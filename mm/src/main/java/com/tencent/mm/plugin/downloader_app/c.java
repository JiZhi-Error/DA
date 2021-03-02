package com.tencent.mm.plugin.downloader_app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader_app.a.e;
import com.tencent.mm.plugin.downloader_app.a.j;
import com.tencent.mm.plugin.downloader_app.api.DownloadWidgetTaskInfo;
import com.tencent.mm.plugin.downloader_app.api.a;
import com.tencent.mm.plugin.downloader_app.ui.DownloadMainUI;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class c implements com.tencent.mm.plugin.downloader_app.api.c {
    @Override // com.tencent.mm.plugin.downloader_app.api.c
    public final boolean cBP() {
        AppMethodBeat.i(8770);
        boolean cBP = j.cBP();
        AppMethodBeat.o(8770);
        return cBP;
    }

    @Override // com.tencent.mm.plugin.downloader_app.api.c
    public final void cBQ() {
        AppMethodBeat.i(8771);
        j.cCf();
        AppMethodBeat.o(8771);
    }

    @Override // com.tencent.mm.plugin.downloader_app.api.c
    public final void a(Context context, Intent intent, a.c cVar) {
        AppMethodBeat.i(8772);
        if (context == null) {
            if (cVar != null) {
                cVar.bEx();
            }
            AppMethodBeat.o(8772);
            return;
        }
        if (intent == null) {
            intent = new Intent();
        }
        intent.getExtras();
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        intent.setClass(context, DownloadMainUI.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/downloader_app/DownloaderAppDelegateImpl", "startDownloadManager", "(Landroid/content/Context;Landroid/content/Intent;Lcom/tencent/mm/plugin/downloader_app/api/DownloadAppCallback$StartDownloadManagerCallBack;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/downloader_app/DownloaderAppDelegateImpl", "startDownloadManager", "(Landroid/content/Context;Landroid/content/Intent;Lcom/tencent/mm/plugin/downloader_app/api/DownloadAppCallback$StartDownloadManagerCallBack;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        if (cVar != null) {
            cVar.bEx();
        }
        AppMethodBeat.o(8772);
    }

    @Override // com.tencent.mm.plugin.downloader_app.api.c
    public final long a(com.tencent.mm.plugin.downloader_app.a.a aVar, a.b bVar) {
        AppMethodBeat.i(8773);
        aVar.extInfo = alq(aVar.extInfo);
        long a2 = com.tencent.mm.plugin.downloader_app.a.c.a(aVar, bVar);
        AppMethodBeat.o(8773);
        return a2;
    }

    @Override // com.tencent.mm.plugin.downloader_app.api.c
    public final void at(final Context context, final String str) {
        AppMethodBeat.i(8774);
        p.postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.downloader_app.c.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(240197);
                com.tencent.mm.plugin.downloader.i.a.as(context, str);
                AppMethodBeat.o(240197);
            }
        }, 200);
        AppMethodBeat.o(8774);
    }

    @Override // com.tencent.mm.plugin.downloader_app.api.c
    public final LinkedList<DownloadWidgetTaskInfo> cBR() {
        AppMethodBeat.i(8775);
        LinkedList<String> cCh = j.cCh();
        if (Util.isNullOrNil(cCh)) {
            AppMethodBeat.o(8775);
            return null;
        }
        LinkedList<DownloadWidgetTaskInfo> linkedList = new LinkedList<>();
        Iterator<String> it = cCh.iterator();
        while (it.hasNext()) {
            String next = it.next();
            DownloadWidgetTaskInfo downloadWidgetTaskInfo = new DownloadWidgetTaskInfo();
            downloadWidgetTaskInfo.appId = next;
            FileDownloadTaskInfo alg = f.cBv().alg(next);
            if (alg != null) {
                downloadWidgetTaskInfo.dCa = alg.id;
                downloadWidgetTaskInfo.state = alg.status;
                switch (alg.status) {
                    case 1:
                        downloadWidgetTaskInfo.pJC = "downloading";
                        break;
                    case 2:
                        downloadWidgetTaskInfo.pJC = "download_pause";
                        break;
                    case 3:
                        downloadWidgetTaskInfo.pJC = "download_succ";
                        break;
                    case 4:
                        downloadWidgetTaskInfo.pJC = "download_fail";
                        break;
                    default:
                        downloadWidgetTaskInfo.pJC = BuildConfig.KINDA_DEFAULT;
                        break;
                }
                if (alg.oJj > 0) {
                    downloadWidgetTaskInfo.progress = (int) ((alg.qJe * 100) / alg.oJj);
                    downloadWidgetTaskInfo.lCT = (((float) alg.qJe) * 100.0f) / ((float) alg.oJj);
                }
                if (alg.qJh) {
                    downloadWidgetTaskInfo.qJh = true;
                }
                linkedList.add(downloadWidgetTaskInfo);
            }
        }
        AppMethodBeat.o(8775);
        return linkedList;
    }

    @Override // com.tencent.mm.plugin.downloader_app.api.c
    public final void e(Context context, Bundle bundle) {
        AppMethodBeat.i(8776);
        if (context == null) {
            AppMethodBeat.o(8776);
            return;
        }
        Intent intent = new Intent();
        intent.putExtras(bundle);
        if (((b) g.af(b.class)).a(b.a.game_luggage, true)) {
            com.tencent.mm.plugin.webview.luggage.p.ar(context, intent);
            AppMethodBeat.o(8776);
            return;
        }
        com.tencent.mm.br.c.b(context, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(8776);
    }

    @Override // com.tencent.mm.plugin.downloader_app.api.c
    public final void EN(String str) {
        AppMethodBeat.i(8777);
        j.EN(str);
        AppMethodBeat.o(8777);
    }

    @Override // com.tencent.mm.plugin.downloader_app.api.c
    public final boolean a(long j2, boolean z, a.b bVar) {
        AppMethodBeat.i(8778);
        com.tencent.mm.plugin.downloader.g.a Cw = d.Cw(j2);
        if (Cw != null) {
            Cw.field_extInfo = alq(Cw.field_extInfo);
            d.e(Cw);
            boolean a2 = com.tencent.mm.plugin.downloader_app.a.c.a(Cw, z, bVar);
            AppMethodBeat.o(8778);
            return a2;
        }
        bVar.a(a.EnumC0947a.FAIL, j2);
        AppMethodBeat.o(8778);
        return false;
    }

    @Override // com.tencent.mm.plugin.downloader_app.api.c
    public final void cBS() {
        AppMethodBeat.i(175256);
        j.cBS();
        AppMethodBeat.o(175256);
    }

    @Override // com.tencent.mm.plugin.downloader_app.api.c
    public final boolean cBT() {
        AppMethodBeat.i(183799);
        e.cBX();
        boolean cCa = e.cCa();
        AppMethodBeat.o(183799);
        return cCa;
    }

    @Override // com.tencent.mm.plugin.downloader_app.api.c
    public final void a(com.tencent.mm.plugin.downloader_app.api.e eVar) {
        AppMethodBeat.i(183800);
        e.cBX();
        e.a(eVar);
        AppMethodBeat.o(183800);
    }

    @Override // com.tencent.mm.plugin.downloader_app.api.c
    public final void b(com.tencent.mm.plugin.downloader_app.api.e eVar) {
        AppMethodBeat.i(183801);
        e.cBX();
        e.b(eVar);
        AppMethodBeat.o(183801);
    }

    private static String alq(String str) {
        JSONObject jSONObject;
        String str2;
        String str3;
        AppMethodBeat.i(8779);
        if (!Util.isNullOrNil(str)) {
            try {
                str2 = URLDecoder.decode(str, ProtocolPackage.ServerEncoding);
            } catch (UnsupportedEncodingException e2) {
                str2 = str;
            }
            try {
                jSONObject = new JSONObject(str2);
            } catch (Exception e3) {
                jSONObject = null;
            }
        } else {
            jSONObject = null;
            str2 = str;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (jSONObject.optInt("OpInWidget") == 1) {
            jSONObject.remove("OpInWidget");
        }
        try {
            jSONObject.put("DownloadInWidget", 1);
        } catch (JSONException e4) {
        }
        try {
            str3 = URLEncoder.encode(jSONObject.toString(), ProtocolPackage.ServerEncoding);
        } catch (UnsupportedEncodingException e5) {
            str3 = str2;
        }
        AppMethodBeat.o(8779);
        return str3;
    }
}
