package com.tencent.mm.plugin.finder.live.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.live.core.core.d.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.protocal.protobuf.awh;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001e2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u001e\u001fB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002J\u001c\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u000eH\u0016J*\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u000e2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016J\u001c\u0010\u0018\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000eH\u0016J\u0016\u0010\u001c\u001a\u00020\u00122\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveLotteryWinnerListAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveLotteryWinnerListAdapter$WinnerViewHolder;", "liveData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;)V", "dataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryContact;", "getDataList", "()Ljava/util/LinkedList;", "setDataList", "(Ljava/util/LinkedList;)V", "getItemCount", "", "getWinnderData", "pos", "onBindViewHolder", "", "holder", "position", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "i", "updateWinnerList", "winnerList", "Companion", "WinnerViewHolder", "plugin-finder_release"})
public final class f extends RecyclerView.a<b> {
    public static final a uAU = new a((byte) 0);
    private final g liveData;
    private LinkedList<awh> ppH = new LinkedList<>();

    static {
        AppMethodBeat.i(247794);
        AppMethodBeat.o(247794);
    }

    public f(g gVar) {
        p.h(gVar, "liveData");
        AppMethodBeat.i(247793);
        this.liveData = gVar;
        AppMethodBeat.o(247793);
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ b a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(247786);
        p.h(viewGroup, "parent");
        View inflate = View.inflate(viewGroup.getContext(), R.layout.aen, null);
        p.g(inflate, "itemView");
        b bVar = new b(this, inflate);
        AppMethodBeat.o(247786);
        return bVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* bridge */ /* synthetic */ void a(b bVar, int i2) {
        AppMethodBeat.i(247791);
        a(bVar, i2);
        AppMethodBeat.o(247791);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int, java.util.List] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(b bVar, int i2, List list) {
        AppMethodBeat.i(247789);
        b bVar2 = bVar;
        p.h(bVar2, "holder");
        p.h(list, "payloads");
        Log.i("Finder.LiveLotteryWinnerListAdapter", "onBindViewHolder payload, pos:" + i2 + ",payloads:" + list);
        if (!(list.isEmpty())) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                it.next();
            }
            AppMethodBeat.o(247789);
            return;
        }
        a(bVar2, i2);
        AppMethodBeat.o(247789);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveLotteryWinnerListAdapter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(247787);
        int size = this.ppH.size();
        AppMethodBeat.o(247787);
        return size;
    }

    public final void an(LinkedList<awh> linkedList) {
        AppMethodBeat.i(247788);
        Log.i("Finder.LiveShoppingListAdapter", "updateWinnerList,ori size:" + this.ppH.size() + ",new size:" + (linkedList != null ? Integer.valueOf(linkedList.size()) : null));
        if (linkedList != null) {
            this.ppH.clear();
            LinkedList<awh> linkedList2 = linkedList;
            ArrayList arrayList = new ArrayList(j.a(linkedList2, 10));
            Iterator<T> it = linkedList2.iterator();
            while (it.hasNext()) {
                arrayList.add(Boolean.valueOf(this.ppH.add(it.next())));
            }
            AppMethodBeat.o(247788);
            return;
        }
        AppMethodBeat.o(247788);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\"\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\r0\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveLotteryWinnerListAdapter$WinnerViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveLotteryWinnerListAdapter;Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getAvatar", "()Landroid/widget/ImageView;", "setAvatar", "(Landroid/widget/ImageView;)V", "nickName", "Landroid/widget/TextView;", "getNickName", "()Landroid/widget/TextView;", "setNickName", "(Landroid/widget/TextView;)V", "plugin-finder_release"})
    public final class b extends RecyclerView.v {
        ImageView keC;
        TextView qbF;
        final /* synthetic */ f uAV;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(f fVar, View view) {
            super(view);
            p.h(view, "itemView");
            this.uAV = fVar;
            AppMethodBeat.i(247785);
            this.keC = (ImageView) view.findViewById(R.id.wm);
            this.qbF = (TextView) view.findViewById(R.id.fzc);
            AppMethodBeat.o(247785);
        }
    }

    private void a(b bVar, int i2) {
        String str;
        TextView textView;
        Context context;
        String str2;
        boolean z;
        boolean z2;
        String str3 = null;
        AppMethodBeat.i(247790);
        p.h(bVar, "holder");
        awh Jo = Jo(i2);
        b.a aVar = com.tencent.mm.live.core.core.d.b.hCo;
        if (b.a.aDp()) {
            ImageView imageView = bVar.keC;
            p.g(imageView, "holder.avatar");
            imageView.setVisibility(8);
            String str4 = Jo != null ? Jo.nickname : null;
            if (Jo != null) {
                str3 = Jo.username;
            }
            String str5 = str3;
            if (str5 == null || str5.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z && p.j(str3, z.aTY())) {
                TextView textView2 = bVar.qbF;
                p.g(textView2, "holder.nickName");
                TextView textView3 = bVar.qbF;
                p.g(textView3, "holder.nickName");
                textView2.setText(com.tencent.mm.pluginsdk.ui.span.l.c(textView3.getContext(), str4));
                Log.i("Finder.LiveLotteryWinnerListAdapter", "onBindViewHolder username:" + str3 + "(nickname:" + str4 + ")win the award");
                AppMethodBeat.o(247790);
                return;
            } else if (str4 == null || str4.length() < 2) {
                Log.i("Finder.LiveLotteryWinnerListAdapter", "onBindViewHolder invalid nickName:".concat(String.valueOf(str4)));
                TextView textView4 = bVar.qbF;
                p.g(textView4, "holder.nickName");
                String valueOf = String.valueOf(com.tencent.mm.pluginsdk.ui.span.l.c(textView4.getContext(), str4 + "***"));
                String str6 = str4;
                if (str6 == null || str6.length() == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    valueOf = "***";
                }
                TextView textView5 = bVar.qbF;
                p.g(textView5, "holder.nickName");
                textView5.setText(valueOf);
                AppMethodBeat.o(247790);
                return;
            } else {
                str2 = d.Gb(str4) + "***";
                textView = bVar.qbF;
                p.g(textView, "holder.nickName");
                TextView textView6 = bVar.qbF;
                p.g(textView6, "holder.nickName");
                context = textView6.getContext();
            }
        } else {
            m mVar = m.uJa;
            com.tencent.mm.loader.d<o> dkb = m.dkb();
            if (Jo != null) {
                str = Jo.iAR;
            } else {
                str = null;
            }
            com.tencent.mm.plugin.finder.loader.a aVar2 = new com.tencent.mm.plugin.finder.loader.a(str);
            ImageView imageView2 = bVar.keC;
            p.g(imageView2, "holder.avatar");
            m mVar2 = m.uJa;
            dkb.a(aVar2, imageView2, m.a(m.a.WX_AVATAR));
            textView = bVar.qbF;
            p.g(textView, "holder.nickName");
            TextView textView7 = bVar.qbF;
            p.g(textView7, "holder.nickName");
            context = textView7.getContext();
            if (Jo != null) {
                str2 = Jo.nickname;
            } else {
                str2 = null;
            }
        }
        textView.setText(com.tencent.mm.pluginsdk.ui.span.l.c(context, str2));
        AppMethodBeat.o(247790);
    }

    private final awh Jo(int i2) {
        AppMethodBeat.i(247792);
        int size = this.ppH.size();
        if (i2 >= 0 && size > i2) {
            awh awh = this.ppH.get(i2);
            AppMethodBeat.o(247792);
            return awh;
        }
        AppMethodBeat.o(247792);
        return null;
    }
}
