package com.tencent.mm.plugin.appbrand.widget.picker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.utils.a;
import com.tencent.mm.plugin.appbrand.utils.ac;
import com.tencent.mm.plugin.appbrand.utils.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class c extends FrameLayout {
    private boolean isAnimating;
    TextView mMg;
    private com.tencent.mm.plugin.appbrand.jsapi.r.c ozH;
    private FrameLayout ozI;
    View ozJ;
    View ozK;
    View ozL;
    private a ozM;
    private boolean ozN;
    private View ozO;
    View ozP;
    private b ozQ;
    private q ozR = null;

    public interface a<T> {
        void a(boolean z, T t);
    }

    public interface b<T> {
        void cH(T t);
    }

    static /* synthetic */ void a(c cVar, boolean z, Object obj) {
        AppMethodBeat.i(193742);
        cVar.b(z, obj);
        AppMethodBeat.o(193742);
    }

    static /* synthetic */ void c(c cVar) {
        AppMethodBeat.i(193740);
        cVar.ccu();
        AppMethodBeat.o(193740);
    }

    static /* synthetic */ void d(c cVar) {
        AppMethodBeat.i(193741);
        cVar.cct();
        AppMethodBeat.o(193741);
    }

    public void setOnResultListener(a aVar) {
        this.ozM = aVar;
    }

    public void setOnValueUpdateListener(b bVar) {
        this.ozQ = bVar;
    }

    private void ccs() {
        this.ozM = null;
        this.ozQ = null;
    }

    private void b(boolean z, Object obj) {
        AppMethodBeat.i(138048);
        if (!this.ozN && this.ozM != null) {
            this.ozN = true;
            this.ozM.a(z, obj);
            this.ozN = false;
        }
        AppMethodBeat.o(138048);
    }

    public c(Context context) {
        super(context);
        AppMethodBeat.i(138049);
        setClickable(true);
        setLongClickable(true);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.ozO = LayoutInflater.from(getContext()).inflate(R.layout.el, (ViewGroup) this, false);
        this.ozI = (FrameLayout) this.ozO.findViewById(R.id.q0);
        this.ozP = this.ozO.findViewById(R.id.py);
        this.ozK = this.ozO.findViewById(R.id.gbx);
        this.ozL = this.ozK.findViewById(R.id.j7a);
        ccu();
        this.ozK.findViewById(R.id.ae9).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.widget.picker.c.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(138044);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/picker/AppBrandPickerBottomPanelBase$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                c.a(c.this, true, c.this.ozH == null ? null : c.this.ozH.currentValue());
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/picker/AppBrandPickerBottomPanelBase$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(138044);
            }
        });
        this.ozK.findViewById(R.id.ae8).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.widget.picker.c.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(138045);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/picker/AppBrandPickerBottomPanelBase$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                c.a(c.this, false, null);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/picker/AppBrandPickerBottomPanelBase$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(138045);
            }
        });
        this.ozK.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.widget.picker.c.AnonymousClass6 */

            public final void onClick(View view) {
                AppMethodBeat.i(138046);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/picker/AppBrandPickerBottomPanelBase$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/picker/AppBrandPickerBottomPanelBase$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(138046);
            }
        });
        View findViewById = this.ozO.findViewById(R.id.q0);
        findViewById.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.widget.picker.c.AnonymousClass7 */

            public final void onClick(View view) {
                AppMethodBeat.i(138047);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/picker/AppBrandPickerBottomPanelBase$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/picker/AppBrandPickerBottomPanelBase$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(138047);
            }
        });
        findViewById.setBackgroundColor(android.support.v4.content.b.n(findViewById.getContext(), R.color.f3048f));
        addView(this.ozO, layoutParams);
        this.mMg = (TextView) findViewById(R.id.px);
        this.mMg.setClickable(true);
        this.ozJ = findViewById(R.id.pw);
        addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            /* class com.tencent.mm.plugin.appbrand.widget.picker.c.AnonymousClass3 */

            public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                AppMethodBeat.i(138043);
                c.c(c.this);
                c.d(c.this);
                AppMethodBeat.o(138043);
            }
        });
        AppMethodBeat.o(138049);
    }

    /* access modifiers changed from: protected */
    public void setPickerImpl(com.tencent.mm.plugin.appbrand.jsapi.r.c cVar) {
        AppMethodBeat.i(138050);
        if (this.ozH != null) {
            this.ozH.onDetach(this);
        }
        this.ozH = cVar;
        if (this.ozH != null) {
            this.ozH.onAttach(this);
        }
        if (this.ozI == null || this.ozH == null || this.ozH.getView() == null) {
            AppMethodBeat.o(138050);
            return;
        }
        this.ozI.removeAllViews();
        ccs();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.ozI.addView(this.ozH.getView(), layoutParams);
        AppMethodBeat.o(138050);
    }

    public com.tencent.mm.plugin.appbrand.jsapi.r.c getPicker() {
        return this.ozH;
    }

    public void show() {
        AppMethodBeat.i(138051);
        if (this.isAnimating) {
            AppMethodBeat.o(138051);
        } else if (this.ozH == null) {
            setVisibility(8);
            AppMethodBeat.o(138051);
        } else {
            this.ozH.onShow(this);
            clearAnimation();
            setVisibility(0);
            this.isAnimating = true;
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.a5);
            this.ozO.startAnimation(loadAnimation);
            startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.a3));
            loadAnimation.setAnimationListener(new Animation.AnimationListener() {
                /* class com.tencent.mm.plugin.appbrand.widget.picker.c.AnonymousClass1 */

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.i(138041);
                    c.this.setBackgroundResource(R.color.a3m);
                    c.this.isAnimating = false;
                    AppMethodBeat.o(138041);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            AppMethodBeat.o(138051);
        }
    }

    public void hide() {
        AppMethodBeat.i(138052);
        if (this.isAnimating) {
            AppMethodBeat.o(138052);
            return;
        }
        b(false, null);
        if (this.ozH != null) {
            this.ozH.onHide(this);
            this.isAnimating = true;
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.d0);
            this.ozO.startAnimation(loadAnimation);
            startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.a4));
            loadAnimation.setAnimationListener(new Animation.AnimationListener() {
                /* class com.tencent.mm.plugin.appbrand.widget.picker.c.AnonymousClass2 */

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.i(138042);
                    c.this.setBackgroundResource(R.color.ac_);
                    c.this.clearAnimation();
                    c.b(c.this);
                    c.this.requestLayout();
                    c.this.isAnimating = false;
                    AppMethodBeat.o(138042);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
        }
        AppMethodBeat.o(138052);
    }

    public void setVisibility(int i2) {
        AppMethodBeat.i(138053);
        if (i2 != 0) {
            hide();
            AppMethodBeat.o(138053);
            return;
        }
        super.setVisibility(i2);
        AppMethodBeat.o(138053);
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"WrongCall"})
    public final void eM(int i2, int i3) {
        AppMethodBeat.i(138054);
        super.onMeasure(i2, i3);
        AppMethodBeat.o(138054);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(138055);
        if (!isShown()) {
            super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(0, Integer.MIN_VALUE));
        }
        AppMethodBeat.o(138055);
    }

    public void setHeader(String str) {
        AppMethodBeat.i(138056);
        if (Util.isNullOrNil(str)) {
            cct();
            this.ozP.setVisibility(0);
            this.mMg.setText("");
            this.ozJ.setVisibility(8);
            this.mMg.setVisibility(8);
            AppMethodBeat.o(138056);
            return;
        }
        if ("设置时间".equals(str)) {
            str = getContext().getString(R.string.p8);
        } else if ("设置地区".equals(str)) {
            str = getContext().getString(R.string.p7);
        } else if ("设置日期".equals(str)) {
            str = getContext().getString(R.string.p6);
        } else if (str == null) {
            str = "";
        }
        this.ozP.setVisibility(8);
        this.ozJ.setVisibility(0);
        this.mMg.setVisibility(0);
        this.mMg.setText(str);
        AppMethodBeat.o(138056);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(138058);
        super.onDetachedFromWindow();
        ccs();
        removeAllViews();
        AppMethodBeat.o(138058);
    }

    /* access modifiers changed from: protected */
    public final void cY(Object obj) {
        AppMethodBeat.i(138059);
        if (this.ozQ != null) {
            this.ozQ.cH(obj);
        }
        AppMethodBeat.o(138059);
    }

    private void cct() {
        int dimensionPixelSize;
        AppMethodBeat.i(193735);
        if (isLandscape()) {
            dimensionPixelSize = 0;
        } else {
            dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.ce);
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ozP.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        this.ozP.setLayoutParams(layoutParams);
        AppMethodBeat.o(193735);
    }

    private void ccu() {
        int dimensionPixelSize;
        int dimensionPixelSize2;
        int dimensionPixelSize3;
        AppMethodBeat.i(193736);
        if (isLandscape()) {
            dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.cb);
            dimensionPixelSize2 = getContext().getResources().getDimensionPixelSize(R.dimen.cb);
            dimensionPixelSize3 = getContext().getResources().getDimensionPixelSize(R.dimen.afu);
        } else {
            dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.cl);
            dimensionPixelSize2 = getContext().getResources().getDimensionPixelSize(R.dimen.ci);
            dimensionPixelSize3 = getContext().getResources().getDimensionPixelSize(R.dimen.afv);
        }
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.ozL.getLayoutParams();
        layoutParams.topMargin = dimensionPixelSize;
        layoutParams.bottomMargin = dimensionPixelSize2;
        this.ozL.setLayoutParams(layoutParams);
        this.ozK.setLayoutParams(new LinearLayout.LayoutParams(-1, dimensionPixelSize3));
        AppMethodBeat.o(193736);
    }

    private boolean isLandscape() {
        AppMethodBeat.i(193737);
        if (ac.LANDSCAPE == ccv().bTN()) {
            AppMethodBeat.o(193737);
            return true;
        }
        AppMethodBeat.o(193737);
        return false;
    }

    public void setOrientationGetter(q qVar) {
        AppMethodBeat.i(193738);
        Log.d("MicroMsg.AppBrand.AppBrandPickerBottomPanelBase", "setOrientationGetter, orientationGetter is " + qVar.getName());
        this.ozR = qVar;
        AppMethodBeat.o(193738);
    }

    private q ccv() {
        AppMethodBeat.i(193739);
        if (this.ozR == null) {
            Log.w("MicroMsg.AppBrand.AppBrandPickerBottomPanelBase", "requireOrientationGetter, orientationGetter is null, use AndroidOrientationGetter as fallback");
            a.C0812a aVar = com.tencent.mm.plugin.appbrand.utils.a.ogC;
            this.ozR = a.C0812a.b(null);
        }
        q qVar = this.ozR;
        AppMethodBeat.o(193739);
        return qVar;
    }

    static /* synthetic */ void b(c cVar) {
        AppMethodBeat.i(138060);
        super.setVisibility(8);
        AppMethodBeat.o(138060);
    }
}
