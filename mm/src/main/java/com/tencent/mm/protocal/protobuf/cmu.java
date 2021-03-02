package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cmu extends a {
    public long Msk;
    public long Msl;
    public long Msm;
    public LinkedList<fbr> Msn = new LinkedList<>();
    public long Mso;
    public boolean Msp;
    public double Msq;
    public LinkedList<fbr> Msr = new LinkedList<>();
    public LinkedList<eko> Mss = new LinkedList<>();
    public ejo Mst;
    public long begin_time;
    public long dDw;
    public long duration;
    public long id;
    public String path;

    public cmu() {
        AppMethodBeat.i(110905);
        AppMethodBeat.o(110905);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(110906);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.id);
            aVar.bb(2, this.dDw);
            aVar.bb(3, this.begin_time);
            aVar.bb(4, this.duration);
            aVar.bb(5, this.Msk);
            aVar.bb(6, this.Msl);
            aVar.bb(7, this.Msm);
            aVar.e(8, 8, this.Msn);
            aVar.bb(9, this.Mso);
            aVar.cc(10, this.Msp);
            aVar.e(11, this.Msq);
            aVar.e(12, 8, this.Msr);
            aVar.e(13, 8, this.Mss);
            if (this.Mst != null) {
                aVar.ni(14, this.Mst.computeSize());
                this.Mst.writeFields(aVar);
            }
            if (this.path != null) {
                aVar.e(15, this.path);
            }
            AppMethodBeat.o(110906);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.id) + 0 + g.a.a.b.b.a.r(2, this.dDw) + g.a.a.b.b.a.r(3, this.begin_time) + g.a.a.b.b.a.r(4, this.duration) + g.a.a.b.b.a.r(5, this.Msk) + g.a.a.b.b.a.r(6, this.Msl) + g.a.a.b.b.a.r(7, this.Msm) + g.a.a.a.c(8, 8, this.Msn) + g.a.a.b.b.a.r(9, this.Mso) + g.a.a.b.b.a.fS(10) + 1 + g.a.a.b.b.a.fS(11) + 8 + g.a.a.a.c(12, 8, this.Msr) + g.a.a.a.c(13, 8, this.Mss);
            if (this.Mst != null) {
                r += g.a.a.a.nh(14, this.Mst.computeSize());
            }
            if (this.path != null) {
                r += g.a.a.b.b.a.f(15, this.path);
            }
            AppMethodBeat.o(110906);
            return r;
        } else if (i2 == 2) {
            this.Msn.clear();
            this.Msr.clear();
            this.Mss.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(110906);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cmu cmu = (cmu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cmu.id = aVar3.UbS.zl();
                    AppMethodBeat.o(110906);
                    return 0;
                case 2:
                    cmu.dDw = aVar3.UbS.zl();
                    AppMethodBeat.o(110906);
                    return 0;
                case 3:
                    cmu.begin_time = aVar3.UbS.zl();
                    AppMethodBeat.o(110906);
                    return 0;
                case 4:
                    cmu.duration = aVar3.UbS.zl();
                    AppMethodBeat.o(110906);
                    return 0;
                case 5:
                    cmu.Msk = aVar3.UbS.zl();
                    AppMethodBeat.o(110906);
                    return 0;
                case 6:
                    cmu.Msl = aVar3.UbS.zl();
                    AppMethodBeat.o(110906);
                    return 0;
                case 7:
                    cmu.Msm = aVar3.UbS.zl();
                    AppMethodBeat.o(110906);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        fbr fbr = new fbr();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = fbr.populateBuilderWithField(aVar4, fbr, a.getNextFieldNumber(aVar4))) {
                        }
                        cmu.Msn.add(fbr);
                    }
                    AppMethodBeat.o(110906);
                    return 0;
                case 9:
                    cmu.Mso = aVar3.UbS.zl();
                    AppMethodBeat.o(110906);
                    return 0;
                case 10:
                    cmu.Msp = aVar3.UbS.yZ();
                    AppMethodBeat.o(110906);
                    return 0;
                case 11:
                    cmu.Msq = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(110906);
                    return 0;
                case 12:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        fbr fbr2 = new fbr();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = fbr2.populateBuilderWithField(aVar5, fbr2, a.getNextFieldNumber(aVar5))) {
                        }
                        cmu.Msr.add(fbr2);
                    }
                    AppMethodBeat.o(110906);
                    return 0;
                case 13:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        eko eko = new eko();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = eko.populateBuilderWithField(aVar6, eko, a.getNextFieldNumber(aVar6))) {
                        }
                        cmu.Mss.add(eko);
                    }
                    AppMethodBeat.o(110906);
                    return 0;
                case 14:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        ejo ejo = new ejo();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = ejo.populateBuilderWithField(aVar7, ejo, a.getNextFieldNumber(aVar7))) {
                        }
                        cmu.Mst = ejo;
                    }
                    AppMethodBeat.o(110906);
                    return 0;
                case 15:
                    cmu.path = aVar3.UbS.readString();
                    AppMethodBeat.o(110906);
                    return 0;
                default:
                    AppMethodBeat.o(110906);
                    return -1;
            }
        } else {
            AppMethodBeat.o(110906);
            return -1;
        }
    }
}
