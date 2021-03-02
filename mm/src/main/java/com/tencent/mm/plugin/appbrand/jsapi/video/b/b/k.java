package com.tencent.mm.plugin.appbrand.jsapi.video.b.b;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class k implements t {
    private long bEJ;
    private RandomAccessFile file;
    private final s mxN;
    private long mxP;
    private String mxw;
    private String myk;
    private boolean opened;
    private Uri uri;

    public static class a extends IOException {
        public a(IOException iOException) {
            super(iOException);
        }
    }

    public k() {
        this((byte) 0);
    }

    private k(byte b2) {
        this.mxP = -1;
        this.mxw = "";
        this.mxN = null;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.b.e
    public final long a(g gVar) {
        AppMethodBeat.i(234751);
        try {
            this.uri = gVar.uri;
            this.file = new RandomAccessFile(gVar.uri.getPath(), "r");
            this.file.seek(gVar.position);
            this.bEJ = gVar.length == -1 ? this.file.length() - gVar.position : gVar.length;
            this.mxP = this.file.length() - gVar.position;
            if (this.bEJ < 0) {
                EOFException eOFException = new EOFException();
                AppMethodBeat.o(234751);
                throw eOFException;
            }
            this.opened = true;
            if (this.mxN != null) {
                this.mxN.onTransferStart();
            }
            long j2 = this.bEJ;
            AppMethodBeat.o(234751);
            return j2;
        } catch (IOException e2) {
            a aVar = new a(e2);
            AppMethodBeat.o(234751);
            throw aVar;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.b.e
    public final int read(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(234752);
        if (this.bEJ == 0) {
            AppMethodBeat.o(234752);
            return -1;
        }
        try {
            int read = this.file.read(bArr, i2, (int) Math.min(this.bEJ, (long) i3));
            if (read > 0) {
                this.bEJ -= (long) read;
                if (this.mxN != null) {
                    this.mxN.xx(read);
                }
            }
            AppMethodBeat.o(234752);
            return read;
        } catch (IOException e2) {
            a aVar = new a(e2);
            AppMethodBeat.o(234752);
            throw aVar;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.b.e
    public final long available() {
        return this.mxP;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.b.t
    public final String getUri() {
        AppMethodBeat.i(234753);
        if (TextUtils.isEmpty(this.myk) && this.uri != null) {
            this.myk = this.uri.toString();
        }
        String str = this.myk;
        AppMethodBeat.o(234753);
        return str;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.b.e
    public final void close() {
        AppMethodBeat.i(234754);
        this.myk = null;
        if (this.file != null) {
            try {
                this.file.close();
                this.file = null;
                if (this.opened) {
                    this.opened = false;
                    if (this.mxN != null) {
                        this.mxN.onTransferEnd();
                        AppMethodBeat.o(234754);
                        return;
                    }
                }
            } catch (IOException e2) {
                a aVar = new a(e2);
                AppMethodBeat.o(234754);
                throw aVar;
            } catch (Throwable th) {
                this.file = null;
                if (this.opened) {
                    this.opened = false;
                    if (this.mxN != null) {
                        this.mxN.onTransferEnd();
                    }
                }
                AppMethodBeat.o(234754);
                throw th;
            }
        }
        AppMethodBeat.o(234754);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.b.e
    public c bJP() {
        AppMethodBeat.i(234755);
        String type = com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().appContext.getContentResolver().getType(this.uri);
        if (type == null) {
            c cVar = c.myw;
            AppMethodBeat.o(234755);
            return cVar;
        }
        c abd = c.abd(type);
        AppMethodBeat.o(234755);
        return abd;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.b.e
    public final long getTotalLength() {
        AppMethodBeat.i(234756);
        long j2 = 0;
        try {
            j2 = this.file.length();
        } catch (IOException e2) {
        }
        AppMethodBeat.o(234756);
        return j2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.b.e
    public final void setLogTag(String str) {
        this.mxw = str;
    }
}
