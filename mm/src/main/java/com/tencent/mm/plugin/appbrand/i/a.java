package com.tencent.mm.plugin.appbrand.i;

import android.graphics.SurfaceTexture;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.skia_canvas.external_texture.ISkiaCanvasExternalTextureHandler;
import com.tencent.xweb.skia_canvas.external_texture.SkiaCanvasExternalTexturePlugin;
import com.tencent.xweb.skia_canvas.external_texture.SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class a extends SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate {
    private static a lqm;
    private Map<Integer, c> lqn = new ConcurrentHashMap();

    private a() {
        AppMethodBeat.i(139394);
        AppMethodBeat.o(139394);
    }

    public static a bCz() {
        AppMethodBeat.i(139395);
        if (lqm == null) {
            synchronized (a.class) {
                try {
                    if (lqm == null) {
                        lqm = new a();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(139395);
                    throw th;
                }
            }
        }
        a aVar = lqm;
        AppMethodBeat.o(139395);
        return aVar;
    }

    public final void a(int i2, c cVar, SurfaceTexture surfaceTexture, int i3, int i4, String str) {
        AppMethodBeat.i(177195);
        if (!(surfaceTexture == null || (i3 == 0 && i4 == 0))) {
            Log.i("MicroMsg.AppBrand.VideoCanvas.VideoCanvasExternalTexturePlugin", "registerMediaPlayer, id:%s, width:%s, height:%s, surface:%s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(surfaceTexture.hashCode()));
            this.lqn.put(Integer.valueOf(i2), cVar);
            registerInstance(i2, str, i3, i4, surfaceTexture);
        }
        AppMethodBeat.o(177195);
    }

    @Override // com.tencent.xweb.skia_canvas.external_texture.SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate
    public void replaceDisplaySurface(int i2, String str, SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(177196);
        c cVar = this.lqn.get(Integer.valueOf(i2));
        if (cVar == null || surfaceTexture == null) {
            Log.w("MicroMsg.AppBrand.VideoCanvas.VideoCanvasExternalTexturePlugin", "replaceDisplaySurface, video plugin handler or surface texture is null");
            AppMethodBeat.o(177196);
            return;
        }
        Log.w("MicroMsg.AppBrand.VideoCanvas.VideoCanvasExternalTexturePlugin", "replaceDisplaySurface, surface:%s", Integer.valueOf(surfaceTexture.hashCode()));
        cVar.k(
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0032: INVOKE  
              (r0v2 'cVar' com.tencent.luggage.xweb_ext.extendplugin.component.video.c)
              (wrap: com.tencent.luggage.xweb_ext.extendplugin.component.video.c$12 : 0x002f: CONSTRUCTOR  (r1v3 com.tencent.luggage.xweb_ext.extendplugin.component.video.c$12) = 
              (r0v2 'cVar' com.tencent.luggage.xweb_ext.extendplugin.component.video.c)
              (r10v0 'surfaceTexture' android.graphics.SurfaceTexture)
             call: com.tencent.luggage.xweb_ext.extendplugin.component.video.c.12.<init>(com.tencent.luggage.xweb_ext.extendplugin.component.video.c, android.graphics.SurfaceTexture):void type: CONSTRUCTOR)
             type: VIRTUAL call: com.tencent.luggage.xweb_ext.extendplugin.component.video.c.k(java.lang.Runnable):boolean in method: com.tencent.mm.plugin.appbrand.i.a.replaceDisplaySurface(int, java.lang.String, android.graphics.SurfaceTexture):void, file: classes7.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x002f: CONSTRUCTOR  (r1v3 com.tencent.luggage.xweb_ext.extendplugin.component.video.c$12) = 
              (r0v2 'cVar' com.tencent.luggage.xweb_ext.extendplugin.component.video.c)
              (r10v0 'surfaceTexture' android.graphics.SurfaceTexture)
             call: com.tencent.luggage.xweb_ext.extendplugin.component.video.c.12.<init>(com.tencent.luggage.xweb_ext.extendplugin.component.video.c, android.graphics.SurfaceTexture):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.appbrand.i.a.replaceDisplaySurface(int, java.lang.String, android.graphics.SurfaceTexture):void, file: classes7.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 18 more
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.luggage.xweb_ext.extendplugin.component.video.c, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 24 more
            */
        /*
            this = this;
            r6 = 177196(0x2b42c, float:2.48304E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
            java.util.Map<java.lang.Integer, com.tencent.luggage.xweb_ext.extendplugin.component.video.c> r0 = r7.lqn
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)
            java.lang.Object r0 = r0.get(r1)
            com.tencent.luggage.xweb_ext.extendplugin.component.video.c r0 = (com.tencent.luggage.xweb_ext.extendplugin.component.video.c) r0
            if (r0 == 0) goto L_0x0039
            if (r10 == 0) goto L_0x0039
            java.lang.String r1 = "MicroMsg.AppBrand.VideoCanvas.VideoCanvasExternalTexturePlugin"
            java.lang.String r2 = "replaceDisplaySurface, surface:%s"
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r4 = 0
            int r5 = r10.hashCode()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r3[r4] = r5
            com.tencent.mm.sdk.platformtools.Log.w(r1, r2, r3)
            com.tencent.luggage.xweb_ext.extendplugin.component.video.c$12 r1 = new com.tencent.luggage.xweb_ext.extendplugin.component.video.c$12
            r1.<init>(r10)
            r0.k(r1)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
        L_0x0038:
            return
        L_0x0039:
            java.lang.String r0 = "MicroMsg.AppBrand.VideoCanvas.VideoCanvasExternalTexturePlugin"
            java.lang.String r1 = "replaceDisplaySurface, video plugin handler or surface texture is null"
            com.tencent.mm.sdk.platformtools.Log.w(r0, r1)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
            goto L_0x0038
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.i.a.replaceDisplaySurface(int, java.lang.String, android.graphics.SurfaceTexture):void");
    }

    @Override // com.tencent.xweb.skia_canvas.external_texture.SkiaCanvasExternalTexturePlugin
    public boolean supportType(String str) {
        AppMethodBeat.i(139398);
        if (str.equals("video")) {
            AppMethodBeat.o(139398);
            return true;
        }
        AppMethodBeat.o(139398);
        return false;
    }

    @Override // com.tencent.xweb.skia_canvas.external_texture.SkiaCanvasExternalTexturePlugin, com.tencent.xweb.skia_canvas.external_texture.SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate
    public SkiaCanvasExternalTexturePlugin.PluginLoadResult onPluginInstanceLoad(ISkiaCanvasExternalTextureHandler iSkiaCanvasExternalTextureHandler, String str, int i2, String str2) {
        AppMethodBeat.i(177197);
        Log.i("MicroMsg.AppBrand.VideoCanvas.VideoCanvasExternalTexturePlugin", "onPluginInstanceLoad, type:%s, id:%s appTag:%s", str, Integer.valueOf(i2), str2);
        SkiaCanvasExternalTexturePlugin.PluginLoadResult onPluginInstanceLoad = super.onPluginInstanceLoad(iSkiaCanvasExternalTextureHandler, str, i2, str2);
        AppMethodBeat.o(177197);
        return onPluginInstanceLoad;
    }

    @Override // com.tencent.xweb.skia_canvas.external_texture.SkiaCanvasExternalTexturePlugin, com.tencent.xweb.skia_canvas.external_texture.SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate
    public void onPluginInstanceDestroy(ISkiaCanvasExternalTextureHandler iSkiaCanvasExternalTextureHandler, int i2, String str) {
        AppMethodBeat.i(177198);
        Log.i("MicroMsg.AppBrand.VideoCanvas.VideoCanvasExternalTexturePlugin", "onPluginInstanceDestroy, id:%s appTag:%s", Integer.valueOf(i2), str);
        super.onPluginInstanceDestroy(iSkiaCanvasExternalTextureHandler, i2, str);
        AppMethodBeat.o(177198);
    }
}
