package com.tencent.mm.plugin.websearch.widget;

import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.hr;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;

public final class d {
    private static final d IIf = new d();

    static {
        AppMethodBeat.i(116638);
        AppMethodBeat.o(116638);
    }

    public static d fYU() {
        return IIf;
    }

    public static boolean a(WidgetData widgetData) {
        AppMethodBeat.i(116632);
        Bundle bundle = new Bundle();
        bundle.putInt(NativeProtocol.WEB_DIALOG_ACTION, 1);
        bundle.putParcelable("data", widgetData);
        Bundle bundle2 = (Bundle) h.a(MainProcessIPCService.dkO, bundle, a.class);
        if (bundle2 != null) {
            boolean z = bundle2.getBoolean("result");
            AppMethodBeat.o(116632);
            return z;
        }
        AppMethodBeat.o(116632);
        return false;
    }

    public static void b(WidgetData widgetData, String str) {
        AppMethodBeat.i(116633);
        Bundle bundle = new Bundle();
        bundle.putInt(NativeProtocol.WEB_DIALOG_ACTION, 3);
        bundle.putParcelable("data", widgetData);
        bundle.putString("err", str);
        h.a(MainProcessIPCService.dkO, bundle, a.class, null);
        AppMethodBeat.o(116633);
    }

    public static void c(WidgetData widgetData, String str) {
        AppMethodBeat.i(116634);
        Bundle bundle = new Bundle();
        bundle.putInt(NativeProtocol.WEB_DIALOG_ACTION, 7);
        bundle.putParcelable("data", widgetData);
        bundle.putString("err", str);
        h.a(MainProcessIPCService.dkO, bundle, a.class, null);
        AppMethodBeat.o(116634);
    }

    public static void b(WidgetData widgetData) {
        AppMethodBeat.i(116635);
        Bundle bundle = new Bundle();
        bundle.putInt(NativeProtocol.WEB_DIALOG_ACTION, 4);
        bundle.putParcelable("data", widgetData);
        h.a(MainProcessIPCService.dkO, bundle, a.class, null);
        AppMethodBeat.o(116635);
    }

    public static void c(WidgetData widgetData) {
        AppMethodBeat.i(116636);
        if (widgetData == null) {
            AppMethodBeat.o(116636);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(NativeProtocol.WEB_DIALOG_ACTION, 5);
        bundle.putParcelable("data", widgetData);
        h.a(MainProcessIPCService.dkO, bundle, a.class, null);
        AppMethodBeat.o(116636);
    }

    public static void d(WidgetData widgetData) {
        AppMethodBeat.i(116637);
        Log.i("WidgetSafeModeIpcImpl", "onDisplaySucc");
        Bundle bundle = new Bundle();
        bundle.putInt(NativeProtocol.WEB_DIALOG_ACTION, 6);
        bundle.putParcelable("data", widgetData);
        h.a(MainProcessIPCService.dkO, bundle, a.class, null);
        AppMethodBeat.o(116637);
    }

    static class a implements b<Bundle, Bundle>, k<Bundle, Bundle> {
        private a() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ Bundle invoke(Bundle bundle) {
            boolean z;
            AppMethodBeat.i(116630);
            Bundle bundle2 = bundle;
            Bundle bundle3 = new Bundle();
            switch (bundle2.getInt(NativeProtocol.WEB_DIALOG_ACTION)) {
                case 1:
                    WidgetData widgetData = (WidgetData) bundle2.getParcelable("data");
                    e fYV = e.fYV();
                    fYV.fYW();
                    if (fYV.VC) {
                        com.tencent.mm.plugin.websearch.widget.a.a aVar = new com.tencent.mm.plugin.websearch.widget.a.a();
                        aVar.field_appid = widgetData.IFG.iIA;
                        if (fYV.IIi.get(aVar, new String[0])) {
                            Log.i("WidgetSafeModeProxyImpl", "safeModeRecord appid %s, proc crash count %d, js exception count %d", aVar.field_appid, Integer.valueOf(aVar.field_crashCount), Integer.valueOf(aVar.field_jsExceptionCount));
                            if (System.currentTimeMillis() - aVar.field_beginTimestamp > 172800000) {
                                fYV.IIi.delete(aVar, new String[0]);
                            } else if (aVar.field_pkgVersion == widgetData.IFG.version) {
                                if (aVar.field_jsExceptionCount >= 5) {
                                    Log.i("WidgetSafeModeProxyImpl", "local forbidden %s", widgetData.toString());
                                    hr vt = new hr().vt(widgetData.IFG.iIA);
                                    vt.eBS = (long) widgetData.IFG.serviceType;
                                    vt.eMi = 22;
                                    vt.eMj = System.currentTimeMillis();
                                    vt.vu(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bfK();
                                    v.pl(32);
                                    z = false;
                                    bundle3.putBoolean("result", z);
                                    break;
                                }
                            } else {
                                fYV.IIi.delete(aVar, new String[0]);
                            }
                        }
                    }
                    z = true;
                    bundle3.putBoolean("result", z);
            }
            AppMethodBeat.o(116630);
            return bundle3;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(Bundle bundle, com.tencent.mm.ipcinvoker.d<Bundle> dVar) {
            AppMethodBeat.i(116631);
            Bundle bundle2 = bundle;
            switch (bundle2.getInt(NativeProtocol.WEB_DIALOG_ACTION)) {
                case 2:
                    e.fYV();
                    AppMethodBeat.o(116631);
                    return;
                case 3:
                    e.fYV().b((WidgetData) bundle2.getParcelable("data"), bundle2.getString("err"));
                    AppMethodBeat.o(116631);
                    return;
                case 4:
                    e.fYV().IIh.add((WidgetData) bundle2.getParcelable("data"));
                    AppMethodBeat.o(116631);
                    return;
                case 5:
                    e.fYV().IIh.remove((WidgetData) bundle2.getParcelable("data"));
                    AppMethodBeat.o(116631);
                    return;
                case 6:
                    e fYV = e.fYV();
                    com.tencent.mm.plugin.websearch.widget.a.a aVar = new com.tencent.mm.plugin.websearch.widget.a.a();
                    aVar.field_appid = ((WidgetData) bundle2.getParcelable("data")).IFG.iIA;
                    fYV.IIi.delete(aVar, new String[0]);
                    AppMethodBeat.o(116631);
                    return;
                case 7:
                    e.fYV().b((WidgetData) bundle2.getParcelable("data"), bundle2.getString("err"));
                    break;
            }
            AppMethodBeat.o(116631);
        }
    }
}
