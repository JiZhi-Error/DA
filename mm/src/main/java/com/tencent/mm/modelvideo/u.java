package com.tencent.mm.modelvideo;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.appbrand.jsapi.p.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.cly;
import com.tencent.mm.protocal.protobuf.eeq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.tavkit.component.TAVExporter;

public final class u {
    public static boolean QD(String str) {
        AppMethodBeat.i(126988);
        if (str == null) {
            AppMethodBeat.o(126988);
            return false;
        }
        s QN = QN(str);
        if (QN == null) {
            AppMethodBeat.o(126988);
            return false;
        } else if (QN.jsp >= 2500) {
            AppMethodBeat.o(126988);
            return false;
        } else {
            QN.jsp++;
            QN.cSx = 16384;
            boolean f2 = f(QN);
            AppMethodBeat.o(126988);
            return f2;
        }
    }

    public static boolean QE(String str) {
        AppMethodBeat.i(126989);
        h.INSTANCE.idkeyStat(111, 218, 1, false);
        Log.w("MicroMsg.VideoLogic", "setError file:%s stack:[%s]", str, Util.getStack());
        o.bho().QV(str);
        if (str == null) {
            AppMethodBeat.o(126989);
            return false;
        }
        s QN = QN(str);
        if (QN == null) {
            Log.e("MicroMsg.VideoLogic", "Set error failed file:".concat(String.valueOf(str)));
            AppMethodBeat.o(126989);
            return false;
        }
        QN.status = z.CTRL_INDEX;
        QN.jsm = System.currentTimeMillis() / 1000;
        QN.cSx = TAVExporter.VIDEO_EXPORT_HEIGHT;
        cly cly = QN.jsx;
        cly.vUh = 0;
        QN.jsx = cly;
        boolean f2 = f(QN);
        Log.d("MicroMsg.VideoLogic", "setError file:" + str + " msgid:" + QN.jso + " old stat:" + QN.status);
        if (QN == null || QN.jso == 0) {
            AppMethodBeat.o(126989);
            return f2;
        }
        ca Hb = ((l) g.af(l.class)).eiy().Hb((long) QN.jso);
        int type = Hb.getType();
        Log.i("MicroMsg.VideoLogic", "set error, msg type %d", Integer.valueOf(type));
        if (43 == type || 62 == type) {
            e.INSTANCE.idkeyStat(111, 32, 1, true);
            Hb.Cy(QN.getUser());
            Hb.setContent(q.b(QN.bhs(), -1, true));
            Log.d("MicroMsg.VideoLogic", "[oneliang][setError]");
            ((l) g.af(l.class)).eiy().a(Hb.field_msgId, Hb);
            AppMethodBeat.o(126989);
            return f2;
        }
        AppMethodBeat.o(126989);
        return f2;
    }

    public static boolean QF(String str) {
        AppMethodBeat.i(126990);
        s QN = QN(str);
        if (QN == null || QN.jso == 0) {
            AppMethodBeat.o(126990);
            return false;
        }
        ca Hb = ((l) g.af(l.class)).eiy().Hb((long) QN.jso);
        int type = Hb.getType();
        Log.i("MicroMsg.VideoLogic", "ashutest::setBlack, msg type %d", Integer.valueOf(type));
        if (43 == type || 62 == type) {
            Hb.setContent(q.b(QN.bhs(), (long) QN.iFw, false));
            Hb.setStatus(2);
            ((l) g.af(l.class)).eiy().a((long) QN.jso, Hb);
            QN.status = 197;
            QN.jsm = Util.nowSecond();
            QN.cSx = TAVExporter.VIDEO_EXPORT_HEIGHT;
            Log.d("MicroMsg.VideoLogic", "[oneliang][setBlack]");
            boolean f2 = f(QN);
            AppMethodBeat.o(126990);
            return f2;
        }
        AppMethodBeat.o(126990);
        return false;
    }

    public static boolean a(String str, int i2, String str2, String str3, int i3, String str4, int i4, int i5) {
        AppMethodBeat.i(169102);
        boolean a2 = a(str, i2, str2, str3, i3, str4, i4, null, "", i5, null);
        AppMethodBeat.o(169102);
        return a2;
    }

