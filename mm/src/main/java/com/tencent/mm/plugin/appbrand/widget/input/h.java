package com.tencent.mm.plugin.appbrand.widget.input;

import android.util.SparseIntArray;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.bb;

public final class h {
    private static final h osc = new h();
    private final a osb = new a((byte) 0);

    public h() {
        AppMethodBeat.i(136354);
        AppMethodBeat.o(136354);
    }

    static {
        AppMethodBeat.i(136358);
        AppMethodBeat.o(136358);
    }

    public static h cbe() {
        return osc;
    }

    /* access modifiers changed from: package-private */
    public final void c(bb bbVar) {
        AppMethodBeat.i(136355);
        if (bbVar == null) {
            AppMethodBeat.o(136355);
            return;
        }
        this.osb.osd.delete(bbVar.hashCode());
        try {
            bbVar.getWrapperView().setFocusable(true);
            bbVar.getWrapperView().setFocusableInTouchMode(true);
            bbVar.getContentView().setFocusable(true);
            bbVar.getContentView().setFocusableInTouchMode(true);
            AppMethodBeat.o(136355);
        } catch (NullPointerException e2) {
            AppMethodBeat.o(136355);
        }
    }

    public final void d(bb bbVar) {
        AppMethodBeat.i(136356);
        if (bbVar == null) {
            AppMethodBeat.o(136356);
            return;
        }
        this.osb.a(bbVar, this.osb.f(bbVar) + 1);
        try {
            bbVar.getWrapperView().setFocusable(false);
            bbVar.getWrapperView().setFocusableInTouchMode(false);
            bbVar.getContentView().setFocusable(false);
            bbVar.getContentView().setFocusableInTouchMode(false);
            if (bbVar.getWrapperView() instanceof ViewGroup) {
                ((ViewGroup) bbVar.getWrapperView()).setDescendantFocusability(393216);
            }
            AppMethodBeat.o(136356);
        } catch (NullPointerException e2) {
            AppMethodBeat.o(136356);
        }
    }

    public final void e(bb bbVar) {
        AppMethodBeat.i(136357);
        if (bbVar == null) {
            AppMethodBeat.o(136357);
            return;
        }
        int f2 = this.osb.f(bbVar) - 1;
        if (f2 <= 0) {
            c(bbVar);
            AppMethodBeat.o(136357);
            return;
        }
        this.osb.a(bbVar, f2);
        AppMethodBeat.o(136357);
    }

    /* access modifiers changed from: package-private */
    public static final class a {
        final SparseIntArray osd;

        private a() {
            AppMethodBeat.i(136351);
            this.osd = new SparseIntArray();
            AppMethodBeat.o(136351);
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        /* access modifiers changed from: package-private */
        public final int f(bb bbVar) {
            AppMethodBeat.i(136352);
            int i2 = this.osd.get(bbVar.hashCode(), 0);
            AppMethodBeat.o(136352);
            return i2;
        }

        /* access modifiers changed from: package-private */
        public final void a(bb bbVar, int i2) {
            AppMethodBeat.i(136353);
            this.osd.put(bbVar.hashCode(), i2);
            AppMethodBeat.o(136353);
        }
    }
}
