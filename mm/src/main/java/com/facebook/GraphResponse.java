package com.facebook;

import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class GraphResponse {
    private static final String BODY_KEY = "body";
    private static final String CODE_KEY = "code";
    public static final String NON_JSON_RESPONSE_PROPERTY = "FACEBOOK_NON_JSON_RESULT";
    private static final String RESPONSE_LOG_TAG = "Response";
    public static final String SUCCESS_KEY = "success";
    private static final String TAG = GraphResponse.class.getSimpleName();
    private final HttpURLConnection connection;
    private final FacebookRequestError error;
    private final JSONObject graphObject;
    private final JSONArray graphObjectArray;
    private final String rawResponse;
    private final GraphRequest request;

    static {
        AppMethodBeat.i(17206);
        AppMethodBeat.o(17206);
    }

    GraphResponse(GraphRequest graphRequest, HttpURLConnection httpURLConnection, String str, JSONObject jSONObject) {
        this(graphRequest, httpURLConnection, str, jSONObject, null, null);
    }

    GraphResponse(GraphRequest graphRequest, HttpURLConnection httpURLConnection, String str, JSONArray jSONArray) {
        this(graphRequest, httpURLConnection, str, null, jSONArray, null);
    }

    GraphResponse(GraphRequest graphRequest, HttpURLConnection httpURLConnection, FacebookRequestError facebookRequestError) {
        this(graphRequest, httpURLConnection, null, null, null, facebookRequestError);
    }

    GraphResponse(GraphRequest graphRequest, HttpURLConnection httpURLConnection, String str, JSONObject jSONObject, JSONArray jSONArray, FacebookRequestError facebookRequestError) {
        this.request = graphRequest;
        this.connection = httpURLConnection;
        this.rawResponse = str;
        this.graphObject = jSONObject;
        this.graphObjectArray = jSONArray;
        this.error = facebookRequestError;
    }

    public final FacebookRequestError getError() {
        return this.error;
    }

    public final JSONObject getJSONObject() {
        return this.graphObject;
    }

    public final JSONArray getJSONArray() {
        return this.graphObjectArray;
    }

    public final HttpURLConnection getConnection() {
        return this.connection;
    }

    public GraphRequest getRequest() {
        return this.request;
    }

    public String getRawResponse() {
        return this.rawResponse;
    }

    public enum PagingDirection {
        NEXT,
        PREVIOUS;

        public static PagingDirection valueOf(String str) {
            AppMethodBeat.i(17196);
            PagingDirection pagingDirection = (PagingDirection) Enum.valueOf(PagingDirection.class, str);
            AppMethodBeat.o(17196);
            return pagingDirection;
        }

        static {
            AppMethodBeat.i(17197);
            AppMethodBeat.o(17197);
        }
    }

    public GraphRequest getRequestForPagedResults(PagingDirection pagingDirection) {
        String str;
        JSONObject optJSONObject;
        AppMethodBeat.i(17198);
        if (this.graphObject == null || (optJSONObject = this.graphObject.optJSONObject("paging")) == null) {
            str = null;
        } else if (pagingDirection == PagingDirection.NEXT) {
            str = optJSONObject.optString("next");
        } else {
            str = optJSONObject.optString("previous");
        }
        if (Utility.isNullOrEmpty(str)) {
            AppMethodBeat.o(17198);
            return null;
        } else if (str == null || !str.equals(this.request.getUrlForSingleRequest())) {
            try {
                GraphRequest graphRequest = new GraphRequest(this.request.getAccessToken(), new URL(str));
                AppMethodBeat.o(17198);
                return graphRequest;
            } catch (MalformedURLException e2) {
                AppMethodBeat.o(17198);
                return null;
            }
        } else {
            AppMethodBeat.o(17198);
            return null;
        }
    }

    public String toString() {
        String str;
        AppMethodBeat.i(17199);
        try {
            Locale locale = Locale.US;
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(this.connection != null ? this.connection.getResponseCode() : 200);
            str = String.format(locale, "%d", objArr);
        } catch (IOException e2) {
            str = "unknown";
        }
        String str2 = "{Response:  responseCode: " + str + ", graphObject: " + this.graphObject + ", error: " + this.error + "}";
        AppMethodBeat.o(17199);
        return str2;
    }

    static List<GraphResponse> fromHttpConnection(HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) {
        InputStream inputStream;
        AppMethodBeat.i(17200);
        Closeable closeable = null;
        try {
            if (httpURLConnection.getResponseCode() >= 400) {
                inputStream = httpURLConnection.getErrorStream();
            } else {
                inputStream = httpURLConnection.getInputStream();
            }
            return createResponsesFromStream(closeable, httpURLConnection, graphRequestBatch);
        } catch (FacebookException e2) {
            Logger.log(LoggingBehavior.REQUESTS, RESPONSE_LOG_TAG, "Response <Error>: %s", e2);
            return constructErrorResponses(graphRequestBatch, httpURLConnection, e2);
        } catch (Exception e3) {
            Logger.log(LoggingBehavior.REQUESTS, RESPONSE_LOG_TAG, "Response <Error>: %s", e3);
            return constructErrorResponses(graphRequestBatch, httpURLConnection, new FacebookException(e3));
        } finally {
            Utility.closeQuietly(closeable);
            AppMethodBeat.o(17200);
        }
    }

    static List<GraphResponse> createResponsesFromStream(InputStream inputStream, HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) {
        AppMethodBeat.i(17201);
        String readStreamToString = Utility.readStreamToString(inputStream);
        Logger.log(LoggingBehavior.INCLUDE_RAW_RESPONSES, RESPONSE_LOG_TAG, "Response (raw)\n  Size: %d\n  Response:\n%s\n", Integer.valueOf(readStreamToString.length()), readStreamToString);
        List<GraphResponse> createResponsesFromString = createResponsesFromString(readStreamToString, httpURLConnection, graphRequestBatch);
        AppMethodBeat.o(17201);
        return createResponsesFromString;
    }

    static List<GraphResponse> createResponsesFromString(String str, HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) {
        AppMethodBeat.i(17202);
        List<GraphResponse> createResponsesFromObject = createResponsesFromObject(httpURLConnection, graphRequestBatch, new JSONTokener(str).nextValue());
        Logger.log(LoggingBehavior.REQUESTS, RESPONSE_LOG_TAG, "Response\n  Id: %s\n  Size: %d\n  Responses:\n%s\n", graphRequestBatch.getId(), Integer.valueOf(str.length()), createResponsesFromObject);
        AppMethodBeat.o(17202);
        return createResponsesFromObject;
    }

    private static List<GraphResponse> createResponsesFromObject(HttpURLConnection httpURLConnection, List<GraphRequest> list, Object obj) {
        JSONArray jSONArray;
        AppMethodBeat.i(17203);
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        if (size == 1) {
            GraphRequest graphRequest = list.get(0);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(BODY_KEY, obj);
                jSONObject.put("code", httpURLConnection != null ? httpURLConnection.getResponseCode() : 200);
                JSONArray jSONArray2 = new JSONArray();
                jSONArray2.put(jSONObject);
                jSONArray = jSONArray2;
            } catch (JSONException e2) {
                arrayList.add(new GraphResponse(graphRequest, httpURLConnection, new FacebookRequestError(httpURLConnection, e2)));
                jSONArray = obj;
            } catch (IOException e3) {
                arrayList.add(new GraphResponse(graphRequest, httpURLConnection, new FacebookRequestError(httpURLConnection, e3)));
            }
            if ((jSONArray instanceof JSONArray) || ((JSONArray) jSONArray).length() != size) {
                FacebookException facebookException = new FacebookException("Unexpected number of results");
                AppMethodBeat.o(17203);
                throw facebookException;
            }
            JSONArray jSONArray3 = (JSONArray) jSONArray;
            for (int i2 = 0; i2 < jSONArray3.length(); i2++) {
                GraphRequest graphRequest2 = list.get(i2);
                try {
                    arrayList.add(createResponseFromObject(graphRequest2, httpURLConnection, jSONArray3.get(i2), obj));
                } catch (JSONException e4) {
                    arrayList.add(new GraphResponse(graphRequest2, httpURLConnection, new FacebookRequestError(httpURLConnection, e4)));
                } catch (FacebookException e5) {
                    arrayList.add(new GraphResponse(graphRequest2, httpURLConnection, new FacebookRequestError(httpURLConnection, e5)));
                }
            }
            AppMethodBeat.o(17203);
            return arrayList;
        }
        jSONArray = obj;
        if (jSONArray instanceof JSONArray) {
        }
        FacebookException facebookException2 = new FacebookException("Unexpected number of results");
        AppMethodBeat.o(17203);
        throw facebookException2;
    }

    private static GraphResponse createResponseFromObject(GraphRequest graphRequest, HttpURLConnection httpURLConnection, Object obj, Object obj2) {
        AppMethodBeat.i(17204);
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            FacebookRequestError checkResponseAndCreateError = FacebookRequestError.checkResponseAndCreateError(jSONObject, obj2, httpURLConnection);
            if (checkResponseAndCreateError != null) {
                if (checkResponseAndCreateError.getErrorCode() == 190 && Utility.isCurrentAccessToken(graphRequest.getAccessToken())) {
                    if (checkResponseAndCreateError.getSubErrorCode() != 493) {
                        AccessToken.setCurrentAccessToken(null);
                    } else if (!AccessToken.getCurrentAccessToken().isExpired()) {
                        AccessToken.expireCurrentAccessToken();
                    }
                }
                GraphResponse graphResponse = new GraphResponse(graphRequest, httpURLConnection, checkResponseAndCreateError);
                AppMethodBeat.o(17204);
                return graphResponse;
            }
            Object stringPropertyAsJSON = Utility.getStringPropertyAsJSON(jSONObject, BODY_KEY, NON_JSON_RESPONSE_PROPERTY);
            if (stringPropertyAsJSON instanceof JSONObject) {
                GraphResponse graphResponse2 = new GraphResponse(graphRequest, httpURLConnection, stringPropertyAsJSON.toString(), (JSONObject) stringPropertyAsJSON);
                AppMethodBeat.o(17204);
                return graphResponse2;
            } else if (stringPropertyAsJSON instanceof JSONArray) {
                GraphResponse graphResponse3 = new GraphResponse(graphRequest, httpURLConnection, stringPropertyAsJSON.toString(), (JSONArray) stringPropertyAsJSON);
                AppMethodBeat.o(17204);
                return graphResponse3;
            } else {
                obj = JSONObject.NULL;
            }
        }
        if (obj == JSONObject.NULL) {
            GraphResponse graphResponse4 = new GraphResponse(graphRequest, httpURLConnection, obj.toString(), (JSONObject) null);
            AppMethodBeat.o(17204);
            return graphResponse4;
        }
        FacebookException facebookException = new FacebookException("Got unexpected object type in response, class: " + obj.getClass().getSimpleName());
        AppMethodBeat.o(17204);
        throw facebookException;
    }

    static List<GraphResponse> constructErrorResponses(List<GraphRequest> list, HttpURLConnection httpURLConnection, FacebookException facebookException) {
        AppMethodBeat.i(17205);
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(new GraphResponse(list.get(i2), httpURLConnection, new FacebookRequestError(httpURLConnection, facebookException)));
        }
        AppMethodBeat.o(17205);
        return arrayList;
    }
}
