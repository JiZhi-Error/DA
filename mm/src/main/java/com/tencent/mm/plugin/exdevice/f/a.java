package com.tencent.mm.plugin.exdevice.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class a extends i {
    public String oTI;
    public b rBB;
    public int rBC;
    public int rBD;
    public int rBE;
    public b rBF;
    public b rBG;
    public String rBH;
    public String rBI;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(23485);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.rCb != null) {
                aVar.ni(1, this.rCb.computeSize());
                this.rCb.writeFields(aVar);
            }
            if (this.rBB != null) {
                aVar.c(2, this.rBB);
            }
            aVar.aM(3, this.rBC);
            aVar.aM(4, this.rBD);
            aVar.aM(5, this.rBE);
            if (this.rBF != null) {
                aVar.c(6, this.rBF);
            }
            if (this.rBG != null) {
                aVar.c(7, this.rBG);
            }
            if (this.rBH != null) {
                aVar.e(10, this.rBH);
            }
            if (this.rBI != null) {
                aVar.e(11, this.rBI);
            }
            if (this.oTI != null) {
                aVar.e(12, this.oTI);
            }
            AppMethodBeat.o(23485);
            return 0;
        } else if (i2 == 1) {
            int nh = this.rCb != null ? g.a.a.a.nh(1, this.rCb.computeSize()) + 0 : 0;
            if (this.rBB != null) {
                nh += g.a.a.b.b.a.b(2, this.rBB);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.rBC) + g.a.a.b.b.a.bu(4, this.rBD) + g.a.a.b.b.a.bu(5, this.rBE);
            if (this.rBF != null) {
                bu += g.a.a.b.b.a.b(6, this.rBF);
            }
            if (this.rBG != null) {
                bu += g.a.a.b.b.a.b(7, this.rBG);
            }
            if (this.rBH != null) {
                bu += g.a.a.b.b.a.f(10, this.rBH);
            }
            if (this.rBI != null) {
                bu += g.a.a.b.b.a.f(11, this.rBI);
            }
            if (this.oTI != null) {
                bu += g.a.a.b.b.a.f(12, this.oTI);
            }
            AppMethodBeat.o(23485);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = i.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = i.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(23485);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        d dVar = new d();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dVar.populateBuilderWithField(aVar5, dVar, i.getNextFieldNumber(aVar5))) {
                        }
                        aVar4.rCb = dVar;
                    }
                    AppMethodBeat.o(23485);
                    return 0;
                case 2:
                    aVar4.rBB = aVar3.UbS.hPo();
                    AppMethodBeat.o(23485);
                    return 0;
                case 3:
                    aVar4.rBC = aVar3.UbS.zi();
                    AppMethodBeat.o(23485);
                    return 0;
                case 4:
                    aVar4.rBD = aVar3.UbS.zi();
                    AppMethodBeat.o(23485);
                    return 0;
                case 5:
                    aVar4.rBE = aVar3.UbS.zi();
                    AppMethodBeat.o(23485);
                    return 0;
                case 6:
                    aVar4.rBF = aVar3.UbS.hPo();
                    AppMethodBeat.o(23485);
                    return 0;
                case 7:
                    aVar4.rBG = aVar3.UbS.hPo();
                    AppMethodBeat.o(23485);
                    return 0;
                case 8:
                case 9:
                default:
                    AppMethodBeat.o(23485);
                    return -1;
                case 10:
                    aVar4.rBH = aVar3.UbS.readString();
                    AppMethodBeat.o(23485);
                    return 0;
                case 11:
                    aVar4.rBI = aVar3.UbS.readString();
                    AppMethodBeat.o(23485);
                    return 0;
                case 12:
                    aVar4.oTI = aVar3.UbS.readString();
                    AppMethodBeat.o(23485);
                    return 0;
            }
        } else {
            AppMethodBeat.o(23485);
            return -1;
        }
    }
}
