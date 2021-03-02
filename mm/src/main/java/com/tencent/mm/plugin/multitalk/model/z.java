package com.tencent.mm.plugin.multitalk.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.d.d;
import com.tencent.mm.plugin.multitalk.d.e;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.pb.common.b.a.a.a;
import com.tencent.pb.talkroom.sdk.f;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 !2\u00020\u0001:\u0003!\"#B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0012\u001a\u00020\u000eJ\b\u0010\u0013\u001a\u00020\u000eH\u0002J\u0018\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0010J\u0006\u0010\u001e\u001a\u00020\u001bJ\u0006\u0010\u001f\u001a\u00020\u001bJ\u0006\u0010 \u001a\u00020\u001bR\u001a\u0010\u0003\u001a\f\u0012\b\u0012\u00060\u0005R\u00020\u00000\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0018\u00010\fR\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/model/NetworkDataSource;", "Lcom/tencent/mm/plugin/multitalk/model/BaseDataSource;", "()V", "decodeTask", "", "Lcom/tencent/mm/plugin/multitalk/model/NetworkDataSource$DecodeRunnable;", "[Lcom/tencent/mm/plugin/multitalk/model/NetworkDataSource$DecodeRunnable;", "fpsWrapper", "Lcom/tencent/mm/pluginsdk/platformtools/FpsWraper;", "screenMemberId", "", "screenReceiver", "Lcom/tencent/mm/plugin/multitalk/model/NetworkDataSource$ScreenDataDecode;", "screenRunning", "", "screenUserName", "", "videoRunning", "checkCurrentIsReceiver", "hasScreenData", "receiveScreenData", "buf", "", "byteArray", "", "receiveVideoData", "start", "", "startReceiveScreen", "userName", "stop", "stopReceiveScreen", "stopVideo", "Companion", "DecodeRunnable", "ScreenDataDecode", "plugin-multitalk_release"})
public final class z extends c {
    public static final a zOz = new a((byte) 0);
    private final b[] zOs = {new b(true), new b(false)};
    public volatile boolean zOt;
    public volatile boolean zOu;
    private volatile int zOv = -1;
    private volatile String zOw = "";
    private volatile c zOx;
    private final com.tencent.mm.pluginsdk.i.b zOy = new com.tencent.mm.pluginsdk.i.b("multitalk_network");

    static {
        AppMethodBeat.i(239663);
        AppMethodBeat.o(239663);
    }

    public z() {
        AppMethodBeat.i(239662);
        AppMethodBeat.o(239662);
    }

