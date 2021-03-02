package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.p.u;
import com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable;
import com.tencent.mm.plugin.appbrand.widget.actionbar.e;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.smtt.sdk.WebView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u000bH\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u001b\u001a\u00020\u000bH\u0016J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0014H\u0014J\b\u0010\u001f\u001a\u00020\u0014H\u0014J\u0018\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000bH\u0014J\b\u0010#\u001a\u00020\u0014H\u0016J\u0012\u0010$\u001a\u00020\u00142\b\u0010%\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u0018H\u0016J\u0010\u0010(\u001a\u00020\u00142\u0006\u0010)\u001a\u00020\u000bH\u0016J\u0012\u0010*\u001a\u00020\u00142\b\u0010%\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010+\u001a\u00020\u00142\u0006\u0010)\u001a\u00020\u000bH\u0016J\u0010\u0010,\u001a\u00020\u00142\u0006\u0010-\u001a\u00020.H\u0016J\u0010\u0010/\u001a\u00020\u00142\u0006\u00100\u001a\u000201H\u0016J\u0012\u00102\u001a\u00020\u00142\b\u00103\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u00104\u001a\u00020\u00142\u0006\u00105\u001a\u000201H\u0016J\u0010\u00106\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\tH\u0016J\u0010\u00107\u001a\u00020\u00142\u0006\u00108\u001a\u000201H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000¨\u00069"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/SimplifiedActionBarForPluginSplash;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/IAppBrandActionBar;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mBackBtn", "Landroid/widget/ImageView;", "mBackBtnClickListener", "Landroid/view/View$OnClickListener;", "mFixedHeight", "", "mForegroundColor", "mMainTitleView", "Landroid/widget/TextView;", "mProgressBar", "Landroid/widget/ProgressBar;", "mProgressLoadingDrawable", "Lcom/tencent/mm/plugin/appbrand/widget/CircleProgressDrawable;", "destroy", "", "getActionView", "Landroid/view/View;", "getBackgroundAlpha", "", "getBackgroundColor", "getCapsuleView", "getForegroundColor", "getMainTitle", "", "onAttachedToWindow", "onDetachedFromWindow", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "resetForegroundStyle", "setBackButtonClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setBackgroundAlpha", "alpha", u.NAME, "color", "setCloseButtonClickListener", "setForegroundColor", "setForegroundStyle", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "", "setLoadingIconVisibility", "visible", "", "setMainTitle", "title", "setNavHidden", "hidden", "setOptionButtonClickListener", "showCapsuleArea", "show", "luggage-wechat-full-sdk_release"})
public final class aj extends LinearLayout implements e {
    private final ProgressBar krF;
    private View.OnClickListener nYX;
    private int nYY = WebView.NIGHT_MODE_COLOR;
    private final int nYZ;
    private final ImageView nZa;
    private final TextView nZb;
    private final CircleProgressDrawable nZc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public aj(Context context) {
        super(context);
        p.h(context, "context");
        AppMethodBeat.i(148221);
        this.nYZ = context.getResources().getDimensionPixelSize(R.dimen.b9);
        setOrientation(0);
        setGravity(16);
        setLayoutParams(new ViewGroup.LayoutParams(-1, this.nYZ));
        ImageView imageView = new ImageView(context);
        imageView.setPadding(context.getResources().getDimensionPixelSize(R.dimen.k5), 0, context.getResources().getDimensionPixelSize(R.dimen.k5), 0);
        imageView.setBackgroundResource(R.drawable.b7);
        imageView.setImageResource(R.drawable.bw7);
        imageView.setId(R.id.e6);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(-2, -1));
        imageView.setOnClickListener(new a(this, context));
        addView(imageView);
        this.nZa = imageView;
        TextView textView = new TextView(context);
        textView.setTextSize(0, (float) context.getResources().getDimensionPixelSize(R.dimen.f3058c));
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setMaxLines(1);
        textView.setGravity(16);
        textView.setId(R.id.eg);
        textView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        addView(textView);
        this.nZb = textView;
        this.nZc = new CircleProgressDrawable(context);
        ProgressBar progressBar = new ProgressBar(new ContextThemeWrapper(context, (int) R.style.a61));
        int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(context, 3);
        progressBar.setPadding(fromDPToPix, fromDPToPix, fromDPToPix, fromDPToPix);
        progressBar.setId(R.id.e3);
        int fromDPToPix2 = com.tencent.mm.cb.a.fromDPToPix(context, 24);
        progressBar.setLayoutParams(new ViewGroup.LayoutParams(fromDPToPix2, fromDPToPix2));
        progressBar.setIndeterminateDrawable(this.nZc);
        addView(progressBar);
        this.krF = progressBar;
        AppMethodBeat.o(148221);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/ui/SimplifiedActionBarForPluginSplash$1$1"})
    static final class a implements View.OnClickListener {
        final /* synthetic */ Context $context$inlined;
        final /* synthetic */ aj nZd;

