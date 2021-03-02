package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.a;
import com.tencent.mm.plugin.voip.video.camera.a.b;
import com.tencent.mm.plugin.voip.video.camera.prev.CaptureView;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class j extends CaptureView implements c, b {
    private int mHeight = 480;
    private int mViewId = 0;
    private int mWidth = 640;
    private int qrQ = 0;
    private String qso = "";
    private int qsp = -1;
    private i qsq = null;

    public j(Context context, com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b bVar, int i2, int i3) {
        super(context);
        AppMethodBeat.i(186726);
        this.mWidth = i2;
        this.mHeight = i3;
        Log.i("MicroMsg.OpenVoice.OpenVoiceCameraView", "anlin OpenVoiceCameraView: mWidth: " + this.mWidth + ", height: " + this.mHeight);
        this.qsq = new i(this.mWidth, this.mHeight);
        this.qsp = bVar.qrD;
        this.qso = bVar.openId;
        AppMethodBeat.o(186726);
    }

    @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c
    public final void aG(JSONObject jSONObject) {
        AppMethodBeat.i(90809);
        this.mViewId = jSONObject.optInt("viewId");
        boolean z = true;
        JSONObject optJSONObject = jSONObject.optJSONObject("config");
        if (optJSONObject != null) {
            String optString = optJSONObject.optString("camera", "back");
            Log.i("MicroMsg.OpenVoice.OpenVoiceCameraView", "camera:".concat(String.valueOf(optString)));
            if (optString.equals("back")) {
                z = false;
            }
        }
        this.qsq.a(this, z);
        this.qsq.a(this);
        this.qsq.fLb();
        Log.i("MicroMsg.OpenVoice.OpenVoiceCameraView", "init, viewId:" + this.mViewId + ", openId:" + this.qso + ", memberId:" + this.qsp + ", data:" + jSONObject.toString());
        AppMethodBeat.o(90809);
    }

    @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c
    public final void aH(JSONObject jSONObject) {
        AppMethodBeat.i(90810);
        Log.i("MicroMsg.OpenVoice.OpenVoiceCameraView", "update, viewId:" + this.mViewId + ", openId:" + this.qso + ", memberId:" + this.qsp + ", data:" + jSONObject.toString());
        uint();
        aG(jSONObject);
        AppMethodBeat.o(90810);
    }

    @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c
    public final void uint() {
        AppMethodBeat.i(90811);
        Log.i("MicroMsg.OpenVoice.OpenVoiceCameraView", "uint, viewId:" + this.mViewId + ", openId:" + this.qso + ", memberId:" + this.qsp);
        this.qsq.eoc();
        AppMethodBeat.o(90811);
    }

    @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c
    public final void ES(int i2) {
        AppMethodBeat.i(90812);
        if (i2 == this.qsp) {
            AppMethodBeat.o(90812);
            return;
        }
        Log.i("MicroMsg.OpenVoice.OpenVoiceCameraView", "updateMemberId, viewId:" + this.mViewId + ", openId:" + this.qso + ", memberId:[" + this.qsp + "->" + i2 + "]");
        this.qsp = i2;
        AppMethodBeat.o(90812);
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
        AppMethodBeat.i(90813);
        int i6 = this.qrQ;
        this.qrQ = i6 + 1;
        if (i6 % 50 == 0) {
            Log.i("MicroMsg.OpenVoice.OpenVoiceCameraView", "onFrameDataReady, w:" + i2 + ",h:" + i3 + ",format:" + i4 + ",len:" + bArr.length + ",size:" + j2 + ",rotate:" + i5 + ",time:0.0");
        }
        if (!q.INSTANCE.qtf.isStarted()) {
            AppMethodBeat.o(90813);
            return;
        }
        q.INSTANCE.d(bArr, i2, i3, i4 + i5);
        AppMethodBeat.o(90813);
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

    @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c
    public final int getLogicWidth() {
        AppMethodBeat.i(186727);
        int width = getWidth();
        AppMethodBeat.o(186727);
        return width;
    }

    @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c
    public final int getLogicHeight() {
        AppMethodBeat.i(186728);
        int height = getHeight();
        AppMethodBeat.o(186728);
        return height;
    }
}
