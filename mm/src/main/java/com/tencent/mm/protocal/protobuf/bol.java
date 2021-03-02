package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bol extends dpc {
    public cma LUX;
    public sx LWE;
    public caj LWF;
    public cbx LWG;
    public cal LjA;
    public int pTZ;
    public String pUa;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72489);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(72489);
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
            if (this.LjA != null) {
                aVar.ni(4, this.LjA.computeSize());
                this.LjA.writeFields(aVar);
            }
            if (this.LWE != null) {
                aVar.ni(8, this.LWE.computeSize());
                this.LWE.writeFields(aVar);
            }
            if (this.LUX != null) {
                aVar.ni(9, this.LUX.computeSize());
                this.LUX.writeFields(aVar);
            }
            if (this.LWF != null) {
                aVar.ni(10, this.LWF.computeSize());
                this.LWF.writeFields(aVar);
            }
            if (this.LWG != null) {
                aVar.ni(11, this.LWG.computeSize());
                this.LWG.writeFields(aVar);
            }
            AppMethodBeat.o(72489);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.pTZ);
            if (this.pUa != null) {
                nh += g.a.a.b.b.a.f(3, this.pUa);
            }
            if (this.LjA != null) {
                nh += g.a.a.a.nh(4, this.LjA.computeSize());
            }
            if (this.LWE != null) {
                nh += g.a.a.a.nh(8, this.LWE.computeSize());
            }
            if (this.LUX != null) {
                nh += g.a.a.a.nh(9, this.LUX.computeSize());
            }
            if (this.LWF != null) {
                nh += g.a.a.a.nh(10, this.LWF.computeSize());
            }
            if (this.LWG != null) {
                nh += g.a.a.a.nh(11, this.LWG.computeSize());
            }
            AppMethodBeat.o(72489);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(72489);
                throw bVar2;
            }
            AppMethodBeat.o(72489);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bol bol = (bol) objArr[1];
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
                        bol.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(72489);
                    return 0;
                case 2:
                    bol.pTZ = aVar3.UbS.zi();
                    AppMethodBeat.o(72489);
                    return 0;
                case 3:
                    bol.pUa = aVar3.UbS.readString();
                    AppMethodBeat.o(72489);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cal cal = new cal();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cal.populateBuilderWithField(aVar5, cal, dpc.getNextFieldNumber(aVar5))) {
                        }
                        bol.LjA = cal;
                    }
                    AppMethodBeat.o(72489);
                    return 0;
                case 5:
                case 6:
                case 7:
                default:
                    AppMethodBeat.o(72489);
                    return -1;
                case 8:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        sx sxVar = new sx();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = sxVar.populateBuilderWithField(aVar6, sxVar, dpc.getNextFieldNumber(aVar6))) {
                        }
                        bol.LWE = sxVar;
                    }
                    AppMethodBeat.o(72489);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        cma cma = new cma();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = cma.populateBuilderWithField(aVar7, cma, dpc.getNextFieldNumber(aVar7))) {
                        }
                        bol.LUX = cma;
                    }
                    AppMethodBeat.o(72489);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        caj caj = new caj();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = caj.populateBuilderWithField(aVar8, caj, dpc.getNextFieldNumber(aVar8))) {
                        }
                        bol.LWF = caj;
                    }
                    AppMethodBeat.o(72489);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        cbx cbx = new cbx();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = cbx.populateBuilderWithField(aVar9, cbx, dpc.getNextFieldNumber(aVar9))) {
                        }
                        bol.LWG = cbx;
                    }
                    AppMethodBeat.o(72489);
                    return 0;
            }
        } else {
            AppMethodBeat.o(72489);
            return -1;
        }
    }
}
