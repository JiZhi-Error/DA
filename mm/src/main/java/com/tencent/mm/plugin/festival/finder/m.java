package com.tencent.mm.plugin.festival.finder;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.oe;
import com.tencent.mm.live.c.b;
import com.tencent.mm.plugin.festival.model.FestivalWishContextBundle;
import com.tencent.mm.plugin.festival.model.ab;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0002J\u000e\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u000bJ\b\u0010\u0013\u001a\u00020\rH\u0002J\u001a\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\rH\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalDonationPlugin;", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "enterAnimator", "Landroid/animation/Animator;", "exitAnimator", "wishContextData", "Lcom/tencent/mm/plugin/festival/model/FestivalWishContextBundle;", MessengerShareContentUtility.SHARE_BUTTON_HIDE, "", "onBackPress", "", "renderBgBlur", "show", "wishContext", "showAnimation", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "Companion", "plugin-festival_release"})
public final class m extends p {
    @Deprecated
    public static final a UrP = new a((byte) 0);
    private Animator UrM;
    private Animator UrN;
    FestivalWishContextBundle UrO;
    private final com.tencent.mm.live.c.b hOp;

    static {
        AppMethodBeat.i(262154);
        AppMethodBeat.o(262154);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m(ViewGroup viewGroup, com.tencent.mm.live.c.b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(262153);
        this.hOp = bVar;
        ((Button) viewGroup.findViewById(R.id.ju6)).setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.festival.finder.m.AnonymousClass1 */
            final /* synthetic */ m UrQ;

            {
                this.UrQ = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(262137);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/festival/finder/FestivalDonationPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                m.g(this.UrQ);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/festival/finder/FestivalDonationPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(262137);
            }
        });
        viewGroup.setOnClickListener(AnonymousClass2.UrR);
        AppMethodBeat.o(262153);
    }

    public static final /* synthetic */ void g(m mVar) {
        AppMethodBeat.i(262157);
        mVar.hide();
        AppMethodBeat.o(262157);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalDonationPlugin$Companion;", "", "()V", "TAG", "", "plugin-festival_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/festival/finder/FestivalDonationPlugin$show$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-festival_release"})
    public static final class e implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ m UrQ;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        e(m mVar) {
            this.UrQ = mVar;
        }

        public final void onGlobalLayout() {
            AppMethodBeat.i(TPMediaCodecProfileLevel.HEVCMainTierLevel52);
            LinearLayout linearLayout = (LinearLayout) this.UrQ.hwr.findViewById(R.id.ju7);
            p.g(linearLayout, "root.donationLayoutContent");
            linearLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            m.a(this.UrQ);
            m.b(this.UrQ);
            AppMethodBeat.o(TPMediaCodecProfileLevel.HEVCMainTierLevel52);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class f implements View.OnClickListener {
        final /* synthetic */ m UrQ;
        final /* synthetic */ FestivalWishContextBundle UrS;

        f(m mVar, FestivalWishContextBundle festivalWishContextBundle) {
            this.UrQ = mVar;
            this.UrS = festivalWishContextBundle;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(262145);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/festival/finder/FestivalDonationPlugin$show$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            String str = this.UrS.Uzm;
            a unused = m.UrP;
            Log.i("FestivalDonationPlugin", "click go url:%s", str);
            if (str != null) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", str);
                com.tencent.mm.br.c.b(this.UrQ.hwr.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                oe oeVar = new oe();
                oeVar.PE(Util.nowSecond());
                com.tencent.mm.plugin.festival.model.a.b bVar2 = com.tencent.mm.plugin.festival.model.a.b.UzX;
                oeVar.GJ(com.tencent.mm.plugin.festival.model.a.b.hRV());
                oeVar.PZ(1);
                oeVar.bfK();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/festival/finder/FestivalDonationPlugin$show$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(262145);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/festival/finder/FestivalDonationPlugin$showAnimation$1$1"})
    public static final class g implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ m UrQ;

        g(m mVar) {
            this.UrQ = mVar;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(262146);
            p.g(valueAnimator, LocaleUtil.ITALIAN);
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(262146);
                throw tVar;
            }
            float floatValue = ((Float) animatedValue).floatValue();
            LinearLayout linearLayout = (LinearLayout) this.UrQ.hwr.findViewById(R.id.ju7);
            p.g(linearLayout, "root.donationLayoutContent");
            linearLayout.setAlpha(floatValue);
            LinearLayout linearLayout2 = (LinearLayout) this.UrQ.hwr.findViewById(R.id.ju7);
            p.g(linearLayout2, "root.donationLayoutContent");
            linearLayout2.setScaleX(floatValue);
            LinearLayout linearLayout3 = (LinearLayout) this.UrQ.hwr.findViewById(R.id.ju7);
            p.g(linearLayout3, "root.donationLayoutContent");
            linearLayout3.setScaleY(floatValue);
            AppMethodBeat.o(262146);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/festival/finder/FestivalDonationPlugin$showAnimation$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-festival_release"})
    public static final class h extends AnimatorListenerAdapter {
        final /* synthetic */ m UrQ;

        h(m mVar) {
            this.UrQ = mVar;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(262147);
            this.UrQ.hwr.setVisibility(0);
            LinearLayout linearLayout = (LinearLayout) this.UrQ.hwr.findViewById(R.id.ju7);
            p.g(linearLayout, "root.donationLayoutContent");
            linearLayout.setAlpha(1.0f);
            this.UrQ.UrM = null;
            AppMethodBeat.o(262147);
        }
    }

    private final void hide() {
        AppMethodBeat.i(262149);
        Animator animator = this.UrM;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.UrN;
        if (animator2 != null) {
            animator2.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.setDuration(450L);
        ofFloat.addUpdateListener(new b(this));
        ofFloat.addListener(new c(this));
        ofFloat.start();
        this.UrN = ofFloat;
        AppMethodBeat.o(262149);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/festival/finder/FestivalDonationPlugin$hide$1$1"})
    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ m UrQ;

        b(m mVar) {
            this.UrQ = mVar;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(262141);
            p.g(valueAnimator, LocaleUtil.ITALIAN);
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(262141);
                throw tVar;
            }
            float floatValue = ((Float) animatedValue).floatValue();
            LinearLayout linearLayout = (LinearLayout) this.UrQ.hwr.findViewById(R.id.ju7);
            p.g(linearLayout, "root.donationLayoutContent");
            linearLayout.setAlpha(floatValue);
            LinearLayout linearLayout2 = (LinearLayout) this.UrQ.hwr.findViewById(R.id.ju7);
            p.g(linearLayout2, "root.donationLayoutContent");
            linearLayout2.setScaleX(floatValue);
            LinearLayout linearLayout3 = (LinearLayout) this.UrQ.hwr.findViewById(R.id.ju7);
            p.g(linearLayout3, "root.donationLayoutContent");
            linearLayout3.setScaleY(floatValue);
            AppMethodBeat.o(262141);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/festival/finder/FestivalDonationPlugin$hide$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-festival_release"})
    public static final class c extends AnimatorListenerAdapter {
        final /* synthetic */ m UrQ;

        c(m mVar) {
            this.UrQ = mVar;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(262142);
            this.UrQ.hwr.setVisibility(8);
            LinearLayout linearLayout = (LinearLayout) this.UrQ.hwr.findViewById(R.id.ju7);
            p.g(linearLayout, "root.donationLayoutContent");
            linearLayout.setBackground(null);
            this.UrQ.UrN = null;
            ab abVar = ab.UzG;
            if (ab.hRP()) {
                Bundle bundle = new Bundle();
                FestivalWishContextBundle festivalWishContextBundle = this.UrQ.UrO;
                if (festivalWishContextBundle != null) {
                    festivalWishContextBundle.Uzi = FestivalWishContextBundle.a.GoSetState;
                }
                bundle.putParcelable("WishContext", this.UrQ.UrO);
                this.UrQ.hOp.statusChange(b.c.wLX, bundle);
                AppMethodBeat.o(262142);
                return;
            }
            b.C0376b.a(this.UrQ.hOp, b.c.wLY);
            AppMethodBeat.o(262142);
        }
    }

    @Override // com.tencent.mm.plugin.festival.finder.p, com.tencent.mm.plugin.finder.live.plugin.d, com.tencent.mm.live.c.a
    public final void unMount() {
        AppMethodBeat.i(262151);
        super.unMount();
        Animator animator = this.UrM;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.UrN;
        if (animator2 != null) {
            animator2.cancel();
            AppMethodBeat.o(262151);
            return;
        }
        AppMethodBeat.o(262151);
    }

    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        AppMethodBeat.i(262152);
        p.h(cVar, "status");
        switch (n.haE[cVar.ordinal()]) {
            case 1:
                FestivalWishContextBundle festivalWishContextBundle = bundle != null ? (FestivalWishContextBundle) bundle.getParcelable("WishContext") : null;
                if (festivalWishContextBundle == null) {
                    Log.w("FestivalDonationPlugin", "post after action wish context null");
                    break;
                } else {
                    FestivalWishContextBundle.a aVar = festivalWishContextBundle.Uzi;
                    if (aVar == null) {
                        AppMethodBeat.o(262152);
                        return;
                    }
                    switch (n.$EnumSwitchMapping$0[aVar.ordinal()]) {
                        case 1:
                            com.tencent.mm.ac.d.a(300, new i(this, festivalWishContextBundle));
                            break;
                    }
                    AppMethodBeat.o(262152);
                    return;
                }
        }
        AppMethodBeat.o(262152);
    }

    @Override // com.tencent.mm.live.c.a
    public final boolean onBackPress() {
        AppMethodBeat.i(262150);
        if (this.hwr.getVisibility() == 0) {
            Log.i("FestivalDonationPlugin", "onBackPress eat and hide");
            hide();
            AppMethodBeat.o(262150);
            return true;
        }
        boolean onBackPress = super.onBackPress();
        AppMethodBeat.o(262150);
        return onBackPress;
    }

    public static final /* synthetic */ void a(m mVar) {
        AppMethodBeat.i(262155);
        Log.i("FestivalDonationPlugin", "renderBgBlur");
        d dVar = new d(mVar);
        com.tencent.mm.live.c.b bVar = mVar.hOp;
        if (!(bVar instanceof FestivalFinderLiveVisitorPluginLayout)) {
            bVar = null;
        }
        FestivalFinderLiveVisitorPluginLayout festivalFinderLiveVisitorPluginLayout = (FestivalFinderLiveVisitorPluginLayout) bVar;
        if (festivalFinderLiveVisitorPluginLayout != null) {
            Bitmap a2 = FestivalFinderLiveVisitorPluginLayout.a(festivalFinderLiveVisitorPluginLayout);
            if (a2 == null || a2.isRecycled()) {
                dVar.invoke();
                AppMethodBeat.o(262155);
                return;
            }
            LinearLayout linearLayout = (LinearLayout) mVar.hwr.findViewById(R.id.ju7);
            p.g(linearLayout, "root.donationLayoutContent");
            int x = (int) linearLayout.getX();
            LinearLayout linearLayout2 = (LinearLayout) mVar.hwr.findViewById(R.id.ju7);
            p.g(linearLayout2, "root.donationLayoutContent");
            int y = (int) linearLayout2.getY();
            LinearLayout linearLayout3 = (LinearLayout) mVar.hwr.findViewById(R.id.ju7);
            p.g(linearLayout3, "root.donationLayoutContent");
            float x2 = linearLayout3.getX();
            LinearLayout linearLayout4 = (LinearLayout) mVar.hwr.findViewById(R.id.ju7);
            p.g(linearLayout4, "root.donationLayoutContent");
            int width = (int) (((float) linearLayout4.getWidth()) + x2);
            LinearLayout linearLayout5 = (LinearLayout) mVar.hwr.findViewById(R.id.ju7);
            p.g(linearLayout5, "root.donationLayoutContent");
            float y2 = linearLayout5.getY();
            LinearLayout linearLayout6 = (LinearLayout) mVar.hwr.findViewById(R.id.ju7);
            p.g(linearLayout6, "root.donationLayoutContent");
            Rect rect = new Rect(x, y, width, (int) (((float) linearLayout6.getHeight()) + y2));
            Log.d("FestivalDonationPlugin", "renderBgBlur rect : ".concat(String.valueOf(rect)));
            try {
                Bitmap bitmapFromRectFixed = BitmapUtil.getBitmapFromRectFixed(a2, rect, false);
                Context context = mVar.hwr.getContext();
                p.g(context, "root.context");
                Bitmap roundedCornerBitmap = BitmapUtil.getRoundedCornerBitmap(bitmapFromRectFixed, true, (float) context.getResources().getDimensionPixelSize(R.dimen.c5), true);
                LinearLayout linearLayout7 = (LinearLayout) mVar.hwr.findViewById(R.id.ju7);
                p.g(linearLayout7, "root.donationLayoutContent");
                Drawable[] drawableArr = new Drawable[2];
                Context context2 = mVar.hwr.getContext();
                p.g(context2, "root.context");
                drawableArr[0] = new BitmapDrawable(context2.getResources(), roundedCornerBitmap);
                Drawable l = android.support.v4.content.b.l(mVar.hwr.getContext(), R.drawable.ctp);
                if (l == null) {
                    p.hyc();
                }
                p.g(l, "ContextCompat.getDrawabl…val_donation_layout_bg)!!");
                drawableArr[1] = l;
                linearLayout7.setBackground(new LayerDrawable(drawableArr));
                AppMethodBeat.o(262155);
            } catch (Exception e2) {
                Log.e("FestivalDonationPlugin", "renderBgBlur exp:".concat(String.valueOf(e2)));
                dVar.invoke();
                AppMethodBeat.o(262155);
            }
        } else {
            AppMethodBeat.o(262155);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ m UrQ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(m mVar) {
            super(0);
            this.UrQ = mVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(262143);
            LinearLayout linearLayout = (LinearLayout) this.UrQ.hwr.findViewById(R.id.ju7);
            p.g(linearLayout, "root.donationLayoutContent");
            Drawable[] drawableArr = new Drawable[2];
            com.tencent.mm.plugin.festival.ui.b bVar = com.tencent.mm.plugin.festival.ui.b.UBn;
            Context context = this.UrQ.hwr.getContext();
            p.g(context, "root.context");
            Drawable mj = com.tencent.mm.plugin.festival.ui.b.mj(context);
            if (mj == null) {
                p.hyc();
            }
            drawableArr[0] = mj;
            Drawable l = android.support.v4.content.b.l(this.UrQ.hwr.getContext(), R.drawable.ctp);
            if (l == null) {
                p.hyc();
            }
            p.g(l, "ContextCompat.getDrawabl…val_donation_layout_bg)!!");
            drawableArr[1] = l;
            linearLayout.setBackground(new LayerDrawable(drawableArr));
            x xVar = x.SXb;
            AppMethodBeat.o(262143);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/festival/finder/FestivalDonationPlugin$statusChange$1$1"})
    static final class i extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ m UrQ;
        final /* synthetic */ FestivalWishContextBundle UrT;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(m mVar, FestivalWishContextBundle festivalWishContextBundle) {
            super(0);
            this.UrQ = mVar;
            this.UrT = festivalWishContextBundle;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(262148);
            m mVar = this.UrQ;
            FestivalWishContextBundle festivalWishContextBundle = this.UrT;
            p.h(festivalWishContextBundle, "wishContext");
            mVar.UrO = festivalWishContextBundle;
            LinearLayout linearLayout = (LinearLayout) mVar.hwr.findViewById(R.id.ju7);
            p.g(linearLayout, "root.donationLayoutContent");
            linearLayout.getViewTreeObserver().addOnGlobalLayoutListener(new e(mVar));
            LinearLayout linearLayout2 = (LinearLayout) mVar.hwr.findViewById(R.id.ju7);
            p.g(linearLayout2, "root.donationLayoutContent");
            linearLayout2.setAlpha(0.0f);
            TextView textView = (TextView) mVar.hwr.findViewById(R.id.jua);
            p.g(textView, "root.donationLayoutTitleTv");
            textView.setText(festivalWishContextBundle.Uzj);
            TextView textView2 = (TextView) mVar.hwr.findViewById(R.id.ju8);
            p.g(textView2, "root.donationLayoutDescTv");
            textView2.setText(festivalWishContextBundle.Uzk);
            TextView textView3 = (TextView) mVar.hwr.findViewById(R.id.ju_);
            p.g(textView3, "root.donationLayoutLinkTv");
            textView3.setText(festivalWishContextBundle.Uzl);
            ((LinearLayout) mVar.hwr.findViewById(R.id.ju9)).setOnClickListener(new f(mVar, festivalWishContextBundle));
            mVar.hwr.bringToFront();
            mVar.rg(0);
            com.tencent.mm.cr.d.hiy();
            x xVar = x.SXb;
            AppMethodBeat.o(262148);
            return xVar;
        }
    }

    public static final /* synthetic */ void b(m mVar) {
        AppMethodBeat.i(262156);
        Animator animator = mVar.UrM;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = mVar.UrN;
        if (animator2 != null) {
            animator2.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        mVar.hwr.setClickable(true);
        LinearLayout linearLayout = (LinearLayout) mVar.hwr.findViewById(R.id.ju7);
        p.g(linearLayout, "root.donationLayoutContent");
        linearLayout.setScaleX(0.0f);
        LinearLayout linearLayout2 = (LinearLayout) mVar.hwr.findViewById(R.id.ju7);
        p.g(linearLayout2, "root.donationLayoutContent");
        linearLayout2.setScaleY(0.0f);
        ofFloat.setDuration(450L);
        ofFloat.setInterpolator(new com.tencent.mm.msgsubscription.ui.a.a());
        ofFloat.addUpdateListener(new g(mVar));
        ofFloat.addListener(new h(mVar));
        ofFloat.start();
        mVar.UrM = ofFloat;
        AppMethodBeat.o(262156);
    }
}
