package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class chn extends dpc {
    public int DJa;
    public int LUB;
    public LinkedList<chi> LUC = new LinkedList<>();
    public int MmY;
    public int MmZ;
    public int Mna;

    public chn() {
        AppMethodBeat.i(89927);
        AppMethodBeat.o(89927);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(89928);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(89928);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.LUB);
            aVar.e(3, 8, this.LUC);
            aVar.aM(4, this.DJa);
            aVar.aM(5, this.MmY);
            aVar.aM(6, this.MmZ);
            aVar.aM(7, this.Mna);
            AppMethodBeat.o(89928);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.LUB) + g.a.a.a.c(3, 8, this.LUC) + g.a.a.b.b.a.bu(4, this.DJa) + g.a.a.b.b.a.bu(5, this.MmY) + g.a.a.b.b.a.bu(6, this.MmZ) + g.a.a.b.b.a.bu(7, this.Mna);
            AppMethodBeat.o(89928);
            return nh;
        } else if (i2 == 2) {
            this.LUC.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(89928);
                throw bVar2;
            }
            AppMethodBeat.o(89928);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            chn chn = (chn) objArr[1];
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
                        chn.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(89928);
                    return 0;
                case 2:
                    chn.LUB = aVar3.UbS.zi();
                    AppMethodBeat.o(89928);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        chi chi = new chi();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = chi.populateBuilderWithField(aVar5, chi, dpc.getNextFieldNumber(aVar5))) {
                        }
                        chn.LUC.add(chi);
                    }
                    AppMethodBeat.o(89928);
                    return 0;
                case 4:
                    chn.DJa = aVar3.UbS.zi();
                    AppMethodBeat.o(89928);
                    return 0;
                case 5:
                    chn.MmY = aVar3.UbS.zi();
                    AppMethodBeat.o(89928);
                    return 0;
                case 6:
                    chn.MmZ = aVar3.UbS.zi();
                    AppMethodBeat.o(89928);
                    return 0;
                case 7:
                    chn.Mna = aVar3.UbS.zi();
                    AppMethodBeat.o(89928);
                    return 0;
                default:
                    AppMethodBeat.o(89928);
                    return -1;
            }
        } else {
            AppMethodBeat.o(89928);
            return -1;
        }
    }
}
