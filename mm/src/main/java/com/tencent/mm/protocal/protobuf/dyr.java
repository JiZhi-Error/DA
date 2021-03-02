package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dyr extends a {
    public String KNW;
    public dpq MYf;
    public ehf Mwy;
    public int type;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91693);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Mwy != null) {
                aVar.ni(1, this.Mwy.computeSize());
                this.Mwy.writeFields(aVar);
            }
            if (this.MYf != null) {
                aVar.ni(2, this.MYf.computeSize());
                this.MYf.writeFields(aVar);
            }
            aVar.aM(3, this.type);
            if (this.KNW != null) {
                aVar.e(4, this.KNW);
            }
            AppMethodBeat.o(91693);
            return 0;
        } else if (i2 == 1) {
            int nh = this.Mwy != null ? g.a.a.a.nh(1, this.Mwy.computeSize()) + 0 : 0;
            if (this.MYf != null) {
                nh += g.a.a.a.nh(2, this.MYf.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.type);
            if (this.KNW != null) {
                bu += g.a.a.b.b.a.f(4, this.KNW);
            }
            AppMethodBeat.o(91693);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91693);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dyr dyr = (dyr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ehf ehf = new ehf();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ehf.populateBuilderWithField(aVar4, ehf, a.getNextFieldNumber(aVar4))) {
                        }
                        dyr.Mwy = ehf;
                    }
                    AppMethodBeat.o(91693);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dpq dpq = new dpq();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dpq.populateBuilderWithField(aVar5, dpq, a.getNextFieldNumber(aVar5))) {
                        }
                        dyr.MYf = dpq;
                    }
                    AppMethodBeat.o(91693);
                    return 0;
                case 3:
                    dyr.type = aVar3.UbS.zi();
                    AppMethodBeat.o(91693);
                    return 0;
                case 4:
                    dyr.KNW = aVar3.UbS.readString();
                    AppMethodBeat.o(91693);
                    return 0;
                default:
                    AppMethodBeat.o(91693);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91693);
            return -1;
        }
    }
}
