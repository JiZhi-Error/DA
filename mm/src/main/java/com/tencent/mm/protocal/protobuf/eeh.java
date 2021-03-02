package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class eeh extends a {
    public int CreateTime;
    public long Id;
    public int IsNotRichText;
    public int MYS;
    public int MYT;
    public String NdA;
    public String NdB;
    public int NdD;
    public eea NdL;
    public String ThumbUrl;
    public String iAc;
    public int oUv;
    public String xNG;
    public String xNH;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(118472);
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
            if (this.iAc != null) {
                aVar.e(6, this.iAc);
            }
            aVar.aM(7, this.oUv);
            aVar.aM(8, this.CreateTime);
            aVar.aM(9, this.MYT);
            aVar.aM(10, this.MYS);
            aVar.aM(11, this.IsNotRichText);
            if (this.ThumbUrl != null) {
                aVar.e(12, this.ThumbUrl);
            }
            if (this.NdL != null) {
                aVar.ni(13, this.NdL.computeSize());
                this.NdL.writeFields(aVar);
            }
            aVar.aM(14, this.NdD);
            AppMethodBeat.o(118472);
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
            if (this.iAc != null) {
                r += g.a.a.b.b.a.f(6, this.iAc);
            }
            int bu = r + g.a.a.b.b.a.bu(7, this.oUv) + g.a.a.b.b.a.bu(8, this.CreateTime) + g.a.a.b.b.a.bu(9, this.MYT) + g.a.a.b.b.a.bu(10, this.MYS) + g.a.a.b.b.a.bu(11, this.IsNotRichText);
            if (this.ThumbUrl != null) {
                bu += g.a.a.b.b.a.f(12, this.ThumbUrl);
            }
            if (this.NdL != null) {
                bu += g.a.a.a.nh(13, this.NdL.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(14, this.NdD);
            AppMethodBeat.o(118472);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(118472);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eeh eeh = (eeh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    eeh.Id = aVar3.UbS.zl();
                    AppMethodBeat.o(118472);
                    return 0;
                case 2:
                    eeh.xNH = aVar3.UbS.readString();
                    AppMethodBeat.o(118472);
                    return 0;
                case 3:
                    eeh.xNG = aVar3.UbS.readString();
                    AppMethodBeat.o(118472);
                    return 0;
                case 4:
                    eeh.NdA = aVar3.UbS.readString();
                    AppMethodBeat.o(118472);
                    return 0;
                case 5:
                    eeh.NdB = aVar3.UbS.readString();
                    AppMethodBeat.o(118472);
                    return 0;
                case 6:
                    eeh.iAc = aVar3.UbS.readString();
                    AppMethodBeat.o(118472);
                    return 0;
                case 7:
                    eeh.oUv = aVar3.UbS.zi();
                    AppMethodBeat.o(118472);
                    return 0;
                case 8:
                    eeh.CreateTime = aVar3.UbS.zi();
                    AppMethodBeat.o(118472);
                    return 0;
                case 9:
                    eeh.MYT = aVar3.UbS.zi();
                    AppMethodBeat.o(118472);
                    return 0;
                case 10:
                    eeh.MYS = aVar3.UbS.zi();
                    AppMethodBeat.o(118472);
                    return 0;
                case 11:
                    eeh.IsNotRichText = aVar3.UbS.zi();
                    AppMethodBeat.o(118472);
                    return 0;
                case 12:
                    eeh.ThumbUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(118472);
                    return 0;
                case 13:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        eea eea = new eea();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = eea.populateBuilderWithField(aVar4, eea, a.getNextFieldNumber(aVar4))) {
                        }
                        eeh.NdL = eea;
                    }
                    AppMethodBeat.o(118472);
                    return 0;
                case 14:
                    eeh.NdD = aVar3.UbS.zi();
                    AppMethodBeat.o(118472);
                    return 0;
                default:
                    AppMethodBeat.o(118472);
                    return -1;
            }
        } else {
            AppMethodBeat.o(118472);
            return -1;
        }
    }
}
