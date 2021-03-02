package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class cyy extends a {
    public int FileSize;
    public int KKA;
    public String MEb;
    public int MEc;
    public String MEd;
    public String MEe;
    public String MEf;
    public String MEg;
    public String MEh;
    public int MEi;
    public String MEj;
    public int Scene;
    public String keb;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(223891);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MEb == null) {
                b bVar = new b("Not all required fields were included: FileMD5");
                AppMethodBeat.o(223891);
                throw bVar;
            }
            aVar.aM(1, this.Scene);
            aVar.aM(2, this.KKA);
            aVar.aM(3, this.FileSize);
            if (this.MEb != null) {
                aVar.e(4, this.MEb);
            }
            aVar.aM(5, this.MEc);
            if (this.MEd != null) {
                aVar.e(6, this.MEd);
            }
            if (this.MEe != null) {
                aVar.e(7, this.MEe);
            }
            if (this.MEf != null) {
                aVar.e(8, this.MEf);
            }
            if (this.MEg != null) {
                aVar.e(10, this.MEg);
            }
            if (this.MEh != null) {
                aVar.e(11, this.MEh);
            }
            aVar.aM(12, this.MEi);
            if (this.keb != null) {
                aVar.e(13, this.keb);
            }
            if (this.MEj != null) {
                aVar.e(14, this.MEj);
            }
            AppMethodBeat.o(223891);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Scene) + 0 + g.a.a.b.b.a.bu(2, this.KKA) + g.a.a.b.b.a.bu(3, this.FileSize);
            if (this.MEb != null) {
                bu += g.a.a.b.b.a.f(4, this.MEb);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(5, this.MEc);
            if (this.MEd != null) {
                bu2 += g.a.a.b.b.a.f(6, this.MEd);
            }
            if (this.MEe != null) {
                bu2 += g.a.a.b.b.a.f(7, this.MEe);
            }
            if (this.MEf != null) {
                bu2 += g.a.a.b.b.a.f(8, this.MEf);
            }
            if (this.MEg != null) {
                bu2 += g.a.a.b.b.a.f(10, this.MEg);
            }
            if (this.MEh != null) {
                bu2 += g.a.a.b.b.a.f(11, this.MEh);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(12, this.MEi);
            if (this.keb != null) {
                bu3 += g.a.a.b.b.a.f(13, this.keb);
            }
            if (this.MEj != null) {
                bu3 += g.a.a.b.b.a.f(14, this.MEj);
            }
            AppMethodBeat.o(223891);
            return bu3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.MEb == null) {
                b bVar2 = new b("Not all required fields were included: FileMD5");
                AppMethodBeat.o(223891);
                throw bVar2;
            }
            AppMethodBeat.o(223891);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cyy cyy = (cyy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cyy.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(223891);
                    return 0;
                case 2:
                    cyy.KKA = aVar3.UbS.zi();
                    AppMethodBeat.o(223891);
                    return 0;
                case 3:
                    cyy.FileSize = aVar3.UbS.zi();
                    AppMethodBeat.o(223891);
                    return 0;
                case 4:
                    cyy.MEb = aVar3.UbS.readString();
                    AppMethodBeat.o(223891);
                    return 0;
                case 5:
                    cyy.MEc = aVar3.UbS.zi();
                    AppMethodBeat.o(223891);
                    return 0;
                case 6:
                    cyy.MEd = aVar3.UbS.readString();
                    AppMethodBeat.o(223891);
                    return 0;
                case 7:
                    cyy.MEe = aVar3.UbS.readString();
                    AppMethodBeat.o(223891);
                    return 0;
                case 8:
                    cyy.MEf = aVar3.UbS.readString();
                    AppMethodBeat.o(223891);
                    return 0;
                case 9:
                default:
                    AppMethodBeat.o(223891);
                    return -1;
                case 10:
                    cyy.MEg = aVar3.UbS.readString();
                    AppMethodBeat.o(223891);
                    return 0;
                case 11:
                    cyy.MEh = aVar3.UbS.readString();
                    AppMethodBeat.o(223891);
                    return 0;
                case 12:
                    cyy.MEi = aVar3.UbS.zi();
                    AppMethodBeat.o(223891);
                    return 0;
                case 13:
                    cyy.keb = aVar3.UbS.readString();
                    AppMethodBeat.o(223891);
                    return 0;
                case 14:
                    cyy.MEj = aVar3.UbS.readString();
                    AppMethodBeat.o(223891);
                    return 0;
            }
        } else {
            AppMethodBeat.o(223891);
            return -1;
        }
    }
}
