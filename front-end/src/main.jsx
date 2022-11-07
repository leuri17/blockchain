import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App'
import './index.css'
import 'rsuite/dist/rsuite.min.css'
// import { CustomProvider } from 'rsuite'
import { BrowserRouter } from 'react-router-dom'

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <BrowserRouter>
      {/* <CustomProvider theme='dark'> */}
        <App />
      {/* </CustomProvider> */}
    </BrowserRouter>
  </React.StrictMode>
)
