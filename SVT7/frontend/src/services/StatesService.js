import SprintsAxiosClient from "./clients/SprintsAxiosClient";

export const StatesService = {
  getStates,
};

async function getStates() {
  return await SprintsAxiosClient.get("states");
}
