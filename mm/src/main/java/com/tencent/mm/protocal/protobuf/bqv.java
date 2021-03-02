package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bqv extends dop {
    public int Brl;
    public long Brn;
    public int BsF;
    public int BsG;
    public int BsH;
    public dqi KHl;
    public dqi KHm;
    public int LYt;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152572);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.KHl == null) {
                b bVar = new b("Not all required fields were included: FromUserName");
                AppMethodBeat.o(152572);
                throw bVar;
            } else if (this.KHm == null) {
                b bVar2 = new b("Not all required fields were included: ToUserName");
                AppMethodBeat.o(152572);
                throw bVar2;
            } else {
                if (this.BaseRequest != null) {
                    aVar.ni(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(aVar);
                }
                aVar.aM(2, this.Brl);
                if (this.KHl != null) {
                    aVar.ni(3, this.KHl.computeSize());
                    this.KHl.writeFields(aVar);
                }
                if (this.KHm != null) {
                    aVar.ni(4, this.KHm.computeSize());
                    this.KHm.writeFields(aVar);
                }
                aVar.aM(5, this.BsF);
                aVar.aM(6, this.BsG);
                aVar.aM(7, this.BsH);
                aVar.aM(8, this.LYt);
                aVar.bb(9, this.Brn);
                AppMethodBeat.o(152572);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.Brl);
            if (this.KHl != null) {
                nh += g.a.a.a.nh(3, this.KHl.computeSize());
            }
            if (this.KHm != null) {
                nh += g.a.a.a.nh(4, this.KHm.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.BsF) + g.a.a.b.b.a.bu(6, this.BsG) + g.a.a.b.b.a.bu(7, this.BsH) + g.a.a.b.b.a.bu(8, this.LYt) + g.a.a.b.b.a.r(9, this.Brn);
            AppMethodBeat.o(152572);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.KHl == null) {
                b bVar3 = new b("Not all required fields were included: FromUserName");
                AppMethodBeat.o(152572);
                throw bVar3;
            } else if (this.KHm == null) {
                b bVar4 = new b("Not all required fields were included: ToUserName");
                AppMethodBeat.o(152572);
                throw bVar4;
            } else {
                AppMethodBeat.o(152572);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bqv bqv = (bqv) objArr[1];
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
                        bqv.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(152572);
                    return 0;
                case 2:
                    bqv.Brl = aVar3.UbS.zi();
                    AppMethodBeat.o(152572);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dqi.populateBuilderWithField(aVar5, dqi, dop.getNextFieldNumber(aVar5))) {
                        }
                        bqv.KHl = dqi;
                    }
                    AppMethodBeat.o(152572);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dqi dqi2 = new dqi();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dqi2.populateBuilderWithField(aVar6, dqi2, dop.getNextFieldNumber(aVar6))) {
                        }
                        bqv.KHm = dqi2;
                    }
                    AppMethodBeat.o(152572);
                    return 0;
                case 5:
                    bqv.BsF = aVar3.UbS.zi();
                    AppMethodBeat.o(152572);
                    return 0;
                case 6:
                    bqv.BsG = aVar3.UbS.zi();
                    AppMethodBeat.o(152572);
                    return 0;
                case 7:
                    bqv.BsH = aVar3.UbS.zi();
                    AppMethodBeat.o(152572);
                    return 0;
                case 8:
                    bqv.LYt = aVar3.UbS.zi();
                    AppMethodBeat.o(152572);
                    return 0;
                case 9:
                    bqv.Brn = aVar3.UbS.zl();
                    AppMethodBeat.o(152572);
                    return 0;
                default:
                    AppMethodBeat.o(152572);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152572);
            return -1;
        }
    }
}
