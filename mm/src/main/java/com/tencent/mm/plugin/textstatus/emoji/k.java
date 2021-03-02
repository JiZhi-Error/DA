package com.tencent.mm.plugin.textstatus.emoji;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001cB!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0015\u001a\u00020\u00162\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0004H\u0016J\u000e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "itemView", "Landroid/view/View;", "typeName", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeViewHolder$IAlternativePyViewListener;", "(Landroid/view/View;Ljava/lang/String;Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeViewHolder$IAlternativePyViewListener;)V", "getListener", "()Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeViewHolder$IAlternativePyViewListener;", "rootView", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "subType", "Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeData;", "subTypeTv", "Landroid/widget/TextView;", "getTypeName", "()Ljava/lang/String;", "fillContent", "", "onClick", "v", "onSelect", "select", "", "IAlternativePyViewListener", "plugin-textstatus_release"})
public final class k extends RecyclerView.v implements View.OnClickListener {
    j VcP;
    private final a Vdb;
    TextView Vdg;
    private final String typeName;
    private final RelativeLayout zWu;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeViewHolder$IAlternativePyViewListener;", "", "onSubTypeClick", "", "position", "", "itemView", "Landroid/view/View;", "plugin-textstatus_release"})
    public interface a {
        void r(int i2, View view);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k(View view, String str, a aVar) {
        super(view);
        p.h(view, "itemView");
        p.h(str, "typeName");
        AppMethodBeat.i(258359);
        this.typeName = str;
        this.Vdb = aVar;
        this.zWu = (RelativeLayout) view.findViewById(R.id.h8v);
        View findViewById = view.findViewById(R.id.jun);
        p.g(findViewById, "itemView.findViewById(R.id.emoji_subtype_item_tv)");
        this.Vdg = (TextView) findViewById;
        AppMethodBeat.o(258359);
    }

    public final void onClick(View view) {
        AppMethodBeat.i(258357);
        b bVar = new b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        p.h(view, "v");
        a aVar = this.Vdb;
        if (aVar != null) {
            FI(true);
            aVar.r(lR(), view);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(258357);
    }

    public final void FI(boolean z) {
        AppMethodBeat.i(258358);
        RelativeLayout relativeLayout = this.zWu;
        p.g(relativeLayout, "rootView");
        if (relativeLayout.isSelected() != z) {
            RelativeLayout relativeLayout2 = this.zWu;
            p.g(relativeLayout2, "rootView");
            relativeLayout2.setSelected(z);
        }
        AppMethodBeat.o(258358);
    }
}
