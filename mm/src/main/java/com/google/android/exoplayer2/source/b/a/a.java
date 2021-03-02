package com.google.android.exoplayer2.source.b.a;

import com.google.android.exoplayer2.Format;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

public final class a extends c {
    public final List<C0114a> audios;
    public final List<Format> bxB;
    public final List<C0114a> byO;
    public final List<C0114a> byP;
    public final Format byy;

    /* renamed from: com.google.android.exoplayer2.source.b.a.a$a  reason: collision with other inner class name */
    public static final class C0114a {
        public final Format bdF;
        public final String url;

        public C0114a(String str, Format format) {
            this.url = str;
            this.bdF = format;
        }
    }

    public a(String str, List<String> list, List<C0114a> list2, List<C0114a> list3, List<C0114a> list4, Format format, List<Format> list5) {
        super(str, list);
        AppMethodBeat.i(62886);
        this.byO = Collections.unmodifiableList(list2);
        this.audios = Collections.unmodifiableList(list3);
        this.byP = Collections.unmodifiableList(list4);
        this.byy = format;
        this.bxB = list5 != null ? Collections.unmodifiableList(list5) : null;
        AppMethodBeat.o(62886);
    }
}
