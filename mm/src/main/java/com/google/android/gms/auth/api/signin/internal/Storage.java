package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;

public class Storage {
    private static final Lock zzaf = new ReentrantLock();
    @GuardedBy("sLk")
    private static Storage zzag;
    private final Lock zzah = new ReentrantLock();
    @GuardedBy("mLk")
    private final SharedPreferences zzai;

    static {
        AppMethodBeat.i(10898);
        AppMethodBeat.o(10898);
    }

    @VisibleForTesting
    private Storage(Context context) {
        AppMethodBeat.i(10884);
        this.zzai = context.getSharedPreferences("com.google.android.gms.signin", 0);
        AppMethodBeat.o(10884);
    }

    public static Storage getInstance(Context context) {
        AppMethodBeat.i(10883);
        Preconditions.checkNotNull(context);
        zzaf.lock();
        try {
            if (zzag == null) {
                zzag = new Storage(context.getApplicationContext());
            }
            return zzag;
        } finally {
            zzaf.unlock();
            AppMethodBeat.o(10883);
        }
    }

    @VisibleForTesting
    public static void setInstance(@Nullable Storage storage) {
        AppMethodBeat.i(10882);
        zzaf.lock();
        try {
            zzag = storage;
        } finally {
            zzaf.unlock();
            AppMethodBeat.o(10882);
        }
    }

    private static String zza(String str, String str2) {
        AppMethodBeat.i(10897);
        String sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length()).append(str).append(":").append(str2).toString();
        AppMethodBeat.o(10897);
        return sb;
    }

    @VisibleForTesting
    @Nullable
    private final GoogleSignInAccount zzb(String str) {
        AppMethodBeat.i(10889);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(10889);
            return null;
        }
        String fromStore = getFromStore(zza("googleSignInAccount", str));
        if (fromStore != null) {
            try {
                GoogleSignInAccount fromJsonString = GoogleSignInAccount.fromJsonString(fromStore);
                AppMethodBeat.o(10889);
                return fromJsonString;
            } catch (JSONException e2) {
                AppMethodBeat.o(10889);
                return null;
            }
        } else {
            AppMethodBeat.o(10889);
            return null;
        }
    }

    @VisibleForTesting
    @Nullable
    private final GoogleSignInOptions zzc(String str) {
        AppMethodBeat.i(10891);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(10891);
            return null;
        }
        String fromStore = getFromStore(zza("googleSignInOptions", str));
        if (fromStore != null) {
            try {
                GoogleSignInOptions fromJsonString = GoogleSignInOptions.fromJsonString(fromStore);
                AppMethodBeat.o(10891);
                return fromJsonString;
            } catch (JSONException e2) {
                AppMethodBeat.o(10891);
                return null;
            }
        } else {
            AppMethodBeat.o(10891);
            return null;
        }
    }

    public void clear() {
        AppMethodBeat.i(10896);
        this.zzah.lock();
        try {
            this.zzai.edit().clear().apply();
        } finally {
            this.zzah.unlock();
            AppMethodBeat.o(10896);
        }
    }

    /* access modifiers changed from: protected */
    @Nullable
    public String getFromStore(String str) {
        AppMethodBeat.i(10893);
        this.zzah.lock();
        try {
            return this.zzai.getString(str, null);
        } finally {
            this.zzah.unlock();
            AppMethodBeat.o(10893);
        }
    }

    @Nullable
    public GoogleSignInAccount getSavedDefaultGoogleSignInAccount() {
        AppMethodBeat.i(10888);
        GoogleSignInAccount zzb = zzb(getFromStore("defaultGoogleSignInAccount"));
        AppMethodBeat.o(10888);
        return zzb;
    }

    @Nullable
    public GoogleSignInOptions getSavedDefaultGoogleSignInOptions() {
        AppMethodBeat.i(10890);
        GoogleSignInOptions zzc = zzc(getFromStore("defaultGoogleSignInAccount"));
        AppMethodBeat.o(10890);
        return zzc;
    }

    @Nullable
    public String getSavedRefreshToken() {
        AppMethodBeat.i(10892);
        String fromStore = getFromStore("refreshToken");
        AppMethodBeat.o(10892);
        return fromStore;
    }

    /* access modifiers changed from: protected */
    public void removeFromStore(String str) {
        AppMethodBeat.i(10895);
        this.zzah.lock();
        try {
            this.zzai.edit().remove(str).apply();
        } finally {
            this.zzah.unlock();
            AppMethodBeat.o(10895);
        }
    }

    public void removeSavedDefaultGoogleSignInAccount() {
        AppMethodBeat.i(10894);
        String fromStore = getFromStore("defaultGoogleSignInAccount");
        removeFromStore("defaultGoogleSignInAccount");
        if (!TextUtils.isEmpty(fromStore)) {
            removeFromStore(zza("googleSignInAccount", fromStore));
            removeFromStore(zza("googleSignInOptions", fromStore));
        }
        AppMethodBeat.o(10894);
    }

    public void saveDefaultGoogleSignInAccount(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        AppMethodBeat.i(10885);
        Preconditions.checkNotNull(googleSignInAccount);
        Preconditions.checkNotNull(googleSignInOptions);
        saveToStore("defaultGoogleSignInAccount", googleSignInAccount.getObfuscatedIdentifier());
        Preconditions.checkNotNull(googleSignInAccount);
        Preconditions.checkNotNull(googleSignInOptions);
        String obfuscatedIdentifier = googleSignInAccount.getObfuscatedIdentifier();
        saveToStore(zza("googleSignInAccount", obfuscatedIdentifier), googleSignInAccount.toJsonForStorage());
        saveToStore(zza("googleSignInOptions", obfuscatedIdentifier), googleSignInOptions.toJson());
        AppMethodBeat.o(10885);
    }

    public void saveRefreshToken(String str) {
        AppMethodBeat.i(10886);
        if (!TextUtils.isEmpty(str)) {
            saveToStore("refreshToken", str);
        }
        AppMethodBeat.o(10886);
    }

    /* access modifiers changed from: protected */
    public void saveToStore(String str, String str2) {
        AppMethodBeat.i(10887);
        this.zzah.lock();
        try {
            this.zzai.edit().putString(str, str2).apply();
        } finally {
            this.zzah.unlock();
            AppMethodBeat.o(10887);
        }
    }
}
