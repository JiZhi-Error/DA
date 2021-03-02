package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class caw extends dpc {
    public SKBuiltinBuffer_t KKY;
    public SKBuiltinBuffer_t Mgl;
    public SKBuiltinBuffer_t Mgm;
    public int Mgn;
    public int Mgo;
    public int Mgp;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32319);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(32319);
                throw bVar;
            } else if (this.KKY == null) {
                b bVar2 = new b("Not all required fields were included: SessionKey");
                AppMethodBeat.o(32319);
                throw bVar2;
            } else if (this.Mgl == null) {
                b bVar3 = new b("Not all required fields were included: SessionBuffer");
                AppMethodBeat.o(32319);
                throw bVar3;
            } else if (this.Mgm == null) {
                b bVar4 = new b("Not all required fields were included: KeyBuffer");
                AppMethodBeat.o(32319);
                throw bVar4;
            } else {
                if (this.BaseResponse != null) {
                    aVar.ni(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                if (this.KKY != null) {
                    aVar.ni(2, this.KKY.computeSize());
                    this.KKY.writeFields(aVar);
                }
                if (this.Mgl != null) {
                    aVar.ni(3, this.Mgl.computeSize());
                    this.Mgl.writeFields(aVar);
                }
                if (this.Mgm != null) {
                    aVar.ni(4, this.Mgm.computeSize());
                    this.Mgm.writeFields(aVar);
                }
                aVar.aM(5, this.Mgn);
                aVar.aM(6, this.Mgo);
                aVar.aM(7, this.Mgp);
                AppMethodBeat.o(32319);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.KKY != null) {
                nh += g.a.a.a.nh(2, this.KKY.computeSize());
            }
            if (this.Mgl != null) {
                nh += g.a.a.a.nh(3, this.Mgl.computeSize());
            }
            if (this.Mgm != null) {
                nh += g.a.a.a.nh(4, this.Mgm.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.Mgn) + g.a.a.b.b.a.bu(6, this.Mgo) + g.a.a.b.b.a.bu(7, this.Mgp);
            AppMethodBeat.o(32319);
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
                AppMethodBeat.o(32319);
                throw bVar5;
            } else if (this.KKY == null) {
                b bVar6 = new b("Not all required fields were included: SessionKey");
                AppMethodBeat.o(32319);
                throw bVar6;
            } else if (this.Mgl == null) {
                b bVar7 = new b("Not all required fields were included: SessionBuffer");
                AppMethodBeat.o(32319);
                throw bVar7;
            } else if (this.Mgm == null) {
                b bVar8 = new b("Not all required fields were included: KeyBuffer");
                AppMethodBeat.o(32319);
                throw bVar8;
            } else {
                AppMethodBeat.o(32319);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            caw caw = (caw) objArr[1];
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
                        caw.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(32319);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t.populateBuilderWithField(aVar5, sKBuiltinBuffer_t, dpc.getNextFieldNumber(aVar5))) {
                        }
                        caw.KKY = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(32319);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t2 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = sKBuiltinBuffer_t2.populateBuilderWithField(aVar6, sKBuiltinBuffer_t2, dpc.getNextFieldNumber(aVar6))) {
                        }
                        caw.Mgl = sKBuiltinBuffer_t2;
                    }
                    AppMethodBeat.o(32319);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t3 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = sKBuiltinBuffer_t3.populateBuilderWithField(aVar7, sKBuiltinBuffer_t3, dpc.getNextFieldNumber(aVar7))) {
                        }
                        caw.Mgm = sKBuiltinBuffer_t3;
                    }
                    AppMethodBeat.o(32319);
                    return 0;
                case 5:
                    caw.Mgn = aVar3.UbS.zi();
                    AppMethodBeat.o(32319);
                    return 0;
                case 6:
                    caw.Mgo = aVar3.UbS.zi();
                    AppMethodBeat.o(32319);
                    return 0;
                case 7:
                    caw.Mgp = aVar3.UbS.zi();
                    AppMethodBeat.o(32319);
                    return 0;
                default:
                    AppMethodBeat.o(32319);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32319);
            return -1;
        }
    }
}
