package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.support.v4.e.b;
import android.view.View;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.signin.SignInOptions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@VisibleForTesting
public final class ClientSettings {
    public static final String KEY_CLIENT_SESSION_ID = "com.google.android.gms.common.internal.ClientSettings.sessionId";
    private final Set<Scope> zzcv;
    private final int zzcx;
    private final View zzcy;
    private final String zzcz;
    private final String zzda;
    private final Set<Scope> zzrz;
    private final Account zzs;
    private final Map<Api<?>, OptionalApiSettings> zzsa;
    private final SignInOptions zzsb;
    private Integer zzsc;

    public static final class Builder {
        private int zzcx = 0;
        private View zzcy;
        private String zzcz;
        private String zzda;
        private Account zzs;
        private Map<Api<?>, OptionalApiSettings> zzsa;
        private SignInOptions zzsb = SignInOptions.DEFAULT;
        private b<Scope> zzsd;

        public final Builder addAllRequiredScopes(Collection<Scope> collection) {
            AppMethodBeat.i(11809);
            if (this.zzsd == null) {
                this.zzsd = new b<>();
            }
            this.zzsd.addAll(collection);
            AppMethodBeat.o(11809);
            return this;
        }

        public final Builder addRequiredScope(Scope scope) {
            AppMethodBeat.i(11808);
            if (this.zzsd == null) {
                this.zzsd = new b<>();
            }
            this.zzsd.add(scope);
            AppMethodBeat.o(11808);
            return this;
        }

        public final ClientSettings build() {
            AppMethodBeat.i(11810);
            ClientSettings clientSettings = new ClientSettings(this.zzs, this.zzsd, this.zzsa, this.zzcx, this.zzcy, this.zzcz, this.zzda, this.zzsb);
            AppMethodBeat.o(11810);
            return clientSettings;
        }

        public final Builder setAccount(Account account) {
            this.zzs = account;
            return this;
        }

        public final Builder setGravityForPopups(int i2) {
            this.zzcx = i2;
            return this;
        }

        public final Builder setOptionalApiSettingsMap(Map<Api<?>, OptionalApiSettings> map) {
            this.zzsa = map;
            return this;
        }

        public final Builder setRealClientClassName(String str) {
            this.zzda = str;
            return this;
        }

        public final Builder setRealClientPackageName(String str) {
            this.zzcz = str;
            return this;
        }

        public final Builder setSignInOptions(SignInOptions signInOptions) {
            this.zzsb = signInOptions;
            return this;
        }

        public final Builder setViewForPopups(View view) {
            this.zzcy = view;
            return this;
        }
    }

    public static final class OptionalApiSettings {
        public final Set<Scope> mScopes;

        public OptionalApiSettings(Set<Scope> set) {
            AppMethodBeat.i(11811);
            Preconditions.checkNotNull(set);
            this.mScopes = Collections.unmodifiableSet(set);
            AppMethodBeat.o(11811);
        }
    }

    public ClientSettings(Account account, Set<Scope> set, Map<Api<?>, OptionalApiSettings> map, int i2, View view, String str, String str2, SignInOptions signInOptions) {
        AppMethodBeat.i(11813);
        this.zzs = account;
        this.zzcv = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        this.zzsa = map == null ? Collections.EMPTY_MAP : map;
        this.zzcy = view;
        this.zzcx = i2;
        this.zzcz = str;
        this.zzda = str2;
        this.zzsb = signInOptions;
        HashSet hashSet = new HashSet(this.zzcv);
        for (OptionalApiSettings optionalApiSettings : this.zzsa.values()) {
            hashSet.addAll(optionalApiSettings.mScopes);
        }
        this.zzrz = Collections.unmodifiableSet(hashSet);
        AppMethodBeat.o(11813);
    }

    public static ClientSettings createDefault(Context context) {
        AppMethodBeat.i(11812);
        ClientSettings buildClientSettings = new GoogleApiClient.Builder(context).buildClientSettings();
        AppMethodBeat.o(11812);
        return buildClientSettings;
    }

    @Nullable
    public final Account getAccount() {
        return this.zzs;
    }

    @Nullable
    @Deprecated
    public final String getAccountName() {
        if (this.zzs != null) {
            return this.zzs.name;
        }
        return null;
    }

    public final Account getAccountOrDefault() {
        AppMethodBeat.i(11814);
        if (this.zzs != null) {
            Account account = this.zzs;
            AppMethodBeat.o(11814);
            return account;
        }
        Account account2 = new Account("<<default account>>", "com.google");
        AppMethodBeat.o(11814);
        return account2;
    }

    public final Set<Scope> getAllRequestedScopes() {
        return this.zzrz;
    }

    public final Set<Scope> getApplicableScopes(Api<?> api) {
        AppMethodBeat.i(11815);
        OptionalApiSettings optionalApiSettings = this.zzsa.get(api);
        if (optionalApiSettings == null || optionalApiSettings.mScopes.isEmpty()) {
            Set<Scope> set = this.zzcv;
            AppMethodBeat.o(11815);
            return set;
        }
        HashSet hashSet = new HashSet(this.zzcv);
        hashSet.addAll(optionalApiSettings.mScopes);
        AppMethodBeat.o(11815);
        return hashSet;
    }

    @Nullable
    public final Integer getClientSessionId() {
        return this.zzsc;
    }

    public final int getGravityForPopups() {
        return this.zzcx;
    }

    public final Map<Api<?>, OptionalApiSettings> getOptionalApiSettings() {
        return this.zzsa;
    }

    @Nullable
    public final String getRealClientClassName() {
        return this.zzda;
    }

    @Nullable
    public final String getRealClientPackageName() {
        return this.zzcz;
    }

    public final Set<Scope> getRequiredScopes() {
        return this.zzcv;
    }

    @Nullable
    public final SignInOptions getSignInOptions() {
        return this.zzsb;
    }

    @Nullable
    public final View getViewForPopups() {
        return this.zzcy;
    }

    public final void setClientSessionId(Integer num) {
        this.zzsc = num;
    }
}
