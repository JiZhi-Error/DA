package com.tencent.mm.plugin.story.ui.view;

import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001c\u001a\u00020\fH\u0002J\b\u0010\u001d\u001a\u00020\u0011H\u0002J\u0006\u0010\u001e\u001a\u00020\u0011R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R7\u0010\r\u001a\u001f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R7\u0010\u0016\u001a\u001f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R7\u0010\u0019\u001a\u001f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/ViewClickHelper;", "", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "clickDelay", "", "clickRecord", "", "endRecordRunnable", "Ljava/lang/Runnable;", "isRecording", "", "onClickListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "getOnClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnClickListener", "(Lkotlin/jvm/functions/Function1;)V", "onDoubleClickListener", "getOnDoubleClickListener", "setOnDoubleClickListener", "onTripleClickListener", "getOnTripleClickListener", "setOnTripleClickListener", "checkDispatch", "dispatchClickEvent", "recordClick", "plugin-story_release"})
public final class g {
    b<? super View, x> FEm;
    public b<? super View, x> FEn;
    b<? super View, x> FEo;
    int FEp;
    final long FEq = ((long) ViewConfiguration.getDoubleTapTimeout());
    Runnable FEr = new a(this);
    boolean ipv;
    private final View view;

    public g(View view2) {
        p.h(view2, "view");
        AppMethodBeat.i(120316);
        this.view = view2;
        AppMethodBeat.o(120316);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class a implements Runnable {
        final /* synthetic */ g FEs;

        a(g gVar) {
            this.FEs = gVar;
        }

        public final void run() {
            AppMethodBeat.i(120314);
            this.FEs.fsj();
            AppMethodBeat.o(120314);
        }
    }

    /* access modifiers changed from: package-private */
    public final void fsj() {
        AppMethodBeat.i(120315);
        switch (this.FEp) {
            case 1:
                b<? super View, x> bVar = this.FEm;
                if (bVar != null) {
                    bVar.invoke(this.view);
                    break;
                }
                break;
            case 2:
                b<? super View, x> bVar2 = this.FEn;
                if (bVar2 != null) {
                    bVar2.invoke(this.view);
                    break;
                }
                break;
            case 3:
                b<? super View, x> bVar3 = this.FEo;
                if (bVar3 != null) {
                    bVar3.invoke(this.view);
                    break;
                }
                break;
        }
        this.FEp = 0;
        this.ipv = false;
        AppMethodBeat.o(120315);
    }
}
