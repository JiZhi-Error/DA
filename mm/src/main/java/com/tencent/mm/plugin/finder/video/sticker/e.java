package com.tencent.mm.plugin.finder.video.sticker;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.video.sticker.f;
import com.tencent.mm.protocal.protobuf.chz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sticker.loader.h;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0006\u0018\u0000 12\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u000501234B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\bJ\b\u0010!\u001a\u00020\bH\u0016J\u0010\u0010\"\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J\u001c\u0010#\u001a\u00020\u000e2\n\u0010$\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000b\u001a\u00020\bH\u0016J\u001c\u0010%\u001a\u00060\u0002R\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\bH\u0016J\u0018\u0010)\u001a\u00020\u000e2\b\u0010*\u001a\u0004\u0018\u00010\u00052\u0006\u0010+\u001a\u00020\u001bJ\u000e\u0010,\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\bJ\u0010\u0010,\u001a\u00020\u000e2\b\u0010*\u001a\u0004\u0018\u00010\u0005J\u0014\u0010-\u001a\u00020\u000e2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\f0/R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000RL\u0010\u0006\u001a4\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R7\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\f0\u001ej\b\u0012\u0004\u0012\u00020\f`\u001fX\u0004¢\u0006\u0002\n\u0000¨\u00065"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$BaseViewHolder;", "()V", "TAG", "", "itemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "Lcom/tencent/mm/sticker/LensItem;", "info", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "onBindListener", "Lkotlin/Function1;", "getOnBindListener", "()Lkotlin/jvm/functions/Function1;", "setOnBindListener", "(Lkotlin/jvm/functions/Function1;)V", "selectedId", "selectedLoading", "", "selectedPosition", "stickerList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getItem", "getItemCount", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setLoading", "lensId", "isLoading", "setSelection", "update", "lensList", "", "BaseViewHolder", "Companion", "DiffCallbackToAdapter", "EmptyStickerViewHolder", "StickerViewHolder", "plugin-finder_release"})
public final class e extends RecyclerView.a<a> {
    public static final b wiS = new b((byte) 0);
    final String TAG = "MicroMsg.StickerEffectAdapter";
    String rpt;
    final ArrayList<com.tencent.mm.sticker.c> rsC = new ArrayList<>();
    m<? super Integer, ? super com.tencent.mm.sticker.c, x> rsD;
    kotlin.g.a.b<? super Integer, x> rsE;
    int va;
    boolean wiR;

    static {
        AppMethodBeat.i(254580);
        AppMethodBeat.o(254580);
    }

    public e() {
        AppMethodBeat.i(254579);
        AppMethodBeat.o(254579);
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ a a(ViewGroup viewGroup, int i2) {
        d dVar;
        AppMethodBeat.i(254576);
        p.h(viewGroup, "parent");
        switch (i2) {
            case 1:
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.a_f, viewGroup, false);
                p.g(inflate, "LayoutInflater.from(pare…tem_empty, parent, false)");
                dVar = new d(this, inflate);
                break;
            default:
                View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.a_e, viewGroup, false);
                p.g(inflate2, "LayoutInflater.from(pare…cker_item, parent, false)");
                dVar = new C1324e(this, inflate2);
                break;
        }
        RecyclerView.v vVar = dVar;
        AppMethodBeat.o(254576);
        return vVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(a aVar, int i2) {
        AppMethodBeat.i(254578);
        a aVar2 = aVar;
        p.h(aVar2, "holder");
        com.tencent.mm.sticker.c Gs = Gs(i2);
        if (Gs == null) {
            p.hyc();
        }
        aVar2.b(i2, Gs.NMJ);
        kotlin.g.a.b<? super Integer, x> bVar = this.rsE;
        if (bVar != null) {
            bVar.invoke(Integer.valueOf(i2));
            AppMethodBeat.o(254578);
            return;
        }
        AppMethodBeat.o(254578);
    }

    public final void bx(String str, boolean z) {
        AppMethodBeat.i(254573);
        if (p.j(this.rpt, str) && this.wiR != z) {
            this.wiR = z;
            ci(this.va);
        }
        AppMethodBeat.o(254573);
    }

