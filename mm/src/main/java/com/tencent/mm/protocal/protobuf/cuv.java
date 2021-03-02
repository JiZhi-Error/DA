package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class cuv extends dpc {
    public String HtE;
    public String HtF;
    public String HtG;
    public int HtH;
    public String HtI;
    public String HuS;
    public cki MAb;
    public String MAc;
    public amh MAd;
    public String MAe;
    public ckj efB;
    public int pTZ;
    public String pUa;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91559);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(91559);
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
            if (this.MAb != null) {
                aVar.ni(4, this.MAb.computeSize());
                this.MAb.writeFields(aVar);
            }
            if (this.HtE != null) {
                aVar.e(5, this.HtE);
            }
            if (this.HtF != null) {
                aVar.e(6, this.HtF);
            }
            if (this.HtG != null) {
                aVar.e(7, this.HtG);
            }
            aVar.aM(8, this.HtH);
            if (this.HtI != null) {
                aVar.e(9, this.HtI);
            }
            if (this.MAc != null) {
                aVar.e(10, this.MAc);
            }
            if (this.MAd != null) {
                aVar.ni(11, this.MAd.computeSize());
                this.MAd.writeFields(aVar);
            }
            if (this.MAe != null) {
                aVar.e(12, this.MAe);
            }
            if (this.efB != null) {
                aVar.ni(99, this.efB.computeSize());
                this.efB.writeFields(aVar);
            }
            if (this.HuS != null) {
                aVar.e(100, this.HuS);
            }
            AppMethodBeat.o(91559);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.pTZ);
            if (this.pUa != null) {
                nh += g.a.a.b.b.a.f(3, this.pUa);
            }
            if (this.MAb != null) {
                nh += g.a.a.a.nh(4, this.MAb.computeSize());
            }
            if (this.HtE != null) {
                nh += g.a.a.b.b.a.f(5, this.HtE);
            }
            if (this.HtF != null) {
                nh += g.a.a.b.b.a.f(6, this.HtF);
            }
            if (this.HtG != null) {
                nh += g.a.a.b.b.a.f(7, this.HtG);
            }
            int bu = nh + g.a.a.b.b.a.bu(8, this.HtH);
            if (this.HtI != null) {
                bu += g.a.a.b.b.a.f(9, this.HtI);
            }
            if (this.MAc != null) {
                bu += g.a.a.b.b.a.f(10, this.MAc);
            }
            if (this.MAd != null) {
                bu += g.a.a.a.nh(11, this.MAd.computeSize());
            }
            if (this.MAe != null) {
                bu += g.a.a.b.b.a.f(12, this.MAe);
            }
            if (this.efB != null) {
                bu += g.a.a.a.nh(99, this.efB.computeSize());
            }
            if (this.HuS != null) {
                bu += g.a.a.b.b.a.f(100, this.HuS);
            }
            AppMethodBeat.o(91559);
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
                AppMethodBeat.o(91559);
                throw bVar2;
            }
            AppMethodBeat.o(91559);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cuv cuv = (cuv) objArr[1];
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
                        cuv.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(91559);
                    return 0;
                case 2:
                    cuv.pTZ = aVar3.UbS.zi();
                    AppMethodBeat.o(91559);
                    return 0;
                case 3:
                    cuv.pUa = aVar3.UbS.readString();
                    AppMethodBeat.o(91559);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cki cki = new cki();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cki.populateBuilderWithField(aVar5, cki, dpc.getNextFieldNumber(aVar5))) {
                        }
                        cuv.MAb = cki;
                    }
                    AppMethodBeat.o(91559);
                    return 0;
                case 5:
                    cuv.HtE = aVar3.UbS.readString();
                    AppMethodBeat.o(91559);
                    return 0;
                case 6:
                    cuv.HtF = aVar3.UbS.readString();
                    AppMethodBeat.o(91559);
                    return 0;
                case 7:
                    cuv.HtG = aVar3.UbS.readString();
                    AppMethodBeat.o(91559);
                    return 0;
                case 8:
                    cuv.HtH = aVar3.UbS.zi();
                    AppMethodBeat.o(91559);
                    return 0;
                case 9:
                    cuv.HtI = aVar3.UbS.readString();
                    AppMethodBeat.o(91559);
                    return 0;
                case 10:
                    cuv.MAc = aVar3.UbS.readString();
                    AppMethodBeat.o(91559);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        amh amh = new amh();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = amh.populateBuilderWithField(aVar6, amh, dpc.getNextFieldNumber(aVar6))) {
                        }
                        cuv.MAd = amh;
                    }
                    AppMethodBeat.o(91559);
                    return 0;
                case 12:
                    cuv.MAe = aVar3.UbS.readString();
                    AppMethodBeat.o(91559);
                    return 0;
                case 99:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        ckj ckj = new ckj();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = ckj.populateBuilderWithField(aVar7, ckj, dpc.getNextFieldNumber(aVar7))) {
                        }
                        cuv.efB = ckj;
                    }
                    AppMethodBeat.o(91559);
                    return 0;
                case 100:
                    cuv.HuS = aVar3.UbS.readString();
                    AppMethodBeat.o(91559);
                    return 0;
                default:
                    AppMethodBeat.o(91559);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91559);
            return -1;
        }
    }
}
