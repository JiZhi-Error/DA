package com.tencent.mm.plugin.appbrand.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.multitask.a.a;
import com.tencent.mm.plugin.multitask.b.c;
import com.tencent.mm.protocal.protobuf.er;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class b extends c {
    private q kGW;

    public b(a aVar, q qVar) {
        super(aVar);
        AppMethodBeat.i(227203);
        this.kGW = qVar;
        Log.i("MicroMsg.AppBrandMultiTaskHelper", "create, runtime:%s", Integer.valueOf(qVar.hashCode()));
        AppMethodBeat.o(227203);
    }

    @Override // com.tencent.mm.plugin.multitask.b.a, com.tencent.mm.plugin.multitask.b.b
    public final void ic(boolean z) {
        AppMethodBeat.i(227204);
        bPu();
        super.ic(z);
        AppMethodBeat.o(227204);
    }

    @Override // com.tencent.mm.plugin.multitask.b.a, com.tencent.mm.plugin.multitask.b.c
    public final boolean O(int i2, boolean z) {
        AppMethodBeat.i(227205);
        bPu();
        boolean O = super.O(i2, z);
        AppMethodBeat.o(227205);
        return O;
    }

    @Override // com.tencent.mm.plugin.multitask.b.a
    public final boolean bPp() {
        return false;
    }

    @Override // com.tencent.mm.plugin.multitask.b.a
    public final boolean bPs() {
        return true;
    }

    @Override // com.tencent.mm.plugin.multitask.b.a
    public final boolean bPt() {
        return true;
    }

    @Override // com.tencent.mm.plugin.multitask.b.a
    public final boolean bPr() {
        return false;
    }

    @Override // com.tencent.mm.plugin.multitask.b.a, com.tencent.mm.plugin.multitask.b.b
    public final void bPu() {
        AppMethodBeat.i(227206);
        try {
            AppBrandInitConfigWC bsC = this.kGW.bsC();
            if (bsC != null) {
                this.Abp.erh().MwR = bsC.iconUrl;
                this.Abp.erh().nickname = bsC.brandName;
                if (this.kGW.kAq.eix == 1) {
                    this.Abp.erh().tag = MMApplicationContext.getContext().getString(R.string.id);
                } else if (this.kGW.kAq.eix == 2) {
                    this.Abp.erh().tag = MMApplicationContext.getContext().getString(R.string.ic);
                } else {
                    this.Abp.erh().tag = null;
                }
                er erVar = new er();
                erVar.appId = bsC.appId;
                erVar.username = bsC.username;
                erVar.iOo = bsC.eix;
                erVar.cyo = bsC.cyo;
                Log.i("MicroMsg.AppBrandMultiTaskHelper", "fillMultiTaskInfo username:%s,appid:%s,versionType:%d", erVar.username, erVar.appId, Integer.valueOf(erVar.iOo));
                this.Abp.field_data = erVar.toByteArray();
            }
            AppMethodBeat.o(227206);
        } catch (Exception e2) {
            Log.e("MicroMsg.AppBrandMultiTaskHelper", "onMenuMultiTaskSelected error, ex = " + e2.getMessage());
            AppMethodBeat.o(227206);
        }
    }

    @Override // com.tencent.mm.plugin.multitask.b.a, com.tencent.mm.plugin.multitask.b.c
    public final void G(int i2, String str) {
        AppMethodBeat.i(227207);
        super.G(i2, str);
        AppMethodBeat.o(227207);
    }

    @Override // com.tencent.mm.plugin.multitask.b.a, com.tencent.mm.plugin.multitask.b.b
    public final boolean bPq() {
        AppMethodBeat.i(227208);
        if (!this.kGW.bsC().ldN) {
            AppMethodBeat.o(227208);
            return true;
        }
        AppMethodBeat.o(227208);
        return false;
    }
}
