package com.tencent.mm.plugin.fav.ui.gallery;

import android.content.Context;
import android.graphics.Rect;
import android.os.Looper;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.ui.gallery.e;
import com.tencent.mm.plugin.fav.ui.gallery.f;
import com.tencent.mm.plugin.fav.ui.gallery.g;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class h implements e.b, g.a {
    List<Long> idList = new ArrayList();
    Context mContext;
    ArrayList<f.d> mDataList = null;
    private MMHandler mHandler = new MMHandler(Looper.getMainLooper());
    private GridLayoutManager qoD;
    g.b tkU;
    f tkV;
    boolean tkW = false;
    int tkX = 0;
    int tkY = 0;
    f.b tkz;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.fav.ui.gallery.b] */
    @Override // com.tencent.mm.plugin.fav.ui.gallery.a
    public final /* synthetic */ void a(g.b bVar) {
        AppMethodBeat.i(107440);
        this.tkU = bVar;
        this.tkU.a(this);
        e cWN = e.a.cWN();
        cWN.tkv.remove(this);
        cWN.tkv.add(this);
        AppMethodBeat.o(107440);
    }

    public h(Context context) {
        AppMethodBeat.i(107429);
        this.mContext = context;
        this.mDataList = new ArrayList<>();
        AppMethodBeat.o(107429);
    }

    @Override // com.tencent.mm.plugin.fav.ui.gallery.g.a
    public final void a(f.b bVar) {
        this.tkz = bVar;
    }

    @Override // com.tencent.mm.plugin.fav.ui.gallery.a
    public final void onDetach() {
        AppMethodBeat.i(107430);
        if (this.tkU != null) {
            this.tkU.a(null);
            this.tkU = null;
        }
        e cWN = e.a.cWN();
        cWN.tkv.clear();
        cWN.clear();
        cWN.tku = false;
        AppMethodBeat.o(107430);
    }

    @Override // com.tencent.mm.plugin.fav.ui.gallery.g.a
    public final <T extends RecyclerView.LayoutManager> T eS(Context context) {
        AppMethodBeat.i(235374);
        if (this.qoD == null) {
            this.qoD = new GridLayoutManager(4);
            this.qoD.apR = new GridLayoutManager.b() {
                /* class com.tencent.mm.plugin.fav.ui.gallery.h.AnonymousClass1 */

                @Override // android.support.v7.widget.GridLayoutManager.b
                public final int bX(int i2) {
                    AppMethodBeat.i(107423);
                    if (i2 >= h.this.mDataList.size()) {
                        AppMethodBeat.o(107423);
                        return 4;
                    } else if (h.this.mDataList.get(i2).type == Integer.MAX_VALUE) {
                        AppMethodBeat.o(107423);
                        return 4;
                    } else {
                        AppMethodBeat.o(107423);
                        return 1;
                    }
                }
            };
        }
        GridLayoutManager gridLayoutManager = this.qoD;
        AppMethodBeat.o(235374);
        return gridLayoutManager;
    }

    @Override // com.tencent.mm.plugin.fav.ui.gallery.g.a
    public final RecyclerView.h fi(final Context context) {
        AppMethodBeat.i(107432);
        AnonymousClass2 r0 = new RecyclerView.h() {
            /* class com.tencent.mm.plugin.fav.ui.gallery.h.AnonymousClass2 */

            @Override // android.support.v7.widget.RecyclerView.h
            public final void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
                AppMethodBeat.i(107424);
                int dimension = (int) context.getResources().getDimension(R.dimen.iu);
                rect.bottom = dimension;
                rect.top = dimension;
                rect.left = dimension;
                rect.right = dimension;
                AppMethodBeat.o(107424);
            }
        };
        AppMethodBeat.o(107432);
        return r0;
    }

    @Override // com.tencent.mm.plugin.fav.ui.gallery.g.a
    public final RecyclerView.a cyF() {
        AppMethodBeat.i(107433);
        this.tkV = new f(this.mContext, this.mDataList, this.tkU, new Runnable() {
            /* class com.tencent.mm.plugin.fav.ui.gallery.h.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(107425);
                Log.i("MicroMsg.MediaHistoryGalleryPresenter", "uiCallback()");
                h.this.G(true, -1);
                AppMethodBeat.o(107425);
            }
        });
        this.tkV.tky = new f.c() {
            /* class com.tencent.mm.plugin.fav.ui.gallery.h.AnonymousClass4 */

            @Override // com.tencent.mm.plugin.fav.ui.gallery.f.c
            public final void a(boolean z, f.d dVar, int i2) {
                AppMethodBeat.i(107426);
                Log.i("MicroMsg.MediaHistoryGalleryPresenter", "[onCheck] isChecked :%s pos:%s", Boolean.valueOf(z), Integer.valueOf(i2));
                if (!z || e.a.cWN().tkt.size() < 9) {
                    if (z) {
                        e cWN = e.a.cWN();
                        d dVar2 = dVar.tkC;
                        if (dVar2 != null) {
                            Log.i("MicroMsg.ImageGallerySelectedHandle", "add : %s", dVar2);
                            cWN.tkt.remove(dVar2);
                            cWN.tkt.remove(cWN.asv(dVar2.dLo.dLl));
                            cWN.tkt.add(dVar2);
                            cWN.cWM();
                        }
                    } else {
                        e cWN2 = e.a.cWN();
                        d dVar3 = dVar.tkC;
                        if (dVar3 != null) {
                            Log.i("MicroMsg.ImageGallerySelectedHandle", "remove : %s", dVar3.dLo.dLl);
                            cWN2.tkt.remove(dVar3);
                            cWN2.tkt.remove(cWN2.asv(dVar3.dLo.dLl));
                            cWN2.cWM();
                        }
                    }
                    h.this.tkU.Ie(e.a.cWN().tkt.size());
                    AppMethodBeat.o(107426);
                    return;
                }
                Toast.makeText(h.this.mContext, h.this.mContext.getResources().getString(R.string.c8k, 9), 1).show();
                h.this.tkV.ci(i2);
                AppMethodBeat.o(107426);
            }
        };
        this.tkV.tkz = this.tkz;
        f fVar = this.tkV;
        AppMethodBeat.o(107433);
        return fVar;
    }

    @Override // com.tencent.mm.plugin.fav.ui.gallery.g.a
    public final void Ig(int i2) {
        AppMethodBeat.i(107434);
        Log.i("MicroMsg.MediaHistoryGalleryPresenter", "[handleSelectedItem] type:%s", Integer.valueOf(i2));
        ArrayList<d> arrayList = e.a.cWN().tkt;
        if (arrayList == null || arrayList.size() == 0) {
            Log.i("MicroMsg.MediaHistoryGalleryPresenter", "handleSelectedItem() list == null");
            AppMethodBeat.o(107434);
            return;
        }
        switch (i2) {
            case 0:
                this.tkU.dM(arrayList);
                this.tkU.cWI();
                AppMethodBeat.o(107434);
                return;
            case 1:
                this.tkU.dN(arrayList);
                this.tkU.cWI();
                break;
        }
        AppMethodBeat.o(107434);
    }

    @Override // com.tencent.mm.plugin.fav.ui.gallery.g.a
    public final void onResume() {
        AppMethodBeat.i(107438);
        if (this.tkW && e.a.cWN().tku) {
            this.tkU.Ie(e.a.cWN().tkt.size());
            this.tkV.atj.notifyChanged();
        }
        AppMethodBeat.o(107438);
    }

    @Override // com.tencent.mm.plugin.fav.ui.gallery.e.b
    public final void cWO() {
        this.tkW = true;
    }

    @Override // com.tencent.mm.plugin.fav.ui.gallery.g.a
    public final void cWH() {
        AppMethodBeat.i(107435);
        this.tkV.tkA = true;
        e.a.cWN().tku = true;
        GridLayoutManager gridLayoutManager = (GridLayoutManager) eS(this.mContext);
        int ks = gridLayoutManager.ks();
        this.tkV.e(ks, (gridLayoutManager.ku() - ks) + 1, 0);
        AppMethodBeat.o(107435);
    }

    @Override // com.tencent.mm.plugin.fav.ui.gallery.g.a
    public final void cWI() {
        AppMethodBeat.i(107436);
        this.tkV.tkA = false;
        e.a.cWN().clear();
        e.a.cWN().tku = false;
        this.tkV.atj.notifyChanged();
        AppMethodBeat.o(107436);
    }

    @Override // com.tencent.mm.plugin.fav.ui.gallery.g.a
    public final boolean cWG() {
        AppMethodBeat.i(107437);
        boolean z = e.a.cWN().tku;
        AppMethodBeat.o(107437);
        return z;
    }

    @Override // com.tencent.mm.plugin.fav.ui.gallery.g.a
    public final void G(final boolean z, final int i2) {
        AppMethodBeat.i(107439);
        this.tkV.qor = true;
        this.tkU.kF(z);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.fav.ui.gallery.h.AnonymousClass5 */

            public final void run() {
                int i2 = 100;
                AppMethodBeat.i(107428);
                if (z) {
                    h.this.mDataList.clear();
                    h.this.tkY = 0;
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(21);
                    h.this.idList = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavSearchStorage().b(null, null, arrayList);
                    h.this.tkX = h.this.idList.size();
                }
                if (i2 >= 0 && h.this.tkX - i2 > 100) {
                    i2 = h.this.tkX - i2;
                }
                Log.i("MicroMsg.MediaHistoryGalleryPresenter", "offset:%s limit:%s", Integer.valueOf(i2), Integer.valueOf(i2));
                LinkedList linkedList = new LinkedList();
                while (linkedList.size() < i2 && h.this.tkY < h.this.idList.size()) {
                    int i3 = h.this.tkY;
                    int size = i3 + i2 > h.this.idList.size() ? h.this.idList.size() : i3 + i2;
                    List<com.tencent.mm.plugin.fav.a.g> dO = h.dO(h.this.idList.subList(i3, size));
                    h.this.tkY = size;
                    for (com.tencent.mm.plugin.fav.a.g gVar : dO) {
                        linkedList.addAll(h.I(gVar));
                    }
                    Log.i("MicroMsg.MediaHistoryGalleryPresenter", "traverse until size ok. start:%s, end:%s, idListSize:%s, limit:%s, linklistSize:%s", Integer.valueOf(i3), Integer.valueOf(size), Integer.valueOf(h.this.idList.size()), Integer.valueOf(i2), Integer.valueOf(linkedList.size()));
                }
                final int size2 = linkedList.size();
                Collections.reverse(linkedList);
                h.this.mDataList.addAll(0, linkedList);
                linkedList.clear();
                Log.i("MicroMsg.MediaHistoryGalleryPresenter", "[loadData] %s", Integer.valueOf(h.this.mDataList.size()));
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.fav.ui.gallery.h.AnonymousClass5.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(107427);
                        h.this.tkV.qor = false;
                        if (h.this.tkU != null) {
                            h.this.tkU.D(z, size2);
                        }
                        AppMethodBeat.o(107427);
                    }
                });
                AppMethodBeat.o(107428);
            }
        });
        AppMethodBeat.o(107439);
    }

    @Override // com.tencent.mm.plugin.fav.ui.gallery.g.a
    public final /* bridge */ /* synthetic */ RecyclerView.a cWP() {
        return this.tkV;
    }

    static /* synthetic */ List dO(List list) {
        AppMethodBeat.i(107441);
        ArrayList arrayList = new ArrayList();
        if (list == null || list.size() == 0) {
            AppMethodBeat.o(107441);
            return arrayList;
        }
        int i2 = 0;
        while (true) {
            int size = i2 + 20 < list.size() ? i2 + 20 : list.size();
            Log.v("MicroMsg.MediaHistoryGalleryPresenter", "start:%d  end:%d listSize:%d", Integer.valueOf(i2), Integer.valueOf(size), Integer.valueOf(list.size()));
            ArrayList<com.tencent.mm.plugin.fav.a.g> a2 = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(list.subList(i2, size), null, null, null);
            if (a2 != null && a2.size() > 0) {
                arrayList.addAll(a2);
            }
            if (size >= list.size()) {
                AppMethodBeat.o(107441);
                return arrayList;
            }
            i2 = size;
        }
    }

    static /* synthetic */ List I(com.tencent.mm.plugin.fav.a.g gVar) {
        AppMethodBeat.i(107442);
        ArrayList arrayList = new ArrayList();
        if (!(gVar == null || gVar.field_favProto.ppH.size() == 0)) {
            for (int size = gVar.field_favProto.ppH.size() - 1; size >= 0; size--) {
                aml aml = gVar.field_favProto.ppH.get(size);
                if (aml.dataType == 2 || aml.dataType == 4 || aml.dataType == 15) {
                    arrayList.add(new f.d(new d(gVar, aml)));
                }
            }
        }
        AppMethodBeat.o(107442);
        return arrayList;
    }
}
