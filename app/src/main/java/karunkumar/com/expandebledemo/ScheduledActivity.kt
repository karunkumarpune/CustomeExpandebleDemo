package karunkumar.com.expandebledemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import karunkumar.com.expandebledemo.R
import karunkumar.com.expandebledemo.SchedulAdapter
import karunkumar.com.expandebledemo.model.Example
import karunkumar.com.expandebledemo.model.Result
import karunkumar.com.expandebledemo.retrofit.APIService
import karunkumar.com.expandebledemo.retrofit.ApiUtils
import retrofit2.Call
import retrofit2.Response
import java.util.*
import javax.security.auth.callback.Callback


class ScheduledActivity : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null
    private var rideAdapter: SchedulAdapter? = null
    private var mAPIService: APIService? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scheduled)
        mAPIService = ApiUtils.getAPIService();
        recyclerView = findViewById(R.id.scheduled_recy)
        val mLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView!!.layoutManager = mLayoutManager
        recyclerView!!.itemAnimator = DefaultItemAnimator()

        initJsonPareses()
    }

    private fun initJsonPareses() {

        mAPIService!!.question.enqueue(object  : Callback, retrofit2.Callback<Example> {

            override fun onResponse(call: Call<Example>?, response: Response<Example>?) {

                if (response!!.isSuccessful()) {
                    val list = response.body().result
                    try {
                        rideAdapter = SchedulAdapter(this@ScheduledActivity, list as ArrayList<Result>)
                        recyclerView!!.setAdapter(rideAdapter)
                    } catch (e: Exception) {
                    }

                }
            }

            override fun onFailure(call: Call<Example>?, t: Throwable?) {
            }


        })
    }
}

/*
        mAPIService.getSchedul(User.getInstance().getAccesstoken()).enqueue(new Callback<OnGoing>() {
            @Override
            public void onResponse(Call<OnGoing> call, Response<OnGoing> response) {
                circularProgressView.setVisibility(View.GONE);
                int status = response.code();

                if (response.isSuccessful()) {
                    List<Responses> list = response.body().getResponses();
                    try {
                        rideAdapter = new SchedulAdapter(ScheduledActivity.this, (ArrayList<Responses>) list);
                        recyclerView.setAdapter(rideAdapter);
                    }catch (Exception e){}

                }
                if (status != 200) {
                    switch (status) {
                        case 422:
                        Toast.makeText(ScheduledActivity.this, message[0], Toast.LENGTH_SHORT).show();
                        break;
                        case 400:
                        Toast.makeText(ScheduledActivity.this, message[0], Toast.LENGTH_SHORT).show();
                        break;
                        case 500:
                        Toast.makeText(ScheduledActivity.this, message[0], Toast.LENGTH_SHORT).show();
                        break;
                        case 201:
                        Toast.makeText(ScheduledActivity.this, getResources().getString(R.string.txt_driver_201), Toast.LENGTH_SHORT).show();
                        break;
                        default:
                        Toast.makeText(ScheduledActivity.this, message[0], Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<OnGoing> call, Throwable t) {
                circularProgressView.setVisibility(View.GONE);
                if (t != null) {
                    Toast.makeText(ScheduledActivity.this, getResources().getString(R.string.txt_Netork_error), Toast.LENGTH_SHORT).show();
                    return;
                }
                Log.e(TAG, "Unable to submit post to API.");
            }
        });
    }*/

