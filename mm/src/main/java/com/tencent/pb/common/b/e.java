package com.tencent.pb.common.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.tencent.pb.common.c.b;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public final class e implements b {
    private static e RCN = null;
    private final SparseArray<Set<b>> RCO = new SparseArray<>();
    private d RCP = null;
    private final Handler handler = new Handler(Looper.getMainLooper()) {
        /* class com.tencent.pb.common.b.e.AnonymousClass1 */

        public final void handleMessage(Message message) {
            e.this.a((d) message.obj);
        }
    };
    private Vector<d> iMy = new Vector<>();
    private Vector<d> iMz = new Vector<>();

    private e() {
    }

    public static e hiW() {
        if (RCN == null) {
            synchronized (e.class) {
                if (RCN == null) {
                    RCN = new e();
                }
            }
        }
        return RCN;
    }

    public final void a(int i2, b bVar) {
        if (this.RCO.get(i2) == null) {
            this.RCO.put(i2, new HashSet());
        }
        if (!this.RCO.get(i2).contains(bVar)) {
            this.RCO.get(i2).add(bVar);
        }
    }

    public final boolean a(d dVar) {
        int type;
        if (!h.isNetworkConnected() && ((type = dVar.getType()) == 102 || type == 104 || type == 103)) {
            b.w("MicroMsg.Voip", "doScene do retain mReissueNetScene");
            this.RCP = dVar;
        }
        if (dVar == null) {
            return false;
        }
        b(dVar);
        return true;
    }

    private void b(final d dVar) {
        if (hiX()) {
            this.iMy.add(dVar);
            int a2 = dVar.a(this);
            if (a2 < 0) {
                b.w("MicroMsg.Voip", "doSceneImp do scene failed, ret %d,", Integer.valueOf(a2));
                this.handler.post(new Runnable() {
                    /* class com.tencent.pb.common.b.e.AnonymousClass2 */

                    public final void run() {
                        e.this.iMy.remove(dVar);
                        e.this.a(2, -1, "doScene failed", dVar);
                    }
                });
            }
        } else {
            this.iMz.add(dVar);
        }
        aYX();
    }

    @Override // com.tencent.pb.common.b.b
    public final void a(final int i2, final int i3, final String str, final d dVar) {
        this.iMy.remove(dVar);
        aYX();
        this.handler.post(new Runnable() {
            /* class com.tencent.pb.common.b.e.AnonymousClass3 */

            public final void run() {
                Set set = (Set) e.this.RCO.get(dVar.getType());
                if (set != null && set.size() > 0) {
                    HashSet<b> hashSet = new HashSet();
                    hashSet.addAll(set);
                    for (b bVar : hashSet) {
                        if (bVar != null && set.contains(bVar)) {
                            bVar.a(i2, i3, str, dVar);
                        }
                    }
                }
            }
        });
    }

    private void aYX() {
        if (this.iMz.size() > 0) {
            d dVar = this.iMz.get(0);
            for (int i2 = 1; i2 < this.iMz.size(); i2++) {
                this.iMz.get(i2);
            }
            if (hiX()) {
                this.iMz.remove(dVar);
                b(dVar);
            }
        }
    }

    private boolean hiX() {
        if (this.iMy.size() >= 20) {
            return false;
        }
        return true;
    }
}
