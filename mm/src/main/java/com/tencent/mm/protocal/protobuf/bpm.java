package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bpm extends dpc {
    public b LFp;
    public int LIa;
    public LinkedList<cix> LXE = new LinkedList<>();
    public LinkedList<String> LXF = new LinkedList<>();
    public int LXG;
    public boolean LXH;
    public cis LXI;

    public bpm() {
        AppMethodBeat.i(207474);
        AppMethodBeat.o(207474);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(207475);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(207475);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 8, this.LXE);
            if (this.LFp != null) {
                aVar.c(3, this.LFp);
            }
            aVar.aM(4, this.LIa);
            aVar.e(5, 1, this.LXF);
            aVar.aM(6, this.LXG);
            aVar.cc(7, this.LXH);
            if (this.LXI != null) {
                aVar.ni(8, this.LXI.computeSize());
                this.LXI.writeFields(aVar);
            }
            AppMethodBeat.o(207475);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.LXE);
            if (this.LFp != null) {
                nh += g.a.a.b.b.a.b(3, this.LFp);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.LIa) + g.a.a.a.c(5, 1, this.LXF) + g.a.a.b.b.a.bu(6, this.LXG) + g.a.a.b.b.a.fS(7) + 1;
            if (this.LXI != null) {
                bu += g.a.a.a.nh(8, this.LXI.computeSize());
            }
            AppMethodBeat.o(207475);
            return bu;
        } else if (i2 == 2) {
            this.LXE.clear();
            this.LXF.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(207475);
                throw bVar2;
            }
            AppMethodBeat.o(207475);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bpm bpm = (bpm) objArr[1];
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
                        bpm.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(207475);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cix cix = new cix();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cix.populateBuilderWithField(aVar5, cix, dpc.getNextFieldNumber(aVar5))) {
                        }
                        bpm.LXE.add(cix);
                    }
                    AppMethodBeat.o(207475);
                    return 0;
                case 3:
                    bpm.LFp = aVar3.UbS.hPo();
                    AppMethodBeat.o(207475);
                    return 0;
                case 4:
                    bpm.LIa = aVar3.UbS.zi();
                    AppMethodBeat.o(207475);
                    return 0;
                case 5:
                    bpm.LXF.add(aVar3.UbS.readString());
                    AppMethodBeat.o(207475);
                    return 0;
                case 6:
                    bpm.LXG = aVar3.UbS.zi();
                    AppMethodBeat.o(207475);
                    return 0;
                case 7:
                    bpm.LXH = aVar3.UbS.yZ();
                    AppMethodBeat.o(207475);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        cis cis = new cis();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = cis.populateBuilderWithField(aVar6, cis, dpc.getNextFieldNumber(aVar6))) {
                        }
                        bpm.LXI = cis;
                    }
                    AppMethodBeat.o(207475);
                    return 0;
                default:
                    AppMethodBeat.o(207475);
                    return -1;
            }
        } else {
            AppMethodBeat.o(207475);
            return -1;
        }
    }
}
