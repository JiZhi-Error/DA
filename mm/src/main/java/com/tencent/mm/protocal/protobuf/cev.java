package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public class cev extends dpc {
    public String KFs;
    public cdz Mkb;
    public String Mke;
    public String Mkf;
    public String Mkg;
    public dy Mkh;
    public drb Mkq;
    public aeu Mkr;
    public boolean Mks;
    public eoq Mkt;
    public b oTm;
    public String xMq;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123619);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(123619);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.Mkb != null) {
                aVar.ni(2, this.Mkb.computeSize());
                this.Mkb.writeFields(aVar);
            }
            if (this.oTm != null) {
                aVar.c(3, this.oTm);
            }
            if (this.Mkq != null) {
                aVar.ni(4, this.Mkq.computeSize());
                this.Mkq.writeFields(aVar);
            }
            if (this.xMq != null) {
                aVar.e(5, this.xMq);
            }
            if (this.KFs != null) {
                aVar.e(6, this.KFs);
            }
            if (this.Mkr != null) {
                aVar.ni(7, this.Mkr.computeSize());
                this.Mkr.writeFields(aVar);
            }
            aVar.cc(8, this.Mks);
            if (this.Mke != null) {
                aVar.e(9, this.Mke);
            }
            if (this.Mkf != null) {
                aVar.e(10, this.Mkf);
            }
            if (this.Mkg != null) {
                aVar.e(11, this.Mkg);
            }
            if (this.Mkt != null) {
                aVar.ni(12, this.Mkt.computeSize());
                this.Mkt.writeFields(aVar);
            }
            if (this.Mkh != null) {
                aVar.ni(13, this.Mkh.computeSize());
                this.Mkh.writeFields(aVar);
            }
            AppMethodBeat.o(123619);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.Mkb != null) {
                nh += g.a.a.a.nh(2, this.Mkb.computeSize());
            }
            if (this.oTm != null) {
                nh += g.a.a.b.b.a.b(3, this.oTm);
            }
            if (this.Mkq != null) {
                nh += g.a.a.a.nh(4, this.Mkq.computeSize());
            }
            if (this.xMq != null) {
                nh += g.a.a.b.b.a.f(5, this.xMq);
            }
            if (this.KFs != null) {
                nh += g.a.a.b.b.a.f(6, this.KFs);
            }
            if (this.Mkr != null) {
                nh += g.a.a.a.nh(7, this.Mkr.computeSize());
            }
            int fS = nh + g.a.a.b.b.a.fS(8) + 1;
            if (this.Mke != null) {
                fS += g.a.a.b.b.a.f(9, this.Mke);
            }
            if (this.Mkf != null) {
                fS += g.a.a.b.b.a.f(10, this.Mkf);
            }
            if (this.Mkg != null) {
                fS += g.a.a.b.b.a.f(11, this.Mkg);
            }
            if (this.Mkt != null) {
                fS += g.a.a.a.nh(12, this.Mkt.computeSize());
            }
            if (this.Mkh != null) {
                fS += g.a.a.a.nh(13, this.Mkh.computeSize());
            }
            AppMethodBeat.o(123619);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(123619);
                throw bVar2;
            }
            AppMethodBeat.o(123619);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cev cev = (cev) objArr[1];
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
                        cev.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(123619);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cdz cdz = new cdz();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cdz.populateBuilderWithField(aVar5, cdz, dpc.getNextFieldNumber(aVar5))) {
                        }
                        cev.Mkb = cdz;
                    }
                    AppMethodBeat.o(123619);
                    return 0;
                case 3:
                    cev.oTm = aVar3.UbS.hPo();
                    AppMethodBeat.o(123619);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        drb drb = new drb();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = drb.populateBuilderWithField(aVar6, drb, dpc.getNextFieldNumber(aVar6))) {
                        }
                        cev.Mkq = drb;
                    }
                    AppMethodBeat.o(123619);
                    return 0;
                case 5:
                    cev.xMq = aVar3.UbS.readString();
                    AppMethodBeat.o(123619);
                    return 0;
                case 6:
                    cev.KFs = aVar3.UbS.readString();
                    AppMethodBeat.o(123619);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        aeu aeu = new aeu();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = aeu.populateBuilderWithField(aVar7, aeu, dpc.getNextFieldNumber(aVar7))) {
                        }
                        cev.Mkr = aeu;
                    }
                    AppMethodBeat.o(123619);
                    return 0;
                case 8:
                    cev.Mks = aVar3.UbS.yZ();
                    AppMethodBeat.o(123619);
                    return 0;
                case 9:
                    cev.Mke = aVar3.UbS.readString();
                    AppMethodBeat.o(123619);
                    return 0;
                case 10:
                    cev.Mkf = aVar3.UbS.readString();
                    AppMethodBeat.o(123619);
                    return 0;
                case 11:
                    cev.Mkg = aVar3.UbS.readString();
                    AppMethodBeat.o(123619);
                    return 0;
                case 12:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        eoq eoq = new eoq();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = eoq.populateBuilderWithField(aVar8, eoq, dpc.getNextFieldNumber(aVar8))) {
                        }
                        cev.Mkt = eoq;
                    }
                    AppMethodBeat.o(123619);
                    return 0;
                case 13:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        dy dyVar = new dy();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = dyVar.populateBuilderWithField(aVar9, dyVar, dpc.getNextFieldNumber(aVar9))) {
                        }
                        cev.Mkh = dyVar;
                    }
                    AppMethodBeat.o(123619);
                    return 0;
                default:
                    AppMethodBeat.o(123619);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123619);
            return -1;
        }
    }
}
