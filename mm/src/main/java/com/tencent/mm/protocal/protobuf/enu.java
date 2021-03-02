package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class enu extends dop {
    public int BsF;
    public int BsG;
    public int BsH;
    public SKBuiltinBuffer_t BsI;
    public String KEq;
    public String KEr;
    public String KEs;
    public dqi KHl;
    public dqi KHm;
    public String KHq;
    public int LYt;
    public String LbJ;
    public int LbK;
    public int LbL;
    public int LbM;
    public String LbN;
    public int Llx;
    public int LsF;
    public String MDZ;
    public int MVx;
    public String Md5;
    public String Mir;
    public int Mwb;
    public int NaY;
    public dqi NlB;
    public String NlC;
    public String NlD;
    public int NlE;
    public int NlF;
    public String NlG;
    public int NlH;
    public int NlI;
    public int NlJ;
    public String jfi;
    public String jfl;
    public int xKb;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152719);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.NlB == null) {
                b bVar = new b("Not all required fields were included: ClientImgId");
                AppMethodBeat.o(152719);
                throw bVar;
            } else if (this.KHl == null) {
                b bVar2 = new b("Not all required fields were included: FromUserName");
                AppMethodBeat.o(152719);
                throw bVar2;
            } else if (this.KHm == null) {
                b bVar3 = new b("Not all required fields were included: ToUserName");
                AppMethodBeat.o(152719);
                throw bVar3;
            } else if (this.BsI == null) {
                b bVar4 = new b("Not all required fields were included: Data");
                AppMethodBeat.o(152719);
                throw bVar4;
            } else {
                if (this.BaseRequest != null) {
                    aVar.ni(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(aVar);
                }
                if (this.NlB != null) {
                    aVar.ni(2, this.NlB.computeSize());
                    this.NlB.writeFields(aVar);
                }
                if (this.KHl != null) {
                    aVar.ni(3, this.KHl.computeSize());
                    this.KHl.writeFields(aVar);
                }
                if (this.KHm != null) {
                    aVar.ni(4, this.KHm.computeSize());
                    this.KHm.writeFields(aVar);
                }
                aVar.aM(5, this.BsF);
                aVar.aM(6, this.BsG);
                aVar.aM(7, this.BsH);
                if (this.BsI != null) {
                    aVar.ni(8, this.BsI.computeSize());
                    this.BsI.writeFields(aVar);
                }
                aVar.aM(9, this.xKb);
                if (this.KHq != null) {
                    aVar.e(10, this.KHq);
                }
                aVar.aM(11, this.LYt);
                aVar.aM(12, this.Llx);
                aVar.aM(13, this.NaY);
                if (this.jfl != null) {
                    aVar.e(14, this.jfl);
                }
                if (this.NlC != null) {
                    aVar.e(15, this.NlC);
                }
                if (this.NlD != null) {
                    aVar.e(16, this.NlD);
                }
                if (this.LbJ != null) {
                    aVar.e(17, this.LbJ);
                }
                aVar.aM(18, this.LbK);
                aVar.aM(19, this.NlE);
                aVar.aM(20, this.NlF);
                if (this.NlG != null) {
                    aVar.e(21, this.NlG);
                }
                aVar.aM(22, this.NlH);
                aVar.aM(23, this.NlI);
                aVar.aM(24, this.NlJ);
                if (this.Mir != null) {
                    aVar.e(25, this.Mir);
                }
                aVar.aM(26, this.LsF);
                if (this.Md5 != null) {
                    aVar.e(27, this.Md5);
                }
                aVar.aM(28, this.LbL);
                aVar.aM(29, this.LbM);
                aVar.aM(30, this.MVx);
                if (this.jfi != null) {
                    aVar.e(31, this.jfi);
                }
                if (this.KEs != null) {
                    aVar.e(32, this.KEs);
                }
                if (this.KEr != null) {
                    aVar.e(33, this.KEr);
                }
                if (this.KEq != null) {
                    aVar.e(34, this.KEq);
                }
                if (this.LbN != null) {
                    aVar.e(35, this.LbN);
                }
                aVar.aM(36, this.Mwb);
                if (this.MDZ != null) {
                    aVar.e(37, this.MDZ);
                }
                AppMethodBeat.o(152719);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.NlB != null) {
                nh += g.a.a.a.nh(2, this.NlB.computeSize());
            }
            if (this.KHl != null) {
                nh += g.a.a.a.nh(3, this.KHl.computeSize());
            }
            if (this.KHm != null) {
                nh += g.a.a.a.nh(4, this.KHm.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.BsF) + g.a.a.b.b.a.bu(6, this.BsG) + g.a.a.b.b.a.bu(7, this.BsH);
            if (this.BsI != null) {
                bu += g.a.a.a.nh(8, this.BsI.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(9, this.xKb);
            if (this.KHq != null) {
                bu2 += g.a.a.b.b.a.f(10, this.KHq);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(11, this.LYt) + g.a.a.b.b.a.bu(12, this.Llx) + g.a.a.b.b.a.bu(13, this.NaY);
            if (this.jfl != null) {
                bu3 += g.a.a.b.b.a.f(14, this.jfl);
            }
            if (this.NlC != null) {
                bu3 += g.a.a.b.b.a.f(15, this.NlC);
            }
            if (this.NlD != null) {
                bu3 += g.a.a.b.b.a.f(16, this.NlD);
            }
            if (this.LbJ != null) {
                bu3 += g.a.a.b.b.a.f(17, this.LbJ);
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(18, this.LbK) + g.a.a.b.b.a.bu(19, this.NlE) + g.a.a.b.b.a.bu(20, this.NlF);
            if (this.NlG != null) {
                bu4 += g.a.a.b.b.a.f(21, this.NlG);
            }
            int bu5 = bu4 + g.a.a.b.b.a.bu(22, this.NlH) + g.a.a.b.b.a.bu(23, this.NlI) + g.a.a.b.b.a.bu(24, this.NlJ);
            if (this.Mir != null) {
                bu5 += g.a.a.b.b.a.f(25, this.Mir);
            }
            int bu6 = bu5 + g.a.a.b.b.a.bu(26, this.LsF);
            if (this.Md5 != null) {
                bu6 += g.a.a.b.b.a.f(27, this.Md5);
            }
            int bu7 = bu6 + g.a.a.b.b.a.bu(28, this.LbL) + g.a.a.b.b.a.bu(29, this.LbM) + g.a.a.b.b.a.bu(30, this.MVx);
            if (this.jfi != null) {
                bu7 += g.a.a.b.b.a.f(31, this.jfi);
            }
            if (this.KEs != null) {
                bu7 += g.a.a.b.b.a.f(32, this.KEs);
            }
            if (this.KEr != null) {
                bu7 += g.a.a.b.b.a.f(33, this.KEr);
            }
            if (this.KEq != null) {
                bu7 += g.a.a.b.b.a.f(34, this.KEq);
            }
            if (this.LbN != null) {
                bu7 += g.a.a.b.b.a.f(35, this.LbN);
            }
            int bu8 = bu7 + g.a.a.b.b.a.bu(36, this.Mwb);
            if (this.MDZ != null) {
                bu8 += g.a.a.b.b.a.f(37, this.MDZ);
            }
            AppMethodBeat.o(152719);
            return bu8;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.NlB == null) {
                b bVar5 = new b("Not all required fields were included: ClientImgId");
                AppMethodBeat.o(152719);
                throw bVar5;
            } else if (this.KHl == null) {
                b bVar6 = new b("Not all required fields were included: FromUserName");
                AppMethodBeat.o(152719);
                throw bVar6;
            } else if (this.KHm == null) {
                b bVar7 = new b("Not all required fields were included: ToUserName");
                AppMethodBeat.o(152719);
                throw bVar7;
            } else if (this.BsI == null) {
                b bVar8 = new b("Not all required fields were included: Data");
                AppMethodBeat.o(152719);
                throw bVar8;
            } else {
                AppMethodBeat.o(152719);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            enu enu = (enu) objArr[1];
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
                        enu.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(152719);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dqi.populateBuilderWithField(aVar5, dqi, dop.getNextFieldNumber(aVar5))) {
                        }
                        enu.NlB = dqi;
                    }
                    AppMethodBeat.o(152719);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dqi dqi2 = new dqi();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dqi2.populateBuilderWithField(aVar6, dqi2, dop.getNextFieldNumber(aVar6))) {
                        }
                        enu.KHl = dqi2;
                    }
                    AppMethodBeat.o(152719);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        dqi dqi3 = new dqi();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = dqi3.populateBuilderWithField(aVar7, dqi3, dop.getNextFieldNumber(aVar7))) {
                        }
                        enu.KHm = dqi3;
                    }
                    AppMethodBeat.o(152719);
                    return 0;
                case 5:
                    enu.BsF = aVar3.UbS.zi();
                    AppMethodBeat.o(152719);
                    return 0;
                case 6:
                    enu.BsG = aVar3.UbS.zi();
                    AppMethodBeat.o(152719);
                    return 0;
                case 7:
                    enu.BsH = aVar3.UbS.zi();
                    AppMethodBeat.o(152719);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = sKBuiltinBuffer_t.populateBuilderWithField(aVar8, sKBuiltinBuffer_t, dop.getNextFieldNumber(aVar8))) {
                        }
                        enu.BsI = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(152719);
                    return 0;
                case 9:
                    enu.xKb = aVar3.UbS.zi();
                    AppMethodBeat.o(152719);
                    return 0;
                case 10:
                    enu.KHq = aVar3.UbS.readString();
                    AppMethodBeat.o(152719);
                    return 0;
                case 11:
                    enu.LYt = aVar3.UbS.zi();
                    AppMethodBeat.o(152719);
                    return 0;
                case 12:
                    enu.Llx = aVar3.UbS.zi();
                    AppMethodBeat.o(152719);
                    return 0;
                case 13:
                    enu.NaY = aVar3.UbS.zi();
                    AppMethodBeat.o(152719);
                    return 0;
                case 14:
                    enu.jfl = aVar3.UbS.readString();
                    AppMethodBeat.o(152719);
                    return 0;
                case 15:
                    enu.NlC = aVar3.UbS.readString();
                    AppMethodBeat.o(152719);
                    return 0;
                case 16:
                    enu.NlD = aVar3.UbS.readString();
                    AppMethodBeat.o(152719);
                    return 0;
                case 17:
                    enu.LbJ = aVar3.UbS.readString();
                    AppMethodBeat.o(152719);
                    return 0;
                case 18:
                    enu.LbK = aVar3.UbS.zi();
                    AppMethodBeat.o(152719);
                    return 0;
                case 19:
                    enu.NlE = aVar3.UbS.zi();
                    AppMethodBeat.o(152719);
                    return 0;
                case 20:
                    enu.NlF = aVar3.UbS.zi();
                    AppMethodBeat.o(152719);
                    return 0;
                case 21:
                    enu.NlG = aVar3.UbS.readString();
                    AppMethodBeat.o(152719);
                    return 0;
                case 22:
                    enu.NlH = aVar3.UbS.zi();
                    AppMethodBeat.o(152719);
                    return 0;
                case 23:
                    enu.NlI = aVar3.UbS.zi();
                    AppMethodBeat.o(152719);
                    return 0;
                case 24:
                    enu.NlJ = aVar3.UbS.zi();
                    AppMethodBeat.o(152719);
                    return 0;
                case 25:
                    enu.Mir = aVar3.UbS.readString();
                    AppMethodBeat.o(152719);
                    return 0;
                case 26:
                    enu.LsF = aVar3.UbS.zi();
                    AppMethodBeat.o(152719);
                    return 0;
                case 27:
                    enu.Md5 = aVar3.UbS.readString();
                    AppMethodBeat.o(152719);
                    return 0;
                case 28:
                    enu.LbL = aVar3.UbS.zi();
                    AppMethodBeat.o(152719);
                    return 0;
                case 29:
                    enu.LbM = aVar3.UbS.zi();
                    AppMethodBeat.o(152719);
                    return 0;
                case 30:
                    enu.MVx = aVar3.UbS.zi();
                    AppMethodBeat.o(152719);
                    return 0;
                case 31:
                    enu.jfi = aVar3.UbS.readString();
                    AppMethodBeat.o(152719);
                    return 0;
                case 32:
                    enu.KEs = aVar3.UbS.readString();
                    AppMethodBeat.o(152719);
                    return 0;
                case 33:
                    enu.KEr = aVar3.UbS.readString();
                    AppMethodBeat.o(152719);
                    return 0;
                case 34:
                    enu.KEq = aVar3.UbS.readString();
                    AppMethodBeat.o(152719);
                    return 0;
                case 35:
                    enu.LbN = aVar3.UbS.readString();
                    AppMethodBeat.o(152719);
                    return 0;
                case 36:
                    enu.Mwb = aVar3.UbS.zi();
                    AppMethodBeat.o(152719);
                    return 0;
                case 37:
                    enu.MDZ = aVar3.UbS.readString();
                    AppMethodBeat.o(152719);
                    return 0;
                default:
                    AppMethodBeat.o(152719);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152719);
            return -1;
        }
    }
}
