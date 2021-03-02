package com.tencent.mm.plugin.appbrand.api;

import android.app.ActivityOptions;
import android.os.PersistableBundle;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import java.util.List;

public final class g {
    public String appId;
    public String cyq;
    public String cyr;
    public String dCw;
    public int iOo = 0;
    public String kHA;
    public ValueCallback<String> kHB;
    public int kHC;
    public ActivityOptions kHD;
    public String kHE;
    public AppBrandLaunchReferrer kHF;
    public String kHG;
    public String kHH;
    public AppBrandLaunchFromNotifyReferrer kHI;
    public WeAppOpenDeclarePromptBundle kHJ;
    public List<String> kHK;
    public HalfScreenConfig kHL = HalfScreenConfig.lfr;
    public boolean kHM = false;
    public i kHN = null;
    public boolean kHO = false;
    public ParcelableMultiTaskData kHP = null;
    public String kHQ = "";
    public String kHw = "";
    public d kHx = null;
    public PersistableBundle kHy;
    public int kHz;
    public int launchMode = 0;
    public int scene;
    public String username;
    public int version = 0;

    public g() {
        AppMethodBeat.i(153192);
        if (this.kHy != null) {
            this.kHy.clear();
            this.kHy = null;
        }
        this.kHy = null;
        this.scene = 1000;
        this.kHC = -100;
        this.kHD = null;
        this.kHF = null;
        this.kHJ = null;
        this.kHK = null;
        this.kHL = HalfScreenConfig.lfr;
        this.kHM = false;
        this.kHN = null;
        this.kHO = false;
        this.kHP = null;
        this.kHQ = "";
        AppMethodBeat.o(153192);
    }
}
