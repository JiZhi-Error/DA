package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.data.g;
import com.tencent.mm.plugin.sns.h.b;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;

public final class ap {
    private int CHZ = -1;
    private c DQs;
    private FrameLayout DQt;
    AbsoluteLayout DQu = null;
    protected Animation DQv;
    protected Animation DQw;
    boolean DQx = false;
    private b Eni;
    private Context mContext;
    boolean onr = false;

    public ap(Context context, c cVar, FrameLayout frameLayout) {
        AppMethodBeat.i(98144);
        this.mContext = context;
        this.DQs = cVar;
        this.DQt = frameLayout;
        this.DQv = new ScaleAnimation(1.0f, 1.0f, 0.0f, 1.0f, 1, 1.0f, 1, 0.0f);
        this.DQv = AnimationUtils.loadAnimation(context, R.anim.ax);
        this.DQw = new ScaleAnimation(1.0f, 1.0f, 1.0f, 0.0f, 1, 1.0f, 1, 0.0f);
        this.DQw = AnimationUtils.loadAnimation(context, R.anim.ay);
        AppMethodBeat.o(98144);
    }

    /* access modifiers changed from: package-private */
    public class a {
        View Atk = null;
        String DQN;

        public a(String str, View view) {
            this.DQN = str;
            this.Atk = view;
        }
    }

    public final boolean v(final View view, boolean z) {
        int i2;
        AppMethodBeat.i(203354);
        if (this.DQx) {
            AppMethodBeat.o(203354);
            return false;
        } else if (this.DQu != null) {
            if (this.DQu.getTag() instanceof a) {
                fw(((a) this.DQu.getTag()).Atk);
            } else {
                fcl();
            }
            AppMethodBeat.o(203354);
            return false;
        } else if (view.getTag() == null || !(view.getTag() instanceof g)) {
            AppMethodBeat.o(203354);
            return false;
        } else {
            g gVar = (g) view.getTag();
            String str = gVar.dHp;
            this.DQu = new AbsoluteLayout(this.mContext);
            this.DQu.setId(R.id.h2);
            this.DQt.addView(this.DQu);
            int fromDPToPix = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 126.0f);
            int fromDPToPix2 = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 30.0f);
            final View inflate = aa.jQ(this.mContext).inflate(R.layout.bgz, (ViewGroup) null);
            inflate.setOnClickListener(this.DQs.FaW);
            inflate.setTag(gVar);
            int i3 = 0;
            if (z) {
                i3 = au.eu(this.mContext);
            }
            int[] iArr = new int[2];
            int im = h.im(this.mContext);
            gVar.DDJ.getLocationInWindow(iArr);
            Log.d("MicroMsg.AdNotLikeHelper", "addCommentView getLocationInWindow " + iArr[0] + "  " + iArr[1] + " height: " + im);
            this.CHZ = ao.jJ(this.mContext);
            if (this.onr) {
                i2 = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 2);
                this.CHZ = 0;
            } else {
                i2 = im;
            }
            AbsoluteLayout.LayoutParams layoutParams = new AbsoluteLayout.LayoutParams(-2, -2, iArr[0] - fromDPToPix, (((iArr[1] - this.CHZ) - i2) + fromDPToPix2) - i3);
            this.DQu.setTag(new a(str, inflate));
            this.DQu.addView(inflate, layoutParams);
            inflate.setVisibility(8);
            this.DQx = true;
            new MMHandler().post(new Runnable() {
                /* class com.tencent.mm.plugin.sns.ui.ap.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(98142);
                    ap.a(ap.this, inflate);
                    AppMethodBeat.o(98142);
                }
            });
            AppMethodBeat.o(203354);
            return true;
        }
    }

    private void fw(final View view) {
        AppMethodBeat.i(98146);
        this.DQx = true;
        view.startAnimation(this.DQw);
        this.DQw.setAnimationListener(new Animation.AnimationListener() {
            /* class com.tencent.mm.plugin.sns.ui.ap.AnonymousClass3 */

            public final void onAnimationStart(Animation animation) {
                ap.this.DQx = true;
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(98143);
                if (view != null) {
                    view.clearAnimation();
                    view.setVisibility(8);
                    ap.this.fcl();
                }
                ap.this.DQx = false;
                AppMethodBeat.o(98143);
            }
        });
        AppMethodBeat.o(98146);
    }

    public final boolean fcl() {
        AppMethodBeat.i(98147);
        if (this.Eni != null && aj.faG().fco()) {
            this.Eni.fcl();
        }
        if (this.DQu != null) {
            this.DQt.removeView(this.DQu);
            this.DQu = null;
            AppMethodBeat.o(98147);
            return true;
        }
        this.DQx = false;
        AppMethodBeat.o(98147);
        return false;
    }

    static /* synthetic */ void a(ap apVar, View view) {
        AppMethodBeat.i(98148);
        view.setVisibility(0);
        apVar.DQx = true;
        apVar.DQv.setAnimationListener(new Animation.AnimationListener() {
            /* class com.tencent.mm.plugin.sns.ui.ap.AnonymousClass2 */

            public final void onAnimationStart(Animation animation) {
                ap.this.DQx = true;
            }

            public final void onAnimationEnd(Animation animation) {
                ap.this.DQx = false;
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        view.startAnimation(apVar.DQv);
        AppMethodBeat.o(98148);
    }
}
