package com.tencent.mm.plugin.sns.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.wh;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;
import java.util.Iterator;

public final class b {
    public boolean DSC;
    public long DSD;
    public long DSE;
    public int DSF;
    int DSG;
    int DSH;
    int DSI;
    public int DSJ;
    public int DSK;
    int DSL;
    public int DSM;
    public int DSN;
    int DSO;
    public int DSP;
    public int DSQ;
    public String DSR;
    public String DSS;
    String DST;
    int DSU;
    public int DSV;
    public int DSW;
    public int DSX;
    public int DSY;
    public int DSZ;
    long DTA;
    long DTB;
    long DTC;
    long DTD;
    long DTE;
    long DTF;
    long DTG;
    long DTH;
    long DTI;
    long DTJ;
    long DTK;
    long DTL;
    long DTM;
    long DTN;
    long DTO;
    long DTP;
    long DTQ;
    String DTR;
    int DTS;
    String DTT;
    long DTU;
    private long DTV;
    long DTW;
    private long DTX;
    private HashSet<String> DTY;
    HashSet<String> DTZ;
    public int DTa;
    public int DTb;
    public int DTc;
    int DTd;
    int DTe;
    int DTf;
    int DTg;
    int DTh;
    int DTi;
    public int DTj;
    public int DTk;
    int DTl;
    int DTm;
    public long DTn;
    public long DTo;
    long DTp;
    long DTq;
    long DTr;
    long DTs;
    long DTt;
    long DTu;
    long DTv;
    long DTw;
    long DTx;
    long DTy;
    long DTz;
    public long DUA;
    public HashSet<String> DUa;
    HashSet<String> DUb;
    public HashSet<String> DUc;
    HashSet<String> DUd;
    HashSet<String> DUe;
    public HashSet<String> DUf;
    public HashSet<String> DUg;
    HashSet<String> DUh;
    public HashSet<String> DUi;
    private HashSet<String> DUj;
    public HashSet<String> DUk;
    public HashSet<String> DUl;
    public int DUm;
    public int DUn;
    public HashSet<String> DUo;
    public HashSet<String> DUp;
    public HashSet<String> DUq;
    public HashSet<String> DUr;
    public HashSet<String> DUs;
    public HashSet<String> DUt;
    public HashSet<String> DUu;
    public HashSet<String> DUv;
    public HashSet<String> DUw;
    public HashSet<String> DUx;
    public HashSet<String> DUy;
    public HashSet<String> DUz;
    IListener gmC;
    int gni;
    public int ppa;

