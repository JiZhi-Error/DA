package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cyp extends a {
    public String KDM;
    public int MDA;
    public LinkedList<tz> MDB = new LinkedList<>();
    public String MDC;
    public String MDD;
    public String MDx;
    public String MDy;
    public String MDz;

    public cyp() {
        AppMethodBeat.i(114047);
        AppMethodBeat.o(114047);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(114048);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KDM != null) {
                aVar.e(1, this.KDM);
            }
            if (this.MDx != null) {
                aVar.e(2, this.MDx);
            }
            if (this.MDy != null) {
                aVar.e(3, this.MDy);
            }
            if (this.MDz != null) {
                aVar.e(4, this.MDz);
            }
            aVar.aM(5, this.MDA);
            aVar.e(6, 8, this.MDB);
            if (this.MDC != null) {
                aVar.e(7, this.MDC);
            }
            if (this.MDD != null) {
                aVar.e(8, this.MDD);
            }
            AppMethodBeat.o(114048);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.KDM != null ? g.a.a.b.b.a.f(1, this.KDM) + 0 : 0;
            if (this.MDx != null) {
                f2 += g.a.a.b.b.a.f(2, this.MDx);
            }
            if (this.MDy != null) {
                f2 += g.a.a.b.b.a.f(3, this.MDy);
            }
            if (this.MDz != null) {
                f2 += g.a.a.b.b.a.f(4, this.MDz);
            }
            int bu = f2 + g.a.a.b.b.a.bu(5, this.MDA) + g.a.a.a.c(6, 8, this.MDB);
            if (this.MDC != null) {
                bu += g.a.a.b.b.a.f(7, this.MDC);
            }
            if (this.MDD != null) {
                bu += g.a.a.b.b.a.f(8, this.MDD);
            }
            AppMethodBeat.o(114048);
            return bu;
        } else if (i2 == 2) {
            this.MDB.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(114048);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cyp cyp = (cyp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cyp.KDM = aVar3.UbS.readString();
                    AppMethodBeat.o(114048);
                    return 0;
                case 2:
                    cyp.MDx = aVar3.UbS.readString();
                    AppMethodBeat.o(114048);
                    return 0;
                case 3:
                    cyp.MDy = aVar3.UbS.readString();
                    AppMethodBeat.o(114048);
                    return 0;
                case 4:
                    cyp.MDz = aVar3.UbS.readString();
                    AppMethodBeat.o(114048);
                    return 0;
                case 5:
                    cyp.MDA = aVar3.UbS.zi();
                    AppMethodBeat.o(114048);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        tz tzVar = new tz();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = tzVar.populateBuilderWithField(aVar4, tzVar, a.getNextFieldNumber(aVar4))) {
                        }
                        cyp.MDB.add(tzVar);
                    }
                    AppMethodBeat.o(114048);
                    return 0;
                case 7:
                    cyp.MDC = aVar3.UbS.readString();
                    AppMethodBeat.o(114048);
                    return 0;
                case 8:
                    cyp.MDD = aVar3.UbS.readString();
                    AppMethodBeat.o(114048);
                    return 0;
                default:
                    AppMethodBeat.o(114048);
                    return -1;
            }
        } else {
            AppMethodBeat.o(114048);
            return -1;
        }
    }
}
