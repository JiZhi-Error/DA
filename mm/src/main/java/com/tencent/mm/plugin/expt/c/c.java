package com.tencent.mm.plugin.expt.c;

import android.telephony.PhoneStateListener;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.xt;
import com.tencent.mm.sdk.event.EventCenter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/expt/biz/TelePmMonitor;", "", "()V", "Companion", "plugin-expt_release"})
public final class c {
    private static final HashMap<String, List<Pair<String, String>>> sxo = new HashMap<>();
    private static final b sxp = new b();
    public static final a sxq = new a((byte) 0);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000/\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\rH\u0007J\b\u0010\u000e\u001a\u00020\rH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0007R,\u0010\b\u001a \u0012\u0004\u0012\u00020\u0004\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000b0\n0\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/expt/biz/TelePmMonitor$Companion;", "", "()V", "TAG", "", "mTelePmListener", "com/tencent/mm/plugin/expt/biz/TelePmMonitor$Companion$mTelePmListener$1", "Lcom/tencent/mm/plugin/expt/biz/TelePmMonitor$Companion$mTelePmListener$1;", "telePmMethodMap", "Ljava/util/HashMap;", "", "Landroid/util/Pair;", "monitor", "", "unmonitor", "plugin-expt_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(220736);
        AppMethodBeat.o(220736);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J[\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0010\u0010\f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000b\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u000eJN\u0010\u000f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\u0011"}, hxF = {"com/tencent/mm/plugin/expt/biz/TelePmMonitor$Companion$mTelePmListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodExecListener;", "runOnEnter", "", "innerClassName", "", "innerMethodName", "innerMethodDesc", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
    public static final class b implements com.tencent.mm.hellhoundlib.a.b {
        b() {
        }

        @Override // com.tencent.mm.hellhoundlib.a.b
        public final void c(String str, String str2, String str3, String str4, Object obj, Object[] objArr) {
            AppMethodBeat.i(220734);
            if (objArr != null && objArr.length >= 2) {
                xt xtVar = new xt();
                xt.a aVar = xtVar.eeb;
                Object obj2 = objArr[0];
                if (!(obj2 instanceof PhoneStateListener)) {
                    obj2 = null;
                }
                PhoneStateListener phoneStateListener = (PhoneStateListener) obj2;
                if (phoneStateListener == null) {
                    phoneStateListener = null;
                }
                aVar.eec = phoneStateListener;
                xt.a aVar2 = xtVar.eeb;
                Object obj3 = objArr[1];
                if (!(obj3 instanceof Integer)) {
                    obj3 = null;
                }
                Integer num = (Integer) obj3;
                aVar2.eed = num != null ? num.intValue() : -1;
                xtVar.eeb.action = 0;
                EventCenter.instance.publish(xtVar);
            }
            AppMethodBeat.o(220734);
        }

        @Override // com.tencent.mm.hellhoundlib.a.b
        public final void a(String str, String str2, String str3, Object obj) {
            AppMethodBeat.i(220735);
            xt xtVar = new xt();
            xtVar.eeb.action = 1;
            EventCenter.instance.publish(xtVar);
            AppMethodBeat.o(220735);
        }
    }

    public static final void cMH() {
        AppMethodBeat.i(220737);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Pair.create("listen", "(Landroid/telephony/PhoneStateListener;I)V"));
        sxo.put("android/telephony/TelephonyManager", arrayList);
        com.tencent.mm.hellhoundlib.a.axP();
        com.tencent.mm.hellhoundlib.a.a(sxo, sxp);
        AppMethodBeat.o(220737);
    }
}
