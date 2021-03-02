package com.google.a;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class g implements Serializable, Iterable<Byte> {
    public static final g bNg = new h(ae.EMPTY_BYTE_ARRAY);
    private static final d bNh;
    private static final Comparator<g> bNj = new Comparator<g>() {
        /* class com.google.a.g.AnonymousClass2 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(g gVar, g gVar2) {
            g gVar3 = gVar;
            g gVar4 = gVar2;
            e yN = gVar3.iterator();
            e yN2 = gVar4.iterator();
            while (yN.hasNext() && yN2.hasNext()) {
                int compare = Integer.compare(g.c(yN.nextByte()), g.c(yN2.nextByte()));
                if (compare != 0) {
                    return compare;
                }
            }
            return Integer.compare(gVar3.size(), gVar4.size());
        }
    };
    int bNi = 0;

    /* access modifiers changed from: package-private */
    public interface d {
        byte[] r(byte[] bArr, int i2, int i3);
    }

    public interface e extends Iterator<Byte> {
        byte nextByte();
    }

    /* access modifiers changed from: protected */
    public abstract String a(Charset charset);

    /* access modifiers changed from: package-private */
    public abstract void a(f fVar);

    /* access modifiers changed from: protected */
    public abstract int bq(int i2, int i3);

    public abstract boolean equals(Object obj);

    public abstract byte fB(int i2);

    /* access modifiers changed from: package-private */
    public abstract byte fC(int i2);

    public abstract g fD(int i2);

    /* access modifiers changed from: protected */
    public abstract void q(byte[] bArr, int i2);

    public abstract int size();

    public abstract boolean yP();

    public abstract h yQ();

    static {
        d bVar;
        if (e.yM()) {
            bVar = new i((byte) 0);
        } else {
            bVar = new b((byte) 0);
        }
        bNh = bVar;
    }

    static final class i implements d {
        private i() {
        }

        /* synthetic */ i(byte b2) {
            this();
        }

        @Override // com.google.a.g.d
        public final byte[] r(byte[] bArr, int i2, int i3) {
            byte[] bArr2 = new byte[i3];
            System.arraycopy(bArr, i2, bArr2, 0, i3);
            return bArr2;
        }
    }

    static final class b implements d {
        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }

        @Override // com.google.a.g.d
        public final byte[] r(byte[] bArr, int i2, int i3) {
            return Arrays.copyOfRange(bArr, i2, i2 + i3);
        }
    }

    g() {
    }

    /* renamed from: yN */
    public final e iterator() {
        return new a() {
            /* class com.google.a.g.AnonymousClass1 */
            private final int limit = g.this.size();
            private int position = 0;

            public final boolean hasNext() {
                return this.position < this.limit;
            }

            @Override // com.google.a.g.e
            public final byte nextByte() {
                int i2 = this.position;
                if (i2 >= this.limit) {
                    throw new NoSuchElementException();
                }
                this.position = i2 + 1;
                return g.this.fC(i2);
            }
        };
    }

    static abstract class a implements e {
        a() {
        }

        public final void remove() {
            throw new UnsupportedOperationException();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.Iterator
        public /* synthetic */ Byte next() {
            return Byte.valueOf(nextByte());
        }
    }

    public static g p(byte[] bArr, int i2, int i3) {
        y(i2, i2 + i3, bArr.length);
        return new h(bNh.r(bArr, i2, i3));
    }

    public static g z(byte[] bArr) {
        return p(bArr, 0, bArr.length);
    }

    static g A(byte[] bArr) {
        return new h(bArr);
    }

    static g q(byte[] bArr, int i2, int i3) {
        return new c(bArr, i2, i3);
    }

    public static g bZ(String str) {
        return new h(str.getBytes(ae.UTF_8));
    }

    public final byte[] toByteArray() {
        int size = size();
        if (size == 0) {
            return ae.EMPTY_BYTE_ARRAY;
        }
        byte[] bArr = new byte[size];
        q(bArr, size);
        return bArr;
    }

    public final String yO() {
        return size() == 0 ? "" : a(ae.UTF_8);
    }

    /* renamed from: com.google.a.g$g  reason: collision with other inner class name */
    static abstract class AbstractC0090g extends g {
        AbstractC0090g() {
        }

        /* Return type fixed from 'java.util.Iterator' to match base method */
        @Override // com.google.a.g, java.lang.Iterable
        public /* synthetic */ Iterator<Byte> iterator() {
            return g.super.iterator();
        }
    }

    public final int hashCode() {
        int i2 = this.bNi;
        if (i2 == 0) {
            int size = size();
            i2 = bq(size, size);
            if (i2 == 0) {
                i2 = 1;
            }
            this.bNi = i2;
        }
        return i2;
    }

    static f fE(int i2) {
        return new f(i2, (byte) 0);
    }

    /* access modifiers changed from: package-private */
    public static final class f {
        final i bNn;
        private final byte[] buffer;

        /* synthetic */ f(int i2, byte b2) {
            this(i2);
        }

        private f(int i2) {
            this.buffer = new byte[i2];
            this.bNn = i.C(this.buffer);
        }

        public final g yS() {
            this.bNn.zA();
            return new h(this.buffer);
        }
    }

    static int y(int i2, int i3, int i4) {
        int i5 = i3 - i2;
        if ((i2 | i3 | i5 | (i4 - i3)) >= 0) {
            return i5;
        }
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i2 + " < 0");
        } else if (i3 < i2) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i2 + ", " + i3);
        } else {
            throw new IndexOutOfBoundsException("End index: " + i3 + " >= " + i4);
        }
    }

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }

    /* access modifiers changed from: package-private */
    public static class h extends AbstractC0090g {
        protected final byte[] zy;

        h(byte[] bArr) {
            if (bArr == null) {
                throw new NullPointerException();
            }
            this.zy = bArr;
        }

        @Override // com.google.a.g
        public byte fB(int i2) {
            return this.zy[i2];
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.a.g
        public byte fC(int i2) {
            return this.zy[i2];
        }

        @Override // com.google.a.g
        public int size() {
            return this.zy.length;
        }

        @Override // com.google.a.g
        public final g fD(int i2) {
            int y = y(0, i2, size());
            if (y == 0) {
                return g.bNg;
            }
            return new c(this.zy, yR() + 0, y);
        }

        /* access modifiers changed from: protected */
        @Override // com.google.a.g
        public void q(byte[] bArr, int i2) {
            System.arraycopy(this.zy, 0, bArr, 0, i2);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.a.g
        public final void a(f fVar) {
            fVar.o(this.zy, yR(), size());
        }

        /* access modifiers changed from: protected */
        @Override // com.google.a.g
        public final String a(Charset charset) {
            return new String(this.zy, yR(), size(), charset);
        }

        @Override // com.google.a.g
        public final boolean yP() {
            int yR = yR();
            return ci.s(this.zy, yR, size() + yR);
        }

        @Override // com.google.a.g
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            if (size() != ((g) obj).size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            if (!(obj instanceof h)) {
                return obj.equals(this);
            }
            int i2 = this.bNi;
            int i3 = ((h) obj).bNi;
            if (i2 != 0 && i3 != 0 && i2 != i3) {
                return false;
            }
            h hVar = (h) obj;
            int size = size();
            if (size > hVar.size()) {
                throw new IllegalArgumentException("Length too large: " + size + size());
            } else if (size + 0 > hVar.size()) {
                throw new IllegalArgumentException("Ran off end of other: 0, " + size + ", " + hVar.size());
            } else if (!(hVar instanceof h)) {
                return hVar.fD(size + 0).equals(fD(size));
            } else {
                h hVar2 = hVar;
                byte[] bArr = this.zy;
                byte[] bArr2 = hVar2.zy;
                int yR = yR() + size;
                int yR2 = yR();
                int yR3 = hVar2.yR() + 0;
                while (yR2 < yR) {
                    if (bArr[yR2] != bArr2[yR3]) {
                        return false;
                    }
                    yR2++;
                    yR3++;
                }
                return true;
            }
        }

        /* access modifiers changed from: protected */
        @Override // com.google.a.g
        public final int bq(int i2, int i3) {
            return ae.a(i2, this.zy, yR() + 0, i3);
        }

        @Override // com.google.a.g
        public final h yQ() {
            return h.c(this.zy, yR(), size(), true);
        }

        /* access modifiers changed from: protected */
        public int yR() {
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class c extends h {
        private final int bNl;
        private final int bNm;

        c(byte[] bArr, int i2, int i3) {
            super(bArr);
            y(i2, i2 + i3, bArr.length);
            this.bNl = i2;
            this.bNm = i3;
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.a.g.h, com.google.a.g
        public final byte fC(int i2) {
            return this.zy[this.bNl + i2];
        }

        @Override // com.google.a.g.h, com.google.a.g
        public final int size() {
            return this.bNm;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.a.g.h
        public final int yR() {
            return this.bNl;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.a.g.h, com.google.a.g
        public final void q(byte[] bArr, int i2) {
            System.arraycopy(this.zy, this.bNl + 0, bArr, 0, i2);
        }

        /* access modifiers changed from: package-private */
        public final Object writeReplace() {
            return g.A(toByteArray());
        }

        private void readObject(ObjectInputStream objectInputStream) {
            throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
        }

        @Override // com.google.a.g.h, com.google.a.g
        public final byte fB(int i2) {
            int i3 = this.bNm;
            if (((i3 - (i2 + 1)) | i2) >= 0) {
                return this.zy[this.bNl + i2];
            }
            if (i2 < 0) {
                throw new ArrayIndexOutOfBoundsException("Index < 0: ".concat(String.valueOf(i2)));
            }
            throw new ArrayIndexOutOfBoundsException("Index > length: " + i2 + ", " + i3);
        }
    }

    static /* synthetic */ int c(byte b2) {
        return b2 & 255;
    }
}
