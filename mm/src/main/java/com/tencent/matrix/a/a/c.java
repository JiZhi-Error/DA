package com.tencent.matrix.a.a;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.IBinder;
import android.os.SystemClock;
import android.os.WorkSource;
import com.tencent.matrix.a.a.a;
import com.tencent.matrix.a.a.d;
import com.tencent.matrix.a.c.a;
import com.tencent.matrix.a.c.b;
import com.tencent.matrix.a.c.d;
import com.tencent.matrix.report.d;
import com.tencent.sqlitelint.util.SQLiteLintUtil;

public final class c implements a.b, d.b, d.a {
    public final b cQG;
    public final b cQH;
    private final com.tencent.matrix.a.a cQI;
    public d cQJ;
    public a cQK;
    final Context mContext;
    public boolean mIsStart;

    @Override // com.tencent.matrix.a.c.d.b
    public final void a(final IBinder iBinder, final int i2, final String str, final String str2, final WorkSource workSource, final String str3) {
        if (this.cQJ != null) {
            final String throwableStack = com.tencent.matrix.a.c.c.getThrowableStack(new Throwable());
            final long currentTimeMillis = System.currentTimeMillis();
            this.cQH.q(new Runnable() {
                /* class com.tencent.matrix.a.a.c.AnonymousClass1 */

                public final void run() {
                    d.C0203d dVar;
                    d dVar2 = c.this.cQJ;
                    IBinder iBinder = iBinder;
                    int i2 = i2;
                    String str = str;
                    String str2 = throwableStack;
                    long j2 = currentTimeMillis;
                    com.tencent.matrix.g.c.i("Matrix.detector.WakeLock", "onAcquireWakeLock token:%s tag:%s", iBinder, str);
                    if (dVar2.cRf != null) {
                        d.e eVar = dVar2.cRf;
                        eVar.cRv.append(com.tencent.matrix.g.d.formatTime(SQLiteLintUtil.YYYY_MM_DD_HH_mm, j2)).append(" onAcquireWakeLock token:").append(iBinder.toString()).append(" flags:").append(i2).append(" tag:").append(str).append('\n').append(str2).append('\n');
                        eVar.cRu++;
                        eVar.RY();
                    }
                    String obj = iBinder.toString();
                    if (!dVar2.cQY.containsKey(obj)) {
                        dVar = new d.C0203d(obj, str, i2, j2);
                        dVar2.cQY.put(obj, dVar);
                    } else {
                        dVar = dVar2.cQY.get(obj);
                    }
                    dVar.cRn.ek(str2);
                    if (!dVar2.cQZ.containsKey(str)) {
                        dVar2.cQZ.put(str, new d.c(str));
                    }
                    d.c cVar = dVar2.cQZ.get(str);
                    boolean isScreenOn = dVar2.cRd.isScreenOn();
                    cVar.cRq = isScreenOn;
                    cVar.cRl++;
                    if (!isScreenOn) {
                        cVar.cRm++;
                    }
                    cVar.cRo.put(obj, Boolean.TRUE);
                    if (cVar.cRp < 0) {
                        cVar.cRp = SystemClock.uptimeMillis();
                    }
                    cVar.cRn.ek(str2);
                    dVar2.cRd.d(dVar2.cRe, (long) dVar2.cRa);
                }
            });
        }
    }

    @Override // com.tencent.matrix.a.c.d.b
    public final void a(final IBinder iBinder, final int i2) {
        if (this.cQJ != null) {
            final long currentTimeMillis = System.currentTimeMillis();
            this.cQH.q(new Runnable() {
                /* class com.tencent.matrix.a.a.c.AnonymousClass2 */

                public final void run() {
                    boolean z = true;
                    d dVar = c.this.cQJ;
                    IBinder iBinder = iBinder;
                    int i2 = i2;
                    long j2 = currentTimeMillis;
                    com.tencent.matrix.g.c.i("Matrix.detector.WakeLock", "onReleaseWakeLock token:%s", iBinder);
                    if (dVar.cRf != null) {
                        d.e eVar = dVar.cRf;
                        eVar.cRv.append(com.tencent.matrix.g.d.formatTime(SQLiteLintUtil.YYYY_MM_DD_HH_mm, j2)).append(" onReleaseWakeLock token:").append(iBinder.toString()).append(" flags:").append(i2).append("\n\n");
                        eVar.cRu++;
                        eVar.RY();
                    }
                    String obj = iBinder.toString();
                    if (dVar.cQY.containsKey(obj)) {
                        String str = dVar.cQY.get(obj).tag;
                        if (dVar.cQZ.containsKey(str)) {
                            d.c cVar = dVar.cQZ.get(str);
                            cVar.RX();
                            cVar.cRo.remove(obj);
                            if (cVar.cRo.isEmpty()) {
                                z = false;
                            }
                            if (!z) {
                                cVar.cRp = -1;
                            }
                        }
                    } else {
                        com.tencent.matrix.g.c.i("Matrix.detector.WakeLock", "onReleaseWakeLock not in mWakeLockInfoMap: %s", obj);
                    }
                    dVar.RU();
                    dVar.cQY.remove(obj);
                }
            });
        }
    }

