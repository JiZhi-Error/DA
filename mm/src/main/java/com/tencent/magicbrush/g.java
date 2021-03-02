package com.tencent.magicbrush;

import android.content.Context;
import android.content.res.AssetManager;
import com.facebook.internal.NativeProtocol;
import com.github.henryye.nativeiv.BaseImageDecodeService;
import com.github.henryye.nativeiv.a.c;
import com.github.henryye.nativeiv.api.IImageDecodeService;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.handler.glfont.IMBFontHandler;
import com.tencent.magicbrush.ui.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.g.b.v;
import kotlin.l;
import kotlin.l.h;
import kotlin.l.k;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001:\u0004¶\u0001·\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010°\u0001\u001a\u0005\u0018\u00010±\u0001J$\u0010u\u001a\u00030²\u00012\u001b\u0010³\u0001\u001a\u0016\u0012\u0004\u0012\u00020v\u0012\u0005\u0012\u00030²\u00010´\u0001¢\u0006\u0003\bµ\u0001R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR+\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00048F@FX\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR+\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u000f8F@FX\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R/\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\t\u001a\u0004\u0018\u00010\u00168F@FX\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u000e\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR+\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\t\u001a\u00020\u001d8F@FX\u0002¢\u0006\u0012\n\u0004\b#\u0010\u000e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R+\u0010$\u001a\u00020\u001d2\u0006\u0010\t\u001a\u00020\u001d8F@FX\u0002¢\u0006\u0012\n\u0004\b'\u0010\u000e\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R+\u0010(\u001a\u00020\u001d2\u0006\u0010\t\u001a\u00020\u001d8F@FX\u0002¢\u0006\u0012\n\u0004\b+\u0010\u000e\u001a\u0004\b)\u0010 \"\u0004\b*\u0010\"R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R+\u00103\u001a\u0002022\u0006\u0010\t\u001a\u0002028F@FX\u0002¢\u0006\u0012\n\u0004\b8\u0010\u000e\u001a\u0004\b4\u00105\"\u0004\b6\u00107R+\u00109\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00048F@FX\u0002¢\u0006\u0012\n\u0004\b<\u0010\u000e\u001a\u0004\b:\u0010\u0006\"\u0004\b;\u0010\bR+\u0010=\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00048F@FX\u0002¢\u0006\u0012\n\u0004\b@\u0010\u000e\u001a\u0004\b>\u0010\u0006\"\u0004\b?\u0010\bR+\u0010A\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00048F@FX\u0002¢\u0006\u0012\n\u0004\bD\u0010\u000e\u001a\u0004\bB\u0010\u0006\"\u0004\bC\u0010\bR+\u0010E\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00048F@FX\u0002¢\u0006\u0012\n\u0004\bH\u0010\u000e\u001a\u0004\bF\u0010\u0006\"\u0004\bG\u0010\bR+\u0010I\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00048F@FX\u0002¢\u0006\u0012\n\u0004\bL\u0010\u000e\u001a\u0004\bJ\u0010\u0006\"\u0004\bK\u0010\bR+\u0010M\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00048F@FX\u0002¢\u0006\u0012\n\u0004\bP\u0010\u000e\u001a\u0004\bN\u0010\u0006\"\u0004\bO\u0010\bR+\u0010Q\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00048F@FX\u0002¢\u0006\u0012\n\u0004\bT\u0010\u000e\u001a\u0004\bR\u0010\u0006\"\u0004\bS\u0010\bR\u001a\u0010U\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\u0006\"\u0004\bW\u0010\bR+\u0010X\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00048F@FX\u0002¢\u0006\u0012\n\u0004\b[\u0010\u000e\u001a\u0004\bY\u0010\u0006\"\u0004\bZ\u0010\bR+\u0010\\\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00048F@FX\u0002¢\u0006\u0012\n\u0004\b_\u0010\u000e\u001a\u0004\b]\u0010\u0006\"\u0004\b^\u0010\bR/\u0010a\u001a\u0004\u0018\u00010`2\b\u0010\t\u001a\u0004\u0018\u00010`8F@FX\u0002¢\u0006\u0012\n\u0004\bf\u0010\u000e\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\u001c\u0010g\u001a\u0004\u0018\u00010hX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR+\u0010m\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00048F@FX\u0002¢\u0006\u0012\n\u0004\bp\u0010\u000e\u001a\u0004\bn\u0010\u0006\"\u0004\bo\u0010\bR+\u0010q\u001a\u0002022\u0006\u0010\t\u001a\u0002028F@FX\u0002¢\u0006\u0012\n\u0004\bt\u0010\u000e\u001a\u0004\br\u00105\"\u0004\bs\u00107R\u0013\u0010u\u001a\u00020v8G¢\u0006\b\n\u0000\u001a\u0004\bw\u0010xR+\u0010y\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00048F@FX\u0002¢\u0006\u0012\n\u0004\b{\u0010\u000e\u001a\u0004\by\u0010\u0006\"\u0004\bz\u0010\bR\u001e\u0010|\u001a\u0004\u0018\u00010}X\u000e¢\u0006\u0010\n\u0000\u001a\u0004\b~\u0010\"\u0006\b\u0001\u0010\u0001R\u0018\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001R3\u0010\u0001\u001a\u00030\u00012\u0007\u0010\t\u001a\u00030\u00018F@FX\u0002¢\u0006\u0017\n\u0005\b\u0001\u0010\u000e\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R/\u0010\u0001\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00048F@FX\u0002¢\u0006\u0015\n\u0005\b\u0001\u0010\u000e\u001a\u0005\b\u0001\u0010\u0006\"\u0005\b\u0001\u0010\bR3\u0010\u0001\u001a\u00030\u00012\u0007\u0010\t\u001a\u00030\u00018F@FX\u0002¢\u0006\u0017\n\u0005\b\u0001\u0010\u000e\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R/\u0010\u0001\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00048F@FX\u0002¢\u0006\u0015\n\u0005\b\u0001\u0010\u000e\u001a\u0005\b\u0001\u0010\u0006\"\u0005\b\u0001\u0010\bR/\u0010\u0001\u001a\u00020\u001d2\u0006\u0010\t\u001a\u00020\u001d8F@FX\u0002¢\u0006\u0015\n\u0005\b\u0001\u0010\u000e\u001a\u0005\b\u0001\u0010 \"\u0005\b\u0001\u0010\"R/\u0010\u0001\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00048F@FX\u0002¢\u0006\u0015\n\u0005\b \u0001\u0010\u000e\u001a\u0005\b\u0001\u0010\u0006\"\u0005\b\u0001\u0010\bR/\u0010¡\u0001\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00048F@FX\u0002¢\u0006\u0015\n\u0005\b¤\u0001\u0010\u000e\u001a\u0005\b¢\u0001\u0010\u0006\"\u0005\b£\u0001\u0010\bR/\u0010¥\u0001\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00048F@FX\u0002¢\u0006\u0015\n\u0005\b¨\u0001\u0010\u000e\u001a\u0005\b¦\u0001\u0010\u0006\"\u0005\b§\u0001\u0010\bR)\u0010©\u0001\u001a\f\u0012\u0005\u0012\u00030«\u0001\u0018\u00010ª\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¬\u0001\u0010­\u0001\"\u0006\b®\u0001\u0010¯\u0001¨\u0006¸\u0001"}, hxF = {"Lcom/tencent/magicbrush/MagicBrushConfig;", "", "()V", "abortIfBuildingError", "", "getAbortIfBuildingError", "()Z", "setAbortIfBuildingError", "(Z)V", "<set-?>", "adjustThreadPriority", "getAdjustThreadPriority", "setAdjustThreadPriority", "adjustThreadPriority$delegate", "Lcom/tencent/magicbrush/MagicBrushConfig$A;", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "animationFrameHandlerStrategy", "getAnimationFrameHandlerStrategy", "()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "setAnimationFrameHandlerStrategy", "(Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;)V", "animationFrameHandlerStrategy$delegate", "Landroid/content/res/AssetManager;", "assetManager", "getAssetManager", "()Landroid/content/res/AssetManager;", "setAssetManager", "(Landroid/content/res/AssetManager;)V", "assetManager$delegate", "", "canvasHeight", "getCanvasHeight", "()I", "setCanvasHeight", "(I)V", "canvasHeight$delegate", "canvasWidth", "getCanvasWidth", "setCanvasWidth", "canvasWidth$delegate", "cmdPoolType", "getCmdPoolType", "setCmdPoolType", "cmdPoolType$delegate", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "", "devicePixelRatio", "getDevicePixelRatio", "()F", "setDevicePixelRatio", "(F)V", "devicePixelRatio$delegate", "enable2d", "getEnable2d", "setEnable2d", "enable2d$delegate", "enableAntialias", "getEnableAntialias", "setEnableAntialias", "enableAntialias$delegate", "enableCommandBuffer", "getEnableCommandBuffer", "setEnableCommandBuffer", "enableCommandBuffer$delegate", "enableFontBatch", "getEnableFontBatch", "setEnableFontBatch", "enableFontBatch$delegate", "enableGfx", "getEnableGfx", "setEnableGfx", "enableGfx$delegate", "enableOpenGL3", "getEnableOpenGL3", "setEnableOpenGL3", "enableOpenGL3$delegate", "enableRequestAnimationFrame", "getEnableRequestAnimationFrame", "setEnableRequestAnimationFrame", "enableRequestAnimationFrame$delegate", "enableVerboseInBuilding", "getEnableVerboseInBuilding", "setEnableVerboseInBuilding", "enableWindowAttributesAlpha", "getEnableWindowAttributesAlpha", "setEnableWindowAttributesAlpha", "enableWindowAttributesAlpha$delegate", "enableWxBindCanvasTexture", "getEnableWxBindCanvasTexture", "setEnableWxBindCanvasTexture", "enableWxBindCanvasTexture$delegate", "Lcom/tencent/magicbrush/handler/fs/IMBFileSystem;", "fileSystem", "getFileSystem", "()Lcom/tencent/magicbrush/handler/fs/IMBFileSystem;", "setFileSystem", "(Lcom/tencent/magicbrush/handler/fs/IMBFileSystem;)V", "fileSystem$delegate", "fontHandler", "Lcom/tencent/magicbrush/handler/glfont/IMBFontHandler;", "getFontHandler", "()Lcom/tencent/magicbrush/handler/glfont/IMBFontHandler;", "setFontHandler", "(Lcom/tencent/magicbrush/handler/glfont/IMBFontHandler;)V", "forceRunV8MicroTasks", "getForceRunV8MicroTasks", "setForceRunV8MicroTasks", "forceRunV8MicroTasks$delegate", "gcFactor", "getGcFactor", "setGcFactor", "gcFactor$delegate", "imageHandler", "Lcom/tencent/magicbrush/MagicBrushConfig$ImageHandlerConfig;", "getImageHandlerConfig", "()Lcom/tencent/magicbrush/MagicBrushConfig$ImageHandlerConfig;", "isGame", "setGame", "isGame$delegate", "jsThreadHandler", "Lcom/tencent/magicbrush/handler/IJsThreadHandler;", "getJsThreadHandler", "()Lcom/tencent/magicbrush/handler/IJsThreadHandler;", "setJsThreadHandler", "(Lcom/tencent/magicbrush/handler/IJsThreadHandler;)V", NativeProtocol.WEB_DIALOG_PARAMS, "Lcom/tencent/magicbrush/MBRuntime$MBParams;", "getParams$lib_magicbrush_nano_release", "()Lcom/tencent/magicbrush/MBRuntime$MBParams;", "", "renderThreadName", "getRenderThreadName", "()Ljava/lang/String;", "setRenderThreadName", "(Ljava/lang/String;)V", "renderThreadName$delegate", "revertCpuOptimizerTest", "getRevertCpuOptimizerTest", "setRevertCpuOptimizerTest", "revertCpuOptimizerTest$delegate", "sdcardPath", "getSdcardPath", "setSdcardPath", "sdcardPath$delegate", "supportClientVertexBuffer", "getSupportClientVertexBuffer", "setSupportClientVertexBuffer", "supportClientVertexBuffer$delegate", "supportGfxImageShareTexture", "getSupportGfxImageShareTexture", "setSupportGfxImageShareTexture", "supportGfxImageShareTexture$delegate", "supportHardDecode", "getSupportHardDecode", "setSupportHardDecode", "supportHardDecode$delegate", "supportHardEncode", "getSupportHardEncode", "setSupportHardEncode", "supportHardEncode$delegate", "syncSurfaceDestroy", "getSyncSurfaceDestroy", "setSyncSurfaceDestroy", "syncSurfaceDestroy$delegate", "v8RawPointer", "Lkotlin/Function0;", "Lcom/tencent/magicbrush/V8RawPointer;", "getV8RawPointer", "()Lkotlin/jvm/functions/Function0;", "setV8RawPointer", "(Lkotlin/jvm/functions/Function0;)V", "getImageHandler", "Lcom/github/henryye/nativeiv/BaseImageDecodeService;", "", "dls", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "A", "ImageHandlerConfig", "lib-magicbrush-nano_release"})
public class g {
    public static final /* synthetic */ k[] cLI = {aa.a(new v(aa.bp(g.class), "devicePixelRatio", "getDevicePixelRatio()F")), aa.a(new v(aa.bp(g.class), "canvasWidth", "getCanvasWidth()I")), aa.a(new v(aa.bp(g.class), "canvasHeight", "getCanvasHeight()I")), aa.a(new v(aa.bp(g.class), "fileSystem", "getFileSystem()Lcom/tencent/magicbrush/handler/fs/IMBFileSystem;")), aa.a(new v(aa.bp(g.class), "assetManager", "getAssetManager()Landroid/content/res/AssetManager;")), aa.a(new v(aa.bp(g.class), "animationFrameHandlerStrategy", "getAnimationFrameHandlerStrategy()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;")), aa.a(new v(aa.bp(g.class), "enableAntialias", "getEnableAntialias()Z")), aa.a(new v(aa.bp(g.class), "enableOpenGL3", "getEnableOpenGL3()Z")), aa.a(new v(aa.bp(g.class), "enableCommandBuffer", "getEnableCommandBuffer()Z")), aa.a(new v(aa.bp(g.class), "enableGfx", "getEnableGfx()Z")), aa.a(new v(aa.bp(g.class), "gcFactor", "getGcFactor()F")), aa.a(new v(aa.bp(g.class), "enableRequestAnimationFrame", "getEnableRequestAnimationFrame()Z")), aa.a(new v(aa.bp(g.class), "enableWxBindCanvasTexture", "getEnableWxBindCanvasTexture()Z")), aa.a(new v(aa.bp(g.class), "enable2d", "getEnable2d()Z")), aa.a(new v(aa.bp(g.class), "enableWindowAttributesAlpha", "getEnableWindowAttributesAlpha()Z")), aa.a(new v(aa.bp(g.class), "adjustThreadPriority", "getAdjustThreadPriority()Z")), aa.a(new v(aa.bp(g.class), "cmdPoolType", "getCmdPoolType()I")), aa.a(new v(aa.bp(g.class), "revertCpuOptimizerTest", "getRevertCpuOptimizerTest()Z")), aa.a(new v(aa.bp(g.class), "isGame", "isGame()Z")), aa.a(new v(aa.bp(g.class), "enableFontBatch", "getEnableFontBatch()Z")), aa.a(new v(aa.bp(g.class), "sdcardPath", "getSdcardPath()Ljava/lang/String;")), aa.a(new v(aa.bp(g.class), "syncSurfaceDestroy", "getSyncSurfaceDestroy()Z")), aa.a(new v(aa.bp(g.class), "supportGfxImageShareTexture", "getSupportGfxImageShareTexture()I")), aa.a(new v(aa.bp(g.class), "supportClientVertexBuffer", "getSupportClientVertexBuffer()Z")), aa.a(new v(aa.bp(g.class), "supportHardEncode", "getSupportHardEncode()Z")), aa.a(new v(aa.bp(g.class), "supportHardDecode", "getSupportHardDecode()Z")), aa.a(new v(aa.bp(g.class), "forceRunV8MicroTasks", "getForceRunV8MicroTasks()Z")), aa.a(new v(aa.bp(g.class), "renderThreadName", "getRenderThreadName()Ljava/lang/String;"))};
    public com.tencent.magicbrush.handler.a cLJ;
    public kotlin.g.a.a<aj> cLK;
    private final a cLL = new a(this, n.cMy);
    public final a cLM = new a(this, l.cMy);
    public final a cLN = new a(this, k.cMy);
    public final a cLO = new a(this, x.cMy);
    public final a cLP = new a(this, j.cMy);
    public final b cLQ = new b();
    public IMBFontHandler cLR;
    private final a cLS = new a(this, i.cMy);
    public final a cLT = new a(this, p.cMy);
    public final a cLU = new a(this, t.cMy);
    private final a cLV = new a(this, q.cMy);
    public final a cLW = new a(this, s.cMy);
    private final a cLX = new a(this, z.cMy);
    private final a cLY = new a(this, u.cMy);
    private final a cLZ = new a(this, w.cMy);
    private final a cMa = new a(this, o.cMy);
    private final a cMb = new a(this, v.cMy);
    public final a cMc = new a(this, h.cMy);
    public boolean cMd = true;
    public boolean cMe = true;
    public final a cMf = new a(this, m.cMy);
    public final a cMg = new a(this, ac.cMy);
    public final a cMh = new a(this, aa.cMy);
    private final a cMi = new a(this, r.cMy);
    private final a cMj = new a(this, ad.cMy);
    private final a cMk = new a(this, ai.cMy);
    private final a cMl = new a(this, af.cMy);
    private final a cMm = new a(this, ae.cMy);
    private final a cMn = new a(this, ah.cMy);
    private final a cMo = new a(this, ag.cMy);
    private final a cMp = new a(this, y.cMy);
    public final a cMq = new a(this, ab.cMy);
    final MBRuntime.MBParams cMr = new MBRuntime.MBParams();
    public Context context;

