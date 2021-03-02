package com.tencent.mm.plugin.finder.video.develop;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.g.b.a.jf;
import com.tencent.mm.media.widget.camerarecordview.b.b;
import com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLSurfaceView;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.finder.report.y;
import com.tencent.mm.plugin.finder.video.plugin.view.RecordTypeSelectView;
import com.tencent.mm.plugin.finder.video.plugin.view.SubRecordFinishView;
import com.tencent.mm.plugin.gallery.model.GalleryItem;
import com.tencent.mm.plugin.mmsight.model.d;
import com.tencent.mm.plugin.recordvideo.activity.MMRecordUI;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.XEffectConfig;
import com.tencent.mm.plugin.recordvideo.plugin.aa;
import com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.progress.HorizontalSubProgressBar;
import com.tencent.mm.plugin.recordvideo.plugin.w;
import com.tencent.mm.plugin.recordvideo.plugin.z;
import com.tencent.mm.protocal.protobuf.chz;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sticker.f;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.vfs.s;
import com.tencent.smtt.sdk.WebView;
import java.io.IOException;
import java.util.ArrayList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 K2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001KB\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u00105\u001a\u000206H\u0002J\u0018\u00107\u001a\u0002062\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u00108\u001a\u0002062\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\b\u0010;\u001a\u00020<H\u0016J\b\u0010=\u001a\u000206H\u0016J\u0010\u0010>\u001a\u0002062\u0006\u0010?\u001a\u00020\u001bH\u0016J\b\u0010@\u001a\u000206H\u0016J\b\u0010A\u001a\u000206H\u0016J\b\u0010B\u001a\u000206H\u0016J\u0010\u0010C\u001a\u0002062\u0006\u0010D\u001a\u00020EH\u0002J\u001a\u0010F\u001a\u0002062\u0006\u0010G\u001a\u00020H2\b\u0010I\u001a\u0004\u0018\u00010JH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u000e¢\u0006\u0002\n\u0000¨\u0006L"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/develop/DevFinderRecordPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener$OrienChangeCallback;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "beautifyPlugin", "Lcom/tencent/mm/plugin/finder/video/plugin/FinderRecordBeautifyPlugin;", "cameraSwitchPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/RecordSwitchCameraPlugin;", "closePlugin", "Lcom/tencent/mm/plugin/finder/video/plugin/FinderRecordClosePlugin;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "effectLayout", "Landroid/view/ViewGroup;", "horizontalSubProgressPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/progress/HorizontalSubProgressPlugin;", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "orientationEventListener", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener;", "previewBottomProvider", "Lkotlin/Function0;", "", "previewPlugin", "Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;", "process", "Lcom/tencent/mm/plugin/finder/video/FinderCameraContainerProcess;", "recordController", "Lcom/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer;", "recordEditRootView", "recordFeatureView", "Landroid/view/View;", "recordPathPlugin", "Lcom/tencent/mm/plugin/finder/video/plugin/FinderSubVideoFilePlugin;", "recordPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/RecordButtonPlugin;", "selectTypePlugin", "Lcom/tencent/mm/plugin/finder/video/plugin/subvideo/FinderRecordTypePlugin;", "stickerPlugin", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectPlugin;", "subRecordDeletePlugin", "Lcom/tencent/mm/plugin/finder/video/plugin/FinderSubRecordDeletePlugin;", "subRecordFinishPlugin", "Lcom/tencent/mm/plugin/finder/video/plugin/FinderSubRecordFinishPlugin;", "touchFocusPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/RecordFocusPlugin;", "util", "Lcom/tencent/mm/plugin/finder/video/plugin/util/FinderLayoutUtil;", "initConfig", "", "initLogic", "loadCurrentPage", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "onBackPress", "", "onDetach", "onOrientationChange", "orientation", "onPause", "onResume", "release", "setPreviewRatio", "ratio", "", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-finder_release"})
public final class DevFinderRecordPluginLayout extends BasePluginLayout implements d.a, com.tencent.mm.plugin.recordvideo.plugin.parent.d {
    public static final a wgy = new a((byte) 0);
    private com.tencent.mm.plugin.mmsight.model.d orientationEventListener;
    private final ViewGroup wcU;
    private final CameraPreviewGLSurfaceView wcV;
    private final w wcW;
    private final com.tencent.mm.plugin.finder.video.plugin.c wcX;
    private final aa wcY;
    private final z wcZ;
    private final com.tencent.mm.plugin.finder.video.plugin.b wda;
    private final com.tencent.mm.plugin.recordvideo.plugin.progress.a wdb;
    private final com.tencent.mm.plugin.finder.video.plugin.subvideo.a wdc;
    private final com.tencent.mm.plugin.finder.video.plugin.e wdd;
    private final com.tencent.mm.plugin.finder.video.plugin.d wde;
    private final View wdi;
    private com.tencent.mm.plugin.finder.video.a wdj;
    private com.tencent.mm.media.widget.camerarecordview.a wdk;
    private com.tencent.mm.plugin.recordvideo.activity.a wdl;
    private RecordConfigProvider wdm;
    private com.tencent.mm.plugin.finder.video.plugin.f wdn = new com.tencent.mm.plugin.finder.video.plugin.f(this);
    private com.tencent.mm.plugin.finder.video.plugin.util.a wdp = new com.tencent.mm.plugin.finder.video.plugin.util.a();
    private final kotlin.g.a.a<Integer> wdq;
    private final com.tencent.mm.plugin.finder.video.sticker.g wgw;
    private ViewGroup wgx;

