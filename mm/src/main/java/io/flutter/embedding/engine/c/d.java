package io.flutter.embedding.engine.c;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.a;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.a.g;
import io.flutter.plugin.a.k;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class d {
    public final k bbv;

    public d(DartExecutor dartExecutor) {
        AppMethodBeat.i(10222);
        this.bbv = new k(dartExecutor, "flutter/localization", g.SSl);
        AppMethodBeat.o(10222);
    }

    public final void km(List<Locale> list) {
        AppMethodBeat.i(10223);
        a.hwd();
        ArrayList arrayList = new ArrayList();
        for (Locale locale : list) {
            new StringBuilder("Locale (Language: ").append(locale.getLanguage()).append(", Country: ").append(locale.getCountry()).append(", Variant: ").append(locale.getVariant()).append(")");
            a.hwd();
            arrayList.add(locale.getLanguage());
            arrayList.add(locale.getCountry());
            arrayList.add(Build.VERSION.SDK_INT >= 21 ? locale.getScript() : "");
            arrayList.add(locale.getVariant());
        }
        this.bbv.a("setLocale", arrayList, null);
        AppMethodBeat.o(10223);
    }
}
