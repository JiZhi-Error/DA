package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.b.b;
import com.tencent.mm.model.ad;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.dynamic.d.a.a;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d extends a {
    public d(int i2) {
        super("getSystemInfo", i2);
    }

    @Override // com.tencent.mm.plugin.appbrand.dynamic.d.a.a
    public final void a(com.tencent.mm.aa.c.a aVar, JSONObject jSONObject, b.a<JSONObject> aVar2) {
        AppMethodBeat.i(121310);
        Context context = aVar.getContext();
        ad.b ayQ = aVar.ayQ();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float f2 = displayMetrics.density;
        HashMap hashMap = new HashMap();
        hashMap.put("model", Build.MODEL);
        hashMap.put("pixelRatio", Float.valueOf(f2));
        hashMap.put("windowWidth", Integer.valueOf(g.zC(ayQ.getInt("__page_view_width", 0))));
        hashMap.put("windowHeight", Integer.valueOf(g.zC(ayQ.getInt("__page_view_height", 0))));
        hashMap.put("screenWidth", Integer.valueOf(g.zC(displayMetrics.widthPixels)));
        hashMap.put("screenHeight", Integer.valueOf(g.zC(displayMetrics.heightPixels)));
        hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE, LocaleUtil.getCurrentLanguage(context));
        hashMap.put("version", ChannelUtil.formatVersion(null, com.tencent.mm.protocal.d.KyO));
        hashMap.put("system", "Android " + Build.VERSION.RELEASE);
        aVar2.bt(a(true, "", (Map<String, ? extends Object>) hashMap));
        AppMethodBeat.o(121310);
    }
}
