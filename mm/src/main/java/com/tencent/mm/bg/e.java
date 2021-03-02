package com.tencent.mm.bg;

import android.os.Looper;
import android.os.MessageQueue;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.app.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.s;

public final class e {
    private static e jlU = null;
    private o.a appForegroundListener = new o.a() {
        /* class com.tencent.mm.bg.e.AnonymousClass1 */

        @Override // com.tencent.mm.app.o
        public final void onAppForeground(String str) {
            AppMethodBeat.i(148390);
            e eVar = e.this;
            Log.d("MicroMsg.SpeexUploadCore", "now pause speex uploader");
            eVar.iVg.pause(true);
            AppMethodBeat.o(148390);
        }

        @Override // com.tencent.mm.app.o
        public final void onAppBackground(String str) {
            AppMethodBeat.i(148391);
            Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
                /* class com.tencent.mm.bg.e.AnonymousClass2 */

                public final boolean queueIdle() {
                    AppMethodBeat.i(148392);
                    if (g.azz().foreground) {
                        Log.w("MicroMsg.SpeexUploadCore", "skiped resume speex uploader, not foreground");
                        AppMethodBeat.o(148392);
                    } else {
                        Log.d("MicroMsg.SpeexUploadCore", "now resume speex uploader");
                        e.this.iVg.pause(false);
                        AppMethodBeat.o(148392);
                    }
                    return false;
                }
            });
            AppMethodBeat.o(148391);
        }
    };
    QueueWorkerThread iVg = new QueueWorkerThread(1, "speex_worker");
    private String jlV;
    private byte[] mLock = new byte[0];
    private i onSceneEndCallback = new i() {
        /* class com.tencent.mm.bg.e.AnonymousClass4 */

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            AppMethodBeat.i(148396);
            if (e.this.jlV == null) {
                AppMethodBeat.o(148396);
                return;
            }
            Log.d("MicroMsg.SpeexUploadCore", "onSceneEnd " + ((a) qVar).filename + " filepath " + e.this.jlV + " errCode " + i3);
            if (((a) qVar).filename.equals(e.this.jlV)) {
                g.azz().b(240, e.this.onSceneEndCallback);
                if (i3 == 0) {
                    d.bfP();
                    d.bfR();
                }
                try {
                    Log.d("MicroMsg.SpeexUploadCore", "delete " + e.this.jlV + " delete " + new com.tencent.mm.vfs.o(e.this.jlV).delete() + " errCode " + i3);
                } catch (Exception e2) {
                    Log.e("MicroMsg.SpeexUploadCore", "exception:%s", Util.stackTraceToString(e2));
                } finally {
                    e.bfX().start();
                    e.this.jlV = null;
                    AppMethodBeat.o(148396);
                }
            } else {
                AppMethodBeat.o(148396);
            }
        }
    };

    private e() {
        AppMethodBeat.i(148397);
        this.appForegroundListener.alive();
        AppMethodBeat.o(148397);
    }

    public static e bfX() {
        AppMethodBeat.i(148398);
        if (jlU == null) {
            jlU = new e();
        }
        e eVar = jlU;
        AppMethodBeat.o(148398);
        return eVar;
    }

    public final void b(QueueWorkerThread.ThreadObject threadObject) {
        AppMethodBeat.i(148399);
        Log.d("MicroMsg.SpeexUploadCore", "pushWork");
        this.iVg.add(threadObject);
        AppMethodBeat.o(148399);
    }

    public final void start() {
        AppMethodBeat.i(148400);
        if (!NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
            AppMethodBeat.o(148400);
            return;
        }
        new MMHandler(Looper.getMainLooper()).postDelayed(new Runnable() {
            /* class com.tencent.mm.bg.e.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(148395);
                Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
                    /* class com.tencent.mm.bg.e.AnonymousClass3.AnonymousClass1 */

                    public final boolean queueIdle() {
                        AppMethodBeat.i(148394);
                        e.this.b(new QueueWorkerThread.ThreadObject() {
                            /* class com.tencent.mm.bg.e.AnonymousClass3.AnonymousClass1.AnonymousClass1 */

                            @Override // com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject
                            public final boolean doInBackground() {
                                return true;
                            }

                            @Override // com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject
                            public final boolean onPostExecute() {
                                AppMethodBeat.i(148393);
                                e.b(e.this);
                                AppMethodBeat.o(148393);
                                return false;
                            }
                        });
                        AppMethodBeat.o(148394);
                        return false;
                    }
                });
                AppMethodBeat.o(148395);
            }
        }, 100);
        AppMethodBeat.o(148400);
    }

    private static com.tencent.mm.vfs.o dy(int i2, int i3) {
        AppMethodBeat.i(148401);
        com.tencent.mm.vfs.o oVar = new com.tencent.mm.vfs.o(b.bfO());
        if (!oVar.exists() || !oVar.isDirectory()) {
            AppMethodBeat.o(148401);
            return null;
        }
        com.tencent.mm.vfs.o[] het = oVar.het();
        int i4 = 0;
        com.tencent.mm.vfs.o oVar2 = null;
        while (het != null && i4 < het.length) {
            oVar2 = het[i4];
            if (oVar2 != null && oVar2.isFile()) {
                Log.d("MicroMsg.SpeexUploadCore", "file " + aa.z(oVar2.mUri));
                String z = aa.z(oVar2.mUri);
                long length = oVar2.length();
                if (oVar2.getName().endsWith(".spx")) {
                    if (length >= ((long) i2) && length <= ((long) i3)) {
                        break;
                    }
                    Log.d("MicroMsg.SpeexUploadCore", "unfit delete %s, minsize: %d, maxSize: %d", z, Integer.valueOf(i2), Integer.valueOf(i3));
                    s.deleteFile(z);
                    oVar2 = null;
                } else {
                    oVar2 = null;
                }
            }
            i4++;
        }
        AppMethodBeat.o(148401);
        return oVar2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00bd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void b(com.tencent.mm.bg.e r9) {
        /*
        // Method dump skipped, instructions count: 457
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.bg.e.b(com.tencent.mm.bg.e):void");
    }
}
