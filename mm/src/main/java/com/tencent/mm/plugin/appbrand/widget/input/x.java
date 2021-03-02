package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.ao;
import com.tencent.mm.plugin.appbrand.widget.input.d.e;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class x extends i {
    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.appbrand.widget.input.i
    public final boolean a(y yVar, e eVar) {
        ac acVar;
        boolean z;
        if (yVar == null) {
            Log.w("MicroMsg.AppBrandTextAreaInvokeHandler", "addInputImpl failed, EditText is null");
            return false;
        }
        int i2 = eVar.orE;
        if (this.Jug == null || (acVar = (ac) this.Jug.get()) == null) {
            Log.w("MicroMsg.AppBrandTextAreaInvokeHandler", "addInputImpl(viewId : %s) failed, pageView is null", Integer.valueOf(i2));
            return false;
        }
        ao aoVar = acVar.nqN;
        if (aoVar == null) {
            Log.w("MicroMsg.AppBrandTextAreaInvokeHandler", "addInputImpl(viewId : %s) failed, CustomViewContainer is null", Integer.valueOf(i2));
            return false;
        }
        int i3 = (eVar.oxZ == null || !eVar.oxZ.booleanValue()) ? 0 : 4;
        int i4 = eVar.oxF;
        float[] fArr = {(float) eVar.oxN.intValue(), (float) eVar.oxM.intValue(), (float) eVar.oxK.intValue(), (float) eVar.oxL.intValue(), 0.0f};
        if (eVar.oyd == null || !eVar.oyd.booleanValue()) {
            z = false;
        } else {
            z = true;
        }
        boolean a2 = aoVar.a(yVar, i2, i4, fArr, i3, z);
        Log.i("MicroMsg.AppBrandTextAreaInvokeHandler", "addInputImpl(viewId : %s) success = %s, ", Integer.valueOf(i2), Boolean.valueOf(a2));
        return a2;
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.appbrand.widget.input.i
    public final boolean b(y yVar, e eVar) {
        ac acVar;
        if (yVar == null) {
            Log.w("MicroMsg.AppBrandTextAreaInvokeHandler", "updateInputPosition failed, EditText is null");
            return false;
        }
        int inputId = yVar.getInputId();
        if (this.Jug == null || (acVar = (ac) this.Jug.get()) == null) {
            Log.w("MicroMsg.AppBrandTextAreaInvokeHandler", "updateInputPosition(viewId : %s) failed, pageView is null", Integer.valueOf(inputId));
            return false;
        }
        ao aoVar = acVar.nqN;
        if (aoVar == null) {
            Log.w("MicroMsg.AppBrandTextAreaInvokeHandler", "updateInputPosition(viewId : %s) failed, CustomViewContainer is null", Integer.valueOf(inputId));
            return false;
        }
        boolean a2 = aoVar.a(inputId, new float[]{(float) eVar.oxN.intValue(), (float) eVar.oxM.intValue(), (float) eVar.oxK.intValue(), (float) eVar.oxL.intValue(), 0.0f}, (eVar.oxZ == null || !eVar.oxZ.booleanValue()) ? 0 : 4, eVar.oyd, Boolean.FALSE);
        Log.i("MicroMsg.AppBrandTextAreaInvokeHandler", "updateInputPosition(viewId : %s) success = %s", Integer.valueOf(inputId), Boolean.valueOf(a2));
        return a2;
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.appbrand.widget.input.i
    public final void a(y yVar) {
        ac acVar;
        if (yVar == null) {
            Log.w("MicroMsg.AppBrandTextAreaInvokeHandler", "removeInputImpl failed, EditText is null");
            return;
        }
        int inputId = yVar.getInputId();
        yVar.b(this.Jua);
        if (this.Jug == null) {
            acVar = null;
        } else {
            acVar = (ac) this.Jug.get();
        }
        if (acVar == null) {
            Log.w("MicroMsg.AppBrandTextAreaInvokeHandler", "removeInputImpl(viewId : %s) failed, pageView is null", Integer.valueOf(inputId));
            return;
        }
        ao aoVar = acVar.nqN;
        if (aoVar == null) {
            Log.w("MicroMsg.AppBrandTextAreaInvokeHandler", "removeInputImpl(viewId : %s) failed, CustomViewContainer is null", Integer.valueOf(inputId));
            return;
        }
        Log.i("MicroMsg.AppBrandTextAreaInvokeHandler", "removeInputImpl(viewId : %s) success = %s", Integer.valueOf(inputId), Boolean.valueOf(aoVar.wF(inputId)));
    }
}
