package com.tencent.mm.plugin.finder.megavideo.bullet;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.danmaku.a.g;
import com.tencent.mm.danmaku.c.a;
import com.tencent.mm.danmaku.c.h;
import com.tencent.mm.danmaku.c.l;
import com.tencent.mm.danmaku.c.m;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.plugin.finder.cgi.cs;
import com.tencent.mm.plugin.finder.megavideo.loader.a;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.report.af;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.protocal.protobuf.cni;
import com.tencent.mm.protocal.protobuf.cnj;
import com.tencent.mm.protocal.protobuf.cnl;
import com.tencent.mm.protocal.protobuf.cns;
import com.tencent.mm.protocal.protobuf.cod;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000o\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f*\u0001\b\u0018\u0000 F2\u00020\u0001:\u0001FB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010)\u001a\u00020*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,H\u0002J\u0010\u0010.\u001a\u00020*2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u000e\u0010/\u001a\u00020*2\u0006\u00100\u001a\u00020$J\u000e\u00101\u001a\u00020*2\u0006\u00102\u001a\u00020\u001fJ\u0006\u00103\u001a\u00020*J*\u00104\u001a\u00020*2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u0002062\b\u00108\u001a\u0004\u0018\u0001092\u0006\u0010:\u001a\u00020;H\u0016J\u0006\u0010<\u001a\u00020*J\u000e\u0010=\u001a\u00020*2\u0006\u0010>\u001a\u000209J\u0010\u0010?\u001a\u00020*2\b\b\u0002\u0010@\u001a\u00020\rJ\u0006\u0010A\u001a\u00020*J\u000e\u0010B\u001a\u00020*2\u0006\u0010@\u001a\u000206J\u000e\u0010C\u001a\u00020*2\u0006\u0010D\u001a\u00020\rJ\u0006\u0010E\u001a\u00020*R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006G"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/bullet/MegaVideoBulletManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "bulletView", "Landroid/view/View;", "(Landroid/view/View;)V", "bulletLoader", "Lcom/tencent/mm/plugin/finder/megavideo/loader/MegaVideoBulletLoader;", "bulletLoaderListener", "com/tencent/mm/plugin/finder/megavideo/bullet/MegaVideoBulletManager$bulletLoaderListener$1", "Lcom/tencent/mm/plugin/finder/megavideo/bullet/MegaVideoBulletManager$bulletLoaderListener$1;", "getBulletView", "()Landroid/view/View;", "currentTime", "", "getCurrentTime", "()J", "setCurrentTime", "(J)V", "danmakuClickListener", "Lcom/tencent/mm/danmaku/core/DanmakuManager$IDanmakuListener;", "getDanmakuClickListener", "()Lcom/tencent/mm/danmaku/core/DanmakuManager$IDanmakuListener;", "setDanmakuClickListener", "(Lcom/tencent/mm/danmaku/core/DanmakuManager$IDanmakuListener;)V", "danmakuManager", "Lcom/tencent/mm/danmaku/core/DanmakuManager;", "getDanmakuManager", "()Lcom/tencent/mm/danmaku/core/DanmakuManager;", "setDanmakuManager", "(Lcom/tencent/mm/danmaku/core/DanmakuManager;)V", "isAttached", "", "()Z", "setAttached", "(Z)V", "megaVideoFeed", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "getMegaVideoFeed", "()Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "setMegaVideoFeed", "(Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;)V", "addDanmaku", "", "list", "", "Lcom/tencent/mm/protocal/protobuf/MegaVideoBulletCommentInfo;", "initDanmaku", "onAttach", "feed", "onConfigurationChange", "isLandscape", "onDetach", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "pause", "postBullet", "content", "restart", "timeStamp", "resume", "seek", "setProgress", "times", "stop", "Companion", "plugin-finder_release"})
public final class a implements i {
    public static final C1212a uJT = new C1212a((byte) 0);
    long iGC;
    boolean iuM;
    public bm uJO;
    public g uJP;
    com.tencent.mm.plugin.finder.megavideo.loader.a uJQ;
    private final c uJR = new c(this);
    private final View uJS;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/bullet/MegaVideoBulletManager$Companion;", "", "()V", "DURATION_THRESHOLD", "", "LANDSCAPE_BULLET_DURATION", "", "PORTRAIT_BULLET_DURATION", "TAG", "", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.megavideo.bullet.a$a  reason: collision with other inner class name */
    public static final class C1212a {
        private C1212a() {
        }

        public /* synthetic */ C1212a(byte b2) {
            this();
        }
    }

    public a(View view) {
        p.h(view, "bulletView");
        AppMethodBeat.i(248257);
        this.uJS = view;
        View view2 = this.uJS;
        m asO = com.tencent.mm.danmaku.c.a.asO();
        p.g(asO, "config");
        asO.asZ();
        asO.atb();
        asO.ata();
        asO.pa(0);
        asO.an(0.0f);
        asO.am(4.0f);
        a.C0311a asR = com.tencent.mm.danmaku.c.a.asR();
        asR.a(new d(this));
        asR.a(e.uJV);
        Context context = view2.getContext();
        p.g(context, "bulletView.context");
        asR.a(new d(context));
        this.uJP = new g(view2, asR.asS());
        AppMethodBeat.o(248257);
    }

