package com.tencent.mm.plugin.appbrand.af;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.ui.af;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.a.a;
import kotlin.x;

@SuppressLint({"ViewConstructor"})
public final class b extends FrameLayout implements af {
    private AppBrandRuntime kEc;
    private ImageView ojE;
    private View ojI;
    private com.tencent.mm.plugin.appbrand.widget.actionbar.b ojJ;
    private boolean ojK = false;
    private boolean ojL = false;
    private a<x> ojM = null;
    private boolean ojN = false;

    public b(Context context, AppBrandRuntime appBrandRuntime) {
        super(context);
        AppMethodBeat.i(49339);
        this.kEc = appBrandRuntime;
        setClickable(true);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        LayoutInflater.from(getContext()).inflate(R.layout.fs, this);
        this.ojI = findViewById(R.id.i3p);
        this.ojE = (ImageView) findViewById(R.id.im6);
        this.ojJ = new com.tencent.mm.plugin.appbrand.widget.actionbar.b(getContext());
        this.ojJ.setFullscreenMode(true);
        ((LinearLayout) findViewById(R.id.pb)).addView(this.ojJ.getActionView());
        this.ojJ.setNavResetStyleListener(new b.a() {
            /* class com.tencent.mm.plugin.appbrand.af.b.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.widget.actionbar.b.a
            public final void a(ImageView imageView, View view, View view2) {
                AppMethodBeat.i(49334);
                if (imageView != null) {
                    imageView.clearColorFilter();
                    Log.i("MicroMsg.AppBrandThumbLoadingSplash", "[weishi] set close button");
                    imageView.setImageDrawable(com.tencent.mm.svg.a.a.h(b.this.getContext().getResources(), R.raw.app_brand_weishi_video_btn_close));
                    ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                    layoutParams.height = -1;
                    layoutParams.width = -2;
                    imageView.setLayoutParams(layoutParams);
                }
                if (view != null) {
                    view.setBackground(null);
                }
                AppMethodBeat.o(49334);
            }

            @Override // com.tencent.mm.plugin.appbrand.widget.actionbar.b.a
            public final int bQz() {
                return omi;
            }
        });
        this.ojJ.setFullscreenMode(true);
        this.ojJ.setForegroundStyle(false);
        this.ojJ.gz(false);
        this.ojJ.gx(true);
        this.ojJ.setBackButtonClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.af.b.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(49335);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/weishi/AppBrandThumbLoadingSplash$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.AppBrandThumbLoadingSplash", "[weishi] splash click close button");
                g.bZS();
                if (b.this.kEc != null) {
                    h.a(b.this.kEc.mAppId, h.d.CLOSE);
                    b.this.kEc.close();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/weishi/AppBrandThumbLoadingSplash$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(49335);
            }
        });
        g.a(this.kEc, this.ojE, null);
        AppMethodBeat.o(49339);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.ab
    public final void z(final a<x> aVar) {
        AppMethodBeat.i(227743);
        post(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.af.b.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(49338);
                final ViewParent parent = b.this.getParent();
                if (!(parent instanceof ViewGroup)) {
                    AppMethodBeat.o(49338);
                    return;
                }
                ValueAnimator ofInt = ValueAnimator.ofInt(255, 0);
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    /* class com.tencent.mm.plugin.appbrand.af.b.AnonymousClass3.AnonymousClass1 */

                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        AppMethodBeat.i(49337);
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        b.this.ojI.setBackgroundColor(Color.argb(intValue, 0, 0, 0));
                        if (intValue == 0) {
                            b.this.post(new Runnable() {
                                /* class com.tencent.mm.plugin.appbrand.af.b.AnonymousClass3.AnonymousClass1.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(49336);
                                    b.this.setVisibility(8);
                                    ((ViewGroup) parent).removeView(b.this);
                                    if (aVar != null) {
                                        aVar.invoke();
                                    }
                                    AppMethodBeat.o(49336);
                                }
                            });
                        }
                        AppMethodBeat.o(49337);
                    }
                });
                ofInt.setStartDelay((long) Math.round(((float) ofInt.getDuration()) * 0.8f));
                ofInt.setDuration((long) Math.round(((float) ofInt.getDuration()) * 0.2f));
                ofInt.setInterpolator(new android.support.v4.view.b.a());
                ofInt.start();
                AppMethodBeat.o(49338);
            }
        });
        AppMethodBeat.o(227743);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.af
    public final void k(boolean z, String str) {
        AppMethodBeat.i(227744);
        bZQ();
        AppMethodBeat.o(227744);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.af
    public final void bWI() {
        AppMethodBeat.i(227745);
        bZQ();
        AppMethodBeat.o(227745);
    }

    private void bZQ() {
        AppMethodBeat.i(227746);
        Log.i("MicroMsg.AppBrandThumbLoadingSplash", "[weishi] markCanHide, alreadyHide: %b, hideFromRuntime: %b", Boolean.valueOf(this.ojN), Boolean.valueOf(this.ojL));
        if (this.ojN) {
            AppMethodBeat.o(227746);
        } else if (this.ojL) {
            z(this.ojM);
            this.ojN = true;
            AppMethodBeat.o(227746);
        } else {
            this.ojK = true;
            AppMethodBeat.o(227746);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.af
    public final void B(a<x> aVar) {
        AppMethodBeat.i(227747);
        Log.i("MicroMsg.AppBrandThumbLoadingSplash", "[weishi] hideLoadingSplashFromRuntime, alreadyHide: %b, canHide: %b", Boolean.valueOf(this.ojN), Boolean.valueOf(this.ojK));
        if (this.ojN) {
            AppMethodBeat.o(227747);
        } else if (this.ojK) {
            z(aVar);
            this.ojN = true;
            AppMethodBeat.o(227747);
        } else {
            this.ojL = true;
            this.ojM = aVar;
            AppMethodBeat.o(227747);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.ab
    public final void eo(String str, String str2) {
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.ab
    public final View getView() {
        return this;
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.ab
    public final void setProgress(int i2) {
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.ab
    public final void yu(int i2) {
    }
}
