package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class wl extends a {
    public long connectSuccessfulTime;
    public long handshakeSuccessfulTime;
    public long readPacketFinishedTime;
    public long startConnectTime;
    public long startHandshakeTime;
    public long startReadPacketTime;
    public long startSendPacketTime;
    public long taskStartTime;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(197131);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.startConnectTime);
            aVar.bb(2, this.connectSuccessfulTime);
            aVar.bb(3, this.startHandshakeTime);
            aVar.bb(4, this.handshakeSuccessfulTime);
            aVar.bb(5, this.startSendPacketTime);
            aVar.bb(6, this.startReadPacketTime);
            aVar.bb(7, this.readPacketFinishedTime);
            aVar.bb(8, this.taskStartTime);
            AppMethodBeat.o(197131);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.startConnectTime) + 0 + g.a.a.b.b.a.r(2, this.connectSuccessfulTime) + g.a.a.b.b.a.r(3, this.startHandshakeTime) + g.a.a.b.b.a.r(4, this.handshakeSuccessfulTime) + g.a.a.b.b.a.r(5, this.startSendPacketTime) + g.a.a.b.b.a.r(6, this.startReadPacketTime) + g.a.a.b.b.a.r(7, this.readPacketFinishedTime) + g.a.a.b.b.a.r(8, this.taskStartTime);
            AppMethodBeat.o(197131);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(197131);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            wl wlVar = (wl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    wlVar.startConnectTime = aVar3.UbS.zl();
                    AppMethodBeat.o(197131);
                    return 0;
                case 2:
                    wlVar.connectSuccessfulTime = aVar3.UbS.zl();
                    AppMethodBeat.o(197131);
                    return 0;
                case 3:
                    wlVar.startHandshakeTime = aVar3.UbS.zl();
                    AppMethodBeat.o(197131);
                    return 0;
                case 4:
                    wlVar.handshakeSuccessfulTime = aVar3.UbS.zl();
                    AppMethodBeat.o(197131);
                    return 0;
                case 5:
                    wlVar.startSendPacketTime = aVar3.UbS.zl();
                    AppMethodBeat.o(197131);
                    return 0;
                case 6:
                    wlVar.startReadPacketTime = aVar3.UbS.zl();
                    AppMethodBeat.o(197131);
                    return 0;
                case 7:
                    wlVar.readPacketFinishedTime = aVar3.UbS.zl();
                    AppMethodBeat.o(197131);
                    return 0;
                case 8:
                    wlVar.taskStartTime = aVar3.UbS.zl();
                    AppMethodBeat.o(197131);
                    return 0;
                default:
                    AppMethodBeat.o(197131);
                    return -1;
            }
        } else {
            AppMethodBeat.o(197131);
            return -1;
        }
    }
}
