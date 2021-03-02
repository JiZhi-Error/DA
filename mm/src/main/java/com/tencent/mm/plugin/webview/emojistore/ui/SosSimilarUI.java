package com.tencent.mm.plugin.webview.emojistore.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.emoji.b.b.ac;
import com.tencent.mm.emoji.b.b.h;
import com.tencent.mm.emoji.panel.a.n;
import com.tencent.mm.g.b.a.ig;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.plugin.webview.emojistore.ui.SimilarEmojiLoadMoreRecyclerView;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.ui.applet.y;
import com.tencent.mm.protocal.protobuf.doc;
import com.tencent.mm.protocal.protobuf.dyn;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.search.data.SimilarEmojiQueryModel;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.mm.ui.u;
import com.tencent.mm.view.TouchableLayout;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 .2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001.B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u000eH\u0014J\b\u0010\u0015\u001a\u00020\u000eH\u0002J\u0006\u0010\u0016\u001a\u00020\u000eJ\b\u0010\u0017\u001a\u00020\u0018H\u0002J\u0012\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0018H\u0014J \u0010\u001d\u001a\u00020\u00182\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\f\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010 H\u0016J,\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u000e2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0016\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,J\b\u0010-\u001a\u00020\u0018H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, hxF = {"Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarUI;", "Lcom/tencent/mm/ui/report/MMSecDataActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/webview/emojistore/ui/SimilarEmojiLoadMoreRecyclerView$IOnLoadingStateChangedListener;", "()V", "adapter", "Lcom/tencent/mm/search/ui/SimilarEmojiAdapter;", "data", "Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarEmojiDataManager;", "emojiList", "Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarEmojiRecyclerView;", "lastClickTimestamp", "", "lastReportExposeStartPosition", "", "dp2px", "context", "Landroid/content/Context;", "dpValue", "", "getLayoutId", "getRecyclerViewPadding", "getReportScene", "initHeadInfo", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onLoadMore", "parent", "Lcom/tencent/mm/plugin/webview/emojistore/ui/SimilarEmojiLoadMoreRecyclerView;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "report18742", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "bOk", "", "reportExpose", "Companion", "plugin-webview_release"})
public final class SosSimilarUI extends MMSecDataActivity implements i, SimilarEmojiLoadMoreRecyclerView.a {
    public static final a INJ = new a((byte) 0);
    private final com.tencent.mm.search.d.a INF = new com.tencent.mm.search.d.a();
    private SosSimilarEmojiRecyclerView ING;
    private int INH;
    private long INI;
    private final c INz = new c();

