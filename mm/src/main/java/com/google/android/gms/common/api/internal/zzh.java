package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.internal.Objects;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzh<O extends Api.ApiOptions> {
    private final Api<O> mApi;
    private final O zzcl;
    private final boolean zzeb = true;
    private final int zzec;

    private zzh(Api<O> api) {
        AppMethodBeat.i(11410);
        this.mApi = api;
        this.zzcl = null;
        this.zzec = System.identityHashCode(this);
        AppMethodBeat.o(11410);
    }

    private zzh(Api<O> api, O o) {
        AppMethodBeat.i(11409);
        this.mApi = api;
        this.zzcl = o;
        this.zzec = Objects.hashCode(this.mApi, this.zzcl);
        AppMethodBeat.o(11409);
    }

    public static <O extends Api.ApiOptions> zzh<O> zza(Api<O> api) {
        AppMethodBeat.i(11412);
        zzh<O> zzh = new zzh<>(api);
        AppMethodBeat.o(11412);
        return zzh;
    }

    public static <O extends Api.ApiOptions> zzh<O> zza(Api<O> api, O o) {
        AppMethodBeat.i(11411);
        zzh<O> zzh = new zzh<>(api, o);
        AppMethodBeat.o(11411);
        return zzh;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(11414);
        if (obj == this) {
            AppMethodBeat.o(11414);
            return true;
        } else if (!(obj instanceof zzh)) {
            AppMethodBeat.o(11414);
            return false;
        } else {
            zzh zzh = (zzh) obj;
            if (this.zzeb || zzh.zzeb || !Objects.equal(this.mApi, zzh.mApi) || !Objects.equal(this.zzcl, zzh.zzcl)) {
                AppMethodBeat.o(11414);
                return false;
            }
            AppMethodBeat.o(11414);
            return true;
        }
    }

    public final int hashCode() {
        return this.zzec;
    }

    public final String zzq() {
        AppMethodBeat.i(11413);
        String name = this.mApi.getName();
        AppMethodBeat.o(11413);
        return name;
    }
}
