package com.tencent.mm.plugin.story.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.story.c.a.g;
import com.tencent.mm.plugin.story.f.i;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.proxy.StoryCaptureProxy;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;

@com.tencent.mm.ui.base.a(3)
@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0005\u001f !\"#B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\"\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\u0012\u0010\u0019\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0013H\u0016J\b\u0010\u001d\u001a\u00020\u0013H\u0014J\b\u0010\u001e\u001a\u00020\u0013H\u0014R\u0012\u0010\u0003\u001a\u00060\u0004R\u00020\u0000X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/StorySettingsUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "adapter", "Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ChoiceAdapter;", "listview", "Landroid/widget/ListView;", "mDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "proxy", "Lcom/tencent/mm/plugin/story/proxy/StoryCaptureProxy;", "selectsList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ITestMenu;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "getLayoutId", "", "initOnCreate", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "ChoiceAdapter", "ChoiceItem", "ClickItem", "Companion", "ITestMenu", "plugin-story_release"})
public final class StorySettingsUI extends MMActivity {
    public static final d Fxu = new d((byte) 0);
    private static final String TAG = TAG;
    private a Fxr;
    private StoryCaptureProxy Fxs;
    private com.tencent.mm.ui.base.q Fxt;
    private com.tencent.mm.remoteservice.d gVN = new com.tencent.mm.remoteservice.d(MMApplicationContext.getContext());
    private final LinkedList<e> hUG = new LinkedList<>();
    private ListView hUI;

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0007H&¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ITestMenu;", "", "showAlert", "", "view", "Landroid/view/View;", "title", "", "value", "plugin-story_release"})
    public interface e {
        String auk();

        void cp(View view);

        String value();
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        AppMethodBeat.at(this, z2);
    }

    public StorySettingsUI() {
        AppMethodBeat.i(119710);
        AppMethodBeat.o(119710);
    }

