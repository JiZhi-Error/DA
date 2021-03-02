package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class uf extends a {
    public String KDM;
    public String LcR;
    public String LdG;
    public int Ldc;
    public String Ldd;
    public un Lde;
    public String Ldf;
    public String eaO;
    public String gTG;
    public int nHh;
    public String qGB;
    public String title;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(201323);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.eaO != null) {
                aVar.e(1, this.eaO);
            }
            if (this.KDM != null) {
                aVar.e(2, this.KDM);
            }
            if (this.title != null) {
                aVar.e(3, this.title);
            }
            if (this.gTG != null) {
                aVar.e(4, this.gTG);
            }
            if (this.LdG != null) {
                aVar.e(5, this.LdG);
            }
            if (this.LcR != null) {
                aVar.e(6, this.LcR);
            }
            aVar.aM(7, this.nHh);
            if (this.qGB != null) {
                aVar.e(8, this.qGB);
            }
            aVar.aM(9, this.Ldc);
            if (this.Ldd != null) {
                aVar.e(10, this.Ldd);
            }
            if (this.Lde != null) {
                aVar.ni(11, this.Lde.computeSize());
                this.Lde.writeFields(aVar);
            }
            if (this.Ldf != null) {
                aVar.e(12, this.Ldf);
            }
            AppMethodBeat.o(201323);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.eaO != null ? g.a.a.b.b.a.f(1, this.eaO) + 0 : 0;
            if (this.KDM != null) {
                f2 += g.a.a.b.b.a.f(2, this.KDM);
            }
            if (this.title != null) {
                f2 += g.a.a.b.b.a.f(3, this.title);
            }
            if (this.gTG != null) {
                f2 += g.a.a.b.b.a.f(4, this.gTG);
            }
            if (this.LdG != null) {
                f2 += g.a.a.b.b.a.f(5, this.LdG);
            }
            if (this.LcR != null) {
                f2 += g.a.a.b.b.a.f(6, this.LcR);
            }
            int bu = f2 + g.a.a.b.b.a.bu(7, this.nHh);
            if (this.qGB != null) {
                bu += g.a.a.b.b.a.f(8, this.qGB);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(9, this.Ldc);
            if (this.Ldd != null) {
                bu2 += g.a.a.b.b.a.f(10, this.Ldd);
            }
            if (this.Lde != null) {
                bu2 += g.a.a.a.nh(11, this.Lde.computeSize());
            }
            if (this.Ldf != null) {
                bu2 += g.a.a.b.b.a.f(12, this.Ldf);
            }
            AppMethodBeat.o(201323);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(201323);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            uf ufVar = (uf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ufVar.eaO = aVar3.UbS.readString();
                    AppMethodBeat.o(201323);
                    return 0;
                case 2:
                    ufVar.KDM = aVar3.UbS.readString();
                    AppMethodBeat.o(201323);
                    return 0;
                case 3:
                    ufVar.title = aVar3.UbS.readString();
                    AppMethodBeat.o(201323);
                    return 0;
                case 4:
                    ufVar.gTG = aVar3.UbS.readString();
                    AppMethodBeat.o(201323);
                    return 0;
                case 5:
                    ufVar.LdG = aVar3.UbS.readString();
                    AppMethodBeat.o(201323);
                    return 0;
                case 6:
                    ufVar.LcR = aVar3.UbS.readString();
                    AppMethodBeat.o(201323);
                    return 0;
                case 7:
                    ufVar.nHh = aVar3.UbS.zi();
                    AppMethodBeat.o(201323);
                    return 0;
                case 8:
                    ufVar.qGB = aVar3.UbS.readString();
                    AppMethodBeat.o(201323);
                    return 0;
                case 9:
                    ufVar.Ldc = aVar3.UbS.zi();
                    AppMethodBeat.o(201323);
                    return 0;
                case 10:
                    ufVar.Ldd = aVar3.UbS.readString();
                    AppMethodBeat.o(201323);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        un unVar = new un();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = unVar.populateBuilderWithField(aVar4, unVar, a.getNextFieldNumber(aVar4))) {
                        }
                        ufVar.Lde = unVar;
                    }
                    AppMethodBeat.o(201323);
                    return 0;
                case 12:
                    ufVar.Ldf = aVar3.UbS.readString();
                    AppMethodBeat.o(201323);
                    return 0;
                default:
                    AppMethodBeat.o(201323);
                    return -1;
            }
        } else {
            AppMethodBeat.o(201323);
            return -1;
        }
    }
}
