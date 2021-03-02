package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class enn extends dpc {
    public SKBuiltinBuffer_t Nlq;
    public int jeU;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(148658);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(148658);
                throw bVar;
            } else if (this.Nlq == null) {
                b bVar2 = new b("Not all required fields were included: Text");
                AppMethodBeat.o(148658);
                throw bVar2;
            } else {
                if (this.BaseResponse != null) {
                    aVar.ni(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                aVar.aM(2, this.jeU);
                if (this.Nlq != null) {
                    aVar.ni(3, this.Nlq.computeSize());
                    this.Nlq.writeFields(aVar);
                }
                AppMethodBeat.o(148658);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.jeU);
            if (this.Nlq != null) {
                nh += g.a.a.a.nh(3, this.Nlq.computeSize());
            }
            AppMethodBeat.o(148658);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar3 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(148658);
                throw bVar3;
            } else if (this.Nlq == null) {
                b bVar4 = new b("Not all required fields were included: Text");
                AppMethodBeat.o(148658);
                throw bVar4;
            } else {
                AppMethodBeat.o(148658);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            enn enn = (enn) objArr[1];
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
                        enn.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(148658);
                    return 0;
                case 2:
                    enn.jeU = aVar3.UbS.zi();
                    AppMethodBeat.o(148658);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t.populateBuilderWithField(aVar5, sKBuiltinBuffer_t, dpc.getNextFieldNumber(aVar5))) {
                        }
                        enn.Nlq = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(148658);
                    return 0;
                default:
                    AppMethodBeat.o(148658);
                    return -1;
            }
        } else {
            AppMethodBeat.o(148658);
            return -1;
        }
    }
}
