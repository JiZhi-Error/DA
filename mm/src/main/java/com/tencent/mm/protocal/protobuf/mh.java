package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class mh extends dop {
    public String KLN;
    public SKBuiltinBuffer_t KLQ;
    public String KLk;
    public int KMz;
    public String KPP;
    public String KPQ;
    public int KPR;
    public String KPS;
    public int KPT;
    public String KPU;
    public String KPV;
    public SKBuiltinBuffer_t KPW;
    public int KPX;
    public int KPY;
    public int KPZ;
    public String KQa;
    public SKBuiltinBuffer_t KQb;
    public String KQc;
    public dyx KQd;
    public cta KQe;
    public String KQf;
    public String UserName;
    public String rBI;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(134243);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.UserName != null) {
                aVar.e(2, this.UserName);
            }
            if (this.KPP != null) {
                aVar.e(3, this.KPP);
            }
            aVar.aM(4, this.KMz);
            if (this.KPQ != null) {
                aVar.e(5, this.KPQ);
            }
            aVar.aM(6, this.KPR);
            if (this.KPS != null) {
                aVar.e(7, this.KPS);
            }
            if (this.KLk != null) {
                aVar.e(8, this.KLk);
            }
            aVar.aM(9, this.KPT);
            if (this.KPU != null) {
                aVar.e(10, this.KPU);
            }
            if (this.KPV != null) {
                aVar.e(11, this.KPV);
            }
            if (this.KPW != null) {
                aVar.ni(12, this.KPW.computeSize());
                this.KPW.writeFields(aVar);
            }
            if (this.rBI != null) {
                aVar.e(13, this.rBI);
            }
            aVar.aM(14, this.KPX);
            aVar.aM(15, this.KPY);
            if (this.KLN != null) {
                aVar.e(16, this.KLN);
            }
            aVar.aM(17, this.KPZ);
            if (this.KQa != null) {
                aVar.e(18, this.KQa);
            }
            if (this.KQb != null) {
                aVar.ni(19, this.KQb.computeSize());
                this.KQb.writeFields(aVar);
            }
            if (this.KLQ != null) {
                aVar.ni(20, this.KLQ.computeSize());
                this.KLQ.writeFields(aVar);
            }
            if (this.KQc != null) {
                aVar.e(21, this.KQc);
            }
            if (this.KQd != null) {
                aVar.ni(22, this.KQd.computeSize());
                this.KQd.writeFields(aVar);
            }
            if (this.KQe != null) {
                aVar.ni(23, this.KQe.computeSize());
                this.KQe.writeFields(aVar);
            }
            if (this.KQf != null) {
                aVar.e(24, this.KQf);
            }
            AppMethodBeat.o(134243);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.UserName != null) {
                nh += g.a.a.b.b.a.f(2, this.UserName);
            }
            if (this.KPP != null) {
                nh += g.a.a.b.b.a.f(3, this.KPP);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.KMz);
            if (this.KPQ != null) {
                bu += g.a.a.b.b.a.f(5, this.KPQ);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(6, this.KPR);
            if (this.KPS != null) {
                bu2 += g.a.a.b.b.a.f(7, this.KPS);
            }
            if (this.KLk != null) {
                bu2 += g.a.a.b.b.a.f(8, this.KLk);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(9, this.KPT);
            if (this.KPU != null) {
                bu3 += g.a.a.b.b.a.f(10, this.KPU);
            }
            if (this.KPV != null) {
                bu3 += g.a.a.b.b.a.f(11, this.KPV);
            }
            if (this.KPW != null) {
                bu3 += g.a.a.a.nh(12, this.KPW.computeSize());
            }
            if (this.rBI != null) {
                bu3 += g.a.a.b.b.a.f(13, this.rBI);
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(14, this.KPX) + g.a.a.b.b.a.bu(15, this.KPY);
            if (this.KLN != null) {
                bu4 += g.a.a.b.b.a.f(16, this.KLN);
            }
            int bu5 = bu4 + g.a.a.b.b.a.bu(17, this.KPZ);
            if (this.KQa != null) {
                bu5 += g.a.a.b.b.a.f(18, this.KQa);
            }
            if (this.KQb != null) {
                bu5 += g.a.a.a.nh(19, this.KQb.computeSize());
            }
            if (this.KLQ != null) {
                bu5 += g.a.a.a.nh(20, this.KLQ.computeSize());
            }
            if (this.KQc != null) {
                bu5 += g.a.a.b.b.a.f(21, this.KQc);
            }
            if (this.KQd != null) {
                bu5 += g.a.a.a.nh(22, this.KQd.computeSize());
            }
            if (this.KQe != null) {
                bu5 += g.a.a.a.nh(23, this.KQe.computeSize());
            }
            if (this.KQf != null) {
                bu5 += g.a.a.b.b.a.f(24, this.KQf);
            }
            AppMethodBeat.o(134243);
            return bu5;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(134243);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            mh mhVar = (mh) objArr[1];
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
                        mhVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(134243);
                    return 0;
                case 2:
                    mhVar.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(134243);
                    return 0;
                case 3:
                    mhVar.KPP = aVar3.UbS.readString();
                    AppMethodBeat.o(134243);
                    return 0;
                case 4:
                    mhVar.KMz = aVar3.UbS.zi();
                    AppMethodBeat.o(134243);
                    return 0;
                case 5:
                    mhVar.KPQ = aVar3.UbS.readString();
                    AppMethodBeat.o(134243);
                    return 0;
                case 6:
                    mhVar.KPR = aVar3.UbS.zi();
                    AppMethodBeat.o(134243);
                    return 0;
                case 7:
                    mhVar.KPS = aVar3.UbS.readString();
                    AppMethodBeat.o(134243);
                    return 0;
                case 8:
                    mhVar.KLk = aVar3.UbS.readString();
                    AppMethodBeat.o(134243);
                    return 0;
                case 9:
                    mhVar.KPT = aVar3.UbS.zi();
                    AppMethodBeat.o(134243);
                    return 0;
                case 10:
                    mhVar.KPU = aVar3.UbS.readString();
                    AppMethodBeat.o(134243);
                    return 0;
                case 11:
                    mhVar.KPV = aVar3.UbS.readString();
                    AppMethodBeat.o(134243);
                    return 0;
                case 12:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t.populateBuilderWithField(aVar5, sKBuiltinBuffer_t, dop.getNextFieldNumber(aVar5))) {
                        }
                        mhVar.KPW = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(134243);
                    return 0;
                case 13:
                    mhVar.rBI = aVar3.UbS.readString();
                    AppMethodBeat.o(134243);
                    return 0;
                case 14:
                    mhVar.KPX = aVar3.UbS.zi();
                    AppMethodBeat.o(134243);
                    return 0;
                case 15:
                    mhVar.KPY = aVar3.UbS.zi();
                    AppMethodBeat.o(134243);
                    return 0;
                case 16:
                    mhVar.KLN = aVar3.UbS.readString();
                    AppMethodBeat.o(134243);
                    return 0;
                case 17:
                    mhVar.KPZ = aVar3.UbS.zi();
                    AppMethodBeat.o(134243);
                    return 0;
                case 18:
                    mhVar.KQa = aVar3.UbS.readString();
                    AppMethodBeat.o(134243);
                    return 0;
                case 19:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t2 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = sKBuiltinBuffer_t2.populateBuilderWithField(aVar6, sKBuiltinBuffer_t2, dop.getNextFieldNumber(aVar6))) {
                        }
                        mhVar.KQb = sKBuiltinBuffer_t2;
                    }
                    AppMethodBeat.o(134243);
                    return 0;
                case 20:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t3 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = sKBuiltinBuffer_t3.populateBuilderWithField(aVar7, sKBuiltinBuffer_t3, dop.getNextFieldNumber(aVar7))) {
                        }
                        mhVar.KLQ = sKBuiltinBuffer_t3;
                    }
                    AppMethodBeat.o(134243);
                    return 0;
                case 21:
                    mhVar.KQc = aVar3.UbS.readString();
                    AppMethodBeat.o(134243);
                    return 0;
                case 22:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        dyx dyx = new dyx();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = dyx.populateBuilderWithField(aVar8, dyx, dop.getNextFieldNumber(aVar8))) {
                        }
                        mhVar.KQd = dyx;
                    }
                    AppMethodBeat.o(134243);
                    return 0;
                case 23:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        cta cta = new cta();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = cta.populateBuilderWithField(aVar9, cta, dop.getNextFieldNumber(aVar9))) {
                        }
                        mhVar.KQe = cta;
                    }
                    AppMethodBeat.o(134243);
                    return 0;
                case 24:
                    mhVar.KQf = aVar3.UbS.readString();
                    AppMethodBeat.o(134243);
                    return 0;
                default:
                    AppMethodBeat.o(134243);
                    return -1;
            }
        } else {
            AppMethodBeat.o(134243);
            return -1;
        }
    }
}
