package com.tencent.mm.plugin.emojicapture.ui.b;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.google.android.gms.gcm.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.plugin.emojicapture.model.d;
import com.tencent.mm.plugin.emojicapture.model.e;
import com.tencent.mm.plugin.emojicapture.ui.b.b;
import com.tencent.mm.plugin.xlabeffect.b;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sticker.f;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u001a\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u00032\b\u00108\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u00109\u001a\u0002062\u0006\u0010$\u001a\u00020\u0003H\u0002J\u0006\u0010:\u001a\u00020;J\u0006\u0010<\u001a\u000200J\u0006\u0010=\u001a\u000206J\u0012\u0010>\u001a\u0002062\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J\"\u0010A\u001a\u0002062\b\u0010?\u001a\u0004\u0018\u00010@2\u0006\u0010B\u001a\u00020\n2\u0006\u0010C\u001a\u00020\nH\u0016J\u001c\u0010D\u001a\u0002062\b\u0010?\u001a\u0004\u0018\u00010@2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\u0006\u0010G\u001a\u000206J\u0010\u0010H\u001a\u0002062\b\u0010I\u001a\u0004\u0018\u00010\u001bJ\u000e\u0010J\u001a\u0002062\u0006\u0010K\u001a\u00020\u0003J\u0012\u0010L\u001a\u0002062\b\u00108\u001a\u0004\u0018\u00010\rH\u0002R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010%\u001a\n '*\u0004\u0018\u00010&0&X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010(\u001a\n '*\u0004\u0018\u00010\u00190\u0019X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X.¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006M"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureMixRenderer;", "Landroid/opengl/GLSurfaceView$Renderer;", "enableAlpha", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "(ZLcom/tencent/mm/sticker/StickerPack;)V", "TAG", "", "blendAttributePosition", "", "blendAttributeTextureCoord", "blendBitmapTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "blendEnableAlpha", "blendProgramId", "blendUniformCornerRadius", "blendUniformEmojiTexture", "blendUniformExternalVideoTexture", "blendUniformHasEmojiTexture", "blendUniformMatrix", "blendUniformNormalVideoTexture", "blendUniformSize", "blendUniformUseNormalVideoTexture", "cubeBuffer", "Ljava/nio/FloatBuffer;", "currentBlendBitmap", "Landroid/graphics/Bitmap;", "detectFaceFbo", "detectFaceTexture", "firstFrame", "inputTextureHeight", "inputTextureWidth", "isInit", "matrix", "", "removeBackground", "renderContent", "Ljava/nio/ByteBuffer;", "kotlin.jvm.PlatformType", "sizeBuffer", "textureCoordBuffer", "toTextureAttributePosition", "toTextureAttributeTextureCoord", "toTextureProgramId", "toTextureSize", "toTextureUniformExternalTexture", "videoDecodeSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "videoDecodeTexture", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "xLabEffectOutputTexture", "drawBlendContent", "", "useNormalVideoTexture", "videoTexture", "drawWithStickerAndRemoveBackground", "getEmojiMixContent", "", "getVideoDecodeSurfaceTexture", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "onDrawFrame", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "onSurfaceChanged", "width", "height", "onSurfaceCreated", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "release", "setBlendFrame", "blendBitmap", "setRemoveBackground", "remove", "simpleDrawVideoContent", "plugin-emojicapture_release"})
public final class d implements GLSurfaceView.Renderer {
    final String TAG = "MicroMsg.EmojiCaptureMixRenderer";
    private final float[] cKH;
    final FloatBuffer hDU;
    b hiH;
    private boolean ihq;
    public int ijY;
    public int ijZ;
    public Bitmap ika;
    int ikf;
    int ikg;
    int ikh;
    int ikj;
    int ikk;
    int ikl;
    int ikm;
    int ikn;
    int iko;
    private final FloatBuffer ikt;
    boolean isInit;
    final f rpM;
    boolean rqp;
    private final boolean rwe;
    com.tencent.mm.media.g.d rwi;
    SurfaceTexture rwj;
    com.tencent.mm.media.g.d rwk;
    int rwl;
    int rwm;
    int rwn;
    int rwo;
    int rwp;
    int rwq;
    int rwr;
    final int rws = 640;
    int rwt;
    com.tencent.mm.media.g.d rwu;
    com.tencent.mm.media.g.d rwv;
    final FloatBuffer rww;
    public ByteBuffer rwx;

