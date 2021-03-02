package com.tencent.mm.plugin.emojicapture.ui.b;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.g;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.h;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.j;
import com.tencent.mm.plugin.emojicapture.ui.b.b;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sticker.f;
import javax.microedition.khronos.egl.EGL;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0010\u0010(\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u000fH\u0002J\u0006\u0010*\u001a\u00020\u001fJ\u001c\u0010+\u001a\u00020\u001f2\u0014\u0010,\u001a\u0010\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u001f\u0018\u00010-J\u0006\u0010/\u001a\u00020'J \u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u00062\u0010\b\u0002\u00102\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eJ\b\u00103\u001a\u00020\u001fH\u0002J(\u00104\u001a\u00020\u001f2\b\u00105\u001a\u0004\u0018\u0001062\u0016\b\u0002\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001f\u0018\u00010-J\b\u00107\u001a\u00020\u001fH\u0002J\u0014\u00108\u001a\u00020\u001f2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eR\u000e\u0010\n\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \u0012*\u0004\u0018\u00010\u00110\u0011X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n \u0012*\u0004\u0018\u00010\u00140\u0014X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n \u0012*\u0004\u0018\u00010\u00160\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020%X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u00069"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureMixEGLPixelBuffer;", "", "width", "", "height", "enableAlpha", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "(IIZLcom/tencent/mm/sticker/StickerPack;)V", "TAG", "", "eGL", "Ljavax/microedition/khronos/egl/EGL10;", "eGLConfig", "Ljavax/microedition/khronos/egl/EGLConfig;", "eGLContext", "Ljavax/microedition/khronos/egl/EGLContext;", "kotlin.jvm.PlatformType", "eGLDisplay", "Ljavax/microedition/khronos/egl/EGLDisplay;", "eGLSurface", "Ljavax/microedition/khronos/egl/EGLSurface;", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "glThread", "Landroid/os/HandlerThread;", "glThreadHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "onPrepareDrawFrame", "Lkotlin/Function0;", "", "getOnPrepareDrawFrame", "()Lkotlin/jvm/functions/Function0;", "setOnPrepareDrawFrame", "(Lkotlin/jvm/functions/Function0;)V", "renderer", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureMixRenderer;", "videoDecodeSurface", "Landroid/view/Surface;", "createEGLContext", "config", "destroyGL", "getRenderContent", "callback", "Lkotlin/Function1;", "", "getVideoDecodeSurface", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "removeBackground", "afterInitCallback", "initPixelBuffer", "mixVideoAndEmojiFrame", "nextFrameInfo", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/MixFrameSyncMgr$NextFrameInfo;", "onVideoSurfaceFrameAvailable", "queue", "plugin-emojicapture_release"})
public final class c {
    public final String TAG = "MicroMsg.EmojiCaptureEGLPixelBuffer";
    final int height;
    final f rpM;
    final EGL10 rvT;
    EGLDisplay rvU;
    EGLContext rvV;
    EGLSurface rvW;
    EGLConfig rvX;
    public GL10 rvY;
    public d rvZ;
    Surface rwa;
    public MMHandler rwb;
    HandlerThread rwc;
    public kotlin.g.a.a<x> rwd;
    final boolean rwe;
    final int width;

    public c(int i2, int i3, boolean z, f fVar) {
        AppMethodBeat.i(845);
        this.width = i2;
        this.height = i3;
        this.rwe = z;
        this.rpM = fVar;
        EGL egl = EGLContext.getEGL();
        if (egl == null) {
            t tVar = new t("null cannot be cast to non-null type javax.microedition.khronos.egl.EGL10");
            AppMethodBeat.o(845);
            throw tVar;
        }
        this.rvT = (EGL10) egl;
        this.rvU = EGL10.EGL_NO_DISPLAY;
        this.rvV = EGL10.EGL_NO_CONTEXT;
        this.rvW = EGL10.EGL_NO_SURFACE;
        HandlerThread hz = com.tencent.f.c.d.hz("EmojiCaptureMixEGLPixelBuffer_GLThread", 5);
        p.g(hz, "SpecialThreadFactory.cre…ad\",Thread.NORM_PRIORITY)");
        this.rwc = hz;
        this.rwc.start();
        this.rwb = new MMHandler(this.rwc.getLooper());
        this.rwb.post(new Runnable(this) {
            /* class com.tencent.mm.plugin.emojicapture.ui.b.c.AnonymousClass1 */
            final /* synthetic */ c rwf;

            {
                this.rwf = r1;
            }

            public final void run() {
                EGLConfig eGLConfig;
                char c2;
                AppMethodBeat.i(837);
                c cVar = this.rwf;
                cVar.rvU = cVar.rvT.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
                if (cVar.rvU == EGL10.EGL_NO_DISPLAY) {
                    Log.e(cVar.TAG, "egl get display error: %s", GLUtils.getEGLErrorString(cVar.rvT.eglGetError()));
                }
                if (!cVar.rvT.eglInitialize(cVar.rvU, new int[2])) {
                    Log.e(cVar.TAG, "egl init error: %s", GLUtils.getEGLErrorString(cVar.rvT.eglGetError()));
                    com.tencent.mm.plugin.emojicapture.model.e eVar = com.tencent.mm.plugin.emojicapture.model.e.roB;
                    com.tencent.mm.plugin.emojicapture.model.e.cIY();
                } else {
                    b.a aVar = b.rvS;
                    EGL10 egl10 = cVar.rvT;
                    EGLDisplay eGLDisplay = cVar.rvU;
                    p.g(eGLDisplay, "eGLDisplay");
                    p.h(egl10, "eGL");
                    p.h(eGLDisplay, "eGLDisplay");
                    int[] iArr = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12352, 4, 12344};
                    int[] iArr2 = new int[1];
                    egl10.eglChooseConfig(eGLDisplay, iArr, null, 0, iArr2);
                    int i2 = iArr2[0];
                    EGLConfig[] eGLConfigArr = new EGLConfig[i2];
                    if (!egl10.eglChooseConfig(eGLDisplay, iArr, eGLConfigArr, i2, iArr2)) {
                        Log.e("MicroMsg.EmojiCaptureGLUtil", "egl choose config failed: %s", GLUtils.getEGLErrorString(egl10.eglGetError()));
                        eGLConfig = null;
                    } else {
                        eGLConfig = eGLConfigArr[0];
                    }
                    cVar.rvX = eGLConfig;
                    EGLConfig eGLConfig2 = cVar.rvX;
                    if (eGLConfig2 != null) {
                        cVar.rvV = cVar.rvT.eglCreateContext(cVar.rvU, eGLConfig2, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
                        cVar.rvW = cVar.rvT.eglCreatePbufferSurface(cVar.rvU, eGLConfig2, new int[]{12375, cVar.width, 12374, cVar.height, 12344});
                        if (cVar.rvW != EGL10.EGL_NO_SURFACE && cVar.rvV != EGL10.EGL_NO_CONTEXT) {
                            c2 = 0;
                        } else if (cVar.rvT.eglGetError() == 12299) {
                            Log.e(cVar.TAG, "eglCreateWindowSurface returned EGL_BAD_NATIVE_WINDOW. ");
                            c2 = 65535;
                        } else {
                            Log.e(cVar.TAG, "eglCreateWindowSurface failed : %s", GLUtils.getEGLErrorString(cVar.rvT.eglGetError()));
                            c2 = 65535;
                        }
                        if (c2 < 0) {
                            Log.e(cVar.TAG, "createEGLContext failed -1");
                            com.tencent.mm.plugin.emojicapture.model.e eVar2 = com.tencent.mm.plugin.emojicapture.model.e.roB;
                            com.tencent.mm.plugin.emojicapture.model.e.cIY();
                        } else {
                            if (!cVar.rvT.eglMakeCurrent(cVar.rvU, cVar.rvW, cVar.rvW, cVar.rvV)) {
                                Log.e(cVar.TAG, "eglMakeCurrent failed : " + GLUtils.getEGLErrorString(cVar.rvT.eglGetError()));
                                com.tencent.mm.plugin.emojicapture.model.e eVar3 = com.tencent.mm.plugin.emojicapture.model.e.roB;
                                com.tencent.mm.plugin.emojicapture.model.e.cIY();
                            }
                            EGLContext eGLContext = cVar.rvV;
                            p.g(eGLContext, "eGLContext");
                            GL gl = eGLContext.getGL();
                            if (gl == null) {
                                t tVar = new t("null cannot be cast to non-null type javax.microedition.khronos.opengles.GL10");
                                AppMethodBeat.o(837);
                                throw tVar;
                            }
                            cVar.rvY = (GL10) gl;
                        }
                    }
                }
                cVar.rvZ = new d(cVar.rwe, cVar.rpM);
                d dVar = cVar.rvZ;
                if (dVar == null) {
                    p.btv("renderer");
                }
                if (!dVar.isInit) {
                    Log.i(dVar.TAG, "init: ");
                    b.a aVar2 = b.rvS;
                    com.tencent.mm.media.g.d eV = com.tencent.mm.media.g.c.eV(false);
                    dVar.rwj = new SurfaceTexture(eV.igv);
                    dVar.rwi = eV;
                    b.a aVar3 = b.rvS;
                    dVar.rwk = com.tencent.mm.media.g.c.eV(true);
                    b.a aVar4 = b.rvS;
                    dVar.ikf = b.a.aB("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        uniform mat4 uMatrix;\n        void main() {\n            gl_Position = uMatrix * a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform samplerExternalOES videoExternalTexture;\n        uniform sampler2D videoNormalTexture;\n        uniform sampler2D emojiTexture;\n        uniform vec2 size;\n        uniform float radius;\n        uniform int hasEmojiTexture;\n        uniform int useNormalVideoTexture;\n        uniform int enableAlpha;\n\n        vec4 blendTexture(vec4 source, vec4 blend) {\n            if (blend.a <= 0.0) {\n                return source;\n            }\n            float sourceAlpha = 1.0 - blend.a;\n            float alpha = max(source.a, blend.a);\n            float r = max(0.0, min(sourceAlpha * source.r + blend.r, 1.0));\n            float g = max(0.0, min(sourceAlpha * source.g + blend.g, 1.0));\n            float b = max(0.0, min(sourceAlpha * source.b + blend.b, 1.0));\n            vec4 result = vec4(r, g, b, alpha);\n            if (alpha != 1.0) {\n                r = r + (1.0 - alpha) * 0.95;\n                g = g + (1.0 - alpha) * 0.95;\n                b = b + (1.0 - alpha) * 0.95;\n                r = max(0.0, min(r, 1.0));\n                g = max(0.0, min(g, 1.0));\n                b = max(0.0, min(b, 1.0));\n                return vec4(r, g, b, 1.0);\n            } else {\n                return vec4(r, g, b, alpha);\n            }\n        }\n\n        void main () {\n            vec2 bottomLeftCenter = vec2(radius, radius);\n            vec2 bottomRightCenter = vec2(size.x - radius, radius);\n            vec2 topLeftCenter = vec2(radius, size.y - radius);\n            vec2 topRightCenter = vec2(size.x - radius, size.y - radius);\n            if ((gl_FragCoord.x < bottomLeftCenter.x && gl_FragCoord.y < bottomLeftCenter.y && distance(gl_FragCoord.xy, bottomLeftCenter) > radius) ||\n                    (gl_FragCoord.x > bottomRightCenter.x && gl_FragCoord.y < bottomRightCenter.y && distance(gl_FragCoord.xy, bottomRightCenter) > radius) ||\n                    (gl_FragCoord.x < topLeftCenter.x && gl_FragCoord.y > topLeftCenter.y && distance(gl_FragCoord.xy, topLeftCenter) > radius) ||\n                    (gl_FragCoord.x > topRightCenter.x && gl_FragCoord.y > topRightCenter.y && distance(gl_FragCoord.xy, topRightCenter) > radius))  {\n                gl_FragColor = vec4(0.0, 0.0, 0.0, 0.0);\n                return;\n            } else {\n                vec4 videoColor;\n                if (useNormalVideoTexture == 1) {\n                    videoColor = texture2D(videoNormalTexture, v_texCoord);\n                } else {\n                    videoColor = texture2D(videoExternalTexture, v_texCoord);\n                }\n                if (enableAlpha == 0) {\n                    if (videoColor.a < 0.3) {\n                        videoColor = vec4(0.0, 0.0, 0.0, 0.0);\n                    } else {\n                        videoColor.a = 1.0;\n                    }\n                } else {\n                    if (videoColor.a == 0.0) {\n                        videoColor = vec4(0.0, 0.0, 0.0, 0.0);\n                    }\n                }\n                if (hasEmojiTexture == 1) {\n                    gl_FragColor = blendTexture(videoColor, texture2D(emojiTexture, v_texCoord));\n                } else {\n                    gl_FragColor = videoColor;\n                }\n            }\n        }\n        ");
                    dVar.ikg = GLES20.glGetAttribLocation(dVar.ikf, "a_position");
                    dVar.ikh = GLES20.glGetAttribLocation(dVar.ikf, "a_texCoord");
                    dVar.ikj = GLES20.glGetUniformLocation(dVar.ikf, "videoExternalTexture");
                    dVar.ikk = GLES20.glGetUniformLocation(dVar.ikf, "videoNormalTexture");
                    dVar.ikl = GLES20.glGetUniformLocation(dVar.ikf, "emojiTexture");
                    dVar.rwl = GLES20.glGetUniformLocation(dVar.ikf, "size");
                    dVar.rwm = GLES20.glGetUniformLocation(dVar.ikf, "radius");
                    dVar.ikm = GLES20.glGetUniformLocation(dVar.ikf, "hasEmojiTexture");
                    dVar.iko = GLES20.glGetUniformLocation(dVar.ikf, "uMatrix");
                    dVar.ikn = GLES20.glGetUniformLocation(dVar.ikf, "useNormalVideoTexture");
                    dVar.rwn = GLES20.glGetUniformLocation(dVar.ikf, "enableAlpha");
                    b.a aVar5 = b.rvS;
                    dVar.rwo = b.a.aB("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        void main() {\n            gl_Position = a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform samplerExternalOES texture;\n\n        void main () {\n            gl_FragColor = texture2D(texture, v_texCoord);\n        }\n        ");
                    dVar.rwp = GLES20.glGetAttribLocation(dVar.rwo, "a_position");
                    dVar.rwq = GLES20.glGetAttribLocation(dVar.rwo, "a_texCoord");
                    dVar.rwr = GLES20.glGetUniformLocation(dVar.rwo, "texture");
                    dVar.hDU.put(b.ilm);
                    dVar.rww.put(b.iln);
                    b.a aVar6 = b.rvS;
                    dVar.rwt = b.a.cJU();
                    b.a aVar7 = b.rvS;
                    dVar.rwu = com.tencent.mm.media.g.c.eV(true);
                    b.a aVar8 = b.rvS;
                    dVar.rwv = com.tencent.mm.media.g.c.eV(true);
                    dVar.isInit = true;
                }
                d dVar2 = cVar.rvZ;
                if (dVar2 == null) {
                    p.btv("renderer");
                }
                dVar2.cJW().setOnFrameAvailableListener(new C0983c(cVar));
                d dVar3 = cVar.rvZ;
                if (dVar3 == null) {
                    p.btv("renderer");
                }
                cVar.rwa = new Surface(dVar3.cJW());
                AppMethodBeat.o(837);
            }
        });
        AppMethodBeat.o(845);
    }

    public static final /* synthetic */ d a(c cVar) {
        AppMethodBeat.i(846);
        d dVar = cVar.rvZ;
        if (dVar == null) {
            p.btv("renderer");
        }
        AppMethodBeat.o(846);
        return dVar;
    }

    public static final /* synthetic */ GL10 b(c cVar) {
        AppMethodBeat.i(847);
        GL10 gl10 = cVar.rvY;
        if (gl10 == null) {
            p.btv("gl");
        }
        AppMethodBeat.o(847);
        return gl10;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/graphics/SurfaceTexture;", "kotlin.jvm.PlatformType", "onFrameAvailable"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.b.c$c  reason: collision with other inner class name */
    static final class C0983c implements SurfaceTexture.OnFrameAvailableListener {
        final /* synthetic */ c rwf;

        C0983c(c cVar) {
            this.rwf = cVar;
        }

        public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
            AppMethodBeat.i(840);
            c cVar = this.rwf;
            Log.i(cVar.TAG, "onVideoSurfaceFrameAvailable");
            cVar.k(new d(cVar));
            AppMethodBeat.o(840);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class e implements Runnable {
        final /* synthetic */ kotlin.g.a.a ihE;

        e(kotlin.g.a.a aVar) {
            this.ihE = aVar;
        }

        public final void run() {
            AppMethodBeat.i(h.CTRL_INDEX);
            this.ihE.invoke();
            AppMethodBeat.o(h.CTRL_INDEX);
        }
    }

    public final void k(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(j.CTRL_INDEX);
        p.h(aVar, "callback");
        this.rwb.post(new e(aVar));
        AppMethodBeat.o(j.CTRL_INDEX);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class b implements Runnable {
        final /* synthetic */ c rwf;
        final /* synthetic */ boolean rwg;
        final /* synthetic */ kotlin.g.a.a rwh;

        public b(c cVar, boolean z, kotlin.g.a.a aVar) {
            this.rwf = cVar;
            this.rwg = z;
            this.rwh = aVar;
        }

        public final void run() {
            AppMethodBeat.i(839);
            c.a(this.rwf).onSurfaceCreated(c.b(this.rwf), this.rwf.rvX);
            c.a(this.rwf).onSurfaceChanged(c.b(this.rwf), this.rwf.width, this.rwf.height);
            d a2 = c.a(this.rwf);
            a2.rqp = this.rwg;
            try {
                a2.hiH = new com.tencent.mm.plugin.xlabeffect.b(0, 0, 0, false, false, 15);
                com.tencent.mm.plugin.xlabeffect.b bVar = a2.hiH;
                if (bVar != null) {
                    bVar.setSize(a2.rws, a2.rws);
                }
                com.tencent.mm.plugin.xlabeffect.b bVar2 = a2.hiH;
                if (bVar2 != null) {
                    bVar2.zG(a2.rqp);
                }
                com.tencent.mm.plugin.xlabeffect.b bVar3 = a2.hiH;
                if (bVar3 != null) {
                    bVar3.a(a2.rpM);
                }
            } catch (Exception e2) {
                com.tencent.mm.plugin.emojicapture.model.e eVar = com.tencent.mm.plugin.emojicapture.model.e.roB;
                com.tencent.mm.plugin.emojicapture.model.e.cJf();
            }
            kotlin.g.a.a aVar = this.rwh;
            if (aVar != null) {
                aVar.invoke();
                AppMethodBeat.o(839);
                return;
            }
            AppMethodBeat.o(839);
        }
    }

    public final Surface cJV() {
        AppMethodBeat.i(844);
        Surface surface = this.rwa;
        if (surface == null) {
            p.btv("videoDecodeSurface");
        }
        AppMethodBeat.o(844);
        return surface;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ c rwf;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(c cVar) {
            super(0);
            this.rwf = cVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            AppMethodBeat.i(g.CTRL_INDEX);
            kotlin.g.a.a<x> aVar = this.rwf.rwd;
            if (aVar != null) {
                aVar.invoke();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(g.CTRL_INDEX);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class a extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ c rwf;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(c cVar) {
            super(0);
            this.rwf = cVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(838);
            d a2 = c.a(this.rwf);
            Log.i(a2.TAG, "release: ");
            com.tencent.mm.media.g.d dVar = a2.rwi;
            if (dVar != null) {
                dVar.close();
            }
            com.tencent.mm.media.g.d dVar2 = a2.rwk;
            if (dVar2 != null) {
                dVar2.close();
            }
            com.tencent.mm.media.g.d dVar3 = a2.rwu;
            if (dVar3 != null) {
                dVar3.close();
            }
            com.tencent.mm.media.g.d dVar4 = a2.rwv;
            if (dVar4 != null) {
                dVar4.close();
            }
            GLES20.glDeleteProgram(a2.ikf);
            GLES20.glDeleteProgram(a2.rwo);
            GLES20.glDeleteFramebuffers(1, new int[]{a2.rwt}, 0);
            try {
                com.tencent.mm.plugin.xlabeffect.b bVar = a2.hiH;
                if (bVar != null) {
                    bVar.destroy();
                }
            } catch (Exception e2) {
                com.tencent.mm.plugin.emojicapture.model.e eVar = com.tencent.mm.plugin.emojicapture.model.e.roB;
                com.tencent.mm.plugin.emojicapture.model.e.cJg();
            }
            EGL10 egl10 = this.rwf.rvT;
            EGLDisplay eGLDisplay = this.rwf.rvU;
            EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
            egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            this.rwf.rvT.eglDestroyContext(this.rwf.rvU, this.rwf.rvV);
            this.rwf.rvT.eglDestroySurface(this.rwf.rvU, this.rwf.rvW);
            this.rwf.rvT.eglTerminate(this.rwf.rvU);
            this.rwf.rvV = EGL10.EGL_NO_CONTEXT;
            this.rwf.rvW = EGL10.EGL_NO_SURFACE;
            this.rwf.rwc.quit();
            x xVar = x.SXb;
            AppMethodBeat.o(838);
            return xVar;
        }
    }
}
