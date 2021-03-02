package com.tencent.mm.plugin.choosemsgfile.b.c;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.g.a.ir;
import com.tencent.mm.plugin.choosemsgfile.b.a.b;
import com.tencent.mm.plugin.choosemsgfile.b.b.a;
import com.tencent.mm.plugin.choosemsgfile.b.b.m;
import com.tencent.mm.plugin.choosemsgfile.b.c.g;
import com.tencent.mm.plugin.choosemsgfile.ui.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storage.ca;
import java.util.Date;
import java.util.LinkedList;

public final class f extends b {
    int fs = 0;
    public c qoB;
    private IListener qoC = new IListener<ir>() {
        /* class com.tencent.mm.plugin.choosemsgfile.b.c.f.AnonymousClass1 */

        {
            AppMethodBeat.i(161582);
            this.__eventId = ir.class.getName().hashCode();
            AppMethodBeat.o(161582);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ir irVar) {
            AppMethodBeat.i(123326);
            ir irVar2 = irVar;
            f.a(f.this, irVar2.dNm.msgId, irVar2);
            AppMethodBeat.o(123326);
            return false;
        }
    };
    private GridLayoutManager qoD;
    int qoE = 0;

    static /* synthetic */ int b(f fVar) {
        int i2 = fVar.fs;
        fVar.fs = i2 + 1;
        return i2;
    }

    static /* synthetic */ int c(f fVar) {
        int i2 = fVar.qoE;
        fVar.qoE = i2 + 1;
        return i2;
    }

    public f(c cVar) {
        super(cVar);
        AppMethodBeat.i(123339);
        AppMethodBeat.o(123339);
    }

    @Override // com.tencent.mm.plugin.choosemsgfile.b.c.b
    public final void fC(String str, String str2) {
        AppMethodBeat.i(123340);
        Log.i("MicroMsg.ChooseMsgFileUIController", "onCreate");
        this.qoC.alive();
        c(true, str, str2);
        AppMethodBeat.o(123340);
    }

    @Override // com.tencent.mm.plugin.choosemsgfile.b.c.b
    public final void onResume() {
        AppMethodBeat.i(123341);
        Log.i("MicroMsg.ChooseMsgFileUIController", "onResume");
        this.qoB.atj.notifyChanged();
        AppMethodBeat.o(123341);
    }

    @Override // com.tencent.mm.plugin.choosemsgfile.b.c.b
    public final void onPause() {
        AppMethodBeat.i(123342);
        Log.i("MicroMsg.ChooseMsgFileUIController", "onPause");
        AppMethodBeat.o(123342);
    }

    @Override // com.tencent.mm.plugin.choosemsgfile.b.c.b
    public final void onDestroy() {
        AppMethodBeat.i(123343);
        Log.i("MicroMsg.ChooseMsgFileUIController", "onDestroy");
        this.qoC.dead();
        AppMethodBeat.o(123343);
    }

