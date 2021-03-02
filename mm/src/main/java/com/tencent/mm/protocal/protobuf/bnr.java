package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bnr extends dpc {
    public long LRV;
    public String LWe;
    public rx LWf;
    public de LWg;
    public int LWh;
    public int OpCode;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(114788);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(114788);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.OpCode);
            aVar.bb(3, this.LRV);
            if (this.LWg != null) {
                aVar.ni(4, this.LWg.computeSize());
                this.LWg.writeFields(aVar);
            }
            if (this.LWe != null) {
                aVar.e(5, this.LWe);
            }
            aVar.aM(6, this.LWh);
            if (this.LWf != null) {
                aVar.ni(7, this.LWf.computeSize());
                this.LWf.writeFields(aVar);
            }
            AppMethodBeat.o(114788);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.OpCode) + g.a.a.b.b.a.r(3, this.LRV);
            if (this.LWg != null) {
                nh += g.a.a.a.nh(4, this.LWg.computeSize());
            }
            if (this.LWe != null) {
                nh += g.a.a.b.b.a.f(5, this.LWe);
            }
            int bu = nh + g.a.a.b.b.a.bu(6, this.LWh);
            if (this.LWf != null) {
                bu += g.a.a.a.nh(7, this.LWf.computeSize());
            }
            AppMethodBeat.o(114788);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(114788);
                throw bVar2;
            }
            AppMethodBeat.o(114788);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bnr bnr = (bnr) objArr[1];
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
                        bnr.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(114788);
                    return 0;
                case 2:
                    bnr.OpCode = aVar3.UbS.zi();
                    AppMethodBeat.o(114788);
                    return 0;
                case 3:
                    bnr.LRV = aVar3.UbS.zl();
                    AppMethodBeat.o(114788);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        de deVar = new de();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = deVar.populateBuilderWithField(aVar5, deVar, dpc.getNextFieldNumber(aVar5))) {
                        }
                        bnr.LWg = deVar;
                    }
                    AppMethodBeat.o(114788);
                    return 0;
                case 5:
                    bnr.LWe = aVar3.UbS.readString();
                    AppMethodBeat.o(114788);
                    return 0;
                case 6:
                    bnr.LWh = aVar3.UbS.zi();
                    AppMethodBeat.o(114788);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        rx rxVar = new rx();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = rxVar.populateBuilderWithField(aVar6, rxVar, dpc.getNextFieldNumber(aVar6))) {
                        }
                        bnr.LWf = rxVar;
                    }
                    AppMethodBeat.o(114788);
                    return 0;
                default:
                    AppMethodBeat.o(114788);
                    return -1;
            }
        } else {
            AppMethodBeat.o(114788);
            return -1;
        }
    }
}
