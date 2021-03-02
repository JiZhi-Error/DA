package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class axf extends a {
    public String LHG;
    public String LHH;
    public String coverUrl;
    public String desc;
    public int extFlag;
    public String feedId;
    public String hFO;
    public String hJs;
    public String headUrl;
    public float height;
    public int liveStatus;
    public String nickName;
    public String objectNonceId;
    public String username;
    public float width;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(196088);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.hJs != null) {
                aVar.e(1, this.hJs);
            }
            if (this.username != null) {
                aVar.e(2, this.username);
            }
            if (this.feedId != null) {
                aVar.e(3, this.feedId);
            }
            if (this.nickName != null) {
                aVar.e(4, this.nickName);
            }
            if (this.desc != null) {
                aVar.e(5, this.desc);
            }
            if (this.coverUrl != null) {
                aVar.e(6, this.coverUrl);
            }
            aVar.E(7, this.width);
            aVar.E(8, this.height);
            if (this.LHG != null) {
                aVar.e(9, this.LHG);
            }
            if (this.hFO != null) {
                aVar.e(10, this.hFO);
            }
            if (this.LHH != null) {
                aVar.e(11, this.LHH);
            }
            if (this.headUrl != null) {
                aVar.e(12, this.headUrl);
            }
            if (this.objectNonceId != null) {
                aVar.e(13, this.objectNonceId);
            }
            aVar.aM(14, this.liveStatus);
            aVar.aM(15, this.extFlag);
            AppMethodBeat.o(196088);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.hJs != null ? g.a.a.b.b.a.f(1, this.hJs) + 0 : 0;
            if (this.username != null) {
                f2 += g.a.a.b.b.a.f(2, this.username);
            }
            if (this.feedId != null) {
                f2 += g.a.a.b.b.a.f(3, this.feedId);
            }
            if (this.nickName != null) {
                f2 += g.a.a.b.b.a.f(4, this.nickName);
            }
            if (this.desc != null) {
                f2 += g.a.a.b.b.a.f(5, this.desc);
            }
            if (this.coverUrl != null) {
                f2 += g.a.a.b.b.a.f(6, this.coverUrl);
            }
            int fS = f2 + g.a.a.b.b.a.fS(7) + 4 + g.a.a.b.b.a.fS(8) + 4;
            if (this.LHG != null) {
                fS += g.a.a.b.b.a.f(9, this.LHG);
            }
            if (this.hFO != null) {
                fS += g.a.a.b.b.a.f(10, this.hFO);
            }
            if (this.LHH != null) {
                fS += g.a.a.b.b.a.f(11, this.LHH);
            }
            if (this.headUrl != null) {
                fS += g.a.a.b.b.a.f(12, this.headUrl);
            }
            if (this.objectNonceId != null) {
                fS += g.a.a.b.b.a.f(13, this.objectNonceId);
            }
            int bu = fS + g.a.a.b.b.a.bu(14, this.liveStatus) + g.a.a.b.b.a.bu(15, this.extFlag);
            AppMethodBeat.o(196088);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(196088);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            axf axf = (axf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    axf.hJs = aVar3.UbS.readString();
                    AppMethodBeat.o(196088);
                    return 0;
                case 2:
                    axf.username = aVar3.UbS.readString();
                    AppMethodBeat.o(196088);
                    return 0;
                case 3:
                    axf.feedId = aVar3.UbS.readString();
                    AppMethodBeat.o(196088);
                    return 0;
                case 4:
                    axf.nickName = aVar3.UbS.readString();
                    AppMethodBeat.o(196088);
                    return 0;
                case 5:
                    axf.desc = aVar3.UbS.readString();
                    AppMethodBeat.o(196088);
                    return 0;
                case 6:
                    axf.coverUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(196088);
                    return 0;
                case 7:
                    axf.width = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(196088);
                    return 0;
                case 8:
                    axf.height = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(196088);
                    return 0;
                case 9:
                    axf.LHG = aVar3.UbS.readString();
                    AppMethodBeat.o(196088);
                    return 0;
                case 10:
                    axf.hFO = aVar3.UbS.readString();
                    AppMethodBeat.o(196088);
                    return 0;
                case 11:
                    axf.LHH = aVar3.UbS.readString();
                    AppMethodBeat.o(196088);
                    return 0;
                case 12:
                    axf.headUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(196088);
                    return 0;
                case 13:
                    axf.objectNonceId = aVar3.UbS.readString();
                    AppMethodBeat.o(196088);
                    return 0;
                case 14:
                    axf.liveStatus = aVar3.UbS.zi();
                    AppMethodBeat.o(196088);
                    return 0;
                case 15:
                    axf.extFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(196088);
                    return 0;
                default:
                    AppMethodBeat.o(196088);
                    return -1;
            }
        } else {
            AppMethodBeat.o(196088);
            return -1;
        }
    }
}
