package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class vb extends a {
    public int KHb;
    public String KUk;
    public long Lfn;
    public int Lfo;
    public int oTW;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(93332);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KUk != null) {
                aVar.e(1, this.KUk);
            }
            aVar.bb(2, this.Lfn);
            aVar.aM(3, this.Lfo);
            aVar.aM(4, this.KHb);
            aVar.aM(5, this.oTW);
            AppMethodBeat.o(93332);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.KUk != null ? g.a.a.b.b.a.f(1, this.KUk) + 0 : 0) + g.a.a.b.b.a.r(2, this.Lfn) + g.a.a.b.b.a.bu(3, this.Lfo) + g.a.a.b.b.a.bu(4, this.KHb) + g.a.a.b.b.a.bu(5, this.oTW);
            AppMethodBeat.o(93332);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(93332);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            vb vbVar = (vb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    vbVar.KUk = aVar3.UbS.readString();
                    AppMethodBeat.o(93332);
                    return 0;
                case 2:
                    vbVar.Lfn = aVar3.UbS.zl();
                    AppMethodBeat.o(93332);
                    return 0;
                case 3:
                    vbVar.Lfo = aVar3.UbS.zi();
                    AppMethodBeat.o(93332);
                    return 0;
                case 4:
                    vbVar.KHb = aVar3.UbS.zi();
                    AppMethodBeat.o(93332);
                    return 0;
                case 5:
                    vbVar.oTW = aVar3.UbS.zi();
                    AppMethodBeat.o(93332);
                    return 0;
                default:
                    AppMethodBeat.o(93332);
                    return -1;
            }
        } else {
            AppMethodBeat.o(93332);
            return -1;
        }
    }
}
