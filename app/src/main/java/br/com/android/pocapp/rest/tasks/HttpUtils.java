package br.com.android.pocapp.rest.tasks;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestHandle;
import com.loopj.android.http.RequestParams;

/**
 * Created by guilherme.sanches on 08/08/2017.
 */

public class HttpUtils {
        private static final String BASE_URL = "https://swapi.co/api/";

        private static AsyncHttpClient client = new AsyncHttpClient();


        public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
            client.setEnableRedirects(true);
            client.get(getAbsoluteUrl(url), params, responseHandler);
        }

        public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
            client.post(getAbsoluteUrl(url), params, responseHandler);
        }

        private static String getAbsoluteUrl(String relativeUrl) {
            return BASE_URL + relativeUrl;
        }
}
