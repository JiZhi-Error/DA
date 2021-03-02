package com.tencent.mm.emoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.ac.d;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0012J\u0006\u0010\u0016\u001a\u00020\u0012J\u0006\u0010\u0017\u001a\u00020\u0010J\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u0019J\u000e\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u0019J\u000e\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u0012J\u000e\u0010 \u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u0012J\u000e\u0010!\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\""}, hxF = {"Lcom/tencent/mm/emoji/model/EmojiStorageState;", "", "()V", "KVName", "", "KeyCaptureFull", "KeyCaptureSize", "KeyCustomFull", "KeyCustomSize", "KeyCustomSync", "KeyDesignerSyncTime", "KeySuggestDelay", "KeySync", "KeyWordListUpdateTime", "TAG", "checkSize", "", "getDesignerSyncTime", "", "getKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getSuggestDelay", "getWordListUpdateTime", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "isCaptureFull", "", "isCustomFull", "setCaptureFull", "full", "setCustomFull", "setDesignerSyncTime", "time", "setSuggestDelay", "setWordListUpdateTime", "plugin-emojisdk_release"})
public final class k {
    private static final String TAG = TAG;
    private static final String gXq = gXq;
    public static final k gXr = new k();

    static {
        AppMethodBeat.i(105518);
        AppMethodBeat.o(105518);
    }

    private k() {
    }

    public static MultiProcessMMKV getKV() {
        AppMethodBeat.i(105512);
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV(gXq);
        p.g(mmkv, "MultiProcessMMKV.getMMKV(KVName)");
        AppMethodBeat.o(105512);
        return mmkv;
    }

    public static boolean auQ() {
        AppMethodBeat.i(105513);
        boolean z = getKV().getBoolean("capture_full", false);
        AppMethodBeat.o(105513);
        return z;
    }

    public static void dZ(boolean z) {
        AppMethodBeat.i(105514);
        getKV().putBoolean("custom_full", z);
        if (z && getKV().getInt("normal_custom_size", 0) < n.auY()) {
            Log.w(TAG, "custom state mismatch!");
        }
        AppMethodBeat.o(105514);
    }

    public static void ea(boolean z) {
        AppMethodBeat.i(105515);
        getKV().putBoolean("capture_full", z);
        if (z && getKV().getInt("capture_custom_size", 0) < n.auZ()) {
            Log.w(TAG, "capture state mismatch!");
        }
        AppMethodBeat.o(105515);
    }

    public static int auR() {
        AppMethodBeat.i(199913);
        int i2 = getKV().getInt("word_list_update_time", 0);
        AppMethodBeat.o(199913);
        return i2;
    }

    public static void auS() {
        AppMethodBeat.i(105516);
        d.b("EmojiStorageState_checkSize", a.gXs);
        AppMethodBeat.o(105516);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class a extends q implements kotlin.g.a.a<x> {
        public static final a gXs = new a();

        static {
            AppMethodBeat.i(105509);
            AppMethodBeat.o(105509);
        }

        a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            boolean z = true;
            AppMethodBeat.i(105508);
            bj gCJ = bj.gCJ();
            p.g(gCJ, "EmojiStorageMgr.getInstance()");
            List<String> akw = gCJ.cgN().akw(0);
            j auL = j.auL();
            p.g(auL, "EmojiStorageCache.getInstance()");
            ArrayList<EmojiInfo> auO = auL.auO();
            if (auO != null) {
                for (T t : auO) {
                    p.g(t, LocaleUtil.ITALIAN);
                    if (!akw.contains(t.getMd5())) {
                        akw.add(t.getMd5());
                    }
                }
                int size = akw.size();
                boolean z2 = size >= n.auY();
                k kVar = k.gXr;
                k.getKV().putInt("normal_custom_size", size);
                k kVar2 = k.gXr;
                k.getKV().putBoolean("custom_full", z2);
                bj gCJ2 = bj.gCJ();
                p.g(gCJ2, "EmojiStorageMgr.getInstance()");
                List<String> akw2 = gCJ2.cgN().akw(1);
                ArrayList<EmojiInfo> dU = j.auL().dU(false);
                p.g(dU, "captureList");
                for (T t2 : dU) {
                    p.g(t2, LocaleUtil.ITALIAN);
                    if (!akw2.contains(t2.getMd5())) {
                        akw2.add(t2.getMd5());
                    }
                }
                int size2 = akw2.size();
                if (size2 < n.auZ()) {
                    z = false;
                }
                k kVar3 = k.gXr;
                k.getKV().putInt("capture_custom_size", size2);
                k kVar4 = k.gXr;
                k.getKV().putBoolean("capture_full", z);
                k kVar5 = k.gXr;
                Log.i(k.TAG, "init: normal size is " + size + ' ' + z2 + "; capture size is " + size2 + ' ' + z);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(105508);
            return xVar;
        }
    }
}
