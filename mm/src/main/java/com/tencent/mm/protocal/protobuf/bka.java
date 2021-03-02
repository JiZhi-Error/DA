package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bka extends dpc {
    public tc KQK;
    public tc KQL;
    public tc KQM;
    public SKBuiltinBuffer_t KQN;
    public SKBuiltinBuffer_t KQO;
    public tc KQP;
    public int KQQ;
    public tb KQR;
    public tb KQS;
    public int LTq;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152567);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(152567);
                throw bVar;
            } else if (this.KQK == null) {
                b bVar2 = new b("Not all required fields were included: DnsInfo");
                AppMethodBeat.o(152567);
                throw bVar2;
            } else {
                if (this.BaseResponse != null) {
                    aVar.ni(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                if (this.KQK != null) {
                    aVar.ni(2, this.KQK.computeSize());
                    this.KQK.writeFields(aVar);
                }
                if (this.KQL != null) {
                    aVar.ni(3, this.KQL.computeSize());
                    this.KQL.writeFields(aVar);
                }
                if (this.KQM != null) {
                    aVar.ni(4, this.KQM.computeSize());
                    this.KQM.writeFields(aVar);
                }
                if (this.KQN != null) {
                    aVar.ni(5, this.KQN.computeSize());
                    this.KQN.writeFields(aVar);
                }
                if (this.KQO != null) {
                    aVar.ni(6, this.KQO.computeSize());
                    this.KQO.writeFields(aVar);
                }
                if (this.KQP != null) {
                    aVar.ni(7, this.KQP.computeSize());
                    this.KQP.writeFields(aVar);
                }
                aVar.aM(8, this.KQQ);
                if (this.KQR != null) {
                    aVar.ni(9, this.KQR.computeSize());
                    this.KQR.writeFields(aVar);
                }
                if (this.KQS != null) {
                    aVar.ni(10, this.KQS.computeSize());
                    this.KQS.writeFields(aVar);
                }
                aVar.aM(11, this.LTq);
                AppMethodBeat.o(152567);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.KQK != null) {
                nh += g.a.a.a.nh(2, this.KQK.computeSize());
            }
            if (this.KQL != null) {
                nh += g.a.a.a.nh(3, this.KQL.computeSize());
            }
            if (this.KQM != null) {
                nh += g.a.a.a.nh(4, this.KQM.computeSize());
            }
            if (this.KQN != null) {
                nh += g.a.a.a.nh(5, this.KQN.computeSize());
            }
            if (this.KQO != null) {
                nh += g.a.a.a.nh(6, this.KQO.computeSize());
            }
            if (this.KQP != null) {
                nh += g.a.a.a.nh(7, this.KQP.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(8, this.KQQ);
            if (this.KQR != null) {
                bu += g.a.a.a.nh(9, this.KQR.computeSize());
            }
            if (this.KQS != null) {
                bu += g.a.a.a.nh(10, this.KQS.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(11, this.LTq);
            AppMethodBeat.o(152567);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar3 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(152567);
                throw bVar3;
            } else if (this.KQK == null) {
                b bVar4 = new b("Not all required fields were included: DnsInfo");
                AppMethodBeat.o(152567);
                throw bVar4;
            } else {
                AppMethodBeat.o(152567);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bka bka = (bka) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        BaseResponse baseResponse = new BaseResponse();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = baseResponse.populateBuilderWithField(aVar4, baseResponse, dpc.getNextFieldNumber(aVar4))) {
                        }
                        bka.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(152567);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        tc tcVar = new tc();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = tcVar.populateBuilderWithField(aVar5, tcVar, dpc.getNextFieldNumber(aVar5))) {
                        }
                        bka.KQK = tcVar;
                    }
                    AppMethodBeat.o(152567);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        tc tcVar2 = new tc();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = tcVar2.populateBuilderWithField(aVar6, tcVar2, dpc.getNextFieldNumber(aVar6))) {
                        }
                        bka.KQL = tcVar2;
                    }
                    AppMethodBeat.o(152567);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        tc tcVar3 = new tc();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = tcVar3.populateBuilderWithField(aVar7, tcVar3, dpc.getNextFieldNumber(aVar7))) {
                        }
                        bka.KQM = tcVar3;
                    }
                    AppMethodBeat.o(152567);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = sKBuiltinBuffer_t.populateBuilderWithField(aVar8, sKBuiltinBuffer_t, dpc.getNextFieldNumber(aVar8))) {
                        }
                        bka.KQN = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(152567);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t2 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = sKBuiltinBuffer_t2.populateBuilderWithField(aVar9, sKBuiltinBuffer_t2, dpc.getNextFieldNumber(aVar9))) {
                        }
                        bka.KQO = sKBuiltinBuffer_t2;
                    }
                    AppMethodBeat.o(152567);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        tc tcVar4 = new tc();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = tcVar4.populateBuilderWithField(aVar10, tcVar4, dpc.getNextFieldNumber(aVar10))) {
                        }
                        bka.KQP = tcVar4;
                    }
                    AppMethodBeat.o(152567);
                    return 0;
                case 8:
                    bka.KQQ = aVar3.UbS.zi();
                    AppMethodBeat.o(152567);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh8 = aVar3.awh(intValue);
                    int size8 = awh8.size();
                    for (int i10 = 0; i10 < size8; i10++) {
                        tb tbVar = new tb();
                        g.a.a.a.a aVar11 = new g.a.a.a.a(awh8.get(i10), unknownTagHandler);
                        for (boolean z8 = true; z8; z8 = tbVar.populateBuilderWithField(aVar11, tbVar, dpc.getNextFieldNumber(aVar11))) {
                        }
                        bka.KQR = tbVar;
                    }
                    AppMethodBeat.o(152567);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh9 = aVar3.awh(intValue);
                    int size9 = awh9.size();
                    for (int i11 = 0; i11 < size9; i11++) {
                        tb tbVar2 = new tb();
                        g.a.a.a.a aVar12 = new g.a.a.a.a(awh9.get(i11), unknownTagHandler);
                        for (boolean z9 = true; z9; z9 = tbVar2.populateBuilderWithField(aVar12, tbVar2, dpc.getNextFieldNumber(aVar12))) {
                        }
                        bka.KQS = tbVar2;
                    }
                    AppMethodBeat.o(152567);
                    return 0;
                case 11:
                    bka.LTq = aVar3.UbS.zi();
                    AppMethodBeat.o(152567);
                    return 0;
                default:
                    AppMethodBeat.o(152567);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152567);
            return -1;
        }
    }
}
