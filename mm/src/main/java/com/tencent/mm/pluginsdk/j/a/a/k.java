package com.tencent.mm.pluginsdk.j.a.a;

import com.tencent.f.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bq;
import com.tencent.mm.pluginsdk.j.a.c.f;
import com.tencent.mm.pluginsdk.j.a.c.q;
import com.tencent.mm.pluginsdk.j.a.c.s;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;

/* access modifiers changed from: package-private */
public final class k extends f<a> {
    private final b JZy = new f.a("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", 0, Integer.MAX_VALUE, new SynchronousQueue());

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.pluginsdk.j.a.c.f$b] */
    @Override // com.tencent.mm.pluginsdk.j.a.c.f
    public final /* synthetic */ f.d a(a aVar) {
        AppMethodBeat.i(151993);
        f.d b2 = b(aVar);
        AppMethodBeat.o(151993);
        return b2;
    }

    k() {
        AppMethodBeat.i(151989);
        AppMethodBeat.o(151989);
    }

    static void g(s sVar) {
        AppMethodBeat.i(151990);
        new a(a.a(sVar)).run();
        AppMethodBeat.o(151990);
    }

    @Override // com.tencent.mm.pluginsdk.j.a.c.f
    public final b gnM() {
        return this.JZy;
    }

    private static f.d b(a aVar) {
        AppMethodBeat.i(151992);
        a aVar2 = new a(aVar);
        AppMethodBeat.o(151992);
        return aVar2;
    }

    /* access modifiers changed from: package-private */
    public static final class a extends f.d<a> {
        protected a(a aVar) {
            super(aVar);
        }

        @Override // com.tencent.mm.pluginsdk.j.a.c.f.d
        public final void run() {
            l lVar;
            AppMethodBeat.i(151988);
            Log.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptTask", "%s: decryptTask, entered", ((a) bwt()).JYs);
            a aVar = (a) bwt();
            int i2 = aVar.dEO;
            int i3 = aVar.subType;
            int i4 = aVar.dEP;
            try {
                a aVar2 = (a) bwt();
                l lVar2 = new l(aVar2.dEO, aVar2.subType, aVar2.filePath, aVar2.JYt, aVar2.JYu, aVar2.JYv, aVar2.JYw, aVar2.JYy, aVar2.dEQ, aVar2.JYx, aVar2.dER, aVar2.JYz, aVar2.IBJ, aVar2.url, aVar2.JYA, aVar2.JYB, aVar2.dEP);
                if (lVar2.JYZ) {
                    Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), do fileDecompress", lVar2.JYs);
                    lVar2.JZB = lVar2.filePath + ".decompressed";
                    lVar2.state = 32;
                    if (lVar2.gnP() != null) {
                        lVar2.state = 16;
                        Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), file already valid", lVar2.JYs);
                    }
                    lVar = lVar2;
                } else if (lVar2.JZa) {
                    Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), do fileDecrypt", lVar2.JYs);
                    lVar2.JZB = lVar2.filePath + ".decrypted";
                    lVar2.state = 32;
                    if (lVar2.gnP() != null) {
                        lVar2.state = 16;
                        Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), file already valid", lVar2.JYs);
                    }
                    lVar = lVar2;
                } else {
                    Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), just check sum", lVar2.JYs);
                    lVar2.JZB = lVar2.filePath;
                    lVar2.state = 32;
                    if (lVar2.gnP() != null) {
                        lVar2.state = 16;
                        Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), file already valid", lVar2.JYs);
                    }
                    lVar = lVar2;
                }
                Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: verify(), file_state " + lVar.gnR(), lVar.JYs);
                if (16 != lVar.state) {
                    if (lVar.JZa) {
                        lVar.JZB = lVar.filePath;
                        lVar.xli = lVar.filePath + ".decrypted";
                        lVar.state = 1;
                    } else if (lVar.JYZ) {
                        lVar.JZB = lVar.filePath;
                        lVar.xli = lVar.filePath + ".decompressed";
                        lVar.state = 2;
                    } else {
                        lVar.JZB = lVar.filePath;
                        lVar.state = 4;
                    }
                }
                String gnP = lVar.gnN().gnO().gnP();
                if (!Util.isNullOrNil(gnP)) {
                    b.gnC().a(i2, i3, gnP, i4, ((a) bwt()).dER);
                    if (Thread.interrupted()) {
                        Log.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptTask", "%s: decrypting and interrupted", ((a) bwt()).JYs);
                        com.tencent.mm.pluginsdk.j.a.d.a.bej(((a) bwt()).filePath);
                        com.tencent.mm.pluginsdk.j.a.d.a.bej(((a) bwt()).filePath + ".decrypted");
                        com.tencent.mm.pluginsdk.j.a.d.a.bej(((a) bwt()).filePath + ".decompressed");
                    }
                    AppMethodBeat.o(151988);
                    return;
                }
                com.tencent.mm.pluginsdk.j.a.d.a.bej(((a) bwt()).filePath + ".decrypted");
                com.tencent.mm.pluginsdk.j.a.d.a.bej(((a) bwt()).filePath + ".decompressed");
                if (Thread.interrupted()) {
                    Log.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptTask", "%s: decrypting and interrupted", ((a) bwt()).JYs);
                    com.tencent.mm.pluginsdk.j.a.d.a.bej(((a) bwt()).filePath);
                    com.tencent.mm.pluginsdk.j.a.d.a.bej(((a) bwt()).filePath + ".decrypted");
                    com.tencent.mm.pluginsdk.j.a.d.a.bej(((a) bwt()).filePath + ".decompressed");
                }
                final a aVar3 = (a) bwt();
                q.a.Kan.handler.post(new Runnable() {
                    /* class com.tencent.mm.pluginsdk.j.a.a.k.a.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(151987);
                        bq bqVar = new bq();
                        bqVar.dES.dEO = aVar3.dEO;
                        bqVar.dES.subType = aVar3.subType;
                        bqVar.dES.dEU = aVar3.JYy;
                        bqVar.dES.dDe = 1;
                        bqVar.dES.dET = false;
                        EventCenter.instance.publish(bqVar);
                        AppMethodBeat.o(151987);
                    }
                });
                AppMethodBeat.o(151988);
            } catch (Throwable th) {
                if (Thread.interrupted()) {
                    Log.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptTask", "%s: decrypting and interrupted", ((a) bwt()).JYs);
                    com.tencent.mm.pluginsdk.j.a.d.a.bej(((a) bwt()).filePath);
                    com.tencent.mm.pluginsdk.j.a.d.a.bej(((a) bwt()).filePath + ".decrypted");
                    com.tencent.mm.pluginsdk.j.a.d.a.bej(((a) bwt()).filePath + ".decompressed");
                }
                AppMethodBeat.o(151988);
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(a aVar) {
        boolean z;
        AppMethodBeat.i(151991);
        if (bed(aVar.JYs)) {
            Log.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "URLKey(%s) is already decrypting, skip repeated task", aVar.JYs);
            AppMethodBeat.o(151991);
            return;
        }
        if ((!aVar.JYt || aVar.dEP != aVar.JYw || aVar.JYw < 0) && (aVar.JYt || !aVar.JYu)) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            AppMethodBeat.o(151991);
            return;
        }
        Log.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "request#URLKey(%s) posted to decryptWorker", aVar.JYs);
        try {
            super.b((f.b) aVar);
            AppMethodBeat.o(151991);
        } catch (RejectedExecutionException e2) {
            Log.e("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "submitRequest(%s) get rejected[%s]", aVar.JYs, e2);
            Zb(aVar.JYs);
            b(aVar).run();
            AppMethodBeat.o(151991);
        }
    }
}
