package com.tencent.mm.plugin.finder.live.view.adapter;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.protocal.protobuf.avh;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 ,2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004+,-.B\u0005¢\u0006\u0002\u0010\u0003J\u001c\u0010\u001a\u001a\u00020\u00112\n\u0010\u001b\u001a\u00060\u001cR\u00020\u00002\u0006\u0010\u001d\u001a\u00020\rH\u0002J\b\u0010\u001e\u001a\u00020\rH\u0016J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u00062\u0006\u0010 \u001a\u00020\rH\u0002J\u0010\u0010!\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\rH\u0016J\u0018\u0010\"\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\rH\u0016J\u0018\u0010#\u001a\u00020\u00022\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0010\u001a\u00020\rH\u0016J\u0014\u0010&\u001a\u00020\u00112\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0014\u0010(\u001a\u00020\u00112\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00170\u0005J\b\u0010)\u001a\u00020*H\u0002R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR7\u0010\u000b\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\n¨\u0006/"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "()V", "dataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter$FinderLiveWhiteListGroupData;", "getDataList", "()Ljava/util/LinkedList;", "setDataList", "(Ljava/util/LinkedList;)V", "onItemClikListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "type", "", "getOnItemClikListener", "()Lkotlin/jvm/functions/Function1;", "setOnItemClikListener", "(Lkotlin/jvm/functions/Function1;)V", "webWhiteList", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAudienceListFile;", "getWebWhiteList", "setWebWhiteList", "bindWhiteListViewHolder", "holder", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter$WhiteListViewHolder;", "position", "getItemCount", "getItemData", "pos", "getItemViewType", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "updateDataList", "list", "updateWhiteList", "whiteListCanChoose", "", "ChatRoomInfo", "Companion", "FinderLiveWhiteListGroupData", "WhiteListViewHolder", "plugin-finder_release"})
public final class FinderLiveWhiteListGroupAdapter extends RecyclerView.a<RecyclerView.v> {
    public static final a UPy = new a((byte) 0);
    public kotlin.g.a.b<? super Integer, x> UPj;
    public LinkedList<avh> UPx = new LinkedList<>();
    private LinkedList<b> ppH = new LinkedList<>();

    static {
        AppMethodBeat.i(261025);
        AppMethodBeat.o(261025);
    }

