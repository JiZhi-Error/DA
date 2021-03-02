package com.tencent.mm.plugin.gallery.model;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.a.d;
import com.tencent.mm.plugin.gallery.model.d;
import com.tencent.mm.plugin.gallery.model.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class c {
    public d xhN = new d();
    int xhO = g.DEFAULT_CORE_POOL_SIZE;
    public h<String> xhP = new h<>();
    public HashMap<String, C1385c> xhQ = new HashMap<>();
    int xhR = (g.DEFAULT_CORE_POOL_SIZE / 2);
    private h<b> xhS = new h<>();
    h<b> xhT = new h<>();

    public c() {
        AppMethodBeat.i(111240);
        AppMethodBeat.o(111240);
    }

    public final Bitmap a(String str, int i2, String str2, long j2, long j3) {
        AppMethodBeat.i(179444);
        Bitmap a2 = a(str, i2, str2, j2, null, -1, j3);
        AppMethodBeat.o(179444);
        return a2;
    }

    public final Bitmap a(String str, int i2, String str2, long j2, s.e eVar, int i3, long j3) {
        AppMethodBeat.i(179445);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.CacheService", "file path is invalid.");
            AppMethodBeat.o(179445);
            return null;
        }
        String a2 = d.a(str, eVar, i3);
        Bitmap bitmap = this.xhN.getBitmap(d.a(str, eVar, j3));
        if (bitmap != null) {
            Log.v("MicroMsg.CacheService", "get bitmap from cache: %s.", str);
            AppMethodBeat.o(179445);
            return bitmap;
        }
        Log.d("MicroMsg.CacheService", "waitingDecodeTask size is : [%d].", Integer.valueOf(this.xhQ.size()));
        if (this.xhQ.containsKey(a2)) {
            Log.w("MicroMsg.CacheService", "%s has already getting bitmap from file, %s.", a2, str);
            AppMethodBeat.o(179445);
            return null;
        }
        this.xhP.add(a2);
        this.xhQ.put(a2, new C1385c(this, str, i2, str2, j2, eVar, i3, j3));
        Log.d("MicroMsg.CacheService", "add task: %s.", a2);
        Log.d("MicroMsg.CacheService", "filePathInService size: %s, waitingDecodeTask size: %s.", Integer.valueOf(this.xhP.size()), Integer.valueOf(this.xhQ.size()));
        dQy();
        AppMethodBeat.o(179445);
        return null;
    }

    public final Bitmap a(String str, String str2, s.e eVar, long j2) {
        AppMethodBeat.i(179446);
        if (!Util.isNullOrNil(str)) {
            str2 = str;
        }
        if (Util.isNullOrNil(str2)) {
            Log.w("MicroMsg.CacheService", "file path is null or nil.");
            AppMethodBeat.o(179446);
            return null;
        }
        Bitmap bitmap = this.xhN.getBitmap(d.a(str2, eVar, j2));
        if (bitmap != null) {
            Log.v("MicroMsg.CacheService", "get bitmap from cache: %s.", str2);
            AppMethodBeat.o(179446);
            return bitmap;
        }
        AppMethodBeat.o(179446);
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void dQy() {
        AppMethodBeat.i(111244);
        e.dQL().a(this.xhP, this.xhQ);
        AppMethodBeat.o(111244);
    }

    public abstract class a implements QueueWorkerThread.ThreadObject {
        public a() {
        }

        @Override // com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject
        public boolean onPostExecute() {
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.model.c$c  reason: collision with other inner class name */
    public class C1385c extends a {
        Bitmap bitmap;
        public volatile boolean mCancel;
        String mFilePath;
        int mPosition;
        private int mediaType;
        private String xhV;
        private long xhW;
        int xhX;
        long xhY;
        s.e xhZ;
        String xia;

        C1385c(c cVar, String str, int i2, String str2, long j2, s.e eVar, int i3, long j3) {
            this(str, i2, str2, j2, eVar, i3, j3, (byte) 0);
        }

        private C1385c(String str, int i2, String str2, long j2, s.e eVar, int i3, long j3, byte b2) {
            super();
            AppMethodBeat.i(179443);
            this.mFilePath = str;
            this.mediaType = i2;
            this.xhV = str2;
            this.xhW = j2;
            this.xhX = 12288;
            this.xhZ = eVar;
            this.mPosition = i3;
            this.xhY = j3;
            this.xia = d.a(str, eVar, i3);
            AppMethodBeat.o(179443);
        }

        @Override // com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject
        public final boolean doInBackground() {
            AppMethodBeat.i(111237);
            Log.d("MicroMsg.CacheService", "task execute, mDecodeTaskKey: %s, filePath: %s, isCancel: %s.", this.xia, this.mFilePath, Boolean.valueOf(this.mCancel));
            if (this.mCancel) {
                AppMethodBeat.o(111237);
                return false;
            }
            this.bitmap = c.this.xhN.b(this.mFilePath, this.xhV, this.xhZ, this.xhY);
            if (this.bitmap != null && !this.bitmap.isRecycled()) {
                Log.d("MicroMsg.CacheService", "get bmp from disk cache ok, mDecodeTaskKey[%s] filePath[%s].", this.xia, this.mFilePath);
                AppMethodBeat.o(111237);
                return true;
            } else if (this.mCancel) {
                AppMethodBeat.o(111237);
                return false;
            } else {
                if (this.xhZ != null) {
                    this.bitmap = n.a(this.mFilePath, this.xhZ);
                    if (this.bitmap == null || this.bitmap.isRecycled()) {
                        Log.d("MicroMsg.CacheService", "getPortraitBitmap err, mDecodeTaskKey[%s] filePath[%s].", this.xia, this.mFilePath);
                    } else {
                        Log.d("MicroMsg.CacheService", "getPortraitBitmap ok, mDecodeTaskKey[%s] filePath[%s].", this.xia, this.mFilePath);
                        AppMethodBeat.o(111237);
                        return true;
                    }
                }
                if (this.mCancel) {
                    AppMethodBeat.o(111237);
                    return false;
                }
                this.bitmap = n.a(this.xhW, this.mediaType, this.mFilePath, this.xhV);
                if (this.bitmap == null || this.bitmap.isRecycled()) {
                    AppMethodBeat.o(111237);
                    return false;
                }
                c.this.xhN.a(this.mFilePath, this.xhV, this.bitmap, this.xhZ, this.xhY);
                AppMethodBeat.o(111237);
                return true;
            }
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(111238);
            if (obj == null) {
                AppMethodBeat.o(111238);
                return false;
            } else if (this == obj) {
                AppMethodBeat.o(111238);
                return true;
            } else if (obj instanceof C1385c) {
                boolean equals = Util.nullAs(this.mFilePath, "").equals(((C1385c) obj).mFilePath);
                AppMethodBeat.o(111238);
                return equals;
            } else {
                AppMethodBeat.o(111238);
                return false;
            }
        }

        public final int hashCode() {
            AppMethodBeat.i(111239);
            int hashCode = Util.nullAs(this.mFilePath, "").hashCode();
            AppMethodBeat.o(111239);
            return hashCode;
        }
    }

    public final void a(d.b bVar) {
        AppMethodBeat.i(111245);
        d dVar = this.xhN;
        Log.d("MicroMsg.GalleryCache", "try add listener[%s].", bVar);
        if (dVar.xid.size() > 256) {
            Log.d("MicroMsg.GalleryCache", "start clear logic: %s.", Integer.valueOf(dVar.xid.size()));
            for (int i2 = 0; i2 < 128; i2++) {
                String str = dVar.xid.get(i2);
                if (!Util.isNullOrNil(str)) {
                    dVar.xie.remove(str);
                }
            }
            dVar.xid.subList(0, 128).clear();
            Log.d("MicroMsg.GalleryCache", "finish clear logic: %s.", Integer.valueOf(dVar.xid.size()));
        }
        if (Util.isNullOrNil(bVar.dQG())) {
            Log.e("MicroMsg.GalleryCache", "error! fileKey is invalid!!!");
            AppMethodBeat.o(111245);
        } else if (dVar.xie.containsKey(bVar.dQG())) {
            Log.d("MicroMsg.GalleryCache", "listener already exist!!! %s, update!!!.", bVar);
            dVar.xid.remove(bVar.dQG());
            dVar.xid.add(bVar.dQG());
            dVar.xie.put(bVar.dQG(), bVar);
            AppMethodBeat.o(111245);
        } else {
            Log.d("MicroMsg.GalleryCache", "add listener[%s] ok.", bVar);
            dVar.xid.add(bVar.dQG());
            dVar.xie.put(bVar.dQG(), bVar);
            AppMethodBeat.o(111245);
        }
    }

    public final void b(d.b bVar) {
        AppMethodBeat.i(111246);
        d dVar = this.xhN;
        if (bVar == null) {
            dVar.dQF();
            dVar.iKx.removeAll();
            AppMethodBeat.o(111246);
            return;
        }
        String dQG = bVar.dQG();
        if (dVar.xie.containsKey(bVar.dQG())) {
            dVar.xie.remove(dQG);
            dVar.xid.remove(dQG);
        }
        AppMethodBeat.o(111246);
    }

    /* access modifiers changed from: package-private */
    public final boolean dQz() {
        return this.xhO > 0;
    }

    /* access modifiers changed from: package-private */
    public final void dQA() {
        this.xhO--;
    }

    public final void eT(List<String> list) {
        AppMethodBeat.i(111247);
        if (this.xhQ != null && !this.xhQ.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, C1385c> entry : this.xhQ.entrySet()) {
                if (!list.contains(entry.getKey())) {
                    C1385c value = entry.getValue();
                    if (value != null) {
                        value.mCancel = true;
                    }
                    Log.d("MicroMsg.CacheService", "cancelTask, success : %s.", entry.getKey());
                    arrayList.add(entry.getKey());
                }
            }
            Log.d("MicroMsg.CacheService", "cancelTask, counter: %s.", Integer.valueOf(arrayList.size()));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                this.xhP.dr(str);
                this.xhQ.remove(str);
            }
        }
        AppMethodBeat.o(111247);
    }

    /* access modifiers changed from: package-private */
    public final boolean dQB() {
        return this.xhR > 0;
    }

    /* access modifiers changed from: package-private */
    public final void dQC() {
        this.xhR--;
    }

    public final void b(String str, int i2, String str2, long j2, long j3) {
        AppMethodBeat.i(179447);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.CacheService", "trySubmitPreDecodeTask, file path is invalid.");
            AppMethodBeat.o(179447);
            return;
        }
        String a2 = com.tencent.mm.plugin.gallery.a.d.a(str, (s.e) null, -1);
        Bitmap bitmap = this.xhN.getBitmap(com.tencent.mm.plugin.gallery.a.d.a(str, (s.e) null, j3));
        if (bitmap == null || bitmap.isRecycled()) {
            Log.d("MicroMsg.CacheService", "pre decode info: %s %s stack %s.", a2, str, Util.getStack());
            if (this.xhS.size() > 82) {
                Log.d("MicroMsg.CacheService", "remove task: %s.", this.xhS.dRl().mFilePath);
            }
            this.xhS.add(new b(str, i2, str2, j2, j3));
            dQD();
            AppMethodBeat.o(179447);
            return;
        }
        Log.v("MicroMsg.CacheService", "trySubmitPreDecodeTask, no need decode.");
        AppMethodBeat.o(179447);
    }

    public final void dQD() {
        AppMethodBeat.i(111249);
        Log.d("MicroMsg.CacheService", "tryStartPreDecode: %s %s.", Integer.valueOf(this.xhS.size()), Integer.valueOf(this.xhT.size()));
        e.dQL().a(this.xhS, this.xhT);
        AppMethodBeat.o(111249);
    }

    public final void dQE() {
        AppMethodBeat.i(111250);
        Iterator it = this.xhT.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar != null) {
                bVar.mCancel = true;
            }
        }
        this.xhT.clear();
        this.xhS.clear();
        AppMethodBeat.o(111250);
    }

    public class b extends a {
        Bitmap bitmap;
        volatile boolean mCancel;
        String mFilePath;
        private int mediaType;
        private String xhV;
        private long xhW;
        int xhX = 12288;
        long xhY;

        public b(String str, int i2, String str2, long j2, long j3) {
            super();
            this.mFilePath = str;
            this.mediaType = i2;
            this.xhV = str2;
            this.xhW = j2;
            this.xhY = j3;
        }

        @Override // com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject
        public final boolean doInBackground() {
            AppMethodBeat.i(111235);
            Log.d("MicroMsg.PreDecodeFile", "start doInBackground.");
            if (this.mCancel) {
                AppMethodBeat.o(111235);
                return false;
            }
            this.bitmap = c.this.xhN.b(this.mFilePath, this.xhV, null, this.xhY);
            if (this.bitmap != null && !this.bitmap.isRecycled()) {
                Log.d("MicroMsg.PreDecodeFile", "get bmp from disk cache ok, filePath[%s].", this.mFilePath);
                AppMethodBeat.o(111235);
                return true;
            } else if (this.mCancel) {
                AppMethodBeat.o(111235);
                return false;
            } else {
                this.bitmap = n.a(this.xhW, this.mediaType, this.mFilePath, this.xhV);
                if (this.bitmap == null || this.bitmap.isRecycled()) {
                    AppMethodBeat.o(111235);
                    return false;
                }
                Log.d("MicroMsg.PreDecodeFile", "get bmp from file ok, filePath[%s].", this.mFilePath);
                c.this.xhN.a(this.mFilePath, this.xhV, this.bitmap, null, this.xhY);
                AppMethodBeat.o(111235);
                return true;
            }
        }
    }
}
