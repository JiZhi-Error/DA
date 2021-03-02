package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class drw extends a {
    public String LVq;
    public String Lsm;
    public String Lsn;
    public String Lso;
    public int MUA;
    public String MUu;
    public int MUv;
    public String MUw;
    public String MUx;
    public String MUy;
    public int MUz;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(187879);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MUu != null) {
                aVar.e(1, this.MUu);
            }
            aVar.aM(2, this.MUv);
            if (this.MUw != null) {
                aVar.e(3, this.MUw);
            }
            if (this.MUx != null) {
                aVar.e(4, this.MUx);
            }
            if (this.MUy != null) {
                aVar.e(5, this.MUy);
            }
            if (this.LVq != null) {
                aVar.e(6, this.LVq);
            }
            if (this.Lsm != null) {
                aVar.e(7, this.Lsm);
            }
            if (this.Lsn != null) {
                aVar.e(8, this.Lsn);
            }
            if (this.Lso != null) {
                aVar.e(9, this.Lso);
            }
            aVar.aM(10, this.MUz);
            aVar.aM(11, this.MUA);
            AppMethodBeat.o(187879);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.MUu != null ? g.a.a.b.b.a.f(1, this.MUu) + 0 : 0) + g.a.a.b.b.a.bu(2, this.MUv);
            if (this.MUw != null) {
                f2 += g.a.a.b.b.a.f(3, this.MUw);
            }
            if (this.MUx != null) {
                f2 += g.a.a.b.b.a.f(4, this.MUx);
            }
            if (this.MUy != null) {
                f2 += g.a.a.b.b.a.f(5, this.MUy);
            }
            if (this.LVq != null) {
                f2 += g.a.a.b.b.a.f(6, this.LVq);
            }
            if (this.Lsm != null) {
                f2 += g.a.a.b.b.a.f(7, this.Lsm);
            }
            if (this.Lsn != null) {
                f2 += g.a.a.b.b.a.f(8, this.Lsn);
            }
            if (this.Lso != null) {
                f2 += g.a.a.b.b.a.f(9, this.Lso);
            }
            int bu = f2 + g.a.a.b.b.a.bu(10, this.MUz) + g.a.a.b.b.a.bu(11, this.MUA);
            AppMethodBeat.o(187879);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(187879);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            drw drw = (drw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    drw.MUu = aVar3.UbS.readString();
                    AppMethodBeat.o(187879);
                    return 0;
                case 2:
                    drw.MUv = aVar3.UbS.zi();
                    AppMethodBeat.o(187879);
                    return 0;
                case 3:
                    drw.MUw = aVar3.UbS.readString();
                    AppMethodBeat.o(187879);
                    return 0;
                case 4:
                    drw.MUx = aVar3.UbS.readString();
                    AppMethodBeat.o(187879);
                    return 0;
                case 5:
                    drw.MUy = aVar3.UbS.readString();
                    AppMethodBeat.o(187879);
                    return 0;
                case 6:
                    drw.LVq = aVar3.UbS.readString();
                    AppMethodBeat.o(187879);
                    return 0;
                case 7:
                    drw.Lsm = aVar3.UbS.readString();
                    AppMethodBeat.o(187879);
                    return 0;
                case 8:
                    drw.Lsn = aVar3.UbS.readString();
                    AppMethodBeat.o(187879);
                    return 0;
                case 9:
                    drw.Lso = aVar3.UbS.readString();
                    AppMethodBeat.o(187879);
                    return 0;
                case 10:
                    drw.MUz = aVar3.UbS.zi();
                    AppMethodBeat.o(187879);
                    return 0;
                case 11:
                    drw.MUA = aVar3.UbS.zi();
                    AppMethodBeat.o(187879);
                    return 0;
                default:
                    AppMethodBeat.o(187879);
                    return -1;
            }
        } else {
            AppMethodBeat.o(187879);
            return -1;
        }
    }
}
