package com.google.android.exoplayer2.h;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public final class e implements g {
    private final w<? super e> bEI;
    private long bEJ;
    private final ContentResolver bEK;
    private AssetFileDescriptor bEL;
    private InputStream inputStream;
    private boolean opened;
    private Uri uri;

    public static class a extends IOException {
        public a(IOException iOException) {
            super(iOException);
        }
    }

    public e(Context context, w<? super e> wVar) {
        AppMethodBeat.i(93033);
        this.bEK = context.getContentResolver();
        this.bEI = wVar;
        AppMethodBeat.o(93033);
    }

    @Override // com.google.android.exoplayer2.h.g
    public final long a(j jVar) {
        AppMethodBeat.i(93034);
        try {
            this.uri = jVar.uri;
            this.bEL = this.bEK.openAssetFileDescriptor(this.uri, "r");
            if (this.bEL == null) {
                FileNotFoundException fileNotFoundException = new FileNotFoundException("Could not open file descriptor for: " + this.uri);
                AppMethodBeat.o(93034);
                throw fileNotFoundException;
            }
            this.inputStream = new FileInputStream(this.bEL.getFileDescriptor());
            long startOffset = this.bEL.getStartOffset();
            long skip = this.inputStream.skip(jVar.position + startOffset) - startOffset;
            if (skip != jVar.position) {
                EOFException eOFException = new EOFException();
                AppMethodBeat.o(93034);
                throw eOFException;
            }
            if (jVar.length != -1) {
                this.bEJ = jVar.length;
            } else {
                long length = this.bEL.getLength();
                if (length == -1) {
                    this.bEJ = (long) this.inputStream.available();
                    if (this.bEJ == 0) {
                        this.bEJ = -1;
                    }
                } else {
                    this.bEJ = length - skip;
                }
            }
            this.opened = true;
            if (this.bEI != null) {
                this.bEI.a(this, jVar);
            }
            long j2 = this.bEJ;
            AppMethodBeat.o(93034);
            return j2;
        } catch (IOException e2) {
            a aVar = new a(e2);
            AppMethodBeat.o(93034);
            throw aVar;
        }
    }

    @Override // com.google.android.exoplayer2.h.g
    public final int read(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(93035);
        if (i3 == 0) {
            AppMethodBeat.o(93035);
            return 0;
        } else if (this.bEJ == 0) {
            AppMethodBeat.o(93035);
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
                    AppMethodBeat.o(93035);
                    return read;
                } else if (this.bEJ != -1) {
                    a aVar = new a(new EOFException());
                    AppMethodBeat.o(93035);
                    throw aVar;
                } else {
                    AppMethodBeat.o(93035);
                    return -1;
                }
            } catch (IOException e2) {
                a aVar2 = new a(e2);
                AppMethodBeat.o(93035);
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
        AppMethodBeat.i(93036);
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
                    if (this.bEI != null) {
                        this.bEI.ai(this);
                        AppMethodBeat.o(93036);
                        return;
                    }
                }
                AppMethodBeat.o(93036);
            } catch (IOException e2) {
                a aVar = new a(e2);
                AppMethodBeat.o(93036);
                throw aVar;
            } catch (Throwable th) {
                this.bEL = null;
                if (this.opened) {
                    this.opened = false;
                    if (this.bEI != null) {
                        this.bEI.ai(this);
                    }
                }
                AppMethodBeat.o(93036);
                throw th;
            }
        } catch (IOException e3) {
            a aVar2 = new a(e3);
            AppMethodBeat.o(93036);
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
                    if (this.bEI != null) {
                        this.bEI.ai(this);
                    }
                }
                AppMethodBeat.o(93036);
                throw th2;
            } catch (IOException e4) {
                a aVar3 = new a(e4);
                AppMethodBeat.o(93036);
                throw aVar3;
            } catch (Throwable th3) {
                this.bEL = null;
                if (this.opened) {
                    this.opened = false;
                    if (this.bEI != null) {
                        this.bEI.ai(this);
                    }
                }
                AppMethodBeat.o(93036);
                throw th3;
            }
        }
    }
}
