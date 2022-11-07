import React, { useEffect, useState } from 'react'
import { FlexboxGrid, Pagination/* , Panel */ } from 'rsuite'

const Questions = () => {
  const [activeQuestion, setActiveQuestion] = useState(1)
  const [questions, setQuestions] = useState([])

  useEffect(() => {
    setQuestions([])
    /**
     * axios.get(/questions)
     * * .then(res => {
     * * * setQuestions(res.data)
     * * * setActiveQuestion(1)
     *  *})
     */
  }, [])

  return (
    <FlexboxGrid justify='center'>
      <FlexboxGrid.Item colspan={12}>
        <Pagination
          style={{ display: 'block', margin: '0 auto' }}
          prev
          next
          size='sm'
          total={100}
          limit={questions.length}
          activePage={activeQuestion}
          onChangePage={setActiveQuestion}
        />
        {/* <Panel header={<h3>{questions[activeQuestion].question}</h3>}>

        </Panel> */}
      </FlexboxGrid.Item>
    </FlexboxGrid>
  )
}

export default Questions
