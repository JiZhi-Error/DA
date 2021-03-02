package kotlin.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B7\b\u0000\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016R\u000e\u0010\u000b\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lkotlin/random/XorWowRandom;", "Lkotlin/random/Random;", "seed1", "", "seed2", "(II)V", "x", "y", "z", "w", "v", "addend", "(IIIIII)V", "nextBits", "bitCount", "nextInt", "kotlin-stdlib"})
public final class e extends c {
    private int SYR;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;

    private e(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(129556);
        this.x = i2;
        this.y = i3;
        this.z = 0;
        this.w = 0;
        this.v = i4;
        this.SYR = i5;
        if (!(((((this.x | this.y) | this.z) | this.w) | this.v) != 0)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Initial state must have at least one non-zero element.".toString());
            AppMethodBeat.o(129556);
            throw illegalArgumentException;
        }
        for (int i6 = 0; i6 < 64; i6++) {
            nextInt();
        }
        AppMethodBeat.o(129556);
    }

    public e(int i2, int i3) {
        this(i2, i3, i2 ^ -1, (i2 << 10) ^ (i3 >>> 4));
        AppMethodBeat.i(129557);
        AppMethodBeat.o(129557);
    }

    @Override // kotlin.j.c
    public final int nextInt() {
        int i2 = this.x;
        int i3 = i2 ^ (i2 >>> 2);
        this.x = this.y;
        this.y = this.z;
        this.z = this.w;
        int i4 = this.v;
        this.w = i4;
        int i5 = ((i3 ^ (i3 << 1)) ^ i4) ^ (i4 << 4);
        this.v = i5;
        this.SYR += 362437;
        return i5 + this.SYR;
    }

    @Override // kotlin.j.c
    public final int atK(int i2) {
        AppMethodBeat.i(129555);
        int mX = d.mX(nextInt(), i2);
        AppMethodBeat.o(129555);
        return mX;
    }
}
