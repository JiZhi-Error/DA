package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dpc;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dx extends dpc {
    public String Title;
    public boolean xIO;
    public String xJz;
    public p xNp;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41837);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(41837);
                throw bVar;
            } else if (this.Title == null) {
                b bVar2 = new b("Not all required fields were included: Title");
                AppMethodBeat.o(41837);
                throw bVar2;
            } else if (this.xJz == null) {
                b bVar3 = new b("Not all required fields were included: Message");
                AppMethodBeat.o(41837);
                throw bVar3;
            } else {
                if (this.BaseResponse != null) {
                    aVar.ni(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                aVar.cc(2, this.xIO);
                if (this.Title != null) {
                    aVar.e(3, this.Title);
                }
                if (this.xJz != null) {
                    aVar.e(4, this.xJz);
                }
                if (this.xNp != null) {
                    aVar.ni(5, this.xNp.computeSize());
                    this.xNp.writeFields(aVar);
                }
                AppMethodBeat.o(41837);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.fS(2) + 1;
            if (this.Title != null) {
                nh += g.a.a.b.b.a.f(3, this.Title);
            }
            if (this.xJz != null) {
                nh += g.a.a.b.b.a.f(4, this.xJz);
            }
            if (this.xNp != null) {
                nh += g.a.a.a.nh(5, this.xNp.computeSize());
            }
            AppMethodBeat.o(41837);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar4 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(41837);
                throw bVar4;
            } else if (this.Title == null) {
                b bVar5 = new b("Not all required fields were included: Title");
                AppMethodBeat.o(41837);
                throw bVar5;
            } else if (this.xJz == null) {
                b bVar6 = new b("Not all required fields were included: Message");
                AppMethodBeat.o(41837);
                throw bVar6;
            } else {
                AppMethodBeat.o(41837);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dx dxVar = (dx) objArr[1];
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
                        dxVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(41837);
                    return 0;
                case 2:
                    dxVar.xIO = aVar3.UbS.yZ();
                    AppMethodBeat.o(41837);
                    return 0;
                case 3:
                    dxVar.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(41837);
                    return 0;
                case 4:
                    dxVar.xJz = aVar3.UbS.readString();
                    AppMethodBeat.o(41837);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        p pVar = new p();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = pVar.populateBuilderWithField(aVar5, pVar, dpc.getNextFieldNumber(aVar5))) {
                        }
                        dxVar.xNp = pVar;
                    }
                    AppMethodBeat.o(41837);
                    return 0;
                default:
                    AppMethodBeat.o(41837);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41837);
            return -1;
        }
    }
}
