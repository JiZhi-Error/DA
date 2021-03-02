package com.tencent.mm.plugin.voip.widget;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.plugin.voip.ui.c;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.camera.prev.CaptureView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.lang.ref.WeakReference;

public abstract class BaseSmallView extends FrameLayout {
    protected int GUk = -1;
    protected long GUl;
    public d GgP;
    protected WeakReference<c> Hen;
    private Point HpF = new Point();
    private Point HpG = new Point();
    private Point HpH = new Point();
    private Point HpI;
    Runnable HpJ = new Runnable() {
        /* class com.tencent.mm.plugin.voip.widget.BaseSmallView.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(115757);
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.voip.widget.BaseSmallView.AnonymousClass1.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(184093);
                    BaseSmallView.this.eoL();
                    AppMethodBeat.o(184093);
                }
            });
            AppMethodBeat.o(115757);
        }
    };
    protected MMHandler czp;
    private WindowManager mWindowManager;
    private PointF okA = new PointF();
    @Deprecated
    CaptureView qsJ;
    public SurfaceTexture surfaceTexture;

    public void fJm() {
    }

    public void fMf() {
    }

    public void setStatus(int i2) {
    }

    public void uninit() {
        this.mWindowManager = null;
    }

    public BaseSmallView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.czp = new MMHandler();
        this.HpI = new Point(this.mWindowManager.getDefaultDisplay().getWidth(), this.mWindowManager.getDefaultDisplay().getHeight());
    }

    public void setConnectSec(long j2) {
        this.GUl = j2;
    }

    public void setVoipUIListener(c cVar) {
        Log.i("MicroMsg.Voip.BaseSmallView", "hwViewSmall setVoipUIListener, before initHWView");
        this.Hen = new WeakReference<>(cVar);
    }

    @Deprecated
    public OpenGlRender getBeautyData() {
        return null;
    }

    @Deprecated
    public OpenGlRender getSpatioTemporalFilterData() {
        return null;
    }

    @Deprecated
    public void setCaptureView(CaptureView captureView) {
    }

    public void aGx(String str) {
    }

    public void aGy(String str) {
    }

    public boolean eoK() {
        h.RTc.bqo("resumeIcon");
        return true;
    }

    public void setVoicePlayDevice(int i2) {
        h.RTc.bqo("resumeIcon");
        h.RTc.a(this.HpJ, 2000, "resumeIcon");
    }

    public void enR() {
        h.RTc.bqo("resumeIcon");
        h.RTc.a(this.HpJ, 2000, "resumeIcon");
    }

    public void xm(boolean z) {
        h.RTc.bqo("resumeIcon");
        h.RTc.a(this.HpJ, 2000, "resumeIcon");
    }

    public void eoL() {
    }

    public void eoM() {
    }

    @Deprecated
    public void f(int i2, int i3, byte[] bArr) {
    }

    @Deprecated
    public void fJx() {
    }

    @Deprecated
    public void setVoipBeauty(int i2) {
    }

    @Deprecated
    public void setSpatiotemporalDenosing(int i2) {
    }

    @Deprecated
    public void setHWDecMode(int i2) {
    }

    @Deprecated
    public void a(SurfaceTexture surfaceTexture2, d dVar) {
    }

    @Deprecated
    public void requestRender() {
    }

    @Deprecated
    public void jA(int i2, int i3) {
    }

    @Deprecated
    public void releaseSurfaceTexture() {
    }

    @Deprecated
    public void a(byte[] bArr, long j2, int i2, int i3, int i4, int i5, int i6) {
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void onAnimationEnd() {
    }
}
