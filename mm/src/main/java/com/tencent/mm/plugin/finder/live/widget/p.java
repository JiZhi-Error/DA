package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.b.o;
import com.tencent.mm.live.c.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.model.s;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.ban;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.at;
import kotlin.g.a.r;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010 \u001a\u00020!J\b\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020#H\u0002J\u000e\u0010%\u001a\u00020#2\u0006\u0010\u0014\u001a\u00020&J\u0018\u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0002J\u000e\u0010,\u001a\u00020#2\u0006\u0010-\u001a\u00020\nJ\u0006\u0010.\u001a\u00020#J\b\u0010/\u001a\u00020#H\u0002R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n \u0011*\u0004\u0018\u00010\u00130\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n \u0011*\u0004\u0018\u00010\u00160\u0016X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n \u0011*\u0004\u0018\u00010\u00180\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\n \u0011*\u0004\u0018\u00010\u00010\u0001X\u0004¢\u0006\u0002\n\u0000¨\u00060"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorLikeWidget;", "", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "MAX_LIKE_ONE_TIME", "", "TAG", "", "getBasePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "likeClickArea", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "likeContainer", "Landroid/widget/LinearLayout;", "likeCount", "likeIcon", "Landroid/widget/ImageView;", "likeTv", "Landroid/widget/TextView;", "postLikeTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getRoot", "()Landroid/view/ViewGroup;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "vibrator", "isVisible", "", "postHightLightLike", "", "postLike", "refreshLikeCount", "", "scaleAnimate", "target", "Landroid/view/View;", "targetValue", "", "setVisible", "visible", "shakeIt", "uploadLike", "plugin-finder_release"})
public final class p {
    final String TAG = "Finder.FinderLiveVisitorLikeWidget";
    final com.tencent.mm.live.c.b hOp;
    final TextView hPG;
    final Object hQn;
    final MTimerHandler hQp;
    public final ViewGroup hwr;
    int likeCount;
    final ImageView rNa = ((ImageView) this.hwr.findViewById(R.id.cs6));
    final com.tencent.mm.plugin.finder.live.plugin.d uFw;
    final int uHG = 9;
    public final LinearLayout uHH = ((LinearLayout) this.hwr.findViewById(R.id.cs5));
    public final RelativeLayout uHI = ((RelativeLayout) this.hwr.findViewById(R.id.cs4));

