package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class m extends a {
    public String KBG;
    public String KBH;
    public String KBI;
    public String KBs;
    public String KBt;
    public long eht;
    public int role;
    public int state;
    public String title;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91322);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KBs != null) {
                aVar.e(1, this.KBs);
            }
            if (this.title != null) {
                aVar.e(2, this.title);
            }
            aVar.bb(3, this.eht);
            if (this.KBG != null) {
                aVar.e(5, this.KBG);
            }
            aVar.aM(10, this.state);
            aVar.aM(11, this.role);
            if (this.KBH != null) {
                aVar.e(12, this.KBH);
            }
            if (this.KBt != null) {
                aVar.e(13, this.KBt);
            }
            if (this.KBI != null) {
                aVar.e(14, this.KBI);
            }
            AppMethodBeat.o(91322);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.KBs != null ? g.a.a.b.b.a.f(1, this.KBs) + 0 : 0;
            if (this.title != null) {
                f2 += g.a.a.b.b.a.f(2, this.title);
            }
            int r = f2 + g.a.a.b.b.a.r(3, this.eht);
            if (this.KBG != null) {
                r += g.a.a.b.b.a.f(5, this.KBG);
            }
            int bu = r + g.a.a.b.b.a.bu(10, this.state) + g.a.a.b.b.a.bu(11, this.role);
            if (this.KBH != null) {
                bu += g.a.a.b.b.a.f(12, this.KBH);
            }
            if (this.KBt != null) {
                bu += g.a.a.b.b.a.f(13, this.KBt);
            }
            if (this.KBI != null) {
                bu += g.a.a.b.b.a.f(14, this.KBI);
            }
            AppMethodBeat.o(91322);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91322);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            m mVar = (m) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    mVar.KBs = aVar3.UbS.readString();
                    AppMethodBeat.o(91322);
                    return 0;
                case 2:
                    mVar.title = aVar3.UbS.readString();
                    AppMethodBeat.o(91322);
                    return 0;
                case 3:
                    mVar.eht = aVar3.UbS.zl();
                    AppMethodBeat.o(91322);
                    return 0;
                case 4:
                case 6:
                case 7:
                case 8:
                case 9:
                default:
                    AppMethodBeat.o(91322);
                    return -1;
                case 5:
                    mVar.KBG = aVar3.UbS.readString();
                    AppMethodBeat.o(91322);
                    return 0;
                case 10:
                    mVar.state = aVar3.UbS.zi();
                    AppMethodBeat.o(91322);
                    return 0;
                case 11:
                    mVar.role = aVar3.UbS.zi();
                    AppMethodBeat.o(91322);
                    return 0;
                case 12:
                    mVar.KBH = aVar3.UbS.readString();
                    AppMethodBeat.o(91322);
                    return 0;
                case 13:
                    mVar.KBt = aVar3.UbS.readString();
                    AppMethodBeat.o(91322);
                    return 0;
                case 14:
                    mVar.KBI = aVar3.UbS.readString();
                    AppMethodBeat.o(91322);
                    return 0;
            }
        } else {
            AppMethodBeat.o(91322);
            return -1;
        }
    }
}
