package com.tencent.mm.plugin.flutter.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.a.d;
import java.util.ArrayList;
import java.util.Iterator;

final class i implements d.a {
    private boolean done = false;
    private d.a hgj;
    private ArrayList<Object> hgk = new ArrayList<>();

    i() {
        AppMethodBeat.i(148927);
        AppMethodBeat.o(148927);
    }

    public final void a(d.a aVar) {
        AppMethodBeat.i(148928);
        this.hgj = aVar;
        awV();
        AppMethodBeat.o(148928);
    }

    @Override // io.flutter.plugin.a.d.a
    public final void awU() {
        AppMethodBeat.i(148929);
        bb(new a((byte) 0));
        awV();
        this.done = true;
        AppMethodBeat.o(148929);
    }

    @Override // io.flutter.plugin.a.d.a
    public final void b(String str, String str2, Object obj) {
        AppMethodBeat.i(148930);
        bb(new b(str, str2, obj));
        awV();
        AppMethodBeat.o(148930);
    }

    @Override // io.flutter.plugin.a.d.a
    public final void ba(Object obj) {
        AppMethodBeat.i(148931);
        bb(obj);
        awV();
        AppMethodBeat.o(148931);
    }

    private void bb(Object obj) {
        AppMethodBeat.i(148932);
        if (this.done) {
            AppMethodBeat.o(148932);
            return;
        }
        this.hgk.add(obj);
        AppMethodBeat.o(148932);
    }

    private void awV() {
        AppMethodBeat.i(148933);
        if (this.hgj == null) {
            AppMethodBeat.o(148933);
            return;
        }
        Iterator<Object> it = this.hgk.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof a) {
                this.hgj.awU();
            } else if (next instanceof b) {
                b bVar = (b) next;
                this.hgj.b(bVar.code, bVar.message, bVar.hgl);
            } else {
                this.hgj.ba(next);
            }
        }
        this.hgk.clear();
        AppMethodBeat.o(148933);
    }

    /* access modifiers changed from: package-private */
    public static class a {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    public static class b {
        String code;
        Object hgl;
        String message;

        b(String str, String str2, Object obj) {
            this.code = str;
            this.message = str2;
            this.hgl = obj;
        }
    }
}
