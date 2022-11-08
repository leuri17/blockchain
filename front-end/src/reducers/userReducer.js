import { createAction, createReducer } from '@reduxjs/toolkit'

const initialState = null

// const userReducer = createReducer(initialState, {
//   '@USER/login': (state, action) => action.payload
// })

const login = createAction('@USER/login')
const logout = createAction('@USER/logout')

const userReducer = createReducer(initialState, builder => {
  builder
    .addCase(login, (state, action) => action.payload)
    .addCase(logout, (state, action) => initialState)
})

const loginUser = payload => {
  return {
    type: '@USER/login',
    payload
  }
}

const logoutUser = () => {
  return {
    type: '@USER/logout',
    payload: initialState
  }
}

export { userReducer, loginUser, logoutUser }
