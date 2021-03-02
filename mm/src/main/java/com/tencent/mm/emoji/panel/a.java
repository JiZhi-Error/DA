package com.tencent.mm.emoji.panel;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/emoji/panel/TouchToClick;", "Landroid/view/View$OnTouchListener;", "()V", "clickHandler", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "clicked", "", "cancel", "", "onTouch", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "plugin-emojisdk_release"})
public final class a implements View.OnTouchListener {
    MTimerHandler hat;
    private boolean hau;

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        AppMethodBeat.i(105625);
        p.h(view, "v");
        p.h(motionEvent, "event");
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.hau = false;
                this.hat = new MTimerHandler(new C0331a(this, view), true);
                MTimerHandler mTimerHandler = this.hat;
                if (mTimerHandler != null) {
                    mTimerHandler.startTimer((long) ViewConfiguration.getKeyRepeatTimeout(), (long) ViewConfiguration.getKeyRepeatDelay());
                    break;
                }
                break;
            case 1:
            case 3:
                MTimerHandler mTimerHandler2 = this.hat;
                if (mTimerHandler2 != null) {
                    mTimerHandler2.stopTimer();
                }
                this.hat = null;
                if (!this.hau && motionEvent.getActionMasked() == 1) {
                    view.performClick();
                    break;
                }
        }
        AppMethodBeat.o(105625);
        return true;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onTimerExpired"})
    /* renamed from: com.tencent.mm.emoji.panel.a$a  reason: collision with other inner class name */
    static final class C0331a implements MTimerHandler.CallBack {
        final /* synthetic */ a hav;
        final /* synthetic */ View haw;

        C0331a(a aVar, View view) {
            this.hav = aVar;
            this.haw = view;
        }

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(105624);
            this.hav.hau = true;
            boolean performClick = this.haw.performClick();
            AppMethodBeat.o(105624);
            return performClick;
        }
    }
}
