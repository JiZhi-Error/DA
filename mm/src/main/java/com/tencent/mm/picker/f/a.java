package com.tencent.mm.picker.f;

import android.app.Dialog;
import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;

public class a {
    private Context context;
    boolean ddZ;
    protected com.tencent.mm.picker.c.a jKP;
    boolean jLA;
    private Animation jLB;
    private Animation jLC;
    protected int jLD = 80;
    private boolean jLE = true;
    private View.OnKeyListener jLF = new View.OnKeyListener() {
        /* class com.tencent.mm.picker.f.a.AnonymousClass3 */

        public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
            boolean z;
            AppMethodBeat.i(175335);
            b bVar = new b();
            bVar.bm(view);
            bVar.pH(i2);
            bVar.bm(keyEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/picker/view/BasePickerView$3", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, bVar.axR());
            if (i2 == 4 && keyEvent.getAction() == 0) {
                a aVar = a.this;
                if (aVar.blf() || (aVar.jLy.getParent() == null && !aVar.ddZ)) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    a.this.dismiss();
                    com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/picker/view/BasePickerView$3", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                    AppMethodBeat.o(175335);
                    return true;
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/picker/view/BasePickerView$3", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(175335);
            return false;
        }
    };
    private final View.OnTouchListener jLG = new View.OnTouchListener() {
        /* class com.tencent.mm.picker.f.a.AnonymousClass4 */

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(175336);
            if (motionEvent.getAction() == 0) {
                a.this.dismiss();
            }
            AppMethodBeat.o(175336);
            return false;
        }
    };
    protected ViewGroup jLx;
    ViewGroup jLy;
    private ViewGroup jLz;
    private Dialog mDialog;

    public a(Context context2) {
        AppMethodBeat.i(175337);
        this.context = context2;
        AppMethodBeat.o(175337);
    }

    /* access modifiers changed from: protected */
    public final void blb() {
        ViewGroup viewGroup;
        AppMethodBeat.i(175338);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
        this.jLy = (ViewGroup) LayoutInflater.from(this.context).inflate(R.layout.ayg, this.jKP.Zv, false);
        this.jLy.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        if (this.jKP.jLt != -1) {
            this.jLy.setBackgroundColor(this.jKP.jLt);
        }
        this.jLx = (ViewGroup) this.jLy.findViewById(R.id.ben);
        this.jLx.setLayoutParams(layoutParams);
        if (blf()) {
            viewGroup = this.jLz;
        } else {
            viewGroup = this.jLy;
        }
        viewGroup.setFocusable(true);
        viewGroup.setFocusableInTouchMode(true);
        viewGroup.setOnKeyListener(this.jLF);
        AppMethodBeat.o(175338);
    }

    public final void dismiss() {
        AppMethodBeat.i(175340);
        if (blf()) {
            if (this.mDialog != null) {
                this.mDialog.dismiss();
            }
            AppMethodBeat.o(175340);
        } else if (this.jLA) {
            AppMethodBeat.o(175340);
        } else {
            if (this.jLE) {
                this.jLB.setAnimationListener(new Animation.AnimationListener() {
                    /* class com.tencent.mm.picker.f.a.AnonymousClass1 */

                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        AppMethodBeat.i(175333);
                        a.this.bld();
                        AppMethodBeat.o(175333);
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }
                });
                this.jLx.startAnimation(this.jLB);
            } else {
                bld();
            }
            this.jLA = true;
            AppMethodBeat.o(175340);
        }
    }

    public final void bld() {
        AppMethodBeat.i(175341);
        this.jKP.Zv.post(new Runnable() {
            /* class com.tencent.mm.picker.f.a.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(175334);
                a.this.jKP.Zv.removeView(a.this.jLy);
                a.this.ddZ = false;
                a.this.jLA = false;
                AppMethodBeat.o(175334);
            }
        });
        AppMethodBeat.o(175341);
    }

    /* access modifiers changed from: protected */
    public final a gd(boolean z) {
        AppMethodBeat.i(175342);
        if (this.jLy != null) {
            View findViewById = this.jLy.findViewById(R.id.g7r);
            if (z) {
                findViewById.setOnTouchListener(this.jLG);
            } else {
                findViewById.setOnTouchListener(null);
            }
        }
        AppMethodBeat.o(175342);
        return this;
    }

    public final void ble() {
        AppMethodBeat.i(175343);
        if (this.mDialog != null) {
            this.mDialog.setCancelable(this.jKP.ox);
        }
        AppMethodBeat.o(175343);
    }

    public final View findViewById(int i2) {
        AppMethodBeat.i(175344);
        View findViewById = this.jLx.findViewById(i2);
        AppMethodBeat.o(175344);
        return findViewById;
    }

    public boolean blf() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final void blc() {
        AppMethodBeat.i(175339);
        this.jLC = AnimationUtils.loadAnimation(this.context, com.tencent.mm.picker.e.a.I(this.jLD, true));
        this.jLB = AnimationUtils.loadAnimation(this.context, com.tencent.mm.picker.e.a.I(this.jLD, false));
        AppMethodBeat.o(175339);
    }
}
