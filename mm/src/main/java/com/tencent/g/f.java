package com.tencent.g;

import com.tencent.g.b.b;
import com.tencent.g.b.c;
import com.tencent.g.b.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class f {
    private static f SoQ;
    private HashMap<String, g> SoR = new HashMap<>();
    HashMap<String, Object> SoS = new HashMap<>();
    private Object SoT = new Object();
    Object SoU = new Object();
    private a SoV = new a();

    public f() {
        AppMethodBeat.i(62799);
        AppMethodBeat.o(62799);
    }

    static f hpQ() {
        AppMethodBeat.i(62800);
        if (SoQ == null) {
            synchronized (f.class) {
                try {
                    if (SoQ == null) {
                        SoQ = new f();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(62800);
                    throw th;
                }
            }
        }
        f fVar = SoQ;
        AppMethodBeat.o(62800);
        return fVar;
    }

    public static Object bqW(String str) {
        AppMethodBeat.i(62801);
        Object bqX = hpQ().bqX(str);
        AppMethodBeat.o(62801);
        return bqX;
    }

    public static b a(d dVar) {
        AppMethodBeat.i(62802);
        b b2 = hpQ().b(dVar);
        AppMethodBeat.o(62802);
        return b2;
    }

    private Object bqX(String str) {
        Object obj;
        Object obj2;
        g gVar;
        AppMethodBeat.i(62803);
        if (str == null) {
            h hVar = new h("TpfServiceCenter|getService|service name should not be null");
            AppMethodBeat.o(62803);
            throw hVar;
        }
        synchronized (this.SoU) {
            try {
                obj = this.SoS.get(str);
            } finally {
                AppMethodBeat.o(62803);
            }
        }
        if (obj == null) {
            synchronized (this.SoT) {
                try {
                    gVar = this.SoR.get(str);
                } finally {
                    AppMethodBeat.o(62803);
                }
            }
            if (gVar != null) {
                if (gVar.SoZ.Spk) {
                    obj2 = c(gVar);
                } else {
                    if (4 == gVar.mState) {
                        try {
                            a(gVar);
                        } catch (c e2) {
                            com.tencent.pb.common.c.b.w("service", e2);
                            AppMethodBeat.o(62803);
                            return null;
                        }
                    }
                    synchronized (this.SoU) {
                        try {
                            obj2 = this.SoS.get(str);
                        } finally {
                            AppMethodBeat.o(62803);
                        }
                    }
                }
                return obj2;
            }
        }
        obj2 = obj;
        return obj2;
    }

    private b b(d dVar) {
        g gVar;
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(62804);
        if (dVar == null || dVar.Spi == null) {
            AppMethodBeat.o(62804);
            return null;
        }
        String str = dVar.Spi;
        this.SoV.nP("install_", str);
        try {
            synchronized (this.SoT) {
                try {
                    gVar = this.SoR.get(str);
                    if (gVar == null) {
                        gVar = new g(this, dVar);
                        gVar.mState = 2;
                        com.tencent.pb.common.c.b.d("service", "service [", str, "] installed!");
                        this.SoR.put(str, gVar);
                        z = true;
                    } else {
                        com.tencent.pb.common.c.b.d("service", "service [", str, "] had been installed!");
                        z = false;
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(62804);
                    throw th;
                }
            }
            if (z) {
                if (dVar.Sph == null) {
                    z2 = false;
                }
                if (z2) {
                    gVar.mState = 4;
                    com.tencent.pb.common.c.b.d("service", "service [", str, "] resolved!");
                } else {
                    c cVar = new c("resolve service [" + str + "] failed.");
                    AppMethodBeat.o(62804);
                    throw cVar;
                }
            }
            return gVar;
        } finally {
            this.SoV.nQ("install_", str);
            AppMethodBeat.o(62804);
        }
    }

    private boolean af(String[] strArr) {
        boolean z;
        g gVar;
        AppMethodBeat.i(62806);
        if (strArr != null) {
            int length = strArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                String str = strArr[i2];
                if (str != null) {
                    synchronized (this.SoT) {
                        try {
                            gVar = this.SoR.get(str);
                        } finally {
                            AppMethodBeat.o(62806);
                        }
                    }
                    if (gVar == null) {
                        z = false;
                        break;
                    }
                    a(gVar);
                    if (gVar.mState != 32) {
                        z = false;
                        break;
                    }
                    gVar.mReferenceCount++;
                    com.tencent.pb.common.c.b.d("reference_count", "addReferenceCount|", gVar.SoZ.Spi, "|refcount=", Integer.valueOf(gVar.mReferenceCount));
                }
                i2++;
            }
            return z;
        }
        z = true;
        return z;
    }

    /* access modifiers changed from: package-private */
    public class a {
        private final HashMap<String, Object> SoW = new HashMap<>();
        private final Object mLock = new Object();

        a() {
            AppMethodBeat.i(62795);
            AppMethodBeat.o(62795);
        }

        /* access modifiers changed from: package-private */
        public final void nP(String str, String str2) {
            AppMethodBeat.i(62796);
            String str3 = str + str2;
            synchronized (this.mLock) {
                while (this.SoW.get(str3) != null) {
                    try {
                        try {
                            this.mLock.wait();
                        } catch (InterruptedException e2) {
                            c cVar = new c("install fail,lock interrupted!");
                            AppMethodBeat.o(62796);
                            throw cVar;
                        }
                    } finally {
                        AppMethodBeat.o(62796);
                    }
                }
                this.SoW.put(str3, str2);
            }
        }

        /* access modifiers changed from: package-private */
        public final void nQ(String str, String str2) {
            AppMethodBeat.i(62797);
            String str3 = str + str2;
            synchronized (this.mLock) {
                try {
                    this.SoW.remove(str3);
                    this.mLock.notifyAll();
                } finally {
                    AppMethodBeat.o(62797);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean a(g gVar) {
        boolean z = false;
        AppMethodBeat.i(62805);
        d dVar = gVar.SoZ;
        String str = dVar.Spi;
        this.SoV.nP("service_", str);
        try {
            if (gVar.mState == 32) {
                z = true;
            } else if (gVar.mState == 4) {
                gVar.mState = 8;
                com.tencent.pb.common.c.b.d("service", "service [", str, "] starting...");
                if (dVar.Spj != null) {
                    af(dVar.Spj);
                }
                if (b(gVar)) {
                    gVar.mState = 32;
                    com.tencent.pb.common.c.b.d("service", "service [", str, "] active...");
                    z = true;
                }
            }
            this.SoV.nQ("service_", str);
            if (!z) {
                c cVar = new c("startService [" + str + "] failed");
                AppMethodBeat.o(62805);
                throw cVar;
            }
            AppMethodBeat.o(62805);
            return true;
        } catch (Throwable th) {
            this.SoV.nQ("service_", str);
            AppMethodBeat.o(62805);
            throw th;
        }
    }

    private static boolean b(g gVar) {
        boolean z;
        AppMethodBeat.i(62807);
        if (!gVar.SoZ.Spk) {
            try {
                b bVar = (b) Class.forName(gVar.SoZ.Sph).newInstance();
                gVar.Spa = bVar;
                a aVar = new a(gVar);
                gVar.Spb = aVar;
                bVar.a(aVar);
                z = true;
            } catch (Exception e2) {
                com.tencent.pb.common.c.b.w("service", e2);
            }
            AppMethodBeat.o(62807);
            return z;
        }
        z = false;
        AppMethodBeat.o(62807);
        return z;
    }

    private static Object c(g gVar) {
        AppMethodBeat.i(62808);
        try {
            gVar.Spb = new a(gVar);
            gVar.mState = 32;
            Object hpM = ((c) Class.forName(gVar.SoZ.Sph).newInstance()).hpM();
            AppMethodBeat.o(62808);
            return hpM;
        } catch (Exception e2) {
            com.tencent.pb.common.c.b.w("service", e2);
            AppMethodBeat.o(62808);
            return null;
        }
    }
}
