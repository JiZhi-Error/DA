package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dvk extends a {
    public String LPM;
    public long LPN;
    public LinkedList<dvg> MWr = new LinkedList<>();
    public int index = -1;
    public String sGF;
    public int type = 0;
    public boolean vtY = false;

    public dvk() {
        AppMethodBeat.i(169384);
        AppMethodBeat.o(169384);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(169385);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.sGF != null) {
                aVar.e(1, this.sGF);
            }
            aVar.bb(2, this.LPN);
            aVar.e(3, 8, this.MWr);
            if (this.LPM != null) {
                aVar.e(4, this.LPM);
            }
            aVar.cc(5, this.vtY);
            aVar.aM(6, this.type);
            aVar.aM(7, this.index);
            AppMethodBeat.o(169385);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.sGF != null ? g.a.a.b.b.a.f(1, this.sGF) + 0 : 0) + g.a.a.b.b.a.r(2, this.LPN) + g.a.a.a.c(3, 8, this.MWr);
            if (this.LPM != null) {
                f2 += g.a.a.b.b.a.f(4, this.LPM);
            }
            int fS = f2 + g.a.a.b.b.a.fS(5) + 1 + g.a.a.b.b.a.bu(6, this.type) + g.a.a.b.b.a.bu(7, this.index);
            AppMethodBeat.o(169385);
            return fS;
        } else if (i2 == 2) {
            this.MWr.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(169385);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dvk dvk = (dvk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dvk.sGF = aVar3.UbS.readString();
                    AppMethodBeat.o(169385);
                    return 0;
                case 2:
                    dvk.LPN = aVar3.UbS.zl();
                    AppMethodBeat.o(169385);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dvg dvg = new dvg();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dvg.populateBuilderWithField(aVar4, dvg, a.getNextFieldNumber(aVar4))) {
                        }
                        dvk.MWr.add(dvg);
                    }
                    AppMethodBeat.o(169385);
                    return 0;
                case 4:
                    dvk.LPM = aVar3.UbS.readString();
                    AppMethodBeat.o(169385);
                    return 0;
                case 5:
                    dvk.vtY = aVar3.UbS.yZ();
                    AppMethodBeat.o(169385);
                    return 0;
                case 6:
                    dvk.type = aVar3.UbS.zi();
                    AppMethodBeat.o(169385);
                    return 0;
                case 7:
                    dvk.index = aVar3.UbS.zi();
                    AppMethodBeat.o(169385);
                    return 0;
                default:
                    AppMethodBeat.o(169385);
                    return -1;
            }
        } else {
            AppMethodBeat.o(169385);
            return -1;
        }
    }
}
