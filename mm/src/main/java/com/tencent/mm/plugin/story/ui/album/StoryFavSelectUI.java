package com.tencent.mm.plugin.story.ui.album;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.facebook.share.internal.ShareConstants;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.xb;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.story.d.a;
import com.tencent.mm.plugin.story.e.a;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.i.a;
import com.tencent.mm.plugin.story.ui.StoryBrowseUI;
import com.tencent.mm.plugin.story.ui.album.StoryFavoritePanel;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000o\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\b\u0010\u0011\u001a\u00020\u0012H\u0014J\\\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00052\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0018j\b\u0012\u0004\u0012\u00020\u0005`\u00192\"\u0010\u001a\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001c0\u0018j\b\u0012\u0004\u0012\u00020\u001c`\u00190\u001bH\u0002J\b\u0010\u001d\u001a\u00020\u000eH\u0002J\b\u0010\u001e\u001a\u00020\u000eH\u0002J\b\u0010\u001f\u001a\u00020\u000eH\u0002J\b\u0010 \u001a\u00020\u000eH\u0002J\u0012\u0010!\u001a\u00020\u000e2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u000eH\u0014J\u0010\u0010%\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020'H\u0016J$\u0010(\u001a\u00020\u000e2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020+0*H\u0016J\u0016\u0010-\u001a\u00020\u000e2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*H\u0016J\b\u0010.\u001a\u00020\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000¨\u0006/"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/album/StoryFavSelectUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectView;", "()V", "TAG", "", "checkedFromGalleyListener", "com/tencent/mm/plugin/story/ui/album/StoryFavSelectUI$checkedFromGalleyListener$1", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavSelectUI$checkedFromGalleyListener$1;", "favPanel", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel;", "mPresenter", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectPresenter;", "dealContentView", "", "v", "Landroid/view/View;", "getLayoutId", "", "goDateStoryGallery", "vPosition", "hPosition", ch.COL_USERNAME, "dateList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", ShareConstants.WEB_DIALOG_PARAM_FILTERS, "", "", "initActionBar", "initViews", "justDoIt", "loadDatas", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onIsAll", "isAll", "", "onLoadFpFinish", "datas", "", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "checkedDatas", "onLoadNpFinish", "updateOptionMenu", "plugin-story_release"})
public final class StoryFavSelectUI extends MMActivity implements a.d {
    private StoryFavoritePanel Fzg;
    private a.c Fzk;
    private final a Fzl = new a(this);
    private final String TAG = "MicroMsg.StoryFavSelectUI";

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "storyFavInfo", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavInfo;", "position", "", "invoke"})
    static final class d extends q implements m<StoryFavoritePanel.c, Integer, x> {
        final /* synthetic */ StoryFavSelectUI Fzm;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(StoryFavSelectUI storyFavSelectUI) {
            super(2);
            this.Fzm = storyFavSelectUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(StoryFavoritePanel.c cVar, Integer num) {
            AppMethodBeat.i(119865);
            StoryFavoritePanel.c cVar2 = cVar;
            num.intValue();
            p.h(cVar2, "storyFavInfo");
            ArrayList<StoryFavoritePanel.c> mDatas = StoryFavSelectUI.b(this.Fzm).getMDatas();
            ArrayList arrayList = new ArrayList();
            HashMap hashMap = new HashMap();
            a.C1747a aVar = com.tencent.mm.plugin.story.e.a.Flw;
            String n = a.C1747a.n(Integer.valueOf(cVar2.Fqr.field_createTime));
            for (T t : mDatas) {
                a.C1747a aVar2 = com.tencent.mm.plugin.story.e.a.Flw;
                String n2 = a.C1747a.n(Integer.valueOf(t.Fqr.field_createTime));
                ArrayList arrayList2 = (ArrayList) hashMap.get(n2);
                if (arrayList2 == null) {
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(Long.valueOf(t.Fqr.field_storyID));
                    hashMap.put(n2, arrayList3);
                    arrayList.add(n2);
                } else {
                    arrayList2.add(Long.valueOf(t.Fqr.field_storyID));
                }
            }
            int indexOf = arrayList.indexOf(n);
            ArrayList arrayList4 = (ArrayList) hashMap.get(n);
            int indexOf2 = arrayList4 != null ? arrayList4.indexOf(Long.valueOf(cVar2.Fqr.field_storyID)) : 0;
            StoryFavSelectUI storyFavSelectUI = this.Fzm;
            if (indexOf < 0) {
                indexOf = 0;
            }
            if (indexOf2 < 0) {
                indexOf2 = 0;
            }
            String str = cVar2.Fqr.field_userName;
            if (str == null) {
                str = "";
            }
            StoryFavSelectUI.a(storyFavSelectUI, indexOf, indexOf2, str, arrayList, hashMap);
            x xVar = x.SXb;
            AppMethodBeat.o(119865);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "storyFavInfo", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavInfo;", "position", "", "checked", "", "invoke"})
    static final class e extends q implements kotlin.g.a.q<StoryFavoritePanel.c, Integer, Boolean, x> {
        final /* synthetic */ StoryFavSelectUI Fzm;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(StoryFavSelectUI storyFavSelectUI) {
            super(3);
            this.Fzm = storyFavSelectUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.q
        public final /* synthetic */ x d(StoryFavoritePanel.c cVar, Integer num, Boolean bool) {
            AppMethodBeat.i(119866);
            num.intValue();
            bool.booleanValue();
            p.h(cVar, "storyFavInfo");
            StoryFavSelectUI.c(this.Fzm);
            x xVar = x.SXb;
            AppMethodBeat.o(119866);
            return xVar;
        }
    }

    public StoryFavSelectUI() {
        AppMethodBeat.i(119875);
        AppMethodBeat.o(119875);
    }

    public static final /* synthetic */ StoryFavoritePanel b(StoryFavSelectUI storyFavSelectUI) {
        AppMethodBeat.i(119877);
        StoryFavoritePanel storyFavoritePanel = storyFavSelectUI.Fzg;
        if (storyFavoritePanel == null) {
            p.btv("favPanel");
        }
        AppMethodBeat.o(119877);
        return storyFavoritePanel;
    }

    public static final /* synthetic */ void c(StoryFavSelectUI storyFavSelectUI) {
        AppMethodBeat.i(119879);
        storyFavSelectUI.dzO();
        AppMethodBeat.o(119879);
    }

    public static final /* synthetic */ a.c d(StoryFavSelectUI storyFavSelectUI) {
        AppMethodBeat.i(119880);
        a.c cVar = storyFavSelectUI.Fzk;
        if (cVar == null) {
            p.btv("mPresenter");
        }
        AppMethodBeat.o(119880);
        return cVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/story/ui/album/StoryFavSelectUI$checkedFromGalleyListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/StoryCheckedFavFromGalleryEvent;", "callback", "", "event", "plugin-story_release"})
    public static final class a extends IListener<xb> {
        final /* synthetic */ StoryFavSelectUI Fzm;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(StoryFavSelectUI storyFavSelectUI) {
            this.Fzm = storyFavSelectUI;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x0074  */
        @Override // com.tencent.mm.sdk.event.IListener
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ boolean callback(com.tencent.mm.g.a.xb r15) {
            /*
            // Method dump skipped, instructions count: 166
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.story.ui.album.StoryFavSelectUI.a.callback(com.tencent.mm.sdk.event.IEvent):boolean");
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(119868);
        this.Fzk = new com.tencent.mm.plugin.story.g.l(this);
        a.c cVar = this.Fzk;
        if (cVar == null) {
            p.btv("mPresenter");
        }
        j.b bVar = j.Fmy;
        cVar.onCreate(j.b.fau());
        super.onCreate(bundle);
        EventCenter.instance.addListener(this.Fzl);
        setMMTitle(R.string.hi1);
        addTextOptionMenu(0, getString(R.string.vl), new b(this), null, t.b.GREEN);
        setBackBtn(new c(this));
        AppMethodBeat.o(119868);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(119869);
        super.onDestroy();
        a.c cVar = this.Fzk;
        if (cVar == null) {
            p.btv("mPresenter");
        }
        cVar.fib();
        EventCenter.instance.removeListener(this.Fzl);
        AppMethodBeat.o(119869);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final void dealContentView(View view) {
        AppMethodBeat.i(119870);
        super.dealContentView(view);
        View findViewById = findViewById(R.id.kv);
        p.g(findViewById, "findViewById(R.id.album_story_favorite_panel)");
        this.Fzg = (StoryFavoritePanel) findViewById;
        StoryFavoritePanel storyFavoritePanel = this.Fzg;
        if (storyFavoritePanel == null) {
            p.btv("favPanel");
        }
        StoryFavoritePanel.a aVar = StoryFavoritePanel.FzD;
        storyFavoritePanel.setup(StoryFavoritePanel.frW());
        StoryFavoritePanel storyFavoritePanel2 = this.Fzg;
        if (storyFavoritePanel2 == null) {
            p.btv("favPanel");
        }
        TextView textView = storyFavoritePanel2.Fzq;
        if (textView != null) {
            textView.setVisibility(8);
        }
        StoryFavoritePanel storyFavoritePanel3 = this.Fzg;
        if (storyFavoritePanel3 == null) {
            p.btv("favPanel");
        }
        storyFavoritePanel3.setMOnFavItemClickListener(new d(this));
        StoryFavoritePanel storyFavoritePanel4 = this.Fzg;
        if (storyFavoritePanel4 == null) {
            p.btv("favPanel");
        }
        storyFavoritePanel4.setMOnCheckItemListener(new e(this));
        StoryFavoritePanel storyFavoritePanel5 = this.Fzg;
        if (storyFavoritePanel5 == null) {
            p.btv("favPanel");
        }
        storyFavoritePanel5.a(new f(this));
        a.c cVar = this.Fzk;
        if (cVar == null) {
            p.btv("mPresenter");
        }
        cVar.vL(true);
        a.c cVar2 = this.Fzk;
        if (cVar2 == null) {
            p.btv("mPresenter");
        }
        cVar2.fnx();
        AppMethodBeat.o(119870);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.bz3;
    }

    @Override // com.tencent.mm.plugin.story.d.a.d
    public final void t(List<com.tencent.mm.plugin.story.i.j> list, List<com.tencent.mm.plugin.story.i.j> list2) {
        AppMethodBeat.i(119871);
        p.h(list, "datas");
        p.h(list2, "checkedDatas");
        new StringBuilder("onLoadFpFinish datas.size").append(list.size());
        h.hkS();
        if (list.isEmpty()) {
            StoryFavoritePanel storyFavoritePanel = this.Fzg;
            if (storyFavoritePanel == null) {
                p.btv("favPanel");
            }
            AppCompatActivity context = getContext();
            p.g(context, "context");
            String string = context.getResources().getString(R.string.hgd);
            p.g(string, "context.resources.getStr…album_favorite_empty_tip)");
            storyFavoritePanel.aSC(string);
        } else {
            StoryFavoritePanel storyFavoritePanel2 = this.Fzg;
            if (storyFavoritePanel2 == null) {
                p.btv("favPanel");
            }
            storyFavoritePanel2.v(list, list2);
        }
        dzO();
        AppMethodBeat.o(119871);
    }

    @Override // com.tencent.mm.plugin.story.d.a.d
    public final void hr(List<com.tencent.mm.plugin.story.i.j> list) {
        AppMethodBeat.i(119872);
        p.h(list, "datas");
        new StringBuilder("onLoadNpFinish datas.size").append(list.size());
        h.hkS();
        StoryFavoritePanel storyFavoritePanel = this.Fzg;
        if (storyFavoritePanel == null) {
            p.btv("favPanel");
        }
        storyFavoritePanel.v(list, new ArrayList());
        AppMethodBeat.o(119872);
    }

    @Override // com.tencent.mm.plugin.story.d.a.d
    public final void vK(boolean z) {
        AppMethodBeat.i(119873);
        StoryFavoritePanel storyFavoritePanel = this.Fzg;
        if (storyFavoritePanel == null) {
            p.btv("favPanel");
        }
        storyFavoritePanel.vK(z);
        AppMethodBeat.o(119873);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class b implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ StoryFavSelectUI Fzm;

        b(StoryFavSelectUI storyFavSelectUI) {
            this.Fzm = storyFavSelectUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(119863);
            StoryFavSelectUI.a(this.Fzm);
            this.Fzm.finish();
            AppMethodBeat.o(119863);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class c implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ StoryFavSelectUI Fzm;

        c(StoryFavSelectUI storyFavSelectUI) {
            this.Fzm = storyFavSelectUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(119864);
            this.Fzm.finish();
            AppMethodBeat.o(119864);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/story/ui/album/StoryFavSelectUI$initViews$3", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumScrollListener;", "onLoadMore", "", "plugin-story_release"})
    public static final class f extends e {
        final /* synthetic */ StoryFavSelectUI Fzm;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        f(StoryFavSelectUI storyFavSelectUI) {
            this.Fzm = storyFavSelectUI;
        }

        @Override // com.tencent.mm.plugin.story.ui.album.e
        public final void onLoadMore() {
            AppMethodBeat.i(119867);
            StoryFavSelectUI.d(this.Fzm).fnw();
            AppMethodBeat.o(119867);
        }
    }

    private final void dzO() {
        AppMethodBeat.i(119874);
        StoryFavoritePanel storyFavoritePanel = this.Fzg;
        if (storyFavoritePanel == null) {
            p.btv("favPanel");
        }
        StringBuilder append = new StringBuilder().append(getString(R.string.vl)).append('(').append(storyFavoritePanel.getMCheckedDatas().size()).append('/');
        a.c cVar = a.c.FvH;
        updateOptionMenuText(0, append.append(a.c.frl()).append(')').toString());
        enableOptionMenu(0, true);
        AppMethodBeat.o(119874);
    }

    public static final /* synthetic */ void a(StoryFavSelectUI storyFavSelectUI) {
        AppMethodBeat.i(119876);
        a.c cVar = storyFavSelectUI.Fzk;
        if (cVar == null) {
            p.btv("mPresenter");
        }
        StoryFavoritePanel storyFavoritePanel = storyFavSelectUI.Fzg;
        if (storyFavoritePanel == null) {
            p.btv("favPanel");
        }
        cVar.hq(storyFavoritePanel.getMCheckedDatas());
        AppMethodBeat.o(119876);
    }

    public static final /* synthetic */ void a(StoryFavSelectUI storyFavSelectUI, int i2, int i3, String str, ArrayList arrayList, Map map) {
        AppMethodBeat.i(119878);
        ArrayList<Long> arrayList2 = new ArrayList<>();
        StoryFavoritePanel storyFavoritePanel = storyFavSelectUI.Fzg;
        if (storyFavoritePanel == null) {
            p.btv("favPanel");
        }
        Iterator<T> it = storyFavoritePanel.getMCheckedDatas().iterator();
        while (it.hasNext()) {
            arrayList2.add(Long.valueOf(((com.tencent.mm.plugin.story.i.j) it.next()).field_storyID));
        }
        Intent intent = new Intent(storyFavSelectUI, StoryBrowseUI.class);
        com.tencent.mm.plugin.story.g.d dVar = com.tencent.mm.plugin.story.g.d.FrG;
        intent.putExtra("data_seed_key", com.tencent.mm.plugin.story.api.p.FkJ.a(arrayList, str, map, arrayList2, com.tencent.mm.plugin.story.g.d.fpE()));
        intent.putExtra(ch.COL_USERNAME, str);
        intent.putExtra("v_position", i2);
        intent.putExtra("h_position", i3);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(storyFavSelectUI, bl.axQ(), "com/tencent/mm/plugin/story/ui/album/StoryFavSelectUI", "goDateStoryGallery", "(IILjava/lang/String;Ljava/util/ArrayList;Ljava/util/Map;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        storyFavSelectUI.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(storyFavSelectUI, "com/tencent/mm/plugin/story/ui/album/StoryFavSelectUI", "goDateStoryGallery", "(IILjava/lang/String;Ljava/util/ArrayList;Ljava/util/Map;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(119878);
    }
}
