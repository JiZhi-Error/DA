package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dil extends dpc {
    public dqe KEP;
    public egg MMX;
    public exz MMY;
    public long MMZ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91654);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(91654);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.MMX != null) {
                aVar.ni(2, this.MMX.computeSize());
                this.MMX.writeFields(aVar);
            }
            if (this.KEP != null) {
                aVar.ni(3, this.KEP.computeSize());
                this.KEP.writeFields(aVar);
            }
            if (this.MMY != null) {
                aVar.ni(4, this.MMY.computeSize());
                this.MMY.writeFields(aVar);
            }
            aVar.bb(5, this.MMZ);
            AppMethodBeat.o(91654);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.MMX != null) {
                nh += g.a.a.a.nh(2, this.MMX.computeSize());
            }
            if (this.KEP != null) {
                nh += g.a.a.a.nh(3, this.KEP.computeSize());
            }
            if (this.MMY != null) {
                nh += g.a.a.a.nh(4, this.MMY.computeSize());
            }
            int r = nh + g.a.a.b.b.a.r(5, this.MMZ);
            AppMethodBeat.o(91654);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(91654);
                throw bVar2;
            }
            AppMethodBeat.o(91654);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dil dil = (dil) objArr[1];
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
                        dil.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(91654);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        egg egg = new egg();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = egg.populateBuilderWithField(aVar5, egg, dpc.getNextFieldNumber(aVar5))) {
                        }
                        dil.MMX = egg;
                    }
                    AppMethodBeat.o(91654);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dqe dqe = new dqe();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dqe.populateBuilderWithField(aVar6, dqe, dpc.getNextFieldNumber(aVar6))) {
                        }
                        dil.KEP = dqe;
                    }
                    AppMethodBeat.o(91654);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        exz exz = new exz();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = exz.populateBuilderWithField(aVar7, exz, dpc.getNextFieldNumber(aVar7))) {
                        }
                        dil.MMY = exz;
                    }
                    AppMethodBeat.o(91654);
                    return 0;
                case 5:
                    dil.MMZ = aVar3.UbS.zl();
                    AppMethodBeat.o(91654);
                    return 0;
                default:
                    AppMethodBeat.o(91654);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91654);
            return -1;
        }
    }
}
