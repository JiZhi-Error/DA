package com.tencent.mm.plugin.gamelife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class b extends a {
    public int fuA;
    public String nickname;
    public String tag;
    public String uNR;
    public String username;
    public l yaZ;
    public int yba;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(225885);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.username == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: username");
                AppMethodBeat.o(225885);
                throw bVar;
            }
            if (this.username != null) {
                aVar.e(1, this.username);
            }
            if (this.nickname != null) {
                aVar.e(2, this.nickname);
            }
            if (this.uNR != null) {
                aVar.e(3, this.uNR);
            }
            aVar.aM(4, this.fuA);
            if (this.tag != null) {
                aVar.e(5, this.tag);
            }
            if (this.yaZ != null) {
                aVar.ni(6, this.yaZ.computeSize());
                this.yaZ.writeFields(aVar);
            }
            aVar.aM(7, this.yba);
            AppMethodBeat.o(225885);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.username != null ? g.a.a.b.b.a.f(1, this.username) + 0 : 0;
            if (this.nickname != null) {
                f2 += g.a.a.b.b.a.f(2, this.nickname);
            }
            if (this.uNR != null) {
                f2 += g.a.a.b.b.a.f(3, this.uNR);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.fuA);
            if (this.tag != null) {
                bu += g.a.a.b.b.a.f(5, this.tag);
            }
            if (this.yaZ != null) {
                bu += g.a.a.a.nh(6, this.yaZ.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(7, this.yba);
            AppMethodBeat.o(225885);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.username == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: username");
                AppMethodBeat.o(225885);
                throw bVar2;
            }
            AppMethodBeat.o(225885);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            b bVar3 = (b) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bVar3.username = aVar3.UbS.readString();
                    AppMethodBeat.o(225885);
                    return 0;
                case 2:
                    bVar3.nickname = aVar3.UbS.readString();
                    AppMethodBeat.o(225885);
                    return 0;
                case 3:
                    bVar3.uNR = aVar3.UbS.readString();
                    AppMethodBeat.o(225885);
                    return 0;
                case 4:
                    bVar3.fuA = aVar3.UbS.zi();
                    AppMethodBeat.o(225885);
                    return 0;
                case 5:
                    bVar3.tag = aVar3.UbS.readString();
                    AppMethodBeat.o(225885);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        l lVar = new l();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = lVar.populateBuilderWithField(aVar4, lVar, a.getNextFieldNumber(aVar4))) {
                        }
                        bVar3.yaZ = lVar;
                    }
                    AppMethodBeat.o(225885);
                    return 0;
                case 7:
                    bVar3.yba = aVar3.UbS.zi();
                    AppMethodBeat.o(225885);
                    return 0;
                default:
                    AppMethodBeat.o(225885);
                    return -1;
            }
        } else {
            AppMethodBeat.o(225885);
            return -1;
        }
    }
}
