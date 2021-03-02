package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class eom extends a {
    public int Mwa;
    public LinkedList<eon> Nmn = new LinkedList<>();
    public String Nmo;
    public int Nmp;
    public int apptype;
    public String dNI;
    public String ixZ;
    public String pWf;

    public eom() {
        AppMethodBeat.i(74672);
        AppMethodBeat.o(74672);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(74673);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.dNI != null) {
                aVar.e(1, this.dNI);
            }
            if (this.ixZ != null) {
                aVar.e(2, this.ixZ);
            }
            aVar.aM(3, this.apptype);
            aVar.e(4, 8, this.Nmn);
            aVar.aM(5, this.Mwa);
            if (this.Nmo != null) {
                aVar.e(6, this.Nmo);
            }
            if (this.pWf != null) {
                aVar.e(7, this.pWf);
            }
            aVar.aM(8, this.Nmp);
            AppMethodBeat.o(74673);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.dNI != null ? g.a.a.b.b.a.f(1, this.dNI) + 0 : 0;
            if (this.ixZ != null) {
                f2 += g.a.a.b.b.a.f(2, this.ixZ);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.apptype) + g.a.a.a.c(4, 8, this.Nmn) + g.a.a.b.b.a.bu(5, this.Mwa);
            if (this.Nmo != null) {
                bu += g.a.a.b.b.a.f(6, this.Nmo);
            }
            if (this.pWf != null) {
                bu += g.a.a.b.b.a.f(7, this.pWf);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(8, this.Nmp);
            AppMethodBeat.o(74673);
            return bu2;
        } else if (i2 == 2) {
            this.Nmn.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(74673);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eom eom = (eom) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    eom.dNI = aVar3.UbS.readString();
                    AppMethodBeat.o(74673);
                    return 0;
                case 2:
                    eom.ixZ = aVar3.UbS.readString();
                    AppMethodBeat.o(74673);
                    return 0;
                case 3:
                    eom.apptype = aVar3.UbS.zi();
                    AppMethodBeat.o(74673);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        eon eon = new eon();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = eon.populateBuilderWithField(aVar4, eon, a.getNextFieldNumber(aVar4))) {
                        }
                        eom.Nmn.add(eon);
                    }
                    AppMethodBeat.o(74673);
                    return 0;
                case 5:
                    eom.Mwa = aVar3.UbS.zi();
                    AppMethodBeat.o(74673);
                    return 0;
                case 6:
                    eom.Nmo = aVar3.UbS.readString();
                    AppMethodBeat.o(74673);
                    return 0;
                case 7:
                    eom.pWf = aVar3.UbS.readString();
                    AppMethodBeat.o(74673);
                    return 0;
                case 8:
                    eom.Nmp = aVar3.UbS.zi();
                    AppMethodBeat.o(74673);
                    return 0;
                default:
                    AppMethodBeat.o(74673);
                    return -1;
            }
        } else {
            AppMethodBeat.o(74673);
            return -1;
        }
    }
}
