package com.tencent.mm.aj;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.y;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.avatar.a;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public class p implements bd {
    private static HashMap<Integer, h.b> baseDBFactories;
    private j iLp;
    private e iLq;
    private d iLr;
    private h iLs;
    private MTimerHandler iLt = new MTimerHandler(g.aAk().getLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
        /* class com.tencent.mm.aj.p.AnonymousClass3 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(150318);
            if (!g.aAf().azp() || p.aYn() == null) {
                Log.w("MicroMsg.SubCoreAvatar", "upAssetsHandler onTimerExpired acc:%b astg:%s ", Boolean.valueOf(g.aAf().azp()), p.aYn());
                AppMethodBeat.o(150318);
            } else {
                if (((Boolean) g.aAh().azQ().get(90113, Boolean.FALSE)).booleanValue()) {
                    p.aYF();
                    p.aYE();
                }
                g.aAh().azQ().set(90113, Boolean.FALSE);
                AppMethodBeat.o(150318);
            }
            return false;
        }

        public final String toString() {
            AppMethodBeat.i(150319);
            String str = super.toString() + "|upAssetsHandler";
            AppMethodBeat.o(150319);
            return str;
        }
    }, false);

    public static p aYA() {
        AppMethodBeat.i(150320);
        p pVar = (p) y.at(p.class);
        AppMethodBeat.o(150320);
        return pVar;
    }

    public p() {
        AppMethodBeat.i(150321);
        AppMethodBeat.o(150321);
    }

    public static j aYB() {
        AppMethodBeat.i(150322);
        g.aAf().azk();
        if (aYA().iLp == null) {
            aYA().iLp = new j(g.aAh().hqK);
        }
        j jVar = aYA().iLp;
        AppMethodBeat.o(150322);
        return jVar;
    }

    public static e aYn() {
        AppMethodBeat.i(150323);
        g.aAf().azk();
        if (aYA().iLq == null) {
            aYA().iLq = new e();
        }
        e eVar = aYA().iLq;
        AppMethodBeat.o(150323);
        return eVar;
    }

    public static h aYC() {
        AppMethodBeat.i(150324);
        g.aAf().azk();
        if (aYA().iLs == null) {
            aYA().iLs = new h(g.aAh().hqK);
        }
        h hVar = aYA().iLs;
        AppMethodBeat.o(150324);
        return hVar;
    }

    public static d aYD() {
        AppMethodBeat.i(150325);
        g.aAf().azk();
        if (aYA().iLr == null) {
            aYA().iLr = new d();
        }
        d dVar = aYA().iLr;
        AppMethodBeat.o(150325);
        return dVar;
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
        AppMethodBeat.i(150326);
        this.iLt.stopTimer();
        if (aYA().iLq != null) {
            e.reset();
        }
        d dVar = aYA().iLr;
        if (dVar != null) {
            g.azz().b(123, dVar);
        }
        j jVar = aYA().iLp;
        if (jVar != null) {
            jVar.iLa.clear();
        }
        b.V("//avatar");
        AppMethodBeat.o(150326);
    }

    @Override // com.tencent.mm.model.bd
    public void clearPluginData(int i2) {
    }

    static {
        AppMethodBeat.i(150331);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        baseDBFactories = hashMap;
        hashMap.put(Integer.valueOf("IMG_FLAG_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.aj.p.AnonymousClass1 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return j.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("HDHEADIMGINFO_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.aj.p.AnonymousClass2 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return h.SQL_CREATE;
            }
        });
        AppMethodBeat.o(150331);
    }

    @Override // com.tencent.mm.model.bd
    public HashMap<Integer, h.b> getBaseDBFactories() {
        return baseDBFactories;
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountPostReset(boolean z) {
        AppMethodBeat.i(150327);
        if (z) {
            Log.d("MicroMsg.SubCoreAvatar", "update all plugin avatars");
            g.aAh().azQ().set(90113, Boolean.TRUE);
        }
        this.iLt.startTimer(10000);
        b.a(new a(), "//avatar");
        AppMethodBeat.o(150327);
    }

    static Context getContext() {
        AppMethodBeat.i(150328);
        Context context = MMApplicationContext.getContext();
        AppMethodBeat.o(150328);
        return context;
    }

    @Override // com.tencent.mm.model.bd
    public void onSdcardMount(boolean z) {
    }

    public static boolean aYE() {
        AppMethodBeat.i(150329);
        if (Util.nullAs((Boolean) g.aAh().azQ().get(59, (Object) null), false)) {
            AppMethodBeat.o(150329);
            return true;
        }
        String aTY = z.aTY();
        if (Util.isNullOrNil(aTY)) {
            AppMethodBeat.o(150329);
            return false;
        }
        aYn();
        if (e.Mm(aTY)) {
            AppMethodBeat.o(150329);
            return true;
        }
        Bitmap Mt = e.b.Mt(d.aSY() + "user_" + com.tencent.mm.b.g.getMessageDigest(aTY.getBytes()) + ".png");
        if (Mt == null || Mt.isRecycled()) {
            AppMethodBeat.o(150329);
            return false;
        }
        boolean e2 = aYn().e(aTY, Mt);
        AppMethodBeat.o(150329);
        return e2;
    }

    static /* synthetic */ void aYF() {
        AppMethodBeat.i(150330);
        try {
            Context context = MMApplicationContext.getContext();
            for (String str : e.iKw.keySet()) {
                int intValue = e.iKw.containsKey(str) ? e.iKw.get(str).intValue() : 0;
                if (intValue != 0) {
                    Log.d("MicroMsg.SubCoreAvatar", "updateAssetsAvatar user:%s ", str);
                    aYn().e(str, com.tencent.mm.compatible.f.a.decodeResource(context.getResources(), intValue));
                }
            }
            AppMethodBeat.o(150330);
        } catch (Exception e2) {
            Log.e("MicroMsg.SubCoreAvatar", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(150330);
        }
    }
}
