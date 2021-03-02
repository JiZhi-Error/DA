package i.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    public short[] Upu;
    public int Upv;

    public a(int i2) {
        AppMethodBeat.i(155360);
        this.Upv = i2;
        this.Upu = new short[(1 << i2)];
        AppMethodBeat.o(155360);
    }

    public final int a(b bVar) {
        AppMethodBeat.i(155361);
        int i2 = 1;
        for (int i3 = this.Upv; i3 != 0; i3--) {
            i2 = bVar.g(this.Upu, i2) + (i2 << 1);
        }
        int i4 = i2 - (1 << this.Upv);
        AppMethodBeat.o(155361);
        return i4;
    }
}
