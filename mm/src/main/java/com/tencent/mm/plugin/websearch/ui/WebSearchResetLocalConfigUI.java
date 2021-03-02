package com.tencent.mm.plugin.websearch.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.MMEditText;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.k;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0014J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/websearch/ui/WebSearchResetLocalConfigUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "plugin-websearch_release"})
public final class WebSearchResetLocalConfigUI extends MMActivity {
    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(201752);
        super.onCreate(bundle);
        setMMTitle(R.string.g59);
        setBackBtn(new a(this));
        ((Button) findViewById(R.id.g3k)).setOnClickListener(new b(this));
        AppMethodBeat.o(201752);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class a implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ WebSearchResetLocalConfigUI IGP;

        a(WebSearchResetLocalConfigUI webSearchResetLocalConfigUI) {
            this.IGP = webSearchResetLocalConfigUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(201750);
            this.IGP.finish();
            AppMethodBeat.o(201750);
            return false;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ WebSearchResetLocalConfigUI IGP;

        b(WebSearchResetLocalConfigUI webSearchResetLocalConfigUI) {
            this.IGP = webSearchResetLocalConfigUI;
        }

        public final void onClick(View view) {
            String str;
            AppMethodBeat.i(201751);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/websearch/ui/WebSearchResetLocalConfigUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            try {
                View findViewById = this.IGP.findViewById(R.id.e60);
                p.g(findViewById, "findViewById<MMEditText>(R.id.key_et)");
                String obj = ((MMEditText) findViewById).getText().toString();
                View findViewById2 = this.IGP.findViewById(R.id.j2f);
                p.g(findViewById2, "findViewById<MMEditText>(R.id.value_et)");
                String obj2 = ((MMEditText) findViewById2).getText().toString();
                ar.a valueOf = ar.a.valueOf(obj);
                Object[] array = new k("_").q(obj, 0).toArray(new String[0]);
                if (array == null) {
                    t tVar = new t("null cannot be cast to non-null type kotlin.Array<T>");
                    AppMethodBeat.o(201751);
                    throw tVar;
                }
                String[] strArr = (String[]) array;
                String str2 = strArr[strArr.length - 1];
                if (p.j(str2, "SYNC")) {
                    str = strArr[strArr.length - 2];
                } else {
                    str = str2;
                }
                switch (str.hashCode()) {
                    case -1838656495:
                        if (str.equals("STRING")) {
                            e aAh = g.aAh();
                            p.g(aAh, "MMKernel.storage()");
                            aAh.azQ().set(valueOf, obj2);
                            u.makeText(this.IGP.getContext(), this.IGP.getString(R.string.wo), 0).show();
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/websearch/ui/WebSearchResetLocalConfigUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(201751);
                            return;
                        }
                        RuntimeException runtimeException = new RuntimeException();
                        AppMethodBeat.o(201751);
                        throw runtimeException;
                    case 72655:
                        if (str.equals("INT")) {
                            e aAh2 = g.aAh();
                            p.g(aAh2, "MMKernel.storage()");
                            aAh2.azQ().set(valueOf, Integer.valueOf(Integer.parseInt(obj2)));
                            u.makeText(this.IGP.getContext(), this.IGP.getString(R.string.wo), 0).show();
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/websearch/ui/WebSearchResetLocalConfigUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(201751);
                            return;
                        }
                        RuntimeException runtimeException2 = new RuntimeException();
                        AppMethodBeat.o(201751);
                        throw runtimeException2;
                    case 2342524:
                        if (str.equals("LONG")) {
                            e aAh3 = g.aAh();
                            p.g(aAh3, "MMKernel.storage()");
                            aAh3.azQ().set(valueOf, Long.valueOf(Long.parseLong(obj2)));
                            u.makeText(this.IGP.getContext(), this.IGP.getString(R.string.wo), 0).show();
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/websearch/ui/WebSearchResetLocalConfigUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(201751);
                            return;
                        }
                        RuntimeException runtimeException22 = new RuntimeException();
                        AppMethodBeat.o(201751);
                        throw runtimeException22;
                    case 66988604:
                        if (str.equals("FLOAT")) {
                            e aAh4 = g.aAh();
                            p.g(aAh4, "MMKernel.storage()");
                            aAh4.azQ().set(valueOf, Float.valueOf(Float.parseFloat(obj2)));
                            u.makeText(this.IGP.getContext(), this.IGP.getString(R.string.wo), 0).show();
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/websearch/ui/WebSearchResetLocalConfigUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(201751);
                            return;
                        }
                        RuntimeException runtimeException222 = new RuntimeException();
                        AppMethodBeat.o(201751);
                        throw runtimeException222;
                    case 782694408:
                        if (str.equals("BOOLEAN")) {
                            e aAh5 = g.aAh();
                            p.g(aAh5, "MMKernel.storage()");
                            aAh5.azQ().set(valueOf, Boolean.valueOf(Boolean.parseBoolean(obj2)));
                            u.makeText(this.IGP.getContext(), this.IGP.getString(R.string.wo), 0).show();
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/websearch/ui/WebSearchResetLocalConfigUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(201751);
                            return;
                        }
                        RuntimeException runtimeException2222 = new RuntimeException();
                        AppMethodBeat.o(201751);
                        throw runtimeException2222;
                    case 2022338513:
                        if (str.equals("DOUBLE")) {
                            e aAh6 = g.aAh();
                            p.g(aAh6, "MMKernel.storage()");
                            aAh6.azQ().set(valueOf, Double.valueOf(Double.parseDouble(obj2)));
                            u.makeText(this.IGP.getContext(), this.IGP.getString(R.string.wo), 0).show();
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/websearch/ui/WebSearchResetLocalConfigUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(201751);
                            return;
                        }
                        RuntimeException runtimeException22222 = new RuntimeException();
                        AppMethodBeat.o(201751);
                        throw runtimeException22222;
                    default:
                        RuntimeException runtimeException222222 = new RuntimeException();
                        AppMethodBeat.o(201751);
                        throw runtimeException222222;
                }
            } catch (Exception e2) {
                u.makeText(this.IGP.getContext(), this.IGP.getString(R.string.wn), 0).show();
            }
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.cbg;
    }
}
