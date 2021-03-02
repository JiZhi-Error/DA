package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ctk extends dpc {
    public int KCX;
    public int KZh;
    public SKBuiltinBuffer_t Myi;
    public SKBuiltinBuffer_t Myj;
    public int Myk;
    public int Myl;
    public LinkedList<abn> Mym = new LinkedList<>();

    public ctk() {
        AppMethodBeat.i(133182);
        AppMethodBeat.o(133182);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(133183);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(133183);
                throw bVar;
            } else if (this.Myi == null) {
                b bVar2 = new b("Not all required fields were included: CurrentSynckey");
                AppMethodBeat.o(133183);
                throw bVar2;
            } else if (this.Myj == null) {
                b bVar3 = new b("Not all required fields were included: MaxSynckey");
                AppMethodBeat.o(133183);
                throw bVar3;
            } else {
                if (this.BaseResponse != null) {
                    aVar.ni(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                if (this.Myi != null) {
                    aVar.ni(2, this.Myi.computeSize());
                    this.Myi.writeFields(aVar);
                }
                if (this.Myj != null) {
                    aVar.ni(3, this.Myj.computeSize());
                    this.Myj.writeFields(aVar);
                }
                aVar.aM(4, this.KZh);
                aVar.aM(5, this.Myk);
                aVar.aM(6, this.Myl);
                aVar.e(7, 8, this.Mym);
                aVar.aM(8, this.KCX);
                AppMethodBeat.o(133183);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.Myi != null) {
                nh += g.a.a.a.nh(2, this.Myi.computeSize());
            }
            if (this.Myj != null) {
                nh += g.a.a.a.nh(3, this.Myj.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.KZh) + g.a.a.b.b.a.bu(5, this.Myk) + g.a.a.b.b.a.bu(6, this.Myl) + g.a.a.a.c(7, 8, this.Mym) + g.a.a.b.b.a.bu(8, this.KCX);
            AppMethodBeat.o(133183);
            return bu;
        } else if (i2 == 2) {
            this.Mym.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar4 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(133183);
                throw bVar4;
            } else if (this.Myi == null) {
                b bVar5 = new b("Not all required fields were included: CurrentSynckey");
                AppMethodBeat.o(133183);
                throw bVar5;
            } else if (this.Myj == null) {
                b bVar6 = new b("Not all required fields were included: MaxSynckey");
                AppMethodBeat.o(133183);
                throw bVar6;
            } else {
                AppMethodBeat.o(133183);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ctk ctk = (ctk) objArr[1];
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
                        ctk.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(133183);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t.populateBuilderWithField(aVar5, sKBuiltinBuffer_t, dpc.getNextFieldNumber(aVar5))) {
                        }
                        ctk.Myi = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(133183);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t2 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = sKBuiltinBuffer_t2.populateBuilderWithField(aVar6, sKBuiltinBuffer_t2, dpc.getNextFieldNumber(aVar6))) {
                        }
                        ctk.Myj = sKBuiltinBuffer_t2;
                    }
                    AppMethodBeat.o(133183);
                    return 0;
                case 4:
                    ctk.KZh = aVar3.UbS.zi();
                    AppMethodBeat.o(133183);
                    return 0;
                case 5:
                    ctk.Myk = aVar3.UbS.zi();
                    AppMethodBeat.o(133183);
                    return 0;
                case 6:
                    ctk.Myl = aVar3.UbS.zi();
                    AppMethodBeat.o(133183);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        abn abn = new abn();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = abn.populateBuilderWithField(aVar7, abn, dpc.getNextFieldNumber(aVar7))) {
                        }
                        ctk.Mym.add(abn);
                    }
                    AppMethodBeat.o(133183);
                    return 0;
                case 8:
                    ctk.KCX = aVar3.UbS.zi();
                    AppMethodBeat.o(133183);
                    return 0;
                default:
                    AppMethodBeat.o(133183);
                    return -1;
            }
        } else {
            AppMethodBeat.o(133183);
            return -1;
        }
    }
}
