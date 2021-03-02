package com.facebook;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.content.d;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestBatch;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

public final class AccessTokenManager {
    public static final String ACTION_CURRENT_ACCESS_TOKEN_CHANGED = "com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED";
    public static final String EXTRA_NEW_ACCESS_TOKEN = "com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN";
    public static final String EXTRA_OLD_ACCESS_TOKEN = "com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN";
    private static final String ME_PERMISSIONS_GRAPH_PATH = "me/permissions";
    public static final String SHARED_PREFERENCES_NAME = "com.facebook.AccessTokenManager.SharedPreferences";
    public static final String TAG = "AccessTokenManager";
    private static final String TOKEN_EXTEND_GRAPH_PATH = "oauth/access_token";
    private static final int TOKEN_EXTEND_RETRY_SECONDS = 3600;
    private static final int TOKEN_EXTEND_THRESHOLD_SECONDS = 86400;
    private static volatile AccessTokenManager instance;
    private final AccessTokenCache accessTokenCache;
    private AccessToken currentAccessToken;
    private Date lastAttemptedTokenExtendDate = new Date(0);
    private final d localBroadcastManager;
    private AtomicBoolean tokenRefreshInProgress = new AtomicBoolean(false);

    static /* synthetic */ void access$000(AccessTokenManager accessTokenManager, AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback) {
        AppMethodBeat.i(17004);
        accessTokenManager.refreshCurrentAccessTokenImpl(accessTokenRefreshCallback);
        AppMethodBeat.o(17004);
    }

    AccessTokenManager(d dVar, AccessTokenCache accessTokenCache2) {
        AppMethodBeat.i(16990);
        Validate.notNull(dVar, "localBroadcastManager");
        Validate.notNull(accessTokenCache2, "accessTokenCache");
        this.localBroadcastManager = dVar;
        this.accessTokenCache = accessTokenCache2;
        AppMethodBeat.o(16990);
    }

