package io.flutter.plugin.c;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.c.d;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class a {
    private final d SOa;
    private final Context context;

    public a(Context context2, d dVar) {
        this.context = context2;
        this.SOa = dVar;
    }

    public final Locale ko(List<Locale> list) {
        AppMethodBeat.i(214855);
        if (list.isEmpty()) {
            AppMethodBeat.o(214855);
            return null;
        } else if (Build.VERSION.SDK_INT >= 26) {
            ArrayList arrayList = new ArrayList();
            LocaleList locales = this.context.getResources().getConfiguration().getLocales();
            int size = locales.size();
            for (int i2 = 0; i2 < size; i2++) {
                Locale locale = locales.get(i2);
                arrayList.add(new Locale.LanguageRange(locale.toString().replace("_", "-")));
                arrayList.add(new Locale.LanguageRange(locale.getLanguage()));
                arrayList.add(new Locale.LanguageRange(locale.getLanguage() + "-*"));
            }
            Locale lookup = Locale.lookup(arrayList, list);
            if (lookup != null) {
                AppMethodBeat.o(214855);
                return lookup;
            }
            Locale locale2 = list.get(0);
            AppMethodBeat.o(214855);
            return locale2;
        } else if (Build.VERSION.SDK_INT >= 24) {
            LocaleList locales2 = this.context.getResources().getConfiguration().getLocales();
            for (int i3 = 0; i3 < locales2.size(); i3++) {
                Locale locale3 = locales2.get(i3);
                for (Locale locale4 : list) {
                    if (locale3.equals(locale4)) {
                        AppMethodBeat.o(214855);
                        return locale4;
                    }
                }
                for (Locale locale5 : list) {
                    if (locale3.getLanguage().equals(locale5.toLanguageTag())) {
                        AppMethodBeat.o(214855);
                        return locale5;
                    }
                }
                for (Locale locale6 : list) {
                    if (locale3.getLanguage().equals(locale6.getLanguage())) {
                        AppMethodBeat.o(214855);
                        return locale6;
                    }
                }
            }
            Locale locale7 = list.get(0);
            AppMethodBeat.o(214855);
            return locale7;
        } else {
            Locale locale8 = this.context.getResources().getConfiguration().locale;
            if (locale8 != null) {
                for (Locale locale9 : list) {
                    if (locale8.equals(locale9)) {
                        AppMethodBeat.o(214855);
                        return locale9;
                    }
                }
                for (Locale locale10 : list) {
                    if (locale8.getLanguage().equals(locale10.toString())) {
                        AppMethodBeat.o(214855);
                        return locale10;
                    }
                }
            }
            Locale locale11 = list.get(0);
            AppMethodBeat.o(214855);
            return locale11;
        }
    }

    public final void j(Configuration configuration) {
        AppMethodBeat.i(214856);
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 24) {
            LocaleList locales = configuration.getLocales();
            int size = locales.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(locales.get(i2));
            }
        } else {
            arrayList.add(configuration.locale);
        }
        this.SOa.km(arrayList);
        AppMethodBeat.o(214856);
    }
}
