package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.e;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J4\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010J \u0010\u0011\u001a\u00020\u00122\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0014j\b\u0012\u0004\u0012\u00020\u0006`\u0015H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/AdaptiveAdjustBitrateHelper;", "", "()V", "TAG", "", "getABAResult", "Lcom/tencent/mm/plugin/vlog/model/ABAResult;", "videoList", "", "Lcom/tencent/mm/plugin/vlog/model/ABAVideoInfo;", "videoParams", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "targetWidth", "", "targetHeight", "addStickers", "", "sortVideoBitrate", "", "abaParamList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "plugin-vlog_release"})
public final class c {
    public static final c GwZ = new c();
    private static final String TAG = TAG;

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "o1", "Lcom/tencent/mm/plugin/vlog/model/ABAResult;", "kotlin.jvm.PlatformType", "o2", "compare"})
    public static final class a<T> implements Comparator<a> {
        public static final a Gxa = new a();

        static {
            AppMethodBeat.i(190481);
            AppMethodBeat.o(190481);
        }

        a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(a aVar, a aVar2) {
            AppMethodBeat.i(190480);
            a aVar3 = aVar;
            a aVar4 = aVar2;
            if (aVar3 == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.model.ABAResult");
                AppMethodBeat.o(190480);
                throw tVar;
            } else if (aVar4 == null) {
                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.model.ABAResult");
                AppMethodBeat.o(190480);
                throw tVar2;
            } else {
                int i2 = aVar3.bitrate;
                int i3 = aVar4.bitrate;
                if (i3 < i2) {
                    AppMethodBeat.o(190480);
                    return -1;
                } else if (i2 < i3) {
                    AppMethodBeat.o(190480);
                    return 1;
                } else {
                    AppMethodBeat.o(190480);
                    return 0;
                }
            }
        }
    }

    static {
        AppMethodBeat.i(190483);
        AppMethodBeat.o(190483);
    }

    private c() {
    }

    public static a a(List<b> list, VideoTransPara videoTransPara, int i2, int i3, boolean z) {
        boolean z2;
        int i4;
        int i5;
        AppMethodBeat.i(190482);
        p.h(list, "videoList");
        p.h(videoTransPara, "videoParams");
        ArrayList arrayList = new ArrayList();
        try {
            if ((!list.isEmpty()) && videoTransPara.iTg == 1) {
                for (T t : list) {
                    int[] a2 = AdaptiveAdjustBitrate.a(t.path, i3, i2, videoTransPara.fps, videoTransPara.videoBitrate, ((float) (t.GwY - t.GwX)) / 1000.0f, ((float) t.GwX) / 1000.0f, 4, videoTransPara.iTi, videoTransPara.iTj, videoTransPara.iTk, videoTransPara.iTl, videoTransPara.iTm, videoTransPara.iTn, videoTransPara.iTo, z);
                    int i6 = videoTransPara.videoBitrate;
                    int i7 = -1;
                    if (a2 != null) {
                        i6 = a2[0] * 1000;
                        i7 = 0;
                    }
                    if (a2 == null || a2[5] <= 0) {
                        i4 = i3;
                        i5 = i2;
                    } else {
                        i5 = a2[1];
                        i4 = a2[2];
                        i7 = 0;
                    }
                    Log.i(TAG, "ABA:  finder video bitrate:" + i6 + " width: " + i5 + " height:" + i4);
                    if (o.bhk() != null) {
                        e.s(a2);
                    }
                    if (i7 != -1) {
                        arrayList.add(new a(i7, i5, i4, i6, a2));
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2 || videoTransPara.iTg != 1) {
                a aVar = new a(-1, 0, 0, 0, new int[34]);
                AppMethodBeat.o(190482);
                return aVar;
            }
            j.a((List) arrayList, (Comparator) a.Gxa);
            Object obj = arrayList.get(0);
            p.g(obj, "abaParamList[0]");
            a aVar2 = (a) obj;
            AppMethodBeat.o(190482);
            return aVar2;
        } catch (Throwable th) {
            a aVar3 = new a(-1, 0, 0, 0, null);
            AppMethodBeat.o(190482);
            return aVar3;
        }
    }
}
