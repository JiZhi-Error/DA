package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;

public class SnsAdNativeLandingPagesVideoPlayerLoadingBar extends RelativeLayout implements a {
    private b Dnp = null;
    private View contentView = null;
    private boolean dLB = false;
    private ImageView mCM;
    private ImageView mCN = null;
    private ImageView mCO = null;
    private ImageView mCP = null;
    private TextView mCQ;
    private TextView mCR;
    private int mCS = 0;
    private int mCT = 0;
    private float mCV = 0.0f;
    private int mCW = -1;
    private int mCX = -1;
    private int mCY = -1;
    private int mCZ = -1;
    private int mPosition = 0;
    private boolean mbo = false;

    static /* synthetic */ int d(SnsAdNativeLandingPagesVideoPlayerLoadingBar snsAdNativeLandingPagesVideoPlayerLoadingBar) {
        AppMethodBeat.i(116153);
        int currentTimeByBarPoint = snsAdNativeLandingPagesVideoPlayerLoadingBar.getCurrentTimeByBarPoint();
        AppMethodBeat.o(116153);
        return currentTimeByBarPoint;
    }

    static /* synthetic */ int g(SnsAdNativeLandingPagesVideoPlayerLoadingBar snsAdNativeLandingPagesVideoPlayerLoadingBar) {
        AppMethodBeat.i(116154);
        int barLen = snsAdNativeLandingPagesVideoPlayerLoadingBar.getBarLen();
        AppMethodBeat.o(116154);
        return barLen;
    }

    public SnsAdNativeLandingPagesVideoPlayerLoadingBar(Context context) {
        super(context);
        AppMethodBeat.i(116139);
        init();
        AppMethodBeat.o(116139);
    }

