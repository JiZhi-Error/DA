package com.tencent.mm.plugin.music.model;

import android.os.Bundle;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.c.e;
import com.tencent.mm.plugin.ball.c.f;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.i.a.al;
import com.tencent.mm.plugin.music.model.d;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.PhoneStatusWatcher;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0007J\b\u0010\u0015\u001a\u00020\u0014H\u0007J\u001c\u0010\u0016\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0007J\b\u0010\u0019\u001a\u00020\u0014H\u0002J\b\u0010\u001a\u001a\u00020\u0014H\u0002J\b\u0010\u001b\u001a\u00020\u0014H\u0002J\b\u0010\u001c\u001a\u00020\u0014H\u0002J\u0012\u0010\u001d\u001a\u00020\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0007J\b\u0010 \u001a\u00020\u0014H\u0002J\u0012\u0010!\u001a\u00020\u00142\b\u0010\"\u001a\u0004\u0018\u00010\u0004H\u0007J\u001c\u0010#\u001a\u00020\u00142\b\u0010$\u001a\u0004\u0018\u00010\u001f2\b\u0010%\u001a\u0004\u0018\u00010&H\u0007J\u0010\u0010'\u001a\u00020\u00142\u0006\u0010(\u001a\u00020)H\u0007J\u0012\u0010*\u001a\u00020\u00142\b\u0010+\u001a\u0004\u0018\u00010,H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, hxF = {"Lcom/tencent/mm/plugin/music/model/GlobalMusicFloatBallManager;", "", "()V", "TAG", "", "floatBallInfoEventListener", "Lcom/tencent/mm/plugin/ball/api/OnFloatBallInfoEventListener;", "isMusicMvMode", "", "mCurrentMusicId", "mMusicActionListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MusicPlayerEvent;", "mPhoneCallListener", "Lcom/tencent/mm/sdk/platformtools/PhoneStatusWatcher$PhoneCallListener;", "mPhoneStatusWatcher", "Lcom/tencent/mm/sdk/platformtools/PhoneStatusWatcher;", "mVoipEventListener", "Lcom/tencent/mm/autogen/events/VoipEvent;", "create", "", "destroy", "notifyMusicCoverChanged", "musicId", "coverPath", "onMusicBallRemoved", "removeListener", "removeMusicBall", "resetMusicMvInfo", "resumeMusicFloatBallIfNeed", "wrapper", "Lcom/tencent/mm/modelmusic/MusicWrapper;", "setUpListener", "updateCurrentMusicCover", "coverUrl", "updateMusicInfo", "musicWrapper", "musicWrapperExtend", "Lcom/tencent/mm/modelmusic/MusicWrapperExtend;", "updateMusicMvInfo", "musicShareObject", "Lcom/tencent/mm/protocal/protobuf/MusicShareObject;", "updateMusicMvUIExtra", "extra", "Landroid/os/Bundle;", "plugin-music_release"})
public final class b {
    private static boolean AjV;
    private static String AjW = "";
    private static final IListener<mx> AjX = new C1538b();
    public static final b AjY = new b();
    private static PhoneStatusWatcher kYD;
    private static final PhoneStatusWatcher.PhoneCallListener kYE = c.Aka;
    private static final IListener<zj> kYG = new d();
    private static final e lqt = new a();

    static {
        AppMethodBeat.i(219952);
        AppMethodBeat.o(219952);
    }

