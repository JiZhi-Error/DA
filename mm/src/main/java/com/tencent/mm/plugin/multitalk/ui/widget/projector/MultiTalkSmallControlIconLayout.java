package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.multitalk.a;
import com.tencent.mm.ui.ar;
import com.tencent.smtt.sdk.WebView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0018\u001a\u00020\u000fJ\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u000e\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u000fJ\u000e\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u000fR\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/MultiTalkSmallControlIconLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "forbiddenDrawable", "", "iconDrawable", "iconIv", "Landroid/widget/ImageView;", "iconSize", "", "initStaus", "", "isChceked", "()Z", "setChceked", "(Z)V", "mRootView", "Landroid/view/View;", "singleStatus", "textColor", "isChecked", "onClickCalled", "", "setChecked", "setIconEnabled", "enable", "plugin-multitalk_release"})
public final class MultiTalkSmallControlIconLayout extends FrameLayout {
    private ImageView gBZ;
    private View jBN;
    private int textColor;
    private int zRY;
    private int zRZ;
    private boolean zSa;
    private float zSb;
    private boolean zVG;
    boolean zVH;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MultiTalkSmallControlIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        p.h(attributeSet, "attributeSet");
        AppMethodBeat.i(239899);
        View inflate = LayoutInflater.from(context).inflate(R.layout.bdf, this);
        p.g(inflate, "LayoutInflater.from(cont…small_icons_layout, this)");
        this.jBN = inflate;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C1485a.MultitalkControlIconStyle);
        this.zRY = obtainStyledAttributes.getResourceId(2, -1);
        this.textColor = obtainStyledAttributes.getInteger(5, -1);
        this.zSa = obtainStyledAttributes.getBoolean(6, false);
        this.zRZ = obtainStyledAttributes.getResourceId(0, -1);
        this.zSb = obtainStyledAttributes.getDimension(3, -1.0f);
        this.zVG = obtainStyledAttributes.getBoolean(7, false);
        obtainStyledAttributes.recycle();
        View findViewById = findViewById(R.id.dtx);
        p.g(findViewById, "findViewById(R.id.icon_iv)");
        this.gBZ = (ImageView) findViewById;
        if (this.zRY != -1) {
            if (this.zSa) {
                this.gBZ.setImageDrawable(ar.m(context, this.zRY, WebView.NIGHT_MODE_COLOR));
                AppMethodBeat.o(239899);
                return;
            }
            this.gBZ.setImageDrawable(ar.m(context, this.zRY, -1));
        }
        AppMethodBeat.o(239899);
    }

    public final void setChceked(boolean z) {
        this.zVH = z;
    }

    public final void setChecked(boolean z) {
        Drawable m;
        AppMethodBeat.i(239897);
        this.zVH = z;
        setSelected(z);
        if (!this.zVG || !z) {
            if (this.zRY != -1) {
                if (this.zVH) {
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
            AppMethodBeat.o(239897);
            return;
        }
        AppMethodBeat.o(239897);
    }

    public final void setIconEnabled(boolean z) {
        AppMethodBeat.i(239898);
        if (z) {
            this.jBN.setAlpha(1.0f);
            AppMethodBeat.o(239898);
            return;
        }
        this.jBN.setAlpha(0.3f);
        AppMethodBeat.o(239898);
    }
}
