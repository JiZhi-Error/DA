package com.tencent.mm.plugin.textstatus.emoji;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.textstatus.emoji.k;
import com.tencent.mm.ui.aa;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB9\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\b\u0010\u0011\u001a\u00020\nH\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\nH\u0016J\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\nH\u0016J\u0006\u0010\u001a\u001a\u00020\u0013J\u0016\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0015\u001a\u00020\nR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0006j\b\u0012\u0004\u0012\u00020\u0002`\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeViewHolder;", "typeName", "", "subTypeList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeData;", "Lkotlin/collections/ArrayList;", "selectedPosition", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeViewHolder$IAlternativePyViewListener;", "(Ljava/lang/String;Ljava/util/ArrayList;ILcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeViewHolder$IAlternativePyViewListener;)V", "getListener", "()Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeViewHolder$IAlternativePyViewListener;", "viewHolderList", "getItemCount", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "p1", "reset", "setSelection", "context", "Landroid/content/Context;", "Companion", "plugin-textstatus_release"})
public final class i extends RecyclerView.a<k> {
    public static final a Vdc = new a((byte) 0);
    private final ArrayList<j> Vda;
    private final k.a Vdb;
    final String typeName;
    int va;
    private final ArrayList<k> wmk = new ArrayList<>(this.Vda.size());

    static {
        AppMethodBeat.i(258350);
        AppMethodBeat.o(258350);
    }

    public i(String str, ArrayList<j> arrayList, int i2, k.a aVar) {
        p.h(str, "typeName");
        p.h(arrayList, "subTypeList");
        AppMethodBeat.i(258349);
        this.typeName = str;
        this.Vda = arrayList;
        this.va = i2;
        this.Vdb = aVar;
        AppMethodBeat.o(258349);
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ k a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(258346);
        p.h(viewGroup, "viewGroup");
        View inflate = aa.jQ(viewGroup.getContext()).inflate(R.layout.cfv, viewGroup, false);
        p.g(inflate, "MMLayoutInflater.getInfl…s_item, viewGroup, false)");
        k kVar = new k(inflate, this.typeName, this.Vdb);
        AppMethodBeat.o(258346);
        return kVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(k kVar, int i2) {
        String str;
        AppMethodBeat.i(258347);
        k kVar2 = kVar;
        p.h(kVar2, "viewHolder");
        j jVar = this.Vda.get(i2);
        kVar2.VcP = jVar;
        TextView textView = kVar2.Vdg;
        if (jVar != null) {
            str = jVar.Vdd;
        } else {
            str = null;
        }
        textView.setText(str);
        kVar2.aus.setOnClickListener(kVar2);
        kVar2.FI(this.va == i2);
        if (!this.wmk.contains(kVar2)) {
            this.wmk.add(i2, kVar2);
        }
        AppMethodBeat.o(258347);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeAdapter$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(258348);
        int size = this.Vda.size();
        AppMethodBeat.o(258348);
        return size;
    }
}
