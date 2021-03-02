package com.tencent.mm.plugin.multitalk.ui.a;

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
import com.tencent.mm.api.h;
import com.tencent.mm.api.u;
import com.tencent.mm.api.z;
import com.tencent.mm.bt.a;
import com.tencent.mm.e.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 t2\u00020\u0001:\u0001tB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010E\u001a\u00020\u000b2\u0006\u0010F\u001a\u00020GJ\u001e\u0010H\u001a\u00020\u000b2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020\u00182\u0006\u0010L\u001a\u00020\u0018J\u0006\u0010M\u001a\u00020\u000bJ\u0006\u0010N\u001a\u00020\u000bJ\u0006\u0010O\u001a\u00020\u000bJ\u0006\u0010P\u001a\u00020\u000bJ\u0006\u0010Q\u001a\u00020\u000bJ\u0006\u0010R\u001a\u00020\u000bJ\u0006\u0010S\u001a\u00020\u000bJ\u0006\u0010T\u001a\u00020\u000bJ\u0006\u0010U\u001a\u00020\u000bJ\u000e\u0010V\u001a\u00020\u000b2\u0006\u0010W\u001a\u00020\u0018J\u0016\u0010X\u001a\u00020\u000b2\u0006\u0010W\u001a\u00020\u00182\u0006\u0010Y\u001a\u00020ZJ\u0006\u0010[\u001a\u00020\u000bJ\u0006\u0010\\\u001a\u00020\u000bJ\u0010\u0010]\u001a\u00020\u000b2\u0006\u0010^\u001a\u00020_H\u0002J\b\u0010`\u001a\u00020+H\u0002J\u0006\u0010a\u001a\u00020\u000bJ\u0016\u0010b\u001a\u00020\u000b2\u0006\u0010c\u001a\u00020+2\u0006\u0010\u0006\u001a\u00020dJ\b\u0010e\u001a\u00020+H\u0016J\u001e\u0010f\u001a\u00020\u000b2\u0006\u0010g\u001a\u00020Z2\u0006\u0010h\u001a\u00020\u00182\u0006\u0010i\u001a\u00020\u0018J*\u0010j\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020d2\u0012\b\u0002\u0010k\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n2\u0006\u0010l\u001a\u00020\u0018J\b\u0010m\u001a\u00020\u000bH\u0016J\b\u0010n\u001a\u00020\u000bH\u0016J\u000e\u0010o\u001a\u00020\u000b2\u0006\u0010p\u001a\u00020+J\u0006\u0010q\u001a\u00020\u000bJ\u0006\u0010r\u001a\u00020\u000bJ\u0006\u0010s\u001a\u00020\u000bR\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\n \u0016*\u0004\u0018\u00010\u00150\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R(\u0010!\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u000b\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010,\u001a\u00020+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001b\u00100\u001a\u0002018BX\u0002¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b2\u00103R\u001b\u00106\u001a\u0002018BX\u0002¢\u0006\f\n\u0004\b8\u00105\u001a\u0004\b7\u00103R\u000e\u00109\u001a\u00020+X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u000101X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010;\u001a\u0004\u0018\u00010<X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010D¨\u0006u"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/editor/MultiTalkEditPhotoContainerPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "photoLayout", "Landroid/widget/FrameLayout;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "config", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;", "(Landroid/widget/FrameLayout;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;)V", "addTextDoneCallback", "Lkotlin/Function0;", "", "getAddTextDoneCallback", "()Lkotlin/jvm/functions/Function0;", "setAddTextDoneCallback", "(Lkotlin/jvm/functions/Function0;)V", "getConfig", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;", "setConfig", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "curIndex", "", "curType", "Lcom/tencent/mm/api/FeaturesType;", "drawingView", "Lcom/tencent/mm/view/MultiTalkDrawingView;", "getDrawingView", "()Lcom/tencent/mm/view/MultiTalkDrawingView;", "setDrawingView", "(Lcom/tencent/mm/view/MultiTalkDrawingView;)V", "editBitmapCallback", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "getEditBitmapCallback", "()Lkotlin/jvm/functions/Function1;", "setEditBitmapCallback", "(Lkotlin/jvm/functions/Function1;)V", "editCache", "", "isFinishing", "", "isLoad", "()Z", "setLoad", "(Z)V", "mLandscapePhotoEditor", "Lcom/tencent/mm/api/MMPhotoEditor;", "getMLandscapePhotoEditor", "()Lcom/tencent/mm/api/MMPhotoEditor;", "mLandscapePhotoEditor$delegate", "Lkotlin/Lazy;", "mPortraitPhotoEditor", "getMPortraitPhotoEditor", "mPortraitPhotoEditor$delegate", "moved", "photoEditor", "presenter", "Lcom/tencent/mm/presenter/IPresenter;", "getPresenter", "()Lcom/tencent/mm/presenter/IPresenter;", "setPresenter", "(Lcom/tencent/mm/presenter/IPresenter;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "addEmoji", "emojiInfo", "Lcom/tencent/mm/api/IEmojiInfo;", "addText", "text", "Landroid/text/Editable;", "color", "bgcolor", "cancelTextAdd", "clearCache", "clearScreen", "cropCancel", "cropFinish", "cropRotate", "cropUndo", "doBrush", "doCrop", "doDoodle", FirebaseAnalytics.b.INDEX, "doFilter", "colorWeight", "", "doFinish", "doMosaic", "handleDispatch", "event", "Landroid/view/MotionEvent;", "isCanRevert", "loadEditLayout", "loadPhotoEditLogic", "isLandscape", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "onBackPress", "onViewStatusChange", "zoom", "transX", "transY", "refreshEditLayout", "callback", "orientation", "release", "reset", "setDrawingEnable", "enable", "showEmojiPanel", "showTextPanel", "unDo", "Companion", "plugin-multitalk_release"})
public final class a implements t {
    public static final C1492a zQx = new C1492a((byte) 0);
    final Context context = this.zQv.getContext();
    private boolean gMK;
    boolean isFinishing;
    int sTB = -1;
    com.tencent.mm.plugin.recordvideo.plugin.parent.d wgr;
    ab zCl;
    private final kotlin.f zQm = kotlin.g.ah(g.zQA);
    private final kotlin.f zQn = kotlin.g.ah(f.zQz);
    public com.tencent.mm.view.l zQo;
    com.tencent.mm.bt.b zQp;
    public String zQq = String.valueOf(System.currentTimeMillis() + ((long) hashCode()));
    kotlin.g.a.a<x> zQr;
    public boolean zQs;
    h zQt = h.DEFAULT;
    kotlin.g.a.b<? super Bitmap, x> zQu;
    private FrameLayout zQv;
    private com.tencent.mm.plugin.multitalk.ui.widget.projector.e zQw;

    static {
        AppMethodBeat.i(239739);
        AppMethodBeat.o(239739);
    }

    private final ab eow() {
        AppMethodBeat.i(239733);
        ab abVar = (ab) this.zQm.getValue();
        AppMethodBeat.o(239733);
        return abVar;
    }

    public a(FrameLayout frameLayout, com.tencent.mm.plugin.recordvideo.plugin.parent.d dVar, com.tencent.mm.plugin.multitalk.ui.widget.projector.e eVar) {
        p.h(frameLayout, "photoLayout");
        p.h(dVar, "status");
        AppMethodBeat.i(239738);
        this.zQv = frameLayout;
        this.wgr = dVar;
        this.zQw = eVar;
        AppMethodBeat.o(239738);
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
        AppMethodBeat.i(239740);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        AppMethodBeat.o(239740);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onResume() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void setVisibility(int i2) {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/editor/MultiTalkEditPhotoContainerPlugin$Companion;", "", "()V", "TAG", "", "plugin-multitalk_release"})
    /* renamed from: com.tencent.mm.plugin.multitalk.ui.a.a$a  reason: collision with other inner class name */
    public static final class C1492a {
        private C1492a() {
        }

        public /* synthetic */ C1492a(byte b2) {
            this();
        }
    }

    public final void b(com.tencent.mm.media.widget.camerarecordview.b.b bVar) {
        com.tencent.mm.e.d dVar;
        com.tencent.mm.view.footer.c cVar;
        com.tencent.mm.view.b.b bVar2;
        boolean z = false;
        AppMethodBeat.i(239734);
        p.h(bVar, "config");
        this.zQs = true;
        this.zQv.setVisibility(0);
        this.zCl = eow();
        if (this.zQq == null) {
            this.zQq = String.valueOf(System.currentTimeMillis() + ((long) hashCode()));
        }
        ab abVar = this.zCl;
        if (abVar != null) {
            abVar.a(new ab.a.C0260a().cJ(true).VH().a(ab.c.SCREEN).cK(false).i(bVar.rect).VI().fN(this.zQq).VJ());
        }
        ab abVar2 = this.zCl;
        com.tencent.mm.api.e bB = abVar2 != null ? abVar2.bB(this.context) : null;
        if (bB == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.view.MultiTalkDrawingView");
            AppMethodBeat.o(239734);
            throw tVar;
        }
        this.zQo = (com.tencent.mm.view.l) bB;
        com.tencent.mm.view.l lVar = this.zQo;
        if (!(lVar == null || (bVar2 = (com.tencent.mm.view.b.b) lVar.getBaseBoardView()) == null)) {
            com.tencent.mm.plugin.multitalk.ui.widget.projector.e eVar = this.zQw;
            if (eVar != null) {
                z = eVar.Ry(9);
            }
            bVar2.DF(z);
        }
        com.tencent.mm.view.l lVar2 = this.zQo;
        if (!(lVar2 == null || (cVar = (com.tencent.mm.view.footer.c) lVar2.getBaseFooterView()) == null)) {
            cVar.setHideFooter(true);
        }
        com.tencent.mm.view.l lVar3 = this.zQo;
        if (lVar3 == null) {
            kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.view.MultiTalkDrawingView");
            AppMethodBeat.o(239734);
            throw tVar2;
        }
        this.zQp = lVar3.getPresenter();
        com.tencent.mm.bt.b bVar3 = this.zQp;
        if (bVar3 == null) {
            kotlin.t tVar3 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.presenter.DrawingPresenter");
            AppMethodBeat.o(239734);
            throw tVar3;
        }
        ((com.tencent.mm.bt.a) bVar3).Kyn = new c(this);
        this.zQv.addView(this.zQo, new FrameLayout.LayoutParams(-1, -1));
        com.tencent.mm.view.l lVar4 = this.zQo;
        if (lVar4 != null) {
            lVar4.setSelectedFeatureListener(new d(this));
        }
        com.tencent.mm.bt.b bVar4 = this.zQp;
        if (bVar4 == null || (dVar = (com.tencent.mm.e.d) bVar4.c(h.DOODLE)) == null) {
            AppMethodBeat.o(239734);
            return;
        }
        dVar.a(new e(this));
        AppMethodBeat.o(239734);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/multitalk/ui/editor/MultiTalkEditPhotoContainerPlugin$loadEditLayout$1", "Lcom/tencent/mm/presenter/DrawingPresenter$onTextChangeListener;", "onTextChange", "", "item", "Lcom/tencent/mm/items/TextItem;", "onTextMove", "", "isMoving", "plugin-multitalk_release"})
    public static final class c implements a.c {
        final /* synthetic */ a zQy;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(a aVar) {
            this.zQy = aVar;
        }

        @Override // com.tencent.mm.bt.a.c
        public final /* synthetic */ void l(Boolean bool) {
            AppMethodBeat.i(239725);
            if (bool.booleanValue()) {
                d.b.a(this.zQy.wgr, d.c.BVi);
                AppMethodBeat.o(239725);
                return;
            }
            d.b.a(this.zQy.wgr, d.c.BVj);
            AppMethodBeat.o(239725);
        }

        @Override // com.tencent.mm.bt.a.c
        public final boolean b(com.tencent.mm.z.f fVar) {
            AppMethodBeat.i(239724);
            p.h(fVar, "item");
            Bundle bundle = new Bundle();
            bundle.putCharSequence("PARAM_EDIT_TEXT_CONTENT", fVar.hoI);
            bundle.putInt("PARAM_EDIT_TEXT_COLOR", fVar.mColor);
            bundle.putInt("PARAM_EDIT_TEXT_COLOR_BG_INT", fVar.mBgColor);
            this.zQy.wgr.a(d.c.BVd, bundle);
            AppMethodBeat.o(239724);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, hxF = {"com/tencent/mm/plugin/multitalk/ui/editor/MultiTalkEditPhotoContainerPlugin$loadEditLayout$2", "Lcom/tencent/mm/api/ISelectedFeatureListener;", "onSelectedDetailFeature", "", "features", "Lcom/tencent/mm/api/FeaturesType;", FirebaseAnalytics.b.INDEX, "", NativeProtocol.WEB_DIALOG_PARAMS, "", "onSelectedFeature", "showVKB", "isShow", "", "plugin-multitalk_release"})
    public static final class d implements z {
        final /* synthetic */ a zQy;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(a aVar) {
            this.zQy = aVar;
        }

        @Override // com.tencent.mm.api.z
        public final void a(h hVar) {
            AppMethodBeat.i(239726);
            p.h(hVar, "features");
            Log.i("MicroMsg.MultiTalkEditPhotoContainerPlugin", "[onSelectedFeature] features:%s", hVar.name());
            if (hVar == h.DEFAULT) {
                d.b.a(this.zQy.wgr, d.c.BVS);
            }
            AppMethodBeat.o(239726);
        }

        @Override // com.tencent.mm.api.z
        public final void a(h hVar, int i2, Object obj) {
            AppMethodBeat.i(239727);
            p.h(hVar, "features");
            Log.i("MicroMsg.MultiTalkEditPhotoContainerPlugin", "[onSelectedDetailFeature] features:%s index:%s", hVar.name(), Integer.valueOf(i2));
            AppMethodBeat.o(239727);
        }

        @Override // com.tencent.mm.api.z
        public final void cH(boolean z) {
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MotionEvent;", "kotlin.jvm.PlatformType", "onDispatchTouch"})
    static final class e implements b.a {
        final /* synthetic */ a zQy;

        e(a aVar) {
            this.zQy = aVar;
        }

        @Override // com.tencent.mm.e.b.a
        public final boolean q(MotionEvent motionEvent) {
            AppMethodBeat.i(239728);
            a aVar = this.zQy;
            p.g(motionEvent, LocaleUtil.ITALIAN);
            a.a(aVar, motionEvent);
            AppMethodBeat.o(239728);
            return false;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/multitalk/ui/editor/MultiTalkEditPhotoContainerPlugin$doFinish$1", "Lcom/tencent/mm/api/IGenerateBitmapCallback;", "onError", "", "p0", "Ljava/lang/Exception;", "onSuccess", "Landroid/graphics/Bitmap;", "p1", "", "plugin-multitalk_release"})
    public static final class b implements u {
        final /* synthetic */ a zQy;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(a aVar) {
            this.zQy = aVar;
        }

        @Override // com.tencent.mm.api.u
        public final void a(Bitmap bitmap, boolean z) {
            kotlin.g.a.b<? super Bitmap, x> bVar;
            AppMethodBeat.i(239722);
            if (bitmap == null || (bVar = this.zQy.zQu) == null) {
                AppMethodBeat.o(239722);
                return;
            }
            bVar.invoke(bitmap);
            AppMethodBeat.o(239722);
        }

        @Override // com.tencent.mm.api.u
        public final void onError(Exception exc) {
            AppMethodBeat.i(239723);
            Log.e("MicroMsg.MultiTalkEditPhotoContainerPlugin", "photoEditor onError: %s", exc);
            this.zQy.isFinishing = false;
            AppMethodBeat.o(239723);
        }
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void reset() {
        AppMethodBeat.i(239735);
        this.zQt = h.DEFAULT;
        com.tencent.mm.bt.b bVar = this.zQp;
        if (bVar != null) {
            bVar.getSelectedFeatureListener().a(h.DEFAULT);
        }
        com.tencent.mm.bt.b bVar2 = this.zQp;
        if (bVar2 != null) {
            bVar2.getSelectedFeatureListener().a(h.DEFAULT, -1, null);
            AppMethodBeat.o(239735);
            return;
        }
        AppMethodBeat.o(239735);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void release() {
        AppMethodBeat.i(239736);
        eow().onDestroy();
        ((ab) this.zQn.getValue()).onDestroy();
        this.zQv.removeAllViews();
        this.zQv.setVisibility(8);
        com.tencent.mm.bt.b bVar = this.zQp;
        if (bVar != null) {
            bVar.onDestroy();
            AppMethodBeat.o(239736);
            return;
        }
        AppMethodBeat.o(239736);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final boolean onBackPress() {
        AppMethodBeat.i(239737);
        if (this.zQt == h.CROP_PHOTO) {
            this.zQt = h.DEFAULT;
            com.tencent.mm.bt.b bVar = this.zQp;
            if (bVar != null) {
                bVar.getSelectedFeatureListener().a(h.CROP_PHOTO, 1, null);
            }
            AppMethodBeat.o(239737);
            return true;
        }
        AppMethodBeat.o(239737);
        return false;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/api/MMPhotoEditor;", "kotlin.jvm.PlatformType", "invoke"})
    static final class g extends q implements kotlin.g.a.a<ab> {
        public static final g zQA = new g();

        static {
            AppMethodBeat.i(239732);
            AppMethodBeat.o(239732);
        }

        g() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ab invoke() {
            AppMethodBeat.i(239731);
            ab Uo = ab.diQ.Uo();
            AppMethodBeat.o(239731);
            return Uo;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/api/MMPhotoEditor;", "kotlin.jvm.PlatformType", "invoke"})
    static final class f extends q implements kotlin.g.a.a<ab> {
        public static final f zQz = new f();

        static {
            AppMethodBeat.i(239730);
            AppMethodBeat.o(239730);
        }

        f() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ab invoke() {
            AppMethodBeat.i(239729);
            ab Uo = ab.diQ.Uo();
            AppMethodBeat.o(239729);
            return Uo;
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static final /* synthetic */ void a(a aVar, MotionEvent motionEvent) {
        AppMethodBeat.i(239741);
        switch (motionEvent.getActionMasked()) {
            case 0:
                aVar.gMK = false;
                AppMethodBeat.o(239741);
                return;
            case 1:
            case 5:
            case 6:
                if (aVar.gMK) {
                    d.b.a(aVar.wgr, d.c.BVH);
                    AppMethodBeat.o(239741);
                    return;
                }
                d.b.a(aVar.wgr, d.c.BVF);
                AppMethodBeat.o(239741);
                return;
            case 2:
                aVar.gMK = true;
                d.b.a(aVar.wgr, d.c.BVG);
                break;
        }
        AppMethodBeat.o(239741);
    }
}
