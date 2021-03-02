package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class w extends a {
    public String xJL;
    public String xJM;
    public String xJN;
    public er xJO;
    public int xJP;
    public int xJQ;
    public String xJR;
    public int xJS;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41721);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.xJL == null) {
                b bVar = new b("Not all required fields were included: DownloadURL");
                AppMethodBeat.o(41721);
                throw bVar;
            }
            if (this.xJL != null) {
                aVar.e(1, this.xJL);
            }
            if (this.xJM != null) {
                aVar.e(2, this.xJM);
            }
            if (this.xJN != null) {
                aVar.e(4, this.xJN);
            }
            if (this.xJO != null) {
                aVar.ni(5, this.xJO.computeSize());
                this.xJO.writeFields(aVar);
            }
            aVar.aM(6, this.xJP);
            aVar.aM(7, this.xJQ);
            if (this.xJR != null) {
                aVar.e(8, this.xJR);
            }
            aVar.aM(9, this.xJS);
            AppMethodBeat.o(41721);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.xJL != null ? g.a.a.b.b.a.f(1, this.xJL) + 0 : 0;
            if (this.xJM != null) {
                f2 += g.a.a.b.b.a.f(2, this.xJM);
            }
            if (this.xJN != null) {
                f2 += g.a.a.b.b.a.f(4, this.xJN);
            }
            if (this.xJO != null) {
                f2 += g.a.a.a.nh(5, this.xJO.computeSize());
            }
            int bu = f2 + g.a.a.b.b.a.bu(6, this.xJP) + g.a.a.b.b.a.bu(7, this.xJQ);
            if (this.xJR != null) {
                bu += g.a.a.b.b.a.f(8, this.xJR);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(9, this.xJS);
            AppMethodBeat.o(41721);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.xJL == null) {
                b bVar2 = new b("Not all required fields were included: DownloadURL");
                AppMethodBeat.o(41721);
                throw bVar2;
            }
            AppMethodBeat.o(41721);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            w wVar = (w) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    wVar.xJL = aVar3.UbS.readString();
                    AppMethodBeat.o(41721);
                    return 0;
                case 2:
                    wVar.xJM = aVar3.UbS.readString();
                    AppMethodBeat.o(41721);
                    return 0;
                case 3:
                default:
                    AppMethodBeat.o(41721);
                    return -1;
                case 4:
                    wVar.xJN = aVar3.UbS.readString();
                    AppMethodBeat.o(41721);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        er erVar = new er();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = erVar.populateBuilderWithField(aVar4, erVar, a.getNextFieldNumber(aVar4))) {
                        }
                        wVar.xJO = erVar;
                    }
                    AppMethodBeat.o(41721);
                    return 0;
                case 6:
                    wVar.xJP = aVar3.UbS.zi();
                    AppMethodBeat.o(41721);
                    return 0;
                case 7:
                    wVar.xJQ = aVar3.UbS.zi();
                    AppMethodBeat.o(41721);
                    return 0;
                case 8:
                    wVar.xJR = aVar3.UbS.readString();
                    AppMethodBeat.o(41721);
                    return 0;
                case 9:
                    wVar.xJS = aVar3.UbS.zi();
                    AppMethodBeat.o(41721);
                    return 0;
            }
        } else {
            AppMethodBeat.o(41721);
            return -1;
        }
    }
}
