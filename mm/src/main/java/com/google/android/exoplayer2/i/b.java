package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class b {
    public final File bGP;
    public final File bGQ;

    public b(File file) {
        AppMethodBeat.i(93119);
        this.bGP = file;
        this.bGQ = new File(file.getPath() + ".bak");
        AppMethodBeat.o(93119);
    }

    public final OutputStream wY() {
        a aVar;
        AppMethodBeat.i(93120);
        if (this.bGP.exists()) {
            if (this.bGQ.exists()) {
                this.bGP.delete();
            } else if (!this.bGP.renameTo(this.bGQ)) {
                new StringBuilder("Couldn't rename file ").append(this.bGP).append(" to backup file ").append(this.bGQ);
            }
        }
        try {
            aVar = new a(this.bGP);
        } catch (FileNotFoundException e2) {
            if (!this.bGP.getParentFile().mkdirs()) {
                IOException iOException = new IOException("Couldn't create directory " + this.bGP);
                AppMethodBeat.o(93120);
                throw iOException;
            }
            try {
                aVar = new a(this.bGP);
            } catch (FileNotFoundException e3) {
                IOException iOException2 = new IOException("Couldn't create " + this.bGP);
                AppMethodBeat.o(93120);
                throw iOException2;
            }
        }
        AppMethodBeat.o(93120);
        return aVar;
    }

    static final class a extends OutputStream {
        private final FileOutputStream bGR;
        private boolean closed = false;

        public a(File file) {
            AppMethodBeat.i(93113);
            this.bGR = new FileOutputStream(file);
            AppMethodBeat.o(93113);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            AppMethodBeat.i(93114);
            if (this.closed) {
                AppMethodBeat.o(93114);
                return;
            }
            this.closed = true;
            flush();
            try {
                this.bGR.getFD().sync();
            } catch (IOException e2) {
            }
            this.bGR.close();
            AppMethodBeat.o(93114);
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public final void flush() {
            AppMethodBeat.i(93115);
            this.bGR.flush();
            AppMethodBeat.o(93115);
        }

        @Override // java.io.OutputStream
        public final void write(int i2) {
            AppMethodBeat.i(93116);
            this.bGR.write(i2);
            AppMethodBeat.o(93116);
        }

        @Override // java.io.OutputStream
        public final void write(byte[] bArr) {
            AppMethodBeat.i(93117);
            this.bGR.write(bArr);
            AppMethodBeat.o(93117);
        }

        @Override // java.io.OutputStream
        public final void write(byte[] bArr, int i2, int i3) {
            AppMethodBeat.i(93118);
            this.bGR.write(bArr, i2, i3);
            AppMethodBeat.o(93118);
        }
    }
}
