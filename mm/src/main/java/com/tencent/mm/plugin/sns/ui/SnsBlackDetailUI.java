package com.tencent.mm.plugin.sns.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.contact.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.jsapi.audio.h;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.pluginsdk.i.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.bv;
import java.util.LinkedList;
import java.util.List;

public class SnsBlackDetailUI extends SnsTagDetailUI implements i, MStorageEx.IOnStorageChange {
    @Override // com.tencent.mm.plugin.sns.ui.SnsTagDetailUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.plugin.sns.ui.SnsTagDetailUI
    public final void fhH() {
        AppMethodBeat.i(98488);
        Log.d("MicroMsg.SnsBlackDetailUI", "SnsBlackDetailUI __onCreate");
        g.aAi();
        ((l) g.af(l.class)).aSN().add(this);
        AppMethodBeat.o(98488);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.ui.SnsTagDetailUI
    public final void fhI() {
        AppMethodBeat.i(98489);
        Log.d("MicroMsg.SnsBlackDetailUI", "SnsBlackDetailUI __onDestroy");
        g.aAi();
        if (g.aAf().azp()) {
            g.aAi();
            ((l) g.af(l.class)).aSN().remove(this);
        }
        AppMethodBeat.o(98489);
    }

    @Override // com.tencent.mm.plugin.sns.ui.SnsTagDetailUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(98490);
        super.onCreate(bundle);
        Log.d("MicroMsg.SnsBlackDetailUI", "SnsBlackDetailUI onCreate");
        AppMethodBeat.o(98490);
    }

    @Override // com.tencent.mm.plugin.sns.ui.SnsTagDetailUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(98491);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        g.aAi();
        g.aAg().hqi.b(com.tencent.mm.plugin.appbrand.jsapi.audio.g.CTRL_INDEX, this);
        g.aAi();
        g.aAg().hqi.b(291, this);
        g.aAi();
        g.aAg().hqi.b(com.tencent.mm.plugin.appbrand.jsapi.audio.l.CTRL_INDEX, this);
        g.aAi();
        g.aAg().hqi.b(h.CTRL_INDEX, this);
        g.aAi();
        if (g.aAf().azp()) {
            g.aAi();
            ((l) g.af(l.class)).aSN().remove(this);
        }
        super.onDestroy();
        AppMethodBeat.o(98491);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.ui.SnsTagDetailUI
    public final void fhJ() {
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.ui.SnsTagDetailUI
    public final void edF() {
        AppMethodBeat.i(98492);
        if ((this.EJW + " " + Util.listToString(this.qLQ, ",")).equals(this.md5) && this.DJc != 0) {
            finish();
            AppMethodBeat.o(98492);
        } else if (aj.faU().K(this.DJc, this.EJW)) {
            com.tencent.mm.ui.base.h.c(this, getString(R.string.ha_, new Object[]{this.EJW}), getString(R.string.zb), true);
            AppMethodBeat.o(98492);
        } else {
            List<String> fhL = fhL();
            LinkedList<String> linkedList = new LinkedList();
            LinkedList<String> linkedList2 = new LinkedList();
            for (String str : fhL) {
                if (!this.qLQ.contains(str)) {
                    linkedList.add(str);
                }
            }
            for (String str2 : this.qLQ) {
                if (!fhL.contains(str2)) {
                    linkedList2.add(str2);
                }
            }
            for (String str3 : linkedList) {
                ab.D(str3, false);
            }
            for (String str4 : linkedList2) {
                ab.D(str4, true);
            }
            finish();
            AppMethodBeat.o(98492);
        }
    }

    private static List<String> fhK() {
        AppMethodBeat.i(98493);
        new LinkedList();
        List<String> gnq = a.gnq();
        AppMethodBeat.o(98493);
        return gnq;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.ui.SnsTagDetailUI
    public final List<String> fhL() {
        AppMethodBeat.i(98494);
        LinkedList linkedList = new LinkedList();
        if (this.DJc == 4) {
            List<String> fhK = fhK();
            AppMethodBeat.o(98494);
            return fhK;
        }
        AppMethodBeat.o(98494);
        return linkedList;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.ui.SnsTagDetailUI
    public final void DM(String str) {
        AppMethodBeat.i(98495);
        super.DM(str);
        AppMethodBeat.o(98495);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.ui.SnsTagDetailUI
    public final void hc(List<String> list) {
        AppMethodBeat.i(98496);
        bv faC = aj.faC();
        String aTY = z.aTY();
        for (String str : list) {
            if (!this.qLQ.contains(str) && c.oR(faC.Kn(str).field_type) && !aTY.equals(str)) {
                this.qLQ.add(str);
            }
        }
        if (this.gtU != null) {
            this.gtU.fm(this.qLQ);
        }
        updateTitle();
        AppMethodBeat.o(98496);
    }

    @Override // com.tencent.mm.ak.i, com.tencent.mm.plugin.sns.ui.SnsTagDetailUI
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(98497);
        Log.i("MicroMsg.SnsBlackDetailUI", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        AppMethodBeat.o(98497);
    }
}
