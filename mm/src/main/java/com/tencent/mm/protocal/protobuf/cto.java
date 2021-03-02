package com.tencent.mm.protocal.protobuf;

import android.support.constraint.ConstraintLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class cto extends dop {
    public String Bri;
    public int KDZ;
    public String KEa;
    public String KEb;
    public String KFu;
    public int KLM;
    public String KLN;
    public SKBuiltinBuffer_t KLP;
    public SKBuiltinBuffer_t KLQ;
    public String KLR;
    public dfx KLS;
    public aif KLY;
    public int KPT;
    public SKBuiltinBuffer_t KPW;
    public int KPZ;
    public String KQa;
    public String KQf;
    public String KQi;
    public String Lsj;
    public int LtW;
    public int LtX;
    public String LtY;
    public String LuU;
    public String MbJ;
    public String MbK;
    public String Mrx;
    public int MyA;
    public String MyB;
    public String MyC;
    public String MyD;
    public String MyE;
    public String MyF;
    public String MyG;
    public int MyH;
    public String MyI;
    public String MyJ;
    public int Myz;
    public String UserName;
    public String ked;
    public String oUJ;
    public String rBH;
    public String rBI;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(133184);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.UserName != null) {
                aVar.e(2, this.UserName);
            }
            if (this.KQi != null) {
                aVar.e(3, this.KQi);
            }
            if (this.oUJ != null) {
                aVar.e(4, this.oUJ);
            }
            aVar.aM(5, this.KDZ);
            if (this.KEa != null) {
                aVar.e(6, this.KEa);
            }
            if (this.KEb != null) {
                aVar.e(7, this.KEb);
            }
            if (this.Bri != null) {
                aVar.e(8, this.Bri);
            }
            aVar.aM(12, this.KLM);
            aVar.aM(13, this.Myz);
            aVar.aM(14, this.LtW);
            if (this.rBH != null) {
                aVar.e(15, this.rBH);
            }
            if (this.rBI != null) {
                aVar.e(16, this.rBI);
            }
            aVar.aM(17, this.KPT);
            if (this.Lsj != null) {
                aVar.e(18, this.Lsj);
            }
            if (this.KPW != null) {
                aVar.ni(19, this.KPW.computeSize());
                this.KPW.writeFields(aVar);
            }
            if (this.ked != null) {
                aVar.e(20, this.ked);
            }
            if (this.MbJ != null) {
                aVar.e(21, this.MbJ);
            }
            if (this.MbK != null) {
                aVar.e(22, this.MbK);
            }
            aVar.aM(23, this.LtX);
            aVar.aM(24, this.MyA);
            if (this.KLN != null) {
                aVar.e(31, this.KLN);
            }
            if (this.Mrx != null) {
                aVar.e(32, this.Mrx);
            }
            if (this.MyB != null) {
                aVar.e(33, this.MyB);
            }
            if (this.LuU != null) {
                aVar.e(34, this.LuU);
            }
            if (this.MyC != null) {
                aVar.e(35, this.MyC);
            }
            if (this.MyD != null) {
                aVar.e(36, this.MyD);
            }
            if (this.KLY != null) {
                aVar.ni(37, this.KLY.computeSize());
                this.KLY.writeFields(aVar);
            }
            if (this.MyE != null) {
                aVar.e(38, this.MyE);
            }
            if (this.KLR != null) {
                aVar.e(39, this.KLR);
            }
            if (this.MyF != null) {
                aVar.e(40, this.MyF);
            }
            if (this.MyG != null) {
                aVar.e(41, this.MyG);
            }
            aVar.aM(42, this.MyH);
            if (this.KLP != null) {
                aVar.ni(43, this.KLP.computeSize());
                this.KLP.writeFields(aVar);
            }
            aVar.aM(44, this.KPZ);
            if (this.KQa != null) {
                aVar.e(45, this.KQa);
            }
            if (this.LtY != null) {
                aVar.e(46, this.LtY);
            }
            if (this.MyI != null) {
                aVar.e(47, this.MyI);
            }
            if (this.KLQ != null) {
                aVar.ni(48, this.KLQ.computeSize());
                this.KLQ.writeFields(aVar);
            }
            if (this.MyJ != null) {
                aVar.e(49, this.MyJ);
            }
            if (this.KFu != null) {
                aVar.e(50, this.KFu);
            }
            if (this.KQf != null) {
                aVar.e(51, this.KQf);
            }
            if (this.KLS != null) {
                aVar.ni(52, this.KLS.computeSize());
                this.KLS.writeFields(aVar);
            }
            AppMethodBeat.o(133184);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.UserName != null) {
                nh += g.a.a.b.b.a.f(2, this.UserName);
            }
            if (this.KQi != null) {
                nh += g.a.a.b.b.a.f(3, this.KQi);
            }
            if (this.oUJ != null) {
                nh += g.a.a.b.b.a.f(4, this.oUJ);
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.KDZ);
            if (this.KEa != null) {
                bu += g.a.a.b.b.a.f(6, this.KEa);
            }
            if (this.KEb != null) {
                bu += g.a.a.b.b.a.f(7, this.KEb);
            }
            if (this.Bri != null) {
                bu += g.a.a.b.b.a.f(8, this.Bri);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(12, this.KLM) + g.a.a.b.b.a.bu(13, this.Myz) + g.a.a.b.b.a.bu(14, this.LtW);
            if (this.rBH != null) {
                bu2 += g.a.a.b.b.a.f(15, this.rBH);
            }
            if (this.rBI != null) {
                bu2 += g.a.a.b.b.a.f(16, this.rBI);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(17, this.KPT);
            if (this.Lsj != null) {
                bu3 += g.a.a.b.b.a.f(18, this.Lsj);
            }
            if (this.KPW != null) {
                bu3 += g.a.a.a.nh(19, this.KPW.computeSize());
            }
            if (this.ked != null) {
                bu3 += g.a.a.b.b.a.f(20, this.ked);
            }
            if (this.MbJ != null) {
                bu3 += g.a.a.b.b.a.f(21, this.MbJ);
            }
            if (this.MbK != null) {
                bu3 += g.a.a.b.b.a.f(22, this.MbK);
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(23, this.LtX) + g.a.a.b.b.a.bu(24, this.MyA);
            if (this.KLN != null) {
                bu4 += g.a.a.b.b.a.f(31, this.KLN);
            }
            if (this.Mrx != null) {
                bu4 += g.a.a.b.b.a.f(32, this.Mrx);
            }
            if (this.MyB != null) {
                bu4 += g.a.a.b.b.a.f(33, this.MyB);
            }
            if (this.LuU != null) {
                bu4 += g.a.a.b.b.a.f(34, this.LuU);
            }
            if (this.MyC != null) {
                bu4 += g.a.a.b.b.a.f(35, this.MyC);
            }
            if (this.MyD != null) {
                bu4 += g.a.a.b.b.a.f(36, this.MyD);
            }
            if (this.KLY != null) {
                bu4 += g.a.a.a.nh(37, this.KLY.computeSize());
            }
            if (this.MyE != null) {
                bu4 += g.a.a.b.b.a.f(38, this.MyE);
            }
            if (this.KLR != null) {
                bu4 += g.a.a.b.b.a.f(39, this.KLR);
            }
            if (this.MyF != null) {
                bu4 += g.a.a.b.b.a.f(40, this.MyF);
            }
            if (this.MyG != null) {
                bu4 += g.a.a.b.b.a.f(41, this.MyG);
            }
            int bu5 = bu4 + g.a.a.b.b.a.bu(42, this.MyH);
            if (this.KLP != null) {
                bu5 += g.a.a.a.nh(43, this.KLP.computeSize());
            }
            int bu6 = bu5 + g.a.a.b.b.a.bu(44, this.KPZ);
            if (this.KQa != null) {
                bu6 += g.a.a.b.b.a.f(45, this.KQa);
            }
            if (this.LtY != null) {
                bu6 += g.a.a.b.b.a.f(46, this.LtY);
            }
            if (this.MyI != null) {
                bu6 += g.a.a.b.b.a.f(47, this.MyI);
            }
            if (this.KLQ != null) {
                bu6 += g.a.a.a.nh(48, this.KLQ.computeSize());
            }
            if (this.MyJ != null) {
                bu6 += g.a.a.b.b.a.f(49, this.MyJ);
            }
            if (this.KFu != null) {
                bu6 += g.a.a.b.b.a.f(50, this.KFu);
            }
            if (this.KQf != null) {
                bu6 += g.a.a.b.b.a.f(51, this.KQf);
            }
            if (this.KLS != null) {
                bu6 += g.a.a.a.nh(52, this.KLS.computeSize());
            }
            AppMethodBeat.o(133184);
            return bu6;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(133184);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cto cto = (cto) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        jr jrVar = new jr();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = jrVar.populateBuilderWithField(aVar4, jrVar, dop.getNextFieldNumber(aVar4))) {
                        }
                        cto.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(133184);
                    return 0;
                case 2:
                    cto.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(133184);
                    return 0;
                case 3:
                    cto.KQi = aVar3.UbS.readString();
                    AppMethodBeat.o(133184);
                    return 0;
                case 4:
                    cto.oUJ = aVar3.UbS.readString();
                    AppMethodBeat.o(133184);
                    return 0;
                case 5:
                    cto.KDZ = aVar3.UbS.zi();
                    AppMethodBeat.o(133184);
                    return 0;
                case 6:
                    cto.KEa = aVar3.UbS.readString();
                    AppMethodBeat.o(133184);
                    return 0;
                case 7:
                    cto.KEb = aVar3.UbS.readString();
                    AppMethodBeat.o(133184);
                    return 0;
                case 8:
                    cto.Bri = aVar3.UbS.readString();
                    AppMethodBeat.o(133184);
                    return 0;
                case 9:
                case 10:
                case 11:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                default:
                    AppMethodBeat.o(133184);
                    return -1;
                case 12:
                    cto.KLM = aVar3.UbS.zi();
                    AppMethodBeat.o(133184);
                    return 0;
                case 13:
                    cto.Myz = aVar3.UbS.zi();
                    AppMethodBeat.o(133184);
                    return 0;
                case 14:
                    cto.LtW = aVar3.UbS.zi();
                    AppMethodBeat.o(133184);
                    return 0;
                case 15:
                    cto.rBH = aVar3.UbS.readString();
                    AppMethodBeat.o(133184);
                    return 0;
                case 16:
                    cto.rBI = aVar3.UbS.readString();
                    AppMethodBeat.o(133184);
                    return 0;
                case 17:
                    cto.KPT = aVar3.UbS.zi();
                    AppMethodBeat.o(133184);
                    return 0;
                case 18:
                    cto.Lsj = aVar3.UbS.readString();
                    AppMethodBeat.o(133184);
                    return 0;
                case 19:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t.populateBuilderWithField(aVar5, sKBuiltinBuffer_t, dop.getNextFieldNumber(aVar5))) {
                        }
                        cto.KPW = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(133184);
                    return 0;
                case 20:
                    cto.ked = aVar3.UbS.readString();
                    AppMethodBeat.o(133184);
                    return 0;
                case 21:
                    cto.MbJ = aVar3.UbS.readString();
                    AppMethodBeat.o(133184);
                    return 0;
                case 22:
                    cto.MbK = aVar3.UbS.readString();
                    AppMethodBeat.o(133184);
                    return 0;
                case 23:
                    cto.LtX = aVar3.UbS.zi();
                    AppMethodBeat.o(133184);
                    return 0;
                case 24:
                    cto.MyA = aVar3.UbS.zi();
                    AppMethodBeat.o(133184);
                    return 0;
                case 31:
                    cto.KLN = aVar3.UbS.readString();
                    AppMethodBeat.o(133184);
                    return 0;
                case 32:
                    cto.Mrx = aVar3.UbS.readString();
                    AppMethodBeat.o(133184);
                    return 0;
                case 33:
                    cto.MyB = aVar3.UbS.readString();
                    AppMethodBeat.o(133184);
                    return 0;
                case 34:
                    cto.LuU = aVar3.UbS.readString();
                    AppMethodBeat.o(133184);
                    return 0;
                case 35:
                    cto.MyC = aVar3.UbS.readString();
                    AppMethodBeat.o(133184);
                    return 0;
                case 36:
                    cto.MyD = aVar3.UbS.readString();
                    AppMethodBeat.o(133184);
                    return 0;
                case 37:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        aif aif = new aif();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = aif.populateBuilderWithField(aVar6, aif, dop.getNextFieldNumber(aVar6))) {
                        }
                        cto.KLY = aif;
                    }
                    AppMethodBeat.o(133184);
                    return 0;
                case 38:
                    cto.MyE = aVar3.UbS.readString();
                    AppMethodBeat.o(133184);
                    return 0;
                case 39:
                    cto.KLR = aVar3.UbS.readString();
                    AppMethodBeat.o(133184);
                    return 0;
                case 40:
                    cto.MyF = aVar3.UbS.readString();
                    AppMethodBeat.o(133184);
                    return 0;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_CREATOR:
                    cto.MyG = aVar3.UbS.readString();
                    AppMethodBeat.o(133184);
                    return 0;
                case 42:
                    cto.MyH = aVar3.UbS.zi();
                    AppMethodBeat.o(133184);
                    return 0;
                case 43:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t2 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = sKBuiltinBuffer_t2.populateBuilderWithField(aVar7, sKBuiltinBuffer_t2, dop.getNextFieldNumber(aVar7))) {
                        }
                        cto.KLP = sKBuiltinBuffer_t2;
                    }
                    AppMethodBeat.o(133184);
                    return 0;
                case 44:
                    cto.KPZ = aVar3.UbS.zi();
                    AppMethodBeat.o(133184);
                    return 0;
                case 45:
                    cto.KQa = aVar3.UbS.readString();
                    AppMethodBeat.o(133184);
                    return 0;
                case 46:
                    cto.LtY = aVar3.UbS.readString();
                    AppMethodBeat.o(133184);
                    return 0;
                case 47:
                    cto.MyI = aVar3.UbS.readString();
                    AppMethodBeat.o(133184);
                    return 0;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t3 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = sKBuiltinBuffer_t3.populateBuilderWithField(aVar8, sKBuiltinBuffer_t3, dop.getNextFieldNumber(aVar8))) {
                        }
                        cto.KLQ = sKBuiltinBuffer_t3;
                    }
                    AppMethodBeat.o(133184);
                    return 0;
                case 49:
                    cto.MyJ = aVar3.UbS.readString();
                    AppMethodBeat.o(133184);
                    return 0;
                case 50:
                    cto.KFu = aVar3.UbS.readString();
                    AppMethodBeat.o(133184);
                    return 0;
                case 51:
                    cto.KQf = aVar3.UbS.readString();
                    AppMethodBeat.o(133184);
                    return 0;
                case 52:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        dfx dfx = new dfx();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = dfx.populateBuilderWithField(aVar9, dfx, dop.getNextFieldNumber(aVar9))) {
                        }
                        cto.KLS = dfx;
                    }
                    AppMethodBeat.o(133184);
                    return 0;
            }
        } else {
            AppMethodBeat.o(133184);
            return -1;
        }
    }
}
