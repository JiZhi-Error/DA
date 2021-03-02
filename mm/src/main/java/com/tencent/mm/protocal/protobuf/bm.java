package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class bm extends a {
    public bn KFc;
    public bn KFd;
    public bn KFe;
    public bn KFf;
    public bn KFg;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(122481);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KFc != null) {
                aVar.ni(1, this.KFc.computeSize());
                this.KFc.writeFields(aVar);
            }
            if (this.KFd != null) {
                aVar.ni(2, this.KFd.computeSize());
                this.KFd.writeFields(aVar);
            }
            if (this.KFe != null) {
                aVar.ni(3, this.KFe.computeSize());
                this.KFe.writeFields(aVar);
            }
            if (this.KFf != null) {
                aVar.ni(4, this.KFf.computeSize());
                this.KFf.writeFields(aVar);
            }
            if (this.KFg != null) {
                aVar.ni(5, this.KFg.computeSize());
                this.KFg.writeFields(aVar);
            }
            AppMethodBeat.o(122481);
            return 0;
        } else if (i2 == 1) {
            int nh = this.KFc != null ? g.a.a.a.nh(1, this.KFc.computeSize()) + 0 : 0;
            if (this.KFd != null) {
                nh += g.a.a.a.nh(2, this.KFd.computeSize());
            }
            if (this.KFe != null) {
                nh += g.a.a.a.nh(3, this.KFe.computeSize());
            }
            if (this.KFf != null) {
                nh += g.a.a.a.nh(4, this.KFf.computeSize());
            }
            if (this.KFg != null) {
                nh += g.a.a.a.nh(5, this.KFg.computeSize());
            }
            AppMethodBeat.o(122481);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(122481);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bm bmVar = (bm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        bn bnVar = new bn();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = bnVar.populateBuilderWithField(aVar4, bnVar, a.getNextFieldNumber(aVar4))) {
                        }
                        bmVar.KFc = bnVar;
                    }
                    AppMethodBeat.o(122481);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        bn bnVar2 = new bn();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = bnVar2.populateBuilderWithField(aVar5, bnVar2, a.getNextFieldNumber(aVar5))) {
                        }
                        bmVar.KFd = bnVar2;
                    }
                    AppMethodBeat.o(122481);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        bn bnVar3 = new bn();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = bnVar3.populateBuilderWithField(aVar6, bnVar3, a.getNextFieldNumber(aVar6))) {
                        }
                        bmVar.KFe = bnVar3;
                    }
                    AppMethodBeat.o(122481);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        bn bnVar4 = new bn();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = bnVar4.populateBuilderWithField(aVar7, bnVar4, a.getNextFieldNumber(aVar7))) {
                        }
                        bmVar.KFf = bnVar4;
                    }
                    AppMethodBeat.o(122481);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        bn bnVar5 = new bn();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = bnVar5.populateBuilderWithField(aVar8, bnVar5, a.getNextFieldNumber(aVar8))) {
                        }
                        bmVar.KFg = bnVar5;
                    }
                    AppMethodBeat.o(122481);
                    return 0;
                default:
                    AppMethodBeat.o(122481);
                    return -1;
            }
        } else {
            AppMethodBeat.o(122481);
            return -1;
        }
    }
}
