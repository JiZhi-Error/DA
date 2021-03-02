package com.tencent.mm.plugin.finder.video.sticker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorPanelHolder;
import com.tencent.mm.protocal.protobuf.chz;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sticker.f;
import com.tencent.mm.sticker.loader.e;
import com.tencent.mm.sticker.ui.view.CaptureStickerHint;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u0006\u0010&\u001a\u00020'J\b\u0010(\u001a\u00020'H\u0016J\u0010\u0010)\u001a\u00020'2\u0006\u0010*\u001a\u00020+H\u0002J\b\u0010,\u001a\u00020'H\u0002R\u000e\u0010\n\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "layout", "Landroid/view/View;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "bottomSpace", "Lkotlin/Function0;", "", "(Landroid/view/View;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;Lkotlin/jvm/functions/Function0;)V", "TAG", "", "getBottomSpace", "()Lkotlin/jvm/functions/Function0;", "historyCallback", "Lcom/tencent/mm/plugin/finder/video/sticker/DiffCallbackHolder;", "holder", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "iconView", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getLayout", "()Landroid/view/View;", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "moreCallbackHolder", "selectedLensInfo", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "stickerData", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerData;", "stickerHint", "Lcom/tencent/mm/sticker/ui/view/CaptureStickerHint;", "stickerView", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectView;", "tipsView", "Landroid/widget/ImageView;", "recordHistory", "", "release", "setOpen", "isOpen", "", "showMore", "plugin-finder_release"})
public final class g implements t {
    final String TAG = "MicroMsg.StickerEffectPlugin";
    private final View sc;
    private final com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> ttK;
    final d wgr;
    final WeImageView wjf;
    final ImageView wjg;
    final CaptureStickerHint wjh;
    final EditorPanelHolder wji;
    public chz wjj;
    StickerEffectView wjk;
    final b wjl;
    final a wjm;
    final a wjn;
    final kotlin.g.a.a<Integer> wjo;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    static final class a extends q implements kotlin.g.a.b<Boolean, x> {
        final /* synthetic */ g wjp;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(g gVar) {
            super(1);
            this.wjp = gVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            AppMethodBeat.i(254595);
            if (!bool.booleanValue()) {
                this.wjp.oT(false);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(254595);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "invoke"})
    static final class b extends q implements kotlin.g.a.b<chz, x> {
        final /* synthetic */ g wjp;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(g gVar) {
            super(1);
            this.wjp = gVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(chz chz) {
            AppMethodBeat.i(254597);
            chz chz2 = chz;
            this.wjp.wjj = chz2;
            final String str = chz2 != null ? chz2.Lso : null;
            Log.i(this.wjp.TAG, "select: ".concat(String.valueOf(str)));
            if (str != null) {
                this.wjp.wjg.setVisibility(0);
                com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                    /* class com.tencent.mm.plugin.finder.video.sticker.g.b.AnonymousClass1 */
                    final /* synthetic */ b wjq;

                    {
                        this.wjq = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        AppMethodBeat.i(254596);
                        CaptureStickerHint captureStickerHint = this.wjq.wjp.wjh;
                        f.a aVar = f.NNw;
                        e eVar = e.NNN;
                        captureStickerHint.setStickerPack(f.a.bit(e.biw(str)));
                        x xVar = x.SXb;
                        AppMethodBeat.o(254596);
                        return xVar;
                    }
                });
            } else {
                this.wjp.wjg.setVisibility(8);
            }
            Bundle bundle = new Bundle();
            bundle.putString("PARAM_STICKER_LENS_ID", str);
            this.wjp.wgr.a(d.c.BUK, bundle);
            x xVar = x.SXb;
            AppMethodBeat.o(254597);
            return xVar;
        }
    }