    static {
        AppMethodBeat.i(140174);
        AppMethodBeat.o(140174);
    }

    public final int Rn() {
        AppMethodBeat.i(140177);
        int intValue = ((Number) this.cLM.a(cLI[1])).intValue();
        AppMethodBeat.o(140177);
        return intValue;
    }

    public final int Ro() {
        AppMethodBeat.i(140178);
        int intValue = ((Number) this.cLN.a(cLI[2])).intValue();
        AppMethodBeat.o(140178);
        return intValue;
    }

    public final AssetManager Rp() {
        AppMethodBeat.i(140179);
        AssetManager assetManager = (AssetManager) this.cLP.a(cLI[4]);
        AppMethodBeat.o(140179);
        return assetManager;
    }

    public final a.b Rq() {
        AppMethodBeat.i(140180);
        a.b bVar = (a.b) this.cLS.a(cLI[5]);
        AppMethodBeat.o(140180);
        return bVar;
    }

    public final float Rr() {
        AppMethodBeat.i(140182);
        float floatValue = ((Number) this.cLX.a(cLI[10])).floatValue();
        AppMethodBeat.o(140182);
        return floatValue;
    }

    public final void ae(float f2) {
        AppMethodBeat.i(140176);
        this.cLL.a(cLI[0], Float.valueOf(f2));
        AppMethodBeat.o(140176);
    }

