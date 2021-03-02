package com.tencent.mm.plugin.finder.video;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.g.b.a.jf;
import com.tencent.mm.media.widget.camerarecordview.b.b;
import com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLSurfaceView;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.finder.report.y;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.plugin.finder.video.plugin.view.RecordTypeSelectView;
import com.tencent.mm.plugin.finder.video.plugin.view.SubRecordBeautyView;
import com.tencent.mm.plugin.finder.video.plugin.view.SubRecordFinishView;
import com.tencent.mm.plugin.gallery.model.GalleryItem;
import com.tencent.mm.plugin.mmsight.model.d;
import com.tencent.mm.plugin.recordvideo.activity.MMRecordUI;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.XEffectConfig;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.plugin.aa;
import com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.progress.HorizontalSubProgressBar;
import com.tencent.mm.plugin.recordvideo.plugin.w;
import com.tencent.mm.plugin.recordvideo.plugin.z;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sticker.f;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.vfs.s;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 i2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001iB\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010B\u001a\u00020C2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020F0EH\u0002J\b\u0010\u000f\u001a\u00020GH\u0002J\b\u0010H\u001a\u00020GH\u0002J\u0018\u0010I\u001a\u00020G2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0012\u0010J\u001a\u00020G2\b\u0010K\u001a\u0004\u0018\u00010LH\u0016J\"\u0010M\u001a\u00020G2\u0006\u0010N\u001a\u00020#2\u0006\u0010O\u001a\u00020#2\b\u0010P\u001a\u0004\u0018\u00010QH\u0016J\b\u0010R\u001a\u00020\u0010H\u0016J\b\u0010S\u001a\u00020GH\u0016J\u0010\u0010T\u001a\u00020G2\u0006\u0010U\u001a\u00020#H\u0016J\b\u0010V\u001a\u00020GH\u0016J-\u0010W\u001a\u00020G2\u0006\u0010N\u001a\u00020#2\u000e\u0010X\u001a\n\u0012\u0006\b\u0001\u0012\u00020Z0Y2\u0006\u0010[\u001a\u00020\\H\u0016¢\u0006\u0002\u0010]J\b\u0010^\u001a\u00020GH\u0016J\b\u0010_\u001a\u00020GH\u0016J\u0010\u0010`\u001a\u00020G2\u0006\u0010a\u001a\u00020bH\u0002J\u001a\u0010c\u001a\u00020G2\u0006\u0010d\u001a\u00020e2\b\u0010f\u001a\u0004\u0018\u00010CH\u0016J\u0010\u0010g\u001a\u00020G2\u0006\u0010h\u001a\u00020\u0010H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020AX\u000e¢\u0006\u0002\n\u0000¨\u0006j"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/FinderRecordPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener$OrienChangeCallback;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "audioPanelPlugin", "Lcom/tencent/mm/plugin/finder/video/plugin/AudioPanelPlugin;", "beautifyPlugin", "Lcom/tencent/mm/plugin/finder/video/plugin/FinderRecordBeautifyPlugin;", "cameraSwitchPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/RecordSwitchCameraPlugin;", "checkAudioPermission", "", "closePlugin", "Lcom/tencent/mm/plugin/finder/video/plugin/FinderRecordClosePlugin;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "horizontalSubProgressPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/progress/HorizontalSubProgressPlugin;", "isFullscreenMode", "()Z", "isFullscreenMode$delegate", "Lkotlin/Lazy;", "maxRecordTime", "", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "orientationEventListener", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener;", "previewBottomProvider", "Lkotlin/Function0;", "", "previewPlugin", "Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;", "process", "Lcom/tencent/mm/plugin/finder/video/FinderCameraContainerProcess;", "recordAudioPlugin", "Lcom/tencent/mm/plugin/finder/video/plugin/RecordAudioPlugin;", "recordController", "Lcom/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer;", "recordCountdownPlugin", "Lcom/tencent/mm/plugin/finder/video/RecordCountdownPlugin;", "recordEditRootView", "Landroid/view/ViewGroup;", "recordFeatureView", "Landroid/view/View;", "recordPathPlugin", "Lcom/tencent/mm/plugin/finder/video/plugin/FinderSubVideoFilePlugin;", "recordPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/RecordButtonPlugin;", "recordTime", "selectTypePlugin", "Lcom/tencent/mm/plugin/finder/video/plugin/subvideo/FinderRecordTypePlugin;", "subRecordDeletePlugin", "Lcom/tencent/mm/plugin/finder/video/plugin/FinderSubRecordDeletePlugin;", "subRecordFinishPlugin", "Lcom/tencent/mm/plugin/finder/video/plugin/FinderSubRecordFinishPlugin;", "touchFocusPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/RecordFocusPlugin;", "useBackCamera", "util", "Lcom/tencent/mm/plugin/finder/video/plugin/util/FinderLayoutUtil;", "buildEditBundle", "Landroid/os/Bundle;", "mediaList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "", "initConfig", "initLogic", "loadCurrentPage", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPress", "onDetach", "onOrientationChange", "orientation", "onPause", "onRequestPermissionsResult", NativeProtocol.RESULT_ARGS_PERMISSIONS, "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "release", "setPreviewRatio", "ratio", "", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "updateRecordTipByAudioPermission", "permission", "Companion", "plugin-finder_release"})
public final class FinderRecordPluginLayout extends BasePluginLayout implements d.a, com.tencent.mm.plugin.recordvideo.plugin.parent.d {
    public static final a wdt = new a((byte) 0);
    private long gLd;
    private boolean ilM = true;
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
    private final com.tencent.mm.plugin.finder.video.plugin.a wdf;
    private final com.tencent.mm.plugin.finder.video.plugin.g wdg;
    private final v wdh;
    private final View wdi;
    private a wdj;
    private com.tencent.mm.media.widget.camerarecordview.a wdk;
    private com.tencent.mm.plugin.recordvideo.activity.a wdl;
    private RecordConfigProvider wdm;
    private com.tencent.mm.plugin.finder.video.plugin.f wdn = new com.tencent.mm.plugin.finder.video.plugin.f(this);
    private final kotlin.f wdo = kotlin.g.ah(c.wdv);
    private com.tencent.mm.plugin.finder.video.plugin.util.a wdp = new com.tencent.mm.plugin.finder.video.plugin.util.a();
    private final kotlin.g.a.a<Integer> wdq;
    private long wdr;
    private boolean wds;

    static {
        AppMethodBeat.i(254099);
        AppMethodBeat.o(254099);
    }

