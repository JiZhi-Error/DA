package com.tencent.mm.plugin.location.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class a extends com.tencent.mm.bw.a {
    public LinkedList<String> dTe = new LinkedList<>();
    public double latitude;
    public double longitude;
    public long timestamp;
    public String username;
    public String yFq;

    public a() {
        AppMethodBeat.i(55668);
        AppMethodBeat.o(55668);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(55669);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.username == null) {
                b bVar = new b("Not all required fields were included: username");
                AppMethodBeat.o(55669);
                throw bVar;
            }
            if (this.username != null) {
                aVar.e(1, this.username);
            }
            aVar.e(2, 1, this.dTe);
            aVar.e(3, this.longitude);
            aVar.e(4, this.latitude);
            if (this.yFq != null) {
                aVar.e(5, this.yFq);
            }
            aVar.bb(6, this.timestamp);
            AppMethodBeat.o(55669);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.username != null ? g.a.a.b.b.a.f(1, this.username) + 0 : 0) + g.a.a.a.c(2, 1, this.dTe) + g.a.a.b.b.a.fS(3) + 8 + g.a.a.b.b.a.fS(4) + 8;
            if (this.yFq != null) {
                f2 += g.a.a.b.b.a.f(5, this.yFq);
            }
            int r = f2 + g.a.a.b.b.a.r(6, this.timestamp);
            AppMethodBeat.o(55669);
            return r;
        } else if (i2 == 2) {
            this.dTe.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = com.tencent.mm.bw.a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = com.tencent.mm.bw.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.username == null) {
                b bVar2 = new b("Not all required fields were included: username");
                AppMethodBeat.o(55669);
                throw bVar2;
            }
            AppMethodBeat.o(55669);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aVar4.username = aVar3.UbS.readString();
                    AppMethodBeat.o(55669);
                    return 0;
                case 2:
                    aVar4.dTe.add(aVar3.UbS.readString());
                    AppMethodBeat.o(55669);
                    return 0;
                case 3:
                    aVar4.longitude = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(55669);
                    return 0;
                case 4:
                    aVar4.latitude = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(55669);
                    return 0;
                case 5:
                    aVar4.yFq = aVar3.UbS.readString();
                    AppMethodBeat.o(55669);
                    return 0;
                case 6:
                    aVar4.timestamp = aVar3.UbS.zl();
                    AppMethodBeat.o(55669);
                    return 0;
                default:
                    AppMethodBeat.o(55669);
                    return -1;
            }
        } else {
            AppMethodBeat.o(55669);
            return -1;
        }
    }
}
