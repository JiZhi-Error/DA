package kotlin.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.NoSuchElementException;
import kotlin.a.ab;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\b\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, hxF = {"Lkotlin/ranges/IntProgressionIterator;", "Lkotlin/collections/IntIterator;", "first", "", "last", "step", "(III)V", "finalElement", "hasNext", "", "next", "getStep", "()I", "nextInt", "kotlin-stdlib"})
public final class e extends ab {
    private final int SYX;
    private boolean SYY;
    private int SYZ;
    private final int lCq;

    public e(int i2, int i3, int i4) {
        boolean z = true;
        AppMethodBeat.i(129304);
        this.lCq = i4;
        this.SYX = i3;
        if (this.lCq > 0) {
            if (i2 > i3) {
                z = false;
            }
        } else if (i2 < i3) {
            z = false;
        }
        this.SYY = z;
        this.SYZ = !this.SYY ? this.SYX : i2;
        AppMethodBeat.o(129304);
    }

    public final boolean hasNext() {
        return this.SYY;
    }

    @Override // kotlin.a.ab
    public final int nextInt() {
        AppMethodBeat.i(129303);
        int i2 = this.SYZ;
        if (i2 != this.SYX) {
            this.SYZ += this.lCq;
        } else if (!this.SYY) {
            NoSuchElementException noSuchElementException = new NoSuchElementException();
            AppMethodBeat.o(129303);
            throw noSuchElementException;
        } else {
            this.SYY = false;
        }
        AppMethodBeat.o(129303);
        return i2;
    }
}
