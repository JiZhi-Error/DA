package com.tencent.mm.plugin.mv.ui.uic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ay.f;
import com.tencent.mm.g.b.a.gk;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.model.b;
import com.tencent.mm.plugin.music.model.e;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.plugin.music.model.m;
import com.tencent.mm.plugin.mv.a.e;
import com.tencent.mm.plugin.mv.a.n;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.axw;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.protocal.protobuf.csp;
import com.tencent.mm.protocal.protobuf.csr;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010?\u001a\u00020\u001c2\u0006\u0010@\u001a\u00020\u0016J\b\u0010A\u001a\u00020BH\u0002J\u000e\u0010C\u001a\u00020B2\u0006\u0010D\u001a\u00020EJ\u0010\u0010F\u001a\u00020\u001c2\b\u0010G\u001a\u0004\u0018\u00010HJ\u0012\u0010I\u001a\u00020B2\b\u0010J\u001a\u0004\u0018\u00010KH\u0016J\b\u0010L\u001a\u00020BH\u0016J,\u0010M\u001a\u00020B2\u0006\u0010N\u001a\u00020\u000f2\u0006\u0010O\u001a\u00020\u000f2\b\u0010P\u001a\u0004\u0018\u00010\u00072\b\u0010Q\u001a\u0004\u0018\u00010RH\u0016J\u0006\u0010S\u001a\u00020BR\u0014\u0010\u0006\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\t\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010*\"\u0004\b/\u0010,R\u001a\u00100\u001a\u000201X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\u000207X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001c\u0010<\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\t\"\u0004\b>\u0010\r¨\u0006T"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvDataUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "firstTimeEnterMusicId", "getFirstTimeEnterMusicId", "setFirstTimeEnterMusicId", "(Ljava/lang/String;)V", "firstTimeEnterMusicType", "", "getFirstTimeEnterMusicType", "()Ljava/lang/Integer;", "setFirstTimeEnterMusicType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "initMv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "getInitMv", "()Lcom/tencent/mm/plugin/mv/model/MusicMv;", "setInitMv", "(Lcom/tencent/mm/plugin/mv/model/MusicMv;)V", "launchCommentDialog", "", "getLaunchCommentDialog", "()Z", "setLaunchCommentDialog", "(Z)V", "lyricObj", "Lcom/tencent/mm/plugin/music/model/LyricObj;", "getLyricObj", "()Lcom/tencent/mm/plugin/music/model/LyricObj;", "setLyricObj", "(Lcom/tencent/mm/plugin/music/model/LyricObj;)V", "mvPostPermissionBit", "", "getMvPostPermissionBit", "()J", "setMvPostPermissionBit", "(J)V", "refCommentId", "getRefCommentId", "setRefCommentId", "shareExtInfo", "Lcom/tencent/mm/protocal/protobuf/MusicShareExtInfo;", "getShareExtInfo", "()Lcom/tencent/mm/protocal/protobuf/MusicShareExtInfo;", "setShareExtInfo", "(Lcom/tencent/mm/protocal/protobuf/MusicShareExtInfo;)V", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "getSongInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "setSongInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;)V", "verifyInfo", "getVerifyInfo", "setVerifyInfo", "canCreateMv", "musicMv", "checkAndFillThirdAppSongInfo", "", "initData", "intent", "Landroid/content/Intent;", "isSameMusic", "musicWrapper", "Lcom/tencent/mm/modelmusic/MusicWrapper;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "parseLyric", "plugin-mv_release"})
public final class MusicMvDataUIC extends UIComponent implements i {
    e Amv;
    public axy Aqo = new axy();
    String Ato;
    public com.tencent.mm.plugin.mv.a.e Atp = new com.tencent.mm.plugin.mv.a.e();
    long Atq;
    csr Atr = new csr();
    public boolean Ats;
    private final String TAG = "MicroMsg.Mv.MusicMvDataUIC";
    Integer UZU;
    public String fuN;
    public long tuj;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MusicMvDataUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(257113);
        AppMethodBeat.o(257113);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        String str;
        boolean z;
        boolean z2;
        boolean z3;
        FinderObjectDesc finderObjectDesc;
        axw axw;
        axy axy;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        x xVar = null;
        AppMethodBeat.i(257109);
        super.onCreate(bundle);
        Intent intent = getIntent();
        p.h(intent, "intent");
        com.tencent.mm.plugin.music.model.l lVar = com.tencent.mm.plugin.music.model.l.AkI;
        a au = com.tencent.mm.plugin.music.model.l.au(getActivity());
        if (au != null) {
            com.tencent.mm.plugin.mv.ui.a aVar = com.tencent.mm.plugin.mv.ui.a.ArA;
            com.tencent.mm.plugin.mv.ui.a.a(au, this.Aqo);
        }
        k euj = k.euj();
        p.g(euj, "MusicPlayerManager.Instance()");
        f etU = euj.etU();
        this.UZU = etU != null ? Integer.valueOf(etU.jeT) : null;
        k euj2 = k.euj();
        p.g(euj2, "MusicPlayerManager.Instance()");
        f etU2 = euj2.etU();
        if (etU2 != null) {
            str = etU2.jeV;
        } else {
            str = null;
        }
        this.Ato = str;
        String stringExtra = getIntent().getStringExtra("key_mv_song_name");
        if (stringExtra != null) {
            if (!(stringExtra.length() > 0)) {
                stringExtra = null;
            }
        } else {
            stringExtra = null;
        }
        this.Aqo.BPc = stringExtra;
        String stringExtra2 = getIntent().getStringExtra("key_mv_song_lyric");
        if (stringExtra2 != null) {
            if (stringExtra2.length() > 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (!z12) {
                stringExtra2 = null;
            }
        } else {
            stringExtra2 = null;
        }
        this.Aqo.LIh = stringExtra2;
        String stringExtra3 = getIntent().getStringExtra("key_mv_singer_name");
        if (stringExtra3 != null) {
            if (stringExtra3.length() > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                stringExtra3 = null;
            }
        } else {
            stringExtra3 = null;
        }
        this.Aqo.lDR = stringExtra3;
        String stringExtra4 = getIntent().getStringExtra("key_mv_album_name");
        if (stringExtra4 != null) {
            if (stringExtra4.length() > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10) {
                stringExtra4 = null;
            }
        } else {
            stringExtra4 = null;
        }
        this.Aqo.albumName = stringExtra4;
        String stringExtra5 = getIntent().getStringExtra("key_mv_album_cover_url");
        if (stringExtra5 != null) {
            if (stringExtra5.length() > 0) {
                z9 = true;
            } else {
                z9 = false;
            }
            if (!z9) {
                stringExtra5 = null;
            }
        } else {
            stringExtra5 = null;
        }
        this.Aqo.Djf = stringExtra5;
        String stringExtra6 = getIntent().getStringExtra("key_mv_issue_date");
        if (stringExtra6 != null) {
            if (stringExtra6.length() > 0) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (!z8) {
                stringExtra6 = null;
            }
        } else {
            stringExtra6 = null;
        }
        this.Aqo.LIk = Util.safeParseLong(stringExtra6);
        String stringExtra7 = getIntent().getStringExtra("key_mv_music_genre");
        if (stringExtra7 != null) {
            if (stringExtra7.length() > 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (!z7) {
                stringExtra7 = null;
            }
        } else {
            stringExtra7 = null;
        }
        this.Aqo.LIi = stringExtra7;
        String stringExtra8 = getIntent().getStringExtra("key_mv_identification");
        if (stringExtra8 != null) {
            if (stringExtra8.length() > 0) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (!z6) {
                stringExtra8 = null;
            }
        } else {
            stringExtra8 = null;
        }
        this.Aqo.identification = stringExtra8;
        String stringExtra9 = getIntent().getStringExtra("key_mv_extra_info");
        if (stringExtra9 != null) {
            if (stringExtra9.length() > 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (!z5) {
                stringExtra9 = null;
            }
        } else {
            stringExtra9 = null;
        }
        this.Aqo.extraInfo = stringExtra9;
        String stringExtra10 = getIntent().getStringExtra("key_mv_thumb_path");
        if (stringExtra10 != null) {
            if (stringExtra10.length() > 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (!z4) {
                stringExtra10 = null;
            }
        } else {
            stringExtra10 = null;
        }
        this.Atr.thumbPath = stringExtra10;
        this.Aqo.duration = getIntent().getIntExtra("key_mv_music_duration", 0);
        String str2 = this.TAG;
        com.tencent.mm.plugin.mv.ui.a aVar2 = com.tencent.mm.plugin.mv.ui.a.ArA;
        Log.v(str2, "alvinluo checkAndFillThirdAppSongInfo ext: %s, identification: %s, duration: %s, musicAppId: %s, %s", this.Aqo.extraInfo, this.Aqo.identification, Integer.valueOf(this.Aqo.duration), this.Aqo.LIf, com.tencent.mm.plugin.mv.ui.a.a(this.Aqo));
        byte[] byteArrayExtra = intent.getByteArrayExtra("key_track_data");
        if (byteArrayExtra != null) {
            csp csp = new csp();
            csp.parseFrom(byteArrayExtra);
            FinderObject finderObject = csp.MxE;
            if (!(finderObject == null || (finderObjectDesc = finderObject.objectDesc) == null || (axw = finderObjectDesc.mvInfo) == null || (axy = axw.Aqo) == null)) {
                p.g(axy, LocaleUtil.ITALIAN);
                this.Aqo = axy;
            }
            e.a aVar3 = com.tencent.mm.plugin.mv.a.e.ApR;
            this.Atp = e.a.b(csp);
            c.a aVar4 = c.vGN;
            FinderItem FS = c.a.FS(csp.localId);
            if (FS != null) {
                if (FS.isPostFailed()) {
                    this.Atp.ApM = 3;
                } else if (!FS.isPostFinish()) {
                    this.Atp.ApM = 2;
                } else {
                    this.Atp.ApM = 1;
                }
            }
            Log.i(this.TAG, "init by trackData mvLocalId:" + this.Atp.ApB + " coverPath:" + this.Atp.ApD + " mvPostStatus:" + this.Atp.ApM);
        } else {
            MusicMvDataUIC musicMvDataUIC = this;
            String stringExtra11 = intent.getStringExtra("key_mv_feed_id");
            String stringExtra12 = intent.getStringExtra("key_mv_nonce_id");
            String stringExtra13 = intent.getStringExtra("key_mv_cover_url");
            String stringExtra14 = intent.getStringExtra("key_mv_poster");
            if (!(stringExtra11 == null || stringExtra12 == null || stringExtra13 == null || stringExtra14 == null)) {
                if (stringExtra11.length() > 0) {
                    if (stringExtra12.length() > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        if (stringExtra13.length() > 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            if (stringExtra14.length() > 0) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (z3) {
                                musicMvDataUIC.Atp.ApE = Long.valueOf(d.Ga(stringExtra11));
                                musicMvDataUIC.Atp.ApF = stringExtra12;
                                musicMvDataUIC.Atp.coverUrl = stringExtra13;
                                musicMvDataUIC.Atp.aIm(stringExtra14);
                                if (intent.getBooleanExtra("key_need_update_music_ball_url", false)) {
                                    b.aHM(musicMvDataUIC.Atp.coverUrl);
                                }
                                Log.i(musicMvDataUIC.TAG, "init by feedId:" + stringExtra11 + " feedNonceId:" + stringExtra12);
                                xVar = x.SXb;
                            }
                        }
                    }
                }
                musicMvDataUIC.Atp.ApO = true;
                Log.i(musicMvDataUIC.TAG, "enter empty mv 1 " + stringExtra11 + ' ' + stringExtra12 + ' ' + stringExtra13 + ' ' + stringExtra14);
                xVar = x.SXb;
            }
            if (xVar == null) {
                musicMvDataUIC.Atp.ApO = true;
                Log.i(musicMvDataUIC.TAG, "enter empty mv 2");
                x xVar2 = x.SXb;
            }
        }
        evO();
        this.Ats = intent.getBooleanExtra("key_launch_mv_comment", false);
        this.tuj = intent.getLongExtra("key_refer_mv_comment_id", 0);
        AppMethodBeat.o(257109);
    }

    public final void evO() {
        AppMethodBeat.i(257110);
        axy axy = this.Aqo;
        String str = axy.LIh;
        axy axy2 = !(str == null || str.length() == 0) ? axy : null;
        if (axy2 != null) {
            com.tencent.mm.plugin.music.model.e a2 = com.tencent.mm.plugin.music.model.e.a(axy2.LIh, getActivity().getString(R.string.f9t), "", m.iZ(axy2.LIg, axy2.musicDataUrl), axy2.lDR, false, false);
            p.g(a2, "obj");
            if (a2.euw() <= 1) {
                a2 = null;
            }
            this.Amv = a2;
            AppMethodBeat.o(257110);
            return;
        }
        AppMethodBeat.o(257110);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(257111);
        Log.i(this.TAG, "onSceneEnd errType:" + i2 + " errCode:" + i3 + " errMsg:" + str + " scene:" + qVar);
        AppMethodBeat.o(257111);
    }

    public final boolean d(com.tencent.mm.plugin.mv.a.e eVar) {
        AppMethodBeat.i(257112);
        p.h(eVar, "musicMv");
        if ((this.Atq & 1) <= 0) {
            AppMethodBeat.o(257112);
            return false;
        } else if (eVar.ApM == 1) {
            if (eVar.ApH.size() > 0) {
                AppMethodBeat.o(257112);
                return true;
            }
            AppMethodBeat.o(257112);
            return false;
        } else if (eVar.ApM != 4) {
            AppMethodBeat.o(257112);
            return false;
        } else if (eVar.ApP == null || eVar.ApQ.size() <= 0) {
            AppMethodBeat.o(257112);
            return false;
        } else {
            AppMethodBeat.o(257112);
            return true;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        String str;
        boolean z;
        String str2 = null;
        AppMethodBeat.i(259238);
        com.tencent.mm.plugin.mv.a.k kVar = com.tencent.mm.plugin.mv.a.k.Aql;
        AppCompatActivity activity = getActivity();
        axy axy = this.Aqo;
        p.h(activity, "context");
        p.h(axy, "songInfo");
        SecDataUIC.a aVar = SecDataUIC.CWq;
        cst cst = (cst) SecDataUIC.a.a(activity, 7, cst.class);
        gk gkVar = new gk();
        if (cst != null) {
            gkVar.tW(cst.sGQ);
            gkVar.qn((long) cst.scene);
            gkVar.ub(cst.MxJ);
            gkVar.Qj((long) cst.MxN);
            gkVar.Ql((long) cst.Vkg);
        }
        n mm = com.tencent.mm.plugin.mv.a.k.mm(activity);
        gkVar.Qg(mm.UZu);
        gkVar.Qh(mm.UZv);
        gkVar.Qi(mm.UZw);
        String str3 = axy.BPc;
        if (str3 != null) {
            str = kotlin.n.n.j(str3, ",", " ", false);
        } else {
            str = null;
        }
        gkVar.tX(str);
        gkVar.ua(axy.LIf);
        gkVar.tY(axy.LIg);
        gkVar.tZ(axy.musicDataUrl);
        String str4 = axy.LIh;
        if (str4 == null || str4.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        gkVar.qo(z ? 2 : 1);
        gkVar.ue(axy.AqO);
        String str5 = axy.lDR;
        if (str5 != null) {
            str2 = kotlin.n.n.j(str5, ",", " ", false);
        }
        gkVar.bvO(str2);
        gkVar.Qf(2);
        gkVar.Qk(com.tencent.mm.plugin.mv.a.k.mn(activity));
        gkVar.bfK();
        com.tencent.mm.util.b bVar = com.tencent.mm.util.b.QYu;
        com.tencent.mm.util.b.a(gkVar);
        AppMethodBeat.o(259238);
    }

    public final boolean f(f fVar) {
        AppMethodBeat.i(259239);
        if (fVar != null) {
            int i2 = fVar.jeT;
            Integer num = this.UZU;
            if (num != null && i2 == num.intValue() && p.j(fVar.jeV, this.Ato)) {
                AppMethodBeat.o(259239);
                return true;
            }
            AppMethodBeat.o(259239);
            return false;
        }
        AppMethodBeat.o(259239);
        return false;
    }
}
