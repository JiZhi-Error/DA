package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class as extends a {
    public String xJt;
    public String xJu;
    public LinkedList<Cdo> xKD = new LinkedList<>();
    public String xKE;
    public String xKF;

    public as() {
        AppMethodBeat.i(41738);
        AppMethodBeat.o(41738);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41739);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.xJu != null) {
                aVar.e(1, this.xJu);
            }
            aVar.e(2, 8, this.xKD);
            if (this.xKE != null) {
                aVar.e(3, this.xKE);
            }
            if (this.xKF != null) {
                aVar.e(4, this.xKF);
            }
            if (this.xJt != null) {
                aVar.e(5, this.xJt);
            }
            AppMethodBeat.o(41739);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.xJu != null ? g.a.a.b.b.a.f(1, this.xJu) + 0 : 0) + g.a.a.a.c(2, 8, this.xKD);
            if (this.xKE != null) {
                f2 += g.a.a.b.b.a.f(3, this.xKE);
            }
            if (this.xKF != null) {
                f2 += g.a.a.b.b.a.f(4, this.xKF);
            }
            if (this.xJt != null) {
                f2 += g.a.a.b.b.a.f(5, this.xJt);
            }
            AppMethodBeat.o(41739);
            return f2;
        } else if (i2 == 2) {
            this.xKD.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(41739);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            as asVar = (as) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    asVar.xJu = aVar3.UbS.readString();
                    AppMethodBeat.o(41739);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        Cdo doVar = new Cdo();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = doVar.populateBuilderWithField(aVar4, doVar, a.getNextFieldNumber(aVar4))) {
                        }
                        asVar.xKD.add(doVar);
                    }
                    AppMethodBeat.o(41739);
                    return 0;
                case 3:
                    asVar.xKE = aVar3.UbS.readString();
                    AppMethodBeat.o(41739);
                    return 0;
                case 4:
                    asVar.xKF = aVar3.UbS.readString();
                    AppMethodBeat.o(41739);
                    return 0;
                case 5:
                    asVar.xJt = aVar3.UbS.readString();
                    AppMethodBeat.o(41739);
                    return 0;
                default:
                    AppMethodBeat.o(41739);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41739);
            return -1;
        }
    }
}
