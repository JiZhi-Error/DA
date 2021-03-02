package com.tencent.mm.plugin.multitalk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.camera.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.wxmm.v2helper;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u000b\u0018\u0000 )2\u00020\u0001:\u0001)B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001b\u001a\u00020\u001cH\u0016J8\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u0010H\u0016J\u0010\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u0010H\u0016J0\u0010'\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u0010H\u0016J\u0010\u0010(\u001a\u00020\u001c2\u0006\u0010\f\u001a\u00020\bH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006*"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/model/VideoTransOutDataMuxer;", "Lcom/tencent/mm/plugin/multitalk/model/VideoTransOutDataHandler;", "multiTalkSdkApi", "Lcom/tencent/pb/talkroom/sdk/IMultiTalkSdkApi;", "(Lcom/tencent/pb/talkroom/sdk/IMultiTalkSdkApi;)V", "avcCodec", "Lcom/tencent/mm/plugin/multitalk/model/MultiAvcEncoder;", "isForceUseSWEncode", "", "()Z", "setForceUseSWEncode", "(Z)V", "isVideo", "getMultiTalkSdkApi", "()Lcom/tencent/pb/talkroom/sdk/IMultiTalkSdkApi;", "ori", "", "getOri", "()I", "setOri", "(I)V", "tick", "", "getTick", "()J", "setTick", "(J)V", "close", "", d.a.NAME, "pBuffer", "", "bufferSize", "w", "h", "frameFormat", "mode", "onOrientationChange", "orientation", "onScreenFrame", "switchMode", "Companion", "plugin-multitalk_release"})
public final class ag implements af {
    public static final a zPG = new a((byte) 0);
    private long tick = System.currentTimeMillis();
    private boolean tkD = true;
    private final com.tencent.pb.talkroom.sdk.d zMd;
    private k zPD;
    private boolean zPE = true;
    private int zPF;

    static {
        AppMethodBeat.i(239711);
        AppMethodBeat.o(239711);
    }

    public ag(com.tencent.pb.talkroom.sdk.d dVar) {
        p.h(dVar, "multiTalkSdkApi");
        AppMethodBeat.i(239710);
        this.zMd = dVar;
        AppMethodBeat.o(239710);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/model/VideoTransOutDataMuxer$Companion;", "", "()V", "ENCODING", "", "TAG", "plugin-multitalk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.multitalk.model.af
    public final int b(byte[] bArr, long j2, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(239706);
        p.h(bArr, "pBuffer");
        if (this.tkD) {
            Log.i("VideoTransOutDataMuxer", "onCameraFrame sendToVideo: " + this.tkD + ' ' + com.tencent.mm.plugin.appbrand.utils.ag.LB() + " w: " + i2 + ", h: " + i3);
            int c2 = this.zMd.c(bArr, (int) j2, i2, i3, i4, i5);
            AppMethodBeat.o(239706);
            return c2;
        }
        a(bArr, j2, i2, i3, i4);
        AppMethodBeat.o(239706);
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a9, code lost:
        if (r0 != true) goto L_0x00ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0187, code lost:
        if (r0 != true) goto L_0x0189;
     */
    @Override // com.tencent.mm.plugin.multitalk.model.af
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(byte[] r9, long r10, int r12, int r13, int r14) {
        /*
        // Method dump skipped, instructions count: 419
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.multitalk.model.ag.a(byte[], long, int, int, int):void");
    }

    @Override // com.tencent.mm.plugin.multitalk.model.af
    public final void rQ(boolean z) {
        AppMethodBeat.i(239708);
        if (!z && this.zPD == null) {
            this.zPD = new k("video/avc");
        }
        if (z) {
            this.zPD = null;
        }
        this.tkD = z;
        this.zPF = 1;
        AppMethodBeat.o(239708);
    }

    @Override // com.tencent.mm.plugin.multitalk.model.af
    public final void onOrientationChange(int i2) {
        int i3;
        AppMethodBeat.i(239709);
        switch (i2) {
            case 0:
                i3 = 1;
                break;
            case 90:
                i3 = 2;
                break;
            case TXLiveConstants.RENDER_ROTATION_180 /*{ENCODED_INT: 180}*/:
                i3 = 3;
                break;
            case 270:
                i3 = 4;
                break;
            case v2helper.VOIP_ENC_HEIGHT_LV1 /*{ENCODED_INT: 360}*/:
                i3 = 5;
                break;
            default:
                i3 = 0;
                break;
        }
        com.tencent.mm.plugin.multitalk.d.a aVar = com.tencent.mm.plugin.multitalk.d.a.zYP;
        com.tencent.mm.plugin.multitalk.d.a.hj(62, i3);
        AppMethodBeat.o(239709);
    }

    public final void close() {
        this.tkD = true;
        this.zPD = null;
    }
}
