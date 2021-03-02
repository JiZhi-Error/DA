package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import java.util.Arrays;

/* access modifiers changed from: package-private */
public final class zzacg {
    final int tag;
    final byte[] zzbrc;

    zzacg(int i2, byte[] bArr) {
        this.tag = i2;
        this.zzbrc = bArr;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(40309);
        if (obj == this) {
            AppMethodBeat.o(40309);
            return true;
        } else if (!(obj instanceof zzacg)) {
            AppMethodBeat.o(40309);
            return false;
        } else {
            zzacg zzacg = (zzacg) obj;
            if (this.tag != zzacg.tag || !Arrays.equals(this.zzbrc, zzacg.zzbrc)) {
                AppMethodBeat.o(40309);
                return false;
            }
            AppMethodBeat.o(40309);
            return true;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(40310);
        int hashCode = ((this.tag + JsApiGetABTestConfig.CTRL_INDEX) * 31) + Arrays.hashCode(this.zzbrc);
        AppMethodBeat.o(40310);
        return hashCode;
    }
}
