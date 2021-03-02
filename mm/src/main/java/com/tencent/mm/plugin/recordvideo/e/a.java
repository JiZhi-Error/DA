package com.tencent.mm.plugin.recordvideo.e;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/util/CheckDownloadUtil;", "", "()V", "TAG", "", "bytesToHexString", "bArray", "", "checkAppInstalled", "", "context", "Landroid/content/Context;", AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME, "publicKey", "doDownloadApp", "", "downloadUrl", "plugin-recordvideo_release"})
public final class a {
    public static final a ChV = new a();

    static {
        AppMethodBeat.i(237974);
        AppMethodBeat.o(237974);
    }

    private a() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0049, code lost:
        if (com.tencent.mm.sdk.platformtools.Util.isEqual(r2, r12) != false) goto L_0x004b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean G(android.content.Context r10, java.lang.String r11, java.lang.String r12) {
        /*
        // Method dump skipped, instructions count: 192
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.recordvideo.e.a.G(android.content.Context, java.lang.String, java.lang.String):boolean");
    }

    public static void bt(Context context, String str) {
        AppMethodBeat.i(237973);
        p.h(context, "context");
        p.h(str, "downloadUrl");
        Log.i("MicroMsg.CheckDownloadUtil", "download SecondCut url ".concat(String.valueOf(str)));
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        c.b(context, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(237973);
    }
}
