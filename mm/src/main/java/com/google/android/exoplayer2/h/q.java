package com.google.android.exoplayer2.h;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class q implements g {
    private final w<? super q> bEI;
    private long bEJ;
    private RandomAccessFile file;
    private boolean opened;
    private Uri uri;

    public static class a extends IOException {
        public a(IOException iOException) {
            super(iOException);
        }
    }

    public q() {
        this(null);
    }

    public q(w<? super q> wVar) {
        this.bEI = wVar;
    }

    @Override // com.google.android.exoplayer2.h.g
    public final long a(j jVar) {
        AppMethodBeat.i(93079);
        try {
            this.uri = jVar.uri;
            this.file = new RandomAccessFile(jVar.uri.getPath(), "r");
            this.file.seek(jVar.position);
            this.bEJ = jVar.length == -1 ? this.file.length() - jVar.position : jVar.length;
            if (this.bEJ < 0) {
                EOFException eOFException = new EOFException();
                AppMethodBeat.o(93079);
                throw eOFException;
            }
            this.opened = true;
            if (this.bEI != null) {
                this.bEI.a(this, jVar);
            }
            long j2 = this.bEJ;
            AppMethodBeat.o(93079);
            return j2;
        } catch (IOException e2) {
            a aVar = new a(e2);
            AppMethodBeat.o(93079);
            throw aVar;
        }
    }

    @Override // com.google.android.exoplayer2.h.g
    public final int read(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(93080);
        if (i3 == 0) {
            AppMethodBeat.o(93080);
            return 0;
        } else if (this.bEJ == 0) {
            AppMethodBeat.o(93080);
            return -1;
        } else {
            try {
                int read = this.file.read(bArr, i2, (int) Math.min(this.bEJ, (long) i3));
                if (read > 0) {
                    this.bEJ -= (long) read;
                    if (this.bEI != null) {
                        this.bEI.d(this, read);
                    }
                }
                AppMethodBeat.o(93080);
                return read;
            } catch (IOException e2) {
                a aVar = new a(e2);
                AppMethodBeat.o(93080);
                throw aVar;
            }
        }
    }

    @Override // com.google.android.exoplayer2.h.g
    public final Uri getUri() {
        return this.uri;
    }

    @Override // com.google.android.exoplayer2.h.g
    public final void close() {
        AppMethodBeat.i(93081);
        this.uri = null;
        try {
            if (this.file != null) {
                this.file.close();
            }
            this.file = null;
            if (this.opened) {
                this.opened = false;
                if (this.bEI != null) {
                    this.bEI.ai(this);
                    AppMethodBeat.o(93081);
                    return;
                }
            }
            AppMethodBeat.o(93081);
        } catch (IOException e2) {
            a aVar = new a(e2);
            AppMethodBeat.o(93081);
            throw aVar;
        } catch (Throwable th) {
            this.file = null;
            if (this.opened) {
                this.opened = false;
                if (this.bEI != null) {
                    this.bEI.ai(this);
                }
            }
            AppMethodBeat.o(93081);
            throw th;
        }
    }
}
