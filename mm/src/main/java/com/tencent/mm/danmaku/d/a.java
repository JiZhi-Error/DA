package com.tencent.mm.danmaku.d;

import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;

public final class a {
    public final LinkedList<C0312a> gQm = new LinkedList<>();
    private final LinkedList<C0312a> gQn = new LinkedList<>();
    private final int gQo;
    public int gQp;
    public int gQq;
    public int gQr;

    /* renamed from: com.tencent.mm.danmaku.d.a$a  reason: collision with other inner class name */
    public static class C0312a {
        int gQs;
        Bitmap mBitmap;
        int mHeight;
        int mSize;
        int mWidth;

        private C0312a() {
        }

        /* synthetic */ C0312a(byte b2) {
            this();
        }

        /* access modifiers changed from: package-private */
        public final void reset() {
            this.mBitmap = null;
            this.mWidth = 0;
            this.mHeight = 0;
            this.mSize = 0;
            this.gQs = 0;
        }

        /* access modifiers changed from: package-private */
        public final void y(Bitmap bitmap) {
            AppMethodBeat.i(241739);
            this.mBitmap = bitmap;
            this.mWidth = bitmap.getWidth();
            this.mHeight = bitmap.getHeight();
            this.mSize = bitmap.getHeight() * bitmap.getWidth();
            this.gQs = bitmap.getRowBytes() * bitmap.getHeight();
            AppMethodBeat.o(241739);
        }

        public final void destroy() {
            AppMethodBeat.i(241740);
            if (this.mBitmap != null && !this.mBitmap.isRecycled() && !com.tencent.mm.danmaku.f.a.atn()) {
                this.mBitmap.recycle();
            }
            reset();
            AppMethodBeat.o(241740);
        }
    }

    public a() {
        AppMethodBeat.i(241741);
        DisplayMetrics displayMetrics = com.tencent.mm.danmaku.f.a.atr().getResources().getDisplayMetrics();
        this.gQo = displayMetrics.heightPixels * displayMetrics.widthPixels * 6;
        AppMethodBeat.o(241741);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0030, code lost:
        if (r1.mSize >= r0.mSize) goto L_0x0032;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.Bitmap getBitmap(int r8, int r9) {
        /*
        // Method dump skipped, instructions count: 112
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.danmaku.d.a.getBitmap(int, int):android.graphics.Bitmap");
    }

    public final void x(Bitmap bitmap) {
        AppMethodBeat.i(241743);
        if (bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.o(241743);
            return;
        }
        this.gQp += bitmap.getRowBytes() * bitmap.getHeight();
        C0312a atk = atk();
        atk.y(bitmap);
        this.gQm.addLast(atk);
        atj();
        AppMethodBeat.o(241743);
    }

    private void atj() {
        AppMethodBeat.i(241744);
        while (this.gQp > this.gQo) {
            C0312a aVar = null;
            Iterator<C0312a> it = this.gQm.iterator();
            while (it.hasNext()) {
                aVar = it.next();
                if (aVar != null) {
                    if (aVar.mSize <= aVar.mSize) {
                        aVar = aVar;
                    }
                }
            }
            if (aVar != null) {
                this.gQm.remove(aVar);
                this.gQp -= aVar.gQs;
                aVar.destroy();
                this.gQn.addLast(aVar);
            }
        }
        AppMethodBeat.o(241744);
    }

    private C0312a atk() {
        AppMethodBeat.i(241745);
        C0312a poll = this.gQn.poll();
        if (poll == null) {
            poll = new C0312a((byte) 0);
        }
        AppMethodBeat.o(241745);
        return poll;
    }
}
