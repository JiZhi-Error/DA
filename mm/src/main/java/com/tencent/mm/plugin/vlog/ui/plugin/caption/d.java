package com.tencent.mm.plugin.vlog.ui.plugin.caption;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.protocal.protobuf.sy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.ui.ar;
import java.util.ArrayList;
import java.util.List;
import kotlin.x;

public final class d extends LinearLayout {
    public static final b GLf = new b((byte) 0);
    private final kotlin.f GKD = kotlin.g.ah(new e(this));
    private final kotlin.f GKE = kotlin.g.ah(new h(this));
    private final kotlin.f GKF = kotlin.g.ah(new f(this));
    private final kotlin.f GKG = kotlin.g.ah(new p(this));
    private final kotlin.f GKH = kotlin.g.ah(new r(this));
    private final kotlin.f GKI = kotlin.g.ah(new q(this));
    private final kotlin.f GKJ = kotlin.g.ah(new g(this));
    private final kotlin.f GKK = kotlin.g.ah(new C1867d(this));
    private final kotlin.f GKL = kotlin.g.ah(new o(this));
    private final kotlin.f GKM = kotlin.g.ah(new w(this));
    private final kotlin.f GKN = kotlin.g.ah(new v(this));
    private final kotlin.f GKO = kotlin.g.ah(new s(this));
    private final kotlin.f GKP = kotlin.g.ah(new u(this));
    private final kotlin.f GKQ = kotlin.g.ah(new t(this));
    private final kotlin.f GKR = kotlin.g.ah(new j(this));
    private final kotlin.f GKS = kotlin.g.ah(new i(this));
    private final kotlin.f GKT = kotlin.g.ah(new l(this));
    private final kotlin.f GKU = kotlin.g.ah(new m(this));
    private final kotlin.f GKV = kotlin.g.ah(new n(this));
    final List<c> GKW;
    private kotlin.g.a.a<x> GKX;
    private kotlin.g.a.b<? super Long, x> GKY;
    private kotlin.g.a.b<? super Integer, x> GKZ;
    private kotlin.g.a.m<? super Integer, ? super Boolean, x> GLa;
    private kotlin.g.a.a<x> GLb;
    private List<Integer> GLc;
    private boolean GLd;
    private int GLe;
    private kotlin.g.a.m<? super Integer, ? super sy, x> rsD;
    private final kotlin.f uZY = kotlin.g.ah(new k(this));

    static {
        AppMethodBeat.i(191731);
        AppMethodBeat.o(191731);
    }

    private final ViewGroup getCaptionPanel() {
        AppMethodBeat.i(191710);
        ViewGroup viewGroup = (ViewGroup) this.GKK.getValue();
        AppMethodBeat.o(191710);
        return viewGroup;
    }

    private final ViewGroup getCaptionTab() {
        AppMethodBeat.i(191703);
        ViewGroup viewGroup = (ViewGroup) this.GKD.getValue();
        AppMethodBeat.o(191703);
        return viewGroup;
    }

    private final List<RecyclerView> getCaptionViews() {
        AppMethodBeat.i(191718);
        List<RecyclerView> list = (List) this.GKS.getValue();
        AppMethodBeat.o(191718);
        return list;
    }

    private final ViewGroup getClearRecordBtn() {
        AppMethodBeat.i(191717);
        ViewGroup viewGroup = (ViewGroup) this.GKR.getValue();
        AppMethodBeat.o(191717);
        return viewGroup;
    }

    private final TextView getEmptyTipTxt() {
        AppMethodBeat.i(191720);
        TextView textView = (TextView) this.GKU.getValue();
        AppMethodBeat.o(191720);
        return textView;
    }

    private final ViewGroup getRecordCaptionPanel() {
        AppMethodBeat.i(191711);
        ViewGroup viewGroup = (ViewGroup) this.GKL.getValue();
        AppMethodBeat.o(191711);
        return viewGroup;
    }

    private final View getRecordCaptionTabIndicator() {
        AppMethodBeat.i(191708);
        View view = (View) this.GKI.getValue();
        AppMethodBeat.o(191708);
        return view;
    }

    private final TextView getRecordCaptionTabText() {
        AppMethodBeat.i(191707);
        TextView textView = (TextView) this.GKH.getValue();
        AppMethodBeat.o(191707);
        return textView;
    }

    private final TextView getRecordTransBtn() {
        AppMethodBeat.i(191713);
        TextView textView = (TextView) this.GKN.getValue();
        AppMethodBeat.o(191713);
        return textView;
    }

    public final View getCaptionTabIndicator() {
        AppMethodBeat.i(191705);
        View view = (View) this.GKF.getValue();
        AppMethodBeat.o(191705);
        return view;
    }

    public final View getCaptionTabSpace() {
        AppMethodBeat.i(191709);
        View view = (View) this.GKJ.getValue();
        AppMethodBeat.o(191709);
        return view;
    }

