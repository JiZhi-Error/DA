package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cjm extends a {
    public int Mpa;
    public LinkedList<cjl> Mpb = new LinkedList<>();
    public int Mpc;
    public long Mpd;
    public long Mpe;
    public long Mpf;
    public LinkedList<cjj> Mpg = new LinkedList<>();
    public dmr Mph;
    public String clientId;
    public long hdA;
    public int ibG;
    public int postStage;
    public long zZb;

    public cjm() {
        AppMethodBeat.i(169081);
        AppMethodBeat.o(169081);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(169082);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.clientId != null) {
                aVar.e(1, this.clientId);
            }
            aVar.aM(2, this.ibG);
            aVar.aM(3, this.Mpa);
            aVar.e(4, 8, this.Mpb);
            aVar.aM(5, this.Mpc);
            aVar.aM(6, this.postStage);
            aVar.bb(7, this.Mpd);
            aVar.bb(8, this.zZb);
            aVar.bb(9, this.Mpe);
            aVar.bb(10, this.hdA);
            aVar.bb(11, this.Mpf);
            aVar.e(12, 8, this.Mpg);
            if (this.Mph != null) {
                aVar.ni(13, this.Mph.computeSize());
                this.Mph.writeFields(aVar);
            }
            AppMethodBeat.o(169082);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.clientId != null ? g.a.a.b.b.a.f(1, this.clientId) + 0 : 0) + g.a.a.b.b.a.bu(2, this.ibG) + g.a.a.b.b.a.bu(3, this.Mpa) + g.a.a.a.c(4, 8, this.Mpb) + g.a.a.b.b.a.bu(5, this.Mpc) + g.a.a.b.b.a.bu(6, this.postStage) + g.a.a.b.b.a.r(7, this.Mpd) + g.a.a.b.b.a.r(8, this.zZb) + g.a.a.b.b.a.r(9, this.Mpe) + g.a.a.b.b.a.r(10, this.hdA) + g.a.a.b.b.a.r(11, this.Mpf) + g.a.a.a.c(12, 8, this.Mpg);
            if (this.Mph != null) {
                f2 += g.a.a.a.nh(13, this.Mph.computeSize());
            }
            AppMethodBeat.o(169082);
            return f2;
        } else if (i2 == 2) {
            this.Mpb.clear();
            this.Mpg.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(169082);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cjm cjm = (cjm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cjm.clientId = aVar3.UbS.readString();
                    AppMethodBeat.o(169082);
                    return 0;
                case 2:
                    cjm.ibG = aVar3.UbS.zi();
                    AppMethodBeat.o(169082);
                    return 0;
                case 3:
                    cjm.Mpa = aVar3.UbS.zi();
                    AppMethodBeat.o(169082);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cjl cjl = new cjl();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cjl.populateBuilderWithField(aVar4, cjl, a.getNextFieldNumber(aVar4))) {
                        }
                        cjm.Mpb.add(cjl);
                    }
                    AppMethodBeat.o(169082);
                    return 0;
                case 5:
                    cjm.Mpc = aVar3.UbS.zi();
                    AppMethodBeat.o(169082);
                    return 0;
                case 6:
                    cjm.postStage = aVar3.UbS.zi();
                    AppMethodBeat.o(169082);
                    return 0;
                case 7:
                    cjm.Mpd = aVar3.UbS.zl();
                    AppMethodBeat.o(169082);
                    return 0;
                case 8:
                    cjm.zZb = aVar3.UbS.zl();
                    AppMethodBeat.o(169082);
                    return 0;
                case 9:
                    cjm.Mpe = aVar3.UbS.zl();
                    AppMethodBeat.o(169082);
                    return 0;
                case 10:
                    cjm.hdA = aVar3.UbS.zl();
                    AppMethodBeat.o(169082);
                    return 0;
                case 11:
                    cjm.Mpf = aVar3.UbS.zl();
                    AppMethodBeat.o(169082);
                    return 0;
                case 12:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cjj cjj = new cjj();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cjj.populateBuilderWithField(aVar5, cjj, a.getNextFieldNumber(aVar5))) {
                        }
                        cjm.Mpg.add(cjj);
                    }
                    AppMethodBeat.o(169082);
                    return 0;
                case 13:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dmr dmr = new dmr();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dmr.populateBuilderWithField(aVar6, dmr, a.getNextFieldNumber(aVar6))) {
                        }
                        cjm.Mph = dmr;
                    }
                    AppMethodBeat.o(169082);
                    return 0;
                default:
                    AppMethodBeat.o(169082);
                    return -1;
            }
        } else {
            AppMethodBeat.o(169082);
            return -1;
        }
    }
}
