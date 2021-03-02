package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ald extends a {
    public boolean BLF;
    public String BOA;
    public boolean BOx;
    public boolean BOy;
    public String BOz;
    public boolean Gvu;
    public LinkedList<Integer> Luc = new LinkedList<>();
    public boolean Lud;
    public String Lue;
    public int Luf;
    public long duration;
    public int hDa;
    public int iTg;

    public ald() {
        AppMethodBeat.i(75026);
        AppMethodBeat.o(75026);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(75027);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.duration);
            aVar.e(2, 2, this.Luc);
            aVar.aM(3, this.iTg);
            aVar.cc(4, this.Lud);
            aVar.cc(5, this.Gvu);
            aVar.cc(6, this.BOx);
            aVar.cc(7, this.BOy);
            if (this.BOz != null) {
                aVar.e(8, this.BOz);
            }
            if (this.BOA != null) {
                aVar.e(9, this.BOA);
            }
            if (this.Lue != null) {
                aVar.e(10, this.Lue);
            }
            aVar.cc(11, this.BLF);
            aVar.aM(12, this.Luf);
            aVar.aM(13, this.hDa);
            AppMethodBeat.o(75027);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.duration) + 0 + g.a.a.a.c(2, 2, this.Luc) + g.a.a.b.b.a.bu(3, this.iTg) + g.a.a.b.b.a.fS(4) + 1 + g.a.a.b.b.a.fS(5) + 1 + g.a.a.b.b.a.fS(6) + 1 + g.a.a.b.b.a.fS(7) + 1;
            if (this.BOz != null) {
                r += g.a.a.b.b.a.f(8, this.BOz);
            }
            if (this.BOA != null) {
                r += g.a.a.b.b.a.f(9, this.BOA);
            }
            if (this.Lue != null) {
                r += g.a.a.b.b.a.f(10, this.Lue);
            }
            int fS = r + g.a.a.b.b.a.fS(11) + 1 + g.a.a.b.b.a.bu(12, this.Luf) + g.a.a.b.b.a.bu(13, this.hDa);
            AppMethodBeat.o(75027);
            return fS;
        } else if (i2 == 2) {
            this.Luc.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(75027);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ald ald = (ald) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ald.duration = aVar3.UbS.zl();
                    AppMethodBeat.o(75027);
                    return 0;
                case 2:
                    ald.Luc.add(Integer.valueOf(aVar3.UbS.zi()));
                    AppMethodBeat.o(75027);
                    return 0;
                case 3:
                    ald.iTg = aVar3.UbS.zi();
                    AppMethodBeat.o(75027);
                    return 0;
                case 4:
                    ald.Lud = aVar3.UbS.yZ();
                    AppMethodBeat.o(75027);
                    return 0;
                case 5:
                    ald.Gvu = aVar3.UbS.yZ();
                    AppMethodBeat.o(75027);
                    return 0;
                case 6:
                    ald.BOx = aVar3.UbS.yZ();
                    AppMethodBeat.o(75027);
                    return 0;
                case 7:
                    ald.BOy = aVar3.UbS.yZ();
                    AppMethodBeat.o(75027);
                    return 0;
                case 8:
                    ald.BOz = aVar3.UbS.readString();
                    AppMethodBeat.o(75027);
                    return 0;
                case 9:
                    ald.BOA = aVar3.UbS.readString();
                    AppMethodBeat.o(75027);
                    return 0;
                case 10:
                    ald.Lue = aVar3.UbS.readString();
                    AppMethodBeat.o(75027);
                    return 0;
                case 11:
                    ald.BLF = aVar3.UbS.yZ();
                    AppMethodBeat.o(75027);
                    return 0;
                case 12:
                    ald.Luf = aVar3.UbS.zi();
                    AppMethodBeat.o(75027);
                    return 0;
                case 13:
                    ald.hDa = aVar3.UbS.zi();
                    AppMethodBeat.o(75027);
                    return 0;
                default:
                    AppMethodBeat.o(75027);
                    return -1;
            }
        } else {
            AppMethodBeat.o(75027);
            return -1;
        }
    }
}
