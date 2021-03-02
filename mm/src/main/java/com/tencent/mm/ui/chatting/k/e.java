package com.tencent.mm.ui.chatting.k;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.z;
import com.tencent.mm.av.e;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.ir;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.br;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.model.j;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.a;
import com.tencent.mm.ui.chatting.a.b;
import com.tencent.mm.ui.chatting.ac;
import com.tencent.mm.ui.chatting.f.a;
import com.tencent.mm.ui.chatting.gallery.d;
import com.tencent.mm.ui.chatting.gallery.h;
import com.tencent.mm.ui.chatting.l;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public final class e implements e.a, t.a, a.AbstractC2092a, h.b {
    static int count = 0;
    private int PEA = 0;
    private boolean PEB = false;
    private int PEu = 0;
    private a.b PEy;
    b PEz;
    private long PlX;
    private String gAn;
    private Context mContext;
    private ArrayList<b.c> mDataList = null;
    private MMHandler mHandler = new MMHandler(Looper.getMainLooper());
    private IListener qoC = new IListener<ir>() {
        /* class com.tencent.mm.ui.chatting.k.e.AnonymousClass10 */

        {
            AppMethodBeat.i(161546);
            this.__eventId = ir.class.getName().hashCode();
            AppMethodBeat.o(161546);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ir irVar) {
            AppMethodBeat.i(36509);
            ir irVar2 = irVar;
            e.a(e.this, irVar2.dNm.msgId, irVar2);
            AppMethodBeat.o(36509);
            return false;
        }
    };
    private GridLayoutManager qoD;
    boolean tkW = false;
    private int tkX = 0;

    static /* synthetic */ void a(e eVar, cz czVar) {
        AppMethodBeat.i(233503);
        eVar.c(czVar);
        AppMethodBeat.o(233503);
    }

    static /* synthetic */ boolean g(e eVar) {
        AppMethodBeat.i(233502);
        boolean gTG = eVar.gTG();
        AppMethodBeat.o(233502);
        return gTG;
    }

    static /* synthetic */ int h(e eVar) {
        int i2 = eVar.PEA;
        eVar.PEA = i2 - 1;
        return i2;
    }

    static /* synthetic */ void jz(List list) {
        AppMethodBeat.i(233504);
        jw(list);
        AppMethodBeat.o(233504);
    }

    static /* synthetic */ int m(e eVar) {
        int i2 = eVar.PEu;
        eVar.PEu = i2 + 1;
        return i2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.ui.chatting.view.a] */
    @Override // com.tencent.mm.ui.chatting.k.c
    public final /* synthetic */ void a(a.b bVar) {
        AppMethodBeat.i(36539);
        this.PEy = bVar;
        this.PEy.a(this);
        this.qoC.alive();
        h.a.Pys.a(this);
        AppMethodBeat.o(36539);
    }

    public e(Context context) {
        AppMethodBeat.i(36516);
        this.mContext = context;
        this.mDataList = new ArrayList<>();
        AppMethodBeat.o(36516);
    }

    @Override // com.tencent.mm.ui.chatting.k.c
    public final void onDetach() {
        AppMethodBeat.i(36517);
        this.qoC.dead();
        this.PEy.a(null);
        this.PEy = null;
        q.bcS().a(this);
        o.bhj().a(this);
        h.a.Pys.detach();
        l.gNy();
        AppMethodBeat.o(36517);
    }

    @Override // com.tencent.mm.ui.chatting.f.a.AbstractC2092a
    public final <T extends RecyclerView.LayoutManager> T eS(Context context) {
        AppMethodBeat.i(233494);
        if (this.qoD == null) {
            this.qoD = new GridLayoutManager(4);
            this.qoD.apR = new GridLayoutManager.b() {
                /* class com.tencent.mm.ui.chatting.k.e.AnonymousClass1 */

                @Override // android.support.v7.widget.GridLayoutManager.b
                public final int bX(int i2) {
                    AppMethodBeat.i(36493);
                    if (((b.c) e.this.mDataList.get(i2)).type == Integer.MAX_VALUE) {
                        AppMethodBeat.o(36493);
                        return 4;
                    }
                    AppMethodBeat.o(36493);
                    return 1;
                }
            };
        }
        GridLayoutManager gridLayoutManager = this.qoD;
        AppMethodBeat.o(233494);
        return gridLayoutManager;
    }

    @Override // com.tencent.mm.ui.chatting.f.a.AbstractC2092a
    public final RecyclerView.h fi(final Context context) {
        AppMethodBeat.i(36519);
        AnonymousClass9 r0 = new RecyclerView.h() {
            /* class com.tencent.mm.ui.chatting.k.e.AnonymousClass9 */

            @Override // android.support.v7.widget.RecyclerView.h
            public final void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
                AppMethodBeat.i(36508);
                int dimension = (int) context.getResources().getDimension(R.dimen.iu);
                rect.bottom = dimension;
                rect.top = dimension;
                rect.left = dimension;
                rect.right = dimension;
                AppMethodBeat.o(36508);
            }
        };
        AppMethodBeat.o(36519);
        return r0;
    }

    @Override // com.tencent.mm.ui.chatting.f.a.AbstractC2092a
    public final b ch(String str, long j2) {
        AppMethodBeat.i(233495);
        this.gAn = str;
        this.PlX = j2;
        if (j2 == -1) {
            this.PEz = new b(this.mContext, this.mDataList, str);
        } else {
            this.PEz = new b(this.mContext, this.mDataList, str, j2);
        }
        this.PEz.PlY = new b.AbstractC2088b() {
            /* class com.tencent.mm.ui.chatting.k.e.AnonymousClass11 */

            @Override // com.tencent.mm.ui.chatting.a.b.AbstractC2088b
            public final void a(boolean z, b.c cVar, int i2) {
                AppMethodBeat.i(36510);
                Log.i("MicroMsg.MediaHistoryGalleryPresenter", "[onCheck] isChecked :%s pos:%s", Boolean.valueOf(z), Integer.valueOf(i2));
                if (!z || h.a.Pys.tkt.size() < 9) {
                    if (z) {
                        h.a.Pys.cC(cVar.dTX);
                    } else {
                        h.a.Pys.cD(cVar.dTX);
                    }
                    e.this.PEy.Ie(h.a.Pys.tkt.size());
                    AppMethodBeat.o(36510);
                    return;
                }
                Toast.makeText(e.this.mContext, e.this.mContext.getResources().getString(R.string.dms, 9), 1).show();
                e.this.PEz.ci(i2);
                AppMethodBeat.o(36510);
            }
        };
        b bVar = this.PEz;
        AppMethodBeat.o(233495);
        return bVar;
    }

    @Override // com.tencent.mm.ui.chatting.f.a.AbstractC2092a
    public final String bmB() {
        AppMethodBeat.i(36521);
        String string = this.mContext.getString(R.string.gt);
        AppMethodBeat.o(36521);
        return string;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.ui.chatting.f.a.AbstractC2092a
    public final void Ig(int i2) {
        String string;
        AppMethodBeat.i(36522);
        Log.i("MicroMsg.MediaHistoryGalleryPresenter", "[handleSelectedItem] type:%s", Integer.valueOf(i2));
        final ArrayList<ca> arrayList = h.a.Pys.tkt;
        switch (i2) {
            case 0:
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(219, 19, 1, true);
                l.a(this.mContext, arrayList, ab.Eq(this.gAn), this.gAn, new z() {
                    /* class com.tencent.mm.ui.chatting.k.e.AnonymousClass7 */

                    @Override // com.tencent.mm.ag.z
                    public final void a(z.a aVar) {
                    }

                    @Override // com.tencent.mm.ag.z
                    public final void b(z.a aVar) {
                    }

                    @Override // com.tencent.mm.ag.z
                    public final void c(z.a aVar) {
                    }

                    @Override // com.tencent.mm.ag.z
                    public final boolean aSC() {
                        return true;
                    }

                    @Override // com.tencent.mm.ag.z
                    public final boolean aSD() {
                        return false;
                    }

                    @Override // com.tencent.mm.ag.z
                    public final void B(Bundle bundle) {
                    }

                    @Override // com.tencent.mm.ag.z
                    public final boolean aSE() {
                        return false;
                    }
                });
                this.PEy.cWI();
                AppMethodBeat.o(36522);
                return;
            case 1:
                for (ca caVar : arrayList) {
                    if (!ac.bC(caVar)) {
                        u.makeText(this.mContext, (int) R.string.c_a, 0).show();
                        AppMethodBeat.o(36522);
                        return;
                    }
                }
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(219, 18, 1, true);
                final cz czVar = new cz();
                if (j.a(this.mContext, czVar, this.gAn, arrayList, false)) {
                    c(czVar);
                    jw(arrayList);
                } else if (arrayList.size() > 1) {
                    Context context = this.mContext;
                    String string2 = czVar.dFZ.dGe >= 0 ? this.mContext.getString(R.string.c_f) : this.mContext.getString(R.string.c_e);
                    if (czVar.dFZ.dGe >= 0) {
                        string = this.mContext.getString(R.string.b98);
                    } else {
                        string = this.mContext.getString(R.string.fn9);
                    }
                    com.tencent.mm.ui.base.h.c(context, string2, "", string, this.mContext.getString(R.string.b96), new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.ui.chatting.k.e.AnonymousClass5 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(36505);
                            if (czVar.dFZ.type == 14 && czVar.dFZ.dGb.ppH.size() == 0) {
                                AppMethodBeat.o(36505);
                                return;
                            }
                            e.a(e.this, czVar);
                            e.jz(arrayList);
                            AppMethodBeat.o(36505);
                        }
                    }, null);
                } else {
                    com.tencent.mm.ui.base.h.n(this.mContext, czVar.dFZ.dGe, 0);
                }
                this.PEy.cWI();
                AppMethodBeat.o(36522);
                return;
            case 2:
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(11627, 5);
                final TreeSet treeSet = new TreeSet();
                for (ca caVar2 : arrayList) {
                    treeSet.add(Long.valueOf(caVar2.field_msgId));
                }
                com.tencent.mm.ui.base.h.c(this.mContext, this.mContext.getString(R.string.b91), "", this.mContext.getString(R.string.blj), this.mContext.getString(R.string.sz), new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.ui.chatting.k.e.AnonymousClass6 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(233489);
                        Log.i("MicroMsg.MediaHistoryGalleryPresenter", "delete message");
                        com.tencent.mm.ui.chatting.j.a(e.this.mContext, treeSet, new z() {
                            /* class com.tencent.mm.ui.chatting.k.e.AnonymousClass6.AnonymousClass1 */

                            @Override // com.tencent.mm.ag.z
                            public final void a(z.a aVar) {
                            }

                            @Override // com.tencent.mm.ag.z
                            public final void b(z.a aVar) {
                                AppMethodBeat.i(233487);
                                if (aVar == z.a.del) {
                                    e.this.mDataList.removeAll(arrayList);
                                }
                                AppMethodBeat.o(233487);
                            }

                            @Override // com.tencent.mm.ag.z
                            public final void c(z.a aVar) {
                                AppMethodBeat.i(233488);
                                Log.i("MicroMsg.MediaHistoryGalleryPresenter", "[requestExitSelectedMode] %s del size:%s job:%s", Thread.currentThread(), Integer.valueOf(arrayList.size()), aVar);
                                if (aVar == z.a.del && e.this.PEy != null) {
                                    e.this.PEy.cWI();
                                }
                                AppMethodBeat.o(233488);
                            }

                            @Override // com.tencent.mm.ag.z
                            public final boolean aSC() {
                                return true;
                            }

                            @Override // com.tencent.mm.ag.z
                            public final boolean aSD() {
                                return false;
                            }

                            @Override // com.tencent.mm.ag.z
                            public final void B(Bundle bundle) {
                            }

                            @Override // com.tencent.mm.ag.z
                            public final boolean aSE() {
                                return false;
                            }
                        });
                        AppMethodBeat.o(233489);
                    }
                }, null);
                break;
            case 3:
                p.a(this.mContext, new Runnable() {
                    /* class com.tencent.mm.ui.chatting.k.e.AnonymousClass16 */

                    public final void run() {
                        AppMethodBeat.i(233493);
                        final List jx = e.jx(arrayList);
                        if (jx.size() != arrayList.size()) {
                            com.tencent.mm.ui.base.h.a(e.this.mContext, (int) R.string.dmo, (int) R.string.zb, new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.ui.chatting.k.e.AnonymousClass16.AnonymousClass1 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(233492);
                                    if (jx.size() == 0) {
                                        Log.i("MicroMsg.MediaHistoryGalleryPresenter", "handleSave size = 0");
                                        e.this.PEy.gRS();
                                        AppMethodBeat.o(233492);
                                        return;
                                    }
                                    e.a(e.this, jx);
                                    AppMethodBeat.o(233492);
                                }
                            }, (DialogInterface.OnClickListener) null);
                            AppMethodBeat.o(233493);
                            return;
                        }
                        e.a(e.this, jx);
                        AppMethodBeat.o(233493);
                    }
                }, new Runnable() {
                    /* class com.tencent.mm.ui.chatting.k.e.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(36498);
                        Toast.makeText(e.this.mContext, e.this.mContext.getString(R.string.gap), 1).show();
                        AppMethodBeat.o(36498);
                    }
                });
                AppMethodBeat.o(36522);
                return;
        }
        AppMethodBeat.o(36522);
    }

    @Override // com.tencent.mm.ui.chatting.f.a.AbstractC2092a
    public final void onResume() {
        AppMethodBeat.i(36527);
        if (this.tkW && h.a.Pys.tku) {
            this.PEy.Ie(h.a.Pys.tkt.size());
            this.PEz.atj.notifyChanged();
        }
        AppMethodBeat.o(36527);
    }

    @Override // com.tencent.mm.ui.chatting.gallery.h.b
    public final void gSm() {
        this.tkW = true;
    }

    @Override // com.tencent.mm.ui.chatting.gallery.h.b
    public final void clear() {
    }

    @Override // com.tencent.mm.av.e.a
    public final void a(long j2, long j3, int i2, int i3, Object obj, int i4, int i5, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(36528);
        Log.d("MicroMsg.MediaHistoryGalleryPresenter", "[onImgTaskProgress] offset:%s totalLen:%s", Integer.valueOf(i4), Integer.valueOf(i5));
        AppMethodBeat.o(36528);
    }

    @Override // com.tencent.mm.av.e.a
    public final void a(long j2, long j3, int i2, int i3, Object obj, int i4, int i5, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(36529);
        Log.i("MicroMsg.MediaHistoryGalleryPresenter", "[onImgTaskEnd] mNeedDownloadCount:%s imgLocalId:%s msgLocalId:%s err[%s:%s:%s]", Integer.valueOf(this.PEA), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i4), Integer.valueOf(i5), str);
        if (!this.PEy.gRV()) {
            AppMethodBeat.o(36529);
            return;
        }
        this.PEA--;
        bg.aVF();
        if (!com.tencent.mm.ui.chatting.gallery.b.d(this.mContext, c.aSQ().Hb(j3), false)) {
            this.PEB = true;
        }
        if (gTG()) {
            if (!this.PEB) {
                this.mHandler.post(new Runnable() {
                    /* class com.tencent.mm.ui.chatting.k.e.AnonymousClass12 */

                    public final void run() {
                        AppMethodBeat.i(36511);
                        if (e.this.PEy != null) {
                            e.this.PEy.gRU();
                        }
                        AppMethodBeat.o(36511);
                    }
                });
                AppMethodBeat.o(36529);
                return;
            }
            this.mHandler.post(new Runnable() {
                /* class com.tencent.mm.ui.chatting.k.e.AnonymousClass13 */

                public final void run() {
                    AppMethodBeat.i(36512);
                    if (e.this.PEy != null) {
                        e.this.PEy.amL(R.string.dn4);
                    }
                    AppMethodBeat.o(36512);
                }
            });
        }
        AppMethodBeat.o(36529);
    }

    @Override // com.tencent.mm.av.e.a
    public final void a(long j2, long j3, int i2, int i3, Object obj) {
    }

    @Override // com.tencent.mm.ui.chatting.f.a.AbstractC2092a
    public final void gRS() {
        AppMethodBeat.i(36530);
        q.bcS().a(this);
        o.bhj().a(this);
        this.PEy.gRS();
        AppMethodBeat.o(36530);
    }

    @Override // com.tencent.mm.modelvideo.t.a
    public final void a(t.a.C0460a aVar) {
        AppMethodBeat.i(36531);
        if (this.PEy == null || !this.PEy.gRV()) {
            AppMethodBeat.o(36531);
            return;
        }
        s QN = com.tencent.mm.modelvideo.u.QN(aVar.fileName);
        Log.d("MicroMsg.MediaHistoryGalleryPresenter", "[notifyChanged] mNeedDownloadCount:%s statusType:%s %s", Integer.valueOf(this.PEA), aVar.jsI, aVar.fileName);
        if (QN == null) {
            Log.e("MicroMsg.MediaHistoryGalleryPresenter", "[notifyChanged] videoInfo is null!");
            gRS();
            this.PEy.amL(0);
        } else if (QN.bhy()) {
            this.PEA--;
            bg.aVF();
            com.tencent.mm.ui.chatting.gallery.b.b(this.mContext, c.aSQ().Hb((long) QN.jso), false);
        }
        if (gTG()) {
            if (this.PEB) {
                this.mHandler.post(new Runnable() {
                    /* class com.tencent.mm.ui.chatting.k.e.AnonymousClass14 */

                    public final void run() {
                        AppMethodBeat.i(36513);
                        if (e.this.PEy != null) {
                            e.this.PEy.amL(R.string.dn4);
                        }
                        AppMethodBeat.o(36513);
                    }
                });
                AppMethodBeat.o(36531);
                return;
            }
            this.mHandler.post(new Runnable() {
                /* class com.tencent.mm.ui.chatting.k.e.AnonymousClass15 */

                public final void run() {
                    AppMethodBeat.i(36514);
                    if (e.this.PEy != null) {
                        e.this.PEy.gRU();
                    }
                    AppMethodBeat.o(36514);
                }
            });
        }
        AppMethodBeat.o(36531);
    }

    private boolean gTG() {
        return this.PEA == 0;
    }

    private static void jw(List<ca> list) {
        AppMethodBeat.i(36536);
        for (ca caVar : list) {
            com.tencent.mm.ui.chatting.a.a(a.c.Fav, a.d.Samll, caVar, 0);
        }
        AppMethodBeat.o(36536);
    }

    private void c(cz czVar) {
        AppMethodBeat.i(36537);
        czVar.dFZ.dGf = 45;
        czVar.dFZ.activity = (Activity) this.mContext;
        EventCenter.instance.publish(czVar);
        if (czVar.dGa.ret == -2 || czVar.dGa.ret > 0) {
            AppMethodBeat.o(36537);
            return;
        }
        if (czVar.dGa.ret <= 0) {
            if (14 != czVar.dFZ.type) {
                Log.d("MicroMsg.MediaHistoryGalleryPresenter", "not record type, do not report");
                AppMethodBeat.o(36537);
                return;
            } else if (czVar.dFZ.dGc == null) {
                Log.e("MicroMsg.MediaHistoryGalleryPresenter", "want to report record fav, but type count is null");
                AppMethodBeat.o(36537);
                return;
            } else {
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(11142, Integer.valueOf(czVar.dFZ.dGc.Lyp), Integer.valueOf(czVar.dFZ.dGc.Lyq), Integer.valueOf(czVar.dFZ.dGc.Lyr), Integer.valueOf(czVar.dFZ.dGc.xiP), Integer.valueOf(czVar.dFZ.dGc.Lys), Integer.valueOf(czVar.dFZ.dGc.Lyt), Integer.valueOf(czVar.dFZ.dGc.Lyu), Integer.valueOf(czVar.dFZ.dGc.fileCount), Integer.valueOf(czVar.dFZ.dGc.Lyv), Integer.valueOf(czVar.dFZ.dGc.Lyw), Integer.valueOf(czVar.dFZ.dGc.Lyx), Integer.valueOf(czVar.dFZ.dGc.Lyy), Integer.valueOf(czVar.dFZ.dGc.Lyz), Integer.valueOf(czVar.dFZ.dGc.LyA), Integer.valueOf(czVar.dFZ.dGc.LyB));
            }
        }
        AppMethodBeat.o(36537);
    }

    @Override // com.tencent.mm.ui.chatting.f.a.AbstractC2092a
    public final void G(final boolean z, final int i2) {
        AppMethodBeat.i(36538);
        if (z || this.tkX + this.PEu != this.mDataList.size()) {
            this.PEz.qor = true;
            this.PEy.kF(z);
            g.aAi();
            g.aAk().postToWorker(new Runnable() {
                /* class com.tencent.mm.ui.chatting.k.e.AnonymousClass8 */

                public final void run() {
                    Cursor b2;
                    Cursor d2;
                    AppMethodBeat.i(233491);
                    if (z) {
                        if (e.this.PlX == -1) {
                            e eVar = e.this;
                            bg.aVF();
                            eVar.tkX = c.aSQ().aEN(e.this.gAn);
                        } else {
                            e eVar2 = e.this;
                            bg.aVF();
                            eVar2.tkX = c.aSR().cd(e.this.gAn, e.this.PlX);
                        }
                    }
                    int i2 = (i2 < 0 || e.this.tkX - i2 <= 200) ? 200 : e.this.tkX - i2;
                    Log.i("MicroMsg.MediaHistoryGalleryPresenter", "offset:%s limit:%s", Integer.valueOf(i2), Integer.valueOf(i2));
                    LinkedList linkedList = new LinkedList();
                    if (e.this.PlX == -1) {
                        bg.aVF();
                        b2 = c.aSQ().at(e.this.gAn, e.this.mDataList.size() - e.this.PEu, i2);
                    } else {
                        bg.aVF();
                        b2 = c.aSR().b(e.this.gAn, e.this.PlX, e.this.mDataList.size() - e.this.PEu, i2);
                    }
                    if (b2 == null) {
                        Log.e("MicroMsg.MediaHistoryGalleryPresenter", "[loadData] NULL == cursor ");
                        AppMethodBeat.o(233491);
                        return;
                    }
                    long j2 = 0;
                    while (b2.moveToNext()) {
                        try {
                            ca caVar = new ca();
                            caVar.convertFrom(b2);
                            long b3 = com.tencent.mm.ui.gridviewheaders.a.gWr().b(new Date(caVar.field_createTime));
                            if (j2 != b3) {
                                linkedList.add(new b.c(caVar.field_createTime));
                                e.m(e.this);
                            }
                            linkedList.add(new b.c(caVar));
                            j2 = b3;
                        } catch (Throwable th) {
                            b2.close();
                            AppMethodBeat.o(233491);
                            throw th;
                        }
                    }
                    b2.close();
                    LinkedList linkedList2 = new LinkedList();
                    if (linkedList.size() - e.this.PEu == i2) {
                        long j3 = ((b.c) linkedList.get(0)).timeStamp;
                        com.tencent.mm.ui.gridviewheaders.a.gWr();
                        long NX = com.tencent.mm.ui.gridviewheaders.a.NX(j3);
                        Log.i("MicroMsg.MediaHistoryGalleryPresenter", "[loadData] list size:%s start:%s end:%s", Integer.valueOf(linkedList.size()), Long.valueOf(NX), Long.valueOf(j3));
                        if (e.this.PlX == -1) {
                            bg.aVF();
                            d2 = c.aSQ().B(e.this.gAn, NX, j3);
                        } else {
                            bg.aVF();
                            d2 = c.aSR().d(e.this.gAn, e.this.PlX, NX, j3);
                        }
                        Date date = new Date(j3);
                        long b4 = com.tencent.mm.ui.gridviewheaders.a.gWr().b(date);
                        while (d2 != null) {
                            try {
                                if (!d2.moveToNext()) {
                                    break;
                                }
                                ca caVar2 = new ca();
                                caVar2.convertFrom(d2);
                                long b5 = com.tencent.mm.ui.gridviewheaders.a.gWr().b(new Date(caVar2.field_createTime));
                                if (b4 == b5 || com.tencent.mm.ui.gridviewheaders.a.gWr().b(date) == b5) {
                                    if (linkedList.size() > 0 && linkedList2.size() == 0) {
                                        linkedList2.add(0, linkedList.remove(0));
                                    }
                                    b5 = b4;
                                } else {
                                    linkedList2.add(new b.c(caVar2.field_createTime));
                                    e.m(e.this);
                                }
                                linkedList2.add(new b.c(caVar2));
                                b4 = b5;
                            } catch (Throwable th2) {
                                if (d2 != null) {
                                    d2.close();
                                }
                                AppMethodBeat.o(233491);
                                throw th2;
                            }
                        }
                        if (d2 != null) {
                            d2.close();
                        }
                    }
                    final LinkedList linkedList3 = new LinkedList();
                    linkedList3.addAll(linkedList2);
                    linkedList3.addAll(linkedList);
                    Log.i("MicroMsg.MediaHistoryGalleryPresenter", "[loadData] linkedList:%s linkedList1:%s finalAddList:%s", Integer.valueOf(linkedList.size()), Integer.valueOf(linkedList2.size()), Integer.valueOf(linkedList3.size()));
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.ui.chatting.k.e.AnonymousClass8.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(233490);
                            e.this.mDataList.addAll(0, linkedList3);
                            e.this.PEu = 0;
                            Log.i("MicroMsg.MediaHistoryGalleryPresenter", "[loadData] %s", Integer.valueOf(e.this.mDataList.size()));
                            if (e.this.PEy != null) {
                                e.this.PEy.D(z, linkedList3.size());
                            }
                            e.this.PEz.qor = false;
                            AppMethodBeat.o(233490);
                        }
                    });
                    AppMethodBeat.o(233491);
                }
            });
            AppMethodBeat.o(36538);
            return;
        }
        Log.i("MicroMsg.MediaHistoryGalleryPresenter", "[loadData] that's all msg :%s offset:%s", Integer.valueOf(this.tkX), Integer.valueOf(i2));
        AppMethodBeat.o(36538);
    }

    @Override // com.tencent.mm.ui.chatting.f.a.AbstractC2092a
    public final int gRR() {
        AppMethodBeat.i(36523);
        int size = h.a.Pys.tkt.size();
        AppMethodBeat.o(36523);
        return size;
    }

    @Override // com.tencent.mm.ui.chatting.f.a.AbstractC2092a
    public final void cWH() {
        AppMethodBeat.i(36524);
        this.PEz.tkA = true;
        h.a.Pys.tku = true;
        GridLayoutManager gridLayoutManager = (GridLayoutManager) eS(this.mContext);
        int ks = gridLayoutManager.ks();
        this.PEz.e(ks, (gridLayoutManager.ku() - ks) + 1, 0);
        AppMethodBeat.o(36524);
    }

    @Override // com.tencent.mm.ui.chatting.f.a.AbstractC2092a
    public final void cWI() {
        AppMethodBeat.i(36525);
        this.PEz.tkA = false;
        h.a.Pys.clear();
        h.a.Pys.tku = false;
        this.PEz.atj.notifyChanged();
        AppMethodBeat.o(36525);
    }

    @Override // com.tencent.mm.ui.chatting.f.a.AbstractC2092a
    public final boolean cWG() {
        AppMethodBeat.i(36526);
        boolean z = h.a.Pys.tku;
        AppMethodBeat.o(36526);
        return z;
    }

    private static String d(ca caVar, s sVar) {
        String Qw;
        AppMethodBeat.i(36533);
        if (sVar.jsu == -1) {
            Qw = sVar.bhu();
            if (!com.tencent.mm.vfs.s.YS(Qw)) {
                o.bhj();
                Qw = t.Qw(caVar.field_imgPath);
            }
        } else {
            o.bhj();
            Qw = t.Qw(caVar.field_imgPath);
            if (caVar.field_isSend == 1 && sVar.jsx != null && sVar.jsx.Mrn) {
                try {
                    String boZ = com.tencent.mm.vfs.s.boZ(Qw);
                    if (!boZ.endsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
                        boZ = boZ + FilePathGenerator.ANDROID_DIR_SEP;
                    }
                    String str = boZ + com.tencent.mm.vfs.s.bpb(Qw) + "_hd.mp4";
                    boolean YS = com.tencent.mm.vfs.s.YS(str);
                    Log.i("MicroMsg.MediaHistoryGalleryPresenter", "local capture video, hdFilePath: %s, exist: %s", str, Boolean.valueOf(YS));
                    if (!YS) {
                        str = Qw;
                    }
                    Qw = str;
                } catch (Exception e2) {
                    Log.e("MicroMsg.MediaHistoryGalleryPresenter", "try to get hd filePath error: %s", e2.getMessage());
                }
            }
        }
        AppMethodBeat.o(36533);
        return Qw;
    }

    @Override // com.tencent.mm.ui.chatting.f.a.AbstractC2092a
    public final /* bridge */ /* synthetic */ RecyclerView.a cWP() {
        return this.PEz;
    }

    static /* synthetic */ void a(e eVar, long j2, ir irVar) {
        View childAt;
        AppMethodBeat.i(36540);
        Iterator<b.c> it = eVar.PEz.opg.iterator();
        int i2 = -1;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            }
            b.c next = it.next();
            i2++;
            if (next.dTX != null && next.dTX.field_msgId == j2) {
                break;
            }
        }
        GridLayoutManager gridLayoutManager = (GridLayoutManager) eVar.eS(eVar.mContext);
        int ks = gridLayoutManager.ks();
        int ku = gridLayoutManager.ku();
        Log.i("MicroMsg.MediaHistoryGalleryPresenter", "[getPhotoInfo] msgId:%s pos:%s [%s:%s]", Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(ks), Integer.valueOf(ku));
        if (i2 >= ks && i2 <= ku && (childAt = eVar.PEy.getChildAt(i2 - ks)) != null) {
            int[] iArr = new int[2];
            childAt.getLocationInWindow(iArr);
            irVar.dNn.dEq = iArr[0];
            irVar.dNn.dEr = iArr[1];
            irVar.dNn.dEs = childAt.getWidth();
            irVar.dNn.dEt = childAt.getHeight();
        }
        AppMethodBeat.o(36540);
    }

    static /* synthetic */ List jx(List list) {
        AppMethodBeat.i(233496);
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ca caVar = (ca) it.next();
            if (!com.tencent.mm.ui.chatting.gallery.b.cn(caVar) && !com.tencent.mm.ui.chatting.gallery.b.co(caVar) && !com.tencent.mm.ui.chatting.gallery.b.cq(caVar)) {
                arrayList.add(caVar);
            }
        }
        AppMethodBeat.o(233496);
        return arrayList;
    }

    static /* synthetic */ void a(e eVar, final List list) {
        AppMethodBeat.i(233497);
        eVar.PEy.gRT();
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.ui.chatting.k.e.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(233483);
                int jy = e.jy(list);
                if (list.size() == jy) {
                    e.this.mHandler.post(new Runnable() {
                        /* class com.tencent.mm.ui.chatting.k.e.AnonymousClass3.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(36499);
                            e.this.PEy.amL(R.string.dn3);
                            AppMethodBeat.o(36499);
                        }
                    });
                    AppMethodBeat.o(233483);
                    return;
                }
                e.this.PEB = jy > 0;
                LinkedList<ca> b2 = e.b(e.this, list);
                LinkedList<ca> c2 = e.c(e.this, list);
                Log.i("MicroMsg.MediaHistoryGalleryPresenter", "[innerHandleSave] needDownloadImageList size:%s needDownloadVideoList:%s", Integer.valueOf(b2.size()), Integer.valueOf(c2.size()));
                e.this.PEA = b2.size() + c2.size();
                if (NetStatusUtil.isWifi(MMApplicationContext.getContext()) || e.this.PEA != list.size()) {
                    for (ca caVar : b2) {
                        e.a(e.this, caVar, d.k(caVar));
                    }
                    for (ca caVar2 : c2) {
                        e.a(e.this, caVar2);
                    }
                    if (e.this.PEB) {
                        e.this.mHandler.post(new Runnable() {
                            /* class com.tencent.mm.ui.chatting.k.e.AnonymousClass3.AnonymousClass3 */

                            public final void run() {
                                AppMethodBeat.i(233481);
                                e.this.PEy.amL(R.string.dn4);
                                AppMethodBeat.o(233481);
                            }
                        });
                    }
                    if (e.g(e.this) && !e.this.PEB) {
                        e.this.mHandler.post(new Runnable() {
                            /* class com.tencent.mm.ui.chatting.k.e.AnonymousClass3.AnonymousClass4 */

                            public final void run() {
                                AppMethodBeat.i(233482);
                                if (e.this.PEy != null) {
                                    e.this.PEy.gRU();
                                }
                                AppMethodBeat.o(233482);
                            }
                        });
                    }
                    AppMethodBeat.o(233483);
                    return;
                }
                e.this.mHandler.post(new Runnable() {
                    /* class com.tencent.mm.ui.chatting.k.e.AnonymousClass3.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(36500);
                        e.this.PEy.amL(R.string.dn3);
                        AppMethodBeat.o(36500);
                    }
                });
                AppMethodBeat.o(233483);
            }
        }, "handleSave");
        AppMethodBeat.o(233497);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00bb, code lost:
        if (com.tencent.mm.vfs.s.YS(r0) == false) goto L_0x00bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00ff, code lost:
        if (com.tencent.mm.vfs.s.YS(r0) != false) goto L_0x00c0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ int jy(java.util.List r14) {
        /*
        // Method dump skipped, instructions count: 300
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.k.e.jy(java.util.List):int");
    }

    static /* synthetic */ LinkedList b(e eVar, List list) {
        AppMethodBeat.i(36544);
        LinkedList linkedList = new LinkedList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ca caVar = (ca) it.next();
            if (!br.B(caVar)) {
                if (com.tencent.mm.ui.chatting.gallery.b.j(caVar)) {
                    if (!d.k(caVar).bcu()) {
                        linkedList.add(caVar);
                    } else {
                        eVar.PEA--;
                        com.tencent.mm.ui.chatting.gallery.b.d(eVar.mContext, caVar, false);
                    }
                } else if (caVar.getType() == 268435505) {
                    if (Util.isNullOrNil(com.tencent.mm.ui.chatting.gallery.b.l(caVar)) || !new com.tencent.mm.vfs.o(com.tencent.mm.ui.chatting.gallery.b.l(caVar)).exists()) {
                        linkedList.add(caVar);
                    } else {
                        eVar.PEA--;
                        com.tencent.mm.ui.chatting.gallery.b.d(eVar.mContext, caVar, false);
                    }
                }
            }
        }
        AppMethodBeat.o(36544);
        return linkedList;
    }

    static /* synthetic */ LinkedList c(e eVar, List list) {
        AppMethodBeat.i(233499);
        LinkedList linkedList = new LinkedList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ca caVar = (ca) it.next();
            if (!br.B(caVar) && com.tencent.mm.ui.chatting.gallery.b.m(caVar)) {
                if (!com.tencent.mm.ui.chatting.gallery.j.cF(caVar).bhy()) {
                    linkedList.add(caVar);
                } else {
                    eVar.PEA--;
                    com.tencent.mm.ui.chatting.gallery.b.b(eVar.mContext, caVar, false);
                }
            }
        }
        AppMethodBeat.o(233499);
        return linkedList;
    }

    static /* synthetic */ void a(e eVar, final ca caVar, com.tencent.mm.av.g gVar) {
        AppMethodBeat.i(233500);
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(caVar == null);
        objArr[1] = Boolean.valueOf(gVar == null);
        Log.e("MicroMsg.MediaHistoryGalleryPresenter", "[downloadImg] %s %s ", objArr);
        if (caVar == null) {
            AppMethodBeat.o(233500);
        } else if (caVar.getType() == 268435505) {
            m.a(caVar, new m.a() {
                /* class com.tencent.mm.ui.chatting.k.e.AnonymousClass4 */

                @Override // com.tencent.mm.pluginsdk.model.app.m.a
                public final void kA(int i2, int i3) {
                    AppMethodBeat.i(233486);
                    if (i2 == i3) {
                        Log.i("MicroMsg.MediaHistoryGalleryPresenter", "[onSceneProgressEnd] MsgId:%s", Long.valueOf(caVar.field_msgId));
                        e.h(e.this);
                        if (!com.tencent.mm.ui.chatting.gallery.b.d(e.this.mContext, caVar, false)) {
                            e.this.PEB = true;
                        }
                        if (e.g(e.this)) {
                            if (!e.this.PEB) {
                                e.this.mHandler.post(new Runnable() {
                                    /* class com.tencent.mm.ui.chatting.k.e.AnonymousClass4.AnonymousClass1 */

                                    public final void run() {
                                        AppMethodBeat.i(233484);
                                        if (e.this.PEy != null) {
                                            e.this.PEy.gRU();
                                        }
                                        AppMethodBeat.o(233484);
                                    }
                                });
                                AppMethodBeat.o(233486);
                                return;
                            }
                            e.this.mHandler.post(new Runnable() {
                                /* class com.tencent.mm.ui.chatting.k.e.AnonymousClass4.AnonymousClass2 */

                                public final void run() {
                                    AppMethodBeat.i(233485);
                                    if (e.this.PEy != null) {
                                        e.this.PEy.amL(R.string.dn4);
                                    }
                                    AppMethodBeat.o(233485);
                                }
                            });
                        }
                    }
                    AppMethodBeat.o(233486);
                }
            });
            AppMethodBeat.o(233500);
        } else {
            if (gVar != null && q.bcS().a(gVar.localId, caVar.field_msgId, 0, -1, -1, eVar, 0, true) == -2) {
                Log.w("MicroMsg.MediaHistoryGalleryPresenter", "[downloadImg] this img has download! %s", gVar.iXm);
                eVar.PEA--;
                com.tencent.mm.ui.chatting.gallery.b.d(eVar.mContext, caVar, false);
            }
            AppMethodBeat.o(233500);
        }
    }

    static /* synthetic */ void a(e eVar, ca caVar) {
        AppMethodBeat.i(233501);
        s cF = com.tencent.mm.ui.chatting.gallery.j.cF(caVar);
        if (cF == null) {
            Log.e("MicroMsg.MediaHistoryGalleryPresenter", "[saveVideo] info == null");
            AppMethodBeat.o(233501);
            return;
        }
        o.bhj().a(eVar, Looper.getMainLooper());
        if (cF.bhx()) {
            Log.i("MicroMsg.MediaHistoryGalleryPresenter", "start complete online video");
            com.tencent.mm.modelvideo.u.QT(caVar.field_imgPath);
            AppMethodBeat.o(233501);
            return;
        }
        Log.i("MicroMsg.MediaHistoryGalleryPresenter", "start complete offline video");
        com.tencent.mm.modelvideo.u.aA(caVar.field_imgPath, 10);
        com.tencent.mm.modelvideo.u.QI(caVar.field_imgPath);
        AppMethodBeat.o(233501);
    }
}
