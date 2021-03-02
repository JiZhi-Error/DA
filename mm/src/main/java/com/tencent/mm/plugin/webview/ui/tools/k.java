package com.tencent.mm.plugin.webview.ui.tools;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.webview.ui.tools.LogoWebViewWrapper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;

public final class k implements LogoWebViewWrapper.b {
    static final int JgQ = R.drawable.csb;
    a JgM;
    ImageView JgN;
    LogoWebViewWrapper JgO;
    int JgP = 0;
    private boolean JgR = false;
    private float JgS = 0.0f;
    private ValueAnimator JgT;
    private ViewPropertyAnimator JgU;
    private float JgV;
    View JgW;
    View JgX;
    TextView JgY;
    boolean JgZ = true;
    boolean Jha;
    private boolean Jhb;
    private boolean aWP = false;
    boolean lcy = false;
    private int zaj = 0;

    public interface a {
        void geZ();
    }

    public k() {
        boolean z = true;
        AppMethodBeat.i(211096);
        this.Jha = WeChatBrands.AppInfo.current().isMainland() ? false : z;
        this.Jhb = false;
        AppMethodBeat.o(211096);
    }

    public final void geU() {
        AppMethodBeat.i(79923);
        this.lcy = false;
        stopLoading();
        if (this.JgZ && this.JgX != null && !this.Jha) {
            zh(false);
            if (this.JgO != null) {
                this.JgO.setReleaseTargetHeight(0);
            }
            geX();
        }
        AppMethodBeat.o(79923);
    }

    public final void setMMOverScrollOffsetListener(LogoWebViewWrapper.b bVar) {
        AppMethodBeat.i(79924);
        if (this.JgO != null) {
            this.JgO.setMMOverScrollOffsetListener(bVar);
        }
        AppMethodBeat.o(79924);
    }

    public final void startLoading() {
        AppMethodBeat.i(79926);
        if (this.aWP) {
            AppMethodBeat.o(79926);
        } else if (this.JgN == null || this.JgO == null) {
            AppMethodBeat.o(79926);
        } else {
            this.aWP = true;
            this.JgO.zh(true);
            this.JgN.clearAnimation();
            if (this.JgT != null) {
                this.JgT.cancel();
            }
            this.JgT = ObjectAnimator.ofFloat(this, "startLoadingStep", this.JgS + 0.0f, this.JgS + 354.0f);
            this.JgT.setDuration(960L);
            this.JgT.setRepeatMode(1);
            this.JgT.setRepeatCount(-1);
            this.JgT.setInterpolator(new LinearInterpolator());
            this.JgT.start();
            if (this.JgM != null) {
                this.JgM.geZ();
            }
            AppMethodBeat.o(79926);
        }
    }

    public final void stopLoading() {
        AppMethodBeat.i(79927);
        if (!this.aWP) {
            AppMethodBeat.o(79927);
            return;
        }
        Log.d("MicroMsg.WebViewPullDownLogoDelegate", "stopLoading()");
        this.JgR = true;
        this.aWP = false;
        if (this.JgO != null && this.lcy) {
            this.JgO.zh(false);
        }
        if (this.JgT != null) {
            this.JgT.cancel();
        }
        if (this.JgO != null) {
            this.JgO.s(0, 250);
        }
        if (this.JgN != null) {
            Log.d("MicroMsg.WebViewPullDownLogoDelegate", "refreshImage, alpha to 0f");
            this.JgN.animate().alpha(0.0f).setDuration(500).start();
        }
        AppMethodBeat.o(79927);
    }

    public final void release() {
        AppMethodBeat.i(79928);
        if (this.JgO != null) {
            LogoWebViewWrapper logoWebViewWrapper = this.JgO;
            if (logoWebViewWrapper.Jea != null) {
                logoWebViewWrapper.Jea.removeView(logoWebViewWrapper.gxL);
                logoWebViewWrapper.gxL = null;
            }
            LogoWebViewWrapper logoWebViewWrapper2 = this.JgO;
            logoWebViewWrapper2.Jeh = null;
            logoWebViewWrapper2.Jeg = null;
        }
        if (this.JgW != null) {
            ((ViewGroup) this.JgW).removeAllViews();
        }
        this.JgO = null;
        this.JgN = null;
        this.zaj = 0;
        if (this.JgT != null) {
            this.JgT.cancel();
            this.JgT = null;
        }
        AppMethodBeat.o(79928);
    }

    public final void agK(int i2) {
        AppMethodBeat.i(79929);
        if (this.JgW != null) {
            this.JgW.setBackgroundColor(i2);
            Log.d("MicroMsg.WebViewPullDownLogoDelegate", "setLogoBackgroundColor %d", Integer.valueOf(i2));
        }
        AppMethodBeat.o(79929);
    }

    public final void geW() {
        AppMethodBeat.i(79931);
        if (this.JgX != null) {
            this.JgX.setVisibility(8);
        }
        AppMethodBeat.o(79931);
    }

