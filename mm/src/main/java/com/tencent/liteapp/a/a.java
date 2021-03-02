package com.tencent.liteapp.a;

import android.app.Activity;
import android.content.Context;
import com.tencent.liteapp.a;
import com.tencent.liteapp.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ext.ui.e;
import com.tencent.mm.plugin.appbrand.jsapi.h.c;
import com.tencent.mm.plugin.appbrand.jsapi.p.i;
import com.tencent.wxa.a;
import io.flutter.plugin.a.j;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002¨\u0006\u0011"}, hxF = {"Lcom/tencent/liteapp/channel/WxaLiteAppConsumer;", "Lcom/tencent/wxa/MethodCallConsumer;", "()V", "consume", "Lcom/tencent/wxa/MethodCallConsumer$Result;", "call", "Lio/flutter/plugin/common/MethodCall;", "enterFullScreen", "args", "", "exitFullScreen", "getCutOutHeight", "hasCutOut", c.NAME, "inputLocationChange", i.NAME, "Companion", "wxa_lite_app_release"})
public final class a extends com.tencent.wxa.a {
    private static final String TAG = TAG;
    public static final C0148a cqS = new C0148a((byte) 0);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/liteapp/channel/WxaLiteAppConsumer$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "wxa_lite_app_release"})
    /* renamed from: com.tencent.liteapp.a.a$a  reason: collision with other inner class name */
    public static final class C0148a {
        private C0148a() {
        }

        public /* synthetic */ C0148a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(197924);
        AppMethodBeat.o(197924);
    }

    @Override // com.tencent.wxa.a
    public final a.C2227a a(j jVar) {
        AppMethodBeat.i(197923);
        if (jVar == null) {
            p.hyc();
        }
        String str = jVar.method;
        Object obj = jVar.SxX;
        b.d(TAG, "consume method: ".concat(String.valueOf(str)), new Object[0]);
        if (str != null) {
            switch (str.hashCode()) {
                case -2027946449:
                    if (str.equals("inputLocationChange")) {
                        p.g(obj, "args");
                        com.tencent.wxa.c hrH = com.tencent.wxa.c.hrH();
                        p.g(hrH, "WxaRouter.getInstance()");
                        com.tencent.wxa.b.b hrJ = hrH.hrJ();
                        p.g(hrJ, "WxaRouter.getInstance().currentActivity");
                        Activity activity = hrJ.getActivity();
                        if (activity != null && (activity instanceof com.tencent.liteapp.ui.a) && (obj instanceof Map)) {
                            com.tencent.liteapp.ui.a aVar = (com.tencent.liteapp.ui.a) activity;
                            Object obj2 = ((Map) obj).get("offset");
                            if (obj2 == null) {
                                t tVar = new t("null cannot be cast to non-null type kotlin.Int");
                                AppMethodBeat.o(197923);
                                throw tVar;
                            }
                            aVar.hD(((Integer) obj2).intValue());
                        }
                        a.C2227a eI = eI(Boolean.TRUE);
                        p.g(eI, "consumed(true)");
                        AppMethodBeat.o(197923);
                        return eI;
                    }
                    break;
                case -1887586613:
                    if (str.equals("publishEvent")) {
                        a.C2227a eI2 = eI(Boolean.TRUE);
                        p.g(eI2, "consumed(true)");
                        AppMethodBeat.o(197923);
                        return eI2;
                    }
                    break;
                case -1242073158:
                    if (str.equals("onRenderCallback")) {
                        a.C2227a eI3 = eI(Boolean.TRUE);
                        p.g(eI3, "consumed(true)");
                        AppMethodBeat.o(197923);
                        return eI3;
                    }
                    break;
                case -983638536:
                    if (str.equals(i.NAME)) {
                        com.tencent.wxa.c hrH2 = com.tencent.wxa.c.hrH();
                        p.g(hrH2, "WxaRouter.getInstance()");
                        com.tencent.wxa.b.b hrJ2 = hrH2.hrJ();
                        p.g(hrJ2, "WxaRouter.getInstance().currentActivity");
                        Activity activity2 = hrJ2.getActivity();
                        if (activity2 != null && (activity2 instanceof com.tencent.liteapp.ui.a)) {
                            ((com.tencent.liteapp.ui.a) activity2).navigateBack();
                        }
                        a.C2227a eI4 = eI(Boolean.TRUE);
                        p.g(eI4, "consumed(true)");
                        AppMethodBeat.o(197923);
                        return eI4;
                    }
                    break;
                case -865430423:
                    if (str.equals("getCutOutHeight")) {
                        a.C0147a aVar2 = com.tencent.liteapp.a.cqJ;
                        Context appContext = a.C0147a.getAppContext();
                        a.C0147a aVar3 = com.tencent.liteapp.a.cqJ;
                        a.C2227a eI5 = eI(Double.valueOf((double) com.tencent.mm.ext.ui.c.E(appContext, e.aP(a.C0147a.getAppContext()))));
                        p.g(eI5, "consumed(result)");
                        AppMethodBeat.o(197923);
                        return eI5;
                    }
                    break;
                case -802181223:
                    if (str.equals("exitFullScreen")) {
                        p.g(obj, "args");
                        com.tencent.wxa.c hrH3 = com.tencent.wxa.c.hrH();
                        p.g(hrH3, "WxaRouter.getInstance()");
                        com.tencent.wxa.b.b hrJ3 = hrH3.hrJ();
                        p.g(hrJ3, "WxaRouter.getInstance().currentActivity");
                        Activity activity3 = hrJ3.getActivity();
                        if (activity3 != null && (activity3 instanceof com.tencent.liteapp.ui.a)) {
                            ((com.tencent.liteapp.ui.a) activity3).KC();
                        }
                        a.C2227a eI6 = eI(Boolean.TRUE);
                        p.g(eI6, "consumed(true)");
                        AppMethodBeat.o(197923);
                        return eI6;
                    }
                    break;
                case -729343770:
                    if (str.equals("hasCutOut")) {
                        com.tencent.wxa.c hrH4 = com.tencent.wxa.c.hrH();
                        p.g(hrH4, "WxaRouter.getInstance()");
                        com.tencent.wxa.b.b hrJ4 = hrH4.hrJ();
                        p.g(hrJ4, "WxaRouter.getInstance().currentActivity");
                        a.C2227a eI7 = eI(Boolean.valueOf(e.cI(hrJ4.getActivity())));
                        p.g(eI7, "consumed(result)");
                        AppMethodBeat.o(197923);
                        return eI7;
                    }
                    break;
                case 4298127:
                    if (str.equals("generateInputEventData")) {
                        a.C2227a eI8 = eI(Boolean.TRUE);
                        p.g(eI8, "consumed(true)");
                        AppMethodBeat.o(197923);
                        return eI8;
                    }
                    break;
                case 362379281:
                    if (str.equals("inputOnKeyboardValueChange")) {
                        a.C2227a eI9 = eI(Boolean.TRUE);
                        p.g(eI9, "consumed(true)");
                        AppMethodBeat.o(197923);
                        return eI9;
                    }
                    break;
                case 686611947:
                    if (str.equals("showPicker")) {
                        a.C2227a eI10 = eI(Boolean.TRUE);
                        p.g(eI10, "consumed(true)");
                        AppMethodBeat.o(197923);
                        return eI10;
                    }
                    break;
                case 837852371:
                    if (str.equals("enterFullScreen")) {
                        p.g(obj, "args");
                        com.tencent.wxa.c hrH5 = com.tencent.wxa.c.hrH();
                        p.g(hrH5, "WxaRouter.getInstance()");
                        com.tencent.wxa.b.b hrJ5 = hrH5.hrJ();
                        p.g(hrJ5, "WxaRouter.getInstance().currentActivity");
                        Activity activity4 = hrJ5.getActivity();
                        if (activity4 != null && (activity4 instanceof com.tencent.liteapp.ui.a)) {
                            ((com.tencent.liteapp.ui.a) activity4).KD();
                        }
                        a.C2227a eI11 = eI(Boolean.TRUE);
                        p.g(eI11, "consumed(true)");
                        AppMethodBeat.o(197923);
                        return eI11;
                    }
                    break;
                case 1003266075:
                    if (str.equals("getLocalFileData")) {
                        a.C2227a eI12 = eI(Boolean.TRUE);
                        p.g(eI12, "consumed(true)");
                        AppMethodBeat.o(197923);
                        return eI12;
                    }
                    break;
                case 1065964361:
                    if (str.equals(c.NAME)) {
                        com.tencent.wxa.c hrH6 = com.tencent.wxa.c.hrH();
                        p.g(hrH6, "WxaRouter.getInstance()");
                        com.tencent.wxa.b.b hrJ6 = hrH6.hrJ();
                        p.g(hrJ6, "WxaRouter.getInstance().currentActivity");
                        Activity activity5 = hrJ6.getActivity();
                        if (activity5 != null && (activity5 instanceof com.tencent.liteapp.ui.a)) {
                            ((com.tencent.liteapp.ui.a) activity5).hideKeyboard();
                        }
                        a.C2227a eI13 = eI(Boolean.TRUE);
                        p.g(eI13, "consumed(true)");
                        AppMethodBeat.o(197923);
                        return eI13;
                    }
                    break;
                case 1230183279:
                    if (str.equals("setCanOverScroll")) {
                        a.C2227a eI14 = eI(Boolean.TRUE);
                        p.g(eI14, "consumed(true)");
                        AppMethodBeat.o(197923);
                        return eI14;
                    }
                    break;
            }
        }
        a.C2227a hrG = hrG();
        p.g(hrG, "consumeSkip()");
        AppMethodBeat.o(197923);
        return hrG;
    }
}
