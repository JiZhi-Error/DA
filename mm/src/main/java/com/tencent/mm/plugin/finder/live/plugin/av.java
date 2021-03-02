package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.viewmodel.d;
import com.tencent.mm.plugin.finder.live.viewmodel.f;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.axj;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0006\u0010\u0011\u001a\u00020\u0012R\u0014\u0010\t\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMoreLiveEntrancePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "moreLiveEntrance", "Landroid/view/View;", "canClearScreen", "", "checkMoreLiveEntranceVisible", "", "plugin-finder_release"})
public final class av extends d {
    final String TAG = "FinderLiveMoreLiveEntrancePlugin";
    private final com.tencent.mm.live.c.b hOy;
    View utl;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public av(ViewGroup viewGroup, com.tencent.mm.live.c.b bVar, bbn bbn) {
        super(viewGroup, bVar, bbn);
        p.h(viewGroup, "root");
        p.h(bVar, "statueMonitor");
        AppMethodBeat.i(246938);
        this.hOy = bVar;
        this.utl = viewGroup.findViewById(R.id.cw0);
        AppMethodBeat.o(246938);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final boolean dgK() {
        return true;
    }

    public final void dhJ() {
        Integer num;
        f fVar;
        AppMethodBeat.i(246937);
        m mVar = m.vVH;
        if (m.dBP()) {
            rg(8);
            AppMethodBeat.o(246937);
            return;
        }
        o oVar = o.ujN;
        d dfY = o.dfY();
        if (dfY == null || (fVar = dfY.ufx) == null) {
            num = null;
        } else {
            num = Integer.valueOf(fVar.tCE);
        }
        Log.i(this.TAG, "checkMoreLiveEntranceState commentScene:".concat(String.valueOf(num)));
        if (num == null || num.intValue() == 94 || num.intValue() == 80) {
            View view = this.utl;
            if (view != null) {
                view.setVisibility(8);
                AppMethodBeat.o(246937);
                return;
            }
            AppMethodBeat.o(246937);
            return;
        }
        rg(0);
        com.tencent.mm.plugin.finder.report.live.m.vli.a(s.ag.EXPLORE_MORE_LIVE);
        View view2 = this.utl;
        if (view2 != null) {
            view2.post(new a(this));
        }
        View view3 = this.utl;
        if (view3 != null) {
            view3.setOnClickListener(new b(this, num));
        }
        if (isLandscape()) {
            m mVar2 = m.vVH;
            Context context = this.hwr.getContext();
            p.g(context, "root.context");
            m mVar3 = m.vVH;
            int B = m.B(context, m.i(getLiveData()));
            View view4 = this.utl;
            ViewGroup.LayoutParams layoutParams = view4 != null ? view4.getLayoutParams() : null;
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(246937);
                throw tVar;
            }
            ((ViewGroup.MarginLayoutParams) layoutParams).setMarginEnd(B);
        }
        AppMethodBeat.o(246937);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class a implements Runnable {
        final /* synthetic */ av utm;

        a(av avVar) {
            this.utm = avVar;
        }

        public final void run() {
            AppMethodBeat.i(246935);
            Rect rect = new Rect();
            View view = this.utm.utl;
            if (view != null) {
                view.getHitRect(rect);
            }
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.ct);
            rect.inset(-dimensionPixelOffset, -dimensionPixelOffset);
            View view2 = this.utm.utl;
            ViewParent parent = view2 != null ? view2.getParent() : null;
            if (parent == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.View");
                AppMethodBeat.o(246935);
                throw tVar;
            }
            ((View) parent).setTouchDelegate(new TouchDelegate(rect, this.utm.utl));
            AppMethodBeat.o(246935);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class b implements View.OnClickListener {
        final /* synthetic */ av utm;
        final /* synthetic */ Integer utn;

        b(av avVar, Integer num) {
            this.utm = avVar;
            this.utn = num;
        }

        public final void onClick(View view) {
            Integer num;
            awe awe;
            String str = null;
            AppMethodBeat.i(246936);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveMoreLiveEntrancePlugin$checkMoreLiveEntranceVisible$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            FinderObject finderObject = this.utm.getLiveData().uDz;
            axj axj = (finderObject == null || (awe = finderObject.liveInfo) == null) ? null : awe.LGV;
            String str2 = this.utm.TAG;
            StringBuilder append = new StringBuilder("moreLiveEntrance click,source tabType:").append(this.utn).append(",tabId:");
            if (axj != null) {
                num = Integer.valueOf(axj.LHQ);
            } else {
                num = null;
            }
            StringBuilder append2 = append.append(num).append(",tabName:");
            if (axj != null) {
                str = axj.LHR;
            }
            Log.i(str2, append2.append(str).toString());
            com.tencent.mm.plugin.finder.report.live.m.vli.a(s.ag.CLICK_MORE_LIVE);
            com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
            Context context = this.utm.hwr.getContext();
            p.g(context, "root.context");
            Intent intent = new Intent();
            if (axj != null) {
                intent.putExtra("nearby_live_go_to_square_pge_params_key", axj.toByteArray());
            }
            bbn bbn = this.utm.reportObj;
            if (bbn != null) {
                intent.putExtra("key_context_id", bbn.sGQ);
            }
            com.tencent.mm.plugin.finder.utils.a.Z(context, intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveMoreLiveEntrancePlugin$checkMoreLiveEntranceVisible$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(246936);
        }
    }
}
