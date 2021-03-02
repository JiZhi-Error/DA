package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class hx extends dop {
    public int KCx;
    public String KFu;
    public SKBuiltinBuffer_t KKZ;
    public jk KLK;
    public String KLL;
    public int KLM;
    public String KLN;
    public String KLO;
    public SKBuiltinBuffer_t KLP;
    public SKBuiltinBuffer_t KLQ;
    public String KLR;
    public dfx KLS;
    public String keb;
    public String oTI;
    public String rBH;
    public String rBI;
    public String yiZ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(133146);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.KKZ == null) {
                b bVar = new b("Not all required fields were included: AutoAuthKey");
                AppMethodBeat.o(133146);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.KLK != null) {
                aVar.ni(2, this.KLK.computeSize());
                this.KLK.writeFields(aVar);
            }
            if (this.KKZ != null) {
                aVar.ni(3, this.KKZ.computeSize());
                this.KKZ.writeFields(aVar);
            }
            if (this.yiZ != null) {
                aVar.e(4, this.yiZ);
            }
            if (this.KLL != null) {
                aVar.e(5, this.KLL);
            }
            aVar.aM(6, this.KLM);
            if (this.KLN != null) {
                aVar.e(7, this.KLN);
            }
            if (this.keb != null) {
                aVar.e(8, this.keb);
            }
            if (this.oTI != null) {
                aVar.e(9, this.oTI);
            }
            if (this.KLO != null) {
                aVar.e(10, this.KLO);
            }
            if (this.rBI != null) {
                aVar.e(11, this.rBI);
            }
            if (this.rBH != null) {
                aVar.e(12, this.rBH);
            }
            aVar.aM(13, this.KCx);
            if (this.KLP != null) {
                aVar.ni(14, this.KLP.computeSize());
                this.KLP.writeFields(aVar);
            }
            if (this.KLQ != null) {
                aVar.ni(15, this.KLQ.computeSize());
                this.KLQ.writeFields(aVar);
            }
            if (this.KLR != null) {
                aVar.e(16, this.KLR);
            }
            if (this.KFu != null) {
                aVar.e(17, this.KFu);
            }
            if (this.KLS != null) {
                aVar.ni(18, this.KLS.computeSize());
                this.KLS.writeFields(aVar);
            }
            AppMethodBeat.o(133146);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.KLK != null) {
                nh += g.a.a.a.nh(2, this.KLK.computeSize());
            }
            if (this.KKZ != null) {
                nh += g.a.a.a.nh(3, this.KKZ.computeSize());
            }
            if (this.yiZ != null) {
                nh += g.a.a.b.b.a.f(4, this.yiZ);
            }
            if (this.KLL != null) {
                nh += g.a.a.b.b.a.f(5, this.KLL);
            }
            int bu = nh + g.a.a.b.b.a.bu(6, this.KLM);
            if (this.KLN != null) {
                bu += g.a.a.b.b.a.f(7, this.KLN);
            }
            if (this.keb != null) {
                bu += g.a.a.b.b.a.f(8, this.keb);
            }
            if (this.oTI != null) {
                bu += g.a.a.b.b.a.f(9, this.oTI);
            }
            if (this.KLO != null) {
                bu += g.a.a.b.b.a.f(10, this.KLO);
            }
            if (this.rBI != null) {
                bu += g.a.a.b.b.a.f(11, this.rBI);
            }
            if (this.rBH != null) {
                bu += g.a.a.b.b.a.f(12, this.rBH);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(13, this.KCx);
            if (this.KLP != null) {
                bu2 += g.a.a.a.nh(14, this.KLP.computeSize());
            }
            if (this.KLQ != null) {
                bu2 += g.a.a.a.nh(15, this.KLQ.computeSize());
            }
            if (this.KLR != null) {
                bu2 += g.a.a.b.b.a.f(16, this.KLR);
            }
            if (this.KFu != null) {
                bu2 += g.a.a.b.b.a.f(17, this.KFu);
            }
            if (this.KLS != null) {
                bu2 += g.a.a.a.nh(18, this.KLS.computeSize());
            }
            AppMethodBeat.o(133146);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.KKZ == null) {
                b bVar2 = new b("Not all required fields were included: AutoAuthKey");
                AppMethodBeat.o(133146);
                throw bVar2;
            }
            AppMethodBeat.o(133146);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            hx hxVar = (hx) objArr[1];
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
                        hxVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(133146);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        jk jkVar = new jk();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = jkVar.populateBuilderWithField(aVar5, jkVar, dop.getNextFieldNumber(aVar5))) {
                        }
                        hxVar.KLK = jkVar;
                    }
                    AppMethodBeat.o(133146);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = sKBuiltinBuffer_t.populateBuilderWithField(aVar6, sKBuiltinBuffer_t, dop.getNextFieldNumber(aVar6))) {
                        }
                        hxVar.KKZ = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(133146);
                    return 0;
                case 4:
                    hxVar.yiZ = aVar3.UbS.readString();
                    AppMethodBeat.o(133146);
                    return 0;
                case 5:
                    hxVar.KLL = aVar3.UbS.readString();
                    AppMethodBeat.o(133146);
                    return 0;
                case 6:
                    hxVar.KLM = aVar3.UbS.zi();
                    AppMethodBeat.o(133146);
                    return 0;
                case 7:
                    hxVar.KLN = aVar3.UbS.readString();
                    AppMethodBeat.o(133146);
                    return 0;
                case 8:
                    hxVar.keb = aVar3.UbS.readString();
                    AppMethodBeat.o(133146);
                    return 0;
                case 9:
                    hxVar.oTI = aVar3.UbS.readString();
                    AppMethodBeat.o(133146);
                    return 0;
                case 10:
                    hxVar.KLO = aVar3.UbS.readString();
                    AppMethodBeat.o(133146);
                    return 0;
                case 11:
                    hxVar.rBI = aVar3.UbS.readString();
                    AppMethodBeat.o(133146);
                    return 0;
                case 12:
                    hxVar.rBH = aVar3.UbS.readString();
                    AppMethodBeat.o(133146);
                    return 0;
                case 13:
                    hxVar.KCx = aVar3.UbS.zi();
                    AppMethodBeat.o(133146);
                    return 0;
                case 14:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t2 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = sKBuiltinBuffer_t2.populateBuilderWithField(aVar7, sKBuiltinBuffer_t2, dop.getNextFieldNumber(aVar7))) {
                        }
                        hxVar.KLP = sKBuiltinBuffer_t2;
                    }
                    AppMethodBeat.o(133146);
                    return 0;
                case 15:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t3 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = sKBuiltinBuffer_t3.populateBuilderWithField(aVar8, sKBuiltinBuffer_t3, dop.getNextFieldNumber(aVar8))) {
                        }
                        hxVar.KLQ = sKBuiltinBuffer_t3;
                    }
                    AppMethodBeat.o(133146);
                    return 0;
                case 16:
                    hxVar.KLR = aVar3.UbS.readString();
                    AppMethodBeat.o(133146);
                    return 0;
                case 17:
                    hxVar.KFu = aVar3.UbS.readString();
                    AppMethodBeat.o(133146);
                    return 0;
                case 18:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        dfx dfx = new dfx();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = dfx.populateBuilderWithField(aVar9, dfx, dop.getNextFieldNumber(aVar9))) {
                        }
                        hxVar.KLS = dfx;
                    }
                    AppMethodBeat.o(133146);
                    return 0;
                default:
                    AppMethodBeat.o(133146);
                    return -1;
            }
        } else {
            AppMethodBeat.o(133146);
            return -1;
        }
    }
}
