package com.tencent.mm.plugin.recordvideo.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ab;
import com.tencent.mm.api.u;
import com.tencent.mm.api.x;
import com.tencent.mm.api.z;
import com.tencent.mm.bt.a;
import com.tencent.mm.e.b;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.view.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 R2\u00020\u0001:\u0001RB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.J\u001e\u0010/\u001a\u00020,2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u000f2\u0006\u00103\u001a\u00020\u000fJ\u0006\u00104\u001a\u00020,J\u0006\u00105\u001a\u00020,J\u0006\u00106\u001a\u00020,J\u0006\u00107\u001a\u00020,J\u0006\u00108\u001a\u00020,J\u0006\u00109\u001a\u00020,J\u000e\u0010:\u001a\u00020,2\u0006\u0010;\u001a\u00020\u000fJ\u0016\u0010<\u001a\u00020,2\u0006\u0010;\u001a\u00020\u000f2\u0006\u0010=\u001a\u00020>J\u0006\u0010?\u001a\u00020,J\u0006\u0010@\u001a\u00020,J\u0010\u0010A\u001a\u00020,2\u0006\u0010B\u001a\u00020CH\u0002J\b\u0010D\u001a\u00020\u0015H\u0002J\u000e\u0010E\u001a\u00020,2\u0006\u0010F\u001a\u00020GJ\b\u0010H\u001a\u00020\u0015H\u0016J\b\u0010I\u001a\u00020,H\u0016J\b\u0010J\u001a\u00020,H\u0016J\u0016\u0010K\u001a\u00020,2\u0006\u0010L\u001a\u00020\u000f2\u0006\u0010M\u001a\u00020\u000fJ\u0016\u0010N\u001a\u00020,2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010O\u001a\u00020,J\u0006\u0010P\u001a\u00020,J\u0006\u0010Q\u001a\u00020,R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001c\u001a\u00020\u00178BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001b\u001a\u0004\b\u001d\u0010\u0019R\u000e\u0010\u001f\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006S"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoContainerPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "photoLayout", "Landroid/widget/FrameLayout;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/widget/FrameLayout;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "captureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "curIndex", "", "curType", "Lcom/tencent/mm/api/FeaturesType;", "drawingView", "Lcom/tencent/mm/view/PhotoDrawingView;", "isFinishing", "", "mLandscapePhotoEditor", "Lcom/tencent/mm/api/MMPhotoEditor;", "getMLandscapePhotoEditor", "()Lcom/tencent/mm/api/MMPhotoEditor;", "mLandscapePhotoEditor$delegate", "Lkotlin/Lazy;", "mPortraitPhotoEditor", "getMPortraitPhotoEditor", "mPortraitPhotoEditor$delegate", "moved", "photoEditor", "presenter", "Lcom/tencent/mm/presenter/IPresenter;", "getPresenter", "()Lcom/tencent/mm/presenter/IPresenter;", "setPresenter", "(Lcom/tencent/mm/presenter/IPresenter;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "addEmoji", "", "emojiInfo", "Lcom/tencent/mm/api/IEmojiInfo;", "addText", "text", "Landroid/text/Editable;", "color", "bgcolor", "cropCancel", "cropFinish", "cropRotate", "cropUndo", "doBrush", "doCrop", "doDoodle", FirebaseAnalytics.b.INDEX, "doFilter", "colorWeight", "", "doFinish", "doMosaic", "handleDispatch", "event", "Landroid/view/MotionEvent;", "isCanRevert", "loadPhotoEditLogic", "path", "", "onBackPress", "release", "reset", "setOutputSize", "width", "height", "setup", "showEmojiPanel", "showTextPanel", "unDo", "Companion", "plugin-recordvideo_release"})
public final class j implements t {
    public static final a BQv = new a((byte) 0);
    public com.tencent.mm.media.widget.camerarecordview.b.b BQt;
    public m BQu;
    public final Context context = this.zQv.getContext();
    private boolean gMK;
    private boolean isFinishing;
    public int sTB = -1;
    public RecordConfigProvider wdm;
    com.tencent.mm.plugin.recordvideo.plugin.parent.d wgr;
    public ab zCl;
    private final kotlin.f zQm = kotlin.g.ah(h.BQA);
    private final kotlin.f zQn = kotlin.g.ah(g.BQz);
    public com.tencent.mm.bt.b zQp;
    public com.tencent.mm.api.h zQt = com.tencent.mm.api.h.DEFAULT;
    public FrameLayout zQv;

