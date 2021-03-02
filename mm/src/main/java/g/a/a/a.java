package g.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class a {
    public static int nh(int i2, int i3) {
        AppMethodBeat.i(2395);
        int fS = g.a.a.b.b.a.fS(i2) + g.a.a.b.b.a.fY(i3) + i3;
        AppMethodBeat.o(2395);
        return fS;
    }

    public static int c(int i2, int i3, LinkedList<?> linkedList) {
        int i4;
        AppMethodBeat.i(2396);
        if (linkedList != null) {
            switch (i3) {
                case 1:
                    i4 = 0;
                    int i5 = 0;
                    while (i5 < linkedList.size()) {
                        i5++;
                        i4 = g.a.a.b.b.a.f(i2, (String) linkedList.get(i5)) + i4;
                    }
                    break;
                case 2:
                    i4 = 0;
                    int i6 = 0;
                    while (i6 < linkedList.size()) {
                        i6++;
                        i4 = g.a.a.b.b.a.bu(i2, ((Integer) linkedList.get(i6)).intValue()) + i4;
                    }
                    break;
                case 3:
                    i4 = 0;
                    int i7 = 0;
                    while (i7 < linkedList.size()) {
                        i7++;
                        i4 = g.a.a.b.b.a.r(i2, ((Long) linkedList.get(i7)).longValue()) + i4;
                    }
                    break;
                case 4:
                    i4 = 0;
                    int i8 = 0;
                    while (i8 < linkedList.size()) {
                        ((Double) linkedList.get(i8)).doubleValue();
                        i8++;
                        i4 = g.a.a.b.b.a.fS(i2) + 8 + i4;
                    }
                    break;
                case 5:
                    i4 = 0;
                    int i9 = 0;
                    while (i9 < linkedList.size()) {
                        ((Float) linkedList.get(i9)).floatValue();
                        i9++;
                        i4 = g.a.a.b.b.a.fS(i2) + 4 + i4;
                    }
                    break;
                case 6:
                    i4 = 0;
                    int i10 = 0;
                    while (i10 < linkedList.size()) {
                        i10++;
                        i4 = g.a.a.b.b.a.b(i2, (b) linkedList.get(i10)) + i4;
                    }
                    break;
                case 7:
                    i4 = 0;
                    int i11 = 0;
                    while (i11 < linkedList.size()) {
                        ((Boolean) linkedList.get(i11)).booleanValue();
                        i11++;
                        i4 = g.a.a.b.b.a.fS(i2) + 1 + i4;
                    }
                    break;
                case 8:
                    i4 = 0;
                    int i12 = 0;
                    while (i12 < linkedList.size()) {
                        i12++;
                        i4 = nh(i2, ((com.tencent.mm.bw.a) linkedList.get(i12)).computeSize()) + i4;
                    }
                    break;
                default:
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("The data type was not found, the id used was ".concat(String.valueOf(i3)));
                    AppMethodBeat.o(2396);
                    throw illegalArgumentException;
            }
        } else {
            i4 = 0;
        }
        AppMethodBeat.o(2396);
        return i4;
    }

    public static int d(int i2, int i3, LinkedList<?> linkedList) {
        int i4 = 0;
        AppMethodBeat.i(2397);
        if (linkedList != null) {
            switch (i3) {
                case 2:
                    if (linkedList.size() > 0) {
                        int i5 = 0;
                        int i6 = 0;
                        while (i6 < linkedList.size()) {
                            i6++;
                            i5 = g.a.a.b.b.a.fY(((Integer) linkedList.get(i6)).intValue()) + i5;
                        }
                        i4 = g.a.a.b.b.a.fY(i5) + i5 + g.a.a.b.b.a.fS(i2);
                        break;
                    }
                    break;
                case 3:
                    if (linkedList.size() > 0) {
                        int i7 = 0;
                        int i8 = 0;
                        while (i8 < linkedList.size()) {
                            i8++;
                            i7 = g.a.a.b.b.a.aK(((Long) linkedList.get(i8)).longValue()) + i7;
                        }
                        i4 = g.a.a.b.b.a.fY(i7) + i7 + g.a.a.b.b.a.fS(i2);
                        break;
                    }
                    break;
                default:
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("The data type was not found, the id used was ".concat(String.valueOf(i3)));
                    AppMethodBeat.o(2397);
                    throw illegalArgumentException;
            }
        }
        AppMethodBeat.o(2397);
        return i4;
    }

    public static int f(int i2, LinkedList<?> linkedList) {
        int i3 = 0;
        AppMethodBeat.i(2398);
        if (linkedList != null) {
            switch (i2) {
                case 2:
                    if (linkedList.size() > 0) {
                        int i4 = 0;
                        int i5 = 0;
                        while (i5 < linkedList.size()) {
                            i5++;
                            i4 = g.a.a.b.b.a.fY(((Integer) linkedList.get(i5)).intValue()) + i4;
                        }
                        i3 = i4;
                        break;
                    }
                    break;
                case 3:
                    if (linkedList.size() > 0) {
                        int i6 = 0;
                        int i7 = 0;
                        while (i7 < linkedList.size()) {
                            i7++;
                            i6 = g.a.a.b.b.a.aK(((Long) linkedList.get(i7)).longValue()) + i6;
                        }
                        i3 = i6;
                        break;
                    }
                    break;
                default:
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("The data type was not found, the id used was ".concat(String.valueOf(i2)));
                    AppMethodBeat.o(2398);
                    throw illegalArgumentException;
            }
        }
        AppMethodBeat.o(2398);
        return i3;
    }
}
