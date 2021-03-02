package com.tencent.mm.plugin.test;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.ui.FinderPostRouterUI;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@com.tencent.mm.ui.base.a(3)
@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0004\u0018\u0019\u001a\u001bB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\rH\u0014J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0002J\u0014\u0010\u0013\u001a\u00060\u0014j\u0002`\u00152\u0006\u0010\u0016\u001a\u00020\rH\u0002J\b\u0010\u0017\u001a\u00020\u000fH\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/test/ExMainSettings;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/test/ExMainSettings$Info;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "getLayoutId", "", "initList", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "printCrash", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "d", "startFlutterVideoEditorChoosePic", "Companion", "Info", "SimpleAdapter", "ViewHolder", "app_release"})
public final class ExMainSettings extends MMActivity {
    public static final a FWV = new a((byte) 0);
    private static final String TAG = TAG;
    private RecyclerView hak;
    private final ArrayList<b> kgc = new ArrayList<>();

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ExMainSettings() {
        AppMethodBeat.i(163410);
        AppMethodBeat.o(163410);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/test/ExMainSettings$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "app_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(163411);
        AppMethodBeat.o(163411);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/test/ExMainSettings$initList$1", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "app_release"})
    public static final class e implements View.OnClickListener {
        final /* synthetic */ ExMainSettings FWX;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        e(ExMainSettings exMainSettings) {
            this.FWX = exMainSettings;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(163401);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/test/ExMainSettings$initList$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Intent intent = new Intent(this.FWX, Class.forName("com.tencent.mm.plugin.sns.ui.SnsSettingUI"));
            ExMainSettings exMainSettings = this.FWX;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(exMainSettings, bl.axQ(), "com/tencent/mm/plugin/test/ExMainSettings$initList$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            exMainSettings.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(exMainSettings, "com/tencent/mm/plugin/test/ExMainSettings$initList$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/test/ExMainSettings$initList$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(163401);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/test/ExMainSettings$initList$2", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "app_release"})
    public static final class f implements View.OnClickListener {
        final /* synthetic */ ExMainSettings FWX;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        f(ExMainSettings exMainSettings) {
            this.FWX = exMainSettings;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(230898);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/test/ExMainSettings$initList$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Intent intent = new Intent(this.FWX, Class.forName("com.tencent.mm.plugin.story.ui.StorySettingsUI"));
            ExMainSettings exMainSettings = this.FWX;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(exMainSettings, bl.axQ(), "com/tencent/mm/plugin/test/ExMainSettings$initList$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            exMainSettings.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(exMainSettings, "com/tencent/mm/plugin/test/ExMainSettings$initList$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/test/ExMainSettings$initList$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(230898);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/test/ExMainSettings$initList$3", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "app_release"})
    public static final class g implements View.OnClickListener {
        final /* synthetic */ ExMainSettings FWX;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        g(ExMainSettings exMainSettings) {
            this.FWX = exMainSettings;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(163402);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/test/ExMainSettings$initList$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Intent intent = new Intent(this.FWX, Class.forName("com.tencent.mm.live.ui.LiveUIG"));
            ExMainSettings exMainSettings = this.FWX;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(exMainSettings, bl.axQ(), "com/tencent/mm/plugin/test/ExMainSettings$initList$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            exMainSettings.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(exMainSettings, "com/tencent/mm/plugin/test/ExMainSettings$initList$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/test/ExMainSettings$initList$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(163402);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/test/ExMainSettings$initList$4", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "app_release"})
    public static final class h implements View.OnClickListener {
        final /* synthetic */ ExMainSettings FWX;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        h(ExMainSettings exMainSettings) {
            this.FWX = exMainSettings;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(163403);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/test/ExMainSettings$initList$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Intent intent = new Intent(this.FWX, Class.forName("com.tencent.mm.plugin.finder.ui.FinderSettingsUI"));
            ExMainSettings exMainSettings = this.FWX;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(exMainSettings, bl.axQ(), "com/tencent/mm/plugin/test/ExMainSettings$initList$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            exMainSettings.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(exMainSettings, "com/tencent/mm/plugin/test/ExMainSettings$initList$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/test/ExMainSettings$initList$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(163403);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/test/ExMainSettings$initList$5", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "app_release"})
    public static final class i implements View.OnClickListener {
        final /* synthetic */ ExMainSettings FWX;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        i(ExMainSettings exMainSettings) {
            this.FWX = exMainSettings;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(230899);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/test/ExMainSettings$initList$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.moveLogsFromCacheDirToLogDir();
            Toast.makeText(this.FWX.getContext(), "move success", 0).show();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/test/ExMainSettings$initList$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(230899);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/test/ExMainSettings$initList$6", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "app_release"})
    public static final class j implements View.OnClickListener {
        final /* synthetic */ ExMainSettings FWX;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        j(ExMainSettings exMainSettings) {
            this.FWX = exMainSettings;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(230900);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/test/ExMainSettings$initList$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            ExMainSettings.a(this.FWX);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/test/ExMainSettings$initList$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(230900);
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(163409);
        super.onCreate(bundle);
        setMMTitle("");
        setBackBtn(new k(this));
        this.kgc.add(new b("朋友圈", (int) R.raw.friendactivity_refresh, new e(this)));
        this.kgc.add(new b("视频动态", (int) R.raw.chatting_avatar_story_hint, new f(this)));
        this.kgc.add(new b("Live", (int) R.raw.panel_icon_live, new g(this)));
        Drawable l2 = com.tencent.mm.cb.a.l(getContext(), R.raw.icons_outlined_finder_icon);
        AppCompatActivity context = getContext();
        p.g(context, "context");
        l2.setColorFilter(new PorterDuffColorFilter(context.getResources().getColor(R.color.Orange_100), PorterDuff.Mode.SRC_ATOP));
        this.kgc.add(new b("Finder", l2, new h(this)));
        if (BuildInfo.DEBUG) {
            this.kgc.add(new b("moveXlog", (Drawable) null, new i(this)));
        }
        this.kgc.add(new b("VideoCompositionUI", (Drawable) null, new j(this)));
        this.hak = (RecyclerView) findViewById(R.id.gs0);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager();
        RecyclerView recyclerView = this.hak;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(linearLayoutManager);
        }
        c cVar = new c(this.kgc);
        RecyclerView recyclerView2 = this.hak;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(cVar);
        }
        RecyclerView recyclerView3 = this.hak;
        if (recyclerView3 != null) {
            recyclerView3.setItemViewCacheSize(0);
        }
        com.tencent.mm.ac.d.a(0, new l(cVar));
        AppMethodBeat.o(163409);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class k implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ ExMainSettings FWX;

        k(ExMainSettings exMainSettings) {
            this.FWX = exMainSettings;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(163404);
            this.FWX.finish();
            AppMethodBeat.o(163404);
            return false;
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.bfy;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/test/ExMainSettings$Info;", "", "name", "", "resId", "", "onClickListener", "Landroid/view/View$OnClickListener;", "(Ljava/lang/String;ILandroid/view/View$OnClickListener;)V", "Landroid/graphics/drawable/Drawable;", "(Ljava/lang/String;Landroid/graphics/drawable/Drawable;Landroid/view/View$OnClickListener;)V", "drawable", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "setDrawable", "(Landroid/graphics/drawable/Drawable;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getOnClickListener", "()Landroid/view/View$OnClickListener;", "setOnClickListener", "(Landroid/view/View$OnClickListener;)V", "getResId", "()Ljava/lang/Integer;", "setResId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "app_release"})
    public static final class b {
        Integer FWW;
        Drawable drawable;
        View.OnClickListener ko;
        String name;

        public b(String str, int i2, View.OnClickListener onClickListener) {
            p.h(str, "name");
            p.h(onClickListener, "onClickListener");
            AppMethodBeat.i(163394);
            this.name = str;
            this.FWW = Integer.valueOf(i2);
            this.ko = onClickListener;
            AppMethodBeat.o(163394);
        }

        public b(String str, Drawable drawable2, View.OnClickListener onClickListener) {
            p.h(str, "name");
            p.h(onClickListener, "onClickListener");
            AppMethodBeat.i(163395);
            this.name = str;
            this.drawable = drawable2;
            this.ko = onClickListener;
            AppMethodBeat.o(163395);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u0004R\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/test/ExMainSettings$ViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "iconIv", "Landroid/widget/ImageView;", "getIconIv", "()Landroid/widget/ImageView;", "setIconIv", "(Landroid/widget/ImageView;)V", "layout", "getLayout", "()Landroid/view/View;", "setLayout", "nameTv", "Landroid/widget/TextView;", "getNameTv", "()Landroid/widget/TextView;", "setNameTv", "(Landroid/widget/TextView;)V", "app_release"})
    public static final class d extends RecyclerView.v {
        ImageView gBZ;
        TextView gxs;
        View sc;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(View view) {
            super(view);
            p.h(view, "itemView");
            AppMethodBeat.i(163400);
            View findViewById = view.findViewById(R.id.j7g);
            p.g(findViewById, "itemView.findViewById(R.id.view_layout)");
            this.sc = findViewById;
            View findViewById2 = view.findViewById(R.id.agc);
            p.g(findViewById2, "itemView.findViewById(R.id.busi_icon)");
            this.gBZ = (ImageView) findViewById2;
            View findViewById3 = view.findViewById(R.id.fti);
            p.g(findViewById3, "itemView.findViewById(R.id.name_tv)");
            this.gxs = (TextView) findViewById3;
            AppMethodBeat.o(163400);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/test/ExMainSettings$SimpleAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "list", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/test/ExMainSettings$Info;", "(Ljava/util/ArrayList;)V", "getList", "()Ljava/util/ArrayList;", "getItemCount", "", "onBindViewHolder", "", "_holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "app_release"})
    public static final class c extends RecyclerView.a<RecyclerView.v> {
        private final ArrayList<b> dtS;

        public c(ArrayList<b> arrayList) {
            p.h(arrayList, "list");
            AppMethodBeat.i(163399);
            this.dtS = arrayList;
            AppMethodBeat.o(163399);
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final RecyclerView.v a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(163396);
            p.h(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bqx, viewGroup, false);
            p.g(inflate, "LayoutInflater.from(pare…yout_item, parent, false)");
            d dVar = new d(inflate);
            AppMethodBeat.o(163396);
            return dVar;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            AppMethodBeat.i(163397);
            int size = this.dtS.size();
            AppMethodBeat.o(163397);
            return size;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final void a(RecyclerView.v vVar, int i2) {
            String str;
            Drawable drawable;
            Integer num;
            View.OnClickListener onClickListener = null;
            AppMethodBeat.i(163398);
            p.h(vVar, "_holder");
            d dVar = (d) vVar;
            b bVar = this.dtS.get(i2);
            p.g(bVar, "list[position]");
            b bVar2 = bVar;
            TextView textView = dVar.gxs;
            if (bVar2 != null) {
                str = bVar2.name;
            } else {
                str = null;
            }
            textView.setText(str);
            if (!(bVar2 == null || (num = bVar2.FWW) == null)) {
                dVar.gBZ.setImageResource(num.intValue());
            }
            if (!(bVar2 == null || (drawable = bVar2.drawable) == null)) {
                dVar.gBZ.setImageDrawable(drawable);
            }
            View view = dVar.sc;
            if (bVar2 != null) {
                onClickListener = bVar2.ko;
            }
            view.setOnClickListener(onClickListener);
            AppMethodBeat.o(163398);
        }
    }

    public static final /* synthetic */ void a(ExMainSettings exMainSettings) {
        AppMethodBeat.i(230901);
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.setClass(exMainSettings.getContext(), FinderPostRouterUI.class);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (!com.tencent.mm.plugin.finder.storage.c.drH()) {
            intent.putExtra("key_can_select_video_and_pic", true);
        }
        intent.putExtra("is_hide_album_footer", true);
        intent.putExtra("show_header_view", false);
        intent.putExtra("max_select_count", 9);
        intent.putExtra("query_source_type", 25);
        intent.putExtra("query_media_type", 3);
        com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
        intent.putExtra("album_video_max_duration", com.tencent.mm.plugin.finder.storage.c.dqA());
        com.tencent.mm.plugin.finder.storage.c cVar3 = com.tencent.mm.plugin.finder.storage.c.vCb;
        intent.putExtra("album_video_min_duration", com.tencent.mm.plugin.finder.storage.c.dqw().minDuration);
        intent.putExtra("key_finder_post_router", 10);
        AppCompatActivity context = exMainSettings.getContext();
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/test/ExMainSettings", "startFlutterVideoEditorChoosePic", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/test/ExMainSettings", "startFlutterVideoEditorChoosePic", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(230901);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class l extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ c FWY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(c cVar) {
            super(0);
            this.FWY = cVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(163405);
            this.FWY.notifyDataSetChanged();
            x xVar = x.SXb;
            AppMethodBeat.o(163405);
            return xVar;
        }
    }
}
