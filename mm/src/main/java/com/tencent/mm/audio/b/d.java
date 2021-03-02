package com.tencent.mm.audio.b;

import android.media.AudioRecord;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.Arrays;

public final class d extends f {
    byte[] dzF = null;
    private int dzG;
    int dzH;
    private AudioRecord.OnRecordPositionUpdateListener dzI = new AudioRecord.OnRecordPositionUpdateListener() {
        /* class com.tencent.mm.audio.b.d.AnonymousClass1 */

        public final void onMarkerReached(AudioRecord audioRecord) {
        }

        public final void onPeriodicNotification(AudioRecord audioRecord) {
            AppMethodBeat.i(129994);
            if (d.this.mIsPause) {
                AppMethodBeat.o(129994);
                return;
            }
            if (d.this.dzu != null) {
                if (d.this.dzg || d.this.dzF == null) {
                    d.this.dzF = new byte[d.this.dzH];
                }
                int read = d.this.dzu.read(d.this.dzF, 0, d.this.dzH);
                Log.d("MicroMsg.RecordModeAsyncCallback", "OnRecordPositionUpdateListener, read ret: ".concat(String.valueOf(read)));
                if (d.this.dzD != null) {
                    d.this.dzD.d(read, d.this.dzF);
                }
                if (read > d.this.dzF.length) {
                    read = d.this.dzF.length;
                }
                if (d.this.mIsMute && read > 0) {
                    Arrays.fill(d.this.dzF, 0, read, (byte) 0);
                }
                if (d.this.dzv != null && read > 0) {
                    d.this.dzv.w(d.this.dzF, read);
                }
            }
            AppMethodBeat.o(129994);
        }
    };
    boolean dzg;
    AudioRecord dzu;
    c.a dzv;
    private HandlerThread mHandlerThread = null;
    boolean mIsMute;

    public d(AudioRecord audioRecord, c.a aVar, boolean z, int i2, int i3) {
        AppMethodBeat.i(129995);
        this.dzu = audioRecord;
        this.dzv = aVar;
        this.dzg = z;
        this.dzG = i2;
        this.dzH = i3;
        AppMethodBeat.o(129995);
    }

    @Override // com.tencent.mm.audio.b.f
    public final boolean aai() {
        AppMethodBeat.i(129996);
        if (this.mHandlerThread != null) {
            Log.e("MicroMsg.RecordModeAsyncCallback", "alreay started record");
            AppMethodBeat.o(129996);
            return false;
        }
        this.mHandlerThread = com.tencent.f.c.d.hA("RecordModeAsyncCallback_handlerThread", 10);
        this.mHandlerThread.start();
        this.dzu.setRecordPositionUpdateListener(this.dzI, MMHandler.createFreeHandler(this.mHandlerThread.getLooper()));
        this.dzu.setPositionNotificationPeriod(this.dzG);
        if (this.dzg || this.dzF == null) {
            this.dzF = new byte[this.dzH];
        }
        int read = this.dzu.read(this.dzF, 0, this.dzH);
        Log.d("MicroMsg.RecordModeAsyncCallback", "startRecord, read ret: ".concat(String.valueOf(read)));
        if (this.dzv != null && read > 0) {
            this.dzv.w(this.dzF, read);
        }
        AppMethodBeat.o(129996);
        return true;
    }

    @Override // com.tencent.mm.audio.b.f
    public final void stopRecord() {
        AppMethodBeat.i(129997);
        this.dzu.setRecordPositionUpdateListener(null);
        this.dzu = null;
        this.mHandlerThread.quit();
        this.mHandlerThread = null;
        AppMethodBeat.o(129997);
    }

    @Override // com.tencent.mm.audio.b.f
    public final void de(boolean z) {
        this.mIsMute = z;
    }
}
