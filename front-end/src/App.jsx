import './App.css'
import { Navigate, Route, Routes } from 'react-router-dom'
import Layout from './pages/Layout'
import Login from './pages/Login'
import Questions from './pages/Questions'

const App = () => (
  <div className=''>
    <Routes>
      <Route path='/' element={<Layout />}>
        <Route index element={<Navigate to='/login' />} />
        <Route path='login' element={<Login />} />
        <Route path='questions' element={<Questions />} />
      </Route>
    </Routes>
  </div>
)

export default App
