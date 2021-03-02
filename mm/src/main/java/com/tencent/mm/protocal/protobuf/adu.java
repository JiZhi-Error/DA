package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class adu extends a {
    public String Lpm;
    public LinkedList<ua> iAd = new LinkedList<>();

    public adu() {
        AppMethodBeat.i(201328);
        AppMethodBeat.o(201328);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(201329);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Lpm != null) {
                aVar.e(1, this.Lpm);
            }
            aVar.e(2, 8, this.iAd);
            AppMethodBeat.o(201329);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.Lpm != null ? g.a.a.b.b.a.f(1, this.Lpm) + 0 : 0) + g.a.a.a.c(2, 8, this.iAd);
            AppMethodBeat.o(201329);
            return f2;
        } else if (i2 == 2) {
            this.iAd.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(201329);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            adu adu = (adu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    adu.Lpm = aVar3.UbS.readString();
                    AppMethodBeat.o(201329);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ua uaVar = new ua();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = uaVar.populateBuilderWithField(aVar4, uaVar, a.getNextFieldNumber(aVar4))) {
                        }
                        adu.iAd.add(uaVar);
                    }
                    AppMethodBeat.o(201329);
                    return 0;
                default:
                    AppMethodBeat.o(201329);
                    return -1;
            }
        } else {
            AppMethodBeat.o(201329);
            return -1;
        }
    }
}
