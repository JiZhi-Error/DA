package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class evv extends a {
    public evr NtD;
    public evh NtE;
    public String NtF;
    public String NtG;
    public String NtH;
    public int NtI;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(147809);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.NtD != null) {
                aVar.ni(1, this.NtD.computeSize());
                this.NtD.writeFields(aVar);
            }
            if (this.NtE != null) {
                aVar.ni(2, this.NtE.computeSize());
                this.NtE.writeFields(aVar);
            }
            if (this.NtF != null) {
                aVar.e(3, this.NtF);
            }
            if (this.NtG != null) {
                aVar.e(4, this.NtG);
            }
            if (this.NtH != null) {
                aVar.e(5, this.NtH);
            }
            aVar.aM(6, this.NtI);
            AppMethodBeat.o(147809);
            return 0;
        } else if (i2 == 1) {
            int nh = this.NtD != null ? g.a.a.a.nh(1, this.NtD.computeSize()) + 0 : 0;
            if (this.NtE != null) {
                nh += g.a.a.a.nh(2, this.NtE.computeSize());
            }
            if (this.NtF != null) {
                nh += g.a.a.b.b.a.f(3, this.NtF);
            }
            if (this.NtG != null) {
                nh += g.a.a.b.b.a.f(4, this.NtG);
            }
            if (this.NtH != null) {
                nh += g.a.a.b.b.a.f(5, this.NtH);
            }
            int bu = nh + g.a.a.b.b.a.bu(6, this.NtI);
            AppMethodBeat.o(147809);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(147809);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            evv evv = (evv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        evr evr = new evr();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = evr.populateBuilderWithField(aVar4, evr, a.getNextFieldNumber(aVar4))) {
                        }
                        evv.NtD = evr;
                    }
                    AppMethodBeat.o(147809);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        evh evh = new evh();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = evh.populateBuilderWithField(aVar5, evh, a.getNextFieldNumber(aVar5))) {
                        }
                        evv.NtE = evh;
                    }
                    AppMethodBeat.o(147809);
                    return 0;
                case 3:
                    evv.NtF = aVar3.UbS.readString();
                    AppMethodBeat.o(147809);
                    return 0;
                case 4:
                    evv.NtG = aVar3.UbS.readString();
                    AppMethodBeat.o(147809);
                    return 0;
                case 5:
                    evv.NtH = aVar3.UbS.readString();
                    AppMethodBeat.o(147809);
                    return 0;
                case 6:
                    evv.NtI = aVar3.UbS.zi();
                    AppMethodBeat.o(147809);
                    return 0;
                default:
                    AppMethodBeat.o(147809);
                    return -1;
            }
        } else {
            AppMethodBeat.o(147809);
            return -1;
        }
    }
}
