package com.tencent.mm.plugin.finder.live.plugin;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.c.b;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.model.s;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.utils.ac;
import com.tencent.mm.plugin.finder.utils.ad;
import com.tencent.mm.plugin.finder.utils.ah;
import com.tencent.mm.plugin.finder.utils.b;
import com.tencent.mm.protocal.protobuf.ape;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import kotlin.g.a.s;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\bH\u0016J\u0006\u0010\u001d\u001a\u00020\u0019J\b\u0010\u001e\u001a\u00020\u0019H\u0002J\u001a\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0006\u0010$\u001a\u00020\u0019J\b\u0010%\u001a\u00020\u0019H\u0016R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u000e*\u0004\u0018\u00010\u00100\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveReadyPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "COUNT_DOWN_END", "", "COUNT_DOWN_START", "TAG", "", "cancelBtn", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "countDownTv", "Landroid/widget/TextView;", "curCountDown", "loadingComponent", "Lcom/tencent/mm/plugin/finder/utils/DelayLoadingComponent;", "timerHandler", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "onBackPress", "", "reset", "", "setTextWithAnim", "setVisible", "visible", "startCountDown", "startLive", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "stopCountDown", "unMount", "plugin-finder_release"})
public final class ay extends d {
    final String TAG = "Finder.FinderLiveReadyPlugin";
    final com.tencent.mm.live.c.b hOp;
    private final int hSo = 3;
    final int hSp;
    final Button hSq;
    final TextView hSr;
    int hSs;
    final MTimerHandler timerHandler;
    com.tencent.mm.plugin.finder.utils.b tux;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\n¢\u0006\u0002\b\u000b"}, hxF = {"<anonymous>", "", "success", "", "errCode", "", "errType", "errMsg", "", "errresp", "Lcom/tencent/mm/protocal/protobuf/FinderCloseLiveResp;", "invoke"})
    static final class a extends q implements s<Boolean, Integer, Integer, String, ape, x> {
        final /* synthetic */ ay utv;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(ay ayVar) {
            super(5);
            this.utv = ayVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.s
        public final /* synthetic */ x a(Boolean bool, Integer num, Integer num2, String str, ape ape) {
            AppMethodBeat.i(246948);
            boolean booleanValue = bool.booleanValue();
            num.intValue();
            num2.intValue();
            p.h(str, "errMsg");
            Log.i(this.utv.TAG, "close live result:".concat(String.valueOf(booleanValue)));
            x xVar = x.SXb;
            AppMethodBeat.o(246948);
            return xVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ay(ViewGroup viewGroup, com.tencent.mm.live.c.b bVar) {
        super(viewGroup, bVar);
        com.tencent.mm.plugin.finder.utils.b bVar2;
        ay ayVar;
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(246956);
        this.hOp = bVar;
        this.hSq = (Button) viewGroup.findViewById(R.id.cx7);
        this.hSr = (TextView) viewGroup.findViewById(R.id.cx8);
        ProgressBar progressBar = (ProgressBar) viewGroup.findViewById(R.id.cu6);
        if (progressBar != null) {
            b.a aVar = com.tencent.mm.plugin.finder.utils.b.vVa;
            p.h(progressBar, "progressBar");
            com.tencent.mm.plugin.finder.utils.b bVar3 = new com.tencent.mm.plugin.finder.utils.b();
            bVar3.gY = 1000;
            ah ahVar = new ah();
            ahVar.uuU = progressBar;
            bVar3.vUZ = ahVar;
            bVar2 = bVar3;
            ayVar = this;
        } else {
            bVar2 = null;
            ayVar = this;
        }
        ayVar.tux = bVar2;
        this.hSs = this.hSo;
        this.timerHandler = new MTimerHandler(new b(this), true);
        this.hSq.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.ay.AnonymousClass1 */
            final /* synthetic */ ay utv;

            {
                this.utv = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(246946);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveReadyPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.utv.timerHandler.stopTimer();
                this.utv.reset();
                this.utv.getLiveData().setLiveInfo(new awe());
                b.C0376b.a(this.utv.hOp, b.c.hLy);
                b.C0376b.a(this.utv.hOp, b.c.hMt);
                ac acVar = ac.vYp;
                ad.a aVar = ad.vZu;
                ac.a(acVar, ad.vZe.name, null, false, true, 6);
                if (this.utv.hOp.getLiveRole() == 1) {
                    k kVar = k.vkd;
                    k.q(s.a.LIVE_TIMER.hlf, "1");
                    k kVar2 = k.vkd;
                    k.b(s.o.LIVE_EXIT_CANCEL_TIMER);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveReadyPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(246946);
            }
        });
        com.tencent.mm.plugin.finder.utils.b bVar4 = this.tux;
        if (bVar4 != null) {
            bVar4.end();
            AppMethodBeat.o(246956);
            return;
        }
        AppMethodBeat.o(246956);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onTimerExpired"})
    static final class b implements MTimerHandler.CallBack {
        final /* synthetic */ ay utv;

        b(ay ayVar) {
            this.utv = ayVar;
        }

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(246949);
            if (this.utv.hSs > this.utv.hSp) {
                ay ayVar = this.utv;
                ayVar.hSs--;
                this.utv.aHG();
                AppMethodBeat.o(246949);
                return true;
            }
            ay ayVar2 = this.utv;
            ac acVar = ac.vYp;
            ad.a aVar = ad.vZu;
            ac.a(acVar, ad.vYY.name, null, false, false, 14);
            b.C0376b.a(ayVar2.hOp, b.c.hMw);
            com.tencent.mm.plugin.finder.utils.b bVar = ayVar2.tux;
            if (bVar != null) {
                bVar.begin();
            }
            TextView textView = ayVar2.hSr;
            p.g(textView, "countDownTv");
            textView.setVisibility(8);
            Button button = ayVar2.hSq;
            p.g(button, "cancelBtn");
            button.setVisibility(8);
            AppMethodBeat.o(246949);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final void reset() {
        AppMethodBeat.i(246950);
        TextView textView = this.hSr;
        p.g(textView, "countDownTv");
        textView.setScaleX(1.0f);
        TextView textView2 = this.hSr;
        p.g(textView2, "countDownTv");
        textView2.setScaleY(1.0f);
        this.hSs = this.hSo;
        com.tencent.mm.plugin.finder.utils.b bVar = this.tux;
        if (bVar != null) {
            bVar.end();
            AppMethodBeat.o(246950);
            return;
        }
        AppMethodBeat.o(246950);
    }

    /* access modifiers changed from: package-private */
    public final void aHG() {
        AppMethodBeat.i(246951);
        TextView textView = this.hSr;
        p.g(textView, "countDownTv");
        textView.setVisibility(0);
        TextView textView2 = this.hSr;
        p.g(textView2, "countDownTv");
        textView2.setText(String.valueOf(this.hSs));
        AppMethodBeat.o(246951);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d, com.tencent.mm.live.c.a
    public final void rg(int i2) {
        AppMethodBeat.i(246952);
        super.rg(i2);
        if (i2 == 8 || i2 == 4) {
            this.timerHandler.stopTimer();
            reset();
        }
        AppMethodBeat.o(246952);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        AppMethodBeat.i(246953);
        p.h(cVar, "status");
        super.statusChange(cVar, bundle);
        switch (az.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                Log.printInfoStack(this.TAG, "ILiveStatusLiveStatusREADY", new Object[0]);
                rg(0);
                Button button = this.hSq;
                p.g(button, "cancelBtn");
                button.setVisibility(0);
                aHG();
                this.timerHandler.startTimer(1000, 1000);
                com.tencent.mm.plugin.finder.utils.b bVar = this.tux;
                if (bVar != null) {
                    bVar.end();
                    AppMethodBeat.o(246953);
                    return;
                }
                AppMethodBeat.o(246953);
                return;
            case 2:
            case 3:
            case 4:
                rg(8);
                AppMethodBeat.o(246953);
                return;
            case 5:
                o oVar = o.ujN;
                com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = o.getFinderLiveAssistant();
                if (finderLiveAssistant != null) {
                    s.a.a(finderLiveAssistant, new a(this));
                    AppMethodBeat.o(246953);
                    return;
                }
                break;
        }
        AppMethodBeat.o(246953);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d, com.tencent.mm.live.c.a
    public final void unMount() {
        AppMethodBeat.i(246954);
        super.unMount();
        this.timerHandler.stopTimer();
        reset();
        AppMethodBeat.o(246954);
    }

    @Override // com.tencent.mm.live.c.a
    public final boolean onBackPress() {
        AppMethodBeat.i(246955);
        if (this.hwr.getVisibility() == 0) {
            this.timerHandler.stopTimer();
            getLiveData().setLiveInfo(new awe());
            reset();
            b.C0376b.a(this.hOp, b.c.hLy);
            ac acVar = ac.vYp;
            ad.a aVar = ad.vZu;
            ac.a(acVar, ad.vZe.name, null, false, true, 6);
            if (this.hOp.getLiveRole() == 1) {
                k kVar = k.vkd;
                k.q(s.a.LIVE_TIMER.hlf, "1");
                k kVar2 = k.vkd;
                k.b(s.o.LIVE_EXIT_CANCEL_TIMER);
            }
            AppMethodBeat.o(246955);
            return true;
        }
        AppMethodBeat.o(246955);
        return false;
    }
}
