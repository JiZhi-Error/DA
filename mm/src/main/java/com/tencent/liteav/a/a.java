package com.tencent.liteav.a;

import android.content.Context;
import android.media.MediaFormat;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.liteav.audio.e;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.util.f;
import com.tencent.liteav.muxer.c;
import com.tencent.liteav.videoencoder.TXSVideoEncoderParam;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;

public class a implements e, com.tencent.liteav.videoencoder.e {

    /* renamed from: a  reason: collision with root package name */
    private com.tencent.liteav.audio.impl.Record.b f126a = new com.tencent.liteav.audio.impl.Record.b();

    /* renamed from: b  reason: collision with root package name */
    private com.tencent.liteav.videoencoder.a f127b = new com.tencent.liteav.videoencoder.a();

    /* renamed from: c  reason: collision with root package name */
    private c f128c;

    /* renamed from: d  reason: collision with root package name */
    private C0153a f129d;

    /* renamed from: e  reason: collision with root package name */
    private b f130e;

    /* renamed from: f  reason: collision with root package name */
    private long f131f = 0;

    /* renamed from: g  reason: collision with root package name */
    private long f132g = -1;

    /* renamed from: h  reason: collision with root package name */
    private boolean f133h = false;

    /* renamed from: i  reason: collision with root package name */
    private Handler f134i = new Handler(Looper.getMainLooper()) {
        /* class com.tencent.liteav.a.a.AnonymousClass1 */

        public void handleMessage(Message message) {
            AppMethodBeat.i(16670);
            if (a.this.f130e != null) {
                switch (message.what) {
                    case 1:
                        a.this.f130e.a(((Long) message.obj).longValue());
                        AppMethodBeat.o(16670);
                        return;
                    case 2:
                        TXCLog.d("TXCStreamRecord", "record complete. errcode = " + message.arg1 + ", errmsg = " + ((String) message.obj) + ", outputPath = " + a.this.f129d.f141f + ", coverImage = " + a.this.f129d.f142g);
                        if (message.arg1 == 0 && a.this.f129d.f142g != null && !a.this.f129d.f142g.isEmpty() && !f.a(a.this.f129d.f141f, a.this.f129d.f142g)) {
                            TXCLog.e("TXCStreamRecord", "saveVideoThumb error. sourcePath = " + a.this.f129d.f141f + ", coverImagePath = " + a.this.f129d.f142g);
                        }
                        if (message.arg1 != 0) {
                            try {
                                File file = new File(a.this.f129d.f141f);
                                if (file.exists()) {
                                    file.delete();
                                }
                            } catch (Exception e2) {
                                TXCLog.e("TXCStreamRecord", "delete file failed.", e2);
                            }
                        }
                        a.this.f130e.a(message.arg1, (String) message.obj, a.this.f129d.f141f, a.this.f129d.f142g);
                        break;
                }
            }
            AppMethodBeat.o(16670);
        }
    };

    public interface b {
        void a(int i2, String str, String str2, String str3);

        void a(long j2);
    }

    /* renamed from: com.tencent.liteav.a.a$a  reason: collision with other inner class name */
    public static class C0153a {

        /* renamed from: a  reason: collision with root package name */
        public int f136a = 544;

        /* renamed from: b  reason: collision with root package name */
        public int f137b = 960;

        /* renamed from: c  reason: collision with root package name */
        public int f138c = 20;

        /* renamed from: d  reason: collision with root package name */
        public int f139d = 1000;

        /* renamed from: e  reason: collision with root package name */
        public Object f140e;

        /* renamed from: f  reason: collision with root package name */
        public String f141f;

        /* renamed from: g  reason: collision with root package name */
        public String f142g;

        /* renamed from: h  reason: collision with root package name */
        public int f143h = 0;

        /* renamed from: i  reason: collision with root package name */
        public int f144i = 0;

        /* renamed from: j  reason: collision with root package name */
        public int f145j = 16;

        public String toString() {
            AppMethodBeat.i(16671);
            StringBuilder sb = new StringBuilder();
            sb.append("TXCStreamRecordParams: [width=" + this.f136a);
            sb.append("; height=" + this.f137b);
            sb.append("; fps=" + this.f138c);
            sb.append("; bitrate=" + this.f139d);
            sb.append("; channels=" + this.f143h);
            sb.append("; samplerate=" + this.f144i);
            sb.append("; bits=" + this.f145j);
            sb.append("; EGLContext=" + this.f140e);
            sb.append("; coveriamge=" + this.f142g);
            sb.append("; outputpath=" + this.f141f + "]");
            String sb2 = sb.toString();
            AppMethodBeat.o(16671);
            return sb2;
        }
    }

    public a(Context context) {
        AppMethodBeat.i(16672);
        this.f128c = new c(context, 1);
        AppMethodBeat.o(16672);
    }

    public void a(b bVar) {
        this.f130e = bVar;
    }

    public void a(C0153a aVar) {
        AppMethodBeat.i(16673);
        this.f129d = aVar;
        this.f131f = 0;
        this.f132g = -1;
        this.f128c.a(this.f129d.f141f);
        if (aVar.f143h > 0 && aVar.f144i > 0 && aVar.f145j > 0) {
            this.f126a.a(10, aVar.f144i, aVar.f143h, aVar.f145j, new WeakReference<>(this));
            this.f128c.b(f.a(this.f129d.f144i, this.f129d.f143h, 2));
            this.f133h = true;
        }
        this.f127b.setListener(this);
        TXSVideoEncoderParam tXSVideoEncoderParam = new TXSVideoEncoderParam();
        tXSVideoEncoderParam.width = this.f129d.f136a;
        tXSVideoEncoderParam.height = this.f129d.f137b;
        tXSVideoEncoderParam.fps = this.f129d.f138c;
        tXSVideoEncoderParam.glContext = this.f129d.f140e;
        tXSVideoEncoderParam.annexb = true;
        tXSVideoEncoderParam.appendSpsPps = false;
        this.f127b.setBitrate(this.f129d.f139d);
        this.f127b.start(tXSVideoEncoderParam);
        AppMethodBeat.o(16673);
    }

