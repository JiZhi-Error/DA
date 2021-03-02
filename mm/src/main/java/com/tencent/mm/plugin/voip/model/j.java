package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.io.OutputStream;

/* access modifiers changed from: package-private */
public final class j {
    protected f GVj;
    int GVk;
    private int GVl;
    private int GVm;
    private final OutputStream GVn;
    private int[] GVo;
    int GVp;
    private InputStream aKQ;

    public j(InputStream inputStream) {
        AppMethodBeat.i(114864);
        this.GVj = new f();
        this.GVo = new int[8];
        this.aKQ = inputStream;
        this.GVn = null;
        this.GVl = inputStream.read();
        this.GVm = inputStream.read();
        AppMethodBeat.o(114864);
    }

    public j(InputStream inputStream, OutputStream outputStream) {
        AppMethodBeat.i(114865);
        this.GVj = new f();
        this.GVo = new int[8];
        this.aKQ = inputStream;
        this.GVn = outputStream;
        this.GVl = inputStream.read();
        this.GVm = inputStream.read();
        AppMethodBeat.o(114865);
    }

    public final boolean wY(boolean z) {
        AppMethodBeat.i(114866);
        if (wZ(z) == 1) {
            AppMethodBeat.o(114866);
            return true;
        }
        AppMethodBeat.o(114866);
        return false;
    }

    private int wZ(boolean z) {
        int i2 = -1;
        AppMethodBeat.i(114867);
        if (this.GVk == 8) {
            advance();
            if (this.GVl == -1) {
                AppMethodBeat.o(114867);
                return i2;
            }
        }
        i2 = (this.GVl >> (7 - this.GVk)) & 1;
        this.GVk++;
        if (z && this.GVn != null) {
            acX(i2);
        }
        AppMethodBeat.o(114867);
        return i2;
    }

    private long acT(int i2) {
        AppMethodBeat.i(114868);
        if (i2 > 64) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can not readByte more then 64 bit");
            AppMethodBeat.o(114868);
            throw illegalArgumentException;
        }
        long j2 = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            j2 = (j2 << 1) | ((long) wZ(true));
        }
        AppMethodBeat.o(114868);
        return j2;
    }

    public final void acU(int i2) {
        AppMethodBeat.i(114869);
        if (i2 > 64) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can not skip more then 64 bit");
            AppMethodBeat.o(114869);
            throw illegalArgumentException;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            wZ(true);
        }
        AppMethodBeat.o(114869);
    }

    private void advance() {
        AppMethodBeat.i(114870);
        this.GVl = this.GVm;
        this.GVm = this.aKQ.read();
        this.GVk = 0;
        AppMethodBeat.o(114870);
    }

    public final long fGg() {
        AppMethodBeat.i(114871);
        long acT = acT(8);
        String.valueOf(acT);
        AppMethodBeat.o(114871);
        return acT;
    }

    public final void acV(int i2) {
        AppMethodBeat.i(114872);
        acU(i2);
        AppMethodBeat.o(114872);
    }

    private int fGh() {
        int i2 = 0;
        AppMethodBeat.i(114873);
        int i3 = 0;
        while (wZ(true) == 0) {
            i3++;
        }
        if (i3 > 0) {
            i2 = (int) (((long) ((1 << i3) - 1)) + acT(i3));
        }
        AppMethodBeat.o(114873);
        return i2;
    }

    /* access modifiers changed from: package-private */
    public final void fGi() {
        AppMethodBeat.i(114874);
        int i2 = 0;
        while (wZ(true) == 0) {
            i2++;
        }
        if (i2 > 0) {
            acU(i2);
        }
        AppMethodBeat.o(114874);
    }

    public final int fGj() {
        AppMethodBeat.i(114875);
        int fGh = fGh();
        String.valueOf(fGh);
        AppMethodBeat.o(114875);
        return fGh;
    }

    public final void fGk() {
        AppMethodBeat.i(114876);
        fGi();
        AppMethodBeat.o(114876);
    }

    private int fGl() {
        AppMethodBeat.i(114877);
        int fGh = fGh();
        int i2 = ((fGh & 1) + (fGh >> 1)) * (((fGh & 1) << 1) - 1);
        String.valueOf(i2);
        AppMethodBeat.o(114877);
        return i2;
    }

    public final void acW(int i2) {
        AppMethodBeat.i(114878);
        int[] iArr = new int[i2];
        int i3 = 8;
        int i4 = 8;
        for (int i5 = 0; i5 < i2; i5++) {
            if (i3 != 0) {
                i3 = ((fGl() + i4) + 256) % 256;
            }
            if (i3 != 0) {
                i4 = i3;
            }
            iArr[i5] = i4;
            i4 = iArr[i5];
        }
        AppMethodBeat.o(114878);
    }

    public final void flush() {
        AppMethodBeat.i(114879);
        for (int i2 = this.GVp; i2 < 8; i2++) {
            this.GVo[i2] = 0;
        }
        this.GVp = 0;
        fGm();
        AppMethodBeat.o(114879);
    }

    private void fGm() {
        AppMethodBeat.i(114880);
        this.GVn.write((this.GVo[0] << 7) | (this.GVo[1] << 6) | (this.GVo[2] << 5) | (this.GVo[3] << 4) | (this.GVo[4] << 3) | (this.GVo[5] << 2) | (this.GVo[6] << 1) | this.GVo[7]);
        AppMethodBeat.o(114880);
    }

    public final void acX(int i2) {
        AppMethodBeat.i(114881);
        if (this.GVp == 8) {
            this.GVp = 0;
            fGm();
        }
        int[] iArr = this.GVo;
        int i3 = this.GVp;
        this.GVp = i3 + 1;
        iArr[i3] = i2;
        AppMethodBeat.o(114881);
    }

    public final void ai(long j2, int i2) {
        AppMethodBeat.i(114882);
        for (int i3 = 0; i3 < i2; i3++) {
            acX(((int) (j2 >> ((i2 - i3) - 1))) & 1);
        }
        AppMethodBeat.o(114882);
    }

    private void acY(int i2) {
        AppMethodBeat.i(114883);
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= 15) {
                i3 = 0;
                break;
            } else if (i2 < (1 << i3) + i4) {
                break;
            } else {
                i4 += 1 << i3;
                i3++;
            }
        }
        ai(0, i3);
        acX(1);
        ai((long) (i2 - i4), i3);
        AppMethodBeat.o(114883);
    }

    public final void acZ(int i2) {
        AppMethodBeat.i(114884);
        acY(i2);
        AppMethodBeat.o(114884);
    }

    public final void xa(boolean z) {
        AppMethodBeat.i(114885);
        acX(z ? 1 : 0);
        AppMethodBeat.o(114885);
    }
}
