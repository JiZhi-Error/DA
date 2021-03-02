package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class we extends a {
    public wd Lht;
    public wd Lhu;
    public wd Lhv;
    public wd Lhw;
    public wd Lhx;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(113984);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Lht != null) {
                aVar.ni(1, this.Lht.computeSize());
                this.Lht.writeFields(aVar);
            }
            if (this.Lhu != null) {
                aVar.ni(2, this.Lhu.computeSize());
                this.Lhu.writeFields(aVar);
            }
            if (this.Lhv != null) {
                aVar.ni(3, this.Lhv.computeSize());
                this.Lhv.writeFields(aVar);
            }
            if (this.Lhw != null) {
                aVar.ni(4, this.Lhw.computeSize());
                this.Lhw.writeFields(aVar);
            }
            if (this.Lhx != null) {
                aVar.ni(5, this.Lhx.computeSize());
                this.Lhx.writeFields(aVar);
            }
            AppMethodBeat.o(113984);
            return 0;
        } else if (i2 == 1) {
            int nh = this.Lht != null ? g.a.a.a.nh(1, this.Lht.computeSize()) + 0 : 0;
            if (this.Lhu != null) {
                nh += g.a.a.a.nh(2, this.Lhu.computeSize());
            }
            if (this.Lhv != null) {
                nh += g.a.a.a.nh(3, this.Lhv.computeSize());
            }
            if (this.Lhw != null) {
                nh += g.a.a.a.nh(4, this.Lhw.computeSize());
            }
            if (this.Lhx != null) {
                nh += g.a.a.a.nh(5, this.Lhx.computeSize());
            }
            AppMethodBeat.o(113984);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(113984);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            we weVar = (we) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        wd wdVar = new wd();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = wdVar.populateBuilderWithField(aVar4, wdVar, a.getNextFieldNumber(aVar4))) {
                        }
                        weVar.Lht = wdVar;
                    }
                    AppMethodBeat.o(113984);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        wd wdVar2 = new wd();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = wdVar2.populateBuilderWithField(aVar5, wdVar2, a.getNextFieldNumber(aVar5))) {
                        }
                        weVar.Lhu = wdVar2;
                    }
                    AppMethodBeat.o(113984);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        wd wdVar3 = new wd();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = wdVar3.populateBuilderWithField(aVar6, wdVar3, a.getNextFieldNumber(aVar6))) {
                        }
                        weVar.Lhv = wdVar3;
                    }
                    AppMethodBeat.o(113984);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        wd wdVar4 = new wd();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = wdVar4.populateBuilderWithField(aVar7, wdVar4, a.getNextFieldNumber(aVar7))) {
                        }
                        weVar.Lhw = wdVar4;
                    }
                    AppMethodBeat.o(113984);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        wd wdVar5 = new wd();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = wdVar5.populateBuilderWithField(aVar8, wdVar5, a.getNextFieldNumber(aVar8))) {
                        }
                        weVar.Lhx = wdVar5;
                    }
                    AppMethodBeat.o(113984);
                    return 0;
                default:
                    AppMethodBeat.o(113984);
                    return -1;
            }
        } else {
            AppMethodBeat.o(113984);
            return -1;
        }
    }
}
