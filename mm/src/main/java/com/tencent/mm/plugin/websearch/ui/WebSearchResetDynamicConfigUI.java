package com.tencent.mm.plugin.websearch.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.n.h;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.MMEditText;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0014J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/websearch/ui/WebSearchResetDynamicConfigUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "plugin-websearch_release"})
public final class WebSearchResetDynamicConfigUI extends MMActivity {
    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(201749);
        super.onCreate(bundle);
        setMMTitle(R.string.g58);
        setBackBtn(new a(this));
        ((Button) findViewById(R.id.g3k)).setOnClickListener(new b(this));
        AppMethodBeat.o(201749);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class a implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ WebSearchResetDynamicConfigUI IGO;

        a(WebSearchResetDynamicConfigUI webSearchResetDynamicConfigUI) {
            this.IGO = webSearchResetDynamicConfigUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(201747);
            this.IGO.finish();
            AppMethodBeat.o(201747);
            return false;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ WebSearchResetDynamicConfigUI IGO;

        b(WebSearchResetDynamicConfigUI webSearchResetDynamicConfigUI) {
            this.IGO = webSearchResetDynamicConfigUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(201748);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/websearch/ui/WebSearchResetDynamicConfigUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            try {
                View findViewById = this.IGO.findViewById(R.id.e60);
                p.g(findViewById, "findViewById<MMEditText>(R.id.key_et)");
                String obj = ((MMEditText) findViewById).getText().toString();
                View findViewById2 = this.IGO.findViewById(R.id.j2f);
                p.g(findViewById2, "findViewById<MMEditText>(R.id.value_et)");
                h.aqJ().put(obj, ((MMEditText) findViewById2).getText().toString());
                u.makeText(this.IGO.getContext(), this.IGO.getString(R.string.wo), 0).show();
            } catch (Exception e2) {
                u.makeText(this.IGO.getContext(), this.IGO.getString(R.string.wn), 0).show();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/websearch/ui/WebSearchResetDynamicConfigUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(201748);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.cbg;
    }
}
