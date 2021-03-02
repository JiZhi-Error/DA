package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class cme extends dop {
    public int KCx;
    public String KFu;
    public jk KLK;
    public String KLL;
    public int KLM;
    public String KLN;
    public String KLO;
    public SKBuiltinBuffer_t KLP;
    public SKBuiltinBuffer_t KLQ;
    public String KLR;
    public dfx KLS;
    public String Lsj;
    public String Mrw;
    public String Mrx;
    public String Mry;
    public int Mrz;
    public String hid;
    public String hie;
    public int hil;
    public String keb;
    public String oTI;
    public String rBH;
    public String rBI;
    public String yiZ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(133176);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.KLK != null) {
                aVar.ni(2, this.KLK.computeSize());
                this.KLK.writeFields(aVar);
            }
            if (this.yiZ != null) {
                aVar.e(3, this.yiZ);
            }
            if (this.KLL != null) {
                aVar.e(4, this.KLL);
            }
            aVar.aM(5, this.KLM);
            if (this.KLN != null) {
                aVar.e(6, this.KLN);
            }
            if (this.keb != null) {
                aVar.e(7, this.keb);
            }
            if (this.oTI != null) {
                aVar.e(8, this.oTI);
            }
            if (this.KLO != null) {
                aVar.e(9, this.KLO);
            }
            if (this.rBI != null) {
                aVar.e(10, this.rBI);
            }
            if (this.rBH != null) {
                aVar.e(11, this.rBH);
            }
            aVar.aM(13, this.KCx);
            aVar.aM(14, this.hil);
            if (this.hie != null) {
                aVar.e(15, this.hie);
            }
            if (this.hid != null) {
                aVar.e(16, this.hid);
            }
            if (this.Mrw != null) {
                aVar.e(17, this.Mrw);
            }
            if (this.Lsj != null) {
                aVar.e(18, this.Lsj);
            }
            if (this.KLR != null) {
                aVar.e(19, this.KLR);
            }
            if (this.Mrx != null) {
                aVar.e(20, this.Mrx);
            }
            if (this.Mry != null) {
                aVar.e(21, this.Mry);
            }
            aVar.aM(22, this.Mrz);
            if (this.KLP != null) {
                aVar.ni(23, this.KLP.computeSize());
                this.KLP.writeFields(aVar);
            }
            if (this.KLQ != null) {
                aVar.ni(24, this.KLQ.computeSize());
                this.KLQ.writeFields(aVar);
            }
            if (this.KFu != null) {
                aVar.e(25, this.KFu);
            }
            if (this.KLS != null) {
                aVar.ni(26, this.KLS.computeSize());
                this.KLS.writeFields(aVar);
            }
            AppMethodBeat.o(133176);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.KLK != null) {
                nh += g.a.a.a.nh(2, this.KLK.computeSize());
            }
            if (this.yiZ != null) {
                nh += g.a.a.b.b.a.f(3, this.yiZ);
            }
            if (this.KLL != null) {
                nh += g.a.a.b.b.a.f(4, this.KLL);
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.KLM);
            if (this.KLN != null) {
                bu += g.a.a.b.b.a.f(6, this.KLN);
            }
            if (this.keb != null) {
                bu += g.a.a.b.b.a.f(7, this.keb);
            }
            if (this.oTI != null) {
                bu += g.a.a.b.b.a.f(8, this.oTI);
            }
            if (this.KLO != null) {
                bu += g.a.a.b.b.a.f(9, this.KLO);
            }
            if (this.rBI != null) {
                bu += g.a.a.b.b.a.f(10, this.rBI);
            }
            if (this.rBH != null) {
                bu += g.a.a.b.b.a.f(11, this.rBH);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(13, this.KCx) + g.a.a.b.b.a.bu(14, this.hil);
            if (this.hie != null) {
                bu2 += g.a.a.b.b.a.f(15, this.hie);
            }
            if (this.hid != null) {
                bu2 += g.a.a.b.b.a.f(16, this.hid);
            }
            if (this.Mrw != null) {
                bu2 += g.a.a.b.b.a.f(17, this.Mrw);
            }
            if (this.Lsj != null) {
                bu2 += g.a.a.b.b.a.f(18, this.Lsj);
            }
            if (this.KLR != null) {
                bu2 += g.a.a.b.b.a.f(19, this.KLR);
            }
            if (this.Mrx != null) {
                bu2 += g.a.a.b.b.a.f(20, this.Mrx);
            }
            if (this.Mry != null) {
                bu2 += g.a.a.b.b.a.f(21, this.Mry);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(22, this.Mrz);
            if (this.KLP != null) {
                bu3 += g.a.a.a.nh(23, this.KLP.computeSize());
            }
            if (this.KLQ != null) {
                bu3 += g.a.a.a.nh(24, this.KLQ.computeSize());
            }
            if (this.KFu != null) {
                bu3 += g.a.a.b.b.a.f(25, this.KFu);
            }
            if (this.KLS != null) {
                bu3 += g.a.a.a.nh(26, this.KLS.computeSize());
            }
            AppMethodBeat.o(133176);
            return bu3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(133176);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cme cme = (cme) objArr[1];
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
                        cme.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(133176);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        jk jkVar = new jk();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = jkVar.populateBuilderWithField(aVar5, jkVar, dop.getNextFieldNumber(aVar5))) {
                        }
                        cme.KLK = jkVar;
                    }
                    AppMethodBeat.o(133176);
                    return 0;
                case 3:
                    cme.yiZ = aVar3.UbS.readString();
                    AppMethodBeat.o(133176);
                    return 0;
                case 4:
                    cme.KLL = aVar3.UbS.readString();
                    AppMethodBeat.o(133176);
                    return 0;
                case 5:
                    cme.KLM = aVar3.UbS.zi();
                    AppMethodBeat.o(133176);
                    return 0;
                case 6:
                    cme.KLN = aVar3.UbS.readString();
                    AppMethodBeat.o(133176);
                    return 0;
                case 7:
                    cme.keb = aVar3.UbS.readString();
                    AppMethodBeat.o(133176);
                    return 0;
                case 8:
                    cme.oTI = aVar3.UbS.readString();
                    AppMethodBeat.o(133176);
                    return 0;
                case 9:
                    cme.KLO = aVar3.UbS.readString();
                    AppMethodBeat.o(133176);
                    return 0;
                case 10:
                    cme.rBI = aVar3.UbS.readString();
                    AppMethodBeat.o(133176);
                    return 0;
                case 11:
                    cme.rBH = aVar3.UbS.readString();
                    AppMethodBeat.o(133176);
                    return 0;
                case 12:
                default:
                    AppMethodBeat.o(133176);
                    return -1;
                case 13:
                    cme.KCx = aVar3.UbS.zi();
                    AppMethodBeat.o(133176);
                    return 0;
                case 14:
                    cme.hil = aVar3.UbS.zi();
                    AppMethodBeat.o(133176);
                    return 0;
                case 15:
                    cme.hie = aVar3.UbS.readString();
                    AppMethodBeat.o(133176);
                    return 0;
                case 16:
                    cme.hid = aVar3.UbS.readString();
                    AppMethodBeat.o(133176);
                    return 0;
                case 17:
                    cme.Mrw = aVar3.UbS.readString();
                    AppMethodBeat.o(133176);
                    return 0;
                case 18:
                    cme.Lsj = aVar3.UbS.readString();
                    AppMethodBeat.o(133176);
                    return 0;
                case 19:
                    cme.KLR = aVar3.UbS.readString();
                    AppMethodBeat.o(133176);
                    return 0;
                case 20:
                    cme.Mrx = aVar3.UbS.readString();
                    AppMethodBeat.o(133176);
                    return 0;
                case 21:
                    cme.Mry = aVar3.UbS.readString();
                    AppMethodBeat.o(133176);
                    return 0;
                case 22:
                    cme.Mrz = aVar3.UbS.zi();
                    AppMethodBeat.o(133176);
                    return 0;
                case 23:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = sKBuiltinBuffer_t.populateBuilderWithField(aVar6, sKBuiltinBuffer_t, dop.getNextFieldNumber(aVar6))) {
                        }
                        cme.KLP = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(133176);
                    return 0;
                case 24:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t2 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = sKBuiltinBuffer_t2.populateBuilderWithField(aVar7, sKBuiltinBuffer_t2, dop.getNextFieldNumber(aVar7))) {
                        }
                        cme.KLQ = sKBuiltinBuffer_t2;
                    }
                    AppMethodBeat.o(133176);
                    return 0;
                case 25:
                    cme.KFu = aVar3.UbS.readString();
                    AppMethodBeat.o(133176);
                    return 0;
                case 26:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        dfx dfx = new dfx();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = dfx.populateBuilderWithField(aVar8, dfx, dop.getNextFieldNumber(aVar8))) {
                        }
                        cme.KLS = dfx;
                    }
                    AppMethodBeat.o(133176);
                    return 0;
            }
        } else {
            AppMethodBeat.o(133176);
            return -1;
        }
    }
}
