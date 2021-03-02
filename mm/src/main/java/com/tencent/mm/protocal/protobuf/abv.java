package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class abv extends a {
    public String KJM;
    public String Lmx;
    public abr Lmy;
    public String dPI;
    public long timestamp;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117861);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.timestamp);
            if (this.Lmx != null) {
                aVar.e(2, this.Lmx);
            }
            if (this.KJM != null) {
                aVar.e(3, this.KJM);
            }
            if (this.dPI != null) {
                aVar.e(4, this.dPI);
            }
            if (this.Lmy != null) {
                aVar.ni(5, this.Lmy.computeSize());
                this.Lmy.writeFields(aVar);
            }
            AppMethodBeat.o(117861);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.timestamp) + 0;
            if (this.Lmx != null) {
                r += g.a.a.b.b.a.f(2, this.Lmx);
            }
            if (this.KJM != null) {
                r += g.a.a.b.b.a.f(3, this.KJM);
            }
            if (this.dPI != null) {
                r += g.a.a.b.b.a.f(4, this.dPI);
            }
            if (this.Lmy != null) {
                r += g.a.a.a.nh(5, this.Lmy.computeSize());
            }
            AppMethodBeat.o(117861);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(117861);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            abv abv = (abv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    abv.timestamp = aVar3.UbS.zl();
                    AppMethodBeat.o(117861);
                    return 0;
                case 2:
                    abv.Lmx = aVar3.UbS.readString();
                    AppMethodBeat.o(117861);
                    return 0;
                case 3:
                    abv.KJM = aVar3.UbS.readString();
                    AppMethodBeat.o(117861);
                    return 0;
                case 4:
                    abv.dPI = aVar3.UbS.readString();
                    AppMethodBeat.o(117861);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        abr abr = new abr();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = abr.populateBuilderWithField(aVar4, abr, a.getNextFieldNumber(aVar4))) {
                        }
                        abv.Lmy = abr;
                    }
                    AppMethodBeat.o(117861);
                    return 0;
                default:
                    AppMethodBeat.o(117861);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117861);
            return -1;
        }
    }
}
