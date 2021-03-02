package com.facebook;

import android.content.SharedPreferences;
import com.facebook.internal.Validate;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public final class ProfileCache {
    static final String CACHED_PROFILE_KEY = "com.facebook.ProfileManager.CachedProfile";
    static final String SHARED_PREFERENCES_NAME = "com.facebook.AccessTokenManager.SharedPreferences";
    private final SharedPreferences sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.AccessTokenManager.SharedPreferences", 0);

    ProfileCache() {
        AppMethodBeat.i(17257);
        AppMethodBeat.o(17257);
    }

    /* access modifiers changed from: package-private */
    public final Profile load() {
        AppMethodBeat.i(17258);
        String string = this.sharedPreferences.getString(CACHED_PROFILE_KEY, null);
        if (string != null) {
            try {
                Profile profile = new Profile(new JSONObject(string));
                AppMethodBeat.o(17258);
                return profile;
            } catch (JSONException e2) {
            }
        }
        AppMethodBeat.o(17258);
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void save(Profile profile) {
        AppMethodBeat.i(17259);
        Validate.notNull(profile, Scopes.PROFILE);
        JSONObject jSONObject = profile.toJSONObject();
        if (jSONObject != null) {
            this.sharedPreferences.edit().putString(CACHED_PROFILE_KEY, jSONObject.toString()).apply();
        }
        AppMethodBeat.o(17259);
    }

    /* access modifiers changed from: package-private */
    public final void clear() {
        AppMethodBeat.i(17260);
        this.sharedPreferences.edit().remove(CACHED_PROFILE_KEY).apply();
        AppMethodBeat.o(17260);
    }
}
