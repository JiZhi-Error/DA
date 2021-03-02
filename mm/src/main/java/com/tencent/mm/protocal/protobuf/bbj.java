package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class bbj extends a {
    public int KWR;
    public String LKO;
    public int LKP;
    public int LKQ;
    public long LKR;
    public int LXl;
    public b VjF;
    public int VjG;
    public long object_id;
    public String object_nonce_id;
    public b tabTipsByPassInfo;
    public int tab_type;
    public String username;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209649);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LKO != null) {
                aVar.e(1, this.LKO);
            }
            if (this.username != null) {
                aVar.e(2, this.username);
            }
            aVar.aM(3, this.LKP);
            aVar.bb(4, this.object_id);
            aVar.aM(5, this.LKQ);
            aVar.aM(6, this.KWR);
            aVar.bb(7, this.LKR);
            if (this.tabTipsByPassInfo != null) {
                aVar.c(8, this.tabTipsByPassInfo);
            }
            if (this.object_nonce_id != null) {
                aVar.e(9, this.object_nonce_id);
            }
            aVar.aM(10, this.tab_type);
            aVar.aM(11, this.LXl);
            if (this.VjF != null) {
                aVar.c(12, this.VjF);
            }
            aVar.aM(13, this.VjG);
            AppMethodBeat.o(209649);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.LKO != null ? g.a.a.b.b.a.f(1, this.LKO) + 0 : 0;
            if (this.username != null) {
                f2 += g.a.a.b.b.a.f(2, this.username);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.LKP) + g.a.a.b.b.a.r(4, this.object_id) + g.a.a.b.b.a.bu(5, this.LKQ) + g.a.a.b.b.a.bu(6, this.KWR) + g.a.a.b.b.a.r(7, this.LKR);
            if (this.tabTipsByPassInfo != null) {
                bu += g.a.a.b.b.a.b(8, this.tabTipsByPassInfo);
            }
            if (this.object_nonce_id != null) {
                bu += g.a.a.b.b.a.f(9, this.object_nonce_id);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(10, this.tab_type) + g.a.a.b.b.a.bu(11, this.LXl);
            if (this.VjF != null) {
                bu2 += g.a.a.b.b.a.b(12, this.VjF);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(13, this.VjG);
            AppMethodBeat.o(209649);
            return bu3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209649);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bbj bbj = (bbj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bbj.LKO = aVar3.UbS.readString();
                    AppMethodBeat.o(209649);
                    return 0;
                case 2:
                    bbj.username = aVar3.UbS.readString();
                    AppMethodBeat.o(209649);
                    return 0;
                case 3:
                    bbj.LKP = aVar3.UbS.zi();
                    AppMethodBeat.o(209649);
                    return 0;
                case 4:
                    bbj.object_id = aVar3.UbS.zl();
                    AppMethodBeat.o(209649);
                    return 0;
                case 5:
                    bbj.LKQ = aVar3.UbS.zi();
                    AppMethodBeat.o(209649);
                    return 0;
                case 6:
                    bbj.KWR = aVar3.UbS.zi();
                    AppMethodBeat.o(209649);
                    return 0;
                case 7:
                    bbj.LKR = aVar3.UbS.zl();
                    AppMethodBeat.o(209649);
                    return 0;
                case 8:
                    bbj.tabTipsByPassInfo = aVar3.UbS.hPo();
                    AppMethodBeat.o(209649);
                    return 0;
                case 9:
                    bbj.object_nonce_id = aVar3.UbS.readString();
                    AppMethodBeat.o(209649);
                    return 0;
                case 10:
                    bbj.tab_type = aVar3.UbS.zi();
                    AppMethodBeat.o(209649);
                    return 0;
                case 11:
                    bbj.LXl = aVar3.UbS.zi();
                    AppMethodBeat.o(209649);
                    return 0;
                case 12:
                    bbj.VjF = aVar3.UbS.hPo();
                    AppMethodBeat.o(209649);
                    return 0;
                case 13:
                    bbj.VjG = aVar3.UbS.zi();
                    AppMethodBeat.o(209649);
                    return 0;
                default:
                    AppMethodBeat.o(209649);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209649);
            return -1;
        }
    }
}