        a(aj ajVar, Context context) {
            this.nZd = ajVar;
            this.$context$inlined = context;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(148209);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/SimplifiedActionBarForPluginSplash$$special$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            View.OnClickListener onClickListener = this.nZd.nYX;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/SimplifiedActionBarForPluginSplash$$special$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(148209);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.actionbar.e
    public final void destroy() {
        AppMethodBeat.i(230230);
        this.nZc.stop();
        removeAllViews();
        this.nYX = null;
        AppMethodBeat.o(230230);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.actionbar.e
    public final void setBackButtonClickListener(View.OnClickListener onClickListener) {
        this.nYX = onClickListener;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.actionbar.e
    public final void setCloseButtonClickListener(View.OnClickListener onClickListener) {
        this.nYX = onClickListener;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.actionbar.e
    public final void setMainTitle(CharSequence charSequence) {
        AppMethodBeat.i(148211);
        this.nZb.setText(charSequence);
        AppMethodBeat.o(148211);
    }

    public final CharSequence getMainTitle() {
        AppMethodBeat.i(148212);
        CharSequence text = this.nZb.getText();
        AppMethodBeat.o(148212);
        return text;
    }

    public final double getBackgroundAlpha() {
        return 1.0d;
    }

    public final void setBackgroundAlpha(double d2) {
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.actionbar.e
    public final int getBackgroundColor() {
        AppMethodBeat.i(148213);
        Drawable background = super.getBackground();
        if (!(background instanceof ColorDrawable)) {
            background = null;
        }
        ColorDrawable colorDrawable = (ColorDrawable) background;
        if (colorDrawable != null) {
            int color = colorDrawable.getColor();
            AppMethodBeat.o(148213);
            return color;
        }
        AppMethodBeat.o(148213);
        return 0;
    }

    public final void setOptionButtonClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(148214);
        p.h(onClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        AppMethodBeat.o(148214);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.actionbar.e
    public final void gz(boolean z) {
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.actionbar.e
    public final void setForegroundColor(int i2) {
        AppMethodBeat.i(148215);
        this.nYY = i2;
        this.nZa.setColorFilter(this.nYY, PorterDuff.Mode.SRC_ATOP);
        this.nZb.setTextColor(this.nYY);
        this.nZc.setStrokeColor(this.nYY);
        this.krF.setIndeterminateDrawable(this.nZc);
        AppMethodBeat.o(148215);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.actionbar.e
    public final void setForegroundStyle(String str) {
        AppMethodBeat.i(148216);
        p.h(str, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
        setForegroundColor(e.a.afW(str).omu);
        AppMethodBeat.o(148216);
    }

    public final int getForegroundColor() {
        return this.nYY;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.actionbar.e
    public final void setBackgroundColor(int i2) {
        AppMethodBeat.i(230231);
        super.setBackgroundColor(i2);
        if (i2 != 0) {
            setWillNotDraw(false);
            AppMethodBeat.o(230231);
            return;
        }
        setWillNotDraw(true);
        AppMethodBeat.o(230231);
    }

    public final void setNavHidden(boolean z) {
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.actionbar.e
    public final void setLoadingIconVisibility(boolean z) {
        AppMethodBeat.i(148217);
        if (z) {
            this.krF.setVisibility(0);
            this.nZc.cbk();
            if (isAttachedToWindow()) {
                this.nZc.start();
                AppMethodBeat.o(148217);
                return;
            }
        } else {
            this.krF.setVisibility(8);
            this.nZc.stop();
        }
        AppMethodBeat.o(148217);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.actionbar.e
    public final View getActionView() {
        return this;
    }

    public final View getCapsuleView() {
        return null;
    }

    /* access modifiers changed from: protected */
    public final void onAttachedToWindow() {
        AppMethodBeat.i(148218);
        super.onAttachedToWindow();
        if (this.krF.getVisibility() == 0) {
            this.nZc.start();
        }
        AppMethodBeat.o(148218);
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        AppMethodBeat.i(148219);
        super.onDetachedFromWindow();
        this.nZc.stop();
        AppMethodBeat.o(148219);
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i2, int i3) {
        AppMethodBeat.i(148220);
        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(this.nYZ, 1073741824));
        AppMethodBeat.o(148220);
    }
}
