package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class edg extends a {
    public int ECO;
    public int FnS;
    public String Foa;
    public int Fob;
    public int NdF;
    public int NdG;
    public String clientId;
    public String content;
    public String dRL;
    public long edx;
    public int iXu;
    public int retryCount;
    public String sessionId;
    public int state;
    public String toUser;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(118533);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.dRL == null) {
                b bVar = new b("Not all required fields were included: fromUser");
                AppMethodBeat.o(118533);
                throw bVar;
            } else if (this.toUser == null) {
                b bVar2 = new b("Not all required fields were included: toUser");
                AppMethodBeat.o(118533);
                throw bVar2;
            } else {
                aVar.bb(1, this.edx);
                aVar.aM(2, this.iXu);
                if (this.dRL != null) {
                    aVar.e(3, this.dRL);
                }
                if (this.toUser != null) {
                    aVar.e(4, this.toUser);
                }
                if (this.content != null) {
                    aVar.e(5, this.content);
                }
                aVar.aM(6, this.state);
                if (this.clientId != null) {
                    aVar.e(7, this.clientId);
                }
                aVar.aM(8, this.FnS);
                aVar.aM(9, this.NdF);
                aVar.aM(10, this.retryCount);
                aVar.aM(11, this.NdG);
                if (this.sessionId != null) {
                    aVar.e(12, this.sessionId);
                }
                if (this.Foa != null) {
                    aVar.e(13, this.Foa);
                }
                aVar.aM(14, this.Fob);
                aVar.aM(15, this.ECO);
                AppMethodBeat.o(118533);
                return 0;
            }
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.edx) + 0 + g.a.a.b.b.a.bu(2, this.iXu);
            if (this.dRL != null) {
                r += g.a.a.b.b.a.f(3, this.dRL);
            }
            if (this.toUser != null) {
                r += g.a.a.b.b.a.f(4, this.toUser);
            }
            if (this.content != null) {
                r += g.a.a.b.b.a.f(5, this.content);
            }
            int bu = r + g.a.a.b.b.a.bu(6, this.state);
            if (this.clientId != null) {
                bu += g.a.a.b.b.a.f(7, this.clientId);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(8, this.FnS) + g.a.a.b.b.a.bu(9, this.NdF) + g.a.a.b.b.a.bu(10, this.retryCount) + g.a.a.b.b.a.bu(11, this.NdG);
            if (this.sessionId != null) {
                bu2 += g.a.a.b.b.a.f(12, this.sessionId);
            }
            if (this.Foa != null) {
                bu2 += g.a.a.b.b.a.f(13, this.Foa);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(14, this.Fob) + g.a.a.b.b.a.bu(15, this.ECO);
            AppMethodBeat.o(118533);
            return bu3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.dRL == null) {
                b bVar3 = new b("Not all required fields were included: fromUser");
                AppMethodBeat.o(118533);
                throw bVar3;
            } else if (this.toUser == null) {
                b bVar4 = new b("Not all required fields were included: toUser");
                AppMethodBeat.o(118533);
                throw bVar4;
            } else {
                AppMethodBeat.o(118533);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            edg edg = (edg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    edg.edx = aVar3.UbS.zl();
                    AppMethodBeat.o(118533);
                    return 0;
                case 2:
                    edg.iXu = aVar3.UbS.zi();
                    AppMethodBeat.o(118533);
                    return 0;
                case 3:
                    edg.dRL = aVar3.UbS.readString();
                    AppMethodBeat.o(118533);
                    return 0;
                case 4:
                    edg.toUser = aVar3.UbS.readString();
                    AppMethodBeat.o(118533);
                    return 0;
                case 5:
                    edg.content = aVar3.UbS.readString();
                    AppMethodBeat.o(118533);
                    return 0;
                case 6:
                    edg.state = aVar3.UbS.zi();
                    AppMethodBeat.o(118533);
                    return 0;
                case 7:
                    edg.clientId = aVar3.UbS.readString();
                    AppMethodBeat.o(118533);
                    return 0;
                case 8:
                    edg.FnS = aVar3.UbS.zi();
                    AppMethodBeat.o(118533);
                    return 0;
                case 9:
                    edg.NdF = aVar3.UbS.zi();
                    AppMethodBeat.o(118533);
                    return 0;
                case 10:
                    edg.retryCount = aVar3.UbS.zi();
                    AppMethodBeat.o(118533);
                    return 0;
                case 11:
                    edg.NdG = aVar3.UbS.zi();
                    AppMethodBeat.o(118533);
                    return 0;
                case 12:
                    edg.sessionId = aVar3.UbS.readString();
                    AppMethodBeat.o(118533);
                    return 0;
                case 13:
                    edg.Foa = aVar3.UbS.readString();
                    AppMethodBeat.o(118533);
                    return 0;
                case 14:
                    edg.Fob = aVar3.UbS.zi();
                    AppMethodBeat.o(118533);
                    return 0;
                case 15:
                    edg.ECO = aVar3.UbS.zi();
                    AppMethodBeat.o(118533);
                    return 0;
                default:
                    AppMethodBeat.o(118533);
                    return -1;
            }
        } else {
            AppMethodBeat.o(118533);
            return -1;
        }
    }
}
