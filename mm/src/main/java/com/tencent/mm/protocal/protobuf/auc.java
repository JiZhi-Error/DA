package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class auc extends dpc {
    public int LAQ;
    public LinkedList<FinderContact> LEN = new LinkedList<>();
    public LinkedList<bdg> LEO = new LinkedList<>();
    public SKBuiltinBuffer_t Lev;
    public int continueFlag;
    public LinkedList<apf> sKS = new LinkedList<>();

    public auc() {
        AppMethodBeat.i(168998);
        AppMethodBeat.o(168998);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(168999);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 8, this.LEN);
            if (this.Lev != null) {
                aVar.ni(3, this.Lev.computeSize());
                this.Lev.writeFields(aVar);
            }
            aVar.e(4, 8, this.sKS);
            aVar.aM(5, this.continueFlag);
            aVar.aM(6, this.LAQ);
            aVar.e(7, 8, this.LEO);
            AppMethodBeat.o(168999);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.LEN);
            if (this.Lev != null) {
                nh += g.a.a.a.nh(3, this.Lev.computeSize());
            }
            int c2 = nh + g.a.a.a.c(4, 8, this.sKS) + g.a.a.b.b.a.bu(5, this.continueFlag) + g.a.a.b.b.a.bu(6, this.LAQ) + g.a.a.a.c(7, 8, this.LEO);
            AppMethodBeat.o(168999);
            return c2;
        } else if (i2 == 2) {
            this.LEN.clear();
            this.sKS.clear();
            this.LEO.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(168999);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            auc auc = (auc) objArr[1];
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
                        auc.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(168999);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        FinderContact finderContact = new FinderContact();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = finderContact.populateBuilderWithField(aVar5, finderContact, dpc.getNextFieldNumber(aVar5))) {
                        }
                        auc.LEN.add(finderContact);
                    }
                    AppMethodBeat.o(168999);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = sKBuiltinBuffer_t.populateBuilderWithField(aVar6, sKBuiltinBuffer_t, dpc.getNextFieldNumber(aVar6))) {
                        }
                        auc.Lev = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(168999);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        apf apf = new apf();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = apf.populateBuilderWithField(aVar7, apf, dpc.getNextFieldNumber(aVar7))) {
                        }
                        auc.sKS.add(apf);
                    }
                    AppMethodBeat.o(168999);
                    return 0;
                case 5:
                    auc.continueFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(168999);
                    return 0;
                case 6:
                    auc.LAQ = aVar3.UbS.zi();
                    AppMethodBeat.o(168999);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        bdg bdg = new bdg();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = bdg.populateBuilderWithField(aVar8, bdg, dpc.getNextFieldNumber(aVar8))) {
                        }
                        auc.LEO.add(bdg);
                    }
                    AppMethodBeat.o(168999);
                    return 0;
                default:
                    AppMethodBeat.o(168999);
                    return -1;
            }
        } else {
            AppMethodBeat.o(168999);
            return -1;
        }
    }
}
