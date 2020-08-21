import React, { Component } from 'react'
import EebriaService from '../services/EebriaService';
import  ProductCard  from './ProductCard';
import {Col, Row, Container } from 'reactstrap';



export class EebriaComponent extends Component {


    constructor(props){
        super(props)
        this.state={
            products:[]
        }
    }
    
    
    componentDidMount(){
    
        EebriaService.getProducts().then((response)=>{
            this.setState({products:response.data})
        });
    
    }
    
    render(){
            let productCards = this.state.products.map(product => {
                return (
                  <Col md="2">
                    <ProductCard key={product.name}  product={product} />
                  </Col>
                )
              })
              return (
                <Container fluid>
                  <Row>
                    {productCards}
                  </Row>
                </Container>
            
        )
    }

    
}

export default EebriaComponent;
