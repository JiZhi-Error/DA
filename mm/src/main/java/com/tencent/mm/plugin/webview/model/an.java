package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.i.a;
import com.tencent.mm.i.g;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.f;
import com.tencent.mm.protocal.protobuf.ckt;
import com.tencent.mm.protocal.protobuf.ckv;
import com.tencent.mm.protocal.protobuf.ckz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public final class an implements i {
    private CopyOnWriteArraySet<f.b> IZg = new CopyOnWriteArraySet<>();
    private CopyOnWriteArraySet<f.a> IZh = new CopyOnWriteArraySet<>();
    private g.a iZc = new g.a() {
        /* class com.tencent.mm.plugin.webview.model.an.AnonymousClass1 */

        @Override // com.tencent.mm.i.g.a
        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            AppMethodBeat.i(78987);
            Log.i("MicroMsg.WebviewFileChooserCdnService", "getCdnAuthInfo, mediaId = %s", str);
            AppMethodBeat.o(78987);
        }

        @Override // com.tencent.mm.i.g.a
        public final byte[] f(String str, byte[] bArr) {
            AppMethodBeat.i(78988);
            Log.i("MicroMsg.WebviewFileChooserCdnService", "decodePrepareResponse, mediaId = %s", str);
            AppMethodBeat.o(78988);
            return null;
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x0043  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0088  */
        @Override // com.tencent.mm.i.g.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final int a(java.lang.String r11, int r12, com.tencent.mm.i.c r13, com.tencent.mm.i.d r14, boolean r15) {
            /*
            // Method dump skipped, instructions count: 562
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.model.an.AnonymousClass1.a(java.lang.String, int, com.tencent.mm.i.c, com.tencent.mm.i.d, boolean):int");
        }
    };

    static /* synthetic */ void a(an anVar, boolean z, int i2, String str, String str2, String str3, String str4) {
        AppMethodBeat.i(79004);
        anVar.b(z, i2, str, str2, str3, str4);
        AppMethodBeat.o(79004);
    }

    public an() {
        AppMethodBeat.i(78990);
        AppMethodBeat.o(78990);
    }

    public final void a(f.b bVar) {
        AppMethodBeat.i(78991);
        if (!(this.IZg == null || bVar == null || this.IZg.contains(bVar))) {
            this.IZg.add(bVar);
        }
        AppMethodBeat.o(78991);
    }

    public final void a(f.a aVar) {
        AppMethodBeat.i(78992);
        if (!(this.IZh == null || aVar == null || this.IZh.contains(aVar))) {
            this.IZh.add(aVar);
        }
        AppMethodBeat.o(78992);
    }

    public final void b(f.b bVar) {
        AppMethodBeat.i(78993);
        if (!(this.IZg == null || bVar == null)) {
            this.IZg.remove(bVar);
        }
        AppMethodBeat.o(78993);
    }

    public final void b(f.a aVar) {
        AppMethodBeat.i(78994);
        if (!(this.IZh == null || aVar == null)) {
            this.IZh.remove(aVar);
        }
        AppMethodBeat.o(78994);
    }

    private synchronized void b(boolean z, int i2, String str, String str2, String str3, String str4) {
        AppMethodBeat.i(78995);
        Log.d("MicroMsg.WebviewFileChooserCdnService", "notifyRequstCallback, localId : %s", str);
        if (this.IZg != null && this.IZg.size() > 0) {
            Iterator<f.b> it = this.IZg.iterator();
            while (it.hasNext()) {
                it.next().a(z, i2, str, str2, str3, str4);
            }
        }
        AppMethodBeat.o(78995);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void b(boolean z, int i2, int i3, String str, String str2) {
        AppMethodBeat.i(78996);
        Log.i("MicroMsg.WebviewFileChooserCdnService", "notifyProgressCallback, upload : %b, mediaType : %d, percent : %d, localId : %s, mediaId : %s", Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), str, str2);
        if (this.IZh != null && this.IZh.size() > 0) {
            Iterator<f.a> it = this.IZh.iterator();
            while (it.hasNext()) {
                it.next().a(z, i2, i3, str, str2);
            }
        }
        AppMethodBeat.o(78996);
    }

    public final boolean a(String str, String str2, f.b bVar) {
        AppMethodBeat.i(78997);
        WebViewJSSDKFileItem aYP = com.tencent.mm.plugin.webview.modeltools.g.gdv().aYP(str2);
        if (aYP != null) {
            aYP.appId = str;
            Log.i("MicroMsg.WebviewFileChooserCdnService", "the file item has alreay in local : appid : %s, serverId : %s, localId : %s", str, str2, aYP.dJX);
            bVar.a(true, 0, aYP.dJX, aYP.laS, null, null);
            AppMethodBeat.o(78997);
        } else {
            lZ(str, str2);
            this.IZg.add(bVar);
            AppMethodBeat.o(78997);
        }
        return true;
    }

    public final boolean a(String str, String str2, int i2, int i3, int i4, f.b bVar) {
        AppMethodBeat.i(78998);
        WebViewJSSDKFileItem aYO = com.tencent.mm.plugin.webview.modeltools.g.gdv().aYO(str2);
        if (aYO == null) {
            Log.e("MicroMsg.WebviewFileChooserCdnService", "addUploadTask get webview file chooser item  by local id failed : %s", str2);
            AppMethodBeat.o(78998);
            return false;
        }
        aYO.appId = str;
        if (bVar != null) {
            this.IZg.add(bVar);
        }
        if (i3 == 202 || i3 == 214 || i3 == 215) {
            aYO.laW = false;
        }
        aYO.laU = true;
        g gVar = new g();
        gVar.taskName = "task_WebViewJSSDKCdnService_2";
        gVar.gqy = this.iZc;
        gVar.ehd = true;
        gVar.field_mediaId = aYO.mediaId;
        gVar.field_fullpath = aYO.laR;
        gVar.field_fileType = i2;
        gVar.field_talker = "weixin";
        gVar.field_priority = a.gpM;
        if (i2 == a.gpS || i3 == 214) {
            gVar.field_needStorage = true;
        } else {
            gVar.field_needStorage = false;
        }
        gVar.field_isStreamMedia = false;
        gVar.field_appType = i3;
        gVar.field_bzScene = i4;
        gVar.field_force_aeskeycdn = true;
        gVar.field_trysafecdn = false;
        gVar.field_thumbpath = aYO.lPx;
        if (i3 == 214) {
            gVar.snsVersion = 1;
        }
        boolean f2 = com.tencent.mm.an.f.baQ().f(gVar);
        Log.i("MicroMsg.WebviewFileChooserCdnService", "summersafecdn add upload cdn task : %b, force_aeskeycdn: %b, trysafecdn: %b, localid : %s ", Boolean.valueOf(f2), Boolean.valueOf(gVar.field_force_aeskeycdn), Boolean.valueOf(gVar.field_trysafecdn), str2);
        AppMethodBeat.o(78998);
        return f2;
    }

    public final boolean b(String str, String str2, f.b bVar) {
        AppMethodBeat.i(78999);
        boolean a2 = a(str, str2, a.MediaType_FILE, 0, 0, bVar);
        AppMethodBeat.o(78999);
        return a2;
    }

    public static boolean WG(String str) {
        AppMethodBeat.i(79000);
        WebViewJSSDKFileItem aYO = com.tencent.mm.plugin.webview.modeltools.g.gdv().aYO(str);
        if (aYO == null) {
            Log.e("MicroMsg.WebviewFileChooserCdnService", "cancelUploadTask get webview file chooser item  by local id failed : %s", str);
            AppMethodBeat.o(79000);
            return false;
        }
        boolean Ob = com.tencent.mm.an.f.baQ().Ob(aYO.mediaId);
        AppMethodBeat.o(79000);
        return Ob;
    }

    public static boolean aYI(String str) {
        AppMethodBeat.i(79001);
        Log.i("MicroMsg.WebviewFileChooserCdnService", "cancelDownloadTask get webview file chooser item  by local id : %s", str);
        boolean Oc = com.tencent.mm.an.f.baQ().Oc(str);
        AppMethodBeat.o(79001);
        return Oc;
    }

    private void lZ(String str, String str2) {
        AppMethodBeat.i(79002);
        com.tencent.mm.kernel.g.azz().a(1035, this);
        com.tencent.mm.kernel.g.azz().a(new l(str, str2), 0);
        AppMethodBeat.o(79002);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        WebViewJSSDKFileItem byx;
        AppMethodBeat.i(79003);
        Log.i("MicroMsg.WebviewFileChooserCdnService", "onSceneEnd, errType = %d, errCode = %d, funcType = %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(qVar.getType()));
        switch (qVar.getType()) {
            case 1034:
                com.tencent.mm.kernel.g.azz().b(1034, this);
                ae aeVar = (ae) qVar;
                String str2 = ((ckz) aeVar.rr.iLL.iLR).Mqw;
                String str3 = aeVar.appId;
                String str4 = aeVar.dJX;
                WebViewJSSDKFileItem aYO = com.tencent.mm.plugin.webview.modeltools.g.gdv().aYO(str4);
                Object[] objArr = new Object[4];
                objArr[0] = str2;
                objArr[1] = str3;
                objArr[2] = str4;
                objArr[3] = Boolean.valueOf(aYO == null);
                Log.i("MicroMsg.WebviewFileChooserCdnService", "get server server id : %s from server for appid : %s, localId = %s, item == null ? %b", objArr);
                if (i2 != 0 || i3 != 0) {
                    Log.e("MicroMsg.WebviewFileChooserCdnService", "upload cdn info failed");
                    if (aYO != null) {
                        b(false, 0, aYO.dJX, aYO.mediaId, null, null);
                        AppMethodBeat.o(79003);
                        return;
                    }
                } else if (!Util.isNullOrNil(str3) && !Util.isNullOrNil(str2) && aYO != null) {
                    aYO.laS = str2;
                    b(true, aYO.mediaType, 100, aYO.dJX, aYO.laS);
                    b(true, 0, aYO.dJX, aYO.laS, aYO.VgI.field_fileUrl, null);
                    AppMethodBeat.o(79003);
                    return;
                }
                break;
            case 1035:
                com.tencent.mm.kernel.g.azz().b(1035, this);
                if (i2 != 0 || i3 != 0) {
                    Log.e("MicroMsg.WebviewFileChooserCdnService", "download cdn info failed");
                    b(false, 0, null, null, null, null);
                    break;
                } else {
                    l lVar = (l) qVar;
                    String str5 = lVar.appId;
                    String str6 = lVar.laS;
                    ckt ckt = ((ckv) lVar.rr.iLL.iLR).Mqx;
                    Object[] objArr2 = new Object[3];
                    objArr2[0] = str5;
                    objArr2[1] = str6;
                    objArr2[2] = Boolean.valueOf(ckt == null);
                    Log.i("MicroMsg.WebviewFileChooserCdnService", "appid = %s, serverId = %s, cdninfo == null ? %b", objArr2);
                    if (!Util.isNullOrNil(str5) && !Util.isNullOrNil(str6) && ckt != null) {
                        String str7 = ckt.type;
                        Log.i("MicroMsg.WebviewFileChooserCdnService", "cdn info type = %s", str7);
                        if (!Util.isNullOrNil(str7)) {
                            if (str7.toLowerCase().equals("voice")) {
                                byx = WebViewJSSDKFileItem.byy(ay.aZb(str5));
                            } else if (str7.toLowerCase().equals("video")) {
                                byx = WebViewJSSDKFileItem.byz(ay.aYW(new StringBuilder().append(Util.nowMilliSecond()).toString()));
                            } else {
                                byx = WebViewJSSDKFileItem.byx(ay.aYW(new StringBuilder().append(Util.nowMilliSecond()).toString()));
                            }
                            byx.laU = false;
                            byx.appId = str5;
                            byx.laS = str6;
                            if (byx.VgI == null) {
                                byx.VgI = new WebViewJSSDKFileItem.a();
                            }
                            if (ckt == null) {
                                Log.e("MicroMsg.WebViewJSSDKFileItem", "jsapidcdn info is null");
                            } else {
                                byx.VgI.field_aesKey = ckt.KRe;
                                byx.VgI.field_fileId = ckt.Mqu;
                                byx.VgI.field_fileLength = ckt.Lia;
                            }
                            com.tencent.mm.plugin.webview.modeltools.g.gdv().a(byx);
                            g gVar = new g();
                            gVar.taskName = "task_WebViewJSSDKCdnService_1";
                            gVar.gqy = this.iZc;
                            gVar.ehd = false;
                            gVar.field_mediaId = byx.mediaId;
                            gVar.field_fullpath = byx.laR;
                            gVar.field_totalLen = byx.VgI.field_fileLength;
                            gVar.field_fileType = a.MediaType_FILE;
                            gVar.field_fileId = byx.VgI.field_fileId;
                            gVar.field_aesKey = byx.VgI.field_aesKey;
                            gVar.field_priority = a.gpM;
                            gVar.field_needStorage = false;
                            gVar.field_isStreamMedia = false;
                            boolean b2 = com.tencent.mm.an.f.baQ().b(gVar, -1);
                            Log.i("MicroMsg.WebviewFileChooserCdnService", "add download cdn task : %b, localid : %s", Boolean.valueOf(b2), byx.laS);
                            if (!b2) {
                                b(false, 0, null, null, null, null);
                            }
                        }
                    }
                    AppMethodBeat.o(79003);
                    return;
                }
        }
        AppMethodBeat.o(79003);
    }
}
