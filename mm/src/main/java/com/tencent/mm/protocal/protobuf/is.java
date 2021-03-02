package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class is extends a {
    public int Brl;
    public long Brn;
    public dqi KHl;
    public dqi KHm;
    public dqi KHn;
    public String KHq;
    public String KIz;
    public int KMN;
    public int KMO;
    public int KMP;
    public LinkedList<dqi> KMQ = new LinkedList<>();
    public LinkedList<dqj> KMR = new LinkedList<>();
    public SKBuiltinBuffer_t KMS;
    public int KMT;
    public int KMU;
    public int KMV;
    public long KMW;
    public int KMX;
    public int oUv;

    public is() {
        AppMethodBeat.i(32137);
        AppMethodBeat.o(32137);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32138);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KHl == null) {
                b bVar = new b("Not all required fields were included: FromUserName");
                AppMethodBeat.o(32138);
                throw bVar;
            } else if (this.KHm == null) {
                b bVar2 = new b("Not all required fields were included: ToUserName");
                AppMethodBeat.o(32138);
                throw bVar2;
            } else if (this.KHn == null) {
                b bVar3 = new b("Not all required fields were included: Content");
                AppMethodBeat.o(32138);
                throw bVar3;
            } else {
                aVar.aM(1, this.oUv);
                if (this.KIz != null) {
                    aVar.e(2, this.KIz);
                }
                if (this.KHl != null) {
                    aVar.ni(3, this.KHl.computeSize());
                    this.KHl.writeFields(aVar);
                }
                if (this.KHm != null) {
                    aVar.ni(4, this.KHm.computeSize());
                    this.KHm.writeFields(aVar);
                }
                if (this.KHn != null) {
                    aVar.ni(5, this.KHn.computeSize());
                    this.KHn.writeFields(aVar);
                }
                aVar.aM(6, this.KMN);
                aVar.aM(7, this.KMO);
                if (this.KHq != null) {
                    aVar.e(8, this.KHq);
                }
                aVar.aM(9, this.Brl);
                aVar.aM(10, this.KMP);
                aVar.e(11, 8, this.KMQ);
                aVar.e(12, 8, this.KMR);
                if (this.KMS != null) {
                    aVar.ni(13, this.KMS.computeSize());
                    this.KMS.writeFields(aVar);
                }
                aVar.aM(14, this.KMT);
                aVar.aM(15, this.KMU);
                aVar.bb(16, this.Brn);
                aVar.aM(17, this.KMV);
                aVar.bb(18, this.KMW);
                aVar.aM(19, this.KMX);
                AppMethodBeat.o(32138);
                return 0;
            }
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.oUv) + 0;
            if (this.KIz != null) {
                bu += g.a.a.b.b.a.f(2, this.KIz);
            }
            if (this.KHl != null) {
                bu += g.a.a.a.nh(3, this.KHl.computeSize());
            }
            if (this.KHm != null) {
                bu += g.a.a.a.nh(4, this.KHm.computeSize());
            }
            if (this.KHn != null) {
                bu += g.a.a.a.nh(5, this.KHn.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(6, this.KMN) + g.a.a.b.b.a.bu(7, this.KMO);
            if (this.KHq != null) {
                bu2 += g.a.a.b.b.a.f(8, this.KHq);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(9, this.Brl) + g.a.a.b.b.a.bu(10, this.KMP) + g.a.a.a.c(11, 8, this.KMQ) + g.a.a.a.c(12, 8, this.KMR);
            if (this.KMS != null) {
                bu3 += g.a.a.a.nh(13, this.KMS.computeSize());
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(14, this.KMT) + g.a.a.b.b.a.bu(15, this.KMU) + g.a.a.b.b.a.r(16, this.Brn) + g.a.a.b.b.a.bu(17, this.KMV) + g.a.a.b.b.a.r(18, this.KMW) + g.a.a.b.b.a.bu(19, this.KMX);
            AppMethodBeat.o(32138);
            return bu4;
        } else if (i2 == 2) {
            this.KMQ.clear();
            this.KMR.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.KHl == null) {
                b bVar4 = new b("Not all required fields were included: FromUserName");
                AppMethodBeat.o(32138);
                throw bVar4;
            } else if (this.KHm == null) {
                b bVar5 = new b("Not all required fields were included: ToUserName");
                AppMethodBeat.o(32138);
                throw bVar5;
            } else if (this.KHn == null) {
                b bVar6 = new b("Not all required fields were included: Content");
                AppMethodBeat.o(32138);
                throw bVar6;
            } else {
                AppMethodBeat.o(32138);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            is isVar = (is) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    isVar.oUv = aVar3.UbS.zi();
                    AppMethodBeat.o(32138);
                    return 0;
                case 2:
                    isVar.KIz = aVar3.UbS.readString();
                    AppMethodBeat.o(32138);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dqi.populateBuilderWithField(aVar4, dqi, a.getNextFieldNumber(aVar4))) {
                        }
                        isVar.KHl = dqi;
                    }
                    AppMethodBeat.o(32138);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dqi dqi2 = new dqi();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dqi2.populateBuilderWithField(aVar5, dqi2, a.getNextFieldNumber(aVar5))) {
                        }
                        isVar.KHm = dqi2;
                    }
                    AppMethodBeat.o(32138);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dqi dqi3 = new dqi();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dqi3.populateBuilderWithField(aVar6, dqi3, a.getNextFieldNumber(aVar6))) {
                        }
                        isVar.KHn = dqi3;
                    }
                    AppMethodBeat.o(32138);
                    return 0;
                case 6:
                    isVar.KMN = aVar3.UbS.zi();
                    AppMethodBeat.o(32138);
                    return 0;
                case 7:
                    isVar.KMO = aVar3.UbS.zi();
                    AppMethodBeat.o(32138);
                    return 0;
                case 8:
                    isVar.KHq = aVar3.UbS.readString();
                    AppMethodBeat.o(32138);
                    return 0;
                case 9:
                    isVar.Brl = aVar3.UbS.zi();
                    AppMethodBeat.o(32138);
                    return 0;
                case 10:
                    isVar.KMP = aVar3.UbS.zi();
                    AppMethodBeat.o(32138);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        dqi dqi4 = new dqi();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = dqi4.populateBuilderWithField(aVar7, dqi4, a.getNextFieldNumber(aVar7))) {
                        }
                        isVar.KMQ.add(dqi4);
                    }
                    AppMethodBeat.o(32138);
                    return 0;
                case 12:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        dqj dqj = new dqj();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = dqj.populateBuilderWithField(aVar8, dqj, a.getNextFieldNumber(aVar8))) {
                        }
                        isVar.KMR.add(dqj);
                    }
                    AppMethodBeat.o(32138);
                    return 0;
                case 13:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = sKBuiltinBuffer_t.populateBuilderWithField(aVar9, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar9))) {
                        }
                        isVar.KMS = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(32138);
                    return 0;
                case 14:
                    isVar.KMT = aVar3.UbS.zi();
                    AppMethodBeat.o(32138);
                    return 0;
                case 15:
                    isVar.KMU = aVar3.UbS.zi();
                    AppMethodBeat.o(32138);
                    return 0;
                case 16:
                    isVar.Brn = aVar3.UbS.zl();
                    AppMethodBeat.o(32138);
                    return 0;
                case 17:
                    isVar.KMV = aVar3.UbS.zi();
                    AppMethodBeat.o(32138);
                    return 0;
                case 18:
                    isVar.KMW = aVar3.UbS.zl();
                    AppMethodBeat.o(32138);
                    return 0;
                case 19:
                    isVar.KMX = aVar3.UbS.zi();
                    AppMethodBeat.o(32138);
                    return 0;
                default:
                    AppMethodBeat.o(32138);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32138);
            return -1;
        }
    }
}
