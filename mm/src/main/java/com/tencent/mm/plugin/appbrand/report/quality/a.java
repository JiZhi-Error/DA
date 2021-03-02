package com.tencent.mm.plugin.appbrand.report.quality;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.mf;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.BitSet;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/report/quality/AppBrandQualityFlagsReport;", "", "()V", "reportFlags", "", "instanceId", "", "Companion", "plugin-appbrand-integration_release"})
public final class a {
    private static final BitSet nKm;
    public static final C0792a nKn = new C0792a((byte) 0);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/report/quality/AppBrandQualityFlagsReport$Companion;", "", "()V", "TAG", "", "flags", "Ljava/util/BitSet;", "getFlags", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.report.quality.a$a  reason: collision with other inner class name */
    public static final class C0792a {
        private C0792a() {
        }

        public /* synthetic */ C0792a(byte b2) {
            this();
        }

        public static String getFlags() {
            AppMethodBeat.i(229310);
            org.apache.commons.b.c.a aVar = new org.apache.commons.b.c.a();
            byte[] byteArray = a.nKm.toByteArray();
            p.g(byteArray, "flags.toByteArray()");
            for (byte b2 : byteArray) {
                String valueOf = String.valueOf((int) b2);
                if (valueOf.length() == 0) {
                    valueOf = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                }
                aVar.bvo(valueOf);
            }
            if (aVar.isEmpty()) {
                AppMethodBeat.o(229310);
                return AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            String aVar2 = aVar.toString();
            p.g(aVar2, "sb.toString()");
            AppMethodBeat.o(229310);
            return aVar2;
        }
    }

    static {
        AppMethodBeat.i(229312);
        BitSet bitSet = new BitSet();
        nKm = bitSet;
        bitSet.set(0, com.tencent.mm.plugin.appbrand.ui.p.bXv());
        nKm.set(1, com.tencent.mm.plugin.appbrand.ui.p.bXu());
        AppMethodBeat.o(229312);
    }

    public static void aeT(String str) {
        AppMethodBeat.i(229311);
        p.h(str, "instanceId");
        mf mfVar = new mf();
        mfVar.zu(C0792a.getFlags());
        mfVar.zt(str);
        Log.d("MicroMsg.AppBrandQualityFlagsReport", "reportFlags: instanceId=" + str + ",flags=" + mfVar.getFlags());
        mfVar.bfK();
        AppMethodBeat.o(229311);
    }
}
