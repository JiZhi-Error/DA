package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class axy extends a {
    public String AqO;
    public String BPc;
    public String Djf;
    public String LIf;
    public String LIg;
    public String LIh;
    public String LIi;
    public String LIj;
    public long LIk;
    public String albumName;
    public int duration;
    public String extraInfo;
    public String identification;
    public String lDR;
    public String musicDataUrl;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209579);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.BPc != null) {
                aVar.e(1, this.BPc);
            }
            if (this.lDR != null) {
                aVar.e(2, this.lDR);
            }
            if (this.musicDataUrl != null) {
                aVar.e(3, this.musicDataUrl);
            }
            if (this.LIf != null) {
                aVar.e(4, this.LIf);
            }
            if (this.LIg != null) {
                aVar.e(5, this.LIg);
            }
            if (this.AqO != null) {
                aVar.e(6, this.AqO);
            }
            if (this.LIh != null) {
                aVar.e(7, this.LIh);
            }
            if (this.albumName != null) {
                aVar.e(8, this.albumName);
            }
            if (this.Djf != null) {
                aVar.e(9, this.Djf);
            }
            if (this.LIi != null) {
                aVar.e(10, this.LIi);
            }
            if (this.LIj != null) {
                aVar.e(11, this.LIj);
            }
            aVar.bb(12, this.LIk);
            if (this.extraInfo != null) {
                aVar.e(13, this.extraInfo);
            }
            if (this.identification != null) {
                aVar.e(14, this.identification);
            }
            aVar.aM(15, this.duration);
            AppMethodBeat.o(209579);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.BPc != null ? g.a.a.b.b.a.f(1, this.BPc) + 0 : 0;
            if (this.lDR != null) {
                f2 += g.a.a.b.b.a.f(2, this.lDR);
            }
            if (this.musicDataUrl != null) {
                f2 += g.a.a.b.b.a.f(3, this.musicDataUrl);
            }
            if (this.LIf != null) {
                f2 += g.a.a.b.b.a.f(4, this.LIf);
            }
            if (this.LIg != null) {
                f2 += g.a.a.b.b.a.f(5, this.LIg);
            }
            if (this.AqO != null) {
                f2 += g.a.a.b.b.a.f(6, this.AqO);
            }
            if (this.LIh != null) {
                f2 += g.a.a.b.b.a.f(7, this.LIh);
            }
            if (this.albumName != null) {
                f2 += g.a.a.b.b.a.f(8, this.albumName);
            }
            if (this.Djf != null) {
                f2 += g.a.a.b.b.a.f(9, this.Djf);
            }
            if (this.LIi != null) {
                f2 += g.a.a.b.b.a.f(10, this.LIi);
            }
            if (this.LIj != null) {
                f2 += g.a.a.b.b.a.f(11, this.LIj);
            }
            int r = f2 + g.a.a.b.b.a.r(12, this.LIk);
            if (this.extraInfo != null) {
                r += g.a.a.b.b.a.f(13, this.extraInfo);
            }
            if (this.identification != null) {
                r += g.a.a.b.b.a.f(14, this.identification);
            }
            int bu = r + g.a.a.b.b.a.bu(15, this.duration);
            AppMethodBeat.o(209579);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209579);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            axy axy = (axy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    axy.BPc = aVar3.UbS.readString();
                    AppMethodBeat.o(209579);
                    return 0;
                case 2:
                    axy.lDR = aVar3.UbS.readString();
                    AppMethodBeat.o(209579);
                    return 0;
                case 3:
                    axy.musicDataUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(209579);
                    return 0;
                case 4:
                    axy.LIf = aVar3.UbS.readString();
                    AppMethodBeat.o(209579);
                    return 0;
                case 5:
                    axy.LIg = aVar3.UbS.readString();
                    AppMethodBeat.o(209579);
                    return 0;
                case 6:
                    axy.AqO = aVar3.UbS.readString();
                    AppMethodBeat.o(209579);
                    return 0;
                case 7:
                    axy.LIh = aVar3.UbS.readString();
                    AppMethodBeat.o(209579);
                    return 0;
                case 8:
                    axy.albumName = aVar3.UbS.readString();
                    AppMethodBeat.o(209579);
                    return 0;
                case 9:
                    axy.Djf = aVar3.UbS.readString();
                    AppMethodBeat.o(209579);
                    return 0;
                case 10:
                    axy.LIi = aVar3.UbS.readString();
                    AppMethodBeat.o(209579);
                    return 0;
                case 11:
                    axy.LIj = aVar3.UbS.readString();
                    AppMethodBeat.o(209579);
                    return 0;
                case 12:
                    axy.LIk = aVar3.UbS.zl();
                    AppMethodBeat.o(209579);
                    return 0;
                case 13:
                    axy.extraInfo = aVar3.UbS.readString();
                    AppMethodBeat.o(209579);
                    return 0;
                case 14:
                    axy.identification = aVar3.UbS.readString();
                    AppMethodBeat.o(209579);
                    return 0;
                case 15:
                    axy.duration = aVar3.UbS.zi();
                    AppMethodBeat.o(209579);
                    return 0;
                default:
                    AppMethodBeat.o(209579);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209579);
            return -1;
        }
    }
}
