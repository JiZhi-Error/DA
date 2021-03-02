package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.as;

public abstract class a {
    public static final int wZV = com.tencent.mm.cb.a.aG(MMApplicationContext.getContext(), R.dimen.is);
    public static final TextPaint wZW = new TextPaint();
    public static final int wZX = com.tencent.mm.cb.a.aG(MMApplicationContext.getContext(), R.dimen.hc);
    public static final TextPaint wZY = new TextPaint();
    public boolean PWh;
    public boolean PWi;
    public boolean PZZ;
    public boolean Qaa;
    public boolean Qab = false;
    public boolean Qac = false;
    public boolean Qad;
    public boolean VlU = false;
    public as contact;
    public String dFl;
    public boolean hkH;
    public boolean poB;
    public final int position;
    public final int qcr;
    public String query;
    public int scene;
    public h wWd;
    public int wXL;
    public int wXQ;
    public int wXR;

    public abstract void a(Context context, C2110a aVar);

    public abstract b bmx();

    static {
        wZW.setTextSize((float) wZV);
        wZY.setTextSize((float) wZX);
    }

    public a(int i2, int i3) {
        this.qcr = i2;
        this.position = i3;
        Log.i("MicroMsg.BaseContactDataItem", "Create BaseContactDataItem viewType=%d | position=%d", Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public final h hYN() {
        return this.wWd;
    }

    public final boolean eWh() {
        return this.PWh;
    }

    public final void FK(boolean z) {
        this.PWh = z;
    }

    public final void ay(as asVar) {
        this.contact = asVar;
    }

    public final void byI(String str) {
        this.query = str;
    }

    public final as eFa() {
        return this.contact;
    }

    public abstract class b {
        public abstract View a(Context context, ViewGroup viewGroup);

        public abstract void a(Context context, C2110a aVar, a aVar2, boolean z, boolean z2);

        public abstract boolean a(Context context, View view, a aVar);

        public b() {
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.a.a$a  reason: collision with other inner class name */
    public class C2110a {
        public C2110a() {
        }
    }

    protected static SpannableString w(Context context, String str, int i2) {
        return l.e(context, (CharSequence) str, i2);
    }

    public final void gE(int i2, int i3) {
        this.wXQ = i2;
        this.wXR = i3;
    }

    public boolean dOL() {
        return false;
    }
}
