package com.tencent.mm.plugin.finder.profile.uic;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.feed.ae;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileActivityUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "selectPresenter", "Lcom/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectPresenter;", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onUserVisibleFocused", "Companion", "plugin-finder_release"})
public final class FinderProfileActivityUIC extends UIComponent {
    public static final a var = new a((byte) 0);
    private ae.b tQm;
    private ae.a vaq;

    static {
        AppMethodBeat.i(250095);
        AppMethodBeat.o(250095);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileActivityUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderProfileActivityUIC(Fragment fragment) {
        super(fragment);
        p.h(fragment, "fragment");
        AppMethodBeat.i(250094);
        AppMethodBeat.o(250094);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(250090);
        super.onCreate(bundle);
        String stringExtra = getActivity().getIntent().getStringExtra("finder_username");
        this.vaq = new ae.a(true, stringExtra);
        AppCompatActivity activity = getActivity();
        if (activity == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(250090);
            throw tVar;
        }
        MMActivity mMActivity = (MMActivity) activity;
        View rootView = getRootView();
        ae.a aVar = this.vaq;
        if (aVar == null) {
            p.btv("selectPresenter");
        }
        this.tQm = new ae.b(mMActivity, rootView, aVar);
        ae.a aVar2 = this.vaq;
        if (aVar2 == null) {
            p.btv("selectPresenter");
        }
        ae.b bVar = this.tQm;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        aVar2.a(bVar);
        ae.b bVar2 = this.tQm;
        if (bVar2 == null) {
            p.btv("viewCallback");
        }
        bVar2.initView();
        k kVar = k.vfA;
        long j2 = p.j(stringExtra, z.aUg()) ? 1 : 0;
        FinderReporterUIC.a aVar3 = FinderReporterUIC.wzC;
        FinderReporterUIC fH = FinderReporterUIC.a.fH(getContext());
        k.a(j2, "1", 3, "", fH != null ? fH.dIx() : null);
        AppMethodBeat.o(250090);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onResume() {
        AppMethodBeat.i(250091);
        super.onResume();
        h.hkS();
        AppMethodBeat.o(250091);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onUserVisibleFocused() {
        AppMethodBeat.i(250092);
        super.onUserVisibleFocused();
        h.hkS();
        ae.b bVar = this.tQm;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        Log.i(ae.b.TAG, "onUserVisibleFocused : " + bVar.tQG);
        LinkedList<com.tencent.mm.view.recyclerview.k> linkedList = bVar.tQG;
        if (linkedList != null) {
            bVar.af(linkedList);
            AppMethodBeat.o(250092);
            return;
        }
        AppMethodBeat.o(250092);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final int getLayoutId() {
        return R.layout.aji;
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        AppMethodBeat.i(250093);
        super.onDestroy();
        ae.a aVar = this.vaq;
        if (aVar == null) {
            p.btv("selectPresenter");
        }
        aVar.onDetach();
        AppMethodBeat.o(250093);
    }
}
