package com.tencent.mm.plugin.music.model;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ay.f;
import com.tencent.mm.g.b.a.ol;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.i.a.aq;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.music.ui.FloatBallMusicView;
import com.tencent.mm.protocal.protobuf.cso;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.at;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 02\u00020\u0001:\u0003012B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\u001c\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010\u0019\u001a\u00020\u001aH\u0014J\u0006\u0010\u001b\u001a\u00020\u001cJ\b\u0010\u001d\u001a\u00020\u0011H\u0002J\b\u0010\u001e\u001a\u00020\u0011H\u0002J\b\u0010\u001f\u001a\u00020\u0011H\u0002J\u0012\u0010 \u001a\u00020\u00112\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010#\u001a\u00020\u00112\b\u0010$\u001a\u0004\u0018\u00010\u000fJ\b\u0010%\u001a\u00020\u0011H\u0016J\b\u0010&\u001a\u00020\u0011H\u0014J\u0010\u0010'\u001a\u00020\u00112\b\u0010$\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010(\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0013H\u0014J\u0010\u0010)\u001a\u00020\u00112\b\u0010*\u001a\u0004\u0018\u00010\u0004J\u0010\u0010+\u001a\u00020\u00112\b\u0010,\u001a\u0004\u0018\u00010\u0006J\u0010\u0010-\u001a\u00020\u00112\b\u0010.\u001a\u0004\u0018\u00010\fJ\u0010\u0010/\u001a\u00020\u00112\b\u0010,\u001a\u0004\u0018\u00010\u0006R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000¨\u00063"}, hxF = {"Lcom/tencent/mm/plugin/music/model/GlobalMusicPlayerFloatBallHelper;", "Lcom/tencent/mm/plugin/music/model/GlobalMusicFloatBallHelper;", "()V", "mCoverPath", "", "mCurrentMusicShareObject", "Lcom/tencent/mm/protocal/protobuf/MusicShareObject;", "mFloatBallMusicView", "Lcom/tencent/mm/plugin/music/ui/FloatBallMusicView;", "mMultiTaskHelper", "Lcom/tencent/mm/plugin/music/model/MusicPlayerMultiTaskHelper;", "mMvUIExtra", "Landroid/os/Bundle;", "musicDataChangedListeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/tencent/mm/plugin/music/model/GlobalMusicPlayerFloatBallHelper$MusicPlayerDataChangedEventListener;", "addMusicFloatBall", "", "musicWrapper", "Lcom/tencent/mm/modelmusic/MusicWrapper;", "canHandleMusicPlayerEvent", "", "event", "Lcom/tencent/mm/autogen/events/MusicPlayerEvent;", "wrapper", "getFloatBallType", "", "getMusicMvUIIntent", "Landroid/content/Intent;", "initMusicFloatBallView", "notifyMusicDataChanged", "onClickMusicBall", "onFloatBallRemoved", "ballInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "registerMusicDataChangedEventListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "removeCurrentBall", "removeMusicBallState", "unRegisterMusicDataChangedEventListener", "updateMusicBallState", "updateMusicCoverPath", "coverPath", "updateMusicMvInfo", "musicShareObject", "updateMusicMvUIExtra", "extra", "updateMusicShareObject", "Companion", "Holder", "MusicPlayerDataChangedEventListener", "plugin-music_release"})
public final class d extends a {
    public static final a Aki = new a((byte) 0);
    private FloatBallMusicView Akd;
    Bundle Ake;
    private String Akf;
    css Akg;
    private final k Akh = new k();
    public final CopyOnWriteArraySet<e> UZe = new CopyOnWriteArraySet<>();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/music/model/GlobalMusicPlayerFloatBallHelper$MusicPlayerDataChangedEventListener;", "", "onMusicDataChanged", "", "extra", "Landroid/os/Bundle;", "plugin-music_release"})
    public interface e {
        void bx(Bundle bundle);
    }

