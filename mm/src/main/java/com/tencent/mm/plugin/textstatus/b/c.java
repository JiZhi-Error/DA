package com.tencent.mm.plugin.textstatus.b;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0019\u001aB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J@\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00122\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0016J \u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\tH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/convert/DoWhatItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/textstatus/model/square/DoWhatItem;", "onItemClickListener", "Lcom/tencent/mm/plugin/textstatus/convert/DoWhatItemConvert$OnItemClickListener;", "(Lcom/tencent/mm/plugin/textstatus/convert/DoWhatItemConvert$OnItemClickListener;)V", "getOnItemClickListener", "()Lcom/tencent/mm/plugin/textstatus/convert/DoWhatItemConvert$OnItemClickListener;", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "OnItemClickListener", "plugin-textstatus_release"})
public final class c extends e<com.tencent.mm.plugin.textstatus.f.e.c> {
    public static final a FXz = new a((byte) 0);
    final b FXy;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/convert/DoWhatItemConvert$OnItemClickListener;", "", "onItemClick", "", "v", "Landroid/view/View;", "item", "Lcom/tencent/mm/plugin/textstatus/model/square/DoWhatItem;", "plugin-textstatus_release"})
    public interface b {
        void a(View view, com.tencent.mm.plugin.textstatus.f.e.c cVar);
    }

    static {
        AppMethodBeat.i(216062);
        AppMethodBeat.o(216062);
    }

    public c(b bVar) {
        p.h(bVar, "onItemClickListener");
        AppMethodBeat.i(216061);
        this.FXy = bVar;
        AppMethodBeat.o(216061);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.view.recyclerview.e
    public final /* synthetic */ void a(h hVar, com.tencent.mm.plugin.textstatus.f.e.c cVar, int i2, int i3, boolean z, List list) {
        AppMethodBeat.i(216060);
        com.tencent.mm.plugin.textstatus.f.e.c cVar2 = cVar;
        p.h(hVar, "holder");
        p.h(cVar2, "item");
        View Mn = hVar.Mn(R.id.ixr);
        p.g(Mn, "holder.getView<TextView>(R.id.tv_item)");
        ((TextView) Mn).setText(cVar2.name);
        com.tencent.mm.plugin.textstatus.j.b bVar = com.tencent.mm.plugin.textstatus.j.b.GfZ;
        ((ImageView) hVar.Mn(R.id.dxe)).setImageDrawable(com.tencent.mm.plugin.textstatus.j.b.a(cVar2.VdG.Ggc, null, null, 6));
        hVar.aus.setOnClickListener(new View$OnClickListenerC1812c(this, cVar2));
        AppMethodBeat.o(216060);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/convert/DoWhatItemConvert$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return R.layout.c2f;
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, h hVar, int i2) {
        AppMethodBeat.i(216059);
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        AppMethodBeat.o(216059);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.textstatus.b.c$c  reason: collision with other inner class name */
    static final class View$OnClickListenerC1812c implements View.OnClickListener {
        final /* synthetic */ c FXA;
        final /* synthetic */ com.tencent.mm.plugin.textstatus.f.e.c FXB;

        View$OnClickListenerC1812c(c cVar, com.tencent.mm.plugin.textstatus.f.e.c cVar2) {
            this.FXA = cVar;
            this.FXB = cVar2;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(216058);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/convert/DoWhatItemConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            b bVar2 = this.FXA.FXy;
            p.g(view, LocaleUtil.ITALIAN);
            bVar2.a(view, this.FXB);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/convert/DoWhatItemConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(216058);
        }
    }
}