    static {
        AppMethodBeat.i(75540);
        AppMethodBeat.o(75540);
    }

    public final ab eKz() {
        AppMethodBeat.i(169938);
        ab abVar = (ab) this.zQn.getValue();
        AppMethodBeat.o(169938);
        return abVar;
    }

    public final ab eow() {
        AppMethodBeat.i(169937);
        ab abVar = (ab) this.zQm.getValue();
        AppMethodBeat.o(169937);
        return abVar;
    }

    public j(FrameLayout frameLayout, com.tencent.mm.plugin.recordvideo.plugin.parent.d dVar) {
        p.h(frameLayout, "photoLayout");
        p.h(dVar, "status");
        AppMethodBeat.i(75539);
        this.zQv = frameLayout;
        this.wgr = dVar;
        AppMethodBeat.o(75539);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void aSs() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final String name() {
        return null;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onActivityResult(int i2, int i3, Intent intent) {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onDetach() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onPause() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(237290);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        AppMethodBeat.o(237290);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onResume() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void setVisibility(int i2) {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoContainerPlugin$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/recordvideo/plugin/EditPhotoContainerPlugin$loadPhotoEditLogic$2", "Lcom/tencent/mm/presenter/DrawingPresenter$onTextChangeListener;", "onTextChange", "", "item", "Lcom/tencent/mm/items/TextItem;", "onTextMove", "", "isMoving", "plugin-recordvideo_release"})
    public static final class c implements a.c {
        final /* synthetic */ j BQw;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public c(j jVar) {
            this.BQw = jVar;
        }

        @Override // com.tencent.mm.bt.a.c
        public final /* synthetic */ void l(Boolean bool) {
            AppMethodBeat.i(163430);
            if (bool.booleanValue()) {
                d.b.a(this.BQw.wgr, d.c.BVi);
                AppMethodBeat.o(163430);
                return;
            }
            d.b.a(this.BQw.wgr, d.c.BVj);
            AppMethodBeat.o(163430);
        }

        @Override // com.tencent.mm.bt.a.c
        public final boolean b(com.tencent.mm.z.f fVar) {
            AppMethodBeat.i(163429);
            p.h(fVar, "item");
            Bundle bundle = new Bundle();
            bundle.putCharSequence("PARAM_EDIT_TEXT_CONTENT", fVar.hoI);
            bundle.putInt("PARAM_EDIT_TEXT_COLOR", fVar.mColor);
            bundle.putInt("PARAM_EDIT_TEXT_COLOR_BG_INT", fVar.mBgColor);
            this.BQw.wgr.a(d.c.BVd, bundle);
            AppMethodBeat.o(163429);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, hxF = {"com/tencent/mm/plugin/recordvideo/plugin/EditPhotoContainerPlugin$loadPhotoEditLogic$3", "Lcom/tencent/mm/api/ISelectedFeatureListener;", "onSelectedDetailFeature", "", "features", "Lcom/tencent/mm/api/FeaturesType;", FirebaseAnalytics.b.INDEX, "", NativeProtocol.WEB_DIALOG_PARAMS, "", "onSelectedFeature", "showVKB", "isShow", "", "plugin-recordvideo_release"})
    public static final class d implements z {
        final /* synthetic */ j BQw;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public d(j jVar) {
            this.BQw = jVar;
        }

        @Override // com.tencent.mm.api.z
        public final void a(com.tencent.mm.api.h hVar) {
            AppMethodBeat.i(163431);
            p.h(hVar, "features");
            Log.i("MicroMsg.EditPhotoPluginLayout", "[onSelectedFeature] features:%s", hVar.name());
            if (hVar == com.tencent.mm.api.h.DEFAULT) {
                d.b.a(this.BQw.wgr, d.c.BVS);
            }
            AppMethodBeat.o(163431);
        }

        @Override // com.tencent.mm.api.z
        public final void a(com.tencent.mm.api.h hVar, int i2, Object obj) {
            AppMethodBeat.i(163432);
            p.h(hVar, "features");
            Log.i("MicroMsg.EditPhotoPluginLayout", "[onSelectedDetailFeature] features:%s index:%s", hVar.name(), Integer.valueOf(i2));
            AppMethodBeat.o(163432);
        }

        @Override // com.tencent.mm.api.z
        public final void cH(boolean z) {
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MotionEvent;", "kotlin.jvm.PlatformType", "onDispatchTouch"})
    public static final class e implements b.a {
        final /* synthetic */ j BQw;

        public e(j jVar) {
            this.BQw = jVar;
        }

        @Override // com.tencent.mm.e.b.a
        public final boolean q(MotionEvent motionEvent) {
            AppMethodBeat.i(75534);
            j jVar = this.BQw;
            p.g(motionEvent, LocaleUtil.ITALIAN);
            j.a(jVar, motionEvent);
            AppMethodBeat.o(75534);
            return false;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MotionEvent;", "kotlin.jvm.PlatformType", "onDispatchTouch"})
    public static final class f implements b.a {
        final /* synthetic */ j BQw;

        public f(j jVar) {
            this.BQw = jVar;
        }

        @Override // com.tencent.mm.e.b.a
        public final boolean q(MotionEvent motionEvent) {
            AppMethodBeat.i(163433);
            j jVar = this.BQw;
            p.g(motionEvent, LocaleUtil.ITALIAN);
            j.a(jVar, motionEvent);
            AppMethodBeat.o(163433);
            return false;
        }
    }

    public final void eKA() {
        AppMethodBeat.i(237288);
        this.zQt = com.tencent.mm.api.h.DEFAULT;
        com.tencent.mm.bt.b bVar = this.zQp;
        if (bVar != null) {
            bVar.getSelectedFeatureListener().a(com.tencent.mm.api.h.CROP_PHOTO, 2, null);
            AppMethodBeat.o(237288);
            return;
        }
        AppMethodBeat.o(237288);
    }

    public final void eKB() {
        AppMethodBeat.i(75535);
        this.zQt = com.tencent.mm.api.h.DEFAULT;
        com.tencent.mm.bt.b bVar = this.zQp;
        if (bVar != null) {
            bVar.getSelectedFeatureListener().a(com.tencent.mm.api.h.CROP_PHOTO, 1, null);
            AppMethodBeat.o(75535);
            return;
        }
        AppMethodBeat.o(75535);
    }

    public final void setOutputSize(int i2, int i3) {
        AppMethodBeat.i(261699);
        com.tencent.mm.bt.b bVar = this.zQp;
        if (bVar != null) {
            bVar.setOutputSize(i2, i3);
            AppMethodBeat.o(261699);
            return;
        }
        AppMethodBeat.o(261699);
    }

    public final void dJF() {
        x xVar;
        x xVar2;
        x xVar3;
        x xVar4;
        x xVar5;
        x xVar6;
        x xVar7;
        AppMethodBeat.i(237289);
        com.tencent.mm.plugin.recordvideo.d.c cVar = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        ab abVar = this.zCl;
        x Um = abVar != null ? abVar.Um() : null;
        if (Um == null) {
            p.hyc();
        }
        com.tencent.mm.plugin.recordvideo.d.c.x("KEY_ADD_EMOJI_COUNT_INT", Integer.valueOf(Um.Vy()));
        com.tencent.mm.plugin.recordvideo.d.c cVar2 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        ab abVar2 = this.zCl;
        if (abVar2 != null) {
            xVar = abVar2.Um();
        } else {
            xVar = null;
        }
        if (xVar == null) {
            p.hyc();
        }
        com.tencent.mm.plugin.recordvideo.d.c.x("KEY_ADD_TEXT_COUNT_INT", Integer.valueOf(xVar.Vx()));
        com.tencent.mm.plugin.recordvideo.d.c cVar3 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        ab abVar3 = this.zCl;
        if (abVar3 != null) {
            xVar2 = abVar3.Um();
        } else {
            xVar2 = null;
        }
        if (xVar2 == null) {
            p.hyc();
        }
        com.tencent.mm.plugin.recordvideo.d.c.x("KEY_ADD_DOODLE_COUNT_INT", Integer.valueOf(xVar2.VA()));
        com.tencent.mm.plugin.recordvideo.d.c cVar4 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        ab abVar4 = this.zCl;
        if (abVar4 != null) {
            xVar3 = abVar4.Um();
        } else {
            xVar3 = null;
        }
        if (xVar3 == null) {
            p.hyc();
        }
        com.tencent.mm.plugin.recordvideo.d.c.x("KEY_ADD_DOODLE_COLOR_COUNT_INT", Integer.valueOf(xVar3.VD()));
        com.tencent.mm.plugin.recordvideo.d.c cVar5 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        ab abVar5 = this.zCl;
        if (abVar5 != null) {
            xVar4 = abVar5.Um();
        } else {
            xVar4 = null;
        }
        if (xVar4 == null) {
            p.hyc();
        }
        com.tencent.mm.plugin.recordvideo.d.c.x("KEY_ADD_MOSAIC_COUNT_INT", Integer.valueOf(xVar4.Vz()));
        com.tencent.mm.plugin.recordvideo.d.c cVar6 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        ab abVar6 = this.zCl;
        if (abVar6 != null) {
            xVar5 = abVar6.Um();
        } else {
            xVar5 = null;
        }
        if (xVar5 == null) {
            p.hyc();
        }
        com.tencent.mm.plugin.recordvideo.d.c.x("KEY_ROTATE_INT", Integer.valueOf(xVar5.VC() ? 1 : 0));
        com.tencent.mm.plugin.recordvideo.d.c cVar7 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        com.tencent.mm.plugin.recordvideo.d.c.x("KEY_AFTER_EDIT_INT", 1);
        com.tencent.mm.plugin.recordvideo.d.g gVar = com.tencent.mm.plugin.recordvideo.d.g.BXY;
        int[] iArr = new int[3];
        ab abVar7 = this.zCl;
        if (abVar7 != null) {
            xVar6 = abVar7.Um();
        } else {
            xVar6 = null;
        }
        if (xVar6 == null) {
            p.hyc();
        }
        iArr[0] = xVar6.Vy();
        ab abVar8 = this.zCl;
        x Um2 = abVar8 != null ? abVar8.Um() : null;
        if (Um2 == null) {
            p.hyc();
        }
        iArr[1] = Um2.Vx();
        iArr[2] = -1;
        com.tencent.mm.plugin.recordvideo.d.g.J(iArr);
        com.tencent.mm.plugin.recordvideo.d.g gVar2 = com.tencent.mm.plugin.recordvideo.d.g.BXY;
        com.tencent.mm.plugin.recordvideo.d.g.ax(1, 2);
        ab abVar9 = this.zCl;
        if (abVar9 != null) {
            xVar7 = abVar9.Um();
        } else {
            xVar7 = null;
        }
        if (xVar7 == null) {
            p.hyc();
        }
        boolean VE = xVar7.VE();
        com.tencent.mm.plugin.recordvideo.d.c cVar8 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        com.tencent.mm.plugin.recordvideo.d.c.x("KEY_PHOTO_IS_EDITED_BOOLEAN", Boolean.valueOf(VE));
        if (VE) {
            com.tencent.mm.media.k.e eVar = com.tencent.mm.media.k.e.ilC;
            com.tencent.mm.media.k.e.aNL();
        }
        com.tencent.mm.media.k.e eVar2 = com.tencent.mm.media.k.e.ilC;
        com.tencent.mm.media.k.e.aNS();
        if (!this.isFinishing) {
            Context context2 = this.context;
            if (context2 == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(237289);
                throw tVar;
            } else if (!((Activity) context2).isFinishing()) {
                this.isFinishing = true;
                long currentTicks = Util.currentTicks();
                Log.i("MicroMsg.EditPhotoPluginLayout", "dofinish time: " + currentTicks + ' ' + VE);
                ab abVar10 = this.zCl;
                if (abVar10 != null) {
                    abVar10.a(new b(this, currentTicks, VE));
                    AppMethodBeat.o(237289);
                    return;
                }
                AppMethodBeat.o(237289);
                return;
            }
        }
        AppMethodBeat.o(237289);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/recordvideo/plugin/EditPhotoContainerPlugin$doFinish$1", "Lcom/tencent/mm/api/IGenerateBitmapCallback;", "onError", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "bitmap", "Landroid/graphics/Bitmap;", "isNever", "", "plugin-recordvideo_release"})
    public static final class b implements u {
        final /* synthetic */ j BQw;
        final /* synthetic */ boolean BQx;
        final /* synthetic */ long ipR;

        b(j jVar, long j2, boolean z) {
            this.BQw = jVar;
            this.ipR = j2;
            this.BQx = z;
        }

        @Override // com.tencent.mm.api.u
        public final void onError(Exception exc) {
            AppMethodBeat.i(75527);
            p.h(exc, "e");
            Log.e("MicroMsg.EditPhotoPluginLayout", "photoEditor onError: %s", exc);
            com.tencent.mm.media.k.e eVar = com.tencent.mm.media.k.e.ilC;
            com.tencent.mm.media.k.e.aNQ();
            com.tencent.mm.media.k.e eVar2 = com.tencent.mm.media.k.e.ilC;
            com.tencent.mm.media.k.e.zL(Util.ticksToNow(this.ipR));
            this.BQw.isFinishing = false;
            AppMethodBeat.o(75527);
        }

        @Override // com.tencent.mm.api.u
        public final void a(Bitmap bitmap, boolean z) {
            boolean z2;
            String str = null;
            AppMethodBeat.i(75528);
            Log.i("MicroMsg.EditPhotoPluginLayout", "photoEditor onSuccess: " + bitmap + " isNever：" + z + "  cost:" + Util.ticksToNow(this.ipR));
            com.tencent.mm.media.k.e eVar = com.tencent.mm.media.k.e.ilC;
            com.tencent.mm.media.k.e.zL(Util.ticksToNow(this.ipR));
            if (bitmap == null) {
                com.tencent.mm.media.k.e eVar2 = com.tencent.mm.media.k.e.ilC;
                com.tencent.mm.media.k.e.aNR();
            }
            if (bitmap != null) {
                com.tencent.mm.plugin.recordvideo.d.c cVar = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                com.tencent.mm.plugin.recordvideo.d.c.x("KEY_CROP_MEDIA_WIDTH_INT", Integer.valueOf(bitmap.getWidth()));
                com.tencent.mm.plugin.recordvideo.d.c cVar2 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                com.tencent.mm.plugin.recordvideo.d.c.x("KEY_CROP_MEDIA_HEIGHT_INT", Integer.valueOf(bitmap.getHeight()));
                Log.i("MicroMsg.EditPhotoPluginLayout", "photo width: " + bitmap.getWidth() + "  height:" + bitmap.getHeight());
                Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
                RecordConfigProvider recordConfigProvider = this.BQw.wdm;
                BitmapUtil.saveBitmapToImage(bitmap, 100, compressFormat, recordConfigProvider != null ? recordConfigProvider.BOC : null, true);
                StringBuilder append = new StringBuilder("saveBitmapToImage  cost:").append(Util.ticksToNow(this.ipR)).append("  path:");
                RecordConfigProvider recordConfigProvider2 = this.BQw.wdm;
                if (recordConfigProvider2 != null) {
                    str = recordConfigProvider2.BOC;
                }
                Log.i("MicroMsg.EditPhotoPluginLayout", append.append(str).toString());
                this.BQw.isFinishing = false;
                com.tencent.mm.plugin.recordvideo.e.c cVar3 = com.tencent.mm.plugin.recordvideo.e.c.Cic;
                RecordConfigProvider recordConfigProvider3 = this.BQw.wdm;
                com.tencent.mm.media.widget.camerarecordview.b.b bVar = this.BQw.BQt;
                if (bVar != null) {
                    z2 = bVar.iqf;
                } else {
                    z2 = false;
                }
                com.tencent.mm.plugin.recordvideo.e.c.b(recordConfigProvider3, z2, this.BQx);
                Log.d("MicroMsg.EditPhotoPluginLayout", "new ThreadPool  cost:" + Util.ticksToNow(this.ipR));
                MMHandlerThread.postToMainThread(new a(this));
                AppMethodBeat.o(75528);
                return;
            }
            AppMethodBeat.o(75528);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/plugin/EditPhotoContainerPlugin$doFinish$1$onSuccess$1$1"})
        static final class a implements Runnable {
            final /* synthetic */ b BQy;

            a(b bVar) {
                this.BQy = bVar;
            }

            public final void run() {
                AppMethodBeat.i(75526);
                CaptureDataManager captureDataManager = CaptureDataManager.BOb;
                Context context = this.BQy.BQw.context;
                Boolean bool = Boolean.TRUE;
                RecordConfigProvider recordConfigProvider = this.BQy.BQw.wdm;
                String str = recordConfigProvider != null ? recordConfigProvider.BOC : null;
                Boolean bool2 = Boolean.TRUE;
                com.tencent.mm.plugin.recordvideo.d.c cVar = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                captureDataManager.a(context, new CaptureDataManager.CaptureVideoNormalModel(bool, "", str, -1L, bool2, com.tencent.mm.plugin.recordvideo.d.c.eKW()));
                AppMethodBeat.o(75526);
            }
        }
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void reset() {
        AppMethodBeat.i(75536);
        this.zQt = com.tencent.mm.api.h.DEFAULT;
        com.tencent.mm.bt.b bVar = this.zQp;
        if (bVar != null) {
            bVar.getSelectedFeatureListener().a(com.tencent.mm.api.h.DEFAULT);
        }
        com.tencent.mm.bt.b bVar2 = this.zQp;
        if (bVar2 != null) {
            bVar2.getSelectedFeatureListener().a(com.tencent.mm.api.h.DEFAULT, -1, null);
            AppMethodBeat.o(75536);
            return;
        }
        AppMethodBeat.o(75536);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void release() {
        AppMethodBeat.i(75537);
        eow().onDestroy();
        eKz().onDestroy();
        this.zQv.removeAllViews();
        this.zQv.setVisibility(8);
        com.tencent.mm.bt.b bVar = this.zQp;
        if (bVar != null) {
            bVar.onDestroy();
            AppMethodBeat.o(75537);
            return;
        }
        AppMethodBeat.o(75537);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final boolean onBackPress() {
        AppMethodBeat.i(75538);
        if (this.zQt == com.tencent.mm.api.h.CROP_PHOTO) {
            eKB();
            AppMethodBeat.o(75538);
            return true;
        }
        AppMethodBeat.o(75538);
        return false;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/api/MMPhotoEditor;", "kotlin.jvm.PlatformType", "invoke"})
    static final class h extends q implements kotlin.g.a.a<ab> {
        public static final h BQA = new h();

        static {
            AppMethodBeat.i(169936);
            AppMethodBeat.o(169936);
        }

        h() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ab invoke() {
            AppMethodBeat.i(169935);
            ab Uo = ab.diQ.Uo();
            AppMethodBeat.o(169935);
            return Uo;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/api/MMPhotoEditor;", "kotlin.jvm.PlatformType", "invoke"})
    static final class g extends q implements kotlin.g.a.a<ab> {
        public static final g BQz = new g();

        static {
            AppMethodBeat.i(169934);
            AppMethodBeat.o(169934);
        }

        g() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ab invoke() {
            AppMethodBeat.i(169933);
            ab Uo = ab.diQ.Uo();
            AppMethodBeat.o(169933);
            return Uo;
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static final /* synthetic */ void a(j jVar, MotionEvent motionEvent) {
        AppMethodBeat.i(75541);
        switch (motionEvent.getActionMasked()) {
            case 0:
                jVar.gMK = false;
                AppMethodBeat.o(75541);
                return;
            case 1:
            case 5:
            case 6:
                if (jVar.gMK) {
                    d.b.a(jVar.wgr, d.c.BVH);
                    AppMethodBeat.o(75541);
                    return;
                }
                d.b.a(jVar.wgr, d.c.BVF);
                AppMethodBeat.o(75541);
                return;
            case 2:
                jVar.gMK = true;
                d.b.a(jVar.wgr, d.c.BVG);
                break;
        }
        AppMethodBeat.o(75541);
    }
}