    public d(boolean z, f fVar) {
        AppMethodBeat.i(852);
        this.rwe = z;
        this.rpM = fVar;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(b.ilm.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        p.g(asFloatBuffer, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
        this.hDU = asFloatBuffer;
        FloatBuffer asFloatBuffer2 = ByteBuffer.allocateDirect(b.iln.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        p.g(asFloatBuffer2, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
        this.rww = asFloatBuffer2;
        this.ikt = ByteBuffer.allocateDirect(8).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.cKH = new float[16];
        this.ihq = true;
        this.rwx = ByteBuffer.allocate(this.ijY * this.ijZ * 4);
        AppMethodBeat.o(852);
    }

    public final void onDrawFrame(GL10 gl10) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        AppMethodBeat.i(848);
        try {
            long currentTicks = Util.currentTicks();
            b.a aVar = b.rvS;
            b.a.aMY();
            SurfaceTexture surfaceTexture = this.rwj;
            if (surfaceTexture == null) {
                p.btv("videoDecodeSurfaceTexture");
            }
            surfaceTexture.updateTexImage();
            if (!(this.rwu == null || this.rwv == null)) {
                b.a aVar2 = b.rvS;
                int i7 = this.rwt;
                com.tencent.mm.media.g.d dVar = this.rwu;
                if (dVar != null) {
                    i2 = dVar.igv;
                } else {
                    i2 = 0;
                }
                int i8 = this.rws;
                int i9 = this.rws;
                GLES20.glBindFramebuffer(36160, i7);
                GLES20.glBindTexture(3553, i2);
                GLES20.glTexImage2D(3553, 0, NativeBitmapStruct.GLFormat.GL_RGBA, i8, i9, 0, NativeBitmapStruct.GLFormat.GL_RGBA, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
                GLES20.glFramebufferTexture2D(36160, 36064, 3553, i2, 0);
                GLES20.glBindTexture(3553, 0);
                GLES20.glViewport(0, 0, this.rws, this.rws);
                com.tencent.mm.media.g.d dVar2 = this.rwi;
                if (dVar2 != null) {
                    GLES20.glUseProgram(this.rwo);
                    GLES20.glActiveTexture(33984);
                    GLES20.glBindTexture(36197, dVar2.igv);
                    GLES20.glTexParameterf(36197, 10241, 9729.0f);
                    GLES20.glTexParameterf(36197, Task.EXTRAS_LIMIT_BYTES, 9729.0f);
                    GLES20.glTexParameterf(36197, 10242, 33071.0f);
                    GLES20.glTexParameterf(36197, 10243, 33071.0f);
                    GLES20.glUniform1i(this.rwr, 0);
                    this.hDU.position(0);
                    GLES20.glVertexAttribPointer(this.rwp, 2, 5126, false, 0, (Buffer) this.hDU);
                    GLES20.glEnableVertexAttribArray(this.rwp);
                    this.rww.position(0);
                    this.rww.put(b.ilo);
                    this.rww.position(0);
                    GLES20.glVertexAttribPointer(this.rwq, 2, 5126, false, 0, (Buffer) this.rww);
                    GLES20.glEnableVertexAttribArray(this.rwq);
                    GLES20.glDrawArrays(5, 0, 4);
                    GLES20.glDisableVertexAttribArray(this.rwp);
                    GLES20.glDisableVertexAttribArray(this.rwq);
                    GLES20.glBindTexture(3553, 0);
                    GLES20.glBindTexture(36197, 0);
                    GLES20.glFinish();
                }
                GLES20.glBindFramebuffer(36160, 0);
                GLES20.glFinish();
                b.a aVar3 = b.rvS;
                b.a.aMY();
                GLES20.glViewport(0, 0, this.rws, this.rws);
                com.tencent.mm.plugin.xlabeffect.b bVar = this.hiH;
                if (bVar != null) {
                    com.tencent.mm.media.g.d dVar3 = this.rwu;
                    if (dVar3 != null) {
                        i6 = dVar3.igv;
                    } else {
                        i6 = 0;
                    }
                    com.tencent.mm.plugin.xlabeffect.b.a(bVar, i6);
                }
                if (this.ihq) {
                    this.ihq = false;
                    com.tencent.mm.plugin.xlabeffect.b bVar2 = this.hiH;
                    if (bVar2 != null) {
                        com.tencent.mm.media.g.d dVar4 = this.rwu;
                        if (dVar4 != null) {
                            i5 = dVar4.igv;
                        } else {
                            i5 = 0;
                        }
                        com.tencent.mm.plugin.xlabeffect.b.a(bVar2, i5);
                    }
                }
                com.tencent.mm.media.g.d dVar5 = this.rwv;
                if (dVar5 != null) {
                    com.tencent.mm.media.g.d.a(dVar5, this.rws, this.rws, 0, null, 0, 0, 60);
                }
                com.tencent.mm.plugin.xlabeffect.b bVar3 = this.hiH;
                if (bVar3 != null) {
                    com.tencent.mm.media.g.d dVar6 = this.rwu;
                    if (dVar6 != null) {
                        i3 = dVar6.igv;
                    } else {
                        i3 = 0;
                    }
                    com.tencent.mm.media.g.d dVar7 = this.rwv;
                    if (dVar7 != null) {
                        i4 = dVar7.igv;
                    } else {
                        i4 = 0;
                    }
                    com.tencent.mm.plugin.xlabeffect.b.a(bVar3, i3, i4, false, 60);
                }
                com.tencent.mm.media.g.d dVar8 = this.rwv;
                GLES20.glFinish();
                b.a aVar4 = b.rvS;
                b.a.aMY();
                GLES20.glViewport(0, 0, this.ijY, this.ijZ);
                if (dVar8 != null) {
                    GLES20.glViewport(0, 0, this.ijY, this.ijZ);
                    GLES20.glUseProgram(this.ikf);
                    GLES20.glActiveTexture(33984);
                    GLES20.glBindTexture(3553, dVar8.igv);
                    GLES20.glTexParameterf(3553, 10241, 9729.0f);
                    GLES20.glTexParameterf(3553, Task.EXTRAS_LIMIT_BYTES, 9729.0f);
                    GLES20.glTexParameterf(3553, 10242, 33071.0f);
                    GLES20.glTexParameterf(3553, 10243, 33071.0f);
                    GLES20.glUniform1i(this.ikk, 0);
                    GLES20.glUniform1i(this.ikj, 2);
                    GLES20.glUniform1i(this.ikn, 1);
                    GLES20.glUniform1i(this.rwn, this.rwe ? 1 : 0);
                    if (this.ika != null) {
                        GLES20.glActiveTexture(33985);
                        com.tencent.mm.media.g.d dVar9 = this.rwk;
                        if (dVar9 != null) {
                            Bitmap bitmap = this.ika;
                            if (bitmap == null) {
                                p.hyc();
                            }
                            com.tencent.mm.media.g.d.a(dVar9, bitmap);
                        }
                        GLES20.glUniform1i(this.ikl, 1);
                    } else {
                        GLES20.glUniform1i(this.ikl, 1);
                    }
                    this.hDU.position(0);
                    GLES20.glVertexAttribPointer(this.ikg, 2, 5126, false, 0, (Buffer) this.hDU);
                    GLES20.glEnableVertexAttribArray(this.ikg);
                    this.rww.position(0);
                    this.rww.put(b.iln);
                    this.rww.position(0);
                    GLES20.glVertexAttribPointer(this.ikh, 2, 5126, false, 0, (Buffer) this.rww);
                    GLES20.glEnableVertexAttribArray(this.ikh);
                    this.ikt.put((float) this.ijY);
                    this.ikt.put((float) this.ijZ);
                    this.ikt.position(0);
                    GLES20.glUniform2fv(this.rwl, 1, this.ikt);
                    int i10 = this.rwm;
                    d.a aVar5 = com.tencent.mm.plugin.emojicapture.model.d.roA;
                    GLES20.glUniform1f(i10, ((float) Math.max(this.ijY, this.ijZ)) * 0.06666667f);
                    Matrix.setIdentityM(this.cKH, 0);
                    Matrix.scaleM(this.cKH, 0, 1.0f, -1.0f, 1.0f);
                    GLES20.glUniformMatrix4fv(this.iko, 1, false, this.cKH, 0);
                    if (this.ika != null) {
                        GLES20.glUniform1i(this.ikm, 1);
                    } else {
                        GLES20.glUniform1i(this.ikm, 0);
                    }
                    GLES20.glDrawArrays(5, 0, 4);
                    GLES20.glDisableVertexAttribArray(this.ikg);
                    GLES20.glDisableVertexAttribArray(this.ikh);
                    GLES20.glBindTexture(3553, 0);
                    GLES20.glBindTexture(36197, 0);
                    GLES20.glFinish();
                    this.rwx.position(0);
                    GLES20.glReadPixels(0, 0, this.ijY, this.ijY, NativeBitmapStruct.GLFormat.GL_RGBA, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, this.rwx);
                    GLES20.glUseProgram(0);
                }
            }
            Log.i(this.TAG, "draw frame used " + Util.ticksToNow(currentTicks) + LocaleUtil.MALAY);
            AppMethodBeat.o(848);
        } catch (Exception e2) {
            Log.printErrStackTrace(this.TAG, e2, "EmojiCaptureMixRenderer draw frame failed", new Object[0]);
            e eVar = e.roB;
            e.cJa();
            AppMethodBeat.o(848);
        }
    }

    public final void onSurfaceChanged(GL10 gl10, int i2, int i3) {
        AppMethodBeat.i(849);
        Log.i(this.TAG, "onSurfaceChanged, width:" + i2 + ", height:" + i3);
        this.ijY = i2;
        this.ijZ = i3;
        this.rwx = ByteBuffer.allocate(this.ijY * this.ijZ * 4);
        AppMethodBeat.o(849);
    }

    public final void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        AppMethodBeat.i(850);
        Log.i(this.TAG, "onSurfaceCreated");
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glDisable(2929);
        AppMethodBeat.o(850);
    }

    public final SurfaceTexture cJW() {
        AppMethodBeat.i(851);
        SurfaceTexture surfaceTexture = this.rwj;
        if (surfaceTexture == null) {
            p.btv("videoDecodeSurfaceTexture");
        }
        AppMethodBeat.o(851);
        return surfaceTexture;
    }
}
