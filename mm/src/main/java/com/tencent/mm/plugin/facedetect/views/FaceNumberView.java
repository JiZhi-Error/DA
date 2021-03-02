package com.tencent.mm.plugin.facedetect.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.facedetect.views.FaceNumberItemView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.Timer;

public class FaceNumberView extends LinearLayout {
    private int sWA;
    private Animation sWB;
    private a sWC;
    private String sWw;
    private int sWx;
    private ViewGroup sWy;
    public FaceNumberItemView[] sWz;

    public enum a {
        Normal,
        Shine;

        public static a valueOf(String str) {
            AppMethodBeat.i(104173);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(104173);
            return aVar;
        }

        static {
            AppMethodBeat.i(104174);
            AppMethodBeat.o(104174);
        }
    }

    public void setNumberLengthAndInflate(int i2) {
        int i3;
        int dimensionPixelSize;
        AppMethodBeat.i(104175);
        if (i2 > 12) {
            Log.e("MicroMsg.Facing.MMPwdInputView", "hy: number length exceed max length: %d", Integer.valueOf(i2));
            AppMethodBeat.o(104175);
        } else if (i2 <= 0) {
            Log.e("MicroMsg.Facing.MMPwdInputView", "hy: number length exceed min length: %d", Integer.valueOf(i2));
            AppMethodBeat.o(104175);
        } else if (i2 == this.sWA) {
            Log.i("MicroMsg.Facing.MMPwdInputView", "hy: already correct length. quit");
            arF(null);
            AppMethodBeat.o(104175);
        } else {
            this.sWy.removeAllViews();
            this.sWA = i2;
            this.sWz = new FaceNumberItemView[this.sWA];
            for (int i4 = 0; i4 < i2; i4++) {
                FaceNumberItemView faceNumberItemView = (FaceNumberItemView) inflate(getContext(), R.layout.a6_, null);
                faceNumberItemView.setImageResource(R.drawable.c6x);
                if (i4 == 0) {
                    i3 = 3;
                    dimensionPixelSize = (getResources().getDimensionPixelSize(R.dimen.a41) + com.tencent.mm.cb.a.fromDPToPix(getContext(), 48)) / 2;
                } else if (i4 == i2 - 1) {
                    i3 = 5;
                    dimensionPixelSize = (getResources().getDimensionPixelSize(R.dimen.a41) + com.tencent.mm.cb.a.fromDPToPix(getContext(), 48)) / 2;
                } else {
                    i3 = 17;
                    dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.a41);
                }
                faceNumberItemView.setGravity(i3);
                this.sWz[i4] = faceNumberItemView;
                this.sWy.addView(faceNumberItemView, new ViewGroup.LayoutParams(dimensionPixelSize, getResources().getDimensionPixelSize(R.dimen.a3z)));
            }
            AppMethodBeat.o(104175);
        }
    }

    public FaceNumberView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public FaceNumberView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        AppMethodBeat.i(104176);
        this.sWw = null;
        this.sWz = null;
        this.sWA = 0;
        this.sWB = null;
        this.sWC = a.Shine;
        this.sWy = (ViewGroup) inflate(getContext(), R.layout.a69, null);
        addView(this.sWy);
        this.sWB = AnimationUtils.loadAnimation(getContext(), R.anim.dd);
        AppMethodBeat.o(104176);
    }

    private void cTU() {
        String str;
        AppMethodBeat.i(104177);
        if (this.sWz != null && this.sWz.length > 0) {
            if (!Util.isNullOrNil(this.sWw)) {
                for (int i2 = 0; i2 < this.sWz.length; i2++) {
                    if (this.sWx > i2) {
                        String sb = new StringBuilder().append(this.sWw.charAt(i2)).toString();
                        if (this.sWx == i2 + 1) {
                            FaceNumberItemView faceNumberItemView = this.sWz[i2];
                            if (faceNumberItemView.sWl != null) {
                                faceNumberItemView.cTT();
                            }
                            faceNumberItemView.sWl = new Timer("FaceNumberItemView_karaoke", true);
                            faceNumberItemView.sWl.scheduleAtFixedRate(new FaceNumberItemView.a(faceNumberItemView, faceNumberItemView.sWt, (byte) 0), 0, FaceNumberItemView.sWm);
                            str = sb;
                        } else {
                            this.sWz[i2].cTT();
                            FaceNumberItemView faceNumberItemView2 = this.sWz[i2];
                            faceNumberItemView2.sWs = 30;
                            faceNumberItemView2.invalidate();
                            str = sb;
                        }
                    } else {
                        str = "";
                    }
                    a(this.sWz[i2], str);
                }
                AppMethodBeat.o(104177);
                return;
            }
            for (int i3 = 0; i3 < this.sWz.length; i3++) {
                a(this.sWz[i3], "point");
            }
        }
        AppMethodBeat.o(104177);
    }

    private static void a(FaceNumberItemView faceNumberItemView, String str) {
        AppMethodBeat.i(104178);
        if (faceNumberItemView == null) {
            AppMethodBeat.o(104178);
        } else if (str.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            faceNumberItemView.setImageResource(R.drawable.c6n);
            AppMethodBeat.o(104178);
        } else if (str.equals("1")) {
            faceNumberItemView.setImageResource(R.drawable.c6o);
            AppMethodBeat.o(104178);
        } else if (str.equals("2")) {
            faceNumberItemView.setImageResource(R.drawable.c6p);
            AppMethodBeat.o(104178);
        } else if (str.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
            faceNumberItemView.setImageResource(R.drawable.c6q);
            AppMethodBeat.o(104178);
        } else if (str.equals("4")) {
            faceNumberItemView.setImageResource(R.drawable.c6r);
            AppMethodBeat.o(104178);
        } else if (str.equals("5")) {
            faceNumberItemView.setImageResource(R.drawable.c6s);
            AppMethodBeat.o(104178);
        } else if (str.equals("6")) {
            faceNumberItemView.setImageResource(R.drawable.c6t);
            AppMethodBeat.o(104178);
        } else if (str.equals("7")) {
            faceNumberItemView.setImageResource(R.drawable.c6u);
            AppMethodBeat.o(104178);
        } else if (str.equals("8")) {
            faceNumberItemView.setImageResource(R.drawable.c6v);
            AppMethodBeat.o(104178);
        } else if (str.equals("9")) {
            faceNumberItemView.setImageResource(R.drawable.c6w);
            AppMethodBeat.o(104178);
        } else {
            faceNumberItemView.setImageResource(R.drawable.c6x);
            AppMethodBeat.o(104178);
        }
    }

    private void cTV() {
        AppMethodBeat.i(104179);
        if (this.sWw != null) {
            this.sWx = this.sWw.length();
            AppMethodBeat.o(104179);
            return;
        }
        this.sWx = 0;
        AppMethodBeat.o(104179);
    }

    public final void arF(String str) {
        AppMethodBeat.i(104180);
        this.sWw = str;
        cTV();
        cTU();
        AppMethodBeat.o(104180);
    }
}
