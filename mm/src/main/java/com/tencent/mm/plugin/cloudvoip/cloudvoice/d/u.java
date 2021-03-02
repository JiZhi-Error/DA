package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.SurfaceTexture;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.TextureView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.a;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.smtt.sdk.WebView;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

public final class u extends MMTextureView implements TextureView.SurfaceTextureListener, c, d {
    private TextPaint iW = null;
    protected MMHandler kAn;
    private boolean ltv = false;
    private Bitmap mBitmap = null;
    private boolean mInited = false;
    private Timer mTimer;
    private int mVideoHeight = 0;
    private int mVideoWidth = 0;
    private int mViewId = 0;
    private int qsO = 0;
    private int qsP = 0;
    private String qso = "";
    private int qsp = -1;
    private int qvf = 0;
    private Paint qvj = null;
    private int qvk;
    private int qvl;
    private int qvm;
    private boolean qvn = false;
    private boolean qvo = false;
    private String text = "";

    public u(Context context, b bVar, JSONObject jSONObject) {
        super(context);
        AppMethodBeat.i(90948);
        this.qsp = bVar.qrD;
        this.qso = bVar.openId;
        this.qvj = new Paint();
        this.qvj.setColor(WebView.NIGHT_MODE_COLOR);
        this.qvj.setFilterBitmap(false);
        setSurfaceTextureListener(this);
        this.qvn = jSONObject.optBoolean("debug", false);
        this.qvn = this.qvn || BuildInfo.IS_FLAVOR_RED || WeChatEnvironment.hasDebugger();
        if (this.qvn) {
            this.qvm = 0;
            this.iW = new TextPaint();
            this.iW.setColor(-65536);
            this.iW.setTextSize(25.0f);
            this.iW.setAntiAlias(true);
            this.qvo = false;
            this.mTimer = new Timer("CloudVoIP_video_info");
            this.text = "debug...";
            this.kAn = new MMHandler();
            if (this.mTimer == null || this.qvo || this.kAn == null) {
                AppMethodBeat.o(90948);
                return;
            } else {
                this.qvo = true;
                this.mTimer.schedule(new TimerTask() {
                    /* class com.tencent.mm.plugin.cloudvoip.cloudvoice.d.u.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(90947);
                        u.this.kAn.post(new Runnable() {
                            /* class com.tencent.mm.plugin.cloudvoip.cloudvoice.d.u.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(90946);
                                u.a(u.this);
                                AppMethodBeat.o(90946);
                            }
                        });
                        AppMethodBeat.o(90947);
                    }
                }, 1000, 1000);
            }
        }
        AppMethodBeat.o(90948);
    }

    @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c
    public final void aG(JSONObject jSONObject) {
        AppMethodBeat.i(90949);
        this.mViewId = jSONObject.optInt("viewId");
        Log.i("MicroMsg.OpenVoice.OpenVoiceVideoView", "init, viewId:" + this.mViewId + ", openId:" + this.qso + ", memberId:" + this.qsp + ", data:" + jSONObject.toString());
        synchronized (this) {
            try {
                this.mInited = true;
            } finally {
                AppMethodBeat.o(90949);
            }
        }
    }

    @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c
    public final void aH(JSONObject jSONObject) {
        AppMethodBeat.i(90950);
        Log.i("MicroMsg.OpenVoice.OpenVoiceVideoView", "update, viewId:" + this.mViewId + ", openId:" + this.qso + ", memberId:" + this.qsp + ", data:" + jSONObject.toString());
        uint();
        aG(jSONObject);
        AppMethodBeat.o(90950);
    }

    @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c
    public final void uint() {
        AppMethodBeat.i(90951);
        Log.i("MicroMsg.OpenVoice.OpenVoiceVideoView", "uint, viewId:" + this.mViewId + ", openId:" + this.qso + ", memberId:" + this.qsp);
        synchronized (this) {
            try {
                this.mInited = false;
            } finally {
                AppMethodBeat.o(90951);
            }
        }
    }

    @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c
    public final void ES(int i2) {
        AppMethodBeat.i(90952);
        if (i2 == this.qsp) {
            AppMethodBeat.o(90952);
            return;
        }
        Log.i("MicroMsg.OpenVoice.OpenVoiceVideoView", "updateMemberId, viewId:" + this.mViewId + ", openId:" + this.qso + ", memberId:[" + this.qsp + "->" + i2 + "]");
        this.qsp = i2;
        AppMethodBeat.o(90952);
    }

    @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c
    public final boolean cyX() {
        return false;
    }

    @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c
    public final int getViewId() {
        return this.mViewId;
    }

    @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c
    public final int getMemberId() {
        return this.qsp;
    }

    @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c
    public final String getOpenId() {
        return this.qso;
    }

    @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c
    public final void a(a aVar) {
        int[] iArr;
        AppMethodBeat.i(90953);
        synchronized (this) {
            try {
                if (this.ltv && this.mInited) {
                    if (!(this.mVideoWidth == aVar.width && this.mVideoHeight == aVar.height && this.mBitmap != null)) {
                        this.mVideoWidth = aVar.width;
                        this.mVideoHeight = aVar.height;
                        this.mBitmap = Bitmap.createBitmap(aVar.width, aVar.height, Bitmap.Config.ARGB_8888);
                    }
                    byte[] bArr = aVar.qrB;
                    int i2 = aVar.djh;
                    if (i2 == 0) {
                        iArr = null;
                    } else {
                        int i3 = i2 / 4;
                        iArr = new int[i3];
                        for (int i4 = 0; i4 < i3; i4++) {
                            iArr[i4] = k(bArr[i4 * 4]) | (k(bArr[(i4 * 4) + 1]) << 8) | (k(bArr[(i4 * 4) + 2]) << 16) | (k(bArr[(i4 * 4) + 3]) << 24);
                        }
                    }
                    this.mBitmap.setPixels(iArr, 0, this.mVideoWidth, 0, 0, this.mVideoWidth, this.mVideoHeight);
                    Bitmap bitmap = this.mBitmap;
                    int i5 = OpenGlRender.FLAG_Angle90;
                    if (bitmap != null) {
                        try {
                            if (!bitmap.isRecycled()) {
                                int width = bitmap.getWidth();
                                int height = bitmap.getHeight();
                                Canvas lockCanvas = lockCanvas(null);
                                if (lockCanvas == null) {
                                    Log.e("MicroMsg.OpenVoice.OpenVoiceVideoView", "drawBitmap, getCanvas failed, viewId:" + this.mViewId + ", openId:" + this.qso + ", mId:" + this.qsp);
                                } else {
                                    this.qvf++;
                                    Matrix matrix = new Matrix();
                                    if (i5 == OpenGlRender.FLAG_Angle270) {
                                        matrix.setRotate(270.0f, (float) (width / 2), (float) (height / 2));
                                    } else if (i5 == OpenGlRender.FLAG_Angle90) {
                                        matrix.setRotate(90.0f, (float) (width / 2), (float) (height / 2));
                                    }
                                    if (OpenGlRender.FLAG_Mirror == 0) {
                                        matrix.postScale(-1.0f, 1.0f);
                                        matrix.postTranslate((float) width, 0.0f);
                                    }
                                    if (this.qvf % 50 == 0) {
                                        this.qvf = 0;
                                        Log.i("MicroMsg.OpenVoice.OpenVoiceVideoView", "drawBitmap, canvas:[width:" + lockCanvas.getWidth() + ", height:" + lockCanvas.getHeight() + "], bitmap:[width:" + width + ", height:" + height + "]");
                                    }
                                    float width2 = ((float) lockCanvas.getWidth()) / ((float) height);
                                    float height2 = ((float) lockCanvas.getHeight()) / ((float) width);
                                    float f2 = width2 > height2 ? width2 : height2;
                                    matrix.postTranslate((float) ((height - width) / 2), (float) ((width - height) / 2));
                                    float f3 = (-(((float) height) - ((((float) width) * ((float) lockCanvas.getWidth())) / ((float) lockCanvas.getHeight())))) / 2.0f;
                                    float f4 = ((double) f3) > 1.0E-4d ? 0.0f : f3;
                                    float f5 = (-(((float) width) - ((((float) height) * ((float) lockCanvas.getHeight())) / ((float) lockCanvas.getWidth())))) / 2.0f;
                                    if (((double) f5) > 1.0E-4d) {
                                        f5 = 0.0f;
                                    }
                                    matrix.postTranslate(f4, f5);
                                    matrix.postScale(f2, f2);
                                    lockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                                    if (!bitmap.isRecycled()) {
                                        lockCanvas.drawBitmap(bitmap, matrix, this.qvj);
                                    }
                                    if (this.qvn) {
                                        this.qvm++;
                                        new StaticLayout(this.text, this.iW, 300, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true).draw(lockCanvas);
                                    }
                                    unlockCanvasAndPost(lockCanvas);
                                }
                                AppMethodBeat.o(90953);
                            }
                        } catch (Exception e2) {
                            Log.printErrStackTrace("MicroMsg.OpenVoice.OpenVoiceVideoView", e2, "drawBitmap unlockCanvasAndPost crash", new Object[0]);
                        }
                    }
                    Log.e("MicroMsg.OpenVoice.OpenVoiceVideoView", "DrawBitmap, bitmap is null or recycled");
                    AppMethodBeat.o(90953);
                }
            } finally {
                AppMethodBeat.o(90953);
            }
        }
    }

    @Override // com.tencent.mm.ui.base.MMTextureView, com.tencent.mm.plugin.cloudvoip.cloudvoice.d.d
    public final void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(186789);
        super.setSurfaceTexture(surfaceTexture);
        czn();
        AppMethodBeat.o(186789);
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        AppMethodBeat.i(90954);
        Log.i("MicroMsg.OpenVoice.OpenVoiceVideoView", "onSurfaceTextureAvailable, surface:" + (surfaceTexture == null ? "isNull" : "nonNull") + ", viewId:" + this.mViewId + ", openId:" + this.qso + ", mId:" + this.qsp + ", width:" + i2 + ", height:" + i3);
        gLi();
        czn();
        AppMethodBeat.o(90954);
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        AppMethodBeat.i(90955);
        Log.i("MicroMsg.OpenVoice.OpenVoiceVideoView", "onSurfaceTextureSizeChanged, viewId:" + this.mViewId + ", openId:" + this.qso + ", mId:" + this.qsp + ", width:" + i2 + ", height:" + i3);
        AppMethodBeat.o(90955);
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(90956);
        Log.i("MicroMsg.OpenVoice.OpenVoiceVideoView", "onSurfaceTextureDestroyed, viewId:" + this.mViewId + ", openId:" + this.qso + ", mId:" + this.qsp);
        synchronized (this) {
            try {
                this.ltv = false;
            } finally {
                AppMethodBeat.o(90956);
            }
        }
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        if (this.kAn != null) {
            this.kAn.removeCallbacksAndMessages(null);
        }
        return false;
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    private void czn() {
        AppMethodBeat.i(186790);
        czo();
        synchronized (this) {
            try {
                this.ltv = true;
            } finally {
                AppMethodBeat.o(186790);
            }
        }
    }

    private void czo() {
        AppMethodBeat.i(186791);
        try {
            Canvas lockCanvas = lockCanvas();
            lockCanvas.drawColor(WebView.NIGHT_MODE_COLOR);
            unlockCanvasAndPost(lockCanvas);
            AppMethodBeat.o(186791);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.OpenVoice.OpenVoiceVideoView", e2, "drawColor for background, unlockCanvasAndPost crash", new Object[0]);
            AppMethodBeat.o(186791);
        }
    }

    private static int k(byte b2) {
        return (((b2 >> 4) & 15) * 16) + (b2 & 15);
    }

    @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.d
    public final void fq(int i2, int i3) {
        this.qvk = i2;
        this.qvl = i3;
    }

    public final int getSameLayerSurfaceWidth() {
        return this.qvk;
    }

    public final int getSameLayerSurfaceHeight() {
        return this.qvl;
    }

    @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.d
    public final void fr(int i2, int i3) {
        this.qsO = i2;
        this.qsP = i3;
    }

    @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c
    public final int getLogicWidth() {
        AppMethodBeat.i(186792);
        if (this.qsO > 0) {
            int i2 = this.qsO;
            AppMethodBeat.o(186792);
            return i2;
        }
        int zC = g.zC(getWidth());
        AppMethodBeat.o(186792);
        return zC;
    }

    @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c
    public final int getLogicHeight() {
        AppMethodBeat.i(186793);
        if (this.qsP > 0) {
            int i2 = this.qsP;
            AppMethodBeat.o(186793);
            return i2;
        }
        int zC = g.zC(getHeight());
        AppMethodBeat.o(186793);
        return zC;
    }

    static /* synthetic */ void a(u uVar) {
        AppMethodBeat.i(90957);
        uVar.text = "\r\nmid: " + uVar.qsp + "\r\nfps: " + uVar.qvm + "\r\nsize: " + uVar.mVideoWidth + "x" + uVar.mVideoHeight;
        uVar.qvm = 0;
        AppMethodBeat.o(90957);
    }
}
