import React, { useEffect } from "react"
import { Jumbotron, Card, CardImg, CardText, CardImgOverlay } from "reactstrap"
const AboutUs = () => {
  useEffect(() => {
    document.title = "About Us || FFH"
  }, [])
  return (
    <div>
      <Jumbotron style={{ backgroundColor: '#333' }} className="text-center">
        <h2 style={{ color: 'white' }}>-: ABOUT US :-</h2>
        <br />
        <br />
        <Card inverse>
          <CardImg width="100%" src="https://cdn.pixabay.com/photo/2014/06/11/17/00/food-366875_1280.jpg" alt="Card image cap" />
          <CardImgOverlay>
            {/* <CardTitle tag="h1">About Us</CardTitle> */}
            <CardText tag="h4">
              The purpose of our application is to create a platform which provides an opportunity to the local-area homemakers to start their own Tiffin Services to ensure that the people can satisfy their hunger within budget.

              The users of our web-application require to create an account as a customer to avail Tiffin Services based on the availability of the Homemaker in their respective locality.

              Customers can navigate through different categories of food items as per their choice.

              A payment functionality is there to allow the use of credit cards, debit cards or COD for customers.
            </CardText>
          </CardImgOverlay>
        </Card>
        <br />
        <br />
        <p style={{ color: 'white' }}> -----------------------------------------------------------------------------------------------------------------------------------------------------------------</p>
        < br />
        <h2 style={{ color: 'white' }}>-: CONTACT US :-</h2>
        <br />

        <div className="fluid-container row">
          {/* First Card */}
          <div className="fluid-container flip-card col-4 my-2">
            <div className="flip-card-inner">
              <div className="flip-card-front">
                <img id="img" width="100%" height="100%" src="/Dv.png" alt="Avatar" />
              </div>
              <div className="flip-card-back">
                <h5 className="mt-2">DEEPALI VYAS</h5>
                <p className="mb-2 text-muted">Business Partner</p>
                <p>Phone: +91-7772851335</p>
                <p>Email: deepalivyas@gmail.com</p>
              </div>
            </div>
          </div>
          {/* Second Card */}
          <div className="fluid-container flip-card col-4 my-2">
            <div className="flip-card-inner">
              <div className="flip-card-front">
                <img id="img" width="100%" height="100%" src="/Mh.jpg" alt="Avatar" />
              </div>
              <div className="flip-card-back">
                <h5 className="mt-2">MOHD HAMMAD</h5>
                <p className="mb-2 text-muted">Business Partner</p>
                <p>Phone: +91-8447109979</p>
                <p>Email: mh.hammad@gmail.com</p>
              </div>
            </div>
          </div>

          
        </div>
      </Jumbotron>
    </div>
  )
}
export default AboutUs