    public void a() {
        AppMethodBeat.i(16674);
        this.f133h = false;
        this.f126a.a();
        this.f127b.stop();
        if (this.f128c.b() < 0) {
            this.f134i.sendMessage(Message.obtain(this.f134i, 2, 1, 0, "mp4合成失败"));
            AppMethodBeat.o(16674);
            return;
        }
        this.f134i.sendMessage(Message.obtain(this.f134i, 2, 0, 0, ""));
        AppMethodBeat.o(16674);
    }

    public void a(int i2, long j2) {
        AppMethodBeat.i(16675);
        this.f127b.pushVideoFrame(i2, this.f129d.f136a, this.f129d.f137b, j2);
        AppMethodBeat.o(16675);
    }

    public void a(byte[] bArr, long j2) {
        AppMethodBeat.i(16676);
        if (this.f133h) {
            this.f126a.a(bArr, j2);
            AppMethodBeat.o(16676);
            return;
        }
        TXCLog.e("TXCStreamRecord", "drainAudio fail because of not init yet!");
        AppMethodBeat.o(16676);
    }

    public static String a(Context context, String str) {
        AppMethodBeat.i(16677);
        if (context == null) {
            AppMethodBeat.o(16677);
            return null;
        }
        try {
            String format = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date(Long.valueOf(String.valueOf(System.currentTimeMillis() / 1000) + "000").longValue()));
            String a2 = a(context);
            if (TextUtils.isEmpty(a2)) {
                AppMethodBeat.o(16677);
                return null;
            }
            String absolutePath = new File(a2, String.format("TXUGC_%s".concat(String.valueOf(str)), format)).getAbsolutePath();
            AppMethodBeat.o(16677);
            return absolutePath;
        } catch (Exception e2) {
            TXCLog.e("TXCStreamRecord", "create file path failed.", e2);
            AppMethodBeat.o(16677);
            return null;
        }
    }

    private static String a(Context context) {
        String str = null;
        AppMethodBeat.i(16678);
        if (context == null) {
            AppMethodBeat.o(16678);
        } else {
            if ("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
                File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_MOVIES);
                if (externalFilesDir != null) {
                    str = externalFilesDir.getPath();
                }
            } else {
                str = context.getFilesDir().getPath();
            }
            AppMethodBeat.o(16678);
        }
        return str;
    }

    private String a(int i2) {
        String str;
        AppMethodBeat.i(221378);
        switch (i2) {
            case 10000002:
                str = "Video encoder is not activated";
                break;
            case 10000003:
                str = "Illegal video input parameters";
                break;
            case 10000004:
                str = "Video encoding failed to initialize";
                break;
            case 10000005:
                str = "Video encoding failed";
                break;
            default:
                str = "";
                break;
        }
        this.f134i.sendMessage(Message.obtain(this.f134i, 2, 1, 0, str));
        AppMethodBeat.o(221378);
        return str;
    }

    @Override // com.tencent.liteav.audio.e
    public void onRecordRawPcmData(byte[] bArr, long j2, int i2, int i3, int i4, boolean z) {
    }

    @Override // com.tencent.liteav.audio.e
    public void onRecordPcmData(byte[] bArr, long j2, int i2, int i3, int i4) {
    }

    @Override // com.tencent.liteav.audio.e
    public void onRecordEncData(byte[] bArr, long j2, int i2, int i3, int i4) {
        AppMethodBeat.i(16680);
        this.f128c.a(bArr, 0, bArr.length, 1000 * j2, 1);
        AppMethodBeat.o(16680);
    }

    @Override // com.tencent.liteav.audio.e
    public void onRecordError(int i2, String str) {
    }

    @Override // com.tencent.liteav.videoencoder.e
    public void a(TXSNALPacket tXSNALPacket, int i2) {
        AppMethodBeat.i(16681);
        if (i2 == 0) {
            this.f128c.b(tXSNALPacket.nalData, 0, tXSNALPacket.nalData.length, tXSNALPacket.pts * 1000, tXSNALPacket.info.flags);
            if (this.f132g < 0) {
                this.f132g = tXSNALPacket.pts;
            }
            if (tXSNALPacket.pts > this.f131f + 500) {
                this.f134i.sendMessage(Message.obtain(this.f134i, 1, new Long(tXSNALPacket.pts - this.f132g)));
                this.f131f = tXSNALPacket.pts;
                AppMethodBeat.o(16681);
                return;
            }
        } else {
            TXCLog.e("TXCStreamRecord", "video encode error! errmsg: ".concat(String.valueOf(a(i2))));
        }
        AppMethodBeat.o(16681);
    }

    @Override // com.tencent.liteav.videoencoder.e
    public void a(MediaFormat mediaFormat) {
        AppMethodBeat.i(16682);
        this.f128c.a(mediaFormat);
        if (this.f128c.c() && this.f128c.a() < 0) {
            this.f134i.sendMessage(Message.obtain(this.f134i, 2, 1, 0, "mp4 wrapper failed to start"));
        }
        AppMethodBeat.o(16682);
    }

    @Override // com.tencent.liteav.videoencoder.e
    public void a(int i2, long j2, long j3) {
    }

    @Override // com.tencent.liteav.videoencoder.e
    public void l(int i2) {
    }

    @Override // com.tencent.liteav.videoencoder.e
    public void m(int i2) {
    }
}
