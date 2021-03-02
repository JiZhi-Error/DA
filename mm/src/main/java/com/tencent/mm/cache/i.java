package com.tencent.mm.cache;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cl.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.vfs.s;
import com.tencent.mm.z.e;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

public final class i implements f<e> {
    public int gpA;
    private SparseArray<String> gpH;
    private HashMap<String, Bitmap> gpI;
    private Stack<e> gpx;
    private Stack<e> gpy;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.mm.cache.f
    public final /* synthetic */ void add(e eVar) {
        AppMethodBeat.i(9238);
        a(eVar);
        AppMethodBeat.o(9238);
    }

    @Override // com.tencent.mm.cache.f
    public final void onCreate() {
        AppMethodBeat.i(9228);
        Log.i("MicroMsg.MosaicCache", "[onCreate]");
        this.gpx = new Stack<>();
        this.gpH = new SparseArray<>();
        this.gpI = new HashMap<>();
        AppMethodBeat.o(9228);
    }

    @Override // com.tencent.mm.cache.f
    public final void onDestroy() {
        AppMethodBeat.i(9229);
        if (this.gpx != null) {
            Iterator<e> it = this.gpx.iterator();
            while (it.hasNext()) {
                it.next();
            }
            this.gpx.clear();
        }
        if (this.gpy != null) {
            Iterator<e> it2 = this.gpy.iterator();
            while (it2.hasNext()) {
                it2.next();
            }
            this.gpy.clear();
        }
        this.gpH.clear();
        for (Map.Entry<String, Bitmap> entry : this.gpI.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                Log.i("MicroMsg.MosaicCache", "bitmap recycle %s", value.toString());
                value.recycle();
            }
        }
        this.gpI.clear();
        AppMethodBeat.o(9229);
    }

    @Override // com.tencent.mm.cache.f
    public final void dl(boolean z) {
        AppMethodBeat.i(9230);
        Log.i("MicroMsg.MosaicCache", "[onSave] size:%s", Integer.valueOf(this.gpx.size()));
        if (this.gpy != null) {
            this.gpy.clear();
        }
        this.gpy = (Stack) this.gpx.clone();
        if (z) {
            this.gpx.clear();
        }
        AppMethodBeat.o(9230);
    }

    @Override // com.tencent.mm.cache.f
    public final void alC() {
        AppMethodBeat.i(9231);
        Log.i("MicroMsg.MosaicCache", "[onRestore] size:%s", Integer.valueOf(this.gpx.size()));
        this.gpx.clear();
        if (this.gpy != null) {
            Log.i("MicroMsg.MosaicCache", "[onRestore] %s", Integer.valueOf(this.gpy.size()));
            this.gpx.addAll(this.gpy);
        }
        AppMethodBeat.o(9231);
    }

    @Override // com.tencent.mm.cache.f
    public final void a(Canvas canvas, boolean z) {
        e eVar;
        AppMethodBeat.i(9232);
        if (!z) {
            if (this.gpx == null || this.gpx.size() <= 0) {
                eVar = null;
            } else {
                eVar = this.gpx.peek();
            }
            if (eVar != null && eVar.dty == e.a.ONE) {
                eVar.draw(canvas);
            }
        }
        AppMethodBeat.o(9232);
    }

    @Override // com.tencent.mm.cache.f
    public final void e(Canvas canvas) {
        AppMethodBeat.i(9233);
        Bitmap alK = alK();
        if (alK != null && !alK.isRecycled()) {
            canvas.drawBitmap(alK, 0.0f, 0.0f, (Paint) null);
        }
        AppMethodBeat.o(9233);
    }

    public final void u(Bitmap bitmap) {
        AppMethodBeat.i(9234);
        final Bitmap copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        final String boD = a.boD(com.tencent.mm.e.a.MOSAIC.toString());
        Log.i("MicroMsg.MosaicCache", "[saveCacheToLocal] path:%s size:%s", boD, Integer.valueOf(ai(true)));
        String str = this.gpH.get(ai(true));
        if (!Util.isNullOrNil(str)) {
            s.deleteFile(str);
            this.gpH.remove(ai(true));
        }
        this.gpH.put(ai(true), boD);
        this.gpI.put(boD, copy);
        ThreadPool.postAtFront(new Runnable() {
            /* class com.tencent.mm.cache.i.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(9227);
                try {
                    BitmapUtil.saveBitmapToImage(copy, 50, Bitmap.CompressFormat.PNG, boD, true);
                    AppMethodBeat.o(9227);
                } catch (IOException e2) {
                    Log.printErrStackTrace("MicroMsg.MosaicCache", e2, "", new Object[0]);
                    AppMethodBeat.o(9227);
                }
            }
        }, "[saveCacheToLocal] mosaic path:".concat(String.valueOf(boD)));
        AppMethodBeat.o(9234);
    }

    public final Bitmap alK() {
        Bitmap bitmap;
        AppMethodBeat.i(9235);
        String str = this.gpH.get(ai(true));
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.MosaicCache", "[getCacheFromLocal] path is null");
            AppMethodBeat.o(9235);
            return null;
        }
        Log.i("MicroMsg.MosaicCache", "[getCacheFromLocal] path:%s size:%s", str, Integer.valueOf(ai(true)));
        if (this.gpI.containsKey(str)) {
            bitmap = this.gpI.get(str);
        } else {
            bitmap = null;
        }
        if (bitmap == null || bitmap.isRecycled()) {
            Log.i("MicroMsg.MosaicCache", "");
            bitmap = BitmapUtil.getBitmapNative(str);
            Log.i("MicroMsg.MosaicCache", "[getCacheFromLocal] get from local!");
        }
        if (bitmap == null) {
            Log.e("MicroMsg.MosaicCache", "[getCacheFromLocal] null == bitmap path:%s", str);
            AppMethodBeat.o(9235);
            return null;
        }
        Bitmap copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        Log.i("MicroMsg.MosaicCache", "bitmap recycle %s", bitmap);
        bitmap.recycle();
        AppMethodBeat.o(9235);
        return copy;
    }

    public final void a(e eVar) {
        AppMethodBeat.i(9236);
        if (this.gpx != null) {
            this.gpx.push(eVar);
        }
        AppMethodBeat.o(9236);
    }

    @Override // com.tencent.mm.cache.f
    public final void clear() {
        AppMethodBeat.i(204751);
        if (this.gpx != null) {
            this.gpx.clear();
        }
        AppMethodBeat.o(204751);
    }

    @Override // com.tencent.mm.cache.f
    public final int ai(boolean z) {
        AppMethodBeat.i(9237);
        if (z) {
            if (this.gpx != null) {
                int size = this.gpx.size();
                AppMethodBeat.o(9237);
                return size;
            }
            AppMethodBeat.o(9237);
            return 0;
        } else if (this.gpy != null) {
            int size2 = this.gpy.size();
            AppMethodBeat.o(9237);
            return size2;
        } else {
            AppMethodBeat.o(9237);
            return 0;
        }
    }

    @Override // com.tencent.mm.cache.f
    public final void Ya() {
        this.gpA++;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.cache.f
    public final /* synthetic */ e pop() {
        AppMethodBeat.i(9239);
        if (this.gpx.size() <= 0) {
            Log.e("MicroMsg.MosaicCache", "[pop]");
            AppMethodBeat.o(9239);
            return null;
        }
        e pop = this.gpx.pop();
        AppMethodBeat.o(9239);
        return pop;
    }
}
