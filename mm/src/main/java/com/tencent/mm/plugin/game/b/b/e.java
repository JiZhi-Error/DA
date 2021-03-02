package com.tencent.mm.plugin.game.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class e extends a {
    public String albumName;
    public String appId;
    public String appName;
    public int appType;
    public long createTime;
    public boolean dLQ;
    public long duration;
    public String psI;
    public long size;
    public String title;
    public String videoPath;
    public String videoUrl;
    public boolean xuJ;
    public boolean xuK;
    public String xuL;
    public String xuM;
    public String xuN;
    public LinkedList<l> xuO = new LinkedList<>();
    public String xuP;

    public e() {
        AppMethodBeat.i(40868);
        AppMethodBeat.o(40868);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(40869);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.cc(1, this.dLQ);
            aVar.cc(2, this.xuJ);
            aVar.cc(3, this.xuK);
            if (this.xuL != null) {
                aVar.e(4, this.xuL);
            }
            if (this.xuM != null) {
                aVar.e(5, this.xuM);
            }
            if (this.videoUrl != null) {
                aVar.e(6, this.videoUrl);
            }
            if (this.title != null) {
                aVar.e(7, this.title);
            }
            if (this.xuN != null) {
                aVar.e(8, this.xuN);
            }
            aVar.e(9, 8, this.xuO);
            aVar.bb(10, this.createTime);
            aVar.bb(11, this.duration);
            aVar.bb(12, this.size);
            if (this.appId != null) {
                aVar.e(13, this.appId);
            }
            if (this.appName != null) {
                aVar.e(14, this.appName);
            }
            aVar.aM(15, this.appType);
            if (this.videoPath != null) {
                aVar.e(16, this.videoPath);
            }
            if (this.albumName != null) {
                aVar.e(17, this.albumName);
            }
            if (this.psI != null) {
                aVar.e(18, this.psI);
            }
            if (this.xuP != null) {
                aVar.e(19, this.xuP);
            }
            AppMethodBeat.o(40869);
            return 0;
        } else if (i2 == 1) {
            int fS = g.a.a.b.b.a.fS(1) + 1 + 0 + g.a.a.b.b.a.fS(2) + 1 + g.a.a.b.b.a.fS(3) + 1;
            if (this.xuL != null) {
                fS += g.a.a.b.b.a.f(4, this.xuL);
            }
            if (this.xuM != null) {
                fS += g.a.a.b.b.a.f(5, this.xuM);
            }
            if (this.videoUrl != null) {
                fS += g.a.a.b.b.a.f(6, this.videoUrl);
            }
            if (this.title != null) {
                fS += g.a.a.b.b.a.f(7, this.title);
            }
            if (this.xuN != null) {
                fS += g.a.a.b.b.a.f(8, this.xuN);
            }
            int c2 = fS + g.a.a.a.c(9, 8, this.xuO) + g.a.a.b.b.a.r(10, this.createTime) + g.a.a.b.b.a.r(11, this.duration) + g.a.a.b.b.a.r(12, this.size);
            if (this.appId != null) {
                c2 += g.a.a.b.b.a.f(13, this.appId);
            }
            if (this.appName != null) {
                c2 += g.a.a.b.b.a.f(14, this.appName);
            }
            int bu = c2 + g.a.a.b.b.a.bu(15, this.appType);
            if (this.videoPath != null) {
                bu += g.a.a.b.b.a.f(16, this.videoPath);
            }
            if (this.albumName != null) {
                bu += g.a.a.b.b.a.f(17, this.albumName);
            }
            if (this.psI != null) {
                bu += g.a.a.b.b.a.f(18, this.psI);
            }
            if (this.xuP != null) {
                bu += g.a.a.b.b.a.f(19, this.xuP);
            }
            AppMethodBeat.o(40869);
            return bu;
        } else if (i2 == 2) {
            this.xuO.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(40869);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            e eVar = (e) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    eVar.dLQ = aVar3.UbS.yZ();
                    AppMethodBeat.o(40869);
                    return 0;
                case 2:
                    eVar.xuJ = aVar3.UbS.yZ();
                    AppMethodBeat.o(40869);
                    return 0;
                case 3:
                    eVar.xuK = aVar3.UbS.yZ();
                    AppMethodBeat.o(40869);
                    return 0;
                case 4:
                    eVar.xuL = aVar3.UbS.readString();
                    AppMethodBeat.o(40869);
                    return 0;
                case 5:
                    eVar.xuM = aVar3.UbS.readString();
                    AppMethodBeat.o(40869);
                    return 0;
                case 6:
                    eVar.videoUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(40869);
                    return 0;
                case 7:
                    eVar.title = aVar3.UbS.readString();
                    AppMethodBeat.o(40869);
                    return 0;
                case 8:
                    eVar.xuN = aVar3.UbS.readString();
                    AppMethodBeat.o(40869);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size2 = awh.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        l lVar = new l();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = lVar.populateBuilderWithField(aVar4, lVar, a.getNextFieldNumber(aVar4))) {
                        }
                        eVar.xuO.add(lVar);
                    }
                    AppMethodBeat.o(40869);
                    return 0;
                case 10:
                    eVar.createTime = aVar3.UbS.zl();
                    AppMethodBeat.o(40869);
                    return 0;
                case 11:
                    eVar.duration = aVar3.UbS.zl();
                    AppMethodBeat.o(40869);
                    return 0;
                case 12:
                    eVar.size = aVar3.UbS.zl();
                    AppMethodBeat.o(40869);
                    return 0;
                case 13:
                    eVar.appId = aVar3.UbS.readString();
                    AppMethodBeat.o(40869);
                    return 0;
                case 14:
                    eVar.appName = aVar3.UbS.readString();
                    AppMethodBeat.o(40869);
                    return 0;
                case 15:
                    eVar.appType = aVar3.UbS.zi();
                    AppMethodBeat.o(40869);
                    return 0;
                case 16:
                    eVar.videoPath = aVar3.UbS.readString();
                    AppMethodBeat.o(40869);
                    return 0;
                case 17:
                    eVar.albumName = aVar3.UbS.readString();
                    AppMethodBeat.o(40869);
                    return 0;
                case 18:
                    eVar.psI = aVar3.UbS.readString();
                    AppMethodBeat.o(40869);
                    return 0;
                case 19:
                    eVar.xuP = aVar3.UbS.readString();
                    AppMethodBeat.o(40869);
                    return 0;
                default:
                    AppMethodBeat.o(40869);
                    return -1;
            }
        } else {
            AppMethodBeat.o(40869);
            return -1;
        }
    }
}
