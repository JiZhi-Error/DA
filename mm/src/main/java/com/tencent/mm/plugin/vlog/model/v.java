package com.tencent.mm.plugin.vlog.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.vlog.model.local.a;
import com.tencent.mm.plugin.vlog.model.z;
import com.tencent.mm.protocal.protobuf.bha;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.videocomposition.c;
import com.tencent.mm.videocomposition.d;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.d.b.a.f;
import kotlin.d.b.a.j;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.r;
import kotlin.x;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.g;

@l(hxD = {1, 1, 16}, hxE = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010:\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\t2\b\b\u0002\u0010<\u001a\u00020\u0014J\u001a\u0010=\u001a\u00020\u00072\b\b\u0002\u0010>\u001a\u00020\u000b2\b\b\u0002\u0010?\u001a\u00020\u000fJ\u0006\u0010@\u001a\u00020\u0007J\u000e\u0010A\u001a\u00020\u00072\u0006\u0010B\u001a\u00020CJ\u000e\u0010D\u001a\u00020\u00072\u0006\u0010E\u001a\u00020\rJ\\\u0010F\u001a\u00020\u00072\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\r0H2\"\b\u0002\u0010I\u001a\u001c\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0J\u0018\u00010H2\"\b\u0002\u0010K\u001a\u001c\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0J\u0018\u00010HJ\u0006\u0010L\u001a\u00020\tJ\b\u0010M\u001a\u0004\u0018\u00010\rJ\u0006\u0010N\u001a\u00020OJ\b\u0010P\u001a\u00020\u0007H\u0016J\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u000bJ\u001e\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010Q\u001a\u00020\u000f2\u0006\u0010R\u001a\u00020\u000fJ@\u0010S\u001a\u00020\u00072\u0006\u0010T\u001a\u00020\u00142\b\b\u0002\u0010Q\u001a\u00020\u000f2\b\b\u0002\u0010R\u001a\u00020\u000f2\b\b\u0002\u0010U\u001a\u00020\u000b2\b\b\u0002\u0010V\u001a\u00020\u000b2\b\b\u0002\u0010W\u001a\u00020\u0014J\u0006\u0010X\u001a\u00020\u0007J\u000e\u0010Y\u001a\u00020O2\u0006\u0010>\u001a\u00020\u000bJ\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020[0HJ\u0006\u0010\\\u001a\u00020\u0011J\u0006\u0010]\u001a\u00020^J\f\u0010_\u001a\b\u0012\u0004\u0012\u00020\r0HJ\u0006\u0010`\u001a\u00020^J\u0006\u0010a\u001a\u00020'J\u0006\u0010b\u001a\u00020\u0014J(\u0010c\u001a\u00020\u00072\b\b\u0002\u0010d\u001a\u00020\u000b2\b\b\u0002\u0010e\u001a\u00020\u000b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0016\u0010f\u001a\u00020\u00072\u0006\u0010g\u001a\u00020\u000b2\u0006\u0010h\u001a\u00020\u000bJ\u0006\u0010i\u001a\u00020\u0011J\u0006\u0010j\u001a\u00020kJ\u000e\u0010l\u001a\u00020\u00072\u0006\u0010m\u001a\u00020\u0011J\u0010\u0010n\u001a\u00020\u00072\b\u0010E\u001a\u0004\u0018\u00010\rJ\u000e\u0010o\u001a\u00020\u00072\u0006\u0010p\u001a\u00020\u000fJ\u0018\u0010q\u001a\u00020\u00072\u0006\u0010&\u001a\u00020'2\b\b\u0002\u0010r\u001a\u00020\u0014J\u0016\u0010s\u001a\u00020\u00072\u0006\u0010t\u001a\u00020\u000b2\u0006\u0010u\u001a\u00020\u000bJ\u0016\u0010v\u001a\u00020\u00072\u0006\u0010t\u001a\u00020\u000b2\u0006\u0010u\u001a\u00020\u000bJ=\u0010w\u001a\u0004\u0018\u00010\u00072\f\u0010x\u001a\b\u0012\u0004\u0012\u00020\u00040H2\f\u0010y\u001a\b\u0012\u0004\u0012\u00020\u000b0H2\f\u0010z\u001a\b\u0012\u0004\u0012\u00020\u000b0HH@ø\u0001\u0000¢\u0006\u0002\u0010{J\u0016\u0010|\u001a\u00020\u00072\u0006\u0010}\u001a\u00020\u00142\u0006\u0010~\u001a\u00020^J\u0006\u0010\u001a\u00020\u0007J\u001d\u0010\u0001\u001a\u00020\u00072\u0006\u0010B\u001a\u00020C2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\r0HJ\u000f\u0010\u0001\u001a\u00020\u00072\u0006\u0010&\u001a\u00020'J\u0017\u0010\u0001\u001a\u00020\u00072\u0006\u0010Q\u001a\u00020\u000f2\u0006\u0010R\u001a\u00020\u000fJ\u0006\u00106\u001a\u00020\u0014R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u000e\u0010\u001a\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R+\u0010\u001f\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010!¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00070 X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00040,¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0014\u0010/\u001a\b\u0012\u0004\u0012\u00020\r0,X\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\b\u0012\u0004\u0012\u0002020,X\u0004¢\u0006\u0002\n\u0000R\u0014\u00103\u001a\b\u0012\u0004\u0012\u00020\r0,X\u0004¢\u0006\u0002\n\u0000R\u0017\u00104\u001a\b\u0012\u0004\u0012\u00020\u000b0,¢\u0006\b\n\u0000\u001a\u0004\b5\u0010.R\u000e\u00106\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020'X\u0004¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0001"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/MultiMediaModel;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "()V", "TAG", "", "callback", "Lkotlin/Function0;", "", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "editIndex", "", "editTrack", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "editTrackEnd", "", "editTrackPlayRate", "", "editTrackStart", "isAllImage", "", "()Z", "setAllImage", "(Z)V", "isAllVideo", "setAllVideo", "isLoading", "lastPlayRange", "Lcom/tencent/mm/plugin/vlog/model/PlayRange;", "legendData", "Lcom/tencent/mm/plugin/vlog/model/VLogDataManager;", "legendDataCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/GenerateVlogRespBody;", "Lkotlin/ParameterName;", "name", "result", "maxDuration", "maxVisibleRect", "Landroid/graphics/RectF;", "normalCropRatio", "normalHeight", "normalWidth", "pathList", "Ljava/util/LinkedList;", "getPathList", "()Ljava/util/LinkedList;", "playingList", "scriptIndex", "sourceList", "Lcom/tencent/mm/plugin/vlog/model/SourceMaterial;", "sourceTrackList", "typeList", "getTypeList", "vLogLoaded", "visibleRect", "vlogHeight", "vlogWidth", "createCompositionFromComposition", "refComposition", "cutComposition", "createCompositionFromScript", FirebaseAnalytics.b.INDEX, "maxDurationMs", "createCompositionFromSource", "createCompositionFromTemplate", MessengerShareContentUtility.ATTACHMENT_TEMPLATE_TYPE, "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoTemplateInfo;", "createCompositionFromTrack", FFmpegMetadataRetriever.METADATA_KEY_TRACK, "createCompositionFromTrackList", "trackList", "", "recordResult", "Lkotlin/Triple;", "ttsResult", "currentComposition", "currentEditTrack", "currentScript", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "dead", "start", "end", "endEditTrack", "confirm", "cutCnt", "scrollCnt", "clearEdit", "endMoveTrack", "getIndexScript", "getMusicList", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicInfo;", "getNormalCropRatio", "getNormalSize", "Landroid/util/Size;", "getSourceTrack", "getVLogSize", "getVisibleRect", "isVLog", "loadVLogScript", "sid", "fid", "moveTrack", "fromPosition", "toPosition", "refFullScreenRatio", "refFullScreenVisibleRect", "Landroid/graphics/Rect;", "scaleEdit", "playRate", "selectTrack", "setMaxDuration", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "setMaxVisibleRect", "cropToNormalRatio", "setNormalMaxSize", "width", "height", "setVLogSize", "setup", "paths", "types", "sourceFrom", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setupFullScreenSourceTrackCrop", "byWidth", "screenSize", "setupSourceTrackCrop", "setupSourceTrackCropByVideoTemplate", "transformFullScreenSourceTrackCrop", "updateEdit", "plugin-vlog_release"})
public final class v implements com.tencent.mm.vending.e.a {
    public long Gfd;
    public ac GxA;
    private int GyA;
    private int GyB;
    private int GyC;
    private int GyD;
    float GyE;
    public final RectF GyF;
    private final RectF GyG;
    private final ae GyH;
    private final kotlin.g.a.b<bha, x> GyI;
    boolean GyJ;
    private final LinkedList<ad> GyK;
    private int GyL;
    private int GyM;
    public ad GyN;
    private long GyO;
    private long GyP;
    private float GyQ;
    private final x GyR;
    public final LinkedList<String> Gyv = new LinkedList<>();
    final LinkedList<z> Gyw = new LinkedList<>();
    public final LinkedList<ad> Gyx = new LinkedList<>();
    public boolean Gyy;
    public boolean Gyz;
    final String TAG = "MicroMsg.MultiMediaModel";
    boolean isLoading;
    final LinkedList<Integer> tmP = new LinkedList<>();
    kotlin.g.a.a<x> uGD;

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, hxF = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    @f(c = "com.tencent.mm.plugin.vlog.model.MultiMediaModel$setup$2", f = "MultiMediaModel.kt", hxM = {PlayerException.EXCEPTION_TYPE_CONNECT_FAIL}, m = "invokeSuspend")
    public static final class b extends j implements m<ai, d<? super x>, Object> {
        final /* synthetic */ v GyS;
        final /* synthetic */ List GyT;
        final /* synthetic */ List GyU;
        final /* synthetic */ List GyV;
        Object L$0;
        int label;
        private ai p$;
        Object pED;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(v vVar, List list, List list2, List list3, d dVar) {
            super(2, dVar);
            this.GyS = vVar;
            this.GyT = list;
            this.GyU = list2;
            this.GyV = list3;
        }

