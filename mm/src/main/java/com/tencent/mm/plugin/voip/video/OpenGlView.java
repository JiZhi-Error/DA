package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.video.GLTextureView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import java.lang.ref.WeakReference;

public class OpenGlView extends GLTextureView {
    public static String TAG = "OpenGlView";
    public boolean HiX;
    public boolean HiY;
    public int HiZ;
    public int Hja;
    public int Hjb;
    public boolean Hjc;
    WeakReference<OpenGlRender> Hjd;
    public boolean onr;

    public void jG(int i2, int i3) {
        RelativeLayout.LayoutParams layoutParams;
        AppMethodBeat.i(115669);
        this.Hja = i2;
        this.Hjb = i3;
        if (ao.gJI()) {
            int i4 = (i3 * 9) / 16;
            layoutParams = new RelativeLayout.LayoutParams(i4, i3);
            layoutParams.addRule(13);
            this.Hja = i4;
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        setLayoutParams(layoutParams);
        AppMethodBeat.o(115669);
    }

    public OpenGlView(Context context) {
        super(context);
        AppMethodBeat.i(235832);
        this.HiX = false;
        this.HiY = true;
        this.onr = false;
        this.HiZ = 1;
        this.Hja = 0;
        this.Hjb = 0;
        this.Hjc = false;
        this.HiZ = OpenGlRender.getGLVersion();
        fKU();
        AppMethodBeat.o(235832);
    }

    public OpenGlView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(115670);
        this.HiX = false;
        this.HiY = true;
        this.onr = false;
        this.HiZ = 1;
        this.Hja = 0;
        this.Hjb = 0;
        this.Hjc = false;
        this.HiZ = OpenGlRender.getGLVersion();
        fKU();
        AppMethodBeat.o(115670);
    }

    public void setRenderer(OpenGlRender openGlRender) {
        AppMethodBeat.i(115671);
        this.Hjd = new WeakReference<>(openGlRender);
        super.setRenderer((GLTextureView.m) openGlRender);
        setRenderMode(0);
        AppMethodBeat.o(115671);
    }

    @Override // com.tencent.mm.plugin.voip.video.GLTextureView
    public final void o(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(115672);
        Log.i(TAG, "surfaceCreated");
        super.o(surfaceTexture);
        OpenGlRender openGlRender = this.Hjd.get();
        Log.i(OpenGlRender.TAG, "%s surfaceCreated", Integer.valueOf(openGlRender.hashCode()));
        OpenGlRender.getGLVersion();
        openGlRender.Hie = true;
        openGlRender.Hia = true;
        AppMethodBeat.o(115672);
    }

    @Override // com.tencent.mm.plugin.voip.video.GLTextureView
    public final void p(SurfaceTexture surfaceTexture) {
        OpenGlView openGlView;
        AppMethodBeat.i(115673);
        Log.i(TAG, "surfaceDestroyed");
        OpenGlRender openGlRender = this.Hjd.get();
        Log.i(OpenGlRender.TAG, "onSurfaceDestroyed,mRenderMode:%d", Integer.valueOf(openGlRender.mRenderMode));
        if (openGlRender.Hiu != null) {
            openGlRender.HiU = true;
            Log.i(OpenGlRender.TAG, "surfaceDestroy call detachGLContext");
            openGlRender.fKP();
        }
        openGlRender.Hia = false;
        Log.i(OpenGlRender.TAG, "steve: after Uninit in onSurfaceDestroyed");
        openGlRender.HhY = 0;
        openGlRender.Hif = 0;
        openGlRender.Hig = 0;
        if (!(openGlRender.Hih == null || (openGlView = openGlRender.Hih.get()) == null)) {
            Log.i(OpenGlRender.TAG, "onSurfaceDestroyed queue release renderer event");
            openGlView.queueEvent(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0066: INVOKE  
                  (r1v7 'openGlView' com.tencent.mm.plugin.voip.video.OpenGlView)
                  (wrap: com.tencent.mm.plugin.voip.video.OpenGlRender$4 : 0x0063: CONSTRUCTOR  (r2v3 com.tencent.mm.plugin.voip.video.OpenGlRender$4) = (r0v3 'openGlRender' com.tencent.mm.plugin.voip.video.OpenGlRender) call: com.tencent.mm.plugin.voip.video.OpenGlRender.4.<init>(com.tencent.mm.plugin.voip.video.OpenGlRender):void type: CONSTRUCTOR)
                 type: VIRTUAL call: com.tencent.mm.plugin.voip.video.OpenGlView.queueEvent(java.lang.Runnable):void in method: com.tencent.mm.plugin.voip.video.OpenGlView.p(android.graphics.SurfaceTexture):void, file: classes7.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
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
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0063: CONSTRUCTOR  (r2v3 com.tencent.mm.plugin.voip.video.OpenGlRender$4) = (r0v3 'openGlRender' com.tencent.mm.plugin.voip.video.OpenGlRender) call: com.tencent.mm.plugin.voip.video.OpenGlRender.4.<init>(com.tencent.mm.plugin.voip.video.OpenGlRender):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.voip.video.OpenGlView.p(android.graphics.SurfaceTexture):void, file: classes7.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 19 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.voip.video.OpenGlRender, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 25 more
                */
            /*
            // Method dump skipped, instructions count: 112
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.voip.video.OpenGlView.p(android.graphics.SurfaceTexture):void");
        }

        @Override // com.tencent.mm.plugin.voip.video.GLTextureView
        public final void a(SurfaceTexture surfaceTexture, int i2, int i3, int i4) {
            AppMethodBeat.i(115674);
            super.a(surfaceTexture, i2, i3, i4);
            AppMethodBeat.o(115674);
        }

        public final void fKT() {
            AppMethodBeat.i(115675);
            this.HiX = true;
            this.HhI.requestRender();
            AppMethodBeat.o(115675);
        }

        private void fKU() {
            AppMethodBeat.i(235833);
            if (this.HiZ == 2) {
                setEGLContextFactory(new b());
                setEGLConfigChooser(new a());
            }
            AppMethodBeat.o(235833);
        }

        public void jH(int i2, int i3) {
        }

        public final void xv(boolean z) {
            AppMethodBeat.i(115676);
            this.Hjc = z;
            if (z) {
                setAlpha(0.0f);
                AppMethodBeat.o(115676);
                return;
            }
            setAlpha(1.0f);
            AppMethodBeat.o(115676);
        }
    }
