package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet;
import com.tencent.mm.plugin.report.service.h;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class j {
    private static j lmh = new j();
    public Map<String, b> llZ = new ConcurrentHashMap();

    public j() {
        AppMethodBeat.i(121187);
        AppMethodBeat.o(121187);
    }

    public static class b implements com.tencent.mm.ipcinvoker.d.a {
        String appId = "";
        int dCv;
        String dDL;
        String lmc = "";
        int serviceType;

        public b() {
        }

        public b(String str, String str2, int i2, String str3, int i3) {
            this.lmc = str;
            this.appId = str2;
            this.dCv = i2;
            this.dDL = str3;
            this.serviceType = i3;
        }

        @Override // com.tencent.mm.ipcinvoker.d.a
        public final Bundle toBundle() {
            AppMethodBeat.i(121185);
            Bundle bundle = new Bundle();
            bundle.putString("widgetId", this.lmc);
            bundle.putString("appid", this.appId);
            bundle.putInt("appState", this.dCv);
            bundle.putString("reqKey", this.dDL);
            bundle.putInt("serviceType", this.serviceType);
            AppMethodBeat.o(121185);
            return bundle;
        }

        @Override // com.tencent.mm.ipcinvoker.d.a
        public final void fromBundle(Bundle bundle) {
            AppMethodBeat.i(121186);
            this.lmc = bundle.getString("widgetId");
            this.appId = bundle.getString("appid");
            this.dCv = bundle.getInt("appState");
            this.dDL = bundle.getString("reqKey");
            this.serviceType = bundle.getInt("serviceType");
            AppMethodBeat.o(121186);
        }
    }

    static {
        AppMethodBeat.i(121193);
        AppMethodBeat.o(121193);
    }

    public static j bBN() {
        return lmh;
    }

    public final void bG(String str, int i2) {
        AppMethodBeat.i(121188);
        P(Yq(str), JsApiShowImageOperateSheet.CTRL_INDEX, i2);
        AppMethodBeat.o(121188);
    }

    public final void P(String str, int i2, int i3) {
        AppMethodBeat.i(121189);
        b bVar = this.llZ.get(str);
        if (bVar != null) {
            com.tencent.mm.ipcinvoker.h.b.i("WidgetReporter_14443", "report %s, %s, %s", str, Integer.valueOf(i2), Integer.valueOf(i3));
            h.INSTANCE.a(14443, bVar.appId, 0, Integer.valueOf(bVar.dCv), 2, bVar.dDL, Integer.valueOf(i2), Integer.valueOf(i3), 0, Integer.valueOf(bVar.serviceType));
        }
        AppMethodBeat.o(121189);
    }

    public final void Yp(String str) {
        AppMethodBeat.i(121190);
        P(Yq(str), JsApiShowImageOperateSheet.CTRL_INDEX, 7);
        AppMethodBeat.o(121190);
    }

    private String Yq(String str) {
        AppMethodBeat.i(121191);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(121191);
            return "";
        }
        for (Map.Entry<String, b> entry : this.llZ.entrySet()) {
            if (entry.getValue() != null && str.equals(entry.getValue().appId)) {
                String key = entry.getKey();
                AppMethodBeat.o(121191);
                return key;
            }
        }
        AppMethodBeat.o(121191);
        return "";
    }

    public final void Yr(String str) {
        AppMethodBeat.i(121192);
        P(str, JsApiShowImageOperateSheet.CTRL_INDEX, 26);
        AppMethodBeat.o(121192);
    }

    static class a implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle> {
        private a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(Bundle bundle, d<Bundle> dVar) {
            AppMethodBeat.i(121184);
            b bVar = new b();
            bVar.fromBundle(bundle);
            j.bBN().llZ.put(bVar.lmc, bVar);
            AppMethodBeat.o(121184);
        }
    }
}
