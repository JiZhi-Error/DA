package com.tencent.mm.flutter.plugins.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.a.d;
import java.util.ArrayList;
import java.util.Iterator;

final class c implements d.a {
    private boolean done = false;
    private d.a hgj;
    private ArrayList<Object> hgk = new ArrayList<>();

    c() {
        AppMethodBeat.i(199130);
        AppMethodBeat.o(199130);
    }

    public final void a(d.a aVar) {
        AppMethodBeat.i(199131);
        this.hgj = aVar;
        awV();
        AppMethodBeat.o(199131);
    }

    @Override // io.flutter.plugin.a.d.a
    public final void awU() {
        AppMethodBeat.i(199132);
        bb(new a((byte) 0));
        awV();
        this.done = true;
        AppMethodBeat.o(199132);
    }

    @Override // io.flutter.plugin.a.d.a
    public final void b(String str, String str2, Object obj) {
        AppMethodBeat.i(199133);
        bb(new b(str, str2, obj));
        awV();
        AppMethodBeat.o(199133);
    }

    @Override // io.flutter.plugin.a.d.a
    public final void ba(Object obj) {
        AppMethodBeat.i(199134);
        bb(obj);
        awV();
        AppMethodBeat.o(199134);
    }

    private void bb(Object obj) {
        AppMethodBeat.i(199135);
        if (this.done) {
            AppMethodBeat.o(199135);
            return;
        }
        this.hgk.add(obj);
        AppMethodBeat.o(199135);
    }

    private void awV() {
        AppMethodBeat.i(199136);
        if (this.hgj == null) {
            AppMethodBeat.o(199136);
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
        AppMethodBeat.o(199136);
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
