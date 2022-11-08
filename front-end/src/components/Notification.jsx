import { Message } from 'rsuite'
import { PropTypes } from 'prop-types'

const Notification = ({ type, message, ...props }) => {
  return (
    <Message type={type} showIcon {...props}>
      {message}
    </Message>
  )
}

Notification.propTypes = {
  type: PropTypes.string,
  message: PropTypes.string
}

export default Notification
