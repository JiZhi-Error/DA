package kotlin.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.NoSuchElementException;
import kotlin.a.ac;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\b\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, hxF = {"Lkotlin/ranges/LongProgressionIterator;", "Lkotlin/collections/LongIterator;", "first", "", "last", "step", "(JJJ)V", "finalElement", "hasNext", "", "next", "getStep", "()J", "nextLong", "kotlin-stdlib"})
public final class h extends ac {
    private final long BMh;
    private boolean SYY;
    private final long SZe;
    private long SZf;

    public h(long j2, long j3, long j4) {
        boolean z = true;
        AppMethodBeat.i(129314);
        this.BMh = j4;
        this.SZe = j3;
        if (this.BMh > 0) {
            if (j2 > j3) {
                z = false;
            }
        } else if (j2 < j3) {
            z = false;
        }
        this.SYY = z;
        this.SZf = !this.SYY ? this.SZe : j2;
        AppMethodBeat.o(129314);
    }

    public final boolean hasNext() {
        return this.SYY;
    }

    @Override // kotlin.a.ac
    public final long nextLong() {
        AppMethodBeat.i(129313);
        long j2 = this.SZf;
        if (j2 != this.SZe) {
            this.SZf += this.BMh;
        } else if (!this.SYY) {
            NoSuchElementException noSuchElementException = new NoSuchElementException();
            AppMethodBeat.o(129313);
            throw noSuchElementException;
        } else {
            this.SYY = false;
        }
        AppMethodBeat.o(129313);
        return j2;
    }
}
