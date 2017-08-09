package br.com.android.pocapp.rest.tasks;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestHandle;
import com.loopj.android.http.RequestParams;

/**
 * Created by guilherme.sanches on 08/08/2017.
 */

public class HttpUtils {

    /**
     * BASE_URL to api rest of StarWars
     */
    private static final String BASE_URL = "https://swapi.co/api/";

    /**
     * Instance of client AsyncHttpClient
     */
    private static AsyncHttpClient client = new AsyncHttpClient();

    /**
     * Method get generic in client http
     * @param url
     * @param params
     * @param responseHandler
     */
    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.setEnableRedirects(true);
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    /**
     * Build url with resources in param
     * @param relativeUrl
     * @return
     */
    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }
}