    public static boolean a(String str, int i2, String str2, String str3, int i3, String str4, int i4, eeq eeq, String str5, int i5, String str6) {
        AppMethodBeat.i(169103);
        s sVar = new s();
        sVar.fileName = str;
        sVar.iFw = i2;
        sVar.dWq = str2;
        sVar.jsh = (String) g.aAh().azQ().get(2, "");
        sVar.createTime = Util.nowSecond();
        sVar.jsm = Util.nowSecond();
        sVar.jst = str4;
        sVar.jpP = str3;
        sVar.jsw = eeq;
        sVar.ean = str5;
        sVar.ue(i5);
        sVar.Qo(str6);
        if (!Util.isNullOrNil(str3)) {
            sVar.jsr = 1;
        }
        if (i3 > 0) {
            sVar.jsr = 1;
        }
        if (62 == i4) {
            sVar.jsu = 3;
        } else if (i3 > 0) {
            sVar.jsu = 2;
        } else {
            sVar.jsu = 1;
        }
        o.bhj();
        int Qy = t.Qy(t.Qw(str));
        if (Qy <= 0) {
            Log.e("MicroMsg.VideoLogic", "get Video size failed :".concat(String.valueOf(str)));
            AppMethodBeat.o(169103);
            return false;
        }
        sVar.iKP = Qy;
        o.bhj();
        String Qx = t.Qx(str);
        int Qy2 = t.Qy(Qx);
        if (Qy2 <= 0) {
            Log.e("MicroMsg.VideoLogic", "get Thumb size failed :" + Qx + " size:" + Qy2);
            AppMethodBeat.o(169103);
            return false;
        }
        sVar.jsl = Qy2;
        Log.i("MicroMsg.VideoLogic", "init record file:" + str + " thumbsize:" + sVar.jsl + " videosize:" + sVar.iKP + " msgType:" + i4 + " forwardMsgId: " + i5);
        sVar.status = 102;
        ca caVar = new ca();
        caVar.Cy(sVar.getUser());
        caVar.setType(i4);
        caVar.nv(1);
        caVar.Cz(str);
        caVar.setStatus(1);
        caVar.setCreateTime(bp.Kw(sVar.getUser()));
        sVar.jso = (int) bp.x(caVar);
        boolean b2 = o.bhj().b(sVar);
        AppMethodBeat.o(169103);
        return b2;
    }

    public static boolean b(String str, int i2, String str2, String str3, int i3) {
        AppMethodBeat.i(169104);
        s sVar = new s();
        sVar.fileName = str;
        sVar.iFw = i2;
        sVar.dWq = str2;
        sVar.jsh = (String) g.aAh().azQ().get(2, "");
        sVar.createTime = Util.nowSecond();
        sVar.jsm = Util.nowSecond();
        sVar.jst = str3;
        sVar.ue(i3);
        sVar.jsu = 1;
        o.bhj();
        sVar.iKP = t.Qy(t.Qw(str));
        o.bhj();
        sVar.jsl = t.Qy(t.Qx(str));
        Log.i("MicroMsg.VideoLogic", "init record file:" + str + " thumbsize:" + sVar.jsl + " videosize:" + sVar.iKP + " msgType:43 forwardMsgId: " + i3);
        sVar.status = 102;
        ca caVar = new ca();
        caVar.Cy(sVar.getUser());
        caVar.setType(43);
        caVar.nv(1);
        caVar.Cz(str);
        caVar.setStatus(1);
        caVar.setCreateTime(bp.Kw(sVar.getUser()));
        sVar.jso = (int) bp.x(caVar);
        boolean b2 = o.bhj().b(sVar);
        AppMethodBeat.o(169104);
        return b2;
    }

