package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.luggage.h.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.f.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase.d;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.k;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.p;
import com.tencent.mm.plugin.appbrand.menu.t;
import com.tencent.mm.plugin.appbrand.menu.u;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.gallery.model.n;
import com.tencent.mm.protocal.protobuf.dya;
import com.tencent.mm.protocal.protobuf.dyb;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.wework.api.IWWAPI;
import com.tencent.wework.api.WWAPIFactory;
import com.tencent.wework.api.model.WWMediaMiniProgram;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class JsApiShareAppMessageBase<Param extends d> extends com.tencent.mm.plugin.appbrand.jsapi.d<com.tencent.mm.plugin.appbrand.service.c> {
    final int mqZ = com.tencent.luggage.sdk.g.a.aK(this);

    /* access modifiers changed from: protected */
    public interface b {
        <ShareParams extends d> void a(ShareParams shareparams, Intent intent);

        <ShareParams extends d> void a(ShareParams shareparams, com.tencent.mm.plugin.appbrand.service.c cVar, JSONObject jSONObject);

        <ShareParams extends d> void a(SendAppMessageTask sendAppMessageTask, com.tencent.mm.plugin.appbrand.service.c cVar);

        <ShareParams extends d> void b(ShareParams shareparams);

        <ShareParams extends d> boolean c(ShareParams shareparams);
    }

    /* access modifiers changed from: protected */
    public abstract Param bIJ();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(com.tencent.mm.plugin.appbrand.service.c cVar, JSONObject jSONObject, final int i2) {
        String str;
        final com.tencent.mm.plugin.appbrand.service.c cVar2 = cVar;
        try {
            final Param a2 = a(cVar2, jSONObject);
            final Intent intent = new Intent();
            a(intent, a2);
            if (!TextUtils.isEmpty(a2.mrl) && a2.mrl.equals("qyweixin")) {
                com.tencent.mm.plugin.appbrand.utils.f.bZn().j(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase.AnonymousClass1 */

                    public final void run() {
                        boolean z;
                        AppMethodBeat.i(226982);
                        JsApiShareAppMessageBase jsApiShareAppMessageBase = JsApiShareAppMessageBase.this;
                        com.tencent.mm.plugin.appbrand.service.c cVar = cVar2;
                        int i2 = i2;
                        d dVar = a2;
                        Log.i("MicroMsg.JsApiShareAppMessageBase", "sendToWework");
                        AppBrandSysConfigWC bsB = cVar.getRuntime().bsB();
                        WWMediaMiniProgram wWMediaMiniProgram = new WWMediaMiniProgram();
                        wWMediaMiniProgram.username = dVar.userName;
                        wWMediaMiniProgram.path = dVar.dCx;
                        wWMediaMiniProgram.title = dVar.title;
                        if (TextUtils.isEmpty(wWMediaMiniProgram.title)) {
                            wWMediaMiniProgram.title = bsB.brandName;
                        }
                        wWMediaMiniProgram.Sxx = dVar.dMe;
                        wWMediaMiniProgram.type = 0;
                        if (bsB != null) {
                            wWMediaMiniProgram.name = bsB.brandName;
                            wWMediaMiniProgram.iconUrl = bsB.jyi;
                        }
                        Log.i("MicroMsg.JsApiShareAppMessageBase", "username:%s, path:%s, title:%s, name:%s, iconUrl:%s, miniProgramType:%d, imgPath:%s", wWMediaMiniProgram.username, wWMediaMiniProgram.path, wWMediaMiniProgram.title, wWMediaMiniProgram.name, wWMediaMiniProgram.iconUrl, Integer.valueOf(wWMediaMiniProgram.Sxx), dVar.dRr);
                        String str = !TextUtils.isEmpty(dVar.dRr) ? dVar.dRr : dVar.imageUrl;
                        Log.i("MicroMsg.JsApiShareAppMessageBase", "imageUrl:%s", dVar.imageUrl);
                        if (!TextUtils.isEmpty(str)) {
                            String aaL = y.aaL(str);
                            com.tencent.mm.plugin.appbrand.f.a aVar = (com.tencent.mm.plugin.appbrand.f.a) cVar.M(com.tencent.mm.plugin.appbrand.f.a.class);
                            if (com.tencent.mm.pluginsdk.j.a.d.a.YS(aaL)) {
                                Bitmap ayT = n.ayT(aaL);
                                if (ayT != null) {
                                    JsApiShareAppMessageBase.a(ayT, wWMediaMiniProgram);
                                }
                                z = true;
                            } else if (aVar != null) {
                                Log.i("MicroMsg.JsApiShareAppMessageBase", "load bitmap imagePath:%s", aaL);
                                Bitmap a2 = aVar.a(aaL, (Rect) null, new a.b(wWMediaMiniProgram, cVar, i2) {
                                    /* class com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase.AnonymousClass6 */
                                    final /* synthetic */ int cvP;
                                    final /* synthetic */ com.tencent.mm.plugin.appbrand.service.c lzl;
                                    final /* synthetic */ WWMediaMiniProgram mrf;

                                    {
                                        this.mrf = r2;
                                        this.lzl = r3;
                                        this.cvP = r4;
                                    }

                                    @Override // com.tencent.mm.plugin.appbrand.f.a.b
                                    public final void Q(Bitmap bitmap) {
                                        AppMethodBeat.i(226987);
                                        if (bitmap != null) {
                                            Log.i("MicroMsg.JsApiShareAppMessageBase", "load bitmap onResult success");
                                            JsApiShareAppMessageBase.a(bitmap, this.mrf);
                                        } else {
                                            Log.i("MicroMsg.JsApiShareAppMessageBase", "load bitmap onResult fail");
                                            this.mrf.Sxw = new byte[1];
                                        }
                                        try {
                                            WWAPIFactory.ly(this.lzl.getContext()).a(this.mrf, IWWAPI.WWAppType.WwAppTypeDefault);
                                        } catch (Exception e2) {
                                            Log.printErrStackTrace("MicroMsg.JsApiShareAppMessageBase", e2, "", new Object[0]);
                                        }
                                        this.lzl.i(this.cvP, JsApiShareAppMessageBase.this.h("ok", null));
                                        AppMethodBeat.o(226987);
                                    }
                                });
                                if (a2 != null) {
                                    Log.i("MicroMsg.JsApiShareAppMessageBase", "load bitmap success");
                                    JsApiShareAppMessageBase.a(a2, wWMediaMiniProgram);
                                    z = true;
                                } else {
                                    Log.i("MicroMsg.JsApiShareAppMessageBase", "don't send message");
                                    z = false;
                                }
                            } else {
                                wWMediaMiniProgram.Sxw = new byte[1];
                                Log.e("MicroMsg.JsApiShareAppMessageBase", "loader is null");
                                z = true;
                            }
                        } else {
                            Log.e("MicroMsg.JsApiShareAppMessageBase", "imgPath is empty");
                            wWMediaMiniProgram.Sxw = new byte[1];
                            z = true;
                        }
                        if (z) {
                            try {
                                WWAPIFactory.ly(cVar.getContext()).a(wWMediaMiniProgram, IWWAPI.WWAppType.WwAppTypeDefault);
                            } catch (Exception e2) {
                                Log.printErrStackTrace("MicroMsg.JsApiShareAppMessageBase", e2, "", new Object[0]);
                            }
                            cVar.i(i2, jsApiShareAppMessageBase.h("ok", null));
                        }
                        AppMethodBeat.o(226982);
                    }
                }, 500);
            } else if (Util.isNullOrNil(a2.mrs) && Util.isNullOrNil(a2.mrt)) {
                a(cVar2, i2, a2, intent, false);
            } else if (!Util.isNullOrNil(a2.mrt)) {
                intent.putExtra("Select_Conv_User", a2.mrt);
                intent.putExtra("KSendWording", a2.dKq.getResources().getString(R.string.a3j));
                a(cVar2, i2, a2, intent, true);
            } else {
                dya dya = new dya();
                dya.dNI = a2.appId;
                dya.openid = a2.mrs;
                d.a aVar = new d.a();
                aVar.funcId = 1961;
                aVar.uri = "/cgi-bin/mmbiz-bin/wxabusiness/share_transid";
                aVar.iLN = dya;
                aVar.iLO = new dyb();
                IPCRunCgi.a(aVar.aXF(), new IPCRunCgi.a() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase.AnonymousClass2 */

                    /* JADX DEBUG: Multi-variable search result rejected for r0v19, resolved type: com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
                    public final void a(int i2, int i3, String str, com.tencent.mm.ak.d dVar) {
                        AppMethodBeat.i(226983);
                        if (i2 != 0 || i3 != 0 || dVar == null || dVar.iLL.iLR == null || !(dVar.iLL.iLR instanceof dyb)) {
                            Log.e("MicroMsg.JsApiShareAppMessageBase", "shareTransId fail, convert openId to username fail");
                            cVar2.i(i2, JsApiShareAppMessageBase.this.h("fail:convert openId to username fail", null));
                            AppMethodBeat.o(226983);
                            return;
                        }
                        dyb dyb = (dyb) dVar.iLL.iLR;
                        if (dyb.MXF.dIZ == 0 && !Util.isNullOrNil(dyb.username)) {
                            Log.i("MicroMsg.JsApiShareAppMessageBase", "shareTransId success, username:%s", dyb.username);
                            intent.putExtra("Select_Conv_User", dyb.username);
                            intent.putExtra("KSendWording", a2.dKq.getResources().getString(R.string.a3j));
                            JsApiShareAppMessageBase.this.a(cVar2, i2, a2, intent, true);
                            AppMethodBeat.o(226983);
                        } else if (!Util.isNullOrNil(dyb.MXF.dJa)) {
                            Log.e("MicroMsg.JsApiShareAppMessageBase", "shareTransId fail, response error msg:%s", dyb.MXF.dJa);
                            cVar2.i(i2, JsApiShareAppMessageBase.this.h("fail:" + dyb.MXF.dJa, null));
                            AppMethodBeat.o(226983);
                        } else {
                            Log.e("MicroMsg.JsApiShareAppMessageBase", "shareTransId fail, response username is null");
                            cVar2.i(i2, JsApiShareAppMessageBase.this.h("fail:response username is null", null));
                            AppMethodBeat.o(226983);
                        }
                    }
                });
            }
        } catch (c e2) {
            Log.printErrStackTrace("MicroMsg.JsApiShareAppMessageBase", e2, "hy: illegal params", new Object[0]);
            a aVar2 = e2.mrh;
            if (aVar2 == null) {
                aVar2 = new a(e2.getMessage());
            }
            if (Util.nullAsNil(aVar2.errMsg).startsWith("fail")) {
                str = aVar2.errMsg;
            } else {
                str = "fail: " + aVar2.errMsg;
            }
            cVar2.i(i2, n(str, aVar2.mrg));
        }
    }

    /* access modifiers changed from: package-private */
    public static class g implements b {
        private g() {
        }

        /* synthetic */ g(byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase.b
        public final <ShareParams extends d> void a(ShareParams shareparams, com.tencent.mm.plugin.appbrand.service.c cVar, JSONObject jSONObject) {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase.b
        public final <ShareParams extends d> void a(ShareParams shareparams, Intent intent) {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase.b
        public final <ShareParams extends d> void a(SendAppMessageTask sendAppMessageTask, com.tencent.mm.plugin.appbrand.service.c cVar) {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase.b
        public final <ShareParams extends d> void b(ShareParams shareparams) {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase.b
        public final <ShareParams extends d> boolean c(ShareParams shareparams) {
            AppMethodBeat.i(174900);
            boolean startsWith = Util.nullAsNil(shareparams.dRr).startsWith("delayLoadFile://");
            AppMethodBeat.o(174900);
            return startsWith;
        }

        public final String toString() {
            return "ShareTypeNormal{}";
        }
    }

    /* access modifiers changed from: protected */
    public static class h implements b {
        String ebj;
        String ivp;
        String mrD;
        String mrE;
        String mrF;
        String videoPath;

        protected h() {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase.b
        public final <ShareParams extends d> void a(ShareParams shareparams, com.tencent.mm.plugin.appbrand.service.c cVar, JSONObject jSONObject) {
            AppMethodBeat.i(174901);
            this.videoPath = jSONObject.optString("videoPath");
            String optString = jSONObject.optString("videoThumbPath");
            this.ebj = jSONObject.optString("videoMD5");
            this.mrD = jSONObject.optString("videoButtonText");
            this.ivp = jSONObject.optString("playDesc");
            this.mrE = y.a(shareparams.mri, this.videoPath, shareparams.mrr);
            this.mrF = y.a(shareparams.mri, optString, shareparams.mrr);
            if (Util.isNullOrNil(this.mrE) || Util.isNullOrNil(this.mrF) || Util.isNullOrNil(this.ebj)) {
                Log.w("MicroMsg.JsApiShareAppMessageBase", "hy: try share video but video path or video thumbpath or md5 is null nil");
                c cVar2 = new c("try share video but video path or video thumbpath is null nil");
                AppMethodBeat.o(174901);
                throw cVar2;
            }
            shareparams.mrv.put("is_video", Boolean.TRUE);
            shareparams.mrv.put("footer_icon", shareparams.mrj.jyi);
            shareparams.mrv.put("footer_text", shareparams.mrj.brandName);
            shareparams.mrv.put("video_path", this.mrE);
            shareparams.mrv.put("video_thumb_path", this.mrF);
            AppMethodBeat.o(174901);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase.b
        public final <ShareParams extends d> void a(ShareParams shareparams, Intent intent) {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase.b
        public final <ShareParams extends d> void a(SendAppMessageTask sendAppMessageTask, com.tencent.mm.plugin.appbrand.service.c cVar) {
            AppMethodBeat.i(174902);
            sendAppMessageTask.msi = 4;
            sendAppMessageTask.msn = true;
            sendAppMessageTask.videoPath = y.aaL(this.mrE);
            sendAppMessageTask.mss = y.aaL(this.mrF);
            sendAppMessageTask.ebj = this.ebj;
            sendAppMessageTask.mrD = this.mrD;
            sendAppMessageTask.ivp = this.ivp;
            sendAppMessageTask.msf = y.aaL(this.mrF);
            AppMethodBeat.o(174902);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase.b
        public final <ShareParams extends d> void b(ShareParams shareparams) {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase.b
        public final <ShareParams extends d> boolean c(ShareParams shareparams) {
            AppMethodBeat.i(174903);
            if (Util.nullAsNil(shareparams.dRr).startsWith("delayLoadFile://") || Util.nullAsNil(this.mrE).startsWith("delayLoadFile://") || Util.nullAsNil(this.mrF).startsWith("delayLoadFile://")) {
                AppMethodBeat.o(174903);
                return true;
            }
            AppMethodBeat.o(174903);
            return false;
        }

        public final String toString() {
            AppMethodBeat.i(174904);
            String str = "ShareTypeVideo{videoPath='" + this.videoPath + '\'' + ", videoMD5='" + this.ebj + '\'' + ", videoButtonText='" + this.mrD + '\'' + ", videoPlayDesc='" + this.ivp + '\'' + ", videoPathInFileSystem='" + this.mrE + '\'' + ", videoThumbPathInFileSystem='" + this.mrF + '\'' + '}';
            AppMethodBeat.o(174904);
            return str;
        }
    }

    /* access modifiers changed from: protected */
    public static class f implements b {
        String mrC;

        protected f() {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase.b
        public final <ShareParams extends d> void a(ShareParams shareparams, com.tencent.mm.plugin.appbrand.service.c cVar, JSONObject jSONObject) {
            AppMethodBeat.i(174896);
            this.mrC = jSONObject.optString("link");
            if (Util.isNullOrNil(this.mrC)) {
                Log.w("MicroMsg.JsApiShareAppMessageBase", "hy: is h5 share type but no link!");
                c cVar2 = new c("is h5 share type but no h5 link");
                AppMethodBeat.o(174896);
                throw cVar2;
            }
            shareparams.mrv.put("is_h5", Boolean.TRUE);
            AppMethodBeat.o(174896);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase.b
        public final <ShareParams extends d> void a(ShareParams shareparams, Intent intent) {
            AppMethodBeat.i(174897);
            HashMap hashMap = new HashMap(4);
            hashMap.put("img_url", shareparams.imageUrl);
            hashMap.put("title", shareparams.title);
            hashMap.put("desc", shareparams.desc);
            hashMap.put("url", this.mrC);
            intent.putExtra("webview_params", hashMap);
            AppMethodBeat.o(174897);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase.b
        public final <ShareParams extends d> void a(SendAppMessageTask sendAppMessageTask, com.tencent.mm.plugin.appbrand.service.c cVar) {
            sendAppMessageTask.msi = 5;
            sendAppMessageTask.url = this.mrC;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase.b
        public final <ShareParams extends d> void b(ShareParams shareparams) {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase.b
        public final <ShareParams extends d> boolean c(ShareParams shareparams) {
            AppMethodBeat.i(174898);
            boolean startsWith = Util.nullAsNil(shareparams.dRr).startsWith("delayLoadFile://");
            AppMethodBeat.o(174898);
            return startsWith;
        }

        public final String toString() {
            AppMethodBeat.i(174899);
            String str = "ShareTypeH5{h5Link='" + this.mrC + '\'' + '}';
            AppMethodBeat.o(174899);
            return str;
        }
    }

    /* access modifiers changed from: protected */
    public static class i implements b {
        protected i() {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase.b
        public final <ShareParams extends d> void a(ShareParams shareparams, com.tencent.mm.plugin.appbrand.service.c cVar, JSONObject jSONObject) {
            AppMethodBeat.i(174905);
            shareparams.mrr = false;
            String optString = jSONObject.optString("webpageUrl");
            if (Util.isNullOrNil(optString)) {
                optString = w.Ur(cVar.getAppId());
            }
            shareparams.lho = optString;
            shareparams.mrv.put("is_weishi_video", Boolean.TRUE);
            AppBrandInitConfigWC bsC = cVar.getRuntime().bsC();
            if (bsC.cyt != null && !Util.isNullOrNil(bsC.cyt.leO)) {
                shareparams.mrv.put("msg_img_path", bsC.cyt.leO);
            }
            AppMethodBeat.o(174905);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase.b
        public final <ShareParams extends d> void a(ShareParams shareparams, Intent intent) {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase.b
        public final <ShareParams extends d> void a(SendAppMessageTask sendAppMessageTask, com.tencent.mm.plugin.appbrand.service.c cVar) {
            AppMethodBeat.i(174906);
            AppBrandInitConfigWC bsC = cVar.getRuntime().bsC();
            sendAppMessageTask.msi = 3;
            if (bsC.cyt != null) {
                sendAppMessageTask.mso = bsC.cyt.appId;
                sendAppMessageTask.msp = bsC.cyt.appName;
                sendAppMessageTask.msq = bsC.cyt.sourceUserName;
                sendAppMessageTask.msr = bsC.cyt.thumbUrl;
                if (Util.isNullOrNil(sendAppMessageTask.mse)) {
                    sendAppMessageTask.msf = bsC.cyt.leN;
                    sendAppMessageTask.lSk = false;
                }
            }
            AppMethodBeat.o(174906);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase.b
        public final <ShareParams extends d> boolean c(ShareParams shareparams) {
            AppMethodBeat.i(174907);
            boolean startsWith = Util.nullAsNil(shareparams.dRr).startsWith("delayLoadFile://");
            AppMethodBeat.o(174907);
            return startsWith;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase.b
        public final <ShareParams extends d> void b(ShareParams shareparams) {
            AppMethodBeat.i(174908);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(16979, shareparams.appId, shareparams.dCx, 0, 3);
            AppMethodBeat.o(174908);
        }
    }

    /* access modifiers changed from: protected */
    public static class d {
        String appId;
        String cacheKey;
        String dCx;
        Activity dKq = null;
        int dMe;
        String dRr;
        String desc;
        String eda;
        String imageUrl;
        public String ivd = "";
        String ixM;
        boolean lSk;
        String lho;
        ag mri = null;
        AppBrandSysConfigWC mrj = null;
        boolean mrk;
        String mrl;
        b mrm;
        boolean mrn;
        boolean mro;
        boolean mrp;
        int mrq;
        boolean mrr = false;
        String mrs = "";
        String mrt = "";
        public boolean mru;
        HashMap<String, Object> mrv;
        int mrw = 0;
        String mrx;
        int pkgVersion;
        int subType = 0;
        String title;
        int type = -1;
        String userName;
        boolean withShareTicket = false;

        protected d() {
        }

        public String toString() {
            AppMethodBeat.i(174895);
            String str = "Params{context=" + this.dKq + ", pageView=" + this.mri + ", config=" + this.mrj + ", withShareTicket=" + this.withShareTicket + ", type=" + this.type + ", subType=" + this.subType + ", title='" + this.title + '\'' + ", desc='" + this.desc + '\'' + ", pagePath='" + this.dCx + '\'' + ", imageUrl='" + this.imageUrl + '\'' + ", cacheKey='" + this.cacheKey + '\'' + ", disableForward=" + this.mrk + ", messageExtraData='" + this.eda + '\'' + ", mShareExtImp=" + this.mrm + ", isDynamicMsg=" + this.mrn + ", isUpdateMsg=" + this.mro + ", isPrivateMsg=" + this.mrp + ", templateId='" + this.ixM + '\'' + ", appId='" + this.appId + '\'' + ", userName='" + this.userName + '\'' + ", pkgType=" + this.dMe + ", pkgVersion=" + this.pkgVersion + ", finalAppServiceTypeReport=" + this.mrq + ", errorUrl='" + this.lho + '\'' + ", needDelThumb=" + this.lSk + ", imgPath='" + this.dRr + '\'' + ", useDefaultSnapshot=" + this.mrr + ", msgParams=" + this.mrv + ", todoActivityId=" + this.ivd + ", isToDoMessage=" + this.mru + ", kv14077ReportShareSourceType=" + this.mrw + ", currentHtmlUrl=" + this.mrx + '}';
            AppMethodBeat.o(174895);
            return str;
        }
    }

    protected static class a {
        int errCode;
        String errMsg;
        Map<String, String> mrg;

        a(String str) {
            this(str, (byte) 0);
        }

        private a(String str, byte b2) {
            this.errCode = 0;
            this.errMsg = "";
            this.mrg = null;
            this.errCode = -1;
            this.errMsg = str;
            this.mrg = null;
        }
    }

    /* access modifiers changed from: protected */
    public static class c extends IllegalArgumentException {
        a mrh;

        c(String str) {
            super(str);
        }
    }

    /* access modifiers changed from: protected */
    public Param a(com.tencent.mm.plugin.appbrand.service.c cVar, JSONObject jSONObject) {
        b gVar;
        Log.i("MicroMsg.JsApiShareAppMessageBase", "invoke share app message directly.");
        Param bIJ = bIJ();
        if (jSONObject == null) {
            Log.i("MicroMsg.JsApiShareAppMessageBase", "data is null");
            throw new c("data is null");
        }
        bIJ.dKq = cVar.ay(Activity.class);
        if (bIJ.dKq == null) {
            Log.i("MicroMsg.JsApiShareAppMessageBase", "share app message fail, context is null");
            throw new c("fail:internal error invalid android context");
        }
        bIJ.mri = (ag) cVar.ax(ag.class);
        if (bIJ.mri == null) {
            Log.i("MicroMsg.JsApiShareAppMessageBase", "share app message fail, pageView is null");
            throw new c("current page do not exist");
        }
        t yK = bIJ.mri.yK(u.ShareAppMsg.ordinal());
        t yK2 = bIJ.mri.yK(u.ShareToWork.ordinal());
        if (yK == null && yK2 == null) {
            Log.i("MicroMsg.JsApiShareAppMessageBase", "share app message fail, menuInfo is null.");
            throw new c("menu is null");
        }
        String optString = jSONObject.optString("type");
        if (com.tencent.mm.plugin.appbrand.af.g.an(cVar.getRuntime())) {
            optString = "weishi";
        }
        if (Util.isNullOrNil(optString)) {
            optString = "normal";
        }
        String optString2 = jSONObject.optString("to");
        Log.i("MicroMsg.JsApiShareAppMessageBase", "hy: share type is %s", optString);
        if ("video".equalsIgnoreCase(optString)) {
            gVar = new h();
        } else if ("h5".equalsIgnoreCase(optString)) {
            gVar = new f();
        } else if ("weishi".equalsIgnoreCase(optString)) {
            gVar = new i();
        } else {
            gVar = new g((byte) 0);
        }
        bIJ.mrm = gVar;
        bIJ.mrj = cVar.getRuntime().bsB();
        bIJ.withShareTicket = yK.lEi.getBoolean("enable_share_with_share_ticket", false);
        if (!bIJ.withShareTicket && (cVar instanceof p)) {
            bIJ.withShareTicket = "withShareTicket".equals(jSONObject.optString("mode"));
        }
        bIJ.mru = yK.lEi.getBoolean("is_todo_message", false);
        bIJ.ivd = yK.lEi.getString("share_todo_activity_id", "");
        bIJ.type = bIJ.withShareTicket ? 3 : 2;
        bIJ.title = jSONObject.optString("title");
        bIJ.desc = jSONObject.optString("desc", "");
        bIJ.dCx = jSONObject.optString("path");
        bIJ.imageUrl = jSONObject.optString("imageUrl");
        bIJ.cacheKey = jSONObject.optString("cacheKey");
        bIJ.mrk = jSONObject.optBoolean("disableForward", false);
        Log.i("MicroMsg.JsApiShareAppMessageBase", "disableForward:%b", Boolean.valueOf(bIJ.mrk));
        bIJ.eda = jSONObject.optString("messageExtraData");
        bIJ.subType = jSONObject.optInt("cardSubType", 0);
        bIJ.mrr = jSONObject.optBoolean("useDefaultSnapshot", true);
        bIJ.mrl = optString2;
        AppBrandInitConfigWC bsC = cVar.getRuntime().bsC();
        if (bsC == null) {
            Log.e("MicroMsg.JsApiShareAppMessageBase", "hy: no init config");
            throw new c("no init config");
        }
        bIJ.mrn = yK.lEi.JY("enable_share_dynamic");
        bIJ.mro = yK.lEi.JY("enable_share_with_updateable_msg");
        bIJ.mrp = yK.lEi.JY("enable_share_with_private_msg");
        bIJ.ixM = yK.lEi.getString("enable_share_with_updateable_msg_template_id", "");
        bIJ.appId = cVar.getAppId();
        bIJ.userName = bsC.username;
        bIJ.dMe = bIJ.mrj.leE.kNW;
        bIJ.pkgVersion = bIJ.mrj.leE.pkgVersion;
        bIJ.mrq = cVar.getRuntime().bsC().cyo;
        bIJ.lho = w.Ur(cVar.getAppId());
        bIJ.lSk = y.aaK(bIJ.imageUrl);
        bIJ.dRr = y.a(bIJ.mri, bIJ.imageUrl, bIJ.mrr);
        Log.i("MicroMsg.JsApiShareAppMessageBase", "imgPath[%s] imageUrl[%s] default[%s]", bIJ.dRr, bIJ.imageUrl, Boolean.valueOf(bIJ.mrr));
        bIJ.mrv = new HashMap<>();
        bIJ.mrv.put("desc", bIJ.desc);
        bIJ.mrv.put("type", Integer.valueOf(bIJ.type));
        bIJ.mrv.put("title", bIJ.title);
        bIJ.mrv.put("app_id", bIJ.appId);
        bIJ.mrv.put("pkg_type", Integer.valueOf(bIJ.dMe));
        bIJ.mrv.put("pkg_version", Integer.valueOf(bIJ.pkgVersion));
        bIJ.mrv.put("img_url", bIJ.imageUrl);
        bIJ.mrv.put("is_dynamic", Boolean.valueOf(bIJ.mrn));
        bIJ.mrv.put("cache_key", bIJ.cacheKey);
        bIJ.mrv.put("path", bIJ.dCx);
        bIJ.mrv.put("disableForward", Boolean.valueOf(bIJ.mrk));
        bIJ.mrv.put("subType", Integer.valueOf(bIJ.subType));
        if (!Util.isNullOrNil(bIJ.dRr)) {
            bIJ.mrv.put("delay_load_img_path", bIJ.dRr);
        }
        bIJ.mrs = jSONObject.optString("openId");
        bIJ.mrt = jSONObject.optString("chatroomUsername");
        bIJ.mrm.a(bIJ, cVar, jSONObject);
        ag bsz = cVar.bsz();
        com.tencent.mm.plugin.appbrand.jsapi.af.a bRM = bsz == null ? null : bsz.bRM();
        if (bRM != null) {
            bIJ.mrx = bRM.getWebView().getUrl();
        } else if (bsz instanceof k) {
            bIJ.mrx = jSONObject.optString("webViewUrl");
        }
        boolean optBoolean = jSONObject.optBoolean("sdk_isFromMenu", false);
        String name = getName();
        if (TextUtils.isEmpty(name) || name.equals(d.NAME)) {
            bIJ.mrw = 0;
        } else if (name.contains("ToSpecificContact")) {
            bIJ.mrw = 2;
        } else if (optBoolean) {
            bIJ.mrw = 0;
        } else {
            bIJ.mrw = 1;
        }
        Log.i("MicroMsg.JsApiShareAppMessageBase", "hy: params: %s", bIJ.toString());
        return bIJ;
    }

    /* access modifiers changed from: protected */
    public void a(Intent intent, Param param) {
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("mutil_select_is_ret", !param.withShareTicket);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("scene_from", 3);
        intent.putExtra("appbrand_params", param.mrv);
        intent.putExtra("Retr_Msg_Type", 2);
        param.mrm.a(param, intent);
    }

    /* access modifiers changed from: package-private */
    public final void a(final com.tencent.mm.plugin.appbrand.service.c cVar, final int i2, final Param param, final Intent intent, final boolean z) {
        long j2;
        final AnonymousClass3 r3 = new MMActivity.a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase.AnonymousClass3 */

            /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase */
            /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase */
            /* JADX DEBUG: Multi-variable search result rejected for r2v12, resolved type: com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.tencent.mm.ui.MMActivity.a
            public final void d(int i2, int i3, Intent intent) {
                boolean z;
                int i4 = 0;
                AppMethodBeat.i(226984);
                if (i2 != JsApiShareAppMessageBase.this.mqZ) {
                    Log.i("MicroMsg.JsApiShareAppMessageBase", "requestCode(%d) not corrected.", Integer.valueOf(i2));
                    AppMethodBeat.o(226984);
                    return;
                }
                String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
                if (intent == null || !intent.getBooleanExtra("KSendGroupToDo", false)) {
                    z = false;
                } else {
                    z = true;
                }
                int intExtra = intent == null ? 0 : intent.getIntExtra("KShowTodoIntroduceView", 0);
                if (i3 != -1) {
                    Log.i("MicroMsg.JsApiShareAppMessageBase", "resultCode is not RESULT_OK(%d)", Integer.valueOf(i3));
                    JsApiShareAppMessageBase.this.a(param, i3);
                    cVar.i(i2, JsApiShareAppMessageBase.this.h("cancel", null));
                    String str = param.userName;
                    String str2 = param.mrj.brandName;
                    if (z) {
                        i4 = 1;
                    }
                    JsApiShareAppMessageBase.c(stringExtra, str, str2, i4, intExtra, 1);
                    AppMethodBeat.o(226984);
                } else if (stringExtra == null || stringExtra.length() == 0) {
                    Log.e("MicroMsg.JsApiShareAppMessageBase", "mmOnActivityResult fail, toUser is null");
                    JsApiShareAppMessageBase.this.a(param);
                    cVar.i(i2, JsApiShareAppMessageBase.this.h("fail:selected user is nil", null));
                    AppMethodBeat.o(226984);
                } else {
                    Log.i("MicroMsg.JsApiShareAppMessageBase", "result success toUser : %s ", stringExtra);
                    String stringExtra2 = intent.getStringExtra("custom_send_text");
                    String str3 = param.userName;
                    String str4 = param.mrj.brandName;
                    if (z) {
                        i4 = 1;
                    }
                    JsApiShareAppMessageBase.c(stringExtra, str3, str4, i4, intExtra, 2);
                    JsApiShareAppMessageBase.this.a(stringExtra, stringExtra2, z, cVar, i2, param);
                    AppMethodBeat.o(226984);
                }
            }
        };
        AnonymousClass4 r0 = new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase.AnonymousClass4 */

            public final void run() {
                String str;
                AppMethodBeat.i(174894);
                com.tencent.luggage.h.f.aK(param.dKq).b(new f.c() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase.AnonymousClass4.AnonymousClass1 */

                    @Override // com.tencent.luggage.h.f.c
                    public final boolean c(int i2, int i3, Intent intent) {
                        AppMethodBeat.i(226985);
                        if (JsApiShareAppMessageBase.this.mqZ != i2) {
                            AppMethodBeat.o(226985);
                            return false;
                        }
                        r3.d(i2, i3, intent);
                        AppMethodBeat.o(226985);
                        return true;
                    }
                });
                Activity activity = param.dKq;
                if (z) {
                    str = ".ui.transmit.SelectConversationDirectSelectUI";
                } else {
                    str = ".ui.transmit.SelectConversationUI";
                }
                com.tencent.mm.br.c.c(activity, str, intent, JsApiShareAppMessageBase.this.mqZ);
                AppMethodBeat.o(174894);
            }
        };
        if (param.mrm.c(param)) {
            Log.d("MicroMsg.JsApiShareAppMessageBase", "hy: should delay navigate");
            j2 = 200;
        } else {
            j2 = 0;
        }
        cVar.i(r0, j2);
    }

    /* access modifiers changed from: protected */
    public void a(Param param, int i2) {
    }

    /* access modifiers changed from: protected */
    public void a(Param param) {
    }

    /* access modifiers changed from: protected */
    public void a(boolean z, Param param, String str) {
    }

    /* access modifiers changed from: protected */
    public void a(SendAppMessageTask sendAppMessageTask, String str, String str2, boolean z, com.tencent.mm.plugin.appbrand.service.c cVar, Param param) {
        sendAppMessageTask.msd = str2;
        sendAppMessageTask.toUser = str;
        sendAppMessageTask.appId = param.appId;
        q runtime = cVar.getRuntime();
        if (runtime == null || runtime.OU() == null || !(runtime.OU() instanceof AppBrandInitConfigWC)) {
            Log.w("MicroMsg.JsApiShareAppMessageBase", "hy: can not retrieve init config");
            sendAppMessageTask.appVersion = -1;
        } else {
            sendAppMessageTask.appVersion = ((AppBrandInitConfigWC) runtime.OU()).appVersion;
        }
        sendAppMessageTask.userName = param.userName;
        sendAppMessageTask.title = param.title;
        sendAppMessageTask.description = param.desc;
        sendAppMessageTask.url = param.lho;
        sendAppMessageTask.path = param.dCx;
        sendAppMessageTask.type = param.type;
        sendAppMessageTask.lSk = param.lSk;
        sendAppMessageTask.mse = param.imageUrl;
        sendAppMessageTask.iconUrl = param.mrj.jyi;
        sendAppMessageTask.dMe = param.mrj.leE.kNW;
        sendAppMessageTask.lhn = param.mrj.leE.md5;
        sendAppMessageTask.version = param.mrj.leE.pkgVersion;
        sendAppMessageTask.nickname = param.mrj.brandName;
        sendAppMessageTask.eda = param.eda;
        sendAppMessageTask.leb = param.mrj.leb;
        sendAppMessageTask.subType = param.subType;
        sendAppMessageTask.lyE = param.mrk ? 1 : 0;
        sendAppMessageTask.msj = com.tencent.mm.plugin.appbrand.p.Un(param.appId).kCQ.getAndIncrement();
        sendAppMessageTask.msl = param.mri.lBI;
        sendAppMessageTask.msm = param.mri.bDn();
        AppBrandStatObject appBrandStatObject = param.mri.getRuntime().ON().cyA;
        if (appBrandStatObject != null) {
            sendAppMessageTask.scene = appBrandStatObject.scene == 0 ? 1000 : appBrandStatObject.scene;
            sendAppMessageTask.dCw = Util.nullAsNil(appBrandStatObject.dCw);
            sendAppMessageTask.msk = Util.nullAsNil(param.mri.getRuntime().bsC().cym);
        }
        sendAppMessageTask.msf = y.aaL(param.dRr);
        sendAppMessageTask.withShareTicket = param.withShareTicket;
        sendAppMessageTask.mrn = param.mrn;
        sendAppMessageTask.mro = param.mro;
        sendAppMessageTask.mrp = param.mrp;
        sendAppMessageTask.ixM = param.ixM;
        sendAppMessageTask.cacheKey = param.cacheKey;
        sendAppMessageTask.serviceType = param.mrq;
        sendAppMessageTask.mrx = param.mrx;
        param.mrm.a(sendAppMessageTask, cVar);
        sendAppMessageTask.mru = param.mru;
        sendAppMessageTask.ivd = param.ivd;
        sendAppMessageTask.ivq = z;
        sendAppMessageTask.mrw = param.mrw;
    }

    /* access modifiers changed from: protected */
    public final void a(final String str, String str2, boolean z, final com.tencent.mm.plugin.appbrand.service.c cVar, final int i2, final Param param) {
        final SendAppMessageTask sendAppMessageTask = new SendAppMessageTask();
        a(sendAppMessageTask, str, str2, z, cVar, param);
        if (param.withShareTicket) {
            sendAppMessageTask.lyv = new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase.AnonymousClass5 */

                /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase */
                /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase */
                /* JADX WARN: Multi-variable type inference failed */
                public final void run() {
                    AppMethodBeat.i(226986);
                    Log.i("MicroMsg.JsApiShareAppMessageBase", "task callback");
                    sendAppMessageTask.bDK();
                    cVar.i(i2, JsApiShareAppMessageBase.this.n("ok", JsApiShareAppMessageBase.this.a(param, sendAppMessageTask, str)));
                    JsApiShareAppMessageBase.this.a(true, param, str);
                    AppMethodBeat.o(226986);
                }
            };
            sendAppMessageTask.bDJ();
            AppBrandMainProcessService.a(sendAppMessageTask);
        } else {
            AppBrandMainProcessService.a(sendAppMessageTask);
            cVar.i(i2, n("ok", a(param, sendAppMessageTask, str)));
            a(false, (d) param, str);
        }
        if (param.dKq != null) {
            com.tencent.mm.ui.base.h.cD(param.dKq, param.dKq.getResources().getString(R.string.ie));
        }
    }

    /* access modifiers changed from: protected */
    public Map<String, Object> a(Param param, SendAppMessageTask sendAppMessageTask, String str) {
        if (!param.withShareTicket) {
            return null;
        }
        HashMap hashMap = new HashMap();
        JSONArray jSONArray = new JSONArray();
        try {
            if (!Util.isNullOrNil(sendAppMessageTask.mst)) {
                Iterator<ShareInfo> it = sendAppMessageTask.mst.iterator();
                while (it.hasNext()) {
                    ShareInfo next = it.next();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("shareKey", next.cyr);
                    jSONObject.put("shareName", next.cyq);
                    jSONArray.put(jSONObject);
                }
            }
        } catch (JSONException e2) {
            Log.e("MicroMsg.JsApiShareAppMessageBase", android.util.Log.getStackTraceString(e2));
        }
        hashMap.put("shareInfos", jSONArray);
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    public static class e implements com.tencent.mm.ipcinvoker.k<ShareDialogTodoReportData, IPCVoid> {
        private e() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ IPCVoid invoke(ShareDialogTodoReportData shareDialogTodoReportData) {
            AppMethodBeat.i(184719);
            ShareDialogTodoReportData shareDialogTodoReportData2 = shareDialogTodoReportData;
            ((com.tencent.mm.plugin.messenger.foundation.a.t) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.t.class)).b(shareDialogTodoReportData2.mry, shareDialogTodoReportData2.username, shareDialogTodoReportData2.ixZ, shareDialogTodoReportData2.mrz, shareDialogTodoReportData2.mrA, shareDialogTodoReportData2.mrB);
            IPCVoid iPCVoid = new IPCVoid();
            AppMethodBeat.o(184719);
            return iPCVoid;
        }
    }

    /* access modifiers changed from: package-private */
    public static class ShareDialogTodoReportData implements Parcelable {
        public static final Parcelable.Creator<ShareDialogTodoReportData> CREATOR = new Parcelable.Creator<ShareDialogTodoReportData>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase.ShareDialogTodoReportData.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ ShareDialogTodoReportData[] newArray(int i2) {
                return new ShareDialogTodoReportData[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ ShareDialogTodoReportData createFromParcel(Parcel parcel) {
                AppMethodBeat.i(184720);
                ShareDialogTodoReportData shareDialogTodoReportData = new ShareDialogTodoReportData(parcel);
                AppMethodBeat.o(184720);
                return shareDialogTodoReportData;
            }
        };
        public String ixZ;
        public int mrA;
        public int mrB;
        public String mry;
        public int mrz;
        public String username;

        public ShareDialogTodoReportData(String str, String str2, String str3, int i2, int i3, int i4) {
            this.mry = str;
            this.username = str2;
            this.ixZ = str3;
            this.mrz = i2;
            this.mrA = i3;
            this.mrB = i4;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(184721);
            parcel.writeString(this.mry);
            parcel.writeString(this.username);
            parcel.writeString(this.ixZ);
            parcel.writeInt(this.mrz);
            parcel.writeInt(this.mrA);
            parcel.writeInt(this.mrB);
            AppMethodBeat.o(184721);
        }

        protected ShareDialogTodoReportData(Parcel parcel) {
            AppMethodBeat.i(184722);
            this.mry = parcel.readString();
            this.username = parcel.readString();
            this.ixZ = parcel.readString();
            this.mrz = parcel.readInt();
            this.mrA = parcel.readInt();
            this.mrB = parcel.readInt();
            AppMethodBeat.o(184722);
        }

        static {
            AppMethodBeat.i(184723);
            AppMethodBeat.o(184723);
        }
    }

    static void a(Bitmap bitmap, WWMediaMiniProgram wWMediaMiniProgram) {
        try {
            Log.i("MicroMsg.JsApiShareAppMessageBase", "writeBitmap, w:%d, h:%d", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()));
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int width2 = bitmap.getWidth();
            int height2 = bitmap.getHeight();
            if (!(width2 == 0 || height2 == 0)) {
                if (width2 <= 1024 || height2 <= 1024) {
                    if (width2 > 1024) {
                        height2 = (height2 * 1024) / width2;
                        width2 = 1024;
                    } else if (height2 > 1024) {
                        width2 = (width2 * 1024) / height2;
                        height2 = 1024;
                    }
                } else if (width2 > height2) {
                    height2 = (height2 * 1024) / width2;
                    width2 = 1024;
                } else if (width2 == height2) {
                    height2 = 1024;
                    width2 = 1024;
                } else {
                    width2 = (width2 * 1024) / height2;
                    height2 = 1024;
                }
            }
            if (!(width2 == width || height2 == height)) {
                bitmap = BitmapUtil.rotateAndScale(bitmap, 0.0f, ((float) width2) / ((float) width), ((float) height2) / ((float) height));
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 70, byteArrayOutputStream);
            wWMediaMiniProgram.Sxw = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (Exception e2) {
            Log.i("MicroMsg.JsApiShareAppMessageBase", "WWMediaMiniProgram.hdImageData Exception:%s", e2.getMessage());
            wWMediaMiniProgram.Sxw = new byte[1];
        }
    }

    static /* synthetic */ void c(String str, String str2, String str3, int i2, int i3, int i4) {
        XIPCInvoker.a(MainProcessIPCService.dkO, new ShareDialogTodoReportData(str, str2, str3, i2, i3, i4), e.class);
    }
}
