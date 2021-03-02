package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class mv extends dop {
    public b KRc;
    public String KRd;
    public String KRe;
    public String KRf;
    public int KRg;
    public int KRh;
    public long KRi;
    public boolean KRj;
    public boolean KRk;
    public GoodsObject KRl;
    public int KRm;
    public int KRn;
    public mu KRo;
    public ms KRp;
    public mt KRq;
    public long KRr;
    public int mode;
    public int type;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124394);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.KRc != null) {
                aVar.c(2, this.KRc);
            }
            aVar.aM(11, this.type);
            aVar.aM(12, this.mode);
            if (this.KRd != null) {
                aVar.e(13, this.KRd);
            }
            if (this.KRe != null) {
                aVar.e(14, this.KRe);
            }
            if (this.KRf != null) {
                aVar.e(15, this.KRf);
            }
            aVar.aM(16, this.KRg);
            aVar.aM(17, this.KRh);
            aVar.bb(18, this.KRi);
            aVar.cc(19, this.KRj);
            aVar.cc(20, this.KRk);
            if (this.KRl != null) {
                aVar.ni(21, this.KRl.computeSize());
                this.KRl.writeFields(aVar);
            }
            aVar.aM(22, this.KRm);
            aVar.aM(23, this.KRn);
            if (this.KRo != null) {
                aVar.ni(26, this.KRo.computeSize());
                this.KRo.writeFields(aVar);
            }
            if (this.KRp != null) {
                aVar.ni(31, this.KRp.computeSize());
                this.KRp.writeFields(aVar);
            }
            if (this.KRq != null) {
                aVar.ni(32, this.KRq.computeSize());
                this.KRq.writeFields(aVar);
            }
            aVar.bb(50, this.KRr);
            AppMethodBeat.o(124394);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.KRc != null) {
                nh += g.a.a.b.b.a.b(2, this.KRc);
            }
            int bu = nh + g.a.a.b.b.a.bu(11, this.type) + g.a.a.b.b.a.bu(12, this.mode);
            if (this.KRd != null) {
                bu += g.a.a.b.b.a.f(13, this.KRd);
            }
            if (this.KRe != null) {
                bu += g.a.a.b.b.a.f(14, this.KRe);
            }
            if (this.KRf != null) {
                bu += g.a.a.b.b.a.f(15, this.KRf);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(16, this.KRg) + g.a.a.b.b.a.bu(17, this.KRh) + g.a.a.b.b.a.r(18, this.KRi) + g.a.a.b.b.a.fS(19) + 1 + g.a.a.b.b.a.fS(20) + 1;
            if (this.KRl != null) {
                bu2 += g.a.a.a.nh(21, this.KRl.computeSize());
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(22, this.KRm) + g.a.a.b.b.a.bu(23, this.KRn);
            if (this.KRo != null) {
                bu3 += g.a.a.a.nh(26, this.KRo.computeSize());
            }
            if (this.KRp != null) {
                bu3 += g.a.a.a.nh(31, this.KRp.computeSize());
            }
            if (this.KRq != null) {
                bu3 += g.a.a.a.nh(32, this.KRq.computeSize());
            }
            int r = bu3 + g.a.a.b.b.a.r(50, this.KRr);
            AppMethodBeat.o(124394);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(124394);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            mv mvVar = (mv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        jr jrVar = new jr();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = jrVar.populateBuilderWithField(aVar4, jrVar, dop.getNextFieldNumber(aVar4))) {
                        }
                        mvVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(124394);
                    return 0;
                case 2:
                    mvVar.KRc = aVar3.UbS.hPo();
                    AppMethodBeat.o(124394);
                    return 0;
                case 11:
                    mvVar.type = aVar3.UbS.zi();
                    AppMethodBeat.o(124394);
                    return 0;
                case 12:
                    mvVar.mode = aVar3.UbS.zi();
                    AppMethodBeat.o(124394);
                    return 0;
                case 13:
                    mvVar.KRd = aVar3.UbS.readString();
                    AppMethodBeat.o(124394);
                    return 0;
                case 14:
                    mvVar.KRe = aVar3.UbS.readString();
                    AppMethodBeat.o(124394);
                    return 0;
                case 15:
                    mvVar.KRf = aVar3.UbS.readString();
                    AppMethodBeat.o(124394);
                    return 0;
                case 16:
                    mvVar.KRg = aVar3.UbS.zi();
                    AppMethodBeat.o(124394);
                    return 0;
                case 17:
                    mvVar.KRh = aVar3.UbS.zi();
                    AppMethodBeat.o(124394);
                    return 0;
                case 18:
                    mvVar.KRi = aVar3.UbS.zl();
                    AppMethodBeat.o(124394);
                    return 0;
                case 19:
                    mvVar.KRj = aVar3.UbS.yZ();
                    AppMethodBeat.o(124394);
                    return 0;
                case 20:
                    mvVar.KRk = aVar3.UbS.yZ();
                    AppMethodBeat.o(124394);
                    return 0;
                case 21:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        GoodsObject goodsObject = new GoodsObject();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = goodsObject.populateBuilderWithField(aVar5, goodsObject, dop.getNextFieldNumber(aVar5))) {
                        }
                        mvVar.KRl = goodsObject;
                    }
                    AppMethodBeat.o(124394);
                    return 0;
                case 22:
                    mvVar.KRm = aVar3.UbS.zi();
                    AppMethodBeat.o(124394);
                    return 0;
                case 23:
                    mvVar.KRn = aVar3.UbS.zi();
                    AppMethodBeat.o(124394);
                    return 0;
                case 26:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        mu muVar = new mu();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = muVar.populateBuilderWithField(aVar6, muVar, dop.getNextFieldNumber(aVar6))) {
                        }
                        mvVar.KRo = muVar;
                    }
                    AppMethodBeat.o(124394);
                    return 0;
                case 31:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        ms msVar = new ms();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = msVar.populateBuilderWithField(aVar7, msVar, dop.getNextFieldNumber(aVar7))) {
                        }
                        mvVar.KRp = msVar;
                    }
                    AppMethodBeat.o(124394);
                    return 0;
                case 32:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        mt mtVar = new mt();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = mtVar.populateBuilderWithField(aVar8, mtVar, dop.getNextFieldNumber(aVar8))) {
                        }
                        mvVar.KRq = mtVar;
                    }
                    AppMethodBeat.o(124394);
                    return 0;
                case 50:
                    mvVar.KRr = aVar3.UbS.zl();
                    AppMethodBeat.o(124394);
                    return 0;
                default:
                    AppMethodBeat.o(124394);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124394);
            return -1;
        }
    }
}
