package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dgk extends a {
    public String LRO;
    public String Lir;
    public String Lis;
    public int MKZ;
    public String MLa;
    public int MLb;
    public String MLc;
    public ebj MmQ;
    public aeq MmR;
    public String UserName;
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
    public String oUJ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(155448);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.MKZ);
            if (this.UserName != null) {
                aVar.e(2, this.UserName);
            }
            if (this.oUJ != null) {
                aVar.e(3, this.oUJ);
            }
            if (this.MLa != null) {
                aVar.e(4, this.MLa);
            }
            aVar.aM(5, this.MLb);
            if (this.MLc != null) {
                aVar.e(6, this.MLc);
            }
            aVar.aM(7, this.kdY);
            if (this.kdZ != null) {
                aVar.e(8, this.kdZ);
            }
            if (this.kea != null) {
                aVar.e(9, this.kea);
            }
            if (this.keb != null) {
                aVar.e(10, this.keb);
            }
            aVar.aM(11, this.kec);
            if (this.ked != null) {
                aVar.e(12, this.ked);
            }
            aVar.aM(13, this.kee);
            aVar.aM(14, this.kef);
            if (this.keg != null) {
                aVar.e(15, this.keg);
            }
            if (this.MmQ != null) {
                aVar.ni(16, this.MmQ.computeSize());
                this.MmQ.writeFields(aVar);
            }
            if (this.keh != null) {
                aVar.e(17, this.keh);
            }
            if (this.kei != null) {
                aVar.e(18, this.kei);
            }
            if (this.MmR != null) {
                aVar.ni(19, this.MmR.computeSize());
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
            AppMethodBeat.o(155448);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.MKZ) + 0;
            if (this.UserName != null) {
                bu += g.a.a.b.b.a.f(2, this.UserName);
            }
            if (this.oUJ != null) {
                bu += g.a.a.b.b.a.f(3, this.oUJ);
            }
            if (this.MLa != null) {
                bu += g.a.a.b.b.a.f(4, this.MLa);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(5, this.MLb);
            if (this.MLc != null) {
                bu2 += g.a.a.b.b.a.f(6, this.MLc);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(7, this.kdY);
            if (this.kdZ != null) {
                bu3 += g.a.a.b.b.a.f(8, this.kdZ);
            }
            if (this.kea != null) {
                bu3 += g.a.a.b.b.a.f(9, this.kea);
            }
            if (this.keb != null) {
                bu3 += g.a.a.b.b.a.f(10, this.keb);
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(11, this.kec);
            if (this.ked != null) {
                bu4 += g.a.a.b.b.a.f(12, this.ked);
            }
            int bu5 = bu4 + g.a.a.b.b.a.bu(13, this.kee) + g.a.a.b.b.a.bu(14, this.kef);
            if (this.keg != null) {
                bu5 += g.a.a.b.b.a.f(15, this.keg);
            }
            if (this.MmQ != null) {
                bu5 += g.a.a.a.nh(16, this.MmQ.computeSize());
            }
            if (this.keh != null) {
                bu5 += g.a.a.b.b.a.f(17, this.keh);
            }
            if (this.kei != null) {
                bu5 += g.a.a.b.b.a.f(18, this.kei);
            }
            if (this.MmR != null) {
                bu5 += g.a.a.a.nh(19, this.MmR.computeSize());
            }
            if (this.Lir != null) {
                bu5 += g.a.a.b.b.a.f(20, this.Lir);
            }
            if (this.Lis != null) {
                bu5 += g.a.a.b.b.a.f(21, this.Lis);
            }
            if (this.LRO != null) {
                bu5 += g.a.a.b.b.a.f(22, this.LRO);
            }
            AppMethodBeat.o(155448);
            return bu5;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(155448);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dgk dgk = (dgk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dgk.MKZ = aVar3.UbS.zi();
                    AppMethodBeat.o(155448);
                    return 0;
                case 2:
                    dgk.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(155448);
                    return 0;
                case 3:
                    dgk.oUJ = aVar3.UbS.readString();
                    AppMethodBeat.o(155448);
                    return 0;
                case 4:
                    dgk.MLa = aVar3.UbS.readString();
                    AppMethodBeat.o(155448);
                    return 0;
                case 5:
                    dgk.MLb = aVar3.UbS.zi();
                    AppMethodBeat.o(155448);
                    return 0;
                case 6:
                    dgk.MLc = aVar3.UbS.readString();
                    AppMethodBeat.o(155448);
                    return 0;
                case 7:
                    dgk.kdY = aVar3.UbS.zi();
                    AppMethodBeat.o(155448);
                    return 0;
                case 8:
                    dgk.kdZ = aVar3.UbS.readString();
                    AppMethodBeat.o(155448);
                    return 0;
                case 9:
                    dgk.kea = aVar3.UbS.readString();
                    AppMethodBeat.o(155448);
                    return 0;
                case 10:
                    dgk.keb = aVar3.UbS.readString();
                    AppMethodBeat.o(155448);
                    return 0;
                case 11:
                    dgk.kec = aVar3.UbS.zi();
                    AppMethodBeat.o(155448);
                    return 0;
                case 12:
                    dgk.ked = aVar3.UbS.readString();
                    AppMethodBeat.o(155448);
                    return 0;
                case 13:
                    dgk.kee = aVar3.UbS.zi();
                    AppMethodBeat.o(155448);
                    return 0;
                case 14:
                    dgk.kef = aVar3.UbS.zi();
                    AppMethodBeat.o(155448);
                    return 0;
                case 15:
                    dgk.keg = aVar3.UbS.readString();
                    AppMethodBeat.o(155448);
                    return 0;
                case 16:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ebj ebj = new ebj();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ebj.populateBuilderWithField(aVar4, ebj, a.getNextFieldNumber(aVar4))) {
                        }
                        dgk.MmQ = ebj;
                    }
                    AppMethodBeat.o(155448);
                    return 0;
                case 17:
                    dgk.keh = aVar3.UbS.readString();
                    AppMethodBeat.o(155448);
                    return 0;
                case 18:
                    dgk.kei = aVar3.UbS.readString();
                    AppMethodBeat.o(155448);
                    return 0;
                case 19:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aeq aeq = new aeq();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aeq.populateBuilderWithField(aVar5, aeq, a.getNextFieldNumber(aVar5))) {
                        }
                        dgk.MmR = aeq;
                    }
                    AppMethodBeat.o(155448);
                    return 0;
                case 20:
                    dgk.Lir = aVar3.UbS.readString();
                    AppMethodBeat.o(155448);
                    return 0;
                case 21:
                    dgk.Lis = aVar3.UbS.readString();
                    AppMethodBeat.o(155448);
                    return 0;
                case 22:
                    dgk.LRO = aVar3.UbS.readString();
                    AppMethodBeat.o(155448);
                    return 0;
                default:
                    AppMethodBeat.o(155448);
                    return -1;
            }
        } else {
            AppMethodBeat.o(155448);
            return -1;
        }
    }
}
