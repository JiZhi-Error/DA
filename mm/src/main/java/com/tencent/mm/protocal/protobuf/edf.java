package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class edf extends a {
    public int CreateTime;
    public long Id;
    public int IsNotRichText;
    public int MYS;
    public int MYT;
    public int MYX;
    public String NdA;
    public String NdB;
    public int NdC;
    public int NdD;
    public int NdE;
    public String ThumbUrl;
    public String iAc;
    public String xNG;
    public String xNH;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(118438);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.Id);
            if (this.xNH != null) {
                aVar.e(2, this.xNH);
            }
            if (this.xNG != null) {
                aVar.e(3, this.xNG);
            }
            if (this.NdA != null) {
                aVar.e(4, this.NdA);
            }
            if (this.NdB != null) {
                aVar.e(5, this.NdB);
            }
            aVar.aM(6, this.CreateTime);
            if (this.iAc != null) {
                aVar.e(7, this.iAc);
            }
            aVar.aM(8, this.NdC);
            aVar.aM(9, this.MYX);
            aVar.aM(10, this.MYS);
            aVar.aM(11, this.MYT);
            aVar.aM(12, this.IsNotRichText);
            if (this.ThumbUrl != null) {
                aVar.e(13, this.ThumbUrl);
            }
            aVar.aM(14, this.NdD);
            aVar.aM(15, this.NdE);
            AppMethodBeat.o(118438);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.Id) + 0;
            if (this.xNH != null) {
                r += g.a.a.b.b.a.f(2, this.xNH);
            }
            if (this.xNG != null) {
                r += g.a.a.b.b.a.f(3, this.xNG);
            }
            if (this.NdA != null) {
                r += g.a.a.b.b.a.f(4, this.NdA);
            }
            if (this.NdB != null) {
                r += g.a.a.b.b.a.f(5, this.NdB);
            }
            int bu = r + g.a.a.b.b.a.bu(6, this.CreateTime);
            if (this.iAc != null) {
                bu += g.a.a.b.b.a.f(7, this.iAc);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(8, this.NdC) + g.a.a.b.b.a.bu(9, this.MYX) + g.a.a.b.b.a.bu(10, this.MYS) + g.a.a.b.b.a.bu(11, this.MYT) + g.a.a.b.b.a.bu(12, this.IsNotRichText);
            if (this.ThumbUrl != null) {
                bu2 += g.a.a.b.b.a.f(13, this.ThumbUrl);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(14, this.NdD) + g.a.a.b.b.a.bu(15, this.NdE);
            AppMethodBeat.o(118438);
            return bu3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(118438);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            edf edf = (edf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    edf.Id = aVar3.UbS.zl();
                    AppMethodBeat.o(118438);
                    return 0;
                case 2:
                    edf.xNH = aVar3.UbS.readString();
                    AppMethodBeat.o(118438);
                    return 0;
                case 3:
                    edf.xNG = aVar3.UbS.readString();
                    AppMethodBeat.o(118438);
                    return 0;
                case 4:
                    edf.NdA = aVar3.UbS.readString();
                    AppMethodBeat.o(118438);
                    return 0;
                case 5:
                    edf.NdB = aVar3.UbS.readString();
                    AppMethodBeat.o(118438);
                    return 0;
                case 6:
                    edf.CreateTime = aVar3.UbS.zi();
                    AppMethodBeat.o(118438);
                    return 0;
                case 7:
                    edf.iAc = aVar3.UbS.readString();
                    AppMethodBeat.o(118438);
                    return 0;
                case 8:
                    edf.NdC = aVar3.UbS.zi();
                    AppMethodBeat.o(118438);
                    return 0;
                case 9:
                    edf.MYX = aVar3.UbS.zi();
                    AppMethodBeat.o(118438);
                    return 0;
                case 10:
                    edf.MYS = aVar3.UbS.zi();
                    AppMethodBeat.o(118438);
                    return 0;
                case 11:
                    edf.MYT = aVar3.UbS.zi();
                    AppMethodBeat.o(118438);
                    return 0;
                case 12:
                    edf.IsNotRichText = aVar3.UbS.zi();
                    AppMethodBeat.o(118438);
                    return 0;
                case 13:
                    edf.ThumbUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(118438);
                    return 0;
                case 14:
                    edf.NdD = aVar3.UbS.zi();
                    AppMethodBeat.o(118438);
                    return 0;
                case 15:
                    edf.NdE = aVar3.UbS.zi();
                    AppMethodBeat.o(118438);
                    return 0;
                default:
                    AppMethodBeat.o(118438);
                    return -1;
            }
        } else {
            AppMethodBeat.o(118438);
            return -1;
        }
    }
}
