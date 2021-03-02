package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class eas extends a {
    public int Esd;
    public float Nai;
    public float Naj;
    public float Nak;
    public float Nal;
    public int Nam;
    public long Nan;
    public long Nao;
    public float cjn;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125812);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.E(1, this.Nai);
            aVar.E(2, this.Naj);
            aVar.E(3, this.Nak);
            aVar.E(4, this.Nal);
            aVar.aM(5, this.Nam);
            aVar.bb(6, this.Nan);
            aVar.bb(7, this.Nao);
            aVar.E(8, this.cjn);
            aVar.aM(9, this.Esd);
            AppMethodBeat.o(125812);
            return 0;
        } else if (i2 == 1) {
            int fS = g.a.a.b.b.a.fS(1) + 4 + 0 + g.a.a.b.b.a.fS(2) + 4 + g.a.a.b.b.a.fS(3) + 4 + g.a.a.b.b.a.fS(4) + 4 + g.a.a.b.b.a.bu(5, this.Nam) + g.a.a.b.b.a.r(6, this.Nan) + g.a.a.b.b.a.r(7, this.Nao) + g.a.a.b.b.a.fS(8) + 4 + g.a.a.b.b.a.bu(9, this.Esd);
            AppMethodBeat.o(125812);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(125812);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eas eas = (eas) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eas.Nai = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(125812);
                    return 0;
                case 2:
                    eas.Naj = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(125812);
                    return 0;
                case 3:
                    eas.Nak = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(125812);
                    return 0;
                case 4:
                    eas.Nal = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(125812);
                    return 0;
                case 5:
                    eas.Nam = aVar3.UbS.zi();
                    AppMethodBeat.o(125812);
                    return 0;
                case 6:
                    eas.Nan = aVar3.UbS.zl();
                    AppMethodBeat.o(125812);
                    return 0;
                case 7:
                    eas.Nao = aVar3.UbS.zl();
                    AppMethodBeat.o(125812);
                    return 0;
                case 8:
                    eas.cjn = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(125812);
                    return 0;
                case 9:
                    eas.Esd = aVar3.UbS.zi();
                    AppMethodBeat.o(125812);
                    return 0;
                default:
                    AppMethodBeat.o(125812);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125812);
            return -1;
        }
    }
}
