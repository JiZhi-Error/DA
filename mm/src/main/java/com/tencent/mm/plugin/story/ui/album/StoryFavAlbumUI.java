package com.tencent.mm.plugin.story.ui.album;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.d.a;
import com.tencent.mm.plugin.story.e.a;
import com.tencent.mm.plugin.story.g.k;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.plugin.story.i.j;
import com.tencent.mm.plugin.story.ui.StoryBrowseUI;
import com.tencent.mm.plugin.story.ui.album.StoryFavoritePanel;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001'B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0013H\u0014J(\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00132\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u0005j\b\u0012\u0004\u0012\u00020\u000f`\u0007H\u0002J\b\u0010\u0018\u001a\u00020\u0015H\u0002J\b\u0010\u0019\u001a\u00020\u0015H\u0002J\b\u0010\u001a\u001a\u00020\u0015H\u0002J\b\u0010\u001b\u001a\u00020\u0015H\u0002J\u0012\u0010\u001c\u001a\u00020\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0015H\u0014J\u0010\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u000bH\u0016J\u001e\u0010\"\u001a\u00020\u00152\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060$2\u0006\u0010%\u001a\u00020\u000bH\u0016J\b\u0010&\u001a\u00020\u0015H\u0014R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006("}, hxF = {"Lcom/tencent/mm/plugin/story/ui/album/StoryFavAlbumUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumView;", "()V", "curDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "Lkotlin/collections/ArrayList;", "favPanel", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel;", "isSelf", "", "mPresenter", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumPresenter;", "mUsername", "", "tipTv", "Landroid/widget/TextView;", "getLayoutId", "", "goFavGallery", "", "position", "dateList", "goFavSelector", "initActionBar", "initViews", "loadData", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onIsAll", "isAll", "onLoadFavFinish", "datas", "", "isAllEmpty", "onResume", "Companion", "plugin-story_release"})
public final class StoryFavAlbumUI extends MMActivity implements a.b {
    public static final a Fzi = new a((byte) 0);
    private static final String TAG = TAG;
    private ArrayList<j> Fzf = new ArrayList<>();
    private StoryFavoritePanel Fzg;
    private a.AbstractC1746a Fzh;
    private boolean dJM = true;
    private TextView jBS;
    private String mRa = "";

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavInfo;", "invoke"})
    static final class d extends q implements kotlin.g.a.b<StoryFavoritePanel.c, x> {
        final /* synthetic */ StoryFavAlbumUI Fzj;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(StoryFavAlbumUI storyFavAlbumUI) {
            super(1);
            this.Fzj = storyFavAlbumUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(StoryFavoritePanel.c cVar) {
            AppMethodBeat.i(119849);
            p.h(cVar, LocaleUtil.ITALIAN);
            StoryFavAlbumUI.b(this.Fzj);
            x xVar = x.SXb;
            AppMethodBeat.o(119849);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "storyFavInfo", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavInfo;", "position", "", "invoke"})
    static final class e extends q implements m<StoryFavoritePanel.c, Integer, x> {
        final /* synthetic */ StoryFavAlbumUI Fzj;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(StoryFavAlbumUI storyFavAlbumUI) {
            super(2);
            this.Fzj = storyFavAlbumUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(StoryFavoritePanel.c cVar, Integer num) {
            AppMethodBeat.i(119850);
            StoryFavoritePanel.c cVar2 = cVar;
            num.intValue();
            p.h(cVar2, "storyFavInfo");
            ArrayList arrayList = new ArrayList();
            int size = this.Fzj.Fzf.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                if (cVar2.Fqr != null && cVar2.Fqr.field_storyID == ((j) this.Fzj.Fzf.get(i3)).field_storyID) {
                    i2 = i3;
                }
                a.C1747a aVar = com.tencent.mm.plugin.story.e.a.Flw;
                arrayList.add(a.C1747a.n(Integer.valueOf(((j) this.Fzj.Fzf.get(i3)).field_createTime)));
            }
            StoryFavAlbumUI.a(this.Fzj, i2, arrayList);
            x xVar = x.SXb;
            AppMethodBeat.o(119850);
            return xVar;
        }
    }

    public StoryFavAlbumUI() {
        AppMethodBeat.i(119857);
        AppMethodBeat.o(119857);
    }

    public static final /* synthetic */ a.AbstractC1746a d(StoryFavAlbumUI storyFavAlbumUI) {
        AppMethodBeat.i(119861);
        a.AbstractC1746a aVar = storyFavAlbumUI.Fzh;
        if (aVar == null) {
            p.btv("mPresenter");
        }
        AppMethodBeat.o(119861);
        return aVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/album/StoryFavAlbumUI$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(119858);
        AppMethodBeat.o(119858);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.bz0;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        String str;
        String arJ;
        AppMethodBeat.i(119852);
        fixStatusbar(true);
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null || (str = intent.getStringExtra(ch.COL_USERNAME)) == null) {
            str = "";
        }
        this.mRa = str;
        Log.i(TAG, "initViews username=" + this.mRa);
        Object obj = g.aAh().azQ().get(2);
        if (obj == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(119852);
            throw tVar;
        }
        this.dJM = Util.isEqual((String) obj, this.mRa);
        if (this.dJM) {
            setMMTitle(R.string.hge);
        } else {
            com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
            p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
            as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().Kn(this.mRa);
            AppCompatActivity context = getContext();
            String str2 = (Kn == null || (arJ = Kn.arJ()) == null) ? "" : arJ;
            View findViewById = findViewById(16908308);
            p.g(findViewById, "findViewById<TextView>(android.R.id.text1)");
            setMMTitle(((Object) com.tencent.mm.pluginsdk.ui.span.l.b(context, str2, ((TextView) findViewById).getTextSize())) + getString(R.string.hgf));
        }
        setBackBtn(new b(this));
        this.Fzh = new k(this);
        a.AbstractC1746a aVar = this.Fzh;
        if (aVar == null) {
            p.btv("mPresenter");
        }
        aVar.onCreate(this.mRa);
        this.jBS = (TextView) findViewById(R.id.js);
        if (!this.dJM) {
            TextView textView = this.jBS;
            if (textView != null) {
                textView.setVisibility(8);
            }
        } else {
            TextView textView2 = this.jBS;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            TextView textView3 = this.jBS;
            if (textView3 != null) {
                textView3.setText(Html.fromHtml(getResources().getString(R.string.hg9)));
            }
            TextView textView4 = this.jBS;
            if (textView4 != null) {
                textView4.setOnClickListener(new c(this));
            }
        }
        this.Fzg = (StoryFavoritePanel) findViewById(R.id.kv);
        StoryFavoritePanel storyFavoritePanel = this.Fzg;
        if (storyFavoritePanel != null) {
            StoryFavoritePanel.a aVar2 = StoryFavoritePanel.FzD;
            storyFavoritePanel.setup(StoryFavoritePanel.frV());
        }
        StoryFavoritePanel storyFavoritePanel2 = this.Fzg;
        if (storyFavoritePanel2 != null) {
            storyFavoritePanel2.setMOnAddItemClickListener(new d(this));
        }
        StoryFavoritePanel storyFavoritePanel3 = this.Fzg;
        if (storyFavoritePanel3 != null) {
            storyFavoritePanel3.setMOnFavItemClickListener(new e(this));
        }
        StoryFavoritePanel storyFavoritePanel4 = this.Fzg;
        if (storyFavoritePanel4 != null) {
            storyFavoritePanel4.a(new f(this));
        }
        a.AbstractC1746a aVar3 = this.Fzh;
        if (aVar3 == null) {
            p.btv("mPresenter");
        }
        aVar3.fnx();
        a.AbstractC1746a aVar4 = this.Fzh;
        if (aVar4 == null) {
            p.btv("mPresenter");
        }
        aVar4.fny();
        AppMethodBeat.o(119852);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(119853);
        super.onResume();
        a.AbstractC1746a aVar = this.Fzh;
        if (aVar == null) {
            p.btv("mPresenter");
        }
        aVar.fny();
        AppMethodBeat.o(119853);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(119854);
        super.onDestroy();
        a.AbstractC1746a aVar = this.Fzh;
        if (aVar == null) {
            p.btv("mPresenter");
        }
        aVar.fib();
        AppMethodBeat.o(119854);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c implements View.OnClickListener {
        final /* synthetic */ StoryFavAlbumUI Fzj;

        c(StoryFavAlbumUI storyFavAlbumUI) {
            this.Fzj = storyFavAlbumUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(119848);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/album/StoryFavAlbumUI$initViews$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Intent intent = new Intent();
            intent.putExtra("Contact_User", this.Fzj.mRa);
            intent.putExtra("CONTACT_INFO_UI_SOURCE", 12);
            com.tencent.mm.br.c.b(this.Fzj, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/album/StoryFavAlbumUI$initViews$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(119848);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/story/ui/album/StoryFavAlbumUI$initViews$4", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumScrollListener;", "onLoadMore", "", "plugin-story_release"})
    public static final class f extends e {
        final /* synthetic */ StoryFavAlbumUI Fzj;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        f(StoryFavAlbumUI storyFavAlbumUI) {
            this.Fzj = storyFavAlbumUI;
        }

        @Override // com.tencent.mm.plugin.story.ui.album.e
        public final void onLoadMore() {
            AppMethodBeat.i(119851);
            StoryFavAlbumUI.d(this.Fzj).fnw();
            AppMethodBeat.o(119851);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class b implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ StoryFavAlbumUI Fzj;

        b(StoryFavAlbumUI storyFavAlbumUI) {
            this.Fzj = storyFavAlbumUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(119847);
            this.Fzj.finish();
            AppMethodBeat.o(119847);
            return true;
        }
    }

    @Override // com.tencent.mm.plugin.story.d.a.b
    public final void o(List<j> list, boolean z) {
        AppMethodBeat.i(119855);
        p.h(list, "datas");
        if ((!list.isEmpty()) || !z) {
            this.Fzf.clear();
            this.Fzf.addAll(list);
            StoryFavoritePanel storyFavoritePanel = this.Fzg;
            if (storyFavoritePanel != null) {
                boolean z2 = this.dJM;
                p.h(list, "favoriteStory");
                Log.i(storyFavoritePanel.TAG, "updateFavStory " + list.size());
                TextView textView = storyFavoritePanel.Fzr;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                RecyclerView recyclerView = storyFavoritePanel.Fzs;
                if (recyclerView != null) {
                    recyclerView.setVisibility(0);
                }
                storyFavoritePanel.dJM = z2;
                storyFavoritePanel.Fzv.clear();
                if (z2 && storyFavoritePanel.fromScene != StoryFavoritePanel.FzC) {
                    storyFavoritePanel.Fzv.add(new StoryFavoritePanel.c(new j(), storyFavoritePanel.Fzn));
                }
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    storyFavoritePanel.Fzv.add(new StoryFavoritePanel.c(it.next(), storyFavoritePanel.Fzo));
                }
                storyFavoritePanel.Fzv.add(new StoryFavoritePanel.c(new j(), storyFavoritePanel.BPk));
                storyFavoritePanel.Fzt.notifyDataSetChanged();
                AppMethodBeat.o(119855);
                return;
            }
            AppMethodBeat.o(119855);
            return;
        }
        this.Fzf.clear();
        TextView textView2 = this.jBS;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        StoryFavoritePanel storyFavoritePanel2 = this.Fzg;
        if (storyFavoritePanel2 != null) {
            AppCompatActivity context = getContext();
            p.g(context, "context");
            String string = context.getResources().getString(R.string.hgd);
            p.g(string, "context.resources.getStr…album_favorite_empty_tip)");
            storyFavoritePanel2.aSC(string);
            AppMethodBeat.o(119855);
            return;
        }
        AppMethodBeat.o(119855);
    }

    @Override // com.tencent.mm.plugin.story.d.a.b
    public final void vK(boolean z) {
        AppMethodBeat.i(119856);
        StoryFavoritePanel storyFavoritePanel = this.Fzg;
        if (storyFavoritePanel != null) {
            storyFavoritePanel.vK(z);
            AppMethodBeat.o(119856);
            return;
        }
        AppMethodBeat.o(119856);
    }

    public static final /* synthetic */ void b(StoryFavAlbumUI storyFavAlbumUI) {
        AppMethodBeat.i(119859);
        storyFavAlbumUI.startActivityForResult(new Intent(storyFavAlbumUI, StoryFavSelectUI.class), 2);
        AppMethodBeat.o(119859);
    }

    public static final /* synthetic */ void a(StoryFavAlbumUI storyFavAlbumUI, int i2, ArrayList arrayList) {
        AppMethodBeat.i(119860);
        String str = storyFavAlbumUI.mRa;
        com.tencent.mm.plugin.story.g.d dVar = com.tencent.mm.plugin.story.g.d.FrG;
        long a2 = com.tencent.mm.plugin.story.api.p.FkJ.a(arrayList, str, com.tencent.mm.plugin.story.g.d.fpB());
        Intent intent = new Intent(storyFavAlbumUI, StoryBrowseUI.class);
        intent.putExtra("data_seed_key", a2);
        intent.putExtra(ch.COL_USERNAME, storyFavAlbumUI.mRa);
        intent.putExtra("v_position", i2);
        intent.putExtra("gallery_story_need_action", false);
        storyFavAlbumUI.startActivityForResult(intent, 3);
        h hVar = h.FuH;
        h.fqi().sl(15);
        AppMethodBeat.o(119860);
    }
}
