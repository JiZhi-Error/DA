package com.tencent.mm.plugin.editor.model.nativenote.manager;

import android.text.Spanned;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.editor.model.nativenote.spans.l;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class i implements Serializable {
    private static final Pattern qRH = Pattern.compile("\\r\\n|\\r|\\n");
    int qRI = 0;
    public final ArrayList<l> qRJ = new ArrayList<>();

    static {
        AppMethodBeat.i(181829);
        AppMethodBeat.o(181829);
    }

    public i(Spanned spanned) {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(181826);
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
                this.qRJ.add(new l(i2, end, z, false));
                i2 = matcher.end();
                this.qRI++;
            }
            if (this.qRJ.size() < this.qRI) {
                this.qRJ.add(new l(i2, obj.length(), this.qRI == 1 ? true : z2, true));
            }
        }
        AppMethodBeat.o(181826);
    }

    public final int getLineForOffset(int i2) {
        AppMethodBeat.i(181827);
        int i3 = 0;
        while (i3 < this.qRI && i2 >= this.qRJ.get(i3).Pc) {
            i3++;
        }
        int min = Math.min(Math.max(0, i3), this.qRJ.size() - 1);
        AppMethodBeat.o(181827);
        return min;
    }

    public final String toString() {
        AppMethodBeat.i(181828);
        StringBuilder sb = new StringBuilder();
        Iterator<l> it = this.qRJ.iterator();
        int i2 = 1;
        while (it.hasNext()) {
            l next = it.next();
            int i3 = i2 + 1;
            sb.append(i2).append(": ").append(next.avh).append("-").append(next.Pc).append(next.qTk ? "" : ", ");
            i2 = i3;
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(181828);
        return sb2;
    }
}
