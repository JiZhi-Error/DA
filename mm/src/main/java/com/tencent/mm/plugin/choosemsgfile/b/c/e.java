package com.tencent.mm.plugin.choosemsgfile.b.c;

import android.database.Cursor;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.plugin.choosemsgfile.b.a.b;
import com.tencent.mm.plugin.choosemsgfile.b.b.a;
import com.tencent.mm.plugin.choosemsgfile.b.b.i;
import com.tencent.mm.plugin.choosemsgfile.b.b.n;
import com.tencent.mm.plugin.choosemsgfile.b.c.g;
import com.tencent.mm.plugin.choosemsgfile.ui.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storage.ca;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e extends b {
    public LinearLayoutManager oDV;
    protected List<a> opg = new ArrayList();
    d qos;

    public e(c cVar) {
        super(cVar);
        AppMethodBeat.i(123322);
        AppMethodBeat.o(123322);
    }

    public final RecyclerView.a cyF() {
        AppMethodBeat.i(123323);
        this.qos = new d(this.qon, this.opg);
        a.qoq = new g.b() {
            /* class com.tencent.mm.plugin.choosemsgfile.b.c.e.AnonymousClass4 */
        };
        this.qos.qop = new g.a() {
            /* class com.tencent.mm.plugin.choosemsgfile.b.c.e.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.choosemsgfile.b.c.g.a
            public final void a(boolean z, final a aVar, final RecyclerView.v vVar) {
                AppMethodBeat.i(123317);
                if (aVar == null) {
                    Log.e("MicroMsg.ChooseMsgFileListUIController", "[onCheck] item is null, err");
                    AppMethodBeat.o(123317);
                    return;
                }
                Log.i("MicroMsg.ChooseMsgFileListUIController", "[onCheck] isChecked :%b", Boolean.valueOf(z));
                if (z) {
                    aVar.cyu();
                    e.a(e.this).BZ(aVar.qnv.field_msgId);
                    b.a(aVar, new com.tencent.mm.plugin.choosemsgfile.b.a.a() {
                        /* class com.tencent.mm.plugin.choosemsgfile.b.c.e.AnonymousClass1.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.choosemsgfile.b.a.a
                        public final void a(MsgFile msgFile) {
                            AppMethodBeat.i(123311);
                            Log.i("MicroMsg.ChooseMsgFileListUIController", "item:%s onDownloadSuccess msgFile:%s", aVar, msgFile);
                            e.a(e.this).Ca(aVar.qnv.field_msgId);
                            e.a(e.this).a(aVar.qnv.field_msgId, msgFile);
                            if (e.a(e.this).cyG()) {
                                MMHandlerThread.postToMainThread(new Runnable() {
                                    /* class com.tencent.mm.plugin.choosemsgfile.b.c.e.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                    public final void run() {
                                        AppMethodBeat.i(123310);
                                        e.this.qos.atj.notifyChanged();
                                        AppMethodBeat.o(123310);
                                    }
                                });
                            }
                            e.this.qon.cyJ();
                            aVar.cyv();
                            a aVar = (a) ((n) vVar).qnZ.getTag();
                            if (aVar.equals(aVar)) {
                                aVar.V(vVar);
                            }
                            AppMethodBeat.o(123311);
                        }

                        @Override // com.tencent.mm.plugin.choosemsgfile.b.a.a
                        public final void cyk() {
                            AppMethodBeat.i(123312);
                            Log.e("MicroMsg.ChooseMsgFileListUIController", "item:%s onDownloadFails", aVar);
                            e.a(e.this).Ca(aVar.qnv.field_msgId);
                            aVar.cyx();
                            a aVar = (a) ((n) vVar).qnZ.getTag();
                            if (aVar.equals(aVar)) {
                                aVar.V(vVar);
                            }
                            AppMethodBeat.o(123312);
                        }

                        @Override // com.tencent.mm.plugin.choosemsgfile.b.a.a
                        public final void cyl() {
                            AppMethodBeat.i(123313);
                            Log.i("MicroMsg.ChooseMsgFileListUIController", "item:%s onDownloadPause", aVar);
                            e.a(e.this).Ca(aVar.qnv.field_msgId);
                            aVar.cyy();
                            a aVar = (a) ((n) vVar).qnZ.getTag();
                            if (aVar.equals(aVar)) {
                                aVar.V(vVar);
                            }
                            AppMethodBeat.o(123313);
                        }

                        @Override // com.tencent.mm.plugin.choosemsgfile.b.a.a
                        public final void cym() {
                            AppMethodBeat.i(123314);
                            Log.e("MicroMsg.ChooseMsgFileListUIController", "item:%s onExpireFail", aVar);
                            e.a(e.this).Ca(aVar.qnv.field_msgId);
                            aVar.cyw();
                            a aVar = (a) ((n) vVar).qnZ.getTag();
                            if (aVar.equals(aVar)) {
                                aVar.V(vVar);
                            }
                            AppMethodBeat.o(123314);
                        }

                        @Override // com.tencent.mm.plugin.choosemsgfile.b.a.a
                        public final void fk(int i2, int i3) {
                            AppMethodBeat.i(123315);
                            Log.e("MicroMsg.ChooseMsgFileListUIController", "item:%s onDownloadProgress offset:%d totalLen:%d", aVar, Integer.valueOf(i2), Integer.valueOf(i3));
                            aVar.fm(i2, i3);
                            a aVar = (a) ((n) vVar).qnZ.getTag();
                            if (aVar.equals(aVar)) {
                                aVar.V(vVar);
                            }
                            AppMethodBeat.o(123315);
                        }
                    }, e.this.cyE());
                } else {
                    aVar.cyy();
                    e.a(e.this).Ca(aVar.qnv.field_msgId);
                    e.a(e.this).BX(aVar.qnv.field_msgId);
                    if (e.a(e.this).cyG()) {
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.choosemsgfile.b.c.e.AnonymousClass1.AnonymousClass2 */

                            public final void run() {
                                AppMethodBeat.i(123316);
                                e.this.qos.atj.notifyChanged();
                                AppMethodBeat.o(123316);
                            }
                        });
                    }
                    e.this.qon.cyJ();
                }
                aVar.V(vVar);
                AppMethodBeat.o(123317);
            }
        };
        d dVar = this.qos;
        AppMethodBeat.o(123323);
        return dVar;
    }

    @Override // com.tencent.mm.plugin.choosemsgfile.b.c.h
    public final void c(final boolean z, String str, final String str2) {
        AppMethodBeat.i(123324);
        Log.i("MicroMsg.ChooseMsgFileListUIController", "[loadData] isFirst:%s", Boolean.valueOf(z));
        this.qon.kF(z);
        if (z) {
            this.opg.clear();
        }
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.choosemsgfile.b.c.e.AnonymousClass2 */

            public final void run() {
                long j2;
                k.b HD;
                boolean z;
                AppMethodBeat.i(123319);
                LinkedList linkedList = new LinkedList();
                Cursor ez = ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().ez(e.this.goe, -1);
                if (ez == null) {
                    Log.e("MicroMsg.ChooseMsgFileListUIController", "[loadData] cursor is null!");
                    AppMethodBeat.o(123319);
                    return;
                }
                List<String> akz = com.tencent.mm.plugin.choosemsgfile.b.d.c.akz(str2);
                long j3 = 0;
                while (ez.moveToNext()) {
                    try {
                        ca caVar = new ca();
                        caVar.convertFrom(ez);
                        String str = caVar.field_content;
                        if (str == null || (HD = k.b.HD(str)) == null || HD.type != 6) {
                            j2 = j3;
                        } else {
                            com.tencent.mm.plugin.choosemsgfile.b.b.k kVar = new com.tencent.mm.plugin.choosemsgfile.b.b.k(e.this.qos, caVar, e.this.goe);
                            if (akz.size() != 0) {
                                Iterator<String> it = akz.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        if (kVar.getFileName().endsWith(it.next())) {
                                            z = true;
                                            break;
                                        }
                                    } else {
                                        z = false;
                                        break;
                                    }
                                }
                            } else {
                                z = true;
                            }
                            if (z) {
                                j2 = com.tencent.mm.ui.gridviewheaders.a.gWr().b(new Date(caVar.field_createTime));
                                if (j3 != j2) {
                                    linkedList.add(new i(e.this.qos, caVar.field_createTime));
                                }
                                linkedList.add(kVar);
                            }
                        }
                        j3 = j2;
                    } catch (Throwable th) {
                        ez.close();
                        AppMethodBeat.o(123319);
                        throw th;
                    }
                }
                ez.close();
                e.this.opg.addAll(linkedList);
                linkedList.clear();
                Log.i("MicroMsg.ChooseMsgFileListUIController", "[loadData] data:%s", Integer.valueOf(e.this.opg.size()));
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.choosemsgfile.b.c.e.AnonymousClass2.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(123318);
                        if (e.this.qon != null) {
                            e.this.qon.D(z, e.this.opg.size());
                        }
                        AppMethodBeat.o(123318);
                    }
                });
                AppMethodBeat.o(123319);
            }
        });
        AppMethodBeat.o(123324);
    }

    static /* synthetic */ com.tencent.mm.plugin.choosemsgfile.b.d.a a(e eVar) {
        AppMethodBeat.i(123325);
        com.tencent.mm.plugin.choosemsgfile.b.d.a cys = eVar.qon.cys();
        AppMethodBeat.o(123325);
        return cys;
    }
}
