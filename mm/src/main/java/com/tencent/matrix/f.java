package com.tencent.matrix;

import com.tencent.c.a.a;
import com.tencent.mm.plugin.expt.h.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;

public final class f implements a {
    private final MultiProcessMMKV cQe = MultiProcessMMKV.getMultiDefault();

    @Override // com.tencent.c.a.a
    public final String get(String str, String str2) {
        return d.cRY().b(str, str2, false, false);
    }

    @Override // com.tencent.c.a.a
    public final int get(String str, int i2) {
        int i3;
        if (!str.equals(a.EnumC0131a.clicfg_matrix_trace_evil_method_threshold.name()) || (i3 = this.cQe.getInt(a.EnumC0131a.clicfg_matrix_trace_evil_method_threshold.name(), -1)) == -1) {
            String str2 = get(str, "");
            return !Util.isNullOrNil(str2) ? Util.getInt(str2, i2) : i2;
        }
        Log.i("MicroMsg.XDynamicConfig", "[get] local! key=%s value=%s", str, Integer.valueOf(i3));
        return i3;
    }

    @Override // com.tencent.c.a.a
    public final long get(String str, long j2) {
        String str2 = get(str, "");
        return Util.isNullOrNil(str2) ? j2 : Util.getLong(str2, j2);
    }

    @Override // com.tencent.c.a.a
    public final boolean get(String str, boolean z) {
        int i2;
        String str2 = get(str, "");
        if (Util.isNullOrNil(str2)) {
            return z;
        }
        if (z) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        return Util.getInt(str2, i2) != 0;
    }

    @Override // com.tencent.c.a.a
    public final float ei(String str) {
        String str2 = get(str, "");
        if (Util.isNullOrNil(str2)) {
            return 0.9f;
        }
        return Util.getFloat(str2, 0.9f);
    }
}
