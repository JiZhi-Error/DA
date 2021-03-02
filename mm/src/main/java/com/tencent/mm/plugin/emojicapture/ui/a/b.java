package com.tencent.mm.plugin.emojicapture.ui.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.easygo.sdk.constant.EasyGoCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.k.z;
import com.tencent.mm.plugin.appbrand.jsapi.lab.JsApiGetLabInfo;
import com.tencent.mm.plugin.appbrand.jsapi.share.g;
import com.tencent.mm.plugin.emojicapture.model.a.f;
import com.tencent.mm.protocal.protobuf.chz;
import com.tencent.mm.sticker.loader.h;
import java.util.ArrayList;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\u0018\u0000 $2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0005#$%&'B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\u0006J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0006\u0010\u0018\u001a\u00020\u0006J\u001c\u0010\u0019\u001a\u00020\f2\n\u0010\u001a\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u001c\u0010\u001b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0006H\u0016J\u000e\u0010\u001f\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0006J\u0014\u0010 \u001a\u00020\f2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\n0\"RL\u0010\u0004\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0013j\b\u0012\u0004\u0012\u00020\n`\u0014X\u0004¢\u0006\u0002\n\u0000¨\u0006("}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$BaseViewHolder;", "()V", "itemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "Lcom/tencent/mm/sticker/LensItem;", "info", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "selectedPosition", "stickerList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getItem", "getItemCount", "getItemViewType", "getSelection", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setSelection", "update", "lensList", "", "BaseViewHolder", "Companion", "EmptyStickerViewHolder", "MoreStickerViewHolder", "StickerViewHolder", "plugin-emojicapture_release"})
public final class b extends RecyclerView.a<a> {
    public static final String TAG = TAG;
    public static final C0982b rsJ = new C0982b((byte) 0);
    public final ArrayList<com.tencent.mm.sticker.c> rsC = new ArrayList<>();
    public m<? super Integer, ? super com.tencent.mm.sticker.c, x> rsD;
    public int va = -1;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$Companion;", "", "()V", "TAG", "", "ViewTypeEmpty", "", "ViewTypeMore", "ViewTypeNormal", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.a.b$b  reason: collision with other inner class name */
    public static final class C0982b {
        private C0982b() {
        }

        public /* synthetic */ C0982b(byte b2) {
            this();
        }
    }

