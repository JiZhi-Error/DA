package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class acy extends a {
    public String KBt;
    public long Lnv;
    public int Lof;
    public boolean Log;
    public int Loh;
    public boolean Lol;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(186800);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.Lnv);
            if (this.KBt != null) {
                aVar.e(2, this.KBt);
            }
            aVar.aM(3, this.Lof);
            aVar.cc(4, this.Lol);
            aVar.cc(5, this.Log);
            aVar.aM(6, this.Loh);
            AppMethodBeat.o(186800);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.Lnv) + 0;
            if (this.KBt != null) {
                r += g.a.a.b.b.a.f(2, this.KBt);
            }
            int bu = r + g.a.a.b.b.a.bu(3, this.Lof) + g.a.a.b.b.a.fS(4) + 1 + g.a.a.b.b.a.fS(5) + 1 + g.a.a.b.b.a.bu(6, this.Loh);
            AppMethodBeat.o(186800);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(186800);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            acy acy = (acy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    acy.Lnv = aVar3.UbS.zl();
                    AppMethodBeat.o(186800);
                    return 0;
                case 2:
                    acy.KBt = aVar3.UbS.readString();
                    AppMethodBeat.o(186800);
                    return 0;
                case 3:
                    acy.Lof = aVar3.UbS.zi();
                    AppMethodBeat.o(186800);
                    return 0;
                case 4:
                    acy.Lol = aVar3.UbS.yZ();
                    AppMethodBeat.o(186800);
                    return 0;
                case 5:
                    acy.Log = aVar3.UbS.yZ();
                    AppMethodBeat.o(186800);
                    return 0;
                case 6:
                    acy.Loh = aVar3.UbS.zi();
                    AppMethodBeat.o(186800);
                    return 0;
                default:
                    AppMethodBeat.o(186800);
                    return -1;
            }
        } else {
            AppMethodBeat.o(186800);
            return -1;
        }
    }
}