    public static final /* synthetic */ void a(a aVar, List list) {
        AppMethodBeat.i(248259);
        aVar.eg(list);
        AppMethodBeat.o(248259);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J&\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\r"}, hxF = {"com/tencent/mm/plugin/finder/megavideo/bullet/MegaVideoBulletManager$Companion$1", "Lcom/tencent/mm/danmaku/inject/VideoDanmakuConfig$ILogger;", "d", "", "tag", "", "message", "e", "t", "", "i", "v", "w", "plugin-finder_release"})
    public static final class b implements l.a {
        b() {
        }

        @Override // com.tencent.mm.danmaku.c.l.a
        public final void i(String str, String str2) {
            AppMethodBeat.i(248246);
            Log.i(str, str2);
            AppMethodBeat.o(248246);
        }

        @Override // com.tencent.mm.danmaku.c.l.a
        public final void w(String str, String str2) {
            AppMethodBeat.i(248247);
            Log.w(str, str2);
            AppMethodBeat.o(248247);
        }

        @Override // com.tencent.mm.danmaku.c.l.a
        public final void v(String str, String str2) {
            AppMethodBeat.i(248248);
            Log.v(str, str2);
            AppMethodBeat.o(248248);
        }

        @Override // com.tencent.mm.danmaku.c.l.a
        public final void e(String str, String str2) {
            AppMethodBeat.i(248249);
            Log.e(str, str2);
            AppMethodBeat.o(248249);
        }

        @Override // com.tencent.mm.danmaku.c.l.a
        public final void e(String str, String str2, Throwable th) {
            AppMethodBeat.i(248250);
            Log.e(str, str2, th);
            AppMethodBeat.o(248250);
        }

        @Override // com.tencent.mm.danmaku.c.l.a
        public final void d(String str, String str2) {
            AppMethodBeat.i(248251);
            Log.d(str, str2);
            AppMethodBeat.o(248251);
        }
    }

    static {
        AppMethodBeat.i(248258);
        com.tencent.mm.danmaku.e.e.a(new b());
        AppMethodBeat.o(248258);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/finder/megavideo/bullet/MegaVideoBulletManager$bulletLoaderListener$1", "Lcom/tencent/mm/plugin/finder/megavideo/loader/MegaVideoBulletLoader$BulletLoadListener;", "onBulletIncrease", "", "increaseList", "", "Lcom/tencent/mm/protocal/protobuf/MegaVideoBulletCommentInfo;", "plugin-finder_release"})
    public static final class c implements a.AbstractC1219a {
        final /* synthetic */ a uJU;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(a aVar) {
            this.uJU = aVar;
        }

        @Override // com.tencent.mm.plugin.finder.megavideo.loader.a.AbstractC1219a
        public final void eh(List<? extends cni> list) {
            AppMethodBeat.i(248252);
            p.h(list, "increaseList");
            a aVar = this.uJU;
            bm bmVar = this.uJU.uJO;
            if (bmVar == null) {
                p.btv("megaVideoFeed");
            }
            a.a(aVar, bmVar.ej(list));
            AppMethodBeat.o(248252);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "getPlayTime"})
    static final class d implements h {
        final /* synthetic */ a uJU;

        d(a aVar) {
            this.uJU = aVar;
        }

        @Override // com.tencent.mm.danmaku.c.h
        public final long asQ() {
            return this.uJU.iGC;
        }
    }

    /* access modifiers changed from: package-private */
    public final void eg(List<? extends cni> list) {
        AppMethodBeat.i(248255);
        g gVar = this.uJP;
        if (gVar == null) {
            p.btv("danmakuManager");
        }
        List<? extends cni> list2 = list;
        ArrayList arrayList = new ArrayList(j.a(list2, 10));
        for (T t : list2) {
            g gVar2 = this.uJP;
            if (gVar2 == null) {
                p.btv("danmakuManager");
            }
            com.tencent.mm.danmaku.b.a aW = gVar2.aW(t);
            p.g(aW, "danmaku");
            aW.asE();
            aW.setTime(t.MtO);
            arrayList.add(aW);
        }
        gVar.ab(arrayList);
        AppMethodBeat.o(248255);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        long j2;
        int i4;
        String str2;
        cnl cnl;
        LinkedList<cod> linkedList;
        cod cod;
        cns cns;
        long j3 = 0;
        int i5 = 1;
        int i6 = 0;
        AppMethodBeat.i(248256);
        p.h(qVar, "scene");
        if (qVar instanceof cs) {
            long j4 = ((cs) qVar).twG;
            bm bmVar = this.uJO;
            if (bmVar == null) {
                p.btv("megaVideoFeed");
            }
            if (j4 != bmVar.lT()) {
                AppMethodBeat.o(248256);
                return;
            }
            com.tencent.mm.bw.a aYK = ((cs) qVar).rr.aYK();
            if (aYK == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MegaVideoBulletCommentResponse");
                AppMethodBeat.o(248256);
                throw tVar;
            }
            cni cni = ((cnj) aYK).MtP;
            if (i2 == 0 && i3 == 0) {
                if (cni != null) {
                    bm bmVar2 = this.uJO;
                    if (bmVar2 == null) {
                        p.btv("megaVideoFeed");
                    }
                    bmVar2.ej(j.listOf(cni));
                }
                g gVar = this.uJP;
                if (gVar == null) {
                    p.btv("danmakuManager");
                }
                com.tencent.mm.danmaku.b.a aW = gVar.aW(cni);
                p.g(aW, "danmaku");
                aW.asE();
                g gVar2 = this.uJP;
                if (gVar2 == null) {
                    p.btv("danmakuManager");
                }
                gVar2.d(aW);
                StringBuilder sb = new StringBuilder("postBullet onSceneEnd: addDanmaku ");
                bm bmVar3 = this.uJO;
                if (bmVar3 == null) {
                    p.btv("megaVideoFeed");
                }
                Log.i("MegaVideoBulletManager", sb.append(bmVar3.lT()).toString());
                bm bmVar4 = this.uJO;
                if (bmVar4 == null) {
                    p.btv("megaVideoFeed");
                }
                cng cng = bmVar4.tuP;
                int i7 = cng != null ? cng.MtK : 0;
                bm bmVar5 = this.uJO;
                if (bmVar5 == null) {
                    p.btv("megaVideoFeed");
                }
                cng cng2 = bmVar5.tuP;
                if (cng2 != null) {
                    cng2.MtK = i7 + 1;
                }
                hn hnVar = new hn();
                hnVar.dLW.id = ((cs) qVar).twG;
                hnVar.dLW.dMb = 1;
                hnVar.dLW.dLK = 1;
                hnVar.dLW.type = 10;
                EventCenter.instance.publish(hnVar);
            } else if (i3 == -8000) {
                y yVar = y.vXH;
                Context context = this.uJS.getContext();
                p.g(context, "bulletView.context");
                String string = this.uJS.getContext().getString(R.string.ezc);
                p.g(string, "bulletView.context.getSt…_bullet_has_closed_toast)");
                y.aF(context, string);
                i5 = 2;
            } else {
                Log.e("MegaVideoBulletManager", "NetSceneMegaVideoBulletPost: errType=" + i2 + ", errCode=" + i3 + ", errMsg=" + str);
                i5 = 2;
            }
            af afVar = af.viA;
            bm bmVar6 = this.uJO;
            if (bmVar6 == null) {
                p.btv("megaVideoFeed");
            }
            cng cng3 = bmVar6.tuP;
            if (cng3 == null || (cns = cng3.MtI) == null) {
                j2 = 0;
            } else {
                j2 = cns.hFK;
            }
            String zs = com.tencent.mm.ac.d.zs(j2);
            bm bmVar7 = this.uJO;
            if (bmVar7 == null) {
                p.btv("megaVideoFeed");
            }
            String zs2 = com.tencent.mm.ac.d.zs(bmVar7.lT());
            bm bmVar8 = this.uJO;
            if (bmVar8 == null) {
                p.btv("megaVideoFeed");
            }
            cng cng4 = bmVar8.tuP;
            if (cng4 == null || (cnl = cng4.MtG) == null || (linkedList = cnl.media) == null || (cod = (cod) j.kt(linkedList)) == null) {
                i4 = 0;
            } else {
                i4 = cod.Mur;
            }
            if (!(cni == null || (str2 = cni.content) == null)) {
                i6 = str2.length();
            }
            if (cni != null) {
                j3 = cni.MtO;
            }
            af.a(zs, zs2, i4, i6, j3, i5);
        }
        AppMethodBeat.o(248256);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/megavideo/bullet/TextDanmaku;", "danmakuContext", "Lcom/tencent/mm/danmaku/inject/DanmakuContext;", "kotlin.jvm.PlatformType", "danmakuType", "", "createDanmaku"})
    static final class e implements com.tencent.mm.danmaku.c.d {
        public static final e uJV = new e();

        static {
            AppMethodBeat.i(248254);
            AppMethodBeat.o(248254);
        }

        e() {
        }

        @Override // com.tencent.mm.danmaku.c.d
        public final /* synthetic */ com.tencent.mm.danmaku.b.a a(com.tencent.mm.danmaku.c.a aVar) {
            AppMethodBeat.i(248253);
            p.g(aVar, "danmakuContext");
            c cVar = new c(aVar);
            AppMethodBeat.o(248253);
            return cVar;
        }
    }
}
