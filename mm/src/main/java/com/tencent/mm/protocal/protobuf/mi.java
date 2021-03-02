package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class mi extends dpc {
    public int KEf;
    public dyh KLj;
    public String KLk;
    public int KLo;
    public int KPZ;
    public String KQa;
    public cta KQe;
    public String KQg;
    public int KQh;
    public String KQi;
    public ccb KQj;
    public qy KQk;
    public ctb KQl;
    public String KQm;
    public int KQn;
    public dql KQo;
    public String KQp;
    public String KQq;
    public String KQr;
    public String KQs;
    public int KQt;
    public String Username;
    public String dHx;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(134244);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(134244);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.dHx != null) {
                aVar.e(2, this.dHx);
            }
            if (this.KQg != null) {
                aVar.e(3, this.KQg);
            }
            aVar.aM(4, this.KQh);
            if (this.KQi != null) {
                aVar.e(5, this.KQi);
            }
            if (this.Username != null) {
                aVar.e(6, this.Username);
            }
            if (this.KQj != null) {
                aVar.ni(7, this.KQj.computeSize());
                this.KQj.writeFields(aVar);
            }
            if (this.KQk != null) {
                aVar.ni(8, this.KQk.computeSize());
                this.KQk.writeFields(aVar);
            }
            if (this.KQl != null) {
                aVar.ni(9, this.KQl.computeSize());
                this.KQl.writeFields(aVar);
            }
            if (this.KLk != null) {
                aVar.e(10, this.KLk);
            }
            aVar.aM(11, this.KEf);
            if (this.KQm != null) {
                aVar.e(12, this.KQm);
            }
            aVar.aM(13, this.KQn);
            if (this.KQo != null) {
                aVar.ni(14, this.KQo.computeSize());
                this.KQo.writeFields(aVar);
            }
            if (this.KQp != null) {
                aVar.e(15, this.KQp);
            }
            if (this.KQq != null) {
                aVar.e(16, this.KQq);
            }
            if (this.KLj != null) {
                aVar.ni(17, this.KLj.computeSize());
                this.KLj.writeFields(aVar);
            }
            aVar.aM(18, this.KLo);
            if (this.KQr != null) {
                aVar.e(19, this.KQr);
            }
            if (this.KQs != null) {
                aVar.e(20, this.KQs);
            }
            aVar.aM(21, this.KPZ);
            if (this.KQa != null) {
                aVar.e(22, this.KQa);
            }
            aVar.aM(23, this.KQt);
            if (this.KQe != null) {
                aVar.ni(24, this.KQe.computeSize());
                this.KQe.writeFields(aVar);
            }
            AppMethodBeat.o(134244);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.dHx != null) {
                nh += g.a.a.b.b.a.f(2, this.dHx);
            }
            if (this.KQg != null) {
                nh += g.a.a.b.b.a.f(3, this.KQg);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.KQh);
            if (this.KQi != null) {
                bu += g.a.a.b.b.a.f(5, this.KQi);
            }
            if (this.Username != null) {
                bu += g.a.a.b.b.a.f(6, this.Username);
            }
            if (this.KQj != null) {
                bu += g.a.a.a.nh(7, this.KQj.computeSize());
            }
            if (this.KQk != null) {
                bu += g.a.a.a.nh(8, this.KQk.computeSize());
            }
            if (this.KQl != null) {
                bu += g.a.a.a.nh(9, this.KQl.computeSize());
            }
            if (this.KLk != null) {
                bu += g.a.a.b.b.a.f(10, this.KLk);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(11, this.KEf);
            if (this.KQm != null) {
                bu2 += g.a.a.b.b.a.f(12, this.KQm);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(13, this.KQn);
            if (this.KQo != null) {
                bu3 += g.a.a.a.nh(14, this.KQo.computeSize());
            }
            if (this.KQp != null) {
                bu3 += g.a.a.b.b.a.f(15, this.KQp);
            }
            if (this.KQq != null) {
                bu3 += g.a.a.b.b.a.f(16, this.KQq);
            }
            if (this.KLj != null) {
                bu3 += g.a.a.a.nh(17, this.KLj.computeSize());
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(18, this.KLo);
            if (this.KQr != null) {
                bu4 += g.a.a.b.b.a.f(19, this.KQr);
            }
            if (this.KQs != null) {
                bu4 += g.a.a.b.b.a.f(20, this.KQs);
            }
            int bu5 = bu4 + g.a.a.b.b.a.bu(21, this.KPZ);
            if (this.KQa != null) {
                bu5 += g.a.a.b.b.a.f(22, this.KQa);
            }
            int bu6 = bu5 + g.a.a.b.b.a.bu(23, this.KQt);
            if (this.KQe != null) {
                bu6 += g.a.a.a.nh(24, this.KQe.computeSize());
            }
            AppMethodBeat.o(134244);
            return bu6;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(134244);
                throw bVar2;
            }
            AppMethodBeat.o(134244);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            mi miVar = (mi) objArr[1];
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
                        miVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(134244);
                    return 0;
                case 2:
                    miVar.dHx = aVar3.UbS.readString();
                    AppMethodBeat.o(134244);
                    return 0;
                case 3:
                    miVar.KQg = aVar3.UbS.readString();
                    AppMethodBeat.o(134244);
                    return 0;
                case 4:
                    miVar.KQh = aVar3.UbS.zi();
                    AppMethodBeat.o(134244);
                    return 0;
                case 5:
                    miVar.KQi = aVar3.UbS.readString();
                    AppMethodBeat.o(134244);
                    return 0;
                case 6:
                    miVar.Username = aVar3.UbS.readString();
                    AppMethodBeat.o(134244);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ccb ccb = new ccb();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ccb.populateBuilderWithField(aVar5, ccb, dpc.getNextFieldNumber(aVar5))) {
                        }
                        miVar.KQj = ccb;
                    }
                    AppMethodBeat.o(134244);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        qy qyVar = new qy();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = qyVar.populateBuilderWithField(aVar6, qyVar, dpc.getNextFieldNumber(aVar6))) {
                        }
                        miVar.KQk = qyVar;
                    }
                    AppMethodBeat.o(134244);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        ctb ctb = new ctb();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = ctb.populateBuilderWithField(aVar7, ctb, dpc.getNextFieldNumber(aVar7))) {
                        }
                        miVar.KQl = ctb;
                    }
                    AppMethodBeat.o(134244);
                    return 0;
                case 10:
                    miVar.KLk = aVar3.UbS.readString();
                    AppMethodBeat.o(134244);
                    return 0;
                case 11:
                    miVar.KEf = aVar3.UbS.zi();
                    AppMethodBeat.o(134244);
                    return 0;
                case 12:
                    miVar.KQm = aVar3.UbS.readString();
                    AppMethodBeat.o(134244);
                    return 0;
                case 13:
                    miVar.KQn = aVar3.UbS.zi();
                    AppMethodBeat.o(134244);
                    return 0;
                case 14:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        dql dql = new dql();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = dql.populateBuilderWithField(aVar8, dql, dpc.getNextFieldNumber(aVar8))) {
                        }
                        miVar.KQo = dql;
                    }
                    AppMethodBeat.o(134244);
                    return 0;
                case 15:
                    miVar.KQp = aVar3.UbS.readString();
                    AppMethodBeat.o(134244);
                    return 0;
                case 16:
                    miVar.KQq = aVar3.UbS.readString();
                    AppMethodBeat.o(134244);
                    return 0;
                case 17:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        dyh dyh = new dyh();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = dyh.populateBuilderWithField(aVar9, dyh, dpc.getNextFieldNumber(aVar9))) {
                        }
                        miVar.KLj = dyh;
                    }
                    AppMethodBeat.o(134244);
                    return 0;
                case 18:
                    miVar.KLo = aVar3.UbS.zi();
                    AppMethodBeat.o(134244);
                    return 0;
                case 19:
                    miVar.KQr = aVar3.UbS.readString();
                    AppMethodBeat.o(134244);
                    return 0;
                case 20:
                    miVar.KQs = aVar3.UbS.readString();
                    AppMethodBeat.o(134244);
                    return 0;
                case 21:
                    miVar.KPZ = aVar3.UbS.zi();
                    AppMethodBeat.o(134244);
                    return 0;
                case 22:
                    miVar.KQa = aVar3.UbS.readString();
                    AppMethodBeat.o(134244);
                    return 0;
                case 23:
                    miVar.KQt = aVar3.UbS.zi();
                    AppMethodBeat.o(134244);
                    return 0;
                case 24:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        cta cta = new cta();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = cta.populateBuilderWithField(aVar10, cta, dpc.getNextFieldNumber(aVar10))) {
                        }
                        miVar.KQe = cta;
                    }
                    AppMethodBeat.o(134244);
                    return 0;
                default:
                    AppMethodBeat.o(134244);
                    return -1;
            }
        } else {
            AppMethodBeat.o(134244);
            return -1;
        }
    }
}
