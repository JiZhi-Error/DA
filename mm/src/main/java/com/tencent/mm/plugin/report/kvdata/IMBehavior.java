package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public class IMBehavior extends a {
    public IMBehaviorChattingOP chattingOp;
    public IMBehaviorMsgOP msgOp;
    public int opType;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(151535);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.opType);
            if (this.chattingOp != null) {
                aVar.ni(2, this.chattingOp.computeSize());
                this.chattingOp.writeFields(aVar);
            }
            if (this.msgOp != null) {
                aVar.ni(3, this.msgOp.computeSize());
                this.msgOp.writeFields(aVar);
            }
            AppMethodBeat.o(151535);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.opType) + 0;
            if (this.chattingOp != null) {
                bu += g.a.a.a.nh(2, this.chattingOp.computeSize());
            }
            if (this.msgOp != null) {
                bu += g.a.a.a.nh(3, this.msgOp.computeSize());
            }
            AppMethodBeat.o(151535);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(151535);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            IMBehavior iMBehavior = (IMBehavior) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    iMBehavior.opType = aVar3.UbS.zi();
                    AppMethodBeat.o(151535);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        IMBehaviorChattingOP iMBehaviorChattingOP = new IMBehaviorChattingOP();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = iMBehaviorChattingOP.populateBuilderWithField(aVar4, iMBehaviorChattingOP, a.getNextFieldNumber(aVar4))) {
                        }
                        iMBehavior.chattingOp = iMBehaviorChattingOP;
                    }
                    AppMethodBeat.o(151535);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        IMBehaviorMsgOP iMBehaviorMsgOP = new IMBehaviorMsgOP();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = iMBehaviorMsgOP.populateBuilderWithField(aVar5, iMBehaviorMsgOP, a.getNextFieldNumber(aVar5))) {
                        }
                        iMBehavior.msgOp = iMBehaviorMsgOP;
                    }
                    AppMethodBeat.o(151535);
                    return 0;
                default:
                    AppMethodBeat.o(151535);
                    return -1;
            }
        } else {
            AppMethodBeat.o(151535);
            return -1;
        }
    }
}
