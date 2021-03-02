package com.tencent.mm.plugin.finder.live.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.live.viewmodel.e;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001&B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0019H\u0016J\u0018\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0019H\u0016J\u0010\u0010!\u001a\u00020\u00132\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u0014\u0010\"\u001a\u00020\u00132\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\b0$J*\u0010%\u001a\u00020\u00132\"\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00050\u000bj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0005`\rR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0004¢\u0006\u0002\n\u0000R*\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00050\u000bj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0005`\rX\u000e¢\u0006\u0002\n\u0000R7\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006'"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveLinkInviteAnchorAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveLinkInviteAnchorAdapter$AnchorLinkViewHolder;", "()V", "curPkUser", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveLinkMicUser;", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "Lkotlin/collections/ArrayList;", "localApplyMicMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "onInviteAnchor", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "invitetUser", "", "getOnInviteAnchor", "()Lkotlin/jvm/functions/Function1;", "setOnInviteAnchor", "(Lkotlin/jvm/functions/Function1;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "type", "updateCurPkUser", "updateData", "data", "", "updateLocalApplyMicList", "AnchorLinkViewHolder", "plugin-finder_release"})
public final class l extends RecyclerView.a<a> {
    public HashMap<String, e> UOB = new HashMap<>();
    public e UOC;
    public kotlin.g.a.b<? super avn, x> UOD;
    private final ArrayList<avn> kgc = new ArrayList<>();

