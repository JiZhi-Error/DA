package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ccd extends a {
    public String KMl;
    public String LbJ;
    public String Md5;
    public String Name;
    public String Type;
    public String Url;
    public int oUq;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32323);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Type != null) {
                aVar.e(1, this.Type);
            }
            if (this.Name != null) {
                aVar.e(2, this.Name);
            }
            aVar.aM(3, this.oUq);
            if (this.Md5 != null) {
                aVar.e(4, this.Md5);
            }
            if (this.KMl != null) {
                aVar.e(5, this.KMl);
            }
            if (this.LbJ != null) {
                aVar.e(6, this.LbJ);
            }
            if (this.Url != null) {
                aVar.e(7, this.Url);
            }
            AppMethodBeat.o(32323);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Type != null ? g.a.a.b.b.a.f(1, this.Type) + 0 : 0;
            if (this.Name != null) {
                f2 += g.a.a.b.b.a.f(2, this.Name);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.oUq);
            if (this.Md5 != null) {
                bu += g.a.a.b.b.a.f(4, this.Md5);
            }
            if (this.KMl != null) {
                bu += g.a.a.b.b.a.f(5, this.KMl);
            }
            if (this.LbJ != null) {
                bu += g.a.a.b.b.a.f(6, this.LbJ);
            }
            if (this.Url != null) {
                bu += g.a.a.b.b.a.f(7, this.Url);
            }
            AppMethodBeat.o(32323);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32323);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ccd ccd = (ccd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ccd.Type = aVar3.UbS.readString();
                    AppMethodBeat.o(32323);
                    return 0;
                case 2:
                    ccd.Name = aVar3.UbS.readString();
                    AppMethodBeat.o(32323);
                    return 0;
                case 3:
                    ccd.oUq = aVar3.UbS.zi();
                    AppMethodBeat.o(32323);
                    return 0;
                case 4:
                    ccd.Md5 = aVar3.UbS.readString();
                    AppMethodBeat.o(32323);
                    return 0;
                case 5:
                    ccd.KMl = aVar3.UbS.readString();
                    AppMethodBeat.o(32323);
                    return 0;
                case 6:
                    ccd.LbJ = aVar3.UbS.readString();
                    AppMethodBeat.o(32323);
                    return 0;
                case 7:
                    ccd.Url = aVar3.UbS.readString();
                    AppMethodBeat.o(32323);
                    return 0;
                default:
                    AppMethodBeat.o(32323);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32323);
            return -1;
        }
    }
}
