package com.tencent.mm.cache;

import android.graphics.Canvas;
import android.graphics.PorterDuff;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.z.c;
import com.tencent.mm.z.f;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Stack;

public final class d implements f<c> {
    private int gpA;
    public Stack<c> gpx;
    public Stack<c> gpy;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.mm.cache.f
    public final /* synthetic */ void add(c cVar) {
        AppMethodBeat.i(9225);
        a(cVar);
        AppMethodBeat.o(9225);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.cache.f
    public final /* synthetic */ c pop() {
        AppMethodBeat.i(9226);
        c alH = alH();
        AppMethodBeat.o(9226);
        return alH;
    }

    @Override // com.tencent.mm.cache.f
    public final void onCreate() {
        AppMethodBeat.i(9211);
        Log.i("MicroMsg.EmojiAndTextCache", "[onCreate]");
        this.gpx = new Stack<>();
        AppMethodBeat.o(9211);
    }

    @Override // com.tencent.mm.cache.f
    public final void onDestroy() {
        AppMethodBeat.i(9212);
        Log.i("MicroMsg.EmojiAndTextCache", "[onDestroy]");
        if (this.gpx != null) {
            Iterator<c> it = this.gpx.iterator();
            while (it.hasNext()) {
                it.next().clear();
            }
            this.gpx.clear();
        }
        if (this.gpy != null) {
            Iterator<c> it2 = this.gpy.iterator();
            while (it2.hasNext()) {
                it2.next().clear();
            }
            this.gpy.clear();
        }
        AppMethodBeat.o(9212);
    }

    @Override // com.tencent.mm.cache.f
    public final void dl(boolean z) {
        AppMethodBeat.i(9213);
        Log.i("MicroMsg.EmojiAndTextCache", "[onSave] size:%s isExit:%s", Integer.valueOf(this.gpx.size()), Boolean.valueOf(z));
        if (this.gpy != null) {
            this.gpy.clear();
        }
        this.gpy = new Stack<>();
        Iterator<c> it = this.gpx.iterator();
        while (it.hasNext()) {
            this.gpy.push(it.next().ayz());
        }
        Log.i("MicroMsg.EmojiAndTextCache", "[onSave] mLastStack size:%s", Integer.valueOf(this.gpy.size()));
        if (z) {
            this.gpx.clear();
            Iterator<c> it2 = this.gpy.iterator();
            while (it2.hasNext()) {
                c next = it2.next();
                Log.d("MicroMsg.EmojiItem", "[recycleBitmap]");
                if (next.hoj != null && !next.hoj.isRecycled()) {
                    Log.i("MicroMsg.EmojiItem", "bitmap recycle %s", next.hoj.toString());
                    next.hoj.recycle();
                }
            }
        }
        AppMethodBeat.o(9213);
    }

    @Override // com.tencent.mm.cache.f
    public final void alC() {
        AppMethodBeat.i(9214);
        Log.i("MicroMsg.EmojiAndTextCache", "[onRestore] size:%s isExit:%s", Integer.valueOf(this.gpx.size()), Boolean.FALSE);
        this.gpx.clear();
        if (this.gpy != null) {
            Log.i("MicroMsg.EmojiAndTextCache", "[onRestore] %s", Integer.valueOf(this.gpy.size()));
            this.gpx.addAll(this.gpy);
        }
        Log.i("MicroMsg.EmojiAndTextCache", "[onRestore] mCurStack size:%s ", Integer.valueOf(this.gpx.size()));
        Iterator<c> it = this.gpx.iterator();
        while (it.hasNext()) {
            it.next().ayu();
        }
        AppMethodBeat.o(9214);
    }

    @Override // com.tencent.mm.cache.f
    public final void a(Canvas canvas, boolean z) {
        AppMethodBeat.i(9215);
        if (z) {
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            Iterator<c> it = this.gpx.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (!next.gwn) {
                    next.draw(canvas);
                }
            }
            AppMethodBeat.o(9215);
            return;
        }
        c alI = alI();
        if (alI != null && !alI.gwn) {
            alI.draw(canvas);
        }
        AppMethodBeat.o(9215);
    }

    @Override // com.tencent.mm.cache.f
    public final void e(Canvas canvas) {
        AppMethodBeat.i(9216);
        Iterator<c> it = this.gpx.iterator();
        while (it.hasNext()) {
            c next = it.next();
            next.setSelected(false);
            next.draw(canvas);
        }
        AppMethodBeat.o(9216);
    }

    public final c alH() {
        AppMethodBeat.i(9217);
        c pop = this.gpx.pop();
        AppMethodBeat.o(9217);
        return pop;
    }

    public final c alI() {
        AppMethodBeat.i(9218);
        if (this.gpx == null || this.gpx.size() <= 0) {
            AppMethodBeat.o(9218);
            return null;
        }
        c peek = this.gpx.peek();
        AppMethodBeat.o(9218);
        return peek;
    }

    public final void a(c cVar) {
        AppMethodBeat.i(9219);
        if (this.gpx != null) {
            this.gpx.push(cVar);
        }
        AppMethodBeat.o(9219);
    }

    @Override // com.tencent.mm.cache.f
    public final void clear() {
        AppMethodBeat.i(204750);
        if (this.gpx != null) {
            this.gpx.clear();
        }
        AppMethodBeat.o(204750);
    }

    @Override // com.tencent.mm.cache.f
    public final int ai(boolean z) {
        AppMethodBeat.i(9220);
        if (z) {
            if (this.gpx != null) {
                int size = this.gpx.size();
                AppMethodBeat.o(9220);
                return size;
            }
            AppMethodBeat.o(9220);
            return 0;
        } else if (this.gpy != null) {
            int size2 = this.gpy.size();
            AppMethodBeat.o(9220);
            return size2;
        } else {
            AppMethodBeat.o(9220);
            return 0;
        }
    }

    @Override // com.tencent.mm.cache.f
    public final void Ya() {
        this.gpA++;
    }

    public final void b(c cVar) {
        AppMethodBeat.i(9221);
        if (cVar == null) {
            AppMethodBeat.o(9221);
            return;
        }
        this.gpx.remove(this.gpx.indexOf(cVar));
        this.gpx.push(cVar);
        AppMethodBeat.o(9221);
    }

    public final ListIterator<c> alJ() {
        AppMethodBeat.i(9222);
        ListIterator<c> listIterator = this.gpx.listIterator(this.gpx.size());
        AppMethodBeat.o(9222);
        return listIterator;
    }

    public final int[] dm(boolean z) {
        AppMethodBeat.i(9223);
        int[] iArr = new int[2];
        if (z) {
            Iterator<c> it = this.gpx.iterator();
            while (it.hasNext()) {
                if (it.next() instanceof f) {
                    iArr[1] = iArr[1] + 1;
                } else {
                    iArr[0] = iArr[0] + 1;
                }
            }
        } else if (this.gpy != null) {
            Iterator<c> it2 = this.gpy.iterator();
            while (it2.hasNext()) {
                if (it2.next() instanceof f) {
                    iArr[1] = iArr[1] + 1;
                } else {
                    iArr[0] = iArr[0] + 1;
                }
            }
        }
        AppMethodBeat.o(9223);
        return iArr;
    }

    public final String[] Dq(String str) {
        AppMethodBeat.i(9224);
        String[] strArr = {"", ""};
        Iterator<c> it = this.gpx.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next instanceof f) {
                strArr[1] = strArr[1] + ((f) next).hoI.toString() + str;
            } else {
                strArr[0] = strArr[0] + next.hoi.getMd5() + str;
            }
        }
        AppMethodBeat.o(9224);
        return strArr;
    }
}
