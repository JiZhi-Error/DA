package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.auth.api.signin.internal.HashAccumulator;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Constants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "GoogleSignInOptionsCreator")
public class GoogleSignInOptions extends AbstractSafeParcelable implements Api.ApiOptions.Optional, ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR = new GoogleSignInOptionsCreator();
    public static final GoogleSignInOptions DEFAULT_GAMES_SIGN_IN = new Builder().requestScopes(SCOPE_GAMES_LITE, new Scope[0]).build();
    public static final GoogleSignInOptions DEFAULT_SIGN_IN = new Builder().requestId().requestProfile().build();
    @VisibleForTesting
    public static final Scope SCOPE_EMAIL = new Scope(Scopes.EMAIL);
    @VisibleForTesting
    public static final Scope SCOPE_GAMES = new Scope(Scopes.GAMES);
    @VisibleForTesting
    public static final Scope SCOPE_GAMES_LITE = new Scope(Scopes.GAMES_LITE);
    @VisibleForTesting
    public static final Scope SCOPE_OPEN_ID = new Scope(Scopes.OPEN_ID);
    @VisibleForTesting
    public static final Scope SCOPE_PROFILE = new Scope(Scopes.PROFILE);
    private static Comparator<Scope> zzaa = new zzb();
    @SafeParcelable.VersionField(id = 1)
    private final int versionCode;
    @SafeParcelable.Field(getter = "getScopes", id = 2)
    private final ArrayList<Scope> zzr;
    @SafeParcelable.Field(getter = "getAccount", id = 3)
    private Account zzs;
    @SafeParcelable.Field(getter = "isIdTokenRequested", id = 4)
    private boolean zzt;
    @SafeParcelable.Field(getter = "isServerAuthCodeRequested", id = 5)
    private final boolean zzu;
    @SafeParcelable.Field(getter = "isForceCodeForRefreshToken", id = 6)
    private final boolean zzv;
    @SafeParcelable.Field(getter = "getServerClientId", id = 7)
    private String zzw;
    @SafeParcelable.Field(getter = "getHostedDomain", id = 8)
    private String zzx;
    @SafeParcelable.Field(getter = "getExtensions", id = 9)
    private ArrayList<GoogleSignInOptionsExtensionParcelable> zzy;
    private Map<Integer, GoogleSignInOptionsExtensionParcelable> zzz;

    public static final class Builder {
        private Set<Scope> mScopes = new HashSet();
        private Map<Integer, GoogleSignInOptionsExtensionParcelable> zzab = new HashMap();
        private Account zzs;
        private boolean zzt;
        private boolean zzu;
        private boolean zzv;
        private String zzw;
        private String zzx;

        public Builder() {
            AppMethodBeat.i(10841);
            AppMethodBeat.o(10841);
        }

        public Builder(GoogleSignInOptions googleSignInOptions) {
            AppMethodBeat.i(10842);
            Preconditions.checkNotNull(googleSignInOptions);
            this.mScopes = new HashSet(googleSignInOptions.zzr);
            this.zzu = googleSignInOptions.zzu;
            this.zzv = googleSignInOptions.zzv;
            this.zzt = googleSignInOptions.zzt;
            this.zzw = googleSignInOptions.zzw;
            this.zzs = googleSignInOptions.zzs;
            this.zzx = googleSignInOptions.zzx;
            this.zzab = GoogleSignInOptions.zzb(googleSignInOptions.zzy);
            AppMethodBeat.o(10842);
        }

        private final String zza(String str) {
            AppMethodBeat.i(10856);
            Preconditions.checkNotEmpty(str);
            Preconditions.checkArgument(this.zzw == null || this.zzw.equals(str), "two different server client ids provided");
            AppMethodBeat.o(10856);
            return str;
        }

        public final Builder addExtension(GoogleSignInOptionsExtension googleSignInOptionsExtension) {
            AppMethodBeat.i(10854);
            if (this.zzab.containsKey(Integer.valueOf(googleSignInOptionsExtension.getExtensionType()))) {
                IllegalStateException illegalStateException = new IllegalStateException("Only one extension per type may be added");
                AppMethodBeat.o(10854);
                throw illegalStateException;
            }
            if (googleSignInOptionsExtension.getImpliedScopes() != null) {
                this.mScopes.addAll(googleSignInOptionsExtension.getImpliedScopes());
            }
            this.zzab.put(Integer.valueOf(googleSignInOptionsExtension.getExtensionType()), new GoogleSignInOptionsExtensionParcelable(googleSignInOptionsExtension));
            AppMethodBeat.o(10854);
            return this;
        }

        public final GoogleSignInOptions build() {
            AppMethodBeat.i(10855);
            if (this.mScopes.contains(GoogleSignInOptions.SCOPE_GAMES) && this.mScopes.contains(GoogleSignInOptions.SCOPE_GAMES_LITE)) {
                this.mScopes.remove(GoogleSignInOptions.SCOPE_GAMES_LITE);
            }
            if (this.zzt && (this.zzs == null || !this.mScopes.isEmpty())) {
                requestId();
            }
            GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions(3, new ArrayList(this.mScopes), this.zzs, this.zzt, this.zzu, this.zzv, this.zzw, this.zzx, this.zzab, null);
            AppMethodBeat.o(10855);
            return googleSignInOptions;
        }

        public final Builder requestEmail() {
            AppMethodBeat.i(10844);
            this.mScopes.add(GoogleSignInOptions.SCOPE_EMAIL);
            AppMethodBeat.o(10844);
            return this;
        }

        public final Builder requestId() {
            AppMethodBeat.i(10843);
            this.mScopes.add(GoogleSignInOptions.SCOPE_OPEN_ID);
            AppMethodBeat.o(10843);
            return this;
        }

        public final Builder requestIdToken(String str) {
            AppMethodBeat.i(10847);
            this.zzt = true;
            this.zzw = zza(str);
            AppMethodBeat.o(10847);
            return this;
        }

        public final Builder requestPhatIdToken(String str) {
            AppMethodBeat.i(10848);
            Builder requestEmail = requestIdToken(str).requestProfile().requestEmail();
            AppMethodBeat.o(10848);
            return requestEmail;
        }

        public final Builder requestProfile() {
            AppMethodBeat.i(10845);
            this.mScopes.add(GoogleSignInOptions.SCOPE_PROFILE);
            AppMethodBeat.o(10845);
            return this;
        }

        public final Builder requestScopes(Scope scope, Scope... scopeArr) {
            AppMethodBeat.i(10846);
            this.mScopes.add(scope);
            this.mScopes.addAll(Arrays.asList(scopeArr));
            AppMethodBeat.o(10846);
            return this;
        }

        public final Builder requestServerAuthCode(String str) {
            AppMethodBeat.i(10849);
            Builder requestServerAuthCode = requestServerAuthCode(str, false);
            AppMethodBeat.o(10849);
            return requestServerAuthCode;
        }

        public final Builder requestServerAuthCode(String str, boolean z) {
            AppMethodBeat.i(10850);
            this.zzu = true;
            this.zzw = zza(str);
            this.zzv = z;
            AppMethodBeat.o(10850);
            return this;
        }

        public final Builder setAccount(Account account) {
            AppMethodBeat.i(10852);
            this.zzs = (Account) Preconditions.checkNotNull(account);
            AppMethodBeat.o(10852);
            return this;
        }

        public final Builder setAccountName(String str) {
            AppMethodBeat.i(10851);
            this.zzs = new Account(Preconditions.checkNotEmpty(str), "com.google");
            AppMethodBeat.o(10851);
            return this;
        }

        public final Builder setHostedDomain(String str) {
            AppMethodBeat.i(10853);
            this.zzx = Preconditions.checkNotEmpty(str);
            AppMethodBeat.o(10853);
            return this;
        }
    }

    static {
        AppMethodBeat.i(10871);
        AppMethodBeat.o(10871);
    }

    @SafeParcelable.Constructor
    GoogleSignInOptions(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) ArrayList<Scope> arrayList, @SafeParcelable.Param(id = 3) Account account, @SafeParcelable.Param(id = 4) boolean z, @SafeParcelable.Param(id = 5) boolean z2, @SafeParcelable.Param(id = 6) boolean z3, @SafeParcelable.Param(id = 7) String str, @SafeParcelable.Param(id = 8) String str2, @SafeParcelable.Param(id = 9) ArrayList<GoogleSignInOptionsExtensionParcelable> arrayList2) {
        this(i2, arrayList, account, z, z2, z3, str, str2, zza(arrayList2));
        AppMethodBeat.i(10858);
        AppMethodBeat.o(10858);
    }

    private GoogleSignInOptions(int i2, ArrayList<Scope> arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, Map<Integer, GoogleSignInOptionsExtensionParcelable> map) {
        AppMethodBeat.i(10859);
        this.versionCode = i2;
        this.zzr = arrayList;
        this.zzs = account;
        this.zzt = z;
        this.zzu = z2;
        this.zzv = z3;
        this.zzw = str;
        this.zzx = str2;
        this.zzy = new ArrayList<>(map.values());
        this.zzz = map;
        AppMethodBeat.o(10859);
    }

    /* synthetic */ GoogleSignInOptions(int i2, ArrayList arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, Map map, zzb zzb) {
        this(3, arrayList, account, z, z2, z3, str, str2, map);
    }

    public static GoogleSignInOptions fromJsonString(String str) {
        AppMethodBeat.i(10857);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(10857);
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray(Constants.KEY_SCOPES);
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            hashSet.add(new Scope(jSONArray.getString(i2)));
        }
        String optString = jSONObject.optString("accountName", null);
        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions(3, new ArrayList(hashSet), !TextUtils.isEmpty(optString) ? new Account(optString, "com.google") : null, jSONObject.getBoolean("idTokenRequested"), jSONObject.getBoolean("serverAuthRequested"), jSONObject.getBoolean("forceCodeForRefreshToken"), jSONObject.optString("serverClientId", null), jSONObject.optString("hostedDomain", null), new HashMap());
        AppMethodBeat.o(10857);
        return googleSignInOptions;
    }

    private static Map<Integer, GoogleSignInOptionsExtensionParcelable> zza(List<GoogleSignInOptionsExtensionParcelable> list) {
        AppMethodBeat.i(10864);
        HashMap hashMap = new HashMap();
        if (list == null) {
            AppMethodBeat.o(10864);
            return hashMap;
        }
        for (GoogleSignInOptionsExtensionParcelable googleSignInOptionsExtensionParcelable : list) {
            hashMap.put(Integer.valueOf(googleSignInOptionsExtensionParcelable.getType()), googleSignInOptionsExtensionParcelable);
        }
        AppMethodBeat.o(10864);
        return hashMap;
    }

    private final JSONObject zza() {
        AppMethodBeat.i(10869);
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.zzr, zzaa);
            ArrayList<Scope> arrayList = this.zzr;
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Scope scope = arrayList.get(i2);
                i2++;
                jSONArray.put(scope.getScopeUri());
            }
            jSONObject.put(Constants.KEY_SCOPES, jSONArray);
            if (this.zzs != null) {
                jSONObject.put("accountName", this.zzs.name);
            }
            jSONObject.put("idTokenRequested", this.zzt);
            jSONObject.put("forceCodeForRefreshToken", this.zzv);
            jSONObject.put("serverAuthRequested", this.zzu);
            if (!TextUtils.isEmpty(this.zzw)) {
                jSONObject.put("serverClientId", this.zzw);
            }
            if (!TextUtils.isEmpty(this.zzx)) {
                jSONObject.put("hostedDomain", this.zzx);
            }
            AppMethodBeat.o(10869);
            return jSONObject;
        } catch (JSONException e2) {
            RuntimeException runtimeException = new RuntimeException(e2);
            AppMethodBeat.o(10869);
            throw runtimeException;
        }
    }

    static /* synthetic */ Map zzb(List list) {
        AppMethodBeat.i(10870);
        Map<Integer, GoogleSignInOptionsExtensionParcelable> zza = zza(list);
        AppMethodBeat.o(10870);
        return zza;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(10866);
        if (obj == null) {
            AppMethodBeat.o(10866);
            return false;
        }
        try {
            GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) obj;
            if (this.zzy.size() > 0 || googleSignInOptions.zzy.size() > 0) {
                AppMethodBeat.o(10866);
                return false;
            } else if (this.zzr.size() != googleSignInOptions.getScopes().size() || !this.zzr.containsAll(googleSignInOptions.getScopes())) {
                AppMethodBeat.o(10866);
                return false;
            } else {
                if (this.zzs != null ? this.zzs.equals(googleSignInOptions.getAccount()) : googleSignInOptions.getAccount() == null) {
                    if (!TextUtils.isEmpty(this.zzw) ? this.zzw.equals(googleSignInOptions.getServerClientId()) : TextUtils.isEmpty(googleSignInOptions.getServerClientId())) {
                        if (this.zzv == googleSignInOptions.isForceCodeForRefreshToken() && this.zzt == googleSignInOptions.isIdTokenRequested() && this.zzu == googleSignInOptions.isServerAuthCodeRequested()) {
                            AppMethodBeat.o(10866);
                            return true;
                        }
                    }
                }
                AppMethodBeat.o(10866);
                return false;
            }
        } catch (ClassCastException e2) {
            AppMethodBeat.o(10866);
            return false;
        }
    }

    public Account getAccount() {
        return this.zzs;
    }

    public GoogleSignInOptionsExtensionParcelable getExtension(@GoogleSignInOptionsExtension.TypeId int i2) {
        AppMethodBeat.i(10863);
        GoogleSignInOptionsExtensionParcelable googleSignInOptionsExtensionParcelable = this.zzz.get(Integer.valueOf(i2));
        AppMethodBeat.o(10863);
        return googleSignInOptionsExtensionParcelable;
    }

    public ArrayList<GoogleSignInOptionsExtensionParcelable> getExtensions() {
        return this.zzy;
    }

    public String getHostedDomain() {
        return this.zzx;
    }

    public Scope[] getScopeArray() {
        AppMethodBeat.i(10861);
        Scope[] scopeArr = (Scope[]) this.zzr.toArray(new Scope[this.zzr.size()]);
        AppMethodBeat.o(10861);
        return scopeArr;
    }

    public ArrayList<Scope> getScopes() {
        AppMethodBeat.i(10860);
        ArrayList<Scope> arrayList = new ArrayList<>(this.zzr);
        AppMethodBeat.o(10860);
        return arrayList;
    }

    public String getServerClientId() {
        return this.zzw;
    }

    public boolean hasExtension(@GoogleSignInOptionsExtension.TypeId int i2) {
        AppMethodBeat.i(10862);
        boolean containsKey = this.zzz.containsKey(Integer.valueOf(i2));
        AppMethodBeat.o(10862);
        return containsKey;
    }

    public int hashCode() {
        AppMethodBeat.i(10867);
        ArrayList arrayList = new ArrayList();
        ArrayList<Scope> arrayList2 = this.zzr;
        int size = arrayList2.size();
        int i2 = 0;
        while (i2 < size) {
            Scope scope = arrayList2.get(i2);
            i2++;
            arrayList.add(scope.getScopeUri());
        }
        Collections.sort(arrayList);
        int hash = new HashAccumulator().addObject(arrayList).addObject(this.zzs).addObject(this.zzw).addBoolean(this.zzv).addBoolean(this.zzt).addBoolean(this.zzu).hash();
        AppMethodBeat.o(10867);
        return hash;
    }

    public boolean isForceCodeForRefreshToken() {
        return this.zzv;
    }

    public boolean isIdTokenRequested() {
        return this.zzt;
    }

    public boolean isServerAuthCodeRequested() {
        return this.zzu;
    }

    public String toJson() {
        AppMethodBeat.i(10868);
        String jSONObject = zza().toString();
        AppMethodBeat.o(10868);
        return jSONObject;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(10865);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeTypedList(parcel, 2, getScopes(), false);
        SafeParcelWriter.writeParcelable(parcel, 3, getAccount(), i2, false);
        SafeParcelWriter.writeBoolean(parcel, 4, isIdTokenRequested());
        SafeParcelWriter.writeBoolean(parcel, 5, isServerAuthCodeRequested());
        SafeParcelWriter.writeBoolean(parcel, 6, isForceCodeForRefreshToken());
        SafeParcelWriter.writeString(parcel, 7, getServerClientId(), false);
        SafeParcelWriter.writeString(parcel, 8, getHostedDomain(), false);
        SafeParcelWriter.writeTypedList(parcel, 9, getExtensions(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(10865);
    }
}
