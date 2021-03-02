package com.tencent.liteav.muxer;

import android.content.Context;
import android.media.MediaFormat;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class c implements a {

    /* renamed from: a  reason: collision with root package name */
    private int f835a = 0;

    /* renamed from: b  reason: collision with root package name */
    private a f836b;

    public c(Context context, int i2) {
        AppMethodBeat.i(14901);
        switch (i2) {
            case 0:
                this.f835a = 0;
                this.f836b = new d();
                TXCLog.i("TXCMP4Muxer", "TXCMP4Muxer: use sw model ");
                AppMethodBeat.o(14901);
                return;
            case 1:
                this.f835a = 1;
                this.f836b = new b();
                TXCLog.i("TXCMP4Muxer", "TXCMP4Muxer: use hw model ");
                AppMethodBeat.o(14901);
                return;
            default:
                if (a(context)) {
                    this.f835a = 0;
                    this.f836b = new d();
                    TXCLog.i("TXCMP4Muxer", "TXCMP4Muxer: use sw model ");
                    AppMethodBeat.o(14901);
                    return;
                }
                this.f835a = 1;
                this.f836b = new b();
                TXCLog.i("TXCMP4Muxer", "TXCMP4Muxer: use hw model ");
                AppMethodBeat.o(14901);
                return;
        }
    }

    public static boolean a(Context context) {
        AppMethodBeat.i(14902);
        com.tencent.liteav.basic.d.c.a().a(context);
        if (com.tencent.liteav.basic.d.c.a().f() == 1) {
            AppMethodBeat.o(14902);
            return true;
        }
        AppMethodBeat.o(14902);
        return false;
    }

    @Override // com.tencent.liteav.muxer.a
    public void a(MediaFormat mediaFormat) {
        AppMethodBeat.i(14903);
        this.f836b.a(mediaFormat);
        AppMethodBeat.o(14903);
    }

    @Override // com.tencent.liteav.muxer.a
    public void b(MediaFormat mediaFormat) {
        AppMethodBeat.i(14904);
        this.f836b.b(mediaFormat);
        AppMethodBeat.o(14904);
    }

    @Override // com.tencent.liteav.muxer.a
    public void a(String str) {
        AppMethodBeat.i(14905);
        this.f836b.a(str);
        AppMethodBeat.o(14905);
    }

    @Override // com.tencent.liteav.muxer.a
    public void a(byte[] bArr, int i2, int i3, long j2, int i4) {
        AppMethodBeat.i(14906);
        this.f836b.a(bArr, i2, i3, j2, i4);
        AppMethodBeat.o(14906);
    }

    @Override // com.tencent.liteav.muxer.a
    public void b(byte[] bArr, int i2, int i3, long j2, int i4) {
        AppMethodBeat.i(14907);
        this.f836b.b(bArr, i2, i3, j2, i4);
        AppMethodBeat.o(14907);
    }

    @Override // com.tencent.liteav.muxer.a
    public int a() {
        AppMethodBeat.i(14908);
        int a2 = this.f836b.a();
        AppMethodBeat.o(14908);
        return a2;
    }

    @Override // com.tencent.liteav.muxer.a
    public int b() {
        AppMethodBeat.i(14909);
        int b2 = this.f836b.b();
        AppMethodBeat.o(14909);
        return b2;
    }

    @Override // com.tencent.liteav.muxer.a
    public boolean c() {
        AppMethodBeat.i(14910);
        boolean c2 = this.f836b.c();
        AppMethodBeat.o(14910);
        return c2;
    }
}
