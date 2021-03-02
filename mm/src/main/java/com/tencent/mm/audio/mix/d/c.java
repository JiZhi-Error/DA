package com.tencent.mm.audio.mix.d;

import android.text.TextUtils;
import com.tencent.mm.ai.b;
import com.tencent.mm.audio.mix.a.e;
import com.tencent.mm.audio.mix.c.h;
import com.tencent.mm.audio.mix.g.d;
import com.tencent.mm.audio.mix.g.f;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class c implements l, f {
    protected int channels = 0;
    protected volatile String dtX;
    protected volatile d dva;
    protected volatile com.tencent.mm.audio.mix.h.c dvj;
    protected volatile b dvk;
    protected h dvl;
    protected int dvm = 0;
    public volatile String dvn;
    protected AtomicBoolean dvo = new AtomicBoolean(false);
    protected AtomicInteger dvp = new AtomicInteger(0);
    protected AtomicBoolean dvq = new AtomicBoolean(false);
    protected AtomicBoolean dvr = new AtomicBoolean(false);
    protected AtomicBoolean dvs = new AtomicBoolean(false);
    protected AtomicBoolean dvt = new AtomicBoolean(false);
    protected AtomicBoolean dvu = new AtomicBoolean(false);
    protected int dvv;
    protected int dvw = -1;
    protected Object dvx = new Object();
    protected Object lock = new Object();
    protected int sampleRate = 0;
    protected volatile String sourcePath;

    /* access modifiers changed from: protected */
    public abstract void Ze();

    protected c(d dVar, com.tencent.mm.audio.mix.h.c cVar) {
        this.dva = dVar;
        this.dvj = cVar;
        this.dvk = this.dvj.ZU();
        this.dtX = this.dvk.dtX;
        this.sourcePath = this.dvk.filePath;
        this.dvv = this.dvk.dvv;
        this.dvn = this.dvk.dvn;
    }

    @Override // com.tencent.mm.audio.mix.d.l
    public final void init() {
        this.dvv = this.dvj.ZU().iJD;
        this.dvq.set(false);
        this.dvr.set(false);
        if (this.dvj != null) {
            this.dvj.connect();
        }
        je(1);
    }

    @Override // com.tencent.mm.audio.mix.d.l
    public final void YU() {
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "preload");
        this.dvo.set(true);
        je(10);
    }

    @Override // com.tencent.mm.audio.mix.d.l
    public final void resume() {
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "resume");
        je(4);
        synchronized (this.lock) {
            if (this.dvq.get()) {
                this.dvq.set(false);
                try {
                    this.lock.notify();
                } catch (Exception e2) {
                    com.tencent.mm.audio.mix.i.b.printErrStackTrace("MicroMsg.Mix.AudioDecoderBase", e2, "resume", new Object[0]);
                }
            }
        }
    }

    @Override // com.tencent.mm.audio.mix.d.l
    public void pause() {
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "pause");
        je(5);
        this.dvq.set(true);
        this.dvt.set(false);
    }

    @Override // com.tencent.mm.audio.mix.d.l
    public void YV() {
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "pauseOnBackground");
        pause();
    }

    @Override // com.tencent.mm.audio.mix.d.l
    public final void stop() {
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "stop");
        Zj();
        je(6);
        this.dvr.set(true);
        this.dvq.set(false);
        Zc();
        this.dvt.set(false);
        this.dvu.set(false);
    }

    @Override // com.tencent.mm.audio.mix.d.l
    public void seek(int i2) {
        int i3 = this.dvv;
        synchronized (this.dvx) {
            this.dvv = i2;
            this.dvw = i2 / 20;
            com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "seek preStartTime:%d, seek position:%d", Integer.valueOf(i3), Integer.valueOf(i2));
        }
    }

    @Override // com.tencent.mm.audio.mix.d.l
    public final void release() {
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "release");
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "duration:%d", Long.valueOf(Za().duration));
        YW();
        onRelease();
        if (this.dvj != null) {
            this.dvj.ZU().dvv = 0;
            this.dvj.disconnect();
        }
        this.dvo.set(false);
        this.dvr.set(true);
        this.dvq.set(false);
        this.dvs.set(false);
        this.dva = null;
    }

    public void YW() {
        WeakReference<c> remove;
        com.tencent.mm.audio.mix.f.c cVar = this.dva.dxo;
        String Zl = Zl();
        if (cVar.dwk.containsKey(Zl) && (remove = cVar.dwk.remove(Zl)) != null && remove.get() != null) {
            remove.clear();
        }
    }

    public final void YX() {
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "onError needTry:%b", Boolean.TRUE);
        this.dvr.set(true);
        je(9);
        com.tencent.mm.audio.mix.a.d Za = Za();
        if (Za != null && !Za.aBQ) {
            Za.reset();
        }
    }

    @Override // com.tencent.mm.audio.mix.d.l
    public final boolean YY() {
        return this.dvq.get();
    }

    @Override // com.tencent.mm.audio.mix.d.l
    public final boolean YZ() {
        return this.dvr.get();
    }

    private boolean isPlaying() {
        return this.dvp.get() == 4;
    }

    private boolean isError() {
        return this.dvp.get() == 9;
    }

    @Override // com.tencent.mm.audio.mix.d.l
    public final com.tencent.mm.audio.mix.a.d Za() {
        return com.tencent.mm.audio.mix.b.f.YL().gE(this.sourcePath);
    }

    /* access modifiers changed from: protected */
    public final void Zb() {
        synchronized (this.lock) {
            while (!this.dvr.get() && this.dvq.get()) {
                try {
                    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "waitDecode");
                    this.lock.wait();
                } catch (Exception e2) {
                    com.tencent.mm.audio.mix.i.b.printErrStackTrace("MicroMsg.Mix.AudioDecoderBase", e2, "waitDecode", new Object[0]);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void Zc() {
        synchronized (this.lock) {
            try {
                this.lock.notify();
            } catch (Exception e2) {
                com.tencent.mm.audio.mix.i.b.printErrStackTrace("MicroMsg.Mix.AudioDecoderBase", e2, "notifyDecode", new Object[0]);
            }
        }
    }

    @Override // com.tencent.mm.audio.mix.d.l
    public final void Zd() {
        boolean z;
        if (this.dva.dxr != null) {
            this.dva.dxr.jj(Zk().fromScene);
        }
        this.sourcePath = Zk().filePath;
        if (TextUtils.isEmpty(this.sourcePath)) {
            com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioDecoderBase", "source path is null");
            this.dvm = 712;
            onError(this.dvm);
            return;
        }
        b Zk = Zk();
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "decode sourcePath :%s, loop:%b", this.sourcePath, Boolean.valueOf(Zk.loop));
        if (this.dvo.get()) {
            com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "do preload audio");
            if (Zk.iJT) {
                com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "preload begin");
                if (!com.tencent.mm.audio.mix.b.f.YL().gG(this.sourcePath)) {
                    Ze();
                } else {
                    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "audio is loaded complete!");
                }
                com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "preload end");
                je(15);
                return;
            }
            if (!isPlaying()) {
                je(3);
            }
            if (!com.tencent.mm.audio.mix.b.f.YL().gG(this.sourcePath)) {
                Ze();
            } else {
                com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "audio is loaded complete!");
            }
            com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "preload audio end");
            this.dvo.set(false);
            com.tencent.mm.audio.mix.a.d Za = Za();
            if (this.dvr.get()) {
                com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "stopped, not to play");
                if (Za.aBQ) {
                    je(2);
                    return;
                }
                return;
            } else if (isError()) {
                com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "occurs error, not to play");
                return;
            } else if (isPlaying() || Zk.iJE) {
                com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "to play");
                je(2);
            } else {
                com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "not to play");
                je(2);
                return;
            }
        }
        je(4);
        do {
            if (!com.tencent.mm.audio.mix.b.f.YL().gG(this.sourcePath)) {
                Ze();
            } else {
                Zf();
            }
            if (!Zk.loop || this.dvr.get()) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "loop again for audioId:%s", Zl());
                try {
                    Thread.sleep(20);
                } catch (Exception e2) {
                    com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioDecoderBase", "sleep exception");
                }
                this.dvv = 0;
                continue;
            }
        } while (z);
        if (this.dvr.get() || isError()) {
            com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "is stop or error, not set to play complete!");
            if (this.dvj.equals(Zk().filePath)) {
                this.dva.dxo.gU(Zl());
                com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "removeAudio");
            } else {
                com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "change src only, don't removeAudio");
            }
        } else if (!this.dva.dxo.gW(Zl())) {
            com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "not mix end, not set to play complete!");
            this.dva.dxo.m(Zl(), true);
        } else {
            je(7);
            this.dva.dxo.gU(Zl());
        }
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "task end");
    }

    /* access modifiers changed from: protected */
    public final void a(com.tencent.mm.audio.mix.a.d dVar) {
        if (this.dvl == null) {
            com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioDecoderBase", "process is null");
            return;
        }
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "writeCacheAndPlay");
        Zh();
        while (true) {
            if (this.dvr.get()) {
                break;
            }
            Zb();
            e YS = this.dvl.YS();
            if (dVar.size() <= 0 || YS != null) {
                if (dVar.size() != 0 || YS != null) {
                    if (YS != null) {
                        if (!dVar.aBQ) {
                            dVar.a(YS);
                        }
                        a(YS);
                        if (YS == null) {
                            break;
                        }
                    } else {
                        break;
                    }
                } else {
                    dVar.reset();
                    break;
                }
            } else {
                dVar.complete();
                break;
            }
        }
        Zi();
    }

    /* access modifiers changed from: protected */
    public final void Zf() {
        int i2 = 0;
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "readCacheAndPlay");
        com.tencent.mm.audio.mix.a.d Za = Za();
        if (Za != null) {
            Zh();
            int size = Za.size();
            while (i2 < size && !this.dvr.get()) {
                Zb();
                synchronized (this.dvx) {
                    if (this.dvw >= 0 && this.dvw < size) {
                        i2 = this.dvw;
                        this.dvw = -1;
                        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "seek to pos:%s", Integer.valueOf(i2));
                    }
                }
                e jb = Za.jb(i2);
                if (jb != null) {
                    a(jb);
                }
                i2++;
            }
            Zi();
        }
    }

    /* access modifiers changed from: protected */
    public final void a(e eVar) {
        if (this.dvo.get() || eVar == null) {
            return;
        }
        if ((eVar.dua <= 0 || this.dvv <= 0 || eVar.dua >= ((long) this.dvv)) && this.dva != null && this.dva.dxo != null && eVar != null) {
            eVar.dtX = Zl();
            c(eVar);
        }
    }

    public final void jd(int i2) {
        if (i2 < 20 && this.dvs.get() && !this.dvq.get() && !this.dvr.get()) {
            com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "unLockWrite, queueSize:%d", Integer.valueOf(i2));
            Zc();
        }
    }

    /* access modifiers changed from: protected */
    public final void je(int i2) {
        d(i2, 0, "");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0022  */
    /* JADX WARNING: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void d(int r7, int r8, java.lang.String r9) {
        /*
        // Method dump skipped, instructions count: 116
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.audio.mix.d.c.d(int, int, java.lang.String):void");
    }

    @Override // com.tencent.mm.audio.mix.g.f
    public final void Zg() {
        if (!this.dvt.get() && !this.dvr.get()) {
            this.dvt.set(true);
            je(13);
        }
    }

    @Override // com.tencent.mm.audio.mix.g.f
    public final void onError(int i2) {
        com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioDecoderBase", "onError, errType:%d", Integer.valueOf(i2));
        this.dvm = i2;
        this.dvr.set(true);
        d(9, i2, "");
    }

    /* access modifiers changed from: protected */
    public void Zh() {
    }

    /* access modifiers changed from: protected */
    public void c(e eVar) {
        if (this.dvj.ZU().dtU) {
            if (!this.dvu.get()) {
                this.dvu.set(true);
                je(14);
            }
            int a2 = this.dva.dxo.a(Zl(), eVar, this);
            if (a2 < 50) {
                this.dvs.set(false);
                return;
            }
            com.tencent.mm.audio.mix.a.d Za = Za();
            if (Za == null || !Za.aBQ) {
                this.dvs.set(false);
                return;
            }
            this.dvs.set(true);
            synchronized (this.lock) {
                try {
                    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "lockWriteBuffer, writeSize:%d", Integer.valueOf(a2));
                    this.lock.wait();
                } catch (Exception e2) {
                    com.tencent.mm.audio.mix.i.b.printErrStackTrace("MicroMsg.Mix.AudioDecoderBase", e2, "lockWriteBuffer", new Object[0]);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void Zi() {
    }

    public void Zj() {
    }

    @Override // com.tencent.mm.audio.mix.d.l
    public final b Zk() {
        if (this.dvj != null) {
            return this.dvj.ZU();
        }
        return this.dvk;
    }

    private String Zl() {
        b Zk = Zk();
        if (Zk != null) {
            return Zk.dtX;
        }
        com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioDecoderBase", "param is null");
        return this.dtX;
    }

    @Override // com.tencent.mm.audio.mix.d.l
    public long getCurrentPosition() {
        return -1;
    }
}
