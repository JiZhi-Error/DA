package com.tencent.mm.plugin.vlog.ui.plugin.timeedit;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.ui.editor.b.f;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.i;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.n;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.o;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.r;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.plugin.vlog.ui.plugin.v;
import com.tencent.mm.protocal.protobuf.sy;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.a.ae;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.s;
import kotlin.x;

public final class a implements View.OnClickListener, t, v.a {
    public static final C1875a GMH = new C1875a((byte) 0);
    private f GFO;
    public com.tencent.mm.plugin.recordvideo.ui.editor.item.a GMF;
    public TimeEditorItemContainer GMG;
    private boolean onr;
    d wgr;

    static {
        AppMethodBeat.i(191889);
        AppMethodBeat.o(191889);
    }

    public static final class b<T> implements Comparator<com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d> {
        public static final b GMK = new b();

        static {
            AppMethodBeat.i(191856);
            AppMethodBeat.o(191856);
        }

        b() {
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d dVar, com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d dVar2) {
            AppMethodBeat.i(191855);
            com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d dVar3 = dVar;
            com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d dVar4 = dVar2;
            if (dVar3.Cgx.getTime() == dVar4.Cgx.getTime()) {
                AppMethodBeat.o(191855);
                return 0;
            } else if (dVar3.Cgx.getTime() < dVar4.Cgx.getTime()) {
                AppMethodBeat.o(191855);
                return -1;
            } else if (dVar3.Cgx.getTime() != dVar4.Cgx.getTime() || dVar3.Cgy.getTime() >= dVar4.Cgy.getTime()) {
                AppMethodBeat.o(191855);
                return 1;
            } else {
                AppMethodBeat.o(191855);
                return -1;
            }
        }
    }

