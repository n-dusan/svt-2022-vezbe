import React from "react";
import { Alert, Button, Form } from "react-bootstrap";

const AddTask = (props) => (
  <>
    {props.showAlert.success && (
      <Alert
        variant="success"
        onClose={() => props.setShowAlert(null)}
        dismissible
      >
        {props.showAlert.message}
      </Alert>
    )}
    {props.showAlert.success === false && (
      <Alert
        variant="danger"
        onClose={() => props.setShowAlert(null)}
        dismissible
      >
        {props.showAlert.message}
      </Alert>
    )}
    <Form>
      <Form.Group>
        <Form.Label>Name</Form.Label>
        <Form.Control
          onChange={props.addTaskValueInputChange("name")}
          required
          name="name"
          value={props.task.name}
          as="input"
        />
      </Form.Group>
      <Form.Group>
        <Form.Label>Employee</Form.Label>
        <Form.Control
          onChange={props.addTaskValueInputChange("employee")}
          required
          name="employee"
          value={props.task.employee}
          as="input"
        />
      </Form.Group>
      <Form.Group>
        <Form.Label>Points</Form.Label>
        <Form.Control
          onChange={props.addTaskValueInputChange("points")}
          required
          name="points"
          value={props.task.points}
          as="input"
          type="number"
          min="0"
          step="1"
        />
      </Form.Group>
      <Form.Group>
        <Form.Label>Sprint</Form.Label>
        <Form.Control
          onChange={props.addTaskValueInputChange("sprintId")}
          required
          name="sprintId"
          value={props.task.sprintId}
          as="select"
        >
          <option value={""} />
          {props.sprints.map((sprint) => {
            return (
              <option value={sprint.id} key={sprint.id}>
                {sprint.name}
              </option>
            );
          })}
        </Form.Control>
      </Form.Group>
      <Button
        disabled={!props.isTaskValid(props.task)}
        variant="primary"
        onClick={props.addTask}
      >
        Add
      </Button>
    </Form>
  </>
);

export default AddTask;