    static AccessTokenManager getInstance() {
        AppMethodBeat.i(16991);
        if (instance == null) {
            synchronized (AccessTokenManager.class) {
                try {
                    if (instance == null) {
                        instance = new AccessTokenManager(d.W(FacebookSdk.getApplicationContext()), new AccessTokenCache());
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(16991);
                    throw th;
                }
            }
        }
        AccessTokenManager accessTokenManager = instance;
        AppMethodBeat.o(16991);
        return accessTokenManager;
    }

    /* access modifiers changed from: package-private */
    public final AccessToken getCurrentAccessToken() {
        return this.currentAccessToken;
    }

    /* access modifiers changed from: package-private */
    public final boolean loadCurrentAccessToken() {
        AppMethodBeat.i(16992);
        AccessToken load = this.accessTokenCache.load();
        if (load != null) {
            setCurrentAccessToken(load, false);
            AppMethodBeat.o(16992);
            return true;
        }
        AppMethodBeat.o(16992);
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void setCurrentAccessToken(AccessToken accessToken) {
        AppMethodBeat.i(16993);
        setCurrentAccessToken(accessToken, true);
        AppMethodBeat.o(16993);
    }

    private void setCurrentAccessToken(AccessToken accessToken, boolean z) {
        AppMethodBeat.i(16994);
        AccessToken accessToken2 = this.currentAccessToken;
        this.currentAccessToken = accessToken;
        this.tokenRefreshInProgress.set(false);
        this.lastAttemptedTokenExtendDate = new Date(0);
        if (z) {
            if (accessToken != null) {
                this.accessTokenCache.save(accessToken);
            } else {
                this.accessTokenCache.clear();
                Utility.clearFacebookCookies(FacebookSdk.getApplicationContext());
            }
        }
        if (!Utility.areObjectsEqual(accessToken2, accessToken)) {
            sendCurrentAccessTokenChangedBroadcastIntent(accessToken2, accessToken);
            setTokenExpirationBroadcastAlarm();
        }
        AppMethodBeat.o(16994);
    }

    /* access modifiers changed from: package-private */
    public final void currentAccessTokenChanged() {
        AppMethodBeat.i(16995);
        sendCurrentAccessTokenChangedBroadcastIntent(this.currentAccessToken, this.currentAccessToken);
        AppMethodBeat.o(16995);
    }

    private void sendCurrentAccessTokenChangedBroadcastIntent(AccessToken accessToken, AccessToken accessToken2) {
        AppMethodBeat.i(16996);
        Intent intent = new Intent(FacebookSdk.getApplicationContext(), CurrentAccessTokenExpirationBroadcastReceiver.class);
        intent.setAction(ACTION_CURRENT_ACCESS_TOKEN_CHANGED);
        intent.putExtra(EXTRA_OLD_ACCESS_TOKEN, accessToken);
        intent.putExtra(EXTRA_NEW_ACCESS_TOKEN, accessToken2);
        this.localBroadcastManager.b(intent);
        AppMethodBeat.o(16996);
    }

    private void setTokenExpirationBroadcastAlarm() {
        AppMethodBeat.i(16997);
        Context applicationContext = FacebookSdk.getApplicationContext();
        AccessToken currentAccessToken2 = AccessToken.getCurrentAccessToken();
        AlarmManager alarmManager = (AlarmManager) applicationContext.getSystemService("alarm");
        if (!AccessToken.isCurrentAccessTokenActive() || currentAccessToken2.getExpires() == null || alarmManager == null) {
            AppMethodBeat.o(16997);
            return;
        }
        Intent intent = new Intent(applicationContext, CurrentAccessTokenExpirationBroadcastReceiver.class);
        intent.setAction(ACTION_CURRENT_ACCESS_TOKEN_CHANGED);
        alarmManager.set(1, currentAccessToken2.getExpires().getTime(), PendingIntent.getBroadcast(applicationContext, 0, intent, 0));
        AppMethodBeat.o(16997);
    }

    /* access modifiers changed from: package-private */
    public final void extendAccessTokenIfNeeded() {
        AppMethodBeat.i(16998);
        if (!shouldExtendAccessToken()) {
            AppMethodBeat.o(16998);
            return;
        }
        refreshCurrentAccessToken(null);
        AppMethodBeat.o(16998);
    }

    private boolean shouldExtendAccessToken() {
        AppMethodBeat.i(16999);
        if (this.currentAccessToken == null) {
            AppMethodBeat.o(16999);
            return false;
        }
        Long valueOf = Long.valueOf(new Date().getTime());
        if (!this.currentAccessToken.getSource().canExtendToken() || valueOf.longValue() - this.lastAttemptedTokenExtendDate.getTime() <= Util.MILLSECONDS_OF_HOUR || valueOf.longValue() - this.currentAccessToken.getLastRefresh().getTime() <= Util.MILLSECONDS_OF_DAY) {
            AppMethodBeat.o(16999);
            return false;
        }
        AppMethodBeat.o(16999);
        return true;
    }

    private static GraphRequest createGrantedPermissionsRequest(AccessToken accessToken, GraphRequest.Callback callback) {
        AppMethodBeat.i(17000);
        GraphRequest graphRequest = new GraphRequest(accessToken, ME_PERMISSIONS_GRAPH_PATH, new Bundle(), HttpMethod.GET, callback);
        AppMethodBeat.o(17000);
        return graphRequest;
    }

    private static GraphRequest createExtendAccessTokenRequest(AccessToken accessToken, GraphRequest.Callback callback) {
        AppMethodBeat.i(17001);
        Bundle bundle = new Bundle();
        bundle.putString("grant_type", "fb_extend_sso_token");
        GraphRequest graphRequest = new GraphRequest(accessToken, TOKEN_EXTEND_GRAPH_PATH, bundle, HttpMethod.GET, callback);
        AppMethodBeat.o(17001);
        return graphRequest;
    }

    /* access modifiers changed from: package-private */
    public static class RefreshResult {
        public String accessToken;
        public Long dataAccessExpirationTime;
        public int expiresAt;

        private RefreshResult() {
        }
    }

    /* access modifiers changed from: package-private */
    public final void refreshCurrentAccessToken(final AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback) {
        AppMethodBeat.i(17002);
        if (Looper.getMainLooper().equals(Looper.myLooper())) {
            refreshCurrentAccessTokenImpl(accessTokenRefreshCallback);
            AppMethodBeat.o(17002);
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            /* class com.facebook.AccessTokenManager.AnonymousClass1 */

            public void run() {
                AppMethodBeat.i(16986);
                AccessTokenManager.access$000(AccessTokenManager.this, accessTokenRefreshCallback);
                AppMethodBeat.o(16986);
            }
        });
        AppMethodBeat.o(17002);
    }

    private void refreshCurrentAccessTokenImpl(final AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback) {
        AppMethodBeat.i(17003);
        final AccessToken accessToken = this.currentAccessToken;
        if (accessToken == null) {
            if (accessTokenRefreshCallback != null) {
                accessTokenRefreshCallback.OnTokenRefreshFailed(new FacebookException("No current access token to refresh"));
            }
            AppMethodBeat.o(17003);
        } else if (!this.tokenRefreshInProgress.compareAndSet(false, true)) {
            if (accessTokenRefreshCallback != null) {
                accessTokenRefreshCallback.OnTokenRefreshFailed(new FacebookException("Refresh already in progress"));
            }
            AppMethodBeat.o(17003);
        } else {
            this.lastAttemptedTokenExtendDate = new Date();
            final HashSet hashSet = new HashSet();
            final HashSet hashSet2 = new HashSet();
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            final RefreshResult refreshResult = new RefreshResult();
            GraphRequestBatch graphRequestBatch = new GraphRequestBatch(createGrantedPermissionsRequest(accessToken, new GraphRequest.Callback() {
                /* class com.facebook.AccessTokenManager.AnonymousClass2 */

                @Override // com.facebook.GraphRequest.Callback
                public void onCompleted(GraphResponse graphResponse) {
                    AppMethodBeat.i(16987);
                    JSONObject jSONObject = graphResponse.getJSONObject();
                    if (jSONObject == null) {
                        AppMethodBeat.o(16987);
                        return;
                    }
                    JSONArray optJSONArray = jSONObject.optJSONArray("data");
                    if (optJSONArray == null) {
                        AppMethodBeat.o(16987);
                        return;
                    }
                    atomicBoolean.set(true);
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                        if (optJSONObject != null) {
                            String optString = optJSONObject.optString("permission");
                            String optString2 = optJSONObject.optString("status");
                            if (!Utility.isNullOrEmpty(optString) && !Utility.isNullOrEmpty(optString2)) {
                                String lowerCase = optString2.toLowerCase(Locale.US);
                                if (lowerCase.equals("granted")) {
                                    hashSet.add(optString);
                                } else if (lowerCase.equals("declined")) {
                                    hashSet2.add(optString);
                                }
                            }
                        }
                    }
                    AppMethodBeat.o(16987);
                }
            }), createExtendAccessTokenRequest(accessToken, new GraphRequest.Callback() {
                /* class com.facebook.AccessTokenManager.AnonymousClass3 */

                @Override // com.facebook.GraphRequest.Callback
                public void onCompleted(GraphResponse graphResponse) {
                    AppMethodBeat.i(16988);
                    JSONObject jSONObject = graphResponse.getJSONObject();
                    if (jSONObject == null) {
                        AppMethodBeat.o(16988);
                        return;
                    }
                    refreshResult.accessToken = jSONObject.optString("access_token");
                    refreshResult.expiresAt = jSONObject.optInt("expires_at");
                    refreshResult.dataAccessExpirationTime = Long.valueOf(jSONObject.optLong(AccessToken.DATA_ACCESS_EXPIRATION_TIME));
                    AppMethodBeat.o(16988);
                }
            }));
            graphRequestBatch.addCallback(new GraphRequestBatch.Callback() {
                /* class com.facebook.AccessTokenManager.AnonymousClass4 */

                @Override // com.facebook.GraphRequestBatch.Callback
                public void onBatchCompleted(GraphRequestBatch graphRequestBatch) {
                    AccessToken accessToken;
                    Throwable th;
                    String token;
                    Set<String> permissions;
                    Set<String> declinedPermissions;
                    Date expires;
                    Date dataAccessExpirationTime;
                    AppMethodBeat.i(16989);
                    try {
                        if (AccessTokenManager.getInstance().getCurrentAccessToken() == null || AccessTokenManager.getInstance().getCurrentAccessToken().getUserId() != accessToken.getUserId()) {
                            if (accessTokenRefreshCallback != null) {
                                accessTokenRefreshCallback.OnTokenRefreshFailed(new FacebookException("No current access token to refresh"));
                            }
                            AccessTokenManager.this.tokenRefreshInProgress.set(false);
                            AppMethodBeat.o(16989);
                        } else if (!atomicBoolean.get() && refreshResult.accessToken == null && refreshResult.expiresAt == 0) {
                            if (accessTokenRefreshCallback != null) {
                                accessTokenRefreshCallback.OnTokenRefreshFailed(new FacebookException("Failed to refresh access token"));
                            }
                            AccessTokenManager.this.tokenRefreshInProgress.set(false);
                            AppMethodBeat.o(16989);
                        } else {
                            if (refreshResult.accessToken != null) {
                                token = refreshResult.accessToken;
                            } else {
                                token = accessToken.getToken();
                            }
                            String applicationId = accessToken.getApplicationId();
                            String userId = accessToken.getUserId();
                            if (atomicBoolean.get()) {
                                permissions = hashSet;
                            } else {
                                permissions = accessToken.getPermissions();
                            }
                            if (atomicBoolean.get()) {
                                declinedPermissions = hashSet2;
                            } else {
                                declinedPermissions = accessToken.getDeclinedPermissions();
                            }
                            AccessTokenSource source = accessToken.getSource();
                            if (refreshResult.expiresAt != 0) {
                                expires = new Date(((long) refreshResult.expiresAt) * 1000);
                            } else {
                                expires = accessToken.getExpires();
                            }
                            Date date = new Date();
                            if (refreshResult.dataAccessExpirationTime != null) {
                                dataAccessExpirationTime = new Date(refreshResult.dataAccessExpirationTime.longValue() * 1000);
                            } else {
                                dataAccessExpirationTime = accessToken.getDataAccessExpirationTime();
                            }
                            AccessToken accessToken2 = new AccessToken(token, applicationId, userId, permissions, declinedPermissions, source, expires, date, dataAccessExpirationTime);
                            try {
                                AccessTokenManager.getInstance().setCurrentAccessToken(accessToken2);
                                AccessTokenManager.this.tokenRefreshInProgress.set(false);
                                if (accessTokenRefreshCallback != null) {
                                    accessTokenRefreshCallback.OnTokenRefreshed(accessToken2);
                                    AppMethodBeat.o(16989);
                                    return;
                                }
                                AppMethodBeat.o(16989);
                            } catch (Throwable th2) {
                                th = th2;
                                accessToken = accessToken2;
                                AccessTokenManager.this.tokenRefreshInProgress.set(false);
                                accessTokenRefreshCallback.OnTokenRefreshed(accessToken);
                                AppMethodBeat.o(16989);
                                throw th;
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        accessToken = null;
                        AccessTokenManager.this.tokenRefreshInProgress.set(false);
                        if (!(accessTokenRefreshCallback == null || accessToken == null)) {
                            accessTokenRefreshCallback.OnTokenRefreshed(accessToken);
                        }
                        AppMethodBeat.o(16989);
                        throw th;
                    }
                }
            });
            graphRequestBatch.executeAsync();
            AppMethodBeat.o(17003);
        }
    }
}
