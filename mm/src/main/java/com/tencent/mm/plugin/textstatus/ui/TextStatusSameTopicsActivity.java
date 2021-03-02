package com.tencent.mm.plugin.textstatus.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableStringBuilder;
import android.view.MenuItem;
import android.view.View;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.textstatus.a.a;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.g.y;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.e;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\fH\u0014J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusSameTopicsActivity;", "Lcom/tencent/mm/ui/report/MMSecDataActivity;", "()V", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/textstatus/model/topic/SameTopicItem;", "Lkotlin/collections/ArrayList;", "rvSameTopic", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "buildItemConverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-textstatus_release"})
public final class TextStatusSameTopicsActivity extends MMSecDataActivity {
    public static final a GfI = new a((byte) 0);
    private WxRecyclerView GfF;
    private ArrayList<com.tencent.mm.plugin.textstatus.f.g.a> kgc = new ArrayList<>();

    static {
        AppMethodBeat.i(216658);
        AppMethodBeat.o(216658);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusSameTopicsActivity$Companion;", "", "()V", "KEY_TOPIC_ID", "", "TAG", "start", "", "context", "Landroid/content/Context;", "topicId", "plugin-textstatus_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void bE(Context context, String str) {
            AppMethodBeat.i(216651);
            p.h(context, "context");
            Intent intent = new Intent(context, TextStatusSameTopicsActivity.class);
            intent.putExtra("topic_id", str);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/textstatus/ui/TextStatusSameTopicsActivity$Companion", "start", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/textstatus/ui/TextStatusSameTopicsActivity$Companion", "start", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(216651);
        }
    }

    public TextStatusSameTopicsActivity() {
        AppMethodBeat.i(216657);
        AppMethodBeat.o(216657);
    }

