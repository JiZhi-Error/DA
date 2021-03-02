package com.facebook;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class AccessToken implements Parcelable {
    public static final String ACCESS_TOKEN_KEY = "access_token";
    private static final String APPLICATION_ID_KEY = "application_id";
    public static final Parcelable.Creator<AccessToken> CREATOR = new Parcelable.Creator() {
        /* class com.facebook.AccessToken.AnonymousClass2 */

        @Override // android.os.Parcelable.Creator
        public final AccessToken createFromParcel(Parcel parcel) {
            AppMethodBeat.i(16946);
            AccessToken accessToken = new AccessToken(parcel);
            AppMethodBeat.o(16946);
            return accessToken;
        }

        @Override // android.os.Parcelable.Creator
        public final AccessToken[] newArray(int i2) {
            return new AccessToken[i2];
        }
    };
    private static final int CURRENT_JSON_FORMAT = 1;
    public static final String DATA_ACCESS_EXPIRATION_TIME = "data_access_expiration_time";
    private static final String DECLINED_PERMISSIONS_KEY = "declined_permissions";
    private static final AccessTokenSource DEFAULT_ACCESS_TOKEN_SOURCE = AccessTokenSource.FACEBOOK_APPLICATION_WEB;
    private static final Date DEFAULT_EXPIRATION_TIME;
    private static final Date DEFAULT_LAST_REFRESH_TIME = new Date();
    private static final String EXPIRES_AT_KEY = "expires_at";
    public static final String EXPIRES_IN_KEY = "expires_in";
    private static final String LAST_REFRESH_KEY = "last_refresh";
    private static final Date MAX_DATE;
    private static final String PERMISSIONS_KEY = "permissions";
    private static final String SOURCE_KEY = "source";
    private static final String TOKEN_KEY = "token";
    public static final String USER_ID_KEY = "user_id";
    private static final String VERSION_KEY = "version";
    private final String applicationId;
    private final Date dataAccessExpirationTime;
    private final Set<String> declinedPermissions;
    private final Date expires;
    private final Date lastRefresh;
    private final Set<String> permissions;
    private final AccessTokenSource source;
    private final String token;
    private final String userId;

    public interface AccessTokenCreationCallback {
        void onError(FacebookException facebookException);

        void onSuccess(AccessToken accessToken);
    }

    public interface AccessTokenRefreshCallback {
        void OnTokenRefreshFailed(FacebookException facebookException);

        void OnTokenRefreshed(AccessToken accessToken);
    }

    static /* synthetic */ AccessToken access$000(List list, Bundle bundle, AccessTokenSource accessTokenSource, Date date, String str) {
        AppMethodBeat.i(16974);
        AccessToken createFromBundle = createFromBundle(list, bundle, accessTokenSource, date, str);
        AppMethodBeat.o(16974);
        return createFromBundle;
    }

    static {
        AppMethodBeat.i(16975);
        Date date = new Date((long) MAlarmHandler.NEXT_FIRE_INTERVAL);
        MAX_DATE = date;
        DEFAULT_EXPIRATION_TIME = date;
        AppMethodBeat.o(16975);
    }

    public AccessToken(String str, String str2, String str3, Collection<String> collection, Collection<String> collection2, AccessTokenSource accessTokenSource, Date date, Date date2, Date date3) {
        AppMethodBeat.i(16949);
        Validate.notNullOrEmpty(str, "accessToken");
        Validate.notNullOrEmpty(str2, "applicationId");
        Validate.notNullOrEmpty(str3, "userId");
        this.expires = date == null ? DEFAULT_EXPIRATION_TIME : date;
        this.permissions = Collections.unmodifiableSet(collection != null ? new HashSet(collection) : new HashSet());
        this.declinedPermissions = Collections.unmodifiableSet(collection2 != null ? new HashSet(collection2) : new HashSet());
        this.token = str;
        this.source = accessTokenSource == null ? DEFAULT_ACCESS_TOKEN_SOURCE : accessTokenSource;
        this.lastRefresh = date2 == null ? DEFAULT_LAST_REFRESH_TIME : date2;
        this.applicationId = str2;
        this.userId = str3;
        this.dataAccessExpirationTime = (date3 == null || date3.getTime() == 0) ? DEFAULT_EXPIRATION_TIME : date3;
        AppMethodBeat.o(16949);
    }

    public static AccessToken getCurrentAccessToken() {
        AppMethodBeat.i(16950);
        AccessToken currentAccessToken = AccessTokenManager.getInstance().getCurrentAccessToken();
        AppMethodBeat.o(16950);
        return currentAccessToken;
    }

    public static boolean isCurrentAccessTokenActive() {
        AppMethodBeat.i(16951);
        AccessToken currentAccessToken = AccessTokenManager.getInstance().getCurrentAccessToken();
        if (currentAccessToken == null || currentAccessToken.isExpired()) {
            AppMethodBeat.o(16951);
            return false;
        }
        AppMethodBeat.o(16951);
        return true;
    }

    public static boolean isDataAccessActive() {
        AppMethodBeat.i(16952);
        AccessToken currentAccessToken = AccessTokenManager.getInstance().getCurrentAccessToken();
        if (currentAccessToken == null || currentAccessToken.isDataAccessExpired()) {
            AppMethodBeat.o(16952);
            return false;
        }
        AppMethodBeat.o(16952);
        return true;
    }

    static void expireCurrentAccessToken() {
        AppMethodBeat.i(16953);
        AccessToken currentAccessToken = AccessTokenManager.getInstance().getCurrentAccessToken();
        if (currentAccessToken != null) {
            setCurrentAccessToken(createExpired(currentAccessToken));
        }
        AppMethodBeat.o(16953);
    }

    public static void setCurrentAccessToken(AccessToken accessToken) {
        AppMethodBeat.i(16954);
        AccessTokenManager.getInstance().setCurrentAccessToken(accessToken);
        AppMethodBeat.o(16954);
    }

    public static void refreshCurrentAccessTokenAsync() {
        AppMethodBeat.i(16955);
        AccessTokenManager.getInstance().refreshCurrentAccessToken(null);
        AppMethodBeat.o(16955);
    }

    public static void refreshCurrentAccessTokenAsync(AccessTokenRefreshCallback accessTokenRefreshCallback) {
        AppMethodBeat.i(16956);
        AccessTokenManager.getInstance().refreshCurrentAccessToken(accessTokenRefreshCallback);
        AppMethodBeat.o(16956);
    }

    public final String getToken() {
        return this.token;
    }

    public final Date getExpires() {
        return this.expires;
    }

    public final Date getDataAccessExpirationTime() {
        return this.dataAccessExpirationTime;
    }

    public final Set<String> getPermissions() {
        return this.permissions;
    }

    public final Set<String> getDeclinedPermissions() {
        return this.declinedPermissions;
    }

    public final AccessTokenSource getSource() {
        return this.source;
    }

    public final Date getLastRefresh() {
        return this.lastRefresh;
    }

    public final String getApplicationId() {
        return this.applicationId;
    }

    public final String getUserId() {
        return this.userId;
    }

    public static void createFromNativeLinkingIntent(Intent intent, final String str, final AccessTokenCreationCallback accessTokenCreationCallback) {
        AppMethodBeat.i(16957);
        Validate.notNull(intent, "intent");
        if (intent.getExtras() == null) {
            accessTokenCreationCallback.onError(new FacebookException("No extras found on intent"));
            AppMethodBeat.o(16957);
            return;
        }
        final Bundle bundle = new Bundle(intent.getExtras());
        String string = bundle.getString("access_token");
        if (string == null || string.isEmpty()) {
            accessTokenCreationCallback.onError(new FacebookException("No access token found on intent"));
            AppMethodBeat.o(16957);
            return;
        }
        String string2 = bundle.getString(USER_ID_KEY);
        if (string2 == null || string2.isEmpty()) {
            Utility.getGraphMeRequestWithCacheAsync(string, new Utility.GraphMeRequestWithCacheCallback() {
                /* class com.facebook.AccessToken.AnonymousClass1 */

                @Override // com.facebook.internal.Utility.GraphMeRequestWithCacheCallback
                public final void onSuccess(JSONObject jSONObject) {
                    AppMethodBeat.i(16944);
                    try {
                        bundle.putString(AccessToken.USER_ID_KEY, jSONObject.getString("id"));
                        accessTokenCreationCallback.onSuccess(AccessToken.access$000(null, bundle, AccessTokenSource.FACEBOOK_APPLICATION_WEB, new Date(), str));
                        AppMethodBeat.o(16944);
                    } catch (JSONException e2) {
                        accessTokenCreationCallback.onError(new FacebookException("Unable to generate access token due to missing user id"));
                        AppMethodBeat.o(16944);
                    }
                }

                @Override // com.facebook.internal.Utility.GraphMeRequestWithCacheCallback
                public final void onFailure(FacebookException facebookException) {
                    AppMethodBeat.i(16945);
                    accessTokenCreationCallback.onError(facebookException);
                    AppMethodBeat.o(16945);
                }
            });
            AppMethodBeat.o(16957);
            return;
        }
        accessTokenCreationCallback.onSuccess(createFromBundle(null, bundle, AccessTokenSource.FACEBOOK_APPLICATION_WEB, new Date(), str));
        AppMethodBeat.o(16957);
    }

    public final String toString() {
        AppMethodBeat.i(16958);
        StringBuilder sb = new StringBuilder();
        sb.append("{AccessToken");
        sb.append(" token:").append(tokenToString());
        appendPermissions(sb);
        sb.append("}");
        String sb2 = sb.toString();
        AppMethodBeat.o(16958);
        return sb2;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(16959);
        if (this == obj) {
            AppMethodBeat.o(16959);
            return true;
        } else if (!(obj instanceof AccessToken)) {
            AppMethodBeat.o(16959);
            return false;
        } else {
            AccessToken accessToken = (AccessToken) obj;
            if (!this.expires.equals(accessToken.expires) || !this.permissions.equals(accessToken.permissions) || !this.declinedPermissions.equals(accessToken.declinedPermissions) || !this.token.equals(accessToken.token) || this.source != accessToken.source || !this.lastRefresh.equals(accessToken.lastRefresh) || (this.applicationId != null ? !this.applicationId.equals(accessToken.applicationId) : accessToken.applicationId != null) || !this.userId.equals(accessToken.userId) || !this.dataAccessExpirationTime.equals(accessToken.dataAccessExpirationTime)) {
                AppMethodBeat.o(16959);
                return false;
            }
            AppMethodBeat.o(16959);
            return true;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(16960);
        int hashCode = (((((this.applicationId == null ? 0 : this.applicationId.hashCode()) + ((((((((((((this.expires.hashCode() + JsApiGetABTestConfig.CTRL_INDEX) * 31) + this.permissions.hashCode()) * 31) + this.declinedPermissions.hashCode()) * 31) + this.token.hashCode()) * 31) + this.source.hashCode()) * 31) + this.lastRefresh.hashCode()) * 31)) * 31) + this.userId.hashCode()) * 31) + this.dataAccessExpirationTime.hashCode();
        AppMethodBeat.o(16960);
        return hashCode;
    }

    @SuppressLint({"FieldGetter"})
    static AccessToken createFromRefresh(AccessToken accessToken, Bundle bundle) {
        AppMethodBeat.i(16961);
        if (accessToken.source == AccessTokenSource.FACEBOOK_APPLICATION_WEB || accessToken.source == AccessTokenSource.FACEBOOK_APPLICATION_NATIVE || accessToken.source == AccessTokenSource.FACEBOOK_APPLICATION_SERVICE) {
            Date bundleLongAsDate = Utility.getBundleLongAsDate(bundle, EXPIRES_IN_KEY, new Date(0));
            String string = bundle.getString("access_token");
            Date bundleLongAsDate2 = Utility.getBundleLongAsDate(bundle, DATA_ACCESS_EXPIRATION_TIME, new Date(0));
            if (Utility.isNullOrEmpty(string)) {
                AppMethodBeat.o(16961);
                return null;
            }
            AccessToken accessToken2 = new AccessToken(string, accessToken.applicationId, accessToken.getUserId(), accessToken.getPermissions(), accessToken.getDeclinedPermissions(), accessToken.source, bundleLongAsDate, new Date(), bundleLongAsDate2);
            AppMethodBeat.o(16961);
            return accessToken2;
        }
        FacebookException facebookException = new FacebookException("Invalid token source: " + accessToken.source);
        AppMethodBeat.o(16961);
        throw facebookException;
    }

    static AccessToken createExpired(AccessToken accessToken) {
        AppMethodBeat.i(16962);
        AccessToken accessToken2 = new AccessToken(accessToken.token, accessToken.applicationId, accessToken.getUserId(), accessToken.getPermissions(), accessToken.getDeclinedPermissions(), accessToken.source, new Date(), new Date(), accessToken.dataAccessExpirationTime);
        AppMethodBeat.o(16962);
        return accessToken2;
    }

    static AccessToken createFromLegacyCache(Bundle bundle) {
        AppMethodBeat.i(16963);
        List<String> permissionsFromBundle = getPermissionsFromBundle(bundle, LegacyTokenHelper.PERMISSIONS_KEY);
        List<String> permissionsFromBundle2 = getPermissionsFromBundle(bundle, LegacyTokenHelper.DECLINED_PERMISSIONS_KEY);
        String applicationId2 = LegacyTokenHelper.getApplicationId(bundle);
        if (Utility.isNullOrEmpty(applicationId2)) {
            applicationId2 = FacebookSdk.getApplicationId();
        }
        String token2 = LegacyTokenHelper.getToken(bundle);
        try {
            AccessToken accessToken = new AccessToken(token2, applicationId2, Utility.awaitGetGraphMeRequestWithCache(token2).getString("id"), permissionsFromBundle, permissionsFromBundle2, LegacyTokenHelper.getSource(bundle), LegacyTokenHelper.getDate(bundle, LegacyTokenHelper.EXPIRATION_DATE_KEY), LegacyTokenHelper.getDate(bundle, LegacyTokenHelper.LAST_REFRESH_DATE_KEY), null);
            AppMethodBeat.o(16963);
            return accessToken;
        } catch (JSONException e2) {
            AppMethodBeat.o(16963);
            return null;
        }
    }

    static List<String> getPermissionsFromBundle(Bundle bundle, String str) {
        List<String> unmodifiableList;
        AppMethodBeat.i(16964);
        ArrayList<String> stringArrayList = bundle.getStringArrayList(str);
        if (stringArrayList == null) {
            unmodifiableList = Collections.emptyList();
        } else {
            unmodifiableList = Collections.unmodifiableList(new ArrayList(stringArrayList));
        }
        AppMethodBeat.o(16964);
        return unmodifiableList;
    }

    public final boolean isExpired() {
        AppMethodBeat.i(16965);
        boolean after = new Date().after(this.expires);
        AppMethodBeat.o(16965);
        return after;
    }

    public final boolean isDataAccessExpired() {
        AppMethodBeat.i(16966);
        boolean after = new Date().after(this.dataAccessExpirationTime);
        AppMethodBeat.o(16966);
        return after;
    }

    /* access modifiers changed from: package-private */
    public final JSONObject toJSONObject() {
        AppMethodBeat.i(16967);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("version", 1);
        jSONObject.put(TOKEN_KEY, this.token);
        jSONObject.put(EXPIRES_AT_KEY, this.expires.getTime());
        jSONObject.put("permissions", new JSONArray((Collection) this.permissions));
        jSONObject.put(DECLINED_PERMISSIONS_KEY, new JSONArray((Collection) this.declinedPermissions));
        jSONObject.put(LAST_REFRESH_KEY, this.lastRefresh.getTime());
        jSONObject.put("source", this.source.name());
        jSONObject.put(APPLICATION_ID_KEY, this.applicationId);
        jSONObject.put(USER_ID_KEY, this.userId);
        jSONObject.put(DATA_ACCESS_EXPIRATION_TIME, this.dataAccessExpirationTime.getTime());
        AppMethodBeat.o(16967);
        return jSONObject;
    }

    static AccessToken createFromJSONObject(JSONObject jSONObject) {
        AppMethodBeat.i(16968);
        if (jSONObject.getInt("version") > 1) {
            FacebookException facebookException = new FacebookException("Unknown AccessToken serialization format.");
            AppMethodBeat.o(16968);
            throw facebookException;
        }
        String string = jSONObject.getString(TOKEN_KEY);
        Date date = new Date(jSONObject.getLong(EXPIRES_AT_KEY));
        JSONArray jSONArray = jSONObject.getJSONArray("permissions");
        JSONArray jSONArray2 = jSONObject.getJSONArray(DECLINED_PERMISSIONS_KEY);
        Date date2 = new Date(jSONObject.getLong(LAST_REFRESH_KEY));
        AccessTokenSource valueOf = AccessTokenSource.valueOf(jSONObject.getString("source"));
        AccessToken accessToken = new AccessToken(string, jSONObject.getString(APPLICATION_ID_KEY), jSONObject.getString(USER_ID_KEY), Utility.jsonArrayToStringList(jSONArray), Utility.jsonArrayToStringList(jSONArray2), valueOf, date, date2, new Date(jSONObject.getLong(DATA_ACCESS_EXPIRATION_TIME)));
        AppMethodBeat.o(16968);
        return accessToken;
    }

    private static AccessToken createFromBundle(List<String> list, Bundle bundle, AccessTokenSource accessTokenSource, Date date, String str) {
        AppMethodBeat.i(16969);
        String string = bundle.getString("access_token");
        Date bundleLongAsDate = Utility.getBundleLongAsDate(bundle, EXPIRES_IN_KEY, date);
        String string2 = bundle.getString(USER_ID_KEY);
        Date bundleLongAsDate2 = Utility.getBundleLongAsDate(bundle, DATA_ACCESS_EXPIRATION_TIME, new Date(0));
        if (Utility.isNullOrEmpty(string) || bundleLongAsDate == null) {
            AppMethodBeat.o(16969);
            return null;
        }
        AccessToken accessToken = new AccessToken(string, str, string2, list, null, accessTokenSource, bundleLongAsDate, new Date(), bundleLongAsDate2);
        AppMethodBeat.o(16969);
        return accessToken;
    }

    private String tokenToString() {
        AppMethodBeat.i(16970);
        if (this.token == null) {
            AppMethodBeat.o(16970);
            return BuildConfig.COMMAND;
        } else if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.INCLUDE_ACCESS_TOKENS)) {
            String str = this.token;
            AppMethodBeat.o(16970);
            return str;
        } else {
            AppMethodBeat.o(16970);
            return "ACCESS_TOKEN_REMOVED";
        }
    }

    private void appendPermissions(StringBuilder sb) {
        AppMethodBeat.i(16971);
        sb.append(" permissions:");
        if (this.permissions == null) {
            sb.append(BuildConfig.COMMAND);
            AppMethodBeat.o(16971);
            return;
        }
        sb.append("[");
        sb.append(TextUtils.join(", ", this.permissions));
        sb.append("]");
        AppMethodBeat.o(16971);
    }

    AccessToken(Parcel parcel) {
        AppMethodBeat.i(16972);
        this.expires = new Date(parcel.readLong());
        ArrayList arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        this.permissions = Collections.unmodifiableSet(new HashSet(arrayList));
        arrayList.clear();
        parcel.readStringList(arrayList);
        this.declinedPermissions = Collections.unmodifiableSet(new HashSet(arrayList));
        this.token = parcel.readString();
        this.source = AccessTokenSource.valueOf(parcel.readString());
        this.lastRefresh = new Date(parcel.readLong());
        this.applicationId = parcel.readString();
        this.userId = parcel.readString();
        this.dataAccessExpirationTime = new Date(parcel.readLong());
        AppMethodBeat.o(16972);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(16973);
        parcel.writeLong(this.expires.getTime());
        parcel.writeStringList(new ArrayList(this.permissions));
        parcel.writeStringList(new ArrayList(this.declinedPermissions));
        parcel.writeString(this.token);
        parcel.writeString(this.source.name());
        parcel.writeLong(this.lastRefresh.getTime());
        parcel.writeString(this.applicationId);
        parcel.writeString(this.userId);
        parcel.writeLong(this.dataAccessExpirationTime.getTime());
        AppMethodBeat.o(16973);
    }
}
