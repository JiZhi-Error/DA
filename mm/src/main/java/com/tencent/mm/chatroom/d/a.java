package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Calendar;

public final class a {
    private Calendar calendar;
    public int grV;
    public long grW;
    public int month;
    public long msgId;
    public int year;

    public a() {
        AppMethodBeat.i(12447);
        setTime(System.currentTimeMillis());
        AppMethodBeat.o(12447);
    }

    public a(int i2, int i3, int i4) {
        AppMethodBeat.i(12448);
        this.year = i2;
        this.month = i3;
        this.grV = i4;
        AppMethodBeat.o(12448);
    }

    public a(long j2) {
        AppMethodBeat.i(12449);
        this.grW = j2;
        setTime(j2);
        AppMethodBeat.o(12449);
    }

    private void setTime(long j2) {
        AppMethodBeat.i(12450);
        this.grW = j2;
        if (this.calendar == null) {
            this.calendar = Calendar.getInstance();
        }
        this.calendar.setTimeInMillis(j2);
        this.month = this.calendar.get(2);
        this.year = this.calendar.get(1);
        this.grV = this.calendar.get(5);
        AppMethodBeat.o(12450);
    }

    public final String toString() {
        AppMethodBeat.i(12451);
        String str = "{ year: " + this.year + ", month: " + this.month + ", day: " + this.grV + " }";
        AppMethodBeat.o(12451);
        return str;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (aVar.grV == this.grV && aVar.month == this.month && aVar.year == this.year) {
            return true;
        }
        return false;
    }
}
