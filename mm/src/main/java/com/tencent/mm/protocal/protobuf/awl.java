package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class awl extends a {
    public LinkedList<avj> LHg = new LinkedList<>();
    public cjd LHh;
    public int LHi;
    public String LHj;

    public awl() {
        AppMethodBeat.i(209534);
        AppMethodBeat.o(209534);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209535);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.LHg);
            if (this.LHh != null) {
                aVar.ni(2, this.LHh.computeSize());
                this.LHh.writeFields(aVar);
            }
            aVar.aM(3, this.LHi);
            if (this.LHj != null) {
                aVar.e(4, this.LHj);
            }
            AppMethodBeat.o(209535);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.LHg) + 0;
            if (this.LHh != null) {
                c2 += g.a.a.a.nh(2, this.LHh.computeSize());
            }
            int bu = c2 + g.a.a.b.b.a.bu(3, this.LHi);
            if (this.LHj != null) {
                bu += g.a.a.b.b.a.f(4, this.LHj);
            }
            AppMethodBeat.o(209535);
            return bu;
        } else if (i2 == 2) {
            this.LHg.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209535);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            awl awl = (awl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        avj avj = new avj();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = avj.populateBuilderWithField(aVar4, avj, a.getNextFieldNumber(aVar4))) {
                        }
                        awl.LHg.add(avj);
                    }
                    AppMethodBeat.o(209535);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cjd cjd = new cjd();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cjd.populateBuilderWithField(aVar5, cjd, a.getNextFieldNumber(aVar5))) {
                        }
                        awl.LHh = cjd;
                    }
                    AppMethodBeat.o(209535);
                    return 0;
                case 3:
                    awl.LHi = aVar3.UbS.zi();
                    AppMethodBeat.o(209535);
                    return 0;
                case 4:
                    awl.LHj = aVar3.UbS.readString();
                    AppMethodBeat.o(209535);
                    return 0;
                default:
                    AppMethodBeat.o(209535);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209535);
            return -1;
        }
    }
}
