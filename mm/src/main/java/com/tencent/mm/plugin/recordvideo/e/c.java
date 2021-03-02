package com.tencent.mm.plugin.recordvideo.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.s;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TimeZone;
import kotlin.g.b.p;

public final class c {
    private static final String ChZ;
    private static final String Cia = (ChZ + "temp/");
    private static final String Cib = (ChZ + "mix/");
    public static final c Cic = new c();
    private static final MultiProcessMMKV cQe = MultiProcessMMKV.getMMKV("media_file_key");

    static {
        AppMethodBeat.i(76218);
        StringBuilder sb = new StringBuilder();
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        ChZ = sb.append(aAh.getAccPath()).append("recordPlugin/").toString();
        AppMethodBeat.o(76218);
    }

    private c() {
    }

    public static void aLC(String str) {
        AppMethodBeat.i(237981);
        Log.i("MicroMsg.MediaFileUtil", "markTimingDeleteFile file ".concat(String.valueOf(str)));
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(237981);
            return;
        }
        Set<String> decodeStringSet = cQe.decodeStringSet("media_timing_delete_set", new HashSet());
        decodeStringSet.add(str);
        cQe.encode("media_timing_delete_set", decodeStringSet);
        AppMethodBeat.o(237981);
    }

    /* access modifiers changed from: package-private */
    public static final class a implements Runnable {
        public static final a Cid = new a();

        static {
            AppMethodBeat.i(237976);
            AppMethodBeat.o(237976);
        }

        a() {
        }

        public final void run() {
            AppMethodBeat.i(237975);
            c cVar = c.Cic;
            Set<String> decodeStringSet = c.cQe.decodeStringSet("media_file_delete_set", new HashSet());
            p.g(decodeStringSet, "set");
            Iterator<T> it = decodeStringSet.iterator();
            while (it.hasNext()) {
                s.deleteFile(it.next());
            }
            decodeStringSet.clear();
            c cVar2 = c.Cic;
            c.cQe.encode("media_timing_delete_set", decodeStringSet);
            AppMethodBeat.o(237975);
        }
    }

    public static void eMH() {
        AppMethodBeat.i(237982);
        com.tencent.f.h.RTc.aX(a.Cid);
        AppMethodBeat.o(237982);
    }

    public static void jD(String str, String str2) {
        AppMethodBeat.i(76188);
        Log.i("MicroMsg.MediaFileUtil", "cache delete key: " + str + " , file " + str2);
        if (str == null || str2 == null) {
            AppMethodBeat.o(76188);
            return;
        }
        cQe.encode(str, str2);
        AppMethodBeat.o(76188);
    }

    public static void aLD(String str) {
        AppMethodBeat.i(76189);
        if (str != null) {
            String decodeString = cQe.decodeString(str, "");
            if (!TextUtils.isEmpty(decodeString)) {
                com.tencent.f.h.RTc.b(new e(decodeString), "MediaFileUtil_deleteMediaFile");
            }
        }
        AppMethodBeat.o(76189);
    }

    /* access modifiers changed from: package-private */
    public static final class e implements Runnable {
        final /* synthetic */ String msC;

        e(String str) {
            this.msC = str;
        }

        public final void run() {
            AppMethodBeat.i(76180);
            Log.i("MicroMsg.MediaFileUtil", "deleteMediaFile file:" + this.msC);
            s.deleteFile(this.msC);
            AppMethodBeat.o(76180);
        }
    }

    public static void aLE(String str) {
        AppMethodBeat.i(76190);
        if (!TextUtils.isEmpty(str)) {
            Log.i("MicroMsg.MediaFileUtil", "cache delete file ".concat(String.valueOf(str)));
            Set<String> decodeStringSet = cQe.decodeStringSet("media_file_delete_set", new HashSet());
            decodeStringSet.add(str);
            cQe.encode("media_file_delete_set", decodeStringSet);
        }
        AppMethodBeat.o(76190);
    }

    public static void aLF(String str) {
        AppMethodBeat.i(76191);
        if (!TextUtils.isEmpty(str)) {
            Set<String> decodeStringSet = cQe.decodeStringSet("media_file_delete_set", new HashSet());
            if (decodeStringSet.contains(str)) {
                decodeStringSet.remove(str);
                if (!TextUtils.isEmpty(str)) {
                    com.tencent.f.h.RTc.b(new f(str), "MediaFileUtil_deleteMediaFile");
                }
            }
        }
        AppMethodBeat.o(76191);
    }

    /* access modifiers changed from: package-private */
    public static final class f implements Runnable {
        final /* synthetic */ String msC;

        f(String str) {
            this.msC = str;
        }

        public final void run() {
            AppMethodBeat.i(76181);
            Log.i("MicroMsg.MediaFileUtil", "deleteMediaFile file:" + this.msC);
            s.deleteFile(this.msC);
            AppMethodBeat.o(76181);
        }
    }

    public static void aHD(String str) {
        AppMethodBeat.i(76192);
        if (!TextUtils.isEmpty(str)) {
            com.tencent.f.h.RTc.b(new d(str), "MediaFileUtil_deleteMediaFile");
        }
        AppMethodBeat.o(76192);
    }

    public static final class d implements Runnable {
        final /* synthetic */ String msC;

        d(String str) {
            this.msC = str;
        }

        public final void run() {
            AppMethodBeat.i(76179);
            Log.i("MicroMsg.MediaFileUtil", "deleteMediaFile file:" + this.msC);
            s.deleteFile(this.msC);
            AppMethodBeat.o(76179);
        }
    }

    public static void aLG(String str) {
        AppMethodBeat.i(76193);
        if (!TextUtils.isEmpty(str)) {
            if (str != null) {
                p.g(com.tencent.mm.modelvideo.o.bhi(), "SubCoreVideo.getCore()");
                String accVideoPath = com.tencent.mm.modelvideo.o.getAccVideoPath();
                p.g(accVideoPath, "SubCoreVideo.getCore().accVideoPath");
                if (kotlin.n.n.a((CharSequence) str, (CharSequence) accVideoPath, false)) {
                    aHD(str);
                }
            } else {
                AppMethodBeat.o(76193);
                return;
            }
        }
        AppMethodBeat.o(76193);
    }

    public static void aL(ArrayList<String> arrayList) {
        AppMethodBeat.i(76194);
        p.h(arrayList, "imagePathList");
        for (T t : arrayList) {
            if (t != null && kotlin.n.n.a((CharSequence) t, (CharSequence) "photoEdited_", false)) {
                Log.i("MicroMsg.MediaFileUtil", "markDeletePhotoEditFile: ".concat(String.valueOf(t)));
                aLE(t);
            }
        }
        AppMethodBeat.o(76194);
    }

    public static void aLH(String str) {
        AppMethodBeat.i(76195);
        if (str != null) {
            if (kotlin.n.n.a((CharSequence) str, (CharSequence) "photoEdited_", false)) {
                Log.i("MicroMsg.MediaFileUtil", "markDeletePhotoEditFile: ".concat(String.valueOf(str)));
                aLE(str);
            }
            AppMethodBeat.o(76195);
            return;
        }
        AppMethodBeat.o(76195);
    }

    public static void jE(String str, String str2) {
        AppMethodBeat.i(76196);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            AppMethodBeat.o(76196);
            return;
        }
        if (str2 == null) {
            p.hyc();
        }
        if (kotlin.n.n.a((CharSequence) str2, (CharSequence) "photoEdited_", false)) {
            jD(str, str2);
        }
        AppMethodBeat.o(76196);
    }

    public static void d(RecordConfigProvider recordConfigProvider) {
        AppMethodBeat.i(76197);
        p.h(recordConfigProvider, "configProvider");
        if (TextUtils.isEmpty(recordConfigProvider.BOC)) {
            StringBuilder sb = new StringBuilder();
            p.g(com.tencent.mm.modelvideo.o.bhi(), "SubCoreVideo.getCore()");
            recordConfigProvider.BOC = sb.append(com.tencent.mm.modelvideo.o.getAccVideoPath()).append("/vsg_output_").append(System.currentTimeMillis()).toString();
        }
        AppMethodBeat.o(76197);
    }

    public static void e(RecordConfigProvider recordConfigProvider) {
        AppMethodBeat.i(76198);
        p.h(recordConfigProvider, "configProvider");
        if (TextUtils.isEmpty(recordConfigProvider.thumbPath)) {
            StringBuilder sb = new StringBuilder();
            p.g(com.tencent.mm.modelvideo.o.bhi(), "SubCoreVideo.getCore()");
            recordConfigProvider.thumbPath = sb.append(com.tencent.mm.modelvideo.o.getAccVideoPath()).append("/vsg_thumb_").append(System.currentTimeMillis()).toString();
        }
        if (TextUtils.isEmpty(recordConfigProvider.BOA)) {
            StringBuilder sb2 = new StringBuilder();
            p.g(com.tencent.mm.modelvideo.o.bhi(), "SubCoreVideo.getCore()");
            recordConfigProvider.BOA = sb2.append(com.tencent.mm.modelvideo.o.getAccVideoPath()).append("/vsg_output_").append(System.currentTimeMillis()).toString();
        }
        AppMethodBeat.o(76198);
    }

    public static String eMI() {
        AppMethodBeat.i(76199);
        p.g(com.tencent.mm.modelvideo.o.bhi(), "SubCoreVideo.getCore()");
        String aFj = com.tencent.mm.plugin.mmsight.d.aFj(com.tencent.mm.modelvideo.o.getAccVideoPath());
        p.g(aFj, "MMSightUtil.getTempFileN…o.getCore().accVideoPath)");
        AppMethodBeat.o(76199);
        return aFj;
    }

    public static String eMJ() {
        AppMethodBeat.i(237983);
        p.g(com.tencent.mm.modelvideo.o.bhi(), "SubCoreVideo.getCore()");
        String bhr = com.tencent.mm.modelvideo.o.bhr();
        p.g(bhr, "SubCoreVideo.getCore().subVideoPath");
        AppMethodBeat.o(237983);
        return bhr;
    }

    public static String aLI(String str) {
        AppMethodBeat.i(76200);
        p.h(str, "videoPath");
        String aFl = com.tencent.mm.plugin.mmsight.d.aFl(str);
        p.g(aFl, "MMSightUtil.getThumbName(videoPath)");
        AppMethodBeat.o(76200);
        return aFl;
    }

    public static String eMK() {
        AppMethodBeat.i(76201);
        String str = "photoEdited_" + System.currentTimeMillis();
        String k2 = s.k("wcf://temp/".concat(String.valueOf(str)), true);
        if (k2 == null) {
            StringBuilder sb = new StringBuilder();
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            File cacheDir = context.getCacheDir();
            p.g(cacheDir, "MMApplicationContext.getContext().cacheDir");
            k2 = sb.append(cacheDir.getAbsolutePath()).append('/').append(str).toString();
        }
        AppMethodBeat.o(76201);
        return k2;
    }

    public static String eML() {
        AppMethodBeat.i(76202);
        String str = "photoCapture_" + System.currentTimeMillis();
        String k2 = s.k("wcf://temp/".concat(String.valueOf(str)), true);
        if (k2 == null) {
            StringBuilder sb = new StringBuilder();
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            File cacheDir = context.getCacheDir();
            p.g(cacheDir, "MMApplicationContext.getContext().cacheDir");
            k2 = sb.append(cacheDir.getAbsolutePath()).append('/').append(str).toString();
        }
        AppMethodBeat.o(76202);
        return k2;
    }

    public static void a(RecordConfigProvider recordConfigProvider, boolean z, boolean z2) {
        AppMethodBeat.i(76203);
        Log.i("MicroMsg.MediaFileUtil", "configProvider : " + recordConfigProvider + "  isCaptureMedia:" + z + "   change:" + z2);
        if (recordConfigProvider != null) {
            com.tencent.f.h.RTc.b(new l(recordConfigProvider, recordConfigProvider, z, z2), "mux_save_work");
            AppMethodBeat.o(76203);
            return;
        }
        AppMethodBeat.o(76203);
    }

    public static final class l implements Runnable {
        final /* synthetic */ RecordConfigProvider BSb;
        final /* synthetic */ boolean Cii;
        final /* synthetic */ RecordConfigProvider Cij;
        final /* synthetic */ boolean Cik;

        l(RecordConfigProvider recordConfigProvider, RecordConfigProvider recordConfigProvider2, boolean z, boolean z2) {
            this.BSb = recordConfigProvider;
            this.Cij = recordConfigProvider2;
            this.Cii = z;
            this.Cik = z2;
        }

        public final void run() {
            AppMethodBeat.i(76185);
            if (!this.Cij.BOx) {
                s.deleteFile(this.BSb.BOz);
            }
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            p.g(aAh, "MMKernel.storage()");
            boolean z = aAh.azQ().getBoolean(ar.a.USERINFO_WEIXIN_CAMERASAVEVIDEO_STATE_BOOLEAN, true);
            Log.i("MicroMsg.MediaFileUtil", "videoState : " + z + ' ');
            if (!z) {
                AppMethodBeat.o(76185);
                return;
            }
            if (this.Cii || (!this.Cii && this.Cij.BOy && this.Cik)) {
                String exportImagePath = com.tencent.mm.plugin.mmsight.d.getExportImagePath("mp4");
                if (!this.Cii) {
                    exportImagePath = AndroidMediaUtil.getExportImagePath("mp4");
                }
                Log.i("MicroMsg.MediaFileUtil", "auto save video :".concat(String.valueOf(exportImagePath)));
                s.nw(this.BSb.BOA, exportImagePath);
                AndroidMediaUtil.refreshMediaScanner(exportImagePath, MMApplicationContext.getContext());
            }
            AppMethodBeat.o(76185);
        }
    }

    public static void c(CaptureDataManager.CaptureVideoNormalModel captureVideoNormalModel) {
        AppMethodBeat.i(76204);
        if (captureVideoNormalModel == null || !captureVideoNormalModel.eJG().booleanValue()) {
            AppMethodBeat.o(76204);
            return;
        }
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        if (!aAh.azQ().getBoolean(ar.a.USERINFO_WEIXIN_CAMERASAVEVIDEO_STATE_BOOLEAN, true)) {
            AppMethodBeat.o(76204);
            return;
        }
        com.tencent.f.h.RTc.b(new n(captureVideoNormalModel), "mux_save_work");
        AppMethodBeat.o(76204);
    }

    /* access modifiers changed from: package-private */
    public static final class n implements Runnable {
        final /* synthetic */ CaptureDataManager.CaptureVideoNormalModel BKd;

        n(CaptureDataManager.CaptureVideoNormalModel captureVideoNormalModel) {
            this.BKd = captureVideoNormalModel;
        }

        public final void run() {
            AppMethodBeat.i(76187);
            String exportImagePath = AndroidMediaUtil.getExportImagePath("mp4");
            s.nw(this.BKd.getVideoPath(), exportImagePath);
            AndroidMediaUtil.refreshMediaScanner(exportImagePath, MMApplicationContext.getContext());
            AppMethodBeat.o(76187);
        }
    }

    public static void a(ald ald) {
        AppMethodBeat.i(76205);
        if (ald != null) {
            com.tencent.f.h.RTc.b(new m(ald), "mux_save_work");
        }
        AppMethodBeat.o(76205);
    }

    /* access modifiers changed from: package-private */
    public static final class m implements Runnable {
        final /* synthetic */ ald Cil;

        m(ald ald) {
            this.Cil = ald;
        }

        public final void run() {
            AppMethodBeat.i(76186);
            if (!this.Cil.BOx) {
                s.deleteFile(this.Cil.BOz);
            }
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            p.g(aAh, "MMKernel.storage()");
            if (!aAh.azQ().getBoolean(ar.a.USERINFO_WEIXIN_CAMERASAVEVIDEO_STATE_BOOLEAN, true)) {
                AppMethodBeat.o(76186);
                return;
            }
            if (this.Cil.Lud || (!this.Cil.Lud && this.Cil.BOy && this.Cil.Gvu)) {
                String exportImagePath = com.tencent.mm.plugin.mmsight.d.getExportImagePath("mp4");
                if (!this.Cil.Lud) {
                    exportImagePath = AndroidMediaUtil.getExportImagePath("mp4");
                }
                s.nw(this.Cil.BOA, exportImagePath);
                AndroidMediaUtil.refreshMediaScanner(exportImagePath, MMApplicationContext.getContext());
            }
            AppMethodBeat.o(76186);
        }
    }

    public static void b(RecordConfigProvider recordConfigProvider, boolean z, boolean z2) {
        AppMethodBeat.i(76206);
        Log.i("MicroMsg.MediaFileUtil", "configProvider : " + recordConfigProvider + "  isCaptureMedia:" + z + "   change:" + z2);
        if (recordConfigProvider != null) {
            com.tencent.f.h.RTc.b(new k(recordConfigProvider, z, recordConfigProvider, z2), "mux_save_work");
            AppMethodBeat.o(76206);
            return;
        }
        AppMethodBeat.o(76206);
    }

    public static final class k implements Runnable {
        final /* synthetic */ RecordConfigProvider BSb;
        final /* synthetic */ boolean Cii;
        final /* synthetic */ RecordConfigProvider Cij;
        final /* synthetic */ boolean Cik;

        k(RecordConfigProvider recordConfigProvider, boolean z, RecordConfigProvider recordConfigProvider2, boolean z2) {
            this.BSb = recordConfigProvider;
            this.Cii = z;
            this.Cij = recordConfigProvider2;
            this.Cik = z2;
        }

        public final void run() {
            AppMethodBeat.i(76184);
            if (!this.BSb.BOx) {
                s.deleteFile(this.BSb.BOB);
            }
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            p.g(aAh, "MMKernel.storage()");
            boolean z = aAh.azQ().getBoolean(ar.a.USERINFO_WEIXIN_CAMERASAVEIMAGE_STATE_BOOLEAN, true);
            Log.i("MicroMsg.MediaFileUtil", "imageState : " + z + ' ');
            if (!z) {
                AppMethodBeat.o(76184);
                return;
            }
            if ((this.Cii && z) || (!this.Cii && this.Cij.BOy && this.Cik)) {
                String exportImagePath = com.tencent.mm.plugin.mmsight.d.getExportImagePath("jpg");
                if (!this.Cii) {
                    exportImagePath = AndroidMediaUtil.getExportImagePath("jpg");
                }
                Log.i("MicroMsg.MediaFileUtil", "auto save pic src " + this.Cij.BOC + " dest " + exportImagePath + ' ');
                s.nw(this.Cij.BOC, exportImagePath);
                AndroidMediaUtil.refreshMediaScanner(exportImagePath, MMApplicationContext.getContext());
            }
            AppMethodBeat.o(76184);
        }
    }

    public static boolean f(RecordConfigProvider recordConfigProvider) {
        AppMethodBeat.i(76207);
        Log.i("MicroMsg.MediaFileUtil", "configProvider : " + recordConfigProvider + "  isCaptureMedia:true  ");
        if (recordConfigProvider != null) {
            com.tencent.f.h.RTc.b(new g(recordConfigProvider), "mux_save_work_daemon");
        }
        AppMethodBeat.o(76207);
        return true;
    }

    public static final class g implements Runnable {
        final /* synthetic */ RecordConfigProvider BSb;

        g(RecordConfigProvider recordConfigProvider) {
            this.BSb = recordConfigProvider;
        }

        public final void run() {
            AppMethodBeat.i(76182);
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            p.g(aAh, "MMKernel.storage()");
            boolean z = aAh.azQ().getBoolean(ar.a.USERINFO_WEIXIN_CAMERASAVEVIDEO_STATE_BOOLEAN, true);
            Log.i("MicroMsg.MediaFileUtil", "handleDaemonNoNeedRemuxCaptureVideo videoState : " + z + ' ');
            if (z) {
                String exportImagePath = com.tencent.mm.plugin.mmsight.d.getExportImagePath("mp4");
                s.nw(this.BSb.BOA, exportImagePath);
                AndroidMediaUtil.refreshMediaScanner(exportImagePath, MMApplicationContext.getContext());
            }
            s.deleteFile(this.BSb.BOz);
            AppMethodBeat.o(76182);
        }
    }

    public static boolean g(RecordConfigProvider recordConfigProvider) {
        AppMethodBeat.i(76208);
        Log.i("MicroMsg.MediaFileUtil", "configProvider : " + recordConfigProvider + "  isCaptureMedia:true  ");
        if (recordConfigProvider != null) {
            if (s.YS(recordConfigProvider.BOz)) {
                s.nw(recordConfigProvider.BOz, recordConfigProvider.BOA);
            }
            com.tencent.f.h.RTc.b(new j(recordConfigProvider), "handleNoNeedRemuxCaptureVideo");
        }
        AppMethodBeat.o(76208);
        return true;
    }

    public static final class j implements Runnable {
        final /* synthetic */ RecordConfigProvider BSb;

        j(RecordConfigProvider recordConfigProvider) {
            this.BSb = recordConfigProvider;
        }

        public final void run() {
            AppMethodBeat.i(76183);
            Log.i("MicroMsg.MediaFileUtil", "handleNoNeedRemuxCaptureVideo");
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            p.g(aAh, "MMKernel.storage()");
            boolean z = aAh.azQ().getBoolean(ar.a.USERINFO_WEIXIN_CAMERASAVEVIDEO_STATE_BOOLEAN, true);
            Log.i("MicroMsg.MediaFileUtil", "handleNoNeedRemuxCaptureVideo videoState : " + z + ' ');
            if (z) {
                String exportImagePath = com.tencent.mm.plugin.mmsight.d.getExportImagePath("mp4");
                s.nw(this.BSb.BOA, exportImagePath);
                AndroidMediaUtil.refreshMediaScanner(exportImagePath, MMApplicationContext.getContext());
            }
            s.deleteFile(this.BSb.BOz);
            AppMethodBeat.o(76183);
        }
    }

    public static void aLJ(String str) {
        AppMethodBeat.i(237984);
        if (!TextUtils.isEmpty(str) && s.YS(str)) {
            com.tencent.f.h.RTc.aX(new i(str));
        }
        AppMethodBeat.o(237984);
    }

    public static final class i implements Runnable {
        final /* synthetic */ String mtb;

        i(String str) {
            this.mtb = str;
        }

        public final void run() {
            AppMethodBeat.i(237979);
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            p.g(aAh, "MMKernel.storage()");
            boolean z = aAh.azQ().getBoolean(ar.a.USERINFO_WEIXIN_CAMERASAVEVIDEO_STATE_BOOLEAN, true);
            Log.i("MicroMsg.MediaFileUtil", "remuxComposition videoState : " + z + " videoPath:" + this.mtb);
            if (z) {
                String exportImagePath = AndroidMediaUtil.getExportImagePath("mp4");
                s.nw(this.mtb, exportImagePath);
                AndroidMediaUtil.refreshMediaScanner(exportImagePath, MMApplicationContext.getContext());
            }
            AppMethodBeat.o(237979);
        }
    }

    public static void aLK(String str) {
        AppMethodBeat.i(237985);
        if (!TextUtils.isEmpty(str) && s.YS(str)) {
            com.tencent.f.h.RTc.aX(new h(str));
        }
        AppMethodBeat.o(237985);
    }

    public static final class h implements Runnable {
        final /* synthetic */ String Cih;

        h(String str) {
            this.Cih = str;
        }

        public final void run() {
            AppMethodBeat.i(237978);
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            p.g(aAh, "MMKernel.storage()");
            boolean z = aAh.azQ().getBoolean(ar.a.USERINFO_WEIXIN_CAMERASAVEIMAGE_STATE_BOOLEAN, true);
            Log.i("MicroMsg.MediaFileUtil", "handleMultiVideoResult videoState : " + z + ' ');
            if (z) {
                String exportImagePath = AndroidMediaUtil.getExportImagePath("jpg");
                s.nw(this.Cih, exportImagePath);
                AndroidMediaUtil.refreshMediaScanner(exportImagePath, MMApplicationContext.getContext());
            }
            AppMethodBeat.o(237978);
        }
    }

    public static void c(com.tencent.mm.media.widget.camerarecordview.b.b bVar) {
        AppMethodBeat.i(237986);
        if (bVar != null) {
            if (bVar.iqf) {
                com.tencent.f.h.RTc.aX(new o(bVar));
            }
            AppMethodBeat.o(237986);
            return;
        }
        AppMethodBeat.o(237986);
    }

    public static final class o implements Runnable {
        final /* synthetic */ com.tencent.mm.media.widget.camerarecordview.b.b Cim;

        o(com.tencent.mm.media.widget.camerarecordview.b.b bVar) {
            this.Cim = bVar;
        }

        public final void run() {
            AppMethodBeat.i(237980);
            for (T t : this.Cim.iqn) {
                Log.i("MicroMsg.MediaFileUtil", "delete file:".concat(String.valueOf(t)));
                s.deleteFile(t);
            }
            AppMethodBeat.o(237980);
        }
    }

    public static Bitmap j(Bitmap bitmap, int i2) {
        int width;
        int i3;
        AppMethodBeat.i(76209);
        p.h(bitmap, "bitmap");
        if (i2 <= 0) {
            AppMethodBeat.o(76209);
            return bitmap;
        } else if (Math.min(bitmap.getWidth(), bitmap.getHeight()) > i2) {
            if (bitmap.getWidth() < bitmap.getHeight()) {
                i3 = (int) ((((float) (bitmap.getHeight() * i2)) * 1.0f) / ((float) bitmap.getWidth()));
                width = i2;
            } else {
                width = (int) ((((float) (bitmap.getWidth() * i2)) * 1.0f) / ((float) bitmap.getHeight()));
                i3 = i2;
            }
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, width, i3, true);
            p.g(createScaledBitmap, "Bitmap.createScaledBitma…idth, outputHeight, true)");
            AppMethodBeat.o(76209);
            return createScaledBitmap;
        } else {
            AppMethodBeat.o(76209);
            return bitmap;
        }
    }

    public static String In(long j2) {
        AppMethodBeat.i(76210);
        s.boN(Cia);
        String str = Cia + "thumb" + j2 + ".jpg";
        AppMethodBeat.o(76210);
        return str;
    }

    private static String jF(String str, String str2) {
        AppMethodBeat.i(76211);
        if (str2 == null) {
            AppMethodBeat.o(76211);
            return "";
        }
        String str3 = str + str2 + ".p";
        AppMethodBeat.o(76211);
        return str3;
    }

    public static String aLL(String str) {
        String str2;
        AppMethodBeat.i(76213);
        if (str == null) {
            AppMethodBeat.o(76213);
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String str3 = Cib;
        if (str == null) {
            str2 = "";
        } else {
            str2 = str3 + str + ".v";
        }
        String sb2 = sb.append(str2).append(".mixv").toString();
        AppMethodBeat.o(76213);
        return sb2;
    }

    public static String aLM(String str) {
        AppMethodBeat.i(76214);
        if (str == null) {
            AppMethodBeat.o(76214);
            return "";
        }
        String str2 = jF(Cib, str) + ".mixt";
        AppMethodBeat.o(76214);
        return str2;
    }

    public static String aLN(String str) {
        AppMethodBeat.i(163472);
        if (str == null) {
            AppMethodBeat.o(163472);
            return "";
        }
        String str2 = jF(Cib, str) + ".blurt";
        AppMethodBeat.o(163472);
        return str2;
    }

    public static String aLO(String str) {
        String str2;
        AppMethodBeat.i(237987);
        if (str == null) {
            AppMethodBeat.o(237987);
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String str3 = Cib;
        if (str == null) {
            str2 = "";
        } else {
            str2 = str3 + str + ".p";
        }
        String sb2 = sb.append(str2).append(".mixa").toString();
        AppMethodBeat.o(237987);
        return sb2;
    }

    public static void aLP(String str) {
        AppMethodBeat.i(76215);
        p.h(str, "newVideoPath");
        if (str.length() == 0) {
            AppMethodBeat.o(76215);
            return;
        }
        String boZ = s.boZ(str);
        s.boN(boZ);
        s.bpc(boZ);
        AppMethodBeat.o(76215);
    }

    public static /* synthetic */ void jG(String str, String str2) {
        AppMethodBeat.i(237988);
        p.h(str, "videoPath");
        p.h(str2, "thumbPath");
        if (s.YS(str2)) {
            s.deleteFile(str2);
        }
        Bitmap PF = com.tencent.mm.plugin.mmsight.d.PF(str);
        if (PF != null) {
            BitmapUtil.saveBitmapToImage(PF, 60, Bitmap.CompressFormat.JPEG, str2, true);
            AppMethodBeat.o(237988);
            return;
        }
        Log.e("MicroMsg.MediaFileUtil", "saveThumb error");
        AppMethodBeat.o(237988);
    }

    public static void d(com.tencent.mm.media.widget.camerarecordview.b.b bVar) {
        AppMethodBeat.i(76217);
        if (bVar != null) {
            com.tencent.f.h.RTc.b(new b(bVar), "deleteDaemonMediaFile");
            AppMethodBeat.o(76217);
            return;
        }
        AppMethodBeat.o(76217);
    }

    public static final class b implements Runnable {
        final /* synthetic */ com.tencent.mm.media.widget.camerarecordview.b.b Cie;

        b(com.tencent.mm.media.widget.camerarecordview.b.b bVar) {
            this.Cie = bVar;
        }

        public final void run() {
            AppMethodBeat.i(76178);
            Log.i("MicroMsg.MediaFileUtil", "deleteDaemonMediaFile");
            s.deleteFile(this.Cie.iqh);
            s.deleteFile(this.Cie.iqi);
            AppMethodBeat.o(76178);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.recordvideo.e.c$c */
    public static final class RunnableC1646c implements Runnable {
        final /* synthetic */ String Cif;
        final /* synthetic */ long Cig;
        final /* synthetic */ String msC;

        RunnableC1646c(String str, String str2, long j2) {
            this.Cif = str;
            this.msC = str2;
            this.Cig = j2;
        }

        public final void run() {
            com.tencent.mm.vfs.o[] het;
            AppMethodBeat.i(237977);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
            if (TextUtils.isEmpty(this.Cif) || !s.YS(this.Cif) || (het = new com.tencent.mm.vfs.o(this.Cif).het()) == null) {
                AppMethodBeat.o(237977);
                return;
            }
            for (com.tencent.mm.vfs.o oVar : het) {
                p.g(oVar, LocaleUtil.ITALIAN);
                String absolutePath = oVar.getAbsolutePath();
                p.g(absolutePath, "it.absolutePath");
                if (kotlin.n.n.e(absolutePath, this.msC)) {
                    Log.i("MicroMsg.MediaFileUtil", "print file path:" + oVar.getAbsolutePath() + " data:" + new Date(oVar.lastModified()) + " time:" + oVar.lastModified() + " exist:" + simpleDateFormat.format(Long.valueOf(System.currentTimeMillis() - oVar.lastModified())));
                    if (System.currentTimeMillis() - oVar.lastModified() >= this.Cig) {
                        Log.i("MicroMsg.MediaFileUtil", "delete file path:" + oVar.getAbsolutePath());
                        s.deleteFile(oVar.getAbsolutePath());
                    }
                }
            }
            AppMethodBeat.o(237977);
        }
    }

    public static void n(String str, String str2, long j2) {
        AppMethodBeat.i(237989);
        com.tencent.f.h.RTc.aZ(new RunnableC1646c(str, str2, j2));
        AppMethodBeat.o(237989);
    }
}
