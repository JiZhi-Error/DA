package com.tencent.mm.plugin.appbrand.widget.base;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class e {
    public final LinkedList<View> omB = new LinkedList<>();
    public a omC;
    public final ViewGroup parent;

    public static final class a {
        public final long hET;
        public final long lTl;

        public /* synthetic */ a(long j2, long j3, byte b2) {
            this(j2, j3);
        }

        private a(long j2, long j3) {
            this.hET = j2;
            this.lTl = j3;
        }
    }

    public e(ViewGroup viewGroup) {
        AppMethodBeat.i(131473);
        this.parent = viewGroup;
        AppMethodBeat.o(131473);
    }
}
