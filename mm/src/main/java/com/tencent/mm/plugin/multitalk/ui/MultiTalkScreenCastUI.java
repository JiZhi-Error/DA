package com.tencent.mm.plugin.multitalk.ui;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.q;
import com.tencent.mm.plugin.multitalk.model.t;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0014J\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\u000f\u001a\u00020\nH\u0016J\u001c\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/MultiTalkScreenCastUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "decorView", "Landroid/view/View;", "getDecorView", "()Landroid/view/View;", "decorView$delegate", "Lkotlin/Lazy;", "sendScreen", "", "getLayoutId", "", "initButton", "", "noActionBar", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "persistentState", "Landroid/os/PersistableBundle;", "startCapture", "plugin-multitalk_release"})
public final class MultiTalkScreenCastUI extends MMActivity {
    private HashMap _$_findViewCache;
    private final f zPY = g.ah(new a(this));

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(239721);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(239721);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(239720);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(239720);
        return view;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MultiTalkScreenCastUI() {
        AppMethodBeat.i(239719);
        AppMethodBeat.o(239719);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.bc9;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final boolean noActionBar() {
        return true;
    }

    public final void onCreate(Bundle bundle, PersistableBundle persistableBundle) {
        AppMethodBeat.i(239718);
        super.onCreate(bundle, persistableBundle);
        ((Button) _$_findCachedViewById(R.id.ahc)).setOnClickListener(b.zQa);
        ((Button) _$_findCachedViewById(R.id.ahg)).setOnClickListener(c.zQb);
        ((Button) _$_findCachedViewById(R.id.agp)).setOnClickListener(new d(this));
        AppMethodBeat.o(239718);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements View.OnClickListener {
        public static final b zQa = new b();

        static {
            AppMethodBeat.i(239714);
            AppMethodBeat.o(239714);
        }

        b() {
        }

        public final void onClick(View view) {
            AppMethodBeat.i(239713);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/MultiTalkScreenCastUI$initButton$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            q eom = ac.eom();
            p.g(eom, "SubCoreMultiTalk.getMultiTalkManager()");
            eom.enw();
            t.Rk(102);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/MultiTalkScreenCastUI$initButton$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(239713);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c implements View.OnClickListener {
        public static final c zQb = new c();

        static {
            AppMethodBeat.i(239716);
            AppMethodBeat.o(239716);
        }

        c() {
        }

        public final void onClick(View view) {
            AppMethodBeat.i(239715);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/MultiTalkScreenCastUI$initButton$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            q eom = ac.eom();
            p.g(eom, "SubCoreMultiTalk.getMultiTalkManager()");
            eom.enw();
            t.Rk(103);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/MultiTalkScreenCastUI$initButton$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(239715);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class d implements View.OnClickListener {
        final /* synthetic */ MultiTalkScreenCastUI zPZ;

        d(MultiTalkScreenCastUI multiTalkScreenCastUI) {
            this.zPZ = multiTalkScreenCastUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(239717);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/MultiTalkScreenCastUI$initButton$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            q eom = ac.eom();
            p.g(eom, "SubCoreMultiTalk.getMultiTalkManager()");
            eom.enw();
            t.Rk(102);
            this.zPZ.finish();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/MultiTalkScreenCastUI$initButton$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(239717);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/view/View;", "invoke"})
    static final class a extends kotlin.g.b.q implements kotlin.g.a.a<View> {
        final /* synthetic */ MultiTalkScreenCastUI zPZ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(MultiTalkScreenCastUI multiTalkScreenCastUI) {
            super(0);
            this.zPZ = multiTalkScreenCastUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(239712);
            Window window = this.zPZ.getWindow();
            p.g(window, "window");
            View decorView = window.getDecorView();
            AppMethodBeat.o(239712);
            return decorView;
        }
    }
}
