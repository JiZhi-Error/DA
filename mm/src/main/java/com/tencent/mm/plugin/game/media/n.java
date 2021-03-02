package com.tencent.mm.plugin.game.media;

import android.database.Cursor;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.utils.d;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.game.commlib.util.b;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKImageItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem;
import com.tencent.mm.plugin.webview.model.an;
import com.tencent.mm.plugin.webview.model.f;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class n {
    private static int mRetryCount = 5;
    private static final String xBM = (b.c(b.a.ONE_MONTH) + "haowan/");
    private String jEY;
    private int retryCount;
    private LinkedList<String> xBN = new LinkedList<>();
    private boolean xBO;
    a xBP;
    private Set<String> xBQ = new HashSet();
    private Set<String> xBR = new HashSet();
    private Set<String> xBS = new HashSet();
    private HashMap<String, String> xBT = new HashMap<>();
    private boolean xBU = false;
    private boolean xBV = false;
    private HashMap<String, Long> xBW = new HashMap<>();
    private Runnable xBX = new Runnable() {
        /* class com.tencent.mm.plugin.game.media.n.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(41101);
            if (n.this.xBV) {
                AppMethodBeat.o(41101);
                return;
            }
            n.b(n.this);
            if (n.this.retryCount <= n.mRetryCount) {
                n.this.xBQ.clear();
                n.this.xBQ.addAll(n.this.xBS);
                n.this.xBS.clear();
                n.f(n.this);
                AppMethodBeat.o(41101);
                return;
            }
            Log.i("MicroMsg.Haowan.GameUploadMediaEngine", "retry count bigger than 5");
            n.g(n.this);
            AppMethodBeat.o(41101);
        }
    };
    private f.b xBY = new f.b() {
        /* class com.tencent.mm.plugin.game.media.n.AnonymousClass2 */

        @Override // com.tencent.mm.plugin.webview.model.f.b
        public final void a(final boolean z, final int i2, final String str, String str2, final String str3, final String str4) {
            AppMethodBeat.i(41103);
            if (!n.this.xBR.contains(str)) {
                Log.i("MicroMsg.Haowan.GameUploadMediaEngine", "onFinish, not in uploadingList, localId: %s", str);
                AppMethodBeat.o(41103);
                return;
            }
            n.this.xBR.remove(str);
            final long currentTimeMillis = System.currentTimeMillis() - Util.nullAs((Long) n.this.xBW.remove(str), System.currentTimeMillis());
            Log.i("MicroMsg.Haowan.GameUploadMediaEngine", "success : %b, errCode: %d, localId : %s, mediaId : %s, mediaUrl : %s, costTime: %d", Boolean.valueOf(z), Integer.valueOf(i2), str, str2, str3, Long.valueOf(currentTimeMillis));
            if (n.this.xBV) {
                Log.i("MicroMsg.Haowan.GameUploadMediaEngine", "uploadMediaFile, has cancel");
                AppMethodBeat.o(41103);
                return;
            }
            com.tencent.mm.ch.a.post(new Runnable() {
                /* class com.tencent.mm.plugin.game.media.n.AnonymousClass2.AnonymousClass1 */

                public final void run() {
                    int i2;
                    int i3;
                    AppMethodBeat.i(41102);
                    c azV = ((com.tencent.mm.plugin.game.api.f) g.af(com.tencent.mm.plugin.game.api.f.class)).dSO().azV(str);
                    HashMap hashMap = new HashMap();
                    if (azV != null) {
                        hashMap.put("type", Integer.valueOf(n.Oh(azV.field_mediaType)));
                        if (n.Oh(azV.field_mediaType) == 2) {
                            hashMap.put("videoid", s.bhK(azV.field_filePath));
                        }
                    }
                    hashMap.put("costtime", Long.valueOf(currentTimeMillis));
                    hashMap.put("origtime", Integer.valueOf(azV.field_duration));
                    hashMap.put("origsize", Long.valueOf(azV.field_size));
                    e azX = ((com.tencent.mm.plugin.game.api.f) g.af(com.tencent.mm.plugin.game.api.f.class)).dSN().azX(n.this.jEY);
                    if (azX != null) {
                        hashMap.put("pushid", azX.field_taskId);
                        int i4 = azX.field_publishSource;
                        i2 = azX.field_sourceSceneId;
                        i3 = i4;
                    } else {
                        i2 = 0;
                        i3 = 0;
                    }
                    if (z) {
                        n.this.xBS.remove(str);
                        d dSO = ((com.tencent.mm.plugin.game.api.f) g.af(com.tencent.mm.plugin.game.api.f.class)).dSO();
                        String format = String.format("update %s set %s=\"%s\", %s=\"%s\", %s=%d where %s=\"%s\"", "GameHaowanMedia", "mediaUrl", str3, "thumbPicUrl", str4, "uploadState", 2, ch.COL_LOCALID, str);
                        Log.i("MicroMsg.Haowan.GameHaowanPublishStorage", "updateMediaUrl, sql: ".concat(String.valueOf(format)));
                        dSO.execSQL("GameHaowanMedia", format);
                        com.tencent.mm.game.report.b.a.a(MMApplicationContext.getContext(), 8764, 0, 48, i2, com.tencent.mm.game.report.b.a.c(i3, hashMap));
                    } else if (i2 != -21006) {
                        n.this.xBS.add(str);
                        hashMap.put("failid", Integer.valueOf(i2));
                        com.tencent.mm.game.report.b.a.a(MMApplicationContext.getContext(), 8764, 0, 56, i2, com.tencent.mm.game.report.b.a.c(i3, hashMap));
                    }
                    Log.i("MicroMsg.Haowan.GameUploadMediaEngine", "upload list size : %d, hasPushAllUpload: %b", Integer.valueOf(n.this.xBR.size()), Boolean.valueOf(n.this.xBU));
                    if (n.this.xBR.isEmpty() && n.this.xBU) {
                        if (!n.this.xBS.isEmpty()) {
                            h.RTc.o(n.this.xBX, Util.MILLSECONDS_OF_MINUTE);
                            AppMethodBeat.o(41102);
                            return;
                        }
                        n.m(n.this);
                    }
                    AppMethodBeat.o(41102);
                }
            });
            AppMethodBeat.o(41103);
        }
    };
    private f.a xBZ = new f.a() {
        /* class com.tencent.mm.plugin.game.media.n.AnonymousClass3 */

        @Override // com.tencent.mm.plugin.webview.model.f.a
        public final void a(boolean z, int i2, int i3, String str, String str2) {
            AppMethodBeat.i(41104);
            if (!n.this.xBR.contains(str)) {
                Log.i("MicroMsg.Haowan.GameUploadMediaEngine", "onFinish, not in uploadingList, localId: %s", str);
                AppMethodBeat.o(41104);
                return;
            }
            int size = n.this.xBN.size();
            int size2 = n.this.xBR.size() + n.this.xBS.size();
            float f2 = 0.95f * ((((float) (size - size2)) / ((float) size)) + ((1.0f / ((float) size)) * (((float) i3) / 100.0f)));
            Log.i("MicroMsg.Haowan.GameUploadMediaEngine", "onProgress, localId : %s, percent : %d, initSize : %d, uploadingSize : %d, uploadProgress : %f", str, Integer.valueOf(i3), Integer.valueOf(size), Integer.valueOf(size2), Float.valueOf(f2));
            n.a(n.this, f2);
            AppMethodBeat.o(41104);
        }
    };

    /* access modifiers changed from: package-private */
    public interface a {
        void pM(boolean z);
    }

    static /* synthetic */ int Oh(int i2) {
        if (i2 == 4) {
            return 2;
        }
        if (i2 != 1) {
            return 0;
        }
        return 1;
    }

    static /* synthetic */ int b(n nVar) {
        int i2 = nVar.retryCount + 1;
        nVar.retryCount = i2;
        return i2;
    }

    static /* synthetic */ void f(n nVar) {
        AppMethodBeat.i(41115);
        nVar.dUy();
        AppMethodBeat.o(41115);
    }

    static /* synthetic */ void m(n nVar) {
        AppMethodBeat.i(41117);
        nVar.dUA();
        AppMethodBeat.o(41117);
    }

    static {
        AppMethodBeat.i(41119);
        AppMethodBeat.o(41119);
    }

    public n(String str, int i2, LinkedList<String> linkedList, boolean z) {
        boolean z2;
        boolean z3 = false;
        AppMethodBeat.i(41106);
        this.jEY = str;
        this.xBO = z;
        if (Util.isNullOrNil(linkedList)) {
            AppMethodBeat.o(41106);
            return;
        }
        if (i2 == 2) {
            this.xBN.add(linkedList.get(0));
        } else {
            this.xBN.addAll(linkedList);
        }
        d dSO = ((com.tencent.mm.plugin.game.api.f) g.af(com.tencent.mm.plugin.game.api.f.class)).dSO();
        if (str != null) {
            Cursor rawQuery = dSO.rawQuery(String.format("select * from %s where %s=\"%s\"", "GameHaowanMedia", "hostTaskId", str), new String[0]);
            if (rawQuery != null) {
                if (rawQuery.getCount() != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                rawQuery.close();
                z3 = z2;
            }
        }
        if (!z3) {
            dUw();
        }
        com.tencent.mm.plugin.webview.modeltools.g.gdu().a(this.xBY);
        com.tencent.mm.plugin.webview.modeltools.g.gdu().a(this.xBZ);
        AppMethodBeat.o(41106);
    }

    private void dUw() {
        AppMethodBeat.i(41107);
        Iterator<String> it = this.xBN.iterator();
        while (it.hasNext()) {
            String next = it.next();
            WebViewJSSDKFileItem aYO = com.tencent.mm.plugin.webview.modeltools.g.gdv().aYO(next);
            if (aYO != null) {
                c cVar = new c();
                cVar.field_localId = aYO.dJX;
                cVar.field_mediaId = aYO.mediaId;
                cVar.field_filePath = aYO.laR;
                cVar.field_thumbPath = aYO.lPx;
                cVar.field_mediaType = aYO.mediaType;
                cVar.field_size = (long) aYO.size;
                cVar.field_width = aYO.width;
                cVar.field_height = aYO.height;
                cVar.field_editFlag = aYO.jkf.getInt("mark_edit_flag", 0);
                if (aYO instanceof WebViewJSSDKVideoItem) {
                    cVar.field_duration = ((WebViewJSSDKVideoItem) aYO).duration;
                }
                if (aYO instanceof WebViewJSSDKImageItem) {
                    cVar.field_isGif = ((WebViewJSSDKImageItem) aYO).xlR;
                }
                cVar.field_hostTaskId = this.jEY;
                if (aYO.mediaType == 1) {
                    String str = xBM + "microMsg.compress." + System.currentTimeMillis() + (Util.nullAsNil(next).hashCode() & 65535);
                    if (!this.xBO || !hF(str, aYO.laR)) {
                        cVar.field_compressPath = aYO.laR;
                    } else {
                        cVar.field_compressPath = str;
                        Log.i("MicroMsg.Haowan.GameUploadMediaEngine", "compress, originSize: %d, dstSize: %d", Long.valueOf(s.boW(aYO.laR)), Long.valueOf(s.boW(cVar.field_compressPath)));
                        aYO.laR = str;
                        com.tencent.mm.plugin.webview.modeltools.g.gdv().a(aYO);
                    }
                }
                ((com.tencent.mm.plugin.game.api.f) g.af(com.tencent.mm.plugin.game.api.f.class)).dSO().insert(cVar);
            }
        }
        AppMethodBeat.o(41107);
    }

    public final synchronized void dUx() {
        AppMethodBeat.i(41108);
        mRetryCount = ((com.tencent.mm.game.report.a.b) g.af(com.tencent.mm.game.report.a.b.class)).a(b.a.clicfg_game_haowan_publish_retry_num_android, 5);
        this.xBQ.clear();
        this.xBQ.addAll(this.xBN);
        dUy();
        AppMethodBeat.o(41108);
    }

    private synchronized void dUy() {
        AppMethodBeat.i(41109);
        if (this.xBV) {
            AppMethodBeat.o(41109);
        } else {
            this.xBR.addAll(this.xBQ);
            Log.i("MicroMsg.Haowan.GameUploadMediaEngine", "upload, list : %s", this.xBR.toString());
            this.xBU = false;
            synchronized (this.xBQ) {
                try {
                    Iterator<String> it = this.xBQ.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            String next = it.next();
                            if (!this.xBV) {
                                c azV = ((com.tencent.mm.plugin.game.api.f) g.af(com.tencent.mm.plugin.game.api.f.class)).dSO().azV(next);
                                if (azV == null || azV.field_localId == null || !Util.isNullOrNil(azV.field_mediaUrl)) {
                                    Log.i("MicroMsg.Haowan.GameUploadMediaEngine", "upload, remvoe: %s", next);
                                    this.xBR.remove(next);
                                } else {
                                    if (com.tencent.mm.plugin.webview.modeltools.g.gdv().aYO(next) == null) {
                                        if (azV.field_mediaType == 1) {
                                            WebViewJSSDKImageItem webViewJSSDKImageItem = new WebViewJSSDKImageItem();
                                            webViewJSSDKImageItem.dJX = azV.field_localId;
                                            webViewJSSDKImageItem.mediaId = azV.field_mediaId;
                                            if (!this.xBO || s.YS(azV.field_compressPath)) {
                                                webViewJSSDKImageItem.laR = azV.field_filePath;
                                            } else {
                                                String str = xBM + "microMsg.compress." + System.currentTimeMillis() + (Util.nullAsNil(next).hashCode() & 65535);
                                                if (hF(str, azV.field_filePath)) {
                                                    azV.field_compressPath = str;
                                                } else {
                                                    azV.field_compressPath = azV.field_filePath;
                                                }
                                                webViewJSSDKImageItem.laR = azV.field_compressPath;
                                            }
                                            webViewJSSDKImageItem.lPx = azV.field_thumbPath;
                                            com.tencent.mm.plugin.webview.modeltools.g.gdv().a(webViewJSSDKImageItem);
                                        } else if (azV.field_mediaType == 4) {
                                            WebViewJSSDKVideoItem webViewJSSDKVideoItem = new WebViewJSSDKVideoItem();
                                            webViewJSSDKVideoItem.dJX = azV.field_localId;
                                            webViewJSSDKVideoItem.mediaId = azV.field_mediaId;
                                            webViewJSSDKVideoItem.laR = azV.field_filePath;
                                            webViewJSSDKVideoItem.lPx = azV.field_thumbPath;
                                            webViewJSSDKVideoItem.duration = azV.field_duration;
                                            webViewJSSDKVideoItem.width = azV.field_width;
                                            webViewJSSDKVideoItem.height = azV.field_height;
                                            webViewJSSDKVideoItem.size = (int) azV.field_size;
                                            com.tencent.mm.plugin.webview.modeltools.g.gdv().a(webViewJSSDKVideoItem);
                                        }
                                    }
                                    switch (azV.field_mediaType) {
                                        case 1:
                                            if (!ao(next, com.tencent.mm.i.a.gpU, 215)) {
                                                Log.i("MicroMsg.Haowan.GameUploadMediaEngine", "upload, ret is false, remvoe: %s", next);
                                                this.xBR.remove(next);
                                                break;
                                            } else {
                                                continue;
                                            }
                                        case 4:
                                            if (!ao(next, com.tencent.mm.i.a.gpV, 214)) {
                                                Log.i("MicroMsg.Haowan.GameUploadMediaEngine", "upload, ret is false, remvoe: %s", next);
                                                this.xBR.remove(next);
                                                break;
                                            } else {
                                                continue;
                                            }
                                    }
                                }
                            }
                        } else {
                            this.xBU = true;
                            if (this.xBR.isEmpty()) {
                                dUA();
                            }
                            AppMethodBeat.o(41109);
                        }
                    }
                } finally {
                    AppMethodBeat.o(41109);
                }
            }
        }
    }

    private boolean ao(final String str, int i2, int i3) {
        AppMethodBeat.i(41110);
        this.xBW.put(str, Long.valueOf(System.currentTimeMillis()));
        Log.i("MicroMsg.Haowan.GameUploadMediaEngine", "uploadMediaFile, localId : %s", str);
        com.tencent.mm.ch.a.post(new Runnable() {
            /* class com.tencent.mm.plugin.game.media.n.AnonymousClass4 */

            public final void run() {
                int i2;
                int i3;
                AppMethodBeat.i(41105);
                HashMap hashMap = new HashMap();
                c azV = ((com.tencent.mm.plugin.game.api.f) g.af(com.tencent.mm.plugin.game.api.f.class)).dSO().azV(str);
                if (azV != null) {
                    hashMap.put("type", Integer.valueOf(n.Oh(azV.field_mediaType)));
                    if (n.Oh(azV.field_mediaType) == 2) {
                        hashMap.put("videoid", s.bhK(azV.field_filePath));
                    }
                }
                e azX = ((com.tencent.mm.plugin.game.api.f) g.af(com.tencent.mm.plugin.game.api.f.class)).dSN().azX(n.this.jEY);
                if (azX != null) {
                    hashMap.put("pushid", azX.field_taskId);
                    int i4 = azX.field_publishSource;
                    i2 = azX.field_sourceSceneId;
                    i3 = i4;
                } else {
                    i2 = 0;
                    i3 = 0;
                }
                com.tencent.mm.game.report.b.a.a(MMApplicationContext.getContext(), 8764, 0, 20, i2, com.tencent.mm.game.report.b.a.c(i3, hashMap));
                AppMethodBeat.o(41105);
            }
        });
        boolean a2 = com.tencent.mm.plugin.webview.modeltools.g.gdu().a("", str, i2, i3, 2, null);
        AppMethodBeat.o(41110);
        return a2;
    }

    public final void dUz() {
        AppMethodBeat.i(41111);
        this.xBV = true;
        Iterator<String> it = this.xBN.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.webview.modeltools.g.gdu();
            an.WG(it.next());
        }
        ((com.tencent.mm.plugin.game.api.f) g.af(com.tencent.mm.plugin.game.api.f.class)).dSO().aR(this.xBN);
        reset();
        AppMethodBeat.o(41111);
    }

    public final void reset() {
        AppMethodBeat.i(41112);
        com.tencent.mm.plugin.webview.modeltools.g.gdu().b(this.xBY);
        com.tencent.mm.plugin.webview.modeltools.g.gdu().b(this.xBZ);
        this.xBQ.clear();
        this.xBS.clear();
        this.xBR.clear();
        this.xBN.clear();
        this.xBP = null;
        AppMethodBeat.o(41112);
    }

    private void dUA() {
        AppMethodBeat.i(41113);
        if (this.xBP != null) {
            this.xBP.pM(true);
        }
        AppMethodBeat.o(41113);
    }

    private static boolean hF(String str, String str2) {
        AppMethodBeat.i(41114);
        if (ImgUtil.isGif(str2)) {
            AppMethodBeat.o(41114);
            return false;
        }
        try {
            boolean f2 = d.f(str, str2, 1440, 1080);
            if (f2) {
                s.deleteFile(str2);
            }
            AppMethodBeat.o(41114);
            return f2;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Haowan.GameUploadMediaEngine", e2, "", new Object[0]);
            AppMethodBeat.o(41114);
            return false;
        }
    }

    static /* synthetic */ void g(n nVar) {
        AppMethodBeat.i(41116);
        Iterator<String> it = nVar.xBS.iterator();
        while (it.hasNext()) {
            d dSO = ((com.tencent.mm.plugin.game.api.f) g.af(com.tencent.mm.plugin.game.api.f.class)).dSO();
            String format = String.format("update %s set %s=%d where %s=\"%s\"", "GameHaowanMedia", "uploadState", 1, ch.COL_LOCALID, it.next());
            Log.i("MicroMsg.Haowan.GameHaowanPublishStorage", "updateUploadSuccess, sql: ".concat(String.valueOf(format)));
            dSO.execSQL("GameHaowanMedia", format);
        }
        nVar.xBS.clear();
        if (nVar.xBP != null) {
            nVar.xBP.pM(false);
        }
        AppMethodBeat.o(41116);
    }

    static /* synthetic */ void a(n nVar, float f2) {
        AppMethodBeat.i(41118);
        com.tencent.mm.plugin.game.api.a.e(nVar.jEY, f2);
        AppMethodBeat.o(41118);
    }
}
