package com.tencent.mm.plugin.brandservice.ui.timeline.video.lite;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.video.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.VideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.ui.ar;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class VideoLiteControBar extends VideoPlayerSeekBar implements e.a, e.b {
    private View gvQ;
    private ImageView mDf;
    private e.i mDm;
    private MTimerHandler mDn;
    private boolean mDo;
    private boolean mDp;
    private boolean mDq;
    private boolean mDr;
    private boolean mDs;
    private boolean mDt;
    private boolean mDu;
    private boolean mDv = true;
    private e.AbstractC0717e mDw;
    private ConcurrentLinkedQueue<e.f> mDx = new ConcurrentLinkedQueue<>();
    private MTimerHandler mww;
    private ImageView pJX;
    private View pJY;
    private a pJZ;

    public interface a {
        void kr(boolean z);
    }

    static /* synthetic */ boolean b(VideoLiteControBar videoLiteControBar) {
        AppMethodBeat.i(195060);
        boolean bKX = videoLiteControBar.bKX();
        AppMethodBeat.o(195060);
        return bKX;
    }

    public VideoLiteControBar(Context context) {
        super(context);
        AppMethodBeat.i(195027);
        AppMethodBeat.o(195027);
    }

    public VideoLiteControBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(195028);
        AppMethodBeat.o(195028);
    }

    public VideoLiteControBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(195029);
        AppMethodBeat.o(195029);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public void setStatePorter(e.i iVar) {
        this.mDm = iVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public final void onDestroy() {
        AppMethodBeat.i(195030);
        if (this.mww != null) {
            this.mww.stopTimer();
        }
        if (this.mDn != null) {
            this.mDn.stopTimer();
        }
        AppMethodBeat.o(195030);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.AdVideoPlayerLoadingBar, com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.VideoPlayerSeekBar
    public int getLayoutId() {
        return R.layout.c5f;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.AdVideoPlayerLoadingBar, com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.VideoPlayerSeekBar
    public final void init() {
        AppMethodBeat.i(195031);
        super.init();
        this.mDf = (ImageView) this.contentView.findViewById(R.id.gcy);
        this.pJX = (ImageView) findViewById(R.id.j43);
        this.gvQ = findViewById(R.id.h8v);
        this.pJY = findViewById(R.id.bfo);
        AppMethodBeat.o(195031);
    }

    public void setBtnCloseListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(195032);
        this.pJX.setOnClickListener(onClickListener);
        AppMethodBeat.o(195032);
    }

    public void setOnPlayStatusChangeListener(a aVar) {
        this.pJZ = aVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public void setMuteBtnOnClickListener(View.OnClickListener onClickListener) {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public void setExitFullScreenBtnOnClickListener(View.OnClickListener onClickListener) {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.AdVideoPlayerLoadingBar, com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public void setOnPlayButtonClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(195033);
        super.setOnPlayButtonClickListener(onClickListener);
        AppMethodBeat.o(195033);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public void setTitle(String str) {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public void setShowMuteBtn(boolean z) {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public void setMuteBtnState(boolean z) {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public void setShowControlProgress(boolean z) {
        AppMethodBeat.i(195034);
        this.mDs = z;
        bKY();
        AppMethodBeat.o(195034);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public void setPlayBtnInCenterPosition(boolean z) {
        AppMethodBeat.i(195035);
        this.mDu = z;
        bKQ();
        AppMethodBeat.o(195035);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public final void bIZ() {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public final void bJC() {
    }

    private void bKQ() {
        AppMethodBeat.i(195036);
        if (!this.mDt || this.mDu) {
            this.mCP.setVisibility(8);
            AppMethodBeat.o(195036);
            return;
        }
        this.mCP.setVisibility(0);
        AppMethodBeat.o(195036);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.AdVideoPlayerLoadingBar, com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.VideoPlayerSeekBar, com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public void setIsPlay(boolean z) {
        AppMethodBeat.i(195037);
        this.dLB = z;
        if (this.dLB) {
            this.mCP.setImageDrawable(ar.m(getContext(), R.raw.icons_filled_pause, -1));
        } else {
            this.mCP.setImageDrawable(ar.m(getContext(), R.raw.icons_filled_play, -1));
        }
        if (this.pJZ != null) {
            this.pJZ.kr(z);
        }
        AppMethodBeat.o(195037);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public void setFullScreenBtnOnClickListener(View.OnClickListener onClickListener) {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public void setDanmakuBtnOnClickListener(e.g gVar) {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public final boolean bJt() {
        return this.mDp;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public void setDanmakuBtnOpen(boolean z) {
        this.mDp = z;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public void setShowDanmakuBtn(boolean z) {
    }

    public void setAutoHide(boolean z) {
        this.mDv = z;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public final void bJv() {
        AppMethodBeat.i(195038);
        setVisibility(0);
        if (!this.mDv) {
            AppMethodBeat.o(195038);
            return;
        }
        if (this.mDn == null) {
            this.mDn = new MTimerHandler(new MTimerHandler.CallBack() {
                /* class com.tencent.mm.plugin.brandservice.ui.timeline.video.lite.VideoLiteControBar.AnonymousClass1 */

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public final boolean onTimerExpired() {
                    AppMethodBeat.i(195025);
                    VideoLiteControBar.this.setVisibility(8);
                    VideoLiteControBar.this.mDn.stopTimer();
                    AppMethodBeat.o(195025);
                    return false;
                }
            }, false);
        }
        this.mDn.stopTimer();
        this.mDn.startTimer(7000);
        AppMethodBeat.o(195038);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public final void bJB() {
        AppMethodBeat.i(195039);
        if (this.mDn != null) {
            this.mDn.stopTimer();
            this.mDn.startTimer(7000);
        }
        AppMethodBeat.o(195039);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public final void hide() {
        AppMethodBeat.i(195040);
        setVisibility(8);
        AppMethodBeat.o(195040);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public final boolean bJw() {
        AppMethodBeat.i(195041);
        if (getVisibility() == 0) {
            AppMethodBeat.o(195041);
            return true;
        }
        AppMethodBeat.o(195041);
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public final void bJu() {
        AppMethodBeat.i(195042);
        if (bJw()) {
            setVisibility(8);
            AppMethodBeat.o(195042);
            return;
        }
        bJv();
        AppMethodBeat.o(195042);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public final void KD() {
        AppMethodBeat.i(195043);
        this.mDo = true;
        bKT();
        AppMethodBeat.o(195043);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public final void bGL() {
        AppMethodBeat.i(195044);
        this.mDo = false;
        bKT();
        AppMethodBeat.o(195044);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public final boolean bJx() {
        return this.mDo;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public final boolean bJy() {
        return this.mDv;
    }

    private void bKT() {
        AppMethodBeat.i(195045);
        bKV();
        bKU();
        AppMethodBeat.o(195045);
    }

    private void bKU() {
        int dimensionPixelSize;
        AppMethodBeat.i(195046);
        if (this.mDo) {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.sj);
        } else {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.s_);
        }
        if (this.mCP != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mCP.getLayoutParams();
            marginLayoutParams.setMarginStart(dimensionPixelSize);
            this.mCP.setLayoutParams(marginLayoutParams);
        }
        AppMethodBeat.o(195046);
    }

    private void bKV() {
        float dimensionPixelSize;
        AppMethodBeat.i(195047);
        if (this.mDo) {
            dimensionPixelSize = (float) getResources().getDimensionPixelSize(R.dimen.sm);
        } else {
            dimensionPixelSize = (float) getResources().getDimensionPixelSize(R.dimen.sf);
        }
        this.mCQ.setTextSize(0, dimensionPixelSize);
        this.mCR.setTextSize(0, dimensionPixelSize);
        AppMethodBeat.o(195047);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public final void bJz() {
        AppMethodBeat.i(195048);
        if (this.mww == null) {
            this.mww = new MTimerHandler(new MTimerHandler.CallBack() {
                /* class com.tencent.mm.plugin.brandservice.ui.timeline.video.lite.VideoLiteControBar.AnonymousClass2 */

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public final boolean onTimerExpired() {
                    AppMethodBeat.i(195026);
                    if (!VideoLiteControBar.b(VideoLiteControBar.this)) {
                        AppMethodBeat.o(195026);
                        return false;
                    }
                    AppMethodBeat.o(195026);
                    return true;
                }
            }, true);
        }
        bKX();
        this.mww.stopTimer();
        this.mww.startTimer(500);
        AppMethodBeat.o(195048);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public final void bJA() {
        AppMethodBeat.i(195049);
        if (this.mww != null) {
            this.mww.stopTimer();
        }
        AppMethodBeat.o(195049);
    }

    private boolean bKX() {
        int i2;
        AppMethodBeat.i(195050);
        if (this.mDm == null) {
            Log.i("MicroMsg.VideoLiteControlBar", "updateMiddleBar mStatePorter null");
            AppMethodBeat.o(195050);
            return false;
        }
        int bJh = this.mDm.bJh();
        int bJi = this.mDm.bJi();
        if (bJh < 0 || bJi < 0) {
            AppMethodBeat.o(195050);
            return false;
        }
        if (bJh > bJi) {
            bJh = bJi;
        }
        int barLen = getBarLen();
        if (barLen <= 0) {
            AppMethodBeat.o(195050);
            return true;
        }
        if (bJi == 0) {
            i2 = 0;
        } else {
            i2 = (int) (((((double) bJh) * 1.0d) / ((double) bJi)) * ((double) barLen));
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mDf.getLayoutParams();
        layoutParams.width = i2;
        this.mDf.setLayoutParams(layoutParams);
        AppMethodBeat.o(195050);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.AdVideoPlayerLoadingBar, com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.VideoPlayerSeekBar, com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public final void seek(int i2) {
        AppMethodBeat.i(195051);
        super.seek(i2);
        em(this.mPosition, this.mCS);
        AppMethodBeat.o(195051);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.AdVideoPlayerLoadingBar, com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.VideoPlayerSeekBar
    public final void bKO() {
        AppMethodBeat.i(195052);
        if (this.mCS == 0) {
            AppMethodBeat.o(195052);
        } else if (this.mbo) {
            AppMethodBeat.o(195052);
        } else if (this.mCO == null) {
            AppMethodBeat.o(195052);
        } else {
            this.mCQ.setText(xt(this.mPosition / 60) + ":" + xt(this.mPosition % 60));
            if (getBarLen() == 0) {
                AppMethodBeat.o(195052);
                return;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mCO.getLayoutParams();
            int barLen = getBarLen();
            layoutParams.leftMargin = en(this.mPosition, barLen);
            this.mCO.setLayoutParams(layoutParams);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.mCM.getLayoutParams();
            layoutParams2.width = (int) (((((double) this.mPosition) * 1.0d) / ((double) this.mCS)) * ((double) barLen));
            this.mCM.setLayoutParams(layoutParams2);
            requestLayout();
            em(this.mPosition, this.mCS);
            AppMethodBeat.o(195052);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public void setShowFullScreenBtn(boolean z) {
        this.mDq = z;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public void setShowPlayBtn(boolean z) {
        AppMethodBeat.i(195053);
        this.mDt = z;
        bKQ();
        AppMethodBeat.o(195053);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public void setShowProgress(boolean z) {
        AppMethodBeat.i(195054);
        this.mDr = z;
        bKY();
        AppMethodBeat.o(195054);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public final boolean bJD() {
        return false;
    }

    private void bKY() {
        boolean z;
        int i2;
        int i3 = 0;
        AppMethodBeat.i(195055);
        if (this.mDs) {
            z = this.mDr;
        } else {
            z = false;
        }
        TextView textView = this.mCQ;
        if (z) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        textView.setVisibility(i2);
        TextView textView2 = this.mCR;
        if (!z) {
            i3 = 8;
        }
        textView2.setVisibility(i3);
        AppMethodBeat.o(195055);
    }

    private void em(int i2, int i3) {
        AppMethodBeat.i(195056);
        if (this.mDw != null) {
            this.mDw.onProgressChanged(i2, i3);
        }
        AppMethodBeat.o(195056);
    }

    public void setVisibility(int i2) {
        AppMethodBeat.i(195057);
        super.setVisibility(i2);
        if (i2 == 0) {
            Iterator<e.f> it = this.mDx.iterator();
            while (it.hasNext()) {
                e.f next = it.next();
                if (next != null) {
                    next.onVisibilityChanged(true);
                }
            }
            AppMethodBeat.o(195057);
            return;
        }
        if (i2 == 8 || i2 == 4) {
            Iterator<e.f> it2 = this.mDx.iterator();
            while (it2.hasNext()) {
                e.f next2 = it2.next();
                if (next2 != null) {
                    next2.onVisibilityChanged(false);
                }
            }
        }
        AppMethodBeat.o(195057);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public void setOnUpdateProgressLenListener(e.AbstractC0717e eVar) {
        this.mDw = eVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public final void a(e.f fVar) {
        AppMethodBeat.i(195058);
        this.mDx.add(fVar);
        AppMethodBeat.o(195058);
    }

    public final void e(Configuration configuration) {
        AppMethodBeat.i(195059);
        if (configuration.orientation == 1) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.pJY.getLayoutParams();
            layoutParams.addRule(2, R.id.j43);
            layoutParams.removeRule(8);
            layoutParams.removeRule(1);
            layoutParams.setMargins(com.tencent.mm.cb.a.aH(getContext(), R.dimen.ce), 0, com.tencent.mm.cb.a.aH(getContext(), R.dimen.ce), 0);
            this.pJY.setLayoutParams(layoutParams);
            ((RelativeLayout.LayoutParams) this.pJX.getLayoutParams()).setMargins(com.tencent.mm.cb.a.aH(getContext(), R.dimen.ce), com.tencent.mm.cb.a.aH(getContext(), R.dimen.ce), 0, 0);
            ((RelativeLayout.LayoutParams) this.gvQ.getLayoutParams()).setMargins(0, 0, 0, com.tencent.mm.cb.a.aH(getContext(), R.dimen.cb));
            AppMethodBeat.o(195059);
            return;
        }
        if (configuration.orientation == 2) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.pJY.getLayoutParams();
            layoutParams2.removeRule(2);
            layoutParams2.addRule(8, R.id.j43);
            layoutParams2.addRule(1, R.id.j43);
            layoutParams2.setMargins(com.tencent.mm.cb.a.aH(getContext(), R.dimen.cp), 0, com.tencent.mm.cb.a.aH(getContext(), R.dimen.ce), 0);
            this.pJY.setLayoutParams(layoutParams2);
            int aH = com.tencent.mm.cb.a.aH(getContext(), R.dimen.ce);
            ((RelativeLayout.LayoutParams) this.pJX.getLayoutParams()).setMargins(aH, com.tencent.mm.cb.a.aH(getContext(), R.dimen.cb), 0, com.tencent.mm.cb.a.fromDPToPix(getContext(), -5));
            ((RelativeLayout.LayoutParams) this.gvQ.getLayoutParams()).setMargins(aH, 0, 0, com.tencent.mm.cb.a.aH(getContext(), R.dimen.cl));
        }
        AppMethodBeat.o(195059);
    }
}
