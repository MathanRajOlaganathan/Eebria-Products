import React, { Component } from 'react'
import './App.css';
import TopNav from  './components/TopNav';
import EebriaComponent from './components/EebriaComponent';
import Footer from './components/Footer';



export class App extends Component {
  render() {

    return(
      <div className="app">
        <TopNav />
         <EebriaComponent  />
         <Footer />
      </div>
   ); 
  }
}

export default App
