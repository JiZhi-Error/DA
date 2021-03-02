package com.tencent.mm.plugin.vlog.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.mmsight.segment.d;
import com.tencent.mm.plugin.mmsight.segment.n;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.ccw;
import com.tencent.mm.protocal.protobuf.cmt;
import com.tencent.mm.protocal.protobuf.eqx;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.k.g;
import kotlin.k.i;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u001aJ\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/VLogGenerator;", "", "()V", "TAG", "", "vLogConfig", "Lcom/tencent/mm/protocal/protobuf/ClientConfFromServer;", "cropBitmap", "Landroid/graphics/Bitmap;", FirebaseAnalytics.b.ORIGIN, "cropInfo", "Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "maxWidth", "", "maxHeight", "imageTrackToMaterialReq", "Lcom/tencent/mm/protocal/protobuf/MaterialReq;", FFmpegMetadataRetriever.METADATA_KEY_TRACK, "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "setConfig", "", "config", "trackToMaterialReq", "trackToMaterials", "Ljava/util/LinkedList;", "trackList", "", "videoTrackToMaterialReq", "Companion", "plugin-vlog_release"})
public final class ag {
    public static final a GzO = new a((byte) 0);
    aar GzN;
    private final String TAG = "MicroMsg.VLogGenerator";

    static {
        AppMethodBeat.i(190723);
        AppMethodBeat.o(190723);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/VLogGenerator$Companion;", "", "()V", "DefaultImageHeight", "", "DefaultImageWidth", "plugin-vlog_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final LinkedList<cmt> hO(List<ad> list) {
        cmt a2;
        ccw ccw;
        ccw ccw2;
        AppMethodBeat.i(190720);
        p.h(list, "trackList");
        LinkedList<cmt> linkedList = new LinkedList<>();
        for (T t : list) {
            p.h(t, FFmpegMetadataRetriever.METADATA_KEY_TRACK);
            if (t.type == 1) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = (int) ((((float) t.Gzu) * t.Gzw) / ((float) t.Gzx.rwL.width()));
                Bitmap decodeFile = MMBitmapFactory.decodeFile(t.path, options);
                if (decodeFile != null) {
                    aar aar = this.GzN;
                    int i2 = (aar == null || (ccw2 = aar.LlY) == null) ? 120 : (int) ccw2.width;
                    aar aar2 = this.GzN;
                    Bitmap a3 = a(decodeFile, t.Gzx, i2, (aar2 == null || (ccw = aar2.LlY) == null) ? 120 : (int) ccw.height);
                    byte[] Bitmap2Bytes = BitmapUtil.Bitmap2Bytes(a3, 20);
                    cmt cmt = new cmt();
                    cmt.id = (long) t.id;
                    cmt.Msh = new LinkedList<>(j.listOf(new b(Bitmap2Bytes)));
                    ccw ccw3 = new ccw();
                    ccw3.width = (long) a3.getWidth();
                    ccw3.height = (long) a3.getHeight();
                    cmt.Msi = ccw3;
                    cmt.dDw = 1;
                    cmt.MqN = 0;
                    a2 = cmt;
                } else {
                    a2 = null;
                }
            } else {
                a2 = t.type == 2 ? a(t) : null;
            }
            if (a2 != null) {
                linkedList.add(a2);
            }
        }
        AppMethodBeat.o(190720);
        return linkedList;
    }