    public b() {
        AppMethodBeat.i(563);
        AppMethodBeat.o(563);
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ a a(ViewGroup viewGroup, int i2) {
        d dVar;
        AppMethodBeat.i(561);
        p.h(viewGroup, "parent");
        switch (i2) {
            case 1:
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.a1g, viewGroup, false);
                p.g(inflate, "LayoutInflater.from(pare…tem_empty, parent, false)");
                dVar = new c(this, inflate);
                break;
            case 2:
                View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.a1i, viewGroup, false);
                p.g(inflate2, "LayoutInflater.from(pare…item_more, parent, false)");
                dVar = new d(this, inflate2);
                break;
            default:
                View inflate3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.a1f, viewGroup, false);
                p.g(inflate3, "LayoutInflater.from(pare…cker_item, parent, false)");
                dVar = new e(this, inflate3);
                break;
        }
        RecyclerView.v vVar = dVar;
        AppMethodBeat.o(561);
        return vVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(a aVar, int i2) {
        AppMethodBeat.i(562);
        a aVar2 = aVar;
        p.h(aVar2, "holder");
        com.tencent.mm.sticker.c Gs = Gs(i2);
        if (Gs != null) {
            aVar2.c(Gs.NMJ);
        }
        AppMethodBeat.o(562);
    }

    static {
        AppMethodBeat.i(564);
        AppMethodBeat.o(564);
    }

    public final com.tencent.mm.sticker.c Gs(int i2) {
        AppMethodBeat.i(256438);
        com.tencent.mm.sticker.c cVar = (com.tencent.mm.sticker.c) j.L(this.rsC, i2);
        AppMethodBeat.o(256438);
        return cVar;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(559);
        int size = this.rsC.size();
        AppMethodBeat.o(559);
        return size;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemViewType(int i2) {
        chz chz;
        AppMethodBeat.i(EasyGoCode.ReleaseErrCode.UNKNOWN_ERR);
        com.tencent.mm.sticker.c Gs = Gs(i2);
        if (Gs != null) {
            chz = Gs.NMJ;
        } else {
            chz = null;
        }
        f.a aVar = f.rpr;
        if (p.j(chz, f.rpl)) {
            AppMethodBeat.o(EasyGoCode.ReleaseErrCode.UNKNOWN_ERR);
            return 1;
        }
        f.a aVar2 = f.rpr;
        if (!p.j(chz, f.rpn)) {
            f.a aVar3 = f.rpr;
            if (!p.j(chz, f.rpm)) {
                AppMethodBeat.o(EasyGoCode.ReleaseErrCode.UNKNOWN_ERR);
                return 0;
            }
        }
        AppMethodBeat.o(EasyGoCode.ReleaseErrCode.UNKNOWN_ERR);
        return 2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b¦\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H&R\u0019\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$BaseViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;Landroid/view/View;)V", "icon", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getIcon", "()Landroid/widget/ImageView;", "text", "Landroid/widget/TextView;", "getText", "()Landroid/widget/TextView;", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-emojicapture_release"})
    public abstract class a extends RecyclerView.v {
        final ImageView kc;
        final TextView krl;
        final /* synthetic */ b rsK;

        public abstract void c(chz chz);

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(b bVar, final View view) {
            super(view);
            p.h(view, "itemView");
            this.rsK = bVar;
            this.kc = (ImageView) view.findViewById(R.id.bze);
            this.krl = (TextView) view.findViewById(R.id.bzf);
            view.setOnClickListener(new View.OnClickListener(this) {
                /* class com.tencent.mm.plugin.emojicapture.ui.a.b.a.AnonymousClass1 */
                final /* synthetic */ a rsL;

                {
                    this.rsL = r1;
                }

                public final void onClick(View view) {
                    m<? super Integer, ? super com.tencent.mm.sticker.c, x> mVar;
                    AppMethodBeat.i(551);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$BaseViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    int lR = this.rsL.lR();
                    com.tencent.mm.sticker.c Gs = this.rsL.rsK.Gs(lR);
                    if (!(Gs == null || (mVar = this.rsL.rsK.rsD) == null)) {
                        mVar.invoke(Integer.valueOf(lR), Gs);
                    }
                    view.requestFocus();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$BaseViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(551);
                }
            });
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$StickerViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;Landroid/view/View;)V", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-emojicapture_release"})
    public final class e extends a {
        final /* synthetic */ b rsK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(b bVar, View view) {
            super(bVar, view);
            p.h(view, "itemView");
            this.rsK = bVar;
            AppMethodBeat.i(JsApiGetLabInfo.CTRL_INDEX);
            AppMethodBeat.o(JsApiGetLabInfo.CTRL_INDEX);
        }

        @Override // com.tencent.mm.plugin.emojicapture.ui.a.b.a
        public final void c(chz chz) {
            AppMethodBeat.i(556);
            p.h(chz, "info");
            h hVar = h.NNV;
            com.tencent.mm.loader.a.b<com.tencent.mm.sticker.loader.a, Bitmap> bQ = h.getLoader().bQ(new com.tencent.mm.sticker.loader.a(chz));
            ImageView imageView = this.kc;
            p.g(imageView, "icon");
            bQ.c(imageView);
            TextView textView = this.krl;
            p.g(textView, "text");
            textView.setText(chz.Name);
            AppMethodBeat.o(556);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$EmptyStickerViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;Landroid/view/View;)V", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-emojicapture_release"})
    public final class c extends a {
        final /* synthetic */ b rsK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(b bVar, View view) {
            super(bVar, view);
            p.h(view, "itemView");
            this.rsK = bVar;
            AppMethodBeat.i(553);
            AppMethodBeat.o(553);
        }

        @Override // com.tencent.mm.plugin.emojicapture.ui.a.b.a
        public final void c(chz chz) {
            AppMethodBeat.i(g.CTRL_INDEX);
            p.h(chz, "info");
            ImageView imageView = this.kc;
            p.g(imageView, "icon");
            ImageView imageView2 = this.kc;
            p.g(imageView2, "icon");
            Context context = imageView2.getContext();
            p.g(context, "icon.context");
            com.tencent.mm.plugin.emojicapture.ui.c.a(imageView, R.raw.icons_outlined_no_effect, context.getResources().getColor(R.color.FG_0));
            this.krl.setText(R.string.brq);
            AppMethodBeat.o(g.CTRL_INDEX);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$MoreStickerViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter$BaseViewHolder;", "Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/emojicapture/ui/adapter/StickerAdapter;Landroid/view/View;)V", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-emojicapture_release"})
    public final class d extends a {
        final /* synthetic */ b rsK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(b bVar, View view) {
            super(bVar, view);
            p.h(view, "itemView");
            this.rsK = bVar;
            AppMethodBeat.i(z.CTRL_INDEX);
            AppMethodBeat.o(z.CTRL_INDEX);
        }

        @Override // com.tencent.mm.plugin.emojicapture.ui.a.b.a
        public final void c(chz chz) {
            AppMethodBeat.i(554);
            p.h(chz, "info");
            f.a aVar = f.rpr;
            if (p.j(chz, f.rpn)) {
                View view = this.aus;
                p.g(view, "itemView");
                view.setVisibility(4);
                AppMethodBeat.o(554);
                return;
            }
            View view2 = this.aus;
            p.g(view2, "itemView");
            view2.setVisibility(0);
            ImageView imageView = this.kc;
            p.g(imageView, "icon");
            ImageView imageView2 = this.kc;
            p.g(imageView2, "icon");
            Context context = imageView2.getContext();
            p.g(context, "icon.context");
            com.tencent.mm.plugin.emojicapture.ui.c.a(imageView, R.raw.icons_filled_more, context.getResources().getColor(R.color.FG_0));
            this.krl.setText(R.string.brp);
            AppMethodBeat.o(554);
        }
    }
}
