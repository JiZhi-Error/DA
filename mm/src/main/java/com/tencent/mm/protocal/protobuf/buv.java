package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class buv extends dpc {
    public dsr Mbc;
    public dro Mbd;
    public drn Mbe;
    public dsu Mbf;
    public dsv Mbg;
    public drz Mbh;
    public dsa Mbi;
    public drw Mbj;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(187874);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.Mbc != null) {
                aVar.ni(2, this.Mbc.computeSize());
                this.Mbc.writeFields(aVar);
            }
            if (this.Mbd != null) {
                aVar.ni(3, this.Mbd.computeSize());
                this.Mbd.writeFields(aVar);
            }
            if (this.Mbe != null) {
                aVar.ni(4, this.Mbe.computeSize());
                this.Mbe.writeFields(aVar);
            }
            if (this.Mbf != null) {
                aVar.ni(5, this.Mbf.computeSize());
                this.Mbf.writeFields(aVar);
            }
            if (this.Mbg != null) {
                aVar.ni(6, this.Mbg.computeSize());
                this.Mbg.writeFields(aVar);
            }
            if (this.Mbh != null) {
                aVar.ni(7, this.Mbh.computeSize());
                this.Mbh.writeFields(aVar);
            }
            if (this.Mbi != null) {
                aVar.ni(8, this.Mbi.computeSize());
                this.Mbi.writeFields(aVar);
            }
            if (this.Mbj != null) {
                aVar.ni(9, this.Mbj.computeSize());
                this.Mbj.writeFields(aVar);
            }
            AppMethodBeat.o(187874);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.Mbc != null) {
                nh += g.a.a.a.nh(2, this.Mbc.computeSize());
            }
            if (this.Mbd != null) {
                nh += g.a.a.a.nh(3, this.Mbd.computeSize());
            }
            if (this.Mbe != null) {
                nh += g.a.a.a.nh(4, this.Mbe.computeSize());
            }
            if (this.Mbf != null) {
                nh += g.a.a.a.nh(5, this.Mbf.computeSize());
            }
            if (this.Mbg != null) {
                nh += g.a.a.a.nh(6, this.Mbg.computeSize());
            }
            if (this.Mbh != null) {
                nh += g.a.a.a.nh(7, this.Mbh.computeSize());
            }
            if (this.Mbi != null) {
                nh += g.a.a.a.nh(8, this.Mbi.computeSize());
            }
            if (this.Mbj != null) {
                nh += g.a.a.a.nh(9, this.Mbj.computeSize());
            }
            AppMethodBeat.o(187874);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(187874);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            buv buv = (buv) objArr[1];
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
                        buv.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(187874);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dsr dsr = new dsr();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dsr.populateBuilderWithField(aVar5, dsr, dpc.getNextFieldNumber(aVar5))) {
                        }
                        buv.Mbc = dsr;
                    }
                    AppMethodBeat.o(187874);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dro dro = new dro();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dro.populateBuilderWithField(aVar6, dro, dpc.getNextFieldNumber(aVar6))) {
                        }
                        buv.Mbd = dro;
                    }
                    AppMethodBeat.o(187874);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        drn drn = new drn();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = drn.populateBuilderWithField(aVar7, drn, dpc.getNextFieldNumber(aVar7))) {
                        }
                        buv.Mbe = drn;
                    }
                    AppMethodBeat.o(187874);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        dsu dsu = new dsu();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = dsu.populateBuilderWithField(aVar8, dsu, dpc.getNextFieldNumber(aVar8))) {
                        }
                        buv.Mbf = dsu;
                    }
                    AppMethodBeat.o(187874);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        dsv dsv = new dsv();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = dsv.populateBuilderWithField(aVar9, dsv, dpc.getNextFieldNumber(aVar9))) {
                        }
                        buv.Mbg = dsv;
                    }
                    AppMethodBeat.o(187874);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        drz drz = new drz();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = drz.populateBuilderWithField(aVar10, drz, dpc.getNextFieldNumber(aVar10))) {
                        }
                        buv.Mbh = drz;
                    }
                    AppMethodBeat.o(187874);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh8 = aVar3.awh(intValue);
                    int size8 = awh8.size();
                    for (int i10 = 0; i10 < size8; i10++) {
                        dsa dsa = new dsa();
                        g.a.a.a.a aVar11 = new g.a.a.a.a(awh8.get(i10), unknownTagHandler);
                        for (boolean z8 = true; z8; z8 = dsa.populateBuilderWithField(aVar11, dsa, dpc.getNextFieldNumber(aVar11))) {
                        }
                        buv.Mbi = dsa;
                    }
                    AppMethodBeat.o(187874);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh9 = aVar3.awh(intValue);
                    int size9 = awh9.size();
                    for (int i11 = 0; i11 < size9; i11++) {
                        drw drw = new drw();
                        g.a.a.a.a aVar12 = new g.a.a.a.a(awh9.get(i11), unknownTagHandler);
                        for (boolean z9 = true; z9; z9 = drw.populateBuilderWithField(aVar12, drw, dpc.getNextFieldNumber(aVar12))) {
                        }
                        buv.Mbj = drw;
                    }
                    AppMethodBeat.o(187874);
                    return 0;
                default:
                    AppMethodBeat.o(187874);
                    return -1;
            }
        } else {
            AppMethodBeat.o(187874);
            return -1;
        }
    }
}
