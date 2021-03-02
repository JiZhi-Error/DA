package com.tencent.mm.plugin.facedetect.service;

import android.content.Intent;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.an.f;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.plugin.facedetect.b.r;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.flash.c.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.service.MMService;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.ByteArrayOutputStream;

public class FaceUploadVideoService extends MMService implements i {
    private int sSZ = -1;

    @Override // com.tencent.mm.service.MMService
    public final int onStartCommand(Intent intent, int i2, int i3) {
        AppMethodBeat.i(103873);
        if (intent == null) {
            Log.e("MicroMsg.FaceUploadVideoService", "hy: null intent called to FaceUploadVideoService! Stub");
            int onStartCommand = super.onStartCommand(null, i2, i3);
            AppMethodBeat.o(103873);
            return onStartCommand;
        }
        String stringExtra = intent.getStringExtra("key_video_file_name");
        long longExtra = intent.getLongExtra("k_bio_id", -1);
        String stringExtra2 = intent.getStringExtra("key_app_id");
        this.sSZ = intent.getIntExtra("key_face_type", -1);
        Log.i("MicroMsg.FaceUploadVideoService", "hy: start uploading %s", stringExtra);
        if (Util.isNullOrNil(stringExtra)) {
            Log.w("MicroMsg.FaceUploadVideoService", "hy: null file name");
            b.z(this.sSZ, -2, "null file name");
            int onStartCommand2 = super.onStartCommand(intent, i2, i3);
            AppMethodBeat.o(103873);
            return onStartCommand2;
        } else if (!new o(stringExtra).exists()) {
            Log.w("MicroMsg.FaceUploadVideoService", "hy: file not exist");
            b.z(this.sSZ, -3, "file not exist");
            int onStartCommand3 = super.onStartCommand(intent, i2, i3);
            AppMethodBeat.o(103873);
            return onStartCommand3;
        } else if (longExtra != -1 || !Util.isNullOrNil(stringExtra2)) {
            g gVar = new g();
            gVar.taskName = "task_FaceUploadVideoService";
            gVar.gqy = new a(this, longExtra, stringExtra2, stringExtra, (byte) 0);
            gVar.field_mediaId = p.arC(stringExtra);
            gVar.field_fullpath = stringExtra;
            gVar.field_thumbpath = "";
            gVar.field_fileType = com.tencent.mm.i.a.MediaType_FILE;
            gVar.field_talker = "";
            gVar.field_priority = com.tencent.mm.i.a.gpM;
            gVar.field_needStorage = false;
            gVar.field_isStreamMedia = false;
            gVar.field_appType = 0;
            gVar.field_bzScene = 0;
            gVar.field_largesvideo = 0;
            if (!f.baQ().f(gVar)) {
                Log.e("MicroMsg.FaceUploadVideoService", "hy: video task info failed. clientid:%s", gVar.field_mediaId);
                b.z(this.sSZ, -5, "add task fail");
                s.deleteFile(stringExtra);
                FaceDetectReporter.h(longExtra, 1, 10086);
            }
            int onStartCommand4 = super.onStartCommand(intent, i2, i3);
            AppMethodBeat.o(103873);
            return onStartCommand4;
        } else {
            Log.w("MicroMsg.FaceUploadVideoService", "hy: bioId or app id null");
            b.z(this.sSZ, -4, "bioId or app id null");
            s.deleteFile(stringExtra);
            int onStartCommand5 = super.onStartCommand(intent, i2, i3);
            AppMethodBeat.o(103873);
            return onStartCommand5;
        }
    }

    class a implements g.a {
        private String mAppId;
        private String mFileName;
        private long sQI;

        /* synthetic */ a(FaceUploadVideoService faceUploadVideoService, long j2, String str, String str2, byte b2) {
            this(j2, str, str2);
        }

        private a(long j2, String str, String str2) {
            this.sQI = -1;
            this.mAppId = null;
            this.mFileName = null;
            this.sQI = j2;
            this.mAppId = str;
            this.mFileName = str2;
        }

        @Override // com.tencent.mm.i.g.a
        public final int a(String str, int i2, c cVar, d dVar, boolean z) {
            AppMethodBeat.i(103872);
            Log.i("MicroMsg.FaceUploadVideoService", "hy: sceneResult.field_retCode == 0 cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i2), cVar, dVar);
            if (dVar != null && dVar.field_retCode == 0) {
                Log.i("MicroMsg.FaceUploadVideoService", "hy: upload video done. now upload");
                b.z(FaceUploadVideoService.this.sSZ, 0, "success");
                h.INSTANCE.idkeyStat(917, 23, 1, false);
                FaceDetectReporter.h(this.sQI, 0, 0);
                com.tencent.mm.kernel.g.azz().a(1197, FaceUploadVideoService.this);
                com.tencent.mm.kernel.g.azz().a(new r(this.mFileName, this.sQI, this.mAppId, dVar.field_fileId, dVar.field_aesKey), 0);
            } else if (dVar != null) {
                Log.w("MicroMsg.FaceUploadVideoService", "hy: upload video cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i2), cVar, dVar);
                s.deleteFile(this.mFileName);
                b.z(FaceUploadVideoService.this.sSZ, dVar.field_retCode, "cdn error retCode");
                h.INSTANCE.idkeyStat(917, 24, 1, false);
                FaceDetectReporter.h(this.sQI, 1, dVar.field_retCode);
                AppMethodBeat.o(103872);
                return 0;
            } else if (i2 != 0) {
                Log.w("MicroMsg.FaceUploadVideoService", "hy: upload video start error!; cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i2), cVar, dVar);
                s.deleteFile(this.mFileName);
                b.z(FaceUploadVideoService.this.sSZ, i2, "cdn error startRet");
                h.INSTANCE.idkeyStat(917, 24, 1, false);
                FaceDetectReporter.h(this.sQI, 1, i2);
                AppMethodBeat.o(103872);
                return 0;
            }
            AppMethodBeat.o(103872);
            return 0;
        }

        @Override // com.tencent.mm.i.g.a
        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        @Override // com.tencent.mm.i.g.a
        public final byte[] f(String str, byte[] bArr) {
            return new byte[0];
        }
    }

    @Override // com.tencent.mm.service.MMService
    public final IBinder akL() {
        return null;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(103874);
        if (qVar instanceof r) {
            r rVar = (r) qVar;
            Log.i("MicroMsg.FaceUploadVideoService", "hy: bind video errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
            h.INSTANCE.idkeyStat(917, i3 == 0 ? 25 : 26, 1, false);
            com.tencent.mm.kernel.g.azz().b(1197, this);
            s.deleteFile(rVar.mFileName);
            stopSelf();
        }
        AppMethodBeat.o(103874);
    }

    @Override // com.tencent.mm.service.MMService
    public final String getTag() {
        return "MicroMsg.FaceUploadVideoService";
    }
}
