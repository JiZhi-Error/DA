package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ab;
import com.tencent.mm.api.h;
import com.tencent.mm.api.u;
import com.tencent.mm.api.z;
import com.tencent.mm.bt.a;
import com.tencent.mm.cache.ArtistCacheManager;
import com.tencent.mm.e.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.view.m;
import java.util.Collection;
import java.util.HashMap;
import kotlin.g.a.q;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 ]2\u00020\u0001:\u0002]^B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+J\u001e\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\u000fJ\u0006\u00101\u001a\u00020)J\u0006\u00102\u001a\u00020)J\u0006\u00103\u001a\u00020)J\u0006\u00104\u001a\u00020)J\u0006\u00105\u001a\u00020)J\u0006\u00106\u001a\u00020)J\u000e\u00107\u001a\u00020)2\u0006\u00108\u001a\u00020\u000fJ\u0016\u00109\u001a\u00020)2\u0006\u00108\u001a\u00020\u000f2\u0006\u0010:\u001a\u00020;J]\u0010<\u001a\u00020)2\u0006\u0010=\u001a\u00020\u00162M\u0010>\u001aI\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(B\u0012\u0015\u0012\u0013\u0018\u00010\u0016¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(C\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(D\u0012\u0004\u0012\u00020)0?J\u0006\u0010E\u001a\u00020)J\u0010\u0010F\u001a\u00020)2\u0006\u0010G\u001a\u00020HH\u0002J\b\u0010I\u001a\u00020\u001aH\u0002J\b\u0010J\u001a\u00020\u001aH\u0016J\b\u0010K\u001a\u00020)H\u0016J\u0014\u0010L\u001a\u00020)2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020)0NJ\b\u0010O\u001a\u00020)H\u0016J\b\u0010P\u001a\u00020)H\u0016J&\u0010Q\u001a\u00020)2\u0006\u0010R\u001a\u00020\u000f2\u0006\u0010S\u001a\u00020\u000f2\u0006\u0010T\u001a\u00020\u000f2\u0006\u0010U\u001a\u00020\u000fJ\u0010\u0010V\u001a\u00020)2\u0006\u0010W\u001a\u00020\u000fH\u0016J\u0016\u0010X\u001a\u00020)2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010Y\u001a\u00020)J\u0006\u0010Z\u001a\u00020)J\u0006\u0010[\u001a\u00020)J\u000e\u0010\\\u001a\u00020\u00132\u0006\u0010C\u001a\u00020\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R*\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015j\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017`\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006_"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiPhotoEditContainerPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "photoLayout", "Landroid/widget/FrameLayout;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/widget/FrameLayout;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "captureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "curIndex", "", "curType", "Lcom/tencent/mm/api/FeaturesType;", "drawingView", "Lcom/tencent/mm/view/PhotoDrawingView;", "editorViewDataMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiPhotoEditContainerPlugin$PhotoEditorViewData;", "Lkotlin/collections/HashMap;", "isFinishing", "", "moved", "paddingBottom", "paddingLeft", "paddingRight", "paddingTop", "photoEditor", "Lcom/tencent/mm/api/MMPhotoEditor;", "presenter", "Lcom/tencent/mm/presenter/IPresenter;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "addEmoji", "", "emojiInfo", "Lcom/tencent/mm/api/IEmojiInfo;", "addText", "text", "Landroid/text/Editable;", "color", "bgcolor", "cropCancel", "cropFinish", "cropRotate", "cropUndo", "doBrush", "doCrop", "doDoodle", FirebaseAnalytics.b.INDEX, "doFilter", "colorWeight", "", "doFinish", "sourcePath", "callback", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "ret", "path", "edited", "doMosaic", "handleDispatch", "event", "Landroid/view/MotionEvent;", "isCanRevert", "onBackPress", "onDetach", "post", "r", "Lkotlin/Function0;", "release", "reset", "setDrawingPadding", "left", "top", "right", "bottom", "setVisibility", "visibility", "setup", "showEmojiPanel", "showTextPanel", "unDo", "updatePhotoEdit", "Companion", "PhotoEditorViewData", "plugin-vlog_release"})
public final class t implements com.tencent.mm.plugin.recordvideo.plugin.t {
    public static final a GHX = new a((byte) 0);
    private com.tencent.mm.media.widget.camerarecordview.b.b BQt;
    private m BQu;
    private final HashMap<String, b> GHW = new HashMap<>();
    private final Context context = this.zQv.getContext();
    private boolean gMK;
    private boolean isFinishing;
    private int sTB = -1;
    private RecordConfigProvider wdm;
    com.tencent.mm.plugin.recordvideo.plugin.parent.d wgr;
    private ab zCl;
    private com.tencent.mm.bt.b zQp;
    private h zQt = h.DEFAULT;
    private FrameLayout zQv;

    static {
        AppMethodBeat.i(191416);
        AppMethodBeat.o(191416);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiPhotoEditContainerPlugin$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public t(FrameLayout frameLayout, com.tencent.mm.plugin.recordvideo.plugin.parent.d dVar) {
        p.h(frameLayout, "photoLayout");
        p.h(dVar, "status");
        AppMethodBeat.i(191415);
        this.zQv = frameLayout;
        this.wgr = dVar;
        AppMethodBeat.o(191415);
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
    public final void onPause() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(191417);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        AppMethodBeat.o(191417);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onResume() {
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiPhotoEditContainerPlugin$PhotoEditorViewData;", "", "editor", "Lcom/tencent/mm/api/MMPhotoEditor;", "drawingView", "Lcom/tencent/mm/view/PhotoDrawingView;", "(Lcom/tencent/mm/api/MMPhotoEditor;Lcom/tencent/mm/view/PhotoDrawingView;)V", "getDrawingView", "()Lcom/tencent/mm/view/PhotoDrawingView;", "getEditor", "()Lcom/tencent/mm/api/MMPhotoEditor;", "component1", "component2", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "", "plugin-vlog_release"})
    public static final class b {
        final m BQu;
        final ab GHY;

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
            if (kotlin.g.b.p.j(r3.BQu, r4.BQu) != false) goto L_0x0022;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 191392(0x2eba0, float:2.68197E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x0022
                boolean r0 = r4 instanceof com.tencent.mm.plugin.vlog.ui.plugin.t.b
                if (r0 == 0) goto L_0x0027
                com.tencent.mm.plugin.vlog.ui.plugin.t$b r4 = (com.tencent.mm.plugin.vlog.ui.plugin.t.b) r4
                com.tencent.mm.api.ab r0 = r3.GHY
                com.tencent.mm.api.ab r1 = r4.GHY
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0027
                com.tencent.mm.view.m r0 = r3.BQu
                com.tencent.mm.view.m r1 = r4.BQu
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0027
            L_0x0022:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x0026:
                return r0
            L_0x0027:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x0026
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.vlog.ui.plugin.t.b.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 0;
            AppMethodBeat.i(191391);
            ab abVar = this.GHY;
            int hashCode = (abVar != null ? abVar.hashCode() : 0) * 31;
            m mVar = this.BQu;
            if (mVar != null) {
                i2 = mVar.hashCode();
            }
            int i3 = hashCode + i2;
            AppMethodBeat.o(191391);
            return i3;
        }

        public final String toString() {
            AppMethodBeat.i(191390);
            String str = "PhotoEditorViewData(editor=" + this.GHY + ", drawingView=" + this.BQu + ")";
            AppMethodBeat.o(191390);
            return str;
        }

        public b(ab abVar, m mVar) {
            p.h(abVar, "editor");
            p.h(mVar, "drawingView");
            AppMethodBeat.i(191389);
            this.GHY = abVar;
            this.BQu = mVar;
            AppMethodBeat.o(191389);
        }
    }

    public final void b(RecordConfigProvider recordConfigProvider, com.tencent.mm.media.widget.camerarecordview.b.b bVar) {
        AppMethodBeat.i(191402);
        p.h(recordConfigProvider, "configProvider");
        p.h(bVar, "captureInfo");
        this.wdm = recordConfigProvider;
        this.BQt = bVar;
        AppMethodBeat.o(191402);
    }

    public final void U(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(191403);
        p.h(aVar, "r");
        this.zQv.post(new u(aVar));
        AppMethodBeat.o(191403);
    }

    public final m aUl(String str) {
        ab abVar;
        com.tencent.mm.e.h hVar;
        com.tencent.mm.e.d dVar;
        com.tencent.mm.view.footer.c cVar;
        Bundle bundle;
        float[] floatArray;
        com.tencent.mm.view.b.a baseBoardView;
        m mVar = null;
        boolean z = false;
        AppMethodBeat.i(191404);
        p.h(str, "path");
        Log.i("MicroMsg.MultiPhotoEditContainerPlugin", "updatePhotoEdit path:" + str + ", photoLayout rect:[" + this.zQv.getLeft() + ", " + this.zQv.getTop() + ", " + this.zQv.getRight() + ", " + this.zQv.getBottom() + ']');
        this.zQv.setVisibility(0);
        if (this.GHW.get(str) == null) {
            Log.i("MicroMsg.MultiPhotoEditContainerPlugin", "put new photo editor:".concat(String.valueOf(str)));
            ab Uo = ab.diQ.Uo();
            ab.a.C0260a a2 = new ab.a.C0260a().cJ(fDC()).VH().j(new Rect(this.zQv.getLeft(), this.zQv.getTop(), this.zQv.getRight(), this.zQv.getBottom())).a(ab.c.PHOTO);
            com.tencent.mm.media.widget.camerarecordview.b.b bVar = this.BQt;
            if (bVar != null && bVar.iqf) {
                z = true;
            }
            Uo.a(a2.cK(z).fN(str).VJ());
            com.tencent.mm.api.e bB = Uo.bB(this.context);
            if (bB == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.view.PhotoDrawingView");
                AppMethodBeat.o(191404);
                throw tVar;
            }
            p.g(Uo, "editor");
            this.GHW.put(str, new b(Uo, (m) bB));
        }
        b bVar2 = this.GHW.get(str);
        if (bVar2 != null) {
            abVar = bVar2.GHY;
        } else {
            abVar = null;
        }
        this.zCl = abVar;
        b bVar3 = this.GHW.get(str);
        if (bVar3 != null) {
            mVar = bVar3.BQu;
        }
        this.BQu = mVar;
        ArtistCacheManager.alA().Dn(str);
        com.tencent.mm.cache.c.alF().Dp(Util.nullAs(str, "MicroMsg.MultiPhotoEditContainerPlugin"));
        RecordConfigProvider recordConfigProvider = this.wdm;
        if (!(recordConfigProvider == null || (bundle = recordConfigProvider.jkf) == null || (floatArray = bundle.getFloatArray("matrix")) == null)) {
            Matrix matrix = new Matrix();
            matrix.setValues(floatArray);
            m mVar2 = this.BQu;
            if (!(mVar2 == null || (baseBoardView = mVar2.getBaseBoardView()) == null)) {
                baseBoardView.setForceMatrix(matrix);
            }
        }
        m mVar3 = this.BQu;
        if (!(mVar3 == null || (cVar = (com.tencent.mm.view.footer.c) mVar3.getBaseFooterView()) == null)) {
            cVar.setHideFooter(true);
        }
        m mVar4 = this.BQu;
        if (mVar4 == null) {
            kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.view.PhotoDrawingView");
            AppMethodBeat.o(191404);
            throw tVar2;
        }
        this.zQp = mVar4.getPresenter();
        com.tencent.mm.bt.b bVar4 = this.zQp;
        if (bVar4 != null) {
            bVar4.gtf();
        }
        com.tencent.mm.bt.b bVar5 = this.zQp;
        if (bVar5 == null) {
            kotlin.t tVar3 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.presenter.DrawingPresenter");
            AppMethodBeat.o(191404);
            throw tVar3;
        }
        ((com.tencent.mm.bt.a) bVar5).Kyn = new d(this);
        m mVar5 = this.BQu;
        if (mVar5 != null) {
            mVar5.setSelectedFeatureListener(new e(this));
        }
        com.tencent.mm.bt.b bVar6 = this.zQp;
        if (!(bVar6 == null || (dVar = (com.tencent.mm.e.d) bVar6.c(h.DOODLE)) == null)) {
            dVar.a(new f(this));
        }
        com.tencent.mm.bt.b bVar7 = this.zQp;
        if (!(bVar7 == null || (hVar = (com.tencent.mm.e.h) bVar7.c(h.MOSAIC)) == null)) {
            hVar.a(new g(this));
        }
        BitmapFactory.Options imageOptions = BitmapUtil.getImageOptions(str);
        if (imageOptions != null) {
            com.tencent.mm.plugin.recordvideo.d.c cVar2 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
            com.tencent.mm.plugin.recordvideo.d.c.x("KEY_ORIGIN_MEDIA_WIDTH_INT", Integer.valueOf(imageOptions.outWidth));
            com.tencent.mm.plugin.recordvideo.d.c cVar3 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
            com.tencent.mm.plugin.recordvideo.d.c.x("KEY_ORIGIN_MEDIA_HEIGHT_INT", Integer.valueOf(imageOptions.outHeight));
        }
        m mVar6 = this.BQu;
        if (mVar6 == null) {
            p.hyc();
        }
        AppMethodBeat.o(191404);
        return mVar6;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/vlog/ui/plugin/MultiPhotoEditContainerPlugin$updatePhotoEdit$2", "Lcom/tencent/mm/presenter/DrawingPresenter$onTextChangeListener;", "onTextChange", "", "item", "Lcom/tencent/mm/items/TextItem;", "onTextMove", "", "isMoving", "plugin-vlog_release"})
    public static final class d implements a.c {
        final /* synthetic */ t GHZ;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(t tVar) {
            this.GHZ = tVar;
        }

        @Override // com.tencent.mm.bt.a.c
        public final /* synthetic */ void l(Boolean bool) {
            AppMethodBeat.i(191397);
            if (bool.booleanValue()) {
                d.b.a(this.GHZ.wgr, d.c.BVi);
                AppMethodBeat.o(191397);
                return;
            }
            d.b.a(this.GHZ.wgr, d.c.BVj);
            AppMethodBeat.o(191397);
        }

        @Override // com.tencent.mm.bt.a.c
        public final boolean b(com.tencent.mm.z.f fVar) {
            AppMethodBeat.i(191396);
            p.h(fVar, "item");
            Bundle bundle = new Bundle();
            bundle.putCharSequence("PARAM_EDIT_TEXT_CONTENT", fVar.hoI);
            bundle.putInt("PARAM_EDIT_TEXT_COLOR", fVar.mColor);
            bundle.putInt("PARAM_EDIT_TEXT_COLOR_BG_INT", fVar.mBgColor);
            this.GHZ.wgr.a(d.c.BVd, bundle);
            AppMethodBeat.o(191396);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, hxF = {"com/tencent/mm/plugin/vlog/ui/plugin/MultiPhotoEditContainerPlugin$updatePhotoEdit$3", "Lcom/tencent/mm/api/ISelectedFeatureListener;", "onSelectedDetailFeature", "", "features", "Lcom/tencent/mm/api/FeaturesType;", FirebaseAnalytics.b.INDEX, "", NativeProtocol.WEB_DIALOG_PARAMS, "", "onSelectedFeature", "showVKB", "isShow", "", "plugin-vlog_release"})
    public static final class e implements z {
        final /* synthetic */ t GHZ;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        e(t tVar) {
            this.GHZ = tVar;
        }

        @Override // com.tencent.mm.api.z
        public final void a(h hVar) {
            AppMethodBeat.i(191398);
            p.h(hVar, "features");
            Log.i("MicroMsg.MultiPhotoEditContainerPlugin", "[onSelectedFeature] features:%s", hVar.name());
            if (hVar == h.DEFAULT) {
                d.b.a(this.GHZ.wgr, d.c.BVS);
            }
            AppMethodBeat.o(191398);
        }

        @Override // com.tencent.mm.api.z
        public final void a(h hVar, int i2, Object obj) {
            AppMethodBeat.i(191399);
            p.h(hVar, "features");
            Log.i("MicroMsg.MultiPhotoEditContainerPlugin", "[onSelectedDetailFeature] features:%s index:%s", hVar.name(), Integer.valueOf(i2));
            AppMethodBeat.o(191399);
        }

        @Override // com.tencent.mm.api.z
        public final void cH(boolean z) {
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MotionEvent;", "kotlin.jvm.PlatformType", "onDispatchTouch"})
    public static final class f implements b.a {
        final /* synthetic */ t GHZ;

        f(t tVar) {
            this.GHZ = tVar;
        }

        @Override // com.tencent.mm.e.b.a
        public final boolean q(MotionEvent motionEvent) {
            AppMethodBeat.i(191400);
            t tVar = this.GHZ;
            p.g(motionEvent, LocaleUtil.ITALIAN);
            t.a(tVar, motionEvent);
            AppMethodBeat.o(191400);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MotionEvent;", "kotlin.jvm.PlatformType", "onDispatchTouch"})
    public static final class g implements b.a {
        final /* synthetic */ t GHZ;

        g(t tVar) {
            this.GHZ = tVar;
        }

        @Override // com.tencent.mm.e.b.a
        public final boolean q(MotionEvent motionEvent) {
            AppMethodBeat.i(191401);
            t tVar = this.GHZ;
            p.g(motionEvent, LocaleUtil.ITALIAN);
            t.a(tVar, motionEvent);
            AppMethodBeat.o(191401);
            return false;
        }
    }

    public final void acD(int i2) {
        AppMethodBeat.i(191405);
        this.zQt = h.DOODLE;
        this.sTB = i2;
        com.tencent.mm.bt.b bVar = this.zQp;
        if (bVar != null) {
            bVar.getSelectedFeatureListener().a(h.DOODLE);
        }
        com.tencent.mm.bt.b bVar2 = this.zQp;
        if (bVar2 != null) {
            bVar2.getSelectedFeatureListener().a(h.DOODLE, i2, null);
            AppMethodBeat.o(191405);
            return;
        }
        AppMethodBeat.o(191405);
    }

    public final void fDz() {
        AppMethodBeat.i(191406);
        com.tencent.mm.bt.b bVar = this.zQp;
        if (bVar != null) {
            bVar.getSelectedFeatureListener().a(com.tencent.mm.cache.c.alF().alG(), -1, null);
        }
        com.tencent.mm.bt.b bVar2 = this.zQp;
        if (bVar2 != null) {
            bVar2.getSelectedFeatureListener().a(this.zQt);
        }
        com.tencent.mm.bt.b bVar3 = this.zQp;
        if (bVar3 != null) {
            bVar3.getSelectedFeatureListener().a(this.zQt, this.sTB, null);
            AppMethodBeat.o(191406);
            return;
        }
        AppMethodBeat.o(191406);
    }

    public final void fDA() {
        AppMethodBeat.i(191407);
        this.zQt = h.MOSAIC;
        this.sTB = 0;
        com.tencent.mm.bt.b bVar = this.zQp;
        if (bVar != null) {
            bVar.getSelectedFeatureListener().a(h.MOSAIC);
        }
        com.tencent.mm.bt.b bVar2 = this.zQp;
        if (bVar2 != null) {
            bVar2.getSelectedFeatureListener().a(h.MOSAIC, 0, null);
        }
        com.tencent.mm.plugin.recordvideo.d.c cVar = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        com.tencent.mm.plugin.recordvideo.d.c.aLu("KEY_CLICK_MOSAIC_COUNT_INT");
        com.tencent.mm.plugin.recordvideo.d.c cVar2 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        com.tencent.mm.plugin.recordvideo.d.c.VH(8);
        AppMethodBeat.o(191407);
    }

    public final void fDB() {
        AppMethodBeat.i(191408);
        this.zQt = h.MOSAIC;
        this.sTB = 1;
        com.tencent.mm.bt.b bVar = this.zQp;
        if (bVar != null) {
            bVar.getSelectedFeatureListener().a(h.MOSAIC);
        }
        com.tencent.mm.bt.b bVar2 = this.zQp;
        if (bVar2 != null) {
            bVar2.getSelectedFeatureListener().a(h.MOSAIC, 1, null);
        }
        com.tencent.mm.plugin.recordvideo.d.c cVar = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        com.tencent.mm.plugin.recordvideo.d.c.aLu("KEY_CLICK_BRUSH_COUNT_INT");
        com.tencent.mm.plugin.recordvideo.d.c cVar2 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        com.tencent.mm.plugin.recordvideo.d.c.VH(9);
        AppMethodBeat.o(191408);
    }

    public final void c(String str, q<? super Boolean, ? super String, ? super Boolean, x> qVar) {
        ab abVar;
        com.tencent.mm.api.x xVar;
        com.tencent.mm.api.x xVar2;
        com.tencent.mm.api.x xVar3;
        com.tencent.mm.api.x xVar4;
        com.tencent.mm.api.x xVar5;
        int i2;
        com.tencent.mm.api.x xVar6 = null;
        AppMethodBeat.i(191409);
        p.h(str, "sourcePath");
        p.h(qVar, "callback");
        b bVar = this.GHW.get(str);
        if (bVar != null) {
            abVar = bVar.GHY;
        } else {
            abVar = null;
        }
        this.zCl = abVar;
        if (this.zCl == null) {
            qVar.d(Boolean.TRUE, str, Boolean.FALSE);
            AppMethodBeat.o(191409);
            return;
        }
        ArtistCacheManager.alA().Dn(str);
        com.tencent.mm.cache.c.alF().Dp(Util.nullAs(str, "MicroMsg.MultiPhotoEditContainerPlugin"));
        com.tencent.mm.plugin.recordvideo.d.c cVar = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        ab abVar2 = this.zCl;
        com.tencent.mm.api.x Um = abVar2 != null ? abVar2.Um() : null;
        if (Um == null) {
            p.hyc();
        }
        com.tencent.mm.plugin.recordvideo.d.c.x("KEY_ADD_EMOJI_COUNT_INT", Integer.valueOf(Um.Vy()));
        com.tencent.mm.plugin.recordvideo.d.c cVar2 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        ab abVar3 = this.zCl;
        if (abVar3 != null) {
            xVar = abVar3.Um();
        } else {
            xVar = null;
        }
        if (xVar == null) {
            p.hyc();
        }
        com.tencent.mm.plugin.recordvideo.d.c.x("KEY_ADD_TEXT_COUNT_INT", Integer.valueOf(xVar.Vx()));
        com.tencent.mm.plugin.recordvideo.d.c cVar3 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        ab abVar4 = this.zCl;
        if (abVar4 != null) {
            xVar2 = abVar4.Um();
        } else {
            xVar2 = null;
        }
        if (xVar2 == null) {
            p.hyc();
        }
        com.tencent.mm.plugin.recordvideo.d.c.x("KEY_ADD_DOODLE_COUNT_INT", Integer.valueOf(xVar2.VA()));
        com.tencent.mm.plugin.recordvideo.d.c cVar4 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        ab abVar5 = this.zCl;
        if (abVar5 != null) {
            xVar3 = abVar5.Um();
        } else {
            xVar3 = null;
        }
        if (xVar3 == null) {
            p.hyc();
        }
        com.tencent.mm.plugin.recordvideo.d.c.x("KEY_ADD_DOODLE_COLOR_COUNT_INT", Integer.valueOf(xVar3.VD()));
        com.tencent.mm.plugin.recordvideo.d.c cVar5 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        ab abVar6 = this.zCl;
        if (abVar6 != null) {
            xVar4 = abVar6.Um();
        } else {
            xVar4 = null;
        }
        if (xVar4 == null) {
            p.hyc();
        }
        com.tencent.mm.plugin.recordvideo.d.c.x("KEY_ADD_MOSAIC_COUNT_INT", Integer.valueOf(xVar4.Vz()));
        com.tencent.mm.plugin.recordvideo.d.c cVar6 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        ab abVar7 = this.zCl;
        if (abVar7 != null) {
            xVar5 = abVar7.Um();
        } else {
            xVar5 = null;
        }
        if (xVar5 == null) {
            p.hyc();
        }
        if (xVar5.VC()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        com.tencent.mm.plugin.recordvideo.d.c.x("KEY_ROTATE_INT", Integer.valueOf(i2));
        com.tencent.mm.plugin.recordvideo.d.c cVar7 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        com.tencent.mm.plugin.recordvideo.d.c.x("KEY_AFTER_EDIT_INT", 1);
        ab abVar8 = this.zCl;
        if (abVar8 != null) {
            xVar6 = abVar8.Um();
        }
        if (xVar6 == null) {
            p.hyc();
        }
        boolean VE = xVar6.VE();
        com.tencent.mm.plugin.recordvideo.d.c cVar8 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        com.tencent.mm.plugin.recordvideo.d.c.x("KEY_PHOTO_IS_EDITED_BOOLEAN", Boolean.valueOf(VE));
        if (VE) {
            com.tencent.mm.media.k.e eVar = com.tencent.mm.media.k.e.ilC;
            com.tencent.mm.media.k.e.aNL();
        }
        com.tencent.mm.media.k.e eVar2 = com.tencent.mm.media.k.e.ilC;
        com.tencent.mm.media.k.e.aNS();
        long currentTicks = Util.currentTicks();
        Log.i("MicroMsg.MultiPhotoEditContainerPlugin", "dofinish time: " + currentTicks + ' ' + VE);
        ab abVar9 = this.zCl;
        if (abVar9 != null) {
            abVar9.a(new c(this, currentTicks, qVar, VE));
            AppMethodBeat.o(191409);
            return;
        }
        AppMethodBeat.o(191409);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/vlog/ui/plugin/MultiPhotoEditContainerPlugin$doFinish$1", "Lcom/tencent/mm/api/IGenerateBitmapCallback;", "onError", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "bitmap", "Landroid/graphics/Bitmap;", "isNever", "", "plugin-vlog_release"})
    public static final class c implements u {
        final /* synthetic */ boolean BQx;
        final /* synthetic */ t GHZ;
        final /* synthetic */ long ipR;
        final /* synthetic */ q pDc;

        c(t tVar, long j2, q qVar, boolean z) {
            this.GHZ = tVar;
            this.ipR = j2;
            this.pDc = qVar;
            this.BQx = z;
        }

        @Override // com.tencent.mm.api.u
        public final void onError(Exception exc) {
            AppMethodBeat.i(191393);
            p.h(exc, "e");
            Log.e("MicroMsg.MultiPhotoEditContainerPlugin", "photoEditor onError: %s", exc);
            com.tencent.mm.media.k.e eVar = com.tencent.mm.media.k.e.ilC;
            com.tencent.mm.media.k.e.aNQ();
            com.tencent.mm.media.k.e eVar2 = com.tencent.mm.media.k.e.ilC;
            com.tencent.mm.media.k.e.zL(Util.ticksToNow(this.ipR));
            this.GHZ.isFinishing = false;
            this.pDc.d(Boolean.FALSE, null, Boolean.valueOf(this.BQx));
            AppMethodBeat.o(191393);
        }

        @Override // com.tencent.mm.api.u
        public final void a(Bitmap bitmap, boolean z) {
            boolean z2;
            AppMethodBeat.i(191394);
            Log.i("MicroMsg.MultiPhotoEditContainerPlugin", "photoEditor onSuccess: " + bitmap + " isNever：" + z + "  cost:" + Util.ticksToNow(this.ipR));
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
                Log.i("MicroMsg.MultiPhotoEditContainerPlugin", "photo width: " + bitmap.getWidth() + "  height:" + bitmap.getHeight());
                StringBuilder sb = new StringBuilder();
                com.tencent.mm.plugin.recordvideo.e.c cVar3 = com.tencent.mm.plugin.recordvideo.e.c.Cic;
                String sb2 = sb.append(com.tencent.mm.plugin.recordvideo.e.c.eMK()).append(bitmap.hashCode()).toString();
                BitmapUtil.saveBitmapToImage(bitmap, 100, Bitmap.CompressFormat.JPEG, sb2, true);
                Log.i("MicroMsg.MultiPhotoEditContainerPlugin", "saveBitmapToImage  cost:" + Util.ticksToNow(this.ipR) + "  path:" + sb2);
                this.GHZ.isFinishing = false;
                com.tencent.mm.plugin.recordvideo.e.c cVar4 = com.tencent.mm.plugin.recordvideo.e.c.Cic;
                RecordConfigProvider recordConfigProvider = this.GHZ.wdm;
                com.tencent.mm.media.widget.camerarecordview.b.b bVar = this.GHZ.BQt;
                if (bVar != null) {
                    z2 = bVar.iqf;
                } else {
                    z2 = false;
                }
                com.tencent.mm.plugin.recordvideo.e.c.b(recordConfigProvider, z2, this.BQx);
                Log.d("MicroMsg.MultiPhotoEditContainerPlugin", "new ThreadPool  cost:" + Util.ticksToNow(this.ipR));
                this.pDc.d(Boolean.TRUE, sb2, Boolean.valueOf(this.BQx));
                AppMethodBeat.o(191394);
                return;
            }
            AppMethodBeat.o(191394);
        }
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void reset() {
        AppMethodBeat.i(191410);
        Log.i("MicroMsg.MultiPhotoEditContainerPlugin", "reset");
        this.zQt = h.DEFAULT;
        com.tencent.mm.bt.b bVar = this.zQp;
        if (bVar != null) {
            bVar.getSelectedFeatureListener().a(h.DEFAULT);
        }
        com.tencent.mm.bt.b bVar2 = this.zQp;
        if (bVar2 != null) {
            bVar2.getSelectedFeatureListener().a(h.DEFAULT, -1, null);
            AppMethodBeat.o(191410);
            return;
        }
        AppMethodBeat.o(191410);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onDetach() {
        AppMethodBeat.i(191411);
        Log.i("MicroMsg.MultiPhotoEditContainerPlugin", "release");
        Collection<b> values = this.GHW.values();
        p.g(values, "editorViewDataMap.values");
        for (T t : values) {
            t.GHY.onDestroy();
            t.BQu.getPresenter().onDestroy();
        }
        this.GHW.clear();
        AppMethodBeat.o(191411);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void release() {
        AppMethodBeat.i(191412);
        Log.i("MicroMsg.MultiPhotoEditContainerPlugin", "release");
        Collection<b> values = this.GHW.values();
        p.g(values, "editorViewDataMap.values");
        for (T t : values) {
            t.GHY.onDestroy();
            t.BQu.getPresenter().onDestroy();
        }
        this.GHW.clear();
        this.zQv.removeAllViews();
        this.zQv.setVisibility(8);
        this.zCl = null;
        AppMethodBeat.o(191412);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final boolean onBackPress() {
        AppMethodBeat.i(191413);
        if (this.zQt == h.CROP_PHOTO) {
            this.zQt = h.DEFAULT;
            com.tencent.mm.bt.b bVar = this.zQp;
            if (bVar != null) {
                bVar.getSelectedFeatureListener().a(h.CROP_PHOTO, 1, null);
            }
            AppMethodBeat.o(191413);
            return true;
        }
        AppMethodBeat.o(191413);
        return false;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void setVisibility(int i2) {
        AppMethodBeat.i(191414);
        this.zQv.setVisibility(i2);
        AppMethodBeat.o(191414);
    }

    private final boolean fDC() {
        RecordConfigProvider recordConfigProvider;
        RecordConfigProvider recordConfigProvider2 = this.wdm;
        return (recordConfigProvider2 == null || recordConfigProvider2.scene != 291) && ((recordConfigProvider = this.wdm) == null || recordConfigProvider.scene != 293);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static final /* synthetic */ void a(t tVar, MotionEvent motionEvent) {
        AppMethodBeat.i(191418);
        switch (motionEvent.getActionMasked()) {
            case 0:
                tVar.gMK = false;
                AppMethodBeat.o(191418);
                return;
            case 1:
            case 5:
            case 6:
                if (tVar.gMK) {
                    d.b.a(tVar.wgr, d.c.BVH);
                    AppMethodBeat.o(191418);
                    return;
                }
                d.b.a(tVar.wgr, d.c.BVF);
                AppMethodBeat.o(191418);
                return;
            case 2:
                tVar.gMK = true;
                d.b.a(tVar.wgr, d.c.BVG);
                break;
        }
        AppMethodBeat.o(191418);
    }
}
