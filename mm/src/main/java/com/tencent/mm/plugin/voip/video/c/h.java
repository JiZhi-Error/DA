package com.tencent.mm.plugin.voip.video.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\u0013\u0018\u0000 :2\u00020\u0001:\u0001:B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0002J\u0018\u0010*\u001a\u00020#2\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\nH\u0002J&\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020\n2\u0006\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u00020\nJ(\u0010+\u001a\u00020#2\b\u0010,\u001a\u0004\u0018\u00010\u00112\u0006\u0010-\u001a\u00020\n2\u0006\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u00020\nJ\u0012\u00100\u001a\u00020#2\b\u00101\u001a\u0004\u0018\u00010\u000fH\u0002J\"\u00102\u001a\u00020\u00072\b\u00101\u001a\u0004\u0018\u00010\u000f2\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\nH\u0002J\b\u00103\u001a\u00020#H\u0002J\u0006\u00104\u001a\u00020#J\u0006\u00105\u001a\u00020#J0\u00106\u001a\u00020#2\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\n2\u0006\u00107\u001a\u00020\n2\u0006\u00108\u001a\u00020\n2\u0006\u0010/\u001a\u00020\nH\u0002J\u0016\u00109\u001a\u00020#2\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\nR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010 \u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010!\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, hxF = {"Lcom/tencent/mm/plugin/voip/video/programv2/VoipYUVRenderProgram;", "", "()V", "all", "Ljava/nio/ByteBuffer;", "kotlin.jvm.PlatformType", "canDrawYuv", "", "clearFrame", "mAngle", "", "mFlag", "mHardDrawCnt", "mHeight", "mImage", "", "mImage32", "", "mMirror", "mSProgram", "Lcom/tencent/mm/plugin/voip/video/programv2/VoipGLSProgram;", "mScreenHeight", "mScreenWidth", "mSoftDrawCnt", "mUIHeight", "mUIWidth", "mVideoHeight", "mVideoWidth", "mWidth", "renderType", "u", "uv", "v", "y", "checkDisplayAngleSoft", "", "width", "height", "clipEdge", "cropTextureCoord", "", "vert", "createBuffer", "drawFrame", "pBuff", "w", "h", "flag", "feedData", "yuvData", "isYuvDataValid", "onDrawFrame", "release", "renderImpl", "setYUVDataSize", "screenWidth", "screenHeight", "updateDrawViewSize", "Companion", "plugin-voip_release"})
public final class h {
    public static final a HmL = new a((byte) 0);
    public int AOS;
    public int FfM;
    public int Hif;
    public int Hig;
    public byte[] Him;
    public int[] Hin;
    public a HmK = new a();
    public ByteBuffer Hmg = ByteBuffer.allocate(0);
    public ByteBuffer Hmh = ByteBuffer.allocate(0);
    public ByteBuffer Hmi = ByteBuffer.allocate(0);
    public ByteBuffer Hmj = ByteBuffer.allocate(0);
    public boolean Hmk;
    public volatile boolean Hmo;
    public int Hmp;
    public int Hmq;
    public int hEm;
    public volatile boolean ijr;
    public int mHeight;
    public int mScreenHeight;
    public int mScreenWidth;
    public int mVideoHeight;
    public int mVideoWidth;
    public int mWidth;
    public ByteBuffer y = ByteBuffer.allocate(0);

    static {
        AppMethodBeat.i(236185);
        AppMethodBeat.o(236185);
    }

    public h() {
        AppMethodBeat.i(236184);
        AppMethodBeat.o(236184);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/voip/video/programv2/VoipYUVRenderProgram$Companion;", "", "()V", "TAG", "", "plugin-voip_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
