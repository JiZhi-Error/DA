package com.tencent.mm.plugin.finder.viewmodel.component;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.a.hj;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.HashSet;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;
import org.json.JSONObject;
import org.libpag.PAGFile;
import org.libpag.PAGView;

@l(hxD = {1, 1, 16}, hxE = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0006\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\nH\u0002J\u0012\u0010\u000f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\rH\u0016J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0014H\u0002R\u0010\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLikeGuideUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "com/tencent/mm/plugin/finder/viewmodel/component/FinderLikeGuideUIC$listener$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLikeGuideUIC$listener$1;", "shownSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "checkShow", "", "feedId", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "report21875", "", "Companion", "plugin-finder_release"})
public final class FinderLikeGuideUIC extends UIComponent {
    public static final a wxT = new a((byte) 0);
    private final HashSet<Long> wxR = new HashSet<>();
    private final c wxS = new c(this);

    static {
        AppMethodBeat.i(255711);
        AppMethodBeat.o(255711);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderLikeGuideUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(255710);
        AppMethodBeat.o(255710);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLikeGuideUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/viewmodel/component/FinderLikeGuideUIC$listener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedMegaVideoAnimPlayEvent;", "callback", "", "event", "plugin-finder_release"})
    public static final class c extends IListener<hj> {
        final /* synthetic */ FinderLikeGuideUIC wxU;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(FinderLikeGuideUIC finderLikeGuideUIC) {
            this.wxU = finderLikeGuideUIC;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(hj hjVar) {
            AppMethodBeat.i(255707);
            hj hjVar2 = hjVar;
            p.h(hjVar2, "event");
            if (hjVar2.dLP.dLR && !this.wxU.wxR.contains(Long.valueOf(hjVar2.dLP.feedId))) {
                if (!hjVar2.dLP.dLQ) {
                    y yVar = y.vXH;
                    if (y.LY(hjVar2.dLP.dLS)) {
                        d.h(new a(this, hjVar2));
                    }
                }
                this.wxU.wxR.add(Long.valueOf(hjVar2.dLP.feedId));
            }
            AppMethodBeat.o(255707);
            return false;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ c wxW;
            final /* synthetic */ hj wxX;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(c cVar, hj hjVar) {
                super(0);
                this.wxW = cVar;
                this.wxX = hjVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(255706);
                FinderLikeGuideUIC.a(this.wxW.wxU, this.wxX.dLP.feedId);
                x xVar = x.SXb;
                AppMethodBeat.o(255706);
                return xVar;
            }
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
    public static final class b implements View.OnTouchListener {
        final /* synthetic */ FinderLikeGuideUIC wxU;
        final /* synthetic */ LinearLayout wxV;

        b(FinderLikeGuideUIC finderLikeGuideUIC, LinearLayout linearLayout) {
            this.wxU = finderLikeGuideUIC;
            this.wxV = linearLayout;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(255705);
            p.g(motionEvent, "event");
            if (motionEvent.getAction() == 0) {
                Window window = this.wxU.getActivity().getWindow();
                p.g(window, "activity.window");
                View decorView = window.getDecorView();
                if (decorView == null) {
                    t tVar = new t("null cannot be cast to non-null type android.widget.FrameLayout");
                    AppMethodBeat.o(255705);
                    throw tVar;
                }
                ((FrameLayout) decorView).removeView(this.wxV);
            }
            AppMethodBeat.o(255705);
            return false;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(255708);
        super.onCreate(bundle);
        this.wxS.alive();
        AppMethodBeat.o(255708);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        AppMethodBeat.i(255709);
        super.onDestroy();
        this.wxS.dead();
        AppMethodBeat.o(255709);
    }

    public static final /* synthetic */ void a(FinderLikeGuideUIC finderLikeGuideUIC, long j2) {
        bbn bbn;
        AppMethodBeat.i(255712);
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        int i2 = aAh.azQ().getInt(ar.a.USERINFO_FINDER_FULL_LIKE_FEED_GUIDE_INT, 0);
        if (i2 < 3) {
            Log.i("Finder.LikeGuideUIC", "[checkGuide] count=".concat(String.valueOf(i2)));
            String zs = d.zs(j2);
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            FinderReporterUIC fH = FinderReporterUIC.a.fH(finderLikeGuideUIC.getActivity());
            if (fH == null || (bbn = fH.dIx()) == null) {
                bbn = new bbn();
            }
            String valueOf = String.valueOf(System.currentTimeMillis());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("feedid", zs);
            String jSONObject2 = jSONObject.toString();
            p.g(jSONObject2, "JSONObject().apply {\n   …dId)\n        }.toString()");
            h.INSTANCE.a(21875, bbn.sessionId, bbn.sGQ, Integer.valueOf(bbn.tCE), 0, valueOf, "dbclck_like_edu", n.j(jSONObject2, ",", ";", false), bbn.sGE);
            LinearLayout linearLayout = new LinearLayout(finderLikeGuideUIC.getActivity());
            linearLayout.setOrientation(1);
            linearLayout.setGravity(17);
            linearLayout.setBackgroundResource(R.color.uw);
            PAGView pAGView = new PAGView(finderLikeGuideUIC.getActivity());
            int dimension = (int) finderLikeGuideUIC.getActivity().getResources().getDimension(R.dimen.by);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimension, dimension);
            layoutParams.gravity = 17;
            linearLayout.addView(pAGView, layoutParams);
            TextView textView = new TextView(finderLikeGuideUIC.getActivity());
            textView.setText(finderLikeGuideUIC.getActivity().getResources().getString(R.string.cn2));
            textView.setTextColor(-1);
            textView.setTextSize(1, 20.0f);
            com.tencent.mm.plugin.finder.utils.e.n(textView);
            TextView textView2 = textView;
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.topMargin = (int) finderLikeGuideUIC.getActivity().getResources().getDimension(R.dimen.ce);
            layoutParams2.gravity = 17;
            linearLayout.addView(textView2, layoutParams2);
            pAGView.setRepeatCount(-1);
            pAGView.setFile(PAGFile.Load(finderLikeGuideUIC.getContext().getAssets(), "finder_full_like_guide.pag"));
            pAGView.play();
            Window window = finderLikeGuideUIC.getActivity().getWindow();
            p.g(window, "activity.window");
            View decorView = window.getDecorView();
            if (decorView == null) {
                t tVar = new t("null cannot be cast to non-null type android.widget.FrameLayout");
                AppMethodBeat.o(255712);
                throw tVar;
            }
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
            layoutParams3.gravity = 17;
            ((FrameLayout) decorView).addView(linearLayout, layoutParams3);
            linearLayout.setClickable(false);
            linearLayout.setOnTouchListener(new b(finderLikeGuideUIC, linearLayout));
            e aAh2 = g.aAh();
            p.g(aAh2, "MMKernel.storage()");
            aAh2.azQ().set(ar.a.USERINFO_FINDER_FULL_LIKE_FEED_GUIDE_INT, Integer.valueOf(i2 + 1));
        }
        AppMethodBeat.o(255712);
    }
}
