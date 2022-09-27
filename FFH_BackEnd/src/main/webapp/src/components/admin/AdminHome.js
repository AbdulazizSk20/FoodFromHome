import React, { useEffect, useState } from "react"
import { Jumbotron } from "reactstrap"
import {
  Card, CardImg, CardTitle, CardDeck,
  CardSubtitle, CardBody, Media
} from 'reactstrap';
import SessionService from "../../service/SessionService";


const AdminHome = () => {

  const [user] = useState(SessionService.getCurrentUser)

  useEffect(() => {
    document.title = "Admin || Home"
  }, [])

  return (
    <div>
      <Jumbotron style={{ background: 'darkgray' }} className="text-center">
        <Media>
          <Media left>
            <Media src="https://icons.iconarchive.com/icons/double-j-design/origami-colored-pencil/128/blue-user-icon.png" alt="Generic placeholder image" />
          </Media>
          <Media body>
            <Media heading>
              <h2 >Welcome {user.name}</h2>
            </Media>
          </Media>
        </Media>
        <br />
        <CardDeck>
          <Card>
            <CardImg top height="200px" width="300px" src="https://icons.iconarchive.com/icons/dtafalonso/android-lollipop/512/Gmail-icon.png" alt="Card image cap" />
            <CardBody>
              <CardTitle tag="h5">EMAIL ADDRESS</CardTitle>
              <CardSubtitle tag="h6" className="mb-2 text-muted">{user.email}</CardSubtitle>
            </CardBody>
          </Card>
          <Card>
            <CardImg top height="200px" width="300px" src="https://icons.iconarchive.com/icons/dtafalonso/android-lollipop/512/Phone-icon.png" alt="Card image cap" />
            <CardBody>
              <CardTitle tag="h5">PHONE NUMBER</CardTitle>
              <CardSubtitle tag="h6" className="mb-2 text-muted">{user.phoneNo}</CardSubtitle>
            </CardBody>
          </Card>
        </CardDeck>
      </Jumbotron>
    </div>
  )
}
export default AdminHome