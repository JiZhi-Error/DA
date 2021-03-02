package com.tencent.mm.plugin.appbrand.widget.recent;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.appbrand.appusage.ah;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.appbrand.widget.recent.AppBrandRecentView;
import com.tencent.mm.plugin.appbrand.widget.recent.BaseAppBrandRecentView;
import com.tencent.mm.plugin.appbrand.widget.recent.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.ui.base.o;
import java.util.List;

public class ConversationAppBrandRecentView extends BaseAppBrandRecentView {
    private static final int oDx = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 200);
    private int mScreenWidth = 0;
    private a oDA = null;
    private View.OnCreateContextMenuListener oDB = null;
    private AppBrandRecentView.a oDC = null;
    private boolean oDD = false;
    private AppBrandRecentView.b oDv;
    private p.a oDw;
    private float oDy = 0.0f;
    private int oDz = 0;

    public interface a {
    }

    static {
        AppMethodBeat.i(227830);
        AppMethodBeat.o(227830);
    }

    public void setOnBindCustomViewHolderListener(a aVar) {
        this.oDA = aVar;
    }

    public ConversationAppBrandRecentView(Context context) {
        super(context);
    }

    public ConversationAppBrandRecentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.recent.BaseAppBrandRecentView
    public int getLayoutId() {
        return R.layout.gx;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.recent.BaseAppBrandRecentView
    public final void a(BaseAppBrandRecentView.b bVar, e eVar, int i2) {
        AppMethodBeat.i(227814);
        super.a(bVar, eVar, i2);
        if (eVar != null && eVar.type == 0) {
            bVar.titleTv.setVisibility(4);
            bVar.nnL.setImageResource(R.raw.multitask_bar_more_btn);
        }
        if (d.cak()) {
            if (eVar == null || bVar == null || bVar.aus == null) {
                AppMethodBeat.o(227814);
                return;
            }
            if (eVar.type == 3) {
                bVar.aus.setVisibility(4);
                bVar.aus.getLayoutParams().width = 0;
            }
            int ey = (int) f.ey(getContext());
            bVar.oDp.getLayoutParams().width = (com.tencent.mm.cb.a.aH(getContext(), R.dimen.k5) * 2) + ey;
            bVar.oDp.getLayoutParams().height = (com.tencent.mm.cb.a.aH(getContext(), R.dimen.k5) * 2) + ey;
            bVar.nnL.getLayoutParams().width = ey;
            bVar.nnL.getLayoutParams().height = ey;
            bVar.ooB.getLayoutParams().width = ey;
            bVar.ooB.getLayoutParams().height = ey;
            int currentPage = getCurrentPage();
            int AH = p.AH(currentPage);
            d.ccS();
            int completelyCountPerPage = ((currentPage + 1) * d.getCompletelyCountPerPage()) + 1;
            Log.i("MicroMsg.ConversationAppBrandRecentView", "alvinluo configView curPage: %d, firstPositionOfCurPage: %d, lastPositionOfCurPage: %d, position: %d", Integer.valueOf(currentPage), Integer.valueOf(AH), Integer.valueOf(completelyCountPerPage), Integer.valueOf(i2));
            if (i2 == completelyCountPerPage) {
                bVar.aus.animate().alpha(0.3f).setDuration(1).start();
                AppMethodBeat.o(227814);
                return;
            } else if (eVar.oBV) {
                bVar.aus.setVisibility(4);
                AppMethodBeat.o(227814);
                return;
            } else {
                bVar.aus.setVisibility(0);
                bVar.aus.setAlpha(1.0f);
            }
        }
        AppMethodBeat.o(227814);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.widget.recent.BaseAppBrandRecentView
    public float getShowCountPerPage() {
        AppMethodBeat.i(227815);
        float showCountPerPage = d.getShowCountPerPage();
        AppMethodBeat.o(227815);
        return showCountPerPage;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.widget.recent.BaseAppBrandRecentView
    public int getCompletelyCountPerPage() {
        AppMethodBeat.i(227816);
        int completelyCountPerPage = d.getCompletelyCountPerPage();
        AppMethodBeat.o(227816);
        return completelyCountPerPage;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.widget.recent.BaseAppBrandRecentView
    public int getLoadCount() {
        AppMethodBeat.i(227817);
        if (this.oDe == AppBrandRecentView.f.RECENT_APP_BRAND) {
            AppMethodBeat.o(227817);
            return 50;
        } else if (this.oDe == AppBrandRecentView.f.MY_APP_BRAND) {
            int byo = d.byo();
            AppMethodBeat.o(227817);
            return byo;
        } else {
            AppMethodBeat.o(227817);
            return 50;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.widget.recent.BaseAppBrandRecentView
    public int getShowCount() {
        AppMethodBeat.i(227818);
        if (this.oDe == AppBrandRecentView.f.RECENT_APP_BRAND) {
            int i2 = d.omI;
            AppMethodBeat.o(227818);
            return i2;
        } else if (this.oDe == AppBrandRecentView.f.MY_APP_BRAND) {
            int byo = d.byo();
            AppMethodBeat.o(227818);
            return byo;
        } else {
            AppMethodBeat.o(227818);
            return 50;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.widget.recent.BaseAppBrandRecentView
    public String getType() {
        AppMethodBeat.i(227819);
        String simpleName = ConversationAppBrandRecentView.class.getSimpleName();
        AppMethodBeat.o(227819);
        return simpleName;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.recent.BaseAppBrandRecentView
    public final void bX(List<e> list) {
        AppMethodBeat.i(227820);
        if (!d.cak()) {
            list.add(new e(0));
        }
        if (d.cak()) {
            d.ccS();
            list.add(0, new e(3));
        }
        AppMethodBeat.o(227820);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.recent.BaseAppBrandRecentView
    public int getCustomItemCount() {
        AppMethodBeat.i(227821);
        if (!d.cak()) {
            AppMethodBeat.o(227821);
            return 1;
        } else if (d.cak()) {
            d.ccS();
            AppMethodBeat.o(227821);
            return 1;
        } else {
            AppMethodBeat.o(227821);
            return 0;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.recent.AppBrandRecentView, com.tencent.mm.plugin.appbrand.widget.recent.BaseAppBrandRecentView
    public void setOnItemClickListener(AppBrandRecentView.b bVar) {
        this.oDv = bVar;
    }

    public void setCreateContextMenuListener(View.OnCreateContextMenuListener onCreateContextMenuListener) {
        this.oDB = onCreateContextMenuListener;
    }

    public void setMenuItemSelectedListener(AppBrandRecentView.a aVar) {
        this.oDC = aVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.widget.recent.BaseAppBrandRecentView
    public final void init(Context context) {
        AppMethodBeat.i(227822);
        super.init(context);
        this.mScreenWidth = getResources().getDisplayMetrics().widthPixels;
        super.setOnItemClickListener(new AppBrandRecentView.b() {
            /* class com.tencent.mm.plugin.appbrand.widget.recent.ConversationAppBrandRecentView.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.widget.recent.AppBrandRecentView.b
            public final boolean a(View view, e eVar, float f2, float f3) {
                AppMethodBeat.i(227808);
                if (ConversationAppBrandRecentView.this.oDv != null) {
                    ConversationAppBrandRecentView.this.oDv.a(view, eVar, f2, f3);
                }
                if (eVar.type == 0) {
                    ((t) g.af(t.class)).K(ConversationAppBrandRecentView.this.getContext(), 13);
                } else {
                    ConversationAppBrandRecentView.this.setLayoutFrozen(true);
                    AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                    appBrandStatObject.scene = ConversationAppBrandRecentView.this.oDe == AppBrandRecentView.f.MY_APP_BRAND ? 1104 : 1089;
                    ((r) g.af(r.class)).a(ConversationAppBrandRecentView.this.getContext(), eVar.ooj.username, (String) null, eVar.ooj.iOo, -1, (String) null, appBrandStatObject);
                }
                AppMethodBeat.o(227808);
                return false;
            }

            @Override // com.tencent.mm.plugin.appbrand.widget.recent.AppBrandRecentView.b
            public final boolean b(View view, final e eVar, float f2, float f3) {
                AppMethodBeat.i(227809);
                if (ConversationAppBrandRecentView.this.oDv != null) {
                    ConversationAppBrandRecentView.this.oDv.b(view, eVar, f2, f3);
                }
                Log.i("MicroMsg.ConversationAppBrandRecentView", "[onItemLongClick] x:%s", Float.valueOf(f2));
                if (eVar.type != 0) {
                    new com.tencent.mm.ui.widget.b.a(ConversationAppBrandRecentView.this.getContext()).a(view, new View.OnCreateContextMenuListener() {
                        /* class com.tencent.mm.plugin.appbrand.widget.recent.ConversationAppBrandRecentView.AnonymousClass1.AnonymousClass1 */

                        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                            AppMethodBeat.i(227806);
                            if (ConversationAppBrandRecentView.this.oDB != null) {
                                ConversationAppBrandRecentView.this.oDB.onCreateContextMenu(contextMenu, view, contextMenuInfo);
                            }
                            contextMenu.add(0, 1, contextMenu.size() + 1, ConversationAppBrandRecentView.this.getContext().getResources().getString(R.string.blc));
                            AppMethodBeat.o(227806);
                        }
                    }, new o.g() {
                        /* class com.tencent.mm.plugin.appbrand.widget.recent.ConversationAppBrandRecentView.AnonymousClass1.AnonymousClass2 */

                        @Override // com.tencent.mm.ui.base.o.g
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                            AppMethodBeat.i(227807);
                            if (ConversationAppBrandRecentView.this.oDC != null) {
                                AppBrandRecentView.a unused = ConversationAppBrandRecentView.this.oDC;
                            }
                            if (menuItem.getItemId() == 1 && eVar.position >= 0) {
                                ConversationAppBrandRecentView.this.oDD = true;
                                Log.i("MicroMsg.ConversationAppBrandRecentView", "[onItemLongClick] Delete position:%s, mType: %s", Integer.valueOf(eVar.position), ConversationAppBrandRecentView.this.oDe);
                                if (ConversationAppBrandRecentView.this.oDe == AppBrandRecentView.f.RECENT_APP_BRAND) {
                                    ((ah) g.af(ah.class)).bi(eVar.ooj.username, eVar.ooj.iOo);
                                } else if (ConversationAppBrandRecentView.this.oDe == AppBrandRecentView.f.MY_APP_BRAND) {
                                    ((ag) g.af(ag.class)).bh(eVar.ooj.username, eVar.ooj.iOo);
                                }
                                Log.i("MicroMsg.ConversationAppBrandRecentView", "alvinluo Delete %s, pos: %d", eVar.ooj.nickname, Integer.valueOf(eVar.position));
                                ConversationAppBrandRecentView.this.AD(eVar.position);
                            }
                            AppMethodBeat.o(227807);
                        }
                    }, (int) f2, (int) f3);
                }
                AppMethodBeat.o(227809);
                return false;
            }
        });
        if (d.cak()) {
            super.setOnScrollPageListener(new p.a() {
                /* class com.tencent.mm.plugin.appbrand.widget.recent.ConversationAppBrandRecentView.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.appbrand.widget.recent.p.a
                public final void c(RecyclerView recyclerView, int i2) {
                    AppMethodBeat.i(227810);
                    Log.i("MicroMsg.ConversationAppBrandRecentView", "alvinluo ScrollPageListener onScrolled offsetOfCurPage: %d, , currentPage: %d", Integer.valueOf(i2), Integer.valueOf(ConversationAppBrandRecentView.this.getCurrentPage()));
                    ConversationAppBrandRecentView.e(ConversationAppBrandRecentView.this);
                    if (ConversationAppBrandRecentView.this.oDw != null) {
                        ConversationAppBrandRecentView.this.oDw.c(recyclerView, i2);
                    }
                    AppMethodBeat.o(227810);
                }

                @Override // com.tencent.mm.plugin.appbrand.widget.recent.p.a
                public final void V(int i2, boolean z) {
                    AppMethodBeat.i(227811);
                    if (ConversationAppBrandRecentView.this.oDw != null) {
                        ConversationAppBrandRecentView.this.oDw.V(i2, z);
                    }
                    AppMethodBeat.o(227811);
                }

                @Override // com.tencent.mm.plugin.appbrand.widget.recent.p.a
                public final void c(RecyclerView recyclerView, int i2, int i3) {
                    AppMethodBeat.i(227812);
                    if (ConversationAppBrandRecentView.this.oDw != null) {
                        ConversationAppBrandRecentView.this.oDw.c(recyclerView, i2, i3);
                    }
                    AppMethodBeat.o(227812);
                }
            });
        }
        AppMethodBeat.o(227822);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.recent.BaseAppBrandRecentView
    public void setOnScrollPageListener(p.a aVar) {
        this.oDw = aVar;
    }

    private void g(RecyclerView.v vVar, int i2) {
        AppMethodBeat.i(227823);
        Log.d("MicroMsg.ConversationAppBrandRecentView", "alvinluo updateAlpha pos: %d", Integer.valueOf(i2));
        if (vVar != null) {
            float x = vVar.aus.getX();
            if (x >= ((float) (this.mScreenWidth - (getItemWidth() / 2)))) {
                vVar.aus.setAlpha(0.3f);
                AppMethodBeat.o(227823);
                return;
            } else if (x >= ((float) (this.mScreenWidth - (getItemWidth() / 2))) || x < this.oDy) {
                vVar.aus.setAlpha(1.0f);
            } else {
                float f2 = 1.0f - (((x - this.oDy) / ((float) this.oDz)) * 0.7f);
                Log.d("MicroMsg.ConversationAppBrandRecentView", "alvinluo updateAlpha %f", Float.valueOf(f2));
                vVar.aus.setAlpha(f2);
                AppMethodBeat.o(227823);
                return;
            }
        }
        AppMethodBeat.o(227823);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.widget.recent.BaseAppBrandRecentView
    public final void AD(int i2) {
        AppMethodBeat.i(227824);
        super.AD(i2);
        getPreviewItemList().remove(i2);
        getAdapter().ck(i2);
        getAdapter().aq(i2, 5);
        if (this.oDe == AppBrandRecentView.f.RECENT_APP_BRAND) {
            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.widget.recent.ConversationAppBrandRecentView.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(227813);
                    ConversationAppBrandRecentView conversationAppBrandRecentView = ConversationAppBrandRecentView.this;
                    if (conversationAppBrandRecentView.oDd) {
                        int size = conversationAppBrandRecentView.oCZ.size();
                        if (size - 1 < conversationAppBrandRecentView.opg.size() && conversationAppBrandRecentView.opg.get(size - 1) != null) {
                            Log.i("MicroMsg.BaseAppBrandRecentView", "alvinluo addCacheItemAtLast pos: %d", Integer.valueOf(size));
                            conversationAppBrandRecentView.oCZ.add(size, conversationAppBrandRecentView.opg.get(size - 1));
                            conversationAppBrandRecentView.getAdapter().cj(size);
                            conversationAppBrandRecentView.getAdapter().aq(size, 5);
                        }
                    }
                    if (ConversationAppBrandRecentView.this.getOnDataChangedListener() != null) {
                        ConversationAppBrandRecentView.this.getOnDataChangedListener();
                        ConversationAppBrandRecentView.this.getPreviewItemList().size();
                    }
                    AppMethodBeat.o(227813);
                }
            }, 200);
            AppMethodBeat.o(227824);
            return;
        }
        if (getOnDataChangedListener() != null) {
            getOnDataChangedListener();
            getPreviewItemList().size();
        }
        AppMethodBeat.o(227824);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.widget.recent.BaseAppBrandRecentView
    public final boolean ccX() {
        boolean z = this.oDD;
        this.oDD = false;
        return z;
    }

    public void setIgnoreNotify(boolean z) {
        this.oDD = z;
    }

    @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange, com.tencent.mm.plugin.appbrand.widget.recent.BaseAppBrandRecentView
    public void onNotifyChange(String str, MStorageEventData mStorageEventData) {
        AppMethodBeat.i(227825);
        Log.i("MicroMsg.ConversationAppBrandRecentView", "[onNotifyChange] process:%s eventId:%s, mType: %s", g.aAe().azG().toString(), Integer.valueOf(mStorageEventData.eventId), this.oDe);
        if (ccX()) {
            AppMethodBeat.o(227825);
            return;
        }
        refresh();
        AppMethodBeat.o(227825);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.recent.BaseAppBrandRecentView
    public int getItemWidth() {
        AppMethodBeat.i(227826);
        int ev = f.ev(getContext());
        AppMethodBeat.o(227826);
        return ev;
    }

    private int getItemPadding() {
        AppMethodBeat.i(227827);
        int ew = f.ew(getContext());
        AppMethodBeat.o(227827);
        return ew;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.recent.BaseAppBrandRecentView
    public List<e> getPreviewItemList() {
        AppMethodBeat.i(227828);
        List<e> previewItemList = super.getPreviewItemList();
        AppMethodBeat.o(227828);
        return previewItemList;
    }

    static /* synthetic */ void e(ConversationAppBrandRecentView conversationAppBrandRecentView) {
        AppMethodBeat.i(227829);
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) conversationAppBrandRecentView.getLayoutManager();
        if (linearLayoutManager != null) {
            conversationAppBrandRecentView.mScreenWidth = conversationAppBrandRecentView.getResources().getDisplayMetrics().widthPixels;
            conversationAppBrandRecentView.oDz = conversationAppBrandRecentView.getItemPadding() + com.tencent.mm.cb.a.fromDPToPix(conversationAppBrandRecentView.getContext(), 50);
            conversationAppBrandRecentView.oDy = (float) ((conversationAppBrandRecentView.mScreenWidth - (conversationAppBrandRecentView.getItemWidth() / 2)) - conversationAppBrandRecentView.oDz);
            int ku = linearLayoutManager.ku();
            int kv = linearLayoutManager.kv();
            Log.d("MicroMsg.ConversationAppBrandRecentView", "alvinluo onScroll mAlphaChangeOffset: %s, ALPHA_DISTANCE: %d", Float.valueOf(conversationAppBrandRecentView.oDy), Integer.valueOf(conversationAppBrandRecentView.oDz));
            RecyclerView.v ch = conversationAppBrandRecentView.ch(ku);
            RecyclerView.v ch2 = conversationAppBrandRecentView.ch(kv);
            conversationAppBrandRecentView.g(ch, ku);
            conversationAppBrandRecentView.g(ch2, kv);
        }
        AppMethodBeat.o(227829);
    }
}
