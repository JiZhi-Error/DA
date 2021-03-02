package com.tencent.mm.sandbox.updater;

import android.os.AsyncTask;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sandbox.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public final class c extends com.tencent.mm.sandbox.monitor.c {
    private b.a NEJ;
    private String[] NEQ;
    private a NER = null;
    private boolean NES = false;
    private MMHandler NET = new MMHandler() {
        /* class com.tencent.mm.sandbox.updater.c.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(32670);
            if (1 == message.what && !c.this.jcC) {
                new File(c.this.bhO()).delete();
                if (message.arg1 == 0) {
                    Log.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "patch ok");
                    c.this.NEJ.b(200, 0, (dpc) message.obj);
                } else if (message.arg1 == 3) {
                    c.this.NEJ.b(3, -1, (dpc) message.obj);
                } else if (message.arg1 == 4) {
                    c.this.NEJ.b(4, -1, (dpc) message.obj);
                }
            }
            super.handleMessage(message);
            AppMethodBeat.o(32670);
        }
    };
    private b.a NEU = new b.a() {
        /* class com.tencent.mm.sandbox.updater.c.AnonymousClass3 */

        @Override // com.tencent.mm.sandbox.b.a
        public final void fn(int i2, int i3) {
            AppMethodBeat.i(32672);
            Log.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "progress, total=" + i2 + ", offset=" + i3);
            c.this.NEJ.fn(i2, i3);
            AppMethodBeat.o(32672);
        }

        @Override // com.tencent.mm.sandbox.b.a
        public final void b(int i2, int i3, dpc dpc) {
            AppMethodBeat.i(32673);
            if (i2 != 0) {
                Log.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene error. netRet=".concat(String.valueOf(i2)));
                if (i2 == -2) {
                    new File(c.this.bhO()).delete();
                }
                c.e(c.this);
                c.this.a(c.this.NEJ);
                AppMethodBeat.o(32673);
                return;
            }
            Log.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene success");
            try {
                if (d.bhI(c.this.bhO()) < c.this.NEp) {
                    Log.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene continue;");
                    c.this.a(c.this.NEJ);
                    AppMethodBeat.o(32673);
                } else if (c.this.NES) {
                    if (!c.this.patchMd5.equalsIgnoreCase(d.bhK(c.this.bhO()))) {
                        Log.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "pack md5 check error");
                        new File(c.this.bhO()).delete();
                        c.this.NEJ.b(2, -1, dpc);
                        AppMethodBeat.o(32673);
                        return;
                    }
                    c.a(c.this, dpc);
                    AppMethodBeat.o(32673);
                } else if (!c.this.NEr.equalsIgnoreCase(d.bhK(c.this.bhO()))) {
                    Log.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "update pack check error");
                    new File(c.this.bhO()).delete();
                    c.this.NEJ.b(-1, -1, dpc);
                    AppMethodBeat.o(32673);
                } else {
                    d.bo(com.tencent.mm.sandbox.monitor.c.NEn, c.this.NEr + ".temp", c.this.NEr + ".apk");
                    c.this.NEJ.b(200, 0, dpc);
                    AppMethodBeat.o(32673);
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "error occured during pack processing");
                Log.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e2, "", new Object[0]);
                c.this.NEJ.b(-1, -1, dpc);
                AppMethodBeat.o(32673);
            }
        }

        @Override // com.tencent.mm.sandbox.a
        public final void MC(long j2) {
            AppMethodBeat.i(32674);
            c.this.NEJ.MC(j2);
            AppMethodBeat.o(32674);
        }

        @Override // com.tencent.mm.sandbox.a
        public final void MD(long j2) {
            AppMethodBeat.i(32675);
            c.this.NEJ.MD(j2);
            AppMethodBeat.o(32675);
        }
    };
    private int gVP = 0;
    private boolean jcC = false;
    private String patchMd5;
    private String ynv;

    static /* synthetic */ int e(c cVar) {
        int i2 = cVar.gVP;
        cVar.gVP = i2 + 1;
        return i2;
    }

    public c(int i2, String str, int i3, String[] strArr, boolean z) {
        super(i2, str, i3, z);
        AppMethodBeat.i(32685);
        this.NEQ = strArr;
        AppMethodBeat.o(32685);
    }

    public c(int i2, String str, int i3, String str2, String str3, String str4, boolean z) {
        super(i2, str, i3, z);
        AppMethodBeat.i(32686);
        this.NEQ = new String[]{str2};
        this.NES = true;
        this.patchMd5 = str3;
        this.ynv = str4;
        AppMethodBeat.o(32686);
    }

    @Override // com.tencent.mm.sandbox.b
    public final void a(b.a aVar) {
        AppMethodBeat.i(32687);
        this.NEJ = aVar;
        if (!g.getExternalStorageState().equals("mounted")) {
            Log.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "SDCard not available.");
            aVar.b(-1, -1, null);
            AppMethodBeat.o(32687);
        } else if (this.jcC) {
            Log.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "netscene had been canceled.");
            aVar.b(-1, -1, null);
            AppMethodBeat.o(32687);
        } else if (gvZ() || gwg() >= this.NEQ.length) {
            Log.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "exceed max download url. url count = " + this.NEQ.length);
            if (this.NES) {
                aVar.b(1, -1, null);
                AppMethodBeat.o(32687);
                return;
            }
            aVar.b(-1, -1, null);
            AppMethodBeat.o(32687);
        } else if (!e.yV((long) this.NEp)) {
            Log.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "SDCard full");
            if (this.NES) {
                aVar.b(13, -1, null);
                AppMethodBeat.o(32687);
                return;
            }
            aVar.b(-1, -1, null);
            AppMethodBeat.o(32687);
        } else {
            this.NER = new a(this.NEp, d.bhI(bhO()), this.NEU);
            this.NER.execute(this.NEQ[gwg()]);
            AppMethodBeat.o(32687);
        }
    }

    @Override // com.tencent.mm.sandbox.monitor.c
    public final String bhO() {
        AppMethodBeat.i(32688);
        if (this.NES) {
            String str = NEn + this.patchMd5 + ".temp";
            AppMethodBeat.o(32688);
            return str;
        }
        String bhO = super.bhO();
        AppMethodBeat.o(32688);
        return bhO;
    }

    @Override // com.tencent.mm.sandbox.monitor.c
    public final String gvY() {
        AppMethodBeat.i(32689);
        if (this.NES) {
            String str = NEn + this.ynv + ".apk";
            AppMethodBeat.o(32689);
            return str;
        }
        String str2 = NEn + this.NEr + ".apk";
        AppMethodBeat.o(32689);
        return str2;
    }

    @Override // com.tencent.mm.sandbox.b
    public final void cancel() {
        AppMethodBeat.i(32690);
        Log.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "cancel netscene");
        this.jcC = true;
        if (this.NER != null && !this.NER.isCancelled()) {
            this.NER.cancel(true);
        }
        AppMethodBeat.o(32690);
    }

    private int gwg() {
        AppMethodBeat.i(32691);
        Log.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "requestCount=" + this.gVP + ", curLinkIdx = " + (this.gVP / 5));
        int i2 = this.gVP / 5;
        AppMethodBeat.o(32691);
        return i2;
    }

    /* access modifiers changed from: package-private */
    public class a extends AsyncTask<String, Integer, Integer> {
        private OutputStream GVn = new OutputStream() {
            /* class com.tencent.mm.sandbox.updater.c.a.AnonymousClass1 */
            private ByteArrayOutputStream NFb = new ByteArrayOutputStream();
            private MMHandler handler = new MMHandler(Looper.getMainLooper());

            {
                AppMethodBeat.i(32677);
                AppMethodBeat.o(32677);
            }

            @Override // java.io.OutputStream
            public final void write(byte[] bArr, int i2, int i3) {
                AppMethodBeat.i(32678);
                this.NFb.write(bArr, i2, i3);
                if (this.NFb.size() >= 131072 || a.this.cng + this.NFb.size() >= a.this.size) {
                    final int size = this.NFb.size();
                    int e2 = d.e(c.this.bhO(), this.NFb.toByteArray(), size);
                    this.NFb.reset();
                    if (e2 != 0) {
                        IOException iOException = new IOException("appendToFile failed :".concat(String.valueOf(e2)));
                        AppMethodBeat.o(32678);
                        throw iOException;
                    }
                    a.this.cng += size;
                    this.handler.post(new Runnable() {
                        /* class com.tencent.mm.sandbox.updater.c.a.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(32676);
                            if (a.this.cng <= a.this.size) {
                                a.this.NEJ.fn(a.this.size, a.this.cng);
                            }
                            a.this.NEJ.MD((long) size);
                            AppMethodBeat.o(32676);
                        }
                    });
                    if (c.this.jcC) {
                        IOException iOException2 = new IOException("manual force cancel!");
                        AppMethodBeat.o(32678);
                        throw iOException2;
                    }
                    AppMethodBeat.o(32678);
                    return;
                }
                AppMethodBeat.o(32678);
            }

            @Override // java.io.OutputStream
            public final void write(int i2) {
                AppMethodBeat.i(32679);
                IOException iOException = new IOException("unexpected operation");
                AppMethodBeat.o(32679);
                throw iOException;
            }
        };
        private b.a NEJ;
        private HttpGet NEY = null;
        private HttpResponse NEZ = null;
        private HttpEntity NFa = null;
        private HttpClient client = null;
        private int cng;
        private int size;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public final /* synthetic */ Integer doInBackground(String[] strArr) {
            AppMethodBeat.i(32684);
            Integer W = W(strArr);
            AppMethodBeat.o(32684);
            return W;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public final /* synthetic */ void onPostExecute(Integer num) {
            AppMethodBeat.i(32683);
            this.NEJ.b(num.intValue(), 0, null);
            AppMethodBeat.o(32683);
        }

        public a(int i2, int i3, b.a aVar) {
            AppMethodBeat.i(32680);
            this.size = i2;
            this.cng = i3;
            this.NEJ = aVar;
            AppMethodBeat.o(32680);
        }

        /* JADX INFO: finally extract failed */
        private Integer W(String... strArr) {
            AppMethodBeat.i(32681);
            String str = strArr[0];
            if (str == null || str.length() == 0) {
                AppMethodBeat.o(32681);
                return -1;
            }
            Log.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "current download url=" + str + ", range=" + this.cng);
            this.client = new DefaultHttpClient();
            this.client.getParams().setIntParameter("http.connection.timeout", 15000);
            this.NEY = new HttpGet(str);
            this.NEY.addHeader("RANGE", "bytes=" + this.cng + "-" + (this.size - this.cng > 1048576 ? Integer.valueOf((this.cng + 1048576) - 1) : ""));
            try {
                this.NEJ.MC(50);
                this.NEZ = this.client.execute(this.NEY);
                int statusCode = this.NEZ.getStatusLine().getStatusCode();
                if (statusCode != 200 && statusCode != 206) {
                    Log.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "HttpClient return code:".concat(String.valueOf(statusCode)));
                    if (statusCode == 416) {
                        if (this.NEY != null) {
                            this.NEY.abort();
                        }
                        if (this.NFa != null) {
                            try {
                                this.NFa.consumeContent();
                            } catch (IOException e2) {
                                Log.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e2, "", new Object[0]);
                            }
                        }
                        if (this.client != null) {
                            this.client.getConnectionManager().shutdown();
                        }
                        AppMethodBeat.o(32681);
                        return -2;
                    }
                    if (this.NEY != null) {
                        this.NEY.abort();
                    }
                    if (this.NFa != null) {
                        try {
                            this.NFa.consumeContent();
                        } catch (IOException e3) {
                            Log.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e3, "", new Object[0]);
                        }
                    }
                    if (this.client != null) {
                        this.client.getConnectionManager().shutdown();
                    }
                    AppMethodBeat.o(32681);
                    return -1;
                } else if (!c.this.NES || !ac.jOr || Math.random() <= 0.2d) {
                    this.NEZ.getHeaders("Content-Length");
                    if (this.cng > this.size) {
                        Log.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "range out of size");
                        if (this.NEY != null) {
                            this.NEY.abort();
                        }
                        if (this.NFa != null) {
                            try {
                                this.NFa.consumeContent();
                            } catch (IOException e4) {
                                Log.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e4, "", new Object[0]);
                            }
                        }
                        if (this.client != null) {
                            this.client.getConnectionManager().shutdown();
                        }
                        AppMethodBeat.o(32681);
                        return -2;
                    }
                    this.NFa = this.NEZ.getEntity();
                    this.NFa.writeTo(this.GVn);
                    this.NFa.consumeContent();
                    if (this.NEY != null) {
                        this.NEY.abort();
                    }
                    if (this.NFa != null) {
                        try {
                            this.NFa.consumeContent();
                        } catch (IOException e5) {
                            Log.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e5, "", new Object[0]);
                        }
                    }
                    if (this.client != null) {
                        this.client.getConnectionManager().shutdown();
                    }
                    AppMethodBeat.o(32681);
                    return 0;
                } else {
                    Log.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "simulateNetworkFault");
                    if (this.NEY != null) {
                        this.NEY.abort();
                    }
                    if (this.NFa != null) {
                        try {
                            this.NFa.consumeContent();
                        } catch (IOException e6) {
                            Log.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e6, "", new Object[0]);
                        }
                    }
                    if (this.client != null) {
                        this.client.getConnectionManager().shutdown();
                    }
                    AppMethodBeat.o(32681);
                    return -1;
                }
            } catch (Exception e7) {
                Log.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e7, "", new Object[0]);
                Log.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e7, "exception current in download pack", new Object[0]);
                if (this.NEY != null) {
                    this.NEY.abort();
                }
                if (this.NFa != null) {
                    try {
                        this.NFa.consumeContent();
                    } catch (IOException e8) {
                        Log.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e8, "", new Object[0]);
                    }
                }
                if (this.client != null) {
                    this.client.getConnectionManager().shutdown();
                }
                AppMethodBeat.o(32681);
                return -1;
            } catch (Throwable th) {
                if (this.NEY != null) {
                    this.NEY.abort();
                }
                if (this.NFa != null) {
                    try {
                        this.NFa.consumeContent();
                    } catch (IOException e9) {
                        Log.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e9, "", new Object[0]);
                    }
                }
                if (this.client != null) {
                    this.client.getConnectionManager().shutdown();
                }
                AppMethodBeat.o(32681);
                throw th;
            }
        }

        /* access modifiers changed from: protected */
        public final void onCancelled() {
            AppMethodBeat.i(32682);
            Log.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "AsyncTask had been canceled.");
            if (this.NEY != null) {
                this.NEY.abort();
            }
            if (this.NFa != null) {
                try {
                    this.NFa.consumeContent();
                } catch (IOException e2) {
                    Log.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e2, "", new Object[0]);
                }
            }
            if (this.client != null) {
                Log.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "connection shutdown.");
                this.client.getConnectionManager().shutdown();
            }
            AppMethodBeat.o(32682);
        }
    }

    static /* synthetic */ void a(c cVar, final dpc dpc) {
        AppMethodBeat.i(32692);
        try {
            Log.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "in genNewAPKInNewThread()");
            ThreadPool.post(new Runnable() {
                /* class com.tencent.mm.sandbox.updater.c.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(32671);
                    Log.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "updateByPatch start");
                    Message obtain = Message.obtain();
                    obtain.what = 1;
                    obtain.obj = dpc;
                    Long valueOf = Long.valueOf(System.currentTimeMillis());
                    int h2 = j.h(MMApplicationContext.getContext(), c.this.bhO(), c.this.gvY(), c.this.ynv);
                    Log.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "gen new apk finish, time cost = " + (System.currentTimeMillis() - valueOf.longValue()));
                    if (h2 == 0) {
                        Log.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "updateByPatch ok");
                        obtain.arg1 = 0;
                        c.this.NET.sendMessage(obtain);
                        AppMethodBeat.o(32671);
                        return;
                    }
                    Log.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "updateByPatch error in genNewAPKInNewThread()");
                    File file = new File(c.this.gvY());
                    if (file.exists()) {
                        file.delete();
                    }
                    if (h2 == -1) {
                        Log.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "RET_GEN_APK_ERR");
                        obtain.arg1 = 3;
                        c.this.NET.sendMessage(obtain);
                        AppMethodBeat.o(32671);
                    } else if (h2 == -2) {
                        Log.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "RET_APK_MD5_ERR");
                        obtain.arg1 = 4;
                        c.this.NET.sendMessage(obtain);
                        AppMethodBeat.o(32671);
                    } else {
                        AppMethodBeat.o(32671);
                    }
                }
            }, "NetSceneGetUpdatePackFromCDN_genApk");
            AppMethodBeat.o(32692);
        } catch (Exception e2) {
            Log.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "exception in genNewAPKInNewThread()");
            Log.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e2, "", new Object[0]);
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = 3;
            obtain.obj = dpc;
            cVar.NET.sendMessage(obtain);
            AppMethodBeat.o(32692);
        }
    }
}
