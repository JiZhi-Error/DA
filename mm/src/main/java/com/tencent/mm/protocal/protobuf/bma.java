package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bma extends dpc {
    public int LUO;
    public uh LUP;
    public un LUQ;
    public String LUR;
    public int LUS;
    public int LUT;
    public uw LUU;
    public int pTZ;
    public String pUa;
    public int qGg;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(201338);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(201338);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.pTZ);
            if (this.pUa != null) {
                aVar.e(3, this.pUa);
            }
            aVar.aM(4, this.qGg);
            aVar.aM(5, this.LUO);
            if (this.LUP != null) {
                aVar.ni(6, this.LUP.computeSize());
                this.LUP.writeFields(aVar);
            }
            if (this.LUQ != null) {
                aVar.ni(7, this.LUQ.computeSize());
                this.LUQ.writeFields(aVar);
            }
            if (this.LUR != null) {
                aVar.e(8, this.LUR);
            }
            aVar.aM(9, this.LUS);
            aVar.aM(10, this.LUT);
            if (this.LUU != null) {
                aVar.ni(11, this.LUU.computeSize());
                this.LUU.writeFields(aVar);
            }
            AppMethodBeat.o(201338);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.pTZ);
            if (this.pUa != null) {
                nh += g.a.a.b.b.a.f(3, this.pUa);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.qGg) + g.a.a.b.b.a.bu(5, this.LUO);
            if (this.LUP != null) {
                bu += g.a.a.a.nh(6, this.LUP.computeSize());
            }
            if (this.LUQ != null) {
                bu += g.a.a.a.nh(7, this.LUQ.computeSize());
            }
            if (this.LUR != null) {
                bu += g.a.a.b.b.a.f(8, this.LUR);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(9, this.LUS) + g.a.a.b.b.a.bu(10, this.LUT);
            if (this.LUU != null) {
                bu2 += g.a.a.a.nh(11, this.LUU.computeSize());
            }
            AppMethodBeat.o(201338);
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
                AppMethodBeat.o(201338);
                throw bVar2;
            }
            AppMethodBeat.o(201338);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bma bma = (bma) objArr[1];
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
                        bma.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(201338);
                    return 0;
                case 2:
                    bma.pTZ = aVar3.UbS.zi();
                    AppMethodBeat.o(201338);
                    return 0;
                case 3:
                    bma.pUa = aVar3.UbS.readString();
                    AppMethodBeat.o(201338);
                    return 0;
                case 4:
                    bma.qGg = aVar3.UbS.zi();
                    AppMethodBeat.o(201338);
                    return 0;
                case 5:
                    bma.LUO = aVar3.UbS.zi();
                    AppMethodBeat.o(201338);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        uh uhVar = new uh();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = uhVar.populateBuilderWithField(aVar5, uhVar, dpc.getNextFieldNumber(aVar5))) {
                        }
                        bma.LUP = uhVar;
                    }
                    AppMethodBeat.o(201338);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        un unVar = new un();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = unVar.populateBuilderWithField(aVar6, unVar, dpc.getNextFieldNumber(aVar6))) {
                        }
                        bma.LUQ = unVar;
                    }
                    AppMethodBeat.o(201338);
                    return 0;
                case 8:
                    bma.LUR = aVar3.UbS.readString();
                    AppMethodBeat.o(201338);
                    return 0;
                case 9:
                    bma.LUS = aVar3.UbS.zi();
                    AppMethodBeat.o(201338);
                    return 0;
                case 10:
                    bma.LUT = aVar3.UbS.zi();
                    AppMethodBeat.o(201338);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        uw uwVar = new uw();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = uwVar.populateBuilderWithField(aVar7, uwVar, dpc.getNextFieldNumber(aVar7))) {
                        }
                        bma.LUU = uwVar;
                    }
                    AppMethodBeat.o(201338);
                    return 0;
                default:
                    AppMethodBeat.o(201338);
                    return -1;
            }
        } else {
            AppMethodBeat.o(201338);
            return -1;
        }
    }
}
