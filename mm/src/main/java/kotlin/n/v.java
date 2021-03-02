package kotlin.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0006\u001a\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\t\u001a\u0013\u0010\n\u001a\u0004\u0018\u00010\b*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u000b\u001a\u001b\u0010\n\u001a\u0004\u0018\u00010\b*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\f\u001a\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u000f\u001a\u001b\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\u0010\u001a\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0013\u001a\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u0012*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, hxF = {"numberFormatError", "", "input", "", "toByteOrNull", "", "(Ljava/lang/String;)Ljava/lang/Byte;", "radix", "", "(Ljava/lang/String;I)Ljava/lang/Byte;", "toIntOrNull", "(Ljava/lang/String;)Ljava/lang/Integer;", "(Ljava/lang/String;I)Ljava/lang/Integer;", "toLongOrNull", "", "(Ljava/lang/String;)Ljava/lang/Long;", "(Ljava/lang/String;I)Ljava/lang/Long;", "toShortOrNull", "", "(Ljava/lang/String;)Ljava/lang/Short;", "(Ljava/lang/String;I)Ljava/lang/Short;", "kotlin-stdlib"}, hxG = 1)
public class v extends u {
    public static final Integer buA(String str) {
        AppMethodBeat.i(129444);
        p.h(str, "$this$toIntOrNull");
        Integer hT = n.hT(str, 10);
        AppMethodBeat.o(129444);
        return hT;
    }

    public static final Integer hT(String str, int i2) {
        int i3;
        boolean z;
        int i4;
        int i5 = -2147483647;
        int i6 = 0;
        AppMethodBeat.i(129445);
        p.h(str, "$this$toIntOrNull");
        a.avR(i2);
        int length = str.length();
        if (length == 0) {
            AppMethodBeat.o(129445);
            return null;
        }
        char charAt = str.charAt(0);
        if (charAt >= '0') {
            i3 = 0;
            z = false;
        } else if (length == 1) {
            AppMethodBeat.o(129445);
            return null;
        } else if (charAt == '-') {
            i5 = Integer.MIN_VALUE;
            i3 = 1;
            z = true;
        } else if (charAt == '+') {
            i3 = 1;
            z = false;
        } else {
            AppMethodBeat.o(129445);
            return null;
        }
        int i7 = -59652323;
        int i8 = i3;
        while (i8 < length) {
            int digit = Character.digit((int) str.charAt(i8), i2);
            if (digit < 0) {
                AppMethodBeat.o(129445);
                return null;
            }
            if (i6 >= i7) {
                i4 = i7;
            } else if (i7 == -59652323) {
                i4 = i5 / i2;
                if (i6 < i4) {
                    AppMethodBeat.o(129445);
                    return null;
                }
            } else {
                AppMethodBeat.o(129445);
                return null;
            }
            int i9 = i6 * i2;
            if (i9 < i5 + digit) {
                AppMethodBeat.o(129445);
                return null;
            }
            i6 = i9 - digit;
            i8++;
            i7 = i4;
        }
        if (z) {
            Integer valueOf = Integer.valueOf(i6);
            AppMethodBeat.o(129445);
            return valueOf;
        }
        Integer valueOf2 = Integer.valueOf(-i6);
        AppMethodBeat.o(129445);
        return valueOf2;
    }

    public static final Long buB(String str) {
        AppMethodBeat.i(129446);
        p.h(str, "$this$toLongOrNull");
        Long hU = n.hU(str, 10);
        AppMethodBeat.o(129446);
        return hU;
    }

    public static final Long hU(String str, int i2) {
        int i3;
        boolean z;
        long j2;
        long j3 = -9223372036854775807L;
        AppMethodBeat.i(129447);
        p.h(str, "$this$toLongOrNull");
        a.avR(i2);
        int length = str.length();
        if (length == 0) {
            AppMethodBeat.o(129447);
            return null;
        }
        char charAt = str.charAt(0);
        if (charAt >= '0') {
            i3 = 0;
            z = false;
        } else if (length == 1) {
            AppMethodBeat.o(129447);
            return null;
        } else if (charAt == '-') {
            j3 = Long.MIN_VALUE;
            i3 = 1;
            z = true;
        } else if (charAt == '+') {
            i3 = 1;
            z = false;
        } else {
            AppMethodBeat.o(129447);
            return null;
        }
        long j4 = -256204778801521550L;
        long j5 = 0;
        int i4 = i3;
        while (i4 < length) {
            int digit = Character.digit((int) str.charAt(i4), i2);
            if (digit < 0) {
                AppMethodBeat.o(129447);
                return null;
            }
            if (j5 >= j4) {
                j2 = j4;
            } else if (j4 == -256204778801521550L) {
                j2 = j3 / ((long) i2);
                if (j5 < j2) {
                    AppMethodBeat.o(129447);
                    return null;
                }
            } else {
                AppMethodBeat.o(129447);
                return null;
            }
            long j6 = ((long) i2) * j5;
            if (j6 < ((long) digit) + j3) {
                AppMethodBeat.o(129447);
                return null;
            }
            j5 = j6 - ((long) digit);
            i4++;
            j4 = j2;
        }
        if (z) {
            Long valueOf = Long.valueOf(j5);
            AppMethodBeat.o(129447);
            return valueOf;
        }
        Long valueOf2 = Long.valueOf(-j5);
        AppMethodBeat.o(129447);
        return valueOf2;
    }
}
