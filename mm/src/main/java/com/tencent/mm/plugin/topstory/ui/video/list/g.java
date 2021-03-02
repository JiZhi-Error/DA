package com.tencent.mm.plugin.topstory.ui.video.list;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.MTimerHandler;

public final class g extends com.tencent.mm.plugin.topstory.ui.video.g {
    MTimerHandler GoU;
    private View GpM = this.contentView.findViewById(R.id.dbz);
    private a GpN;

    public interface a {
        void fzK();

        void fzL();

        void update(int i2, int i3);
    }

    public g(Context context) {
        super(context);
        AppMethodBeat.i(126476);
        AppMethodBeat.o(126476);
    }

    public final void setFullScreenBtnClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(126477);
        this.GpM.setOnClickListener(onClickListener);
        AppMethodBeat.o(126477);
    }

    public final boolean bJw() {
        AppMethodBeat.i(126478);
        if (getVisibility() == 0) {
            AppMethodBeat.o(126478);
            return true;
        }
        AppMethodBeat.o(126478);
        return false;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.g
    public final void hide() {
        AppMethodBeat.i(263562);
        setVisibility(8);
        AppMethodBeat.o(263562);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.g
    public final void show() {
        AppMethodBeat.i(126480);
        setVisibility(0);
        fzN();
        if (this.GoU == null) {
            this.GoU = new MTimerHandler(new MTimerHandler.CallBack() {
                /* class com.tencent.mm.plugin.topstory.ui.video.list.g.AnonymousClass1 */

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public final boolean onTimerExpired() {
                    AppMethodBeat.i(126475);
                    g.this.setVisibility(8);
                    g.this.GoU.stopTimer();
                    AppMethodBeat.o(126475);
                    return false;
                }
            }, false);
        }
        this.GoU.stopTimer();
        this.GoU.startTimer(2000);
        AppMethodBeat.o(126480);
    }

    public final void crH() {
        AppMethodBeat.i(126481);
        if (this.GoU != null) {
            this.GoU.stopTimer();
        }
        AppMethodBeat.o(126481);
    }

    public final void bJB() {
        AppMethodBeat.i(126482);
        if (this.GoU != null) {
            this.GoU.stopTimer();
            this.GoU.startTimer(2000);
        }
        AppMethodBeat.o(126482);
    }

    @Override // com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar, com.tencent.mm.plugin.websearch.ui.WebSearchVideoPlayerSeekBar
    public final int getBarPointWidth() {
        AppMethodBeat.i(126483);
        int width = this.mCO.getWidth();
        AppMethodBeat.o(126483);
        return width;
    }

    public final void fzM() {
        AppMethodBeat.i(126484);
        this.mCP.setVisibility(8);
        AppMethodBeat.o(126484);
    }

    public final void fzN() {
        AppMethodBeat.i(126485);
        this.mCP.setVisibility(0);
        AppMethodBeat.o(126485);
    }

    @Override // com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar, com.tencent.mm.plugin.websearch.ui.WebSearchVideoPlayerSeekBar
    public final int getLayoutId() {
        return R.layout.c48;
    }

    public final void setVisibility(int i2) {
        AppMethodBeat.i(126486);
        super.setVisibility(i2);
        if (i2 == 8 || i2 == 4) {
            if (this.GpN != null) {
                this.GpN.fzL();
                AppMethodBeat.o(126486);
                return;
            }
        } else if (i2 == 0 && this.GpN != null) {
            this.GpN.fzK();
        }
        AppMethodBeat.o(126486);
    }

    @Override // com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar, com.tencent.mm.plugin.websearch.ui.WebSearchVideoPlayerSeekBar
    public final void bKO() {
        AppMethodBeat.i(126487);
        super.bKO();
        if (this.GpN != null) {
            this.GpN.update(this.mPosition, getVideoTotalTime());
        }
        AppMethodBeat.o(126487);
    }

    public final void setOnUpdateProgressLenListener(a aVar) {
        this.GpN = aVar;
    }
}
