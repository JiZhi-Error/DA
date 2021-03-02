package com.tencent.mm.plugin.scanner.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import java.io.File;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u001e\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/scanner/model/ScanAssetsManager;", "", "()V", "CENTER_DET_BIN_FILE_NAME", "", "CENTER_DET_PARAM_FILE_NAME", "TAG", "checkDirectory", "", "context", "Landroid/content/Context;", "copyFileFromAssets", "srcFileName", "dstFileName", "getCenterBinFilePath", "getCenterParamFilePath", "getSavedFileDirectory", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "plugin-scan_release"})
public final class v {
    public static final v CFW = new v();

    static {
        AppMethodBeat.i(52184);
        AppMethodBeat.o(52184);
    }

    private v() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x006b A[SYNTHETIC, Splitter:B:21:0x006b] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0070 A[Catch:{ Exception -> 0x00b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00bd A[SYNTHETIC, Splitter:B:39:0x00bd] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c2 A[Catch:{ Exception -> 0x00c9 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void j(android.content.Context r10, java.lang.String r11, java.lang.String r12) {
        /*
        // Method dump skipped, instructions count: 215
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.scanner.model.v.j(android.content.Context, java.lang.String, java.lang.String):void");
    }

    public static String cF(Context context) {
        AppMethodBeat.i(52183);
        p.h(context, "context");
        StringBuilder sb = new StringBuilder();
        File filesDir = context.getFilesDir();
        p.g(filesDir, "context.filesDir");
        String sb2 = sb.append(filesDir.getParent()).append("/scan_goods/").toString();
        AppMethodBeat.o(52183);
        return sb2;
    }
}
