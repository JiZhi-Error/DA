package com.tencent.mm.plugin.brandservice.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.ap;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.ui.BizSearchDetailPageUI;
import com.tencent.mm.protocal.protobuf.chl;
import com.tencent.mm.protocal.protobuf.ru;
import com.tencent.mm.sdk.platformtools.Log;

public final class e {
    public static chl clJ() {
        AppMethodBeat.i(5569);
        try {
            g.aAi();
            String str = (String) g.aAh().azQ().get(67591, (Object) null);
            if (str != null) {
                chl chl = new chl();
                String[] split = str.split(",");
                chl.LuT = Integer.valueOf(split[0]).intValue();
                chl.LuW = Integer.valueOf(split[1]).intValue();
                chl.LbD = ((float) Integer.valueOf(split[2]).intValue()) / 1000000.0f;
                chl.LbC = ((float) Integer.valueOf(split[3]).intValue()) / 1000000.0f;
                Log.i("MicroMsg.BrandService.BrandServiceLogic", "lbs location is not null, %f, %f", Float.valueOf(chl.LbD), Float.valueOf(chl.LbC));
                AppMethodBeat.o(5569);
                return chl;
            }
            Log.i("MicroMsg.BrandService.BrandServiceLogic", "lbs location is null, lbsContent is null!");
            AppMethodBeat.o(5569);
            return null;
        } catch (Exception e2) {
            Log.i("MicroMsg.BrandService.BrandServiceLogic", "lbs location is null, reason %s", e2.getMessage());
            AppMethodBeat.o(5569);
            return null;
        }
    }

    public static class a implements i {
        private Context context;
        private String dDv;
        private long dDw;
        private boolean dDx;
        private int fromScene;
        private int offset;
        private ap pnn;
        private String title;

        public a(Context context2, String str, long j2, int i2, int i3, String str2, boolean z, ap apVar) {
            this.context = context2;
            this.dDv = str;
            this.dDw = j2;
            this.offset = i2;
            this.fromScene = i3;
            this.title = str2;
            this.dDx = z;
            this.pnn = apVar;
        }

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            AppMethodBeat.i(5567);
            Log.i("MicroMsg.BrandService.BrandServiceLogic", "errType (%d) , errCode (%d) , errMsg (errMsg)", Integer.valueOf(i2), Integer.valueOf(i3), str);
            if (i2 != 0 || i3 != 0) {
                kk(false);
                AppMethodBeat.o(5567);
            } else if (qVar == null) {
                Log.e("MicroMsg.BrandService.BrandServiceLogic", "scene is null.");
                kk(false);
                AppMethodBeat.o(5567);
            } else if (qVar.getType() != 1071) {
                Log.i("MicroMsg.BrandService.BrandServiceLogic", "The NetScene is not a instanceof BizSearchDetailPage.");
                AppMethodBeat.o(5567);
            } else {
                Log.i("MicroMsg.BrandService.BrandServiceLogic", "BizSearchDetailPage.");
                ru clR = ((l) qVar).clR();
                if (clR == null || clR.xKD == null) {
                    Log.e("MicroMsg.BrandService.BrandServiceLogic", "response or BusinessContent or itemList is null.");
                    kk(false);
                    AppMethodBeat.o(5567);
                    return;
                }
                Log.d("MicroMsg.BrandService.BrandServiceLogic", "searchId : %s.", clR.KZj);
                Intent intent = new Intent(this.context, BizSearchDetailPageUI.class);
                intent.putExtra("addContactScene", 35);
                intent.putExtra("fromScene", this.fromScene);
                intent.putExtra("keyword", this.dDv);
                intent.putExtra("businessType", this.dDw);
                intent.putExtra("offset", this.offset);
                intent.putExtra("title", this.title);
                intent.putExtra("showEditText", this.dDx);
                try {
                    intent.putExtra("result", clR.toByteArray());
                    if (!(this.context instanceof Activity)) {
                        intent.addFlags(268435456);
                    }
                    kk(true);
                } catch (Exception e2) {
                    kk(false);
                    Log.printErrStackTrace("MicroMsg.BrandService.BrandServiceLogic", e2, "", new Object[0]);
                } finally {
                    AppMethodBeat.o(5567);
                }
            }
        }

        private void kk(boolean z) {
            AppMethodBeat.i(5568);
            g.azz().b(1071, this);
            if (!(this.pnn == null || this.pnn.dDt.dDy == null)) {
                this.pnn.dDu.dDz = z;
                this.pnn.dDt.dDy.run();
            }
            AppMethodBeat.o(5568);
        }
    }
}
