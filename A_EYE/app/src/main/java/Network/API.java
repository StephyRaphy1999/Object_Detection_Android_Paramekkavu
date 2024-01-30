package Network;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface API {
    @POST(ApiClientCustom.APPEND_URL + "blind")
    Call<JsonObject> blind(@Body JsonObject object);
    @POST(ApiClientCustom.APPEND_URL + "caretaker")
    Call<JsonObject> caretaker(@Body JsonObject object);
    @POST(ApiClientCustom.APPEND_URL + "signin")
    Call<JsonObject> signin(@Body JsonObject object);
    @POST(ApiClientCustom.APPEND_URL + "reqBlind")
    Call<JsonObject> reqBlind(@Body JsonObject object);
    @POST(ApiClientCustom.APPEND_URL + "reqCaretaker")
    Call<JsonObject> reqCaretaker(@Body JsonObject object);
    @POST(ApiClientCustom.APPEND_URL + "accept")
    Call<JsonObject> accept(@Body JsonObject object);
    @POST(ApiClientCustom.APPEND_URL + "reject")
    Call<JsonObject> reject(@Body JsonObject object);
    @POST(ApiClientCustom.APPEND_URL + "assign")
    Call<JsonObject> assign(@Body JsonObject object);
    @POST(ApiClientCustom.APPEND_URL + "assignView")
    Call<JsonObject> assignView(@Body JsonObject object);
    @POST(ApiClientCustom.APPEND_URL + "approvedBlind")
    Call<JsonObject> approvedBlind(@Body JsonObject object);
    @POST(ApiClientCustom.APPEND_URL + "approvedCaretaker")
    Call<JsonObject> approvedCaretaker(@Body JsonObject object);
    @POST(ApiClientCustom.APPEND_URL + "rejectedBLind")
    Call<JsonObject> rejectedBlind(@Body JsonObject object);
    @POST(ApiClientCustom.APPEND_URL + "profile")
    Call<JsonObject> profile(@Body JsonObject object);









}
