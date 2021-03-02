package com.tencent.mm.normsg;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.concurrent.CountDownLatch;

final class c {
    c() {
    }

    public static final class p {
        public static native byte[] aa(int i2, int i3);

        public static native boolean ab();

        public static native String ac(String str, boolean z);

        public static native byte[] ad();

        public static native byte[] ae(int i2);

        public static native byte[] af(int i2);

        public static native boolean ag();

        public static native boolean ah();

        public static native boolean ai();

        public static native boolean aj();

        static native void ak();

        public static native boolean al();

        static native String ba(int i2);

        static native String bb(int i2);

        static native boolean bc(int i2, byte[] bArr, int i3, int i4, PValue<Integer> pValue, PValue<Integer> pValue2, PValue<byte[]> pValue3);

        static native boolean bd(byte[] bArr, int i2, int i3, PValue<byte[]> pValue, PValue<byte[]> pValue2);

        static native boolean be(byte[] bArr, int i2, int i3, PValue<byte[]> pValue, PValue<byte[]> pValue2);

        public static native boolean ca(Object obj, Class<?> cls);

        public static native boolean cb(Object obj);

        public static native void da(String str);

        public static native void db(String str);

        public static native void dc(String str);

        public static native boolean dd(String str);

        public static native byte[] de(String str);

        public static native void df(String str, String str2, String str3);

        public static native void dg(String str, MotionEvent motionEvent);

        public static native void dh(String str);

        public static native boolean di(String str);

        public static native byte[] dj(String str);

        public static native String dk(String str);

        public static native byte[] ea(int i2, int i3);

        public static native boolean eb(byte[] bArr, int i2, int i3);

        public static native boolean ec();

        static native byte[] ed();

        public static native byte[] ee();

        public static native String ef();

        public static native String eg();

        public static native String eh();

        public static native void fa(String str, int i2, int i3);

        public static native void fb(int i2, List<b> list);

        public static native boolean fc();

        public static native void fd();

        public static native void fe(int i2);

        public static native void ff(int i2);

        public static native boolean fg(String str);

        public static native void fh(String str);

        public static native byte[] fi(String str);

        public static native void fj(String str);

        public static native void fk();

        public static native int fl(String str);

        p() {
        }

        static {
            AppMethodBeat.i(62426);
            final String sb = new StringBuilder("tahcew").reverse().append(new StringBuilder("gsmron").reverse().toString()).toString();
            if (Process.myPid() == Process.myTid()) {
                System.loadLibrary(sb);
                AppMethodBeat.o(62426);
                return;
            }
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            new Handler(Looper.getMainLooper()).postAtFrontOfQueue(new Runnable() {
                /* class com.tencent.mm.normsg.c.p.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(62425);
                    System.loadLibrary(sb);
                    countDownLatch.countDown();
                    AppMethodBeat.o(62425);
                }
            });
            try {
                countDownLatch.await();
                AppMethodBeat.o(62426);
            } catch (Throwable th) {
                AppMethodBeat.o(62426);
            }
        }
    }

    public static final class q {
        private static volatile a jGG = null;

        q() {
        }

        public static synchronized void c0(a aVar) {
            synchronized (q.class) {
                jGG = aVar;
            }
        }

        static synchronized String c1() {
            String str;
            synchronized (q.class) {
                AppMethodBeat.i(62427);
                if (jGG != null) {
                    str = jGG.bkv();
                    AppMethodBeat.o(62427);
                } else {
                    str = "";
                    AppMethodBeat.o(62427);
                }
            }
            return str;
        }

        static synchronized long c2() {
            long j2;
            synchronized (q.class) {
                AppMethodBeat.i(62428);
                if (jGG != null) {
                    j2 = jGG.bkw();
                    AppMethodBeat.o(62428);
                } else {
                    j2 = 0;
                    AppMethodBeat.o(62428);
                }
            }
            return j2;
        }

        static synchronized void c3(int i2, String str) {
            synchronized (q.class) {
                AppMethodBeat.i(62429);
                if (jGG != null) {
                    jGG.R(i2, str);
                }
                AppMethodBeat.o(62429);
            }
        }

        static synchronized void c4(int i2, int i3, int i4) {
            synchronized (q.class) {
                AppMethodBeat.i(62430);
                if (jGG != null) {
                    jGG.O(i2, i3, i4);
                }
                AppMethodBeat.o(62430);
            }
        }

        static synchronized void c5(int i2, int i3, int i4, int i5) {
            synchronized (q.class) {
                AppMethodBeat.i(62431);
                if (jGG != null) {
                    jGG.w(i2, i3, i4, i5);
                }
                AppMethodBeat.o(62431);
            }
        }

        static synchronized String c6() {
            synchronized (q.class) {
            }
            return "";
        }

        static synchronized String c7() {
            String str;
            synchronized (q.class) {
                AppMethodBeat.i(62432);
                if (jGG != null) {
                    str = jGG.bkx();
                    AppMethodBeat.o(62432);
                } else {
                    str = "";
                    AppMethodBeat.o(62432);
                }
            }
            return str;
        }

        private static boolean c8() {
            AppMethodBeat.i(62433);
            if (jGG != null) {
                boolean bky = jGG.bky();
                AppMethodBeat.o(62433);
                return bky;
            }
            AppMethodBeat.o(62433);
            return false;
        }

        private static String c9() {
            AppMethodBeat.i(62434);
            if (jGG != null) {
                String bkz = jGG.bkz();
                AppMethodBeat.o(62434);
                return bkz;
            }
            AppMethodBeat.o(62434);
            return "";
        }

        private static String c10() {
            AppMethodBeat.i(62435);
            if (jGG != null) {
                String deviceId = jGG.getDeviceId();
                AppMethodBeat.o(62435);
                return deviceId;
            }
            AppMethodBeat.o(62435);
            return "";
        }

        private static boolean c11(String str, byte[] bArr) {
            AppMethodBeat.i(62436);
            if (jGG != null) {
                boolean k = jGG.k(str, bArr);
                AppMethodBeat.o(62436);
                return k;
            }
            AppMethodBeat.o(62436);
            return false;
        }

        private static byte[] c12(String str) {
            AppMethodBeat.i(62437);
            if (jGG != null) {
                byte[] RW = jGG.RW(str);
                AppMethodBeat.o(62437);
                return RW;
            }
            byte[] bArr = new byte[0];
            AppMethodBeat.o(62437);
            return bArr;
        }

        private static void c13(String str) {
            AppMethodBeat.i(62438);
            if (jGG != null) {
                jGG.RX(str);
            }
            AppMethodBeat.o(62438);
        }

        private static String c14() {
            AppMethodBeat.i(62439);
            if (jGG != null) {
                String aoK = jGG.aoK();
                AppMethodBeat.o(62439);
                return aoK;
            }
            AppMethodBeat.o(62439);
            return "";
        }

        private static String c15(Context context, String str) {
            AppMethodBeat.i(62440);
            if (jGG != null) {
                String G = jGG.G(context, str);
                AppMethodBeat.o(62440);
                return G;
            }
            AppMethodBeat.o(62440);
            return str;
        }

        private static boolean c16(Context context) {
            AppMethodBeat.i(193639);
            if (jGG != null) {
                boolean dn = jGG.dn(context);
                AppMethodBeat.o(193639);
                return dn;
            }
            AppMethodBeat.o(193639);
            return false;
        }

        private static boolean c17() {
            AppMethodBeat.i(193640);
            if (jGG != null) {
                boolean bkA = jGG.bkA();
                AppMethodBeat.o(193640);
                return bkA;
            }
            AppMethodBeat.o(193640);
            return false;
        }
    }
}
