package com.tencent.mm.plugin.websearch.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;

public class WebSearchWebVideoViewControlBar extends WebSearchVideoPlayerSeekBar {
    private static int IGY = -1;
    private ImageView IGW;
    private a IGX;
    private ImageView mDc;
    private ImageView mDf;
    private FrameLayout mDg;
    private ImageView mDh;
    public MTimerHandler mDn;
    public boolean mDo;
    public MTimerHandler mww;
    protected RelativeLayout qAE;

    public interface a {
        int bJh();

        int bJi();

        int fYO();
    }

    static /* synthetic */ boolean b(WebSearchWebVideoViewControlBar webSearchWebVideoViewControlBar) {
        AppMethodBeat.i(110274);
        boolean bKX = webSearchWebVideoViewControlBar.bKX();
        AppMethodBeat.o(110274);
        return bKX;
    }

    public WebSearchWebVideoViewControlBar(Context context) {
        super(context);
    }

    public WebSearchWebVideoViewControlBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WebSearchWebVideoViewControlBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void setStatePorter(a aVar) {
        this.IGX = aVar;
    }

    @Override // com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar, com.tencent.mm.plugin.websearch.ui.WebSearchVideoPlayerSeekBar
    public int getLayoutId() {
        return R.layout.ao4;
    }

    @Override // com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar, com.tencent.mm.plugin.websearch.ui.WebSearchVideoPlayerSeekBar
    public final void init() {
        AppMethodBeat.i(110253);
        super.init();
        this.mDc = (ImageView) this.contentView.findViewById(R.id.dbs);
        this.mDh = (ImageView) this.contentView.findViewById(R.id.j9n);
        this.mDf = (ImageView) this.contentView.findViewById(R.id.gcy);
        this.mDg = (FrameLayout) this.contentView.findViewById(R.id.gd1);
        this.qAE = (RelativeLayout) findViewById(R.id.h8v);
        this.IGW = (ImageView) this.contentView.findViewById(R.id.c6j);
        if (IGY < 0) {
            IGY = getResources().getDimensionPixelSize(R.dimen.a8b);
        }
        AppMethodBeat.o(110253);
    }

    @Override // com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar, com.tencent.mm.plugin.sight.decode.ui.a, com.tencent.mm.plugin.websearch.ui.WebSearchVideoPlayerSeekBar
    public void setIsPlay(boolean z) {
        AppMethodBeat.i(110254);
        this.dLB = z;
        fYM();
        AppMethodBeat.o(110254);
    }

    @Override // com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar, com.tencent.mm.plugin.websearch.ui.WebSearchVideoPlayerSeekBar
    public int getBarPointWidth() {
        AppMethodBeat.i(110255);
        int width = this.mCO.getWidth();
        AppMethodBeat.o(110255);
        return width;
    }

    private void fYM() {
        AppMethodBeat.i(110256);
        if (!this.mDo) {
            if (this.dLB) {
                this.mCP.setImageResource(R.drawable.c_3);
                AppMethodBeat.o(110256);
                return;
            }
            this.mCP.setImageResource(R.drawable.c_7);
            AppMethodBeat.o(110256);
        } else if (this.dLB) {
            this.mCP.setImageResource(R.drawable.c_3);
            AppMethodBeat.o(110256);
        } else {
            this.mCP.setImageResource(R.drawable.c_7);
            AppMethodBeat.o(110256);
        }
    }

    public final void ard() {
        AppMethodBeat.i(110257);
        this.mDh.setImageResource(R.drawable.c_9);
        AppMethodBeat.o(110257);
    }

    public final void fYN() {
        AppMethodBeat.i(110258);
        this.mDh.setImageResource(R.drawable.c_6);
        AppMethodBeat.o(110258);
    }

