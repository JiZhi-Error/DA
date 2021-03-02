package kotlin.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;
import kotlin.l.b.a.b.h.d;

/* access modifiers changed from: package-private */
public final class u extends d {
    private static final int[] TDS;
    private final int TDT;
    private final d TDU;
    private final d TDV;
    private final int TDW;
    private final int TDX;
    private int bNi;

    /* synthetic */ u(d dVar, d dVar2, byte b2) {
        this(dVar, dVar2);
    }

    /* Return type fixed from 'java.util.Iterator' to match base method */
    @Override // kotlin.l.b.a.b.h.d, java.lang.Iterable
    public final /* synthetic */ Iterator<Byte> iterator() {
        AppMethodBeat.i(59568);
        d.a hJm = hJm();
        AppMethodBeat.o(59568);
        return hJm;
    }

    static {
        AppMethodBeat.i(59569);
        ArrayList arrayList = new ArrayList();
        int i2 = 1;
        int i3 = 1;
        while (i2 > 0) {
            arrayList.add(Integer.valueOf(i2));
            int i4 = i3 + i2;
            i3 = i2;
            i2 = i4;
        }
        arrayList.add(Integer.MAX_VALUE);
        TDS = new int[arrayList.size()];
        for (int i5 = 0; i5 < TDS.length; i5++) {
            TDS[i5] = ((Integer) arrayList.get(i5)).intValue();
        }
        AppMethodBeat.o(59569);
    }

    private u(d dVar, d dVar2) {
        AppMethodBeat.i(59555);
        this.bNi = 0;
        this.TDU = dVar;
        this.TDV = dVar2;
        this.TDW = dVar.size();
        this.TDT = this.TDW + dVar2.size();
        this.TDX = Math.max(dVar.hJp(), dVar2.hJp()) + 1;
        AppMethodBeat.o(59555);
    }

    static d a(d dVar, d dVar2) {
        d dVar3;
        AppMethodBeat.i(59556);
        u uVar = dVar instanceof u ? (u) dVar : null;
        if (dVar2.size() == 0) {
            dVar3 = dVar;
        } else if (dVar.size() != 0) {
            int size = dVar.size() + dVar2.size();
            if (size < 128) {
                dVar3 = b(dVar, dVar2);
            } else if (uVar != null && uVar.TDV.size() + dVar2.size() < 128) {
                dVar3 = new u(uVar.TDU, b(uVar.TDV, dVar2));
            } else if (uVar == null || uVar.TDU.hJp() <= uVar.TDV.hJp() || uVar.TDX <= dVar2.hJp()) {
                if (size >= TDS[Math.max(dVar.hJp(), dVar2.hJp()) + 1]) {
                    dVar3 = new u(dVar, dVar2);
                } else {
                    a aVar = new a((byte) 0);
                    aVar.g(dVar);
                    aVar.g(dVar2);
                    dVar3 = aVar.TDY.pop();
                    while (!aVar.TDY.isEmpty()) {
                        dVar3 = new u(aVar.TDY.pop(), dVar3, (byte) 0);
                    }
                }
            } else {
                dVar3 = new u(uVar.TDU, new u(uVar.TDV, dVar2));
            }
        } else {
            dVar3 = dVar2;
        }
        AppMethodBeat.o(59556);
        return dVar3;
    }

    private static p b(d dVar, d dVar2) {
        AppMethodBeat.i(59557);
        int size = dVar.size();
        int size2 = dVar2.size();
        byte[] bArr = new byte[(size + size2)];
        dVar.j(bArr, 0, 0, size);
        dVar2.j(bArr, 0, size, size2);
        p pVar = new p(bArr);
        AppMethodBeat.o(59557);
        return pVar;
    }

