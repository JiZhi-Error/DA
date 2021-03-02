package com.tencent.mm.plugin.sns.ui;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.sns.model.au;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.tools.j;

public class SnsTranslateResultView extends LinearLayout {
    private static final int EOn = Color.parseColor("#19000000");
    private int EJA = -1;
    private TextView EOk;
    private TextView EOl;
    private View EOm;
    private float EOo = -1.0f;
    private int EOp = -1;
    private Drawable jbs;

    static {
        AppMethodBeat.i(99450);
        AppMethodBeat.o(99450);
    }

    public SnsTranslateResultView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(99444);
        LayoutInflater.from(getContext()).inflate(R.layout.c4l, this);
        this.EOk = (TextView) findViewById(R.id.i1a);
        this.EOl = (TextView) findViewById(R.id.i1b);
        this.EOm = findViewById(R.id.ivc);
        this.jbs = getResources().getDrawable(R.drawable.bo6);
        this.jbs.setBounds(0, 0, (int) (this.EOl.getTextSize() * 0.8f), (int) (this.EOl.getTextSize() * 0.8f));
        this.jbs.setColorFilter(EOn, PorterDuff.Mode.SRC_IN);
        AppMethodBeat.o(99444);
    }

    public final void ZW(int i2) {
        AppMethodBeat.i(99445);
        this.EOl.setCompoundDrawables(this.jbs, null, null, null);
        this.EOl.setCompoundDrawablePadding(a.fromDPToPix(getContext(), 3));
        this.EOl.setText(R.string.hbo);
        j.a(this.EOl, null);
        this.EOk.setVisibility(4);
        this.EJA = i2;
        this.EOl.setTextSize(0, this.EOk.getTextSize());
        this.EOl.setTextColor(getContext().getResources().getColor(R.color.a9m));
        AppMethodBeat.o(99445);
    }

    public TextView getResultTextView() {
        return this.EOl;
    }

    public View getSplitlineView() {
        return this.EOm;
    }

    public final void setResultTextSize$255e752(float f2) {
        AppMethodBeat.i(99446);
        this.EOl.setTextSize(1, f2);
        this.EOo = f2;
        this.EOp = 1;
        AppMethodBeat.o(99446);
    }

    public void setResultTextSize(float f2) {
        AppMethodBeat.i(99447);
        this.EOl.setTextSize(0, f2);
        this.EOo = f2;
        this.EOp = 0;
        AppMethodBeat.o(99447);
    }

    private void fjv() {
        AppMethodBeat.i(99448);
        if (this.EOo != -1.0f || this.EOp != -1) {
            this.EOl.setTextSize(this.EOp, this.EOo);
        } else if (this.EJA == 2) {
            this.EOl.setTextSize(1, 14.0f * a.ez(getContext()));
        } else if (this.EJA == 1) {
            this.EOl.setTextSize(1, 15.0f * a.ez(getContext()));
        }
        if (this.EJA == 2) {
            this.EOl.setTextColor(getContext().getResources().getColor(R.color.a9l));
            AppMethodBeat.o(99448);
            return;
        }
        if (this.EJA == 1) {
            this.EOl.setTextColor(getContext().getResources().getColor(R.color.a9n));
        }
        AppMethodBeat.o(99448);
    }

    @TargetApi(11)
    public final void a(final au.b bVar, int i2, String str, String str2, boolean z) {
        AppMethodBeat.i(99449);
        this.EJA = i2;
        fjv();
        if (!Util.isNullOrNil(str)) {
            this.EOl.setText(str);
            l.p(this.EOl, 2);
        } else {
            this.EOl.setText(R.string.hbm);
        }
        this.EOl.setCompoundDrawables(null, null, null, null);
        if (z && d.oD(11)) {
            j.a(this.EOl, new Animator.AnimatorListener() {
                /* class com.tencent.mm.plugin.sns.ui.SnsTranslateResultView.AnonymousClass1 */

                public final void onAnimationStart(Animator animator) {
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(99443);
                    if (bVar != null) {
                        au.a(bVar);
                    }
                    AppMethodBeat.o(99443);
                }

                public final void onAnimationCancel(Animator animator) {
                }

                public final void onAnimationRepeat(Animator animator) {
                }
            });
        }
        if (!Util.isNullOrNil(str2)) {
            this.EOk.setText(str2);
        } else {
            this.EOk.setText(R.string.b31);
        }
        this.EOk.setVisibility(0);
        AppMethodBeat.o(99449);
    }
}
