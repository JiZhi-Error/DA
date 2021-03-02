package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class czc extends a {
    public int KWb;
    public String Lrs;
    public int Lrt;
    public String Lru;
    public String MEn;
    public String MEo;
    public String MEp;
    public String UserName;
    public String query;
    public String xIy;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117887);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.KWb);
            if (this.xIy != null) {
                aVar.e(2, this.xIy);
            }
            if (this.UserName != null) {
                aVar.e(3, this.UserName);
            }
            if (this.Lrs != null) {
                aVar.e(4, this.Lrs);
            }
            aVar.aM(5, this.Lrt);
            if (this.Lru != null) {
                aVar.e(6, this.Lru);
            }
            if (this.MEn != null) {
                aVar.e(7, this.MEn);
            }
            if (this.MEo != null) {
                aVar.e(8, this.MEo);
            }
            if (this.query != null) {
                aVar.e(100, this.query);
            }
            if (this.MEp != null) {
                aVar.e(101, this.MEp);
            }
            AppMethodBeat.o(117887);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.KWb) + 0;
            if (this.xIy != null) {
                bu += g.a.a.b.b.a.f(2, this.xIy);
            }
            if (this.UserName != null) {
                bu += g.a.a.b.b.a.f(3, this.UserName);
            }
            if (this.Lrs != null) {
                bu += g.a.a.b.b.a.f(4, this.Lrs);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(5, this.Lrt);
            if (this.Lru != null) {
                bu2 += g.a.a.b.b.a.f(6, this.Lru);
            }
            if (this.MEn != null) {
                bu2 += g.a.a.b.b.a.f(7, this.MEn);
            }
            if (this.MEo != null) {
                bu2 += g.a.a.b.b.a.f(8, this.MEo);
            }
            if (this.query != null) {
                bu2 += g.a.a.b.b.a.f(100, this.query);
            }
            if (this.MEp != null) {
                bu2 += g.a.a.b.b.a.f(101, this.MEp);
            }
            AppMethodBeat.o(117887);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(117887);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            czc czc = (czc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    czc.KWb = aVar3.UbS.zi();
                    AppMethodBeat.o(117887);
                    return 0;
                case 2:
                    czc.xIy = aVar3.UbS.readString();
                    AppMethodBeat.o(117887);
                    return 0;
                case 3:
                    czc.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(117887);
                    return 0;
                case 4:
                    czc.Lrs = aVar3.UbS.readString();
                    AppMethodBeat.o(117887);
                    return 0;
                case 5:
                    czc.Lrt = aVar3.UbS.zi();
                    AppMethodBeat.o(117887);
                    return 0;
                case 6:
                    czc.Lru = aVar3.UbS.readString();
                    AppMethodBeat.o(117887);
                    return 0;
                case 7:
                    czc.MEn = aVar3.UbS.readString();
                    AppMethodBeat.o(117887);
                    return 0;
                case 8:
                    czc.MEo = aVar3.UbS.readString();
                    AppMethodBeat.o(117887);
                    return 0;
                case 100:
                    czc.query = aVar3.UbS.readString();
                    AppMethodBeat.o(117887);
                    return 0;
                case 101:
                    czc.MEp = aVar3.UbS.readString();
                    AppMethodBeat.o(117887);
                    return 0;
                default:
                    AppMethodBeat.o(117887);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117887);
            return -1;
        }
    }
}
