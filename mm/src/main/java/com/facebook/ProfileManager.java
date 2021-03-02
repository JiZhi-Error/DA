package com.facebook;

import android.content.Intent;
import android.support.v4.content.d;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ProfileManager {
    public static final String ACTION_CURRENT_PROFILE_CHANGED = "com.facebook.sdk.ACTION_CURRENT_PROFILE_CHANGED";
    public static final String EXTRA_NEW_PROFILE = "com.facebook.sdk.EXTRA_NEW_PROFILE";
    public static final String EXTRA_OLD_PROFILE = "com.facebook.sdk.EXTRA_OLD_PROFILE";
    private static volatile ProfileManager instance;
    private Profile currentProfile;
    private final d localBroadcastManager;
    private final ProfileCache profileCache;

    ProfileManager(d dVar, ProfileCache profileCache2) {
        AppMethodBeat.i(17261);
        Validate.notNull(dVar, "localBroadcastManager");
        Validate.notNull(profileCache2, "profileCache");
        this.localBroadcastManager = dVar;
        this.profileCache = profileCache2;
        AppMethodBeat.o(17261);
    }

    static ProfileManager getInstance() {
        AppMethodBeat.i(17262);
        if (instance == null) {
            synchronized (ProfileManager.class) {
                try {
                    if (instance == null) {
                        instance = new ProfileManager(d.W(FacebookSdk.getApplicationContext()), new ProfileCache());
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(17262);
                    throw th;
                }
            }
        }
        ProfileManager profileManager = instance;
        AppMethodBeat.o(17262);
        return profileManager;
    }

    /* access modifiers changed from: package-private */
    public final Profile getCurrentProfile() {
        return this.currentProfile;
    }

    /* access modifiers changed from: package-private */
    public final boolean loadCurrentProfile() {
        AppMethodBeat.i(17263);
        Profile load = this.profileCache.load();
        if (load != null) {
            setCurrentProfile(load, false);
            AppMethodBeat.o(17263);
            return true;
        }
        AppMethodBeat.o(17263);
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void setCurrentProfile(Profile profile) {
        AppMethodBeat.i(17264);
        setCurrentProfile(profile, true);
        AppMethodBeat.o(17264);
    }

    private void setCurrentProfile(Profile profile, boolean z) {
        AppMethodBeat.i(17265);
        Profile profile2 = this.currentProfile;
        this.currentProfile = profile;
        if (z) {
            if (profile != null) {
                this.profileCache.save(profile);
            } else {
                this.profileCache.clear();
            }
        }
        if (!Utility.areObjectsEqual(profile2, profile)) {
            sendCurrentProfileChangedBroadcast(profile2, profile);
        }
        AppMethodBeat.o(17265);
    }

    private void sendCurrentProfileChangedBroadcast(Profile profile, Profile profile2) {
        AppMethodBeat.i(17266);
        Intent intent = new Intent(ACTION_CURRENT_PROFILE_CHANGED);
        intent.putExtra(EXTRA_OLD_PROFILE, profile);
        intent.putExtra(EXTRA_NEW_PROFILE, profile2);
        this.localBroadcastManager.b(intent);
        AppMethodBeat.o(17266);
    }
}
