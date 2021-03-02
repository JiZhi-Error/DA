package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bwo extends dpc {
    public int Mcl;
    public String Mcm;
    public int Mcn;
    public String Mco;
    public int Mcp;
    public LinkedList<dqi> Mcq = new LinkedList<>();
    public String Mcr;
    public int Mcs;
    public String Mct;
    public int Mcu;
    public SKBuiltinBuffer_t Mcv;

    public bwo() {
        AppMethodBeat.i(152605);
        AppMethodBeat.o(152605);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152606);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(152606);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.Mcl);
            if (this.Mcm != null) {
                aVar.e(3, this.Mcm);
            }
            aVar.aM(4, this.Mcn);
            if (this.Mco != null) {
                aVar.e(5, this.Mco);
            }
            aVar.aM(6, this.Mcp);
            aVar.e(7, 8, this.Mcq);
            if (this.Mcr != null) {
                aVar.e(8, this.Mcr);
            }
            aVar.aM(9, this.Mcs);
            if (this.Mct != null) {
                aVar.e(10, this.Mct);
            }
            aVar.aM(11, this.Mcu);
            if (this.Mcv != null) {
                aVar.ni(12, this.Mcv.computeSize());
                this.Mcv.writeFields(aVar);
            }
            AppMethodBeat.o(152606);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.Mcl);
            if (this.Mcm != null) {
                nh += g.a.a.b.b.a.f(3, this.Mcm);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.Mcn);
            if (this.Mco != null) {
                bu += g.a.a.b.b.a.f(5, this.Mco);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(6, this.Mcp) + g.a.a.a.c(7, 8, this.Mcq);
            if (this.Mcr != null) {
                bu2 += g.a.a.b.b.a.f(8, this.Mcr);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(9, this.Mcs);
            if (this.Mct != null) {
                bu3 += g.a.a.b.b.a.f(10, this.Mct);
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(11, this.Mcu);
            if (this.Mcv != null) {
                bu4 += g.a.a.a.nh(12, this.Mcv.computeSize());
            }
            AppMethodBeat.o(152606);
            return bu4;
        } else if (i2 == 2) {
            this.Mcq.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(152606);
                throw bVar2;
            }
            AppMethodBeat.o(152606);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bwo bwo = (bwo) objArr[1];
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
                        bwo.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(152606);
                    return 0;
                case 2:
                    bwo.Mcl = aVar3.UbS.zi();
                    AppMethodBeat.o(152606);
                    return 0;
                case 3:
                    bwo.Mcm = aVar3.UbS.readString();
                    AppMethodBeat.o(152606);
                    return 0;
                case 4:
                    bwo.Mcn = aVar3.UbS.zi();
                    AppMethodBeat.o(152606);
                    return 0;
                case 5:
                    bwo.Mco = aVar3.UbS.readString();
                    AppMethodBeat.o(152606);
                    return 0;
                case 6:
                    bwo.Mcp = aVar3.UbS.zi();
                    AppMethodBeat.o(152606);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dqi.populateBuilderWithField(aVar5, dqi, dpc.getNextFieldNumber(aVar5))) {
                        }
                        bwo.Mcq.add(dqi);
                    }
                    AppMethodBeat.o(152606);
                    return 0;
                case 8:
                    bwo.Mcr = aVar3.UbS.readString();
                    AppMethodBeat.o(152606);
                    return 0;
                case 9:
                    bwo.Mcs = aVar3.UbS.zi();
                    AppMethodBeat.o(152606);
                    return 0;
                case 10:
                    bwo.Mct = aVar3.UbS.readString();
                    AppMethodBeat.o(152606);
                    return 0;
                case 11:
                    bwo.Mcu = aVar3.UbS.zi();
                    AppMethodBeat.o(152606);
                    return 0;
                case 12:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = sKBuiltinBuffer_t.populateBuilderWithField(aVar6, sKBuiltinBuffer_t, dpc.getNextFieldNumber(aVar6))) {
                        }
                        bwo.Mcv = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(152606);
                    return 0;
                default:
                    AppMethodBeat.o(152606);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152606);
            return -1;
        }
    }
}
