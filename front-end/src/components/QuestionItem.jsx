import { FlexboxGrid, Radio, RadioGroup } from 'rsuite'
import { PropTypes } from 'prop-types'

const QuestionItem = ({ answers, question }) => {
  return (
    <RadioGroup name={question.id}>
      <FlexboxGrid>
        {answers.map(answer => (
          <FlexboxGrid.Item key={answer.id} colspan={12}>
            <Radio value={answer.id}>{answer.answer}</Radio>
          </FlexboxGrid.Item>
        ))}
      </FlexboxGrid>
    </RadioGroup>
  )
}

QuestionItem.propTypes = {
  answers: PropTypes.array,
  question: PropTypes.object,
  key: PropTypes.string
}

export default QuestionItem