    public void setMuteBtnOnClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(110259);
        this.mDh.setOnClickListener(onClickListener);
        AppMethodBeat.o(110259);
    }

    public void setEnterFullScreenBtnClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(110260);
        this.mDc.setOnClickListener(onClickListener);
        AppMethodBeat.o(110260);
    }

    public void setExitFullScreenBtnClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(110261);
        this.IGW.setOnClickListener(onClickListener);
        AppMethodBeat.o(110261);
    }

    private void bKS() {
        AppMethodBeat.i(110262);
        if (this.mDo) {
            this.mDc.setImageResource(R.raw.fts_web_video_fullscreen_op_fullscreen_btn);
            this.mDc.setVisibility(8);
            this.IGW.setVisibility(0);
            AppMethodBeat.o(110262);
            return;
        }
        this.IGW.setVisibility(8);
        this.mDc.setVisibility(0);
        this.mDc.setImageResource(R.drawable.c_5);
        AppMethodBeat.o(110262);
    }

    public final void crH() {
        AppMethodBeat.i(110263);
        if (this.mDn != null) {
            this.mDn.stopTimer();
        }
        AppMethodBeat.o(110263);
    }

    public final void bJB() {
        AppMethodBeat.i(110264);
        if (this.mDn != null) {
            this.mDn.stopTimer();
            this.mDn.startTimer(2000);
        }
        AppMethodBeat.o(110264);
    }

    public final void bGL() {
        AppMethodBeat.i(110266);
        this.mDo = false;
        bKT();
        AppMethodBeat.o(110266);
    }

    public final void bKT() {
        AppMethodBeat.i(110267);
        bKW();
        bKS();
        fYM();
        bKV();
        AppMethodBeat.o(110267);
    }

    private void bKV() {
        float dimensionPixelSize;
        AppMethodBeat.i(110268);
        if (this.mDo) {
            dimensionPixelSize = (float) getResources().getDimensionPixelSize(R.dimen.a8a);
        } else {
            dimensionPixelSize = (float) getResources().getDimensionPixelSize(R.dimen.a89);
        }
        this.mCQ.setTextSize(0, dimensionPixelSize);
        this.mCR.setTextSize(0, dimensionPixelSize);
        AppMethodBeat.o(110268);
    }

    private void bKW() {
        AppMethodBeat.i(110269);
        ViewGroup.LayoutParams layoutParams = this.qAE.getLayoutParams();
        if (this.mDo) {
            layoutParams.height = getResources().getDimensionPixelSize(R.dimen.a8_);
        } else {
            layoutParams.height = getResources().getDimensionPixelSize(R.dimen.a88);
        }
        this.qAE.setLayoutParams(layoutParams);
        AppMethodBeat.o(110269);
    }

    public final boolean bKX() {
        AppMethodBeat.i(110270);
        if (this.IGX == null) {
            Log.i("MicroMsg.FtsWebVideoViewControlBar", "updateMiddleBar mStatePorter null");
            AppMethodBeat.o(110270);
            return false;
        }
        int bJh = this.IGX.bJh();
        int bJi = this.IGX.bJi();
        if (bJh < 0 || bJi < 0) {
            AppMethodBeat.o(110270);
            return false;
        }
        int width = this.mDg.getWidth();
        if (width <= 0) {
            AppMethodBeat.o(110270);
            return true;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mDf.getLayoutParams();
        if (bJi != 0) {
            width = (int) (((float) width) * (1.0f - (((float) bJh) / ((float) bJi))));
        }
        if (width <= 0) {
            width = 0;
        }
        layoutParams.rightMargin = width + IGY;
        this.mDf.setLayoutParams(layoutParams);
        if (bJh < bJi || bJi == 0) {
            AppMethodBeat.o(110270);
            return true;
        }
        AppMethodBeat.o(110270);
        return false;
    }

    public final void fzM() {
        AppMethodBeat.i(110271);
        this.mCP.setVisibility(8);
        AppMethodBeat.o(110271);
    }

    public final void fzN() {
        AppMethodBeat.i(110272);
        this.mCP.setVisibility(0);
        AppMethodBeat.o(110272);
    }

    @Override // com.tencent.mm.plugin.websearch.ui.WebSearchVideoPlayerSeekBar, com.tencent.mm.pluginsdk.ui.h
    public final void xv(int i2) {
        AppMethodBeat.i(110273);
        seek((int) Math.ceil((((double) this.IGX.fYO()) * 1.0d) / 1000.0d));
        AppMethodBeat.o(110273);
    }

    /* access modifiers changed from: protected */
    public ImageView getExitFullscreenIv() {
        return this.IGW;
    }

    public final void yQ(boolean z) {
        boolean z2;
        AppMethodBeat.i(110265);
        if (getVisibility() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            setVisibility(8);
            AppMethodBeat.o(110265);
            return;
        }
        setVisibility(0);
        if (!z) {
            fzN();
        } else {
            fzM();
        }
        if (this.mDn == null) {
            this.mDn = new MTimerHandler(new MTimerHandler.CallBack() {
                /* class com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar.AnonymousClass1 */

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public final boolean onTimerExpired() {
                    AppMethodBeat.i(110251);
                    WebSearchWebVideoViewControlBar.this.setVisibility(8);
                    WebSearchWebVideoViewControlBar.this.mDn.stopTimer();
                    AppMethodBeat.o(110251);
                    return false;
                }
            }, false);
        }
        this.mDn.stopTimer();
        this.mDn.startTimer(2000);
        AppMethodBeat.o(110265);
    }
}