        @Override // kotlin.d.b.a.a
        public final d<x> create(Object obj, d<?> dVar) {
            AppMethodBeat.i(190594);
            p.h(dVar, "completion");
            b bVar = new b(this.GyS, this.GyT, this.GyU, this.GyV, dVar);
            bVar.p$ = (ai) obj;
            AppMethodBeat.o(190594);
            return bVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final Object invoke(ai aiVar, d<? super x> dVar) {
            AppMethodBeat.i(190595);
            Object invokeSuspend = ((b) create(aiVar, dVar)).invokeSuspend(x.SXb);
            AppMethodBeat.o(190595);
            return invokeSuspend;
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "Landroid/graphics/Bitmap;", "invoke", "com/tencent/mm/plugin/vlog/model/MultiMediaModel$setup$2$3$1"})
        public static final class a extends q implements m<Long, Bitmap, x> {
            final /* synthetic */ b GyW;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(b bVar) {
                super(2);
                this.GyW = bVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final /* synthetic */ x invoke(Long l, Bitmap bitmap) {
                AppMethodBeat.i(190592);
                l.longValue();
                Log.i(this.GyW.GyS.TAG, "setup: get first frame");
                x xVar = x.SXb;
                AppMethodBeat.o(190592);
                return xVar;
            }
        }

