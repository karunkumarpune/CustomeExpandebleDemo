package karunkumar.com.expandebledemo.retrofit;

import karunkumar.com.expandebledemo.model.Example;
import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    //https://raw.githubusercontent.com/karunkumarpune/Expandeble/master/question_test.json

    //https://code.tutsplus.com/tutorials/sending-data-with-retrofit-2-http-client-for-android--cms-27845

   // http://www.androidhub4you.com/p/blog-page_27.html

    @GET("/karunkumarpune/Expandeble/master/question_test.json")
    Call<Example> getQuestion();
}