    private final cmt a(ad adVar) {
        long j2;
        i iVar;
        int width;
        int height;
        ccw ccw;
        ccw ccw2;
        eqx eqx;
        eqx eqx2;
        AppMethodBeat.i(190721);
        long j3 = adVar.GzA.GJB;
        aar aar = this.GzN;
        long j4 = (aar == null || (eqx2 = aar.LlZ) == null) ? 100 : (long) eqx2.Noq;
        aar aar2 = this.GzN;
        if (aar2 == null || (eqx = aar2.LlZ) == null) {
            j2 = 1;
        } else {
            j2 = eqx.Nop;
        }
        d m = n.m(adVar.path, 100, Math.min(adVar.Gzu, adVar.Gzx.rwL.width()), Math.min(adVar.Gzv, adVar.Gzx.rwL.height()));
        LinkedList<b> linkedList = new LinkedList<>();
        aar aar3 = this.GzN;
        int i2 = (aar3 == null || (ccw2 = aar3.LlY) == null) ? 120 : (int) ccw2.width;
        aar aar4 = this.GzN;
        int i3 = (aar4 == null || (ccw = aar4.LlY) == null) ? 120 : (int) ccw.height;
        long j5 = j3 - 100;
        if (j5 <= Long.MIN_VALUE) {
            i.a aVar = i.SZh;
            iVar = i.hyk();
        } else {
            iVar = new i(100, j5 - 1);
        }
        g a2 = kotlin.k.j.a(iVar, j4);
        long j6 = a2.first;
        long j7 = a2.SZc;
        long j8 = a2.BMh;
        if (j8 < 0 ? j6 >= j7 : j6 <= j7) {
            while (true) {
                Bitmap frameAtTime = m.getFrameAtTime(j6);
                p.g(frameAtTime, "bitmap");
                Bitmap a3 = a(frameAtTime, adVar.Gzx, i2, i3);
                width = a3.getWidth();
                height = a3.getHeight();
                linkedList.add(new b(BitmapUtil.Bitmap2Bytes(a3, 20)));
                if (((long) linkedList.size()) >= j2 || j6 == j7) {
                    i2 = width;
                } else {
                    j6 += j8;
                }
            }
            i2 = width;
        } else {
            height = i3;
        }
        m.release();
        cmt cmt = new cmt();
        cmt.id = (long) adVar.id;
        cmt.Msh = linkedList;
        ccw ccw3 = new ccw();
        ccw3.width = (long) i2;
        ccw3.height = (long) height;
        cmt.Msi = ccw3;
        cmt.dDw = 2;
        cmt.MqN = j3;
        AppMethodBeat.o(190721);
        return cmt;
    }

    private final Bitmap a(Bitmap bitmap, j jVar, int i2, int i3) {
        float f2 = 1.0f;
        AppMethodBeat.i(190722);
        if (!jVar.rwL.contains(jVar.iiw)) {
            Log.i(this.TAG, "cropBitmap: cropInfo is Error?");
        }
        float width = (((float) bitmap.getWidth()) * 1.0f) / ((float) jVar.rwL.width());
        float width2 = (((float) i2) * 1.0f) / ((float) jVar.iiw.width());
        float height = (((float) i3) * 1.0f) / ((float) jVar.iiw.height());
        if (width2 < 1.0f || height < 1.0f) {
            f2 = Math.min(width2, height);
        }
        int i4 = (int) (((float) (jVar.iiw.left - jVar.rwL.left)) * width);
        int i5 = (int) (((float) (jVar.iiw.top - jVar.rwL.top)) * width);
        int width3 = (int) (((float) jVar.iiw.width()) * width);
        int height2 = (int) (((float) jVar.iiw.height()) * width);
        Matrix matrix = new Matrix();
        float f3 = f2 / width;
        float f4 = f2 / width;
        matrix.setScale(f3, f4);
        Log.i(this.TAG, "cropBitmap, left:" + i4 + ", top:" + i5 + ", width:" + width3 + ", height:" + height2 + ", scaleX:" + f3 + ", scaleY:" + f4 + ", bitmap size:[" + bitmap.getWidth() + ", " + bitmap.getHeight() + ']');
        if (i4 >= 0 && i5 >= 0 && i4 + width3 <= bitmap.getWidth() && i5 + height2 <= bitmap.getHeight()) {
            bitmap = Bitmap.createBitmap(bitmap, i4, i5, width3, height2, matrix, true);
            p.g(bitmap, "Bitmap.createBitmap(orig…eight, scaleMatrix, true)");
        }
        AppMethodBeat.o(190722);
        return bitmap;
    }
}
