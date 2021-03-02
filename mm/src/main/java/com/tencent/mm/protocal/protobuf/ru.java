package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class ru extends a {
    public long KZg;
    public int KZh;
    public LinkedList<String> KZi = new LinkedList<>();
    public String KZj;
    public int KZk;
    public String Title;
    public int oTY;
    public LinkedList<sb> xKD = new LinkedList<>();

    public ru() {
        AppMethodBeat.i(117842);
        AppMethodBeat.o(117842);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117843);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KZj == null) {
                b bVar = new b("Not all required fields were included: SearchID");
                AppMethodBeat.o(117843);
                throw bVar;
            }
            aVar.bb(1, this.KZg);
            aVar.aM(2, this.KZh);
            if (this.Title != null) {
                aVar.e(3, this.Title);
            }
            aVar.e(4, 1, this.KZi);
            aVar.e(5, 8, this.xKD);
            aVar.aM(6, this.oTY);
            if (this.KZj != null) {
                aVar.e(7, this.KZj);
            }
            aVar.aM(8, this.KZk);
            AppMethodBeat.o(117843);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.KZg) + 0 + g.a.a.b.b.a.bu(2, this.KZh);
            if (this.Title != null) {
                r += g.a.a.b.b.a.f(3, this.Title);
            }
            int c2 = r + g.a.a.a.c(4, 1, this.KZi) + g.a.a.a.c(5, 8, this.xKD) + g.a.a.b.b.a.bu(6, this.oTY);
            if (this.KZj != null) {
                c2 += g.a.a.b.b.a.f(7, this.KZj);
            }
            int bu = c2 + g.a.a.b.b.a.bu(8, this.KZk);
            AppMethodBeat.o(117843);
            return bu;
        } else if (i2 == 2) {
            this.KZi.clear();
            this.xKD.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.KZj == null) {
                b bVar2 = new b("Not all required fields were included: SearchID");
                AppMethodBeat.o(117843);
                throw bVar2;
            }
            AppMethodBeat.o(117843);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ru ruVar = (ru) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ruVar.KZg = aVar3.UbS.zl();
                    AppMethodBeat.o(117843);
                    return 0;
                case 2:
                    ruVar.KZh = aVar3.UbS.zi();
                    AppMethodBeat.o(117843);
                    return 0;
                case 3:
                    ruVar.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(117843);
                    return 0;
                case 4:
                    ruVar.KZi.add(aVar3.UbS.readString());
                    AppMethodBeat.o(117843);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        sb sbVar = new sb();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = sbVar.populateBuilderWithField(aVar4, sbVar, a.getNextFieldNumber(aVar4))) {
                        }
                        ruVar.xKD.add(sbVar);
                    }
                    AppMethodBeat.o(117843);
                    return 0;
                case 6:
                    ruVar.oTY = aVar3.UbS.zi();
                    AppMethodBeat.o(117843);
                    return 0;
                case 7:
                    ruVar.KZj = aVar3.UbS.readString();
                    AppMethodBeat.o(117843);
                    return 0;
                case 8:
                    ruVar.KZk = aVar3.UbS.zi();
                    AppMethodBeat.o(117843);
                    return 0;
                default:
                    AppMethodBeat.o(117843);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117843);
            return -1;
        }
    }
}
