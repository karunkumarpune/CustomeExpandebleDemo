package karunkumar.com.expandebledemo.retrofit;


public class ApiUtils {
    private ApiUtils() {}
    public static APIService getAPIService() {
 
        return RetrofitClient.getClient("https://raw.githubusercontent.com").create(APIService.class);
    }
}