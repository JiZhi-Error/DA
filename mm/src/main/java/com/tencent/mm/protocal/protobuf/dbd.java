package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dbd extends dpc {
    public int MGd;
    public String MGe;
    public SKBuiltinBuffer_t MhT;
    public int MhU;
    public String MhV;
    public int MhW;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91611);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(91611);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.MhT != null) {
                aVar.ni(2, this.MhT.computeSize());
                this.MhT.writeFields(aVar);
            }
            aVar.aM(3, this.MhU);
            if (this.MhV != null) {
                aVar.e(4, this.MhV);
            }
            aVar.aM(5, this.MhW);
            aVar.aM(6, this.MGd);
            if (this.MGe != null) {
                aVar.e(7, this.MGe);
            }
            AppMethodBeat.o(91611);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.MhT != null) {
                nh += g.a.a.a.nh(2, this.MhT.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.MhU);
            if (this.MhV != null) {
                bu += g.a.a.b.b.a.f(4, this.MhV);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(5, this.MhW) + g.a.a.b.b.a.bu(6, this.MGd);
            if (this.MGe != null) {
                bu2 += g.a.a.b.b.a.f(7, this.MGe);
            }
            AppMethodBeat.o(91611);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(91611);
                throw bVar2;
            }
            AppMethodBeat.o(91611);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dbd dbd = (dbd) objArr[1];
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
                        dbd.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(91611);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t.populateBuilderWithField(aVar5, sKBuiltinBuffer_t, dpc.getNextFieldNumber(aVar5))) {
                        }
                        dbd.MhT = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(91611);
                    return 0;
                case 3:
                    dbd.MhU = aVar3.UbS.zi();
                    AppMethodBeat.o(91611);
                    return 0;
                case 4:
                    dbd.MhV = aVar3.UbS.readString();
                    AppMethodBeat.o(91611);
                    return 0;
                case 5:
                    dbd.MhW = aVar3.UbS.zi();
                    AppMethodBeat.o(91611);
                    return 0;
                case 6:
                    dbd.MGd = aVar3.UbS.zi();
                    AppMethodBeat.o(91611);
                    return 0;
                case 7:
                    dbd.MGe = aVar3.UbS.readString();
                    AppMethodBeat.o(91611);
                    return 0;
                default:
                    AppMethodBeat.o(91611);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91611);
            return -1;
        }
    }
}
