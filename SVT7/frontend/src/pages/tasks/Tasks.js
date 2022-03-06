import React, { useEffect, useState } from "react";
import { useHistory } from "react-router";
import { Col, Container, Row } from "react-bootstrap";
import { TasksService } from "../../services/TasksService";
import { SprintsService } from "../../services/SprintsService";
import TasksTable from "../../components/tasks/TasksTable";
import TasksSearch from "../../components/tasks/TasksSearch";
import AddTask from "../../components/tasks/AddTask";
import { AuthenticationService } from "../../services/AuthenticationService";

const Tasks = () => {
  const [tasks, setTasks] = useState([]);
  const [task, setTask] = useState({
    name: "",
    employee: "",
    points: "",
    sprintId: "",
  });
  const [sprints, setSprints] = useState([]);
  const [showSearch, setShowSearch] = useState(false);
  const [searchInputs, setSearchInputs] = useState({
    taskName: null,
    sprintId: null,
  });
  const [searchOptions, setSearchOptions] = useState({
    page: 0,
    taskName: null,
    sprintId: null,
  });
  const [totalPages, setTotalPages] = useState(null);
  const [sumOfSprintsForTasks, setSumOfSprintsForTasks] = useState(0);
  const [showAlert, setShowAlert] = useState({ success: null, message: "" });

  // useHistory Hook koji vraća history objekat iz React Router-a
  // Koristi se kako bi se izvršilo prebacivanja sa stranice na stranicu - a da to ostane u istorijatu
  const history = useHistory();

  // useEffect Hook koji zavisi od opcija za pretragu
  // Čim se promeni bilo koja opcija - odmah se izvrši i pretraga
  useEffect(() => {
    fetchTasks(searchOptions);
    fetchSprints();
  }, [searchOptions]);

  async function fetchTasks(search) {
    try {
      const response = await TasksService.getTasks(search);
      setTasks(response.data);
      setTotalPages(response.headers["total-pages"]);
      setSumOfSprintsForTasks(response.headers["sprint-total"]);
    } catch (error) {
      console.error(`Greška prilikom dobavljanja zadataka: ${error}`);
    }
  }

  async function fetchSprints() {
    try {
      const response = await SprintsService.getSprints();
      setSprints(response.data);
    } catch (error) {
      console.error(`Greška prilikom dobavljanja sprintova: ${error}`);
    }
  }

  // Postavljanje vrednosti iz search input polja za stavke koje se prikazuju
  // Radzvajanje se izvršava kako pretraga ne bi radila čim korisnik unese karakter
  function search() {
    setSearchOptions({
      ...searchOptions,
      taskName: searchInputs.taskName,
      sprintId: searchInputs.sprintId,
    });
  }

  async function addTask() {
    try {
      await TasksService.addTask(task);

      // Resetovanje polja nakon što je zadatak dodat
      setTask({
        name: "",
        employee: "",
        points: "",
        sprintId: "",
      });

      // Poruka o uspešnom izvršenju
      setShowAlert({ success: true, message: "Zadatak uspešno dodat" });
    } catch (error) {
      // Poruka za developer-e
      console.error(`Greška prilikom dodavanja novog zadataka: ${error}`);

      // Poruka za korisnike
      setShowAlert({
        success: false,
        message: "Greška prilikom dodavanja zadataka",
      });
    }
  }

  async function deleteTask(id) {
    try {
      await TasksService.deleteTask(id);

      // Za novu vrednost liste zadataka uzima se prethodna lista, filtrirana tako da ne sadrži obrisani zatak
      setTasks((tasks) => tasks.filter((task) => task.id !== id));
    } catch (error) {
      console.error(`Greška prilikom brisanja zadataka ${id}: ${error}`);
    }
  }

  // Odlazak na stranicu za ažuriranje izabranog zadatka
  const goToTaskEditPage = (taskId) => {
    history.push("/tasks/edit/" + taskId);
  };

  async function changeTaskState(id) {
    try {
      const response = await TasksService.changeTaskState(id);

      // Za novu vrednost liste zadataka uzimaju se elementi prethodne liste do novog, novi zadatak i preostali stari
      const taskIdxToUpdate = tasks.findIndex((task) => task.id === id);
      setTasks((tasks) => [
        ...tasks.slice(0, taskIdxToUpdate),
        response.data,
        ...tasks.slice(taskIdxToUpdate + 1),
      ]);
    } catch (error) {
      console.error(`Greška prilikom promene stanja zadataka ${id}: ${error}`);
    }
  }

  const handleSearchFormInputChange = (name) => (event) => {
    const val = event.target.value;
    setSearchInputs({ ...searchInputs, [name]: val });
  };

  const handleAddTaskFormInputChange = (name) => (event) => {
    const val = event.target.value;
    setTask({ ...task, [name]: val });
  };

  return (
    <Container>
      <Row>
        <Col md={{ span: 8, offset: 2 }} style={{ textAlign: "center" }}>
          <h1>Tasks</h1>

          {AuthenticationService.getRole() === "ROLE_ADMIN" && (
            <AddTask
              task={task}
              addTaskValueInputChange={handleAddTaskFormInputChange}
              sprints={sprints}
              isTaskValid={TasksService.isTaskValid}
              addTask={addTask}
              showAlert={showAlert}
              setShowAlert={setShowAlert}
            />
          )}

          <TasksSearch
            showSearch={showSearch}
            setShowSearch={setShowSearch}
            taskName={searchInputs.taskName}
            sprintId={searchInputs.sprintId}
            sprints={sprints}
            handleSearchFormInputChange={handleSearchFormInputChange}
            search={search}
          />

          <TasksTable
            tasks={tasks}
            page={searchOptions.page}
            totalPages={totalPages}
            handleSearchPageChange={(page) =>
              setSearchOptions({
                ...searchOptions,
                page: page,
              })
            }
            goToTaskEditPage={goToTaskEditPage}
            deleteTask={deleteTask}
            changeTaskState={changeTaskState}
          />

          <h2 hidden={!sumOfSprintsForTasks || sumOfSprintsForTasks === 0}>
            Suma bodova za sprint je {sumOfSprintsForTasks}
          </h2>
        </Col>
      </Row>
    </Container>
  );
};

export default Tasks;