    public final RecyclerView.a cyF() {
        AppMethodBeat.i(123344);
        this.qoB = new c(this.qon, this.mDataList);
        this.qoB.qop = new g.a() {
            /* class com.tencent.mm.plugin.choosemsgfile.b.c.f.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.choosemsgfile.b.c.g.a
            public final void a(boolean z, final a aVar, final RecyclerView.v vVar) {
                AppMethodBeat.i(123334);
                if (aVar == null) {
                    Log.e("MicroMsg.ChooseMsgFileUIController", "[onCheck] item is null, err");
                    AppMethodBeat.o(123334);
                    return;
                }
                Log.i("MicroMsg.ChooseMsgFileUIController", "[onCheck] isChecked:%b", Boolean.valueOf(z));
                if (z) {
                    aVar.cyu();
                    f.a(f.this).BZ(aVar.qnv.field_msgId);
                    b.a(aVar, new com.tencent.mm.plugin.choosemsgfile.b.a.a() {
                        /* class com.tencent.mm.plugin.choosemsgfile.b.c.f.AnonymousClass2.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.choosemsgfile.b.a.a
                        public final void a(MsgFile msgFile) {
                            AppMethodBeat.i(123328);
                            Log.i("MicroMsg.ChooseMsgFileUIController", "item:%s onDownloadSuccess msgFile:%s", aVar, msgFile);
                            f.a(f.this).Ca(aVar.qnv.field_msgId);
                            f.a(f.this).a(aVar.qnv.field_msgId, msgFile);
                            if (f.a(f.this).cyG()) {
                                MMHandlerThread.postToMainThread(new Runnable() {
                                    /* class com.tencent.mm.plugin.choosemsgfile.b.c.f.AnonymousClass2.AnonymousClass1.AnonymousClass1 */

                                    public final void run() {
                                        AppMethodBeat.i(123327);
                                        f.this.qoB.atj.notifyChanged();
                                        AppMethodBeat.o(123327);
                                    }
                                });
                            }
                            f.this.qon.cyJ();
                            aVar.cyv();
                            a aVar = (a) ((m) vVar).puw.getTag();
                            if (aVar.equals(aVar)) {
                                aVar.V(vVar);
                            }
                            AppMethodBeat.o(123328);
                        }

                        @Override // com.tencent.mm.plugin.choosemsgfile.b.a.a
                        public final void cyk() {
                            AppMethodBeat.i(123329);
                            Log.e("MicroMsg.ChooseMsgFileUIController", "item:%s onDownloadFails", aVar);
                            f.a(f.this).Ca(aVar.qnv.field_msgId);
                            aVar.cyx();
                            a aVar = (a) ((m) vVar).puw.getTag();
                            if (aVar.equals(aVar)) {
                                aVar.V(vVar);
                            }
                            AppMethodBeat.o(123329);
                        }

                        @Override // com.tencent.mm.plugin.choosemsgfile.b.a.a
                        public final void cyl() {
                            AppMethodBeat.i(123330);
                            Log.i("MicroMsg.ChooseMsgFileUIController", "item:%s onDownloadPause", aVar);
                            f.a(f.this).Ca(aVar.qnv.field_msgId);
                            aVar.cyy();
                            a aVar = (a) ((m) vVar).puw.getTag();
                            if (aVar.equals(aVar)) {
                                aVar.V(vVar);
                            }
                            AppMethodBeat.o(123330);
                        }

                        @Override // com.tencent.mm.plugin.choosemsgfile.b.a.a
                        public final void cym() {
                            AppMethodBeat.i(123331);
                            Log.e("MicroMsg.ChooseMsgFileUIController", "item:%s onExpireFail", aVar);
                            f.a(f.this).Ca(aVar.qnv.field_msgId);
                            aVar.cyw();
                            a aVar = (a) ((m) vVar).puw.getTag();
                            if (aVar.equals(aVar)) {
                                aVar.V(vVar);
                            }
                            AppMethodBeat.o(123331);
                        }

                        @Override // com.tencent.mm.plugin.choosemsgfile.b.a.a
                        public final void fk(int i2, int i3) {
                            AppMethodBeat.i(123332);
                            Log.e("MicroMsg.ChooseMsgFileUIController", "item:%s onDownloadProgress offset:%d totalLen:%d", aVar, Integer.valueOf(i2), Integer.valueOf(i3));
                            aVar.fm(i2, i3);
                            a aVar = (a) ((m) vVar).puw.getTag();
                            if (aVar.equals(aVar)) {
                                aVar.V(vVar);
                            }
                            AppMethodBeat.o(123332);
                        }
                    }, f.this.cyE());
                } else {
                    aVar.cyy();
                    f.a(f.this).Ca(aVar.qnv.field_msgId);
                    f.a(f.this).BX(aVar.qnv.field_msgId);
                    if (f.a(f.this).cyG()) {
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.choosemsgfile.b.c.f.AnonymousClass2.AnonymousClass2 */

                            public final void run() {
                                AppMethodBeat.i(123333);
                                f.this.qoB.atj.notifyChanged();
                                AppMethodBeat.o(123333);
                            }
                        });
                    }
                    f.this.qon.cyJ();
                }
                aVar.V(vVar);
                AppMethodBeat.o(123334);
            }
        };
        c cVar = this.qoB;
        AppMethodBeat.o(123344);
        return cVar;
    }

    public final <T extends RecyclerView.LayoutManager> T eS(Context context) {
        AppMethodBeat.i(237144);
        if (this.qoD == null) {
            this.qoD = new GridLayoutManager(4);
            this.qoD.apR = new GridLayoutManager.b() {
                /* class com.tencent.mm.plugin.choosemsgfile.b.c.f.AnonymousClass3 */

                @Override // android.support.v7.widget.GridLayoutManager.b
                public final int bX(int i2) {
                    AppMethodBeat.i(123335);
                    if (((a) f.this.mDataList.get(i2)).getType() == 0) {
                        AppMethodBeat.o(123335);
                        return 4;
                    }
                    AppMethodBeat.o(123335);
                    return 1;
                }
            };
        }
        GridLayoutManager gridLayoutManager = this.qoD;
        AppMethodBeat.o(237144);
        return gridLayoutManager;
    }

    @Override // com.tencent.mm.plugin.choosemsgfile.b.c.h
    public final void c(final boolean z, final String str, final String str2) {
        AppMethodBeat.i(123346);
        if (z) {
            this.mDataList.clear();
            this.fs = 0;
        }
        this.qoB.qor = true;
        this.qon.kF(z);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.choosemsgfile.b.c.f.AnonymousClass5 */

            public final void run() {
                long j2;
                AppMethodBeat.i(123338);
                LinkedList linkedList = new LinkedList();
                Cursor eB = ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().eB(f.this.goe, f.this.fs);
                if (eB == null) {
                    Log.e("MicroMsg.ChooseMsgFileUIController", "[loadData] NULL == cursor ");
                    AppMethodBeat.o(123338);
                    return;
                }
                long j3 = 0;
                while (eB.moveToNext()) {
                    try {
                        f.b(f.this);
                        ca caVar = new ca();
                        caVar.convertFrom(eB);
                        a a2 = com.tencent.mm.plugin.choosemsgfile.b.d.c.a(f.this.qoB, caVar, f.this.goe, str, str2);
                        if (a2 != null) {
                            j2 = com.tencent.mm.ui.gridviewheaders.a.gWr().b(new Date(caVar.field_createTime));
                            if (j3 != j2) {
                                linkedList.add(new com.tencent.mm.plugin.choosemsgfile.b.b.c(f.this.qoB, caVar.field_createTime));
                                f.c(f.this);
                            }
                            linkedList.add(a2);
                        } else {
                            j2 = j3;
                        }
                        j3 = j2;
                    } catch (Throwable th) {
                        eB.close();
                        AppMethodBeat.o(123338);
                        throw th;
                    }
                }
                eB.close();
                LinkedList linkedList2 = new LinkedList();
                if (linkedList.size() - f.this.qoE == 200) {
                    long timeStamp = ((a) linkedList.get(0)).getTimeStamp();
                    com.tencent.mm.ui.gridviewheaders.a.gWr();
                    long NX = com.tencent.mm.ui.gridviewheaders.a.NX(timeStamp);
                    Log.i("MicroMsg.ChooseMsgFileUIController", "[loadData] list size:%s start:%s end:%s", Integer.valueOf(linkedList.size()), Long.valueOf(NX), Long.valueOf(timeStamp));
                    Cursor C = ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().C(f.this.goe, NX, timeStamp);
                    Date date = new Date(timeStamp);
                    long b2 = com.tencent.mm.ui.gridviewheaders.a.gWr().b(date);
                    while (C != null) {
                        try {
                            if (!C.moveToNext()) {
                                break;
                            }
                            f.b(f.this);
                            ca caVar2 = new ca();
                            caVar2.convertFrom(C);
                            a a3 = com.tencent.mm.plugin.choosemsgfile.b.d.c.a(f.this.qoB, caVar2, f.this.goe, str, str2);
                            if (a3 != null) {
                                long b3 = com.tencent.mm.ui.gridviewheaders.a.gWr().b(new Date(caVar2.field_createTime));
                                if (b2 != b3 && com.tencent.mm.ui.gridviewheaders.a.gWr().b(date) != b3) {
                                    linkedList2.add(new com.tencent.mm.plugin.choosemsgfile.b.b.c(f.this.qoB, caVar2.field_createTime));
                                    f.c(f.this);
                                    b2 = b3;
                                } else if (linkedList.size() > 0 && linkedList2.size() == 0) {
                                    linkedList2.add(0, linkedList.remove(0));
                                }
                                linkedList2.add(a3);
                            }
                        } catch (Throwable th2) {
                            if (C != null) {
                                C.close();
                            }
                            AppMethodBeat.o(123338);
                            throw th2;
                        }
                    }
                    if (C != null) {
                        C.close();
                    }
                }
                final int size = linkedList.size() + linkedList2.size();
                f.this.mDataList.addAll(0, linkedList2);
                f.this.mDataList.addAll(linkedList2.size(), linkedList);
                linkedList.clear();
                linkedList2.clear();
                f.this.qoE = 0;
                Log.i("MicroMsg.ChooseMsgFileUIController", "[loadData] %s", Integer.valueOf(f.this.mDataList.size()));
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.choosemsgfile.b.c.f.AnonymousClass5.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(123337);
                        f.this.qoB.qor = false;
                        f.this.qon.D(z, size);
                        AppMethodBeat.o(123337);
                    }
                });
                AppMethodBeat.o(123338);
            }
        });
        AppMethodBeat.o(123346);
    }

    static /* synthetic */ void a(f fVar, long j2, ir irVar) {
        View childAt;
        AppMethodBeat.i(123347);
        int BW = fVar.qoB.BW(j2);
        GridLayoutManager gridLayoutManager = (GridLayoutManager) fVar.eS(fVar.qon.getContext());
        int ks = gridLayoutManager.ks();
        int ku = gridLayoutManager.ku();
        Log.i("MicroMsg.ChooseMsgFileUIController", "[getPhotoInfo] msgId:%s pos:%s [%s:%s]", Long.valueOf(j2), Integer.valueOf(BW), Integer.valueOf(ks), Integer.valueOf(ku));
        if (BW >= ks && BW <= ku && (childAt = fVar.qon.getChildAt(BW - ks)) != null) {
            int[] iArr = new int[2];
            childAt.getLocationInWindow(iArr);
            irVar.dNn.dEq = iArr[0];
            irVar.dNn.dEr = iArr[1];
            irVar.dNn.dEs = childAt.getWidth();
            irVar.dNn.dEt = childAt.getHeight();
        }
        AppMethodBeat.o(123347);
    }

    static /* synthetic */ com.tencent.mm.plugin.choosemsgfile.b.d.a a(f fVar) {
        AppMethodBeat.i(123348);
        com.tencent.mm.plugin.choosemsgfile.b.d.a cys = fVar.qon.cys();
        AppMethodBeat.o(123348);
        return cys;
    }
}
