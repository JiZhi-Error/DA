package com.facebook;

import android.content.Context;
import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import com.facebook.GraphRequestBatch;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.InternalSettings;
import com.facebook.internal.Logger;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GraphRequest {
    private static final String ACCEPT_LANGUAGE_HEADER = "Accept-Language";
    public static final String ACCESS_TOKEN_PARAM = "access_token";
    private static final String ATTACHED_FILES_PARAM = "attached_files";
    private static final String ATTACHMENT_FILENAME_PREFIX = "file";
    private static final String BATCH_APP_ID_PARAM = "batch_app_id";
    private static final String BATCH_BODY_PARAM = "body";
    private static final String BATCH_ENTRY_DEPENDS_ON_PARAM = "depends_on";
    private static final String BATCH_ENTRY_NAME_PARAM = "name";
    private static final String BATCH_ENTRY_OMIT_RESPONSE_ON_SUCCESS_PARAM = "omit_response_on_success";
    private static final String BATCH_METHOD_PARAM = "method";
    private static final String BATCH_PARAM = "batch";
    private static final String BATCH_RELATIVE_URL_PARAM = "relative_url";
    private static final String CAPTION_PARAM = "caption";
    private static final String CONTENT_ENCODING_HEADER = "Content-Encoding";
    private static final String CONTENT_TYPE_HEADER = "Content-Type";
    private static final String DEBUG_KEY = "__debug__";
    private static final String DEBUG_MESSAGES_KEY = "messages";
    private static final String DEBUG_MESSAGE_KEY = "message";
    private static final String DEBUG_MESSAGE_LINK_KEY = "link";
    private static final String DEBUG_MESSAGE_TYPE_KEY = "type";
    private static final String DEBUG_PARAM = "debug";
    private static final String DEBUG_SEVERITY_INFO = "info";
    private static final String DEBUG_SEVERITY_WARNING = "warning";
    public static final String FIELDS_PARAM = "fields";
    private static final String FORMAT_JSON = "json";
    private static final String FORMAT_PARAM = "format";
    private static final String GRAPH_PATH_FORMAT = "%s/%s";
    private static final String ISO_8601_FORMAT_STRING = "yyyy-MM-dd'T'HH:mm:ssZ";
    public static final int MAXIMUM_BATCH_SIZE = 50;
    private static final String ME = "me";
    private static final String MIME_BOUNDARY;
    private static final String MY_FRIENDS = "me/friends";
    private static final String MY_PHOTOS = "me/photos";
    private static final String PICTURE_PARAM = "picture";
    private static final String SDK_ANDROID = "android";
    private static final String SDK_PARAM = "sdk";
    private static final String SEARCH = "search";
    public static final String TAG = GraphRequest.class.getSimpleName();
    private static final String USER_AGENT_BASE = "FBAndroidSDK";
    private static final String USER_AGENT_HEADER = "User-Agent";
    private static final String VIDEOS_SUFFIX = "/videos";
    private static String defaultBatchApplicationId;
    private static volatile String userAgent;
    private static Pattern versionPattern = Pattern.compile("^/?v\\d+\\.\\d+/(.*)");
    private AccessToken accessToken;
    private String batchEntryDependsOn;
    private String batchEntryName;
    private boolean batchEntryOmitResultOnSuccess;
    private Callback callback;
    private JSONObject graphObject;
    private String graphPath;
    private HttpMethod httpMethod;
    private String overriddenURL;
    private Bundle parameters;
    private boolean skipClientToken;
    private Object tag;
    private String version;

    public interface Callback {
        void onCompleted(GraphResponse graphResponse);
    }

    public interface GraphJSONArrayCallback {
        void onCompleted(JSONArray jSONArray, GraphResponse graphResponse);
    }

    public interface GraphJSONObjectCallback {
        void onCompleted(JSONObject jSONObject, GraphResponse graphResponse);
    }

    /* access modifiers changed from: package-private */
    public interface KeyValueSerializer {
        void writeString(String str, String str2);
    }

    public interface OnProgressCallback extends Callback {
        void onProgress(long j2, long j3);
    }

    static /* synthetic */ boolean access$000(Object obj) {
        AppMethodBeat.i(17157);
        boolean isSupportedParameterType = isSupportedParameterType(obj);
        AppMethodBeat.o(17157);
        return isSupportedParameterType;
    }

    static /* synthetic */ String access$100(Object obj) {
        AppMethodBeat.i(17158);
        String parameterToString = parameterToString(obj);
        AppMethodBeat.o(17158);
        return parameterToString;
    }

    static {
        AppMethodBeat.i(17159);
        char[] charArray = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        StringBuilder sb = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        int nextInt = secureRandom.nextInt(11) + 30;
        for (int i2 = 0; i2 < nextInt; i2++) {
            sb.append(charArray[secureRandom.nextInt(charArray.length)]);
        }
        MIME_BOUNDARY = sb.toString();
        AppMethodBeat.o(17159);
    }

    public GraphRequest() {
        this(null, null, null, null, null);
    }

    public GraphRequest(AccessToken accessToken2, String str) {
        this(accessToken2, str, null, null, null);
    }

    public GraphRequest(AccessToken accessToken2, String str, Bundle bundle, HttpMethod httpMethod2) {
        this(accessToken2, str, bundle, httpMethod2, null);
    }

    public GraphRequest(AccessToken accessToken2, String str, Bundle bundle, HttpMethod httpMethod2, Callback callback2) {
        this(accessToken2, str, bundle, httpMethod2, callback2, null);
    }

    public GraphRequest(AccessToken accessToken2, String str, Bundle bundle, HttpMethod httpMethod2, Callback callback2, String str2) {
        AppMethodBeat.i(17100);
        this.batchEntryOmitResultOnSuccess = true;
        this.skipClientToken = false;
        this.accessToken = accessToken2;
        this.graphPath = str;
        this.version = str2;
        setCallback(callback2);
        setHttpMethod(httpMethod2);
        if (bundle != null) {
            this.parameters = new Bundle(bundle);
        } else {
            this.parameters = new Bundle();
        }
        if (this.version == null) {
            this.version = FacebookSdk.getGraphApiVersion();
        }
        AppMethodBeat.o(17100);
    }

    GraphRequest(AccessToken accessToken2, URL url) {
        AppMethodBeat.i(17101);
        this.batchEntryOmitResultOnSuccess = true;
        this.skipClientToken = false;
        this.accessToken = accessToken2;
        this.overriddenURL = url.toString();
        setHttpMethod(HttpMethod.GET);
        this.parameters = new Bundle();
        AppMethodBeat.o(17101);
    }

    public static GraphRequest newDeleteObjectRequest(AccessToken accessToken2, String str, Callback callback2) {
        AppMethodBeat.i(17102);
        GraphRequest graphRequest = new GraphRequest(accessToken2, str, null, HttpMethod.DELETE, callback2);
        AppMethodBeat.o(17102);
        return graphRequest;
    }

    public static GraphRequest newMeRequest(AccessToken accessToken2, final GraphJSONObjectCallback graphJSONObjectCallback) {
        AppMethodBeat.i(17103);
        GraphRequest graphRequest = new GraphRequest(accessToken2, ME, null, null, new Callback() {
            /* class com.facebook.GraphRequest.AnonymousClass1 */

            @Override // com.facebook.GraphRequest.Callback
            public final void onCompleted(GraphResponse graphResponse) {
                AppMethodBeat.i(17076);
                if (graphJSONObjectCallback != null) {
                    graphJSONObjectCallback.onCompleted(graphResponse.getJSONObject(), graphResponse);
                }
                AppMethodBeat.o(17076);
            }
        });
        AppMethodBeat.o(17103);
        return graphRequest;
    }

    public static GraphRequest newPostRequest(AccessToken accessToken2, String str, JSONObject jSONObject, Callback callback2) {
        AppMethodBeat.i(17104);
        GraphRequest graphRequest = new GraphRequest(accessToken2, str, null, HttpMethod.POST, callback2);
        graphRequest.setGraphObject(jSONObject);
        AppMethodBeat.o(17104);
        return graphRequest;
    }

    public static GraphRequest newMyFriendsRequest(AccessToken accessToken2, final GraphJSONArrayCallback graphJSONArrayCallback) {
        AppMethodBeat.i(17105);
        GraphRequest graphRequest = new GraphRequest(accessToken2, MY_FRIENDS, null, null, new Callback() {
            /* class com.facebook.GraphRequest.AnonymousClass2 */

            @Override // com.facebook.GraphRequest.Callback
            public final void onCompleted(GraphResponse graphResponse) {
                AppMethodBeat.i(17077);
                if (graphJSONArrayCallback != null) {
                    JSONObject jSONObject = graphResponse.getJSONObject();
                    graphJSONArrayCallback.onCompleted(jSONObject != null ? jSONObject.optJSONArray("data") : null, graphResponse);
                }
                AppMethodBeat.o(17077);
            }
        });
        AppMethodBeat.o(17105);
        return graphRequest;
    }

    public static GraphRequest newGraphPathRequest(AccessToken accessToken2, String str, Callback callback2) {
        AppMethodBeat.i(17106);
        GraphRequest graphRequest = new GraphRequest(accessToken2, str, null, null, callback2);
        AppMethodBeat.o(17106);
        return graphRequest;
    }

    public static GraphRequest newPlacesSearchRequest(AccessToken accessToken2, Location location, int i2, int i3, String str, final GraphJSONArrayCallback graphJSONArrayCallback) {
        AppMethodBeat.i(17107);
        if (location != null || !Utility.isNullOrEmpty(str)) {
            Bundle bundle = new Bundle(5);
            bundle.putString("type", "place");
            bundle.putInt("limit", i3);
            if (location != null) {
                bundle.putString("center", String.format(Locale.US, "%f,%f", Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude())));
                bundle.putInt("distance", i2);
            }
            if (!Utility.isNullOrEmpty(str)) {
                bundle.putString("q", str);
            }
            GraphRequest graphRequest = new GraphRequest(accessToken2, "search", bundle, HttpMethod.GET, new Callback() {
                /* class com.facebook.GraphRequest.AnonymousClass3 */

                @Override // com.facebook.GraphRequest.Callback
                public final void onCompleted(GraphResponse graphResponse) {
                    AppMethodBeat.i(17078);
                    if (graphJSONArrayCallback != null) {
                        JSONObject jSONObject = graphResponse.getJSONObject();
                        graphJSONArrayCallback.onCompleted(jSONObject != null ? jSONObject.optJSONArray("data") : null, graphResponse);
                    }
                    AppMethodBeat.o(17078);
                }
            });
            AppMethodBeat.o(17107);
            return graphRequest;
        }
        FacebookException facebookException = new FacebookException("Either location or searchText must be specified.");
        AppMethodBeat.o(17107);
        throw facebookException;
    }

    public static GraphRequest newUploadPhotoRequest(AccessToken accessToken2, String str, Bitmap bitmap, String str2, Bundle bundle, Callback callback2) {
        AppMethodBeat.i(17108);
        String defaultPhotoPathIfNull = getDefaultPhotoPathIfNull(str);
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        bundle2.putParcelable("picture", bitmap);
        if (str2 != null && !str2.isEmpty()) {
            bundle2.putString("caption", str2);
        }
        GraphRequest graphRequest = new GraphRequest(accessToken2, defaultPhotoPathIfNull, bundle2, HttpMethod.POST, callback2);
        AppMethodBeat.o(17108);
        return graphRequest;
    }

    public static GraphRequest newUploadPhotoRequest(AccessToken accessToken2, String str, File file, String str2, Bundle bundle, Callback callback2) {
        AppMethodBeat.i(17109);
        String defaultPhotoPathIfNull = getDefaultPhotoPathIfNull(str);
        ParcelFileDescriptor open = ParcelFileDescriptor.open(file, 268435456);
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        bundle2.putParcelable("picture", open);
        if (str2 != null && !str2.isEmpty()) {
            bundle2.putString("caption", str2);
        }
        GraphRequest graphRequest = new GraphRequest(accessToken2, defaultPhotoPathIfNull, bundle2, HttpMethod.POST, callback2);
        AppMethodBeat.o(17109);
        return graphRequest;
    }

    public static GraphRequest newUploadPhotoRequest(AccessToken accessToken2, String str, Uri uri, String str2, Bundle bundle, Callback callback2) {
        AppMethodBeat.i(17110);
        String defaultPhotoPathIfNull = getDefaultPhotoPathIfNull(str);
        if (Utility.isFileUri(uri)) {
            GraphRequest newUploadPhotoRequest = newUploadPhotoRequest(accessToken2, defaultPhotoPathIfNull, new File(uri.getPath()), str2, bundle, callback2);
            AppMethodBeat.o(17110);
            return newUploadPhotoRequest;
        } else if (!Utility.isContentUri(uri)) {
            FacebookException facebookException = new FacebookException("The photo Uri must be either a file:// or content:// Uri");
            AppMethodBeat.o(17110);
            throw facebookException;
        } else {
            Bundle bundle2 = new Bundle();
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            bundle2.putParcelable("picture", uri);
            if (str2 != null && !str2.isEmpty()) {
                bundle2.putString("caption", str2);
            }
            GraphRequest graphRequest = new GraphRequest(accessToken2, defaultPhotoPathIfNull, bundle2, HttpMethod.POST, callback2);
            AppMethodBeat.o(17110);
            return graphRequest;
        }
    }

    public static GraphRequest newCustomAudienceThirdPartyIdRequest(AccessToken accessToken2, Context context, String str, Callback callback2) {
        String str2;
        String androidAdvertiserId;
        AppMethodBeat.i(17111);
        if (str != null || accessToken2 == null) {
            str2 = str;
        } else {
            str2 = accessToken2.getApplicationId();
        }
        if (str2 == null) {
            str2 = Utility.getMetadataApplicationId(context);
        }
        if (str2 == null) {
            FacebookException facebookException = new FacebookException("Facebook App ID cannot be determined");
            AppMethodBeat.o(17111);
            throw facebookException;
        }
        String str3 = str2 + "/custom_audience_third_party_id";
        AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(context);
        Bundle bundle = new Bundle();
        if (accessToken2 == null) {
            if (attributionIdentifiers == null) {
                FacebookException facebookException2 = new FacebookException("There is no access token and attribution identifiers could not be retrieved");
                AppMethodBeat.o(17111);
                throw facebookException2;
            }
            if (attributionIdentifiers.getAttributionId() != null) {
                androidAdvertiserId = attributionIdentifiers.getAttributionId();
            } else {
                androidAdvertiserId = attributionIdentifiers.getAndroidAdvertiserId();
            }
            if (attributionIdentifiers.getAttributionId() != null) {
                bundle.putString("udid", androidAdvertiserId);
            }
        }
        if (FacebookSdk.getLimitEventAndDataUsage(context) || (attributionIdentifiers != null && attributionIdentifiers.isTrackingLimited())) {
            bundle.putString("limit_event_usage", "1");
        }
        GraphRequest graphRequest = new GraphRequest(accessToken2, str3, bundle, HttpMethod.GET, callback2);
        AppMethodBeat.o(17111);
        return graphRequest;
    }

    public static GraphRequest newCustomAudienceThirdPartyIdRequest(AccessToken accessToken2, Context context, Callback callback2) {
        AppMethodBeat.i(17112);
        GraphRequest newCustomAudienceThirdPartyIdRequest = newCustomAudienceThirdPartyIdRequest(accessToken2, context, null, callback2);
        AppMethodBeat.o(17112);
        return newCustomAudienceThirdPartyIdRequest;
    }

    public final JSONObject getGraphObject() {
        return this.graphObject;
    }

    public final void setGraphObject(JSONObject jSONObject) {
        this.graphObject = jSONObject;
    }

    public final String getGraphPath() {
        return this.graphPath;
    }

    public final void setGraphPath(String str) {
        this.graphPath = str;
    }

    public final HttpMethod getHttpMethod() {
        return this.httpMethod;
    }

    public final void setHttpMethod(HttpMethod httpMethod2) {
        AppMethodBeat.i(17113);
        if (this.overriddenURL == null || httpMethod2 == HttpMethod.GET) {
            if (httpMethod2 == null) {
                httpMethod2 = HttpMethod.GET;
            }
            this.httpMethod = httpMethod2;
            AppMethodBeat.o(17113);
            return;
        }
        FacebookException facebookException = new FacebookException("Can't change HTTP method on request with overridden URL.");
        AppMethodBeat.o(17113);
        throw facebookException;
    }

    public final String getVersion() {
        return this.version;
    }

    public final void setVersion(String str) {
        this.version = str;
    }

    public final void setSkipClientToken(boolean z) {
        this.skipClientToken = z;
    }

    public final Bundle getParameters() {
        return this.parameters;
    }

    public final void setParameters(Bundle bundle) {
        this.parameters = bundle;
    }

    public final AccessToken getAccessToken() {
        return this.accessToken;
    }

    public final void setAccessToken(AccessToken accessToken2) {
        this.accessToken = accessToken2;
    }

    public final String getBatchEntryName() {
        return this.batchEntryName;
    }

    public final void setBatchEntryName(String str) {
        this.batchEntryName = str;
    }

    public final String getBatchEntryDependsOn() {
        return this.batchEntryDependsOn;
    }

    public final void setBatchEntryDependsOn(String str) {
        this.batchEntryDependsOn = str;
    }

    public final boolean getBatchEntryOmitResultOnSuccess() {
        return this.batchEntryOmitResultOnSuccess;
    }

    public final void setBatchEntryOmitResultOnSuccess(boolean z) {
        this.batchEntryOmitResultOnSuccess = z;
    }

    public static final String getDefaultBatchApplicationId() {
        return defaultBatchApplicationId;
    }

    public static final void setDefaultBatchApplicationId(String str) {
        defaultBatchApplicationId = str;
    }

    public final Callback getCallback() {
        return this.callback;
    }

    public final void setCallback(final Callback callback2) {
        AppMethodBeat.i(17114);
        if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_INFO) || FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_WARNING)) {
            this.callback = new Callback() {
                /* class com.facebook.GraphRequest.AnonymousClass4 */

                @Override // com.facebook.GraphRequest.Callback
                public void onCompleted(GraphResponse graphResponse) {
                    AppMethodBeat.i(17079);
                    JSONObject jSONObject = graphResponse.getJSONObject();
                    JSONObject optJSONObject = jSONObject != null ? jSONObject.optJSONObject(GraphRequest.DEBUG_KEY) : null;
                    JSONArray optJSONArray = optJSONObject != null ? optJSONObject.optJSONArray(GraphRequest.DEBUG_MESSAGES_KEY) : null;
                    if (optJSONArray != null) {
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                            String optString = optJSONObject2 != null ? optJSONObject2.optString("message") : null;
                            String optString2 = optJSONObject2 != null ? optJSONObject2.optString("type") : null;
                            String optString3 = optJSONObject2 != null ? optJSONObject2.optString("link") : null;
                            if (!(optString == null || optString2 == null)) {
                                LoggingBehavior loggingBehavior = LoggingBehavior.GRAPH_API_DEBUG_INFO;
                                if (optString2.equals(GraphRequest.DEBUG_SEVERITY_WARNING)) {
                                    loggingBehavior = LoggingBehavior.GRAPH_API_DEBUG_WARNING;
                                }
                                if (!Utility.isNullOrEmpty(optString3)) {
                                    optString = optString + " Link: " + optString3;
                                }
                                Logger.log(loggingBehavior, GraphRequest.TAG, optString);
                            }
                        }
                    }
                    if (callback2 != null) {
                        callback2.onCompleted(graphResponse);
                    }
                    AppMethodBeat.o(17079);
                }
            };
            AppMethodBeat.o(17114);
            return;
        }
        this.callback = callback2;
        AppMethodBeat.o(17114);
    }

    public final void setTag(Object obj) {
        this.tag = obj;
    }

    public final Object getTag() {
        return this.tag;
    }

    public final GraphResponse executeAndWait() {
        AppMethodBeat.i(17115);
        GraphResponse executeAndWait = executeAndWait(this);
        AppMethodBeat.o(17115);
        return executeAndWait;
    }

    public final GraphRequestAsyncTask executeAsync() {
        AppMethodBeat.i(17116);
        GraphRequestAsyncTask executeBatchAsync = executeBatchAsync(this);
        AppMethodBeat.o(17116);
        return executeBatchAsync;
    }

    public static HttpURLConnection toHttpConnection(GraphRequest... graphRequestArr) {
        AppMethodBeat.i(17117);
        HttpURLConnection httpConnection = toHttpConnection(Arrays.asList(graphRequestArr));
        AppMethodBeat.o(17117);
        return httpConnection;
    }

    public static HttpURLConnection toHttpConnection(Collection<GraphRequest> collection) {
        AppMethodBeat.i(17118);
        Validate.notEmptyAndContainsNoNulls(collection, "requests");
        HttpURLConnection httpConnection = toHttpConnection(new GraphRequestBatch(collection));
        AppMethodBeat.o(17118);
        return httpConnection;
    }

    public static HttpURLConnection toHttpConnection(GraphRequestBatch graphRequestBatch) {
        URL url;
        AppMethodBeat.i(17119);
        validateFieldsParamForGetRequests(graphRequestBatch);
        try {
            if (graphRequestBatch.size() == 1) {
                url = new URL(graphRequestBatch.get(0).getUrlForSingleRequest());
            } else {
                url = new URL(ServerProtocol.getGraphUrlBase());
            }
            HttpURLConnection httpURLConnection = null;
            try {
                httpURLConnection = createConnection(url);
                serializeToUrlConnection(graphRequestBatch, httpURLConnection);
                AppMethodBeat.o(17119);
                return httpURLConnection;
            } catch (IOException | JSONException e2) {
                Utility.disconnectQuietly(httpURLConnection);
                FacebookException facebookException = new FacebookException("could not construct request body", e2);
                AppMethodBeat.o(17119);
                throw facebookException;
            }
        } catch (MalformedURLException e3) {
            FacebookException facebookException2 = new FacebookException("could not construct URL for request", e3);
            AppMethodBeat.o(17119);
            throw facebookException2;
        }
    }

    public static GraphResponse executeAndWait(GraphRequest graphRequest) {
        AppMethodBeat.i(17120);
        List<GraphResponse> executeBatchAndWait = executeBatchAndWait(graphRequest);
        if (executeBatchAndWait == null || executeBatchAndWait.size() != 1) {
            FacebookException facebookException = new FacebookException("invalid state: expected a single response");
            AppMethodBeat.o(17120);
            throw facebookException;
        }
        GraphResponse graphResponse = executeBatchAndWait.get(0);
        AppMethodBeat.o(17120);
        return graphResponse;
    }

    public static List<GraphResponse> executeBatchAndWait(GraphRequest... graphRequestArr) {
        AppMethodBeat.i(17121);
        Validate.notNull(graphRequestArr, "requests");
        List<GraphResponse> executeBatchAndWait = executeBatchAndWait(Arrays.asList(graphRequestArr));
        AppMethodBeat.o(17121);
        return executeBatchAndWait;
    }

    public static List<GraphResponse> executeBatchAndWait(Collection<GraphRequest> collection) {
        AppMethodBeat.i(17122);
        List<GraphResponse> executeBatchAndWait = executeBatchAndWait(new GraphRequestBatch(collection));
        AppMethodBeat.o(17122);
        return executeBatchAndWait;
    }

    public static List<GraphResponse> executeBatchAndWait(GraphRequestBatch graphRequestBatch) {
        AppMethodBeat.i(17123);
        Validate.notEmptyAndContainsNoNulls(graphRequestBatch, "requests");
        try {
            HttpURLConnection httpConnection = toHttpConnection(graphRequestBatch);
            try {
                return executeConnectionAndWait(httpConnection, graphRequestBatch);
            } finally {
                Utility.disconnectQuietly(httpConnection);
                AppMethodBeat.o(17123);
            }
        } catch (Exception e2) {
            List<GraphResponse> constructErrorResponses = GraphResponse.constructErrorResponses(graphRequestBatch.getRequests(), null, new FacebookException(e2));
            runCallbacks(graphRequestBatch, constructErrorResponses);
            Utility.disconnectQuietly(null);
            AppMethodBeat.o(17123);
            return constructErrorResponses;
        }
    }

    public static GraphRequestAsyncTask executeBatchAsync(GraphRequest... graphRequestArr) {
        AppMethodBeat.i(17124);
        Validate.notNull(graphRequestArr, "requests");
        GraphRequestAsyncTask executeBatchAsync = executeBatchAsync(Arrays.asList(graphRequestArr));
        AppMethodBeat.o(17124);
        return executeBatchAsync;
    }

    public static GraphRequestAsyncTask executeBatchAsync(Collection<GraphRequest> collection) {
        AppMethodBeat.i(17125);
        GraphRequestAsyncTask executeBatchAsync = executeBatchAsync(new GraphRequestBatch(collection));
        AppMethodBeat.o(17125);
        return executeBatchAsync;
    }

    public static GraphRequestAsyncTask executeBatchAsync(GraphRequestBatch graphRequestBatch) {
        AppMethodBeat.i(17126);
        Validate.notEmptyAndContainsNoNulls(graphRequestBatch, "requests");
        GraphRequestAsyncTask graphRequestAsyncTask = new GraphRequestAsyncTask(graphRequestBatch);
        graphRequestAsyncTask.executeOnExecutor(FacebookSdk.getExecutor(), new Void[0]);
        AppMethodBeat.o(17126);
        return graphRequestAsyncTask;
    }

    public static List<GraphResponse> executeConnectionAndWait(HttpURLConnection httpURLConnection, Collection<GraphRequest> collection) {
        AppMethodBeat.i(17127);
        List<GraphResponse> executeConnectionAndWait = executeConnectionAndWait(httpURLConnection, new GraphRequestBatch(collection));
        AppMethodBeat.o(17127);
        return executeConnectionAndWait;
    }

    public static List<GraphResponse> executeConnectionAndWait(HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) {
        AppMethodBeat.i(17128);
        List<GraphResponse> fromHttpConnection = GraphResponse.fromHttpConnection(httpURLConnection, graphRequestBatch);
        Utility.disconnectQuietly(httpURLConnection);
        int size = graphRequestBatch.size();
        if (size != fromHttpConnection.size()) {
            FacebookException facebookException = new FacebookException(String.format(Locale.US, "Received %d responses while expecting %d", Integer.valueOf(fromHttpConnection.size()), Integer.valueOf(size)));
            AppMethodBeat.o(17128);
            throw facebookException;
        }
        runCallbacks(graphRequestBatch, fromHttpConnection);
        AccessTokenManager.getInstance().extendAccessTokenIfNeeded();
        AppMethodBeat.o(17128);
        return fromHttpConnection;
    }

    public static GraphRequestAsyncTask executeConnectionAsync(HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) {
        AppMethodBeat.i(17129);
        GraphRequestAsyncTask executeConnectionAsync = executeConnectionAsync(null, httpURLConnection, graphRequestBatch);
        AppMethodBeat.o(17129);
        return executeConnectionAsync;
    }

    public static GraphRequestAsyncTask executeConnectionAsync(Handler handler, HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) {
        AppMethodBeat.i(17130);
        Validate.notNull(httpURLConnection, "connection");
        GraphRequestAsyncTask graphRequestAsyncTask = new GraphRequestAsyncTask(httpURLConnection, graphRequestBatch);
        graphRequestBatch.setCallbackHandler(handler);
        graphRequestAsyncTask.executeOnExecutor(FacebookSdk.getExecutor(), new Void[0]);
        AppMethodBeat.o(17130);
        return graphRequestAsyncTask;
    }

    public String toString() {
        AppMethodBeat.i(17131);
        String str = "{Request:  accessToken: " + (this.accessToken == null ? BuildConfig.COMMAND : this.accessToken) + ", graphPath: " + this.graphPath + ", graphObject: " + this.graphObject + ", httpMethod: " + this.httpMethod + ", parameters: " + this.parameters + "}";
        AppMethodBeat.o(17131);
        return str;
    }

    static void runCallbacks(final GraphRequestBatch graphRequestBatch, List<GraphResponse> list) {
        AppMethodBeat.i(17132);
        int size = graphRequestBatch.size();
        final ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < size; i2++) {
            GraphRequest graphRequest = graphRequestBatch.get(i2);
            if (graphRequest.callback != null) {
                arrayList.add(new Pair(graphRequest.callback, list.get(i2)));
            }
        }
        if (arrayList.size() > 0) {
            AnonymousClass5 r0 = new Runnable() {
                /* class com.facebook.GraphRequest.AnonymousClass5 */

                public final void run() {
                    AppMethodBeat.i(17080);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        ((Callback) pair.first).onCompleted((GraphResponse) pair.second);
                    }
                    for (GraphRequestBatch.Callback callback : graphRequestBatch.getCallbacks()) {
                        callback.onBatchCompleted(graphRequestBatch);
                    }
                    AppMethodBeat.o(17080);
                }
            };
            Handler callbackHandler = graphRequestBatch.getCallbackHandler();
            if (callbackHandler == null) {
                r0.run();
                AppMethodBeat.o(17132);
                return;
            }
            callbackHandler.post(r0);
        }
        AppMethodBeat.o(17132);
    }

    private static String getDefaultPhotoPathIfNull(String str) {
        return str == null ? "me/photos" : str;
    }

    private static HttpURLConnection createConnection(URL url) {
        AppMethodBeat.i(17133);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestProperty(USER_AGENT_HEADER, getUserAgent());
        httpURLConnection.setRequestProperty(ACCEPT_LANGUAGE_HEADER, Locale.getDefault().toString());
        httpURLConnection.setChunkedStreamingMode(0);
        AppMethodBeat.o(17133);
        return httpURLConnection;
    }

    private void addCommonParameters() {
        AppMethodBeat.i(17134);
        if (this.accessToken != null) {
            if (!this.parameters.containsKey("access_token")) {
                String token = this.accessToken.getToken();
                Logger.registerAccessToken(token);
                this.parameters.putString("access_token", token);
            }
        } else if (!this.skipClientToken && !this.parameters.containsKey("access_token")) {
            String applicationId = FacebookSdk.getApplicationId();
            String clientToken = FacebookSdk.getClientToken();
            if (Utility.isNullOrEmpty(applicationId) || Utility.isNullOrEmpty(clientToken)) {
                Utility.logd(TAG, "Warning: Request without access token missing application ID or client token.");
            } else {
                this.parameters.putString("access_token", applicationId + "|" + clientToken);
            }
        }
        this.parameters.putString("sdk", "android");
        this.parameters.putString(FORMAT_PARAM, FORMAT_JSON);
        if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_INFO)) {
            this.parameters.putString(DEBUG_PARAM, DEBUG_SEVERITY_INFO);
            AppMethodBeat.o(17134);
            return;
        }
        if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_WARNING)) {
            this.parameters.putString(DEBUG_PARAM, DEBUG_SEVERITY_WARNING);
        }
        AppMethodBeat.o(17134);
    }

    private String appendParametersToBaseUrl(String str, Boolean bool) {
        AppMethodBeat.i(17135);
        if (bool.booleanValue() || this.httpMethod != HttpMethod.POST) {
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            for (String str2 : this.parameters.keySet()) {
                Object obj = this.parameters.get(str2);
                if (obj == null) {
                    obj = "";
                }
                if (isSupportedParameterType(obj)) {
                    buildUpon.appendQueryParameter(str2, parameterToString(obj).toString());
                } else if (this.httpMethod == HttpMethod.GET) {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format(Locale.US, "Unsupported parameter type for GET request: %s", obj.getClass().getSimpleName()));
                    AppMethodBeat.o(17135);
                    throw illegalArgumentException;
                }
            }
            String builder = buildUpon.toString();
            AppMethodBeat.o(17135);
            return builder;
        }
        AppMethodBeat.o(17135);
        return str;
    }

    /* access modifiers changed from: package-private */
    public final String getRelativeUrlForBatchedRequest() {
        AppMethodBeat.i(17136);
        if (this.overriddenURL != null) {
            FacebookException facebookException = new FacebookException("Can't override URL for a batch request");
            AppMethodBeat.o(17136);
            throw facebookException;
        }
        String format = String.format(GRAPH_PATH_FORMAT, ServerProtocol.getGraphUrlBase(), getGraphPathWithVersion());
        addCommonParameters();
        Uri parse = Uri.parse(appendParametersToBaseUrl(format, Boolean.TRUE));
        String format2 = String.format("%s?%s", parse.getPath(), parse.getQuery());
        AppMethodBeat.o(17136);
        return format2;
    }

    /* access modifiers changed from: package-private */
    public final String getUrlForSingleRequest() {
        String graphUrlBase;
        AppMethodBeat.i(17137);
        if (this.overriddenURL != null) {
            String str = this.overriddenURL.toString();
            AppMethodBeat.o(17137);
            return str;
        }
        if (getHttpMethod() != HttpMethod.POST || this.graphPath == null || !this.graphPath.endsWith(VIDEOS_SUFFIX)) {
            graphUrlBase = ServerProtocol.getGraphUrlBase();
        } else {
            graphUrlBase = ServerProtocol.getGraphVideoUrlBase();
        }
        String format = String.format(GRAPH_PATH_FORMAT, graphUrlBase, getGraphPathWithVersion());
        addCommonParameters();
        String appendParametersToBaseUrl = appendParametersToBaseUrl(format, Boolean.FALSE);
        AppMethodBeat.o(17137);
        return appendParametersToBaseUrl;
    }

    private String getGraphPathWithVersion() {
        AppMethodBeat.i(17138);
        if (versionPattern.matcher(this.graphPath).matches()) {
            String str = this.graphPath;
            AppMethodBeat.o(17138);
            return str;
        }
        String format = String.format(GRAPH_PATH_FORMAT, this.version, this.graphPath);
        AppMethodBeat.o(17138);
        return format;
    }

    /* access modifiers changed from: package-private */
    public static class Attachment {
        private final GraphRequest request;
        private final Object value;

        public Attachment(GraphRequest graphRequest, Object obj) {
            this.request = graphRequest;
            this.value = obj;
        }

        public GraphRequest getRequest() {
            return this.request;
        }

        public Object getValue() {
            return this.value;
        }
    }

    private void serializeToBatch(JSONArray jSONArray, Map<String, Attachment> map) {
        AppMethodBeat.i(17139);
        JSONObject jSONObject = new JSONObject();
        if (this.batchEntryName != null) {
            jSONObject.put("name", this.batchEntryName);
            jSONObject.put(BATCH_ENTRY_OMIT_RESPONSE_ON_SUCCESS_PARAM, this.batchEntryOmitResultOnSuccess);
        }
        if (this.batchEntryDependsOn != null) {
            jSONObject.put(BATCH_ENTRY_DEPENDS_ON_PARAM, this.batchEntryDependsOn);
        }
        String relativeUrlForBatchedRequest = getRelativeUrlForBatchedRequest();
        jSONObject.put(BATCH_RELATIVE_URL_PARAM, relativeUrlForBatchedRequest);
        jSONObject.put("method", this.httpMethod);
        if (this.accessToken != null) {
            Logger.registerAccessToken(this.accessToken.getToken());
        }
        ArrayList arrayList = new ArrayList();
        for (String str : this.parameters.keySet()) {
            Object obj = this.parameters.get(str);
            if (isSupportedAttachmentType(obj)) {
                String format = String.format(Locale.ROOT, "%s%d", ATTACHMENT_FILENAME_PREFIX, Integer.valueOf(map.size()));
                arrayList.add(format);
                map.put(format, new Attachment(this, obj));
            }
        }
        if (!arrayList.isEmpty()) {
            jSONObject.put(ATTACHED_FILES_PARAM, TextUtils.join(",", arrayList));
        }
        if (this.graphObject != null) {
            final ArrayList arrayList2 = new ArrayList();
            processGraphObject(this.graphObject, relativeUrlForBatchedRequest, new KeyValueSerializer() {
                /* class com.facebook.GraphRequest.AnonymousClass6 */

                @Override // com.facebook.GraphRequest.KeyValueSerializer
                public void writeString(String str, String str2) {
                    AppMethodBeat.i(17081);
                    arrayList2.add(String.format(Locale.US, "%s=%s", str, URLEncoder.encode(str2, MimeTypeUtil.ContentType.DEFAULT_CHARSET)));
                    AppMethodBeat.o(17081);
                }
            });
            jSONObject.put(BATCH_BODY_PARAM, TextUtils.join("&", arrayList2));
        }
        jSONArray.put(jSONObject);
        AppMethodBeat.o(17139);
    }

    private static boolean hasOnProgressCallbacks(GraphRequestBatch graphRequestBatch) {
        AppMethodBeat.i(17140);
        for (GraphRequestBatch.Callback callback2 : graphRequestBatch.getCallbacks()) {
            if (callback2 instanceof GraphRequestBatch.OnProgressCallback) {
                AppMethodBeat.o(17140);
                return true;
            }
        }
        Iterator it = graphRequestBatch.iterator();
        while (it.hasNext()) {
            if (((GraphRequest) it.next()).getCallback() instanceof OnProgressCallback) {
                AppMethodBeat.o(17140);
                return true;
            }
        }
        AppMethodBeat.o(17140);
        return false;
    }

    private static void setConnectionContentType(HttpURLConnection httpURLConnection, boolean z) {
        AppMethodBeat.i(17141);
        if (z) {
            httpURLConnection.setRequestProperty(CONTENT_TYPE_HEADER, "application/x-www-form-urlencoded");
            httpURLConnection.setRequestProperty(CONTENT_ENCODING_HEADER, "gzip");
            AppMethodBeat.o(17141);
            return;
        }
        httpURLConnection.setRequestProperty(CONTENT_TYPE_HEADER, getMimeContentType());
        AppMethodBeat.o(17141);
    }

    private static boolean isGzipCompressible(GraphRequestBatch graphRequestBatch) {
        AppMethodBeat.i(17142);
        Iterator it = graphRequestBatch.iterator();
        while (it.hasNext()) {
            GraphRequest graphRequest = (GraphRequest) it.next();
            Iterator<String> it2 = graphRequest.parameters.keySet().iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (isSupportedAttachmentType(graphRequest.parameters.get(it2.next()))) {
                        AppMethodBeat.o(17142);
                        return false;
                    }
                }
            }
        }
        AppMethodBeat.o(17142);
        return true;
    }

    static final boolean shouldWarnOnMissingFieldsParam(GraphRequest graphRequest) {
        AppMethodBeat.i(17143);
        String version2 = graphRequest.getVersion();
        if (Utility.isNullOrEmpty(version2)) {
            AppMethodBeat.o(17143);
            return true;
        }
        if (version2.startsWith("v")) {
            version2 = version2.substring(1);
        }
        String[] split = version2.split("\\.");
        if ((split.length < 2 || Integer.parseInt(split[0]) <= 2) && (Integer.parseInt(split[0]) < 2 || Integer.parseInt(split[1]) < 4)) {
            AppMethodBeat.o(17143);
            return false;
        }
        AppMethodBeat.o(17143);
        return true;
    }

    static final void validateFieldsParamForGetRequests(GraphRequestBatch graphRequestBatch) {
        AppMethodBeat.i(17144);
        Iterator it = graphRequestBatch.iterator();
        while (it.hasNext()) {
            GraphRequest graphRequest = (GraphRequest) it.next();
            if (HttpMethod.GET.equals(graphRequest.getHttpMethod()) && shouldWarnOnMissingFieldsParam(graphRequest)) {
                Bundle parameters2 = graphRequest.getParameters();
                if (!parameters2.containsKey(FIELDS_PARAM) || Utility.isNullOrEmpty(parameters2.getString(FIELDS_PARAM))) {
                    Logger.log(LoggingBehavior.DEVELOPER_ERRORS, 5, "Request", "starting with Graph API v2.4, GET requests for /%s should contain an explicit \"fields\" parameter.", graphRequest.getGraphPath());
                }
            }
        }
        AppMethodBeat.o(17144);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00d6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static final void serializeToUrlConnection(com.facebook.GraphRequestBatch r14, java.net.HttpURLConnection r15) {
        /*
        // Method dump skipped, instructions count: 228
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.GraphRequest.serializeToUrlConnection(com.facebook.GraphRequestBatch, java.net.HttpURLConnection):void");
    }

    private static void processRequest(GraphRequestBatch graphRequestBatch, Logger logger, int i2, URL url, OutputStream outputStream, boolean z) {
        AppMethodBeat.i(17146);
        Serializer serializer = new Serializer(outputStream, logger, z);
        if (i2 == 1) {
            GraphRequest graphRequest = graphRequestBatch.get(0);
            HashMap hashMap = new HashMap();
            for (String str : graphRequest.parameters.keySet()) {
                Object obj = graphRequest.parameters.get(str);
                if (isSupportedAttachmentType(obj)) {
                    hashMap.put(str, new Attachment(graphRequest, obj));
                }
            }
            if (logger != null) {
                logger.append("  Parameters:\n");
            }
            serializeParameters(graphRequest.parameters, serializer, graphRequest);
            if (logger != null) {
                logger.append("  Attachments:\n");
            }
            serializeAttachments(hashMap, serializer);
            if (graphRequest.graphObject != null) {
                processGraphObject(graphRequest.graphObject, url.getPath(), serializer);
            }
            AppMethodBeat.o(17146);
            return;
        }
        String batchAppId = getBatchAppId(graphRequestBatch);
        if (Utility.isNullOrEmpty(batchAppId)) {
            FacebookException facebookException = new FacebookException("App ID was not specified at the request or Settings.");
            AppMethodBeat.o(17146);
            throw facebookException;
        }
        serializer.writeString(BATCH_APP_ID_PARAM, batchAppId);
        HashMap hashMap2 = new HashMap();
        serializeRequestsAsJSON(serializer, graphRequestBatch, hashMap2);
        if (logger != null) {
            logger.append("  Attachments:\n");
        }
        serializeAttachments(hashMap2, serializer);
        AppMethodBeat.o(17146);
    }

    private static boolean isMeRequest(String str) {
        AppMethodBeat.i(17147);
        Matcher matcher = versionPattern.matcher(str);
        if (matcher.matches()) {
            str = matcher.group(1);
        }
        if (str.startsWith("me/") || str.startsWith("/me/")) {
            AppMethodBeat.o(17147);
            return true;
        }
        AppMethodBeat.o(17147);
        return false;
    }

    private static void processGraphObject(JSONObject jSONObject, String str, KeyValueSerializer keyValueSerializer) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(17148);
        if (isMeRequest(str)) {
            int indexOf = str.indexOf(":");
            int indexOf2 = str.indexOf("?");
            z = indexOf > 3 && (indexOf2 == -1 || indexOf < indexOf2);
        } else {
            z = false;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object opt = jSONObject.opt(next);
            if (!z || !next.equalsIgnoreCase("image")) {
                z2 = false;
            } else {
                z2 = true;
            }
            processGraphObjectProperty(next, opt, keyValueSerializer, z2);
        }
        AppMethodBeat.o(17148);
    }

    private static void processGraphObjectProperty(String str, Object obj, KeyValueSerializer keyValueSerializer, boolean z) {
        AppMethodBeat.i(17149);
        String str2 = obj;
        while (true) {
            Class<?> cls = str2.getClass();
            if (JSONObject.class.isAssignableFrom(cls)) {
                JSONObject jSONObject = (JSONObject) str2;
                if (z) {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        processGraphObjectProperty(String.format("%s[%s]", str, next), jSONObject.opt(next), keyValueSerializer, z);
                    }
                    AppMethodBeat.o(17149);
                    return;
                } else if (jSONObject.has("id")) {
                    str2 = jSONObject.optString("id");
                } else if (jSONObject.has("url")) {
                    str2 = jSONObject.optString("url");
                } else if (jSONObject.has(NativeProtocol.OPEN_GRAPH_CREATE_OBJECT_KEY)) {
                    str2 = jSONObject.toString();
                } else {
                    AppMethodBeat.o(17149);
                    return;
                }
            } else if (JSONArray.class.isAssignableFrom(cls)) {
                JSONArray jSONArray = (JSONArray) str2;
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    processGraphObjectProperty(String.format(Locale.ROOT, "%s[%d]", str, Integer.valueOf(i2)), jSONArray.opt(i2), keyValueSerializer, z);
                }
                AppMethodBeat.o(17149);
                return;
            } else if (String.class.isAssignableFrom(cls) || Number.class.isAssignableFrom(cls) || Boolean.class.isAssignableFrom(cls)) {
                keyValueSerializer.writeString(str, str2.toString());
                AppMethodBeat.o(17149);
                return;
            } else {
                if (Date.class.isAssignableFrom(cls)) {
                    keyValueSerializer.writeString(str, new SimpleDateFormat(ISO_8601_FORMAT_STRING, Locale.US).format((Date) str2));
                }
                AppMethodBeat.o(17149);
                return;
            }
        }
    }

    private static void serializeParameters(Bundle bundle, Serializer serializer, GraphRequest graphRequest) {
        AppMethodBeat.i(17150);
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (isSupportedParameterType(obj)) {
                serializer.writeObject(str, obj, graphRequest);
            }
        }
        AppMethodBeat.o(17150);
    }

    private static void serializeAttachments(Map<String, Attachment> map, Serializer serializer) {
        AppMethodBeat.i(17151);
        for (String str : map.keySet()) {
            Attachment attachment = map.get(str);
            if (isSupportedAttachmentType(attachment.getValue())) {
                serializer.writeObject(str, attachment.getValue(), attachment.getRequest());
            }
        }
        AppMethodBeat.o(17151);
    }

    private static void serializeRequestsAsJSON(Serializer serializer, Collection<GraphRequest> collection, Map<String, Attachment> map) {
        AppMethodBeat.i(17152);
        JSONArray jSONArray = new JSONArray();
        for (GraphRequest graphRequest : collection) {
            graphRequest.serializeToBatch(jSONArray, map);
        }
        serializer.writeRequestsAsJson("batch", jSONArray, collection);
        AppMethodBeat.o(17152);
    }

    private static String getMimeContentType() {
        AppMethodBeat.i(17153);
        String format = String.format("multipart/form-data; boundary=%s", MIME_BOUNDARY);
        AppMethodBeat.o(17153);
        return format;
    }

    private static String getUserAgent() {
        AppMethodBeat.i(17154);
        if (userAgent == null) {
            userAgent = String.format("%s.%s", USER_AGENT_BASE, FacebookSdkVersion.BUILD);
            String customUserAgent = InternalSettings.getCustomUserAgent();
            if (!Utility.isNullOrEmpty(customUserAgent)) {
                userAgent = String.format(Locale.ROOT, GRAPH_PATH_FORMAT, userAgent, customUserAgent);
            }
        }
        String str = userAgent;
        AppMethodBeat.o(17154);
        return str;
    }

    private static String getBatchAppId(GraphRequestBatch graphRequestBatch) {
        String applicationId;
        AppMethodBeat.i(17155);
        if (!Utility.isNullOrEmpty(graphRequestBatch.getBatchApplicationId())) {
            String batchApplicationId = graphRequestBatch.getBatchApplicationId();
            AppMethodBeat.o(17155);
            return batchApplicationId;
        }
        Iterator it = graphRequestBatch.iterator();
        while (it.hasNext()) {
            AccessToken accessToken2 = ((GraphRequest) it.next()).accessToken;
            if (accessToken2 != null && (applicationId = accessToken2.getApplicationId()) != null) {
                AppMethodBeat.o(17155);
                return applicationId;
            }
        }
        if (!Utility.isNullOrEmpty(defaultBatchApplicationId)) {
            String str = defaultBatchApplicationId;
            AppMethodBeat.o(17155);
            return str;
        }
        String applicationId2 = FacebookSdk.getApplicationId();
        AppMethodBeat.o(17155);
        return applicationId2;
    }

    private static boolean isSupportedAttachmentType(Object obj) {
        return (obj instanceof Bitmap) || (obj instanceof byte[]) || (obj instanceof Uri) || (obj instanceof ParcelFileDescriptor) || (obj instanceof ParcelableResourceWithMimeType);
    }

    private static boolean isSupportedParameterType(Object obj) {
        return (obj instanceof String) || (obj instanceof Boolean) || (obj instanceof Number) || (obj instanceof Date);
    }

    private static String parameterToString(Object obj) {
        AppMethodBeat.i(17156);
        if (obj instanceof String) {
            String str = (String) obj;
            AppMethodBeat.o(17156);
            return str;
        } else if ((obj instanceof Boolean) || (obj instanceof Number)) {
            String obj2 = obj.toString();
            AppMethodBeat.o(17156);
            return obj2;
        } else if (obj instanceof Date) {
            String format = new SimpleDateFormat(ISO_8601_FORMAT_STRING, Locale.US).format(obj);
            AppMethodBeat.o(17156);
            return format;
        } else {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unsupported parameter type.");
            AppMethodBeat.o(17156);
            throw illegalArgumentException;
        }
    }

    /* access modifiers changed from: package-private */
    public static class Serializer implements KeyValueSerializer {
        private boolean firstWrite = true;
        private final Logger logger;
        private final OutputStream outputStream;
        private boolean useUrlEncode = false;

        public Serializer(OutputStream outputStream2, Logger logger2, boolean z) {
            this.outputStream = outputStream2;
            this.logger = logger2;
            this.useUrlEncode = z;
        }

        public void writeObject(String str, Object obj, GraphRequest graphRequest) {
            AppMethodBeat.i(17088);
            if (this.outputStream instanceof RequestOutputStream) {
                ((RequestOutputStream) this.outputStream).setCurrentRequest(graphRequest);
            }
            if (GraphRequest.access$000(obj)) {
                writeString(str, GraphRequest.access$100(obj));
                AppMethodBeat.o(17088);
            } else if (obj instanceof Bitmap) {
                writeBitmap(str, (Bitmap) obj);
                AppMethodBeat.o(17088);
            } else if (obj instanceof byte[]) {
                writeBytes(str, (byte[]) obj);
                AppMethodBeat.o(17088);
            } else if (obj instanceof Uri) {
                writeContentUri(str, (Uri) obj, null);
                AppMethodBeat.o(17088);
            } else if (obj instanceof ParcelFileDescriptor) {
                writeFile(str, (ParcelFileDescriptor) obj, null);
                AppMethodBeat.o(17088);
            } else if (obj instanceof ParcelableResourceWithMimeType) {
                ParcelableResourceWithMimeType parcelableResourceWithMimeType = (ParcelableResourceWithMimeType) obj;
                Parcelable resource = parcelableResourceWithMimeType.getResource();
                String mimeType = parcelableResourceWithMimeType.getMimeType();
                if (resource instanceof ParcelFileDescriptor) {
                    writeFile(str, (ParcelFileDescriptor) resource, mimeType);
                    AppMethodBeat.o(17088);
                } else if (resource instanceof Uri) {
                    writeContentUri(str, (Uri) resource, mimeType);
                    AppMethodBeat.o(17088);
                } else {
                    RuntimeException invalidTypeError = getInvalidTypeError();
                    AppMethodBeat.o(17088);
                    throw invalidTypeError;
                }
            } else {
                RuntimeException invalidTypeError2 = getInvalidTypeError();
                AppMethodBeat.o(17088);
                throw invalidTypeError2;
            }
        }

        private RuntimeException getInvalidTypeError() {
            AppMethodBeat.i(17089);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("value is not a supported type.");
            AppMethodBeat.o(17089);
            return illegalArgumentException;
        }

        public void writeRequestsAsJson(String str, JSONArray jSONArray, Collection<GraphRequest> collection) {
            AppMethodBeat.i(17090);
            if (!(this.outputStream instanceof RequestOutputStream)) {
                writeString(str, jSONArray.toString());
                AppMethodBeat.o(17090);
                return;
            }
            RequestOutputStream requestOutputStream = (RequestOutputStream) this.outputStream;
            writeContentDisposition(str, null, null);
            write("[", new Object[0]);
            int i2 = 0;
            for (GraphRequest graphRequest : collection) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                requestOutputStream.setCurrentRequest(graphRequest);
                if (i2 > 0) {
                    write(",%s", jSONObject.toString());
                } else {
                    write("%s", jSONObject.toString());
                }
                i2++;
            }
            write("]", new Object[0]);
            if (this.logger != null) {
                this.logger.appendKeyValue("    ".concat(String.valueOf(str)), jSONArray.toString());
            }
            AppMethodBeat.o(17090);
        }

        @Override // com.facebook.GraphRequest.KeyValueSerializer
        public void writeString(String str, String str2) {
            AppMethodBeat.i(17091);
            writeContentDisposition(str, null, null);
            writeLine("%s", str2);
            writeRecordBoundary();
            if (this.logger != null) {
                this.logger.appendKeyValue("    ".concat(String.valueOf(str)), str2);
            }
            AppMethodBeat.o(17091);
        }

        public void writeBitmap(String str, Bitmap bitmap) {
            AppMethodBeat.i(17092);
            writeContentDisposition(str, str, "image/png");
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, this.outputStream);
            writeLine("", new Object[0]);
            writeRecordBoundary();
            if (this.logger != null) {
                this.logger.appendKeyValue("    ".concat(String.valueOf(str)), "<Image>");
            }
            AppMethodBeat.o(17092);
        }

        public void writeBytes(String str, byte[] bArr) {
            AppMethodBeat.i(17093);
            writeContentDisposition(str, str, "content/unknown");
            this.outputStream.write(bArr);
            writeLine("", new Object[0]);
            writeRecordBoundary();
            if (this.logger != null) {
                this.logger.appendKeyValue("    ".concat(String.valueOf(str)), String.format(Locale.ROOT, "<Data: %d>", Integer.valueOf(bArr.length)));
            }
            AppMethodBeat.o(17093);
        }

        public void writeContentUri(String str, Uri uri, String str2) {
            int copyAndCloseInputStream;
            AppMethodBeat.i(17094);
            if (str2 == null) {
                str2 = "content/unknown";
            }
            writeContentDisposition(str, str, str2);
            if (this.outputStream instanceof ProgressNoopOutputStream) {
                ((ProgressNoopOutputStream) this.outputStream).addProgress(Utility.getContentSize(uri));
                copyAndCloseInputStream = 0;
            } else {
                copyAndCloseInputStream = Utility.copyAndCloseInputStream(FacebookSdk.getApplicationContext().getContentResolver().openInputStream(uri), this.outputStream) + 0;
            }
            writeLine("", new Object[0]);
            writeRecordBoundary();
            if (this.logger != null) {
                this.logger.appendKeyValue("    ".concat(String.valueOf(str)), String.format(Locale.ROOT, "<Data: %d>", Integer.valueOf(copyAndCloseInputStream)));
            }
            AppMethodBeat.o(17094);
        }

        public void writeFile(String str, ParcelFileDescriptor parcelFileDescriptor, String str2) {
            int copyAndCloseInputStream;
            AppMethodBeat.i(17095);
            if (str2 == null) {
                str2 = "content/unknown";
            }
            writeContentDisposition(str, str, str2);
            if (this.outputStream instanceof ProgressNoopOutputStream) {
                ((ProgressNoopOutputStream) this.outputStream).addProgress(parcelFileDescriptor.getStatSize());
                copyAndCloseInputStream = 0;
            } else {
                copyAndCloseInputStream = Utility.copyAndCloseInputStream(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor), this.outputStream) + 0;
            }
            writeLine("", new Object[0]);
            writeRecordBoundary();
            if (this.logger != null) {
                this.logger.appendKeyValue("    ".concat(String.valueOf(str)), String.format(Locale.ROOT, "<Data: %d>", Integer.valueOf(copyAndCloseInputStream)));
            }
            AppMethodBeat.o(17095);
        }

        public void writeRecordBoundary() {
            AppMethodBeat.i(17096);
            if (!this.useUrlEncode) {
                writeLine("--%s", GraphRequest.MIME_BOUNDARY);
                AppMethodBeat.o(17096);
                return;
            }
            this.outputStream.write("&".getBytes());
            AppMethodBeat.o(17096);
        }

        public void writeContentDisposition(String str, String str2, String str3) {
            AppMethodBeat.i(17097);
            if (!this.useUrlEncode) {
                write("Content-Disposition: form-data; name=\"%s\"", str);
                if (str2 != null) {
                    write("; filename=\"%s\"", str2);
                }
                writeLine("", new Object[0]);
                if (str3 != null) {
                    writeLine("%s: %s", GraphRequest.CONTENT_TYPE_HEADER, str3);
                }
                writeLine("", new Object[0]);
                AppMethodBeat.o(17097);
                return;
            }
            this.outputStream.write(String.format("%s=", str).getBytes());
            AppMethodBeat.o(17097);
        }

        public void write(String str, Object... objArr) {
            AppMethodBeat.i(17098);
            if (!this.useUrlEncode) {
                if (this.firstWrite) {
                    this.outputStream.write("--".getBytes());
                    this.outputStream.write(GraphRequest.MIME_BOUNDARY.getBytes());
                    this.outputStream.write(APLogFileUtil.SEPARATOR_LINE.getBytes());
                    this.firstWrite = false;
                }
                this.outputStream.write(String.format(str, objArr).getBytes());
                AppMethodBeat.o(17098);
                return;
            }
            this.outputStream.write(URLEncoder.encode(String.format(Locale.US, str, objArr), MimeTypeUtil.ContentType.DEFAULT_CHARSET).getBytes());
            AppMethodBeat.o(17098);
        }

        public void writeLine(String str, Object... objArr) {
            AppMethodBeat.i(17099);
            write(str, objArr);
            if (!this.useUrlEncode) {
                write(APLogFileUtil.SEPARATOR_LINE, new Object[0]);
            }
            AppMethodBeat.o(17099);
        }
    }

    public static class ParcelableResourceWithMimeType<RESOURCE extends Parcelable> implements Parcelable {
        public static final Parcelable.Creator<ParcelableResourceWithMimeType> CREATOR = new Parcelable.Creator<ParcelableResourceWithMimeType>() {
            /* class com.facebook.GraphRequest.ParcelableResourceWithMimeType.AnonymousClass1 */

            @Override // android.os.Parcelable.Creator
            public final ParcelableResourceWithMimeType createFromParcel(Parcel parcel) {
                AppMethodBeat.i(17082);
                ParcelableResourceWithMimeType parcelableResourceWithMimeType = new ParcelableResourceWithMimeType(parcel);
                AppMethodBeat.o(17082);
                return parcelableResourceWithMimeType;
            }

            @Override // android.os.Parcelable.Creator
            public final ParcelableResourceWithMimeType[] newArray(int i2) {
                return new ParcelableResourceWithMimeType[i2];
            }
        };
        private final String mimeType;
        private final RESOURCE resource;

        public String getMimeType() {
            return this.mimeType;
        }

        public RESOURCE getResource() {
            return this.resource;
        }

        public int describeContents() {
            return 1;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(17085);
            parcel.writeString(this.mimeType);
            parcel.writeParcelable(this.resource, i2);
            AppMethodBeat.o(17085);
        }

        static {
            AppMethodBeat.i(17087);
            AppMethodBeat.o(17087);
        }

        public ParcelableResourceWithMimeType(RESOURCE resource2, String str) {
            this.mimeType = str;
            this.resource = resource2;
        }

        private ParcelableResourceWithMimeType(Parcel parcel) {
            AppMethodBeat.i(17086);
            this.mimeType = parcel.readString();
            this.resource = (RESOURCE) parcel.readParcelable(FacebookSdk.getApplicationContext().getClassLoader());
            AppMethodBeat.o(17086);
        }
    }
}
