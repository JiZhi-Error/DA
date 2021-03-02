package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class oh extends a {
    public LinkedList<ewv> KUa = new LinkedList<>();
    public LinkedList<String> KUc = new LinkedList<>();
    public String KUd;
    public String KUe;

    public oh() {
        AppMethodBeat.i(212234);
        AppMethodBeat.o(212234);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(212235);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(15, 8, this.KUa);
            aVar.e(17, 1, this.KUc);
            if (this.KUd != null) {
                aVar.e(18, this.KUd);
            }
            if (this.KUe != null) {
                aVar.e(19, this.KUe);
            }
            AppMethodBeat.o(212235);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(15, 8, this.KUa) + 0 + g.a.a.a.c(17, 1, this.KUc);
            if (this.KUd != null) {
                c2 += g.a.a.b.b.a.f(18, this.KUd);
            }
            if (this.KUe != null) {
                c2 += g.a.a.b.b.a.f(19, this.KUe);
            }
            AppMethodBeat.o(212235);
            return c2;
        } else if (i2 == 2) {
            this.KUa.clear();
            this.KUc.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(212235);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            oh ohVar = (oh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 15:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ewv ewv = new ewv();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ewv.populateBuilderWithField(aVar4, ewv, a.getNextFieldNumber(aVar4))) {
                        }
                        ohVar.KUa.add(ewv);
                    }
                    AppMethodBeat.o(212235);
                    return 0;
                case 16:
                default:
                    AppMethodBeat.o(212235);
                    return -1;
                case 17:
                    ohVar.KUc.add(aVar3.UbS.readString());
                    AppMethodBeat.o(212235);
                    return 0;
                case 18:
                    ohVar.KUd = aVar3.UbS.readString();
                    AppMethodBeat.o(212235);
                    return 0;
                case 19:
                    ohVar.KUe = aVar3.UbS.readString();
                    AppMethodBeat.o(212235);
                    return 0;
            }
        } else {
            AppMethodBeat.o(212235);
            return -1;
        }
    }
}
