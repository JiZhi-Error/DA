package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class au extends a {
    public co xKG;
    public co xKH;
    public co xKI;
    public dq xKJ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41741);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.xKG != null) {
                aVar.ni(1, this.xKG.computeSize());
                this.xKG.writeFields(aVar);
            }
            if (this.xKH != null) {
                aVar.ni(2, this.xKH.computeSize());
                this.xKH.writeFields(aVar);
            }
            if (this.xKI != null) {
                aVar.ni(3, this.xKI.computeSize());
                this.xKI.writeFields(aVar);
            }
            if (this.xKJ != null) {
                aVar.ni(4, this.xKJ.computeSize());
                this.xKJ.writeFields(aVar);
            }
            AppMethodBeat.o(41741);
            return 0;
        } else if (i2 == 1) {
            int nh = this.xKG != null ? g.a.a.a.nh(1, this.xKG.computeSize()) + 0 : 0;
            if (this.xKH != null) {
                nh += g.a.a.a.nh(2, this.xKH.computeSize());
            }
            if (this.xKI != null) {
                nh += g.a.a.a.nh(3, this.xKI.computeSize());
            }
            if (this.xKJ != null) {
                nh += g.a.a.a.nh(4, this.xKJ.computeSize());
            }
            AppMethodBeat.o(41741);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(41741);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            au auVar = (au) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        co coVar = new co();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = coVar.populateBuilderWithField(aVar4, coVar, a.getNextFieldNumber(aVar4))) {
                        }
                        auVar.xKG = coVar;
                    }
                    AppMethodBeat.o(41741);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        co coVar2 = new co();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = coVar2.populateBuilderWithField(aVar5, coVar2, a.getNextFieldNumber(aVar5))) {
                        }
                        auVar.xKH = coVar2;
                    }
                    AppMethodBeat.o(41741);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        co coVar3 = new co();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = coVar3.populateBuilderWithField(aVar6, coVar3, a.getNextFieldNumber(aVar6))) {
                        }
                        auVar.xKI = coVar3;
                    }
                    AppMethodBeat.o(41741);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        dq dqVar = new dq();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = dqVar.populateBuilderWithField(aVar7, dqVar, a.getNextFieldNumber(aVar7))) {
                        }
                        auVar.xKJ = dqVar;
                    }
                    AppMethodBeat.o(41741);
                    return 0;
                default:
                    AppMethodBeat.o(41741);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41741);
            return -1;
        }
    }
}
