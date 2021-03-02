package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class ezd extends a {
    public String MRZ;
    public int MWA;
    public boolean NvF;
    public boolean NvG;
    public boolean NvH;
    public b Nvo;
    public String Title;
    public String iAc;
    public int xNF;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32545);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MRZ == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: Talker");
                AppMethodBeat.o(32545);
                throw bVar;
            } else if (this.Title == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: Title");
                AppMethodBeat.o(32545);
                throw bVar2;
            } else if (this.iAc == null) {
                g.a.a.b bVar3 = new g.a.a.b("Not all required fields were included: Content");
                AppMethodBeat.o(32545);
                throw bVar3;
            } else {
                aVar.aM(1, this.xNF);
                if (this.MRZ != null) {
                    aVar.e(2, this.MRZ);
                }
                if (this.Title != null) {
                    aVar.e(3, this.Title);
                }
                if (this.iAc != null) {
                    aVar.e(4, this.iAc);
                }
                aVar.aM(5, this.MWA);
                if (this.Nvo != null) {
                    aVar.c(6, this.Nvo);
                }
                aVar.cc(7, this.NvF);
                aVar.cc(8, this.NvG);
                aVar.cc(9, this.NvH);
                AppMethodBeat.o(32545);
                return 0;
            }
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.xNF) + 0;
            if (this.MRZ != null) {
                bu += g.a.a.b.b.a.f(2, this.MRZ);
            }
            if (this.Title != null) {
                bu += g.a.a.b.b.a.f(3, this.Title);
            }
            if (this.iAc != null) {
                bu += g.a.a.b.b.a.f(4, this.iAc);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(5, this.MWA);
            if (this.Nvo != null) {
                bu2 += g.a.a.b.b.a.b(6, this.Nvo);
            }
            int fS = bu2 + g.a.a.b.b.a.fS(7) + 1 + g.a.a.b.b.a.fS(8) + 1 + g.a.a.b.b.a.fS(9) + 1;
            AppMethodBeat.o(32545);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.MRZ == null) {
                g.a.a.b bVar4 = new g.a.a.b("Not all required fields were included: Talker");
                AppMethodBeat.o(32545);
                throw bVar4;
            } else if (this.Title == null) {
                g.a.a.b bVar5 = new g.a.a.b("Not all required fields were included: Title");
                AppMethodBeat.o(32545);
                throw bVar5;
            } else if (this.iAc == null) {
                g.a.a.b bVar6 = new g.a.a.b("Not all required fields were included: Content");
                AppMethodBeat.o(32545);
                throw bVar6;
            } else {
                AppMethodBeat.o(32545);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ezd ezd = (ezd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ezd.xNF = aVar3.UbS.zi();
                    AppMethodBeat.o(32545);
                    return 0;
                case 2:
                    ezd.MRZ = aVar3.UbS.readString();
                    AppMethodBeat.o(32545);
                    return 0;
                case 3:
                    ezd.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(32545);
                    return 0;
                case 4:
                    ezd.iAc = aVar3.UbS.readString();
                    AppMethodBeat.o(32545);
                    return 0;
                case 5:
                    ezd.MWA = aVar3.UbS.zi();
                    AppMethodBeat.o(32545);
                    return 0;
                case 6:
                    ezd.Nvo = aVar3.UbS.hPo();
                    AppMethodBeat.o(32545);
                    return 0;
                case 7:
                    ezd.NvF = aVar3.UbS.yZ();
                    AppMethodBeat.o(32545);
                    return 0;
                case 8:
                    ezd.NvG = aVar3.UbS.yZ();
                    AppMethodBeat.o(32545);
                    return 0;
                case 9:
                    ezd.NvH = aVar3.UbS.yZ();
                    AppMethodBeat.o(32545);
                    return 0;
                default:
                    AppMethodBeat.o(32545);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32545);
            return -1;
        }
    }
}
