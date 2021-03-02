package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.report.live.m;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLiveVisitorWithoutAffinityUIC;", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLiveVisitorUIC;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "plugin-finder_release"})
public final class FinderLiveVisitorWithoutAffinityUIC extends FinderLiveVisitorUIC {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderLiveVisitorWithoutAffinityUIC(Fragment fragment) {
        super(fragment);
        p.h(fragment, "fragment");
        AppMethodBeat.i(255825);
        AppMethodBeat.o(255825);
    }

    @Override // com.tencent.mm.plugin.finder.viewmodel.component.FinderLiveVisitorUIC, com.tencent.mm.ui.component.UIComponent
    public final void onActivityResult(int i2, int i3, Intent intent) {
        boolean z;
        String str;
        AppMethodBeat.i(255823);
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1) {
            if (i2 == 1005) {
                ArrayList<String> arrayList = new ArrayList<>();
                if (intent != null) {
                    arrayList = intent.getStringArrayListExtra("SendMsgUsernames");
                    p.g(arrayList, "data.getStringArrayListE…sgRetr.KSendMsgUsernames)");
                }
                if (!arrayList.isEmpty()) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    String str2 = "";
                    Iterator<String> it = arrayList.iterator();
                    while (true) {
                        str = str2;
                        if (!it.hasNext()) {
                            break;
                        }
                        str2 = str + it.next() + ';';
                    }
                    if (n.nm(str, ";")) {
                        int length = str.length() - 1;
                        if (str == null) {
                            t tVar = new t("null cannot be cast to non-null type java.lang.String");
                            AppMethodBeat.o(255823);
                            throw tVar;
                        }
                        str = str.substring(0, length);
                        p.g(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    }
                    m.vli.a(str, s.ba.Chat);
                    AppMethodBeat.o(255823);
                    return;
                }
            } else if (i2 == 1006) {
                m.vli.a((String) null, s.ba.Timeline);
            }
        }
        AppMethodBeat.o(255823);
    }

    @Override // com.tencent.mm.plugin.finder.viewmodel.component.FinderLiveVisitorUIC, com.tencent.mm.ui.component.UIComponent
    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(255824);
        p.h(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        Log.i("Finder.FinderLiveVisitorUI", "[LiveLifecycle]onConfigurationChanged orientation:" + configuration.orientation);
        AppMethodBeat.o(255824);
    }
}
