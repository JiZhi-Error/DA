package com.tencent.mm.plugin.vlog.model;

import android.graphics.Rect;
import android.util.Size;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker;
import com.tencent.mm.plugin.vlog.model.effect.b;
import com.tencent.mm.plugin.vlog.model.local.a;
import com.tencent.mm.protocal.protobuf.acm;
import com.tencent.mm.protocal.protobuf.acn;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.protocal.protobuf.clz;
import com.tencent.mm.protocal.protobuf.dlh;
import com.tencent.mm.protocal.protobuf.eqy;
import com.tencent.mm.protocal.protobuf.jn;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.a.e;
import kotlin.a.j;
import kotlin.g.b.p;

public final class g {
    public static final a GxB = new a((byte) 0);
    private static final String TAG = TAG;
    private final ac GxA;
    private final aco Gxw = new aco();
    private final acm Gxx = new acm();
    private final LinkedList<clz> Gxy = new LinkedList<>();
    private eqy Gxz;

    public g(ac acVar) {
        p.h(acVar, "composition");
        AppMethodBeat.i(190509);
        this.GxA = acVar;
        AppMethodBeat.o(190509);
    }

    public static /* synthetic */ aco a(g gVar, String str, VideoTransPara videoTransPara, Size size, Rect rect, boolean z, int i2) {
        AppMethodBeat.i(190504);
        aco a2 = gVar.a(str, videoTransPara, size, rect, false, (i2 & 32) != 0 ? false : z);
        AppMethodBeat.o(190504);
        return a2;
    }