    public static final /* synthetic */ boolean f(z zVar) {
        AppMethodBeat.i(239665);
        boolean eoe = zVar.eoe();
        AppMethodBeat.o(239665);
        return eoe;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/model/NetworkDataSource$Companion;", "", "()V", "SCREEN_BUFFER_SIZE", "", "SLEEP_DURATION", "", "TAG", "", "VIDEO_BUFFER_SIZE", "plugin-multitalk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void start() {
        AppMethodBeat.i(239657);
        if (this.zOt) {
            AppMethodBeat.o(239657);
            return;
        }
        Log.i("NetworkDataSource", "start");
        this.zOt = true;
        b[] bVarArr = this.zOs;
        for (b bVar : bVarArr) {
            synchronized (Boolean.valueOf(bVar.zOB)) {
                try {
                    if (!bVar.zOB) {
                        bVar.zOB = true;
                        new Thread(bVar).start();
                    }
                    x xVar = x.SXb;
                } catch (Throwable th) {
                    AppMethodBeat.o(239657);
                    throw th;
                }
            }
        }
        if (eoe()) {
            aGm(this.zOw);
        }
        AppMethodBeat.o(239657);
    }

    public final void stop() {
        AppMethodBeat.i(239658);
        eof();
        stopVideo();
        AppMethodBeat.o(239658);
    }

    public final void stopVideo() {
        AppMethodBeat.i(239659);
        this.zOt = false;
        if (!this.zOu) {
            this.zLj = null;
        }
        b[] bVarArr = this.zOs;
        for (b bVar : bVarArr) {
            synchronized (Boolean.valueOf(bVar.zOB)) {
                try {
                    bVar.zOB = false;
                    x xVar = x.SXb;
                } catch (Throwable th) {
                    AppMethodBeat.o(239659);
                    throw th;
                }
            }
        }
        AppMethodBeat.o(239659);
    }

    private final boolean eoe() {
        return this.zOv >= 0;
    }

    public final void aGm(String str) {
        AppMethodBeat.i(239660);
        p.h(str, "userName");
        int aGF = e.aGF(str);
        if (aGF == -1) {
            AppMethodBeat.o(239660);
        } else if (eoe() || this.zOu) {
            AppMethodBeat.o(239660);
        } else {
            this.zOu = true;
            this.zOv = aGF;
            ArrayList arrayList = new ArrayList();
            a.aq aqVar = new a.aq();
            aqVar.qrD = aGF;
            arrayList.add(aqVar);
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.order(ByteOrder.LITTLE_ENDIAN).putInt(aGF);
            o eol = ac.eol();
            p.g(eol, "SubCoreMultiTalk.getMultiEngine()");
            eol.emG().setAppCmd(55, allocate.array(), 4);
            o eol2 = ac.eol();
            p.g(eol2, "SubCoreMultiTalk.getMultiEngine()");
            eol2.emG().kc(arrayList);
            this.zOw = str;
            e eVar = e.zZc;
            if (!e.eqe()) {
                com.tencent.mm.plugin.multitalk.d.a aVar = com.tencent.mm.plugin.multitalk.d.a.zYP;
                com.tencent.mm.plugin.multitalk.d.a.epL();
            }
            c cVar = new c();
            new Thread(cVar).start();
            this.zOx = cVar;
            AppMethodBeat.o(239660);
        }
    }

    public final void eof() {
        AppMethodBeat.i(239661);
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(ByteOrder.LITTLE_ENDIAN).putInt(-1);
        o eol = ac.eol();
        p.g(eol, "SubCoreMultiTalk.getMultiEngine()");
        eol.emG().setAppCmd(55, allocate.array(), 4);
        o eol2 = ac.eol();
        p.g(eol2, "SubCoreMultiTalk.getMultiEngine()");
        eol2.emG().kc(new ArrayList());
        this.zOv = -1;
        this.zOu = false;
        if (!this.zOt) {
            this.zLj = null;
        }
        c cVar = this.zOx;
        if (cVar != null) {
            synchronized (Boolean.valueOf(cVar.zOB)) {
                try {
                    cVar.zOB = false;
                    x xVar = x.SXb;
                } catch (Throwable th) {
                    AppMethodBeat.o(239661);
                    throw th;
                }
            }
        }
        this.zOx = null;
        AppMethodBeat.o(239661);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0007R\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0007\"\u0004\b\n\u0010\u000b¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/model/NetworkDataSource$DecodeRunnable;", "Ljava/lang/Runnable;", "isOdd", "", "(Lcom/tencent/mm/plugin/multitalk/model/NetworkDataSource;Z)V", "decodeBuf", "", "()Z", "taskRunning", "getTaskRunning", "setTaskRunning", "(Z)V", "run", "", "plugin-multitalk_release"})
    public final class b implements Runnable {
        private final int[] zOA = new int[Downloads.SPLIT_RANGE_SIZE_WAP];
        volatile boolean zOB;
        private final boolean zOC;

        public b(boolean z) {
            AppMethodBeat.i(239654);
            this.zOC = z;
            AppMethodBeat.o(239654);
        }

