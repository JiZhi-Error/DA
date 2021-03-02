package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dml extends a {
    public int LqX;
    public String LqY;
    public String LqZ;
    public int Lra;
    public int Lrb;
    public int Lrc;
    public int Lrg;
    public int Lrh;
    public esr MPX;
    public esr MPY;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(115848);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.LqX);
            if (this.LqY != null) {
                aVar.e(2, this.LqY);
            }
            if (this.LqZ != null) {
                aVar.e(3, this.LqZ);
            }
            aVar.aM(4, this.Lra);
            aVar.aM(5, this.Lrb);
            aVar.aM(6, this.Lrc);
            if (this.MPX != null) {
                aVar.ni(7, this.MPX.computeSize());
                this.MPX.writeFields(aVar);
            }
            if (this.MPY != null) {
                aVar.ni(8, this.MPY.computeSize());
                this.MPY.writeFields(aVar);
            }
            aVar.aM(9, this.Lrg);
            aVar.aM(10, this.Lrh);
            AppMethodBeat.o(115848);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.LqX) + 0;
            if (this.LqY != null) {
                bu += g.a.a.b.b.a.f(2, this.LqY);
            }
            if (this.LqZ != null) {
                bu += g.a.a.b.b.a.f(3, this.LqZ);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(4, this.Lra) + g.a.a.b.b.a.bu(5, this.Lrb) + g.a.a.b.b.a.bu(6, this.Lrc);
            if (this.MPX != null) {
                bu2 += g.a.a.a.nh(7, this.MPX.computeSize());
            }
            if (this.MPY != null) {
                bu2 += g.a.a.a.nh(8, this.MPY.computeSize());
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(9, this.Lrg) + g.a.a.b.b.a.bu(10, this.Lrh);
            AppMethodBeat.o(115848);
            return bu3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(115848);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dml dml = (dml) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dml.LqX = aVar3.UbS.zi();
                    AppMethodBeat.o(115848);
                    return 0;
                case 2:
                    dml.LqY = aVar3.UbS.readString();
                    AppMethodBeat.o(115848);
                    return 0;
                case 3:
                    dml.LqZ = aVar3.UbS.readString();
                    AppMethodBeat.o(115848);
                    return 0;
                case 4:
                    dml.Lra = aVar3.UbS.zi();
                    AppMethodBeat.o(115848);
                    return 0;
                case 5:
                    dml.Lrb = aVar3.UbS.zi();
                    AppMethodBeat.o(115848);
                    return 0;
                case 6:
                    dml.Lrc = aVar3.UbS.zi();
                    AppMethodBeat.o(115848);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        esr esr = new esr();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = esr.populateBuilderWithField(aVar4, esr, a.getNextFieldNumber(aVar4))) {
                        }
                        dml.MPX = esr;
                    }
                    AppMethodBeat.o(115848);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        esr esr2 = new esr();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = esr2.populateBuilderWithField(aVar5, esr2, a.getNextFieldNumber(aVar5))) {
                        }
                        dml.MPY = esr2;
                    }
                    AppMethodBeat.o(115848);
                    return 0;
                case 9:
                    dml.Lrg = aVar3.UbS.zi();
                    AppMethodBeat.o(115848);
                    return 0;
                case 10:
                    dml.Lrh = aVar3.UbS.zi();
                    AppMethodBeat.o(115848);
                    return 0;
                default:
                    AppMethodBeat.o(115848);
                    return -1;
            }
        } else {
            AppMethodBeat.o(115848);
            return -1;
        }
    }
}
