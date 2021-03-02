package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.compatible.deviceinfo.ac;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.d;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.plugin.voip.video.camera.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.rtmp.TXLiveConstants;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\f\u0018\u0000 D2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001DB'\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0002\u0010\rJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\u000bH\u0016J\b\u0010$\u001a\u00020\u000bH\u0016J\b\u0010%\u001a\u00020\u000bH\u0016J\b\u0010&\u001a\u00020\u0014H\u0016J\b\u0010'\u001a\u00020\u000bH\u0016J\b\u0010(\u001a\u00020\u000bH\u0016J\b\u0010)\u001a\u00020\u000bH\u0016J\u0010\u0010*\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010+\u001a\u00020\u000fH\u0016J\b\u0010,\u001a\u00020\u001dH\u0002J\b\u0010-\u001a\u00020\u001dH\u0016J\u0018\u0010.\u001a\u00020\u001d2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J@\u0010/\u001a\u00020\u001d2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u000b2\u0006\u00106\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u000b2\u0006\u00108\u001a\u000209H\u0016J\u0018\u0010:\u001a\u00020\u001d2\u0006\u0010;\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\u000bH\u0016J\u0012\u0010=\u001a\u00020\u001d2\b\u0010>\u001a\u0004\u0018\u00010\u0018H\u0016J\u0018\u0010?\u001a\u00020\u001d2\u0006\u0010;\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\u000bH\u0016J\b\u0010@\u001a\u00020\u001dH\u0016J\u0010\u0010A\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010B\u001a\u00020\u001d2\u0006\u0010C\u001a\u00020\u000bH\u0016R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006E"}, hxF = {"Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/SameLayerOpenVoiceOpenGlView;", "Lcom/tencent/mm/plugin/video/ObservableTextureView;", "Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/IOpenVoiceView;", "Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/ISameLayerOpenVoiceView;", "Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/ISameLayerOpenVoiceView$ISameLayerScaleOpenVoiceView;", "Lcom/tencent/mm/plugin/voip/video/camera/common/ICaptureRenderListener;", "ctx", "Landroid/content/Context;", "member", "Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/model/OpenVoiceMember;", "width", "", "height", "(Landroid/content/Context;Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/model/OpenVoiceMember;II)V", "bFace", "", "logicHeight", "logicWidth", "memberId", "openId", "", "render", "Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/OpenVoiceCameraRender;", "sameLayerCallback", "Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/ISameLayerOpenVoiceView$SameLayerCallback;", "sameLayerSurfaceHeight", "sameLayerSurfaceWidth", "viewId", "draw", "", "frame", "Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/model/AVFrame;", "getCameraType", "data", "Lorg/json/JSONObject;", "getLogicHeight", "getLogicWidth", "getMemberId", "getOpenId", "getSameLayerSurfaceHeight", "getSameLayerSurfaceWidth", "getViewId", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "isCameraView", "notifyVideoSizeChanged", "onCameraError", "onCameraPreviewApply", "onFrameDataReady", "pBuffer", "", "lBufferSize", "", "w", "h", "cameraFrameFormat", FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, "dblSampleTime", "", "setLogicSurfaceSize", "surfaceWidth", "surfaceHeight", "setSameLayerCallback", "callback", "setSameLayerSurfaceSize", "uint", "update", "updateMemberId", "mid", "Companion", "cloudvoice_release"})
public final class v extends ObservableTextureView implements c, d, d.a, b {
    public static final a qvv = new a((byte) 0);
    private String openId = "";
    private int qrD = -1;
    private boolean qsN;
    private int qsO;
    private int qsP;
    private final i qvr;
    private d.b qvs;
    private int qvt;
    private int qvu;
    private int viewId;

    static {
        AppMethodBeat.i(186823);
        AppMethodBeat.o(186823);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public v(Context context, com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b bVar, int i2, int i3) {
        super(context);
        p.h(bVar, "member");
        AppMethodBeat.i(186822);
        this.qvr = new i(i2, i3);
        this.qrD = bVar.qrD;
        String str = bVar.openId;
        p.g(str, "member.openId");
        this.openId = str;
        AppMethodBeat.o(186822);
    }

    @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c
    public final void aG(JSONObject jSONObject) {
        AppMethodBeat.i(186813);
        p.h(jSONObject, "data");
        this.viewId = jSONObject.optInt("viewId");
        this.qsN = aI(jSONObject);
        this.qvr.a(this, this.qsN);
        this.qvr.a(this);
        this.qvr.fLb();
        ac fLc = this.qvr.fLc();
        if (fLc != null) {
            if (this.qvr.aPv() % 90 == 0 && this.qvr.aPv() % TXLiveConstants.RENDER_ROTATION_180 != 0) {
                d.b bVar = this.qvs;
                if (bVar != null) {
                    bVar.eq(fLc.height, fLc.width);
                }
            } else {
                d.b bVar2 = this.qvs;
                if (bVar2 != null) {
                    bVar2.eq(fLc.width, fLc.height);
                }
            }
        }
        Log.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "init, viewId:" + this.viewId + ", openId:" + this.openId + ", memberId:" + this.qrD + ", data:" + jSONObject);
        AppMethodBeat.o(186813);
    }