    public final com.tencent.mm.sticker.c Gs(int i2) {
        AppMethodBeat.i(254574);
        com.tencent.mm.sticker.c cVar = (com.tencent.mm.sticker.c) j.L(this.rsC, i2);
        AppMethodBeat.o(254574);
        return cVar;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemViewType(int i2) {
        AppMethodBeat.i(254575);
        com.tencent.mm.sticker.c Gs = Gs(i2);
        f.a aVar = f.wja;
        if (p.j(Gs, f.dGg())) {
            AppMethodBeat.o(254575);
            return 1;
        }
        AppMethodBeat.o(254575);
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(254577);
        int size = this.rsC.size();
        AppMethodBeat.o(254577);
        return size;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$Companion;", "", "()V", "ViewTypeEmpty", "", "ViewTypeNormal", "plugin-finder_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b¦\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$BaseViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;Landroid/view/View;)V", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-finder_release"})
    public abstract class a extends RecyclerView.v {
        final /* synthetic */ e wiT;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(e eVar, View view) {
            super(view);
            p.h(view, "itemView");
            this.wiT = eVar;
            view.setOnClickListener(new View.OnClickListener(this) {
                /* class com.tencent.mm.plugin.finder.video.sticker.e.a.AnonymousClass1 */
                final /* synthetic */ a wiU;

                {
                    this.wiU = r1;
                }

                public final void onClick(View view) {
                    m<? super Integer, ? super com.tencent.mm.sticker.c, x> mVar;
                    AppMethodBeat.i(254563);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$BaseViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    int lR = this.wiU.lR();
                    com.tencent.mm.sticker.c Gs = this.wiU.wiT.Gs(lR);
                    if (!(Gs == null || (mVar = this.wiU.wiT.rsD) == null)) {
                        mVar.invoke(Integer.valueOf(lR), Gs);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$BaseViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(254563);
                }
            });
        }

        public void b(int i2, chz chz) {
            p.h(chz, "info");
            View view = this.aus;
            p.g(view, "itemView");
            view.setSelected(i2 == this.wiT.va);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0019\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$EmptyStickerViewHolder;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;Landroid/view/View;)V", "icon", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getIcon", "()Landroid/widget/ImageView;", "plugin-finder_release"})
    public final class d extends a {
        private final ImageView kc;
        final /* synthetic */ e wiT;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(e eVar, View view) {
            super(eVar, view);
            p.h(view, "itemView");
            this.wiT = eVar;
            AppMethodBeat.i(254570);
            this.kc = (ImageView) view.findViewById(R.id.cl7);
            AppMethodBeat.o(254570);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u0019\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u000b\u001a\n \b*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000e\u001a\n \b*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$StickerViewHolder;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;Landroid/view/View;)V", "icon", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getIcon", "()Landroid/widget/ImageView;", "loading", "getLoading", "()Landroid/view/View;", "loadingBg", "getLoadingBg", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.video.sticker.e$e  reason: collision with other inner class name */
    public final class C1324e extends a {
        private final ImageView kc;
        private final View rtV;
        final /* synthetic */ e wiT;
        private final View wiW;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1324e(e eVar, View view) {
            super(eVar, view);
            p.h(view, "itemView");
            this.wiT = eVar;
            AppMethodBeat.i(254572);
            this.kc = (ImageView) view.findViewById(R.id.cl7);
            this.rtV = view.findViewById(R.id.cl8);
            this.wiW = view.findViewById(R.id.cl9);
            AppMethodBeat.o(254572);
        }

        @Override // com.tencent.mm.plugin.finder.video.sticker.e.a
        public final void b(int i2, chz chz) {
            AppMethodBeat.i(254571);
            p.h(chz, "info");
            super.b(i2, chz);
            h hVar = h.NNV;
            com.tencent.mm.loader.a.b<com.tencent.mm.sticker.loader.a, Bitmap> bQ = h.getLoader().bQ(new com.tencent.mm.sticker.loader.a(chz));
            ImageView imageView = this.kc;
            p.g(imageView, "icon");
            bQ.c(imageView);
            if (i2 != this.wiT.va || !this.wiT.wiR) {
                View view = this.rtV;
                p.g(view, "loading");
                view.setVisibility(8);
                View view2 = this.wiW;
                p.g(view2, "loadingBg");
                view2.setVisibility(8);
                AppMethodBeat.o(254571);
                return;
            }
            View view3 = this.rtV;
            p.g(view3, "loading");
            view3.setVisibility(0);
            View view4 = this.wiW;
            p.g(view4, "loadingBg");
            view4.setVisibility(0);
            AppMethodBeat.o(254571);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0016\u0010\u0011\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter$DiffCallbackToAdapter;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerDiffCallback;", "adapter", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;", "(Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;)V", "getAdapter", "()Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;", "onInsert", "", "start", "", "count", "onMove", "fromPos", "toPos", "onRemove", "onUpdate", "updateData", "lensList", "", "Lcom/tencent/mm/sticker/LensItem;", "plugin-finder_release"})
    public static final class c implements d {
        private final e wiV;

        public c(e eVar) {
            p.h(eVar, "adapter");
            AppMethodBeat.i(254569);
            this.wiV = eVar;
            AppMethodBeat.o(254569);
        }

        @Override // com.tencent.mm.plugin.finder.video.sticker.d
        public final void ad(List<com.tencent.mm.sticker.c> list) {
            AppMethodBeat.i(254564);
            p.h(list, "lensList");
            e eVar = this.wiV;
            p.h(list, "lensList");
            Log.i(eVar.TAG, "update: " + list.size());
            eVar.rsC.clear();
            eVar.rsC.addAll(list);
            AppMethodBeat.o(254564);
        }

        @Override // com.tencent.mm.plugin.finder.video.sticker.d
        public final void fH(int i2, int i3) {
            AppMethodBeat.i(254565);
            this.wiV.as(i2, i3);
            AppMethodBeat.o(254565);
        }

        @Override // com.tencent.mm.plugin.finder.video.sticker.d
        public final void fI(int i2, int i3) {
            AppMethodBeat.i(254566);
            this.wiV.at(i2, i3);
            AppMethodBeat.o(254566);
        }

        @Override // com.tencent.mm.plugin.finder.video.sticker.d
        public final void fJ(int i2, int i3) {
            AppMethodBeat.i(254567);
            this.wiV.ar(i2, i3);
            AppMethodBeat.o(254567);
        }

        @Override // com.tencent.mm.plugin.finder.video.sticker.d
        public final void fK(int i2, int i3) {
            AppMethodBeat.i(254568);
            this.wiV.aq(i2, i3);
            AppMethodBeat.o(254568);
        }
    }
}
