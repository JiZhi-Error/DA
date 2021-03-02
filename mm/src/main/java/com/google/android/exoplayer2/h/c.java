package com.google.android.exoplayer2.h;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public final class c implements g {
    private final AssetManager aFb;
    private final w<? super c> bEI;
    private long bEJ;
    private InputStream inputStream;
    private boolean opened;
    private Uri uri;

    public static final class a extends IOException {
        public a(IOException iOException) {
            super(iOException);
        }
    }

    public c(Context context, w<? super c> wVar) {
        AppMethodBeat.i(92955);
        this.aFb = context.getAssets();
        this.bEI = wVar;
        AppMethodBeat.o(92955);
    }

    @Override // com.google.android.exoplayer2.h.g
    public final long a(j jVar) {
        AppMethodBeat.i(92956);
        try {
            this.uri = jVar.uri;
            String path = this.uri.getPath();
            if (path.startsWith("/android_asset/")) {
                path = path.substring(15);
            } else if (path.startsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
                path = path.substring(1);
            }
            this.inputStream = this.aFb.open(path, 1);
            if (this.inputStream.skip(jVar.position) < jVar.position) {
                EOFException eOFException = new EOFException();
                AppMethodBeat.o(92956);
                throw eOFException;
            }
            if (jVar.length != -1) {
                this.bEJ = jVar.length;
            } else {
                this.bEJ = (long) this.inputStream.available();
                if (this.bEJ == 2147483647L) {
                    this.bEJ = -1;
                }
            }
            this.opened = true;
            if (this.bEI != null) {
                this.bEI.a(this, jVar);
            }
            long j2 = this.bEJ;
            AppMethodBeat.o(92956);
            return j2;
        } catch (IOException e2) {
            a aVar = new a(e2);
            AppMethodBeat.o(92956);
            throw aVar;
        }
    }

    @Override // com.google.android.exoplayer2.h.g
    public final int read(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(92957);
        if (i3 == 0) {
            AppMethodBeat.o(92957);
            return 0;
        } else if (this.bEJ == 0) {
            AppMethodBeat.o(92957);
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
                    if (this.bEI != null) {
                        this.bEI.d(this, read);
                    }
                    AppMethodBeat.o(92957);
                    return read;
                } else if (this.bEJ != -1) {
                    a aVar = new a(new EOFException());
                    AppMethodBeat.o(92957);
                    throw aVar;
                } else {
                    AppMethodBeat.o(92957);
                    return -1;
                }
            } catch (IOException e2) {
                a aVar2 = new a(e2);
                AppMethodBeat.o(92957);
                throw aVar2;
            }
        }
    }

    @Override // com.google.android.exoplayer2.h.g
    public final Uri getUri() {
        return this.uri;
    }

    @Override // com.google.android.exoplayer2.h.g
    public final void close() {
        AppMethodBeat.i(92958);
        this.uri = null;
        try {
            if (this.inputStream != null) {
                this.inputStream.close();
            }
            this.inputStream = null;
            if (this.opened) {
                this.opened = false;
                if (this.bEI != null) {
                    this.bEI.ai(this);
                    AppMethodBeat.o(92958);
                    return;
                }
            }
            AppMethodBeat.o(92958);
        } catch (IOException e2) {
            a aVar = new a(e2);
            AppMethodBeat.o(92958);
            throw aVar;
        } catch (Throwable th) {
            this.inputStream = null;
            if (this.opened) {
                this.opened = false;
                if (this.bEI != null) {
                    this.bEI.ai(this);
                }
            }
            AppMethodBeat.o(92958);
            throw th;
        }
    }
}
