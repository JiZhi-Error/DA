package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorPanelHolder;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.v;
import com.tencent.mm.plugin.vlog.model.w;
import com.tencent.mm.plugin.vlog.ui.plugin.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ar;
import com.tencent.mm.xeffect.effect.EffectManager;
import com.tencent.mm.xeffect.effect.ad;
import com.tencent.mm.xeffect.effect.j;
import com.tencent.mm.xeffect.effect.r;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0006\u00105\u001a\u000206J\u0010\u00107\u001a\u0002062\u0006\u00108\u001a\u00020\u000fH\u0002J\u0016\u00109\u001a\u0002062\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020;J\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u000f0>J\b\u0010?\u001a\u00020\u0014H\u0016J\u0012\u0010@\u001a\u0002062\b\u0010A\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010B\u001a\u0002062\u0006\u0010C\u001a\u00020DH\u0016R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \u0012*\u0004\u0018\u00010\u00110\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\n \u0012*\u0004\u0018\u00010\u001c0\u001cX\u0004¢\u0006\u0002\n\u0000R#\u0010\u001d\u001a\n \u0012*\u0004\u0018\u00010\u001e0\u001e8BX\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R#\u0010)\u001a\n \u0012*\u0004\u0018\u00010*0*8BX\u0002¢\u0006\f\n\u0004\b-\u0010\"\u001a\u0004\b+\u0010,R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u000e\u00102\u001a\u000203X\u0004¢\u0006\u0002\n\u0000R\u0016\u00104\u001a\n \u0012*\u0004\u0018\u00010\u001c0\u001cX\u0004¢\u0006\u0002\n\u0000¨\u0006E"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiEditMagicPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Landroid/view/View$OnClickListener;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "model", "Lcom/tencent/mm/plugin/vlog/model/MultiMediaModel;", "previewPlugin", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;Lcom/tencent/mm/plugin/vlog/model/MultiMediaModel;Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin;)V", "adapter", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicPanelAdapter;", "editingItem", "Lcom/tencent/mm/plugin/vlog/model/effect/MagicAddEffectItem;", "iconView", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "isInit", "", "layoutManager", "Landroid/support/v7/widget/GridLayoutManager;", "magicData", "Lcom/tencent/mm/plugin/vlog/model/effect/MagicListData;", "getModel", "()Lcom/tencent/mm/plugin/vlog/model/MultiMediaModel;", "panelHolder", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "panelRoot", "Landroid/view/View;", "getPanelRoot", "()Landroid/view/View;", "panelRoot$delegate", "Lkotlin/Lazy;", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "getPreviewPlugin", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin;", "recycler", "Landroid/support/v7/widget/RecyclerView;", "getRecycler", "()Landroid/support/v7/widget/RecyclerView;", "recycler$delegate", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "timeEdit", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin;", "timePanelHolder", "deleteEditItem", "", "editItemTime", "item", "finishEditItem", "start", "", "end", "getAddMagicItem", "", "onBackPress", "onClick", "v", "setVisibility", "visibility", "", "plugin-vlog_release"})
public final class o implements View.OnClickListener, t {
    private final f GGj = g.ah(new d(this));
    final i GHA = new i();
    public final com.tencent.mm.plugin.vlog.model.effect.c GHB;
    com.tencent.mm.plugin.vlog.model.effect.b GHC;
    private final k GHD;
    final v GHE;
    final e GHF;
    final EditorPanelHolder GHx = ((EditorPanelHolder) this.parent.findViewById(R.id.bxe));
    private final EditorPanelHolder GHy = ((EditorPanelHolder) this.parent.findViewById(R.id.bxf));
    private final f GHz = g.ah(new e(this));
    private final GridLayoutManager haU;
    private boolean isInit;
    ViewGroup parent;
    private final ImageView vs = ((ImageView) this.parent.findViewById(R.id.bws));
    com.tencent.mm.plugin.recordvideo.plugin.parent.d wgr;

    private final View fDm() {
        AppMethodBeat.i(191331);
        View view = (View) this.GGj.getValue();
        AppMethodBeat.o(191331);
        return view;
    }