    private final boolean isFullscreenMode() {
        AppMethodBeat.i(254086);
        boolean booleanValue = ((Boolean) this.wdo.getValue()).booleanValue();
        AppMethodBeat.o(254086);
        return booleanValue;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "succ", "", "invoke"})
    static final class f extends q implements kotlin.g.a.b<Boolean, x> {
        public static final f wdw = new f();

        static {
            AppMethodBeat.i(254078);
            AppMethodBeat.o(254078);
        }

        f() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            AppMethodBeat.i(254077);
            Log.i("Finder.FinderRecordPluginLayout", "startPreview finish:".concat(String.valueOf(bool.booleanValue())));
            x xVar = x.SXb;
            AppMethodBeat.o(254077);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "capture", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "invoke"})
    static final class i extends q implements kotlin.g.a.b<com.tencent.mm.media.widget.camerarecordview.b.b, x> {
        final /* synthetic */ Bundle uxC;
        final /* synthetic */ FinderRecordPluginLayout wdu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(FinderRecordPluginLayout finderRecordPluginLayout, Bundle bundle) {
            super(1);
            this.wdu = finderRecordPluginLayout;
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
            AppMethodBeat.i(254082);
            com.tencent.mm.media.widget.camerarecordview.b.b bVar2 = bVar;
            p.h(bVar2, "capture");
            this.wdu.wdn.bw(bVar2.iqd, this.wdu.wda.dFS());
            if (this.wdu.wdc.whp) {
                com.tencent.mm.plugin.recordvideo.d.c cVar = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                com.tencent.mm.plugin.recordvideo.d.c.aLu("KEY_SUB_VIDEO_RECORD_SUCCESS_INT");
                Bundle bundle = this.uxC;
                if (bundle == null || !bundle.getBoolean("PARAM_1_BOOLEAN")) {
                    this.wdu.wcW.td(false);
                    this.wdu.wcW.reset();
                    com.tencent.mm.media.widget.camerarecordview.a aVar = this.wdu.wdk;
                    if (aVar != null) {
                        aVar.aQf();
                    }
                    this.wdu.wdd.setVisibility(0);
                    this.wdu.wde.setVisibility(0);
                    this.wdu.wda.setVisibility(4);
                } else {
                    Log.i("Finder.FinderRecordPluginLayout", "sub record finish");
                    y yVar = y.vih;
                    y.Q(191, 1);
                    d.b.a(this.wdu, d.c.BUx);
                }
            } else {
                y yVar2 = y.vih;
                y.Q(211, 1);
                y yVar3 = y.vih;
                com.tencent.mm.media.widget.camerarecordview.a aVar2 = this.wdu.wdk;
                if (aVar2 != null && aVar2.ipt) {
                    z = true;
                }
                y.ot(z);
                if (this.wdu.wda.dFS()) {
                    y yVar4 = y.vih;
                    y.Q(215, 1);
                }
                y yVar5 = y.vih;
                y.Fo((long) bVar2.iqg);
                d.b.a(this.wdu, d.c.BUx);
                com.tencent.mm.plugin.recordvideo.d.c cVar2 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                com.tencent.mm.media.widget.camerarecordview.a aVar3 = this.wdu.wdk;
                com.tencent.mm.plugin.recordvideo.d.c.x("KEY_MEDIA_SOURCE_INT", Integer.valueOf((aVar3 == null || !aVar3.ipt) ? 1 : 2));
                com.tencent.mm.media.k.e eVar = com.tencent.mm.media.k.e.ilC;
                String str = bVar2.iqd;
                RecordConfigProvider recordConfigProvider = this.wdu.wdm;
                if (recordConfigProvider != null) {
                    i2 = recordConfigProvider.BOi;
                } else {
                    i2 = 1;
                }
                RecordConfigProvider recordConfigProvider2 = this.wdu.wdm;
                com.tencent.mm.media.k.e.n(str, i2, recordConfigProvider2 != null ? recordConfigProvider2.ilT : -1);
                String str2 = bVar2.iqd;
                RecordConfigProvider recordConfigProvider3 = this.wdu.wdm;
                if (recordConfigProvider3 != null) {
                    i3 = recordConfigProvider3.BOi;
                } else {
                    i3 = 1;
                }
                RecordConfigProvider recordConfigProvider4 = this.wdu.wdm;
                if (recordConfigProvider4 != null) {
                    i4 = recordConfigProvider4.scene;
                }
                com.tencent.mm.plugin.mmsight.model.l.au(str2, i3, i4);
                com.tencent.mm.plugin.recordvideo.d.c cVar3 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                com.tencent.mm.plugin.recordvideo.d.c.eKX().rz((long) (bVar2.iqg - bVar2.dvv));
                com.tencent.mm.plugin.recordvideo.d.c cVar4 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                jf eKX = com.tencent.mm.plugin.recordvideo.d.c.eKX();
                com.tencent.mm.media.widget.camerarecordview.a aVar4 = this.wdu.wdk;
                if (aVar4 == null || !aVar4.ipt) {
                    j2 = 1;
                } else {
                    j2 = 2;
                }
                eKX.rA(j2);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(254082);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/graphics/Bitmap;", "invoke"})
    static final class j extends q implements kotlin.g.a.b<Bitmap, x> {
        final /* synthetic */ long qVz;
        final /* synthetic */ float wdA;
        final /* synthetic */ FinderRecordPluginLayout wdu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(FinderRecordPluginLayout finderRecordPluginLayout, long j2, float f2) {
            super(1);
            this.wdu = finderRecordPluginLayout;
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
            AppMethodBeat.i(254083);
            Bitmap bitmap3 = bitmap;
            long ticksToNow = Util.ticksToNow(this.qVz);
            Log.i("Finder.FinderRecordPluginLayout", "photo time cost : ".concat(String.valueOf(ticksToNow)));
            com.tencent.mm.media.k.e eVar = com.tencent.mm.media.k.e.ilC;
            com.tencent.mm.media.k.e.aNN();
            com.tencent.mm.media.k.e eVar2 = com.tencent.mm.media.k.e.ilC;
            com.tencent.mm.media.k.e.zK(ticksToNow);
            if (bitmap3 != null) {
                com.tencent.mm.media.widget.camerarecordview.a aVar = this.wdu.wdk;
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
                com.tencent.mm.media.widget.camerarecordview.a aVar2 = this.wdu.wdk;
                if (aVar2 == null || !aVar2.ipt) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                y.os(z2);
                if (this.wdu.wda.dFS()) {
                    y yVar3 = y.vih;
                    y.Q(203, 1);
                }
                RecordConfigProvider recordConfigProvider = this.wdu.wdm;
                if (recordConfigProvider != null) {
                    try {
                        BitmapUtil.saveBitmapToImage(bitmap2, 100, Bitmap.CompressFormat.JPEG, recordConfigProvider.BOB, true);
                        Log.i("Finder.FinderRecordPluginLayout", "save picture in " + recordConfigProvider.BOB + "  cost: " + Util.ticksToNow(currentTicks));
                        b.a aVar3 = com.tencent.mm.media.widget.camerarecordview.b.b.iqq;
                        String str = recordConfigProvider.BOB;
                        p.g(str, "this.inputPhotoPath");
                        com.tencent.mm.media.widget.camerarecordview.b.b Hz = b.a.Hz(str);
                        Hz.iqo = z;
                        GalleryItem.MediaItem a3 = GalleryItem.MediaItem.a(1, 0, recordConfigProvider.BOB, "", "");
                        a3.u("KEY_MEDIA_IS_BEAUTY", Boolean.valueOf(this.wdu.wda.dFS()));
                        a3.xja = System.currentTimeMillis();
                        RecordConfigProvider recordConfigProvider2 = this.wdu.wdm;
                        if (recordConfigProvider2 != null) {
                            FinderRecordPluginLayout finderRecordPluginLayout = this.wdu;
                            p.g(a3, "item");
                            recordConfigProvider2.jkf = FinderRecordPluginLayout.a(finderRecordPluginLayout, kotlin.a.j.ac(a3));
                        }
                        com.tencent.mm.plugin.recordvideo.activity.a aVar4 = this.wdu.wdl;
                        if (aVar4 != null) {
                            aVar4.a(1, Hz);
                        }
                    } catch (IOException e2) {
                        com.tencent.mm.media.widget.camerarecordview.a aVar5 = this.wdu.wdk;
                        if (aVar5 != null) {
                            com.tencent.mm.media.widget.camerarecordview.a.a(aVar5, false, null, 7);
                        }
                        com.tencent.mm.media.k.e eVar3 = com.tencent.mm.media.k.e.ilC;
                        com.tencent.mm.media.k.e.aNT();
                    }
                }
            }
            com.tencent.mm.plugin.recordvideo.d.c cVar = com.tencent.mm.plugin.recordvideo.d.c.BXI;
            com.tencent.mm.media.widget.camerarecordview.a aVar6 = this.wdu.wdk;
            if (aVar6 != null && aVar6.ipt) {
                i2 = 2;
            }
            com.tencent.mm.plugin.recordvideo.d.c.x("KEY_MEDIA_SOURCE_INT", Integer.valueOf(i2));
            if (bitmap3 == null) {
                com.tencent.mm.media.k.e eVar4 = com.tencent.mm.media.k.e.ilC;
                com.tencent.mm.media.k.e.aNO();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(254083);
            return xVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderRecordPluginLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(168010);
        this.orientationEventListener = new com.tencent.mm.plugin.mmsight.model.d(context, (byte) 0);
        LayoutInflater.from(context).inflate(R.layout.aj9, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.d2y);
        p.g(findViewById, "findViewById(R.id.finder_record_layout)");
        this.wcU = (ViewGroup) findViewById;
        View findViewById2 = findViewById(R.id.if9);
        p.g(findViewById2, "findViewById(R.id.switch_camera)");
        this.wcY = new aa((ImageView) findViewById2, this);
        View findViewById3 = findViewById(R.id.b4k);
        p.g(findViewById3, "findViewById(R.id.close_plugin)");
        this.wcX = new com.tencent.mm.plugin.finder.video.plugin.c((WeImageView) findViewById3, this);
        this.wcZ = new z(this, this);
        View findViewById4 = findViewById(R.id.gxe);
        p.g(findViewById4, "findViewById(R.id.record_plugin)");
        this.wcW = new w((RelativeLayout) findViewById4, this);
        View findViewById5 = findViewById(R.id.d1e);
        p.g(findViewById5, "findViewById(R.id.finder_preview_plugin)");
        this.wcV = (CameraPreviewGLSurfaceView) findViewById5;
        View findViewById6 = findViewById(R.id.gxq);
        p.g(findViewById6, "findViewById(R.id.record_type_view)");
        this.wdc = new com.tencent.mm.plugin.finder.video.plugin.subvideo.a((RecordTypeSelectView) findViewById6, this);
        this.wdg = new com.tencent.mm.plugin.finder.video.plugin.g(this, this);
        View findViewById7 = findViewById(R.id.gwf);
        p.g(findViewById7, "findViewById(R.id.record_audio_panel)");
        this.wdf = new com.tencent.mm.plugin.finder.video.plugin.a((EditorAudioView) findViewById7, this);
        this.wdf.wgJ.add(this.wdg);
        this.wdh = new v(this, this);
        View findViewById8 = findViewById(R.id.bmj);
        p.g(findViewById8, "findViewById(R.id.delete_sub_video)");
        this.wde = new com.tencent.mm.plugin.finder.video.plugin.d((WeImageView) findViewById8, this);
        View findViewById9 = findViewById(R.id.glg);
        p.g(findViewById9, "findViewById(R.id.progress_horizontal)");
        this.wdb = new com.tencent.mm.plugin.recordvideo.plugin.progress.a((HorizontalSubProgressBar) findViewById9, this);
        this.wcW.BRz = new kotlin.g.a.b<ArrayList<Float>, x>(this) {
            /* class com.tencent.mm.plugin.finder.video.FinderRecordPluginLayout.AnonymousClass1 */
            final /* synthetic */ FinderRecordPluginLayout wdu;

            {
                this.wdu = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(ArrayList<Float> arrayList) {
                AppMethodBeat.i(254069);
                ArrayList<Float> arrayList2 = arrayList;
                p.h(arrayList2, LocaleUtil.ITALIAN);
                this.wdu.wdb.aJ(arrayList2);
                FinderRecordPluginLayout finderRecordPluginLayout = this.wdu;
                Float v = kotlin.a.j.v((Iterable<Float>) arrayList2);
                finderRecordPluginLayout.gLd = (long) (((v != null ? v.floatValue() : 0.0f) / 100.0f) * ((float) this.wdu.wdr));
                com.tencent.mm.plugin.finder.video.plugin.g unused = this.wdu.wdg;
                long unused2 = this.wdu.gLd;
                x xVar = x.SXb;
                AppMethodBeat.o(254069);
                return xVar;
            }
        };
        this.wcW.BRB = false;
        this.wdq = new kotlin.g.a.a<Integer>(this) {
            /* class com.tencent.mm.plugin.finder.video.FinderRecordPluginLayout.AnonymousClass2 */
            final /* synthetic */ FinderRecordPluginLayout wdu;

            {
                this.wdu = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ Integer invoke() {
                AppMethodBeat.i(254070);
                Integer valueOf = Integer.valueOf(this.wdu.getHeight() - this.wdu.wcV.getBottom());
                AppMethodBeat.o(254070);
                return valueOf;
            }
        };
        View findViewById10 = findViewById(R.id.d2y);
        p.g(findViewById10, "findViewById(R.id.finder_record_layout)");
        this.wdi = findViewById10;
        SubRecordFinishView subRecordFinishView = new SubRecordFinishView(context, null);
        subRecordFinishView.setVisibility(4);
        ((FrameLayout) findViewById(R.id.h77)).addView(subRecordFinishView, new FrameLayout.LayoutParams(-1, -1));
        this.wdd = new com.tencent.mm.plugin.finder.video.plugin.e(subRecordFinishView, this);
        SubRecordBeautyView subRecordBeautyView = new SubRecordBeautyView(context, null);
        ((FrameLayout) findViewById(R.id.h77)).addView(subRecordBeautyView, new FrameLayout.LayoutParams(-1, -1));
        this.wda = new com.tencent.mm.plugin.finder.video.plugin.b(subRecordBeautyView, this, this.wcV);
        getPluginList().add(this.wcW);
        getPluginList().add(this.wcX);
        getPluginList().add(this.wcY);
        getPluginList().add(this.wcZ);
        getPluginList().add(this.wdc);
        getPluginList().add(this.wdn);
        getPluginList().add(this.wdf);
        getPluginList().add(this.wdg);
        com.tencent.mm.plugin.mmsight.model.d dVar = this.orientationEventListener;
        if (dVar != null) {
            dVar.a(this);
        }
        com.tencent.mm.plugin.mmsight.model.d dVar2 = this.orientationEventListener;
        if (dVar2 != null) {
            dVar2.enable();
            AppMethodBeat.o(168010);
            return;
        }
        AppMethodBeat.o(168010);
    }

    public static final /* synthetic */ Bundle a(FinderRecordPluginLayout finderRecordPluginLayout, ArrayList arrayList) {
        AppMethodBeat.i(254100);
        Bundle am = finderRecordPluginLayout.am(arrayList);
        AppMethodBeat.o(254100);
        return am;
    }

    public static final /* synthetic */ void l(FinderRecordPluginLayout finderRecordPluginLayout) {
        AppMethodBeat.i(254101);
        finderRecordPluginLayout.oL(false);
        AppMethodBeat.o(254101);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/FinderRecordPluginLayout$Companion;", "", "()V", "FLUTTER_TAG", "", "REQUEST_CODE_EDIT_VLOG_FLUTTER", "", "TAG", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
    public final void a(com.tencent.mm.plugin.recordvideo.activity.a aVar, RecordConfigProvider recordConfigProvider) {
        String str;
        String str2;
        boolean z;
        boolean z2;
        AppMethodBeat.i(168005);
        p.h(aVar, "navigator");
        p.h(recordConfigProvider, "configProvider");
        this.wdm = recordConfigProvider;
        this.wdj = new a(recordConfigProvider, this.wcV);
        cMT();
        int n = com.tencent.mm.cb.a.n(getContext(), R.color.act);
        aa aaVar = this.wcY;
        aaVar.tkI.setImageDrawable(ar.m(aaVar.tkI.getContext(), R.raw.icons_filled_camera_switch, n));
        setPreviewRatio(recordConfigProvider.BOn.gLT);
        this.wdl = aVar;
        this.wdm = recordConfigProvider;
        Context context = getContext();
        if (context == null) {
            t tVar = new t("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(168005);
            throw tVar;
        }
        boolean a2 = com.tencent.mm.pluginsdk.permission.b.a((Activity) context, "android.permission.RECORD_AUDIO", 80, "", "");
        Log.i("MicroMsg.RecordPluginLayout", "checkAudioPermission " + a2 + " !");
        a aVar2 = this.wdj;
        if (aVar2 != null) {
            if (!a2) {
                z2 = true;
            } else {
                z2 = false;
            }
            aVar2.isb = z2;
        }
        a aVar3 = this.wdj;
        if (aVar3 == null) {
            p.hyc();
        }
        this.wdk = new com.tencent.mm.media.widget.camerarecordview.a(aVar3);
        if (recordConfigProvider.scene == 11) {
            com.tencent.mm.modelcontrol.e baZ = com.tencent.mm.modelcontrol.e.baZ();
            p.g(baZ, "SubCoreVideoControl.getCore()");
            long j2 = ((long) baZ.bbe().minDuration) * 1000;
            if (j2 >= 1000) {
                com.tencent.mm.media.widget.camerarecordview.a aVar4 = this.wdk;
                if (aVar4 != null) {
                    aVar4.zU(j2);
                }
            } else {
                com.tencent.mm.media.widget.camerarecordview.a aVar5 = this.wdk;
                if (aVar5 != null) {
                    aVar5.zU(1000);
                }
            }
        } else {
            com.tencent.mm.media.widget.camerarecordview.a aVar6 = this.wdk;
            if (aVar6 != null) {
                aVar6.zU(1000);
            }
        }
        this.wcW.a(recordConfigProvider);
        Bundle bundle = recordConfigProvider.jkf;
        String string = bundle != null ? bundle.getString("KEY_ORIGIN_MUSIC_PATH") : null;
        if (!Util.isNullOrNil(string)) {
            Bundle bundle2 = recordConfigProvider.jkf;
            if (bundle2 == null || (str = bundle2.getString("KEY_ORIGIN_MUSIC_NAME")) == null) {
                str = "";
            }
            p.g(str, "configProvider.extra?.ge…_ORIGIN_MUSIC_NAME) ?: \"\"");
            Bundle bundle3 = recordConfigProvider.jkf;
            if (bundle3 != null) {
                bundle3.getString("KEY_ORIGIN_MUSIC_ID");
            }
            MultiMediaVideoChecker multiMediaVideoChecker = MultiMediaVideoChecker.GyY;
            if (string == null) {
                str2 = "";
            } else {
                str2 = string;
            }
            MultiMediaVideoChecker.a aTW = MultiMediaVideoChecker.aTW(str2);
            if (aTW == null || aTW.duration == 0) {
                Log.e("Finder.FinderRecordPluginLayout", "follow music error, path:" + string + ", length:" + s.boW(string));
                onBackPress();
                AppMethodBeat.o(168005);
                return;
            }
            AudioCacheInfo audioCacheInfo = new AudioCacheInfo();
            audioCacheInfo.aXa = true;
            audioCacheInfo.BPb = true;
            audioCacheInfo.cachePath = string;
            audioCacheInfo.aIa(str);
            audioCacheInfo.duration = (int) aTW.duration;
            com.tencent.mm.plugin.finder.video.plugin.a aVar7 = this.wdf;
            List<AudioCacheInfo> listOf = kotlin.a.j.listOf(audioCacheInfo);
            p.h(listOf, "audioList");
            aVar7.wgL.setLocalAudioList(listOf);
            com.tencent.mm.plugin.finder.video.plugin.a aVar8 = this.wdf;
            com.tencent.mm.plugin.recordvideo.b.d dVar = new com.tencent.mm.plugin.recordvideo.b.d();
            Integer valueOf = recordConfigProvider != null ? Integer.valueOf(recordConfigProvider.scene) : null;
            if (valueOf != null && valueOf.intValue() == 2) {
                dVar.a(com.tencent.mm.plugin.recordvideo.b.i.SNSComm);
                if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_video_editor_lyrics_enable, 0) == 1) {
                    z = true;
                } else {
                    z = false;
                }
                dVar.BNb = z;
            } else if (valueOf != null && valueOf.intValue() == 1) {
                dVar.a(com.tencent.mm.plugin.recordvideo.b.i.Chatting);
            } else if (valueOf != null && valueOf.intValue() == 3) {
                dVar.a(com.tencent.mm.plugin.recordvideo.b.i.StoryComm);
                dVar.BNb = true;
                dVar.BNe = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_story_visitor_enable, false);
            } else if (valueOf != null && valueOf.intValue() == 5) {
                dVar.a(com.tencent.mm.plugin.recordvideo.b.i.WXGGame);
            } else if (valueOf != null && valueOf.intValue() == 11) {
                dVar.a(com.tencent.mm.plugin.recordvideo.b.i.Finder);
                dVar.BNb = false;
            }
            dVar.BNd = false;
            EditorAudioView.a(aVar8.wgL, "", new ArrayList(), -1, -1, false, dVar, true, 16);
            this.wdf.autoPlay = false;
            this.wdg.setVisibility(0);
            com.tencent.mm.media.widget.camerarecordview.a aVar9 = this.wdk;
            if (aVar9 != null) {
                aVar9.setMute(true);
            }
            a aVar10 = this.wdj;
            if (aVar10 != null) {
                aVar10.isb = true;
            }
            this.wcW.BRC = R.string.fw_;
            com.tencent.f.h.RTc.aV(new b(this));
            this.ilM = false;
            this.wcW.BRy = false;
        } else {
            this.wdg.setVisibility(8);
        }
        this.wcZ.a(recordConfigProvider);
        this.wcX.a(recordConfigProvider);
        this.wda.a(recordConfigProvider);
        this.wdn.a(recordConfigProvider);
        StringBuilder append = new StringBuilder("configProvider:").append(recordConfigProvider).append(", config:");
        com.tencent.mm.plugin.recordvideo.b.g gVar = com.tencent.mm.plugin.recordvideo.b.g.BNx;
        Log.i("Finder.FinderRecordPluginLayout", append.append(com.tencent.mm.plugin.recordvideo.b.g.eJx()).toString());
        AppMethodBeat.o(168005);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ FinderRecordPluginLayout wdu;

        b(FinderRecordPluginLayout finderRecordPluginLayout) {
            this.wdu = finderRecordPluginLayout;
        }

        public final void run() {
            AppMethodBeat.i(254072);
            this.wdu.wcW.eKI();
            AppMethodBeat.o(254072);
        }
    }

    private final void setPreviewRatio(float f2) {
        AppMethodBeat.i(168009);
        if (isFullscreenMode()) {
            this.wcV.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            AppMethodBeat.o(168009);
            return;
        }
        Context context = MMApplicationContext.getContext();
        p.g(context, "MMApplicationContext.getContext()");
        Resources resources = context.getResources();
        p.g(resources, "MMApplicationContext.getContext().resources");
        int i2 = resources.getDisplayMetrics().widthPixels;
        int i3 = (int) (((float) i2) / f2);
        Log.i("Finder.FinderRecordPluginLayout", "[setPreviewSize] width=" + i2 + " height=" + i3);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i2, i3);
        layoutParams.topMargin = com.tencent.mm.cb.a.aG(getContext(), R.dimen.a5c);
        this.wcV.setLayoutParams(layoutParams);
        AppMethodBeat.o(168009);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t, com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
    public final void onResume() {
        AppMethodBeat.i(254087);
        super.onResume();
        if (this.wds) {
            Context context = getContext();
            if (context == null) {
                t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(254087);
                throw tVar;
            }
            oL(com.tencent.mm.pluginsdk.permission.b.e((Activity) context, "android.permission.RECORD_AUDIO"));
        }
        cMT();
        com.tencent.mm.plugin.mmsight.model.d dVar = this.orientationEventListener;
        if (dVar != null) {
            dVar.enable();
        }
        com.tencent.mm.media.widget.camerarecordview.a aVar = this.wdk;
        if (aVar != null) {
            this.wda.oS(aVar.ipt);
            com.tencent.mm.media.widget.camerarecordview.a.a(aVar, this.ilM, f.wdw, 2);
        }
        this.wcW.setVisibility(0);
        AppMethodBeat.o(254087);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t, com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
    public final void onPause() {
        AppMethodBeat.i(254088);
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
        AppMethodBeat.o(254088);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t, com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
    public final void release() {
        AppMethodBeat.i(254089);
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
                com.tencent.f.h.RTc.aZ(new g(this));
            }
            AppMethodBeat.o(254089);
            return;
        }
        AppMethodBeat.o(254089);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class g implements Runnable {
        final /* synthetic */ FinderRecordPluginLayout wdu;

        g(FinderRecordPluginLayout finderRecordPluginLayout) {
            this.wdu = finderRecordPluginLayout;
        }

        public final void run() {
            AppMethodBeat.i(254079);
            RecordConfigProvider recordConfigProvider = this.wdu.wdm;
            s.deleteFile(recordConfigProvider != null ? recordConfigProvider.BOB : null);
            AppMethodBeat.o(254079);
        }
    }

    @Override // com.tencent.mm.plugin.mmsight.model.d.a
    public final void onOrientationChange(int i2) {
        float f2;
        AppMethodBeat.i(254090);
        if (i2 < 0) {
            AppMethodBeat.o(254090);
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
        AppMethodBeat.o(254090);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t, com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
    public final void onDetach() {
        AppMethodBeat.i(254091);
        super.onDetach();
        Log.i("Finder.FinderRecordPluginLayout", "onDetach");
        com.tencent.mm.media.widget.camerarecordview.a aVar = this.wdk;
        if (aVar != null) {
            aVar.stopPreview();
            AppMethodBeat.o(254091);
            return;
        }
        AppMethodBeat.o(254091);
    }

    private final void cMT() {
        VideoTransPara videoTransPara;
        AppMethodBeat.i(168007);
        RecordConfigProvider recordConfigProvider = this.wdm;
        if (recordConfigProvider == null || (videoTransPara = recordConfigProvider.BOm) == null) {
            AppMethodBeat.o(168007);
            return;
        }
        Log.i("Finder.FinderRecordPluginLayout", "onResume init SightRecordConfig");
        com.tencent.mm.plugin.recordvideo.b.g gVar = com.tencent.mm.plugin.recordvideo.b.g.BNx;
        com.tencent.mm.plugin.recordvideo.b.g.a(videoTransPara, 0, isFullscreenMode());
        AppMethodBeat.o(168007);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.parent.d
    public final void a(d.c cVar, Bundle bundle) {
        boolean z;
        com.tencent.mm.sticker.f bit;
        float f2;
        boolean z2;
        long j2;
        boolean z3;
        int i2;
        AppMethodBeat.i(254092);
        p.h(cVar, "status");
        Log.i("Finder.FinderRecordPluginLayout", "status : " + cVar + "  param: " + bundle);
        switch (h.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                RecordConfigProvider recordConfigProvider = this.wdm;
                if (recordConfigProvider == null || !recordConfigProvider.BOG) {
                    z3 = false;
                    i2 = 0;
                } else {
                    com.tencent.mm.plugin.mmsight.model.d dVar = this.orientationEventListener;
                    z3 = dVar != null ? dVar.isLandscape() : false;
                    com.tencent.mm.plugin.mmsight.model.d dVar2 = this.orientationEventListener;
                    i2 = dVar2 != null ? dVar2.getOrientation() : 0;
                }
                com.tencent.mm.media.widget.camerarecordview.a aVar = this.wdk;
                if (aVar != null) {
                    Boolean.valueOf(aVar.j(z3, i2));
                }
                this.wdf.autoPlay = false;
                com.tencent.mm.plugin.recordvideo.b.g gVar = com.tencent.mm.plugin.recordvideo.b.g.BNx;
                com.tencent.mm.plugin.recordvideo.b.g.eJC();
                com.tencent.mm.plugin.recordvideo.d.c cVar2 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                com.tencent.mm.plugin.recordvideo.d.c.x("KEY_START_RECORD_MS_LONG", Long.valueOf(System.currentTimeMillis()));
                this.wda.setVisibility(4);
                this.wdd.setVisibility(4);
                this.wde.setVisibility(8);
                this.wdc.setVisibility(4);
                this.wcX.setVisibility(8);
                if (this.wdc.whp) {
                    com.tencent.mm.plugin.recordvideo.d.c cVar3 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                    com.tencent.mm.plugin.recordvideo.d.c.aLu("KEY_SUB_VIDEO_RECORD_CLICK_INT");
                    y yVar = y.vih;
                    y.Q(228, 1);
                    this.wdf.seekTo(this.gLd);
                } else {
                    y yVar2 = y.vih;
                    y.Q(210, 1);
                    this.wdf.seekTo(0);
                }
                this.wdf.resume();
                AppMethodBeat.o(254092);
                return;
            case 2:
                this.wdf.pause();
                this.wdb.BXq.eKU();
                com.tencent.mm.media.widget.camerarecordview.a aVar2 = this.wdk;
                if (aVar2 != null && !aVar2.p(new i(this, bundle))) {
                    if (this.wdc.whp) {
                        y yVar3 = y.vih;
                        y.Q(230, 1);
                        this.wcW.QS(this.wdn.wha.size());
                        this.wdb.m(Integer.valueOf(this.wdn.wha.size()));
                        Float v = kotlin.a.j.v((Iterable<Float>) this.wcW.getSubProgress());
                        this.gLd = (long) (((v != null ? v.floatValue() : 0.0f) / 100.0f) * ((float) this.wdr));
                        if (this.wdn.wha.isEmpty()) {
                            this.wdc.setVisibility(0);
                            this.wdf.autoPlay = false;
                            this.wda.setVisibility(0);
                            this.wdd.setVisibility(8);
                        } else {
                            this.wde.setVisibility(0);
                            this.wda.setVisibility(8);
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
                            this.wda.setVisibility(0);
                            this.wdf.autoPlay = false;
                        } else {
                            this.wcW.eKH();
                        }
                    }
                }
                this.wcX.setVisibility(0);
                AppMethodBeat.o(254092);
                return;
            case 3:
                if (bundle != null) {
                    this.wcW.td(!bundle.getBoolean("PARAM_1_BOOLEAN"));
                    if (bundle.getBoolean("PARAM_1_BOOLEAN")) {
                        this.gLd = 0;
                        this.wcW.BRC = this.wdf.wgG == null ? R.string.fx1 : R.string.fw_;
                        this.wcW.eKI();
                        this.wcW.ae(true, isFullscreenMode());
                        this.wdb.reset();
                        this.wdb.setVisibility(0);
                        com.tencent.mm.plugin.recordvideo.d.c cVar4 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                        com.tencent.mm.plugin.recordvideo.d.c.x("KEY_IS_SUB_RECORD_BOOLEAN", Boolean.TRUE);
                        com.tencent.mm.plugin.recordvideo.d.c cVar5 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                        com.tencent.mm.plugin.recordvideo.d.c.aLu("KEY_CHANGE_SUB_RECORD_TAB_INT");
                    } else {
                        this.wcW.BRC = this.wdf.wgG == null ? R.string.fw6 : R.string.fw_;
                        this.wcW.eKI();
                        this.wcW.ae(false, isFullscreenMode());
                        this.wdb.setVisibility(4);
                        com.tencent.mm.plugin.recordvideo.d.c cVar6 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                        com.tencent.mm.plugin.recordvideo.d.c.x("KEY_IS_SUB_RECORD_BOOLEAN", Boolean.FALSE);
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(254092);
                    return;
                }
                AppMethodBeat.o(254092);
                return;
            case 4:
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
                        x xVar2 = x.SXb;
                    }
                    x xVar3 = x.SXb;
                    AppMethodBeat.o(254092);
                    return;
                }
                AppMethodBeat.o(254092);
                return;
            case 5:
                if (bundle != null) {
                    com.tencent.mm.media.widget.camerarecordview.a aVar5 = this.wdk;
                    if (aVar5 != null) {
                        aVar5.rz(bundle.getInt("PARAM_PREPARE_CAMERA_ZOOM_LOCATION_INT"));
                        x xVar4 = x.SXb;
                    }
                    x xVar5 = x.SXb;
                    AppMethodBeat.o(254092);
                    return;
                }
                AppMethodBeat.o(254092);
                return;
            case 6:
                if (bundle != null) {
                    com.tencent.mm.media.widget.camerarecordview.a aVar6 = this.wdk;
                    if (aVar6 != null) {
                        boolean z4 = bundle.getBoolean("PARAM_PREPARE_CAMERA_ZOOM_BOOLEAN", false);
                        bundle.getBoolean("PARAM_PREPARE_CAMERA_ZOOM_SCROLL_BOOLEAN", true);
                        aVar6.i(z4, bundle.getInt("PARAM_PREPARE_CAMERA_ZOOM_FACTOR_INT"));
                        x xVar6 = x.SXb;
                    }
                    x xVar7 = x.SXb;
                }
                AppMethodBeat.o(254092);
                return;
            case 7:
                com.tencent.mm.media.widget.camerarecordview.a aVar7 = this.wdk;
                this.ilM = aVar7 != null ? com.tencent.mm.media.widget.camerarecordview.a.b(aVar7) : true;
                com.tencent.mm.plugin.finder.video.plugin.b bVar2 = this.wda;
                com.tencent.mm.media.widget.camerarecordview.a aVar8 = this.wdk;
                if (aVar8 != null) {
                    z2 = aVar8.ipt;
                } else {
                    z2 = false;
                }
                bVar2.oS(z2);
                this.wcY.tf(!this.ilM);
                AppMethodBeat.o(254092);
                return;
            case 8:
                float f3 = bundle != null ? bundle.getFloat("PARAM_POINT_X") : 0.0f;
                float f4 = bundle != null ? bundle.getFloat("PARAM_POINT_Y") : 0.0f;
                com.tencent.mm.media.widget.camerarecordview.a aVar9 = this.wdk;
                if (aVar9 != null) {
                    aVar9.b(f3, f4, this.wcV.getWidth(), this.wcV.getHeight());
                    x xVar8 = x.SXb;
                    AppMethodBeat.o(254092);
                    return;
                }
                AppMethodBeat.o(254092);
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
                    aVar10.r(new j(this, currentTicks, f2));
                    x xVar9 = x.SXb;
                    AppMethodBeat.o(254092);
                    return;
                }
                AppMethodBeat.o(254092);
                return;
            case 10:
                boolean z5 = bundle != null ? bundle.getBoolean("PARAM_BEAUTIFY_ENABLE") : false;
                a aVar11 = this.wdj;
                com.tencent.mm.media.j.a previewRenderer = aVar11 != null ? aVar11.getPreviewRenderer() : null;
                if (!(previewRenderer instanceof com.tencent.mm.plugin.recordvideo.c.b)) {
                    previewRenderer = null;
                }
                this.wcV.j(new k(this, (com.tencent.mm.plugin.recordvideo.c.b) previewRenderer, z5));
                AppMethodBeat.o(254092);
                return;
            case 11:
                y yVar5 = y.vih;
                y.Q(192, 1);
                this.wdb.rl(true);
                this.wcW.rl(true);
                AppMethodBeat.o(254092);
                return;
            case 12:
                this.wdb.rl(false);
                this.wcW.rl(false);
                AppMethodBeat.o(254092);
                return;
            case 13:
                y yVar6 = y.vih;
                y.Q(193, 1);
                this.wdn.dFT();
                this.wcW.QS(this.wdn.wha.size());
                this.wdb.m(Integer.valueOf(this.wdn.wha.size()));
                Float v2 = kotlin.a.j.v((Iterable<Float>) this.wcW.getSubProgress());
                this.gLd = (long) (((v2 != null ? v2.floatValue() : 0.0f) / 100.0f) * ((float) this.wdr));
                if (this.wdn.wha.isEmpty()) {
                    this.wdc.setVisibility(0);
                    this.wde.setVisibility(8);
                    this.wda.setVisibility(0);
                    this.wdd.setVisibility(4);
                    this.wdf.autoPlay = false;
                    AppMethodBeat.o(254092);
                    return;
                }
                break;
            case 14:
                this.wdf.pause();
                if (this.wdc.whp) {
                    com.tencent.mm.plugin.recordvideo.d.c cVar8 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                    com.tencent.mm.plugin.recordvideo.d.c.x("KEY_SUB_VIDEO_NUM_INT", Integer.valueOf(this.wdn.dFV().size()));
                }
                if (!this.wdc.whp || this.wdn.wha.isEmpty()) {
                    Context context = getContext();
                    if (context == null) {
                        t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.activity.MMRecordUI");
                        AppMethodBeat.o(254092);
                        throw tVar;
                    }
                    ((MMRecordUI) context).eIF();
                    AppMethodBeat.o(254092);
                    return;
                }
                y yVar7 = y.vih;
                y.Q(194, 1);
                this.wcX.kvo.show();
                AppMethodBeat.o(254092);
                return;
            case 15:
                if (this.wdc.whp) {
                    y yVar8 = y.vih;
                    y.Q(229, 1);
                    y yVar9 = y.vih;
                    y.ah(this.wdn.dFV());
                    com.tencent.mm.plugin.recordvideo.d.c cVar9 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                    com.tencent.mm.plugin.recordvideo.d.c.x("KEY_SUB_VIDEO_NUM_INT", Integer.valueOf(this.wdn.dFV().size()));
                } else {
                    this.wdf.autoPlay = false;
                }
                com.tencent.mm.media.widget.camerarecordview.b.b bVar3 = new com.tencent.mm.media.widget.camerarecordview.b.b(null, null, false, null, null, null, null, null, null, 65535);
                ArrayList<String> dFV = this.wdn.dFV();
                String str3 = dFV.get(0);
                p.g(str3, "videoList[0]");
                bVar3.Hw(str3);
                bVar3.t(dFV);
                bVar3.iqf = true;
                bVar3.aQr();
                RecordConfigProvider recordConfigProvider2 = this.wdm;
                if (recordConfigProvider2 != null) {
                    recordConfigProvider2.jkf = am(this.wdn.dFU());
                }
                int a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_flutter_video_editor, 0);
                com.tencent.mm.plugin.finder.storage.c cVar10 = com.tencent.mm.plugin.finder.storage.c.vCb;
                boolean z6 = com.tencent.mm.plugin.finder.storage.c.dxh().value().intValue() == 1 || a2 == 1;
                Log.i("Finder.FinderRecordPluginLayout.FlutterVideoEditor_DataReport", "openFlutterVideoEditor %d useFlutterVideoEditor:%s", Integer.valueOf(a2), Boolean.valueOf(z6));
                if (z6) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1565, 0);
                    Log.i("Finder.FinderRecordPluginLayout.FlutterVideoEditor_DataReport", "click next step in album activity");
                    Bundle bundle2 = new Bundle();
                    ArrayList<String> arrayList3 = new ArrayList<>();
                    Iterator<String> it = bVar3.iqn.iterator();
                    while (it.hasNext()) {
                        it.next();
                        arrayList3.add("video");
                    }
                    bundle2.putStringArrayList("pathList", bVar3.iqn);
                    bundle2.putStringArrayList("typeList", arrayList3);
                    ((com.tencent.mm.plugin.flutter.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.flutter.a.a.class)).a(getContext(), 304, bundle2);
                    AppMethodBeat.o(254092);
                    return;
                }
                com.tencent.mm.plugin.recordvideo.activity.a aVar12 = this.wdl;
                if (aVar12 != null) {
                    aVar12.a(4, bVar3);
                    x xVar10 = x.SXb;
                    AppMethodBeat.o(254092);
                    return;
                }
                AppMethodBeat.o(254092);
                return;
            case 16:
                if (!(bundle != null ? bundle.getBoolean("PARAM_STICKER_PANEL_OPEN") : false)) {
                    this.wdi.setVisibility(0);
                    AppMethodBeat.o(254092);
                    return;
                }
                this.wdi.setVisibility(4);
                AppMethodBeat.o(254092);
                return;
            case 17:
                String string = bundle != null ? bundle.getString("PARAM_STICKER_LENS_ID") : null;
                a aVar13 = this.wdj;
                com.tencent.mm.media.j.a previewRenderer2 = aVar13 != null ? aVar13.getPreviewRenderer() : null;
                if (!(previewRenderer2 instanceof com.tencent.mm.plugin.recordvideo.c.b)) {
                    previewRenderer2 = null;
                }
                com.tencent.mm.plugin.recordvideo.c.b bVar4 = (com.tencent.mm.plugin.recordvideo.c.b) previewRenderer2;
                if (bVar4 != null) {
                    if (string == null) {
                        bit = null;
                    } else {
                        f.a aVar14 = com.tencent.mm.sticker.f.NNw;
                        com.tencent.mm.sticker.loader.e eVar = com.tencent.mm.sticker.loader.e.NNN;
                        bit = f.a.bit(com.tencent.mm.sticker.loader.e.biw(string));
                    }
                    this.wcV.j(new h(bVar4, bit, this, string));
                    x xVar11 = x.SXb;
                    AppMethodBeat.o(254092);
                    return;
                }
                AppMethodBeat.o(254092);
                return;
            case 18:
                this.wdf.wgL.setShow(true);
                AppMethodBeat.o(254092);
                return;
            case 19:
                com.tencent.mm.plugin.finder.video.plugin.g gVar2 = this.wdg;
                AudioCacheInfo audioCacheInfo = this.wdf.wgG;
                gVar2.whj = audioCacheInfo;
                gVar2.whk = audioCacheInfo != null;
                gVar2.dFW();
                com.tencent.mm.media.widget.camerarecordview.a aVar15 = this.wdk;
                if (aVar15 != null) {
                    aVar15.setMute(this.wdf.wgG != null);
                    x xVar12 = x.SXb;
                }
                a aVar16 = this.wdj;
                if (aVar16 != null) {
                    if (this.wdf.wgG != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    aVar16.isb = z;
                }
                this.wcW.BRC = this.wdf.wgG == null ? R.string.fw6 : R.string.fw_;
                this.wcW.eKI();
                AudioCacheInfo audioCacheInfo2 = this.wdf.wgG;
                if (audioCacheInfo2 != null) {
                    this.wcW.BRs = audioCacheInfo2.duration;
                    this.wdg.Gt((long) audioCacheInfo2.duration);
                    this.wdr = (long) audioCacheInfo2.duration;
                    x xVar13 = x.SXb;
                }
                if (this.wdf.wgG == null) {
                    w wVar = this.wcW;
                    wVar.BRs = wVar.BRt + 250;
                    this.wdg.Gt((long) this.wcW.BRs);
                    this.wdr = (long) this.wcW.BRs;
                    AppMethodBeat.o(254092);
                    return;
                }
                break;
            case 20:
                this.wdf.autoPlay = true;
                this.wdf.resume();
                AppMethodBeat.o(254092);
                return;
            case 21:
                AppMethodBeat.o(254092);
                return;
            case 22:
                this.wdc.setVisibility(4);
                this.wdf.pause();
                v vVar = this.wdh;
                vVar.wgo.setText(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
                vVar.wgn.setVisibility(0);
                vVar.wgp.start();
                this.wdf.autoPlay = false;
                AppMethodBeat.o(254092);
                return;
            case 23:
                this.wdc.setVisibility(0);
                v vVar2 = this.wdh;
                vVar2.wgp.cancel();
                vVar2.wgn.setVisibility(8);
                this.wdf.autoPlay = false;
                AppMethodBeat.o(254092);
                return;
            case 24:
                this.wcW.bFT();
                AppMethodBeat.o(254092);
                return;
            default:
                Log.i("Finder.FinderRecordPluginLayout", "unknown status ".concat(String.valueOf(cVar)));
                break;
        }
        AppMethodBeat.o(254092);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
    public final void a(com.tencent.mm.media.widget.camerarecordview.b.b bVar) {
        AppMethodBeat.i(254093);
        super.a(bVar);
        setBackgroundColor(Color.parseColor("#000000"));
        this.wdc.setVisibility(8);
        if (this.wdc.whp) {
            this.wde.setVisibility(0);
            this.wdd.setVisibility(0);
            this.wdb.setVisibility(0);
            AppMethodBeat.o(254093);
            return;
        }
        this.wdc.setVisibility(0);
        this.wda.setVisibility(0);
        this.wdb.reset();
        this.wdn.dFT();
        AppMethodBeat.o(254093);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t, com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
    public final boolean onBackPress() {
        AppMethodBeat.i(254094);
        if (super.onBackPress()) {
            AppMethodBeat.o(254094);
            return true;
        }
        d.b.a(this, d.c.BWW);
        AppMethodBeat.o(254094);
        return false;
    }

    private final Bundle am(ArrayList<GalleryItem.MediaItem> arrayList) {
        boolean z;
        String str;
        String str2;
        String str3;
        String str4;
        Bundle bundle;
        Bundle bundle2;
        Bundle bundle3;
        Bundle bundle4;
        Bundle bundle5;
        Bundle bundle6;
        byte[] bArr = null;
        AppMethodBeat.i(254095);
        Bundle bundle7 = new Bundle();
        bundle7.putParcelableArrayList("media_list", arrayList);
        RecordConfigProvider recordConfigProvider = this.wdm;
        bundle7.putString(ShareConstants.WEB_DIALOG_RESULT_PARAM_POST_ID, (recordConfigProvider == null || (bundle6 = recordConfigProvider.jkf) == null) ? null : bundle6.getString(ShareConstants.WEB_DIALOG_RESULT_PARAM_POST_ID));
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        bundle7.putLong("video_max_duration", ((long) com.tencent.mm.plugin.finder.storage.c.drG()) * 1000);
        com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
        bundle7.putInt("image_max_height", com.tencent.mm.plugin.finder.storage.c.dqP());
        com.tencent.mm.plugin.finder.storage.c cVar3 = com.tencent.mm.plugin.finder.storage.c.vCb;
        bundle7.putInt("image_max_width", com.tencent.mm.plugin.finder.storage.c.dqO());
        com.tencent.mm.plugin.finder.storage.c cVar4 = com.tencent.mm.plugin.finder.storage.c.vCb;
        bundle7.putInt("image_compress_quality", com.tencent.mm.plugin.finder.storage.c.dqQ());
        al alVar = al.waC;
        bundle7.putString("output_dir", al.dEG());
        a aVar = this.wdj;
        if (aVar != null) {
            z = aVar.isb;
        } else {
            z = false;
        }
        bundle7.putBoolean("KEY_MEDIA_MUTE", z);
        RecordConfigProvider recordConfigProvider2 = this.wdm;
        if (recordConfigProvider2 == null || (bundle5 = recordConfigProvider2.jkf) == null) {
            str = null;
        } else {
            str = bundle5.getString("KEY_ORIGIN_BGM_URL");
        }
        bundle7.putString("KEY_ORIGIN_BGM_URL", str);
        com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
        bundle7.putBoolean("KEY_FULLSCREEN", com.tencent.mm.plugin.finder.utils.y.isAnyEnableFullScreenEnjoy());
        bundle7.putInt("KEY_MEDIA_SOURCE_FROM", 2);
        AudioCacheInfo audioCacheInfo = this.wdf.wgG;
        if (audioCacheInfo != null) {
            if (audioCacheInfo.BPb) {
                RecordConfigProvider recordConfigProvider3 = this.wdm;
                if (recordConfigProvider3 == null || (bundle4 = recordConfigProvider3.jkf) == null) {
                    str2 = null;
                } else {
                    str2 = bundle4.getString("KEY_ORIGIN_MUSIC_ID");
                }
                bundle7.putString("KEY_ORIGIN_MUSIC_ID", str2);
                RecordConfigProvider recordConfigProvider4 = this.wdm;
                if (recordConfigProvider4 == null || (bundle3 = recordConfigProvider4.jkf) == null) {
                    str3 = null;
                } else {
                    str3 = bundle3.getString("KEY_ORIGIN_MUSIC_PATH");
                }
                bundle7.putString("KEY_ORIGIN_MUSIC_PATH", str3);
                RecordConfigProvider recordConfigProvider5 = this.wdm;
                if (recordConfigProvider5 == null || (bundle2 = recordConfigProvider5.jkf) == null) {
                    str4 = null;
                } else {
                    str4 = bundle2.getString("KEY_ORIGIN_MUSIC_NAME");
                }
                bundle7.putString("KEY_ORIGIN_MUSIC_NAME", str4);
                RecordConfigProvider recordConfigProvider6 = this.wdm;
                if (!(recordConfigProvider6 == null || (bundle = recordConfigProvider6.jkf) == null)) {
                    bArr = bundle.getByteArray("KEY_ORIGIN_MUSIC_INFO");
                }
                bundle7.putByteArray("KEY_ORIGIN_MUSIC_INFO", bArr);
            } else {
                bundle7.putParcelable("KEY_SELECT_AUDIO_INFO", audioCacheInfo);
            }
            bundle7.putBoolean("KEY_MEDIA_MUTE", true);
        }
        AppMethodBeat.o(254095);
        return bundle7;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t, com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(254096);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        Log.i("MicroMsg.RecordPluginLayout", "onRequestPermissionsResult requestCode:" + i2 + " permissions:" + strArr + " grantResults:" + iArr);
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 == 80) {
            if (iArr[0] == 0) {
                oL(true);
                AppMethodBeat.o(254096);
                return;
            }
            com.tencent.mm.ui.base.h.a(getContext(), com.tencent.mm.cb.a.aI(getContext(), R.string.fvk), com.tencent.mm.cb.a.aI(getContext(), R.string.fvm), com.tencent.mm.cb.a.aI(getContext(), R.string.fvl), com.tencent.mm.cb.a.aI(getContext(), R.string.fvj), false, (DialogInterface.OnClickListener) new d(this), (DialogInterface.OnClickListener) new e(this));
        }
        AppMethodBeat.o(254096);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    static final class d implements DialogInterface.OnClickListener {
        final /* synthetic */ FinderRecordPluginLayout wdu;

        d(FinderRecordPluginLayout finderRecordPluginLayout) {
            this.wdu = finderRecordPluginLayout;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(254075);
            dialogInterface.dismiss();
            this.wdu.wds = true;
            Context context = this.wdu.getContext();
            if (context == null) {
                t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(254075);
                throw tVar;
            }
            Activity activity = (Activity) context;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/finder/video/FinderRecordPluginLayout$onRequestPermissionsResult$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            activity.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/finder/video/FinderRecordPluginLayout$onRequestPermissionsResult$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(254075);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    static final class e implements DialogInterface.OnClickListener {
        final /* synthetic */ FinderRecordPluginLayout wdu;

        e(FinderRecordPluginLayout finderRecordPluginLayout) {
            this.wdu = finderRecordPluginLayout;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(254076);
            dialogInterface.dismiss();
            FinderRecordPluginLayout.l(this.wdu);
            AppMethodBeat.o(254076);
        }
    }

    private final void oL(boolean z) {
        boolean z2;
        AppMethodBeat.i(254097);
        a aVar = this.wdj;
        if (aVar != null) {
            if (!z) {
                z2 = true;
            } else {
                z2 = false;
            }
            aVar.isb = z2;
        }
        com.tencent.mm.media.widget.camerarecordview.a aVar2 = this.wdk;
        if (aVar2 != null) {
            aVar2.aQf();
        }
        if (z) {
            this.wcW.eKG();
            AppMethodBeat.o(254097);
            return;
        }
        this.wcW.c(new l(this));
        AppMethodBeat.o(254097);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class l implements View.OnClickListener {
        final /* synthetic */ FinderRecordPluginLayout wdu;

        l(FinderRecordPluginLayout finderRecordPluginLayout) {
            this.wdu = finderRecordPluginLayout;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(254085);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/FinderRecordPluginLayout$updateRecordTipByAudioPermission$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.wdu.wds = true;
            Context context = this.wdu.getContext();
            if (context == null) {
                t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(254085);
                throw tVar;
            }
            Activity activity = (Activity) context;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/finder/video/FinderRecordPluginLayout$updateRecordTipByAudioPermission$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            activity.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/finder/video/FinderRecordPluginLayout$updateRecordTipByAudioPermission$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/FinderRecordPluginLayout$updateRecordTipByAudioPermission$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(254085);
        }
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t, com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(254098);
        super.onActivityResult(i2, i3, intent);
        if (i2 == 304 && i3 == 0) {
            a((com.tencent.mm.media.widget.camerarecordview.b.b) null);
            AppMethodBeat.o(254098);
            return;
        }
        if (i2 == 304 && i3 == -1) {
            onBackPress();
        }
        AppMethodBeat.o(254098);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<Boolean> {
        public static final c wdv = new c();

        static {
            AppMethodBeat.i(254074);
            AppMethodBeat.o(254074);
        }

        c() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            AppMethodBeat.i(254073);
            com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
            Boolean valueOf = Boolean.valueOf(com.tencent.mm.plugin.finder.utils.y.isAnyEnableFullScreenEnjoy());
            AppMethodBeat.o(254073);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class k extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ boolean hLa;
        final /* synthetic */ FinderRecordPluginLayout wdu;
        final /* synthetic */ com.tencent.mm.plugin.recordvideo.c.b wdx;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(FinderRecordPluginLayout finderRecordPluginLayout, com.tencent.mm.plugin.recordvideo.c.b bVar, boolean z) {
            super(0);
            this.wdu = finderRecordPluginLayout;
            this.wdx = bVar;
            this.hLa = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            XEffectConfig xEffectConfig;
            com.tencent.mm.plugin.recordvideo.c.b bVar;
            AppMethodBeat.i(254084);
            RecordConfigProvider recordConfigProvider = this.wdu.wdm;
            if (!(recordConfigProvider == null || (xEffectConfig = recordConfigProvider.BOJ) == null || (bVar = this.wdx) == null)) {
                bVar.a(xEffectConfig);
            }
            com.tencent.mm.plugin.recordvideo.c.b bVar2 = this.wdx;
            if (bVar2 != null) {
                bVar2.ti(this.hLa);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(254084);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/video/FinderRecordPluginLayout$statusChange$8$1"})
    static final class h extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ com.tencent.mm.sticker.f rsy;
        final /* synthetic */ FinderRecordPluginLayout wdu;
        final /* synthetic */ com.tencent.mm.plugin.recordvideo.c.b wdx;
        final /* synthetic */ String wdy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(com.tencent.mm.plugin.recordvideo.c.b bVar, com.tencent.mm.sticker.f fVar, FinderRecordPluginLayout finderRecordPluginLayout, String str) {
            super(0);
            this.wdx = bVar;
            this.rsy = fVar;
            this.wdu = finderRecordPluginLayout;
            this.wdy = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(254081);
            com.tencent.mm.plugin.xlabeffect.b bVar = this.wdx.hiH;
            if (bVar != null) {
                bVar.a(this.rsy);
            }
            if (this.rsy != null) {
                com.tencent.mm.ac.d.a(2000, new kotlin.g.a.a<x>(this) {
                    /* class com.tencent.mm.plugin.finder.video.FinderRecordPluginLayout.h.AnonymousClass1 */
                    final /* synthetic */ h wdz;

                    {
                        this.wdz = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        AppMethodBeat.i(254080);
                        com.tencent.mm.plugin.xlabeffect.b bVar = this.wdz.wdx.hiH;
                        if (p.j(bVar != null ? Boolean.valueOf(bVar.JRh) : null, Boolean.FALSE)) {
                            Toast.makeText(this.wdz.wdu.wcV.getContext(), (int) R.string.fws, 0).show();
                        }
                        x xVar = x.SXb;
                        AppMethodBeat.o(254080);
                        return xVar;
                    }
                });
            }
            x xVar = x.SXb;
            AppMethodBeat.o(254081);
            return xVar;
        }
    }
}
