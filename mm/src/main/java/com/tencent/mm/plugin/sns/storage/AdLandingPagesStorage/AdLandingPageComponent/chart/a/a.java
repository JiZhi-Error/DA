package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a;

import android.text.Spannable;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public final class a extends LinkedHashMap<Spannable, Float> {
    public b Ear = new b();
    public Interpolator Eas = null;
    private String Eat = "";
    public long duration = 0;

    public a() {
        AppMethodBeat.i(96334);
        AppMethodBeat.o(96334);
    }

    public a(b bVar) {
        AppMethodBeat.i(96335);
        this.Ear = bVar;
        AppMethodBeat.o(96335);
    }

    public final boolean a(a aVar) {
        AppMethodBeat.i(96336);
        if (size() != aVar.size()) {
            AppMethodBeat.o(96336);
            return false;
        }
        for (Map.Entry entry : aVar.entrySet()) {
            if (!containsKey(entry.getKey())) {
                AppMethodBeat.o(96336);
                return false;
            }
        }
        AppMethodBeat.o(96336);
        return true;
    }

    public final Spannable[] fcQ() {
        AppMethodBeat.i(96337);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : entrySet()) {
            arrayList.add(entry.getKey());
        }
        Spannable[] spannableArr = (Spannable[]) arrayList.toArray(new Spannable[arrayList.size()]);
        AppMethodBeat.o(96337);
        return spannableArr;
    }
}
