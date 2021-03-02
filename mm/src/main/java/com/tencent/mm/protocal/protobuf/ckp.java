package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ckp extends a {
    public String LRO;
    public String Lir;
    public String Lis;
    public ebj MmQ;
    public aeq MmR;
    public alg MpZ;
    public String Nickname;
    public String Username;
    public String kdX;
    public int kdY;
    public String kdZ;
    public String kea;
    public String keb;
    public int kec;
    public String ked;
    public int kee;
    public int kef;
    public String keg;
    public String keh;
    public String kei;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(155440);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Username != null) {
                aVar.e(1, this.Username);
            }
            if (this.Nickname != null) {
                aVar.e(2, this.Nickname);
            }
            if (this.kdX != null) {
                aVar.e(3, this.kdX);
            }
            aVar.aM(4, this.kdY);
            if (this.kdZ != null) {
                aVar.e(5, this.kdZ);
            }
            if (this.kea != null) {
                aVar.e(6, this.kea);
            }
            if (this.keb != null) {
                aVar.e(7, this.keb);
            }
            aVar.aM(8, this.kec);
            if (this.ked != null) {
                aVar.e(9, this.ked);
            }
            if (this.MpZ != null) {
                aVar.ni(10, this.MpZ.computeSize());
                this.MpZ.writeFields(aVar);
            }
            aVar.aM(11, this.kee);
            aVar.aM(12, this.kef);
            if (this.keg != null) {
                aVar.e(13, this.keg);
            }
            if (this.MmQ != null) {
                aVar.ni(14, this.MmQ.computeSize());
                this.MmQ.writeFields(aVar);
            }
            if (this.keh != null) {
                aVar.e(15, this.keh);
            }
            if (this.kei != null) {
                aVar.e(16, this.kei);
            }
            if (this.MmR != null) {
                aVar.ni(17, this.MmR.computeSize());
                this.MmR.writeFields(aVar);
            }
            if (this.Lir != null) {
                aVar.e(20, this.Lir);
            }
            if (this.Lis != null) {
                aVar.e(21, this.Lis);
            }
            if (this.LRO != null) {
                aVar.e(22, this.LRO);
            }
            AppMethodBeat.o(155440);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Username != null ? g.a.a.b.b.a.f(1, this.Username) + 0 : 0;
            if (this.Nickname != null) {
                f2 += g.a.a.b.b.a.f(2, this.Nickname);
            }
            if (this.kdX != null) {
                f2 += g.a.a.b.b.a.f(3, this.kdX);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.kdY);
            if (this.kdZ != null) {
                bu += g.a.a.b.b.a.f(5, this.kdZ);
            }
            if (this.kea != null) {
                bu += g.a.a.b.b.a.f(6, this.kea);
            }
            if (this.keb != null) {
                bu += g.a.a.b.b.a.f(7, this.keb);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(8, this.kec);
            if (this.ked != null) {
                bu2 += g.a.a.b.b.a.f(9, this.ked);
            }
            if (this.MpZ != null) {
                bu2 += g.a.a.a.nh(10, this.MpZ.computeSize());
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(11, this.kee) + g.a.a.b.b.a.bu(12, this.kef);
            if (this.keg != null) {
                bu3 += g.a.a.b.b.a.f(13, this.keg);
            }
            if (this.MmQ != null) {
                bu3 += g.a.a.a.nh(14, this.MmQ.computeSize());
            }
            if (this.keh != null) {
                bu3 += g.a.a.b.b.a.f(15, this.keh);
            }
            if (this.kei != null) {
                bu3 += g.a.a.b.b.a.f(16, this.kei);
            }
            if (this.MmR != null) {
                bu3 += g.a.a.a.nh(17, this.MmR.computeSize());
            }
            if (this.Lir != null) {
                bu3 += g.a.a.b.b.a.f(20, this.Lir);
            }
            if (this.Lis != null) {
                bu3 += g.a.a.b.b.a.f(21, this.Lis);
            }
            if (this.LRO != null) {
                bu3 += g.a.a.b.b.a.f(22, this.LRO);
            }
            AppMethodBeat.o(155440);
            return bu3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(155440);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ckp ckp = (ckp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ckp.Username = aVar3.UbS.readString();
                    AppMethodBeat.o(155440);
                    return 0;
                case 2:
                    ckp.Nickname = aVar3.UbS.readString();
                    AppMethodBeat.o(155440);
                    return 0;
                case 3:
                    ckp.kdX = aVar3.UbS.readString();
                    AppMethodBeat.o(155440);
                    return 0;
                case 4:
                    ckp.kdY = aVar3.UbS.zi();
                    AppMethodBeat.o(155440);
                    return 0;
                case 5:
                    ckp.kdZ = aVar3.UbS.readString();
                    AppMethodBeat.o(155440);
                    return 0;
                case 6:
                    ckp.kea = aVar3.UbS.readString();
                    AppMethodBeat.o(155440);
                    return 0;
                case 7:
                    ckp.keb = aVar3.UbS.readString();
                    AppMethodBeat.o(155440);
                    return 0;
                case 8:
                    ckp.kec = aVar3.UbS.zi();
                    AppMethodBeat.o(155440);
                    return 0;
                case 9:
                    ckp.ked = aVar3.UbS.readString();
                    AppMethodBeat.o(155440);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        alg alg = new alg();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = alg.populateBuilderWithField(aVar4, alg, a.getNextFieldNumber(aVar4))) {
                        }
                        ckp.MpZ = alg;
                    }
                    AppMethodBeat.o(155440);
                    return 0;
                case 11:
                    ckp.kee = aVar3.UbS.zi();
                    AppMethodBeat.o(155440);
                    return 0;
                case 12:
                    ckp.kef = aVar3.UbS.zi();
                    AppMethodBeat.o(155440);
                    return 0;
                case 13:
                    ckp.keg = aVar3.UbS.readString();
                    AppMethodBeat.o(155440);
                    return 0;
                case 14:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ebj ebj = new ebj();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ebj.populateBuilderWithField(aVar5, ebj, a.getNextFieldNumber(aVar5))) {
                        }
                        ckp.MmQ = ebj;
                    }
                    AppMethodBeat.o(155440);
                    return 0;
                case 15:
                    ckp.keh = aVar3.UbS.readString();
                    AppMethodBeat.o(155440);
                    return 0;
                case 16:
                    ckp.kei = aVar3.UbS.readString();
                    AppMethodBeat.o(155440);
                    return 0;
                case 17:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        aeq aeq = new aeq();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = aeq.populateBuilderWithField(aVar6, aeq, a.getNextFieldNumber(aVar6))) {
                        }
                        ckp.MmR = aeq;
                    }
                    AppMethodBeat.o(155440);
                    return 0;
                case 18:
                case 19:
                default:
                    AppMethodBeat.o(155440);
                    return -1;
                case 20:
                    ckp.Lir = aVar3.UbS.readString();
                    AppMethodBeat.o(155440);
                    return 0;
                case 21:
                    ckp.Lis = aVar3.UbS.readString();
                    AppMethodBeat.o(155440);
                    return 0;
                case 22:
                    ckp.LRO = aVar3.UbS.readString();
                    AppMethodBeat.o(155440);
                    return 0;
            }
        } else {
            AppMethodBeat.o(155440);
            return -1;
        }
    }
}
