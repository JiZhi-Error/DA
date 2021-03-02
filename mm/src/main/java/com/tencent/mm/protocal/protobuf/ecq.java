package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class ecq extends a {
    public mp NcM;
    public epf NcN;
    public cxr NcO;
    public long NcP;
    public int NcQ;
    public long NcR;
    public long NcS;
    public b NcT;
    public long NcU;
    public String NcV;
    public long NcW;
    public String finderUsername;
    public long hFK;
    public int mediaType;
    public String objectNonceId;
    public String sessionBuffer;
    public int tCE;
    public int uin;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(169091);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.hFK);
            if (this.NcM != null) {
                aVar.ni(2, this.NcM.computeSize());
                this.NcM.writeFields(aVar);
            }
            if (this.NcN != null) {
                aVar.ni(3, this.NcN.computeSize());
                this.NcN.writeFields(aVar);
            }
            if (this.NcO != null) {
                aVar.ni(4, this.NcO.computeSize());
                this.NcO.writeFields(aVar);
            }
            if (this.objectNonceId != null) {
                aVar.e(5, this.objectNonceId);
            }
            if (this.finderUsername != null) {
                aVar.e(6, this.finderUsername);
            }
            aVar.bb(7, this.NcP);
            aVar.aM(8, this.NcQ);
            if (this.sessionBuffer != null) {
                aVar.e(9, this.sessionBuffer);
            }
            aVar.bb(10, this.NcR);
            aVar.aM(11, this.tCE);
            aVar.bb(12, this.NcS);
            if (this.NcT != null) {
                aVar.c(13, this.NcT);
            }
            aVar.aM(14, this.mediaType);
            aVar.bb(15, this.NcU);
            if (this.NcV != null) {
                aVar.e(16, this.NcV);
            }
            aVar.bb(17, this.NcW);
            aVar.aM(18, this.uin);
            AppMethodBeat.o(169091);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.hFK) + 0;
            if (this.NcM != null) {
                r += g.a.a.a.nh(2, this.NcM.computeSize());
            }
            if (this.NcN != null) {
                r += g.a.a.a.nh(3, this.NcN.computeSize());
            }
            if (this.NcO != null) {
                r += g.a.a.a.nh(4, this.NcO.computeSize());
            }
            if (this.objectNonceId != null) {
                r += g.a.a.b.b.a.f(5, this.objectNonceId);
            }
            if (this.finderUsername != null) {
                r += g.a.a.b.b.a.f(6, this.finderUsername);
            }
            int r2 = r + g.a.a.b.b.a.r(7, this.NcP) + g.a.a.b.b.a.bu(8, this.NcQ);
            if (this.sessionBuffer != null) {
                r2 += g.a.a.b.b.a.f(9, this.sessionBuffer);
            }
            int r3 = r2 + g.a.a.b.b.a.r(10, this.NcR) + g.a.a.b.b.a.bu(11, this.tCE) + g.a.a.b.b.a.r(12, this.NcS);
            if (this.NcT != null) {
                r3 += g.a.a.b.b.a.b(13, this.NcT);
            }
            int bu = r3 + g.a.a.b.b.a.bu(14, this.mediaType) + g.a.a.b.b.a.r(15, this.NcU);
            if (this.NcV != null) {
                bu += g.a.a.b.b.a.f(16, this.NcV);
            }
            int r4 = bu + g.a.a.b.b.a.r(17, this.NcW) + g.a.a.b.b.a.bu(18, this.uin);
            AppMethodBeat.o(169091);
            return r4;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(169091);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ecq ecq = (ecq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ecq.hFK = aVar3.UbS.zl();
                    AppMethodBeat.o(169091);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        mp mpVar = new mp();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = mpVar.populateBuilderWithField(aVar4, mpVar, a.getNextFieldNumber(aVar4))) {
                        }
                        ecq.NcM = mpVar;
                    }
                    AppMethodBeat.o(169091);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        epf epf = new epf();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = epf.populateBuilderWithField(aVar5, epf, a.getNextFieldNumber(aVar5))) {
                        }
                        ecq.NcN = epf;
                    }
                    AppMethodBeat.o(169091);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        cxr cxr = new cxr();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = cxr.populateBuilderWithField(aVar6, cxr, a.getNextFieldNumber(aVar6))) {
                        }
                        ecq.NcO = cxr;
                    }
                    AppMethodBeat.o(169091);
                    return 0;
                case 5:
                    ecq.objectNonceId = aVar3.UbS.readString();
                    AppMethodBeat.o(169091);
                    return 0;
                case 6:
                    ecq.finderUsername = aVar3.UbS.readString();
                    AppMethodBeat.o(169091);
                    return 0;
                case 7:
                    ecq.NcP = aVar3.UbS.zl();
                    AppMethodBeat.o(169091);
                    return 0;
                case 8:
                    ecq.NcQ = aVar3.UbS.zi();
                    AppMethodBeat.o(169091);
                    return 0;
                case 9:
                    ecq.sessionBuffer = aVar3.UbS.readString();
                    AppMethodBeat.o(169091);
                    return 0;
                case 10:
                    ecq.NcR = aVar3.UbS.zl();
                    AppMethodBeat.o(169091);
                    return 0;
                case 11:
                    ecq.tCE = aVar3.UbS.zi();
                    AppMethodBeat.o(169091);
                    return 0;
                case 12:
                    ecq.NcS = aVar3.UbS.zl();
                    AppMethodBeat.o(169091);
                    return 0;
                case 13:
                    ecq.NcT = aVar3.UbS.hPo();
                    AppMethodBeat.o(169091);
                    return 0;
                case 14:
                    ecq.mediaType = aVar3.UbS.zi();
                    AppMethodBeat.o(169091);
                    return 0;
                case 15:
                    ecq.NcU = aVar3.UbS.zl();
                    AppMethodBeat.o(169091);
                    return 0;
                case 16:
                    ecq.NcV = aVar3.UbS.readString();
                    AppMethodBeat.o(169091);
                    return 0;
                case 17:
                    ecq.NcW = aVar3.UbS.zl();
                    AppMethodBeat.o(169091);
                    return 0;
                case 18:
                    ecq.uin = aVar3.UbS.zi();
                    AppMethodBeat.o(169091);
                    return 0;
                default:
                    AppMethodBeat.o(169091);
                    return -1;
            }
        } else {
            AppMethodBeat.o(169091);
            return -1;
        }
    }
}
