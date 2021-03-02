package com.tencent.mm.plugin.appbrand.widget.input;

import android.graphics.Rect;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.widget.input.d.e;
import com.tencent.mm.plugin.appbrand.widget.input.d.h;
import com.tencent.mm.plugin.appbrand.widget.input.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

/* access modifiers changed from: package-private */
public final class d extends c<s> {
    int orM = 0;
    s orN;
    v orO;
    h orP;
    boolean orQ;
    boolean orR;
    private boolean orS;

    d(String str, ac acVar, e eVar) {
        super(str, acVar, eVar.orE);
        AppMethodBeat.i(136314);
        this.orN = new s(acVar.getContext());
        this.orM = Util.nullAs(o.otl.get(str), 0);
        AppMethodBeat.o(136314);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.aa
    public final View getInputPanel() {
        AppMethodBeat.i(136315);
        cbb();
        v vVar = this.orO;
        AppMethodBeat.o(136315);
        return vVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.aa
    public final boolean caY() {
        AppMethodBeat.i(136316);
        if (this.orP == null || !aj.i(this.orP.oyh)) {
            AppMethodBeat.o(136316);
            return false;
        }
        AppMethodBeat.o(136316);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.aa
    public final int caZ() {
        AppMethodBeat.i(136317);
        if (this.orP == null || this.orP.oye == null) {
            AppMethodBeat.o(136317);
            return 0;
        }
        int intValue = this.orP.oye.intValue();
        AppMethodBeat.o(136317);
        return intValue;
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.appbrand.widget.input.c
    public final Rect caT() {
        AppMethodBeat.i(136318);
        Rect rect = new Rect(this.orP.oxN.intValue(), this.orP.oxM.intValue(), this.orP.oxN.intValue() + this.orP.oxK.intValue(), this.orP.oxM.intValue() + this.orP.oxL.intValue());
        AppMethodBeat.o(136318);
        return rect;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.c
    public final h b(h hVar) {
        AppMethodBeat.i(136319);
        if (this.orP == null) {
            this.orP = hVar;
            if (aj.i(hVar.oyp) && this.orN != null) {
                this.orN.setPasswordMode(true);
            }
        } else {
            this.orP.a(hVar);
        }
        if (this.orN == null) {
            AppMethodBeat.o(136319);
            return null;
        }
        b.a(this.orN, this.orP);
        h hVar2 = this.orP;
        AppMethodBeat.o(136319);
        return hVar2;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.c
    public final boolean afY(String str) {
        AppMethodBeat.i(136320);
        if (this.orN == null) {
            AppMethodBeat.o(136320);
            return false;
        }
        this.orN.G(str);
        AppMethodBeat.o(136320);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.aa
    public final boolean q(int i2, int i3, boolean z) {
        AppMethodBeat.i(230571);
        if (this.orN == null) {
            AppMethodBeat.o(230571);
            return false;
        }
        this.orO = v.a(((ac) this.orG.get()).getContentView(), (this.orG.get() == null || !(this.orG.get() instanceof ac)) ? null : ((ac) this.orG.get()).bRo());
        this.orO.setComponentView(this.orP.oyq.booleanValue());
        v vVar = this.orO;
        if (v.otQ && vVar.otO == null) {
            vVar.otO = v.otP;
            v.db(vVar.otO);
            vVar.addView(vVar.otO, 0);
        }
        if (v.otQ && vVar.otO != v.otP) {
            v.db(vVar.otO);
            vVar.otO = v.otP;
            v.db(vVar.otO);
            vVar.addView(vVar.otO, 0);
            Log.d("MicroMsg.AppBrandNumberKeyboardPanel", "toolbar is changed in updateToolbar() because toolbar != mComponentView");
        }
        if (v.otQ && vVar.otO.getParent() != vVar) {
            v.db(vVar.otO);
            vVar.addView(vVar.otO, 0);
        }
        if (!v.otQ && vVar.otO != null && vVar.otO.getParent() == vVar) {
            vVar.removeView(vVar.otO);
        }
        if (this.orO == null) {
            AppMethodBeat.o(230571);
            return false;
        }
        this.orS = z;
        if (z) {
            v vVar2 = this.orO;
            vVar2.otK.setBackgroundResource(R.color.BW_BG_100);
            vVar2.otK.findViewById(R.id.brt).setBackgroundResource(R.color.aa);
            vVar2.otK.findViewById(R.id.ago).setBackgroundResource(R.color.aa);
            AppBrandNumberKeyboardView appBrandNumberKeyboardView = vVar2.otN;
            appBrandNumberKeyboardView.orS = true;
            appBrandNumberKeyboardView.mKey1.setTextColor(appBrandNumberKeyboardView.getResources().getColor(R.color.ae));
            appBrandNumberKeyboardView.mKey1.setBackgroundResource(R.drawable.ed);
            appBrandNumberKeyboardView.mKey2.setTextColor(appBrandNumberKeyboardView.getResources().getColor(R.color.ae));
            appBrandNumberKeyboardView.mKey2.setBackgroundResource(R.drawable.ed);
            appBrandNumberKeyboardView.mKey3.setTextColor(appBrandNumberKeyboardView.getResources().getColor(R.color.ae));
            appBrandNumberKeyboardView.mKey3.setBackgroundResource(R.drawable.ed);
            appBrandNumberKeyboardView.mKey4.setTextColor(appBrandNumberKeyboardView.getResources().getColor(R.color.ae));
            appBrandNumberKeyboardView.mKey4.setBackgroundResource(R.drawable.ed);
            appBrandNumberKeyboardView.mKey5.setTextColor(appBrandNumberKeyboardView.getResources().getColor(R.color.ae));
            appBrandNumberKeyboardView.mKey5.setBackgroundResource(R.drawable.ed);
            appBrandNumberKeyboardView.mKey6.setTextColor(appBrandNumberKeyboardView.getResources().getColor(R.color.ae));
            appBrandNumberKeyboardView.mKey6.setBackgroundResource(R.drawable.ed);
            appBrandNumberKeyboardView.mKey7.setTextColor(appBrandNumberKeyboardView.getResources().getColor(R.color.ae));
            appBrandNumberKeyboardView.mKey7.setBackgroundResource(R.drawable.ed);
            appBrandNumberKeyboardView.mKey8.setTextColor(appBrandNumberKeyboardView.getResources().getColor(R.color.ae));
            appBrandNumberKeyboardView.mKey8.setBackgroundResource(R.drawable.ed);
            appBrandNumberKeyboardView.mKey9.setTextColor(appBrandNumberKeyboardView.getResources().getColor(R.color.ae));
            appBrandNumberKeyboardView.mKey9.setBackgroundResource(R.drawable.ed);
            appBrandNumberKeyboardView.mKeyX.setTextColor(appBrandNumberKeyboardView.getResources().getColor(R.color.ae));
            appBrandNumberKeyboardView.mKeyX.setBackgroundResource(R.drawable.ayu);
            appBrandNumberKeyboardView.mKey0.setTextColor(appBrandNumberKeyboardView.getResources().getColor(R.color.ae));
            appBrandNumberKeyboardView.mKey0.setBackgroundResource(R.drawable.ed);
            appBrandNumberKeyboardView.owM.setBackgroundResource(R.drawable.ayu);
            appBrandNumberKeyboardView.jBN.findViewById(R.id.h9a).setBackgroundResource(R.color.BW_BG_100);
            appBrandNumberKeyboardView.jBN.findViewById(R.id.bru).setBackgroundResource(R.color.aa);
            appBrandNumberKeyboardView.jBN.findViewById(R.id.brz).setBackgroundResource(R.color.aa);
            appBrandNumberKeyboardView.jBN.findViewById(R.id.bs0).setBackgroundResource(R.color.aa);
            appBrandNumberKeyboardView.jBN.findViewById(R.id.bs1).setBackgroundResource(R.color.aa);
            appBrandNumberKeyboardView.jBN.findViewById(R.id.bs2).setBackgroundResource(R.color.aa);
            appBrandNumberKeyboardView.jBN.findViewById(R.id.bs3).setBackgroundResource(R.color.aa);
            appBrandNumberKeyboardView.jBN.findViewById(R.id.bs4).setBackgroundResource(R.color.aa);
            appBrandNumberKeyboardView.jBN.findViewById(R.id.bs5).setBackgroundResource(R.color.aa);
            appBrandNumberKeyboardView.jBN.findViewById(R.id.bs6).setBackgroundResource(R.color.aa);
            appBrandNumberKeyboardView.jBN.findViewById(R.id.brv).setBackgroundResource(R.color.aa);
            appBrandNumberKeyboardView.jBN.findViewById(R.id.brw).setBackgroundResource(R.color.aa);
            appBrandNumberKeyboardView.jBN.findViewById(R.id.brx).setBackgroundResource(R.color.aa);
            appBrandNumberKeyboardView.jBN.findViewById(R.id.bry).setBackgroundResource(R.color.aa);
        }
        this.orR = true;
        ac acVar = this.orG.get();
        if (!(acVar == null || acVar.nmX == null)) {
            h.cbe().d(acVar.nmX);
        }
        this.orO.setXMode(this.orM);
        v vVar3 = this.orO;
        s sVar = this.orN;
        if (sVar != null) {
            if (vVar3.mEditText != sVar) {
                vVar3.cbE();
            }
            vVar3.setInputEditText(sVar);
            vVar3.setVisibility(0);
        }
        this.orO.setOnDoneListener(new v.a() {
            /* class com.tencent.mm.plugin.appbrand.widget.input.d.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.widget.input.v.a
            public final void onDone() {
                AppMethodBeat.i(136313);
                d.this.a(d.this.cbn());
                d.this.jg(false);
                AppMethodBeat.o(136313);
            }
        });
        eK(i2, i3);
        k.a(this.orG).Ac(this.orE);
        this.orR = false;
        AppMethodBeat.o(230571);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.aa
    public final boolean cba() {
        AppMethodBeat.i(136322);
        if (cbb() == null) {
            AppMethodBeat.o(136322);
            return false;
        } else if (isFocused()) {
            v vVar = this.orO;
            vVar.setVisibility(8);
            vVar.cbE();
            Log.d("MicroMsg.AppBrandInputComponentAsNumber", "[input_switch] disableInputFocus %s", this.orN);
            if (this.orN != null) {
                this.orN.setFocusable(false);
                this.orN.setFocusableInTouchMode(false);
                this.orN.setEnabled(false);
            }
            ac acVar = this.orG.get();
            if (!(acVar == null || acVar.nmX == null)) {
                h.cbe().e(acVar.nmX);
            }
            k.a(this.orG).Ad(this.orE);
            AppMethodBeat.o(136322);
            return true;
        } else {
            AppMethodBeat.o(136322);
            return false;
        }
    }

    private boolean isFocused() {
        AppMethodBeat.i(136323);
        if (this.orN == null) {
            AppMethodBeat.o(136323);
            return false;
        } else if (this.orN.isFocused()) {
            AppMethodBeat.o(136323);
            return true;
        } else if (cbb() == null) {
            AppMethodBeat.o(136323);
            return false;
        } else if (!cbb().isShown()) {
            AppMethodBeat.o(136323);
            return false;
        } else if (this.orO.getAttachedEditText() == this.orN) {
            AppMethodBeat.o(136323);
            return true;
        } else {
            AppMethodBeat.o(136323);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.widget.input.c
    public final boolean jg(boolean z) {
        AppMethodBeat.i(136324);
        Log.d("MicroMsg.AppBrandInputComponentAsNumber", "[input_switch] onFocusChanged hasFocus %b, isFocused %b", Boolean.valueOf(z), Boolean.valueOf(isFocused()));
        if (!z) {
            if (this.orQ) {
                AppMethodBeat.o(136324);
            } else if (!isFocused()) {
                AppMethodBeat.o(136324);
            } else {
                this.orQ = true;
                a(cbn());
                cba();
                remove();
                this.orQ = false;
                this.orN = null;
                AppMethodBeat.o(136324);
            }
        } else if (this.orR) {
            AppMethodBeat.o(136324);
        } else if (isFocused()) {
            AppMethodBeat.o(136324);
        } else {
            this.orR = true;
            q(-2, -2, this.orS);
            this.orR = false;
            AppMethodBeat.o(136324);
        }
        return true;
    }

    private v cbb() {
        AppMethodBeat.i(136325);
        if (this.orO != null) {
            v vVar = this.orO;
            AppMethodBeat.o(136325);
            return vVar;
        }
        v inputPanel = this.orN.getInputPanel();
        this.orO = inputPanel;
        AppMethodBeat.o(136325);
        return inputPanel;
    }

    /* Return type fixed from 'android.widget.EditText' to match base method */
    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.appbrand.widget.input.c
    public final /* bridge */ /* synthetic */ s caS() {
        return this.orN;
    }
}
