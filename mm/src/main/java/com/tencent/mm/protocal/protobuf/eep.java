package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class eep extends a {
    public String iyZ;
    public int iza;
    public String izb;
    public String izc;
    public String izd;
    public String ize;
    public String izf;
    public String izg;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125846);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.iyZ != null) {
                aVar.e(1, this.iyZ);
            }
            aVar.aM(2, this.iza);
            if (this.izc != null) {
                aVar.e(3, this.izc);
            }
            if (this.izd != null) {
                aVar.e(4, this.izd);
            }
            if (this.izb != null) {
                aVar.e(5, this.izb);
            }
            if (this.ize != null) {
                aVar.e(6, this.ize);
            }
            if (this.izf != null) {
                aVar.e(7, this.izf);
            }
            if (this.izg != null) {
                aVar.e(8, this.izg);
            }
            AppMethodBeat.o(125846);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.iyZ != null ? g.a.a.b.b.a.f(1, this.iyZ) + 0 : 0) + g.a.a.b.b.a.bu(2, this.iza);
            if (this.izc != null) {
                f2 += g.a.a.b.b.a.f(3, this.izc);
            }
            if (this.izd != null) {
                f2 += g.a.a.b.b.a.f(4, this.izd);
            }
            if (this.izb != null) {
                f2 += g.a.a.b.b.a.f(5, this.izb);
            }
            if (this.ize != null) {
                f2 += g.a.a.b.b.a.f(6, this.ize);
            }
            if (this.izf != null) {
                f2 += g.a.a.b.b.a.f(7, this.izf);
            }
            if (this.izg != null) {
                f2 += g.a.a.b.b.a.f(8, this.izg);
            }
            AppMethodBeat.o(125846);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(125846);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eep eep = (eep) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eep.iyZ = aVar3.UbS.readString();
                    AppMethodBeat.o(125846);
                    return 0;
                case 2:
                    eep.iza = aVar3.UbS.zi();
                    AppMethodBeat.o(125846);
                    return 0;
                case 3:
                    eep.izc = aVar3.UbS.readString();
                    AppMethodBeat.o(125846);
                    return 0;
                case 4:
                    eep.izd = aVar3.UbS.readString();
                    AppMethodBeat.o(125846);
                    return 0;
                case 5:
                    eep.izb = aVar3.UbS.readString();
                    AppMethodBeat.o(125846);
                    return 0;
                case 6:
                    eep.ize = aVar3.UbS.readString();
                    AppMethodBeat.o(125846);
                    return 0;
                case 7:
                    eep.izf = aVar3.UbS.readString();
                    AppMethodBeat.o(125846);
                    return 0;
                case 8:
                    eep.izg = aVar3.UbS.readString();
                    AppMethodBeat.o(125846);
                    return 0;
                default:
                    AppMethodBeat.o(125846);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125846);
            return -1;
        }
    }
}