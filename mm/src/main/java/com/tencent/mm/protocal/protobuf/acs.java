package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class acs extends a {
    public long Lnw;
    public aha Lnx;
    public ahe Lny;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(90958);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.Lnw);
            if (this.Lnx != null) {
                aVar.ni(2, this.Lnx.computeSize());
                this.Lnx.writeFields(aVar);
            }
            if (this.Lny != null) {
                aVar.ni(3, this.Lny.computeSize());
                this.Lny.writeFields(aVar);
            }
            AppMethodBeat.o(90958);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.Lnw) + 0;
            if (this.Lnx != null) {
                r += g.a.a.a.nh(2, this.Lnx.computeSize());
            }
            if (this.Lny != null) {
                r += g.a.a.a.nh(3, this.Lny.computeSize());
            }
            AppMethodBeat.o(90958);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(90958);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            acs acs = (acs) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    acs.Lnw = aVar3.UbS.zl();
                    AppMethodBeat.o(90958);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        aha aha = new aha();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = aha.populateBuilderWithField(aVar4, aha, a.getNextFieldNumber(aVar4))) {
                        }
                        acs.Lnx = aha;
                    }
                    AppMethodBeat.o(90958);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ahe ahe = new ahe();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ahe.populateBuilderWithField(aVar5, ahe, a.getNextFieldNumber(aVar5))) {
                        }
                        acs.Lny = ahe;
                    }
                    AppMethodBeat.o(90958);
                    return 0;
                default:
                    AppMethodBeat.o(90958);
                    return -1;
            }
        } else {
            AppMethodBeat.o(90958);
            return -1;
        }
    }
}
