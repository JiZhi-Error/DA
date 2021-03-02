package com.google.android.exoplayer2.c;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class i {
    public static final a.AbstractC0113a bhW = new a.AbstractC0113a() {
        /* class com.google.android.exoplayer2.c.i.AnonymousClass1 */

        @Override // com.google.android.exoplayer2.metadata.id3.a.AbstractC0113a
        public final boolean g(int i2, int i3, int i4, int i5, int i6) {
            return i3 == 67 && i4 == 79 && i5 == 77 && (i6 == 77 || i2 == 2);
        }
    };
    private static final Pattern bhX = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    public int bdA = -1;
    public int bdB = -1;

    static {
        AppMethodBeat.i(91998);
        AppMethodBeat.o(91998);
    }

    private boolean l(String str, String str2) {
        AppMethodBeat.i(91997);
        if (!"iTunSMPB".equals(str)) {
            AppMethodBeat.o(91997);
            return false;
        }
        Matcher matcher = bhX.matcher(str2);
        if (matcher.find()) {
            try {
                int parseInt = Integer.parseInt(matcher.group(1), 16);
                int parseInt2 = Integer.parseInt(matcher.group(2), 16);
                if (parseInt > 0 || parseInt2 > 0) {
                    this.bdA = parseInt;
                    this.bdB = parseInt2;
                    AppMethodBeat.o(91997);
                    return true;
                }
            } catch (NumberFormatException e2) {
            }
        }
        AppMethodBeat.o(91997);
        return false;
    }

    public final boolean uz() {
        return (this.bdA == -1 || this.bdB == -1) ? false : true;
    }

    public final boolean c(Metadata metadata) {
        AppMethodBeat.i(91996);
        for (int i2 = 0; i2 < metadata.btX.length; i2++) {
            Metadata.Entry entry = metadata.btX[i2];
            if (entry instanceof CommentFrame) {
                CommentFrame commentFrame = (CommentFrame) entry;
                if (l(commentFrame.description, commentFrame.text)) {
                    AppMethodBeat.o(91996);
                    return true;
                }
            }
        }
        AppMethodBeat.o(91996);
        return false;
    }
}
