package kotlin.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.l.b.a.b.h.d;

/* access modifiers changed from: package-private */
public class p extends d {
    private int bNi = 0;
    protected final byte[] zy;

    /* Return type fixed from 'java.util.Iterator' to match base method */
    @Override // kotlin.l.b.a.b.h.d, java.lang.Iterable
    public /* synthetic */ Iterator<Byte> iterator() {
        AppMethodBeat.i(59532);
        d.a hJm = hJm();
        AppMethodBeat.o(59532);
        return hJm;
    }

    p(byte[] bArr) {
        this.zy = bArr;
    }

    public byte fB(int i2) {
        return this.zy[i2];
    }

    @Override // kotlin.l.b.a.b.h.d
    public int size() {
        return this.zy.length;
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.l.b.a.b.h.d
    public void l(byte[] bArr, int i2, int i3, int i4) {
        AppMethodBeat.i(59521);
        System.arraycopy(this.zy, i2, bArr, i3, i4);
        AppMethodBeat.o(59521);
    }

    /* access modifiers changed from: package-private */
    @Override // kotlin.l.b.a.b.h.d
    public final void b(OutputStream outputStream, int i2, int i3) {
        AppMethodBeat.i(59522);
        outputStream.write(this.zy, yR() + i2, i3);
        AppMethodBeat.o(59522);
    }

    @Override // kotlin.l.b.a.b.h.d
    public final String toString(String str) {
        AppMethodBeat.i(59523);
        String str2 = new String(this.zy, yR(), size(), str);
        AppMethodBeat.o(59523);
        return str2;
    }

    @Override // kotlin.l.b.a.b.h.d
    public final boolean yP() {
        AppMethodBeat.i(59524);
        int yR = yR();
        boolean s = y.s(this.zy, yR, size() + yR);
        AppMethodBeat.o(59524);
        return s;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005b, code lost:
        if (r5[r1] > -65) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x009e, code lost:
        if (r5[r1] > -65) goto L_0x00a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002a, code lost:
        if (r5[r1] > -65) goto L_0x002c;
     */
    @Override // kotlin.l.b.a.b.h.d
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int bi(int r12, int r13, int r14) {
        /*
        // Method dump skipped, instructions count: 178
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.h.p.bi(int, int, int):int");
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(59526);
        if (obj == this) {
            AppMethodBeat.o(59526);
            return true;
        } else if (!(obj instanceof d)) {
            AppMethodBeat.o(59526);
            return false;
        } else if (size() != ((d) obj).size()) {
            AppMethodBeat.o(59526);
            return false;
        } else if (size() == 0) {
            AppMethodBeat.o(59526);
            return true;
        } else if (obj instanceof p) {
            boolean a2 = a((p) obj, 0, size());
            AppMethodBeat.o(59526);
            return a2;
        } else if (obj instanceof u) {
            boolean equals = obj.equals(this);
            AppMethodBeat.o(59526);
            return equals;
        } else {
            String valueOf = String.valueOf(String.valueOf(obj.getClass()));
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder(valueOf.length() + 49).append("Has a new type of ByteString been created? Found ").append(valueOf).toString());
            AppMethodBeat.o(59526);
            throw illegalArgumentException;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean a(p pVar, int i2, int i3) {
        AppMethodBeat.i(59527);
        if (i3 > pVar.size()) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder(40).append("Length too large: ").append(i3).append(size()).toString());
            AppMethodBeat.o(59527);
            throw illegalArgumentException;
        } else if (i2 + i3 > pVar.size()) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(new StringBuilder(59).append("Ran off end of other: ").append(i2).append(", ").append(i3).append(", ").append(pVar.size()).toString());
            AppMethodBeat.o(59527);
            throw illegalArgumentException2;
        } else {
            byte[] bArr = this.zy;
            byte[] bArr2 = pVar.zy;
            int yR = yR() + i3;
            int yR2 = yR();
            int yR3 = pVar.yR() + i2;
            while (yR2 < yR) {
                if (bArr[yR2] != bArr2[yR3]) {
                    AppMethodBeat.o(59527);
                    return false;
                }
                yR2++;
                yR3++;
            }
            AppMethodBeat.o(59527);
            return true;
        }
    }

    public int hashCode() {
        AppMethodBeat.i(59528);
        int i2 = this.bNi;
        if (i2 == 0) {
            int size = size();
            i2 = bj(size, 0, size);
            if (i2 == 0) {
                i2 = 1;
            }
            this.bNi = i2;
        }
        AppMethodBeat.o(59528);
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
        AppMethodBeat.i(59529);
        int b2 = b(i2, this.zy, yR() + i3, i4);
        AppMethodBeat.o(59529);
        return b2;
    }

    private static int b(int i2, byte[] bArr, int i3, int i4) {
        for (int i5 = i3; i5 < i3 + i4; i5++) {
            i2 = (i2 * 31) + bArr[i5];
        }
        return i2;
    }

    @Override // kotlin.l.b.a.b.h.d
    public final e hJn() {
        AppMethodBeat.i(59530);
        e a2 = e.a(this);
        AppMethodBeat.o(59530);
        return a2;
    }

    @Override // kotlin.l.b.a.b.h.d
    public d.a hJm() {
        AppMethodBeat.i(59531);
        a aVar = new a(this, (byte) 0);
        AppMethodBeat.o(59531);
        return aVar;
    }

    /* access modifiers changed from: package-private */
    public class a implements d.a {
        private final int limit;
        private int position;

        /* synthetic */ a(p pVar, byte b2) {
            this();
        }

        private a() {
            AppMethodBeat.i(59517);
            this.position = 0;
            this.limit = p.this.size();
            AppMethodBeat.o(59517);
        }

        public final boolean hasNext() {
            return this.position < this.limit;
        }

        @Override // kotlin.l.b.a.b.h.d.a
        public final byte nextByte() {
            AppMethodBeat.i(59518);
            try {
                byte[] bArr = p.this.zy;
                int i2 = this.position;
                this.position = i2 + 1;
                byte b2 = bArr[i2];
                AppMethodBeat.o(59518);
                return b2;
            } catch (ArrayIndexOutOfBoundsException e2) {
                NoSuchElementException noSuchElementException = new NoSuchElementException(e2.getMessage());
                AppMethodBeat.o(59518);
                throw noSuchElementException;
            }
        }

        public final void remove() {
            AppMethodBeat.i(59519);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(59519);
            throw unsupportedOperationException;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.Iterator
        public final /* synthetic */ Byte next() {
            AppMethodBeat.i(59520);
            Byte valueOf = Byte.valueOf(nextByte());
            AppMethodBeat.o(59520);
            return valueOf;
        }
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.l.b.a.b.h.d
    public final int hJp() {
        return 0;
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.l.b.a.b.h.d
    public final boolean hJq() {
        return true;
    }

    /* access modifiers changed from: protected */
    public int yR() {
        return 0;
    }
}
