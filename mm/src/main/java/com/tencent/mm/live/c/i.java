package com.tencent.mm.live.c;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.b.o;
import com.tencent.mm.live.b.r;
import com.tencent.mm.live.b.x;
import com.tencent.mm.live.c.b;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.e;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u001d\u001a\u00020\u001eH\u0016J,\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0010\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\u0018H\u0002J\u0006\u0010)\u001a\u00020\u001eJ\b\u0010*\u001a\u00020\u001eH\u0002J\u001a\u0010+\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u00100\u001a\u00020\u001eH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n \u0016*\u0004\u0018\u00010\u00150\u0015X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u00061"}, hxF = {"Lcom/tencent/mm/live/plugin/LiveBanCommentPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "banCommentBtn", "Landroid/widget/ImageView;", "banCommentClickArea", "Landroid/widget/RelativeLayout;", "banCommentDescTv", "Landroid/widget/TextView;", "banCommentLoadingView", "Landroid/widget/ProgressBar;", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "bottomSheetItemClickListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "enableComment", "", "getEnableComment", "()Z", "setEnableComment", "(Z)V", "mount", "", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "showBanCommentBottomSheet", "enable", "showBanCommentBtn", "showLoading", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "plugin-logic_release"})
public final class i extends a implements com.tencent.mm.ak.i {
    Context context;
    private final ImageView hOR;
    private final RelativeLayout hOS;
    private final TextView hOT;
    private final ProgressBar hOU;
    public boolean hOV = true;
    private final b hOp;
    e hOv;
    final o.g hOx = new a(this);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(ViewGroup viewGroup, b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(207929);
        this.hOp = bVar;
        this.context = viewGroup.getContext();
        View findViewById = viewGroup.findViewById(R.id.efn);
        p.g(findViewById, "root.findViewById(R.id.live_ban_comment_icon)");
        this.hOR = (ImageView) findViewById;
        View findViewById2 = viewGroup.findViewById(R.id.efo);
        p.g(findViewById2, "root.findViewById(R.id.l…_comment_icon_click_area)");
        this.hOS = (RelativeLayout) findViewById2;
        View findViewById3 = viewGroup.findViewById(R.id.efp);
        p.g(findViewById3, "root.findViewById(R.id.l…ban_comment_icon_desc_tv)");
        this.hOT = (TextView) findViewById3;
        View findViewById4 = viewGroup.findViewById(R.id.efr);
        p.g(findViewById4, "root.findViewById(R.id.live_ban_comment_loading)");
        this.hOU = (ProgressBar) findViewById4;
        ImageView imageView = this.hOR;
        Context context2 = viewGroup.getContext();
        p.g(context2, "root.context");
        imageView.setImageDrawable(ar.e(context2.getResources().getDrawable(R.raw.icons_filled_chat), -1));
        this.hOS.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.live.c.i.AnonymousClass1 */
            final /* synthetic */ i hOW;

            {
                this.hOW = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(207920);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveBanCommentPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (this.hOW.hOV) {
                    i iVar = this.hOW;
                    boolean z = this.hOW.hOV;
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    if (z) {
                        Context context = iVar.context;
                        p.g(context, "context");
                        arrayList.add(context.getResources().getString(R.string.eha));
                    } else {
                        Context context2 = iVar.context;
                        p.g(context2, "context");
                        arrayList.add(context2.getResources().getString(R.string.eh_));
                    }
                    o.g gVar = o.g.hHa;
                    arrayList2.add(Integer.valueOf(o.g.aFF()));
                    if (z) {
                        iVar.hOv = new e(iVar.context, 1, true);
                        View inflate = View.inflate(iVar.context, R.layout.b0l, null);
                        TextView textView = (TextView) inflate.findViewById(R.id.eg6);
                        e eVar = iVar.hOv;
                        if (eVar != null) {
                            eVar.setTitleView(inflate);
                        }
                        p.g(textView, "bottomSheetTitleTv");
                        Context context3 = iVar.hwr.getContext();
                        p.g(context3, "root.context");
                        textView.setText(context3.getResources().getString(R.string.efg));
                    } else {
                        iVar.hOv = new e(iVar.context, 1, false);
                    }
                    e eVar2 = iVar.hOv;
                    if (eVar2 != null) {
                        eVar2.a(new b(iVar, arrayList, arrayList2));
                    }
                    e eVar3 = iVar.hOv;
                    if (eVar3 != null) {
                        eVar3.hbr();
                    }
                    e eVar4 = iVar.hOv;
                    if (eVar4 != null) {
                        eVar4.a(iVar.hOx);
                    }
                    e eVar5 = iVar.hOv;
                    if (eVar5 != null) {
                        eVar5.b(new c(iVar));
                    }
                    e eVar6 = iVar.hOv;
                    if (eVar6 != null) {
                        eVar6.dGm();
                    }
                } else {
                    r rVar = r.hIg;
                    r.eF(true);
                    x xVar = x.hJf;
                    String aGm = x.aGm();
                    x xVar2 = x.hJf;
                    long j2 = x.aGr().hyH;
                    x xVar3 = x.hJf;
                    String aGt = x.aGt();
                    x xVar4 = x.hJf;
                    com.tencent.mm.live.d.e.a(aGm, j2, aGt, 4, 0, x.aGr().LIa);
                    com.tencent.mm.live.d.a.aHZ();
                    i.a(this.hOW);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveBanCommentPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(207920);
            }
        });
        if (!isLandscape() && viewGroup.getLayoutParams() != null && (viewGroup.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(207929);
                throw tVar;
            }
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin += au.aD(viewGroup.getContext());
        }
        AppMethodBeat.o(207929);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected"})
    static final class a implements o.g {
        final /* synthetic */ i hOW;

