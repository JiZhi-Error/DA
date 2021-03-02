package com.tencent.mm.plugin.appbrand.jsapi.video.progressbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.video.e;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.Log;

public class VideoPlayerSeekBar extends AdVideoPlayerLoadingBar implements e.b {
    protected boolean dLB = false;
    private PInt mDA = new PInt();
    private int mDC = -1;
    private int mDD = -1;
    private int mDE = -1;

    public VideoPlayerSeekBar(Context context) {
        super(context);
        AppMethodBeat.i(235130);
        AppMethodBeat.o(235130);
    }

    public VideoPlayerSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(235131);
        AppMethodBeat.o(235131);
    }

    public VideoPlayerSeekBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(235132);
        AppMethodBeat.o(235132);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.AdVideoPlayerLoadingBar
    public void init() {
        AppMethodBeat.i(235133);
        this.contentView = View.inflate(getContext(), getLayoutId(), this);
        this.mCM = (ImageView) this.contentView.findViewById(R.id.gcx);
        this.mCN = (ImageView) this.contentView.findViewById(R.id.gcw);
        this.mCO = (ImageView) this.contentView.findViewById(R.id.gd0);
        this.mCP = (ImageView) this.contentView.findViewById(R.id.gcc);
        this.mCQ = (TextView) this.contentView.findViewById(R.id.gce);
        this.mCR = (TextView) this.contentView.findViewById(R.id.gck);
        this.mCO.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.VideoPlayerSeekBar.AnonymousClass1 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(235129);
                if (motionEvent.getAction() == 0) {
                    Log.i("MicroMsg.Video.VideoPlayerSeekBar", "ontouch down");
                    VideoPlayerSeekBar.this.mbo = false;
                    VideoPlayerSeekBar.this.mCV = motionEvent.getX();
                    if (VideoPlayerSeekBar.this.mCL != null) {
                        VideoPlayerSeekBar.this.mCL.aJq();
                    }
                } else if (motionEvent.getAction() == 2) {
                    float x = motionEvent.getX();
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) VideoPlayerSeekBar.this.mCO.getLayoutParams();
                    int a2 = VideoPlayerSeekBar.a(VideoPlayerSeekBar.this, ((int) (x - VideoPlayerSeekBar.this.mCV)) + layoutParams.leftMargin, VideoPlayerSeekBar.this.mDA);
                    layoutParams.leftMargin = a2;
                    VideoPlayerSeekBar.this.mCO.setLayoutParams(layoutParams);
                    int i2 = VideoPlayerSeekBar.this.mDA.value;
                    if (VideoPlayerSeekBar.this.mCS > 0) {
                        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) VideoPlayerSeekBar.this.mCM.getLayoutParams();
                        layoutParams2.width = a2;
                        VideoPlayerSeekBar.this.mCM.setLayoutParams(layoutParams2);
                    }
                    VideoPlayerSeekBar.this.mCQ.setText(VideoPlayerSeekBar.xt(i2 / 60) + ":" + VideoPlayerSeekBar.xt(i2 % 60));
                    VideoPlayerSeekBar.this.mbo = true;
                } else {
                    int i3 = VideoPlayerSeekBar.this.mPosition;
                    if (VideoPlayerSeekBar.this.mbo) {
                        VideoPlayerSeekBar videoPlayerSeekBar = VideoPlayerSeekBar.this;
                        i3 = VideoPlayerSeekBar.this.mDA.value;
                        videoPlayerSeekBar.mPosition = i3;
                    }
                    if (VideoPlayerSeekBar.this.mCL != null) {
                        Log.i("MicroMsg.Video.VideoPlayerSeekBar", "current time : ".concat(String.valueOf(i3)));
                        VideoPlayerSeekBar.this.mCL.rk(i3);
                    }
                    VideoPlayerSeekBar.this.mbo = false;
                }
                AppMethodBeat.o(235129);
                return true;
            }
        });
        AppMethodBeat.o(235133);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.AdVideoPlayerLoadingBar
    public int getBarPointWidth() {
        AppMethodBeat.i(235134);
        if (this.mDC == -1) {
            this.mDC = this.mCO.getWidth();
        }
        int i2 = this.mDC;
        AppMethodBeat.o(235134);
        return i2;
    }

    private int getBarPointPaddingLeft() {
        AppMethodBeat.i(235135);
        if (this.mDD == -1) {
            this.mDD = this.mCO.getPaddingLeft();
        }
        int i2 = this.mDD;
        AppMethodBeat.o(235135);
        return i2;
    }

    private int getBarPointPaddingRight() {
        AppMethodBeat.i(235136);
        if (this.mDE == -1) {
            this.mDE = this.mCO.getPaddingRight();
        }
        int i2 = this.mDE;
        AppMethodBeat.o(235136);
        return i2;
    }

    /* access modifiers changed from: protected */
    public final int en(int i2, int i3) {
        int i4;
        AppMethodBeat.i(235137);
        if (i2 <= 0) {
            this.mCN.getLayoutParams();
            i4 = 0;
        } else if (i2 >= this.mCS) {
            i4 = i3 - (((getBarPointWidth() - getBarPointPaddingLeft()) - getBarPointPaddingRight()) / 2);
        } else {
            i4 = (int) (((((double) i2) * 1.0d) / ((double) this.mCS)) * ((double) i3));
        }
        AppMethodBeat.o(235137);
        return i4;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.AdVideoPlayerLoadingBar
    public int getLayoutId() {
        return R.layout.g2;
    }

    public ImageView getPlayBtn() {
        return this.mCP;
    }

    public TextView getPlaytimeTv() {
        return this.mCQ;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.AdVideoPlayerLoadingBar
    public void seek(int i2) {
        AppMethodBeat.i(235138);
        if (i2 < 0) {
            i2 = 0;
        }
        if (i2 >= this.mCS) {
            i2 = this.mCS;
        }
        if (this.mPosition != i2) {
            this.mPosition = i2;
            bKO();
        }
        AppMethodBeat.o(235138);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.AdVideoPlayerLoadingBar, com.tencent.mm.plugin.appbrand.jsapi.video.e.b
    public void setVideoTotalTime(int i2) {
        AppMethodBeat.i(235139);
        this.mCS = i2;
        this.mPosition = 0;
        this.mCR.setText(xt(this.mCS / 60) + ":" + xt(this.mCS % 60));
        bKO();
        AppMethodBeat.o(235139);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.AdVideoPlayerLoadingBar
    public void bKO() {
        AppMethodBeat.i(235140);
        if (this.mCS == 0) {
            AppMethodBeat.o(235140);
        } else if (this.mbo) {
            AppMethodBeat.o(235140);
        } else if (this.mCO == null) {
            AppMethodBeat.o(235140);
        } else if (getBarLen() == 0) {
            AppMethodBeat.o(235140);
        } else {
            this.mCQ.setText(xt(this.mPosition / 60) + ":" + xt(this.mPosition % 60));
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mCO.getLayoutParams();
            int barLen = getBarLen();
            layoutParams.leftMargin = en(this.mPosition, barLen);
            this.mCO.setLayoutParams(layoutParams);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.mCM.getLayoutParams();
            layoutParams2.width = (int) (((((double) this.mPosition) * 1.0d) / ((double) this.mCS)) * ((double) barLen));
            this.mCM.setLayoutParams(layoutParams2);
            requestLayout();
            AppMethodBeat.o(235140);
        }
    }

    public void setPlayBtnOnClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(235141);
        if (this.mCP != null) {
            this.mCP.setOnClickListener(onClickListener);
        }
        AppMethodBeat.o(235141);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.AdVideoPlayerLoadingBar
    public void setIsPlay(boolean z) {
        AppMethodBeat.i(235142);
        this.dLB = z;
        super.setIsPlay(z);
        AppMethodBeat.o(235142);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.b
    public final void xv(int i2) {
        AppMethodBeat.i(235143);
        seek(i2);
        AppMethodBeat.o(235143);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.b
    public void hP(boolean z) {
        AppMethodBeat.i(235144);
        setIsPlay(z);
        AppMethodBeat.o(235144);
    }

    static /* synthetic */ int a(VideoPlayerSeekBar videoPlayerSeekBar, int i2, PInt pInt) {
        AppMethodBeat.i(235145);
        int barPointPaddingLeft = ((FrameLayout.LayoutParams) videoPlayerSeekBar.mCN.getLayoutParams()).leftMargin - videoPlayerSeekBar.getBarPointPaddingLeft();
        pInt.value = (int) (((((double) (i2 - barPointPaddingLeft)) * 1.0d) / ((double) videoPlayerSeekBar.getBarLen())) * ((double) videoPlayerSeekBar.mCS));
        if (pInt.value <= 0) {
            pInt.value = 0;
            if (i2 - barPointPaddingLeft > barPointPaddingLeft) {
                barPointPaddingLeft = i2 - barPointPaddingLeft;
            }
        } else if (pInt.value >= videoPlayerSeekBar.mCS) {
            pInt.value = videoPlayerSeekBar.mCS;
            barPointPaddingLeft = videoPlayerSeekBar.getBarLen() - (((videoPlayerSeekBar.getBarPointWidth() - videoPlayerSeekBar.getBarPointPaddingLeft()) - videoPlayerSeekBar.getBarPointPaddingRight()) / 2);
        } else {
            barPointPaddingLeft = i2 - barPointPaddingLeft;
        }
        AppMethodBeat.o(235145);
        return barPointPaddingLeft;
    }
}
