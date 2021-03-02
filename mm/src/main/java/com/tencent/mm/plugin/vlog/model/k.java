package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/ExportConfig;", "", "()V", "FALLBACK_SIZE_CONFIG", "", "FALLBACK_SIZE_NONE", "KEY_FALLBACK_SIZE", "", "kvName", "getKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "isFallbackSize", "setFallbackSize", "", "fallback", "plugin-vlog_release"})
public final class k {
    private static final String GxN = GxN;
    static final String GxO = GxO;
    public static final k GxP = new k();

    static {
        AppMethodBeat.i(190565);
        AppMethodBeat.o(190565);
    }

    private k() {
    }

    public static MultiProcessMMKV getKV() {
        AppMethodBeat.i(190563);
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV(GxN);
        p.g(mmkv, "MultiProcessMMKV.getMMKV(kvName)");
        AppMethodBeat.o(190563);
        return mmkv;
    }

    public static int fAT() {
        AppMethodBeat.i(190564);
        int i2 = getKV().getInt(GxO, 0);
        AppMethodBeat.o(190564);
        return i2;
    }
}
