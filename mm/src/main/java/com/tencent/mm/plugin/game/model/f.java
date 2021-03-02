package com.tencent.mm.plugin.game.model;

import android.content.Context;
import com.tencent.kinda.framework.app.KindaConfigCacheStg;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.c.d;
import com.tencent.mm.g.a.it;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.game.commlib.util.b;
import com.tencent.mm.plugin.game.ui.GameRegionPreference;
import com.tencent.mm.plugin.recordvideo.background.c;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKImageItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.protocal.protobuf.can;
import com.tencent.mm.protocal.protobuf.coq;
import com.tencent.mm.sdk.platformtools.ErrorCode;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class f {
    private static final String xEu = (b.c(b.a.PERMANENT) + "hvmenu/");

    /* access modifiers changed from: package-private */
    public interface a {
        void onComplete();
    }

    static /* synthetic */ void b(List list, a aVar) {
        AppMethodBeat.i(41405);
        a(list, aVar);
        AppMethodBeat.o(41405);
    }

    static {
        AppMethodBeat.i(41406);
        AppMethodBeat.o(41406);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void a(it itVar) {
        AppMethodBeat.i(41401);
        int i2 = itVar.dNs.EX;
        Log.i("MicroMsg.GameCommOpertionProcessor", "cmd:%d", Integer.valueOf(i2));
        switch (i2) {
            case 1:
                Context context = itVar.dNs.context;
                if (context != null) {
                    JSONObject jSONObject = new JSONObject();
                    GameRegionPreference.a fX = e.fX(context);
                    if (fX != null) {
                        try {
                            jSONObject.put("gameRegionName", e.a(fX));
                        } catch (JSONException e2) {
                        }
                    }
                    itVar.dNt.result = jSONObject.toString();
                }
                AppMethodBeat.o(41401);
                return;
            case 2:
                final String str = itVar.dNs.param;
                Log.i("MicroMsg.GameCommOpertionProcessor", "update hv menu! appid:%s", str);
                if (!Util.isNullOrNil(str)) {
                    g.azz().a(1369, new i() {
                        /* class com.tencent.mm.plugin.game.model.f.AnonymousClass1 */

                        @Override // com.tencent.mm.ak.i
                        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                            AppMethodBeat.i(41398);
                            if (i2 == 0 && i3 == 0) {
                                Log.i("MicroMsg.GameCommOpertionProcessor", "pull menu data success. appid:%s", str);
                                g.azz().b(1369, this);
                                final can can = (can) ((as) qVar).hhm.iLL.iLR;
                                MMHandlerThread.postToMainThread(new Runnable() {
                                    /* class com.tencent.mm.plugin.game.model.f.AnonymousClass1.AnonymousClass1 */

                                    public final void run() {
                                        AppMethodBeat.i(41397);
                                        f.a(can, str);
                                        AppMethodBeat.o(41397);
                                    }
                                });
                                AppMethodBeat.o(41398);
                                return;
                            }
                            Log.i("MicroMsg.GameCommOpertionProcessor", "pull menu data fail. appid:%s", str);
                            AppMethodBeat.o(41398);
                        }
                    });
                    g.azz().a(new as(str), 0);
                }
                AppMethodBeat.o(41401);
                return;
            case 3:
                String str2 = itVar.dNs.param;
                Log.i("MicroMsg.GameCommOpertionProcessor", "get hv menu! appid:%s", str2);
                if (!Util.isNullOrNil(str2)) {
                    byte[] azn = ((com.tencent.mm.plugin.game.api.f) g.af(com.tencent.mm.plugin.game.api.f.class)).dSL().azn("pb_game_hv_menu_".concat(String.valueOf(str2)));
                    if (!Util.isNullOrNil(azn)) {
                        try {
                            itVar.dNt.result = new String(azn, KindaConfigCacheStg.SAVE_CHARSET);
                            Log.i("MicroMsg.GameCommOpertionProcessor", "get hv menu success! appid:%s", str2);
                            AppMethodBeat.o(41401);
                            return;
                        } catch (UnsupportedEncodingException e3) {
                        }
                    }
                }
                AppMethodBeat.o(41401);
                return;
            case 4:
                b(itVar);
                AppMethodBeat.o(41401);
                return;
            case 5:
                com.tencent.mm.plugin.game.commlib.b.dTd().I(true, Util.getInt(itVar.dNs.param, 0));
                AppMethodBeat.o(41401);
                return;
            case 10001:
                Context context2 = itVar.dNs.context;
                if (context2 != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    String gf = e.gf(context2);
                    if (Util.isNullOrNil(gf)) {
                        gf = e.dUS();
                    }
                    try {
                        jSONObject2.put("regionCode", gf);
                    } catch (JSONException e4) {
                    }
                    itVar.dNt.result = jSONObject2.toString();
                }
                AppMethodBeat.o(41401);
                return;
            case ErrorCode.ERROR_SYSLIB_OPEN_JPEG_FAIL /*{ENCODED_INT: 10003}*/:
                com.tencent.mm.plugin.game.media.a aVar = new com.tencent.mm.plugin.game.media.a();
                if (!Util.isNullOrNil(itVar.dNs.param)) {
                    JSONArray jSONArray = null;
                    try {
                        jSONArray = new JSONObject(itVar.dNs.param).optJSONArray("albumInfos");
                    } catch (JSONException e5) {
                    }
                    aVar.y(jSONArray);
                }
                String dUc = aVar.dUc();
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("newVideoDesc", dUc);
                } catch (JSONException e6) {
                }
                itVar.dNt.result = jSONObject3.toString();
                AppMethodBeat.o(41401);
                return;
            case ErrorCode.ERROR_SYSLIB_READHEAD_JPEG_FAIL /*{ENCODED_INT: 10004}*/:
                if (!Util.isNullOrNil(itVar.dNs.param)) {
                    try {
                        JSONObject jSONObject4 = new JSONObject(itVar.dNs.param);
                        int optInt = jSONObject4.optInt("basic_type");
                        if (jSONObject4.optBoolean("ban")) {
                            e.Ok(optInt);
                            AppMethodBeat.o(41401);
                            return;
                        }
                        e.Ol(optInt);
                        AppMethodBeat.o(41401);
                        return;
                    } catch (JSONException e7) {
                    }
                }
                AppMethodBeat.o(41401);
                return;
            case 10005:
                c(itVar);
                AppMethodBeat.o(41401);
                return;
            case 10006:
                d(itVar);
                AppMethodBeat.o(41401);
                return;
            case CdnLogic.kMediaTypeFavoriteBigFile:
                e(itVar);
                AppMethodBeat.o(41401);
                return;
            case 10010:
                JSONObject jSONObject5 = new JSONObject();
                try {
                    jSONObject5.put("disable_gamelife_api", false);
                    if (com.tencent.mm.plugin.game.commlib.a.dSY() != null && com.tencent.mm.plugin.game.commlib.a.dSY().xLa) {
                        jSONObject5.put("disable_gamelife_api", true);
                    }
                } catch (JSONException e8) {
                }
                itVar.dNt.result = jSONObject5.toString();
                AppMethodBeat.o(41401);
                return;
            case CdnLogic.kMediaTypeBeatificFile:
                if (!Util.isNullOrNil(itVar.dNs.param)) {
                    try {
                        JSONObject jSONObject6 = new JSONObject(itVar.dNs.param);
                        String optString = jSONObject6.optString("appid");
                        int optInt2 = jSONObject6.optInt("version");
                        Log.i("MicroMsg.GameCommOpertionProcessor", "updateAppInfo, appid:%s, version:%d", optString, Integer.valueOf(optInt2));
                        if (Util.isNullOrNil(optString)) {
                            AppMethodBeat.o(41401);
                            return;
                        }
                        if (optInt2 == 0) {
                            optInt2 = Integer.MAX_VALUE;
                        }
                        h.gE(optString, optInt2);
                        AppMethodBeat.o(41401);
                        return;
                    } catch (JSONException e9) {
                    }
                }
                AppMethodBeat.o(41401);
                return;
            case 10012:
                JSONObject jSONObject7 = new JSONObject();
                try {
                    jSONObject7.put("isExDevice", z.aUh());
                } catch (JSONException e10) {
                }
                itVar.dNt.result = jSONObject7.toString();
                break;
        }
        AppMethodBeat.o(41401);
    }

    private static void a(final List<coq> list, final a aVar) {
        AppMethodBeat.i(41402);
        if (Util.isNullOrNil(list)) {
            if (aVar != null) {
                aVar.onComplete();
            }
            AppMethodBeat.o(41402);
            return;
        }
        final coq remove = list.remove(0);
        if (remove == null || Util.isNullOrNil(remove.ThumbUrl)) {
            Log.e("MicroMsg.GameCommOpertionProcessor", "menu is null or thumburl is null");
            AppMethodBeat.o(41402);
            return;
        }
        c.a aVar2 = new c.a();
        aVar2.jbf = true;
        aVar2.fullPath = xEu + com.tencent.mm.b.g.getMessageDigest(remove.ThumbUrl.getBytes());
        com.tencent.mm.av.q.bcV().a(remove.ThumbUrl, aVar2.bdv(), new d() {
            /* class com.tencent.mm.plugin.game.model.f.AnonymousClass3 */

            @Override // com.tencent.mm.av.a.c.d
            public final void a(boolean z, Object... objArr) {
                AppMethodBeat.i(204148);
                if (z) {
                    Log.i("MicroMsg.GameCommOpertionProcessor", "menu icon download success! thumburl:%s", remove.ThumbUrl);
                    f.b(list, aVar);
                }
                AppMethodBeat.o(204148);
            }
        });
        AppMethodBeat.o(41402);
    }

    private static void b(it itVar) {
        AppMethodBeat.i(41403);
        String str = itVar.dNs.param;
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(41403);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i2 = Util.getInt(jSONObject.getString("game_page_report_id"), 0);
            boolean z = jSONObject.getBoolean("game_page_report_instantly");
            String optString = jSONObject.optString("game_page_report_format_data");
            String optString2 = jSONObject.optString("game_page_report_tabs_format_data");
            Log.i("MicroMsg.GameCommOpertionProcessor", "reportGamePageTime, reportId:%d, reportInstantly:%b, reportFormatData:(%s), reportTabsFormatData(%s)", Integer.valueOf(i2), Boolean.valueOf(z), optString, optString2);
            if (i2 == 0) {
                Log.i("MicroMsg.GameCommOpertionProcessor", "reportId format exception");
                AppMethodBeat.o(41403);
            } else if (Util.isNullOrNil(optString)) {
                if (!Util.isNullOrNil(optString2)) {
                    try {
                        JSONArray jSONArray = new JSONArray(optString2);
                        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                            String string = jSONArray.getString(i3);
                            if (!Util.isNullOrNil(string)) {
                                if (z) {
                                    com.tencent.mm.plugin.game.d.a.bz(i2, string);
                                } else {
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(i2, string);
                                }
                            }
                        }
                        AppMethodBeat.o(41403);
                        return;
                    } catch (JSONException e2) {
                        Log.i("MicroMsg.GameCommOpertionProcessor", "reportGamePageTime, err2:%s", e2.getMessage());
                    }
                }
                AppMethodBeat.o(41403);
            } else if (z) {
                com.tencent.mm.plugin.game.d.a.bz(i2, optString);
                AppMethodBeat.o(41403);
            } else {
                com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(i2, optString);
                AppMethodBeat.o(41403);
            }
        } catch (JSONException e3) {
            Log.i("MicroMsg.GameCommOpertionProcessor", "reportGamePageTime, err1:%s", e3.getMessage());
            AppMethodBeat.o(41403);
        }
    }

    private static void c(it itVar) {
        AppMethodBeat.i(183854);
        String dVe = e.dVe();
        if (!Util.isNullOrNil(dVe)) {
            String[] split = dVe.split(",");
            JSONArray jSONArray = new JSONArray();
            for (String str : split) {
                if (!Util.isNullOrNil(str)) {
                    jSONArray.put(Integer.valueOf(str));
                }
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("basic_type", jSONArray);
            } catch (JSONException e2) {
            }
            itVar.dNt.result = jSONObject.toString();
        }
        AppMethodBeat.o(183854);
    }

    private static void d(it itVar) {
        AppMethodBeat.i(183855);
        JSONArray jSONArray = new JSONArray();
        if (!Util.isNullOrNil(itVar.dNs.param)) {
            Log.i("MicroMsg.GameCommOpertionProcessor", "saveMediaLocalIds params:%s", itVar.dNs.param);
            try {
                JSONArray jSONArray2 = new JSONArray(itVar.dNs.param);
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    String string = jSONArray2.getString(i2);
                    WebViewJSSDKFileItem aYO = com.tencent.mm.plugin.webview.modeltools.g.gdv().aYO(string);
                    if (aYO == null) {
                        jSONArray.put(false);
                    } else {
                        String str = null;
                        if (aYO.mediaType == 1) {
                            str = ((WebViewJSSDKImageItem) aYO).hXJ().toString();
                        } else if (aYO.mediaType == 4) {
                            str = ((WebViewJSSDKVideoItem) aYO).hXJ().toString();
                        }
                        if (!Util.isNullOrNil(str)) {
                            ((com.tencent.mm.plugin.game.commlib.a.a) g.af(com.tencent.mm.plugin.game.commlib.a.a.class)).azo(string);
                            ((com.tencent.mm.plugin.game.commlib.a.a) g.af(com.tencent.mm.plugin.game.commlib.a.a.class)).q(string, str.getBytes());
                            jSONArray.put(true);
                        } else {
                            jSONArray.put(false);
                        }
                    }
                }
            } catch (JSONException e2) {
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", jSONArray);
        } catch (JSONException e3) {
        }
        String jSONObject2 = jSONObject.toString();
        Log.i("MicroMsg.GameCommOpertionProcessor", "saveMediaLocalIds result:%s", jSONObject2);
        itVar.dNt.result = jSONObject2;
        AppMethodBeat.o(183855);
    }

    private static void e(it itVar) {
        boolean z;
        byte[] azn;
        WebViewJSSDKFileItem aAi;
        AppMethodBeat.i(183856);
        JSONArray jSONArray = new JSONArray();
        if (!Util.isNullOrNil(itVar.dNs.param)) {
            Log.i("MicroMsg.GameCommOpertionProcessor", "checkMediaLocalIds params:%s", itVar.dNs.param);
            try {
                JSONArray jSONArray2 = new JSONArray(itVar.dNs.param);
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    String string = jSONArray2.getString(i2);
                    WebViewJSSDKFileItem aYO = com.tencent.mm.plugin.webview.modeltools.g.gdv().aYO(string);
                    if (aYO != null && s.YS(aYO.laR) && (Util.isNullOrNil(aYO.lPx) || s.YS(aYO.lPx))) {
                        jSONArray.put(true);
                    } else if (string.startsWith("weixin://bgmixid/")) {
                        String replace = string.replace("weixin://bgmixid/", "");
                        e eVar = e.BKp;
                        com.tencent.mm.plugin.recordvideo.background.c aLf = e.aLf(replace);
                        if (aLf != null) {
                            int i3 = aLf.field_status;
                            c.b bVar = c.b.BKk;
                            if (i3 == c.b.bTk()) {
                                ald eIK = aLf.eIK();
                                if (eIK != null && s.YS(eIK.BOA) && s.YS(eIK.Lue)) {
                                    jSONArray.put(true);
                                }
                            } else {
                                ald eIK2 = aLf.eIK();
                                if (eIK2 != null && s.YS(eIK2.BOz)) {
                                    jSONArray.put(true);
                                }
                            }
                        }
                        jSONArray.put(false);
                    } else {
                        if (Util.isNullOrNil(string) || (azn = ((com.tencent.mm.plugin.game.commlib.a.a) g.af(com.tencent.mm.plugin.game.commlib.a.a.class)).azn(string)) == null || azn.length == 0 || (aAi = aAi(new String(azn))) == null || !s.YS(aAi.laR) || (!Util.isNullOrNil(aAi.lPx) && !s.YS(aAi.lPx))) {
                            z = false;
                        } else {
                            com.tencent.mm.plugin.webview.modeltools.g.gdv().a(aAi);
                            z = true;
                        }
                        if (z) {
                            jSONArray.put(true);
                        } else {
                            jSONArray.put(false);
                        }
                    }
                }
            } catch (JSONException e2) {
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", jSONArray);
        } catch (JSONException e3) {
        }
        String jSONObject2 = jSONObject.toString();
        Log.i("MicroMsg.GameCommOpertionProcessor", "checkMediaLocalIds result:%s", jSONObject2);
        itVar.dNt.result = jSONObject2;
        AppMethodBeat.o(183856);
    }

    private static WebViewJSSDKFileItem aAi(String str) {
        WebViewJSSDKFileItem webViewJSSDKFileItem = null;
        AppMethodBeat.i(183857);
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("mediaType", 0);
            if (optInt == 1) {
                webViewJSSDKFileItem = new WebViewJSSDKImageItem();
                ((WebViewJSSDKImageItem) webViewJSSDKFileItem).cb(jSONObject);
            } else if (optInt == 4) {
                webViewJSSDKFileItem = new WebViewJSSDKVideoItem();
                ((WebViewJSSDKVideoItem) webViewJSSDKFileItem).cb(jSONObject);
            } else {
                AppMethodBeat.o(183857);
                return webViewJSSDKFileItem;
            }
            AppMethodBeat.o(183857);
        } catch (JSONException e2) {
            AppMethodBeat.o(183857);
        }
        return webViewJSSDKFileItem;
    }

    static /* synthetic */ void a(final can can, final String str) {
        AppMethodBeat.i(41404);
        if (can != null) {
            if (Util.isNullOrNil(can.MfF)) {
                Log.i("MicroMsg.GameCommOpertionProcessor", "menu list is null. appid:%s", str);
                AppMethodBeat.o(41404);
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(can.MfF);
            a(arrayList, new a() {
                /* class com.tencent.mm.plugin.game.model.f.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.game.model.f.a
                public final void onComplete() {
                    AppMethodBeat.i(41399);
                    Log.i("MicroMsg.GameCommOpertionProcessor", "menu icon download complete! save menu data. appid:%s", str);
                    ((com.tencent.mm.plugin.game.api.f) g.af(com.tencent.mm.plugin.game.api.f.class)).dSL().b("pb_game_hv_menu_" + str, can);
                    AppMethodBeat.o(41399);
                }
            });
        }
        AppMethodBeat.o(41404);
    }
}
