package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.plugin.finder.cgi.bu;
import com.tencent.mm.plugin.finder.live.model.cgi.s;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.protocal.protobuf.aqb;
import com.tencent.mm.protocal.protobuf.avh;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.protocal.protobuf.axk;
import com.tencent.mm.protocal.protobuf.axq;
import com.tencent.mm.protocal.protobuf.bed;
import com.tencent.mm.protocal.protobuf.bel;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.base.u;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.t;
import kotlin.x;

public final class g implements i {
    public static final a vKX = new a((byte) 0);
    public final String TAG = "Finder.LivePostHelper";
    public final Activity dKq;
    public int ks = -1;
    public bed udb;
    public awt ufj;
    private long ulj;
    public aqb vKV;
    public kotlin.g.a.a<x> vKW;

    static {
        AppMethodBeat.i(252484);
        AppMethodBeat.o(252484);
    }

    public g(Activity activity) {
        p.h(activity, "context");
        AppMethodBeat.i(252483);
        this.dKq = activity;
        AppMethodBeat.o(252483);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void a(bed bed) {
        bel bel;
        AppMethodBeat.i(252476);
        Log.i(this.TAG, "setPrepareResp wxaShopInfo appId:" + ((bed == null || (bel = bed.wxaShopInfo) == null) ? null : bel.appId) + ',');
        this.udb = bed;
        AppMethodBeat.o(252476);
    }

    public final void dzD() {
        AppMethodBeat.i(252477);
        Log.i(this.TAG, "prepareLive");
        this.ulj = System.currentTimeMillis();
        this.ks = -1;
        am amVar = am.tuw;
        new s(am.cXY(), z.aUg(), this.ulj, new b(this), (byte) 0).aYI();
        AppMethodBeat.o(252477);
    }

    public static final class b implements s.a {
        final /* synthetic */ g vKY;

        b(g gVar) {
            this.vKY = gVar;
        }

        @Override // com.tencent.mm.plugin.finder.live.model.cgi.s.a
        public final void a(int i2, int i3, String str, long j2, aqb aqb) {
            AppMethodBeat.i(252475);
            p.h(aqb, "resp");
            if (this.vKY.ulj != j2) {
                Log.i(this.vKY.TAG, "result errCode:" + i3 + ",errMsg:" + str + ",errType:" + i2 + ",requestId:" + this.vKY.ulj + ",scene.requestId:" + j2);
                AppMethodBeat.o(252475);
            } else if (i2 == 0 && i3 == 0) {
                this.vKY.vKV = aqb;
                this.vKY.ufj = aqb.live_notice_info;
                kotlin.g.a.a<x> aVar = this.vKY.vKW;
                if (aVar != null) {
                    aVar.invoke();
                    AppMethodBeat.o(252475);
                    return;
                }
                AppMethodBeat.o(252475);
            } else {
                this.vKY.ufj = null;
                kotlin.g.a.a<x> aVar2 = this.vKY.vKW;
                if (aVar2 != null) {
                    aVar2.invoke();
                    AppMethodBeat.o(252475);
                    return;
                }
                AppMethodBeat.o(252475);
            }
        }
    }

    public final void dzE() {
        this.ulj = 0;
        this.ks = -1;
        this.vKV = null;
    }

    public final void b(aqb aqb) {
        AppMethodBeat.i(252478);
        e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        Object obj = aAh.azQ().get(ar.a.USERINFO_FINDER_LIVE_VERIFY_BOOLEAN_SYNC, Boolean.FALSE);
        if (obj == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.Boolean");
            AppMethodBeat.o(252478);
            throw tVar;
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        Log.i(this.TAG, "gotoLive isVerify:".concat(String.valueOf(booleanValue)));
        if (booleanValue) {
            c(aqb);
            AppMethodBeat.o(252478);
            return;
        }
        Log.i(this.TAG, "liveVerify");
        com.tencent.mm.kernel.g.azz().a(5231, this);
        com.tencent.mm.kernel.g.azz().b(new bu().d(this.dKq, this.dKq.getResources().getString(R.string.dbf), 1000));
        AppMethodBeat.o(252478);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(252479);
        Log.i(this.TAG, "scene:" + (qVar != null ? Integer.valueOf(qVar.getType()) : null) + " result errCode:" + i3 + ",errMsg:" + str + ",errType:" + i2);
        if (qVar instanceof bu) {
            com.tencent.mm.kernel.g.azz().b(5231, this);
            if ((i2 == 0 && i3 == 0) || i3 == -200008) {
                axq cYK = ((bu) qVar).cYK();
                Log.i(this.TAG, "prepareLive,is verify:" + cYK.sPX);
                if (cYK.sPX) {
                    c(this.vKV);
                    AppMethodBeat.o(252479);
                    return;
                } else if (!Util.isNullOrNil(cYK.HIt)) {
                    String str2 = cYK.HIt;
                    if (str2 == null) {
                        str2 = "";
                    }
                    Log.i(this.TAG, "gotoFaceVerify ".concat(String.valueOf(str2)));
                    Intent intent = new Intent();
                    intent.putExtra("LIVE_HELP_TYPE", 1);
                    intent.putExtra("FACE_VERIFY_URL", str2);
                    intent.setClass(this.dKq, FinderLivePostHelperUI.class);
                    this.dKq.startActivityForResult(intent, 10000);
                    AppMethodBeat.o(252479);
                    return;
                } else {
                    u.makeText(this.dKq, this.dKq.getResources().getString(R.string.cxt), 0).show();
                    Log.e(this.TAG, "prepareLive,realnameUrl is empty:" + cYK.HIt);
                    AppMethodBeat.o(252479);
                    return;
                }
            } else {
                switch (i3) {
                    case -200018:
                    case -200012:
                        Lr(2);
                        AppMethodBeat.o(252479);
                        return;
                    case -200017:
                    case -200016:
                    case -200015:
                    case -200014:
                    case -200013:
                    default:
                        u.makeText(this.dKq, this.dKq.getResources().getString(R.string.cs1), 0).show();
                        break;
                    case -200011:
                        Lr(3);
                        AppMethodBeat.o(252479);
                        return;
                    case -200010:
                        u.makeText(this.dKq, this.dKq.getResources().getString(R.string.cqt), 0).show();
                        AppMethodBeat.o(252479);
                        return;
                    case -200009:
                        u.makeText(this.dKq, this.dKq.getResources().getString(R.string.cqx), 0).show();
                        AppMethodBeat.o(252479);
                        return;
                }
            }
        }
        AppMethodBeat.o(252479);
    }

    public final void c(aqb aqb) {
        Integer num;
        LinkedList<avh> linkedList;
        LinkedList<axk> linkedList2;
        bel bel;
        bel bel2;
        Integer num2 = null;
        AppMethodBeat.i(252480);
        Log.i(this.TAG, "checkLivePermission resp".concat(String.valueOf(aqb)));
        boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(this.dKq, "android.permission.CAMERA", 16, "", "");
        Log.i(this.TAG, "check camera:".concat(String.valueOf(a2)));
        if (!a2) {
            Log.i(this.TAG, "check camera stack:" + Util.getStack());
            AppMethodBeat.o(252480);
            return;
        }
        boolean a3 = com.tencent.mm.pluginsdk.permission.b.a(this.dKq, "android.permission.RECORD_AUDIO", 80, "", "");
        Log.i(this.TAG, "check micro:".concat(String.valueOf(a3)));
        if (!a3) {
            Log.i(this.TAG, "check micro:" + Util.getStack());
            AppMethodBeat.o(252480);
            return;
        }
        m mVar = m.vVH;
        bed bed = this.udb;
        int i2 = bed != null ? bed.LNW : 0;
        bed bed2 = this.udb;
        String str = (bed2 == null || (bel2 = bed2.wxaShopInfo) == null) ? null : bel2.appId;
        bed bed3 = this.udb;
        boolean z = m.z(i2, str, (bed3 == null || (bel = bed3.wxaShopInfo) == null) ? null : bel.LOg);
        String str2 = this.TAG;
        StringBuilder append = new StringBuilder("bindShop:").append(z).append(", full_tag_info:");
        if (aqb == null || (linkedList2 = aqb.LBV) == null) {
            num = null;
        } else {
            num = Integer.valueOf(linkedList2.size());
        }
        StringBuilder append2 = append.append(num).append(",visibility_file_list size:");
        if (!(aqb == null || (linkedList = aqb.LBX) == null)) {
            num2 = Integer.valueOf(linkedList.size());
        }
        Log.i(str2, append2.append(num2).toString());
        com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
        com.tencent.mm.plugin.finder.utils.a.a(this.dKq, z, aqb);
        AppMethodBeat.o(252480);
    }

    public static /* synthetic */ void a(g gVar) {
        AppMethodBeat.i(252482);
        gVar.Lr(2);
        AppMethodBeat.o(252482);
    }

    private final void Lr(int i2) {
        AppMethodBeat.i(252481);
        Log.i(this.TAG, "showErrPage type:".concat(String.valueOf(i2)));
        Intent intent = new Intent();
        intent.putExtra("LIVE_HELP_TYPE", i2);
        intent.setClass(this.dKq, FinderLivePostHelperUI.class);
        this.dKq.startActivityForResult(intent, 10001);
        AppMethodBeat.o(252481);
    }
}
