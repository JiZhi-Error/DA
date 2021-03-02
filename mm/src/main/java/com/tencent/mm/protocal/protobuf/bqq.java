package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bqq extends dpc {
    public int LUO;
    public ue LYh;
    public uj LYk;
    public ug LYl;
    public String LYm;
    public int pTZ;
    public String pUa;
    public int qGg;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(201346);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(201346);
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
            if (this.LYk != null) {
                aVar.ni(4, this.LYk.computeSize());
                this.LYk.writeFields(aVar);
            }
            aVar.aM(5, this.qGg);
            aVar.aM(6, this.LUO);
            if (this.LYl != null) {
                aVar.ni(7, this.LYl.computeSize());
                this.LYl.writeFields(aVar);
            }
            if (this.LYh != null) {
                aVar.ni(8, this.LYh.computeSize());
                this.LYh.writeFields(aVar);
            }
            if (this.LYm != null) {
                aVar.e(9, this.LYm);
            }
            AppMethodBeat.o(201346);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.pTZ);
            if (this.pUa != null) {
                nh += g.a.a.b.b.a.f(3, this.pUa);
            }
            if (this.LYk != null) {
                nh += g.a.a.a.nh(4, this.LYk.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.qGg) + g.a.a.b.b.a.bu(6, this.LUO);
            if (this.LYl != null) {
                bu += g.a.a.a.nh(7, this.LYl.computeSize());
            }
            if (this.LYh != null) {
                bu += g.a.a.a.nh(8, this.LYh.computeSize());
            }
            if (this.LYm != null) {
                bu += g.a.a.b.b.a.f(9, this.LYm);
            }
            AppMethodBeat.o(201346);
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
                AppMethodBeat.o(201346);
                throw bVar2;
            }
            AppMethodBeat.o(201346);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bqq bqq = (bqq) objArr[1];
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
                        bqq.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(201346);
                    return 0;
                case 2:
                    bqq.pTZ = aVar3.UbS.zi();
                    AppMethodBeat.o(201346);
                    return 0;
                case 3:
                    bqq.pUa = aVar3.UbS.readString();
                    AppMethodBeat.o(201346);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        uj ujVar = new uj();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ujVar.populateBuilderWithField(aVar5, ujVar, dpc.getNextFieldNumber(aVar5))) {
                        }
                        bqq.LYk = ujVar;
                    }
                    AppMethodBeat.o(201346);
                    return 0;
                case 5:
                    bqq.qGg = aVar3.UbS.zi();
                    AppMethodBeat.o(201346);
                    return 0;
                case 6:
                    bqq.LUO = aVar3.UbS.zi();
                    AppMethodBeat.o(201346);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        ug ugVar = new ug();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = ugVar.populateBuilderWithField(aVar6, ugVar, dpc.getNextFieldNumber(aVar6))) {
                        }
                        bqq.LYl = ugVar;
                    }
                    AppMethodBeat.o(201346);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        ue ueVar = new ue();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = ueVar.populateBuilderWithField(aVar7, ueVar, dpc.getNextFieldNumber(aVar7))) {
                        }
                        bqq.LYh = ueVar;
                    }
                    AppMethodBeat.o(201346);
                    return 0;
                case 9:
                    bqq.LYm = aVar3.UbS.readString();
                    AppMethodBeat.o(201346);
                    return 0;
                default:
                    AppMethodBeat.o(201346);
                    return -1;
            }
        } else {
            AppMethodBeat.o(201346);
            return -1;
        }
    }
}
