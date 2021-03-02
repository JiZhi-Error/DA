package com.tencent.mm.plugin.appbrand.app;

import android.content.Context;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.q;
import com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.ipc.e;
import com.tencent.mm.plugin.appbrand.jsapi.file.OpenFileRequest;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.WechatNativeExtraDataInvokeFunctionalPage;
import com.tencent.mm.plugin.appbrand.service.f;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.plugin.appbrand.task.g;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.plugin.appbrand.ui.recommend.c;
import com.tencent.mm.plugin.appbrand.ui.recommend.d;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

public final class AppBrandMixExportLogicService implements f {
    @Override // com.tencent.mm.plugin.appbrand.service.f
    public final void a(z zVar) {
        AppMethodBeat.i(226284);
        h.bWb().e(zVar);
        AppMethodBeat.o(226284);
    }

    @Override // com.tencent.mm.plugin.appbrand.service.f
    public final void b(z zVar) {
        AppMethodBeat.i(226285);
        h.bWb().a(g.WASERVICE, zVar);
        AppMethodBeat.o(226285);
    }

    @Override // com.tencent.mm.plugin.appbrand.service.f
    public final void c(z zVar) {
        AppMethodBeat.i(226286);
        h.bWb().a(g.WAGAME, zVar);
        AppMethodBeat.o(226286);
    }

