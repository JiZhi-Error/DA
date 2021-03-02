package com.tencent.mm.plugin.translate.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.translate.a.c;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ekr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.Queue;

public final class d implements i {
    public SparseArray<c.C1840c> Gts = null;
    public boolean Gtt = false;
    public b Gtu;
    a Gtv;
    public MTimerHandler Gtw = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.translate.a.d.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(29749);
            if (d.this.Gtt) {
                Log.e("MicroMsg.WorkingTranslate", "this work is time out, index: %s", Integer.valueOf(d.this.index));
                d.this.fAp();
                d.this.Gtv.a(-1, d.this.Gts, null);
            }
            AppMethodBeat.o(29749);
            return false;
        }
    }, false);
    public int index;
    private long start;

    public d(int i2, a aVar) {
        AppMethodBeat.i(29750);
        this.index = i2;
        this.Gtv = aVar;
        AppMethodBeat.o(29750);
    }

    public final boolean e(Queue<c.C1840c> queue) {
        AppMethodBeat.i(29751);
        if (this.Gtt) {
            AppMethodBeat.o(29751);
            return false;
        }
        this.Gts = new SparseArray<>();
        if (queue.size() == 0) {
            AppMethodBeat.o(29751);
            return false;
        }
        this.Gtt = true;
        LinkedList linkedList = new LinkedList();
        int i2 = 0;
        while (i2 < 512 && queue.size() > 0) {
            c.C1840c peek = queue.peek();
            int length = peek.eeq.getBytes().length;
            if (i2 == 0 || i2 + length <= 512) {
                queue.poll();
                ekr ekr = new ekr();
                ekr.NjV = peek.Gtp;
                ekr.NjW = peek.eeq;
                ekr.LRE = new SKBuiltinBuffer_t().setBuffer(peek.fRc);
                if (peek.type == 1 || ab.Eq(peek.source)) {
                    ekr.NjX = peek.source;
                }
                switch (peek.type) {
                    case 0:
                        ekr.Scene = 1;
                        break;
                    case 1:
                        ekr.Scene = 4;
                        break;
                    case 2:
                        ekr.Scene = 2;
                        break;
                    case 3:
                        ekr.Scene = 3;
                        break;
                }
                Log.d("MicroMsg.WorkingTranslate", "eventMsg.type: %d, msg.Scene:%d, id: %s", Integer.valueOf(peek.type), Integer.valueOf(ekr.Scene), peek.id);
                linkedList.add(ekr);
                this.Gts.put(peek.Gtp, peek);
            }
            i2 += length;
        }
        this.Gtu = new b(linkedList);
        bg.azz().a(this.Gtu, 0);
        this.start = System.currentTimeMillis();
        this.Gtw.startTimer(Util.MILLSECONDS_OF_MINUTE);
        AppMethodBeat.o(29751);
        return true;
    }

    public final void fAp() {
        this.Gtu = null;
        this.Gtt = false;
    }

    public final void init() {
        AppMethodBeat.i(29752);
        bg.azz().a(631, this);
        AppMethodBeat.o(29752);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        int i4;
        AppMethodBeat.i(29753);
        if (this.Gtu != qVar) {
            Log.e("MicroMsg.WorkingTranslate", "not my translate work");
            AppMethodBeat.o(29753);
            return;
        }
        this.Gtw.stopTimer();
        Log.d("MicroMsg.WorkingTranslate", "translate take time : %s", Long.valueOf(System.currentTimeMillis() - this.start));
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = Integer.valueOf(i3);
        objArr[2] = str;
        if (((b) qVar).Gtk != null) {
            i4 = ((b) qVar).Gtk.size();
        } else {
            i4 = 0;
        }
        objArr[3] = Integer.valueOf(i4);
        Log.d("MicroMsg.WorkingTranslate", "errType : %s, errCode : %s, errMsg : %s, translatedMsg.size() : %s", objArr);
        fAp();
        this.Gtv.a(i3, this.Gts, ((b) qVar).Gtk);
        AppMethodBeat.o(29753);
    }
}
