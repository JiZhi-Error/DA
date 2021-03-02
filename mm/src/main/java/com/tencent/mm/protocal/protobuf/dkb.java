package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dkb extends a {
    public fbt MNW;
    public fbs MNX;
    public fbs MNY;
    public int version;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(196215);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.version);
            if (this.MNW != null) {
                aVar.ni(2, this.MNW.computeSize());
                this.MNW.writeFields(aVar);
            }
            if (this.MNX != null) {
                aVar.ni(3, this.MNX.computeSize());
                this.MNX.writeFields(aVar);
            }
            if (this.MNY != null) {
                aVar.ni(4, this.MNY.computeSize());
                this.MNY.writeFields(aVar);
            }
            AppMethodBeat.o(196215);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.version) + 0;
            if (this.MNW != null) {
                bu += g.a.a.a.nh(2, this.MNW.computeSize());
            }
            if (this.MNX != null) {
                bu += g.a.a.a.nh(3, this.MNX.computeSize());
            }
            if (this.MNY != null) {
                bu += g.a.a.a.nh(4, this.MNY.computeSize());
            }
            AppMethodBeat.o(196215);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(196215);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dkb dkb = (dkb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dkb.version = aVar3.UbS.zi();
                    AppMethodBeat.o(196215);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        fbt fbt = new fbt();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = fbt.populateBuilderWithField(aVar4, fbt, a.getNextFieldNumber(aVar4))) {
                        }
                        dkb.MNW = fbt;
                    }
                    AppMethodBeat.o(196215);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        fbs fbs = new fbs();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = fbs.populateBuilderWithField(aVar5, fbs, a.getNextFieldNumber(aVar5))) {
                        }
                        dkb.MNX = fbs;
                    }
                    AppMethodBeat.o(196215);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        fbs fbs2 = new fbs();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = fbs2.populateBuilderWithField(aVar6, fbs2, a.getNextFieldNumber(aVar6))) {
                        }
                        dkb.MNY = fbs2;
                    }
                    AppMethodBeat.o(196215);
                    return 0;
                default:
                    AppMethodBeat.o(196215);
                    return -1;
            }
        } else {
            AppMethodBeat.o(196215);
            return -1;
        }
    }
}