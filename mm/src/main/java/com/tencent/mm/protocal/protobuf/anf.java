package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class anf extends a {
    public String KTg;
    public LinkedList<amz> Lyf = new LinkedList<>();
    public amz Lyg;
    public int him;

    public anf() {
        AppMethodBeat.i(127478);
        AppMethodBeat.o(127478);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(127479);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.him);
            if (this.KTg != null) {
                aVar.e(2, this.KTg);
            }
            aVar.e(3, 8, this.Lyf);
            if (this.Lyg != null) {
                aVar.ni(4, this.Lyg.computeSize());
                this.Lyg.writeFields(aVar);
            }
            AppMethodBeat.o(127479);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.him) + 0;
            if (this.KTg != null) {
                bu += g.a.a.b.b.a.f(2, this.KTg);
            }
            int c2 = bu + g.a.a.a.c(3, 8, this.Lyf);
            if (this.Lyg != null) {
                c2 += g.a.a.a.nh(4, this.Lyg.computeSize());
            }
            AppMethodBeat.o(127479);
            return c2;
        } else if (i2 == 2) {
            this.Lyf.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(127479);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            anf anf = (anf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    anf.him = aVar3.UbS.zi();
                    AppMethodBeat.o(127479);
                    return 0;
                case 2:
                    anf.KTg = aVar3.UbS.readString();
                    AppMethodBeat.o(127479);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        amz amz = new amz();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = amz.populateBuilderWithField(aVar4, amz, a.getNextFieldNumber(aVar4))) {
                        }
                        anf.Lyf.add(amz);
                    }
                    AppMethodBeat.o(127479);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        amz amz2 = new amz();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = amz2.populateBuilderWithField(aVar5, amz2, a.getNextFieldNumber(aVar5))) {
                        }
                        anf.Lyg = amz2;
                    }
                    AppMethodBeat.o(127479);
                    return 0;
                default:
                    AppMethodBeat.o(127479);
                    return -1;
            }
        } else {
            AppMethodBeat.o(127479);
            return -1;
        }
    }
}
