package com.tencent.mm.ui;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import android.widget.BaseAdapter;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.a.a;
import com.tencent.mm.storagebase.a.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public abstract class f<K, T extends com.tencent.mm.storagebase.a.a> extends BaseAdapter {
    protected boolean OzL;
    protected f<K, T>.c OzM;
    protected a OzN;
    public int OzO;
    public int OzP;
    public boolean OzQ;
    int OzR;
    private boolean OzS;
    private boolean OzT;
    private f<K, T>.e OzU;
    public K OzV;
    public String TAG;
    public Context context;
    private HashMap<K, b<K, T>> events;
    private int pageSize;
    private int yHf;

    public interface a {
        void bnE();

        void gHg();
    }

    /* access modifiers changed from: package-private */
    public interface d {
        void gHf();
    }

    public abstract SparseArray<K>[] a(HashSet<b<K, T>> hashSet, SparseArray<K>[] sparseArrayArr);

    public abstract ArrayList<T> bo(ArrayList<K> arrayList);

    public abstract T gFJ();

    public abstract com.tencent.mm.storagebase.a.d<K> gGY();

    public final void a(a aVar) {
        this.OzN = aVar;
    }

    public final void gGV() {
        this.OzN = null;
    }

    public f(Context context2) {
        this(context2, (byte) 0);
        this.pageSize = 5000;
        Log.i(this.TAG, "newCursor setPageSize %d", 5000);
    }

    private f(Context context2, byte b2) {
        this.TAG = "MicroMsg.CursorDataAdapter";
        this.OzL = true;
        this.OzO = 1000;
        this.OzP = 3000;
        this.OzQ = true;
        this.yHf = 0;
        this.OzR = 0;
        this.OzV = null;
        this.context = context2;
        this.OzS = true;
    }

    private f(Context context2, char c2) {
        this.TAG = "MicroMsg.CursorDataAdapter";
        this.OzL = true;
        this.OzO = 1000;
        this.OzP = 3000;
        this.OzQ = true;
        this.yHf = 0;
        this.OzR = 0;
        this.OzV = null;
        this.context = context2;
        this.OzS = true;
        this.OzT = false;
        this.OzO = 800;
        this.OzP = 2000;
    }

    public f(Context context2, short s) {
        this(context2, (char) 0);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a(f<K, T>.c cVar) {
        AV(false);
        this.OzM = cVar;
        this.OzM.getCount();
        gGW();
    }

    private void a(com.tencent.mm.storagebase.a.d<K> dVar) {
        AV(true);
        if (this.OzM == null || this.OzM.Ouf != dVar) {
            if (this.OzM != null && !this.OzM.isClosed()) {
                this.OzM.close();
                this.OzM = null;
            }
            this.OzM = b(dVar);
            this.OzM.getCount();
            gGW();
            notifyDataSetChanged();
        }
    }

    public class c extends g<K, T> {
        /* JADX WARN: Incorrect types in method signature: (Lcom/tencent/mm/storagebase/a/d<TK;>;Z)V */
        public c(com.tencent.mm.storagebase.a.d dVar) {
            super(dVar, f.this.pageSize, true);
            AppMethodBeat.i(33000);
            AppMethodBeat.o(33000);
        }

        /* JADX WARN: Incorrect types in method signature: (Lcom/tencent/mm/storagebase/a/d<TK;>;BB)V */
        public c(com.tencent.mm.storagebase.a.d dVar, byte b2) {
            super(dVar, f.this.pageSize, false);
            AppMethodBeat.i(232462);
            AppMethodBeat.o(232462);
        }

        @Override // com.tencent.mm.storagebase.a.g
        public final T gFL() {
            AppMethodBeat.i(33001);
            T t = (T) f.this.gFJ();
            AppMethodBeat.o(33001);
            return t;
        }

        @Override // com.tencent.mm.storagebase.a.g
        public final ArrayList<T> bo(ArrayList arrayList) {
            AppMethodBeat.i(33002);
            ArrayList<T> bo = f.this.bo(arrayList);
            AppMethodBeat.o(33002);
            return bo;
        }
    }

    private void gGW() {
        if (this.OzS) {
            int i2 = this.OzM.gFx() ? 1 : 2;
            if (!(i2 == this.OzR || this.OzR == 0)) {
                if (this.OzU != null && this.OzU.gHk()) {
                    a(b(gGY()), true, false);
                }
                Log.i(this.TAG, "newcursor change update stats  %d ", Integer.valueOf(i2));
            }
            this.OzR = i2;
        }
    }

    /* access modifiers changed from: protected */
    public boolean gFx() {
        if (this.OzM == null) {
            return false;
        }
        return this.OzM.gFx();
    }

    public int getCount() {
        if (this.OzM == null) {
            long currentTimeMillis = System.currentTimeMillis();
            a(gGY());
            Log.i(this.TAG, "newcursor createCursor last : %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
        dl("getcount", false);
        if (this.OzM != null) {
            return this.OzM.getCount();
        }
        Log.w(this.TAG, "[getCount] is zero!");
        return 0;
    }

    public final int gGX() {
        if (this.OzM == null) {
            return 0;
        }
        com.tencent.mm.storagebase.a.d dVar = this.OzM.Ouf;
        if (dVar == null) {
            return 0;
        }
        if (dVar instanceof com.tencent.mm.storagebase.a.e) {
            return ((com.tencent.mm.storagebase.a.e) dVar).OtV[0].getCount();
        }
        throw new RuntimeException("the cursor is not instanceof MergeHeapCursor ,please call getCount() instead ");
    }

    private void dl(String str, boolean z) {
        if (!gHd() && (this.OzQ || z)) {
            if (!z) {
                Log.i(this.TAG, "newcursor cache needRefresh : needRefreshInfront :%b from : %s %s", Boolean.valueOf(this.OzQ), str, Util.getStack());
            }
            mY(false);
        }
    }

    /* renamed from: akz */
    public final T getItem(int i2) {
        if (this.OzM == null) {
            a(gGY());
        }
        dl("getItem", false);
        this.OzM.Ouf.moveToPosition(i2);
        T t = (T) this.OzM.Ouf.akz(i2);
        if (t != null) {
            t.gzB();
        } else {
            Log.e(this.TAG, "newcursor getItem error %d", Integer.valueOf(i2));
        }
        return t;
    }

    public long getItemId(int i2) {
        return 0;
    }

    public f<K, T>.c b(com.tencent.mm.storagebase.a.d<K> dVar) {
        return new c(dVar, (byte) 0);
    }

    public final SparseArray<K>[] gGZ() {
        if (this.OzM == null) {
            return null;
        }
        SparseArray<K>[] gFv = this.OzM.gFv();
        SparseArray<K>[] sparseArrayArr = new SparseArray[gFv.length];
        for (int i2 = 0; i2 < sparseArrayArr.length; i2++) {
            sparseArrayArr[i2] = new SparseArray<>();
            for (int i3 = 0; i3 < gFv[i2].size(); i3++) {
                sparseArrayArr[i2].put(i3, gFv[i2].get(i3));
            }
        }
        return sparseArrayArr;
    }

    private void gHa() {
        this.events.clear();
        this.events.put(this.OzV, null);
    }

    public final void mY(boolean z) {
        if (this.OzT || z) {
            gHb();
        } else {
            int changeType = getChangeType();
            if (changeType == 0) {
                Log.i(this.TAG, "newcursor need not change ");
                return;
            }
            if (changeType == 2) {
                Log.i(this.TAG, "newcursor enqueueMessage resetcursor ");
                this.events.clear();
            }
            if (this.OzU == null) {
                this.OzU = new e();
            }
            this.OzU.akM(changeType);
        }
        this.yHf = 0;
    }

    private int getChangeType() {
        if (this.events == null || this.events.size() == 0) {
            return 0;
        }
        if (this.events.containsKey(this.OzV)) {
            return 2;
        }
        return 1;
    }

    public void o(K k, int i2) {
        boolean z;
        boolean z2;
        if (this.OzM != null) {
            if (this.events == null) {
                this.events = new HashMap<>();
            }
            boolean containsKey = this.events.containsKey(this.OzV);
            if (i2 == 5 || !this.OzS || i2 == 1) {
                if (i2 != 5) {
                    gHa();
                } else if (!containsKey) {
                    this.events.put(k, new b<>(k, i2));
                }
                Log.i(this.TAG, "newcursor syncHandle is true ,changeType is %d  ", Integer.valueOf(i2));
                z = true;
            } else if (containsKey) {
                Log.i(this.TAG, "newcursor need reset ,return ");
                return;
            } else if (this.OzR != 1) {
                gHa();
                z = false;
            } else if (this.OzM.ed(k) || i2 == 2) {
                HashMap<K, b<K, T>> hashMap = this.events;
                b<K, T> bVar = new b<>(k, i2);
                if (bVar.OAa == 2 && this.OzM.ed(bVar.object)) {
                    bVar.OAa = 3;
                }
                b<K, T> bVar2 = hashMap.get(k);
                if (bVar2 != null) {
                    hashMap.remove(bVar2);
                    switch (bVar.OAa) {
                        case 2:
                            switch (bVar2.OAa) {
                                case 2:
                                    Log.i(this.TAG, "newcursor processEvent last insert, now insert, impossible");
                                    bVar.OAa = 2;
                                    break;
                                case 3:
                                case 4:
                                default:
                                    Log.i(this.TAG, "newcursor processEvent last update, now insert, impossible");
                                    bVar.OAa = 2;
                                    break;
                                case 5:
                                    bVar.OAa = 3;
                                    break;
                            }
                            hashMap.put(k, bVar);
                            break;
                        case 3:
                        case 4:
                        default:
                            switch (bVar2.OAa) {
                                case 2:
                                    bVar.OAa = 2;
                                    break;
                                case 5:
                                    Log.i(this.TAG, "newcursor processEvent last delete, now update, impossible");
                                case 3:
                                case 4:
                                default:
                                    bVar.OAa = 3;
                                    break;
                            }
                            hashMap.put(k, bVar);
                            break;
                        case 5:
                            switch (bVar2.OAa) {
                                case 2:
                                    break;
                                case 3:
                                case 4:
                                default:
                                    bVar.OAa = 5;
                                    hashMap.put(k, bVar);
                                    break;
                                case 5:
                                    Log.i(this.TAG, "newcursor processEvent last delete, now delete, impossible");
                                    bVar.OAa = 5;
                                    hashMap.put(k, bVar);
                                    break;
                            }
                    }
                    Log.i(this.TAG, "newcursor add event events size %d", Integer.valueOf(this.events.size()));
                    z = false;
                } else {
                    hashMap.put(k, bVar);
                }
                if (!this.OzM.Ouf.aky(hashMap.size())) {
                    Log.i(this.TAG, "newcursor events size exceed limit :size is :  %d", Integer.valueOf(hashMap.size()));
                    hashMap.clear();
                    hashMap.put(this.OzV, null);
                }
                Log.i(this.TAG, "newcursor add event events size %d", Integer.valueOf(this.events.size()));
                z = false;
            } else {
                Log.i(this.TAG, "newcursor event pass ");
                z = false;
            }
            this.yHf = getChangeType();
            String str = this.TAG;
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(this.yHf);
            if (this.OzR == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[1] = Boolean.valueOf(z2);
            objArr[2] = Integer.valueOf(i2);
            Log.i(str, "newcursor refreshStatus: %d ,hasLoadedAllDataStatus %b changeType :%d ", objArr);
            if (z) {
                Log.i(this.TAG, "newcursor event is refresh sync ");
                mY(true);
            } else if (this.OzL && this.OzQ) {
                mY(false);
            }
        }
    }

    public static class b<K, T> {
        public int OAa;
        public T OAb = null;
        public K object;

        public b(K k, int i2) {
            this.object = k;
            this.OAa = i2;
        }

        public final int hashCode() {
            int hashCode;
            AppMethodBeat.i(32998);
            int i2 = (this.OAa + 31) * 31;
            if (this.object == null) {
                hashCode = 0;
            } else {
                hashCode = this.object.hashCode();
            }
            int i3 = hashCode + i2;
            AppMethodBeat.o(32998);
            return i3;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(32999);
            if (this == obj) {
                AppMethodBeat.o(32999);
                return true;
            } else if (obj == null) {
                AppMethodBeat.o(32999);
                return false;
            } else if (getClass() != obj.getClass()) {
                AppMethodBeat.o(32999);
                return false;
            } else {
                b bVar = (b) obj;
                if (this.OAa != bVar.OAa) {
                    AppMethodBeat.o(32999);
                    return false;
                }
                if (this.object == null) {
                    if (bVar.object != null) {
                        AppMethodBeat.o(32999);
                        return false;
                    }
                } else if (!this.object.equals(bVar.object)) {
                    AppMethodBeat.o(32999);
                    return false;
                }
                AppMethodBeat.o(32999);
                return true;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002f, code lost:
        if (r1 != 2) goto L_0x0031;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void gHb() {
        /*
            r9 = this;
            r8 = 2
            r7 = 0
            r6 = 1
            boolean r0 = r9.gHc()
            if (r0 != 0) goto L_0x000a
        L_0x0009:
            return
        L_0x000a:
            int r1 = r9.getChangeType()
            com.tencent.mm.ui.f<K, T>$e r0 = r9.OzU
            if (r0 == 0) goto L_0x0055
            com.tencent.mm.ui.f<K, T>$e r0 = r9.OzU
            int r0 = r0.gHm()
            java.lang.String r2 = r9.TAG
            java.lang.String r3 = "newcursor mWorkerHandler.isHandingMsg,type is %d "
            java.lang.Object[] r4 = new java.lang.Object[r6]
            java.lang.Integer r5 = java.lang.Integer.valueOf(r0)
            r4[r7] = r5
            com.tencent.mm.sdk.platformtools.Log.i(r2, r3, r4)
            if (r0 == 0) goto L_0x002f
            com.tencent.mm.ui.f<K, T>$e r2 = r9.OzU
            r2.gHi()
        L_0x002f:
            if (r1 == r8) goto L_0x0055
        L_0x0031:
            java.lang.String r1 = r9.TAG
            java.lang.String r2 = "newcursor ensureNewState  refreshstatus is %d "
            java.lang.Object[] r3 = new java.lang.Object[r6]
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)
            r3[r7] = r4
            com.tencent.mm.sdk.platformtools.Log.i(r1, r2, r3)
            r9.yHf = r7
            if (r0 != r8) goto L_0x0051
            com.tencent.mm.storagebase.a.d r0 = r9.gGY()
            com.tencent.mm.ui.f$c r0 = r9.b(r0)
            r9.a(r0, r6, r6)
            goto L_0x0009
        L_0x0051:
            r9.gHe()
            goto L_0x0009
        L_0x0055:
            r0 = r1
            goto L_0x0031
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.f.gHb():void");
    }

    private boolean gHc() {
        return (this.OzU != null && this.OzU.gHk()) || getChangeType() != 0;
    }

    private boolean gHd() {
        if (this.yHf == 0) {
            return true;
        }
        return false;
    }

    public final void resume() {
        Log.i(this.TAG, "newcursor resume ");
        this.OzL = true;
        dl("resume", true);
    }

    public void pause() {
        this.OzL = false;
        Log.i(this.TAG, "new cursor pasue");
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a(d dVar) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.OzN != null) {
            this.OzN.gHg();
        }
        if (dVar != null) {
            dVar.gHf();
        }
        notifyDataSetChanged();
        if (this.OzN != null) {
            this.OzN.bnE();
        }
        if (this.OzU != null) {
            this.OzU.gHl();
        }
        Log.i(this.TAG, "newcursor update callback last :%d ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void gHe() {
        if (this.OzM == null || this.OzM.isClosed() || this.events.size() != 0) {
            a(new d() {
                /* class com.tencent.mm.ui.f.AnonymousClass1 */

                /* JADX DEBUG: Multi-variable search result rejected for r2v9, resolved type: com.tencent.mm.ui.f$c */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.tencent.mm.ui.f.d
                public final void gHf() {
                    AppMethodBeat.i(32996);
                    if (f.a(f.this, f.this.events)) {
                        HashSet hashSet = new HashSet(f.this.events.size());
                        for (b bVar : f.this.events.values()) {
                            hashSet.add(bVar.object);
                        }
                        Log.i(f.this.TAG, "newcursor all event is delete");
                        f.this.OzM.c(hashSet.toArray(), null);
                    } else if (!f.this.events.containsKey(f.this.OzV)) {
                        long currentTimeMillis = System.currentTimeMillis();
                        SparseArray<K>[] gGZ = f.this.gGZ();
                        SparseArray<K>[] a2 = f.this.a(new HashSet<>(f.this.events.values()), gGZ);
                        int length = gGZ.length;
                        if (length > 1) {
                            for (int i2 = 0; i2 < length; i2++) {
                                Log.i(f.this.TAG, "newcursor %d  refreshPosistion last :%d, oldpos size is %d ,newpos size is %d  ", Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(gGZ[i2].size()), Integer.valueOf(a2[i2].size()));
                            }
                        } else {
                            Log.i(f.this.TAG, "newcursor refreshPosistion last :%d, oldpos size is %d ,newpos size is %d  ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(gGZ[0].size()), Integer.valueOf(a2[0].size()));
                        }
                        for (b bVar2 : f.this.events.values()) {
                            if (bVar2 != null) {
                                if (bVar2.OAb != null) {
                                    Log.i(f.this.TAG, "newcursor notify cache update : key : %s ", bVar2.object);
                                }
                                f.this.OzM.c(bVar2.object, bVar2.OAb);
                            } else {
                                Log.e(f.this.TAG, "newcursor event is null ! ");
                            }
                        }
                        f.this.a(a2);
                        Log.i(f.this.TAG, "newcursor after resort new pos size :%d  ", Integer.valueOf(f.this.OzM.gFv()[0].size()));
                    } else {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        f.this.a(f.this.b(f.this.gGY()), true, false);
                        Log.i(f.this.TAG, "cache unuseful,reset cursor,last : %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                    }
                    f.this.events.clear();
                    AppMethodBeat.o(32996);
                }
            });
        } else {
            Log.i(this.TAG, "events size is 0  ");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a(final f<K, T>.c cVar, boolean z, boolean z2) {
        if (z) {
            if (this.OzU != null && this.OzU.gHk()) {
                this.OzU.gHi();
            }
            if (this.events != null) {
                this.events.clear();
            }
        }
        if (z2 && cVar != null && !cVar.Oug) {
            a(new d() {
                /* class com.tencent.mm.ui.f.AnonymousClass2 */

                @Override // com.tencent.mm.ui.f.d
                public final void gHf() {
                    AppMethodBeat.i(32997);
                    f.this.a((f) cVar);
                    AppMethodBeat.o(32997);
                }
            });
        } else if (cVar == null || !cVar.Oug || !z2) {
            a(cVar);
        } else {
            h.RTc.aX(new Runnable() {
                /* class com.tencent.mm.ui.f.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(232461);
                    int count = cVar.getCount();
                    Log.i(f.this.TAG, "select db count: %d", Integer.valueOf(count));
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.ui.f.AnonymousClass3.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(232460);
                            f.this.a((f) new d() {
                                /* class com.tencent.mm.ui.f.AnonymousClass3.AnonymousClass1.AnonymousClass1 */

                                @Override // com.tencent.mm.ui.f.d
                                public final void gHf() {
                                    AppMethodBeat.i(232459);
                                    f.this.a((f) cVar);
                                    AppMethodBeat.o(232459);
                                }
                            });
                            AppMethodBeat.o(232460);
                        }
                    });
                    AppMethodBeat.o(232461);
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public class e {
        f<K, T>.e.b OAc;
        private f<K, T>.e.c OAd;
        LinkedList<Integer> OAe;
        int OAf;

        /* access modifiers changed from: package-private */
        public class c extends MMHandler {
            long OAl;
            private final int OAm = (hashCode() | 1910);
            private final int OAn = (hashCode() | 1914);
            long lastUpdateTime;

            public c(Looper looper) {
                super(looper);
                AppMethodBeat.i(33004);
                e.this.OAe = new LinkedList<>();
                AppMethodBeat.o(33004);
            }

            @Override // com.tencent.mm.sdk.platformtools.MMHandler
            public final void handleMessage(Message message) {
                AppMethodBeat.i(33005);
                super.handleMessage(message);
                if (message.what == this.OAn) {
                    removeMessages(this.OAm);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - this.OAl > ((long) f.this.OzO) || currentTimeMillis - this.OAl < 0 || ((this.lastUpdateTime != 0 && currentTimeMillis - this.lastUpdateTime > ((long) f.this.OzP)) || currentTimeMillis - this.lastUpdateTime < 0)) {
                        e.a(e.this);
                    } else {
                        sendEmptyMessageDelayed(this.OAm, (long) f.this.OzO);
                    }
                    this.OAl = currentTimeMillis;
                    AppMethodBeat.o(33005);
                    return;
                }
                if (message.what == this.OAm) {
                    e.a(e.this);
                }
                AppMethodBeat.o(33005);
            }

            static /* synthetic */ void a(c cVar) {
                AppMethodBeat.i(232463);
                cVar.removeMessages(cVar.OAm);
                cVar.removeMessages(cVar.OAn);
                AppMethodBeat.o(232463);
            }

            static /* synthetic */ void b(c cVar) {
                AppMethodBeat.i(232464);
                cVar.lastUpdateTime = System.currentTimeMillis();
                AppMethodBeat.o(232464);
            }

            static /* synthetic */ void c(c cVar) {
                AppMethodBeat.i(232465);
                cVar.sendEmptyMessage(cVar.OAn);
                AppMethodBeat.o(232465);
            }
        }

        /* access modifiers changed from: package-private */
        public class b extends MMHandler {
            boolean OAi;
            public final int OAj = 1;
            public final int OAk = 2;

            public b(Looper looper) {
                super(looper);
            }

            @Override // com.tencent.mm.sdk.platformtools.MMHandler
            public final void handleMessage(Message message) {
                AppMethodBeat.i(33003);
                super.handleMessage(message);
                if (this.OAi) {
                    AppMethodBeat.o(33003);
                    return;
                }
                synchronized (e.this) {
                    try {
                        e.this.OAf = e.this.gHj();
                        Log.i(f.this.TAG, "newcursor updateWorkerRefresh status %d", Integer.valueOf(e.this.OAf));
                    } finally {
                        AppMethodBeat.o(33003);
                    }
                }
                if (message.what == 1) {
                    f.this.gHe();
                    AppMethodBeat.o(33003);
                    return;
                }
                if (message.what == 2) {
                    f.this.a((c) message.obj, false, true);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public class a {
            int OAg;

            public a(int i2) {
                this.OAg = i2;
            }
        }

        public e() {
            AppMethodBeat.i(33006);
            gHh();
            AppMethodBeat.o(33006);
        }

        private void gHh() {
            AppMethodBeat.i(33007);
            this.OAc = new b(Looper.getMainLooper());
            this.OAd = new c(bg.aAk().getLooper());
            AppMethodBeat.o(33007);
        }

        private void glP() {
            AppMethodBeat.i(33008);
            c.a(this.OAd);
            f<K, T>.e.b bVar = this.OAc;
            bVar.OAi = true;
            bVar.removeMessages(1);
            bVar.removeMessages(2);
            this.OAe.clear();
            this.OAf = 0;
            AppMethodBeat.o(33008);
        }

        public final synchronized void gHi() {
            AppMethodBeat.i(33009);
            Log.i(f.this.TAG, "newcursor resetQueue ");
            glP();
            gHh();
            AppMethodBeat.o(33009);
        }

        public final synchronized void quit() {
            AppMethodBeat.i(33010);
            Log.i(f.this.TAG, "newcursor quit ");
            glP();
            AppMethodBeat.o(33010);
        }

        /* access modifiers changed from: package-private */
        public final int gHj() {
            int i2 = 0;
            AppMethodBeat.i(33011);
            if (this.OAe.size() > 1) {
                i2 = 2;
            } else if (this.OAe.size() == 1) {
                i2 = this.OAe.get(0).intValue();
            }
            AppMethodBeat.o(33011);
            return i2;
        }

        public final synchronized boolean gHk() {
            return this.OAf != 0;
        }

        /* access modifiers changed from: package-private */
        public final synchronized void gHl() {
            AppMethodBeat.i(33012);
            c.b(this.OAd);
            AppMethodBeat.o(33012);
        }

        /* access modifiers changed from: package-private */
        public final synchronized int gHm() {
            return this.OAf;
        }

        /* access modifiers changed from: package-private */
        public final synchronized void akM(int i2) {
            AppMethodBeat.i(33013);
            if (!this.OAe.contains(Integer.valueOf(i2))) {
                this.OAe.add(Integer.valueOf(i2));
            }
            this.OAf = gHj();
            c.c(this.OAd);
            AppMethodBeat.o(33013);
        }

        static /* synthetic */ void a(e eVar) {
            int gHj;
            AppMethodBeat.i(232466);
            synchronized (eVar) {
                try {
                    gHj = eVar.gHj();
                    eVar.OAe.clear();
                } catch (Throwable th) {
                    AppMethodBeat.o(232466);
                    throw th;
                }
            }
            a aVar = new a(gHj);
            if (aVar.OAg == 2) {
                long currentTimeMillis = System.currentTimeMillis();
                f<K, T>.c b2 = f.this.b(f.this.gGY());
                int count = b2.getCount();
                Log.i(f.this.TAG, "newcursor fillCursor last : %d  count %d ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(count));
                f<K, T>.e.b bVar = e.this.OAc;
                Message obtain = Message.obtain();
                obtain.obj = b2;
                obtain.what = 2;
                bVar.sendMessage(obtain);
                AppMethodBeat.o(232466);
                return;
            }
            e.this.OAc.sendEmptyMessage(1);
            AppMethodBeat.o(232466);
        }
    }

    public final void a(SparseArray<K>[] sparseArrayArr) {
        SparseArray<K>[] gFv = this.OzM.gFv();
        for (int i2 = 0; i2 < gFv.length; i2++) {
            gFv[i2].clear();
            for (int i3 = 0; i3 < sparseArrayArr[i2].size(); i3++) {
                gFv[i2].put(i3, sparseArrayArr[i2].get(i3));
            }
        }
    }

    public final void AV(boolean z) {
        if (this.OzM != null) {
            this.OzM.close();
            this.OzM = null;
        }
        if (z && this.OzU != null) {
            this.OzU.quit();
            this.OzU = null;
            if (this.events != null) {
                this.events.clear();
                Log.i(this.TAG, "newcursor closeCursor,clear events");
            }
        }
        this.yHf = 0;
        this.OzR = 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x000f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ boolean a(com.tencent.mm.ui.f r5, java.util.HashMap r6) {
        /*
            r1 = 1
            java.util.Collection r0 = r6.values()
            java.util.Iterator r2 = r0.iterator()
        L_0x0009:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x0022
            java.lang.Object r0 = r2.next()
            com.tencent.mm.ui.f$b r0 = (com.tencent.mm.ui.f.b) r0
            if (r0 == 0) goto L_0x001c
            int r3 = r0.OAa
            r4 = 5
            if (r3 != r4) goto L_0x0020
        L_0x001c:
            K r3 = r5.OzV
            if (r0 != r3) goto L_0x0009
        L_0x0020:
            r0 = 0
        L_0x0021:
            return r0
        L_0x0022:
            r0 = r1
            goto L_0x0021
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.f.a(com.tencent.mm.ui.f, java.util.HashMap):boolean");
    }
}
