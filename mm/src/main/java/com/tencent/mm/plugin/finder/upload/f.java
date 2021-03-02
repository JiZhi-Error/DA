package com.tencent.mm.plugin.finder.upload;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.report.r;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.plugin.finder.video.LocalVideoCropInfoParcelable;
import com.tencent.mm.protocal.protobuf.acn;
import com.tencent.mm.protocal.protobuf.ejf;
import com.tencent.mm.protocal.protobuf.erf;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.x;

public final class f {
    static final String TAG = TAG;
    private static final String vSv = vSv;
    private static final Object vSw = new Object();
    static long vSx;
    static final List<a> vSy;
    public static final f vSz = new f();

    public interface a {
        List<String> dAY();

        String name();
    }

    static {
        AppMethodBeat.i(167748);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new b());
        arrayList.add(new c());
        vSy = arrayList;
        AppMethodBeat.o(167748);
    }

    private f() {
    }

    public static String getTAG() {
        return TAG;
    }

    private static String gW(String str, String str2) {
        AppMethodBeat.i(167738);
        p.h(str, "originFilePath");
        p.h(str2, "suffix");
        StringBuilder sb = new StringBuilder();
        al alVar = al.waC;
        String sb2 = sb.append(al.dEG()).append("video_").append(MD5Util.getMD5String(str)).append("_").append(str2).append("_thumb").toString();
        AppMethodBeat.o(167738);
        return sb2;
    }

    public static String gX(String str, String str2) {
        AppMethodBeat.i(253072);
        p.h(str, "videoFilePath");
        p.h(str2, "thumbOriginPath");
        al alVar = al.waC;
        String awD = al.awD(str);
        Log.i(TAG, "copyVideoThumbFileToPost, videoFilePath:" + str + ", thumbOriginPath:" + str2 + ", thumbPostPath:" + awD);
        i iVar = i.vSX;
        if (i.avZ(str2)) {
            Log.i(TAG, "copyImageThumbFromTmpToPost exist, copy");
            s.nw(str2, awD);
        } else {
            Log.i(TAG, "copyImageThumbFromTmpToPost not exist, generate");
            i iVar2 = i.vSX;
            Point dK = i.dK(str, 4);
            Log.i(TAG, "genVideoThumbFileTmp videoFilePath:" + str + ", targetWidth:" + dK.x + ", targetHeight:" + dK.y);
            a(str, dK.x, dK.y, (Rect) null, awD);
        }
        AppMethodBeat.o(253072);
        return awD;
    }

    public final String ag(String str, int i2, int i3) {
        AppMethodBeat.i(253073);
        p.h(str, "input");
        al alVar = al.waC;
        String a2 = a(str, al.awD(str), i2, i3, (Rect) null);
        AppMethodBeat.o(253073);
        return a2;
    }

    public static String a(String str, String str2, int i2, int i3, Rect rect) {
        AppMethodBeat.i(253074);
        p.h(str, "input");
        p.h(str2, "dstPath");
        Log.i(TAG, "genVideoThumbFileForPost input:" + str + ", targetWidth:" + i2 + ", targetHeight:" + i3 + ", thumbRect:" + rect + ", dstPath:" + str2);
        String a2 = a(str, i2, i3, rect, str2);
        AppMethodBeat.o(253074);
        return a2;
    }

    public static String a(String str, int i2, int i3, Rect rect) {
        AppMethodBeat.i(167739);
        p.h(str, "input");
        Log.i(TAG, "genVideoThumbFileTmp input:" + str + ", targetWidth:" + i2 + ", targetHeight:" + i3 + ", thumbRect:" + rect);
        String a2 = a(str, i2, i3, rect, "");
        AppMethodBeat.o(167739);
        return a2;
    }

    public static String avT(String str) {
        AppMethodBeat.i(167740);
        p.h(str, "input");
        i iVar = i.vSX;
        Point dK = i.dK(str, 4);
        Log.i(TAG, "genVideoThumbFileTmp input:" + str + ", targetWidth:" + dK.x + ", targetHeight:" + dK.y);
        String a2 = a(str, dK.x, dK.y, (Rect) null, "");
        AppMethodBeat.o(167740);
        return a2;
    }

    public final String a(String str, erf erf) {
        AppMethodBeat.i(167741);
        p.h(str, "input");
        p.h(erf, "thumbRect");
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        int i2 = com.tencent.mm.plugin.finder.storage.c.dqw().iTf;
        String a2 = a(str, i2, (int) ((((float) (erf.top - erf.bottom)) / ((float) (erf.right - erf.left))) * ((float) i2)), new Rect(erf.left, erf.top, erf.right, erf.bottom));
        AppMethodBeat.o(167741);
        return a2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0093  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(java.lang.String r10, int r11, int r12, android.graphics.Rect r13, java.lang.String r14) {
        /*
        // Method dump skipped, instructions count: 267
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.upload.f.a(java.lang.String, int, int, android.graphics.Rect, java.lang.String):java.lang.String");
    }

    public static String gY(String str, String str2) {
        AppMethodBeat.i(253075);
        p.h(str, "imagePath");
        p.h(str2, "thumbOriginPath");
        al alVar = al.waC;
        p.h(str, "imagePath");
        String str3 = al.dEH() + "image_" + MD5Util.getMD5String(str) + "_" + s.boX(str) + "_thumb";
        Log.i(TAG, "copyImageThumbFromTmpToPost, imagePath:" + str + ", thumbOriginPath:" + str2 + ", thumbPostPath:" + str3);
        i iVar = i.vSX;
        if (i.avZ(str2)) {
            Log.i(TAG, "copyImageThumbFromTmpToPost exist, copy");
            s.nw(str2, str3);
        } else {
            Log.i(TAG, "copyImageThumbFromTmpToPost not exist, generate");
            gZ(str, str3);
        }
        AppMethodBeat.o(253075);
        return str3;
    }

    public static /* synthetic */ String avU(String str) {
        AppMethodBeat.i(253076);
        p.h(str, "originFilePath");
        p.h(str, "originFilePath");
        StringBuilder sb = new StringBuilder();
        al alVar = al.waC;
        String sb2 = sb.append(al.dEG()).append("image_").append(MD5Util.getMD5String(str)).append("_").append(s.boX(str)).append("_thumb").toString();
        Log.i(TAG, "genImageThumbFileTmp " + str + ", " + sb2 + ", " + ((Object) null));
        String gZ = gZ(str, sb2);
        AppMethodBeat.o(253076);
        return gZ;
    }

    private static String gZ(String str, String str2) {
        AppMethodBeat.i(253077);
        i iVar = i.vSX;
        if (i.avZ(str2)) {
            AppMethodBeat.o(253077);
        } else {
            i iVar2 = i.vSX;
            Point dK = i.dK(str, 2);
            Bitmap createThumbCropBitmap = BitmapUtil.createThumbCropBitmap(str, dK.x, dK.y, true);
            Exif fromFile = Exif.fromFile(str);
            p.g(fromFile, "Exif.fromFile(originFilePath)");
            int orientationInDegree = fromFile.getOrientationInDegree();
            Log.i(TAG, "_genImageThumbFile, file %s rotate %d. originThumbWidth:%s, originThumbHeight:%s", str, Integer.valueOf(orientationInDegree), Integer.valueOf(dK.x), Integer.valueOf(dK.y));
            if (createThumbCropBitmap != null) {
                Log.i(TAG, "_genImageThumbFile, file %s cropThumbWidth:%s, cropThumbHeight:%s", str, Integer.valueOf(createThumbCropBitmap.getWidth()), Integer.valueOf(createThumbCropBitmap.getHeight()));
                BitmapUtil.saveBitmapToImage(createThumbCropBitmap, 70, Bitmap.CompressFormat.JPEG, str2, false);
            }
            AppMethodBeat.o(253077);
        }
        return str2;
    }

    public static void avV(String str) {
        AppMethodBeat.i(167745);
        p.h(str, "path");
        synchronized (vSw) {
            try {
                Log.i(TAG, "FinderFileTrack markPostFileToDelete ".concat(String.valueOf(str)));
                MultiProcessMMKV singleDefault = MultiProcessMMKV.getSingleDefault();
                Set<String> stringSet = singleDefault.getStringSet(vSv, new HashSet());
                if (stringSet == null) {
                    p.hyc();
                }
                stringSet.add(str);
                singleDefault.putStringSet(vSv, stringSet).commit();
            } finally {
                AppMethodBeat.o(167745);
            }
        }
    }

    public static void dAW() {
        AppMethodBeat.i(167746);
        synchronized (vSw) {
            try {
                long currentTicks = Util.currentTicks();
                MultiProcessMMKV singleDefault = MultiProcessMMKV.getSingleDefault();
                Set<String> stringSet = singleDefault.getStringSet(vSv, new HashSet());
                if (stringSet != null) {
                    for (T t : stringSet) {
                        Log.i(TAG, "FinderFileTrack clearMarkFiles ".concat(String.valueOf(t)));
                        s.deleteFile(t);
                    }
                }
                singleDefault.putStringSet(vSv, new HashSet());
                long ticksToNow = Util.ticksToNow(currentTicks);
                if (stringSet != null && stringSet.size() > 0) {
                    r.a aVar = r.a.vgH;
                    r.a.Fl(ticksToNow);
                }
                Log.i(TAG, "clearMarkFolder cost:".concat(String.valueOf(ticksToNow)));
                x xVar = x.SXb;
            } finally {
                AppMethodBeat.o(167746);
            }
        }
    }

    public static boolean dAX() {
        AppMethodBeat.i(167747);
        long aWy = cl.aWy() - vSx;
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (aWy > com.tencent.mm.plugin.finder.storage.c.drh()) {
            AppMethodBeat.o(167747);
            return true;
        }
        AppMethodBeat.o(167747);
        return false;
    }

    public static final class b implements a {
        b() {
        }

        @Override // com.tencent.mm.plugin.finder.upload.f.a
        public final String name() {
            return "unsentFileClaimer";
        }

        @Override // com.tencent.mm.plugin.finder.upload.f.a
        public final List<String> dAY() {
            LinkedList<ejf> linkedList;
            LinkedList<ejf> linkedList2;
            LinkedList<ejf> linkedList3;
            AppMethodBeat.i(253070);
            ArrayList arrayList = new ArrayList();
            for (T t : ((PluginFinder) g.ah(PluginFinder.class)).getFeedStorage().dxD()) {
                for (T t2 : t.getMediaList()) {
                    arrayList.add(t2.url);
                    arrayList.add(t2.thumbUrl);
                    arrayList.add(t2.coverUrl);
                    arrayList.add(t2.MoR);
                    acn acn = t2.MfU;
                    if (!(acn == null || (linkedList3 = acn.Lnd) == null)) {
                        Iterator<T> it = linkedList3.iterator();
                        while (it.hasNext()) {
                            arrayList.add(it.next().path);
                        }
                    }
                }
                for (T t3 : t.getHalfVideoMediaExtList()) {
                    arrayList.add(t3.url);
                    arrayList.add(t3.thumbUrl);
                    arrayList.add(t3.coverUrl);
                    arrayList.add(t3.MoR);
                    acn acn2 = t3.MfU;
                    if (!(acn2 == null || (linkedList2 = acn2.Lnd) == null)) {
                        Iterator<T> it2 = linkedList2.iterator();
                        while (it2.hasNext()) {
                            arrayList.add(it2.next().path);
                        }
                    }
                }
                Iterator<T> it3 = t.getClipListExt().iterator();
                while (it3.hasNext()) {
                    for (T t4 : it3.next().getMediaList()) {
                        arrayList.add(t4.url);
                        arrayList.add(t4.thumbUrl);
                        arrayList.add(t4.coverUrl);
                        arrayList.add(t4.MoR);
                        acn acn3 = t4.MfU;
                        if (!(acn3 == null || (linkedList = acn3.Lnd) == null)) {
                            Iterator<T> it4 = linkedList.iterator();
                            while (it4.hasNext()) {
                                arrayList.add(it4.next().path);
                            }
                        }
                    }
                }
            }
            ArrayList arrayList2 = arrayList;
            AppMethodBeat.o(253070);
            return arrayList2;
        }
    }

    public static final class c implements a {
        c() {
        }

        @Override // com.tencent.mm.plugin.finder.upload.f.a
        public final String name() {
            return "draftFileClaimer";
        }

        @Override // com.tencent.mm.plugin.finder.upload.f.a
        public final List<String> dAY() {
            AppMethodBeat.i(253071);
            ArrayList arrayList = new ArrayList();
            e aAh = g.aAh();
            p.g(aAh, "MMKernel.storage()");
            String obj = aAh.azQ().get(ar.a.USERINFO_FINDER_OPEN_UPLOAD_DRAFT_STRING_SYNC, "").toString();
            if (!Util.isNullOrNil(obj)) {
                try {
                    byte[] bqe = com.tencent.e.f.e.bqe(obj);
                    Parcel obtain = Parcel.obtain();
                    p.g(obtain, "Parcel.obtain()");
                    obtain.unmarshall(bqe, 0, bqe.length);
                    obtain.setDataPosition(0);
                    Intent intent = (Intent) Intent.CREATOR.createFromParcel(obtain);
                    intent.setExtrasClassLoader(LocalVideoCropInfoParcelable.CREATOR.getClass().getClassLoader());
                    arrayList.add(intent.getStringExtra("VIDEO_COVER_URL"));
                } catch (Exception e2) {
                    f fVar = f.vSz;
                    Log.e(f.getTAG(), String.valueOf(e2));
                }
            }
            ArrayList arrayList2 = arrayList;
            AppMethodBeat.o(253071);
            return arrayList2;
        }
    }
}
