package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class dde extends a {
    public String HFD;
    public String HLy;
    public String Hwr;
    public String Hws;
    public String MIh;
    public String dQx;
    public int type;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91620);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.dQx != null) {
                aVar.e(1, this.dQx);
            }
            aVar.aM(2, this.type);
            if (this.HLy != null) {
                aVar.e(3, this.HLy);
            }
            if (this.Hwr != null) {
                aVar.e(4, this.Hwr);
            }
            if (this.Hws != null) {
                aVar.e(5, this.Hws);
            }
            if (this.MIh != null) {
                aVar.e(6, this.MIh);
            }
            if (this.HFD != null) {
                aVar.e(7, this.HFD);
            }
            AppMethodBeat.o(91620);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.dQx != null ? g.a.a.b.b.a.f(1, this.dQx) + 0 : 0) + g.a.a.b.b.a.bu(2, this.type);
            if (this.HLy != null) {
                f2 += g.a.a.b.b.a.f(3, this.HLy);
            }
            if (this.Hwr != null) {
                f2 += g.a.a.b.b.a.f(4, this.Hwr);
            }
            if (this.Hws != null) {
                f2 += g.a.a.b.b.a.f(5, this.Hws);
            }
            if (this.MIh != null) {
                f2 += g.a.a.b.b.a.f(6, this.MIh);
            }
            if (this.HFD != null) {
                f2 += g.a.a.b.b.a.f(7, this.HFD);
            }
            AppMethodBeat.o(91620);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91620);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dde dde = (dde) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dde.dQx = aVar3.UbS.readString();
                    AppMethodBeat.o(91620);
                    return 0;
                case 2:
                    dde.type = aVar3.UbS.zi();
                    AppMethodBeat.o(91620);
                    return 0;
                case 3:
                    dde.HLy = aVar3.UbS.readString();
                    AppMethodBeat.o(91620);
                    return 0;
                case 4:
                    dde.Hwr = aVar3.UbS.readString();
                    AppMethodBeat.o(91620);
                    return 0;
                case 5:
                    dde.Hws = aVar3.UbS.readString();
                    AppMethodBeat.o(91620);
                    return 0;
                case 6:
                    dde.MIh = aVar3.UbS.readString();
                    AppMethodBeat.o(91620);
                    return 0;
                case 7:
                    dde.HFD = aVar3.UbS.readString();
                    AppMethodBeat.o(91620);
                    return 0;
                default:
                    AppMethodBeat.o(91620);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91620);
            return -1;
        }
    }
}
