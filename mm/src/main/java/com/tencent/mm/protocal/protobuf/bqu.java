package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bqu extends dpc {
    public int LUO;
    public cyr LYp;
    public cys LYq;
    public cys LYr;
    public cyt LYs;
    public int pTZ;
    public String pUa;
    public int qGg;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(114033);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(114033);
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
            if (this.LYp != null) {
                aVar.ni(6, this.LYp.computeSize());
                this.LYp.writeFields(aVar);
            }
            if (this.LYq != null) {
                aVar.ni(7, this.LYq.computeSize());
                this.LYq.writeFields(aVar);
            }
            if (this.LYr != null) {
                aVar.ni(8, this.LYr.computeSize());
                this.LYr.writeFields(aVar);
            }
            if (this.LYs != null) {
                aVar.ni(9, this.LYs.computeSize());
                this.LYs.writeFields(aVar);
            }
            AppMethodBeat.o(114033);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.pTZ);
            if (this.pUa != null) {
                nh += g.a.a.b.b.a.f(3, this.pUa);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.qGg) + g.a.a.b.b.a.bu(5, this.LUO);
            if (this.LYp != null) {
                bu += g.a.a.a.nh(6, this.LYp.computeSize());
            }
            if (this.LYq != null) {
                bu += g.a.a.a.nh(7, this.LYq.computeSize());
            }
            if (this.LYr != null) {
                bu += g.a.a.a.nh(8, this.LYr.computeSize());
            }
            if (this.LYs != null) {
                bu += g.a.a.a.nh(9, this.LYs.computeSize());
            }
            AppMethodBeat.o(114033);
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
                AppMethodBeat.o(114033);
                throw bVar2;
            }
            AppMethodBeat.o(114033);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bqu bqu = (bqu) objArr[1];
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
                        bqu.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(114033);
                    return 0;
                case 2:
                    bqu.pTZ = aVar3.UbS.zi();
                    AppMethodBeat.o(114033);
                    return 0;
                case 3:
                    bqu.pUa = aVar3.UbS.readString();
                    AppMethodBeat.o(114033);
                    return 0;
                case 4:
                    bqu.qGg = aVar3.UbS.zi();
                    AppMethodBeat.o(114033);
                    return 0;
                case 5:
                    bqu.LUO = aVar3.UbS.zi();
                    AppMethodBeat.o(114033);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cyr cyr = new cyr();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cyr.populateBuilderWithField(aVar5, cyr, dpc.getNextFieldNumber(aVar5))) {
                        }
                        bqu.LYp = cyr;
                    }
                    AppMethodBeat.o(114033);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        cys cys = new cys();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = cys.populateBuilderWithField(aVar6, cys, dpc.getNextFieldNumber(aVar6))) {
                        }
                        bqu.LYq = cys;
                    }
                    AppMethodBeat.o(114033);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        cys cys2 = new cys();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = cys2.populateBuilderWithField(aVar7, cys2, dpc.getNextFieldNumber(aVar7))) {
                        }
                        bqu.LYr = cys2;
                    }
                    AppMethodBeat.o(114033);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        cyt cyt = new cyt();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = cyt.populateBuilderWithField(aVar8, cyt, dpc.getNextFieldNumber(aVar8))) {
                        }
                        bqu.LYs = cyt;
                    }
                    AppMethodBeat.o(114033);
                    return 0;
                default:
                    AppMethodBeat.o(114033);
                    return -1;
            }
        } else {
            AppMethodBeat.o(114033);
            return -1;
        }
    }
}
