package com.tencent.e.e.a;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.Display;
import com.tencent.e.e.a.a.c;
import com.tencent.e.e.a.a.d;
import com.tencent.e.e.a.a.g;
import com.tencent.e.e.a.a.h;
import com.tencent.e.e.a.a.i;
import com.tencent.e.e.a.a.k;
import com.tencent.e.f.f;
import com.tencent.e.f.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class e {
    private static final j<e> AEL = new j<e>() {
        /* class com.tencent.e.e.a.e.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.tencent.e.f.j
        public final /* synthetic */ e oR() {
            AppMethodBeat.i(138376);
            e eVar = new e((byte) 0);
            AppMethodBeat.o(138376);
            return eVar;
        }
    };
    private g RMB;
    private final List<k> RMC;
    private d RMD;
    private b RME;
    private d RMF;
    private final Runnable RMG;
    private final a RMH;
    private boolean gc;
    private final MMHandler mHandler;

    /* synthetic */ e(byte b2) {
        this();
    }

    static {
        AppMethodBeat.i(138392);
        AppMethodBeat.o(138392);
    }

    public static e hkD() {
        AppMethodBeat.i(138385);
        e eVar = AEL.get();
        AppMethodBeat.o(138385);
        return eVar;
    }

    /* access modifiers changed from: package-private */
    public class a extends c {
        long RMO;
        int mCount;
        int mMaxCount;

        private a() {
            this.mCount = 1;
            this.mMaxCount = 3;
            this.RMO = 0;
        }

        /* synthetic */ a(e eVar, byte b2) {
            this();
        }

        @Override // com.tencent.e.e.a.a.c
        public final void boF() {
            int i2;
            boolean z;
            AppMethodBeat.i(138383);
            k kVar = new k();
            synchronized (e.this) {
                try {
                    Context context = e.this.RMD.context;
                    try {
                        if (Build.VERSION.SDK_INT >= 20) {
                            Class<?> cls = Class.forName("android.hardware.display.DisplayManager");
                            Field field = context.getClass().getField("DISPLAY_SERVICE");
                            field.setAccessible(true);
                            Object systemService = context.getSystemService((String) field.get(context));
                            if (systemService == null) {
                                i2 = 0;
                            } else {
                                Method method = cls.getMethod("getDisplays", new Class[0]);
                                if (method == null) {
                                    i2 = 0;
                                } else {
                                    method.setAccessible(true);
                                    Display[] displayArr = (Display[]) method.invoke(systemService, new Object[0]);
                                    Method method2 = Display.class.getMethod("getState", new Class[0]);
                                    method2.setAccessible(true);
                                    Field field2 = Display.class.getField("STATE_OFF");
                                    field2.setAccessible(true);
                                    boolean z2 = false;
                                    int length = displayArr.length;
                                    int i3 = 0;
                                    while (i3 < length) {
                                        Display display = displayArr[i3];
                                        if (((Integer) method2.invoke(display, new Object[0])).intValue() != field2.getInt(display)) {
                                            z = true;
                                        } else {
                                            z = z2;
                                        }
                                        i3++;
                                        z2 = z;
                                    }
                                    kVar.RNi = z2 ? 1 : 2;
                                    i2 = kVar.RNi;
                                }
                            }
                            kVar.RNi = i2;
                        } else {
                            PowerManager powerManager = (PowerManager) context.getSystemService("power");
                            if (powerManager != null) {
                                kVar.RNi = powerManager.isScreenOn() ? 1 : 2;
                            }
                        }
                    } catch (Throwable th) {
                    }
                    String Z = f.Z(new File("/sys/class/android_usb/android0/state"));
                    if (!TextUtils.isEmpty(Z)) {
                        if ("CONFIGURED".equals(Z)) {
                            kVar.RNk = 1;
                        } else if ("DISCONNECTED".equals(Z)) {
                            kVar.RNk = 2;
                        } else if ("CONNECTED".equals(Z)) {
                            kVar.RNk = 3;
                        }
                    }
                    Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                    if (registerReceiver != null) {
                        int intExtra = registerReceiver.getIntExtra("status", -1);
                        if (!(intExtra == 2 || intExtra == 5)) {
                            kVar.RNl = 1;
                        } else {
                            int intExtra2 = registerReceiver.getIntExtra("plugged", -1);
                            if (intExtra2 == 2) {
                                kVar.RNl = 3;
                            } else if (intExtra2 == 1) {
                                kVar.RNl = 2;
                            } else {
                                kVar.RNl = 0;
                            }
                        }
                    }
                } finally {
                    AppMethodBeat.o(138383);
                }
            }
            synchronized (e.this.RMC) {
                try {
                    e.this.RMC.add(kVar);
                } finally {
                    AppMethodBeat.o(138383);
                }
            }
            if (this.mCount >= this.mMaxCount) {
                synchronized (e.this) {
                    try {
                        if (e.this.gc) {
                            e.this.Qt();
                            AppMethodBeat.o(138383);
                        }
                    } finally {
                        AppMethodBeat.o(138383);
                    }
                }
            } else {
                this.mCount++;
                long currentTimeMillis = (this.RMO + (com.tencent.e.e.a.a.f.RMR * ((long) this.mCount))) - System.currentTimeMillis();
                if (currentTimeMillis > 0) {
                    e.this.mHandler.postDelayed(e.this.RMH, currentTimeMillis);
                    AppMethodBeat.o(138383);
                    return;
                }
                e.this.mHandler.post(e.this.RMH);
                AppMethodBeat.o(138383);
            }
        }

        @Override // com.tencent.e.e.a.a.c
        public final void hkE() {
            AppMethodBeat.i(138384);
            if (e.this.RMF != null) {
                d unused = e.this.RMF;
            }
            AppMethodBeat.o(138384);
        }
    }

    private e() {
        AppMethodBeat.i(138386);
        this.gc = false;
        this.RMC = new ArrayList();
        this.RMG = new c() {
            /* class com.tencent.e.e.a.e.AnonymousClass2 */

            @Override // com.tencent.e.e.a.a.c
            public final void boF() {
                AppMethodBeat.i(138377);
                synchronized (e.this) {
                    try {
                        if (e.this.gc) {
                            if (e.this.RMB == null) {
                                AppMethodBeat.o(138377);
                                return;
                            }
                            if (e.this.RMB.Ox(e.this.RMD.Gfd)) {
                                long hkI = e.this.RMB.RMY.hkI();
                                a aVar = e.this.RMH;
                                aVar.mCount = 1;
                                aVar.mMaxCount = (int) (e.this.RMD.Gfd / com.tencent.e.e.a.a.f.RMR);
                                aVar.RMO = hkI;
                                long currentTimeMillis = (hkI + com.tencent.e.e.a.a.f.RMR) - System.currentTimeMillis();
                                if (currentTimeMillis > 0) {
                                    e.this.mHandler.postDelayed(e.this.RMH, currentTimeMillis);
                                } else {
                                    e.this.mHandler.post(e.this.RMH);
                                }
                            }
                            AppMethodBeat.o(138377);
                        }
                    } finally {
                        AppMethodBeat.o(138377);
                    }
                }
            }

            @Override // com.tencent.e.e.a.a.c
            public final void hkE() {
                AppMethodBeat.i(138378);
                if (e.this.RMF != null) {
                    d unused = e.this.RMF;
                }
                AppMethodBeat.o(138378);
            }
        };
        this.RMH = new a(this, (byte) 0);
        this.mHandler = new MMHandler("TuringMMCore");
        AppMethodBeat.o(138386);
    }

    public final synchronized boolean Qt() {
        final ArrayList arrayList;
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(138388);
            if (!this.gc) {
                AppMethodBeat.o(138388);
                z = true;
            } else {
                this.gc = false;
                if (this.RMD == null) {
                    AppMethodBeat.o(138388);
                } else {
                    this.mHandler.removeCallbacks(this.RMG);
                    this.mHandler.removeCallbacks(this.RMH);
                    if (this.RMB != null) {
                        this.RMB.hkG();
                        if (((int) (this.RMB.RMY.hkJ() / com.tencent.e.e.a.a.f.RMR)) < 3) {
                            AppMethodBeat.o(138388);
                        } else {
                            final SparseArray<i> hkH = this.RMB.hkH();
                            if (hkH.size() == 0) {
                                AppMethodBeat.o(138388);
                            } else {
                                synchronized (this.RMC) {
                                    try {
                                        arrayList = new ArrayList(this.RMC);
                                    } catch (Throwable th) {
                                        AppMethodBeat.o(138388);
                                        throw th;
                                    }
                                }
                                if (arrayList.size() < 3) {
                                    AppMethodBeat.o(138388);
                                } else {
                                    final int i2 = this.RMD.RMA;
                                    final int i3 = this.RMD.action;
                                    final int i4 = this.RMD.requestType;
                                    this.mHandler.post(new c() {
                                        /* class com.tencent.e.e.a.e.AnonymousClass3 */

                                        /* JADX WARNING: Removed duplicated region for block: B:22:0x006d  */
                                        /* JADX WARNING: Removed duplicated region for block: B:25:0x007d  */
                                        @Override // com.tencent.e.e.a.a.c
                                        /* Code decompiled incorrectly, please refer to instructions dump. */
                                        public final void boF() {
                                            /*
                                            // Method dump skipped, instructions count: 215
                                            */
                                            throw new UnsupportedOperationException("Method not decompiled: com.tencent.e.e.a.e.AnonymousClass3.boF():void");
                                        }

                                        @Override // com.tencent.e.e.a.a.c
                                        public final void hkE() {
                                            AppMethodBeat.i(138380);
                                            if (e.this.RMF != null) {
                                                d unused = e.this.RMF;
                                            }
                                            AppMethodBeat.o(138380);
                                        }
                                    });
                                    AppMethodBeat.o(138388);
                                    z = true;
                                }
                            }
                        }
                    } else {
                        AppMethodBeat.o(138388);
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    public final synchronized void a(Context context, final String str, final com.tencent.e.e.a.a.e eVar) {
        AppMethodBeat.i(138389);
        h hkK = h.hkK();
        if (!hkK.mInit) {
            hkK.init(context);
        }
        this.mHandler.post(new c() {
            /* class com.tencent.e.e.a.e.AnonymousClass4 */

            @Override // com.tencent.e.e.a.a.c
            public final void boF() {
                boolean a2;
                AppMethodBeat.i(138381);
                Map<String, com.tencent.e.e.a.b.a> hkL = h.hkK().hkL();
                HashMap hashMap = new HashMap();
                if (hkL.size() != 0) {
                    h.a i2 = h.i(hkL, 0);
                    if (i2 != null) {
                        hashMap.put(i2.RNd, i2.RNe);
                    }
                    h.a i3 = h.i(hkL, 1);
                    if (i3 != null) {
                        hashMap.put(i3.RNd, i3.RNe);
                    }
                    h.a i4 = h.i(hkL, 2);
                    if (i4 != null) {
                        hashMap.put(i4.RNd, i4.RNe);
                    }
                }
                if (hashMap.size() == 0) {
                    eVar.bqP();
                    AppMethodBeat.o(138381);
                    return;
                }
                for (com.tencent.e.e.a.b.a aVar : hashMap.keySet()) {
                    aVar.RNm = System.currentTimeMillis();
                    aVar.dUb = str;
                    if (eVar instanceof a) {
                        a2 = e.a((a) eVar, aVar);
                    } else {
                        a2 = eVar instanceof c ? e.a((c) eVar, aVar) : false;
                    }
                    if (a2) {
                        for (String str : (List) hashMap.get(aVar)) {
                            try {
                                new File(str).delete();
                            } catch (Throwable th) {
                            }
                        }
                    }
                }
                AppMethodBeat.o(138381);
            }

            @Override // com.tencent.e.e.a.a.c
            public final void hkE() {
                AppMethodBeat.i(138382);
                if (e.this.RMF != null) {
                    d unused = e.this.RMF;
                }
                AppMethodBeat.o(138382);
            }
        });
        AppMethodBeat.o(138389);
    }

    public final synchronized boolean a(d dVar) {
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.i(138387);
            Context context = dVar.context;
            if (context == null) {
                z = false;
                AppMethodBeat.o(138387);
            } else {
                h hkK = h.hkK();
                if (!hkK.mInit) {
                    hkK.init(context);
                }
                if (this.gc) {
                    Qt();
                }
                this.RMD = dVar;
                this.gc = true;
                if (this.RMB == null) {
                    this.RMB = new g();
                }
                if (this.RMB != null) {
                    g gVar = this.RMB;
                    synchronized (gVar.RMW) {
                        try {
                            gVar.RMW.clear();
                        } catch (Throwable th) {
                            AppMethodBeat.o(138387);
                            throw th;
                        }
                    }
                }
                synchronized (this.RMC) {
                    try {
                        this.RMC.clear();
                    } catch (Throwable th2) {
                        AppMethodBeat.o(138387);
                        throw th2;
                    }
                }
                this.mHandler.postDelayed(this.RMG, dVar.delayTime);
                AppMethodBeat.o(138387);
            }
        }
        return z;
    }

    static /* synthetic */ boolean a(a aVar, com.tencent.e.e.a.b.a aVar2) {
        com.tencent.e.e.a.b.c hkC;
        com.tencent.e.e.a.b.d hkB;
        boolean z = true;
        AppMethodBeat.i(138390);
        if (aVar2.requestType != 0 ? (hkC = aVar.hkC()) == null || hkC.errCode != 0 : (hkB = aVar.hkB()) == null || hkB.errorCode != 0) {
            z = false;
        }
        AppMethodBeat.o(138390);
        return z;
    }

    static /* synthetic */ boolean a(c cVar, com.tencent.e.e.a.b.a aVar) {
        boolean z = true;
        AppMethodBeat.i(138391);
        if (aVar.requestType != 0 ? cVar.b("sensorReport", "sensorInsightReportWup", aVar).errCode != 0 : cVar.a("userIdentify", "reportWup", aVar).errorCode != 0) {
            z = false;
        }
        AppMethodBeat.o(138391);
        return z;
    }
}
