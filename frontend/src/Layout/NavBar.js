import React, { useState, useEffect } from "react";
import {
  Menu,
  Container,
  Button,
  Icon,
  Image
} from "semantic-ui-react";

// The Navbar component as a functional component
const NavBar = () => {
  return (
    <Menu fixed="top" inverted >

      <Container style={{ height: "70px" }}>
      <Menu.Item>
      {/* tried to add an image for the navbar */}
      {/* <Image
            size="mini"
            circular
            src="https://www.freepik.com/vectors/money"
            style={{ marginRight: "1.5em" }}
          /> */}
        <a href="#"> About </a>
      </Menu.Item>
      <Menu.Item>
        <a href="#">Apply for a loan</a>
      </Menu.Item>
    
      <Menu.Item position="right">
        <Button as="a" href="/login">
          Log in
        </Button>
        <Button as="a" style={{ marginLeft: "0.5em" }} href="/register">
          Sign Up
        </Button>
      </Menu.Item>
      </Container>
    </Menu>
  );
};

export default NavBar;