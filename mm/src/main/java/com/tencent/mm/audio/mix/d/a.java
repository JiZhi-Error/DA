package com.tencent.mm.audio.mix.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.audio.mix.b.f;
import com.tencent.mm.audio.mix.g.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a {
    public Object dup = new Object();
    public d dva;
    public HashMap<String, b> dvb = new HashMap<>();
    public HashMap<String, b> dvc = new HashMap<>();
    public List<String> dvd = new ArrayList();
    public LinkedList<String> dve = new LinkedList<>();

    public a(d dVar) {
        AppMethodBeat.i(136786);
        this.dva = dVar;
        f.YL().clearCache();
        AppMethodBeat.o(136786);
    }

    public final void clearCache() {
        AppMethodBeat.i(136787);
        this.dvb.clear();
        this.dve.clear();
        this.dvc.clear();
        AppMethodBeat.o(136787);
    }

    public final boolean gK(String str) {
        boolean contains;
        AppMethodBeat.i(136788);
        synchronized (this.dup) {
            try {
                contains = this.dvd.contains(str);
            } finally {
                AppMethodBeat.o(136788);
            }
        }
        return contains;
    }

    public final void stopAll() {
        l lVar;
        AppMethodBeat.i(136789);
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecodeMgr", "stopAll");
        Iterator<String> it = this.dve.iterator();
        while (it.hasNext()) {
            b bVar = this.dvb.get(it.next());
            if (bVar != null && !bVar.dvh && !bVar.YT() && (lVar = bVar.dvi) != null) {
                lVar.stop();
            }
        }
        AppMethodBeat.o(136789);
    }

    public final void gL(String str) {
        AppMethodBeat.i(136790);
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecodeMgr", "startDecode audioId:%s", str);
        c(str, false, false);
        AppMethodBeat.o(136790);
    }

    public final void gM(String str) {
        AppMethodBeat.i(136791);
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecodeMgr", "stopDecode audioId:%s", str);
        b bVar = this.dvb.get(str);
        if (bVar == null) {
            com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is not exist");
            AppMethodBeat.o(136791);
        } else if (bVar.dvh) {
            com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is execute end!");
            AppMethodBeat.o(136791);
        } else {
            l lVar = bVar.dvi;
            if (lVar != null) {
                lVar.stop();
                bVar.dvi = null;
                this.dvb.remove(str);
            }
            AppMethodBeat.o(136791);
        }
    }

    public final boolean c(String str, boolean z, boolean z2) {
        AppMethodBeat.i(136792);
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecodeMgr", "doDecodeAudio");
        if (this.dva == null) {
            com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioDecodeMgr", "mPlayer is null!");
            AppMethodBeat.o(136792);
            return false;
        }
        b bVar = this.dvc.get(str);
        if (bVar == null) {
            com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioDecodeMgr", "param for id %s is not exist!", str);
            AppMethodBeat.o(136792);
            return false;
        }
        b bVar2 = this.dvb.get(str);
        if (bVar2 != null) {
            if (bVar2.dvh && !this.dva.dxo.YZ() && !this.dva.dxo.gW(str)) {
                com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecodeMgr", "task is end, but not to play end");
                AppMethodBeat.o(136792);
                return true;
            } else if (bVar2.dvh) {
                com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecodeMgr", "task is end, reset source and decoder to run");
                bVar2.dvh = false;
                bVar2.b(f.a(this.dva, new com.tencent.mm.audio.mix.h.a(bVar), z2));
                i.a(bVar2);
                AppMethodBeat.o(136792);
                return true;
            } else {
                l lVar = bVar2.dvi;
                if (lVar != null && z) {
                    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecodeMgr", "force decode to stop and create new task to run");
                    lVar.stop();
                } else if (lVar != null && lVar.YY() && !lVar.YZ()) {
                    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecodeMgr", "resume decoder to run");
                    lVar.resume();
                    AppMethodBeat.o(136792);
                    return true;
                } else if (lVar != null && lVar.YZ()) {
                    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecodeMgr", "decoder to stop, reset task run");
                    bVar2.dvh = false;
                    bVar2.b(f.a(this.dva, new com.tencent.mm.audio.mix.h.a(bVar), z2));
                    i.a(bVar2);
                    AppMethodBeat.o(136792);
                    return true;
                } else if (lVar != null) {
                    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecodeMgr", "task is run and playing audio");
                    AppMethodBeat.o(136792);
                    return true;
                }
            }
        }
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecodeMgr", "task is not exist, create new task to run");
        l a2 = f.a(this.dva, new com.tencent.mm.audio.mix.h.a(bVar), z2);
        b bVar3 = new b(new k() {
            /* class com.tencent.mm.audio.mix.d.a.AnonymousClass1 */

            @Override // com.tencent.mm.audio.mix.d.k
            public final void a(l lVar) {
                AppMethodBeat.i(136784);
                if (lVar == null) {
                    com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioDecodeMgr", "process decoder is null");
                    AppMethodBeat.o(136784);
                    return;
                }
                b Zk = lVar.Zk();
                lVar.Zd();
                lVar.Za();
                lVar.release();
                synchronized (a.this.dup) {
                    if (Zk != null) {
                        try {
                            if (a.this.dvd.contains(Zk.filePath)) {
                                a.this.dvd.remove(Zk.filePath);
                            }
                        } catch (Throwable th) {
                            AppMethodBeat.o(136784);
                            throw th;
                        }
                    }
                }
                AppMethodBeat.o(136784);
            }

            @Override // com.tencent.mm.audio.mix.d.k
            public final void a(b bVar) {
                AppMethodBeat.i(136785);
                com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecodeMgr", "decode process end");
                i.b(bVar);
                AppMethodBeat.o(136785);
            }
        }, str);
        bVar3.b(a2);
        i.a(bVar3);
        this.dvb.put(str, bVar3);
        AppMethodBeat.o(136792);
        return true;
    }

    public final boolean y(String str, int i2) {
        AppMethodBeat.i(136793);
        if (!z(str, i2)) {
            AppMethodBeat.o(136793);
            return false;
        }
        z(str, i2);
        b bVar = this.dvb.get(str);
        if (bVar == null) {
            com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is not exist");
            AppMethodBeat.o(136793);
            return false;
        } else if (bVar.dvh) {
            com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is execute end!");
            AppMethodBeat.o(136793);
            return false;
        } else if (bVar.YT()) {
            com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is isDetach!");
            AppMethodBeat.o(136793);
            return false;
        } else {
            l lVar = bVar.dvi;
            if (lVar != null) {
                lVar.seek(i2);
            }
            AppMethodBeat.o(136793);
            return true;
        }
    }

    public final boolean z(String str, int i2) {
        AppMethodBeat.i(136794);
        b bVar = this.dvc.get(str);
        if (bVar == null) {
            com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioDecodeMgr", "param for id %s is not exist!", str);
            AppMethodBeat.o(136794);
            return false;
        }
        bVar.dvv = i2;
        AppMethodBeat.o(136794);
        return true;
    }

    public final boolean gN(String str) {
        AppMethodBeat.i(136795);
        b bVar = this.dvb.get(str);
        if (bVar == null) {
            AppMethodBeat.o(136795);
            return true;
        } else if (bVar.dvh) {
            AppMethodBeat.o(136795);
            return true;
        } else if (bVar.YT()) {
            AppMethodBeat.o(136795);
            return true;
        } else {
            AppMethodBeat.o(136795);
            return false;
        }
    }

    public final boolean gO(String str) {
        AppMethodBeat.i(136796);
        b bVar = this.dvb.get(str);
        if (bVar == null || !bVar.dvh || this.dva.dxo.YZ() || this.dva.dxo.gW(str)) {
            AppMethodBeat.o(136796);
            return false;
        }
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecodeMgr", "task is end, but not to play end");
        AppMethodBeat.o(136796);
        return true;
    }

    public final long gP(String str) {
        AppMethodBeat.i(177343);
        b bVar = this.dvb.get(str);
        if (bVar == null) {
            AppMethodBeat.o(177343);
            return -1;
        }
        l lVar = bVar.dvi;
        if (lVar != null) {
            long currentPosition = lVar.getCurrentPosition();
            AppMethodBeat.o(177343);
            return currentPosition;
        }
        AppMethodBeat.o(177343);
        return -1;
    }
}
