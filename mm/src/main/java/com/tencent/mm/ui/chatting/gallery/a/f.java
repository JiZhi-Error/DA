package com.tencent.mm.ui.chatting.gallery.a;

import com.facebook.internal.NativeProtocol;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.g;
import com.tencent.mm.g.b.a.ab;
import com.tencent.mm.g.b.a.fb;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.vfs.s;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 )2\u00020\u0001:\b'()*+,-.B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000eJ*\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J<\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\nJ\u000e\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u000eJ\b\u0010\u001f\u001a\u00020\fH\u0002J\u0016\u0010 \u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000eJ\u0016\u0010!\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000eJ\u000e\u0010\"\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000eJ\u0018\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u000e2\b\u0010%\u001a\u0004\u0018\u00010&R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, hxF = {"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonReporter;", "", "()V", "fastEntryClick", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonReporter$ImageFastEntryClick;", "fastEntryDetectStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/ImageFastEntryDetectStruct;", "searchButtonReportInfo", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonReporter$ImageSearchButtonReportInfo;", "sessionId", "", "clickFinish", "", "clickResult", "", "clickScanButton", "iconType", "doReportSearchButtonAction", NativeProtocol.WEB_DIALOG_ACTION, "source", AppMeasurement.Param.TIMESTAMP, "", "initSearchButtonReportInfo", "msgId", "scene", "chatType", ch.COL_USERNAME, "chatRoomId", "imagePath", "reportFastDetectEntry", "pictureConcluding", "reportFastEntryClick", "reportSearchButtonAction", "resetSearchButtonAction", "setShowIcon", "startSession", "picType", "imgInfo", "Lcom/tencent/mm/modelimage/ImgInfo;", "ChatType", "ClickResult", "Companion", "IconType", "ImageFastEntryClick", "ImageSearchButtonReportInfo", "OpenPictureType", "PictureConcluding", "app_release"})
public final class f {
    public static final a PBZ = new a((byte) 0);
    private fb PBW;
    private b PBX;
    public c PBY;
    private String sessionId = "";

