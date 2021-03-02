package com.google.android.gms.wearable;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.support.v4.e.m;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.wearable.internal.zzaa;
import com.google.android.gms.wearable.internal.zzaj;
import com.google.android.gms.wearable.internal.zzao;
import com.google.android.gms.wearable.internal.zzbv;
import com.google.android.gms.wearable.internal.zzbw;
import com.google.android.gms.wearable.internal.zzcj;
import com.google.android.gms.wearable.internal.zzeu;
import com.google.android.gms.wearable.internal.zzez;
import com.google.android.gms.wearable.internal.zzfg;
import com.google.android.gms.wearable.internal.zzfl;
import com.google.android.gms.wearable.internal.zzgi;
import com.google.android.gms.wearable.internal.zzh;
import com.google.android.gms.wearable.internal.zzhg;
import com.google.android.gms.wearable.internal.zzhq;
import com.google.android.gms.wearable.internal.zzk;
import com.google.android.gms.wearable.internal.zzo;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class Wearable {
    @Deprecated
    public static final Api<WearableOptions> API = new Api<>("Wearable.API", CLIENT_BUILDER, CLIENT_KEY);
    private static final Api.AbstractClientBuilder<zzhg, WearableOptions> CLIENT_BUILDER = new zzj();
    private static final Api.ClientKey<zzhg> CLIENT_KEY = new Api.ClientKey<>();
    @Deprecated
    public static final CapabilityApi CapabilityApi = new zzo();
    @Deprecated
    public static final ChannelApi ChannelApi = new zzaj();
    @Deprecated
    public static final DataApi DataApi = new zzbw();
    @Deprecated
    public static final MessageApi MessageApi = new zzeu();
    @Deprecated
    public static final NodeApi NodeApi = new zzfg();
    @Deprecated
    private static final zzi zzaa = new zzgi();
    @Deprecated
    private static final zzu zzab = new zzhq();
    @Deprecated
    private static final zzc zzx = new zzk();
    @Deprecated
    private static final zza zzy = new zzh();
    @Deprecated
    private static final zzf zzz = new zzbv();

    public static final class WearableOptions implements Api.ApiOptions.Optional {
        private final Looper zzac;

        public static class Builder {
            private Looper zzac;

            public WearableOptions build() {
                AppMethodBeat.i(100872);
                WearableOptions wearableOptions = new WearableOptions(this, null);
                AppMethodBeat.o(100872);
                return wearableOptions;
            }

            public Builder setLooper(Looper looper) {
                this.zzac = looper;
                return this;
            }
        }

        private WearableOptions(Builder builder) {
            AppMethodBeat.i(100873);
            this.zzac = builder.zzac;
            AppMethodBeat.o(100873);
        }

        /* synthetic */ WearableOptions(Builder builder, zzj zzj) {
            this(builder);
        }

        private final GoogleApi.Settings zza() {
            AppMethodBeat.i(100874);
            if (this.zzac != null) {
                GoogleApi.Settings build = new GoogleApi.Settings.Builder().setLooper(this.zzac).build();
                AppMethodBeat.o(100874);
                return build;
            }
            GoogleApi.Settings settings = GoogleApi.Settings.DEFAULT_SETTINGS;
            AppMethodBeat.o(100874);
            return settings;
        }

        static /* synthetic */ GoogleApi.Settings zza(WearableOptions wearableOptions) {
            AppMethodBeat.i(100875);
            GoogleApi.Settings zza = wearableOptions.zza();
            AppMethodBeat.o(100875);
            return zza;
        }
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.google.android.gms.wearable.internal.zzk, com.google.android.gms.wearable.zzc] */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.google.android.gms.wearable.zza, com.google.android.gms.wearable.internal.zzh] */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.google.android.gms.wearable.internal.zzbv, com.google.android.gms.wearable.zzf] */
    /* JADX WARN: Type inference failed for: r0v8, types: [com.google.android.gms.wearable.zzi, com.google.android.gms.wearable.internal.zzgi] */
    /* JADX WARN: Type inference failed for: r0v9, types: [com.google.android.gms.wearable.internal.zzhq, com.google.android.gms.wearable.zzu] */
    static {
        AppMethodBeat.i(100896);
        AppMethodBeat.o(100896);
    }

    private Wearable() {
    }

    public static CapabilityClient getCapabilityClient(Activity activity) {
        AppMethodBeat.i(100886);
        zzaa zzaa2 = new zzaa(activity, GoogleApi.Settings.DEFAULT_SETTINGS);
        AppMethodBeat.o(100886);
        return zzaa2;
    }

    public static CapabilityClient getCapabilityClient(Activity activity, WearableOptions wearableOptions) {
        AppMethodBeat.i(100887);
        m.checkNotNull(wearableOptions, "options must not be null");
        zzaa zzaa2 = new zzaa(activity, WearableOptions.zza(wearableOptions));
        AppMethodBeat.o(100887);
        return zzaa2;
    }

    public static CapabilityClient getCapabilityClient(Context context) {
        AppMethodBeat.i(100884);
        zzaa zzaa2 = new zzaa(context, GoogleApi.Settings.DEFAULT_SETTINGS);
        AppMethodBeat.o(100884);
        return zzaa2;
    }

    public static CapabilityClient getCapabilityClient(Context context, WearableOptions wearableOptions) {
        AppMethodBeat.i(100885);
        m.checkNotNull(wearableOptions, "options must not be null");
        zzaa zzaa2 = new zzaa(context, WearableOptions.zza(wearableOptions));
        AppMethodBeat.o(100885);
        return zzaa2;
    }

    public static ChannelClient getChannelClient(Activity activity) {
        AppMethodBeat.i(100894);
        zzao zzao = new zzao(activity, GoogleApi.Settings.DEFAULT_SETTINGS);
        AppMethodBeat.o(100894);
        return zzao;
    }

    public static ChannelClient getChannelClient(Activity activity, WearableOptions wearableOptions) {
        AppMethodBeat.i(100895);
        m.checkNotNull(wearableOptions, "options must not be null");
        zzao zzao = new zzao(activity, WearableOptions.zza(wearableOptions));
        AppMethodBeat.o(100895);
        return zzao;
    }

    public static ChannelClient getChannelClient(Context context) {
        AppMethodBeat.i(100892);
        zzao zzao = new zzao(context, GoogleApi.Settings.DEFAULT_SETTINGS);
        AppMethodBeat.o(100892);
        return zzao;
    }

    public static ChannelClient getChannelClient(Context context, WearableOptions wearableOptions) {
        AppMethodBeat.i(100893);
        m.checkNotNull(wearableOptions, "options must not be null");
        zzao zzao = new zzao(context, WearableOptions.zza(wearableOptions));
        AppMethodBeat.o(100893);
        return zzao;
    }

    public static DataClient getDataClient(Activity activity) {
        AppMethodBeat.i(100878);
        zzcj zzcj = new zzcj(activity, GoogleApi.Settings.DEFAULT_SETTINGS);
        AppMethodBeat.o(100878);
        return zzcj;
    }

    public static DataClient getDataClient(Activity activity, WearableOptions wearableOptions) {
        AppMethodBeat.i(100879);
        m.checkNotNull(wearableOptions, "options must not be null");
        zzcj zzcj = new zzcj(activity, WearableOptions.zza(wearableOptions));
        AppMethodBeat.o(100879);
        return zzcj;
    }

    public static DataClient getDataClient(Context context) {
        AppMethodBeat.i(100876);
        zzcj zzcj = new zzcj(context, GoogleApi.Settings.DEFAULT_SETTINGS);
        AppMethodBeat.o(100876);
        return zzcj;
    }

    public static DataClient getDataClient(Context context, WearableOptions wearableOptions) {
        AppMethodBeat.i(100877);
        m.checkNotNull(wearableOptions, "options must not be null");
        zzcj zzcj = new zzcj(context, WearableOptions.zza(wearableOptions));
        AppMethodBeat.o(100877);
        return zzcj;
    }

    public static MessageClient getMessageClient(Activity activity) {
        AppMethodBeat.i(100882);
        zzez zzez = new zzez(activity, GoogleApi.Settings.DEFAULT_SETTINGS);
        AppMethodBeat.o(100882);
        return zzez;
    }

    public static MessageClient getMessageClient(Activity activity, WearableOptions wearableOptions) {
        AppMethodBeat.i(100883);
        m.checkNotNull(wearableOptions, "options must not be null");
        zzez zzez = new zzez(activity, WearableOptions.zza(wearableOptions));
        AppMethodBeat.o(100883);
        return zzez;
    }

    public static MessageClient getMessageClient(Context context) {
        AppMethodBeat.i(100880);
        zzez zzez = new zzez(context, GoogleApi.Settings.DEFAULT_SETTINGS);
        AppMethodBeat.o(100880);
        return zzez;
    }

    public static MessageClient getMessageClient(Context context, WearableOptions wearableOptions) {
        AppMethodBeat.i(100881);
        m.checkNotNull(wearableOptions, "options must not be null");
        zzez zzez = new zzez(context, WearableOptions.zza(wearableOptions));
        AppMethodBeat.o(100881);
        return zzez;
    }

    public static NodeClient getNodeClient(Activity activity) {
        AppMethodBeat.i(100890);
        zzfl zzfl = new zzfl(activity, GoogleApi.Settings.DEFAULT_SETTINGS);
        AppMethodBeat.o(100890);
        return zzfl;
    }

    public static NodeClient getNodeClient(Activity activity, WearableOptions wearableOptions) {
        AppMethodBeat.i(100891);
        m.checkNotNull(wearableOptions, "options must not be null");
        zzfl zzfl = new zzfl(activity, WearableOptions.zza(wearableOptions));
        AppMethodBeat.o(100891);
        return zzfl;
    }

    public static NodeClient getNodeClient(Context context) {
        AppMethodBeat.i(100888);
        zzfl zzfl = new zzfl(context, GoogleApi.Settings.DEFAULT_SETTINGS);
        AppMethodBeat.o(100888);
        return zzfl;
    }

    public static NodeClient getNodeClient(Context context, WearableOptions wearableOptions) {
        AppMethodBeat.i(100889);
        m.checkNotNull(wearableOptions, "options must not be null");
        zzfl zzfl = new zzfl(context, WearableOptions.zza(wearableOptions));
        AppMethodBeat.o(100889);
        return zzfl;
    }
}
