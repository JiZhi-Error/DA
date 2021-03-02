package com.tencent.mm.av.a.b;

import android.graphics.Bitmap;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.c.o;
import com.tencent.mm.hardcoder.g;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class f implements o {
    private com.tencent.mm.b.f<String, Bitmap> hYQ = new b(50, getClass());
    private com.tencent.mm.b.f<String, Bitmap> hYR = new b(10, getClass());

    public f() {
        AppMethodBeat.i(130419);
        AppMethodBeat.o(130419);
    }

    @Override // com.tencent.mm.av.a.c.o
    public final Bitmap EP(String str) {
        AppMethodBeat.i(130420);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(130420);
            return null;
        } else if (this.hYQ.get(str) == null) {
            Bitmap bitmap = this.hYR.get(str);
            AppMethodBeat.o(130420);
            return bitmap;
        } else {
            Bitmap bitmap2 = this.hYQ.get(str);
            AppMethodBeat.o(130420);
            return bitmap2;
        }
    }

    @Override // com.tencent.mm.av.a.c.o
    public final void put(String str, Bitmap bitmap) {
        long j2;
        AppMethodBeat.i(130421);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "[cpan] put failed. key is null.");
            AppMethodBeat.o(130421);
        } else if (bitmap == null) {
            Log.w("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "[cpan] put failed.value is null.");
            AppMethodBeat.o(130421);
        } else {
            if (bitmap == null || !(bitmap instanceof Bitmap)) {
                j2 = 0;
            } else {
                Bitmap bitmap2 = bitmap;
                if (Build.VERSION.SDK_INT >= 12) {
                    j2 = (long) bitmap2.getByteCount();
                } else {
                    j2 = (long) (bitmap2.getHeight() * bitmap2.getRowBytes());
                }
            }
            Log.d("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "[cpan] put key:%s,bitmap size:%d B newsize:%s", str, Long.valueOf(j2), Util.getSizeKB(j2));
            if (j2 > g.ACTION_MINI_PROGRAM_LAUNCH) {
                this.hYR.put(str, bitmap);
                AppMethodBeat.o(130421);
                return;
            }
            this.hYQ.put(str, bitmap);
            AppMethodBeat.o(130421);
        }
    }

    @Override // com.tencent.mm.av.a.c.o
    public final void remove(String str) {
        AppMethodBeat.i(212681);
        this.hYQ.remove(str);
        this.hYR.remove(str);
        AppMethodBeat.o(212681);
    }

    @Override // com.tencent.mm.av.a.c.o
    public final void clear() {
        AppMethodBeat.i(130422);
        synchronized (this) {
            try {
                if (this.hYQ != null) {
                    Map<String, Bitmap> snapshot = this.hYQ.snapshot();
                    if (!snapshot.isEmpty() && snapshot.size() > 0) {
                        for (Map.Entry<String, Bitmap> entry : snapshot.entrySet()) {
                            Bitmap value = entry.getValue();
                            if (value != null && !value.isRecycled()) {
                                Log.i("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "recycle bitmap:%s, not need", value.toString());
                            }
                        }
                    }
                    this.hYQ.clear();
                }
                if (this.hYR != null) {
                    Map<String, Bitmap> snapshot2 = this.hYR.snapshot();
                    if (!snapshot2.isEmpty() && snapshot2.size() > 0) {
                        for (Map.Entry<String, Bitmap> entry2 : snapshot2.entrySet()) {
                            Bitmap value2 = entry2.getValue();
                            if (value2 != null && !value2.isRecycled()) {
                                Log.i("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "recycle bitmap:%s. not need", value2.toString());
                            }
                        }
                    }
                    this.hYR.clear();
                }
            } finally {
                AppMethodBeat.o(130422);
            }
        }
    }
}