    public l() {
        AppMethodBeat.i(260920);
        AppMethodBeat.o(260920);
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ a a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(260916);
        p.h(viewGroup, "parent");
        View inflate = View.inflate(viewGroup.getContext(), R.layout.cf2, null);
        p.g(inflate, "View.inflate(parent.cont…_anchor_apply_item, null)");
        a aVar = new a(inflate);
        AppMethodBeat.o(260916);
        return aVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(a aVar, int i2) {
        String str;
        String str2;
        String str3;
        String str4;
        boolean z;
        String str5;
        String str6;
        String str7;
        String str8;
        FinderAuthInfo finderAuthInfo = null;
        AppMethodBeat.i(260918);
        a aVar2 = aVar;
        p.h(aVar2, "holder");
        avn avn = this.kgc.get(i2);
        p.g(avn, "dataList[position]");
        avn avn2 = avn;
        m mVar = m.uJa;
        d<o> dka = m.dka();
        FinderContact finderContact = avn2.contact;
        if (finderContact != null) {
            str = finderContact.headUrl;
        } else {
            str = null;
        }
        com.tencent.mm.plugin.finder.loader.a aVar3 = new com.tencent.mm.plugin.finder.loader.a(str);
        ImageView imageView = aVar2.keC;
        p.g(imageView, "holder.avatar");
        m mVar2 = m.uJa;
        dka.a(aVar3, imageView, m.a(m.a.AVATAR));
        TextView textView = aVar2.pIN;
        p.g(textView, "holder.nicknameTv");
        com.tencent.mm.plugin.finder.convert.d dVar = com.tencent.mm.plugin.finder.convert.d.tyZ;
        TextView textView2 = aVar2.pIN;
        p.g(textView2, "holder.nicknameTv");
        y yVar = y.vXH;
        FinderContact finderContact2 = avn2.contact;
        if (finderContact2 == null || (str2 = finderContact2.username) == null) {
            str2 = "";
        }
        FinderContact finderContact3 = avn2.contact;
        if (finderContact3 == null || (str3 = finderContact3.nickname) == null) {
            str3 = "";
        }
        textView.setText(com.tencent.mm.plugin.finder.convert.d.e(textView2, y.hf(str2, str3)));
        FinderContact finderContact4 = avn2.contact;
        if (finderContact4 != null) {
            str4 = finderContact4.signature;
        } else {
            str4 = null;
        }
        String str9 = str4;
        if (str9 == null || str9.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            TextView textView3 = aVar2.hPW;
            p.g(textView3, "holder.descTv");
            textView3.setVisibility(8);
        } else {
            TextView textView4 = aVar2.hPW;
            p.g(textView4, "holder.descTv");
            textView4.setVisibility(0);
            TextView textView5 = aVar2.hPW;
            p.g(textView5, "holder.descTv");
            TextView textView6 = aVar2.hPW;
            p.g(textView6, "holder.descTv");
            Context context = textView6.getContext();
            FinderContact finderContact5 = avn2.contact;
            if (finderContact5 != null) {
                str5 = finderContact5.signature;
            } else {
                str5 = null;
            }
            TextView textView7 = aVar2.hPW;
            p.g(textView7, "holder.descTv");
            textView5.setText(com.tencent.mm.pluginsdk.ui.span.l.b(context, str5, textView7.getTextSize()));
        }
        e eVar = this.UOC;
        if (eVar != null) {
            str6 = eVar.username;
        } else {
            str6 = null;
        }
        FinderContact finderContact6 = avn2.contact;
        if (finderContact6 != null) {
            str7 = finderContact6.username;
        } else {
            str7 = null;
        }
        if (Util.isEqual(str6, str7)) {
            TextView textView8 = aVar2.UOE;
            p.g(textView8, "holder.inviteBtn");
            TextView textView9 = aVar2.UOE;
            p.g(textView9, "holder.inviteBtn");
            Context context2 = textView9.getContext();
            p.g(context2, "holder.inviteBtn.context");
            textView8.setText(context2.getResources().getString(R.string.jab));
            TextView textView10 = aVar2.UOE;
            p.g(textView10, "holder.inviteBtn");
            TextView textView11 = aVar2.UOE;
            p.g(textView11, "holder.inviteBtn");
            textView10.setBackground(textView11.getContext().getDrawable(R.drawable.cun));
            TextView textView12 = aVar2.UOE;
            TextView textView13 = aVar2.UOE;
            p.g(textView13, "holder.inviteBtn");
            Context context3 = textView13.getContext();
            p.g(context3, "holder.inviteBtn.context");
            textView12.setTextColor(context3.getResources().getColor(R.color.Red_100));
        } else {
            HashMap<String, e> hashMap = this.UOB;
            FinderContact finderContact7 = avn2.contact;
            if (finderContact7 != null) {
                str8 = finderContact7.username;
            } else {
                str8 = null;
            }
            if (hashMap.get(str8) == null) {
                TextView textView14 = aVar2.UOE;
                p.g(textView14, "holder.inviteBtn");
                TextView textView15 = aVar2.UOE;
                p.g(textView15, "holder.inviteBtn");
                Context context4 = textView15.getContext();
                p.g(context4, "holder.inviteBtn.context");
                textView14.setText(context4.getResources().getString(R.string.jac));
                TextView textView16 = aVar2.UOE;
                p.g(textView16, "holder.inviteBtn");
                TextView textView17 = aVar2.UOE;
                p.g(textView17, "holder.inviteBtn");
                Context context5 = textView17.getContext();
                p.g(context5, "holder.inviteBtn.context");
                textView16.setBackground(context5.getResources().getDrawable(R.drawable.cut));
                TextView textView18 = aVar2.UOE;
                TextView textView19 = aVar2.UOE;
                p.g(textView19, "holder.inviteBtn");
                Context context6 = textView19.getContext();
                p.g(context6, "holder.inviteBtn.context");
                textView18.setTextColor(context6.getResources().getColor(R.color.BW_0_Alpha_0_8));
            } else {
                TextView textView20 = aVar2.UOE;
                p.g(textView20, "holder.inviteBtn");
                TextView textView21 = aVar2.UOE;
                p.g(textView21, "holder.inviteBtn");
                Context context7 = textView21.getContext();
                p.g(context7, "holder.inviteBtn.context");
                textView20.setText(context7.getResources().getString(R.string.ctr));
                TextView textView22 = aVar2.UOE;
                p.g(textView22, "holder.inviteBtn");
                TextView textView23 = aVar2.UOE;
                p.g(textView23, "holder.inviteBtn");
                Context context8 = textView23.getContext();
                p.g(context8, "holder.inviteBtn.context");
                textView22.setBackground(context8.getResources().getDrawable(R.drawable.a20));
                TextView textView24 = aVar2.UOE;
                TextView textView25 = aVar2.UOE;
                p.g(textView25, "holder.inviteBtn");
                Context context9 = textView25.getContext();
                p.g(context9, "holder.inviteBtn.context");
                textView24.setTextColor(context9.getResources().getColor(R.color.BW_0_Alpha_0_8));
            }
        }
        y yVar2 = y.vXH;
        ImageView imageView2 = aVar2.uzZ;
        p.g(imageView2, "holder.typeIcon");
        FinderContact finderContact8 = avn2.contact;
        if (finderContact8 != null) {
            finderAuthInfo = finderContact8.authInfo;
        }
        y.a(imageView2, finderAuthInfo, 0);
        aVar2.UOE.setOnClickListener(new b(this, i2));
        AppMethodBeat.o(260918);
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(260917);
        int size = this.kgc.size();
        AppMethodBeat.o(260917);
        return size;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ l UOF;
        final /* synthetic */ int gUj;

        b(l lVar, int i2) {
            this.UOF = lVar;
            this.gUj = i2;
        }

        public final void onClick(View view) {
            kotlin.g.a.b<? super avn, x> bVar;
            AppMethodBeat.i(260915);
            com.tencent.mm.hellhoundlib.b.b bVar2 = new com.tencent.mm.hellhoundlib.b.b();
            bVar2.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveLinkInviteAnchorAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar2.axR());
            avn avn = (avn) j.L(this.UOF.kgc, this.gUj);
            if (!(avn == null || (bVar = this.UOF.UOD) == null)) {
                bVar.invoke(avn);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveLinkInviteAnchorAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(260915);
        }
    }

    public final void ad(List<? extends avn> list) {
        AppMethodBeat.i(260919);
        p.h(list, "data");
        this.kgc.clear();
        this.kgc.addAll(list);
        AppMethodBeat.o(260919);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0019\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0019\u0010\u0010\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0019\u0010\u0012\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\t¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveLinkInviteAnchorAdapter$AnchorLinkViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getAvatar", "()Landroid/widget/ImageView;", "descTv", "Landroid/widget/TextView;", "getDescTv", "()Landroid/widget/TextView;", "inviteBtn", "getInviteBtn", "nicknameTv", "getNicknameTv", "typeIcon", "getTypeIcon", "plugin-finder_release"})
    public static final class a extends RecyclerView.v {
        final TextView UOE;
        final TextView hPW;
        final ImageView keC;
        final TextView pIN;
        final ImageView uzZ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            p.h(view, "itemView");
            AppMethodBeat.i(260914);
            this.keC = (ImageView) view.findViewById(R.id.jxl);
            this.pIN = (TextView) view.findViewById(R.id.jxq);
            this.uzZ = (ImageView) view.findViewById(R.id.jxr);
            this.UOE = (TextView) view.findViewById(R.id.jxk);
            this.hPW = (TextView) view.findViewById(R.id.jxt);
            AppMethodBeat.o(260914);
        }
    }
}
