package com.tencent.liteav.audio.impl.Record;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<c> f160a;

    /* renamed from: b  reason: collision with root package name */
    private int f161b;

    /* renamed from: c  reason: collision with root package name */
    private int f162c;

    /* renamed from: d  reason: collision with root package name */
    private int f163d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f164e;

    /* renamed from: f  reason: collision with root package name */
    private Thread f165f;

    /* renamed from: g  reason: collision with root package name */
    private byte[] f166g;

    public void a() {
        AppMethodBeat.i(221927);
        this.f164e = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (!(this.f165f == null || !this.f165f.isAlive() || Thread.currentThread().getId() == this.f165f.getId())) {
            try {
                this.f165f.join();
            } catch (Exception e2) {
                TXCLog.e("AudioCenter:TXCAudioBGMRecord", "record stop Exception: " + e2.getMessage());
            }
        }
        TXCLog.i("AudioCenter:TXCAudioBGMRecord", "stop record cost time(MS): " + (System.currentTimeMillis() - currentTimeMillis));
        this.f165f = null;
        AppMethodBeat.o(221927);
    }

    private void a(byte[] bArr, int i2, long j2) {
        AppMethodBeat.i(221928);
        c cVar = null;
        synchronized (this) {
            try {
                if (this.f160a != null) {
                    cVar = this.f160a.get();
                }
            } catch (Throwable th) {
                AppMethodBeat.o(221928);
                throw th;
            }
        }
        if (cVar != null) {
            cVar.onAudioRecordPCM(bArr, i2, j2);
            AppMethodBeat.o(221928);
            return;
        }
        TXCLog.e("AudioCenter:TXCAudioBGMRecord", "onRecordPcmData:no callback");
        AppMethodBeat.o(221928);
    }

    private void b() {
        AppMethodBeat.i(221929);
        c cVar = null;
        synchronized (this) {
            try {
                if (this.f160a != null) {
                    cVar = this.f160a.get();
                }
            } catch (Throwable th) {
                AppMethodBeat.o(221929);
                throw th;
            }
        }
        if (cVar != null) {
            cVar.onAudioRecordStart();
            AppMethodBeat.o(221929);
            return;
        }
        TXCLog.e("AudioCenter:TXCAudioBGMRecord", "onRecordStart:no callback");
        AppMethodBeat.o(221929);
    }

    private void c() {
        AppMethodBeat.i(221930);
        c cVar = null;
        synchronized (this) {
            try {
                if (this.f160a != null) {
                    cVar = this.f160a.get();
                }
            } catch (Throwable th) {
                AppMethodBeat.o(221930);
                throw th;
            }
        }
        if (cVar != null) {
            cVar.onAudioRecordStop();
            AppMethodBeat.o(221930);
            return;
        }
        TXCLog.e("AudioCenter:TXCAudioBGMRecord", "onRecordStop:no callback");
        AppMethodBeat.o(221930);
    }

    public void run() {
        AppMethodBeat.i(221931);
        if (!this.f164e) {
            TXCLog.w("AudioCenter:TXCAudioBGMRecord", "audio record: abandom start audio sys record thread!");
            AppMethodBeat.o(221931);
            return;
        }
        b();
        int i2 = this.f161b;
        int i3 = this.f162c;
        int i4 = this.f163d;
        int i5 = ((i3 * 1024) * i4) / 8;
        this.f166g = new byte[i5];
        Arrays.fill(this.f166g, (byte) 0);
        long j2 = 0;
        long currentTimeMillis = System.currentTimeMillis();
        while (this.f164e && !Thread.interrupted()) {
            if (((((((System.currentTimeMillis() - currentTimeMillis) * ((long) i2)) * ((long) i3)) * ((long) i4)) / 8) / 1000) - j2 < ((long) i5)) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e2) {
                }
            } else {
                j2 += (long) this.f166g.length;
                a(this.f166g, this.f166g.length, TXCTimeUtil.getTimeTick());
            }
        }
        c();
        AppMethodBeat.o(221931);
    }
}
