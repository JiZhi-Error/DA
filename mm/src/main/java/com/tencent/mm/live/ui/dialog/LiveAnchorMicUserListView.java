package com.tencent.mm.live.ui.dialog;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.b.b.a;
import com.tencent.mm.live.b.r;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.a.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.g.b.ae;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

public final class LiveAnchorMicUserListView extends RelativeLayout {
    public static final a hVe = new a((byte) 0);
    private com.tencent.mm.ui.widget.a.e hOv;
    private final com.tencent.mm.plugin.voip.video.e hTl;
    private boolean hUS;
    private kotlin.g.a.a<x> hUT;
    private kotlin.g.a.m<? super Boolean, ? super a.C0371a, x> hUU;
    private kotlin.g.a.b<? super Boolean, x> hUV;
    private final RecyclerView hUW;
    public final b hUX;
    private a.C0371a hUY;
    private boolean hUZ;
    public boolean hVa;
    private kotlin.g.a.b<? super a.C0371a, x> hVb;
    private kotlin.g.a.b<? super a.C0371a, x> hVc;
    private View hVd;

    static {
        AppMethodBeat.i(208467);
        AppMethodBeat.o(208467);
    }

    /* access modifiers changed from: package-private */
    public static final class d extends q implements kotlin.g.a.b<a.C0371a, x> {
        final /* synthetic */ LiveAnchorMicUserListView hVf;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(LiveAnchorMicUserListView liveAnchorMicUserListView) {
            super(1);
            this.hVf = liveAnchorMicUserListView;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(a.C0371a aVar) {
            AppMethodBeat.i(208443);
            a.C0371a aVar2 = aVar;
            if (aVar2 != null) {
                this.hVf.hUZ = false;
                kotlin.g.a.m<Boolean, a.C0371a, x> callMicListener = this.hVf.getCallMicListener();
                if (callMicListener != null) {
                    callMicListener.invoke(Boolean.TRUE, aVar2);
                }
                this.hVf.hUY = aVar2;
                this.hVf.aJf();
                LiveAnchorMicUserListView.b(this.hVf, aVar2);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(208443);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class j extends q implements kotlin.g.a.b<a.C0371a, x> {
        final /* synthetic */ LiveAnchorMicUserListView hVf;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(LiveAnchorMicUserListView liveAnchorMicUserListView) {
            super(1);
            this.hVf = liveAnchorMicUserListView;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(a.C0371a aVar) {
            AppMethodBeat.i(208449);
            if (aVar != null) {
                LiveAnchorMicUserListView.a(this.hVf);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(208449);
            return xVar;
        }
    }

    public static final class l extends q implements kotlin.g.a.m<Integer, Integer, x> {
        final /* synthetic */ LiveAnchorMicUserListView hVf;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(LiveAnchorMicUserListView liveAnchorMicUserListView) {
            super(2);
            this.hVf = liveAnchorMicUserListView;
        }

        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Integer num, Integer num2) {
            AppMethodBeat.i(208451);
            int intValue = num.intValue();
            int intValue2 = num2.intValue();
            if (intValue == 0 && intValue2 == 0) {
                com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
                ArrayList<a.C0371a> arrayList = com.tencent.mm.live.b.x.aHa().hKT;
                a.C0371a aVar = this.hVf.hUY;
                if (arrayList == null) {
                    t tVar = new t("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
                    AppMethodBeat.o(208451);
                    throw tVar;
                }
                af.eV(arrayList).remove(aVar);
                com.tencent.mm.live.b.x xVar2 = com.tencent.mm.live.b.x.hJf;
                com.tencent.mm.live.b.x.aHa().aHk();
                this.hVf.aJd();
                kotlin.g.a.m<Boolean, a.C0371a, x> callMicListener = this.hVf.getCallMicListener();
                if (callMicListener != null) {
                    callMicListener.invoke(Boolean.FALSE, null);
                }
            }
            x xVar3 = x.SXb;
            AppMethodBeat.o(208451);
            return xVar3;
        }
    }

    public /* synthetic */ LiveAnchorMicUserListView(Context context) {
        this(context, null, 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LiveAnchorMicUserListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(208466);
        this.hTl = new com.tencent.mm.plugin.voip.video.e(MMApplicationContext.getContext());
        this.hUS = true;
        this.hUX = new b();
        this.hUZ = true;
        this.hVb = new d(this);
        this.hVc = new j(this);
        View inflate = LayoutInflater.from(context).inflate(R.layout.b0c, (ViewGroup) this, true);
        p.g(inflate, "LayoutInflater.from(cont…ic_list_view, this, true)");
        this.hVd = inflate;
        this.hVd.findViewById(R.id.b4g).setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.live.ui.dialog.LiveAnchorMicUserListView.AnonymousClass1 */
            final /* synthetic */ LiveAnchorMicUserListView hVf;

            {
                this.hVf = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(208429);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                kotlin.g.a.a<x> hideClickListener = this.hVf.getHideClickListener();
                if (hideClickListener != null) {
                    hideClickListener.invoke();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(208429);
            }
        });
        View findViewById = this.hVd.findViewById(R.id.ef4);
        p.g(findViewById, "parent.findViewById(R.id.live_anchor_mic_list)");
        this.hUW = (RecyclerView) findViewById;
        this.hUW.setLayoutManager(new LinearLayoutManager());
        this.hUW.setAdapter(this.hUX);
        this.hUW.setItemViewCacheSize(0);
        AppMethodBeat.o(208466);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final boolean getMicPermission() {
        return this.hUS;
    }

    public final void setMicPermission(boolean z) {
        this.hUS = z;
    }

    public final kotlin.g.a.a<x> getHideClickListener() {
        return this.hUT;
    }

    public final void setHideClickListener(kotlin.g.a.a<x> aVar) {
        this.hUT = aVar;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.m<? super java.lang.Boolean, ? super com.tencent.mm.live.b.b.a$a, kotlin.x>, kotlin.g.a.m<java.lang.Boolean, com.tencent.mm.live.b.b.a$a, kotlin.x> */
    public final kotlin.g.a.m<Boolean, a.C0371a, x> getCallMicListener() {
        return this.hUU;
    }

    public final void setCallMicListener(kotlin.g.a.m<? super Boolean, ? super a.C0371a, x> mVar) {
        this.hUU = mVar;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.b<? super java.lang.Boolean, kotlin.x>, kotlin.g.a.b<java.lang.Boolean, kotlin.x> */
    public final kotlin.g.a.b<Boolean, x> getMicPermissionListener() {
        return this.hUV;
    }

    public final void setMicPermissionListener(kotlin.g.a.b<? super Boolean, x> bVar) {
        this.hUV = bVar;
    }

    public final View getParent() {
        return this.hVd;
    }

    public final void setParent(View view) {
        AppMethodBeat.i(208453);
        p.h(view, "<set-?>");
        this.hVd = view;
        AppMethodBeat.o(208453);
    }

    public final void setDefaultMicState(boolean z) {
        this.hUS = z;
    }

    public final void aJc() {
        AppMethodBeat.i(208454);
        this.hTl.g(R.raw.playend, true, 1);
        AppMethodBeat.o(208454);
    }

    public static /* synthetic */ void a(LiveAnchorMicUserListView liveAnchorMicUserListView) {
        AppMethodBeat.i(208456);
        liveAnchorMicUserListView.a((kotlin.g.a.m<? super Integer, ? super Integer, x>) null);
        AppMethodBeat.o(208456);
    }

    private void a(kotlin.g.a.m<? super Integer, ? super Integer, x> mVar) {
        AppMethodBeat.i(208455);
        a.C0371a aVar = this.hUY;
        if (aVar != null) {
            com.tencent.mm.live.core.debug.a aVar2 = com.tencent.mm.live.core.debug.a.hCA;
            com.tencent.mm.live.core.debug.a.au("MicroMsg.LiveCoreMic", "[cgi]anchor close mic.".concat(String.valueOf(aVar)));
            com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
            long j2 = com.tencent.mm.live.b.x.aGr().hyH;
            com.tencent.mm.live.b.x xVar2 = com.tencent.mm.live.b.x.hJf;
            com.tencent.mm.live.b.a.k kVar = new com.tencent.mm.live.b.a.k(j2, com.tencent.mm.live.b.x.aGm(), String.valueOf(System.currentTimeMillis()), aVar.hFz, aVar.hFG);
            com.tencent.mm.ak.t azz = com.tencent.mm.kernel.g.azz();
            p.g(azz, "MMKernel.getNetSceneQueue()");
            kVar.doScene(azz.azD(), new f(aVar, this, mVar));
            AppMethodBeat.o(208455);
            return;
        }
        AppMethodBeat.o(208455);
    }

    public static final class f implements com.tencent.mm.ak.i {
        final /* synthetic */ LiveAnchorMicUserListView hVf;
        final /* synthetic */ a.C0371a hVk;
        final /* synthetic */ kotlin.g.a.m hVl;

        f(a.C0371a aVar, LiveAnchorMicUserListView liveAnchorMicUserListView, kotlin.g.a.m mVar) {
            this.hVk = aVar;
            this.hVf = liveAnchorMicUserListView;
            this.hVl = mVar;
        }

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
            AppMethodBeat.i(208445);
            qVar.setHasCallbackToQueue(true);
            com.tencent.mm.live.core.debug.a aVar = com.tencent.mm.live.core.debug.a.hCA;
            com.tencent.mm.live.core.debug.a.au("MicroMsg.LiveCoreMic", "[cgi-ret]anchor close mic :" + i2 + " errCode:" + i3 + " errMsg:" + str);
            if (i2 == 0 && i3 == 0) {
                this.hVf.aJc();
            }
            if (this.hVl != null) {
                this.hVl.invoke(Integer.valueOf(i2), Integer.valueOf(i3));
            } else if (i2 == 0 && i3 == 0) {
                Context context = this.hVf.getContext();
                Context context2 = this.hVf.getContext();
                p.g(context2, "context");
                u.makeText(context, context2.getResources().getString(R.string.ej4), 0).show();
                com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
                com.tencent.mm.live.b.x.aHa().hKT.remove(this.hVk);
                this.hVf.aJd();
                com.tencent.mm.live.b.x xVar2 = com.tencent.mm.live.b.x.hJf;
                com.tencent.mm.live.b.x.aHa().aHk();
                this.hVf.aJf();
                kotlin.g.a.m<Boolean, a.C0371a, x> callMicListener = this.hVf.getCallMicListener();
                if (callMicListener != null) {
                    callMicListener.invoke(Boolean.FALSE, null);
                    AppMethodBeat.o(208445);
                    return;
                }
                AppMethodBeat.o(208445);
                return;
            }
            AppMethodBeat.o(208445);
        }
    }

    public final void aJd() {
        this.hUZ = true;
        this.hUY = null;
    }

    public final void setMicUser(a.C0371a aVar) {
        this.hUY = aVar;
    }

    private void aJe() {
        AppMethodBeat.i(208457);
        int jn = com.tencent.mm.cb.a.jn(getContext());
        int jo = com.tencent.mm.cb.a.jo(getContext());
        if (jn <= jo) {
            jo = jn;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(jo, -1);
        layoutParams.gravity = 1;
        Context context = getContext();
        Context context2 = getContext();
        p.g(context2, "context");
        layoutParams.topMargin = com.tencent.mm.cb.a.fromDPToPix(context, context2.getResources().getDimension(R.dimen.a_r));
        this.hVd.setLayoutParams(layoutParams);
        AppMethodBeat.o(208457);
    }

    public final void aJf() {
        AppMethodBeat.i(208458);
        aJe();
        clearData();
        aJh();
        if (this.hUY != null) {
            aJi();
        }
        if (this.hUS) {
            com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
            ArrayList<a.C0371a> arrayList = com.tencent.mm.live.b.x.aHa().hKT;
            ArrayList<a.C0371a> arrayList2 = arrayList;
            a.C0371a aVar = this.hUY;
            if (arrayList2 == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
                AppMethodBeat.o(208458);
                throw tVar;
            }
            af.eV(arrayList2).remove(aVar);
            if (arrayList.size() > 0) {
                n(arrayList);
            } else if (this.hUY == null) {
                aJj();
            }
        } else {
            aJk();
        }
        this.hUX.notifyDataSetChanged();
        AppMethodBeat.o(208458);
    }

    public static void aJg() {
        AppMethodBeat.i(208459);
        com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
        ArrayList<a.C0371a> arrayList = com.tencent.mm.live.b.x.aHa().hKT;
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(it.next().hFJ);
        }
        r rVar = r.hIg;
        r.ag(arrayList2);
        AppMethodBeat.o(208459);
    }

    public final a.C0371a getSelectUser() {
        return this.hUY;
    }

    private final void clearData() {
        AppMethodBeat.i(208460);
        this.hUX.hVg.clear();
        AppMethodBeat.o(208460);
    }

    private final void aJh() {
        AppMethodBeat.i(208461);
        this.hUX.hVg.add(new c(0, null, null, 6));
        AppMethodBeat.o(208461);
    }

    private final void aJi() {
        AppMethodBeat.i(208462);
        a.C0371a aVar = this.hUY;
        if (aVar != null) {
            this.hUX.hVg.add(new c(1, null, com.tencent.mm.cb.a.aI(getContext(), R.string.eii), 2));
            this.hUX.hVg.add(new c(3, aVar, null, 4));
            AppMethodBeat.o(208462);
            return;
        }
        AppMethodBeat.o(208462);
    }

    private final void n(ArrayList<a.C0371a> arrayList) {
        AppMethodBeat.i(208463);
        ArrayList<c> arrayList2 = this.hUX.hVg;
        ae aeVar = ae.SYK;
        String aI = com.tencent.mm.cb.a.aI(getContext(), R.string.ejg);
        p.g(aI, "ResourceHelper.getString…ive_room_wait_mic_number)");
        com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
        String format = String.format(aI, Arrays.copyOf(new Object[]{Integer.valueOf(com.tencent.mm.live.b.x.aHa().hKT.size())}, 1));
        p.g(format, "java.lang.String.format(format, *args)");
        arrayList2.add(new c(1, null, format, 2));
        for (T t : arrayList) {
            String str = t.hFJ;
            a.C0371a aVar = this.hUY;
            String str2 = aVar != null ? aVar.hFJ : null;
            if (!p.j(str, str2)) {
                this.hUX.hVg.add(new c(2, t, null, 4));
            }
        }
        AppMethodBeat.o(208463);
    }

    private final void aJj() {
        AppMethodBeat.i(208464);
        this.hUX.hVg.add(new c(4, null, null, 6));
        AppMethodBeat.o(208464);
    }

    private final void aJk() {
        AppMethodBeat.i(208465);
        this.hUX.hVg.add(new c(5, null, null, 6));
        AppMethodBeat.o(208465);
    }

    public static final class e implements com.tencent.mm.ak.i {
        final /* synthetic */ a.C0371a hKZ;
        final /* synthetic */ LiveAnchorMicUserListView hVf;

        e(LiveAnchorMicUserListView liveAnchorMicUserListView, a.C0371a aVar) {
            this.hVf = liveAnchorMicUserListView;
            this.hKZ = aVar;
        }

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
            AppMethodBeat.i(208444);
            qVar.setHasCallbackToQueue(true);
            com.tencent.mm.live.core.debug.a aVar = com.tencent.mm.live.core.debug.a.hCA;
            com.tencent.mm.live.core.debug.a.au("MicroMsg.LiveCoreMic", "[cgi]accept mic errType:" + i2 + " errCode:" + i3 + " errMsg:" + str);
            if (i2 == 0 && i3 == 0) {
                this.hVf.hTl.g(R.raw.playend, true, 1);
                com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
                com.tencent.mm.live.b.x.aHa().a(this.hKZ);
                AppMethodBeat.o(208444);
                return;
            }
            u.makeText(this.hVf.getContext(), com.tencent.mm.cb.a.aI(this.hVf.getContext(), R.string.eih), 0).show();
            this.hVf.hUZ = true;
            kotlin.g.a.m<Boolean, a.C0371a, x> callMicListener = this.hVf.getCallMicListener();
            if (callMicListener != null) {
                callMicListener.invoke(Boolean.FALSE, null);
            }
            this.hVf.aJf();
            AppMethodBeat.o(208444);
        }
    }

    public static final class g implements o.f {
        final /* synthetic */ LiveAnchorMicUserListView hVf;

        g(LiveAnchorMicUserListView liveAnchorMicUserListView) {
            this.hVf = liveAnchorMicUserListView;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
            AppMethodBeat.i(208446);
            com.tencent.mm.ui.widget.a.e eVar = this.hVf.hOv;
            if (eVar != null) {
                eVar.setFooterView(null);
            }
            mVar.clear();
            Context context = this.hVf.getContext();
            p.g(context, "context");
            int color = context.getResources().getColor(R.color.xq);
            Context context2 = this.hVf.getContext();
            p.g(context2, "context");
            mVar.a(1, color, context2.getResources().getString(R.string.eil));
            AppMethodBeat.o(208446);
        }
    }

    public static final class h implements o.g {
        final /* synthetic */ LiveAnchorMicUserListView hVf;

        h(LiveAnchorMicUserListView liveAnchorMicUserListView) {
            this.hVf = liveAnchorMicUserListView;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(208447);
            p.h(menuItem, "menuItem");
            switch (menuItem.getItemId()) {
                case 0:
                    AppMethodBeat.o(208447);
                    return;
                case 1:
                    com.tencent.mm.ui.widget.a.e eVar = this.hVf.hOv;
                    if (eVar != null) {
                        eVar.bMo();
                    }
                    LiveAnchorMicUserListView.a(this.hVf, false);
                    AppMethodBeat.o(208447);
                    return;
                default:
                    com.tencent.mm.ui.widget.a.e eVar2 = this.hVf.hOv;
                    if (eVar2 != null) {
                        eVar2.bMo();
                        AppMethodBeat.o(208447);
                        return;
                    }
                    AppMethodBeat.o(208447);
                    return;
            }
        }
    }

    public static final class i implements e.b {
        final /* synthetic */ LiveAnchorMicUserListView hVf;

        i(LiveAnchorMicUserListView liveAnchorMicUserListView) {
            this.hVf = liveAnchorMicUserListView;
        }

        @Override // com.tencent.mm.ui.widget.a.e.b
        public final void onDismiss() {
            AppMethodBeat.i(208448);
            this.hVf.hOv = null;
            AppMethodBeat.o(208448);
        }
    }

    public static final class k implements com.tencent.mm.ak.i {
        final /* synthetic */ LiveAnchorMicUserListView hVf;

        k(LiveAnchorMicUserListView liveAnchorMicUserListView) {
            this.hVf = liveAnchorMicUserListView;
        }

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
            AppMethodBeat.i(208450);
            qVar.setHasCallbackToQueue(true);
            com.tencent.mm.live.core.debug.a aVar = com.tencent.mm.live.core.debug.a.hCA;
            com.tencent.mm.live.core.debug.a.au("MicroMsg.LiveCoreMic", "anchor close mic permission:" + i2 + " errCode:" + i3 + " errMsg:" + str);
            if (i2 == 0 && i3 == 0) {
                this.hVf.setMicPermission(true);
                this.hVf.aJf();
            } else {
                this.hVf.setMicPermission(false);
            }
            kotlin.g.a.b<Boolean, x> micPermissionListener = this.hVf.getMicPermissionListener();
            if (micPermissionListener != null) {
                micPermissionListener.invoke(Boolean.valueOf(this.hVf.getMicPermission()));
                AppMethodBeat.o(208450);
                return;
            }
            AppMethodBeat.o(208450);
        }
    }

    public static final class m implements com.tencent.mm.ak.i {
        final /* synthetic */ LiveAnchorMicUserListView hVf;

        m(LiveAnchorMicUserListView liveAnchorMicUserListView) {
            this.hVf = liveAnchorMicUserListView;
        }

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
            AppMethodBeat.i(208452);
            qVar.setHasCallbackToQueue(true);
            com.tencent.mm.live.core.debug.a aVar = com.tencent.mm.live.core.debug.a.hCA;
            com.tencent.mm.live.core.debug.a.au("MicroMsg.LiveCoreMic", "anchor close mic permission:" + i2 + " errCode:" + i3 + " errMsg:" + str);
            if (i2 == 0 && i3 == 0) {
                this.hVf.setMicPermission(false);
                com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
                com.tencent.mm.live.b.x.aHa().hKT.clear();
                this.hVf.aJf();
            } else {
                this.hVf.setMicPermission(true);
            }
            kotlin.g.a.b<Boolean, x> micPermissionListener = this.hVf.getMicPermissionListener();
            if (micPermissionListener != null) {
                micPermissionListener.invoke(Boolean.valueOf(this.hVf.getMicPermission()));
                AppMethodBeat.o(208452);
                return;
            }
            AppMethodBeat.o(208452);
        }
    }

    public final class b extends RecyclerView.a<RecyclerView.v> {
        ArrayList<c> hVg = new ArrayList<>();

        public b() {
            LiveAnchorMicUserListView.this = r3;
            AppMethodBeat.i(208438);
            AppMethodBeat.o(208438);
        }

        public static final class d extends RecyclerView.v {
            final /* synthetic */ b hVh;
            final /* synthetic */ ViewGroup hVi;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            d(b bVar, ViewGroup viewGroup, View view) {
                super(view);
                this.hVh = bVar;
                this.hVi = viewGroup;
            }
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final RecyclerView.v a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(208433);
            p.h(viewGroup, "parent");
            switch (i2) {
                case 0:
                    d dVar = new d(this, viewGroup, LayoutInflater.from(LiveAnchorMicUserListView.this.getContext()).inflate(R.layout.b0a, viewGroup, false));
                    AppMethodBeat.o(208433);
                    return dVar;
                case 1:
                    e eVar = new e(this, viewGroup, LayoutInflater.from(LiveAnchorMicUserListView.this.getContext()).inflate(R.layout.b0b, viewGroup, false));
                    AppMethodBeat.o(208433);
                    return eVar;
                case 2:
                    f fVar = new f(this, viewGroup, LayoutInflater.from(LiveAnchorMicUserListView.this.getContext()).inflate(R.layout.b07, viewGroup, false));
                    AppMethodBeat.o(208433);
                    return fVar;
                case 3:
                    g gVar = new g(this, viewGroup, LayoutInflater.from(LiveAnchorMicUserListView.this.getContext()).inflate(R.layout.b08, viewGroup, false));
                    AppMethodBeat.o(208433);
                    return gVar;
                case 4:
                    h hVar = new h(this, viewGroup, LayoutInflater.from(LiveAnchorMicUserListView.this.getContext()).inflate(R.layout.b09, viewGroup, false));
                    AppMethodBeat.o(208433);
                    return hVar;
                case 5:
                    i iVar = new i(this, viewGroup, LayoutInflater.from(LiveAnchorMicUserListView.this.getContext()).inflate(R.layout.b0_, viewGroup, false));
                    AppMethodBeat.o(208433);
                    return iVar;
                default:
                    j jVar = new j(this, viewGroup, LayoutInflater.from(LiveAnchorMicUserListView.this.getContext()).inflate(R.layout.b0b, viewGroup, false));
                    AppMethodBeat.o(208433);
                    return jVar;
            }
        }

        public static final class e extends RecyclerView.v {
            final /* synthetic */ b hVh;
            final /* synthetic */ ViewGroup hVi;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            e(b bVar, ViewGroup viewGroup, View view) {
                super(view);
                this.hVh = bVar;
                this.hVi = viewGroup;
            }
        }

        public static final class f extends RecyclerView.v {
            final /* synthetic */ b hVh;
            final /* synthetic */ ViewGroup hVi;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            f(b bVar, ViewGroup viewGroup, View view) {
                super(view);
                this.hVh = bVar;
                this.hVi = viewGroup;
            }
        }

        public static final class g extends RecyclerView.v {
            final /* synthetic */ b hVh;
            final /* synthetic */ ViewGroup hVi;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            g(b bVar, ViewGroup viewGroup, View view) {
                super(view);
                this.hVh = bVar;
                this.hVi = viewGroup;
            }
        }

        public static final class h extends RecyclerView.v {
            final /* synthetic */ b hVh;
            final /* synthetic */ ViewGroup hVi;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            h(b bVar, ViewGroup viewGroup, View view) {
                super(view);
                this.hVh = bVar;
                this.hVi = viewGroup;
            }
        }

        public static final class i extends RecyclerView.v {
            final /* synthetic */ b hVh;
            final /* synthetic */ ViewGroup hVi;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            i(b bVar, ViewGroup viewGroup, View view) {
                super(view);
                this.hVh = bVar;
                this.hVi = viewGroup;
            }
        }

        public static final class j extends RecyclerView.v {
            final /* synthetic */ b hVh;
            final /* synthetic */ ViewGroup hVi;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            j(b bVar, ViewGroup viewGroup, View view) {
                super(view);
                this.hVh = bVar;
                this.hVi = viewGroup;
            }
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            AppMethodBeat.i(208434);
            int size = this.hVg.size();
            AppMethodBeat.o(208434);
            return size;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final void a(RecyclerView.v vVar, int i2) {
            AppMethodBeat.i(208435);
            p.h(vVar, "holder");
            switch (getItemViewType(i2)) {
                case 0:
                    MMSwitchBtn mMSwitchBtn = (MMSwitchBtn) vVar.aus.findViewById(R.id.efl);
                    ((TextView) vVar.aus.findViewById(R.id.efm)).setOnClickListener(new a(this));
                    p.g(mMSwitchBtn, "switchView");
                    mMSwitchBtn.setCheck(LiveAnchorMicUserListView.this.getMicPermission());
                    break;
                case 1:
                    View view = vVar.aus;
                    if (view != null) {
                        ((TextView) view).setText(this.hVg.get(i2).title);
                        break;
                    } else {
                        t tVar = new t("null cannot be cast to non-null type android.widget.TextView");
                        AppMethodBeat.o(208435);
                        throw tVar;
                    }
                case 2:
                    a.C0371a aVar = this.hVg.get(i2).hVj;
                    if (aVar != null) {
                        View view2 = vVar.aus;
                        p.g(view2, "holder.itemView");
                        a(view2, aVar);
                    }
                    ((TextView) vVar.aus.findViewById(R.id.ejd)).setOnClickListener(new View$OnClickListenerC0392b(this, i2));
                    break;
                case 3:
                    a.C0371a aVar2 = this.hVg.get(i2).hVj;
                    if (aVar2 != null) {
                        View view3 = vVar.aus;
                        p.g(view3, "holder.itemView");
                        a(view3, aVar2);
                    }
                    ImageView imageView = (ImageView) vVar.aus.findViewById(R.id.ejy);
                    ImageView imageView2 = (ImageView) vVar.aus.findViewById(R.id.ejz);
                    TextView textView = (TextView) vVar.aus.findViewById(R.id.ejr);
                    if (LiveAnchorMicUserListView.this.hVa) {
                        p.g(imageView2, "maskView");
                        imageView2.setVisibility(0);
                        p.g(imageView, "loadingView");
                        imageView.setVisibility(0);
                        Drawable background = imageView.getBackground();
                        if (background == null) {
                            t tVar2 = new t("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
                            AppMethodBeat.o(208435);
                            throw tVar2;
                        }
                        ((AnimationDrawable) background).stop();
                        Drawable background2 = imageView.getBackground();
                        if (background2 == null) {
                            t tVar3 = new t("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
                            AppMethodBeat.o(208435);
                            throw tVar3;
                        }
                        ((AnimationDrawable) background2).start();
                        p.g(textView, "btn");
                        Context context = LiveAnchorMicUserListView.this.getContext();
                        p.g(context, "context");
                        textView.setBackground(context.getResources().getDrawable(R.drawable.a_l));
                        Context context2 = LiveAnchorMicUserListView.this.getContext();
                        p.g(context2, "context");
                        textView.setText(context2.getResources().getString(R.string.eij));
                    } else {
                        p.g(imageView2, "maskView");
                        imageView2.setVisibility(4);
                        p.g(imageView, "loadingView");
                        imageView.setVisibility(4);
                        Drawable background3 = imageView.getBackground();
                        if (background3 == null) {
                            t tVar4 = new t("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
                            AppMethodBeat.o(208435);
                            throw tVar4;
                        }
                        ((AnimationDrawable) background3).stop();
                        p.g(textView, "btn");
                        Context context3 = LiveAnchorMicUserListView.this.getContext();
                        p.g(context3, "context");
                        textView.setBackground(context3.getResources().getDrawable(R.drawable.ad_));
                        Context context4 = LiveAnchorMicUserListView.this.getContext();
                        p.g(context4, "context");
                        textView.setText(context4.getResources().getString(R.string.eir));
                    }
                    textView.setOnClickListener(new c(this, i2));
                    break;
            }
            View view4 = vVar.aus;
            p.g(view4, "holder.itemView");
            if (LiveAnchorMicUserListView.this.hUZ) {
                view4.setAlpha(1.0f);
                view4.setEnabled(true);
                AppMethodBeat.o(208435);
                return;
            }
            if (i2 >= 3) {
                view4.setAlpha(0.3f);
                view4.setEnabled(false);
            }
            AppMethodBeat.o(208435);
        }

        static final class a implements View.OnClickListener {
            final /* synthetic */ b hVh;

            a(b bVar) {
                this.hVh = bVar;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(208430);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (LiveAnchorMicUserListView.this.getMicPermission()) {
                    LiveAnchorMicUserListView.b(LiveAnchorMicUserListView.this);
                    com.tencent.mm.ui.widget.a.e eVar = LiveAnchorMicUserListView.this.hOv;
                    if (eVar != null) {
                        eVar.dGm();
                    }
                } else {
                    LiveAnchorMicUserListView.a(LiveAnchorMicUserListView.this, true);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(208430);
            }
        }

        /* renamed from: com.tencent.mm.live.ui.dialog.LiveAnchorMicUserListView$b$b */
        static final class View$OnClickListenerC0392b implements View.OnClickListener {
            final /* synthetic */ int gUj;
            final /* synthetic */ b hVh;

            View$OnClickListenerC0392b(b bVar, int i2) {
                this.hVh = bVar;
                this.gUj = i2;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(208431);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (LiveAnchorMicUserListView.this.hUZ) {
                    LiveAnchorMicUserListView.this.hVa = true;
                    LiveAnchorMicUserListView.this.hVb.invoke(this.hVh.hVg.get(this.gUj).hVj);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(208431);
            }
        }

        static final class c implements View.OnClickListener {
            final /* synthetic */ int gUj;
            final /* synthetic */ b hVh;

            c(b bVar, int i2) {
                this.hVh = bVar;
                this.gUj = i2;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(208432);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onBindViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                LiveAnchorMicUserListView.this.hVc.invoke(this.hVh.hVg.get(this.gUj).hVj);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onBindViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(208432);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemViewType(int i2) {
            AppMethodBeat.i(208436);
            int i3 = this.hVg.get(i2).type;
            AppMethodBeat.o(208436);
            return i3;
        }

        private static void a(View view, a.C0371a aVar) {
            AppMethodBeat.i(208437);
            com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
            p.g(af, "service<IMessengerStorag…engerStorage::class.java)");
            as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().Kn(aVar.hFJ);
            a.b.d((ImageView) view.findViewById(R.id.efd), aVar.hFJ, 0.1f);
            View findViewById = view.findViewById(R.id.efh);
            p.g(findViewById, "itemView.findViewById<Te…ive_anchor_mic_user_name)");
            p.g(Kn, "contact");
            ((TextView) findViewById).setText(Kn.getNickname());
            AppMethodBeat.o(208437);
        }
    }

    public static final class c {
        a.C0371a hVj;
        String title;
        int type;

        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
            if (kotlin.g.b.p.j(r3.title, r4.title) != false) goto L_0x0028;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 208442(0x32e3a, float:2.9209E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x0028
                boolean r0 = r4 instanceof com.tencent.mm.live.ui.dialog.LiveAnchorMicUserListView.c
                if (r0 == 0) goto L_0x002d
                com.tencent.mm.live.ui.dialog.LiveAnchorMicUserListView$c r4 = (com.tencent.mm.live.ui.dialog.LiveAnchorMicUserListView.c) r4
                int r0 = r3.type
                int r1 = r4.type
                if (r0 != r1) goto L_0x002d
                com.tencent.mm.live.b.b.a$a r0 = r3.hVj
                com.tencent.mm.live.b.b.a$a r1 = r4.hVj
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x002d
                java.lang.String r0 = r3.title
                java.lang.String r1 = r4.title
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x002d
            L_0x0028:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x002c:
                return r0
            L_0x002d:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x002c
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.live.ui.dialog.LiveAnchorMicUserListView.c.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 0;
            AppMethodBeat.i(208441);
            int i3 = this.type * 31;
            a.C0371a aVar = this.hVj;
            int hashCode = ((aVar != null ? aVar.hashCode() : 0) + i3) * 31;
            String str = this.title;
            if (str != null) {
                i2 = str.hashCode();
            }
            int i4 = hashCode + i2;
            AppMethodBeat.o(208441);
            return i4;
        }

        public final String toString() {
            AppMethodBeat.i(208440);
            String str = "LiveMicListItem(type=" + this.type + ", user=" + this.hVj + ", title=" + this.title + ")";
            AppMethodBeat.o(208440);
            return str;
        }

        private c(int i2, a.C0371a aVar, String str) {
            this.type = i2;
            this.hVj = aVar;
            this.title = str;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ c(int i2, a.C0371a aVar, String str, int i3) {
            this(i2, (i3 & 2) != 0 ? null : aVar, (i3 & 4) != 0 ? null : str);
            AppMethodBeat.i(208439);
            AppMethodBeat.o(208439);
        }
    }

    public static final /* synthetic */ void b(LiveAnchorMicUserListView liveAnchorMicUserListView) {
        AppMethodBeat.i(208468);
        if (liveAnchorMicUserListView.hOv == null) {
            liveAnchorMicUserListView.hOv = new com.tencent.mm.ui.widget.a.e(liveAnchorMicUserListView.getContext(), 1, true);
            com.tencent.mm.ui.widget.a.e eVar = liveAnchorMicUserListView.hOv;
            if (eVar != null) {
                eVar.hbs();
            }
            View inflate = View.inflate(liveAnchorMicUserListView.getContext(), R.layout.b0l, null);
            TextView textView = (TextView) inflate.findViewById(R.id.eg6);
            p.g(textView, "bottomSheetTitleTv");
            Context context = liveAnchorMicUserListView.getContext();
            p.g(context, "context");
            textView.setText(context.getResources().getString(R.string.eim));
            com.tencent.mm.ui.widget.a.e eVar2 = liveAnchorMicUserListView.hOv;
            if (eVar2 != null) {
                eVar2.setTitleView(inflate);
            }
        }
        com.tencent.mm.ui.widget.a.e eVar3 = liveAnchorMicUserListView.hOv;
        if (eVar3 != null) {
            eVar3.hbr();
        }
        com.tencent.mm.ui.widget.a.e eVar4 = liveAnchorMicUserListView.hOv;
        if (eVar4 != null) {
            eVar4.a(new g(liveAnchorMicUserListView));
        }
        com.tencent.mm.ui.widget.a.e eVar5 = liveAnchorMicUserListView.hOv;
        if (eVar5 != null) {
            eVar5.a(new h(liveAnchorMicUserListView));
        }
        com.tencent.mm.ui.widget.a.e eVar6 = liveAnchorMicUserListView.hOv;
        if (eVar6 != null) {
            eVar6.b(new i(liveAnchorMicUserListView));
            AppMethodBeat.o(208468);
            return;
        }
        AppMethodBeat.o(208468);
    }

    public static final /* synthetic */ void a(LiveAnchorMicUserListView liveAnchorMicUserListView, boolean z) {
        AppMethodBeat.i(208469);
        if (z) {
            com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
            long j2 = com.tencent.mm.live.b.x.aGr().hyH;
            com.tencent.mm.live.b.x xVar2 = com.tencent.mm.live.b.x.hJf;
            com.tencent.mm.live.b.a.j jVar = new com.tencent.mm.live.b.a.j(j2, com.tencent.mm.live.b.x.aGm(), false);
            com.tencent.mm.ak.t azz = com.tencent.mm.kernel.g.azz();
            p.g(azz, "MMKernel.getNetSceneQueue()");
            jVar.doScene(azz.azD(), new k(liveAnchorMicUserListView));
            com.tencent.mm.live.b.x xVar3 = com.tencent.mm.live.b.x.hJf;
            String aGm = com.tencent.mm.live.b.x.aGm();
            com.tencent.mm.live.b.x xVar4 = com.tencent.mm.live.b.x.hJf;
            long j3 = com.tencent.mm.live.b.x.aGr().hyH;
            com.tencent.mm.live.b.x xVar5 = com.tencent.mm.live.b.x.hJf;
            String aGt = com.tencent.mm.live.b.x.aGt();
            com.tencent.mm.live.b.x xVar6 = com.tencent.mm.live.b.x.hJf;
            com.tencent.mm.live.d.e.a(aGm, j3, aGt, 3, 0, com.tencent.mm.live.b.x.aGr().LIa);
            com.tencent.mm.live.d.c.aIi();
            AppMethodBeat.o(208469);
            return;
        }
        liveAnchorMicUserListView.a(new l(liveAnchorMicUserListView));
        com.tencent.mm.live.b.x xVar7 = com.tencent.mm.live.b.x.hJf;
        long j4 = com.tencent.mm.live.b.x.aGr().hyH;
        com.tencent.mm.live.b.x xVar8 = com.tencent.mm.live.b.x.hJf;
        com.tencent.mm.live.b.a.j jVar2 = new com.tencent.mm.live.b.a.j(j4, com.tencent.mm.live.b.x.aGm(), true);
        com.tencent.mm.ak.t azz2 = com.tencent.mm.kernel.g.azz();
        p.g(azz2, "MMKernel.getNetSceneQueue()");
        jVar2.doScene(azz2.azD(), new m(liveAnchorMicUserListView));
        com.tencent.mm.live.b.x xVar9 = com.tencent.mm.live.b.x.hJf;
        String aGm2 = com.tencent.mm.live.b.x.aGm();
        com.tencent.mm.live.b.x xVar10 = com.tencent.mm.live.b.x.hJf;
        long j5 = com.tencent.mm.live.b.x.aGr().hyH;
        com.tencent.mm.live.b.x xVar11 = com.tencent.mm.live.b.x.hJf;
        String aGt2 = com.tencent.mm.live.b.x.aGt();
        com.tencent.mm.live.b.x xVar12 = com.tencent.mm.live.b.x.hJf;
        com.tencent.mm.live.d.e.a(aGm2, j5, aGt2, 3, 1, com.tencent.mm.live.b.x.aGr().LIa);
        com.tencent.mm.live.d.c.aIh();
        AppMethodBeat.o(208469);
    }

    public static final /* synthetic */ void b(LiveAnchorMicUserListView liveAnchorMicUserListView, a.C0371a aVar) {
        AppMethodBeat.i(208470);
        com.tencent.mm.live.core.debug.a aVar2 = com.tencent.mm.live.core.debug.a.hCA;
        com.tencent.mm.live.core.debug.a.au("MicroMsg.LiveCoreMic", "[cgi]anchor accept user mic.".concat(String.valueOf(aVar)));
        com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
        com.tencent.mm.live.b.a.f fVar = new com.tencent.mm.live.b.a.f(com.tencent.mm.live.b.x.aGr().hyH, aVar.hFG, aVar.roomId, aVar.hFz, String.valueOf(System.currentTimeMillis()));
        com.tencent.mm.ak.t azz = com.tencent.mm.kernel.g.azz();
        p.g(azz, "MMKernel.getNetSceneQueue()");
        fVar.doScene(azz.azD(), new e(liveAnchorMicUserListView, aVar));
        AppMethodBeat.o(208470);
    }
}
