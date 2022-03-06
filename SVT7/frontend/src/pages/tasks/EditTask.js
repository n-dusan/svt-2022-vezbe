import React, { useEffect, useState } from "react";
import { Alert, Button, Form } from "react-bootstrap";
import { SprintsService } from "../../services/SprintsService";
import { StatesService } from "../../services/StatesService";
import { useParams } from "react-router";
import { TasksService } from "../../services/TasksService";

const EditTask = () => {
  const [task, setTask] = useState({
    name: "",
    employee: "",
    points: "",
    stateId: "",
    sprintId: "",
  });
  const [taskStates, setTaskStates] = useState([]);
  const [sprints, setSprints] = useState([]);
  const [showSuccessAlert, setShowSuccessAlert] = useState(false);

  // useParams Hook iz React Routera - preko nje je moguće dobiti paramet koji se zahteva na ruti, poput ID-ja
  const { id } = useParams();

  useEffect(() => {
    fetchTask(id);
    fetchSprints();
    fetchStates();
  }, [id]);

  async function fetchTask(id) {
    try {
      const response = await TasksService.getTask(id);
      setTask(response.data);
    } catch (error) {
      console.error(`Greška prilikom dobavljanja zadataka ${id}: ${error}`);
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

  async function fetchStates() {
    try {
      const response = await StatesService.getStates();
      setTaskStates(response.data);
    } catch (error) {
      console.error(`Greška prilikom dobavljanja stanja zadataka: ${error}`);
    }
  }

  async function editTask() {
    try {
      await TasksService.editTask(id, task);
      setShowSuccessAlert(true);
    } catch (error) {
      console.error(`Greška prilikom аžuriranja stanja zadataka: ${error}`);
    }
  }

  const handleFormInputChange = (name) => (event) => {
    const val = event.target.value;
    setTask({ ...task, [name]: val });
  };

  return (
    <>
      {showSuccessAlert && (
        <Alert
          variant="success"
          onClose={() => setShowSuccessAlert(false)}
          dismissible
        >
          Zadatak uspešno ažuriran!
        </Alert>
      )}
      <h1>Task</h1>
      <Form>
        <Form.Group>
          <Form.Label>Name</Form.Label>
          <Form.Control
            onChange={handleFormInputChange("name")}
            name="name"
            value={task.name}
            as="input"
          />
        </Form.Group>
        <Form.Group>
          <Form.Label>Employee</Form.Label>
          <Form.Control
            onChange={handleFormInputChange("employee")}
            name="employee"
            value={task.employee}
            as="input"
          />
        </Form.Group>
        <Form.Group>
          <Form.Label>Bodovi</Form.Label>
          <Form.Control
            onChange={handleFormInputChange("points")}
            name="points"
            value={task.points}
            as="input"
          />
        </Form.Group>
        <Form.Group>
          <Form.Label>State</Form.Label>
          <Form.Control
            onChange={handleFormInputChange("stateId")}
            name="stateId"
            value={task.stateId}
            as="select"
          >
            <option value={""} />
            {taskStates.map((state) => {
              return (
                <option value={state.id} key={state.id}>
                  {state.name}
                </option>
              );
            })}
          </Form.Control>
        </Form.Group>
        <Form.Group>
          <Form.Label>Sprint</Form.Label>
          <Form.Control
            onChange={handleFormInputChange("sprintId")}
            name="sprintId"
            value={task.sprintId}
            as="select"
          >
            <option value={""} />
            {sprints.map((sprint) => {
              return (
                <option value={sprint.id} key={sprint.id}>
                  {sprint.name}
                </option>
              );
            })}
          </Form.Control>
        </Form.Group>
        <Button variant="primary" onClick={() => editTask()}>
          Edit
        </Button>
      </Form>
    </>
  );
};

export default EditTask;
