package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class dqb extends a {
    public String MSX;
    public String MSY;
    public b MSZ;
    public long MTa;
    public String MTb;
    public String MTc;
    public String MTd;
    public String Title;
    public String Username;
    public int rBX;
    public String xut;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(181512);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MSY != null) {
                aVar.e(1, this.MSY);
            }
            if (this.Username != null) {
                aVar.e(2, this.Username);
            }
            if (this.xut != null) {
                aVar.e(3, this.xut);
            }
            aVar.aM(4, this.rBX);
            if (this.MSZ != null) {
                aVar.c(5, this.MSZ);
            }
            if (this.Title != null) {
                aVar.e(6, this.Title);
            }
            if (this.MSX != null) {
                aVar.e(7, this.MSX);
            }
            aVar.bb(8, this.MTa);
            if (this.MTb != null) {
                aVar.e(9, this.MTb);
            }
            if (this.MTc != null) {
                aVar.e(10, this.MTc);
            }
            if (this.MTd != null) {
                aVar.e(11, this.MTd);
            }
            AppMethodBeat.o(181512);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.MSY != null ? g.a.a.b.b.a.f(1, this.MSY) + 0 : 0;
            if (this.Username != null) {
                f2 += g.a.a.b.b.a.f(2, this.Username);
            }
            if (this.xut != null) {
                f2 += g.a.a.b.b.a.f(3, this.xut);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.rBX);
            if (this.MSZ != null) {
                bu += g.a.a.b.b.a.b(5, this.MSZ);
            }
            if (this.Title != null) {
                bu += g.a.a.b.b.a.f(6, this.Title);
            }
            if (this.MSX != null) {
                bu += g.a.a.b.b.a.f(7, this.MSX);
            }
            int r = bu + g.a.a.b.b.a.r(8, this.MTa);
            if (this.MTb != null) {
                r += g.a.a.b.b.a.f(9, this.MTb);
            }
            if (this.MTc != null) {
                r += g.a.a.b.b.a.f(10, this.MTc);
            }
            if (this.MTd != null) {
                r += g.a.a.b.b.a.f(11, this.MTd);
            }
            AppMethodBeat.o(181512);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(181512);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dqb dqb = (dqb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dqb.MSY = aVar3.UbS.readString();
                    AppMethodBeat.o(181512);
                    return 0;
                case 2:
                    dqb.Username = aVar3.UbS.readString();
                    AppMethodBeat.o(181512);
                    return 0;
                case 3:
                    dqb.xut = aVar3.UbS.readString();
                    AppMethodBeat.o(181512);
                    return 0;
                case 4:
                    dqb.rBX = aVar3.UbS.zi();
                    AppMethodBeat.o(181512);
                    return 0;
                case 5:
                    dqb.MSZ = aVar3.UbS.hPo();
                    AppMethodBeat.o(181512);
                    return 0;
                case 6:
                    dqb.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(181512);
                    return 0;
                case 7:
                    dqb.MSX = aVar3.UbS.readString();
                    AppMethodBeat.o(181512);
                    return 0;
                case 8:
                    dqb.MTa = aVar3.UbS.zl();
                    AppMethodBeat.o(181512);
                    return 0;
                case 9:
                    dqb.MTb = aVar3.UbS.readString();
                    AppMethodBeat.o(181512);
                    return 0;
                case 10:
                    dqb.MTc = aVar3.UbS.readString();
                    AppMethodBeat.o(181512);
                    return 0;
                case 11:
                    dqb.MTd = aVar3.UbS.readString();
                    AppMethodBeat.o(181512);
                    return 0;
                default:
                    AppMethodBeat.o(181512);
                    return -1;
            }
        } else {
            AppMethodBeat.o(181512);
            return -1;
        }
    }
}
