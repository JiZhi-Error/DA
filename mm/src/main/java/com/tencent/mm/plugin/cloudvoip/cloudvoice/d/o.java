package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.a;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.OpenGlView;
import com.tencent.mm.plugin.voip.video.b.e;
import com.tencent.mm.plugin.voip.video.camera.a.b;
import com.tencent.mm.plugin.voip.video.camera.prev.CaptureView;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public final class o extends RelativeLayout implements c, b {
    private int mHeight = 480;
    private int mViewId = 0;
    private int mWidth = 640;
    private int qrQ = 0;
    private CaptureView qsJ;
    OpenGlRender qsK;
    private OpenGlView qsL;
    boolean qsM;
    private boolean qsN = false;
    private int qsO = 0;
    private int qsP = 0;
    private String qso = "";
    private int qsp = -1;
    private i qsq = null;

    public o(Context context, com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b bVar, int i2, int i3) {
        super(context);
        AppMethodBeat.i(186734);
        this.mWidth = i2;
        this.mHeight = i3;
        Log.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "anlin OpenVoiceOpenGlView: mWidth: " + this.mWidth + ", height: " + this.mHeight);
        this.qsq = new i(this.mWidth, this.mHeight);
        this.qsp = bVar.qrD;
        this.qso = bVar.openId;
        this.qsL = new OpenGlView(context);
        this.qsK = new OpenGlRender(this.qsL, OpenGlRender.RenderLocal);
        this.qsM = true;
        this.qsL.setRenderer(this.qsK);
        this.qsL.setRenderMode(0);
        addView(this.qsL);
        this.qsJ = new CaptureView(context);
        addView(this.qsJ, new RelativeLayout.LayoutParams(1, 1));
        this.qsJ.setVisibility(0);
        this.qsJ.setAlpha(0.0f);
        AppMethodBeat.o(186734);
    }

    @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c
    public final void aG(JSONObject jSONObject) {
        AppMethodBeat.i(186735);
        this.mViewId = jSONObject.optInt("viewId");
        this.qsN = true;
        JSONObject optJSONObject = jSONObject.optJSONObject("config");
        if (optJSONObject != null) {
            String optString = optJSONObject.optString("camera", "back");
            Log.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "camera:".concat(String.valueOf(optString)));
            if (optString.equals("back")) {
                this.qsN = false;
            }
        }
        this.qsq.a(this, this.qsN);
        this.qsq.a(this.qsJ);
        this.qsq.fLb();
        Log.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "init, viewId:" + this.mViewId + ", openId:" + this.qso + ", memberId:" + this.qsp + ", data:" + jSONObject.toString());
        e.fLK().HlY = new e.a() {
            /* class com.tencent.mm.plugin.cloudvoip.cloudvoice.d.o.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.voip.video.b.e.a
            public final void MC() {
                AppMethodBeat.i(186733);
                o oVar = o.this;
                SurfaceTexture surfaceTexture = v2protocal.mSurfaceTexture;
                d dVar = v2protocal.HcD;
                if (surfaceTexture == null || dVar == null) {
                    Log.e("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "setSurfaceTexture error, videoTexture:%s, videoTexture:%s", surfaceTexture, dVar);
                    AppMethodBeat.o(186733);
                } else if (!oVar.qsM || oVar.qsK == null) {
                    Log.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "setSurfaceTexture failed , texId:%d,mInitDone:%b", Integer.valueOf(dVar.igv), Boolean.valueOf(oVar.qsM));
                    AppMethodBeat.o(186733);
                } else {
                    oVar.qsK.a(surfaceTexture, dVar);
                    Log.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "setSurfaceTexture OK , videoTexture:%d", Integer.valueOf(dVar.igv));
                    AppMethodBeat.o(186733);
                }
            }
        };
        try {
            float[] L = L(jSONObject);
            if (L != null) {
                this.qsL.jG((int) L[2], (int) L[3]);
            }
        } catch (JSONException e2) {
            Log.e("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "parse position error. Exception :%s", e2);
        }
        this.qsK.onStarted();
        AppMethodBeat.o(186735);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0090 A[Catch:{ JSONException -> 0x00b7 }] */
    @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void aH(org.json.JSONObject r10) {
        /*
        // Method dump skipped, instructions count: 250
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.cloudvoip.cloudvoice.d.o.aH(org.json.JSONObject):void");
    }

    @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c
    public final void uint() {
        AppMethodBeat.i(186737);
        Log.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "uint, viewId:" + this.mViewId + ", openId:" + this.qso + ", memberId:" + this.qsp);
        this.qsq.eoc();
        this.qsK.releaseSurfaceTexture();
        this.qsK.fKM();
        AppMethodBeat.o(186737);
    }

    @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c
    public final void ES(int i2) {
        AppMethodBeat.i(186738);
        if (i2 == this.qsp) {
            AppMethodBeat.o(186738);
            return;
        }
        Log.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "updateMemberId, viewId:" + this.mViewId + ", openId:" + this.qso + ", memberId:[" + this.qsp + "->" + i2 + "]");
        this.qsp = i2;
        AppMethodBeat.o(186738);
    }

    @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c
    public final boolean cyX() {
        return true;
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

    @Override // com.tencent.mm.plugin.voip.video.camera.a.b
    public final void a(byte[] bArr, long j2, int i2, int i3, int i4, int i5) {
        OpenGlView openGlView;
        AppMethodBeat.i(186739);
        int i6 = this.qrQ;
        this.qrQ = i6 + 1;
        if (i6 % 50 == 0) {
            Log.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "onFrameDataReady, w:" + i2 + ",h:" + i3 + ",format:" + i4 + ",len:" + bArr.length + ",size:" + j2 + ",rotate:" + i5 + ",time:0.0");
        }
        if (!q.INSTANCE.qtf.isStarted()) {
            AppMethodBeat.o(186739);
            return;
        }
        OpenGlRender openGlRender = this.qsK;
        int i7 = OpenGlRender.FLAG_NV21;
        if (openGlRender.Hiz && openGlRender.Hiv != null && bArr.length >= i2 * i3 && i7 == OpenGlRender.FLAG_NV21) {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            openGlRender.Hiw = bArr;
            if (!(openGlRender.Hih == null || (openGlView = openGlRender.Hih.get()) == null)) {
                openGlView.queueEvent(new Runnable(i2, i3, countDownLatch) {
                    /* class com.tencent.mm.plugin.voip.video.OpenGlRender.AnonymousClass3 */
                    final /* synthetic */ int HiW = 0;
                    final /* synthetic */ int czr;
                    final /* synthetic */ int czs;
                    final /* synthetic */ CountDownLatch val$countDownLatch;

                    {
                        this.czr = r3;
                        this.czs = r4;
                        this.val$countDownLatch = r5;
                    }

                    public final void run() {
                        AppMethodBeat.i(115643);
                        if (!(this.czr == OpenGlRender.this.Hix && this.czs == OpenGlRender.this.Hiy)) {
                            OpenGlRender.this.Hiv.setSize(this.czr, this.czs);
                            OpenGlRender.this.Hix = this.czr;
                            OpenGlRender.this.Hiy = this.czs;
                        }
                        OpenGlRender.this.Hiv.b(OpenGlRender.this.Hiw, this.czr, this.czs, OpenGlRender.this.Hiw);
                        this.val$countDownLatch.countDown();
                        AppMethodBeat.o(115643);
                    }
                });
            }
            try {
                countDownLatch.await(2, TimeUnit.SECONDS);
            } catch (InterruptedException e2) {
            }
        }
        q.INSTANCE.d(bArr, i2, i3, i4 + i5);
        this.qsK.a(bArr, i2, i3, (this.qsq.fLp() ? OpenGlRender.FLAG_Mirror : 0) + OpenGlRender.FLAG_NV21 + (this.qsq.fKZ() ? OpenGlRender.FLAG_Angle270 : OpenGlRender.FLAG_Angle90), true, 3);
        AppMethodBeat.o(186739);
    }

    @Override // com.tencent.mm.plugin.voip.video.camera.a.b
    public final void cza() {
    }

    @Override // com.tencent.mm.plugin.voip.video.camera.a.b
    public final void fs(int i2, int i3) {
    }

    @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c
    public final void a(a aVar) {
    }

    private float[] L(JSONObject jSONObject) {
        AppMethodBeat.i(186740);
        try {
            JSONObject jSONObject2 = new JSONObject(jSONObject.optString("position"));
            float a2 = g.a(jSONObject2, "left", 0.0f);
            float a3 = g.a(jSONObject2, "top", 0.0f);
            float a4 = g.a(jSONObject2, "width", 0.0f);
            float a5 = g.a(jSONObject2, "height", 0.0f);
            int optInt = jSONObject.optInt("zIndex", 0);
            try {
                this.qsO = (int) jSONObject2.optDouble("width", 0.0d);
                this.qsP = (int) jSONObject2.optDouble("height", 0.0d);
            } catch (Exception e2) {
            }
            Log.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "w:%f, h:%f, logicWidth:%d, logicHeight:%d", Float.valueOf(a4), Float.valueOf(a5), Integer.valueOf(this.qsO), Integer.valueOf(this.qsP));
            float[] fArr = {a2, a3, a4, a5, (float) optInt};
            AppMethodBeat.o(186740);
            return fArr;
        } catch (Exception e3) {
            AppMethodBeat.o(186740);
            return null;
        }
    }

    @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c
    public final int getLogicWidth() {
        AppMethodBeat.i(186741);
        if (this.qsO > 0) {
            int i2 = this.qsO;
            AppMethodBeat.o(186741);
            return i2;
        }
        int zC = g.zC(getWidth());
        AppMethodBeat.o(186741);
        return zC;
    }

    @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c
    public final int getLogicHeight() {
        AppMethodBeat.i(186742);
        if (this.qsP > 0) {
            int i2 = this.qsP;
            AppMethodBeat.o(186742);
            return i2;
        }
        int zC = g.zC(getHeight());
        AppMethodBeat.o(186742);
        return zC;
    }
}
