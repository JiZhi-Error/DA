package com.tencent.mm.plugin.game.luggage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import com.facebook.internal.NativeProtocol;
import com.tencent.luggage.d.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.luggage.g.d;
import com.tencent.mm.plugin.game.luggage.g.e;
import com.tencent.mm.plugin.game.luggage.g.h;
import com.tencent.mm.plugin.game.luggage.g.i;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.at;
import java.util.HashMap;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@com.tencent.mm.ui.base.a(3)
@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000eH\u0014J\b\u0010\u0014\u001a\u00020\nH\u0014J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0018\u001a\u00020\u0016H\u0016J\u0012\u0010\u0019\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/game/luggage/LuggageGameHalfWebViewUI;", "Lcom/tencent/mm/plugin/game/luggage/LuggageGameWebViewUI;", "()V", "MAX_HEIGHT", "", "getMAX_HEIGHT", "()D", "MAX_HEIGHT$delegate", "Lkotlin/Lazy;", "pageHeight", "", "preloadWebCore", "Lcom/tencent/luggage/container/LuggageWebCore;", "rawUrl", "", "createPage", "Lcom/tencent/mm/plugin/game/luggage/page/GameWebPage;", NativeProtocol.WEB_DIALOG_PARAMS, "Landroid/os/Bundle;", "url", "getLayoutId", "onCreate", "", "savedInstanceState", "onDestroy", "setRootView", "view", "Landroid/view/View;", "Companion", "luggage-game_release"})
public final class LuggageGameHalfWebViewUI extends LuggageGameWebViewUI {
    private static final String TAG = TAG;
    public static final a xwb = new a((byte) 0);
    private HashMap _$_findViewCache;
    private String edo;
    private int loF;
    private final f xwa = g.ah(new b(this));

    private final double dTk() {
        AppMethodBeat.i(187028);
        double doubleValue = ((Number) this.xwa.getValue()).doubleValue();
        AppMethodBeat.o(187028);
        return doubleValue;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(187035);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(187035);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(187034);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(187034);
        return view;
    }

