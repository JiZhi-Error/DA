package com.robinhood.ticker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

final class c {
    final Map<Character, Integer> cgA;
    final int cgy;
    final char[] cgz;

    c(String str) {
        AppMethodBeat.i(39843);
        if (str.contains(Character.toString(0))) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("You cannot include TickerUtils.EMPTY_CHAR in the character list.");
            AppMethodBeat.o(39843);
            throw illegalArgumentException;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        this.cgy = length;
        this.cgA = new HashMap(length);
        for (int i2 = 0; i2 < length; i2++) {
            this.cgA.put(Character.valueOf(charArray[i2]), Integer.valueOf(i2));
        }
        this.cgz = new char[((length * 2) + 1)];
        this.cgz[0] = 0;
        for (int i3 = 0; i3 < length; i3++) {
            this.cgz[i3 + 1] = charArray[i3];
            this.cgz[length + 1 + i3] = charArray[i3];
        }
        AppMethodBeat.o(39843);
    }

    /* access modifiers changed from: package-private */
    public final int p(char c2) {
        AppMethodBeat.i(39844);
        if (c2 == 0) {
            AppMethodBeat.o(39844);
            return 0;
        } else if (this.cgA.containsKey(Character.valueOf(c2))) {
            int intValue = this.cgA.get(Character.valueOf(c2)).intValue() + 1;
            AppMethodBeat.o(39844);
            return intValue;
        } else {
            AppMethodBeat.o(39844);
            return -1;
        }
    }

    class a {
        final int endIndex;
        final int startIndex;

        public a(int i2, int i3) {
            this.startIndex = i2;
            this.endIndex = i3;
        }
    }
}
