package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ars extends dpc {
    public LinkedList<FinderCommentInfo> LDe = new LinkedList<>();
    public int LDf;
    public int LDg;
    public LinkedList<FinderCommentInfo> LDh = new LinkedList<>();
    public LinkedList<FinderObject> LDi = new LinkedList<>();
    public int commentCount;
    public FinderObject feedObject;
    public b lastBuffer;
    public int secondaryShowFlag;
    public int upContinueFlag;

    public ars() {
        AppMethodBeat.i(168974);
        AppMethodBeat.o(168974);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(168975);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 8, this.LDe);
            if (this.feedObject != null) {
                aVar.ni(3, this.feedObject.computeSize());
                this.feedObject.writeFields(aVar);
            }
            if (this.lastBuffer != null) {
                aVar.c(4, this.lastBuffer);
            }
            aVar.aM(5, this.commentCount);
            aVar.aM(6, this.upContinueFlag);
            aVar.aM(7, this.LDf);
            aVar.aM(8, this.LDg);
            aVar.aM(9, this.secondaryShowFlag);
            aVar.e(10, 8, this.LDh);
            aVar.e(11, 8, this.LDi);
            AppMethodBeat.o(168975);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.LDe);
            if (this.feedObject != null) {
                nh += g.a.a.a.nh(3, this.feedObject.computeSize());
            }
            if (this.lastBuffer != null) {
                nh += g.a.a.b.b.a.b(4, this.lastBuffer);
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.commentCount) + g.a.a.b.b.a.bu(6, this.upContinueFlag) + g.a.a.b.b.a.bu(7, this.LDf) + g.a.a.b.b.a.bu(8, this.LDg) + g.a.a.b.b.a.bu(9, this.secondaryShowFlag) + g.a.a.a.c(10, 8, this.LDh) + g.a.a.a.c(11, 8, this.LDi);
            AppMethodBeat.o(168975);
            return bu;
        } else if (i2 == 2) {
            this.LDe.clear();
            this.LDh.clear();
            this.LDi.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(168975);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ars ars = (ars) objArr[1];
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
                        ars.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(168975);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        FinderCommentInfo finderCommentInfo = new FinderCommentInfo();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = finderCommentInfo.populateBuilderWithField(aVar5, finderCommentInfo, dpc.getNextFieldNumber(aVar5))) {
                        }
                        ars.LDe.add(finderCommentInfo);
                    }
                    AppMethodBeat.o(168975);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        FinderObject finderObject = new FinderObject();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = finderObject.populateBuilderWithField(aVar6, finderObject, dpc.getNextFieldNumber(aVar6))) {
                        }
                        ars.feedObject = finderObject;
                    }
                    AppMethodBeat.o(168975);
                    return 0;
                case 4:
                    ars.lastBuffer = aVar3.UbS.hPo();
                    AppMethodBeat.o(168975);
                    return 0;
                case 5:
                    ars.commentCount = aVar3.UbS.zi();
                    AppMethodBeat.o(168975);
                    return 0;
                case 6:
                    ars.upContinueFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(168975);
                    return 0;
                case 7:
                    ars.LDf = aVar3.UbS.zi();
                    AppMethodBeat.o(168975);
                    return 0;
                case 8:
                    ars.LDg = aVar3.UbS.zi();
                    AppMethodBeat.o(168975);
                    return 0;
                case 9:
                    ars.secondaryShowFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(168975);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        FinderCommentInfo finderCommentInfo2 = new FinderCommentInfo();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = finderCommentInfo2.populateBuilderWithField(aVar7, finderCommentInfo2, dpc.getNextFieldNumber(aVar7))) {
                        }
                        ars.LDh.add(finderCommentInfo2);
                    }
                    AppMethodBeat.o(168975);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        FinderObject finderObject2 = new FinderObject();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = finderObject2.populateBuilderWithField(aVar8, finderObject2, dpc.getNextFieldNumber(aVar8))) {
                        }
                        ars.LDi.add(finderObject2);
                    }
                    AppMethodBeat.o(168975);
                    return 0;
                default:
                    AppMethodBeat.o(168975);
                    return -1;
            }
        } else {
            AppMethodBeat.o(168975);
            return -1;
        }
    }
}
