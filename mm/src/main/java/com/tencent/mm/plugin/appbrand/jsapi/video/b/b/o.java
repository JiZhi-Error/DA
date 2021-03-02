package com.tencent.mm.plugin.appbrand.jsapi.video.b.b;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;

public final class o implements t {
    private final Resources aKy;
    private long bEJ;
    private AssetFileDescriptor bEL;
    private InputStream inputStream;
    private String mimeType;
    private final s mxN;
    private long mxO;
    private long mxP;
    private String mxw;
    private boolean opened;
    private Uri uri;

    public static class a extends IOException {
        public a(String str) {
            super(str);
        }

        public a(IOException iOException) {
            super(iOException);
        }
    }

    public o(Context context) {
        this(context, (byte) 0);
    }

    private o(Context context, byte b2) {
        AppMethodBeat.i(234764);
        this.mimeType = null;
        this.mxO = -1;
        this.mxP = -1;
        this.mxw = "";
        this.aKy = context.getResources();
        this.mxN = null;
        AppMethodBeat.o(234764);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.b.e
    public final long a(g gVar) {
        long j2 = -1;
        AppMethodBeat.i(234765);
        try {
            this.uri = gVar.uri;
            if (!TextUtils.equals("android.resource", this.uri.getScheme())) {
                a aVar = new a("URI must use scheme android.resource");
                AppMethodBeat.o(234765);
                throw aVar;
            }
            try {
                this.bEL = this.aKy.openRawResourceFd(Integer.parseInt(this.uri.getLastPathSegment()));
                this.mxO = this.bEL.getLength();
                this.mxP = this.mxO - gVar.position;
                this.inputStream = new FileInputStream(this.bEL.getFileDescriptor());
                if (this.inputStream.markSupported()) {
                    this.mimeType = URLConnection.guessContentTypeFromStream(this.inputStream);
                }
                this.inputStream.skip(this.bEL.getStartOffset());
                if (this.inputStream.skip(gVar.position) < gVar.position) {
                    EOFException eOFException = new EOFException();
                    AppMethodBeat.o(234765);
                    throw eOFException;
                }
                if (gVar.length != -1) {
                    this.bEJ = gVar.length;
                } else {
                    long length = this.bEL.getLength();
                    if (length != -1) {
                        j2 = length - gVar.position;
                    }
                    this.bEJ = j2;
                }
                this.opened = true;
                if (this.mxN != null) {
                    this.mxN.onTransferStart();
                }
                long j3 = this.bEJ;
                AppMethodBeat.o(234765);
                return j3;
            } catch (NumberFormatException e2) {
                a aVar2 = new a("Resource identifier must be an integer.");
                AppMethodBeat.o(234765);
                throw aVar2;
            }
        } catch (IOException e3) {
            a aVar3 = new a(e3);
            AppMethodBeat.o(234765);
            throw aVar3;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.b.e
    public final void close() {
        AppMethodBeat.i(234766);
        this.uri = null;
        try {
            if (this.inputStream != null) {
                this.inputStream.close();
            }
            this.inputStream = null;
            try {
                if (this.bEL != null) {
                    this.bEL.close();
                }
                this.bEL = null;
                if (this.opened) {
                    this.opened = false;
                    if (this.mxN != null) {
                        this.mxN.onTransferEnd();
                        AppMethodBeat.o(234766);
                        return;
                    }
                }
                AppMethodBeat.o(234766);
            } catch (IOException e2) {
                a aVar = new a(e2);
                AppMethodBeat.o(234766);
                throw aVar;
            } catch (Throwable th) {
                this.bEL = null;
                if (this.opened) {
                    this.opened = false;
                    if (this.mxN != null) {
                        this.mxN.onTransferEnd();
                    }
                }
                AppMethodBeat.o(234766);
                throw th;
            }
        } catch (IOException e3) {
            a aVar2 = new a(e3);
            AppMethodBeat.o(234766);
            throw aVar2;
        } catch (Throwable th2) {
            this.inputStream = null;
            try {
                if (this.bEL != null) {
                    this.bEL.close();
                }
                this.bEL = null;
                if (this.opened) {
                    this.opened = false;
                    if (this.mxN != null) {
                        this.mxN.onTransferEnd();
                    }
                }
                AppMethodBeat.o(234766);
                throw th2;
            } catch (IOException e4) {
                a aVar3 = new a(e4);
                AppMethodBeat.o(234766);
                throw aVar3;
            } catch (Throwable th3) {
                this.bEL = null;
                if (this.opened) {
                    this.opened = false;
                    if (this.mxN != null) {
                        this.mxN.onTransferEnd();
                    }
                }
                AppMethodBeat.o(234766);
                throw th3;
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.b.e
    public final int read(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(234767);
        if (i3 == 0) {
            AppMethodBeat.o(234767);
            return 0;
        } else if (this.bEJ == 0) {
            AppMethodBeat.o(234767);
            return -1;
        } else {
            try {
                if (this.bEJ != -1) {
                    i3 = (int) Math.min(this.bEJ, (long) i3);
                }
                int read = this.inputStream.read(bArr, i2, i3);
                if (read != -1) {
                    if (this.bEJ != -1) {
                        this.bEJ -= (long) read;
                    }
                    if (this.mxN != null) {
                        this.mxN.xx(read);
                    }
                    AppMethodBeat.o(234767);
                    return read;
                } else if (this.bEJ != -1) {
                    a aVar = new a(new EOFException());
                    AppMethodBeat.o(234767);
                    throw aVar;
                } else {
                    AppMethodBeat.o(234767);
                    return -1;
                }
            } catch (IOException e2) {
                a aVar2 = new a(e2);
                AppMethodBeat.o(234767);
                throw aVar2;
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.b.t
    public final String getUri() {
        AppMethodBeat.i(234768);
        if (this.uri != null) {
            String uri2 = this.uri.toString();
            AppMethodBeat.o(234768);
            return uri2;
        }
        AppMethodBeat.o(234768);
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.b.e
    public final long available() {
        return this.mxP;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.b.e
    public final c bJP() {
        AppMethodBeat.i(234769);
        if (TextUtils.isEmpty(this.mimeType)) {
            c cVar = c.myv;
            AppMethodBeat.o(234769);
            return cVar;
        }
        c abd = c.abd(this.mimeType);
        AppMethodBeat.o(234769);
        return abd;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.b.e
    public final long getTotalLength() {
        return this.mxO;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.b.e
    public final void setLogTag(String str) {
        this.mxw = str;
    }
}
