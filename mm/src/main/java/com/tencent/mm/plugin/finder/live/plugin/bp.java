package com.tencent.mm.plugin.finder.live.plugin;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.live.c.b;
import com.tencent.mm.plugin.finder.live.widget.o;
import com.tencent.mm.plugin.finder.live.widget.p;
import com.tencent.mm.plugin.finder.live.widget.q;
import com.tencent.mm.plugin.finder.live.widget.r;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.au;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 $2\u00020\u0001:\u0001$B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u0012J\u0006\u0010\u0017\u001a\u00020\u0014J\u000e\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u0014J\u0006\u0010\u001c\u001a\u00020\u0003J\u0006\u0010\u001d\u001a\u00020\u0014J\u000e\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001aJ\u001a\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorBottomOptionPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "giftWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGiftWidget;", "likeWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorLikeWidget;", "linkMicWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorMicEntranceWidget;", "shoppingWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorShoppingEntranceWidget;", "canClearScreen", "", "checkLinkMicGroupState", "", "checkOptionsVisible", "printLog", "checkRequestLinkMic", "hideOption", "option", "", "refreshLikeCount", "shoppingEntranceView", "showMicBottomSheet", "showOption", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-finder_release"})
public final class bp extends d {
    private static final int ums = 2;
    private static final int umt = 1;
    private static final int uvb = 0;
    public static final a uvc = new a((byte) 0);
    private final String TAG = "Finder.FinderLiveVisitorBottomOptionPlugin";
    private final com.tencent.mm.live.c.b hOp;
    public final r uuX;
    public final q uuY;
    public final p uuZ;
    private final o uva;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bp(ViewGroup viewGroup, com.tencent.mm.live.c.b bVar) {
        super(viewGroup, bVar);
        kotlin.g.b.p.h(viewGroup, "root");
        kotlin.g.b.p.h(bVar, "statusMonitor");
        AppMethodBeat.i(247128);
        this.hOp = bVar;
        View findViewById = viewGroup.findViewById(R.id.hql);
        kotlin.g.b.p.g(findViewById, "root.findViewById(R.id.s…pping_entrance_container)");
        this.uuX = new r((ViewGroup) findViewById, this.hOp, this);
        View findViewById2 = viewGroup.findViewById(R.id.ecb);
        kotlin.g.b.p.g(findViewById2, "root.findViewById(R.id.link_entrance_container)");
        this.uuY = new q((ViewGroup) findViewById2, this.hOp, this);
        View findViewById3 = viewGroup.findViewById(R.id.ebc);
        kotlin.g.b.p.g(findViewById3, "root.findViewById(R.id.like_entrance_container)");
        this.uuZ = new p((ViewGroup) findViewById3, this.hOp, this);
        View findViewById4 = viewGroup.findViewById(R.id.dk2);
        kotlin.g.b.p.g(findViewById4, "root.findViewById(R.id.gift_entrance_container)");
        this.uva = new o((ViewGroup) findViewById4, this.hOp, this);
        if (isLandscape()) {
            m mVar = m.vVH;
            m.a((d) this, false);
            AppMethodBeat.o(247128);
            return;
        }
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        if (layoutParams == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(247128);
            throw tVar;
        }
        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin += au.aD(viewGroup.getContext());
        AppMethodBeat.o(247128);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorBottomOptionPlugin$Companion;", "", "()V", "OPTION_LIKE", "", "getOPTION_LIKE", "()I", "OPTION_MIC", "getOPTION_MIC", "OPTION_SHOPPING", "getOPTION_SHOPPING", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(247129);
        AppMethodBeat.o(247129);
    }

    public static /* synthetic */ void b(bp bpVar) {
        AppMethodBeat.i(260739);
        bpVar.Fw(true);
        AppMethodBeat.o(260739);
    }

    public final void Fw(boolean z) {
        AppMethodBeat.i(260738);
        r rVar = this.uuX;
        if (rVar.uFw.getLiveData().uEk) {
            rVar.rg(0);
        } else {
            rVar.rg(8);
        }
        this.uuY.dju();
        this.uva.dju();
        if (this.uuX.isVisible() || this.uuY.isVisible() || this.uuZ.isVisible() || this.uva.isVisible()) {
            rg(0);
        } else {
            rg(8);
        }
        if (z) {
            Log.i(this.TAG, "bottom options [shopping:" + this.uuX.isVisible() + ", linkMic:" + this.uuY.isVisible() + ", gift:" + this.uva.isVisible() + ", like:" + this.uuZ.isVisible() + ']');
        }
        AppMethodBeat.o(260738);
    }

    public final void Jn(int i2) {
        AppMethodBeat.i(247125);
        if (i2 == uvb) {
            p pVar = this.uuZ;
            pVar.hwr.setVisibility(0);
            LinearLayout linearLayout = pVar.uHH;
            kotlin.g.b.p.g(linearLayout, "likeContainer");
            linearLayout.setVisibility(pVar.hwr.getVisibility());
            AppMethodBeat.o(247125);
        } else if (i2 == umt) {
            this.uuX.rg(0);
            AppMethodBeat.o(247125);
        } else {
            if (i2 == ums) {
                this.uuY.hwr.setVisibility(0);
            }
            AppMethodBeat.o(247125);
        }
    }

    public final void dgP() {
        AppMethodBeat.i(247126);
        d.h(new b(this));
        AppMethodBeat.o(247126);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        AppMethodBeat.i(247127);
        kotlin.g.b.p.h(cVar, "status");
        switch (bq.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                this.uuY.dju();
                this.uva.dju();
                AppMethodBeat.o(247127);
                return;
            case 2:
                m mVar = m.vVH;
                m.a((d) this, false);
                AppMethodBeat.o(247127);
                return;
            case 3:
                p pVar = this.uuZ;
                Animation loadAnimation = AnimationUtils.loadAnimation(pVar.hwr.getContext(), R.anim.y);
                RelativeLayout relativeLayout = pVar.uHI;
                if (relativeLayout != null) {
                    relativeLayout.startAnimation(loadAnimation);
                    AppMethodBeat.o(247127);
                    return;
                }
                break;
        }
        AppMethodBeat.o(247127);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final boolean dgK() {
        return true;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class b extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ bp uvd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(bp bpVar) {
            super(0);
            this.uvd = bpVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0032, code lost:
            if (com.tencent.mm.sdk.platformtools.Util.isEqual(r0, r1.uFw.getLiveData().djq()) == false) goto L_0x0034;
         */
        @Override // kotlin.g.a.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ kotlin.x invoke() {
            /*
            // Method dump skipped, instructions count: 197
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.plugin.bp.b.invoke():java.lang.Object");
        }
    }
}