    public final aco a(String str, VideoTransPara videoTransPara, Size size, Rect rect, boolean z, boolean z2) {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        AppMethodBeat.i(190503);
        p.h(str, "path");
        p.h(videoTransPara, "videoTransPara");
        p.h(size, "previewSize");
        p.h(rect, "cropRect");
        VideoTransPara videoTransPara2 = new VideoTransPara(videoTransPara);
        int i2 = videoTransPara2.width;
        int height = (int) (((float) i2) * (((float) size.getHeight()) / ((float) size.getWidth())));
        videoTransPara2.width = i2;
        videoTransPara2.height = height;
        this.Gxw.rpE = str;
        this.Gxw.xlg = Lt(size.getWidth());
        this.Gxw.xlh = Lt(size.getHeight());
        aco aco = this.Gxw;
        dlh dlh = new dlh();
        i.a(rect, dlh);
        aco.Lnm = dlh;
        if (z2) {
            this.Gxw.targetWidth = Lt(i2);
            this.Gxw.targetHeight = Lt(height);
        } else {
            this.Gxw.targetWidth = Lt(videoTransPara2.width);
            this.Gxw.targetHeight = Lt((videoTransPara2.width * rect.height()) / rect.width());
        }
        aco aco2 = this.Gxw;
        aco2.videoBitrate = videoTransPara.videoBitrate;
        aco2.fps = videoTransPara.fps;
        aco2.iiH = videoTransPara.iiH;
        aco2.audioBitrate = videoTransPara.audioBitrate;
        aco2.audioSampleRate = videoTransPara.audioSampleRate;
        aco2.audioChannelCount = videoTransPara.audioChannelCount;
        aco2.iTg = videoTransPara.iTg;
        ArrayList arrayList = new ArrayList();
        for (T t : this.GxA.Gzn) {
            if (t.type == 2) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (z6) {
                arrayList.add(t);
            }
        }
        if (arrayList.size() == 1) {
            for (T t2 : this.GxA.Gzn) {
                if (t2.type == 2) {
                    z5 = true;
                    continue;
                } else {
                    z5 = false;
                    continue;
                }
                if (z5) {
                    MultiMediaVideoChecker.a aTV = MultiMediaVideoChecker.GyY.aTV(t2.path);
                    if (aTV != null && aTV.width > 0 && aTV.height > 0 && aTV.cKu > 0.0f) {
                        if (!z2 && this.Gxw.targetWidth > aTV.width) {
                            this.Gxw.targetWidth = Lt(aTV.width);
                            this.Gxw.targetHeight = Lt((int) (((1.0d * ((double) rect.height())) / ((double) rect.width())) * ((double) this.Gxw.targetWidth)));
                        }
                        if (!this.GxA.BNS) {
                            if (this.Gxw.audioBitrate > aTV.audioBitrate) {
                                this.Gxw.audioBitrate = aTV.audioBitrate;
                            }
                            if (this.Gxw.audioSampleRate > aTV.audioSampleRate && aTV.audioSampleRate > 1000) {
                                this.Gxw.audioSampleRate = aTV.audioSampleRate;
                            }
                        }
                        this.Gxw.fps = Math.min(this.Gxw.fps, (int) aTV.cKu);
                        this.Gxw.audioChannelCount = Math.min(aTV.audioChannelCount, 2);
                    }
                }
            }
            NoSuchElementException noSuchElementException = new NoSuchElementException("Collection contains no element matching the predicate.");
            AppMethodBeat.o(190503);
            throw noSuchElementException;
        }
        ArrayList arrayList2 = new ArrayList();
        for (T t3 : this.GxA.Gzn) {
            if (t3.type == 2) {
                arrayList2.add(t3);
            }
        }
        ArrayList arrayList3 = arrayList2;
        if (!arrayList3.isEmpty()) {
            Iterator it = arrayList3.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                MultiMediaVideoChecker.a aTV2 = MultiMediaVideoChecker.GyY.aTV(((ad) it.next()).path);
                if (aTV2 == null || aTV2.audioChannelCount != 1) {
                    z4 = false;
                    continue;
                } else {
                    z4 = true;
                    continue;
                }
                if (z4) {
                    z3 = true;
                    break;
                }
            }
        }
        z3 = false;
        if (z3) {
            this.Gxw.audioChannelCount = 1;
        } else {
            this.Gxw.audioChannelCount = 2;
        }
        this.Gxw.audioChannelCount = Math.min(this.Gxw.audioChannelCount, 2);
        if (z) {
            a.a(a.a(this.GxA, videoTransPara, this.Gxw.targetWidth, this.Gxw.targetHeight, this.Gxx.Lna.isEmpty()), this.Gxw);
        }
        this.Gxw.Lnn = (((float) this.Gxw.targetWidth) * 1.0f) / ((float) this.Gxw.xlg);
        Log.i(TAG, "getExportConfig: origin: " + this.Gxw.xlg + ", " + this.Gxw.xlh + ", " + this.Gxw.Lnm + " target: " + this.Gxw.targetWidth + ", " + this.Gxw.targetHeight + ", audio:" + this.Gxw.audioChannelCount + ',' + this.Gxw.audioBitrate + ',' + this.Gxw.audioSampleRate + ", cropRect:" + rect);
        aco aco3 = this.Gxw;
        AppMethodBeat.o(190503);
        return aco3;
    }

    public final void a(Rect rect, float[] fArr, List<? extends com.tencent.mm.plugin.recordvideo.ui.editor.item.a> list) {
        AppMethodBeat.i(190505);
        p.h(rect, "drawingRect");
        p.h(fArr, "validRect");
        p.h(list, "editItems");
        this.Gxx.LmZ = new dlh();
        dlh dlh = this.Gxx.LmZ;
        p.g(dlh, "editData.drawingRect");
        i.a(rect, dlh);
        this.Gxx.Lnc = new dlh();
        Rect rect2 = new Rect((int) fArr[0], (int) fArr[1], (int) fArr[2], (int) fArr[3]);
        dlh dlh2 = this.Gxx.Lnc;
        p.g(dlh2, "editData.validRect");
        i.a(rect2, dlh2);
        LinkedList<jn> linkedList = this.Gxx.Lna;
        List<? extends com.tencent.mm.plugin.recordvideo.ui.editor.item.a> list2 = list;
        ArrayList arrayList = new ArrayList(j.a(list2, 10));
        for (T t : list2) {
            jn jnVar = new jn();
            jnVar.dataType = t.Cex.value;
            jnVar.KOd = z.aC(t.eMk().toByteArray());
            arrayList.add(jnVar);
        }
        linkedList.addAll(arrayList);
        AppMethodBeat.o(190505);
    }

    public final void hM(List<b> list) {
        AppMethodBeat.i(190506);
        p.h(list, "magicList");
        for (T t : list) {
            LinkedList<clz> linkedList = this.Gxy;
            clz clz = new clz();
            clz.path = t.GAm.Cga;
            clz.start = t.start;
            clz.boX = t.boX;
            linkedList.add(clz);
        }
        AppMethodBeat.o(190506);
    }

    public final void a(a.c cVar) {
        AppMethodBeat.i(190507);
        p.h(cVar, MessengerShareContentUtility.ATTACHMENT_TEMPLATE_TYPE);
        this.Gxz = i.b(cVar);
        AppMethodBeat.o(190507);
    }

    public final acn fAQ() {
        AppMethodBeat.i(190508);
        acn a2 = i.a(this.GxA, this.Gxw);
        a2.Gxx = this.Gxx;
        a2.Lnh.addAll(this.Gxy);
        a2.Lni = this.Gxz;
        if (this.Gxz != null) {
            a2.Gzo = false;
        }
        AppMethodBeat.o(190508);
        return a2;
    }

    private static int Lt(int i2) {
        if (i2 % 2 != 0) {
            return i2 - 1;
        }
        return i2;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static a a(ac acVar, VideoTransPara videoTransPara, int i2, int i3, boolean z) {
            b bVar;
            AppMethodBeat.i(190501);
            p.h(acVar, "composition");
            p.h(videoTransPara, "videoParams");
            ArrayList arrayList = new ArrayList();
            for (T t : acVar.Gzn) {
                if (t.type == 2) {
                    bVar = new b(t.path, t.GzA.GGz, t.GzA.GGA);
                } else {
                    bVar = null;
                }
                if (bVar != null) {
                    arrayList.add(bVar);
                }
            }
            c cVar = c.GwZ;
            a a2 = c.a(arrayList, videoTransPara, i2, i3, z);
            AppMethodBeat.o(190501);
            return a2;
        }

        public static void a(a aVar, aco aco) {
            List<Integer> Y;
            AppMethodBeat.i(190502);
            p.h(aVar, "abaResult");
            p.h(aco, "outputConfig");
            if (aVar.errCode == 0) {
                if (aVar.width > 0 && aVar.height > 0 && aVar.bitrate > 0) {
                    aco.targetWidth = aVar.width;
                    aco.targetHeight = aVar.height;
                    aco.videoBitrate = aVar.bitrate;
                    Log.i(g.TAG, "video abaResult, width:" + aco.targetWidth + ", height:" + aco.targetHeight + ", " + aco.videoBitrate);
                }
                int[] iArr = aVar.vRR;
                if (!(iArr == null || (Y = e.Y(iArr)) == null)) {
                    aco.Lno.addAll(Y);
                    AppMethodBeat.o(190502);
                    return;
                }
            }
            AppMethodBeat.o(190502);
        }
    }

    static {
        AppMethodBeat.i(190510);
        AppMethodBeat.o(190510);
    }
}
