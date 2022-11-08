import { useEffect, useState } from 'react'
import { PropTypes } from 'prop-types'
import {
  Button,
  FlexboxGrid,
  Form,
  Message,
  Pagination,
  Panel,
  useToaster
} from 'rsuite'
import QuestionItem from './QuestionItem'
import { useSelector } from 'react-redux'
import { useNavigate } from 'react-router-dom'
import axios from 'axios'

const Questionnaire = ({ limit, questions, ...props }) => {
  const [activeQuestion, setActiveQuestion] = useState(1)
  const user = useSelector(state => state.user)
  const navigate = useNavigate()
  const toaster = useToaster()

  useEffect(() => {
    if (user === null) {
      navigate('/login')
    }
  }, [])

  const handleSubmit = (isValid, event) => {
    const checkedRadio = Object.values(event.target).find(item =>
      item.checked ? item : null
    )

    if (!checkedRadio) {
      toaster.push(
        <Message type='error' showIcon>
          You must select a choice
        </Message>
      )
    } else {
      axios
        .post('http://localhost:8080/answer', {
          answer_id: checkedRadio.value,
          user_id: user
        })
        .then(res => {
          console.log(res.data)
        })

      if (activeQuestion < 4) {
        setActiveQuestion(activeQuestion + 1)
      }
    }
  }

  return (
    <FlexboxGrid justify='center'>
      <FlexboxGrid.Item colspan={24}>
        <Pagination
          style={{ display: 'block', margin: '0 auto', marginBottom: '30px' }}
          // prev
          // next
          disabled
          size='sm'
          total={limit}
          limit={1}
          activePage={activeQuestion}
          onChangePage={setActiveQuestion}
        />
      </FlexboxGrid.Item>
      <FlexboxGrid.Item colspan={12}>
        <Panel header={questions[activeQuestion - 1].question} bordered>
          <Form onSubmit={handleSubmit} fluid>
            <Form.Group controlId={questions[activeQuestion - 1].id}>
              <QuestionItem
                answers={questions[activeQuestion - 1].answers}
                question={questions[activeQuestion - 1]}
              />
            </Form.Group>
            <Button appearance='primary' type='submit'>
              Next {'>'}
            </Button>
          </Form>
        </Panel>
      </FlexboxGrid.Item>
    </FlexboxGrid>
  )
}

Questionnaire.propTypes = {
  limit: PropTypes.number,
  questions: PropTypes.array
}

export default Questionnaire
