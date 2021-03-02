package com.tencent.mm.plugin.report.service;

import android.widget.Toast;
import com.tencent.f.h;
import com.tencent.mars.smc.IDKey;
import com.tencent.mars.smc.SmcLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.report.b.a;
import com.tencent.mm.protocal.protobuf.cbi;
import com.tencent.mm.protocal.protobuf.crd;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class e {
    private static Map<Long, Long> Cyn;
    private static a Cyo = new a();
    private static int Cyp = -1;
    private static boolean Cyq = false;

    static {
        AppMethodBeat.i(143841);
        AppMethodBeat.o(143841);
    }

    public static void a(long j2, String str, boolean z, boolean z2, boolean z3) {
        AppMethodBeat.i(143834);
        if (z2) {
            try {
                SmcLogic.writeImportKvData(j2, str, z, z3);
            } catch (Exception e2) {
                Log.e("MicroMsg.KVEasyReport", "localReport :%s", Util.stackTraceToString(e2));
            }
        } else {
            try {
                SmcLogic.writeKvData(j2, str, z, z3);
            } catch (Throwable th) {
                Log.printErrStackTrace("MicroMsg.KVEasyReport", th, "", new Object[0]);
                if (d.oE(20)) {
                    SmcLogic.writeKvData(j2, str, z, z3);
                } else {
                    AppMethodBeat.o(143834);
                    throw th;
                }
            }
        }
        k.eOK();
        k.G(j2, str);
        AppMethodBeat.o(143834);
    }

    public static void a(long j2, long j3, String str, boolean z, boolean z2, boolean z3) {
        AppMethodBeat.i(143835);
        if (z2) {
            try {
                SmcLogic.writeImportKvDataWithType(j2, j3, str, z, z3);
            } catch (Exception e2) {
                Log.e("MicroMsg.KVEasyReport", "localReport :%s", Util.stackTraceToString(e2));
            }
        } else {
            try {
                SmcLogic.writeKvDataWithType(j2, j3, str, z, z3);
            } catch (Throwable th) {
                Log.printErrStackTrace("MicroMsg.KVEasyReport", th, "", new Object[0]);
                if (d.oE(20)) {
                    SmcLogic.writeKvDataWithType(j2, j3, str, z, z3);
                } else {
                    AppMethodBeat.o(143835);
                    throw th;
                }
            }
        }
        k.eOK();
        k.G(j2, str);
        AppMethodBeat.o(143835);
    }

    public static void a(long j2, byte[] bArr, boolean z, boolean z2) {
        AppMethodBeat.i(143836);
        if (z2) {
            try {
                SmcLogic.writeImportKvPbData(j2, bArr, z);
                AppMethodBeat.o(143836);
            } catch (Exception e2) {
                Log.e("MicroMsg.KVEasyReport", "localReport :%s", Util.stackTraceToString(e2));
                AppMethodBeat.o(143836);
            }
        } else {
            SmcLogic.writeKvPbData(j2, bArr, z);
            AppMethodBeat.o(143836);
        }
    }

    public static void b(long j2, long j3, long j4, boolean z) {
        int hashCode;
        int hashCode2;
        AppMethodBeat.i(143837);
        boolean z2 = z;
        long j5 = j4;
        long j6 = j3;
        long j7 = j2;
        while (true) {
            Object[] objArr = new Object[2];
            if (e.class.getClassLoader() == null) {
                hashCode = -1;
            } else {
                hashCode = e.class.getClassLoader().hashCode();
            }
            objArr[0] = Integer.valueOf(hashCode);
            if (Thread.currentThread().getContextClassLoader() == null) {
                hashCode2 = -1;
            } else {
                hashCode2 = Thread.currentThread().getContextClassLoader().hashCode();
            }
            objArr[1] = Integer.valueOf(hashCode2);
            Log.i("MicroMsg.KVEasyReport", "SmcLogic.reportIDKey class loader %s, %s ", objArr);
            if (c.Wj((int) j7)) {
                Log.e("MicroMsg.KVEasyReport", "exception:%s", Util.stackTraceToString(new Exception("The IDKey has not applied yet, check your code, IDKey:(" + j7 + "," + j6 + ")")));
                if (BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE) {
                    h.RTc.aV(new Runnable() {
                        /* class com.tencent.mm.plugin.report.service.e.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(224155);
                            Toast.makeText(MMApplicationContext.getContext(), "The IDKey has not applied yet, check your code or contact with astrozhou", 1);
                            AppMethodBeat.o(224155);
                        }
                    });
                }
                j7 = 1566;
                j6 = 1;
                j5 = 1;
                z2 = false;
            } else {
                try {
                    SmcLogic.reportIDKey(j7, j6, j5, z2);
                } catch (Throwable th) {
                    Log.printErrStackTrace("MicroMsg.KVEasyReport", th, "", new Object[0]);
                    if (d.oE(20)) {
                        SmcLogic.reportIDKey(j7, j6, j5, z2);
                    } else {
                        AppMethodBeat.o(143837);
                        throw th;
                    }
                }
                if (!Cyq) {
                    break;
                }
                if (Cyn == null) {
                    eOE();
                }
                j7 = Util.nullAs(Cyn.get(Long.valueOf(j7)), 0);
                if (j7 <= 0) {
                    break;
                }
            }
        }
        AppMethodBeat.o(143837);
    }

    public static void e(ArrayList<IDKey> arrayList, boolean z) {
        AppMethodBeat.i(143838);
        if (arrayList != null) {
            boolean z2 = false;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (c.Wj((int) arrayList.get(i2).GetID())) {
                    Log.e("MicroMsg.KVEasyReport", "exception:%s", Util.stackTraceToString(new Exception("The IDKey has not applied yet, check your code. IDKey:(" + arrayList.get(i2).GetID() + "," + arrayList.get(i2).GetKey() + ")")));
                    if (BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE) {
                        h.RTc.aV(new Runnable() {
                            /* class com.tencent.mm.plugin.report.service.e.AnonymousClass2 */

                            public final void run() {
                                AppMethodBeat.i(224156);
                                Toast.makeText(MMApplicationContext.getContext(), "The IDKey has not applied yet, check your code or contact with astrozhou", 1);
                                AppMethodBeat.o(224156);
                            }
                        });
                    }
                    b(1566, 1, 1, false);
                    z2 = true;
                }
            }
            if (z2) {
                AppMethodBeat.o(143838);
                return;
            }
            try {
                SmcLogic.reportListIDKey((IDKey[]) arrayList.toArray(new IDKey[arrayList.size()]), z);
                AppMethodBeat.o(143838);
            } catch (Throwable th) {
                Log.printErrStackTrace("MicroMsg.KVEasyReport", th, "", new Object[0]);
                if (d.oE(20)) {
                    SmcLogic.reportListIDKey((IDKey[]) arrayList.toArray(new IDKey[arrayList.size()]), z);
                    AppMethodBeat.o(143838);
                    return;
                }
                AppMethodBeat.o(143838);
                throw th;
            }
        } else {
            AppMethodBeat.o(143838);
        }
    }

    public static void tM(boolean z) {
        AppMethodBeat.i(143839);
        Log.i("MicroMsg.KVEasyReport", "summerhv setHeavyUser [%b %b], stack[%s]", Boolean.valueOf(Cyq), Boolean.valueOf(z), Util.getStack());
        Cyq = z;
        AppMethodBeat.o(143839);
    }

    public static synchronized void eOE() {
        synchronized (e.class) {
            AppMethodBeat.i(143840);
            if (Cyn == null) {
                Cyn = new HashMap(20);
            }
            cbi eOy = a.eOy();
            if (!(eOy == null || eOy.Mha == Cyp)) {
                Cyp = eOy.Mha;
                Cyn.clear();
                LinkedList<crd> linkedList = eOy.Mhb;
                if (linkedList != null) {
                    Iterator<crd> it = linkedList.iterator();
                    while (it.hasNext()) {
                        crd next = it.next();
                        Cyn.put(new Long((long) next.Mwu), new Long((long) next.Mwv));
                    }
                }
            }
            Log.i("MicroMsg.KVEasyReport", "summerhv reloadHeavyUserIDMap heavyUserIDMap[%d][%d][%s], stack[%s]", Integer.valueOf(Cyp), Integer.valueOf(Cyn.size()), Cyn, Util.getStack());
            AppMethodBeat.o(143840);
        }
    }
}