    private final RecyclerView fDp() {
        AppMethodBeat.i(191332);
        RecyclerView recyclerView = (RecyclerView) this.GHz.getValue();
        AppMethodBeat.o(191332);
        return recyclerView;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "position", "", "item", "Lcom/tencent/mm/plugin/vlog/model/effect/MagicListItem;", "invoke"})
    static final class c extends q implements m<Integer, com.tencent.mm.plugin.vlog.model.effect.e, x> {
        final /* synthetic */ o GHG;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(o oVar) {
            super(2);
            this.GHG = oVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Integer num, com.tencent.mm.plugin.vlog.model.effect.e eVar) {
            ad adVar;
            ad adVar2;
            long j2;
            AppMethodBeat.i(191328);
            num.intValue();
            com.tencent.mm.plugin.vlog.model.effect.e eVar2 = eVar;
            p.h(eVar2, "item");
            if (eVar2 instanceof com.tencent.mm.plugin.vlog.model.effect.d) {
                com.tencent.mm.plugin.vlog.model.local.a aVar = com.tencent.mm.plugin.vlog.model.local.a.GAD;
                EffectManager fBP = com.tencent.mm.plugin.vlog.model.local.a.fBP();
                if (fBP != null) {
                    j jVar = j.PAGGlobalAnimateEffect;
                    Context context = this.GHG.parent.getContext();
                    p.g(context, "parent.context");
                    AssetManager assets = context.getAssets();
                    p.g(assets, "parent.context.assets");
                    adVar = fBP.a(jVar, assets, ((com.tencent.mm.plugin.vlog.model.effect.d) eVar2).GAm.Cga);
                } else {
                    adVar = null;
                }
                com.tencent.mm.plugin.vlog.model.local.a aVar2 = com.tencent.mm.plugin.vlog.model.local.a.GAD;
                EffectManager fBP2 = com.tencent.mm.plugin.vlog.model.local.a.fBP();
                if (fBP2 != null) {
                    fBP2.a(adVar);
                }
                if (!(adVar instanceof r)) {
                    adVar2 = null;
                } else {
                    adVar2 = adVar;
                }
                r rVar = (r) adVar2;
                if (rVar != null) {
                    j2 = rVar.RyW;
                } else {
                    j2 = 0;
                }
                long position = this.GHG.GHF.fCU().getPosition();
                long j3 = position + j2;
                if (position + j2 > this.GHG.GHE.GxA.Gez.fBz()) {
                    j3 = this.GHG.GHE.GxA.Gez.fBz();
                    position = Math.max(j3 - j2, 0L);
                }
                if (adVar != null) {
                    adVar.aH(position, j3);
                }
                com.tencent.mm.plugin.vlog.model.effect.b bVar = new com.tencent.mm.plugin.vlog.model.effect.b(((com.tencent.mm.plugin.vlog.model.effect.d) eVar2).GAm, adVar, position, j3, (byte) 0);
                Log.i(p.auD(), "add magic: " + adVar + ", " + (adVar != null ? Long.valueOf(adVar.id) : null) + ", " + position + ", " + j3 + ", " + j2);
                com.tencent.mm.plugin.vlog.model.effect.c cVar = this.GHG.GHB;
                p.h(bVar, "item");
                cVar.GAo.add(0, bVar);
                bVar.order = cVar.GAo.size();
                this.GHG.GHA.ad(this.GHG.GHB.avn());
                o.a(this.GHG, bVar);
                this.GHG.GHx.setShow(false);
            } else if (eVar2 instanceof com.tencent.mm.plugin.vlog.model.effect.b) {
                o.a(this.GHG, (com.tencent.mm.plugin.vlog.model.effect.b) eVar2);
                this.GHG.GHx.setShow(false);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(191328);
            return xVar;
        }
    }

    public o(ViewGroup viewGroup, com.tencent.mm.plugin.recordvideo.plugin.parent.d dVar, v vVar, e eVar) {
        p.h(viewGroup, "parent");
        p.h(dVar, "status");
        p.h(vVar, "model");
        p.h(eVar, "previewPlugin");
        AppMethodBeat.i(191336);
        this.parent = viewGroup;
        this.wgr = dVar;
        this.GHE = vVar;
        this.GHF = eVar;
        this.parent.getContext();
        this.haU = new GridLayoutManager(5);
        this.GHB = new com.tencent.mm.plugin.vlog.model.effect.c();
        EditorPanelHolder editorPanelHolder = this.GHy;
        p.g(editorPanelHolder, "timePanelHolder");
        this.GHD = new k(editorPanelHolder, this.wgr);
        this.vs.setImageDrawable(ar.m(this.parent.getContext(), R.raw.icons_filled_magic, com.tencent.mm.cb.a.n(this.parent.getContext(), R.color.act)));
        this.vs.setOnClickListener(this);
        this.GHF.a(this.GHD);
        this.GHx.setOnVisibleChangeCallback(new kotlin.g.a.b<Boolean, x>(this) {
            /* class com.tencent.mm.plugin.vlog.ui.plugin.o.AnonymousClass1 */
            final /* synthetic */ o GHG;

            {
                this.GHG = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Boolean bool) {
                AppMethodBeat.i(191322);
                if (bool.booleanValue()) {
                    d.b.a(this.GHG.wgr, d.c.BWJ);
                } else if (!this.GHG.GHy.bJw()) {
                    d.b.a(this.GHG.wgr, d.c.BVj);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(191322);
                return xVar;
            }
        });
        AppMethodBeat.o(191336);
    }

    public static final /* synthetic */ View e(o oVar) {
        AppMethodBeat.i(191339);
        View fDm = oVar.fDm();
        AppMethodBeat.o(191339);
        return fDm;
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
        AppMethodBeat.i(191337);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        AppMethodBeat.o(191337);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onResume() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void release() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void reset() {
    }

    public final void onClick(View view) {
        AppMethodBeat.i(191333);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/MultiEditMagicPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (this.GHx.bJw()) {
            this.GHx.setShow(false);
        } else {
            if (!this.isInit) {
                this.isInit = true;
                EditorPanelHolder editorPanelHolder = this.GHx;
                View fDm = fDm();
                p.g(fDm, "panelRoot");
                EditorPanelHolder.a(editorPanelHolder, fDm);
                this.GHx.setCloseTouchOutside(true);
                RecyclerView fDp = fDp();
                p.g(fDp, "recycler");
                fDp.setAdapter(this.GHA);
                RecyclerView fDp2 = fDp();
                p.g(fDp2, "recycler");
                fDp2.setLayoutManager(this.haU);
                this.haU.a(new b(this));
                this.GHA.uAj = new c(this);
            }
            this.GHA.ad(this.GHB.avn());
            this.GHx.setShow(true);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/MultiEditMagicPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(191333);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, hxF = {"com/tencent/mm/plugin/vlog/ui/plugin/MultiEditMagicPlugin$onClick$1", "Landroid/support/v7/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSize", "", "position", "plugin-vlog_release"})
    public static final class b extends GridLayoutManager.b {
        final /* synthetic */ o GHG;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(o oVar) {
            this.GHG = oVar;
        }

        @Override // android.support.v7.widget.GridLayoutManager.b
        public final int bX(int i2) {
            AppMethodBeat.i(191327);
            switch (this.GHG.GHA.getItemViewType(i2)) {
                case 1:
                    AppMethodBeat.o(191327);
                    return 5;
                default:
                    AppMethodBeat.o(191327);
                    return 1;
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/vlog/ui/plugin/MultiEditMagicPlugin$editItemTime$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$EditCallback;", "onCrop", "", "start", "", "end", "onCropStart", "onDelete", "onFinish", "plugin-vlog_release"})
    public static final class a implements k.b {
        final /* synthetic */ o GHG;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(o oVar) {
            this.GHG = oVar;
        }

        @Override // com.tencent.mm.plugin.vlog.ui.plugin.k.b
        public final void fDo() {
            AppMethodBeat.i(191323);
            com.tencent.mm.plugin.vlog.model.effect.b bVar = this.GHG.GHC;
            if (bVar != null) {
                ad adVar = bVar.GAn;
                if (adVar != null) {
                    adVar.aH(0, 0);
                    AppMethodBeat.o(191323);
                    return;
                }
                AppMethodBeat.o(191323);
                return;
            }
            AppMethodBeat.o(191323);
        }

        @Override // com.tencent.mm.plugin.vlog.ui.plugin.k.b
        public final void ay(long j2, long j3) {
            AppMethodBeat.i(191324);
            com.tencent.mm.plugin.vlog.model.effect.b bVar = this.GHG.GHC;
            if (bVar != null) {
                bVar.start = j2;
                bVar.boX = j3;
                ad adVar = bVar.GAn;
                if (adVar != null) {
                    adVar.aH(bVar.start, bVar.boX);
                    AppMethodBeat.o(191324);
                    return;
                }
                AppMethodBeat.o(191324);
                return;
            }
            AppMethodBeat.o(191324);
        }

        @Override // com.tencent.mm.plugin.vlog.ui.plugin.k.b
        public final void onFinish() {
            AppMethodBeat.i(191325);
            this.GHG.GHF.at(this.GHG.GHE.GxA.Gez.getPlayStart(), this.GHG.GHE.GxA.Gez.fBz());
            d.b.a(this.GHG.wgr, d.c.BVj);
            AppMethodBeat.o(191325);
        }

        @Override // com.tencent.mm.plugin.vlog.ui.plugin.k.b
        public final void eMs() {
            long j2;
            AppMethodBeat.i(191326);
            o oVar = this.GHG;
            com.tencent.mm.plugin.vlog.model.effect.b bVar = oVar.GHC;
            if (bVar != null) {
                com.tencent.mm.plugin.vlog.model.local.a aVar = com.tencent.mm.plugin.vlog.model.local.a.GAD;
                EffectManager fBP = com.tencent.mm.plugin.vlog.model.local.a.fBP();
                if (fBP == null) {
                    p.hyc();
                }
                ad adVar = bVar.GAn;
                if (adVar != null) {
                    j2 = adVar.id;
                } else {
                    j2 = 0;
                }
                fBP.Ot(j2);
                oVar.GHF.at(oVar.GHE.GxA.Gez.getPlayStart(), oVar.GHE.GxA.Gez.fBz());
                com.tencent.mm.plugin.vlog.model.effect.c cVar = oVar.GHB;
                p.h(bVar, "item");
                cVar.GAo.remove(bVar);
                int size = cVar.GAo.size();
                int i2 = 0;
                for (T t : cVar.GAo) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        kotlin.a.j.hxH();
                    }
                    t.order = size - i2;
                    i2 = i3;
                }
                oVar.GHA.ad(oVar.GHB.avn());
                oVar.GHx.setShow(true);
            }
            oVar.GHC = null;
            AppMethodBeat.o(191326);
        }
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void setVisibility(int i2) {
        AppMethodBeat.i(191334);
        if (w.fBr()) {
            ImageView imageView = this.vs;
            p.g(imageView, "iconView");
            imageView.setVisibility(i2);
            AppMethodBeat.o(191334);
            return;
        }
        ImageView imageView2 = this.vs;
        p.g(imageView2, "iconView");
        imageView2.setVisibility(8);
        AppMethodBeat.o(191334);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final boolean onBackPress() {
        AppMethodBeat.i(191335);
        if (this.GHx.bJw()) {
            this.GHx.setShow(false);
            AppMethodBeat.o(191335);
            return true;
        } else if (this.GHy.bJw()) {
            this.GHD.cancel();
            this.GHy.setShow(false);
            AppMethodBeat.o(191335);
            return true;
        } else {
            AppMethodBeat.o(191335);
            return false;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class d extends q implements kotlin.g.a.a<View> {
        final /* synthetic */ o GHG;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(o oVar) {
            super(0);
            this.GHG = oVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(191329);
            View inflate = LayoutInflater.from(this.GHG.parent.getContext()).inflate(R.layout.a13, (ViewGroup) this.GHG.GHx, false);
            AppMethodBeat.o(191329);
            return inflate;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class e extends q implements kotlin.g.a.a<RecyclerView> {
        final /* synthetic */ o GHG;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(o oVar) {
            super(0);
            this.GHG = oVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ RecyclerView invoke() {
            AppMethodBeat.i(191330);
            RecyclerView recyclerView = (RecyclerView) o.e(this.GHG).findViewById(R.id.bwt);
            AppMethodBeat.o(191330);
            return recyclerView;
        }
    }

    public static final /* synthetic */ void a(o oVar, com.tencent.mm.plugin.vlog.model.effect.b bVar) {
        AppMethodBeat.i(191338);
        oVar.GHC = bVar;
        oVar.GHF.at(bVar.start, bVar.boX);
        k kVar = oVar.GHD;
        long j2 = bVar.start;
        long j3 = bVar.boX;
        kVar.GHo = j2;
        kVar.GHp = j3;
        kVar.GHq = kVar.GHo;
        kVar.GHr = kVar.GHp;
        k kVar2 = oVar.GHD;
        ac acVar = oVar.GHE.GxA;
        p.h(acVar, "composition");
        kVar2.GGs = false;
        if (!kVar2.gKM) {
            kVar2.gKM = true;
            kVar2.wji.setCloseTouchOutside(false);
            kVar2.fDn().setCallback(kVar2.GHt);
            kVar2.fDn().setRealTimeCallback(kVar2.GHt);
            kVar2.wji.setOnVisibleChangeCallback(new k.d(kVar2));
            ((View) kVar2.vJB.getValue()).setOnClickListener(new k.e(kVar2));
            ((View) kVar2.GHn.getValue()).setOnClickListener(new k.f(kVar2));
            kVar2.fDm().findViewById(R.id.f5n).setOnClickListener(new k.g(kVar2));
            kVar2.fDm().findViewById(R.id.f5o).setOnClickListener(new k.h(kVar2));
        }
        if (kVar2.GHp > acVar.Gez.hfo().getEndUs() / 1000) {
            kVar2.GHp = acVar.Gez.hfo().getEndUs() / 1000;
            kVar2.GHr = kVar2.GHp;
        }
        kVar2.fDn().a(acVar, kVar2.GHo, kVar2.GHp);
        kVar2.wji.setShow(true);
        oVar.GHD.GHs = new a(oVar);
        AppMethodBeat.o(191338);
    }
}
