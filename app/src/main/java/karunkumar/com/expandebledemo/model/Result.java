package karunkumar.com.expandebledemo.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

@SerializedName("question_title")
@Expose
private String questionTitle;
@SerializedName("answer")
@Expose
private List<Answer> answer = null;

public String getQuestionTitle() {
return questionTitle;
}

public void setQuestionTitle(String questionTitle) {
this.questionTitle = questionTitle;
}

public List<Answer> getAnswer() {
return answer;
}

public void setAnswer(List<Answer> answer) {
this.answer = answer;
}

}