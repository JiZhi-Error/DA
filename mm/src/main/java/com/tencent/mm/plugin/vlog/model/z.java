package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import com.tencent.mm.videocomposition.d;
import com.tencent.mm.videocomposition.i;
import com.tencent.rtmp.TXLiveConstants;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.d.b.a.f;
import kotlin.d.b.a.j;
import kotlin.d.d;
import kotlin.f.b;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;
import kotlinx.coroutines.ai;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0016\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/SourceMaterial;", "", "width", "", "height", "type", "fromCamera", "(IIII)V", "getFromCamera", "()I", "setFromCamera", "(I)V", "getHeight", "setHeight", "getType", "setType", "getWidth", "setWidth", "Companion", "plugin-vlog_release"})
public class z {
    public static final a Gzf = new a((byte) 0);
    private static final String TAG = TAG;
    int Gze;
    int height;
    private int type;
    int width;

    private z(int i2, int i3, int i4) {
        this.width = i2;
        this.height = i3;
        this.type = i4;
        this.Gze = 0;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J6\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u000f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\u000f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fJ2\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u000f2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u000f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\nJ\u0010\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u001e\u001a\u00020\nJ\u0010\u0010!\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\nH\u0002J\u001b\u0010\"\u001a\u0004\u0018\u00010\u00102\u0006\u0010#\u001a\u00020\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010$R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/SourceMaterial$Companion;", "", "()V", "CropMinDuration", "", "ImageSourceDuration", "MaxHeight", "", "MaxWidth", "TAG", "", "TypeImage", "TypeVideo", "VideoTrackMaxDuration", "asyncSourceToTrackList", "", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "sources", "Lcom/tencent/mm/plugin/vlog/model/SourceMaterial;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createFromPath", "paths", "types", "sourceFrom", "images", "videos", "indices", "", "createImageSource", "Lcom/tencent/mm/plugin/vlog/model/ImageSource;", "path", "createVideoSource", "Lcom/tencent/mm/plugin/vlog/model/VideoSource;", "getImageRotate", "sourceToTrack", "source", "(Lcom/tencent/mm/plugin/vlog/model/SourceMaterial;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plugin-vlog_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        static int aTX(String str) {
            android.support.e.a aVar;
            Throwable th;
            Integer num = null;
            Throwable th2 = null;
            AppMethodBeat.i(190642);
            InputStream openRead = s.openRead(str);
            if (openRead != null) {
                InputStream inputStream = openRead;
                try {
                    android.support.e.a aVar2 = new android.support.e.a(inputStream);
                    x xVar = x.SXb;
                    b.a(inputStream, null);
                    aVar = aVar2;
                } catch (Throwable th3) {
                    th = th3;
                    th2 = th;
                    b.a(inputStream, th2);
                    AppMethodBeat.o(190642);
                    throw th;
                }
            } else {
                aVar = null;
            }
            if (aVar != null) {
                num = Integer.valueOf(aVar.l(android.support.e.a.TAG_ORIENTATION));
            }
            if (num != null && num.intValue() == 6) {
                AppMethodBeat.o(190642);
                return 90;
            } else if (num != null && num.intValue() == 3) {
                AppMethodBeat.o(190642);
                return TXLiveConstants.RENDER_ROTATION_180;
            } else if (num != null && num.intValue() == 8) {
                AppMethodBeat.o(190642);
                return 270;
            } else {
                AppMethodBeat.o(190642);
                return 0;
            }
        }

