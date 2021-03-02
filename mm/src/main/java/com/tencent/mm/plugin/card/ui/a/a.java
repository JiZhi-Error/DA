package com.tencent.mm.plugin.card.ui.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.ui.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public class a implements g {
    protected b pQV;
    protected MMActivity pQZ;
    protected e.a pZU;
    boolean qeD = false;
    private boolean qeE = false;
    private boolean qeF = false;
    private boolean qeG = false;
    private boolean qeH = false;
    private boolean qeI = false;
    private boolean qeJ = false;
    private boolean qeK = false;
    private boolean qeL = false;
    private boolean qeM = false;

    public a(MMActivity mMActivity) {
        this.pQZ = mMActivity;
    }

    @Override // com.tencent.mm.plugin.card.ui.a.g
    public final void a(b bVar, e.a aVar) {
        AppMethodBeat.i(113620);
        this.pQV = bVar;
        this.pZU = aVar;
        cwv();
        AppMethodBeat.o(113620);
    }

    @Override // com.tencent.mm.plugin.card.ui.a.g
    public final void release() {
        this.pQV = null;
        this.pZU = null;
        this.pQZ = null;
    }

    @Override // com.tencent.mm.plugin.card.ui.a.g
    public final String cwp() {
        AppMethodBeat.i(113621);
        String str = "";
        if (!TextUtils.isEmpty(this.pQV.csQ().LeY)) {
            str = this.pQV.csQ().LeY;
        } else if (this.pQV.csR().Lct == 0) {
            str = getString(R.string.aro);
        } else if (this.pQV.csR().Lcu == 0) {
            if (!TextUtils.isEmpty(this.pQV.csQ().lHL)) {
                str = this.pQV.csQ().lHL;
            } else {
                str = getString(R.string.ane);
            }
        }
        AppMethodBeat.o(113621);
        return str;
    }

    private String getString(int i2) {
        AppMethodBeat.i(113622);
        String string = this.pQZ.getString(i2);
        AppMethodBeat.o(113622);
        return string;
    }

    @Override // com.tencent.mm.plugin.card.ui.a.g
    public final boolean cwq() {
        AppMethodBeat.i(113623);
        if (this.pQV.csR().status == 0 || this.pQV.csR().status == 1 || this.pQV.csR().status == 2) {
            AppMethodBeat.o(113623);
            return true;
        }
        AppMethodBeat.o(113623);
        return false;
    }

    @Override // com.tencent.mm.plugin.card.ui.a.g
    public final boolean cwr() {
        AppMethodBeat.i(113624);
        if (this.pZU.gwE == 3 || ((this.pZU.gwE == 6 && this.pQV.csR().Lcq == 0) || this.pZU.gwE == 4 || this.pZU.gwE == 5 || this.pZU.gwE == 15)) {
            AppMethodBeat.o(113624);
            return true;
        }
        AppMethodBeat.o(113624);
        return false;
    }

    private boolean cws() {
        AppMethodBeat.i(113625);
        if (!TextUtils.isEmpty(this.pQV.csR().code)) {
            AppMethodBeat.o(113625);
            return true;
        }
        AppMethodBeat.o(113625);
        return false;
    }

    /* access modifiers changed from: protected */
    public final boolean cwt() {
        AppMethodBeat.i(113626);
        if (this.pQV.isAcceptable() || (!l.EH(this.pZU.gwE) && !l.EI(this.pZU.gwE) && this.pZU.gwE != 23)) {
            AppMethodBeat.o(113626);
            return false;
        }
        AppMethodBeat.o(113626);
        return true;
    }

    /* access modifiers changed from: protected */
    public final boolean cwu() {
        AppMethodBeat.i(113627);
        if (this.pQV.csN() || this.pZU.gwE != 6) {
            AppMethodBeat.o(113627);
            return false;
        }
        AppMethodBeat.o(113627);
        return true;
    }

    @Override // com.tencent.mm.plugin.card.ui.a.g
    public final boolean cvO() {
        return this.qeD;
    }

    @Override // com.tencent.mm.plugin.card.ui.a.g
    public boolean cww() {
        return this.qeE;
    }

    @Override // com.tencent.mm.plugin.card.ui.a.g
    public final boolean cwx() {
        return this.qeF;
    }

    @Override // com.tencent.mm.plugin.card.ui.a.g
    public final boolean cwy() {
        return this.qeG;
    }

    @Override // com.tencent.mm.plugin.card.ui.a.g
    public final boolean cwz() {
        return this.qeH;
    }

    @Override // com.tencent.mm.plugin.card.ui.a.g
    public final boolean cwA() {
        return this.qeI;
    }

    @Override // com.tencent.mm.plugin.card.ui.a.g
    public final boolean cwB() {
        return this.qeK;
    }

    @Override // com.tencent.mm.plugin.card.ui.a.g
    public final boolean cwC() {
        return this.qeL;
    }

    @Override // com.tencent.mm.plugin.card.ui.a.g
    public final boolean cwD() {
        return this.qeM;
    }

    @Override // com.tencent.mm.plugin.card.ui.a.g
    public boolean cwE() {
        return true;
    }

    @Override // com.tencent.mm.plugin.card.ui.a.g
    public boolean cwF() {
        return false;
    }

    @Override // com.tencent.mm.plugin.card.ui.a.g
    public boolean cwG() {
        return false;
    }

    @Override // com.tencent.mm.plugin.card.ui.a.g
    public boolean cwH() {
        AppMethodBeat.i(113629);
        if ((this.pZU.gwE != 6 || (this.pQV.csM() && !this.pQV.csN())) && this.pZU.gwE != 5 && (this.pZU.gwE != 23 || !this.pQV.csP())) {
            AppMethodBeat.o(113629);
            return false;
        }
        AppMethodBeat.o(113629);
        return true;
    }

    @Override // com.tencent.mm.plugin.card.ui.a.g
    public boolean cwI() {
        return false;
    }

    @Override // com.tencent.mm.plugin.card.ui.a.g
    public boolean cwJ() {
        return true;
    }

    @Override // com.tencent.mm.plugin.card.ui.a.g
    public boolean cwK() {
        AppMethodBeat.i(113630);
        if ((!cws() || !cwq() || !cwr()) && !this.qeD) {
            AppMethodBeat.o(113630);
            return false;
        }
        AppMethodBeat.o(113630);
        return true;
    }

    @Override // com.tencent.mm.plugin.card.ui.a.g
    public boolean cwL() {
        return false;
    }

    @Override // com.tencent.mm.plugin.card.ui.a.g
    public boolean cwM() {
        AppMethodBeat.i(113631);
        if (!this.pQV.csM()) {
            AppMethodBeat.o(113631);
            return true;
        }
        AppMethodBeat.o(113631);
        return false;
    }

    @Override // com.tencent.mm.plugin.card.ui.a.g
    public boolean cwN() {
        AppMethodBeat.i(113632);
        if (this.pQV.csQ().LeS == null || this.pQV.csQ().LeS.LqB == null || this.pQV.csQ().LeS.LqB.size() <= 0 || TextUtils.isEmpty(this.pQV.csQ().LeS.LqB.get(0))) {
            AppMethodBeat.o(113632);
            return false;
        }
        AppMethodBeat.o(113632);
        return true;
    }

    @Override // com.tencent.mm.plugin.card.ui.a.g
    public boolean cwO() {
        AppMethodBeat.i(113633);
        if (this.pQV.csR().Lcs == null || this.pQV.csR().Lcs.size() <= 0 || ((!cwq() || !cwr()) && !this.qeD)) {
            AppMethodBeat.o(113633);
            return false;
        }
        AppMethodBeat.o(113633);
        return true;
    }

    @Override // com.tencent.mm.plugin.card.ui.a.g
    public boolean cwP() {
        return false;
    }

    @Override // com.tencent.mm.plugin.card.ui.a.g
    public final boolean cwQ() {
        AppMethodBeat.i(113634);
        if (this.pQV.csR().Lcw == null || TextUtils.isEmpty(this.pQV.csR().Lcw.title)) {
            AppMethodBeat.o(113634);
            return false;
        }
        AppMethodBeat.o(113634);
        return true;
    }

    @Override // com.tencent.mm.plugin.card.ui.a.g
    public boolean cwR() {
        AppMethodBeat.i(113635);
        if (this.pQV.csR().Lcz == null || TextUtils.isEmpty(this.pQV.csR().Lcz.title)) {
            AppMethodBeat.o(113635);
            return false;
        }
        AppMethodBeat.o(113635);
        return true;
    }

    @Override // com.tencent.mm.plugin.card.ui.a.g
    public boolean cwS() {
        AppMethodBeat.i(113636);
        if (this.pQV.csQ().LeO != null) {
            AppMethodBeat.o(113636);
            return true;
        }
        AppMethodBeat.o(113636);
        return false;
    }

    @Override // com.tencent.mm.plugin.card.ui.a.g
    public boolean cwT() {
        AppMethodBeat.i(113637);
        if (!TextUtils.isEmpty(this.pQV.csQ().LeL)) {
            AppMethodBeat.o(113637);
            return true;
        }
        AppMethodBeat.o(113637);
        return false;
    }

    @Override // com.tencent.mm.plugin.card.ui.a.g
    public boolean cwU() {
        return false;
    }

    @Override // com.tencent.mm.plugin.card.ui.a.g
    public boolean cwV() {
        return false;
    }

    @Override // com.tencent.mm.plugin.card.ui.a.g
    public final void cwW() {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12 = 1;
        AppMethodBeat.i(113638);
        Object[] objArr = new Object[12];
        if (cws()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = cwp();
        if (this.qeD) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        objArr[2] = Integer.valueOf(i3);
        if (cww()) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        objArr[3] = Integer.valueOf(i4);
        if (this.qeF) {
            i5 = 1;
        } else {
            i5 = 0;
        }
        objArr[4] = Integer.valueOf(i5);
        if (this.qeG) {
            i6 = 1;
        } else {
            i6 = 0;
        }
        objArr[5] = Integer.valueOf(i6);
        if (this.qeH) {
            i7 = 1;
        } else {
            i7 = 0;
        }
        objArr[6] = Integer.valueOf(i7);
        if (this.qeI) {
            i8 = 1;
        } else {
            i8 = 0;
        }
        objArr[7] = Integer.valueOf(i8);
        if (this.qeJ) {
            i9 = 1;
        } else {
            i9 = 0;
        }
        objArr[8] = Integer.valueOf(i9);
        if (this.qeK) {
            i10 = 1;
        } else {
            i10 = 0;
        }
        objArr[9] = Integer.valueOf(i10);
        if (this.qeL) {
            i11 = 1;
        } else {
            i11 = 0;
        }
        objArr[10] = Integer.valueOf(i11);
        if (!this.qeM) {
            i12 = 0;
        }
        objArr[11] = Integer.valueOf(i12);
        Log.i("MicroMsg.CardBaseShowLogic", "printStatus, isValidCode:%d, getUnacceptWording:%s, isAcceptedCard:%d, acceptViewVisible:%d, acceptViewEnabled:%d, isShowConsumedBtn:%d, isConsumedBtnEnabled:%d, enableOptionMenu:%d, isShareLogoVisible:%d, addShareMenu:%d, addMenu:%d, addInvalidCardMenu:%d ", objArr);
        AppMethodBeat.o(113638);
    }

    /* access modifiers changed from: protected */
    public void cwv() {
        AppMethodBeat.i(113628);
        Log.i("MicroMsg.CardBaseShowLogic", "updateAcceptState()");
        if (l.EH(this.pZU.gwE) || l.EI(this.pZU.gwE)) {
            if (this.pQV.isAcceptable()) {
                this.qeE = true;
                this.qeF = true;
                this.qeK = true;
                this.qeI = true;
                this.qeJ = true;
            } else if (!this.pQV.isAcceptable()) {
                this.qeE = true;
                this.qeF = false;
                if (this.pQV.csL()) {
                    this.qeL = true;
                    this.qeI = true;
                    this.qeH = true;
                } else {
                    this.qeI = false;
                }
                this.qeJ = true;
            } else {
                this.qeE = false;
                this.qeF = false;
                this.qeI = false;
            }
        } else if (this.pZU.gwE == 6) {
            if (this.pQV.csN()) {
                this.qeE = true;
                this.qeF = true;
                this.qeI = false;
            } else if (this.pQV.csM()) {
                this.qeL = true;
                this.qeI = true;
                this.qeG = true;
                this.qeH = true;
            } else {
                this.qeE = false;
                this.qeF = false;
                this.qeI = false;
                this.qeG = true;
            }
        } else if (l.EJ(this.pZU.gwE)) {
            this.qeE = false;
            this.qeF = false;
            this.qeG = true;
            if (this.pQV.csM()) {
                this.qeL = true;
                this.qeI = true;
                this.qeH = true;
            } else {
                this.qeM = true;
            }
        } else if (this.pZU.gwE == 23) {
            if (this.pQV.isAcceptable()) {
                this.qeE = true;
                this.qeF = true;
                this.qeI = false;
                this.qeJ = true;
            } else {
                this.qeE = true;
                this.qeF = false;
                this.qeI = false;
                this.qeJ = true;
            }
            if (!TextUtils.isEmpty(this.pZU.pZc) && !this.pZU.pZc.equals(z.aTY()) && !this.pQV.csP()) {
                Log.i("MicroMsg.CardBaseShowLogic", " detail page");
                this.qeE = false;
                this.qeF = false;
                this.qeG = true;
                if (this.pQV.csM()) {
                    this.qeL = true;
                    this.qeI = true;
                    this.qeH = true;
                }
            }
        }
        if (this.pQV.csL()) {
            this.qeE = false;
            this.qeF = false;
            Log.i("MicroMsg.CardBaseShowLogic", "need direct jump!");
        } else {
            Log.i("MicroMsg.CardBaseShowLogic", "not need direct jump!");
        }
        if (this.qeD) {
            this.qeE = false;
            this.qeF = false;
            Log.i("MicroMsg.CardBaseShowLogic", "updateAcceptView to gone!");
        } else if (!this.qeE) {
            this.qeD = true;
            Log.i("MicroMsg.CardBaseShowLogic", "set mIsAcceptedCard is true");
        } else {
            this.qeD = false;
            Log.i("MicroMsg.CardBaseShowLogic", "set mIsAcceptedCard is false!");
        }
        Log.i("MicroMsg.CardBaseShowLogic", "mIsAcceptedCard:" + this.qeD);
        AppMethodBeat.o(113628);
    }
}
