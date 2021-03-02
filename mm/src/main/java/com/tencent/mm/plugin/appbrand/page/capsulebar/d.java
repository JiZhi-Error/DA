package com.tencent.mm.plugin.appbrand.page.capsulebar;

import android.content.Context;
import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.page.bz;
import com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandCapsuleHomeButton;
import com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandOptionButton;
import com.tencent.smtt.sdk.WebView;

public final class d extends FrameLayout implements bz, g {
    private int nvb = 0;
    private AppBrandOptionButton nvc;
    private AppBrandCapsuleHomeButton nvd;
    private LinearLayout nve;
    private View nvf;
    public View nvg;

    public d(Context context) {
        super(context);
        AppMethodBeat.i(219479);
        LayoutInflater.from(context).inflate(R.layout.de, this);
        this.nvc = (AppBrandOptionButton) findViewById(R.id.dy);
        this.nvd = (AppBrandCapsuleHomeButton) findViewById(R.id.dx);
        this.nve = (LinearLayout) findViewById(R.id.du);
        this.nvf = findViewById(R.id.dw);
        this.nvc.setAccessibilityLabel(getContext().getString(R.string.ho));
        this.nvd.setAccessibilityLabel(getContext().getString(R.string.hk));
        AppMethodBeat.o(219479);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bz
    public final boolean c(Canvas canvas) {
        AppMethodBeat.i(219480);
        draw(canvas);
        AppMethodBeat.o(219480);
        return true;
    }

    public final void setStyleColor(int i2) {
        AppMethodBeat.i(219481);
        if (i2 == this.nvb) {
            AppMethodBeat.o(219481);
            return;
        }
        if (i2 == -1) {
            this.nvb = -1;
            this.nvf.setBackgroundResource(R.color.cu);
            this.nve.setBackgroundResource(R.drawable.cy);
            this.nvc.setColor(-1);
            this.nvd.setColor(-1);
        } else {
            this.nvb = WebView.NIGHT_MODE_COLOR;
            this.nvf.setBackgroundResource(R.color.cv);
            this.nve.setBackgroundResource(R.drawable.cz);
            this.nvc.setColor(WebView.NIGHT_MODE_COLOR);
            this.nvd.setColor(WebView.NIGHT_MODE_COLOR);
        }
        if (this.nvg != null) {
            this.nvg.animate().cancel();
            removeView(this.nvg);
        }
        AppMethodBeat.o(219481);
    }

    public final View getCapsuleContentAreaView() {
        return this.nve;
    }

    public final AppBrandOptionButton getOptionBtn() {
        return this.nvc;
    }

    public final AppBrandCapsuleHomeButton getCapsuleHomeButton() {
        return this.nvd;
    }

    public final void setHomeButtonOnClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(219482);
        this.nvd.setOnClickListener(onClickListener);
        AppMethodBeat.o(219482);
    }

    public final void setOptionButtonOnClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(219483);
        this.nvc.setOnClickListener(onClickListener);
        AppMethodBeat.o(219483);
    }
}
