package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class deq extends a {
    public String KNW;
    public boolean MJJ;
    public dyr MJK;
    public dyr MJL;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91632);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.cc(1, this.MJJ);
            if (this.MJK != null) {
                aVar.ni(2, this.MJK.computeSize());
                this.MJK.writeFields(aVar);
            }
            if (this.MJL != null) {
                aVar.ni(3, this.MJL.computeSize());
                this.MJL.writeFields(aVar);
            }
            if (this.KNW != null) {
                aVar.e(4, this.KNW);
            }
            AppMethodBeat.o(91632);
            return 0;
        } else if (i2 == 1) {
            int fS = g.a.a.b.b.a.fS(1) + 1 + 0;
            if (this.MJK != null) {
                fS += g.a.a.a.nh(2, this.MJK.computeSize());
            }
            if (this.MJL != null) {
                fS += g.a.a.a.nh(3, this.MJL.computeSize());
            }
            if (this.KNW != null) {
                fS += g.a.a.b.b.a.f(4, this.KNW);
            }
            AppMethodBeat.o(91632);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91632);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            deq deq = (deq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    deq.MJJ = aVar3.UbS.yZ();
                    AppMethodBeat.o(91632);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dyr dyr = new dyr();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dyr.populateBuilderWithField(aVar4, dyr, a.getNextFieldNumber(aVar4))) {
                        }
                        deq.MJK = dyr;
                    }
                    AppMethodBeat.o(91632);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dyr dyr2 = new dyr();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dyr2.populateBuilderWithField(aVar5, dyr2, a.getNextFieldNumber(aVar5))) {
                        }
                        deq.MJL = dyr2;
                    }
                    AppMethodBeat.o(91632);
                    return 0;
                case 4:
                    deq.KNW = aVar3.UbS.readString();
                    AppMethodBeat.o(91632);
                    return 0;
                default:
                    AppMethodBeat.o(91632);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91632);
            return -1;
        }
    }
}
