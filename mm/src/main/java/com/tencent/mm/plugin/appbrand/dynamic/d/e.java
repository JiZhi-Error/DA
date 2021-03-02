package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.c.a;
import com.tencent.mm.model.ad;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.dynamic.d.a.b;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.HashMap;
import org.json.JSONObject;

public final class e extends b {
    public e(int i2) {
        super(com.tencent.mm.ui.l.a.b.b.NAME, i2);
    }

    @Override // com.tencent.mm.plugin.appbrand.dynamic.d.a.b
    public final JSONObject a(a aVar) {
        AppMethodBeat.i(121311);
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
        hashMap.put("version", ChannelUtil.formatVersion(null, d.KyO));
        hashMap.put("system", "Android " + Build.VERSION.RELEASE);
        JSONObject jSONObject = new JSONObject(hashMap);
        AppMethodBeat.o(121311);
        return jSONObject;
    }
}
