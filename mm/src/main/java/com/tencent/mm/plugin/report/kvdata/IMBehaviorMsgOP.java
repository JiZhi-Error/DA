package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public class IMBehaviorMsgOP extends a {
    public int appMsgInnerType;
    public int count;
    public int msgOpType;
    public int msgType;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(151537);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.msgType);
            aVar.aM(2, this.msgOpType);
            aVar.aM(3, this.appMsgInnerType);
            aVar.aM(4, this.count);
            AppMethodBeat.o(151537);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.msgType) + 0 + g.a.a.b.b.a.bu(2, this.msgOpType) + g.a.a.b.b.a.bu(3, this.appMsgInnerType) + g.a.a.b.b.a.bu(4, this.count);
            AppMethodBeat.o(151537);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(151537);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            IMBehaviorMsgOP iMBehaviorMsgOP = (IMBehaviorMsgOP) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    iMBehaviorMsgOP.msgType = aVar3.UbS.zi();
                    AppMethodBeat.o(151537);
                    return 0;
                case 2:
                    iMBehaviorMsgOP.msgOpType = aVar3.UbS.zi();
                    AppMethodBeat.o(151537);
                    return 0;
                case 3:
                    iMBehaviorMsgOP.appMsgInnerType = aVar3.UbS.zi();
                    AppMethodBeat.o(151537);
                    return 0;
                case 4:
                    iMBehaviorMsgOP.count = aVar3.UbS.zi();
                    AppMethodBeat.o(151537);
                    return 0;
                default:
                    AppMethodBeat.o(151537);
                    return -1;
            }
        } else {
            AppMethodBeat.o(151537);
            return -1;
        }
    }
}
