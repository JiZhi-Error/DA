package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class aqj extends a {
    public int LCp;
    public int LCq;
    public int LCr;
    public int LCs;
    public int LCt;
    public int LCu;
    public int LCv;
    public int LCw;
    public int LCx;
    public String dVY;
    public int duration;
    public long feedId;
    public int mzA;
    public int networkId;
    public int scene;
    public String uUI;
    public long whR;
    public int whS;
    public String wiK;
    public int wiL;
    public LinkedList<bek> wit = new LinkedList<>();

    public aqj() {
        AppMethodBeat.i(184197);
        AppMethodBeat.o(184197);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(184198);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.feedId);
            aVar.aM(2, this.LCp);
            aVar.aM(3, this.scene);
            aVar.aM(4, this.LCq);
            aVar.aM(5, this.mzA);
            aVar.aM(6, this.LCr);
            aVar.aM(7, this.duration);
            aVar.aM(8, this.LCs);
            aVar.aM(9, this.LCt);
            aVar.aM(10, this.LCu);
            aVar.e(11, 8, this.wit);
            aVar.aM(12, this.LCv);
            aVar.aM(13, this.whS);
            aVar.aM(14, this.LCw);
            if (this.uUI != null) {
                aVar.e(15, this.uUI);
            }
            aVar.bb(16, this.whR);
            aVar.aM(17, this.LCx);
            aVar.aM(18, this.networkId);
            if (this.wiK != null) {
                aVar.e(19, this.wiK);
            }
            aVar.aM(20, this.wiL);
            if (this.dVY != null) {
                aVar.e(21, this.dVY);
            }
            AppMethodBeat.o(184198);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.feedId) + 0 + g.a.a.b.b.a.bu(2, this.LCp) + g.a.a.b.b.a.bu(3, this.scene) + g.a.a.b.b.a.bu(4, this.LCq) + g.a.a.b.b.a.bu(5, this.mzA) + g.a.a.b.b.a.bu(6, this.LCr) + g.a.a.b.b.a.bu(7, this.duration) + g.a.a.b.b.a.bu(8, this.LCs) + g.a.a.b.b.a.bu(9, this.LCt) + g.a.a.b.b.a.bu(10, this.LCu) + g.a.a.a.c(11, 8, this.wit) + g.a.a.b.b.a.bu(12, this.LCv) + g.a.a.b.b.a.bu(13, this.whS) + g.a.a.b.b.a.bu(14, this.LCw);
            if (this.uUI != null) {
                r += g.a.a.b.b.a.f(15, this.uUI);
            }
            int r2 = r + g.a.a.b.b.a.r(16, this.whR) + g.a.a.b.b.a.bu(17, this.LCx) + g.a.a.b.b.a.bu(18, this.networkId);
            if (this.wiK != null) {
                r2 += g.a.a.b.b.a.f(19, this.wiK);
            }
            int bu = r2 + g.a.a.b.b.a.bu(20, this.wiL);
            if (this.dVY != null) {
                bu += g.a.a.b.b.a.f(21, this.dVY);
            }
            AppMethodBeat.o(184198);
            return bu;
        } else if (i2 == 2) {
            this.wit.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(184198);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aqj aqj = (aqj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    aqj.feedId = aVar3.UbS.zl();
                    AppMethodBeat.o(184198);
                    return 0;
                case 2:
                    aqj.LCp = aVar3.UbS.zi();
                    AppMethodBeat.o(184198);
                    return 0;
                case 3:
                    aqj.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(184198);
                    return 0;
                case 4:
                    aqj.LCq = aVar3.UbS.zi();
                    AppMethodBeat.o(184198);
                    return 0;
                case 5:
                    aqj.mzA = aVar3.UbS.zi();
                    AppMethodBeat.o(184198);
                    return 0;
                case 6:
                    aqj.LCr = aVar3.UbS.zi();
                    AppMethodBeat.o(184198);
                    return 0;
                case 7:
                    aqj.duration = aVar3.UbS.zi();
                    AppMethodBeat.o(184198);
                    return 0;
                case 8:
                    aqj.LCs = aVar3.UbS.zi();
                    AppMethodBeat.o(184198);
                    return 0;
                case 9:
                    aqj.LCt = aVar3.UbS.zi();
                    AppMethodBeat.o(184198);
                    return 0;
                case 10:
                    aqj.LCu = aVar3.UbS.zi();
                    AppMethodBeat.o(184198);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        bek bek = new bek();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = bek.populateBuilderWithField(aVar4, bek, a.getNextFieldNumber(aVar4))) {
                        }
                        aqj.wit.add(bek);
                    }
                    AppMethodBeat.o(184198);
                    return 0;
                case 12:
                    aqj.LCv = aVar3.UbS.zi();
                    AppMethodBeat.o(184198);
                    return 0;
                case 13:
                    aqj.whS = aVar3.UbS.zi();
                    AppMethodBeat.o(184198);
                    return 0;
                case 14:
                    aqj.LCw = aVar3.UbS.zi();
                    AppMethodBeat.o(184198);
                    return 0;
                case 15:
                    aqj.uUI = aVar3.UbS.readString();
                    AppMethodBeat.o(184198);
                    return 0;
                case 16:
                    aqj.whR = aVar3.UbS.zl();
                    AppMethodBeat.o(184198);
                    return 0;
                case 17:
                    aqj.LCx = aVar3.UbS.zi();
                    AppMethodBeat.o(184198);
                    return 0;
                case 18:
                    aqj.networkId = aVar3.UbS.zi();
                    AppMethodBeat.o(184198);
                    return 0;
                case 19:
                    aqj.wiK = aVar3.UbS.readString();
                    AppMethodBeat.o(184198);
                    return 0;
                case 20:
                    aqj.wiL = aVar3.UbS.zi();
                    AppMethodBeat.o(184198);
                    return 0;
                case 21:
                    aqj.dVY = aVar3.UbS.readString();
                    AppMethodBeat.o(184198);
                    return 0;
                default:
                    AppMethodBeat.o(184198);
                    return -1;
            }
        } else {
            AppMethodBeat.o(184198);
            return -1;
        }
    }
}
