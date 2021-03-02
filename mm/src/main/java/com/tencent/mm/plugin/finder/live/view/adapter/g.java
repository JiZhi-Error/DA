package com.tencent.mm.plugin.finder.live.view.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.avi;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\n\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\n\u0001\u0001\u0001\u0001\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001c\u0010b\u001a\u0002032\n\u0010c\u001a\u00060dR\u00020\u00002\u0006\u0010e\u001a\u00020\tH\u0002J\u001c\u0010f\u001a\u0002032\n\u0010c\u001a\u00060TR\u00020\u00002\u0006\u0010e\u001a\u00020\tH\u0002J\u001c\u0010g\u001a\u0002032\n\u0010c\u001a\u00060hR\u00020\u00002\u0006\u0010e\u001a\u00020\tH\u0002J\u0018\u0010i\u001a\u0002032\u0006\u0010j\u001a\u00020\t2\u0006\u0010k\u001a\u00020!H\u0002J\b\u0010l\u001a\u00020\tH\u0016J\u0010\u0010m\u001a\u00020\t2\u0006\u0010e\u001a\u00020\tH\u0016J\b\u0010n\u001a\u00020(H\u0002J\u0006\u0010o\u001a\u000203J\u001c\u0010p\u001a\u0002032\n\u0010c\u001a\u00060\u0002R\u00020\u00002\u0006\u0010e\u001a\u00020\tH\u0016J\u001c\u0010q\u001a\u00060\u0002R\u00020\u00002\u0006\u0010r\u001a\u00020s2\u0006\u0010t\u001a\u00020\tH\u0016J\u0010\u0010u\u001a\u0002032\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J.\u0010v\u001a\u0002032\n\u0010c\u001a\u00060TR\u00020\u00002\u0006\u0010e\u001a\u00020\t2\b\u00102\u001a\u0004\u0018\u00010/2\u0006\u0010w\u001a\u00020(H\u0002J.\u0010x\u001a\u0002032\n\u0010c\u001a\u00060TR\u00020\u00002\u0006\u0010e\u001a\u00020\t2\b\u00102\u001a\u0004\u0018\u00010/2\u0006\u0010w\u001a\u00020(H\u0002J5\u0010y\u001a\u0002032\n\u0010c\u001a\u00060TR\u00020\u00002\u0006\u0010e\u001a\u00020\t2\u0006\u0010k\u001a\u00020!2\n\b\u0002\u0010z\u001a\u0004\u0018\u00010(H\u0002¢\u0006\u0002\u0010{JG\u0010|\u001a\u0002032\f\u0010}\u001a\b\u0012\u0004\u0012\u00020/0~2\b\u0010\u001a\u0004\u0018\u00010/2\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020/0~2\u0007\u0010\u0001\u001a\u00020\t2\u0007\u0010\u0001\u001a\u00020\t2\u0006\u0010'\u001a\u00020(R\u001b\u0010\b\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u0010XD¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\r\u001a\u0004\b\u0019\u0010\u000bR\u001a\u0010\u001b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000b\"\u0004\b\u001d\u0010\u001eR*\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020!0 j\b\u0012\u0004\u0012\u00020!`\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020(X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010)\u001a\u00020(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R9\u0010-\u001a!\u0012\u0015\u0012\u0013\u0018\u00010/¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\u0004\u0012\u000203\u0018\u00010.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001a\u00108\u001a\u000209X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001a\u0010>\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u000b\"\u0004\b@\u0010\u001eR\u000e\u0010A\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\"\u0010B\u001a\n\u0012\u0004\u0012\u000203\u0018\u00010CX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u001a\u0010J\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u000b\"\u0004\bL\u0010\u001eR\u001a\u0010M\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bR\u0010OR \u0010S\u001a\b\u0018\u00010TR\u00020\u0000X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001a\u0010Y\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\u000b\"\u0004\b[\u0010\u001eR\u001a\u0010\\\u001a\u00020]X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010_\"\u0004\b`\u0010a¨\u0006\u0001"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$AbsMemberViewHolder;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "stickViewContainer", "Landroid/view/View;", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/View;)V", "GIFT_ICON_SIZE", "", "getGIFT_ICON_SIZE", "()I", "GIFT_ICON_SIZE$delegate", "Lkotlin/Lazy;", "RV_ITEM_START_OFFSET", "TAG", "", "getTAG", "()Ljava/lang/String;", "TYPE_BOTTOM", "TYPE_MEMBER_OFFLINE", "TYPE_MEMBER_ONLINE", "TYPE_TITLE_OFFLINE", "TYPE_TITLE_ONLINE", "UP_ICON_SIZE", "getUP_ICON_SIZE", "UP_ICON_SIZE$delegate", "continueFlag", "getContinueFlag", "setContinueFlag", "(I)V", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$FinderLiveContactInfo;", "Lkotlin/collections/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "setDataList", "(Ljava/util/ArrayList;)V", "enableGift", "", "isBussineVistor", "()Z", "setBussineVistor", "(Z)V", "itemClickListener", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "Lkotlin/ParameterName;", "name", "contact", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "lastVisibleViewPos", "", "getLastVisibleViewPos", "()[I", "setLastVisibleViewPos", "([I)V", "maxMemberCount", "getMaxMemberCount", "setMaxMemberCount", "onlineMembersSize", "rankWidgetClickListener", "Lkotlin/Function0;", "getRankWidgetClickListener", "()Lkotlin/jvm/functions/Function0;", "setRankWidgetClickListener", "(Lkotlin/jvm/functions/Function0;)V", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "selfItemPosition", "getSelfItemPosition", "setSelfItemPosition", "stickView", "getStickView", "()Landroid/view/View;", "setStickView", "(Landroid/view/View;)V", "getStickViewContainer", "stickViewHolder", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$MemberViewHolder;", "getStickViewHolder", "()Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$MemberViewHolder;", "setStickViewHolder", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$MemberViewHolder;)V", "stickViewY", "getStickViewY", "setStickViewY", "totalGiftValue", "", "getTotalGiftValue", "()J", "setTotalGiftValue", "(J)V", "bindBottom", "holder", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$MemberBottomViewHolder;", "position", "bindMember", "bindTitle", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$MemberCategoryViewHolder;", "fillStickView", "selfPosition", "data", "getItemCount", "getItemViewType", "haveAttachStickView", "hideStickContainer", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "type", "onRecyclerViewScrollLogic", "setRankTv", "isSelf", "setReawrdAmount", "setUserItem", "isBindMember", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$MemberViewHolder;ILcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$FinderLiveContactInfo;Ljava/lang/Boolean;)V", "updateMemberList", "onlineMembers", "", "selfContact", "offlineMembers", "onlineMemberCnt", "offlineMemberCnt", "AbsMemberViewHolder", "FinderLiveContactInfo", "MemberBottomViewHolder", "MemberCategoryViewHolder", "MemberViewHolder", "plugin-finder_release"})
public final class g extends RecyclerView.a<a> {
    private final String TAG = "FinderLiveMemberLinearAdapter";
    public long UOH;
    public int UOI;
    public boolean UOJ;
    public int continueFlag;
    public kotlin.g.a.b<? super avn, x> hXE;
    private final RecyclerView hak;
    private ArrayList<b> kgc = new ArrayList<>();
    private final int uAW = 1;
    private final int uAX;
    private final int uAY = 1;
    private final int uAZ = 2;
    private final kotlin.f uAe;
    private final int uBa = 3;
    private final int uBb = 4;
    private boolean uBc = true;
    private int uBd;
    public kotlin.g.a.a<x> uBe;
    private int uBf = Integer.MAX_VALUE;
    private f uBg;
    private View uBh;
    private int uBi;
    private int[] uBj;
    private final kotlin.f uBk;
    private final View usm;

    public g(RecyclerView recyclerView, View view) {
        p.h(recyclerView, "recyclerView");
        p.h(view, "stickViewContainer");
        AppMethodBeat.i(247821);
        this.hak = recyclerView;
        this.usm = view;
        View findViewById = this.usm.findViewById(R.id.cuf);
        p.g(findViewById, "stickViewContainer.findV…r_live_member_stick_view)");
        this.uBh = findViewById;
        this.uBj = new int[2];
        m mVar = m.vVH;
        if (!m.dBP()) {
            int aD = au.az(this.hak.getContext()).y - au.aD(this.hak.getContext());
            ViewGroup.LayoutParams layoutParams = this.uBh.getLayoutParams();
            this.uBi = aD - (layoutParams != null ? layoutParams.height : 0);
            View view2 = this.uBh;
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            view2.setBackgroundColor(context.getResources().getColor(R.color.BW_BG_20));
            this.hak.a(new RecyclerView.l(this) {
                /* class com.tencent.mm.plugin.finder.live.view.adapter.g.AnonymousClass1 */
                final /* synthetic */ g uBl;

                @Override // android.support.v7.widget.RecyclerView.l
                public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                    AppMethodBeat.i(247796);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(recyclerView);
                    bVar.pH(i2);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
                    super.onScrollStateChanged(recyclerView, i2);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
                    AppMethodBeat.o(247796);
                }

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.uBl = r1;
                }

                @Override // android.support.v7.widget.RecyclerView.l
                public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                    AppMethodBeat.i(247795);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(recyclerView);
                    bVar.pH(i2);
                    bVar.pH(i3);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
                    p.h(recyclerView, "recyclerView");
                    super.onScrolled(recyclerView, i2, i3);
                    g.a(this.uBl, recyclerView);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
                    AppMethodBeat.o(247795);
                }
            });
        }
        this.uAe = kotlin.g.ah(c.uBp);
        this.uBk = kotlin.g.ah(C1198g.uBz);
        AppMethodBeat.o(247821);
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ a a(ViewGroup viewGroup, int i2) {
        f fVar;
        AppMethodBeat.i(247812);
        p.h(viewGroup, "parent");
        if (i2 == this.uAX || i2 == this.uAY) {
            View inflate = View.inflate(viewGroup.getContext(), R.layout.ae4, null);
            p.g(inflate, "View.inflate(parent.cont…ear_member_item_ui, null)");
            fVar = new f(this, inflate);
        } else if (i2 == this.uAZ || i2 == this.uBa) {
            View inflate2 = View.inflate(viewGroup.getContext(), R.layout.ae3, null);
            p.g(inflate2, "View.inflate(parent.cont…member_category_ui, null)");
            fVar = new e(this, inflate2);
        } else if (i2 == this.uBb) {
            View inflate3 = View.inflate(viewGroup.getContext(), R.layout.ae2, null);
            p.g(inflate3, "View.inflate(parent.cont…r_member_bottom_ui, null)");
            fVar = new d(this, inflate3);
        } else {
            View inflate4 = View.inflate(viewGroup.getContext(), R.layout.ae4, null);
            p.g(inflate4, "View.inflate(parent.cont…ear_member_item_ui, null)");
            fVar = new f(this, inflate4);
        }
        RecyclerView.v vVar = fVar;
        AppMethodBeat.o(247812);
        return vVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(a aVar, int i2) {
        AppMethodBeat.i(247815);
        a aVar2 = aVar;
        p.h(aVar2, "holder");
        if (aVar2 instanceof f) {
            f fVar = (f) aVar2;
            b bVar = this.kgc.get(i2);
            p.g(bVar, "dataList[position]");
            b bVar2 = bVar;
            a(fVar, i2, bVar2.uBm, bVar2.rIK);
            a(fVar, i2, bVar2, Boolean.TRUE);
            if (this.uBc) {
                a(fVar, bVar2.uBm);
            } else {
                TextView textView = fVar.uBu;
                p.g(textView, "holder.wecoinHot");
                textView.setVisibility(8);
                LinearLayout linearLayout = fVar.uBv;
                p.g(linearLayout, "holder.selfWidget");
                linearLayout.setVisibility(8);
            }
            fVar.aus.setOnClickListener(new h(this, bVar2));
            AppMethodBeat.o(247815);
        } else if (aVar2 instanceof e) {
            e eVar = (e) aVar2;
            b bVar3 = this.kgc.get(i2);
            p.g(bVar3, "dataList[position]");
            if (bVar3.type == this.uAZ) {
                com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
                if (com.tencent.mm.plugin.finder.storage.c.hVh().value().intValue() != 1 || this.UOJ) {
                    m mVar = m.vVH;
                    if (m.dBP()) {
                        TextView textView2 = eVar.hbb;
                        p.g(textView2, "holder.title");
                        TextView textView3 = eVar.hbb;
                        p.g(textView3, "holder.title");
                        Context context = textView3.getContext();
                        p.g(context, "holder.title.context");
                        Resources resources = context.getResources();
                        y yVar = y.vXH;
                        textView2.setText(resources.getString(R.string.cw9, y.LT(this.uBd)));
                    } else {
                        TextView textView4 = eVar.hbb;
                        p.g(textView4, "holder.title");
                        TextView textView5 = eVar.hbb;
                        p.g(textView5, "holder.title");
                        Context context2 = textView5.getContext();
                        p.g(context2, "holder.title.context");
                        textView4.setText(context2.getResources().getString(R.string.jb0));
                    }
                } else {
                    m mVar2 = m.vVH;
                    if (m.dBP()) {
                        TextView textView6 = eVar.hbb;
                        p.g(textView6, "holder.title");
                        TextView textView7 = eVar.hbb;
                        p.g(textView7, "holder.title");
                        Context context3 = textView7.getContext();
                        p.g(context3, "holder.title.context");
                        Resources resources2 = context3.getResources();
                        y yVar2 = y.vXH;
                        textView6.setText(resources2.getString(R.string.cw9, y.LT(this.uBd)));
                    } else {
                        TextView textView8 = eVar.hbb;
                        p.g(textView8, "holder.title");
                        TextView textView9 = eVar.hbb;
                        p.g(textView9, "holder.title");
                        Context context4 = textView9.getContext();
                        p.g(context4, "holder.title.context");
                        textView8.setText(context4.getResources().getString(R.string.jb0));
                    }
                }
            } else if (this.kgc.get(i2).type == this.uBa) {
                TextView textView10 = eVar.hbb;
                p.g(textView10, "holder.title");
                TextView textView11 = eVar.hbb;
                p.g(textView11, "holder.title");
                Context context5 = textView11.getContext();
                p.g(context5, "holder.title.context");
                textView10.setText(context5.getResources().getString(R.string.cw8));
            }
            if (this.uBc) {
                TextView textView12 = eVar.uBr;
                p.g(textView12, "holder.wecoinHotTitle");
                textView12.setVisibility(0);
                com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
                if (com.tencent.mm.plugin.finder.storage.c.hVh().value().intValue() == 1) {
                    TextView textView13 = eVar.uBr;
                    p.g(textView13, "holder.wecoinHotTitle");
                    TextView textView14 = eVar.hbb;
                    p.g(textView14, "holder.title");
                    Context context6 = textView14.getContext();
                    p.g(context6, "holder.title.context");
                    textView13.setText(context6.getResources().getString(R.string.jb1));
                } else {
                    TextView textView15 = eVar.uBr;
                    p.g(textView15, "holder.wecoinHotTitle");
                    TextView textView16 = eVar.hbb;
                    p.g(textView16, "holder.title");
                    Context context7 = textView16.getContext();
                    p.g(context7, "holder.title.context");
                    textView15.setText(context7.getResources().getString(R.string.cwa));
                }
            } else {
                TextView textView17 = eVar.uBr;
                p.g(textView17, "holder.wecoinHotTitle");
                textView17.setVisibility(8);
            }
            m mVar3 = m.vVH;
            if (m.dBP()) {
                com.tencent.mm.plugin.finder.storage.c cVar3 = com.tencent.mm.plugin.finder.storage.c.vCb;
                if (com.tencent.mm.plugin.finder.storage.c.hVh().value().intValue() == 1 && this.UOH > 0) {
                    View view = eVar.UOK;
                    p.g(view, "holder.totalGiftValueLayout");
                    view.setVisibility(0);
                    TextView textView18 = eVar.UOL;
                    p.g(textView18, "holder.totalGiftValueTxtView");
                    y yVar3 = y.vXH;
                    textView18.setText(y.RN(this.UOH));
                    AppMethodBeat.o(247815);
                    return;
                }
            }
            View view2 = eVar.UOK;
            p.g(view2, "holder.totalGiftValueLayout");
            view2.setVisibility(8);
            AppMethodBeat.o(247815);
        } else {
            if (aVar2 instanceof d) {
                d dVar = (d) aVar2;
                View view3 = dVar.aus;
                p.g(view3, "holder.itemView");
                view3.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, -2));
                TextView textView19 = dVar.uBq;
                p.g(textView19, "holder.tip");
                TextView textView20 = dVar.uBq;
                p.g(textView20, "holder.tip");
                Context context8 = textView20.getContext();
                p.g(context8, "holder.tip.context");
                textView19.setText(context8.getResources().getString(R.string.cw6, Integer.valueOf(this.kgc.get(i2).uBo + this.kgc.get(i2).uBn)));
            }
            AppMethodBeat.o(247815);
        }
    }

    public final void diK() {
        AppMethodBeat.i(247811);
        View view = this.usm;
        if (view != null) {
            view.setVisibility(4);
        }
        this.uBh.setTag(Boolean.FALSE);
        AppMethodBeat.o(247811);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0091, code lost:
        if (com.tencent.mm.plugin.finder.utils.m.byb(r0 != null ? r0.username : null) != false) goto L_0x0093;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.util.List<? extends com.tencent.mm.protocal.protobuf.avn> r11, com.tencent.mm.protocal.protobuf.avn r12, java.util.List<? extends com.tencent.mm.protocal.protobuf.avn> r13, int r14, boolean r15) {
        /*
        // Method dump skipped, instructions count: 569
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.view.adapter.g.a(java.util.List, com.tencent.mm.protocal.protobuf.avn, java.util.List, int, boolean):void");
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(247813);
        int size = this.kgc.size();
        AppMethodBeat.o(247813);
        return size;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemViewType(int i2) {
        AppMethodBeat.i(247814);
        int i3 = this.kgc.get(i2).type;
        AppMethodBeat.o(247814);
        return i3;
    }

    private final void a(f fVar, int i2, avn avn, boolean z) {
        boolean z2;
        AppMethodBeat.i(260929);
        avi avi = avn != null ? avn.LDK : null;
        int i3 = avi != null ? avi.LFV : 0;
        int i4 = avi != null ? avi.LFX : 0;
        int i5 = avn != null ? avn.LGi : 0;
        int i6 = this.uAW + this.uBd;
        if (z) {
            String str = this.TAG;
            StringBuilder sb = new StringBuilder("myself setRankTv contact is empty:");
            if (avn == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            Log.i(str, sb.append(z2).append(",position:").append(i2).append(",badgeType:").append(i3).append(",badgeLevel:").append(i4).append(",rewardAmount:").append(i5).append(",validPos:").append(i6).toString());
        } else {
            m mVar = m.vVH;
            m.hd(this.TAG, "setRankTv contact is empty:" + (avn == null) + ",position:" + i2 + ",badgeType:" + i3 + ",badgeLevel:" + i4 + ",rewardAmount:" + i5 + ",validPos:" + i6);
        }
        if (i5 <= 0 || i2 >= i6) {
            TextView textView = fVar.uBs;
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            textView.setTextColor(context.getResources().getColor(R.color.BW_100_Alpha_0_6));
            TextView textView2 = fVar.uBs;
            p.g(textView2, "holder.badgeRank");
            textView2.setText("-");
        } else {
            TextView textView3 = fVar.uBs;
            p.g(textView3, "holder.badgeRank");
            textView3.setText(String.valueOf(i2));
            if (i2 == this.uAW) {
                TextView textView4 = fVar.uBs;
                Context context2 = MMApplicationContext.getContext();
                p.g(context2, "MMApplicationContext.getContext()");
                textView4.setTextColor(context2.getResources().getColor(R.color.pu));
                fVar.uBs.setTextSize(1, 22.0f);
            } else if (i2 == this.uAW + 1) {
                TextView textView5 = fVar.uBs;
                Context context3 = MMApplicationContext.getContext();
                p.g(context3, "MMApplicationContext.getContext()");
                textView5.setTextColor(context3.getResources().getColor(R.color.pw));
                fVar.uBs.setTextSize(1, 22.0f);
            } else if (i2 == this.uAW + 2) {
                TextView textView6 = fVar.uBs;
                Context context4 = MMApplicationContext.getContext();
                p.g(context4, "MMApplicationContext.getContext()");
                textView6.setTextColor(context4.getResources().getColor(R.color.pv));
                fVar.uBs.setTextSize(1, 22.0f);
            } else {
                TextView textView7 = fVar.uBs;
                Context context5 = MMApplicationContext.getContext();
                p.g(context5, "MMApplicationContext.getContext()");
                textView7.setTextColor(context5.getResources().getColor(R.color.BW_100_Alpha_0_6));
                fVar.uBs.setTextSize(1, 15.0f);
            }
            if (!z) {
                Log.i(this.TAG, "setRankTv contact is empty:" + (avn == null) + ",position:" + i2 + ",badgeType:" + i3 + ",badgeLevel:" + i4 + ",rewardAmount:" + i5 + ",validPos:" + i6);
                AppMethodBeat.o(260929);
                return;
            }
        }
        AppMethodBeat.o(260929);
    }

    private static void a(f fVar, avn avn) {
        AppMethodBeat.i(260930);
        int i2 = avn != null ? avn.LGi : 0;
        y yVar = y.vXH;
        String LT = y.LT(i2);
        TextView textView = fVar.uBu;
        p.g(textView, "holder.wecoinHot");
        textView.setVisibility(0);
        TextView textView2 = fVar.uBu;
        p.g(textView2, "holder.wecoinHot");
        textView2.setText(LT);
        LinearLayout linearLayout = fVar.uBv;
        p.g(linearLayout, "holder.selfWidget");
        linearLayout.setVisibility(8);
        AppMethodBeat.o(260930);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class h implements View.OnClickListener {
        final /* synthetic */ b uBA;
        final /* synthetic */ g uBl;

        h(g gVar, b bVar) {
            this.uBl = gVar;
            this.uBA = bVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(247809);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$bindMember$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            kotlin.g.a.b<? super avn, x> bVar2 = this.uBl.hXE;
            if (bVar2 != null) {
                bVar2.invoke(this.uBA.uBm);
            }
            k kVar = k.vkd;
            k.a(s.ak.CLICK_LIST_ITEM_USER);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$bindMember$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(247809);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class i implements View.OnClickListener {
        final /* synthetic */ b uBA;
        final /* synthetic */ g uBl;

        i(g gVar, b bVar) {
            this.uBl = gVar;
            this.uBA = bVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(247810);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$fillStickView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            kotlin.g.a.b<? super avn, x> bVar2 = this.uBl.hXE;
            if (bVar2 != null) {
                bVar2.invoke(this.uBA.uBm);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$fillStickView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(247810);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$AbsMemberViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter;Landroid/view/View;)V", "plugin-finder_release"})
    public class a extends RecyclerView.v {
        final /* synthetic */ g uBl;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(g gVar, View view) {
            super(view);
            p.h(view, "itemView");
            this.uBl = gVar;
            AppMethodBeat.i(247797);
            AppMethodBeat.o(247797);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\"\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\n \b*\u0004\u0018\u00010\u00040\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\fR\"\u0010\u0015\u001a\n \b*\u0004\u0018\u00010\u00160\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\n \b*\u0004\u0018\u00010\u00040\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\"\u0010\u001e\u001a\n \b*\u0004\u0018\u00010\u001f0\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010$\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\n\"\u0004\b&\u0010\fR\"\u0010'\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\n\"\u0004\b)\u0010\f¨\u0006*"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$MemberViewHolder;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$AbsMemberViewHolder;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter;Landroid/view/View;)V", "badgeRank", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getBadgeRank", "()Landroid/widget/TextView;", "setBadgeRank", "(Landroid/widget/TextView;)V", "banComment", "getBanComment", "()Landroid/view/View;", "setBanComment", "(Landroid/view/View;)V", "contributeValue", "getContributeValue", "setContributeValue", "contributeWay", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getContributeWay", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setContributeWay", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "finder", "getFinder", "setFinder", "selfWidget", "Landroid/widget/LinearLayout;", "getSelfWidget", "()Landroid/widget/LinearLayout;", "setSelfWidget", "(Landroid/widget/LinearLayout;)V", "userName", "getUserName", "setUserName", "wecoinHot", "getWecoinHot", "setWecoinHot", "plugin-finder_release"})
    public final class f extends a {
        View UOM;
        TextView oSN;
        final /* synthetic */ g uBl;
        TextView uBs;
        View uBt;
        TextView uBu;
        LinearLayout uBv;
        private TextView uBw = ((TextView) this.uBv.findViewById(R.id.bfn));
        private WeImageView uBx = ((WeImageView) this.uBv.findViewById(R.id.bfm));

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(g gVar, View view) {
            super(gVar, view);
            p.h(view, "itemView");
            this.uBl = gVar;
            AppMethodBeat.i(247806);
            this.uBs = (TextView) view.findViewById(R.id.eic);
            this.oSN = (TextView) view.findViewById(R.id.eih);
            this.uBt = view.findViewById(R.id.co1);
            this.UOM = view.findViewById(R.id.cme);
            this.uBu = (TextView) view.findViewById(R.id.eii);
            this.uBv = (LinearLayout) view.findViewById(R.id.eig);
            this.uBv.setOnClickListener(new View.OnClickListener(this) {
                /* class com.tencent.mm.plugin.finder.live.view.adapter.g.f.AnonymousClass1 */
                final /* synthetic */ f uBy;

                {
                    this.uBy = r1;
                }

                public final void onClick(View view) {
                    AppMethodBeat.i(247805);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$MemberViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    kotlin.g.a.a<x> aVar = this.uBy.uBl.uBe;
                    if (aVar != null) {
                        aVar.invoke();
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$MemberViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(247805);
                }
            });
            AppMethodBeat.o(247806);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\"\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\n \b*\u0004\u0018\u00010\u00040\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\fR\"\u0010\u0015\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\n\"\u0004\b\u0017\u0010\f¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$MemberCategoryViewHolder;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$AbsMemberViewHolder;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter;Landroid/view/View;)V", "title", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getTitle", "()Landroid/widget/TextView;", "setTitle", "(Landroid/widget/TextView;)V", "totalGiftValueLayout", "getTotalGiftValueLayout", "()Landroid/view/View;", "setTotalGiftValueLayout", "(Landroid/view/View;)V", "totalGiftValueTxtView", "getTotalGiftValueTxtView", "setTotalGiftValueTxtView", "wecoinHotTitle", "getWecoinHotTitle", "setWecoinHotTitle", "plugin-finder_release"})
    public final class e extends a {
        View UOK;
        TextView UOL;
        TextView hbb;
        final /* synthetic */ g uBl;
        TextView uBr;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(g gVar, View view) {
            super(gVar, view);
            p.h(view, "itemView");
            this.uBl = gVar;
            AppMethodBeat.i(247804);
            this.hbb = (TextView) view.findViewById(R.id.cfy);
            this.uBr = (TextView) view.findViewById(R.id.cfz);
            this.UOK = view.findViewById(R.id.jvq);
            this.UOL = (TextView) view.findViewById(R.id.jvp);
            AppMethodBeat.o(247804);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\"\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$MemberBottomViewHolder;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$AbsMemberViewHolder;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter;Landroid/view/View;)V", "tip", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getTip", "()Landroid/widget/TextView;", "setTip", "(Landroid/widget/TextView;)V", "plugin-finder_release"})
    public final class d extends a {
        final /* synthetic */ g uBl;
        TextView uBq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(g gVar, View view) {
            super(gVar, view);
            p.h(view, "itemView");
            this.uBl = gVar;
            AppMethodBeat.i(247803);
            this.uBq = (TextView) view.findViewById(R.id.cs_);
            AppMethodBeat.o(247803);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B1\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J=\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter$FinderLiveContactInfo;", "", "contact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "type", "", "onlineCnt", "offlineCnt", "isMySelf", "", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;IIIZ)V", "getContact", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "()Z", "setMySelf", "(Z)V", "getOfflineCnt", "()I", "getOnlineCnt", "getType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "plugin-finder_release"})
    public static final class b {
        boolean rIK;
        final int type;
        final avn uBm;
        final int uBn;
        final int uBo;

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x002e, code lost:
            if (r3.rIK == r4.rIK) goto L_0x0030;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 247800(0x3c7f8, float:3.47242E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x0030
                boolean r0 = r4 instanceof com.tencent.mm.plugin.finder.live.view.adapter.g.b
                if (r0 == 0) goto L_0x0035
                com.tencent.mm.plugin.finder.live.view.adapter.g$b r4 = (com.tencent.mm.plugin.finder.live.view.adapter.g.b) r4
                com.tencent.mm.protocal.protobuf.avn r0 = r3.uBm
                com.tencent.mm.protocal.protobuf.avn r1 = r4.uBm
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0035
                int r0 = r3.type
                int r1 = r4.type
                if (r0 != r1) goto L_0x0035
                int r0 = r3.uBn
                int r1 = r4.uBn
                if (r0 != r1) goto L_0x0035
                int r0 = r3.uBo
                int r1 = r4.uBo
                if (r0 != r1) goto L_0x0035
                boolean r0 = r3.rIK
                boolean r1 = r4.rIK
                if (r0 != r1) goto L_0x0035
            L_0x0030:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x0034:
                return r0
            L_0x0035:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x0034
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.view.adapter.g.b.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            AppMethodBeat.i(247799);
            avn avn = this.uBm;
            int hashCode = (((((((avn != null ? avn.hashCode() : 0) * 31) + this.type) * 31) + this.uBn) * 31) + this.uBo) * 31;
            boolean z = this.rIK;
            if (z) {
                z = true;
            }
            int i2 = z ? 1 : 0;
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = i2 + hashCode;
            AppMethodBeat.o(247799);
            return i5;
        }

        public final String toString() {
            AppMethodBeat.i(247798);
            String str = "FinderLiveContactInfo(contact=" + this.uBm + ", type=" + this.type + ", onlineCnt=" + this.uBn + ", offlineCnt=" + this.uBo + ", isMySelf=" + this.rIK + ")";
            AppMethodBeat.o(247798);
            return str;
        }

        private b(avn avn, int i2, int i3) {
            this.uBm = avn;
            this.type = i2;
            this.uBn = i3;
            this.uBo = 0;
            this.rIK = false;
        }

        public /* synthetic */ b(avn avn, int i2, int i3, byte b2) {
            this(avn, i2, i3);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<Integer> {
        public static final c uBp = new c();

        static {
            AppMethodBeat.i(247802);
            AppMethodBeat.o(247802);
        }

        c() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(247801);
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            Integer valueOf = Integer.valueOf(context.getResources().getDimensionPixelSize(R.dimen.cb));
            AppMethodBeat.o(247801);
            return valueOf;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.finder.live.view.adapter.g$g  reason: collision with other inner class name */
    static final class C1198g extends q implements kotlin.g.a.a<Integer> {
        public static final C1198g uBz = new C1198g();

        static {
            AppMethodBeat.i(247808);
            AppMethodBeat.o(247808);
        }

        C1198g() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(247807);
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            Integer valueOf = Integer.valueOf(context.getResources().getDimensionPixelSize(R.dimen.ce));
            AppMethodBeat.o(247807);
            return valueOf;
        }
    }

    private final void a(f fVar, int i2, b bVar, Boolean bool) {
        String str;
        int i3;
        FinderContact finderContact;
        int i4 = 0;
        AppMethodBeat.i(260931);
        TextView textView = fVar.oSN;
        p.g(textView, "holder.userName");
        Context context = MMApplicationContext.getContext();
        avn avn = bVar.uBm;
        if (avn == null || (finderContact = avn.contact) == null) {
            str = null;
        } else {
            str = finderContact.nickname;
        }
        TextView textView2 = fVar.oSN;
        p.g(textView2, "holder.userName");
        textView.setText(com.tencent.mm.pluginsdk.ui.span.l.b(context, str, textView2.getTextSize()));
        if (bVar.type == this.uAX) {
            if (p.j(bool, Boolean.TRUE)) {
                if (i2 < 3) {
                    TextView textView3 = fVar.oSN;
                    TextView textView4 = fVar.oSN;
                    p.g(textView4, "holder.userName");
                    Context context2 = textView4.getContext();
                    p.g(context2, "holder.userName.context");
                    textView3.setTextColor(context2.getResources().getColor(R.color.BW_100_Alpha_0_9));
                } else {
                    TextView textView5 = fVar.oSN;
                    TextView textView6 = fVar.oSN;
                    p.g(textView6, "holder.userName");
                    Context context3 = textView6.getContext();
                    p.g(context3, "holder.userName.context");
                    textView5.setTextColor(context3.getResources().getColor(R.color.BW_100_Alpha_0_6));
                }
            }
            TextView textView7 = fVar.uBu;
            TextView textView8 = fVar.uBu;
            p.g(textView8, "holder.wecoinHot");
            Context context4 = textView8.getContext();
            p.g(context4, "holder.wecoinHot.context");
            textView7.setTextColor(context4.getResources().getColor(R.color.BW_100_Alpha_0_9));
        } else {
            TextView textView9 = fVar.oSN;
            TextView textView10 = fVar.oSN;
            p.g(textView10, "holder.userName");
            Context context5 = textView10.getContext();
            p.g(context5, "holder.userName.context");
            textView9.setTextColor(context5.getResources().getColor(R.color.BW_100_Alpha_0_3));
            TextView textView11 = fVar.uBu;
            TextView textView12 = fVar.uBu;
            p.g(textView12, "holder.wecoinHot");
            Context context6 = textView12.getContext();
            p.g(context6, "holder.wecoinHot.context");
            textView11.setTextColor(context6.getResources().getColor(R.color.BW_100_Alpha_0_3));
        }
        View view = fVar.uBt;
        p.g(view, "holder.banComment");
        avn avn2 = bVar.uBm;
        if (avn2 == null || avn2.hFI != 0) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        view.setVisibility(i3);
        View view2 = fVar.UOM;
        p.g(view2, "holder.finder");
        avn avn3 = bVar.uBm;
        if (avn3 == null || avn3.Viq != 3) {
            i4 = 8;
        }
        view2.setVisibility(i4);
        AppMethodBeat.o(260931);
    }

    public static final /* synthetic */ void a(g gVar, RecyclerView recyclerView) {
        boolean z;
        AppMethodBeat.i(247822);
        if (gVar.uBf <= 0 || gVar.uBf >= Integer.MAX_VALUE) {
            AppMethodBeat.o(247822);
            return;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager == null) {
            t tVar = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
            AppMethodBeat.o(247822);
            throw tVar;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        if (linearLayoutManager != null) {
            int ku = linearLayoutManager.ku();
            View findViewByPosition = linearLayoutManager.findViewByPosition(ku);
            Object tag = gVar.uBh.getTag();
            if (!(tag instanceof Boolean)) {
                tag = null;
            }
            boolean j2 = p.j((Boolean) tag, Boolean.TRUE);
            m mVar = m.vVH;
            m.hd(gVar.TAG, "onScrolled lastVisiblePos:" + ku + ",selfItemPosition:" + gVar.uBf + ",haveAttachStickView:" + j2);
            if (ku < gVar.uBf && j2) {
                gVar.usm.setVisibility(0);
                AppMethodBeat.o(247822);
                return;
            } else if (ku > gVar.uBf) {
                gVar.usm.setVisibility(4);
                AppMethodBeat.o(247822);
                return;
            } else {
                gVar.uBj[1] = 0;
                if (findViewByPosition != null) {
                    findViewByPosition.getLocationOnScreen(gVar.uBj);
                }
                m mVar2 = m.vVH;
                String str = gVar.TAG;
                StringBuilder sb = new StringBuilder("onScrolled lastVisibleView is empty:");
                if (findViewByPosition == null) {
                    z = true;
                } else {
                    z = false;
                }
                m.hd(str, sb.append(z).append(",lastVisibleViewY:").append(gVar.uBj[1]).append(",stickViewY:").append(gVar.uBi).toString());
                if (gVar.uBj[1] < gVar.uBi || !j2) {
                    gVar.usm.setVisibility(8);
                } else {
                    gVar.usm.setVisibility(0);
                    AppMethodBeat.o(247822);
                    return;
                }
            }
        }
        AppMethodBeat.o(247822);
    }
}
