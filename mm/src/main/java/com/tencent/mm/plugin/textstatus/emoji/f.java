package com.tencent.mm.plugin.textstatus.emoji;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.textstatus.g.ac;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.g.c.b;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0011H\u0016J\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0011H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiGridAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiGridViewHolder;", "context", "Landroid/content/Context;", "emojiList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/textstatus/proto/WxImeEmojiData;", "emojiSubType", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/textstatus/emoji/IEmojiContentViewListener;", "(Landroid/content/Context;Ljava/util/LinkedList;Ljava/lang/String;Lcom/tencent/mm/plugin/textstatus/emoji/IEmojiContentViewListener;)V", "getContext", "()Landroid/content/Context;", "mListener", "getItemCount", "", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "Companion", "plugin-textstatus_release"})
public final class f extends RecyclerView.a<g> {
    public static final a VcU = new a((byte) 0);
    private final a VcF;
    private LinkedList<ac> VcS;
    private String VcT;
    private final Context context;

    static {
        AppMethodBeat.i(258333);
        AppMethodBeat.o(258333);
    }

    public f(Context context2, LinkedList<ac> linkedList, String str, a aVar) {
        p.h(context2, "context");
        p.h(linkedList, "emojiList");
        p.h(str, "emojiSubType");
        AppMethodBeat.i(258332);
        this.context = context2;
        this.VcS = linkedList;
        this.VcT = str;
        this.VcF = aVar;
        AppMethodBeat.o(258332);
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ g a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(258329);
        p.h(viewGroup, "viewGroup");
        Log.d("WxIme.ImeEmojiGridAdapter", "onCreateViewHolder ".concat(String.valueOf(i2)));
        View inflate = aa.jQ(viewGroup.getContext()).inflate(R.layout.cfu, viewGroup, false);
        p.g(inflate, "MMLayoutInflater.getInfl…d_item, viewGroup, false)");
        g gVar = new g(inflate, this.VcF);
        AppMethodBeat.o(258329);
        return gVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(g gVar, int i2) {
        AppMethodBeat.i(258330);
        g gVar2 = gVar;
        p.h(gVar2, "viewHolder");
        Log.d("WxIme.ImeEmojiGridAdapter", "onBindViewHolder ".concat(String.valueOf(i2)));
        ac acVar = this.VcS.get(i2);
        p.g(acVar, "emojiList[position]");
        ac acVar2 = acVar;
        p.h(acVar2, "emojiData");
        gVar2.VcX = acVar2;
        TextView textView = gVar2.VcW;
        View view = gVar2.aus;
        p.g(view, "itemView");
        textView.setText(b.c(view.getContext(), acVar2.content, gVar2.VcW.getTextSize()));
        AppMethodBeat.o(258330);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiGridAdapter$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(258331);
        int size = this.VcS.size();
        AppMethodBeat.o(258331);
        return size;
    }
}
