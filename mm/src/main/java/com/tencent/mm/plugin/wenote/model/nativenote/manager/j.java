package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.text.Spanned;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.n;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class j implements Serializable {
    private static final Pattern qRH = Pattern.compile("\\r\\n|\\r|\\n");
    int qRI = 0;
    public final ArrayList<n> qRJ = new ArrayList<>();

    static {
        AppMethodBeat.i(30523);
        AppMethodBeat.o(30523);
    }

    public j(Spanned spanned) {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(30520);
        if (spanned != null) {
            String obj = spanned.toString();
            this.qRI = 1;
            Matcher matcher = qRH.matcher(obj);
            int i2 = 0;
            while (matcher.find()) {
                int end = matcher.end();
                if (this.qRI == 1) {
                    z = true;
                } else {
                    z = false;
                }
                this.qRJ.add(new n(i2, end, z, false));
                i2 = matcher.end();
                this.qRI++;
            }
            if (this.qRJ.size() < this.qRI) {
                this.qRJ.add(new n(i2, obj.length(), this.qRI == 1 ? true : z2, true));
            }
        }
        AppMethodBeat.o(30520);
    }

    public final int getLineForOffset(int i2) {
        AppMethodBeat.i(30521);
        int i3 = 0;
        while (i3 < this.qRI && i2 >= this.qRJ.get(i3).Pc) {
            i3++;
        }
        int min = Math.min(Math.max(0, i3), this.qRJ.size() - 1);
        AppMethodBeat.o(30521);
        return min;
    }

    public final String toString() {
        AppMethodBeat.i(30522);
        StringBuilder sb = new StringBuilder();
        Iterator<n> it = this.qRJ.iterator();
        int i2 = 1;
        while (it.hasNext()) {
            n next = it.next();
            int i3 = i2 + 1;
            sb.append(i2).append(": ").append(next.avh).append("-").append(next.Pc).append(next.qTk ? "" : ", ");
            i2 = i3;
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(30522);
        return sb2;
    }
}
