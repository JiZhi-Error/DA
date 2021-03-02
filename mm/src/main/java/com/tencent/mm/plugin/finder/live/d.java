package com.tencent.mm.plugin.finder.live;

import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.m;
import com.tencent.mm.plugin.finder.live.c;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.viewmodel.f;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 !2\u00020\u0001:\u0001!B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\bH\u0016J\b\u0010\u0015\u001a\u00020\bH\u0016J\b\u0010\u0016\u001a\u00020\bH\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0018H\u0016J\u001a\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u000bH\u0016R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/finder/live/FinderLivePresenter;", "Lcom/tencent/mm/plugin/finder/live/FinderLiveContract$Presenter;", "()V", "data", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveDataModel;", "getData", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveDataModel;", "hasPreload", "", "livePreload", "Lcom/tencent/mm/plugin/finder/feed/model/internal/Preload;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveData;", "loader", "Lcom/tencent/mm/plugin/finder/live/FinderLiveRelatedLoader;", "getLoader", "()Lcom/tencent/mm/plugin/finder/live/FinderLiveRelatedLoader;", "setLoader", "(Lcom/tencent/mm/plugin/finder/live/FinderLiveRelatedLoader;)V", "viewcall", "Lcom/tencent/mm/plugin/finder/live/FinderLiveViewCallback;", "canLoadMore", "flingUpType", "isEnableNestedScroll", "loadMoreData", "", "onAttach", "callback", "Lcom/tencent/mm/plugin/finder/live/FinderLiveContract$ViewCallback;", "onDetach", "preloadData", "newPos", "", "liveData", "Companion", "plugin-finder_release"})
public final class d implements c.a {
    private static final String TAG = TAG;
    public static final b ufv = new b((byte) 0);
    private FinderLiveViewCallback ufr;
    private final m<com.tencent.mm.plugin.finder.live.viewmodel.c> ufs = new m<>((byte) 0);
    private boolean uft;
    private FinderLiveRelatedLoader ufu;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveData;", "invoke", "com/tencent/mm/plugin/finder/live/FinderLivePresenter$loader$1$1"})
    static final class a extends q implements kotlin.g.a.b<IResponse<com.tencent.mm.plugin.finder.live.viewmodel.c>, x> {
        final /* synthetic */ d ufw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(d dVar) {
            super(1);
            this.ufw = dVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(IResponse<com.tencent.mm.plugin.finder.live.viewmodel.c> iResponse) {
            int i2;
            ArrayList<com.tencent.mm.plugin.finder.live.viewmodel.c> arrayList;
            f fVar;
            com.tencent.mm.bw.b bVar;
            List<com.tencent.mm.plugin.finder.live.viewmodel.c> incrementList;
            ArrayList<com.tencent.mm.plugin.finder.live.viewmodel.c> arrayList2;
            int i3 = 0;
            List<com.tencent.mm.plugin.finder.live.viewmodel.c> list = null;
            ArrayList<com.tencent.mm.plugin.finder.live.viewmodel.c> arrayList3 = null;
            AppMethodBeat.i(245795);
            IResponse<com.tencent.mm.plugin.finder.live.viewmodel.c> iResponse2 = iResponse;
            b bVar2 = d.ufv;
            String str = d.TAG;
            StringBuilder sb = new StringBuilder("load more data finish,cur data size:");
            com.tencent.mm.plugin.finder.live.viewmodel.d deN = d.deN();
            Log.i(str, sb.append((deN == null || (arrayList2 = deN.uCu) == null) ? null : Integer.valueOf(arrayList2.size())).append(",load data size:").append((iResponse2 == null || (incrementList = iResponse2.getIncrementList()) == null) ? null : Integer.valueOf(incrementList.size())).append('!').toString());
            com.tencent.mm.plugin.finder.live.viewmodel.d deN2 = d.deN();
            if (!(deN2 == null || (fVar = deN2.ufx) == null)) {
                if (iResponse2 != null) {
                    bVar = iResponse2.getLastBuffer();
                } else {
                    bVar = null;
                }
                fVar.tsO = bVar;
            }
            if (iResponse2 == null || iResponse2.getPullType() != 3) {
                FinderLiveViewCallback finderLiveViewCallback = this.ufw.ufr;
                if (finderLiveViewCallback != null) {
                    int pullType = iResponse2 != null ? iResponse2.getPullType() : 1000;
                    com.tencent.mm.plugin.finder.live.viewmodel.d deN3 = d.deN();
                    com.tencent.mm.plugin.finder.live.viewmodel.d deN4 = d.deN();
                    if (deN4 != null) {
                        if (iResponse2 != null) {
                            list = iResponse2.getIncrementList();
                        }
                        i3 = deN4.ee(list);
                    }
                    finderLiveViewCallback.a(pullType, deN3, i3);
                }
            } else {
                FinderLiveViewCallback finderLiveViewCallback2 = this.ufw.ufr;
                if (finderLiveViewCallback2 != null) {
                    int pullType2 = iResponse2.getPullType();
                    com.tencent.mm.plugin.finder.live.viewmodel.d deN5 = d.deN();
                    com.tencent.mm.plugin.finder.live.viewmodel.d deN6 = d.deN();
                    if (deN6 != null) {
                        i2 = deN6.ee(iResponse2.getIncrementList());
                    } else {
                        i2 = 0;
                    }
                    Log.i(FinderLiveViewCallback.TAG, "onPreloadResult pullType:" + pullType2 + " increment size:" + i2 + ",init position:" + (deN5 != null ? Integer.valueOf(deN5.getInitPos()) : null));
                    if (pullType2 == 3) {
                        finderLiveViewCallback2.deP();
                        if (deN5 != null) {
                            arrayList3 = deN5.uCu;
                        }
                        boolean deQ = finderLiveViewCallback2.deQ();
                        if (arrayList3 == null || deQ) {
                            Log.i(FinderLiveViewCallback.TAG, "onPreloadResult dataList is null:" + (arrayList3 == null) + ",isFinish:" + deQ);
                        } else {
                            RecyclerView.a adapter = finderLiveViewCallback2.ufA.getAdapter();
                            if (adapter != null) {
                                adapter.aq(1, arrayList3.size());
                            }
                        }
                        if (!(deN5 == null || (arrayList = deN5.uCu) == null)) {
                            i3 = arrayList.size();
                        }
                        finderLiveViewCallback2.IY(i3);
                    }
                }
                this.ufw.ufs.clearCache();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(245795);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/FinderLivePresenter$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    public d() {
        AppMethodBeat.i(245805);
        FinderLiveRelatedLoader finderLiveRelatedLoader = new FinderLiveRelatedLoader();
        o oVar = o.ujN;
        com.tencent.mm.plugin.finder.live.viewmodel.d dfY = o.dfY();
        f fVar = (dfY == null || (fVar = dfY.ufx) == null) ? new f() : fVar;
        p.h(fVar, "<set-?>");
        finderLiveRelatedLoader.ufx = fVar;
        finderLiveRelatedLoader.fetchEndCallback = new a(this);
        this.ufu = finderLiveRelatedLoader;
        AppMethodBeat.o(245805);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.mm.plugin.finder.presenter.base.a
    public final /* synthetic */ void onAttach(c.b bVar) {
        AppMethodBeat.i(245803);
        a(bVar);
        AppMethodBeat.o(245803);
    }

    static {
        AppMethodBeat.i(245806);
        AppMethodBeat.o(245806);
    }

    public static com.tencent.mm.plugin.finder.live.viewmodel.d deN() {
        AppMethodBeat.i(245796);
        o oVar = o.ujN;
        com.tencent.mm.plugin.finder.live.viewmodel.d dfY = o.dfY();
        AppMethodBeat.o(245796);
        return dfY;
    }

    @Override // com.tencent.mm.plugin.finder.live.c.a
    public final void boE() {
        String str;
        String str2;
        f fVar;
        long j2;
        AppMethodBeat.i(245797);
        o oVar = o.ujN;
        g dfZ = o.dfZ();
        Long valueOf = dfZ != null ? Long.valueOf(dfZ.hFK) : null;
        o oVar2 = o.ujN;
        g dfZ2 = o.dfZ();
        if (dfZ2 != null) {
            str = dfZ2.hwg;
        } else {
            str = null;
        }
        o oVar3 = o.ujN;
        g dfZ3 = o.dfZ();
        if (dfZ3 != null) {
            str2 = dfZ3.sessionBuffer;
        } else {
            str2 = null;
        }
        o oVar4 = o.ujN;
        com.tencent.mm.plugin.finder.live.viewmodel.d dfY = o.dfY();
        if (dfY != null) {
            fVar = dfY.ufx;
        } else {
            fVar = null;
        }
        if (fVar != null) {
            if (valueOf != null) {
                j2 = valueOf.longValue();
            } else {
                j2 = 0;
            }
            fVar.hFK = j2;
            if (str == null) {
                str = "";
            }
            fVar.atS(str);
            fVar.sessionBuffer = str2;
            this.ufu.a(fVar);
            this.ufu.requestLoadMore();
        } else {
            FinderLiveViewCallback finderLiveViewCallback = this.ufr;
            if (finderLiveViewCallback != null) {
                o oVar5 = o.ujN;
                finderLiveViewCallback.a(1000, o.dfY(), 0);
            }
        }
        Log.i(TAG, "load more data params:".concat(String.valueOf(fVar)));
        AppMethodBeat.o(245797);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001f, code lost:
        if (r1.uiy == 1) goto L_0x0021;
     */
    @Override // com.tencent.mm.plugin.finder.live.c.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean deK() {
        /*
            r4 = this;
            r0 = 1
            r3 = 245798(0x3c026, float:3.44436E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
            com.tencent.mm.plugin.finder.feed.model.internal.m<com.tencent.mm.plugin.finder.live.viewmodel.c> r1 = r4.ufs
            boolean r1 = r1.isLoading
            if (r1 != 0) goto L_0x0021
            boolean r1 = r4.uft
            if (r1 != 0) goto L_0x004c
            com.tencent.mm.plugin.finder.live.model.o r1 = com.tencent.mm.plugin.finder.live.model.o.ujN
            com.tencent.mm.plugin.finder.live.viewmodel.d r1 = com.tencent.mm.plugin.finder.live.model.o.dfY()
            if (r1 == 0) goto L_0x004c
            com.tencent.mm.plugin.finder.live.viewmodel.f r1 = r1.ufx
            if (r1 == 0) goto L_0x004c
            int r1 = r1.uiy
            if (r1 != r0) goto L_0x004c
        L_0x0021:
            java.lang.String r0 = com.tencent.mm.plugin.finder.live.d.TAG
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "canLoadMore isLoading:"
            r1.<init>(r2)
            com.tencent.mm.plugin.finder.feed.model.internal.m<com.tencent.mm.plugin.finder.live.viewmodel.c> r2 = r4.ufs
            boolean r2 = r2.isLoading
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = " hasPreload:"
            java.lang.StringBuilder r1 = r1.append(r2)
            boolean r2 = r4.uft
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.tencent.mm.sdk.platformtools.Log.i(r0, r1)
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
        L_0x004b:
            return r0
        L_0x004c:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            goto L_0x004b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.d.deK():boolean");
    }

    @Override // com.tencent.mm.plugin.finder.live.c.a
    public final boolean IX(int i2) {
        String str;
        String str2;
        f fVar;
        long j2;
        AppMethodBeat.i(245801);
        Log.i(TAG, "preloadData");
        if (this.uft) {
            Log.w(TAG, "return for hasPreload");
            AppMethodBeat.o(245801);
            return false;
        } else if (i2 != 0) {
            Log.w(TAG, "return for newPos:".concat(String.valueOf(i2)));
            AppMethodBeat.o(245801);
            return false;
        } else {
            this.uft = true;
            o oVar = o.ujN;
            if (o.dfY() != null) {
                o oVar2 = o.ujN;
                g dfZ = o.dfZ();
                Long valueOf = dfZ != null ? Long.valueOf(dfZ.hFK) : null;
                o oVar3 = o.ujN;
                g dfZ2 = o.dfZ();
                if (dfZ2 != null) {
                    str = dfZ2.hwg;
                } else {
                    str = null;
                }
                o oVar4 = o.ujN;
                g dfZ3 = o.dfZ();
                if (dfZ3 != null) {
                    str2 = dfZ3.sessionBuffer;
                } else {
                    str2 = null;
                }
                o oVar5 = o.ujN;
                com.tencent.mm.plugin.finder.live.viewmodel.d dfY = o.dfY();
                if (dfY != null) {
                    fVar = dfY.ufx;
                } else {
                    fVar = null;
                }
                if (fVar != null) {
                    if (valueOf != null) {
                        j2 = valueOf.longValue();
                    } else {
                        j2 = 0;
                    }
                    fVar.hFK = j2;
                    if (str == null) {
                        str = "";
                    }
                    fVar.atS(str);
                    fVar.sessionBuffer = str2;
                    if (fVar.uiy == 1) {
                        if (fVar != null) {
                            this.ufu.setPreload(this.ufs);
                            this.ufu.a(fVar);
                            FinderLiveRelatedLoader finderLiveRelatedLoader = this.ufu;
                            if (finderLiveRelatedLoader != null) {
                                finderLiveRelatedLoader.requestPreload();
                            }
                        }
                        AppMethodBeat.o(245801);
                        return true;
                    }
                    AppMethodBeat.o(245801);
                    return false;
                }
                Log.w(TAG, "return for loaderParams is null");
                AppMethodBeat.o(245801);
                return false;
            }
            AppMethodBeat.o(245801);
            return false;
        }
    }

    public final void a(c.b bVar) {
        c.b bVar2;
        RefreshLoadMoreLayout refreshLoadMoreLayout;
        AppMethodBeat.i(245802);
        p.h(bVar, "callback");
        if (!(bVar instanceof FinderLiveViewCallback)) {
            bVar2 = null;
        } else {
            bVar2 = bVar;
        }
        this.ufr = (FinderLiveViewCallback) bVar2;
        FinderLiveViewCallback finderLiveViewCallback = this.ufr;
        if (finderLiveViewCallback != null) {
            o oVar = o.ujN;
            com.tencent.mm.plugin.finder.live.viewmodel.d dfY = o.dfY();
            if (dfY == null) {
                dfY = new com.tencent.mm.plugin.finder.live.viewmodel.d();
            }
            finderLiveViewCallback.a(dfY);
        }
        FinderLiveViewCallback finderLiveViewCallback2 = this.ufr;
        if (finderLiveViewCallback2 == null || (refreshLoadMoreLayout = finderLiveViewCallback2.ufI) == null) {
            AppMethodBeat.o(245802);
            return;
        }
        this.ufu.register(refreshLoadMoreLayout);
        AppMethodBeat.o(245802);
    }

    @Override // com.tencent.mm.plugin.finder.presenter.base.a
    public final void onDetach() {
        RefreshLoadMoreLayout refreshLoadMoreLayout;
        AppMethodBeat.i(245804);
        m<com.tencent.mm.plugin.finder.live.viewmodel.c> mVar = this.ufs;
        if (mVar != null) {
            mVar.clearCache();
        }
        FinderLiveViewCallback finderLiveViewCallback = this.ufr;
        if (!(finderLiveViewCallback == null || (refreshLoadMoreLayout = finderLiveViewCallback.ufI) == null)) {
            this.ufu.unregister(refreshLoadMoreLayout);
        }
        this.ufr = null;
        AppMethodBeat.o(245804);
    }

    @Override // com.tencent.mm.plugin.finder.live.c.a
    public final boolean deL() {
        f fVar;
        f fVar2;
        f fVar3;
        f fVar4;
        AppMethodBeat.i(245799);
        o oVar = o.ujN;
        com.tencent.mm.plugin.finder.live.viewmodel.d dfY = o.dfY();
        if (dfY == null) {
            AppMethodBeat.o(245799);
            return false;
        } else if (dfY.diM() || (((fVar = dfY.ufx) != null && fVar.dLS == 2) || (((fVar2 = dfY.ufx) != null && fVar2.dLS == 2) || (((fVar3 = dfY.ufx) != null && fVar3.dLS == 1001) || ((fVar4 = dfY.ufx) != null && fVar4.uiy == 1))))) {
            AppMethodBeat.o(245799);
            return true;
        } else {
            AppMethodBeat.o(245799);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.finder.live.c.a
    public final boolean deM() {
        AppMethodBeat.i(245800);
        o oVar = o.ujN;
        com.tencent.mm.plugin.finder.live.viewmodel.d dfY = o.dfY();
        if (dfY != null) {
            boolean diM = dfY.diM();
            AppMethodBeat.o(245800);
            return diM;
        }
        AppMethodBeat.o(245800);
        return false;
    }
}
