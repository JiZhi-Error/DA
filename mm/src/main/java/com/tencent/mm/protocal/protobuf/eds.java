package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class eds extends a {
    public int BOX;
    public String HIK;
    public int Lsa;
    public long NdZ;
    public boolean Nea;
    public LinkedList<String> Neb = new LinkedList<>();
    public LinkedList<String> Nec = new LinkedList<>();

    public eds() {
        AppMethodBeat.i(118452);
        AppMethodBeat.o(118452);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(118453);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.NdZ);
            aVar.aM(2, this.BOX);
            aVar.aM(3, this.Lsa);
            aVar.cc(4, this.Nea);
            aVar.e(5, 1, this.Neb);
            aVar.e(6, 1, this.Nec);
            if (this.HIK != null) {
                aVar.e(7, this.HIK);
            }
            AppMethodBeat.o(118453);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.NdZ) + 0 + g.a.a.b.b.a.bu(2, this.BOX) + g.a.a.b.b.a.bu(3, this.Lsa) + g.a.a.b.b.a.fS(4) + 1 + g.a.a.a.c(5, 1, this.Neb) + g.a.a.a.c(6, 1, this.Nec);
            if (this.HIK != null) {
                r += g.a.a.b.b.a.f(7, this.HIK);
            }
            AppMethodBeat.o(118453);
            return r;
        } else if (i2 == 2) {
            this.Neb.clear();
            this.Nec.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(118453);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eds eds = (eds) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eds.NdZ = aVar3.UbS.zl();
                    AppMethodBeat.o(118453);
                    return 0;
                case 2:
                    eds.BOX = aVar3.UbS.zi();
                    AppMethodBeat.o(118453);
                    return 0;
                case 3:
                    eds.Lsa = aVar3.UbS.zi();
                    AppMethodBeat.o(118453);
                    return 0;
                case 4:
                    eds.Nea = aVar3.UbS.yZ();
                    AppMethodBeat.o(118453);
                    return 0;
                case 5:
                    eds.Neb.add(aVar3.UbS.readString());
                    AppMethodBeat.o(118453);
                    return 0;
                case 6:
                    eds.Nec.add(aVar3.UbS.readString());
                    AppMethodBeat.o(118453);
                    return 0;
                case 7:
                    eds.HIK = aVar3.UbS.readString();
                    AppMethodBeat.o(118453);
                    return 0;
                default:
                    AppMethodBeat.o(118453);
                    return -1;
            }
        } else {
            AppMethodBeat.o(118453);
            return -1;
        }
    }
}
