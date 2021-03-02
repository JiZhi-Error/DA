package com.tencent.mm.normsgext;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CountDownLatch;

final class d {
    d() {
    }

    static final class m {
        static native boolean ba(int i2, byte[] bArr, int i3, int i4, QValue<Integer> qValue, QValue<Integer> qValue2, QValue<byte[]> qValue3);

        m() {
        }

        static {
            AppMethodBeat.i(188585);
            final String sb = new StringBuilder("tahcew").reverse().append(new StringBuilder("txegsmron").reverse().toString()).toString();
            if (Process.myPid() == Process.myTid()) {
                System.loadLibrary(sb);
                AppMethodBeat.o(188585);
                return;
            }
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            new Handler(Looper.getMainLooper()).postAtFrontOfQueue(new Runnable() {
                /* class com.tencent.mm.normsgext.d.m.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(188584);
                    System.loadLibrary(sb);
                    countDownLatch.countDown();
                    AppMethodBeat.o(188584);
                }
            });
            try {
                countDownLatch.await();
                AppMethodBeat.o(188585);
            } catch (Throwable th) {
                AppMethodBeat.o(188585);
            }
        }
    }

    public static final class n {
        private static volatile a jGH = null;

        n() {
        }

        public static synchronized void c0(a aVar) {
            synchronized (n.class) {
                jGH = aVar;
            }
        }

        static synchronized String c1() {
            String str;
            synchronized (n.class) {
                AppMethodBeat.i(188586);
                if (jGH != null) {
                    str = jGH.bkv();
                    AppMethodBeat.o(188586);
                } else {
                    str = "";
                    AppMethodBeat.o(188586);
                }
            }
            return str;
        }

        static synchronized long c2() {
            long j2;
            synchronized (n.class) {
                AppMethodBeat.i(188587);
                if (jGH != null) {
                    j2 = jGH.bkw();
                    AppMethodBeat.o(188587);
                } else {
                    j2 = 0;
                    AppMethodBeat.o(188587);
                }
            }
            return j2;
        }

        static synchronized void c3(int i2, String str) {
            synchronized (n.class) {
                AppMethodBeat.i(188588);
                if (jGH != null) {
                    jGH.R(i2, str);
                }
                AppMethodBeat.o(188588);
            }
        }

        static synchronized void c4(int i2, int i3, int i4) {
            synchronized (n.class) {
                AppMethodBeat.i(188589);
                if (jGH != null) {
                    jGH.O(i2, i3, i4);
                }
                AppMethodBeat.o(188589);
            }
        }

        static synchronized void c5(int i2, int i3, int i4, int i5) {
            synchronized (n.class) {
                AppMethodBeat.i(188590);
                if (jGH != null) {
                    jGH.w(i2, i3, i4, i5);
                }
                AppMethodBeat.o(188590);
            }
        }

        static synchronized String c6() {
            synchronized (n.class) {
            }
            return "";
        }

        static synchronized String c7() {
            String str;
            synchronized (n.class) {
                AppMethodBeat.i(188591);
                if (jGH != null) {
                    str = jGH.bkx();
                    AppMethodBeat.o(188591);
                } else {
                    str = "";
                    AppMethodBeat.o(188591);
                }
            }
            return str;
        }

        private static boolean c8() {
            AppMethodBeat.i(188592);
            if (jGH != null) {
                boolean bky = jGH.bky();
                AppMethodBeat.o(188592);
                return bky;
            }
            AppMethodBeat.o(188592);
            return false;
        }

        private static String c9() {
            AppMethodBeat.i(188593);
            if (jGH != null) {
                String bkz = jGH.bkz();
                AppMethodBeat.o(188593);
                return bkz;
            }
            AppMethodBeat.o(188593);
            return "";
        }

        private static String c10() {
            AppMethodBeat.i(188594);
            if (jGH != null) {
                String deviceId = jGH.getDeviceId();
                AppMethodBeat.o(188594);
                return deviceId;
            }
            AppMethodBeat.o(188594);
            return "";
        }

        private static boolean c11(String str, byte[] bArr) {
            AppMethodBeat.i(188595);
            if (jGH != null) {
                boolean k = jGH.k(str, bArr);
                AppMethodBeat.o(188595);
                return k;
            }
            AppMethodBeat.o(188595);
            return false;
        }

        private static byte[] c12(String str) {
            AppMethodBeat.i(188596);
            if (jGH != null) {
                byte[] RW = jGH.RW(str);
                AppMethodBeat.o(188596);
                return RW;
            }
            byte[] bArr = new byte[0];
            AppMethodBeat.o(188596);
            return bArr;
        }

        private static void c13(String str) {
            AppMethodBeat.i(188597);
            if (jGH != null) {
                jGH.RX(str);
            }
            AppMethodBeat.o(188597);
        }

        private static String c14() {
            AppMethodBeat.i(188598);
            if (jGH != null) {
                String aoK = jGH.aoK();
                AppMethodBeat.o(188598);
                return aoK;
            }
            AppMethodBeat.o(188598);
            return "";
        }

        private static String c15(Context context, String str) {
            AppMethodBeat.i(188599);
            if (jGH != null) {
                String G = jGH.G(context, str);
                AppMethodBeat.o(188599);
                return G;
            }
            AppMethodBeat.o(188599);
            return str;
        }

        private static boolean c16(Context context) {
            AppMethodBeat.i(188600);
            if (jGH != null) {
                boolean dn = jGH.dn(context);
                AppMethodBeat.o(188600);
                return dn;
            }
            AppMethodBeat.o(188600);
            return false;
        }
    }
}
