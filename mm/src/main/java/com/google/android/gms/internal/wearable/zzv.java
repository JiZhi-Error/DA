package com.google.android.gms.internal.wearable;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import java.util.Arrays;

/* access modifiers changed from: package-private */
public final class zzv {
    final int tag;
    final byte[] zzhm;

    zzv(int i2, byte[] bArr) {
        this.tag = i2;
        this.zzhm = bArr;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(100765);
        if (obj == this) {
            AppMethodBeat.o(100765);
            return true;
        } else if (!(obj instanceof zzv)) {
            AppMethodBeat.o(100765);
            return false;
        } else {
            zzv zzv = (zzv) obj;
            if (this.tag != zzv.tag || !Arrays.equals(this.zzhm, zzv.zzhm)) {
                AppMethodBeat.o(100765);
                return false;
            }
            AppMethodBeat.o(100765);
            return true;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(100766);
        int hashCode = ((this.tag + JsApiGetABTestConfig.CTRL_INDEX) * 31) + Arrays.hashCode(this.zzhm);
        AppMethodBeat.o(100766);
        return hashCode;
    }
}
