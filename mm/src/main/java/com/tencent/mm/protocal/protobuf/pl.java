package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class pl extends a {
    public LinkedList<oq> KUf = new LinkedList<>();
    public int KUh;
    public String KUi;
    public String KWA;
    public long KWz;

    public pl() {
        AppMethodBeat.i(212256);
        AppMethodBeat.o(212256);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(212257);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.KWz);
            aVar.e(2, 8, this.KUf);
            aVar.aM(3, this.KUh);
            if (this.KUi != null) {
                aVar.e(4, this.KUi);
            }
            if (this.KWA != null) {
                aVar.e(5, this.KWA);
            }
            AppMethodBeat.o(212257);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.KWz) + 0 + g.a.a.a.c(2, 8, this.KUf) + g.a.a.b.b.a.bu(3, this.KUh);
            if (this.KUi != null) {
                r += g.a.a.b.b.a.f(4, this.KUi);
            }
            if (this.KWA != null) {
                r += g.a.a.b.b.a.f(5, this.KWA);
            }
            AppMethodBeat.o(212257);
            return r;
        } else if (i2 == 2) {
            this.KUf.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(212257);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            pl plVar = (pl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    plVar.KWz = aVar3.UbS.zl();
                    AppMethodBeat.o(212257);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        oq oqVar = new oq();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = oqVar.populateBuilderWithField(aVar4, oqVar, a.getNextFieldNumber(aVar4))) {
                        }
                        plVar.KUf.add(oqVar);
                    }
                    AppMethodBeat.o(212257);
                    return 0;
                case 3:
                    plVar.KUh = aVar3.UbS.zi();
                    AppMethodBeat.o(212257);
                    return 0;
                case 4:
                    plVar.KUi = aVar3.UbS.readString();
                    AppMethodBeat.o(212257);
                    return 0;
                case 5:
                    plVar.KWA = aVar3.UbS.readString();
                    AppMethodBeat.o(212257);
                    return 0;
                default:
                    AppMethodBeat.o(212257);
                    return -1;
            }
        } else {
            AppMethodBeat.o(212257);
            return -1;
        }
    }
}
