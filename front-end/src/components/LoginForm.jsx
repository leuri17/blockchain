import axios from 'axios'
import { useState } from 'react'
import { useDispatch } from 'react-redux'
import { useNavigate } from 'react-router-dom'
import { Button, Form, Message, Schema, useToaster } from 'rsuite'
import { loginUser } from '../reducers/userReducer'
import FormInput from './FormInput'

const LoginForm = () => {
  const [email, setEmail] = useState('')
  const [password, setPassword] = useState('')
  const dispatch = useDispatch()
  const navigate = useNavigate()
  const toaster = useToaster()

  const model = Schema.Model({
    email: Schema.Types.StringType()
      .isEmail('Please enter a valid email address.')
      .isRequired('This field is required'),
    password: Schema.Types.StringType()
  })

  const handleSubmit = (isValid, event) => {
    if (isValid) {
      axios
        .post('http://localhost:8080/login', { email, password })
        .then(({ data, status }) => {
          if (status === 200) {
            dispatch(loginUser(data.id))
            navigate('/questions')
          }
        })
        .catch(({ response }) => {
          console.log(response)
          toaster.push(
            <Message type='error' showIcon>
              {response.data}
            </Message>
          )
        })
      // TODO Redirect if not answers
    }
  }

  return (
    <Form fluid onSubmit={handleSubmit} model={model}>
      <FormInput
        id='email-input'
        label='Email address'
        name='email'
        value={email}
        onChange={val => {
          setEmail(val)
        }}
      />
      <FormInput
        id='password-input'
        label='Password (optional)'
        name='password'
        type='password'
        value={password}
        onChange={val => {
          setPassword(val)
        }}
      />
      <Button appearance='primary' type='submit'>
        Sign in
      </Button>
    </Form>
  )
}

export default LoginForm
