package com.tencent.mm.plugin.finder.live.component;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.live.component.a;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import org.libpag.PAGFile;
import org.libpag.PAGView;

@l(hxD = {1, 1, 16}, hxE = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 62\u00020\u0001:\u00016B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010(\u001a\u00020\u0005H\u0016J\n\u0010)\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010*\u001a\u00020+H\u0002J\b\u0010,\u001a\u00020+H\u0016J\b\u0010-\u001a\u00020+H\u0016J\u0016\u0010.\u001a\u00020+2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020+00H\u0016J\b\u00101\u001a\u00020+H\u0016J\b\u00102\u001a\u00020+H\u0016J\u0016\u00103\u001a\u00020+2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020+00H\u0016J\u0010\u00104\u001a\u00020+2\u0006\u00105\u001a\u00020\nH\u0016R\u0014\u0010\t\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0015R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u00067"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleViewCallback;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleContract$ViewCallback;", "root", "Landroid/view/View;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleContract$Presenter;", "(Landroid/view/View;Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleContract$Presenter;)V", "SMALL_ANIMATION_FILE", "", "getSMALL_ANIMATION_FILE", "()Ljava/lang/String;", "countDownTxt", "Landroid/widget/TextView;", "getCountDownTxt", "()Landroid/widget/TextView;", "setCountDownTxt", "(Landroid/widget/TextView;)V", "isPagEnable", "", "()Z", "smallAnim", "Lorg/libpag/PAGView;", "getSmallAnim", "()Lorg/libpag/PAGView;", "setSmallAnim", "(Lorg/libpag/PAGView;)V", "smallAnimContainer", "Landroid/widget/FrameLayout;", "getSmallAnimContainer", "()Landroid/widget/FrameLayout;", "setSmallAnimContainer", "(Landroid/widget/FrameLayout;)V", "smallAnimListener", "Lcom/tencent/mm/plugin/finder/live/component/SmallAnimListener;", "getSmallAnimListener", "()Lcom/tencent/mm/plugin/finder/live/component/SmallAnimListener;", "setSmallAnimListener", "(Lcom/tencent/mm/plugin/finder/live/component/SmallAnimListener;)V", "getActivity", "getPresenter", "initSmallAnim", "", "initView", "reset", "resumeLotteryBubble", "callback", "Lkotlin/Function0;", "showLotteryComputing", "showLotteryFinish", "showPrepareLottery", "updateCountDown", "remainTime", "Companion", "plugin-finder_release"})
public final class c implements a.b {
    private static final String TAG = TAG;
    public static final a ugB = new a((byte) 0);
    private final MMActivity activity;
    private final View gvQ;
    final a.AbstractC1176a ugA;
    private final String ugu = "small_lottery_amin.pag";
    TextView ugv;
    private FrameLayout ugw;
    private PAGView ugx;
    private h ugy;
    private final boolean ugz;

    public c(View view, MMActivity mMActivity, a.AbstractC1176a aVar) {
        p.h(view, "root");
        p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(245918);
        this.gvQ = view;
        this.activity = mMActivity;
        this.ugA = aVar;
        com.tencent.mm.kernel.b.a ah = g.ah(PluginFinder.class);
        p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
        this.ugz = ((PluginFinder) ah).isPagEnable();
        y yVar = y.vXH;
        y.awu(TAG);
        AppMethodBeat.o(245918);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleViewCallback$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(245919);
        AppMethodBeat.o(245919);
    }

