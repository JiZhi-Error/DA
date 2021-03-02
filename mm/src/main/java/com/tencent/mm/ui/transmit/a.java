package com.tencent.mm.ui.transmit;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.q;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class a extends q {
    l Bdt = new l() {
        /* class com.tencent.mm.ui.transmit.a.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.fts.a.l
        public final void b(k kVar) {
            AppMethodBeat.i(39220);
            C2134a aVar = new C2134a(a.this, (byte) 0);
            aVar.query = kVar.wTn.query;
            aVar.wWd = kVar.wWd;
            aVar.wXb = kVar.wXb;
            if (aVar.wXb == null || aVar.wXb.size() == 0) {
                m mVar = new m();
                mVar.wVX = "no_result​";
                aVar.wXb = new ArrayList();
                aVar.wXb.add(mVar);
            }
            a.this.QxS.add(aVar);
            a.b(a.this);
            AppMethodBeat.o(39220);
        }
    };
    List<String> QxQ;
    List<com.tencent.mm.plugin.fts.a.a.a> QxR;
    List<C2134a> QxS;
    private int count = 0;
    MMHandler handler = new MMHandler(Looper.getMainLooper());
    HashSet<String> jVV;

    static /* synthetic */ boolean a(a aVar, int i2) {
        AppMethodBeat.i(39230);
        boolean aor = aVar.aor(i2);
        AppMethodBeat.o(39230);
        return aor;
    }

    static /* synthetic */ void b(a aVar) {
        AppMethodBeat.i(39229);
        aVar.gYc();
        AppMethodBeat.o(39229);
    }

    public a(n nVar, List<String> list, int i2) {
        super(nVar, (List<String>) null, true, true, i2);
        AppMethodBeat.i(39222);
        this.QxQ = list;
        this.QxS = new ArrayList();
        this.jVV = new HashSet<>();
        AppMethodBeat.o(39222);
    }

    @Override // com.tencent.mm.ui.contact.p
    public final void finish() {
        AppMethodBeat.i(39223);
        super.finish();
        for (com.tencent.mm.plugin.fts.a.a.a aVar : this.QxR) {
            ((com.tencent.mm.plugin.fts.a.n) g.ah(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(aVar);
        }
        AppMethodBeat.o(39223);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.ui.transmit.a$a  reason: collision with other inner class name */
    public class C2134a {
        String QxV;
        String query;
        h wWd;
        int wXD;
        int wXF;
        boolean wXG;
        List<m> wXb;

        private C2134a() {
            this.wXD = Integer.MAX_VALUE;
            this.wXF = Integer.MAX_VALUE;
            this.wXG = true;
        }

        /* synthetic */ C2134a(a aVar, byte b2) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.tencent.mm.ui.contact.a.a] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v23, types: [com.tencent.mm.ui.contact.a.a] */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.tencent.mm.ui.contact.p
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.ui.contact.a.a va(int r11) {
        /*
        // Method dump skipped, instructions count: 169
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.transmit.a.va(int):com.tencent.mm.ui.contact.a.a");
    }

    /* access modifiers changed from: package-private */
    public final void gYc() {
        int size;
        AppMethodBeat.i(39225);
        int i2 = 0;
        for (C2134a aVar : this.QxS) {
            if (aVar.wXb.size() > 0) {
                aVar.wXD = i2;
                int i3 = i2 + 1;
                if (aVar.wXb.size() > 3) {
                    if (aVar.wXG) {
                        size = i3 + 3;
                    } else {
                        size = i3 + aVar.wXb.size();
                    }
                    aVar.wXF = size;
                    i2 = size + 1;
                } else {
                    i2 = aVar.wXb.size() + i3;
                }
            } else {
                i2 = i2;
            }
        }
        this.count = i2;
        clearCache();
        notifyDataSetChanged();
        AppMethodBeat.o(39225);
    }

    public final int getCount() {
        return this.count;
    }

    @Override // com.tencent.mm.ui.contact.p
    public final boolean anI(int i2) {
        AppMethodBeat.i(39226);
        boolean aor = aor(i2);
        AppMethodBeat.o(39226);
        return aor;
    }

    public final List<String> gYd() {
        AppMethodBeat.i(39228);
        HashSet hashSet = new HashSet();
        for (C2134a aVar : this.QxS) {
            if (!Util.isNullOrNil(aVar.QxV)) {
                hashSet.add(aVar.QxV);
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(hashSet);
        AppMethodBeat.o(39228);
        return arrayList;
    }

    private boolean aor(int i2) {
        m mVar;
        boolean z = false;
        AppMethodBeat.i(39227);
        int headerViewsCount = i2 - this.PWg.getContentLV().getHeaderViewsCount();
        int size = this.QxS.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            }
            C2134a aVar = this.QxS.get(size);
            if (aVar.wXF == headerViewsCount) {
                if (aVar.wXG) {
                    int selectedItemPosition = this.PWg.getContentLV().getSelectedItemPosition();
                    aVar.wXG = false;
                    gYc();
                    this.PWg.getContentLV().setSelection(selectedItemPosition);
                } else {
                    aVar.wXG = true;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= aVar.wXb.size()) {
                            mVar = null;
                            i3 = 0;
                            break;
                        }
                        mVar = aVar.wXb.get(i3);
                        if (mVar.wVX.equals(aVar.QxV) && i3 > 2) {
                            break;
                        }
                        i3++;
                    }
                    if (mVar != null) {
                        aVar.wXb.remove(i3);
                        aVar.wXb.add(0, mVar);
                    }
                    gYc();
                    this.PWg.getContentLV().setSelection(i2);
                }
                notifyDataSetChanged();
                z = true;
            } else if (headerViewsCount == aVar.wXD) {
                z = true;
                break;
            } else if (i2 > aVar.wXD) {
                m mVar2 = aVar.wXb.get((headerViewsCount - aVar.wXD) - 1);
                if (!mVar2.wVX.equals("no_result​")) {
                    MMCreateChatroomUI mMCreateChatroomUI = (MMCreateChatroomUI) this.PWg;
                    if (!Util.isNullOrNil(aVar.QxV)) {
                        if (aVar.QxV.equals(mVar2.wVX)) {
                            mMCreateChatroomUI.zoy.bew(aVar.QxV);
                            this.jVV.remove(aVar.QxV);
                            aVar.QxV = null;
                        } else if (!this.jVV.contains(mVar2.wVX)) {
                            this.jVV.remove(aVar.QxV);
                            mMCreateChatroomUI.zoy.bew(aVar.QxV);
                            aVar.QxV = mVar2.wVX;
                            mMCreateChatroomUI.zoy.bex(aVar.QxV);
                            this.jVV.add(aVar.QxV);
                        }
                    } else if (!this.jVV.contains(mVar2.wVX)) {
                        mMCreateChatroomUI.zoy.bex(mVar2.wVX);
                        aVar.QxV = mVar2.wVX;
                        this.jVV.add(aVar.QxV);
                    }
                    mMCreateChatroomUI.ani();
                    notifyDataSetChanged();
                    z = true;
                }
                z = true;
            } else {
                size--;
            }
        }
        AppMethodBeat.o(39227);
        return z;
    }
}
