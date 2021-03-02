package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "GoogleSignInAccountCreator")
public class GoogleSignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new GoogleSignInAccountCreator();
    @VisibleForTesting
    public static Clock sClock = DefaultClock.getInstance();
    @SafeParcelable.VersionField(id = 1)
    private final int versionCode;
    @SafeParcelable.Field(getter = "getId", id = 2)
    private String zze;
    @SafeParcelable.Field(getter = "getIdToken", id = 3)
    private String zzf;
    @SafeParcelable.Field(getter = "getEmail", id = 4)
    private String zzg;
    @SafeParcelable.Field(getter = "getDisplayName", id = 5)
    private String zzh;
    @SafeParcelable.Field(getter = "getPhotoUrl", id = 6)
    private Uri zzi;
    @SafeParcelable.Field(getter = "getServerAuthCode", id = 7)
    private String zzj;
    @SafeParcelable.Field(getter = "getExpirationTimeSecs", id = 8)
    private long zzk;
    @SafeParcelable.Field(getter = "getObfuscatedIdentifier", id = 9)
    private String zzl;
    @SafeParcelable.Field(id = 10)
    private List<Scope> zzm;
    @SafeParcelable.Field(getter = "getGivenName", id = 11)
    private String zzn;
    @SafeParcelable.Field(getter = "getFamilyName", id = 12)
    private String zzo;
    private Set<Scope> zzp = new HashSet();

    static {
        AppMethodBeat.i(10837);
        AppMethodBeat.o(10837);
    }

    @SafeParcelable.Constructor
    GoogleSignInAccount(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) String str3, @SafeParcelable.Param(id = 5) String str4, @SafeParcelable.Param(id = 6) Uri uri, @SafeParcelable.Param(id = 7) String str5, @SafeParcelable.Param(id = 8) long j2, @SafeParcelable.Param(id = 9) String str6, @SafeParcelable.Param(id = 10) List<Scope> list, @SafeParcelable.Param(id = 11) String str7, @SafeParcelable.Param(id = 12) String str8) {
        AppMethodBeat.i(10824);
        this.versionCode = i2;
        this.zze = str;
        this.zzf = str2;
        this.zzg = str3;
        this.zzh = str4;
        this.zzi = uri;
        this.zzj = str5;
        this.zzk = j2;
        this.zzl = str6;
        this.zzm = list;
        this.zzn = str7;
        this.zzo = str8;
        AppMethodBeat.o(10824);
    }

    public static GoogleSignInAccount create(String str, String str2, String str3, String str4, Uri uri, Long l, String str5, Set<Scope> set) {
        AppMethodBeat.i(10820);
        GoogleSignInAccount create = create(str, str2, str3, str4, null, null, uri, l, str5, set);
        AppMethodBeat.o(10820);
        return create;
    }

    public static GoogleSignInAccount create(String str, String str2, String str3, String str4, String str5, String str6, Uri uri, Long l, String str7, Set<Scope> set) {
        AppMethodBeat.i(10819);
        if (l == null) {
            l = Long.valueOf(sClock.currentTimeMillis() / 1000);
        }
        GoogleSignInAccount googleSignInAccount = new GoogleSignInAccount(3, str, str2, str3, str4, uri, null, l.longValue(), Preconditions.checkNotEmpty(str7), new ArrayList((Collection) Preconditions.checkNotNull(set)), str5, str6);
        AppMethodBeat.o(10819);
        return googleSignInAccount;
    }

    public static GoogleSignInAccount createDefault() {
        AppMethodBeat.i(10822);
        GoogleSignInAccount zza = zza(new Account("<<default account>>", "com.google"), new HashSet());
        AppMethodBeat.o(10822);
        return zza;
    }

    public static GoogleSignInAccount fromAccountAndScopes(Account account, Scope scope, Scope... scopeArr) {
        AppMethodBeat.i(10821);
        Preconditions.checkNotNull(account);
        Preconditions.checkNotNull(scope);
        HashSet hashSet = new HashSet();
        hashSet.add(scope);
        hashSet.addAll(Arrays.asList(scopeArr));
        GoogleSignInAccount zza = zza(account, hashSet);
        AppMethodBeat.o(10821);
        return zza;
    }

    public static GoogleSignInAccount fromJsonString(String str) {
        AppMethodBeat.i(10818);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(10818);
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("photoUrl", null);
        Uri parse = !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null;
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            hashSet.add(new Scope(jSONArray.getString(i2)));
        }
        GoogleSignInAccount serverAuthCode = create(jSONObject.optString("id"), jSONObject.optString("tokenId", null), jSONObject.optString(Scopes.EMAIL, null), jSONObject.optString("displayName", null), jSONObject.optString("givenName", null), jSONObject.optString("familyName", null), parse, Long.valueOf(parseLong), jSONObject.getString("obfuscatedIdentifier"), hashSet).setServerAuthCode(jSONObject.optString("serverAuthCode", null));
        AppMethodBeat.o(10818);
        return serverAuthCode;
    }

    static final /* synthetic */ int zza(Scope scope, Scope scope2) {
        AppMethodBeat.i(10836);
        int compareTo = scope.getScopeUri().compareTo(scope2.getScopeUri());
        AppMethodBeat.o(10836);
        return compareTo;
    }

    private static GoogleSignInAccount zza(Account account, Set<Scope> set) {
        AppMethodBeat.i(10823);
        GoogleSignInAccount create = create(null, null, account.name, null, null, null, null, 0L, account.name, set);
        AppMethodBeat.o(10823);
        return create;
    }

    private final JSONObject zza() {
        AppMethodBeat.i(10835);
        JSONObject jSONObject = new JSONObject();
        try {
            if (getId() != null) {
                jSONObject.put("id", getId());
            }
            if (getIdToken() != null) {
                jSONObject.put("tokenId", getIdToken());
            }
            if (getEmail() != null) {
                jSONObject.put(Scopes.EMAIL, getEmail());
            }
            if (getDisplayName() != null) {
                jSONObject.put("displayName", getDisplayName());
            }
            if (getGivenName() != null) {
                jSONObject.put("givenName", getGivenName());
            }
            if (getFamilyName() != null) {
                jSONObject.put("familyName", getFamilyName());
            }
            if (getPhotoUrl() != null) {
                jSONObject.put("photoUrl", getPhotoUrl().toString());
            }
            if (getServerAuthCode() != null) {
                jSONObject.put("serverAuthCode", getServerAuthCode());
            }
            jSONObject.put("expirationTime", this.zzk);
            jSONObject.put("obfuscatedIdentifier", getObfuscatedIdentifier());
            JSONArray jSONArray = new JSONArray();
            Scope[] scopeArr = (Scope[]) this.zzm.toArray(new Scope[this.zzm.size()]);
            Arrays.sort(scopeArr, zza.zzq);
            for (Scope scope : scopeArr) {
                jSONArray.put(scope.getScopeUri());
            }
            jSONObject.put("grantedScopes", jSONArray);
            AppMethodBeat.o(10835);
            return jSONObject;
        } catch (JSONException e2) {
            RuntimeException runtimeException = new RuntimeException(e2);
            AppMethodBeat.o(10835);
            throw runtimeException;
        }
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(10832);
        if (obj == this) {
            AppMethodBeat.o(10832);
            return true;
        } else if (!(obj instanceof GoogleSignInAccount)) {
            AppMethodBeat.o(10832);
            return false;
        } else {
            GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
            if (!googleSignInAccount.getObfuscatedIdentifier().equals(getObfuscatedIdentifier()) || !googleSignInAccount.getRequestedScopes().equals(getRequestedScopes())) {
                AppMethodBeat.o(10832);
                return false;
            }
            AppMethodBeat.o(10832);
            return true;
        }
    }

    public Account getAccount() {
        AppMethodBeat.i(10825);
        if (this.zzg == null) {
            AppMethodBeat.o(10825);
            return null;
        }
        Account account = new Account(this.zzg, "com.google");
        AppMethodBeat.o(10825);
        return account;
    }

    public String getDisplayName() {
        return this.zzh;
    }

    public String getEmail() {
        return this.zzg;
    }

    public long getExpirationTimeSecs() {
        return this.zzk;
    }

    public String getFamilyName() {
        return this.zzo;
    }

    public String getGivenName() {
        return this.zzn;
    }

    public Set<Scope> getGrantedScopes() {
        AppMethodBeat.i(10828);
        HashSet hashSet = new HashSet(this.zzm);
        AppMethodBeat.o(10828);
        return hashSet;
    }

    public String getId() {
        return this.zze;
    }

    public String getIdToken() {
        return this.zzf;
    }

    public String getObfuscatedIdentifier() {
        return this.zzl;
    }

    public Uri getPhotoUrl() {
        return this.zzi;
    }

    public Set<Scope> getRequestedScopes() {
        AppMethodBeat.i(10829);
        HashSet hashSet = new HashSet(this.zzm);
        hashSet.addAll(this.zzp);
        AppMethodBeat.o(10829);
        return hashSet;
    }

    public String getServerAuthCode() {
        return this.zzj;
    }

    public int hashCode() {
        AppMethodBeat.i(10831);
        int hashCode = ((getObfuscatedIdentifier().hashCode() + JsApiGetABTestConfig.CTRL_INDEX) * 31) + getRequestedScopes().hashCode();
        AppMethodBeat.o(10831);
        return hashCode;
    }

    public boolean isExpired() {
        AppMethodBeat.i(10827);
        if (sClock.currentTimeMillis() / 1000 >= this.zzk - 300) {
            AppMethodBeat.o(10827);
            return true;
        }
        AppMethodBeat.o(10827);
        return false;
    }

    public GoogleSignInAccount requestExtraScopes(Scope... scopeArr) {
        AppMethodBeat.i(10826);
        if (scopeArr != null) {
            Collections.addAll(this.zzp, scopeArr);
        }
        AppMethodBeat.o(10826);
        return this;
    }

    public GoogleSignInAccount setServerAuthCode(String str) {
        this.zzj = str;
        return this;
    }

    public String toJson() {
        AppMethodBeat.i(10833);
        String jSONObject = zza().toString();
        AppMethodBeat.o(10833);
        return jSONObject;
    }

    public String toJsonForStorage() {
        AppMethodBeat.i(10834);
        JSONObject zza = zza();
        zza.remove("serverAuthCode");
        String jSONObject = zza.toString();
        AppMethodBeat.o(10834);
        return jSONObject;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(10830);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeString(parcel, 2, getId(), false);
        SafeParcelWriter.writeString(parcel, 3, getIdToken(), false);
        SafeParcelWriter.writeString(parcel, 4, getEmail(), false);
        SafeParcelWriter.writeString(parcel, 5, getDisplayName(), false);
        SafeParcelWriter.writeParcelable(parcel, 6, getPhotoUrl(), i2, false);
        SafeParcelWriter.writeString(parcel, 7, getServerAuthCode(), false);
        SafeParcelWriter.writeLong(parcel, 8, getExpirationTimeSecs());
        SafeParcelWriter.writeString(parcel, 9, getObfuscatedIdentifier(), false);
        SafeParcelWriter.writeTypedList(parcel, 10, this.zzm, false);
        SafeParcelWriter.writeString(parcel, 11, getGivenName(), false);
        SafeParcelWriter.writeString(parcel, 12, getFamilyName(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(10830);
    }
}
