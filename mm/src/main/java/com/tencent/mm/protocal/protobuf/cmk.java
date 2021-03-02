package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cmk extends a {
    public int MrG;
    public String MrH;
    public String bssid;
    public String dFd;
    public int dIX;
    public String ssid;
    public int wNc;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32344);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.ssid != null) {
                aVar.e(1, this.ssid);
            }
            if (this.bssid != null) {
                aVar.e(2, this.bssid);
            }
            aVar.aM(3, this.dIX);
            aVar.aM(4, this.MrG);
            if (this.MrH != null) {
                aVar.e(5, this.MrH);
            }
            if (this.dFd != null) {
                aVar.e(6, this.dFd);
            }
            aVar.aM(7, this.wNc);
            AppMethodBeat.o(32344);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.ssid != null ? g.a.a.b.b.a.f(1, this.ssid) + 0 : 0;
            if (this.bssid != null) {
                f2 += g.a.a.b.b.a.f(2, this.bssid);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.dIX) + g.a.a.b.b.a.bu(4, this.MrG);
            if (this.MrH != null) {
                bu += g.a.a.b.b.a.f(5, this.MrH);
            }
            if (this.dFd != null) {
                bu += g.a.a.b.b.a.f(6, this.dFd);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(7, this.wNc);
            AppMethodBeat.o(32344);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32344);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cmk cmk = (cmk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cmk.ssid = aVar3.UbS.readString();
                    AppMethodBeat.o(32344);
                    return 0;
                case 2:
                    cmk.bssid = aVar3.UbS.readString();
                    AppMethodBeat.o(32344);
                    return 0;
                case 3:
                    cmk.dIX = aVar3.UbS.zi();
                    AppMethodBeat.o(32344);
                    return 0;
                case 4:
                    cmk.MrG = aVar3.UbS.zi();
                    AppMethodBeat.o(32344);
                    return 0;
                case 5:
                    cmk.MrH = aVar3.UbS.readString();
                    AppMethodBeat.o(32344);
                    return 0;
                case 6:
                    cmk.dFd = aVar3.UbS.readString();
                    AppMethodBeat.o(32344);
                    return 0;
                case 7:
                    cmk.wNc = aVar3.UbS.zi();
                    AppMethodBeat.o(32344);
                    return 0;
                default:
                    AppMethodBeat.o(32344);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32344);
            return -1;
        }
    }
}
