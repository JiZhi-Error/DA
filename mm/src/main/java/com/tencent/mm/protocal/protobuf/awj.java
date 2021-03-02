package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class awj extends a {
    public b LDs;
    public int LHd;
    public LinkedList<awi> LHe = new LinkedList<>();
    public long hFK;
    public long liveId;
    public String objectNonceId;
    public int tUC;

    public awj() {
        AppMethodBeat.i(209530);
        AppMethodBeat.o(209530);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209531);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.LHd);
            aVar.e(2, 8, this.LHe);
            aVar.bb(3, this.liveId);
            aVar.bb(4, this.hFK);
            if (this.objectNonceId != null) {
                aVar.e(5, this.objectNonceId);
            }
            aVar.aM(7, this.tUC);
            if (this.LDs != null) {
                aVar.c(8, this.LDs);
            }
            AppMethodBeat.o(209531);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.LHd) + 0 + g.a.a.a.c(2, 8, this.LHe) + g.a.a.b.b.a.r(3, this.liveId) + g.a.a.b.b.a.r(4, this.hFK);
            if (this.objectNonceId != null) {
                bu += g.a.a.b.b.a.f(5, this.objectNonceId);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(7, this.tUC);
            if (this.LDs != null) {
                bu2 += g.a.a.b.b.a.b(8, this.LDs);
            }
            AppMethodBeat.o(209531);
            return bu2;
        } else if (i2 == 2) {
            this.LHe.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209531);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            awj awj = (awj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    awj.LHd = aVar3.UbS.zi();
                    AppMethodBeat.o(209531);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        awi awi = new awi();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = awi.populateBuilderWithField(aVar4, awi, a.getNextFieldNumber(aVar4))) {
                        }
                        awj.LHe.add(awi);
                    }
                    AppMethodBeat.o(209531);
                    return 0;
                case 3:
                    awj.liveId = aVar3.UbS.zl();
                    AppMethodBeat.o(209531);
                    return 0;
                case 4:
                    awj.hFK = aVar3.UbS.zl();
                    AppMethodBeat.o(209531);
                    return 0;
                case 5:
                    awj.objectNonceId = aVar3.UbS.readString();
                    AppMethodBeat.o(209531);
                    return 0;
                case 6:
                default:
                    AppMethodBeat.o(209531);
                    return -1;
                case 7:
                    awj.tUC = aVar3.UbS.zi();
                    AppMethodBeat.o(209531);
                    return 0;
                case 8:
                    awj.LDs = aVar3.UbS.hPo();
                    AppMethodBeat.o(209531);
                    return 0;
            }
        } else {
            AppMethodBeat.o(209531);
            return -1;
        }
    }
}
