package com.tencent.mm.plugin.finder.live.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.protocal.protobuf.aus;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 =2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003<=>B\u0005¢\u0006\u0002\u0010\u0003J\u001c\u0010)\u001a\u00020\u001c2\n\u0010*\u001a\u00060+R\u00020\u00002\u0006\u0010,\u001a\u00020\u0005H\u0002J\u001c\u0010-\u001a\u00020\u001c2\n\u0010*\u001a\u00060.R\u00020\u00002\u0006\u0010,\u001a\u00020\u0005H\u0002J\b\u0010/\u001a\u00020\u0012H\u0002J\b\u00100\u001a\u00020\u0005H\u0016J\u0012\u00101\u001a\u0004\u0018\u00010\f2\u0006\u00102\u001a\u00020\u0005H\u0002J\u0010\u00103\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u0005H\u0016J\u0018\u00104\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\u0005H\u0016J\u0018\u00105\u001a\u00020\u00022\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0005H\u0016J&\u00109\u001a\u00020\u001c2\u0006\u0010:\u001a\u00020\u00052\u000e\u0010;\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0006\u0010\u0011\u001a\u00020\u0012R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R7\u0010\u0017\u001a\u001f\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 RL\u0010!\u001a4\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110#¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u001c\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006?"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveVisitorRoleAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "()V", "curRoleType", "", "getCurRoleType", "()I", "setCurRoleType", "(I)V", "dataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAliasInfo;", "getDataList", "()Ljava/util/LinkedList;", "setDataList", "(Ljava/util/LinkedList;)V", "enableCreate", "", "getEnableCreate", "()Z", "setEnableCreate", "(Z)V", "onItemClikListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "chooseItem", "", "getOnItemClikListener", "()Lkotlin/jvm/functions/Function1;", "setOnItemClikListener", "(Lkotlin/jvm/functions/Function1;)V", "onItemLongClikListener", "Lkotlin/Function2;", "Landroid/view/View;", "itemView", "getOnItemLongClikListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemLongClikListener", "(Lkotlin/jvm/functions/Function2;)V", "bindBottomViewHolder", "holder", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveVisitorRoleAdapter$BottomViewHolder;", "position", "bindVisitorModeViewHolder", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveVisitorRoleAdapter$VisitorModeViewHolder;", "containeAlias", "getItemCount", "getItemData", "pos", "getItemViewType", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "type", "updateAliasInfoList", "roleType", "list", "BottomViewHolder", "Companion", "VisitorModeViewHolder", "plugin-finder_release"})
public final class t extends RecyclerView.a<RecyclerView.v> {
    public static final b UPn = new b((byte) 0);
    public kotlin.g.a.b<? super aus, x> UPj;
    public m<? super aus, ? super View, x> UPk;
    int UPl = 1;
    boolean UPm;
    private LinkedList<aus> ppH = new LinkedList<>();

    static {
        AppMethodBeat.i(261003);
        AppMethodBeat.o(261003);
    }

    public t() {
        AppMethodBeat.i(261002);
        AppMethodBeat.o(261002);
    }

