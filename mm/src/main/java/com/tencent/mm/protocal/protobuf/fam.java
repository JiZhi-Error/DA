package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class fam extends dpc {
    public int KZk;
    public String MaZ;
    public int NwM;
    public dkh NwN;
    public dkf NwO;
    public int NwP;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117949);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.NwM);
            aVar.aM(3, this.KZk);
            if (this.MaZ != null) {
                aVar.e(4, this.MaZ);
            }
            if (this.NwN != null) {
                aVar.ni(5, this.NwN.computeSize());
                this.NwN.writeFields(aVar);
            }
            if (this.NwO != null) {
                aVar.ni(6, this.NwO.computeSize());
                this.NwO.writeFields(aVar);
            }
            aVar.aM(7, this.NwP);
            AppMethodBeat.o(117949);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.NwM) + g.a.a.b.b.a.bu(3, this.KZk);
            if (this.MaZ != null) {
                nh += g.a.a.b.b.a.f(4, this.MaZ);
            }
            if (this.NwN != null) {
                nh += g.a.a.a.nh(5, this.NwN.computeSize());
            }
            if (this.NwO != null) {
                nh += g.a.a.a.nh(6, this.NwO.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(7, this.NwP);
            AppMethodBeat.o(117949);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(117949);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fam fam = (fam) objArr[1];
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
                        fam.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(117949);
                    return 0;
                case 2:
                    fam.NwM = aVar3.UbS.zi();
                    AppMethodBeat.o(117949);
                    return 0;
                case 3:
                    fam.KZk = aVar3.UbS.zi();
                    AppMethodBeat.o(117949);
                    return 0;
                case 4:
                    fam.MaZ = aVar3.UbS.readString();
                    AppMethodBeat.o(117949);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dkh dkh = new dkh();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dkh.populateBuilderWithField(aVar5, dkh, dpc.getNextFieldNumber(aVar5))) {
                        }
                        fam.NwN = dkh;
                    }
                    AppMethodBeat.o(117949);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dkf dkf = new dkf();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dkf.populateBuilderWithField(aVar6, dkf, dpc.getNextFieldNumber(aVar6))) {
                        }
                        fam.NwO = dkf;
                    }
                    AppMethodBeat.o(117949);
                    return 0;
                case 7:
                    fam.NwP = aVar3.UbS.zi();
                    AppMethodBeat.o(117949);
                    return 0;
                default:
                    AppMethodBeat.o(117949);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117949);
            return -1;
        }
    }
}
