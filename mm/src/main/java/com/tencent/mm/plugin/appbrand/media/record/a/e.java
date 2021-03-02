package com.tencent.mm.plugin.appbrand.media.record.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.plugin.appbrand.media.encode.Mp3EncodeJni;
import com.tencent.mm.plugin.appbrand.media.record.h;
import com.tencent.mm.plugin.appbrand.media.record.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

public final class e extends c {
    private int jlA = 2;
    private OutputStream mFileOutputStream;
    private String mFilePath = "";
    private byte[] nem;

    @Override // com.tencent.mm.plugin.appbrand.media.record.a.d, com.tencent.mm.plugin.appbrand.media.record.a.c
    public final boolean i(String str, int i2, int i3, int i4) {
        boolean z = true;
        AppMethodBeat.i(146345);
        Log.i("MicroMsg.Record.MP3AudioEncoder", "init, filePath:%s, sampleRate:%d, channelCount:%d, bitRate:%d", str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        this.mFilePath = str;
        this.jlA = i3;
        int init = Mp3EncodeJni.init(i2, i3, i2, i4 / 1000, 5);
        Log.i("MicroMsg.Record.MP3AudioEncoder", "Mp3EncodeJni.init ret :%d", Integer.valueOf(init));
        if (init == -1) {
            j.yz(17);
            AppMethodBeat.o(146345);
            return false;
        }
        Log.i("MicroMsg.Record.MP3AudioEncoder", "lame MPEG version:%d", Integer.valueOf(Mp3EncodeJni.getVersion()));
        try {
            this.mFileOutputStream = s.dw(str, false);
        } catch (FileNotFoundException e2) {
            Log.printErrStackTrace("MicroMsg.Record.MP3AudioEncoder", e2, APMidasPluginInfo.LAUNCH_INTERFACE_INIT, new Object[0]);
            j.yz(18);
            z = false;
        }
        AppMethodBeat.o(146345);
        return z;
    }

    @Override // com.tencent.mm.plugin.appbrand.media.record.a.d, com.tencent.mm.plugin.appbrand.media.record.a.c
    public final boolean a(boolean z, byte[] bArr, int i2) {
        boolean z2 = true;
        AppMethodBeat.i(146346);
        if (this.nei <= 0) {
            Log.e("MicroMsg.Record.MP3AudioEncoder", "mMinBufferSize %d is invalid", Integer.valueOf(this.nei));
            AppMethodBeat.o(146346);
            return false;
        } else if (this.mFileOutputStream == null) {
            Log.e("MicroMsg.Record.MP3AudioEncoder", "mFileOutputStream is null");
            AppMethodBeat.o(146346);
            return false;
        } else {
            if (this.nem == null) {
                int i3 = (int) (7200.0d + (((double) (this.nei * this.jlA)) * 1.25d));
                Log.i("MicroMsg.Record.MP3AudioEncoder", "channelCnt:%d, mMinBufferSize:%d, size:%d, ", Integer.valueOf(this.jlA), Integer.valueOf(this.nei), Integer.valueOf(i3));
                this.nem = new byte[i3];
            }
            short[] G = h.G(bArr, i2);
            int encode = Mp3EncodeJni.encode(G, G, i2 / 2, this.nem);
            Log.d("MicroMsg.Record.MP3AudioEncoder", "len:%d, shorts.len:%d, encodedSize:%d", Integer.valueOf(i2), Integer.valueOf(G.length), Integer.valueOf(encode));
            if (encode > 0) {
                Log.d("MicroMsg.Record.MP3AudioEncoder", "encodeSize:%d, len:%d", Integer.valueOf(encode), Integer.valueOf(i2));
                try {
                    this.mFileOutputStream.write(this.nem, 0, encode);
                    d(this.nem, encode, false);
                } catch (IOException e2) {
                    Log.printErrStackTrace("MicroMsg.Record.MP3AudioEncoder", e2, "encode write", new Object[0]);
                    j.yz(20);
                    z2 = false;
                }
            } else {
                Log.e("MicroMsg.Record.MP3AudioEncoder", "Mp3EncodeJni encode fail, encodedSize:%d", Integer.valueOf(encode));
                z2 = false;
            }
            AppMethodBeat.o(146346);
            return z2;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.media.record.a.d, com.tencent.mm.plugin.appbrand.media.record.a.c
    public final void flush() {
        AppMethodBeat.i(146347);
        Log.i("MicroMsg.Record.MP3AudioEncoder", "flush");
        if (this.mFileOutputStream == null || this.nem == null) {
            Log.e("MicroMsg.Record.MP3AudioEncoder", "flush, mFileOutputStream or mMp3Buffer is null");
            AppMethodBeat.o(146347);
            return;
        }
        int flush = Mp3EncodeJni.flush(this.nem);
        if (flush > 0) {
            try {
                this.mFileOutputStream.write(this.nem, 0, flush);
                d(this.nem, flush, true);
                AppMethodBeat.o(146347);
            } catch (IOException e2) {
                Log.printErrStackTrace("MicroMsg.Record.MP3AudioEncoder", e2, "flush write", new Object[0]);
                j.yz(20);
                AppMethodBeat.o(146347);
            }
        } else {
            Log.e("MicroMsg.Record.MP3AudioEncoder", "flush fail, flushResult:%d", Integer.valueOf(flush));
            AppMethodBeat.o(146347);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.media.record.a.d, com.tencent.mm.plugin.appbrand.media.record.a.c
    public final void close() {
        AppMethodBeat.i(146348);
        Log.i("MicroMsg.Record.MP3AudioEncoder", "close");
        Mp3EncodeJni.close();
        if (this.mFileOutputStream != null) {
            try {
                this.mFileOutputStream.close();
            } catch (IOException e2) {
                Log.printErrStackTrace("MicroMsg.Record.MP3AudioEncoder", e2, "close", new Object[0]);
                j.yz(20);
            }
            this.mFileOutputStream = null;
        }
        AppMethodBeat.o(146348);
    }
}