        @Override // kotlin.d.b.a.a
        public final Object invokeSuspend(Object obj) {
            LinkedList<ad> linkedList;
            Object obj2;
            boolean z;
            boolean z2;
            AppMethodBeat.i(190593);
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    ai aiVar = this.p$;
                    this.GyS.Gyv.clear();
                    this.GyS.tmP.clear();
                    this.GyS.Gyw.clear();
                    this.GyS.Gyx.clear();
                    this.GyS.Gyv.addAll(this.GyT);
                    this.GyS.tmP.addAll(this.GyU);
                    LinkedList<z> linkedList2 = this.GyS.Gyw;
                    z.a aVar2 = z.Gzf;
                    List list = this.GyT;
                    List list2 = this.GyU;
                    List list3 = this.GyV;
                    p.h(list, "paths");
                    p.h(list2, "types");
                    p.h(list3, "sourceFrom");
                    LinkedList linkedList3 = new LinkedList();
                    int i2 = 0;
                    for (Object obj3 : list) {
                        int i3 = i2 + 1;
                        if (i2 < 0) {
                            kotlin.a.j.hxH();
                        }
                        String str = (String) obj3;
                        Integer num = (Integer) kotlin.a.j.L(list2, i2);
                        if (num != null && num.intValue() == 2) {
                            z.a aVar3 = z.Gzf;
                            ak aTY = z.a.aTY(str);
                            if (aTY != null) {
                                aTY.Gze = ((Number) list3.get(i2)).intValue();
                                linkedList3.add(aTY);
                                i2 = i3;
                            } else {
                                i2 = i3;
                            }
                        } else {
                            z.a aVar4 = z.Gzf;
                            p.h(str, "path");
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            options.inJustDecodeBounds = true;
                            MMBitmapFactory.decodeFile(str, options);
                            int aTX = z.a.aTX(str);
                            int i4 = options.outWidth;
                            int i5 = options.outHeight;
                            if (aTX == 90 || aTX == 270) {
                                i4 = options.outHeight;
                                i5 = options.outWidth;
                            }
                            r rVar = new r(i4, i5, str);
                            rVar.Gze = ((Number) list3.get(i2)).intValue();
                            linkedList3.add(rVar);
                            i2 = i3;
                        }
                    }
                    linkedList2.addAll(linkedList3);
                    v vVar = this.GyS;
                    LinkedList<z> linkedList4 = this.GyS.Gyw;
                    if (!(linkedList4 instanceof Collection) || !linkedList4.isEmpty()) {
                        Iterator<T> it = linkedList4.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (!(it.next() instanceof r)) {
                                    z = false;
                                }
                            }
                        }
                    }
                    z = true;
                    vVar.Gyy = z;
                    v vVar2 = this.GyS;
                    LinkedList<z> linkedList5 = this.GyS.Gyw;
                    if (!(linkedList5 instanceof Collection) || !linkedList5.isEmpty()) {
                        Iterator<T> it2 = linkedList5.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                if (!(it2.next() instanceof ak)) {
                                    z2 = false;
                                }
                            }
                        }
                    }
                    z2 = true;
                    vVar2.Gyz = z2;
                    v vVar3 = this.GyS;
                    com.tencent.mm.plugin.vlog.util.a aVar5 = com.tencent.mm.plugin.vlog.util.a.GQC;
                    float f2 = (((float) this.GyS.Gyw.get(0).height) * 1.0f) / ((float) this.GyS.Gyw.get(0).width);
                    if (f2 > com.tencent.mm.plugin.vlog.util.a.fEA()) {
                        f2 = com.tencent.mm.plugin.vlog.util.a.fEA();
                    } else if (f2 < 0.5625f) {
                        f2 = 0.5625f;
                    }
                    vVar3.GyE = f2;
                    LinkedList<ad> linkedList6 = this.GyS.Gyx;
                    z.a aVar6 = z.Gzf;
                    this.L$0 = aiVar;
                    this.pED = linkedList6;
                    this.label = 1;
                    obj2 = g.a(ba.hMW(), new z.a.C1851a(this.GyS.Gyw, null), this);
                    if (obj2 != aVar) {
                        linkedList = linkedList6;
                        break;
                    } else {
                        AppMethodBeat.o(190593);
                        return aVar;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure(obj);
                    obj2 = obj;
                    linkedList = (LinkedList) this.pED;
                    break;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    AppMethodBeat.o(190593);
                    throw illegalStateException;
            }
            linkedList.addAll((Collection) obj2);
            ad adVar = (ad) kotlin.a.j.L(this.GyS.Gyx, 0);
            if (adVar != null) {
                c.a aVar7 = c.RgU;
                c b2 = c.a.b(adVar.GzA);
                b2.setSize(63, 112);
                b2.b(kotlin.a.j.listOf(kotlin.d.b.a.b.Pe(0)), new a(this));
                x xVar = x.SXb;
                AppMethodBeat.o(190593);
                return xVar;
            }
            AppMethodBeat.o(190593);
            return null;
        }
    }

    public v() {
        AppMethodBeat.i(190618);
        com.tencent.mm.plugin.vlog.util.a aVar = com.tencent.mm.plugin.vlog.util.a.GQC;
        this.GyE = com.tencent.mm.plugin.vlog.util.a.fEA();
        this.GyF = new RectF();
        this.GyG = new RectF();
        this.GyH = new ae();
        this.GyI = new a(this);
        this.GxA = new ac(kotlin.a.v.SXr);
        this.GyK = new LinkedList<>();
        this.GyL = -1;
        this.GyM = -1;
        this.GyQ = 1.0f;
        this.GyR = new x();
        AppMethodBeat.o(190618);
    }

    public final Object a(List<String> list, List<Integer> list2, List<Integer> list3, d<? super x> dVar) {
        AppMethodBeat.i(190596);
        Object a2 = g.a(ba.hMW(), new b(this, list, list2, list3, null), dVar);
        AppMethodBeat.o(190596);
        return a2;
    }

    public final void a(RectF rectF, boolean z) {
        AppMethodBeat.i(190597);
        p.h(rectF, "maxVisibleRect");
        this.GyG.set(rectF);
        this.GyF.set(rectF);
        if (z) {
            this.GyF.inset(0.0f, (rectF.height() - (rectF.width() * this.GyE)) / 2.0f);
        }
        AppMethodBeat.o(190597);
    }

    public final float fBk() {
        AppMethodBeat.i(190598);
        ad first = this.Gyx.getFirst();
        if (first != null) {
            float f2 = ((float) first.Gzu) / ((float) first.Gzv);
            AppMethodBeat.o(190598);
            return f2;
        }
        com.tencent.mm.plugin.vlog.util.a aVar = com.tencent.mm.plugin.vlog.util.a.GQC;
        float fEA = com.tencent.mm.plugin.vlog.util.a.fEA();
        AppMethodBeat.o(190598);
        return fEA;
    }

    public final Rect fBl() {
        AppMethodBeat.i(190599);
        Rect rect = this.Gyx.getFirst().Gzx.rwL;
        AppMethodBeat.o(190599);
        return rect;
    }

    public final void a(boolean z, Size size) {
        AppMethodBeat.i(190600);
        p.h(size, "screenSize");
        z.c cVar = new z.c();
        z.d dVar = new z.d();
        z.d dVar2 = new z.d();
        Rect rect = new Rect();
        int i2 = 0;
        for (T t : this.Gyx) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                kotlin.a.j.hxH();
            }
            T t2 = t;
            j jVar = t2.Gzx;
            float f2 = ((float) t2.Gzv) / ((float) t2.Gzu);
            if (i2 == 0) {
                dVar.SYE = size.getWidth();
                dVar2.SYE = size.getHeight();
            } else {
                dVar.SYE = rect.width();
                dVar2.SYE = rect.height();
            }
            cVar.SYD = ((float) dVar2.SYE) / ((float) dVar.SYE);
            if ((i2 != 0 || !z) && (i2 == 0 || f2 <= cVar.SYD)) {
                float f3 = ((float) dVar2.SYE) / f2;
                float f4 = (((float) dVar.SYE) - f3) / 2.0f;
                jVar.rwL.set((int) f4, 0, (int) (f3 + f4), dVar2.SYE);
            } else {
                float f5 = f2 * ((float) dVar.SYE);
                float f6 = (((float) dVar2.SYE) - f5) / 2.0f;
                jVar.rwL.set(0, (int) f6, dVar.SYE, (int) (f5 + f6));
            }
            if (i2 == 0) {
                Rect rect2 = jVar.rwL;
                if (size.getWidth() * size.getHeight() < rect2.width() * rect2.height()) {
                    rect.set(0, 0, size.getWidth(), size.getHeight());
                } else {
                    rect.set(rect2);
                }
            }
            t.a(jVar.gT, new RectF(0.0f, 0.0f, (float) t2.Gzu, (float) t2.Gzv), new RectF(rect));
            jVar.xnf = t.e(jVar.gT);
            jVar.aXt = jVar.xnf * 5.0f;
            jVar.aXu = jVar.xnf * 0.25f;
            t2.GzA.Rhb = true;
            i2 = i3;
        }
        AppMethodBeat.o(190600);
    }

    public final void g(RectF rectF) {
        AppMethodBeat.i(190601);
        p.h(rectF, "maxVisibleRect");
        int i2 = 0;
        for (T t : this.Gyx) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                kotlin.a.j.hxH();
            }
            T t2 = t;
            j jVar = t2.Gzx;
            if (i2 == 0) {
                jVar.rwL.offset(-((int) rectF.left), -((int) rectF.top));
            }
            t2.GzA.iiw.set(jVar.rwL);
            jVar.viewRect.set(jVar.rwL);
            i2 = i3;
        }
        AppMethodBeat.o(190601);
    }

    public final void fBm() {
        AppMethodBeat.i(190602);
        for (T t : this.Gyx) {
            j jVar = t.Gzx;
            if (jVar.gT.isIdentity()) {
                float f2 = (((float) t.Gzv) * 1.0f) / ((float) t.Gzu);
                this.GyF.round(jVar.rwL);
                if (f2 > this.GyF.height() / this.GyF.width()) {
                    float width = ((((this.GyF.width() * 1.0f) / ((float) t.Gzu)) * ((float) t.Gzv)) - this.GyF.height()) / 2.0f;
                    jVar.rwL.top = (int) (this.GyF.top - width);
                    jVar.rwL.bottom = (int) (width + this.GyF.bottom);
                } else {
                    float height = ((((this.GyF.height() * 1.0f) / ((float) t.Gzv)) * ((float) t.Gzu)) - this.GyF.width()) / 2.0f;
                    jVar.rwL.left = (int) (this.GyF.left - height);
                    jVar.rwL.right = (int) (height + this.GyF.right);
                }
                this.GyF.round(jVar.iiw);
                t.a(jVar.gT, new RectF(0.0f, 0.0f, (float) t.Gzu, (float) t.Gzv), new RectF(jVar.rwL));
                jVar.rwL.offset(-((int) this.GyG.left), -((int) this.GyG.top));
                t.GzA.iiw.set(jVar.rwL);
                jVar.xnf = t.e(jVar.gT);
                jVar.aXt = jVar.xnf * 5.0f;
                jVar.aXu = jVar.xnf * 0.25f;
            }
            t.GzA.Rhb = true;
        }
        AppMethodBeat.o(190602);
    }

    public final void jq(int i2, int i3) {
        AppMethodBeat.i(190603);
        this.GyA = i2;
        this.GyB = i3;
        ae aeVar = this.GyH;
        Log.i("MicroMsg.VLogDataManager", "setPreviewSize, width:" + i2 + ", " + i3);
        aeVar.previewHeight = i3;
        aeVar.previewWidth = i2;
        AppMethodBeat.o(190603);
    }

    public final void jr(int i2, int i3) {
        this.GyC = i2;
        this.GyD = i3;
    }

    public final Size fBn() {
        AppMethodBeat.i(190604);
        Size size = new Size(this.GyC, this.GyD);
        AppMethodBeat.o(190604);
        return size;
    }

    public final void acx(int i2) {
        AppMethodBeat.i(190605);
        Log.i(this.TAG, "editTrack index:".concat(String.valueOf(i2)));
        this.GyM = i2;
        this.GyR.start = this.GxA.Gez.getPlayStart();
        this.GyR.boX = this.GxA.Gez.fBz();
        if (this.GyM >= 0 && this.GyM < this.GyK.size()) {
            ad adVar = this.GyK.get(this.GyM);
            p.g(adVar, "playingList[editIndex]");
            ad adVar2 = adVar;
            this.GyN = adVar2;
            this.GyO = adVar2.GzA.GGz;
            this.GyP = adVar2.GzA.GGA;
            this.GyQ = adVar2.GzA.mwH;
            ad adVar3 = new ad(adVar2.path, adVar2.type);
            adVar3.KR(adVar2.GzA.GJB);
            adVar3.KP((long) (((float) adVar2.GzA.GJB) / adVar2.GzA.mwH));
            adVar3.setPlayRate(adVar2.GzA.mwH);
            adVar3.Gzu = adVar2.Gzu;
            adVar3.Gzv = adVar2.Gzv;
            adVar3.Gzx.iiw.set(adVar2.Gzx.iiw);
            adVar3.Gzx.rwL.set(adVar2.Gzx.rwL);
            adVar3.Gzx.viewRect.set(adVar2.Gzx.viewRect);
            adVar3.Gzx.gT.set(adVar2.Gzx.gT);
            adVar3.GzA.iiw.set(adVar2.GzA.iiw);
            adVar3.GzA.gKp();
            p.h(adVar3, FFmpegMetadataRetriever.METADATA_KEY_TRACK);
            this.GxA = new ac(kotlin.a.j.listOf(adVar3));
            this.GxA.jt(this.GyC, this.GyD);
            ac acVar = this.GxA;
            com.tencent.mm.plugin.vlog.model.local.a aVar = com.tencent.mm.plugin.vlog.model.local.a.GAD;
            acVar.a(com.tencent.mm.plugin.vlog.model.local.a.fBP());
            this.GxA.at((long) (((float) this.GyO) / this.GyQ), (long) (((float) this.GyP) / this.GyQ));
        }
        AppMethodBeat.o(190605);
    }

    public final void cf(float f2) {
        AppMethodBeat.i(190606);
        ad adVar = this.GyN;
        if (adVar != null) {
            adVar.setPlayRate(f2);
            adVar.GzA.gKp();
        }
        ad adVar2 = (ad) kotlin.a.j.kt(this.GxA.Gzn);
        if (adVar2 != null) {
            adVar2.setPlayRate(f2);
            adVar2.GzA.gKp();
            this.GxA.at(adVar2.GzA.startTimeMs, adVar2.GzA.endTimeMs);
            AppMethodBeat.o(190606);
            return;
        }
        AppMethodBeat.o(190606);
    }

    public final void aw(long j2, long j3) {
        AppMethodBeat.i(190607);
        this.GxA.at(j2, j3);
        AppMethodBeat.o(190607);
    }

    public static /* synthetic */ void a(v vVar) {
        AppMethodBeat.i(190609);
        vVar.a(true, -1, -1, 0, 0, false);
        AppMethodBeat.o(190609);
    }

    public final void a(boolean z, long j2, long j3, int i2, int i3, boolean z2) {
        AppMethodBeat.i(190608);
        Log.i(this.TAG, "endEditTrack editIndex:" + this.GyM + ", confirm:" + z + ", start:" + j2 + ", end:" + j3);
        if (this.GyM >= 0 && this.GyM < this.GyK.size()) {
            ad adVar = this.GyK.get(this.GyM);
            p.g(adVar, "playingList[editIndex]");
            ad adVar2 = adVar;
            adVar2.Gzz.clickEditCount++;
            adVar2.Gzz.durationCutCount += i2;
            adVar2.Gzz.durationScrollCount += i3;
            if (!z || j2 < 0 || j3 < 0) {
                adVar2.KQ(this.GyO);
                adVar2.KR(this.GyP);
            } else {
                adVar2.KQ((long) (((float) j2) * adVar2.GzA.mwH));
                adVar2.KR((long) (((float) j3) * adVar2.GzA.mwH));
            }
            adVar2.Gzz.targetDuration = (long) (((float) (adVar2.GzA.GGA - adVar2.GzA.GGz)) / adVar2.GzA.mwH);
            if (z2) {
                this.GyN = null;
                this.GyM = -1;
            }
            d.a aVar = com.tencent.mm.videocomposition.d.Rhf;
            LinkedList<ad> linkedList = this.GyK;
            ArrayList arrayList = new ArrayList(kotlin.a.j.a(linkedList, 10));
            Iterator<T> it = linkedList.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().GzA);
            }
            d.a.jZ(arrayList);
        }
        this.GxA = new ac(this.GyK);
        this.GxA.KN(this.Gfd);
        ac acVar = this.GxA;
        com.tencent.mm.plugin.vlog.model.local.a aVar2 = com.tencent.mm.plugin.vlog.model.local.a.GAD;
        acVar.a(com.tencent.mm.plugin.vlog.model.local.a.fBP());
        this.GxA.jt(this.GyC, this.GyD);
        AppMethodBeat.o(190608);
    }

    public final void p(int i2, long j2, long j3) {
        AppMethodBeat.i(190610);
        Log.i(this.TAG, "editTrack editIndex:" + i2 + ", start:" + j2 + ", end:" + j3);
        if (i2 >= 0 && i2 < this.GyK.size()) {
            ad adVar = this.GyK.get(i2);
            p.g(adVar, "playingList[editIndex]");
            ad adVar2 = adVar;
            if (j2 >= 0 && j3 >= 0) {
                adVar2.KQ(j2);
                adVar2.KR(j3);
            }
            d.a aVar = com.tencent.mm.videocomposition.d.Rhf;
            LinkedList<ad> linkedList = this.GyK;
            ArrayList arrayList = new ArrayList(kotlin.a.j.a(linkedList, 10));
            Iterator<T> it = linkedList.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().GzA);
            }
            d.a.jZ(arrayList);
        }
        this.GxA = new ac(this.GyK);
        this.GxA.KN(this.Gfd);
        ac acVar = this.GxA;
        com.tencent.mm.plugin.vlog.model.local.a aVar2 = com.tencent.mm.plugin.vlog.model.local.a.GAD;
        acVar.a(com.tencent.mm.plugin.vlog.model.local.a.fBP());
        this.GxA.jt(this.GyC, this.GyD);
        AppMethodBeat.o(190610);
    }

    public final void js(int i2, int i3) {
        AppMethodBeat.i(190611);
        Collections.swap(this.GyK, i2, i3);
        AppMethodBeat.o(190611);
    }

    public final void fBo() {
        AppMethodBeat.i(190612);
        this.GxA = new ac(this.GyK);
        this.GxA.jt(this.GyC, this.GyD);
        AppMethodBeat.o(190612);
    }

    public final void fBp() {
        AppMethodBeat.i(190613);
        this.GyL = -1;
        this.GyK.clear();
        this.GyK.addAll(this.Gyx);
        this.GxA = new ac(this.GyK);
        this.GxA.KN(this.Gfd);
        ac acVar = this.GxA;
        com.tencent.mm.plugin.vlog.model.local.a aVar = com.tencent.mm.plugin.vlog.model.local.a.GAD;
        acVar.a(com.tencent.mm.plugin.vlog.model.local.a.fBP());
        this.GxA.jt(this.GyC, this.GyD);
        AppMethodBeat.o(190613);
    }

    public final void c(a.c cVar) {
        AppMethodBeat.i(190614);
        p.h(cVar, MessengerShareContentUtility.ATTACHMENT_TEMPLATE_TYPE);
        this.GyL = -1;
        this.GyK.clear();
        com.tencent.mm.plugin.vlog.model.local.a aVar = com.tencent.mm.plugin.vlog.model.local.a.GAD;
        List<ad> a2 = com.tencent.mm.plugin.vlog.model.local.a.a(cVar, this.Gyx);
        p.h(cVar, MessengerShareContentUtility.ATTACHMENT_TEMPLATE_TYPE);
        p.h(a2, "trackList");
        if (cVar.GAH) {
            for (T t : a2) {
                Size size = cVar.ApT;
                double width = (1.0d * ((double) size.getWidth())) / ((double) size.getHeight());
                t.GzA.iiw.setEmpty();
                if ((1.0d * ((double) t.GzA.Gzu)) / ((double) t.GzA.Gzv) < width) {
                    int i2 = t.GzA.Gzu;
                    double d2 = ((double) i2) / width;
                    Rect rect = new Rect();
                    rect.left = 0;
                    rect.right = i2;
                    rect.top = (int) ((((double) t.GzA.Gzv) - d2) / 2.0d);
                    rect.bottom = (int) (d2 + ((double) rect.top));
                    t.GzA.Rha.set(rect);
                } else {
                    int i3 = t.GzA.Gzv;
                    double d3 = width * ((double) i3);
                    Rect rect2 = new Rect();
                    rect2.top = 0;
                    rect2.bottom = i3;
                    rect2.left = (int) ((((double) t.GzA.Gzu) - d3) / 2.0d);
                    rect2.right = (int) (d3 + ((double) rect2.left));
                    t.GzA.Rha.set(rect2);
                }
                t.GzA.Rhb = false;
                Log.i(this.TAG, "track source size:[" + t.GzA.Gzu + ", " + t.GzA.Gzv + "], trackCropRect:" + t.GzA.Rha + ", templateSize:" + cVar.ApT);
            }
        } else {
            for (T t2 : a2) {
                t2.GzA.Rha.set(0, 0, t2.GzA.Gzu, t2.GzA.Gzv);
                t2.GzA.Rhb = false;
            }
        }
        this.GyK.addAll(a2);
        this.GxA = new ac(this.GyK);
        this.GxA.KN(cVar.duration);
        ac acVar = this.GxA;
        com.tencent.mm.plugin.vlog.model.local.a aVar2 = com.tencent.mm.plugin.vlog.model.local.a.GAD;
        acVar.a(com.tencent.mm.plugin.vlog.model.local.a.fBP());
        this.GxA.jt(this.GyC, (int) (((double) this.GyC) / ((1.0d * ((double) cVar.ApT.getWidth())) / ((double) cVar.ApT.getHeight()))));
        this.GxA.wB(false);
        ac.a(this.GxA, cVar.iiv);
        AppMethodBeat.o(190614);
    }

    public final void e(List<ad> list, List<r<String, Long, Long>> list2, List<r<String, Long, Long>> list3) {
        T t;
        ArrayList arrayList;
        ArrayList arrayList2;
        AppMethodBeat.i(190616);
        p.h(list, "trackList");
        d.a aVar = com.tencent.mm.videocomposition.d.Rhf;
        ArrayList arrayList3 = new ArrayList();
        for (T t2 : list) {
            T t3 = t2;
            if (t3.type == 2 || t3.type == 1) {
                arrayList3.add(t2);
            }
        }
        ArrayList<ad> arrayList4 = arrayList3;
        ArrayList arrayList5 = new ArrayList(kotlin.a.j.a(arrayList4, 10));
        for (ad adVar : arrayList4) {
            arrayList5.add(adVar.GzA);
        }
        d.a.jZ(arrayList5);
        Iterator<T> it = list.iterator();
        if (!it.hasNext()) {
            t = null;
        } else {
            T next = it.next();
            if (!it.hasNext()) {
                t = next;
            } else {
                long j2 = next.GzA.endTimeMs;
                while (true) {
                    next = it.next();
                    long j3 = next.GzA.endTimeMs;
                    if (j2 < j3) {
                        j2 = j3;
                    } else {
                        next = next;
                    }
                    if (!it.hasNext()) {
                        break;
                    }
                }
                t = next;
            }
        }
        T t4 = t;
        long j4 = t4 != null ? t4.GzA.endTimeMs : Long.MAX_VALUE;
        if (list2 != null) {
            List<r<String, Long, Long>> list4 = list2;
            ArrayList arrayList6 = new ArrayList(kotlin.a.j.a(list4, 10));
            for (T t5 : list4) {
                long longValue = t5.second.longValue();
                long longValue2 = t5.SWY.longValue();
                ad adVar2 = new ad(t5.first, 3);
                adVar2.KO(longValue);
                adVar2.KP(longValue2);
                adVar2.KQ(0);
                adVar2.KR(longValue2 - longValue);
                adVar2.setVolume(3.0f);
                arrayList6.add(adVar2);
            }
            arrayList = arrayList6;
        } else {
            arrayList = null;
        }
        if (list3 != null) {
            List<r<String, Long, Long>> list5 = list3;
            ArrayList arrayList7 = new ArrayList(kotlin.a.j.a(list5, 10));
            for (T t6 : list5) {
                long longValue3 = t6.second.longValue();
                long longValue4 = t6.SWY.longValue();
                ad adVar3 = new ad(t6.first, 3);
                adVar3.KO(longValue3);
                adVar3.KP(Math.min(longValue4, j4));
                adVar3.KQ(0);
                adVar3.KR(longValue4 - longValue3);
                adVar3.setVolume(3.0f);
                arrayList7.add(adVar3);
            }
            arrayList2 = arrayList7;
        } else {
            arrayList2 = null;
        }
        ArrayList arrayList8 = new ArrayList();
        arrayList8.addAll(list);
        if (arrayList != null) {
            arrayList8.addAll(arrayList);
        }
        if (arrayList2 != null) {
            arrayList8.addAll(arrayList2);
        }
        this.GxA = new ac(arrayList8);
        this.GxA.KN(this.Gfd);
        ac acVar = this.GxA;
        com.tencent.mm.plugin.vlog.model.local.a aVar2 = com.tencent.mm.plugin.vlog.model.local.a.GAD;
        acVar.a(com.tencent.mm.plugin.vlog.model.local.a.fBP());
        this.GxA.jt(this.GyC, this.GyD);
        AppMethodBeat.o(190616);
    }

    public final boolean fBq() {
        return this.GyL >= 0;
    }

    @Override // com.tencent.mm.vending.e.a
    public final void dead() {
        AppMethodBeat.i(190617);
        ae aeVar = this.GyH;
        aeVar.GzF = null;
        com.tencent.mm.kernel.g.azz().b(1469, aeVar);
        com.tencent.mm.kernel.g.azz().b(2972, aeVar);
        AppMethodBeat.o(190617);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/protocal/protobuf/GenerateVlogRespBody;", "invoke"})
    static final class a extends q implements kotlin.g.a.b<bha, x> {
        final /* synthetic */ v GyS;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(v vVar) {
            super(1);
            this.GyS = vVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* bridge */ /* synthetic */ x invoke(bha bha) {
            AppMethodBeat.i(190591);
            this.GyS.isLoading = false;
            this.GyS.GyJ = false;
            kotlin.g.a.a<x> aVar = this.GyS.uGD;
            if (aVar != null) {
                aVar.invoke();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(190591);
            return xVar;
        }
    }

    public final void a(ac acVar, boolean z) {
        AppMethodBeat.i(190615);
        p.h(acVar, "refComposition");
        ArrayList<ad> arrayList = acVar.Gzn;
        d.a aVar = com.tencent.mm.videocomposition.d.Rhf;
        ArrayList arrayList2 = new ArrayList();
        for (T t : arrayList) {
            T t2 = t;
            if (t2.type == 2 || t2.type == 1) {
                arrayList2.add(t);
            }
        }
        ArrayList<ad> arrayList3 = arrayList2;
        ArrayList arrayList4 = new ArrayList(kotlin.a.j.a(arrayList3, 10));
        for (ad adVar : arrayList3) {
            arrayList4.add(adVar.GzA);
        }
        d.a.jZ(arrayList4);
        ArrayList arrayList5 = new ArrayList();
        arrayList5.addAll(arrayList);
        this.GxA = new ac(arrayList5);
        if (z) {
            this.GxA.KN(this.Gfd);
        }
        ac acVar2 = this.GxA;
        com.tencent.mm.plugin.vlog.model.local.a aVar2 = com.tencent.mm.plugin.vlog.model.local.a.GAD;
        acVar2.a(com.tencent.mm.plugin.vlog.model.local.a.fBP());
        this.GxA.jt(this.GyC, this.GyD);
        AppMethodBeat.o(190615);
    }
}