    public SnsAdNativeLandingPagesVideoPlayerLoadingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(116140);
        init();
        AppMethodBeat.o(116140);
    }

    public SnsAdNativeLandingPagesVideoPlayerLoadingBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(116141);
        init();
        AppMethodBeat.o(116141);
    }

    @Override // com.tencent.mm.plugin.sight.decode.ui.a
    public void setIplaySeekCallback(b bVar) {
        this.Dnp = bVar;
    }

    private void init() {
        AppMethodBeat.i(116142);
        this.contentView = View.inflate(getContext(), R.layout.bux, this);
        this.mCM = (ImageView) this.contentView.findViewById(R.id.gcx);
        this.mCN = (ImageView) this.contentView.findViewById(R.id.gcw);
        this.mCO = (ImageView) this.contentView.findViewById(R.id.gd0);
        this.mCP = (ImageView) this.contentView.findViewById(R.id.gcc);
        this.mCQ = (TextView) this.contentView.findViewById(R.id.gce);
        this.mCR = (TextView) this.contentView.findViewById(R.id.gck);
        this.mCO.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.sight.decode.ui.SnsAdNativeLandingPagesVideoPlayerLoadingBar.AnonymousClass1 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(116137);
                if (motionEvent.getAction() == 0) {
                    Log.i("MicroMsg.SnsAdNativeLandingPagesVideoPlayerLoadingBar", "ontouch down");
                    SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.mbo = false;
                    SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.mCV = motionEvent.getX();
                    if (SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.Dnp != null) {
                        SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.Dnp.aJq();
                    }
                } else if (motionEvent.getAction() == 2) {
                    float x = motionEvent.getX();
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.mCO.getLayoutParams();
                    layoutParams.leftMargin = SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this, ((int) (x - SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.mCV)) + layoutParams.leftMargin);
                    SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.mCO.setLayoutParams(layoutParams);
                    int d2 = SnsAdNativeLandingPagesVideoPlayerLoadingBar.d(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this);
                    if (SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.mCS > 0) {
                        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.mCM.getLayoutParams();
                        layoutParams2.width = (int) (((((double) d2) * 1.0d) / ((double) SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.mCS)) * ((double) SnsAdNativeLandingPagesVideoPlayerLoadingBar.g(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this)));
                        SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.mCM.setLayoutParams(layoutParams2);
                    }
                    SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.mCQ.setText(SnsAdNativeLandingPagesVideoPlayerLoadingBar.xt(d2 / 60) + ":" + SnsAdNativeLandingPagesVideoPlayerLoadingBar.xt(d2 % 60));
                    SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.mbo = true;
                } else if (SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.mbo) {
                    int d3 = SnsAdNativeLandingPagesVideoPlayerLoadingBar.d(SnsAdNativeLandingPagesVideoPlayerLoadingBar.this);
                    if (SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.Dnp != null) {
                        Log.i("MicroMsg.SnsAdNativeLandingPagesVideoPlayerLoadingBar", "current time : ".concat(String.valueOf(d3)));
                        SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.Dnp.rk(d3);
                    }
                    SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.mbo = false;
                }
                AppMethodBeat.o(116137);
                return true;
            }
        });
        AppMethodBeat.o(116142);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(116143);
        super.onLayout(z, i2, i3, i4, i5);
        if (!(i2 == this.mCW && i3 == this.mCX && i4 == this.mCY && i5 == this.mCZ)) {
            bKO();
        }
        this.mCW = i2;
        this.mCX = i3;
        this.mCY = i4;
        this.mCZ = i5;
        AppMethodBeat.o(116143);
    }

    @Override // com.tencent.mm.plugin.sight.decode.ui.a
    public void setOnPlayButtonClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(116144);
        this.mCP.setOnClickListener(onClickListener);
        AppMethodBeat.o(116144);
    }

    @Override // com.tencent.mm.plugin.sight.decode.ui.a
    public void setIsPlay(boolean z) {
        AppMethodBeat.i(116145);
        this.dLB = z;
        if (z) {
            this.mCP.setImageResource(R.raw.media_player_pause_btn);
            AppMethodBeat.o(116145);
            return;
        }
        this.mCP.setImageResource(R.raw.media_player_play_btn);
        AppMethodBeat.o(116145);
    }

    public boolean getIsPlay() {
        return this.dLB;
    }

    private int getCurrentTimeByBarPoint() {
        AppMethodBeat.i(116146);
        int paddingLeft = (int) (((((double) (((FrameLayout.LayoutParams) this.mCO.getLayoutParams()).leftMargin - (((FrameLayout.LayoutParams) this.mCN.getLayoutParams()).leftMargin - this.mCO.getPaddingLeft()))) * 1.0d) / ((double) getBarLen())) * ((double) this.mCS));
        if (paddingLeft < 0) {
            paddingLeft = 0;
        }
        AppMethodBeat.o(116146);
        return paddingLeft;
    }

    @Override // com.tencent.mm.plugin.sight.decode.ui.a
    public final void seek(int i2) {
        AppMethodBeat.i(116147);
        this.mPosition = i2;
        bKO();
        AppMethodBeat.o(116147);
    }

    @Override // com.tencent.mm.plugin.sight.decode.ui.a
    public int getVideoTotalTime() {
        return this.mCS;
    }

    @Override // com.tencent.mm.plugin.sight.decode.ui.a
    public void setVideoTotalTime(final int i2) {
        AppMethodBeat.i(116148);
        if (!this.mCO.isShown() || this.mCO.getWidth() != 0) {
            this.mCS = i2;
            this.mPosition = 0;
            this.mCR.setText(xt(this.mCS / 60) + ":" + xt(this.mCS % 60));
            bKO();
            AppMethodBeat.o(116148);
            return;
        }
        post(new Runnable() {
            /* class com.tencent.mm.plugin.sight.decode.ui.SnsAdNativeLandingPagesVideoPlayerLoadingBar.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(116138);
                SnsAdNativeLandingPagesVideoPlayerLoadingBar.this.setVideoTotalTime(i2);
                AppMethodBeat.o(116138);
            }
        });
        AppMethodBeat.o(116148);
    }

    private int getBarLen() {
        AppMethodBeat.i(116149);
        this.mCT = this.mCN.getWidth();
        int i2 = this.mCT;
        AppMethodBeat.o(116149);
        return i2;
    }

    @Override // com.tencent.mm.plugin.sight.decode.ui.a
    public final void eVJ() {
        this.mCT = 0;
    }

    private void bKO() {
        AppMethodBeat.i(116150);
        if (this.mCS == 0) {
            AppMethodBeat.o(116150);
        } else if (this.mbo) {
            AppMethodBeat.o(116150);
        } else if (this.mCO == null) {
            AppMethodBeat.o(116150);
        } else if (getBarLen() == 0) {
            AppMethodBeat.o(116150);
        } else {
            int width = ((this.mCO.getWidth() - this.mCO.getPaddingLeft()) - this.mCO.getPaddingRight()) / 2;
            this.mCQ.setText(xt(this.mPosition / 60) + ":" + xt(this.mPosition % 60));
            int paddingLeft = ((FrameLayout.LayoutParams) this.mCN.getLayoutParams()).leftMargin - this.mCO.getPaddingLeft();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mCO.getLayoutParams();
            layoutParams.leftMargin = (paddingLeft + ((int) (((((double) this.mPosition) * 1.0d) / ((double) this.mCS)) * ((double) getBarLen())))) - width;
            this.mCO.setLayoutParams(layoutParams);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.mCM.getLayoutParams();
            layoutParams2.width = (int) (((((double) this.mPosition) * 1.0d) / ((double) this.mCS)) * ((double) getBarLen()));
            this.mCM.setLayoutParams(layoutParams2);
            AppMethodBeat.o(116150);
        }
    }

    public static String xt(int i2) {
        AppMethodBeat.i(116151);
        if (i2 < 10) {
            String concat = AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(i2));
            AppMethodBeat.o(116151);
            return concat;
        }
        String valueOf = String.valueOf(i2);
        AppMethodBeat.o(116151);
        return valueOf;
    }

    static /* synthetic */ int a(SnsAdNativeLandingPagesVideoPlayerLoadingBar snsAdNativeLandingPagesVideoPlayerLoadingBar, int i2) {
        AppMethodBeat.i(116152);
        int width = ((snsAdNativeLandingPagesVideoPlayerLoadingBar.mCO.getWidth() - snsAdNativeLandingPagesVideoPlayerLoadingBar.mCO.getPaddingLeft()) - snsAdNativeLandingPagesVideoPlayerLoadingBar.mCO.getPaddingRight()) / 2;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) snsAdNativeLandingPagesVideoPlayerLoadingBar.mCN.getLayoutParams();
        if (i2 < (layoutParams.leftMargin - snsAdNativeLandingPagesVideoPlayerLoadingBar.mCO.getPaddingLeft()) - width) {
            int paddingLeft = (layoutParams.leftMargin - snsAdNativeLandingPagesVideoPlayerLoadingBar.mCO.getPaddingLeft()) - width;
            AppMethodBeat.o(116152);
            return paddingLeft;
        } else if (i2 > snsAdNativeLandingPagesVideoPlayerLoadingBar.getBarLen()) {
            int barLen = snsAdNativeLandingPagesVideoPlayerLoadingBar.getBarLen() - width;
            AppMethodBeat.o(116152);
            return barLen;
        } else {
            int i3 = i2 - width;
            AppMethodBeat.o(116152);
            return i3;
        }
    }
}
