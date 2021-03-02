package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.util.BiConsumer;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.tencent.matrix.trace.core.AppMethodBeat;

@KeepForSdk
public abstract class TaskApiCall<A extends Api.AnyClient, ResultT> {
    private final Feature[] zzlz;
    private final boolean zzma;

    @KeepForSdk
    public static class Builder<A extends Api.AnyClient, ResultT> {
        private Feature[] zzlz;
        private boolean zzma;
        private BiConsumer<A, TaskCompletionSource<ResultT>> zzmb;

        private Builder() {
            this.zzma = true;
        }

        @KeepForSdk
        public TaskApiCall<A, ResultT> build() {
            AppMethodBeat.i(11155);
            if (this.zzmb == null) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("execute parameter required");
                AppMethodBeat.o(11155);
                throw illegalArgumentException;
            }
            zzcf zzcf = new zzcf(this, this.zzlz, this.zzma);
            AppMethodBeat.o(11155);
            return zzcf;
        }

        @KeepForSdk
        public Builder<A, ResultT> execute(BiConsumer<A, TaskCompletionSource<ResultT>> biConsumer) {
            this.zzmb = biConsumer;
            return this;
        }

        @KeepForSdk
        public Builder<A, ResultT> setAutoResolveMissingFeatures(boolean z) {
            this.zzma = z;
            return this;
        }

        @KeepForSdk
        public Builder<A, ResultT> setFeatures(Feature[] featureArr) {
            this.zzlz = featureArr;
            return this;
        }
    }

    @KeepForSdk
    @Deprecated
    public TaskApiCall() {
        this.zzlz = null;
        this.zzma = false;
    }

    @KeepForSdk
    private TaskApiCall(Feature[] featureArr, boolean z) {
        this.zzlz = featureArr;
        this.zzma = z;
    }

    @KeepForSdk
    public static <A extends Api.AnyClient, ResultT> Builder<A, ResultT> builder() {
        return new Builder<>();
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public abstract void doExecute(A a2, TaskCompletionSource<ResultT> taskCompletionSource);

    @KeepForSdk
    public boolean shouldAutoResolveMissingFeatures() {
        return this.zzma;
    }

    public final Feature[] zzca() {
        return this.zzlz;
    }
}
