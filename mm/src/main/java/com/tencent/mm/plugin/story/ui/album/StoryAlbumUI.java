package com.tencent.mm.plugin.story.ui.album;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.d.a;
import com.tencent.mm.plugin.story.i.h;
import com.tencent.mm.plugin.story.ui.StoryBrowseUI;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragment;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 92\u00020\u00012\u00020\u0002:\u00019B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000fH\u0014J\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0014J(\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001b2\u0016\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u001fj\b\u0012\u0004\u0012\u00020\u0014` H\u0002J\b\u0010!\u001a\u00020\u0016H\u0002J\b\u0010\"\u001a\u00020\u0016H\u0002J\u0010\u0010#\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000fH\u0002J\b\u0010$\u001a\u00020\u0016H\u0002J\b\u0010%\u001a\u00020\u0016H\u0002J\"\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\u001b2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010+\u001a\u00020\u0016H\u0016J\u0012\u0010,\u001a\u00020\u00162\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u0010/\u001a\u00020\u0016H\u0016J\b\u00100\u001a\u00020\u0016H\u0016J\u0016\u00101\u001a\u00020\u00162\f\u00102\u001a\b\u0012\u0004\u0012\u00020403H\u0016J\u0016\u00105\u001a\u00020\u00162\f\u00106\u001a\b\u0012\u0004\u0012\u00020703H\u0016J\b\u00108\u001a\u00020\u0019H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumUI;", "Lcom/tencent/mm/ui/MMFragment;", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IView;", "()V", "mPresenter", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IPresenter;", "mRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "mStoryAlbumAdapter", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;", "mStoryBubblePostFailLayout", "Landroid/widget/LinearLayout;", "mStoryBubblePostFailTv", "Landroid/widget/TextView;", "mStoryFavEntrancePanel", "Landroid/view/View;", "mStoryNoDataTv", "mStoryPostFailLayout", "mStoryPostFailTv", "mUsername", "", "dealContentView", "", "v", "enableFavorite", "", "getLayoutId", "", "goDateStoryGallery", "position", "dateList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "goFavAlbum", "initActionBar", "initViews", "loadFromDB", "loadFromRemote", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBubbleFail", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onIsAll", "onLoadFinish", "datas", "", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumInfo;", "onStoryPostFail", "list", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "supportNavigationSwipeBack", "Companion", "plugin-story_release"})
public final class StoryAlbumUI extends MMFragment implements a.f {
    public static final a Fzd = new a((byte) 0);
    private static final String TAG = TAG;
    private LinearLayout FyV;
    private LinearLayout FyW;
    private TextView FyX;
    private TextView FyY;
    private TextView FyZ;
    private View Fza;
    private a Fzb;
    private a.e Fzc;
    private String mRa = "";
    private RecyclerView mRecyclerView;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "storyHistoryInfo", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfo;", "invoke"})
    static final class c extends q implements kotlin.g.a.b<h, x> {
        final /* synthetic */ StoryAlbumUI Fze;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(StoryAlbumUI storyAlbumUI) {
            super(1);
            this.Fze = storyAlbumUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(h hVar) {
            AppMethodBeat.i(119831);
            h hVar2 = hVar;
            p.h(hVar2, "storyHistoryInfo");
            a a2 = StoryAlbumUI.a(this.Fze);
            ArrayList arrayList = new ArrayList();
            int size = a2.mItemList.size();
            for (int i2 = 0; i2 < size; i2++) {
                for (h hVar3 : a2.mItemList.get(i2).FyP) {
                    arrayList.add(hVar3.field_date);
                    Log.d(a.TAG, "getItemDateList add: " + hVar3.field_date);
                }
            }
            int g2 = StoryAlbumUI.a(this.Fze).g(hVar2.Fqr);
            a aVar = StoryAlbumUI.Fzd;
            Log.i(StoryAlbumUI.TAG, "onClickItem position=" + g2 + ", localId=" + ((int) hVar2.Fqr.systemRowid) + ", storyId=" + hVar2.Fqr.field_storyID + ", date=" + hVar2.field_date + ", count=" + hVar2.field_count);
            StoryAlbumUI.a(this.Fze, g2, arrayList);
            x xVar = x.SXb;
            AppMethodBeat.o(119831);
            return xVar;
        }
    }

    public static final /* synthetic */ a a(StoryAlbumUI storyAlbumUI) {
        AppMethodBeat.i(119843);
        a aVar = storyAlbumUI.Fzb;
        if (aVar == null) {
            p.btv("mStoryAlbumAdapter");
        }
        AppMethodBeat.o(119843);
        return aVar;
    }

    public static final /* synthetic */ a.e c(StoryAlbumUI storyAlbumUI) {
        AppMethodBeat.i(119846);
        a.e eVar = storyAlbumUI.Fzc;
        if (eVar == null) {
            p.btv("mPresenter");
        }
        AppMethodBeat.o(119846);
        return eVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumUI$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(119842);
        AppMethodBeat.o(119842);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/story/ui/album/StoryAlbumUI$initViews$3", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumScrollListener;", "onLoadMore", "", "plugin-story_release"})
    public static final class e extends e {
        final /* synthetic */ StoryAlbumUI Fze;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        e(StoryAlbumUI storyAlbumUI) {
            this.Fze = storyAlbumUI;
        }

        @Override // com.tencent.mm.plugin.story.ui.album.e
        public final void onLoadMore() {
            AppMethodBeat.i(119833);
            StoryAlbumUI.c(this.Fze).fnw();
            AppMethodBeat.o(119833);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class f implements View.OnClickListener {
        final /* synthetic */ StoryAlbumUI Fze;

        f(StoryAlbumUI storyAlbumUI) {
            this.Fze = storyAlbumUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(119834);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/album/StoryAlbumUI$initViews$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            StoryAlbumUI.b(this.Fze);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/album/StoryAlbumUI$initViews$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(119834);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class b implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ StoryAlbumUI Fze;

        b(StoryAlbumUI storyAlbumUI) {
            this.Fze = storyAlbumUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(119830);
            FragmentActivity activity = this.Fze.getActivity();
            if (activity != null) {
                activity.finish();
            }
            AppMethodBeat.o(119830);
            return true;
        }
    }

    private final void loadFromDB() {
        AppMethodBeat.i(119835);
        a.e eVar = this.Fzc;
        if (eVar == null) {
            p.btv("mPresenter");
        }
        eVar.fnz();
        AppMethodBeat.o(119835);
    }

    @Override // com.tencent.mm.ui.FragmentActivitySupport, android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(119836);
        super.onCreate(bundle);
        setMMTitle(R.string.gl);
        setBackBtn(new b(this));
        AppMethodBeat.o(119836);
    }

    @Override // com.tencent.mm.ui.MMFragment
    public final void dealContentView(View view) {
        String str;
        Intent intent;
        AppMethodBeat.i(119837);
        p.h(view, "v");
        super.dealContentView(view);
        this.Fzc = new com.tencent.mm.plugin.story.g.a(this);
        FragmentActivity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null || (str = intent.getStringExtra(ch.COL_USERNAME)) == null) {
            str = "";
        }
        this.mRa = str;
        Log.i(TAG, "initViews username=" + this.mRa);
        View findViewById = view.findViewById(R.id.l6);
        p.g(findViewById, "v.findViewById(R.id.album_story_recycler)");
        this.mRecyclerView = (RecyclerView) findViewById;
        View findViewById2 = view.findViewById(R.id.l9);
        p.g(findViewById2, "v.findViewById(R.id.album_story_send_fail_layout)");
        this.FyV = (LinearLayout) findViewById2;
        View findViewById3 = view.findViewById(R.id.j1);
        p.g(findViewById3, "v.findViewById(R.id.album_bubble_send_fail_layout)");
        this.FyW = (LinearLayout) findViewById3;
        View findViewById4 = view.findViewById(R.id.l_);
        p.g(findViewById4, "v.findViewById(R.id.album_story_send_fail_tips)");
        this.FyX = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.j2);
        p.g(findViewById5, "v.findViewById(R.id.album_bubble_send_fail_tips)");
        this.FyY = (TextView) findViewById5;
        View findViewById6 = view.findViewById(R.id.l5);
        p.g(findViewById6, "v.findViewById(R.id.album_story_no_data_tip_tv)");
        this.FyZ = (TextView) findViewById6;
        View findViewById7 = view.findViewById(R.id.l4);
        p.g(findViewById7, "v.findViewById(R.id.album_story_no_data_fav_panel)");
        this.Fza = findViewById7;
        this.Fzb = new a();
        a aVar = this.Fzb;
        if (aVar == null) {
            p.btv("mStoryAlbumAdapter");
        }
        aVar.FyG = new c(this);
        a aVar2 = this.Fzb;
        if (aVar2 == null) {
            p.btv("mStoryAlbumAdapter");
        }
        aVar2.FyH = new d(this);
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            p.btv("mRecyclerView");
        }
        a aVar3 = this.Fzb;
        if (aVar3 == null) {
            p.btv("mStoryAlbumAdapter");
        }
        recyclerView.setAdapter(aVar3);
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 == null) {
            p.btv("mRecyclerView");
        }
        getActivity();
        recyclerView2.setLayoutManager(new LinearLayoutManager());
        RecyclerView recyclerView3 = this.mRecyclerView;
        if (recyclerView3 == null) {
            p.btv("mRecyclerView");
        }
        recyclerView3.a(new e(this));
        View view2 = this.Fza;
        if (view2 == null) {
            p.btv("mStoryFavEntrancePanel");
        }
        view2.setOnClickListener(new f(this));
        a.e eVar = this.Fzc;
        if (eVar == null) {
            p.btv("mPresenter");
        }
        eVar.onCreate(this.mRa);
        loadFromDB();
        a.e eVar2 = this.Fzc;
        if (eVar2 == null) {
            p.btv("mPresenter");
        }
        eVar2.fnx();
        AppMethodBeat.o(119837);
    }

    @Override // android.support.v4.app.Fragment
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(119838);
        super.onActivityResult(i2, i3, intent);
        Log.d(TAG, "onActivityResult requestCode=" + i2 + " resultCode=" + i3);
        if (i2 == 1) {
            loadFromDB();
        }
        AppMethodBeat.o(119838);
    }

    @Override // com.tencent.mm.ui.FragmentActivitySupport, android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
    public final void onDestroy() {
        AppMethodBeat.i(119839);
        super.onDestroy();
        a.e eVar = this.Fzc;
        if (eVar == null) {
            p.btv("mPresenter");
        }
        eVar.fib();
        AppMethodBeat.o(119839);
    }

    @Override // com.tencent.mm.ui.MMFragment
    public final int getLayoutId() {
        return R.layout.bz9;
    }

    @Override // com.tencent.mm.ui.MMFragment
    public final boolean supportNavigationSwipeBack() {
        return false;
    }

    @Override // com.tencent.mm.plugin.story.d.a.f
    public final void hh(List<c> list) {
        boolean fnd;
        AppMethodBeat.i(119840);
        p.h(list, "datas");
        Log.i(TAG, "onLoadFinish datas.size=" + list.size());
        a aVar = this.Fzb;
        if (aVar == null) {
            p.btv("mStoryAlbumAdapter");
        }
        aVar.hy(list);
        if (list.isEmpty()) {
            View view = this.Fza;
            if (view == null) {
                p.btv("mStoryFavEntrancePanel");
            }
            view.setVisibility(0);
            TextView textView = this.FyZ;
            if (textView == null) {
                p.btv("mStoryNoDataTv");
            }
            textView.setVisibility(0);
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null) {
                p.btv("mRecyclerView");
            }
            recyclerView.setVisibility(8);
        } else {
            View view2 = this.Fza;
            if (view2 == null) {
                p.btv("mStoryFavEntrancePanel");
            }
            view2.setVisibility(8);
            TextView textView2 = this.FyZ;
            if (textView2 == null) {
                p.btv("mStoryNoDataTv");
            }
            textView2.setVisibility(8);
            RecyclerView recyclerView2 = this.mRecyclerView;
            if (recyclerView2 == null) {
                p.btv("mRecyclerView");
            }
            recyclerView2.setVisibility(0);
        }
        if (com.tencent.mm.plugin.textstatus.a.p.fvC()) {
            fnd = com.tencent.mm.plugin.story.c.a.a.FkW.hWO();
        } else {
            fnd = com.tencent.mm.plugin.story.c.a.a.FkW.fnd();
        }
        if (!fnd) {
            View view3 = this.Fza;
            if (view3 == null) {
                p.btv("mStoryFavEntrancePanel");
            }
            view3.setVisibility(8);
        }
        AppMethodBeat.o(119840);
    }

    @Override // com.tencent.mm.plugin.story.d.a.f
    public final void fnA() {
        AppMethodBeat.i(119841);
        a aVar = this.Fzb;
        if (aVar == null) {
            p.btv("mStoryAlbumAdapter");
        }
        aVar.qhf = true;
        if (!aVar.mItemList.isEmpty()) {
            aVar.notifyDataSetChanged();
        }
        AppMethodBeat.o(119841);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ StoryAlbumUI Fze;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(StoryAlbumUI storyAlbumUI) {
            super(0);
            this.Fze = storyAlbumUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(119832);
            StoryAlbumUI.b(this.Fze);
            x xVar = x.SXb;
            AppMethodBeat.o(119832);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(StoryAlbumUI storyAlbumUI, int i2, ArrayList arrayList) {
        AppMethodBeat.i(119844);
        Intent intent = new Intent(storyAlbumUI.getActivity(), StoryBrowseUI.class);
        intent.putExtra(ch.COL_USERNAME, storyAlbumUI.mRa);
        intent.putExtra("user_date_list", arrayList);
        intent.putExtra("v_position", i2);
        storyAlbumUI.startActivityForResult(intent, 1);
        com.tencent.mm.plugin.story.h.h hVar = com.tencent.mm.plugin.story.h.h.FuH;
        com.tencent.mm.plugin.story.h.h.fqi().sl(2);
        AppMethodBeat.o(119844);
    }

    public static final /* synthetic */ void b(StoryAlbumUI storyAlbumUI) {
        AppMethodBeat.i(119845);
        Intent intent = new Intent(storyAlbumUI.getActivity(), StoryFavAlbumUI.class);
        com.tencent.mm.kernel.e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        Object obj = aAh.azQ().get(2);
        if (obj == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(119845);
            throw tVar;
        }
        intent.putExtra(ch.COL_USERNAME, (String) obj);
        FragmentActivity activity = storyAlbumUI.getActivity();
        if (activity != null) {
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/story/ui/album/StoryAlbumUI", "goFavAlbum", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            activity.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/story/ui/album/StoryAlbumUI", "goFavAlbum", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(119845);
            return;
        }
        AppMethodBeat.o(119845);
    }
}
