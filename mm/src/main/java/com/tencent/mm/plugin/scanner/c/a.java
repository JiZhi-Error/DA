package com.tencent.mm.plugin.scanner.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/scanner/config/ScanClientConfigManager;", "", "()V", "TAG", "", "enableImageOCR", "", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "", "plugin-scan_release"})
public final class a {
    private static boolean CEh;
    public static final a CEi = new a();

    static {
        AppMethodBeat.i(240359);
        CEh = true;
        int a2 = ((b) g.af(b.class)).a(b.a.clicfg_scan_image_ocr_disable, 0);
        if (a2 == 1) {
            CEh = false;
        }
        Log.i("MicroMsg.ScanClientConfigManager", "ScanClientConfigManager init config: %d, enableImageOCR: %b", Integer.valueOf(a2), Boolean.valueOf(CEh));
        AppMethodBeat.o(240359);
    }

    private a() {
    }

    public static final boolean ePI() {
        return CEh;
    }
}
