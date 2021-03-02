package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.content.Intent;
import com.tencent.luggage.h.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.br.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.protocal.protobuf.fhr;
import com.tencent.mm.protocal.protobuf.fhs;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.t;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0003J%\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiSendRedCoverAppMsg;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "()V", "REQUEST_CODE", "", "getREQUEST_CODE", "()I", "TAG", "", "getTAG", "()Ljava/lang/String;", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "Companion", "plugin-appbrand-integration_release"})
public final class di extends d<k> {
    @Deprecated
    public static final a Atw = new a((byte) 0);
    public static final int CTRL_INDEX = 990;
    public static final String NAME = "sendRedCoverAppMsg";
    final int REQUEST_CODE = com.tencent.luggage.sdk.g.a.aK(this);
    final String TAG = "MicroMsg.JsApiSendRedCoverAppMsg";

    static {
        AppMethodBeat.i(261646);
        AppMethodBeat.o(261646);
    }

    public di() {
        AppMethodBeat.i(261645);
        AppMethodBeat.o(261645);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(k kVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(261644);
        k kVar2 = kVar;
        if (kVar2 == null) {
            p.hyc();
        }
        AppBrandRuntime runtime = kVar2.getRuntime();
        p.g(runtime, "env!!.runtime");
        Activity context = runtime.getContext();
        if (context == null) {
            kVar2.i(i2, Zf("fail:internal error invalid android context"));
            Log.e(this.TAG, "mmActivity is null, invoke fail!");
            AppMethodBeat.o(261644);
            return;
        }
        z.f fVar = new z.f();
        fVar.SYG = jSONObject != null ? (T) jSONObject.optString("receiveuri") : null;
        Log.i(this.TAG, "receive uri: " + ((String) fVar.SYG));
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", false);
        intent.putExtra("mutil_select_is_ret", false);
        intent.putExtra("scene_from", 12);
        f.aK(context).b(new b(this, fVar, kVar2, i2));
        c.c(context, ".ui.transmit.SelectConversationUI", intent, this.REQUEST_CODE);
        AppMethodBeat.o(261644);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiSendRedCoverAppMsg$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "plugin-appbrand-integration_release"})
    static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/appbrand/jsapi/JsApiSendRedCoverAppMsg$invoke$1", "Lcom/tencent/luggage/util/LuggageActivityHelper$ActivityResultInterceptCallback;", "onResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "plugin-appbrand-integration_release"})
    public static final class b implements f.c {
        final /* synthetic */ di Atx;
        final /* synthetic */ z.f ECs;
        final /* synthetic */ int lyo;
        final /* synthetic */ k nxT;

        b(di diVar, z.f fVar, k kVar, int i2) {
            this.Atx = diVar;
            this.ECs = fVar;
            this.nxT = kVar;
            this.lyo = i2;
        }

        @Override // com.tencent.luggage.h.f.c
        public final boolean c(int i2, int i3, Intent intent) {
            AppMethodBeat.i(261643);
            if (i2 != this.Atx.REQUEST_CODE) {
                AppMethodBeat.o(261643);
                return false;
            }
            if (i3 != -1) {
                this.nxT.i(this.lyo, this.Atx.Zf("fail:cancel"));
            } else if (intent != null) {
                fhr fhr = new fhr();
                fhr.Vkj = this.ECs.SYG;
                fhr.Vkk = intent.getStringExtra("Select_Conv_User");
                Log.i(this.Atx.TAG, "do send redcover appmsg: " + ((String) this.ECs.SYG) + ", " + fhr.Vkk);
                d.a aVar = new d.a();
                aVar.sG(6446);
                aVar.MB("/cgi-bin/micromsg-bin/sendsharecovermsg");
                aVar.c(fhr);
                aVar.d(new fhs());
                IPCRunCgi.a(aVar.aXF(), new a(this, intent));
            }
            AppMethodBeat.o(261643);
            return true;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/appbrand/jsapi/JsApiSendRedCoverAppMsg$invoke$1$onResult$1$1", "Lcom/tencent/mm/ipcinvoker/wx_extension/IPCRunCgi$ICGICallback;", "callback", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "plugin-appbrand-integration_release"})
        public static final class a implements IPCRunCgi.a {
            final /* synthetic */ b ECt;
            final /* synthetic */ Intent ECu;

            a(b bVar, Intent intent) {
                this.ECt = bVar;
                this.ECu = intent;
            }

            @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
            public final void a(int i2, int i3, String str, d dVar) {
                AppMethodBeat.i(261642);
                Log.i(this.ECt.Atx.TAG, "sendRedCoverAppMsg errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                if (i2 == 0 && i3 == 0) {
                    if ((dVar != null ? dVar.aYK() : null) instanceof fhs) {
                        com.tencent.mm.bw.a aYK = dVar.aYK();
                        if (aYK == null) {
                            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.SendShareCoverMsgResp");
                            AppMethodBeat.o(261642);
                            throw tVar;
                        }
                        fhs fhs = (fhs) aYK;
                        Log.i(this.ECt.Atx.TAG, "send result: " + fhs.dDN);
                        if (fhs.dDN == 0) {
                            this.ECt.nxT.i(this.ECt.lyo, this.ECt.Atx.Zf("ok"));
                            AppMethodBeat.o(261642);
                            return;
                        }
                        this.ECt.nxT.i(this.ECt.lyo, this.ECt.Atx.Zf("fail:send fail"));
                        AppMethodBeat.o(261642);
                        return;
                    }
                } else {
                    Log.e(this.ECt.Atx.TAG, "send error");
                    this.ECt.nxT.i(this.ECt.lyo, this.ECt.Atx.Zf("fail:send error"));
                }
                AppMethodBeat.o(261642);
            }
        }
    }
}