        public final void run() {
            boolean z;
            AppMethodBeat.i(239653);
            this.zOB = true;
            while (z.this.zOt && this.zOB) {
                this.zOA[0] = this.zOC ? 0 : 1;
                z.this.zOy.bdU("_total");
                synchronized (Boolean.valueOf(this.zOB)) {
                    try {
                        if (this.zOB) {
                            z = z.a(z.this, this.zOA);
                        } else {
                            z = true;
                        }
                        x xVar = x.SXb;
                    } catch (Throwable th) {
                        AppMethodBeat.o(239653);
                        throw th;
                    }
                }
                if (!z) {
                    z.this.zOy.bdU("_fail");
                    try {
                        Thread.sleep(40);
                    } catch (InterruptedException e2) {
                        z.this.zOt = false;
                    }
                } else {
                    z.this.zOy.bdU("_success");
                }
            }
            this.zOB = false;
            AppMethodBeat.o(239653);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/model/NetworkDataSource$ScreenDataDecode;", "Ljava/lang/Runnable;", "(Lcom/tencent/mm/plugin/multitalk/model/NetworkDataSource;)V", "decodeBuf", "", "decodeByteBuffer", "", "taskRunning", "", "getTaskRunning", "()Z", "setTaskRunning", "(Z)V", "run", "", "plugin-multitalk_release"})
    public final class c implements Runnable {
        private final int[] zOA = new int[3686400];
        volatile boolean zOB;
        private final byte[] zOE = new byte[14745600];

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public c() {
            AppMethodBeat.i(239656);
            AppMethodBeat.o(239656);
        }

        public final void run() {
            boolean z;
            AppMethodBeat.i(239655);
            this.zOB = true;
            while (z.this.zOu && z.f(z.this) && this.zOB) {
                synchronized (Boolean.valueOf(this.zOB)) {
                    try {
                        if (this.zOB) {
                            z = z.a(z.this, this.zOA, this.zOE);
                        } else {
                            z = true;
                        }
                        x xVar = x.SXb;
                    } catch (Throwable th) {
                        AppMethodBeat.o(239655);
                        throw th;
                    }
                }
                if (!z) {
                    try {
                        Thread.sleep(40);
                    } catch (InterruptedException e2) {
                        z.this.zOu = false;
                    }
                }
            }
            this.zOB = false;
            d dVar = d.zZa;
            d.eof();
            ad adVar = z.this.zLj;
            if (adVar != null) {
                adVar.eos();
                AppMethodBeat.o(239655);
                return;
            }
            AppMethodBeat.o(239655);
        }
    }

    public static final /* synthetic */ boolean a(z zVar, int[] iArr) {
        f fVar;
        AppMethodBeat.i(239664);
        ad adVar = zVar.zLj;
        if (adVar != null) {
            long currentTicks = Util.currentTicks();
            o eol = ac.eol();
            p.g(eol, "SubCoreMultiTalk.getMultiEngine()");
            f R = eol.emG().R(iArr);
            if (R != null) {
                if (R.ret > 0 && !TextUtils.isEmpty(R.RHb) && R.RHf > 0 && R.RHg > 0) {
                    fVar = R;
                } else {
                    fVar = null;
                }
                if (fVar != null) {
                    d dVar = d.zZa;
                    d.append(0, Util.ticksToNow(currentTicks));
                    Log.i("NetworkDataSource", "receive video frame");
                    String str = fVar.RHb;
                    p.g(str, "decodeInfo.usrName");
                    int[] iArr2 = fVar.RHd;
                    p.g(iArr2, "decodeInfo.imgBuffer");
                    adVar.a(str, iArr2, fVar.RHf, fVar.RHg, 0, OpenGlRender.FLAG_Angle90);
                    AppMethodBeat.o(239664);
                    return true;
                }
            }
        }
        AppMethodBeat.o(239664);
        return false;
    }

    public static final /* synthetic */ boolean a(z zVar, int[] iArr, byte[] bArr) {
        boolean z;
        AppMethodBeat.i(239666);
        ad adVar = zVar.zLj;
        if (adVar != null) {
            long currentTicks = Util.currentTicks();
            o eol = ac.eol();
            p.g(eol, "SubCoreMultiTalk.getMultiEngine()");
            f a2 = eol.emG().a(bArr, iArr, zVar.zOv);
            if (a2 != null) {
                f fVar = a2.ret == 1 && !TextUtils.isEmpty(a2.RHb) && p.j(a2.RHb, zVar.zOw) ? a2 : null;
                if (fVar != null) {
                    if (fVar.ret == 1 && fVar.RHf == 0 && fVar.RHg < 3) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        d dVar = d.zZa;
                        d.RC(2);
                        Log.i("NetworkDataSource", "receive screen frame using HW decode");
                        byte[] bArr2 = new byte[fVar.RHe];
                        System.arraycopy(bArr, 0, bArr2, 0, fVar.RHe);
                        Log.i("NetworkDataSource", "orien: " + fVar.RHi);
                        String str = fVar.RHb;
                        p.g(str, "decodeInfo.usrName");
                        adVar.a(str, bArr2, fVar.RHg, fVar.RHi);
                        AppMethodBeat.o(239666);
                        return true;
                    }
                    Log.i("NetworkDataSource", "receive screen frame");
                    d dVar2 = d.zZa;
                    d.RC(1);
                    d dVar3 = d.zZa;
                    d.append(1, Util.ticksToNow(currentTicks));
                    String str2 = fVar.RHb;
                    p.g(str2, "decodeInfo.usrName");
                    int[] iArr2 = fVar.RHd;
                    p.g(iArr2, "decodeInfo.imgBuffer");
                    adVar.a(str2, iArr2, fVar.RHf, fVar.RHg, fVar.RHi);
                    AppMethodBeat.o(239666);
                    return true;
                }
            }
        }
        AppMethodBeat.o(239666);
        return false;
    }
}
