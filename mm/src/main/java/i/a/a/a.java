package i.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;

public final class a {
    public int Ucm;
    public byte[] UoN;
    public int UoO = 0;
    public int UoP;
    public OutputStream UoQ;

    public final void hRo() {
        AppMethodBeat.i(155350);
        hRp();
        this.UoQ = null;
        AppMethodBeat.o(155350);
    }

    public final void hRp() {
        AppMethodBeat.i(155351);
        int i2 = this.Ucm - this.UoP;
        if (i2 == 0) {
            AppMethodBeat.o(155351);
            return;
        }
        this.UoQ.write(this.UoN, this.UoP, i2);
        if (this.Ucm >= this.UoO) {
            this.Ucm = 0;
        }
        this.UoP = this.Ucm;
        AppMethodBeat.o(155351);
    }

    public final byte awq(int i2) {
        int i3 = (this.Ucm - i2) - 1;
        if (i3 < 0) {
            i3 += this.UoO;
        }
        return this.UoN[i3];
    }
}
