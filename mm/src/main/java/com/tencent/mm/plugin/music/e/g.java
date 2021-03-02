package com.tencent.mm.plugin.music.e;

import com.tencent.mm.ay.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.net.URL;
import java.util.List;

public abstract class g implements a {
    protected c Ajw;
    protected f nda;

    @Override // com.tencent.mm.plugin.music.e.a
    public void init() {
    }

    @Override // com.tencent.mm.plugin.music.e.a
    public final void a(c cVar) {
        this.Ajw = cVar;
    }

    @Override // com.tencent.mm.plugin.music.e.a
    public boolean i(f fVar) {
        this.nda = fVar;
        return true;
    }

    @Override // com.tencent.mm.plugin.music.e.a
    public f j(f fVar) {
        return fVar;
    }

    @Override // com.tencent.mm.plugin.music.e.a
    public f k(f fVar) {
        return fVar;
    }

    @Override // com.tencent.mm.plugin.music.e.a
    public f y(List<f> list, int i2) {
        if (list == null || list.size() == 0 || i2 >= list.size()) {
            Log.i("MicroMsg.Music.MusicBaseLogic", "music wrapper list error");
            return null;
        }
        this.nda = list.get(i2);
        Log.i("MicroMsg.Music.MusicBaseLogic", "startPlayNewMusicList:%d", Integer.valueOf(i2));
        return this.nda;
    }

    @Override // com.tencent.mm.plugin.music.e.a
    public void l(f fVar) {
        this.nda = fVar;
    }

    @Override // com.tencent.mm.plugin.music.e.a
    public void i(List<f> list, boolean z) {
    }

    @Override // com.tencent.mm.plugin.music.e.a
    public f etU() {
        return this.nda;
    }

    @Override // com.tencent.mm.plugin.music.e.a
    public void m(f fVar) {
        if (this.nda == null || !this.nda.f(fVar)) {
            this.nda = fVar;
            return;
        }
        f fVar2 = this.nda;
        fVar2.jeX = fVar.jeX;
        fVar2.jeY = fVar.jeY;
        fVar2.jeZ = fVar.jeZ;
        fVar2.jfa = fVar.jfa;
        fVar2.jfe = fVar.jfe;
        fVar2.jff = fVar.jff;
        fVar2.jfg = fVar.jfg;
        fVar2.jfh = fVar.jfh;
        fVar2.jfm = fVar.jfm;
        fVar2.jfi = fVar.jfi;
        fVar2.dvv = fVar.dvv;
        fVar2.protocol = fVar.protocol;
        fVar2.iJH = fVar.iJH;
        fVar2.volume = fVar.volume;
        fVar2.jfh = fVar.jfh;
        fVar2.iJQ = fVar.iJP;
        fVar2.iJQ = fVar.iJQ;
        fVar2.jfs = fVar.jfs;
        fVar2.jft = fVar.jft;
        fVar2.eag = fVar.eag;
        fVar2.jfv = fVar.jfv;
        fVar2.jfu = fVar.jfu;
        fVar2.jfx = fVar.jfx;
    }

    @Override // com.tencent.mm.plugin.music.e.a
    public boolean hWq() {
        return true;
    }

    @Override // com.tencent.mm.plugin.music.e.a
    public String aiK(String str) {
        return str;
    }

    @Override // com.tencent.mm.plugin.music.e.a
    public URL aHK(String str) {
        return new URL(str);
    }

    @Override // com.tencent.mm.plugin.music.e.a
    public void n(f fVar) {
    }

    @Override // com.tencent.mm.plugin.music.e.a
    public void o(f fVar) {
    }

    @Override // com.tencent.mm.plugin.music.e.a
    public void p(f fVar) {
    }

    @Override // com.tencent.mm.plugin.music.e.a
    public void q(f fVar) {
    }

    @Override // com.tencent.mm.plugin.music.e.a
    public void r(f fVar) {
    }

    @Override // com.tencent.mm.plugin.music.e.a
    public void a(f fVar, int i2) {
    }
}
