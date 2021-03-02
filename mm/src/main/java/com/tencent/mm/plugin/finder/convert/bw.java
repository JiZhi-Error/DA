package com.tencent.mm.plugin.finder.convert;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.report.m;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bfx;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.e;
import com.tencent.mm.view.f;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B\u0017\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\u0006H\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J@\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u000f2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aH\u0016J \u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0006H\u0016J\u0010\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0012\u0010 \u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u001bH\u0002R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderOpenEntranceTipConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/BaseLocalFeed;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "tabType", "", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;I)V", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "doReport", "", FirebaseAnalytics.b.INDEX, "getLayoutId", "isFinderClose", "", "extStatus", "", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "openFinderEntrance", "toIntSafely", "Companion", "plugin-finder_release"})
public final class bw extends e<com.tencent.mm.plugin.finder.model.b> {
    public static final a tFl = new a((byte) 0);
    private final int dLS;
    final bbn ttO;

    static {
        AppMethodBeat.i(243221);
        AppMethodBeat.o(243221);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderOpenEntranceTipConvert$Companion;", "", "()V", "FINDER_ENTRANCE_ID", "", "STATUS_CLOSE", "STATUS_OPEN", "TAB_FOLLOW", "TAB_FRIEND", "TAB_HOT", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public bw(bbn bbn, int i2) {
        this.ttO = bbn;
        this.dLS = i2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.view.recyclerview.e
    public final /* synthetic */ void a(h hVar, com.tencent.mm.plugin.finder.model.b bVar, int i2, int i3, boolean z, List list) {
        AppMethodBeat.i(243220);
        p.h(hVar, "holder");
        p.h(bVar, "item");
        LinearLayout linearLayout = (LinearLayout) hVar.aus.findViewById(R.id.g4c);
        p.g(linearLayout, "tipsLl");
        if (linearLayout.getTag() == null) {
            linearLayout.setTag(Integer.valueOf(i2));
        }
        AppMethodBeat.o(243220);
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return R.layout.ahs;
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, h hVar, int i2) {
        AppMethodBeat.i(243219);
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        TextView textView = (TextView) hVar.aus.findViewById(R.id.g4d);
        p.g(textView, "tipsTv");
        ao.a(textView.getPaint(), 0.8f);
        LinearLayout linearLayout = (LinearLayout) hVar.aus.findViewById(R.id.g4c);
        View view = hVar.aus;
        p.g(view, "holder.itemView");
        f.a(view, new b(this, linearLayout));
        linearLayout.setOnClickListener(new c(this, linearLayout, recyclerView));
        if (y.a(y.vXH, this.dLS, 0, 2)) {
            Context context = hVar.getContext();
            p.g(context, "holder.context");
            int color = context.getResources().getColor(R.color.vj);
            textView.setTextColor(color);
            WeImageView weImageView = (WeImageView) hVar.aus.findViewById(R.id.g4b);
            if (weImageView != null) {
                weImageView.setIconColor(color);
            }
            View findViewById = hVar.aus.findViewById(R.id.g4c);
            if (findViewById != null) {
                findViewById.setBackgroundResource(R.color.rv);
                AppMethodBeat.o(243219);
                return;
            }
        }
        AppMethodBeat.o(243219);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/finder/convert/FinderOpenEntranceTipConvert$onCreateViewHolder$1", "Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;", "onViewExposed", "", "view", "Landroid/view/View;", "oldExposedId", "", "newExposedId", "isExposed", "", "plugin-finder_release"})
    public static final class b extends e.b {
        final /* synthetic */ bw tFm;
        final /* synthetic */ LinearLayout tFn;

        b(bw bwVar, LinearLayout linearLayout) {
            this.tFm = bwVar;
            this.tFn = linearLayout;
        }

        @Override // com.tencent.mm.view.e.b
        public final void p(View view, boolean z) {
            AppMethodBeat.i(243217);
            p.h(view, "view");
            if (z) {
                LinearLayout linearLayout = this.tFn;
                p.g(linearLayout, "tipsLl");
                int dj = bw.dj(linearLayout.getTag());
                m.a aVar = m.vfD;
                m unused = m.vfC;
                m.a(this.tFm.ttO, 1, System.currentTimeMillis(), dj - 1);
            }
            AppMethodBeat.o(243217);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c implements View.OnClickListener {
        final /* synthetic */ RecyclerView tDJ;
        final /* synthetic */ bw tFm;
        final /* synthetic */ LinearLayout tFn;

        c(bw bwVar, LinearLayout linearLayout, RecyclerView recyclerView) {
            this.tFm = bwVar;
            this.tFn = linearLayout;
            this.tDJ = recyclerView;
        }

        public final void onClick(View view) {
            int i2;
            String str;
            List b2;
            String str2;
            AppMethodBeat.i(243218);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderOpenEntranceTipConvert$onCreateViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            bbn bbn = this.tFm.ttO;
            com.tencent.mm.plugin.expt.hellhound.core.b.aoW(bbn != null ? bbn.sGQ : null);
            long aUd = z.aUd();
            if (bw.Ef(aUd)) {
                bw.Eg(aUd);
            }
            LinearLayout linearLayout = this.tFn;
            p.g(linearLayout, "tipsLl");
            int dj = bw.dj(linearLayout.getTag());
            int i3 = 18;
            String str3 = "KEY_FINDER_POST_FINISH_JUMP_FRIEND_TAB";
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            switch (com.tencent.mm.plugin.finder.storage.c.dvK().value().intValue()) {
                case 0:
                    i3 = 17;
                    str3 = "KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB";
                    break;
                case 2:
                    i3 = 19;
                    str3 = "KEY_FINDER_POST_FINISH_JUMP_HOT_TAB";
                    break;
            }
            bw.a(this.tFm, dj);
            if (this.tDJ.getContext() instanceof Activity) {
                Context context = this.tDJ.getContext();
                if (context == null) {
                    t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                    AppMethodBeat.o(243218);
                    throw tVar;
                }
                ((Activity) context).finish();
            }
            Intent intent = new Intent();
            intent.putExtra(str3, true);
            intent.putExtra("KEY_FROM_SHARE_REL", true);
            bbn bbn2 = this.tFm.ttO;
            if (bbn2 == null || (str = bbn2.sGQ) == null || (b2 = n.b(str, new char[]{'-'})) == null || (str2 = (String) b2.get(0)) == null) {
                i2 = -1;
            } else {
                i2 = Integer.parseInt(str2);
            }
            if (i2 > 0 && i3 > 0) {
                ((aj) g.ah(aj.class)).fillContextIdToIntent(i2, 9, i3, intent);
            }
            com.tencent.mm.plugin.finder.report.h hVar = com.tencent.mm.plugin.finder.report.h.veu;
            com.tencent.mm.plugin.finder.report.h.dnS();
            com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
            Context context2 = this.tDJ.getContext();
            p.g(context2, "recyclerView.context");
            com.tencent.mm.plugin.finder.utils.a.a(context2, intent, 1);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderOpenEntranceTipConvert$onCreateViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(243218);
        }
    }

    public static final /* synthetic */ int dj(Object obj) {
        AppMethodBeat.i(243222);
        if (obj == null || !(obj instanceof Integer)) {
            AppMethodBeat.o(243222);
            return -1;
        }
        int intValue = ((Number) obj).intValue();
        AppMethodBeat.o(243222);
        return intValue;
    }

    public static final /* synthetic */ boolean Ef(long j2) {
        return (34359738368L & j2) != 0;
    }

    public static final /* synthetic */ void Eg(long j2) {
        AppMethodBeat.i(243223);
        long j3 = -34359738369L & j2;
        com.tencent.mm.kernel.e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        aAh.azQ().set(147457, Long.valueOf(j3));
        Log.i("Finder.FinderOpenEntranceTipConvert", "openFinderEntrance extstatus:".concat(String.valueOf(j3)));
        bfx bfx = new bfx();
        bfx.LPB = 57;
        bfx.BsD = 1;
        com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
        ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSM().d(new k.a(23, bfx));
        Log.d("Finder.FinderOpenEntranceTipConvert", "openFinderEntrance switch functionId:" + bfx.LPB + " to " + bfx.BsD);
        AppMethodBeat.o(243223);
    }

    public static final /* synthetic */ void a(bw bwVar, int i2) {
        AppMethodBeat.i(243224);
        if (i2 > 0) {
            m.a aVar = m.vfD;
            m unused = m.vfC;
            m.a(bwVar.ttO, 2, System.currentTimeMillis(), i2 - 1);
        }
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(15185, 11, 1, 2);
        AppMethodBeat.o(243224);
    }
}
