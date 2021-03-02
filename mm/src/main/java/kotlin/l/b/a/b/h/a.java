package kotlin.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FilterInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.l.b.a.b.h.q;

public abstract class a implements q {
    protected int bNb = 0;

    public final void d(OutputStream outputStream) {
        int i2 = 4096;
        int yC = yC();
        int fY = f.fY(yC) + yC;
        if (fY <= 4096) {
            i2 = fY;
        }
        f f2 = f.f(outputStream, i2);
        f2.hc(yC);
        a(f2);
        f2.flush();
    }

    /* renamed from: kotlin.l.b.a.b.h.a$a  reason: collision with other inner class name */
    public static abstract class AbstractC2337a<BuilderType extends AbstractC2337a> implements q.a {
        /* renamed from: c */
        public abstract BuilderType d(e eVar, g gVar);

        /* renamed from: hEF */
        public abstract BuilderType clone();

        /* renamed from: kotlin.l.b.a.b.h.a$a$a  reason: collision with other inner class name */
        static final class C2338a extends FilterInputStream {
            private int limit;

            C2338a(InputStream inputStream, int i2) {
                super(inputStream);
                this.limit = i2;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public final int available() {
                AppMethodBeat.i(59357);
                int min = Math.min(super.available(), this.limit);
                AppMethodBeat.o(59357);
                return min;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public final int read() {
                AppMethodBeat.i(59358);
                if (this.limit <= 0) {
                    AppMethodBeat.o(59358);
                    return -1;
                }
                int read = super.read();
                if (read >= 0) {
                    this.limit--;
                }
                AppMethodBeat.o(59358);
                return read;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public final int read(byte[] bArr, int i2, int i3) {
                AppMethodBeat.i(59359);
                if (this.limit <= 0) {
                    AppMethodBeat.o(59359);
                    return -1;
                }
                int read = super.read(bArr, i2, Math.min(i3, this.limit));
                if (read >= 0) {
                    this.limit -= read;
                }
                AppMethodBeat.o(59359);
                return read;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public final long skip(long j2) {
                AppMethodBeat.i(59360);
                long skip = super.skip(Math.min(j2, (long) this.limit));
                if (skip >= 0) {
                    this.limit = (int) (((long) this.limit) - skip);
                }
                AppMethodBeat.o(59360);
                return skip;
            }
        }
    }
}
