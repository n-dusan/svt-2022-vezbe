import SprintsAxiosClient from "./clients/SprintsAxiosClient";

export const TasksService = {
  getTasks,
  getTask,
  isTaskValid,
  addTask,
  editTask,
  deleteTask,
  changeTaskState,
};

async function getTasks(searchOptions) {
  const config = {
    params: {
      pageNo: searchOptions.page,
      taskName: searchOptions.taskName,
      sprintId: searchOptions.sprintId,
    },
  };
  return await SprintsAxiosClient.get("tasks", config);
}

async function getTask(id) {
  return await SprintsAxiosClient.get(`tasks/${id}`);
}

async function editTask(id, task) {
  return await SprintsAxiosClient.put(`tasks/${id}`, task);
}

async function deleteTask(id) {
  return await SprintsAxiosClient.delete(`tasks/${id}`);
}

async function changeTaskState(id) {
  return await SprintsAxiosClient.post(`tasks/${id}/change_state`);
}

function isTaskValid(task) {
  return (
    task.name !== "" &&
    task.points !== "" &&
    task.points >= 0 &&
    task.points <= 20 &&
    task.points % 1 === 0 &&
    task.sprintId !== ""
  );
}

async function addTask(task) {
  return await SprintsAxiosClient.post("tasks", task);
}
