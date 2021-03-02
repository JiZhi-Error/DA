package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class esp extends dpc {
    public int LsZ;
    public long Lta;
    public int NpI;
    public int NpR;
    public eue NpS;
    public int NpT;
    public int NpU;
    public int NpV;
    public int NpW;
    public SKBuiltinBuffer_t NpX;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(115859);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(115859);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.LsZ);
            aVar.bb(3, this.Lta);
            aVar.aM(4, this.NpR);
            if (this.NpS != null) {
                aVar.ni(5, this.NpS.computeSize());
                this.NpS.writeFields(aVar);
            }
            aVar.aM(6, this.NpI);
            aVar.aM(7, this.NpT);
            aVar.aM(8, this.NpU);
            aVar.aM(9, this.NpV);
            aVar.aM(10, this.NpW);
            if (this.NpX != null) {
                aVar.ni(11, this.NpX.computeSize());
                this.NpX.writeFields(aVar);
            }
            AppMethodBeat.o(115859);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.LsZ) + g.a.a.b.b.a.r(3, this.Lta) + g.a.a.b.b.a.bu(4, this.NpR);
            if (this.NpS != null) {
                nh += g.a.a.a.nh(5, this.NpS.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(6, this.NpI) + g.a.a.b.b.a.bu(7, this.NpT) + g.a.a.b.b.a.bu(8, this.NpU) + g.a.a.b.b.a.bu(9, this.NpV) + g.a.a.b.b.a.bu(10, this.NpW);
            if (this.NpX != null) {
                bu += g.a.a.a.nh(11, this.NpX.computeSize());
            }
            AppMethodBeat.o(115859);
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
                AppMethodBeat.o(115859);
                throw bVar2;
            }
            AppMethodBeat.o(115859);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            esp esp = (esp) objArr[1];
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
                        esp.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(115859);
                    return 0;
                case 2:
                    esp.LsZ = aVar3.UbS.zi();
                    AppMethodBeat.o(115859);
                    return 0;
                case 3:
                    esp.Lta = aVar3.UbS.zl();
                    AppMethodBeat.o(115859);
                    return 0;
                case 4:
                    esp.NpR = aVar3.UbS.zi();
                    AppMethodBeat.o(115859);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        eue eue = new eue();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = eue.populateBuilderWithField(aVar5, eue, dpc.getNextFieldNumber(aVar5))) {
                        }
                        esp.NpS = eue;
                    }
                    AppMethodBeat.o(115859);
                    return 0;
                case 6:
                    esp.NpI = aVar3.UbS.zi();
                    AppMethodBeat.o(115859);
                    return 0;
                case 7:
                    esp.NpT = aVar3.UbS.zi();
                    AppMethodBeat.o(115859);
                    return 0;
                case 8:
                    esp.NpU = aVar3.UbS.zi();
                    AppMethodBeat.o(115859);
                    return 0;
                case 9:
                    esp.NpV = aVar3.UbS.zi();
                    AppMethodBeat.o(115859);
                    return 0;
                case 10:
                    esp.NpW = aVar3.UbS.zi();
                    AppMethodBeat.o(115859);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = sKBuiltinBuffer_t.populateBuilderWithField(aVar6, sKBuiltinBuffer_t, dpc.getNextFieldNumber(aVar6))) {
                        }
                        esp.NpX = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(115859);
                    return 0;
                default:
                    AppMethodBeat.o(115859);
                    return -1;
            }
        } else {
            AppMethodBeat.o(115859);
            return -1;
        }
    }
}
