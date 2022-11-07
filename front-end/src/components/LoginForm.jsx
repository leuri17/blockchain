import { useState } from 'react'
import { Button, Form, Schema } from 'rsuite'
import FormInput from './FormInput'

const LoginForm = () => {
  const [email, setEmail] = useState('')
  const [password, setPassword] = useState('')

  const model = Schema.Model({
    email: Schema.Types.StringType()
      .isEmail('Please enter a valid email address.')
      .isRequired('This field is required'),
    password: Schema.Types.StringType()
  })

  const handleSubmit = (isValid, event) => {
    console.log(isValid)
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
        label='Password'
        name='password'
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
