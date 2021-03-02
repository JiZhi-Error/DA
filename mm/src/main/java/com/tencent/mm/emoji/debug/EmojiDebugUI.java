package com.tencent.mm.emoji.debug;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.emoji.a.f;
import com.tencent.mm.emoji.b.a;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.SmileyInfo;
import com.tencent.mm.storage.emotion.SmileyPanelConfigInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.smtt.sdk.WebView;
import java.io.DataOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001b2\u00020\u0001:\b\u0019\u001a\u001b\u001c\u001d\u001e\u001f B\u0005¢\u0006\u0002\u0010\u0002J#\u0010\n\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u0002H\u000bH\u0002¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0011H\u0014J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J#\u0010\u0016\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0017\u001a\u0002H\u000bH\u0002¢\u0006\u0002\u0010\u0018R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0007R\u00020\u00000\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, hxF = {"Lcom/tencent/mm/emoji/debug/EmojiDebugUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "itemList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI$AbsItem;", "recycler", "Landroid/support/v7/widget/RecyclerView;", "getConfig", "T", "key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "defVal", "(Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;Ljava/lang/Object;)Ljava/lang/Object;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setConfig", "value", "(Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;Ljava/lang/Object;)V", "AbsItem", "ClickItem", "Companion", "ConfigItem", "DebugAdapter", "DebugViewHolder", "GetterItem", "GroupItem", "plugin-emojisdk_release"})
public final class EmojiDebugUI extends MMActivity {
    private static boolean gTX;
    private static boolean gTY;
    public static final c gTZ = new c((byte) 0);
    private final String TAG = "MicroMsg.EmojiDebugUI";
    private final LinkedList<a> gTV = new LinkedList<>();
    private RecyclerView gTW;

    static {
        AppMethodBeat.i(161812);
        AppMethodBeat.o(161812);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        AppMethodBeat.at(this, z2);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class x extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        public static final x gUy = new x();

        static {
            AppMethodBeat.i(199851);
            AppMethodBeat.o(199851);
        }

        x() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ kotlin.x invoke() {
            return kotlin.x.SXb;
        }
    }