        public static ak aTY(String str) {
            int i2;
            int i3;
            AppMethodBeat.i(190643);
            p.h(str, "path");
            try {
                MultiMediaVideoChecker.a aTV = MultiMediaVideoChecker.GyY.aTV(str);
                if (aTV != null) {
                    int i4 = aTV.width;
                    int i5 = aTV.height;
                    long j2 = aTV.duration;
                    int i6 = aTV.dYT;
                    if (i6 == 90 || i6 == 270) {
                        i2 = i4;
                        i3 = i5;
                    } else {
                        i2 = i5;
                        i3 = i4;
                    }
                    ak akVar = new ak(i3, i2, str, j2);
                    AppMethodBeat.o(190643);
                    return akVar;
                }
            } catch (Exception e2) {
                com.tencent.mm.audio.mix.i.b.printErrStackTrace(z.TAG, e2, "createVideoSource error", new Object[0]);
            }
            AppMethodBeat.o(190643);
            return null;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H@¢\u0006\u0004\b\u0004\u0010\u0005"}, hxF = {"<anonymous>", "", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
        @f(c = "com.tencent.mm.plugin.vlog.model.SourceMaterial$Companion$asyncSourceToTrackList$2", f = "SourceMaterial.kt", hxM = {157}, m = "invokeSuspend")
        /* renamed from: com.tencent.mm.plugin.vlog.model.z$a$a  reason: collision with other inner class name */
        static final class C1851a extends j implements m<ai, d<? super List<? extends ad>>, Object> {
            final /* synthetic */ List Gzg;
            Object L$0;
            int label;
            private ai p$;
            Object pED;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1851a(List list, d dVar) {
                super(2, dVar);
                this.Gzg = list;
            }

            @Override // kotlin.d.b.a.a
            public final d<x> create(Object obj, d<?> dVar) {
                AppMethodBeat.i(190640);
                p.h(dVar, "completion");
                C1851a aVar = new C1851a(this.Gzg, dVar);
                aVar.p$ = (ai) obj;
                AppMethodBeat.o(190640);
                return aVar;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final Object invoke(ai aiVar, d<? super List<? extends ad>> dVar) {
                AppMethodBeat.i(190641);
                Object invokeSuspend = ((C1851a) create(aiVar, dVar)).invokeSuspend(x.SXb);
                AppMethodBeat.o(190641);
                return invokeSuspend;
            }

            /* access modifiers changed from: package-private */
            @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
            @f(c = "com.tencent.mm.plugin.vlog.model.SourceMaterial$Companion$asyncSourceToTrackList$2$requests$1$1", f = "SourceMaterial.kt", hxM = {156}, m = "invokeSuspend")
            /* renamed from: com.tencent.mm.plugin.vlog.model.z$a$a$a  reason: collision with other inner class name */
            public static final class C1852a extends j implements m<ai, d<? super ad>, Object> {
                final /* synthetic */ z Gzh;
                Object L$0;
                int label;
                private ai p$;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                C1852a(z zVar, d dVar) {
                    super(2, dVar);
                    this.Gzh = zVar;
                }

                @Override // kotlin.d.b.a.a
                public final d<x> create(Object obj, d<?> dVar) {
                    AppMethodBeat.i(190637);
                    p.h(dVar, "completion");
                    C1852a aVar = new C1852a(this.Gzh, dVar);
                    aVar.p$ = (ai) obj;
                    AppMethodBeat.o(190637);
                    return aVar;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // kotlin.g.a.m
                public final Object invoke(ai aiVar, d<? super ad> dVar) {
                    AppMethodBeat.i(190638);
                    Object invokeSuspend = ((C1852a) create(aiVar, dVar)).invokeSuspend(x.SXb);
                    AppMethodBeat.o(190638);
                    return invokeSuspend;
                }

                /* JADX DEBUG: Failed to insert an additional move for type inference into block B:7:0x003f */
                @Override // kotlin.d.b.a.a
                public final Object invokeSuspend(Object obj) {
                    AppMethodBeat.i(190636);
                    kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure(obj);
                            ai aiVar = this.p$;
                            a aVar2 = z.Gzf;
                            z zVar = this.Gzh;
                            this.L$0 = aiVar;
                            this.label = 1;
                            if (zVar instanceof ak) {
                                ad adVar = new ad(((ak) zVar).path, 2, zVar.Gze);
                                i.Rhj.c(adVar.GzA);
                                obj = adVar;
                            } else if (zVar instanceof r) {
                                ad adVar2 = new ad(((r) zVar).path, 1, zVar.Gze);
                                i.Rhj.c(adVar2.GzA);
                                obj = adVar2;
                            } else {
                                obj = null;
                            }
                            if (obj == aVar) {
                                AppMethodBeat.o(190636);
                                return aVar;
                            }
                            break;
                        case 1:
                            ResultKt.throwOnFailure(obj);
                            break;
                        default:
                            IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            AppMethodBeat.o(190636);
                            throw illegalStateException;
                    }
                    AppMethodBeat.o(190636);
                    return obj;
                }
            }

            @Override // kotlin.d.b.a.a
            public final Object invokeSuspend(Object obj) {
                Object obj2;
                long j2;
                long j3;
                long j4;
                AppMethodBeat.i(190639);
                kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        ai aiVar = this.p$;
                        List<z> list = this.Gzg;
                        ArrayList arrayList = new ArrayList(kotlin.a.j.a(list, 10));
                        for (z zVar : list) {
                            arrayList.add(kotlinx.coroutines.f.a(aiVar, (kotlin.d.f) null, new C1852a(zVar, null), 3));
                        }
                        ArrayList arrayList2 = arrayList;
                        this.L$0 = aiVar;
                        this.pED = arrayList2;
                        this.label = 1;
                        obj2 = kotlinx.coroutines.d.a(arrayList2, this);
                        if (obj2 == aVar) {
                            AppMethodBeat.o(190639);
                            return aVar;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure(obj);
                        obj2 = obj;
                        break;
                    default:
                        IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        AppMethodBeat.o(190639);
                        throw illegalStateException;
                }
                List l = kotlin.a.j.l((Iterable) obj2);
                int i2 = 0;
                for (Object obj3 : l) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        kotlin.a.j.hxH();
                    }
                    ad adVar = (ad) obj3;
                    r rVar = (z) this.Gzg.get(Integer.valueOf(i2).intValue());
                    switch (adVar.type) {
                        case 1:
                            if (rVar != null) {
                                rVar = (r) rVar;
                                j2 = 4000;
                                adVar.Gzz.type = 1;
                                j3 = 4000;
                                break;
                            } else {
                                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.model.ImageSource");
                                AppMethodBeat.o(190639);
                                throw tVar;
                            }
                        case 2:
                            if (rVar != null) {
                                rVar = (ak) rVar;
                                if (rVar.duration > Util.MILLSECONDS_OF_MINUTE) {
                                    j4 = Util.MILLSECONDS_OF_MINUTE;
                                } else {
                                    j4 = rVar.duration;
                                }
                                j3 = rVar.duration;
                                adVar.Gzz.type = 2;
                                j2 = j4;
                                break;
                            } else {
                                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.model.VideoSource");
                                AppMethodBeat.o(190639);
                                throw tVar2;
                            }
                        default:
                            j2 = 0;
                            com.tencent.mm.audio.mix.i.b.i(z.TAG, "unknown track type:" + adVar.type);
                            j3 = 0;
                            break;
                    }
                    adVar.KQ(0);
                    adVar.KR(j2);
                    adVar.Gzz.originDuration = j3;
                    adVar.Gzz.targetDuration = j3;
                    if (rVar.width > 1080 || rVar.height > 1280) {
                        float max = Math.max((((float) rVar.width) * 1.0f) / 1080.0f, (((float) rVar.height) * 1.0f) / 1280.0f);
                        adVar.Gzu = (int) (((float) rVar.width) / max);
                        adVar.Gzv = (int) (((float) rVar.height) / max);
                        adVar.Gzw = max;
                        i2 = i3;
                    } else {
                        adVar.Gzu = rVar.width;
                        adVar.Gzv = rVar.height;
                        i2 = i3;
                    }
                }
                d.a aVar2 = com.tencent.mm.videocomposition.d.Rhf;
                List<ad> list2 = l;
                ArrayList arrayList3 = new ArrayList(kotlin.a.j.a(list2, 10));
                for (ad adVar2 : list2) {
                    arrayList3.add(adVar2.GzA);
                }
                d.a.jZ(arrayList3);
                AppMethodBeat.o(190639);
                return l;
            }
        }
    }

    public /* synthetic */ z(int i2, int i3, int i4, byte b2) {
        this(i2, i3, i4);
    }

    static {
        AppMethodBeat.i(190644);
        AppMethodBeat.o(190644);
    }
}
