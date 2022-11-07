import { Panel, FlexboxGrid } from 'rsuite'
import LoginForm from '../components/LoginForm'

const Login = () => {
  return (
    <FlexboxGrid justify='center'>
      <FlexboxGrid.Item colspan={12}>
        <Panel header={<h3>Login</h3>} bordered>
          <LoginForm />
        </Panel>
      </FlexboxGrid.Item>
    </FlexboxGrid>
  )
}

export default Login
