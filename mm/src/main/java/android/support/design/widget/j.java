package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.support.design.a.a;
import android.support.design.a.b;
import android.support.v4.view.u;
import android.support.v4.widget.Space;
import android.support.v4.widget.q;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import java.util.ArrayList;
import java.util.List;

/* access modifiers changed from: package-private */
public final class j {
    final Context context;
    int sA;
    Typeface sB;
    final TextInputLayout si;
    private LinearLayout sj;
    private int sk;
    private FrameLayout sl;
    private int sm;
    Animator sn;
    private final float so = ((float) this.context.getResources().getDimensionPixelSize(R.dimen.zz));
    int sq;
    int sr;
    CharSequence ss;
    boolean st;
    TextView su;
    int sv;
    CharSequence sx;
    boolean sy;
    TextView sz;

    public j(TextInputLayout textInputLayout) {
        this.context = textInputLayout.getContext();
        this.si = textInputLayout;
    }

    /* access modifiers changed from: package-private */
    public final void cO() {
        this.ss = null;
        cP();
        if (this.sq == 1) {
            if (!this.sy || TextUtils.isEmpty(this.sx)) {
                this.sr = 0;
            } else {
                this.sr = 2;
            }
        }
        a(this.sq, this.sr, a(this.su, (CharSequence) null));
    }

    /* access modifiers changed from: package-private */
    public final boolean a(TextView textView, CharSequence charSequence) {
        return u.az(this.si) && this.si.isEnabled() && (this.sr != this.sq || textView == null || !TextUtils.equals(textView.getText(), charSequence));
    }

    /* access modifiers changed from: package-private */
    public final void a(final int i2, final int i3, boolean z) {
        if (z) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.sn = animatorSet;
            ArrayList arrayList = new ArrayList();
            a(arrayList, this.sy, this.sz, 2, i2, i3);
            a(arrayList, this.st, this.su, 1, i2, i3);
            b.a(animatorSet, arrayList);
            final TextView X = X(i2);
            final TextView X2 = X(i3);
            animatorSet.addListener(new AnimatorListenerAdapter() {
                /* class android.support.design.widget.j.AnonymousClass1 */

                public final void onAnimationEnd(Animator animator) {
                    j.this.sq = i3;
                    j.this.sn = null;
                    if (X != null) {
                        X.setVisibility(4);
                        if (i2 == 1 && j.this.su != null) {
                            j.this.su.setText((CharSequence) null);
                        }
                    }
                }

                public final void onAnimationStart(Animator animator) {
                    if (X2 != null) {
                        X2.setVisibility(0);
                    }
                }
            });
            animatorSet.start();
        } else {
            p(i2, i3);
        }
        this.si.dn();
        this.si.d(z, false);
        this.si.dw();
    }

    private void p(int i2, int i3) {
        TextView X;
        TextView X2;
        if (i2 != i3) {
            if (!(i3 == 0 || (X2 = X(i3)) == null)) {
                X2.setVisibility(0);
                X2.setAlpha(1.0f);
            }
            if (!(i2 == 0 || (X = X(i2)) == null)) {
                X.setVisibility(4);
                if (i2 == 1) {
                    X.setText((CharSequence) null);
                }
            }
            this.sq = i3;
        }
    }

    private void a(List<Animator> list, boolean z, TextView textView, int i2, int i3, int i4) {
        if (textView != null && z) {
            if (i2 == i4 || i2 == i3) {
                list.add(a(textView, i4 == i2));
                if (i4 == i2) {
                    list.add(a(textView));
                }
            }
        }
    }

    private static ObjectAnimator a(TextView textView, boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.ALPHA, z ? 1.0f : 0.0f);
        ofFloat.setDuration(167L);
        ofFloat.setInterpolator(a.gK);
        return ofFloat;
    }

    private ObjectAnimator a(TextView textView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.TRANSLATION_Y, -this.so, 0.0f);
        ofFloat.setDuration(217L);
        ofFloat.setInterpolator(a.gN);
        return ofFloat;
    }

    /* access modifiers changed from: package-private */
    public final void cP() {
        if (this.sn != null) {
            this.sn.cancel();
        }
    }

    private static boolean W(int i2) {
        return i2 == 0 || i2 == 1;
    }

    private TextView X(int i2) {
        switch (i2) {
            case 1:
                return this.su;
            case 2:
                return this.sz;
            default:
                return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void cQ() {
        boolean z;
        if (this.sj == null || this.si.getEditText() == null) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            u.d(this.sj, u.ac(this.si.getEditText()), 0, u.ad(this.si.getEditText()), 0);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(TextView textView, int i2) {
        if (this.sj == null && this.sl == null) {
            this.sj = new LinearLayout(this.context);
            this.sj.setOrientation(0);
            this.si.addView(this.sj, -1, -2);
            this.sl = new FrameLayout(this.context);
            this.sj.addView(this.sl, -1, new FrameLayout.LayoutParams(-2, -2));
            this.sj.addView(new Space(this.context), new LinearLayout.LayoutParams(0, 0, 1.0f));
            if (this.si.getEditText() != null) {
                cQ();
            }
        }
        if (W(i2)) {
            this.sl.setVisibility(0);
            this.sl.addView(textView);
            this.sm++;
        } else {
            this.sj.addView(textView, i2);
        }
        this.sj.setVisibility(0);
        this.sk++;
    }

    /* access modifiers changed from: package-private */
    public final void b(TextView textView, int i2) {
        if (this.sj != null) {
            if (!W(i2) || this.sl == null) {
                this.sj.removeView(textView);
            } else {
                this.sm--;
                b(this.sl, this.sm);
                this.sl.removeView(textView);
            }
            this.sk--;
            b(this.sj, this.sk);
        }
    }

    private static void b(ViewGroup viewGroup, int i2) {
        if (i2 == 0) {
            viewGroup.setVisibility(8);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean cR() {
        return this.sr == 1 && this.su != null && !TextUtils.isEmpty(this.ss);
    }

    static void a(TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    /* access modifiers changed from: package-private */
    public final int cS() {
        if (this.su != null) {
            return this.su.getCurrentTextColor();
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public final ColorStateList cT() {
        if (this.su != null) {
            return this.su.getTextColors();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void setErrorTextAppearance(int i2) {
        this.sv = i2;
        if (this.su != null) {
            this.si.c(this.su, i2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void Y(int i2) {
        this.sA = i2;
        if (this.sz != null) {
            q.d(this.sz, i2);
        }
    }
}
