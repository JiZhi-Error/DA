package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class dou extends a {
    public String LiG;
    public String MRZ;
    public long MSa;
    public int MSb;
    public int MSc;
    public int MSd;
    public int MSe;
    public int MSf;
    public int MSg;
    public float MSh;
    public float MSi;
    public float MSj;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(87875);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LiG != null) {
                aVar.e(1, this.LiG);
            }
            if (this.MRZ != null) {
                aVar.e(2, this.MRZ);
            }
            aVar.bb(3, this.MSa);
            aVar.aM(4, this.MSb);
            aVar.aM(5, this.MSc);
            aVar.aM(6, this.MSd);
            aVar.aM(7, this.MSe);
            aVar.aM(8, this.MSf);
            aVar.aM(9, this.MSg);
            aVar.E(10, this.MSh);
            aVar.E(11, this.MSi);
            aVar.E(12, this.MSj);
            AppMethodBeat.o(87875);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.LiG != null ? g.a.a.b.b.a.f(1, this.LiG) + 0 : 0;
            if (this.MRZ != null) {
                f2 += g.a.a.b.b.a.f(2, this.MRZ);
            }
            int r = f2 + g.a.a.b.b.a.r(3, this.MSa) + g.a.a.b.b.a.bu(4, this.MSb) + g.a.a.b.b.a.bu(5, this.MSc) + g.a.a.b.b.a.bu(6, this.MSd) + g.a.a.b.b.a.bu(7, this.MSe) + g.a.a.b.b.a.bu(8, this.MSf) + g.a.a.b.b.a.bu(9, this.MSg) + g.a.a.b.b.a.fS(10) + 4 + g.a.a.b.b.a.fS(11) + 4 + g.a.a.b.b.a.fS(12) + 4;
            AppMethodBeat.o(87875);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(87875);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dou dou = (dou) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dou.LiG = aVar3.UbS.readString();
                    AppMethodBeat.o(87875);
                    return 0;
                case 2:
                    dou.MRZ = aVar3.UbS.readString();
                    AppMethodBeat.o(87875);
                    return 0;
                case 3:
                    dou.MSa = aVar3.UbS.zl();
                    AppMethodBeat.o(87875);
                    return 0;
                case 4:
                    dou.MSb = aVar3.UbS.zi();
                    AppMethodBeat.o(87875);
                    return 0;
                case 5:
                    dou.MSc = aVar3.UbS.zi();
                    AppMethodBeat.o(87875);
                    return 0;
                case 6:
                    dou.MSd = aVar3.UbS.zi();
                    AppMethodBeat.o(87875);
                    return 0;
                case 7:
                    dou.MSe = aVar3.UbS.zi();
                    AppMethodBeat.o(87875);
                    return 0;
                case 8:
                    dou.MSf = aVar3.UbS.zi();
                    AppMethodBeat.o(87875);
                    return 0;
                case 9:
                    dou.MSg = aVar3.UbS.zi();
                    AppMethodBeat.o(87875);
                    return 0;
                case 10:
                    dou.MSh = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(87875);
                    return 0;
                case 11:
                    dou.MSi = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(87875);
                    return 0;
                case 12:
                    dou.MSj = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(87875);
                    return 0;
                default:
                    AppMethodBeat.o(87875);
                    return -1;
            }
        } else {
            AppMethodBeat.o(87875);
            return -1;
        }
    }
}
