package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class aab extends dpc {
    public esm Llk;
    public eoe Lll;
    public did Llm;
    public int Lln;
    public int oTW;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32167);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(32167);
                throw bVar;
            } else if (this.Llk == null) {
                b bVar2 = new b("Not all required fields were included: TransRes");
                AppMethodBeat.o(32167);
                throw bVar2;
            } else if (this.Lll == null) {
                b bVar3 = new b("Not all required fields were included: UploadCtx");
                AppMethodBeat.o(32167);
                throw bVar3;
            } else if (this.Llm == null) {
                b bVar4 = new b("Not all required fields were included: QueryCtx");
                AppMethodBeat.o(32167);
                throw bVar4;
            } else {
                if (this.BaseResponse != null) {
                    aVar.ni(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                aVar.aM(2, this.oTW);
                if (this.Llk != null) {
                    aVar.ni(3, this.Llk.computeSize());
                    this.Llk.writeFields(aVar);
                }
                if (this.Lll != null) {
                    aVar.ni(4, this.Lll.computeSize());
                    this.Lll.writeFields(aVar);
                }
                if (this.Llm != null) {
                    aVar.ni(5, this.Llm.computeSize());
                    this.Llm.writeFields(aVar);
                }
                aVar.aM(6, this.Lln);
                AppMethodBeat.o(32167);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.oTW);
            if (this.Llk != null) {
                nh += g.a.a.a.nh(3, this.Llk.computeSize());
            }
            if (this.Lll != null) {
                nh += g.a.a.a.nh(4, this.Lll.computeSize());
            }
            if (this.Llm != null) {
                nh += g.a.a.a.nh(5, this.Llm.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(6, this.Lln);
            AppMethodBeat.o(32167);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar5 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(32167);
                throw bVar5;
            } else if (this.Llk == null) {
                b bVar6 = new b("Not all required fields were included: TransRes");
                AppMethodBeat.o(32167);
                throw bVar6;
            } else if (this.Lll == null) {
                b bVar7 = new b("Not all required fields were included: UploadCtx");
                AppMethodBeat.o(32167);
                throw bVar7;
            } else if (this.Llm == null) {
                b bVar8 = new b("Not all required fields were included: QueryCtx");
                AppMethodBeat.o(32167);
                throw bVar8;
            } else {
                AppMethodBeat.o(32167);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aab aab = (aab) objArr[1];
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
                        aab.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(32167);
                    return 0;
                case 2:
                    aab.oTW = aVar3.UbS.zi();
                    AppMethodBeat.o(32167);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        esm esm = new esm();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = esm.populateBuilderWithField(aVar5, esm, dpc.getNextFieldNumber(aVar5))) {
                        }
                        aab.Llk = esm;
                    }
                    AppMethodBeat.o(32167);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        eoe eoe = new eoe();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = eoe.populateBuilderWithField(aVar6, eoe, dpc.getNextFieldNumber(aVar6))) {
                        }
                        aab.Lll = eoe;
                    }
                    AppMethodBeat.o(32167);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        did did = new did();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = did.populateBuilderWithField(aVar7, did, dpc.getNextFieldNumber(aVar7))) {
                        }
                        aab.Llm = did;
                    }
                    AppMethodBeat.o(32167);
                    return 0;
                case 6:
                    aab.Lln = aVar3.UbS.zi();
                    AppMethodBeat.o(32167);
                    return 0;
                default:
                    AppMethodBeat.o(32167);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32167);
            return -1;
        }
    }
}
