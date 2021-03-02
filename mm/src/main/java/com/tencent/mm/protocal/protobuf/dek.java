package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dek extends dpc {
    public b Loz;
    public fbz MJx;
    public cdg MJy;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(214318);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(214318);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.Loz != null) {
                aVar.c(2, this.Loz);
            }
            if (this.MJx != null) {
                aVar.ni(3, this.MJx.computeSize());
                this.MJx.writeFields(aVar);
            }
            if (this.MJy != null) {
                aVar.ni(100, this.MJy.computeSize());
                this.MJy.writeFields(aVar);
            }
            AppMethodBeat.o(214318);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.Loz != null) {
                nh += g.a.a.b.b.a.b(2, this.Loz);
            }
            if (this.MJx != null) {
                nh += g.a.a.a.nh(3, this.MJx.computeSize());
            }
            if (this.MJy != null) {
                nh += g.a.a.a.nh(100, this.MJy.computeSize());
            }
            AppMethodBeat.o(214318);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(214318);
                throw bVar2;
            }
            AppMethodBeat.o(214318);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dek dek = (dek) objArr[1];
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
                        dek.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(214318);
                    return 0;
                case 2:
                    dek.Loz = aVar3.UbS.hPo();
                    AppMethodBeat.o(214318);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        fbz fbz = new fbz();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = fbz.populateBuilderWithField(aVar5, fbz, dpc.getNextFieldNumber(aVar5))) {
                        }
                        dek.MJx = fbz;
                    }
                    AppMethodBeat.o(214318);
                    return 0;
                case 100:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        cdg cdg = new cdg();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = cdg.populateBuilderWithField(aVar6, cdg, dpc.getNextFieldNumber(aVar6))) {
                        }
                        dek.MJy = cdg;
                    }
                    AppMethodBeat.o(214318);
                    return 0;
                default:
                    AppMethodBeat.o(214318);
                    return -1;
            }
        } else {
            AppMethodBeat.o(214318);
            return -1;
        }
    }
}
