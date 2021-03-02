package com.tencent.mm.plugin.festival.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class c extends a {
    public int KAO;
    public int Lqb;
    public b UAA;
    public String UAB;
    public d UAs;
    public String UAt;
    public int UAu;
    public String UAv;
    public String UAw;
    public String UAx;
    public int UAy;
    public String UAz;
    public int action;
    public String country;
    public int createtime;
    public String dST;
    public int fuA;
    public String fuJ;
    public String fuK;
    public String gzC;
    public String nickname;
    public String text;
    public String thumburl;
    public String username;
    public int x;
    public int y;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(261968);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.x);
            aVar.aM(2, this.y);
            if (this.UAs != null) {
                aVar.ni(3, this.UAs.computeSize());
                this.UAs.writeFields(aVar);
            }
            if (this.text != null) {
                aVar.e(4, this.text);
            }
            aVar.aM(5, this.KAO);
            if (this.thumburl != null) {
                aVar.e(6, this.thumburl);
            }
            if (this.UAt != null) {
                aVar.e(7, this.UAt);
            }
            if (this.nickname != null) {
                aVar.e(9, this.nickname);
            }
            if (this.gzC != null) {
                aVar.e(10, this.gzC);
            }
            aVar.aM(11, this.createtime);
            if (this.username != null) {
                aVar.e(12, this.username);
            }
            aVar.aM(13, this.UAu);
            if (this.UAv != null) {
                aVar.e(14, this.UAv);
            }
            if (this.UAw != null) {
                aVar.e(15, this.UAw);
            }
            if (this.UAx != null) {
                aVar.e(16, this.UAx);
            }
            aVar.aM(17, this.UAy);
            if (this.dST != null) {
                aVar.e(18, this.dST);
            }
            if (this.UAz != null) {
                aVar.e(19, this.UAz);
            }
            if (this.UAA != null) {
                aVar.c(20, this.UAA);
            }
            if (this.country != null) {
                aVar.e(21, this.country);
            }
            if (this.fuJ != null) {
                aVar.e(22, this.fuJ);
            }
            if (this.fuK != null) {
                aVar.e(23, this.fuK);
            }
            aVar.aM(24, this.Lqb);
            aVar.aM(25, this.action);
            aVar.aM(26, this.fuA);
            if (this.UAB != null) {
                aVar.e(27, this.UAB);
            }
            AppMethodBeat.o(261968);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.x) + 0 + g.a.a.b.b.a.bu(2, this.y);
            if (this.UAs != null) {
                bu += g.a.a.a.nh(3, this.UAs.computeSize());
            }
            if (this.text != null) {
                bu += g.a.a.b.b.a.f(4, this.text);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(5, this.KAO);
            if (this.thumburl != null) {
                bu2 += g.a.a.b.b.a.f(6, this.thumburl);
            }
            if (this.UAt != null) {
                bu2 += g.a.a.b.b.a.f(7, this.UAt);
            }
            if (this.nickname != null) {
                bu2 += g.a.a.b.b.a.f(9, this.nickname);
            }
            if (this.gzC != null) {
                bu2 += g.a.a.b.b.a.f(10, this.gzC);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(11, this.createtime);
            if (this.username != null) {
                bu3 += g.a.a.b.b.a.f(12, this.username);
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(13, this.UAu);
            if (this.UAv != null) {
                bu4 += g.a.a.b.b.a.f(14, this.UAv);
            }
            if (this.UAw != null) {
                bu4 += g.a.a.b.b.a.f(15, this.UAw);
            }
            if (this.UAx != null) {
                bu4 += g.a.a.b.b.a.f(16, this.UAx);
            }
            int bu5 = bu4 + g.a.a.b.b.a.bu(17, this.UAy);
            if (this.dST != null) {
                bu5 += g.a.a.b.b.a.f(18, this.dST);
            }
            if (this.UAz != null) {
                bu5 += g.a.a.b.b.a.f(19, this.UAz);
            }
            if (this.UAA != null) {
                bu5 += g.a.a.b.b.a.b(20, this.UAA);
            }
            if (this.country != null) {
                bu5 += g.a.a.b.b.a.f(21, this.country);
            }
            if (this.fuJ != null) {
                bu5 += g.a.a.b.b.a.f(22, this.fuJ);
            }
            if (this.fuK != null) {
                bu5 += g.a.a.b.b.a.f(23, this.fuK);
            }
            int bu6 = bu5 + g.a.a.b.b.a.bu(24, this.Lqb) + g.a.a.b.b.a.bu(25, this.action) + g.a.a.b.b.a.bu(26, this.fuA);
            if (this.UAB != null) {
                bu6 += g.a.a.b.b.a.f(27, this.UAB);
            }
            AppMethodBeat.o(261968);
            return bu6;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(261968);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            c cVar = (c) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cVar.x = aVar3.UbS.zi();
                    AppMethodBeat.o(261968);
                    return 0;
                case 2:
                    cVar.y = aVar3.UbS.zi();
                    AppMethodBeat.o(261968);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        d dVar = new d();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dVar.populateBuilderWithField(aVar4, dVar, a.getNextFieldNumber(aVar4))) {
                        }
                        cVar.UAs = dVar;
                    }
                    AppMethodBeat.o(261968);
                    return 0;
                case 4:
                    cVar.text = aVar3.UbS.readString();
                    AppMethodBeat.o(261968);
                    return 0;
                case 5:
                    cVar.KAO = aVar3.UbS.zi();
                    AppMethodBeat.o(261968);
                    return 0;
                case 6:
                    cVar.thumburl = aVar3.UbS.readString();
                    AppMethodBeat.o(261968);
                    return 0;
                case 7:
                    cVar.UAt = aVar3.UbS.readString();
                    AppMethodBeat.o(261968);
                    return 0;
                case 8:
                default:
                    AppMethodBeat.o(261968);
                    return -1;
                case 9:
                    cVar.nickname = aVar3.UbS.readString();
                    AppMethodBeat.o(261968);
                    return 0;
                case 10:
                    cVar.gzC = aVar3.UbS.readString();
                    AppMethodBeat.o(261968);
                    return 0;
                case 11:
                    cVar.createtime = aVar3.UbS.zi();
                    AppMethodBeat.o(261968);
                    return 0;
                case 12:
                    cVar.username = aVar3.UbS.readString();
                    AppMethodBeat.o(261968);
                    return 0;
                case 13:
                    cVar.UAu = aVar3.UbS.zi();
                    AppMethodBeat.o(261968);
                    return 0;
                case 14:
                    cVar.UAv = aVar3.UbS.readString();
                    AppMethodBeat.o(261968);
                    return 0;
                case 15:
                    cVar.UAw = aVar3.UbS.readString();
                    AppMethodBeat.o(261968);
                    return 0;
                case 16:
                    cVar.UAx = aVar3.UbS.readString();
                    AppMethodBeat.o(261968);
                    return 0;
                case 17:
                    cVar.UAy = aVar3.UbS.zi();
                    AppMethodBeat.o(261968);
                    return 0;
                case 18:
                    cVar.dST = aVar3.UbS.readString();
                    AppMethodBeat.o(261968);
                    return 0;
                case 19:
                    cVar.UAz = aVar3.UbS.readString();
                    AppMethodBeat.o(261968);
                    return 0;
                case 20:
                    cVar.UAA = aVar3.UbS.hPo();
                    AppMethodBeat.o(261968);
                    return 0;
                case 21:
                    cVar.country = aVar3.UbS.readString();
                    AppMethodBeat.o(261968);
                    return 0;
                case 22:
                    cVar.fuJ = aVar3.UbS.readString();
                    AppMethodBeat.o(261968);
                    return 0;
                case 23:
                    cVar.fuK = aVar3.UbS.readString();
                    AppMethodBeat.o(261968);
                    return 0;
                case 24:
                    cVar.Lqb = aVar3.UbS.zi();
                    AppMethodBeat.o(261968);
                    return 0;
                case 25:
                    cVar.action = aVar3.UbS.zi();
                    AppMethodBeat.o(261968);
                    return 0;
                case 26:
                    cVar.fuA = aVar3.UbS.zi();
                    AppMethodBeat.o(261968);
                    return 0;
                case 27:
                    cVar.UAB = aVar3.UbS.readString();
                    AppMethodBeat.o(261968);
                    return 0;
            }
        } else {
            AppMethodBeat.o(261968);
            return -1;
        }
    }
}
