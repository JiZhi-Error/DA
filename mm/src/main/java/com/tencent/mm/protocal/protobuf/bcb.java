package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bcb extends dpc {
    public LinkedList<bdu> LLh = new LinkedList<>();
    public int LLi;
    public int LLj;
    public LinkedList<azl> LLk = new LinkedList<>();
    public int LLl;
    public int continueFlag;
    public String dPI;
    public int offset;
    public b tVM;
    public LinkedList<FinderObject> tbD = new LinkedList<>();
    public LinkedList<bbz> zns = new LinkedList<>();

    public bcb() {
        AppMethodBeat.i(169049);
        AppMethodBeat.o(169049);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(169050);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 8, this.zns);
            aVar.aM(3, this.offset);
            aVar.aM(4, this.continueFlag);
            aVar.e(5, 8, this.tbD);
            if (this.tVM != null) {
                aVar.c(6, this.tVM);
            }
            if (this.dPI != null) {
                aVar.e(7, this.dPI);
            }
            aVar.e(8, 8, this.LLh);
            aVar.aM(9, this.LLi);
            aVar.aM(10, this.LLj);
            aVar.e(11, 8, this.LLk);
            aVar.aM(12, this.LLl);
            AppMethodBeat.o(169050);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.zns) + g.a.a.b.b.a.bu(3, this.offset) + g.a.a.b.b.a.bu(4, this.continueFlag) + g.a.a.a.c(5, 8, this.tbD);
            if (this.tVM != null) {
                nh += g.a.a.b.b.a.b(6, this.tVM);
            }
            if (this.dPI != null) {
                nh += g.a.a.b.b.a.f(7, this.dPI);
            }
            int c2 = nh + g.a.a.a.c(8, 8, this.LLh) + g.a.a.b.b.a.bu(9, this.LLi) + g.a.a.b.b.a.bu(10, this.LLj) + g.a.a.a.c(11, 8, this.LLk) + g.a.a.b.b.a.bu(12, this.LLl);
            AppMethodBeat.o(169050);
            return c2;
        } else if (i2 == 2) {
            this.zns.clear();
            this.tbD.clear();
            this.LLh.clear();
            this.LLk.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(169050);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bcb bcb = (bcb) objArr[1];
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
                        bcb.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(169050);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        bbz bbz = new bbz();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = bbz.populateBuilderWithField(aVar5, bbz, dpc.getNextFieldNumber(aVar5))) {
                        }
                        bcb.zns.add(bbz);
                    }
                    AppMethodBeat.o(169050);
                    return 0;
                case 3:
                    bcb.offset = aVar3.UbS.zi();
                    AppMethodBeat.o(169050);
                    return 0;
                case 4:
                    bcb.continueFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(169050);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        FinderObject finderObject = new FinderObject();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = finderObject.populateBuilderWithField(aVar6, finderObject, dpc.getNextFieldNumber(aVar6))) {
                        }
                        bcb.tbD.add(finderObject);
                    }
                    AppMethodBeat.o(169050);
                    return 0;
                case 6:
                    bcb.tVM = aVar3.UbS.hPo();
                    AppMethodBeat.o(169050);
                    return 0;
                case 7:
                    bcb.dPI = aVar3.UbS.readString();
                    AppMethodBeat.o(169050);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        bdu bdu = new bdu();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = bdu.populateBuilderWithField(aVar7, bdu, dpc.getNextFieldNumber(aVar7))) {
                        }
                        bcb.LLh.add(bdu);
                    }
                    AppMethodBeat.o(169050);
                    return 0;
                case 9:
                    bcb.LLi = aVar3.UbS.zi();
                    AppMethodBeat.o(169050);
                    return 0;
                case 10:
                    bcb.LLj = aVar3.UbS.zi();
                    AppMethodBeat.o(169050);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        azl azl = new azl();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = azl.populateBuilderWithField(aVar8, azl, dpc.getNextFieldNumber(aVar8))) {
                        }
                        bcb.LLk.add(azl);
                    }
                    AppMethodBeat.o(169050);
                    return 0;
                case 12:
                    bcb.LLl = aVar3.UbS.zi();
                    AppMethodBeat.o(169050);
                    return 0;
                default:
                    AppMethodBeat.o(169050);
                    return -1;
            }
        } else {
            AppMethodBeat.o(169050);
            return -1;
        }
    }
}
