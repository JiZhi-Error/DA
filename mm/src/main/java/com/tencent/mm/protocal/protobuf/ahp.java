package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ahp extends a {
    public dpe KWG;
    public String Lrr;
    public String Lrs;
    public int Lrt;
    public String Lru;
    public String UserName;
    public String xIy;
    public int xJa;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117866);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KWG != null) {
                aVar.ni(1, this.KWG.computeSize());
                this.KWG.writeFields(aVar);
            }
            if (this.xIy != null) {
                aVar.e(2, this.xIy);
            }
            if (this.Lrr != null) {
                aVar.e(3, this.Lrr);
            }
            aVar.aM(4, this.xJa);
            if (this.UserName != null) {
                aVar.e(5, this.UserName);
            }
            if (this.Lrs != null) {
                aVar.e(6, this.Lrs);
            }
            aVar.aM(7, this.Lrt);
            if (this.Lru != null) {
                aVar.e(8, this.Lru);
            }
            AppMethodBeat.o(117866);
            return 0;
        } else if (i2 == 1) {
            int nh = this.KWG != null ? g.a.a.a.nh(1, this.KWG.computeSize()) + 0 : 0;
            if (this.xIy != null) {
                nh += g.a.a.b.b.a.f(2, this.xIy);
            }
            if (this.Lrr != null) {
                nh += g.a.a.b.b.a.f(3, this.Lrr);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.xJa);
            if (this.UserName != null) {
                bu += g.a.a.b.b.a.f(5, this.UserName);
            }
            if (this.Lrs != null) {
                bu += g.a.a.b.b.a.f(6, this.Lrs);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(7, this.Lrt);
            if (this.Lru != null) {
                bu2 += g.a.a.b.b.a.f(8, this.Lru);
            }
            AppMethodBeat.o(117866);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(117866);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ahp ahp = (ahp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dpe dpe = new dpe();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dpe.populateBuilderWithField(aVar4, dpe, a.getNextFieldNumber(aVar4))) {
                        }
                        ahp.KWG = dpe;
                    }
                    AppMethodBeat.o(117866);
                    return 0;
                case 2:
                    ahp.xIy = aVar3.UbS.readString();
                    AppMethodBeat.o(117866);
                    return 0;
                case 3:
                    ahp.Lrr = aVar3.UbS.readString();
                    AppMethodBeat.o(117866);
                    return 0;
                case 4:
                    ahp.xJa = aVar3.UbS.zi();
                    AppMethodBeat.o(117866);
                    return 0;
                case 5:
                    ahp.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(117866);
                    return 0;
                case 6:
                    ahp.Lrs = aVar3.UbS.readString();
                    AppMethodBeat.o(117866);
                    return 0;
                case 7:
                    ahp.Lrt = aVar3.UbS.zi();
                    AppMethodBeat.o(117866);
                    return 0;
                case 8:
                    ahp.Lru = aVar3.UbS.readString();
                    AppMethodBeat.o(117866);
                    return 0;
                default:
                    AppMethodBeat.o(117866);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117866);
            return -1;
        }
    }
}
