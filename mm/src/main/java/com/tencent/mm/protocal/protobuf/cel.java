package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cel extends a {
    public LinkedList<String> LxM = new LinkedList<>();
    public int MjU;
    public int MjV;
    public String MjW;
    public String md5;
    public String name;
    public String url;

    public cel() {
        AppMethodBeat.i(82447);
        AppMethodBeat.o(82447);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(82448);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.name != null) {
                aVar.e(1, this.name);
            }
            if (this.url != null) {
                aVar.e(2, this.url);
            }
            if (this.md5 != null) {
                aVar.e(3, this.md5);
            }
            aVar.e(4, 1, this.LxM);
            aVar.aM(5, this.MjU);
            aVar.aM(6, this.MjV);
            if (this.MjW != null) {
                aVar.e(7, this.MjW);
            }
            AppMethodBeat.o(82448);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.name != null ? g.a.a.b.b.a.f(1, this.name) + 0 : 0;
            if (this.url != null) {
                f2 += g.a.a.b.b.a.f(2, this.url);
            }
            if (this.md5 != null) {
                f2 += g.a.a.b.b.a.f(3, this.md5);
            }
            int c2 = f2 + g.a.a.a.c(4, 1, this.LxM) + g.a.a.b.b.a.bu(5, this.MjU) + g.a.a.b.b.a.bu(6, this.MjV);
            if (this.MjW != null) {
                c2 += g.a.a.b.b.a.f(7, this.MjW);
            }
            AppMethodBeat.o(82448);
            return c2;
        } else if (i2 == 2) {
            this.LxM.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(82448);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cel cel = (cel) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cel.name = aVar3.UbS.readString();
                    AppMethodBeat.o(82448);
                    return 0;
                case 2:
                    cel.url = aVar3.UbS.readString();
                    AppMethodBeat.o(82448);
                    return 0;
                case 3:
                    cel.md5 = aVar3.UbS.readString();
                    AppMethodBeat.o(82448);
                    return 0;
                case 4:
                    cel.LxM.add(aVar3.UbS.readString());
                    AppMethodBeat.o(82448);
                    return 0;
                case 5:
                    cel.MjU = aVar3.UbS.zi();
                    AppMethodBeat.o(82448);
                    return 0;
                case 6:
                    cel.MjV = aVar3.UbS.zi();
                    AppMethodBeat.o(82448);
                    return 0;
                case 7:
                    cel.MjW = aVar3.UbS.readString();
                    AppMethodBeat.o(82448);
                    return 0;
                default:
                    AppMethodBeat.o(82448);
                    return -1;
            }
        } else {
            AppMethodBeat.o(82448);
            return -1;
        }
    }
}