    public static long a(String str, String str2, String str3, int i2) {
        int i3;
        s sVar;
        AppMethodBeat.i(126995);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.VideoLogic", "do prepare, but file name is null, type %d", Integer.valueOf(i2));
            AppMethodBeat.o(126995);
            return -1;
        } else if (Util.isNullOrNil(str2)) {
            Log.w("MicroMsg.VideoLogic", "do prepare, but toUser is null, type %d", Integer.valueOf(i2));
            AppMethodBeat.o(126995);
            return -1;
        } else {
            s sVar2 = new s();
            sVar2.fileName = str;
            sVar2.iFw = 1;
            sVar2.dWq = str2;
            sVar2.jsh = (String) g.aAh().azQ().get(2, "");
            sVar2.createTime = Util.nowSecond();
            sVar2.jsm = Util.nowSecond();
            sVar2.jst = null;
            sVar2.jpP = str3;
            if (!Util.isNullOrNil(str3)) {
                sVar2.jsr = 1;
            }
            if (62 == i2) {
                sVar2.jsr = 0;
                i3 = 3;
                sVar = sVar2;
            } else if (sVar2.jsr == 0) {
                i3 = 1;
                sVar = sVar2;
            } else {
                i3 = -1;
                sVar = sVar2;
            }
            sVar.jsu = i3;
            sVar2.iKP = 0;
            sVar2.status = 106;
            ca caVar = new ca();
            caVar.Cy(sVar2.getUser());
            caVar.setType(i2);
            caVar.nv(1);
            caVar.Cz(str);
            caVar.setStatus(8);
            caVar.setCreateTime(bp.Kw(sVar2.getUser()));
            long x = bp.x(caVar);
            sVar2.jso = (int) x;
            if (o.bhj().b(sVar2)) {
                AppMethodBeat.o(126995);
                return x;
            }
            AppMethodBeat.o(126995);
            return -1;
        }
    }

    public static long r(String str, String str2, String str3) {
        AppMethodBeat.i(126996);
        long a2 = a(str, str2, str3, 43);
        AppMethodBeat.o(126996);
        return a2;
    }

    public static void u(String str, int i2, int i3) {
        AppMethodBeat.i(126997);
        s QN = QN(str);
        if (QN == null) {
            Log.w("MicroMsg.VideoLogic", "update, but video info is null, fileName %s, msgType %d", str, Integer.valueOf(i3));
            AppMethodBeat.o(126997);
            return;
        }
        o.bhj();
        int Qy = t.Qy(t.Qw(str));
        Log.i("MicroMsg.VideoLogic", "update, video size %d, msgType %d", Integer.valueOf(Qy), Integer.valueOf(i3));
        QN.iKP = Qy;
        QN.iFw = i2;
        cly cly = QN.jsx;
        cly.Mrm = false;
        QN.jsx = cly;
        QN.status = 102;
        o.bhj();
        QN.jsl = t.Qy(t.Qx(str));
        Log.i("MicroMsg.VideoLogic", "update prepare:" + str + " thumbsize:" + QN.jsl);
        QN.cSx = 4512;
        Log.i("MicroMsg.VideoLogic", "update to db, result %B, msgType %d", Boolean.valueOf(f(QN)), Integer.valueOf(i3));
        ca Hb = ((l) g.af(l.class)).eiy().Hb((long) QN.jso);
        Log.i("MicroMsg.VideoLogic", "before update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", Long.valueOf(Hb.field_msgId), Long.valueOf(Hb.field_msgSvrId), Hb.field_talker, Integer.valueOf(Hb.getType()), Integer.valueOf(Hb.field_isSend), Hb.field_imgPath, Integer.valueOf(Hb.field_status), Long.valueOf(Hb.field_createTime));
        Hb.Cy(QN.getUser());
        Hb.setType(i3);
        Hb.nv(1);
        Hb.Cz(str);
        Hb.setStatus(1);
        Log.i("MicroMsg.VideoLogic", "after update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", Long.valueOf(Hb.field_msgId), Long.valueOf(Hb.field_msgSvrId), Hb.field_talker, Integer.valueOf(Hb.getType()), Integer.valueOf(Hb.field_isSend), Hb.field_imgPath, Integer.valueOf(Hb.field_status), Long.valueOf(Hb.field_createTime));
        ((l) g.af(l.class)).eiy().a((long) QN.jso, Hb);
        AppMethodBeat.o(126997);
    }

    public static int QG(String str) {
        AppMethodBeat.i(126998);
        s QN = QN(str);
        if (QN == null) {
            Log.e("MicroMsg.VideoLogic", "SENDERR:" + f.apq() + " getinfo failed: " + str);
            int line = 0 - f.getLine();
            AppMethodBeat.o(126998);
            return line;
        } else if (QN.status == 102 || QN.status == 105) {
            int i2 = QN.status;
            if (QN.status == 102 || QN.jsl != QN.jsk) {
                QN.status = 103;
            } else {
                QN.status = 104;
            }
            Log.i("MicroMsg.VideoLogic", f.apq() + "startSend file:" + str + " status:[" + i2 + "->" + QN.status + "]");
            QN.jsn = Util.nowSecond();
            QN.jsm = Util.nowSecond();
            QN.cSx = 3328;
            if (!f(QN)) {
                Log.e("MicroMsg.VideoLogic", "ERR:" + f.apq() + " update failed: " + str);
                int line2 = 0 - f.getLine();
                AppMethodBeat.o(126998);
                return line2;
            }
            o.bho().run();
            AppMethodBeat.o(126998);
            return 0;
        } else {
            Log.e("MicroMsg.VideoLogic", "SENDERR:" + f.apq() + " get status failed: " + str + " status:" + QN.status);
            int line3 = 0 - f.getLine();
            AppMethodBeat.o(126998);
            return line3;
        }
    }

    public static int AL(long j2) {
        AppMethodBeat.i(126999);
        for (s sVar : o.bhj().AK(j2)) {
            int i2 = sVar.status;
            sVar.status = 200;
            Log.d("MicroMsg.VideoLogic", f.apq() + "startSend file:" + sVar.getFileName() + " status:[" + i2 + "->" + sVar.status + "]");
            sVar.jsn = Util.nowSecond();
            sVar.jsm = Util.nowSecond();
            sVar.cSx = 3328;
            if (!f(sVar)) {
                Log.e("MicroMsg.VideoLogic", "ERR on start MassSend:" + f.apq() + " update failed: " + sVar.getFileName());
                int line = 0 - f.getLine();
                AppMethodBeat.o(126999);
                return line;
            }
        }
        g.aAk().postToWorker(
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00bf: INVOKE  
              (wrap: com.tencent.mm.sdk.platformtools.MMHandlerThread : 0x00b6: INVOKE  (r1v1 com.tencent.mm.sdk.platformtools.MMHandlerThread) =  type: STATIC call: com.tencent.mm.kernel.g.aAk():com.tencent.mm.sdk.platformtools.MMHandlerThread)
              (wrap: com.tencent.mm.modelvideo.m$3 : 0x00bc: CONSTRUCTOR  (r2v0 com.tencent.mm.modelvideo.m$3) = 
              (wrap: com.tencent.mm.modelvideo.m : 0x00b2: INVOKE  (r0v3 com.tencent.mm.modelvideo.m) =  type: STATIC call: com.tencent.mm.modelvideo.o.bhp():com.tencent.mm.modelvideo.m)
             call: com.tencent.mm.modelvideo.m.3.<init>(com.tencent.mm.modelvideo.m):void type: CONSTRUCTOR)
             type: VIRTUAL call: com.tencent.mm.sdk.platformtools.MMHandlerThread.postToWorker(java.lang.Runnable):int in method: com.tencent.mm.modelvideo.u.AL(long):int, file: classes5.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00bc: CONSTRUCTOR  (r2v0 com.tencent.mm.modelvideo.m$3) = 
              (wrap: com.tencent.mm.modelvideo.m : 0x00b2: INVOKE  (r0v3 com.tencent.mm.modelvideo.m) =  type: STATIC call: com.tencent.mm.modelvideo.o.bhp():com.tencent.mm.modelvideo.m)
             call: com.tencent.mm.modelvideo.m.3.<init>(com.tencent.mm.modelvideo.m):void type: CONSTRUCTOR in method: com.tencent.mm.modelvideo.u.AL(long):int, file: classes5.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 14 more
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.modelvideo.m, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 20 more
            */
        /*
        // Method dump skipped, instructions count: 199
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelvideo.u.AL(long):int");
    }

    public static int QH(String str) {
        AppMethodBeat.i(127000);
        s QN = QN(str);
        if (QN == null) {
            Log.e("MicroMsg.VideoLogic", "ERR:" + f.apq() + " getinfo failed: " + str);
            int line = 0 - f.getLine();
            AppMethodBeat.o(127000);
            return line;
        } else if (QN.status == 104 || QN.status == 103) {
            QN.status = 105;
            QN.jsm = Util.nowSecond();
            QN.cSx = TAVExporter.VIDEO_EXPORT_HEIGHT;
            if (!f(QN)) {
                Log.e("MicroMsg.VideoLogic", "ERR:" + f.apq() + " update failed: " + str);
                int line2 = 0 - f.getLine();
                AppMethodBeat.o(127000);
                return line2;
            }
            AppMethodBeat.o(127000);
            return 0;
        } else {
            Log.e("MicroMsg.VideoLogic", "ERR:" + f.apq() + " get status failed: " + str + " status:" + QN.status);
            int line3 = 0 - f.getLine();
            AppMethodBeat.o(127000);
            return line3;
        }
    }

    public static void d(s sVar) {
        AppMethodBeat.i(127001);
        if (sVar == null) {
            Log.e("MicroMsg.VideoLogic", "video info is null");
            AppMethodBeat.o(127001);
            return;
        }
        ca Hb = ((l) g.af(l.class)).eiy().Hb((long) sVar.jso);
        int type = Hb.getType();
        Log.i("MicroMsg.VideoLogic", "ashutest::updateWriteFinMsgInfo, msg type %d", Integer.valueOf(type));
        if (43 == type || 62 == type) {
            Hb.nv(1);
            Hb.Cy(sVar.getUser());
            Hb.yF(sVar.dTS);
            Hb.setStatus(2);
            Hb.setContent(q.b(sVar.bhs(), (long) sVar.iFw, false));
            ((l) g.af(l.class)).eiy().a((long) sVar.jso, Hb);
            Log.d("MicroMsg.VideoLogic", "[oneliang][updateWriteFinMsgInfo], msgId:%d", Long.valueOf(Hb.field_msgId));
            AppMethodBeat.o(127001);
            return;
        }
        AppMethodBeat.o(127001);
    }

    static boolean e(s sVar) {
        AppMethodBeat.i(127002);
        ca Hb = ((l) g.af(l.class)).eiy().Hb((long) sVar.jso);
        int type = Hb.getType();
        Log.i("MicroMsg.VideoLogic", "ashutest::update read fin msg info, msg type %d", Integer.valueOf(type));
        if (43 == type || 62 == type) {
            Hb.yF(sVar.dTS);
            Hb.setContent(q.b(sVar.bhs(), (long) sVar.iFw, false));
            Hb.Cy(sVar.getUser());
            Log.d("MicroMsg.VideoLogic", "set msg content :" + Hb.field_content);
            ((l) g.af(l.class)).eiy().b(sVar.dTS, Hb);
            Log.d("MicroMsg.VideoLogic", "[oneliang][updateReadFinMsgInfo], msgId:%d", Long.valueOf(Hb.field_msgId));
            if (Hb.cWL()) {
                Log.i("MicroMsg.VideoLogic", "on receive sight, sightFileSize %d bytes", Integer.valueOf(sVar.iKP));
            }
            AppMethodBeat.o(127002);
            return true;
        }
        AppMethodBeat.o(127002);
        return false;
    }

    public static int QI(String str) {
        AppMethodBeat.i(127003);
        s QN = QN(str);
        if (QN == null) {
            Log.e("MicroMsg.VideoLogic", "ERR:" + f.apq() + " getinfo failed: " + str);
            int line = 0 - f.getLine();
            AppMethodBeat.o(127003);
            return line;
        } else if (QN.status == 111 || QN.status == 113 || QN.status == 121 || QN.status == 122 || QN.status == 123) {
            QN.status = 112;
            QN.jsn = Util.nowSecond();
            QN.jsm = Util.nowSecond();
            QN.cSx = 3328;
            if (!f(QN)) {
                Log.e("MicroMsg.VideoLogic", "ERR:" + f.apq() + " update failed: " + str);
                int line2 = 0 - f.getLine();
                AppMethodBeat.o(127003);
                return line2;
            }
            o.bho().bhG();
            o.bho().run();
            AppMethodBeat.o(127003);
            return 0;
        } else {
            Log.e("MicroMsg.VideoLogic", "ERR:" + f.apq() + " get status failed: " + str + " status:" + QN.status);
            int line3 = 0 - f.getLine();
            AppMethodBeat.o(127003);
            return line3;
        }
    }

    public static int QJ(String str) {
        AppMethodBeat.i(127004);
        s QN = QN(str);
        if (QN == null) {
            Log.e("MicroMsg.VideoLogic", "ERR:" + f.apq() + " getinfo failed: " + str);
            int line = 0 - f.getLine();
            AppMethodBeat.o(127004);
            return line;
        } else if (QN.status == 112 || QN.status == 120 || QN.status == 122 || QN.status == 123) {
            QN.status = 113;
            QN.jsm = Util.nowSecond();
            QN.cSx = TAVExporter.VIDEO_EXPORT_HEIGHT;
            if (!f(QN)) {
                Log.e("MicroMsg.VideoLogic", "ERR:" + f.apq() + " update failed: " + str);
                int line2 = 0 - f.getLine();
                AppMethodBeat.o(127004);
                return line2;
            }
            AppMethodBeat.o(127004);
            return 0;
        } else {
            Log.e("MicroMsg.VideoLogic", "ERR:" + f.apq() + " get status failed: " + str + " status:" + QN.status);
            int line3 = 0 - f.getLine();
            AppMethodBeat.o(127004);
            return line3;
        }
    }

    public static boolean ay(String str, int i2) {
        int i3 = 0;
        AppMethodBeat.i(127005);
        s QN = QN(str);
        if (QN == null) {
            Log.e("MicroMsg.VideoLogic", "ERR:" + f.apq() + " getinfo failed: " + str);
            AppMethodBeat.o(127005);
            return false;
        }
        if (i2 != QN.iKP) {
            Log.w("MicroMsg.VideoLogic", "download video finish, but file size is not equals db size[%d, %d]", Integer.valueOf(i2), Integer.valueOf(QN.iKP));
            QN.iKP = i2;
            i3 = 32;
        }
        QN.jsj = i2;
        QN.jsm = Util.nowSecond();
        e(QN);
        QN.status = 199;
        QN.cSx = i3 | 1296;
        boolean f2 = f(QN);
        Log.i("MicroMsg.VideoLogic", "END!!!  updateRecv  file:" + str + " newsize:" + i2 + " total:" + QN.iKP + " status:" + QN.status + " netTimes:" + QN.jsp + " update ret: " + f2);
        AppMethodBeat.o(127005);
        return f2;
    }

    public static boolean QK(String str) {
        AppMethodBeat.i(127006);
        Log.i("MicroMsg.VideoLogic", "resetMsgRecv fileName : ".concat(String.valueOf(str)));
        s sVar = new s();
        sVar.status = 112;
        sVar.jsm = Util.nowSecond();
        sVar.jsn = Util.nowSecond();
        sVar.fileName = str;
        sVar.cSx = 3328;
        if (!f(sVar)) {
            AppMethodBeat.o(127006);
            return false;
        }
        o.bho().run();
        AppMethodBeat.o(127006);
        return true;
    }

    public static boolean QL(String str) {
        AppMethodBeat.i(127007);
        s QN = QN(str);
        if (QN == null) {
            AppMethodBeat.o(127007);
            return false;
        }
        Log.i("MicroMsg.VideoLogic", "rsetMsgSend %s", str);
        cly cly = QN.jsx;
        if (cly != null) {
            cly.vUh = 0;
            QN.jsx = cly;
        }
        if (QN.jsk < QN.jsl) {
            QN.status = 103;
        } else {
            QN.status = 104;
        }
        QN.createTime = Util.nowSecond();
        QN.jsm = Util.nowSecond();
        QN.jsn = Util.nowSecond();
        QN.cSx = 536874752;
        if (!f(QN)) {
            AppMethodBeat.o(127007);
            return false;
        }
        o.bho().run();
        AppMethodBeat.o(127007);
        return true;
    }

    public static void QM(String str) {
        boolean z = true;
        AppMethodBeat.i(127008);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(127008);
            return;
        }
        t bhj = o.bhj();
        if (bhj.iFy.delete(t.d.QC(str), "filename= ?", new String[]{String.valueOf(str)}) > 0) {
            bhj.iKx.event(new t.a.C0460a(str, t.a.b.DELETE, t.a.c.NORMAL, 1, -1));
            bhj.iKx.doNotify();
        } else {
            z = false;
        }
        if (!z) {
            AppMethodBeat.o(127008);
            return;
        }
        try {
            o.bhj();
            new o(t.Qx(str)).delete();
            o.bhj();
            new o(t.Qw(str)).delete();
            AppMethodBeat.o(127008);
        } catch (Exception e2) {
            Log.e("MicroMsg.VideoLogic", "ERR: Delete file Failed" + f.apq() + " file:" + str + " msg:" + e2.getMessage());
            AppMethodBeat.o(127008);
        }
    }

    public static s QN(String str) {
        AppMethodBeat.i(127009);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(127009);
            return null;
        }
        s Qq = o.bhj().Qq(str);
        AppMethodBeat.o(127009);
        return Qq;
    }

    public static boolean f(s sVar) {
        AppMethodBeat.i(127010);
        if (sVar == null) {
            AppMethodBeat.o(127010);
            return false;
        } else if ((sVar.getFileName() == null || sVar.getFileName().length() <= 0) && sVar.cSx == -1) {
            AppMethodBeat.o(127010);
            return false;
        } else {
            boolean c2 = o.bhj().c(sVar);
            AppMethodBeat.o(127010);
            return c2;
        }
    }

    public static boolean QO(String str) {
        AppMethodBeat.i(127014);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.VideoLogic", "check short video was replaced, but filename is null.");
            AppMethodBeat.o(127014);
            return false;
        }
        Log.d("MicroMsg.VideoLogic", "checkShortVideoWasReplaced filename: ".concat(String.valueOf(str)));
        s QN = QN(str);
        if (QN != null && QN.status == 199) {
            int i2 = QN.iKP;
            o.bhj();
            int boW = (int) s.boW(t.Qw(str));
            Log.d("MicroMsg.VideoLogic", "it short video file size[%d] infoLen[%d]", Integer.valueOf(boW), Integer.valueOf(i2));
            if (boW > 0 && Math.abs(boW - i2) > 16) {
                Log.w("MicroMsg.VideoLogic", "it error short video can not retransmit. file size[%d], video info size[%d]", Integer.valueOf(boW), Integer.valueOf(i2));
                String fileName = QN.getFileName();
                h.INSTANCE.idkeyStat(111, 217, 1, false);
                s QN2 = QN(fileName);
                if (QN2 != null) {
                    ca Hb = ((l) g.af(l.class)).eiy().Hb((long) QN2.jso);
                    int type = Hb.getType();
                    Log.i("MicroMsg.VideoLogic", "ashutest::setBroken, msg type %d", Integer.valueOf(type));
                    if (43 == type || 62 == type) {
                        Hb.setContent(q.b(QN2.bhs(), (long) QN2.iFw, false));
                        Hb.setStatus(2);
                        ((l) g.af(l.class)).eiy().a((long) QN2.jso, Hb);
                        QN2.status = 196;
                        QN2.jsm = Util.nowSecond();
                        QN2.cSx = TAVExporter.VIDEO_EXPORT_HEIGHT;
                        Log.d("MicroMsg.VideoLogic", "[oneliang][setBroken]");
                        f(QN2);
                    }
                }
                AppMethodBeat.o(127014);
                return true;
            }
        }
        AppMethodBeat.o(127014);
        return false;
    }

    public static int Q(int i2, String str) {
        int i3;
        AppMethodBeat.i(127015);
        long currentTicks = Util.currentTicks();
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        if (!o.bhm().b(str, pInt, pInt2) || Util.secondsToNow((long) pInt.value) >= 300) {
            i3 = 0;
        } else {
            i3 = pInt2.value;
        }
        if (i3 < 0 || i3 >= i2 - 1) {
            i3 = 0;
        }
        Log.d("MicroMsg.VideoLogic", "check last play duration result[%d] startTime[%d] filename[%s] cost %d", Integer.valueOf(i3), Integer.valueOf(pInt.value), str, Long.valueOf(Util.ticksToNow(currentTicks)));
        AppMethodBeat.o(127015);
        return i3;
    }

    public static void f(String str, int i2, boolean z) {
        boolean z2;
        int i3;
        AppMethodBeat.i(127016);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.VideoLogic", "noteVideoPlayHistory error filename[%s]", str);
            AppMethodBeat.o(127016);
            return;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        int i4 = i2 / 1000;
        long currentTicks = Util.currentTicks();
        if (!o.bhm().QU(str)) {
            x bhm = o.bhm();
            int nowMilliSecond = (int) (Util.nowMilliSecond() / 1000);
            if (z) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            if (!Util.isNullOrNil(str)) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("filename", str);
                contentValues.put("starttime", Integer.valueOf(nowMilliSecond));
                contentValues.put("playduration", Integer.valueOf(i4));
                contentValues.put("downloadway", Integer.valueOf(i3));
                long insert = bhm.db.insert("VideoPlayHistory", "filename", contentValues);
                Log.i("MicroMsg.VideoPlayHistoryStorage", "insert video play history ret : ".concat(String.valueOf(insert)));
                if (insert > 0) {
                    z2 = true;
                }
            }
            z2 = false;
        } else {
            x bhm2 = o.bhm();
            int nowMilliSecond2 = (int) (Util.nowMilliSecond() / 1000);
            if (!Util.isNullOrNil(str)) {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("starttime", Integer.valueOf(nowMilliSecond2));
                contentValues2.put("playduration", Integer.valueOf(i4));
                long update = (long) bhm2.db.update("VideoPlayHistory", contentValues2, "filename=?", new String[]{str});
                Log.i("MicroMsg.VideoPlayHistoryStorage", "update video play history ret : ".concat(String.valueOf(update)));
                if (update > 0) {
                    z2 = true;
                }
            }
            z2 = false;
        }
        Log.d("MicroMsg.VideoLogic", "noteVideoPlayHistory ret %b filename %s playDuration %d isOnlinePlay %b cost %d", Boolean.valueOf(z2), str, Integer.valueOf(i4), Boolean.valueOf(z), Long.valueOf(Util.ticksToNow(currentTicks)));
        AppMethodBeat.o(127016);
    }

    public static void QP(String str) {
        boolean z = true;
        AppMethodBeat.i(127017);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(127017);
            return;
        }
        if (o.bhm().db.delete("VideoPlayHistory", "filename= ?", new String[]{str}) <= 0) {
            z = false;
        }
        Log.d("MicroMsg.VideoLogic", "delete video play history ret : " + z + " filename : " + str);
        AppMethodBeat.o(127017);
    }

    public static String f(long j2, int i2) {
        AppMethodBeat.i(127018);
        String str = j2 + "_" + i2;
        AppMethodBeat.o(127018);
        return str;
    }

    public static int g(long j2, String str) {
        AppMethodBeat.i(127019);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(127019);
            return -1;
        }
        try {
            String[] split = str.split("_");
            if (split == null || split.length != 2) {
                AppMethodBeat.o(127019);
                return -1;
            }
            if (Util.getLong(split[0], 0) == j2) {
                int i2 = Util.getInt(split[1], 0);
                AppMethodBeat.o(127019);
                return i2;
            }
            AppMethodBeat.o(127019);
            return -1;
        } catch (Exception e2) {
            Log.e("MicroMsg.VideoLogic", "parseEnterVideoOpTips error: " + e2.toString());
        }
    }

    public static void az(String str, int i2) {
        AppMethodBeat.i(127020);
        s QN = QN(str);
        if (QN != null) {
            if (((l) g.af(l.class)).eiy().Hb((long) QN.jso).cWK()) {
                Log.i("MicroMsg.VideoLogic", "jump mp video");
                AppMethodBeat.o(127020);
                return;
            }
            QN.status = 122;
            QN.jsn = Util.nowSecond();
            QN.jsm = Util.nowSecond();
            QN.gqW = i2;
            QN.cSx = 268438784;
            Log.i("MicroMsg.VideoLogic", "set online video Completion ret: " + o.bhj().c(QN) + " status: " + QN.status);
        }
        AppMethodBeat.o(127020);
    }

    public static boolean QQ(String str) {
        AppMethodBeat.i(127021);
        s QN = QN(str);
        if (QN != null) {
            QN.videoFormat = 2;
            QN.cSx = 2;
            boolean c2 = o.bhj().c(QN);
            Log.i("MicroMsg.VideoLogic", "set VideoFormat ret[%b] filename[%s] format[%d]", Boolean.valueOf(c2), str, 2);
            AppMethodBeat.o(127021);
            return c2;
        }
        AppMethodBeat.o(127021);
        return false;
    }

    public static boolean QR(String str) {
        AppMethodBeat.i(127022);
        s QN = QN(str);
        if (QN != null) {
            QN.videoFormat = 2;
            QN.status = 199;
            QN.jsn = Util.nowSecond();
            QN.jsm = Util.nowSecond();
            QN.gqW = 19;
            QN.cSx = 268438786;
            boolean c2 = o.bhj().c(QN);
            Log.i("MicroMsg.VideoLogic", "set hevc video Completion ret: " + c2 + " status: " + QN.status);
            AppMethodBeat.o(127022);
            return c2;
        }
        AppMethodBeat.o(127022);
        return false;
    }

    public static boolean QS(String str) {
        AppMethodBeat.i(127023);
        s QN = QN(str);
        if (QN != null) {
            QN.videoFormat = 2;
            QN.cSx = 2;
            boolean c2 = o.bhj().c(QN);
            Log.i("MicroMsg.VideoLogic", "set hevc video format ret: " + c2 + " status: " + QN.status);
            AppMethodBeat.o(127023);
            return c2;
        }
        AppMethodBeat.o(127023);
        return false;
    }

    public static int QT(String str) {
        int i2;
        AppMethodBeat.i(127024);
        s QN = QN(str);
        if (QN == null) {
            Log.e("MicroMsg.VideoLogic", "ERR:" + f.apq() + " getinfo failed: " + str);
            int line = 0 - f.getLine();
            AppMethodBeat.o(127024);
            return line;
        } else if (QN.status == 111 || QN.status == 113 || QN.status == 121 || QN.status == 122 || QN.status == 123) {
            boolean z = ((l) g.af(l.class)).eiy().Hb((long) QN.jso).cWK();
            Log.i("MicroMsg.VideoLogic", " is mp video :%b", Boolean.valueOf(z));
            com.tencent.mm.modelcontrol.e.baZ();
            if (!com.tencent.mm.modelcontrol.e.bbk() || z) {
                Log.w("MicroMsg.VideoLogic", "start complete online video, but can not stream video now!");
                QN.status = 112;
                QN.jsj = 0;
                i2 = 272;
            } else {
                QN.status = 122;
                i2 = 256;
            }
            QN.jsn = Util.nowSecond();
            QN.jsm = Util.nowSecond();
            QN.cSx = i2 | 2048 | 1024;
            if (!f(QN)) {
                Log.e("MicroMsg.VideoLogic", "ERR:" + f.apq() + " update failed: " + str);
                int line2 = 0 - f.getLine();
                AppMethodBeat.o(127024);
                return line2;
            }
            o.bho().bhG();
            o.bho().run();
            AppMethodBeat.o(127024);
            return 0;
        } else {
            Log.e("MicroMsg.VideoLogic", "ERR:" + f.apq() + " get status failed: " + str + " status:" + QN.status);
            int line3 = 0 - f.getLine();
            AppMethodBeat.o(127024);
            return line3;
        }
    }

    public static boolean aA(String str, int i2) {
        AppMethodBeat.i(127025);
        boolean b2 = b(QN(str), i2);
        AppMethodBeat.o(127025);
        return b2;
    }

    public static boolean b(s sVar, int i2) {
        AppMethodBeat.i(127026);
        if (sVar != null) {
            sVar.gqW = i2;
            sVar.cSx = 268435456;
            boolean f2 = f(sVar);
            AppMethodBeat.o(127026);
            return f2;
        }
        AppMethodBeat.o(127026);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00e0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(java.lang.String r11, com.tencent.mm.pointers.PInt r12, com.tencent.mm.pointers.PInt r13) {
        /*
        // Method dump skipped, instructions count: 235
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelvideo.u.a(java.lang.String, com.tencent.mm.pointers.PInt, com.tencent.mm.pointers.PInt):boolean");
    }

    public static boolean c(String str, int i2, String str2, String str3) {
        AppMethodBeat.i(126991);
        boolean a2 = a(str, i2, str2, str3, 0, "", 43, 0);
        AppMethodBeat.o(126991);
        return a2;
    }

    public static int g(s sVar) {
        AppMethodBeat.i(127012);
        if (sVar.iKP == 0) {
            AppMethodBeat.o(127012);
            return 0;
        }
        Log.d("MicroMsg.VideoLogic", "cdntra getDownloadProgress :" + sVar.jsj + " " + sVar.iKP);
        int i2 = (sVar.jsj * 100) / sVar.iKP;
        AppMethodBeat.o(127012);
        return i2;
    }

    public static int h(s sVar) {
        AppMethodBeat.i(127013);
        if (sVar.iKP == 0) {
            AppMethodBeat.o(127013);
            return 0;
        }
        Log.d("MicroMsg.VideoLogic", "cdntra getUploadProgress :" + sVar.jqP + " " + sVar.iKP);
        int i2 = (sVar.jqP * 100) / sVar.iKP;
        AppMethodBeat.o(127013);
        return i2;
    }
}
