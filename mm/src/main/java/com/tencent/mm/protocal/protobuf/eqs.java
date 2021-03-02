package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public class eqs extends a {
    public String MVS;
    public int Noa;
    public String Nob;
    public String Noc;
    public int Nod;
    public String Noe;
    public int Nof;
    public int Nog;
    public String Noh;
    public int Noi;
    public String Noj;
    public int Nok;
    public String Nol;
    public int Nom;
    public String Non;
    public String dNI;
    public String extInfo;
    public int gTn;
    public String iwv;
    public String title;
    public int version;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(176157);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.dNI != null) {
                aVar.e(2, this.dNI);
            }
            aVar.aM(3, this.version);
            if (this.iwv != null) {
                aVar.e(4, this.iwv);
            }
            aVar.aM(5, this.Noa);
            if (this.Nob != null) {
                aVar.e(6, this.Nob);
            }
            if (this.Noc != null) {
                aVar.e(7, this.Noc);
            }
            aVar.aM(8, this.Nod);
            if (this.Noe != null) {
                aVar.e(9, this.Noe);
            }
            aVar.aM(10, this.gTn);
            aVar.aM(11, this.Nof);
            aVar.aM(12, this.Nog);
            if (this.Noh != null) {
                aVar.e(13, this.Noh);
            }
            if (this.MVS != null) {
                aVar.e(14, this.MVS);
            }
            aVar.aM(15, this.Noi);
            if (this.Noj != null) {
                aVar.e(16, this.Noj);
            }
            aVar.aM(17, this.Nok);
            if (this.Nol != null) {
                aVar.e(18, this.Nol);
            }
            aVar.aM(19, this.Nom);
            if (this.extInfo != null) {
                aVar.e(20, this.extInfo);
            }
            if (this.Non != null) {
                aVar.e(21, this.Non);
            }
            AppMethodBeat.o(176157);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.title != null ? g.a.a.b.b.a.f(1, this.title) + 0 : 0;
            if (this.dNI != null) {
                f2 += g.a.a.b.b.a.f(2, this.dNI);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.version);
            if (this.iwv != null) {
                bu += g.a.a.b.b.a.f(4, this.iwv);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(5, this.Noa);
            if (this.Nob != null) {
                bu2 += g.a.a.b.b.a.f(6, this.Nob);
            }
            if (this.Noc != null) {
                bu2 += g.a.a.b.b.a.f(7, this.Noc);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(8, this.Nod);
            if (this.Noe != null) {
                bu3 += g.a.a.b.b.a.f(9, this.Noe);
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(10, this.gTn) + g.a.a.b.b.a.bu(11, this.Nof) + g.a.a.b.b.a.bu(12, this.Nog);
            if (this.Noh != null) {
                bu4 += g.a.a.b.b.a.f(13, this.Noh);
            }
            if (this.MVS != null) {
                bu4 += g.a.a.b.b.a.f(14, this.MVS);
            }
            int bu5 = bu4 + g.a.a.b.b.a.bu(15, this.Noi);
            if (this.Noj != null) {
                bu5 += g.a.a.b.b.a.f(16, this.Noj);
            }
            int bu6 = bu5 + g.a.a.b.b.a.bu(17, this.Nok);
            if (this.Nol != null) {
                bu6 += g.a.a.b.b.a.f(18, this.Nol);
            }
            int bu7 = bu6 + g.a.a.b.b.a.bu(19, this.Nom);
            if (this.extInfo != null) {
                bu7 += g.a.a.b.b.a.f(20, this.extInfo);
            }
            if (this.Non != null) {
                bu7 += g.a.a.b.b.a.f(21, this.Non);
            }
            AppMethodBeat.o(176157);
            return bu7;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(176157);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eqs eqs = (eqs) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eqs.title = aVar3.UbS.readString();
                    AppMethodBeat.o(176157);
                    return 0;
                case 2:
                    eqs.dNI = aVar3.UbS.readString();
                    AppMethodBeat.o(176157);
                    return 0;
                case 3:
                    eqs.version = aVar3.UbS.zi();
                    AppMethodBeat.o(176157);
                    return 0;
                case 4:
                    eqs.iwv = aVar3.UbS.readString();
                    AppMethodBeat.o(176157);
                    return 0;
                case 5:
                    eqs.Noa = aVar3.UbS.zi();
                    AppMethodBeat.o(176157);
                    return 0;
                case 6:
                    eqs.Nob = aVar3.UbS.readString();
                    AppMethodBeat.o(176157);
                    return 0;
                case 7:
                    eqs.Noc = aVar3.UbS.readString();
                    AppMethodBeat.o(176157);
                    return 0;
                case 8:
                    eqs.Nod = aVar3.UbS.zi();
                    AppMethodBeat.o(176157);
                    return 0;
                case 9:
                    eqs.Noe = aVar3.UbS.readString();
                    AppMethodBeat.o(176157);
                    return 0;
                case 10:
                    eqs.gTn = aVar3.UbS.zi();
                    AppMethodBeat.o(176157);
                    return 0;
                case 11:
                    eqs.Nof = aVar3.UbS.zi();
                    AppMethodBeat.o(176157);
                    return 0;
                case 12:
                    eqs.Nog = aVar3.UbS.zi();
                    AppMethodBeat.o(176157);
                    return 0;
                case 13:
                    eqs.Noh = aVar3.UbS.readString();
                    AppMethodBeat.o(176157);
                    return 0;
                case 14:
                    eqs.MVS = aVar3.UbS.readString();
                    AppMethodBeat.o(176157);
                    return 0;
                case 15:
                    eqs.Noi = aVar3.UbS.zi();
                    AppMethodBeat.o(176157);
                    return 0;
                case 16:
                    eqs.Noj = aVar3.UbS.readString();
                    AppMethodBeat.o(176157);
                    return 0;
                case 17:
                    eqs.Nok = aVar3.UbS.zi();
                    AppMethodBeat.o(176157);
                    return 0;
                case 18:
                    eqs.Nol = aVar3.UbS.readString();
                    AppMethodBeat.o(176157);
                    return 0;
                case 19:
                    eqs.Nom = aVar3.UbS.zi();
                    AppMethodBeat.o(176157);
                    return 0;
                case 20:
                    eqs.extInfo = aVar3.UbS.readString();
                    AppMethodBeat.o(176157);
                    return 0;
                case 21:
                    eqs.Non = aVar3.UbS.readString();
                    AppMethodBeat.o(176157);
                    return 0;
                default:
                    AppMethodBeat.o(176157);
                    return -1;
            }
        } else {
            AppMethodBeat.o(176157);
            return -1;
        }
    }
}