    public static final class c extends q implements kotlin.g.a.b<ad, Boolean> {
        final /* synthetic */ com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d GML;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d dVar) {
            super(1);
            this.GML = dVar;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(ad adVar) {
            com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d dVar;
            com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d dVar2;
            boolean z;
            AppMethodBeat.i(191857);
            ad adVar2 = adVar;
            p.h(adVar2, LocaleUtil.ITALIAN);
            com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d dVar3 = adVar2.Cev;
            com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d dVar4 = this.GML;
            p.h(dVar4, LocaleUtil.TURKEY);
            if (dVar3.Cgx.getTime() < dVar4.Cgx.getTime()) {
                dVar = dVar3;
                dVar2 = dVar4;
            } else {
                dVar = dVar4;
                dVar2 = dVar3;
            }
            if (dVar.Cgx.getTime() == dVar2.Cgx.getTime() && dVar.Cgy.getTime() == dVar2.Cgy.getTime()) {
                z = true;
            } else if (dVar.Cgy.getTime() > dVar2.Cgx.getTime()) {
                z = true;
            } else {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(191857);
            return valueOf;
        }
    }

    public a(TimeEditorItemContainer timeEditorItemContainer, d dVar) {
        p.h(timeEditorItemContainer, "view");
        p.h(dVar, "status");
        AppMethodBeat.i(191888);
        this.GMG = timeEditorItemContainer;
        this.wgr = dVar;
        this.GMG.setDeleteStateListener(AnonymousClass1.GMI);
        this.GMG.setItemChangeListener(new kotlin.g.a.b<View, x>(this) {
            /* class com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.AnonymousClass2 */
            final /* synthetic */ a GMJ;

            {
                this.GMJ = r2;
            }

            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(View view) {
                AppMethodBeat.i(191849);
                View view2 = view;
                if (view2 instanceof com.tencent.mm.plugin.recordvideo.ui.editor.view.c) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("PARAM_DELETE_VIEW_TYPE_INT", ((com.tencent.mm.plugin.recordvideo.ui.editor.view.c) view2).getType().ordinal());
                    this.GMJ.wgr.a(d.c.BVy, bundle);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(191849);
                return xVar;
            }
        });
        this.GMG.setClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.AnonymousClass3 */
            final /* synthetic */ a GMJ;

            {
                this.GMJ = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(191850);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/timeedit/MultiEditItemContainerPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (view instanceof r) {
                    ((r) view).setEnableNotify(false);
                    ((r) view).setVisibility(4);
                    com.tencent.mm.plugin.recordvideo.ui.editor.item.a editorData = ((r) view).getEditorData();
                    if (editorData == null) {
                        kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.ui.editor.item.TextItem");
                        AppMethodBeat.o(191850);
                        throw tVar;
                    }
                    com.tencent.mm.plugin.recordvideo.ui.editor.item.q qVar = (com.tencent.mm.plugin.recordvideo.ui.editor.item.q) editorData;
                    this.GMJ.GMF = qVar;
                    Bundle bundle = new Bundle();
                    bundle.putCharSequence("PARAM_EDIT_TEXT_CONTENT", qVar.text);
                    bundle.putInt("PARAM_EDIT_TEXT_COLOR", qVar.textColor);
                    bundle.putInt("PARAM_EDIT_TEXT_COLOR_BG_INT", qVar.Cgg);
                    bundle.putString("PARAM_EDIT_TEXT_FONT", qVar.CeI);
                    this.GMJ.wgr.a(d.c.BVd, bundle);
                } else if (view instanceof com.tencent.mm.plugin.recordvideo.ui.editor.a) {
                    ((com.tencent.mm.plugin.recordvideo.ui.editor.a) view).setVisibility(4);
                    sy currentCaption = ((com.tencent.mm.plugin.recordvideo.ui.editor.a) view).getCurrentCaption();
                    com.tencent.mm.plugin.recordvideo.ui.editor.item.a editorData2 = ((com.tencent.mm.plugin.recordvideo.ui.editor.a) view).getEditorData();
                    if (editorData2 == null) {
                        kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.ui.editor.item.CaptionItem");
                        AppMethodBeat.o(191850);
                        throw tVar2;
                    }
                    com.tencent.mm.plugin.recordvideo.ui.editor.item.c cVar = (com.tencent.mm.plugin.recordvideo.ui.editor.item.c) editorData2;
                    if (currentCaption != null) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putByteArray("PARAM_1_BYTEARRAY", currentCaption.toByteArray());
                        bundle2.putInt("PARAM_EDIT_TEXT_COLOR", cVar.textColor);
                        bundle2.putInt("PARAM_EDIT_TEXT_COLOR_BG_INT", cVar.bgColor);
                        bundle2.putString("PARAM_EDIT_TEXT_FONT", cVar.CeI);
                        this.GMJ.wgr.a(d.c.BWq, bundle2);
                    }
                } else if (view instanceof n) {
                    ((n) view).setVisibility(4);
                    com.tencent.mm.plugin.recordvideo.ui.editor.item.a editorData3 = ((n) view).getEditorData();
                    if (editorData3 == null) {
                        kotlin.t tVar3 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.ui.editor.item.PagStickerItem");
                        AppMethodBeat.o(191850);
                        throw tVar3;
                    }
                    this.GMJ.GMF = ((n) view).getEditorData();
                    Bundle bundle3 = new Bundle();
                    bundle3.putCharSequence("PARAM_EDIT_TEXT_CONTENT", ((o) editorData3).text);
                    this.GMJ.wgr.a(d.c.BWH, bundle3);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/timeedit/MultiEditItemContainerPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(191850);
            }
        });
        this.GMG.setTimeEditClickListener(new kotlin.g.a.b<com.tencent.mm.plugin.recordvideo.ui.editor.item.a, x>(this) {
            /* class com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.AnonymousClass4 */
            final /* synthetic */ a GMJ;

            {
                this.GMJ = r2;
            }

            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(com.tencent.mm.plugin.recordvideo.ui.editor.item.a aVar) {
                AppMethodBeat.i(191851);
                com.tencent.mm.plugin.recordvideo.ui.editor.item.a aVar2 = aVar;
                if (aVar2 != null) {
                    this.GMJ.b(aVar2);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(191851);
                return xVar;
            }
        });
        this.GMG.setShowCaptionDialogListener(new kotlin.g.a.b<com.tencent.mm.plugin.recordvideo.ui.editor.a, x>(this) {
            /* class com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.AnonymousClass5 */
            final /* synthetic */ a GMJ;

            {
                this.GMJ = r2;
            }

            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(com.tencent.mm.plugin.recordvideo.ui.editor.a aVar) {
                AppMethodBeat.i(191852);
                com.tencent.mm.plugin.recordvideo.ui.editor.a aVar2 = aVar;
                p.h(aVar2, LocaleUtil.ITALIAN);
                sy currentCaption = aVar2.getCurrentCaption();
                if (currentCaption != null) {
                    aVar2.setVisibility(4);
                    Bundle bundle = new Bundle();
                    bundle.putByteArray("PARAM_1_BYTEARRAY", currentCaption.toByteArray());
                    this.GMJ.wgr.a(d.c.BWr, bundle);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(191852);
                return xVar;
            }
        });
        this.GMG.setReadTextListener(new kotlin.g.a.b<com.tencent.mm.plugin.recordvideo.ui.editor.item.a, x>(this) {
            /* class com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.AnonymousClass6 */
            final /* synthetic */ a GMJ;

            {
                this.GMJ = r2;
            }

            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(com.tencent.mm.plugin.recordvideo.ui.editor.item.a aVar) {
                com.tencent.mm.plugin.recordvideo.ui.editor.item.a aVar2;
                AppMethodBeat.i(191853);
                com.tencent.mm.plugin.recordvideo.ui.editor.item.a aVar3 = aVar;
                if (aVar3 != null) {
                    if (!(aVar3 instanceof i)) {
                        aVar2 = null;
                    } else {
                        aVar2 = aVar3;
                    }
                    i iVar = (i) aVar2;
                    if (iVar == null || !iVar.eMq()) {
                        this.GMJ.GMF = aVar3;
                        d.b.a(this.GMJ.wgr, d.c.BWN);
                    } else {
                        this.GMJ.GMF = aVar3;
                        ((i) aVar3).bh("", 0);
                        d.b.a(this.GMJ.wgr, d.c.BWQ);
                        d.b.a(this.GMJ.wgr, d.c.BWv);
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(191853);
                return xVar;
            }
        });
        this.GMG.setTimeEditMenuChangeListener(new kotlin.g.a.b<Boolean, x>(this) {
            /* class com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.AnonymousClass7 */
            final /* synthetic */ a GMJ;

            {
                this.GMJ = r2;
            }

            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Boolean bool) {
                AppMethodBeat.i(191854);
                if (bool.booleanValue()) {
                    d.b.a(this.GMJ.wgr, d.c.BVr);
                } else {
                    d.b.a(this.GMJ.wgr, d.c.BVs);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(191854);
                return xVar;
            }
        });
        AppMethodBeat.o(191888);
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
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(191890);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        AppMethodBeat.o(191890);
    }

    /* renamed from: com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a$a */
    public static final class C1875a {
        private C1875a() {
        }

        public /* synthetic */ C1875a(byte b2) {
            this();
        }
    }

    public final void b(com.tencent.mm.plugin.recordvideo.ui.editor.item.a aVar) {
        AppMethodBeat.i(191858);
        p.h(aVar, LocaleUtil.ITALIAN);
        this.GMF = aVar;
        d.b.a(this.wgr, d.c.BWh);
        AppMethodBeat.o(191858);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void setVisibility(int i2) {
        AppMethodBeat.i(191859);
        this.GMG.setVisibility(i2);
        AppMethodBeat.o(191859);
    }

    public final void onClick(View view) {
        AppMethodBeat.i(191860);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/timeedit/MultiEditItemContainerPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/timeedit/MultiEditItemContainerPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(191860);
    }

    public static /* synthetic */ void a(a aVar, com.tencent.mm.plugin.recordvideo.ui.editor.item.a aVar2, ad adVar, String str) {
        AppMethodBeat.i(191862);
        aVar.a(aVar2, adVar, str, -1);
        AppMethodBeat.o(191862);
    }

    public final void a(com.tencent.mm.plugin.recordvideo.ui.editor.item.a aVar, ad adVar, String str, long j2) {
        com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d dVar;
        AppMethodBeat.i(191861);
        StringBuilder append = new StringBuilder("addTimeEditItemData ").append(aVar).append(' ');
        if (adVar != null) {
            dVar = adVar.Cev;
        } else {
            dVar = null;
        }
        Log.i("MicroMsg.MultiEditItemContainerPlugin", append.append(dVar).append(' ').append(str).toString());
        if (aVar != null) {
            if (this.GMF == null || !c(aVar)) {
                if (adVar != null) {
                    com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d.a(aVar.Cev, adVar.Cev);
                }
                if (adVar == null && j2 >= 0) {
                    aVar.Cev.ai(j2, 10000 + j2);
                }
                if (str != null) {
                    aVar.objectId = str;
                }
                this.GMG.d(aVar);
            }
            AppMethodBeat.o(191861);
            return;
        }
        AppMethodBeat.o(191861);
    }

    private final boolean c(com.tencent.mm.plugin.recordvideo.ui.editor.item.a aVar) {
        AppMethodBeat.i(191863);
        if (!(this.GMF instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.q) || !(aVar instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.q)) {
            AppMethodBeat.o(191863);
            return false;
        }
        com.tencent.mm.plugin.recordvideo.ui.editor.item.a aVar2 = this.GMF;
        if (aVar2 == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.ui.editor.item.TextItem");
            AppMethodBeat.o(191863);
            throw tVar;
        }
        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.q) aVar2).a((com.tencent.mm.plugin.recordvideo.ui.editor.item.q) aVar);
        TimeEditorItemContainer timeEditorItemContainer = this.GMG;
        com.tencent.mm.plugin.recordvideo.ui.editor.item.a aVar3 = this.GMF;
        if (aVar3 == null) {
            p.hyc();
        }
        timeEditorItemContainer.e(aVar3);
        this.GMF = null;
        AppMethodBeat.o(191863);
        return true;
    }

    public final void c(com.tencent.mm.plugin.recordvideo.ui.editor.item.d dVar) {
        AppMethodBeat.i(191864);
        p.h(dVar, "type");
        this.GMG.d(dVar);
        AppMethodBeat.o(191864);
    }

    public final void fEj() {
        AppMethodBeat.i(191865);
        this.GMG.fEj();
        AppMethodBeat.o(191865);
    }

    public final void fEk() {
        AppMethodBeat.i(191866);
        Log.i("MicroMsg.MultiEditItemContainerPlugin", "enableGif:false");
        this.GMG.Cfa = true;
        AppMethodBeat.o(191866);
    }

    public final void fEl() {
        AppMethodBeat.i(191867);
        Log.i("MicroMsg.MultiEditItemContainerPlugin", "setFullScreen:true");
        this.onr = true;
        AppMethodBeat.o(191867);
    }

    public final void a(RecordConfigProvider recordConfigProvider) {
        AppMethodBeat.i(191868);
        p.h(recordConfigProvider, "configProvider");
        this.GMG.a(recordConfigProvider);
        AppMethodBeat.o(191868);
    }

    public final void fEm() {
        AppMethodBeat.i(191869);
        com.tencent.mm.plugin.recordvideo.ui.editor.item.a aVar = this.GMF;
        if (aVar != null) {
            c(aVar);
            AppMethodBeat.o(191869);
            return;
        }
        AppMethodBeat.o(191869);
    }

    public final void aUo(String str) {
        AppMethodBeat.i(191870);
        p.h(str, "objectId");
        this.GMG.aUp(str);
        AppMethodBeat.o(191870);
    }

    public final Bitmap fT(String str, int i2) {
        Bitmap bitmap;
        AppMethodBeat.i(191871);
        p.h(str, "cacheId");
        ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> aUq = this.GMG.aUq(str);
        if (aUq.isEmpty()) {
            AppMethodBeat.o(191871);
            return null;
        }
        float[] eKr = eKr();
        eKs();
        this.GFO = new f(eKr, aUq, i2, (this.GMG.getHeight() * i2) / this.GMG.getWidth());
        f fVar = this.GFO;
        if (fVar != null) {
            fVar.start();
        }
        f fVar2 = this.GFO;
        if (fVar2 != null) {
            bitmap = fVar2.Im(1);
        } else {
            bitmap = null;
        }
        f fVar3 = this.GFO;
        if (fVar3 != null) {
            fVar3.destroy();
        }
        this.GFO = null;
        AppMethodBeat.o(191871);
        return bitmap;
    }

    private float[] eKr() {
        AppMethodBeat.i(191872);
        float[] fArr = {(float) this.GMG.getLeft(), (float) this.GMG.getTop(), (float) this.GMG.getRight(), (float) this.GMG.getBottom()};
        AppMethodBeat.o(191872);
        return fArr;
    }

    public static float[] eKs() {
        AppMethodBeat.i(191873);
        e eVar = e.BKp;
        e eVar2 = e.BKp;
        e eVar3 = e.BKp;
        e eVar4 = e.BKp;
        float[] fArr = {(float) e.eIS().left, (float) e.eIS().top, (float) e.eIS().right, (float) e.eIS().bottom};
        AppMethodBeat.o(191873);
        return fArr;
    }

    public final void r(Rect rect) {
        AppMethodBeat.i(191874);
        p.h(rect, "validRect");
        this.GMG.r(rect);
        AppMethodBeat.o(191874);
    }

    @Override // com.tencent.mm.plugin.vlog.ui.plugin.v.a
    public final void onVideoPlay() {
        AppMethodBeat.i(191875);
        this.GMG.fEn();
        AppMethodBeat.o(191875);
    }

    @Override // com.tencent.mm.plugin.vlog.ui.plugin.v.a
    public final void onVideoPause() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onResume() {
        AppMethodBeat.i(191876);
        TimeEditorItemContainer timeEditorItemContainer = this.GMG;
        ViewGroup itemLayout = timeEditorItemContainer.getItemLayout();
        p.g(itemLayout, "itemLayout");
        int childCount = itemLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = timeEditorItemContainer.getItemLayout().getChildAt(i2);
            if ((childAt instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.f) && !timeEditorItemContainer.Cfa) {
                ((com.tencent.mm.plugin.recordvideo.ui.editor.item.f) childAt).resume();
            }
        }
        AppMethodBeat.o(191876);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onPause() {
        AppMethodBeat.i(191877);
        TimeEditorItemContainer timeEditorItemContainer = this.GMG;
        ViewGroup itemLayout = timeEditorItemContainer.getItemLayout();
        p.g(itemLayout, "itemLayout");
        int childCount = itemLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = timeEditorItemContainer.getItemLayout().getChildAt(i2);
            if (childAt instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.f) {
                ((com.tencent.mm.plugin.recordvideo.ui.editor.item.f) childAt).pause();
            }
        }
        AppMethodBeat.o(191877);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void release() {
        AppMethodBeat.i(191878);
        this.GMG.getItemLayout().removeAllViews();
        AppMethodBeat.o(191878);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void reset() {
        AppMethodBeat.i(191879);
        this.GMG.getItemLayout().removeAllViews();
        AppMethodBeat.o(191879);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final boolean onBackPress() {
        return false;
    }

    public final void eKt() {
        AppMethodBeat.i(191880);
        this.GMG.setEnableTouch(true);
        AppMethodBeat.o(191880);
    }

    public final int eKu() {
        int i2;
        AppMethodBeat.i(191881);
        int i3 = 0;
        Iterator<T> it = this.GMG.getAllItemViews().iterator();
        while (it.hasNext()) {
            if (it.next() instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.f) {
                i2 = i3 + 1;
            } else {
                i2 = i3;
            }
            i3 = i2;
        }
        AppMethodBeat.o(191881);
        return i3;
    }

    public final int eKv() {
        int i2;
        AppMethodBeat.i(191882);
        int i3 = 0;
        Iterator<T> it = this.GMG.getAllItemViews().iterator();
        while (it.hasNext()) {
            if (it.next() instanceof r) {
                i2 = i3 + 1;
            } else {
                i2 = i3;
            }
            i3 = i2;
        }
        AppMethodBeat.o(191882);
        return i3;
    }

    public final void fEn() {
        AppMethodBeat.i(191883);
        this.GMG.fEn();
        this.GMF = null;
        AppMethodBeat.o(191883);
    }

    public final void setSegmentOffset(long j2) {
        AppMethodBeat.i(191884);
        this.GMG.setSegmentOffset(j2);
        AppMethodBeat.o(191884);
    }

    private static kotlin.o<Integer, Long> y(List<? extends com.tencent.mm.plugin.recordvideo.ui.editor.item.a> list, List<ad> list2) {
        AppMethodBeat.i(191885);
        List v = j.v((Collection) list2);
        List<? extends com.tencent.mm.plugin.recordvideo.ui.editor.item.a> list3 = list;
        ArrayList arrayList = new ArrayList(j.a(list3, 10));
        Iterator<T> it = list3.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().Cev);
        }
        long j2 = 0;
        long j3 = 0;
        for (com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d dVar : j.a((Iterable) arrayList, (Comparator) b.GMK)) {
            if (dVar.getStart() >= j2) {
                j3 += dVar.getEnd() - dVar.getStart();
            } else if (dVar.getEnd() > j2) {
                j3 += dVar.getEnd() - j2;
            }
            j2 = dVar.getEnd();
            j.c(v, (kotlin.g.a.b) new c(dVar));
        }
        kotlin.o<Integer, Long> oVar = new kotlin.o<>(Integer.valueOf(list2.size() - v.size()), Long.valueOf(j3));
        AppMethodBeat.o(191885);
        return oVar;
    }

    public final String u(List<ad> list, boolean z) {
        T t;
        T t2;
        AppMethodBeat.i(191886);
        p.h(list, "trackList");
        Iterator<T> it = list.iterator();
        if (!it.hasNext()) {
            t = null;
        } else {
            T next = it.next();
            if (!it.hasNext()) {
                t = next;
            } else {
                long j2 = next.GzA.endTimeMs;
                while (true) {
                    next = it.next();
                    long j3 = next.GzA.endTimeMs;
                    if (j2 < j3) {
                        j2 = j3;
                    } else {
                        next = next;
                    }
                    if (!it.hasNext()) {
                        break;
                    }
                }
                t = next;
            }
        }
        T t3 = t;
        long j4 = t3 != null ? t3.GzA.endTimeMs : Long.MAX_VALUE;
        ArrayList arrayList = new ArrayList();
        for (T t4 : this.GMG.getAllEditorData()) {
            if (!(t4 instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.q)) {
                t2 = null;
            } else {
                t2 = t4;
            }
            T t5 = t2;
            if (t5 != null) {
                t4.Cev.ai(t4.Cev.getStart(), Math.min(t4.Cev.getEnd(), j4));
            } else {
                t5 = null;
            }
            if (t5 != null) {
                arrayList.add(t5);
            }
        }
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.q> arrayList3 = arrayList2;
        ArrayList arrayList4 = new ArrayList(j.a(arrayList3, 10));
        for (com.tencent.mm.plugin.recordvideo.ui.editor.item.q qVar : arrayList3) {
            kotlin.o[] oVarArr = new kotlin.o[3];
            oVarArr[0] = s.U("font", com.tencent.mm.plugin.vlog.model.i.aTT(qVar.CeI));
            oVarArr[1] = s.U("durationMs", Long.valueOf(z ? 0 : qVar.Cev.getEnd() - qVar.Cev.getStart()));
            oVarArr[2] = s.U("isRead", Integer.valueOf(i.a.a(qVar) ? 1 : 0));
            arrayList4.add(ae.e(oVarArr));
        }
        Map f2 = ae.f(s.U("textCount", Integer.valueOf(size)), s.U("textStatus", arrayList4));
        if (z) {
            ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.q> arrayList5 = arrayList2;
            ArrayList arrayList6 = new ArrayList(j.a(arrayList5, 10));
            for (com.tencent.mm.plugin.recordvideo.ui.editor.item.q qVar2 : arrayList5) {
                arrayList6.add(qVar2.objectId);
            }
            f2.put("useTextTrackCount", Integer.valueOf(j.r((Iterable) arrayList6).size()));
            f2.put("totalDurationMs", 0);
        } else {
            kotlin.o<Integer, Long> y = y(arrayList2, list);
            f2.put("useTextTrackCount", y.first);
            f2.put("totalDurationMs", y.second);
        }
        String iVar = new com.tencent.mm.ab.i(f2).toString();
        p.g(iVar, "JSONObject(info).toString()");
        String j5 = kotlin.n.n.j(iVar, ",", ";", false);
        AppMethodBeat.o(191886);
        return j5;
    }

    public final String v(List<ad> list, boolean z) {
        T t;
        long end;
        T t2;
        AppMethodBeat.i(191887);
        p.h(list, "trackList");
        Iterator<T> it = list.iterator();
        if (!it.hasNext()) {
            t = null;
        } else {
            T next = it.next();
            if (!it.hasNext()) {
                t = next;
            } else {
                long j2 = next.GzA.endTimeMs;
                while (true) {
                    next = it.next();
                    long j3 = next.GzA.endTimeMs;
                    if (j2 < j3) {
                        j2 = j3;
                    } else {
                        next = next;
                    }
                    if (!it.hasNext()) {
                        break;
                    }
                }
                t = next;
            }
        }
        T t3 = t;
        long j4 = t3 != null ? t3.GzA.endTimeMs : Long.MAX_VALUE;
        ArrayList arrayList = new ArrayList();
        for (T t4 : this.GMG.getAllEditorData()) {
            if (!(t4 instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.e)) {
                t2 = null;
            } else {
                t2 = t4;
            }
            T t5 = t2;
            t4.Cev.ai(t4.Cev.getStart(), Math.min(t4.Cev.getEnd(), j4));
            if (t5 != null) {
                arrayList.add(t5);
            }
        }
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.e> arrayList3 = arrayList2;
        ArrayList arrayList4 = new ArrayList(j.a(arrayList3, 10));
        for (com.tencent.mm.plugin.recordvideo.ui.editor.item.e eVar : arrayList3) {
            if (z) {
                end = 0;
            } else {
                end = eVar.Cev.getEnd() - eVar.Cev.getStart();
            }
            arrayList4.add(Long.valueOf(end));
        }
        Map f2 = ae.f(s.U("emojiCount", Integer.valueOf(size)), s.U("emojiStatus", j.a(arrayList4, "|", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 62)));
        if (z) {
            ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.e> arrayList5 = arrayList2;
            ArrayList arrayList6 = new ArrayList(j.a(arrayList5, 10));
            for (com.tencent.mm.plugin.recordvideo.ui.editor.item.e eVar2 : arrayList5) {
                arrayList6.add(eVar2.objectId);
            }
            f2.put("useEmojiTrackCount", Integer.valueOf(j.r((Iterable) arrayList6).size()));
            f2.put("totalDurationMs", 0);
        } else {
            kotlin.o<Integer, Long> y = y(arrayList2, list);
            f2.put("useEmojiTrackCount", y.first);
            f2.put("totalDurationMs", y.second);
        }
        String iVar = new com.tencent.mm.ab.i(f2).toString();
        p.g(iVar, "JSONObject(info).toString()");
        String j5 = kotlin.n.n.j(iVar, ",", ";", false);
        AppMethodBeat.o(191887);
        return j5;
    }
}
