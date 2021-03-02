package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.plugin.sight.decode.ui.b;
import com.tencent.mm.sdk.platformtools.MTimerHandler;

public class SnsAdStreamVideoView extends MMVideoView {
    public MTimerHandler FeB = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.sns.ui.widget.SnsAdStreamVideoView.AnonymousClass2 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(100472);
            SnsAdStreamVideoView.this.setIsShowBasicControls(false);
            AppMethodBeat.o(100472);
            return true;
        }
    }, false);

    static /* synthetic */ boolean a(SnsAdStreamVideoView snsAdStreamVideoView, int i2) {
        AppMethodBeat.i(163135);
        boolean G = snsAdStreamVideoView.G(i2, true);
        AppMethodBeat.o(163135);
        return G;
    }

    static /* synthetic */ void b(SnsAdStreamVideoView snsAdStreamVideoView) {
        AppMethodBeat.i(163136);
        snsAdStreamVideoView.fO(false);
        AppMethodBeat.o(163136);
    }

    public SnsAdStreamVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(100473);
        AppMethodBeat.o(100473);
    }

    public SnsAdStreamVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(100474);
        AppMethodBeat.o(100474);
    }

    @Override // com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public final int dEP() {
        return R.layout.buz;
    }

    public final void fld() {
        AppMethodBeat.i(100475);
        this.mEx.setVisibility(0);
        AppMethodBeat.o(100475);
    }

    public final void fle() {
        AppMethodBeat.i(100476);
        this.mEx.setVisibility(4);
        AppMethodBeat.o(100476);
    }

    @Override // com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public final b flf() {
        AppMethodBeat.i(100477);
        AnonymousClass1 r0 = new b() {
            /* class com.tencent.mm.plugin.sns.ui.widget.SnsAdStreamVideoView.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.sight.decode.ui.b
            public final void aJq() {
                AppMethodBeat.i(100470);
                SnsAdStreamVideoView.this.FeB.stopTimer();
                AppMethodBeat.o(100470);
            }

            @Override // com.tencent.mm.plugin.sight.decode.ui.b
            public final void rk(int i2) {
                AppMethodBeat.i(100471);
                if (SnsAdStreamVideoView.a(SnsAdStreamVideoView.this, i2)) {
                    SnsAdStreamVideoView.b(SnsAdStreamVideoView.this);
                }
                SnsAdStreamVideoView.this.KaT.setIsPlay(true);
                AppMethodBeat.o(100471);
            }
        };
        AppMethodBeat.o(100477);
        return r0;
    }

    public final void flg() {
        AppMethodBeat.i(100478);
        this.FeB.startTimer(5000, 0);
        AppMethodBeat.o(100478);
    }
}
