package android.support.v4.e;

import com.tencent.thumbplayer.core.thirdparties.LocalCache;
import java.io.PrintWriter;

public final class p {
    private static final Object Pj = new Object();
    private static char[] Pk = new char[24];

    private static int a(char[] cArr, int i2, char c2, int i3, boolean z) {
        int i4;
        int i5;
        if (!z && i2 <= 0) {
            return i3;
        }
        if (i2 > 99) {
            int i6 = i2 / 100;
            cArr[i3] = (char) (i6 + 48);
            i4 = i3 + 1;
            i5 = i2 - (i6 * 100);
        } else {
            i4 = i3;
            i5 = i2;
        }
        if (i5 > 9 || i3 != i4) {
            int i7 = i5 / 10;
            cArr[i4] = (char) (i7 + 48);
            i4++;
            i5 -= i7 * 10;
        }
        cArr[i4] = (char) (i5 + 48);
        int i8 = i4 + 1;
        cArr[i8] = c2;
        return i8 + 1;
    }

    private static void a(long j2, PrintWriter printWriter) {
        char c2;
        int i2;
        int i3;
        int i4;
        boolean z;
        boolean z2 = true;
        int i5 = 1;
        synchronized (Pj) {
            if (Pk.length < 0) {
                Pk = new char[0];
            }
            char[] cArr = Pk;
            if (j2 == 0) {
                cArr[0] = '0';
            } else {
                if (j2 > 0) {
                    c2 = '+';
                } else {
                    j2 = -j2;
                    c2 = '-';
                }
                int i6 = (int) (j2 % 1000);
                int floor = (int) Math.floor((double) (j2 / 1000));
                if (floor > 86400) {
                    int i7 = floor / LocalCache.TIME_DAY;
                    floor -= i7 * LocalCache.TIME_DAY;
                    i2 = i7;
                } else {
                    i2 = 0;
                }
                if (floor > 3600) {
                    int i8 = floor / LocalCache.TIME_HOUR;
                    floor -= i8 * LocalCache.TIME_HOUR;
                    i3 = i8;
                } else {
                    i3 = 0;
                }
                if (floor > 60) {
                    int i9 = floor / 60;
                    floor -= i9 * 60;
                    i4 = i9;
                } else {
                    i4 = 0;
                }
                cArr[0] = c2;
                int a2 = a(cArr, i2, 'd', 1, false);
                int a3 = a(cArr, i3, 'h', a2, a2 != 1);
                if (a3 != 1) {
                    z = true;
                } else {
                    z = false;
                }
                int a4 = a(cArr, i4, 'm', a3, z);
                if (a4 == 1) {
                    z2 = false;
                }
                int a5 = a(cArr, i6, 'm', a(cArr, floor, 's', a4, z2), true);
                cArr[a5] = 's';
                i5 = a5 + 1;
            }
            printWriter.print(new String(Pk, 0, i5));
        }
    }

    public static void b(long j2, PrintWriter printWriter) {
        a(j2, printWriter);
    }

    public static void a(long j2, long j3, PrintWriter printWriter) {
        if (j2 == 0) {
            printWriter.print("--");
        } else {
            a(j2 - j3, printWriter);
        }
    }
}
