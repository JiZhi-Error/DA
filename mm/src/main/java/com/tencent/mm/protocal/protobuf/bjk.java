package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bjk extends dpc {
    public dis KTz;
    public LinkedList<bfs> LTh = new LinkedList<>();

    public bjk() {
        AppMethodBeat.i(124494);
        AppMethodBeat.o(124494);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124495);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(124495);
                throw bVar;
            } else if (this.KTz == null) {
                b bVar2 = new b("Not all required fields were included: qy_base_resp");
                AppMethodBeat.o(124495);
                throw bVar2;
            } else {
                if (this.BaseResponse != null) {
                    aVar.ni(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                if (this.KTz != null) {
                    aVar.ni(2, this.KTz.computeSize());
                    this.KTz.writeFields(aVar);
                }
                aVar.e(3, 8, this.LTh);
                AppMethodBeat.o(124495);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.KTz != null) {
                nh += g.a.a.a.nh(2, this.KTz.computeSize());
            }
            int c2 = nh + g.a.a.a.c(3, 8, this.LTh);
            AppMethodBeat.o(124495);
            return c2;
        } else if (i2 == 2) {
            this.LTh.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar3 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(124495);
                throw bVar3;
            } else if (this.KTz == null) {
                b bVar4 = new b("Not all required fields were included: qy_base_resp");
                AppMethodBeat.o(124495);
                throw bVar4;
            } else {
                AppMethodBeat.o(124495);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bjk bjk = (bjk) objArr[1];
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
                        bjk.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(124495);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dis dis = new dis();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dis.populateBuilderWithField(aVar5, dis, dpc.getNextFieldNumber(aVar5))) {
                        }
                        bjk.KTz = dis;
                    }
                    AppMethodBeat.o(124495);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        bfs bfs = new bfs();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = bfs.populateBuilderWithField(aVar6, bfs, dpc.getNextFieldNumber(aVar6))) {
                        }
                        bjk.LTh.add(bfs);
                    }
                    AppMethodBeat.o(124495);
                    return 0;
                default:
                    AppMethodBeat.o(124495);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124495);
            return -1;
        }
    }
}