    @Override // com.tencent.mm.plugin.finder.live.component.a.b
    public final void initView() {
        AppMethodBeat.i(245911);
        this.ugv = (TextView) this.gvQ.findViewById(R.id.bgd);
        this.ugw = (FrameLayout) this.gvQ.findViewById(R.id.mx);
        FrameLayout frameLayout = this.ugw;
        if (frameLayout != null) {
            frameLayout.setOnClickListener(new b(this));
        }
        TextView textView = this.ugv;
        if (textView != null) {
            textView.setOnClickListener(new View$OnClickListenerC1178c(this));
        }
        dfe();
        AppMethodBeat.o(245911);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ c ugC;

        b(c cVar) {
            this.ugC = cVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(245909);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleViewCallback$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            a.AbstractC1176a aVar = this.ugC.ugA;
            if (aVar != null) {
                aVar.deZ();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleViewCallback$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(245909);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.finder.live.component.c$c  reason: collision with other inner class name */
    static final class View$OnClickListenerC1178c implements View.OnClickListener {
        final /* synthetic */ c ugC;

        View$OnClickListenerC1178c(c cVar) {
            this.ugC = cVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(245910);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleViewCallback$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            a.AbstractC1176a aVar = this.ugC.ugA;
            if (aVar != null) {
                aVar.deZ();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleViewCallback$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(245910);
        }
    }

    private final void dfe() {
        AppMethodBeat.i(245912);
        if (!this.ugz) {
            AppMethodBeat.o(245912);
            return;
        }
        if (this.ugx == null) {
            Log.i(TAG, "initSmallAnim create smallAnim!");
            this.ugx = new PAGView(this.gvQ.getContext());
            this.ugy = new h(this);
            PAGView pAGView = this.ugx;
            if (pAGView != null) {
                pAGView.addListener(this.ugy);
            }
        }
        FrameLayout frameLayout = this.ugw;
        if (frameLayout != null) {
            if (frameLayout.indexOfChild(this.ugx) == -1) {
                Log.i(TAG, "initSmallAnim add smallAnim!");
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                PAGView pAGView2 = this.ugx;
                if (pAGView2 != null) {
                    pAGView2.setLayoutParams(layoutParams);
                }
                PAGView pAGView3 = this.ugx;
                if (pAGView3 != null) {
                    pAGView3.setFile(PAGFile.Load(this.activity.getAssets(), this.ugu));
                }
                FrameLayout frameLayout2 = this.ugw;
                if (frameLayout2 != null) {
                    frameLayout2.addView(this.ugx);
                    AppMethodBeat.o(245912);
                    return;
                }
            }
            AppMethodBeat.o(245912);
            return;
        }
        AppMethodBeat.o(245912);
    }

    @Override // com.tencent.mm.plugin.finder.live.component.a.b
    public final void H(kotlin.g.a.a<x> aVar) {
        PAGView pAGView;
        AppMethodBeat.i(245913);
        p.h(aVar, "callback");
        Log.i(TAG, "showPrepareLottery smallAnim is null:" + (this.ugx == null) + ",isPagEnable:" + this.ugz);
        if (!this.ugz) {
            aVar.invoke();
            AppMethodBeat.o(245913);
            return;
        }
        PAGView pAGView2 = this.ugx;
        if (!(pAGView2 == null || !pAGView2.isPlaying() || (pAGView = this.ugx) == null)) {
            pAGView.stop();
        }
        dfe();
        FrameLayout frameLayout = this.ugw;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
        TextView textView = this.ugv;
        if (textView != null) {
            textView.setVisibility(8);
        }
        h hVar = this.ugy;
        if (hVar != null) {
            p.h(aVar, "callback");
            hVar.uhH = aVar;
        }
        PAGView pAGView3 = this.ugx;
        if (pAGView3 != null) {
            pAGView3.setProgress(0.0d);
        }
        PAGView pAGView4 = this.ugx;
        if (pAGView4 != null) {
            pAGView4.play();
            AppMethodBeat.o(245913);
            return;
        }
        AppMethodBeat.o(245913);
    }

    @Override // com.tencent.mm.plugin.finder.live.component.a.b
    public final void I(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(245914);
        p.h(aVar, "callback");
        Log.i(TAG, "resumeLotteryBubble smallAnim is null:" + (this.ugx == null));
        FrameLayout frameLayout = this.ugw;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
        PAGView pAGView = this.ugx;
        if (pAGView != null) {
            pAGView.setProgress(1.0d);
        }
        TextView textView = this.ugv;
        if (textView != null) {
            textView.setVisibility(8);
        }
        aVar.invoke();
        AppMethodBeat.o(245914);
    }

    @Override // com.tencent.mm.plugin.finder.live.component.a.b
    public final void dfa() {
        AppMethodBeat.i(245915);
        Log.i(TAG, "showLotteryComputing");
        FrameLayout frameLayout = this.ugw;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
        PAGView pAGView = this.ugx;
        if (pAGView != null) {
            pAGView.setProgress(1.0d);
        }
        TextView textView = this.ugv;
        if (textView != null) {
            textView.setVisibility(0);
        }
        TextView textView2 = this.ugv;
        if (textView2 != null) {
            Context context = this.gvQ.getContext();
            p.g(context, "root.context");
            textView2.setText(context.getResources().getString(R.string.cus));
        }
        TextView textView3 = this.ugv;
        if (textView3 != null) {
            textView3.setTextSize(1, 14.0f);
            AppMethodBeat.o(245915);
            return;
        }
        AppMethodBeat.o(245915);
    }

    @Override // com.tencent.mm.plugin.finder.live.component.a.b
    public final void dfb() {
        AppMethodBeat.i(245916);
        Log.i(TAG, "showLotteryFinish");
        FrameLayout frameLayout = this.ugw;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
        PAGView pAGView = this.ugx;
        if (pAGView != null) {
            pAGView.setProgress(1.0d);
        }
        TextView textView = this.ugv;
        if (textView != null) {
            textView.setVisibility(0);
        }
        TextView textView2 = this.ugv;
        if (textView2 != null) {
            Context context = this.gvQ.getContext();
            p.g(context, "root.context");
            textView2.setText(context.getResources().getString(R.string.cut));
        }
        TextView textView3 = this.ugv;
        if (textView3 != null) {
            textView3.setTextSize(1, 14.0f);
            AppMethodBeat.o(245916);
            return;
        }
        AppMethodBeat.o(245916);
    }

    @Override // com.tencent.mm.plugin.finder.live.component.a.b
    public final void ats(String str) {
        AppMethodBeat.i(245917);
        p.h(str, "remainTime");
        Log.i(TAG, "updateCountDown remainTime:".concat(String.valueOf(str)));
        FrameLayout frameLayout = this.ugw;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
        PAGView pAGView = this.ugx;
        if (pAGView != null) {
            pAGView.setProgress(1.0d);
        }
        TextView textView = this.ugv;
        if (textView != null) {
            textView.setVisibility(0);
        }
        TextView textView2 = this.ugv;
        if (textView2 != null) {
            textView2.setText(str);
        }
        TextView textView3 = this.ugv;
        if (textView3 != null) {
            textView3.setTextSize(1, 17.0f);
            AppMethodBeat.o(245917);
            return;
        }
        AppMethodBeat.o(245917);
    }

    @Override // com.tencent.mm.plugin.finder.presenter.base.c
    public final /* bridge */ /* synthetic */ MMFragmentActivity dcl() {
        return this.activity;
    }
}
