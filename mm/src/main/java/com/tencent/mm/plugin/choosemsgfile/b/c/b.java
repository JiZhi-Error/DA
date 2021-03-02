package com.tencent.mm.plugin.choosemsgfile.b.c;

import com.tencent.mm.plugin.choosemsgfile.b.b.a;
import com.tencent.mm.plugin.choosemsgfile.ui.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;

public abstract class b implements h {
    protected String goe;
    protected ArrayList<a> mDataList = new ArrayList<>();
    protected c qon;

    public b(c cVar) {
        this.qon = cVar;
        this.goe = cVar.getUserName();
    }

    public void fC(String str, String str2) {
        Log.i("MicroMsg.BaseChooseMsgFileUIController", "onCreate type:%s extension:%s", str, str2);
        c(true, str, str2);
    }

    public void onResume() {
        Log.i("MicroMsg.BaseChooseMsgFileUIController", "onResume");
    }

    public void onPause() {
        Log.i("MicroMsg.BaseChooseMsgFileUIController", "onPause");
    }

    public void onDestroy() {
        Log.i("MicroMsg.BaseChooseMsgFileUIController", "onDestroy");
    }

    /* access modifiers changed from: protected */
    public final com.tencent.mm.vending.e.b cyE() {
        if (this.qon.getContext() instanceof com.tencent.mm.vending.e.b) {
            return (com.tencent.mm.vending.e.b) this.qon.getContext();
        }
        return null;
    }
}