    @Override // com.tencent.matrix.report.d.a
    public final void onDetectIssue(com.tencent.matrix.report.c cVar) {
        this.cQI.onDetectIssue(cVar);
    }

    @Override // com.tencent.matrix.a.c.a.b
    public final void a(final int i2, final long j2, final long j3, final long j4, final int i3, final PendingIntent pendingIntent, final AlarmManager.OnAlarmListener onAlarmListener) {
        if (this.cQK != null) {
            final String throwableStack = com.tencent.matrix.a.c.c.getThrowableStack(new Throwable());
            this.cQH.q(new Runnable() {
                /* class com.tencent.matrix.a.a.c.AnonymousClass5 */

                public final void run() {
                    a aVar = c.this.cQK;
                    int i2 = i2;
                    long j2 = j2;
                    long j3 = j3;
                    long j4 = j4;
                    int i3 = i3;
                    PendingIntent pendingIntent = pendingIntent;
                    AlarmManager.OnAlarmListener onAlarmListener = onAlarmListener;
                    String str = throwableStack;
                    if (aVar.cQp) {
                        com.tencent.matrix.g.c.i("MicroMsg.AlarmDetector", "in foreground, ignore alarm event", new Object[0]);
                        return;
                    }
                    if (aVar.cQm != null) {
                        a.b bVar = aVar.cQm;
                        try {
                            Object[] objArr = new Object[11];
                            objArr[0] = com.tencent.matrix.g.d.formatTime(SQLiteLintUtil.YYYY_MM_DD_HH_mm, System.currentTimeMillis());
                            objArr[1] = Integer.valueOf(i2);
                            objArr[2] = Long.valueOf(j2);
                            objArr[3] = Long.valueOf(j3);
                            objArr[4] = Long.valueOf(j4);
                            objArr[5] = Integer.valueOf(i3);
                            objArr[6] = pendingIntent;
                            objArr[7] = Integer.valueOf(pendingIntent == null ? -1 : pendingIntent.hashCode());
                            objArr[8] = onAlarmListener;
                            objArr[9] = Integer.valueOf(onAlarmListener == null ? -1 : onAlarmListener.hashCode());
                            objArr[10] = str;
                            bVar.ej(String.format("%s onAlarmSet type:%d triggerAtMillis:%d windowMillis:%d intervalMillis:%d flags:%d operationInfo:%s operationHashCode:%d onAlarmListener:%s onAlarmListenerHashCode:%d\n%s\n\n", objArr));
                        } catch (ClassCastException e2) {
                            com.tencent.matrix.g.c.e("MicroMsg.AlarmDetector", e2.toString(), new Object[0]);
                        }
                    }
                    a.C0202a aVar2 = new a.C0202a(i2, j2, j4, pendingIntent, onAlarmListener, str);
                    aVar.a(aVar2.cQt, aVar2.cQs);
                    aVar.cQn.add(aVar2);
                    aVar.RO();
                }
            });
        }
    }

    @Override // com.tencent.matrix.a.c.a.b
    public final void a(final PendingIntent pendingIntent, final AlarmManager.OnAlarmListener onAlarmListener) {
        if (this.cQK != null) {
            final String throwableStack = com.tencent.matrix.a.c.c.getThrowableStack(new Throwable());
            this.cQH.q(new Runnable() {
                /* class com.tencent.matrix.a.a.c.AnonymousClass6 */

                public final void run() {
                    int hashCode;
                    int i2 = -1;
                    a aVar = c.this.cQK;
                    PendingIntent pendingIntent = pendingIntent;
                    AlarmManager.OnAlarmListener onAlarmListener = onAlarmListener;
                    String str = throwableStack;
                    if (aVar.cQm != null) {
                        a.b bVar = aVar.cQm;
                        try {
                            Object[] objArr = new Object[6];
                            objArr[0] = com.tencent.matrix.g.d.formatTime(SQLiteLintUtil.YYYY_MM_DD_HH_mm, System.currentTimeMillis());
                            objArr[1] = pendingIntent;
                            if (pendingIntent == null) {
                                hashCode = -1;
                            } else {
                                hashCode = pendingIntent.hashCode();
                            }
                            objArr[2] = Integer.valueOf(hashCode);
                            objArr[3] = onAlarmListener;
                            if (onAlarmListener != null) {
                                i2 = onAlarmListener.hashCode();
                            }
                            objArr[4] = Integer.valueOf(i2);
                            objArr[5] = str;
                            bVar.ej(String.format("%s onAlarmRemove operationInfo:%s operationHashCode:%d onAlarmListener:%s onAlarmListenerHashCode:%d\n%s\n\n", objArr));
                        } catch (ClassCastException e2) {
                            com.tencent.matrix.g.c.e("MicroMsg.AlarmDetector", e2.toString(), new Object[0]);
                        }
                    }
                    aVar.a(onAlarmListener, new a.e(pendingIntent));
                    if (!aVar.cQp) {
                        aVar.RO();
                    }
                }
            });
        }
    }
}
