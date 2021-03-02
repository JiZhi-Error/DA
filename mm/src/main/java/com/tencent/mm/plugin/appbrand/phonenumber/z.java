package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.HashMap;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u0004J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u0004J\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u0004J\u000e\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u0004J\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0\fj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r`\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReporter;", "", "()V", "TAG", "", "mmKv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getMmKv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmKv$delegate", "Lkotlin/Lazy;", "sMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;", "Lkotlin/collections/HashMap;", "get", "appId", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "", "resotre", "save", "uninit", "luggage-wechat-full-sdk_release"})
public final class z {
    private static final HashMap<String, y> nBe = new HashMap<>();
    private static final f nBf = g.ah(a.nBh);
    public static final z nBg = new z();

    private static MultiProcessMMKV bTA() {
        AppMethodBeat.i(169651);
        MultiProcessMMKV multiProcessMMKV = (MultiProcessMMKV) nBf.getValue();
        AppMethodBeat.o(169651);
        return multiProcessMMKV;
    }

    static {
        AppMethodBeat.i(169650);
        AppMethodBeat.o(169650);
    }

    private z() {
    }

    public final synchronized void init(String str) {
        AppMethodBeat.i(169652);
        p.h(str, "appId");
        nBe.put(str, new y((byte) 0));
        AppMethodBeat.o(169652);
    }

    public final synchronized void aev(String str) {
        AppMethodBeat.i(169653);
        p.h(str, "appId");
        y aex = aex(str);
        if (aex != null) {
            bTA().putString(str, aex.toString()).commit();
        }
        AppMethodBeat.o(169653);
    }

    public final synchronized void aew(String str) {
        AppMethodBeat.i(169654);
        p.h(str, "appId");
        String string = bTA().getString(str, "");
        if (string == null) {
            string = "{}";
        }
        p.g(string, "mmKv.getString(appId, \"\") ?: \"{}\"");
        if (string.length() > 0) {
            nBe.put(str, new y(string));
        }
        AppMethodBeat.o(169654);
    }

    public final synchronized y aex(String str) {
        y yVar;
        AppMethodBeat.i(169655);
        p.h(str, "appId");
        yVar = nBe.get(str);
        AppMethodBeat.o(169655);
        return yVar;
    }

    public final synchronized void aey(String str) {
        AppMethodBeat.i(169656);
        p.h(str, "appId");
        StringBuilder sb = new StringBuilder("report ");
        y aex = aex(str);
        Log.v("MicroMsg.PhoneNumberReporter", sb.append(aex != null ? aex.toString() : null).toString());
        nBe.remove(str);
        bTA().remove(str).commit();
        AppMethodBeat.o(169656);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "invoke"})
    static final class a extends q implements kotlin.g.a.a<MultiProcessMMKV> {
        public static final a nBh = new a();

        static {
            AppMethodBeat.i(169649);
            AppMethodBeat.o(169649);
        }

        a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ MultiProcessMMKV invoke() {
            AppMethodBeat.i(169648);
            MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("MicroMsg.PhoneNumberReporter");
            AppMethodBeat.o(169648);
            return mmkv;
        }
    }
}
