package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.ag.w;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.d;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.modelsns.k;
import com.tencent.mm.modelstat.i;
import com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar;
import com.tencent.mm.plugin.sight.decode.ui.VideoPlayView;
import com.tencent.mm.plugin.sns.ad.g.l;
import com.tencent.mm.plugin.sns.ad.g.o;
import com.tencent.mm.plugin.sns.data.n;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.model.c;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.widget.snackbar.b;
import com.tencent.mm.vfs.s;

@a(19)
public class VideoAdPlayerUI extends MMActivity implements c.a, c.b {
    private String DZi = "";
    private SnsInfo DsC;
    private VideoPlayView ERV;
    private k ERW = null;
    private int ERX = 0;
    private cnb ERY = null;
    private String ERZ;
    private int ESa;
    private String[] ESb = null;
    private String[] ESc = null;
    private String EzJ = "";
    private boolean EzK = false;
    private boolean EzL = false;
    private String EzM = "";
    private l EzN = new l("VideoAdPlayerUI");
    public String EzO = "";
    public String EzP = "";
    private int EzQ = 0;
    private int EzR = 0;
    private String EzS = "";
    private String EzT;
    private String EzU = "";
    private long EzV = 0;
    private int EzW = 0;
    private int EzX = 0;
    private String bssid;
    private String ean;
    private String fullPath = "";
    private boolean gVd = false;
    private boolean isAd = false;
    private String izc = "";
    private String izd = "";
    private String mediaId = "";
    private d pNk;
    private String ssid;
    private String thumbPath = "";
    private String thumbUrl = "";
    private String url = "";
    private String viewId = "";

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public VideoAdPlayerUI() {
        AppMethodBeat.i(99792);
        AppMethodBeat.o(99792);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(99793);
        super.onCreate(bundle);
        hideTitleView();
        if (ao.aQ(getContext())) {
            getController().setActionbarColor(getResources().getColor(R.color.bj));
        }
        this.ESb = new String[]{getString(R.string.h4t), getString(R.string.h4u), getString(R.string.h4r)};
        this.ESc = new String[]{getString(R.string.h4t), getString(R.string.h4u)};
        this.DsC = aj.faO().aQl(new StringBuilder().append(r.aOw(getIntent().getStringExtra("KSta_SnSId"))).toString());
        this.pNk = new d();
        this.ERW = k.w(getIntent());
        this.fullPath = getIntent().getStringExtra("KFullVideoPath");
        this.EzJ = getIntent().getStringExtra("KStremVideoUrl");
        this.thumbUrl = getIntent().getStringExtra("KThumUrl");
        this.mediaId = getIntent().getStringExtra("KMediaId");
        this.isAd = getIntent().getBooleanExtra("KFromTimeLine", false);
        this.url = getIntent().getStringExtra("KUrl");
        this.EzM = Util.nullAs(getIntent().getStringExtra("KMediaTitle"), "");
        this.ERX = getIntent().getIntExtra("KMediaVideoTime", 0);
        this.EzL = getIntent().getBooleanExtra("KBlockFav", false);
        this.EzK = getIntent().getBooleanExtra("ForceLandscape", false);
        this.izc = getIntent().getStringExtra("StreamWording");
        this.izd = getIntent().getStringExtra("StremWebUrl");
        this.DZi = getIntent().getStringExtra("KComponentCid");
        this.EzO = getIntent().getStringExtra("KSta_StremVideoAduxInfo");
        this.EzP = getIntent().getStringExtra("KSta_StremVideoPublishId");
        this.EzQ = getIntent().getIntExtra("KSta_SourceType", 0);
        this.EzR = getIntent().getIntExtra("KSta_Scene", 0);
        this.EzS = getIntent().getStringExtra("KSta_FromUserName");
        this.EzT = getIntent().getStringExtra("KSta_ChatName");
        this.EzU = getIntent().getStringExtra("KSta_SnSId");
        this.EzV = getIntent().getLongExtra("KSta_MsgId", 0);
        this.EzW = getIntent().getIntExtra("KSta_FavID", 0);
        this.EzX = getIntent().getIntExtra("KSta_ChatroomMembercount", 0);
        this.ean = getIntent().getStringExtra("KSta_SnsStatExtStr");
        this.viewId = Util.nullAs(getIntent().getStringExtra("KViewId"), "");
        this.ERZ = Util.nullAs(getIntent().getStringExtra("ReportArgs"), "");
        this.ESa = getIntent().getIntExtra("NeedReportData", 0);
        if (this.ESa != 0) {
            this.ssid = NetStatusUtil.getConnectedWifiSsid(MMApplicationContext.getContext());
            this.bssid = NetStatusUtil.getConnectedWifiBssid(MMApplicationContext.getContext());
        }
        this.ERY = new cnb();
        this.ERY.Msz = this.thumbUrl;
        this.ERY.MsF = this.EzJ;
        this.ERY.Id = this.mediaId;
        this.ERY.Url = this.url;
        this.ERY.Mcw = 1;
        this.ERY.ERX = this.ERX;
        this.EzN.DvQ = Util.currentTicks();
        Log.i("MicroMsg.VideoPlayerUI", "init streamvideo " + this.ERY.Id + " attachurl:" + this.ERY.MsF + " videoattachTotalTime:" + this.ERY.ERX + " streamvideowording: " + this.izc + " streamvideoweburl: " + this.izd + " mediaTitle: " + this.EzM + " thumburl " + this.thumbUrl + " streamvideoaduxinfo " + this.EzO + " streamvideopublishid " + this.EzP);
        if (Util.isNullOrNil(this.fullPath)) {
            this.fullPath = ar.ki(aj.getAccSnsPath(), this.ERY.Id) + r.k(this.ERY);
        }
        if (Util.isNullOrNil(this.thumbPath) || !s.YS(this.thumbPath)) {
            String str = "attach" + this.ERY.Id;
            this.thumbPath = ar.ki(aj.getAccSnsPath(), str) + r.aOf(str);
        }
        if (!s.YS(this.thumbPath)) {
            try {
                cnb cnb = new cnb();
                cnb.parseFrom(this.ERY.toByteArray());
                cnb.Id = "attach" + cnb.Id;
                n nVar = new n(this.ERY);
                nVar.DEs = 1;
                nVar.dPI = this.ERY.Id;
                aj.faJ().a(cnb, 7, nVar, bp.Oqt);
            } catch (Exception e2) {
                Log.e("MicroMsg.VideoPlayerUI", "error for download thumb");
            }
            getWindow().addFlags(128);
        }
        this.ERV = (VideoPlayView) findViewById(R.id.j5t);
        VideoPlayView videoPlayView = this.ERV;
        AdVideoPlayerLoadingBar adVideoPlayerLoadingBar = new AdVideoPlayerLoadingBar(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = videoPlayView.getContext().getResources().getDimensionPixelSize(R.dimen.ih);
        videoPlayView.DnU = adVideoPlayerLoadingBar;
        videoPlayView.qbJ.setPlayProgressCallback(true);
        videoPlayView.addView((View) videoPlayView.DnU, layoutParams);
        videoPlayView.DnU.setIplaySeekCallback(
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x03e4: INVOKE  
              (wrap: com.tencent.mm.plugin.sight.decode.ui.a : 0x03dd: IGET  (r0v98 com.tencent.mm.plugin.sight.decode.ui.a) = (r1v66 'videoPlayView' com.tencent.mm.plugin.sight.decode.ui.VideoPlayView) com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.DnU com.tencent.mm.plugin.sight.decode.ui.a)
              (wrap: com.tencent.mm.plugin.sight.decode.ui.VideoPlayView$5 : 0x03e1: CONSTRUCTOR  (r3v2 com.tencent.mm.plugin.sight.decode.ui.VideoPlayView$5) = (r1v66 'videoPlayView' com.tencent.mm.plugin.sight.decode.ui.VideoPlayView) call: com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.5.<init>(com.tencent.mm.plugin.sight.decode.ui.VideoPlayView):void type: CONSTRUCTOR)
             type: INTERFACE call: com.tencent.mm.plugin.sight.decode.ui.a.setIplaySeekCallback(com.tencent.mm.plugin.sight.decode.ui.b):void in method: com.tencent.mm.plugin.sns.ui.VideoAdPlayerUI.onCreate(android.os.Bundle):void, file: classes3.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x03e1: CONSTRUCTOR  (r3v2 com.tencent.mm.plugin.sight.decode.ui.VideoPlayView$5) = (r1v66 'videoPlayView' com.tencent.mm.plugin.sight.decode.ui.VideoPlayView) call: com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.5.<init>(com.tencent.mm.plugin.sight.decode.ui.VideoPlayView):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.sns.ui.VideoAdPlayerUI.onCreate(android.os.Bundle):void, file: classes3.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 14 more
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.sight.decode.ui.VideoPlayView, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 20 more
            */
        /*
        // Method dump skipped, instructions count: 1184
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.VideoAdPlayerUI.onCreate(android.os.Bundle):void");
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        String str;
        o.c cVar;
        int i4;
        AppMethodBeat.i(99794);
        Log.i("MicroMsg.VideoPlayerUI", "onActivityResult %d", Integer.valueOf(i2));
        if (4097 == i2) {
            if (-1 == i3) {
                String stringExtra = intent.getStringExtra("Select_Conv_User");
                String stringExtra2 = intent.getStringExtra("custom_send_text");
                for (String str2 : Util.stringsToList(stringExtra.split(","))) {
                    Log.i("MicroMsg.VideoPlayerUI", "send sight to %s", str2);
                    k.b bVar = new k.b();
                    bVar.title = this.EzM;
                    bVar.type = 4;
                    if (!Util.isNullOrNil(this.ERY.Url)) {
                        bVar.url = this.ERY.Url;
                    } else {
                        bVar.url = this.ERY.MsF;
                    }
                    if (Util.isNullOrNil(this.ERY.MsI)) {
                        str = this.ERY.Msz;
                    } else {
                        str = this.ERY.MsI;
                    }
                    bVar.thumburl = str;
                    bVar.iyZ = this.ERY.MsF;
                    bVar.iza = this.ERY.ERX;
                    bVar.izb = this.EzM;
                    bVar.izd = this.izd;
                    bVar.izc = this.izc;
                    bVar.ize = this.thumbUrl;
                    bVar.izf = this.EzO;
                    bVar.izg = this.EzP;
                    bVar.ean = this.ean;
                    byte[] aW = s.aW(this.thumbPath, 0, -1);
                    Object[] objArr = new Object[1];
                    objArr[0] = Integer.valueOf(aW == null ? 0 : aW.length);
                    Log.i("MicroMsg.VideoPlayerUI", "read buf size %d", objArr);
                    if (w.a.aSz() != null) {
                        w.a.aSz().a(bVar, "", "", str2, "", aW);
                    }
                    if (this.ESa != 0) {
                        int i5 = this.EzN.DvW.DwY;
                        if (this.gVd && this.EzN.DvW.Dxc != 0) {
                            i5 += (int) (Util.ticksToNow(this.EzN.DvW.Dxc) / 1000);
                        }
                        i iVar = new i(13228, "1,3," + i5 + "," + this.ssid + "," + this.bssid + "," + Util.nowSecond() + "," + this.ERZ + "," + this.ERX, (int) Util.nowSecond());
                        g.aAi();
                        g.aAg().hqi.a(iVar, 0);
                    }
                    com.tencent.mm.plugin.messenger.a.g.eir().iF(stringExtra2, str2);
                    if (this.isAd) {
                        r.a(new SnsAdClick(0, 6, this.DsC.field_snsId, 12, 0));
                    }
                    if (this.EzR != 0) {
                        boolean Eq = ab.Eq(str2);
                        if (Eq) {
                            cVar = o.c.Chatroom;
                        } else {
                            cVar = o.c.Chat;
                        }
                        String str3 = this.EzP;
                        String str4 = this.EzO;
                        int i6 = this.EzQ;
                        int i7 = this.EzR;
                        String str5 = this.EzS;
                        String str6 = this.EzT;
                        String str7 = this.EzU;
                        long j2 = this.EzV;
                        int i8 = this.EzW;
                        int i9 = this.EzX;
                        if (Eq) {
                            i4 = v.Ie(str2);
                        } else {
                            i4 = 0;
                        }
                        o.a(cVar, str3, str4, i6, i7, str5, str6, str7, j2, i8, i9, i4);
                    }
                }
                b.r(this, getString(R.string.dzo));
            } else if (this.isAd) {
                r.a(new SnsAdClick(0, 6, this.DsC.field_snsId, 13, 0));
            }
        }
        if (4098 == i2) {
            if (this.EzR != 0) {
                o.a(o.c.Sns, this.EzP, this.EzO, this.EzQ, this.EzR, this.EzS, this.EzT, this.EzU, this.EzV, this.EzW, this.EzX, 0);
            }
            if (-1 == i3) {
                if (this.isAd) {
                    r.a(new SnsAdClick(0, 6, this.DsC.field_snsId, 15, 0));
                }
            } else if (this.isAd) {
                r.a(new SnsAdClick(0, 6, this.DsC.field_snsId, 16, 0));
            }
        }
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(99794);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        int adRecSrc;
        AppMethodBeat.i(99795);
        super.onDestroy();
        getWindow().clearFlags(128);
        if (this.EzR != 0) {
            o.a(o.a.LeaveCompleteVideo, this.EzP, this.EzO, this.EzQ, this.EzR, this.EzS, this.EzT, this.EzU, this.EzV, this.EzW, this.EzX);
        }
        if (this.isAd) {
            if (this.DsC == null) {
                adRecSrc = 0;
            } else {
                adRecSrc = this.DsC.getAdRecSrc();
            }
            if (this.DsC != null) {
                String eXr = this.EzN.eXr();
                long j2 = ((long) this.EzN.DvP) - this.EzN.jkZ;
                if (j2 < 0) {
                    Log.e("MicroMsg.VideoPlayerUI", "reportVideo minus staytime found! totaltime[%d], offscreenTime[%ld]", Integer.valueOf(this.EzN.DvP), Long.valueOf(this.EzN.jkZ));
                    j2 = (long) this.EzN.DvP;
                }
                int i2 = (int) j2;
                ADInfo adInfo = this.DsC.getAdInfo();
                String str = adInfo == null ? "" : adInfo.waidPkg;
                g.aAi();
                g.aAg().hqi.a(new com.tencent.mm.plugin.sns.ad.g.g(this.viewId, 6, this.EzN.DvP, eXr, adRecSrc, i2, i2, this.DsC.getAdSnsInfo().getTimelineRemindInfoSourceInfo(), this.DsC.getAdSnsInfo().getTimelineRemindInfoSelfInfo(), str), 0);
            }
        }
        if (this.ESa != 0) {
            int i3 = this.EzN.DvW.DwY;
            if (this.gVd && this.EzN.DvW.Dxc != 0) {
                i3 += (int) (Util.ticksToNow(this.EzN.DvW.Dxc) / 1000);
            }
            i iVar = new i(13228, "1,2," + i3 + "," + this.ssid + "," + this.bssid + "," + Util.nowSecond() + "," + this.ERZ + "," + this.ERX, (int) Util.nowSecond());
            g.aAi();
            g.aAg().hqi.a(iVar, 0);
        }
        setResult(-1, getIntent().putExtra("key_activity_browse_time", getActivityBrowseTimeMs()));
        AppMethodBeat.o(99795);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        AppMethodBeat.i(99796);
        if (this.gVd) {
            this.ERV.pause();
        }
        if (!(this.EzN == null || this.DZi == null || this.DZi.length() <= 0)) {
            this.EzN.eXs();
            Intent intent = new Intent();
            intent.putExtra("KComponentCid", this.DZi);
            intent.putExtra("KStreamVideoPlayCount", this.EzN.DvS);
            intent.putExtra("KStreamVideoPlayCompleteCount", this.EzN.DvT);
            intent.putExtra("KStreamVideoTotalPlayTimeInMs", this.EzN.DvU);
            setResult(-1, intent);
        }
        super.finish();
        AppMethodBeat.o(99796);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(99797);
        super.onPause();
        int i2 = getResources().getConfiguration().orientation;
        Log.i("MicroMsg.VideoPlayerUI", "onpause  ".concat(String.valueOf(i2)));
        ZQ(i2);
        if (this.ERV != null && this.ERV.isPlaying()) {
            this.ERV.pause();
        }
        if (this.ERV != null) {
            Log.i("MicroMsg.VideoPlayerUI", "onDetach");
            this.ERV.onDetach();
        }
        aj.faJ().DGK.remove(this);
        aj.faJ().b(this);
        if (this.EzN != null) {
            this.EzN.jkY = Util.currentTicks();
        }
        AppMethodBeat.o(99797);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(99798);
        super.onResume();
        aj.faJ().DGK.add(this);
        aj.faJ().a(this);
        if (this.EzN != null) {
            this.EzN.onResume();
        }
        AppMethodBeat.o(99798);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c5k;
    }

    @Override // com.tencent.mm.plugin.sns.model.c.a
    public final void ke(String str, String str2) {
        AppMethodBeat.i(99799);
        Log.i("MicroMsg.VideoPlayerUI", "isPlaying " + this.ERV.isPlaying());
        if (this.ERV.isPlaying()) {
            AppMethodBeat.o(99799);
            return;
        }
        this.ERV.setLoop(false);
        if (str2.equals(this.ERV.getVideoPath())) {
            this.ERV.q(this.ERV.getLastProgresstime());
            this.ERV.start();
            Log.i("MicroMsg.VideoPlayerUI", "onSightProgressstart " + str + " path: " + str2);
            AppMethodBeat.o(99799);
            return;
        }
        this.ERV.setVideoPath(str2);
        this.ERV.q(this.ERV.getLastProgresstime());
        Log.i("MicroMsg.VideoPlayerUI", "onSightProgresssetVideoPath " + str + " path: " + str2);
        AppMethodBeat.o(99799);
    }

    @Override // com.tencent.mm.plugin.sns.model.c.b
    public final void aOG(String str) {
    }

    @Override // com.tencent.mm.plugin.sns.model.c.b
    public final void ci(String str, boolean z) {
    }

    @Override // com.tencent.mm.plugin.sns.model.c.b
    public final void eZJ() {
    }

    @Override // com.tencent.mm.plugin.sns.model.c.b
    public final void cj(String str, boolean z) {
        AppMethodBeat.i(99800);
        Log.i("MicroMsg.VideoPlayerUI", "onSightFinish ".concat(String.valueOf(str)));
        this.ERV.setIsDownloading(false);
        this.ERV.setVideoPath(this.fullPath);
        this.ERV.q(this.ERV.getLastProgresstime());
        this.ERV.setLoop(false);
        if (this.isAd && !Util.isNullOrNil(str) && this.ERY != null && str.equals(this.ERY.Id) && s.YS(this.fullPath)) {
            this.EzN.DvO = 1;
        }
        AppMethodBeat.o(99800);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        if (this.EzK) {
            return 0;
        }
        return 4;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(99801);
        super.onConfigurationChanged(configuration);
        VideoPlayView videoPlayView = this.ERV;
        Log.i("MicroMsg.VideoPlayView", "onConfigurationChanged " + configuration.orientation + " " + videoPlayView.Doi);
        if (videoPlayView.Doi != configuration.orientation) {
            if (configuration.orientation == 1) {
                videoPlayView.update(1);
            } else {
                videoPlayView.update(2);
            }
            videoPlayView.Doi = configuration.orientation;
            if (videoPlayView.Doi == 2) {
                videoPlayView.maskView.setVisibility(8);
            }
        }
        ZQ(configuration.orientation);
        AppMethodBeat.o(99801);
    }

    private void ZQ(int i2) {
        AppMethodBeat.i(99802);
        if (!this.isAd) {
            AppMethodBeat.o(99802);
            return;
        }
        this.EzN.XK(this.ERV.getDuration());
        this.EzN.DvW.Dxc = Util.currentTicks();
        this.EzN.DvW.Dxb = i2 == 2 ? 2 : 1;
        this.EzN.DvW.Dxa = 2;
        Log.i("MicroMsg.VideoPlayerUI", "duration  orient " + this.EzN.DvW.Dxb);
        AppMethodBeat.o(99802);
    }

    static /* synthetic */ void o(VideoAdPlayerUI videoAdPlayerUI) {
        AppMethodBeat.i(99803);
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_link", videoAdPlayerUI.EzJ);
        intent.putExtra("Ksnsupload_type", 11);
        intent.putExtra("Ksnsupload_title", videoAdPlayerUI.EzM);
        intent.putExtra("Ksnsupload_imgurl", videoAdPlayerUI.thumbUrl);
        intent.putExtra("KSnsStreamVideoTotalTime", videoAdPlayerUI.ERY.ERX);
        intent.putExtra("KSnsStreamVideoWroding", videoAdPlayerUI.izc);
        intent.putExtra("KSnsStreamVideoWebUrl", videoAdPlayerUI.izd);
        intent.putExtra("KSnsStreamVideoAduxInfo", videoAdPlayerUI.EzO);
        intent.putExtra("KSnsStreamVideoPublishId", videoAdPlayerUI.EzP);
        intent.putExtra("need_result", true);
        intent.putExtra("key_snsad_statextstr", videoAdPlayerUI.ean);
        String str = "sns_";
        if (videoAdPlayerUI.EzR == o.b.Sight.value || videoAdPlayerUI.EzR == o.b.AdUrl.value) {
            str = "sns_" + videoAdPlayerUI.EzU;
        } else if (videoAdPlayerUI.EzR == o.b.Chat.value || videoAdPlayerUI.EzR == o.b.TalkChat.value) {
            str = "msg_" + videoAdPlayerUI.EzV;
        } else if (videoAdPlayerUI.EzR == o.b.Fav.value) {
            str = "fav_" + z.aTY() + "_" + videoAdPlayerUI.EzW;
        }
        String JX = ad.JX(str);
        ad.aVe().G(JX, true).l("prePublishId", str);
        intent.putExtra("reportSessionId", JX);
        com.tencent.mm.br.c.b(videoAdPlayerUI, "sns", ".ui.SnsUploadUI", intent, 4098);
        if (videoAdPlayerUI.ESa != 0) {
            int i2 = videoAdPlayerUI.EzN.DvW.DwY;
            if (videoAdPlayerUI.gVd && videoAdPlayerUI.EzN.DvW.Dxc != 0) {
                i2 += (int) (Util.ticksToNow(videoAdPlayerUI.EzN.DvW.Dxc) / 1000);
            }
            i iVar = new i(13228, "1,4," + i2 + "," + videoAdPlayerUI.ssid + "," + videoAdPlayerUI.bssid + "," + Util.nowSecond() + "," + videoAdPlayerUI.ERZ + "," + videoAdPlayerUI.ERX, (int) Util.nowSecond());
            g.aAi();
            g.aAg().hqi.a(iVar, 0);
        }
        AppMethodBeat.o(99803);
    }

    static /* synthetic */ void p(VideoAdPlayerUI videoAdPlayerUI) {
        AppMethodBeat.i(99804);
        cz czVar = new cz();
        ((com.tencent.mm.plugin.fav.a.ad) g.af(com.tencent.mm.plugin.fav.a.ad.class)).a(czVar, videoAdPlayerUI.ERY.ERX, videoAdPlayerUI.EzM, "", videoAdPlayerUI.ERY.MsF, videoAdPlayerUI.izc, videoAdPlayerUI.izd, videoAdPlayerUI.thumbUrl, videoAdPlayerUI.thumbPath, videoAdPlayerUI.EzS, videoAdPlayerUI.EzO, videoAdPlayerUI.EzP, videoAdPlayerUI.ean);
        czVar.dFZ.activity = videoAdPlayerUI;
        czVar.dFZ.dGf = 24;
        EventCenter.instance.publish(czVar);
        if (czVar.dGa.ret == 0 && videoAdPlayerUI.EzR != 0) {
            o.a(o.c.Fav, videoAdPlayerUI.EzP, videoAdPlayerUI.EzO, videoAdPlayerUI.EzQ, videoAdPlayerUI.EzR, videoAdPlayerUI.EzS, videoAdPlayerUI.EzT, videoAdPlayerUI.EzU, videoAdPlayerUI.EzV, videoAdPlayerUI.EzW, videoAdPlayerUI.EzX, 0);
        }
        if (videoAdPlayerUI.isAd) {
            r.a(new SnsAdClick(0, 6, videoAdPlayerUI.DsC.field_snsId, 11, 0));
        }
        if (videoAdPlayerUI.ESa != 0) {
            int i2 = videoAdPlayerUI.EzN.DvW.DwY;
            if (videoAdPlayerUI.gVd && videoAdPlayerUI.EzN.DvW.Dxc != 0) {
                i2 += (int) (Util.ticksToNow(videoAdPlayerUI.EzN.DvW.Dxc) / 1000);
            }
            i iVar = new i(13228, "1,5," + i2 + "," + videoAdPlayerUI.ssid + "," + videoAdPlayerUI.bssid + "," + Util.nowSecond() + "," + videoAdPlayerUI.ERZ + "," + videoAdPlayerUI.ERX, (int) Util.nowSecond());
            g.aAi();
            g.aAg().hqi.a(iVar, 0);
        }
        AppMethodBeat.o(99804);
    }
}
