import Util.InputData;
import makequestion.IMakeQuestion;

import java.time.LocalDate;

public class AskQuestion implements IMakeQuestion<String>
{
    private final InputData inputData;

    public AskQuestion(InputData inputData)
    {
        this.inputData = inputData;
    }

    @Override
    public String makeQuestion(String regex, String question)
    {
        return null;
    }
}