    public static final /* synthetic */ aus a(t tVar, int i2) {
        AppMethodBeat.i(261004);
        aus awO = tVar.awO(i2);
        AppMethodBeat.o(261004);
        return awO;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveVisitorRoleAdapter$Companion;", "", "()V", "TAG", "", "TYPE_BOTTOM", "", "plugin-finder_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final RecyclerView.v a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(260995);
        p.h(viewGroup, "parent");
        switch (i2) {
            case 10001:
                View inflate = View.inflate(viewGroup.getContext(), R.layout.cfh, null);
                p.g(inflate, "itemView");
                a aVar = new a(this, inflate);
                AppMethodBeat.o(260995);
                return aVar;
            default:
                View inflate2 = View.inflate(viewGroup.getContext(), R.layout.cfj, null);
                p.g(inflate2, "itemView");
                c cVar = new c(this, inflate2);
                AppMethodBeat.o(260995);
                return cVar;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(260996);
        int size = this.ppH.size();
        AppMethodBeat.o(260996);
        return size;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemViewType(int i2) {
        AppMethodBeat.i(260997);
        int i3 = this.ppH.get(i2).LFy;
        AppMethodBeat.o(260997);
        return i3;
    }

    public final void a(int i2, LinkedList<aus> linkedList, boolean z) {
        AppMethodBeat.i(260998);
        Log.i("FinderLiveVisitorRoleAdapter", "updateAliasInfoList,ori size:" + this.ppH.size() + ",new size:" + (linkedList != null ? Integer.valueOf(linkedList.size()) : null) + ",curroleType:" + this.UPl + ",roleType:" + i2 + ",enableCreate:" + z);
        this.UPl = i2;
        this.UPm = z;
        if (linkedList != null) {
            this.ppH.clear();
            this.ppH.addAll(linkedList);
            if (!hTO()) {
                LinkedList<aus> linkedList2 = this.ppH;
                aus aus = new aus();
                aus.LFy = 10001;
                linkedList2.add(aus);
            }
            AppMethodBeat.o(260998);
            return;
        }
        AppMethodBeat.o(260998);
    }

    private final boolean hTO() {
        AppMethodBeat.i(260999);
        Iterator<T> it = this.ppH.iterator();
        while (it.hasNext()) {
            if (it.next().LFy == 2) {
                AppMethodBeat.o(260999);
                return true;
            }
        }
        AppMethodBeat.o(260999);
        return false;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveVisitorRoleAdapter$BottomViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveVisitorRoleAdapter;Landroid/view/View;)V", "createArrowIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getCreateArrowIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setCreateArrowIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "createIv", "getCreateIv", "setCreateIv", "createTv", "Landroid/widget/TextView;", "getCreateTv", "()Landroid/widget/TextView;", "setCreateTv", "(Landroid/widget/TextView;)V", "plugin-finder_release"})
    public final class a extends RecyclerView.v {
        WeImageView UPo;
        TextView UPp;
        WeImageView UPq;
        final /* synthetic */ t UPr;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(t tVar, View view) {
            super(view);
            p.h(view, "itemView");
            this.UPr = tVar;
            AppMethodBeat.i(260988);
            View findViewById = view.findViewById(R.id.k39);
            p.g(findViewById, "itemView.findViewById(R.id.visitor_create_iv)");
            this.UPo = (WeImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.k3_);
            p.g(findViewById2, "itemView.findViewById(R.id.visitor_create_tv)");
            this.UPp = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.k38);
            p.g(findViewById3, "itemView.findViewById(R.….visitor_create_arrow_iv)");
            this.UPq = (WeImageView) findViewById3;
            AppMethodBeat.o(260988);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveVisitorRoleAdapter$VisitorModeViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveVisitorRoleAdapter;Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "getAvatar", "()Landroid/widget/ImageView;", "setAvatar", "(Landroid/widget/ImageView;)V", "chooser", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getChooser", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setChooser", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "mode", "Landroid/widget/TextView;", "getMode", "()Landroid/widget/TextView;", "setMode", "(Landroid/widget/TextView;)V", "nickname", "getNickname", "setNickname", "plugin-finder_release"})
    public final class c extends RecyclerView.v {
        final /* synthetic */ t UPr;
        TextView UPs;
        WeImageView UPt;
        ImageView keC;
        TextView uuB;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(t tVar, View view) {
            super(view);
            p.h(view, "itemView");
            this.UPr = tVar;
            AppMethodBeat.i(260989);
            View findViewById = view.findViewById(R.id.k36);
            p.g(findViewById, "itemView.findViewById(R.id.visitor_avatar_iv)");
            this.keC = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.k3b);
            p.g(findViewById2, "itemView.findViewById(R.id.visitor_nick_name_tv)");
            this.uuB = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.k3a);
            p.g(findViewById3, "itemView.findViewById(R.id.visitor_mode_tips_tv)");
            this.UPs = (TextView) findViewById3;
            View findViewById4 = view.findViewById(R.id.k37);
            p.g(findViewById4, "itemView.findViewById(R.id.visitor_choose_iv)");
            this.UPt = (WeImageView) findViewById4;
            AppMethodBeat.o(260989);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final void a(RecyclerView.v vVar, int i2) {
        boolean z;
        AppMethodBeat.i(261000);
        p.h(vVar, "holder");
        if (vVar instanceof c) {
            c cVar = (c) vVar;
            aus awO = awO(i2);
            if (awO != null) {
                com.tencent.mm.plugin.finder.loader.m mVar = com.tencent.mm.plugin.finder.loader.m.uJa;
                com.tencent.mm.loader.d<o> dkb = com.tencent.mm.plugin.finder.loader.m.dkb();
                com.tencent.mm.plugin.finder.loader.a aVar = new com.tencent.mm.plugin.finder.loader.a(awO.qFV);
                ImageView imageView = cVar.keC;
                com.tencent.mm.plugin.finder.loader.m mVar2 = com.tencent.mm.plugin.finder.loader.m.uJa;
                dkb.a(aVar, imageView, com.tencent.mm.plugin.finder.loader.m.a(m.a.WX_AVATAR));
                cVar.uuB.setText(awO.nickname);
                com.tencent.mm.plugin.finder.utils.m mVar3 = com.tencent.mm.plugin.finder.utils.m.vVH;
                String awV = com.tencent.mm.plugin.finder.utils.m.awV(awO.LFy);
                String str = awV;
                if (str == null || str.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    cVar.UPs.setVisibility(8);
                } else {
                    cVar.UPs.setVisibility(0);
                    cVar.UPs.setText(awV);
                }
                if (awO.LFy == this.UPl) {
                    cVar.UPt.setVisibility(0);
                } else {
                    cVar.UPt.setVisibility(4);
                }
                View view = cVar.aus;
                p.g(view, "holder.itemView");
                view.setTag(awO);
            }
            cVar.aus.setOnClickListener(new e(this, cVar));
            cVar.aus.setOnLongClickListener(new f(this));
            AppMethodBeat.o(261000);
            return;
        }
        if (vVar instanceof a) {
            a aVar2 = (a) vVar;
            if (this.UPm) {
                WeImageView weImageView = aVar2.UPo;
                Context context = MMApplicationContext.getContext();
                p.g(context, "MMApplicationContext.getContext()");
                weImageView.setIconColor(context.getResources().getColor(R.color.BW_0_Alpha_0_9));
                TextView textView = aVar2.UPp;
                Context context2 = MMApplicationContext.getContext();
                p.g(context2, "MMApplicationContext.getContext()");
                textView.setTextColor(context2.getResources().getColor(R.color.BW_0_Alpha_0_9));
                aVar2.UPq.setVisibility(0);
            } else {
                WeImageView weImageView2 = aVar2.UPo;
                Context context3 = MMApplicationContext.getContext();
                p.g(context3, "MMApplicationContext.getContext()");
                weImageView2.setIconColor(context3.getResources().getColor(R.color.BW_0_Alpha_0_5));
                TextView textView2 = aVar2.UPp;
                Context context4 = MMApplicationContext.getContext();
                p.g(context4, "MMApplicationContext.getContext()");
                textView2.setTextColor(context4.getResources().getColor(R.color.BW_0_Alpha_0_5));
                aVar2.UPq.setVisibility(4);
            }
            aVar2.aus.setOnClickListener(new d(this, i2, aVar2));
        }
        AppMethodBeat.o(261000);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e implements View.OnClickListener {
        final /* synthetic */ t UPr;
        final /* synthetic */ c UPw;

        e(t tVar, c cVar) {
            this.UPr = tVar;
            this.UPw = cVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(260993);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveVisitorRoleAdapter$bindVisitorModeViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            p.g(view, LocaleUtil.ITALIAN);
            if (view.getTag() instanceof aus) {
                Object tag = view.getTag();
                if (tag == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveAliasInfo");
                    AppMethodBeat.o(260993);
                    throw tVar;
                }
                aus aus = (aus) tag;
                this.UPr.UPl = aus.LFy;
                kotlin.g.a.b<? super aus, x> bVar2 = this.UPr.UPj;
                if (bVar2 != null) {
                    bVar2.invoke(aus);
                }
            } else {
                com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
                View view2 = this.UPw.aus;
                p.g(view2, "holder.itemView");
                Context context = view2.getContext();
                p.g(context, "holder.itemView.context");
                com.tencent.mm.plugin.finder.utils.m.dk(context, "type error!");
                Log.e("FinderLiveVisitorRoleAdapter", "bindVisitorModeViewHolder it.tag:" + view.getTag());
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveVisitorRoleAdapter$bindVisitorModeViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(260993);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    static final class f implements View.OnLongClickListener {
        final /* synthetic */ t UPr;

        f(t tVar) {
            this.UPr = tVar;
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.i(260994);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveVisitorRoleAdapter$bindVisitorModeViewHolder$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            p.g(view, LocaleUtil.ITALIAN);
            if (view.getTag() instanceof aus) {
                Object tag = view.getTag();
                if (tag == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveAliasInfo");
                    AppMethodBeat.o(260994);
                    throw tVar;
                }
                aus aus = (aus) tag;
                kotlin.g.a.m<? super aus, ? super View, x> mVar = this.UPr.UPk;
                if (mVar != null) {
                    mVar.invoke(aus, view);
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveVisitorRoleAdapter$bindVisitorModeViewHolder$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(260994);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class d implements View.OnClickListener {
        final /* synthetic */ t UPr;
        final /* synthetic */ a UPu;
        final /* synthetic */ int gUj;

        d(t tVar, int i2, a aVar) {
            this.UPr = tVar;
            this.gUj = i2;
            this.UPu = aVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(260992);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveVisitorRoleAdapter$bindBottomViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (this.UPr.UPm) {
                aus a2 = t.a(this.UPr, this.gUj);
                kotlin.g.a.b<? super aus, x> bVar2 = this.UPr.UPj;
                if (bVar2 != null) {
                    if (a2 == null) {
                        a2 = new aus();
                        a2.LFy = 10001;
                    }
                    bVar2.invoke(a2);
                }
            } else {
                View view2 = this.UPu.aus;
                p.g(view2, "holder.itemView");
                Context context = view2.getContext();
                Context context2 = MMApplicationContext.getContext();
                p.g(context2, "MMApplicationContext.getContext()");
                u.a(context, context2.getResources().getString(R.string.jc_), AnonymousClass1.UPv);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveVisitorRoleAdapter$bindBottomViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(260992);
        }
    }

    private final aus awO(int i2) {
        AppMethodBeat.i(261001);
        int size = this.ppH.size();
        if (i2 >= 0 && size > i2) {
            aus aus = this.ppH.get(i2);
            AppMethodBeat.o(261001);
            return aus;
        }
        AppMethodBeat.o(261001);
        return null;
    }
}
