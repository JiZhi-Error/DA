package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class rc extends a {
    public LinkedList<ans> KXX = new LinkedList<>();
    public LinkedList<anr> KXY = new LinkedList<>();
    public String KXZ;
    public String KYa;
    public String KYb;

    public rc() {
        AppMethodBeat.i(91368);
        AppMethodBeat.o(91368);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91369);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.KXX);
            aVar.e(2, 8, this.KXY);
            if (this.KXZ != null) {
                aVar.e(3, this.KXZ);
            }
            if (this.KYa != null) {
                aVar.e(4, this.KYa);
            }
            if (this.KYb != null) {
                aVar.e(5, this.KYb);
            }
            AppMethodBeat.o(91369);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.KXX) + 0 + g.a.a.a.c(2, 8, this.KXY);
            if (this.KXZ != null) {
                c2 += g.a.a.b.b.a.f(3, this.KXZ);
            }
            if (this.KYa != null) {
                c2 += g.a.a.b.b.a.f(4, this.KYa);
            }
            if (this.KYb != null) {
                c2 += g.a.a.b.b.a.f(5, this.KYb);
            }
            AppMethodBeat.o(91369);
            return c2;
        } else if (i2 == 2) {
            this.KXX.clear();
            this.KXY.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91369);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            rc rcVar = (rc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ans ans = new ans();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ans.populateBuilderWithField(aVar4, ans, a.getNextFieldNumber(aVar4))) {
                        }
                        rcVar.KXX.add(ans);
                    }
                    AppMethodBeat.o(91369);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        anr anr = new anr();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = anr.populateBuilderWithField(aVar5, anr, a.getNextFieldNumber(aVar5))) {
                        }
                        rcVar.KXY.add(anr);
                    }
                    AppMethodBeat.o(91369);
                    return 0;
                case 3:
                    rcVar.KXZ = aVar3.UbS.readString();
                    AppMethodBeat.o(91369);
                    return 0;
                case 4:
                    rcVar.KYa = aVar3.UbS.readString();
                    AppMethodBeat.o(91369);
                    return 0;
                case 5:
                    rcVar.KYb = aVar3.UbS.readString();
                    AppMethodBeat.o(91369);
                    return 0;
                default:
                    AppMethodBeat.o(91369);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91369);
            return -1;
        }
    }
}
