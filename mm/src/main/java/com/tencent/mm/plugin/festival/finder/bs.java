package com.tencent.mm.plugin.festival.finder;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.c.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.festival.model.FestivalWishContextBundle;
import com.tencent.mm.plugin.festival.model.ab;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.av;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 !2\u00020\u0001:\u0001!B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\u0006\u0010\f\u001a\u00020\rJ\"\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\rH\u0002J\b\u0010\u0016\u001a\u00020\rH\u0002J\b\u0010\u0017\u001a\u00020\rH\u0002J\u000e\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001aJ\b\u0010\u001b\u001a\u00020\rH\u0002J\u001a\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalSetStatusPlugin;", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "screenHeight", "", "screenWidth", "getFuIconDrawable", "Landroid/graphics/drawable/Drawable;", MessengerShareContentUtility.SHARE_BUTTON_HIDE, "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPress", "", "renderBgBlur", "setDescFuImageSpan", "setNickNameFuImageSpan", "show", "wishContext", "Lcom/tencent/mm/plugin/festival/model/FestivalWishContextBundle;", "showAnimation", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-festival_release"})
public final class bs extends p {
    @Deprecated
    public static final a UwO = new a((byte) 0);
    final com.tencent.mm.live.c.b hOp;
    final int mEX;
    final int mEY;

    static {
        AppMethodBeat.i(262867);
        AppMethodBeat.o(262867);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalSetStatusPlugin$Companion;", "", "()V", "TAG", "", "plugin-festival_release"})
    static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bs(ViewGroup viewGroup, com.tencent.mm.live.c.b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(262866);
        this.hOp = bVar;
        this.mEY = av.az(viewGroup.getContext()).y;
        this.mEX = av.az(viewGroup.getContext()).x;
        ((RelativeLayout) viewGroup.findViewById(R.id.k27)).setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.festival.finder.bs.AnonymousClass1 */
            final /* synthetic */ bs UwP;

            {
                this.UwP = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(262850);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/festival/finder/FestivalSetStatusPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.plugin.festival.model.a.e eVar = com.tencent.mm.plugin.festival.model.a.e.UAo;
                com.tencent.mm.plugin.festival.model.a.e.hSa();
                this.UwP.hide();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/festival/finder/FestivalSetStatusPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(262850);
            }
        });
        viewGroup.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.festival.finder.bs.AnonymousClass2 */
            final /* synthetic */ bs UwP;

