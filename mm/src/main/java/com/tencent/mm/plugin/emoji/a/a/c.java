package com.tencent.mm.plugin.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.emoji.model.f;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.storage.bh;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class c implements Cloneable, Iterable<f> {
    protected ArrayList<f> mItemList;
    private HashMap<String, bh> qYg;
    protected HashMap<String, bh> qYh;
    public boolean qYi;

    @Override // java.lang.Object
    public /* synthetic */ Object clone() {
        AppMethodBeat.i(108370);
        c cFp = cFp();
        AppMethodBeat.o(108370);
        return cFp;
    }

    public void clear() {
        AppMethodBeat.i(108354);
        if (this.mItemList != null) {
            this.mItemList.clear();
            this.mItemList = null;
        }
        if (this.qYg != null) {
            this.qYg.clear();
            this.qYg = null;
        }
        if (this.qYh != null) {
            this.qYh.clear();
            this.qYh = null;
        }
        AppMethodBeat.o(108354);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public c(com.tencent.mm.plugin.emoji.model.g r3) {
        /*
            r2 = this;
            r1 = 108355(0x1a743, float:1.51838E-40)
            if (r3 != 0) goto L_0x0010
            r0 = 0
        L_0x0006:
            r2.<init>(r0)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r1)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r1)
            return
        L_0x0010:
            java.util.List<com.tencent.mm.plugin.emoji.a.a.f> r0 = r3.rbt
            goto L_0x0006
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.emoji.a.a.c.<init>(com.tencent.mm.plugin.emoji.model.g):void");
    }

    public c() {
        AppMethodBeat.i(108356);
        this.qYg = new HashMap<>();
        this.qYh = new HashMap<>();
        this.qYi = z.aUn();
        AppMethodBeat.o(108356);
    }

    public c(List<f> list) {
        this();
        AppMethodBeat.i(108357);
        if (list == null) {
            AppMethodBeat.o(108357);
            return;
        }
        this.mItemList = new ArrayList<>();
        this.mItemList.addAll(list);
        AppMethodBeat.o(108357);
    }

    public final int size() {
        AppMethodBeat.i(108358);
        if (this.mItemList == null) {
            AppMethodBeat.o(108358);
            return 0;
        }
        int size = this.mItemList.size();
        AppMethodBeat.o(108358);
        return size;
    }

    public final f FS(int i2) {
        AppMethodBeat.i(108359);
        if (this.mItemList == null || this.mItemList.size() <= i2 || i2 < 0) {
            AppMethodBeat.o(108359);
            return null;
        } else if (this.mItemList == null) {
            AppMethodBeat.o(108359);
            return null;
        } else {
            f fVar = this.mItemList.get(i2);
            AppMethodBeat.o(108359);
            return fVar;
        }
    }

    public final f amb(String str) {
        AppMethodBeat.i(108360);
        if (this.mItemList != null) {
            Iterator<f> it = this.mItemList.iterator();
            while (it.hasNext()) {
                f next = it.next();
                EmotionSummary emotionSummary = next.qYl;
                if (emotionSummary != null && emotionSummary.ProductID != null && emotionSummary.ProductID.equals(str)) {
                    AppMethodBeat.o(108360);
                    return next;
                }
            }
        }
        AppMethodBeat.o(108360);
        return null;
    }

    public final c cFp() {
        c cVar;
        AppMethodBeat.i(108361);
        try {
            cVar = (c) super.clone();
            try {
                if (this.mItemList != null) {
                    cVar.mItemList = (ArrayList) this.mItemList.clone();
                }
            } catch (CloneNotSupportedException e2) {
            }
        } catch (CloneNotSupportedException e3) {
            cVar = null;
        }
        AppMethodBeat.o(108361);
        return cVar;
    }

    public void notifyDataSetChanged() {
        AppMethodBeat.i(108362);
        if (this.mItemList == null) {
            AppMethodBeat.o(108362);
            return;
        }
        this.qYh = k.getEmojiStorageMgr().OpO.gEI();
        Iterator<f> it = this.mItemList.iterator();
        while (it.hasNext()) {
            f next = it.next();
            EmotionSummary emotionSummary = next.qYl;
            if (emotionSummary != null) {
                if (com.tencent.mm.plugin.emoji.h.a.g(emotionSummary)) {
                    next.setStatus(com.tencent.mm.plugin.emoji.h.a.cHz() ? 7 : 3);
                } else {
                    String str = emotionSummary.ProductID;
                    next.a(this.qYi, amf(str), amd(str));
                }
            }
        }
        cFq();
        AppMethodBeat.o(108362);
    }

    public final void amc(String str) {
        AppMethodBeat.i(108363);
        f amb = amb(str);
        if (amb == null) {
            AppMethodBeat.o(108363);
            return;
        }
        amb.setStatus(-1);
        amb.a(this.qYi, amf(str), amd(str));
        AppMethodBeat.o(108363);
    }

    public final boolean amd(String str) {
        AppMethodBeat.i(108364);
        if (this.qYh == null) {
            AppMethodBeat.o(108364);
            return false;
        }
        boolean containsKey = this.qYh.containsKey(str);
        AppMethodBeat.o(108364);
        return containsKey;
    }

    public final bh ame(String str) {
        AppMethodBeat.i(108365);
        bh amf = amf(str);
        if (amf == null) {
            amf = new bh(str);
            this.qYg.put(str, amf);
        }
        AppMethodBeat.o(108365);
        return amf;
    }

    public final bh amf(String str) {
        AppMethodBeat.i(108366);
        bh bhVar = this.qYg.get(str);
        AppMethodBeat.o(108366);
        return bhVar;
    }

    @Override // java.lang.Iterable
    public Iterator<f> iterator() {
        AppMethodBeat.i(108367);
        a aVar = new a(this, (byte) 0);
        AppMethodBeat.o(108367);
        return aVar;
    }

    class a implements Iterator<f> {
        private int mIndex;

        private a() {
            this.mIndex = 0;
        }

        /* synthetic */ a(c cVar, byte b2) {
            this();
        }

        public final boolean hasNext() {
            AppMethodBeat.i(108352);
            if (this.mIndex < c.this.size()) {
                AppMethodBeat.o(108352);
                return true;
            }
            AppMethodBeat.o(108352);
            return false;
        }

        public final void remove() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.Iterator
        public final /* synthetic */ f next() {
            AppMethodBeat.i(108353);
            c cVar = c.this;
            int i2 = this.mIndex;
            this.mIndex = i2 + 1;
            f FS = cVar.FS(i2);
            AppMethodBeat.o(108353);
            return FS;
        }
    }

    public final void de(String str, int i2) {
        AppMethodBeat.i(108368);
        bh bhVar = this.qYg.get(str);
        if (bhVar == null) {
            AppMethodBeat.o(108368);
            return;
        }
        bhVar.akj(i2);
        AppMethodBeat.o(108368);
    }

    public void cFq() {
        int intValue;
        AppMethodBeat.i(108369);
        if (this.mItemList == null) {
            AppMethodBeat.o(108369);
        } else if (k.cGk().rbr == null) {
            AppMethodBeat.o(108369);
        } else {
            Iterator<f> it = this.mItemList.iterator();
            while (it.hasNext()) {
                f next = it.next();
                EmotionSummary emotionSummary = next.qYl;
                if (emotionSummary != null) {
                    f cGk = k.cGk();
                    Integer num = cGk.rbr.get(emotionSummary.ProductID);
                    if (num == null) {
                        intValue = -1;
                    } else {
                        intValue = num.intValue();
                    }
                    if (intValue >= 0) {
                        next.setStatus(6);
                        next.HH = intValue;
                    }
                    if (intValue < 0 && next.mStatus == 6) {
                        next.setStatus(3);
                    }
                }
            }
            AppMethodBeat.o(108369);
        }
    }
}
