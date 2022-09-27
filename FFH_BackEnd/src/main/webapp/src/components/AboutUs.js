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
              The purpose of our application is to create a platform which provides an opportunity to the local-area homemakers to start their own Tiffin Services while ensuring the local-area bachelors diminish their hunger on a budget.

              The users of our web-application will need to create an account as a customer to avail Tiffin Services based on the availability of the Homemaker in the respective locality.

              Customers can navigate through different categories of food items as per their choice.

              A payment functionality will be built in to allow the use of credit cards, debit cards or COD for customers.
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
                <img id="img" width="100%" height="100%" src="/Dv.jpg" alt="Avatar" />
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
                <img id="img" width="100%" height="100%" src="/Mh1.jpg" alt="Avatar" />
              </div>
              <div className="flip-card-back">
                <h5 className="mt-2">MOHD HAMMAD</h5>
                <p className="mb-2 text-muted">Business Partner</p>
                <p>Phone: +91-8447109979</p>
                <p>Email: mh.hammad@gmail.com</p>
              </div>
            </div>
          </div>

          {/* Third Card */}
          {/* <div className="fluid-container flip-card col-4 my-2">
            <div className="flip-card-inner">
              <div className="flip-card-front">
                <img id="img" width="100%" height="100%" src="https://media-exp1.licdn.com/dms/image/C4E03AQGW9wgETyi4pA/profile-displayphoto-shrink_800_800/0/1616747268647?e=1622073600&v=beta&t=JyYiogFuGqQF45A49Rh5gsE9c7yxX3ydqzIH8qcNIE8" alt="Avatar" />
              </div>
              <div className="flip-card-back">
                <h5 className="mt-2">AKHLESH GOUR</h5>
                <p className="mb-2 text-muted">Business Partner</p>
                <p>Phone: +91-9907220333</p>
                <p>Email: akhlesh95@gmailcom</p>
              </div>
            </div>
          </div> */}

          {/* Fourth Card */}
          {/* <div className="fluid-container flip-card col-4 my-2">
            <div className="flip-card-inner">
              <div className="flip-card-front">
                <img id="img" width="100%" height="100%" src="https://media-exp1.licdn.com/dms/image/C4E03AQELewH9OBKB8A/profile-displayphoto-shrink_800_800/0/1616395564920?e=1622073600&v=beta&t=nfMZtrYkb5xgl0uRBmMfdrfMxMfHzu9iW49yRR_wqmY" alt="Avatar" />
              </div>
              <div className="flip-card-back">
                <h5 className="mt-2">ANAND SRIVASTAVA</h5>
                <p className="mb-2 text-muted">Business Partner</p>
                <p>Phone: +91-7723005159</p>
                <p>Email: anandshrivastava0007@gmailcom</p>
              </div>
            </div>
          </div> */}
          {/* Fifth Card */}
          {/* <div className="fluid-container flip-card col-4 my-2">
            <div className="flip-card-inner">
              <div className="flip-card-front">
                <img id="img" width="100%" height="100%" src="https://media-exp1.licdn.com/dms/image/C5103AQGVSMX-6-uPyQ/profile-displayphoto-shrink_800_800/0/1542785912198?e=1622073600&v=beta&t=wrM_R1CjgHBlAo50UnVFYR7qcY3uBPP7ArRIAc5epRs" alt="Avatar" />
              </div>
              <div className="flip-card-back">
                <h5 className="mt-2">PRASAD TULAPURKAR</h5>
                <p className="mb-2 text-muted">Business Partner</p>
                <p>Phone: +91-9617641186</p>
                <p>Email: prasadtulapurkar95@gmail.com</p>
              </div>
            </div>
          </div> */}
        </div>
      </Jumbotron>
    </div>
  )
}
export default AboutUs