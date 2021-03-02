package com.tencent.mm.ui.l.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.z.b;
import com.tencent.mm.plugin.appbrand.jsapi.z.i;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.l.a.g;
import java.util.Map;

public class a extends i<g> {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "getSystemInfo";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.z.i
    public final /* synthetic */ Map a(g gVar) {
        AppMethodBeat.i(234430);
        g gVar2 = gVar;
        Map<String, Object> a2 = super.a(gVar2);
        int[] g2 = com.tencent.mm.ui.l.b.a.g(gVar2);
        int zB = com.tencent.mm.plugin.appbrand.ac.g.zB(g2[0]);
        if (zB <= 0) {
            zB = 1;
        }
        a2.put("windowWidth", Integer.valueOf(zB));
        int zB2 = com.tencent.mm.plugin.appbrand.ac.g.zB(g2[1]);
        if (zB2 <= 0) {
            zB2 = 1;
        }
        a2.put("windowHeight", Integer.valueOf(zB2));
        int[] g3 = com.tencent.mm.ui.l.b.a.g(gVar2);
        int i2 = g3[0];
        int i3 = g3[1];
        int zB3 = com.tencent.mm.plugin.appbrand.ac.g.zB(i2);
        if (zB3 <= 0) {
            zB3 = 1;
        }
        a2.put("screenWidth", Integer.valueOf(zB3));
        int zB4 = com.tencent.mm.plugin.appbrand.ac.g.zB(i3);
        if (zB4 <= 0) {
            zB4 = 1;
        }
        a2.put("screenHeight", Integer.valueOf(zB4));
        a2.put("pixelRatio", Float.valueOf(com.tencent.mm.plugin.appbrand.ac.g.bZk()));
        a2.put(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE, LocaleUtil.getCurrentLanguage(gVar2.getContext()));
        a2.put("version", ChannelUtil.formatVersion(null, BuildInfo.CLIENT_VERSION_INT));
        a2.put("benchmarkLevel", Integer.valueOf(((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getInt("ClientBenchmarkLevel", -1)));
        int i4 = gVar2.getContext().getResources().getConfiguration().orientation;
        if (2 == i4) {
            a2.put("deviceOrientation", "landscape");
        } else if (1 == i4) {
            a2.put("deviceOrientation", "portrait");
        }
        b bVar = (b) gVar2.M(b.class);
        a2.put("fontSizeSetting", Integer.valueOf(Math.round((bVar == null ? 1.0f : bVar.bIO()) * 16.0f)));
        Log.i("Luggage.FULL.JsApiGetSystemInfoLU", "hy: magic emoji get system info %s", a2.toString());
        AppMethodBeat.o(234430);
        return a2;
    }
}
