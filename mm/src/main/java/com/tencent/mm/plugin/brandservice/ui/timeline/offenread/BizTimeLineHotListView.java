package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.content.Context;
import android.content.Intent;
import android.graphics.PointF;
import android.support.v7.h.c;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ae;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.aq;
import com.tencent.mm.model.aa;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.plugin.brandservice.b.c;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.BizTLRecCardCanvasView;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.h;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.tools.z;
import com.tencent.mm.protocal.protobuf.cup;
import com.tencent.mm.protocal.protobuf.cus;
import com.tencent.mm.protocal.protobuf.eqs;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import java.util.ArrayList;
import java.util.List;
import kotlin.n.n;

public class BizTimeLineHotListView extends MRecyclerView {
    public static int pze;
    private Context mContext;
    private int mScreenWidth = 0;
    private List<c> nZr = new ArrayList();
    private float oDy = 0.0f;
    private int oDz = 0;
    h pyW;
    private a pyX;
    boolean pyY = false;
    private g pyZ;
    private j pza;
    private float pzb = 0.0f;
    private float pzc = 0.0f;
    private float pzd = 0.0f;
    public IListener<aq> pzf = new IListener<aq>() {
        /* class com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotListView.AnonymousClass1 */

        {
            AppMethodBeat.i(175427);
            this.__eventId = aq.class.getName().hashCode();
            AppMethodBeat.o(175427);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(aq aqVar) {
            AppMethodBeat.i(175428);
            aq aqVar2 = aqVar;
            if (!(aqVar2 == null || BizTimeLineHotListView.this.nZr == null)) {
                Log.i("MicroMsg.BizTimeLineHotListView", "alvinluo onTopBarVideoChannelEntryChanged switchOption: %d, list: %d", Integer.valueOf(aqVar2.dDA.dDB), Integer.valueOf(BizTimeLineHotListView.this.nZr.size()));
                if (c.clu()) {
                    if (BizTimeLineHotListView.this.nZr.size() > 1) {
                        c cVar = (c) BizTimeLineHotListView.this.nZr.get(1);
                        if (cVar.type != 3 || !(cVar instanceof e)) {
                            BizTimeLineHotListView.a(BizTimeLineHotListView.this, BizTimeLineHotListView.this.nZr, aqVar2);
                        } else {
                            BizTimeLineHotListView.a(BizTimeLineHotListView.this, (e) cVar, aqVar2);
                        }
                    } else if (BizTimeLineHotListView.this.nZr.size() == 1) {
                        BizTimeLineHotListView.a(BizTimeLineHotListView.this, BizTimeLineHotListView.this.nZr, aqVar2);
                    }
                } else if (BizTimeLineHotListView.this.nZr.size() > 1) {
                    c cVar2 = (c) BizTimeLineHotListView.this.nZr.get(1);
                    if (cVar2.type == 3 && (cVar2 instanceof e)) {
                        BizTimeLineHotListView.this.nZr.remove(1);
                        BizTimeLineHotListView.this.pyY = false;
                        if (BizTimeLineHotListView.this.pyX != null) {
                            BizTimeLineHotListView.this.pyX.atj.notifyChanged();
                        }
                    }
                }
            }
            AppMethodBeat.o(175428);
            return false;
        }
    };

    static /* synthetic */ void b(b bVar) {
        AppMethodBeat.i(194994);
        a(bVar);
        AppMethodBeat.o(194994);
    }

    public BizTimeLineHotListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(6081);
        this.mContext = context;
        init();
        AppMethodBeat.o(6081);
    }

