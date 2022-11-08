/* eslint-disable multiline-ternary */
import { useDispatch, useSelector } from 'react-redux'
import { Panel, FlexboxGrid, Button } from 'rsuite'
import LoginForm from '../components/LoginForm'
import { logoutUser } from '../reducers/userReducer'

const Login = () => {
  const user = useSelector(state => state.user)
  const dispatch = useDispatch()

  return (
    <FlexboxGrid justify='center'>
      <FlexboxGrid.Item colspan={12}>
        <Panel header={<h3>Login</h3>} bordered>
          {user ? (
            <Button
              onClick={() => {
                dispatch(logoutUser())
              }}
            >
              Logout
            </Button>
          ) : (
            <LoginForm />
          )}
          {/* <LoginForm /> */}
        </Panel>
      </FlexboxGrid.Item>
    </FlexboxGrid>
  )
}

export default Login
