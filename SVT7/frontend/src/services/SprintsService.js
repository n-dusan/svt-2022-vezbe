import SprintsAxiosClient from "./clients/SprintsAxiosClient";

export const SprintsService = {
  getSprints,
};

async function getSprints() {
  return await SprintsAxiosClient.get("sprints");
}
