package com.tencent.mm.live.view;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.x;
import com.tencent.mm.live.core.mini.AbsLiveMiniView;
import com.tencent.mm.live.core.mini.d;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/live/view/RoomLiveMiniView;", "Lcom/tencent/mm/live/core/mini/AbsLiveMiniView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "floatScene", "updateState", "", "state", "Lcom/tencent/mm/live/core/mini/LiveMiniState;", "plugin-logic_release"})
public final class RoomLiveMiniView extends AbsLiveMiniView {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RoomLiveMiniView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(208645);
        x xVar = x.hJf;
        setOnClickListener(x.aHc());
        AppMethodBeat.o(208645);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public RoomLiveMiniView(Context context) {
        this(context, null, 0);
        p.h(context, "context");
        AppMethodBeat.i(208646);
        AppMethodBeat.o(208646);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public RoomLiveMiniView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(208647);
        AppMethodBeat.o(208647);
    }

    @Override // com.tencent.mm.live.core.mini.AbsLiveMiniView
    public final void b(d dVar) {
        AppMethodBeat.i(208644);
        p.h(dVar, "state");
        AppMethodBeat.o(208644);
    }

    @Override // com.tencent.mm.live.core.mini.AbsLiveMiniView
    public final int aEg() {
        return 16;
    }
}