    public p(ViewGroup viewGroup, com.tencent.mm.live.c.b bVar, com.tencent.mm.plugin.finder.live.plugin.d dVar) {
        kotlin.g.b.p.h(viewGroup, "root");
        kotlin.g.b.p.h(bVar, "statusMonitor");
        kotlin.g.b.p.h(dVar, "basePlugin");
        AppMethodBeat.i(248170);
        this.hwr = viewGroup;
        this.hOp = bVar;
        this.uFw = dVar;
        ViewParent parent = this.hwr.getParent();
        if (parent == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(248170);
            throw tVar;
        }
        this.hPG = (TextView) ((ViewGroup) parent).findViewById(R.id.cs8);
        this.hQn = this.hwr.getContext().getSystemService("vibrator");
        this.hQp = new MTimerHandler("FinderLiveLikePlugin::Timer", (MTimerHandler.CallBack) new c(this), true);
        ImageView imageView = this.rNa;
        Context context = this.hwr.getContext();
        kotlin.g.b.p.g(context, "root.context");
        imageView.setImageDrawable(ar.e(context.getResources().getDrawable(R.raw.icons_filled_call_good), -1));
        this.uHH.setOnTouchListener(new View.OnTouchListener(this) {
            /* class com.tencent.mm.plugin.finder.live.widget.p.AnonymousClass1 */
            final /* synthetic */ p uHJ;

            {
                this.uHJ = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(248162);
                kotlin.g.b.p.g(motionEvent, "event");
                switch (motionEvent.getActionMasked()) {
                    case 0:
                        TextView textView = this.uHJ.hPG;
                        kotlin.g.b.p.g(textView, "likeTv");
                        textView.setVisibility(4);
                        p.u(this.uHJ.hwr, 1.7f);
                        this.uHJ.hQp.startTimer(0, 200);
                        ImageView imageView = this.uHJ.rNa;
                        kotlin.g.b.p.g(imageView, "likeIcon");
                        imageView.setAlpha(0.3f);
                        break;
                    case 1:
                    case 3:
                        this.uHJ.hQp.stopTimer();
                        TextView textView2 = this.uHJ.hPG;
                        kotlin.g.b.p.g(textView2, "likeTv");
                        textView2.setVisibility(0);
                        p.u(this.uHJ.hwr, 1.0f);
                        p pVar = this.uHJ;
                        o oVar = o.ujN;
                        s finderLiveAssistant = o.getFinderLiveAssistant();
                        if (finderLiveAssistant != null) {
                            finderLiveAssistant.Jf(pVar.likeCount);
                        }
                        pVar.RE(pVar.uFw.getLiveData().UPT);
                        pVar.likeCount = 0;
                        ImageView imageView2 = this.uHJ.rNa;
                        kotlin.g.b.p.g(imageView2, "likeIcon");
                        imageView2.setAlpha(1.0f);
                        break;
                }
                AppMethodBeat.o(248162);
                return true;
            }
        });
        AppMethodBeat.o(248170);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class d implements Runnable {
        final /* synthetic */ long Utg;
        final /* synthetic */ p uHJ;

        d(p pVar, long j2) {
            this.uHJ = pVar;
            this.Utg = j2;
        }

        public final void run() {
            AppMethodBeat.i(248167);
            TextView textView = this.uHJ.hPG;
            kotlin.g.b.p.g(textView, "likeTv");
            y yVar = y.vXH;
            textView.setText(y.RN(this.Utg));
            AppMethodBeat.o(248167);
        }
    }

    public final void RE(long j2) {
        AppMethodBeat.i(261226);
        this.hwr.post(new d(this, j2));
        AppMethodBeat.o(261226);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onTimerExpired"})
    static final class c implements MTimerHandler.CallBack {
        final /* synthetic */ p uHJ;

        c(p pVar) {
            this.uHJ = pVar;
        }

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(248166);
            if (this.uHJ.likeCount < this.uHJ.uHG - 1) {
                p pVar = this.uHJ;
                if (pVar.hQn instanceof Vibrator) {
                    ((Vibrator) pVar.hQn).vibrate(10);
                }
                com.tencent.mm.ac.d.h(new b(pVar));
                AppMethodBeat.o(248166);
                return true;
            }
            if (this.uHJ.likeCount == this.uHJ.uHG - 1) {
                p pVar2 = this.uHJ;
                if (pVar2.hQn instanceof Vibrator) {
                    ((Vibrator) pVar2.hQn).vibrate(10);
                }
                com.tencent.mm.ac.d.h(new a(pVar2));
            }
            AppMethodBeat.o(248166);
            return false;
        }
    }

    public final boolean isVisible() {
        AppMethodBeat.i(248169);
        if (this.hwr.getVisibility() == 0) {
            AppMethodBeat.o(248169);
            return true;
        }
        AppMethodBeat.o(248169);
        return false;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ p uHJ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(p pVar) {
            super(0);
            this.uHJ = pVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(248165);
            this.uHJ.likeCount++;
            Bundle bundle = new Bundle();
            int[] iArr = {0, 0};
            this.uHJ.hwr.getLocationOnScreen(iArr);
            int width = iArr[0] + ((int) ((((float) this.uHJ.hwr.getWidth()) * this.uHJ.hwr.getScaleX()) / 2.0f));
            o.b bVar = o.b.hGo;
            bundle.putInt("PARAM_LIVE_LIKE_CONFETTI_X", width - (o.b.aFl() / 2));
            bundle.putInt("PARAM_LIVE_LIKE_CONFETTI_Y", iArr[1] - at.fromDPToPix(this.uHJ.hwr.getContext(), 16));
            this.uHJ.hOp.statusChange(b.c.hMa, bundle);
            x xVar = x.SXb;
            AppMethodBeat.o(248165);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ p uHJ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(p pVar) {
            super(0);
            this.uHJ = pVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(248164);
            Bundle bundle = new Bundle();
            int[] iArr = {0, 0};
            this.uHJ.hwr.getLocationOnScreen(iArr);
            int width = iArr[0] + ((int) ((((float) this.uHJ.hwr.getWidth()) * this.uHJ.hwr.getScaleX()) / 2.0f));
            o.b bVar = o.b.hGo;
            bundle.putInt("PARAM_LIVE_LIKE_CONFETTI_X", width - (o.b.aFm() / 2));
            bundle.putInt("PARAM_LIVE_LIKE_CONFETTI_Y", iArr[1]);
            String str = this.uHJ.uFw.getLiveData().UQh.qFV;
            if (str == null) {
                str = z.aTY();
            }
            bundle.putString("PARAM_FINDER_LIVE_HEAD_URL", str);
            this.uHJ.hOp.statusChange(b.c.hNK, bundle);
            com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
            s finderLiveAssistant = com.tencent.mm.plugin.finder.live.model.o.getFinderLiveAssistant();
            if (finderLiveAssistant != null) {
                finderLiveAssistant.c(new r<Integer, Integer, String, ban, x>(this) {
                    /* class com.tencent.mm.plugin.finder.live.widget.p.a.AnonymousClass1 */
                    final /* synthetic */ a uHK;

                    {
                        this.uHK = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
                    @Override // kotlin.g.a.r
                    public final /* synthetic */ x invoke(Integer num, Integer num2, String str, ban ban) {
                        AppMethodBeat.i(248163);
                        int intValue = num.intValue();
                        int intValue2 = num2.intValue();
                        kotlin.g.b.p.h(ban, "resp");
                        Log.i(this.uHK.uHJ.TAG, "doHighLightLikeLive errType:" + intValue + " errCode:" + intValue2 + " errMsg:" + str);
                        x xVar = x.SXb;
                        AppMethodBeat.o(248163);
                        return xVar;
                    }
                });
            }
            x xVar = x.SXb;
            AppMethodBeat.o(248164);
            return xVar;
        }
    }

    public static final /* synthetic */ void u(View view, float f2) {
        AppMethodBeat.i(248171);
        view.animate().setDuration(200).scaleX(f2).scaleY(f2).start();
        AppMethodBeat.o(248171);
    }
}
