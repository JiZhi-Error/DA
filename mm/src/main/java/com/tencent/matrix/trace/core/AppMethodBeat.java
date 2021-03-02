package com.tencent.matrix.trace.core;

import android.app.Activity;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.matrix.g.c;
import com.tencent.matrix.trace.core.a;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AppMethodBeat {
    public static final int METHOD_ID_DISPATCH = 1048574;
    private static final int METHOD_ID_MAX = 1048575;
    private static final int STATUS_DEFAULT = Integer.MAX_VALUE;
    private static final int STATUS_EXPIRED_START = -2;
    private static final int STATUS_OUT_RELEASE = -3;
    private static final int STATUS_READY = 1;
    private static final int STATUS_STARTED = 2;
    private static final int STATUS_STOPPED = -1;
    private static final String TAG = "Matrix.AppMethodBeat";
    private static boolean assertIn = false;
    private static Runnable checkStartExpiredRunnable = null;
    public static boolean isDev = false;
    private static volatile boolean isPauseUpdateTime = false;
    private static final HashSet<com.tencent.matrix.trace.e.a> listeners = new HashSet<>();
    private static a.AbstractC0235a looperMonitorListener = new a.AbstractC0235a() {
        /* class com.tencent.matrix.trace.core.AppMethodBeat.AnonymousClass1 */

        @Override // com.tencent.matrix.trace.core.a.AbstractC0235a
        public final boolean isValid() {
            return AppMethodBeat.status > 0;
        }

        @Override // com.tencent.matrix.trace.core.a.AbstractC0235a
        public final void dispatchStart() {
            super.dispatchStart();
            AppMethodBeat.dispatchBegin();
        }

        @Override // com.tencent.matrix.trace.core.a.AbstractC0235a
        public final void dispatchEnd() {
            super.dispatchEnd();
            AppMethodBeat.dispatchEnd();
        }
    };
    private static long[] sBuffer = new long[1000000];
    private static volatile long sCurrentDiffTime;
    private static volatile long sDiffTime;
    private static Set<String> sFocusActivitySet = new HashSet();
    private static Handler sHandler = new Handler(sTimerUpdateThread.getLooper());
    private static int sIndex = 0;
    private static a sIndexRecordHead = null;
    private static AppMethodBeat sInstance = new AppMethodBeat();
    private static int sLastIndex = -1;
    private static long sMainThreadId = Looper.getMainLooper().getThread().getId();
    public static b sMethodEnterListener;
    private static HandlerThread sTimerUpdateThread = com.tencent.matrix.g.b.eS("matrix_time_update_thread");
    private static Runnable sUpdateDiffTimeRunnable = new Runnable() {
        /* class com.tencent.matrix.trace.core.AppMethodBeat.AnonymousClass3 */

        public final void run() {
            while (true) {
                try {
                    if (AppMethodBeat.isPauseUpdateTime || AppMethodBeat.status < 0) {
                        synchronized (AppMethodBeat.updateTimeLock) {
                            AppMethodBeat.updateTimeLock.wait();
                        }
                    } else {
                        long unused = AppMethodBeat.sCurrentDiffTime = SystemClock.uptimeMillis() - AppMethodBeat.sDiffTime;
                        SystemClock.sleep(5);
                    }
                } catch (Exception e2) {
                    c.e(AppMethodBeat.TAG, e2.toString(), new Object[0]);
                    return;
                }
            }
        }
    };
    private static volatile int status = Integer.MAX_VALUE;
    private static final Object statusLock = new Object();
    private static final Object updateTimeLock = new Object();

    public interface b {
        void t(int i2, long j2);
    }

    static {
        long uptimeMillis = SystemClock.uptimeMillis();
        sCurrentDiffTime = uptimeMillis;
        sDiffTime = uptimeMillis;
        sHandler.postDelayed(new Runnable() {
            /* class com.tencent.matrix.trace.core.AppMethodBeat.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.realRelease();
            }
        }, 15000);
    }

    public static AppMethodBeat getInstance() {
        return sInstance;
    }

    public void onStart() {
        synchronized (statusLock) {
            if (status >= 2 || status < -2) {
                c.w(TAG, "[onStart] current status:%s", Integer.valueOf(status));
            } else {
                sHandler.removeCallbacks(checkStartExpiredRunnable);
                if (sBuffer == null) {
                    throw new RuntimeException("Matrix.AppMethodBeat sBuffer == null");
                }
                c.i(TAG, "[onStart] preStatus:%s", Integer.valueOf(status), com.tencent.matrix.trace.g.b.getStack());
                status = 2;
            }
        }
    }

    public void onStop() {
        synchronized (statusLock) {
            if (status == 2) {
                c.i(TAG, "[onStop] %s", com.tencent.matrix.trace.g.b.getStack());
                status = -1;
            } else {
                c.w(TAG, "[onStop] current status:%s", Integer.valueOf(status));
            }
        }
    }

    public boolean isAlive() {
        return status >= 2;
    }

    public static boolean isRealTrace() {
        return status > 0;
    }

    /* access modifiers changed from: private */
    public static void realRelease() {
        synchronized (statusLock) {
            if (status == Integer.MAX_VALUE) {
                c.i(TAG, "[realRelease] timestamp:%s", Long.valueOf(System.currentTimeMillis()));
                sHandler.removeCallbacksAndMessages(null);
                a.b(looperMonitorListener);
                sTimerUpdateThread.quit();
                sBuffer = null;
                status = -3;
            }
        }
    }

    private static void realExecute() {
        c.i(TAG, "[realExecute] timestamp:%s", Long.valueOf(System.currentTimeMillis()));
        sCurrentDiffTime = SystemClock.uptimeMillis() - sDiffTime;
        sHandler.removeCallbacksAndMessages(null);
        sHandler.postDelayed(sUpdateDiffTimeRunnable, 5);
        Handler handler = sHandler;
        AnonymousClass4 r1 = new Runnable() {
            /* class com.tencent.matrix.trace.core.AppMethodBeat.AnonymousClass4 */

            public final void run() {
                synchronized (AppMethodBeat.statusLock) {
                    c.i(AppMethodBeat.TAG, "[startExpired] timestamp:%s status:%s", Long.valueOf(System.currentTimeMillis()), Integer.valueOf(AppMethodBeat.status));
                    if (AppMethodBeat.status == Integer.MAX_VALUE || AppMethodBeat.status == 1) {
                        int unused = AppMethodBeat.status = -2;
                    }
                }
            }
        };
        checkStartExpiredRunnable = r1;
        handler.postDelayed(r1, 15000);
        com.tencent.matrix.trace.c.a.Tx();
        a.a(looperMonitorListener);
    }

    /* access modifiers changed from: private */
    public static void dispatchBegin() {
        sCurrentDiffTime = SystemClock.uptimeMillis() - sDiffTime;
        isPauseUpdateTime = false;
        synchronized (updateTimeLock) {
            updateTimeLock.notify();
        }
    }

    /* access modifiers changed from: private */
    public static void dispatchEnd() {
        isPauseUpdateTime = true;
    }

    public static void i(int i2) {
        if (status >= 0 && i2 < METHOD_ID_MAX) {
            if (status == Integer.MAX_VALUE) {
                synchronized (statusLock) {
                    if (status == Integer.MAX_VALUE) {
                        realExecute();
                        status = 1;
                    }
                }
            }
            long id = Thread.currentThread().getId();
            if (sMethodEnterListener != null) {
                sMethodEnterListener.t(i2, id);
            }
            if (id == sMainThreadId && !assertIn) {
                assertIn = true;
                if (sIndex < 1000000) {
                    mergeData(i2, sIndex, true);
                } else {
                    sIndex = 0;
                    mergeData(i2, sIndex, true);
                }
                sIndex++;
                assertIn = false;
            }
        }
    }

    public static void o(int i2) {
        if (status >= 0 && i2 < METHOD_ID_MAX && Thread.currentThread().getId() == sMainThreadId) {
            if (sIndex < 1000000) {
                mergeData(i2, sIndex, false);
            } else {
                sIndex = 0;
                mergeData(i2, sIndex, false);
            }
            sIndex++;
        }
    }

    public static void at(Activity activity, boolean z) {
        String name = activity.getClass().getName();
        if (z) {
            if (sFocusActivitySet.add(name)) {
                synchronized (listeners) {
                    Iterator<com.tencent.matrix.trace.e.a> it = listeners.iterator();
                    while (it.hasNext()) {
                        it.next().n(activity);
                    }
                }
                c.i(TAG, "[at] visibleScene[%s] has %s focus!", getVisibleScene(), "attach");
            }
        } else if (sFocusActivitySet.remove(name)) {
            c.i(TAG, "[at] visibleScene[%s] has %s focus!", getVisibleScene(), "detach");
        }
    }

    public static String getVisibleScene() {
        return com.tencent.matrix.a.INSTANCE.cPC;
    }

    private static void mergeData(int i2, int i3, boolean z) {
        if (i2 == 1048574) {
            sCurrentDiffTime = SystemClock.uptimeMillis() - sDiffTime;
        }
        long j2 = 0;
        if (z) {
            j2 = Long.MIN_VALUE;
        }
        sBuffer[i3] = j2 | (((long) i2) << 43) | (sCurrentDiffTime & 8796093022207L);
        checkPileup(i3);
        sLastIndex = i3;
    }

    public void addListener(com.tencent.matrix.trace.e.a aVar) {
        synchronized (listeners) {
            listeners.add(aVar);
        }
    }

    public void removeListener(com.tencent.matrix.trace.e.a aVar) {
        synchronized (listeners) {
            listeners.remove(aVar);
        }
    }

    public a maskIndex(String str) {
        if (sIndexRecordHead == null) {
            a aVar = new a(sIndex - 1);
            sIndexRecordHead = aVar;
            aVar.source = str;
            return sIndexRecordHead;
        }
        a aVar2 = new a(sIndex - 1);
        aVar2.source = str;
        a aVar3 = null;
        for (a aVar4 = sIndexRecordHead; aVar4 != null; aVar4 = aVar4.daY) {
            if (aVar2.index > aVar4.index) {
                aVar3 = aVar4;
            } else if (aVar3 == null) {
                a aVar5 = sIndexRecordHead;
                sIndexRecordHead = aVar2;
                aVar2.daY = aVar5;
                return aVar2;
            } else {
                a aVar6 = aVar3.daY;
                aVar3.daY = aVar2;
                aVar2.daY = aVar6;
                return aVar2;
            }
        }
        aVar3.daY = aVar2;
        return aVar2;
    }

    private static void checkPileup(int i2) {
        a aVar = sIndexRecordHead;
        while (aVar != null) {
            if (aVar.index == i2 || (aVar.index == -1 && sLastIndex == 999999)) {
                aVar.daZ = false;
                c.w(TAG, "[checkPileup] %s", aVar.toString());
                aVar = aVar.daY;
                sIndexRecordHead = aVar;
            } else {
                return;
            }
        }
    }

    public static final class a {
        a daY;
        public boolean daZ;
        public int index;
        public String source;

        public a(int i2) {
            this.daZ = true;
            this.index = i2;
        }

        public a() {
            this.daZ = true;
            this.daZ = false;
        }

        public final void release() {
            this.daZ = false;
            a aVar = null;
            for (a aVar2 = AppMethodBeat.sIndexRecordHead; aVar2 != null; aVar2 = aVar2.daY) {
                if (aVar2 == this) {
                    if (aVar != null) {
                        aVar.daY = aVar2.daY;
                    } else {
                        a unused = AppMethodBeat.sIndexRecordHead = aVar2.daY;
                    }
                    aVar2.daY = null;
                    return;
                }
                aVar = aVar2;
            }
        }

        public final String toString() {
            return "index:" + this.index + ",\tisValid:" + this.daZ + " source:" + this.source;
        }
    }

    public long[] copyData(a aVar) {
        return copyData(aVar, new a(sIndex - 1));
    }

    private long[] copyData(a aVar, a aVar2) {
        long currentTimeMillis = System.currentTimeMillis();
        long[] jArr = new long[0];
        try {
            if (!aVar.daZ || !aVar2.daZ) {
                c.i(TAG, "[copyData] [%s:%s] length:%s cost:%sms", Integer.valueOf(Math.max(0, aVar.index)), Integer.valueOf(aVar2.index), 0, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                return jArr;
            }
            int max = Math.max(0, aVar.index);
            int max2 = Math.max(0, aVar2.index);
            if (max2 > max) {
                int i2 = (max2 - max) + 1;
                jArr = new long[i2];
                System.arraycopy(sBuffer, max, jArr, 0, i2);
            } else if (max2 < max) {
                jArr = new long[(max2 + 1 + (sBuffer.length - max))];
                System.arraycopy(sBuffer, max, jArr, 0, sBuffer.length - max);
                System.arraycopy(sBuffer, 0, jArr, sBuffer.length - max, max2 + 1);
            }
            c.i(TAG, "[copyData] [%s:%s] length:%s cost:%sms", Integer.valueOf(Math.max(0, aVar.index)), Integer.valueOf(aVar2.index), Integer.valueOf(jArr.length), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            return jArr;
        } catch (OutOfMemoryError e2) {
            c.e(TAG, e2.toString(), new Object[0]);
            c.i(TAG, "[copyData] [%s:%s] length:%s cost:%sms", Integer.valueOf(Math.max(0, aVar.index)), Integer.valueOf(aVar2.index), Integer.valueOf(jArr.length), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        } catch (Throwable th) {
            c.i(TAG, "[copyData] [%s:%s] length:%s cost:%sms", Integer.valueOf(Math.max(0, aVar.index)), Integer.valueOf(aVar2.index), Integer.valueOf(jArr.length), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            throw th;
        }
    }

    public static long getDiffTime() {
        return sDiffTime;
    }

    public void printIndexRecord() {
        StringBuilder sb = new StringBuilder(" \n");
        for (a aVar = sIndexRecordHead; aVar != null; aVar = aVar.daY) {
            sb.append(aVar).append("\n");
        }
        c.i(TAG, "[printIndexRecord] %s", sb.toString());
    }
}
