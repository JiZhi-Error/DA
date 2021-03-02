package com.tencent.mm.plugin.websearch.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar;
import com.tencent.mm.pluginsdk.ui.h;
import com.tencent.mm.sdk.platformtools.Log;

public class WebSearchVideoPlayerSeekBar extends AdVideoPlayerLoadingBar implements h {
    protected boolean dLB = false;
    private float deo;
    private int mDC = -1;
    private int mDD = -1;
    private int mDE = -1;

    static /* synthetic */ int f(WebSearchVideoPlayerSeekBar webSearchVideoPlayerSeekBar) {
        AppMethodBeat.i(110249);
        int curProgressBarLen = webSearchVideoPlayerSeekBar.getCurProgressBarLen();
        AppMethodBeat.o(110249);
        return curProgressBarLen;
    }

    static /* synthetic */ void fYL() {
    }

    static /* synthetic */ int g(WebSearchVideoPlayerSeekBar webSearchVideoPlayerSeekBar) {
        AppMethodBeat.i(110250);
        int curTimeByProgressBar = webSearchVideoPlayerSeekBar.getCurTimeByProgressBar();
        AppMethodBeat.o(110250);
        return curTimeByProgressBar;
    }

    public WebSearchVideoPlayerSeekBar(Context context) {
        super(context);
    }

    public WebSearchVideoPlayerSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WebSearchVideoPlayerSeekBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @Override // com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar
    public void init() {
        AppMethodBeat.i(110232);
        this.contentView = View.inflate(getContext(), getLayoutId(), this);
        this.mCM = (ImageView) this.contentView.findViewById(R.id.gcx);
        this.mCN = (ImageView) this.contentView.findViewById(R.id.gcw);
        this.mCO = (ImageView) this.contentView.findViewById(R.id.gd0);
        this.mCP = (ImageView) this.contentView.findViewById(R.id.gcc);
        this.mCQ = (TextView) this.contentView.findViewById(R.id.gce);
        this.mCR = (TextView) this.contentView.findViewById(R.id.gck);
        this.mCO.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.websearch.ui.WebSearchVideoPlayerSeekBar.AnonymousClass1 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(110229);
                if (motionEvent.getAction() == 0) {
                    Log.i("MicroMsg.WebSearch.WebSearchVideoPlayerSeekBar", "ontouch down");
                    WebSearchVideoPlayerSeekBar.this.mbo = false;
                    WebSearchVideoPlayerSeekBar.this.deo = motionEvent.getX();
                    WebSearchVideoPlayerSeekBar.this.mCV = (float) ((FrameLayout.LayoutParams) WebSearchVideoPlayerSeekBar.this.mCO.getLayoutParams()).leftMargin;
                    if (WebSearchVideoPlayerSeekBar.this.Dnp != null) {
                        WebSearchVideoPlayerSeekBar.this.Dnp.aJq();
                    }
                } else if (motionEvent.getAction() == 2) {
                    float x = motionEvent.getX();
                    Log.i("MicroMsg.WebSearch.WebSearchVideoPlayerSeekBar", "move dis %f ", Float.valueOf(x - WebSearchVideoPlayerSeekBar.this.deo));
                    float f2 = x - WebSearchVideoPlayerSeekBar.this.deo;
                    WebSearchVideoPlayerSeekBar.this.afE((int) (f2 + ((float) WebSearchVideoPlayerSeekBar.f(WebSearchVideoPlayerSeekBar.this))));
                    int g2 = WebSearchVideoPlayerSeekBar.g(WebSearchVideoPlayerSeekBar.this);
                    WebSearchVideoPlayerSeekBar.this.mCQ.setText(WebSearchVideoPlayerSeekBar.xt(g2 / 60) + ":" + WebSearchVideoPlayerSeekBar.xt(g2 % 60));
                    WebSearchVideoPlayerSeekBar.this.mbo = true;
                    WebSearchVideoPlayerSeekBar.fYL();
                } else {
                    Log.i("MicroMsg.WebSearch.WebSearchVideoPlayerSeekBar", "ontouch up");
                    int i2 = WebSearchVideoPlayerSeekBar.this.mPosition;
                    if (WebSearchVideoPlayerSeekBar.this.mbo) {
                        i2 = WebSearchVideoPlayerSeekBar.this.mPosition = WebSearchVideoPlayerSeekBar.g(WebSearchVideoPlayerSeekBar.this);
                    }
                    if (WebSearchVideoPlayerSeekBar.this.Dnp != null) {
                        Log.i("MicroMsg.WebSearch.WebSearchVideoPlayerSeekBar", "current time : ".concat(String.valueOf(i2)));
                        WebSearchVideoPlayerSeekBar.this.Dnp.rk(i2);
                    }
                    WebSearchVideoPlayerSeekBar.this.mbo = false;
                }
                AppMethodBeat.o(110229);
                return true;
            }
        });
        this.mCO.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            /* class com.tencent.mm.plugin.websearch.ui.WebSearchVideoPlayerSeekBar.AnonymousClass2 */

            public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                AppMethodBeat.i(110230);
                if (i4 - i2 != i8 - i6) {
                    WebSearchVideoPlayerSeekBar.this.bKO();
                }
                AppMethodBeat.o(110230);
            }
        });
        this.mCN.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            /* class com.tencent.mm.plugin.websearch.ui.WebSearchVideoPlayerSeekBar.AnonymousClass3 */

            public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                AppMethodBeat.i(110231);
                if (i4 - i2 != i8 - i6) {
                    WebSearchVideoPlayerSeekBar.this.bKO();
                }
                AppMethodBeat.o(110231);
            }
        });
        AppMethodBeat.o(110232);
    }

    private int getCurTimeByProgressBar() {
        AppMethodBeat.i(110233);
        int curProgressBarLen = (int) (((((double) getCurProgressBarLen()) * 1.0d) / ((double) getBarLen())) * ((double) this.mCS));
        AppMethodBeat.o(110233);
        return curProgressBarLen;
    }

    private int getCurProgressBarLen() {
        AppMethodBeat.i(110234);
        int width = this.mCM.getWidth();
        AppMethodBeat.o(110234);
        return width;
    }

    @Override // com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar
    public int getBarPointWidth() {
        AppMethodBeat.i(110235);
        if (this.mDC == -1) {
            this.mDC = this.mCO.getWidth();
        }
        int i2 = this.mDC;
        AppMethodBeat.o(110235);
        return i2;
    }

    private int getBarPointPaddingLeft() {
        AppMethodBeat.i(110236);
        if (this.mDD == -1) {
            this.mDD = this.mCO.getPaddingLeft();
        }
        int i2 = this.mDD;
        AppMethodBeat.o(110236);
        return i2;
    }

    private int getBarPointPaddingRight() {
        AppMethodBeat.i(110237);
        if (this.mDE == -1) {
            this.mDE = this.mCO.getPaddingRight();
        }
        int i2 = this.mDE;
        AppMethodBeat.o(110237);
        return i2;
    }

    /* access modifiers changed from: protected */
    public final int afD(int i2) {
        AppMethodBeat.i(110238);
        if (i2 <= 0) {
            AppMethodBeat.o(110238);
            return 0;
        } else if (i2 >= this.mCS) {
            int barLen = getBarLen();
            AppMethodBeat.o(110238);
            return barLen;
        } else {
            int barLen2 = (int) (((((double) i2) * 1.0d) / ((double) this.mCS)) * ((double) getBarLen()));
            AppMethodBeat.o(110238);
            return barLen2;
        }
    }

    @Override // com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar
    public int getBarLen() {
        AppMethodBeat.i(110239);
        int width = this.mCN.getWidth();
        AppMethodBeat.o(110239);
        return width;
    }

    @Override // com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar
    public int getLayoutId() {
        return R.layout.c5j;
    }

    public ImageView getPlayBtn() {
        return this.mCP;
    }

    public TextView getPlaytimeTv() {
        return this.mCQ;
    }

    @Override // com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar, com.tencent.mm.plugin.sight.decode.ui.a
    public final void seek(int i2) {
        AppMethodBeat.i(110240);
        Log.d("MicroMsg.WebSearch.WebSearchVideoPlayerSeekBar", "seek position : ".concat(String.valueOf(i2)));
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
        AppMethodBeat.o(110240);
    }

    @Override // com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar, com.tencent.mm.plugin.sight.decode.ui.a, com.tencent.mm.pluginsdk.ui.h
    public void setVideoTotalTime(int i2) {
        AppMethodBeat.i(110241);
        this.mCS = i2;
        this.mPosition = 0;
        this.mCR.setText(xt(this.mCS / 60) + ":" + xt(this.mCS % 60));
        bKO();
        AppMethodBeat.o(110241);
    }

    @Override // com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar
    public void bKO() {
        AppMethodBeat.i(110242);
        if (this.mCS == 0) {
            AppMethodBeat.o(110242);
        } else if (this.mbo) {
            AppMethodBeat.o(110242);
        } else if (this.mCO == null) {
            AppMethodBeat.o(110242);
        } else if (getBarLen() == 0) {
            AppMethodBeat.o(110242);
        } else {
            if (this.mPosition == this.mCS) {
                Log.i("MicroMsg.WebSearch.WebSearchVideoPlayerSeekBar", APMidasPayAPI.ENV_TEST);
            }
            this.mCQ.setText(xt(this.mPosition / 60) + ":" + xt(this.mPosition % 60));
            afE(afD(this.mPosition));
            AppMethodBeat.o(110242);
        }
    }

    /* access modifiers changed from: protected */
    public final void afE(int i2) {
        AppMethodBeat.i(110243);
        if (i2 > getBarLen()) {
            i2 = getBarLen();
        } else if (i2 < 0) {
            i2 = 0;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mCO.getLayoutParams();
        layoutParams.leftMargin = afF(i2);
        this.mCO.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.mCM.getLayoutParams();
        layoutParams2.width = i2;
        this.mCM.setLayoutParams(layoutParams2);
        this.mCO.requestLayout();
        this.mCM.requestLayout();
        AppMethodBeat.o(110243);
    }

    private int afF(int i2) {
        AppMethodBeat.i(110244);
        if (i2 > getBarLen()) {
            i2 = getBarLen();
        }
        int barPointWidth = (((FrameLayout.LayoutParams) this.mCN.getLayoutParams()).leftMargin + i2) - (getBarPointWidth() >>> 1);
        AppMethodBeat.o(110244);
        return barPointWidth;
    }

    public void setPlayBtnOnClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(110245);
        if (this.mCP != null) {
            this.mCP.setOnClickListener(onClickListener);
        }
        AppMethodBeat.o(110245);
    }

    @Override // com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar, com.tencent.mm.plugin.sight.decode.ui.a
    public void setIsPlay(boolean z) {
        AppMethodBeat.i(110246);
        this.dLB = z;
        super.setIsPlay(z);
        AppMethodBeat.o(110246);
    }

    @Override // com.tencent.mm.pluginsdk.ui.h
    public void xv(int i2) {
        AppMethodBeat.i(110247);
        seek(i2);
        AppMethodBeat.o(110247);
    }

    @Override // com.tencent.mm.pluginsdk.ui.h
    public final void hP(boolean z) {
        AppMethodBeat.i(110248);
        setIsPlay(z);
        AppMethodBeat.o(110248);
    }
}
