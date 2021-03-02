package com.tencent.mm.protocal.protobuf;

import android.support.constraint.ConstraintLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.bv;
import com.tencent.mm.plugin.appbrand.jsapi.h.h;
import com.tencent.mm.plugin.appbrand.jsapi.pay.n;
import com.tencent.mm.plugin.appbrand.jsapi.pay.s;
import com.tencent.mm.plugin.appbrand.jsapi.r.f;
import com.tencent.mm.plugin.appbrand.jsapi.share.d;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.thumbplayer.core.common.TPCodecParamers;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dhn extends dpc {
    public String HtI;
    public String HuS;
    public int MAf;
    public dde MAl;
    public String MLJ;
    public String MLP;
    public String MLQ;
    public String MLR;
    public int MLS;
    public LinkedList<ahq> MLT = new LinkedList<>();
    public int MLU;
    public LinkedList<ahq> MLV = new LinkedList<>();
    public ahq MLW;
    public LinkedList<ahq> MLX = new LinkedList<>();
    public ahq MLY;
    public cox MLZ;
    public String MMa;
    public int MMb;
    public String MMc;
    public int MMd;
    public boolean MMe;
    public String MMf;
    public String MMg;
    public LinkedList<ctg> MMh = new LinkedList<>();
    public String MMi;
    public String MMj;
    public String MMk;
    public ctg MMl;
    public cgt MMm;
    public cgt MMn;
    public String MMo;
    public String MMp;
    public aof MMq;
    public LinkedList<ctg> MMr = new LinkedList<>();
    public String MMs;
    public String MMt;
    public ctg MMu;
    public chu MMv;
    public ctg MMw;
    public boolean Mma;
    public String Mnk;
    public String Mnl;
    public ckj efB;
    public int egj;
    public int pTZ;
    public String pUa;
    public int yba;

    public dhn() {
        AppMethodBeat.i(91644);
        AppMethodBeat.o(91644);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91645);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(91645);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.pTZ);
            if (this.pUa != null) {
                aVar.e(3, this.pUa);
            }
            aVar.aM(4, this.MAf);
            if (this.MLP != null) {
                aVar.e(5, this.MLP);
            }
            if (this.MLQ != null) {
                aVar.e(6, this.MLQ);
            }
            if (this.MLR != null) {
                aVar.e(7, this.MLR);
            }
            aVar.aM(8, this.MLS);
            aVar.e(9, 8, this.MLT);
            aVar.aM(10, this.egj);
            aVar.aM(11, this.MLU);
            aVar.e(12, 8, this.MLV);
            if (this.Mnl != null) {
                aVar.e(13, this.Mnl);
            }
            if (this.MLW != null) {
                aVar.ni(14, this.MLW.computeSize());
                this.MLW.writeFields(aVar);
            }
            aVar.e(15, 8, this.MLX);
            if (this.MLY != null) {
                aVar.ni(16, this.MLY.computeSize());
                this.MLY.writeFields(aVar);
            }
            if (this.MLZ != null) {
                aVar.ni(17, this.MLZ.computeSize());
                this.MLZ.writeFields(aVar);
            }
            if (this.MMa != null) {
                aVar.e(18, this.MMa);
            }
            aVar.aM(19, this.MMb);
            if (this.MMc != null) {
                aVar.e(20, this.MMc);
            }
            if (this.MLJ != null) {
                aVar.e(21, this.MLJ);
            }
            aVar.aM(22, this.MMd);
            aVar.cc(23, this.MMe);
            aVar.aM(24, this.yba);
            if (this.Mnk != null) {
                aVar.e(25, this.Mnk);
            }
            if (this.MMf != null) {
                aVar.e(26, this.MMf);
            }
            if (this.MMg != null) {
                aVar.e(27, this.MMg);
            }
            aVar.e(28, 8, this.MMh);
            if (this.MMi != null) {
                aVar.e(29, this.MMi);
            }
            if (this.MMj != null) {
                aVar.e(30, this.MMj);
            }
            if (this.MMk != null) {
                aVar.e(31, this.MMk);
            }
            if (this.HtI != null) {
                aVar.e(32, this.HtI);
            }
            if (this.MMl != null) {
                aVar.ni(33, this.MMl.computeSize());
                this.MMl.writeFields(aVar);
            }
            if (this.MMm != null) {
                aVar.ni(34, this.MMm.computeSize());
                this.MMm.writeFields(aVar);
            }
            if (this.MMn != null) {
                aVar.ni(35, this.MMn.computeSize());
                this.MMn.writeFields(aVar);
            }
            if (this.MMo != null) {
                aVar.e(36, this.MMo);
            }
            if (this.MMp != null) {
                aVar.e(37, this.MMp);
            }
            if (this.MMq != null) {
                aVar.ni(38, this.MMq.computeSize());
                this.MMq.writeFields(aVar);
            }
            aVar.cc(39, this.Mma);
            if (this.MAl != null) {
                aVar.ni(40, this.MAl.computeSize());
                this.MAl.writeFields(aVar);
            }
            aVar.e(41, 8, this.MMr);
            if (this.MMs != null) {
                aVar.e(42, this.MMs);
            }
            if (this.MMt != null) {
                aVar.e(43, this.MMt);
            }
            if (this.MMu != null) {
                aVar.ni(44, this.MMu.computeSize());
                this.MMu.writeFields(aVar);
            }
            if (this.MMv != null) {
                aVar.ni(45, this.MMv.computeSize());
                this.MMv.writeFields(aVar);
            }
            if (this.MMw != null) {
                aVar.ni(46, this.MMw.computeSize());
                this.MMw.writeFields(aVar);
            }
            if (this.efB != null) {
                aVar.ni(99, this.efB.computeSize());
                this.efB.writeFields(aVar);
            }
            if (this.HuS != null) {
                aVar.e(100, this.HuS);
            }
            AppMethodBeat.o(91645);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.pTZ);
            if (this.pUa != null) {
                nh += g.a.a.b.b.a.f(3, this.pUa);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.MAf);
            if (this.MLP != null) {
                bu += g.a.a.b.b.a.f(5, this.MLP);
            }
            if (this.MLQ != null) {
                bu += g.a.a.b.b.a.f(6, this.MLQ);
            }
            if (this.MLR != null) {
                bu += g.a.a.b.b.a.f(7, this.MLR);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(8, this.MLS) + g.a.a.a.c(9, 8, this.MLT) + g.a.a.b.b.a.bu(10, this.egj) + g.a.a.b.b.a.bu(11, this.MLU) + g.a.a.a.c(12, 8, this.MLV);
            if (this.Mnl != null) {
                bu2 += g.a.a.b.b.a.f(13, this.Mnl);
            }
            if (this.MLW != null) {
                bu2 += g.a.a.a.nh(14, this.MLW.computeSize());
            }
            int c2 = bu2 + g.a.a.a.c(15, 8, this.MLX);
            if (this.MLY != null) {
                c2 += g.a.a.a.nh(16, this.MLY.computeSize());
            }
            if (this.MLZ != null) {
                c2 += g.a.a.a.nh(17, this.MLZ.computeSize());
            }
            if (this.MMa != null) {
                c2 += g.a.a.b.b.a.f(18, this.MMa);
            }
            int bu3 = c2 + g.a.a.b.b.a.bu(19, this.MMb);
            if (this.MMc != null) {
                bu3 += g.a.a.b.b.a.f(20, this.MMc);
            }
            if (this.MLJ != null) {
                bu3 += g.a.a.b.b.a.f(21, this.MLJ);
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(22, this.MMd) + g.a.a.b.b.a.fS(23) + 1 + g.a.a.b.b.a.bu(24, this.yba);
            if (this.Mnk != null) {
                bu4 += g.a.a.b.b.a.f(25, this.Mnk);
            }
            if (this.MMf != null) {
                bu4 += g.a.a.b.b.a.f(26, this.MMf);
            }
            if (this.MMg != null) {
                bu4 += g.a.a.b.b.a.f(27, this.MMg);
            }
            int c3 = bu4 + g.a.a.a.c(28, 8, this.MMh);
            if (this.MMi != null) {
                c3 += g.a.a.b.b.a.f(29, this.MMi);
            }
            if (this.MMj != null) {
                c3 += g.a.a.b.b.a.f(30, this.MMj);
            }
            if (this.MMk != null) {
                c3 += g.a.a.b.b.a.f(31, this.MMk);
            }
            if (this.HtI != null) {
                c3 += g.a.a.b.b.a.f(32, this.HtI);
            }
            if (this.MMl != null) {
                c3 += g.a.a.a.nh(33, this.MMl.computeSize());
            }
            if (this.MMm != null) {
                c3 += g.a.a.a.nh(34, this.MMm.computeSize());
            }
            if (this.MMn != null) {
                c3 += g.a.a.a.nh(35, this.MMn.computeSize());
            }
            if (this.MMo != null) {
                c3 += g.a.a.b.b.a.f(36, this.MMo);
            }
            if (this.MMp != null) {
                c3 += g.a.a.b.b.a.f(37, this.MMp);
            }
            if (this.MMq != null) {
                c3 += g.a.a.a.nh(38, this.MMq.computeSize());
            }
            int fS = c3 + g.a.a.b.b.a.fS(39) + 1;
            if (this.MAl != null) {
                fS += g.a.a.a.nh(40, this.MAl.computeSize());
            }
            int c4 = fS + g.a.a.a.c(41, 8, this.MMr);
            if (this.MMs != null) {
                c4 += g.a.a.b.b.a.f(42, this.MMs);
            }
            if (this.MMt != null) {
                c4 += g.a.a.b.b.a.f(43, this.MMt);
            }
            if (this.MMu != null) {
                c4 += g.a.a.a.nh(44, this.MMu.computeSize());
            }
            if (this.MMv != null) {
                c4 += g.a.a.a.nh(45, this.MMv.computeSize());
            }
            if (this.MMw != null) {
                c4 += g.a.a.a.nh(46, this.MMw.computeSize());
            }
            if (this.efB != null) {
                c4 += g.a.a.a.nh(99, this.efB.computeSize());
            }
            if (this.HuS != null) {
                c4 += g.a.a.b.b.a.f(100, this.HuS);
            }
            AppMethodBeat.o(91645);
            return c4;
        } else if (i2 == 2) {
            this.MLT.clear();
            this.MLV.clear();
            this.MLX.clear();
            this.MMh.clear();
            this.MMr.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(91645);
                throw bVar2;
            }
            AppMethodBeat.o(91645);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dhn dhn = (dhn) objArr[1];
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
                        dhn.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(91645);
                    return 0;
                case 2:
                    dhn.pTZ = aVar3.UbS.zi();
                    AppMethodBeat.o(91645);
                    return 0;
                case 3:
                    dhn.pUa = aVar3.UbS.readString();
                    AppMethodBeat.o(91645);
                    return 0;
                case 4:
                    dhn.MAf = aVar3.UbS.zi();
                    AppMethodBeat.o(91645);
                    return 0;
                case 5:
                    dhn.MLP = aVar3.UbS.readString();
                    AppMethodBeat.o(91645);
                    return 0;
                case 6:
                    dhn.MLQ = aVar3.UbS.readString();
                    AppMethodBeat.o(91645);
                    return 0;
                case 7:
                    dhn.MLR = aVar3.UbS.readString();
                    AppMethodBeat.o(91645);
                    return 0;
                case 8:
                    dhn.MLS = aVar3.UbS.zi();
                    AppMethodBeat.o(91645);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ahq ahq = new ahq();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ahq.populateBuilderWithField(aVar5, ahq, dpc.getNextFieldNumber(aVar5))) {
                        }
                        dhn.MLT.add(ahq);
                    }
                    AppMethodBeat.o(91645);
                    return 0;
                case 10:
                    dhn.egj = aVar3.UbS.zi();
                    AppMethodBeat.o(91645);
                    return 0;
                case 11:
                    dhn.MLU = aVar3.UbS.zi();
                    AppMethodBeat.o(91645);
                    return 0;
                case 12:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        ahq ahq2 = new ahq();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = ahq2.populateBuilderWithField(aVar6, ahq2, dpc.getNextFieldNumber(aVar6))) {
                        }
                        dhn.MLV.add(ahq2);
                    }
                    AppMethodBeat.o(91645);
                    return 0;
                case 13:
                    dhn.Mnl = aVar3.UbS.readString();
                    AppMethodBeat.o(91645);
                    return 0;
                case 14:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        ahq ahq3 = new ahq();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = ahq3.populateBuilderWithField(aVar7, ahq3, dpc.getNextFieldNumber(aVar7))) {
                        }
                        dhn.MLW = ahq3;
                    }
                    AppMethodBeat.o(91645);
                    return 0;
                case 15:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        ahq ahq4 = new ahq();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = ahq4.populateBuilderWithField(aVar8, ahq4, dpc.getNextFieldNumber(aVar8))) {
                        }
                        dhn.MLX.add(ahq4);
                    }
                    AppMethodBeat.o(91645);
                    return 0;
                case 16:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        ahq ahq5 = new ahq();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = ahq5.populateBuilderWithField(aVar9, ahq5, dpc.getNextFieldNumber(aVar9))) {
                        }
                        dhn.MLY = ahq5;
                    }
                    AppMethodBeat.o(91645);
                    return 0;
                case 17:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        cox cox = new cox();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = cox.populateBuilderWithField(aVar10, cox, dpc.getNextFieldNumber(aVar10))) {
                        }
                        dhn.MLZ = cox;
                    }
                    AppMethodBeat.o(91645);
                    return 0;
                case 18:
                    dhn.MMa = aVar3.UbS.readString();
                    AppMethodBeat.o(91645);
                    return 0;
                case 19:
                    dhn.MMb = aVar3.UbS.zi();
                    AppMethodBeat.o(91645);
                    return 0;
                case 20:
                    dhn.MMc = aVar3.UbS.readString();
                    AppMethodBeat.o(91645);
                    return 0;
                case 21:
                    dhn.MLJ = aVar3.UbS.readString();
                    AppMethodBeat.o(91645);
                    return 0;
                case 22:
                    dhn.MMd = aVar3.UbS.zi();
                    AppMethodBeat.o(91645);
                    return 0;
                case 23:
                    dhn.MMe = aVar3.UbS.yZ();
                    AppMethodBeat.o(91645);
                    return 0;
                case 24:
                    dhn.yba = aVar3.UbS.zi();
                    AppMethodBeat.o(91645);
                    return 0;
                case 25:
                    dhn.Mnk = aVar3.UbS.readString();
                    AppMethodBeat.o(91645);
                    return 0;
                case 26:
                    dhn.MMf = aVar3.UbS.readString();
                    AppMethodBeat.o(91645);
                    return 0;
                case 27:
                    dhn.MMg = aVar3.UbS.readString();
                    AppMethodBeat.o(91645);
                    return 0;
                case 28:
                    LinkedList<byte[]> awh8 = aVar3.awh(intValue);
                    int size8 = awh8.size();
                    for (int i10 = 0; i10 < size8; i10++) {
                        ctg ctg = new ctg();
                        g.a.a.a.a aVar11 = new g.a.a.a.a(awh8.get(i10), unknownTagHandler);
                        for (boolean z8 = true; z8; z8 = ctg.populateBuilderWithField(aVar11, ctg, dpc.getNextFieldNumber(aVar11))) {
                        }
                        dhn.MMh.add(ctg);
                    }
                    AppMethodBeat.o(91645);
                    return 0;
                case 29:
                    dhn.MMi = aVar3.UbS.readString();
                    AppMethodBeat.o(91645);
                    return 0;
                case 30:
                    dhn.MMj = aVar3.UbS.readString();
                    AppMethodBeat.o(91645);
                    return 0;
                case 31:
                    dhn.MMk = aVar3.UbS.readString();
                    AppMethodBeat.o(91645);
                    return 0;
                case 32:
                    dhn.HtI = aVar3.UbS.readString();
                    AppMethodBeat.o(91645);
                    return 0;
                case 33:
                    LinkedList<byte[]> awh9 = aVar3.awh(intValue);
                    int size9 = awh9.size();
                    for (int i11 = 0; i11 < size9; i11++) {
                        ctg ctg2 = new ctg();
                        g.a.a.a.a aVar12 = new g.a.a.a.a(awh9.get(i11), unknownTagHandler);
                        for (boolean z9 = true; z9; z9 = ctg2.populateBuilderWithField(aVar12, ctg2, dpc.getNextFieldNumber(aVar12))) {
                        }
                        dhn.MMl = ctg2;
                    }
                    AppMethodBeat.o(91645);
                    return 0;
                case 34:
                    LinkedList<byte[]> awh10 = aVar3.awh(intValue);
                    int size10 = awh10.size();
                    for (int i12 = 0; i12 < size10; i12++) {
                        cgt cgt = new cgt();
                        g.a.a.a.a aVar13 = new g.a.a.a.a(awh10.get(i12), unknownTagHandler);
                        for (boolean z10 = true; z10; z10 = cgt.populateBuilderWithField(aVar13, cgt, dpc.getNextFieldNumber(aVar13))) {
                        }
                        dhn.MMm = cgt;
                    }
                    AppMethodBeat.o(91645);
                    return 0;
                case 35:
                    LinkedList<byte[]> awh11 = aVar3.awh(intValue);
                    int size11 = awh11.size();
                    for (int i13 = 0; i13 < size11; i13++) {
                        cgt cgt2 = new cgt();
                        g.a.a.a.a aVar14 = new g.a.a.a.a(awh11.get(i13), unknownTagHandler);
                        for (boolean z11 = true; z11; z11 = cgt2.populateBuilderWithField(aVar14, cgt2, dpc.getNextFieldNumber(aVar14))) {
                        }
                        dhn.MMn = cgt2;
                    }
                    AppMethodBeat.o(91645);
                    return 0;
                case 36:
                    dhn.MMo = aVar3.UbS.readString();
                    AppMethodBeat.o(91645);
                    return 0;
                case 37:
                    dhn.MMp = aVar3.UbS.readString();
                    AppMethodBeat.o(91645);
                    return 0;
                case 38:
                    LinkedList<byte[]> awh12 = aVar3.awh(intValue);
                    int size12 = awh12.size();
                    for (int i14 = 0; i14 < size12; i14++) {
                        aof aof = new aof();
                        g.a.a.a.a aVar15 = new g.a.a.a.a(awh12.get(i14), unknownTagHandler);
                        for (boolean z12 = true; z12; z12 = aof.populateBuilderWithField(aVar15, aof, dpc.getNextFieldNumber(aVar15))) {
                        }
                        dhn.MMq = aof;
                    }
                    AppMethodBeat.o(91645);
                    return 0;
                case 39:
                    dhn.Mma = aVar3.UbS.yZ();
                    AppMethodBeat.o(91645);
                    return 0;
                case 40:
                    LinkedList<byte[]> awh13 = aVar3.awh(intValue);
                    int size13 = awh13.size();
                    for (int i15 = 0; i15 < size13; i15++) {
                        dde dde = new dde();
                        g.a.a.a.a aVar16 = new g.a.a.a.a(awh13.get(i15), unknownTagHandler);
                        for (boolean z13 = true; z13; z13 = dde.populateBuilderWithField(aVar16, dde, dpc.getNextFieldNumber(aVar16))) {
                        }
                        dhn.MAl = dde;
                    }
                    AppMethodBeat.o(91645);
                    return 0;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_CREATOR:
                    LinkedList<byte[]> awh14 = aVar3.awh(intValue);
                    int size14 = awh14.size();
                    for (int i16 = 0; i16 < size14; i16++) {
                        ctg ctg3 = new ctg();
                        g.a.a.a.a aVar17 = new g.a.a.a.a(awh14.get(i16), unknownTagHandler);
                        for (boolean z14 = true; z14; z14 = ctg3.populateBuilderWithField(aVar17, ctg3, dpc.getNextFieldNumber(aVar17))) {
                        }
                        dhn.MMr.add(ctg3);
                    }
                    AppMethodBeat.o(91645);
                    return 0;
                case 42:
                    dhn.MMs = aVar3.UbS.readString();
                    AppMethodBeat.o(91645);
                    return 0;
                case 43:
                    dhn.MMt = aVar3.UbS.readString();
                    AppMethodBeat.o(91645);
                    return 0;
                case 44:
                    LinkedList<byte[]> awh15 = aVar3.awh(intValue);
                    int size15 = awh15.size();
                    for (int i17 = 0; i17 < size15; i17++) {
                        ctg ctg4 = new ctg();
                        g.a.a.a.a aVar18 = new g.a.a.a.a(awh15.get(i17), unknownTagHandler);
                        for (boolean z15 = true; z15; z15 = ctg4.populateBuilderWithField(aVar18, ctg4, dpc.getNextFieldNumber(aVar18))) {
                        }
                        dhn.MMu = ctg4;
                    }
                    AppMethodBeat.o(91645);
                    return 0;
                case 45:
                    LinkedList<byte[]> awh16 = aVar3.awh(intValue);
                    int size16 = awh16.size();
                    for (int i18 = 0; i18 < size16; i18++) {
                        chu chu = new chu();
                        g.a.a.a.a aVar19 = new g.a.a.a.a(awh16.get(i18), unknownTagHandler);
                        for (boolean z16 = true; z16; z16 = chu.populateBuilderWithField(aVar19, chu, dpc.getNextFieldNumber(aVar19))) {
                        }
                        dhn.MMv = chu;
                    }
                    AppMethodBeat.o(91645);
                    return 0;
                case 46:
                    LinkedList<byte[]> awh17 = aVar3.awh(intValue);
                    int size17 = awh17.size();
                    for (int i19 = 0; i19 < size17; i19++) {
                        ctg ctg5 = new ctg();
                        g.a.a.a.a aVar20 = new g.a.a.a.a(awh17.get(i19), unknownTagHandler);
                        for (boolean z17 = true; z17; z17 = ctg5.populateBuilderWithField(aVar20, ctg5, dpc.getNextFieldNumber(aVar20))) {
                        }
                        dhn.MMw = ctg5;
                    }
                    AppMethodBeat.o(91645);
                    return 0;
                case 47:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case n.CTRL_INDEX:
                case 58:
                case bv.CTRL_INDEX:
                case 60:
                case PlayerException.EXCEPTION_TYPE_INITLIB /*{ENCODED_INT: 61}*/:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                case 69:
                case 70:
                case 71:
                case 72:
                case d.CTRL_INDEX:
                case 74:
                case 75:
                case WXMediaMessage.IMediaObject.TYPE_MUSIC_VIDEO:
                case TPCodecParamers.TP_PROFILE_H264_MAIN /*{ENCODED_INT: 77}*/:
                case h.a.CTRL_INDEX:
                case 79:
                case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*{ENCODED_INT: 80}*/:
                case 81:
                case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_JAVA_DATASOURCE /*{ENCODED_INT: 82}*/:
                case 83:
                case f.CTRL_INDEX:
                case s.CTRL_INDEX:
                case com.tencent.mm.plugin.appbrand.jsapi.pay.b.CTRL_INDEX:
                case 87:
                case TPCodecParamers.TP_PROFILE_H264_EXTENDED /*{ENCODED_INT: 88}*/:
                case PlayerException.EXCEPTION_IN_CHECK_STATE /*{ENCODED_INT: 89}*/:
                case 90:
                case PlayerException.EXCEPTION_IN_PREPARE /*{ENCODED_INT: 91}*/:
                case 92:
                case PlayerException.EXCEPTION_IN_PAUSE /*{ENCODED_INT: 93}*/:
                case 94:
                case PlayerException.EXCEPTION_IN_SEEK /*{ENCODED_INT: 95}*/:
                case PlayerException.EXCEPTION_IN_SETAUDIOEFFECT /*{ENCODED_INT: 96}*/:
                case PlayerException.EXCEPTION_IN_RELEASE /*{ENCODED_INT: 97}*/:
                case 98:
                default:
                    AppMethodBeat.o(91645);
                    return -1;
                case 99:
                    LinkedList<byte[]> awh18 = aVar3.awh(intValue);
                    int size18 = awh18.size();
                    for (int i20 = 0; i20 < size18; i20++) {
                        ckj ckj = new ckj();
                        g.a.a.a.a aVar21 = new g.a.a.a.a(awh18.get(i20), unknownTagHandler);
                        for (boolean z18 = true; z18; z18 = ckj.populateBuilderWithField(aVar21, ckj, dpc.getNextFieldNumber(aVar21))) {
                        }
                        dhn.efB = ckj;
                    }
                    AppMethodBeat.o(91645);
                    return 0;
                case 100:
                    dhn.HuS = aVar3.UbS.readString();
                    AppMethodBeat.o(91645);
                    return 0;
            }
        } else {
            AppMethodBeat.o(91645);
            return -1;
        }
    }
}
