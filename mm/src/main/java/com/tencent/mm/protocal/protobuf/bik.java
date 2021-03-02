package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bik extends dpc {
    public LinkedList<String> LSA = new LinkedList<>();
    public String LSB;
    public String qGG;
    public String title;

    public bik() {
        AppMethodBeat.i(181502);
        AppMethodBeat.o(181502);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(181503);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.qGG != null) {
                aVar.e(2, this.qGG);
            }
            aVar.e(3, 1, this.LSA);
            if (this.LSB != null) {
                aVar.e(4, this.LSB);
            }
            if (this.title != null) {
                aVar.e(5, this.title);
            }
            AppMethodBeat.o(181503);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.qGG != null) {
                nh += g.a.a.b.b.a.f(2, this.qGG);
            }
            int c2 = nh + g.a.a.a.c(3, 1, this.LSA);
            if (this.LSB != null) {
                c2 += g.a.a.b.b.a.f(4, this.LSB);
            }
            if (this.title != null) {
                c2 += g.a.a.b.b.a.f(5, this.title);
            }
            AppMethodBeat.o(181503);
            return c2;
        } else if (i2 == 2) {
            this.LSA.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(181503);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bik bik = (bik) objArr[1];
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
                        bik.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(181503);
                    return 0;
                case 2:
                    bik.qGG = aVar3.UbS.readString();
                    AppMethodBeat.o(181503);
                    return 0;
                case 3:
                    bik.LSA.add(aVar3.UbS.readString());
                    AppMethodBeat.o(181503);
                    return 0;
                case 4:
                    bik.LSB = aVar3.UbS.readString();
                    AppMethodBeat.o(181503);
                    return 0;
                case 5:
                    bik.title = aVar3.UbS.readString();
                    AppMethodBeat.o(181503);
                    return 0;
                default:
                    AppMethodBeat.o(181503);
                    return -1;
            }
        } else {
            AppMethodBeat.o(181503);
            return -1;
        }
    }
}
