package com.tencent.mm.t.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class j extends a {
    public String desc;
    public String gTA;
    public String gTB;
    public long gTC;
    public k gTD;
    public String gTE;
    public String gTF;
    public String gTG;
    public String gTH;
    public String gTI = "fa5151";
    public String gTJ = "ffffff";
    public String gTK = "f2f2f2";
    public String gTL = "fa5151";
    public String gTM = "C84040";
    public int gTr;
    public String gTs;
    public String gTt;
    public int gTu;
    public l gTv;
    public String gTw;
    public int gTx;
    public l gTy;
    public int gTz;
    public String nickname;
    public String title;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(194682);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.gTr);
            if (this.gTs != null) {
                aVar.e(2, this.gTs);
            }
            if (this.nickname != null) {
                aVar.e(3, this.nickname);
            }
            if (this.title != null) {
                aVar.e(4, this.title);
            }
            if (this.desc != null) {
                aVar.e(5, this.desc);
            }
            if (this.gTt != null) {
                aVar.e(7, this.gTt);
            }
            aVar.aM(8, this.gTu);
            if (this.gTv != null) {
                aVar.ni(9, this.gTv.computeSize());
                this.gTv.writeFields(aVar);
            }
            if (this.gTw != null) {
                aVar.e(10, this.gTw);
            }
            aVar.aM(11, this.gTx);
            if (this.gTy != null) {
                aVar.ni(12, this.gTy.computeSize());
                this.gTy.writeFields(aVar);
            }
            aVar.aM(14, this.gTz);
            if (this.gTA != null) {
                aVar.e(15, this.gTA);
            }
            if (this.gTB != null) {
                aVar.e(16, this.gTB);
            }
            aVar.bb(19, this.gTC);
            if (this.gTD != null) {
                aVar.ni(25, this.gTD.computeSize());
                this.gTD.writeFields(aVar);
            }
            if (this.gTE != null) {
                aVar.e(6, this.gTE);
            }
            if (this.gTF != null) {
                aVar.e(13, this.gTF);
            }
            if (this.gTG != null) {
                aVar.e(17, this.gTG);
            }
            if (this.gTH != null) {
                aVar.e(18, this.gTH);
            }
            if (this.gTI != null) {
                aVar.e(20, this.gTI);
            }
            if (this.gTJ != null) {
                aVar.e(21, this.gTJ);
            }
            if (this.gTK != null) {
                aVar.e(22, this.gTK);
            }
            if (this.gTL != null) {
                aVar.e(23, this.gTL);
            }
            if (this.gTM != null) {
                aVar.e(24, this.gTM);
            }
            AppMethodBeat.o(194682);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.gTr) + 0;
            if (this.gTs != null) {
                bu += g.a.a.b.b.a.f(2, this.gTs);
            }
            if (this.nickname != null) {
                bu += g.a.a.b.b.a.f(3, this.nickname);
            }
            if (this.title != null) {
                bu += g.a.a.b.b.a.f(4, this.title);
            }
            if (this.desc != null) {
                bu += g.a.a.b.b.a.f(5, this.desc);
            }
            if (this.gTt != null) {
                bu += g.a.a.b.b.a.f(7, this.gTt);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(8, this.gTu);
            if (this.gTv != null) {
                bu2 += g.a.a.a.nh(9, this.gTv.computeSize());
            }
            if (this.gTw != null) {
                bu2 += g.a.a.b.b.a.f(10, this.gTw);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(11, this.gTx);
            if (this.gTy != null) {
                bu3 += g.a.a.a.nh(12, this.gTy.computeSize());
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(14, this.gTz);
            if (this.gTA != null) {
                bu4 += g.a.a.b.b.a.f(15, this.gTA);
            }
            if (this.gTB != null) {
                bu4 += g.a.a.b.b.a.f(16, this.gTB);
            }
            int r = bu4 + g.a.a.b.b.a.r(19, this.gTC);
            if (this.gTD != null) {
                r += g.a.a.a.nh(25, this.gTD.computeSize());
            }
            if (this.gTE != null) {
                r += g.a.a.b.b.a.f(6, this.gTE);
            }
            if (this.gTF != null) {
                r += g.a.a.b.b.a.f(13, this.gTF);
            }
            if (this.gTG != null) {
                r += g.a.a.b.b.a.f(17, this.gTG);
            }
            if (this.gTH != null) {
                r += g.a.a.b.b.a.f(18, this.gTH);
            }
            if (this.gTI != null) {
                r += g.a.a.b.b.a.f(20, this.gTI);
            }
            if (this.gTJ != null) {
                r += g.a.a.b.b.a.f(21, this.gTJ);
            }
            if (this.gTK != null) {
                r += g.a.a.b.b.a.f(22, this.gTK);
            }
            if (this.gTL != null) {
                r += g.a.a.b.b.a.f(23, this.gTL);
            }
            if (this.gTM != null) {
                r += g.a.a.b.b.a.f(24, this.gTM);
            }
            AppMethodBeat.o(194682);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(194682);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            j jVar = (j) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    jVar.gTr = aVar3.UbS.zi();
                    AppMethodBeat.o(194682);
                    return 0;
                case 2:
                    jVar.gTs = aVar3.UbS.readString();
                    AppMethodBeat.o(194682);
                    return 0;
                case 3:
                    jVar.nickname = aVar3.UbS.readString();
                    AppMethodBeat.o(194682);
                    return 0;
                case 4:
                    jVar.title = aVar3.UbS.readString();
                    AppMethodBeat.o(194682);
                    return 0;
                case 5:
                    jVar.desc = aVar3.UbS.readString();
                    AppMethodBeat.o(194682);
                    return 0;
                case 6:
                    jVar.gTE = aVar3.UbS.readString();
                    AppMethodBeat.o(194682);
                    return 0;
                case 7:
                    jVar.gTt = aVar3.UbS.readString();
                    AppMethodBeat.o(194682);
                    return 0;
                case 8:
                    jVar.gTu = aVar3.UbS.zi();
                    AppMethodBeat.o(194682);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        l lVar = new l();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = lVar.populateBuilderWithField(aVar4, lVar, a.getNextFieldNumber(aVar4))) {
                        }
                        jVar.gTv = lVar;
                    }
                    AppMethodBeat.o(194682);
                    return 0;
                case 10:
                    jVar.gTw = aVar3.UbS.readString();
                    AppMethodBeat.o(194682);
                    return 0;
                case 11:
                    jVar.gTx = aVar3.UbS.zi();
                    AppMethodBeat.o(194682);
                    return 0;
                case 12:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        l lVar2 = new l();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = lVar2.populateBuilderWithField(aVar5, lVar2, a.getNextFieldNumber(aVar5))) {
                        }
                        jVar.gTy = lVar2;
                    }
                    AppMethodBeat.o(194682);
                    return 0;
                case 13:
                    jVar.gTF = aVar3.UbS.readString();
                    AppMethodBeat.o(194682);
                    return 0;
                case 14:
                    jVar.gTz = aVar3.UbS.zi();
                    AppMethodBeat.o(194682);
                    return 0;
                case 15:
                    jVar.gTA = aVar3.UbS.readString();
                    AppMethodBeat.o(194682);
                    return 0;
                case 16:
                    jVar.gTB = aVar3.UbS.readString();
                    AppMethodBeat.o(194682);
                    return 0;
                case 17:
                    jVar.gTG = aVar3.UbS.readString();
                    AppMethodBeat.o(194682);
                    return 0;
                case 18:
                    jVar.gTH = aVar3.UbS.readString();
                    AppMethodBeat.o(194682);
                    return 0;
                case 19:
                    jVar.gTC = aVar3.UbS.zl();
                    AppMethodBeat.o(194682);
                    return 0;
                case 20:
                    jVar.gTI = aVar3.UbS.readString();
                    AppMethodBeat.o(194682);
                    return 0;
                case 21:
                    jVar.gTJ = aVar3.UbS.readString();
                    AppMethodBeat.o(194682);
                    return 0;
                case 22:
                    jVar.gTK = aVar3.UbS.readString();
                    AppMethodBeat.o(194682);
                    return 0;
                case 23:
                    jVar.gTL = aVar3.UbS.readString();
                    AppMethodBeat.o(194682);
                    return 0;
                case 24:
                    jVar.gTM = aVar3.UbS.readString();
                    AppMethodBeat.o(194682);
                    return 0;
                case 25:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        k kVar = new k();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = kVar.populateBuilderWithField(aVar6, kVar, a.getNextFieldNumber(aVar6))) {
                        }
                        jVar.gTD = kVar;
                    }
                    AppMethodBeat.o(194682);
                    return 0;
                default:
                    AppMethodBeat.o(194682);
                    return -1;
            }
        } else {
            AppMethodBeat.o(194682);
            return -1;
        }
    }
}
