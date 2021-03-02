package com.tencent.mm.plugin.story.ui.a;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.storage.as;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u001c\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/adapter/GalleryAvatarAdapter;", "Lcom/tencent/mm/plugin/story/ui/adapter/GalleryHeaderAdapter;", "Lcom/tencent/mm/plugin/story/ui/adapter/GalleryAvatarAdapter$GalleryAvatarViewHolder;", "()V", "chatRoom", "", "getChatRoom", "()Ljava/lang/String;", "setChatRoom", "(Ljava/lang/String;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "GalleryAvatarViewHolder", "plugin-story_release"})
public final class b extends d<a> {
    public String jVv;

    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ RecyclerView.v a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(119722);
        p.h(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.c06, viewGroup, false);
        p.g(inflate, "LayoutInflater.from(pare…atar_view, parent, false)");
        a aVar = new a(this, inflate);
        AppMethodBeat.o(119722);
        return aVar;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(RecyclerView.v vVar, int i2) {
        AppMethodBeat.i(119723);
        a aVar = (a) vVar;
        p.h(aVar, "holder");
        String str = this.kgc.get(i2);
        p.g(str, "dataList[position]");
        String str2 = str;
        if (!p.j(str2, "")) {
            com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
            p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
            as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().Kn(str2);
            View view = aVar.aus;
            p.g(view, "holder.itemView");
            Context context = view.getContext();
            p.g(Kn, "contact");
            aVar.kcZ.setText(com.tencent.mm.pluginsdk.ui.span.l.b(context, Kn.arJ(), aVar.kcZ.getTextSize()));
            a.b.d(aVar.gyr, str2, 0.5f);
            aVar.gyr.setOnClickListener(new View$OnClickListenerC1774b(this, str2, aVar));
        }
        AppMethodBeat.o(119723);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.a.b$b  reason: collision with other inner class name */
    static final class View$OnClickListenerC1774b implements View.OnClickListener {
        final /* synthetic */ b FxF;
        final /* synthetic */ String FxG;
        final /* synthetic */ a FxH;

        View$OnClickListenerC1774b(b bVar, String str, a aVar) {
            this.FxF = bVar;
            this.FxG = str;
            this.FxH = aVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(119720);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/adapter/GalleryAvatarAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            p.g(view, LocaleUtil.ITALIAN);
            if (view.isSelected()) {
                Intent intent = new Intent();
                intent.putExtra("Contact_User", this.FxG);
                intent.putExtra("Contact_ChatRoomId", this.FxF.jVv);
                intent.putExtra("CONTACT_INFO_UI_SOURCE", 15);
                View view2 = this.FxH.aus;
                p.g(view2, "holder.itemView");
                c.b(view2.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/adapter/GalleryAvatarAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(119720);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/adapter/GalleryAvatarAdapter$GalleryAvatarViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/GalleryAvatarAdapter;Landroid/view/View;)V", "avatarIv", "Landroid/widget/ImageView;", "getAvatarIv", "()Landroid/widget/ImageView;", "nickNameTv", "Landroid/widget/TextView;", "getNickNameTv", "()Landroid/widget/TextView;", "plugin-story_release"})
    public final class a extends RecyclerView.v {
        final /* synthetic */ b FxF;
        final ImageView gyr;
        final TextView kcZ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(b bVar, View view) {
            super(view);
            p.h(view, "itemView");
            this.FxF = bVar;
            AppMethodBeat.i(119719);
            View findViewById = view.findViewById(R.id.x1);
            p.g(findViewById, "itemView.findViewById(R.id.avatar_iv)");
            this.gyr = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.fzg);
            p.g(findViewById2, "itemView.findViewById(R.id.nickname_tv)");
            this.kcZ = (TextView) findViewById2;
            d.f(this.kcZ);
            AppMethodBeat.o(119719);
        }
    }

    @Override // com.tencent.mm.plugin.story.ui.a.d, android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(119721);
        int size = this.kgc.size();
        AppMethodBeat.o(119721);
        return size;
    }
}
