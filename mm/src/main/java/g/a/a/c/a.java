package g.a.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.io.OutputStream;
import java.util.LinkedList;

public final class a {
    private final byte[] UbU;
    private final g.a.a.b.b.a UbV;
    private final OutputStream output = null;

    public a(byte[] bArr) {
        AppMethodBeat.i(2444);
        this.UbU = bArr;
        this.UbV = new g.a.a.b.b.a(bArr, bArr.length);
        AppMethodBeat.o(2444);
    }

    public final void cc(int i2, boolean z) {
        AppMethodBeat.i(2445);
        this.UbV.r(i2, z);
        AppMethodBeat.o(2445);
    }

    public final void c(int i2, b bVar) {
        AppMethodBeat.i(2446);
        this.UbV.a(i2, bVar);
        AppMethodBeat.o(2446);
    }

    public final void e(int i2, double d2) {
        AppMethodBeat.i(2447);
        this.UbV.e(i2, d2);
        AppMethodBeat.o(2447);
    }

    public final void E(int i2, float f2) {
        AppMethodBeat.i(2448);
        this.UbV.E(i2, f2);
        AppMethodBeat.o(2448);
    }

    public final void aM(int i2, int i3) {
        AppMethodBeat.i(2449);
        this.UbV.bs(i2, i3);
        AppMethodBeat.o(2449);
    }

    public final void bb(int i2, long j2) {
        AppMethodBeat.i(2451);
        this.UbV.q(i2, j2);
        AppMethodBeat.o(2451);
    }

    public final void e(int i2, String str) {
        AppMethodBeat.i(2452);
        this.UbV.e(i2, str);
        AppMethodBeat.o(2452);
    }

    public final void ni(int i2, int i3) {
        AppMethodBeat.i(2453);
        this.UbV.ni(i2, i3);
        AppMethodBeat.o(2453);
    }

    public final void e(int i2, int i3, LinkedList<?> linkedList) {
        int i4 = 0;
        AppMethodBeat.i(2454);
        if (linkedList != null) {
            switch (i3) {
                case 1:
                    while (i4 < linkedList.size()) {
                        e(i2, (String) linkedList.get(i4));
                        i4++;
                    }
                    AppMethodBeat.o(2454);
                    return;
                case 2:
                    while (i4 < linkedList.size()) {
                        aM(i2, ((Integer) linkedList.get(i4)).intValue());
                        i4++;
                    }
                    AppMethodBeat.o(2454);
                    return;
                case 3:
                    while (i4 < linkedList.size()) {
                        bb(i2, ((Long) linkedList.get(i4)).longValue());
                        i4++;
                    }
                    AppMethodBeat.o(2454);
                    return;
                case 4:
                    while (i4 < linkedList.size()) {
                        e(i2, ((Double) linkedList.get(i4)).doubleValue());
                        i4++;
                    }
                    AppMethodBeat.o(2454);
                    return;
                case 5:
                    while (i4 < linkedList.size()) {
                        E(i2, ((Float) linkedList.get(i4)).floatValue());
                        i4++;
                    }
                    AppMethodBeat.o(2454);
                    return;
                case 6:
                    while (i4 < linkedList.size()) {
                        c(i2, (b) linkedList.get(i4));
                        i4++;
                    }
                    AppMethodBeat.o(2454);
                    return;
                case 7:
                    while (i4 < linkedList.size()) {
                        cc(i2, ((Boolean) linkedList.get(i4)).booleanValue());
                        i4++;
                    }
                    AppMethodBeat.o(2454);
                    return;
                case 8:
                    while (i4 < linkedList.size()) {
                        com.tencent.mm.bw.a aVar = (com.tencent.mm.bw.a) linkedList.get(i4);
                        ni(i2, aVar.computeSize());
                        aVar.writeFields(this);
                        i4++;
                    }
                    AppMethodBeat.o(2454);
                    return;
                default:
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("The data type was not found, the id used was ".concat(String.valueOf(i3)));
                    AppMethodBeat.o(2454);
                    throw illegalArgumentException;
            }
        } else {
            AppMethodBeat.o(2454);
        }
    }

    public final void f(int i2, int i3, LinkedList<?> linkedList) {
        int i4 = 0;
        AppMethodBeat.i(2455);
        if (linkedList != null) {
            switch (i3) {
                case 2:
                    if (linkedList.size() > 0) {
                        this.UbV.br(i2, 2);
                        this.UbV.hc(g.a.a.a.f(i3, linkedList));
                        while (i4 < linkedList.size()) {
                            this.UbV.hc(((Integer) linkedList.get(i4)).intValue());
                            i4++;
                        }
                        AppMethodBeat.o(2455);
                        return;
                    }
                    break;
                case 3:
                    if (linkedList.size() > 0) {
                        this.UbV.br(i2, 2);
                        this.UbV.hc(g.a.a.a.f(i3, linkedList));
                        while (i4 < linkedList.size()) {
                            this.UbV.aJ(((Long) linkedList.get(i4)).longValue());
                            i4++;
                        }
                        AppMethodBeat.o(2455);
                        return;
                    }
                    break;
                default:
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("The data type was not found, the id used was ".concat(String.valueOf(i3)));
                    AppMethodBeat.o(2455);
                    throw illegalArgumentException;
            }
        }
        AppMethodBeat.o(2455);
    }

    public final void hPu() {
        AppMethodBeat.i(168739);
        if (this.output != null) {
            this.output.write(this.UbU);
            this.output.flush();
        }
        AppMethodBeat.o(168739);
    }
}
