package com.tencent.mm.plugin.finder.presenter.contract;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLiveSubTagConstract;
import com.tencent.mm.protocal.protobuf.axk;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
public final class FinderLiveSubTagConstract$ViewCallback$initView$4 implements View.OnClickListener {
    final /* synthetic */ FinderLiveSubTagConstract.ViewCallback uXE;

    FinderLiveSubTagConstract$ViewCallback$initView$4(FinderLiveSubTagConstract.ViewCallback viewCallback) {
        this.uXE = viewCallback;
    }

    public final void onClick(View view) {
        String str;
        String str2;
        String str3;
        axk axk;
        axk axk2;
        String str4 = null;
        AppMethodBeat.i(249812);
        b bVar = new b();
        bVar.bm(view);
        a.b("com/tencent/mm/plugin/finder/presenter/contract/FinderLiveSubTagConstract$ViewCallback$initView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        StringBuilder sb = new StringBuilder("select live tag finish. lastTag:[");
        axk axk3 = FinderLiveSubTagConstract.ViewCallback.c(this.uXE).getLiveData().uix;
        if (axk3 != null) {
            str = axk3.qHk;
        } else {
            str = null;
        }
        StringBuilder append = sb.append(str).append('-');
        axk axk4 = FinderLiveSubTagConstract.ViewCallback.c(this.uXE).getLiveData().uix;
        if (axk4 == null || (axk2 = axk4.LHU) == null) {
            str2 = null;
        } else {
            str2 = axk2.qHk;
        }
        StringBuilder append2 = append.append(str2).append("] selectedTag:[");
        axk axk5 = FinderLiveSubTagConstract.ViewCallback.c(this.uXE).uXq;
        if (axk5 != null) {
            str3 = axk5.qHk;
        } else {
            str3 = null;
        }
        StringBuilder append3 = append2.append(str3).append('-');
        axk axk6 = FinderLiveSubTagConstract.ViewCallback.c(this.uXE).uXq;
        if (!(axk6 == null || (axk = axk6.LHU) == null)) {
            str4 = axk.qHk;
        }
        Log.i("FinderLiveSubTagConstract.ViewCallback", append3.append(str4).append(']').toString());
        FinderLiveSubTagConstract.ViewCallback.c(this.uXE).getLiveData().uix = FinderLiveSubTagConstract.ViewCallback.c(this.uXE).uXq;
        FinderLiveSubTagConstract.ViewCallback.b(this.uXE).setResult(-1);
        FinderLiveSubTagConstract.ViewCallback.b(this.uXE).finish();
        a.a(this, "com/tencent/mm/plugin/finder/presenter/contract/FinderLiveSubTagConstract$ViewCallback$initView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(249812);
    }
}
