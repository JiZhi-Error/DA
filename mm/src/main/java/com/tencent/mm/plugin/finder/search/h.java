package com.tencent.mm.plugin.finder.search;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.protocal.protobuf.bbw;
import com.tencent.mm.protocal.protobuf.bbx;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.HashMap;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0003\u001e\u001f B#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bB-\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\u000bB7\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u0015\u001a\u00020\u0007J\u0006\u0010\u0016\u001a\u00020\nJ\u0006\u0010\u0017\u001a\u00020\u0007J\u0010\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u001a\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\u001b\u001a\u00020\u0007J\b\u0010\u001c\u001a\u00020\u0007H\u0016J\u0006\u0010\u001d\u001a\u00020\u0007R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00060\u0012R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic;", "Lcom/tencent/mm/plugin/finder/search/OnHistoryUpdateListener;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMActivity;", "onHistoryClickListener", "Lkotlin/Function1;", "", "", "(Lcom/tencent/mm/ui/MMActivity;Lkotlin/jvm/functions/Function1;)V", "isFullEnjoy", "", "(Lcom/tencent/mm/ui/MMActivity;ZLkotlin/jvm/functions/Function1;)V", "onHistoryClearListener", "Lcom/tencent/mm/plugin/finder/search/OnHistoryClearListener;", "(Lcom/tencent/mm/ui/MMActivity;ZLkotlin/jvm/functions/Function1;Lcom/tencent/mm/plugin/finder/search/OnHistoryClearListener;)V", "footer", "Landroid/view/View;", "historyAdapter", "Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$HistoryAdapter;", "historyLV", "Landroid/widget/ListView;", "dismissHistoryLV", "isShowing", "onDestroy", "onTextChange", SearchIntents.EXTRA_QUERY, "onTextSearch", "showHistoryLV", "update", "updateHistoryFooter", "HistoryAdapter", "HistoryDataManager", "HistoryItemHolder", "plugin-finder_release"})
public final class h implements k {
    View qdl;
    private ListView vvb;
    private a vvc;
    private j vvd;
    boolean vve;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public h(MMActivity mMActivity, kotlin.g.a.b<? super String, x> bVar) {
        this(mMActivity, false, bVar, null);
        p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        p.h(bVar, "onHistoryClickListener");
        AppMethodBeat.i(166864);
        AppMethodBeat.o(166864);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public h(MMActivity mMActivity, boolean z, kotlin.g.a.b<? super String, x> bVar) {
        this(mMActivity, z, bVar, null);
        p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        p.h(bVar, "onHistoryClickListener");
        AppMethodBeat.i(251368);
        AppMethodBeat.o(251368);
    }

    public h(final MMActivity mMActivity, boolean z, final kotlin.g.a.b<? super String, x> bVar, final j jVar) {
        p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        p.h(bVar, "onHistoryClickListener");
        AppMethodBeat.i(251369);
        View findViewById = mMActivity.findViewById(R.id.dpq);
        p.g(findViewById, "activity.findViewById(R.id.history_lv)");
        this.vvb = (ListView) findViewById;
        this.vve = z;
        View inflate = LayoutInflater.from(mMActivity).inflate(z ? R.layout.ac1 : R.layout.aje, (ViewGroup) this.vvb, false);
        p.g(inflate, "LayoutInflater.from(acti…footer, historyLV, false)");
        this.qdl = inflate;
        dpV();
        this.vvb.addFooterView(this.qdl);
        this.vvc = new a();
        this.vvb.setAdapter((ListAdapter) this.vvc);
        this.qdl.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.search.h.AnonymousClass1 */
            final /* synthetic */ h vvf;

            {
                this.vvf = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(166844);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.vvf.qdl.setVisibility(8);
                b bVar2 = b.vvl;
                b.vvj.oTA.clear();
                b.dpY();
                b.dpX();
                j jVar = jVar;
                if (jVar != null) {
                    jVar.cwc();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(166844);
            }
        });
        this.vvb.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.finder.search.h.AnonymousClass2 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(166845);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                kotlin.g.a.b bVar2 = bVar;
                b bVar3 = b.vvl;
                String str = b.dpW().oTA.get(i2).query;
                if (str == null) {
                    str = "";
                }
                bVar2.invoke(str);
                b bVar4 = b.vvl;
                String str2 = b.dpW().oTA.get(i2).query;
                if (str2 == null) {
                    str2 = "";
                }
                b.auX(str2);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(166845);
            }
        });
        this.vvb.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.finder.search.h.AnonymousClass3 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(166846);
                mMActivity.hideVKB();
                AppMethodBeat.o(166846);
                return false;
            }
        });
        b bVar2 = b.vvl;
        b.a(this);
        AppMethodBeat.o(251369);
    }

    public final void dpT() {
        AppMethodBeat.i(251365);
        this.vvb.setVisibility(0);
        AppMethodBeat.o(251365);
    }

    public final void dpU() {
        AppMethodBeat.i(251366);
        this.vvb.setVisibility(8);
        AppMethodBeat.o(251366);
    }

    public final boolean isShowing() {
        AppMethodBeat.i(251367);
        if (this.vvb.getVisibility() == 0) {
            AppMethodBeat.o(251367);
            return true;
        }
        AppMethodBeat.o(251367);
        return false;
    }

    public final void onDestroy() {
        AppMethodBeat.i(166859);
        b bVar = b.vvl;
        b.b(this);
        AppMethodBeat.o(166859);
    }

    public final void auW(String str) {
        AppMethodBeat.i(166860);
        if (!Util.isNullOrNil(str)) {
            this.vvb.setVisibility(8);
            AppMethodBeat.o(166860);
            return;
        }
        this.vvb.setVisibility(0);
        AppMethodBeat.o(166860);
    }

    @Override // com.tencent.mm.plugin.finder.search.k
    public final void update() {
        AppMethodBeat.i(166861);
        this.vvc.notifyDataSetChanged();
        AppMethodBeat.o(166861);
    }

    public final void auX(String str) {
        AppMethodBeat.i(166862);
        if (str != null) {
            b bVar = b.vvl;
            b.auX(str);
            this.qdl.setVisibility(0);
            AppMethodBeat.o(166862);
            return;
        }
        AppMethodBeat.o(166862);
    }

    public final void dpV() {
        AppMethodBeat.i(166863);
        b bVar = b.vvl;
        if (b.dpW().oTA.isEmpty()) {
            this.qdl.setVisibility(8);
            j jVar = this.vvd;
            if (jVar != null) {
                jVar.cwc();
                AppMethodBeat.o(166863);
                return;
            }
            AppMethodBeat.o(166863);
            return;
        }
        this.qdl.setVisibility(0);
        AppMethodBeat.o(166863);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J$\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$HistoryAdapter;", "Landroid/widget/BaseAdapter;", "(Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic;)V", "getCount", "", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "plugin-finder_release"})
    public final class a extends BaseAdapter {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a() {
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            c cVar;
            AppMethodBeat.i(166848);
            if (view == null) {
                if (viewGroup == null) {
                    p.hyc();
                }
                view = LayoutInflater.from(viewGroup.getContext()).inflate(h.this.vve ? R.layout.ac2 : R.layout.ajf, viewGroup, false);
                cVar = new c();
                View findViewById = view.findViewById(R.id.bfe);
                p.g(findViewById, "contentView.findViewById(R.id.content_tv)");
                TextView textView = (TextView) findViewById;
                p.h(textView, "<set-?>");
                cVar.gBb = textView;
                View findViewById2 = view.findViewById(R.id.b4h);
                p.g(findViewById2, "contentView.findViewById(R.id.close_iv)");
                ImageView imageView = (ImageView) findViewById2;
                p.h(imageView, "<set-?>");
                cVar.vvn = imageView;
                p.g(view, "contentView");
                view.setTag(cVar);
            } else {
                Object tag = view.getTag();
                if (tag == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.search.FinderSearchHistoryLogic.HistoryItemHolder");
                    AppMethodBeat.o(166848);
                    throw tVar;
                }
                cVar = (c) tag;
            }
            b bVar = b.vvl;
            String str = b.dpW().oTA.get(i2).query;
            TextView textView2 = cVar.gBb;
            if (textView2 == null) {
                p.btv("contentTV");
            }
            textView2.setText(str);
            ImageView imageView2 = cVar.vvn;
            if (imageView2 == null) {
                p.btv("closeIV");
            }
            imageView2.setOnClickListener(new View$OnClickListenerC1273a(this, i2));
            AppMethodBeat.o(166848);
            return view;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        /* renamed from: com.tencent.mm.plugin.finder.search.h$a$a  reason: collision with other inner class name */
        static final class View$OnClickListenerC1273a implements View.OnClickListener {
            final /* synthetic */ int gUj;
            final /* synthetic */ a vvi;

            View$OnClickListenerC1273a(a aVar, int i2) {
                this.vvi = aVar;
                this.gUj = i2;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(166847);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$HistoryAdapter$getView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                b bVar2 = b.vvl;
                b.vvj.oTA.remove(this.gUj);
                b.dpY();
                b.dpX();
                h.this.dpV();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$HistoryAdapter$getView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(166847);
            }
        }

        public final Object getItem(int i2) {
            AppMethodBeat.i(166849);
            b bVar = b.vvl;
            bbx bbx = b.dpW().oTA.get(i2);
            p.g(bbx, "HistoryDataManager.searchHistory.List[position]");
            AppMethodBeat.o(166849);
            return bbx;
        }

        public final long getItemId(int i2) {
            return 0;
        }

        public final int getCount() {
            AppMethodBeat.i(166850);
            b bVar = b.vvl;
            int size = b.dpW().oTA.size();
            AppMethodBeat.o(166850);
            return size;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$HistoryItemHolder;", "", "(Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic;)V", "closeIV", "Landroid/widget/ImageView;", "getCloseIV", "()Landroid/widget/ImageView;", "setCloseIV", "(Landroid/widget/ImageView;)V", "contentTV", "Landroid/widget/TextView;", "getContentTV", "()Landroid/widget/TextView;", "setContentTV", "(Landroid/widget/TextView;)V", "plugin-finder_release"})
    public final class c {
        public TextView gBb;
        public ImageView vvn;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public c() {
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\bJ\b\u0010\u0013\u001a\u00020\u0011H\u0002J\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0004J\b\u0010\u0016\u001a\u00020\u0011H\u0002J\u0006\u0010\u0017\u001a\u00020\u0011J\u000e\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\bJ\u000e\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0007J\b\u0010\u001b\u001a\u00020\u0011H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R*\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic$HistoryDataManager;", "", "()V", "TAG", "", "listenerMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/search/OnHistoryUpdateListener;", "Lkotlin/collections/HashMap;", "searchHistory", "Lcom/tencent/mm/protocal/protobuf/FinderSearchHistory;", "getSearchHistory", "()Lcom/tencent/mm/protocal/protobuf/FinderSearchHistory;", "setSearchHistory", "(Lcom/tencent/mm/protocal/protobuf/FinderSearchHistory;)V", "addListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "notifyUpdate", "onTextSearch", SearchIntents.EXTRA_QUERY, "readFromFile", "removeAll", "removeListener", "removeQueryAtPosition", "position", "saveToFile", "plugin-finder_release"})
    public static final class b {
        static bbw vvj = new bbw();
        private static HashMap<Integer, k> vvk = new HashMap<>();
        public static final b vvl = new b();

        static {
            AppMethodBeat.i(166858);
            StringBuilder sb = new StringBuilder();
            al alVar = al.waC;
            try {
                vvj.parseFrom(s.aW(sb.append(al.dEF()).append("search-history.info").toString(), 0, -1));
                AppMethodBeat.o(166858);
            } catch (Exception e2) {
                Log.printErrStackTrace("Finder.FinderSearchHistoryLogic", e2, "", new Object[0]);
                AppMethodBeat.o(166858);
            }
        }

        private b() {
        }

        public static bbw dpW() {
            return vvj;
        }

        public static void a(k kVar) {
            AppMethodBeat.i(166853);
            p.h(kVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            vvk.put(Integer.valueOf(kVar.hashCode()), kVar);
            AppMethodBeat.o(166853);
        }

        public static void b(k kVar) {
            AppMethodBeat.i(166854);
            p.h(kVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            vvk.remove(Integer.valueOf(kVar.hashCode()));
            AppMethodBeat.o(166854);
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        public static final class a implements Runnable {
            public static final a vvm = new a();

            static {
                AppMethodBeat.i(166852);
                AppMethodBeat.o(166852);
            }

            a() {
            }

            public final void run() {
                AppMethodBeat.i(166851);
                StringBuilder sb = new StringBuilder();
                al alVar = al.waC;
                String sb2 = sb.append(al.dEF()).append("search-history.info").toString();
                o oVar = new o(sb2);
                b bVar = b.vvl;
                byte[] byteArray = b.dpW().toByteArray();
                if (!s.YS(String.valueOf(oVar.heq()))) {
                    s.boN(String.valueOf(oVar.heq()));
                }
                s.C(sb2, byteArray);
                AppMethodBeat.o(166851);
            }
        }

        static void dpX() {
            AppMethodBeat.i(166855);
            com.tencent.f.h.RTc.aX(a.vvm);
            AppMethodBeat.o(166855);
        }

        public static void auX(String str) {
            AppMethodBeat.i(166856);
            p.h(str, SearchIntents.EXTRA_QUERY);
            bbx bbx = new bbx();
            bbx.timestamp = System.currentTimeMillis();
            bbx.query = str;
            int i2 = 0;
            LinkedList<bbx> linkedList = vvj.oTA;
            p.g(linkedList, "searchHistory.List");
            int size = linkedList.size();
            while (true) {
                if (i2 >= size) {
                    break;
                } else if (p.j(vvj.oTA.get(i2).query, str)) {
                    vvj.oTA.remove(i2);
                    break;
                } else {
                    i2++;
                }
            }
            vvj.oTA.addFirst(bbx);
            if (vvj.oTA.size() > 20) {
                vvj.oTA.removeLast();
            }
            dpY();
            dpX();
            AppMethodBeat.o(166856);
        }

        static void dpY() {
            AppMethodBeat.i(166857);
            for (k kVar : vvk.values()) {
                kVar.update();
            }
            AppMethodBeat.o(166857);
        }
    }
}