    @Override // com.tencent.mm.plugin.game.luggage.LuggageGameWebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public LuggageGameHalfWebViewUI() {
        AppMethodBeat.i(187032);
        AppMethodBeat.o(187032);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/game/luggage/LuggageGameHalfWebViewUI$Companion;", "", "()V", "TAG", "", "luggage-game_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(187033);
        AppMethodBeat.o(187033);
    }

    @Override // com.tencent.mm.plugin.game.luggage.LuggageGameWebViewUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.aqq;
    }

    @Override // com.tencent.mm.plugin.game.luggage.LuggageGameWebViewUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(187029);
        super.onCreate(bundle);
        overridePendingTransition(R.anim.br, R.anim.bs);
        this.loF = getIntent().getIntExtra("KHalfScreenHeight", (int) dTk());
        this.loF = at.fromDPToPix(this, this.loF);
        if (((double) this.loF) > dTk()) {
            this.loF = (int) dTk();
        }
        if (ao.isDarkMode()) {
            _$_findCachedViewById(R.id.iua).setBackgroundResource(R.color.uc);
        }
        _$_findCachedViewById(R.id.iua).setOnClickListener(new c(this));
        e eVar = this.xwg;
        p.g(eVar, "mContainer");
        View contentView = eVar.getContentView();
        p.g(contentView, "mContainer.contentView");
        contentView.setAnimation(AnimationUtils.loadAnimation(this, R.anim.c8));
        e eVar2 = this.xwg;
        p.g(eVar2, "mContainer");
        ((GameRoundContainerView) _$_findCachedViewById(R.id.jr8)).addView(eVar2.getContentView(), new ViewGroup.LayoutParams(-1, this.loF));
        AppMethodBeat.o(187029);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c implements View.OnClickListener {
        final /* synthetic */ LuggageGameHalfWebViewUI xwc;

        c(LuggageGameHalfWebViewUI luggageGameHalfWebViewUI) {
            this.xwc = luggageGameHalfWebViewUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(187027);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/luggage/LuggageGameHalfWebViewUI$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            e eVar = this.xwc.xwg;
            p.g(eVar, "mContainer");
            View contentView = eVar.getContentView();
            e eVar2 = this.xwc.xwg;
            p.g(eVar2, "mContainer");
            View contentView2 = eVar2.getContentView();
            p.g(contentView2, "mContainer.contentView");
            e eVar3 = this.xwc.xwg;
            p.g(eVar3, "mContainer");
            View contentView3 = eVar3.getContentView();
            p.g(contentView3, "mContainer.contentView");
            ObjectAnimator duration = ObjectAnimator.ofFloat(contentView, "translationY", contentView2.getTranslationY(), contentView3.getTranslationY() + ((float) this.xwc.loF)).setDuration(200L);
            duration.addListener(new a());
            p.g(duration, "ObjectAnimator.ofFloat(m…         })\n            }");
            duration.start();
            this.xwc.finish();
            this.xwc.overridePendingTransition(R.anim.br, R.anim.bs);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/luggage/LuggageGameHalfWebViewUI$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(187027);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/game/luggage/LuggageGameHalfWebViewUI$onCreate$1$animator$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "luggage-game_release"})
        public static final class a extends AnimatorListenerAdapter {
            a() {
            }

            public final void onAnimationEnd(Animator animator) {
            }
        }
    }

    @Override // com.tencent.mm.plugin.game.luggage.LuggageGameWebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(187030);
        super.onDestroy();
        AppMethodBeat.o(187030);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.game.luggage.LuggageGameWebViewUI
    public final void dTl() {
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.game.luggage.LuggageGameWebViewUI
    public final i g(Bundle bundle, String str) {
        AppMethodBeat.i(187031);
        p.h(bundle, NativeProtocol.WEB_DIALOG_PARAMS);
        p.h(str, "url");
        com.tencent.luggage.d.p aI = h.aI(this, str);
        Log.i(TAG, "createPage, wc : " + (aI != null));
        this.edo = str;
        if (aI != null) {
            Object LG = aI.LG();
            if (LG == null) {
                p.hyc();
            }
            if (((h) LG).dTL()) {
                h hVar = (h) aI.LG();
                if ((hVar != null ? hVar.getParent() : null) instanceof ViewGroup) {
                    ViewParent parent = hVar.getParent();
                    if (parent == null) {
                        t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
                        AppMethodBeat.o(187031);
                        throw tVar;
                    }
                    ((ViewGroup) parent).removeView(hVar);
                }
                e eVar = this.xwg;
                p.g(eVar, "mContainer");
                j Lm = eVar.Lm();
                p.g(Lm, "mContainer.ctrl");
                com.tencent.mm.plugin.game.luggage.g.c cVar = new com.tencent.mm.plugin.game.luggage.g.c(Lm, aI, bundle);
                AppMethodBeat.o(187031);
                return cVar;
            }
        }
        e eVar2 = this.xwg;
        p.g(eVar2, "mContainer");
        j Lm2 = eVar2.Lm();
        p.g(Lm2, "mContainer.ctrl");
        d dVar = new d(Lm2, bundle);
        AppMethodBeat.o(187031);
        return dVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0006\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<Double> {
        final /* synthetic */ LuggageGameHalfWebViewUI xwc;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(LuggageGameHalfWebViewUI luggageGameHalfWebViewUI) {
            super(0);
            this.xwc = luggageGameHalfWebViewUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Double invoke() {
            AppMethodBeat.i(187026);
            Double valueOf = Double.valueOf(((double) com.tencent.mm.cb.a.jo(this.xwc)) * 0.75d);
            AppMethodBeat.o(187026);
            return valueOf;
        }
    }
}