    static {
        AppMethodBeat.i(219968);
        AppMethodBeat.o(219968);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/music/model/GlobalMusicPlayerFloatBallHelper$Companion;", "", "()V", "TAG", "", "get", "Lcom/tencent/mm/plugin/music/model/GlobalMusicPlayerFloatBallHelper;", "plugin-music_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public d() {
        super("MicroMsg.GlobalMusicPlayerFloatBallHelper");
        AppMethodBeat.i(219967);
        AppMethodBeat.o(219967);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/music/model/GlobalMusicPlayerFloatBallHelper$Holder;", "", "()V", "sHelper", "Lcom/tencent/mm/plugin/music/model/GlobalMusicPlayerFloatBallHelper;", "getSHelper", "()Lcom/tencent/mm/plugin/music/model/GlobalMusicPlayerFloatBallHelper;", "setSHelper", "(Lcom/tencent/mm/plugin/music/model/GlobalMusicPlayerFloatBallHelper;)V", "plugin-music_release"})
    public static final class b {
        private static d Akj = new d();
        public static final b Akk = new b();

        static {
            AppMethodBeat.i(219955);
            AppMethodBeat.o(219955);
        }

        private b() {
        }

        public static d euv() {
            return Akj;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.music.model.a
    public final int euo() {
        return 23;
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper
    public final void cir() {
        AppMethodBeat.i(219958);
        super.cir();
        FloatBallMusicView floatBallMusicView = this.Akd;
        if (floatBallMusicView != null) {
            ((com.tencent.mm.plugin.ball.c.b) g.af(com.tencent.mm.plugin.ball.c.b.class)).b(floatBallMusicView.AmF);
        }
        this.Akd = null;
        AppMethodBeat.o(219958);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.music.model.a
    public final void A(f fVar) {
        AppMethodBeat.i(219959);
        p.h(fVar, "wrapper");
        if (fVar.jfx) {
            this.oWE.state = com.tencent.mm.plugin.ball.f.d.eV(this.oWE.state, 8);
            BH(this.oWE.state);
        }
        AppMethodBeat.o(219959);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.music.model.a
    public final void eup() {
        AppMethodBeat.i(219960);
        BH(com.tencent.mm.plugin.ball.f.d.eW(this.oWE.state, 8));
        AppMethodBeat.o(219960);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.music.model.a
    public final void z(f fVar) {
        AppMethodBeat.i(219961);
        if (fVar != null) {
            Log.i("MicroMsg.GlobalMusicPlayerFloatBallHelper", "addMusicFloatBall isFromNewMusicPlayer: %s", Boolean.valueOf(fVar.jfx));
            if (fVar.jfx) {
                Context context = MMApplicationContext.getContext();
                p.g(context, "MMApplicationContext.getContext()");
                this.Akd = new FloatBallMusicView(context);
                FloatBallMusicView floatBallMusicView = this.Akd;
                if (floatBallMusicView != null) {
                    floatBallMusicView.setOnCloseListener(new c(this));
                }
                FloatBallMusicView floatBallMusicView2 = this.Akd;
                if (floatBallMusicView2 != null) {
                    floatBallMusicView2.setOnMusicIconClickListener(new View$OnClickListenerC1539d(this));
                }
                FloatBallMusicView floatBallMusicView3 = this.Akd;
                if (floatBallMusicView3 != null) {
                    floatBallMusicView3.setCoverPath(this.Akf);
                }
                this.oWE.vk = this.Akd;
                if (this.oWE.oWm == null) {
                    this.oWE.oWm = new Point();
                }
                if (this.oWE.oWn == null) {
                    this.oWE.oWn = new Point();
                }
                this.oWE.oWm.x = at.aH(MMApplicationContext.getContext(), R.dimen.a6_);
                this.oWE.oWm.y = at.aH(MMApplicationContext.getContext(), R.dimen.a67);
                this.oWE.oWn.x = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 20);
                this.oWE.oWn.y = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 20);
                this.oWE.nno = false;
                this.oWE.oWr = true;
                this.oWE.oWq = true;
                this.oWE.gqx = false;
                this.oWE.state = com.tencent.mm.plugin.ball.f.d.eW(this.oWE.state, 2);
                this.oWE.state = com.tencent.mm.plugin.ball.f.d.eV(this.oWE.state, 8);
                Log.v("MicroMsg.GlobalMusicPlayerFloatBallHelper", "initMusicFloatBallViewSize %s, ballInfo.state: %d", this.oWE.oWm, Integer.valueOf(this.oWE.state));
                cis();
            }
        }
        AppMethodBeat.o(219961);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.music.model.a
    public final boolean y(f fVar) {
        if (fVar == null || !fVar.jfx) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mm.plugin.music.model.a
    public final void C(BallInfo ballInfo) {
        css css;
        boolean z;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        int i2;
        String str14 = null;
        AppMethodBeat.i(219962);
        com.tencent.mm.plugin.music.f.c.a aS = com.tencent.mm.plugin.music.f.c.b.aS(com.tencent.mm.plugin.music.e.e.class);
        p.g(aS, "MusicCoreService.service…PrivateLogic::class.java)");
        com.tencent.mm.plugin.music.model.e.a etY = ((com.tencent.mm.plugin.music.e.e) aS).etY();
        if (etY != null) {
            this.Akh.G(6, com.tencent.mm.plugin.multitask.g.az(etY.field_songName, etY.field_songSinger, etY.field_songAlbum));
            k kVar = this.Akh;
            css css2 = this.Akg;
            Bundle bundle = this.Ake;
            p.h(etY, "music");
            if (css2 == null && bundle == null) {
                Log.w("MicroMsg.MusicPlayerMultiTaskHelper", "fillMultiTaskData failed");
                kVar.Abp = null;
            } else {
                if (css2 == null) {
                    css css3 = new css();
                    css3.Ktp = bundle != null ? bundle.getString("key_mv_cover_url", null) : null;
                    if (bundle != null) {
                        str2 = bundle.getString("key_mv_poster", null);
                    } else {
                        str2 = null;
                    }
                    css3.Ktq = str2;
                    if (bundle != null) {
                        str3 = bundle.getString("key_mv_nonce_id", null);
                    } else {
                        str3 = null;
                    }
                    css3.Kto = str3;
                    if (bundle != null) {
                        str4 = bundle.getString("key_mv_feed_id", null);
                    } else {
                        str4 = null;
                    }
                    css3.Ktn = str4;
                    if (bundle != null) {
                        str5 = bundle.getString("key_mv_song_name", null);
                    } else {
                        str5 = null;
                    }
                    css3.BPc = str5;
                    if (bundle != null) {
                        str6 = bundle.getString("key_mv_song_lyric", "");
                    } else {
                        str6 = null;
                    }
                    css3.songLyric = str6;
                    if (bundle != null) {
                        str7 = bundle.getString("key_mv_singer_name", null);
                    } else {
                        str7 = null;
                    }
                    css3.singerName = str7;
                    if (bundle != null) {
                        str8 = bundle.getString("key_mv_album_name", null);
                    } else {
                        str8 = null;
                    }
                    css3.albumName = str8;
                    if (bundle != null) {
                        str9 = bundle.getString("key_mv_music_genre", null);
                    } else {
                        str9 = null;
                    }
                    css3.musicGenre = str9;
                    if (bundle != null) {
                        str10 = bundle.getString("key_mv_issue_date", "");
                    } else {
                        str10 = null;
                    }
                    css3.issueDate = Util.safeParseLong(str10);
                    if (bundle != null) {
                        str11 = bundle.getString("key_mv_album_cover_url", null);
                    } else {
                        str11 = null;
                    }
                    css3.EsK = str11;
                    if (bundle != null) {
                        str12 = bundle.getString("key_mv_identification", null);
                    } else {
                        str12 = null;
                    }
                    css3.identification = str12;
                    if (bundle != null) {
                        str13 = bundle.getString("key_mv_extra_info", null);
                    } else {
                        str13 = null;
                    }
                    css3.extraInfo = str13;
                    if (bundle != null) {
                        i2 = bundle.getInt("key_mv_music_duration", 0);
                    } else {
                        i2 = 0;
                    }
                    css3.Alz = i2;
                    if (bundle != null) {
                        str14 = bundle.getString("key_mv_thumb_path", null);
                    }
                    css3.jfz = str14;
                    css = css3;
                } else {
                    css = css2;
                }
                MultiTaskInfo multiTaskInfo = kVar.Abp;
                if (multiTaskInfo != null) {
                    String str15 = etY.field_songSinger;
                    p.g(str15, "music.field_songSinger");
                    if (str15.length() > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        str = " · " + etY.field_songSinger;
                    } else {
                        str = "";
                    }
                    multiTaskInfo.erh().title = etY.field_songName + str;
                    multiTaskInfo.erh().nickname = css.Ktq;
                    cso cso = new cso();
                    cso.jfy = css;
                    cso.musicType = etY.field_musicType;
                    cso.Djf = etY.field_songAlbumUrl;
                    cso.name = etY.field_songName;
                    cso.lDR = etY.field_songSinger;
                    cso.lDS = etY.field_songWebUrl;
                    cso.Mxy = etY.field_songWapLinkUrl;
                    cso.Mxz = etY.field_songWifiUrl;
                    cso.dSF = etY.field_musicId;
                    cso.MxB = etY.field_songAlbumLocalPath;
                    cso.MxC = etY.field_songAlbum;
                    cso.appId = etY.field_appId;
                    cso.MxD = etY.field_songHAlbumUrl;
                    multiTaskInfo.field_data = cso.toByteArray();
                }
            }
            this.Akh.O(0, false);
        } else {
            Log.i("MicroMsg.GlobalMusicPlayerFloatBallHelper", "onFloatBallRemoved currentMusic is null");
        }
        super.C(ballInfo);
        AppMethodBeat.o(219962);
    }

    public final void d(css css) {
        AppMethodBeat.i(219963);
        this.Akg = css;
        Object[] objArr = new Object[1];
        css css2 = this.Akg;
        objArr[0] = css2 != null ? Integer.valueOf(css2.hashCode()) : null;
        Log.i("MicroMsg.GlobalMusicPlayerFloatBallHelper", "alvinluo updateMusicShareObject hashCode: %s", objArr);
        AppMethodBeat.o(219963);
    }

    public final void as(Bundle bundle) {
        AppMethodBeat.i(219964);
        if (!p.j(this.Ake, bundle)) {
            this.Ake = bundle;
            Object[] objArr = new Object[1];
            Bundle bundle2 = this.Ake;
            objArr[0] = bundle2 != null ? Integer.valueOf(bundle2.hashCode()) : null;
            Log.i("MicroMsg.GlobalMusicPlayerFloatBallHelper", "alvinluo updateMusicMvUIExtra hashCode: %s", objArr);
            hWs();
        }
        AppMethodBeat.o(219964);
    }

    private final void hWs() {
        AppMethodBeat.i(261711);
        for (T t : this.UZe) {
            if (t != null) {
                t.bx(this.Ake);
            }
        }
        AppMethodBeat.o(261711);
    }

    public final void aHN(String str) {
        AppMethodBeat.i(219965);
        Log.i("MicroMsg.GlobalMusicPlayerFloatBallHelper", "alvinluo updateMusicCoverPath %s", str);
        this.Akf = str;
        FloatBallMusicView floatBallMusicView = this.Akd;
        if (floatBallMusicView != null) {
            floatBallMusicView.setCoverPath(str);
            AppMethodBeat.o(219965);
            return;
        }
        AppMethodBeat.o(219965);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c implements View.OnClickListener {
        final /* synthetic */ d Akl;

        c(d dVar) {
            this.Akl = dVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(219956);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/music/model/GlobalMusicPlayerFloatBallHelper$initMusicFloatBallView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            ol olVar = new ol();
            olVar.PP(2);
            olVar.PQ(4);
            aq.a(olVar);
            this.Akl.cir();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/music/model/GlobalMusicPlayerFloatBallHelper$initMusicFloatBallView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(219956);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.music.model.d$d  reason: collision with other inner class name */
    static final class View$OnClickListenerC1539d implements View.OnClickListener {
        final /* synthetic */ d Akl;

        View$OnClickListenerC1539d(d dVar) {
            this.Akl = dVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(219957);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/music/model/GlobalMusicPlayerFloatBallHelper$initMusicFloatBallView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            d.a(this.Akl);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/music/model/GlobalMusicPlayerFloatBallHelper$initMusicFloatBallView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(219957);
        }
    }

    public final Intent eut() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        int i2;
        String str14;
        Integer num = null;
        AppMethodBeat.i(219966);
        Intent intent = new Intent();
        if (this.Ake != null) {
            Object[] objArr = new Object[1];
            Bundle bundle = this.Ake;
            if (bundle != null) {
                num = Integer.valueOf(bundle.hashCode());
            }
            objArr[0] = num;
            Log.i("MicroMsg.GlobalMusicPlayerFloatBallHelper", "getMusicMvUIIntent jump by extra %s", objArr);
            Bundle bundle2 = this.Ake;
            if (bundle2 == null) {
                p.hyc();
            }
            intent.putExtras(bundle2);
        } else {
            css css = this.Akg;
            Object[] objArr2 = new Object[1];
            if (css != null) {
                num = Integer.valueOf(css.hashCode());
            }
            objArr2[0] = num;
            Log.i("MicroMsg.GlobalMusicPlayerFloatBallHelper", "getMusicMvUIIntent jump by musicShareObject: %s", objArr2);
            intent.putExtra("key_scene", 6);
            if (css == null || (str = css.Ktn) == null) {
                str = "";
            }
            intent.putExtra("key_mv_feed_id", str);
            if (css == null || (str2 = css.Kto) == null) {
                str2 = "";
            }
            intent.putExtra("key_mv_nonce_id", str2);
            if (css == null || (str3 = css.Ktp) == null) {
                str3 = "";
            }
            intent.putExtra("key_mv_cover_url", str3);
            if (css == null || (str4 = css.Ktq) == null) {
                str4 = "";
            }
            intent.putExtra("key_mv_poster", str4);
            if (css == null || (str5 = css.BPc) == null) {
                str5 = "";
            }
            intent.putExtra("key_mv_song_name", str5);
            if (css == null || (str6 = css.songLyric) == null) {
                str6 = "";
            }
            intent.putExtra("key_mv_song_lyric", str6);
            if (css == null || (str7 = css.singerName) == null) {
                str7 = "";
            }
            intent.putExtra("key_mv_singer_name", str7);
            if (css == null || (str8 = css.albumName) == null) {
                str8 = "";
            }
            intent.putExtra("key_mv_album_name", str8);
            if (css == null || (str9 = css.musicGenre) == null) {
                str9 = "";
            }
            intent.putExtra("key_mv_music_genre", str9);
            if (css == null || (str10 = String.valueOf(css.issueDate)) == null) {
                str10 = "";
            }
            intent.putExtra("key_mv_issue_date", str10);
            if (css == null || (str11 = css.EsK) == null) {
                str11 = "";
            }
            intent.putExtra("key_mv_album_cover_url", str11);
            if (css == null || (str12 = css.identification) == null) {
                str12 = "";
            }
            intent.putExtra("key_mv_identification", str12);
            if (css == null || (str13 = css.extraInfo) == null) {
                str13 = "";
            }
            intent.putExtra("key_mv_extra_info", str13);
            if (css != null) {
                i2 = css.Alz;
            } else {
                i2 = 0;
            }
            intent.putExtra("key_mv_music_duration", i2);
            if (css == null || (str14 = css.jfz) == null) {
                str14 = "";
            }
            intent.putExtra("key_mv_thumb_path", str14);
            intent.setFlags(268435456);
        }
        AppMethodBeat.o(219966);
        return intent;
    }

    public static final /* synthetic */ void a(d dVar) {
        AppMethodBeat.i(219969);
        cst cst = new cst();
        com.tencent.mm.plugin.comm.a aVar = com.tencent.mm.plugin.comm.a.qCo;
        cst.sGQ = com.tencent.mm.plugin.comm.a.cAK();
        cst.scene = 4;
        Intent eut = dVar.eut();
        eut.putExtra("key_mv_report_data", cst.toByteArray());
        com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "mv", ".ui.MusicMvMainUI", eut);
        AppMethodBeat.o(219969);
    }

    public static final d euu() {
        AppMethodBeat.i(219970);
        b bVar = b.Akk;
        d euv = b.euv();
        AppMethodBeat.o(219970);
        return euv;
    }
}
