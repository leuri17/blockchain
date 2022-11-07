import { Form } from 'rsuite'
import { PropTypes } from 'prop-types'

const FormInput = ({
  id,
  value,
  name,
  placeholder,
  onChange,
  label,
  ...props
}) => {
  return (
    <Form.Group>
      <Form.ControlLabel>{label}</Form.ControlLabel>
      <Form.Control
        id={id}
        value={value}
        name={name}
        placeholder={placeholder}
        onChange={onChange}
        {...props}
      />
    </Form.Group>
  )
}

FormInput.propTypes = {
  id: PropTypes.string,
  value: PropTypes.string,
  name: PropTypes.string,
  label: PropTypes.string,
  placeholder: PropTypes.string,
  onChange: PropTypes.func
}

export default FormInput