        a(i iVar) {
            this.hOW = iVar;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(207922);
            p.g(menuItem, "menuItem");
            int itemId = menuItem.getItemId();
            o.g gVar = o.g.hHa;
            if (itemId == o.g.aFF()) {
                if (this.hOW.hOV) {
                    r rVar = r.hIg;
                    r.eF(false);
                    x xVar = x.hJf;
                    String aGm = x.aGm();
                    x xVar2 = x.hJf;
                    long j2 = x.aGr().hyH;
                    x xVar3 = x.hJf;
                    String aGt = x.aGt();
                    x xVar4 = x.hJf;
                    com.tencent.mm.live.d.e.a(aGm, j2, aGt, 4, 1, x.aGr().LIa);
                    com.tencent.mm.live.d.a.aHY();
                } else {
                    r rVar2 = r.hIg;
                    r.eF(true);
                    x xVar5 = x.hJf;
                    String aGm2 = x.aGm();
                    x xVar6 = x.hJf;
                    long j3 = x.aGr().hyH;
                    x xVar7 = x.hJf;
                    String aGt2 = x.aGt();
                    x xVar8 = x.hJf;
                    com.tencent.mm.live.d.e.a(aGm2, j3, aGt2, 4, 0, x.aGr().LIa);
                    com.tencent.mm.live.d.a.aHZ();
                }
                i.a(this.hOW);
            }
            AppMethodBeat.o(207922);
        }
    }

    public final void aHu() {
        AppMethodBeat.i(207924);
        this.hOR.setVisibility(0);
        this.hOT.setVisibility(0);
        this.hOU.setVisibility(8);
        this.hOS.setClickable(true);
        if (this.hOV) {
            ImageView imageView = this.hOR;
            Context context2 = this.hwr.getContext();
            p.g(context2, "root.context");
            imageView.setImageDrawable(ar.e(context2.getResources().getDrawable(R.raw.icons_filled_chat), -1));
            TextView textView = this.hOT;
            Context context3 = this.hwr.getContext();
            p.g(context3, "root.context");
            textView.setText(context3.getResources().getString(R.string.ef9));
            AppMethodBeat.o(207924);
            return;
        }
        ImageView imageView2 = this.hOR;
        Context context4 = this.hwr.getContext();
        p.g(context4, "root.context");
        imageView2.setImageDrawable(ar.e(context4.getResources().getDrawable(R.raw.icons_filled_ban_comment), -1));
        TextView textView2 = this.hOT;
        Context context5 = this.hwr.getContext();
        p.g(context5, "root.context");
        textView2.setText(context5.getResources().getString(R.string.ef8));
        AppMethodBeat.o(207924);
    }

    @Override // com.tencent.mm.live.c.a
    public final void mount() {
        AppMethodBeat.i(207925);
        com.tencent.mm.kernel.b aAg = g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().a(3664, this);
        AppMethodBeat.o(207925);
    }

    @Override // com.tencent.mm.live.c.a
    public final void unMount() {
        AppMethodBeat.i(207926);
        com.tencent.mm.kernel.b aAg = g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().b(3664, this);
        AppMethodBeat.o(207926);
    }

    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        AppMethodBeat.i(207927);
        p.h(cVar, "status");
        super.statusChange(cVar, bundle);
        switch (j.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
                rg(8);
                AppMethodBeat.o(207927);
                return;
            case 4:
                rg(0);
                break;
        }
        AppMethodBeat.o(207927);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        String string;
        AppMethodBeat.i(207928);
        if (qVar instanceof com.tencent.mm.live.b.a.i) {
            if (i2 == 0 && i3 == 0) {
                this.hOV = !this.hOV;
            } else {
                if (this.hOV) {
                    Context context2 = this.hwr.getContext();
                    p.g(context2, "root.context");
                    string = context2.getResources().getString(R.string.efa);
                } else {
                    Context context3 = this.hwr.getContext();
                    p.g(context3, "root.context");
                    string = context3.getResources().getString(R.string.ef_);
                }
                p.g(string, "if (enableComment) {\n   …il_tip)\n                }");
                u.makeText(this.hwr.getContext(), string, 0).show();
            }
            aHu();
        }
        AppMethodBeat.o(207928);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    static final class b implements o.f {
        final /* synthetic */ ArrayList hOB;
        final /* synthetic */ ArrayList hOC;
        final /* synthetic */ i hOW;

        b(i iVar, ArrayList arrayList, ArrayList arrayList2) {
            this.hOW = iVar;
            this.hOB = arrayList;
            this.hOC = arrayList2;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(m mVar) {
            AppMethodBeat.i(207923);
            e eVar = this.hOW.hOv;
            if (eVar != null) {
                eVar.setFooterView(null);
            }
            mVar.clear();
            int size = this.hOB.size();
            for (int i2 = 0; i2 < size; i2++) {
                Object obj = this.hOC.get(i2);
                p.g(obj, "ids[i]");
                int intValue = ((Number) obj).intValue();
                Context context = this.hOW.context;
                p.g(context, "context");
                mVar.a(intValue, context.getResources().getColor(R.color.xq), (CharSequence) this.hOB.get(i2));
            }
            AppMethodBeat.o(207923);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onDismiss"})
    static final class c implements e.b {
        final /* synthetic */ i hOW;

        c(i iVar) {
            this.hOW = iVar;
        }

        @Override // com.tencent.mm.ui.widget.a.e.b
        public final void onDismiss() {
            this.hOW.hOv = null;
        }
    }

    public static final /* synthetic */ void a(i iVar) {
        AppMethodBeat.i(207930);
        iVar.hOR.setVisibility(4);
        iVar.hOT.setVisibility(4);
        iVar.hOU.setVisibility(0);
        iVar.hOS.setClickable(false);
        AppMethodBeat.o(207930);
    }
}
