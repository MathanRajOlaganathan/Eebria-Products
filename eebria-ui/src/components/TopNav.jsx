import React, { Component } from 'react';
import { Collapse, Navbar, NavbarToggler, NavbarBrand, Nav, NavItem, NavLink } from 'reactstrap';

export class TopNav extends Component {
    constructor(props) {
        super(props);
    
        this.toggle = this.toggle.bind(this);
        this.state = {
          isOpen: false
        };
      }
      toggle() {
        this.setState({
          isOpen: !this.state.isOpen
        });
      }

    render() {
        return (
            <div>
                <Navbar color="faded" light toggleable color="info">
                
                <NavbarToggler right onClick={this.toggle} />
                <h1>Eebria Products</h1>
                    <NavbarBrand href="https://www.eebria.com/" rel="noopener noreferrer" target="_blank">Read More</NavbarBrand>
                    <Collapse isOpen={this.state.isOpen} navbar>
                        <Nav className="ml-auto" navbar>
                            <NavItem>
                                <NavLink href="https://github.com/MathanRajOlaganathan">Github</NavLink>
                            </NavItem>
                        </Nav>
                    </Collapse>
        </Navbar>
            </div>
        )
    }
}

export default TopNav
