package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class dlr extends a {
    public int MPl;
    public String iwl;
    public String iwm;
    public String iwn;
    public String iwo;
    public String iwp;
    public String iwq;
    public String iwr;
    public String iws;
    public String iwt;
    public String iwu;
    public String iwv;
    public String iww;
    public boolean iwx;
    public int iwy;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(169219);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.iwl != null) {
                aVar.e(1, this.iwl);
            }
            if (this.iwm != null) {
                aVar.e(2, this.iwm);
            }
            if (this.iwn != null) {
                aVar.e(3, this.iwn);
            }
            if (this.iwo != null) {
                aVar.e(4, this.iwo);
            }
            if (this.iwp != null) {
                aVar.e(5, this.iwp);
            }
            if (this.iwq != null) {
                aVar.e(6, this.iwq);
            }
            if (this.iwr != null) {
                aVar.e(7, this.iwr);
            }
            if (this.iws != null) {
                aVar.e(8, this.iws);
            }
            if (this.iwt != null) {
                aVar.e(9, this.iwt);
            }
            if (this.iwu != null) {
                aVar.e(10, this.iwu);
            }
            aVar.aM(11, this.MPl);
            if (this.iwv != null) {
                aVar.e(12, this.iwv);
            }
            if (this.iww != null) {
                aVar.e(13, this.iww);
            }
            aVar.cc(14, this.iwx);
            aVar.aM(15, this.iwy);
            AppMethodBeat.o(169219);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.iwl != null ? g.a.a.b.b.a.f(1, this.iwl) + 0 : 0;
            if (this.iwm != null) {
                f2 += g.a.a.b.b.a.f(2, this.iwm);
            }
            if (this.iwn != null) {
                f2 += g.a.a.b.b.a.f(3, this.iwn);
            }
            if (this.iwo != null) {
                f2 += g.a.a.b.b.a.f(4, this.iwo);
            }
            if (this.iwp != null) {
                f2 += g.a.a.b.b.a.f(5, this.iwp);
            }
            if (this.iwq != null) {
                f2 += g.a.a.b.b.a.f(6, this.iwq);
            }
            if (this.iwr != null) {
                f2 += g.a.a.b.b.a.f(7, this.iwr);
            }
            if (this.iws != null) {
                f2 += g.a.a.b.b.a.f(8, this.iws);
            }
            if (this.iwt != null) {
                f2 += g.a.a.b.b.a.f(9, this.iwt);
            }
            if (this.iwu != null) {
                f2 += g.a.a.b.b.a.f(10, this.iwu);
            }
            int bu = f2 + g.a.a.b.b.a.bu(11, this.MPl);
            if (this.iwv != null) {
                bu += g.a.a.b.b.a.f(12, this.iwv);
            }
            if (this.iww != null) {
                bu += g.a.a.b.b.a.f(13, this.iww);
            }
            int fS = bu + g.a.a.b.b.a.fS(14) + 1 + g.a.a.b.b.a.bu(15, this.iwy);
            AppMethodBeat.o(169219);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(169219);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dlr dlr = (dlr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dlr.iwl = aVar3.UbS.readString();
                    AppMethodBeat.o(169219);
                    return 0;
                case 2:
                    dlr.iwm = aVar3.UbS.readString();
                    AppMethodBeat.o(169219);
                    return 0;
                case 3:
                    dlr.iwn = aVar3.UbS.readString();
                    AppMethodBeat.o(169219);
                    return 0;
                case 4:
                    dlr.iwo = aVar3.UbS.readString();
                    AppMethodBeat.o(169219);
                    return 0;
                case 5:
                    dlr.iwp = aVar3.UbS.readString();
                    AppMethodBeat.o(169219);
                    return 0;
                case 6:
                    dlr.iwq = aVar3.UbS.readString();
                    AppMethodBeat.o(169219);
                    return 0;
                case 7:
                    dlr.iwr = aVar3.UbS.readString();
                    AppMethodBeat.o(169219);
                    return 0;
                case 8:
                    dlr.iws = aVar3.UbS.readString();
                    AppMethodBeat.o(169219);
                    return 0;
                case 9:
                    dlr.iwt = aVar3.UbS.readString();
                    AppMethodBeat.o(169219);
                    return 0;
                case 10:
                    dlr.iwu = aVar3.UbS.readString();
                    AppMethodBeat.o(169219);
                    return 0;
                case 11:
                    dlr.MPl = aVar3.UbS.zi();
                    AppMethodBeat.o(169219);
                    return 0;
                case 12:
                    dlr.iwv = aVar3.UbS.readString();
                    AppMethodBeat.o(169219);
                    return 0;
                case 13:
                    dlr.iww = aVar3.UbS.readString();
                    AppMethodBeat.o(169219);
                    return 0;
                case 14:
                    dlr.iwx = aVar3.UbS.yZ();
                    AppMethodBeat.o(169219);
                    return 0;
                case 15:
                    dlr.iwy = aVar3.UbS.zi();
                    AppMethodBeat.o(169219);
                    return 0;
                default:
                    AppMethodBeat.o(169219);
                    return -1;
            }
        } else {
            AppMethodBeat.o(169219);
            return -1;
        }
    }
}
