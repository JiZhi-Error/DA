package com.tencent.mm.plugin.facedetect.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;

public class FaceScanRect extends RelativeLayout {
    public View sWI;
    private ImageView sWJ;
    private ImageView sWK;
    private ImageView sWL;
    private ImageView sWM;
    private ImageView sWN;
    private ImageView sWO;
    private ImageView sWP;
    private ImageView sWQ;
    public ImageView[] sWR;
    private ScaleAnimation sWS;
    private ScaleAnimation sWT;
    private ScaleAnimation sWU;
    private ScaleAnimation sWV;
    public TranslateAnimation sWW;
    private b sWX;
    private ViewGroup sWY;
    public View sWZ;
    public a sXa;

    public interface b {
        void onRefresh();
    }

    public enum a {
        OPENED,
        CLOSED,
        INIT;

        public static a valueOf(String str) {
            AppMethodBeat.i(104187);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(104187);
            return aVar;
        }

        static {
            AppMethodBeat.i(104188);
            AppMethodBeat.o(104188);
        }
    }

    public FaceScanRect(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FaceScanRect(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(104189);
        this.sWI = null;
        this.sWJ = null;
        this.sWK = null;
        this.sWL = null;
        this.sWM = null;
        this.sWN = null;
        this.sWO = null;
        this.sWP = null;
        this.sWQ = null;
        this.sWR = null;
        this.sWS = null;
        this.sWT = null;
        this.sWU = null;
        this.sWV = null;
        this.sWW = null;
        this.sWX = null;
        this.sWY = null;
        this.sWZ = null;
        LayoutInflater.from(context).inflate(R.layout.a6g, (ViewGroup) this, true);
        this.sWI = findViewById(R.id.c_q);
        this.sWJ = (ImageView) findViewById(R.id.c_o);
        this.sWK = (ImageView) findViewById(R.id.c_p);
        this.sWL = (ImageView) findViewById(R.id.c_l);
        this.sWM = (ImageView) findViewById(R.id.c_k);
        this.sWN = (ImageView) findViewById(R.id.c_n);
        this.sWO = (ImageView) findViewById(R.id.c_m);
        this.sWP = (ImageView) findViewById(R.id.c_i);
        this.sWQ = (ImageView) findViewById(R.id.c_j);
        this.sWZ = findViewById(R.id.c95);
        this.sWY = (ViewGroup) findViewById(R.id.c8u);
        this.sWR = new ImageView[]{this.sWJ, this.sWK, this.sWL, this.sWM, this.sWN, this.sWO, this.sWP, this.sWQ};
        this.sXa = a.INIT;
        this.sWW = new TranslateAnimation(2, 0.0f, 2, 1.0f, 2, 0.0f, 2, 0.0f);
        this.sWW.setRepeatCount(-1);
        this.sWW.setRepeatMode(1);
        this.sWW.setDuration(1000);
        AppMethodBeat.o(104189);
    }

    public void setOnRefreshRectListener(b bVar) {
        this.sWX = bVar;
    }

    public ViewGroup getCenterHintHolder() {
        return this.sWY;
    }

    private void cTW() {
        AppMethodBeat.i(104190);
        this.sWZ.setVisibility(8);
        this.sWI.setBackground(null);
        this.sWZ.clearAnimation();
        AppMethodBeat.o(104190);
    }

    public final void b(Animation.AnimationListener animationListener) {
        AppMethodBeat.i(104191);
        if (this.sXa == a.CLOSED) {
            Log.w("MicroMsg.FaceScanRect", "hy: already closed");
            if (animationListener != null) {
                animationListener.onAnimationEnd(null);
            }
            AppMethodBeat.o(104191);
            return;
        }
        this.sXa = a.CLOSED;
        c(animationListener);
        this.sWJ.startAnimation(this.sWS);
        this.sWM.startAnimation(this.sWV);
        this.sWN.startAnimation(this.sWU);
        this.sWQ.startAnimation(this.sWT);
        cTW();
        for (ImageView imageView : this.sWR) {
            imageView.setBackgroundColor(getResources().getColor(R.color.op));
        }
        AppMethodBeat.o(104191);
    }

    private void c(Animation.AnimationListener animationListener) {
        AppMethodBeat.i(104192);
        int width = getWidth();
        int height = getHeight();
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.a42);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.a43);
        float f2 = ((float) (((width - (dimensionPixelSize * 2)) - (dimensionPixelSize2 * 2)) + dimensionPixelSize2)) / ((float) dimensionPixelSize2);
        float f3 = ((float) (((height - (dimensionPixelSize * 2)) - (dimensionPixelSize2 * 2)) + dimensionPixelSize2)) / ((float) dimensionPixelSize2);
        Log.i("MicroMsg.FaceScanRect", "hy: horizontalScale : %f, verticalScale : %f", Float.valueOf(f2), Float.valueOf(f3));
        this.sWS = new ScaleAnimation(1.0f, f2, 1.0f, 1.0f, 1, 0.0f, 1, 0.0f);
        this.sWS.setFillAfter(true);
        this.sWS.setDuration(1500);
        this.sWS.setInterpolator(getContext(), 17563654);
        this.sWS.setAnimationListener(animationListener);
        this.sWT = new ScaleAnimation(1.0f, f2, 1.0f, 1.0f, 1, 1.0f, 1, 0.0f);
        this.sWT.setFillAfter(true);
        this.sWT.setDuration(1500);
        this.sWT.setInterpolator(getContext(), 17563654);
        this.sWU = new ScaleAnimation(1.0f, 1.0f, 1.0f, f3, 1, 0.0f, 1, 0.0f);
        this.sWU.setFillAfter(true);
        this.sWU.setDuration(1500);
        this.sWU.setInterpolator(getContext(), 17563654);
        this.sWV = new ScaleAnimation(1.0f, 1.0f, 1.0f, f3, 1, 0.0f, 1, 1.0f);
        this.sWV.setFillAfter(true);
        this.sWV.setDuration(1500);
        this.sWV.setInterpolator(getContext(), 17563654);
        AppMethodBeat.o(104192);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(104193);
        super.onMeasure(i2, i3);
        if (this.sWX != null) {
            this.sWX.onRefresh();
        }
        AppMethodBeat.o(104193);
    }
}
