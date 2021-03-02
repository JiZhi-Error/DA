package com.tencent.mm.plugin.story.ui.album;

import android.content.SharedPreferences;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.story.e.a;
import com.tencent.mm.plugin.story.e.b;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.i.a;
import com.tencent.mm.plugin.story.i.h;
import com.tencent.mm.plugin.story.i.j;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\u0018\u0000 ?2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0005?@ABCB\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010+\u001a\u00020\u001aJ\u000e\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\rJ\u0016\u0010.\u001a\u0012\u0012\u0004\u0012\u00020\t0\fj\b\u0012\u0004\u0012\u00020\t`\u000eJ\b\u0010/\u001a\u00020\u0005H\u0016J\u0016\u00100\u001a\u0012\u0012\u0004\u0012\u00020\t0\fj\b\u0012\u0004\u0012\u00020\t`\u000eJ\u0010\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u0005H\u0016J \u00103\u001a\u00020\u00102\u0016\u00104\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eH\u0002J\u001c\u00105\u001a\u00020\u001a2\n\u00106\u001a\u00060\u0002R\u00020\u00002\u0006\u00102\u001a\u00020\u0005H\u0016J\u001c\u00107\u001a\u00060\u0002R\u00020\u00002\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u0005H\u0016J\u0006\u0010;\u001a\u00020\u001aJ\u0014\u0010<\u001a\u00020\u001a2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00170=J\u001e\u0010>\u001a\u00020\u001a2\u0016\u00104\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eR\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00170\fj\b\u0012\u0004\u0012\u00020\u0017`\u000eX\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR7\u0010\u001f\u001a\u001f\u0012\u0013\u0012\u00110!¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u001a\u0018\u00010 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006D"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumViewHolder;", "()V", "ITEM_TYPE_FAVORITE", "", "ITEM_TYPE_LOADING", "ITEM_TYPE_NOMAL", "LABEL_FAVORITE", "", "LABEL_LOAD_MORE", "mFavList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "Lkotlin/collections/ArrayList;", "mIsAll", "", "mIsSelectFavorite", "getMIsSelectFavorite", "()Z", "setMIsSelectFavorite", "(Z)V", "mItemList", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumInfo;", "mOnFavItemClickListener", "Lkotlin/Function0;", "", "getMOnFavItemClickListener", "()Lkotlin/jvm/functions/Function0;", "setMOnFavItemClickListener", "(Lkotlin/jvm/functions/Function0;)V", "mOnGridItemClickListener", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfo;", "Lkotlin/ParameterName;", "name", "info", "getMOnGridItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setMOnGridItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "mRawDataCount", "mThisYear", "calculateStoryCount", "findPositionInGallery", "storyInfo", "getFavItemDateList", "getItemCount", "getItemDateList", "getItemViewType", "position", "hasFavStoryChanged", "datas", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onIsAll", "updateDatas", "", "updateFavStory", "Companion", "StoryAlbumFavHolder", "StoryAlbumLoadingHolder", "StoryAlbumNormalHolder", "StoryAlbumViewHolder", "plugin-story_release"})
public final class a extends RecyclerView.a<e> {
    public static final C1779a FyI = new C1779a((byte) 0);
    static final String TAG = TAG;
    private final int ESY = 1;
    private final int FyA;
    private final int FyB = 2;
    private ArrayList<j> FyC = new ArrayList<>();
    private final int FyD;
    private int FyE;
    boolean FyF;
    kotlin.g.a.b<? super h, x> FyG;
    kotlin.g.a.a<x> FyH;
    private final String Fyy = "loadingMore";
    private final String Fyz = "favorite";
    ArrayList<c> mItemList = new ArrayList<>();
    boolean qhf;

    public a() {
        AppMethodBeat.i(119817);
        a.C1747a aVar = com.tencent.mm.plugin.story.e.a.Flw;
        this.FyD = new GregorianCalendar().get(1);
        AppMethodBeat.o(119817);
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ e a(ViewGroup viewGroup, int i2) {
        RecyclerView.v vVar;
        AppMethodBeat.i(119811);
        p.h(viewGroup, "parent");
        Log.d(TAG, "onCreateViewHolder");
        if (i2 == this.ESY) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bz7, viewGroup, false);
            p.g(inflate, "LayoutInflater.from(pare…ng_layout, parent, false)");
            vVar = (e) new c(this, inflate);
        } else if (i2 == this.FyB) {
            View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bz5, viewGroup, false);
            p.g(inflate2, "LayoutInflater.from(pare…ce_layout, parent, false)");
            vVar = (e) new b(this, inflate2);
        } else {
            View inflate3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bz6, viewGroup, false);
            p.g(inflate3, "LayoutInflater.from(pare…em_layout, parent, false)");
            vVar = (e) new d(this, inflate3);
        }
        if (vVar instanceof d) {
            ((d) vVar).FyN.b(new b());
        }
        RecyclerView.v vVar2 = vVar;
        AppMethodBeat.o(119811);
        return vVar2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(e eVar, int i2) {
        AppMethodBeat.i(119812);
        e eVar2 = eVar;
        p.h(eVar2, "holder");
        Log.d(TAG, "onBindViewHolder ".concat(String.valueOf(i2)));
        eVar2.abc(i2);
        AppMethodBeat.o(119812);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.album.a$a  reason: collision with other inner class name */
    public static final class C1779a {
        private C1779a() {
        }

        public /* synthetic */ C1779a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(119818);
        AppMethodBeat.o(119818);
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemViewType(int i2) {
        AppMethodBeat.i(119813);
        if (Util.isEqual(this.mItemList.get(i2).label, this.Fyy)) {
            int i3 = this.ESY;
            AppMethodBeat.o(119813);
            return i3;
        } else if (Util.isEqual(this.mItemList.get(i2).label, this.Fyz)) {
            int i4 = this.FyB;
            AppMethodBeat.o(119813);
            return i4;
        } else {
            int i5 = this.FyA;
            AppMethodBeat.o(119813);
            return i5;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(119814);
        int size = this.mItemList.size();
        AppMethodBeat.o(119814);
        return size;
    }

    public final void hy(List<c> list) {
        boolean fnd;
        AppMethodBeat.i(119815);
        p.h(list, "datas");
        Log.i(TAG, "updateDatas");
        this.mItemList.clear();
        if (com.tencent.mm.plugin.textstatus.a.p.fvC()) {
            fnd = com.tencent.mm.plugin.story.c.a.a.FkW.hWO();
        } else {
            fnd = com.tencent.mm.plugin.story.c.a.a.FkW.fnd();
        }
        if (fnd && !this.FyF) {
            this.mItemList.add(new c(this.Fyz, null, 2));
            Log.i(TAG, "updateDatas add fav");
        }
        this.mItemList.addAll(list);
        Iterator<T> it = this.mItemList.iterator();
        while (it.hasNext()) {
            this.FyE = it.next().FyP.size() + this.FyE;
        }
        if (!list.isEmpty()) {
            this.mItemList.add(new c(this.Fyy, null, 2));
        }
        notifyDataSetChanged();
        AppMethodBeat.o(119815);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b¦\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;Landroid/view/View;)V", "onBind", "", "position", "", "plugin-story_release"})
    public abstract class e extends RecyclerView.v {
        final /* synthetic */ a FyJ;

        public abstract void abc(int i2);

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(a aVar, View view) {
            super(view);
            p.h(view, "view");
            this.FyJ = aVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001a\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020$H\u0002J\u0010\u0010&\u001a\u00020\"2\u0006\u0010%\u001a\u00020$H\u0002J \u0010'\u001a\u00020\"2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020,H\u0002J\u0010\u0010-\u001a\u00020\"2\u0006\u0010.\u001a\u00020)H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001d¨\u0006/"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumNormalHolder;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumViewHolder;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;Landroid/view/View;)V", "gridAdapter", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter;", "getGridAdapter", "()Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter;", "setGridAdapter", "(Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter;)V", "gridView", "Landroid/support/v7/widget/RecyclerView;", "getGridView", "()Landroid/support/v7/widget/RecyclerView;", "setGridView", "(Landroid/support/v7/widget/RecyclerView;)V", "layoutManager", "Landroid/support/v7/widget/GridLayoutManager;", "getLayoutManager", "()Landroid/support/v7/widget/GridLayoutManager;", "setLayoutManager", "(Landroid/support/v7/widget/GridLayoutManager;)V", "monTv", "Landroid/widget/TextView;", "getMonTv", "()Landroid/widget/TextView;", "setMonTv", "(Landroid/widget/TextView;)V", "yearTv", "getYearTv", "setYearTv", "handleDate", "", "preStoryAlbumInfo", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumInfo;", "storyAlbumInfo", "handleGrid", "handleYearTv", "preHead", "", "head", "yearStr", "", "onBind", "position", "plugin-story_release"})
    public final class d extends e {
        private TextView EIh;
        private TextView EIj;
        final /* synthetic */ a FyJ;
        RecyclerView FyN;
        private d FyO = new d();
        private GridLayoutManager haU;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(a aVar, View view) {
            super(aVar, view);
            p.h(view, "view");
            this.FyJ = aVar;
            AppMethodBeat.i(119810);
            View findViewById = view.findViewById(R.id.l1);
            p.g(findViewById, "view.findViewById(R.id.a…_item_decoration_year_tv)");
            this.EIj = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.l0);
            p.g(findViewById2, "view.findViewById(R.id.a…item_decoration_month_tv)");
            this.EIh = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.ky);
            p.g(findViewById3, "view.findViewById(R.id.a…tem_decoration_grid_view)");
            this.FyN = (RecyclerView) findViewById3;
            view.getContext();
            this.haU = new GridLayoutManager(4);
            AppMethodBeat.o(119810);
        }

        @Override // com.tencent.mm.plugin.story.ui.album.a.e
        public final void abc(int i2) {
            c cVar;
            int i3;
            AppMethodBeat.i(119809);
            Object obj = this.FyJ.mItemList.get(i2);
            p.g(obj, "mItemList[position]");
            c cVar2 = (c) obj;
            if (i2 <= 0 || Util.isEqual(((c) this.FyJ.mItemList.get(i2 - 1)).label, this.FyJ.Fyz)) {
                cVar = null;
            } else {
                cVar = (c) this.FyJ.mItemList.get(i2 - 1);
            }
            if (!this.FyJ.FyF) {
                this.EIh.setVisibility(0);
                String str = cVar2.label;
                if (n.a((CharSequence) str, ":", 0, false, 6) != -1) {
                    List<String> a2 = n.a(str, new String[]{":"});
                    if (a2.size() == 2) {
                        this.EIh.setText(a2.get(1));
                        if (cVar == null || cVar.FyP.isEmpty()) {
                            i3 = 0;
                        } else {
                            i3 = cVar.FyP.get(0).Fqr.Fwp;
                        }
                        int i4 = cVar2.FyP.get(0).Fqr.Fwp;
                        String str2 = a2.get(0);
                        int i5 = i3 / 10000;
                        int i6 = i4 / 10000;
                        if ((i5 != 0 || i6 == this.FyJ.FyD) && (i5 == 0 || i6 == i5)) {
                            this.EIj.setVisibility(8);
                        } else {
                            this.EIj.setVisibility(0);
                            this.EIj.setText(str2);
                        }
                    }
                } else {
                    this.EIh.setText(str);
                    this.EIj.setVisibility(8);
                }
            }
            this.FyN.setLayoutManager(this.haU);
            this.FyN.setAdapter(this.FyO);
            this.FyO.FyG = this.FyJ.FyG;
            d dVar = this.FyO;
            List<h> list = cVar2.FyP;
            p.h(list, "datas");
            dVar.FyQ.clear();
            dVar.FyQ.addAll(list);
            dVar.notifyDataSetChanged();
            AppMethodBeat.o(119809);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumLoadingHolder;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumViewHolder;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;Landroid/view/View;)V", "isAllView", "Landroid/widget/ImageView;", "()Landroid/widget/ImageView;", "setAllView", "(Landroid/widget/ImageView;)V", "loadingView", "Landroid/view/ViewGroup;", "getLoadingView", "()Landroid/view/ViewGroup;", "setLoadingView", "(Landroid/view/ViewGroup;)V", "onBind", "", "position", "", "plugin-story_release"})
    public final class c extends e {
        final /* synthetic */ a FyJ;
        private ViewGroup FyL;
        private ImageView FyM;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(a aVar, View view) {
            super(aVar, view);
            p.h(view, "view");
            this.FyJ = aVar;
            AppMethodBeat.i(119808);
            View findViewById = view.findViewById(R.id.epm);
            p.g(findViewById, "view.findViewById(R.id.loading_more_state)");
            this.FyL = (ViewGroup) findViewById;
            View findViewById2 = view.findViewById(R.id.k9);
            p.g(findViewById2, "view.findViewById(R.id.album_is_all_view)");
            this.FyM = (ImageView) findViewById2;
            AppMethodBeat.o(119808);
        }

        @Override // com.tencent.mm.plugin.story.ui.album.a.e
        public final void abc(int i2) {
            AppMethodBeat.i(119807);
            if (this.FyJ.qhf) {
                this.FyL.setVisibility(8);
                this.FyM.setVisibility(0);
                AppMethodBeat.o(119807);
                return;
            }
            int unused = this.FyJ.FyE;
            j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
            if (j.b.fol().DMv <= 0) {
                b.a aVar = com.tencent.mm.plugin.story.e.b.FlA;
                SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
                String str = com.tencent.mm.plugin.story.e.b.Flz;
                a.C1768a aVar2 = com.tencent.mm.plugin.story.i.a.FvD;
                sharedPreferences.getInt(str, com.tencent.mm.plugin.story.i.a.FuO);
            }
            this.FyL.setVisibility(0);
            this.FyM.setVisibility(8);
            AppMethodBeat.o(119807);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumFavHolder;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumViewHolder;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;Landroid/view/View;)V", "onBind", "", "position", "", "plugin-story_release"})
    public final class b extends e {
        final /* synthetic */ a FyJ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(a aVar, View view) {
            super(aVar, view);
            p.h(view, "view");
            this.FyJ = aVar;
            AppMethodBeat.i(119806);
            AppMethodBeat.o(119806);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        /* renamed from: com.tencent.mm.plugin.story.ui.album.a$b$a  reason: collision with other inner class name */
        static final class View$OnClickListenerC1780a implements View.OnClickListener {
            final /* synthetic */ b FyK;

            View$OnClickListenerC1780a(b bVar) {
                this.FyK = bVar;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(119804);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumFavHolder$onBind$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                kotlin.g.a.a<x> aVar = this.FyK.FyJ.FyH;
                if (aVar != null) {
                    aVar.invoke();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumFavHolder$onBind$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(119804);
            }
        }

        @Override // com.tencent.mm.plugin.story.ui.album.a.e
        public final void abc(int i2) {
            AppMethodBeat.i(119805);
            this.aus.setOnClickListener(new View$OnClickListenerC1780a(this));
            AppMethodBeat.o(119805);
        }
    }

    public final int g(com.tencent.mm.plugin.story.i.j jVar) {
        AppMethodBeat.i(119816);
        p.h(jVar, "storyInfo");
        Log.d(TAG, "storyLocalId=" + ((int) jVar.systemRowid));
        int size = this.mItemList.size();
        int i2 = 0;
        int i3 = 0;
        loop0:
        while (true) {
            if (i2 >= size) {
                AppMethodBeat.o(119816);
                break;
            }
            for (h hVar : this.mItemList.get(i2).FyP) {
                if (((int) hVar.Fqr.systemRowid) == ((int) jVar.systemRowid)) {
                    Log.d(TAG, "findPositionInGallery index=%s", Integer.valueOf(i3));
                    AppMethodBeat.o(119816);
                    break loop0;
                }
                i3++;
            }
            i2++;
        }
        return i3;
    }
}
