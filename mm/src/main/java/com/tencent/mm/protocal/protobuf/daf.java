package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class daf extends dpc {
    public String IbC;
    public exm MFq;
    public exj MFr;
    public exd MFs;
    public exk MFt;
    public boolean MFu;
    public LinkedList<String> MFv = new LinkedList<>();
    public exh MFw;
    public int dIZ;
    public String dJa;
    public int zjs;

    public daf() {
        AppMethodBeat.i(91588);
        AppMethodBeat.o(91588);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91589);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(91589);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.dIZ);
            if (this.dJa != null) {
                aVar.e(3, this.dJa);
            }
            if (this.MFq != null) {
                aVar.ni(4, this.MFq.computeSize());
                this.MFq.writeFields(aVar);
            }
            if (this.MFr != null) {
                aVar.ni(5, this.MFr.computeSize());
                this.MFr.writeFields(aVar);
            }
            if (this.MFs != null) {
                aVar.ni(6, this.MFs.computeSize());
                this.MFs.writeFields(aVar);
            }
            if (this.MFt != null) {
                aVar.ni(7, this.MFt.computeSize());
                this.MFt.writeFields(aVar);
            }
            aVar.aM(8, this.zjs);
            aVar.cc(9, this.MFu);
            if (this.IbC != null) {
                aVar.e(10, this.IbC);
            }
            aVar.e(11, 1, this.MFv);
            if (this.MFw != null) {
                aVar.ni(12, this.MFw.computeSize());
                this.MFw.writeFields(aVar);
            }
            AppMethodBeat.o(91589);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.dIZ);
            if (this.dJa != null) {
                nh += g.a.a.b.b.a.f(3, this.dJa);
            }
            if (this.MFq != null) {
                nh += g.a.a.a.nh(4, this.MFq.computeSize());
            }
            if (this.MFr != null) {
                nh += g.a.a.a.nh(5, this.MFr.computeSize());
            }
            if (this.MFs != null) {
                nh += g.a.a.a.nh(6, this.MFs.computeSize());
            }
            if (this.MFt != null) {
                nh += g.a.a.a.nh(7, this.MFt.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(8, this.zjs) + g.a.a.b.b.a.fS(9) + 1;
            if (this.IbC != null) {
                bu += g.a.a.b.b.a.f(10, this.IbC);
            }
            int c2 = bu + g.a.a.a.c(11, 1, this.MFv);
            if (this.MFw != null) {
                c2 += g.a.a.a.nh(12, this.MFw.computeSize());
            }
            AppMethodBeat.o(91589);
            return c2;
        } else if (i2 == 2) {
            this.MFv.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(91589);
                throw bVar2;
            }
            AppMethodBeat.o(91589);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            daf daf = (daf) objArr[1];
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
                        daf.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(91589);
                    return 0;
                case 2:
                    daf.dIZ = aVar3.UbS.zi();
                    AppMethodBeat.o(91589);
                    return 0;
                case 3:
                    daf.dJa = aVar3.UbS.readString();
                    AppMethodBeat.o(91589);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        exm exm = new exm();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = exm.populateBuilderWithField(aVar5, exm, dpc.getNextFieldNumber(aVar5))) {
                        }
                        daf.MFq = exm;
                    }
                    AppMethodBeat.o(91589);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        exj exj = new exj();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = exj.populateBuilderWithField(aVar6, exj, dpc.getNextFieldNumber(aVar6))) {
                        }
                        daf.MFr = exj;
                    }
                    AppMethodBeat.o(91589);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        exd exd = new exd();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = exd.populateBuilderWithField(aVar7, exd, dpc.getNextFieldNumber(aVar7))) {
                        }
                        daf.MFs = exd;
                    }
                    AppMethodBeat.o(91589);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        exk exk = new exk();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = exk.populateBuilderWithField(aVar8, exk, dpc.getNextFieldNumber(aVar8))) {
                        }
                        daf.MFt = exk;
                    }
                    AppMethodBeat.o(91589);
                    return 0;
                case 8:
                    daf.zjs = aVar3.UbS.zi();
                    AppMethodBeat.o(91589);
                    return 0;
                case 9:
                    daf.MFu = aVar3.UbS.yZ();
                    AppMethodBeat.o(91589);
                    return 0;
                case 10:
                    daf.IbC = aVar3.UbS.readString();
                    AppMethodBeat.o(91589);
                    return 0;
                case 11:
                    daf.MFv.add(aVar3.UbS.readString());
                    AppMethodBeat.o(91589);
                    return 0;
                case 12:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        exh exh = new exh();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = exh.populateBuilderWithField(aVar9, exh, dpc.getNextFieldNumber(aVar9))) {
                        }
                        daf.MFw = exh;
                    }
                    AppMethodBeat.o(91589);
                    return 0;
                default:
                    AppMethodBeat.o(91589);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91589);
            return -1;
        }
    }
}
