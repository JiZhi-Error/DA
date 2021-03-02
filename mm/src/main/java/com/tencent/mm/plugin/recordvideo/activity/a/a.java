package com.tencent.mm.plugin.recordvideo.activity.a;

import android.media.MediaFormat;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.i.c;
import com.tencent.mm.media.widget.camerarecordview.b.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import com.tencent.tav.decoder.EncoderWriter;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0004J\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/activity/controller/RecordUIController;", "", "()V", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "checkConfigProvider", "", "toWhere", "fileCheck", "path", "", "formatCheck", "getCaptureInfoFromProvider", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "setUpProvider", "", "Companion", "plugin-recordvideo_release"})
public final class a {
    public static final C1634a BJv = new C1634a((byte) 0);

    static {
        AppMethodBeat.i(75067);
        AppMethodBeat.o(75067);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/activity/controller/RecordUIController$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
    /* renamed from: com.tencent.mm.plugin.recordvideo.activity.a.a$a  reason: collision with other inner class name */
    public static final class C1634a {
        private C1634a() {
        }

        public /* synthetic */ C1634a(byte b2) {
            this();
        }
    }

    public static int aLc(String str) {
        AppMethodBeat.i(75064);
        if (TextUtils.isEmpty(str)) {
            Log.e("MicroMsg.MMRecordUI", "fileCheck path is null");
            AppMethodBeat.o(75064);
            return 1000;
        } else if (s.boW(str) < 1) {
            Log.e("MicroMsg.MMRecordUI", "fileCheck file size is 0. path: ".concat(String.valueOf(str)));
            AppMethodBeat.o(75064);
            return 1001;
        } else {
            AppMethodBeat.o(75064);
            return 999;
        }
    }

    public static int aLd(String str) {
        String string;
        AppMethodBeat.i(75065);
        long currentTicks = Util.currentTicks();
        c cVar = new c();
        try {
            cVar.setDataSource(str);
            int trackCount = cVar.getTrackCount();
            MediaFormat mediaFormat = null;
            MediaFormat mediaFormat2 = null;
            for (int i2 = 0; i2 < trackCount; i2++) {
                MediaFormat trackFormat = cVar.getTrackFormat(i2);
                p.g(trackFormat, "extractor.getTrackFormat(i)");
                if (trackFormat.containsKey("mime")) {
                    String string2 = trackFormat.getString("mime");
                    Log.d("MicroMsg.RecordUIController", "find video mime : %s", string2);
                    if (string2 != null) {
                        if (n.J(string2, "video/", false)) {
                            if (mediaFormat == null) {
                                mediaFormat = trackFormat;
                            }
                        } else if (n.J(string2, "audio/", false) && mediaFormat2 == null) {
                            mediaFormat2 = trackFormat;
                        }
                        if (!(mediaFormat2 == null || mediaFormat == null)) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    Log.d("MicroMsg.RecordUIController", "find video mime : not found.");
                }
            }
            Log.i("MicroMsg.RecordUIController", "cost time: " + Util.ticksToNow(currentTicks));
            if (mediaFormat2 != null) {
                if (!mediaFormat2.containsKey("mime")) {
                    string = "";
                } else {
                    string = mediaFormat2.getString("mime");
                }
                if (n.I(EncoderWriter.OUTPUT_AUDIO_MIME_TYPE, string, true)) {
                    cVar.release();
                    AppMethodBeat.o(75065);
                    return 999;
                }
                Log.d("MicroMsg.RecordUIController", "mediaItem format:%s, videoPath:%s", mediaFormat, str);
                cVar.release();
                AppMethodBeat.o(75065);
                return 1004;
            }
            cVar.release();
            AppMethodBeat.o(75065);
            return 999;
        } catch (Exception e2) {
            Log.d("MicroMsg.RecordUIController", "Video extractor init failed. video path = [%s] e = [%s]", str, e2.getMessage());
            cVar.release();
        } catch (Throwable th) {
            cVar.release();
            AppMethodBeat.o(75065);
            throw th;
        }
    }

    public static b b(RecordConfigProvider recordConfigProvider) {
        AppMethodBeat.i(75066);
        p.h(recordConfigProvider, "configProvider");
        b bVar = new b(null, null, false, null, null, null, null, null, null, 65535);
        ArrayList<String> arrayList = recordConfigProvider.BOD;
        if (arrayList != null) {
            bVar.iqn = arrayList;
        }
        ArrayList<String> arrayList2 = recordConfigProvider.images;
        if (arrayList2 != null) {
            bVar.iqm = arrayList2;
        }
        ArrayList<String> arrayList3 = recordConfigProvider.images;
        if (arrayList3 == null || arrayList3.isEmpty()) {
            ArrayList<String> arrayList4 = recordConfigProvider.BOD;
            if (!(arrayList4 == null || arrayList4.isEmpty()) && recordConfigProvider.BOD.size() == 1) {
                String str = recordConfigProvider.BOD.get(0);
                p.g(str, "configProvider.videos[0]");
                bVar.Hw(str);
                bVar.iqg = e.aNx(bVar.iqd).videoDuration;
                String str2 = recordConfigProvider.thumbPath;
                p.g(str2, "configProvider.thumbPath");
                bVar.Hx(str2);
            }
        }
        if (!TextUtils.isEmpty(recordConfigProvider.BOB)) {
            String str3 = recordConfigProvider.BOB;
            p.g(str3, "configProvider.inputPhotoPath");
            bVar.Hy(str3);
        }
        if (!TextUtils.isEmpty(recordConfigProvider.BOz) && s.YS(recordConfigProvider.BOz)) {
            String str4 = recordConfigProvider.BOz;
            p.g(str4, "configProvider.inputVideoPath");
            bVar.Hw(str4);
            bVar.iqg = e.aNx(recordConfigProvider.BOz).videoDuration;
            String str5 = recordConfigProvider.thumbPath;
            p.g(str5, "configProvider.thumbPath");
            bVar.Hx(str5);
        }
        AppMethodBeat.o(75066);
        return bVar;
    }
}
