package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class etz extends a {
    public int Nrd;
    public int Nre;
    public int Nrf;
    public int Nrg;
    public int Nrh;
    public int Nri;
    public int Nrj;
    public int Nrk;
    public int Nrl;
    public int Nrm;
    public LinkedList<Integer> Nrn = new LinkedList<>();
    public int Nro;
    public LinkedList<Integer> Nrp = new LinkedList<>();
    public int Nrq;
    public LinkedList<Integer> Nrr = new LinkedList<>();
    public String Nrs;
    public String Nrt;

    public etz() {
        AppMethodBeat.i(115892);
        AppMethodBeat.o(115892);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(115893);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.Nrd);
            aVar.aM(2, this.Nre);
            aVar.aM(3, this.Nrf);
            aVar.aM(4, this.Nrg);
            aVar.aM(5, this.Nrh);
            aVar.aM(6, this.Nri);
            aVar.aM(7, this.Nrj);
            aVar.aM(8, this.Nrk);
            aVar.aM(9, this.Nrl);
            aVar.aM(10, this.Nrm);
            aVar.e(11, 2, this.Nrn);
            aVar.aM(12, this.Nro);
            aVar.e(13, 2, this.Nrp);
            aVar.aM(14, this.Nrq);
            aVar.e(15, 2, this.Nrr);
            if (this.Nrs != null) {
                aVar.e(16, this.Nrs);
            }
            if (this.Nrt != null) {
                aVar.e(17, this.Nrt);
            }
            AppMethodBeat.o(115893);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Nrd) + 0 + g.a.a.b.b.a.bu(2, this.Nre) + g.a.a.b.b.a.bu(3, this.Nrf) + g.a.a.b.b.a.bu(4, this.Nrg) + g.a.a.b.b.a.bu(5, this.Nrh) + g.a.a.b.b.a.bu(6, this.Nri) + g.a.a.b.b.a.bu(7, this.Nrj) + g.a.a.b.b.a.bu(8, this.Nrk) + g.a.a.b.b.a.bu(9, this.Nrl) + g.a.a.b.b.a.bu(10, this.Nrm) + g.a.a.a.c(11, 2, this.Nrn) + g.a.a.b.b.a.bu(12, this.Nro) + g.a.a.a.c(13, 2, this.Nrp) + g.a.a.b.b.a.bu(14, this.Nrq) + g.a.a.a.c(15, 2, this.Nrr);
            if (this.Nrs != null) {
                bu += g.a.a.b.b.a.f(16, this.Nrs);
            }
            if (this.Nrt != null) {
                bu += g.a.a.b.b.a.f(17, this.Nrt);
            }
            AppMethodBeat.o(115893);
            return bu;
        } else if (i2 == 2) {
            this.Nrn.clear();
            this.Nrp.clear();
            this.Nrr.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(115893);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            etz etz = (etz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    etz.Nrd = aVar3.UbS.zi();
                    AppMethodBeat.o(115893);
                    return 0;
                case 2:
                    etz.Nre = aVar3.UbS.zi();
                    AppMethodBeat.o(115893);
                    return 0;
                case 3:
                    etz.Nrf = aVar3.UbS.zi();
                    AppMethodBeat.o(115893);
                    return 0;
                case 4:
                    etz.Nrg = aVar3.UbS.zi();
                    AppMethodBeat.o(115893);
                    return 0;
                case 5:
                    etz.Nrh = aVar3.UbS.zi();
                    AppMethodBeat.o(115893);
                    return 0;
                case 6:
                    etz.Nri = aVar3.UbS.zi();
                    AppMethodBeat.o(115893);
                    return 0;
                case 7:
                    etz.Nrj = aVar3.UbS.zi();
                    AppMethodBeat.o(115893);
                    return 0;
                case 8:
                    etz.Nrk = aVar3.UbS.zi();
                    AppMethodBeat.o(115893);
                    return 0;
                case 9:
                    etz.Nrl = aVar3.UbS.zi();
                    AppMethodBeat.o(115893);
                    return 0;
                case 10:
                    etz.Nrm = aVar3.UbS.zi();
                    AppMethodBeat.o(115893);
                    return 0;
                case 11:
                    etz.Nrn.add(Integer.valueOf(aVar3.UbS.zi()));
                    AppMethodBeat.o(115893);
                    return 0;
                case 12:
                    etz.Nro = aVar3.UbS.zi();
                    AppMethodBeat.o(115893);
                    return 0;
                case 13:
                    etz.Nrp.add(Integer.valueOf(aVar3.UbS.zi()));
                    AppMethodBeat.o(115893);
                    return 0;
                case 14:
                    etz.Nrq = aVar3.UbS.zi();
                    AppMethodBeat.o(115893);
                    return 0;
                case 15:
                    etz.Nrr.add(Integer.valueOf(aVar3.UbS.zi()));
                    AppMethodBeat.o(115893);
                    return 0;
                case 16:
                    etz.Nrs = aVar3.UbS.readString();
                    AppMethodBeat.o(115893);
                    return 0;
                case 17:
                    etz.Nrt = aVar3.UbS.readString();
                    AppMethodBeat.o(115893);
                    return 0;
                default:
                    AppMethodBeat.o(115893);
                    return -1;
            }
        } else {
            AppMethodBeat.o(115893);
            return -1;
        }
    }
}
