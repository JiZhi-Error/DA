package com.tencent.matrix.a.a;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Environment;
import android.os.Parcel;
import android.os.SystemClock;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class a extends com.tencent.matrix.report.d {
    private final int cQj;
    private final int cQk;
    private final f cQl;
    final b cQm;
    List<C0202a> cQn;
    private long cQo;
    public boolean cQp = true;

    static /* synthetic */ byte[] k(Intent intent) {
        if (intent == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        intent.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00dd A[SYNTHETIC, Splitter:B:26:0x00dd] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0103 A[SYNTHETIC, Splitter:B:34:0x0103] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x012b A[SYNTHETIC, Splitter:B:42:0x012b] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0144 A[SYNTHETIC, Splitter:B:49:0x0144] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x0051  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a(com.tencent.matrix.report.d.a r13, com.tencent.matrix.a.a.b r14) {
        /*
        // Method dump skipped, instructions count: 356
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.matrix.a.a.a.<init>(com.tencent.matrix.report.d$a, com.tencent.matrix.a.a.b):void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:121:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x02b9 A[SYNTHETIC, Splitter:B:91:0x02b9] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x02d2 A[SYNTHETIC, Splitter:B:98:0x02d2] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void RO() {
        /*
        // Method dump skipped, instructions count: 750
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.matrix.a.a.a.RO():void");
    }

    private static String a(Set<String> set, String str) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = set.iterator();
        if (it.hasNext()) {
            sb.append(it.next());
        }
        while (it.hasNext()) {
            sb.append(str).append(it.next());
        }
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public final void a(AlarmManager.OnAlarmListener onAlarmListener, e eVar) {
        boolean z;
        for (int i2 = 0; i2 < this.cQn.size(); i2++) {
            C0202a aVar = this.cQn.get(i2);
            if (aVar.cQt == null || !aVar.cQt.equals(onAlarmListener)) {
                if (aVar.cQs != null) {
                    e eVar2 = aVar.cQs;
                    if (eVar2.cQB != null && eVar2.cQB.equals(eVar.cQB)) {
                        z = true;
                    } else if (eVar2.cQw == eVar.cQw) {
                        z = true;
                    } else if (eVar2.cQC != null && eVar2.cQC.filterEquals(eVar.cQC)) {
                        z = true;
                    } else if (eVar2.cQy == null || !eVar2.cQy.equals(eVar.cQy)) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (z) {
                        aVar.RP();
                    }
                }
                if (aVar.cQs == null && aVar.cQt == null) {
                    aVar.RP();
                }
            } else {
                aVar.RP();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.matrix.a.a.a$a  reason: collision with other inner class name */
    public static final class C0202a {
        final long cQq;
        final long cQr;
        final e cQs;
        final AlarmManager.OnAlarmListener cQt;
        long cQu;
        final String stackTrace;
        final int type;

        C0202a(int i2, long j2, long j3, PendingIntent pendingIntent, AlarmManager.OnAlarmListener onAlarmListener, String str) {
            long j4;
            this.type = i2;
            if (i2 == 2 || i2 == 3) {
                j4 = SystemClock.elapsedRealtime();
            } else {
                j4 = System.currentTimeMillis();
            }
            long j5 = j4 + 5000;
            this.cQq = j2 < j5 ? j5 : j2;
            if (j3 > 0 && j3 < Util.MILLSECONDS_OF_MINUTE) {
                j3 = 60000;
            }
            this.cQr = j3;
            this.cQs = new e(pendingIntent);
            this.cQt = onAlarmListener;
            this.stackTrace = str;
            this.cQu = MAlarmHandler.NEXT_FIRE_INTERVAL;
        }

        C0202a(int i2, long j2, long j3, e eVar, String str, long j4) {
            this.type = i2;
            this.cQq = j2;
            this.cQr = j3;
            this.cQs = eVar;
            this.cQt = null;
            this.stackTrace = str;
            this.cQu = j4;
        }

        public final void RP() {
            if (this.cQu == MAlarmHandler.NEXT_FIRE_INTERVAL) {
                this.cQu = System.currentTimeMillis();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class e {
        private static Method cQA;
        private static Method cQz;
        final PendingIntent cQB;
        final Intent cQC;
        final int cQw;
        final String cQy;

        e(PendingIntent pendingIntent) {
            this.cQB = pendingIntent;
            if (this.cQB != null) {
                this.cQw = pendingIntent.hashCode();
                this.cQC = d(pendingIntent);
                this.cQy = e(pendingIntent);
                return;
            }
            this.cQw = -1;
            this.cQC = null;
            this.cQy = null;
        }

        e(int i2, Intent intent, String str) {
            this.cQB = null;
            this.cQw = i2;
            this.cQC = intent;
            this.cQy = str;
        }

        private static Intent d(PendingIntent pendingIntent) {
            if (pendingIntent == null) {
                return null;
            }
            if (cQz == null) {
                try {
                    Method declaredMethod = PendingIntent.class.getDeclaredMethod("getIntent", new Class[0]);
                    cQz = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (NoSuchMethodException e2) {
                    com.tencent.matrix.g.c.w("MicroMsg.AlarmDetector", "getOperationIntent e:%s", e2);
                    return null;
                }
            }
            try {
                Object invoke = cQz.invoke(pendingIntent, new Object[0]);
                if (!(invoke instanceof Intent)) {
                    return null;
                }
                return (Intent) invoke;
            } catch (IllegalAccessException e3) {
                com.tencent.matrix.g.c.w("MicroMsg.AlarmDetector", "getOperationIntent e:%s", e3);
                return null;
            } catch (InvocationTargetException e4) {
                return null;
            } catch (SecurityException e5) {
                com.tencent.matrix.g.c.w("MicroMsg.AlarmDetector", "getOperationIntent e:%s", e5);
                return null;
            }
        }

        private static String e(PendingIntent pendingIntent) {
            if (pendingIntent == null) {
                return null;
            }
            if (cQA == null) {
                try {
                    Method declaredMethod = PendingIntent.class.getDeclaredMethod("getTag", String.class);
                    cQA = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (NoSuchMethodException e2) {
                    com.tencent.matrix.g.c.w("MicroMsg.AlarmDetector", "getOperationIntentTag e:%s", e2);
                    return null;
                }
            }
            try {
                Object invoke = cQA.invoke(pendingIntent, "");
                if (!(invoke instanceof String)) {
                    return null;
                }
                return (String) invoke;
            } catch (IllegalAccessException e3) {
                com.tencent.matrix.g.c.w("MicroMsg.AlarmDetector", "getOperationIntentTag e:%s", e3);
                return null;
            } catch (InvocationTargetException e4) {
                com.tencent.matrix.g.c.w("MicroMsg.AlarmDetector", "getOperationIntentTag e:%s", e4);
                return null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class c implements Serializable {
        static final /* synthetic */ boolean $assertionsDisabled = (!a.class.desiredAssertionStatus());
        final long cQq;
        final long cQr;
        long cQu;
        final int cQw;
        final byte[] cQx;
        final String cQy;
        final String stackTrace;
        final int type;

        c(C0202a aVar) {
            if ($assertionsDisabled || aVar != null) {
                this.type = aVar.type;
                this.cQq = aVar.cQq;
                this.cQr = aVar.cQr;
                this.cQw = aVar.cQs.cQw;
                this.cQx = a.k(aVar.cQs.cQC);
                this.cQy = aVar.cQs.cQy;
                this.stackTrace = aVar.stackTrace;
                this.cQu = aVar.cQu;
                return;
            }
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: private */
    public static Intent N(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            Parcel obtain = Parcel.obtain();
            obtain.unmarshall(bArr, 0, bArr.length);
            obtain.setDataPosition(0);
            Intent intent = (Intent) Intent.CREATOR.createFromParcel(obtain);
            obtain.recycle();
            return intent;
        } catch (IllegalStateException e2) {
            com.tencent.matrix.g.c.e("MicroMsg.AlarmDetector", "[bytesToIntent] %s", e2);
            return null;
        }
    }

    static final class d implements Serializable {
        private final List<c> cQn = new ArrayList();
        private final long cQo;

        d(List<C0202a> list, long j2) {
            if (list != null) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    this.cQn.add(new c(list.get(i2)));
                }
            }
            this.cQo = j2;
        }

        public final List<C0202a> RQ() {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < this.cQn.size(); i2++) {
                c cVar = this.cQn.get(i2);
                Intent N = a.N(cVar.cQx);
                if (N == null) {
                    com.tencent.matrix.g.c.e("MicroMsg.AlarmDetector", "bytesToIntent is null,  alarmInfoSet maybe invalid object", new Object[0]);
                } else {
                    arrayList.add(new C0202a(cVar.type, cVar.cQq, cVar.cQr, new e(cVar.cQw, N, cVar.cQy), cVar.stackTrace, cVar.cQu));
                }
            }
            return arrayList;
        }
    }

    final class f {
        final String cQD;

        f() {
            Object[] objArr = new Object[3];
            objArr[0] = Environment.getExternalStorageDirectory().getAbsolutePath();
            objArr[1] = com.tencent.matrix.a.c.c.getPackageName();
            com.tencent.matrix.a.b bVar = (com.tencent.matrix.a.b) com.tencent.matrix.b.RG().Y(com.tencent.matrix.a.b.class);
            if (bVar == null) {
                throw new IllegalStateException("BatteryMonitorPlugin is not yet installed!");
            }
            objArr[2] = bVar.getProcessName();
            this.cQD = String.format("%s/com.tencent.matrix/alarm-detector-record/%s/current-alarm-info-%s", objArr);
            com.tencent.matrix.g.c.i("MicroMsg.AlarmDetector", "PersistenceHelper mSaveFileName :%s", this.cQD);
        }
    }

    static final class b {
        private final String cQv = String.format("%s/com.tencent.matrix/alarm-detector-record/%s/alarm-info-record-%s", Environment.getExternalStorageDirectory().getAbsolutePath(), com.tencent.matrix.a.c.c.getPackageName(), com.tencent.matrix.g.d.formatTime("yyyy-MM-dd", System.currentTimeMillis()));

        b() {
            com.tencent.matrix.g.c.i("MicroMsg.AlarmDetector", "AlarmInfoRecorder path:%s", this.cQv);
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0060 A[SYNTHETIC, Splitter:B:19:0x0060] */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x007c A[SYNTHETIC, Splitter:B:25:0x007c] */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x0085 A[SYNTHETIC, Splitter:B:30:0x0085] */
        /* JADX WARNING: Removed duplicated region for block: B:41:? A[Catch:{ FileNotFoundException -> 0x004a, IOException -> 0x0066 }, RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:42:? A[Catch:{ FileNotFoundException -> 0x004a, IOException -> 0x0066 }, RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void ej(java.lang.String r7) {
            /*
            // Method dump skipped, instructions count: 148
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.matrix.a.a.a.b.ej(java.lang.String):void");
        }
    }
}
