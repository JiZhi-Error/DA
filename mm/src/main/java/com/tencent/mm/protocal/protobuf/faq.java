package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class faq extends a {
    public long KZg;
    public int MaY;
    public chl MlQ;
    public aah MlR;
    public LinkedList<String> NwT = new LinkedList<>();
    public LinkedList<aca> NwU = new LinkedList<>();
    public int Scene;
    public String pLm;
    public String rBI;

    public faq() {
        AppMethodBeat.i(117951);
        AppMethodBeat.o(117951);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117952);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 1, this.NwT);
            aVar.aM(2, this.MaY);
            if (this.rBI != null) {
                aVar.e(3, this.rBI);
            }
            aVar.aM(4, this.Scene);
            aVar.bb(5, this.KZg);
            if (this.pLm != null) {
                aVar.e(6, this.pLm);
            }
            if (this.MlQ != null) {
                aVar.ni(7, this.MlQ.computeSize());
                this.MlQ.writeFields(aVar);
            }
            aVar.e(8, 8, this.NwU);
            if (this.MlR != null) {
                aVar.ni(9, this.MlR.computeSize());
                this.MlR.writeFields(aVar);
            }
            AppMethodBeat.o(117952);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 1, this.NwT) + 0 + g.a.a.b.b.a.bu(2, this.MaY);
            if (this.rBI != null) {
                c2 += g.a.a.b.b.a.f(3, this.rBI);
            }
            int bu = c2 + g.a.a.b.b.a.bu(4, this.Scene) + g.a.a.b.b.a.r(5, this.KZg);
            if (this.pLm != null) {
                bu += g.a.a.b.b.a.f(6, this.pLm);
            }
            if (this.MlQ != null) {
                bu += g.a.a.a.nh(7, this.MlQ.computeSize());
            }
            int c3 = bu + g.a.a.a.c(8, 8, this.NwU);
            if (this.MlR != null) {
                c3 += g.a.a.a.nh(9, this.MlR.computeSize());
            }
            AppMethodBeat.o(117952);
            return c3;
        } else if (i2 == 2) {
            this.NwT.clear();
            this.NwU.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(117952);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            faq faq = (faq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    faq.NwT.add(aVar3.UbS.readString());
                    AppMethodBeat.o(117952);
                    return 0;
                case 2:
                    faq.MaY = aVar3.UbS.zi();
                    AppMethodBeat.o(117952);
                    return 0;
                case 3:
                    faq.rBI = aVar3.UbS.readString();
                    AppMethodBeat.o(117952);
                    return 0;
                case 4:
                    faq.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(117952);
                    return 0;
                case 5:
                    faq.KZg = aVar3.UbS.zl();
                    AppMethodBeat.o(117952);
                    return 0;
                case 6:
                    faq.pLm = aVar3.UbS.readString();
                    AppMethodBeat.o(117952);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        chl chl = new chl();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = chl.populateBuilderWithField(aVar4, chl, a.getNextFieldNumber(aVar4))) {
                        }
                        faq.MlQ = chl;
                    }
                    AppMethodBeat.o(117952);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aca aca = new aca();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aca.populateBuilderWithField(aVar5, aca, a.getNextFieldNumber(aVar5))) {
                        }
                        faq.NwU.add(aca);
                    }
                    AppMethodBeat.o(117952);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        aah aah = new aah();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = aah.populateBuilderWithField(aVar6, aah, a.getNextFieldNumber(aVar6))) {
                        }
                        faq.MlR = aah;
                    }
                    AppMethodBeat.o(117952);
                    return 0;
                default:
                    AppMethodBeat.o(117952);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117952);
            return -1;
        }
    }
}
