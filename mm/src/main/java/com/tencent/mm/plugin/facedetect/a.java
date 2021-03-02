package com.tencent.mm.plugin.facedetect;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.model.i;
import com.tencent.mm.plugin.facedetect.model.j;
import com.tencent.mm.plugin.facedetect.model.k;
import com.tencent.mm.plugin.facedetect.model.m;
import com.tencent.mm.plugin.facedetect.model.o;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.facedetectaction.b.c;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vfs.s;

public final class a implements com.tencent.mm.vending.c.a<Void, Void> {
    private static j sPc = new j();
    private static o sPd = new o();
    private static i sPe = new i();
    private static m sPf = new m();
    private static c sPg = new c();
    private static k sPh = new k();
    private b jSi = null;

    static /* synthetic */ void b(a aVar, String str, String str2) {
        AppMethodBeat.i(186360);
        gB(str, str2);
        AppMethodBeat.o(186360);
    }

    static /* synthetic */ void q(Context context, String str, String str2) {
        AppMethodBeat.i(103579);
        x(context, str, str2);
        AppMethodBeat.o(103579);
    }

    static {
        AppMethodBeat.i(103581);
        AppMethodBeat.o(103581);
    }

    private static void safeAddListener(IListener iListener) {
        AppMethodBeat.i(103574);
        if (iListener == null) {
            Log.w("MicroMsg.TaskInitFace", "hy: listener is null or id is invalid");
            AppMethodBeat.o(103574);
        } else if (EventCenter.instance.hadListened(iListener)) {
            Log.w("MicroMsg.TaskInitFace", "hy: already has listener");
            AppMethodBeat.o(103574);
        } else {
            EventCenter.instance.addListener(iListener);
            AppMethodBeat.o(103574);
        }
    }

    private static void gB(String str, String str2) {
        AppMethodBeat.i(103575);
        com.tencent.mm.plugin.expansions.a.cMq();
        String bhK = s.bhK(str);
        String bhK2 = s.bhK("assets:///".concat(String.valueOf(str2)));
        Log.i("MicroMsg.TaskInitFace", "localMD5 : ".concat(String.valueOf(bhK)));
        Log.i("MicroMsg.TaskInitFace", "assetMD5 : ".concat(String.valueOf(bhK2)));
        if (bhK == null || bhK.equals(bhK2)) {
            Log.i("MicroMsg.TaskInitFace", "SDPath:%s   exists ", str);
            AppMethodBeat.o(103575);
            return;
        }
        s.deleteFile(str);
        Log.i("MicroMsg.TaskInitFace", str + " md5 is wrong");
        p.j(MMApplicationContext.getContext(), str2, str);
        AppMethodBeat.o(103575);
    }

    private static void x(Context context, String str, String str2) {
        AppMethodBeat.i(103576);
        com.tencent.mm.plugin.expansions.a.cMq();
        p.j(context, str, str2);
        AppMethodBeat.o(103576);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.mm.vending.c.a
    public final /* synthetic */ Void call(Void r8) {
        AppMethodBeat.i(103577);
        Log.i("MicroMsg.TaskInitFace", "hy: TaskInitFace init");
        this.jSi = g.hdx();
        safeAddListener(sPc);
        safeAddListener(sPd);
        safeAddListener(sPe);
        safeAddListener(sPg);
        safeAddListener(sPh);
        final String str = p.cTh() + FilePathGenerator.ANDROID_DIR_SEP;
        final String[] cTk = p.cTk();
        final String[] cTj = p.cTj();
        final String[] cTi = p.cTi();
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.plugin.facedetect.a.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(103573);
                String[] strArr = cTk;
                for (String str : strArr) {
                    a.a(a.this, str + str, "face_detect/".concat(String.valueOf("detector/".concat(String.valueOf(str)))));
                }
                String[] strArr2 = cTj;
                for (String str2 : strArr2) {
                    a.a(a.this, str + str2, "face_detect/".concat(String.valueOf("ufa/".concat(String.valueOf(str2)))));
                }
                String[] strArr3 = cTi;
                for (String str3 : strArr3) {
                    a.a(a.this, str + str3, "face_detect/".concat(String.valueOf("poseest/".concat(String.valueOf(str3)))));
                }
                String cTl = p.cTl();
                String cTm = p.cTm();
                boolean YS = com.tencent.mm.pluginsdk.j.a.d.a.YS(cTl);
                boolean YS2 = com.tencent.mm.pluginsdk.j.a.d.a.YS(cTm);
                Log.i("MicroMsg.TaskInitFace", "alvinluo detectmodel: %s, exist: %b, alignModel: %s, exist: %b", cTl, Boolean.valueOf(YS), cTm, Boolean.valueOf(YS2));
                if (!YS) {
                    Log.i("MicroMsg.TaskInitFace", "alvinluo copy detect model file");
                    a.q(MMApplicationContext.getContext(), "face_detect/ufdmtcc.bin", cTl);
                } else {
                    a.b(a.this, cTl, "face_detect/ufdmtcc.bin");
                }
                if (!YS2) {
                    Log.i("MicroMsg.TaskInitFace", "alvinluo copy alignment model file");
                    a.q(MMApplicationContext.getContext(), "face_detect/ufat.bin", cTm);
                    AppMethodBeat.o(103573);
                    return;
                }
                a.b(a.this, cTm, "face_detect/ufat.bin");
                AppMethodBeat.o(103573);
            }
        }, "FaceReflectCopyModelFile");
        AppMethodBeat.o(103577);
        return null;
    }

    static /* synthetic */ void a(a aVar, String str, String str2) {
        AppMethodBeat.i(186359);
        if (!com.tencent.mm.pluginsdk.j.a.d.a.YS(str)) {
            Log.i("MicroMsg.TaskInitFace", "alvinluo copy detect model file detector: %s", str);
            x(MMApplicationContext.getContext(), str2, str);
            AppMethodBeat.o(186359);
            return;
        }
        gB(str, str2);
        AppMethodBeat.o(186359);
    }
}
