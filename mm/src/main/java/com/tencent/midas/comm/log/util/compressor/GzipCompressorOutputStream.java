package com.tencent.midas.comm.log.util.compressor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.CRC32;
import java.util.zip.Deflater;

public class GzipCompressorOutputStream extends OutputStream {
    private final byte[] _header = {31, -117, 8, 0, 0, 0, 0, 0, 0, 0};
    private boolean closed;
    private final CRC32 crc = new CRC32();
    private final byte[] deflateBuffer = new byte[512];
    private final Deflater deflater;
    private final OutputStream out;

    public GzipCompressorOutputStream(OutputStream outputStream) {
        AppMethodBeat.i(193476);
        this.out = outputStream;
        this.deflater = new Deflater(-1, true);
        AppMethodBeat.o(193476);
    }

    public void writeHeader() {
        AppMethodBeat.i(193477);
        this.out.write(this._header);
        AppMethodBeat.o(193477);
    }

    private void writeTrailer() {
        AppMethodBeat.i(193478);
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.putInt((int) this.crc.getValue());
        allocate.putInt(this.deflater.getTotalIn());
        this.out.write(allocate.array());
        AppMethodBeat.o(193478);
    }

    @Override // java.io.OutputStream
    public void write(int i2) {
        AppMethodBeat.i(193479);
        write(new byte[]{(byte) (i2 & 255)}, 0, 1);
        AppMethodBeat.o(193479);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        AppMethodBeat.i(193480);
        write(bArr, 0, bArr.length);
        AppMethodBeat.o(193480);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(193481);
        if (this.deflater.finished()) {
            IOException iOException = new IOException("Cannot write more data, the end of the compressed data stream has been reached");
            AppMethodBeat.o(193481);
            throw iOException;
        }
        if (i3 > 0) {
            this.deflater.setInput(bArr, i2, i3);
            while (!this.deflater.needsInput()) {
                deflate();
            }
            this.crc.update(bArr, i2, i3);
        }
        AppMethodBeat.o(193481);
    }

    private void deflate() {
        AppMethodBeat.i(193482);
        int deflate = this.deflater.deflate(this.deflateBuffer, 0, this.deflateBuffer.length);
        if (deflate > 0) {
            this.out.write(this.deflateBuffer, 0, deflate);
        }
        AppMethodBeat.o(193482);
    }

    public void finish() {
        AppMethodBeat.i(193483);
        if (!this.deflater.finished()) {
            this.deflater.finish();
            while (!this.deflater.finished()) {
                deflate();
            }
            writeTrailer();
        }
        AppMethodBeat.o(193483);
    }

    public void continued() {
        AppMethodBeat.i(193484);
        this.crc.reset();
        this.deflater.reset();
        AppMethodBeat.o(193484);
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        AppMethodBeat.i(193485);
        this.out.flush();
        AppMethodBeat.o(193485);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        AppMethodBeat.i(193486);
        if (!this.closed) {
            finish();
            this.deflater.end();
            this.out.close();
            this.closed = true;
        }
        AppMethodBeat.o(193486);
    }
}
