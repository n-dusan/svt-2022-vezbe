import React from "react";
import { Button, Collapse, Form } from "react-bootstrap";

const TasksSearch = (props) => (
  <>
    <Form.Group style={{ marginTop: 35 }}>
      <Form.Check
        type="checkbox"
        label="Show search form"
        value={props.showSearch}
        onClick={() => props.setShowSearch(!props.showSearch)}
      />
    </Form.Group>
    <Collapse in={props.showSearch}>
      <Form
        onSubmit={(e) => {
          e.preventDefault();
          props.search();
        }}
        style={{ marginTop: 10 }}
      >
        <Form.Group>
          <Form.Label>Ime zadatka</Form.Label>
          <Form.Control
            type="text"
            name="taskName"
            as="input"
            value={props.taskName ? props.taskName : ""}
            onChange={props.handleSearchFormInputChange("taskName")}
          />
        </Form.Group>
        <Form.Group>
          <Form.Label>Sprint</Form.Label>
          <Form.Control
            type="text"
            name="sprintId"
            as="select"
            value={props.sprintId ? props.sprintId : ""}
            onChange={props.handleSearchFormInputChange("sprintId")}
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
          onClick={(e) => {
            e.preventDefault();
            props.search();
          }}
        >
          Search
        </Button>
      </Form>
    </Collapse>
  </>
);

export default TasksSearch;
