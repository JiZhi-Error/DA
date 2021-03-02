package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class bmm extends a {
    public int KXD;
    public int LUr;
    public doo LVf;
    public boolean LVl;
    public boolean LVm;
    public String LVn;
    public int dIZ;
    public String md5;
    public String url;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(175245);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.dIZ);
            if (this.url != null) {
                aVar.e(2, this.url);
            }
            if (this.md5 != null) {
                aVar.e(3, this.md5);
            }
            aVar.aM(4, this.LUr);
            aVar.aM(5, this.KXD);
            aVar.cc(6, this.LVl);
            aVar.cc(7, this.LVm);
            if (this.LVf != null) {
                aVar.ni(20, this.LVf.computeSize());
                this.LVf.writeFields(aVar);
            }
            if (this.LVn != null) {
                aVar.e(21, this.LVn);
            }
            AppMethodBeat.o(175245);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.dIZ) + 0;
            if (this.url != null) {
                bu += g.a.a.b.b.a.f(2, this.url);
            }
            if (this.md5 != null) {
                bu += g.a.a.b.b.a.f(3, this.md5);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(4, this.LUr) + g.a.a.b.b.a.bu(5, this.KXD) + g.a.a.b.b.a.fS(6) + 1 + g.a.a.b.b.a.fS(7) + 1;
            if (this.LVf != null) {
                bu2 += g.a.a.a.nh(20, this.LVf.computeSize());
            }
            if (this.LVn != null) {
                bu2 += g.a.a.b.b.a.f(21, this.LVn);
            }
            AppMethodBeat.o(175245);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(175245);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bmm bmm = (bmm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bmm.dIZ = aVar3.UbS.zi();
                    AppMethodBeat.o(175245);
                    return 0;
                case 2:
                    bmm.url = aVar3.UbS.readString();
                    AppMethodBeat.o(175245);
                    return 0;
                case 3:
                    bmm.md5 = aVar3.UbS.readString();
                    AppMethodBeat.o(175245);
                    return 0;
                case 4:
                    bmm.LUr = aVar3.UbS.zi();
                    AppMethodBeat.o(175245);
                    return 0;
                case 5:
                    bmm.KXD = aVar3.UbS.zi();
                    AppMethodBeat.o(175245);
                    return 0;
                case 6:
                    bmm.LVl = aVar3.UbS.yZ();
                    AppMethodBeat.o(175245);
                    return 0;
                case 7:
                    bmm.LVm = aVar3.UbS.yZ();
                    AppMethodBeat.o(175245);
                    return 0;
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                default:
                    AppMethodBeat.o(175245);
                    return -1;
                case 20:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        doo doo = new doo();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = doo.populateBuilderWithField(aVar4, doo, a.getNextFieldNumber(aVar4))) {
                        }
                        bmm.LVf = doo;
                    }
                    AppMethodBeat.o(175245);
                    return 0;
                case 21:
                    bmm.LVn = aVar3.UbS.readString();
                    AppMethodBeat.o(175245);
                    return 0;
            }
        } else {
            AppMethodBeat.o(175245);
            return -1;
        }
    }
}
