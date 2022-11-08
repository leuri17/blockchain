import { FlexboxGrid, Loader, Panel, Placeholder } from 'rsuite'

const QuestionPlaceholder = () => {
  return (
    <FlexboxGrid justify='center'>
      <FlexboxGrid.Item colspan={12}>
        <Panel bordered>
          <Placeholder.Paragraph/>
          <Loader style={{ marginTop: '10px', marginBottom: '10px' }} />
          <Placeholder.Paragraph />
        </Panel>
      </FlexboxGrid.Item>
    </FlexboxGrid>
  )
}

export default QuestionPlaceholder