    public final TextView getCaptionTabText() {
        AppMethodBeat.i(191704);
        TextView textView = (TextView) this.GKE.getValue();
        AppMethodBeat.o(191704);
        return textView;
    }

    public final LinearLayout getContentLayout() {
        AppMethodBeat.i(191721);
        LinearLayout linearLayout = (LinearLayout) this.uZY.getValue();
        AppMethodBeat.o(191721);
        return linearLayout;
    }

    public final LinearLayout getEmptyLayout() {
        AppMethodBeat.i(191719);
        LinearLayout linearLayout = (LinearLayout) this.GKT.getValue();
        AppMethodBeat.o(191719);
        return linearLayout;
    }

    public final View getLoadingView() {
        AppMethodBeat.i(191722);
        View view = (View) this.GKV.getValue();
        AppMethodBeat.o(191722);
        return view;
    }

    public final ViewGroup getRecordCaptionTab() {
        AppMethodBeat.i(191706);
        ViewGroup viewGroup = (ViewGroup) this.GKG.getValue();
        AppMethodBeat.o(191706);
        return viewGroup;
    }

    public final ViewGroup getRecordContentLayout() {
        AppMethodBeat.i(191714);
        ViewGroup viewGroup = (ViewGroup) this.GKO.getValue();
        AppMethodBeat.o(191714);
        return viewGroup;
    }

    public final ViewGroup getRecordEmptyLayout() {
        AppMethodBeat.i(191716);
        ViewGroup viewGroup = (ViewGroup) this.GKQ.getValue();
        AppMethodBeat.o(191716);
        return viewGroup;
    }

    public final View getRecordLoadingView() {
        AppMethodBeat.i(191715);
        View view = (View) this.GKP.getValue();
        AppMethodBeat.o(191715);
        return view;
    }

    public final TextView getTransBtn() {
        AppMethodBeat.i(191712);
        TextView textView = (TextView) this.GKM.getValue();
        AppMethodBeat.o(191712);
        return textView;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(Context context) {
        super(context);
        kotlin.g.b.p.h(context, "context");
        AppMethodBeat.i(191730);
        this.GKW = kotlin.a.j.listOf((Object[]) new c[]{new c(this, 0, context), new c(this, 1, context)});
        this.GLc = kotlin.a.j.mutableListOf(0, 0);
        LayoutInflater.from(context).inflate(R.layout.a16, (ViewGroup) this, true);
        setBackgroundResource(R.drawable.fh);
        setOrientation(1);
        LinearLayout contentLayout = getContentLayout();
        kotlin.g.b.p.g(contentLayout, "contentLayout");
        contentLayout.setVisibility(4);
        LinearLayout emptyLayout = getEmptyLayout();
        kotlin.g.b.p.g(emptyLayout, "emptyLayout");
        emptyLayout.setVisibility(0);
        getCaptionTab().setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.vlog.ui.plugin.caption.d.AnonymousClass1 */
            final /* synthetic */ d GLg;

            {
                this.GLg = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(191663);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                d.c(this.GLg, 0);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(191663);
            }
        });
        getRecordCaptionTab().setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.vlog.ui.plugin.caption.d.AnonymousClass2 */
            final /* synthetic */ d GLg;

