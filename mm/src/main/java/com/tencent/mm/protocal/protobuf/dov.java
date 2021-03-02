package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class dov extends a {
    public int JZb;
    public int LWr;
    public int Lbj;
    public int MJT;
    public doy MSk;
    public dox MSl;
    public int MSm;
    public String MSn;
    public int MSo;
    public int MSp;
    public int MSq;
    public int MhZ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152668);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MSn == null) {
                b bVar = new b("Not all required fields were included: SampleId");
                AppMethodBeat.o(152668);
                throw bVar;
            }
            aVar.aM(1, this.MJT);
            if (this.MSk != null) {
                aVar.ni(2, this.MSk.computeSize());
                this.MSk.writeFields(aVar);
            }
            if (this.MSl != null) {
                aVar.ni(3, this.MSl.computeSize());
                this.MSl.writeFields(aVar);
            }
            aVar.aM(4, this.LWr);
            aVar.aM(5, this.MSm);
            if (this.MSn != null) {
                aVar.e(6, this.MSn);
            }
            aVar.aM(7, this.Lbj);
            aVar.aM(8, this.MSo);
            aVar.aM(9, this.JZb);
            aVar.aM(10, this.MSp);
            aVar.aM(11, this.MSq);
            aVar.aM(12, this.MhZ);
            AppMethodBeat.o(152668);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.MJT) + 0;
            if (this.MSk != null) {
                bu += g.a.a.a.nh(2, this.MSk.computeSize());
            }
            if (this.MSl != null) {
                bu += g.a.a.a.nh(3, this.MSl.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(4, this.LWr) + g.a.a.b.b.a.bu(5, this.MSm);
            if (this.MSn != null) {
                bu2 += g.a.a.b.b.a.f(6, this.MSn);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(7, this.Lbj) + g.a.a.b.b.a.bu(8, this.MSo) + g.a.a.b.b.a.bu(9, this.JZb) + g.a.a.b.b.a.bu(10, this.MSp) + g.a.a.b.b.a.bu(11, this.MSq) + g.a.a.b.b.a.bu(12, this.MhZ);
            AppMethodBeat.o(152668);
            return bu3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.MSn == null) {
                b bVar2 = new b("Not all required fields were included: SampleId");
                AppMethodBeat.o(152668);
                throw bVar2;
            }
            AppMethodBeat.o(152668);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dov dov = (dov) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dov.MJT = aVar3.UbS.zi();
                    AppMethodBeat.o(152668);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        doy doy = new doy();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = doy.populateBuilderWithField(aVar4, doy, a.getNextFieldNumber(aVar4))) {
                        }
                        dov.MSk = doy;
                    }
                    AppMethodBeat.o(152668);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dox dox = new dox();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dox.populateBuilderWithField(aVar5, dox, a.getNextFieldNumber(aVar5))) {
                        }
                        dov.MSl = dox;
                    }
                    AppMethodBeat.o(152668);
                    return 0;
                case 4:
                    dov.LWr = aVar3.UbS.zi();
                    AppMethodBeat.o(152668);
                    return 0;
                case 5:
                    dov.MSm = aVar3.UbS.zi();
                    AppMethodBeat.o(152668);
                    return 0;
                case 6:
                    dov.MSn = aVar3.UbS.readString();
                    AppMethodBeat.o(152668);
                    return 0;
                case 7:
                    dov.Lbj = aVar3.UbS.zi();
                    AppMethodBeat.o(152668);
                    return 0;
                case 8:
                    dov.MSo = aVar3.UbS.zi();
                    AppMethodBeat.o(152668);
                    return 0;
                case 9:
                    dov.JZb = aVar3.UbS.zi();
                    AppMethodBeat.o(152668);
                    return 0;
                case 10:
                    dov.MSp = aVar3.UbS.zi();
                    AppMethodBeat.o(152668);
                    return 0;
                case 11:
                    dov.MSq = aVar3.UbS.zi();
                    AppMethodBeat.o(152668);
                    return 0;
                case 12:
                    dov.MhZ = aVar3.UbS.zi();
                    AppMethodBeat.o(152668);
                    return 0;
                default:
                    AppMethodBeat.o(152668);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152668);
            return -1;
        }
    }
}
