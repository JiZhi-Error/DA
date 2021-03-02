package com.tencent.mm.ui.base.sortview;

import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class c extends BaseAdapter {
    List<d> OZV = null;
    private Map<String, Integer> Paa;
    private a Pab;

    public interface a {
        View a(d dVar, View view, int i2, boolean z, boolean z2);
    }

    static /* synthetic */ void a(c cVar, List list) {
        AppMethodBeat.i(142704);
        cVar.jf(list);
        AppMethodBeat.o(142704);
    }

    public c(a aVar) {
        AppMethodBeat.i(142694);
        if (aVar == null) {
            RuntimeException runtimeException = new RuntimeException("ViewCreator can not be null.");
            AppMethodBeat.o(142694);
            throw runtimeException;
        }
        this.Pab = aVar;
        this.OZV = new ArrayList();
        this.Paa = new HashMap();
        AppMethodBeat.o(142694);
    }

    public final void refresh() {
        AppMethodBeat.i(142695);
        hy(this.OZV);
        AppMethodBeat.o(142695);
    }

    public final void hy(final List<d> list) {
        AppMethodBeat.i(142696);
        if (Thread.currentThread().getId() != Looper.getMainLooper().getThread().getId()) {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.ui.base.sortview.c.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(142693);
                    c.a(c.this, list);
                    AppMethodBeat.o(142693);
                }
            });
            AppMethodBeat.o(142696);
            return;
        }
        jf(list);
        AppMethodBeat.o(142696);
    }

    private void jf(List<d> list) {
        AppMethodBeat.i(142697);
        if (this.OZV != list) {
            this.OZV.clear();
            if (list != null) {
                this.OZV.addAll(list);
            }
        }
        gLW();
        notifyDataSetChanged();
        AppMethodBeat.o(142697);
    }

    private void gLW() {
        AppMethodBeat.i(142698);
        this.Paa.clear();
        String str = null;
        int i2 = 0;
        while (i2 < this.OZV.size()) {
            String a2 = a(this.OZV.get(i2));
            if (a2 == null || a2.equalsIgnoreCase(str)) {
                a2 = str;
            } else {
                this.Paa.put(a2, Integer.valueOf(i2));
            }
            i2++;
            str = a2;
        }
        AppMethodBeat.o(142698);
    }

    private static String a(d dVar) {
        if (dVar == null || dVar.Pae == null) {
            return null;
        }
        return dVar.Pae;
    }

    public final int getCount() {
        AppMethodBeat.i(142699);
        int size = this.OZV.size();
        AppMethodBeat.o(142699);
        return size;
    }

    public final Object getItem(int i2) {
        AppMethodBeat.i(142700);
        d dVar = this.OZV.get(i2);
        AppMethodBeat.o(142700);
        return dVar;
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        boolean z = true;
        AppMethodBeat.i(142701);
        d dVar = (d) getItem(i2);
        String alP = alP(i2);
        String alP2 = alP(i2 + 1);
        boolean z2 = i2 == bmn(alP);
        if (alP == null || alP.equalsIgnoreCase(alP2)) {
            z = false;
        }
        a aVar = this.Pab;
        getCount();
        View a2 = aVar.a(dVar, view, i2, z2, z);
        AppMethodBeat.o(142701);
        return a2;
    }

    private String alP(int i2) {
        AppMethodBeat.i(142702);
        if (i2 < 0 || i2 >= this.OZV.size()) {
            AppMethodBeat.o(142702);
            return null;
        }
        String str = this.OZV.get(i2).Pae;
        AppMethodBeat.o(142702);
        return str;
    }

    public final int bmn(String str) {
        AppMethodBeat.i(142703);
        int nullAs = Util.nullAs(this.Paa.get(str), -1);
        AppMethodBeat.o(142703);
        return nullAs;
    }
}