            {
                this.UwP = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(262851);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/festival/finder/FestivalSetStatusPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.plugin.festival.model.a.e eVar = com.tencent.mm.plugin.festival.model.a.e.UAo;
                com.tencent.mm.plugin.festival.model.a.e.hSa();
                this.UwP.hide();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/festival/finder/FestivalSetStatusPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(262851);
            }
        });
        AppMethodBeat.o(262866);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class d implements View.OnClickListener {
        final /* synthetic */ FestivalWishContextBundle UrS;
        final /* synthetic */ bs UwP;

        d(bs bsVar, FestivalWishContextBundle festivalWishContextBundle) {
            this.UwP = bsVar;
            this.UrS = festivalWishContextBundle;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(262855);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/festival/finder/FestivalSetStatusPlugin$show$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.UwP.getLiveData().uDS = false;
            ab abVar = ab.UzG;
            Context context = this.UwP.hwr.getContext();
            p.g(context, "root.context");
            ab.a(context, this.UrS);
            com.tencent.mm.plugin.festival.model.a.e eVar = com.tencent.mm.plugin.festival.model.a.e.UAo;
            com.tencent.mm.plugin.festival.model.a.e.gUu();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/festival/finder/FestivalSetStatusPlugin$show$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(262855);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/festival/finder/FestivalSetStatusPlugin$hide$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-festival_release"})
    public static final class b implements Animator.AnimatorListener {
        final /* synthetic */ bs UwP;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(bs bsVar) {
            this.UwP = bsVar;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(262853);
            this.UwP.hwr.setVisibility(8);
            RelativeLayout relativeLayout = (RelativeLayout) this.UwP.hwr.findViewById(R.id.k28);
            if (relativeLayout != null) {
                relativeLayout.setBackground(null);
            }
            b.C0376b.a(this.UwP.hOp, b.c.wLY);
            b.C0376b.a(this.UwP.hOp, b.c.yPo);
            com.tencent.mm.plugin.festival.model.a.e eVar = com.tencent.mm.plugin.festival.model.a.e.UAo;
            com.tencent.mm.plugin.festival.model.a.e.gUu();
            AppMethodBeat.o(262853);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/festival/finder/FestivalSetStatusPlugin$showAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-festival_release"})
    public static final class e implements Animator.AnimatorListener {
        final /* synthetic */ bs UwP;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        e(bs bsVar) {
            this.UwP = bsVar;
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(262856);
            p.h(animator, "animation");
            AppMethodBeat.o(262856);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(262857);
            p.h(animator, "animation");
            this.UwP.hwr.setVisibility(0);
            AppMethodBeat.o(262857);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.i(262858);
            p.h(animator, "animation");
            AppMethodBeat.o(262858);
        }

        public final void onAnimationRepeat(Animator animator) {
            AppMethodBeat.i(262859);
            p.h(animator, "animation");
            AppMethodBeat.o(262859);
        }
    }

    /* access modifiers changed from: package-private */
    public final Drawable gFd() {
        AppMethodBeat.i(262863);
        ab abVar = ab.UzG;
        Drawable hRQ = ab.hRQ();
        if (hRQ == null) {
            hRQ = this.hwr.getContext().getDrawable(R.drawable.cvt);
        }
        AppMethodBeat.o(262863);
        return hRQ;
    }

    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        FestivalWishContextBundle festivalWishContextBundle;
        AppMethodBeat.i(262864);
        p.h(cVar, "status");
        switch (bt.haE[cVar.ordinal()]) {
            case 1:
                if (bundle != null) {
                    festivalWishContextBundle = (FestivalWishContextBundle) bundle.getParcelable("WishContext");
                } else {
                    festivalWishContextBundle = null;
                }
                if (festivalWishContextBundle == null) {
                    Log.w("FestivalSetStatusPlugin", "post after action wish context null");
                    break;
                } else {
                    FestivalWishContextBundle.a aVar = festivalWishContextBundle.Uzi;
                    if (aVar == null) {
                        AppMethodBeat.o(262864);
                        return;
                    }
                    switch (bt.$EnumSwitchMapping$0[aVar.ordinal()]) {
                        case 1:
                            if (!((Boolean) ab.UzA.a(ab.UzG, ab.cLI[3])).booleanValue()) {
                                Log.i("FestivalSetStatusPlugin", "show set status panel");
                                com.tencent.mm.ac.d.a(100, new f(this, festivalWishContextBundle));
                                AppMethodBeat.o(262864);
                                return;
                            }
                            this.hOp.statusChange(b.c.wLY, null);
                            b.C0376b.a(this.hOp, b.c.yPo);
                            AppMethodBeat.o(262864);
                            return;
                        case 2:
                            b.C0376b.a(this.hOp, b.c.wLY);
                            break;
                    }
                    AppMethodBeat.o(262864);
                    return;
                }
        }
        AppMethodBeat.o(262864);
    }

    @Override // com.tencent.mm.live.c.a
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(262865);
        super.onActivityResult(i2, i3, intent);
        switch (i2) {
            case 273:
                getLiveData().uDS = true;
                if (i3 == -1) {
                    hide();
                    ab.UzG.hRO();
                    break;
                }
                break;
        }
        AppMethodBeat.o(262865);
    }

    public final void hide() {
        AppMethodBeat.i(262861);
        if (this.hwr.getVisibility() != 0) {
            AppMethodBeat.o(262861);
            return;
        }
        ((RelativeLayout) this.hwr.findViewById(R.id.k28)).animate().translationY((float) this.mEY).setDuration(300).setInterpolator(new AccelerateInterpolator()).setListener(new b(this)).start();
        AppMethodBeat.o(262861);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ bs UwP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(bs bsVar) {
            super(0);
            this.UwP = bsVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(262854);
            RelativeLayout relativeLayout = (RelativeLayout) this.UwP.hwr.findViewById(R.id.k28);
            p.g(relativeLayout, "root.setStatePanelContainer");
            Drawable[] drawableArr = new Drawable[2];
            com.tencent.mm.plugin.festival.ui.b bVar = com.tencent.mm.plugin.festival.ui.b.UBn;
            Context context = this.UwP.hwr.getContext();
            p.g(context, "root.context");
            Drawable mj = com.tencent.mm.plugin.festival.ui.b.mj(context);
            if (mj == null) {
                p.hyc();
            }
            drawableArr[0] = mj;
            Drawable l = android.support.v4.content.b.l(this.UwP.hwr.getContext(), R.drawable.cu2);
            if (l == null) {
                p.hyc();
            }
            p.g(l, "ContextCompat.getDrawabl…val_set_state_panel_bg)!!");
            drawableArr[1] = l;
            relativeLayout.setBackground(new LayerDrawable(drawableArr));
            x xVar = x.SXb;
            AppMethodBeat.o(262854);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/festival/finder/FestivalSetStatusPlugin$statusChange$1$1"})
    static final class f extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ FestivalWishContextBundle UrT;
        final /* synthetic */ bs UwP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(bs bsVar, FestivalWishContextBundle festivalWishContextBundle) {
            super(0);
            this.UwP = bsVar;
            this.UrT = festivalWishContextBundle;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(262860);
            bs bsVar = this.UwP;
            FestivalWishContextBundle festivalWishContextBundle = this.UrT;
            p.h(festivalWishContextBundle, "wishContext");
            if (bsVar.hwr.getVisibility() != 0) {
                RelativeLayout relativeLayout = (RelativeLayout) bsVar.hwr.findViewById(R.id.k28);
                p.g(relativeLayout, "root.setStatePanelContainer");
                relativeLayout.getLayoutParams().height = (av.az(bsVar.hwr.getContext()).y / 2) + av.aD(bsVar.hwr.getContext());
                TextView textView = (TextView) bsVar.hwr.findViewById(R.id.k2b);
                p.g(textView, "root.setStatePanelSetBtnTv");
                ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
                if (layoutParams == null) {
                    t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    AppMethodBeat.o(262860);
                    throw tVar;
                }
                int aD = av.aD(bsVar.hwr.getContext());
                Context context = bsVar.hwr.getContext();
                p.g(context, "root.context");
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = aD + context.getResources().getDimensionPixelSize(R.dimen.cj);
                ((TextView) bsVar.hwr.findViewById(R.id.k2b)).setOnClickListener(new d(bsVar, festivalWishContextBundle));
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) bsVar.hwr.getContext().getString(R.string.j9f));
                Drawable gFd = bsVar.gFd();
                if (gFd != null) {
                    TextView textView2 = (TextView) bsVar.hwr.findViewById(R.id.k29);
                    p.g(textView2, "root.setStatePanelDescTv");
                    int lineHeight = textView2.getLineHeight();
                    TextView textView3 = (TextView) bsVar.hwr.findViewById(R.id.k29);
                    p.g(textView3, "root.setStatePanelDescTv");
                    gFd.setBounds(0, 0, lineHeight, textView3.getLineHeight());
                    spannableStringBuilder.setSpan(new ImageSpan(gFd), 5, 6, 17);
                }
                TextView textView4 = (TextView) bsVar.hwr.findViewById(R.id.k29);
                p.g(textView4, "root.setStatePanelDescTv");
                textView4.setText(spannableStringBuilder);
                SpannableString c2 = com.tencent.mm.pluginsdk.ui.span.l.c(bsVar.hwr.getContext(), bsVar.hwr.getContext().getString(R.string.j9g, z.aUa()));
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
                spannableStringBuilder2.append((CharSequence) c2);
                Drawable gFd2 = bsVar.gFd();
                if (gFd2 != null) {
                    TextView textView5 = (TextView) bsVar.hwr.findViewById(R.id.k2_);
                    p.g(textView5, "root.setStatePanelNameTv");
                    int lineHeight2 = textView5.getLineHeight();
                    TextView textView6 = (TextView) bsVar.hwr.findViewById(R.id.k2_);
                    p.g(textView6, "root.setStatePanelNameTv");
                    gFd2.setBounds(0, 0, lineHeight2, textView6.getLineHeight());
                    spannableStringBuilder2.setSpan(new ImageSpan(gFd2), spannableStringBuilder2.length() - 1, spannableStringBuilder2.length(), 17);
                }
                TextView textView7 = (TextView) bsVar.hwr.findViewById(R.id.k2_);
                p.g(textView7, "root.setStatePanelNameTv");
                textView7.setText(spannableStringBuilder2);
                a.b.d((ImageView) bsVar.hwr.findViewById(R.id.k26), z.aTY(), 0.08f);
                Log.i("FestivalSetStatusPlugin", "renderBgBlur");
                c cVar = new c(bsVar);
                com.tencent.mm.live.c.b bVar = bsVar.hOp;
                if (!(bVar instanceof FestivalFinderLiveVisitorPluginLayout)) {
                    bVar = null;
                }
                FestivalFinderLiveVisitorPluginLayout festivalFinderLiveVisitorPluginLayout = (FestivalFinderLiveVisitorPluginLayout) bVar;
                if (festivalFinderLiveVisitorPluginLayout != null) {
                    Bitmap a2 = FestivalFinderLiveVisitorPluginLayout.a(festivalFinderLiveVisitorPluginLayout);
                    if (a2 == null || a2.isRecycled()) {
                        cVar.invoke();
                    } else {
                        Rect rect = new Rect(0, bsVar.mEY / 2, bsVar.mEX, bsVar.mEY);
                        Log.d("FestivalSetStatusPlugin", "renderBgBlur rect : ".concat(String.valueOf(rect)));
                        try {
                            Bitmap bitmapFromRectFixed = BitmapUtil.getBitmapFromRectFixed(a2, rect, false);
                            Context context2 = bsVar.hwr.getContext();
                            p.g(context2, "root.context");
                            Context context3 = bsVar.hwr.getContext();
                            p.g(context3, "root.context");
                            Bitmap roundedCornerBitmap = BitmapUtil.getRoundedCornerBitmap(bitmapFromRectFixed, true, new float[]{(float) context2.getResources().getDimensionPixelSize(R.dimen.c5), (float) context3.getResources().getDimensionPixelSize(R.dimen.c5), 0.0f, 0.0f}, true);
                            RelativeLayout relativeLayout2 = (RelativeLayout) bsVar.hwr.findViewById(R.id.k28);
                            p.g(relativeLayout2, "root.setStatePanelContainer");
                            Drawable[] drawableArr = new Drawable[2];
                            Context context4 = bsVar.hwr.getContext();
                            p.g(context4, "root.context");
                            drawableArr[0] = new BitmapDrawable(context4.getResources(), roundedCornerBitmap);
                            Drawable l = android.support.v4.content.b.l(bsVar.hwr.getContext(), R.drawable.cu2);
                            if (l == null) {
                                p.hyc();
                            }
                            p.g(l, "ContextCompat.getDrawabl…val_set_state_panel_bg)!!");
                            drawableArr[1] = l;
                            relativeLayout2.setBackground(new LayerDrawable(drawableArr));
                        } catch (Exception e2) {
                            Log.e("FestivalSetStatusPlugin", "renderBgBlur exp:".concat(String.valueOf(e2)));
                            cVar.invoke();
                        }
                    }
                }
                bsVar.hwr.bringToFront();
                RelativeLayout relativeLayout3 = (RelativeLayout) bsVar.hwr.findViewById(R.id.k28);
                p.g(relativeLayout3, "root.setStatePanelContainer");
                relativeLayout3.setTranslationY((float) bsVar.mEY);
                ((RelativeLayout) bsVar.hwr.findViewById(R.id.k28)).animate().translationY(0.0f).setDuration(500).setInterpolator(new DecelerateInterpolator()).setListener(new e(bsVar)).start();
            }
            ab.UzG.Fn(true);
            x xVar = x.SXb;
            AppMethodBeat.o(262860);
            return xVar;
        }
    }

    @Override // com.tencent.mm.live.c.a
    public final boolean onBackPress() {
        AppMethodBeat.i(262862);
        if (this.hwr.getVisibility() == 0) {
            com.tencent.mm.plugin.festival.model.a.e eVar = com.tencent.mm.plugin.festival.model.a.e.UAo;
            com.tencent.mm.plugin.festival.model.a.e.hSa();
            hide();
            AppMethodBeat.o(262862);
            return true;
        }
        boolean onBackPress = super.onBackPress();
        AppMethodBeat.o(262862);
        return onBackPress;
    }
}