    public final void L(SnsInfo snsInfo) {
        AppMethodBeat.i(96176);
        if (snsInfo == null) {
            AppMethodBeat.o(96176);
            return;
        }
        this.DTY.add(snsInfo.getLocalid());
        this.DSG = this.DTY.size();
        AppMethodBeat.o(96176);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public final void M(SnsInfo snsInfo) {
        AppMethodBeat.i(96177);
        if (snsInfo == null) {
            AppMethodBeat.o(96177);
            return;
        }
        String localid = snsInfo.getLocalid();
        String v = r.v(snsInfo);
        if (this.DTZ.contains(v)) {
            AppMethodBeat.o(96177);
            return;
        }
        Log.i("MicroMsg.SnsBrowseInfoHelper", "onClickFeed localId:Td, snsId:%s", localid, v);
        this.DSH++;
        this.DTZ.add(v);
        if (snsInfo.isAd()) {
            this.DTm++;
        }
        switch (snsInfo.field_type) {
            case 1:
                this.DTf++;
                break;
            case 3:
                if (Util.isNullOrNil(snsInfo.getTimeLine().publicUserName)) {
                    this.DTe++;
                    break;
                } else {
                    this.DTd++;
                    break;
                }
            case 4:
            case 42:
                this.DTh++;
                break;
            case 5:
                this.DTi++;
                break;
            case 15:
                this.DTg++;
                break;
            case 18:
                this.DTl++;
                break;
        }
        if (snsInfo.isAd()) {
            if (snsInfo.getAdXml() != null && snsInfo.getAdXml().isLandingPagesAd()) {
                uV(true);
                AppMethodBeat.o(96177);
                return;
            } else if (snsInfo.field_type == 1) {
                va(true);
                AppMethodBeat.o(96177);
                return;
            } else if (snsInfo.field_type == 15) {
                vb(true);
                AppMethodBeat.o(96177);
                return;
            }
        } else if (snsInfo.getTimeLine() == null || Util.isNullOrNil(snsInfo.getTimeLine().canvasInfo)) {
            switch (snsInfo.field_type) {
                case 1:
                    uU(true);
                    AppMethodBeat.o(96177);
                    return;
                case 3:
                    if (Util.isNullOrNil(snsInfo.getTimeLine().publicUserName)) {
                        uZ(true);
                        break;
                    } else {
                        uY(true);
                        AppMethodBeat.o(96177);
                        return;
                    }
                case 4:
                case 42:
                    uZ(true);
                    AppMethodBeat.o(96177);
                    return;
                case 5:
                    uZ(true);
                    AppMethodBeat.o(96177);
                    return;
                case 15:
                    uX(true);
                    AppMethodBeat.o(96177);
                    return;
                case 18:
                    vd(true);
                    AppMethodBeat.o(96177);
                    return;
            }
        } else {
            uW(true);
            AppMethodBeat.o(96177);
            return;
        }
        AppMethodBeat.o(96177);
    }

    public final void e(SnsInfo snsInfo, boolean z) {
        AppMethodBeat.i(96178);
        if (snsInfo == null) {
            AppMethodBeat.o(96178);
            return;
        }
        if (z) {
            this.DUd.add(r.v(snsInfo));
        } else {
            this.DUe.add(r.v(snsInfo));
        }
        this.DUh.add(snsInfo.getUserName());
        this.DSI = this.DUh.size();
        if (aj.fau().equals(snsInfo.getUserName())) {
            uQ(true);
            AppMethodBeat.o(96178);
            return;
        }
        uR(true);
        AppMethodBeat.o(96178);
    }

    public final void kp(String str, String str2) {
        AppMethodBeat.i(96179);
        this.DUb.add(str2);
        this.DUj.add(str);
        this.DSL = this.DUj.size();
        AppMethodBeat.o(96179);
    }

    public final void uP(boolean z) {
        AppMethodBeat.i(96180);
        if (z) {
            this.DTq = System.currentTimeMillis();
            AppMethodBeat.o(96180);
            return;
        }
        if (this.DTq > 0) {
            this.DTp += System.currentTimeMillis() - this.DTq;
            this.DTq = 0;
        }
        AppMethodBeat.o(96180);
    }

    public final void uQ(boolean z) {
        AppMethodBeat.i(96181);
        if (z) {
            this.DTs = System.currentTimeMillis();
            AppMethodBeat.o(96181);
            return;
        }
        if (this.DTs > 0) {
            this.DTr += System.currentTimeMillis() - this.DTs;
            this.DTs = 0;
        }
        AppMethodBeat.o(96181);
    }

    public final void uR(boolean z) {
        AppMethodBeat.i(96182);
        if (z) {
            this.DTu = System.currentTimeMillis();
            AppMethodBeat.o(96182);
            return;
        }
        if (this.DTu > 0) {
            this.DTt += System.currentTimeMillis() - this.DTu;
            this.DTu = 0;
        }
        AppMethodBeat.o(96182);
    }

    public final void uS(boolean z) {
        AppMethodBeat.i(96183);
        if (z) {
            this.DTw = System.currentTimeMillis();
            AppMethodBeat.o(96183);
            return;
        }
        if (this.DTw > 0) {
            this.DTv += System.currentTimeMillis() - this.DTw;
            this.DTw = 0;
        }
        AppMethodBeat.o(96183);
    }

    public final void uT(boolean z) {
        AppMethodBeat.i(96184);
        if (z) {
            this.DTy = System.currentTimeMillis();
            AppMethodBeat.o(96184);
            return;
        }
        if (this.DTy > 0) {
            this.DTx += System.currentTimeMillis() - this.DTy;
            this.DTy = 0;
        }
        AppMethodBeat.o(96184);
    }

    public final void uU(boolean z) {
        AppMethodBeat.i(96185);
        if (z) {
            this.DTA = System.currentTimeMillis();
            AppMethodBeat.o(96185);
            return;
        }
        if (this.DTA > 0) {
            this.DTz += System.currentTimeMillis() - this.DTA;
            this.DTA = 0;
        }
        AppMethodBeat.o(96185);
    }

    public final void uV(boolean z) {
        AppMethodBeat.i(96186);
        if (z) {
            this.DTV = System.currentTimeMillis();
            AppMethodBeat.o(96186);
            return;
        }
        if (this.DTV > 0) {
            this.DTU += System.currentTimeMillis() - this.DTV;
            this.DTV = 0;
        }
        AppMethodBeat.o(96186);
    }

    public final void uW(boolean z) {
        AppMethodBeat.i(96187);
        if (z) {
            this.DTX = System.currentTimeMillis();
            AppMethodBeat.o(96187);
            return;
        }
        if (this.DTX > 0) {
            this.DTW += System.currentTimeMillis() - this.DTX;
            this.DTX = 0;
        }
        AppMethodBeat.o(96187);
    }

    public final void uX(boolean z) {
        AppMethodBeat.i(96188);
        if (z) {
            this.DTC = System.currentTimeMillis();
            AppMethodBeat.o(96188);
            return;
        }
        if (this.DTC > 0) {
            this.DTB += System.currentTimeMillis() - this.DTC;
            this.DTC = 0;
        }
        AppMethodBeat.o(96188);
    }

    public final void uY(boolean z) {
        AppMethodBeat.i(96189);
        if (z) {
            this.DTE = System.currentTimeMillis();
            AppMethodBeat.o(96189);
            return;
        }
        if (this.DTE > 0) {
            this.DTD += System.currentTimeMillis() - this.DTE;
            this.DTE = 0;
        }
        AppMethodBeat.o(96189);
    }

    public final void uZ(boolean z) {
        AppMethodBeat.i(96190);
        if (z) {
            this.DTG = System.currentTimeMillis();
            AppMethodBeat.o(96190);
            return;
        }
        if (this.DTG > 0) {
            this.DTF += System.currentTimeMillis() - this.DTG;
            this.DTG = 0;
        }
        AppMethodBeat.o(96190);
    }

    public final void va(boolean z) {
        AppMethodBeat.i(96191);
        if (z) {
            this.DTI = System.currentTimeMillis();
            AppMethodBeat.o(96191);
            return;
        }
        if (this.DTI > 0) {
            this.DTH += System.currentTimeMillis() - this.DTI;
            this.DTI = 0;
        }
        AppMethodBeat.o(96191);
    }

    public final void vb(boolean z) {
        AppMethodBeat.i(96192);
        if (z) {
            this.DTM = System.currentTimeMillis();
            AppMethodBeat.o(96192);
            return;
        }
        if (this.DTM > 0) {
            this.DTL += System.currentTimeMillis() - this.DTM;
            this.DTM = 0;
        }
        AppMethodBeat.o(96192);
    }

    public final void vc(boolean z) {
        AppMethodBeat.i(96193);
        if (z) {
            this.DTO = System.currentTimeMillis();
            AppMethodBeat.o(96193);
            return;
        }
        if (this.DTO > 0) {
            this.DTN += System.currentTimeMillis() - this.DTO;
            this.DTO = 0;
        }
        AppMethodBeat.o(96193);
    }

    public final void vd(boolean z) {
        AppMethodBeat.i(96194);
        if (z) {
            this.DTQ = System.currentTimeMillis();
            AppMethodBeat.o(96194);
            return;
        }
        if (this.DTQ > 0) {
            this.DTP += System.currentTimeMillis() - this.DTQ;
            this.DTQ = 0;
        }
        AppMethodBeat.o(96194);
    }

    public final void ve(boolean z) {
        this.DSU = z ? 1 : 0;
    }

    public b() {
        AppMethodBeat.i(96195);
        this.DSC = false;
        this.DSD = -1;
        this.DSE = 0;
        this.DSF = 0;
        this.DSG = 0;
        this.DSH = 0;
        this.DSI = 0;
        this.DSJ = 0;
        this.DSK = 0;
        this.DSL = 0;
        this.DSM = 0;
        this.DSN = 0;
        this.DSO = 0;
        this.DSP = 0;
        this.DSQ = 0;
        this.DSR = "";
        this.DSS = "";
        this.DST = "";
        this.DSV = 0;
        this.DSW = 0;
        this.DSX = 0;
        this.DSY = 0;
        this.DSZ = 0;
        this.DTa = 0;
        this.DTb = 0;
        this.ppa = 0;
        this.DTc = 0;
        this.DTd = 0;
        this.DTe = 0;
        this.DTf = 0;
        this.DTg = 0;
        this.DTh = 0;
        this.DTi = 0;
        this.DTj = 0;
        this.DTk = 0;
        this.DTl = 0;
        this.DTm = 0;
        this.DTn = 0;
        this.DTo = 0;
        this.DTp = 0;
        this.DTq = 0;
        this.DTr = 0;
        this.DTs = 0;
        this.DTt = 0;
        this.DTu = 0;
        this.DTv = 0;
        this.DTw = 0;
        this.DTx = 0;
        this.DTy = 0;
        this.DTz = 0;
        this.DTA = 0;
        this.DTB = 0;
        this.DTC = 0;
        this.DTD = 0;
        this.DTE = 0;
        this.DTF = 0;
        this.DTG = 0;
        this.DTH = 0;
        this.DTI = 0;
        this.DTJ = 0;
        this.DTK = 0;
        this.DTL = 0;
        this.DTM = 0;
        this.DTN = 0;
        this.DTO = 0;
        this.DTP = 0;
        this.DTQ = 0;
        this.DTU = 0;
        this.DTV = 0;
        this.DTW = 0;
        this.DTX = 0;
        this.DTY = new HashSet<>();
        this.DTZ = new HashSet<>();
        this.DUa = new HashSet<>();
        this.DUb = new HashSet<>();
        this.DUc = new HashSet<>();
        this.DUd = new HashSet<>();
        this.DUe = new HashSet<>();
        this.DUf = new HashSet<>();
        this.DUg = new HashSet<>();
        this.DUh = new HashSet<>();
        this.DUi = new HashSet<>();
        this.DUj = new HashSet<>();
        this.DUk = new HashSet<>();
        this.DUl = new HashSet<>();
        this.DUm = Integer.MAX_VALUE;
        this.DUn = 0;
        this.DUo = new HashSet<>();
        this.DUp = new HashSet<>();
        this.DUq = new HashSet<>();
        this.DUr = new HashSet<>();
        this.DUs = new HashSet<>();
        this.DUt = new HashSet<>();
        this.DUu = new HashSet<>();
        this.DUv = new HashSet<>();
        this.DUw = new HashSet<>();
        this.DUx = new HashSet<>();
        this.DUy = new HashSet<>();
        this.DUz = new HashSet<>();
        this.gmC = new IListener<wh>() {
            /* class com.tencent.mm.plugin.sns.k.b.AnonymousClass1 */

            {
                AppMethodBeat.i(160681);
                this.__eventId = wh.class.getName().hashCode();
                AppMethodBeat.o(160681);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(wh whVar) {
                AppMethodBeat.i(96174);
                wh whVar2 = whVar;
                if (whVar2 instanceof wh) {
                    Log.i("MicroMsg.SnsBrowseInfoHelper", "IListener callback " + b.this.DSD);
                    if (b.this.DSD != -1 && b.this.DSD < 0) {
                        Iterator<Long> it = whVar2.ecr.ecs.iterator();
                        while (it.hasNext()) {
                            if (it.next().longValue() > b.this.DSD) {
                                b.this.DSO++;
                            }
                        }
                    }
                }
                AppMethodBeat.o(96174);
                return false;
            }
        };
        this.DUA = 0;
        EventCenter.instance.addListener(this.gmC);
        AppMethodBeat.o(96195);
    }

    public b(int i2, String str, int i3, String str2) {
        this();
        this.gni = i2;
        this.DTR = str;
        this.DTS = i3;
        this.DTT = str2;
    }

    static String f(HashSet<String> hashSet) {
        AppMethodBeat.i(96196);
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<String> it = hashSet.iterator();
        boolean z = true;
        while (it.hasNext()) {
            String next = it.next();
            if (z) {
                stringBuffer.append(next);
                z = false;
            } else {
                stringBuffer.append("|".concat(String.valueOf(next)));
            }
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(96196);
        return stringBuffer2;
    }
}
