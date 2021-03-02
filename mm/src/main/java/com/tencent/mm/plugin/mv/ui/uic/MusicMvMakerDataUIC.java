package com.tencent.mm.plugin.mv.ui.uic;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.on;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.plugin.mv.ui.uic.a.b;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.axw;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.protocal.protobuf.axz;
import com.tencent.mm.protocal.protobuf.csp;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u001d\u001a\u00020\u001eJ\u0012\u0010\u001f\u001a\u00020\u001e2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerDataUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/mv/ui/uic/callback/OnDataReadyListener;", "getListener", "()Lcom/tencent/mm/plugin/mv/ui/uic/callback/OnDataReadyListener;", "setListener", "(Lcom/tencent/mm/plugin/mv/ui/uic/callback/OnDataReadyListener;)V", "music", "Lcom/tencent/mm/plugin/music/model/storage/Music;", "getMusic", "()Lcom/tencent/mm/plugin/music/model/storage/Music;", "setMusic", "(Lcom/tencent/mm/plugin/music/model/storage/Music;)V", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "getSongInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "setSongInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;)V", "trackData", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "getTrackData", "()Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "setTrackData", "(Lcom/tencent/mm/protocal/protobuf/MusicMvData;)V", "initData", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "plugin-mv_release"})
public final class MusicMvMakerDataUIC extends UIComponent {
    public a AkC;
    public csp AqY;
    public axy Aqo = new axy();
    public b Auy;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MusicMvMakerDataUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(257201);
        AppMethodBeat.o(257201);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        String str;
        long j2;
        FinderObject finderObject;
        FinderObjectDesc finderObjectDesc;
        axw axw;
        LinkedList<axz> linkedList;
        boolean z;
        String str2;
        FinderObjectDesc finderObjectDesc2;
        axw axw2;
        axy axy;
        String str3;
        FinderObjectDesc finderObjectDesc3;
        axw axw3;
        axy axy2;
        FinderObject finderObject2;
        FinderObjectDesc finderObjectDesc4;
        axw axw4;
        axy axy3;
        csp csp;
        String str4 = null;
        AppMethodBeat.i(257200);
        super.onCreate(bundle);
        com.tencent.mm.plugin.music.model.l lVar = com.tencent.mm.plugin.music.model.l.AkI;
        this.AkC = com.tencent.mm.plugin.music.model.l.au(getActivity());
        a aVar = this.AkC;
        if (aVar != null) {
            com.tencent.mm.plugin.mv.ui.a aVar2 = com.tencent.mm.plugin.mv.ui.a.ArA;
            com.tencent.mm.plugin.mv.ui.a.a(aVar, this.Aqo);
        }
        this.AqY = new csp();
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_track_data");
        if (!(byteArrayExtra == null || (csp = this.AqY) == null)) {
            csp.parseFrom(byteArrayExtra);
        }
        csp csp2 = this.AqY;
        if (!(csp2 == null || (finderObject2 = csp2.MxE) == null || (finderObjectDesc4 = finderObject2.objectDesc) == null || (axw4 = finderObjectDesc4.mvInfo) == null || (axy3 = axw4.Aqo) == null)) {
            p.g(axy3, LocaleUtil.ITALIAN);
            this.Aqo = axy3;
        }
        a aVar3 = this.AkC;
        csp csp3 = this.AqY;
        if (!(aVar3 == null || csp3 == null)) {
            String str5 = aVar3.field_songHAlbumUrl;
            if (str5 == null || str5.length() == 0) {
                FinderObject finderObject3 = csp3.MxE;
                if (finderObject3 == null || (finderObjectDesc3 = finderObject3.objectDesc) == null || (axw3 = finderObjectDesc3.mvInfo) == null || (axy2 = axw3.Aqo) == null) {
                    str3 = null;
                } else {
                    str3 = axy2.Djf;
                }
                aVar3.field_songHAlbumUrl = str3;
            }
            String str6 = aVar3.field_songLyric;
            if (str6 == null || str6.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                FinderObject finderObject4 = csp3.MxE;
                if (finderObject4 == null || (finderObjectDesc2 = finderObject4.objectDesc) == null || (axw2 = finderObjectDesc2.mvInfo) == null || (axy = axw2.Aqo) == null) {
                    str2 = null;
                } else {
                    str2 = axy.LIh;
                }
                aVar3.field_songLyric = str2;
            }
        }
        com.tencent.mm.plugin.mv.a.l lVar2 = com.tencent.mm.plugin.mv.a.l.UZs;
        Activity context = getContext();
        axy axy4 = this.Aqo;
        csp csp4 = this.AqY;
        p.h(context, "context");
        p.h(axy4, "songInfo");
        SecDataUIC.a aVar4 = SecDataUIC.CWq;
        cst cst = (cst) SecDataUIC.a.a(context, 7, cst.class);
        com.tencent.mm.plugin.mv.a.l.UZn = new on();
        if (cst != null) {
            com.tencent.mm.plugin.mv.a.l.UZn.bvy(cst.sGQ);
            com.tencent.mm.plugin.mv.a.l.UZn.Qe((long) cst.scene);
            com.tencent.mm.plugin.mv.a.l.UZn.bvH(cst.Vkb);
        }
        on onVar = com.tencent.mm.plugin.mv.a.l.UZn;
        com.tencent.mm.plugin.comm.a aVar5 = com.tencent.mm.plugin.comm.a.qCo;
        onVar.bvz(com.tencent.mm.plugin.comm.a.cAK());
        on onVar2 = com.tencent.mm.plugin.mv.a.l.UZn;
        String str7 = axy4.BPc;
        if (str7 != null) {
            str = n.j(str7, ",", " ", false);
        } else {
            str = null;
        }
        onVar2.bvA(str);
        com.tencent.mm.plugin.mv.a.l.UZn.bvB(axy4.AqO);
        com.tencent.mm.plugin.mv.a.l.UZn.bvC(axy4.LIg);
        com.tencent.mm.plugin.mv.a.l.UZn.bvD(axy4.musicDataUrl);
        on onVar3 = com.tencent.mm.plugin.mv.a.l.UZn;
        String str8 = axy4.lDR;
        if (str8 != null) {
            str4 = n.j(str8, ",", " ", false);
        }
        onVar3.bvE(str4);
        on onVar4 = com.tencent.mm.plugin.mv.a.l.UZn;
        String aUg = z.aUg();
        if (aUg == null) {
            aUg = "";
        }
        onVar4.bvF(aUg);
        on onVar5 = com.tencent.mm.plugin.mv.a.l.UZn;
        if (csp4 == null || (finderObject = csp4.MxE) == null || (finderObjectDesc = finderObject.objectDesc) == null || (axw = finderObjectDesc.mvInfo) == null || (linkedList = axw.LId) == null) {
            j2 = 0;
        } else {
            j2 = (long) linkedList.size();
        }
        onVar5.PZ(j2);
        on hWv = com.tencent.mm.plugin.mv.a.l.hWv();
        hWv.PV(1);
        hWv.bfK();
        com.tencent.mm.util.b bVar = com.tencent.mm.util.b.QYu;
        com.tencent.mm.util.b.a(hWv);
        b bVar2 = this.Auy;
        if (bVar2 != null) {
            bVar2.evE();
            AppMethodBeat.o(257200);
            return;
        }
        AppMethodBeat.o(257200);
    }
}
