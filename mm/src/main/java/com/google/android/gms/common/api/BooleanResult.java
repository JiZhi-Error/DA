package com.google.android.gms.common.api;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;

@KeepForSdk
public class BooleanResult implements Result {
    private final Status mStatus;
    private final boolean zzck;

    @KeepForSdk
    public BooleanResult(Status status, boolean z) {
        AppMethodBeat.i(10984);
        this.mStatus = (Status) Preconditions.checkNotNull(status, "Status must not be null");
        this.zzck = z;
        AppMethodBeat.o(10984);
    }

    @KeepForSdk
    public final boolean equals(Object obj) {
        AppMethodBeat.i(10986);
        if (obj == this) {
            AppMethodBeat.o(10986);
            return true;
        } else if (!(obj instanceof BooleanResult)) {
            AppMethodBeat.o(10986);
            return false;
        } else {
            BooleanResult booleanResult = (BooleanResult) obj;
            if (!this.mStatus.equals(booleanResult.mStatus) || this.zzck != booleanResult.zzck) {
                AppMethodBeat.o(10986);
                return false;
            }
            AppMethodBeat.o(10986);
            return true;
        }
    }

    @Override // com.google.android.gms.common.api.Result
    @KeepForSdk
    public Status getStatus() {
        return this.mStatus;
    }

    @KeepForSdk
    public boolean getValue() {
        return this.zzck;
    }

    @KeepForSdk
    public final int hashCode() {
        AppMethodBeat.i(10985);
        int hashCode = (this.zzck ? 1 : 0) + ((this.mStatus.hashCode() + JsApiGetABTestConfig.CTRL_INDEX) * 31);
        AppMethodBeat.o(10985);
        return hashCode;
    }
}
