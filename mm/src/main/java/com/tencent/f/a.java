package com.tencent.f;

import com.tencent.f.b.d;
import com.tencent.f.g;
import com.tencent.f.g.a.b;
import com.tencent.f.g.h;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    public static g.b RSx = new g.b() {
        /* class com.tencent.f.a.AnonymousClass1 */

        @Override // com.tencent.f.g.b
        public final boolean eCC() {
            return false;
        }

        @Override // com.tencent.f.g.b
        public final boolean eCD() {
            return false;
        }

        @Override // com.tencent.f.g.b
        public final void a(Thread thread, String str) {
        }
    };
    public static boolean cWq = false;
    public int RSq;
    public int RSr;
    public int RSs;
    public b RSt;
    public h.a RSu;
    public d RSv;
    public boolean RSw;
    public long zrg;

    /* synthetic */ a(byte b2) {
        this();
    }

    static {
        AppMethodBeat.i(256656);
        AppMethodBeat.o(256656);
    }

    private a() {
        this.RSw = true;
    }

    /* renamed from: com.tencent.f.a$a  reason: collision with other inner class name */
    public static class C0134a {
        public a RSy = new a((byte) 0);

        public C0134a() {
            AppMethodBeat.i(183098);
            AppMethodBeat.o(183098);
        }

        public final C0134a hlX() {
            this.RSy.zrg = 259200000;
            return this;
        }

        public final C0134a mv(int i2, int i3) {
            this.RSy.RSr = i2;
            this.RSy.RSq = i3;
            return this;
        }

        public final C0134a aqO(int i2) {
            this.RSy.RSs = i2;
            return this;
        }

        public final C0134a a(h.a aVar) {
            this.RSy.RSu = aVar;
            return this;
        }

        public final C0134a hlY() {
            this.RSy.RSw = true;
            return this;
        }
    }
}