    public final void af(float f2) {
        AppMethodBeat.i(140183);
        this.cLX.a(cLI[10], Float.valueOf(f2));
        AppMethodBeat.o(140183);
    }

    public final void b(a.b bVar) {
        AppMethodBeat.i(140181);
        p.h(bVar, "<set-?>");
        this.cLS.a(cLI[5], bVar);
        AppMethodBeat.o(140181);
    }

    public final void co(boolean z) {
        AppMethodBeat.i(206854);
        this.cLV.a(cLI[8], Boolean.valueOf(z));
        AppMethodBeat.o(206854);
    }

    public final void cp(boolean z) {
        AppMethodBeat.i(140184);
        this.cLZ.a(cLI[12], Boolean.valueOf(z));
        AppMethodBeat.o(140184);
    }

    public final void cq(boolean z) {
        AppMethodBeat.i(206855);
        this.cMa.a(cLI[13], Boolean.valueOf(z));
        AppMethodBeat.o(206855);
    }

    public final void cr(boolean z) {
        AppMethodBeat.i(140185);
        this.cMb.a(cLI[14], Boolean.valueOf(z));
        AppMethodBeat.o(140185);
    }

    public final void cs(boolean z) {
        AppMethodBeat.i(206856);
        this.cMi.a(cLI[19], Boolean.valueOf(z));
        AppMethodBeat.o(206856);
    }