    public EmojiDebugUI() {
        AppMethodBeat.i(105360);
        AppMethodBeat.o(105360);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/emoji/debug/EmojiDebugUI$Companion;", "", "()V", "stopCDN", "", "getStopCDN", "()Z", "setStopCDN", "(Z)V", "stopCGI", "getStopCGI", "setStopCGI", "plugin-emojisdk_release"})
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.a1s;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        RecyclerView.a adapter;
        AppMethodBeat.i(105359);
        super.onCreate(bundle);
        setBackBtn(new i(this));
        this.gTW = (RecyclerView) findViewById(R.id.bzr);
        RecyclerView recyclerView = this.gTW;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager());
        }
        RecyclerView recyclerView2 = this.gTW;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(new e());
        }
        RecyclerView recyclerView3 = this.gTW;
        if (recyclerView3 != null) {
            recyclerView3.b(new android.support.v7.widget.w(this, 1));
        }
        RecyclerView recyclerView4 = this.gTW;
        if (!(recyclerView4 == null || (adapter = recyclerView4.getAdapter()) == null)) {
            adapter.notifyDataSetChanged();
        }
        this.gTV.add(new d(this, "预览裁剪方式", ar.a.USERINFO_EMOJI_SPRING_FESTIVAL_CROP_TYPE_INT, kotlin.a.j.listOf((Object[]) new String[]{"GPU", "CPU"}), kotlin.a.j.listOf((Object[]) new Integer[]{1, 0})));
        this.gTV.add(new b(this, "临时屏蔽小尾巴", "", new t(this)));
        this.gTV.add(new b(this, "重置自拍更新红点", "", new ad(this)));
        this.gTV.add(new h(this, ""));
        this.gTV.add(new b(this, "Test parse egg", "", ae.gUC));
        this.gTV.add(new b(this, "测试打开网页", "", new af(this)));
        this.gTV.add(new b(this, "测试预加载", "", ag.gUD));
        this.gTV.add(new h(this, ""));
        this.gTV.add(new b(this, "Start Sticker Preview", "", new ah(this)));
        this.gTV.add(new b(this, "copy preview", "", new ai(this)));
        this.gTV.add(new b(this, "Clean Sticker Cache", "", aj.gUE));
        this.gTV.add(new b(this, "test parse", "", new j(this)));
        this.gTV.add(new b(this, "Mock Download Fail", k.gUm, l.gUn));
        this.gTV.add(new h(this, "Emoji Res"));
        this.gTV.add(new b(this, "dump color_emoji", "", new m(this)));
        this.gTV.add(new b(this, "merge color_emoji", "", new n(this)));
        this.gTV.add(new b(this, "parse anim emoji", "", new o(this)));
        this.gTV.add(new b(this, "get smiley", "", new p(this)));
        this.gTV.add(new d(this, "Sticker Panel Switch", ar.a.USERINFO_EMOJI_STICKER_ENABLE_INT, kotlin.a.j.listOf((Object[]) new String[]{"use remote config", "enable", "disable"}), kotlin.a.j.listOf((Object[]) new Integer[]{0, 1, 2})));
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("xlab_effect_config");
        this.gTV.add(new b(this, "Toggle multi thread", String.valueOf(mmkv.getBoolean("multi_thread", false)), new q(this, mmkv)));
        this.gTV.add(new g(this, r.gUv, new s(mmkv), new u(this, mmkv)));
        this.gTV.add(new d(this, "Use CDN?", ar.a.USERINFO_EMOJI_UPLOAD_CDN_INT, kotlin.a.j.listOf((Object[]) new String[]{"remote config", "yes", "no"}), kotlin.a.j.listOf((Object[]) new Integer[]{0, 1, 2})));
        int size = this.gTV.size();
        b bVar = new b(this, "Egg Spring: Stop CGI?", new StringBuilder().append(gTX).toString());
        bVar.gUc = new v(this, size);
        this.gTV.add(bVar);
        int size2 = this.gTV.size();
        b bVar2 = new b(this, "Egg Spring: Stop CDN?", new StringBuilder().append(gTY).toString());
        bVar2.gUc = new w(this, size2);
        this.gTV.add(bVar2);
        this.gTV.add(new b(this, "Egg res Info", "", x.gUy));
        this.gTV.add(new h(this, ""));
        this.gTV.add(new b(this, "GetDesigner", "", y.gUz));
        this.gTV.add(new h(this, "Emoji Suggest"));
        this.gTV.add(new b(this, "Show Words", "", new z(this)));
        this.gTV.add(new b(this, "Clear Cache", "", aa.gUA));
        this.gTV.add(new b(this, "Update Word List", "", ab.gUB));
        this.gTV.add(new b(this, "Emoji Suggest config", "", new ac(this)));
        AppMethodBeat.o(105359);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class i implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ EmojiDebugUI gUa;

        i(EmojiDebugUI emojiDebugUI) {
            this.gUa = emojiDebugUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(105346);
            this.gUa.finish();
            AppMethodBeat.o(105346);
            return true;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b \u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\bH&¨\u0006\n"}, hxF = {"Lcom/tencent/mm/emoji/debug/EmojiDebugUI$AbsItem;", "", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;)V", "onClick", "", "textSize", "", "title", "", "value", "plugin-emojisdk_release"})
    public abstract class a {
        public abstract String auk();

        public abstract void onClick();

        public abstract String value();

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a() {
        }

        public float aul() {
            return 0.0f;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, hxF = {"Lcom/tencent/mm/emoji/debug/EmojiDebugUI$GroupItem;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI$AbsItem;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI;", "title", "", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "onClick", "", "textSize", "", "value", "plugin-emojisdk_release"})
    public final class h extends a {
        final /* synthetic */ EmojiDebugUI gUa;
        private final String title;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(EmojiDebugUI emojiDebugUI, String str) {
            super();
            kotlin.g.b.p.h(str, "title");
            this.gUa = emojiDebugUI;
            AppMethodBeat.i(199836);
            this.title = str;
            AppMethodBeat.o(199836);
        }

        @Override // com.tencent.mm.emoji.debug.EmojiDebugUI.a
        public final String auk() {
            return this.title;
        }

        @Override // com.tencent.mm.emoji.debug.EmojiDebugUI.a
        public final String value() {
            return "";
        }

        @Override // com.tencent.mm.emoji.debug.EmojiDebugUI.a
        public final void onClick() {
        }

        @Override // com.tencent.mm.emoji.debug.EmojiDebugUI.a
        public final float aul() {
            return 30.0f;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B3\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004¢\u0006\u0002\u0010\tJ\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\u0003\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/emoji/debug/EmojiDebugUI$GetterItem;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI$AbsItem;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI;", "title", "Lkotlin/Function0;", "", "value", "onClick", "", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "getTitle", "getValue", "plugin-emojisdk_release"})
    public final class g extends a {
        final /* synthetic */ EmojiDebugUI gUa;
        private final kotlin.g.a.a<kotlin.x> gUc;
        private final kotlin.g.a.a<String> gUk;
        private final kotlin.g.a.a<String> gUl;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(EmojiDebugUI emojiDebugUI, kotlin.g.a.a<String> aVar, kotlin.g.a.a<String> aVar2, kotlin.g.a.a<kotlin.x> aVar3) {
            super();
            kotlin.g.b.p.h(aVar, "title");
            kotlin.g.b.p.h(aVar2, "value");
            this.gUa = emojiDebugUI;
            AppMethodBeat.i(105345);
            this.gUk = aVar;
            this.gUl = aVar2;
            this.gUc = aVar3;
            AppMethodBeat.o(105345);
        }

        @Override // com.tencent.mm.emoji.debug.EmojiDebugUI.a
        public final String auk() {
            AppMethodBeat.i(105342);
            String invoke = this.gUk.invoke();
            AppMethodBeat.o(105342);
            return invoke;
        }

        @Override // com.tencent.mm.emoji.debug.EmojiDebugUI.a
        public final String value() {
            AppMethodBeat.i(105343);
            String invoke = this.gUl.invoke();
            AppMethodBeat.o(105343);
            return invoke;
        }

        @Override // com.tencent.mm.emoji.debug.EmojiDebugUI.a
        public final void onClick() {
            AppMethodBeat.i(105344);
            kotlin.g.a.a<kotlin.x> aVar = this.gUc;
            if (aVar != null) {
                aVar.invoke();
                AppMethodBeat.o(105344);
                return;
            }
            AppMethodBeat.o(105344);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B)\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tB-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\u000bJ\b\u0010\u0006\u001a\u00020\bH\u0016J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u000e\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000f¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/emoji/debug/EmojiDebugUI$ClickItem;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI$AbsItem;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI;", "title", "", "value", "onClick", "Lkotlin/Function0;", "", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "valueGetter", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "setOnClick", "(Lkotlin/jvm/functions/Function0;)V", "getTitle", "()Ljava/lang/String;", "getValueGetter", "setValueGetter", "updateValue", "plugin-emojisdk_release"})
    public final class b extends a {
        final /* synthetic */ EmojiDebugUI gUa;
        private kotlin.g.a.a<String> gUb;
        kotlin.g.a.a<kotlin.x> gUc;
        private final String title;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(EmojiDebugUI emojiDebugUI, String str, kotlin.g.a.a<String> aVar, kotlin.g.a.a<kotlin.x> aVar2) {
            super();
            kotlin.g.b.p.h(str, "title");
            kotlin.g.b.p.h(aVar, "valueGetter");
            this.gUa = emojiDebugUI;
            AppMethodBeat.i(177044);
            this.title = str;
            this.gUb = aVar;
            this.gUc = aVar2;
            AppMethodBeat.o(177044);
        }

        public /* synthetic */ b(EmojiDebugUI emojiDebugUI, String str, String str2) {
            this(emojiDebugUI, str, str2, (kotlin.g.a.a<kotlin.x>) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public b(EmojiDebugUI emojiDebugUI, String str, final String str2, kotlin.g.a.a<kotlin.x> aVar) {
            this(emojiDebugUI, str, new kotlin.g.a.a<String>() {
                /* class com.tencent.mm.emoji.debug.EmojiDebugUI.b.AnonymousClass1 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* bridge */ /* synthetic */ String invoke() {
                    return str2;
                }
            }, aVar);
            kotlin.g.b.p.h(str, "title");
            kotlin.g.b.p.h(str2, "value");
            AppMethodBeat.i(105332);
            AppMethodBeat.o(105332);
        }

        @Override // com.tencent.mm.emoji.debug.EmojiDebugUI.a
        public final String auk() {
            return this.title;
        }

        @Override // com.tencent.mm.emoji.debug.EmojiDebugUI.a
        public final String value() {
            AppMethodBeat.i(177043);
            String invoke = this.gUb.invoke();
            AppMethodBeat.o(177043);
            return invoke;
        }

        @Override // com.tencent.mm.emoji.debug.EmojiDebugUI.a
        public final void onClick() {
            RecyclerView.a adapter;
            AppMethodBeat.i(105331);
            kotlin.g.a.a<kotlin.x> aVar = this.gUc;
            if (aVar != null) {
                aVar.invoke();
            }
            RecyclerView recyclerView = this.gUa.gTW;
            if (recyclerView == null || (adapter = recyclerView.getAdapter()) == null) {
                AppMethodBeat.o(105331);
                return;
            }
            adapter.notifyDataSetChanged();
            AppMethodBeat.o(105331);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00060\u0002R\u00020\u0003B1\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0002\u0010\u000bJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/emoji/debug/EmojiDebugUI$ConfigItem;", "T", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI$AbsItem;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI;", "title", "", "configKey", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "contentArray", "", "valueArray", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;Ljava/lang/String;Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;Ljava/util/List;Ljava/util/List;)V", "getConfigKey", "()Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "getContentArray", "()Ljava/util/List;", "getTitle", "()Ljava/lang/String;", "getValueArray", "onClick", "", "value", "plugin-emojisdk_release"})
    public final class d<T> extends a {
        final /* synthetic */ EmojiDebugUI gUa;
        final ar.a gUe;
        private final List<String> gUf;
        final List<T> gUg;
        private final String title;

        /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: java.util.List<? extends T> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(EmojiDebugUI emojiDebugUI, String str, ar.a aVar, List<String> list, List<? extends T> list2) {
            super();
            kotlin.g.b.p.h(str, "title");
            kotlin.g.b.p.h(aVar, "configKey");
            kotlin.g.b.p.h(list, "contentArray");
            kotlin.g.b.p.h(list2, "valueArray");
            this.gUa = emojiDebugUI;
            AppMethodBeat.i(105336);
            this.title = str;
            this.gUe = aVar;
            this.gUf = list;
            this.gUg = list2;
            AppMethodBeat.o(105336);
        }

        @Override // com.tencent.mm.emoji.debug.EmojiDebugUI.a
        public final String auk() {
            return this.title;
        }

        @Override // com.tencent.mm.emoji.debug.EmojiDebugUI.a
        public final String value() {
            AppMethodBeat.i(105334);
            int indexOf = this.gUg.indexOf(EmojiDebugUI.a(this.gUe, this.gUg.get(0)));
            if (indexOf < 0 || indexOf >= this.gUf.size()) {
                String str = this.gUf.get(0);
                AppMethodBeat.o(105334);
                return str;
            }
            String str2 = this.gUf.get(indexOf);
            AppMethodBeat.o(105334);
            return str2;
        }

        @Override // com.tencent.mm.emoji.debug.EmojiDebugUI.a
        public final void onClick() {
            AppMethodBeat.i(105335);
            LinkedList linkedList = new LinkedList();
            int size = this.gUf.size();
            for (int i2 = 0; i2 < size; i2++) {
                linkedList.add(Integer.valueOf(i2));
            }
            com.tencent.mm.ui.base.h.a(this.gUa, "", this.gUf, kotlin.a.j.p(kotlin.a.j.r((Collection<?>) this.gUf)), "", new a(this));
            AppMethodBeat.o(105335);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "T", "whichButton", "", "resultId", "onClick"})
        static final class a implements h.e {
            final /* synthetic */ d gUh;

            a(d dVar) {
                this.gUh = dVar;
            }

            @Override // com.tencent.mm.ui.base.h.e
            public final void cy(int i2, int i3) {
                RecyclerView.a adapter;
                AppMethodBeat.i(105333);
                EmojiDebugUI.b(this.gUh.gUe, this.gUh.gUg.get(i3));
                RecyclerView recyclerView = this.gUh.gUa.gTW;
                if (recyclerView == null || (adapter = recyclerView.getAdapter()) == null) {
                    AppMethodBeat.o(105333);
                    return;
                }
                adapter.notifyDataSetChanged();
                AppMethodBeat.o(105333);
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u001c\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u001c\u0010\u000b\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/emoji/debug/EmojiDebugUI$DebugAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI$DebugViewHolder;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI;", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-emojisdk_release"})
    public final class e extends RecyclerView.a<f> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public e() {
        }

        /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ f a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(105338);
            kotlin.g.b.p.h(viewGroup, "parent");
            AppCompatTextView appCompatTextView = new AppCompatTextView(viewGroup.getContext());
            appCompatTextView.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, com.tencent.mm.cb.a.fromDPToPix(viewGroup.getContext(), 48)));
            appCompatTextView.setTextColor(WebView.NIGHT_MODE_COLOR);
            appCompatTextView.setGravity(17);
            appCompatTextView.setTextSize(2, 18.0f);
            f fVar = new f(EmojiDebugUI.this, appCompatTextView);
            AppMethodBeat.o(105338);
            return fVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void a(f fVar, int i2) {
            AppMethodBeat.i(105340);
            f fVar2 = fVar;
            kotlin.g.b.p.h(fVar2, "holder");
            float aul = ((a) EmojiDebugUI.this.gTV.get(i2)).aul();
            fVar2.vr.setText(((a) EmojiDebugUI.this.gTV.get(i2)).auk() + ": " + ((a) EmojiDebugUI.this.gTV.get(i2)).value());
            fVar2.vr.setBackgroundResource(R.drawable.aol);
            if (aul > 0.0f) {
                fVar2.vr.setTextSize(aul);
            } else {
                fVar2.vr.setTextSize(2, 18.0f);
            }
            fVar2.vr.setOnClickListener(new a(this, i2));
            AppMethodBeat.o(105340);
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            AppMethodBeat.i(105339);
            int size = EmojiDebugUI.this.gTV.size();
            AppMethodBeat.o(105339);
            return size;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        static final class a implements View.OnClickListener {
            final /* synthetic */ e gUi;
            final /* synthetic */ int gUj;

            a(e eVar, int i2) {
                this.gUi = eVar;
                this.gUj = i2;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(105337);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/emoji/debug/EmojiDebugUI$DebugAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ((a) EmojiDebugUI.this.gTV.get(this.gUj)).onClick();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/emoji/debug/EmojiDebugUI$DebugAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(105337);
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, hxF = {"Lcom/tencent/mm/emoji/debug/EmojiDebugUI$DebugViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/widget/TextView;", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;Landroid/widget/TextView;)V", "textView", "getTextView", "()Landroid/widget/TextView;", "plugin-emojisdk_release"})
    public final class f extends RecyclerView.v {
        final /* synthetic */ EmojiDebugUI gUa;
        final TextView vr;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(EmojiDebugUI emojiDebugUI, TextView textView) {
            super(textView);
            kotlin.g.b.p.h(textView, "itemView");
            this.gUa = emojiDebugUI;
            AppMethodBeat.i(105341);
            this.vr = textView;
            AppMethodBeat.o(105341);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class t extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ EmojiDebugUI gUa;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        t(EmojiDebugUI emojiDebugUI) {
            super(0);
            this.gUa = emojiDebugUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(105349);
            com.tencent.mm.n.h.aqJ().put("ForbiddenEmotionSpringFestivalMsgTail", "1");
            com.tencent.mm.ui.base.u.makeText(this.gUa, "微信重启后，会恢复后台配置", 0).show();
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(105349);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class ad extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ EmojiDebugUI gUa;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ad(EmojiDebugUI emojiDebugUI) {
            super(0);
            this.gUa = emojiDebugUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(105350);
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_EMOJI_CAPTURE_TAB_RED_DOT_BOOLEAN, Boolean.FALSE);
            com.tencent.mm.ui.base.u.makeText(this.gUa, "done", 0).show();
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(105350);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class ae extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        public static final ae gUC = new ae();

        static {
            AppMethodBeat.i(105352);
            AppMethodBeat.o(105352);
        }

        ae() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(105351);
            com.tencent.mm.bb.g f2 = com.tencent.mm.emoji.e.b.f(new com.tencent.mm.vfs.o("/sdcard/temp/egg.xml"));
            if (f2 != null) {
                com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class);
                kotlin.g.b.p.g(ah, "MMKernel.plugin(IPluginEmoji::class.java)");
                com.tencent.mm.pluginsdk.a.d emojiMgr = ((com.tencent.mm.plugin.emoji.b.d) ah).getEmojiMgr();
                kotlin.g.b.p.g(emojiMgr, "MMKernel.plugin(IPluginEmoji::class.java).emojiMgr");
                com.tencent.mm.bb.g cFL = emojiMgr.cFL();
                cFL.jgT = f2.jgT;
                cFL.jgS.clear();
                Iterator<com.tencent.mm.bb.e> it = f2.jgS.iterator();
                while (it.hasNext()) {
                    com.tencent.mm.bb.e next = it.next();
                    if (next.jgP <= 6) {
                        cFL.jgS.add(next);
                    }
                }
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(105351);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class af extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ EmojiDebugUI gUa;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        af(EmojiDebugUI emojiDebugUI) {
            super(0);
            this.gUa = emojiDebugUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(105353);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", "https://game.weixin.qq.com/cgi-bin/h5/static/act_dnfm/index.html?noticeid=90248502&wechat_pkgid=act_dnfm_index&actid=138433&nav_color=F2D8AB&darkmode_nav_color=F2D8AB&hide_share_option=1#wechat_redirect");
            intent.putExtra("from_shortcut", true);
            intent.putExtra("disable_minimize", true);
            intent.putExtra("MMActivity.OverrideEnterAnimation", R.anim.s);
            intent.putExtra("MMActivity.OverrideExitAnimation", R.anim.f6do);
            com.tencent.mm.br.c.b(this.gUa, "webview", ".ui.tools.WebViewUI", intent, 1001);
            this.gUa.overridePendingTransition(R.anim.dq, R.anim.s);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(105353);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class ag extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        public static final ag gUD = new ag();

        static {
            AppMethodBeat.i(105355);
            AppMethodBeat.o(105355);
        }

        ag() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(105354);
            ((com.tencent.mm.plugin.eggspring.a.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.eggspring.a.a.class)).prefetch("https://game.weixin.qq.com/cgi-bin/h5/static/act_dnfm/index.html?noticeid=90248502&wechat_pkgid=act_dnfm_index&actid=138433&nav_color=F2D8AB&darkmode_nav_color=F2D8AB&hide_share_option=1#wechat_redirect");
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(105354);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class ah extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ EmojiDebugUI gUa;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ah(EmojiDebugUI emojiDebugUI) {
            super(0);
            this.gUa = emojiDebugUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(105356);
            com.tencent.mm.plugin.emojicapture.api.b.fa(this.gUa);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(105356);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class ai extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ EmojiDebugUI gUa;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ai(EmojiDebugUI emojiDebugUI) {
            super(0);
            this.gUa = emojiDebugUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(177049);
            StringBuilder sb = new StringBuilder();
            com.tencent.mm.sticker.loader.e eVar = com.tencent.mm.sticker.loader.e.NNN;
            String sb2 = sb.append(com.tencent.mm.sticker.loader.e.gyY()).append("preview/").toString();
            if (com.tencent.mm.vfs.s.YS(sb2)) {
                File externalCacheDir = this.gUa.getExternalCacheDir();
                String I = kotlin.g.b.p.I(externalCacheDir != null ? externalCacheDir.getAbsolutePath() : null, "/preview.zip");
                com.tencent.mm.vfs.s.nz(sb2, I);
                Toast.makeText(this.gUa, I, 1).show();
                ClipboardHelper.setText(I);
            } else {
                Toast.makeText(this.gUa, "no file", 1).show();
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(177049);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class aj extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        public static final aj gUE = new aj();

        static {
            AppMethodBeat.i(199860);
            AppMethodBeat.o(199860);
        }

        aj() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(105358);
            com.tencent.mm.sticker.loader.e eVar = com.tencent.mm.sticker.loader.e.NNN;
            com.tencent.mm.vfs.s.deleteDir(com.tencent.mm.sticker.loader.e.gyW());
            com.tencent.mm.sticker.a.b bVar = com.tencent.mm.sticker.a.b.NOi;
            com.tencent.mm.sticker.a.b.gzh();
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(105358);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class j extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ EmojiDebugUI gUa;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(EmojiDebugUI emojiDebugUI) {
            super(0);
            this.gUa = emojiDebugUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(105347);
            StringBuilder sb = new StringBuilder();
            com.tencent.mm.sticker.loader.e eVar = com.tencent.mm.sticker.loader.e.NNN;
            String sb2 = sb.append(com.tencent.mm.sticker.loader.e.gyY()).append("preview/").toString();
            com.tencent.mm.vfs.s.deleteDir(sb2);
            com.tencent.mm.vfs.s.boN(sb2);
            com.tencent.mm.vfs.s.fW("/sdcard/temp/sticker/output.zip", sb2);
            com.tencent.mm.sticker.f fVar = new com.tencent.mm.sticker.f();
            fVar.bip(sb2);
            fVar.biq("preview");
            fVar.bis(sb2);
            com.tencent.mm.sticker.f fVar2 = new com.tencent.mm.sticker.f();
            fVar2.bip(sb2);
            fVar2.bir(sb2);
            Log.i(this.gUa.TAG, "pack: " + fVar.NNv.size() + ", " + fVar2.NNv.size());
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(105347);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class k extends kotlin.g.b.q implements kotlin.g.a.a<String> {
        public static final k gUm = new k();

        static {
            AppMethodBeat.i(105348);
            AppMethodBeat.o(105348);
        }

        k() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            AppMethodBeat.i(161810);
            com.tencent.mm.emoji.loader.e eVar = com.tencent.mm.emoji.loader.e.gVM;
            String valueOf = String.valueOf(com.tencent.mm.emoji.loader.e.auB());
            AppMethodBeat.o(161810);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class l extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        public static final l gUn = new l();

        static {
            AppMethodBeat.i(199837);
            AppMethodBeat.o(199837);
        }

        l() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            boolean z;
            AppMethodBeat.i(161811);
            com.tencent.mm.emoji.loader.e eVar = com.tencent.mm.emoji.loader.e.gVM;
            com.tencent.mm.emoji.loader.e eVar2 = com.tencent.mm.emoji.loader.e.gVM;
            if (!com.tencent.mm.emoji.loader.e.auB()) {
                z = true;
            } else {
                z = false;
            }
            com.tencent.mm.emoji.loader.e.dO(z);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(161811);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class m extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ EmojiDebugUI gUa;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(EmojiDebugUI emojiDebugUI) {
            super(0);
            this.gUa = emojiDebugUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(177046);
            com.tencent.mm.ce.b gxI = com.tencent.mm.ce.b.gxI();
            kotlin.g.b.p.g(gxI, "EmojiHelper.getInstance()");
            final com.tencent.mm.ce.a gxJ = gxI.gxJ();
            com.tencent.mm.ce.b gxI2 = com.tencent.mm.ce.b.gxI();
            kotlin.g.b.p.g(gxI2, "EmojiHelper.getInstance()");
            final int offset = gxI2.getOffset();
            Log.i(this.gUa.TAG, "emojiRes: " + gxJ.NKr.size() + ", " + gxJ.NKs.size() + ", " + offset);
            String str = this.gUa.TAG;
            StringBuilder sb = new StringBuilder("emoji Ranges : ");
            List<com.tencent.mm.ce.d> subList = gxJ.NKr.subList(0, Math.min(10, gxJ.NKr.size()));
            kotlin.g.b.p.g(subList, "header.emojiRanges.subLi…header.emojiRanges.size))");
            Log.i(str, sb.append(kotlin.a.j.a(subList, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, AnonymousClass1.gUo, 31)).toString());
            String str2 = this.gUa.TAG;
            StringBuilder sb2 = new StringBuilder("emoji Items: ");
            List<com.tencent.mm.ce.c> subList2 = gxJ.NKs.subList(0, Math.min(10, gxJ.NKs.size()));
            kotlin.g.b.p.g(subList2, "header.emojiItems.subLis… header.emojiItems.size))");
            Log.i(str2, sb2.append(kotlin.a.j.a(subList2, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, AnonymousClass2.gUp, 31)).toString());
            com.tencent.mm.ac.d.i(new kotlin.g.a.a<kotlin.x>(this) {
                /* class com.tencent.mm.emoji.debug.EmojiDebugUI.m.AnonymousClass3 */
                final /* synthetic */ m gUq;

                {
                    this.gUq = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ kotlin.x invoke() {
                    AppMethodBeat.i(199843);
                    com.tencent.mm.vfs.s.deleteDir("/sdcard/temp/emojiRes/origin/");
                    com.tencent.mm.vfs.s.deleteDir("/sdcard/temp/emojiRes/smiley/");
                    com.tencent.mm.vfs.s.boN("/sdcard/temp/emojiRes/origin/");
                    com.tencent.mm.vfs.s.boN("/sdcard/temp/emojiRes/smiley/");
                    LinkedList<com.tencent.mm.ce.c> linkedList = gxJ.NKs;
                    kotlin.g.b.p.g(linkedList, "header.emojiItems");
                    int i2 = 0;
                    for (T t : linkedList) {
                        int i3 = i2 + 1;
                        if (i2 < 0) {
                            kotlin.a.j.hxH();
                        }
                        T t2 = t;
                        byte[] aW = com.tencent.mm.vfs.s.aW(com.tencent.mm.ce.b.NKu, t2.bNu + offset, t2.size);
                        com.tencent.mm.vfs.s.C("/sdcard/temp/emojiRes/origin/" + i2 + ".png", aW);
                        if (t2.NKP >= 0) {
                            Log.i(this.gUq.gUa.TAG, "name: " + i2 + ' ' + t2.NKP);
                        }
                        if (t2.owH == 0) {
                            Log.i(this.gUq.gUa.TAG, "smiley: " + i2 + ' ' + t2.NKQ);
                            com.tencent.mm.vfs.s.C("/sdcard/temp/emojiRes/smiley/" + t2.NKQ + ".png", aW);
                        }
                        i2 = i3;
                    }
                    String str = this.gUq.gUa.TAG;
                    StringBuilder sb = new StringBuilder("emoji Items: ");
                    LinkedList<com.tencent.mm.ce.c> linkedList2 = gxJ.NKs;
                    kotlin.g.b.p.g(linkedList2, "header.emojiItems");
                    StringBuilder append = sb.append(linkedList2.getLast().bNu).append(" ");
                    LinkedList<com.tencent.mm.ce.c> linkedList3 = gxJ.NKs;
                    kotlin.g.b.p.g(linkedList3, "header.emojiItems");
                    Log.i(str, append.append(linkedList3.getLast().size).toString());
                    com.tencent.mm.ac.d.h(new kotlin.g.a.a<kotlin.x>(this) {
                        /* class com.tencent.mm.emoji.debug.EmojiDebugUI.m.AnonymousClass3.AnonymousClass1 */
                        final /* synthetic */ AnonymousClass3 gUt;

                        {
                            this.gUt = r2;
                        }

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.g.a.a
                        public final /* synthetic */ kotlin.x invoke() {
                            AppMethodBeat.i(199842);
                            Toast.makeText(this.gUt.gUq.gUa, "done", 0).show();
                            kotlin.x xVar = kotlin.x.SXb;
                            AppMethodBeat.o(199842);
                            return xVar;
                        }
                    });
                    kotlin.x xVar = kotlin.x.SXb;
                    AppMethodBeat.o(199843);
                    return xVar;
                }
            });
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(177046);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class n extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ EmojiDebugUI gUa;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(EmojiDebugUI emojiDebugUI) {
            super(0);
            this.gUa = emojiDebugUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            Throwable th;
            Throwable th2;
            Throwable th3;
            AppMethodBeat.i(177047);
            com.tencent.mm.ce.b gxI = com.tencent.mm.ce.b.gxI();
            kotlin.g.b.p.g(gxI, "EmojiHelper.getInstance()");
            com.tencent.mm.ce.a gxJ = gxI.gxJ();
            kotlin.g.b.p.g(com.tencent.mm.ce.b.gxI(), "EmojiHelper.getInstance()");
            com.tencent.mm.vfs.s.deleteFile("/sdcard/temp/emojiRes/neaFileContent");
            com.tencent.mm.vfs.s.deleteFile("/sdcard/temp/emojiRes/newFile");
            com.tencent.mm.vfs.s.bpa("/sdcard/temp/emojiRes/neaFileContent");
            com.tencent.mm.vfs.s.bpa("/sdcard/temp/emojiRes/newFile");
            LinkedList<com.tencent.mm.ce.c> linkedList = gxJ.NKs;
            kotlin.g.b.p.g(linkedList, "header.emojiItems");
            int i2 = 0;
            int i3 = 0;
            for (T t : linkedList) {
                int i4 = i2 + 1;
                if (i2 < 0) {
                    kotlin.a.j.hxH();
                }
                T t2 = t;
                String str = "/sdcard/temp/emojiRes/origin/" + i2 + ".png";
                long boW = com.tencent.mm.vfs.s.boW(str);
                if (t2.owH == 0) {
                    Log.i(this.gUa.TAG, "merge : skip " + i2 + ", " + t2.NKQ);
                } else {
                    com.tencent.mm.vfs.s.A("/sdcard/temp/emojiRes/neaFileContent", com.tencent.mm.vfs.s.aW(str, 0, -1));
                }
                if (t2.bNu != i3) {
                    Log.i(this.gUa.TAG, "merge : start change ".concat(String.valueOf(i2)));
                    t2.bNu = i3;
                }
                t2.size = (int) boW;
                i2 = i4;
                i3 = t2.size + i3;
            }
            byte[] byteArray = gxJ.toByteArray();
            OutputStream LM = com.tencent.mm.vfs.s.LM("/sdcard/temp/emojiRes/newFile");
            try {
                DataOutputStream dataOutputStream = new DataOutputStream(LM);
                Throwable th4 = null;
                try {
                    DataOutputStream dataOutputStream2 = dataOutputStream;
                    dataOutputStream2.writeInt(1);
                    dataOutputStream2.writeLong(1480413681119L);
                    dataOutputStream2.writeInt(byteArray.length);
                    dataOutputStream2.write(byteArray);
                    dataOutputStream2.write(com.tencent.mm.vfs.s.aW("/sdcard/temp/emojiRes/neaFileContent", 0, -1));
                    kotlin.x xVar = kotlin.x.SXb;
                    kotlin.f.b.a(dataOutputStream, null);
                    kotlin.x xVar2 = kotlin.x.SXb;
                    kotlin.f.b.a(LM, null);
                    String str2 = this.gUa.TAG;
                    StringBuilder sb = new StringBuilder("merge: result ");
                    LinkedList<com.tencent.mm.ce.c> linkedList2 = gxJ.NKs;
                    kotlin.g.b.p.g(linkedList2, "header.emojiItems");
                    StringBuilder append = sb.append(linkedList2.getLast().bNu).append(", ");
                    LinkedList<com.tencent.mm.ce.c> linkedList3 = gxJ.NKs;
                    kotlin.g.b.p.g(linkedList3, "header.emojiItems");
                    Log.i(str2, append.append(linkedList3.getLast().size).toString());
                    com.tencent.mm.ce.b.gxI().init();
                    kotlin.x xVar3 = kotlin.x.SXb;
                    AppMethodBeat.o(177047);
                    return xVar3;
                } catch (Throwable th5) {
                    th3 = th5;
                    th4 = th;
                    kotlin.f.b.a(dataOutputStream, th4);
                    AppMethodBeat.o(177047);
                    throw th3;
                }
            } catch (Throwable th6) {
                th = th6;
                th2 = th;
                kotlin.f.b.a(LM, th2);
                AppMethodBeat.o(177047);
                throw th;
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class o extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ EmojiDebugUI gUa;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        o(EmojiDebugUI emojiDebugUI) {
            super(0);
            this.gUa = emojiDebugUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(183949);
            a.C0319a aVar = com.tencent.mm.emoji.b.a.gWU;
            f.a aVar2 = com.tencent.mm.emoji.a.f.gVz;
            a.C0319a.a("/sdcard/temp/emojiRes/emoji-anim.xml", com.tencent.mm.emoji.a.f.gVy);
            String str = this.gUa.TAG;
            StringBuilder sb = new StringBuilder("parse anim: ");
            f.a aVar3 = com.tencent.mm.emoji.a.f.gVz;
            Log.i(str, sb.append(com.tencent.mm.emoji.a.f.gVy.gUV.size()).toString());
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(183949);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class p extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ EmojiDebugUI gUa;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        p(EmojiDebugUI emojiDebugUI) {
            super(0);
            this.gUa = emojiDebugUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(199844);
            com.tencent.mm.ce.e gxR = com.tencent.mm.ce.e.gxR();
            kotlin.g.b.p.g(gxR, "MergerSmileyManager.getInstance()");
            List<SmileyPanelConfigInfo> gxS = gxR.gxS();
            kotlin.g.b.p.g(gxS, "info");
            for (T t : gxS) {
                SmileyInfo bii = com.tencent.mm.ce.f.gxT().bii(((SmileyPanelConfigInfo) t).field_key);
                String bib = com.tencent.mm.ce.b.gxI().bib(((SmileyPanelConfigInfo) t).field_key);
                if (bii == null) {
                    StringBuilder sb = new StringBuilder("\\\\u");
                    String num = Integer.toString(((SmileyPanelConfigInfo) t).field_key.codePoints().toArray()[0], kotlin.n.a.avR(16));
                    kotlin.g.b.p.g(num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
                    String sb2 = sb.append(num).toString();
                    String str = ((SmileyPanelConfigInfo) t).field_key;
                    kotlin.g.b.p.g(str, "it.field_key");
                    Charset charset = kotlin.n.d.UTF_8;
                    if (str == null) {
                        kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type java.lang.String");
                        AppMethodBeat.o(199844);
                        throw tVar;
                    }
                    byte[] bytes = str.getBytes(charset);
                    kotlin.g.b.p.g(bytes, "(this as java.lang.String).getBytes(charset)");
                    byte[] encode = Base64.encode(bytes, 0);
                    kotlin.g.b.p.g(encode, "Base64.encode(it.field_k…eArray(), Base64.DEFAULT)");
                    new String(encode, kotlin.n.d.UTF_8);
                    Log.i(this.gUa.TAG, "smiley key : " + ((SmileyPanelConfigInfo) t).field_key + ", " + sb2 + ", " + bib);
                }
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(199844);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class q extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ EmojiDebugUI gUa;
        final /* synthetic */ MultiProcessMMKV gUu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        q(EmojiDebugUI emojiDebugUI, MultiProcessMMKV multiProcessMMKV) {
            super(0);
            this.gUa = emojiDebugUI;
            this.gUu = multiProcessMMKV;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            RecyclerView.a adapter;
            boolean z = false;
            AppMethodBeat.i(199845);
            MultiProcessMMKV multiProcessMMKV = this.gUu;
            if (!this.gUu.getBoolean("multi_thread", false)) {
                z = true;
            }
            multiProcessMMKV.putBoolean("multi_thread", z);
            RecyclerView recyclerView = this.gUa.gTW;
            if (!(recyclerView == null || (adapter = recyclerView.getAdapter()) == null)) {
                adapter.notifyDataSetChanged();
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(199845);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class r extends kotlin.g.b.q implements kotlin.g.a.a<String> {
        public static final r gUv = new r();

        static {
            AppMethodBeat.i(199846);
            AppMethodBeat.o(199846);
        }

        r() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ String invoke() {
            return "enable";
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class s extends kotlin.g.b.q implements kotlin.g.a.a<String> {
        final /* synthetic */ MultiProcessMMKV gUu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        s(MultiProcessMMKV multiProcessMMKV) {
            super(0);
            this.gUu = multiProcessMMKV;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            AppMethodBeat.i(199847);
            String valueOf = String.valueOf(this.gUu.getBoolean("effect", true));
            AppMethodBeat.o(199847);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class u extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ EmojiDebugUI gUa;
        final /* synthetic */ MultiProcessMMKV gUu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        u(EmojiDebugUI emojiDebugUI, MultiProcessMMKV multiProcessMMKV) {
            super(0);
            this.gUa = emojiDebugUI;
            this.gUu = multiProcessMMKV;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            RecyclerView.a adapter;
            boolean z = true;
            AppMethodBeat.i(199848);
            MultiProcessMMKV multiProcessMMKV = this.gUu;
            if (this.gUu.getBoolean("effect", true)) {
                z = false;
            }
            multiProcessMMKV.putBoolean("effect", z);
            RecyclerView recyclerView = this.gUa.gTW;
            if (!(recyclerView == null || (adapter = recyclerView.getAdapter()) == null)) {
                adapter.notifyDataSetChanged();
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(199848);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class v extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ EmojiDebugUI gUa;
        final /* synthetic */ int gUw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        v(EmojiDebugUI emojiDebugUI, int i2) {
            super(0);
            this.gUa = emojiDebugUI;
            this.gUw = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            boolean z;
            AppMethodBeat.i(199849);
            c cVar = EmojiDebugUI.gTZ;
            c cVar2 = EmojiDebugUI.gTZ;
            if (!EmojiDebugUI.gTX) {
                z = true;
            } else {
                z = false;
            }
            EmojiDebugUI.gTX = z;
            RecyclerView recyclerView = this.gUa.gTW;
            RecyclerView.a adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.emoji.debug.EmojiDebugUI.DebugAdapter");
                AppMethodBeat.o(199849);
                throw tVar;
            }
            ((e) adapter).ci(this.gUw);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(199849);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class w extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ EmojiDebugUI gUa;
        final /* synthetic */ int gUx;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        w(EmojiDebugUI emojiDebugUI, int i2) {
            super(0);
            this.gUa = emojiDebugUI;
            this.gUx = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            boolean z;
            AppMethodBeat.i(199850);
            c cVar = EmojiDebugUI.gTZ;
            c cVar2 = EmojiDebugUI.gTZ;
            if (!EmojiDebugUI.gTY) {
                z = true;
            } else {
                z = false;
            }
            EmojiDebugUI.gTY = z;
            RecyclerView recyclerView = this.gUa.gTW;
            RecyclerView.a adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.emoji.debug.EmojiDebugUI.DebugAdapter");
                AppMethodBeat.o(199850);
                throw tVar;
            }
            ((e) adapter).ci(this.gUx);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(199850);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class y extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        public static final y gUz = new y();

        static {
            AppMethodBeat.i(199853);
            AppMethodBeat.o(199853);
        }

        y() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(199852);
            new com.tencent.mm.emoji.sync.d().start();
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(199852);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class z extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ EmojiDebugUI gUa;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        z(EmojiDebugUI emojiDebugUI) {
            super(0);
            this.gUa = emojiDebugUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(199854);
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder("version: ");
            com.tencent.mm.emoji.b.c.g gVar = com.tencent.mm.emoji.b.c.g.gZH;
            StringBuilder append = sb.append(sb2.append(com.tencent.mm.emoji.b.c.g.avK()).append('\n').toString());
            StringBuilder sb3 = new StringBuilder("type: ");
            com.tencent.mm.emoji.b.c.g gVar2 = com.tencent.mm.emoji.b.c.g.gZH;
            StringBuilder append2 = append.append(sb3.append(com.tencent.mm.emoji.b.c.g.avJ()).append('\n').toString());
            StringBuilder sb4 = new StringBuilder("size: ");
            com.tencent.mm.emoji.b.c.g gVar3 = com.tencent.mm.emoji.b.c.g.gZH;
            StringBuilder append3 = append2.append(sb4.append(com.tencent.mm.emoji.b.c.g.avM().size()).append('\n').toString());
            StringBuilder sb5 = new StringBuilder("updateTime: ");
            com.tencent.mm.emoji.b.k kVar = com.tencent.mm.emoji.b.k.gXr;
            StringBuilder append4 = append3.append(sb5.append(Util.formatUnixTime((long) com.tencent.mm.emoji.b.k.auR())).append('\n').toString());
            com.tencent.mm.emoji.b.c.g gVar4 = com.tencent.mm.emoji.b.c.g.gZH;
            append4.append(kotlin.a.j.a(com.tencent.mm.emoji.b.c.g.avM(), "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 62));
            new f.a(this.gUa).bow(sb.toString()).Dq(true).show();
            bj gCJ = bj.gCJ();
            kotlin.g.b.p.g(gCJ, "EmojiStorageMgr.getInstance()");
            gCJ.gCO().dump();
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(199854);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class aa extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        public static final aa gUA = new aa();

        static {
            AppMethodBeat.i(199856);
            AppMethodBeat.o(199856);
        }

        aa() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(199855);
            bj gCJ = bj.gCJ();
            kotlin.g.b.p.g(gCJ, "EmojiStorageMgr.getInstance()");
            com.tencent.mm.storage.emotion.g gCO = gCJ.gCO();
            gCO.jNx.clear();
            gCO.db.delete(com.tencent.mm.storage.emotion.g.OsG, null, null);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(199855);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class ab extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        public static final ab gUB = new ab();

        static {
            AppMethodBeat.i(199858);
            AppMethodBeat.o(199858);
        }

        ab() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(199857);
            com.tencent.mm.emoji.b.c.i iVar = com.tencent.mm.emoji.b.c.i.gZJ;
            com.tencent.mm.emoji.b.c.i.avO();
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(199857);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class ac extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ EmojiDebugUI gUa;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ac(EmojiDebugUI emojiDebugUI) {
            super(0);
            this.gUa = emojiDebugUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(199859);
            StringBuilder sb = new StringBuilder();
            boolean a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_emoji_suggest_remote_enable, false);
            int a3 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_emoji_suggest_remote_request_interval, 24);
            int a4 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_emoji_suggest_remote_prefetch, 0);
            int a5 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_emoji_suggest_personal_words_interval, 0);
            sb.append("remote: " + a2 + " \n");
            sb.append("remote interval: " + a3 + " \n");
            sb.append("remote preload type: " + a4 + " \n");
            sb.append("word update interval: " + a5 + " \n");
            boolean a6 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_emoji_suggest_remote_shuffle, false);
            sb.append("remote shuffle: " + a6 + ", size:" + ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_emoji_suggest_remote_shuffle_size, 20) + " \n");
            sb.append("show delay: " + ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_emoji_suggest_show_delay, 250) + " \n");
            new f.a(this.gUa).bow(sb.toString()).Dq(true).show();
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(199859);
            return xVar;
        }
    }

    public static final /* synthetic */ Object a(ar.a aVar, Object obj) {
        AppMethodBeat.i(105361);
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh, "MMKernel.storage()");
        Object obj2 = aAh.azQ().get(aVar, obj);
        AppMethodBeat.o(105361);
        return obj2;
    }

    public static final /* synthetic */ void b(ar.a aVar, Object obj) {
        AppMethodBeat.i(105362);
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh, "MMKernel.storage()");
        aAh.azQ().set(aVar, obj);
        AppMethodBeat.o(105362);
    }
}