    private b() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "state", "", "onPhoneCall"})
    static final class c implements PhoneStatusWatcher.PhoneCallListener {
        public static final c Aka = new c();

        static {
            AppMethodBeat.i(219941);
            AppMethodBeat.o(219941);
        }

        c() {
        }

        @Override // com.tencent.mm.sdk.platformtools.PhoneStatusWatcher.PhoneCallListener
        public final void onPhoneCall(int i2) {
            AppMethodBeat.i(219940);
            switch (i2) {
                case 0:
                    AppMethodBeat.o(219940);
                    return;
                case 1:
                case 2:
                    Log.i("MicroMsg.GlobalMusicFloatBallManager", "onPhoneCall, removeCurrentBall, state:%s", Integer.valueOf(i2));
                    h.RTc.aV(AnonymousClass1.UZd);
                    break;
            }
            AppMethodBeat.o(219940);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/music/model/GlobalMusicFloatBallManager$mVoipEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/VoipEvent;", "callback", "", "event", "plugin-music_release"})
    public static final class d extends IListener<zj> {
        d() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(zj zjVar) {
            AppMethodBeat.i(219942);
            zj zjVar2 = zjVar;
            if (zjVar2 != null) {
                Log.i("MicroMsg.GlobalMusicFloatBallManager", "receive VoipEvent:[%s, %s]", Integer.valueOf(zjVar2.efx.eft), Integer.valueOf(zjVar2.efx.dKy));
                if (zjVar2.efx.dKy == 7 || zjVar2.efx.dKy == 3) {
                    b bVar = b.AjY;
                    b.eur();
                }
            }
            AppMethodBeat.o(219942);
            return false;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/music/model/GlobalMusicFloatBallManager$floatBallInfoEventListener$1", "Lcom/tencent/mm/plugin/ball/api/OnFloatBallInfoEventListenerAdapter;", "onFloatBallInfoAdded", "", "ballInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "onFloatBallInfoClicked", "onFloatBallInfoExposed", "onFloatBallInfoRemoved", "plugin-music_release"})
    public static final class a extends f {
        a() {
        }

        @Override // com.tencent.mm.plugin.ball.c.f, com.tencent.mm.plugin.ball.c.e
        public final void b(BallInfo ballInfo) {
            AppMethodBeat.i(219935);
            if (ballInfo == null) {
                AppMethodBeat.o(219935);
            } else if (ballInfo.type == 6) {
                a eun = a.eun();
                if (eun != null) {
                    eun.Q(ballInfo);
                    AppMethodBeat.o(219935);
                    return;
                }
                AppMethodBeat.o(219935);
            } else {
                if (ballInfo.type == 23) {
                    d.a aVar = d.Aki;
                    d.b bVar = d.b.Akk;
                    d.b.euv().Q(ballInfo);
                }
                AppMethodBeat.o(219935);
            }
        }

        @Override // com.tencent.mm.plugin.ball.c.f, com.tencent.mm.plugin.ball.c.e
        public final void c(BallInfo ballInfo) {
            AppMethodBeat.i(219936);
            if (ballInfo == null) {
                AppMethodBeat.o(219936);
                return;
            }
            switch (ballInfo.type) {
                case 6:
                    a eun = a.eun();
                    if (eun != null) {
                        eun.C(ballInfo);
                    }
                    b bVar = b.AjY;
                    b.eus();
                    AppMethodBeat.o(219936);
                    return;
                case 23:
                    d.a aVar = d.Aki;
                    d.b bVar2 = d.b.Akk;
                    d.b.euv().C(ballInfo);
                    b bVar3 = b.AjY;
                    b.eus();
                    break;
            }
            AppMethodBeat.o(219936);
        }

        @Override // com.tencent.mm.plugin.ball.c.f, com.tencent.mm.plugin.ball.c.e
        public final void d(BallInfo ballInfo) {
            AppMethodBeat.i(219937);
            if (ballInfo == null) {
                AppMethodBeat.o(219937);
            } else if (ballInfo.type == 6) {
                a eun = a.eun();
                if (eun != null) {
                    eun.R(ballInfo);
                    AppMethodBeat.o(219937);
                    return;
                }
                AppMethodBeat.o(219937);
            } else {
                if (ballInfo.type == 23) {
                    d.a aVar = d.Aki;
                    d.b bVar = d.b.Akk;
                    d.b.euv().R(ballInfo);
                }
                AppMethodBeat.o(219937);
            }
        }

        @Override // com.tencent.mm.plugin.ball.c.f, com.tencent.mm.plugin.ball.c.e
        public final void g(BallInfo ballInfo) {
            AppMethodBeat.i(219938);
            if (ballInfo == null) {
                AppMethodBeat.o(219938);
                return;
            }
            d.a aVar = d.Aki;
            d.b bVar = d.b.Akk;
            if (p.j(ballInfo, d.b.euv().cix())) {
                Log.i("MicroMsg.GlobalMusicFloatBallManager", "onFloatBallInfoAdded remove normal music ball");
                a eun = a.eun();
                if (eun != null) {
                    eun.cir();
                }
            } else {
                a eun2 = a.eun();
                if (p.j(ballInfo, eun2 != null ? eun2.cix() : null)) {
                    Log.i("MicroMsg.GlobalMusicFloatBallManager", "onFloatBallInfoAdded remove music player ball");
                    d.a aVar2 = d.Aki;
                    d.b bVar2 = d.b.Akk;
                    d.b.euv().cir();
                } else if (18 == ballInfo.type || 17 == ballInfo.type || com.tencent.mm.plugin.ball.f.d.H(ballInfo)) {
                    Log.i("MicroMsg.GlobalMusicFloatBallManager", "onFloatBallInfoAdded pause music because of ball: %s", Integer.valueOf(ballInfo.type));
                    if (com.tencent.mm.ay.a.bef() != null && com.tencent.mm.ay.a.bec()) {
                        com.tencent.mm.ay.a.bdY();
                    }
                    MMHandlerThread.postToMainThread(RunnableC1537a.AjZ);
                }
            }
            if (ballInfo.type == 6) {
                a eun3 = a.eun();
                if (eun3 != null) {
                    eun3.B(ballInfo);
                    AppMethodBeat.o(219938);
                    return;
                }
                AppMethodBeat.o(219938);
                return;
            }
            if (ballInfo.type == 23) {
                d.a aVar3 = d.Aki;
                d.b bVar3 = d.b.Akk;
                d.b.euv().B(ballInfo);
            }
            AppMethodBeat.o(219938);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.music.model.b$a$a  reason: collision with other inner class name */
        static final class RunnableC1537a implements Runnable {
            public static final RunnableC1537a AjZ = new RunnableC1537a();

            static {
                AppMethodBeat.i(219934);
                AppMethodBeat.o(219934);
            }

            RunnableC1537a() {
            }

            public final void run() {
                AppMethodBeat.i(219933);
                b bVar = b.AjY;
                b.eur();
                AppMethodBeat.o(219933);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/music/model/GlobalMusicFloatBallManager$mMusicActionListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MusicPlayerEvent;", "callback", "", "event", "plugin-music_release"})
    /* renamed from: com.tencent.mm.plugin.music.model.b$b  reason: collision with other inner class name */
    public static final class C1538b extends IListener<mx> {
        C1538b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(mx mxVar) {
            AppMethodBeat.i(219939);
            mx mxVar2 = mxVar;
            p.h(mxVar2, "event");
            Log.v("MicroMsg.GlobalMusicFloatBallManager", "alvinluo dispatchMusicPlayerEvent action: %s", Integer.valueOf(mxVar2.dSE.action));
            switch (mxVar2.dSE.action) {
                case 2:
                case 3:
                case 7:
                    b.as(null);
                    break;
            }
            a eun = a.eun();
            if (eun != null) {
                eun.a(mxVar2);
            }
            d.a aVar = d.Aki;
            d.b bVar = d.b.Akk;
            d.b.euv().a(mxVar2);
            AppMethodBeat.o(219939);
            return false;
        }
    }

    public static final void x(com.tencent.mm.ay.f fVar) {
        AppMethodBeat.i(219945);
        Object[] objArr = new Object[2];
        objArr[0] = fVar != null ? Boolean.valueOf(fVar.jfx) : null;
        objArr[1] = Boolean.valueOf(AjV);
        Log.i("MicroMsg.GlobalMusicFloatBallManager", "alvinluo resumeMusicFloatBallIfNeed isFromNewMusicPlayer: %s, isMusicMvMode: %s", objArr);
        if ((fVar == null || !fVar.jfx) && !AjV) {
            a eun = a.eun();
            if (eun != null) {
                eun.x(fVar);
                AppMethodBeat.o(219945);
                return;
            }
            AppMethodBeat.o(219945);
            return;
        }
        if (fVar != null) {
            fVar.jfx = true;
        }
        d.a aVar = d.Aki;
        d.b bVar = d.b.Akk;
        d.b.euv().x(fVar);
        AppMethodBeat.o(219945);
    }

    public static final void b(com.tencent.mm.ay.f fVar, com.tencent.mm.ay.h hVar) {
        String str;
        Boolean bool;
        String str2;
        String str3;
        css css;
        boolean z = false;
        css css2 = null;
        AppMethodBeat.i(219946);
        if (hVar == null || (str = hVar.dSF) == null) {
            str = "";
        }
        AjW = str;
        boolean z2 = (fVar != null && fVar.jfx) || (hVar != null && !al.b(hVar.jfy));
        Object[] objArr = new Object[3];
        objArr[0] = AjW;
        if (fVar != null) {
            bool = Boolean.valueOf(fVar.jfx);
        } else {
            bool = null;
        }
        objArr[1] = bool;
        objArr[2] = Boolean.valueOf(z2);
        Log.i("MicroMsg.GlobalMusicFloatBallManager", "alvinluo updateMusicInfo musicId: %s, isFromNewMusicPlayer: %s, isValid: %s", objArr);
        if (z2) {
            AjV = true;
            if (hVar != null) {
                str2 = hVar.jfz;
            } else {
                str2 = null;
            }
            String str4 = str2;
            if (str4 == null || str4.length() == 0) {
                z = true;
            }
            if (!z) {
                str3 = hVar != null ? hVar.jfz : null;
            } else {
                str3 = (hVar == null || (css = hVar.jfy) == null) ? null : css.jfz;
            }
            d.a aVar = d.Aki;
            d.b bVar = d.b.Akk;
            d.b.euv().aHN(str3);
            d.a aVar2 = d.Aki;
            d.b bVar2 = d.b.Akk;
            d euv = d.b.euv();
            if (hVar != null) {
                css2 = hVar.jfy;
            }
            euv.d(css2);
            AppMethodBeat.o(219946);
            return;
        }
        AjV = false;
        d.a aVar3 = d.Aki;
        d.b bVar3 = d.b.Akk;
        d.b.euv().aHN(null);
        d.a aVar4 = d.Aki;
        d.b bVar4 = d.b.Akk;
        d.b.euv().d(null);
        AppMethodBeat.o(219946);
    }

    public static final void c(css css) {
        AppMethodBeat.i(219947);
        p.h(css, "musicShareObject");
        Log.i("MicroMsg.GlobalMusicFloatBallManager", "alvinluo updateMusicMvInfo objectId: %s, nonceId: %s", css.Ktn, css.Kto);
        if (AjV) {
            d.a aVar = d.Aki;
            d.b bVar = d.b.Akk;
            d euv = d.b.euv();
            css css2 = euv.Akg;
            if (css2 != null) {
                css2.Ktn = css.Ktn;
                css2.Kto = css.Kto;
                css2.Ktp = css.Ktp;
                css2.Ktq = css.Ktq;
            }
            Bundle bundle = euv.Ake;
            if (bundle != null) {
                String str = css.Ktn;
                if (str == null) {
                    str = "";
                }
                bundle.putString("key_mv_feed_id", str);
                String str2 = css.Kto;
                if (str2 == null) {
                    str2 = "";
                }
                bundle.putString("key_mv_nonce_id", str2);
                String str3 = css.Ktp;
                if (str3 == null) {
                    str3 = "";
                }
                bundle.putString("key_mv_cover_url", str3);
                String str4 = css.Ktq;
                if (str4 == null) {
                    str4 = "";
                }
                bundle.putString("key_mv_poster", str4);
                AppMethodBeat.o(219947);
                return;
            }
        }
        AppMethodBeat.o(219947);
    }

    public static final void as(Bundle bundle) {
        AppMethodBeat.i(219948);
        if (bundle != null) {
            AjV = true;
        }
        d.a aVar = d.Aki;
        d.b bVar = d.b.Akk;
        d.b.euv().as(bundle);
        AppMethodBeat.o(219948);
    }

    public static final void iX(String str, String str2) {
        AppMethodBeat.i(219949);
        if (!p.j(str, AjW)) {
            Log.w("MicroMsg.GlobalMusicFloatBallManager", "alvinluo notifyMusicCoverChanged musicId not the same and ignore musicId: %s, current: %s", str, AjW);
            AppMethodBeat.o(219949);
            return;
        }
        d.a aVar = d.Aki;
        d.b bVar = d.b.Akk;
        d.b.euv().aHN(str2);
        AppMethodBeat.o(219949);
    }

    public static final void aHM(String str) {
        AppMethodBeat.i(219950);
        Log.i("MicroMsg.GlobalMusicFloatBallManager", "alvinluo updateCurrentMusicCover %s", str);
        d.a aVar = d.Aki;
        d.b bVar = d.b.Akk;
        d.b.euv().aHN(str);
        AppMethodBeat.o(219950);
    }

    private static void euq() {
        AppMethodBeat.i(219951);
        Log.i("MicroMsg.GlobalMusicFloatBallManager", "alvinluo resetMusicMvInfo");
        AjV = false;
        d.a aVar = d.Aki;
        d.b bVar = d.b.Akk;
        d.b.euv().d(null);
        d.a aVar2 = d.Aki;
        d.b bVar2 = d.b.Akk;
        d.b.euv().as(null);
        AppMethodBeat.o(219951);
    }

    public static final void create() {
        AppMethodBeat.i(219943);
        ((com.tencent.mm.plugin.ball.c.b) g.af(com.tencent.mm.plugin.ball.c.b.class)).a(6, lqt);
        ((com.tencent.mm.plugin.ball.c.b) g.af(com.tencent.mm.plugin.ball.c.b.class)).a(23, lqt);
        AjX.alive();
        PhoneStatusWatcher phoneStatusWatcher = new PhoneStatusWatcher();
        kYD = phoneStatusWatcher;
        phoneStatusWatcher.begin(MMApplicationContext.getContext());
        PhoneStatusWatcher phoneStatusWatcher2 = kYD;
        if (phoneStatusWatcher2 == null) {
            p.hyc();
        }
        phoneStatusWatcher2.addPhoneCallListener(kYE);
        kYG.alive();
        a.eun();
        d.a aVar = d.Aki;
        d.b bVar = d.b.Akk;
        d.b.euv();
        AppMethodBeat.o(219943);
    }

    public static final void destroy() {
        AppMethodBeat.i(219944);
        ((com.tencent.mm.plugin.ball.c.b) g.af(com.tencent.mm.plugin.ball.c.b.class)).b(6, lqt);
        ((com.tencent.mm.plugin.ball.c.b) g.af(com.tencent.mm.plugin.ball.c.b.class)).b(23, lqt);
        AjX.dead();
        PhoneStatusWatcher phoneStatusWatcher = kYD;
        if (phoneStatusWatcher == null) {
            p.hyc();
        }
        phoneStatusWatcher.removePhoneCallListener(kYE);
        PhoneStatusWatcher phoneStatusWatcher2 = kYD;
        if (phoneStatusWatcher2 == null) {
            p.hyc();
        }
        phoneStatusWatcher2.end();
        kYG.dead();
        a.eun();
        d.a aVar = d.Aki;
        d.b bVar = d.b.Akk;
        d.b.euv();
        AppMethodBeat.o(219944);
    }

    public static final /* synthetic */ void eur() {
        AppMethodBeat.i(219953);
        a.eun().cir();
        d.a aVar = d.Aki;
        d.b bVar = d.b.Akk;
        d.b.euv().cir();
        euq();
        AppMethodBeat.o(219953);
    }

    public static final /* synthetic */ void eus() {
        AppMethodBeat.i(219954);
        euq();
        AppMethodBeat.o(219954);
    }
}
