package com.qq.wx.voice.embed.recognizer;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e {

    /* renamed from: c  reason: collision with root package name */
    byte[] f117c;
    public Grammar cgs;
    g cgt;

    /* renamed from: d  reason: collision with root package name */
    public boolean f118d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f119e;

    public e() {
        AppMethodBeat.i(76756);
        this.cgs = null;
        this.cgt = new g();
        this.f117c = null;
        this.f118d = false;
        this.f119e = false;
        this.cgs = new Grammar();
        AppMethodBeat.o(76756);
    }

    class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(e eVar, byte b2) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(76755);
            if (e.this.cgs.begin() != 0) {
                e.this.cgt.a(-102);
                AppMethodBeat.o(76755);
            } else if (e.this.cgs.recognize(e.this.f117c, e.this.f117c.length) != 0) {
                e.this.cgt.a(-103);
                AppMethodBeat.o(76755);
            } else if (e.this.cgs.end() != 0) {
                e.this.cgt.a(-104);
                AppMethodBeat.o(76755);
            } else {
                a aVar = new a();
                if (e.this.cgs.getResult(aVar) != 0) {
                    e.this.cgt.a(-105);
                }
                g gVar = e.this.cgt;
                gVar.f122b.sendMessage(gVar.f122b.obtainMessage(200, aVar));
                AppMethodBeat.o(76755);
            }
        }
    }

    public final int a(c cVar, byte[] bArr) {
        AppMethodBeat.i(76757);
        if (!this.f118d) {
            AppMethodBeat.o(76757);
            return -304;
        } else if (!this.f119e) {
            AppMethodBeat.o(76757);
            return -302;
        } else {
            this.cgt.cgu = cVar;
            this.f117c = bArr;
            if (this.f117c == null) {
                AppMethodBeat.o(76757);
                return -301;
            }
            try {
                new Thread(new a(this, (byte) 0)).start();
                AppMethodBeat.o(76757);
                return 0;
            } catch (Exception e2) {
                AppMethodBeat.o(76757);
                return -302;
            }
        }
    }
}
