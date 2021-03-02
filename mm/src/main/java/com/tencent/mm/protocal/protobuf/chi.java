package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public class chi extends a {
    public int KHa;
    public int KHo;
    public String LRO;
    public String Lir;
    public String Lis;
    public String MbK;
    public String MmJ;
    public int MmK;
    public String MmL;
    public String MmM;
    public String MmN;
    public int MmO;
    public int MmP;
    public ebj MmQ;
    public aeq MmR;
    public int MmS;
    public String UserName;
    public int kdY;
    public String kdZ;
    public String kea;
    public String keb;
    public String ked;
    public String keh;
    public String kei;
    public String oUJ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(89925);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.UserName != null) {
                aVar.e(1, this.UserName);
            }
            if (this.oUJ != null) {
                aVar.e(2, this.oUJ);
            }
            if (this.kdZ != null) {
                aVar.e(3, this.kdZ);
            }
            if (this.kea != null) {
                aVar.e(4, this.kea);
            }
            if (this.keb != null) {
                aVar.e(5, this.keb);
            }
            if (this.MmJ != null) {
                aVar.e(6, this.MmJ);
            }
            aVar.aM(7, this.kdY);
            aVar.aM(8, this.KHo);
            aVar.aM(9, this.MmK);
            if (this.MmL != null) {
                aVar.e(10, this.MmL);
            }
            if (this.MbK != null) {
                aVar.e(11, this.MbK);
            }
            if (this.ked != null) {
                aVar.e(12, this.ked);
            }
            if (this.MmM != null) {
                aVar.e(13, this.MmM);
            }
            if (this.MmN != null) {
                aVar.e(14, this.MmN);
            }
            aVar.aM(15, this.MmO);
            aVar.aM(19, this.MmP);
            if (this.MmQ != null) {
                aVar.ni(20, this.MmQ.computeSize());
                this.MmQ.writeFields(aVar);
            }
            if (this.keh != null) {
                aVar.e(21, this.keh);
            }
            if (this.Lir != null) {
                aVar.e(22, this.Lir);
            }
            if (this.Lis != null) {
                aVar.e(23, this.Lis);
            }
            if (this.kei != null) {
                aVar.e(24, this.kei);
            }
            if (this.MmR != null) {
                aVar.ni(25, this.MmR.computeSize());
                this.MmR.writeFields(aVar);
            }
            if (this.LRO != null) {
                aVar.e(26, this.LRO);
            }
            aVar.aM(27, this.KHa);
            aVar.aM(28, this.MmS);
            AppMethodBeat.o(89925);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.UserName != null ? g.a.a.b.b.a.f(1, this.UserName) + 0 : 0;
            if (this.oUJ != null) {
                f2 += g.a.a.b.b.a.f(2, this.oUJ);
            }
            if (this.kdZ != null) {
                f2 += g.a.a.b.b.a.f(3, this.kdZ);
            }
            if (this.kea != null) {
                f2 += g.a.a.b.b.a.f(4, this.kea);
            }
            if (this.keb != null) {
                f2 += g.a.a.b.b.a.f(5, this.keb);
            }
            if (this.MmJ != null) {
                f2 += g.a.a.b.b.a.f(6, this.MmJ);
            }
            int bu = f2 + g.a.a.b.b.a.bu(7, this.kdY) + g.a.a.b.b.a.bu(8, this.KHo) + g.a.a.b.b.a.bu(9, this.MmK);
            if (this.MmL != null) {
                bu += g.a.a.b.b.a.f(10, this.MmL);
            }
            if (this.MbK != null) {
                bu += g.a.a.b.b.a.f(11, this.MbK);
            }
            if (this.ked != null) {
                bu += g.a.a.b.b.a.f(12, this.ked);
            }
            if (this.MmM != null) {
                bu += g.a.a.b.b.a.f(13, this.MmM);
            }
            if (this.MmN != null) {
                bu += g.a.a.b.b.a.f(14, this.MmN);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(15, this.MmO) + g.a.a.b.b.a.bu(19, this.MmP);
            if (this.MmQ != null) {
                bu2 += g.a.a.a.nh(20, this.MmQ.computeSize());
            }
            if (this.keh != null) {
                bu2 += g.a.a.b.b.a.f(21, this.keh);
            }
            if (this.Lir != null) {
                bu2 += g.a.a.b.b.a.f(22, this.Lir);
            }
            if (this.Lis != null) {
                bu2 += g.a.a.b.b.a.f(23, this.Lis);
            }
            if (this.kei != null) {
                bu2 += g.a.a.b.b.a.f(24, this.kei);
            }
            if (this.MmR != null) {
                bu2 += g.a.a.a.nh(25, this.MmR.computeSize());
            }
            if (this.LRO != null) {
                bu2 += g.a.a.b.b.a.f(26, this.LRO);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(27, this.KHa) + g.a.a.b.b.a.bu(28, this.MmS);
            AppMethodBeat.o(89925);
            return bu3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(89925);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            chi chi = (chi) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    chi.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(89925);
                    return 0;
                case 2:
                    chi.oUJ = aVar3.UbS.readString();
                    AppMethodBeat.o(89925);
                    return 0;
                case 3:
                    chi.kdZ = aVar3.UbS.readString();
                    AppMethodBeat.o(89925);
                    return 0;
                case 4:
                    chi.kea = aVar3.UbS.readString();
                    AppMethodBeat.o(89925);
                    return 0;
                case 5:
                    chi.keb = aVar3.UbS.readString();
                    AppMethodBeat.o(89925);
                    return 0;
                case 6:
                    chi.MmJ = aVar3.UbS.readString();
                    AppMethodBeat.o(89925);
                    return 0;
                case 7:
                    chi.kdY = aVar3.UbS.zi();
                    AppMethodBeat.o(89925);
                    return 0;
                case 8:
                    chi.KHo = aVar3.UbS.zi();
                    AppMethodBeat.o(89925);
                    return 0;
                case 9:
                    chi.MmK = aVar3.UbS.zi();
                    AppMethodBeat.o(89925);
                    return 0;
                case 10:
                    chi.MmL = aVar3.UbS.readString();
                    AppMethodBeat.o(89925);
                    return 0;
                case 11:
                    chi.MbK = aVar3.UbS.readString();
                    AppMethodBeat.o(89925);
                    return 0;
                case 12:
                    chi.ked = aVar3.UbS.readString();
                    AppMethodBeat.o(89925);
                    return 0;
                case 13:
                    chi.MmM = aVar3.UbS.readString();
                    AppMethodBeat.o(89925);
                    return 0;
                case 14:
                    chi.MmN = aVar3.UbS.readString();
                    AppMethodBeat.o(89925);
                    return 0;
                case 15:
                    chi.MmO = aVar3.UbS.zi();
                    AppMethodBeat.o(89925);
                    return 0;
                case 16:
                case 17:
                case 18:
                default:
                    AppMethodBeat.o(89925);
                    return -1;
                case 19:
                    chi.MmP = aVar3.UbS.zi();
                    AppMethodBeat.o(89925);
                    return 0;
                case 20:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ebj ebj = new ebj();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ebj.populateBuilderWithField(aVar4, ebj, a.getNextFieldNumber(aVar4))) {
                        }
                        chi.MmQ = ebj;
                    }
                    AppMethodBeat.o(89925);
                    return 0;
                case 21:
                    chi.keh = aVar3.UbS.readString();
                    AppMethodBeat.o(89925);
                    return 0;
                case 22:
                    chi.Lir = aVar3.UbS.readString();
                    AppMethodBeat.o(89925);
                    return 0;
                case 23:
                    chi.Lis = aVar3.UbS.readString();
                    AppMethodBeat.o(89925);
                    return 0;
                case 24:
                    chi.kei = aVar3.UbS.readString();
                    AppMethodBeat.o(89925);
                    return 0;
                case 25:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aeq aeq = new aeq();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aeq.populateBuilderWithField(aVar5, aeq, a.getNextFieldNumber(aVar5))) {
                        }
                        chi.MmR = aeq;
                    }
                    AppMethodBeat.o(89925);
                    return 0;
                case 26:
                    chi.LRO = aVar3.UbS.readString();
                    AppMethodBeat.o(89925);
                    return 0;
                case 27:
                    chi.KHa = aVar3.UbS.zi();
                    AppMethodBeat.o(89925);
                    return 0;
                case 28:
                    chi.MmS = aVar3.UbS.zi();
                    AppMethodBeat.o(89925);
                    return 0;
            }
        } else {
            AppMethodBeat.o(89925);
            return -1;
        }
    }
}
