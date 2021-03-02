package com.google.android.exoplayer2.h.a;

import android.util.SparseArray;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.b;
import com.google.android.exoplayer2.i.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* access modifiers changed from: package-private */
public final class j {
    private q bFY;
    private final boolean bGA = false;
    boolean bGB;
    final HashMap<String, i> bGv = new HashMap<>();
    final SparseArray<String> bGw = new SparseArray<>();
    final b bGx;
    private final Cipher bGy = null;
    private final SecretKeySpec bGz = null;

    public j(File file) {
        AppMethodBeat.i(92981);
        this.bGx = new b(new File(file, "cached_content_index.exi"));
        AppMethodBeat.o(92981);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00ee, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00f0, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00f1, code lost:
        r1 = r2;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00ee A[ExcHandler: all (th java.lang.Throwable), PHI: r2 
      PHI: (r2v8 java.io.DataOutputStream) = (r2v7 java.io.DataOutputStream), (r2v9 java.io.DataOutputStream) binds: [B:9:0x002a, B:22:0x006b] A[DONT_GENERATE, DONT_INLINE], Splitter:B:9:0x002a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void wU() {
        /*
        // Method dump skipped, instructions count: 245
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.h.a.j.wU():void");
    }

    public final i bq(String str) {
        AppMethodBeat.i(92983);
        i iVar = this.bGv.get(str);
        if (iVar == null) {
            iVar = h(str, -1);
        }
        AppMethodBeat.o(92983);
        return iVar;
    }

    public final i br(String str) {
        AppMethodBeat.i(92984);
        i iVar = this.bGv.get(str);
        AppMethodBeat.o(92984);
        return iVar;
    }

    public final int bs(String str) {
        AppMethodBeat.i(92985);
        int i2 = bq(str).id;
        AppMethodBeat.o(92985);
        return i2;
    }

    public final void bt(String str) {
        AppMethodBeat.i(92986);
        i remove = this.bGv.remove(str);
        if (remove != null) {
            a.checkState(remove.bGu.isEmpty());
            this.bGw.remove(remove.id);
            this.bGB = true;
        }
        AppMethodBeat.o(92986);
    }

    public final void wV() {
        AppMethodBeat.i(92987);
        LinkedList linkedList = new LinkedList();
        for (i iVar : this.bGv.values()) {
            if (iVar.bGu.isEmpty()) {
                linkedList.add(iVar.key);
            }
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            bt((String) it.next());
        }
        AppMethodBeat.o(92987);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0099, code lost:
        com.google.android.exoplayer2.i.x.closeQuietly(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00c2, code lost:
        com.google.android.exoplayer2.i.x.closeQuietly(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ca, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00cd, code lost:
        com.google.android.exoplayer2.i.x.closeQuietly(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00de, code lost:
        r1 = r2;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00bf A[ExcHandler: IOException (e java.io.IOException), PHI: r2 
      PHI: (r2v4 java.io.DataInputStream) = (r2v0 java.io.DataInputStream), (r2v13 java.io.DataInputStream) binds: [B:1:0x0009, B:19:0x0070] A[DONT_GENERATE, DONT_INLINE], Splitter:B:1:0x0009] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00ca A[ExcHandler: all (th java.lang.Throwable), PHI: r2 
      PHI: (r2v2 java.io.DataInputStream) = (r2v0 java.io.DataInputStream), (r2v13 java.io.DataInputStream) binds: [B:1:0x0009, B:19:0x0070] A[DONT_GENERATE, DONT_INLINE], Splitter:B:1:0x0009] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00cd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean wW() {
        /*
        // Method dump skipped, instructions count: 226
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.h.a.j.wW():boolean");
    }

    private void a(i iVar) {
        AppMethodBeat.i(92989);
        this.bGv.put(iVar.key, iVar);
        this.bGw.put(iVar.id, iVar.key);
        AppMethodBeat.o(92989);
    }

    private void b(i iVar) {
        AppMethodBeat.i(92990);
        a(iVar);
        this.bGB = true;
        AppMethodBeat.o(92990);
    }

    /* access modifiers changed from: package-private */
    public final i h(String str, long j2) {
        AppMethodBeat.i(92991);
        i iVar = new i(a(this.bGw), str, j2);
        b(iVar);
        AppMethodBeat.o(92991);
        return iVar;
    }

    private static int a(SparseArray<String> sparseArray) {
        AppMethodBeat.i(92992);
        int size = sparseArray.size();
        int keyAt = size == 0 ? 0 : sparseArray.keyAt(size - 1) + 1;
        if (keyAt < 0) {
            keyAt = 0;
            while (keyAt < size && keyAt == sparseArray.keyAt(keyAt)) {
                keyAt++;
            }
        }
        AppMethodBeat.o(92992);
        return keyAt;
    }
}
