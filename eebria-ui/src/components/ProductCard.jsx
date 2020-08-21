import React, { Component } from 'react'
import {
    Container,Row,  Col, Card, CardImg, CardText, CardBody, CardBlock,
    CardTitle, CardSubtitle, Button
} from 'reactstrap';

export class Productard extends Component {
    constructor(props){
        super(props)
    }

    render() {
        let { name, image, style, price } = this.props.product;
        return (
            <div className="container-fluid d-flex justify-content-center">
                <div className="col-md-8">
                <div className=" text-center">
                    <div className="overflow">
                        <img src={image} className="card-img-top"/>
                    </div>
                    <div className="card-body text-dark">
                        <h4 className="card-title">{name}</h4>
                        <h4 className="card-text">{style}</h4>
                        <h4 className="card-text currSign">{price}</h4>
                    </div>
                </div>
                </div>


            </div>
        )
    }
}

export default Productard
