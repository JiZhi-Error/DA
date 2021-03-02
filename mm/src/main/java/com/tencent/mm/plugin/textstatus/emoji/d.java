package com.tencent.mm.plugin.textstatus.emoji;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.textstatus.emoji.e;
import com.tencent.mm.plugin.textstatus.g.ac;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aa;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0010H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiContentAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiContentViewHolder;", "context", "Landroid/content/Context;", "emojiSubTypeList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeData;", "Lkotlin/collections/ArrayList;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/textstatus/emoji/IEmojiContentViewListener;", "(Landroid/content/Context;Ljava/util/ArrayList;Lcom/tencent/mm/plugin/textstatus/emoji/IEmojiContentViewListener;)V", "getContext", "()Landroid/content/Context;", "mListener", "getItemCount", "", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "Companion", "plugin-textstatus_release"})
public final class d extends RecyclerView.a<e> {
    public static final a VcH = new a((byte) 0);
    private final a VcF;
    private ArrayList<j> VcG;
    private final Context context;

    static {
        AppMethodBeat.i(258321);
        AppMethodBeat.o(258321);
    }

    public d(Context context2, ArrayList<j> arrayList, a aVar) {
        p.h(context2, "context");
        p.h(arrayList, "emojiSubTypeList");
        AppMethodBeat.i(258320);
        this.context = context2;
        this.VcG = arrayList;
        this.VcF = aVar;
        AppMethodBeat.o(258320);
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ e a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(258317);
        p.h(viewGroup, "viewGroup");
        Log.d("WxIme.ImeEmojiContentAdapter", "onCreateViewHolder ".concat(String.valueOf(i2)));
        View inflate = aa.jQ(viewGroup.getContext()).inflate(R.layout.cft, viewGroup, false);
        p.g(inflate, "MMLayoutInflater.getInfl…t_item, viewGroup, false)");
        e eVar = new e(inflate, this.VcF);
        AppMethodBeat.o(258317);
        return eVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(e eVar, int i2) {
        AppMethodBeat.i(258318);
        e eVar2 = eVar;
        p.h(eVar2, "viewHolder");
        Context context2 = this.context;
        j jVar = this.VcG.get(i2);
        p.g(jVar, "emojiSubTypeList[position]");
        j jVar2 = jVar;
        p.h(context2, "context");
        p.h(jVar2, "subTypeData");
        Log.d("WxIme.ImeEmojiContentAdapter", "fillContent " + jVar2.typeName);
        eVar2.VcP = jVar2;
        eVar2.VcO.setVisibility(4);
        eVar2.VcN.setLayoutManager(new EmojiLayoutManager(context2));
        RecyclerView recyclerView = eVar2.VcN;
        m mVar = m.Vdq;
        LinkedList<ac> linkedList = m.af(context2, "emoji", jVar2.typeName).IND;
        p.g(linkedList, "WxImeEmojiUtil.getAllEmo…a.typeName).emojiDataList");
        recyclerView.setAdapter(new f(context2, linkedList, jVar2.typeName, eVar2.VcQ));
        eVar2.VcM.setOnScrollChangeListener(new e.a(eVar2));
        AppMethodBeat.o(258318);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiContentAdapter$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(258319);
        int size = this.VcG.size();
        AppMethodBeat.o(258319);
        return size;
    }
}
