package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class etj extends dpc {
    public long Lta;
    public long NeG;
    public int NqC;
    public int NqD;
    public int NqE;
    public int NqF;
    public b NqG;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125510);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(125510);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.bb(2, this.NeG);
            aVar.bb(3, this.Lta);
            aVar.aM(4, this.NqC);
            aVar.aM(5, this.NqD);
            aVar.aM(6, this.NqE);
            aVar.aM(7, this.NqF);
            if (this.NqG != null) {
                aVar.c(8, this.NqG);
            }
            AppMethodBeat.o(125510);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.r(2, this.NeG) + g.a.a.b.b.a.r(3, this.Lta) + g.a.a.b.b.a.bu(4, this.NqC) + g.a.a.b.b.a.bu(5, this.NqD) + g.a.a.b.b.a.bu(6, this.NqE) + g.a.a.b.b.a.bu(7, this.NqF);
            if (this.NqG != null) {
                nh += g.a.a.b.b.a.b(8, this.NqG);
            }
            AppMethodBeat.o(125510);
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
                AppMethodBeat.o(125510);
                throw bVar2;
            }
            AppMethodBeat.o(125510);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            etj etj = (etj) objArr[1];
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
                        etj.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(125510);
                    return 0;
                case 2:
                    etj.NeG = aVar3.UbS.zl();
                    AppMethodBeat.o(125510);
                    return 0;
                case 3:
                    etj.Lta = aVar3.UbS.zl();
                    AppMethodBeat.o(125510);
                    return 0;
                case 4:
                    etj.NqC = aVar3.UbS.zi();
                    AppMethodBeat.o(125510);
                    return 0;
                case 5:
                    etj.NqD = aVar3.UbS.zi();
                    AppMethodBeat.o(125510);
                    return 0;
                case 6:
                    etj.NqE = aVar3.UbS.zi();
                    AppMethodBeat.o(125510);
                    return 0;
                case 7:
                    etj.NqF = aVar3.UbS.zi();
                    AppMethodBeat.o(125510);
                    return 0;
                case 8:
                    etj.NqG = aVar3.UbS.hPo();
                    AppMethodBeat.o(125510);
                    return 0;
                default:
                    AppMethodBeat.o(125510);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125510);
            return -1;
        }
    }
}
