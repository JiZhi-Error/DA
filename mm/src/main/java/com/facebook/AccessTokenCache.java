package com.facebook;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.internal.Validate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public class AccessTokenCache {
    static final String CACHED_ACCESS_TOKEN_KEY = "com.facebook.AccessTokenManager.CachedAccessToken";
    private final SharedPreferences sharedPreferences;
    private LegacyTokenHelper tokenCachingStrategy;
    private final SharedPreferencesTokenCachingStrategyFactory tokenCachingStrategyFactory;

    AccessTokenCache(SharedPreferences sharedPreferences2, SharedPreferencesTokenCachingStrategyFactory sharedPreferencesTokenCachingStrategyFactory) {
        this.sharedPreferences = sharedPreferences2;
        this.tokenCachingStrategyFactory = sharedPreferencesTokenCachingStrategyFactory;
    }

    public AccessTokenCache() {
        this(FacebookSdk.getApplicationContext().getSharedPreferences(AccessTokenManager.SHARED_PREFERENCES_NAME, 0), new SharedPreferencesTokenCachingStrategyFactory());
        AppMethodBeat.i(16977);
        AppMethodBeat.o(16977);
    }

    public AccessToken load() {
        AppMethodBeat.i(16978);
        AccessToken accessToken = null;
        if (hasCachedAccessToken()) {
            accessToken = getCachedAccessToken();
        } else if (shouldCheckLegacyToken() && (accessToken = getLegacyAccessToken()) != null) {
            save(accessToken);
            getTokenCachingStrategy().clear();
        }
        AppMethodBeat.o(16978);
        return accessToken;
    }

    public void save(AccessToken accessToken) {
        AppMethodBeat.i(16979);
        Validate.notNull(accessToken, "accessToken");
        try {
            this.sharedPreferences.edit().putString(CACHED_ACCESS_TOKEN_KEY, accessToken.toJSONObject().toString()).apply();
            AppMethodBeat.o(16979);
        } catch (JSONException e2) {
            AppMethodBeat.o(16979);
        }
    }

    public void clear() {
        AppMethodBeat.i(16980);
        this.sharedPreferences.edit().remove(CACHED_ACCESS_TOKEN_KEY).apply();
        if (shouldCheckLegacyToken()) {
            getTokenCachingStrategy().clear();
        }
        AppMethodBeat.o(16980);
    }

    private boolean hasCachedAccessToken() {
        AppMethodBeat.i(16981);
        boolean contains = this.sharedPreferences.contains(CACHED_ACCESS_TOKEN_KEY);
        AppMethodBeat.o(16981);
        return contains;
    }

    private AccessToken getCachedAccessToken() {
        AccessToken accessToken = null;
        AppMethodBeat.i(16982);
        String string = this.sharedPreferences.getString(CACHED_ACCESS_TOKEN_KEY, null);
        if (string != null) {
            try {
                accessToken = AccessToken.createFromJSONObject(new JSONObject(string));
                AppMethodBeat.o(16982);
            } catch (JSONException e2) {
                AppMethodBeat.o(16982);
            }
        } else {
            AppMethodBeat.o(16982);
        }
        return accessToken;
    }

    private boolean shouldCheckLegacyToken() {
        AppMethodBeat.i(16983);
        boolean isLegacyTokenUpgradeSupported = FacebookSdk.isLegacyTokenUpgradeSupported();
        AppMethodBeat.o(16983);
        return isLegacyTokenUpgradeSupported;
    }

    private AccessToken getLegacyAccessToken() {
        AppMethodBeat.i(16984);
        AccessToken accessToken = null;
        Bundle load = getTokenCachingStrategy().load();
        if (load != null && LegacyTokenHelper.hasTokenInformation(load)) {
            accessToken = AccessToken.createFromLegacyCache(load);
        }
        AppMethodBeat.o(16984);
        return accessToken;
    }

    private LegacyTokenHelper getTokenCachingStrategy() {
        AppMethodBeat.i(16985);
        if (this.tokenCachingStrategy == null) {
            synchronized (this) {
                try {
                    if (this.tokenCachingStrategy == null) {
                        this.tokenCachingStrategy = this.tokenCachingStrategyFactory.create();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(16985);
                    throw th;
                }
            }
        }
        LegacyTokenHelper legacyTokenHelper = this.tokenCachingStrategy;
        AppMethodBeat.o(16985);
        return legacyTokenHelper;
    }

    /* access modifiers changed from: package-private */
    public static class SharedPreferencesTokenCachingStrategyFactory {
        SharedPreferencesTokenCachingStrategyFactory() {
        }

        public LegacyTokenHelper create() {
            AppMethodBeat.i(16976);
            LegacyTokenHelper legacyTokenHelper = new LegacyTokenHelper(FacebookSdk.getApplicationContext());
            AppMethodBeat.o(16976);
            return legacyTokenHelper;
        }
    }
}