    static {
        AppMethodBeat.i(254440);
        AppMethodBeat.o(254440);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "succ", "", "invoke"})
    static final class b extends q implements kotlin.g.a.b<Boolean, x> {
        public static final b wgA = new b();

        static {
            AppMethodBeat.i(254421);
            AppMethodBeat.o(254421);
        }

        b() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            AppMethodBeat.i(254420);
            Log.i("Finder.FinderRecordPluginLayout", "startPreview finish:".concat(String.valueOf(bool.booleanValue())));
            x xVar = x.SXb;
            AppMethodBeat.o(254420);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "capture", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "invoke"})
    static final class e extends q implements kotlin.g.a.b<com.tencent.mm.media.widget.camerarecordview.b.b, x> {
        final /* synthetic */ Bundle uxC;
        final /* synthetic */ DevFinderRecordPluginLayout wgz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(DevFinderRecordPluginLayout devFinderRecordPluginLayout, Bundle bundle) {
            super(1);
            this.wgz = devFinderRecordPluginLayout;
            this.uxC = bundle;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(com.tencent.mm.media.widget.camerarecordview.b.b bVar) {
            int i2;
            int i3;
            long j2;
            int i4 = -1;
            boolean z = false;
            AppMethodBeat.i(254425);
            com.tencent.mm.media.widget.camerarecordview.b.b bVar2 = bVar;
            p.h(bVar2, "capture");
            this.wgz.wdn.bw(bVar2.iqd, this.wgz.wda.dFS());
            if (this.wgz.wdc.whp) {
                com.tencent.mm.plugin.recordvideo.d.c cVar = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                com.tencent.mm.plugin.recordvideo.d.c.aLu("KEY_SUB_VIDEO_RECORD_SUCCESS_INT");
                Bundle bundle = this.uxC;
                if (bundle == null || !bundle.getBoolean("PARAM_1_BOOLEAN")) {
                    this.wgz.wcW.td(false);
                    this.wgz.wcW.reset();
                    com.tencent.mm.media.widget.camerarecordview.a aVar = this.wgz.wdk;
                    if (aVar != null) {
                        aVar.aQf();
                    }
                    this.wgz.wdd.setVisibility(0);
                    this.wgz.wde.setVisibility(0);
                } else {
                    Log.i("Finder.FinderRecordPluginLayout", "sub record finish");
                    y yVar = y.vih;
                    y.Q(191, 1);
                    d.b.a(this.wgz, d.c.BUx);
                }
            } else {
                y yVar2 = y.vih;
                y.Q(211, 1);
                y yVar3 = y.vih;
                com.tencent.mm.media.widget.camerarecordview.a aVar2 = this.wgz.wdk;
                if (aVar2 != null && aVar2.ipt) {
                    z = true;
                }
                y.ot(z);
                if (this.wgz.wda.dFS()) {
                    y yVar4 = y.vih;
                    y.Q(215, 1);
                }
                y yVar5 = y.vih;
                y.Fo((long) bVar2.iqg);
                d.b.a(this.wgz, d.c.BUx);
                com.tencent.mm.plugin.recordvideo.d.c cVar2 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                com.tencent.mm.media.widget.camerarecordview.a aVar3 = this.wgz.wdk;
                com.tencent.mm.plugin.recordvideo.d.c.x("KEY_MEDIA_SOURCE_INT", Integer.valueOf((aVar3 == null || !aVar3.ipt) ? 1 : 2));
                com.tencent.mm.media.k.e eVar = com.tencent.mm.media.k.e.ilC;
                String str = bVar2.iqd;
                RecordConfigProvider recordConfigProvider = this.wgz.wdm;
                if (recordConfigProvider != null) {
                    i2 = recordConfigProvider.BOi;
                } else {
                    i2 = 1;
                }
                RecordConfigProvider recordConfigProvider2 = this.wgz.wdm;
                com.tencent.mm.media.k.e.n(str, i2, recordConfigProvider2 != null ? recordConfigProvider2.ilT : -1);
                String str2 = bVar2.iqd;
                RecordConfigProvider recordConfigProvider3 = this.wgz.wdm;
                if (recordConfigProvider3 != null) {
                    i3 = recordConfigProvider3.BOi;
                } else {
                    i3 = 1;
                }
                RecordConfigProvider recordConfigProvider4 = this.wgz.wdm;
                if (recordConfigProvider4 != null) {
                    i4 = recordConfigProvider4.scene;
                }
                com.tencent.mm.plugin.mmsight.model.l.au(str2, i3, i4);
                com.tencent.mm.plugin.recordvideo.d.c cVar3 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                com.tencent.mm.plugin.recordvideo.d.c.eKX().rz((long) (bVar2.iqg - bVar2.dvv));
                com.tencent.mm.plugin.recordvideo.d.c cVar4 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                jf eKX = com.tencent.mm.plugin.recordvideo.d.c.eKX();
                com.tencent.mm.media.widget.camerarecordview.a aVar4 = this.wgz.wdk;
                if (aVar4 == null || !aVar4.ipt) {
                    j2 = 1;
                } else {
                    j2 = 2;
                }
                eKX.rA(j2);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(254425);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/graphics/Bitmap;", "invoke"})
    static final class f extends q implements kotlin.g.a.b<Bitmap, x> {
        final /* synthetic */ long qVz;
        final /* synthetic */ float wdA;
        final /* synthetic */ DevFinderRecordPluginLayout wgz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(DevFinderRecordPluginLayout devFinderRecordPluginLayout, long j2, float f2) {
            super(1);
            this.wgz = devFinderRecordPluginLayout;
            this.qVz = j2;
            this.wdA = f2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Bitmap bitmap) {
            Bitmap bitmap2;
            boolean z;
            boolean z2;
            int i2 = 1;
            AppMethodBeat.i(254426);
            Bitmap bitmap3 = bitmap;
            long ticksToNow = Util.ticksToNow(this.qVz);
            Log.i("Finder.FinderRecordPluginLayout", "photo time cost : ".concat(String.valueOf(ticksToNow)));
            com.tencent.mm.media.k.e eVar = com.tencent.mm.media.k.e.ilC;
            com.tencent.mm.media.k.e.aNN();
            com.tencent.mm.media.k.e eVar2 = com.tencent.mm.media.k.e.ilC;
            com.tencent.mm.media.k.e.zK(ticksToNow);
            if (bitmap3 != null) {
                com.tencent.mm.media.widget.camerarecordview.a aVar = this.wgz.wdk;
                if (aVar != null) {
                    aVar.stopPreview();
                }
                Log.i("Finder.FinderRecordPluginLayout", "orientation : " + this.wdA);
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
                y yVar = y.vih;
                y.Q(200, 1);
                y yVar2 = y.vih;
                com.tencent.mm.media.widget.camerarecordview.a aVar2 = this.wgz.wdk;
                if (aVar2 == null || !aVar2.ipt) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                y.os(z2);
                if (this.wgz.wda.dFS()) {
                    y yVar3 = y.vih;
                    y.Q(203, 1);
                }
                RecordConfigProvider recordConfigProvider = this.wgz.wdm;
                if (recordConfigProvider != null) {
                    try {
                        BitmapUtil.saveBitmapToImage(bitmap2, 100, Bitmap.CompressFormat.JPEG, recordConfigProvider.BOB, true);
                        Log.i("Finder.FinderRecordPluginLayout", "save picture in " + recordConfigProvider.BOB + "  cost: " + Util.ticksToNow(currentTicks));
                        b.a aVar3 = com.tencent.mm.media.widget.camerarecordview.b.b.iqq;
                        String str = recordConfigProvider.BOB;
                        p.g(str, "this.inputPhotoPath");
                        com.tencent.mm.media.widget.camerarecordview.b.b Hz = b.a.Hz(str);
                        Hz.iqo = z;
                        Bundle bundle = new Bundle();
                        GalleryItem.MediaItem a3 = GalleryItem.MediaItem.a(1, 0, recordConfigProvider.BOB, "", "");
                        a3.xja = System.currentTimeMillis();
                        bundle.putParcelableArrayList("media_list", j.ac(a3));
                        RecordConfigProvider recordConfigProvider2 = this.wgz.wdm;
                        if (recordConfigProvider2 != null) {
                            recordConfigProvider2.jkf = bundle;
                        }
                        com.tencent.mm.plugin.recordvideo.activity.a aVar4 = this.wgz.wdl;
                        if (aVar4 != null) {
                            aVar4.a(1, Hz);
                        }
                    } catch (IOException e2) {
                        com.tencent.mm.media.widget.camerarecordview.a aVar5 = this.wgz.wdk;
                        if (aVar5 != null) {
                            com.tencent.mm.media.widget.camerarecordview.a.a(aVar5, false, null, 7);
                        }
                        com.tencent.mm.media.k.e eVar3 = com.tencent.mm.media.k.e.ilC;
                        com.tencent.mm.media.k.e.aNT();
                    }
                }
            }
            com.tencent.mm.plugin.recordvideo.d.c cVar = com.tencent.mm.plugin.recordvideo.d.c.BXI;
            com.tencent.mm.media.widget.camerarecordview.a aVar6 = this.wgz.wdk;
            if (aVar6 != null && aVar6.ipt) {
                i2 = 2;
            }
            com.tencent.mm.plugin.recordvideo.d.c.x("KEY_MEDIA_SOURCE_INT", Integer.valueOf(i2));
            if (bitmap3 == null) {
                com.tencent.mm.media.k.e eVar4 = com.tencent.mm.media.k.e.ilC;
                com.tencent.mm.media.k.e.aNO();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(254426);
            return xVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DevFinderRecordPluginLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(254439);
        this.orientationEventListener = new com.tencent.mm.plugin.mmsight.model.d(context, (byte) 0);
        LayoutInflater.from(context).inflate(R.layout.zl, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.d2x);
        p.g(findViewById, "findViewById(R.id.finder_record_edit_layout_root)");
        this.wgx = (ViewGroup) findViewById;
        View findViewById2 = findViewById(R.id.d2y);
        p.g(findViewById2, "findViewById(R.id.finder_record_layout)");
        this.wcU = (ViewGroup) findViewById2;
        View findViewById3 = findViewById(R.id.if9);
        p.g(findViewById3, "findViewById(R.id.switch_camera)");
        this.wcY = new aa((ImageView) findViewById3, this);
        View findViewById4 = findViewById(R.id.b4k);
        p.g(findViewById4, "findViewById(R.id.close_plugin)");
        this.wcX = new com.tencent.mm.plugin.finder.video.plugin.c((WeImageView) findViewById4, this);
        this.wcZ = new z(this, this);
        View findViewById5 = findViewById(R.id.gxe);
        p.g(findViewById5, "findViewById(R.id.record_plugin)");
        this.wcW = new w((RelativeLayout) findViewById5, this);
        View findViewById6 = findViewById(R.id.d1e);
        p.g(findViewById6, "findViewById(R.id.finder_preview_plugin)");
        this.wcV = (CameraPreviewGLSurfaceView) findViewById6;
        View findViewById7 = findViewById(R.id.gxq);
        p.g(findViewById7, "findViewById(R.id.record_type_view)");
        this.wdc = new com.tencent.mm.plugin.finder.video.plugin.subvideo.a((RecordTypeSelectView) findViewById7, this);
        View findViewById8 = findViewById(R.id.a2p);
        p.g(findViewById8, "findViewById(R.id.beauty_effect_parent)");
        this.wda = new com.tencent.mm.plugin.finder.video.plugin.b((ViewGroup) findViewById8, this, this.wcV);
        SubRecordFinishView subRecordFinishView = new SubRecordFinishView(context, null);
        subRecordFinishView.setVisibility(4);
        ((FrameLayout) findViewById(R.id.h77)).addView(subRecordFinishView, new FrameLayout.LayoutParams(-1, -1));
        this.wdd = new com.tencent.mm.plugin.finder.video.plugin.e(subRecordFinishView, this);
        View findViewById9 = findViewById(R.id.bmj);
        p.g(findViewById9, "findViewById(R.id.delete_sub_video)");
        this.wde = new com.tencent.mm.plugin.finder.video.plugin.d((WeImageView) findViewById9, this);
        View findViewById10 = findViewById(R.id.glg);
        p.g(findViewById10, "findViewById(R.id.progress_horizontal)");
        this.wdb = new com.tencent.mm.plugin.recordvideo.plugin.progress.a((HorizontalSubProgressBar) findViewById10, this);
        this.wcW.BRz = new kotlin.g.a.b<ArrayList<Float>, x>(this) {
            /* class com.tencent.mm.plugin.finder.video.develop.DevFinderRecordPluginLayout.AnonymousClass1 */
            final /* synthetic */ DevFinderRecordPluginLayout wgz;

            {
                this.wgz = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(ArrayList<Float> arrayList) {
                AppMethodBeat.i(254417);
                ArrayList<Float> arrayList2 = arrayList;
                p.h(arrayList2, LocaleUtil.ITALIAN);
                this.wgz.wdb.aJ(arrayList2);
                x xVar = x.SXb;
                AppMethodBeat.o(254417);
                return xVar;
            }
        };
        this.wdq = new kotlin.g.a.a<Integer>(this) {
            /* class com.tencent.mm.plugin.finder.video.develop.DevFinderRecordPluginLayout.AnonymousClass2 */
            final /* synthetic */ DevFinderRecordPluginLayout wgz;

            {
                this.wgz = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ Integer invoke() {
                AppMethodBeat.i(254418);
                Integer valueOf = Integer.valueOf(this.wgz.getHeight() - this.wgz.wcV.getBottom());
                AppMethodBeat.o(254418);
                return valueOf;
            }
        };
        this.wgw = new com.tencent.mm.plugin.finder.video.sticker.g(this, this, this.wdq);
        View findViewById11 = findViewById(R.id.d2y);
        p.g(findViewById11, "findViewById(R.id.finder_record_layout)");
        this.wdi = findViewById11;
        getPluginList().add(this.wcW);
        getPluginList().add(this.wcX);
        getPluginList().add(this.wcY);
        getPluginList().add(this.wcZ);
        getPluginList().add(this.wdc);
        getPluginList().add(this.wdn);
        getPluginList().add(this.wgw);
        com.tencent.mm.plugin.mmsight.model.d dVar = this.orientationEventListener;
        if (dVar != null) {
            dVar.a(this);
        }
        com.tencent.mm.plugin.mmsight.model.d dVar2 = this.orientationEventListener;
        if (dVar2 != null) {
            dVar2.enable();
            AppMethodBeat.o(254439);
            return;
        }
        AppMethodBeat.o(254439);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/develop/DevFinderRecordPluginLayout$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
    public final void a(com.tencent.mm.plugin.recordvideo.activity.a aVar, RecordConfigProvider recordConfigProvider) {
        AppMethodBeat.i(254428);
        p.h(aVar, "navigator");
        p.h(recordConfigProvider, "configProvider");
        this.wdm = recordConfigProvider;
        this.wdj = new com.tencent.mm.plugin.finder.video.a(recordConfigProvider, this.wcV);
        cMT();
        setPreviewRatio(recordConfigProvider.BOn.gLT);
        setBackgroundColor(WebView.NIGHT_MODE_COLOR);
        this.wdl = aVar;
        this.wdm = recordConfigProvider;
        com.tencent.mm.plugin.finder.video.a aVar2 = this.wdj;
        if (aVar2 == null) {
            p.hyc();
        }
        this.wdk = new com.tencent.mm.media.widget.camerarecordview.a(aVar2);
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
            com.tencent.mm.media.widget.camerarecordview.a aVar5 = this.wdk;
            if (aVar5 != null) {
                aVar5.zU(1000);
            }
        }
        this.wcZ.a(recordConfigProvider);
        this.wcW.a(recordConfigProvider);
        this.wcX.a(recordConfigProvider);
        this.wda.a(recordConfigProvider);
        this.wdn.a(recordConfigProvider);
        StringBuilder append = new StringBuilder("configProvider:").append(recordConfigProvider).append(", config:");
        com.tencent.mm.plugin.recordvideo.b.g gVar = com.tencent.mm.plugin.recordvideo.b.g.BNx;
        Log.i("Finder.FinderRecordPluginLayout", append.append(com.tencent.mm.plugin.recordvideo.b.g.eJx()).toString());
        AppMethodBeat.o(254428);
    }

    private final void setPreviewRatio(float f2) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(254429);
        Context context = MMApplicationContext.getContext();
        p.g(context, "MMApplicationContext.getContext()");
        Resources resources = context.getResources();
        p.g(resources, "MMApplicationContext.getContext().resources");
        int i2 = resources.getDisplayMetrics().widthPixels;
        int i3 = (int) (((float) i2) / f2);
        Log.i("Finder.FinderRecordPluginLayout", "[setPreviewSize] width=" + i2 + " height=" + i3);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i2, i3);
        com.tencent.mm.plugin.finder.video.plugin.util.a aVar = this.wdp;
        Context context2 = getContext();
        Float valueOf = Float.valueOf(f2);
        if (valueOf == null || context2 == null) {
            z = aVar.whs;
        } else {
            Context context3 = MMApplicationContext.getContext();
            p.g(context3, "MMApplicationContext.getContext()");
            Resources resources2 = context3.getResources();
            p.g(resources2, "MMApplicationContext.getContext().resources");
            int i4 = resources2.getDisplayMetrics().widthPixels;
            int aD = au.az(context2).y - au.aD(context2);
            Log.i(aVar.TAG, "screen width:" + i4 + " height:" + aD + " ratio:" + valueOf + " preview height" + (((float) i4) / valueOf.floatValue()));
            float floatValue = ((float) aD) - (((float) i4) / valueOf.floatValue());
            Log.i(aVar.TAG, "screen - video height,left: ".concat(String.valueOf(floatValue)));
            int e2 = com.tencent.mm.view.d.e(MMApplicationContext.getContext(), 320.0f);
            float f3 = floatValue - ((float) e2);
            Log.i(aVar.TAG, "screen - operationHeight,left: " + f3 + " operationHeight:" + e2);
            if (f3 < 0.0f) {
                z2 = true;
            } else {
                z2 = false;
            }
            aVar.whs = z2;
            z = aVar.whs;
        }
        if (z) {
            layoutParams.topMargin = 0;
            layoutParams.removeRule(2);
        } else {
            layoutParams.topMargin = com.tencent.mm.cb.a.aG(getContext(), R.dimen.a5c);
        }
        this.wcV.setLayoutParams(layoutParams);
        AppMethodBeat.o(254429);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t, com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
    public final void onResume() {
        AppMethodBeat.i(254430);
        super.onResume();
        cMT();
        com.tencent.mm.plugin.mmsight.model.d dVar = this.orientationEventListener;
        if (dVar != null) {
            dVar.enable();
        }
        com.tencent.mm.media.widget.camerarecordview.a aVar = this.wdk;
        if (aVar != null) {
            this.wda.oS(aVar.ipt);
            com.tencent.mm.media.widget.camerarecordview.a.a(aVar, false, b.wgA, 3);
            AppMethodBeat.o(254430);
            return;
        }
        AppMethodBeat.o(254430);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t, com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
    public final void onPause() {
        AppMethodBeat.i(254431);
        super.onPause();
        Log.i("Finder.FinderRecordPluginLayout", "onPause");
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
        AppMethodBeat.o(254431);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t, com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
    public final void release() {
        AppMethodBeat.i(254432);
        super.release();
        Log.i("Finder.FinderRecordPluginLayout", "release");
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
                h.RTc.aZ(new c(this));
            }
            AppMethodBeat.o(254432);
            return;
        }
        AppMethodBeat.o(254432);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ DevFinderRecordPluginLayout wgz;

        c(DevFinderRecordPluginLayout devFinderRecordPluginLayout) {
            this.wgz = devFinderRecordPluginLayout;
        }

        public final void run() {
            AppMethodBeat.i(254422);
            RecordConfigProvider recordConfigProvider = this.wgz.wdm;
            s.deleteFile(recordConfigProvider != null ? recordConfigProvider.BOB : null);
            com.tencent.mm.plugin.recordvideo.e.c cVar = com.tencent.mm.plugin.recordvideo.e.c.Cic;
            s.deleteDir(com.tencent.mm.plugin.recordvideo.e.c.eMJ());
            AppMethodBeat.o(254422);
        }
    }

    @Override // com.tencent.mm.plugin.mmsight.model.d.a
    public final void onOrientationChange(int i2) {
        float f2;
        AppMethodBeat.i(254433);
        if (i2 < 0) {
            AppMethodBeat.o(254433);
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
        AppMethodBeat.o(254433);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t, com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
    public final void onDetach() {
        AppMethodBeat.i(254434);
        super.onDetach();
        Log.i("Finder.FinderRecordPluginLayout", "onDetach");
        com.tencent.mm.media.widget.camerarecordview.a aVar = this.wdk;
        if (aVar != null) {
            aVar.stopPreview();
            AppMethodBeat.o(254434);
            return;
        }
        AppMethodBeat.o(254434);
    }

    private final void cMT() {
        VideoTransPara videoTransPara;
        AppMethodBeat.i(254435);
        RecordConfigProvider recordConfigProvider = this.wdm;
        if (recordConfigProvider == null || (videoTransPara = recordConfigProvider.BOm) == null) {
            AppMethodBeat.o(254435);
            return;
        }
        Log.i("Finder.FinderRecordPluginLayout", "onResume init SightRecordConfig");
        com.tencent.mm.plugin.recordvideo.b.g gVar = com.tencent.mm.plugin.recordvideo.b.g.BNx;
        com.tencent.mm.plugin.recordvideo.b.g.a(videoTransPara, 0, false);
        AppMethodBeat.o(254435);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.parent.d
    public final void a(d.c cVar, Bundle bundle) {
        com.tencent.mm.sticker.f bit;
        float f2;
        boolean z;
        long j2;
        boolean z2;
        int i2;
        AppMethodBeat.i(254436);
        p.h(cVar, "status");
        Log.i("Finder.FinderRecordPluginLayout", "status : " + cVar + "  param: " + bundle);
        switch (a.$EnumSwitchMapping$0[cVar.ordinal()]) {
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
                if (aVar != null) {
                    Boolean.valueOf(aVar.j(z2, i2));
                }
                com.tencent.mm.plugin.recordvideo.b.g gVar = com.tencent.mm.plugin.recordvideo.b.g.BNx;
                com.tencent.mm.plugin.recordvideo.b.g.eJC();
                com.tencent.mm.plugin.recordvideo.d.c cVar2 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                com.tencent.mm.plugin.recordvideo.d.c.x("KEY_START_RECORD_MS_LONG", Long.valueOf(System.currentTimeMillis()));
                this.wgx.setVisibility(4);
                this.wdd.setVisibility(4);
                this.wde.setVisibility(4);
                this.wdc.setVisibility(4);
                this.wcX.setVisibility(8);
                if (this.wdc.whp) {
                    com.tencent.mm.plugin.recordvideo.d.c cVar3 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                    com.tencent.mm.plugin.recordvideo.d.c.aLu("KEY_SUB_VIDEO_RECORD_CLICK_INT");
                    y yVar = y.vih;
                    y.Q(228, 1);
                    AppMethodBeat.o(254436);
                    return;
                }
                y yVar2 = y.vih;
                y.Q(210, 1);
                AppMethodBeat.o(254436);
                return;
            case 2:
                this.wgx.setVisibility(0);
                this.wdb.BXq.eKU();
                com.tencent.mm.media.widget.camerarecordview.a aVar2 = this.wdk;
                if (aVar2 != null && !aVar2.p(new e(this, bundle))) {
                    if (this.wdc.whp) {
                        y yVar3 = y.vih;
                        y.Q(230, 1);
                        this.wcW.QS(this.wdn.wha.size());
                        this.wdb.m(Integer.valueOf(this.wdn.wha.size()));
                        if (this.wdn.wha.isEmpty()) {
                            this.wdc.setVisibility(0);
                        } else {
                            this.wde.setVisibility(0);
                            this.wdd.setVisibility(0);
                        }
                        w.b(this.wcW);
                        this.wcW.reset();
                    } else {
                        this.wcW.reset();
                        com.tencent.mm.media.widget.camerarecordview.a aVar3 = this.wdk;
                        if (aVar3 != null) {
                            j2 = aVar3.ipu;
                        } else {
                            j2 = 0;
                        }
                        if (Util.ticksToNow(j2) > 1000) {
                            y yVar4 = y.vih;
                            y.Q(212, 1);
                            w.b(this.wcW);
                            this.wdc.setVisibility(0);
                        } else {
                            this.wcW.eKH();
                        }
                    }
                }
                this.wcX.setVisibility(0);
                chz chz = this.wgw.wjj;
                if (chz != null) {
                    if (!Util.isNullOrNil(chz.Lso)) {
                        com.tencent.mm.sticker.a.b bVar = com.tencent.mm.sticker.a.b.NOi;
                        com.tencent.mm.sticker.a.b.f(chz);
                    }
                    AppMethodBeat.o(254436);
                    return;
                }
                AppMethodBeat.o(254436);
                return;
            case 3:
                if (bundle != null) {
                    this.wcW.td(!bundle.getBoolean("PARAM_1_BOOLEAN"));
                    if (bundle.getBoolean("PARAM_1_BOOLEAN")) {
                        this.wcW.ae(true, false);
                        this.wdb.reset();
                        this.wdb.setVisibility(0);
                        com.tencent.mm.plugin.recordvideo.d.c cVar4 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                        com.tencent.mm.plugin.recordvideo.d.c.x("KEY_IS_SUB_RECORD_BOOLEAN", Boolean.TRUE);
                        com.tencent.mm.plugin.recordvideo.d.c cVar5 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                        com.tencent.mm.plugin.recordvideo.d.c.aLu("KEY_CHANGE_SUB_RECORD_TAB_INT");
                    } else {
                        this.wcW.ae(false, false);
                        this.wdb.setVisibility(4);
                        com.tencent.mm.plugin.recordvideo.d.c cVar6 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                        com.tencent.mm.plugin.recordvideo.d.c.x("KEY_IS_SUB_RECORD_BOOLEAN", Boolean.FALSE);
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(254436);
                    return;
                }
                AppMethodBeat.o(254436);
                return;
            case 4:
                if (bundle != null) {
                    ArrayList<String> stringArrayList = bundle.getStringArrayList("PARAM_PHOTO_LIST");
                    ArrayList<String> stringArrayList2 = bundle.getStringArrayList("PARAM_VIDEO_LIST");
                    com.tencent.mm.media.widget.camerarecordview.b.b bVar2 = new com.tencent.mm.media.widget.camerarecordview.b.b(null, null, false, null, null, null, null, null, null, 65535);
                    ArrayList<String> arrayList = stringArrayList;
                    if (!(arrayList == null || arrayList.isEmpty())) {
                        if (stringArrayList == null) {
                            p.hyc();
                        }
                        String str = stringArrayList.get(0);
                        p.g(str, "imageList!![0]");
                        bVar2.Hy(str);
                        bVar2.s(stringArrayList);
                    }
                    ArrayList<String> arrayList2 = stringArrayList2;
                    if (!(arrayList2 == null || arrayList2.isEmpty())) {
                        if (stringArrayList2 == null) {
                            p.hyc();
                        }
                        String str2 = stringArrayList2.get(0);
                        p.g(str2, "videoList!![0]");
                        bVar2.Hw(str2);
                        bVar2.t(stringArrayList2);
                    }
                    bVar2.iqf = false;
                    bVar2.aQr();
                    com.tencent.mm.plugin.recordvideo.activity.a aVar4 = this.wdl;
                    if (aVar4 != null) {
                        aVar4.a(bundle.getInt("PARAM_ROUTER_INT", 0), bVar2);
                        x xVar2 = x.SXb;
                    }
                    x xVar3 = x.SXb;
                    AppMethodBeat.o(254436);
                    return;
                }
                AppMethodBeat.o(254436);
                return;
            case 5:
                if (bundle != null) {
                    com.tencent.mm.media.widget.camerarecordview.a aVar5 = this.wdk;
                    if (aVar5 != null) {
                        aVar5.rz(bundle.getInt("PARAM_PREPARE_CAMERA_ZOOM_LOCATION_INT"));
                        x xVar4 = x.SXb;
                    }
                    x xVar5 = x.SXb;
                    AppMethodBeat.o(254436);
                    return;
                }
                AppMethodBeat.o(254436);
                return;
            case 6:
                if (bundle != null) {
                    com.tencent.mm.media.widget.camerarecordview.a aVar6 = this.wdk;
                    if (aVar6 != null) {
                        boolean z3 = bundle.getBoolean("PARAM_PREPARE_CAMERA_ZOOM_BOOLEAN", false);
                        bundle.getBoolean("PARAM_PREPARE_CAMERA_ZOOM_SCROLL_BOOLEAN", true);
                        aVar6.i(z3, bundle.getInt("PARAM_PREPARE_CAMERA_ZOOM_FACTOR_INT"));
                        x xVar6 = x.SXb;
                    }
                    x xVar7 = x.SXb;
                }
                AppMethodBeat.o(254436);
                return;
            case 7:
                com.tencent.mm.media.widget.camerarecordview.a aVar7 = this.wdk;
                Boolean valueOf = aVar7 != null ? Boolean.valueOf(com.tencent.mm.media.widget.camerarecordview.a.b(aVar7)) : null;
                com.tencent.mm.plugin.finder.video.plugin.b bVar3 = this.wda;
                com.tencent.mm.media.widget.camerarecordview.a aVar8 = this.wdk;
                if (aVar8 != null) {
                    z = aVar8.ipt;
                } else {
                    z = false;
                }
                bVar3.oS(z);
                if (valueOf != null) {
                    valueOf.booleanValue();
                    this.wcY.tf(!valueOf.booleanValue());
                    x xVar8 = x.SXb;
                    AppMethodBeat.o(254436);
                    return;
                }
                AppMethodBeat.o(254436);
                return;
            case 8:
                float f3 = bundle != null ? bundle.getFloat("PARAM_POINT_X") : 0.0f;
                float f4 = bundle != null ? bundle.getFloat("PARAM_POINT_Y") : 0.0f;
                com.tencent.mm.media.widget.camerarecordview.a aVar9 = this.wdk;
                if (aVar9 != null) {
                    aVar9.b(f3, f4, this.wcV.getWidth(), this.wcV.getHeight());
                    x xVar9 = x.SXb;
                    AppMethodBeat.o(254436);
                    return;
                }
                AppMethodBeat.o(254436);
                return;
            case 9:
                long currentTicks = Util.currentTicks();
                com.tencent.mm.plugin.mmsight.model.d dVar3 = this.orientationEventListener;
                if (dVar3 != null) {
                    f2 = (float) dVar3.ejw();
                } else {
                    f2 = 0.0f;
                }
                com.tencent.mm.plugin.recordvideo.d.c cVar7 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                com.tencent.mm.plugin.recordvideo.d.c.x("KEY_START_RECORD_MS_LONG", Long.valueOf(System.currentTimeMillis()));
                com.tencent.mm.media.widget.camerarecordview.a aVar10 = this.wdk;
                if (aVar10 != null) {
                    aVar10.r(new f(this, currentTicks, f2));
                    x xVar10 = x.SXb;
                    AppMethodBeat.o(254436);
                    return;
                }
                AppMethodBeat.o(254436);
                return;
            case 10:
                boolean z4 = bundle != null ? bundle.getBoolean("PARAM_BEAUTIFY_ENABLE") : false;
                com.tencent.mm.plugin.finder.video.a aVar11 = this.wdj;
                com.tencent.mm.media.j.a previewRenderer = aVar11 != null ? aVar11.getPreviewRenderer() : null;
                if (!(previewRenderer instanceof com.tencent.mm.plugin.recordvideo.c.b)) {
                    previewRenderer = null;
                }
                this.wcV.j(new g(this, (com.tencent.mm.plugin.recordvideo.c.b) previewRenderer, z4));
                AppMethodBeat.o(254436);
                return;
            case 11:
                y yVar5 = y.vih;
                y.Q(192, 1);
                this.wdb.rl(true);
                this.wcW.rl(true);
                AppMethodBeat.o(254436);
                return;
            case 12:
                this.wdb.rl(false);
                this.wcW.rl(false);
                AppMethodBeat.o(254436);
                return;
            case 13:
                y yVar6 = y.vih;
                y.Q(193, 1);
                this.wdn.dFT();
                this.wcW.QS(this.wdn.wha.size());
                this.wdb.m(Integer.valueOf(this.wdn.wha.size()));
                if (this.wdn.wha.isEmpty()) {
                    this.wdc.setVisibility(0);
                    this.wde.setVisibility(4);
                    this.wda.setVisibility(0);
                    this.wdd.setVisibility(4);
                    AppMethodBeat.o(254436);
                    return;
                }
                break;
            case 14:
                if (this.wdc.whp) {
                    com.tencent.mm.plugin.recordvideo.d.c cVar8 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                    com.tencent.mm.plugin.recordvideo.d.c.x("KEY_SUB_VIDEO_NUM_INT", Integer.valueOf(this.wdn.dFV().size()));
                }
                if (!this.wdc.whp || this.wdn.wha.isEmpty()) {
                    Context context = getContext();
                    if (context == null) {
                        t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.activity.MMRecordUI");
                        AppMethodBeat.o(254436);
                        throw tVar;
                    }
                    ((MMRecordUI) context).eIF();
                    AppMethodBeat.o(254436);
                    return;
                }
                y yVar7 = y.vih;
                y.Q(194, 1);
                this.wcX.kvo.show();
                AppMethodBeat.o(254436);
                return;
            case 15:
                if (this.wdc.whp) {
                    y yVar8 = y.vih;
                    y.Q(229, 1);
                    y yVar9 = y.vih;
                    y.ah(this.wdn.dFV());
                    com.tencent.mm.plugin.recordvideo.d.c cVar9 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                    com.tencent.mm.plugin.recordvideo.d.c.x("KEY_SUB_VIDEO_NUM_INT", Integer.valueOf(this.wdn.dFV().size()));
                }
                com.tencent.mm.media.widget.camerarecordview.b.b bVar4 = new com.tencent.mm.media.widget.camerarecordview.b.b(null, null, false, null, null, null, null, null, null, 65535);
                ArrayList<String> dFV = this.wdn.dFV();
                String str3 = dFV.get(0);
                p.g(str3, "videoList[0]");
                bVar4.Hw(str3);
                bVar4.t(dFV);
                bVar4.iqf = true;
                bVar4.aQr();
                Bundle bundle2 = new Bundle();
                bundle2.putParcelableArrayList("media_list", this.wdn.dFU());
                RecordConfigProvider recordConfigProvider2 = this.wdm;
                if (recordConfigProvider2 != null) {
                    recordConfigProvider2.jkf = bundle2;
                }
                com.tencent.mm.plugin.recordvideo.activity.a aVar12 = this.wdl;
                if (aVar12 != null) {
                    aVar12.a(4, bVar4);
                    x xVar11 = x.SXb;
                    AppMethodBeat.o(254436);
                    return;
                }
                AppMethodBeat.o(254436);
                return;
            case 16:
                if (!(bundle != null ? bundle.getBoolean("PARAM_STICKER_PANEL_OPEN") : false)) {
                    this.wdi.setVisibility(0);
                    AppMethodBeat.o(254436);
                    return;
                }
                this.wdi.setVisibility(4);
                AppMethodBeat.o(254436);
                return;
            case 17:
                String string = bundle != null ? bundle.getString("PARAM_STICKER_LENS_ID") : null;
                com.tencent.mm.plugin.finder.video.a aVar13 = this.wdj;
                com.tencent.mm.media.j.a previewRenderer2 = aVar13 != null ? aVar13.getPreviewRenderer() : null;
                if (!(previewRenderer2 instanceof com.tencent.mm.plugin.recordvideo.c.b)) {
                    previewRenderer2 = null;
                }
                com.tencent.mm.plugin.recordvideo.c.b bVar5 = (com.tencent.mm.plugin.recordvideo.c.b) previewRenderer2;
                if (bVar5 != null) {
                    if (string == null) {
                        bit = null;
                    } else {
                        f.a aVar14 = com.tencent.mm.sticker.f.NNw;
                        com.tencent.mm.sticker.loader.e eVar = com.tencent.mm.sticker.loader.e.NNN;
                        bit = f.a.bit(com.tencent.mm.sticker.loader.e.biw(string));
                    }
                    this.wcV.j(new d(bVar5, bit, this, string));
                    x xVar12 = x.SXb;
                    AppMethodBeat.o(254436);
                    return;
                }
                AppMethodBeat.o(254436);
                return;
            default:
                Log.i("Finder.FinderRecordPluginLayout", "unknown status ".concat(String.valueOf(cVar)));
                break;
        }
        AppMethodBeat.o(254436);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
    public final void a(com.tencent.mm.media.widget.camerarecordview.b.b bVar) {
        AppMethodBeat.i(254437);
        super.a(bVar);
        if (this.wdc.whp) {
            this.wde.setVisibility(0);
            this.wdd.setVisibility(0);
            AppMethodBeat.o(254437);
            return;
        }
        this.wdc.setVisibility(0);
        this.wdb.reset();
        this.wdn.dFT();
        AppMethodBeat.o(254437);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t, com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
    public final boolean onBackPress() {
        AppMethodBeat.i(254438);
        if (!super.onBackPress()) {
            d.b.a(this, d.c.BWW);
            AppMethodBeat.o(254438);
            return true;
        }
        AppMethodBeat.o(254438);
        return false;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class g extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ boolean hLa;
        final /* synthetic */ com.tencent.mm.plugin.recordvideo.c.b wdx;
        final /* synthetic */ DevFinderRecordPluginLayout wgz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(DevFinderRecordPluginLayout devFinderRecordPluginLayout, com.tencent.mm.plugin.recordvideo.c.b bVar, boolean z) {
            super(0);
            this.wgz = devFinderRecordPluginLayout;
            this.wdx = bVar;
            this.hLa = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            XEffectConfig xEffectConfig;
            com.tencent.mm.plugin.recordvideo.c.b bVar;
            AppMethodBeat.i(254427);
            RecordConfigProvider recordConfigProvider = this.wgz.wdm;
            if (!(recordConfigProvider == null || (xEffectConfig = recordConfigProvider.BOJ) == null || (bVar = this.wdx) == null)) {
                bVar.a(xEffectConfig);
            }
            com.tencent.mm.plugin.recordvideo.c.b bVar2 = this.wdx;
            if (bVar2 != null) {
                bVar2.ti(this.hLa);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(254427);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/video/develop/DevFinderRecordPluginLayout$statusChange$9$1"})
    static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ com.tencent.mm.sticker.f rsy;
        final /* synthetic */ com.tencent.mm.plugin.recordvideo.c.b wdx;
        final /* synthetic */ String wdy;
        final /* synthetic */ DevFinderRecordPluginLayout wgz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(com.tencent.mm.plugin.recordvideo.c.b bVar, com.tencent.mm.sticker.f fVar, DevFinderRecordPluginLayout devFinderRecordPluginLayout, String str) {
            super(0);
            this.wdx = bVar;
            this.rsy = fVar;
            this.wgz = devFinderRecordPluginLayout;
            this.wdy = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(254424);
            com.tencent.mm.plugin.xlabeffect.b bVar = this.wdx.hiH;
            if (bVar != null) {
                bVar.a(this.rsy);
            }
            if (this.rsy != null) {
                com.tencent.mm.ac.d.a(2000, new kotlin.g.a.a<x>(this) {
                    /* class com.tencent.mm.plugin.finder.video.develop.DevFinderRecordPluginLayout.d.AnonymousClass1 */
                    final /* synthetic */ d wgB;

                    {
                        this.wgB = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        AppMethodBeat.i(254423);
                        com.tencent.mm.plugin.xlabeffect.b bVar = this.wgB.wdx.hiH;
                        if (p.j(bVar != null ? Boolean.valueOf(bVar.JRh) : null, Boolean.FALSE)) {
                            Toast.makeText(this.wgB.wgz.wcV.getContext(), (int) R.string.fws, 0).show();
                        }
                        x xVar = x.SXb;
                        AppMethodBeat.o(254423);
                        return xVar;
                    }
                });
            }
            x xVar = x.SXb;
            AppMethodBeat.o(254424);
            return xVar;
        }
    }
}
