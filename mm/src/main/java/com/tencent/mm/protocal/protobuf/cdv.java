package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cdv extends a {
    public String KNW;
    public ehf Mjp;
    public LinkedList<egf> Mjq = new LinkedList<>();
    public ehf Mjr;

    public cdv() {
        AppMethodBeat.i(91526);
        AppMethodBeat.o(91526);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91527);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Mjp != null) {
                aVar.ni(1, this.Mjp.computeSize());
                this.Mjp.writeFields(aVar);
            }
            aVar.e(2, 8, this.Mjq);
            if (this.Mjr != null) {
                aVar.ni(3, this.Mjr.computeSize());
                this.Mjr.writeFields(aVar);
            }
            if (this.KNW != null) {
                aVar.e(4, this.KNW);
            }
            AppMethodBeat.o(91527);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.Mjp != null ? g.a.a.a.nh(1, this.Mjp.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.Mjq);
            if (this.Mjr != null) {
                nh += g.a.a.a.nh(3, this.Mjr.computeSize());
            }
            if (this.KNW != null) {
                nh += g.a.a.b.b.a.f(4, this.KNW);
            }
            AppMethodBeat.o(91527);
            return nh;
        } else if (i2 == 2) {
            this.Mjq.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91527);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cdv cdv = (cdv) objArr[1];
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
                        cdv.Mjp = ehf;
                    }
                    AppMethodBeat.o(91527);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        egf egf = new egf();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = egf.populateBuilderWithField(aVar5, egf, a.getNextFieldNumber(aVar5))) {
                        }
                        cdv.Mjq.add(egf);
                    }
                    AppMethodBeat.o(91527);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        ehf ehf2 = new ehf();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = ehf2.populateBuilderWithField(aVar6, ehf2, a.getNextFieldNumber(aVar6))) {
                        }
                        cdv.Mjr = ehf2;
                    }
                    AppMethodBeat.o(91527);
                    return 0;
                case 4:
                    cdv.KNW = aVar3.UbS.readString();
                    AppMethodBeat.o(91527);
                    return 0;
                default:
                    AppMethodBeat.o(91527);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91527);
            return -1;
        }
    }
}