    public g(View view, d dVar, kotlin.g.a.a<Integer> aVar) {
        p.h(view, "layout");
        p.h(dVar, "status");
        p.h(aVar, "bottomSpace");
        AppMethodBeat.i(254601);
        this.sc = view;
        this.wgr = dVar;
        this.wjo = aVar;
        View findViewById = this.sc.findViewById(R.id.i5z);
        p.g(findViewById, "layout.findViewById(R.id.sticker_effect)");
        this.wjf = (WeImageView) findViewById;
        View findViewById2 = this.sc.findViewById(R.id.i60);
        p.g(findViewById2, "layout.findViewById(R.id.sticker_effect_check)");
        this.wjg = (ImageView) findViewById2;
        View findViewById3 = this.sc.findViewById(R.id.ckn);
        p.g(findViewById3, "layout.findViewById(R.id…der_capture_sticker_hint)");
        this.wjh = (CaptureStickerHint) findViewById3;
        Context context = this.sc.getContext();
        p.g(context, "layout.context");
        this.wji = new EditorPanelHolder(context);
        this.ttK = new com.tencent.mm.vending.e.c<>();
        this.wjm = new a();
        this.wjn = new a();
        this.wjf.setIconColor(-1);
        this.wjg.setImageDrawable(com.tencent.mm.cb.a.l(this.sc.getContext(), R.raw.popvideo_post_selected_origin));
        this.wjl = new b(this.ttK, new f(this.wjm, this.wjn));
        this.wjf.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.video.sticker.g.AnonymousClass1 */
            final /* synthetic */ g wjp;

            {
                this.wjp = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(254594);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/sticker/StickerEffectPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                g gVar = this.wjp;
                if (gVar.wjk == null) {
                    gVar.wjl.cJk();
                    Context context = gVar.wjf.getContext();
                    p.g(context, "iconView.context");
                    gVar.wjk = new StickerEffectView(context);
                    ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, gVar.wjo.invoke().intValue() - com.tencent.mm.cb.a.fromDPToPix(gVar.wjf.getContext(), 8));
                    EditorPanelHolder editorPanelHolder = gVar.wji;
                    StickerEffectView stickerEffectView = gVar.wjk;
                    if (stickerEffectView == null) {
                        p.hyc();
                    }
                    editorPanelHolder.a(stickerEffectView, marginLayoutParams);
                    gVar.wji.setOnVisibleChangeCallback(new a(gVar));
                    StickerEffectView stickerEffectView2 = gVar.wjk;
                    if (stickerEffectView2 != null) {
                        stickerEffectView2.setMoreDiffCallback(gVar.wjn);
                    }
                    StickerEffectView stickerEffectView3 = gVar.wjk;
                    if (stickerEffectView3 != null) {
                        stickerEffectView3.setHistoryDiffCallback(gVar.wjm);
                    }
                    StickerEffectView stickerEffectView4 = gVar.wjk;
                    if (stickerEffectView4 != null) {
                        stickerEffectView4.setSelectionCallback(new b(gVar));
                    }
                    StickerEffectView stickerEffectView5 = gVar.wjk;
                    if (stickerEffectView5 != null) {
                        stickerEffectView5.setLoadMoreCallback(new c(gVar));
                    }
                }
                gVar.wji.setShow(true);
                gVar.oT(true);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/sticker/StickerEffectPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(254594);
            }
        });
        AppMethodBeat.o(254601);
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
    public final boolean onBackPress() {
        return false;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onDetach() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onPause() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(254602);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        AppMethodBeat.o(254602);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onResume() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void reset() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void setVisibility(int i2) {
    }

    /* access modifiers changed from: package-private */
    public final void oT(boolean z) {
        AppMethodBeat.i(254599);
        Bundle bundle = new Bundle();
        bundle.putBoolean("PARAM_STICKER_PANEL_OPEN", z);
        this.wgr.a(d.c.BUJ, bundle);
        AppMethodBeat.o(254599);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void release() {
        AppMethodBeat.i(254600);
        this.ttK.dead();
        StickerEffectView stickerEffectView = this.wjk;
        if (stickerEffectView != null) {
            e eVar = e.NNN;
            e.b(stickerEffectView.wjt);
            AppMethodBeat.o(254600);
            return;
        }
        AppMethodBeat.o(254600);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ g wjp;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(g gVar) {
            super(0);
            this.wjp = gVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(254598);
            this.wjp.wjl.cJk();
            x xVar = x.SXb;
            AppMethodBeat.o(254598);
            return xVar;
        }
    }
}
