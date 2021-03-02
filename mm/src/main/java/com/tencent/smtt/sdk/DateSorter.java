package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.IX5DateSorter;

public class DateSorter extends z {
    public static int DAY_COUNT = 5;

    /* renamed from: a  reason: collision with root package name */
    private android.webkit.DateSorter f1680a;

    /* renamed from: b  reason: collision with root package name */
    private IX5DateSorter f1681b;

    static {
        AppMethodBeat.i(54072);
        isX5Core();
        AppMethodBeat.o(54072);
    }

    public DateSorter(Context context) {
        AppMethodBeat.i(54068);
        x a2 = x.a();
        if (a2 == null || !a2.b()) {
            this.f1680a = new android.webkit.DateSorter(context);
            AppMethodBeat.o(54068);
            return;
        }
        this.f1681b = getCoreMessy().createDateSorter(context);
        AppMethodBeat.o(54068);
    }

    public int getIndex(long j2) {
        AppMethodBeat.i(54069);
        x a2 = x.a();
        if (a2 == null || !a2.b()) {
            int index = this.f1680a.getIndex(j2);
            AppMethodBeat.o(54069);
            return index;
        }
        int index2 = this.f1681b.getIndex(j2);
        AppMethodBeat.o(54069);
        return index2;
    }

    public String getLabel(int i2) {
        AppMethodBeat.i(54070);
        x a2 = x.a();
        if (a2 == null || !a2.b()) {
            String label = this.f1680a.getLabel(i2);
            AppMethodBeat.o(54070);
            return label;
        }
        String label2 = this.f1681b.getLabel(i2);
        AppMethodBeat.o(54070);
        return label2;
    }

    public long getBoundary(int i2) {
        AppMethodBeat.i(54071);
        x a2 = x.a();
        if (a2 == null || !a2.b()) {
            long boundary = this.f1680a.getBoundary(i2);
            AppMethodBeat.o(54071);
            return boundary;
        }
        long boundary2 = this.f1681b.getBoundary(i2);
        AppMethodBeat.o(54071);
        return boundary2;
    }
}
