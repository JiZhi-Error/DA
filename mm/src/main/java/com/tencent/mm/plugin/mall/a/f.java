package com.tencent.mm.plugin.mall.a;

import android.util.SparseArray;
import com.tencent.kinda.framework.app.KindaConfigCacheStg;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.mall.a;
import com.tencent.mm.plugin.wallet_core.model.mall.b;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.protocal.protobuf.bsc;
import com.tencent.mm.protocal.protobuf.bsd;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.smtt.sdk.TbsListener;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class f extends q implements m {
    private i callback;
    private d rr;
    private String zjn;
    public ArrayList<MallFunction> zjo;
    public ArrayList<MallNews> zjp;
    public ArrayList<a> zjq;
    public SparseArray<String> zjr;
    public int zjs;

    public f(int i2, String str, int i3) {
        this(i2, str, (String) null, (String) null, i3);
    }

    public f(int i2, String str, String str2, String str3, String str4) {
        this(i2, str, str3, String.format("appid=%s&funcid=%s&url=%s", str2, str3, URLEncoder.encode(str4, KindaConfigCacheStg.SAVE_CHARSET).toString()), 0);
        AppMethodBeat.i(65993);
        AppMethodBeat.o(65993);
    }

    private f(int i2, String str, String str2, String str3, int i3) {
        ArrayList fSh;
        ArrayList arrayList;
        AppMethodBeat.i(65994);
        this.zjo = null;
        this.zjp = null;
        this.zjq = null;
        this.zjr = null;
        this.zjs = 0;
        this.zjs = i2;
        d.a aVar = new d.a();
        aVar.iLN = new bsc();
        aVar.iLO = new bsd();
        aVar.uri = "/cgi-bin/micromsg-bin/getpayfunctionlist";
        aVar.funcId = com.tencent.mm.plugin.appbrand.jsapi.bio.face.d.CTRL_INDEX;
        aVar.iLP = TbsListener.ErrorCode.HOST_CONTEXT_IS_NULL;
        aVar.respCmdId = 1000000227;
        this.rr = aVar.aXF();
        bsc bsc = (bsc) this.rr.iLK.iLR;
        bsc.LZf = str;
        LinkedList<dqi> linkedList = new LinkedList<>();
        if (!Util.isNullOrNil(str2)) {
            MallNews mallNews = c.fSg().Icv.get(str2);
            if (mallNews == null || Util.isNullOrNil(mallNews.dHx)) {
                arrayList = null;
            } else {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(mallNews.dHx);
                arrayList = arrayList2;
            }
            fSh = arrayList;
        } else {
            fSh = c.fSg().fSh();
        }
        if (fSh != null && fSh.size() > 0) {
            String str4 = "";
            for (String str5 : fSh) {
                dqi dqi = new dqi();
                dqi.bhy(str5);
                linkedList.add(dqi);
                str4 = str4 + "; + " + str5;
            }
            Log.d("MicroMsg.NetSceneGetPayFunctionList", "post with list : ".concat(String.valueOf(str4)));
        }
        bsc.LZh = linkedList;
        bsc.LZg = linkedList.size();
        if (Util.isNullOrNil(str3)) {
            bsc.xNU = String.format("tpa_country=%s", Integer.valueOf(i2));
        } else {
            bsc.xNU = String.format("%s&tpa_country=%s", str3, Integer.valueOf(i2));
        }
        bsc.LZi = i3;
        this.zjn = str2;
        Log.d("MicroMsg.NetSceneGetPayFunctionList", "telephonyNetIso " + str + " ExtInfo: " + bsc.xNU);
        AppMethodBeat.o(65994);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(65995);
        Log.i("MicroMsg.NetSceneGetPayFunctionList", "errCode " + i4 + ", errMsg " + str);
        if (i3 == 0 && i4 == 0) {
            bsd bsd = (bsd) ((d) sVar).iLL.iLR;
            Log.i("MicroMsg.NetSceneGetPayFunctionList", "resp.PayFunctionList wallet_regionL " + this.zjs + " " + bsd.LZj);
            try {
                if (!Util.isNullOrNil(bsd.LZj)) {
                    JSONObject jSONObject = new JSONObject(bsd.LZj);
                    String optString = jSONObject.optString("pay_func_list");
                    this.zjo = b.R(new JSONArray(optString));
                    t.fQN().b(this.zjs, optString, jSONObject.optString("global_activity_list"), jSONObject.optString("pay_banner_list"), jSONObject.optString("type_info_list"), bsd.LZl);
                    k.egL().zjD.clear();
                }
            } catch (JSONException e2) {
                Log.printErrStackTrace("MicroMsg.NetSceneGetPayFunctionList", e2, "", new Object[0]);
            }
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(65995);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return com.tencent.mm.plugin.appbrand.jsapi.bio.face.d.CTRL_INDEX;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(65996);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(65996);
        return dispatch;
    }
}