    public static final /* synthetic */ WxRecyclerView a(TextStatusSameTopicsActivity textStatusSameTopicsActivity) {
        AppMethodBeat.i(216659);
        WxRecyclerView wxRecyclerView = textStatusSameTopicsActivity.GfF;
        if (wxRecyclerView == null) {
            p.btv("rvSameTopic");
        }
        AppMethodBeat.o(216659);
        return wxRecyclerView;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.c2u;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(216656);
        super.onCreate(bundle);
        setBackBtn(new c(this));
        setActionbarColor(getResources().getColor(R.color.z));
        setNavigationbarColor(getResources().getColor(R.color.z));
        hideActionbarLine();
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        ((SecDataUIC) com.tencent.mm.ui.component.a.b(this).get(SecDataUIC.class)).a(new com.tencent.mm.plugin.secdata.c(y.class, 9, (byte) 0));
        SecDataUIC.a aVar2 = SecDataUIC.CWq;
        y yVar = (y) SecDataUIC.a.a(this, 9, y.class);
        if (yVar != null) {
            yVar.sessionId = com.tencent.mm.plugin.fts.a.d.Nj(1);
        }
        String stringExtra = getIntent().getStringExtra("topic_id");
        f fVar = f.FXJ;
        com.tencent.mm.plugin.textstatus.f.f.d fvM = f.fvM();
        String ceA = com.tencent.mm.plugin.auth.a.a.ceA();
        p.g(ceA, "Account.username()");
        List<com.tencent.mm.plugin.textstatus.f.f.a> m = fvM.m(stringExtra, j.ac(ceA));
        new StringBuilder("oncreate ").append(stringExtra).append(',').append(m.size());
        h.hkS();
        for (com.tencent.mm.plugin.textstatus.f.f.a aVar3 : m) {
            this.kgc.add(new com.tencent.mm.plugin.textstatus.f.g.a(aVar3));
        }
        if (this.kgc.size() > 0) {
            String str = this.kgc.get(0).FYx.field_IconID;
            com.tencent.mm.plugin.textstatus.j.b bVar = com.tencent.mm.plugin.textstatus.j.b.GfZ;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(com.tencent.mm.plugin.textstatus.j.b.getName(str));
            com.tencent.mm.plugin.textstatus.j.b bVar2 = com.tencent.mm.plugin.textstatus.j.b.GfZ;
            Drawable a2 = com.tencent.mm.plugin.textstatus.j.b.a(str, a.c.OUTLINED, null, 4);
            if (a2 != null) {
                a2.setBounds(0, 0, getResources().getDimensionPixelSize(R.dimen.t), getResources().getDimensionPixelSize(R.dimen.t));
                com.tencent.mm.plugin.textstatus.j.d dVar = new com.tencent.mm.plugin.textstatus.j.d(a2);
                spannableStringBuilder.insert(0, (CharSequence) "  ");
                spannableStringBuilder.setSpan(dVar, 0, 1, 34);
            }
            spannableStringBuilder.append((CharSequence) ("(" + m.size() + ')'));
            setMMTitle(spannableStringBuilder);
        }
        View findViewById = findViewById(R.id.h_2);
        p.g(findViewById, "findViewById(R.id.rv_same_topic)");
        this.GfF = (WxRecyclerView) findViewById;
        WxRecyclerView wxRecyclerView = this.GfF;
        if (wxRecyclerView == null) {
            p.btv("rvSameTopic");
        }
        wxRecyclerView.setLayoutManager(new LinearLayoutManager(1, false));
        WxRecyclerView wxRecyclerView2 = this.GfF;
        if (wxRecyclerView2 == null) {
            p.btv("rvSameTopic");
        }
        wxRecyclerView2.setAdapter(new WxRecyclerAdapter(new b(), this.kgc));
        WxRecyclerView wxRecyclerView3 = this.GfF;
        if (wxRecyclerView3 == null) {
            p.btv("rvSameTopic");
        }
        wxRecyclerView3.b(new d(this));
        AppMethodBeat.o(216656);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class c implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ TextStatusSameTopicsActivity GfJ;

        c(TextStatusSameTopicsActivity textStatusSameTopicsActivity) {
            this.GfJ = textStatusSameTopicsActivity;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(258520);
            this.GfJ.onBackPressed();
            AppMethodBeat.o(258520);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/textstatus/ui/TextStatusSameTopicsActivity$onCreate$4", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "itemPosition", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "plugin-textstatus_release"})
    public static final class d extends RecyclerView.h {
        final /* synthetic */ TextStatusSameTopicsActivity GfJ;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(TextStatusSameTopicsActivity textStatusSameTopicsActivity) {
            this.GfJ = textStatusSameTopicsActivity;
        }

        @Override // android.support.v7.widget.RecyclerView.h
        public final void a(Rect rect, int i2, RecyclerView recyclerView) {
            AppMethodBeat.i(258521);
            p.h(rect, "outRect");
            p.h(recyclerView, "parent");
            RecyclerView.a adapter = TextStatusSameTopicsActivity.a(this.GfJ).getAdapter();
            if (i2 == (adapter != null ? adapter.getItemCount() : 1) - 1) {
                rect.bottom = com.tencent.mm.cb.a.fromDPToPix((Context) this.GfJ, 16);
                AppMethodBeat.o(258521);
                return;
            }
            rect.bottom = com.tencent.mm.cb.a.fromDPToPix((Context) this.GfJ, 8);
            AppMethodBeat.o(258521);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/textstatus/ui/TextStatusSameTopicsActivity$buildItemConverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-textstatus_release"})
    public static final class b implements com.tencent.mm.view.recyclerview.f {
        b() {
        }

        @Override // com.tencent.mm.view.recyclerview.f
        public final e<?> EC(int i2) {
            AppMethodBeat.i(216652);
            com.tencent.mm.plugin.textstatus.b.d.a aVar = new com.tencent.mm.plugin.textstatus.b.d.a();
            AppMethodBeat.o(216652);
            return aVar;
        }
    }
}
