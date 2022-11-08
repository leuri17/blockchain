import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App'
import './index.css'
import 'rsuite/dist/rsuite.min.css'
// import { CustomProvider } from 'rsuite'
import { BrowserRouter } from 'react-router-dom'
import { Provider } from 'react-redux'
import { store } from './store'

ReactDOM.createRoot(document.getElementById('root')).render(
  // <React.StrictMode>
  <Provider store={store}>
    <BrowserRouter>
      {/* <CustomProvider theme='dark'> */}
      <App />
      {/* </CustomProvider> */}
    </BrowserRouter>
  </Provider>
  // </React.StrictMode>
)
