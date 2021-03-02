package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ebk extends dop {
    public String MZg;
    public long MZh;
    public int NaA;
    public long Nau;
    public int Nav;
    public int Nbe;
    public String Username;
    public int xub;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125835);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.MZg != null) {
                aVar.e(2, this.MZg);
            }
            if (this.Username != null) {
                aVar.e(3, this.Username);
            }
            aVar.bb(4, this.MZh);
            aVar.aM(5, this.xub);
            aVar.bb(6, this.Nau);
            aVar.aM(7, this.Nav);
            aVar.aM(8, this.Nbe);
            aVar.aM(9, this.NaA);
            AppMethodBeat.o(125835);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.MZg != null) {
                nh += g.a.a.b.b.a.f(2, this.MZg);
            }
            if (this.Username != null) {
                nh += g.a.a.b.b.a.f(3, this.Username);
            }
            int r = nh + g.a.a.b.b.a.r(4, this.MZh) + g.a.a.b.b.a.bu(5, this.xub) + g.a.a.b.b.a.r(6, this.Nau) + g.a.a.b.b.a.bu(7, this.Nav) + g.a.a.b.b.a.bu(8, this.Nbe) + g.a.a.b.b.a.bu(9, this.NaA);
            AppMethodBeat.o(125835);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(125835);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ebk ebk = (ebk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        jr jrVar = new jr();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = jrVar.populateBuilderWithField(aVar4, jrVar, dop.getNextFieldNumber(aVar4))) {
                        }
                        ebk.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(125835);
                    return 0;
                case 2:
                    ebk.MZg = aVar3.UbS.readString();
                    AppMethodBeat.o(125835);
                    return 0;
                case 3:
                    ebk.Username = aVar3.UbS.readString();
                    AppMethodBeat.o(125835);
                    return 0;
                case 4:
                    ebk.MZh = aVar3.UbS.zl();
                    AppMethodBeat.o(125835);
                    return 0;
                case 5:
                    ebk.xub = aVar3.UbS.zi();
                    AppMethodBeat.o(125835);
                    return 0;
                case 6:
                    ebk.Nau = aVar3.UbS.zl();
                    AppMethodBeat.o(125835);
                    return 0;
                case 7:
                    ebk.Nav = aVar3.UbS.zi();
                    AppMethodBeat.o(125835);
                    return 0;
                case 8:
                    ebk.Nbe = aVar3.UbS.zi();
                    AppMethodBeat.o(125835);
                    return 0;
                case 9:
                    ebk.NaA = aVar3.UbS.zi();
                    AppMethodBeat.o(125835);
                    return 0;
                default:
                    AppMethodBeat.o(125835);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125835);
            return -1;
        }
    }
}