    public final void geX() {
        AppMethodBeat.i(79932);
        if (this.JgX != null && !this.Jhb) {
            this.JgX.setVisibility(0);
        }
        AppMethodBeat.o(79932);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.LogoWebViewWrapper.b
    public final void aa(int i2, boolean z) {
        String valueOf;
        String obj;
        String valueOf2;
        int i3;
        AppMethodBeat.i(79933);
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = Boolean.valueOf(z);
        if (this.JgN == null) {
            valueOf = BuildConfig.COMMAND;
        } else {
            valueOf = String.valueOf(this.JgN.getVisibility());
        }
        objArr[2] = valueOf;
        if (this.JgN == null) {
            obj = BuildConfig.COMMAND;
        } else {
            obj = this.JgN.getDrawable().toString();
        }
        objArr[3] = obj;
        if (this.JgN == null) {
            valueOf2 = BuildConfig.COMMAND;
        } else {
            valueOf2 = String.valueOf(this.JgN.getAlpha());
        }
        objArr[4] = valueOf2;
        Log.v("MicroMsg.WebViewPullDownLogoDelegate", "onOverScrollOffset, offset = %d, pointerDown = %b, refreshImage.visibility = %s, refreshImage.drawable = %s, refreshImage.alpha = %s", objArr);
        if (!this.lcy) {
            AppMethodBeat.o(79933);
            return;
        }
        if (i2 == 0) {
            this.JgR = false;
        }
        if (this.JgN == null) {
            AppMethodBeat.o(79933);
            return;
        }
        if (!z) {
            if (Math.abs(i2) > this.JgP && !this.aWP) {
                Log.d("MicroMsg.WebViewPullDownLogoDelegate", "startLoading()");
                startLoading();
                AppMethodBeat.o(79933);
                return;
            } else if (this.aWP) {
                AppMethodBeat.o(79933);
                return;
            }
        } else if (Math.abs(i2) >= this.JgP) {
            if (this.JgO != null) {
                this.JgO.setReleaseTargetHeight(this.JgP);
            }
        } else if (this.JgO != null) {
            this.JgO.setReleaseTargetHeight(0);
        }
        if (this.JgN != null && this.JgN.getAlpha() < 1.0f && this.JgU == null && z) {
            Log.d("MicroMsg.WebViewPullDownLogoDelegate", "refreshImage alpha to 1.0f");
            this.JgU = this.JgN.animate().alpha(1.0f).setDuration(500);
            this.JgU.setListener(new AnimatorListenerAdapter() {
                /* class com.tencent.mm.plugin.webview.ui.tools.k.AnonymousClass1 */

                public final void onAnimationCancel(Animator animator) {
                    AppMethodBeat.i(79921);
                    super.onAnimationCancel(animator);
                    k.this.JgU = null;
                    AppMethodBeat.o(79921);
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(79922);
                    super.onAnimationEnd(animator);
                    k.this.JgU = null;
                    AppMethodBeat.o(79922);
                }
            });
            this.JgU.start();
        }
        if (!this.JgR) {
            int i4 = (-i2) - this.zaj;
            if (Math.abs(i2) >= this.JgP) {
                i3 = i4 * 5;
            } else {
                i3 = i4 * 2;
            }
            this.zaj = -i2;
            float width = ((float) this.JgN.getWidth()) / 2.0f;
            this.JgS -= (float) i3;
            this.JgN.setScaleType(ImageView.ScaleType.MATRIX);
            Matrix imageMatrix = this.JgN.getImageMatrix();
            imageMatrix.postRotate((float) (-i3), width, ((float) this.JgN.getHeight()) / 2.0f);
            this.JgN.setImageMatrix(imageMatrix);
            this.JgN.setImageResource(JgQ);
        }
        this.JgN.invalidate();
        AppMethodBeat.o(79933);
    }

    public final float getStartLoadingStep() {
        return this.JgV;
    }

    public final void setStartLoadingStep(float f2) {
        float width;
        float f3 = 0.0f;
        AppMethodBeat.i(79934);
        this.JgV = f2;
        this.JgN.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix imageMatrix = this.JgN.getImageMatrix();
        if (this.JgN == null) {
            width = 0.0f;
        } else {
            width = ((float) this.JgN.getWidth()) / 2.0f;
        }
        if (this.JgN != null) {
            f3 = ((float) this.JgN.getHeight()) / 2.0f;
        }
        imageMatrix.setRotate(f2, width, f3);
        this.JgS = f2;
        this.JgN.invalidate();
        AppMethodBeat.o(79934);
    }

    public final void zh(boolean z) {
        AppMethodBeat.i(79935);
        if (!(this.JgO == null || this.JgO.Jed == z)) {
            this.JgO.zh(z);
            geW();
            this.Jha = !WeChatBrands.AppInfo.current().isMainland() || z;
        }
        AppMethodBeat.o(79935);
    }

    public final void setCurrentURL(String str) {
        AppMethodBeat.i(79937);
        if (!this.JgZ || this.Jha) {
            zh(true);
            if (this.JgX != null && this.JgX.getVisibility() == 0) {
                geW();
            }
            AppMethodBeat.o(79937);
            return;
        }
        if (this.JgY != null) {
            if (!Util.isNullOrNil(str)) {
                String host = Uri.parse(str).getHost();
                if (!Util.isNullOrNil(host)) {
                    String string = this.JgY.getContext().getString(R.string.izp, host);
                    this.JgY.setVisibility(0);
                    this.JgY.setText(string);
                    zh(false);
                    AppMethodBeat.o(79937);
                    return;
                }
            }
            this.JgY.setVisibility(8);
        }
        AppMethodBeat.o(79937);
    }

    static boolean geY() {
        AppMethodBeat.i(259615);
        boolean isMainland = WeChatBrands.AppInfo.current().isMainland();
        AppMethodBeat.o(259615);
        return isMainland;
    }

    public final void geV() {
        AppMethodBeat.i(211097);
        this.Jhb = WeChatBrands.AppInfo.current().isMainland();
        AppMethodBeat.o(211097);
    }
}
