package com.tencent.mm.plugin.finder.view.manager;

import android.content.Context;
import android.text.Editable;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.utils.d;
import com.tencent.mm.plugin.finder.utils.w;
import com.tencent.mm.plugin.finder.view.FinderPostEditText;
import com.tencent.mm.plugin.finder.view.manager.b;
import com.tencent.mm.plugin.finder.view.manager.e;
import com.tencent.mm.protocal.protobuf.cjj;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.o;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 #2\u00020\u0001:\u0001#B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0018\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010 \u001a\u00020\u001aH\u0002J\b\u0010!\u001a\u00020\u001aH\u0002J\u0006\u0010\"\u001a\u00020\u001aR\u001a\u0010\u0007\u001a\u00020\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/manager/FinderStyleManager;", "", "descTv", "Lcom/tencent/mm/plugin/finder/view/FinderPostEditText;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/plugin/finder/view/FinderPostEditText;Lcom/tencent/mm/ui/MMActivity;)V", "activityPostManager", "Lcom/tencent/mm/plugin/finder/view/manager/FinderActivityPostManager;", "getActivityPostManager", "()Lcom/tencent/mm/plugin/finder/view/manager/FinderActivityPostManager;", "setActivityPostManager", "(Lcom/tencent/mm/plugin/finder/view/manager/FinderActivityPostManager;)V", "atManager", "Lcom/tencent/mm/plugin/finder/view/manager/FinderAtManager;", "getAtManager", "()Lcom/tencent/mm/plugin/finder/view/manager/FinderAtManager;", "setAtManager", "(Lcom/tencent/mm/plugin/finder/view/manager/FinderAtManager;)V", "topicSuggestManager", "Lcom/tencent/mm/plugin/finder/view/manager/FinderTopicSuggestManager;", "getTopicSuggestManager", "()Lcom/tencent/mm/plugin/finder/view/manager/FinderTopicSuggestManager;", "setTopicSuggestManager", "(Lcom/tencent/mm/plugin/finder/view/manager/FinderTopicSuggestManager;)V", "extractTopicAndSetSpan", "", "curDesc", "", "s", "Landroid/text/Editable;", "iniFinderTopicSuggestManager", "initFinderAtManager", "initPostManager", "release", "Companion", "plugin-finder_release"})
public final class d {
    private static final String TAG = TAG;
    public static final a wts = new a((byte) 0);
    public e wtp;
    public b wtq = new b();
    public a wtr = new a();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/manager/FinderStyleManager$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(255288);
        AppMethodBeat.o(255288);
    }

    public final b dHI() {
        AppMethodBeat.i(255285);
        b bVar = this.wtq;
        if (bVar == null) {
            p.btv("atManager");
        }
        AppMethodBeat.o(255285);
        return bVar;
    }

    public d(FinderPostEditText finderPostEditText, MMActivity mMActivity) {
        p.h(finderPostEditText, "descTv");
        p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(255287);
        this.wtp = new e(finderPostEditText, mMActivity);
        AppMethodBeat.o(255287);
    }

    public final void a(String str, Editable editable) {
        AppMethodBeat.i(255286);
        p.h(str, "curDesc");
        p.h(editable, "s");
        Editable editable2 = editable;
        ForegroundColorSpan[] foregroundColorSpanArr = (ForegroundColorSpan[]) editable2.getSpans(0, editable2.length(), ForegroundColorSpan.class);
        p.g(foregroundColorSpanArr, "spans");
        for (ForegroundColorSpan foregroundColorSpan : foregroundColorSpanArr) {
            editable2.removeSpan(foregroundColorSpan);
        }
        c cVar = c.vCb;
        if (c.drO()) {
            b bVar = this.wtq;
            if (bVar == null) {
                p.btv("atManager");
            }
            p.h(str, "curDesc");
            p.h(editable, "s");
            bVar.vTC.clear();
            bVar.wsH.clear();
            com.tencent.mm.plugin.finder.utils.d dVar = com.tencent.mm.plugin.finder.utils.d.vVg;
            o<ArrayList<cjj>, ArrayList<d.a>> a2 = com.tencent.mm.plugin.finder.utils.d.a(str, bVar.wsG, new b.C1343b(editable));
            bVar.vTC.addAll(a2.first);
            bVar.wsH.addAll(a2.second);
        }
        c cVar2 = c.vCb;
        if (c.drN()) {
            e eVar = this.wtp;
            if (eVar == null) {
                p.btv("topicSuggestManager");
            }
            b bVar2 = this.wtq;
            if (bVar2 == null) {
                p.btv("atManager");
            }
            ArrayList<d.a> arrayList = bVar2.wsH;
            p.h(str, "curDesc");
            p.h(editable, "s");
            p.h(arrayList, "atStringInfoList");
            eVar.wtt.clear();
            w wVar = w.vXp;
            eVar.wtt.addAll(w.a(str, arrayList, new e.b(editable)));
        }
        a aVar = this.wtr;
        if (aVar == null) {
            p.btv("activityPostManager");
        }
        p.h(str, "curDesc");
        p.h(editable, "s");
        int a3 = n.a((CharSequence) str, aVar.wsz, 0, false, 6);
        if (Util.isNullOrNil(aVar.wsz) || a3 < 0) {
            View view = aVar.wsA;
            if (view != null) {
                view.setVisibility(0);
                AppMethodBeat.o(255286);
                return;
            }
            AppMethodBeat.o(255286);
            return;
        }
        aVar.wsB = true;
        Editable editable3 = editable;
        int length = aVar.wsz.length() + a3;
        Context context = MMApplicationContext.getContext();
        p.g(context, "MMApplicationContext.getContext()");
        editable3.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.x0)), a3, length, 17);
        Context context2 = MMApplicationContext.getContext();
        p.g(context2, "MMApplicationContext.getContext()");
        editable3.setSpan(new BackgroundColorSpan(context2.getResources().getColor(R.color.ti)), a3, length, 17);
        AppMethodBeat.o(255286);
    }
}
