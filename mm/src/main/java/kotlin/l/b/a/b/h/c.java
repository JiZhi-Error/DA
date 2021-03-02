package kotlin.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.l.b.a.b.h.d;

/* access modifiers changed from: package-private */
public final class c extends p {
    final int bNl;
    private final int bNm;

    /* Return type fixed from 'java.util.Iterator' to match base method */
    @Override // kotlin.l.b.a.b.h.p, kotlin.l.b.a.b.h.d, java.lang.Iterable
    public final /* synthetic */ Iterator<Byte> iterator() {
        AppMethodBeat.i(59369);
        d.a hJm = hJm();
        AppMethodBeat.o(59369);
        return hJm;
    }

    c(byte[] bArr, int i2, int i3) {
        super(bArr);
        AppMethodBeat.i(59365);
        if (i2 < 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder(29).append("Offset too small: ").append(i2).toString());
            AppMethodBeat.o(59365);
            throw illegalArgumentException;
        } else if (i3 < 0) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(new StringBuilder(29).append("Length too small: ").append(i2).toString());
            AppMethodBeat.o(59365);
            throw illegalArgumentException2;
        } else if (((long) i2) + ((long) i3) > ((long) bArr.length)) {
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(new StringBuilder(48).append("Offset+Length too large: ").append(i2).append("+").append(i3).toString());
            AppMethodBeat.o(59365);
            throw illegalArgumentException3;
        } else {
            this.bNl = i2;
            this.bNm = i3;
            AppMethodBeat.o(59365);
        }
    }

    @Override // kotlin.l.b.a.b.h.p
    public final byte fB(int i2) {
        AppMethodBeat.i(59366);
        if (i2 < 0) {
            ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException(new StringBuilder(28).append("Index too small: ").append(i2).toString());
            AppMethodBeat.o(59366);
            throw arrayIndexOutOfBoundsException;
        } else if (i2 >= this.bNm) {
            ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException2 = new ArrayIndexOutOfBoundsException(new StringBuilder(41).append("Index too large: ").append(i2).append(", ").append(this.bNm).toString());
            AppMethodBeat.o(59366);
            throw arrayIndexOutOfBoundsException2;
        } else {
            byte b2 = this.zy[this.bNl + i2];
            AppMethodBeat.o(59366);
            return b2;
        }
    }

    @Override // kotlin.l.b.a.b.h.p, kotlin.l.b.a.b.h.d
    public final int size() {
        return this.bNm;
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.l.b.a.b.h.p
    public final int yR() {
        return this.bNl;
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.l.b.a.b.h.p, kotlin.l.b.a.b.h.d
    public final void l(byte[] bArr, int i2, int i3, int i4) {
        AppMethodBeat.i(59367);
        System.arraycopy(this.zy, this.bNl + i2, bArr, i3, i4);
        AppMethodBeat.o(59367);
    }

    @Override // kotlin.l.b.a.b.h.p, kotlin.l.b.a.b.h.d
    public final d.a hJm() {
        AppMethodBeat.i(59368);
        a aVar = new a(this, (byte) 0);
        AppMethodBeat.o(59368);
        return aVar;
    }

    /* access modifiers changed from: package-private */
    public class a implements d.a {
        private final int limit;
        private int position;

        /* synthetic */ a(c cVar, byte b2) {
            this();
        }

        private a() {
            AppMethodBeat.i(59361);
            this.position = c.this.bNl;
            this.limit = this.position + c.this.size();
            AppMethodBeat.o(59361);
        }

        public final boolean hasNext() {
            return this.position < this.limit;
        }

        @Override // kotlin.l.b.a.b.h.d.a
        public final byte nextByte() {
            AppMethodBeat.i(59362);
            if (this.position >= this.limit) {
                NoSuchElementException noSuchElementException = new NoSuchElementException();
                AppMethodBeat.o(59362);
                throw noSuchElementException;
            }
            byte[] bArr = c.this.zy;
            int i2 = this.position;
            this.position = i2 + 1;
            byte b2 = bArr[i2];
            AppMethodBeat.o(59362);
            return b2;
        }

        public final void remove() {
            AppMethodBeat.i(59363);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(59363);
            throw unsupportedOperationException;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.Iterator
        public final /* synthetic */ Byte next() {
            AppMethodBeat.i(59364);
            Byte valueOf = Byte.valueOf(nextByte());
            AppMethodBeat.o(59364);
            return valueOf;
        }
    }
}
