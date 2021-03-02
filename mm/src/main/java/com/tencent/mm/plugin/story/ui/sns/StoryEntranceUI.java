package com.tencent.mm.plugin.story.ui.sns;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.api.l;
import com.tencent.mm.plugin.story.api.p;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.plugin.story.ui.StoryBrowseUI;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0003!\"#B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0014J\u0012\u0010\u0019\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0017H\u0014J\u001c\u0010\u001d\u001a\u00020\u00172\b\u0010\u001e\u001a\u0004\u0018\u00010\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0012\u0010\n\u001a\u00060\u000bR\u00020\u0000X.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R2\u0010\u000e\u001a&\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u0010 \u0011*\u0012\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u0010\u0018\u00010\u00120\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R2\u0010\u0014\u001a&\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00150\u0015 \u0011*\u0012\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00150\u0015\u0018\u00010\u00120\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "()V", "TYPE_TIP", "", "getTYPE_TIP", "()I", "TYPE_USERNAME", "getTYPE_USERNAME", "entranceAdapter", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;", "entranceRecycler", "Landroid/support/v7/widget/RecyclerView;", "readNameList", "", "", "kotlin.jvm.PlatformType", "", "storyTypeIndex", "userNameList", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$DataObject;", "finish", "", "getLayoutId", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "Companion", "DataObject", "EntranceAdapter", "plugin-story_release"})
public final class StoryEntranceUI extends MMActivity implements MStorage.IOnStorageChange {
    public static final a FAf = new a((byte) 0);
    private static final String TAG = TAG;
    private RecyclerView FAa;
    private c FAb;
    private int FAc = -1;
    private List<b> FAd = Collections.synchronizedList(new LinkedList());
    private List<String> FAe = Collections.synchronizedList(new LinkedList());
    private final int FzY = 1;
    private final int FzZ = 2;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "position", "", "item", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$DataObject;", "invoke"})
    static final class e extends q implements m<Integer, b, x> {
        final /* synthetic */ StoryEntranceUI FAg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(StoryEntranceUI storyEntranceUI) {
            super(2);
            this.FAg = storyEntranceUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Integer num, b bVar) {
            AppMethodBeat.i(119975);
            int intValue = num.intValue();
            p.h(bVar, "item");
            LinkedList linkedList = new LinkedList();
            int i2 = intValue >= this.FAg.FAc ? intValue - 1 : intValue;
            List list = this.FAg.FAd;
            p.g(list, "userNameList");
            List<b> list2 = list;
            synchronized (list2) {
                try {
                    for (b bVar2 : list2) {
                        if (!(bVar2.type == 1)) {
                            bVar2 = null;
                        }
                        if (bVar2 != null) {
                            linkedList.add(bVar2.userName);
                        }
                    }
                    x xVar = x.SXb;
                } catch (Throwable th) {
                    AppMethodBeat.o(119975);
                    throw th;
                }
            }
            p.b bVar3 = com.tencent.mm.plugin.story.api.p.FkJ;
            LinkedList linkedList2 = linkedList;
            com.tencent.mm.plugin.story.g.d dVar = com.tencent.mm.plugin.story.g.d.FrG;
            long a2 = bVar3.a(linkedList2, (Map<String, ArrayList<Long>>) null, com.tencent.mm.plugin.story.g.d.fpB());
            com.tencent.mm.kernel.b.a ah = g.ah(com.tencent.mm.plugin.story.api.e.class);
            kotlin.g.b.p.g(ah, "MMKernel.plugin(IPluginStory::class.java)");
            l.c contactFetcher = ((com.tencent.mm.plugin.story.api.e) ah).getContactFetcher();
            kotlin.g.b.p.g(contactFetcher, "MMKernel.plugin(IPluginS…lass.java).contactFetcher");
            contactFetcher.fnj();
            Intent intent = new Intent(this.FAg.getContext(), StoryBrowseUI.class);
            intent.putExtra("v_position", i2);
            intent.putExtra("data_seed_key", a2);
            intent.putExtra("gallery_session_id", "");
            AppCompatActivity context = this.FAg.getContext();
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$onCreate$2", "invoke", "(ILcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$DataObject;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$onCreate$2", "invoke", "(ILcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$DataObject;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            x xVar2 = x.SXb;
            AppMethodBeat.o(119975);
            return xVar2;
        }
    }

    public StoryEntranceUI() {
        AppMethodBeat.i(119980);
        AppMethodBeat.o(119980);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(119981);
        AppMethodBeat.o(119981);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$DataObject;", "", "userName", "", "type", "", "(Ljava/lang/String;I)V", "getType", "()I", "getUserName", "()Ljava/lang/String;", "plugin-story_release"})
    public static final class b {
        final int type;
        final String userName;

        public b(String str, int i2) {
            kotlin.g.b.p.h(str, "userName");
            AppMethodBeat.i(119961);
            this.userName = str;
            this.type = i2;
            AppMethodBeat.o(119961);
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(119976);
        Log.i(TAG, "StoryEntranceUI create ".concat(String.valueOf(this)));
        supportRequestWindowFeature(1);
        getWindow().addFlags(1024);
        super.onCreate(bundle);
        j.b bVar = j.Fmy;
        j.b.fod().add(this);
        setMMTitle(R.string.h_z);
        setBackBtn(new d(this), R.raw.actionbar_icon_close_black);
        View findViewById = findViewById(R.id.iaa);
        kotlin.g.b.p.g(findViewById, "findViewById(R.id.story_entrance_recycler)");
        this.FAa = (RecyclerView) findViewById;
        RecyclerView recyclerView = this.FAa;
        if (recyclerView == null) {
            kotlin.g.b.p.btv("entranceRecycler");
        }
        recyclerView.setLayoutManager(new LinearLayoutManager());
        this.FAb = new c();
        RecyclerView recyclerView2 = this.FAa;
        if (recyclerView2 == null) {
            kotlin.g.b.p.btv("entranceRecycler");
        }
        recyclerView2.setItemViewCacheSize(0);
        RecyclerView recyclerView3 = this.FAa;
        if (recyclerView3 == null) {
            kotlin.g.b.p.btv("entranceRecycler");
        }
        c cVar = this.FAb;
        if (cVar == null) {
            kotlin.g.b.p.btv("entranceAdapter");
        }
        recyclerView3.setAdapter(cVar);
        c cVar2 = this.FAb;
        if (cVar2 == null) {
            kotlin.g.b.p.btv("entranceAdapter");
        }
        cVar2.uAj = new e(this);
        List<String> fnj = com.tencent.mm.plugin.story.f.f.a.FpB.fnj();
        List<String> fnk = com.tencent.mm.plugin.story.f.f.a.FpB.fnk();
        Log.i(TAG, "userNames " + fnj.size() + " lastUserNames " + fnk.size());
        List<String> list = fnj;
        synchronized (list) {
            try {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    this.FAd.add(new b(it.next(), 1));
                }
                x xVar = x.SXb;
            } finally {
                AppMethodBeat.o(119976);
            }
        }
        this.FAc = this.FAd.size();
        if (fnk.size() > 0) {
            this.FAd.add(new b("", 2));
        }
        List<String> list2 = fnk;
        synchronized (list2) {
            try {
                Iterator<T> it2 = list2.iterator();
                while (it2.hasNext()) {
                    this.FAd.add(new b(it2.next(), 1));
                }
                x xVar2 = x.SXb;
            } catch (Throwable th) {
                throw th;
            }
        }
        c cVar3 = this.FAb;
        if (cVar3 == null) {
            kotlin.g.b.p.btv("entranceAdapter");
        }
        List<b> list3 = this.FAd;
        kotlin.g.b.p.g(list3, "userNameList");
        kotlin.g.b.p.h(list3, "extinfoList");
        cVar3.hKT.clear();
        cVar3.hKT.addAll(list3);
        cVar3.notifyDataSetChanged();
        AppMethodBeat.o(119976);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class d implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ StoryEntranceUI FAg;

        d(StoryEntranceUI storyEntranceUI) {
            this.FAg = storyEntranceUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(119974);
            this.FAg.finish();
            AppMethodBeat.o(119974);
            return true;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(119977);
        super.onDestroy();
        j.b bVar = j.Fmy;
        j.b.fod().remove(this);
        AppMethodBeat.o(119977);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public final void finish() {
        AppMethodBeat.i(119978);
        Log.i(TAG, "finish " + this.FAe.size());
        if (this.FAd.size() > 0) {
            String str = this.FAd.get(0).userName;
            j.b bVar = j.Fmy;
            f aRS = j.b.fod().aRS(str);
            if (aRS != null) {
                long j2 = aRS.field_updateTime;
                if (j2 == 0) {
                    j2 = ((long) aRS.field_storyPostTime) * 1000;
                }
                Log.i(TAG, "finish updateTime user:" + str + " updateTime: " + j2);
                if (j2 > 0) {
                    com.tencent.mm.kernel.e aAh = g.aAh();
                    kotlin.g.b.p.g(aAh, "MMKernel.storage()");
                    aAh.azQ().set(ar.a.USERINFO_STORY_SNS_UPDATE_TIME_LONG, Long.valueOf(j2));
                }
            }
        }
        super.finish();
        AppMethodBeat.o(119978);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.c04;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\b\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0003\u001f !B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0014\u001a\u00020\u0007H\u0016J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016J \u0010\u0016\u001a\u00020\r2\u000e\u0010\u0017\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\n\u001a\u00020\u0007H\u0016J \u0010\u0018\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0007H\u0016J\u0014\u0010\u001c\u001a\u00020\r2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001eRL\u0010\u0005\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI;)V", "onItemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$DataObject;", "item", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "userList", "Ljava/util/ArrayList;", "getItemCount", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "update", "extinfoList", "", "EntranceViewHolder", "EntranceViewTipHolder", "EntranceViewUserHolder", "plugin-story_release"})
    public final class c extends RecyclerView.a<a> {
        final ArrayList<b> hKT = new ArrayList<>();
        m<? super Integer, ? super b, x> uAj;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public c() {
            AppMethodBeat.i(119973);
            AppMethodBeat.o(119973);
        }

        /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ a a(ViewGroup viewGroup, int i2) {
            b bVar;
            AppMethodBeat.i(119970);
            kotlin.g.b.p.h(viewGroup, "parent");
            if (i2 == 1) {
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.c01, viewGroup, false);
                kotlin.g.b.p.g(inflate, "LayoutInflater.from(pare…ance_item, parent, false)");
                bVar = new C1781c(this, inflate);
            } else {
                View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.c03, viewGroup, false);
                kotlin.g.b.p.g(inflate2, "LayoutInflater.from(pare…rance_tip, parent, false)");
                bVar = new b(this, inflate2);
            }
            RecyclerView.v vVar = bVar;
            AppMethodBeat.o(119970);
            return vVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void a(a aVar, int i2) {
            AppMethodBeat.i(119972);
            a aVar2 = aVar;
            kotlin.g.b.p.h(aVar2, "holder");
            b bVar = this.hKT.get(i2);
            kotlin.g.b.p.g(bVar, "userList[position]");
            aVar2.a(bVar);
            AppMethodBeat.o(119972);
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            AppMethodBeat.i(119969);
            int size = this.hKT.size();
            AppMethodBeat.o(119969);
            return size;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemViewType(int i2) {
            AppMethodBeat.i(119971);
            int i3 = this.hKT.get(i2).type;
            AppMethodBeat.o(119971);
            return i3;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b¦\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;Landroid/view/View;)V", "onBind", "", "position", "", "data", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$DataObject;", "plugin-story_release"})
        public abstract class a extends RecyclerView.v {
            final /* synthetic */ c FAh;

            public abstract void a(b bVar);

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(c cVar, View view) {
                super(view);
                kotlin.g.b.p.h(view, "itemView");
                this.FAh = cVar;
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\n0\u0001R\u00060\u0002R\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewTipHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;Landroid/view/View;)V", "contentTv", "Landroid/widget/TextView;", "getContentTv", "()Landroid/widget/TextView;", "onBind", "", "position", "", "data", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$DataObject;", "plugin-story_release"})
        public final class b extends a {
            final /* synthetic */ c FAh;
            private final TextView hXC;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(c cVar, View view) {
                super(cVar, view);
                kotlin.g.b.p.h(view, "itemView");
                this.FAh = cVar;
                AppMethodBeat.i(119965);
                View findViewById = view.findViewById(R.id.ior);
                kotlin.g.b.p.g(findViewById, "itemView.findViewById(R.id.tip_tv)");
                this.hXC = (TextView) findViewById;
                view.setOnClickListener(AnonymousClass1.FAi);
                AppMethodBeat.o(119965);
            }

            @Override // com.tencent.mm.plugin.story.ui.sns.StoryEntranceUI.c.a
            public final void a(b bVar) {
                AppMethodBeat.i(119964);
                kotlin.g.b.p.h(bVar, "data");
                this.hXC.setText(R.string.ha1);
                AppMethodBeat.o(119964);
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\n0\u0001R\u00060\u0002R\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewUserHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "getAvatar", "()Landroid/widget/ImageView;", "contentTv", "Landroid/widget/TextView;", "getContentTv", "()Landroid/widget/TextView;", "onBind", "", "position", "", "data", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$DataObject;", "plugin-story_release"})
        /* renamed from: com.tencent.mm.plugin.story.ui.sns.StoryEntranceUI$c$c  reason: collision with other inner class name */
        public final class C1781c extends a {
            final /* synthetic */ c FAh;
            private final TextView hXC;
            private final ImageView keC;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C1781c(c cVar, View view) {
                super(cVar, view);
                kotlin.g.b.p.h(view, "itemView");
                this.FAh = cVar;
                AppMethodBeat.i(119968);
                View findViewById = view.findViewById(R.id.x1);
                kotlin.g.b.p.g(findViewById, "itemView.findViewById(R.id.avatar_iv)");
                this.keC = (ImageView) findViewById;
                View findViewById2 = view.findViewById(R.id.j1l);
                kotlin.g.b.p.g(findViewById2, "itemView.findViewById(R.id.user_name_tv)");
                this.hXC = (TextView) findViewById2;
                view.setOnClickListener(new View.OnClickListener(this) {
                    /* class com.tencent.mm.plugin.story.ui.sns.StoryEntranceUI.c.C1781c.AnonymousClass1 */
                    final /* synthetic */ C1781c FAj;

                    {
                        this.FAj = r1;
                    }

                    public final void onClick(View view) {
                        AppMethodBeat.i(119966);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewUserHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        int lR = this.FAj.lR();
                        Object obj = this.FAj.FAh.hKT.get(lR);
                        kotlin.g.b.p.g(obj, "userList[position]");
                        b bVar2 = (b) obj;
                        m<? super Integer, ? super b, x> mVar = this.FAj.FAh.uAj;
                        if (mVar != null) {
                            mVar.invoke(Integer.valueOf(lR), bVar2);
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewUserHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(119966);
                    }
                });
                AppMethodBeat.o(119968);
            }

            @Override // com.tencent.mm.plugin.story.ui.sns.StoryEntranceUI.c.a
            public final void a(b bVar) {
                String str;
                AppMethodBeat.i(119967);
                kotlin.g.b.p.h(bVar, "data");
                a.b.c(this.keC, bVar.userName);
                com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
                kotlin.g.b.p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
                as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().Kn(bVar.userName);
                if (Kn == null || (str = Kn.arJ()) == null) {
                    str = bVar.userName;
                }
                SpannableString b2 = com.tencent.mm.pluginsdk.ui.span.l.b(this.hXC.getContext(), str, this.hXC.getTextSize());
                if (StoryEntranceUI.this.FAe.contains(bVar.userName)) {
                    this.hXC.setTextColor(StoryEntranceUI.this.getContext().getResources().getColor(R.color.BW_0_Alpha_0_3));
                } else {
                    this.hXC.setTextColor(StoryEntranceUI.this.getContext().getResources().getColor(R.color.a2x));
                }
                this.hXC.setText(b2);
                AppMethodBeat.o(119967);
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
    public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
        AppMethodBeat.i(119979);
        if (!(str == null || mStorageEventData == null || !(mStorageEventData.obj instanceof f))) {
            switch (str.hashCode()) {
                case 398324054:
                    if (str.equals("notify_story_read")) {
                        Object obj = mStorageEventData.obj;
                        if (obj == null) {
                            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryExtInfo");
                            AppMethodBeat.o(119979);
                            throw tVar;
                        }
                        this.FAe.add(((f) obj).getUserName());
                        c cVar = this.FAb;
                        if (cVar == null) {
                            kotlin.g.b.p.btv("entranceAdapter");
                        }
                        cVar.notifyDataSetChanged();
                        AppMethodBeat.o(119979);
                        return;
                    }
                    break;
            }
            Log.i(TAG, "unknown event ".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(119979);
    }
}
