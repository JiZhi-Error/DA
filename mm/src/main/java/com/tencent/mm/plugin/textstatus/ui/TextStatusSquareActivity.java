package com.tencent.mm.plugin.textstatus.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.g;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0012\u0018\u0000 (2\u00020\u0001:\u0001(B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020#H\u0014J\u0012\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016R*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006)"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusSquareActivity;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/textstatus/model/square/SquareItem;", "Lkotlin/collections/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "setDataList", "(Ljava/util/ArrayList;)V", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getMProgressDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setMProgressDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "onSceneEnd", "com/tencent/mm/plugin/textstatus/ui/TextStatusSquareActivity$onSceneEnd$1", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusSquareActivity$onSceneEnd$1;", "recycleView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRecycleView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRecycleView", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "topicId", "", "getTopicId", "()Ljava/lang/String;", "setTopicId", "(Ljava/lang/String;)V", "buildItemConverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-textstatus_release"})
public final class TextStatusSquareActivity extends MMActivity {
    public static final a GfR = new a((byte) 0);
    private String FZz;
    private final e GfQ = new e(this);
    q gxX;
    private ArrayList<com.tencent.mm.plugin.textstatus.f.e.e> kgc = new ArrayList<>();
    WxRecyclerView rHX;

    static {
        AppMethodBeat.i(216672);
        AppMethodBeat.o(216672);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusSquareActivity$Companion;", "", "()V", "TAG", "", "start", "", "context", "Landroid/content/Context;", "p", "Landroid/os/Bundle;", "plugin-textstatus_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public TextStatusSquareActivity() {
        AppMethodBeat.i(216671);
        AppMethodBeat.o(216671);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.c2z;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(216670);
        super.onCreate(bundle);
        setMMTitle("");
        setBackBtn(new c(this));
        Intent intent = getIntent();
        p.g(intent, "intent");
        Bundle extras = intent.getExtras();
        String string = extras != null ? extras.getString("TEXT_STATUS") : null;
        Intent intent2 = getIntent();
        p.g(intent2, "intent");
        Bundle extras2 = intent2.getExtras();
        this.FZz = extras2 != null ? extras2.getString("TOPIC_ID") : null;
        Intent intent3 = getIntent();
        p.g(intent3, "intent");
        Bundle extras3 = intent3.getExtras();
        if (extras3 != null) {
            extras3.getString("STATUS_ID");
        }
        for (int i2 = 0; i2 <= 10; i2++) {
            this.kgc.add(new com.tencent.mm.plugin.textstatus.f.e.e(String.valueOf(i2), APMidasPayAPI.ENV_TEST, "", "", ""));
        }
        this.rHX = (WxRecyclerView) findViewById(R.id.gy2);
        WxRecyclerView wxRecyclerView = this.rHX;
        if (wxRecyclerView != null) {
            wxRecyclerView.setLayoutManager(new LinearLayoutManager(1, false));
        }
        WxRecyclerView wxRecyclerView2 = this.rHX;
        if (wxRecyclerView2 != null) {
            wxRecyclerView2.setAdapter(new WxRecyclerAdapter(new b(), this.kgc));
        }
        WxRecyclerView wxRecyclerView3 = this.rHX;
        RecyclerView.a adapter = wxRecyclerView3 != null ? wxRecyclerView3.getAdapter() : null;
        if (adapter == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.WxRecyclerAdapter<*>");
            AppMethodBeat.o(216670);
            throw tVar;
        }
        ((WxRecyclerAdapter) adapter).a((g) new com.tencent.mm.plugin.textstatus.f.e.d("#".concat(String.valueOf(string)), "共324人 同城23人"), (g.b) true);
        WxRecyclerView wxRecyclerView4 = this.rHX;
        if (wxRecyclerView4 != null) {
            wxRecyclerView4.b(new d(this));
            AppMethodBeat.o(216670);
            return;
        }
        AppMethodBeat.o(216670);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class c implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ TextStatusSquareActivity GfS;

        c(TextStatusSquareActivity textStatusSquareActivity) {
            this.GfS = textStatusSquareActivity;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(216667);
            this.GfS.onBackPressed();
            AppMethodBeat.o(216667);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/textstatus/ui/TextStatusSquareActivity$onCreate$2", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "itemPosition", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "plugin-textstatus_release"})
    public static final class d extends RecyclerView.h {
        final /* synthetic */ TextStatusSquareActivity GfS;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(TextStatusSquareActivity textStatusSquareActivity) {
            this.GfS = textStatusSquareActivity;
        }

        @Override // android.support.v7.widget.RecyclerView.h
        public final void a(Rect rect, int i2, RecyclerView recyclerView) {
            RecyclerView.a adapter;
            AppMethodBeat.i(216668);
            p.h(rect, "outRect");
            p.h(recyclerView, "parent");
            WxRecyclerView wxRecyclerView = this.GfS.rHX;
            if (i2 == ((wxRecyclerView == null || (adapter = wxRecyclerView.getAdapter()) == null) ? 1 : adapter.getItemCount()) - 1) {
                rect.bottom = com.tencent.mm.cb.a.fromDPToPix((Context) this.GfS, 16);
                AppMethodBeat.o(216668);
                return;
            }
            rect.bottom = com.tencent.mm.cb.a.fromDPToPix((Context) this.GfS, 8);
            AppMethodBeat.o(216668);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/textstatus/ui/TextStatusSquareActivity$buildItemConverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-textstatus_release"})
    public static final class b implements f {
        b() {
        }

        @Override // com.tencent.mm.view.recyclerview.f
        public final com.tencent.mm.view.recyclerview.e<?> EC(int i2) {
            AppMethodBeat.i(216666);
            switch (i2) {
                case -1:
                    com.tencent.mm.plugin.textstatus.b.d dVar = new com.tencent.mm.plugin.textstatus.b.d();
                    AppMethodBeat.o(216666);
                    return dVar;
                default:
                    com.tencent.mm.plugin.textstatus.b.e eVar = new com.tencent.mm.plugin.textstatus.b.e();
                    AppMethodBeat.o(216666);
                    return eVar;
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/textstatus/ui/TextStatusSquareActivity$onSceneEnd$1", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-textstatus_release"})
    public static final class e implements i {
        final /* synthetic */ TextStatusSquareActivity GfS;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        e(TextStatusSquareActivity textStatusSquareActivity) {
            this.GfS = textStatusSquareActivity;
        }

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
            WxRecyclerView wxRecyclerView;
            RecyclerView.a adapter;
            AppMethodBeat.i(216669);
            if (qVar instanceof com.tencent.mm.plugin.textstatus.f.d) {
                com.tencent.mm.kernel.g.azz().b(((com.tencent.mm.plugin.textstatus.f.d) qVar).getType(), this);
                if (i2 == 0 && i3 == 0 && (wxRecyclerView = this.GfS.rHX) != null && (adapter = wxRecyclerView.getAdapter()) != null) {
                    adapter.notifyDataSetChanged();
                }
            }
            q qVar2 = this.GfS.gxX;
            if (qVar2 != null) {
                qVar2.dismiss();
                AppMethodBeat.o(216669);
                return;
            }
            AppMethodBeat.o(216669);
        }
    }
}
