package com.tencent.mm.protocal.protobuf;

import android.support.constraint.ConstraintLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.bv;
import com.tencent.mm.plugin.appbrand.jsapi.h.h;
import com.tencent.mm.plugin.appbrand.jsapi.pay.n;
import com.tencent.mm.plugin.appbrand.jsapi.share.d;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.thumbplayer.core.common.TPCodecParamers;
import g.a.a.b;
import java.util.LinkedList;

public final class cpl extends a {
    public int DeleteFlag;
    public int ExtFlag;
    public String KHk;
    public SKBuiltinBuffer_t KHp;
    public String LRy;
    public xg LUi;
    public String LiD;
    public String LiF;
    public String Lir;
    public String Lis;
    public int LoG;
    public int LoH;
    public int LoM;
    public int LoN;
    public LinkedList<dpt> LoO = new LinkedList<>();
    public int LoQ;
    public int LoR;
    public dqi LpA;
    public dqi LpB;
    public dqi Lqk;
    public int Lql;
    public String Lqm;
    public String MbK;
    public dqi Mjj;
    public int MmK;
    public String MmL;
    public String MmM;
    public String MmN;
    public int MmO;
    public ebj MmQ;
    public aeq MmR;
    public dqi MuI;
    public dqi MuJ;
    public dqi MuK;
    public String MvA;
    public int MvB;
    public int Mvd;
    public dqi Mvh;
    public int Mvi;
    public int Mvj;
    public String Mvk;
    public String Mvl;
    public String Mvm;
    public String Mvn;
    public String Mvo;
    public String Mvp;
    public String Mvq;
    public String Mvr;
    public dq Mvs;
    public int Mvt;
    public int Mvu;
    public int Mvv;
    public String Mvw;
    public dbl Mvx;
    public int Mvy;
    public int Mvz;
    public String fuW;
    public long fvd;
    public int kdY;
    public String kdZ;
    public String kea;
    public String keb;
    public int kec;
    public String ked;
    public int kee;
    public int kef;
    public String keg;
    public String keh;
    public String kei;
    public String xNU;
    public int xub;

