package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class bgy extends a {
    public LinkedList<cmt> GzC = new LinkedList<>();
    public long KPk;
    public long KPl;
    public boolean KPn = false;
    public dus LQH;
    public long LQI = 10;
    public long LQJ = 0;
    public long LQK = 0;
    public long LQL = 0;
    public long LQM = 0;
    public long uin;

    public bgy() {
        AppMethodBeat.i(110895);
        AppMethodBeat.o(110895);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(110896);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.KPk);
            aVar.bb(2, this.uin);
            aVar.bb(3, this.KPl);
            aVar.e(4, 8, this.GzC);
            if (this.LQH != null) {
                aVar.ni(5, this.LQH.computeSize());
                this.LQH.writeFields(aVar);
            }
            aVar.bb(6, this.LQI);
            aVar.bb(7, this.LQJ);
            aVar.cc(8, this.KPn);
            aVar.bb(9, this.LQK);
            aVar.bb(10, this.LQL);
            aVar.bb(11, this.LQM);
            AppMethodBeat.o(110896);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.KPk) + 0 + g.a.a.b.b.a.r(2, this.uin) + g.a.a.b.b.a.r(3, this.KPl) + g.a.a.a.c(4, 8, this.GzC);
            if (this.LQH != null) {
                r += g.a.a.a.nh(5, this.LQH.computeSize());
            }
            int r2 = r + g.a.a.b.b.a.r(6, this.LQI) + g.a.a.b.b.a.r(7, this.LQJ) + g.a.a.b.b.a.fS(8) + 1 + g.a.a.b.b.a.r(9, this.LQK) + g.a.a.b.b.a.r(10, this.LQL) + g.a.a.b.b.a.r(11, this.LQM);
            AppMethodBeat.o(110896);
            return r2;
        } else if (i2 == 2) {
            this.GzC.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(110896);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bgy bgy = (bgy) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bgy.KPk = aVar3.UbS.zl();
                    AppMethodBeat.o(110896);
                    return 0;
                case 2:
                    bgy.uin = aVar3.UbS.zl();
                    AppMethodBeat.o(110896);
                    return 0;
                case 3:
                    bgy.KPl = aVar3.UbS.zl();
                    AppMethodBeat.o(110896);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cmt cmt = new cmt();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cmt.populateBuilderWithField(aVar4, cmt, a.getNextFieldNumber(aVar4))) {
                        }
                        bgy.GzC.add(cmt);
                    }
                    AppMethodBeat.o(110896);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dus dus = new dus();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dus.populateBuilderWithField(aVar5, dus, a.getNextFieldNumber(aVar5))) {
                        }
                        bgy.LQH = dus;
                    }
                    AppMethodBeat.o(110896);
                    return 0;
                case 6:
                    bgy.LQI = aVar3.UbS.zl();
                    AppMethodBeat.o(110896);
                    return 0;
                case 7:
                    bgy.LQJ = aVar3.UbS.zl();
                    AppMethodBeat.o(110896);
                    return 0;
                case 8:
                    bgy.KPn = aVar3.UbS.yZ();
                    AppMethodBeat.o(110896);
                    return 0;
                case 9:
                    bgy.LQK = aVar3.UbS.zl();
                    AppMethodBeat.o(110896);
                    return 0;
                case 10:
                    bgy.LQL = aVar3.UbS.zl();
                    AppMethodBeat.o(110896);
                    return 0;
                case 11:
                    bgy.LQM = aVar3.UbS.zl();
                    AppMethodBeat.o(110896);
                    return 0;
                default:
                    AppMethodBeat.o(110896);
                    return -1;
            }
        } else {
            AppMethodBeat.o(110896);
            return -1;
        }
    }
}
