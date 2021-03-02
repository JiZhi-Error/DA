package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class fal extends a {
    public String KZj;
    public int KZk;
    public String LPT;
    public String MEr;
    public String MOi;
    public int MRb;
    public int MRf;
    public int MRy;
    public int MaY;
    public chl MlQ;
    public int NgA;
    public LinkedList<aca> Nva = new LinkedList<>();
    public int NwG = 2;
    public String NwH;
    public String NwI;
    public LinkedList<String> NwJ = new LinkedList<>();
    public int NwK;
    public beo NwL;
    public int Scene;
    public int oUv;

    public fal() {
        AppMethodBeat.i(117947);
        AppMethodBeat.o(117947);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117948);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.KZk);
            aVar.aM(2, this.MaY);
            aVar.aM(3, this.MRb);
            if (this.LPT != null) {
                aVar.e(4, this.LPT);
            }
            if (this.MlQ != null) {
                aVar.ni(5, this.MlQ.computeSize());
                this.MlQ.writeFields(aVar);
            }
            aVar.aM(6, this.Scene);
            if (this.KZj != null) {
                aVar.e(7, this.KZj);
            }
            aVar.aM(8, this.MRf);
            aVar.aM(9, this.NwG);
            aVar.e(10, 8, this.Nva);
            if (this.NwH != null) {
                aVar.e(11, this.NwH);
            }
            if (this.MEr != null) {
                aVar.e(12, this.MEr);
            }
            aVar.aM(13, this.NgA);
            if (this.NwI != null) {
                aVar.e(14, this.NwI);
            }
            if (this.MOi != null) {
                aVar.e(15, this.MOi);
            }
            aVar.e(16, 1, this.NwJ);
            aVar.aM(17, this.MRy);
            aVar.aM(18, this.oUv);
            aVar.aM(19, this.NwK);
            if (this.NwL != null) {
                aVar.ni(20, this.NwL.computeSize());
                this.NwL.writeFields(aVar);
            }
            AppMethodBeat.o(117948);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.KZk) + 0 + g.a.a.b.b.a.bu(2, this.MaY) + g.a.a.b.b.a.bu(3, this.MRb);
            if (this.LPT != null) {
                bu += g.a.a.b.b.a.f(4, this.LPT);
            }
            if (this.MlQ != null) {
                bu += g.a.a.a.nh(5, this.MlQ.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(6, this.Scene);
            if (this.KZj != null) {
                bu2 += g.a.a.b.b.a.f(7, this.KZj);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(8, this.MRf) + g.a.a.b.b.a.bu(9, this.NwG) + g.a.a.a.c(10, 8, this.Nva);
            if (this.NwH != null) {
                bu3 += g.a.a.b.b.a.f(11, this.NwH);
            }
            if (this.MEr != null) {
                bu3 += g.a.a.b.b.a.f(12, this.MEr);
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(13, this.NgA);
            if (this.NwI != null) {
                bu4 += g.a.a.b.b.a.f(14, this.NwI);
            }
            if (this.MOi != null) {
                bu4 += g.a.a.b.b.a.f(15, this.MOi);
            }
            int c2 = bu4 + g.a.a.a.c(16, 1, this.NwJ) + g.a.a.b.b.a.bu(17, this.MRy) + g.a.a.b.b.a.bu(18, this.oUv) + g.a.a.b.b.a.bu(19, this.NwK);
            if (this.NwL != null) {
                c2 += g.a.a.a.nh(20, this.NwL.computeSize());
            }
            AppMethodBeat.o(117948);
            return c2;
        } else if (i2 == 2) {
            this.Nva.clear();
            this.NwJ.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(117948);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fal fal = (fal) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    fal.KZk = aVar3.UbS.zi();
                    AppMethodBeat.o(117948);
                    return 0;
                case 2:
                    fal.MaY = aVar3.UbS.zi();
                    AppMethodBeat.o(117948);
                    return 0;
                case 3:
                    fal.MRb = aVar3.UbS.zi();
                    AppMethodBeat.o(117948);
                    return 0;
                case 4:
                    fal.LPT = aVar3.UbS.readString();
                    AppMethodBeat.o(117948);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        chl chl = new chl();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = chl.populateBuilderWithField(aVar4, chl, a.getNextFieldNumber(aVar4))) {
                        }
                        fal.MlQ = chl;
                    }
                    AppMethodBeat.o(117948);
                    return 0;
                case 6:
                    fal.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(117948);
                    return 0;
                case 7:
                    fal.KZj = aVar3.UbS.readString();
                    AppMethodBeat.o(117948);
                    return 0;
                case 8:
                    fal.MRf = aVar3.UbS.zi();
                    AppMethodBeat.o(117948);
                    return 0;
                case 9:
                    fal.NwG = aVar3.UbS.zi();
                    AppMethodBeat.o(117948);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aca aca = new aca();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aca.populateBuilderWithField(aVar5, aca, a.getNextFieldNumber(aVar5))) {
                        }
                        fal.Nva.add(aca);
                    }
                    AppMethodBeat.o(117948);
                    return 0;
                case 11:
                    fal.NwH = aVar3.UbS.readString();
                    AppMethodBeat.o(117948);
                    return 0;
                case 12:
                    fal.MEr = aVar3.UbS.readString();
                    AppMethodBeat.o(117948);
                    return 0;
                case 13:
                    fal.NgA = aVar3.UbS.zi();
                    AppMethodBeat.o(117948);
                    return 0;
                case 14:
                    fal.NwI = aVar3.UbS.readString();
                    AppMethodBeat.o(117948);
                    return 0;
                case 15:
                    fal.MOi = aVar3.UbS.readString();
                    AppMethodBeat.o(117948);
                    return 0;
                case 16:
                    fal.NwJ.add(aVar3.UbS.readString());
                    AppMethodBeat.o(117948);
                    return 0;
                case 17:
                    fal.MRy = aVar3.UbS.zi();
                    AppMethodBeat.o(117948);
                    return 0;
                case 18:
                    fal.oUv = aVar3.UbS.zi();
                    AppMethodBeat.o(117948);
                    return 0;
                case 19:
                    fal.NwK = aVar3.UbS.zi();
                    AppMethodBeat.o(117948);
                    return 0;
                case 20:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        beo beo = new beo();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = beo.populateBuilderWithField(aVar6, beo, a.getNextFieldNumber(aVar6))) {
                        }
                        fal.NwL = beo;
                    }
                    AppMethodBeat.o(117948);
                    return 0;
                default:
                    AppMethodBeat.o(117948);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117948);
            return -1;
        }
    }
}