    @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c
    public final void aH(JSONObject jSONObject) {
        AppMethodBeat.i(186814);
        p.h(jSONObject, "data");
        Log.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "update, viewId:" + this.viewId + ", openId:" + this.openId + ", memberId:" + this.qrD + ", data:" + jSONObject);
        boolean aI = aI(jSONObject);
        if (aI != this.qsN) {
            this.qsN = aI;
            this.qvr.fLd();
        }
        AppMethodBeat.o(186814);
    }

    private static boolean aI(JSONObject jSONObject) {
        AppMethodBeat.i(186815);
        boolean z = true;
        JSONObject optJSONObject = jSONObject.optJSONObject("config");
        if (optJSONObject != null) {
            String optString = optJSONObject.optString("camera", "back");
            Log.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "camera:".concat(String.valueOf(optString)));
            if (p.j(optString, "back")) {
                z = false;
            }
        }
        AppMethodBeat.o(186815);
        return z;
    }

    @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c
    public final void uint() {
        AppMethodBeat.i(186816);
        Log.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "uint, viewId:" + this.viewId + ", openId:" + this.openId + ", memberId:" + this.qrD);
        this.qvr.eoc();
        AppMethodBeat.o(186816);
    }

    @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c
    public final void ES(int i2) {
        AppMethodBeat.i(186817);
        if (i2 == this.qrD) {
            AppMethodBeat.o(186817);
            return;
        }
        Log.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "updateMemberId, viewId:" + this.viewId + ", openId:" + this.openId + ", memberId:[" + this.qrD + "->" + i2 + ']');
        this.qrD = i2;
        AppMethodBeat.o(186817);
    }

    @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c
    public final boolean cyX() {
        return true;
    }

    @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c
    public final int getViewId() {
        return this.viewId;
    }

    @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c
    public final int getMemberId() {
        return this.qrD;
    }

    @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c
    public final String getOpenId() {
        return this.openId;
    }

    @Override // com.tencent.mm.plugin.voip.video.camera.a.b
    public final void a(byte[] bArr, long j2, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(186818);
        p.h(bArr, "pBuffer");
        t czk = q.INSTANCE.czk();
        p.g(czk, "OpenVoiceService.INSTANCE.videoMgr");
        if (!czk.isStarted()) {
            AppMethodBeat.o(186818);
            return;
        }
        q.INSTANCE.d(bArr, i2, i3, i4 + i5);
        AppMethodBeat.o(186818);
    }

    @Override // com.tencent.mm.plugin.voip.video.camera.a.b
    public final void cza() {
    }

    @Override // com.tencent.mm.plugin.voip.video.camera.a.b
    public final void fs(int i2, int i3) {
    }

    @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c
    public final void a(com.tencent.mm.plugin.cloudvoip.cloudvoice.c.a aVar) {
        AppMethodBeat.i(186819);
        p.h(aVar, "frame");
        AppMethodBeat.o(186819);
    }

    @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.d.a
    public final void setSameLayerCallback(d.b bVar) {
        this.qvs = bVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/SameLayerOpenVoiceOpenGlView$Companion;", "", "()V", "TAG", "", "cloudvoice_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.d
    public final void fq(int i2, int i3) {
        this.qvt = i2;
        this.qvu = i3;
    }

    public final int getSameLayerSurfaceWidth() {
        return this.qvt;
    }

    public final int getSameLayerSurfaceHeight() {
        return this.qvu;
    }

    @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.d
    public final void fr(int i2, int i3) {
        this.qsO = i2;
        this.qsP = i3;
    }

    @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c
    public final int getLogicWidth() {
        AppMethodBeat.i(186820);
        if (this.qsO > 0) {
            int i2 = this.qsO;
            AppMethodBeat.o(186820);
            return i2;
        }
        int width = getWidth();
        AppMethodBeat.o(186820);
        return width;
    }

    @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c
    public final int getLogicHeight() {
        AppMethodBeat.i(186821);
        if (this.qsP > 0) {
            int i2 = this.qsP;
            AppMethodBeat.o(186821);
            return i2;
        }
        int height = getHeight();
        AppMethodBeat.o(186821);
        return height;
    }
}
