package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class cmp extends dop {
    public int LYt;
    public int LbA;
    public int Lbz;
    public String MrM;
    public String MrN;
    public String MrO;
    public int MrP;
    public SKBuiltinBuffer_t MrQ;
    public int MrR;
    public int MrS;
    public int MrT;
    public int MrU;
    public SKBuiltinBuffer_t MrV;
    public int MrW;
    public int MrX;
    public int MrY;
    public int MrZ;
    public int Msa;
    public String Msb;
    public String Msc;
    public String ThumbUrl;
    public int xKb;
    public String xLk;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32345);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.MrQ == null) {
                b bVar = new b("Not all required fields were included: DataBuffer");
                AppMethodBeat.o(32345);
                throw bVar;
            } else if (this.MrV == null) {
                b bVar2 = new b("Not all required fields were included: ThumbData");
                AppMethodBeat.o(32345);
                throw bVar2;
            } else {
                if (this.BaseRequest != null) {
                    aVar.ni(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(aVar);
                }
                if (this.MrM != null) {
                    aVar.e(2, this.MrM);
                }
                if (this.MrN != null) {
                    aVar.e(3, this.MrN);
                }
                if (this.MrO != null) {
                    aVar.e(4, this.MrO);
                }
                aVar.aM(5, this.xKb);
                aVar.aM(6, this.MrP);
                if (this.MrQ != null) {
                    aVar.ni(7, this.MrQ.computeSize());
                    this.MrQ.writeFields(aVar);
                }
                aVar.aM(8, this.MrR);
                aVar.aM(9, this.MrS);
                aVar.aM(10, this.MrT);
                aVar.aM(11, this.MrU);
                if (this.MrV != null) {
                    aVar.ni(12, this.MrV.computeSize());
                    this.MrV.writeFields(aVar);
                }
                aVar.aM(13, this.MrW);
                aVar.aM(14, this.MrX);
                aVar.aM(15, this.MrY);
                aVar.aM(16, this.MrZ);
                aVar.aM(17, this.LYt);
                aVar.aM(18, this.Msa);
                if (this.xLk != null) {
                    aVar.e(19, this.xLk);
                }
                if (this.ThumbUrl != null) {
                    aVar.e(20, this.ThumbUrl);
                }
                aVar.aM(21, this.LbA);
                aVar.aM(22, this.Lbz);
                if (this.Msb != null) {
                    aVar.e(23, this.Msb);
                }
                if (this.Msc != null) {
                    aVar.e(24, this.Msc);
                }
                AppMethodBeat.o(32345);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.MrM != null) {
                nh += g.a.a.b.b.a.f(2, this.MrM);
            }
            if (this.MrN != null) {
                nh += g.a.a.b.b.a.f(3, this.MrN);
            }
            if (this.MrO != null) {
                nh += g.a.a.b.b.a.f(4, this.MrO);
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.xKb) + g.a.a.b.b.a.bu(6, this.MrP);
            if (this.MrQ != null) {
                bu += g.a.a.a.nh(7, this.MrQ.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(8, this.MrR) + g.a.a.b.b.a.bu(9, this.MrS) + g.a.a.b.b.a.bu(10, this.MrT) + g.a.a.b.b.a.bu(11, this.MrU);
            if (this.MrV != null) {
                bu2 += g.a.a.a.nh(12, this.MrV.computeSize());
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(13, this.MrW) + g.a.a.b.b.a.bu(14, this.MrX) + g.a.a.b.b.a.bu(15, this.MrY) + g.a.a.b.b.a.bu(16, this.MrZ) + g.a.a.b.b.a.bu(17, this.LYt) + g.a.a.b.b.a.bu(18, this.Msa);
            if (this.xLk != null) {
                bu3 += g.a.a.b.b.a.f(19, this.xLk);
            }
            if (this.ThumbUrl != null) {
                bu3 += g.a.a.b.b.a.f(20, this.ThumbUrl);
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(21, this.LbA) + g.a.a.b.b.a.bu(22, this.Lbz);
            if (this.Msb != null) {
                bu4 += g.a.a.b.b.a.f(23, this.Msb);
            }
            if (this.Msc != null) {
                bu4 += g.a.a.b.b.a.f(24, this.Msc);
            }
            AppMethodBeat.o(32345);
            return bu4;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.MrQ == null) {
                b bVar3 = new b("Not all required fields were included: DataBuffer");
                AppMethodBeat.o(32345);
                throw bVar3;
            } else if (this.MrV == null) {
                b bVar4 = new b("Not all required fields were included: ThumbData");
                AppMethodBeat.o(32345);
                throw bVar4;
            } else {
                AppMethodBeat.o(32345);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cmp cmp = (cmp) objArr[1];
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
                        cmp.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(32345);
                    return 0;
                case 2:
                    cmp.MrM = aVar3.UbS.readString();
                    AppMethodBeat.o(32345);
                    return 0;
                case 3:
                    cmp.MrN = aVar3.UbS.readString();
                    AppMethodBeat.o(32345);
                    return 0;
                case 4:
                    cmp.MrO = aVar3.UbS.readString();
                    AppMethodBeat.o(32345);
                    return 0;
                case 5:
                    cmp.xKb = aVar3.UbS.zi();
                    AppMethodBeat.o(32345);
                    return 0;
                case 6:
                    cmp.MrP = aVar3.UbS.zi();
                    AppMethodBeat.o(32345);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t.populateBuilderWithField(aVar5, sKBuiltinBuffer_t, dop.getNextFieldNumber(aVar5))) {
                        }
                        cmp.MrQ = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(32345);
                    return 0;
                case 8:
                    cmp.MrR = aVar3.UbS.zi();
                    AppMethodBeat.o(32345);
                    return 0;
                case 9:
                    cmp.MrS = aVar3.UbS.zi();
                    AppMethodBeat.o(32345);
                    return 0;
                case 10:
                    cmp.MrT = aVar3.UbS.zi();
                    AppMethodBeat.o(32345);
                    return 0;
                case 11:
                    cmp.MrU = aVar3.UbS.zi();
                    AppMethodBeat.o(32345);
                    return 0;
                case 12:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t2 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = sKBuiltinBuffer_t2.populateBuilderWithField(aVar6, sKBuiltinBuffer_t2, dop.getNextFieldNumber(aVar6))) {
                        }
                        cmp.MrV = sKBuiltinBuffer_t2;
                    }
                    AppMethodBeat.o(32345);
                    return 0;
                case 13:
                    cmp.MrW = aVar3.UbS.zi();
                    AppMethodBeat.o(32345);
                    return 0;
                case 14:
                    cmp.MrX = aVar3.UbS.zi();
                    AppMethodBeat.o(32345);
                    return 0;
                case 15:
                    cmp.MrY = aVar3.UbS.zi();
                    AppMethodBeat.o(32345);
                    return 0;
                case 16:
                    cmp.MrZ = aVar3.UbS.zi();
                    AppMethodBeat.o(32345);
                    return 0;
                case 17:
                    cmp.LYt = aVar3.UbS.zi();
                    AppMethodBeat.o(32345);
                    return 0;
                case 18:
                    cmp.Msa = aVar3.UbS.zi();
                    AppMethodBeat.o(32345);
                    return 0;
                case 19:
                    cmp.xLk = aVar3.UbS.readString();
                    AppMethodBeat.o(32345);
                    return 0;
                case 20:
                    cmp.ThumbUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(32345);
                    return 0;
                case 21:
                    cmp.LbA = aVar3.UbS.zi();
                    AppMethodBeat.o(32345);
                    return 0;
                case 22:
                    cmp.Lbz = aVar3.UbS.zi();
                    AppMethodBeat.o(32345);
                    return 0;
                case 23:
                    cmp.Msb = aVar3.UbS.readString();
                    AppMethodBeat.o(32345);
                    return 0;
                case 24:
                    cmp.Msc = aVar3.UbS.readString();
                    AppMethodBeat.o(32345);
                    return 0;
                default:
                    AppMethodBeat.o(32345);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32345);
            return -1;
        }
    }
}
