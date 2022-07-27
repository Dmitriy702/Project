package makequestion;

public interface IMakeQuestion<ResultType>
{
     ResultType makeQuestion(String regex, String question);
}
