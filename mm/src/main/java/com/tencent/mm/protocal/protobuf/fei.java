package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class fei extends a {
    public String IconUrl;
    public String KHk;
    public int KSa;
    public String MUT;
    public b MVf;
    public float NzA;
    public int NzB;
    public String NzC;
    public float Nzz;
    public String UserName;
    public String jfi;
    public String oUJ;
    public String xut;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117960);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MUT != null) {
                aVar.e(1, this.MUT);
            }
            if (this.oUJ != null) {
                aVar.e(2, this.oUJ);
            }
            if (this.IconUrl != null) {
                aVar.e(3, this.IconUrl);
            }
            if (this.UserName != null) {
                aVar.e(4, this.UserName);
            }
            aVar.aM(5, this.KSa);
            if (this.KHk != null) {
                aVar.e(6, this.KHk);
            }
            if (this.xut != null) {
                aVar.e(7, this.xut);
            }
            aVar.E(8, this.Nzz);
            aVar.E(9, this.NzA);
            aVar.aM(10, this.NzB);
            if (this.jfi != null) {
                aVar.e(11, this.jfi);
            }
            if (this.NzC != null) {
                aVar.e(12, this.NzC);
            }
            if (this.MVf != null) {
                aVar.c(13, this.MVf);
            }
            AppMethodBeat.o(117960);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.MUT != null ? g.a.a.b.b.a.f(1, this.MUT) + 0 : 0;
            if (this.oUJ != null) {
                f2 += g.a.a.b.b.a.f(2, this.oUJ);
            }
            if (this.IconUrl != null) {
                f2 += g.a.a.b.b.a.f(3, this.IconUrl);
            }
            if (this.UserName != null) {
                f2 += g.a.a.b.b.a.f(4, this.UserName);
            }
            int bu = f2 + g.a.a.b.b.a.bu(5, this.KSa);
            if (this.KHk != null) {
                bu += g.a.a.b.b.a.f(6, this.KHk);
            }
            if (this.xut != null) {
                bu += g.a.a.b.b.a.f(7, this.xut);
            }
            int fS = bu + g.a.a.b.b.a.fS(8) + 4 + g.a.a.b.b.a.fS(9) + 4 + g.a.a.b.b.a.bu(10, this.NzB);
            if (this.jfi != null) {
                fS += g.a.a.b.b.a.f(11, this.jfi);
            }
            if (this.NzC != null) {
                fS += g.a.a.b.b.a.f(12, this.NzC);
            }
            if (this.MVf != null) {
                fS += g.a.a.b.b.a.b(13, this.MVf);
            }
            AppMethodBeat.o(117960);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(117960);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fei fei = (fei) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    fei.MUT = aVar3.UbS.readString();
                    AppMethodBeat.o(117960);
                    return 0;
                case 2:
                    fei.oUJ = aVar3.UbS.readString();
                    AppMethodBeat.o(117960);
                    return 0;
                case 3:
                    fei.IconUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(117960);
                    return 0;
                case 4:
                    fei.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(117960);
                    return 0;
                case 5:
                    fei.KSa = aVar3.UbS.zi();
                    AppMethodBeat.o(117960);
                    return 0;
                case 6:
                    fei.KHk = aVar3.UbS.readString();
                    AppMethodBeat.o(117960);
                    return 0;
                case 7:
                    fei.xut = aVar3.UbS.readString();
                    AppMethodBeat.o(117960);
                    return 0;
                case 8:
                    fei.Nzz = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(117960);
                    return 0;
                case 9:
                    fei.NzA = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(117960);
                    return 0;
                case 10:
                    fei.NzB = aVar3.UbS.zi();
                    AppMethodBeat.o(117960);
                    return 0;
                case 11:
                    fei.jfi = aVar3.UbS.readString();
                    AppMethodBeat.o(117960);
                    return 0;
                case 12:
                    fei.NzC = aVar3.UbS.readString();
                    AppMethodBeat.o(117960);
                    return 0;
                case 13:
                    fei.MVf = aVar3.UbS.hPo();
                    AppMethodBeat.o(117960);
                    return 0;
                default:
                    AppMethodBeat.o(117960);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117960);
            return -1;
        }
    }
}
