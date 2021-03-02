package com.tencent.mm.plugin.card.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.f;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class a {
    private static List<WeakReference<AbstractC0901a>> pQG = new ArrayList();

    /* renamed from: com.tencent.mm.plugin.card.d.a$a  reason: collision with other inner class name */
    public interface AbstractC0901a {
        void ajH(String str);

        void cP(String str, int i2);

        void fw(String str, String str2);
    }

    static {
        AppMethodBeat.i(113736);
        AppMethodBeat.o(113736);
    }

    public static void a(AbstractC0901a aVar) {
        AppMethodBeat.i(113733);
        if (pQG == null) {
            pQG = new ArrayList();
        }
        if (aVar == null) {
            Log.e("MicroMsg.CDNDownloadHelpper", "ICDNDownloadCallback is null");
            AppMethodBeat.o(113733);
            return;
        }
        Log.i("MicroMsg.CDNDownloadHelpper", "register:%d", Integer.valueOf(aVar.hashCode()));
        pQG.add(new WeakReference<>(aVar));
        AppMethodBeat.o(113733);
    }

    public static void b(AbstractC0901a aVar) {
        AbstractC0901a aVar2;
        AppMethodBeat.i(113734);
        if (pQG == null || aVar == null) {
            AppMethodBeat.o(113734);
            return;
        }
        Log.i("MicroMsg.CDNDownloadHelpper", "unregister:%d", Integer.valueOf(aVar.hashCode()));
        for (int i2 = 0; i2 < pQG.size(); i2++) {
            WeakReference<AbstractC0901a> weakReference = pQG.get(i2);
            if (weakReference != null && (aVar2 = weakReference.get()) != null && aVar2.equals(aVar)) {
                pQG.remove(weakReference);
                AppMethodBeat.o(113734);
                return;
            }
        }
        AppMethodBeat.o(113734);
    }

    public static void g(final String str, String str2, int i2, int i3) {
        String str3;
        final String str4;
        AbstractC0901a aVar;
        AbstractC0901a aVar2;
        int i4 = 0;
        AppMethodBeat.i(113735);
        if (str == null || str2 == null || i2 == 0) {
            Log.e("MicroMsg.CDNDownloadHelpper", "the params is wrongful");
            AppMethodBeat.o(113735);
            return;
        }
        String mD5String = MD5Util.getMD5String(str);
        o oVar = new o(m.pTO);
        if (!oVar.mkdirs()) {
            Log.i("MicroMsg.CDNDownloadHelpper", "mkdirs failed.File is exist = " + oVar.exists());
        }
        if (i3 == 2) {
            str3 = ".jpeg";
        } else {
            str3 = ".mp4";
        }
        if (aa.z(oVar.her()).endsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
            str4 = aa.z(oVar.her()) + mD5String + str3;
        } else {
            str4 = aa.z(oVar.her()) + FilePathGenerator.ANDROID_DIR_SEP + mD5String + str3;
        }
        Log.i("MicroMsg.CDNDownloadHelpper", "get file path from capture file name : %s == %s", mD5String, str4);
        Log.i("MicroMsg.CDNDownloadHelpper", "before downloadVideoFromCDN fieldId:%s, aseKey:%s, dataLength:%d, type:%d, filePath:%s", str, str2, Integer.valueOf(i2), Integer.valueOf(i3), str4);
        Log.i("MicroMsg.CDNDownloadHelpper", "read file length = " + s.boW(str4));
        if (!s.YS(str4) || s.boW(str4) != ((long) i2)) {
            Log.i("MicroMsg.CDNDownloadHelpper", "filePath:%s is't exist, so download from CDN", str4);
            g gVar = new g();
            gVar.taskName = "task_CDNDownloadHelpper";
            gVar.gqy = new g.a() {
                /* class com.tencent.mm.plugin.card.d.a.AnonymousClass1 */

                @Override // com.tencent.mm.i.g.a
                public final int a(String str, int i2, c cVar, d dVar, boolean z) {
                    AbstractC0901a aVar;
                    AbstractC0901a aVar2;
                    long j2;
                    AbstractC0901a aVar3;
                    AbstractC0901a aVar4;
                    AppMethodBeat.i(113730);
                    if (i2 == -21005) {
                        Log.i("MicroMsg.CDNDownloadHelpper", "duplicate request, ignore this request, media id is %s", str);
                        AppMethodBeat.o(113730);
                        return 0;
                    } else if (i2 != 0) {
                        Log.e("MicroMsg.CDNDownloadHelpper", "start failed : %d, media id is :%s", Integer.valueOf(i2), str);
                        for (int i3 = 0; i3 < a.pQG.size(); i3++) {
                            WeakReference weakReference = (WeakReference) a.pQG.get(i3);
                            if (!(weakReference == null || (aVar4 = (AbstractC0901a) weakReference.get()) == null)) {
                                aVar4.ajH(str);
                            }
                        }
                        AppMethodBeat.o(113730);
                        return 0;
                    } else if (cVar != null) {
                        Log.i("MicroMsg.CDNDownloadHelpper", "progressInfo : %s", cVar.toString());
                        long j3 = 0;
                        if (cVar.field_toltalLength > 0) {
                            j3 = (cVar.field_finishedLength * 100) / cVar.field_toltalLength;
                        }
                        if (j3 < 0) {
                            j2 = 0;
                        } else if (j3 > 100) {
                            j2 = 100;
                        } else {
                            j2 = j3;
                        }
                        for (int i4 = 0; i4 < a.pQG.size(); i4++) {
                            WeakReference weakReference2 = (WeakReference) a.pQG.get(i4);
                            if (!(weakReference2 == null || (aVar3 = (AbstractC0901a) weakReference2.get()) == null)) {
                                aVar3.cP(str, (int) j2);
                            }
                        }
                        AppMethodBeat.o(113730);
                        return 0;
                    } else {
                        if (dVar != null) {
                            if (dVar.field_retCode != 0) {
                                Log.e("MicroMsg.CDNDownloadHelpper", "cdntra clientid:%s , sceneResult.retCode:%d , sceneResult[%s]", str, Integer.valueOf(dVar.field_retCode), dVar);
                                for (int i5 = 0; i5 < a.pQG.size(); i5++) {
                                    WeakReference weakReference3 = (WeakReference) a.pQG.get(i5);
                                    if (!(weakReference3 == null || (aVar2 = (AbstractC0901a) weakReference3.get()) == null)) {
                                        aVar2.ajH(str);
                                    }
                                }
                            } else {
                                Log.i("MicroMsg.CDNDownloadHelpper", "cdn trans suceess, sceneResult[%s]", dVar);
                                for (int i6 = 0; i6 < a.pQG.size(); i6++) {
                                    WeakReference weakReference4 = (WeakReference) a.pQG.get(i6);
                                    if (!(weakReference4 == null || (aVar = (AbstractC0901a) weakReference4.get()) == null)) {
                                        aVar.fw(str, str4);
                                    }
                                }
                            }
                        }
                        AppMethodBeat.o(113730);
                        return 0;
                    }
                }

                @Override // com.tencent.mm.i.g.a
                public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                    AppMethodBeat.i(113731);
                    Log.i("MicroMsg.CDNDownloadHelpper", "getCdnAuthInfo, mediaId = %s", str);
                    AppMethodBeat.o(113731);
                }

                @Override // com.tencent.mm.i.g.a
                public final byte[] f(String str, byte[] bArr) {
                    AppMethodBeat.i(113732);
                    Log.i("MicroMsg.CDNDownloadHelpper", "decodePrepareResponse, mediaId = %s", str);
                    AppMethodBeat.o(113732);
                    return null;
                }
            };
            gVar.ehd = false;
            gVar.field_mediaId = com.tencent.mm.an.c.a("cardgiftfile", Util.nowMilliSecond(), str, str);
            gVar.field_fullpath = str4;
            gVar.field_totalLen = i2;
            gVar.field_fileType = com.tencent.mm.i.a.gpS;
            gVar.field_fileId = str;
            gVar.field_aesKey = str2;
            gVar.field_priority = com.tencent.mm.i.a.gpM;
            gVar.field_needStorage = true;
            boolean b2 = f.baQ().b(gVar, -1);
            Log.i("MicroMsg.CDNDownloadHelpper", "add download cdn task : %b, fileId : %s", Boolean.valueOf(b2), gVar.field_fileId);
            if (!b2) {
                while (i4 < pQG.size()) {
                    WeakReference<AbstractC0901a> weakReference = pQG.get(i4);
                    if (!(weakReference == null || (aVar = weakReference.get()) == null)) {
                        aVar.ajH(str);
                    }
                    i4++;
                }
                Log.e("MicroMsg.CDNDownloadHelpper", "can't download from cdn!!!");
            }
            AppMethodBeat.o(113735);
            return;
        }
        while (i4 < pQG.size()) {
            WeakReference<AbstractC0901a> weakReference2 = pQG.get(i4);
            if (!(weakReference2 == null || (aVar2 = weakReference2.get()) == null)) {
                aVar2.fw(str, str4);
            }
            i4++;
        }
        AppMethodBeat.o(113735);
    }
}
