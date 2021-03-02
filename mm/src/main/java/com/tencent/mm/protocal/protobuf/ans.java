package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ans extends a {
    public String Lhy;
    public long LyO;
    public long LyP;
    public long LyQ;
    public String LyR;
    public long LyS;
    public String LyT;
    public String LyU;
    public String LyV;
    public String LyW;
    public String LyX;
    public String LyY;
    public int LyZ;
    public String Lza;
    public int Lzb;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91460);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.LyO);
            aVar.bb(2, this.LyP);
            aVar.bb(3, this.LyQ);
            if (this.LyR != null) {
                aVar.e(4, this.LyR);
            }
            aVar.bb(5, this.LyS);
            if (this.LyT != null) {
                aVar.e(6, this.LyT);
            }
            if (this.LyU != null) {
                aVar.e(7, this.LyU);
            }
            if (this.LyV != null) {
                aVar.e(8, this.LyV);
            }
            if (this.LyW != null) {
                aVar.e(9, this.LyW);
            }
            if (this.LyX != null) {
                aVar.e(10, this.LyX);
            }
            if (this.LyY != null) {
                aVar.e(11, this.LyY);
            }
            aVar.aM(12, this.LyZ);
            if (this.Lza != null) {
                aVar.e(13, this.Lza);
            }
            aVar.aM(14, this.Lzb);
            if (this.Lhy != null) {
                aVar.e(15, this.Lhy);
            }
            AppMethodBeat.o(91460);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.LyO) + 0 + g.a.a.b.b.a.r(2, this.LyP) + g.a.a.b.b.a.r(3, this.LyQ);
            if (this.LyR != null) {
                r += g.a.a.b.b.a.f(4, this.LyR);
            }
            int r2 = r + g.a.a.b.b.a.r(5, this.LyS);
            if (this.LyT != null) {
                r2 += g.a.a.b.b.a.f(6, this.LyT);
            }
            if (this.LyU != null) {
                r2 += g.a.a.b.b.a.f(7, this.LyU);
            }
            if (this.LyV != null) {
                r2 += g.a.a.b.b.a.f(8, this.LyV);
            }
            if (this.LyW != null) {
                r2 += g.a.a.b.b.a.f(9, this.LyW);
            }
            if (this.LyX != null) {
                r2 += g.a.a.b.b.a.f(10, this.LyX);
            }
            if (this.LyY != null) {
                r2 += g.a.a.b.b.a.f(11, this.LyY);
            }
            int bu = r2 + g.a.a.b.b.a.bu(12, this.LyZ);
            if (this.Lza != null) {
                bu += g.a.a.b.b.a.f(13, this.Lza);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(14, this.Lzb);
            if (this.Lhy != null) {
                bu2 += g.a.a.b.b.a.f(15, this.Lhy);
            }
            AppMethodBeat.o(91460);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91460);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ans ans = (ans) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ans.LyO = aVar3.UbS.zl();
                    AppMethodBeat.o(91460);
                    return 0;
                case 2:
                    ans.LyP = aVar3.UbS.zl();
                    AppMethodBeat.o(91460);
                    return 0;
                case 3:
                    ans.LyQ = aVar3.UbS.zl();
                    AppMethodBeat.o(91460);
                    return 0;
                case 4:
                    ans.LyR = aVar3.UbS.readString();
                    AppMethodBeat.o(91460);
                    return 0;
                case 5:
                    ans.LyS = aVar3.UbS.zl();
                    AppMethodBeat.o(91460);
                    return 0;
                case 6:
                    ans.LyT = aVar3.UbS.readString();
                    AppMethodBeat.o(91460);
                    return 0;
                case 7:
                    ans.LyU = aVar3.UbS.readString();
                    AppMethodBeat.o(91460);
                    return 0;
                case 8:
                    ans.LyV = aVar3.UbS.readString();
                    AppMethodBeat.o(91460);
                    return 0;
                case 9:
                    ans.LyW = aVar3.UbS.readString();
                    AppMethodBeat.o(91460);
                    return 0;
                case 10:
                    ans.LyX = aVar3.UbS.readString();
                    AppMethodBeat.o(91460);
                    return 0;
                case 11:
                    ans.LyY = aVar3.UbS.readString();
                    AppMethodBeat.o(91460);
                    return 0;
                case 12:
                    ans.LyZ = aVar3.UbS.zi();
                    AppMethodBeat.o(91460);
                    return 0;
                case 13:
                    ans.Lza = aVar3.UbS.readString();
                    AppMethodBeat.o(91460);
                    return 0;
                case 14:
                    ans.Lzb = aVar3.UbS.zi();
                    AppMethodBeat.o(91460);
                    return 0;
                case 15:
                    ans.Lhy = aVar3.UbS.readString();
                    AppMethodBeat.o(91460);
                    return 0;
                default:
                    AppMethodBeat.o(91460);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91460);
            return -1;
        }
    }
}
