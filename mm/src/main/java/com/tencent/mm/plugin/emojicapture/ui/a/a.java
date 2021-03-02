package com.tencent.mm.plugin.emojicapture.ui.a;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.contact.f;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMultiMedia;
import com.tencent.mm.plugin.emojicapture.model.a.f;
import com.tencent.mm.plugin.emojicapture.ui.capture.StickerSelectFrame;
import com.tencent.mm.protocal.protobuf.chz;
import com.tencent.mm.sticker.loader.h;
import com.tencent.tavkit.component.TAVPlayer;
import java.util.ArrayList;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\u0018\u0000 )2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0005()*+,B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\u0006J\b\u0010\u001c\u001a\u00020\u0006H\u0016J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u001c\u0010\u001e\u001a\u00020\f2\n\u0010\u001f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u001c\u0010 \u001a\u00060\u0002R\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0006H\u0016J\u000e\u0010$\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0006J\u0014\u0010%\u001a\u00020\f2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\n0'RL\u0010\u0004\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R7\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\f\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0019j\b\u0012\u0004\u0012\u00020\n`\u001aX\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter$BaseViewHolder;", "()V", "itemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "Lcom/tencent/mm/sticker/LensItem;", "info", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "onBindListener", "Lkotlin/Function1;", "getOnBindListener", "()Lkotlin/jvm/functions/Function1;", "setOnBindListener", "(Lkotlin/jvm/functions/Function1;)V", "selectedPosition", "stickerList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getItem", "getItemCount", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setSelection", "update", "lensList", "", "BaseViewHolder", "Companion", "EndViewHolder", "StickerViewHolder", "TitleViewHolder", "plugin-emojicapture_release"})
public final class a extends RecyclerView.a<AbstractC0981a> {
    public static final String TAG = TAG;
    public static final b rsF = new b((byte) 0);
    public final ArrayList<com.tencent.mm.sticker.c> rsC = new ArrayList<>();
    public m<? super Integer, ? super com.tencent.mm.sticker.c, x> rsD;
    public kotlin.g.a.b<? super Integer, x> rsE;
    private int va = -1;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter$Companion;", "", "()V", "TAG", "", "ViewTypeEnd", "", "ViewTypeNormal", "ViewTypeTitle", "plugin-emojicapture_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    public a() {
        AppMethodBeat.i(JsApiChooseMultiMedia.CTRL_INDEX);
        AppMethodBeat.o(JsApiChooseMultiMedia.CTRL_INDEX);
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ AbstractC0981a a(ViewGroup viewGroup, int i2) {
        c cVar;
        AppMethodBeat.i(547);
        p.h(viewGroup, "parent");
        switch (i2) {
            case 1:
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.a1j, viewGroup, false);
                p.g(inflate, "LayoutInflater.from(pare…tem_title, parent, false)");
                cVar = new e(this, inflate);
                break;
            case 2:
                View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.a1h, viewGroup, false);
                p.g(inflate2, "LayoutInflater.from(pare…_item_end, parent, false)");
                cVar = new c(this, inflate2);
                break;
            default:
                View inflate3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.a1m, viewGroup, false);
                p.g(inflate3, "LayoutInflater.from(pare…anel_item, parent, false)");
                cVar = new d(this, inflate3);
                break;
        }
        RecyclerView.v vVar = cVar;
        AppMethodBeat.o(547);
        return vVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(AbstractC0981a aVar, int i2) {
        AppMethodBeat.i(548);
        AbstractC0981a aVar2 = aVar;
        p.h(aVar2, "holder");
        com.tencent.mm.sticker.c Gs = Gs(i2);
        if (Gs != null) {
            aVar2.c(Gs.NMJ);
        }
        View view = aVar2.aus;
        p.g(view, "holder.itemView");
        view.setSelected(i2 == this.va);
        kotlin.g.a.b<? super Integer, x> bVar = this.rsE;
        if (bVar != null) {
            bVar.invoke(Integer.valueOf(i2));
            AppMethodBeat.o(548);
            return;
        }
        AppMethodBeat.o(548);
    }

    static {
        AppMethodBeat.i(f.CTRL_INDEX);
        AppMethodBeat.o(f.CTRL_INDEX);
    }

    public final void setSelection(int i2) {
        AppMethodBeat.i(543);
        if (this.va != i2) {
            ci(this.va);
            this.va = i2;
            ci(this.va);
        }
        AppMethodBeat.o(543);
    }

    public final com.tencent.mm.sticker.c Gs(int i2) {
        AppMethodBeat.i(256437);
        com.tencent.mm.sticker.c cVar = (com.tencent.mm.sticker.c) j.L(this.rsC, i2);
        AppMethodBeat.o(256437);
        return cVar;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(545);
        int size = this.rsC.size();
        AppMethodBeat.o(545);
        return size;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemViewType(int i2) {
        chz chz;
        AppMethodBeat.i(546);
        com.tencent.mm.sticker.c Gs = Gs(i2);
        if (Gs != null) {
            chz = Gs.NMJ;
        } else {
            chz = null;
        }
        f.a aVar = com.tencent.mm.plugin.emojicapture.model.a.f.rpr;
        if (!p.j(chz, com.tencent.mm.plugin.emojicapture.model.a.f.rpo)) {
            f.a aVar2 = com.tencent.mm.plugin.emojicapture.model.a.f.rpr;
            if (!p.j(chz, com.tencent.mm.plugin.emojicapture.model.a.f.rpq)) {
                f.a aVar3 = com.tencent.mm.plugin.emojicapture.model.a.f.rpr;
                if (p.j(chz, com.tencent.mm.plugin.emojicapture.model.a.f.rpp)) {
                    AppMethodBeat.o(546);
                    return 2;
                }
                AppMethodBeat.o(546);
                return 0;
            }
        }
        AppMethodBeat.o(546);
        return 1;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b¦\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter$BaseViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter;Landroid/view/View;)V", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.a.a$a  reason: collision with other inner class name */
    public abstract class AbstractC0981a extends RecyclerView.v {
        final /* synthetic */ a rsG;

        public abstract void c(chz chz);

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AbstractC0981a(a aVar, View view) {
            super(view);
            p.h(view, "itemView");
            this.rsG = aVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u0019\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u000b\u001a\n \b*\u0004\u0018\u00010\f0\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u000f\u001a\n \b*\u0004\u0018\u00010\u00100\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter$StickerViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter;Landroid/view/View;)V", "frame", "Lcom/tencent/mm/plugin/emojicapture/ui/capture/StickerSelectFrame;", "kotlin.jvm.PlatformType", "getFrame", "()Lcom/tencent/mm/plugin/emojicapture/ui/capture/StickerSelectFrame;", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "text", "Landroid/widget/TextView;", "getText", "()Landroid/widget/TextView;", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-emojicapture_release"})
    public final class d extends AbstractC0981a {
        private final ImageView kc;
        private final TextView krl;
        final /* synthetic */ a rsG;
        private final StickerSelectFrame rsH;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(a aVar, View view) {
            super(aVar, view);
            p.h(view, "itemView");
            this.rsG = aVar;
            AppMethodBeat.i(TAVPlayer.VIDEO_PLAYER_WIDTH);
            this.kc = (ImageView) view.findViewById(R.id.bze);
            this.krl = (TextView) view.findViewById(R.id.bzf);
            this.rsH = (StickerSelectFrame) view.findViewById(R.id.bzk);
            view.setOnClickListener(new View.OnClickListener(this) {
                /* class com.tencent.mm.plugin.emojicapture.ui.a.a.d.AnonymousClass1 */
                final /* synthetic */ d rsI;

                {
                    this.rsI = r1;
                }

                public final void onClick(View view) {
                    m<? super Integer, ? super com.tencent.mm.sticker.c, x> mVar;
                    AppMethodBeat.i(538);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter$StickerViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    int lR = this.rsI.lR();
                    com.tencent.mm.sticker.c Gs = this.rsI.rsG.Gs(lR);
                    if (!(Gs == null || (mVar = this.rsI.rsG.rsD) == null)) {
                        mVar.invoke(Integer.valueOf(lR), Gs);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter$StickerViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(538);
                }
            });
            AppMethodBeat.o(TAVPlayer.VIDEO_PLAYER_WIDTH);
        }

        @Override // com.tencent.mm.plugin.emojicapture.ui.a.a.AbstractC0981a
        public final void c(chz chz) {
            AppMethodBeat.i(539);
            p.h(chz, "info");
            h hVar = h.NNV;
            com.tencent.mm.loader.a.b<com.tencent.mm.sticker.loader.a, Bitmap> bQ = h.getLoader().bQ(new com.tencent.mm.sticker.loader.a(chz));
            ImageView imageView = this.kc;
            p.g(imageView, "icon");
            bQ.c(imageView);
            TextView textView = this.krl;
            p.g(textView, "text");
            textView.setText(chz.Name);
            this.rsH.anq(chz.Lso);
            AppMethodBeat.o(539);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter$TitleViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter;Landroid/view/View;)V", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-emojicapture_release"})
    public final class e extends AbstractC0981a {
        final /* synthetic */ a rsG;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(a aVar, View view) {
            super(aVar, view);
            p.h(view, "itemView");
            this.rsG = aVar;
            AppMethodBeat.i(542);
            AppMethodBeat.o(542);
        }

        @Override // com.tencent.mm.plugin.emojicapture.ui.a.a.AbstractC0981a
        public final void c(chz chz) {
            AppMethodBeat.i(541);
            p.h(chz, "info");
            TextView textView = (TextView) this.aus.findViewById(R.id.bzf);
            f.a aVar = com.tencent.mm.plugin.emojicapture.model.a.f.rpr;
            if (p.j(chz, com.tencent.mm.plugin.emojicapture.model.a.f.rpo)) {
                textView.setText(R.string.bro);
                AppMethodBeat.o(541);
                return;
            }
            f.a aVar2 = com.tencent.mm.plugin.emojicapture.model.a.f.rpr;
            if (p.j(chz, com.tencent.mm.plugin.emojicapture.model.a.f.rpq)) {
                textView.setText(R.string.brr);
            }
            AppMethodBeat.o(541);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter$EndViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/emojicapture/ui/adapter/MoreStickerAdapter;Landroid/view/View;)V", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-emojicapture_release"})
    public final class c extends AbstractC0981a {
        final /* synthetic */ a rsG;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(a aVar, View view) {
            super(aVar, view);
            p.h(view, "itemView");
            this.rsG = aVar;
            AppMethodBeat.i(537);
            AppMethodBeat.o(537);
        }

        @Override // com.tencent.mm.plugin.emojicapture.ui.a.a.AbstractC0981a
        public final void c(chz chz) {
            AppMethodBeat.i(536);
            p.h(chz, "info");
            AppMethodBeat.o(536);
        }
    }
}
