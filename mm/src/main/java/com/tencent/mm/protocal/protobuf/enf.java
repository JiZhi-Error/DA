package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class enf extends a {
    public int BsF;
    public int BsG;
    public String LVq;
    public String MD5;
    public boolean Nlg;
    public boolean Nlh = false;
    public int Ret;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(104841);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.Ret);
            aVar.aM(2, this.BsG);
            aVar.aM(3, this.BsF);
            if (this.MD5 != null) {
                aVar.e(4, this.MD5);
            }
            aVar.cc(5, this.Nlg);
            if (this.LVq != null) {
                aVar.e(6, this.LVq);
            }
            aVar.cc(7, this.Nlh);
            AppMethodBeat.o(104841);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Ret) + 0 + g.a.a.b.b.a.bu(2, this.BsG) + g.a.a.b.b.a.bu(3, this.BsF);
            if (this.MD5 != null) {
                bu += g.a.a.b.b.a.f(4, this.MD5);
            }
            int fS = bu + g.a.a.b.b.a.fS(5) + 1;
            if (this.LVq != null) {
                fS += g.a.a.b.b.a.f(6, this.LVq);
            }
            int fS2 = fS + g.a.a.b.b.a.fS(7) + 1;
            AppMethodBeat.o(104841);
            return fS2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(104841);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            enf enf = (enf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    enf.Ret = aVar3.UbS.zi();
                    AppMethodBeat.o(104841);
                    return 0;
                case 2:
                    enf.BsG = aVar3.UbS.zi();
                    AppMethodBeat.o(104841);
                    return 0;
                case 3:
                    enf.BsF = aVar3.UbS.zi();
                    AppMethodBeat.o(104841);
                    return 0;
                case 4:
                    enf.MD5 = aVar3.UbS.readString();
                    AppMethodBeat.o(104841);
                    return 0;
                case 5:
                    enf.Nlg = aVar3.UbS.yZ();
                    AppMethodBeat.o(104841);
                    return 0;
                case 6:
                    enf.LVq = aVar3.UbS.readString();
                    AppMethodBeat.o(104841);
                    return 0;
                case 7:
                    enf.Nlh = aVar3.UbS.yZ();
                    AppMethodBeat.o(104841);
                    return 0;
                default:
                    AppMethodBeat.o(104841);
                    return -1;
            }
        } else {
            AppMethodBeat.o(104841);
            return -1;
        }
    }
}
