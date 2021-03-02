package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ebd extends dop {
    public SKBuiltinBuffer_t MYJ;
    public int MYL;
    public String MZg;
    public long MZh;
    public int NaA;
    public long NaB;
    public long NaC;
    public long NaD;
    public int NaE;
    public long NaF;
    public long Nau;
    public int Nav;
    public long Naw;
    public int Nax;
    public LinkedList<Long> Nay = new LinkedList<>();
    public int Naz;

    public ebd() {
        AppMethodBeat.i(125826);
        AppMethodBeat.o(125826);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125827);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.MZg != null) {
                aVar.e(2, this.MZg);
            }
            aVar.bb(3, this.MZh);
            aVar.bb(4, this.Nau);
            aVar.aM(5, this.Nav);
            aVar.bb(6, this.Naw);
            if (this.MYJ != null) {
                aVar.ni(7, this.MYJ.computeSize());
                this.MYJ.writeFields(aVar);
            }
            aVar.aM(8, this.MYL);
            aVar.aM(11, this.Nax);
            aVar.f(12, 3, this.Nay);
            aVar.aM(13, this.Naz);
            aVar.aM(14, this.NaA);
            aVar.bb(15, this.NaB);
            aVar.bb(16, this.NaC);
            aVar.bb(17, this.NaD);
            aVar.aM(18, this.NaE);
            aVar.bb(19, this.NaF);
            AppMethodBeat.o(125827);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.MZg != null) {
                nh += g.a.a.b.b.a.f(2, this.MZg);
            }
            int r = nh + g.a.a.b.b.a.r(3, this.MZh) + g.a.a.b.b.a.r(4, this.Nau) + g.a.a.b.b.a.bu(5, this.Nav) + g.a.a.b.b.a.r(6, this.Naw);
            if (this.MYJ != null) {
                r += g.a.a.a.nh(7, this.MYJ.computeSize());
            }
            int bu = r + g.a.a.b.b.a.bu(8, this.MYL) + g.a.a.b.b.a.bu(11, this.Nax) + g.a.a.a.d(12, 3, this.Nay) + g.a.a.b.b.a.bu(13, this.Naz) + g.a.a.b.b.a.bu(14, this.NaA) + g.a.a.b.b.a.r(15, this.NaB) + g.a.a.b.b.a.r(16, this.NaC) + g.a.a.b.b.a.r(17, this.NaD) + g.a.a.b.b.a.bu(18, this.NaE) + g.a.a.b.b.a.r(19, this.NaF);
            AppMethodBeat.o(125827);
            return bu;
        } else if (i2 == 2) {
            this.Nay.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(125827);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ebd ebd = (ebd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        jr jrVar = new jr();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = jrVar.populateBuilderWithField(aVar4, jrVar, dop.getNextFieldNumber(aVar4))) {
                        }
                        ebd.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(125827);
                    return 0;
                case 2:
                    ebd.MZg = aVar3.UbS.readString();
                    AppMethodBeat.o(125827);
                    return 0;
                case 3:
                    ebd.MZh = aVar3.UbS.zl();
                    AppMethodBeat.o(125827);
                    return 0;
                case 4:
                    ebd.Nau = aVar3.UbS.zl();
                    AppMethodBeat.o(125827);
                    return 0;
                case 5:
                    ebd.Nav = aVar3.UbS.zi();
                    AppMethodBeat.o(125827);
                    return 0;
                case 6:
                    ebd.Naw = aVar3.UbS.zl();
                    AppMethodBeat.o(125827);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t.populateBuilderWithField(aVar5, sKBuiltinBuffer_t, dop.getNextFieldNumber(aVar5))) {
                        }
                        ebd.MYJ = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(125827);
                    return 0;
                case 8:
                    ebd.MYL = aVar3.UbS.zi();
                    AppMethodBeat.o(125827);
                    return 0;
                case 9:
                case 10:
                default:
                    AppMethodBeat.o(125827);
                    return -1;
                case 11:
                    ebd.Nax = aVar3.UbS.zi();
                    AppMethodBeat.o(125827);
                    return 0;
                case 12:
                    ebd.Nay = new g.a.a.a.a(aVar3.UbS.hPo().zy, unknownTagHandler).UbS.hPn();
                    AppMethodBeat.o(125827);
                    return 0;
                case 13:
                    ebd.Naz = aVar3.UbS.zi();
                    AppMethodBeat.o(125827);
                    return 0;
                case 14:
                    ebd.NaA = aVar3.UbS.zi();
                    AppMethodBeat.o(125827);
                    return 0;
                case 15:
                    ebd.NaB = aVar3.UbS.zl();
                    AppMethodBeat.o(125827);
                    return 0;
                case 16:
                    ebd.NaC = aVar3.UbS.zl();
                    AppMethodBeat.o(125827);
                    return 0;
                case 17:
                    ebd.NaD = aVar3.UbS.zl();
                    AppMethodBeat.o(125827);
                    return 0;
                case 18:
                    ebd.NaE = aVar3.UbS.zi();
                    AppMethodBeat.o(125827);
                    return 0;
                case 19:
                    ebd.NaF = aVar3.UbS.zl();
                    AppMethodBeat.o(125827);
                    return 0;
            }
        } else {
            AppMethodBeat.o(125827);
            return -1;
        }
    }
}
