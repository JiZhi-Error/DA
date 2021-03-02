package com.tencent.mm.plugin.appbrand.jsapi.video.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

public final class f extends Reader {
    private e mxQ;
    private boolean mxR = false;
    private CharsetDecoder mxS;
    private final ByteBuffer mxT = ByteBuffer.allocate(8192);

    public f(e eVar, String str) {
        super(eVar);
        AppMethodBeat.i(234719);
        this.mxQ = eVar;
        try {
            this.mxS = Charset.forName(str).newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
            this.mxT.limit(0);
            AppMethodBeat.o(234719);
        } catch (IllegalArgumentException e2) {
            UnsupportedEncodingException unsupportedEncodingException = (UnsupportedEncodingException) new UnsupportedEncodingException(str).initCause(e2);
            AppMethodBeat.o(234719);
            throw unsupportedEncodingException;
        }
    }

    @Override // java.io.Closeable, java.io.Reader, java.lang.AutoCloseable
    public final void close() {
        AppMethodBeat.i(234720);
        synchronized (this.lock) {
            try {
                if (this.mxS != null) {
                    this.mxS.reset();
                }
                this.mxS = null;
                if (this.mxQ != null) {
                    this.mxQ.close();
                    this.mxQ = null;
                }
            } finally {
                AppMethodBeat.o(234720);
            }
        }
    }

    @Override // java.io.Reader
    public final int read() {
        char c2 = 65535;
        AppMethodBeat.i(234721);
        synchronized (this.lock) {
            try {
                if (!isOpen()) {
                    IOException iOException = new IOException("DataSourceReader is closed");
                    AppMethodBeat.o(234721);
                    throw iOException;
                }
                char[] cArr = new char[1];
                if (read(cArr, 0, 1) != -1) {
                    c2 = cArr[0];
                }
            } finally {
                AppMethodBeat.o(234721);
            }
        }
        return c2;
    }

    @Override // java.io.Reader
    public final int read(char[] cArr, int i2, int i3) {
        CoderResult coderResult;
        int position;
        AppMethodBeat.i(234722);
        synchronized (this.lock) {
            try {
                if (!isOpen()) {
                    IOException iOException = new IOException("DataSourceReader is closed");
                    AppMethodBeat.o(234722);
                    throw iOException;
                }
                int length = cArr.length;
                if ((i2 | i3) < 0 || i2 > length || length - i2 < i3) {
                    ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException("arrayLength=" + length + ",offset=" + i2 + ",count=" + i3);
                    AppMethodBeat.o(234722);
                    throw arrayIndexOutOfBoundsException;
                } else if (i3 == 0) {
                    position = 0;
                } else {
                    CharBuffer wrap = CharBuffer.wrap(cArr, i2, i3);
                    CoderResult coderResult2 = CoderResult.UNDERFLOW;
                    boolean z = !this.mxT.hasRemaining();
                    while (true) {
                        if (wrap.hasRemaining()) {
                            if (z) {
                                try {
                                    if (this.mxQ.available() == 0 && wrap.position() > i2) {
                                        coderResult = coderResult2;
                                        break;
                                    }
                                } catch (Exception e2) {
                                }
                                if (!this.mxR) {
                                    int read = this.mxQ.read(this.mxT.array(), this.mxT.arrayOffset() + this.mxT.limit(), this.mxT.capacity() - this.mxT.limit());
                                    if (read != -1) {
                                        if (read == 0) {
                                            break;
                                        }
                                        this.mxT.limit(read + this.mxT.limit());
                                    } else {
                                        this.mxR = true;
                                        coderResult = coderResult2;
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                            coderResult = this.mxS.decode(this.mxT, wrap, false);
                            if (!coderResult.isUnderflow()) {
                                break;
                            }
                            if (this.mxT.limit() == this.mxT.capacity()) {
                                this.mxT.compact();
                                this.mxT.limit(this.mxT.position());
                                this.mxT.position(0);
                            }
                            z = true;
                            coderResult2 = coderResult;
                        } else {
                            break;
                        }
                    }
                    coderResult = coderResult2;
                    if (coderResult == CoderResult.UNDERFLOW && this.mxR) {
                        coderResult = this.mxS.decode(this.mxT, wrap, true);
                        this.mxS.flush(wrap);
                        this.mxS.reset();
                    }
                    if (coderResult.isMalformed() || coderResult.isUnmappable()) {
                        coderResult.throwException();
                    }
                    if (wrap.position() - i2 == 0) {
                        position = -1;
                    } else {
                        position = wrap.position() - i2;
                    }
                    AppMethodBeat.o(234722);
                }
            } finally {
                AppMethodBeat.o(234722);
            }
        }
        return position;
    }

    private boolean isOpen() {
        return this.mxQ != null;
    }
}
