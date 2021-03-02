package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cbj extends a {
    public String LOY;
    public int LOZ;
    public String LPa;
    public boolean LPb = false;
    public boolean LPc = false;
    public eih Mhd;
    public eih Mhe;
    public String Mhf;
    public String Mhg;
    public boolean Mhh = false;
    public boolean Mhi;
    public cbn Mhj;
    public erd Mhk;
    public boj Mhl;
    public int flags;
    public int msgType = -1;
    public long timestamp = 0;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(122507);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.msgType);
            if (this.Mhd != null) {
                aVar.ni(2, this.Mhd.computeSize());
                this.Mhd.writeFields(aVar);
            }
            if (this.Mhe != null) {
                aVar.ni(3, this.Mhe.computeSize());
                this.Mhe.writeFields(aVar);
            }
            aVar.cc(4, this.LPb);
            if (this.LOY != null) {
                aVar.e(5, this.LOY);
            }
            aVar.aM(6, this.flags);
            if (this.LPa != null) {
                aVar.e(7, this.LPa);
            }
            if (this.Mhf != null) {
                aVar.e(8, this.Mhf);
            }
            if (this.Mhg != null) {
                aVar.e(9, this.Mhg);
            }
            aVar.cc(10, this.Mhh);
            aVar.cc(11, this.Mhi);
            aVar.cc(12, this.LPc);
            if (this.Mhj != null) {
                aVar.ni(13, this.Mhj.computeSize());
                this.Mhj.writeFields(aVar);
            }
            aVar.bb(14, this.timestamp);
            if (this.Mhk != null) {
                aVar.ni(15, this.Mhk.computeSize());
                this.Mhk.writeFields(aVar);
            }
            aVar.aM(16, this.LOZ);
            if (this.Mhl != null) {
                aVar.ni(17, this.Mhl.computeSize());
                this.Mhl.writeFields(aVar);
            }
            AppMethodBeat.o(122507);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.msgType) + 0;
            if (this.Mhd != null) {
                bu += g.a.a.a.nh(2, this.Mhd.computeSize());
            }
            if (this.Mhe != null) {
                bu += g.a.a.a.nh(3, this.Mhe.computeSize());
            }
            int fS = bu + g.a.a.b.b.a.fS(4) + 1;
            if (this.LOY != null) {
                fS += g.a.a.b.b.a.f(5, this.LOY);
            }
            int bu2 = fS + g.a.a.b.b.a.bu(6, this.flags);
            if (this.LPa != null) {
                bu2 += g.a.a.b.b.a.f(7, this.LPa);
            }
            if (this.Mhf != null) {
                bu2 += g.a.a.b.b.a.f(8, this.Mhf);
            }
            if (this.Mhg != null) {
                bu2 += g.a.a.b.b.a.f(9, this.Mhg);
            }
            int fS2 = bu2 + g.a.a.b.b.a.fS(10) + 1 + g.a.a.b.b.a.fS(11) + 1 + g.a.a.b.b.a.fS(12) + 1;
            if (this.Mhj != null) {
                fS2 += g.a.a.a.nh(13, this.Mhj.computeSize());
            }
            int r = fS2 + g.a.a.b.b.a.r(14, this.timestamp);
            if (this.Mhk != null) {
                r += g.a.a.a.nh(15, this.Mhk.computeSize());
            }
            int bu3 = r + g.a.a.b.b.a.bu(16, this.LOZ);
            if (this.Mhl != null) {
                bu3 += g.a.a.a.nh(17, this.Mhl.computeSize());
            }
            AppMethodBeat.o(122507);
            return bu3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(122507);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cbj cbj = (cbj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cbj.msgType = aVar3.UbS.zi();
                    AppMethodBeat.o(122507);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        eih eih = new eih();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = eih.populateBuilderWithField(aVar4, eih, a.getNextFieldNumber(aVar4))) {
                        }
                        cbj.Mhd = eih;
                    }
                    AppMethodBeat.o(122507);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        eih eih2 = new eih();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = eih2.populateBuilderWithField(aVar5, eih2, a.getNextFieldNumber(aVar5))) {
                        }
                        cbj.Mhe = eih2;
                    }
                    AppMethodBeat.o(122507);
                    return 0;
                case 4:
                    cbj.LPb = aVar3.UbS.yZ();
                    AppMethodBeat.o(122507);
                    return 0;
                case 5:
                    cbj.LOY = aVar3.UbS.readString();
                    AppMethodBeat.o(122507);
                    return 0;
                case 6:
                    cbj.flags = aVar3.UbS.zi();
                    AppMethodBeat.o(122507);
                    return 0;
                case 7:
                    cbj.LPa = aVar3.UbS.readString();
                    AppMethodBeat.o(122507);
                    return 0;
                case 8:
                    cbj.Mhf = aVar3.UbS.readString();
                    AppMethodBeat.o(122507);
                    return 0;
                case 9:
                    cbj.Mhg = aVar3.UbS.readString();
                    AppMethodBeat.o(122507);
                    return 0;
                case 10:
                    cbj.Mhh = aVar3.UbS.yZ();
                    AppMethodBeat.o(122507);
                    return 0;
                case 11:
                    cbj.Mhi = aVar3.UbS.yZ();
                    AppMethodBeat.o(122507);
                    return 0;
                case 12:
                    cbj.LPc = aVar3.UbS.yZ();
                    AppMethodBeat.o(122507);
                    return 0;
                case 13:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        cbn cbn = new cbn();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = cbn.populateBuilderWithField(aVar6, cbn, a.getNextFieldNumber(aVar6))) {
                        }
                        cbj.Mhj = cbn;
                    }
                    AppMethodBeat.o(122507);
                    return 0;
                case 14:
                    cbj.timestamp = aVar3.UbS.zl();
                    AppMethodBeat.o(122507);
                    return 0;
                case 15:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        erd erd = new erd();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = erd.populateBuilderWithField(aVar7, erd, a.getNextFieldNumber(aVar7))) {
                        }
                        cbj.Mhk = erd;
                    }
                    AppMethodBeat.o(122507);
                    return 0;
                case 16:
                    cbj.LOZ = aVar3.UbS.zi();
                    AppMethodBeat.o(122507);
                    return 0;
                case 17:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        boj boj = new boj();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = boj.populateBuilderWithField(aVar8, boj, a.getNextFieldNumber(aVar8))) {
                        }
                        cbj.Mhl = boj;
                    }
                    AppMethodBeat.o(122507);
                    return 0;
                default:
                    AppMethodBeat.o(122507);
                    return -1;
            }
        } else {
            AppMethodBeat.o(122507);
            return -1;
        }
    }
}
