package com.tencent.mm.plugin.fts.a.d.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class a {
    public String info;
    public int mve;
    public int pageType;
    public final int position;
    public final int qcr;
    public int rjr;
    public h wWd;
    public boolean wXJ;
    public boolean wXK = true;
    public int wXL;
    public int wXM;
    public String wXN;
    public long wXO;
    public boolean wXP;
    public int wXQ;
    public int wXR;
    public long wXS;
    public boolean wXT;

    public abstract b axc();

    public abstract class b {
        public abstract View a(Context context, ViewGroup viewGroup);

        public abstract void a(Context context, AbstractC1374a aVar, a aVar2, Object... objArr);

        public abstract boolean a(Context context, View view, a aVar);

        public b() {
        }

        protected static void a(String str, m mVar) {
            ((n) g.ah(n.class)).updateTopHitsRank(str, mVar, 0);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.a.d.a.a$a  reason: collision with other inner class name */
    public abstract class AbstractC1374a {
        public AbstractC1374a() {
        }
    }

    public a(int i2, int i3) {
        this.qcr = i2;
        this.position = i3;
        Log.v("MicroMsg.FTS.FTSDataItem", "create data item | viewType=%d | position=%d", Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public void a(Context context, AbstractC1374a aVar, Object... objArr) {
    }

    public final void gE(int i2, int i3) {
        this.wXQ = i2;
        this.wXR = i3;
        this.wXT = true;
    }

    public int bCS() {
        return 0;
    }

    public String bCR() {
        return "";
    }

    public int dOK() {
        return 0;
    }

    public boolean dOL() {
        return false;
    }

    public int dOM() {
        return 0;
    }

    public String getAppId() {
        return "";
    }
}
