package com.tencent.e.e.b.a.a;

import android.content.Context;
import android.os.Build;
import com.tencent.e.e.b.a.a.a.c;
import com.tencent.e.e.b.a.a.a.d;
import com.tencent.e.e.b.a.a.a.e;
import com.tencent.e.e.b.a.a.a.f;
import com.tencent.e.e.b.a.a.a.g;
import com.tencent.e.e.b.a.a.a.h;
import com.tencent.e.e.b.a.a.a.i;
import com.tencent.e.e.b.a.a.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class b {
    private static Map<String, a> RNF = new ConcurrentHashMap();
    private static final c[] RNG = {null};
    private static final boolean[] RNH = {false};
    private static String RNI;

    static /* synthetic */ void access$300() {
        AppMethodBeat.i(224043);
        hkN();
        AppMethodBeat.o(224043);
    }

    static {
        AppMethodBeat.i(138431);
        RNF.put("FF5E66B", new a(new i()));
        RNF.put("C1AAFC7", new a(new c()));
        RNF.put("E389A21", new a(new d()));
        RNF.put("750379B", new a(new d()));
        RNF.put("C892BA2", new a(new f()));
        RNF.put("C1F2239", new a(new com.tencent.e.e.b.a.a.a.a()));
        RNF.put("B09207F", new a(new h()));
        RNF.put("43780D5", new a(new h()));
        RNF.put("22C4185", new a(new e()));
        RNF.put("FE54627", new a(new g()));
        RNI = "";
        try {
            RNI = com.tencent.e.e.b.a.a.b.b.cU(a.cT(Build.MANUFACTURER.toLowerCase().getBytes())).substring(0, 7);
            AppMethodBeat.o(138431);
        } catch (Throwable th) {
            AppMethodBeat.o(138431);
        }
    }

    /* access modifiers changed from: package-private */
    public static class a {
        a RNL;
        int ibG = 0;

        public a(a aVar) {
            this.RNL = aVar;
        }
    }

    public static synchronized c kV(Context context) {
        c cVar;
        synchronized (b.class) {
            AppMethodBeat.i(138430);
            synchronized (RNG) {
                try {
                    if (RNG[0] != null && RNG[0].errorCode != -12) {
                        Log.i("MicroMsg.MsaIdManager", "[+] getOAID, hit cache, errcode: %s, oaid: %s", Integer.valueOf(RNG[0].errorCode), RNG[0].Dsg);
                        cVar = RNG[0];
                    } else if (isInitializing()) {
                        Log.w("MicroMsg.MsaIdManager", "[!] still initializing, skip rest logic.");
                        synchronized (RNG) {
                            try {
                                RNG[0] = c.aqC(-12);
                                cVar = RNG[0];
                            } finally {
                                AppMethodBeat.o(138430);
                            }
                        }
                    } else {
                        a aVar = RNF.get(RNI);
                        if (aVar == null) {
                            synchronized (RNG) {
                                try {
                                    RNG[0] = c.aqC(-10);
                                    Log.w("MicroMsg.MsaIdManager", "[!] getOAID, unsupported device.");
                                    cVar = RNG[0];
                                } finally {
                                    AppMethodBeat.o(138430);
                                }
                            }
                        } else if (aVar.ibG <= 5) {
                            aVar.ibG++;
                            Log.w("MicroMsg.MsaIdManager", "[!] getOAID, no cached res, trigger async init now.");
                            kW(context);
                            synchronized (RNG) {
                                try {
                                    RNG[0] = c.aqC(-12);
                                    cVar = RNG[0];
                                } finally {
                                    AppMethodBeat.o(138430);
                                }
                            }
                        } else {
                            synchronized (RNG) {
                                try {
                                    RNG[0] = c.aqC(-13);
                                    Log.w("MicroMsg.MsaIdManager", "[!] getOAID, too many attempts.");
                                    cVar = RNG[0];
                                } finally {
                                    AppMethodBeat.o(138430);
                                }
                            }
                        }
                    }
                } finally {
                    AppMethodBeat.o(138430);
                }
            }
        }
        return cVar;
    }

    private static void hkN() {
        synchronized (RNH) {
            RNH[0] = false;
        }
    }

    private static boolean isInitializing() {
        boolean z;
        synchronized (RNH) {
            z = RNH[0];
        }
        return z;
    }

    public static synchronized void kW(final Context context) {
        synchronized (b.class) {
            AppMethodBeat.i(224042);
            Log.i("MicroMsg.MsaIdManager", "[+] asyncInit called.");
            if (isInitializing()) {
                Log.w("MicroMsg.MsaIdManager", "[!] Initializing before, ignore this invocation. call_stack: %s", Util.getStack());
                AppMethodBeat.o(224042);
            } else {
                synchronized (RNH) {
                    try {
                        RNH[0] = true;
                    } finally {
                        AppMethodBeat.o(224042);
                    }
                }
                final a aVar = RNF.get(RNI);
                if (aVar == null) {
                    Log.e("MicroMsg.MsaIdManager", "[-] asyncInit, Unsupport device.");
                    synchronized (RNG) {
                        try {
                            RNG[0] = c.aqC(-10);
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    hkN();
                    AppMethodBeat.o(224042);
                } else {
                    com.tencent.f.h.RTc.c(new com.tencent.f.i.h() {
                        /* class com.tencent.e.e.b.a.a.b.AnonymousClass1 */

                        @Override // com.tencent.f.i.h, com.tencent.f.i.g
                        public final String getKey() {
                            return "msa-init-waiter";
                        }

                        public final void run() {
                            AppMethodBeat.i(138429);
                            try {
                                com.tencent.f.h.RTc.c(new com.tencent.f.i.h() {
                                    /* class com.tencent.e.e.b.a.a.b.AnonymousClass1.AnonymousClass1 */

                                    @Override // com.tencent.f.i.h, com.tencent.f.i.g
                                    public final String getKey() {
                                        return "msa-init-fetcher";
                                    }

                                    public final void run() {
                                        AppMethodBeat.i(224041);
                                        Log.i("MicroMsg.MsaIdManager", "[+] do initialize in sep thread now.");
                                        c kV = aVar.RNL.kV(context);
                                        synchronized (b.RNG) {
                                            try {
                                                b.RNG[0] = kV;
                                            } catch (Throwable th) {
                                                AppMethodBeat.o(224041);
                                                throw th;
                                            }
                                        }
                                        b.access$300();
                                        Log.i("MicroMsg.MsaIdManager", "[+] initialize done.");
                                        AppMethodBeat.o(224041);
                                    }
                                }, "sn-msa-init-fetcher").get(10, TimeUnit.SECONDS);
                                AppMethodBeat.o(138429);
                            } catch (TimeoutException e2) {
                                b.access$300();
                                Log.w("MicroMsg.MsaIdManager", "[!] asyncInit, timeout.");
                                AppMethodBeat.o(138429);
                            } catch (Throwable th) {
                                b.access$300();
                                Log.printErrStackTrace("MicroMsg.MsaIdManager", th, "[-] asyncInit failure.", new Object[0]);
                                AppMethodBeat.o(138429);
                            }
                        }
                    }, "sn-msa-init-waiter");
                    AppMethodBeat.o(224042);
                }
            }
        }
    }
}
