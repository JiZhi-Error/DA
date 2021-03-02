package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import com.tencent.kinda.gen.DynamicColor;
import com.tencent.kinda.gen.KImage;
import com.tencent.kinda.gen.KSwitchView;
import com.tencent.kinda.gen.KSwitchViewOnChangeSwitchCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMSwitchBtn;

public class KindaSwitchViewImpl extends MMKView<MMSwitchBtn> implements KSwitchView {
    private MMSwitchBtn mmSwitchBtn;
    private KSwitchViewOnChangeSwitchCallback onChangeSwitchCallback;

    @Override // com.tencent.kinda.framework.widget.base.MMKView
    public MMSwitchBtn createView(Context context) {
        AppMethodBeat.i(18966);
        this.mmSwitchBtn = new MMSwitchBtn(context);
        MMSwitchBtn mMSwitchBtn = this.mmSwitchBtn;
        AppMethodBeat.o(18966);
        return mMSwitchBtn;
    }

    @Override // com.tencent.kinda.gen.KSwitchView
    public void setOnTintColor(DynamicColor dynamicColor) {
    }

    @Override // com.tencent.kinda.gen.KSwitchView
    public DynamicColor getOnTintColor() {
        return null;
    }

    @Override // com.tencent.kinda.gen.KSwitchView
    public void setTintColor(DynamicColor dynamicColor) {
    }

    @Override // com.tencent.kinda.gen.KSwitchView
    public DynamicColor getTintColor() {
        return null;
    }

    @Override // com.tencent.kinda.gen.KSwitchView
    public void setThumbTintColor(DynamicColor dynamicColor) {
    }

    @Override // com.tencent.kinda.gen.KSwitchView
    public DynamicColor getThumbTintColor() {
        return null;
    }

    @Override // com.tencent.kinda.gen.KSwitchView
    public void setOnImage(KImage kImage) {
    }

    @Override // com.tencent.kinda.gen.KSwitchView
    public KImage getOnImage() {
        return null;
    }

    @Override // com.tencent.kinda.gen.KSwitchView
    public void setOffImage(KImage kImage) {
    }

    @Override // com.tencent.kinda.gen.KSwitchView
    public KImage getOffImage() {
        return null;
    }

    @Override // com.tencent.kinda.gen.KSwitchView
    public void setOn(boolean z) {
        AppMethodBeat.i(18967);
        this.mmSwitchBtn.setCheck(z);
        AppMethodBeat.o(18967);
    }

    @Override // com.tencent.kinda.gen.KSwitchView
    public boolean getOn() {
        return this.mmSwitchBtn.QDw;
    }

    @Override // com.tencent.kinda.gen.KSwitchView
    public void setEnabled(boolean z) {
        AppMethodBeat.i(18968);
        this.mmSwitchBtn.setEnabled(z);
        AppMethodBeat.o(18968);
    }

    @Override // com.tencent.kinda.gen.KSwitchView
    public boolean getEnabled() {
        AppMethodBeat.i(18969);
        boolean isEnabled = this.mmSwitchBtn.isEnabled();
        AppMethodBeat.o(18969);
        return isEnabled;
    }

    @Override // com.tencent.kinda.gen.KSwitchView
    public void setOnChangeSwitchCallback(final KSwitchViewOnChangeSwitchCallback kSwitchViewOnChangeSwitchCallback) {
        AppMethodBeat.i(18970);
        this.mmSwitchBtn.setSwitchListener(new MMSwitchBtn.a() {
            /* class com.tencent.kinda.framework.widget.base.KindaSwitchViewImpl.AnonymousClass1 */

            @Override // com.tencent.mm.ui.widget.MMSwitchBtn.a
            public void onStatusChange(boolean z) {
                AppMethodBeat.i(18965);
                kSwitchViewOnChangeSwitchCallback.onChangeSwitch();
                AppMethodBeat.o(18965);
            }
        });
        AppMethodBeat.o(18970);
    }
}