    @Override // kotlin.l.b.a.b.h.d
    public final int size() {
        return this.TDT;
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.l.b.a.b.h.d
    public final int hJp() {
        return this.TDX;
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.l.b.a.b.h.d
    public final boolean hJq() {
        return this.TDT >= TDS[this.TDX];
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.l.b.a.b.h.d
    public final void l(byte[] bArr, int i2, int i3, int i4) {
        AppMethodBeat.i(59558);
        if (i2 + i4 <= this.TDW) {
            this.TDU.l(bArr, i2, i3, i4);
            AppMethodBeat.o(59558);
        } else if (i2 >= this.TDW) {
            this.TDV.l(bArr, i2 - this.TDW, i3, i4);
            AppMethodBeat.o(59558);
        } else {
            int i5 = this.TDW - i2;
            this.TDU.l(bArr, i2, i3, i5);
            this.TDV.l(bArr, 0, i3 + i5, i4 - i5);
            AppMethodBeat.o(59558);
        }
    }

    /* access modifiers changed from: package-private */
    @Override // kotlin.l.b.a.b.h.d
    public final void b(OutputStream outputStream, int i2, int i3) {
        AppMethodBeat.i(59559);
        if (i2 + i3 <= this.TDW) {
            this.TDU.b(outputStream, i2, i3);
            AppMethodBeat.o(59559);
        } else if (i2 >= this.TDW) {
            this.TDV.b(outputStream, i2 - this.TDW, i3);
            AppMethodBeat.o(59559);
        } else {
            int i4 = this.TDW - i2;
            this.TDU.b(outputStream, i2, i4);
            this.TDV.b(outputStream, 0, i3 - i4);
            AppMethodBeat.o(59559);
        }
    }

    @Override // kotlin.l.b.a.b.h.d
    public final String toString(String str) {
        AppMethodBeat.i(59560);
        String str2 = new String(toByteArray(), str);
        AppMethodBeat.o(59560);
        return str2;
    }

    @Override // kotlin.l.b.a.b.h.d
    public final boolean yP() {
        AppMethodBeat.i(59561);
        if (this.TDV.bi(this.TDU.bi(0, 0, this.TDW), 0, this.TDV.size()) == 0) {
            AppMethodBeat.o(59561);
            return true;
        }
        AppMethodBeat.o(59561);
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.l.b.a.b.h.d
    public final int bi(int i2, int i3, int i4) {
        AppMethodBeat.i(59562);
        if (i3 + i4 <= this.TDW) {
            int bi = this.TDU.bi(i2, i3, i4);
            AppMethodBeat.o(59562);
            return bi;
        } else if (i3 >= this.TDW) {
            int bi2 = this.TDV.bi(i2, i3 - this.TDW, i4);
            AppMethodBeat.o(59562);
            return bi2;
        } else {
            int i5 = this.TDW - i3;
            int bi3 = this.TDV.bi(this.TDU.bi(i2, i3, i5), 0, i4 - i5);
            AppMethodBeat.o(59562);
            return bi3;
        }
    }

    public final boolean equals(Object obj) {
        int hJr;
        AppMethodBeat.i(59563);
        if (obj == this) {
            AppMethodBeat.o(59563);
            return true;
        } else if (!(obj instanceof d)) {
            AppMethodBeat.o(59563);
            return false;
        } else {
            d dVar = (d) obj;
            if (this.TDT != dVar.size()) {
                AppMethodBeat.o(59563);
                return false;
            } else if (this.TDT == 0) {
                AppMethodBeat.o(59563);
                return true;
            } else if (this.bNi == 0 || (hJr = dVar.hJr()) == 0 || this.bNi == hJr) {
                int i2 = 0;
                b bVar = new b(this, (byte) 0);
                int i3 = 0;
                b bVar2 = new b(dVar, (byte) 0);
                int i4 = 0;
                p pVar = (p) bVar2.next();
                p pVar2 = (p) bVar.next();
                while (true) {
                    int size = pVar2.size() - i2;
                    int size2 = pVar.size() - i3;
                    int min = Math.min(size, size2);
                    if (!(i2 == 0 ? pVar2.a(pVar, i3, min) : pVar.a(pVar2, i2, min))) {
                        AppMethodBeat.o(59563);
                        return false;
                    }
                    int i5 = i4 + min;
                    if (i5 < this.TDT) {
                        if (min == size) {
                            i2 = 0;
                            pVar2 = (p) bVar.next();
                        } else {
                            i2 += min;
                        }
                        if (min == size2) {
                            i3 = 0;
                            i4 = i5;
                            pVar = (p) bVar2.next();
                        } else {
                            i4 = i5;
                            i3 += min;
                        }
                    } else if (i5 == this.TDT) {
                        AppMethodBeat.o(59563);
                        return true;
                    } else {
                        IllegalStateException illegalStateException = new IllegalStateException();
                        AppMethodBeat.o(59563);
                        throw illegalStateException;
                    }
                }
            } else {
                AppMethodBeat.o(59563);
                return false;
            }
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(59564);
        int i2 = this.bNi;
        if (i2 == 0) {
            i2 = bj(this.TDT, 0, this.TDT);
            if (i2 == 0) {
                i2 = 1;
            }
            this.bNi = i2;
        }
        AppMethodBeat.o(59564);
        return i2;
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.l.b.a.b.h.d
    public final int hJr() {
        return this.bNi;
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.l.b.a.b.h.d
    public final int bj(int i2, int i3, int i4) {
        AppMethodBeat.i(59565);
        if (i3 + i4 <= this.TDW) {
            int bj = this.TDU.bj(i2, i3, i4);
            AppMethodBeat.o(59565);
            return bj;
        } else if (i3 >= this.TDW) {
            int bj2 = this.TDV.bj(i2, i3 - this.TDW, i4);
            AppMethodBeat.o(59565);
            return bj2;
        } else {
            int i5 = this.TDW - i3;
            int bj3 = this.TDV.bj(this.TDU.bj(i2, i3, i5), 0, i4 - i5);
            AppMethodBeat.o(59565);
            return bj3;
        }
    }

    @Override // kotlin.l.b.a.b.h.d
    public final e hJn() {
        AppMethodBeat.i(59566);
        e V = e.V(new d());
        AppMethodBeat.o(59566);
        return V;
    }

    /* access modifiers changed from: package-private */
    public static class a {
        final Stack<d> TDY;

        private a() {
            AppMethodBeat.i(59533);
            this.TDY = new Stack<>();
            AppMethodBeat.o(59533);
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        /* access modifiers changed from: package-private */
        public final void g(d dVar) {
            AppMethodBeat.i(59534);
            d dVar2 = dVar;
            while (!dVar2.hJq()) {
                if (dVar2 instanceof u) {
                    u uVar = (u) dVar2;
                    g(uVar.TDU);
                    dVar2 = uVar.TDV;
                } else {
                    String valueOf = String.valueOf(String.valueOf(dVar2.getClass()));
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder(valueOf.length() + 49).append("Has a new type of ByteString been created? Found ").append(valueOf).toString());
                    AppMethodBeat.o(59534);
                    throw illegalArgumentException;
                }
            }
            int avD = avD(dVar2.size());
            int i2 = u.TDS[avD + 1];
            if (this.TDY.isEmpty() || this.TDY.peek().size() >= i2) {
                this.TDY.push(dVar2);
                AppMethodBeat.o(59534);
                return;
            }
            int i3 = u.TDS[avD];
            u pop = this.TDY.pop();
            while (!this.TDY.isEmpty() && this.TDY.peek().size() < i3) {
                pop = new u(this.TDY.pop(), pop, (byte) 0);
            }
            u uVar2 = new u(pop, dVar2, (byte) 0);
            while (!this.TDY.isEmpty()) {
                if (this.TDY.peek().size() >= u.TDS[avD(uVar2.size()) + 1]) {
                    break;
                }
                uVar2 = new u(this.TDY.pop(), uVar2, (byte) 0);
            }
            this.TDY.push(uVar2);
            AppMethodBeat.o(59534);
        }

        private static int avD(int i2) {
            AppMethodBeat.i(59535);
            int binarySearch = Arrays.binarySearch(u.TDS, i2);
            if (binarySearch < 0) {
                binarySearch = (-(binarySearch + 1)) - 1;
            }
            AppMethodBeat.o(59535);
            return binarySearch;
        }
    }

    /* access modifiers changed from: package-private */
    public static class b implements Iterator<p> {
        private final Stack<u> TDZ;
        private p TEa;

        /* synthetic */ b(d dVar, byte b2) {
            this(dVar);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.Iterator
        public final /* synthetic */ p next() {
            AppMethodBeat.i(59541);
            p hJP = hJP();
            AppMethodBeat.o(59541);
            return hJP;
        }

        private b(d dVar) {
            AppMethodBeat.i(59536);
            this.TDZ = new Stack<>();
            this.TEa = h(dVar);
            AppMethodBeat.o(59536);
        }

        private p h(d dVar) {
            AppMethodBeat.i(59537);
            d dVar2 = dVar;
            while (dVar2 instanceof u) {
                u uVar = (u) dVar2;
                this.TDZ.push(uVar);
                dVar2 = uVar.TDU;
            }
            p pVar = (p) dVar2;
            AppMethodBeat.o(59537);
            return pVar;
        }

        private p hJO() {
            boolean z;
            AppMethodBeat.i(59538);
            while (!this.TDZ.isEmpty()) {
                p h2 = h(this.TDZ.pop().TDV);
                if (h2.size() == 0) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (!z) {
                    AppMethodBeat.o(59538);
                    return h2;
                }
            }
            AppMethodBeat.o(59538);
            return null;
        }

        public final boolean hasNext() {
            return this.TEa != null;
        }

        public final p hJP() {
            AppMethodBeat.i(59539);
            if (this.TEa == null) {
                NoSuchElementException noSuchElementException = new NoSuchElementException();
                AppMethodBeat.o(59539);
                throw noSuchElementException;
            }
            p pVar = this.TEa;
            this.TEa = hJO();
            AppMethodBeat.o(59539);
            return pVar;
        }

        public final void remove() {
            AppMethodBeat.i(59540);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(59540);
            throw unsupportedOperationException;
        }
    }

    @Override // kotlin.l.b.a.b.h.d
    public final d.a hJm() {
        AppMethodBeat.i(59567);
        c cVar = new c(this, (byte) 0);
        AppMethodBeat.o(59567);
        return cVar;
    }

    /* access modifiers changed from: package-private */
    public class c implements d.a {
        private final b TEb;
        private d.a TEc;
        int TEd;

        /* synthetic */ c(u uVar, byte b2) {
            this();
        }

        private c() {
            AppMethodBeat.i(59542);
            this.TEb = new b(u.this, (byte) 0);
            this.TEc = this.TEb.hJP().hJm();
            this.TEd = u.this.size();
            AppMethodBeat.o(59542);
        }

        public final boolean hasNext() {
            return this.TEd > 0;
        }

        @Override // kotlin.l.b.a.b.h.d.a
        public final byte nextByte() {
            AppMethodBeat.i(59543);
            if (!this.TEc.hasNext()) {
                this.TEc = this.TEb.hJP().hJm();
            }
            this.TEd--;
            byte nextByte = this.TEc.nextByte();
            AppMethodBeat.o(59543);
            return nextByte;
        }

        public final void remove() {
            AppMethodBeat.i(59544);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(59544);
            throw unsupportedOperationException;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.Iterator
        public final /* synthetic */ Byte next() {
            AppMethodBeat.i(59545);
            Byte valueOf = Byte.valueOf(nextByte());
            AppMethodBeat.o(59545);
            return valueOf;
        }
    }

    class d extends InputStream {
        private b TEf;
        private p TEg;
        private int TEh;
        private int TEi;
        private int TEj;
        private int mark;

        public d() {
            AppMethodBeat.i(59546);
            initialize();
            AppMethodBeat.o(59546);
        }

        @Override // java.io.InputStream
        public final int read(byte[] bArr, int i2, int i3) {
            AppMethodBeat.i(59547);
            if (bArr == null) {
                NullPointerException nullPointerException = new NullPointerException();
                AppMethodBeat.o(59547);
                throw nullPointerException;
            } else if (i2 < 0 || i3 < 0 || i3 > bArr.length - i2) {
                IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException();
                AppMethodBeat.o(59547);
                throw indexOutOfBoundsException;
            } else {
                int W = W(bArr, i2, i3);
                AppMethodBeat.o(59547);
                return W;
            }
        }

        @Override // java.io.InputStream
        public final long skip(long j2) {
            AppMethodBeat.i(59548);
            if (j2 < 0) {
                IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException();
                AppMethodBeat.o(59548);
                throw indexOutOfBoundsException;
            }
            if (j2 > 2147483647L) {
                j2 = 2147483647L;
            }
            long W = (long) W(null, 0, (int) j2);
            AppMethodBeat.o(59548);
            return W;
        }

        private int W(byte[] bArr, int i2, int i3) {
            AppMethodBeat.i(59549);
            int i4 = i3;
            int i5 = i2;
            while (true) {
                if (i4 <= 0) {
                    break;
                }
                hJQ();
                if (this.TEg != null) {
                    int min = Math.min(this.TEh - this.TEi, i4);
                    if (bArr != null) {
                        this.TEg.j(bArr, this.TEi, i5, min);
                        i5 += min;
                    }
                    this.TEi += min;
                    i4 -= min;
                } else if (i4 == i3) {
                    AppMethodBeat.o(59549);
                    return -1;
                }
            }
            int i6 = i3 - i4;
            AppMethodBeat.o(59549);
            return i6;
        }

        @Override // java.io.InputStream
        public final int read() {
            AppMethodBeat.i(59550);
            hJQ();
            if (this.TEg == null) {
                AppMethodBeat.o(59550);
                return -1;
            }
            p pVar = this.TEg;
            int i2 = this.TEi;
            this.TEi = i2 + 1;
            int fB = pVar.fB(i2) & 255;
            AppMethodBeat.o(59550);
            return fB;
        }

        @Override // java.io.InputStream
        public final int available() {
            AppMethodBeat.i(59551);
            int size = u.this.size() - (this.TEj + this.TEi);
            AppMethodBeat.o(59551);
            return size;
        }

        public final boolean markSupported() {
            return true;
        }

        public final void mark(int i2) {
            this.mark = this.TEj + this.TEi;
        }

        @Override // java.io.InputStream
        public final synchronized void reset() {
            AppMethodBeat.i(59552);
            initialize();
            W(null, 0, this.mark);
            AppMethodBeat.o(59552);
        }

        private void initialize() {
            AppMethodBeat.i(59553);
            this.TEf = new b(u.this, (byte) 0);
            this.TEg = this.TEf.hJP();
            this.TEh = this.TEg.size();
            this.TEi = 0;
            this.TEj = 0;
            AppMethodBeat.o(59553);
        }

        private void hJQ() {
            AppMethodBeat.i(59554);
            if (this.TEg != null && this.TEi == this.TEh) {
                this.TEj += this.TEh;
                this.TEi = 0;
                if (this.TEf.hasNext()) {
                    this.TEg = this.TEf.hJP();
                    this.TEh = this.TEg.size();
                    AppMethodBeat.o(59554);
                    return;
                }
                this.TEg = null;
                this.TEh = 0;
            }
            AppMethodBeat.o(59554);
        }
    }
}
