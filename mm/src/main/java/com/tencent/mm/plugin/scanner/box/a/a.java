package com.tencent.mm.plugin.scanner.box.a;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.plugin.scanner.box.a.a.b;
import com.tencent.mm.plugin.scanner.e.a;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/scanner/box/jsapi/JsApiCollect;", "Lcom/tencent/mm/plugin/scanner/box/jsapi/base/ScanBaseJsApi;", "()V", "TAG", "", "funcName", "getFuncName", "()Ljava/lang/String;", "doFav", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "fillTextEventInfo", "", "favEvent", "Lcom/tencent/mm/autogen/events/DoFavoriteEvent;", "text", "sourceType", "", "handleMsg", "plugin-scan_release"})
public final class a extends b {
    public static final a CDA = new a();
    private static final String edq = edq;

    static {
        AppMethodBeat.i(240342);
        AppMethodBeat.o(240342);
    }

    private a() {
    }

    @Override // com.tencent.mm.plugin.webview.d.j
    public final String ePz() {
        return edq;
    }

    @Override // com.tencent.mm.plugin.webview.d.j
    public final boolean a(f fVar, n nVar) {
        String str;
        String str2;
        String str3;
        anh gui;
        String str4;
        AppMethodBeat.i(240341);
        p.h(fVar, "env");
        p.h(nVar, "msg");
        String str5 = (String) nVar.params.get("sessionId");
        if (str5 == null) {
            str = "";
        } else {
            str = str5;
        }
        String str6 = (String) nVar.params.get("content");
        if (str6 == null) {
            str2 = "";
        } else {
            str2 = str6;
        }
        Log.i("MicroMsg.JsApiCollect", "ScanJsApi-Call:collect sessionId: %s, content: %s", str, str2);
        if (str2.length() == 0) {
            Log.e("MicroMsg.JsApiCollect", "ScanJsApi-Call collect content is empty");
        } else {
            com.tencent.mm.plugin.scanner.e.a aVar = com.tencent.mm.plugin.scanner.e.a.CHU;
            a.C1669a aMF = com.tencent.mm.plugin.scanner.e.a.aMF(str);
            cz czVar = new cz();
            Log.d("MicroMsg.JsApiCollect", "fillTextEventInfo text: %s, sourceType %d", str2, 27);
            anb anb = new anb();
            anh anh = new anh();
            anh.ajm(27);
            anh.MA(Util.nowMilliSecond());
            anb.a(anh);
            czVar.dFZ.desc = str2;
            czVar.dFZ.dGb = anb;
            czVar.dFZ.type = 1;
            Object[] objArr = new Object[1];
            if (aMF != null) {
                str3 = aMF.CAZ;
            } else {
                str3 = null;
            }
            objArr[0] = str3;
            Log.v("MicroMsg.JsApiCollect", "ScanJsApi-Call:collect fromUser: %s", objArr);
            anb anb2 = czVar.dFZ.dGb;
            if (!(anb2 == null || (gui = anb2.gui()) == null)) {
                if (aMF == null || (str4 = aMF.CAZ) == null) {
                    str4 = "";
                }
                gui.bhf(str4);
            }
            cz.a aVar2 = czVar.dFZ;
            Context context = fVar.context;
            if (context == null) {
                t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(240341);
                throw tVar;
            }
            aVar2.activity = (Activity) context;
            czVar.dFZ.dGi = false;
            czVar.dFZ.dGf = 43;
            EventCenter.instance.publish(czVar);
            if (Iu(System.currentTimeMillis())) {
                if (czVar.dGa.ret == 0) {
                    u.cG(fVar.context, fVar.context.getString(R.string.caf));
                } else {
                    u.cH(fVar.context, fVar.context.getString(R.string.gbj));
                }
            }
        }
        fVar.IQZ.h(nVar.ISe, nVar.mhO + ":ok", null);
        AppMethodBeat.o(240341);
        return true;
    }
}