            {
                this.GLg = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(191664);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                d.c(this.GLg, 1);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(191664);
            }
        });
        findViewById(R.id.ain).setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.vlog.ui.plugin.caption.d.AnonymousClass3 */
            final /* synthetic */ d GLg;

            {
                this.GLg = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(191665);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                kotlin.g.a.a<x> dismissListener = this.GLg.getDismissListener();
                if (dismissListener != null) {
                    dismissListener.invoke();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(191665);
            }
        });
        findViewById(R.id.iuu).setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.vlog.ui.plugin.caption.d.AnonymousClass4 */
            final /* synthetic */ d GLg;

            {
                this.GLg = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(191666);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                LinearLayout e2 = d.e(this.GLg);
                kotlin.g.b.p.g(e2, "contentLayout");
                e2.setVisibility(0);
                LinearLayout f2 = d.f(this.GLg);
                kotlin.g.b.p.g(f2, "emptyLayout");
                f2.setVisibility(4);
                kotlin.g.a.b<Integer, x> startTransListener = this.GLg.getStartTransListener();
                if (startTransListener != null) {
                    startTransListener.invoke(0);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(191666);
            }
        });
        findViewById(R.id.b3h).setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.vlog.ui.plugin.caption.d.AnonymousClass5 */
            final /* synthetic */ d GLg;

            {
                this.GLg = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(191667);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                d.a(this.GLg, 0);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(191667);
            }
        });
        getRecordTransBtn().setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.vlog.ui.plugin.caption.d.AnonymousClass6 */
            final /* synthetic */ d GLg;

            {
                this.GLg = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(191668);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ViewGroup g2 = d.g(this.GLg);
                kotlin.g.b.p.g(g2, "recordContentLayout");
                g2.setVisibility(0);
                ViewGroup h2 = d.h(this.GLg);
                kotlin.g.b.p.g(h2, "recordEmptyLayout");
                h2.setVisibility(4);
                kotlin.g.a.b<Integer, x> startTransListener = this.GLg.getStartTransListener();
                if (startTransListener != null) {
                    startTransListener.invoke(1);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(191668);
            }
        });
        getClearRecordBtn().setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.vlog.ui.plugin.caption.d.AnonymousClass7 */
            final /* synthetic */ d GLg;

            {
                this.GLg = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(191669);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                d.a(this.GLg, 1);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(191669);
            }
        });
        for (int i2 = 0; i2 < 2; i2++) {
            RecyclerView recyclerView = getCaptionViews().get(i2);
            kotlin.g.b.p.g(recyclerView, "captionViews[i]");
            recyclerView.setLayoutManager(new EditorCaptionLayoutManager(context));
            RecyclerView recyclerView2 = getCaptionViews().get(i2);
            kotlin.g.b.p.g(recyclerView2, "captionViews[i]");
            recyclerView2.setAdapter(this.GKW.get(i2));
            getCaptionViews().get(i2).a(new a(i2));
        }
        AppMethodBeat.o(191730);
    }

    public static final /* synthetic */ void c(d dVar, int i2) {
        AppMethodBeat.i(191735);
        dVar.VT(i2);
        AppMethodBeat.o(191735);
    }

    public static final /* synthetic */ List d(d dVar) {
        AppMethodBeat.i(191733);
        List<RecyclerView> captionViews = dVar.getCaptionViews();
        AppMethodBeat.o(191733);
        return captionViews;
    }

    public static final /* synthetic */ LinearLayout e(d dVar) {
        AppMethodBeat.i(191736);
        LinearLayout contentLayout = dVar.getContentLayout();
        AppMethodBeat.o(191736);
        return contentLayout;
    }

    public static final /* synthetic */ LinearLayout f(d dVar) {
        AppMethodBeat.i(191737);
        LinearLayout emptyLayout = dVar.getEmptyLayout();
        AppMethodBeat.o(191737);
        return emptyLayout;
    }

    public static final /* synthetic */ ViewGroup g(d dVar) {
        AppMethodBeat.i(191738);
        ViewGroup recordContentLayout = dVar.getRecordContentLayout();
        AppMethodBeat.o(191738);
        return recordContentLayout;
    }

    public static final /* synthetic */ ViewGroup h(d dVar) {
        AppMethodBeat.i(191739);
        ViewGroup recordEmptyLayout = dVar.getRecordEmptyLayout();
        AppMethodBeat.o(191739);
        return recordEmptyLayout;
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    public static final class l extends kotlin.g.b.q implements kotlin.g.a.a<LinearLayout> {
        final /* synthetic */ d GLg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(d dVar) {
            super(0);
            this.GLg = dVar;
        }

        static final class a implements View.OnClickListener {
            public static final a GLi = new a();

            static {
                AppMethodBeat.i(191690);
                AppMethodBeat.o(191690);
            }

            a() {
            }

            public final void onClick(View view) {
                AppMethodBeat.i(191689);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$emptyLayout$2$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$emptyLayout$2$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(191689);
            }
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ LinearLayout invoke() {
            AppMethodBeat.i(191691);
            View findViewById = this.GLg.findViewById(R.id.c31);
            this.GLg.setOnClickListener(a.GLi);
            LinearLayout linearLayout = (LinearLayout) findViewById;
            AppMethodBeat.o(191691);
            return linearLayout;
        }
    }

    public final kotlin.g.a.a<x> getVideoPauseListener() {
        return this.GKX;
    }

    public final void setVideoPauseListener(kotlin.g.a.a<x> aVar) {
        this.GKX = aVar;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.b<? super java.lang.Long, kotlin.x>, kotlin.g.a.b<java.lang.Long, kotlin.x> */
    public final kotlin.g.a.b<Long, x> getVideoSeekListener() {
        return this.GKY;
    }

    public final void setVideoSeekListener(kotlin.g.a.b<? super Long, x> bVar) {
        this.GKY = bVar;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.b<? super java.lang.Integer, kotlin.x>, kotlin.g.a.b<java.lang.Integer, kotlin.x> */
    public final kotlin.g.a.b<Integer, x> getStartTransListener() {
        return this.GKZ;
    }

    public final void setStartTransListener(kotlin.g.a.b<? super Integer, x> bVar) {
        this.GKZ = bVar;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.m<? super java.lang.Integer, ? super java.lang.Boolean, kotlin.x>, kotlin.g.a.m<java.lang.Integer, java.lang.Boolean, kotlin.x> */
    public final kotlin.g.a.m<Integer, Boolean, x> getClearTransListener() {
        return this.GLa;
    }

    public final void setClearTransListener(kotlin.g.a.m<? super Integer, ? super Boolean, x> mVar) {
        this.GLa = mVar;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.m<? super java.lang.Integer, ? super com.tencent.mm.protocal.protobuf.sy, kotlin.x>, kotlin.g.a.m<java.lang.Integer, com.tencent.mm.protocal.protobuf.sy, kotlin.x> */
    public final kotlin.g.a.m<Integer, sy, x> getItemClickListener() {
        return this.rsD;
    }

    public final void setItemClickListener(kotlin.g.a.m<? super Integer, ? super sy, x> mVar) {
        this.rsD = mVar;
    }

    public final kotlin.g.a.a<x> getDismissListener() {
        return this.GLb;
    }

    public final void setDismissListener(kotlin.g.a.a<x> aVar) {
        this.GLb = aVar;
    }

    public static /* synthetic */ void a(d dVar, int i2) {
        AppMethodBeat.i(191724);
        dVar.cE(i2, null);
        AppMethodBeat.o(191724);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x006e, code lost:
        if (r3.getVisibility() == 4) goto L_0x0070;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void cE(int r8, java.lang.String r9) {
        /*
        // Method dump skipped, instructions count: 168
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.vlog.ui.plugin.caption.d.cE(int, java.lang.String):void");
    }

    public final void acH(int i2) {
        AppMethodBeat.i(191725);
        this.GKW.get(i2).GKy.clear();
        AppMethodBeat.o(191725);
    }

    public final void acI(int i2) {
        AppMethodBeat.i(191726);
        this.GKW.get(i2).notifyDataSetChanged();
        AppMethodBeat.o(191726);
    }

    public final void aL(int i2, long j2) {
        AppMethodBeat.i(191727);
        if (this.GLd || this.GKW.get(i2).GKy.isEmpty()) {
            AppMethodBeat.o(191727);
            return;
        }
        int intValue = this.GLc.get(i2).intValue();
        aM(i2, j2);
        RecyclerView recyclerView = getCaptionViews().get(i2);
        kotlin.g.b.p.g(recyclerView, "captionViews[type]");
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager != null) {
            layoutManager.smoothScrollToPosition(getCaptionViews().get(i2), new RecyclerView.s(), this.GLc.get(i2).intValue());
            this.GKW.get(i2);
            c.fZ(layoutManager.findViewByPosition(intValue));
            this.GKW.get(i2);
            c.fY(layoutManager.findViewByPosition(this.GLc.get(i2).intValue()));
            AppMethodBeat.o(191727);
            return;
        }
        AppMethodBeat.o(191727);
    }

    private final int aM(int i2, long j2) {
        boolean z;
        AppMethodBeat.i(191728);
        if (this.GLc.get(i2).intValue() >= this.GKW.get(i2).GKy.size()) {
            Log.i("MicroMsg.EditorTextCaptionView", "maybe clear captionItems");
            this.GLc.set(i2, Integer.valueOf(this.GKW.get(i2).GKy.size() - 1));
        }
        if (this.GKW.get(i2).GKy.get(this.GLc.get(i2).intValue()).LaT > j2) {
            this.GLc.set(i2, 0);
            z = true;
        } else {
            z = false;
        }
        while (this.GKW.get(i2).GKy.get(this.GLc.get(i2).intValue()).LaU < j2) {
            List<Integer> list = this.GLc;
            list.set(i2, Integer.valueOf(list.get(i2).intValue() + 1));
        }
        this.GKW.get(i2).ady = this.GLc.get(i2).intValue();
        if (z) {
            RecyclerView recyclerView = getCaptionViews().get(i2);
            com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(this.GLc.get(i2).intValue(), new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView", "time2Pos", "(IJ)I", "Undefined", "scrollToPosition", "(I)V");
            recyclerView.scrollToPosition(((Integer) a2.pG(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView", "time2Pos", "(IJ)I", "Undefined", "scrollToPosition", "(I)V");
        }
        int intValue = this.GLc.get(i2).intValue();
        AppMethodBeat.o(191728);
        return intValue;
    }

    public final void VT(int i2) {
        AppMethodBeat.i(191729);
        this.GLe = i2;
        if (this.GLe == 0) {
            View captionTabIndicator = getCaptionTabIndicator();
            kotlin.g.b.p.g(captionTabIndicator, "captionTabIndicator");
            captionTabIndicator.setVisibility(0);
            View recordCaptionTabIndicator = getRecordCaptionTabIndicator();
            kotlin.g.b.p.g(recordCaptionTabIndicator, "recordCaptionTabIndicator");
            recordCaptionTabIndicator.setVisibility(4);
            TextView captionTabText = getCaptionTabText();
            Context context = getContext();
            kotlin.g.b.p.g(context, "context");
            captionTabText.setTextColor(context.getResources().getColor(R.color.ag2));
            TextView recordCaptionTabText = getRecordCaptionTabText();
            Context context2 = getContext();
            kotlin.g.b.p.g(context2, "context");
            recordCaptionTabText.setTextColor(context2.getResources().getColor(R.color.ag3));
            ViewGroup captionPanel = getCaptionPanel();
            kotlin.g.b.p.g(captionPanel, "captionPanel");
            captionPanel.setVisibility(0);
            ViewGroup recordCaptionPanel = getRecordCaptionPanel();
            kotlin.g.b.p.g(recordCaptionPanel, "recordCaptionPanel");
            recordCaptionPanel.setVisibility(8);
            AppMethodBeat.o(191729);
            return;
        }
        View captionTabIndicator2 = getCaptionTabIndicator();
        kotlin.g.b.p.g(captionTabIndicator2, "captionTabIndicator");
        captionTabIndicator2.setVisibility(4);
        View recordCaptionTabIndicator2 = getRecordCaptionTabIndicator();
        kotlin.g.b.p.g(recordCaptionTabIndicator2, "recordCaptionTabIndicator");
        recordCaptionTabIndicator2.setVisibility(0);
        TextView captionTabText2 = getCaptionTabText();
        Context context3 = getContext();
        kotlin.g.b.p.g(context3, "context");
        captionTabText2.setTextColor(context3.getResources().getColor(R.color.ag3));
        TextView recordCaptionTabText2 = getRecordCaptionTabText();
        Context context4 = getContext();
        kotlin.g.b.p.g(context4, "context");
        recordCaptionTabText2.setTextColor(context4.getResources().getColor(R.color.ag2));
        ViewGroup captionPanel2 = getCaptionPanel();
        kotlin.g.b.p.g(captionPanel2, "captionPanel");
        captionPanel2.setVisibility(8);
        ViewGroup recordCaptionPanel2 = getRecordCaptionPanel();
        kotlin.g.b.p.g(recordCaptionPanel2, "recordCaptionPanel");
        recordCaptionPanel2.setVisibility(0);
        AppMethodBeat.o(191729);
    }

    public final class a extends RecyclerView.l {
        private final int type;

        public a(int i2) {
            d.this = r1;
            this.type = i2;
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(191670);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$CaptionScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            kotlin.g.b.p.h(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i2);
            switch (i2) {
                case 0:
                    if (d.this.GLd) {
                        long j2 = ((c) d.this.GKW.get(this.type)).GKy.get(((Number) d.this.GLc.get(this.type)).intValue()).LaT;
                        kotlin.g.a.b<Long, x> videoSeekListener = d.this.getVideoSeekListener();
                        if (videoSeekListener != null) {
                            if (j2 >= 2147483637) {
                                j2 = 0;
                            }
                            videoSeekListener.invoke(Long.valueOf(j2));
                        }
                        d.this.GLd = false;
                        d.b(d.this, this.type);
                        break;
                    }
                    break;
                case 1:
                    Log.d("MicroMsg.EditorTextCaptionView", "SCROLL_STATE_DRAGGING");
                    d.this.GLd = true;
                    kotlin.g.a.a<x> videoPauseListener = d.this.getVideoPauseListener();
                    if (videoPauseListener != null) {
                        videoPauseListener.invoke();
                        break;
                    }
                    break;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$CaptionScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(191670);
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(191671);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$CaptionScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            kotlin.g.b.p.h(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i2, i3);
            if (!d.this.GLd) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$CaptionScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
                AppMethodBeat.o(191671);
                return;
            }
            int intValue = ((Number) d.this.GLc.get(this.type)).intValue();
            Object obj = d.d(d.this).get(this.type);
            kotlin.g.b.p.g(obj, "captionViews[type]");
            RecyclerView.LayoutManager layoutManager = ((RecyclerView) obj).getLayoutManager();
            if (layoutManager == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                AppMethodBeat.o(191671);
                throw tVar;
            }
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            int ks = (linearLayoutManager.ks() + linearLayoutManager.ku()) / 2;
            if (ks == ((c) d.this.GKW.get(this.type)).ady) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$CaptionScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
                AppMethodBeat.o(191671);
                return;
            }
            int i4 = ks - 1;
            int i5 = ks + 1;
            if (i4 <= i5) {
                while (true) {
                    if (!d.a(d.this, this.type, linearLayoutManager.findViewByPosition(i4))) {
                        if (i4 == i5) {
                            break;
                        }
                        i4++;
                    } else {
                        d.this.GLc.set(this.type, Integer.valueOf(i4));
                        ((c) d.this.GKW.get(this.type)).ady = ((Number) d.this.GLc.get(this.type)).intValue();
                        d.this.GKW.get(this.type);
                        c.fZ(linearLayoutManager.findViewByPosition(intValue));
                        d.this.GKW.get(this.type);
                        c.fY(linearLayoutManager.findViewByPosition(((Number) d.this.GLc.get(this.type)).intValue()));
                        Log.d("MicroMsg.EditorTextCaptionView", "onScrolled currentPos  " + d.this.GLc + ' ' + intValue);
                        break;
                    }
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$CaptionScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(191671);
        }
    }

    public final class c extends RecyclerView.a<RecyclerView.v> {
        ArrayList<sy> GKy = new ArrayList<>();
        final /* synthetic */ d GLg;
        int ady;
        private Context context;
        private final int type;

        public c(d dVar, int i2, Context context2) {
            kotlin.g.b.p.h(context2, "context");
            this.GLg = dVar;
            AppMethodBeat.i(191680);
            this.type = i2;
            this.context = context2;
            AppMethodBeat.o(191680);
        }

        public static final class b extends RecyclerView.v {
            final /* synthetic */ ViewGroup GKC;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(ViewGroup viewGroup, View view) {
                super(view);
                this.GKC = viewGroup;
            }
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final RecyclerView.v a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(191673);
            kotlin.g.b.p.h(viewGroup, "parent");
            View inflate = LayoutInflater.from(this.context).inflate(R.layout.a15, viewGroup, false);
            if (inflate == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
                AppMethodBeat.o(191673);
                throw tVar;
            }
            ViewGroup viewGroup2 = (ViewGroup) inflate;
            b bVar = new b(viewGroup2, viewGroup2);
            AppMethodBeat.o(191673);
            return bVar;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            AppMethodBeat.i(191674);
            int size = this.GKy.size();
            AppMethodBeat.o(191674);
            return size;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final void a(RecyclerView.v vVar, int i2) {
            AppMethodBeat.i(191675);
            kotlin.g.b.p.h(vVar, "viewHolder");
            View view = vVar.aus;
            kotlin.g.b.p.g(view, "viewHolder.itemView");
            if (TextUtils.isEmpty(d(this.GKy.get(i2).LaS)) || this.GKy.get(i2).LaV) {
                view.setVisibility(4);
            } else {
                view.setVisibility(0);
                if (this.ady == i2) {
                    a(view, this.GKy.get(i2));
                } else {
                    fZ(view);
                }
                TextView textView = (TextView) view.findViewById(R.id.aio);
                kotlin.g.b.p.g(textView, "contentView");
                textView.setText(d(this.GKy.get(i2).LaS));
            }
            vVar.aus.setOnClickListener(new a(this, i2));
            AppMethodBeat.o(191675);
        }

        static final class a implements View.OnClickListener {
            final /* synthetic */ c GLh;
            final /* synthetic */ int gUj;

            a(c cVar, int i2) {
                this.GLh = cVar;
                this.gUj = i2;
            }

            public final void onClick(View view) {
                kotlin.g.a.m<Integer, sy, x> itemClickListener;
                AppMethodBeat.i(191672);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$EditorCaptionAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!this.GLh.GKy.get(this.gUj).LaV && (itemClickListener = this.GLh.GLg.getItemClickListener()) != null) {
                    Integer valueOf = Integer.valueOf(this.GLh.type);
                    sy syVar = this.GLh.GKy.get(this.gUj);
                    kotlin.g.b.p.g(syVar, "captionItems[position]");
                    itemClickListener.invoke(valueOf, syVar);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView$EditorCaptionAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(191672);
            }
        }

        public static /* synthetic */ void fY(View view) {
            AppMethodBeat.i(191677);
            a(view, (sy) null);
            AppMethodBeat.o(191677);
        }

        private static void a(View view, sy syVar) {
            AppMethodBeat.i(191676);
            if (view == null) {
                AppMethodBeat.o(191676);
                return;
            }
            view.setAlpha(1.0f);
            ImageView imageView = (ImageView) view.findViewById(R.id.aiq);
            if (syVar == null || !syVar.LaV) {
                kotlin.g.b.p.g(imageView, "img");
                imageView.setImageDrawable(ar.m(imageView.getContext(), R.raw.icons_filled_pencil, -1));
                imageView.setVisibility(0);
                AppMethodBeat.o(191676);
                return;
            }
            kotlin.g.b.p.g(imageView, "img");
            imageView.setVisibility(4);
            AppMethodBeat.o(191676);
        }

        public static void fZ(View view) {
            AppMethodBeat.i(191678);
            if (view == null) {
                AppMethodBeat.o(191678);
                return;
            }
            view.setAlpha(0.5f);
            View findViewById = view.findViewById(R.id.aiq);
            kotlin.g.b.p.g(findViewById, "itemView.findViewById<Im…eView>(R.id.caption_edit)");
            ((ImageView) findViewById).setVisibility(4);
            AppMethodBeat.o(191678);
        }

        private static String d(com.tencent.mm.bw.b bVar) {
            AppMethodBeat.i(191679);
            if (bVar == null) {
                AppMethodBeat.o(191679);
                return "";
            }
            String bVar2 = bVar.toString(MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            kotlin.g.b.p.g(bVar2, "byte.toString(\"UTF-8\")");
            AppMethodBeat.o(191679);
            return bVar2;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class e extends kotlin.g.b.q implements kotlin.g.a.a<ViewGroup> {
        final /* synthetic */ d GLg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(d dVar) {
            super(0);
            this.GLg = dVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ ViewGroup invoke() {
            AppMethodBeat.i(191682);
            ViewGroup viewGroup = (ViewGroup) this.GLg.findViewById(R.id.aj2);
            AppMethodBeat.o(191682);
            return viewGroup;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class h extends kotlin.g.b.q implements kotlin.g.a.a<TextView> {
        final /* synthetic */ d GLg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(d dVar) {
            super(0);
            this.GLg = dVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ TextView invoke() {
            AppMethodBeat.i(191685);
            TextView textView = (TextView) this.GLg.findViewById(R.id.aj5);
            AppMethodBeat.o(191685);
            return textView;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class f extends kotlin.g.b.q implements kotlin.g.a.a<View> {
        final /* synthetic */ d GLg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(d dVar) {
            super(0);
            this.GLg = dVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(191683);
            View findViewById = this.GLg.findViewById(R.id.aj3);
            AppMethodBeat.o(191683);
            return findViewById;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class p extends kotlin.g.b.q implements kotlin.g.a.a<ViewGroup> {
        final /* synthetic */ d GLg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        p(d dVar) {
            super(0);
            this.GLg = dVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ ViewGroup invoke() {
            AppMethodBeat.i(191695);
            ViewGroup viewGroup = (ViewGroup) this.GLg.findViewById(R.id.gwn);
            AppMethodBeat.o(191695);
            return viewGroup;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class r extends kotlin.g.b.q implements kotlin.g.a.a<TextView> {
        final /* synthetic */ d GLg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        r(d dVar) {
            super(0);
            this.GLg = dVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ TextView invoke() {
            AppMethodBeat.i(191697);
            TextView textView = (TextView) this.GLg.findViewById(R.id.gwp);
            AppMethodBeat.o(191697);
            return textView;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class q extends kotlin.g.b.q implements kotlin.g.a.a<View> {
        final /* synthetic */ d GLg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        q(d dVar) {
            super(0);
            this.GLg = dVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(191696);
            View findViewById = this.GLg.findViewById(R.id.gwo);
            AppMethodBeat.o(191696);
            return findViewById;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class g extends kotlin.g.b.q implements kotlin.g.a.a<View> {
        final /* synthetic */ d GLg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(d dVar) {
            super(0);
            this.GLg = dVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(191684);
            View findViewById = this.GLg.findViewById(R.id.aj4);
            AppMethodBeat.o(191684);
            return findViewById;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.vlog.ui.plugin.caption.d$d */
    public static final class C1867d extends kotlin.g.b.q implements kotlin.g.a.a<ViewGroup> {
        final /* synthetic */ d GLg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1867d(d dVar) {
            super(0);
            this.GLg = dVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ ViewGroup invoke() {
            AppMethodBeat.i(191681);
            ViewGroup viewGroup = (ViewGroup) this.GLg.findViewById(R.id.aiz);
            AppMethodBeat.o(191681);
            return viewGroup;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class o extends kotlin.g.b.q implements kotlin.g.a.a<ViewGroup> {
        final /* synthetic */ d GLg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        o(d dVar) {
            super(0);
            this.GLg = dVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ ViewGroup invoke() {
            AppMethodBeat.i(191694);
            ViewGroup viewGroup = (ViewGroup) this.GLg.findViewById(R.id.gwm);
            AppMethodBeat.o(191694);
            return viewGroup;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class w extends kotlin.g.b.q implements kotlin.g.a.a<TextView> {
        final /* synthetic */ d GLg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        w(d dVar) {
            super(0);
            this.GLg = dVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ TextView invoke() {
            AppMethodBeat.i(191702);
            TextView textView = (TextView) this.GLg.findViewById(R.id.iuu);
            AppMethodBeat.o(191702);
            return textView;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class v extends kotlin.g.b.q implements kotlin.g.a.a<TextView> {
        final /* synthetic */ d GLg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        v(d dVar) {
            super(0);
            this.GLg = dVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ TextView invoke() {
            AppMethodBeat.i(191701);
            TextView textView = (TextView) this.GLg.findViewById(R.id.gxo);
            AppMethodBeat.o(191701);
            return textView;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class s extends kotlin.g.b.q implements kotlin.g.a.a<ViewGroup> {
        final /* synthetic */ d GLg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        s(d dVar) {
            super(0);
            this.GLg = dVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ ViewGroup invoke() {
            AppMethodBeat.i(191698);
            ViewGroup viewGroup = (ViewGroup) this.GLg.findViewById(R.id.gwk);
            AppMethodBeat.o(191698);
            return viewGroup;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class u extends kotlin.g.b.q implements kotlin.g.a.a<View> {
        final /* synthetic */ d GLg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        u(d dVar) {
            super(0);
            this.GLg = dVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(191700);
            View findViewById = this.GLg.findViewById(R.id.gwl);
            AppMethodBeat.o(191700);
            return findViewById;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class t extends kotlin.g.b.q implements kotlin.g.a.a<ViewGroup> {
        final /* synthetic */ d GLg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        t(d dVar) {
            super(0);
            this.GLg = dVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ ViewGroup invoke() {
            AppMethodBeat.i(191699);
            ViewGroup viewGroup = (ViewGroup) this.GLg.findViewById(R.id.gwt);
            AppMethodBeat.o(191699);
            return viewGroup;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class j extends kotlin.g.b.q implements kotlin.g.a.a<ViewGroup> {
        final /* synthetic */ d GLg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(d dVar) {
            super(0);
            this.GLg = dVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ ViewGroup invoke() {
            AppMethodBeat.i(191687);
            ViewGroup viewGroup = (ViewGroup) this.GLg.findViewById(R.id.b3j);
            AppMethodBeat.o(191687);
            return viewGroup;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class i extends kotlin.g.b.q implements kotlin.g.a.a<List<? extends RecyclerView>> {
        final /* synthetic */ d GLg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(d dVar) {
            super(0);
            this.GLg = dVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ List<? extends RecyclerView> invoke() {
            AppMethodBeat.i(191686);
            List<? extends RecyclerView> listOf = kotlin.a.j.listOf((Object[]) new RecyclerView[]{(RecyclerView) this.GLg.findViewById(R.id.ait), (RecyclerView) this.GLg.findViewById(R.id.gwj)});
            AppMethodBeat.o(191686);
            return listOf;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class m extends kotlin.g.b.q implements kotlin.g.a.a<TextView> {
        final /* synthetic */ d GLg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(d dVar) {
            super(0);
            this.GLg = dVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ TextView invoke() {
            AppMethodBeat.i(191692);
            TextView textView = (TextView) this.GLg.findViewById(R.id.aj6);
            AppMethodBeat.o(191692);
            return textView;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class k extends kotlin.g.b.q implements kotlin.g.a.a<LinearLayout> {
        final /* synthetic */ d GLg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(d dVar) {
            super(0);
            this.GLg = dVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ LinearLayout invoke() {
            AppMethodBeat.i(191688);
            LinearLayout linearLayout = (LinearLayout) this.GLg.findViewById(R.id.aiu);
            AppMethodBeat.o(191688);
            return linearLayout;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class n extends kotlin.g.b.q implements kotlin.g.a.a<View> {
        final /* synthetic */ d GLg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(d dVar) {
            super(0);
            this.GLg = dVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(191693);
            View findViewById = this.GLg.findViewById(R.id.aiy);
            AppMethodBeat.o(191693);
            return findViewById;
        }
    }

    public static final /* synthetic */ void b(d dVar, int i2) {
        AppMethodBeat.i(191732);
        RecyclerView recyclerView = dVar.getCaptionViews().get(i2);
        kotlin.g.b.p.g(recyclerView, "captionViews[type]");
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager != null) {
            layoutManager.smoothScrollToPosition(dVar.getCaptionViews().get(i2), new RecyclerView.s(), dVar.GLc.get(i2).intValue());
            AppMethodBeat.o(191732);
            return;
        }
        AppMethodBeat.o(191732);
    }

    public static final /* synthetic */ boolean a(d dVar, int i2, View view) {
        AppMethodBeat.i(191734);
        if (view != null) {
            RecyclerView recyclerView = dVar.getCaptionViews().get(i2);
            kotlin.g.b.p.g(recyclerView, "captionViews[type]");
            int top = recyclerView.getTop();
            RecyclerView recyclerView2 = dVar.getCaptionViews().get(i2);
            kotlin.g.b.p.g(recyclerView2, "captionViews[type]");
            int bottom = (recyclerView2.getBottom() + top) / 2;
            int top2 = view.getTop();
            int bottom2 = view.getBottom();
            if (top2 <= bottom && bottom2 > bottom) {
                AppMethodBeat.o(191734);
                return true;
            }
        }
        AppMethodBeat.o(191734);
        return false;
    }
}
