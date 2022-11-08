import axios from 'axios'
import { useEffect, useState } from 'react'

const useQuestions = () => {
  const [questions, setQuestions] = useState()

  useEffect(async () => {
    const response = await axios.get('http://localhost:8080/questions')

    setQuestions(response.data)
  }, [])

  return [questions]
}

export { useQuestions }
