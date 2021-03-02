package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import android.content.Context;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.multitalk.ui.widget.projector.a;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010 \u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\"J\b\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020$H\u0002J\u000e\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020\nJ\u0006\u0010(\u001a\u00020$J\b\u0010)\u001a\u00020$H\u0002J\u0006\u0010*\u001a\u00020$R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenReadyUI;", "", "context", "Landroid/content/Context;", "statusManager", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "config", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;)V", "COUNT_DOWN_END", "", "COUNT_DOWN_START", "getConfig", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;", "setConfig", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "countDownDetail", "Landroid/widget/TextView;", "countDownTv", "curCountDown", "readyUiLayout", "Landroid/view/View;", "getStatusManager", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "setStatusManager", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "timerHandler", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getReadyLayout", "rootView", "Landroid/widget/FrameLayout;", "reset", "", "setTextWithAnim", "setVisible", "visible", "startCountDown", "startScreenProject", "stopCountDown", "plugin-multitalk_release"})
public final class r {
    private Context context;
    final int hSo = 4;
    final int hSp = 1;
    TextView hSr;
    int hSs = this.hSo;
    MTimerHandler timerHandler = new MTimerHandler(new a(this), true);
    private a zQD;
    e zQw;
    View zYc;
    TextView zYd;

    public r(Context context2, a aVar, e eVar) {
        p.h(context2, "context");
        p.h(aVar, "statusManager");
        AppMethodBeat.i(240063);
        this.context = context2;
        this.zQD = aVar;
        this.zQw = eVar;
        AppMethodBeat.o(240063);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onTimerExpired"})
    static final class a implements MTimerHandler.CallBack {
        final /* synthetic */ r zYe;

        a(r rVar) {
            this.zYe = rVar;
        }

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(240060);
            if (this.zYe.hSs > this.zYe.hSp) {
                r rVar = this.zYe;
                rVar.hSs--;
                this.zYe.aHG();
                AppMethodBeat.o(240060);
                return true;
            }
            this.zYe.epK();
            AppMethodBeat.o(240060);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final void epK() {
        AppMethodBeat.i(240061);
        a.b.a(this.zQD, a.c.SCREEN_READY_UI_FINISH);
        AppMethodBeat.o(240061);
    }

    /* access modifiers changed from: package-private */
    public final void aHG() {
        ViewPropertyAnimator animate;
        ViewPropertyAnimator scaleX;
        ViewPropertyAnimator scaleY;
        ViewPropertyAnimator duration;
        AppMethodBeat.i(240062);
        TextView textView = this.hSr;
        if (textView != null) {
            textView.setText(String.valueOf(this.hSs));
        }
        TextView textView2 = this.zYd;
        if (textView2 != null) {
            Context context2 = this.context;
            textView2.setText((context2 != null ? context2.getResources() : null).getString(R.string.fum));
        }
        TextView textView3 = this.hSr;
        if (textView3 != null) {
            textView3.setScaleX(1.5f);
        }
        TextView textView4 = this.hSr;
        if (textView4 != null) {
            textView4.setScaleY(1.5f);
        }
        TextView textView5 = this.hSr;
        if (textView5 == null || (animate = textView5.animate()) == null || (scaleX = animate.scaleX(1.0f)) == null || (scaleY = scaleX.scaleY(1.0f)) == null || (duration = scaleY.setDuration(200)) == null) {
            AppMethodBeat.o(240062);
            return;
        }
        duration.start();
        AppMethodBeat.o(240062);
    }
}