    public final void ct(boolean z) {
        AppMethodBeat.i(206858);
        this.cMk.a(cLI[21], Boolean.valueOf(z));
        AppMethodBeat.o(206858);
    }

    public final void cu(boolean z) {
        AppMethodBeat.i(206859);
        this.cMm.a(cLI[23], Boolean.valueOf(z));
        AppMethodBeat.o(206859);
    }

    public final void cv(boolean z) {
        AppMethodBeat.i(206860);
        this.cMn.a(cLI[24], Boolean.valueOf(z));
        AppMethodBeat.o(206860);
    }

    public final void cw(boolean z) {
        AppMethodBeat.i(206861);
        this.cMo.a(cLI[25], Boolean.valueOf(z));
        AppMethodBeat.o(206861);
    }

    public final void cx(boolean z) {
        AppMethodBeat.i(206862);
        this.cMp.a(cLI[26], Boolean.valueOf(z));
        AppMethodBeat.o(206862);
    }

    public final void dY(String str) {
        AppMethodBeat.i(206857);
        p.h(str, "<set-?>");
        this.cMj.a(cLI[20], str);
        AppMethodBeat.o(206857);
    }

    public final float getDevicePixelRatio() {
        AppMethodBeat.i(140175);
        float floatValue = ((Number) this.cLL.a(cLI[0])).floatValue();
        AppMethodBeat.o(140175);
        return floatValue;
    }

