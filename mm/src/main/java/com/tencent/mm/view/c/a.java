package com.tencent.mm.view.c;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.c.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class a implements o {
    private com.tencent.mm.av.a.d.a<String, Bitmap> Rpz = new com.tencent.mm.av.a.d.a<>(150);

    public a() {
        AppMethodBeat.i(105276);
        AppMethodBeat.o(105276);
    }

    @Override // com.tencent.mm.av.a.c.o
    public final Bitmap EP(String str) {
        AppMethodBeat.i(105277);
        if (!Util.isNullOrNil(str)) {
            Bitmap bitmap = this.Rpz.get(str);
            AppMethodBeat.o(105277);
            return bitmap;
        }
        AppMethodBeat.o(105277);
        return null;
    }

    @Override // com.tencent.mm.av.a.c.o
    public final void put(String str, Bitmap bitmap) {
        AppMethodBeat.i(105278);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.emoji.EmojiLoaderMemoryCache", "[cpan] put failed. key is null.");
            AppMethodBeat.o(105278);
        } else if (bitmap == null) {
            Log.w("MicroMsg.emoji.EmojiLoaderMemoryCache", "[cpan] put failed.value is null.");
            AppMethodBeat.o(105278);
        } else {
            this.Rpz.put(str, bitmap);
            AppMethodBeat.o(105278);
        }
    }

    @Override // com.tencent.mm.av.a.c.o
    public final void remove(String str) {
        AppMethodBeat.i(199830);
        com.tencent.mm.av.a.d.a<String, Bitmap> aVar = this.Rpz;
        if (aVar.icd == null) {
            NullPointerException nullPointerException = new NullPointerException("mData == null");
            AppMethodBeat.o(199830);
            throw nullPointerException;
        }
        aVar.icd.remove(str);
        AppMethodBeat.o(199830);
    }

    @Override // com.tencent.mm.av.a.c.o
    public final void clear() {
        AppMethodBeat.i(105279);
        synchronized (this) {
            try {
                if (this.Rpz != null) {
                    Map<String, Bitmap> snapshot = this.Rpz.snapshot();
                    if (!snapshot.isEmpty() && snapshot.size() > 0) {
                        for (Map.Entry<String, Bitmap> entry : snapshot.entrySet()) {
                            Bitmap value = entry.getValue();
                            if (value != null && !value.isRecycled()) {
                                Log.i("MicroMsg.emoji.EmojiLoaderMemoryCache", "recycle bitmap:%s, not need", value.toString());
                            }
                        }
                    }
                    com.tencent.mm.av.a.d.a<String, Bitmap> aVar = this.Rpz;
                    if (aVar.icd == null) {
                        NullPointerException nullPointerException = new NullPointerException("mData == null");
                        AppMethodBeat.o(105279);
                        throw nullPointerException;
                    }
                    aVar.icd.trimToSize(-1);
                }
            } finally {
                AppMethodBeat.o(105279);
            }
        }
    }
}
