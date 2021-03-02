package com.tencent.mm.plugin.flutter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.flutter.a.a;
import com.tencent.mm.plugin.flutter.a.c;
import com.tencent.mm.plugin.flutter.ui.MMFlutterActivity;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.UUID;

public final class b implements a {
    @Override // com.tencent.mm.plugin.flutter.a.a
    public final void dLp() {
        AppMethodBeat.i(240925);
        ((PluginFlutter) g.ah(PluginFlutter.class)).getFlutterEngineMgr().dLq();
        AppMethodBeat.o(240925);
    }

    @Override // com.tencent.mm.plugin.flutter.a.a
    public final void a(Context context, c cVar) {
        AppMethodBeat.i(148837);
        if (!((com.tencent.mm.plugin.flutter.a.b) g.ah(com.tencent.mm.plugin.flutter.a.b.class)).isInitFlutter()) {
            AppMethodBeat.o(148837);
            return;
        }
        String uuid = UUID.randomUUID().toString();
        cVar.wJg = 2;
        cVar.wJf = new HashMap<>();
        cVar.wJf.put("fontScale", Float.valueOf(com.tencent.mm.cb.a.ez(MMApplicationContext.getContext())));
        cVar.wJf.put("layoutScale", Float.valueOf(com.tencent.mm.cb.a.jj(MMApplicationContext.getContext())));
        cVar.wJf.put(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE, LocaleUtil.getApplicationLanguage());
        cVar.wJf.put("sessionId", uuid);
        boolean a2 = ((PluginFlutter) g.ah(PluginFlutter.class)).getFlutterEngineMgr().a(cVar, "mmNative", (Activity) context);
        Log.i("MicroMsg.Flutter.FlutterService", "startEmbeddingFlutterView firstCreate %b", Boolean.valueOf(a2));
        Intent intent = new Intent(context, MMFlutterActivity.class);
        intent.putExtra("first_create", a2);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/flutter/FlutterService", "startFlutterPage", "(Landroid/content/Context;Lcom/tencent/mm/plugin/flutter/api/MMFlutterRoute;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/flutter/FlutterService", "startFlutterPage", "(Landroid/content/Context;Lcom/tencent/mm/plugin/flutter/api/MMFlutterRoute;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((Activity) context).overridePendingTransition(R.anim.br, R.anim.bs);
        AppMethodBeat.o(148837);
    }

    @Override // com.tencent.mm.plugin.flutter.a.a
    public final boolean a(Context context, int i2, Bundle bundle) {
        AppMethodBeat.i(240926);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ArrayList<String> stringArrayList = bundle.getStringArrayList("pathList");
        ArrayList<String> stringArrayList2 = bundle.getStringArrayList("typeList");
        for (int i3 = 0; i3 < stringArrayList.size(); i3++) {
            if (stringArrayList2.get(i3) == "image") {
                linkedHashMap.put(stringArrayList.get(i3), "image");
            } else if (stringArrayList2.get(i3) == "video") {
                linkedHashMap.put(stringArrayList.get(i3), "video");
            }
        }
        linkedHashMap.put("startTime", Long.valueOf(System.currentTimeMillis()));
        StringBuilder sb = new StringBuilder();
        g.aAf();
        linkedHashMap.put("editId", sb.append(com.tencent.mm.kernel.a.ayV()).append("_").append(System.currentTimeMillis()).toString());
        linkedHashMap.put(ShareConstants.RESULT_POST_ID, bundle.getString(ShareConstants.RESULT_POST_ID));
        String uuid = UUID.randomUUID().toString();
        c cVar = new c("emoticon", "store", linkedHashMap);
        cVar.wJg = 2;
        cVar.wJf = new HashMap<>();
        cVar.wJf.put("fontScale", Float.valueOf(com.tencent.mm.cb.a.ez(MMApplicationContext.getContext())));
        cVar.wJf.put("layoutScale", Float.valueOf(com.tencent.mm.cb.a.jj(MMApplicationContext.getContext())));
        cVar.wJf.put(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE, LocaleUtil.getApplicationLanguage());
        cVar.wJf.put("sessionId", uuid);
        boolean a2 = ((PluginFlutter) g.ah(PluginFlutter.class)).getFlutterEngineMgr().a(cVar, "mmNative", (Activity) context);
        Log.i("MicroMsg.Flutter.FlutterService", "startEmbeddingFlutterView firstCreate %b", Boolean.valueOf(a2));
        Intent intent = new Intent(context, MMFlutterActivity.class);
        intent.putExtra("videoEditor", true);
        intent.putExtra("first_create", a2);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        ((Activity) context).startActivityForResult(intent, i2);
        ((Activity) context).overridePendingTransition(R.anim.n, R.anim.o);
        AppMethodBeat.o(240926);
        return false;
    }
}
