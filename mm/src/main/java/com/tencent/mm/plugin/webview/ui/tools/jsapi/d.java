package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.rg;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.m;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/JsApiGetRedPacketDone;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "GetRedPacketDoneTask", "plugin-webview_release"})
public final class d extends com.tencent.mm.plugin.webview.d.c.a {
    private static final int CDJ = CDJ;
    public static final d JsC = new d();
    private static final String TAG = TAG;
    private static final String edq = edq;

    static {
        AppMethodBeat.i(164017);
        AppMethodBeat.o(164017);
    }

    private d() {
    }

    public static String getTAG() {
        return TAG;
    }

    @Override // com.tencent.mm.plugin.webview.d.j
    public final int ePA() {
        return CDJ;
    }

    @Override // com.tencent.mm.plugin.webview.d.j
    public final String ePz() {
        return edq;
    }

    @Override // com.tencent.mm.plugin.webview.d.j
    public final boolean a(f fVar, n nVar) {
        boolean z;
        boolean z2;
        boolean z3;
        AppMethodBeat.i(210552);
        p.h(fVar, "env");
        p.h(nVar, "msg");
        Log.i(TAG, "do get red packet done: " + nVar.params);
        if (p.j(nVar.params.get("shouldShowRedDot"), "1")) {
            z = true;
        } else {
            z = false;
        }
        if (p.j(nVar.params.get("isNeedRefresh"), "1")) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (p.j(nVar.params.get("shouldOpenSelectSkinPage"), "1")) {
            z3 = true;
        } else {
            z3 = false;
        }
        Log.i(TAG, "isNeedRefresh: " + nVar.params.get("isNeedRefresh") + ", shouldShowRedDot: " + nVar.params.get("shouldShowRedDot") + ", shouldOpenSelectSkinPage: " + z3 + ", packageId: " + nVar.params.get("packetId"));
        Bundle bundle = new Bundle();
        bundle.putBoolean("shouldShowRedDot", z);
        bundle.putBoolean("isNeedRefresh", z2);
        h.a(MainProcessIPCService.dkO, bundle, a.class);
        if (z3) {
            Intent intent = new Intent();
            Object obj = nVar.params.get("packetId");
            if (obj == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.String");
                AppMethodBeat.o(210552);
                throw tVar;
            }
            intent.putExtra("packetId", (String) obj);
            if (fVar.context instanceof MMActivity) {
                Context context = fVar.context;
                if (context == null) {
                    t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                    AppMethodBeat.o(210552);
                    throw tVar2;
                }
                ((MMActivity) context).mmSetOnActivityResultCallback(new b(fVar, nVar));
            }
            c.b(fVar.context, "luckymoney", ".ui.LuckyMoneyPickEnvelopeUI", intent, (int) m.CTRL_INDEX);
        } else {
            fVar.IQZ.h(nVar.ISe, nVar.mhO + ":ok", null);
        }
        AppMethodBeat.o(210552);
        return true;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
    static final class b implements MMActivity.a {
        final /* synthetic */ f CDE;
        final /* synthetic */ n pGr;

        b(f fVar, n nVar) {
            this.CDE = fVar;
            this.pGr = nVar;
        }

        @Override // com.tencent.mm.ui.MMActivity.a
        public final void d(int i2, int i3, Intent intent) {
            AppMethodBeat.i(210551);
            d dVar = d.JsC;
            Log.i(d.getTAG(), "on select envelope result: ".concat(String.valueOf(i3)));
            if (i2 == 789) {
                if (i3 == -1) {
                    this.CDE.IQZ.h(this.pGr.ISe, this.pGr.mhO + ":ok confirm", null);
                    AppMethodBeat.o(210551);
                    return;
                }
                this.CDE.IQZ.h(this.pGr.ISe, this.pGr.mhO + ":ok cancel", null);
            }
            AppMethodBeat.o(210551);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/JsApiGetRedPacketDone$GetRedPacketDoneTask;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Landroid/os/Bundle;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "data", "plugin-webview_release"})
    public static final class a implements k<Bundle, IPCVoid> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ IPCVoid invoke(Bundle bundle) {
            AppMethodBeat.i(164015);
            Bundle bundle2 = bundle;
            if (bundle2 != null) {
                boolean z = bundle2.getBoolean("shouldShowRedDot");
                boolean z2 = bundle2.getBoolean("isNeedRefresh");
                d dVar = d.JsC;
                Log.i(d.getTAG(), "get red packet: " + z + ", " + z2);
                ((com.tencent.mm.plugin.luckymoney.a.a) g.af(com.tencent.mm.plugin.luckymoney.a.a.class)).W(z, z2);
                rg rgVar = new rg();
                rgVar.dXW.dXX = z2;
                EventCenter.instance.publish(rgVar);
            }
            IPCVoid iPCVoid = IPCVoid.hnE;
            p.g(iPCVoid, "IPCVoid.VOID");
            AppMethodBeat.o(164015);
            return iPCVoid;
        }
    }
}
