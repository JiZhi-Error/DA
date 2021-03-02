package com.google.android.exoplayer2.source.b.a;

import java.util.Collections;
import java.util.List;

public abstract class c {
    public final String bzg;
    public final List<String> bzh;

    protected c(String str, List<String> list) {
        this.bzg = str;
        this.bzh = Collections.unmodifiableList(list);
    }
}
