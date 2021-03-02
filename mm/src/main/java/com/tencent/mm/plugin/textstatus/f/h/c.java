package com.tencent.mm.plugin.textstatus.f.h;

import android.os.Looper;
import android.os.Message;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.f.f.d;
import com.tencent.mm.plugin.textstatus.g.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0006\u0010\t\u001a\u00020\bJ\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000bJ\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u0013\u001a\u00020\bJ\b\u0010\u0014\u001a\u00020\bH\u0002J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/model/upload/UploadManager;", "", "()V", "TAG", "", "retryHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "clearUploadTask", "", "doCheck", "getLastUploadTask", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusPostInfo;", "getMMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getPostErrMsg", "makeCdnFail", "postInfo", "makeCgiFail", "errMsg", "reCommitByUser", "retry", "saveUploadTask", "plugin-textstatus_release"})
public final class c {
    private static final MMHandler FZW = new C1824c(Looper.getMainLooper());
    public static final c FZX = new c();

    static {
        AppMethodBeat.i(216321);
        AppMethodBeat.o(216321);
    }

    private c() {
    }

    public static final /* synthetic */ void fwg() {
        AppMethodBeat.i(216322);
        dYH();
        AppMethodBeat.o(216322);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/textstatus/model/upload/UploadManager$retryHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-textstatus_release"})
    /* renamed from: com.tencent.mm.plugin.textstatus.f.h.c$c  reason: collision with other inner class name */
    public static final class C1824c extends MMHandler {
        C1824c(Looper looper) {
            super(looper);
        }

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(216312);
            p.h(message, "msg");
            Log.i("MicroMsg.TxtStatus.UploadManager", "retryHandler");
            c cVar = c.FZX;
            v fwe = c.fwe();
            if (fwe == null) {
                AppMethodBeat.o(216312);
            } else if (!Util.isNullOrNil(fwe.errMsg)) {
                Log.w("MicroMsg.TxtStatus.UploadManager", "business fial " + fwe.errMsg);
                AppMethodBeat.o(216312);
            } else {
                if (fwe.Gbb) {
                    if (fwe.GaZ > 3) {
                        f fVar = f.FXJ;
                        f.c(Long.valueOf(fwe.Gba), 5);
                        AppMethodBeat.o(216312);
                        return;
                    }
                } else if (fwe.GaY > 5) {
                    f fVar2 = f.FXJ;
                    f.c(Long.valueOf(fwe.Gba), 5);
                    AppMethodBeat.o(216312);
                    return;
                }
                if (((long) (cl.aWB() - fwe.GaU.Gaz)) > 1800) {
                    Log.w("MicroMsg.TxtStatus.UploadManager", "exceed 30min to fial");
                    f fVar3 = f.FXJ;
                    f.c(Long.valueOf(fwe.Gba), 5);
                    AppMethodBeat.o(216312);
                    return;
                }
                d dVar = d.Gaa;
                d.b(fwe);
                AppMethodBeat.o(216312);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class a implements Runnable {
        public static final a FZY = new a();

        static {
            AppMethodBeat.i(216309);
            AppMethodBeat.o(216309);
        }

        a() {
        }

        public final void run() {
            AppMethodBeat.i(216308);
            c cVar = c.FZX;
            v fwe = c.fwe();
            if (fwe != null) {
                f fVar = f.FXJ;
                d fvM = f.fvM();
                String ceA = com.tencent.mm.plugin.auth.a.a.ceA();
                p.g(ceA, "Account.username()");
                com.tencent.mm.plugin.textstatus.f.f.a aTl = fvM.aTl(ceA);
                if (aTl == null || aTl.field_CreateTime <= fwe.GaU.Gaz) {
                    Log.i("MicroMsg.TxtStatus.UploadManager", "trigger upload last post");
                    c cVar2 = c.FZX;
                    c.fwg();
                    AppMethodBeat.o(216308);
                    return;
                }
                Log.w("MicroMsg.TxtStatus.UploadManager", "doCheck, last item is new.(cur:" + aTl.field_CreateTime + ", new:" + fwe.GaU.Gaz + ')');
                com.tencent.mm.plugin.textstatus.k.a aVar = com.tencent.mm.plugin.textstatus.k.a.VeA;
                com.tencent.mm.plugin.textstatus.k.a.c(fwe.VdX, 6L);
                c cVar3 = c.FZX;
                c.fwf();
                AppMethodBeat.o(216308);
                return;
            }
            AppMethodBeat.o(216308);
        }
    }

    public static void cjR() {
        AppMethodBeat.i(216313);
        h.RTc.aX(a.FZY);
        AppMethodBeat.o(216313);
    }

    public static void fwc() {
        AppMethodBeat.i(216314);
        Log.i("MicroMsg.TxtStatus.UploadManager", "click to reCommit");
        h.RTc.aX(b.FZZ);
        AppMethodBeat.o(216314);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        public static final b FZZ = new b();

        static {
            AppMethodBeat.i(216311);
            AppMethodBeat.o(216311);
        }

        b() {
        }

        public final void run() {
            AppMethodBeat.i(216310);
            c cVar = c.FZX;
            v fwe = c.fwe();
            if (fwe != null) {
                f fVar = f.FXJ;
                d fvM = f.fvM();
                String ceA = com.tencent.mm.plugin.auth.a.a.ceA();
                p.g(ceA, "Account.username()");
                com.tencent.mm.plugin.textstatus.f.f.a aTl = fvM.aTl(ceA);
                if (aTl == null || aTl.field_CreateTime <= fwe.GaU.Gaz) {
                    Log.i("MicroMsg.TxtStatus.UploadManager", "reCommit last post");
                    if (!fwe.Gbb) {
                        fwe.GaY = 0;
                    }
                    fwe.GaZ = 0;
                    fwe.errMsg = "";
                    fwe.GaU.Gaz = cl.aWB();
                    c cVar2 = c.FZX;
                    c.a(fwe);
                    f fVar2 = f.FXJ;
                    f.c(Long.valueOf(fwe.Gba), 3);
                    c cVar3 = c.FZX;
                    c.fwg();
                    AppMethodBeat.o(216310);
                    return;
                }
                Log.w("MicroMsg.TxtStatus.UploadManager", "reCommit, last item is new.(cur:" + aTl.field_CreateTime + ", new:" + fwe.GaU.Gaz + ')');
                com.tencent.mm.plugin.textstatus.k.a aVar = com.tencent.mm.plugin.textstatus.k.a.VeA;
                com.tencent.mm.plugin.textstatus.k.a.c(fwe.VdX, 6L);
                c cVar4 = c.FZX;
                c.fwf();
                AppMethodBeat.o(216310);
                return;
            }
            AppMethodBeat.o(216310);
        }
    }

    static void dYH() {
        AppMethodBeat.i(216316);
        FZW.sendEmptyMessage(0);
        AppMethodBeat.o(216316);
    }

    private static MultiProcessMMKV VQ() {
        AppMethodBeat.i(216317);
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("text_status_upload" + com.tencent.mm.kernel.a.azs());
        AppMethodBeat.o(216317);
        return mmkv;
    }

    public static void a(v vVar) {
        AppMethodBeat.i(216318);
        p.h(vVar, "postInfo");
        MultiProcessMMKV VQ = VQ();
        Log.i("MicroMsg.TxtStatus.UploadManager", "saveUploadTask result:" + (VQ != null ? Boolean.valueOf(VQ.encode("upload_cache", vVar.toByteArray())) : null) + " rowId:" + vVar.Gba + " cdnSuccess:" + vVar.Gbb + " cdnRetryNum:" + vVar.GaY + " cgiRetryNum:" + vVar.GaZ);
        AppMethodBeat.o(216318);
    }

    public static v fwe() {
        byte[] bArr;
        AppMethodBeat.i(216319);
        MultiProcessMMKV VQ = VQ();
        if (VQ != null) {
            bArr = VQ.decodeBytes("upload_cache");
        } else {
            bArr = null;
        }
        if (bArr == null) {
            AppMethodBeat.o(216319);
            return null;
        }
        v vVar = new v();
        vVar.parseFrom(bArr);
        AppMethodBeat.o(216319);
        return vVar;
    }

    public static void fwf() {
        AppMethodBeat.i(216320);
        MultiProcessMMKV VQ = VQ();
        if (VQ != null) {
            VQ.clearAll();
            AppMethodBeat.o(216320);
            return;
        }
        AppMethodBeat.o(216320);
    }
}