    public BizTimeLineHotListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(6082);
        this.mContext = context;
        init();
        AppMethodBeat.o(6082);
    }

    @Override // android.support.v7.widget.RecyclerView
    public void onDetachedFromWindow() {
        AppMethodBeat.i(6083);
        super.onDetachedFromWindow();
        AppMethodBeat.o(6083);
    }

    private void init() {
        AppMethodBeat.i(175432);
        Log.v("MicroMsg.BizTimeLineHotListView", "alvinluo init");
        pze = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 16);
        this.pzf.alive();
        setItemAnimator(null);
        AppMethodBeat.o(175432);
    }

    public final void c(List<c> list, boolean z) {
        AppMethodBeat.i(194982);
        ArrayList arrayList = new ArrayList(list);
        bX(arrayList);
        Log.i("MicroMsg.BizTimeLineHotListView", "alvinluo refreshData new list: %d, old list: %d, configurationChanged: %b", Integer.valueOf(arrayList.size()), Integer.valueOf(this.nZr.size()), Boolean.valueOf(z));
        b bVar = new b(this.nZr, arrayList);
        if (z) {
            bVar.pzK = true;
        }
        c.b a2 = android.support.v7.h.c.a(bVar, true);
        this.nZr.clear();
        this.nZr.addAll(arrayList);
        a2.a(this.pyX);
        AppMethodBeat.o(194982);
    }

    public final void a(c cVar) {
        AppMethodBeat.i(194983);
        if (cVar == null) {
            AppMethodBeat.o(194983);
            return;
        }
        b bVar = (b) ch(cVar.position);
        if (bVar == null) {
            Log.e("MicroMsg.BizTimeLineHotListView", "refreshUnread %s", cVar.KJV);
            AppMethodBeat.o(194983);
        } else if (cVar.pzL) {
            bVar.pzk.setVisibility(0);
            AppMethodBeat.o(194983);
        } else {
            bVar.pzk.setVisibility(8);
            AppMethodBeat.o(194983);
        }
    }

    @Override // android.support.v7.widget.RecyclerView, com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView
    public a getAdapter() {
        return this.pyX;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView
    public final boolean cdc() {
        return false;
    }

    public final void cnm() {
        AppMethodBeat.i(6085);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.nZr);
        int currentPage = getCurrentPage();
        int AH = h.AH(currentPage);
        int Dl = h.Dl(currentPage);
        if (currentPage == 0) {
            AH++;
        }
        int i2 = AH;
        while (i2 <= Dl && i2 < arrayList.size()) {
            c cVar = (c) arrayList.get(i2);
            if (cVar != null) {
                g gVar = this.pyZ;
                if (cVar != null) {
                    if (cVar.type == 1) {
                        cus cus = gVar.pzS.get(cVar.KJV);
                        if (cus == null) {
                            cus cus2 = new cus();
                            cus2.KUC = cVar.KJV;
                            cus2.MzQ = cVar.pzL ? 1 : 0;
                            cus2.MzR = (int) (System.currentTimeMillis() / 1000);
                            cus2.xHb = cVar.position - 1;
                            cus2.pQJ = 1;
                            cus2.type = 0;
                            gVar.pzS.put(cVar.KJV, cus2);
                        } else {
                            cus.MzQ = cVar.pzL ? 1 : 0;
                            cus.MzR = (int) (System.currentTimeMillis() / 1000);
                            cus.xHb = cVar.position - 1;
                            cus.type = 0;
                            cus.pQJ++;
                        }
                    } else if (cVar.type == 3) {
                        cus cus3 = new cus();
                        long currentTimeMillis = System.currentTimeMillis();
                        cus3.MzR = (int) (currentTimeMillis / 1000);
                        cus3.xHb = cVar.position - 1;
                        cus3.pQJ = 1;
                        com.tencent.mm.plugin.brandservice.b.c cVar2 = com.tencent.mm.plugin.brandservice.b.c.pne;
                        cus3.type = com.tencent.mm.plugin.brandservice.b.c.clF() ? 2 : 1;
                        cus3.iwv = com.tencent.mm.plugin.brandservice.b.c.pne.kj(false);
                        cus3.MzT = com.tencent.mm.plugin.brandservice.b.c.pne.clC() ? 1 : 0;
                        com.tencent.mm.plugin.brandservice.b.c cVar3 = com.tencent.mm.plugin.brandservice.b.c.pne;
                        cus3.MzS = com.tencent.mm.plugin.brandservice.b.c.clD();
                        cus3.MzU = com.tencent.mm.plugin.brandservice.b.c.pne.clB() ? 1 : 0;
                        int i3 = g.pzU;
                        g.pzU = i3 + 1;
                        cus3.MzZ = i3;
                        cus3.MzV = currentTimeMillis;
                        gVar.pzS.put(cVar.KJV, cus3);
                        com.tencent.mm.plugin.brandservice.b.c cVar4 = com.tencent.mm.plugin.brandservice.b.c.pne;
                        h.INSTANCE.a(21258, 1, Long.valueOf(currentTimeMillis), 0, z.bfG(cus3.iwv), Integer.valueOf(com.tencent.mm.plugin.brandservice.b.c.clF() ? 1 : 0));
                    }
                }
            }
            i2++;
        }
        AppMethodBeat.o(6085);
    }

    public final void a(Context context, List<c> list, g gVar, j jVar) {
        AppMethodBeat.i(194984);
        this.pyZ = gVar;
        this.pza = jVar;
        this.nZr.addAll(list);
        bX(this.nZr);
        this.pyX = new a(context);
        AnonymousClass2 r0 = new LinearLayoutManager() {
            /* class com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotListView.AnonymousClass2 */

            @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
            public final boolean supportsPredictiveItemAnimations() {
                return false;
            }
        };
        r0.setOrientation(0);
        setLayoutManager(r0);
        setAdapter(this.pyX);
        this.pyW = new h(getCustomItemCount());
        h hVar = this.pyW;
        int completelyCountPerPage = a.getCompletelyCountPerPage();
        hVar.mContext = context;
        hVar.pzW = this;
        hVar.oDS = completelyCountPerPage;
        hVar.pzW.b(hVar);
        hVar.pzW.a(hVar);
        hVar.oDV = (LinearLayoutManager) hVar.pzW.getLayoutManager();
        hVar.mSmoothScroller = new ae(hVar.pzW.getContext()) {
            /* class com.tencent.mm.plugin.brandservice.ui.timeline.offenread.h.AnonymousClass1 */

            @Override // android.support.v7.widget.ae
            public final int kz() {
                return -1;
            }

            @Override // android.support.v7.widget.ae
            public final float a(DisplayMetrics displayMetrics) {
                return 80.0f / ((float) displayMetrics.densityDpi);
            }

            @Override // android.support.v7.widget.ae
            public final int cd(int i2) {
                AppMethodBeat.i(6138);
                int cd = super.cd(i2);
                AppMethodBeat.o(6138);
                return cd;
            }

            @Override // android.support.v7.widget.RecyclerView.r
            public final PointF bZ(int i2) {
                AppMethodBeat.i(6139);
                PointF bZ = ((LinearLayoutManager) h.this.pzW.getLayoutManager()).bZ(i2);
                AppMethodBeat.o(6139);
                return bZ;
            }

            @Override // android.support.v7.widget.ae, android.support.v7.widget.RecyclerView.r
            public final void onStop() {
                AppMethodBeat.i(6140);
                super.onStop();
                AppMethodBeat.o(6140);
            }
        };
        hVar.oDR = new ae(hVar.pzW.getContext()) {
            /* class com.tencent.mm.plugin.brandservice.ui.timeline.offenread.h.AnonymousClass2 */

            @Override // android.support.v7.widget.ae
            public final int kz() {
                return -1;
            }

            @Override // android.support.v7.widget.ae
            public final float a(DisplayMetrics displayMetrics) {
                return 40.0f / ((float) displayMetrics.densityDpi);
            }

            @Override // android.support.v7.widget.RecyclerView.r
            public final PointF bZ(int i2) {
                AppMethodBeat.i(6141);
                PointF bZ = ((LinearLayoutManager) h.this.pzW.getLayoutManager()).bZ(i2);
                AppMethodBeat.o(6141);
                return bZ;
            }

            @Override // android.support.v7.widget.ae, android.support.v7.widget.RecyclerView.r
            public final void onStop() {
                AppMethodBeat.i(6142);
                super.onStop();
                Log.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo SmoothScrollerForFling onStop %d", Integer.valueOf(h.this.pzW.getScrollState()));
                if (h.this.pzW.getScrollState() == 0) {
                    h.this.ccZ();
                }
                AppMethodBeat.o(6142);
            }
        };
        setOnScrollPageListener(new h.a() {
            /* class com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotListView.AnonymousClass5 */

            @Override // com.tencent.mm.plugin.brandservice.ui.timeline.offenread.h.a
            public final void Dk(int i2) {
                AppMethodBeat.i(194979);
                int currentPage = BizTimeLineHotListView.this.getCurrentPage();
                Log.d("MicroMsg.BizTimeLineHotListView", "alvinluo ScrollPageListener onScrolled offsetOfCurPage: %d, , currentPage: %d", Integer.valueOf(i2), Integer.valueOf(currentPage));
                BizTimeLineHotListView.a(BizTimeLineHotListView.this, i2, currentPage);
                BizTimeLineHotListView.f(BizTimeLineHotListView.this);
                AppMethodBeat.o(194979);
            }

            @Override // com.tencent.mm.plugin.brandservice.ui.timeline.offenread.h.a
            public final void V(int i2, boolean z) {
                AppMethodBeat.i(194980);
                if (!z) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(15721, "", 0, 10, Integer.valueOf((int) (System.currentTimeMillis() / 1000)), Integer.valueOf(ab.getSessionId()));
                }
                BizTimeLineHotListView.a(BizTimeLineHotListView.this, i2);
                BizTimeLineHotListView.this.cnm();
                AppMethodBeat.o(194980);
            }
        });
        setOnItemClickListener(new MRecyclerView.a() {
            /* class com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotListView.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.a
            public final void S(View view, int i2) {
                AppMethodBeat.i(175429);
                c cVar = (c) BizTimeLineHotListView.this.nZr.get(i2);
                if (cVar == null) {
                    AppMethodBeat.o(175429);
                    return;
                }
                g gVar = BizTimeLineHotListView.this.pyZ;
                if (cVar != null) {
                    if (cVar.type == 1) {
                        cup cup = new cup();
                        cup.KUC = cVar.KJV;
                        cup.xHb = cVar.position - 1;
                        cup.MzR = (int) (System.currentTimeMillis() / 1000);
                        cup.MzQ = cVar.pzL ? 1 : 0;
                        cup.type = 0;
                        gVar.pzT.add(cup);
                    } else if (cVar.type == 3) {
                        cup cup2 = new cup();
                        long currentTimeMillis = System.currentTimeMillis();
                        cup2.xHb = cVar.position - 1;
                        cup2.MzR = (int) (currentTimeMillis / 1000);
                        com.tencent.mm.plugin.brandservice.b.c cVar2 = com.tencent.mm.plugin.brandservice.b.c.pne;
                        cup2.type = com.tencent.mm.plugin.brandservice.b.c.clF() ? 2 : 1;
                        cup2.iwv = com.tencent.mm.plugin.brandservice.b.c.pne.kj(false);
                        cup2.MzT = com.tencent.mm.plugin.brandservice.b.c.pne.clC() ? 1 : 0;
                        com.tencent.mm.plugin.brandservice.b.c cVar3 = com.tencent.mm.plugin.brandservice.b.c.pne;
                        cup2.MzS = com.tencent.mm.plugin.brandservice.b.c.clD();
                        cup2.MzU = com.tencent.mm.plugin.brandservice.b.c.pne.clB() ? 1 : 0;
                        cup2.MzV = currentTimeMillis;
                        Log.d("MicroMsg.BizTimeLineOftenReadReport", "onClick is_default_icon %d, is_icon_cache %d", Integer.valueOf(cup2.MzU), Integer.valueOf(cup2.MzT));
                        gVar.pzT.add(cup2);
                        com.tencent.mm.plugin.brandservice.b.c cVar4 = com.tencent.mm.plugin.brandservice.b.c.pne;
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(21258, 2, Long.valueOf(currentTimeMillis), 0, z.bfG(cup2.iwv), Integer.valueOf(com.tencent.mm.plugin.brandservice.b.c.clF() ? 1 : 0));
                    }
                }
                if (cVar.type == 1) {
                    Intent intent = new Intent();
                    intent.putExtra("Chat_User", cVar.KJV);
                    intent.putExtra("finish_direct", true);
                    intent.putExtra("KOpenArticleSceneFromScene", 91);
                    intent.putExtra("specific_chat_from_scene", 8);
                    intent.putExtra("preChatTYPE", 12);
                    com.tencent.mm.br.c.f(BizTimeLineHotListView.this.mContext, ".ui.chatting.ChattingUI", intent);
                    cVar.pzL = false;
                    BizTimeLineHotListView.this.a(cVar);
                    AppMethodBeat.o(175429);
                    return;
                }
                if (cVar.type == 3) {
                    Log.i("MicroMsg.BizTimeLineHotListView", "alvinluo onClick jump to video channel");
                    if (cVar instanceof e) {
                        BizTimeLineHotListView.a(BizTimeLineHotListView.this, (e) cVar, view);
                    }
                }
                AppMethodBeat.o(175429);
            }
        });
        AppMethodBeat.o(194984);
    }

    private static boolean Dj(int i2) {
        AppMethodBeat.i(194985);
        if (i2 <= 0) {
            AppMethodBeat.o(194985);
            return false;
        }
        int decodeInt = MultiProcessMMKV.getSingleMMKV("MicroMsg.BizTimeLineHotListView").decodeInt("VideoChannelTopBarVersion", 0);
        Log.i("MicroMsg.BizTimeLineHotListView", "getVideoChannelUnReadState, version: %d, lastVersion: %d", Integer.valueOf(i2), Integer.valueOf(decodeInt));
        if (i2 > decodeInt) {
            AppMethodBeat.o(194985);
            return true;
        }
        AppMethodBeat.o(194985);
        return false;
    }

    private void g(RecyclerView.v vVar, int i2) {
        AppMethodBeat.i(6087);
        Log.d("MicroMsg.BizTimeLineHotListView", "alvinluo updateAlpha pos: %d", Integer.valueOf(i2));
        if (vVar != null) {
            float x = vVar.aus.getX();
            if (x >= ((float) (this.mScreenWidth - (getItemWidth() / 2)))) {
                vVar.aus.setAlpha(0.3f);
                AppMethodBeat.o(6087);
                return;
            } else if (x >= ((float) (this.mScreenWidth - (getItemWidth() / 2))) || x < this.oDy) {
                vVar.aus.setAlpha(1.0f);
            } else {
                float f2 = 1.0f - (((x - this.oDy) / ((float) this.oDz)) * 0.7f);
                Log.d("MicroMsg.BizTimeLineHotListView", "alvinluo updateAlpha %f", Float.valueOf(f2));
                vVar.aus.setAlpha(f2);
                AppMethodBeat.o(6087);
                return;
            }
        }
        AppMethodBeat.o(6087);
    }

    @Override // android.support.v7.widget.RecyclerView
    public final boolean ak(int i2, int i3) {
        AppMethodBeat.i(6088);
        h hVar = this.pyW;
        hVar.W(hVar.AE(hVar.mOffsetX + i2), false);
        boolean ak = super.ak(i2, i3);
        AppMethodBeat.o(6088);
        return ak;
    }

    public int getCurrentPage() {
        if (this.pyW != null) {
            return this.pyW.owW;
        }
        return 0;
    }

    public int getItemPadding() {
        AppMethodBeat.i(6089);
        int ew = a.ew(getContext());
        AppMethodBeat.o(6089);
        return ew;
    }

    public void setOnScrollPageListener(h.a aVar) {
        if (this.pyW != null) {
            this.pyW.pzY = aVar;
        }
    }

    public int getDataCount() {
        AppMethodBeat.i(6090);
        int size = this.nZr.size();
        AppMethodBeat.o(6090);
        return size;
    }

    public int getCustomItemCount() {
        return 1;
    }

    /* access modifiers changed from: protected */
    public float getShowCountPerPage() {
        AppMethodBeat.i(6091);
        float showCountPerPage = a.getShowCountPerPage();
        AppMethodBeat.o(6091);
        return showCountPerPage;
    }

    public int getItemWidth() {
        AppMethodBeat.i(6092);
        int ev = a.ev(this.mContext);
        AppMethodBeat.o(6092);
        return ev;
    }

    public int getShowCount() {
        if (this.pyY) {
            return 13;
        }
        return 12;
    }

    private void bX(List<c> list) {
        AppMethodBeat.i(6093);
        if (list == null) {
            AppMethodBeat.o(6093);
            return;
        }
        c cVar = new c(2);
        cVar.KJV = "__BizTimeLine.CustomItem__";
        list.add(0, cVar);
        cE(list);
        AppMethodBeat.o(6093);
    }

    private void cE(List<c> list) {
        AppMethodBeat.i(175433);
        if (list == null) {
            AppMethodBeat.o(175433);
            return;
        }
        if (com.tencent.mm.plugin.brandservice.b.c.clu()) {
            Log.i("MicroMsg.BizTimeLineHotListView", "alvinluo addCustomItems timeline top bar entry is open");
            e eVar = new e();
            eqs clw = com.tencent.mm.plugin.brandservice.b.c.clw();
            if (clw != null) {
                eVar.KJV = "__BizTimeLine.VideoChannelEntry__";
                a(eVar, clw);
                list.add(1, eVar);
                eVar.position = 1;
                this.pyY = true;
            }
        }
        AppMethodBeat.o(175433);
    }

    private static void a(e eVar, eqs eqs) {
        AppMethodBeat.i(194986);
        if (!(eVar == null || eqs == null)) {
            eVar.title = eqs.title;
            eVar.jXM = eqs.Noh;
            eVar.appId = eqs.dNI;
            eVar.iwv = eqs.iwv;
            eVar.pzQ = eqs.Nob;
            eVar.appVersion = eqs.version;
            eVar.pzO = eqs.Noa;
            eVar.pzP = eqs.Noe;
            eVar.pzL = Dj(eqs.Noa);
        }
        AppMethodBeat.o(194986);
    }

    public class a extends RecyclerView.a<b> {
        private Context mContext;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void a(b bVar, int i2) {
            AppMethodBeat.i(6078);
            b bVar2 = bVar;
            if (i2 >= BizTimeLineHotListView.this.nZr.size() || i2 - BizTimeLineHotListView.this.getCustomItemCount() > BizTimeLineHotListView.this.getShowCount()) {
                bVar2.aus.setVisibility(4);
                a(bVar2, (c) null, i2);
                AppMethodBeat.o(6078);
                return;
            }
            bVar2.aus.setVisibility(0);
            c cVar = (c) BizTimeLineHotListView.this.nZr.get(i2);
            if (cVar != null) {
                cVar.position = i2;
                bVar2.aus.setTag(cVar);
            }
            a(bVar2, cVar, i2);
            AppMethodBeat.o(6078);
        }

        public a(Context context) {
            this.mContext = context;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            int i2;
            AppMethodBeat.i(6075);
            if (Util.isNullOrNil(BizTimeLineHotListView.this.nZr)) {
                AppMethodBeat.o(6075);
                return 0;
            }
            int size = BizTimeLineHotListView.this.nZr.size();
            int completelyCountPerPage = a.getCompletelyCountPerPage();
            if (BizTimeLineHotListView.this.getCustomItemCount() == 1) {
                size--;
            }
            if (size > BizTimeLineHotListView.this.getShowCount()) {
                size = BizTimeLineHotListView.this.getShowCount();
            }
            if (BizTimeLineHotListView.this.getCustomItemCount() == 1) {
                if (size % completelyCountPerPage == 0) {
                    i2 = size + 1;
                } else {
                    i2 = size + ((completelyCountPerPage + 1) - (size % completelyCountPerPage));
                }
                int customItemCount = i2 + BizTimeLineHotListView.this.getCustomItemCount();
                AppMethodBeat.o(6075);
                return customItemCount;
            }
            if (size % completelyCountPerPage != 0) {
                size += completelyCountPerPage - (size % completelyCountPerPage);
            }
            AppMethodBeat.o(6075);
            return size;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemViewType(int i2) {
            c cVar;
            AppMethodBeat.i(6076);
            if (i2 >= BizTimeLineHotListView.this.nZr.size() || i2 - BizTimeLineHotListView.this.getCustomItemCount() > BizTimeLineHotListView.this.getShowCount() || (cVar = (c) BizTimeLineHotListView.this.nZr.get(i2)) == null || cVar.type != 3 || !(cVar instanceof e)) {
                AppMethodBeat.o(6076);
                return 0;
            }
            AppMethodBeat.o(6076);
            return 1;
        }

        private void a(b bVar, c cVar, int i2) {
            boolean z;
            AppMethodBeat.i(6077);
            int itemWidth = BizTimeLineHotListView.this.getItemWidth();
            float showCountPerPage = BizTimeLineHotListView.this.getShowCountPerPage();
            if (i2 == BizTimeLineHotListView.this.pyX.getItemCount() - 1) {
                itemWidth = (int) ((1.0d - (Math.ceil((double) showCountPerPage) - ((double) showCountPerPage))) * ((double) itemWidth));
                Log.i("MicroMsg.BizTimeLineHotListView", "alvinluo lastPosition %d set width %d", Integer.valueOf(i2), Integer.valueOf(itemWidth));
            }
            if (cVar != null && cVar.type == 3) {
                itemWidth = a.eN(this.mContext);
            }
            bVar.aus.getLayoutParams().width = itemWidth;
            bVar.aus.setScaleX(1.0f);
            bVar.aus.setScaleY(1.0f);
            Log.d("MicroMsg.BizTimeLineHotListView", "alvinluo onBindCustomViewHolder postion: %d, width: %d", Integer.valueOf(i2), Integer.valueOf(itemWidth));
            if (cVar == null || cVar.type != 1) {
                if (cVar != null && cVar.type == 3 && (cVar instanceof e)) {
                    com.tencent.mm.plugin.brandservice.b.c cVar2 = com.tencent.mm.plugin.brandservice.b.c.pne;
                    if (com.tencent.mm.plugin.brandservice.b.c.clF()) {
                        bVar.oDp.setVisibility(8);
                        bVar.pzj.setVisibility(8);
                        if (bVar.pzm == null) {
                            bVar.pzm = ((ViewStub) bVar.aus.findViewById(R.id.j8j)).inflate();
                            bVar.pvr = (BizTLRecCardCanvasView) bVar.pzm.findViewById(R.id.j3z);
                        }
                        BizTLRecCardCanvasView bizTLRecCardCanvasView = bVar.pvr;
                        bizTLRecCardCanvasView.setVisibility(0);
                        com.tencent.mm.plugin.brandservice.b.c cVar3 = com.tencent.mm.plugin.brandservice.b.c.pne;
                        bizTLRecCardCanvasView.a(0, "__biz_video_channel_canvas_id__", "vc", "");
                        z = false;
                    } else {
                        BizTimeLineHotListView.a(BizTimeLineHotListView.this, bVar, (e) cVar);
                    }
                }
                z = true;
            } else {
                BizTimeLineHotListView.b(bVar);
                a.b.d(bVar.nnL, cVar.KJV);
                bVar.titleTv.setText(aa.getDisplayName(cVar.KJV));
                bVar.titleTv.setTextSize(0, ((float) com.tencent.mm.cb.a.aH(this.mContext, R.dimen.kc)) * com.tencent.mm.cb.a.ji(BizTimeLineHotListView.this.getContext()));
                bVar.titleTv.setTextColor(this.mContext.getResources().getColor(R.color.u_));
                if (cVar.pzL) {
                    bVar.pzk.setVisibility(0);
                } else {
                    bVar.pzk.setVisibility(8);
                }
                bVar.pzl.setVisibility(8);
                bVar.pzp.setVisibility(8);
                bVar.pzo.setVisibility(8);
                bVar.pzn.setVisibility(8);
                z = true;
            }
            BizTimeLineHotListView.a(BizTimeLineHotListView.this, bVar, cVar, i2, z);
            AppMethodBeat.o(6077);
        }

        /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ b a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(6079);
            b bVar = new b(com.tencent.mm.ui.aa.jQ(this.mContext).inflate(R.layout.jw, viewGroup, false));
            AppMethodBeat.o(6079);
            return bVar;
        }
    }

    private static void a(b bVar) {
        AppMethodBeat.i(194987);
        bVar.oDp.setVisibility(0);
        bVar.pzj.setVisibility(0);
        if (bVar.pvr != null) {
            bVar.pvr.setVisibility(8);
        }
        AppMethodBeat.o(194987);
    }

    public class b extends RecyclerView.v {
        public View aus;
        public ImageView nnL;
        public RelativeLayout oDp;
        public ImageView ooB;
        public BizTLRecCardCanvasView pvr;
        public View pzj;
        public ImageView pzk;
        public ImageView pzl;
        public View pzm = null;
        public TextView pzn = null;
        public ImageView pzo = null;
        public ImageView pzp = null;
        public TextView titleTv;

        public b(View view) {
            super(view);
            AppMethodBeat.i(6080);
            this.aus = view;
            view.getLayoutParams().width = BizTimeLineHotListView.this.getResources().getDisplayMetrics().widthPixels / 4;
            this.nnL = (ImageView) view.findViewById(R.id.a7y);
            this.ooB = (ImageView) view.findViewById(R.id.a7z);
            this.oDp = (RelativeLayout) view.findViewById(R.id.a80);
            this.pzj = view.findViewById(R.id.a85);
            this.titleTv = (TextView) view.findViewById(R.id.a84);
            this.pzk = (ImageView) view.findViewById(R.id.a86);
            this.pzl = (ImageView) view.findViewById(R.id.a81);
            this.pzn = (TextView) view.findViewById(R.id.a7x);
            this.pzo = (ImageView) view.findViewById(R.id.a82);
            this.pzp = (ImageView) view.findViewById(R.id.a83);
            AppMethodBeat.o(6080);
        }
    }

    static /* synthetic */ void a(BizTimeLineHotListView bizTimeLineHotListView, e eVar, aq aqVar) {
        AppMethodBeat.i(194988);
        if (!(eVar == null || aqVar == null)) {
            eVar.KJV = "";
            a(eVar, aqVar.dDA.dDC);
            if (bizTimeLineHotListView.pyX != null) {
                bizTimeLineHotListView.pyX.ci(1);
            }
        }
        AppMethodBeat.o(194988);
    }

    static /* synthetic */ void a(BizTimeLineHotListView bizTimeLineHotListView, List list, aq aqVar) {
        AppMethodBeat.i(175434);
        if (!(list == null || aqVar == null)) {
            e eVar = new e();
            eVar.KJV = "";
            a(eVar, aqVar.dDA.dDC);
            list.add(1, eVar);
            bizTimeLineHotListView.pyY = true;
            if (bizTimeLineHotListView.pyX != null) {
                bizTimeLineHotListView.pyX.atj.notifyChanged();
            }
        }
        AppMethodBeat.o(175434);
    }

    static /* synthetic */ void a(BizTimeLineHotListView bizTimeLineHotListView, final e eVar, View view) {
        String str;
        AppMethodBeat.i(194989);
        Log.i("MicroMsg.BizTimeLineHotListView", "jumpVideoChannel, appId: %s, appVersion: %d, funcVersion: %d, dataBuffer: %s", eVar.appId, Integer.valueOf(eVar.appVersion), Integer.valueOf(eVar.pzO), eVar.pzP);
        com.tencent.mm.plugin.brandservice.b.c cVar = com.tencent.mm.plugin.brandservice.b.c.pne;
        if (com.tencent.mm.plugin.brandservice.b.c.clF()) {
            Log.i("MicroMsg.BizTimeLineHotListView", "jumpVideoChannel show canvas now");
            AppMethodBeat.o(194989);
            return;
        }
        if (!Util.isNullOrNil(eVar.appId)) {
            g gVar = new g();
            gVar.appId = eVar.appId;
            gVar.iOo = eVar.appVersion;
            gVar.scene = 1130;
            i iVar = new i();
            iVar.pAa = ab.getSessionId();
            iVar.pzP = eVar.pzP;
            gVar.kHx = iVar;
            com.tencent.mm.plugin.brandservice.b.c cVar2 = com.tencent.mm.plugin.brandservice.b.c.pne;
            if (com.tencent.mm.plugin.brandservice.b.c.clA()) {
                str = null;
            } else {
                eqs clw = com.tencent.mm.plugin.brandservice.b.c.clw();
                str = clw != null ? clw.Non : null;
            }
            if (!Util.isNullOrNil(str)) {
                gVar.kHw = str;
            }
            ((r) com.tencent.mm.kernel.g.af(r.class)).a(MMApplicationContext.getContext(), gVar);
            if (eVar.pzL) {
                eVar.pzL = false;
                MultiProcessMMKV.getSingleMMKV("MicroMsg.BizTimeLineHotListView").encode("VideoChannelTopBarVersion", eVar.pzO);
                bizTimeLineHotListView.a(eVar);
            }
            eVar.pzP = null;
            final b bVar = new b(view);
            if (bVar.nnL != null) {
                com.tencent.mm.plugin.brandservice.b.c cVar3 = com.tencent.mm.plugin.brandservice.b.c.pne;
                if (eVar.iwv != null) {
                    com.tencent.mm.plugin.brandservice.b.c.aTI().encode("biz_video_channel_show_default_icon", 1);
                    eqs clw2 = com.tencent.mm.plugin.brandservice.b.c.clw();
                    if (clw2 != null) {
                        String str2 = clw2.Noe;
                        if (!(str2 == null || n.aL(str2))) {
                            clw2.Noe = null;
                            com.tencent.mm.plugin.brandservice.b.c cVar4 = com.tencent.mm.plugin.brandservice.b.c.pne;
                            com.tencent.mm.plugin.brandservice.b.c.a(clw2);
                        }
                    }
                }
                com.tencent.mm.plugin.brandservice.b.c cVar5 = com.tencent.mm.plugin.brandservice.b.c.pne;
                if (com.tencent.mm.plugin.brandservice.b.c.clz()) {
                    com.tencent.f.h.RTc.n(new Runnable() {
                        /* class com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotListView.AnonymousClass4 */

                        public final void run() {
                            AppMethodBeat.i(194978);
                            BizTimeLineHotListView.a(BizTimeLineHotListView.this, bVar, eVar);
                            AppMethodBeat.o(194978);
                        }
                    }, 1000);
                }
            }
        }
        AppMethodBeat.o(194989);
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x0177  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotListView r13, com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotListView.b r14, com.tencent.mm.plugin.brandservice.ui.timeline.offenread.e r15) {
        /*
        // Method dump skipped, instructions count: 619
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotListView.a(com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotListView, com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotListView$b, com.tencent.mm.plugin.brandservice.ui.timeline.offenread.e):void");
    }

    static /* synthetic */ void a(BizTimeLineHotListView bizTimeLineHotListView, int i2, int i3) {
        AppMethodBeat.i(194991);
        if (!bizTimeLineHotListView.pyY || bizTimeLineHotListView.pza == null) {
            if (bizTimeLineHotListView.pza != null) {
                bizTimeLineHotListView.pza.setOftenReadTitlePaddingLeft((float) pze);
                bizTimeLineHotListView.pza.cnn();
            }
        } else if ((i3 == 0 || (i3 == 1 && i2 < 0)) && bizTimeLineHotListView.pyY) {
            if (((float) i2) > bizTimeLineHotListView.pzd) {
                bizTimeLineHotListView.pzd = (float) i2;
            }
            float f2 = bizTimeLineHotListView.pzb - (i2 >= 0 ? (float) i2 : ((float) i2) + bizTimeLineHotListView.pzd);
            if (f2 >= ((float) pze)) {
                bizTimeLineHotListView.pza.setOftenReadTitlePaddingLeft(f2);
            } else {
                bizTimeLineHotListView.pza.setOftenReadTitlePaddingLeft((float) pze);
            }
            if (((float) i2) > bizTimeLineHotListView.pzc || (i2 < 0 && ((float) i2) + bizTimeLineHotListView.pzd > bizTimeLineHotListView.pzc)) {
                bizTimeLineHotListView.pza.setVideoTitlePaddingLeft((((float) pze) - (i2 >= 0 ? (float) i2 : ((float) i2) + bizTimeLineHotListView.pzd)) + bizTimeLineHotListView.pzc);
                AppMethodBeat.o(194991);
                return;
            }
            bizTimeLineHotListView.pza.setVideoTitlePaddingLeft((float) pze);
            AppMethodBeat.o(194991);
            return;
        }
        AppMethodBeat.o(194991);
    }

    static /* synthetic */ void f(BizTimeLineHotListView bizTimeLineHotListView) {
        AppMethodBeat.i(194992);
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) bizTimeLineHotListView.getLayoutManager();
        if (linearLayoutManager != null) {
            bizTimeLineHotListView.mScreenWidth = bizTimeLineHotListView.getResources().getDisplayMetrics().widthPixels;
            bizTimeLineHotListView.oDz = bizTimeLineHotListView.getItemPadding() + com.tencent.mm.cb.a.fromDPToPix(bizTimeLineHotListView.getContext(), 50);
            bizTimeLineHotListView.oDy = (float) ((bizTimeLineHotListView.mScreenWidth - (bizTimeLineHotListView.getItemWidth() / 2)) - bizTimeLineHotListView.oDz);
            int ku = linearLayoutManager.ku();
            int kv = linearLayoutManager.kv();
            Log.d("MicroMsg.BizTimeLineHotListView", "alvinluo onScroll mAlphaChangeOffset: %s, ALPHA_DISTANCE: %d", Float.valueOf(bizTimeLineHotListView.oDy), Integer.valueOf(bizTimeLineHotListView.oDz));
            RecyclerView.v ch = bizTimeLineHotListView.ch(ku);
            RecyclerView.v ch2 = bizTimeLineHotListView.ch(kv);
            bizTimeLineHotListView.g(ch, ku);
            bizTimeLineHotListView.g(ch2, kv);
        }
        AppMethodBeat.o(194992);
    }

    static /* synthetic */ void a(BizTimeLineHotListView bizTimeLineHotListView, int i2) {
        AppMethodBeat.i(194993);
        if (!bizTimeLineHotListView.pyY || bizTimeLineHotListView.pza == null) {
            if (bizTimeLineHotListView.pza != null) {
                bizTimeLineHotListView.pza.setOftenReadTitlePaddingLeft((float) pze);
                bizTimeLineHotListView.pza.cnn();
            }
            AppMethodBeat.o(194993);
        } else if (i2 == 0) {
            bizTimeLineHotListView.pza.setOftenReadTitlePaddingLeft(bizTimeLineHotListView.pzb);
            bizTimeLineHotListView.pza.setVideoTitlePaddingLeft((float) pze);
            AppMethodBeat.o(194993);
        } else {
            bizTimeLineHotListView.pza.setOftenReadTitlePaddingLeft((float) pze);
            AppMethodBeat.o(194993);
        }
    }

    static /* synthetic */ void a(BizTimeLineHotListView bizTimeLineHotListView, final b bVar, c cVar, final int i2, boolean z) {
        AppMethodBeat.i(194995);
        if (cVar == null || bVar == null || bVar.aus == null) {
            AppMethodBeat.o(194995);
            return;
        }
        if (cVar.type == 2) {
            bVar.aus.setVisibility(4);
            bVar.aus.getLayoutParams().width = 0;
        }
        if (z) {
            int eO = a.eO(bizTimeLineHotListView.getContext());
            bVar.oDp.getLayoutParams().width = -1;
            bVar.oDp.getLayoutParams().height = (com.tencent.mm.cb.a.aH(bizTimeLineHotListView.getContext(), R.dimen.k5) * 2) + eO;
            bVar.nnL.getLayoutParams().width = eO;
            bVar.nnL.getLayoutParams().height = eO;
            bVar.ooB.getLayoutParams().width = eO;
            bVar.ooB.getLayoutParams().height = eO;
        }
        int currentPage = bizTimeLineHotListView.getCurrentPage();
        int AH = h.AH(currentPage);
        int Dl = h.Dl(currentPage);
        Log.i("MicroMsg.BizTimeLineHotListView", "alvinluo configView curPage: %d, firstPositionOfCurPage: %d, lastPositionOfCurPage: %d, position: %d", Integer.valueOf(currentPage), Integer.valueOf(AH), Integer.valueOf(Dl), Integer.valueOf(i2));
        if (i2 == 2 || i2 == 1) {
            if (bizTimeLineHotListView.pyY && bizTimeLineHotListView.pza != null) {
                bVar.aus.post(new Runnable() {
                    /* class com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotListView.AnonymousClass6 */

                    public final void run() {
                        AppMethodBeat.i(194981);
                        if (i2 == 2) {
                            float x = bVar.aus.getX();
                            if (x > 0.0f && BizTimeLineHotListView.this.pzb != x) {
                                BizTimeLineHotListView.this.pzb = x;
                                Log.d("MicroMsg.BizTimeLineHotListView", "updateTitlePos originalPaddingLeft=%s", Float.valueOf(BizTimeLineHotListView.this.pzb));
                                BizTimeLineHotListView.this.pza.setOftenReadTitlePaddingLeft(BizTimeLineHotListView.this.pzb);
                                BizTimeLineHotListView.this.pza.setVideoTitlePaddingLeft((float) BizTimeLineHotListView.pze);
                            }
                            AppMethodBeat.o(194981);
                            return;
                        }
                        if (i2 == 1) {
                            float x2 = bVar.aus.getX();
                            int width = bVar.aus.getWidth();
                            if (width > 0 && x2 >= 0.0f) {
                                BizTimeLineHotListView.this.pzc = ((x2 + ((float) width)) / 2.0f) - ((float) BizTimeLineHotListView.pze);
                                Log.d("MicroMsg.BizTimeLineHotListView", "updateTitlePos originalVideoIconMiddle=%s", Float.valueOf(BizTimeLineHotListView.this.pzc));
                            }
                        }
                        AppMethodBeat.o(194981);
                    }
                });
            } else if (bizTimeLineHotListView.pza != null) {
                bizTimeLineHotListView.pza.setOftenReadTitlePaddingLeft((float) pze);
                bizTimeLineHotListView.pza.cnn();
            }
        }
        if (i2 == Dl) {
            bVar.aus.setVisibility(0);
            bVar.aus.setAlpha(0.3f);
            AppMethodBeat.o(194995);
            return;
        }
        bVar.aus.setVisibility(0);
        bVar.aus.setAlpha(1.0f);
        AppMethodBeat.o(194995);
    }
}