    public g() {
        AppMethodBeat.i(140186);
        AppMethodBeat.o(140186);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006\""}, hxF = {"Lcom/tencent/magicbrush/MagicBrushConfig$ImageHandlerConfig;", "", "()V", "decodeSlaveForDefault", "Lcom/github/henryye/nativeiv/api/IImageDecodeService$BitmapDecodeSlave;", "getDecodeSlaveForDefault", "()Lcom/github/henryye/nativeiv/api/IImageDecodeService$BitmapDecodeSlave;", "setDecodeSlaveForDefault", "(Lcom/github/henryye/nativeiv/api/IImageDecodeService$BitmapDecodeSlave;)V", "enableDefaultImageHandler", "", "getEnableDefaultImageHandler", "()Z", "setEnableDefaultImageHandler", "(Z)V", "imageDecoderForDefault", "", "Lcom/github/henryye/nativeiv/stream/IImageStreamFetcher;", "getImageDecoderForDefault", "()Ljava/util/List;", "setImageDecoderForDefault", "(Ljava/util/List;)V", "imageHandler", "Lcom/github/henryye/nativeiv/BaseImageDecodeService;", "getImageHandler", "()Lcom/github/henryye/nativeiv/BaseImageDecodeService;", "setImageHandler", "(Lcom/github/henryye/nativeiv/BaseImageDecodeService;)V", "reporterForDefault", "Lcom/github/henryye/nativeiv/delegate/ReportDelegate$IKvReport;", "getReporterForDefault", "()Lcom/github/henryye/nativeiv/delegate/ReportDelegate$IKvReport;", "setReporterForDefault", "(Lcom/github/henryye/nativeiv/delegate/ReportDelegate$IKvReport;)V", "lib-magicbrush-nano_release"})
    public static final class b {
        public boolean cMt = true;
        public List<com.github.henryye.nativeiv.b.b> cMu = new ArrayList();
        public c.b cMv;
        public IImageDecodeService.a cMw;
        public BaseImageDecodeService cMx;

        public b() {
            AppMethodBeat.i(140099);
            AppMethodBeat.o(140099);
        }
    }

    public final void a(kotlin.g.a.b<? super b, x> bVar) {
        AppMethodBeat.i(206853);
        p.h(bVar, "dls");
        bVar.invoke(this.cLQ);
        AppMethodBeat.o(206853);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00010\u0002B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/magicbrush/MagicBrushConfig$A;", "T", "Lcom/tencent/magicbrush/utils/Alias;", "Lcom/tencent/magicbrush/MBRuntime$MBParams;", "k", "Lkotlin/reflect/KMutableProperty1;", "(Lcom/tencent/magicbrush/MagicBrushConfig;Lkotlin/reflect/KMutableProperty1;)V", "lib-magicbrush-nano_release"})
    public final class a<T> extends com.tencent.magicbrush.utils.a<MBRuntime.MBParams, T> {
        final /* synthetic */ g cMs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(final g gVar, h<MBRuntime.MBParams, T> hVar) {
            super(new kotlin.g.a.a<MBRuntime.MBParams>() {
                /* class com.tencent.magicbrush.g.a.AnonymousClass1 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* bridge */ /* synthetic */ MBRuntime.MBParams invoke() {
                    return gVar.cMr;
                }
            }, hVar, (byte) 0);
            p.h(hVar, "k");
            this.cMs = gVar;
            AppMethodBeat.i(140098);
            AppMethodBeat.o(140098);
        }
    }
}
