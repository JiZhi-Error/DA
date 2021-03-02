package com.tencent.mm.plugin.fts.ui;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a.h;
import com.tencent.mm.plugin.fts.ui.c.a;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashSet;

public final class j extends d implements e.b {
    private boolean khr;
    private int mve;
    private int rjr;
    private MMHandler xad = new MMHandler(Looper.getMainLooper());
    private boolean xbo;
    private e xbu;
    private a xbv;
    private boolean xbw;
    private MMHandler xbx = new MMHandler(Looper.getMainLooper()) {
        /* class com.tencent.mm.plugin.fts.ui.j.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(111930);
            switch (message.what) {
                case 1:
                    Log.d("MicroMsg.FTS.FTSDetailAdapter", "ImageEngine attach is true");
                    if (!j.this.xbw && j.this.getCount() > 0) {
                        ((n) g.ah(n.class)).getFTSImageLoader().dOn();
                        o.DCM.start();
                        j.this.notifyDataSetChanged();
                        break;
                    }
            }
            AppMethodBeat.o(111930);
        }
    };
    private boolean xby;

    public j(e eVar, int i2, int i3) {
        super(eVar);
        AppMethodBeat.i(111931);
        this.rjr = i2;
        Context context = getContext();
        int i4 = -1;
        switch (i2) {
            case -15:
                i4 = 4240;
                break;
            case -13:
                i4 = 4224;
                break;
            case -7:
                i4 = 4208;
                break;
            case -6:
                i4 = 4160;
                break;
            case -5:
                i4 = 4144;
                break;
            case -4:
                i4 = 4112;
                break;
            case -3:
                i4 = 4128;
                break;
            case -2:
                i4 = 4176;
                break;
            case -1:
                i4 = 4192;
                break;
        }
        Log.i("MicroMsg.FTS.FTSDetailAdapter", "searchType=%d | uiLogicType=%d", Integer.valueOf(i4), Integer.valueOf(i4));
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(Integer.valueOf(i4));
        this.xbu = ((n) g.ah(n.class)).createFTSUIUnitList(hashSet, context, this, i3).get(0);
        this.xbv = new a();
        this.mve = i3;
        AppMethodBeat.o(111931);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.d
    public final com.tencent.mm.plugin.fts.a.d.a.a No(int i2) {
        AppMethodBeat.i(111932);
        com.tencent.mm.plugin.fts.a.d.a.a No = this.xbu.No(i2);
        if (No != null) {
            No.wXL = i2;
            No.pageType = 2;
        }
        AppMethodBeat.o(111932);
        return No;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.d
    public final void dPb() {
        AppMethodBeat.i(111933);
        this.khr = true;
        this.xbo = false;
        this.xbv.xej = d.Ni(this.mve);
        this.xbu.a(this.query, this.xad, new HashSet<>(), 0);
        AppMethodBeat.o(111933);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.d
    public final void clearCache() {
        AppMethodBeat.i(111934);
        super.clearCache();
        this.xbv.reset();
        this.xbu.clearData();
        this.xbu.dOG();
        this.xbx.removeMessages(1);
        AppMethodBeat.o(111934);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.d
    public final boolean a(View view, com.tencent.mm.plugin.fts.a.d.a.a aVar, boolean z) {
        AppMethodBeat.i(111935);
        this.xbu.a(view, aVar, z);
        if (aVar.wXT) {
            Log.d("MicroMsg.FTS.FTSDetailAdapter", "searchType=%d | searchScene=%d | kvPosition=%d | kvSubPosition=%d | kvSearchId=%s | kvDocId=%d", Integer.valueOf(aVar.rjr), Integer.valueOf(aVar.mve), Integer.valueOf(aVar.wXL), Integer.valueOf(aVar.wXM), aVar.wXN, Long.valueOf(aVar.wXO));
            if (!this.xbo) {
                l.c(this.query, true, dOI(), aVar.rjr);
                this.xbo = true;
            }
            l.a(aVar, this.xbv);
        } else if (aVar instanceof h) {
            this.xby = true;
            l.a(aVar, this.xbv);
        }
        AppMethodBeat.o(111935);
        return false;
    }

    @Override // com.tencent.mm.plugin.fts.ui.d
    public final void finish() {
        AppMethodBeat.i(111936);
        if (!this.xbo) {
            this.xbo = true;
            if (!this.xby) {
                l.c(this.query, false, dOI(), this.rjr);
            }
        }
        this.xbv.reset();
        super.finish();
        AppMethodBeat.o(111936);
    }

    @Override // com.tencent.mm.plugin.fts.ui.d
    public final void onScrollStateChanged(AbsListView absListView, int i2) {
        AppMethodBeat.i(111938);
        super.onScrollStateChanged(absListView, i2);
        if (i2 == 2) {
            this.xbw = true;
            ((n) g.ah(n.class)).getFTSImageLoader().dOl();
            o.DCM.pause();
            Log.d("MicroMsg.FTS.FTSDetailAdapter", "ImageEngine attach is false");
            AppMethodBeat.o(111938);
            return;
        }
        this.xbw = false;
        if (!((n) g.ah(n.class)).getFTSImageLoader().dOm()) {
            this.xbx.removeMessages(1);
            this.xbx.sendEmptyMessageDelayed(1, 200);
        }
        AppMethodBeat.o(111938);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.d
    public final int dOI() {
        AppMethodBeat.i(111939);
        int dOI = this.xbu.dOI();
        AppMethodBeat.o(111939);
        return dOI;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.e.b
    public final void a(e eVar, String str) {
        AppMethodBeat.i(111937);
        if (str.equals(this.query)) {
            this.khr = false;
        }
        setCount(eVar.Nn(0));
        notifyDataSetChanged();
        ax(getCount(), true);
        this.xbv.xeh = System.currentTimeMillis();
        a aVar = this.xbv;
        for (e.a aVar2 : ((a) eVar).wZO) {
            aVar.xei = aVar2.mWl.size() + aVar.xei;
        }
        AppMethodBeat.o(111937);
    }
}
