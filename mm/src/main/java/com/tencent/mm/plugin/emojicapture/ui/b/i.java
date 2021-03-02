package com.tencent.mm.plugin.emojicapture.ui.b;

import android.opengl.GLES20;
import com.google.android.gms.gcm.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.e.c;
import com.tencent.mm.plugin.appbrand.jsapi.e.d;
import com.tencent.mm.plugin.emojicapture.model.d;
import com.tencent.mm.plugin.emojicapture.ui.b.b;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\b\u0010\u0015\u001a\u00020\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0016H\u0014J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0003H\u0016R\u000e\u0010\n\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCropRenderProc;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "aPosition", "aTexCoord", "inputTexture", "programId", "rgbSizeBuff", "Ljava/nio/FloatBuffer;", "uCalcRoundCorner", "uMatrix", "uRadius", "uSize", "uTexture", "beforeRender", "", "renderImpl", "setInputTexture", "texture", "plugin-emojicapture_release"})
public final class i extends a {
    private int hDl = -1;
    private final int programId;
    private final int rwA;
    private final int rwB;
    private final int rwC;
    private final int rwD;
    private final int rwE;
    private final int rwF;
    private FloatBuffer rwG;
    private final int rwz;

    public i(int i2, int i3, int i4, int i5) {
        super(i2, i3, i4, i5, 1, 1);
        AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.rencentusage.a.CTRL_INDEX);
        b.a aVar = b.rvS;
        this.programId = b.a.aB("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform sampler2D texture;\n        uniform vec2 size;\n        uniform float radius;\n        uniform int calcRoundCorner;\n\n        void main () {\n            if (calcRoundCorner == 1) {\n                // round corner\n                vec2 bottomLeftCenter = vec2(radius, radius);\n                vec2 bottomRightCenter = vec2(size.x - radius, radius);\n                vec2 topLeftCenter = vec2(radius, size.y - radius);\n                vec2 topRightCenter = vec2(size.x - radius, size.y - radius);\n                if ((gl_FragCoord.x < bottomLeftCenter.x && gl_FragCoord.y < bottomLeftCenter.y && distance(gl_FragCoord.xy, bottomLeftCenter) > radius) ||\n                    (gl_FragCoord.x > bottomRightCenter.x && gl_FragCoord.y < bottomRightCenter.y && distance(gl_FragCoord.xy, bottomRightCenter) > radius) ||\n                    (gl_FragCoord.x < topLeftCenter.x && gl_FragCoord.y > topLeftCenter.y && distance(gl_FragCoord.xy, topLeftCenter) > radius) ||\n                    (gl_FragCoord.x > topRightCenter.x && gl_FragCoord.y > topRightCenter.y && distance(gl_FragCoord.xy, topRightCenter) > radius))  {\n//                   gl_FragColor = vec4(0.95, 0.95, 0.95, 1.0);\n                    discard;\n                } else {\n                   gl_FragColor = texture2D(texture, v_texCoord);\n                }\n            } else {\n                gl_FragColor = texture2D(texture, v_texCoord);\n            }\n        }\n        ");
        this.rwA = GLES20.glGetAttribLocation(this.programId, "a_position");
        this.rwz = GLES20.glGetAttribLocation(this.programId, "a_texCoord");
        this.rwD = GLES20.glGetUniformLocation(this.programId, "size");
        this.rwE = GLES20.glGetUniformLocation(this.programId, "radius");
        this.rwB = GLES20.glGetUniformLocation(this.programId, "texture");
        this.rwC = GLES20.glGetUniformLocation(this.programId, "uMatrix");
        this.rwF = GLES20.glGetUniformLocation(this.programId, "calcRoundCorner");
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(16).order(ByteOrder.nativeOrder()).asFloatBuffer();
        p.g(asFloatBuffer, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
        this.rwG = asFloatBuffer;
        AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.rencentusage.a.CTRL_INDEX);
    }

    @Override // com.tencent.mm.media.j.b.a
    public final void rl(int i2) {
        this.hDl = i2;
    }

    @Override // com.tencent.mm.media.j.b.a
    public final void aEB() {
        AppMethodBeat.i(c.CTRL_INDEX);
        super.aEB();
        this.rwG.position(0);
        this.rwG.put((float) this.hEp);
        this.rwG.put((float) this.hEq);
        AppMethodBeat.o(c.CTRL_INDEX);
    }

    @Override // com.tencent.mm.media.j.b.a
    public final void aMV() {
        AppMethodBeat.i(d.CTRL_INDEX);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16640);
        GLES20.glUseProgram(this.programId);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, this.hDl);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, Task.EXTRAS_LIMIT_BYTES, 9729.0f);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glUniform1i(this.rwB, 0);
        GLES20.glUniformMatrix4fv(this.rwC, 1, false, this.ijG, 0);
        this.rwG.position(0);
        GLES20.glUniform2fv(this.rwD, 1, this.rwG);
        int i2 = this.rwE;
        d.a aVar = com.tencent.mm.plugin.emojicapture.model.d.roA;
        GLES20.glUniform1f(i2, ((float) Math.max(this.hEp, this.hEq)) * 0.06666667f);
        GLES20.glUniform1i(this.rwF, 1);
        this.hDU.position(0);
        GLES20.glVertexAttribPointer(this.rwA, 2, 5126, false, 0, (Buffer) this.hDU);
        GLES20.glEnableVertexAttribArray(this.rwA);
        this.hDT.position(0);
        GLES20.glVertexAttribPointer(this.rwz, 2, 5126, false, 0, (Buffer) this.hDT);
        GLES20.glEnableVertexAttribArray(this.rwz);
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(770, 771);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.rwA);
        GLES20.glDisableVertexAttribArray(this.rwz);
        GLES20.glBindTexture(3553, 0);
        GLES20.glFinish();
        AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.e.d.CTRL_INDEX);
    }
}
