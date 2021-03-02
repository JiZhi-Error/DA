package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class efc extends a {
    public String KSV;
    public LinkedList<cgj> KZi = new LinkedList<>();
    public String Mqy;
    public int NeU;
    public int NeV;
    public int NeW;
    public int NeX;
    public int NeY;
    public int NeZ;
    public int Nfa;
    public String Nfb;
    public String Nfc;
    public int Nfd;
    public String Title;

    public efc() {
        AppMethodBeat.i(152702);
        AppMethodBeat.o(152702);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152703);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Mqy != null) {
                aVar.e(1, this.Mqy);
            }
            aVar.aM(2, this.NeU);
            aVar.aM(3, this.NeV);
            aVar.aM(4, this.NeW);
            aVar.aM(5, this.NeX);
            if (this.Title != null) {
                aVar.e(6, this.Title);
            }
            aVar.e(7, 8, this.KZi);
            aVar.aM(8, this.NeY);
            if (this.KSV != null) {
                aVar.e(9, this.KSV);
            }
            aVar.aM(10, this.NeZ);
            aVar.aM(11, this.Nfa);
            if (this.Nfb != null) {
                aVar.e(12, this.Nfb);
            }
            if (this.Nfc != null) {
                aVar.e(13, this.Nfc);
            }
            aVar.aM(14, this.Nfd);
            AppMethodBeat.o(152703);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.Mqy != null ? g.a.a.b.b.a.f(1, this.Mqy) + 0 : 0) + g.a.a.b.b.a.bu(2, this.NeU) + g.a.a.b.b.a.bu(3, this.NeV) + g.a.a.b.b.a.bu(4, this.NeW) + g.a.a.b.b.a.bu(5, this.NeX);
            if (this.Title != null) {
                f2 += g.a.a.b.b.a.f(6, this.Title);
            }
            int c2 = f2 + g.a.a.a.c(7, 8, this.KZi) + g.a.a.b.b.a.bu(8, this.NeY);
            if (this.KSV != null) {
                c2 += g.a.a.b.b.a.f(9, this.KSV);
            }
            int bu = c2 + g.a.a.b.b.a.bu(10, this.NeZ) + g.a.a.b.b.a.bu(11, this.Nfa);
            if (this.Nfb != null) {
                bu += g.a.a.b.b.a.f(12, this.Nfb);
            }
            if (this.Nfc != null) {
                bu += g.a.a.b.b.a.f(13, this.Nfc);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(14, this.Nfd);
            AppMethodBeat.o(152703);
            return bu2;
        } else if (i2 == 2) {
            this.KZi.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152703);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            efc efc = (efc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    efc.Mqy = aVar3.UbS.readString();
                    AppMethodBeat.o(152703);
                    return 0;
                case 2:
                    efc.NeU = aVar3.UbS.zi();
                    AppMethodBeat.o(152703);
                    return 0;
                case 3:
                    efc.NeV = aVar3.UbS.zi();
                    AppMethodBeat.o(152703);
                    return 0;
                case 4:
                    efc.NeW = aVar3.UbS.zi();
                    AppMethodBeat.o(152703);
                    return 0;
                case 5:
                    efc.NeX = aVar3.UbS.zi();
                    AppMethodBeat.o(152703);
                    return 0;
                case 6:
                    efc.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(152703);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cgj cgj = new cgj();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cgj.populateBuilderWithField(aVar4, cgj, a.getNextFieldNumber(aVar4))) {
                        }
                        efc.KZi.add(cgj);
                    }
                    AppMethodBeat.o(152703);
                    return 0;
                case 8:
                    efc.NeY = aVar3.UbS.zi();
                    AppMethodBeat.o(152703);
                    return 0;
                case 9:
                    efc.KSV = aVar3.UbS.readString();
                    AppMethodBeat.o(152703);
                    return 0;
                case 10:
                    efc.NeZ = aVar3.UbS.zi();
                    AppMethodBeat.o(152703);
                    return 0;
                case 11:
                    efc.Nfa = aVar3.UbS.zi();
                    AppMethodBeat.o(152703);
                    return 0;
                case 12:
                    efc.Nfb = aVar3.UbS.readString();
                    AppMethodBeat.o(152703);
                    return 0;
                case 13:
                    efc.Nfc = aVar3.UbS.readString();
                    AppMethodBeat.o(152703);
                    return 0;
                case 14:
                    efc.Nfd = aVar3.UbS.zi();
                    AppMethodBeat.o(152703);
                    return 0;
                default:
                    AppMethodBeat.o(152703);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152703);
            return -1;
        }
    }
}
