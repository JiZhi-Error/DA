package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class edu extends a {
    public int Mpa;
    public long MsZ;
    public int Mtd;
    public int Nee;
    public eds Nef;
    public String Neg;
    public boolean Neh;
    public LinkedList<String> Nei = new LinkedList<>();
    public int ibG;
    public String izX;
    public String md5;

    public edu() {
        AppMethodBeat.i(201797);
        AppMethodBeat.o(201797);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(118455);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.izX != null) {
                aVar.e(1, this.izX);
            }
            aVar.aM(2, this.ibG);
            aVar.bb(3, this.MsZ);
            aVar.aM(4, this.Mtd);
            if (this.md5 != null) {
                aVar.e(5, this.md5);
            }
            aVar.aM(6, this.Mpa);
            aVar.aM(7, this.Nee);
            if (this.Nef != null) {
                aVar.ni(8, this.Nef.computeSize());
                this.Nef.writeFields(aVar);
            }
            if (this.Neg != null) {
                aVar.e(9, this.Neg);
            }
            aVar.cc(10, this.Neh);
            aVar.e(11, 1, this.Nei);
            AppMethodBeat.o(118455);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.izX != null ? g.a.a.b.b.a.f(1, this.izX) + 0 : 0) + g.a.a.b.b.a.bu(2, this.ibG) + g.a.a.b.b.a.r(3, this.MsZ) + g.a.a.b.b.a.bu(4, this.Mtd);
            if (this.md5 != null) {
                f2 += g.a.a.b.b.a.f(5, this.md5);
            }
            int bu = f2 + g.a.a.b.b.a.bu(6, this.Mpa) + g.a.a.b.b.a.bu(7, this.Nee);
            if (this.Nef != null) {
                bu += g.a.a.a.nh(8, this.Nef.computeSize());
            }
            if (this.Neg != null) {
                bu += g.a.a.b.b.a.f(9, this.Neg);
            }
            int fS = bu + g.a.a.b.b.a.fS(10) + 1 + g.a.a.a.c(11, 1, this.Nei);
            AppMethodBeat.o(118455);
            return fS;
        } else if (i2 == 2) {
            this.Nei.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(118455);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            edu edu = (edu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    edu.izX = aVar3.UbS.readString();
                    AppMethodBeat.o(118455);
                    return 0;
                case 2:
                    edu.ibG = aVar3.UbS.zi();
                    AppMethodBeat.o(118455);
                    return 0;
                case 3:
                    edu.MsZ = aVar3.UbS.zl();
                    AppMethodBeat.o(118455);
                    return 0;
                case 4:
                    edu.Mtd = aVar3.UbS.zi();
                    AppMethodBeat.o(118455);
                    return 0;
                case 5:
                    edu.md5 = aVar3.UbS.readString();
                    AppMethodBeat.o(118455);
                    return 0;
                case 6:
                    edu.Mpa = aVar3.UbS.zi();
                    AppMethodBeat.o(118455);
                    return 0;
                case 7:
                    edu.Nee = aVar3.UbS.zi();
                    AppMethodBeat.o(118455);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        eds eds = new eds();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = eds.populateBuilderWithField(aVar4, eds, a.getNextFieldNumber(aVar4))) {
                        }
                        edu.Nef = eds;
                    }
                    AppMethodBeat.o(118455);
                    return 0;
                case 9:
                    edu.Neg = aVar3.UbS.readString();
                    AppMethodBeat.o(118455);
                    return 0;
                case 10:
                    edu.Neh = aVar3.UbS.yZ();
                    AppMethodBeat.o(118455);
                    return 0;
                case 11:
                    edu.Nei.add(aVar3.UbS.readString());
                    AppMethodBeat.o(118455);
                    return 0;
                default:
                    AppMethodBeat.o(118455);
                    return -1;
            }
        } else {
            AppMethodBeat.o(118455);
            return -1;
        }
    }
}
