package com.tencent.mm.audio.mix.e;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.audio.mix.e.f;
import com.tencent.mm.audio.mix.h.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class a implements f {
    Object dup = new Object();
    public volatile LinkedList<String> dvR = new LinkedList<>();
    volatile ArrayList<String> dvS = new ArrayList<>();
    public f.a dvT;
    public volatile HashMap<String, c> dvb = new HashMap<>();

    public a() {
        AppMethodBeat.i(198113);
        AppMethodBeat.o(198113);
    }

    public final boolean a(b bVar) {
        AppMethodBeat.i(198114);
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Audio.AudioDownloadMgr", "startDownload");
        if (bVar == null) {
            com.tencent.mm.audio.mix.i.b.e("MicroMsg.Audio.AudioDownloadMgr", "param is null");
            AppMethodBeat.o(198114);
            return false;
        } else if (TextUtils.isEmpty(bVar.dvn)) {
            com.tencent.mm.audio.mix.i.b.e("MicroMsg.Audio.AudioDownloadMgr", "srcUrl is null");
            AppMethodBeat.o(198114);
            return false;
        } else if (this.dvS.contains(bVar.dvn)) {
            com.tencent.mm.audio.mix.i.b.e("MicroMsg.Audio.AudioDownloadMgr", "srcUrl:%s is download finish", bVar.dvn);
            AppMethodBeat.o(198114);
            return false;
        } else if (this.dvb.containsKey(bVar.dvn)) {
            com.tencent.mm.audio.mix.i.b.e("MicroMsg.Audio.AudioDownloadMgr", "task is exit!");
            AppMethodBeat.o(198114);
            return true;
        } else {
            com.tencent.mm.audio.mix.i.b.i("MicroMsg.Audio.AudioDownloadMgr", "download src:%s, audioId:%s", bVar.dvn, bVar.dtX);
            c cVar = new c(new b(new e() {
                /* class com.tencent.mm.audio.mix.e.a.AnonymousClass1 */

                @Override // com.tencent.mm.audio.mix.e.e
                public final void c(b bVar) {
                    AppMethodBeat.i(198111);
                    String str = "";
                    synchronized (a.this.dup) {
                        if (bVar != null) {
                            try {
                                a.this.dvb.remove(bVar.dvn);
                                str = bVar.dvn;
                                a.this.dvS.add(bVar.dvn);
                            } catch (Throwable th) {
                                AppMethodBeat.o(198111);
                                throw th;
                            }
                        }
                    }
                    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Audio.AudioDownloadMgr", "download finish, src:%s", str);
                    if (a.this.dvT != null) {
                        a.this.dvT.e(bVar);
                    }
                    AppMethodBeat.o(198111);
                }

                @Override // com.tencent.mm.audio.mix.e.e
                public final void d(b bVar) {
                    AppMethodBeat.i(198112);
                    String str = "";
                    synchronized (a.this.dup) {
                        if (bVar != null) {
                            try {
                                a.this.dvb.remove(bVar.dvn);
                                str = bVar.dvn;
                            } catch (Throwable th) {
                                AppMethodBeat.o(198112);
                                throw th;
                            }
                        }
                    }
                    com.tencent.mm.audio.mix.i.b.e("MicroMsg.Audio.AudioDownloadMgr", "download fail, src:%s", str);
                    AppMethodBeat.o(198112);
                }
            }), bVar.dtX);
            cVar.b(b(bVar));
            d.a(cVar);
            synchronized (this.dup) {
                try {
                    this.dvb.put(bVar.dvn, cVar);
                    this.dvR.add(bVar.dvn);
                } finally {
                    AppMethodBeat.o(198114);
                }
            }
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public c b(b bVar) {
        AppMethodBeat.i(198115);
        com.tencent.mm.audio.mix.h.b bVar2 = new com.tencent.mm.audio.mix.h.b();
        AppMethodBeat.o(198115);
        return bVar2;
    }
}
