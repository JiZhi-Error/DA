package com.tencent.mm.plugin.appbrand.jsapi.video.progressbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class AppBrandVideoViewControlBar extends VideoPlayerSeekBar implements e.a, e.b {
    private TextView ayz;
    private ImageView mDc;
    private ImageView mDd;
    private LinearLayout mDe;
    private ImageView mDf;
    private FrameLayout mDg;
    private ImageView mDh;
    private ImageView mDi;
    private ImageView mDj;
    private LinearLayout mDk;
    private LinearLayout mDl;
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

    static /* synthetic */ boolean d(AppBrandVideoViewControlBar appBrandVideoViewControlBar) {
        AppMethodBeat.i(235128);
        boolean bKX = appBrandVideoViewControlBar.bKX();
        AppMethodBeat.o(235128);
        return bKX;
    }

    public AppBrandVideoViewControlBar(Context context) {
        super(context);
        AppMethodBeat.i(235079);
        AppMethodBeat.o(235079);
    }

    public AppBrandVideoViewControlBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(235080);
        AppMethodBeat.o(235080);
    }

    public AppBrandVideoViewControlBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(235081);
        AppMethodBeat.o(235081);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public void setStatePorter(e.i iVar) {
        this.mDm = iVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public final void onDestroy() {
        AppMethodBeat.i(235082);
        if (this.mww != null) {
            this.mww.stopTimer();
        }
        if (this.mDn != null) {
            this.mDn.stopTimer();
        }
        AppMethodBeat.o(235082);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.AdVideoPlayerLoadingBar, com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.VideoPlayerSeekBar
    public int getLayoutId() {
        return R.layout.g5;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.AdVideoPlayerLoadingBar, com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.VideoPlayerSeekBar
    public final void init() {
        AppMethodBeat.i(235083);
        super.init();
        this.mDc = (ImageView) this.contentView.findViewById(R.id.dbs);
        this.mDd = (ImageView) this.contentView.findViewById(R.id.bk_);
        this.mDf = (ImageView) this.contentView.findViewById(R.id.gcy);
        this.mDg = (FrameLayout) this.contentView.findViewById(R.id.gd1);
        this.mDe = (LinearLayout) findViewById(R.id.h8v);
        this.mDh = (ImageView) findViewById(R.id.fqr);
        this.mDi = (ImageView) findViewById(R.id.aqa);
        this.mDj = (ImageView) findViewById(R.id.c6j);
        this.ayz = (TextView) findViewById(R.id.ipm);
        this.mDk = (LinearLayout) findViewById(R.id.dcd);
        this.mDl = (LinearLayout) findViewById(R.id.gcv);
        AppMethodBeat.o(235083);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public void setMuteBtnOnClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(235084);
        this.mDh.setOnClickListener(onClickListener);
        AppMethodBeat.o(235084);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public void setExitFullScreenBtnOnClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(235085);
        this.mDj.setOnClickListener(onClickListener);
        AppMethodBeat.o(235085);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.AdVideoPlayerLoadingBar, com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public void setOnPlayButtonClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(235086);
        super.setOnPlayButtonClickListener(onClickListener);
        this.mDi.setOnClickListener(onClickListener);
        AppMethodBeat.o(235086);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public void setTitle(String str) {
        AppMethodBeat.i(235087);
        if (!Util.isNullOrNil(str)) {
            this.ayz.setText(str);
        }
        AppMethodBeat.o(235087);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public void setShowMuteBtn(boolean z) {
        AppMethodBeat.i(235088);
        this.mDh.setVisibility(z ? 0 : 8);
        AppMethodBeat.o(235088);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public void setMuteBtnState(boolean z) {
        AppMethodBeat.i(235089);
        if (z) {
            this.mDh.setImageResource(R.raw.app_brand_video_mute_btn_off);
            AppMethodBeat.o(235089);
            return;
        }
        this.mDh.setImageResource(R.raw.app_brand_video_mute_btn_on);
        AppMethodBeat.o(235089);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public void setShowControlProgress(boolean z) {
        AppMethodBeat.i(235090);
        this.mDs = z;
        bKY();
        AppMethodBeat.o(235090);
    }

    private void bKP() {
        AppMethodBeat.i(235091);
        if (this.mDo) {
            this.mDk.setVisibility(0);
            AppMethodBeat.o(235091);
            return;
        }
        this.mDk.setVisibility(8);
        AppMethodBeat.o(235091);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public void setPlayBtnInCenterPosition(boolean z) {
        AppMethodBeat.i(235092);
        this.mDu = z;
        bKQ();
        AppMethodBeat.o(235092);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public final void bIZ() {
        AppMethodBeat.i(235093);
        if (this.mDt && this.mDu) {
            this.mDi.setVisibility(8);
        }
        AppMethodBeat.o(235093);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public final void bJC() {
        AppMethodBeat.i(235094);
        if (this.mDt && this.mDu) {
            this.mDi.setVisibility(0);
        }
        AppMethodBeat.o(235094);
    }

    private void bKQ() {
        AppMethodBeat.i(235095);
        if (!this.mDt) {
            this.mCP.setVisibility(8);
            this.mDi.setVisibility(8);
            AppMethodBeat.o(235095);
        } else if (this.mDu) {
            this.mCP.setVisibility(8);
            this.mDi.setVisibility(0);
            AppMethodBeat.o(235095);
        } else {
            this.mCP.setVisibility(0);
            this.mDi.setVisibility(8);
            AppMethodBeat.o(235095);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.AdVideoPlayerLoadingBar, com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.VideoPlayerSeekBar, com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public void setIsPlay(boolean z) {
        AppMethodBeat.i(235096);
        this.dLB = z;
        if (this.dLB) {
            this.mCP.setImageResource(R.raw.app_brand_video_play_btn_pause);
            this.mDi.setImageResource(R.raw.app_brand_video_play_btn_pause);
            AppMethodBeat.o(235096);
            return;
        }
        this.mCP.setImageResource(R.raw.app_brand_video_play_btn_play);
        this.mDi.setImageResource(R.raw.app_brand_video_play_btn_play);
        AppMethodBeat.o(235096);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public void setFullScreenBtnOnClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(235097);
        this.mDc.setOnClickListener(onClickListener);
        AppMethodBeat.o(235097);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public void setDanmakuBtnOnClickListener(final e.g gVar) {
        AppMethodBeat.i(235098);
        this.mDd.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.AppBrandVideoViewControlBar.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(235076);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/appbrand/jsapi/video/progressbar/AppBrandVideoViewControlBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                AppBrandVideoViewControlBar.a(AppBrandVideoViewControlBar.this);
                if (gVar != null) {
                    gVar.hO(AppBrandVideoViewControlBar.this.mDp);
                }
                a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/video/progressbar/AppBrandVideoViewControlBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(235076);
            }
        });
        AppMethodBeat.o(235098);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public final boolean bJt() {
        return this.mDp;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public void setDanmakuBtnOpen(boolean z) {
        AppMethodBeat.i(235099);
        this.mDp = z;
        bKR();
        AppMethodBeat.o(235099);
    }

    private void bKR() {
        AppMethodBeat.i(235100);
        if (this.mDp) {
            this.mDd.setImageResource(R.raw.app_brand_video_danmu_on);
            AppMethodBeat.o(235100);
            return;
        }
        this.mDd.setImageResource(R.raw.app_brand_video_danmu_off);
        AppMethodBeat.o(235100);
    }

    private void bKS() {
        AppMethodBeat.i(235101);
        if (this.mDq) {
            this.mDc.setVisibility(0);
            if (this.mDo) {
                this.mDc.setImageResource(R.raw.app_brand_video_fullscreen_exit_btn);
                AppMethodBeat.o(235101);
                return;
            }
            this.mDc.setImageResource(R.raw.app_brand_video_fullscreen_btn);
            AppMethodBeat.o(235101);
            return;
        }
        this.mDc.setVisibility(8);
        AppMethodBeat.o(235101);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public void setShowDanmakuBtn(boolean z) {
        AppMethodBeat.i(235102);
        if (z) {
            this.mDd.setVisibility(0);
            AppMethodBeat.o(235102);
            return;
        }
        this.mDd.setVisibility(8);
        AppMethodBeat.o(235102);
    }

    public void setAutoHide(boolean z) {
        this.mDv = z;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public final void bJv() {
        AppMethodBeat.i(235103);
        setVisibility(0);
        if (!this.mDv) {
            AppMethodBeat.o(235103);
            return;
        }
        if (this.mDn == null) {
            this.mDn = new MTimerHandler(new MTimerHandler.CallBack() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.AppBrandVideoViewControlBar.AnonymousClass2 */

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public final boolean onTimerExpired() {
                    AppMethodBeat.i(235077);
                    AppBrandVideoViewControlBar.this.setVisibility(8);
                    AppBrandVideoViewControlBar.this.mDn.stopTimer();
                    AppMethodBeat.o(235077);
                    return false;
                }
            }, false);
        }
        this.mDn.stopTimer();
        this.mDn.startTimer(7000);
        AppMethodBeat.o(235103);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public final void bJB() {
        AppMethodBeat.i(235104);
        if (this.mDn != null) {
            this.mDn.stopTimer();
            this.mDn.startTimer(7000);
        }
        AppMethodBeat.o(235104);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public final void hide() {
        AppMethodBeat.i(235105);
        setVisibility(8);
        AppMethodBeat.o(235105);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public final boolean bJw() {
        AppMethodBeat.i(235106);
        if (getVisibility() == 0) {
            AppMethodBeat.o(235106);
            return true;
        }
        AppMethodBeat.o(235106);
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public final void bJu() {
        AppMethodBeat.i(235107);
        if (bJw()) {
            setVisibility(8);
            AppMethodBeat.o(235107);
            return;
        }
        bJv();
        AppMethodBeat.o(235107);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public final void KD() {
        AppMethodBeat.i(235108);
        this.mDo = true;
        bKT();
        AppMethodBeat.o(235108);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public final void bGL() {
        AppMethodBeat.i(235109);
        this.mDo = false;
        bKT();
        AppMethodBeat.o(235109);
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
        AppMethodBeat.i(235110);
        bKW();
        bKS();
        bKP();
        bKV();
        bKU();
        AppMethodBeat.o(235110);
    }

    private void bKU() {
        int dimensionPixelSize;
        AppMethodBeat.i(235111);
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
        if (this.mDl != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mDl.getLayoutParams();
            marginLayoutParams2.setMarginStart(dimensionPixelSize);
            this.mDl.setLayoutParams(marginLayoutParams2);
        }
        if (this.mDd != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.mDd.getLayoutParams();
            marginLayoutParams3.setMarginStart(dimensionPixelSize);
            this.mDd.setLayoutParams(marginLayoutParams3);
        }
        if (this.mDh != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) this.mDh.getLayoutParams();
            marginLayoutParams4.setMarginStart(dimensionPixelSize);
            this.mDh.setLayoutParams(marginLayoutParams4);
        }
        if (this.mDc != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) this.mDc.getLayoutParams();
            marginLayoutParams5.setMarginStart(dimensionPixelSize);
            this.mDc.setLayoutParams(marginLayoutParams5);
        }
        AppMethodBeat.o(235111);
    }

    private void bKV() {
        float dimensionPixelSize;
        AppMethodBeat.i(235112);
        if (this.mDo) {
            dimensionPixelSize = (float) getResources().getDimensionPixelSize(R.dimen.sm);
        } else {
            dimensionPixelSize = (float) getResources().getDimensionPixelSize(R.dimen.sf);
        }
        this.mCQ.setTextSize(0, dimensionPixelSize);
        this.mCR.setTextSize(0, dimensionPixelSize);
        AppMethodBeat.o(235112);
    }

    private void bKW() {
        int dimensionPixelSize;
        AppMethodBeat.i(235113);
        ViewGroup.LayoutParams layoutParams = this.mDe.getLayoutParams();
        if (this.mDo) {
            layoutParams.height = getResources().getDimensionPixelSize(R.dimen.sk);
        } else {
            layoutParams.height = getResources().getDimensionPixelSize(R.dimen.sb);
        }
        this.mDe.setLayoutParams(layoutParams);
        if (this.mDo) {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.sl);
        } else {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.sc);
        }
        this.mDe.setPadding(0, 0, dimensionPixelSize, 0);
        if (this.mDk != null) {
            this.mDk.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        }
        AppMethodBeat.o(235113);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public final void bJz() {
        AppMethodBeat.i(235114);
        if (this.mww == null) {
            this.mww = new MTimerHandler(new MTimerHandler.CallBack() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.AppBrandVideoViewControlBar.AnonymousClass3 */

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public final boolean onTimerExpired() {
                    AppMethodBeat.i(235078);
                    if (!AppBrandVideoViewControlBar.d(AppBrandVideoViewControlBar.this)) {
                        AppMethodBeat.o(235078);
                        return false;
                    }
                    AppMethodBeat.o(235078);
                    return true;
                }
            }, true);
        }
        bKX();
        this.mww.stopTimer();
        this.mww.startTimer(500);
        AppMethodBeat.o(235114);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public final void bJA() {
        AppMethodBeat.i(235115);
        if (this.mww != null) {
            this.mww.stopTimer();
        }
        AppMethodBeat.o(235115);
    }

    private boolean bKX() {
        int i2;
        AppMethodBeat.i(235116);
        if (this.mDm == null) {
            Log.i("MicroMsg.AppBrandVideoViewControlBar", "updateMiddleBar mStatePorter null");
            AppMethodBeat.o(235116);
            return false;
        }
        int bJh = this.mDm.bJh();
        int bJi = this.mDm.bJi();
        if (bJh < 0 || bJi < 0) {
            AppMethodBeat.o(235116);
            return false;
        }
        if (bJh > bJi) {
            bJh = bJi;
        }
        int barLen = getBarLen();
        if (barLen <= 0) {
            AppMethodBeat.o(235116);
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
        AppMethodBeat.o(235116);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.AdVideoPlayerLoadingBar, com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.VideoPlayerSeekBar, com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public final void seek(int i2) {
        AppMethodBeat.i(235117);
        super.seek(i2);
        em(this.mPosition, this.mCS);
        AppMethodBeat.o(235117);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.AdVideoPlayerLoadingBar, com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.VideoPlayerSeekBar
    public final void bKO() {
        AppMethodBeat.i(235118);
        if (this.mCS == 0) {
            AppMethodBeat.o(235118);
        } else if (this.mbo) {
            AppMethodBeat.o(235118);
        } else if (this.mCO == null) {
            AppMethodBeat.o(235118);
        } else {
            this.mCQ.setText(xt(this.mPosition / 60) + ":" + xt(this.mPosition % 60));
            if (getBarLen() == 0) {
                AppMethodBeat.o(235118);
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
            AppMethodBeat.o(235118);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public void setShowFullScreenBtn(boolean z) {
        AppMethodBeat.i(235119);
        this.mDq = z;
        bKS();
        bKP();
        AppMethodBeat.o(235119);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public void setShowPlayBtn(boolean z) {
        AppMethodBeat.i(235120);
        this.mDt = z;
        bKQ();
        AppMethodBeat.o(235120);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public void setShowProgress(boolean z) {
        AppMethodBeat.i(235121);
        this.mDr = z;
        bKY();
        AppMethodBeat.o(235121);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public final boolean bJD() {
        AppMethodBeat.i(235122);
        if (this.mDg == null) {
            AppMethodBeat.o(235122);
            return false;
        } else if (getVisibility() == 0 && this.mDg.getVisibility() == 0) {
            AppMethodBeat.o(235122);
            return true;
        } else {
            AppMethodBeat.o(235122);
            return false;
        }
    }

    private void bKY() {
        boolean z;
        int i2;
        int i3;
        int i4 = 0;
        AppMethodBeat.i(235123);
        if (this.mDs) {
            z = this.mDr;
        } else {
            z = false;
        }
        FrameLayout frameLayout = this.mDg;
        if (z) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        frameLayout.setVisibility(i2);
        TextView textView = this.mCQ;
        if (z) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        textView.setVisibility(i3);
        TextView textView2 = this.mCR;
        if (!z) {
            i4 = 8;
        }
        textView2.setVisibility(i4);
        AppMethodBeat.o(235123);
    }

    private void em(int i2, int i3) {
        AppMethodBeat.i(235124);
        if (this.mDw != null) {
            this.mDw.onProgressChanged(i2, i3);
        }
        AppMethodBeat.o(235124);
    }

    public void setVisibility(int i2) {
        AppMethodBeat.i(235125);
        super.setVisibility(i2);
        if (i2 == 0) {
            Iterator<e.f> it = this.mDx.iterator();
            while (it.hasNext()) {
                e.f next = it.next();
                if (next != null) {
                    next.onVisibilityChanged(true);
                }
            }
            AppMethodBeat.o(235125);
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
        AppMethodBeat.o(235125);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public void setOnUpdateProgressLenListener(e.AbstractC0717e eVar) {
        this.mDw = eVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.a
    public final void a(e.f fVar) {
        AppMethodBeat.i(235126);
        this.mDx.add(fVar);
        AppMethodBeat.o(235126);
    }

    static /* synthetic */ void a(AppBrandVideoViewControlBar appBrandVideoViewControlBar) {
        AppMethodBeat.i(235127);
        appBrandVideoViewControlBar.mDp = !appBrandVideoViewControlBar.mDp;
        appBrandVideoViewControlBar.bKR();
        AppMethodBeat.o(235127);
    }
}
