package com.tencent.mm.live.c;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.live.b.x;
import com.tencent.mm.live.c.b;
import com.tencent.mm.protocal.protobuf.civ;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\bH\u0016J\u0006\u0010\u0019\u001a\u00020\u0015J\b\u0010\u001a\u001a\u00020\u0015H\u0002J\u001a\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0006\u0010 \u001a\u00020\u0015J\b\u0010!\u001a\u00020\u0015H\u0016R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \f*\u0004\u0018\u00010\u000e0\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, hxF = {"Lcom/tencent/mm/live/plugin/LiveReadyPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "COUNT_DOWN_END", "", "COUNT_DOWN_START", "cancelBtn", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "countDownTv", "Landroid/widget/TextView;", "curCountDown", "timerHandler", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "onBackPress", "", "reset", "", "setTextWithAnim", "setVisible", "visible", "startCountDown", "startLive", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "stopCountDown", "unMount", "plugin-logic_release"})
public final class aq extends a {
    final b hOp;
    private final int hSo = 3;
    final int hSp;
    private final Button hSq;
    private final TextView hSr;
    int hSs;
    final MTimerHandler timerHandler;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public aq(ViewGroup viewGroup, b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(208151);
        this.hOp = bVar;
        this.hSq = (Button) viewGroup.findViewById(R.id.ek9);
        this.hSr = (TextView) viewGroup.findViewById(R.id.eka);
        this.hSs = this.hSo;
        this.timerHandler = new MTimerHandler(new a(this), true);
        this.hSq.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.live.c.aq.AnonymousClass1 */
            final /* synthetic */ aq hSt;

            {
                this.hSt = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(208142);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveReadyPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.hSt.timerHandler.stopTimer();
                this.hSt.reset();
                x xVar = x.hJf;
                x.a(new civ());
                b.C0376b.a(this.hSt.hOp, b.c.hLy);
                b.C0376b.a(this.hSt.hOp, b.c.hMt);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveReadyPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(208142);
            }
        });
        AppMethodBeat.o(208151);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onTimerExpired"})
    static final class a implements MTimerHandler.CallBack {
        final /* synthetic */ aq hSt;

        a(aq aqVar) {
            this.hSt = aqVar;
        }

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(208144);
            if (this.hSt.hSs > this.hSt.hSp) {
                aq aqVar = this.hSt;
                aqVar.hSs--;
                this.hSt.aHG();
                AppMethodBeat.o(208144);
                return true;
            }
            b.C0376b.a(this.hSt.hOp, b.c.hMw);
            AppMethodBeat.o(208144);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final void reset() {
        AppMethodBeat.i(208145);
        TextView textView = this.hSr;
        p.g(textView, "countDownTv");
        textView.setScaleX(1.0f);
        TextView textView2 = this.hSr;
        p.g(textView2, "countDownTv");
        textView2.setScaleY(1.0f);
        this.hSs = this.hSo;
        AppMethodBeat.o(208145);
    }

    /* access modifiers changed from: package-private */
    public final void aHG() {
        AppMethodBeat.i(208146);
        TextView textView = this.hSr;
        p.g(textView, "countDownTv");
        textView.setText(String.valueOf(this.hSs));
        TextView textView2 = this.hSr;
        p.g(textView2, "countDownTv");
        textView2.setScaleX(1.5f);
        TextView textView3 = this.hSr;
        p.g(textView3, "countDownTv");
        textView3.setScaleY(1.5f);
        this.hSr.animate().scaleX(1.0f).scaleY(1.0f).setDuration(200).start();
        AppMethodBeat.o(208146);
    }

    @Override // com.tencent.mm.live.c.a
    public final void rg(int i2) {
        AppMethodBeat.i(208147);
        super.rg(i2);
        if (i2 == 8 || i2 == 4) {
            this.timerHandler.stopTimer();
            reset();
        }
        AppMethodBeat.o(208147);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        AppMethodBeat.i(208148);
        p.h(cVar, "status");
        super.statusChange(cVar, bundle);
        switch (ar.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                rg(0);
                aHG();
                this.timerHandler.startTimer(1000, 1000);
                AppMethodBeat.o(208148);
                return;
            case 2:
            case 3:
            case 4:
                rg(8);
                AppMethodBeat.o(208148);
                return;
            case 5:
                x xVar = x.hJf;
                x.eL(true);
                com.tencent.mm.live.d.a.aHX();
                break;
        }
        AppMethodBeat.o(208148);
    }

    @Override // com.tencent.mm.live.c.a
    public final void unMount() {
        AppMethodBeat.i(208149);
        this.timerHandler.stopTimer();
        reset();
        AppMethodBeat.o(208149);
    }

    @Override // com.tencent.mm.live.c.a
    public final boolean onBackPress() {
        AppMethodBeat.i(208150);
        if (this.hwr.getVisibility() == 0) {
            this.timerHandler.stopTimer();
            reset();
            x xVar = x.hJf;
            x.a(new civ());
            b.C0376b.a(this.hOp, b.c.hLy);
            AppMethodBeat.o(208150);
            return true;
        }
        AppMethodBeat.o(208150);
        return false;
    }
}
