package com.tencent.i.a;

import android.content.Context;
import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.tencent.h.c.h;
import com.tencent.i.a.a.c;
import com.tencent.i.a.a.e;
import com.tencent.i.a.b.a.b;
import com.tencent.i.a.b.b.a;
import com.tencent.i.a.h;
import com.tencent.i.a.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class l extends a {
    com.tencent.i.a.e.a SqD = new com.tencent.i.a.e.a(this.SqM.mAppContext);
    private final com.tencent.h.a.a SqE = new com.tencent.h.a.a() {
        /* class com.tencent.i.a.l.AnonymousClass1 */

        @Override // com.tencent.h.a.a
        public final void boF() {
            AppMethodBeat.i(214671);
            h.i("sensor_TuringSMIImpl", "[method: mTimeOutRunnable ] ");
            l lVar = l.this;
            i.a hpZ = i.hpZ();
            hpZ.Sqx = false;
            lVar.b(hpZ);
            AppMethodBeat.o(214671);
        }
    };

    public l(Context context, m mVar) {
        super(context, mVar);
        AppMethodBeat.i(214673);
        AppMethodBeat.o(214673);
    }

    public final boolean a(final h.a aVar, final e eVar) {
        AppMethodBeat.i(214674);
        AnonymousClass2 r0 = new com.tencent.i.a.c.a() {
            /* class com.tencent.i.a.l.AnonymousClass2 */

            @Override // com.tencent.i.a.c.a
            public final void a(int i2, com.tencent.i.a.c.b.a aVar) {
                com.tencent.i.a.c.b.a aVar2;
                String str;
                String str2;
                AppMethodBeat.i(214672);
                if (eVar == null) {
                    AppMethodBeat.o(214672);
                    return;
                }
                if (i2 != 0 || aVar == null) {
                    aVar2 = l.a(l.this, (com.tencent.i.a.c.b.a) null);
                } else {
                    aVar2 = l.a(l.this, aVar);
                }
                com.tencent.i.a.e.a aVar3 = l.this.SqD;
                if (aVar.Sqr == c.GESTURETYPE_MULTI) {
                    str = "TeenyProto";
                } else {
                    str = "masterRecoV2New";
                }
                if (aVar.Sqr == c.GESTURETYPE_MULTI) {
                    str2 = "teenyProtoCheckWup";
                } else {
                    str2 = "ownerRecoV2Wup";
                }
                eVar.bW(aVar3.a(str, str2, aVar2));
                AppMethodBeat.o(214672);
            }
        };
        this.SqM.SqQ.a(this.SqE);
        boolean a2 = a(aVar, r0);
        if (a2) {
            com.tencent.h.c.h.i("sensor_TuringSMIImpl", "[method: start ] post mTimeOutRunnable");
            e eVar2 = this.SqM.SqQ;
            com.tencent.h.a.a aVar2 = this.SqE;
            if (aVar2 != null) {
                eVar2.Son.postDelayed(aVar2, 1200000);
            }
        }
        AppMethodBeat.o(214674);
        return a2;
    }

    public final boolean a(i.a aVar) {
        AppMethodBeat.i(214675);
        boolean z = false;
        try {
            z = b(aVar);
            this.SqM.SqQ.a(this.SqE);
            com.tencent.h.c.h.i("sensor_TuringSMIImpl", "[method: stop ] remove mTimeOutRunnable");
        } catch (Throwable th) {
            if (!(this.SqM == null || this.SqM.SqP == null)) {
                this.SqM.SqP.b(th, "stop");
            }
        }
        AppMethodBeat.o(214675);
        return z;
    }

    /* access modifiers changed from: package-private */
    public final boolean b(i.a aVar) {
        AppMethodBeat.i(214676);
        boolean z = false;
        try {
            z = this.Srk.a(aVar);
            com.tencent.h.c.h.i("sensor_TuringSMIImpl", "[method: stopMasterEngine ] ");
        } catch (Throwable th) {
            if (!(this.SqM == null || this.SqM.SqP == null)) {
                this.SqM.SqP.b(th, "stop");
            }
        }
        AppMethodBeat.o(214676);
        return z;
    }

    static /* synthetic */ com.tencent.i.a.c.b.a a(l lVar, com.tencent.i.a.c.b.a aVar) {
        ArrayList<String> arrayList;
        ArrayList arrayList2;
        byte[] cV;
        com.tencent.i.a.b.a.a a2;
        AppMethodBeat.i(214677);
        b.hqm();
        c cVar = lVar.SqM;
        b.hqm();
        b.hqn();
        if (cVar == null) {
            arrayList2 = null;
        } else {
            com.tencent.i.a.d.b bVar = cVar.SqR;
            if (bVar.SqM == null) {
                arrayList = null;
            } else {
                File i2 = com.tencent.i.a.d.a.i(bVar.Stt.lv(bVar.SqM.mAppContext), "2");
                if (i2 == null) {
                    arrayList = null;
                } else {
                    File[] brd = com.tencent.i.a.d.a.brd(i2.getAbsolutePath());
                    if (brd == null) {
                        arrayList = null;
                    } else {
                        ArrayList arrayList3 = new ArrayList();
                        int i3 = 0;
                        for (File file : brd) {
                            if (i3 >= 5) {
                                break;
                            }
                            String absolutePath = file.getAbsolutePath();
                            if (!TextUtils.isEmpty(absolutePath)) {
                                i3++;
                                arrayList3.add(absolutePath);
                            }
                        }
                        arrayList = arrayList3;
                    }
                }
            }
            if (arrayList == null || arrayList.isEmpty()) {
                arrayList2 = null;
            } else {
                ArrayList arrayList4 = new ArrayList();
                ArrayList arrayList5 = new ArrayList();
                ArrayList arrayList6 = new ArrayList();
                for (String str : arrayList) {
                    if (TextUtils.isEmpty(str)) {
                        cV = null;
                    } else {
                        byte[] o = com.tencent.h.c.b.o(com.tencent.h.c.e.aa(new File(str)), com.tencent.h.c.b.hkP());
                        cV = o == null ? null : com.tencent.h.c.a.cV(o);
                    }
                    if (cV != null && cV.length > 0) {
                        d dVar = new d();
                        dVar.readFrom(new JceInputStream(cV));
                        arrayList5.add(str);
                        arrayList6.add(dVar);
                        if (arrayList6.size() >= 5 && (a2 = b.a(cVar, arrayList6, arrayList5)) != null) {
                            arrayList4.add(a2);
                        }
                    }
                }
                com.tencent.i.a.b.a.a a3 = b.a(cVar, arrayList6, arrayList5);
                if (a3 != null) {
                    arrayList4.add(a3);
                }
                arrayList2 = arrayList4;
            }
        }
        com.tencent.i.a.b.a.a aVar2 = (arrayList2 == null || arrayList2.isEmpty()) ? null : (com.tencent.i.a.b.a.a) arrayList2.get(0);
        if (aVar != null) {
            a(aVar, aVar2);
            if (!(aVar2 == null || aVar2.Srh == null || aVar2.Srh.isEmpty())) {
                Iterator<String> it = aVar2.Srh.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!TextUtils.isEmpty(next)) {
                        File file2 = new File(next);
                        if (file2.isFile() && file2.exists()) {
                            file2.delete();
                        }
                    }
                }
            }
            AppMethodBeat.o(214677);
            return aVar;
        } else if (aVar2 == null) {
            AppMethodBeat.o(214677);
            return null;
        } else {
            com.tencent.i.a.c.b.a aVar3 = new com.tencent.i.a.c.b.a();
            com.tencent.i.a.a.b.a.a(lVar.SqM, aVar3, b.DATA_USAGE_TYPE_TRAIN);
            ArrayList<com.tencent.i.a.c.b.d> arrayList7 = new ArrayList<>();
            com.tencent.i.a.c.b.d dVar2 = new com.tencent.i.a.c.b.d();
            dVar2.Ssh = "usage";
            dVar2.Ssi = "crashVal";
            arrayList7.add(dVar2);
            aVar3.SrQ = arrayList7;
            Map<String, String> lu = com.tencent.i.a.a.b.a.lu(lVar.SqM.mAppContext);
            if (!lu.isEmpty()) {
                if (aVar3.SrV == null) {
                    aVar3.SrV = new HashMap();
                }
                aVar3.SrV.putAll(lu);
            }
            a.a(aVar3, aVar2);
            AppMethodBeat.o(214677);
            return aVar3;
        }
    }
}
