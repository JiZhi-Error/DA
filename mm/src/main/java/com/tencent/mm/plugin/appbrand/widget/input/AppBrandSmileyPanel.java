package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.compatible.util.i;
import com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyPanelBase;
import com.tencent.mm.plugin.appbrand.widget.input.panel.c;
import com.tencent.mm.plugin.appbrand.widget.input.panel.e;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.Log;

public final class AppBrandSmileyPanel extends AppBrandSmileyPanelBase implements e {
    private boolean mInLayout = false;
    private int otX = -1;
    private int otY = -1;

    public AppBrandSmileyPanel(Context context) {
        super(context);
    }

    public AppBrandSmileyPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private int getPanelHeightInLandscape() {
        AppMethodBeat.i(49896);
        getManager();
        int[] ccp = c.ccp();
        if (this.otY <= 0 || this.otY >= ccp[1]) {
            int min = (Math.min(ccp[0], ccp[1]) / 2) - getContext().getResources().getDimensionPixelSize(R.dimen.ag);
            AppMethodBeat.o(49896);
            return min;
        }
        int i2 = this.otY;
        AppMethodBeat.o(49896);
        return i2;
    }

    private int getPanelDefaultHeightInPort() {
        AppMethodBeat.i(49897);
        if (this.otX < 0) {
            this.otX = KeyBoardUtil.getValidPanelHeight(getContext());
        }
        if (this.otX > 0) {
            int i2 = this.otX;
            AppMethodBeat.o(49897);
            return i2;
        }
        getManager();
        int[] ccp = c.ccp();
        int max = (Math.max(ccp[0], ccp[1]) / 2) - getContext().getResources().getDimensionPixelSize(R.dimen.ag);
        this.otX = max;
        AppMethodBeat.o(49897);
        return max;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.panel.e
    public final View getPanelView() {
        return this;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.panel.e
    public final boolean Af(int i2) {
        if (i2 <= 0 || this.otY == i2) {
            return false;
        }
        this.otY = i2;
        return true;
    }

    public final int getForcedPanelHeight() {
        return this.otY;
    }

    public final int getAppropriateHeightInPort() {
        AppMethodBeat.i(49898);
        if (this.otY > 0) {
            int i2 = this.otY;
            AppMethodBeat.o(49898);
            return i2;
        }
        int panelDefaultHeightInPort = getPanelDefaultHeightInPort();
        AppMethodBeat.o(49898);
        return panelDefaultHeightInPort;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyPanelBase
    public final c cbG() {
        AppMethodBeat.i(49899);
        ak akVar = new ak();
        AppMethodBeat.o(49899);
        return akVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyPanelBase
    public final void onMeasure(int i2, int i3) {
        AppMethodBeat.i(49900);
        if (!isShown()) {
            eM(i2, View.MeasureSpec.makeMeasureSpec(0, Integer.MIN_VALUE));
            AppMethodBeat.o(49900);
            return;
        }
        eM(i2, View.MeasureSpec.makeMeasureSpec(!i.isPortOrientation(getContext()) ? getPanelHeightInLandscape() : getAppropriateHeightInPort(), 1073741824));
        AppMethodBeat.o(49900);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyPanelBase
    public final void setVisibility(int i2) {
        AppMethodBeat.i(49901);
        Ai(i2);
        if (i2 == 0) {
            initView();
        }
        AppMethodBeat.o(49901);
    }

    /* access modifiers changed from: protected */
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(49902);
        this.mInLayout = true;
        super.onLayout(z, i2, i3, i4, i5);
        this.mInLayout = false;
        AppMethodBeat.o(49902);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.panel.e
    public final boolean cbH() {
        AppMethodBeat.i(49903);
        if (d.oD(18)) {
            boolean isInLayout = super.isInLayout();
            AppMethodBeat.o(49903);
            return isInLayout;
        }
        boolean z = this.mInLayout;
        AppMethodBeat.o(49903);
        return z;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.ac
    public final boolean cbD() {
        AppMethodBeat.i(49904);
        Log.d("MicroMsg.AppBrandSmileyPanel", "[scrollUp] isRealHeightSettled, mForcePanelHeight %d, height %d, measuredHeight %d", Integer.valueOf(this.otY), Integer.valueOf(getHeight()), Integer.valueOf(getMeasuredHeight()));
        if (this.otY <= 0 || this.otY != getMeasuredHeight()) {
            AppMethodBeat.o(49904);
            return false;
        }
        AppMethodBeat.o(49904);
        return true;
    }
}