    static {
        AppMethodBeat.i(231237);
        AppMethodBeat.o(231237);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonReporter$Companion;", "", "()V", "TAG", "", "app_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void b(int i2, g gVar) {
        String str = null;
        AppMethodBeat.i(231229);
        this.PBW = new fb();
        Log.v("MicroMsg.ImageScanButtonReporter", "startSession picType: %d", Integer.valueOf(i2));
        fb fbVar = this.PBW;
        if (fbVar == null) {
            p.hyc();
        }
        fbVar.ne(1);
        fbVar.nd(1);
        fbVar.na(System.currentTimeMillis());
        fbVar.nb((long) i2);
        fbVar.rX(z.aTY() + "_" + fbVar.afT());
        fbVar.rY(gVar != null ? gVar.getFileId() : null);
        if (gVar != null) {
            str = gVar.getAesKey();
        }
        fbVar.rZ(str);
        String sessionId2 = fbVar.getSessionId();
        p.g(sessionId2, "sessionId");
        this.sessionId = sessionId2;
        c cVar = new c();
        cVar.PCd = System.currentTimeMillis();
        this.PBY = cVar;
        AppMethodBeat.o(231229);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001f, code lost:
        if (r0.afU() == 0) goto L_0x0021;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void ann(int r7) {
        /*
            r6 = this;
            r5 = 231230(0x3873e, float:3.24022E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r5)
            com.tencent.mm.g.b.a.fb r0 = r6.PBW
            if (r0 == 0) goto L_0x0021
            long r0 = r0.afV()
            long r2 = (long) r7
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x0021
            com.tencent.mm.g.b.a.fb r0 = r6.PBW
            if (r0 == 0) goto L_0x004b
            long r0 = r0.afU()
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x004f
        L_0x0021:
            java.lang.String r0 = "MicroMsg.ImageScanButtonReporter"
            java.lang.String r1 = "setShowIcon iconType: %d"
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            java.lang.Integer r4 = java.lang.Integer.valueOf(r7)
            r2[r3] = r4
            com.tencent.mm.sdk.platformtools.Log.v(r0, r1, r2)
            com.tencent.mm.g.b.a.fb r0 = r6.PBW
            if (r0 == 0) goto L_0x003c
            long r2 = (long) r7
            r0.ne(r2)
        L_0x003c:
            com.tencent.mm.g.b.a.fb r0 = r6.PBW
            if (r0 == 0) goto L_0x004f
            long r2 = java.lang.System.currentTimeMillis()
            r0.nc(r2)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
        L_0x004a:
            return
        L_0x004b:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            goto L_0x004a
        L_0x004f:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            goto L_0x004a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.gallery.a.f.ann(int):void");
    }

    public final void ano(int i2) {
        AppMethodBeat.i(231231);
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i2);
        fb fbVar = this.PBW;
        objArr[1] = fbVar != null ? fbVar.getSessionId() : null;
        Log.v("MicroMsg.ImageScanButtonReporter", "reportFastDetectEntry pictureConcluding: %d, sessionId: %s", objArr);
        fb fbVar2 = this.PBW;
        if (fbVar2 != null) {
            fbVar2.nd((long) i2);
        }
        fb fbVar3 = this.PBW;
        if (fbVar3 != null) {
            fbVar3.bfK();
            AppMethodBeat.o(231231);
            return;
        }
        AppMethodBeat.o(231231);
    }

    public final void anp(int i2) {
        AppMethodBeat.i(231232);
        Log.i("MicroMsg.ImageScanButtonReporter", "alvinluo clickScanButton iconType: %d", Integer.valueOf(i2));
        this.PBX = new b();
        b bVar = this.PBX;
        if (bVar == null) {
            p.hyc();
        }
        bVar.reset();
        fb fbVar = this.PBW;
        if (fbVar == null) {
            p.hyc();
        }
        String sessionId2 = fbVar.getSessionId();
        p.g(sessionId2, "fastEntryDetectStruct!!.sessionId");
        bVar.setSessionId(sessionId2);
        bVar.jjN = i2;
        bVar.PCb = System.currentTimeMillis();
        AppMethodBeat.o(231232);
    }

    public final void anq(int i2) {
        AppMethodBeat.i(231233);
        b bVar = this.PBX;
        if (bVar != null) {
            bVar.PCa = i2;
        }
        b bVar2 = this.PBX;
        if (bVar2 != null) {
            bVar2.PCc = System.currentTimeMillis();
        }
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i2);
        b bVar3 = this.PBX;
        objArr[1] = bVar3 != null ? Long.valueOf(bVar3.PCc) : null;
        Log.i("MicroMsg.ImageScanButtonReporter", "alvinluo clickFinish clickResult: %d, %s", objArr);
        gTu();
        AppMethodBeat.o(231233);
    }

    private final void gTu() {
        b bVar;
        AppMethodBeat.i(231234);
        b bVar2 = this.PBX;
        if (bVar2 == null || !bVar2.gqx) {
            b bVar3 = this.PBX;
            if (bVar3 != null) {
                bVar3.gqx = true;
            }
            b bVar4 = this.PBX;
            if ((bVar4 == null || bVar4.PCa != 1) && (bVar = this.PBX) != null) {
                bVar.PCa = 2;
            }
            b bVar5 = this.PBX;
            if (bVar5 != null) {
                Log.v("MicroMsg.ImageScanButtonReporter", "reportFastEntryClick sessionId: %s, clickResult: %s, iconType: %d, clickIconTime: %s, clickFinishTime: %s, diff: %s", bVar5.sessionId, Integer.valueOf(bVar5.PCa), Integer.valueOf(bVar5.jjN), Long.valueOf(bVar5.PCb), Long.valueOf(bVar5.PCc), Long.valueOf(bVar5.PCc - bVar5.PCb));
                h hVar = h.INSTANCE;
                Object[] objArr = new Object[7];
                objArr[0] = bVar5.sessionId;
                objArr[1] = Integer.valueOf(bVar5.PCa);
                objArr[2] = Integer.valueOf(bVar5.jjN);
                objArr[3] = Long.valueOf(bVar5.PCb);
                objArr[4] = Long.valueOf(bVar5.PCc);
                fb fbVar = this.PBW;
                objArr[5] = fbVar != null ? fbVar.afW() : null;
                fb fbVar2 = this.PBW;
                objArr[6] = fbVar2 != null ? fbVar2.getAesKey() : null;
                hVar.a(19778, objArr);
                AppMethodBeat.o(231234);
                return;
            }
            AppMethodBeat.o(231234);
            return;
        }
        AppMethodBeat.o(231234);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010 \u001a\u00020!R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006\""}, hxF = {"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonReporter$ImageFastEntryClick;", "", "()V", "clickFinishTimestamp", "", "getClickFinishTimestamp", "()J", "setClickFinishTimestamp", "(J)V", "clickIconTimestamp", "getClickIconTimestamp", "setClickIconTimestamp", "clickResult", "", "getClickResult", "()I", "setClickResult", "(I)V", "iconType", "getIconType", "setIconType", "isReported", "", "()Z", "setReported", "(Z)V", "sessionId", "", "getSessionId", "()Ljava/lang/String;", "setSessionId", "(Ljava/lang/String;)V", "reset", "", "app_release"})
    public static final class b {
        int PCa;
        long PCb;
        long PCc;
        boolean gqx;
        int jjN;
        String sessionId = "";

        public final void setSessionId(String str) {
            AppMethodBeat.i(231226);
            p.h(str, "<set-?>");
            this.sessionId = str;
            AppMethodBeat.o(231226);
        }

        public final void reset() {
            this.sessionId = "";
            this.PCa = 0;
            this.jjN = 0;
            this.PCb = 0;
            this.PCc = 0;
            this.gqx = false;
        }
    }

    public final void anr(int i2) {
        HashMap<String, Boolean> hashMap;
        AppMethodBeat.i(231235);
        c cVar = this.PBY;
        if (cVar == null || cVar.msgId != 0) {
            String concat = "1,".concat(String.valueOf(i2));
            c cVar2 = this.PBY;
            if (p.j((cVar2 == null || (hashMap = cVar2.PCh) == null) ? null : hashMap.get(concat), Boolean.TRUE)) {
                AppMethodBeat.o(231235);
                return;
            }
            c cVar3 = this.PBY;
            if (cVar3 != null) {
                cVar3.PCh.put(concat, Boolean.TRUE);
            }
            a(i2, System.currentTimeMillis(), this.PBY);
            AppMethodBeat.o(231235);
            return;
        }
        AppMethodBeat.o(231235);
    }

    private static void a(int i2, long j2, c cVar) {
        AppMethodBeat.i(231236);
        if (cVar == null) {
            AppMethodBeat.o(231236);
            return;
        }
        com.tencent.f.h.RTc.e(new d(cVar, 1, i2, j2), "ReportSearchButtonAction");
        AppMethodBeat.o(231236);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class d implements Runnable {
        final /* synthetic */ int CFo;
        final /* synthetic */ c PCi;
        final /* synthetic */ int jAd = 1;
        final /* synthetic */ long kPc;

        d(c cVar, int i2, int i3, long j2) {
            this.PCi = cVar;
            this.CFo = i3;
            this.kPc = j2;
        }

        public final void run() {
            AppMethodBeat.i(231228);
            c cVar = this.PCi;
            if (s.YS(cVar.imagePath)) {
                String mD5String = MD5Util.getMD5String(s.aW(cVar.imagePath, 0, -1));
                p.g(mD5String, "MD5Util.getMD5String(VFS…omFile(imagePath, 0, -1))");
                p.h(mD5String, "<set-?>");
                cVar.PCf = mD5String;
                Log.v("MicroMsg.ImageScanButtonReporter", "alvinluo doReportSearchButtonAction sessionId: %s, msgId: %s, detectId: %s, action: %d, source: %d, scene: %d, chatType: %d, username: %s, chatRoomId: %s, imagePath: %s, md5: %s, serverSessionId: %s", cVar.sessionId, Long.valueOf(cVar.msgId), Long.valueOf(cVar.PCd), Integer.valueOf(this.jAd), Integer.valueOf(this.CFo), Integer.valueOf(cVar.scene), Integer.valueOf(cVar.chatType), cVar.PCe, cVar.qUK, cVar.imagePath, cVar.PCf, Long.valueOf(cVar.PCg));
                ab abVar = new ab();
                abVar.ie(this.PCi.sessionId);
                abVar.jK(this.jAd);
                abVar.jL(this.CFo);
                abVar.jM(this.PCi.scene);
                abVar.m7if(String.valueOf(this.PCi.msgId));
                abVar.jN(this.PCi.chatType);
                abVar.ih(this.PCi.qUK);
                abVar.ii(this.PCi.PCf);
                abVar.bW(this.kPc);
                abVar.bfK();
            }
            AppMethodBeat.o(231228);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u001a\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R6\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000e\"\u0004\b\u001f\u0010\u0010R\u001a\u0010 \u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000e\"\u0004\b\"\u0010\u0010R\u001a\u0010#\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u000e\"\u0004\b%\u0010\u0010R\u001a\u0010&\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001a\"\u0004\b(\u0010\u001cR\u001a\u0010)\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0014\"\u0004\b+\u0010\u0016R\u001a\u0010,\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001a\"\u0004\b.\u0010\u001cR\u001a\u0010/\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u000e\"\u0004\b1\u0010\u0010¨\u00062"}, hxF = {"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonReporter$ImageSearchButtonReportInfo;", "", "()V", "actionReported", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getActionReported", "()Ljava/util/HashMap;", "setActionReported", "(Ljava/util/HashMap;)V", "chatRoomId", "getChatRoomId", "()Ljava/lang/String;", "setChatRoomId", "(Ljava/lang/String;)V", "chatType", "", "getChatType", "()I", "setChatType", "(I)V", "detectId", "", "getDetectId", "()J", "setDetectId", "(J)V", "imageMd5", "getImageMd5", "setImageMd5", "imagePath", "getImagePath", "setImagePath", "msgFromUserName", "getMsgFromUserName", "setMsgFromUserName", "msgId", "getMsgId", "setMsgId", "scene", "getScene", "setScene", "serverSessionId", "getServerSessionId", "setServerSessionId", "sessionId", "getSessionId", "setSessionId", "app_release"})
    public static final class c {
        long PCd;
        public String PCe = "";
        String PCf = "";
        long PCg;
        public HashMap<String, Boolean> PCh = new HashMap<>();
        public int chatType;
        public String imagePath = "";
        public long msgId;
        public String qUK = "";
        public int scene;
        public String sessionId = "";

        public c() {
            AppMethodBeat.i(231227);
            AppMethodBeat.o(231227);
        }
    }
}
