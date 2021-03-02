package com.tencent.mm.av;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public final class e implements i, j {
    final List<b> iXb = Collections.synchronizedList(new LinkedList());
    private HashSet<b> iXc = new HashSet<>();
    b iXd = null;
    private m iXe = null;
    public boolean iXf = false;

    public interface a {
        void a(long j2, long j3, int i2, int i3, Object obj);

        void a(long j2, long j3, int i2, int i3, Object obj, int i4, int i5, q qVar);

        void a(long j2, long j3, int i2, int i3, Object obj, int i4, int i5, String str, q qVar);
    }

    public e() {
        AppMethodBeat.i(150535);
        g.aAg().hqi.a(109, this);
        AppMethodBeat.o(150535);
    }

    public final boolean a(long j2, long j3, int i2, Object obj, int i3, a aVar) {
        AppMethodBeat.i(150536);
        if (a(j2, j3, i2, obj, i3, aVar, -1, false) >= 0) {
            AppMethodBeat.o(150536);
            return true;
        }
        AppMethodBeat.o(150536);
        return false;
    }

    public final int a(long j2, long j3, Object obj, a aVar) {
        AppMethodBeat.i(150537);
        int a2 = a(j2, j3, 1, obj, R.drawable.c3h, aVar, 0, false);
        AppMethodBeat.o(150537);
        return a2;
    }

    public final int a(long j2, long j3, int i2, Object obj, int i3, a aVar, int i4, boolean z) {
        AppMethodBeat.i(150538);
        if (aVar == null) {
            Log.e("ModelImage.DownloadImgService", "listener is null");
            AppMethodBeat.o(150538);
            return -1;
        }
        b bVar = new b(j2, j3, i2);
        bVar.iXi = i3;
        if (this.iXc.contains(bVar)) {
            Log.e("ModelImage.DownloadImgService", "[" + aVar.hashCode() + "] add failed, task already done");
            AppMethodBeat.o(150538);
            return -2;
        } else if (this.iXd == null || !bVar.equals(this.iXd)) {
            int indexOf = this.iXb.indexOf(bVar);
            if (indexOf < 0 || indexOf >= this.iXb.size()) {
                Log.i("ModelImage.DownloadImgService", "[" + aVar.hashCode() + "] no found task, create a new task(" + j2 + " " + j3 + " " + i2 + ") mLockStart: %s callbackDuration %s", Boolean.valueOf(this.iXf), Integer.valueOf(i4));
                bVar.a(aVar, obj);
                if (!z || this.iXb.size() <= 0) {
                    this.iXb.add(bVar);
                } else {
                    this.iXb.add(0, bVar);
                }
                td(i4);
                AppMethodBeat.o(150538);
                return 0;
            } else if (this.iXb.get(indexOf).a(aVar, obj)) {
                AppMethodBeat.o(150538);
                return 0;
            } else {
                AppMethodBeat.o(150538);
                return -4;
            }
        } else if (this.iXd.a(aVar, obj)) {
            AppMethodBeat.o(150538);
            return 0;
        } else {
            AppMethodBeat.o(150538);
            return -3;
        }
    }

    public final boolean a(long j2, long j3, int i2) {
        AppMethodBeat.i(150539);
        b bVar = new b(j2, j3, i2);
        if (this.iXd != null && this.iXd.equals(bVar)) {
            AppMethodBeat.o(150539);
            return true;
        } else if (this.iXb.indexOf(bVar) >= 0) {
            AppMethodBeat.o(150539);
            return true;
        } else {
            AppMethodBeat.o(150539);
            return false;
        }
    }

    public final boolean a(long j2, long j3, int i2, a aVar) {
        AppMethodBeat.i(223572);
        if (aVar == null) {
            Log.e("ModelImage.DownloadImgService", "listener is null");
            AppMethodBeat.o(223572);
            return false;
        }
        b bVar = new b(j2, j3, i2);
        b bVar2 = null;
        if (this.iXd == null || !this.iXd.equals(bVar)) {
            int indexOf = this.iXb.indexOf(bVar);
            if (-1 != indexOf) {
                bVar2 = this.iXb.get(indexOf);
            }
        } else {
            bVar2 = this.iXd;
        }
        if (bVar2 != null) {
            bVar2.b(aVar);
            a(bVar2);
            Log.i("ModelImage.DownloadImgService", "[" + aVar.hashCode() + "] task has been canceled, (" + j2 + ", " + j3 + ", " + i2 + ")");
            AppMethodBeat.o(223572);
            return true;
        }
        Log.e("ModelImage.DownloadImgService", "[" + aVar.hashCode() + "] task no found, (" + j2 + ", " + j3 + ", " + i2 + ")");
        AppMethodBeat.o(223572);
        return false;
    }

    public final void a(a aVar) {
        AppMethodBeat.i(150541);
        Log.i("ModelImage.DownloadImgService", "[" + aVar.hashCode() + "] cancel all tasks of listener");
        this.iXf = true;
        if (this.iXd != null) {
            Object[] objArr = new Object[3];
            objArr[0] = this.iXd == null ? "mCurTaskInfo is null" : this.iXd.iXg + ", " + this.iXd.gzl + ", " + this.iXd.iXh;
            objArr[1] = Integer.valueOf(this.iXb.size());
            objArr[2] = Boolean.valueOf(this.iXf);
            Log.i("ModelImage.DownloadImgService", "cancelAllTaskByListener CurTaskInfo %s mTodoList %s mLockStart %s", objArr);
            b(this.iXd);
        }
        LinkedList<b> linkedList = new LinkedList();
        synchronized (this.iXb) {
            try {
                linkedList.addAll(this.iXb);
            } catch (Throwable th) {
                AppMethodBeat.o(150541);
                throw th;
            }
        }
        for (b bVar : linkedList) {
            if (bVar != null) {
                bVar.b(aVar);
                a(bVar);
            }
        }
        bco();
        Object[] objArr2 = new Object[2];
        objArr2[0] = Integer.valueOf(aVar.hashCode());
        objArr2[1] = this.iXd == null ? "mCurTaskInfo is null" : this.iXd.iXg + ", " + this.iXd.gzl + ", " + this.iXd.iXh;
        Log.i("ModelImage.DownloadImgService", "[ %s ] cancelAllTaskByListener done mCurTaskInfo %s", objArr2);
        AppMethodBeat.o(150541);
    }

    private boolean a(b bVar) {
        AppMethodBeat.i(150542);
        if (bVar == null || bVar.bcp() > 0) {
            AppMethodBeat.o(150542);
            return false;
        }
        boolean b2 = b(bVar);
        AppMethodBeat.o(150542);
        return b2;
    }

    public final boolean C(long j2, long j3) {
        AppMethodBeat.i(150543);
        boolean b2 = b(new b(j2, j3, 1));
        AppMethodBeat.o(150543);
        return b2;
    }

    /* access modifiers changed from: package-private */
    public final boolean b(b bVar) {
        AppMethodBeat.i(150544);
        if (bVar == null) {
            Log.e("ModelImage.DownloadImgService", "task is null");
            AppMethodBeat.o(150544);
            return false;
        }
        Log.i("ModelImage.DownloadImgService", "cancel scene, (" + bVar.iXg + ", " + bVar.gzl + ", " + bVar.iXh + ")");
        if (this.iXd != null && this.iXd.equals(bVar)) {
            g.aAg().hqi.a(this.iXe);
            this.iXe = null;
            Log.i("ModelImage.DownloadImgService", "cancelNetScene reset curTaskInfo (%s %s %s)", Long.valueOf(bVar.iXg), Long.valueOf(bVar.gzl), Integer.valueOf(bVar.iXh));
            c(this.iXd);
            this.iXd = null;
            td(-1);
            AppMethodBeat.o(150544);
            return true;
        } else if (this.iXb.contains(bVar)) {
            if (this.iXb.remove(bVar)) {
                c(bVar);
            }
            AppMethodBeat.o(150544);
            return true;
        } else {
            AppMethodBeat.o(150544);
            return false;
        }
    }

    private static void c(b bVar) {
        AppMethodBeat.i(150545);
        if (bVar == null) {
            Log.e("ModelImage.DownloadImgService", "task is null");
            AppMethodBeat.o(150545);
        } else if (bVar.iXj == null) {
            Log.e("ModelImage.DownloadImgService", "task callback list is null");
            AppMethodBeat.o(150545);
        } else {
            for (c cVar : bVar.iXj) {
                if (cVar.iXk != null) {
                    cVar.iXk.a(bVar.iXg, bVar.gzl, bVar.iXh, bVar.iXi, cVar.iXl);
                }
            }
            AppMethodBeat.o(150545);
        }
    }

    public final void bco() {
        AppMethodBeat.i(150546);
        this.iXf = false;
        td(-1);
        AppMethodBeat.o(150546);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(150547);
        if (this.iXe != qVar) {
            Log.d("ModelImage.DownloadImgService", "scene changed");
            AppMethodBeat.o(150547);
            return;
        }
        if (!(this.iXd == null || this.iXd.iXj == null)) {
            this.iXc.add(new b(this.iXd.iXg, this.iXd.gzl, this.iXd.iXh));
            Log.i("ModelImage.DownloadImgService", "scene end, (" + this.iXd.iXg + ", " + this.iXd.gzl + ", " + this.iXd.iXh + ")");
            for (c cVar : new ArrayList(this.iXd.iXj)) {
                if (cVar.iXk != null) {
                    cVar.iXk.a(this.iXd.iXg, this.iXd.gzl, this.iXd.iXh, this.iXd.iXi, cVar.iXl, i2, i3, str, qVar);
                }
            }
            this.iXd = null;
            this.iXe = null;
            td(-1);
        }
        AppMethodBeat.o(150547);
    }

    @Override // com.tencent.mm.ak.j
    public final void a(int i2, int i3, q qVar) {
        AppMethodBeat.i(150548);
        if (this.iXe != qVar) {
            Log.d("ModelImage.DownloadImgService", "scene changed");
            AppMethodBeat.o(150548);
            return;
        }
        if (!(this.iXd == null || this.iXd.iXj == null)) {
            for (c cVar : new ArrayList(this.iXd.iXj)) {
                if (cVar.iXk != null) {
                    cVar.iXk.a(this.iXd.iXg, this.iXd.gzl, this.iXd.iXh, this.iXd.iXi, cVar.iXl, i2, i3, qVar);
                }
            }
        }
        AppMethodBeat.o(150548);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x008a, code lost:
        if (r11.iXd != null) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x008c, code lost:
        com.tencent.mm.sdk.platformtools.Log.w("ModelImage.DownloadImgService", "null == mCurTaskInfo");
        com.tencent.matrix.trace.core.AppMethodBeat.o(150549);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x009f, code lost:
        r11.iXe = new com.tencent.mm.av.m(r11.iXd.iXg, r11.iXd.gzl, r11.iXd.iXh, r11, r12);
        r11.iXe.iYW = r11.iXd.iXi;
        com.tencent.mm.sdk.platformtools.Log.i("ModelImage.DownloadImgService", "do scene, (" + r11.iXd.iXg + ", " + r11.iXd.gzl + ", " + r11.iXd.iXh + ")");
        com.tencent.mm.kernel.g.aAg().hqi.a(r11.iXe, 0);
        com.tencent.matrix.trace.core.AppMethodBeat.o(150549);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void td(int r12) {
        /*
        // Method dump skipped, instructions count: 267
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.av.e.td(int):void");
    }

    /* access modifiers changed from: package-private */
    public static class b {
        private int aHK = 0;
        public long gzl;
        public long iXg;
        public int iXh;
        public int iXi;
        public List<c> iXj;

        public b(long j2, long j3, int i2) {
            this.iXg = j2;
            this.gzl = j3;
            this.iXh = i2;
            this.iXi = 0;
        }

        public final boolean a(a aVar, Object obj) {
            AppMethodBeat.i(150531);
            if (this.iXj == null) {
                this.iXj = Collections.synchronizedList(new LinkedList());
            }
            c cVar = new c(aVar, obj);
            if (this.iXj.contains(cVar)) {
                Log.d("ModelImage.DownloadImgService.Task", "task item already exists");
                AppMethodBeat.o(150531);
                return false;
            }
            this.iXj.add(cVar);
            AppMethodBeat.o(150531);
            return true;
        }

        public final boolean b(a aVar) {
            AppMethodBeat.i(150532);
            c cVar = new c(aVar, null);
            if (this.iXj.contains(cVar)) {
                this.iXj.remove(cVar);
                AppMethodBeat.o(150532);
                return true;
            }
            AppMethodBeat.o(150532);
            return false;
        }

        public final int bcp() {
            AppMethodBeat.i(150533);
            int size = this.iXj.size();
            AppMethodBeat.o(150533);
            return size;
        }

        public final boolean equals(Object obj) {
            if (obj == null || !(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (bVar.iXg == this.iXg && bVar.gzl == this.gzl && bVar.iXh == this.iXh) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            AppMethodBeat.i(150534);
            if (this.aHK == 0) {
                this.aHK = (this.iXg + "_" + this.gzl + "_" + this.iXh).hashCode();
            }
            int i2 = this.aHK;
            AppMethodBeat.o(150534);
            return i2;
        }
    }

    /* access modifiers changed from: package-private */
    public static class c {
        a iXk;
        Object iXl;

        public c(a aVar, Object obj) {
            this.iXk = aVar;
            this.iXl = obj;
        }

        public final boolean equals(Object obj) {
            if (obj == null || !(obj instanceof c) || this.iXk != ((c) obj).iXk) {
                return false;
            }
            return true;
        }
    }
}
