package com.tencent.xweb.xwalk.updater;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.util.h;
import com.tencent.xweb.xwalk.updater.a;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;

public final class i extends XWebCoreScheduler {
    static i SJx;

    public static XWebCoreScheduler hvV() {
        AppMethodBeat.i(207373);
        if (SJx == null) {
            SJx = new i();
        }
        i iVar = SJx;
        AppMethodBeat.o(207373);
        return iVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.xweb.xwalk.updater.Scheduler, com.tencent.xweb.xwalk.updater.XWebCoreScheduler
    public final boolean hvA() {
        return false;
    }

    @Override // com.tencent.xweb.xwalk.updater.Scheduler, com.tencent.xweb.xwalk.updater.XWebCoreScheduler
    public final String hvc() {
        return "XWebCorePredown";
    }

    @Override // com.tencent.xweb.xwalk.updater.XWebCoreScheduler
    public final c a(a.b bVar) {
        c cVar;
        AppMethodBeat.i(207374);
        if (bVar != null) {
            String nS = com.tencent.xweb.a.nS("pre_down_abi", "tools");
            XWalkInitializer.addXWalkInitializeLog(this.TAG, "predown load abi is ".concat(String.valueOf(nS)));
            if (TextUtils.isEmpty(nS) || nS.equalsIgnoreCase(XWalkEnvironment.getRuntimeAbi())) {
                cVar = null;
            } else {
                c a2 = d.a(bVar, nS);
                if (a2 != null) {
                    h.s(577, 240, 1);
                }
                cVar = a2;
            }
            boolean z = false;
            if (cVar != null) {
                XWalkInitializer.addXWalkInitializeLog(this.TAG, "use pre down load abi schedule:" + cVar.version);
                z = true;
            }
            c d2 = d(cVar);
            if (z && d2 == cVar) {
                if (XWalkEnvironment.RUNTIME_ABI_ARM32_STR.equalsIgnoreCase(cVar.strAbi)) {
                    h.s(577, 236, 1);
                } else if (XWalkEnvironment.RUNTIME_ABI_ARM64_STR.equalsIgnoreCase(cVar.strAbi)) {
                    h.s(577, 237, 1);
                }
            }
            AppMethodBeat.o(207374);
            return d2;
        }
        AppMethodBeat.o(207374);
        return null;
    }
}
