package com.tencent.mm.plugin.sns.ui.a.b;

import android.content.Context;
import android.database.Cursor;
import com.tencent.mm.g.b.a.it;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kiss.widget.textview.c;
import com.tencent.mm.modelsns.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.k.e;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.bl;
import com.tencent.mm.protocal.protobuf.ebn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;
import com.tencent.mm.vending.base.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class a extends b {
    private boolean DEBUG = false;
    private String ELj;
    private List<String> EQI = new ArrayList();
    private bk ESO;
    private int ESP = ((int) (System.currentTimeMillis() / 1000));
    private boolean ESQ = false;
    private volatile boolean ESR = false;
    private byte[] ESS = new byte[0];
    public HashMap<String, Boolean> EST = new HashMap<>();
    protected HashMap<String, String> ESU = new HashMap<>();
    private String ESV = "";
    private String ESW = "";
    protected volatile String EvF = "";
    protected volatile String EvG = "";
    protected volatile String EvH = "";
    protected volatile String EvI = "";
    private bv iFD;
    private Context mContext;
    protected volatile String sNG = "";

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, android.database.Cursor] */
    @Override // com.tencent.mm.vending.a.b
    public final /* synthetic */ SnsInfo a(SnsInfo snsInfo, Cursor cursor) {
        SnsInfo snsInfo2 = snsInfo;
        if (snsInfo2 == null) {
            snsInfo2 = new SnsInfo();
        }
        snsInfo2.convertFrom(cursor);
        return snsInfo2;
    }

    @Override // com.tencent.mm.vending.base.Vending
    public /* synthetic */ void applyChangeSynchronized(Object obj) {
        ebf();
        this.To = (Cursor) obj;
    }

    public a(SnsInfo snsInfo) {
        super(snsInfo);
        hdm();
    }

    @Override // com.tencent.mm.plugin.sns.ui.a.b.b
    public final void a(Context context, bk bkVar, String str) {
        this.mContext = context;
        this.ESO = bkVar;
        this.ELj = str;
        g.aAi();
        this.iFD = ((l) g.af(l.class)).aSN();
    }

    @Override // com.tencent.mm.plugin.sns.ui.a.b.b
    public final void aRi(String str) {
        this.EvF = str;
    }

    @Override // com.tencent.mm.plugin.sns.ui.a.b.b
    public final void aRj(String str) {
        Log.i("MicroMsg.SnsTimeLineVendingSide", "setUnreadBottomSeq:[%s, %s]", str, Long.valueOf(r.aOw(str)));
        this.EvG = str;
    }

    @Override // com.tencent.mm.plugin.sns.ui.a.b.b
    public final String fkd() {
        return this.EvG;
    }

    @Override // com.tencent.mm.plugin.sns.ui.a.b.b
    public final void aRk(String str) {
        Log.i("MicroMsg.SnsTimeLineVendingSide", "setUnreadTopSeq:[%s, %s]", str, Long.valueOf(r.aOw(str)));
        this.EvH = str;
    }

    @Override // com.tencent.mm.plugin.sns.ui.a.b.b
    public final String fke() {
        return this.EvH;
    }

    @Override // com.tencent.mm.plugin.sns.ui.a.b.b
    public final String fkf() {
        return this.sNG;
    }

    @Override // com.tencent.mm.plugin.sns.ui.a.b.b
    public final String fkg() {
        return this.EvI;
    }

    @Override // com.tencent.mm.plugin.sns.ui.a.b.b
    public final void fiE() {
        long j2;
        long j3 = 0;
        looperCheckForVending();
        int i2 = aj.faZ().DNF;
        if (i2 == ax.DOd) {
            long j4 = aj.faZ().DNE;
            Log.printDebugStack("MicroMsg.SnsTimeLineVendingSide", "updateDownLimitSeqWithoutFault", new Object[0]);
            Log.d("MicroMsg.SnsTimeLineVendingSide", "updateDownLimitSeqWithoutFault %s %s", Integer.valueOf(aj.faE().fbw()), this.sNG);
            this.sNG = r.Jc(aj.faO().g(j4, aj.faE().fbw(), false));
            this.sNG = this.sNG;
            this.EvI = r.Jc(j4);
            Log.d("MicroMsg.SnsTimeLineVendingSide", "unreadTipFaultItem.end:%s, upLimitSeq:%s, downLimitSeq:%s", Long.valueOf(j4), Long.valueOf(r.aOw(this.EvI)), Long.valueOf(r.aOw(this.sNG)));
        } else if (i2 == ax.DOf) {
            if (((b) this).mCount == 0) {
                j2 = 0;
            } else {
                int i3 = ((b) this).mCount - 1;
                int i4 = 0;
                while (true) {
                    SnsInfo snsInfo = (SnsInfo) getItem(i3);
                    if (snsInfo != null && !snsInfo.isSourceExist(32) && snsInfo.field_snsId != 0) {
                        long j5 = snsInfo.field_snsId;
                        Log.i("MicroMsg.SnsTimeLineVendingSide", "get list last not ad item %s %s", Long.valueOf(j5), snsInfo.getStringSeq());
                        j2 = j5;
                        break;
                    }
                    i4++;
                    int i5 = i3 - 1;
                    if (i5 < 0 || i4 > 500) {
                        j2 = 0;
                    } else {
                        i3 = i5;
                    }
                }
                j2 = 0;
            }
            this.ESR = true;
            synchronized (this.ESS) {
                Log.i("MicroMsg.SnsTimeLineVendingSide", "updateDownLimitSeq by addSizeByNormal");
                this.sNG = L(j2, this.sNG);
            }
        } else if (i2 == ax.DOe) {
            if (((b) this).mCount != 0) {
                int i6 = 0;
                int i7 = 0;
                while (true) {
                    SnsInfo snsInfo2 = (SnsInfo) getItem(i6);
                    if (snsInfo2 != null && !snsInfo2.isSourceExist(32) && snsInfo2.field_snsId != 0) {
                        j3 = snsInfo2.field_snsId;
                        Log.i("MicroMsg.SnsTimeLineVendingSide", "get list last not ad item %s %s", Long.valueOf(j3), snsInfo2.getStringSeq());
                        break;
                    }
                    i7++;
                    int i8 = i6 + 1;
                    if (i8 >= ((b) this).mCount || i7 > 500) {
                        break;
                    }
                    i6 = i8;
                }
            }
            synchronized (this.ESS) {
                this.EvI = JV(j3);
            }
        }
    }

    @Override // com.tencent.mm.plugin.sns.ui.a.b.b
    public final void axJ() {
        looperCheckForVending();
        Log.i("MicroMsg.SnsTimeLineVendingSide", "resetSize %s", Boolean.valueOf(this.ESR));
        if (!this.ESR) {
            synchronized (this.ESS) {
                Log.i("MicroMsg.SnsTimeLineVendingSide", "updateDownLimitSeq by resetSize");
                this.sNG = L(0, this.sNG);
            }
        }
    }

    @Override // com.tencent.mm.plugin.sns.ui.a.b.b
    public final void aRl(String str) {
        synchronized (this.ESS) {
            this.sNG = str;
        }
    }

    @Override // com.tencent.mm.plugin.sns.ui.a.b.b
    public final void aRm(String str) {
        synchronized (this.ESS) {
            this.EvI = str;
        }
    }

    @Override // com.tencent.mm.plugin.sns.ui.a.b.b
    public final String fkh() {
        return this.EvF;
    }

    @Override // com.tencent.mm.plugin.sns.ui.a.b.b
    public final void vD(boolean z) {
        this.ESR = z;
    }

    @Override // com.tencent.mm.vending.a.b
    public Cursor fki() {
        int aQC;
        int i2;
        int i3;
        int i4;
        long currentTimeMillis = System.currentTimeMillis();
        init();
        if (!Util.isNullOrNil(this.EvI)) {
            n faO = aj.faO();
            String str = this.sNG;
            String str2 = this.EvI;
            int[] iArr = new int[2];
            boolean aQw = n.aQw(str2);
            String feT = n.feT();
            if (n.aQw(str)) {
                feT = feT + " AND " + faO.aQx(str);
            }
            if (aQw) {
                feT = feT + " AND " + faO.aQB(str2);
            }
            String str3 = (feT + " AND  (snsId != 0 ) ") + n.Emv;
            Cursor rawQuery = faO.iFy.rawQuery(str3, null, 2);
            if (rawQuery.moveToFirst()) {
                SnsInfo snsInfo = new SnsInfo();
                snsInfo.convertFrom(rawQuery);
                i3 = snsInfo.field_createTime;
            } else {
                i3 = 0;
            }
            if (!aQw || !rawQuery.moveToLast()) {
                i4 = 0;
            } else {
                SnsInfo snsInfo2 = new SnsInfo();
                snsInfo2.convertFrom(rawQuery);
                i4 = snsInfo2.field_createTime;
            }
            rawQuery.close();
            Log.i("MicroMsg.SnsInfoStorage", "getLastAndFirstTime " + str3 + " downCreatetime " + i3 + " upCreatetime " + i4);
            iArr[0] = i3;
            iArr[1] = i4;
            aQC = iArr[0];
            i2 = iArr[1];
        } else {
            aQC = aj.faO().aQC(this.sNG);
            i2 = 0;
        }
        Log.i("MicroMsg.SnsTimeLineVendingSide", "create time sql %s to %s getLimitSeq() %s", Integer.valueOf(this.ESP), Integer.valueOf(aQC), this.sNG);
        try {
            com.tencent.mm.plugin.sns.ad.e.a.G(this.ESP, aQC, this.ELj);
        } catch (Throwable th) {
            Log.e("MicroMsg.SnsTimeLineVendingSide", "checkDeleteExpireAdByPage exp=" + th.toString());
        }
        this.ESP = aQC;
        Log.i("MicroMsg.SnsTimeLineVendingSide", "up:%s, down:%s, upCreateTime:%s, downCreateTime:%s", Long.valueOf(r.aOw(this.EvI)), Long.valueOf(r.aOw(this.sNG)), Integer.valueOf(i2), Integer.valueOf(aQC));
        Cursor q = aj.faO().q(this.sNG, this.EvI, aQC, i2);
        Log.i("MicroMsg.SnsTimeLineVendingSide", "prepareCursorAsynchronous %s", Long.valueOf(Util.milliSecondsToNow(currentTimeMillis)));
        Log.d("MicroMsg.SnsTimeLineVendingSide", "onCursorResetFinish");
        k tO = k.tO(500);
        if (tO.bfG()) {
            int i5 = ((b) this).mCount;
            if (i5 == 0) {
                tO.tR(0).tR(0).tR(0);
                tO.bfK();
            } else {
                String v = r.v((SnsInfo) getItem(1));
                String v2 = r.v((SnsInfo) getItem(i5 - 1));
                if (!v.equals(this.ESV) || !v2.equals(this.ESW)) {
                    this.ESV = v;
                    this.ESW = v2;
                    tO.tR(i5).PH(v).PH(v2);
                    tO.bfK();
                }
            }
        }
        aw faZ = aj.faZ();
        if (faZ.DNn) {
            faZ.DNy.clear();
        }
        return q;
    }

    @Override // com.tencent.mm.vending.base.Vending, com.tencent.mm.vending.a.b
    public void destroyAsynchronous() {
        super.destroyAsynchronous();
        c.hue.aBj();
        this.EST.clear();
        this.mContext = null;
        this.ESO = null;
        this.iFD = null;
        this.QYM = null;
    }

    /* access modifiers changed from: protected */
    public final void init() {
        if (!this.ESQ) {
            amZ();
            this.ESQ = true;
        }
    }

    private void amZ() {
        synchronized (this.ESS) {
            Log.i("MicroMsg.SnsTimeLineVendingSide", "updateDownLimitSeq by initData");
            if (Util.isNullOrNil(this.EvI)) {
                this.sNG = L(0, this.sNG);
            }
        }
    }

    @Override // com.tencent.mm.vending.base.b
    public final /* synthetic */ Object aac(int i2) {
        if (i2 < 0) {
            return null;
        }
        Log.i("MicroMsg.SnsTimeLineVendingSide", "resolveAsynchronous %s", Integer.valueOf(i2));
        long currentTimeMillis = System.currentTimeMillis();
        SnsInfo snsInfo = (SnsInfo) super.getItem(i2);
        if (snsInfo != null) {
            aw faZ = aj.faZ();
            long j2 = snsInfo.field_snsId;
            if (faZ.DNn) {
                faZ.DNy.put(Long.valueOf(j2), Integer.valueOf(i2));
            }
        }
        bl a2 = r.a(snsInfo, an.C(snsInfo), this.mContext, this.ESO, i2 < this.ESO.getCount(), this.iFD, this.ELj, this.EST, this.ESU, this.EQI);
        if (!(a2.EOi == null || a2.EOj == null)) {
            e eVar = e.DUQ;
            u uVar = a2.EOi;
            ebn ebn = a2.EOj;
            String str = a2.mRa;
            if (!(uVar == null || ebn == null)) {
                it itVar = new it();
                itVar.eiB = itVar.x("SessionId", com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO().cPR(), true);
                itVar.ePA = itVar.x("FoldedBlockId", r.Jc(uVar.field_groupId), true);
                itVar.ePG = 2;
                itVar.ePH = 2;
                itVar.eoK = itVar.x("UserName", str, true);
                if (ebn.Nbk != null) {
                    itVar.ePB = (long) ebn.Nbk.size();
                }
                eVar.DVH.put(Long.valueOf(uVar.field_groupId), itVar);
            }
        }
        if (i2 == ((b) this).mCount - 1 && a2.DqO != null) {
            e.DUQ.DUW = r.v(a2.DqO);
            e.DUQ.DUX = a2.DqO.getCreateTime();
            Log.d("MicroMsg.SnsTimeLineVendingSide", "last snsId:%s, createTime:%s", e.DUQ.DUW, Integer.valueOf(e.DUQ.DUX));
        }
        Log.d("MicroMsg.SnsTimeLineVendingSide", "SnsTimeLineVendingStruct resolve %s %s ms", Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        return a2;
    }
}
