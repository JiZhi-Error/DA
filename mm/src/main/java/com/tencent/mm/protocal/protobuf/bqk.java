package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bqk extends dpc {
    public LinkedList<ue> LUK = new LinkedList<>();
    public int LUO;
    public un LUQ;
    public String LUR;
    public int LUS;
    public int LUT;
    public uw LUU;
    public un LYc;
    public String LYd;
    public String LYe;
    public LinkedList<ua> Lds = new LinkedList<>();
    public int pTZ;
    public String pUa;
    public int qGg;

    public bqk() {
        AppMethodBeat.i(201343);
        AppMethodBeat.o(201343);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(201344);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(201344);
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
            aVar.e(6, 8, this.Lds);
            if (this.LUU != null) {
                aVar.ni(7, this.LUU.computeSize());
                this.LUU.writeFields(aVar);
            }
            aVar.aM(8, this.LUS);
            aVar.aM(9, this.LUT);
            if (this.LUQ != null) {
                aVar.ni(10, this.LUQ.computeSize());
                this.LUQ.writeFields(aVar);
            }
            if (this.LUR != null) {
                aVar.e(11, this.LUR);
            }
            if (this.LYc != null) {
                aVar.ni(12, this.LYc.computeSize());
                this.LYc.writeFields(aVar);
            }
            if (this.LYd != null) {
                aVar.e(13, this.LYd);
            }
            if (this.LYe != null) {
                aVar.e(14, this.LYe);
            }
            aVar.e(15, 8, this.LUK);
            AppMethodBeat.o(201344);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.pTZ);
            if (this.pUa != null) {
                nh += g.a.a.b.b.a.f(3, this.pUa);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.qGg) + g.a.a.b.b.a.bu(5, this.LUO) + g.a.a.a.c(6, 8, this.Lds);
            if (this.LUU != null) {
                bu += g.a.a.a.nh(7, this.LUU.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(8, this.LUS) + g.a.a.b.b.a.bu(9, this.LUT);
            if (this.LUQ != null) {
                bu2 += g.a.a.a.nh(10, this.LUQ.computeSize());
            }
            if (this.LUR != null) {
                bu2 += g.a.a.b.b.a.f(11, this.LUR);
            }
            if (this.LYc != null) {
                bu2 += g.a.a.a.nh(12, this.LYc.computeSize());
            }
            if (this.LYd != null) {
                bu2 += g.a.a.b.b.a.f(13, this.LYd);
            }
            if (this.LYe != null) {
                bu2 += g.a.a.b.b.a.f(14, this.LYe);
            }
            int c2 = bu2 + g.a.a.a.c(15, 8, this.LUK);
            AppMethodBeat.o(201344);
            return c2;
        } else if (i2 == 2) {
            this.Lds.clear();
            this.LUK.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(201344);
                throw bVar2;
            }
            AppMethodBeat.o(201344);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bqk bqk = (bqk) objArr[1];
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
                        bqk.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(201344);
                    return 0;
                case 2:
                    bqk.pTZ = aVar3.UbS.zi();
                    AppMethodBeat.o(201344);
                    return 0;
                case 3:
                    bqk.pUa = aVar3.UbS.readString();
                    AppMethodBeat.o(201344);
                    return 0;
                case 4:
                    bqk.qGg = aVar3.UbS.zi();
                    AppMethodBeat.o(201344);
                    return 0;
                case 5:
                    bqk.LUO = aVar3.UbS.zi();
                    AppMethodBeat.o(201344);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ua uaVar = new ua();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = uaVar.populateBuilderWithField(aVar5, uaVar, dpc.getNextFieldNumber(aVar5))) {
                        }
                        bqk.Lds.add(uaVar);
                    }
                    AppMethodBeat.o(201344);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        uw uwVar = new uw();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = uwVar.populateBuilderWithField(aVar6, uwVar, dpc.getNextFieldNumber(aVar6))) {
                        }
                        bqk.LUU = uwVar;
                    }
                    AppMethodBeat.o(201344);
                    return 0;
                case 8:
                    bqk.LUS = aVar3.UbS.zi();
                    AppMethodBeat.o(201344);
                    return 0;
                case 9:
                    bqk.LUT = aVar3.UbS.zi();
                    AppMethodBeat.o(201344);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        un unVar = new un();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = unVar.populateBuilderWithField(aVar7, unVar, dpc.getNextFieldNumber(aVar7))) {
                        }
                        bqk.LUQ = unVar;
                    }
                    AppMethodBeat.o(201344);
                    return 0;
                case 11:
                    bqk.LUR = aVar3.UbS.readString();
                    AppMethodBeat.o(201344);
                    return 0;
                case 12:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        un unVar2 = new un();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = unVar2.populateBuilderWithField(aVar8, unVar2, dpc.getNextFieldNumber(aVar8))) {
                        }
                        bqk.LYc = unVar2;
                    }
                    AppMethodBeat.o(201344);
                    return 0;
                case 13:
                    bqk.LYd = aVar3.UbS.readString();
                    AppMethodBeat.o(201344);
                    return 0;
                case 14:
                    bqk.LYe = aVar3.UbS.readString();
                    AppMethodBeat.o(201344);
                    return 0;
                case 15:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        ue ueVar = new ue();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = ueVar.populateBuilderWithField(aVar9, ueVar, dpc.getNextFieldNumber(aVar9))) {
                        }
                        bqk.LUK.add(ueVar);
                    }
                    AppMethodBeat.o(201344);
                    return 0;
                default:
                    AppMethodBeat.o(201344);
                    return -1;
            }
        } else {
            AppMethodBeat.o(201344);
            return -1;
        }
    }
}
