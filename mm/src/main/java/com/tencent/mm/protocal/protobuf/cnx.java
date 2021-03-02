package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class cnx extends dpc {
    public long Mum;
    public long Mun;
    public LinkedList<cni> commentList = new LinkedList<>();
    public b lastBuffer;

    public cnx() {
        AppMethodBeat.i(209753);
        AppMethodBeat.o(209753);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209754);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 8, this.commentList);
            if (this.lastBuffer != null) {
                aVar.c(3, this.lastBuffer);
            }
            aVar.bb(4, this.Mum);
            aVar.bb(5, this.Mun);
            AppMethodBeat.o(209754);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.commentList);
            if (this.lastBuffer != null) {
                nh += g.a.a.b.b.a.b(3, this.lastBuffer);
            }
            int r = nh + g.a.a.b.b.a.r(4, this.Mum) + g.a.a.b.b.a.r(5, this.Mun);
            AppMethodBeat.o(209754);
            return r;
        } else if (i2 == 2) {
            this.commentList.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209754);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cnx cnx = (cnx) objArr[1];
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
                        cnx.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(209754);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cni cni = new cni();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cni.populateBuilderWithField(aVar5, cni, dpc.getNextFieldNumber(aVar5))) {
                        }
                        cnx.commentList.add(cni);
                    }
                    AppMethodBeat.o(209754);
                    return 0;
                case 3:
                    cnx.lastBuffer = aVar3.UbS.hPo();
                    AppMethodBeat.o(209754);
                    return 0;
                case 4:
                    cnx.Mum = aVar3.UbS.zl();
                    AppMethodBeat.o(209754);
                    return 0;
                case 5:
                    cnx.Mun = aVar3.UbS.zl();
                    AppMethodBeat.o(209754);
                    return 0;
                default:
                    AppMethodBeat.o(209754);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209754);
            return -1;
        }
    }
}
