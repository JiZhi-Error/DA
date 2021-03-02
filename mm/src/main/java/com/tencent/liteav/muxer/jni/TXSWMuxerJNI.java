package com.tencent.liteav.muxer.jni;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tavkit.component.TAVPlayer;
import java.nio.ByteBuffer;

public class TXSWMuxerJNI {

    /* renamed from: a  reason: collision with root package name */
    private long f849a;

    /* renamed from: b  reason: collision with root package name */
    private volatile boolean f850b;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f851c;

    public static class AVOptions {
        public int audioChannels = 0;
        public int audioSampleRate = 0;
        public int videoGOP = 12;
        public int videoHeight = TAVPlayer.VIDEO_PLAYER_WIDTH;
        public int videoWidth = 960;
    }

    private native long init();

    private native void release(long j2);

    private native void setAVParams(long j2, AVOptions aVOptions);

    private native void setAudioCSD(long j2, byte[] bArr);

    private native void setDstPath(long j2, String str);

    private native void setVideoCSD(long j2, byte[] bArr, byte[] bArr2);

    private native int start(long j2);

    private native int stop(long j2);

    private native int writeFrame(long j2, byte[] bArr, int i2, int i3, int i4, int i5, long j3);

    public TXSWMuxerJNI() {
        AppMethodBeat.i(14945);
        this.f849a = -1;
        this.f849a = init();
        this.f850b = true;
        AppMethodBeat.o(14945);
    }

    public void a(AVOptions aVOptions) {
        AppMethodBeat.i(14946);
        if (this.f850b) {
            setAVParams(this.f849a, aVOptions);
            AppMethodBeat.o(14946);
            return;
        }
        TXCLog.e("TXSWMuxerJNI", "Muxer isn't init yet!");
        AppMethodBeat.o(14946);
    }

    public void a(String str) {
        AppMethodBeat.i(14947);
        if (this.f850b) {
            setDstPath(this.f849a, str);
            AppMethodBeat.o(14947);
            return;
        }
        TXCLog.e("TXSWMuxerJNI", "Muxer isn't init yet!");
        AppMethodBeat.o(14947);
    }

    public void a(ByteBuffer byteBuffer, int i2, ByteBuffer byteBuffer2, int i3) {
        AppMethodBeat.i(14948);
        if (this.f850b) {
            setVideoCSD(this.f849a, b(byteBuffer, i2), b(byteBuffer2, i3));
            AppMethodBeat.o(14948);
            return;
        }
        TXCLog.e("TXSWMuxerJNI", "Muxer isn't init yet!");
        AppMethodBeat.o(14948);
    }

    public void a(ByteBuffer byteBuffer, int i2) {
        AppMethodBeat.i(14949);
        if (this.f850b) {
            setAudioCSD(this.f849a, b(byteBuffer, i2));
            AppMethodBeat.o(14949);
            return;
        }
        TXCLog.e("TXSWMuxerJNI", "Muxer isn't init yet!");
        AppMethodBeat.o(14949);
    }

    public int a(ByteBuffer byteBuffer, int i2, int i3, int i4, int i5, long j2) {
        AppMethodBeat.i(14950);
        if (!this.f850b) {
            TXCLog.e("TXSWMuxerJNI", "Muxer isn't init yet!");
            AppMethodBeat.o(14950);
            return -1;
        } else if (this.f851c) {
            int writeFrame = writeFrame(this.f849a, b(byteBuffer, i4), i2, i3, i4, i5, j2);
            if (writeFrame != 0) {
                TXCLog.e("TXSWMuxerJNI", "Muxer write frame error!");
            }
            AppMethodBeat.o(14950);
            return writeFrame;
        } else {
            TXCLog.e("TXSWMuxerJNI", "Muxer isn't start yet!");
            AppMethodBeat.o(14950);
            return -1;
        }
    }

    public int a() {
        AppMethodBeat.i(14951);
        if (this.f850b) {
            int start = start(this.f849a);
            if (start == 0) {
                this.f851c = true;
            } else {
                TXCLog.e("TXSWMuxerJNI", "Start Muxer Error!!!");
            }
            AppMethodBeat.o(14951);
            return start;
        }
        TXCLog.e("TXSWMuxerJNI", "Muxer isn't init yet!");
        AppMethodBeat.o(14951);
        return -1;
    }

    public int b() {
        int i2 = -1;
        AppMethodBeat.i(14952);
        if (!this.f850b) {
            TXCLog.e("TXSWMuxerJNI", "Muxer isn't init yet!");
            AppMethodBeat.o(14952);
        } else if (this.f851c) {
            this.f851c = false;
            i2 = stop(this.f849a);
            if (i2 != 0) {
                TXCLog.e("TXSWMuxerJNI", "Stop Muxer Error!!!");
            }
            AppMethodBeat.o(14952);
        } else {
            TXCLog.e("TXSWMuxerJNI", "Muxer isn't start yet!");
            AppMethodBeat.o(14952);
        }
        return i2;
    }

    public void c() {
        AppMethodBeat.i(14953);
        if (this.f850b) {
            release(this.f849a);
            this.f850b = false;
            this.f851c = false;
            AppMethodBeat.o(14953);
            return;
        }
        TXCLog.e("TXSWMuxerJNI", "Muxer isn't init yet!");
        AppMethodBeat.o(14953);
    }

    private byte[] b(ByteBuffer byteBuffer, int i2) {
        AppMethodBeat.i(14954);
        if (byteBuffer == null) {
            AppMethodBeat.o(14954);
            return null;
        }
        byte[] bArr = new byte[i2];
        byteBuffer.get(bArr);
        AppMethodBeat.o(14954);
        return bArr;
    }
}
