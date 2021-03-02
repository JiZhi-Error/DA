package com.tencent.mm.live.core.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.c.c;
import com.tencent.mm.media.j.b.d;
import com.tencent.mm.media.j.b.e;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 %2\u00020\u0001:\u0001%B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 J\u0016\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0005J\u000e\u0010$\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\u0005R\u000e\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, hxF = {"Lcom/tencent/mm/live/core/render/LiveVisitorRenderer;", "", "userId", "", "streamType", "", "(Ljava/lang/String;I)V", "drawHeight", "drawWidth", "mCost", "", "mFps", "mRendererAnchorTimerCount", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "renderMode", "renderType", "getStreamType", "()I", "setStreamType", "(I)V", "textureRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcTexture;", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "yuvRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcI420ToRgb;", "release", "", "render", "frame", "Lcom/tencent/trtc/TRTCCloudDef$TRTCVideoFrame;", "updateDrawSize", "width", "height", "updateRenderMode", "Companion", "plugin-core_release"})
public final class j {
    public static final a hEt = new a((byte) 0);
    int hDX;
    int hEi = 2;
    int hEm = 1;
    e hEn;
    d hEo;
    int hEp;
    int hEq;
    MTimerHandler hEr = new MTimerHandler("LiveVisitorRendererCounter", (MTimerHandler.CallBack) new b(this), true);
    long hEs;
    private int streamType;
    private String userId;

    static {
        AppMethodBeat.i(196688);
        AppMethodBeat.o(196688);
    }

    public j(String str, int i2) {
        p.h(str, "userId");
        AppMethodBeat.i(196687);
        this.userId = str;
        this.streamType = i2;
        AppMethodBeat.o(196687);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/live/core/render/LiveVisitorRenderer$Companion;", "", "()V", "RENDER_TYPE_I420", "", "RENDER_TYPE_TEXTURE", "TAG", "", "plugin-core_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onTimerExpired"})
    static final class b implements MTimerHandler.CallBack {
        final /* synthetic */ j hEu;

        b(j jVar) {
            this.hEu = jVar;
        }

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(196686);
            if (this.hEu.hDX <= 5) {
                c.aEO();
            } else if (this.hEu.hDX <= 10) {
                c.aEP();
            } else if (this.hEu.hDX > 10) {
                c.aEQ();
            }
            c.qF(this.hEu.hDX);
            this.hEu.hDX = 0;
            AppMethodBeat.o(196686);
            return true;
        }
    }
}
