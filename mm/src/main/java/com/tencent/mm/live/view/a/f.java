package com.tencent.mm.live.view.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.aa;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0016H\u0016J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0016H\u0016J\u0006\u0010\u001e\u001a\u00020\u0006J\u0014\u0010\u001f\u001a\u00020\u00062\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00120!R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR!\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00120\fj\b\u0012\u0004\u0012\u00020\u0012`\u000eX\u0004¢\u0006\u0002\n\u0000R!\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010¨\u0006#"}, hxF = {"Lcom/tencent/mm/live/view/adapter/LiveShareRoomsAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/live/view/adapter/LiveShareRoomsAdapter$LiveShareRoomsItemHolder;", "()V", "itemClickListener", "Lkotlin/Function0;", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function0;", "setItemClickListener", "(Lkotlin/jvm/functions/Function0;)V", "lastSelectedList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getLastSelectedList", "()Ljava/util/ArrayList;", "roomsList", "Lcom/tencent/mm/live/view/adapter/ShareRoomItem;", "selectedList", "getSelectedList", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "type", "reset", "updateRooms", "rooms", "", "LiveShareRoomsItemHolder", "plugin-logic_release"})
public final class f extends RecyclerView.a<a> {
    public final ArrayList<h> hXG = new ArrayList<>();
    final ArrayList<String> hXH = new ArrayList<>();
    public final ArrayList<String> hXI = new ArrayList<>();
    public kotlin.g.a.a<x> hXJ;

    public f() {
        AppMethodBeat.i(208681);
        AppMethodBeat.o(208681);
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ a a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(208678);
        p.h(viewGroup, "viewGroup");
        View inflate = View.inflate(viewGroup.getContext(), R.layout.b1j, null);
        p.g(inflate, "itemView");
        a aVar = new a(inflate);
        AppMethodBeat.o(208678);
        return aVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(a aVar, int i2) {
        AppMethodBeat.i(208680);
        a aVar2 = aVar;
        p.h(aVar2, "holder");
        String str = this.hXG.get(i2).username;
        a.b.c(aVar2.hXu, str);
        aVar2.hXv.setText(com.tencent.mm.pluginsdk.ui.span.l.b(MMApplicationContext.getContext(), aa.getDisplayName(this.hXG.get(i2).username), aVar2.hXv.getTextSize()));
        TextView textView = aVar2.hXK;
        ae aeVar = ae.SYK;
        Context context = aVar2.hXK.getContext();
        p.g(context, "holder.countTv.context");
        String string = context.getResources().getString(R.string.eji);
        p.g(string, "holder.countTv.context.r…e_share_rooms_item_count)");
        String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(this.hXG.get(i2).dRN)}, 1));
        p.g(format, "java.lang.String.format(format, *args)");
        textView.setText(format);
        aVar2.hSH.setEnabled(!this.hXH.contains(str));
        aVar2.aus.setOnClickListener(new b(this, i2, aVar2));
        AppMethodBeat.o(208680);
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(208679);
        int size = this.hXG.size();
        AppMethodBeat.o(208679);
        return size;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ int gUj;
        final /* synthetic */ f hXL;
        final /* synthetic */ a hXM;

        b(f fVar, int i2, a aVar) {
            this.hXL = fVar;
            this.gUj = i2;
            this.hXM = aVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(208677);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/view/adapter/LiveShareRoomsAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            String str = ((h) this.hXL.hXG.get(this.gUj)).username;
            if (!this.hXL.hXH.contains(str)) {
                if (this.hXL.hXI.contains(str)) {
                    this.hXL.hXI.remove(str);
                    this.hXM.hSH.setActivated(false);
                } else {
                    this.hXL.hXI.add(str);
                    this.hXM.hSH.setActivated(true);
                }
                kotlin.g.a.a<x> aVar = this.hXL.hXJ;
                if (aVar != null) {
                    aVar.invoke();
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/view/adapter/LiveShareRoomsAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(208677);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0011\u0010\u000f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/live/view/adapter/LiveShareRoomsAdapter$LiveShareRoomsItemHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "avatarIcon", "Landroid/widget/ImageView;", "getAvatarIcon", "()Landroid/widget/ImageView;", "countTv", "Landroid/widget/TextView;", "getCountTv", "()Landroid/widget/TextView;", "selectIcon", "getSelectIcon", "usernameTv", "getUsernameTv", "plugin-logic_release"})
    public static final class a extends RecyclerView.v {
        final ImageView hSH;
        final TextView hXK;
        final ImageView hXu;
        final TextView hXv;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            p.h(view, "itemView");
            AppMethodBeat.i(208676);
            View findViewById = view.findViewById(R.id.elu);
            p.g(findViewById, "itemView.findViewById(R.…hare_rooms_item_selector)");
            this.hSH = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.els);
            p.g(findViewById2, "itemView.findViewById(R.…e_rooms_item_avatar_icon)");
            this.hXu = (ImageView) findViewById2;
            View findViewById3 = view.findViewById(R.id.elv);
            p.g(findViewById3, "itemView.findViewById(R.…e_rooms_item_username_tv)");
            this.hXv = (TextView) findViewById3;
            View findViewById4 = view.findViewById(R.id.elt);
            p.g(findViewById4, "itemView.findViewById(R.…hare_rooms_item_count_tv)");
            this.hXK = (TextView) findViewById4;
            AppMethodBeat.o(208676);
        }
    }
}
