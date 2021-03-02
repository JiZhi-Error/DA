package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class blf extends dpc {
    public String LUh;
    public xg LUi;
    public int oTw;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(101815);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(101815);
                throw bVar;
            } else if (this.LUi == null) {
                b bVar2 = new b("Not all required fields were included: NewChatroomData");
                AppMethodBeat.o(101815);
                throw bVar2;
            } else {
                if (this.BaseResponse != null) {
                    aVar.ni(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                if (this.LUh != null) {
                    aVar.e(2, this.LUh);
                }
                aVar.aM(3, this.oTw);
                if (this.LUi != null) {
                    aVar.ni(4, this.LUi.computeSize());
                    this.LUi.writeFields(aVar);
                }
                AppMethodBeat.o(101815);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.LUh != null) {
                nh += g.a.a.b.b.a.f(2, this.LUh);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.oTw);
            if (this.LUi != null) {
                bu += g.a.a.a.nh(4, this.LUi.computeSize());
            }
            AppMethodBeat.o(101815);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar3 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(101815);
                throw bVar3;
            } else if (this.LUi == null) {
                b bVar4 = new b("Not all required fields were included: NewChatroomData");
                AppMethodBeat.o(101815);
                throw bVar4;
            } else {
                AppMethodBeat.o(101815);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            blf blf = (blf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        BaseResponse baseResponse = new BaseResponse();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = baseResponse.populateBuilderWithField(aVar4, baseResponse, dpc.getNextFieldNumber(aVar4))) {
                        }
                        blf.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(101815);
                    return 0;
                case 2:
                    blf.LUh = aVar3.UbS.readString();
                    AppMethodBeat.o(101815);
                    return 0;
                case 3:
                    blf.oTw = aVar3.UbS.zi();
                    AppMethodBeat.o(101815);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        xg xgVar = new xg();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = xgVar.populateBuilderWithField(aVar5, xgVar, dpc.getNextFieldNumber(aVar5))) {
                        }
                        blf.LUi = xgVar;
                    }
                    AppMethodBeat.o(101815);
                    return 0;
                default:
                    AppMethodBeat.o(101815);
                    return -1;
            }
        } else {
            AppMethodBeat.o(101815);
            return -1;
        }
    }
}
