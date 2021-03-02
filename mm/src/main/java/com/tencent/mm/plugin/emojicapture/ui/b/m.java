package com.tencent.mm.plugin.emojicapture.ui.b;

import android.graphics.Rect;
import android.opengl.GLES20;
import com.google.android.gms.gcm.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.a;
import com.tencent.mm.media.k.c;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiOnWebPageUrlExposed;
import com.tencent.mm.plugin.appbrand.jsapi.bo;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\b\u0010\u001b\u001a\u00020\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u001cH\u0014J\u0018\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u000f2\b\b\u0002\u0010 \u001a\u00020\u0011J\u0010\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u0003H\u0016J&\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u0003R\u000e\u0010\n\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006("}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/ui/gl/StickerPreviewOutputProc;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "aPosition", "aTexCoord", "contentRect", "Landroid/graphics/Rect;", "cornerEnable", "", "cornerRadius", "", "inputTexture", "programId", "sizeBuffer", "Ljava/nio/FloatBuffer;", "uCalcRoundCorner", "uMatrix", "uRadius", "uSize", "uTexture", "beforeRender", "", "renderImpl", "setCorner", "enable", "radius", "setInputTexture", "texture", "updateContentRect", "left", "top", "right", "bottom", "plugin-emojicapture_release"})
public final class m extends a {
    int hDl;
    private final FloatBuffer ikt;
    private final int programId;
    private final int rwA;
    private final int rwB;
    private final int rwC;
    private final int rwD;
    private final int rwE;
    private final int rwF;
    private boolean rwK;
    private final Rect rwL;
    private final int rwz;
    private float tt;

    private m(int i2, int i3, int i4, int i5) {
        super(i2, i3, i4, i5, 1, 1);
        AppMethodBeat.i(869);
        this.hDl = -1;
        this.rwL = new Rect();
        c.a aVar = c.ilt;
        this.programId = c.a.aB("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform sampler2D texture;\n        uniform vec4 rect;\n        uniform float radius;\n        uniform int calcRoundCorner;\n\n        void main () {\n            if (calcRoundCorner == 1) {\n                // round corner\n                vec2 bottomLeftCenter = vec2(rect.x + radius, rect.y + radius);\n                vec2 bottomRightCenter = vec2(rect.z - radius, rect.y + radius);\n                vec2 topLeftCenter = vec2(rect.x + radius, rect.w - radius);\n                vec2 topRightCenter = vec2(rect.z - radius, rect.w - radius);\n                if ((gl_FragCoord.x < bottomLeftCenter.x && gl_FragCoord.y < bottomLeftCenter.y && distance(gl_FragCoord.xy, bottomLeftCenter) > radius) ||\n                    (gl_FragCoord.x > bottomRightCenter.x && gl_FragCoord.y < bottomRightCenter.y && distance(gl_FragCoord.xy, bottomRightCenter) > radius) ||\n                    (gl_FragCoord.x < topLeftCenter.x && gl_FragCoord.y > topLeftCenter.y && distance(gl_FragCoord.xy, topLeftCenter) > radius) ||\n                    (gl_FragCoord.x > topRightCenter.x && gl_FragCoord.y > topRightCenter.y && distance(gl_FragCoord.xy, topRightCenter) > radius))  {\n//                   gl_FragColor = vec4(0.95, 0.95, 0.95, 1.0);\n                    discard;\n                } else {\n                   gl_FragColor = vec4(texture2D(texture, v_texCoord).rgb, 1.0);\n                }\n            } else {\n                gl_FragColor = texture2D(texture, v_texCoord);\n            }\n        }\n        ");
        this.rwA = GLES20.glGetAttribLocation(this.programId, "a_position");
        this.rwz = GLES20.glGetAttribLocation(this.programId, "a_texCoord");
        this.rwC = GLES20.glGetUniformLocation(this.programId, "uMatrix");
        this.rwB = GLES20.glGetUniformLocation(this.programId, "texture");
        this.rwD = GLES20.glGetUniformLocation(this.programId, "rect");
        this.rwE = GLES20.glGetUniformLocation(this.programId, "radius");
        this.rwF = GLES20.glGetUniformLocation(this.programId, "calcRoundCorner");
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(16).order(ByteOrder.nativeOrder()).asFloatBuffer();
        p.g(asFloatBuffer, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
        this.ikt = asFloatBuffer;
        AppMethodBeat.o(869);
    }

    public /* synthetic */ m(int i2, int i3, int i4, int i5, byte b2) {
        this(i2, i3, i4, i5);
    }

    @Override // com.tencent.mm.media.j.b.a
    public final void rl(int i2) {
        this.hDl = i2;
    }

    @Override // com.tencent.mm.media.j.b.a
    public final void aEB() {
        AppMethodBeat.i(JsApiOnWebPageUrlExposed.CTRL_INDEX);
        super.aEB();
        this.ikt.position(0);
        this.ikt.put((float) this.rwL.left);
        this.ikt.put((float) (this.hEq - this.rwL.bottom));
        this.ikt.put((float) this.rwL.right);
        this.ikt.put((float) (this.hEq - this.rwL.top));
        AppMethodBeat.o(JsApiOnWebPageUrlExposed.CTRL_INDEX);
    }

    @Override // com.tencent.mm.media.j.b.a
    public final void aMV() {
        AppMethodBeat.i(866);
        if (this.hDl == -1) {
            AppMethodBeat.o(866);
            return;
        }
        GLES20.glViewport(this.rwL.left, this.hEq - this.rwL.bottom, this.rwL.width(), this.rwL.height());
        GLES20.glUseProgram(this.programId);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, this.hDl);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, Task.EXTRAS_LIMIT_BYTES, 9729.0f);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glUniform1i(this.rwB, 0);
        GLES20.glUniformMatrix4fv(this.rwC, 1, false, this.ijG, 0);
        this.hDU.position(0);
        GLES20.glVertexAttribPointer(this.rwA, 2, 5126, false, 0, (Buffer) this.hDU);
        GLES20.glEnableVertexAttribArray(this.rwA);
        this.hDT.position(0);
        GLES20.glVertexAttribPointer(this.rwz, 2, 5126, false, 0, (Buffer) this.hDT);
        GLES20.glEnableVertexAttribArray(this.rwz);
        this.ikt.position(0);
        GLES20.glUniform4fv(this.rwD, 1, this.ikt);
        GLES20.glUniform1f(this.rwE, this.tt);
        GLES20.glUniform1i(this.rwF, this.rwK ? 1 : 0);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.rwA);
        GLES20.glDisableVertexAttribArray(this.rwz);
        GLES20.glBindTexture(3553, 0);
        GLES20.glFinish();
        AppMethodBeat.o(866);
    }

    public static /* synthetic */ void a(m mVar) {
        AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.d.a.CTRL_INDEX);
        mVar.a(false, 0.0f);
        AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.d.a.CTRL_INDEX);
    }

    public final void a(boolean z, float f2) {
        this.rwK = z;
        this.tt = f2;
    }

    public final void C(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(bo.CTRL_INDEX);
        this.rwL.set(i2, i3, i4, i5);
        AppMethodBeat.o(bo.CTRL_INDEX);
    }
}
