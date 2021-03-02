package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.b.b;
import com.tencent.liteav.basic.c.i;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class j {

    /* renamed from: j  reason: collision with root package name */
    private static String f523j = "GPUGreenScreen";

    /* renamed from: a  reason: collision with root package name */
    private int f524a;

    /* renamed from: b  reason: collision with root package name */
    private int f525b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f526c;

    /* renamed from: d  reason: collision with root package name */
    private w f527d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f528e;

    /* renamed from: f  reason: collision with root package name */
    private i f529f;

    /* renamed from: g  reason: collision with root package name */
    private e f530g;

    /* renamed from: h  reason: collision with root package name */
    private p f531h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f532i;
    private b k;

    public void a(b bVar) {
        AppMethodBeat.i(221437);
        TXCLog.i(f523j, "set notify");
        this.k = bVar;
        AppMethodBeat.o(221437);
    }

    public int a(int i2) {
        return i2;
    }

    private void b() {
        AppMethodBeat.i(15084);
        TXCLog.i(f523j, "come into destroyPlayer");
        if (this.f527d != null) {
            this.f527d.a();
        }
        this.f527d = null;
        this.f528e = false;
        this.f532i = false;
        TXCLog.i(f523j, "come out destroyPlayer");
        AppMethodBeat.o(15084);
    }

    public void a() {
        AppMethodBeat.i(15085);
        TXCLog.i(f523j, "come into GreenScreen destroy");
        b();
        c();
        if (this.f529f != null) {
            this.f529f.d();
            this.f529f = null;
        }
        if (this.f530g != null) {
            this.f530g.d();
            this.f530g = null;
        }
        if (this.f531h != null) {
            this.f531h.d();
            this.f531h = null;
        }
        this.f526c = false;
        TXCLog.i(f523j, "come out GreenScreen destroy");
        AppMethodBeat.o(15085);
    }

    private void c() {
        AppMethodBeat.i(15086);
        if (!(this.f525b == -1 || this.f525b == this.f524a)) {
            GLES20.glDeleteTextures(1, new int[]{this.f525b}, 0);
            this.f525b = -1;
        }
        if (this.f524a != -1) {
            GLES20.glDeleteTextures(1, new int[]{this.f524a}, 0);
            this.f524a = -1;
        }
        AppMethodBeat.o(15086);
    }
}
