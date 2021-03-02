package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class sc extends a {
    public b KZM;
    public b KZN;
    public LinkedList<duv> KZO = new LinkedList<>();

    public sc() {
        AppMethodBeat.i(117851);
        AppMethodBeat.o(117851);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117852);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KZM == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: Title");
                AppMethodBeat.o(117852);
                throw bVar;
            } else if (this.KZN == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: ServiceUrl");
                AppMethodBeat.o(117852);
                throw bVar2;
            } else {
                if (this.KZM != null) {
                    aVar.c(1, this.KZM);
                }
                if (this.KZN != null) {
                    aVar.c(2, this.KZN);
                }
                aVar.e(3, 8, this.KZO);
                AppMethodBeat.o(117852);
                return 0;
            }
        } else if (i2 == 1) {
            int b2 = this.KZM != null ? g.a.a.b.b.a.b(1, this.KZM) + 0 : 0;
            if (this.KZN != null) {
                b2 += g.a.a.b.b.a.b(2, this.KZN);
            }
            int c2 = b2 + g.a.a.a.c(3, 8, this.KZO);
            AppMethodBeat.o(117852);
            return c2;
        } else if (i2 == 2) {
            this.KZO.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.KZM == null) {
                g.a.a.b bVar3 = new g.a.a.b("Not all required fields were included: Title");
                AppMethodBeat.o(117852);
                throw bVar3;
            } else if (this.KZN == null) {
                g.a.a.b bVar4 = new g.a.a.b("Not all required fields were included: ServiceUrl");
                AppMethodBeat.o(117852);
                throw bVar4;
            } else {
                AppMethodBeat.o(117852);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            sc scVar = (sc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    scVar.KZM = aVar3.UbS.hPo();
                    AppMethodBeat.o(117852);
                    return 0;
                case 2:
                    scVar.KZN = aVar3.UbS.hPo();
                    AppMethodBeat.o(117852);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        duv duv = new duv();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = duv.populateBuilderWithField(aVar4, duv, a.getNextFieldNumber(aVar4))) {
                        }
                        scVar.KZO.add(duv);
                    }
                    AppMethodBeat.o(117852);
                    return 0;
                default:
                    AppMethodBeat.o(117852);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117852);
            return -1;
        }
    }
}
