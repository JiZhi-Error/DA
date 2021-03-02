package com.tencent.mm.plugin.textstatus.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class g extends a {
    public String GaA;
    public long GaB;
    public String GaC;
    public int Gat;
    public w Gau;
    public String Gav;
    public String Gaw;
    public String Gax;
    public String Gay;
    public int Gaz;
    public String description;
    public String iUX;
    public double latitude;
    public double longitude;
    public int pRN;
    public int visibility;
    public int zGN;
    public int zGO;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(222825);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, this.longitude);
            aVar.e(2, this.latitude);
            aVar.aM(3, this.Gat);
            if (this.Gau != null) {
                aVar.ni(4, this.Gau.computeSize());
                this.Gau.writeFields(aVar);
            }
            if (this.Gav != null) {
                aVar.e(5, this.Gav);
            }
            if (this.Gaw != null) {
                aVar.e(6, this.Gaw);
            }
            if (this.Gax != null) {
                aVar.e(7, this.Gax);
            }
            if (this.Gay != null) {
                aVar.e(8, this.Gay);
            }
            aVar.aM(9, this.visibility);
            if (this.description != null) {
                aVar.e(10, this.description);
            }
            aVar.aM(11, this.Gaz);
            aVar.aM(12, this.pRN);
            if (this.GaA != null) {
                aVar.e(13, this.GaA);
            }
            if (this.iUX != null) {
                aVar.e(14, this.iUX);
            }
            aVar.bb(15, this.GaB);
            aVar.aM(16, this.zGN);
            aVar.aM(17, this.zGO);
            if (this.GaC != null) {
                aVar.e(18, this.GaC);
            }
            AppMethodBeat.o(222825);
            return 0;
        } else if (i2 == 1) {
            int fS = g.a.a.b.b.a.fS(1) + 8 + 0 + g.a.a.b.b.a.fS(2) + 8 + g.a.a.b.b.a.bu(3, this.Gat);
            if (this.Gau != null) {
                fS += g.a.a.a.nh(4, this.Gau.computeSize());
            }
            if (this.Gav != null) {
                fS += g.a.a.b.b.a.f(5, this.Gav);
            }
            if (this.Gaw != null) {
                fS += g.a.a.b.b.a.f(6, this.Gaw);
            }
            if (this.Gax != null) {
                fS += g.a.a.b.b.a.f(7, this.Gax);
            }
            if (this.Gay != null) {
                fS += g.a.a.b.b.a.f(8, this.Gay);
            }
            int bu = fS + g.a.a.b.b.a.bu(9, this.visibility);
            if (this.description != null) {
                bu += g.a.a.b.b.a.f(10, this.description);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(11, this.Gaz) + g.a.a.b.b.a.bu(12, this.pRN);
            if (this.GaA != null) {
                bu2 += g.a.a.b.b.a.f(13, this.GaA);
            }
            if (this.iUX != null) {
                bu2 += g.a.a.b.b.a.f(14, this.iUX);
            }
            int r = bu2 + g.a.a.b.b.a.r(15, this.GaB) + g.a.a.b.b.a.bu(16, this.zGN) + g.a.a.b.b.a.bu(17, this.zGO);
            if (this.GaC != null) {
                r += g.a.a.b.b.a.f(18, this.GaC);
            }
            AppMethodBeat.o(222825);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(222825);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            g gVar = (g) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    gVar.longitude = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(222825);
                    return 0;
                case 2:
                    gVar.latitude = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(222825);
                    return 0;
                case 3:
                    gVar.Gat = aVar3.UbS.zi();
                    AppMethodBeat.o(222825);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        w wVar = new w();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = wVar.populateBuilderWithField(aVar4, wVar, a.getNextFieldNumber(aVar4))) {
                        }
                        gVar.Gau = wVar;
                    }
                    AppMethodBeat.o(222825);
                    return 0;
                case 5:
                    gVar.Gav = aVar3.UbS.readString();
                    AppMethodBeat.o(222825);
                    return 0;
                case 6:
                    gVar.Gaw = aVar3.UbS.readString();
                    AppMethodBeat.o(222825);
                    return 0;
                case 7:
                    gVar.Gax = aVar3.UbS.readString();
                    AppMethodBeat.o(222825);
                    return 0;
                case 8:
                    gVar.Gay = aVar3.UbS.readString();
                    AppMethodBeat.o(222825);
                    return 0;
                case 9:
                    gVar.visibility = aVar3.UbS.zi();
                    AppMethodBeat.o(222825);
                    return 0;
                case 10:
                    gVar.description = aVar3.UbS.readString();
                    AppMethodBeat.o(222825);
                    return 0;
                case 11:
                    gVar.Gaz = aVar3.UbS.zi();
                    AppMethodBeat.o(222825);
                    return 0;
                case 12:
                    gVar.pRN = aVar3.UbS.zi();
                    AppMethodBeat.o(222825);
                    return 0;
                case 13:
                    gVar.GaA = aVar3.UbS.readString();
                    AppMethodBeat.o(222825);
                    return 0;
                case 14:
                    gVar.iUX = aVar3.UbS.readString();
                    AppMethodBeat.o(222825);
                    return 0;
                case 15:
                    gVar.GaB = aVar3.UbS.zl();
                    AppMethodBeat.o(222825);
                    return 0;
                case 16:
                    gVar.zGN = aVar3.UbS.zi();
                    AppMethodBeat.o(222825);
                    return 0;
                case 17:
                    gVar.zGO = aVar3.UbS.zi();
                    AppMethodBeat.o(222825);
                    return 0;
                case 18:
                    gVar.GaC = aVar3.UbS.readString();
                    AppMethodBeat.o(222825);
                    return 0;
                default:
                    AppMethodBeat.o(222825);
                    return -1;
            }
        } else {
            AppMethodBeat.o(222825);
            return -1;
        }
    }
}
