package com.tencent.mm.plugin.recordvideo.plugin.parent;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.g.b.a.jf;
import com.tencent.mm.media.widget.b.a.a.b;
import com.tencent.mm.media.widget.camerarecordview.b.b;
import com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLSurfaceView;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.model.d;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.XEffectConfig;
import com.tencent.mm.plugin.recordvideo.plugin.aa;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.u;
import com.tencent.mm.plugin.recordvideo.plugin.v;
import com.tencent.mm.plugin.recordvideo.plugin.w;
import com.tencent.mm.plugin.recordvideo.plugin.x;
import com.tencent.mm.plugin.recordvideo.plugin.y;
import com.tencent.mm.plugin.recordvideo.plugin.z;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.b.n;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 R2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001RB\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000f\u001a\u000205H\u0002J\b\u00106\u001a\u000205H\u0016J\u0010\u00107\u001a\u00020(2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u00108\u001a\u0002052\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u00109\u001a\u000205H\u0016J\u0010\u0010:\u001a\u0002052\u0006\u0010;\u001a\u00020<H\u0016J\b\u0010=\u001a\u000205H\u0016J-\u0010>\u001a\u0002052\u0006\u0010?\u001a\u00020<2\u000e\u0010@\u001a\n\u0012\u0006\b\u0001\u0012\u00020B0A2\u0006\u0010C\u001a\u00020DH\u0016¢\u0006\u0002\u0010EJ\b\u0010F\u001a\u000205H\u0016J\u0010\u0010G\u001a\u0002052\u0006\u0010H\u001a\u00020IH\u0002J\b\u0010J\u001a\u000205H\u0016J\u001a\u0010K\u001a\u0002052\u0006\u0010L\u001a\u00020M2\b\u0010N\u001a\u0004\u0018\u00010OH\u0016J\u0010\u0010P\u001a\u0002052\u0006\u0010Q\u001a\u00020\u0010H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0011\u0010#\u001a\u00020$¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0014\u0010/\u001a\u000200X\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u000e\u00103\u001a\u000204X\u0004¢\u0006\u0002\n\u0000¨\u0006S"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/RecordPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener$OrienChangeCallback;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "albumPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/RecordAlbumPlugin;", "beautifyPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/RecordBeautifyPlugin;", "cameraSwitchPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/RecordSwitchCameraPlugin;", "checkAudioPermission", "", "closePlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/RecordClosePlugin;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "getConfigProvider", "()Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "setConfigProvider", "(Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;)V", "filterPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/RecordFilterPlugin;", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "orientationEventListener", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener;", "getOrientationEventListener", "()Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener;", "setOrientationEventListener", "(Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener;)V", "previewPlugin", "Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;", "getPreviewPlugin", "()Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;", "process", "Lcom/tencent/mm/plugin/recordvideo/config/CameraContainerProcess;", "recordController", "Lcom/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer;", "getRecordController", "()Lcom/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer;", "setRecordController", "(Lcom/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer;)V", "recordPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/RecordButtonPlugin;", "getRecordPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/RecordButtonPlugin;", "touchFocusPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/RecordFocusPlugin;", "", "doOnResume", "getProcess", "initLogic", "onDetach", "onOrientationChange", "orientation", "", "onPause", "onRequestPermissionsResult", "requestCode", NativeProtocol.RESULT_ARGS_PERMISSIONS, "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onStopRecord", "capture", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "release", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "updateRecordTipByAudioPermission", "permission", "Companion", "plugin-recordvideo_release"})
public class RecordPluginLayout extends BasePluginLayout implements d.a, d {
    public static final a BXf = new a((byte) 0);
    private final x BXa;
    private final u BXb;
    private final v BXc;
    private final y BXd;
    private com.tencent.mm.plugin.recordvideo.b.b BXe;
    private com.tencent.mm.plugin.mmsight.model.d orientationEventListener;
    private final CameraPreviewGLSurfaceView wcV;
    private final w wcW;
    private final aa wcY;
    private final z wcZ = new z(this, this);
    private com.tencent.mm.media.widget.camerarecordview.a wdk;
    private com.tencent.mm.plugin.recordvideo.activity.a wdl;
    private RecordConfigProvider wdm;
    private boolean wds;

    static {
        AppMethodBeat.i(75813);
        AppMethodBeat.o(75813);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "succ", "", "invoke"})
    static final class b extends q implements kotlin.g.a.b<Boolean, kotlin.x> {
        final /* synthetic */ com.tencent.mm.media.widget.camerarecordview.a BXh;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(com.tencent.mm.media.widget.camerarecordview.a aVar) {
            super(1);
            this.BXh = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Boolean bool) {
            AppMethodBeat.i(163465);
            Log.i("MicroMsg.RecordPluginLayout", "startPreview finish:".concat(String.valueOf(bool.booleanValue())));
            if (com.tencent.mm.plugin.recordvideo.b.g.isInit()) {
                com.tencent.mm.plugin.recordvideo.b.g.j(this.BXh.fi(true));
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(163465);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    static final class c extends q implements kotlin.g.a.b<Boolean, kotlin.x> {
        final /* synthetic */ RecordPluginLayout BXg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(RecordPluginLayout recordPluginLayout) {
            super(1);
            this.BXg = recordPluginLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Boolean bool) {
            AppMethodBeat.i(75801);
            if (bool.booleanValue()) {
                View findViewById = this.BXg.findViewById(R.id.dni);
                p.g(findViewById, "findViewById<Switch>(R.id.hdr)");
                ((Switch) findViewById).setChecked(true);
                View findViewById2 = this.BXg.findViewById(R.id.bmq);
                p.g(findViewById2, "findViewById<Switch>(R.id.denoisy)");
                ((Switch) findViewById2).setChecked(false);
            } else {
                View findViewById3 = this.BXg.findViewById(R.id.dni);
                p.g(findViewById3, "findViewById<Switch>(R.id.hdr)");
                ((Switch) findViewById3).setChecked(false);
                View findViewById4 = this.BXg.findViewById(R.id.bmq);
                p.g(findViewById4, "findViewById<Switch>(R.id.denoisy)");
                ((Switch) findViewById4).setChecked(true);
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(75801);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "p1", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "Lkotlin/ParameterName;", "name", "capture", "invoke"})
    static final /* synthetic */ class g extends n implements kotlin.g.a.b<com.tencent.mm.media.widget.camerarecordview.b.b, kotlin.x> {
        g(RecordPluginLayout recordPluginLayout) {
            super(1, recordPluginLayout);
        }

        @Override // kotlin.g.b.e
        public final kotlin.l.d Rs() {
            AppMethodBeat.i(237410);
            kotlin.l.b bp = kotlin.g.b.aa.bp(RecordPluginLayout.class);
            AppMethodBeat.o(237410);
            return bp;
        }

        @Override // kotlin.l.a, kotlin.g.b.e
        public final String getName() {
            return "onStopRecord";
        }

        @Override // kotlin.g.b.e
        public final String getSignature() {
            return "onStopRecord(Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;)V";
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(com.tencent.mm.media.widget.camerarecordview.b.b bVar) {
            AppMethodBeat.i(75803);
            com.tencent.mm.media.widget.camerarecordview.b.b bVar2 = bVar;
            p.h(bVar2, "p1");
            RecordPluginLayout.a((RecordPluginLayout) this.SYl, bVar2);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(75803);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/graphics/Bitmap;", "invoke"})
    static final class h extends q implements kotlin.g.a.b<Bitmap, kotlin.x> {
        final /* synthetic */ RecordPluginLayout BXg;
        final /* synthetic */ long qVz;
        final /* synthetic */ float wdA;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(RecordPluginLayout recordPluginLayout, long j2, float f2) {
            super(1);
            this.BXg = recordPluginLayout;
            this.qVz = j2;
            this.wdA = f2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Bitmap bitmap) {
            com.tencent.mm.ab.i iVar;
            Bitmap bitmap2;
            boolean z;
            int i2 = 1;
            AppMethodBeat.i(75804);
            Bitmap bitmap3 = bitmap;
            long ticksToNow = Util.ticksToNow(this.qVz);
            Log.i("MicroMsg.RecordPluginLayout", "photo time cost : ".concat(String.valueOf(ticksToNow)));
            com.tencent.mm.media.k.e eVar = com.tencent.mm.media.k.e.ilC;
            com.tencent.mm.media.k.e.aNN();
            com.tencent.mm.media.k.e eVar2 = com.tencent.mm.media.k.e.ilC;
            com.tencent.mm.media.k.e.zK(ticksToNow);
            if (bitmap3 != null) {
                com.tencent.mm.media.widget.camerarecordview.a recordController = this.BXg.getRecordController();
                if (recordController != null) {
                    recordController.stopPreview();
                }
                Log.i("MicroMsg.RecordPluginLayout", "orientation : " + this.wdA);
                boolean a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_photo_align_long_side, true);
                if (ae.gKA.gJq != -1) {
                    if (ae.gKA.gJq == 0) {
                        a2 = false;
                    } else if (ae.gKA.gJq == 1) {
                        a2 = true;
                    }
                }
                if (a2) {
                    if (bitmap3.getHeight() > bitmap3.getWidth()) {
                        if (((float) bitmap3.getHeight()) > 1920.0f) {
                            float height = 1920.0f / ((float) bitmap3.getHeight());
                            bitmap2 = BitmapUtil.rotateAndScale(bitmap3, this.wdA, height, height);
                            p.g(bitmap2, "BitmapUtil.rotateAndScal…rientation, scale, scale)");
                        } else {
                            if (this.wdA != 0.0f) {
                                bitmap2 = BitmapUtil.rotate(bitmap3, this.wdA);
                                p.g(bitmap2, "BitmapUtil.rotate(it, orientation)");
                            }
                            bitmap2 = bitmap3;
                        }
                    } else if (((float) bitmap3.getWidth()) > 1920.0f) {
                        float width = 1920.0f / ((float) bitmap3.getWidth());
                        bitmap2 = BitmapUtil.rotateAndScale(bitmap3, this.wdA, width, width);
                        p.g(bitmap2, "BitmapUtil.rotateAndScal…rientation, scale, scale)");
                    } else {
                        if (this.wdA != 0.0f) {
                            bitmap2 = BitmapUtil.rotate(bitmap3, this.wdA);
                            p.g(bitmap2, "BitmapUtil.rotate(it, orientation)");
                        }
                        bitmap2 = bitmap3;
                    }
                } else if (bitmap3.getHeight() > bitmap3.getWidth()) {
                    if (((float) bitmap3.getWidth()) > 1080.0f) {
                        float width2 = 1080.0f / ((float) bitmap3.getWidth());
                        bitmap2 = BitmapUtil.rotateAndScale(bitmap3, this.wdA, width2, width2);
                        p.g(bitmap2, "BitmapUtil.rotateAndScal…rientation, scale, scale)");
                    } else {
                        if (this.wdA != 0.0f) {
                            bitmap2 = BitmapUtil.rotate(bitmap3, this.wdA);
                            p.g(bitmap2, "BitmapUtil.rotate(it, orientation)");
                        }
                        bitmap2 = bitmap3;
                    }
                } else if (((float) bitmap3.getHeight()) > 1080.0f) {
                    float height2 = 1080.0f / ((float) bitmap3.getHeight());
                    bitmap2 = BitmapUtil.rotateAndScale(bitmap3, this.wdA, height2, height2);
                    p.g(bitmap2, "BitmapUtil.rotateAndScal…rientation, scale, scale)");
                } else {
                    if (this.wdA != 0.0f) {
                        bitmap2 = BitmapUtil.rotate(bitmap3, this.wdA);
                        p.g(bitmap2, "BitmapUtil.rotate(it, orientation)");
                    }
                    bitmap2 = bitmap3;
                }
                long currentTicks = Util.currentTicks();
                if (this.wdA == 90.0f || this.wdA == 270.0f) {
                    z = true;
                } else {
                    z = false;
                }
                RecordConfigProvider configProvider = this.BXg.getConfigProvider();
                if (configProvider != null) {
                    try {
                        BitmapUtil.saveBitmapToImage(bitmap2, 100, Bitmap.CompressFormat.JPEG, configProvider.BOB, true);
                        Log.i("MicroMsg.RecordPluginLayout", "save picture in " + configProvider.BOB + "  cost: " + Util.ticksToNow(currentTicks));
                        b.a aVar = com.tencent.mm.media.widget.camerarecordview.b.b.iqq;
                        String str = configProvider.BOB;
                        p.g(str, "this.inputPhotoPath");
                        com.tencent.mm.media.widget.camerarecordview.b.b Hz = b.a.Hz(str);
                        Hz.iqo = z;
                        com.tencent.mm.plugin.recordvideo.activity.a aVar2 = this.BXg.wdl;
                        if (aVar2 != null) {
                            aVar2.a(1, Hz);
                        }
                    } catch (IOException e2) {
                        com.tencent.mm.media.widget.camerarecordview.a recordController2 = this.BXg.getRecordController();
                        if (recordController2 != null) {
                            com.tencent.mm.media.widget.camerarecordview.a.a(recordController2, false, null, 7);
                        }
                        com.tencent.mm.media.k.e eVar3 = com.tencent.mm.media.k.e.ilC;
                        com.tencent.mm.media.k.e.aNT();
                    }
                }
            }
            com.tencent.mm.plugin.recordvideo.d.c cVar = com.tencent.mm.plugin.recordvideo.d.c.BXI;
            com.tencent.mm.media.widget.camerarecordview.a recordController3 = this.BXg.getRecordController();
            if (recordController3 != null && recordController3.ipt) {
                i2 = 2;
            }
            com.tencent.mm.plugin.recordvideo.d.c.x("KEY_MEDIA_SOURCE_INT", Integer.valueOf(i2));
            com.tencent.mm.plugin.recordvideo.d.g gVar = com.tencent.mm.plugin.recordvideo.d.g.BXY;
            com.tencent.mm.media.widget.camerarecordview.a recordController4 = this.BXg.getRecordController();
            if (recordController4 != null) {
                iVar = recordController4.ipG;
            } else {
                iVar = null;
            }
            com.tencent.mm.plugin.recordvideo.d.g.b(iVar);
            if (bitmap3 == null) {
                com.tencent.mm.media.k.e eVar4 = com.tencent.mm.media.k.e.ilC;
                com.tencent.mm.media.k.e.aNO();
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(75804);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/RecordPluginLayout$Companion;", "", "()V", "RECORD_MIN_TIME", "", "TAG", "", "plugin-recordvideo_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecordPluginLayout(final Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(75812);
        this.orientationEventListener = new com.tencent.mm.plugin.mmsight.model.d(context, (byte) 0);
        LayoutInflater.from(context).inflate(R.layout.blu, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.ggp);
        p.g(findViewById, "findViewById(R.id.preview_plugin)");
        this.wcV = (CameraPreviewGLSurfaceView) findViewById;
        View findViewById2 = findViewById(R.id.gxe);
        p.g(findViewById2, "findViewById(R.id.record_plugin)");
        this.wcW = new w((RelativeLayout) findViewById2, this);
        View findViewById3 = findViewById(R.id.b4k);
        p.g(findViewById3, "findViewById(R.id.close_plugin)");
        this.BXa = new x((WeImageView) findViewById3, this);
        View findViewById4 = findViewById(R.id.if9);
        p.g(findViewById4, "findViewById(R.id.switch_camera)");
        this.wcY = new aa((ImageView) findViewById4, this);
        View findViewById5 = findViewById(R.id.i7x);
        p.g(findViewById5, "findViewById(R.id.story_choose_from_album)");
        this.BXb = new u((ImageView) findViewById5, this);
        View findViewById6 = findViewById(R.id.gwg);
        p.g(findViewById6, "findViewById(R.id.record_beautify)");
        this.BXc = new v((WeImageView) findViewById6, this, this.wcV);
        View findViewById7 = findViewById(R.id.gwx);
        p.g(findViewById7, "findViewById(R.id.record_filter)");
        this.BXd = new y((ImageView) findViewById7, this);
        getPluginList().add(this.wcW);
        getPluginList().add(this.BXa);
        getPluginList().add(this.BXb);
        getPluginList().add(this.wcY);
        getPluginList().add(this.wcZ);
        getPluginList().add(this.BXc);
        getPluginList().add(this.BXd);
        if (ac.jPs || com.tencent.mm.media.widget.d.b.aRI()) {
            View findViewById8 = findViewById(R.id.ai4);
            p.g(findViewById8, "findViewById<View>(R.id.camera_vendor_test)");
            findViewById8.setVisibility(0);
            ((Switch) findViewById(R.id.ca7)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) {
                /* class com.tencent.mm.plugin.recordvideo.plugin.parent.RecordPluginLayout.AnonymousClass1 */
                final /* synthetic */ RecordPluginLayout BXg;

                {
                    this.BXg = r1;
                }

                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    AppMethodBeat.i(75794);
                    p.g(compoundButton, "buttonView");
                    compoundButton.setVisibility(0);
                    com.tencent.mm.media.widget.camerarecordview.a recordController = this.BXg.getRecordController();
                    if (recordController != null) {
                        b.a aVar = com.tencent.mm.media.widget.b.a.a.b.ipa;
                        recordController.B(com.tencent.mm.media.widget.b.a.a.b.ioS, z);
                        AppMethodBeat.o(75794);
                        return;
                    }
                    AppMethodBeat.o(75794);
                }
            });
            ((Switch) findViewById(R.id.bmq)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) {
                /* class com.tencent.mm.plugin.recordvideo.plugin.parent.RecordPluginLayout.AnonymousClass2 */
                final /* synthetic */ RecordPluginLayout BXg;

                {
                    this.BXg = r1;
                }

                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    AppMethodBeat.i(75795);
                    p.g(compoundButton, "buttonView");
                    compoundButton.setVisibility(0);
                    View findViewById = this.BXg.findViewById(R.id.dni);
                    p.g(findViewById, "findViewById<Switch>(R.id.hdr)");
                    if (((Switch) findViewById).isChecked() && z) {
                        View findViewById2 = this.BXg.findViewById(R.id.dni);
                        p.g(findViewById2, "findViewById<Switch>(R.id.hdr)");
                        ((Switch) findViewById2).setChecked(false);
                    }
                    com.tencent.mm.media.widget.camerarecordview.a recordController = this.BXg.getRecordController();
                    if (recordController != null) {
                        b.a aVar = com.tencent.mm.media.widget.b.a.a.b.ipa;
                        recordController.B(com.tencent.mm.media.widget.b.a.a.b.ioW, z);
                        AppMethodBeat.o(75795);
                        return;
                    }
                    AppMethodBeat.o(75795);
                }
            });
            ((Switch) findViewById(R.id.dnj)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) {
                /* class com.tencent.mm.plugin.recordvideo.plugin.parent.RecordPluginLayout.AnonymousClass3 */
                final /* synthetic */ RecordPluginLayout BXg;

                {
                    this.BXg = r1;
                }

                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    AppMethodBeat.i(75796);
                    p.g(compoundButton, "buttonView");
                    compoundButton.setVisibility(0);
                    com.tencent.mm.media.widget.camerarecordview.a recordController = this.BXg.getRecordController();
                    if (recordController != null) {
                        b.a aVar = com.tencent.mm.media.widget.b.a.a.b.ipa;
                        recordController.B(com.tencent.mm.media.widget.b.a.a.b.ioZ, z);
                        AppMethodBeat.o(75796);
                        return;
                    }
                    AppMethodBeat.o(75796);
                }
            });
            ((Switch) findViewById(R.id.dni)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) {
                /* class com.tencent.mm.plugin.recordvideo.plugin.parent.RecordPluginLayout.AnonymousClass4 */
                final /* synthetic */ RecordPluginLayout BXg;

                {
                    this.BXg = r1;
                }

                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    AppMethodBeat.i(75797);
                    p.g(compoundButton, "buttonView");
                    compoundButton.setVisibility(0);
                    View findViewById = this.BXg.findViewById(R.id.bmq);
                    p.g(findViewById, "findViewById<Switch>(R.id.denoisy)");
                    if (((Switch) findViewById).isChecked() && z) {
                        View findViewById2 = this.BXg.findViewById(R.id.bmq);
                        p.g(findViewById2, "findViewById<Switch>(R.id.denoisy)");
                        ((Switch) findViewById2).setChecked(false);
                    }
                    com.tencent.mm.media.widget.camerarecordview.a recordController = this.BXg.getRecordController();
                    if (recordController != null) {
                        b.a aVar = com.tencent.mm.media.widget.b.a.a.b.ipa;
                        recordController.B(com.tencent.mm.media.widget.b.a.a.b.ioX, z);
                        AppMethodBeat.o(75797);
                        return;
                    }
                    AppMethodBeat.o(75797);
                }
            });
            ((Switch) findViewById(R.id.byg)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) {
                /* class com.tencent.mm.plugin.recordvideo.plugin.parent.RecordPluginLayout.AnonymousClass5 */
                final /* synthetic */ RecordPluginLayout BXg;

                {
                    this.BXg = r1;
                }

                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    AppMethodBeat.i(169940);
                    p.g(compoundButton, "buttonView");
                    compoundButton.setVisibility(0);
                    com.tencent.mm.media.widget.camerarecordview.a recordController = this.BXg.getRecordController();
                    if (recordController != null) {
                        b.a aVar = com.tencent.mm.media.widget.b.a.a.b.ipa;
                        recordController.B(com.tencent.mm.media.widget.b.a.a.b.ioY, z);
                        AppMethodBeat.o(169940);
                        return;
                    }
                    AppMethodBeat.o(169940);
                }
            });
            com.tencent.mm.media.widget.b.a.a aVar = com.tencent.mm.media.widget.b.a.a.ioi;
            com.tencent.mm.media.widget.b.a.a.b(new m<String, Integer, kotlin.x>(this) {
                /* class com.tencent.mm.plugin.recordvideo.plugin.parent.RecordPluginLayout.AnonymousClass6 */
                final /* synthetic */ RecordPluginLayout BXg;

                {
                    this.BXg = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // kotlin.g.a.m
                public final /* synthetic */ kotlin.x invoke(String str, Integer num) {
                    AppMethodBeat.i(169941);
                    String str2 = str;
                    int intValue = num.intValue();
                    p.h(str2, "tag");
                    com.tencent.mm.media.widget.camerarecordview.a recordController = this.BXg.getRecordController();
                    if (recordController != null) {
                        p.h(str2, "tag");
                        recordController.hAt.ad(str2, intValue);
                    }
                    kotlin.x xVar = kotlin.x.SXb;
                    AppMethodBeat.o(169941);
                    return xVar;
                }
            });
            View findViewById9 = findViewById(R.id.a2m);
            p.g(findViewById9, "findViewById<Button>(R.id.beauty_debug)");
            ((Button) findViewById9).setVisibility(0);
            ((Button) findViewById(R.id.a2m)).setOnClickListener(new View.OnClickListener(this) {
                /* class com.tencent.mm.plugin.recordvideo.plugin.parent.RecordPluginLayout.AnonymousClass7 */
                final /* synthetic */ RecordPluginLayout BXg;

                {
                    this.BXg = r1;
                }

                public final void onClick(View view) {
                    AppMethodBeat.i(169942);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/plugin/parent/RecordPluginLayout$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    android.support.design.widget.a aVar = new android.support.design.widget.a(context);
                    Window window = aVar.getWindow();
                    if (window != null) {
                        window.clearFlags(2);
                    }
                    VendorEffectSettingView vendorEffectSettingView = new VendorEffectSettingView(context);
                    vendorEffectSettingView.setCameraView(this.BXg.getPreviewPlugin());
                    aVar.setContentView(vendorEffectSettingView);
                    aVar.show();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/parent/RecordPluginLayout$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(169942);
                }
            });
        }
        com.tencent.mm.plugin.mmsight.model.d dVar = this.orientationEventListener;
        if (dVar != null) {
            dVar.a(this);
        }
        com.tencent.mm.plugin.mmsight.model.d dVar2 = this.orientationEventListener;
        if (dVar2 != null) {
            dVar2.enable();
            AppMethodBeat.o(75812);
            return;
        }
        AppMethodBeat.o(75812);
    }

    public static final /* synthetic */ void c(RecordPluginLayout recordPluginLayout) {
        AppMethodBeat.i(237415);
        recordPluginLayout.oL(false);
        AppMethodBeat.o(237415);
    }

    public final CameraPreviewGLSurfaceView getPreviewPlugin() {
        return this.wcV;
    }

    /* access modifiers changed from: protected */
    public final w getRecordPlugin() {
        return this.wcW;
    }

    public final com.tencent.mm.media.widget.camerarecordview.a getRecordController() {
        return this.wdk;
    }

    public final void setRecordController(com.tencent.mm.media.widget.camerarecordview.a aVar) {
        this.wdk = aVar;
    }

    public final RecordConfigProvider getConfigProvider() {
        return this.wdm;
    }

    public final void setConfigProvider(RecordConfigProvider recordConfigProvider) {
        this.wdm = recordConfigProvider;
    }

    public final com.tencent.mm.plugin.mmsight.model.d getOrientationEventListener() {
        return this.orientationEventListener;
    }

    public final void setOrientationEventListener(com.tencent.mm.plugin.mmsight.model.d dVar) {
        this.orientationEventListener = dVar;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
    public final void a(com.tencent.mm.plugin.recordvideo.activity.a aVar, RecordConfigProvider recordConfigProvider) {
        boolean z;
        boolean z2;
        com.tencent.mm.media.widget.camerarecordview.a aVar2;
        boolean z3;
        boolean z4 = true;
        boolean z5 = false;
        AppMethodBeat.i(75805);
        p.h(aVar, "navigator");
        p.h(recordConfigProvider, "configProvider");
        if (kotlin.a.j.listOf((Object[]) new Integer[]{1, 2, 4}).contains(Integer.valueOf(recordConfigProvider.scene))) {
            if (recordConfigProvider.BOm == null) {
                recordConfigProvider.BOm = new SightParams(recordConfigProvider.scene, 0).irT;
            }
            VideoTransPara videoTransPara = recordConfigProvider.BOm;
            if (videoTransPara != null) {
                Log.i("MicroMsg.RecordPluginLayout", "initLogic init SightRecordConfig ");
                com.tencent.mm.plugin.recordvideo.b.g gVar = com.tencent.mm.plugin.recordvideo.b.g.BNx;
                com.tencent.mm.plugin.recordvideo.b.g.b(videoTransPara, recordConfigProvider.scene);
            }
        }
        this.wdl = aVar;
        this.wdm = recordConfigProvider;
        p.h(recordConfigProvider, "configProvider");
        this.BXe = new com.tencent.mm.plugin.recordvideo.b.b(recordConfigProvider, this.wcV);
        Context context = getContext();
        if (context == null) {
            t tVar = new t("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(75805);
            throw tVar;
        }
        boolean a2 = com.tencent.mm.pluginsdk.permission.b.a((Activity) context, "android.permission.RECORD_AUDIO", 80, "", "");
        Log.i("MicroMsg.RecordPluginLayout", "checkAudioPermission " + a2 + " !");
        com.tencent.mm.plugin.recordvideo.b.b bVar = this.BXe;
        if (bVar != null) {
            if (!a2) {
                z3 = true;
            } else {
                z3 = false;
            }
            bVar.isb = z3;
        }
        com.tencent.mm.plugin.recordvideo.b.b bVar2 = this.BXe;
        if (bVar2 == null) {
            p.hyc();
        }
        this.wdk = new com.tencent.mm.media.widget.camerarecordview.a(bVar2);
        if (recordConfigProvider.scene == 11) {
            com.tencent.mm.modelcontrol.e baZ = com.tencent.mm.modelcontrol.e.baZ();
            p.g(baZ, "SubCoreVideoControl.getCore()");
            long j2 = ((long) baZ.bbe().minDuration) * 1000;
            if (j2 >= 1000) {
                com.tencent.mm.media.widget.camerarecordview.a aVar3 = this.wdk;
                if (aVar3 != null) {
                    aVar3.zU(j2);
                }
            } else {
                com.tencent.mm.media.widget.camerarecordview.a aVar4 = this.wdk;
                if (aVar4 != null) {
                    aVar4.zU(1000);
                }
            }
        } else {
            int i2 = recordConfigProvider.BOw;
            if (i2 > 0) {
                com.tencent.mm.media.widget.camerarecordview.a aVar5 = this.wdk;
                if (aVar5 != null) {
                    aVar5.zU((long) i2);
                }
            } else {
                com.tencent.mm.media.widget.camerarecordview.a aVar6 = this.wdk;
                if (aVar6 != null) {
                    aVar6.zU(1000);
                }
            }
        }
        if (ac.jPs && (aVar2 = this.wdk) != null) {
            c cVar = new c(this);
            aVar2.hAt.o(cVar);
            aVar2.imw = cVar;
        }
        this.wcW.a(recordConfigProvider);
        u uVar = this.BXb;
        p.h(recordConfigProvider, "config");
        Boolean bool = recordConfigProvider.BOu;
        p.g(bool, "config.enableAlbum");
        uVar.enable = bool.booleanValue();
        uVar.scene = recordConfigProvider.scene;
        this.BXa.a(recordConfigProvider);
        v vVar = this.BXc;
        p.h(recordConfigProvider, "config");
        vVar.wgN = recordConfigProvider.BOJ.BOM;
        if (vVar.wgN) {
            vVar.wgX.setVisibility(0);
            if (vVar.krh) {
                z2 = vVar.wgO;
            } else {
                z2 = vVar.wgP;
            }
            vVar.setEnable(z2);
        } else {
            vVar.wgX.setVisibility(8);
        }
        y yVar = this.BXd;
        p.h(recordConfigProvider, "config");
        yVar.wgN = recordConfigProvider.BOJ.BON;
        if (yVar.wgN) {
            yVar.tkI.setVisibility(0);
            yVar.setEnable(true);
        } else {
            yVar.tkI.setVisibility(8);
        }
        u uVar2 = this.BXb;
        Boolean bool2 = recordConfigProvider.BOu;
        p.g(bool2, "configProvider.enableAlbum");
        uVar2.setVisibility(bool2.booleanValue() ? 0 : 8);
        StringBuilder append = new StringBuilder("configProvider:").append(recordConfigProvider).append(", config:");
        com.tencent.mm.plugin.recordvideo.b.g gVar2 = com.tencent.mm.plugin.recordvideo.b.g.BNx;
        Log.i("MicroMsg.RecordPluginLayout", append.append(com.tencent.mm.plugin.recordvideo.b.g.eJx()).toString());
        String str = recordConfigProvider.BOK;
        p.g(str, "configProvider.captureHint");
        if (str.length() <= 0) {
            z4 = false;
        }
        if (z4) {
            w wVar = this.wcW;
            String str2 = recordConfigProvider.BOK;
            p.g(str2, "configProvider.captureHint");
            p.h(str2, "wording");
            wVar.rsX.setText(str2);
        }
        com.tencent.mm.plugin.recordvideo.d.g gVar3 = com.tencent.mm.plugin.recordvideo.d.g.BXY;
        com.tencent.mm.plugin.recordvideo.b.b bVar3 = this.BXe;
        if (bVar3 != null) {
            z = bVar3.aQy();
        } else {
            z = false;
        }
        com.tencent.mm.plugin.recordvideo.d.g.tq(z);
        com.tencent.mm.plugin.recordvideo.d.g gVar4 = com.tencent.mm.plugin.recordvideo.d.g.BXY;
        com.tencent.mm.plugin.recordvideo.b.b bVar4 = this.BXe;
        if (bVar4 != null) {
            z5 = bVar4.aQw();
        }
        com.tencent.mm.plugin.recordvideo.d.g.tp(z5);
        AppMethodBeat.o(75805);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.parent.d
    public final void a(d.c cVar, Bundle bundle) {
        boolean z;
        long j2;
        boolean z2;
        int i2;
        AppMethodBeat.i(75806);
        p.h(cVar, "status");
        Log.i("MicroMsg.RecordPluginLayout", "status : " + cVar + "  param: " + bundle);
        switch (f.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                RecordConfigProvider recordConfigProvider = this.wdm;
                if (recordConfigProvider == null || !recordConfigProvider.BOG) {
                    z2 = false;
                    i2 = 0;
                } else {
                    com.tencent.mm.plugin.mmsight.model.d dVar = this.orientationEventListener;
                    z2 = dVar != null ? dVar.isLandscape() : false;
                    com.tencent.mm.plugin.mmsight.model.d dVar2 = this.orientationEventListener;
                    i2 = dVar2 != null ? dVar2.getOrientation() : 0;
                }
                com.tencent.mm.media.widget.camerarecordview.a aVar = this.wdk;
                boolean j3 = aVar != null ? aVar.j(z2, i2) : false;
                this.BXa.setVisibility(8);
                this.BXb.setVisibility(8);
                com.tencent.mm.plugin.recordvideo.b.g gVar = com.tencent.mm.plugin.recordvideo.b.g.BNx;
                com.tencent.mm.plugin.recordvideo.b.g.eJC();
                com.tencent.mm.plugin.recordvideo.d.c cVar2 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                com.tencent.mm.plugin.recordvideo.d.c.x("KEY_START_RECORD_MS_LONG", Long.valueOf(System.currentTimeMillis()));
                com.tencent.mm.plugin.recordvideo.d.g gVar2 = com.tencent.mm.plugin.recordvideo.d.g.BXY;
                com.tencent.mm.plugin.recordvideo.d.g.Ia(SystemClock.elapsedRealtime());
                com.tencent.mm.plugin.recordvideo.d.g gVar3 = com.tencent.mm.plugin.recordvideo.d.g.BXY;
                com.tencent.mm.plugin.recordvideo.d.g.tr(j3);
                AppMethodBeat.o(75806);
                return;
            case 2:
                com.tencent.mm.plugin.recordvideo.d.g gVar4 = com.tencent.mm.plugin.recordvideo.d.g.BXY;
                com.tencent.mm.plugin.recordvideo.d.g.Ib(SystemClock.elapsedRealtime());
                com.tencent.mm.media.widget.camerarecordview.a aVar2 = this.wdk;
                if (aVar2 != null && !aVar2.p(new g(this))) {
                    this.wcW.reset();
                    RecordConfigProvider recordConfigProvider2 = this.wdm;
                    if (recordConfigProvider2 != null && recordConfigProvider2.scene == 11) {
                        com.tencent.mm.media.widget.camerarecordview.a aVar3 = this.wdk;
                        if (aVar3 != null) {
                            j2 = aVar3.ipu;
                        } else {
                            j2 = 0;
                        }
                        if (Util.ticksToNow(j2) > 1000) {
                            w.b(this.wcW);
                        }
                    }
                    this.wcW.eKH();
                }
                this.BXa.setVisibility(0);
                this.BXb.setVisibility(0);
                AppMethodBeat.o(75806);
                return;
            case 3:
                if (bundle != null) {
                    ArrayList<String> stringArrayList = bundle.getStringArrayList("PARAM_PHOTO_LIST");
                    ArrayList<String> stringArrayList2 = bundle.getStringArrayList("PARAM_VIDEO_LIST");
                    com.tencent.mm.media.widget.camerarecordview.b.b bVar = new com.tencent.mm.media.widget.camerarecordview.b.b(null, null, false, null, null, null, null, null, null, 65535);
                    ArrayList<String> arrayList = stringArrayList;
                    if (!(arrayList == null || arrayList.isEmpty())) {
                        if (stringArrayList == null) {
                            p.hyc();
                        }
                        String str = stringArrayList.get(0);
                        p.g(str, "imageList!![0]");
                        bVar.Hy(str);
                        bVar.s(stringArrayList);
                    }
                    ArrayList<String> arrayList2 = stringArrayList2;
                    if (!(arrayList2 == null || arrayList2.isEmpty())) {
                        if (stringArrayList2 == null) {
                            p.hyc();
                        }
                        String str2 = stringArrayList2.get(0);
                        p.g(str2, "videoList!![0]");
                        bVar.Hw(str2);
                        bVar.t(stringArrayList2);
                    }
                    bVar.iqf = false;
                    bVar.aQr();
                    com.tencent.mm.plugin.recordvideo.activity.a aVar4 = this.wdl;
                    if (aVar4 != null) {
                        aVar4.a(bundle.getInt("PARAM_ROUTER_INT", 0), bVar);
                        AppMethodBeat.o(75806);
                        return;
                    }
                    AppMethodBeat.o(75806);
                    return;
                }
                AppMethodBeat.o(75806);
                return;
            case 4:
                if (bundle != null) {
                    com.tencent.mm.media.widget.camerarecordview.a aVar5 = this.wdk;
                    if (aVar5 != null) {
                        aVar5.rz(bundle.getInt("PARAM_PREPARE_CAMERA_ZOOM_LOCATION_INT"));
                        AppMethodBeat.o(75806);
                        return;
                    }
                    AppMethodBeat.o(75806);
                    return;
                }
                AppMethodBeat.o(75806);
                return;
            case 5:
                if (bundle != null) {
                    com.tencent.mm.media.widget.camerarecordview.a aVar6 = this.wdk;
                    if (aVar6 != null) {
                        boolean z3 = bundle.getBoolean("PARAM_PREPARE_CAMERA_ZOOM_BOOLEAN", false);
                        bundle.getBoolean("PARAM_PREPARE_CAMERA_ZOOM_SCROLL_BOOLEAN", true);
                        aVar6.i(z3, bundle.getInt("PARAM_PREPARE_CAMERA_ZOOM_FACTOR_INT"));
                        AppMethodBeat.o(75806);
                        return;
                    }
                    AppMethodBeat.o(75806);
                    return;
                }
                AppMethodBeat.o(75806);
                return;
            case 6:
                com.tencent.mm.media.widget.camerarecordview.a aVar7 = this.wdk;
                Boolean valueOf = aVar7 != null ? Boolean.valueOf(com.tencent.mm.media.widget.camerarecordview.a.b(aVar7)) : null;
                v vVar = this.BXc;
                com.tencent.mm.media.widget.camerarecordview.a aVar8 = this.wdk;
                if (aVar8 != null) {
                    z = aVar8.ipt;
                } else {
                    z = false;
                }
                vVar.oS(z);
                if (valueOf != null) {
                    valueOf.booleanValue();
                    this.wcY.tf(!valueOf.booleanValue());
                    AppMethodBeat.o(75806);
                    return;
                }
                AppMethodBeat.o(75806);
                return;
            case 7:
                float f2 = bundle != null ? bundle.getFloat("PARAM_POINT_X") : 0.0f;
                float f3 = bundle != null ? bundle.getFloat("PARAM_POINT_Y") : 0.0f;
                com.tencent.mm.media.widget.camerarecordview.a aVar9 = this.wdk;
                if (aVar9 != null) {
                    aVar9.b(f2, f3, this.wcV.getWidth(), this.wcV.getHeight());
                    AppMethodBeat.o(75806);
                    return;
                }
                AppMethodBeat.o(75806);
                return;
            case 8:
                long currentTicks = Util.currentTicks();
                com.tencent.mm.plugin.mmsight.model.d dVar3 = this.orientationEventListener;
                float ejw = dVar3 != null ? (float) dVar3.ejw() : 0.0f;
                com.tencent.mm.plugin.recordvideo.d.c cVar3 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                com.tencent.mm.plugin.recordvideo.d.c.x("KEY_START_RECORD_MS_LONG", Long.valueOf(System.currentTimeMillis()));
                com.tencent.mm.media.widget.camerarecordview.a aVar10 = this.wdk;
                if (aVar10 != null) {
                    aVar10.r(new h(this, currentTicks, ejw));
                    AppMethodBeat.o(75806);
                    return;
                }
                AppMethodBeat.o(75806);
                return;
            case 9:
                boolean z4 = bundle != null ? bundle.getBoolean("PARAM_BEAUTIFY_ENABLE") : false;
                com.tencent.mm.plugin.recordvideo.b.b bVar2 = this.BXe;
                com.tencent.mm.media.j.a previewRenderer = bVar2 != null ? bVar2.getPreviewRenderer() : null;
                if (!(previewRenderer instanceof com.tencent.mm.plugin.recordvideo.c.b)) {
                    previewRenderer = null;
                }
                this.wcV.j(new i(this, (com.tencent.mm.plugin.recordvideo.c.b) previewRenderer, z4));
                AppMethodBeat.o(75806);
                return;
            case 10:
                if (bundle != null) {
                    boolean z5 = bundle.getBoolean("PARAM_FILTER_ENABLE");
                    com.tencent.mm.plugin.recordvideo.b.b bVar3 = this.BXe;
                    com.tencent.mm.media.j.a previewRenderer2 = bVar3 != null ? bVar3.getPreviewRenderer() : null;
                    if (!(previewRenderer2 instanceof com.tencent.mm.plugin.recordvideo.c.b)) {
                        previewRenderer2 = null;
                    }
                    this.wcV.j(new j((com.tencent.mm.plugin.recordvideo.c.b) previewRenderer2, z5));
                    AppMethodBeat.o(75806);
                    return;
                }
                AppMethodBeat.o(75806);
                return;
            default:
                Log.i("MicroMsg.RecordPluginLayout", "unknown status ".concat(String.valueOf(cVar)));
                AppMethodBeat.o(75806);
                return;
        }
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t, com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
    public void onResume() {
        RecordConfigProvider recordConfigProvider;
        VideoTransPara videoTransPara;
        int i2;
        AppMethodBeat.i(75807);
        super.onResume();
        if (this.wds) {
            Context context = getContext();
            if (context == null) {
                t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(75807);
                throw tVar;
            }
            oL(com.tencent.mm.pluginsdk.permission.b.e((Activity) context, "android.permission.RECORD_AUDIO"));
        }
        com.tencent.mm.plugin.mmsight.model.d dVar = this.orientationEventListener;
        if (dVar != null) {
            dVar.enable();
        }
        com.tencent.mm.media.widget.camerarecordview.a aVar = this.wdk;
        if (aVar != null) {
            List listOf = kotlin.a.j.listOf((Object[]) new Integer[]{1, 2});
            RecordConfigProvider recordConfigProvider2 = this.wdm;
            if (!(!kotlin.a.j.a((Iterable) listOf, (Object) (recordConfigProvider2 != null ? Integer.valueOf(recordConfigProvider2.scene) : null)) || (recordConfigProvider = this.wdm) == null || (videoTransPara = recordConfigProvider.BOm) == null)) {
                Log.i("MicroMsg.RecordPluginLayout", "onResume init SightRecordConfig");
                com.tencent.mm.plugin.recordvideo.b.g gVar = com.tencent.mm.plugin.recordvideo.b.g.BNx;
                RecordConfigProvider recordConfigProvider3 = this.wdm;
                if (recordConfigProvider3 != null) {
                    i2 = recordConfigProvider3.scene;
                } else {
                    i2 = 0;
                }
                com.tencent.mm.plugin.recordvideo.b.g.b(videoTransPara, i2);
            }
            this.BXc.oS(aVar.ipt);
            com.tencent.mm.media.widget.camerarecordview.a.a(aVar, false, new b(aVar), 3);
            AppMethodBeat.o(75807);
            return;
        }
        AppMethodBeat.o(75807);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t, com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
    public final void onPause() {
        AppMethodBeat.i(75808);
        super.onPause();
        Log.i("MicroMsg.RecordPluginLayout", "onPause");
        com.tencent.mm.media.widget.camerarecordview.a aVar = this.wdk;
        if (aVar != null) {
            aVar.stopPreview();
        }
        com.tencent.mm.plugin.mmsight.model.d dVar = this.orientationEventListener;
        if (dVar != null) {
            dVar.disable();
        }
        com.tencent.mm.plugin.recordvideo.d.c cVar = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        com.tencent.mm.plugin.recordvideo.d.c.VI(15);
        AppMethodBeat.o(75808);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t, com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
    public final void release() {
        AppMethodBeat.i(75809);
        super.release();
        Log.i("MicroMsg.RecordPluginLayout", "release");
        com.tencent.mm.media.widget.camerarecordview.a aVar = this.wdk;
        if (aVar != null) {
            aVar.release();
        }
        com.tencent.mm.plugin.mmsight.model.d dVar = this.orientationEventListener;
        if (dVar != null) {
            dVar.disable();
        }
        com.tencent.mm.plugin.mmsight.model.d dVar2 = this.orientationEventListener;
        if (dVar2 != null) {
            dVar2.a(null);
        }
        this.orientationEventListener = null;
        RecordConfigProvider recordConfigProvider = this.wdm;
        if (recordConfigProvider != null) {
            if (!recordConfigProvider.BOx) {
                com.tencent.f.h.RTc.aX(new f(this));
            }
            AppMethodBeat.o(75809);
            return;
        }
        AppMethodBeat.o(75809);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class f implements Runnable {
        final /* synthetic */ RecordPluginLayout BXg;

        f(RecordPluginLayout recordPluginLayout) {
            this.BXg = recordPluginLayout;
        }

        public final void run() {
            String str;
            String str2 = null;
            AppMethodBeat.i(237409);
            RecordConfigProvider configProvider = this.BXg.getConfigProvider();
            if (configProvider != null) {
                str = configProvider.BOz;
            } else {
                str = null;
            }
            s.deleteFile(str);
            RecordConfigProvider configProvider2 = this.BXg.getConfigProvider();
            if (configProvider2 != null) {
                str2 = configProvider2.BOB;
            }
            s.deleteFile(str2);
            AppMethodBeat.o(237409);
        }
    }

    @Override // com.tencent.mm.plugin.mmsight.model.d.a
    public void onOrientationChange(int i2) {
        float f2;
        AppMethodBeat.i(75810);
        if (i2 < 0) {
            AppMethodBeat.o(75810);
            return;
        }
        if (i2 != 90 && i2 != 270) {
            f2 = (float) i2;
        } else if (i2 == 270) {
            f2 = 90.0f;
        } else {
            f2 = -90.0f;
        }
        this.wcY.bN(f2);
        AppMethodBeat.o(75810);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t, com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
    public final void onDetach() {
        AppMethodBeat.i(75811);
        super.onDetach();
        Log.i("MicroMsg.RecordPluginLayout", "onDetach");
        com.tencent.mm.media.widget.camerarecordview.a aVar = this.wdk;
        if (aVar != null) {
            aVar.stopPreview();
            AppMethodBeat.o(75811);
            return;
        }
        AppMethodBeat.o(75811);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t, com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(237412);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        Log.i("MicroMsg.RecordPluginLayout", "onRequestPermissionsResult requestCode:" + i2 + " permissions:" + strArr + " grantResults:" + iArr);
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 == 80) {
            if (iArr[0] == 0) {
                oL(true);
                AppMethodBeat.o(237412);
                return;
            }
            com.tencent.mm.ui.base.h.a(getContext(), com.tencent.mm.cb.a.aI(getContext(), R.string.fvk), com.tencent.mm.cb.a.aI(getContext(), R.string.fvm), com.tencent.mm.cb.a.aI(getContext(), R.string.fvl), com.tencent.mm.cb.a.aI(getContext(), R.string.fvj), false, (DialogInterface.OnClickListener) new d(this), (DialogInterface.OnClickListener) new e(this));
        }
        AppMethodBeat.o(237412);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    static final class d implements DialogInterface.OnClickListener {
        final /* synthetic */ RecordPluginLayout BXg;

        d(RecordPluginLayout recordPluginLayout) {
            this.BXg = recordPluginLayout;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(237407);
            dialogInterface.dismiss();
            this.BXg.wds = true;
            Context context = this.BXg.getContext();
            if (context == null) {
                t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(237407);
                throw tVar;
            }
            Activity activity = (Activity) context;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/recordvideo/plugin/parent/RecordPluginLayout$onRequestPermissionsResult$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            activity.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/recordvideo/plugin/parent/RecordPluginLayout$onRequestPermissionsResult$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(237407);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    static final class e implements DialogInterface.OnClickListener {
        final /* synthetic */ RecordPluginLayout BXg;

        e(RecordPluginLayout recordPluginLayout) {
            this.BXg = recordPluginLayout;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(237408);
            dialogInterface.dismiss();
            RecordPluginLayout.c(this.BXg);
            AppMethodBeat.o(237408);
        }
    }

    private final void oL(boolean z) {
        boolean z2;
        AppMethodBeat.i(237413);
        com.tencent.mm.plugin.recordvideo.b.b bVar = this.BXe;
        if (bVar != null) {
            if (!z) {
                z2 = true;
            } else {
                z2 = false;
            }
            bVar.isb = z2;
        }
        com.tencent.mm.media.widget.camerarecordview.a aVar = this.wdk;
        if (aVar != null) {
            aVar.aQf();
        }
        if (z) {
            this.wcW.eKG();
            AppMethodBeat.o(237413);
            return;
        }
        this.wcW.c(new k(this));
        AppMethodBeat.o(237413);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class k implements View.OnClickListener {
        final /* synthetic */ RecordPluginLayout BXg;

        k(RecordPluginLayout recordPluginLayout) {
            this.BXg = recordPluginLayout;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(237411);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/plugin/parent/RecordPluginLayout$updateRecordTipByAudioPermission$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.BXg.wds = true;
            Context context = this.BXg.getContext();
            if (context == null) {
                t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(237411);
                throw tVar;
            }
            Activity activity = (Activity) context;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/recordvideo/plugin/parent/RecordPluginLayout$updateRecordTipByAudioPermission$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            activity.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/recordvideo/plugin/parent/RecordPluginLayout$updateRecordTipByAudioPermission$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/parent/RecordPluginLayout$updateRecordTipByAudioPermission$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(237411);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class i extends q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ RecordPluginLayout BXg;
        final /* synthetic */ boolean hLa;
        final /* synthetic */ com.tencent.mm.plugin.recordvideo.c.b wdx;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(RecordPluginLayout recordPluginLayout, com.tencent.mm.plugin.recordvideo.c.b bVar, boolean z) {
            super(0);
            this.BXg = recordPluginLayout;
            this.wdx = bVar;
            this.hLa = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            XEffectConfig xEffectConfig;
            com.tencent.mm.plugin.recordvideo.c.b bVar;
            AppMethodBeat.i(182854);
            RecordConfigProvider configProvider = this.BXg.getConfigProvider();
            if (!(configProvider == null || (xEffectConfig = configProvider.BOJ) == null || (bVar = this.wdx) == null)) {
                bVar.a(xEffectConfig);
            }
            com.tencent.mm.plugin.recordvideo.c.b bVar2 = this.wdx;
            if (bVar2 != null) {
                bVar2.ti(this.hLa);
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(182854);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class j extends q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ boolean hLa;
        final /* synthetic */ com.tencent.mm.plugin.recordvideo.c.b wdx;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(com.tencent.mm.plugin.recordvideo.c.b bVar, boolean z) {
            super(0);
            this.wdx = bVar;
            this.hLa = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            com.tencent.mm.plugin.xlabeffect.b bVar;
            AppMethodBeat.i(182855);
            com.tencent.mm.plugin.recordvideo.c.b bVar2 = this.wdx;
            if (!(bVar2 == null || (bVar = bVar2.hiH) == null)) {
                com.tencent.mm.plugin.xlabeffect.b.a(bVar, this.hLa);
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(182855);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(RecordPluginLayout recordPluginLayout, com.tencent.mm.media.widget.camerarecordview.b.b bVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        com.tencent.mm.ab.i iVar;
        String str;
        int i7;
        int i8 = -1;
        AppMethodBeat.i(237414);
        Log.d("MicroMsg.RecordPluginLayout", "onStopRecord, capture:".concat(String.valueOf(bVar)));
        com.tencent.mm.plugin.recordvideo.d.c cVar = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        com.tencent.mm.media.widget.camerarecordview.a aVar = recordPluginLayout.wdk;
        if (aVar == null || !aVar.ipt) {
            i2 = 1;
        } else {
            i2 = 2;
        }
        com.tencent.mm.plugin.recordvideo.d.c.x("KEY_MEDIA_SOURCE_INT", Integer.valueOf(i2));
        int i9 = bVar.iqg - bVar.dvv;
        RecordConfigProvider recordConfigProvider = recordPluginLayout.wdm;
        if (recordConfigProvider != null) {
            i3 = recordConfigProvider.BOv;
        } else {
            i3 = 0;
        }
        RecordConfigProvider recordConfigProvider2 = recordPluginLayout.wdm;
        if (recordConfigProvider2 == null || recordConfigProvider2.scene != 14 || i9 >= i3 || i3 <= 0) {
            com.tencent.mm.plugin.recordvideo.activity.a aVar2 = recordPluginLayout.wdl;
            if (aVar2 != null) {
                aVar2.a(2, bVar);
            }
        } else {
            com.tencent.mm.media.widget.camerarecordview.a aVar3 = recordPluginLayout.wdk;
            if (aVar3 != null) {
                com.tencent.mm.media.widget.c.b bVar2 = aVar3.ipr;
                if (bVar2 == null || (str = bVar2.getFilePath()) == null) {
                    str = "";
                }
            } else {
                str = null;
            }
            Log.i("MicroMsg.RecordPluginLayout", "music scene stop duration not enough, videoPath:" + str + ", fileExist:" + s.YS(str));
            com.tencent.mm.plugin.recordvideo.e.c cVar2 = com.tencent.mm.plugin.recordvideo.e.c.Cic;
            com.tencent.mm.plugin.recordvideo.e.c.aLJ(str);
            w wVar = recordPluginLayout.wcW;
            RecordConfigProvider recordConfigProvider3 = recordPluginLayout.wdm;
            if (recordConfigProvider3 != null) {
                i7 = recordConfigProvider3.BOv;
            } else {
                i7 = 1000;
            }
            Context context = wVar.zCQ.getContext();
            com.tencent.mm.ui.base.h.a(context, context.getString(R.string.fwq, Integer.valueOf((int) (((float) i7) / 1000.0f))), "", context.getString(R.string.fwm), w.j.BRI);
            com.tencent.mm.media.widget.camerarecordview.a aVar4 = recordPluginLayout.wdk;
            if (aVar4 != null) {
                aVar4.aQf();
            }
            recordPluginLayout.wcW.reset();
        }
        com.tencent.mm.media.k.e eVar = com.tencent.mm.media.k.e.ilC;
        String str2 = bVar.iqd;
        RecordConfigProvider recordConfigProvider4 = recordPluginLayout.wdm;
        if (recordConfigProvider4 != null) {
            i4 = recordConfigProvider4.BOi;
        } else {
            i4 = 1;
        }
        RecordConfigProvider recordConfigProvider5 = recordPluginLayout.wdm;
        if (recordConfigProvider5 != null) {
            i5 = recordConfigProvider5.ilT;
        } else {
            i5 = -1;
        }
        com.tencent.mm.media.k.e.n(str2, i4, i5);
        String str3 = bVar.iqd;
        RecordConfigProvider recordConfigProvider6 = recordPluginLayout.wdm;
        if (recordConfigProvider6 != null) {
            i6 = recordConfigProvider6.BOi;
        } else {
            i6 = 1;
        }
        RecordConfigProvider recordConfigProvider7 = recordPluginLayout.wdm;
        if (recordConfigProvider7 != null) {
            i8 = recordConfigProvider7.scene;
        }
        com.tencent.mm.plugin.mmsight.model.l.au(str3, i6, i8);
        com.tencent.mm.plugin.recordvideo.d.c cVar3 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        com.tencent.mm.plugin.recordvideo.d.c.eKX().rz((long) (bVar.iqg - bVar.dvv));
        com.tencent.mm.plugin.recordvideo.d.c cVar4 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        jf eKX = com.tencent.mm.plugin.recordvideo.d.c.eKX();
        com.tencent.mm.media.widget.camerarecordview.a aVar5 = recordPluginLayout.wdk;
        eKX.rA((aVar5 == null || !aVar5.ipt) ? 1 : 2);
        com.tencent.mm.plugin.recordvideo.d.g gVar = com.tencent.mm.plugin.recordvideo.d.g.BXY;
        com.tencent.mm.media.widget.camerarecordview.a aVar6 = recordPluginLayout.wdk;
        if (aVar6 != null) {
            iVar = aVar6.ipG;
        } else {
            iVar = null;
        }
        com.tencent.mm.plugin.recordvideo.d.g.b(iVar);
        AppMethodBeat.o(237414);
    }
}
