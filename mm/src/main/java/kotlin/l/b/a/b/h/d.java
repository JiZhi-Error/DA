package kotlin.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public abstract class d implements Iterable<Byte> {
    static final /* synthetic */ boolean $assertionsDisabled;
    public static final d TDp = new p(new byte[0]);

    public interface a extends Iterator<Byte> {
        byte nextByte();
    }

    /* access modifiers changed from: package-private */
    public abstract void b(OutputStream outputStream, int i2, int i3);

    /* access modifiers changed from: protected */
    public abstract int bi(int i2, int i3, int i4);

    /* access modifiers changed from: protected */
    public abstract int bj(int i2, int i3, int i4);

    /* renamed from: hJm */
    public abstract a iterator();

    public abstract e hJn();

    /* access modifiers changed from: protected */
    public abstract int hJp();

    /* access modifiers changed from: protected */
    public abstract boolean hJq();

    /* access modifiers changed from: protected */
    public abstract int hJr();

    /* access modifiers changed from: protected */
    public abstract void l(byte[] bArr, int i2, int i3, int i4);

    public abstract int size();

    public abstract String toString(String str);

    public abstract boolean yP();

    static {
        boolean z;
        if (!d.class.desiredAssertionStatus()) {
            z = true;
        } else {
            z = false;
        }
        $assertionsDisabled = z;
    }

    d() {
    }

    public static d V(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i2, bArr2, 0, i3);
        return new p(bArr2);
    }

    public static d di(byte[] bArr) {
        return V(bArr, 0, bArr.length);
    }

    public static d bud(String str) {
        try {
            return new p(str.getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET));
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("UTF-8 not supported?", e2);
        }
    }

    public final d a(d dVar) {
        int size = size();
        int size2 = dVar.size();
        if (((long) size) + ((long) size2) < 2147483647L) {
            return u.a(this, dVar);
        }
        throw new IllegalArgumentException(new StringBuilder(53).append("ByteString would be too long: ").append(size).append("+").append(size2).toString());
    }

    public static d F(Iterable<d> iterable) {
        Collection collection;
        if (!(iterable instanceof Collection)) {
            ArrayList arrayList = new ArrayList();
            for (d dVar : iterable) {
                arrayList.add(dVar);
            }
            collection = arrayList;
        } else {
            collection = (Collection) iterable;
        }
        if (collection.isEmpty()) {
            return TDp;
        }
        return a(collection.iterator(), collection.size());
    }

    private static d a(Iterator<d> it, int i2) {
        if (!$assertionsDisabled && i2 <= 0) {
            throw new AssertionError();
        } else if (i2 == 1) {
            return it.next();
        } else {
            int i3 = i2 >>> 1;
            return a(it, i3).a(a(it, i2 - i3));
        }
    }

    public final void j(byte[] bArr, int i2, int i3, int i4) {
        if (i2 < 0) {
            throw new IndexOutOfBoundsException(new StringBuilder(30).append("Source offset < 0: ").append(i2).toString());
        } else if (i3 < 0) {
            throw new IndexOutOfBoundsException(new StringBuilder(30).append("Target offset < 0: ").append(i3).toString());
        } else if (i4 < 0) {
            throw new IndexOutOfBoundsException(new StringBuilder(23).append("Length < 0: ").append(i4).toString());
        } else if (i2 + i4 > size()) {
            throw new IndexOutOfBoundsException(new StringBuilder(34).append("Source end offset < 0: ").append(i2 + i4).toString());
        } else if (i3 + i4 > bArr.length) {
            throw new IndexOutOfBoundsException(new StringBuilder(34).append("Target end offset < 0: ").append(i3 + i4).toString());
        } else if (i4 > 0) {
            l(bArr, i2, i3, i4);
        }
    }

    public final byte[] toByteArray() {
        int size = size();
        if (size == 0) {
            return j.EMPTY_BYTE_ARRAY;
        }
        byte[] bArr = new byte[size];
        l(bArr, 0, 0, size);
        return bArr;
    }

    /* access modifiers changed from: package-private */
    public final void a(OutputStream outputStream, int i2, int i3) {
        if (i2 < 0) {
            throw new IndexOutOfBoundsException(new StringBuilder(30).append("Source offset < 0: ").append(i2).toString());
        } else if (i3 < 0) {
            throw new IndexOutOfBoundsException(new StringBuilder(23).append("Length < 0: ").append(i3).toString());
        } else if (i2 + i3 > size()) {
            throw new IndexOutOfBoundsException(new StringBuilder(39).append("Source end offset exceeded: ").append(i2 + i3).toString());
        } else if (i3 > 0) {
            b(outputStream, i2, i3);
        }
    }

    public final String yO() {
        try {
            return toString(MimeTypeUtil.ContentType.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("UTF-8 not supported?", e2);
        }
    }

    public static b hJo() {
        return new b();
    }

    public static final class b extends OutputStream {
        private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
        private final int TDq = 128;
        private final ArrayList<d> TDr = new ArrayList<>();
        private int TDs;
        private byte[] buffer = new byte[128];
        private int cbm;

        b() {
            AppMethodBeat.i(59370);
            AppMethodBeat.o(59370);
        }

        @Override // java.io.OutputStream
        public final synchronized void write(int i2) {
            AppMethodBeat.i(59371);
            if (this.cbm == this.buffer.length) {
                avw(1);
            }
            byte[] bArr = this.buffer;
            int i3 = this.cbm;
            this.cbm = i3 + 1;
            bArr[i3] = (byte) i2;
            AppMethodBeat.o(59371);
        }

        @Override // java.io.OutputStream
        public final synchronized void write(byte[] bArr, int i2, int i3) {
            AppMethodBeat.i(59372);
            if (i3 <= this.buffer.length - this.cbm) {
                System.arraycopy(bArr, i2, this.buffer, this.cbm, i3);
                this.cbm += i3;
                AppMethodBeat.o(59372);
            } else {
                int length = this.buffer.length - this.cbm;
                System.arraycopy(bArr, i2, this.buffer, this.cbm, length);
                int i4 = i2 + length;
                int i5 = i3 - length;
                avw(i5);
                System.arraycopy(bArr, i4, this.buffer, 0, i5);
                this.cbm = i5;
                AppMethodBeat.o(59372);
            }
        }

        private synchronized int size() {
            return this.TDs + this.cbm;
        }

        public final String toString() {
            AppMethodBeat.i(59374);
            String format = String.format("<ByteString.Output@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
            AppMethodBeat.o(59374);
            return format;
        }

        private void avw(int i2) {
            AppMethodBeat.i(59375);
            this.TDr.add(new p(this.buffer));
            this.TDs += this.buffer.length;
            this.buffer = new byte[Math.max(this.TDq, Math.max(i2, this.TDs >>> 1))];
            this.cbm = 0;
            AppMethodBeat.o(59375);
        }

        public final synchronized d hJs() {
            d F;
            AppMethodBeat.i(59373);
            if (this.cbm >= this.buffer.length) {
                this.TDr.add(new p(this.buffer));
                this.buffer = EMPTY_BYTE_ARRAY;
            } else if (this.cbm > 0) {
                byte[] bArr = this.buffer;
                int i2 = this.cbm;
                byte[] bArr2 = new byte[i2];
                System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, i2));
                this.TDr.add(new p(bArr2));
            }
            this.TDs += this.cbm;
            this.cbm = 0;
            F = d.F(this.TDr);
            AppMethodBeat.o(59373);
            return F;
        }
    }

    public String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }
}
