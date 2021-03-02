package com.tencent.mm.plugin.d.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.d.a.b.h;

public class e extends a {
    static final String TAG = e.class.getName();
    public static final String piU = h.phN;
    public static final String piV = h.phO;
    public static final String piW = h.phP;
    public static final String piX = h.phQ;
    public byte piY = 0;
    public byte piZ = 0;
    public byte pja = 0;
    public byte pjb = 0;
    public byte[] pjc = {0, 0};
    public int pjd = -1;
    public byte pje = 0;
    public byte pjf = 0;
    public byte[] pjg = null;

    static {
        AppMethodBeat.i(22582);
        AppMethodBeat.o(22582);
    }

    public e() {
        AppMethodBeat.i(22580);
        this.pie = null;
        this.pif = 8;
        this.phx = 16;
        AppMethodBeat.o(22580);
    }

    @Override // com.tencent.mm.plugin.d.a.b.a.a
    public final byte[] ckM() {
        AppMethodBeat.i(22581);
        if (this.pie.equalsIgnoreCase(piU)) {
            byte[] bArr = new byte[3];
            System.arraycopy(Byte.valueOf(this.piY), 0, bArr, 0, 1);
            System.arraycopy(Byte.valueOf(this.piZ), 0, bArr, 1, 1);
            System.arraycopy(Byte.valueOf(this.pja), 0, bArr, 2, 1);
            AppMethodBeat.o(22581);
            return bArr;
        } else if (this.pie.equalsIgnoreCase(piV)) {
            byte[] bArr2 = new byte[1];
            System.arraycopy(Byte.valueOf(this.pjb), 0, bArr2, 0, 1);
            AppMethodBeat.o(22581);
            return bArr2;
        } else if (this.pie.equalsIgnoreCase(piX)) {
            byte[] bArr3 = new byte[this.pjd];
            System.arraycopy(Byte.valueOf((byte) (this.pjd & 255)), 0, bArr3, 0, 1);
            System.arraycopy(Byte.valueOf((byte) ((this.pjd >> 8) & 255)), 0, bArr3, 1, 1);
            System.arraycopy(Byte.valueOf(this.pje), 0, bArr3, 2, 1);
            if (this.pjd > 3) {
                System.arraycopy(this.pjg, 0, bArr3, 3, this.pjd - 3);
            }
            AppMethodBeat.o(22581);
            return bArr3;
        } else {
            AppMethodBeat.o(22581);
            return null;
        }
    }
}
