package com.tencent.mm.plugin.recordvideo.e;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0004J\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/util/WeSeeUtil;", "", "()V", "TAG", "", "buildCameraEntranceSessionId", AppMeasurement.Param.TIMESTAMP, "", "bytesToHexString", "bArray", "", "checkWeishiInstalled", "", "context", "Landroid/content/Context;", "doCpatureWeSeeSight", "", "videoPath", "doDownloadWeSee", "plugin-recordvideo_release"})
public final class i {
    public static final i Ciy = new i();

    static {
        AppMethodBeat.i(76229);
        AppMethodBeat.o(76229);
    }

    private i() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0043, code lost:
        if (com.tencent.mm.sdk.platformtools.Util.isEqual(r2, "2A281593D71DF33374E6124E9106DF08") != false) goto L_0x0045;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean gQ(android.content.Context r10) {
        /*
        // Method dump skipped, instructions count: 166
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.recordvideo.e.i.gQ(android.content.Context):boolean");
    }

    public static void gR(Context context) {
        AppMethodBeat.i(76227);
        p.h(context, "context");
        Intent intent = new Intent();
        intent.putExtra("rawUrl", "https://isee.weishi.qq.com/static/release/group_10/528a4494-9ce7-4ac8-a763-247d84d07dae.html?_wwv=4096&chid=205000000&attach=cp_reserves3_2230000000");
        c.b(context, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(76227);
    }

    public static String Io(long j2) {
        AppMethodBeat.i(76228);
        StringBuilder sb = new StringBuilder();
        p.g(g.aAf(), "MMKernel.account()");
        String sb2 = sb.append(a.ayV()).append("_").append(j2).toString();
        p.g(sb2, "sb.append(MMKernel.accou…end(timestamp).toString()");
        AppMethodBeat.o(76228);
        return sb2;
    }
}