    public static final /* synthetic */ a b(StorySettingsUI storySettingsUI) {
        AppMethodBeat.i(119712);
        a aVar = storySettingsUI.Fxr;
        if (aVar == null) {
            kotlin.g.b.p.btv("adapter");
        }
        AppMethodBeat.o(119712);
        return aVar;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.c0w;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(119706);
        super.onCreate(bundle);
        this.Fxs = new StoryCaptureProxy(this.gVN);
        this.gVN.connect(new ah(this));
        setBackBtn(new ai(this));
        AppMethodBeat.o(119706);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class ah implements Runnable {
        final /* synthetic */ StorySettingsUI Fxv;

        ah(StorySettingsUI storySettingsUI) {
            this.Fxv = storySettingsUI;
        }

        public final void run() {
            AppMethodBeat.i(119704);
            d dVar = StorySettingsUI.Fxu;
            Log.i(StorySettingsUI.TAG, "has connect");
            StorySettingsUI.d(this.Fxv);
            AppMethodBeat.o(119704);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class ai implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ StorySettingsUI Fxv;

        ai(StorySettingsUI storySettingsUI) {
            this.Fxv = storySettingsUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(119705);
            this.Fxv.finish();
            AppMethodBeat.o(119705);
            return false;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$1", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
    public static final class f implements View.OnClickListener {
        final /* synthetic */ StorySettingsUI Fxv;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        f(StorySettingsUI storySettingsUI) {
            this.Fxv = storySettingsUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(119669);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Intent intent = new Intent(this.Fxv, Class.forName("com.tencent.mm.plugin.ui.SampleListUI"));
            StorySettingsUI storySettingsUI = this.Fxv;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(storySettingsUI, bl.axQ(), "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            storySettingsUI.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(storySettingsUI, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(119669);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$2", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
    public static final class q implements View.OnClickListener {
        q() {
        }

        public final void onClick(View view) {
            AppMethodBeat.i(119685);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            new com.tencent.mm.plugin.story.f.h();
            com.tencent.mm.plugin.story.f.h.fnS();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(119685);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$3", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
    public static final class aa implements View.OnClickListener {
        aa() {
        }

        public final void onClick(View view) {
            AppMethodBeat.i(119697);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_STORY_POST_FIRST_BOOLEAN_SYNC, Boolean.TRUE);
            com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh2, "MMKernel.storage()");
            aAh2.azQ().set(ar.a.USERINFO_STORY_WHATS_NEW_BOOLEAN_SYNC, Boolean.TRUE);
            com.tencent.mm.kernel.e aAh3 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh3, "MMKernel.storage()");
            aAh3.azQ().set(ar.a.USERINFO_STORY_POST_FIRST_TO_AUTOPLAY_BOOLEAN_SYNC, Boolean.TRUE);
            com.tencent.mm.kernel.e aAh4 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh4, "MMKernel.storage()");
            aAh4.azQ().set(ar.a.USERINFO_STORY_GALLERY_FIRST_BOOLEAN_SYNC, Boolean.FALSE);
            com.tencent.mm.kernel.e aAh5 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh5, "MMKernel.storage()");
            aAh5.azQ().set(ar.a.USERINFO_STORY_BUBBLE_COUNT_INT, (Object) 0);
            com.tencent.mm.kernel.e aAh6 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh6, "MMKernel.storage()");
            aAh6.azQ().set(ar.a.USERINFO_STORY_CAPTURE_FIRST_BOOLEAN_SYNC, Boolean.FALSE);
            com.tencent.mm.kernel.e aAh7 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh7, "MMKernel.storage()");
            aAh7.azQ().set(ar.a.USERINFO_STORY_CAPTURE_FIRST_NEW_BOOLEAN_SYNC, Boolean.FALSE);
            com.tencent.mm.kernel.e aAh8 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh8, "MMKernel.storage()");
            aAh8.azQ().set(ar.a.USERINFO_STORY_PULL_DOWN_MORE_TAB_FIRST_BOOLEAN_SYNC, Boolean.FALSE);
            com.tencent.mm.kernel.e aAh9 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh9, "MMKernel.storage()");
            aAh9.azQ().set(ar.a.USERINFO_STORY_PULL_DOWN_PROFILE_FIRST_BOOLEAN_SYNC, Boolean.FALSE);
            com.tencent.mm.kernel.e aAh10 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh10, "MMKernel.storage()");
            aAh10.azQ().set(ar.a.USERINFO_STORY_FIRST_PULL_DOWN_BOOLEAN_SYNC, Boolean.TRUE);
            com.tencent.mm.kernel.e aAh11 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh11, "MMKernel.storage()");
            aAh11.azQ().set(ar.a.USERINFO_STORY_PULL_DOWN_COUNT_INT, (Object) 0);
            com.tencent.mm.kernel.e aAh12 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh12, "MMKernel.storage()");
            aAh12.azQ().set(ar.a.USERINFO_STORY_NEED_DISPLAY_ALBUM_GUIDE_BOOLEAN_SYNC, Boolean.TRUE);
            com.tencent.mm.kernel.e aAh13 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh13, "MMKernel.storage()");
            aAh13.azQ().set(ar.a.USERINFO_STORY_EDITOR_SHOW_PRIVACY_TIP_BOOLEAN_SYNC, Boolean.TRUE);
            com.tencent.mm.kernel.e aAh14 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh14, "MMKernel.storage()");
            aAh14.azQ().set(ar.a.USERINFO_STORY_EDITOR_SHOW_FAV_TIP_BOOLEAN_SYNC, Boolean.TRUE);
            com.tencent.mm.kernel.e aAh15 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh15, "MMKernel.storage()");
            aAh15.azQ().set(ar.a.USERINFO_STORY_BIG_MOUTH_GUIDE_INT, (Object) 0);
            com.tencent.mm.kernel.e aAh16 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh16, "MMKernel.storage()");
            aAh16.azQ().set(ar.a.USERINFO_STORY_NEW_FEATURE_TIP_BOOLEAN_SYNC, Boolean.TRUE);
            com.tencent.mm.kernel.e aAh17 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh17, "MMKernel.storage()");
            aAh17.azQ().set(ar.a.USERINFO_WX_WEISHI_HONGBAO_DOWNLOAD_COUNT_JSON_STRING_SYNC, "");
            com.tencent.mm.ui.base.u.makeText(MMApplicationContext.getContext(), "好了", 1).show();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(119697);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$4", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
    public static final class ab implements View.OnClickListener {
        ab() {
        }

        public final void onClick(View view) {
            AppMethodBeat.i(119698);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            new com.tencent.mm.plugin.story.f.h();
            com.tencent.mm.plugin.story.f.h.fnQ();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(119698);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$5", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
    public static final class ac implements View.OnClickListener {
        ac() {
        }

        public final void onClick(View view) {
            AppMethodBeat.i(119699);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.recordvideo.b.e eVar = com.tencent.mm.plugin.recordvideo.b.e.BNm;
            com.tencent.mm.plugin.recordvideo.b.e eVar2 = com.tencent.mm.plugin.recordvideo.b.e.BNm;
            com.tencent.mm.plugin.recordvideo.b.e.ta(!com.tencent.mm.plugin.recordvideo.b.e.eJt());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(119699);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$6", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
    public static final class ad implements View.OnClickListener {
        ad() {
        }

        public final void onClick(View view) {
            AppMethodBeat.i(119700);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.recordvideo.b.e eVar = com.tencent.mm.plugin.recordvideo.b.e.BNm;
            com.tencent.mm.plugin.recordvideo.b.e eVar2 = com.tencent.mm.plugin.recordvideo.b.e.BNm;
            com.tencent.mm.plugin.recordvideo.b.e.tb(!com.tencent.mm.plugin.recordvideo.b.e.eJu());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(119700);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$7", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
    public static final class ae implements View.OnClickListener {
        ae() {
        }

        public final void onClick(View view) {
            AppMethodBeat.i(119701);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.story.c.c.BNK = !com.tencent.mm.plugin.story.c.c.BNK;
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(119701);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$8", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
    public static final class af implements View.OnClickListener {
        af() {
        }

        public final void onClick(View view) {
            AppMethodBeat.i(119702);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.story.c.c.Kh(100000);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(119702);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$9", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
    public static final class ag implements View.OnClickListener {
        ag() {
        }

        public final void onClick(View view) {
            AppMethodBeat.i(119703);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.story.c.c.fnt();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(119703);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$10", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
    public static final class g implements View.OnClickListener {
        g() {
        }

        public final void onClick(View view) {
            AppMethodBeat.i(119670);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.story.c.c.Kh(10000);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(119670);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$11", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
    public static final class h implements View.OnClickListener {
        h() {
        }

        public final void onClick(View view) {
            AppMethodBeat.i(119671);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            j.b bVar2 = com.tencent.mm.plugin.story.f.j.Fmy;
            j.b.fog().eIQ();
            j.b bVar3 = com.tencent.mm.plugin.story.f.j.Fmy;
            j.b.foe().eIQ();
            j.b bVar4 = com.tencent.mm.plugin.story.f.j.Fmy;
            j.b.foc().eIQ();
            j.b bVar5 = com.tencent.mm.plugin.story.f.j.Fmy;
            com.tencent.mm.vfs.s.deleteDir(j.b.getAccStoryCachePath());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(119671);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$12", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
    public static final class i implements View.OnClickListener {
        i() {
        }

        public final void onClick(View view) {
            AppMethodBeat.i(119674);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.story.f.f.a aVar = com.tencent.mm.plugin.story.f.f.a.FpB;
            com.tencent.mm.plugin.story.f.f.a.fpb();
            com.tencent.mm.ac.d.a(5000, a.Fxy);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(119674);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
            public static final a Fxy = new a();

            static {
                AppMethodBeat.i(119673);
                AppMethodBeat.o(119673);
            }

            a() {
                super(0);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ kotlin.x invoke() {
                AppMethodBeat.i(119672);
                com.tencent.mm.plugin.story.f.f.a.FpB.init();
                kotlin.x xVar = kotlin.x.SXb;
                AppMethodBeat.o(119672);
                return xVar;
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$13", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
    public static final class j implements View.OnClickListener {
        j() {
        }

        public final void onClick(View view) {
            AppMethodBeat.i(119675);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            j.b bVar2 = com.tencent.mm.plugin.story.f.j.Fmy;
            com.tencent.mm.plugin.story.f.j.Fmx = 0;
            new com.tencent.mm.plugin.story.f.h();
            com.tencent.mm.plugin.story.f.h.fnR();
            com.tencent.mm.plugin.story.f.f.a.FpB.init();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(119675);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$14", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
    public static final class k implements View.OnClickListener {
        final /* synthetic */ StorySettingsUI Fxv;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        k(StorySettingsUI storySettingsUI) {
            this.Fxv = storySettingsUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(119676);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.story.f.l lVar = com.tencent.mm.plugin.story.f.l.FmK;
            com.tencent.mm.ui.base.h.X(this.Fxv.getContext(), com.tencent.mm.plugin.story.f.l.fot(), "嗯");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(119676);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$15", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
    public static final class l implements View.OnClickListener {
        final /* synthetic */ StorySettingsUI Fxv;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        l(StorySettingsUI storySettingsUI) {
            this.Fxv = storySettingsUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(119677);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            j.b bVar2 = com.tencent.mm.plugin.story.f.j.Fmy;
            com.tencent.mm.vfs.s.deleteDir(j.b.getAccStoryCachePath());
            com.tencent.mm.ui.base.h.X(this.Fxv.getContext(), "ok", "嗯");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(119677);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$16", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
    public static final class m implements View.OnClickListener {
        final /* synthetic */ StorySettingsUI Fxv;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        m(StorySettingsUI storySettingsUI) {
            this.Fxv = storySettingsUI;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
        static final class a implements DialogInterface.OnCancelListener {
            final /* synthetic */ m Fxz;

            a(m mVar) {
                this.Fxz = mVar;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(119678);
                this.Fxz.Fxv.finish();
                AppMethodBeat.o(119678);
            }
        }

        public final void onClick(View view) {
            AppMethodBeat.i(119681);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            StorySettingsUI storySettingsUI = this.Fxv;
            this.Fxv.getString(R.string.zb);
            storySettingsUI.Fxt = com.tencent.mm.ui.base.h.a((Context) this.Fxv.getContext(), this.Fxv.getString(R.string.a06), true, (DialogInterface.OnCancelListener) new a(this));
            com.tencent.mm.ac.d.b("cpfiles", new b(this));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(119681);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class b extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
            final /* synthetic */ m Fxz;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(m mVar) {
                super(0);
                this.Fxz = mVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ kotlin.x invoke() {
                AppMethodBeat.i(119680);
                com.tencent.mm.plugin.story.f.l lVar = com.tencent.mm.plugin.story.f.l.FmK;
                StringBuilder sb = new StringBuilder();
                j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
                com.tencent.mm.plugin.story.f.l.aLP(sb.append(j.b.getAccStoryPath()).append("cpdirs").toString());
                StringBuilder sb2 = new StringBuilder();
                j.b bVar2 = com.tencent.mm.plugin.story.f.j.Fmy;
                com.tencent.mm.vfs.s.deleteDir(sb2.append(j.b.getAccStoryPath()).append("cpdirs").toString());
                j.b bVar3 = com.tencent.mm.plugin.story.f.j.Fmy;
                String accStoryCachePath = j.b.getAccStoryCachePath();
                StringBuilder sb3 = new StringBuilder();
                j.b bVar4 = com.tencent.mm.plugin.story.f.j.Fmy;
                com.tencent.mm.vfs.s.ny(accStoryCachePath, sb3.append(j.b.getAccStoryPath()).append("/cpdirs").toString());
                com.tencent.mm.ac.d.h(new kotlin.g.a.a<kotlin.x>(this) {
                    /* class com.tencent.mm.plugin.story.ui.StorySettingsUI.m.b.AnonymousClass1 */
                    final /* synthetic */ b FxA;

                    {
                        this.FxA = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ kotlin.x invoke() {
                        AppMethodBeat.i(119679);
                        com.tencent.mm.ui.base.q qVar = this.FxA.Fxz.Fxv.Fxt;
                        if (qVar != null) {
                            qVar.dismiss();
                        }
                        com.tencent.mm.ui.base.h.X(this.FxA.Fxz.Fxv.getContext(), "ok", "嗯");
                        kotlin.x xVar = kotlin.x.SXb;
                        AppMethodBeat.o(119679);
                        return xVar;
                    }
                });
                kotlin.x xVar = kotlin.x.SXb;
                AppMethodBeat.o(119680);
                return xVar;
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$17", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
    public static final class n implements View.OnClickListener {
        final /* synthetic */ StorySettingsUI Fxv;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        n(StorySettingsUI storySettingsUI) {
            this.Fxv = storySettingsUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(119682);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.platformtools.ac.jPI = !com.tencent.mm.platformtools.ac.jPI;
            com.tencent.mm.ui.base.h.X(this.Fxv.getContext(), "ok value Test Fail:" + com.tencent.mm.platformtools.ac.jPI, "嗯");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(119682);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$18", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
    public static final class o implements View.OnClickListener {
        final /* synthetic */ StorySettingsUI Fxv;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        o(StorySettingsUI storySettingsUI) {
            this.Fxv = storySettingsUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(119683);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.platformtools.ac.jPJ = !com.tencent.mm.platformtools.ac.jPJ;
            com.tencent.mm.ui.base.h.X(this.Fxv.getContext(), "ok value Test Fail:" + com.tencent.mm.platformtools.ac.jPJ, "嗯");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(119683);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class p implements View.OnClickListener {
        final /* synthetic */ StorySettingsUI Fxv;

        p(StorySettingsUI storySettingsUI) {
            this.Fxv = storySettingsUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(119684);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_STORY_GALLERY_FIRST_BOOLEAN_SYNC, Boolean.FALSE);
            com.tencent.mm.ui.base.h.X(this.Fxv.getContext(), "在群视频，不要上滑，静候5秒", "");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(119684);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class r implements View.OnClickListener {
        public static final r FxB = new r();

        static {
            AppMethodBeat.i(119687);
            AppMethodBeat.o(119687);
        }

        r() {
        }

        public final void onClick(View view) {
            AppMethodBeat.i(119686);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_STORY_BUBBLE_COUNT_INT, (Object) 0);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(119686);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class s implements View.OnClickListener {
        public static final s FxC = new s();

        static {
            AppMethodBeat.i(119689);
            AppMethodBeat.o(119689);
        }

        s() {
        }

        public final void onClick(View view) {
            AppMethodBeat.i(119688);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_STORY_CAPTURE_FIRST_BOOLEAN_SYNC, Boolean.FALSE);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(119688);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class t implements View.OnClickListener {
        public static final t FxD = new t();

        static {
            AppMethodBeat.i(119691);
            AppMethodBeat.o(119691);
        }

        t() {
        }

        public final void onClick(View view) {
            AppMethodBeat.i(119690);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_STORY_PULL_DOWN_MORE_TAB_FIRST_BOOLEAN_SYNC, Boolean.FALSE);
            com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh2, "MMKernel.storage()");
            aAh2.azQ().set(ar.a.USERINFO_STORY_PULL_DOWN_PROFILE_FIRST_BOOLEAN_SYNC, Boolean.FALSE);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(119690);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class u implements View.OnClickListener {
        final /* synthetic */ StorySettingsUI Fxv;

        u(StorySettingsUI storySettingsUI) {
            this.Fxv = storySettingsUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(119692);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            i.a aVar = com.tencent.mm.plugin.story.f.i.Fmb;
            com.tencent.mm.plugin.story.f.i.FlY = 60;
            com.tencent.mm.ui.base.h.X(this.Fxv.getContext(), "ok！", "");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(119692);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$24", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
    public static final class v implements View.OnClickListener {
        v() {
        }

        public final void onClick(View view) {
            AppMethodBeat.i(119693);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_STORY_SNS_SHOW_TIME_LONG, (Object) 0L);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(119693);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class w implements View.OnClickListener {
        final /* synthetic */ StorySettingsUI Fxv;

        w(StorySettingsUI storySettingsUI) {
            this.Fxv = storySettingsUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(119694);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            try {
                AppCompatActivity context = this.Fxv.getContext();
                kotlin.g.b.p.g(context, "context");
                com.tencent.mm.vfs.s.deleteDir(String.valueOf(context.getExternalCacheDir()) + "/imgcache");
            } catch (Exception e2) {
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(119694);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class x implements View.OnClickListener {
        final /* synthetic */ StorySettingsUI Fxv;

        x(StorySettingsUI storySettingsUI) {
            this.Fxv = storySettingsUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(119695);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$26", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Intent intent = new Intent();
            intent.putExtra("KEY_EDITABLE", true);
            intent.putExtra("KEY_CONTENT_XML", this.Fxv.getSharedPreferences("test_plugin", 0).getString("content", ""));
            com.tencent.mm.br.c.b(this.Fxv.getContext(), "editor", ".EditorUI", intent, 4096);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$26", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(119695);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$27", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
    public static final class y implements View.OnClickListener {
        y() {
        }

        public final void onClick(View view) {
            AppMethodBeat.i(119696);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_SNS_FINDER_EXPOSE_COUNT_INT_SYNC, (Object) 0);
            com.tencent.mm.ui.base.u.makeText(MMApplicationContext.getContext(), "好了", 1).show();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(119696);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$28", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
    public static final class z implements View.OnClickListener {
        final /* synthetic */ StorySettingsUI Fxv;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        z(StorySettingsUI storySettingsUI) {
            this.Fxv = storySettingsUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(178049);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$28", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.t.a.c.eBv().gL(this.Fxv.getContext());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$28", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(178049);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(178052);
        if (4096 == i2 && -1 == i3) {
            String stringExtra = intent != null ? intent.getStringExtra("KEY_CONTENT_XML") : null;
            if (!Util.isNullOrNil(stringExtra)) {
                getSharedPreferences("test_plugin", 0).edit().putString("content", stringExtra).apply();
            }
        }
        AppMethodBeat.o(178052);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(119707);
        super.onDestroy();
        this.gVN.release();
        AppMethodBeat.o(119707);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(119708);
        super.onResume();
        AppMethodBeat.o(119708);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onPause() {
        AppMethodBeat.i(119709);
        super.onPause();
        AppMethodBeat.o(119709);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ClickItem;", "Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ITestMenu;", "title", "", "value", "clickEvent", "Landroid/view/View$OnClickListener;", "(Ljava/lang/String;Ljava/lang/String;Landroid/view/View$OnClickListener;)V", "getClickEvent", "()Landroid/view/View$OnClickListener;", "getTitle", "()Ljava/lang/String;", "getValue", "showAlert", "", "view", "Landroid/view/View;", "plugin-story_release"})
    public static final class c implements e {
        private final View.OnClickListener EJh;
        private final String title;
        private final String value;

        public c(String str, String str2, View.OnClickListener onClickListener) {
            kotlin.g.b.p.h(str, "title");
            kotlin.g.b.p.h(str2, "value");
            kotlin.g.b.p.h(onClickListener, "clickEvent");
            AppMethodBeat.i(119668);
            this.title = str;
            this.value = str2;
            this.EJh = onClickListener;
            AppMethodBeat.o(119668);
        }

        @Override // com.tencent.mm.plugin.story.ui.StorySettingsUI.e
        public final void cp(View view) {
            AppMethodBeat.i(119667);
            kotlin.g.b.p.h(view, "view");
            this.EJh.onClick(view);
            com.tencent.mm.ui.base.u.makeText(MMApplicationContext.getContext(), "ClickItem Done", 1).show();
            AppMethodBeat.o(119667);
        }

        @Override // com.tencent.mm.plugin.story.ui.StorySettingsUI.e
        public final String auk() {
            return this.title;
        }

        @Override // com.tencent.mm.plugin.story.ui.StorySettingsUI.e
        public final String value() {
            return this.value;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0011\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\tH\u0002J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u0003H\u0016J\b\u0010\u001c\u001a\u00020\u0003H\u0016R\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0015¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ChoiceItem;", "Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ITestMenu;", "_showtitle", "", "_key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "_items", "", "_vals", "", "(Lcom/tencent/mm/plugin/story/ui/StorySettingsUI;Ljava/lang/String;Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;[Ljava/lang/String;Ljava/lang/Object;)V", "get_items", "()[Ljava/lang/String;", "set_items", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "get_key", "()Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "set_key", "(Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;)V", "get_showtitle", "()Ljava/lang/String;", "set_showtitle", "(Ljava/lang/String;)V", "get_vals", "()Ljava/lang/Object;", "set_vals", "(Ljava/lang/Object;)V", "value", "getValue", "get", "field", "showAlert", "", "view", "Landroid/view/View;", "title", "plugin-story_release"})
    public final class b implements e {
        final /* synthetic */ StorySettingsUI Fxv;
        private String hUN;
        ar.a hUO;
        private String[] hUP;
        Object hUQ;

        public b(StorySettingsUI storySettingsUI, String str, ar.a aVar, String[] strArr, Object obj) {
            kotlin.g.b.p.h(str, "_showtitle");
            kotlin.g.b.p.h(aVar, "_key");
            kotlin.g.b.p.h(strArr, "_items");
            kotlin.g.b.p.h(obj, "_vals");
            this.Fxv = storySettingsUI;
            AppMethodBeat.i(119666);
            this.hUN = str;
            this.hUO = aVar;
            this.hUP = strArr;
            this.hUQ = obj;
            AppMethodBeat.o(119666);
        }

        @Override // com.tencent.mm.plugin.story.ui.StorySettingsUI.e
        public final String auk() {
            return this.hUN;
        }

        @Override // com.tencent.mm.plugin.story.ui.StorySettingsUI.e
        public final void cp(View view) {
            AppMethodBeat.i(119664);
            kotlin.g.b.p.h(view, "view");
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            int length = this.hUP.length;
            for (int i2 = 0; i2 < length; i2++) {
                linkedList.add(this.hUP[i2]);
                linkedList2.add(Integer.valueOf(i2));
            }
            com.tencent.mm.ui.base.h.a(this.Fxv, "", linkedList, linkedList2, "", new a(this));
            AppMethodBeat.o(119664);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "whichButton", "", "<anonymous parameter 1>", "onClick"})
        static final class a implements h.e {
            final /* synthetic */ b Fxx;

            a(b bVar) {
                this.Fxx = bVar;
            }

            @Override // com.tencent.mm.ui.base.h.e
            public final void cy(int i2, int i3) {
                AppMethodBeat.i(119662);
                try {
                    Object obj = this.Fxx.hUQ;
                    if (obj instanceof long[]) {
                        StoryCaptureProxy storyCaptureProxy = this.Fxx.Fxv.Fxs;
                        if (storyCaptureProxy == null) {
                            kotlin.g.b.p.hyc();
                        }
                        ar.a aVar = this.Fxx.hUO;
                        Object obj2 = this.Fxx.hUQ;
                        if (obj2 == null) {
                            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.LongArray");
                            AppMethodBeat.o(119662);
                            throw tVar;
                        }
                        storyCaptureProxy.set(aVar, Long.valueOf(((long[]) obj2)[i2]));
                    } else if (obj instanceof int[]) {
                        StoryCaptureProxy storyCaptureProxy2 = this.Fxx.Fxv.Fxs;
                        if (storyCaptureProxy2 == null) {
                            kotlin.g.b.p.hyc();
                        }
                        ar.a aVar2 = this.Fxx.hUO;
                        Object obj3 = this.Fxx.hUQ;
                        if (obj3 == null) {
                            kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type kotlin.IntArray");
                            AppMethodBeat.o(119662);
                            throw tVar2;
                        }
                        storyCaptureProxy2.set(aVar2, Integer.valueOf(((int[]) obj3)[i2]));
                    }
                    StorySettingsUI.b(this.Fxx.Fxv).notifyDataSetChanged();
                    AppMethodBeat.o(119662);
                } catch (Exception e2) {
                    d dVar = StorySettingsUI.Fxu;
                    Log.printErrStackTrace(StorySettingsUI.TAG, e2, "", new Object[0]);
                    AppMethodBeat.o(119662);
                }
            }
        }

        private final String dU(Object obj) {
            AppMethodBeat.i(119665);
            Object obj2 = this.hUQ;
            if (obj2 instanceof long[]) {
                if (obj == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.Long");
                    AppMethodBeat.o(119665);
                    throw tVar;
                }
                long longValue = ((Long) obj).longValue();
                Object obj3 = this.hUQ;
                if (obj3 == null) {
                    kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type kotlin.LongArray");
                    AppMethodBeat.o(119665);
                    throw tVar2;
                }
                int length = ((long[]) obj3).length;
                for (int i2 = 0; i2 < length; i2++) {
                    Object obj4 = this.hUQ;
                    if (obj4 == null) {
                        kotlin.t tVar3 = new kotlin.t("null cannot be cast to non-null type kotlin.LongArray");
                        AppMethodBeat.o(119665);
                        throw tVar3;
                    } else if (longValue == ((long[]) obj4)[i2] && i2 < this.hUP.length) {
                        String str = this.hUP[i2];
                        AppMethodBeat.o(119665);
                        return str;
                    }
                }
                String str2 = this.hUP[0];
                AppMethodBeat.o(119665);
                return str2;
            } else if (!(obj2 instanceof int[])) {
                AppMethodBeat.o(119665);
                return "";
            } else if (obj == null) {
                kotlin.t tVar4 = new kotlin.t("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(119665);
                throw tVar4;
            } else {
                int intValue = ((Integer) obj).intValue();
                Object obj5 = this.hUQ;
                if (obj5 == null) {
                    kotlin.t tVar5 = new kotlin.t("null cannot be cast to non-null type kotlin.IntArray");
                    AppMethodBeat.o(119665);
                    throw tVar5;
                }
                int length2 = ((int[]) obj5).length;
                for (int i3 = 0; i3 < length2; i3++) {
                    Object obj6 = this.hUQ;
                    if (obj6 == null) {
                        kotlin.t tVar6 = new kotlin.t("null cannot be cast to non-null type kotlin.IntArray");
                        AppMethodBeat.o(119665);
                        throw tVar6;
                    } else if (intValue == ((int[]) obj6)[i3] && i3 < this.hUP.length) {
                        String str3 = this.hUP[i3];
                        AppMethodBeat.o(119665);
                        return str3;
                    }
                }
                String str4 = this.hUP[0];
                AppMethodBeat.o(119665);
                return str4;
            }
        }

        @Override // com.tencent.mm.plugin.story.ui.StorySettingsUI.e
        public final String value() {
            AppMethodBeat.i(119663);
            if (this.hUQ instanceof long[]) {
                StoryCaptureProxy storyCaptureProxy = this.Fxv.Fxs;
                if (storyCaptureProxy == null) {
                    kotlin.g.b.p.hyc();
                }
                String dU = dU(storyCaptureProxy.get(this.hUO, 0L));
                AppMethodBeat.o(119663);
                return dU;
            }
            StoryCaptureProxy storyCaptureProxy2 = this.Fxv.Fxs;
            if (storyCaptureProxy2 == null) {
                kotlin.g.b.p.hyc();
            }
            String dU2 = dU(storyCaptureProxy2.get(this.hUO, 0));
            AppMethodBeat.o(119663);
            return dU2;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\"\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0017¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ChoiceAdapter;", "Landroid/widget/BaseAdapter;", "(Lcom/tencent/mm/plugin/story/ui/StorySettingsUI;)V", "getCount", "", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "plugin-story_release"})
    public final class a extends BaseAdapter {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a() {
        }

        public final int getCount() {
            AppMethodBeat.i(119659);
            int size = StorySettingsUI.this.hUG.size();
            AppMethodBeat.o(119659);
            return size;
        }

        public final Object getItem(int i2) {
            AppMethodBeat.i(119660);
            Object obj = StorySettingsUI.this.hUG.get(i2);
            kotlin.g.b.p.g(obj, "selectsList[position]");
            AppMethodBeat.o(119660);
            return obj;
        }

        public final long getItemId(int i2) {
            return 0;
        }

        @SuppressLint({"SetTextI18n"})
        public final View getView(int i2, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(119661);
            kotlin.g.b.p.h(viewGroup, "parent");
            TextView textView = new TextView(StorySettingsUI.this);
            Object item = getItem(i2);
            if (item == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.StorySettingsUI.ITestMenu");
                AppMethodBeat.o(119661);
                throw tVar;
            }
            e eVar = (e) item;
            textView.setText(eVar.auk() + "->:" + eVar.value());
            textView.setGravity(17);
            textView.setTextSize(1, 20.0f);
            textView.setHeight(com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 50));
            if (i2 % 2 == 1) {
                textView.setBackgroundColor(Color.parseColor("#e2efda"));
            }
            textView.setOnClickListener(new View$OnClickListenerC1772a(eVar, textView));
            TextView textView2 = textView;
            AppMethodBeat.o(119661);
            return textView2;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        /* renamed from: com.tencent.mm.plugin.story.ui.StorySettingsUI$a$a  reason: collision with other inner class name */
        static final class View$OnClickListenerC1772a implements View.OnClickListener {
            final /* synthetic */ e Fxw;
            final /* synthetic */ TextView hUM;

            View$OnClickListenerC1772a(e eVar, TextView textView) {
                this.Fxw = eVar;
                this.hUM = textView;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(119658);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/StorySettingsUI$ChoiceAdapter$getView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.Fxw.cp(this.hUM);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/StorySettingsUI$ChoiceAdapter$getView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(119658);
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
    public static final class d {
        private d() {
        }

        public /* synthetic */ d(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(119711);
        AppMethodBeat.o(119711);
    }

    public static final /* synthetic */ void d(StorySettingsUI storySettingsUI) {
        long j2;
        AppMethodBeat.i(119713);
        storySettingsUI.hUG.add(new c("TestUI", "点我", new f(storySettingsUI)));
        storySettingsUI.hUG.add(new b(storySettingsUI, "支付Kinda开关", ar.a.USERINFO_KINDA_PAY_CONFIG_TYPE_INT, new String[]{WeChatBrands.Business.GROUP_OPEN, "close", BuildConfig.KINDA_DEFAULT}, new int[]{1, 2, 0}));
        storySettingsUI.hUG.add(new b(storySettingsUI, "朋友圈入口", ar.a.USERINFO_STORY_SNS_HEADER_TYPE_INT, new String[]{"方案一", "方案二", "关闭", "使用后台动态配置"}, new int[]{1, 2, 10000, 0}));
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh, "MMKernel.storage()");
        long a2 = aAh.azQ().a(ar.a.USERINFO_STORY_SNS_UPDATE_TIME_LONG, 0);
        if (a2 <= 0) {
            j2 = System.currentTimeMillis();
        } else {
            j2 = a2;
        }
        storySettingsUI.hUG.add(new b(storySettingsUI, "朋友圈入口新动态时间重设", ar.a.USERINFO_STORY_SNS_UPDATE_TIME_LONG, new String[]{"1个小时前", "2个小时前", "4个小时前", "24个小时前"}, new long[]{j2 - Util.MILLSECONDS_OF_HOUR, j2 - 7200000, j2 - 14400000, j2 - Util.MILLSECONDS_OF_DAY}));
        storySettingsUI.hUG.add(new b(storySettingsUI, "vlog开关", ar.a.USERINFO_TOP_STORY_VLOG_ENABLE_INT, new String[]{"关", "开"}, new int[]{0, 1}));
        storySettingsUI.hUG.add(new b(storySettingsUI, "vlog新旧逻辑", ar.a.USERINFO_TOP_STORY_VLOG_NEW_LOGIC_INT, new String[]{"新", "旧"}, new int[]{0, 1}));
        storySettingsUI.hUG.add(new b(storySettingsUI, "合成方案", ar.a.USERINFO_TOP_STORY_REMUX_TYPE_INT, new String[]{"前台合成", "后台合成"}, new int[]{g.a.FORWARD.value, g.a.BACKGROUND.value}));
        storySettingsUI.hUG.add(new b(storySettingsUI, "裁剪方案", ar.a.USERINFO_TOP_STORY_CROP_TYPE_INT, new String[]{"GPU裁剪", "CPU裁剪"}, new int[]{2, 1}));
        storySettingsUI.hUG.add(new b(storySettingsUI, "CameraApi方案", ar.a.USERINFO_TOP_STORY_CAMERA_API_INT, new String[]{"Camera1", "Camera2"}, new int[]{1, 2}));
        storySettingsUI.hUG.add(new b(storySettingsUI, "编码方案", ar.a.USERINFO_TOP_STORY_ENCODER_TYPE_INT, new String[]{"MediaCodec", "x264"}, new int[]{2, 1}));
        storySettingsUI.hUG.add(new c("一天九张?", "点我", new q()));
        storySettingsUI.hUG.add(new c("新手指引", "点我", new aa()));
        storySettingsUI.hUG.add(new b(storySettingsUI, "视频动态足迹开关", ar.a.USERINFO_STORY_VISITOR_SCHEME_INT, new String[]{"关", "开"}, new int[]{0, 1}));
        storySettingsUI.hUG.add(new c("清空表", "嗯", new ab()));
        LinkedList<e> linkedList = storySettingsUI.hUG;
        com.tencent.mm.plugin.recordvideo.b.e eVar = com.tencent.mm.plugin.recordvideo.b.e.BNm;
        linkedList.add(new c(com.tencent.mm.plugin.recordvideo.b.e.eJt() ? "图片视频不自动合成" : "图片视频自动合成", "嗯", new ac()));
        LinkedList<e> linkedList2 = storySettingsUI.hUG;
        com.tencent.mm.plugin.recordvideo.b.e eVar2 = com.tencent.mm.plugin.recordvideo.b.e.BNm;
        linkedList2.add(new c(com.tencent.mm.plugin.recordvideo.b.e.eJu() ? "视频不重新合成" : "视频重新合成", "嗯", new ad()));
        storySettingsUI.hUG.add(new c(!com.tencent.mm.plugin.story.c.c.BNK ? "强制使用软编码" : "不强制使用软编码", "嗯", new ae()));
        storySettingsUI.hUG.add(new c("软编码超时次数+1", "嗯", new af()));
        storySettingsUI.hUG.add(new c("软编码失败次数+1", "嗯", new ag()));
        storySettingsUI.hUG.add(new c("软编码超时次数-1", "嗯", new g()));
        storySettingsUI.hUG.add(new c("不删除ext, 删除info/room/file", "嗯", new h()));
        storySettingsUI.hUG.add(new c("拉取数据", "嗯", new i()));
        storySettingsUI.hUG.add(new c("所有未读", "嗯", new j()));
        storySettingsUI.hUG.add(new c("查看Story缓存大小", "嗯", new k(storySettingsUI)));
        storySettingsUI.hUG.add(new c("清除Story缓存", "嗯", new l(storySettingsUI)));
        storySettingsUI.hUG.add(new c("同步cache到Sdcard", "嗯", new m(storySettingsUI)));
        storySettingsUI.hUG.add(new c("点我发送后台失败", "嗯 Test", new n(storySettingsUI)));
        storySettingsUI.hUG.add(new c("点我发送超时失败", "嗯 Test", new o(storySettingsUI)));
        storySettingsUI.hUG.add(new c("群视频上拉提示", "再看一下", new p(storySettingsUI)));
        storySettingsUI.hUG.add(new c("冒个泡提示", "再看一次", r.FxB));
        storySettingsUI.hUG.add(new c("首次拍摄", "", s.FxC));
        storySettingsUI.hUG.add(new c("轻触查看", "再来一次", t.FxD));
        storySettingsUI.hUG.add(new c("视频动态过期时长测试", "过期时长设置为1分钟", new u(storySettingsUI)));
        storySettingsUI.hUG.add(new c("重置大嘴巴显示头像时间", "点我", new v()));
        storySettingsUI.hUG.add(new c("删除相册缩略图缓存", "删除", new w(storySettingsUI)));
        storySettingsUI.hUG.add(new c("编辑器", "跳转", new x(storySettingsUI)));
        storySettingsUI.hUG.add(new c("重置视频号朋友圈入口", "点我", new y()));
        storySettingsUI.hUG.add(new c("支付测试ID", "点我", new z(storySettingsUI)));
        View findViewById = storySettingsUI.findViewById(R.id.icd);
        if (findViewById == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.widget.ListView");
            AppMethodBeat.o(119713);
            throw tVar;
        }
        storySettingsUI.hUI = (ListView) findViewById;
        storySettingsUI.Fxr = new a();
        ListView listView = storySettingsUI.hUI;
        if (listView == null) {
            kotlin.g.b.p.hyc();
        }
        a aVar = storySettingsUI.Fxr;
        if (aVar == null) {
            kotlin.g.b.p.btv("adapter");
        }
        listView.setAdapter((ListAdapter) aVar);
        AppMethodBeat.o(119713);
    }
}
