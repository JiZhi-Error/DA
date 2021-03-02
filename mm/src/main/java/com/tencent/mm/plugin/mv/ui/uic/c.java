package com.tencent.mm.plugin.mv.ui.uic;

import android.view.View;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0014\u0010\u0010\u001a\u00020\u00002\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0012J\u001e\u0010\u0013\u001a\u00020\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u0014\u001a\u00020\u0007H\u0002J\u0014\u0010\u0015\u001a\u00020\u00002\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0012J\u0006\u0010\u0016\u001a\u00020\u000fJ\u0014\u0010\u0014\u001a\u00020\u00002\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0012R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R*\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/uic/VisibleRecord;", "", "()V", "TAG", "", "changedMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/mv/ui/uic/VisibleRecord$ViewState;", "Lkotlin/collections/HashMap;", "parent", "Landroid/view/View;", "animate", "view", "clean", "", "gone", "ids", "", MessengerShareContentUtility.SHARE_BUTTON_HIDE, "visible", "invisible", "restore", "ViewState", "plugin-mv_release"})
public final class c {
    public final HashMap<Integer, a> Awq = new HashMap<>();
    private final String TAG = "MicroMsg.VisibleRecord";
    private View hVd;

    public c() {
        AppMethodBeat.i(257396);
        AppMethodBeat.o(257396);
    }

    public final c eD(View view) {
        AppMethodBeat.i(257390);
        this.hVd = view;
        this.Awq.clear();
        AppMethodBeat.o(257390);
        return this;
    }

    public final c s(Set<Integer> set) {
        AppMethodBeat.i(257391);
        p.h(set, "ids");
        Log.i(this.TAG, "gone: ");
        a(set, 8);
        AppMethodBeat.o(257391);
        return this;
    }

    public final c t(Set<Integer> set) {
        AppMethodBeat.i(257392);
        p.h(set, "ids");
        a(set, 4);
        AppMethodBeat.o(257392);
        return this;
    }

    public final c u(Set<Integer> set) {
        View findViewById;
        AppMethodBeat.i(257393);
        p.h(set, "ids");
        for (Integer num : set) {
            int intValue = num.intValue();
            View view = this.hVd;
            if (!(view == null || (findViewById = view.findViewById(intValue)) == null)) {
                int visibility = findViewById.getVisibility();
                boolean z = visibility != 0;
                a aVar = new a(intValue, visibility, findViewById.getAlpha(), 0, 1.0f, z);
                this.Awq.put(Integer.valueOf(intValue), aVar);
                if (z) {
                    findViewById.animate().cancel();
                    findViewById.setVisibility(0);
                    findViewById.animate().alpha(aVar.Awt).setDuration(300).start();
                }
            }
        }
        AppMethodBeat.o(257393);
        return this;
    }

    public final void restore() {
        View view;
        View findViewById;
        AppMethodBeat.i(257394);
        for (a aVar : this.Awq.values()) {
            if (!(!aVar.bGB || (view = this.hVd) == null || (findViewById = view.findViewById(aVar.id)) == null)) {
                findViewById.animate().cancel();
                if (aVar.qJE == 0) {
                    findViewById.setVisibility(aVar.qJE);
                    findViewById.animate().alpha(aVar.Awr).setDuration(300).start();
                } else {
                    findViewById.animate().alpha(aVar.Awr).setDuration(300).withEndAction(new RunnableC1558c(findViewById, aVar)).start();
                }
            }
        }
        this.Awq.clear();
        AppMethodBeat.o(257394);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.mv.ui.uic.c$c  reason: collision with other inner class name */
    public static final class RunnableC1558c implements Runnable {
        final /* synthetic */ a Awu;
        final /* synthetic */ View wbW;

        RunnableC1558c(View view, a aVar) {
            this.wbW = view;
            this.Awu = aVar;
        }

        public final void run() {
            AppMethodBeat.i(257389);
            this.wbW.setVisibility(this.Awu.qJE);
            AppMethodBeat.o(257389);
        }
    }

    private final void a(Set<Integer> set, int i2) {
        View findViewById;
        AppMethodBeat.i(257395);
        for (Integer num : set) {
            int intValue = num.intValue();
            View view = this.hVd;
            if (!(view == null || (findViewById = view.findViewById(intValue)) == null)) {
                int visibility = findViewById.getVisibility();
                boolean z = visibility != i2;
                a aVar = new a(intValue, visibility, findViewById.getAlpha(), i2, 0.0f, z);
                this.Awq.put(Integer.valueOf(intValue), aVar);
                if (z) {
                    findViewById.animate().cancel();
                    findViewById.animate().alpha(aVar.Awt).setDuration(300).withEndAction(new b(findViewById, aVar)).start();
                }
            }
        }
        AppMethodBeat.o(257395);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class b implements Runnable {
        final /* synthetic */ a Awu;
        final /* synthetic */ View wbW;

        b(View view, a aVar) {
            this.wbW = view;
            this.Awu = aVar;
        }

        public final void run() {
            AppMethodBeat.i(257388);
            this.wbW.setVisibility(this.Awu.Aws);
            AppMethodBeat.o(257388);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/uic/VisibleRecord$ViewState;", "", "id", "", "startState", "startAlpha", "", "endState", "endAlpha", "changed", "", "(IIFIFZ)V", "getChanged", "()Z", "getEndAlpha", "()F", "getEndState", "()I", "getId", "getStartAlpha", "getStartState", "plugin-mv_release"})
    public static final class a {
        final float Awr;
        final int Aws;
        final float Awt;
        final boolean bGB;
        final int id;
        final int qJE;

        public a(int i2, int i3, float f2, int i4, float f3, boolean z) {
            this.id = i2;
            this.qJE = i3;
            this.Awr = f2;
            this.Aws = i4;
            this.Awt = f3;
            this.bGB = z;
        }
    }
}
