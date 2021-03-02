package j.a.a;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class e extends b {
    private static Map<Integer, e> UpR = Collections.synchronizedMap(new HashMap());
    private static Map<String, List<e>> UpS = Collections.synchronizedMap(new HashMap());
    private static SoundPool yRy;
    private final String UpK;
    private String UpO = "speakers";
    private final a UpQ;
    private Integer UpT;
    private Integer UpU;
    private boolean UpV = false;
    private boolean aWP = false;
    private boolean bfW = false;
    private float rate = 1.0f;
    private boolean tN = false;
    private String url;
    private float volume = 1.0f;

    static /* synthetic */ void e(e eVar) {
        AppMethodBeat.i(204548);
        eVar.start();
        AppMethodBeat.o(204548);
    }

    e(a aVar, String str) {
        this.UpQ = aVar;
        this.UpK = str;
    }

    /* access modifiers changed from: package-private */
    @Override // j.a.a.b
    public final String esX() {
        return this.UpK;
    }

    /* access modifiers changed from: package-private */
    @Override // j.a.a.b
    public final void mb(Context context) {
        AppMethodBeat.i(204532);
        if (!this.aWP) {
            start();
        }
        this.bfW = true;
        AppMethodBeat.o(204532);
    }

    /* access modifiers changed from: package-private */
    @Override // j.a.a.b
    public final void stop() {
        AppMethodBeat.i(204533);
        if (this.bfW) {
            yRy.stop(this.UpU.intValue());
            this.bfW = false;
        }
        this.tN = false;
        AppMethodBeat.o(204533);
    }

    /* access modifiers changed from: package-private */
    @Override // j.a.a.b
    public final void release() {
        AppMethodBeat.i(204534);
        stop();
        if (this.UpT == null || this.url == null) {
            AppMethodBeat.o(204534);
            return;
        }
        synchronized (UpS) {
            try {
                List<e> list = UpS.get(this.url);
                if (list != null) {
                    if (list.size() == 1 && list.get(0) == this) {
                        UpS.remove(this.url);
                        yRy.unload(this.UpT.intValue());
                        UpR.remove(this.UpT);
                        this.UpT = null;
                        new StringBuilder("Unloaded soundId ").append(this.UpT);
                    } else {
                        list.remove(this);
                    }
                }
            } finally {
                AppMethodBeat.o(204534);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @Override // j.a.a.b
    public final void pause() {
        AppMethodBeat.i(204535);
        if (this.bfW) {
            yRy.pause(this.UpU.intValue());
            this.bfW = false;
            this.tN = true;
        }
        AppMethodBeat.o(204535);
    }

    /* access modifiers changed from: package-private */
    @Override // j.a.a.b
    public final void a(String str, boolean z, Context context) {
        String absolutePath;
        AppMethodBeat.i(204536);
        if (this.url == null || !this.url.equals(str)) {
            if (this.UpT != null) {
                release();
            }
            synchronized (UpS) {
                try {
                    this.url = str;
                    List<e> list = UpS.get(str);
                    if (list != null) {
                        e eVar = list.get(0);
                        this.UpT = eVar.UpT;
                        this.aWP = eVar.aWP;
                        list.add(this);
                        new StringBuilder("Reusing soundId").append(this.UpT).append(" for ").append(str).append(" is loading=").append(this.aWP).append(" ").append(this);
                        return;
                    }
                    this.aWP = true;
                    long currentTimeMillis = System.currentTimeMillis();
                    SoundPool soundPool = yRy;
                    if (z) {
                        absolutePath = str;
                    } else {
                        absolutePath = bvw(str).getAbsolutePath();
                    }
                    this.UpT = Integer.valueOf(soundPool.load(absolutePath, 1));
                    new StringBuilder("time to call load() for ").append(str).append(": ").append(System.currentTimeMillis() - currentTimeMillis).append(" player=").append(this);
                    UpR.put(this.UpT, this);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(this);
                    UpS.put(str, arrayList);
                    AppMethodBeat.o(204536);
                } finally {
                    AppMethodBeat.o(204536);
                }
            }
        } else {
            AppMethodBeat.o(204536);
        }
    }

    /* access modifiers changed from: package-private */
    @Override // j.a.a.b
    public final void u(double d2) {
        AppMethodBeat.i(204537);
        this.volume = (float) d2;
        if (this.bfW) {
            yRy.setVolume(this.UpU.intValue(), this.volume, this.volume);
        }
        AppMethodBeat.o(204537);
    }

    /* access modifiers changed from: package-private */
    @Override // j.a.a.b
    public final int P(double d2) {
        AppMethodBeat.i(204538);
        this.rate = (float) d2;
        if (this.UpU != null) {
            yRy.setRate(this.UpU.intValue(), this.rate);
            AppMethodBeat.o(204538);
            return 1;
        }
        AppMethodBeat.o(204538);
        return 0;
    }

    /* access modifiers changed from: package-private */
    @Override // j.a.a.b
    public final void a(boolean z, boolean z2, Context context) {
    }

    /* access modifiers changed from: package-private */
    @Override // j.a.a.b
    public final void a(c cVar) {
        boolean z;
        int i2 = 0;
        AppMethodBeat.i(204539);
        if (cVar == c.LOOP) {
            z = true;
        } else {
            z = false;
        }
        this.UpV = z;
        if (this.bfW) {
            SoundPool soundPool = yRy;
            int intValue = this.UpU.intValue();
            if (this.UpV) {
                i2 = -1;
            }
            soundPool.setLoop(intValue, i2);
        }
        AppMethodBeat.o(204539);
    }

    /* access modifiers changed from: package-private */
    @Override // j.a.a.b
    public final int getDuration() {
        AppMethodBeat.i(204540);
        UnsupportedOperationException bvx = bvx("getDuration");
        AppMethodBeat.o(204540);
        throw bvx;
    }

    /* access modifiers changed from: package-private */
    @Override // j.a.a.b
    public final int getCurrentPosition() {
        AppMethodBeat.i(204541);
        UnsupportedOperationException bvx = bvx("getCurrentPosition");
        AppMethodBeat.o(204541);
        throw bvx;
    }

    /* access modifiers changed from: package-private */
    @Override // j.a.a.b
    public final boolean hRs() {
        return false;
    }

    /* access modifiers changed from: package-private */
    @Override // j.a.a.b
    public final void p(String str, Context context) {
        AppMethodBeat.i(204542);
        UnsupportedOperationException bvx = bvx("setPlayingRoute");
        AppMethodBeat.o(204542);
        throw bvx;
    }

    /* access modifiers changed from: package-private */
    @Override // j.a.a.b
    public final void seek(int i2) {
        AppMethodBeat.i(204543);
        UnsupportedOperationException bvx = bvx("seek");
        AppMethodBeat.o(204543);
        throw bvx;
    }

    private void start() {
        AppMethodBeat.i(204544);
        P((double) this.rate);
        if (this.tN) {
            yRy.resume(this.UpU.intValue());
            this.tN = false;
            AppMethodBeat.o(204544);
            return;
        }
        this.UpU = Integer.valueOf(yRy.play(this.UpT.intValue(), this.volume, this.volume, 0, this.UpV ? -1 : 0, 1.0f));
        AppMethodBeat.o(204544);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x004b A[SYNTHETIC, Splitter:B:20:0x004b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.io.File bvw(java.lang.String r5) {
        /*
            r4 = 204545(0x31f01, float:2.86629E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            r2 = 0
            java.net.URI r0 = java.net.URI.create(r5)     // Catch:{ IOException -> 0x0039, all -> 0x005c }
            java.net.URL r0 = r0.toURL()     // Catch:{ IOException -> 0x0039, all -> 0x005c }
            byte[] r0 = g(r0)     // Catch:{ IOException -> 0x0039, all -> 0x005c }
            java.lang.String r1 = "sound"
            java.lang.String r3 = ""
            java.io.File r3 = java.io.File.createTempFile(r1, r3)     // Catch:{ IOException -> 0x0039, all -> 0x005c }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0039, all -> 0x005c }
            r1.<init>(r3)     // Catch:{ IOException -> 0x0039, all -> 0x005c }
            r1.write(r0)     // Catch:{ IOException -> 0x005e }
            r3.deleteOnExit()     // Catch:{ IOException -> 0x005e }
            r1.close()     // Catch:{ IOException -> 0x002f }
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            return r3
        L_0x002f:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            r1.<init>(r0)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            throw r1
        L_0x0039:
            r0 = move-exception
            r1 = r2
        L_0x003b:
            java.lang.RuntimeException r2 = new java.lang.RuntimeException     // Catch:{ all -> 0x0047 }
            r2.<init>(r0)     // Catch:{ all -> 0x0047 }
            r0 = 204545(0x31f01, float:2.86629E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r0)     // Catch:{ all -> 0x0047 }
            throw r2     // Catch:{ all -> 0x0047 }
        L_0x0047:
            r0 = move-exception
            r2 = r1
        L_0x0049:
            if (r2 == 0) goto L_0x004e
            r2.close()     // Catch:{ IOException -> 0x0052 }
        L_0x004e:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            throw r0
        L_0x0052:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            r1.<init>(r0)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            throw r1
        L_0x005c:
            r0 = move-exception
            goto L_0x0049
        L_0x005e:
            r0 = move-exception
            goto L_0x003b
        */
        throw new UnsupportedOperationException("Method not decompiled: j.a.a.e.bvw(java.lang.String):java.io.File");
    }

    private static byte[] g(URL url2) {
        AppMethodBeat.i(204546);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        InputStream inputStream = null;
        try {
            byte[] bArr = new byte[4096];
            InputStream openStream = url2.openStream();
            while (true) {
                int read = openStream.read(bArr);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    try {
                        openStream.close();
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        AppMethodBeat.o(204546);
                        return byteArray;
                    } catch (IOException e2) {
                        RuntimeException runtimeException = new RuntimeException(e2);
                        AppMethodBeat.o(204546);
                        throw runtimeException;
                    }
                }
            }
        } catch (IOException e3) {
            RuntimeException runtimeException2 = new RuntimeException(e3);
            AppMethodBeat.o(204546);
            throw runtimeException2;
        } catch (Throwable th) {
            try {
                inputStream.close();
                AppMethodBeat.o(204546);
                throw th;
            } catch (IOException e4) {
                RuntimeException runtimeException3 = new RuntimeException(e4);
                AppMethodBeat.o(204546);
                throw runtimeException3;
            }
        }
    }

    private static UnsupportedOperationException bvx(String str) {
        AppMethodBeat.i(204547);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("LOW_LATENCY mode does not support: ".concat(String.valueOf(str)));
        AppMethodBeat.o(204547);
        return unsupportedOperationException;
    }

    static {
        SoundPool soundPool;
        AppMethodBeat.i(204549);
        if (Build.VERSION.SDK_INT >= 21) {
            soundPool = new SoundPool.Builder().setAudioAttributes(new AudioAttributes.Builder().setLegacyStreamType(Integer.MIN_VALUE).setUsage(14).build()).setMaxStreams(100).build();
        } else {
            soundPool = new SoundPool(1, 3, 1);
        }
        yRy = soundPool;
        soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            /* class j.a.a.e.AnonymousClass1 */

            public final void onLoadComplete(SoundPool soundPool, int i2, int i3) {
                AppMethodBeat.i(204531);
                e eVar = (e) e.UpR.get(Integer.valueOf(i2));
                if (eVar != null) {
                    e.UpR.remove(eVar.UpT);
                    synchronized (e.UpS) {
                        try {
                            for (e eVar2 : (List) e.UpS.get(eVar.url)) {
                                new StringBuilder("Marking ").append(eVar2).append(" as loaded");
                                eVar2.aWP = false;
                                if (eVar2.bfW) {
                                    new StringBuilder("Delayed start of ").append(eVar2);
                                    e.e(eVar2);
                                }
                            }
                        } finally {
                            AppMethodBeat.o(204531);
                        }
                    }
                    return;
                }
                AppMethodBeat.o(204531);
            }
        });
        AppMethodBeat.o(204549);
    }
}
