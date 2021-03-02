package com.tencent.mm.ui.widget.picker;

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
    protected com.tencent.mm.ui.widget.picker.c.a QSH;
    private Context context;
    boolean ddZ;
    boolean jLA;
    private Animation jLB;
    private Animation jLC;
    protected int jLD = 80;
    private boolean jLE = true;
    private View.OnKeyListener jLF = new View.OnKeyListener() {
        /* class com.tencent.mm.ui.widget.picker.a.AnonymousClass3 */

        public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
            boolean z;
            AppMethodBeat.i(198375);
            b bVar = new b();
            bVar.bm(view);
            bVar.pH(i2);
            bVar.bm(keyEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/picker/BasePickerView$3", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, bVar.axR());
            if (i2 == 4 && keyEvent.getAction() == 0) {
                a aVar = a.this;
                if (aVar.blf() || (aVar.jLy.getParent() == null && !aVar.ddZ)) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    a.this.dismiss();
                    com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/widget/picker/BasePickerView$3", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                    AppMethodBeat.o(198375);
                    return true;
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/ui/widget/picker/BasePickerView$3", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(198375);
            return false;
        }
    };
    private final View.OnTouchListener jLG = new View.OnTouchListener() {
        /* class com.tencent.mm.ui.widget.picker.a.AnonymousClass4 */

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(198376);
            if (motionEvent.getAction() == 0) {
                a.this.dismiss();
            }
            AppMethodBeat.o(198376);
            return false;
        }
    };
    protected ViewGroup jLx;
    ViewGroup jLy;
    private ViewGroup jLz;
    private Dialog mDialog;

    public a(Context context2) {
        AppMethodBeat.i(198377);
        this.context = context2;
        AppMethodBeat.o(198377);
    }

    /* access modifiers changed from: protected */
    public final void blb() {
        ViewGroup viewGroup;
        AppMethodBeat.i(198378);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
        this.jLy = (ViewGroup) LayoutInflater.from(this.context).inflate(R.layout.ayg, this.QSH.Zv, false);
        this.jLy.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        if (this.QSH.jLt != -1) {
            this.jLy.setBackgroundColor(this.QSH.jLt);
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
        AppMethodBeat.o(198378);
    }

    public final void dismiss() {
        AppMethodBeat.i(198380);
        if (blf()) {
            if (this.mDialog != null) {
                this.mDialog.dismiss();
            }
            AppMethodBeat.o(198380);
        } else if (this.jLA) {
            AppMethodBeat.o(198380);
        } else {
            if (this.jLE) {
                this.jLB.setAnimationListener(new Animation.AnimationListener() {
                    /* class com.tencent.mm.ui.widget.picker.a.AnonymousClass1 */

                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        AppMethodBeat.i(198373);
                        a.this.bld();
                        AppMethodBeat.o(198373);
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }
                });
                this.jLx.startAnimation(this.jLB);
            } else {
                bld();
            }
            this.jLA = true;
            AppMethodBeat.o(198380);
        }
    }

    public final void bld() {
        AppMethodBeat.i(198381);
        this.QSH.Zv.post(new Runnable() {
            /* class com.tencent.mm.ui.widget.picker.a.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(198374);
                a.this.QSH.Zv.removeView(a.this.jLy);
                a.this.ddZ = false;
                a.this.jLA = false;
                AppMethodBeat.o(198374);
            }
        });
        AppMethodBeat.o(198381);
    }

    /* access modifiers changed from: protected */
    public final a Ds(boolean z) {
        AppMethodBeat.i(198382);
        if (this.jLy != null) {
            View findViewById = this.jLy.findViewById(R.id.g7r);
            if (z) {
                findViewById.setOnTouchListener(this.jLG);
            } else {
                findViewById.setOnTouchListener(null);
            }
        }
        AppMethodBeat.o(198382);
        return this;
    }

    public final void ble() {
        AppMethodBeat.i(198383);
        if (this.mDialog != null) {
            this.mDialog.setCancelable(this.QSH.ox);
        }
        AppMethodBeat.o(198383);
    }

    public final View findViewById(int i2) {
        AppMethodBeat.i(198384);
        View findViewById = this.jLx.findViewById(i2);
        AppMethodBeat.o(198384);
        return findViewById;
    }

    public boolean blf() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final void blc() {
        AppMethodBeat.i(198379);
        this.jLC = AnimationUtils.loadAnimation(this.context, com.tencent.mm.ui.widget.picker.f.a.I(this.jLD, true));
        this.jLB = AnimationUtils.loadAnimation(this.context, com.tencent.mm.ui.widget.picker.f.a.I(this.jLD, false));
        AppMethodBeat.o(198379);
    }
}
