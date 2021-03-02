package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class duc extends a {
    public String DRR;
    public int LaB;
    public LinkedList<eif> MVN = new LinkedList<>();
    public String aesKey;
    public int iFw;
    public int jqS;
    public String md5;
    public int thumbHeight;
    public int thumbWidth;
    public String url;

    public duc() {
        AppMethodBeat.i(127174);
        AppMethodBeat.o(127174);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(127175);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.DRR == null) {
                b bVar = new b("Not all required fields were included: clientID");
                AppMethodBeat.o(127175);
                throw bVar;
            }
            aVar.e(1, 8, this.MVN);
            if (this.DRR != null) {
                aVar.e(2, this.DRR);
            }
            if (this.md5 != null) {
                aVar.e(3, this.md5);
            }
            if (this.aesKey != null) {
                aVar.e(4, this.aesKey);
            }
            if (this.url != null) {
                aVar.e(5, this.url);
            }
            aVar.aM(6, this.iFw);
            aVar.aM(7, this.jqS);
            aVar.aM(8, this.LaB);
            aVar.aM(9, this.thumbHeight);
            aVar.aM(10, this.thumbWidth);
            AppMethodBeat.o(127175);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.MVN) + 0;
            if (this.DRR != null) {
                c2 += g.a.a.b.b.a.f(2, this.DRR);
            }
            if (this.md5 != null) {
                c2 += g.a.a.b.b.a.f(3, this.md5);
            }
            if (this.aesKey != null) {
                c2 += g.a.a.b.b.a.f(4, this.aesKey);
            }
            if (this.url != null) {
                c2 += g.a.a.b.b.a.f(5, this.url);
            }
            int bu = c2 + g.a.a.b.b.a.bu(6, this.iFw) + g.a.a.b.b.a.bu(7, this.jqS) + g.a.a.b.b.a.bu(8, this.LaB) + g.a.a.b.b.a.bu(9, this.thumbHeight) + g.a.a.b.b.a.bu(10, this.thumbWidth);
            AppMethodBeat.o(127175);
            return bu;
        } else if (i2 == 2) {
            this.MVN.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.DRR == null) {
                b bVar2 = new b("Not all required fields were included: clientID");
                AppMethodBeat.o(127175);
                throw bVar2;
            }
            AppMethodBeat.o(127175);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            duc duc = (duc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        eif eif = new eif();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = eif.populateBuilderWithField(aVar4, eif, a.getNextFieldNumber(aVar4))) {
                        }
                        duc.MVN.add(eif);
                    }
                    AppMethodBeat.o(127175);
                    return 0;
                case 2:
                    duc.DRR = aVar3.UbS.readString();
                    AppMethodBeat.o(127175);
                    return 0;
                case 3:
                    duc.md5 = aVar3.UbS.readString();
                    AppMethodBeat.o(127175);
                    return 0;
                case 4:
                    duc.aesKey = aVar3.UbS.readString();
                    AppMethodBeat.o(127175);
                    return 0;
                case 5:
                    duc.url = aVar3.UbS.readString();
                    AppMethodBeat.o(127175);
                    return 0;
                case 6:
                    duc.iFw = aVar3.UbS.zi();
                    AppMethodBeat.o(127175);
                    return 0;
                case 7:
                    duc.jqS = aVar3.UbS.zi();
                    AppMethodBeat.o(127175);
                    return 0;
                case 8:
                    duc.LaB = aVar3.UbS.zi();
                    AppMethodBeat.o(127175);
                    return 0;
                case 9:
                    duc.thumbHeight = aVar3.UbS.zi();
                    AppMethodBeat.o(127175);
                    return 0;
                case 10:
                    duc.thumbWidth = aVar3.UbS.zi();
                    AppMethodBeat.o(127175);
                    return 0;
                default:
                    AppMethodBeat.o(127175);
                    return -1;
            }
        } else {
            AppMethodBeat.o(127175);
            return -1;
        }
    }
}
