package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cja extends a {
    public String MnU;
    public String MnV;
    public int MnW;
    public int MnX;
    public long MnY;
    public long MnZ;
    public LinkedList<vh> Moa = new LinkedList<>();
    public int Mob;
    public LinkedList<String> Moc = new LinkedList<>();
    public String Mod;
    public int Moe;
    public int Mof;
    public int Mog;
    public int Moh;
    public int Moi;
    public int VjO;

    public cja() {
        AppMethodBeat.i(196380);
        AppMethodBeat.o(196380);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(196381);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MnU != null) {
                aVar.e(1, this.MnU);
            }
            if (this.MnV != null) {
                aVar.e(2, this.MnV);
            }
            aVar.aM(3, this.MnW);
            aVar.aM(4, this.MnX);
            aVar.bb(5, this.MnY);
            aVar.bb(6, this.MnZ);
            aVar.e(7, 8, this.Moa);
            aVar.aM(8, this.Mob);
            aVar.e(9, 1, this.Moc);
            if (this.Mod != null) {
                aVar.e(10, this.Mod);
            }
            aVar.aM(11, this.Moe);
            aVar.aM(12, this.Mof);
            aVar.aM(13, this.Mog);
            aVar.aM(14, this.Moh);
            aVar.aM(15, this.Moi);
            aVar.aM(16, this.VjO);
            AppMethodBeat.o(196381);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.MnU != null ? g.a.a.b.b.a.f(1, this.MnU) + 0 : 0;
            if (this.MnV != null) {
                f2 += g.a.a.b.b.a.f(2, this.MnV);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.MnW) + g.a.a.b.b.a.bu(4, this.MnX) + g.a.a.b.b.a.r(5, this.MnY) + g.a.a.b.b.a.r(6, this.MnZ) + g.a.a.a.c(7, 8, this.Moa) + g.a.a.b.b.a.bu(8, this.Mob) + g.a.a.a.c(9, 1, this.Moc);
            if (this.Mod != null) {
                bu += g.a.a.b.b.a.f(10, this.Mod);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(11, this.Moe) + g.a.a.b.b.a.bu(12, this.Mof) + g.a.a.b.b.a.bu(13, this.Mog) + g.a.a.b.b.a.bu(14, this.Moh) + g.a.a.b.b.a.bu(15, this.Moi) + g.a.a.b.b.a.bu(16, this.VjO);
            AppMethodBeat.o(196381);
            return bu2;
        } else if (i2 == 2) {
            this.Moa.clear();
            this.Moc.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(196381);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cja cja = (cja) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cja.MnU = aVar3.UbS.readString();
                    AppMethodBeat.o(196381);
                    return 0;
                case 2:
                    cja.MnV = aVar3.UbS.readString();
                    AppMethodBeat.o(196381);
                    return 0;
                case 3:
                    cja.MnW = aVar3.UbS.zi();
                    AppMethodBeat.o(196381);
                    return 0;
                case 4:
                    cja.MnX = aVar3.UbS.zi();
                    AppMethodBeat.o(196381);
                    return 0;
                case 5:
                    cja.MnY = aVar3.UbS.zl();
                    AppMethodBeat.o(196381);
                    return 0;
                case 6:
                    cja.MnZ = aVar3.UbS.zl();
                    AppMethodBeat.o(196381);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        vh vhVar = new vh();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = vhVar.populateBuilderWithField(aVar4, vhVar, a.getNextFieldNumber(aVar4))) {
                        }
                        cja.Moa.add(vhVar);
                    }
                    AppMethodBeat.o(196381);
                    return 0;
                case 8:
                    cja.Mob = aVar3.UbS.zi();
                    AppMethodBeat.o(196381);
                    return 0;
                case 9:
                    cja.Moc.add(aVar3.UbS.readString());
                    AppMethodBeat.o(196381);
                    return 0;
                case 10:
                    cja.Mod = aVar3.UbS.readString();
                    AppMethodBeat.o(196381);
                    return 0;
                case 11:
                    cja.Moe = aVar3.UbS.zi();
                    AppMethodBeat.o(196381);
                    return 0;
                case 12:
                    cja.Mof = aVar3.UbS.zi();
                    AppMethodBeat.o(196381);
                    return 0;
                case 13:
                    cja.Mog = aVar3.UbS.zi();
                    AppMethodBeat.o(196381);
                    return 0;
                case 14:
                    cja.Moh = aVar3.UbS.zi();
                    AppMethodBeat.o(196381);
                    return 0;
                case 15:
                    cja.Moi = aVar3.UbS.zi();
                    AppMethodBeat.o(196381);
                    return 0;
                case 16:
                    cja.VjO = aVar3.UbS.zi();
                    AppMethodBeat.o(196381);
                    return 0;
                default:
                    AppMethodBeat.o(196381);
                    return -1;
            }
        } else {
            AppMethodBeat.o(196381);
            return -1;
        }
    }
}
