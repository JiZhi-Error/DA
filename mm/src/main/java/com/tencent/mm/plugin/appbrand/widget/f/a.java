package com.tencent.mm.plugin.appbrand.widget.f;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class a extends FrameLayout implements View.OnClickListener, f {
    private final MMHandler mHandler = new MMHandler(Looper.getMainLooper());
    private TextView oBs;
    private final Runnable oBt = new Runnable() {
        /* class com.tencent.mm.plugin.appbrand.widget.f.a.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(135483);
            a aVar = a.this;
            if (aVar.getAlpha() == 0.0f || aVar.oBv != null) {
                AppMethodBeat.o(135483);
                return;
            }
            aVar.animate().cancel();
            ViewPropertyAnimator animate = aVar.animate();
            aVar.oBv = animate;
            animate.alpha(0.0f).setListener(new AnimatorListenerAdapter() {
                /* class com.tencent.mm.plugin.appbrand.widget.f.a.AnonymousClass3 */

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(135486);
                    a.this.setVisibility(8);
                    a.this.oBv = null;
                    AppMethodBeat.o(135486);
                }

                public final void onAnimationCancel(Animator animator) {
                    AppMethodBeat.i(135487);
                    a.this.oBv = null;
                    AppMethodBeat.o(135487);
                }
            }).start();
            AppMethodBeat.o(135483);
        }
    };
    private ViewPropertyAnimator oBu;
    ViewPropertyAnimator oBv;

    public a(Context context) {
        super(context);
        AppMethodBeat.i(135488);
        LayoutInflater.from(context).inflate(R.layout.fn, (ViewGroup) this, true);
        this.oBs = (TextView) findViewById(R.id.ipm);
        setOnClickListener(this);
        AppMethodBeat.o(135488);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.f.f
    public final void agi(String str) {
        AppMethodBeat.i(135489);
        this.oBs.setText(str);
        this.mHandler.removeCallbacks(this.oBt);
        this.mHandler.postDelayed(this.oBt, oBF);
        if (getAlpha() == 1.0f || this.oBu != null) {
            AppMethodBeat.o(135489);
            return;
        }
        setVisibility(0);
        animate().cancel();
        ViewPropertyAnimator animate = animate();
        this.oBu = animate;
        animate.alpha(1.0f).setListener(new AnimatorListenerAdapter() {
            /* class com.tencent.mm.plugin.appbrand.widget.f.a.AnonymousClass2 */

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(135484);
                a.this.oBu = null;
                AppMethodBeat.o(135484);
            }

            public final void onAnimationCancel(Animator animator) {
                AppMethodBeat.i(135485);
                a.this.oBu = null;
                AppMethodBeat.o(135485);
            }
        }).start();
        setVisibility(0);
        AppMethodBeat.o(135489);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.f.f
    public final void c(FrameLayout frameLayout) {
        AppMethodBeat.i(135490);
        frameLayout.addView(this, new FrameLayout.LayoutParams(-2, -2, 17));
        AppMethodBeat.o(135490);
    }

    public final void onClick(View view) {
        AppMethodBeat.i(135491);
        b bVar = new b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/prompt/AppBrandNewBanAlert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/prompt/AppBrandNewBanAlert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(135491);
    }
}
