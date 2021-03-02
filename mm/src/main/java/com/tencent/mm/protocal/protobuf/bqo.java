package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bqo extends dpc {
    public int LUO;
    public uh LUP;
    public int LUS;
    public int LUT;
    public uw LUU;
    public ul LYg;
    public ue LYh;
    public String LYi;
    public uk LYj;
    public int pTZ;
    public String pUa;
    public int qGg;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(114029);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(114029);
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
            if (this.LYg != null) {
                aVar.ni(7, this.LYg.computeSize());
                this.LYg.writeFields(aVar);
            }
            if (this.LYh != null) {
                aVar.ni(8, this.LYh.computeSize());
                this.LYh.writeFields(aVar);
            }
            if (this.LYi != null) {
                aVar.e(10, this.LYi);
            }
            aVar.aM(11, this.LUS);
            aVar.aM(12, this.LUT);
            if (this.LUU != null) {
                aVar.ni(13, this.LUU.computeSize());
                this.LUU.writeFields(aVar);
            }
            if (this.LYj != null) {
                aVar.ni(14, this.LYj.computeSize());
                this.LYj.writeFields(aVar);
            }
            AppMethodBeat.o(114029);
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
            if (this.LYg != null) {
                bu += g.a.a.a.nh(7, this.LYg.computeSize());
            }
            if (this.LYh != null) {
                bu += g.a.a.a.nh(8, this.LYh.computeSize());
            }
            if (this.LYi != null) {
                bu += g.a.a.b.b.a.f(10, this.LYi);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(11, this.LUS) + g.a.a.b.b.a.bu(12, this.LUT);
            if (this.LUU != null) {
                bu2 += g.a.a.a.nh(13, this.LUU.computeSize());
            }
            if (this.LYj != null) {
                bu2 += g.a.a.a.nh(14, this.LYj.computeSize());
            }
            AppMethodBeat.o(114029);
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
                AppMethodBeat.o(114029);
                throw bVar2;
            }
            AppMethodBeat.o(114029);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bqo bqo = (bqo) objArr[1];
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
                        bqo.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(114029);
                    return 0;
                case 2:
                    bqo.pTZ = aVar3.UbS.zi();
                    AppMethodBeat.o(114029);
                    return 0;
                case 3:
                    bqo.pUa = aVar3.UbS.readString();
                    AppMethodBeat.o(114029);
                    return 0;
                case 4:
                    bqo.qGg = aVar3.UbS.zi();
                    AppMethodBeat.o(114029);
                    return 0;
                case 5:
                    bqo.LUO = aVar3.UbS.zi();
                    AppMethodBeat.o(114029);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        uh uhVar = new uh();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = uhVar.populateBuilderWithField(aVar5, uhVar, dpc.getNextFieldNumber(aVar5))) {
                        }
                        bqo.LUP = uhVar;
                    }
                    AppMethodBeat.o(114029);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        ul ulVar = new ul();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = ulVar.populateBuilderWithField(aVar6, ulVar, dpc.getNextFieldNumber(aVar6))) {
                        }
                        bqo.LYg = ulVar;
                    }
                    AppMethodBeat.o(114029);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        ue ueVar = new ue();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = ueVar.populateBuilderWithField(aVar7, ueVar, dpc.getNextFieldNumber(aVar7))) {
                        }
                        bqo.LYh = ueVar;
                    }
                    AppMethodBeat.o(114029);
                    return 0;
                case 9:
                default:
                    AppMethodBeat.o(114029);
                    return -1;
                case 10:
                    bqo.LYi = aVar3.UbS.readString();
                    AppMethodBeat.o(114029);
                    return 0;
                case 11:
                    bqo.LUS = aVar3.UbS.zi();
                    AppMethodBeat.o(114029);
                    return 0;
                case 12:
                    bqo.LUT = aVar3.UbS.zi();
                    AppMethodBeat.o(114029);
                    return 0;
                case 13:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        uw uwVar = new uw();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = uwVar.populateBuilderWithField(aVar8, uwVar, dpc.getNextFieldNumber(aVar8))) {
                        }
                        bqo.LUU = uwVar;
                    }
                    AppMethodBeat.o(114029);
                    return 0;
                case 14:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        uk ukVar = new uk();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = ukVar.populateBuilderWithField(aVar9, ukVar, dpc.getNextFieldNumber(aVar9))) {
                        }
                        bqo.LYj = ukVar;
                    }
                    AppMethodBeat.o(114029);
                    return 0;
            }
        } else {
            AppMethodBeat.o(114029);
            return -1;
        }
    }
}
