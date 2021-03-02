package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.ad.g.k;
import com.tencent.mm.plugin.sns.ad.i.i;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;

public final class b {
    private int CHZ = -1;
    private c DQs;
    private FrameLayout DQt;
    AbsoluteLayout DQu = null;
    protected Animation DQv;
    protected Animation DQw;
    boolean DQx = false;
    k DzW;
    private com.tencent.mm.plugin.sns.h.b Eni;
    private com.tencent.mm.plugin.sns.ad.timeline.feedback.c Enj;
    TextView Enk;
    ListView Enl;
    View Enm;
    private Context mContext;
    boolean onr = false;

    public b(Context context, c cVar, FrameLayout frameLayout, com.tencent.mm.plugin.sns.h.b bVar) {
        AppMethodBeat.i(97689);
        this.mContext = context;
        this.Eni = bVar;
        this.DQs = cVar;
        this.DQt = frameLayout;
        this.DQv = new ScaleAnimation(1.0f, 1.0f, 0.0f, 1.0f, 1, 1.0f, 1, 0.0f);
        this.DQv = AnimationUtils.loadAnimation(context, R.anim.ax);
        this.DQw = new ScaleAnimation(1.0f, 1.0f, 1.0f, 0.0f, 1, 1.0f, 1, 0.0f);
        this.DQw = AnimationUtils.loadAnimation(context, R.anim.ay);
        this.Enj = com.tencent.mm.plugin.sns.ad.timeline.feedback.c.a(context, cVar);
        AppMethodBeat.o(97689);
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

    public final boolean fn(final View view) {
        int fromDPToPix;
        String str;
        AppMethodBeat.i(97690);
        if (!aj.faG().fco() || this.Eni == null) {
            try {
                Object tag = view.getTag();
                if (tag instanceof com.tencent.mm.plugin.sns.data.c) {
                    SnsInfo aQm = aj.faO().aQm(((com.tencent.mm.plugin.sns.data.c) tag).dHp);
                    i.a(com.tencent.mm.plugin.sns.ad.timeline.feedback.a.b.a(aQm, false, view, this.DzW));
                    if (this.Enj != null && this.Enj.a(view, aQm)) {
                        AppMethodBeat.o(97690);
                        return true;
                    }
                }
            } catch (Throwable th) {
            }
        } else {
            int fk = this.Eni.fk(view);
            if (fk == 0 || fk == 1) {
                AppMethodBeat.o(97690);
                return true;
            }
            Log.i("MicroMsg.AdNotLikeHelper", "abtest error return 2");
        }
        if (this.DQx) {
            AppMethodBeat.o(97690);
            return false;
        } else if (this.DQu != null) {
            if (this.DQu.getTag() instanceof a) {
                final View view2 = ((a) this.DQu.getTag()).Atk;
                this.DQx = true;
                view2.startAnimation(this.DQw);
                this.DQw.setAnimationListener(new Animation.AnimationListener() {
                    /* class com.tencent.mm.plugin.sns.ui.b.AnonymousClass3 */

                    public final void onAnimationStart(Animation animation) {
                        b.this.DQx = true;
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        AppMethodBeat.i(97687);
                        if (view2 != null) {
                            view2.clearAnimation();
                            view2.setVisibility(8);
                            b.this.fcl();
                        }
                        b.this.DQx = false;
                        AppMethodBeat.o(97687);
                    }
                });
            } else {
                fcl();
            }
            AppMethodBeat.o(97690);
            return false;
        } else if (view.getTag() == null || !(view.getTag() instanceof com.tencent.mm.plugin.sns.data.c)) {
            AppMethodBeat.o(97690);
            return false;
        } else {
            com.tencent.mm.plugin.sns.data.c cVar = (com.tencent.mm.plugin.sns.data.c) view.getTag();
            String str2 = cVar.dHp;
            this.DQu = new AbsoluteLayout(this.mContext);
            this.DQu.setId(R.id.h2);
            new FrameLayout.LayoutParams(-1, -1);
            this.DQt.addView(this.DQu);
            int fromDPToPix2 = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 150.0f);
            int fromDPToPix3 = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 17.0f);
            BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 40.0f);
            final View inflate = aa.jQ(this.mContext).inflate(R.layout.c9, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.gc);
            String currentLanguage = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
            ADXml aDXml = cVar.DDr.EQY;
            if (aDXml != null) {
                if (LocaleUtil.CHINA.equals(currentLanguage)) {
                    str = aDXml.expandInsideTitle_cn;
                } else if (LocaleUtil.TAIWAN.equals(currentLanguage) || LocaleUtil.HONGKONG.equals(currentLanguage)) {
                    str = aDXml.expandInsideTitle_tw;
                } else {
                    str = aDXml.expandInsideTitle_en;
                }
                if (!Util.isNullOrNil(str)) {
                    textView.setText(str);
                    textView.setClickable(true);
                }
            }
            new Rect();
            int im = h.im(this.mContext);
            int[] fjW = cVar.DDr.fjW();
            Log.d("MicroMsg.AdNotLikeHelper", "addCommentView getLocationInWindow " + fjW[0] + "  " + fjW[1] + " height: " + im);
            this.CHZ = ao.getStatusBarHeight(this.mContext);
            if (this.onr) {
                fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 2);
                this.CHZ = 0;
            } else {
                fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 2) + im;
            }
            AbsoluteLayout.LayoutParams layoutParams = new AbsoluteLayout.LayoutParams(-2, -2, fjW[0] - fromDPToPix2, ((fjW[1] - this.CHZ) - fromDPToPix) + fromDPToPix3);
            this.DQu.setTag(new a(str2, inflate));
            this.DQu.addView(inflate, layoutParams);
            inflate.setVisibility(8);
            this.DQx = true;
            new MMHandler().post(new Runnable() {
                /* class com.tencent.mm.plugin.sns.ui.b.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(97686);
                    b.a(b.this, view, inflate);
                    AppMethodBeat.o(97686);
                }
            });
            AppMethodBeat.o(97690);
            return true;
        }
    }

    public final boolean fcl() {
        AppMethodBeat.i(97691);
        if (this.Eni != null && aj.faG().fco()) {
            this.Eni.fcl();
        }
        if (this.DQu != null) {
            this.DQt.removeView(this.DQu);
            this.DQu = null;
            AppMethodBeat.o(97691);
            return true;
        }
        this.DQx = false;
        this.Enl = null;
        this.Enm = null;
        AppMethodBeat.o(97691);
        return false;
    }

    public final boolean ffh() {
        AppMethodBeat.i(97692);
        final int height = this.Enk.getHeight();
        this.Enk.setVisibility(8);
        View view = null;
        final int i2 = 0;
        for (int i3 = 0; i3 < this.Enl.getAdapter().getCount(); i3++) {
            view = this.Enl.getAdapter().getView(i3, view, null);
            view.measure(this.Enm.getWidth(), -2);
            i2 += view.getMeasuredHeight();
        }
        ((RelativeLayout.LayoutParams) this.Enl.getLayoutParams()).bottomMargin = height - i2;
        this.Enl.setVisibility(0);
        AnonymousClass4 r0 = new Animation() {
            /* class com.tencent.mm.plugin.sns.ui.b.AnonymousClass4 */

            /* access modifiers changed from: protected */
            public final void applyTransformation(float f2, Transformation transformation) {
                AppMethodBeat.i(97688);
                ((RelativeLayout.LayoutParams) b.this.Enl.getLayoutParams()).bottomMargin = f2 == 1.0f ? 0 : (int) (((float) (height - i2)) * (1.0f - f2));
                b.this.Enl.requestLayout();
                AppMethodBeat.o(97688);
            }

            public final boolean willChangeBounds() {
                return true;
            }
        };
        r0.setDuration(250);
        this.Enl.startAnimation(r0);
        AppMethodBeat.o(97692);
        return true;
    }

    static /* synthetic */ void a(b bVar, View view, View view2) {
        boolean z;
        String str;
        AppMethodBeat.i(97693);
        com.tencent.mm.plugin.sns.data.c cVar = (com.tencent.mm.plugin.sns.data.c) view.getTag();
        view2.setVisibility(0);
        bVar.DQx = true;
        bVar.DQv.setAnimationListener(new Animation.AnimationListener() {
            /* class com.tencent.mm.plugin.sns.ui.b.AnonymousClass2 */

            public final void onAnimationStart(Animation animation) {
                b.this.DQx = true;
            }

            public final void onAnimationEnd(Animation animation) {
                b.this.DQx = false;
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        view2.startAnimation(bVar.DQv);
        bVar.Enk = (TextView) view2.findViewById(R.id.gd);
        bVar.Enk.setTag(cVar);
        if (cVar.DDr == null || cVar.DDr.EQY == null) {
            z = false;
        } else {
            ADInfo aDInfo = cVar.DDr.EQZ;
            String currentLanguage = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
            if (LocaleUtil.CHINA.equals(currentLanguage)) {
                str = aDInfo.adDislikeInfoTitle_cn;
            } else if (LocaleUtil.TAIWAN.equals(currentLanguage) || LocaleUtil.HONGKONG.equals(currentLanguage)) {
                str = aDInfo.adDislikeInfoTitle_tw;
            } else {
                str = aDInfo.adDislikeInfoTitle_en;
            }
            if (!Util.isNullOrNil(str)) {
                bVar.Enk.setText(str);
            }
            z = aDInfo.forbidClick;
        }
        bVar.Enl = (ListView) view2.findViewById(R.id.g9);
        bVar.Enl.setAdapter((ListAdapter) new c(bVar.mContext, (com.tencent.mm.plugin.sns.data.c) view.getTag()));
        if (z) {
            bVar.Enl.setClickable(false);
            bVar.Enl.setOnItemClickListener(null);
        } else {
            bVar.Enl.setClickable(true);
            bVar.Enl.setOnItemClickListener(bVar.DQs.FaZ);
        }
        bVar.Enk.setClickable(false);
        bVar.Enm = view2;
        AppMethodBeat.o(97693);
    }
}
