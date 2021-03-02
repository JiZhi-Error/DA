package com.tencent.mm.plugin.scanner.util;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J3\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0010\u0010\u0007\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/scanner/util/ScanProcessorCommand;", "Lcom/tencent/mm/pluginsdk/cmd/ProcessorCommand;", "()V", "processCommand", "", "context", "Landroid/content/Context;", "args", "", "", ch.COL_USERNAME, "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Companion", "scan-sdk_release"})
public final class g implements com.tencent.mm.pluginsdk.cmd.a {
    public static final a CTH = new a((byte) 0);

    static {
        AppMethodBeat.i(194778);
        AppMethodBeat.o(194778);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/scanner/util/ScanProcessorCommand$Companion;", "", "()V", "COMMAND_SCAN", "", "SCAN_DEBUG", "SCAN_DEBUG_SHOW_DEBUG_VIEW", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "", "scan-sdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.pluginsdk.cmd.a
    public final boolean a(Context context, String[] strArr, String str) {
        boolean z = false;
        AppMethodBeat.i(194777);
        if (strArr != null && p.j("//scan", strArr[0]) && p.j("showDebug", strArr[1]) && strArr.length > 2) {
            MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV("ScanDebug");
            if (Util.getInt(strArr[2], 0) == 1) {
                z = true;
            }
            singleMMKV.putBoolean("scan_debug_show_debug_view", z);
            singleMMKV.apply();
            AppMethodBeat.o(194777);
            return true;
        } else if (strArr == null || !p.j("//scan", strArr[0]) || !p.j("clearSearch", strArr[1]) || strArr.length <= 1) {
            AppMethodBeat.o(194777);
            return false;
        } else {
            MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV(z.aTY() + "__image_gallery_search_preview_slot_mmkv_key__");
            if (mmkv != null) {
                mmkv.clearAll();
            }
            AppMethodBeat.o(194777);
            return true;
        }
    }
}
