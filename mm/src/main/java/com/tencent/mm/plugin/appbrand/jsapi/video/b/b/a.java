package com.tencent.mm.plugin.appbrand.jsapi.video.b.b;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public final class a implements t {
    private final AssetManager aFb;
    private long bEJ;
    private InputStream inputStream;
    private final s mxN;
    private long mxO;
    private long mxP;
    private String mxw;
    private boolean opened;
    private String path;
    private Uri uri;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.b.b.a$a  reason: collision with other inner class name */
    public static final class C0710a extends IOException {
        public C0710a(IOException iOException) {
            super(iOException);
        }
    }

    public a(Context context) {
        this(context, (byte) 0);
    }

    private a(Context context, byte b2) {
        AppMethodBeat.i(234713);
        this.mxO = -1;
        this.mxP = -1;
        this.mxw = "";
        this.aFb = context.getAssets();
        this.mxN = null;
        AppMethodBeat.o(234713);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.b.e
    public final long a(g gVar) {
        AppMethodBeat.i(234714);
        try {
            this.uri = gVar.uri;
            this.path = this.uri.getPath();
            if (this.path.startsWith("/android_asset/")) {
                this.path = this.path.substring(15);
            } else if (this.path.startsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
                this.path = this.path.substring(1);
            }
            this.inputStream = this.aFb.open(this.path, 1);
            this.mxO = -1;
            AssetFileDescriptor assetFileDescriptor = null;
            try {
                assetFileDescriptor = this.aFb.openFd(this.path);
                this.mxO = assetFileDescriptor.getLength();
                if (assetFileDescriptor != null) {
                    try {
                        assetFileDescriptor.close();
                    } catch (IOException e2) {
                    }
                }
            } catch (IOException e3) {
                if (assetFileDescriptor != null) {
                    try {
                        assetFileDescriptor.close();
                    } catch (IOException e4) {
                    }
                }
            } catch (Throwable th) {
                if (assetFileDescriptor != null) {
                    try {
                        assetFileDescriptor.close();
                    } catch (IOException e5) {
                    }
                }
                AppMethodBeat.o(234714);
                throw th;
            }
            if (this.mxO == -1) {
                this.mxO = -1;
            }
            this.mxP = this.mxO - gVar.position;
            if (this.inputStream.skip(gVar.position) < gVar.position) {
                EOFException eOFException = new EOFException();
                AppMethodBeat.o(234714);
                throw eOFException;
            }
            if (gVar.length != -1) {
                this.bEJ = gVar.length;
            } else {
                this.bEJ = (long) this.inputStream.available();
                if (this.bEJ == 2147483647L) {
                    this.bEJ = -1;
                }
            }
            this.opened = true;
            if (this.mxN != null) {
                this.mxN.onTransferStart();
            }
            long j2 = this.bEJ;
            AppMethodBeat.o(234714);
            return j2;
        } catch (IOException e6) {
            C0710a aVar = new C0710a(e6);
            AppMethodBeat.o(234714);
            throw aVar;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.b.e
    public final void close() {
        AppMethodBeat.i(234715);
        this.uri = null;
        try {
            if (this.inputStream != null) {
                this.inputStream.close();
            }
            this.inputStream = null;
            if (this.opened) {
                this.opened = false;
                if (this.mxN != null) {
                    this.mxN.onTransferEnd();
                    AppMethodBeat.o(234715);
                    return;
                }
            }
            AppMethodBeat.o(234715);
        } catch (IOException e2) {
            C0710a aVar = new C0710a(e2);
            AppMethodBeat.o(234715);
            throw aVar;
        } catch (Throwable th) {
            this.inputStream = null;
            if (this.opened) {
                this.opened = false;
                if (this.mxN != null) {
                    this.mxN.onTransferEnd();
                }
            }
            AppMethodBeat.o(234715);
            throw th;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.b.e
    public final int read(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(234716);
        if (i3 == 0) {
            AppMethodBeat.o(234716);
            return 0;
        } else if (this.bEJ == 0) {
            AppMethodBeat.o(234716);
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
                    AppMethodBeat.o(234716);
                    return read;
                } else if (this.bEJ != -1) {
                    C0710a aVar = new C0710a(new EOFException());
                    AppMethodBeat.o(234716);
                    throw aVar;
                } else {
                    AppMethodBeat.o(234716);
                    return -1;
                }
            } catch (IOException e2) {
                C0710a aVar2 = new C0710a(e2);
                AppMethodBeat.o(234716);
                throw aVar2;
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.b.t
    public final String getUri() {
        AppMethodBeat.i(234717);
        if (this.uri != null) {
            String uri2 = this.uri.toString();
            AppMethodBeat.o(234717);
            return uri2;
        }
        AppMethodBeat.o(234717);
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.b.e
    public final long available() {
        return this.mxP;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.b.e
    public final long getTotalLength() {
        return this.mxO;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.b.e
    public final void setLogTag(String str) {
        this.mxw = str;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.b.e
    public final c bJP() {
        AppMethodBeat.i(234718);
        String str = null;
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(this.path);
        if (fileExtensionFromUrl != null) {
            str = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
        }
        if (TextUtils.isEmpty(str)) {
            c cVar = c.myv;
            AppMethodBeat.o(234718);
            return cVar;
        }
        c abd = c.abd(str);
        AppMethodBeat.o(234718);
        return abd;
    }
}
