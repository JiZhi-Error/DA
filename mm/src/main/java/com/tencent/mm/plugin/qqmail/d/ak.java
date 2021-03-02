package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ak extends a {
    public String BsJ;
    public String code;
    public String fileid;
    public String key;
    public String name;
    public int size;
    public String type;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(198627);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.fileid != null) {
                aVar.e(1, this.fileid);
            }
            if (this.name != null) {
                aVar.e(2, this.name);
            }
            aVar.aM(3, this.size);
            if (this.type != null) {
                aVar.e(4, this.type);
            }
            if (this.BsJ != null) {
                aVar.e(5, this.BsJ);
            }
            if (this.key != null) {
                aVar.e(6, this.key);
            }
            if (this.code != null) {
                aVar.e(7, this.code);
            }
            AppMethodBeat.o(198627);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.fileid != null ? g.a.a.b.b.a.f(1, this.fileid) + 0 : 0;
            if (this.name != null) {
                f2 += g.a.a.b.b.a.f(2, this.name);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.size);
            if (this.type != null) {
                bu += g.a.a.b.b.a.f(4, this.type);
            }
            if (this.BsJ != null) {
                bu += g.a.a.b.b.a.f(5, this.BsJ);
            }
            if (this.key != null) {
                bu += g.a.a.b.b.a.f(6, this.key);
            }
            if (this.code != null) {
                bu += g.a.a.b.b.a.f(7, this.code);
            }
            AppMethodBeat.o(198627);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(198627);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ak akVar = (ak) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    akVar.fileid = aVar3.UbS.readString();
                    AppMethodBeat.o(198627);
                    return 0;
                case 2:
                    akVar.name = aVar3.UbS.readString();
                    AppMethodBeat.o(198627);
                    return 0;
                case 3:
                    akVar.size = aVar3.UbS.zi();
                    AppMethodBeat.o(198627);
                    return 0;
                case 4:
                    akVar.type = aVar3.UbS.readString();
                    AppMethodBeat.o(198627);
                    return 0;
                case 5:
                    akVar.BsJ = aVar3.UbS.readString();
                    AppMethodBeat.o(198627);
                    return 0;
                case 6:
                    akVar.key = aVar3.UbS.readString();
                    AppMethodBeat.o(198627);
                    return 0;
                case 7:
                    akVar.code = aVar3.UbS.readString();
                    AppMethodBeat.o(198627);
                    return 0;
                default:
                    AppMethodBeat.o(198627);
                    return -1;
            }
        } else {
            AppMethodBeat.o(198627);
            return -1;
        }
    }
}
