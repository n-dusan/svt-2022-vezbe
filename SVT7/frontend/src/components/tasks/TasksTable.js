import React from "react";
import { Button, ButtonGroup, Table } from "react-bootstrap";
import { AuthenticationService } from "../../services/AuthenticationService";

const TasksTable = (props) => (
  <>
    <Table bordered striped style={{ marginTop: 5 }}>
      <thead className="thead-dark">
        <tr>
          <th>Name</th>
          <th>Employees</th>
          <th>Points</th>
          <th>State</th>
          <th>Sprint</th>
          <th colSpan={2}>Actions</th>
        </tr>
      </thead>
      <tbody>
        {props.tasks.map((task) => {
          return (
            <tr key={task.id}>
              <td>{task.name}</td>
              <td>{task.employee}</td>
              <td>{task.points}</td>
              <td>{task.stateName}</td>
              <td>{task.sprintName}</td>
              <td>
                <Button
                  disabled={task.stateId === 3} // Finished
                  variant="info"
                  block
                  onClick={() => props.changeTaskState(task.id)}
                >
                  Change State
                </Button>
                {AuthenticationService.getRole() === "ROLE_ADMIN" && (
                  <>
                    <Button
                      variant="warning"
                      block
                      onClick={() => props.goToTaskEditPage(task.id)}
                    >
                      Edit
                    </Button>
                    <Button
                      variant="danger"
                      block
                      onClick={() => props.deleteTask(task.id)}
                    >
                      Delete
                    </Button>
                  </>
                )}
              </td>
            </tr>
          );
        })}
      </tbody>
    </Table>
    <ButtonGroup style={{ marginBottom: 25 }}>
      <Button
        style={{ margin: 3, width: 90 }}
        disabled={props.page === 0}
        onClick={() => props.handleSearchPageChange(props.page - 1)}
      >
        Previous
      </Button>
      <Button
        style={{ margin: 3, width: 90 }}
        disabled={props.page >= props.totalPages - 1}
        onClick={() => props.handleSearchPageChange(props.page + 1)}
      >
        Next
      </Button>
    </ButtonGroup>
  </>
);

export default TasksTable;
