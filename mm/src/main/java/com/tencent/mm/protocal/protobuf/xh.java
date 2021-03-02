package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class xh extends a {
    public String LiA;
    public String LiB;
    public int LiC;
    public String LiD;
    public String LiE;
    public String LiF;
    public String Liq;
    public String Lir;
    public String Lis;
    public int Lit;
    public String Liu;
    public String Liv;
    public String Liw;
    public String Lix;
    public String Liy;
    public String Liz;
    public String UserName;
    public String oUJ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(43087);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.UserName != null) {
                aVar.e(1, this.UserName);
            }
            if (this.oUJ != null) {
                aVar.e(2, this.oUJ);
            }
            if (this.Liq != null) {
                aVar.e(3, this.Liq);
            }
            if (this.Lir != null) {
                aVar.e(4, this.Lir);
            }
            if (this.Lis != null) {
                aVar.e(5, this.Lis);
            }
            aVar.aM(6, this.Lit);
            if (this.Liu != null) {
                aVar.e(7, this.Liu);
            }
            if (this.Liv != null) {
                aVar.e(9, this.Liv);
            }
            if (this.Liw != null) {
                aVar.e(10, this.Liw);
            }
            if (this.Lix != null) {
                aVar.e(11, this.Lix);
            }
            if (this.Liy != null) {
                aVar.e(12, this.Liy);
            }
            if (this.Liz != null) {
                aVar.e(13, this.Liz);
            }
            if (this.LiA != null) {
                aVar.e(14, this.LiA);
            }
            if (this.LiB != null) {
                aVar.e(15, this.LiB);
            }
            aVar.aM(16, this.LiC);
            if (this.LiD != null) {
                aVar.e(17, this.LiD);
            }
            if (this.LiE != null) {
                aVar.e(18, this.LiE);
            }
            if (this.LiF != null) {
                aVar.e(19, this.LiF);
            }
            AppMethodBeat.o(43087);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.UserName != null ? g.a.a.b.b.a.f(1, this.UserName) + 0 : 0;
            if (this.oUJ != null) {
                f2 += g.a.a.b.b.a.f(2, this.oUJ);
            }
            if (this.Liq != null) {
                f2 += g.a.a.b.b.a.f(3, this.Liq);
            }
            if (this.Lir != null) {
                f2 += g.a.a.b.b.a.f(4, this.Lir);
            }
            if (this.Lis != null) {
                f2 += g.a.a.b.b.a.f(5, this.Lis);
            }
            int bu = f2 + g.a.a.b.b.a.bu(6, this.Lit);
            if (this.Liu != null) {
                bu += g.a.a.b.b.a.f(7, this.Liu);
            }
            if (this.Liv != null) {
                bu += g.a.a.b.b.a.f(9, this.Liv);
            }
            if (this.Liw != null) {
                bu += g.a.a.b.b.a.f(10, this.Liw);
            }
            if (this.Lix != null) {
                bu += g.a.a.b.b.a.f(11, this.Lix);
            }
            if (this.Liy != null) {
                bu += g.a.a.b.b.a.f(12, this.Liy);
            }
            if (this.Liz != null) {
                bu += g.a.a.b.b.a.f(13, this.Liz);
            }
            if (this.LiA != null) {
                bu += g.a.a.b.b.a.f(14, this.LiA);
            }
            if (this.LiB != null) {
                bu += g.a.a.b.b.a.f(15, this.LiB);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(16, this.LiC);
            if (this.LiD != null) {
                bu2 += g.a.a.b.b.a.f(17, this.LiD);
            }
            if (this.LiE != null) {
                bu2 += g.a.a.b.b.a.f(18, this.LiE);
            }
            if (this.LiF != null) {
                bu2 += g.a.a.b.b.a.f(19, this.LiF);
            }
            AppMethodBeat.o(43087);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(43087);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            xh xhVar = (xh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    xhVar.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(43087);
                    return 0;
                case 2:
                    xhVar.oUJ = aVar3.UbS.readString();
                    AppMethodBeat.o(43087);
                    return 0;
                case 3:
                    xhVar.Liq = aVar3.UbS.readString();
                    AppMethodBeat.o(43087);
                    return 0;
                case 4:
                    xhVar.Lir = aVar3.UbS.readString();
                    AppMethodBeat.o(43087);
                    return 0;
                case 5:
                    xhVar.Lis = aVar3.UbS.readString();
                    AppMethodBeat.o(43087);
                    return 0;
                case 6:
                    xhVar.Lit = aVar3.UbS.zi();
                    AppMethodBeat.o(43087);
                    return 0;
                case 7:
                    xhVar.Liu = aVar3.UbS.readString();
                    AppMethodBeat.o(43087);
                    return 0;
                case 8:
                default:
                    AppMethodBeat.o(43087);
                    return -1;
                case 9:
                    xhVar.Liv = aVar3.UbS.readString();
                    AppMethodBeat.o(43087);
                    return 0;
                case 10:
                    xhVar.Liw = aVar3.UbS.readString();
                    AppMethodBeat.o(43087);
                    return 0;
                case 11:
                    xhVar.Lix = aVar3.UbS.readString();
                    AppMethodBeat.o(43087);
                    return 0;
                case 12:
                    xhVar.Liy = aVar3.UbS.readString();
                    AppMethodBeat.o(43087);
                    return 0;
                case 13:
                    xhVar.Liz = aVar3.UbS.readString();
                    AppMethodBeat.o(43087);
                    return 0;
                case 14:
                    xhVar.LiA = aVar3.UbS.readString();
                    AppMethodBeat.o(43087);
                    return 0;
                case 15:
                    xhVar.LiB = aVar3.UbS.readString();
                    AppMethodBeat.o(43087);
                    return 0;
                case 16:
                    xhVar.LiC = aVar3.UbS.zi();
                    AppMethodBeat.o(43087);
                    return 0;
                case 17:
                    xhVar.LiD = aVar3.UbS.readString();
                    AppMethodBeat.o(43087);
                    return 0;
                case 18:
                    xhVar.LiE = aVar3.UbS.readString();
                    AppMethodBeat.o(43087);
                    return 0;
                case 19:
                    xhVar.LiF = aVar3.UbS.readString();
                    AppMethodBeat.o(43087);
                    return 0;
            }
        } else {
            AppMethodBeat.o(43087);
            return -1;
        }
    }
}
