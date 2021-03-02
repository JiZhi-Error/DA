package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0007J,\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0007J<\u0010\f\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R*\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00048G@GX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/report/AppBrandStarOperationReporter;", "", "()V", "TAG", "", "value", "pullDownOpenSceneId", "getPullDownOpenSceneId", "()Ljava/lang/String;", "setPullDownOpenSceneId", "(Ljava/lang/String;)V", "generateSceneId", "report", "", "info", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "eventId", "", "scene", "sceneId", "appId", "appVersion", "appState", "plugin-appbrand-integration_release"})
public final class l {
    private static String nHr;
    public static final l nHs = new l();

    static {
        AppMethodBeat.i(51012);
        AppMethodBeat.o(51012);
    }

    private l() {
    }

    public static final void a(LocalUsageInfo localUsageInfo, int i2, int i3, String str) {
        AppMethodBeat.i(51010);
        if (localUsageInfo != null) {
            String str2 = localUsageInfo.appId;
            int i4 = localUsageInfo.appVersion;
            int i5 = localUsageInfo.iOo + 1;
            if (str2 != null) {
                int aeH = i.aeH(str2);
                Log.d("MicroMsg.AppBrandStarOperationReporter", "report, appId: " + str2 + ", appVersion: " + i4 + ", appState: : " + i5 + ", eventId: " + i2 + ',' + "scene: " + i3 + ", sceneId: " + str + ", serviceType: " + aeH);
                h.INSTANCE.a(13801, str2, Integer.valueOf(i4), Integer.valueOf(i5), Long.valueOf(Util.nowSecond()), Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(aeH));
            }
        }
        AppMethodBeat.o(51010);
    }

    public static final String bUv() {
        AppMethodBeat.i(51011);
        StringBuilder append = new StringBuilder("SceneId@").append(nHs.hashCode()).append('#');
        p.g(g.aAf(), "MMKernel.account()");
        String sb = append.append(com.tencent.mm.b.p.getString(a.getUin())).append('#').append(Util.nowMilliSecond()).toString();
        AppMethodBeat.o(51011);
        return sb;
    }

    public static final String bUw() {
        return nHr;
    }

    public static final void aeK(String str) {
        nHr = str;
    }
}
