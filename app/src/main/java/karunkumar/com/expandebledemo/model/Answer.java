package karunkumar.com.expandebledemo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Answer {

@SerializedName("option")
@Expose
private String option;

public String getOption() {
return option;
}

public void setOption(String option) {
this.option = option;
}

}