    public cpl() {
        AppMethodBeat.i(43106);
        AppMethodBeat.o(43106);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(43107);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Lqk == null) {
                b bVar = new b("Not all required fields were included: UserName");
                AppMethodBeat.o(43107);
                throw bVar;
            } else if (this.Mjj == null) {
                b bVar2 = new b("Not all required fields were included: NickName");
                AppMethodBeat.o(43107);
                throw bVar2;
            } else if (this.LpA == null) {
                b bVar3 = new b("Not all required fields were included: PYInitial");
                AppMethodBeat.o(43107);
                throw bVar3;
            } else if (this.LpB == null) {
                b bVar4 = new b("Not all required fields were included: QuanPin");
                AppMethodBeat.o(43107);
                throw bVar4;
            } else if (this.KHp == null) {
                b bVar5 = new b("Not all required fields were included: ImgBuf");
                AppMethodBeat.o(43107);
                throw bVar5;
            } else {
                if (this.Lqk != null) {
                    aVar.ni(1, this.Lqk.computeSize());
                    this.Lqk.writeFields(aVar);
                }
                if (this.Mjj != null) {
                    aVar.ni(2, this.Mjj.computeSize());
                    this.Mjj.writeFields(aVar);
                }
                if (this.LpA != null) {
                    aVar.ni(3, this.LpA.computeSize());
                    this.LpA.writeFields(aVar);
                }
                if (this.LpB != null) {
                    aVar.ni(4, this.LpB.computeSize());
                    this.LpB.writeFields(aVar);
                }
                aVar.aM(5, this.kdY);
                if (this.KHp != null) {
                    aVar.ni(6, this.KHp.computeSize());
                    this.KHp.writeFields(aVar);
                }
                aVar.aM(7, this.LoG);
                aVar.aM(8, this.LoH);
                aVar.aM(9, this.Mvd);
                if (this.MuI != null) {
                    aVar.ni(10, this.MuI.computeSize());
                    this.MuI.writeFields(aVar);
                }
                if (this.MuJ != null) {
                    aVar.ni(11, this.MuJ.computeSize());
                    this.MuJ.writeFields(aVar);
                }
                if (this.MuK != null) {
                    aVar.ni(12, this.MuK.computeSize());
                    this.MuK.writeFields(aVar);
                }
                aVar.aM(13, this.LoM);
                aVar.aM(14, this.LoN);
                aVar.e(15, 8, this.LoO);
                if (this.Mvh != null) {
                    aVar.ni(16, this.Mvh.computeSize());
                    this.Mvh.writeFields(aVar);
                }
                aVar.aM(17, this.LoQ);
                aVar.aM(18, this.LoR);
                if (this.kdZ != null) {
                    aVar.e(19, this.kdZ);
                }
                if (this.kea != null) {
                    aVar.e(20, this.kea);
                }
                if (this.keb != null) {
                    aVar.e(21, this.keb);
                }
                aVar.aM(22, this.kec);
                aVar.aM(23, this.Mvi);
                aVar.aM(24, this.MmK);
                if (this.MmL != null) {
                    aVar.e(25, this.MmL);
                }
                aVar.aM(26, this.Mvj);
                aVar.aM(27, this.xub);
                if (this.MmM != null) {
                    aVar.e(28, this.MmM);
                }
                if (this.MbK != null) {
                    aVar.e(29, this.MbK);
                }
                if (this.ked != null) {
                    aVar.e(30, this.ked);
                }
                if (this.Mvk != null) {
                    aVar.e(31, this.Mvk);
                }
                if (this.MmN != null) {
                    aVar.e(32, this.MmN);
                }
                aVar.aM(33, this.MmO);
                aVar.aM(34, this.kef);
                aVar.aM(35, this.kee);
                if (this.keg != null) {
                    aVar.e(36, this.keg);
                }
                if (this.MmQ != null) {
                    aVar.ni(37, this.MmQ.computeSize());
                    this.MmQ.writeFields(aVar);
                }
                if (this.keh != null) {
                    aVar.e(38, this.keh);
                }
                if (this.Lir != null) {
                    aVar.e(39, this.Lir);
                }
                if (this.Lis != null) {
                    aVar.e(40, this.Lis);
                }
                if (this.kei != null) {
                    aVar.e(41, this.kei);
                }
                if (this.MmR != null) {
                    aVar.ni(42, this.MmR.computeSize());
                    this.MmR.writeFields(aVar);
                }
                if (this.Mvl != null) {
                    aVar.e(43, this.Mvl);
                }
                if (this.Mvm != null) {
                    aVar.e(44, this.Mvm);
                }
                if (this.Mvn != null) {
                    aVar.e(45, this.Mvn);
                }
                if (this.Mvo != null) {
                    aVar.e(46, this.Mvo);
                }
                if (this.Mvp != null) {
                    aVar.e(47, this.Mvp);
                }
                if (this.Mvq != null) {
                    aVar.e(48, this.Mvq);
                }
                if (this.Mvr != null) {
                    aVar.e(49, this.Mvr);
                }
                if (this.Mvs != null) {
                    aVar.ni(50, this.Mvs.computeSize());
                    this.Mvs.writeFields(aVar);
                }
                aVar.aM(53, this.Mvt);
                if (this.xNU != null) {
                    aVar.e(54, this.xNU);
                }
                aVar.aM(55, this.Mvu);
                aVar.aM(56, this.Mvv);
                if (this.LUi != null) {
                    aVar.ni(57, this.LUi.computeSize());
                    this.LUi.writeFields(aVar);
                }
                aVar.aM(58, this.DeleteFlag);
                if (this.KHk != null) {
                    aVar.e(59, this.KHk);
                }
                if (this.Mvw != null) {
                    aVar.e(60, this.Mvw);
                }
                if (this.Lqm != null) {
                    aVar.e(61, this.Lqm);
                }
                if (this.Mvx != null) {
                    aVar.ni(62, this.Mvx.computeSize());
                    this.Mvx.writeFields(aVar);
                }
                if (this.fuW != null) {
                    aVar.e(63, this.fuW);
                }
                aVar.aM(64, this.Mvy);
                aVar.aM(65, this.Lql);
                aVar.aM(66, this.Mvz);
                aVar.aM(67, this.ExtFlag);
                if (this.MvA != null) {
                    aVar.e(68, this.MvA);
                }
                aVar.bb(70, this.fvd);
                if (this.LRy != null) {
                    aVar.e(71, this.LRy);
                }
                if (this.LiD != null) {
                    aVar.e(77, this.LiD);
                }
                if (this.LiF != null) {
                    aVar.e(79, this.LiF);
                }
                aVar.aM(80, this.MvB);
                AppMethodBeat.o(43107);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.Lqk != null ? g.a.a.a.nh(1, this.Lqk.computeSize()) + 0 : 0;
            if (this.Mjj != null) {
                nh += g.a.a.a.nh(2, this.Mjj.computeSize());
            }
            if (this.LpA != null) {
                nh += g.a.a.a.nh(3, this.LpA.computeSize());
            }
            if (this.LpB != null) {
                nh += g.a.a.a.nh(4, this.LpB.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.kdY);
            if (this.KHp != null) {
                bu += g.a.a.a.nh(6, this.KHp.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(7, this.LoG) + g.a.a.b.b.a.bu(8, this.LoH) + g.a.a.b.b.a.bu(9, this.Mvd);
            if (this.MuI != null) {
                bu2 += g.a.a.a.nh(10, this.MuI.computeSize());
            }
            if (this.MuJ != null) {
                bu2 += g.a.a.a.nh(11, this.MuJ.computeSize());
            }
            if (this.MuK != null) {
                bu2 += g.a.a.a.nh(12, this.MuK.computeSize());
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(13, this.LoM) + g.a.a.b.b.a.bu(14, this.LoN) + g.a.a.a.c(15, 8, this.LoO);
            if (this.Mvh != null) {
                bu3 += g.a.a.a.nh(16, this.Mvh.computeSize());
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(17, this.LoQ) + g.a.a.b.b.a.bu(18, this.LoR);
            if (this.kdZ != null) {
                bu4 += g.a.a.b.b.a.f(19, this.kdZ);
            }
            if (this.kea != null) {
                bu4 += g.a.a.b.b.a.f(20, this.kea);
            }
            if (this.keb != null) {
                bu4 += g.a.a.b.b.a.f(21, this.keb);
            }
            int bu5 = bu4 + g.a.a.b.b.a.bu(22, this.kec) + g.a.a.b.b.a.bu(23, this.Mvi) + g.a.a.b.b.a.bu(24, this.MmK);
            if (this.MmL != null) {
                bu5 += g.a.a.b.b.a.f(25, this.MmL);
            }
            int bu6 = bu5 + g.a.a.b.b.a.bu(26, this.Mvj) + g.a.a.b.b.a.bu(27, this.xub);
            if (this.MmM != null) {
                bu6 += g.a.a.b.b.a.f(28, this.MmM);
            }
            if (this.MbK != null) {
                bu6 += g.a.a.b.b.a.f(29, this.MbK);
            }
            if (this.ked != null) {
                bu6 += g.a.a.b.b.a.f(30, this.ked);
            }
            if (this.Mvk != null) {
                bu6 += g.a.a.b.b.a.f(31, this.Mvk);
            }
            if (this.MmN != null) {
                bu6 += g.a.a.b.b.a.f(32, this.MmN);
            }
            int bu7 = bu6 + g.a.a.b.b.a.bu(33, this.MmO) + g.a.a.b.b.a.bu(34, this.kef) + g.a.a.b.b.a.bu(35, this.kee);
            if (this.keg != null) {
                bu7 += g.a.a.b.b.a.f(36, this.keg);
            }
            if (this.MmQ != null) {
                bu7 += g.a.a.a.nh(37, this.MmQ.computeSize());
            }
            if (this.keh != null) {
                bu7 += g.a.a.b.b.a.f(38, this.keh);
            }
            if (this.Lir != null) {
                bu7 += g.a.a.b.b.a.f(39, this.Lir);
            }
            if (this.Lis != null) {
                bu7 += g.a.a.b.b.a.f(40, this.Lis);
            }
            if (this.kei != null) {
                bu7 += g.a.a.b.b.a.f(41, this.kei);
            }
            if (this.MmR != null) {
                bu7 += g.a.a.a.nh(42, this.MmR.computeSize());
            }
            if (this.Mvl != null) {
                bu7 += g.a.a.b.b.a.f(43, this.Mvl);
            }
            if (this.Mvm != null) {
                bu7 += g.a.a.b.b.a.f(44, this.Mvm);
            }
            if (this.Mvn != null) {
                bu7 += g.a.a.b.b.a.f(45, this.Mvn);
            }
            if (this.Mvo != null) {
                bu7 += g.a.a.b.b.a.f(46, this.Mvo);
            }
            if (this.Mvp != null) {
                bu7 += g.a.a.b.b.a.f(47, this.Mvp);
            }
            if (this.Mvq != null) {
                bu7 += g.a.a.b.b.a.f(48, this.Mvq);
            }
            if (this.Mvr != null) {
                bu7 += g.a.a.b.b.a.f(49, this.Mvr);
            }
            if (this.Mvs != null) {
                bu7 += g.a.a.a.nh(50, this.Mvs.computeSize());
            }
            int bu8 = bu7 + g.a.a.b.b.a.bu(53, this.Mvt);
            if (this.xNU != null) {
                bu8 += g.a.a.b.b.a.f(54, this.xNU);
            }
            int bu9 = bu8 + g.a.a.b.b.a.bu(55, this.Mvu) + g.a.a.b.b.a.bu(56, this.Mvv);
            if (this.LUi != null) {
                bu9 += g.a.a.a.nh(57, this.LUi.computeSize());
            }
            int bu10 = bu9 + g.a.a.b.b.a.bu(58, this.DeleteFlag);
            if (this.KHk != null) {
                bu10 += g.a.a.b.b.a.f(59, this.KHk);
            }
            if (this.Mvw != null) {
                bu10 += g.a.a.b.b.a.f(60, this.Mvw);
            }
            if (this.Lqm != null) {
                bu10 += g.a.a.b.b.a.f(61, this.Lqm);
            }
            if (this.Mvx != null) {
                bu10 += g.a.a.a.nh(62, this.Mvx.computeSize());
            }
            if (this.fuW != null) {
                bu10 += g.a.a.b.b.a.f(63, this.fuW);
            }
            int bu11 = bu10 + g.a.a.b.b.a.bu(64, this.Mvy) + g.a.a.b.b.a.bu(65, this.Lql) + g.a.a.b.b.a.bu(66, this.Mvz) + g.a.a.b.b.a.bu(67, this.ExtFlag);
            if (this.MvA != null) {
                bu11 += g.a.a.b.b.a.f(68, this.MvA);
            }
            int r = bu11 + g.a.a.b.b.a.r(70, this.fvd);
            if (this.LRy != null) {
                r += g.a.a.b.b.a.f(71, this.LRy);
            }
            if (this.LiD != null) {
                r += g.a.a.b.b.a.f(77, this.LiD);
            }
            if (this.LiF != null) {
                r += g.a.a.b.b.a.f(79, this.LiF);
            }
            int bu12 = r + g.a.a.b.b.a.bu(80, this.MvB);
            AppMethodBeat.o(43107);
            return bu12;
        } else if (i2 == 2) {
            this.LoO.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Lqk == null) {
                b bVar6 = new b("Not all required fields were included: UserName");
                AppMethodBeat.o(43107);
                throw bVar6;
            } else if (this.Mjj == null) {
                b bVar7 = new b("Not all required fields were included: NickName");
                AppMethodBeat.o(43107);
                throw bVar7;
            } else if (this.LpA == null) {
                b bVar8 = new b("Not all required fields were included: PYInitial");
                AppMethodBeat.o(43107);
                throw bVar8;
            } else if (this.LpB == null) {
                b bVar9 = new b("Not all required fields were included: QuanPin");
                AppMethodBeat.o(43107);
                throw bVar9;
            } else if (this.KHp == null) {
                b bVar10 = new b("Not all required fields were included: ImgBuf");
                AppMethodBeat.o(43107);
                throw bVar10;
            } else {
                AppMethodBeat.o(43107);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cpl cpl = (cpl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dqi.populateBuilderWithField(aVar4, dqi, a.getNextFieldNumber(aVar4))) {
                        }
                        cpl.Lqk = dqi;
                    }
                    AppMethodBeat.o(43107);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dqi dqi2 = new dqi();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dqi2.populateBuilderWithField(aVar5, dqi2, a.getNextFieldNumber(aVar5))) {
                        }
                        cpl.Mjj = dqi2;
                    }
                    AppMethodBeat.o(43107);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dqi dqi3 = new dqi();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dqi3.populateBuilderWithField(aVar6, dqi3, a.getNextFieldNumber(aVar6))) {
                        }
                        cpl.LpA = dqi3;
                    }
                    AppMethodBeat.o(43107);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        dqi dqi4 = new dqi();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = dqi4.populateBuilderWithField(aVar7, dqi4, a.getNextFieldNumber(aVar7))) {
                        }
                        cpl.LpB = dqi4;
                    }
                    AppMethodBeat.o(43107);
                    return 0;
                case 5:
                    cpl.kdY = aVar3.UbS.zi();
                    AppMethodBeat.o(43107);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = sKBuiltinBuffer_t.populateBuilderWithField(aVar8, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar8))) {
                        }
                        cpl.KHp = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(43107);
                    return 0;
                case 7:
                    cpl.LoG = aVar3.UbS.zi();
                    AppMethodBeat.o(43107);
                    return 0;
                case 8:
                    cpl.LoH = aVar3.UbS.zi();
                    AppMethodBeat.o(43107);
                    return 0;
                case 9:
                    cpl.Mvd = aVar3.UbS.zi();
                    AppMethodBeat.o(43107);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        dqi dqi5 = new dqi();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = dqi5.populateBuilderWithField(aVar9, dqi5, a.getNextFieldNumber(aVar9))) {
                        }
                        cpl.MuI = dqi5;
                    }
                    AppMethodBeat.o(43107);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        dqi dqi6 = new dqi();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = dqi6.populateBuilderWithField(aVar10, dqi6, a.getNextFieldNumber(aVar10))) {
                        }
                        cpl.MuJ = dqi6;
                    }
                    AppMethodBeat.o(43107);
                    return 0;
                case 12:
                    LinkedList<byte[]> awh8 = aVar3.awh(intValue);
                    int size8 = awh8.size();
                    for (int i10 = 0; i10 < size8; i10++) {
                        dqi dqi7 = new dqi();
                        g.a.a.a.a aVar11 = new g.a.a.a.a(awh8.get(i10), unknownTagHandler);
                        for (boolean z8 = true; z8; z8 = dqi7.populateBuilderWithField(aVar11, dqi7, a.getNextFieldNumber(aVar11))) {
                        }
                        cpl.MuK = dqi7;
                    }
                    AppMethodBeat.o(43107);
                    return 0;
                case 13:
                    cpl.LoM = aVar3.UbS.zi();
                    AppMethodBeat.o(43107);
                    return 0;
                case 14:
                    cpl.LoN = aVar3.UbS.zi();
                    AppMethodBeat.o(43107);
                    return 0;
                case 15:
                    LinkedList<byte[]> awh9 = aVar3.awh(intValue);
                    int size9 = awh9.size();
                    for (int i11 = 0; i11 < size9; i11++) {
                        dpt dpt = new dpt();
                        g.a.a.a.a aVar12 = new g.a.a.a.a(awh9.get(i11), unknownTagHandler);
                        for (boolean z9 = true; z9; z9 = dpt.populateBuilderWithField(aVar12, dpt, a.getNextFieldNumber(aVar12))) {
                        }
                        cpl.LoO.add(dpt);
                    }
                    AppMethodBeat.o(43107);
                    return 0;
                case 16:
                    LinkedList<byte[]> awh10 = aVar3.awh(intValue);
                    int size10 = awh10.size();
                    for (int i12 = 0; i12 < size10; i12++) {
                        dqi dqi8 = new dqi();
                        g.a.a.a.a aVar13 = new g.a.a.a.a(awh10.get(i12), unknownTagHandler);
                        for (boolean z10 = true; z10; z10 = dqi8.populateBuilderWithField(aVar13, dqi8, a.getNextFieldNumber(aVar13))) {
                        }
                        cpl.Mvh = dqi8;
                    }
                    AppMethodBeat.o(43107);
                    return 0;
                case 17:
                    cpl.LoQ = aVar3.UbS.zi();
                    AppMethodBeat.o(43107);
                    return 0;
                case 18:
                    cpl.LoR = aVar3.UbS.zi();
                    AppMethodBeat.o(43107);
                    return 0;
                case 19:
                    cpl.kdZ = aVar3.UbS.readString();
                    AppMethodBeat.o(43107);
                    return 0;
                case 20:
                    cpl.kea = aVar3.UbS.readString();
                    AppMethodBeat.o(43107);
                    return 0;
                case 21:
                    cpl.keb = aVar3.UbS.readString();
                    AppMethodBeat.o(43107);
                    return 0;
                case 22:
                    cpl.kec = aVar3.UbS.zi();
                    AppMethodBeat.o(43107);
                    return 0;
                case 23:
                    cpl.Mvi = aVar3.UbS.zi();
                    AppMethodBeat.o(43107);
                    return 0;
                case 24:
                    cpl.MmK = aVar3.UbS.zi();
                    AppMethodBeat.o(43107);
                    return 0;
                case 25:
                    cpl.MmL = aVar3.UbS.readString();
                    AppMethodBeat.o(43107);
                    return 0;
                case 26:
                    cpl.Mvj = aVar3.UbS.zi();
                    AppMethodBeat.o(43107);
                    return 0;
                case 27:
                    cpl.xub = aVar3.UbS.zi();
                    AppMethodBeat.o(43107);
                    return 0;
                case 28:
                    cpl.MmM = aVar3.UbS.readString();
                    AppMethodBeat.o(43107);
                    return 0;
                case 29:
                    cpl.MbK = aVar3.UbS.readString();
                    AppMethodBeat.o(43107);
                    return 0;
                case 30:
                    cpl.ked = aVar3.UbS.readString();
                    AppMethodBeat.o(43107);
                    return 0;
                case 31:
                    cpl.Mvk = aVar3.UbS.readString();
                    AppMethodBeat.o(43107);
                    return 0;
                case 32:
                    cpl.MmN = aVar3.UbS.readString();
                    AppMethodBeat.o(43107);
                    return 0;
                case 33:
                    cpl.MmO = aVar3.UbS.zi();
                    AppMethodBeat.o(43107);
                    return 0;
                case 34:
                    cpl.kef = aVar3.UbS.zi();
                    AppMethodBeat.o(43107);
                    return 0;
                case 35:
                    cpl.kee = aVar3.UbS.zi();
                    AppMethodBeat.o(43107);
                    return 0;
                case 36:
                    cpl.keg = aVar3.UbS.readString();
                    AppMethodBeat.o(43107);
                    return 0;
                case 37:
                    LinkedList<byte[]> awh11 = aVar3.awh(intValue);
                    int size11 = awh11.size();
                    for (int i13 = 0; i13 < size11; i13++) {
                        ebj ebj = new ebj();
                        g.a.a.a.a aVar14 = new g.a.a.a.a(awh11.get(i13), unknownTagHandler);
                        for (boolean z11 = true; z11; z11 = ebj.populateBuilderWithField(aVar14, ebj, a.getNextFieldNumber(aVar14))) {
                        }
                        cpl.MmQ = ebj;
                    }
                    AppMethodBeat.o(43107);
                    return 0;
                case 38:
                    cpl.keh = aVar3.UbS.readString();
                    AppMethodBeat.o(43107);
                    return 0;
                case 39:
                    cpl.Lir = aVar3.UbS.readString();
                    AppMethodBeat.o(43107);
                    return 0;
                case 40:
                    cpl.Lis = aVar3.UbS.readString();
                    AppMethodBeat.o(43107);
                    return 0;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_CREATOR:
                    cpl.kei = aVar3.UbS.readString();
                    AppMethodBeat.o(43107);
                    return 0;
                case 42:
                    LinkedList<byte[]> awh12 = aVar3.awh(intValue);
                    int size12 = awh12.size();
                    for (int i14 = 0; i14 < size12; i14++) {
                        aeq aeq = new aeq();
                        g.a.a.a.a aVar15 = new g.a.a.a.a(awh12.get(i14), unknownTagHandler);
                        for (boolean z12 = true; z12; z12 = aeq.populateBuilderWithField(aVar15, aeq, a.getNextFieldNumber(aVar15))) {
                        }
                        cpl.MmR = aeq;
                    }
                    AppMethodBeat.o(43107);
                    return 0;
                case 43:
                    cpl.Mvl = aVar3.UbS.readString();
                    AppMethodBeat.o(43107);
                    return 0;
                case 44:
                    cpl.Mvm = aVar3.UbS.readString();
                    AppMethodBeat.o(43107);
                    return 0;
                case 45:
                    cpl.Mvn = aVar3.UbS.readString();
                    AppMethodBeat.o(43107);
                    return 0;
                case 46:
                    cpl.Mvo = aVar3.UbS.readString();
                    AppMethodBeat.o(43107);
                    return 0;
                case 47:
                    cpl.Mvp = aVar3.UbS.readString();
                    AppMethodBeat.o(43107);
                    return 0;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                    cpl.Mvq = aVar3.UbS.readString();
                    AppMethodBeat.o(43107);
                    return 0;
                case 49:
                    cpl.Mvr = aVar3.UbS.readString();
                    AppMethodBeat.o(43107);
                    return 0;
                case 50:
                    LinkedList<byte[]> awh13 = aVar3.awh(intValue);
                    int size13 = awh13.size();
                    for (int i15 = 0; i15 < size13; i15++) {
                        dq dqVar = new dq();
                        g.a.a.a.a aVar16 = new g.a.a.a.a(awh13.get(i15), unknownTagHandler);
                        for (boolean z13 = true; z13; z13 = dqVar.populateBuilderWithField(aVar16, dqVar, a.getNextFieldNumber(aVar16))) {
                        }
                        cpl.Mvs = dqVar;
                    }
                    AppMethodBeat.o(43107);
                    return 0;
                case 51:
                case 52:
                case 69:
                case 72:
                case d.CTRL_INDEX:
                case 74:
                case 75:
                case WXMediaMessage.IMediaObject.TYPE_MUSIC_VIDEO:
                case h.a.CTRL_INDEX:
                default:
                    AppMethodBeat.o(43107);
                    return -1;
                case 53:
                    cpl.Mvt = aVar3.UbS.zi();
                    AppMethodBeat.o(43107);
                    return 0;
                case 54:
                    cpl.xNU = aVar3.UbS.readString();
                    AppMethodBeat.o(43107);
                    return 0;
                case 55:
                    cpl.Mvu = aVar3.UbS.zi();
                    AppMethodBeat.o(43107);
                    return 0;
                case 56:
                    cpl.Mvv = aVar3.UbS.zi();
                    AppMethodBeat.o(43107);
                    return 0;
                case n.CTRL_INDEX:
                    LinkedList<byte[]> awh14 = aVar3.awh(intValue);
                    int size14 = awh14.size();
                    for (int i16 = 0; i16 < size14; i16++) {
                        xg xgVar = new xg();
                        g.a.a.a.a aVar17 = new g.a.a.a.a(awh14.get(i16), unknownTagHandler);
                        for (boolean z14 = true; z14; z14 = xgVar.populateBuilderWithField(aVar17, xgVar, a.getNextFieldNumber(aVar17))) {
                        }
                        cpl.LUi = xgVar;
                    }
                    AppMethodBeat.o(43107);
                    return 0;
                case 58:
                    cpl.DeleteFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(43107);
                    return 0;
                case bv.CTRL_INDEX:
                    cpl.KHk = aVar3.UbS.readString();
                    AppMethodBeat.o(43107);
                    return 0;
                case 60:
                    cpl.Mvw = aVar3.UbS.readString();
                    AppMethodBeat.o(43107);
                    return 0;
                case PlayerException.EXCEPTION_TYPE_INITLIB /*{ENCODED_INT: 61}*/:
                    cpl.Lqm = aVar3.UbS.readString();
                    AppMethodBeat.o(43107);
                    return 0;
                case 62:
                    LinkedList<byte[]> awh15 = aVar3.awh(intValue);
                    int size15 = awh15.size();
                    for (int i17 = 0; i17 < size15; i17++) {
                        dbl dbl = new dbl();
                        g.a.a.a.a aVar18 = new g.a.a.a.a(awh15.get(i17), unknownTagHandler);
                        for (boolean z15 = true; z15; z15 = dbl.populateBuilderWithField(aVar18, dbl, a.getNextFieldNumber(aVar18))) {
                        }
                        cpl.Mvx = dbl;
                    }
                    AppMethodBeat.o(43107);
                    return 0;
                case 63:
                    cpl.fuW = aVar3.UbS.readString();
                    AppMethodBeat.o(43107);
                    return 0;
                case 64:
                    cpl.Mvy = aVar3.UbS.zi();
                    AppMethodBeat.o(43107);
                    return 0;
                case 65:
                    cpl.Lql = aVar3.UbS.zi();
                    AppMethodBeat.o(43107);
                    return 0;
                case 66:
                    cpl.Mvz = aVar3.UbS.zi();
                    AppMethodBeat.o(43107);
                    return 0;
                case 67:
                    cpl.ExtFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(43107);
                    return 0;
                case 68:
                    cpl.MvA = aVar3.UbS.readString();
                    AppMethodBeat.o(43107);
                    return 0;
                case 70:
                    cpl.fvd = aVar3.UbS.zl();
                    AppMethodBeat.o(43107);
                    return 0;
                case 71:
                    cpl.LRy = aVar3.UbS.readString();
                    AppMethodBeat.o(43107);
                    return 0;
                case TPCodecParamers.TP_PROFILE_H264_MAIN /*{ENCODED_INT: 77}*/:
                    cpl.LiD = aVar3.UbS.readString();
                    AppMethodBeat.o(43107);
                    return 0;
                case 79:
                    cpl.LiF = aVar3.UbS.readString();
                    AppMethodBeat.o(43107);
                    return 0;
                case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*{ENCODED_INT: 80}*/:
                    cpl.MvB = aVar3.UbS.zi();
                    AppMethodBeat.o(43107);
                    return 0;
            }
        } else {
            AppMethodBeat.o(43107);
            return -1;
        }
    }
}
