package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class btf extends dpc {
    public dgn LZP;
    public dgl LZQ;
    public int him;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(155413);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(155413);
                throw bVar;
            } else if (this.LZP == null) {
                b bVar2 = new b("Not all required fields were included: QQGroup");
                AppMethodBeat.o(155413);
                throw bVar2;
            } else if (this.LZQ == null) {
                b bVar3 = new b("Not all required fields were included: QQFriend");
                AppMethodBeat.o(155413);
                throw bVar3;
            } else {
                if (this.BaseResponse != null) {
                    aVar.ni(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                aVar.aM(2, this.him);
                if (this.LZP != null) {
                    aVar.ni(3, this.LZP.computeSize());
                    this.LZP.writeFields(aVar);
                }
                if (this.LZQ != null) {
                    aVar.ni(4, this.LZQ.computeSize());
                    this.LZQ.writeFields(aVar);
                }
                AppMethodBeat.o(155413);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.him);
            if (this.LZP != null) {
                nh += g.a.a.a.nh(3, this.LZP.computeSize());
            }
            if (this.LZQ != null) {
                nh += g.a.a.a.nh(4, this.LZQ.computeSize());
            }
            AppMethodBeat.o(155413);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar4 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(155413);
                throw bVar4;
            } else if (this.LZP == null) {
                b bVar5 = new b("Not all required fields were included: QQGroup");
                AppMethodBeat.o(155413);
                throw bVar5;
            } else if (this.LZQ == null) {
                b bVar6 = new b("Not all required fields were included: QQFriend");
                AppMethodBeat.o(155413);
                throw bVar6;
            } else {
                AppMethodBeat.o(155413);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            btf btf = (btf) objArr[1];
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
                        btf.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(155413);
                    return 0;
                case 2:
                    btf.him = aVar3.UbS.zi();
                    AppMethodBeat.o(155413);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dgn dgn = new dgn();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dgn.populateBuilderWithField(aVar5, dgn, dpc.getNextFieldNumber(aVar5))) {
                        }
                        btf.LZP = dgn;
                    }
                    AppMethodBeat.o(155413);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dgl dgl = new dgl();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dgl.populateBuilderWithField(aVar6, dgl, dpc.getNextFieldNumber(aVar6))) {
                        }
                        btf.LZQ = dgl;
                    }
                    AppMethodBeat.o(155413);
                    return 0;
                default:
                    AppMethodBeat.o(155413);
                    return -1;
            }
        } else {
            AppMethodBeat.o(155413);
            return -1;
        }
    }
}
