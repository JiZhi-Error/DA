package com.tencent.mm.protocal.protobuf;

import android.support.constraint.ConstraintLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class eoc extends dop {
    public String KHq;
    public String KIz;
    public int KTf;
    public String LbJ;
    public int LbK;
    public int LbL;
    public int LbM;
    public String LbN;
    public int LrC;
    public int LsF;
    public int MVx;
    public int MXo;
    public String Mip;
    public String Mir;
    public int MrT;
    public int MrU;
    public SKBuiltinBuffer_t MrV;
    public int MrW;
    public int NlH;
    public int NlI;
    public int NlJ;
    public int NlP;
    public int NlQ;
    public SKBuiltinBuffer_t NlR;
    public String NlS;
    public int NlT;
    public String NlU;
    public String NlV;
    public int NlW;
    public String NlX;
    public String NlY;
    public String NlZ;
    public String Nma;
    public String Nmb;
    public String Nmc;
    public String Nmd;
    public String Nme;
    public String xNG;
    public String xNH;
    public int xub;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(127180);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.MrV == null) {
                b bVar = new b("Not all required fields were included: ThumbData");
                AppMethodBeat.o(127180);
                throw bVar;
            } else if (this.NlR == null) {
                b bVar2 = new b("Not all required fields were included: VideoData");
                AppMethodBeat.o(127180);
                throw bVar2;
            } else {
                if (this.BaseRequest != null) {
                    aVar.ni(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(aVar);
                }
                if (this.KIz != null) {
                    aVar.e(2, this.KIz);
                }
                if (this.xNH != null) {
                    aVar.e(3, this.xNH);
                }
                if (this.xNG != null) {
                    aVar.e(4, this.xNG);
                }
                aVar.aM(5, this.MrT);
                aVar.aM(6, this.MrU);
                if (this.MrV != null) {
                    aVar.ni(7, this.MrV.computeSize());
                    this.MrV.writeFields(aVar);
                }
                aVar.aM(8, this.NlP);
                aVar.aM(9, this.NlQ);
                if (this.NlR != null) {
                    aVar.ni(10, this.NlR.computeSize());
                    this.NlR.writeFields(aVar);
                }
                aVar.aM(11, this.MXo);
                aVar.aM(12, this.LrC);
                aVar.aM(13, this.MrW);
                aVar.aM(14, this.KTf);
                if (this.KHq != null) {
                    aVar.e(15, this.KHq);
                }
                if (this.NlS != null) {
                    aVar.e(16, this.NlS);
                }
                if (this.LbJ != null) {
                    aVar.e(17, this.LbJ);
                }
                aVar.aM(18, this.LbK);
                if (this.Mip != null) {
                    aVar.e(19, this.Mip);
                }
                aVar.aM(20, this.NlH);
                aVar.aM(21, this.NlI);
                aVar.aM(22, this.NlJ);
                if (this.Mir != null) {
                    aVar.e(23, this.Mir);
                }
                aVar.aM(24, this.NlT);
                aVar.aM(25, this.LsF);
                if (this.NlU != null) {
                    aVar.e(26, this.NlU);
                }
                if (this.NlV != null) {
                    aVar.e(27, this.NlV);
                }
                aVar.aM(28, this.NlW);
                if (this.NlX != null) {
                    aVar.e(29, this.NlX);
                }
                if (this.NlY != null) {
                    aVar.e(30, this.NlY);
                }
                if (this.NlZ != null) {
                    aVar.e(31, this.NlZ);
                }
                if (this.Nma != null) {
                    aVar.e(32, this.Nma);
                }
                if (this.Nmb != null) {
                    aVar.e(33, this.Nmb);
                }
                if (this.Nmc != null) {
                    aVar.e(34, this.Nmc);
                }
                if (this.Nmd != null) {
                    aVar.e(35, this.Nmd);
                }
                aVar.aM(36, this.MVx);
                if (this.Nme != null) {
                    aVar.e(37, this.Nme);
                }
                aVar.aM(38, this.LbL);
                aVar.aM(39, this.LbM);
                aVar.aM(40, this.xub);
                if (this.LbN != null) {
                    aVar.e(41, this.LbN);
                }
                AppMethodBeat.o(127180);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.KIz != null) {
                nh += g.a.a.b.b.a.f(2, this.KIz);
            }
            if (this.xNH != null) {
                nh += g.a.a.b.b.a.f(3, this.xNH);
            }
            if (this.xNG != null) {
                nh += g.a.a.b.b.a.f(4, this.xNG);
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.MrT) + g.a.a.b.b.a.bu(6, this.MrU);
            if (this.MrV != null) {
                bu += g.a.a.a.nh(7, this.MrV.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(8, this.NlP) + g.a.a.b.b.a.bu(9, this.NlQ);
            if (this.NlR != null) {
                bu2 += g.a.a.a.nh(10, this.NlR.computeSize());
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(11, this.MXo) + g.a.a.b.b.a.bu(12, this.LrC) + g.a.a.b.b.a.bu(13, this.MrW) + g.a.a.b.b.a.bu(14, this.KTf);
            if (this.KHq != null) {
                bu3 += g.a.a.b.b.a.f(15, this.KHq);
            }
            if (this.NlS != null) {
                bu3 += g.a.a.b.b.a.f(16, this.NlS);
            }
            if (this.LbJ != null) {
                bu3 += g.a.a.b.b.a.f(17, this.LbJ);
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(18, this.LbK);
            if (this.Mip != null) {
                bu4 += g.a.a.b.b.a.f(19, this.Mip);
            }
            int bu5 = bu4 + g.a.a.b.b.a.bu(20, this.NlH) + g.a.a.b.b.a.bu(21, this.NlI) + g.a.a.b.b.a.bu(22, this.NlJ);
            if (this.Mir != null) {
                bu5 += g.a.a.b.b.a.f(23, this.Mir);
            }
            int bu6 = bu5 + g.a.a.b.b.a.bu(24, this.NlT) + g.a.a.b.b.a.bu(25, this.LsF);
            if (this.NlU != null) {
                bu6 += g.a.a.b.b.a.f(26, this.NlU);
            }
            if (this.NlV != null) {
                bu6 += g.a.a.b.b.a.f(27, this.NlV);
            }
            int bu7 = bu6 + g.a.a.b.b.a.bu(28, this.NlW);
            if (this.NlX != null) {
                bu7 += g.a.a.b.b.a.f(29, this.NlX);
            }
            if (this.NlY != null) {
                bu7 += g.a.a.b.b.a.f(30, this.NlY);
            }
            if (this.NlZ != null) {
                bu7 += g.a.a.b.b.a.f(31, this.NlZ);
            }
            if (this.Nma != null) {
                bu7 += g.a.a.b.b.a.f(32, this.Nma);
            }
            if (this.Nmb != null) {
                bu7 += g.a.a.b.b.a.f(33, this.Nmb);
            }
            if (this.Nmc != null) {
                bu7 += g.a.a.b.b.a.f(34, this.Nmc);
            }
            if (this.Nmd != null) {
                bu7 += g.a.a.b.b.a.f(35, this.Nmd);
            }
            int bu8 = bu7 + g.a.a.b.b.a.bu(36, this.MVx);
            if (this.Nme != null) {
                bu8 += g.a.a.b.b.a.f(37, this.Nme);
            }
            int bu9 = bu8 + g.a.a.b.b.a.bu(38, this.LbL) + g.a.a.b.b.a.bu(39, this.LbM) + g.a.a.b.b.a.bu(40, this.xub);
            if (this.LbN != null) {
                bu9 += g.a.a.b.b.a.f(41, this.LbN);
            }
            AppMethodBeat.o(127180);
            return bu9;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.MrV == null) {
                b bVar3 = new b("Not all required fields were included: ThumbData");
                AppMethodBeat.o(127180);
                throw bVar3;
            } else if (this.NlR == null) {
                b bVar4 = new b("Not all required fields were included: VideoData");
                AppMethodBeat.o(127180);
                throw bVar4;
            } else {
                AppMethodBeat.o(127180);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eoc eoc = (eoc) objArr[1];
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
                        eoc.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(127180);
                    return 0;
                case 2:
                    eoc.KIz = aVar3.UbS.readString();
                    AppMethodBeat.o(127180);
                    return 0;
                case 3:
                    eoc.xNH = aVar3.UbS.readString();
                    AppMethodBeat.o(127180);
                    return 0;
                case 4:
                    eoc.xNG = aVar3.UbS.readString();
                    AppMethodBeat.o(127180);
                    return 0;
                case 5:
                    eoc.MrT = aVar3.UbS.zi();
                    AppMethodBeat.o(127180);
                    return 0;
                case 6:
                    eoc.MrU = aVar3.UbS.zi();
                    AppMethodBeat.o(127180);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t.populateBuilderWithField(aVar5, sKBuiltinBuffer_t, dop.getNextFieldNumber(aVar5))) {
                        }
                        eoc.MrV = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(127180);
                    return 0;
                case 8:
                    eoc.NlP = aVar3.UbS.zi();
                    AppMethodBeat.o(127180);
                    return 0;
                case 9:
                    eoc.NlQ = aVar3.UbS.zi();
                    AppMethodBeat.o(127180);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t2 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = sKBuiltinBuffer_t2.populateBuilderWithField(aVar6, sKBuiltinBuffer_t2, dop.getNextFieldNumber(aVar6))) {
                        }
                        eoc.NlR = sKBuiltinBuffer_t2;
                    }
                    AppMethodBeat.o(127180);
                    return 0;
                case 11:
                    eoc.MXo = aVar3.UbS.zi();
                    AppMethodBeat.o(127180);
                    return 0;
                case 12:
                    eoc.LrC = aVar3.UbS.zi();
                    AppMethodBeat.o(127180);
                    return 0;
                case 13:
                    eoc.MrW = aVar3.UbS.zi();
                    AppMethodBeat.o(127180);
                    return 0;
                case 14:
                    eoc.KTf = aVar3.UbS.zi();
                    AppMethodBeat.o(127180);
                    return 0;
                case 15:
                    eoc.KHq = aVar3.UbS.readString();
                    AppMethodBeat.o(127180);
                    return 0;
                case 16:
                    eoc.NlS = aVar3.UbS.readString();
                    AppMethodBeat.o(127180);
                    return 0;
                case 17:
                    eoc.LbJ = aVar3.UbS.readString();
                    AppMethodBeat.o(127180);
                    return 0;
                case 18:
                    eoc.LbK = aVar3.UbS.zi();
                    AppMethodBeat.o(127180);
                    return 0;
                case 19:
                    eoc.Mip = aVar3.UbS.readString();
                    AppMethodBeat.o(127180);
                    return 0;
                case 20:
                    eoc.NlH = aVar3.UbS.zi();
                    AppMethodBeat.o(127180);
                    return 0;
                case 21:
                    eoc.NlI = aVar3.UbS.zi();
                    AppMethodBeat.o(127180);
                    return 0;
                case 22:
                    eoc.NlJ = aVar3.UbS.zi();
                    AppMethodBeat.o(127180);
                    return 0;
                case 23:
                    eoc.Mir = aVar3.UbS.readString();
                    AppMethodBeat.o(127180);
                    return 0;
                case 24:
                    eoc.NlT = aVar3.UbS.zi();
                    AppMethodBeat.o(127180);
                    return 0;
                case 25:
                    eoc.LsF = aVar3.UbS.zi();
                    AppMethodBeat.o(127180);
                    return 0;
                case 26:
                    eoc.NlU = aVar3.UbS.readString();
                    AppMethodBeat.o(127180);
                    return 0;
                case 27:
                    eoc.NlV = aVar3.UbS.readString();
                    AppMethodBeat.o(127180);
                    return 0;
                case 28:
                    eoc.NlW = aVar3.UbS.zi();
                    AppMethodBeat.o(127180);
                    return 0;
                case 29:
                    eoc.NlX = aVar3.UbS.readString();
                    AppMethodBeat.o(127180);
                    return 0;
                case 30:
                    eoc.NlY = aVar3.UbS.readString();
                    AppMethodBeat.o(127180);
                    return 0;
                case 31:
                    eoc.NlZ = aVar3.UbS.readString();
                    AppMethodBeat.o(127180);
                    return 0;
                case 32:
                    eoc.Nma = aVar3.UbS.readString();
                    AppMethodBeat.o(127180);
                    return 0;
                case 33:
                    eoc.Nmb = aVar3.UbS.readString();
                    AppMethodBeat.o(127180);
                    return 0;
                case 34:
                    eoc.Nmc = aVar3.UbS.readString();
                    AppMethodBeat.o(127180);
                    return 0;
                case 35:
                    eoc.Nmd = aVar3.UbS.readString();
                    AppMethodBeat.o(127180);
                    return 0;
                case 36:
                    eoc.MVx = aVar3.UbS.zi();
                    AppMethodBeat.o(127180);
                    return 0;
                case 37:
                    eoc.Nme = aVar3.UbS.readString();
                    AppMethodBeat.o(127180);
                    return 0;
                case 38:
                    eoc.LbL = aVar3.UbS.zi();
                    AppMethodBeat.o(127180);
                    return 0;
                case 39:
                    eoc.LbM = aVar3.UbS.zi();
                    AppMethodBeat.o(127180);
                    return 0;
                case 40:
                    eoc.xub = aVar3.UbS.zi();
                    AppMethodBeat.o(127180);
                    return 0;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_CREATOR:
                    eoc.LbN = aVar3.UbS.readString();
                    AppMethodBeat.o(127180);
                    return 0;
                default:
                    AppMethodBeat.o(127180);
                    return -1;
            }
        } else {
            AppMethodBeat.o(127180);
            return -1;
        }
    }
}
