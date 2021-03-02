package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Context;
import android.os.Looper;
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

public class AdVideoPlayerLoadingBar extends RelativeLayout implements a {
    public b Dnp = null;
    protected View contentView = null;
    public ImageView mCM;
    public ImageView mCN = null;
    public ImageView mCO = null;
    protected ImageView mCP = null;
    public TextView mCQ;
    protected TextView mCR;
    public int mCS = 0;
    private int mCT = 0;
    private int mCU = 0;
    public float mCV = 0.0f;
    private int mCW = -1;
    private int mCX = -1;
    private int mCY = -1;
    private int mCZ = -1;
    public int mPosition = 0;
    public boolean mbo = false;

    public AdVideoPlayerLoadingBar(Context context) {
        super(context);
        AppMethodBeat.i(133963);
        init();
        AppMethodBeat.o(133963);
    }

    public AdVideoPlayerLoadingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(133964);
        init();
        AppMethodBeat.o(133964);
    }

    public AdVideoPlayerLoadingBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(133965);
        init();
        AppMethodBeat.o(133965);
    }

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.c5i;
    }

    @Override // com.tencent.mm.plugin.sight.decode.ui.a
    public void setIplaySeekCallback(b bVar) {
        this.Dnp = bVar;
    }

    /* access modifiers changed from: protected */
    public void init() {
        AppMethodBeat.i(133966);
        this.contentView = View.inflate(getContext(), getLayoutId(), this);
        this.mCM = (ImageView) this.contentView.findViewById(R.id.gcx);
        this.mCN = (ImageView) this.contentView.findViewById(R.id.gcw);
        this.mCO = (ImageView) this.contentView.findViewById(R.id.gd0);
        this.mCP = (ImageView) this.contentView.findViewById(R.id.gcc);
        this.mCQ = (TextView) this.contentView.findViewById(R.id.gce);
        this.mCR = (TextView) this.contentView.findViewById(R.id.gck);
        this.mCO.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar.AnonymousClass1 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(133960);
                if (motionEvent.getAction() == 0) {
                    Log.i("MicroMsg.VideoPlayerLoadingBar", "ontouch down");
                    AdVideoPlayerLoadingBar.this.mbo = false;
                    AdVideoPlayerLoadingBar.this.mCV = motionEvent.getX();
                    if (AdVideoPlayerLoadingBar.this.Dnp != null) {
                        AdVideoPlayerLoadingBar.this.Dnp.aJq();
                    }
                } else if (motionEvent.getAction() == 2) {
                    float x = motionEvent.getX();
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) AdVideoPlayerLoadingBar.this.mCO.getLayoutParams();
                    layoutParams.leftMargin = AdVideoPlayerLoadingBar.a(AdVideoPlayerLoadingBar.this, ((int) (x - AdVideoPlayerLoadingBar.this.mCV)) + layoutParams.leftMargin);
                    AdVideoPlayerLoadingBar.this.mCO.setLayoutParams(layoutParams);
                    int currentTimeByBarPoint = AdVideoPlayerLoadingBar.this.getCurrentTimeByBarPoint();
                    if (AdVideoPlayerLoadingBar.this.mCS > 0) {
                        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) AdVideoPlayerLoadingBar.this.mCM.getLayoutParams();
                        layoutParams2.width = (int) (((((double) currentTimeByBarPoint) * 1.0d) / ((double) AdVideoPlayerLoadingBar.this.mCS)) * ((double) AdVideoPlayerLoadingBar.this.getBarLen()));
                        AdVideoPlayerLoadingBar.this.mCM.setLayoutParams(layoutParams2);
                    }
                    AdVideoPlayerLoadingBar.this.mCQ.setText(AdVideoPlayerLoadingBar.xt(currentTimeByBarPoint / 60) + ":" + AdVideoPlayerLoadingBar.xt(currentTimeByBarPoint % 60));
                    AdVideoPlayerLoadingBar.this.mbo = true;
                } else if (AdVideoPlayerLoadingBar.this.mbo) {
                    int currentTimeByBarPoint2 = AdVideoPlayerLoadingBar.this.getCurrentTimeByBarPoint();
                    if (AdVideoPlayerLoadingBar.this.Dnp != null) {
                        Log.i("MicroMsg.VideoPlayerLoadingBar", "current time : ".concat(String.valueOf(currentTimeByBarPoint2)));
                        AdVideoPlayerLoadingBar.this.Dnp.rk(currentTimeByBarPoint2);
                    }
                    AdVideoPlayerLoadingBar.this.mbo = false;
                }
                AppMethodBeat.o(133960);
                return true;
            }
        });
        this.mCO.post(new Runnable() {
            /* class com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(133961);
                int paddingLeft = (((FrameLayout.LayoutParams) AdVideoPlayerLoadingBar.this.mCN.getLayoutParams()).leftMargin - AdVideoPlayerLoadingBar.this.mCO.getPaddingLeft()) - (((AdVideoPlayerLoadingBar.this.getBarPointWidth() - AdVideoPlayerLoadingBar.this.mCO.getPaddingLeft()) - AdVideoPlayerLoadingBar.this.mCO.getPaddingRight()) / 2);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) AdVideoPlayerLoadingBar.this.mCO.getLayoutParams();
                layoutParams.leftMargin = paddingLeft;
                AdVideoPlayerLoadingBar.this.mCO.setLayoutParams(layoutParams);
                AppMethodBeat.o(133961);
            }
        });
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mCM.getLayoutParams();
        layoutParams.width = 0;
        this.mCM.setLayoutParams(layoutParams);
        AppMethodBeat.o(133966);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(133967);
        super.onLayout(z, i2, i3, i4, i5);
        this.mCT = 0;
        if (!(i2 == this.mCW && i3 == this.mCX && i4 == this.mCY && i5 == this.mCZ)) {
            bKO();
        }
        this.mCW = i2;
        this.mCX = i3;
        this.mCY = i4;
        this.mCZ = i5;
        AppMethodBeat.o(133967);
    }

    @Override // com.tencent.mm.plugin.sight.decode.ui.a
    public void setOnPlayButtonClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(133968);
        this.mCP.setOnClickListener(onClickListener);
        AppMethodBeat.o(133968);
    }

    @Override // com.tencent.mm.plugin.sight.decode.ui.a
    public void setIsPlay(boolean z) {
        AppMethodBeat.i(133969);
        if (z) {
            this.mCP.setImageResource(R.raw.media_player_pause_btn);
            AppMethodBeat.o(133969);
            return;
        }
        this.mCP.setImageResource(R.raw.media_player_play_btn);
        AppMethodBeat.o(133969);
    }

    /* access modifiers changed from: protected */
    public int getCurrentTimeByBarPoint() {
        AppMethodBeat.i(133970);
        int max = Math.max(0, (int) (((((double) ((((FrameLayout.LayoutParams) this.mCO.getLayoutParams()).leftMargin - (((FrameLayout.LayoutParams) this.mCN.getLayoutParams()).leftMargin - this.mCO.getPaddingLeft())) + (((getBarPointWidth() - this.mCO.getPaddingLeft()) - this.mCO.getPaddingRight()) / 2))) * 1.0d) / ((double) getBarLen())) * ((double) this.mCS)));
        AppMethodBeat.o(133970);
        return max;
    }

    @Override // com.tencent.mm.plugin.sight.decode.ui.a
    public void seek(int i2) {
        AppMethodBeat.i(133971);
        this.mPosition = i2;
        bKO();
        AppMethodBeat.o(133971);
    }

    public int getmPosition() {
        return this.mPosition;
    }

    @Override // com.tencent.mm.plugin.sight.decode.ui.a
    public int getVideoTotalTime() {
        return this.mCS;
    }

    @Override // com.tencent.mm.plugin.sight.decode.ui.a
    public void setVideoTotalTime(int i2) {
        AppMethodBeat.i(133972);
        this.mCS = i2;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            post(new Runnable() {
                /* class com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(133962);
                    AdVideoPlayerLoadingBar.this.bKN();
                    AppMethodBeat.o(133962);
                }
            });
            AppMethodBeat.o(133972);
            return;
        }
        bKN();
        AppMethodBeat.o(133972);
    }

    public final void bKN() {
        AppMethodBeat.i(133973);
        this.mCR.setText(xt(this.mCS / 60) + ":" + xt(this.mCS % 60));
        bKO();
        AppMethodBeat.o(133973);
    }

    public int getBarLen() {
        AppMethodBeat.i(133974);
        if (this.mCT <= 0) {
            this.mCT = this.mCN.getWidth();
        }
        int i2 = this.mCT;
        AppMethodBeat.o(133974);
        return i2;
    }

    @Override // com.tencent.mm.plugin.sight.decode.ui.a
    public final void eVJ() {
        this.mCT = 0;
    }

    /* access modifiers changed from: protected */
    public int getBarPointWidth() {
        AppMethodBeat.i(133975);
        if (this.mCU <= 0) {
            this.mCU = this.mCO.getWidth();
        }
        int i2 = this.mCU;
        AppMethodBeat.o(133975);
        return i2;
    }

    public void bKO() {
        AppMethodBeat.i(133976);
        if (this.mCS == 0) {
            AppMethodBeat.o(133976);
        } else if (this.mbo) {
            AppMethodBeat.o(133976);
        } else if (this.mCO == null) {
            AppMethodBeat.o(133976);
        } else if (getBarLen() == 0) {
            AppMethodBeat.o(133976);
        } else {
            int barPointWidth = ((getBarPointWidth() - this.mCO.getPaddingLeft()) - this.mCO.getPaddingRight()) / 2;
            this.mCQ.setText(xt(this.mPosition / 60) + ":" + xt(this.mPosition % 60));
            int paddingLeft = ((FrameLayout.LayoutParams) this.mCN.getLayoutParams()).leftMargin - this.mCO.getPaddingLeft();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mCO.getLayoutParams();
            layoutParams.leftMargin = (paddingLeft + ((int) (((((double) this.mPosition) * 1.0d) / ((double) this.mCS)) * ((double) getBarLen())))) - barPointWidth;
            this.mCO.setLayoutParams(layoutParams);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.mCM.getLayoutParams();
            layoutParams2.width = (int) (((((double) this.mPosition) * 1.0d) / ((double) this.mCS)) * ((double) getBarLen()));
            this.mCM.setLayoutParams(layoutParams2);
            AppMethodBeat.o(133976);
        }
    }

    public static String xt(int i2) {
        AppMethodBeat.i(133977);
        if (i2 < 10) {
            String concat = AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(i2));
            AppMethodBeat.o(133977);
            return concat;
        }
        String valueOf = String.valueOf(i2);
        AppMethodBeat.o(133977);
        return valueOf;
    }

    static /* synthetic */ int a(AdVideoPlayerLoadingBar adVideoPlayerLoadingBar, int i2) {
        AppMethodBeat.i(133978);
        int barPointWidth = ((adVideoPlayerLoadingBar.getBarPointWidth() - adVideoPlayerLoadingBar.mCO.getPaddingLeft()) - adVideoPlayerLoadingBar.mCO.getPaddingRight()) / 2;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) adVideoPlayerLoadingBar.mCN.getLayoutParams();
        if (i2 < (layoutParams.leftMargin - adVideoPlayerLoadingBar.mCO.getPaddingLeft()) - barPointWidth) {
            int paddingLeft = (layoutParams.leftMargin - adVideoPlayerLoadingBar.mCO.getPaddingLeft()) - barPointWidth;
            AppMethodBeat.o(133978);
            return paddingLeft;
        } else if (i2 > ((adVideoPlayerLoadingBar.getBarLen() + layoutParams.leftMargin) - barPointWidth) - adVideoPlayerLoadingBar.mCO.getPaddingLeft()) {
            int barLen = ((layoutParams.leftMargin + adVideoPlayerLoadingBar.getBarLen()) - barPointWidth) - adVideoPlayerLoadingBar.mCO.getPaddingLeft();
            AppMethodBeat.o(133978);
            return barLen;
        } else {
            AppMethodBeat.o(133978);
            return i2;
        }
    }
}