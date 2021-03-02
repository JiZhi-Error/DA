package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ege extends a {
    public long MOC;
    public int MOD;
    public efz NfY;
    public LinkedList<String> NfZ = new LinkedList<>();
    public ale Nga;
    public int Ngb;
    public dkp Ngc;
    public String Ngd;
    public String dSJ;
    public String event;
    public long lastUpdateTime;
    public int pos;
    public int style;
    public int weight;

    public ege() {
        AppMethodBeat.i(124563);
        AppMethodBeat.o(124563);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124564);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.NfY != null) {
                aVar.ni(1, this.NfY.computeSize());
                this.NfY.writeFields(aVar);
            }
            aVar.bb(2, this.lastUpdateTime);
            aVar.aM(3, this.pos);
            aVar.aM(4, this.weight);
            aVar.bb(5, this.MOC);
            aVar.e(6, 1, this.NfZ);
            aVar.aM(7, this.style);
            if (this.event != null) {
                aVar.e(8, this.event);
            }
            if (this.Nga != null) {
                aVar.ni(9, this.Nga.computeSize());
                this.Nga.writeFields(aVar);
            }
            aVar.aM(10, this.Ngb);
            if (this.Ngc != null) {
                aVar.ni(11, this.Ngc.computeSize());
                this.Ngc.writeFields(aVar);
            }
            if (this.Ngd != null) {
                aVar.e(12, this.Ngd);
            }
            if (this.dSJ != null) {
                aVar.e(13, this.dSJ);
            }
            aVar.aM(14, this.MOD);
            AppMethodBeat.o(124564);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.NfY != null ? g.a.a.a.nh(1, this.NfY.computeSize()) + 0 : 0) + g.a.a.b.b.a.r(2, this.lastUpdateTime) + g.a.a.b.b.a.bu(3, this.pos) + g.a.a.b.b.a.bu(4, this.weight) + g.a.a.b.b.a.r(5, this.MOC) + g.a.a.a.c(6, 1, this.NfZ) + g.a.a.b.b.a.bu(7, this.style);
            if (this.event != null) {
                nh += g.a.a.b.b.a.f(8, this.event);
            }
            if (this.Nga != null) {
                nh += g.a.a.a.nh(9, this.Nga.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(10, this.Ngb);
            if (this.Ngc != null) {
                bu += g.a.a.a.nh(11, this.Ngc.computeSize());
            }
            if (this.Ngd != null) {
                bu += g.a.a.b.b.a.f(12, this.Ngd);
            }
            if (this.dSJ != null) {
                bu += g.a.a.b.b.a.f(13, this.dSJ);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(14, this.MOD);
            AppMethodBeat.o(124564);
            return bu2;
        } else if (i2 == 2) {
            this.NfZ.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(124564);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ege ege = (ege) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        efz efz = new efz();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = efz.populateBuilderWithField(aVar4, efz, a.getNextFieldNumber(aVar4))) {
                        }
                        ege.NfY = efz;
                    }
                    AppMethodBeat.o(124564);
                    return 0;
                case 2:
                    ege.lastUpdateTime = aVar3.UbS.zl();
                    AppMethodBeat.o(124564);
                    return 0;
                case 3:
                    ege.pos = aVar3.UbS.zi();
                    AppMethodBeat.o(124564);
                    return 0;
                case 4:
                    ege.weight = aVar3.UbS.zi();
                    AppMethodBeat.o(124564);
                    return 0;
                case 5:
                    ege.MOC = aVar3.UbS.zl();
                    AppMethodBeat.o(124564);
                    return 0;
                case 6:
                    ege.NfZ.add(aVar3.UbS.readString());
                    AppMethodBeat.o(124564);
                    return 0;
                case 7:
                    ege.style = aVar3.UbS.zi();
                    AppMethodBeat.o(124564);
                    return 0;
                case 8:
                    ege.event = aVar3.UbS.readString();
                    AppMethodBeat.o(124564);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ale ale = new ale();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ale.populateBuilderWithField(aVar5, ale, a.getNextFieldNumber(aVar5))) {
                        }
                        ege.Nga = ale;
                    }
                    AppMethodBeat.o(124564);
                    return 0;
                case 10:
                    ege.Ngb = aVar3.UbS.zi();
                    AppMethodBeat.o(124564);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dkp dkp = new dkp();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dkp.populateBuilderWithField(aVar6, dkp, a.getNextFieldNumber(aVar6))) {
                        }
                        ege.Ngc = dkp;
                    }
                    AppMethodBeat.o(124564);
                    return 0;
                case 12:
                    ege.Ngd = aVar3.UbS.readString();
                    AppMethodBeat.o(124564);
                    return 0;
                case 13:
                    ege.dSJ = aVar3.UbS.readString();
                    AppMethodBeat.o(124564);
                    return 0;
                case 14:
                    ege.MOD = aVar3.UbS.zi();
                    AppMethodBeat.o(124564);
                    return 0;
                default:
                    AppMethodBeat.o(124564);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124564);
            return -1;
        }
    }
}
