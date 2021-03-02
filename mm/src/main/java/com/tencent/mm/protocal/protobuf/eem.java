package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class eem extends dop {
    public String KGO;
    public String MZg;
    public long MZh;
    public long Nau;
    public int Nav;
    public long NeG;
    public String UserName;
    public int xub;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(118476);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.MZg != null) {
                aVar.e(2, this.MZg);
            }
            if (this.UserName != null) {
                aVar.e(3, this.UserName);
            }
            aVar.bb(4, this.MZh);
            aVar.bb(5, this.Nau);
            aVar.aM(6, this.Nav);
            aVar.bb(7, this.NeG);
            aVar.aM(8, this.xub);
            if (this.KGO != null) {
                aVar.e(9, this.KGO);
            }
            AppMethodBeat.o(118476);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.MZg != null) {
                nh += g.a.a.b.b.a.f(2, this.MZg);
            }
            if (this.UserName != null) {
                nh += g.a.a.b.b.a.f(3, this.UserName);
            }
            int r = nh + g.a.a.b.b.a.r(4, this.MZh) + g.a.a.b.b.a.r(5, this.Nau) + g.a.a.b.b.a.bu(6, this.Nav) + g.a.a.b.b.a.r(7, this.NeG) + g.a.a.b.b.a.bu(8, this.xub);
            if (this.KGO != null) {
                r += g.a.a.b.b.a.f(9, this.KGO);
            }
            AppMethodBeat.o(118476);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(118476);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eem eem = (eem) objArr[1];
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
                        eem.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(118476);
                    return 0;
                case 2:
                    eem.MZg = aVar3.UbS.readString();
                    AppMethodBeat.o(118476);
                    return 0;
                case 3:
                    eem.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(118476);
                    return 0;
                case 4:
                    eem.MZh = aVar3.UbS.zl();
                    AppMethodBeat.o(118476);
                    return 0;
                case 5:
                    eem.Nau = aVar3.UbS.zl();
                    AppMethodBeat.o(118476);
                    return 0;
                case 6:
                    eem.Nav = aVar3.UbS.zi();
                    AppMethodBeat.o(118476);
                    return 0;
                case 7:
                    eem.NeG = aVar3.UbS.zl();
                    AppMethodBeat.o(118476);
                    return 0;
                case 8:
                    eem.xub = aVar3.UbS.zi();
                    AppMethodBeat.o(118476);
                    return 0;
                case 9:
                    eem.KGO = aVar3.UbS.readString();
                    AppMethodBeat.o(118476);
                    return 0;
                default:
                    AppMethodBeat.o(118476);
                    return -1;
            }
        } else {
            AppMethodBeat.o(118476);
            return -1;
        }
    }
}
