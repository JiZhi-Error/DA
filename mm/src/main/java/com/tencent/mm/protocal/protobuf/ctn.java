package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ctn extends dpc {
    public LinkedList<ekt> LWt = new LinkedList<>();
    public b LXC;
    public float Myv;
    public String Myw;
    public String Myx;
    public String Myy;
    public int jeU;

    public ctn() {
        AppMethodBeat.i(120958);
        AppMethodBeat.o(120958);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(120959);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(120959);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.jeU);
            aVar.e(3, 8, this.LWt);
            if (this.LXC != null) {
                aVar.c(4, this.LXC);
            }
            aVar.E(5, this.Myv);
            if (this.Myw != null) {
                aVar.e(6, this.Myw);
            }
            if (this.Myx != null) {
                aVar.e(7, this.Myx);
            }
            if (this.Myy != null) {
                aVar.e(8, this.Myy);
            }
            AppMethodBeat.o(120959);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.jeU) + g.a.a.a.c(3, 8, this.LWt);
            if (this.LXC != null) {
                nh += g.a.a.b.b.a.b(4, this.LXC);
            }
            int fS = nh + g.a.a.b.b.a.fS(5) + 4;
            if (this.Myw != null) {
                fS += g.a.a.b.b.a.f(6, this.Myw);
            }
            if (this.Myx != null) {
                fS += g.a.a.b.b.a.f(7, this.Myx);
            }
            if (this.Myy != null) {
                fS += g.a.a.b.b.a.f(8, this.Myy);
            }
            AppMethodBeat.o(120959);
            return fS;
        } else if (i2 == 2) {
            this.LWt.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(120959);
                throw bVar2;
            }
            AppMethodBeat.o(120959);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ctn ctn = (ctn) objArr[1];
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
                        ctn.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(120959);
                    return 0;
                case 2:
                    ctn.jeU = aVar3.UbS.zi();
                    AppMethodBeat.o(120959);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ekt ekt = new ekt();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ekt.populateBuilderWithField(aVar5, ekt, dpc.getNextFieldNumber(aVar5))) {
                        }
                        ctn.LWt.add(ekt);
                    }
                    AppMethodBeat.o(120959);
                    return 0;
                case 4:
                    ctn.LXC = aVar3.UbS.hPo();
                    AppMethodBeat.o(120959);
                    return 0;
                case 5:
                    ctn.Myv = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(120959);
                    return 0;
                case 6:
                    ctn.Myw = aVar3.UbS.readString();
                    AppMethodBeat.o(120959);
                    return 0;
                case 7:
                    ctn.Myx = aVar3.UbS.readString();
                    AppMethodBeat.o(120959);
                    return 0;
                case 8:
                    ctn.Myy = aVar3.UbS.readString();
                    AppMethodBeat.o(120959);
                    return 0;
                default:
                    AppMethodBeat.o(120959);
                    return -1;
            }
        } else {
            AppMethodBeat.o(120959);
            return -1;
        }
    }
}
