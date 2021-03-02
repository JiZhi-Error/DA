package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class amt extends a {
    public String KOe;
    public amu LxS;
    public String dHc;
    public int duration;
    public String iAg;
    public String iAo;
    public int iwc = -1;
    public int iwd;
    public int iwe = 0;
    public int iwf;
    public int iwg;
    public String vid;
    public int videoHeight;
    public String videoUrl;
    public int videoWidth;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(127467);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.iwc);
            aVar.aM(2, this.iwe);
            aVar.aM(3, this.videoWidth);
            aVar.aM(4, this.videoHeight);
            aVar.aM(5, this.iwd);
            aVar.aM(6, this.duration);
            if (this.vid != null) {
                aVar.e(7, this.vid);
            }
            if (this.dHc != null) {
                aVar.e(8, this.dHc);
            }
            if (this.iAg != null) {
                aVar.e(9, this.iAg);
            }
            aVar.aM(10, this.iwg);
            if (this.LxS != null) {
                aVar.ni(11, this.LxS.computeSize());
                this.LxS.writeFields(aVar);
            }
            if (this.iAo != null) {
                aVar.e(12, this.iAo);
            }
            if (this.KOe != null) {
                aVar.e(13, this.KOe);
            }
            if (this.videoUrl != null) {
                aVar.e(14, this.videoUrl);
            }
            aVar.aM(15, this.iwf);
            AppMethodBeat.o(127467);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.iwc) + 0 + g.a.a.b.b.a.bu(2, this.iwe) + g.a.a.b.b.a.bu(3, this.videoWidth) + g.a.a.b.b.a.bu(4, this.videoHeight) + g.a.a.b.b.a.bu(5, this.iwd) + g.a.a.b.b.a.bu(6, this.duration);
            if (this.vid != null) {
                bu += g.a.a.b.b.a.f(7, this.vid);
            }
            if (this.dHc != null) {
                bu += g.a.a.b.b.a.f(8, this.dHc);
            }
            if (this.iAg != null) {
                bu += g.a.a.b.b.a.f(9, this.iAg);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(10, this.iwg);
            if (this.LxS != null) {
                bu2 += g.a.a.a.nh(11, this.LxS.computeSize());
            }
            if (this.iAo != null) {
                bu2 += g.a.a.b.b.a.f(12, this.iAo);
            }
            if (this.KOe != null) {
                bu2 += g.a.a.b.b.a.f(13, this.KOe);
            }
            if (this.videoUrl != null) {
                bu2 += g.a.a.b.b.a.f(14, this.videoUrl);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(15, this.iwf);
            AppMethodBeat.o(127467);
            return bu3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(127467);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            amt amt = (amt) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    amt.iwc = aVar3.UbS.zi();
                    AppMethodBeat.o(127467);
                    return 0;
                case 2:
                    amt.iwe = aVar3.UbS.zi();
                    AppMethodBeat.o(127467);
                    return 0;
                case 3:
                    amt.videoWidth = aVar3.UbS.zi();
                    AppMethodBeat.o(127467);
                    return 0;
                case 4:
                    amt.videoHeight = aVar3.UbS.zi();
                    AppMethodBeat.o(127467);
                    return 0;
                case 5:
                    amt.iwd = aVar3.UbS.zi();
                    AppMethodBeat.o(127467);
                    return 0;
                case 6:
                    amt.duration = aVar3.UbS.zi();
                    AppMethodBeat.o(127467);
                    return 0;
                case 7:
                    amt.vid = aVar3.UbS.readString();
                    AppMethodBeat.o(127467);
                    return 0;
                case 8:
                    amt.dHc = aVar3.UbS.readString();
                    AppMethodBeat.o(127467);
                    return 0;
                case 9:
                    amt.iAg = aVar3.UbS.readString();
                    AppMethodBeat.o(127467);
                    return 0;
                case 10:
                    amt.iwg = aVar3.UbS.zi();
                    AppMethodBeat.o(127467);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        amu amu = new amu();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = amu.populateBuilderWithField(aVar4, amu, a.getNextFieldNumber(aVar4))) {
                        }
                        amt.LxS = amu;
                    }
                    AppMethodBeat.o(127467);
                    return 0;
                case 12:
                    amt.iAo = aVar3.UbS.readString();
                    AppMethodBeat.o(127467);
                    return 0;
                case 13:
                    amt.KOe = aVar3.UbS.readString();
                    AppMethodBeat.o(127467);
                    return 0;
                case 14:
                    amt.videoUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(127467);
                    return 0;
                case 15:
                    amt.iwf = aVar3.UbS.zi();
                    AppMethodBeat.o(127467);
                    return 0;
                default:
                    AppMethodBeat.o(127467);
                    return -1;
            }
        } else {
            AppMethodBeat.o(127467);
            return -1;
        }
    }
}
