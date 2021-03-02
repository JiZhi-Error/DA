package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ads extends dpc {
    public String KTt;
    public dis KTz;
    public int Lpj;
    public bfs Lpk;
    public oa Lpl;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124480);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(124480);
                throw bVar;
            } else if (this.KTz == null) {
                b bVar2 = new b("Not all required fields were included: qy_base_resp");
                AppMethodBeat.o(124480);
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
                if (this.KTt != null) {
                    aVar.e(3, this.KTt);
                }
                aVar.aM(4, this.Lpj);
                if (this.Lpk != null) {
                    aVar.ni(5, this.Lpk.computeSize());
                    this.Lpk.writeFields(aVar);
                }
                if (this.Lpl != null) {
                    aVar.ni(6, this.Lpl.computeSize());
                    this.Lpl.writeFields(aVar);
                }
                AppMethodBeat.o(124480);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.KTz != null) {
                nh += g.a.a.a.nh(2, this.KTz.computeSize());
            }
            if (this.KTt != null) {
                nh += g.a.a.b.b.a.f(3, this.KTt);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.Lpj);
            if (this.Lpk != null) {
                bu += g.a.a.a.nh(5, this.Lpk.computeSize());
            }
            if (this.Lpl != null) {
                bu += g.a.a.a.nh(6, this.Lpl.computeSize());
            }
            AppMethodBeat.o(124480);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar3 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(124480);
                throw bVar3;
            } else if (this.KTz == null) {
                b bVar4 = new b("Not all required fields were included: qy_base_resp");
                AppMethodBeat.o(124480);
                throw bVar4;
            } else {
                AppMethodBeat.o(124480);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ads ads = (ads) objArr[1];
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
                        ads.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(124480);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dis dis = new dis();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dis.populateBuilderWithField(aVar5, dis, dpc.getNextFieldNumber(aVar5))) {
                        }
                        ads.KTz = dis;
                    }
                    AppMethodBeat.o(124480);
                    return 0;
                case 3:
                    ads.KTt = aVar3.UbS.readString();
                    AppMethodBeat.o(124480);
                    return 0;
                case 4:
                    ads.Lpj = aVar3.UbS.zi();
                    AppMethodBeat.o(124480);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        bfs bfs = new bfs();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = bfs.populateBuilderWithField(aVar6, bfs, dpc.getNextFieldNumber(aVar6))) {
                        }
                        ads.Lpk = bfs;
                    }
                    AppMethodBeat.o(124480);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        oa oaVar = new oa();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = oaVar.populateBuilderWithField(aVar7, oaVar, dpc.getNextFieldNumber(aVar7))) {
                        }
                        ads.Lpl = oaVar;
                    }
                    AppMethodBeat.o(124480);
                    return 0;
                default:
                    AppMethodBeat.o(124480);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124480);
            return -1;
        }
    }
}
