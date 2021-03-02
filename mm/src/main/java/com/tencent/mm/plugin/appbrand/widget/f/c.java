package com.tencent.mm.plugin.appbrand.widget.f;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.svg.a.a;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.statusbar.d;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\f\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/widget/prompt/AppBrandPopupToast;", "Lcom/tencent/mm/ui/base/MMPopupWindow;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mIconImage", "Landroid/widget/ImageView;", "mMessageText", "Landroid/widget/TextView;", "setIconDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "setMessage", "message", "", "show", "", "plugin-appbrand-integration_release"})
public final class c extends p {
    private final TextView oBD;
    private final ImageView oBE;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(Context context) {
        super(context);
        kotlin.g.b.p.h(context, "context");
        AppMethodBeat.i(51450);
        FrameLayout frameLayout = new FrameLayout(context);
        View.inflate(context, R.layout.fo, frameLayout);
        setContentView(frameLayout);
        View findViewById = getContentView().findViewById(R.id.gl7);
        kotlin.g.b.p.g(findViewById, "contentView.findViewById<View>(R.id.progress)");
        findViewById.setVisibility(8);
        View findViewById2 = getContentView().findViewById(R.id.e4p);
        kotlin.g.b.p.g(findViewById2, "contentView.findViewById(R.id.iv_icon)");
        this.oBE = (ImageView) findViewById2;
        View findViewById3 = getContentView().findViewById(R.id.ipm);
        kotlin.g.b.p.g(findViewById3, "contentView.findViewById(R.id.title)");
        this.oBD = (TextView) findViewById3;
        Drawable h2 = a.h(context.getResources(), R.raw.app_brand_show_toast_success);
        this.oBE.setVisibility(0);
        this.oBE.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.oBE.setImageDrawable(h2);
        AppMethodBeat.o(51450);
    }

    public final c K(CharSequence charSequence) {
        AppMethodBeat.i(51448);
        if (!(charSequence == null || charSequence.length() == 0)) {
            this.oBD.setLineSpacing(0.0f, 1.0f);
            TextView textView = this.oBD;
            View contentView = getContentView();
            kotlin.g.b.p.g(contentView, "contentView");
            textView.setSpannableFactory(new e(com.tencent.mm.cb.a.fromDPToPix(contentView.getContext(), 18)));
            this.oBD.setText(charSequence, TextView.BufferType.SPANNABLE);
            this.oBD.setVisibility(0);
            View contentView2 = getContentView();
            kotlin.g.b.p.g(contentView2, "contentView");
            getContentView().findViewById(R.id.hr_).setPadding(0, com.tencent.mm.cb.a.fromDPToPix(contentView2.getContext(), 27), 0, 0);
        } else {
            this.oBD.setVisibility(4);
        }
        AppMethodBeat.o(51448);
        return this;
    }

    public final void show() {
        AppMethodBeat.i(51449);
        View contentView = getContentView();
        kotlin.g.b.p.g(contentView, "contentView");
        Activity kD = d.kD(contentView.getContext());
        if (kD != null) {
            super.showAtLocation(kD.findViewById(16908290), 17, 0, 0);
            MMHandlerThread.postToMainThreadDelayed(new d(this), 1500);
            AppMethodBeat.o(51449);
            return;
        }
        AppMethodBeat.o(51449);
    }
}
