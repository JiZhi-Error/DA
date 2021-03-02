package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.o;

public class VideoSightView extends SightPlayImageView implements j {
    private boolean EhM;
    private boolean EhN = true;
    protected String cJp;
    protected int duration = 0;
    private boolean guh = false;

    public VideoSightView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(116271);
        init();
        AppMethodBeat.o(116271);
    }

    public VideoSightView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(116272);
        init();
        AppMethodBeat.o(116272);
    }

    public VideoSightView(Context context) {
        super(context);
        AppMethodBeat.i(116273);
        init();
        AppMethodBeat.o(116273);
    }

    /* access modifiers changed from: protected */
    public void init() {
        AppMethodBeat.i(116274);
        if (Util.nullAs(ae.gKE.gHE, "").equals(FacebookRequestErrorClassification.KEY_OTHER)) {
            Log.i("MicroMsg.VideoSightView", "init::use other player");
        } else {
            uE(true);
        }
        setOnCompletionListener(new b.e() {
            /* class com.tencent.mm.pluginsdk.ui.tools.VideoSightView.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.sight.decode.a.b.e
            public final void c(b bVar, int i2) {
                AppMethodBeat.i(116269);
                if (-1 == i2) {
                    if (VideoSightView.this.rso != null) {
                        VideoSightView.this.rso.onError(0, 0);
                        AppMethodBeat.o(116269);
                        return;
                    }
                } else if (i2 == 0 && VideoSightView.this.rso != null) {
                    VideoSightView.this.rso.onCompletion();
                }
                AppMethodBeat.o(116269);
            }
        });
        AppMethodBeat.o(116274);
    }

    @Override // com.tencent.mm.ui.widget.QImageView
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(116275);
        super.onMeasure(i2, i3);
        AppMethodBeat.o(116275);
    }

    @Override // com.tencent.mm.ui.widget.QImageView
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(116276);
        super.onLayout(z, i2, i3, i4, i5);
        Log.v("MicroMsg.VideoSightView", "ashutest::on layout changed %B, %d %d %d %d %s", Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(this.Dnx));
        if (this.Dnx && i4 - i2 > 0) {
            setDrawableWidth(i4 - i2);
        }
        AppMethodBeat.o(116276);
    }

    public void setEnableConfigChanged(boolean z) {
        this.EhN = z;
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(116277);
        super.onConfigurationChanged(configuration);
        if (this.EhN) {
            setDrawableWidth(getResources().getDisplayMetrics().widthPixels);
        }
        AppMethodBeat.o(116277);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public void setVideoPath(String str) {
        AppMethodBeat.i(116279);
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = Boolean.valueOf(this.rso == null);
        Log.i("MicroMsg.VideoSightView", "set sight path %s, callback null ? %B", objArr);
        this.duration = 0;
        this.cJp = str;
        if (this.rso != null) {
            this.rso.tf();
        }
        AppMethodBeat.o(116279);
    }

    @Override // com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView, com.tencent.mm.plugin.sight.decode.a.a
    public final void e(String str, boolean z, int i2) {
        AppMethodBeat.i(177106);
        this.cJp = str;
        super.e(str, z, i2);
        AppMethodBeat.o(177106);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public void pause() {
        AppMethodBeat.i(116281);
        super.e(this.cJp, true, 0);
        AppMethodBeat.o(116281);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public void setLoop(boolean z) {
        AppMethodBeat.i(116282);
        setLoopImp(z);
        AppMethodBeat.o(116282);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public void setVideoCallback(j.a aVar) {
        this.rso = aVar;
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public int getCurrentPosition() {
        AppMethodBeat.i(116283);
        Log.v("MicroMsg.VideoSightView", "get current position");
        AppMethodBeat.o(116283);
        return 0;
    }

    @Override // com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView, com.tencent.mm.pluginsdk.ui.tools.j
    public int getDuration() {
        AppMethodBeat.i(116284);
        int duration2 = super.getDuration();
        Log.v("MicroMsg.VideoSightView", "get duration ".concat(String.valueOf(duration2)));
        AppMethodBeat.o(116284);
        return duration2;
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public boolean start() {
        AppMethodBeat.i(116286);
        boolean E = E(getContext(), false);
        AppMethodBeat.o(116286);
        return E;
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public final boolean E(Context context, boolean z) {
        boolean z2;
        AppMethodBeat.i(116287);
        if (this.cJp == null) {
            Log.e("MicroMsg.VideoSightView", "start::use path is null!");
            AppMethodBeat.o(116287);
            return false;
        } else if (Util.nullAs(ae.gKE.gHE, "").equals(FacebookRequestErrorClassification.KEY_OTHER) || !b.aNy(this.cJp)) {
            Log.i("MicroMsg.VideoSightView", "start::use other player, path %s, has called %B", this.cJp, Boolean.valueOf(this.EhM));
            if (!this.EhM || z) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                FileProviderHelper.setIntentDataAndType(context, intent, new o(this.cJp), "video/*", false);
                try {
                    a bl = new a().bl(Intent.createChooser(intent, context.getString(R.string.zw)));
                    com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/pluginsdk/ui/tools/VideoSightView", "start", "(Landroid/content/Context;Z)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/pluginsdk/ui/tools/VideoSightView", "start", "(Landroid/content/Context;Z)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                } catch (Exception e2) {
                    Log.e("MicroMsg.VideoSightView", "startActivity fail, activity not found");
                    h.cD(context, context.getResources().getString(R.string.hwr));
                }
                this.EhM = true;
                AppMethodBeat.o(116287);
                return false;
            }
            AppMethodBeat.o(116287);
            return false;
        } else {
            super.e(this.cJp, false, 0);
            if (!this.guh) {
                z2 = true;
            } else {
                z2 = false;
            }
            uE(z2);
            AppMethodBeat.o(116287);
            return true;
        }
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public void setThumb(Bitmap bitmap) {
        AppMethodBeat.i(116288);
        au(bitmap);
        AppMethodBeat.o(116288);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public double getLastProgresstime() {
        AppMethodBeat.i(116289);
        if (getController() != null) {
            b controller = getController();
            if (controller.DmV != -1.0d) {
                double d2 = controller.DmV;
                AppMethodBeat.o(116289);
                return d2;
            }
            double d3 = controller.DmS;
            AppMethodBeat.o(116289);
            return d3;
        }
        AppMethodBeat.o(116289);
        return 0.0d;
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public void setPlayProgressCallback(boolean z) {
        AppMethodBeat.i(116291);
        if (z) {
            setOnDecodeDurationListener(new b.f() {
                /* class com.tencent.mm.pluginsdk.ui.tools.VideoSightView.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.sight.decode.a.b.f
                public final void b(b bVar, long j2) {
                    AppMethodBeat.i(116270);
                    if (VideoSightView.this.duration == 0) {
                        VideoSightView.this.duration = VideoSightView.this.getDuration();
                    }
                    if (VideoSightView.this.rso != null) {
                        Log.v("MicroMsg.VideoSightView", "onPlayTime, currentTime: %s, duration: %s", Long.valueOf(j2), Integer.valueOf(VideoSightView.this.duration));
                        VideoSightView.this.rso.fh((int) j2, VideoSightView.this.duration);
                    }
                    AppMethodBeat.o(116270);
                }
            });
            AppMethodBeat.o(116291);
            return;
        }
        setOnDecodeDurationListener(null);
        AppMethodBeat.o(116291);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public long getLastSurfaceUpdateTime() {
        return 0;
    }

    public void setForceScaleFullScreen(boolean z) {
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public void setMute(boolean z) {
        AppMethodBeat.i(116292);
        this.guh = z;
        uE(!this.guh);
        AppMethodBeat.o(116292);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public final void d(double d2, boolean z) {
        AppMethodBeat.i(116293);
        q(d2);
        AppMethodBeat.o(116293);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public void setOneTimeVideoTextureUpdateCallback(j.e eVar) {
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public void setOnSeekCompleteCallback(j.c cVar) {
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public void setOnInfoCallback(j.b bVar) {
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public void setOnSurfaceCallback(j.d dVar) {
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public boolean isPlaying() {
        AppMethodBeat.i(116278);
        boolean eVy = this.Dnr.eVy();
        AppMethodBeat.o(116278);
        return eVy;
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public void stop() {
        AppMethodBeat.i(116280);
        this.Dnr.clear();
        AppMethodBeat.o(116280);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public final void onDetach() {
        AppMethodBeat.i(116285);
        EventCenter.instance.removeListener(this.Dnr.eVB());
        AppMethodBeat.o(116285);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j
    public void q(double d2) {
        AppMethodBeat.i(116290);
        if (this.Dnr != null) {
            b bVar = this.Dnr;
            Log.v("MicroMsg.SightPlayController", "seekToFrame now %f %s", Double.valueOf(d2), Util.getStack().toString());
            com.tencent.mm.modelvideo.o.g(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0031: INVOKE  
                  (wrap: com.tencent.mm.plugin.sight.decode.a.b$4 : 0x002c: CONSTRUCTOR  (r1v1 com.tencent.mm.plugin.sight.decode.a.b$4) = (r0v1 'bVar' com.tencent.mm.plugin.sight.decode.a.b), (r8v0 'd2' double) call: com.tencent.mm.plugin.sight.decode.a.b.4.<init>(com.tencent.mm.plugin.sight.decode.a.b, double):void type: CONSTRUCTOR)
                  (0 long)
                 type: STATIC call: com.tencent.mm.modelvideo.o.g(java.lang.Runnable, long):boolean in method: com.tencent.mm.pluginsdk.ui.tools.VideoSightView.q(double):void, file: classes8.dex
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
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x002c: CONSTRUCTOR  (r1v1 com.tencent.mm.plugin.sight.decode.a.b$4) = (r0v1 'bVar' com.tencent.mm.plugin.sight.decode.a.b), (r8v0 'd2' double) call: com.tencent.mm.plugin.sight.decode.a.b.4.<init>(com.tencent.mm.plugin.sight.decode.a.b, double):void type: CONSTRUCTOR in method: com.tencent.mm.pluginsdk.ui.tools.VideoSightView.q(double):void, file: classes8.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 19 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.sight.decode.a.b, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 25 more
                */
            /*
                this = this;
                r6 = 116290(0x1c642, float:1.62957E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
                com.tencent.mm.plugin.sight.decode.a.b r0 = r7.Dnr
                if (r0 == 0) goto L_0x0034
                com.tencent.mm.plugin.sight.decode.a.b r0 = r7.Dnr
                java.lang.String r1 = "MicroMsg.SightPlayController"
                java.lang.String r2 = "seekToFrame now %f %s"
                r3 = 2
                java.lang.Object[] r3 = new java.lang.Object[r3]
                r4 = 0
                java.lang.Double r5 = java.lang.Double.valueOf(r8)
                r3[r4] = r5
                r4 = 1
                com.tencent.mm.sdk.platformtools.MMStack r5 = com.tencent.mm.sdk.platformtools.Util.getStack()
                java.lang.String r5 = r5.toString()
                r3[r4] = r5
                com.tencent.mm.sdk.platformtools.Log.v(r1, r2, r3)
                com.tencent.mm.plugin.sight.decode.a.b$4 r1 = new com.tencent.mm.plugin.sight.decode.a.b$4
                r1.<init>(r8)
                r2 = 0
                com.tencent.mm.modelvideo.o.g(r1, r2)
            L_0x0034:
                com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.ui.tools.VideoSightView.q(double):void");
        }
    }
