package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public class bwy extends dpc {
    public int KLv;
    public String McH;
    public String McI;
    public LinkedList<String> McJ = new LinkedList<>();

    public bwy() {
        AppMethodBeat.i(147767);
        AppMethodBeat.o(147767);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(147768);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(147768);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.McH != null) {
                aVar.e(2, this.McH);
            }
            aVar.aM(3, this.KLv);
            if (this.McI != null) {
                aVar.e(4, this.McI);
            }
            aVar.e(5, 1, this.McJ);
            AppMethodBeat.o(147768);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.McH != null) {
                nh += g.a.a.b.b.a.f(2, this.McH);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.KLv);
            if (this.McI != null) {
                bu += g.a.a.b.b.a.f(4, this.McI);
            }
            int c2 = bu + g.a.a.a.c(5, 1, this.McJ);
            AppMethodBeat.o(147768);
            return c2;
        } else if (i2 == 2) {
            this.McJ.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(147768);
                throw bVar2;
            }
            AppMethodBeat.o(147768);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bwy bwy = (bwy) objArr[1];
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
                        bwy.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(147768);
                    return 0;
                case 2:
                    bwy.McH = aVar3.UbS.readString();
                    AppMethodBeat.o(147768);
                    return 0;
                case 3:
                    bwy.KLv = aVar3.UbS.zi();
                    AppMethodBeat.o(147768);
                    return 0;
                case 4:
                    bwy.McI = aVar3.UbS.readString();
                    AppMethodBeat.o(147768);
                    return 0;
                case 5:
                    bwy.McJ.add(aVar3.UbS.readString());
                    AppMethodBeat.o(147768);
                    return 0;
                default:
                    AppMethodBeat.o(147768);
                    return -1;
            }
        } else {
            AppMethodBeat.o(147768);
            return -1;
        }
    }
}
