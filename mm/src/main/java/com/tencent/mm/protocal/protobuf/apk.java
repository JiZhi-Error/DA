package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class apk extends dpc {
    public long LBs;
    public LinkedList<FinderCommentInfo> LBt = new LinkedList<>();
    public String jlz;
    public FinderObject tuO;

    public apk() {
        AppMethodBeat.i(168943);
        AppMethodBeat.o(168943);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(168944);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(168944);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.bb(2, this.LBs);
            if (this.jlz != null) {
                aVar.e(3, this.jlz);
            }
            if (this.tuO != null) {
                aVar.ni(4, this.tuO.computeSize());
                this.tuO.writeFields(aVar);
            }
            aVar.e(5, 8, this.LBt);
            AppMethodBeat.o(168944);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.r(2, this.LBs);
            if (this.jlz != null) {
                nh += g.a.a.b.b.a.f(3, this.jlz);
            }
            if (this.tuO != null) {
                nh += g.a.a.a.nh(4, this.tuO.computeSize());
            }
            int c2 = nh + g.a.a.a.c(5, 8, this.LBt);
            AppMethodBeat.o(168944);
            return c2;
        } else if (i2 == 2) {
            this.LBt.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(168944);
                throw bVar2;
            }
            AppMethodBeat.o(168944);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            apk apk = (apk) objArr[1];
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
                        apk.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(168944);
                    return 0;
                case 2:
                    apk.LBs = aVar3.UbS.zl();
                    AppMethodBeat.o(168944);
                    return 0;
                case 3:
                    apk.jlz = aVar3.UbS.readString();
                    AppMethodBeat.o(168944);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        FinderObject finderObject = new FinderObject();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = finderObject.populateBuilderWithField(aVar5, finderObject, dpc.getNextFieldNumber(aVar5))) {
                        }
                        apk.tuO = finderObject;
                    }
                    AppMethodBeat.o(168944);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        FinderCommentInfo finderCommentInfo = new FinderCommentInfo();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = finderCommentInfo.populateBuilderWithField(aVar6, finderCommentInfo, dpc.getNextFieldNumber(aVar6))) {
                        }
                        apk.LBt.add(finderCommentInfo);
                    }
                    AppMethodBeat.o(168944);
                    return 0;
                default:
                    AppMethodBeat.o(168944);
                    return -1;
            }
        } else {
            AppMethodBeat.o(168944);
            return -1;
        }
    }
}
