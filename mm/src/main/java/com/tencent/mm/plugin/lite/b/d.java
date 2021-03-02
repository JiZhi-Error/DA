package com.tencent.mm.plugin.lite.b;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.je;
import com.tencent.mm.plugin.boots.a.g;
import com.tencent.mm.plugin.lite.LiteAppCenter;
import com.tencent.mm.plugin.lite.LiteAppTaskPreloadReceiver;
import com.tencent.mm.plugin.lite.c.b;
import com.tencent.mm.plugin.lite.launch.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.u;

public final class d extends IListener<je> {
    public d() {
        AppMethodBeat.i(198858);
        this.__eventId = je.class.getName().hashCode();
        AppMethodBeat.o(198858);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(je jeVar) {
        final String str;
        AppMethodBeat.i(198859);
        je jeVar2 = jeVar;
        if (jeVar2.dNT.actionCode != 42) {
            AppMethodBeat.o(198859);
            return false;
        }
        String str2 = jeVar2.dNT.result;
        if (str2 == null || str2.isEmpty()) {
            AppMethodBeat.o(198859);
            return true;
        }
        Log.i("LiteAppDevQrCodeListener", "liteapp qrcode url:".concat(String.valueOf(str2)));
        String[] split = str2.split("\\?");
        if (split == null || split.length <= 0) {
            AppMethodBeat.o(198859);
            return true;
        }
        String str3 = split[0];
        final String[] strArr = new String[2];
        if (split.length != 1) {
            str = split[1];
            String[] split2 = split[1].split("&");
            String[] strArr2 = strArr;
            for (String str4 : split2) {
                String[] split3 = str4.split("=");
                if ("entry".equals(split3[0].trim())) {
                    strArr2 = b.bM(split3[1], true);
                }
            }
            strArr = strArr2;
        } else {
            str = "";
        }
        int lastIndexOf = str3.lastIndexOf(FilePathGenerator.ANDROID_DIR_SEP);
        if (lastIndexOf < 0 || lastIndexOf + 1 > str3.length()) {
            AppMethodBeat.o(198859);
            return true;
        }
        String substring = str3.substring(lastIndexOf + 1);
        int indexOf = substring.indexOf("_");
        if (indexOf < 0) {
            AppMethodBeat.o(198859);
            return true;
        }
        String substring2 = substring.substring(0, indexOf);
        g gVar = new g();
        gVar.appId = substring2;
        gVar.pkK = str3;
        gVar.pkL = "";
        gVar.crh = "3056301006072a8648ce3d020106052b8104000a03420004d60415d0874b4e66bbbbdb598a2c5269caf1af51b2b23ef23a82f48c74d8bc268ae89b34912dbb5b494b3d44d3bc2f0bfc6619357a6679edb531679544de9987";
        e.INSTANCE.a(gVar, "debug", new a() {
            /* class com.tencent.mm.plugin.lite.b.d.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.lite.launch.a
            public final void a(WxaLiteAppInfo wxaLiteAppInfo) {
                AppMethodBeat.i(198856);
                Bundle bundle = new Bundle();
                bundle.putString("appId", wxaLiteAppInfo.appId);
                if (strArr[0] != null) {
                    bundle.putString("path", strArr[0]);
                }
                if (strArr[1] != null) {
                    bundle.putString(SearchIntents.EXTRA_QUERY, strArr[1]);
                }
                if (!"".equals(str) && str != null) {
                    bundle.putString("qr_url_query_string", str);
                }
                if (!LiteAppCenter.LITE_APP_BASE_LIB.equals(wxaLiteAppInfo.appId)) {
                    ((com.tencent.mm.plugin.lite.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.lite.a.a.class)).a(MMApplicationContext.getContext(), bundle, false, null);
                    AppMethodBeat.o(198856);
                    return;
                }
                Intent intent = new Intent();
                intent.setClass(MMApplicationContext.getContext(), LiteAppTaskPreloadReceiver.class);
                intent.addFlags(268435456);
                intent.putExtra("task", "updateBaseLibPath");
                intent.putExtra("path", wxaLiteAppInfo.path);
                MMApplicationContext.getContext().sendBroadcast(intent);
                u.makeText(MMApplicationContext.getContext(), "更新基础库成功，装了 coolassist 并把日志级别设成 debug 才会生效", 1).show();
                AppMethodBeat.o(198856);
            }

            @Override // com.tencent.mm.plugin.lite.launch.a
            public final void dTu() {
                AppMethodBeat.i(198857);
                u.makeText(MMApplicationContext.getContext(), "下载失败", 0).show();
                AppMethodBeat.o(198857);
            }
        });
        AppMethodBeat.o(198859);
        return true;
    }
}
