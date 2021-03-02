package com.tencent.mm.plugin.textstatus.b;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.textstatus.f.f.b;
import com.tencent.mm.plugin.textstatus.f.i;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J@\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0016J \u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0005H\u0016¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/convert/SquareItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/textstatus/model/square/SquareItem;", "()V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "plugin-textstatus_release"})
public final class e extends com.tencent.mm.view.recyclerview.e<com.tencent.mm.plugin.textstatus.f.e.e> {
    public static final a FXC = new a((byte) 0);

    static {
        AppMethodBeat.i(216069);
        AppMethodBeat.o(216069);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.view.recyclerview.e
    public final /* synthetic */ void a(h hVar, com.tencent.mm.plugin.textstatus.f.e.e eVar, int i2, int i3, boolean z, List list) {
        AppMethodBeat.i(216068);
        com.tencent.mm.plugin.textstatus.f.e.e eVar2 = eVar;
        p.h(hVar, "holder");
        p.h(eVar2, "item");
        View Mn = hVar.Mn(R.id.iy1);
        p.g(Mn, "holder.getView<TextView>(R.id.tv_name)");
        ((TextView) Mn).setText(eVar2.name);
        hVar.Mn(R.id.e4j);
        ((TextView) hVar.Mn(R.id.ixu)).setOnClickListener(new b(eVar2));
        AppMethodBeat.o(216068);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/convert/SquareItemConvert$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return R.layout.c31;
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, h hVar, int i2) {
        AppMethodBeat.i(216067);
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        AppMethodBeat.o(216067);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.plugin.textstatus.f.e.e FXD;

        b(com.tencent.mm.plugin.textstatus.f.e.e eVar) {
            this.FXD = eVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(216066);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/convert/SquareItemConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            String str = this.FXD.FZz;
            String str2 = this.FXD.FYf;
            b.a aVar = com.tencent.mm.plugin.textstatus.f.f.b.FZG;
            i iVar = new i(str, str2, "hello", com.tencent.mm.plugin.textstatus.f.f.b.FZE, 4);
            g.azz().a(iVar.getType(), new com.tencent.mm.ak.i() {
                /* class com.tencent.mm.plugin.textstatus.b.e.b.AnonymousClass1 */

                @Override // com.tencent.mm.ak.i
                public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(216065);
                    if (qVar instanceof i) {
                        g.azz().b(((i) qVar).getType(), this);
                        if (i2 == 0 && i3 == 0) {
                            Log.i("MicroMsg.TxtStatus.SquareItemConvert", "onSceneEnd NetSceneTextStatusLike ok");
                        }
                    }
                    AppMethodBeat.o(216065);
                }
            });
            g.azz().b(iVar);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/convert/SquareItemConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(216066);
        }
    }
}
