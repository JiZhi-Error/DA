package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class faf extends dop {
    public String Ntl;
    public String Nwa;
    public int Nwb;
    public int Nwc;
    public String Nwd;
    public int Nwe;
    public String Nwf;
    public String Nwg;
    public String dNI;
    public String dOL;
    public String pDH;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(82489);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.dOL != null) {
                aVar.e(2, this.dOL);
            }
            if (this.Nwa != null) {
                aVar.e(3, this.Nwa);
            }
            aVar.aM(4, this.Nwb);
            aVar.aM(5, this.Nwc);
            if (this.Ntl != null) {
                aVar.e(6, this.Ntl);
            }
            if (this.pDH != null) {
                aVar.e(7, this.pDH);
            }
            if (this.dNI != null) {
                aVar.e(8, this.dNI);
            }
            if (this.Nwd != null) {
                aVar.e(9, this.Nwd);
            }
            aVar.aM(10, this.Nwe);
            if (this.Nwf != null) {
                aVar.e(11, this.Nwf);
            }
            if (this.Nwg != null) {
                aVar.e(12, this.Nwg);
            }
            AppMethodBeat.o(82489);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.dOL != null) {
                nh += g.a.a.b.b.a.f(2, this.dOL);
            }
            if (this.Nwa != null) {
                nh += g.a.a.b.b.a.f(3, this.Nwa);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.Nwb) + g.a.a.b.b.a.bu(5, this.Nwc);
            if (this.Ntl != null) {
                bu += g.a.a.b.b.a.f(6, this.Ntl);
            }
            if (this.pDH != null) {
                bu += g.a.a.b.b.a.f(7, this.pDH);
            }
            if (this.dNI != null) {
                bu += g.a.a.b.b.a.f(8, this.dNI);
            }
            if (this.Nwd != null) {
                bu += g.a.a.b.b.a.f(9, this.Nwd);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(10, this.Nwe);
            if (this.Nwf != null) {
                bu2 += g.a.a.b.b.a.f(11, this.Nwf);
            }
            if (this.Nwg != null) {
                bu2 += g.a.a.b.b.a.f(12, this.Nwg);
            }
            AppMethodBeat.o(82489);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(82489);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            faf faf = (faf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        jr jrVar = new jr();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = jrVar.populateBuilderWithField(aVar4, jrVar, dop.getNextFieldNumber(aVar4))) {
                        }
                        faf.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(82489);
                    return 0;
                case 2:
                    faf.dOL = aVar3.UbS.readString();
                    AppMethodBeat.o(82489);
                    return 0;
                case 3:
                    faf.Nwa = aVar3.UbS.readString();
                    AppMethodBeat.o(82489);
                    return 0;
                case 4:
                    faf.Nwb = aVar3.UbS.zi();
                    AppMethodBeat.o(82489);
                    return 0;
                case 5:
                    faf.Nwc = aVar3.UbS.zi();
                    AppMethodBeat.o(82489);
                    return 0;
                case 6:
                    faf.Ntl = aVar3.UbS.readString();
                    AppMethodBeat.o(82489);
                    return 0;
                case 7:
                    faf.pDH = aVar3.UbS.readString();
                    AppMethodBeat.o(82489);
                    return 0;
                case 8:
                    faf.dNI = aVar3.UbS.readString();
                    AppMethodBeat.o(82489);
                    return 0;
                case 9:
                    faf.Nwd = aVar3.UbS.readString();
                    AppMethodBeat.o(82489);
                    return 0;
                case 10:
                    faf.Nwe = aVar3.UbS.zi();
                    AppMethodBeat.o(82489);
                    return 0;
                case 11:
                    faf.Nwf = aVar3.UbS.readString();
                    AppMethodBeat.o(82489);
                    return 0;
                case 12:
                    faf.Nwg = aVar3.UbS.readString();
                    AppMethodBeat.o(82489);
                    return 0;
                default:
                    AppMethodBeat.o(82489);
                    return -1;
            }
        } else {
            AppMethodBeat.o(82489);
            return -1;
        }
    }
}
