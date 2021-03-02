package com.tencent.mm.plugin.finder.viewmodel.component;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.view.tabcomp.IFinderTabProvider;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderNotifyUIC;
import com.tencent.mm.plugin.finder.viewmodel.notifytab.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0001\rB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\bH\u0002¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderMsgNotifyTabUIC;", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTabUIC;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "generateProvider", "Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabProvider;", "onBtnBack", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "unsetRedDot", "Companion", "plugin-finder_release"})
public final class FinderMsgNotifyTabUIC extends FinderTabUIC {
    public static final a wyK = new a((byte) 0);

    static {
        AppMethodBeat.i(255844);
        AppMethodBeat.o(255844);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderMsgNotifyTabUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(255843);
        AppMethodBeat.o(255843);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderMsgNotifyTabUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.finder.viewmodel.component.FinderTabUIC
    public final IFinderTabProvider cXB() {
        AppMethodBeat.i(255840);
        c cVar = new c();
        AppMethodBeat.o(255840);
        return cVar;
    }

    @Override // com.tencent.mm.plugin.finder.viewmodel.component.FinderTabUIC, com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(255841);
        super.onCreate(bundle);
        ActionBar supportActionBar = getActivity().getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.hide();
            AppMethodBeat.o(255841);
            return;
        }
        AppMethodBeat.o(255841);
    }

    @Override // com.tencent.mm.plugin.finder.viewmodel.component.FinderTabUIC
    public final void dIp() {
        AppMethodBeat.i(255842);
        Log.i("Finder.FinderMsgNotifyUIC", "unsetRedDot");
        FinderNotifyUIC.a aVar = FinderNotifyUIC.wyQ;
        int length = FinderNotifyUIC.dIr().length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = i3 + 1;
            com.tencent.mm.plugin.finder.view.tabcomp.a MI = MI(i3);
            if (MI instanceof com.tencent.mm.plugin.finder.viewmodel.notifytab.a) {
                MI.by("", false);
            }
            i2++;
            i3 = i4;
        }
        super.dIp();
        AppMethodBeat.o(255842);
    }
}
