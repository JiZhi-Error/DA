package com.tencent.mm.ui.gridviewheaders;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import java.util.Calendar;
import java.util.Date;

public class a {
    private static a Qkg;
    private long Qkd = Calendar.getInstance().getTimeInMillis();
    private long Qke;
    private long Qkf;

    public static a gWr() {
        AppMethodBeat.i(142753);
        if (Qkg == null) {
            synchronized (a.class) {
                try {
                    Qkg = new a();
                } catch (Throwable th) {
                    AppMethodBeat.o(142753);
                    throw th;
                }
            }
        }
        a aVar = Qkg;
        AppMethodBeat.o(142753);
        return aVar;
    }

    private a() {
        AppMethodBeat.i(142754);
        Calendar instance = Calendar.getInstance();
        instance.set(7, 1);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        this.Qke = instance.getTimeInMillis();
        Calendar instance2 = Calendar.getInstance();
        instance2.set(5, 1);
        instance2.set(11, 0);
        instance2.set(12, 0);
        instance2.set(13, 0);
        instance2.set(14, 0);
        this.Qkf = instance2.getTimeInMillis();
        AppMethodBeat.o(142754);
    }

    public final long b(Date date) {
        AppMethodBeat.i(142755);
        if (date.getTime() >= this.Qke) {
            AppMethodBeat.o(142755);
            return MAlarmHandler.NEXT_FIRE_INTERVAL;
        } else if (date.getTime() >= this.Qkf) {
            AppMethodBeat.o(142755);
            return 9223372036854775806L;
        } else {
            long c2 = c(date);
            AppMethodBeat.o(142755);
            return c2;
        }
    }

    public static long NX(long j2) {
        AppMethodBeat.i(142756);
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j2);
        instance.set(5, 1);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        long timeInMillis = instance.getTimeInMillis();
        AppMethodBeat.o(142756);
        return timeInMillis;
    }

    private static long c(Date date) {
        AppMethodBeat.i(142757);
        long year = (long) ((date.getYear() * 100) + date.getMonth());
        AppMethodBeat.o(142757);
        return year;
    }

    public final String a(Date date, Context context) {
        AppMethodBeat.i(142758);
        if (date.getTime() >= this.Qke) {
            String string = context.getString(R.string.hoa);
            AppMethodBeat.o(142758);
            return string;
        } else if (date.getTime() >= this.Qkf) {
            String string2 = context.getString(R.string.ho_);
            AppMethodBeat.o(142758);
            return string2;
        } else {
            String str = (date.getYear() + 1900) + FilePathGenerator.ANDROID_DIR_SEP + (date.getMonth() + 1);
            AppMethodBeat.o(142758);
            return str;
        }
    }
}
