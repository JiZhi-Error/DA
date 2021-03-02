package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public class IMBehaviorChattingOP extends a {
    public int changeNotifyStatus;
    public int changeSaveAddress;
    public int changeTop;
    public int changeUnread;
    public int expose;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(151536);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.changeUnread);
            aVar.aM(2, this.changeTop);
            aVar.aM(3, this.changeNotifyStatus);
            aVar.aM(4, this.changeSaveAddress);
            aVar.aM(5, this.expose);
            AppMethodBeat.o(151536);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.changeUnread) + 0 + g.a.a.b.b.a.bu(2, this.changeTop) + g.a.a.b.b.a.bu(3, this.changeNotifyStatus) + g.a.a.b.b.a.bu(4, this.changeSaveAddress) + g.a.a.b.b.a.bu(5, this.expose);
            AppMethodBeat.o(151536);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(151536);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            IMBehaviorChattingOP iMBehaviorChattingOP = (IMBehaviorChattingOP) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    iMBehaviorChattingOP.changeUnread = aVar3.UbS.zi();
                    AppMethodBeat.o(151536);
                    return 0;
                case 2:
                    iMBehaviorChattingOP.changeTop = aVar3.UbS.zi();
                    AppMethodBeat.o(151536);
                    return 0;
                case 3:
                    iMBehaviorChattingOP.changeNotifyStatus = aVar3.UbS.zi();
                    AppMethodBeat.o(151536);
                    return 0;
                case 4:
                    iMBehaviorChattingOP.changeSaveAddress = aVar3.UbS.zi();
                    AppMethodBeat.o(151536);
                    return 0;
                case 5:
                    iMBehaviorChattingOP.expose = aVar3.UbS.zi();
                    AppMethodBeat.o(151536);
                    return 0;
                default:
                    AppMethodBeat.o(151536);
                    return -1;
            }
        } else {
            AppMethodBeat.o(151536);
            return -1;
        }
    }
}
