package com.tencent.xweb.xwalk;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.a;
import com.tencent.xweb.internal.a;
import com.tencent.xweb.xwalk.updater.Scheduler;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkUpdater;

public final class a {
    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static synchronized a.C2230a eM(Object obj) {
        a.C2230a aVar;
        String str;
        boolean z = true;
        synchronized (a.class) {
            AppMethodBeat.i(154150);
            aVar = new a.C2230a();
            if (obj != null && (obj instanceof a.C2231a)) {
                a.C2231a aVar2 = (a.C2231a) obj;
                String str2 = aVar2.SCF;
                String str3 = aVar2.SCG;
                if (aVar2.SCF.equals("executeCommand")) {
                    String[] brL = com.tencent.xweb.a.brL(aVar2.SCG);
                    if (brL == null || brL.length < 2) {
                        AppMethodBeat.o(154150);
                    } else {
                        str2 = brL[0];
                        str = brL[1];
                    }
                } else {
                    str = str3;
                }
                char c2 = 65535;
                switch (str2.hashCode()) {
                    case -1436151804:
                        if (str2.equals("clearSchedule")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case -844092179:
                        if (str2.equals("fix_dex")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case -638079348:
                        if (str2.equals("cStrClearInstallEmbedVersionRecord")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 1108642905:
                        if (str2.equals("revertToVersion")) {
                            c2 = 0;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        aVar.SyJ = true;
                        try {
                            p.aX(XWalkEnvironment.getApplicationContext(), Integer.parseInt(str));
                            AppMethodBeat.o(154150);
                            break;
                        } catch (Exception e2) {
                            Log.e("ConfigCmdProc", "parse revertapk cmdvalue to int failed , value is ".concat(String.valueOf(str)));
                            AppMethodBeat.o(154150);
                            break;
                        }
                    case 1:
                        aVar.SyJ = true;
                        if (p.hva()) {
                        }
                        AppMethodBeat.o(154150);
                        break;
                    case 2:
                        aVar.SyJ = true;
                        XWalkUpdater.clearLastTryEmebedVersion();
                        AppMethodBeat.o(154150);
                        break;
                    case 3:
                        Log.i("ConfigCmdProc", "got command : ".concat(String.valueOf(str2)));
                        String nS = com.tencent.xweb.a.nS("clearSchedule", "tools");
                        if (TextUtils.isEmpty(str) || str.equals(nS)) {
                            z = false;
                        } else {
                            Log.i("ConfigCmdProc", "this command value changed from " + nS + " to " + str);
                        }
                        if (z) {
                            Scheduler.Ev(false).hvw();
                            Scheduler.Ev(true).hvw();
                        }
                        AppMethodBeat.o(154150);
                        break;
                    default:
                        AppMethodBeat.o(154150);
                        break;
                }
            } else {
                AppMethodBeat.o(154150);
            }
        }
        return aVar;
    }
}