    public FinderLiveWhiteListGroupAdapter() {
        AppMethodBeat.i(261024);
        AppMethodBeat.o(261024);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter$Companion;", "", "()V", "TAG", "", "WHITE_LIST_GROUP_TYPE_ROOM", "", "WHITE_LIST_GROUP_TYPE_WEB", "WHITE_LIST_TYPE_USER", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final RecyclerView.v a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(261019);
        p.h(viewGroup, "parent");
        View inflate = View.inflate(viewGroup.getContext(), R.layout.cfl, null);
        p.g(inflate, "View.inflate(parent.cont…list_group_item_ui, null)");
        c cVar = new c(this, inflate);
        AppMethodBeat.o(261019);
        return cVar;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(261020);
        int size = this.ppH.size();
        AppMethodBeat.o(261020);
        return size;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemViewType(int i2) {
        AppMethodBeat.i(261021);
        int i3 = this.ppH.get(i2).type;
        AppMethodBeat.o(261021);
        return i3;
    }

    public final void bT(LinkedList<b> linkedList) {
        AppMethodBeat.i(261022);
        p.h(linkedList, "list");
        Log.i("Finder.FinderLiveWhiteListGroupAdapter", "updateWhiteList,ori size:" + this.ppH.size() + ",new size:" + linkedList.size());
        this.ppH.clear();
        this.ppH.addAll(linkedList);
        AppMethodBeat.o(261022);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\"\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00030\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\t\"\u0004\b\u0013\u0010\u000bR\"\u0010\u0014\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\t\"\u0004\b\u0016\u0010\u000b¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter$WhiteListViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter;Landroid/view/View;)V", "desc", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getDesc", "()Landroid/widget/TextView;", "setDesc", "(Landroid/widget/TextView;)V", "selectedGroup", "getSelectedGroup", "()Landroid/view/View;", "setSelectedGroup", "(Landroid/view/View;)V", "selectedTv", "getSelectedTv", "setSelectedTv", "title", "getTitle", "setTitle", "plugin-finder_release"})
    public final class c extends RecyclerView.v {
        TextView UPA;
        View UPB;
        final /* synthetic */ FinderLiveWhiteListGroupAdapter UPC;
        TextView hbb;
        TextView jCB;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(FinderLiveWhiteListGroupAdapter finderLiveWhiteListGroupAdapter, View view) {
            super(view);
            p.h(view, "itemView");
            this.UPC = finderLiveWhiteListGroupAdapter;
            AppMethodBeat.i(261015);
            this.hbb = (TextView) view.findViewById(R.id.jz9);
            this.jCB = (TextView) view.findViewById(R.id.jz5);
            this.UPA = (TextView) view.findViewById(R.id.jz8);
            this.UPB = view.findViewById(R.id.jz6);
            AppMethodBeat.o(261015);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final void a(RecyclerView.v vVar, int i2) {
        boolean z;
        boolean z2;
        boolean z3 = true;
        AppMethodBeat.i(261023);
        p.h(vVar, "holder");
        if (vVar instanceof c) {
            c cVar = (c) vVar;
            b bVar = (i2 >= 0 && this.ppH.size() > i2) ? this.ppH.get(i2) : null;
            Integer valueOf = bVar != null ? Integer.valueOf(bVar.type) : null;
            if (valueOf != null && valueOf.intValue() == 0) {
                TextView textView = cVar.hbb;
                TextView textView2 = cVar.hbb;
                p.g(textView2, "holder.title");
                Context context = textView2.getContext();
                p.g(context, "holder.title.context");
                textView.setTextColor(context.getResources().getColor(R.color.x0));
                TextView textView3 = cVar.hbb;
                p.g(textView3, "holder.title");
                TextView textView4 = cVar.hbb;
                p.g(textView4, "holder.title");
                Context context2 = textView4.getContext();
                p.g(context2, "holder.title.context");
                textView3.setText(context2.getResources().getString(R.string.jcq));
                TextView textView5 = cVar.jCB;
                p.g(textView5, "holder.desc");
                textView5.setVisibility(8);
                String str = bVar.UPz;
                if (!(str == null || str.length() == 0)) {
                    z3 = false;
                }
                if (z3) {
                    View view = cVar.UPB;
                    p.g(view, "holder.selectedGroup");
                    view.setVisibility(8);
                } else {
                    View view2 = cVar.UPB;
                    p.g(view2, "holder.selectedGroup");
                    view2.setVisibility(0);
                    TextView textView6 = cVar.UPA;
                    p.g(textView6, "holder.selectedTv");
                    textView6.setText(bVar.UPz);
                }
                cVar.aus.setOnClickListener(new d(this));
                AppMethodBeat.o(261023);
                return;
            } else if (valueOf != null && valueOf.intValue() == 1) {
                if (this.UPx.size() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    TextView textView7 = cVar.hbb;
                    TextView textView8 = cVar.hbb;
                    p.g(textView8, "holder.title");
                    Context context3 = textView8.getContext();
                    p.g(context3, "holder.title.context");
                    textView7.setTextColor(context3.getResources().getColor(R.color.x0));
                    cVar.aus.setOnClickListener(new e(this));
                } else {
                    TextView textView9 = cVar.hbb;
                    TextView textView10 = cVar.hbb;
                    p.g(textView10, "holder.title");
                    Context context4 = textView10.getContext();
                    p.g(context4, "holder.title.context");
                    textView9.setTextColor(context4.getResources().getColor(R.color.BW_100_Alpha_0_3));
                    cVar.aus.setOnClickListener(null);
                }
                TextView textView11 = cVar.hbb;
                p.g(textView11, "holder.title");
                TextView textView12 = cVar.hbb;
                p.g(textView12, "holder.title");
                Context context5 = textView12.getContext();
                p.g(context5, "holder.title.context");
                textView11.setText(context5.getResources().getString(R.string.jcs));
                TextView textView13 = cVar.jCB;
                TextView textView14 = cVar.hbb;
                p.g(textView14, "holder.title");
                Context context6 = textView14.getContext();
                p.g(context6, "holder.title.context");
                textView13.setTextColor(context6.getResources().getColor(R.color.BW_100_Alpha_0_3));
                TextView textView15 = cVar.jCB;
                p.g(textView15, "holder.desc");
                TextView textView16 = cVar.jCB;
                p.g(textView16, "holder.desc");
                Context context7 = textView16.getContext();
                p.g(context7, "holder.desc.context");
                textView15.setText(context7.getResources().getString(R.string.d01));
                TextView textView17 = cVar.jCB;
                p.g(textView17, "holder.desc");
                textView17.setVisibility(0);
                String str2 = bVar.UPz;
                if (!(str2 == null || str2.length() == 0)) {
                    z3 = false;
                }
                if (z3) {
                    View view3 = cVar.UPB;
                    p.g(view3, "holder.selectedGroup");
                    view3.setVisibility(8);
                    AppMethodBeat.o(261023);
                    return;
                }
                View view4 = cVar.UPB;
                p.g(view4, "holder.selectedGroup");
                view4.setVisibility(0);
                TextView textView18 = cVar.UPA;
                p.g(textView18, "holder.selectedTv");
                textView18.setText(bVar.UPz);
                AppMethodBeat.o(261023);
                return;
            } else if (valueOf == null) {
                AppMethodBeat.o(261023);
                return;
            } else if (valueOf.intValue() == 2) {
                TextView textView19 = cVar.hbb;
                TextView textView20 = cVar.hbb;
                p.g(textView20, "holder.title");
                Context context8 = textView20.getContext();
                p.g(context8, "holder.title.context");
                textView19.setTextColor(context8.getResources().getColor(R.color.x0));
                TextView textView21 = cVar.hbb;
                p.g(textView21, "holder.title");
                TextView textView22 = cVar.hbb;
                p.g(textView22, "holder.title");
                Context context9 = textView22.getContext();
                p.g(context9, "holder.title.context");
                textView21.setText(context9.getResources().getString(R.string.jcr));
                TextView textView23 = cVar.jCB;
                p.g(textView23, "holder.desc");
                textView23.setVisibility(8);
                String str3 = bVar.UPz;
                if (str3 == null || str3.length() == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    View view5 = cVar.UPB;
                    p.g(view5, "holder.selectedGroup");
                    view5.setVisibility(8);
                } else {
                    View view6 = cVar.UPB;
                    p.g(view6, "holder.selectedGroup");
                    view6.setVisibility(0);
                    TextView textView24 = cVar.UPA;
                    p.g(textView24, "holder.selectedTv");
                    textView24.setText(bVar.UPz);
                }
                cVar.aus.setOnClickListener(new f(this));
            }
        }
        AppMethodBeat.o(261023);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class d implements View.OnClickListener {
        final /* synthetic */ FinderLiveWhiteListGroupAdapter UPC;

        d(FinderLiveWhiteListGroupAdapter finderLiveWhiteListGroupAdapter) {
            this.UPC = finderLiveWhiteListGroupAdapter;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(261016);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter$bindWhiteListViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            kotlin.g.a.b<? super Integer, x> bVar2 = this.UPC.UPj;
            if (bVar2 != null) {
                bVar2.invoke(0);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter$bindWhiteListViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(261016);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e implements View.OnClickListener {
        final /* synthetic */ FinderLiveWhiteListGroupAdapter UPC;

        e(FinderLiveWhiteListGroupAdapter finderLiveWhiteListGroupAdapter) {
            this.UPC = finderLiveWhiteListGroupAdapter;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(261017);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter$bindWhiteListViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            kotlin.g.a.b<? super Integer, x> bVar2 = this.UPC.UPj;
            if (bVar2 != null) {
                bVar2.invoke(1);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter$bindWhiteListViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(261017);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class f implements View.OnClickListener {
        final /* synthetic */ FinderLiveWhiteListGroupAdapter UPC;

        f(FinderLiveWhiteListGroupAdapter finderLiveWhiteListGroupAdapter) {
            this.UPC = finderLiveWhiteListGroupAdapter;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(261018);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter$bindWhiteListViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            kotlin.g.a.b<? super Integer, x> bVar2 = this.UPC.UPj;
            if (bVar2 != null) {
                bVar2.invoke(2);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter$bindWhiteListViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(261018);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u000b\u0010\f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0010H\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter$ChatRoomInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", ch.COL_USERNAME, "", "nickname", "(Ljava/lang/String;Ljava/lang/String;)V", "getNickname", "()Ljava/lang/String;", "getUsername", "component1", "component2", "copy", "describeContents", "", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "plugin-finder_release"})
    public static final class ChatRoomInfo implements Parcelable {
        public static final a CREATOR = new a((byte) 0);
        private final String nickname;
        private final String username;

        static {
            AppMethodBeat.i(261008);
            AppMethodBeat.o(261008);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
            if (kotlin.g.b.p.j(r3.nickname, r4.nickname) != false) goto L_0x0022;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 261011(0x3fb93, float:3.65754E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x0022
                boolean r0 = r4 instanceof com.tencent.mm.plugin.finder.live.view.adapter.FinderLiveWhiteListGroupAdapter.ChatRoomInfo
                if (r0 == 0) goto L_0x0027
                com.tencent.mm.plugin.finder.live.view.adapter.FinderLiveWhiteListGroupAdapter$ChatRoomInfo r4 = (com.tencent.mm.plugin.finder.live.view.adapter.FinderLiveWhiteListGroupAdapter.ChatRoomInfo) r4
                java.lang.String r0 = r3.username
                java.lang.String r1 = r4.username
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0027
                java.lang.String r0 = r3.nickname
                java.lang.String r1 = r4.nickname
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0027
            L_0x0022:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x0026:
                return r0
            L_0x0027:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x0026
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.view.adapter.FinderLiveWhiteListGroupAdapter.ChatRoomInfo.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 0;
            AppMethodBeat.i(261010);
            String str = this.username;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.nickname;
            if (str2 != null) {
                i2 = str2.hashCode();
            }
            int i3 = hashCode + i2;
            AppMethodBeat.o(261010);
            return i3;
        }

        public final String toString() {
            AppMethodBeat.i(261009);
            String str = "ChatRoomInfo(username=" + this.username + ", nickname=" + this.nickname + ")";
            AppMethodBeat.o(261009);
            return str;
        }

        private ChatRoomInfo(String str, String str2) {
            this.username = str;
            this.nickname = str2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public ChatRoomInfo(Parcel parcel) {
            this(parcel.readString(), parcel.readString());
            p.h(parcel, "parcel");
            AppMethodBeat.i(261007);
            AppMethodBeat.o(261007);
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(261006);
            p.h(parcel, "parcel");
            parcel.writeString(this.username);
            parcel.writeString(this.nickname);
            AppMethodBeat.o(261006);
        }

        public final int describeContents() {
            return 0;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter$ChatRoomInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter$ChatRoomInfo;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter$ChatRoomInfo;", "plugin-finder_release"})
        public static final class a implements Parcelable.Creator<ChatRoomInfo> {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ ChatRoomInfo createFromParcel(Parcel parcel) {
                AppMethodBeat.i(261005);
                p.h(parcel, "parcel");
                ChatRoomInfo chatRoomInfo = new ChatRoomInfo(parcel);
                AppMethodBeat.o(261005);
                return chatRoomInfo;
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ ChatRoomInfo[] newArray(int i2) {
                return new ChatRoomInfo[i2];
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveWhiteListGroupAdapter$FinderLiveWhiteListGroupData;", "", "type", "", "selectedInfo", "", "(ILjava/lang/String;)V", "getSelectedInfo", "()Ljava/lang/String;", "getType", "()I", "component1", "component2", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "plugin-finder_release"})
    public static final class b {
        final String UPz;
        final int type;

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x001c, code lost:
            if (kotlin.g.b.p.j(r3.UPz, r4.UPz) != false) goto L_0x001e;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 261014(0x3fb96, float:3.65759E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x001e
                boolean r0 = r4 instanceof com.tencent.mm.plugin.finder.live.view.adapter.FinderLiveWhiteListGroupAdapter.b
                if (r0 == 0) goto L_0x0023
                com.tencent.mm.plugin.finder.live.view.adapter.FinderLiveWhiteListGroupAdapter$b r4 = (com.tencent.mm.plugin.finder.live.view.adapter.FinderLiveWhiteListGroupAdapter.b) r4
                int r0 = r3.type
                int r1 = r4.type
                if (r0 != r1) goto L_0x0023
                java.lang.String r0 = r3.UPz
                java.lang.String r1 = r4.UPz
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0023
            L_0x001e:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x0022:
                return r0
            L_0x0023:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x0022
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.view.adapter.FinderLiveWhiteListGroupAdapter.b.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            AppMethodBeat.i(261013);
            int i2 = this.type * 31;
            String str = this.UPz;
            int hashCode = (str != null ? str.hashCode() : 0) + i2;
            AppMethodBeat.o(261013);
            return hashCode;
        }

        public final String toString() {
            AppMethodBeat.i(261012);
            String str = "FinderLiveWhiteListGroupData(type=" + this.type + ", selectedInfo=" + this.UPz + ")";
            AppMethodBeat.o(261012);
            return str;
        }

        public b(int i2, String str) {
            this.type = i2;
            this.UPz = str;
        }
    }
}
