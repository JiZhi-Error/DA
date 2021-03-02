package com.tencent.mm.plugin.offline.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.brd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.wallet_core.c.w;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a extends w {
    private String AJi;
    private String AJj;
    private i callback;
    private ArrayList<String> jBE;
    private final d rr;

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 606;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(66279);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(66279);
        return dispatch;
    }

    @Override // com.tencent.mm.wallet_core.c.w
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr, long j2) {
        AppMethodBeat.i(66280);
        if (i3 != 0) {
            Log.e("MicroMsg.NetSceneGetOffLineInfo", "Cmd : " + getType() + ", errType = " + i3 + ", errCode = " + i4 + ", errMsg = " + str);
        }
        brd brd = (brd) ((d) sVar).iLL.iLR;
        if (i3 == 0 && i4 == 0) {
            try {
                if (!TextUtils.isEmpty(brd.LYE)) {
                    JSONObject jSONObject = new JSONObject(brd.LYE);
                    int optInt = jSONObject.optInt("InitValue");
                    int optInt2 = jSONObject.optInt("FastChangedLimit");
                    this.AJj = jSONObject.optString("guide_tips");
                    com.tencent.mm.plugin.offline.c.a.Ud(optInt);
                    com.tencent.mm.plugin.offline.c.a.Ue(optInt2);
                    Log.v("MicroMsg.NetSceneGetOffLineInfo", "initValue:" + optInt + " fastChangeValue:" + optInt2);
                }
                if (!TextUtils.isEmpty(brd.LYF)) {
                    bd(new JSONObject(brd.LYF));
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.NetSceneGetOffLineInfo", e2, "", new Object[0]);
                i3 = 1000;
                i4 = 2;
                str = MMApplicationContext.getContext().getString(R.string.ibn);
            }
        }
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(66280);
    }

    private void bd(JSONObject jSONObject) {
        AppMethodBeat.i(66281);
        this.AJi = jSONObject.optString("micropay_tips");
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("head_url_list");
            if (jSONArray == null || jSONArray.length() == 0) {
                AppMethodBeat.o(66281);
                return;
            }
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                this.jBE.add((String) jSONArray.get(i2));
            }
            AppMethodBeat.o(66281);
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.NetSceneGetOffLineInfo", e2, "", new Object[0]);
            AppMethodBeat.o(66281);
        }
    }
}
