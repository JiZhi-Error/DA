package com.tencent.mm.live.view.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.b.x;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\tH\u0016J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\tH\u0016J\u0014\u0010\u0012\u001a\u00020\u000b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/live/view/adapter/LiveAfterMembersStatesAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/live/view/adapter/LiveAfterMembersStatesAdapter$LiveMemberItemHolder;", "()V", "membersList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/view/adapter/MembersData;", "Lkotlin/collections/ArrayList;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "type", "updateMembers", "members", "", "LiveMemberItemHolder", "plugin-logic_release"})
public final class b extends RecyclerView.a<a> {
    private final ArrayList<g> hXt = new ArrayList<>();

    public b() {
        AppMethodBeat.i(208660);
        AppMethodBeat.o(208660);
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ a a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(208657);
        p.h(viewGroup, "viewGroup");
        View inflate = View.inflate(viewGroup.getContext(), R.layout.b03, null);
        p.g(inflate, "itemView");
        inflate.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, -2));
        a aVar = new a(inflate);
        AppMethodBeat.o(208657);
        return aVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(a aVar, int i2) {
        AppMethodBeat.i(208659);
        a aVar2 = aVar;
        p.h(aVar2, "holder");
        a.b.c(aVar2.hXu, this.hXt.get(i2).username);
        TextView textView = aVar2.hXv;
        Context context = MMApplicationContext.getContext();
        x xVar = x.hJf;
        textView.setText(com.tencent.mm.pluginsdk.ui.span.l.b(context, x.GV(this.hXt.get(i2).username), aVar2.hXv.getTextSize()));
        aVar2.aus.setOnClickListener(View$OnClickListenerC0395b.hXx);
        AppMethodBeat.o(208659);
    }

    public final void ai(List<g> list) {
        AppMethodBeat.i(208656);
        p.h(list, "members");
        this.hXt.clear();
        this.hXt.addAll(list);
        AppMethodBeat.o(208656);
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(208658);
        int size = this.hXt.size();
        AppMethodBeat.o(208658);
        return size;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.live.view.a.b$b  reason: collision with other inner class name */
    static final class View$OnClickListenerC0395b implements View.OnClickListener {
        public static final View$OnClickListenerC0395b hXx = new View$OnClickListenerC0395b();

        static {
            AppMethodBeat.i(208655);
            AppMethodBeat.o(208655);
        }

        View$OnClickListenerC0395b() {
        }

        public final void onClick(View view) {
            AppMethodBeat.i(208654);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/view/adapter/LiveAfterMembersStatesAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/view/adapter/LiveAfterMembersStatesAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(208654);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/live/view/adapter/LiveAfterMembersStatesAdapter$LiveMemberItemHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "arrow", "Landroid/widget/ImageView;", "getArrow", "()Landroid/widget/ImageView;", "avatarIcon", "getAvatarIcon", "usernameTv", "Landroid/widget/TextView;", "getUsernameTv", "()Landroid/widget/TextView;", "plugin-logic_release"})
    public static final class a extends RecyclerView.v {
        final ImageView hXu;
        final TextView hXv;
        private final ImageView hXw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            p.h(view, "itemView");
            AppMethodBeat.i(208653);
            View findViewById = view.findViewById(R.id.eeo);
            p.g(findViewById, "itemView.findViewById(R.…_member_item_avatar_icon)");
            this.hXu = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.eep);
            p.g(findViewById2, "itemView.findViewById(R.…_member_item_username_tv)");
            this.hXv = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.een);
            p.g(findViewById3, "itemView.findViewById(R.…states_member_item_arrow)");
            this.hXw = (ImageView) findViewById3;
            AppMethodBeat.o(208653);
        }
    }
}
