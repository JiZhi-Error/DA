package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class dwv extends a {
    public int KHo;
    public String LRO;
    public String Lir;
    public String Lis;
    public int MWP;
    public SKBuiltinBuffer_t MWQ;
    public int MWR;
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
    public String UserName;
    public int kdY;
    public String kdZ;
    public String kea;
    public String keb;
    public String keh;
    public String kei;
    public String oUJ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32440);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MWQ == null) {
                b bVar = new b("Not all required fields were included: ImgBuffer");
                AppMethodBeat.o(32440);
                throw bVar;
            }
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
            aVar.aM(9, this.MWP);
            if (this.MWQ != null) {
                aVar.ni(10, this.MWQ.computeSize());
                this.MWQ.writeFields(aVar);
            }
            aVar.aM(11, this.MWR);
            if (this.MmM != null) {
                aVar.e(12, this.MmM);
            }
            if (this.MmN != null) {
                aVar.e(13, this.MmN);
            }
            aVar.aM(14, this.MmO);
            aVar.aM(15, this.MmK);
            if (this.MmL != null) {
                aVar.e(16, this.MmL);
            }
            if (this.MbK != null) {
                aVar.e(17, this.MbK);
            }
            aVar.aM(21, this.MmP);
            if (this.MmQ != null) {
                aVar.ni(22, this.MmQ.computeSize());
                this.MmQ.writeFields(aVar);
            }
            if (this.keh != null) {
                aVar.e(23, this.keh);
            }
            if (this.Lir != null) {
                aVar.e(24, this.Lir);
            }
            if (this.Lis != null) {
                aVar.e(25, this.Lis);
            }
            if (this.kei != null) {
                aVar.e(26, this.kei);
            }
            if (this.MmR != null) {
                aVar.ni(27, this.MmR.computeSize());
                this.MmR.writeFields(aVar);
            }
            if (this.LRO != null) {
                aVar.e(28, this.LRO);
            }
            AppMethodBeat.o(32440);
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
            int bu = f2 + g.a.a.b.b.a.bu(7, this.kdY) + g.a.a.b.b.a.bu(8, this.KHo) + g.a.a.b.b.a.bu(9, this.MWP);
            if (this.MWQ != null) {
                bu += g.a.a.a.nh(10, this.MWQ.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(11, this.MWR);
            if (this.MmM != null) {
                bu2 += g.a.a.b.b.a.f(12, this.MmM);
            }
            if (this.MmN != null) {
                bu2 += g.a.a.b.b.a.f(13, this.MmN);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(14, this.MmO) + g.a.a.b.b.a.bu(15, this.MmK);
            if (this.MmL != null) {
                bu3 += g.a.a.b.b.a.f(16, this.MmL);
            }
            if (this.MbK != null) {
                bu3 += g.a.a.b.b.a.f(17, this.MbK);
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(21, this.MmP);
            if (this.MmQ != null) {
                bu4 += g.a.a.a.nh(22, this.MmQ.computeSize());
            }
            if (this.keh != null) {
                bu4 += g.a.a.b.b.a.f(23, this.keh);
            }
            if (this.Lir != null) {
                bu4 += g.a.a.b.b.a.f(24, this.Lir);
            }
            if (this.Lis != null) {
                bu4 += g.a.a.b.b.a.f(25, this.Lis);
            }
            if (this.kei != null) {
                bu4 += g.a.a.b.b.a.f(26, this.kei);
            }
            if (this.MmR != null) {
                bu4 += g.a.a.a.nh(27, this.MmR.computeSize());
            }
            if (this.LRO != null) {
                bu4 += g.a.a.b.b.a.f(28, this.LRO);
            }
            AppMethodBeat.o(32440);
            return bu4;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.MWQ == null) {
                b bVar2 = new b("Not all required fields were included: ImgBuffer");
                AppMethodBeat.o(32440);
                throw bVar2;
            }
            AppMethodBeat.o(32440);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dwv dwv = (dwv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dwv.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(32440);
                    return 0;
                case 2:
                    dwv.oUJ = aVar3.UbS.readString();
                    AppMethodBeat.o(32440);
                    return 0;
                case 3:
                    dwv.kdZ = aVar3.UbS.readString();
                    AppMethodBeat.o(32440);
                    return 0;
                case 4:
                    dwv.kea = aVar3.UbS.readString();
                    AppMethodBeat.o(32440);
                    return 0;
                case 5:
                    dwv.keb = aVar3.UbS.readString();
                    AppMethodBeat.o(32440);
                    return 0;
                case 6:
                    dwv.MmJ = aVar3.UbS.readString();
                    AppMethodBeat.o(32440);
                    return 0;
                case 7:
                    dwv.kdY = aVar3.UbS.zi();
                    AppMethodBeat.o(32440);
                    return 0;
                case 8:
                    dwv.KHo = aVar3.UbS.zi();
                    AppMethodBeat.o(32440);
                    return 0;
                case 9:
                    dwv.MWP = aVar3.UbS.zi();
                    AppMethodBeat.o(32440);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        dwv.MWQ = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(32440);
                    return 0;
                case 11:
                    dwv.MWR = aVar3.UbS.zi();
                    AppMethodBeat.o(32440);
                    return 0;
                case 12:
                    dwv.MmM = aVar3.UbS.readString();
                    AppMethodBeat.o(32440);
                    return 0;
                case 13:
                    dwv.MmN = aVar3.UbS.readString();
                    AppMethodBeat.o(32440);
                    return 0;
                case 14:
                    dwv.MmO = aVar3.UbS.zi();
                    AppMethodBeat.o(32440);
                    return 0;
                case 15:
                    dwv.MmK = aVar3.UbS.zi();
                    AppMethodBeat.o(32440);
                    return 0;
                case 16:
                    dwv.MmL = aVar3.UbS.readString();
                    AppMethodBeat.o(32440);
                    return 0;
                case 17:
                    dwv.MbK = aVar3.UbS.readString();
                    AppMethodBeat.o(32440);
                    return 0;
                case 18:
                case 19:
                case 20:
                default:
                    AppMethodBeat.o(32440);
                    return -1;
                case 21:
                    dwv.MmP = aVar3.UbS.zi();
                    AppMethodBeat.o(32440);
                    return 0;
                case 22:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ebj ebj = new ebj();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ebj.populateBuilderWithField(aVar5, ebj, a.getNextFieldNumber(aVar5))) {
                        }
                        dwv.MmQ = ebj;
                    }
                    AppMethodBeat.o(32440);
                    return 0;
                case 23:
                    dwv.keh = aVar3.UbS.readString();
                    AppMethodBeat.o(32440);
                    return 0;
                case 24:
                    dwv.Lir = aVar3.UbS.readString();
                    AppMethodBeat.o(32440);
                    return 0;
                case 25:
                    dwv.Lis = aVar3.UbS.readString();
                    AppMethodBeat.o(32440);
                    return 0;
                case 26:
                    dwv.kei = aVar3.UbS.readString();
                    AppMethodBeat.o(32440);
                    return 0;
                case 27:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        aeq aeq = new aeq();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = aeq.populateBuilderWithField(aVar6, aeq, a.getNextFieldNumber(aVar6))) {
                        }
                        dwv.MmR = aeq;
                    }
                    AppMethodBeat.o(32440);
                    return 0;
                case 28:
                    dwv.LRO = aVar3.UbS.readString();
                    AppMethodBeat.o(32440);
                    return 0;
            }
        } else {
            AppMethodBeat.o(32440);
            return -1;
        }
    }
}
