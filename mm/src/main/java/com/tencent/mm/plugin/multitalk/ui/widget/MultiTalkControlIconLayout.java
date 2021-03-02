package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.multitalk.a;
import com.tencent.mm.plugin.voip.ui.MMCheckBox;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.at;
import com.tencent.smtt.sdk.WebView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\nJ\u0006\u0010\u001e\u001a\u00020\u0016J\b\u0010\u001f\u001a\u00020\u001cH\u0002J\u000e\u0010 \u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0016J\u000e\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u0016J\u0012\u0010#\u001a\u00020\u001c2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0001X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkControlIconLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "checkBox", "Lcom/tencent/mm/plugin/voip/ui/MMCheckBox;", "forbiddenDrawable", "", "iconBg", "iconDrawable", "iconIv", "Landroid/widget/ImageView;", "iconSize", "", "iconText", "", "iconTv", "Landroid/widget/TextView;", "initStaus", "", "mIconMainView", "mRootView", "Landroid/view/View;", "textColor", "applyDeviceOrientataionChange", "", "orientation", "isChecked", "onClickCalled", "setChecked", "setIconEnabled", "enable", "setOnClickListener", "l", "Landroid/view/View$OnClickListener;", "plugin-multitalk_release"})
public final class MultiTalkControlIconLayout extends FrameLayout {
    private ImageView gBZ;
    private View jBN;
    private int textColor;
    MMCheckBox zRU;
    private TextView zRV;
    private FrameLayout zRW;
    private String zRX;
    private int zRY;
    private int zRZ;
    private boolean zSa;
    private float zSb;
    private int zSc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MultiTalkControlIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        p.h(attributeSet, "attributeSet");
        AppMethodBeat.i(178976);
        View inflate = LayoutInflater.from(context).inflate(R.layout.bcn, this);
        p.g(inflate, "LayoutInflater.from(cont…italk_icons_layout, this)");
        this.jBN = inflate;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C1485a.MultitalkControlIconStyle);
        String string = obtainStyledAttributes.getString(4);
        this.zRX = string == null ? "" : string;
        this.zRY = obtainStyledAttributes.getResourceId(2, -1);
        this.textColor = obtainStyledAttributes.getInteger(5, -1);
        this.zSa = obtainStyledAttributes.getBoolean(6, false);
        this.zRZ = obtainStyledAttributes.getResourceId(0, -1);
        this.zSb = obtainStyledAttributes.getDimension(3, -1.0f);
        this.zSc = obtainStyledAttributes.getResourceId(1, -1);
        obtainStyledAttributes.recycle();
        View findViewById = findViewById(R.id.dtl);
        p.g(findViewById, "findViewById(R.id.icon_checkbox)");
        this.zRU = (MMCheckBox) findViewById;
        View findViewById2 = findViewById(R.id.dtx);
        p.g(findViewById2, "findViewById(R.id.icon_iv)");
        this.gBZ = (ImageView) findViewById2;
        if (this.zRY != -1) {
            if (this.zSa) {
                this.gBZ.setImageDrawable(ar.m(context, this.zRY, WebView.NIGHT_MODE_COLOR));
            } else {
                this.gBZ.setImageDrawable(ar.m(context, this.zRY, -1));
            }
        }
        View findViewById3 = findViewById(R.id.du3);
        p.g(findViewById3, "findViewById(R.id.icon_name)");
        this.zRV = (TextView) findViewById3;
        this.zRV.setText(this.zRX);
        this.zRV.setTextColor(this.textColor);
        View findViewById4 = findViewById(R.id.du1);
        p.g(findViewById4, "findViewById(R.id.icon_main)");
        this.zRW = (FrameLayout) findViewById4;
        if (this.zSb != -1.0f) {
            this.zRW.setLayoutParams(new RelativeLayout.LayoutParams(at.fromDPToPix(context, (int) this.zSb), at.fromDPToPix(context, (int) this.zSb)));
        }
        if (this.zSc != -1) {
            this.zRW.setBackground(getResources().getDrawable(this.zSc));
        }
        AppMethodBeat.o(178976);
    }

    public final void setOnClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(178973);
        this.zRU.setOnClickListener(onClickListener);
        AppMethodBeat.o(178973);
    }

    public final void setChecked(boolean z) {
        Drawable m;
        AppMethodBeat.i(178974);
        this.zRU.setChecked(z);
        this.zRW.setSelected(z);
        if (this.zRY != -1) {
            if (this.zRU.isChecked()) {
                if (!this.zSa) {
                    m = ar.m(getContext(), this.zRY, WebView.NIGHT_MODE_COLOR);
                }
                m = ar.m(getContext(), this.zRZ, -1);
            } else {
                if (this.zSa) {
                    m = ar.m(getContext(), this.zRY, WebView.NIGHT_MODE_COLOR);
                }
                m = ar.m(getContext(), this.zRZ, -1);
            }
            this.gBZ.setImageDrawable(m);
        }
        AppMethodBeat.o(178974);
    }

    public final void setIconEnabled(boolean z) {
        AppMethodBeat.i(178975);
        if (z) {
            this.jBN.setAlpha(1.0f);
            AppMethodBeat.o(178975);
            return;
        }
        this.jBN.setAlpha(0.3f);
        AppMethodBeat.o(178975);
    }

    public final void Rr(int i2) {
        AppMethodBeat.i(239784);
        this.gBZ.setRotation(360.0f - ((float) i2));
        AppMethodBeat.o(239784);
    }
}