    @Override // com.tencent.mm.plugin.appbrand.service.f
    public final void bui() {
        AppMethodBeat.i(44097);
        if (c.bYQ() && c.bYS()) {
            a(z.FIND_MORE_ENTRANCE_EXPOSED);
        }
        com.tencent.f.h.RTc.aX(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.app.AppBrandMixExportLogicService.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(44089);
                d.ofe.bYV();
                AppMethodBeat.o(44089);
            }
        });
        AppMethodBeat.o(44097);
    }

    @Override // com.tencent.mm.plugin.appbrand.service.f
    public final <T extends Parcelable> void a(String str, T t) {
        AppMethodBeat.i(174695);
        e.b(str, t);
        AppMethodBeat.o(174695);
    }

    @Override // com.tencent.mm.plugin.appbrand.service.f
    public final void buj() {
        AppMethodBeat.i(226287);
        l.brc();
        AppMethodBeat.o(226287);
    }

    @Override // com.tencent.mm.plugin.appbrand.service.f
    public final void buk() {
        AppMethodBeat.i(226288);
        com.tencent.mm.plugin.appbrand.g.clean();
        AppMethodBeat.o(226288);
    }

    public static com.tencent.mm.vending.g.e<Pair<String, String>> y(String str, int i2, int i3) {
        AppMethodBeat.i(44098);
        com.tencent.mm.co.f b2 = com.tencent.mm.co.g.j(str, Integer.valueOf(i2), Integer.valueOf(i3)).b(new a<Pair<String, String>, com.tencent.mm.vending.j.d<String, Integer, Integer>>() {
            /* class com.tencent.mm.plugin.appbrand.app.AppBrandMixExportLogicService.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Pair<String, String> call(com.tencent.mm.vending.j.d<String, Integer, Integer> dVar) {
                AppMethodBeat.i(44091);
                com.tencent.mm.vending.j.d<String, Integer, Integer> dVar2 = dVar;
                final b hdH = com.tencent.mm.vending.g.g.hdH();
                final com.tencent.mm.modelsimple.l lVar = new com.tencent.mm.modelsimple.l((String) dVar2.get(0), 61, ((Integer) dVar2.get(1)).intValue(), ((Integer) dVar2.get(2)).intValue(), (int) System.currentTimeMillis(), new byte[0]);
                aa.a(lVar.rr, new aa.a() {
                    /* class com.tencent.mm.plugin.appbrand.app.AppBrandMixExportLogicService.AnonymousClass2.AnonymousClass1 */

                    @Override // com.tencent.mm.ak.aa.a
                    public final int a(int i2, int i3, String str, com.tencent.mm.ak.d dVar, q qVar) {
                        String queryParameter;
                        String str2;
                        AppMethodBeat.i(44090);
                        if (i2 == 0 && i3 == 0) {
                            int beS = lVar.beS();
                            String beQ = lVar.beQ();
                            Log.i("MicroMsg.AppBrandMixExportLogicService", "processGetNickName actionCode:%d", Integer.valueOf(beS));
                            switch (beS) {
                                case 26:
                                    if (!Util.isNullOrNil(beQ)) {
                                        Uri parse = Uri.parse(beQ);
                                        String queryParameter2 = parse.getQueryParameter("nickname");
                                        queryParameter = parse.getQueryParameter("headimgurl");
                                        str2 = queryParameter2;
                                        break;
                                    }
                                default:
                                    queryParameter = null;
                                    str2 = null;
                                    break;
                            }
                            hdH.G(new Pair(str2, queryParameter));
                            AppMethodBeat.o(44090);
                        } else {
                            Log.w("MicroMsg.AppBrandMixExportLogicService", "processGetNickName errType:%d errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
                            AppMethodBeat.o(44090);
                        }
                        return 0;
                    }
                }, true);
                AppMethodBeat.o(44091);
                return null;
            }
        });
        AppMethodBeat.o(44098);
        return b2;
    }

    public static final class AppBrandOnStartReportCanvasDataEvent implements Parcelable {
        public static final Parcelable.Creator<AppBrandOnStartReportCanvasDataEvent> CREATOR = new Parcelable.Creator<AppBrandOnStartReportCanvasDataEvent>() {
            /* class com.tencent.mm.plugin.appbrand.app.AppBrandMixExportLogicService.AppBrandOnStartReportCanvasDataEvent.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ AppBrandOnStartReportCanvasDataEvent[] newArray(int i2) {
                return new AppBrandOnStartReportCanvasDataEvent[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ AppBrandOnStartReportCanvasDataEvent createFromParcel(Parcel parcel) {
                AppMethodBeat.i(44092);
                AppBrandOnStartReportCanvasDataEvent appBrandOnStartReportCanvasDataEvent = new AppBrandOnStartReportCanvasDataEvent(parcel);
                AppMethodBeat.o(44092);
                return appBrandOnStartReportCanvasDataEvent;
            }
        };
        public String appId;

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(44093);
            parcel.writeString(this.appId);
            AppMethodBeat.o(44093);
        }

        AppBrandOnStartReportCanvasDataEvent() {
        }

        AppBrandOnStartReportCanvasDataEvent(Parcel parcel) {
            AppMethodBeat.i(44094);
            this.appId = parcel.readString();
            AppMethodBeat.o(44094);
        }

        static {
            AppMethodBeat.i(44095);
            AppMethodBeat.o(44095);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.service.f
    public final void a(Context context, String str, String str2, String str3, boolean z, String str4) {
        AppMethodBeat.i(174698);
        OpenFileRequest openFileRequest = new OpenFileRequest();
        openFileRequest.filePath = str;
        openFileRequest.gCr = str2;
        openFileRequest.appId = str3;
        openFileRequest.lwF = z;
        com.tencent.mm.plugin.appbrand.ipc.a.a(context, openFileRequest, str4);
        AppMethodBeat.o(174698);
    }

    @Override // com.tencent.mm.plugin.appbrand.service.f
    public final String Ur(String str) {
        AppMethodBeat.i(226289);
        String Ur = w.Ur(str);
        AppMethodBeat.o(226289);
        return Ur;
    }

    @Override // com.tencent.mm.plugin.appbrand.service.f
    public final Pair<String, Integer> vN(int i2) {
        AppMethodBeat.i(226290);
        Pair<String, Integer> pair = new Pair<>(com.tencent.mm.plugin.appbrand.appcache.e.vO(i2), Integer.valueOf((int) R.drawable.dg));
        AppMethodBeat.o(226290);
        return pair;
    }

    @Override // com.tencent.mm.plugin.appbrand.service.f
    public final Pair<Integer, String> a(Context context, WXLaunchWxaRedirectingPage.Req req, String str, String str2, String str3) {
        String str4;
        String str5;
        WechatNativeExtraDataInvokeFunctionalPage wechatNativeExtraDataInvokeFunctionalPage;
        String str6;
        AppMethodBeat.i(226291);
        Uri parse = Uri.parse(str2);
        String queryParameter = parse.getQueryParameter("host_appid");
        int i2 = Util.getInt(parse.getQueryParameter("wxa_scene"), 1);
        AppBrandLaunchReferrer appBrandLaunchReferrer = new AppBrandLaunchReferrer();
        appBrandLaunchReferrer.leo = 7;
        appBrandLaunchReferrer.appId = queryParameter;
        try {
            JSONObject jSONObject = new JSONObject(new JSONObject(str3).optString("invokeData"));
            str5 = jSONObject.getString("miniprogramAppID");
            str6 = jSONObject.optString("path", "__wx__/open-api-redirecting-page");
            jSONObject.put("invokeTicket", req.invokeTicket);
            jSONObject.put("wxa_scene", i2);
            jSONObject.put(AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME, str);
            jSONObject.put("callbackActivity", req.callbackActivity);
            wechatNativeExtraDataInvokeFunctionalPage = new WechatNativeExtraDataInvokeFunctionalPage(jSONObject);
            str4 = wechatNativeExtraDataInvokeFunctionalPage.nbb;
        } catch (JSONException e2) {
            Log.e("MicroMsg.AppBrandMixExportLogicService", "openWeappFunctionalPageByDeepLink, get JSONException %s", e2);
            str4 = "";
            str5 = "";
            wechatNativeExtraDataInvokeFunctionalPage = null;
            str6 = "__wx__/open-api-redirecting-page";
        }
        if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str5) || wechatNativeExtraDataInvokeFunctionalPage == null) {
            Log.e("MicroMsg.AppBrandMixExportLogicService", "openWeappFunctionalPageByDeepLink invalid apiName(%s) miniprogramAppID(%s) transferBuffer(%s)", str4, str5, str3);
            Pair<Integer, String> create = Pair.create(-1, "Invalid transferJson");
            AppMethodBeat.o(226291);
            return create;
        }
        com.tencent.mm.plugin.appbrand.api.g gVar = new com.tencent.mm.plugin.appbrand.api.g();
        gVar.appId = str5;
        gVar.kHw = str6;
        gVar.scene = 1111;
        gVar.dCw = queryParameter + ":" + str4;
        gVar.kHF = appBrandLaunchReferrer;
        gVar.kHx = wechatNativeExtraDataInvokeFunctionalPage;
        gVar.iOo = wechatNativeExtraDataInvokeFunctionalPage.nbf;
        if (com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.c.a(context, wechatNativeExtraDataInvokeFunctionalPage, gVar)) {
            Pair<Integer, String> create2 = Pair.create(0, "OK");
            AppMethodBeat.o(226291);
            return create2;
        }
        if (((String) Objects.requireNonNull(str4)).endsWith("openUrl")) {
            com.tencent.mm.cr.d.bpG("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
        }
        ((r) com.tencent.mm.kernel.g.af(r.class)).a(context, gVar);
        Pair<Integer, String> create3 = Pair.create(0, "OK");
        AppMethodBeat.o(226291);
        return create3;
    }
}
