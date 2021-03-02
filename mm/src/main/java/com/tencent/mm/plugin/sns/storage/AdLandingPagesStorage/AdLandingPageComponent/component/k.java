package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.d;
import com.tencent.mm.plugin.sns.e.a;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class k extends q {
    private boolean DCY;
    private ah DJT = fds();
    private w EcN;
    private a EcO = new a();

    public k(Context context, w wVar, ViewGroup viewGroup) {
        super(context, wVar, viewGroup);
        AppMethodBeat.i(202896);
        this.EcN = wVar;
        AppMethodBeat.o(202896);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eXe() {
        AppMethodBeat.i(202897);
        super.eXe();
        if (this.EcN != null) {
            try {
                int i2 = this.DJT.source;
                Log.i("AdLandingPageAddBrandComp", "canNotJump source is ".concat(String.valueOf(i2)));
                if (SnsAdNativeLandingPagesUI.ZF(i2)) {
                    int safeParseDouble = (int) (Util.safeParseDouble("0.6") * 255.0d);
                    if (!Util.isNullOrNil(this.EcN.DYw)) {
                        fdx().DYw = String.format("#%02x%s", Integer.valueOf(safeParseDouble), this.EcN.DYw.substring(1));
                    }
                    if (!Util.isNullOrNil(this.EcN.DYt)) {
                        fdx().DYt = String.format("#%02x%s", Integer.valueOf(safeParseDouble), this.EcN.DYt.substring(1));
                    }
                    if (!Util.isNullOrNil(this.EcN.DYx)) {
                        fdx().DYx = String.format("#%02x%s", Integer.valueOf(safeParseDouble), this.EcN.DYx.substring(1));
                    }
                    if (this.Edp != null) {
                        this.Edp.setEnabled(false);
                    }
                }
                AppMethodBeat.o(202897);
                return;
            } catch (Throwable th) {
                Log.e("AdLandingPageAddBrandComp", th.toString());
            }
        }
        AppMethodBeat.o(202897);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void b(z zVar) {
        AppMethodBeat.i(202898);
        super.b(this.EcN);
        AppMethodBeat.o(202898);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q
    public final void fde() {
        AppMethodBeat.i(202899);
        a aVar = this.EcO;
        Context context = this.context;
        w wVar = this.EcN;
        ah ahVar = this.DJT;
        boolean z = this.DCY;
        aVar.mContext = context;
        aVar.DxM = 182;
        aVar.DCY = z;
        aVar.dRS = ahVar.getSnsId();
        aVar.uxInfo = ahVar.uxInfo;
        aVar.adExtInfo = ahVar.adExtInfo;
        d dVar = new d();
        if (wVar != null) {
            dVar.brandUsername = Util.nullAs(wVar.brandUsername, "");
            dVar.brandHead = Util.nullAs(wVar.brandHead, "");
            dVar.brandName = Util.nullAs(wVar.brandName, "");
            dVar.brandDesc = Util.nullAs(wVar.brandDesc, "");
            dVar.btnTitleAfterAddBrand = Util.nullAs(wVar.btnTitleAfterAddBrand, "");
        }
        aVar.DCX = dVar;
        aVar.eZo();
        fdf();
        AppMethodBeat.o(202899);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWZ() {
        AppMethodBeat.i(202900);
        super.eWZ();
        this.DCY = AdLandingPagesProxy.getInstance().isBrandAdded(this.EcN.brandUsername);
        AppMethodBeat.o(202900);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.p
    public final void fdf() {
        AppMethodBeat.i(202901);
        this.Edn.report("13387");
        AppMethodBeat.o(202901);
    }
}
