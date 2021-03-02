package com.tencent.mm.media.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/media/constant/GLShaderConstant;", "", "()V", "Companion", "plugin-mediaeditor_release"})
public final class a {
    private static final String idJ = idJ;
    private static final String idK = idK;
    private static final String idL = idL;
    private static final String idM = idM;
    private static final String idN = idN;
    private static final String idO = idO;
    public static final C0412a idP = new C0412a((byte) 0);
    private static final String vertexShaderCode = vertexShaderCode;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\"\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0006XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0006XT¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00048\u0006XT¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00048\u0006XT¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u00048\u0006XT¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\u00020\u00048\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u00048\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u00048\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0016\u0010\u0012\u001a\u00020\u00048\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0016\u0010\u0014\u001a\u00020\u00048\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\rR\u0016\u0010\u0016\u001a\u00020\u00048\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\rR\u0010\u0010\u0018\u001a\u00020\u00048\u0006XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u00020\u00048\u0006XT¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u00048\u0006XT¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u00020\u00048\u0006XT¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u00020\u00048\u0006XT¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u00020\u00048\u0006XT¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u00020\u00048\u0006XT¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u00020\u00048\u0006XT¢\u0006\u0002\n\u0000R\u0016\u0010 \u001a\u00020\u00048\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\rR\u0010\u0010\"\u001a\u00020\u00048\u0006XT¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u00020\u00048\u0006XT¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u00020\u00048\u0006XT¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u00020\u00048\u0006XT¢\u0006\u0002\n\u0000¨\u0006&"}, hxF = {"Lcom/tencent/mm/media/constant/GLShaderConstant$Companion;", "", "()V", "FRAGMENT_SHADER_BEAUTY", "", "blendFragmentShader", "blendWithBlurBgFragmentShader", "centerInsideWithBackgroundFragmentShader", "emojiBlendRoundCornerFragmentShader", "fadeFragmentShader", "i420FragmentShader", "rgb2yuvFragmentShader", "getRgb2yuvFragmentShader", "()Ljava/lang/String;", "rgb2yuvPortraitFragmentShader", "getRgb2yuvPortraitFragmentShader", "rgb2yuvRotateFragmentShaderI420", "getRgb2yuvRotateFragmentShaderI420", "rgb2yuvRotateFragmentShaderNv12", "getRgb2yuvRotateFragmentShaderNv12", "rgb2yuvVertexShaderCodeI420", "getRgb2yuvVertexShaderCodeI420", "rgb2yuvVertexShaderCodeNv12", "getRgb2yuvVertexShaderCodeNv12", "rgbFragmentExternalShader", "rgbFragmentShader", "rgbRectCornerFragmentShader", "rgbRoundCornerExternalFragmentShader", "rgbRoundCornerFragmentShader", "twoTextureVertexShader", "vertexNotMatrixShader", "vertexShader", "vertexShaderCode", "getVertexShaderCode", "vertexShaderNoMatrix", "vertexWithBlurBgShader", "verticalDisplayFragmentShader", "yuvFragmentShader", "plugin-mediaeditor_release"})
    /* renamed from: com.tencent.mm.media.c.a$a  reason: collision with other inner class name */
    public static final class C0412a {
        private C0412a() {
        }

        public /* synthetic */ C0412a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(218730);
        AppMethodBeat.o(218730);
    }
}
