package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class awd extends a {
    public int KTE;
    public String LFM;
    public String LGJ;
    public String LGK;
    public String LGL;
    public String LGM;
    public String LGN;
    public String LGO;
    public float LGP;
    public int LGQ;
    public String name;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209524);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LFM != null) {
                aVar.e(1, this.LFM);
            }
            aVar.aM(2, this.KTE);
            if (this.LGJ != null) {
                aVar.e(3, this.LGJ);
            }
            if (this.LGK != null) {
                aVar.e(4, this.LGK);
            }
            if (this.LGL != null) {
                aVar.e(5, this.LGL);
            }
            if (this.LGM != null) {
                aVar.e(6, this.LGM);
            }
            if (this.LGN != null) {
                aVar.e(7, this.LGN);
            }
            if (this.LGO != null) {
                aVar.e(8, this.LGO);
            }
            if (this.name != null) {
                aVar.e(9, this.name);
            }
            aVar.E(10, this.LGP);
            aVar.aM(11, this.LGQ);
            AppMethodBeat.o(209524);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.LFM != null ? g.a.a.b.b.a.f(1, this.LFM) + 0 : 0) + g.a.a.b.b.a.bu(2, this.KTE);
            if (this.LGJ != null) {
                f2 += g.a.a.b.b.a.f(3, this.LGJ);
            }
            if (this.LGK != null) {
                f2 += g.a.a.b.b.a.f(4, this.LGK);
            }
            if (this.LGL != null) {
                f2 += g.a.a.b.b.a.f(5, this.LGL);
            }
            if (this.LGM != null) {
                f2 += g.a.a.b.b.a.f(6, this.LGM);
            }
            if (this.LGN != null) {
                f2 += g.a.a.b.b.a.f(7, this.LGN);
            }
            if (this.LGO != null) {
                f2 += g.a.a.b.b.a.f(8, this.LGO);
            }
            if (this.name != null) {
                f2 += g.a.a.b.b.a.f(9, this.name);
            }
            int fS = f2 + g.a.a.b.b.a.fS(10) + 4 + g.a.a.b.b.a.bu(11, this.LGQ);
            AppMethodBeat.o(209524);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209524);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            awd awd = (awd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    awd.LFM = aVar3.UbS.readString();
                    AppMethodBeat.o(209524);
                    return 0;
                case 2:
                    awd.KTE = aVar3.UbS.zi();
                    AppMethodBeat.o(209524);
                    return 0;
                case 3:
                    awd.LGJ = aVar3.UbS.readString();
                    AppMethodBeat.o(209524);
                    return 0;
                case 4:
                    awd.LGK = aVar3.UbS.readString();
                    AppMethodBeat.o(209524);
                    return 0;
                case 5:
                    awd.LGL = aVar3.UbS.readString();
                    AppMethodBeat.o(209524);
                    return 0;
                case 6:
                    awd.LGM = aVar3.UbS.readString();
                    AppMethodBeat.o(209524);
                    return 0;
                case 7:
                    awd.LGN = aVar3.UbS.readString();
                    AppMethodBeat.o(209524);
                    return 0;
                case 8:
                    awd.LGO = aVar3.UbS.readString();
                    AppMethodBeat.o(209524);
                    return 0;
                case 9:
                    awd.name = aVar3.UbS.readString();
                    AppMethodBeat.o(209524);
                    return 0;
                case 10:
                    awd.LGP = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(209524);
                    return 0;
                case 11:
                    awd.LGQ = aVar3.UbS.zi();
                    AppMethodBeat.o(209524);
                    return 0;
                default:
                    AppMethodBeat.o(209524);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209524);
            return -1;
        }
    }
}
