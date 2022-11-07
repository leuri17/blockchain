import {
  Container,
  Content,
  CustomProvider,
  Footer,
  Header,
  Toggle
} from 'rsuite'
import { Outlet } from 'react-router-dom'
import { useState } from 'react'

const Layout = () => {
  const [darkTheme, setDarkTheme] = useState(true)

  return (
    <Container id='app'>
      <Header>
        <h1 style={{ display: 'inline-block' }}>
          BlockChain
          <Toggle
            style={{ marginLeft: '10px' }}
            checked={darkTheme}
            onChange={checked => {
              setDarkTheme(checked)
            }}
            checkedChildren='Dark'
            unCheckedChildren='Light'
          />
        </h1>
      </Header>
      <Content>
        <CustomProvider theme={darkTheme ? 'dark' : 'light'}>
          <Outlet />
        </CustomProvider>
      </Content>
      <Footer>BlockChain App by Leuri Alonso & Fernando Girón &copy;</Footer>
    </Container>
  )
}

export default Layout
