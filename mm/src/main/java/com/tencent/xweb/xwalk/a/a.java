package com.tencent.xweb.xwalk.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.b;
import com.tencent.xweb.xwalk.updater.Scheduler;
import com.tencent.xweb.xwalk.updater.c;
import java.util.HashMap;

public final class a {
    static HashMap<String, C2235a> SHS = new HashMap<>();

    static {
        AppMethodBeat.i(207340);
        AppMethodBeat.o(207340);
    }

    public static synchronized C2235a bsQ(String str) {
        C2235a aVar;
        synchronized (a.class) {
            AppMethodBeat.i(207339);
            if (!SHS.containsKey(str)) {
                SHS.put(str, new C2235a(str));
            }
            aVar = SHS.get(str);
            AppMethodBeat.o(207339);
        }
        return aVar;
    }

    /* renamed from: com.tencent.xweb.xwalk.a.a$a  reason: collision with other inner class name */
    public static class C2235a extends Scheduler {
        String SHT;

        public C2235a(String str) {
            AppMethodBeat.i(207334);
            this.SHT = str;
            this.TAG = hvc() + "Scheduler";
            AppMethodBeat.o(207334);
        }

        @Override // com.tencent.xweb.xwalk.updater.Scheduler
        public final boolean a(c cVar, c cVar2) {
            AppMethodBeat.i(207335);
            if (cVar.SJl != cVar2.SJl || !ok(cVar.path, cVar2.path)) {
                AppMethodBeat.o(207335);
                return false;
            }
            boolean a2 = super.a(cVar, cVar2);
            AppMethodBeat.o(207335);
            return a2;
        }

        @Override // com.tencent.xweb.xwalk.updater.Scheduler
        public final String hvc() {
            return this.SHT;
        }

        @Override // com.tencent.xweb.xwalk.updater.Scheduler
        public final int hvd() {
            return 15;
        }

        @Override // com.tencent.xweb.xwalk.updater.Scheduler
        public final String Eu(boolean z) {
            String nS;
            AppMethodBeat.i(207336);
            if (!z) {
                nS = b.nS("UPDATE_SPEED_CONFIG", "tools");
                if (TextUtils.isEmpty(nS)) {
                    nS = com.tencent.xweb.a.nS("UPDATE_SPEED_CONFIG", "tools");
                }
            } else {
                nS = b.nS("UPDATE_FORWARD_SPEED_CONFIG", "tools");
                if (TextUtils.isEmpty(nS)) {
                    nS = com.tencent.xweb.a.nS("UPDATE_FORWARD_SPEED_CONFIG", "tools");
                }
            }
            AppMethodBeat.o(207336);
            return nS;
        }

        @Override // com.tencent.xweb.xwalk.updater.Scheduler
        public final String hve() {
            AppMethodBeat.i(207337);
            String nS = b.nS("UPDATE_SCHEDULE_TIME_RANGE_BIND", "tools");
            if (TextUtils.isEmpty(nS)) {
                String hve = super.hve();
                AppMethodBeat.o(207337);
                return hve;
            }
            AppMethodBeat.o(207337);
            return nS;
        }

        @Override // com.tencent.xweb.xwalk.updater.Scheduler
        public final String hvf() {
            AppMethodBeat.i(207338);
            String nS = b.nS("FREE_FETCH_CONFIG_TIME_ZONE", "tools");
            AppMethodBeat.o(207338);
            return nS;
        }
    }
}
