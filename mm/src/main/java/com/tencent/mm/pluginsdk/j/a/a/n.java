package com.tencent.mm.pluginsdk.j.a.a;

import android.database.Cursor;
import android.database.SQLException;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.pluginsdk.j.a.a.a.a;
import com.tencent.mm.pluginsdk.j.a.a.i;
import com.tencent.mm.pluginsdk.j.a.c.q;
import com.tencent.mm.protocal.protobuf.dov;
import com.tencent.mm.protocal.protobuf.doz;
import com.tencent.mm.protocal.protobuf.dpa;
import com.tencent.mm.protocal.protobuf.dpb;
import com.tencent.mm.protocal.protobuf.zi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storagebase.h;
import com.tencent.wcdb.database.SQLiteException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public abstract class n extends q implements m {
    protected static final SparseArray<a> JZD = new SparseArray<>();
    protected final List<dpb> JZC = new LinkedList();
    private volatile i callback;

    /* access modifiers changed from: protected */
    public abstract String getTag();

    /* access modifiers changed from: protected */
    public abstract s gnS();

    /* access modifiers changed from: protected */
    public abstract zi h(s sVar);

    static /* synthetic */ void a(n nVar, int i2, dov dov) {
        if (dov != null) {
            Log.i(nVar.getTag(), "handleOperation --START--, resType = %d, subType = %d, res.Oper = %d", Integer.valueOf(i2), Integer.valueOf(dov.MJT), Integer.valueOf(dov.LWr));
            if (dov.MSk != null) {
                Log.i(nVar.getTag(), "resource.Info.FileFlag %d ", Integer.valueOf(dov.MSk.MSv));
            }
            if (i.b.ahT(dov.LWr)) {
                Log.i(nVar.getTag(), "just do nothing");
                return;
            }
            if (i.b.ahU(dov.LWr)) {
                Log.i(nVar.getTag(), "do cache");
                b.gnC().b(i2, dov, false);
            }
            if (i.b.ahV(dov.LWr)) {
                Log.i(nVar.getTag(), "do decrypt");
                b.gnC().a(i2, dov, false, false);
            }
            if (i.b.ahW(dov.LWr)) {
                Log.i(nVar.getTag(), "do delete");
                b.gnC().a(i2, dov, false);
            }
            Log.i(nVar.getTag(), "handleOperation --END--, resType = %d, subType = %d, res.Oper = %d", Integer.valueOf(i2), Integer.valueOf(dov.MJT), Integer.valueOf(dov.LWr));
        }
    }

    public static void a(a aVar) {
        JZD.put(39, aVar);
    }

    n() {
        int[] iArr = i.JZf;
        for (int i2 : iArr) {
            a aVar = JZD.get(i2);
            if (aVar == null || !aVar.CI(i2)) {
                dpb dpb = new dpb();
                dpb.oUv = i2;
                this.JZC.add(dpb);
            }
        }
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, com.tencent.mm.ak.i iVar) {
        h hVar;
        List<com.tencent.mm.pluginsdk.j.a.c.s> emptyList;
        this.callback = iVar;
        Log.d(getTag(), "before dispatch");
        try {
            for (dpb dpb : this.JZC) {
                int i2 = dpb.oUv;
                com.tencent.mm.pluginsdk.j.a.c.q qVar = q.a.Kan;
                if (!qVar.lsb) {
                    hVar = null;
                } else {
                    hVar = qVar.Kak.iFy;
                }
                if (hVar == null) {
                    emptyList = Collections.emptyList();
                } else {
                    Cursor query = hVar.query("ResDownloaderRecordTable", null, "urlKey" + String.format(Locale.US, " like '%d.%%.data'", Integer.valueOf(i2)) + " and groupId1=" + String.format(Locale.US, "'%s'", "CheckResUpdate"), null, null, null, null, 2);
                    if (query == null || query.isClosed()) {
                        emptyList = Collections.emptyList();
                    } else {
                        if (query.moveToFirst()) {
                            emptyList = new LinkedList();
                            do {
                                com.tencent.mm.pluginsdk.j.a.c.s sVar = new com.tencent.mm.pluginsdk.j.a.c.s();
                                sVar.convertFrom(query);
                                emptyList.add(sVar);
                            } while (query.moveToNext());
                        } else {
                            emptyList = Collections.emptyList();
                        }
                        query.close();
                    }
                }
                StringBuilder sb = new StringBuilder("{ ");
                for (com.tencent.mm.pluginsdk.j.a.c.s sVar2 : emptyList) {
                    int i3 = Util.getInt(sVar2.field_fileVersion, -1);
                    if (i3 >= 0) {
                        if (37 == sVar2.field_resType) {
                            b.gnC();
                            if (TextUtils.isEmpty(b.kC(sVar2.field_resType, sVar2.field_subType))) {
                            }
                        }
                        doz doz = new doz();
                        doz.MJT = sVar2.field_subType;
                        doz.MSu = i3;
                        doz.MSs = sVar2.field_keyVersion;
                        doz.JZb = sVar2.field_EID;
                        dpb.MSA.add(doz);
                        sb.append(sVar2.field_subType).append(", ");
                    }
                }
                sb.append(" }");
                Log.i(getTag(), "before doScene, add subtypeList(%s) in type(%d)", sb.toString(), Integer.valueOf(dpb.oUv));
            }
            return dispatch(gVar, gnS(), this);
        } catch (SQLException | SQLiteException e2) {
            Log.e(getTag(), "doScene get SQLException(%s), return -1", e2);
            return -1;
        }
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        Log.i(getTag(), "onGYNetEnd errType(%d), errCode(%d)", Integer.valueOf(i3), Integer.valueOf(i4));
        if (i3 == 0 && i4 == 0) {
            zi h2 = h(sVar);
            String tag = getTag();
            Object[] objArr = new Object[1];
            objArr[0] = Util.isNullOrNil(h2.LkC) ? BuildConfig.COMMAND : String.valueOf(h2.LkC.size());
            Log.i(tag, "response.Res.size() = %s", objArr);
            if (!Util.isNullOrNil(h2.LkC)) {
                final LinkedList<dpa> linkedList = h2.LkC;
                ThreadPool.post(new Runnable() {
                    /* class com.tencent.mm.pluginsdk.j.a.a.n.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(152002);
                        for (dpa dpa : linkedList) {
                            String tag = n.this.getTag();
                            Object[] objArr = new Object[2];
                            objArr[0] = Integer.valueOf(dpa.oUv);
                            objArr[1] = Util.isNullOrNil(dpa.MSz) ? BuildConfig.COMMAND : String.valueOf(dpa.MSz.size());
                            Log.i(tag, "resType(%d) responses.size() = %s", objArr);
                            if (!Util.isNullOrNil(dpa.MSz)) {
                                Iterator<dov> it = dpa.MSz.iterator();
                                while (it.hasNext()) {
                                    n.a(n.this, dpa.oUv, it.next());
                                }
                            }
                        }
                        AppMethodBeat.o(152002);
                    }
                }, "NetSceneCheckResUpdate-ResponseHandlingThread");
            }
        }
        this.callback.onSceneEnd(i3, i4, str, this);
    }
}