    static {
        AppMethodBeat.i(82509);
        AppMethodBeat.o(82509);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SosSimilarUI() {
        AppMethodBeat.i(82508);
        AppMethodBeat.o(82508);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarUI$Companion;", "", "()V", "COLUMN_COUNT", "", "TAG", "", "plugin-webview_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return -1;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        String str;
        dyn dyn;
        AppMethodBeat.i(82501);
        super.onCreate(bundle);
        Window window = getWindow();
        p.g(window, "window");
        window.getDecorView().setBackgroundColor(getResources().getColor(R.color.BW_93));
        c cVar = this.INz;
        SosSimilarUI sosSimilarUI = this;
        Intent intent = getIntent();
        p.g(intent, "intent");
        p.h(sosSimilarUI, "context");
        p.h(intent, "intent");
        g.azz().a(2999, cVar);
        g.azz().a(719, cVar);
        cVar.INC = (SimilarEmojiQueryModel) intent.getParcelableExtra("KEY_NET_PARAM");
        SecDataUIC.a aVar = SecDataUIC.CWq;
        SecDataUIC gU = SecDataUIC.a.gU(sosSimilarUI);
        if (!(gU == null || (dyn = (dyn) gU.f(1, dyn.class)) == null)) {
            String str2 = dyn.SessionId;
            if (str2 == null) {
                str2 = "";
            }
            cVar.sessionId = str2;
            Log.i("MicroMsg.SimilarEmoji", "report sessionId=" + cVar.sessionId);
        }
        AppCompatActivity context = getContext();
        p.g(context, "context");
        this.ING = new SosSimilarEmojiRecyclerView(new u(context, R.style.i4));
        SosSimilarEmojiRecyclerView sosSimilarEmojiRecyclerView = this.ING;
        if (sosSimilarEmojiRecyclerView != null) {
            sosSimilarEmojiRecyclerView.setBackgroundColor(getResources().getColor(R.color.BW_93));
        }
        SosSimilarEmojiRecyclerView sosSimilarEmojiRecyclerView2 = this.ING;
        if (sosSimilarEmojiRecyclerView2 != null) {
            sosSimilarEmojiRecyclerView2.setOnLoadingStateChangedListener(this);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        TouchableLayout touchableLayout = new TouchableLayout(this);
        SosSimilarEmojiRecyclerView sosSimilarEmojiRecyclerView3 = this.ING;
        if (sosSimilarEmojiRecyclerView3 != null) {
            sosSimilarEmojiRecyclerView3.setPadding(gav(), 0, gav(), 0);
        }
        touchableLayout.addView(this.ING, layoutParams);
        setContentView(touchableLayout, layoutParams);
        SimilarEmojiQueryModel similarEmojiQueryModel = this.INz.INC;
        if (similarEmojiQueryModel == null || (str = similarEmojiQueryModel.query) == null || str == null) {
            str = MMApplicationContext.getContext().getString(R.string.hcf);
            p.g(str, "run {\n            MMAppl…ar_emoji_title)\n        }");
        }
        setMMTitle(str);
        setBackBtn(new b(this));
        getContext();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(3);
        gridLayoutManager.a(new c(this, gridLayoutManager));
        SosSimilarEmojiRecyclerView sosSimilarEmojiRecyclerView4 = this.ING;
        if (sosSimilarEmojiRecyclerView4 != null) {
            sosSimilarEmojiRecyclerView4.setLayoutManager(gridLayoutManager);
        }
        SosSimilarEmojiRecyclerView sosSimilarEmojiRecyclerView5 = this.ING;
        if (sosSimilarEmojiRecyclerView5 != null) {
            sosSimilarEmojiRecyclerView5.setItemViewCacheSize(0);
        }
        SosSimilarEmojiRecyclerView sosSimilarEmojiRecyclerView6 = this.ING;
        if (sosSimilarEmojiRecyclerView6 != null) {
            sosSimilarEmojiRecyclerView6.setAdapter(this.INF);
        }
        this.INF.haK = new d(this);
        this.INF.NJB = false;
        EmojiInfo gat = this.INz.gat();
        if (gat != null) {
            if (this.INz.gau()) {
                this.INF.F(gat);
            } else {
                this.INF.G(gat);
            }
            this.INF.gxB();
        }
        this.INF.notifyDataSetChanged();
        this.INz.f(this);
        com.tencent.mm.search.c.a aVar2 = com.tencent.mm.search.c.a.NJv;
        com.tencent.mm.search.c.a.gxt();
        AppMethodBeat.o(82501);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class b implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ SosSimilarUI INK;

        b(SosSimilarUI sosSimilarUI) {
            this.INK = sosSimilarUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(82497);
            this.INK.finish();
            AppMethodBeat.o(82497);
            return false;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, hxF = {"com/tencent/mm/plugin/webview/emojistore/ui/SosSimilarUI$onCreate$2", "Landroid/support/v7/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSize", "", "position", "plugin-webview_release"})
    public static final class c extends GridLayoutManager.b {
        final /* synthetic */ SosSimilarUI INK;
        final /* synthetic */ GridLayoutManager rgW;

        c(SosSimilarUI sosSimilarUI, GridLayoutManager gridLayoutManager) {
            this.INK = sosSimilarUI;
            this.rgW = gridLayoutManager;
        }

        @Override // android.support.v7.widget.GridLayoutManager.b
        public final int bX(int i2) {
            AppMethodBeat.i(82498);
            switch (this.INK.INF.getItemViewType(i2)) {
                case 100:
                case 104:
                case 105:
                case 106:
                case 107:
                    int ki = this.rgW.ki();
                    AppMethodBeat.o(82498);
                    return ki;
                case 101:
                case 102:
                case 103:
                default:
                    AppMethodBeat.o(82498);
                    return 1;
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J,\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\r"}, hxF = {"com/tencent/mm/plugin/webview/emojistore/ui/SosSimilarUI$onCreate$3", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "onClick", "", "view", "Landroid/view/View;", "context", "Landroid/content/Context;", "position", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "onLongClick", "plugin-webview_release"})
    public static final class d implements n {
        final /* synthetic */ SosSimilarUI INK;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(SosSimilarUI sosSimilarUI) {
            this.INK = sosSimilarUI;
        }

        @Override // com.tencent.mm.emoji.panel.a.n
        public final void a(View view, Context context, int i2) {
            boolean z;
            String str;
            AppMethodBeat.i(210292);
            p.h(context, "context");
            ac pm = this.INK.INF.pm(i2);
            if (pm instanceof h) {
                bj emojiStorageMgr = k.getEmojiStorageMgr();
                p.g(emojiStorageMgr, "SubCoreEmoji.getEmojiStorageMgr()");
                EmojiInfo blk = emojiStorageMgr.cgN().blk(((h) pm).gWm.field_md5);
                if ((blk != null ? blk.getGroup() : 0) == EmojiInfo.VkW) {
                    z = true;
                } else {
                    z = false;
                }
                ig igVar = new ig();
                igVar.ri((long) this.INK.dXX());
                igVar.vZ(this.INK.INz.sessionId);
                igVar.wa(this.INK.INz.rjq);
                igVar.wb(((h) pm).gWm.field_md5);
                SimilarEmojiQueryModel similarEmojiQueryModel = this.INK.INz.INC;
                if (similarEmojiQueryModel == null || (str = similarEmojiQueryModel.emojiMD5) == null) {
                    str = "";
                }
                igVar.wc(str);
                igVar.rj((long) this.INK.INz.offset);
                igVar.rk((long) i2);
                igVar.rl(System.currentTimeMillis());
                igVar.wd(this.INK.INz.rjq);
                igVar.rm(1);
                igVar.rn(z ? 1 : 0);
                igVar.bfK();
                ar.a(igVar);
                if (!z) {
                    TouchableLayout.a aVar = TouchableLayout.Rni;
                    int i3 = TouchableLayout.kuv;
                    TouchableLayout.a aVar2 = TouchableLayout.Rni;
                    new com.tencent.mm.ui.widget.b.a(this.INK).a(view, 0, 0, new a((h) pm), new b(this.INK, (h) pm, this.INK.INz, i2), i3, TouchableLayout.kuw);
                }
            }
            AppMethodBeat.o(210292);
        }

        @Override // com.tencent.mm.emoji.panel.a.n
        public final void a(View view, Context context, int i2, ac acVar) {
            String str;
            String str2;
            String str3;
            String str4 = null;
            AppMethodBeat.i(210293);
            p.h(context, "context");
            if (acVar == null || !(acVar instanceof h) || ((h) acVar).gYc != 103) {
                AppMethodBeat.o(210293);
            } else if (System.currentTimeMillis() - this.INK.INI < 500) {
                AppMethodBeat.o(210293);
            } else {
                this.INK.INI = System.currentTimeMillis();
                com.tencent.mm.search.b.a aVar = com.tencent.mm.search.b.a.NJs;
                com.tencent.mm.search.b.c gxq = com.tencent.mm.search.b.a.gxq();
                if (gxq != null) {
                    gxq.a(view, context, i2, acVar);
                }
                z.f fVar = new z.f();
                fVar.SYG = (T) ((h) acVar).gWm;
                if (this.INK.INz.gau()) {
                    j jVar = (j) g.af(j.class);
                    SimilarEmojiQueryModel similarEmojiQueryModel = this.INK.INz.INC;
                    if (similarEmojiQueryModel != null) {
                        str3 = similarEmojiQueryModel.toUser;
                    } else {
                        str3 = null;
                    }
                    jVar.b(context, str3, fVar.SYG.getMd5(), fVar.SYG.Vlm, new a(this, fVar, context));
                } else {
                    j jVar2 = (j) g.af(j.class);
                    SimilarEmojiQueryModel similarEmojiQueryModel2 = this.INK.INz.INC;
                    if (similarEmojiQueryModel2 != null) {
                        str = similarEmojiQueryModel2.toUser;
                    } else {
                        str = null;
                    }
                    jVar2.b(context, str, fVar.SYG.getMd5(), ((EmojiInfo) fVar.SYG).field_designerID, "", ((EmojiInfo) fVar.SYG).field_thumbUrl, new b(this, fVar, context));
                }
                doc doc = new doc();
                if (this.INK.INz.gau()) {
                    StringBuilder append = new StringBuilder("logid=17372&sessionid=").append(this.INK.INz.rjq).append("&searchid=").append(this.INK.INz.rjq).append("&scene=59&clickmd5=").append(fVar.SYG.getMd5()).append("&querymd5=");
                    SimilarEmojiQueryModel similarEmojiQueryModel3 = this.INK.INz.INC;
                    if (similarEmojiQueryModel3 != null) {
                        str4 = similarEmojiQueryModel3.emojiMD5;
                    }
                    doc.MRe = append.append(str4).append("&offset=").append(this.INK.INz.offset).append("&pos=").append(i2).append("&clienttimestamp=").append(System.currentTimeMillis()).append("&tab=0&requestid=").append(this.INK.INz.rjq).toString();
                } else {
                    StringBuilder append2 = new StringBuilder("scene=78&searchid=").append(this.INK.INz.rjq).append("&businesstype=256&docid=").append(((h) acVar).gYd).append("&docpos=").append(i2).append("&typepos=0&ishomepage=0&clienttimestamp=").append(cl.aWA()).append("&sceneactiontype=1&query=");
                    SimilarEmojiQueryModel similarEmojiQueryModel4 = this.INK.INz.INC;
                    if (similarEmojiQueryModel4 == null || (str2 = similarEmojiQueryModel4.query) == null) {
                        str2 = "";
                    }
                    doc.MRe = append2.append(str2).append("&sessionid=").append(this.INK.INz.sessionId).append("&nettype=").append(ai.ait()).append("&requestid=").append(this.INK.INz.rjq).append("&reqbusinesstype=256&pageno=").append(((h) acVar).gYe).toString();
                }
                g.azz().b(new ad(doc));
                Log.i("MicroMsg.WebSearch.SosSimilarUI", doc.MRe);
                AppMethodBeat.o(210293);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "parsterLen", "", "onDialogClick"})
        static final class a implements y.a {
            final /* synthetic */ Context $context;
            final /* synthetic */ d INL;
            final /* synthetic */ z.f INM;

            a(d dVar, z.f fVar, Context context) {
                this.INL = dVar;
                this.INM = fVar;
                this.$context = context;
            }

            @Override // com.tencent.mm.pluginsdk.ui.applet.y.a
            public final void a(boolean z, String str, int i2) {
                com.tencent.mm.pluginsdk.ui.chat.j jVar;
                AppMethodBeat.i(82499);
                if (z) {
                    com.tencent.mm.search.b.a aVar = com.tencent.mm.search.b.a.NJs;
                    com.tencent.mm.search.b.c gxq = com.tencent.mm.search.b.a.gxq();
                    if (!(gxq == null || (jVar = gxq.haC) == null)) {
                        jVar.B(this.INM.SYG);
                    }
                    com.tencent.mm.ui.base.u.makeText(this.$context, this.$context.getString(R.string.yt), 1).show();
                }
                this.INL.INK.f(this.INM.SYG, z);
                AppMethodBeat.o(82499);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "parsterLen", "", "onDialogClick"})
        static final class b implements y.a {
            final /* synthetic */ Context $context;
            final /* synthetic */ d INL;
            final /* synthetic */ z.f INM;

            b(d dVar, z.f fVar, Context context) {
                this.INL = dVar;
                this.INM = fVar;
                this.$context = context;
            }

            @Override // com.tencent.mm.pluginsdk.ui.applet.y.a
            public final void a(boolean z, String str, int i2) {
                String str2;
                String str3 = null;
                AppMethodBeat.i(210291);
                if (z) {
                    f cGf = k.cGf();
                    SimilarEmojiQueryModel similarEmojiQueryModel = this.INL.INK.INz.INC;
                    if (similarEmojiQueryModel != null) {
                        str2 = similarEmojiQueryModel.toUser;
                    } else {
                        str2 = null;
                    }
                    cGf.a(str2, this.INM.SYG, (ca) null);
                    if (!Util.isNullOrNil(str)) {
                        com.tencent.mm.plugin.messenger.a.d eir = com.tencent.mm.plugin.messenger.a.g.eir();
                        SimilarEmojiQueryModel similarEmojiQueryModel2 = this.INL.INK.INz.INC;
                        if (similarEmojiQueryModel2 != null) {
                            str3 = similarEmojiQueryModel2.toUser;
                        }
                        eir.iF(str, str3);
                    }
                    com.tencent.mm.ui.base.u.makeText(this.$context, this.$context.getString(R.string.yt), 1).show();
                }
                this.INL.INK.f(this.INM.SYG, z);
                AppMethodBeat.o(210291);
            }
        }
    }

    public final int dXX() {
        AppMethodBeat.i(210294);
        if (this.INz.gau()) {
            AppMethodBeat.o(210294);
            return 59;
        }
        AppMethodBeat.o(210294);
        return 78;
    }

    public final void f(EmojiInfo emojiInfo, boolean z) {
        int i2;
        AppMethodBeat.i(210295);
        p.h(emojiInfo, "emojiInfo");
        if (z) {
            i2 = 1;
        } else {
            i2 = 2;
        }
        e.INSTANCE.a(18742, Integer.valueOf(dXX()), this.INz.rjq, this.INz.rjq, this.INz.rjq, Integer.valueOf(i2), emojiInfo.getMd5());
        AppMethodBeat.o(210295);
    }

    private final int gav() {
        AppMethodBeat.i(82502);
        int deviceWidth = ao.getDeviceWidth();
        AppCompatActivity context = getContext();
        p.g(context, "context");
        int hR = (deviceWidth - (hR(context) * 3)) / 8;
        Log.i("MicroMsg.WebSearch.SosSimilarUI", "recycler view padding :".concat(String.valueOf(hR)));
        if (hR > 0) {
            AppMethodBeat.o(82502);
            return hR;
        }
        AppMethodBeat.o(82502);
        return 0;
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(82503);
        SosSimilarEmojiRecyclerView sosSimilarEmojiRecyclerView = this.ING;
        if (sosSimilarEmojiRecyclerView != null) {
            sosSimilarEmojiRecyclerView.showLoading(false);
        }
        if (i2 == 0 && i3 == 0 && this.INz.IND.size() > 1) {
            int itemCount = this.INF.getItemCount();
            this.INF.NJB = true;
            this.INF.ad(this.INz.IND);
            if (itemCount - 2 <= 0) {
                this.INF.notifyDataSetChanged();
                AppMethodBeat.o(82503);
                return;
            }
            this.INF.ci(itemCount - 1);
        } else {
            Log.i("MicroMsg.WebSearch.SosSimilarUI", "onSceneEnd errType:" + i2 + " errCode:" + i3 + " errMsg:" + str + ' ');
            this.INF.setData(new ArrayList());
            EmojiInfo gat = this.INz.gat();
            if (gat != null) {
                if (this.INz.gau()) {
                    this.INF.F(gat);
                } else {
                    this.INF.G(gat);
                }
            }
            this.INF.gxC();
            this.INF.notifyDataSetChanged();
        }
        cnl();
        AppMethodBeat.o(82503);
    }

    private final void cnl() {
        String str;
        String str2;
        int i2 = 0;
        AppMethodBeat.i(82504);
        if (this.INH < this.INF.rgC) {
            doc doc = new doc();
            if (this.INz.gau()) {
                String str3 = "";
                for (T t : this.INz.IND) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        kotlin.a.j.hxH();
                    }
                    T t2 = t;
                    String str4 = (i2 <= this.INH || i2 > this.INF.rgC - 2) ? str3 : str3 + t2.gWm.getMd5() + ';';
                    i2 = i3;
                    str3 = str4;
                }
                StringBuilder append = new StringBuilder("logid=17368&sessionid=").append(this.INz.rjq).append("&searchid=").append(this.INz.rjq).append("&scene=59&md5=");
                SimilarEmojiQueryModel similarEmojiQueryModel = this.INz.INC;
                if (similarEmojiQueryModel != null) {
                    str2 = similarEmojiQueryModel.emojiMD5;
                } else {
                    str2 = null;
                }
                doc.MRe = append.append(str2).append("&md5content=").append(str3).append("&pos=").append(this.INH + 2).append("&clienttimestamp=").append(System.currentTimeMillis()).append("&tab=0&requestid=").append(this.INz.rjq).toString();
            } else {
                String str5 = "";
                for (T t3 : this.INz.IND) {
                    int i4 = i2 + 1;
                    if (i2 < 0) {
                        kotlin.a.j.hxH();
                    }
                    T t4 = t3;
                    String str6 = (i2 <= this.INH || i2 > this.INF.rgC - 2) ? str5 : str5 + "256:" + t4.gYd + ':' + cl.aWA() + ';';
                    i2 = i4;
                    str5 = str6;
                }
                StringBuilder append2 = new StringBuilder("isexpose=1&searchid=").append(this.INz.rjq).append("&content=").append(str5).append("&query=");
                SimilarEmojiQueryModel similarEmojiQueryModel2 = this.INz.INC;
                if (similarEmojiQueryModel2 == null || (str = similarEmojiQueryModel2.query) == null) {
                    str = "";
                }
                doc.MRe = append2.append(str).append("&ishomepage=0&&sessionid=").append(this.INz.sessionId).append("&scene=78&logtype=1&requestid=").append(this.INz.rjq).append("&pageno=").append(this.INz.gYe).toString();
            }
            g.azz().b(new ad(doc));
            this.INH = this.INF.rgC;
            Log.i("MicroMsg.WebSearch.SosSimilarUI", doc.MRe);
        }
        AppMethodBeat.o(82504);
    }

    @Override // com.tencent.mm.plugin.webview.emojistore.ui.SimilarEmojiLoadMoreRecyclerView.a
    public final void gas() {
        AppMethodBeat.i(82505);
        if (this.INz.tuG) {
            SosSimilarEmojiRecyclerView sosSimilarEmojiRecyclerView = this.ING;
            if (sosSimilarEmojiRecyclerView == null) {
                AppMethodBeat.o(82505);
                return;
            } else if (!sosSimilarEmojiRecyclerView.gar()) {
                SosSimilarEmojiRecyclerView sosSimilarEmojiRecyclerView2 = this.ING;
                if (sosSimilarEmojiRecyclerView2 != null) {
                    sosSimilarEmojiRecyclerView2.showLoading(true);
                }
                cnl();
                this.INz.f(this);
            }
        }
        AppMethodBeat.o(82505);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(82506);
        cnl();
        super.onDestroy();
        c cVar = this.INz;
        cVar.callback = null;
        com.tencent.mm.kernel.b aAg = g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().cancel(2999);
        com.tencent.mm.kernel.b aAg2 = g.aAg();
        p.g(aAg2, "MMKernel.network()");
        aAg2.azz().b(2999, cVar);
        com.tencent.mm.kernel.b aAg3 = g.aAg();
        p.g(aAg3, "MMKernel.network()");
        aAg3.azz().cancel(719);
        g.azz().b(719, cVar);
        AppMethodBeat.o(82506);
    }

    private static int hR(Context context) {
        AppMethodBeat.i(82507);
        Resources resources = context.getResources();
        p.g(resources, "context.resources");
        int i2 = (int) ((resources.getDisplayMetrics().density * 108.0f) + 0.5f);
        AppMethodBeat.o(82507);
        return i2;
    }
}
