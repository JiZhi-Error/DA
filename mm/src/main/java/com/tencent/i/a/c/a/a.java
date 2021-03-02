package com.tencent.i.a.c.a;

import com.tencent.i.a.a.c;
import com.tencent.i.a.c.b.f;
import com.tencent.i.a.c.b.g;
import com.tencent.i.a.c.b.i;
import com.tencent.i.a.c.d.b;
import com.tencent.i.a.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class a {
    protected c SqM;
    protected com.tencent.i.a.b.a SrE;
    private int SrF;
    protected h.a SrG = this.SrE.hqh();

    public abstract void a(HashMap<Integer, List<g>> hashMap, List<i> list, List<com.tencent.i.a.c.b.h> list2, b bVar);

    public a(c cVar, com.tencent.i.a.b.a aVar) {
        this.SqM = cVar;
        this.SrE = aVar;
    }

    public void dQn() {
    }

    protected static boolean b(HashMap<Integer, List<g>> hashMap, List<i> list) {
        if (hashMap == null || hashMap.isEmpty() || list == null || list.isEmpty()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final void a(int i2, com.tencent.i.a.c.b.a aVar, b bVar) {
        if (bVar != null) {
            com.tencent.h.c.h.i("sensor_AbsDataHandle", "[method: onCSReqCallBack ] errorCode : " + i2 + " null == csReq? " + (aVar == null));
            com.tencent.i.a.a.b.a.a(this.SqM, aVar, this.SrG.Sqq);
            if (!(aVar == null || this.SrG == null)) {
                aVar.SrL = this.SrG.zfX;
                aVar.dkT = this.SrG.Sqp;
                if (this.SrG.Sqs != null) {
                    if (aVar.SrQ == null) {
                        aVar.SrQ = new ArrayList<>();
                    }
                    aVar.SrQ.addAll(com.tencent.i.a.a.b.a.z(this.SrG.Sqs.hpX()));
                    com.tencent.i.a.a hpY = this.SrG.Sqs.hpY();
                    com.tencent.i.a.c.b.b bVar2 = new com.tencent.i.a.c.b.b();
                    if (hpY != null) {
                        bVar2.Sqg = hpY.Sqg;
                        bVar2.Sqh = hpY.Sqh;
                    }
                    aVar.SrS = bVar2;
                }
                Map<String, String> lu = com.tencent.i.a.a.b.a.lu(this.SqM.mAppContext);
                if (!lu.isEmpty()) {
                    if (aVar.SrV == null) {
                        aVar.SrV = new HashMap();
                    }
                    aVar.SrV.putAll(lu);
                }
            }
            bVar.b(i2, aVar);
        }
    }

    /* access modifiers changed from: protected */
    public final com.tencent.i.a.c.b.a a(com.tencent.i.a.c.b.c cVar, List<i> list, List<com.tencent.i.a.c.b.h> list2) {
        com.tencent.i.a.c.b.a aVar = new com.tencent.i.a.c.b.a();
        aVar.SrM = System.currentTimeMillis();
        f fVar = new f();
        fVar.Ssm = System.currentTimeMillis();
        ArrayList<com.tencent.i.a.c.b.c> arrayList = new ArrayList<>();
        arrayList.add(cVar);
        fVar.kgc = arrayList;
        this.SrF++;
        fVar.RND = this.SrF;
        if (list != null && !list.isEmpty()) {
            fVar.Ssn = new ArrayList<>(list);
        }
        if (list2 != null && !list2.isEmpty()) {
            fVar.Sso = new ArrayList<>(list2);
        }
        ArrayList<f> arrayList2 = new ArrayList<>();
        arrayList2.add(fVar);
        aVar.SrN = arrayList2;
        return aVar;
    }

    protected static boolean a(com.tencent.i.a.c.b.a aVar, int i2) {
        boolean z;
        if (aVar == null || aVar.SrN == null || aVar.SrN.isEmpty() || aVar.SrN.get(0) == null) {
            z = true;
        } else {
            f fVar = aVar.SrN.get(0);
            if (fVar.kgc == null || fVar.kgc.isEmpty() || fVar.kgc.get(0) == null) {
                z = true;
            } else {
                com.tencent.i.a.c.b.c cVar = fVar.kgc.get(0);
                if (cVar.Ssd == null || cVar.Ssd.isEmpty() || cVar.Ssd.get(0) == null) {
                    z = true;
                } else if (fVar.Ssn == null || fVar.Ssn.isEmpty() || fVar.Ssn.get(0) == null) {
                    z = true;
                } else {
                    z = false;
                }
            }
        }
        if (z) {
            return true;
        }
        byte[] byteArray = aVar.toByteArray();
        return byteArray != null && byteArray.length > i2;
    }
}
