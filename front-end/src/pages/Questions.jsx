import axios from 'axios'
import { useEffect, useState } from 'react'
import Questionnaire from '../components/Questionnaire'
import QuestionPlaceholder from '../components/QuestionPlaceholder'

const Questions = () => {
  const [loading, setLoading] = useState(true)
  const [data, setData] = useState([])

  useEffect(() => {
    setLoading(true)
    axios
      .get('http://localhost:8080/questions')
      .then(({ data }) => {
        setLoading(false)
        setData(data)
      })
      .catch(e => {})
  }, [])
  if (loading) {
    return <QuestionPlaceholder />
  }
  return <Questionnaire limit={data.length} questions={data} />
}

export default Questions
