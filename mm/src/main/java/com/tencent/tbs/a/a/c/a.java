package com.tencent.tbs.a.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.a.b;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class a implements b {

    /* renamed from: a  reason: collision with root package name */
    ThreadLocal<SimpleDateFormat> f2305a = new ThreadLocal<SimpleDateFormat>() {
        /* class com.tencent.tbs.a.a.c.a.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public final /* synthetic */ SimpleDateFormat initialValue() {
            AppMethodBeat.i(174290);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
            AppMethodBeat.o(174290);
            return simpleDateFormat;
        }
    };

    public a() {
        AppMethodBeat.i(174291);
        AppMethodBeat.o(174291);
    }

    @Override // com.tencent.tbs.a.a.c.b
    public final String d(b bVar) {
        AppMethodBeat.i(174292);
        long currentTimeMillis = bVar != null ? bVar.f2306a : System.currentTimeMillis();
        SimpleDateFormat simpleDateFormat = this.f2305a.get();
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        String format = simpleDateFormat.format(new Date(currentTimeMillis));
        AppMethodBeat.o(174292);
        return format;
    }
}
