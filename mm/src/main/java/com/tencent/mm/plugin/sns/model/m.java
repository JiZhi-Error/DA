package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.appbrand.jsapi.p.p;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.ad.timeline.b.e;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dmo;
import com.tencent.mm.protocal.protobuf.ds;
import com.tencent.mm.protocal.protobuf.dzd;
import com.tencent.mm.protocal.protobuf.dze;
import com.tencent.mm.protocal.protobuf.dzf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.vfs.s;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class m extends q implements com.tencent.mm.network.m {
    public static List<Long> DIc = Collections.synchronizedList(new LinkedList());
    public static List<Long> DId = Collections.synchronizedList(new LinkedList());
    public i callback;
    private long ece;
    private String jpU;
    private d rr;

    static {
        AppMethodBeat.i(95578);
        AppMethodBeat.o(95578);
    }

    public static boolean Jg(long j2) {
        AppMethodBeat.i(95570);
        if (DIc.contains(Long.valueOf(j2))) {
            AppMethodBeat.o(95570);
            return false;
        }
        DIc.add(Long.valueOf(j2));
        AppMethodBeat.o(95570);
        return true;
    }

    public static boolean Jh(long j2) {
        AppMethodBeat.i(95571);
        if (DId.contains(Long.valueOf(j2))) {
            AppMethodBeat.o(95571);
            return false;
        }
        DId.add(Long.valueOf(j2));
        AppMethodBeat.o(95571);
        return true;
    }

    private static boolean Ji(long j2) {
        AppMethodBeat.i(95572);
        DId.remove(Long.valueOf(j2));
        AppMethodBeat.o(95572);
        return true;
    }

    private static boolean Jj(long j2) {
        AppMethodBeat.i(95573);
        DIc.remove(Long.valueOf(j2));
        AppMethodBeat.o(95573);
        return true;
    }

    public m(long j2, int i2, String str) {
        int i3;
        boolean z = true;
        AppMethodBeat.i(95574);
        this.ece = j2;
        d.a aVar = new d.a();
        aVar.iLN = new dze();
        aVar.iLO = new dzf();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsadobjectdetail";
        aVar.funcId = 683;
        StringBuilder sb = new StringBuilder();
        g.aAi();
        this.jpU = sb.append(g.aAh().cachePath).append("ad_detail_session").toString();
        if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
            i3 = 1;
        } else if (NetStatusUtil.is3G(MMApplicationContext.getContext())) {
            i3 = 3;
        } else if (NetStatusUtil.is4G(MMApplicationContext.getContext())) {
            i3 = 4;
        } else {
            i3 = NetStatusUtil.is2G(MMApplicationContext.getContext()) ? 2 : 0;
        }
        byte[] aW = s.aW(this.jpU, 0, -1);
        this.rr = aVar.aXF();
        ((dze) this.rr.iLK.iLR).Id = j2;
        ((dze) this.rr.iLK.iLR).MYJ = z.aC(aW);
        ((dze) this.rr.iLK.iLR).Scene = i2;
        ((dze) this.rr.iLK.iLR).MYL = i3;
        if (str != null && str.length() > 0) {
            ((dze) this.rr.iLK.iLR).MYK = z.Sv(str);
        }
        Log.i("MicroMsg.NetSceneSnsAdObjectDetial", "NetSceneSnsAdObjectDetial, snsId=" + r.Jb(j2) + ", scene=" + i2 + ", buf is null?" + (aW != null ? false : z) + ", syncBuf=" + str);
        AppMethodBeat.o(95574);
    }

    public m(long j2, dmo dmo) {
        this(j2, 2, "");
        AppMethodBeat.i(95575);
        ((dze) this.rr.iLK.iLR).KHJ = dmo;
        if (dmo == null) {
            Log.e("MicroMsg.NetSceneSnsAdObjectDetial", "NetSceneSnsAdObjectDetial, remindFriendsInfo==null");
            AppMethodBeat.o(95575);
            return;
        }
        Log.i("MicroMsg.NetSceneSnsAdObjectDetial", "NetSceneSnsAdObjectDetial, scene=2, ADGroupId64=" + dmo.MQh + ", ADGroupId=" + dmo.MQc + ", extInfo=" + (dmo.MQg != null ? z.b(dmo.MQg) : null));
        AppMethodBeat.o(95575);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(95576);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(95576);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 683;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, com.tencent.mm.network.s sVar, byte[] bArr) {
        int size;
        AppMethodBeat.i(95577);
        String Jb = r.Jb(this.ece);
        Log.i("MicroMsg.NetSceneSnsAdObjectDetial", "errType " + i3 + " errCode " + i4 + ", snsId=" + Jb);
        boolean z = false;
        if (i3 == 0 && i4 == 0) {
            z = true;
        } else if (i3 == 4 && i4 == 1) {
            byte[] a2 = z.a(((dzf) this.rr.iLL.iLR).MYJ);
            if (a2 != null) {
                s.deleteFile(this.jpU);
                s.f(this.jpU, a2, a2.length);
            }
            z = false;
        }
        if (!z) {
            this.callback.onSceneEnd(i3, i4, str, this);
            if (((dze) this.rr.iLK.iLR).Scene == 2) {
                h.INSTANCE.dN(p.CTRL_INDEX, 1);
            } else {
                h.INSTANCE.dN(p.CTRL_INDEX, 0);
            }
            Jj(this.ece);
            Ji(this.ece);
            AppMethodBeat.o(95577);
            return;
        }
        byte[] a3 = z.a(((dzf) this.rr.iLL.iLR).MYJ);
        if (a3 != null) {
            s.deleteFile(this.jpU);
            s.f(this.jpU, a3, a3.length);
        }
        dzd dzd = ((dzf) this.rr.iLL.iLR).MYM;
        SKBuiltinBuffer_t sKBuiltinBuffer_t = ((dzf) this.rr.iLL.iLR).MYN;
        int i5 = ((dze) this.rr.iLK.iLR).Scene;
        if (dzd != null) {
            Log.i("MicroMsg.NetSceneSnsAdObjectDetial", "snsdetail scene=" + i5 + ", snsXml=" + z.b(dzd.MYH.ObjectDesc));
            Log.i("MicroMsg.NetSceneSnsAdObjectDetial", "adxml=" + dzd.MYI);
            Log.i("MicroMsg.NetSceneSnsAdObjectDetial", "dynamicData=" + z.b(sKBuiltinBuffer_t));
        }
        if (dzd == null || dzd.MYH == null || dzd.MYH.DeleteFlag <= 0) {
            if (!(dzd == null || dzd.MYH == null)) {
                int size2 = dzd.MYH.CommentUserList == null ? 0 : dzd.MYH.CommentUserList.size();
                if (dzd.MYH.LikeUserList == null) {
                    size = 0;
                } else {
                    size = dzd.MYH.LikeUserList.size();
                }
                Log.i("MicroMsg.NetSceneSnsAdObjectDetial", "detail comment.size=" + size2 + " liked.size=" + size + ", likeFlag=" + dzd.MYH.LikeFlag + ", snsId=" + r.Jb(dzd.MYH.Id));
            }
            if (i5 == 2) {
                Log.i("MicroMsg.NetSceneSnsAdObjectDetial", "get atDetail %s", Jb);
                ds dsVar = ((dzf) this.rr.iLL.iLR).MYO;
                if (dsVar != null) {
                    Log.i("MicroMsg.NetSceneSnsAdObjectDetial", "recv at adInfoXml=".concat(String.valueOf(z.a(dsVar.KHH))));
                    a.b(dsVar);
                    try {
                        AdSnsInfo JE = aj.faR().JE(dsVar.KHG.MYH.Id);
                        e.a(JE.getTimeLine(), JE.getAdXml(), 3);
                        Log.i("MicroMsg.NetSceneSnsAdObjectDetial", "preDownloadAdLandingPagesForAtMsg, id=".concat(String.valueOf(Jb)));
                        j.aQk(JE.field_adxml);
                    } catch (Throwable th) {
                        Log.e("MicroMsg.NetSceneSnsAdObjectDetial", "TimeLineAdPreloadHelper->checkPreloadAdResource exp=" + th.toString());
                    }
                } else {
                    Log.e("MicroMsg.NetSceneSnsAdObjectDetial", "remindObject == null");
                }
            } else {
                a.a(dzd, sKBuiltinBuffer_t);
            }
            this.callback.onSceneEnd(i3, i4, str, this);
            Jj(this.ece);
            Ji(this.ece);
            AppMethodBeat.o(95577);
            return;
        }
        Log.i("MicroMsg.NetSceneSnsAdObjectDetial", r.Jb(dzd.MYH.Id) + " will remove by get detail ");
        Jj(this.ece);
        Ji(this.ece);
        aj.faR().delete(dzd.MYH.Id);
        aj.faT().JI(dzd.MYH.Id);
        com.tencent.mm.plugin.sns.storage.g.JH(dzd.MYH.Id);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(95577);
    }
}
