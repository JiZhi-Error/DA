package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.protocal.protobuf.exx;
import com.tencent.mm.protocal.protobuf.exy;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class f {
    private static f llY = new f();
    Map<String, b> llZ = new ConcurrentHashMap();
    private IPCRunCgi.a lma = new IPCRunCgi.a() {
        /* class com.tencent.mm.plugin.appbrand.dynamic.f.AnonymousClass1 */

        @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
        public final void a(int i2, int i3, String str, d dVar) {
            AppMethodBeat.i(121163);
            if (!(i2 == 0 && i3 == 0)) {
                Log.e("MicroMsg.DynamicPageViewStateMonitor", "widget alarm cgi fail, msg[%s]", str);
            }
            AppMethodBeat.o(121163);
        }
    };

    public f() {
        AppMethodBeat.i(121166);
        AppMethodBeat.o(121166);
    }

    static /* synthetic */ String access$000(String str) {
        AppMethodBeat.i(121171);
        String Ym = Ym(str);
        AppMethodBeat.o(121171);
        return Ym;
    }

    public static class b {
        String appId = "";
        String lmc = "";
        LinkedList<Integer> lmd = new LinkedList<>();
        String query = "";
        int serviceType = 0;

        public b(String str, String str2, int i2, String str3) {
            AppMethodBeat.i(121165);
            this.lmc = str;
            this.appId = str2;
            this.serviceType = i2;
            this.query = str3;
            AppMethodBeat.o(121165);
        }
    }

    static {
        AppMethodBeat.i(121172);
        AppMethodBeat.o(121172);
    }

    public static f bBJ() {
        return llY;
    }

    public final boolean Yk(String str) {
        AppMethodBeat.i(176167);
        if (!this.llZ.containsKey(str)) {
            Log.w("MicroMsg.DynamicPageViewStateMonitor", "OnDettach but no keylist found, widgetId[%s]", str);
            AppMethodBeat.o(176167);
            return false;
        }
        b bVar = this.llZ.get(str);
        String str2 = "";
        try {
            str2 = bVar.lmd.toString();
        } catch (NullPointerException e2) {
        }
        Log.i("MicroMsg.DynamicPageViewStateMonitor", "OnDettach ready to report keyList[%s]", str2);
        if (bVar.lmd.size() <= 0) {
            AppMethodBeat.o(176167);
            return true;
        }
        d.a aVar = new d.a();
        aVar.funcId = 2653;
        aVar.uri = "/cgi-bin/mmux-bin/wxaapp/wxaapp_widgetalarm";
        exx exx = new exx();
        exx.dNI = u.Lv(str);
        exx.id = bVar.serviceType;
        exx.Nvf = bVar.lmd;
        exx.query = bVar.query;
        aVar.iLN = exx;
        aVar.iLO = new exy();
        IPCRunCgi.a(aVar.aXF(), this.lma);
        AppMethodBeat.o(176167);
        return true;
    }

    public final boolean bF(String str, int i2) {
        AppMethodBeat.i(121167);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(121167);
            return false;
        } else if (!this.llZ.containsKey(str)) {
            Log.w("MicroMsg.DynamicPageViewStateMonitor", "no keyList exists, widgetId[%s]", str);
            AppMethodBeat.o(121167);
            return false;
        } else {
            switch (i2) {
                case 2103:
                    j.bBN().P(str, 628, 9);
                    break;
            }
            boolean add = this.llZ.get(str).lmd.add(Integer.valueOf(i2));
            AppMethodBeat.o(121167);
            return add;
        }
    }

    public static class a implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(Bundle bundle, com.tencent.mm.ipcinvoker.d<Bundle> dVar) {
            AppMethodBeat.i(121164);
            Bundle bundle2 = bundle;
            if (bundle2.getBoolean("isOpenWeappFial", false)) {
                f.bBJ().bF(f.access$000(bundle2.getString("sceneNote")), bundle2.getInt("widgetState") + 3000);
                AppMethodBeat.o(121164);
                return;
            }
            f.bBJ().bF(bundle2.getString("id"), bundle2.getInt("widgetState"));
            AppMethodBeat.o(121164);
        }
    }

    public static void Yl(String str) {
        AppMethodBeat.i(121168);
        Bundle bundle = new Bundle();
        String Ym = Ym(str);
        bundle.putString("id", Ym);
        bundle.putInt("widgetState", TXLiteAVCode.WARNING_SW_DECODER_START_FAIL);
        h.a(i.bBL().Yn(Ym), bundle, a.class, null);
        AppMethodBeat.o(121168);
    }

    public static void o(int i2, String str, String str2) {
        AppMethodBeat.i(121169);
        Bundle bundle = new Bundle();
        bundle.putBoolean("isOpenWeappFial", true);
        bundle.putInt("widgetState", i2);
        bundle.putString("appid", str);
        bundle.putString("sceneNote", str2);
        h.a(i.bBL().Yn(Ym(str2)), bundle, a.class, null);
        AppMethodBeat.o(121169);
    }

    private static String Ym(String str) {
        AppMethodBeat.i(121170);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(121170);
            return "";
        }
        Matcher matcher = Pattern.compile(":widgetId=.*:").matcher(str);
        if (matcher.matches()) {
            String group = matcher.group();
            if (!TextUtils.isEmpty(group)) {
                String substring = group.substring(group.indexOf("=") + 1, group.lastIndexOf(":"));
                AppMethodBeat.o(121170);
                return substring;
            }
        }
        AppMethodBeat.o(121170);
        return "";
    }
}
