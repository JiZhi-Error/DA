package com.tencent.mm.plugin.zero.tasks;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.wcdb.support.Log;
import java.util.HashSet;

public final class a extends com.tencent.mm.kernel.a.c.a {
    @Override // com.tencent.mm.kernel.a.c.b, com.tencent.mm.kernel.a.c.a
    public final String name() {
        return "boot-db-prepare";
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public final void execute(g gVar) {
        AppMethodBeat.i(133029);
        if (!j.Ee("wcdb")) {
            getClass().getClassLoader();
            j.Ed("wcdb");
        }
        Log.setLogger(new Log.LogCallback() {
            /* class com.tencent.mm.plugin.zero.tasks.a.AnonymousClass1 */
            private final HashSet<String> JSg = new HashSet<>();

            {
                AppMethodBeat.i(133027);
                AppMethodBeat.o(133027);
            }

            @Override // com.tencent.wcdb.support.Log.LogCallback
            public final void println(int i2, String str, String str2) {
                boolean add;
                AppMethodBeat.i(133028);
                Log.LogImp impl = com.tencent.mm.sdk.platformtools.Log.getImpl();
                int myPid = Process.myPid();
                int myTid = Process.myTid();
                switch (i2) {
                    case 2:
                        impl.logV(0, str, "", "", 0, myPid, (long) myTid, (long) myPid, str2);
                        AppMethodBeat.o(133028);
                        return;
                    case 3:
                        impl.logD(0, str, "", "", 0, myPid, (long) myTid, (long) myPid, str2);
                        AppMethodBeat.o(133028);
                        return;
                    case 4:
                        impl.logI(0, str, "", "", 0, myPid, (long) myTid, (long) myPid, str2);
                        AppMethodBeat.o(133028);
                        return;
                    case 5:
                        impl.logW(0, str, "", "", 0, myPid, (long) myTid, (long) myPid, str2);
                        if (str.equals("WCDB.SQLite") && str2.startsWith("[SQLite ErrCode: 284] automatic index on ")) {
                            String substring = str2.substring(41);
                            synchronized (this.JSg) {
                                try {
                                    add = this.JSg.add(substring);
                                } finally {
                                    AppMethodBeat.o(133028);
                                }
                            }
                            if (!add) {
                                try {
                                    e.INSTANCE.e("DBAutoIndex", substring, null);
                                    AppMethodBeat.o(133028);
                                    return;
                                } catch (Exception e2) {
                                    com.tencent.mm.sdk.platformtools.Log.e("DBLogger", "Cannot report automatic index: " + e2.getMessage());
                                }
                            }
                        }
                        return;
                    case 6:
                        impl.logE(0, str, "", "", 0, myPid, (long) myTid, (long) myPid, str2);
                        AppMethodBeat.o(133028);
                        return;
                    case 7:
                        impl.logF(0, str, "", "", 0, myPid, (long) myTid, (long) myPid, str2);
                        AppMethodBeat.o(133028);
                        return;
                    default:
                        AppMethodBeat.o(133028);
                        return;
                }
            }
        });
        AppMethodBeat.o(133029);
    }
}
