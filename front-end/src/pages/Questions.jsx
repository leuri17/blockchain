/* eslint-disable no-unused-vars */
import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { FlexboxGrid, Pagination /* , Panel */ } from 'rsuite'

const Questions = () => {
  const [activeQuestion, setActiveQuestion] = useState(1)
  // eslint-disable-next-line no-unused-vars
  const [questions, setQuestions] = useState([])

  useEffect(() => {
    axios.get('http://localhost:8080/questions').then(res => {
      console.log(res.data)
      // setQuestions(res.data)
      setActiveQuestion(1)
    })
  }, [])

  return (
    <FlexboxGrid justify='center'>
      <FlexboxGrid.Item colspan={12}>
        {/* <Pagination
          style={{ display: 'block', margin: '0 auto' }}
          prev
          next
          size='sm'
          total={100}
          limit={questions.length}
          activePage={activeQuestion}
          onChangePage={setActiveQuestion}
        /> */}
        {/* <Panel header={<h3>{questions[activeQuestion].question}</h3>}>

        </Panel> */}
      </FlexboxGrid.Item>
    </FlexboxGrid>
  )
}

export default Questions
