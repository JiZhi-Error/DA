package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class qd extends dpc {
    public dar KWW;
    public fo KWX;
    public qb KWY;
    public dez KWZ;
    public eqo KXa;
    public dt KXb;
    public dkw KXc;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124461);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(124461);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.KWW != null) {
                aVar.ni(2, this.KWW.computeSize());
                this.KWW.writeFields(aVar);
            }
            if (this.KWX != null) {
                aVar.ni(3, this.KWX.computeSize());
                this.KWX.writeFields(aVar);
            }
            if (this.KWY != null) {
                aVar.ni(4, this.KWY.computeSize());
                this.KWY.writeFields(aVar);
            }
            if (this.KWZ != null) {
                aVar.ni(5, this.KWZ.computeSize());
                this.KWZ.writeFields(aVar);
            }
            if (this.KXa != null) {
                aVar.ni(6, this.KXa.computeSize());
                this.KXa.writeFields(aVar);
            }
            if (this.KXb != null) {
                aVar.ni(7, this.KXb.computeSize());
                this.KXb.writeFields(aVar);
            }
            if (this.KXc != null) {
                aVar.ni(8, this.KXc.computeSize());
                this.KXc.writeFields(aVar);
            }
            AppMethodBeat.o(124461);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.KWW != null) {
                nh += g.a.a.a.nh(2, this.KWW.computeSize());
            }
            if (this.KWX != null) {
                nh += g.a.a.a.nh(3, this.KWX.computeSize());
            }
            if (this.KWY != null) {
                nh += g.a.a.a.nh(4, this.KWY.computeSize());
            }
            if (this.KWZ != null) {
                nh += g.a.a.a.nh(5, this.KWZ.computeSize());
            }
            if (this.KXa != null) {
                nh += g.a.a.a.nh(6, this.KXa.computeSize());
            }
            if (this.KXb != null) {
                nh += g.a.a.a.nh(7, this.KXb.computeSize());
            }
            if (this.KXc != null) {
                nh += g.a.a.a.nh(8, this.KXc.computeSize());
            }
            AppMethodBeat.o(124461);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(124461);
                throw bVar2;
            }
            AppMethodBeat.o(124461);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            qd qdVar = (qd) objArr[1];
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
                        qdVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(124461);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dar dar = new dar();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dar.populateBuilderWithField(aVar5, dar, dpc.getNextFieldNumber(aVar5))) {
                        }
                        qdVar.KWW = dar;
                    }
                    AppMethodBeat.o(124461);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        fo foVar = new fo();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = foVar.populateBuilderWithField(aVar6, foVar, dpc.getNextFieldNumber(aVar6))) {
                        }
                        qdVar.KWX = foVar;
                    }
                    AppMethodBeat.o(124461);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        qb qbVar = new qb();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = qbVar.populateBuilderWithField(aVar7, qbVar, dpc.getNextFieldNumber(aVar7))) {
                        }
                        qdVar.KWY = qbVar;
                    }
                    AppMethodBeat.o(124461);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        dez dez = new dez();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = dez.populateBuilderWithField(aVar8, dez, dpc.getNextFieldNumber(aVar8))) {
                        }
                        qdVar.KWZ = dez;
                    }
                    AppMethodBeat.o(124461);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        eqo eqo = new eqo();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = eqo.populateBuilderWithField(aVar9, eqo, dpc.getNextFieldNumber(aVar9))) {
                        }
                        qdVar.KXa = eqo;
                    }
                    AppMethodBeat.o(124461);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        dt dtVar = new dt();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = dtVar.populateBuilderWithField(aVar10, dtVar, dpc.getNextFieldNumber(aVar10))) {
                        }
                        qdVar.KXb = dtVar;
                    }
                    AppMethodBeat.o(124461);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh8 = aVar3.awh(intValue);
                    int size8 = awh8.size();
                    for (int i10 = 0; i10 < size8; i10++) {
                        dkw dkw = new dkw();
                        g.a.a.a.a aVar11 = new g.a.a.a.a(awh8.get(i10), unknownTagHandler);
                        for (boolean z8 = true; z8; z8 = dkw.populateBuilderWithField(aVar11, dkw, dpc.getNextFieldNumber(aVar11))) {
                        }
                        qdVar.KXc = dkw;
                    }
                    AppMethodBeat.o(124461);
                    return 0;
                default:
                    AppMethodBeat.o(124461);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124461);
            return -1;
        }
    }
}
