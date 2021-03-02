package com.tencent.thumbplayer.a;

import android.os.ParcelFileDescriptor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.a.e;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import java.util.HashMap;
import java.util.Map;

public final class f {
    public ParcelFileDescriptor RWn;
    public Map<String, String> RWo = new HashMap();
    ITPMediaAsset RWp;
    e RWq;
    public int mType;
    public String mUrl;

    protected f() {
        AppMethodBeat.i(188722);
        AppMethodBeat.o(188722);
    }

    /* access modifiers changed from: protected */
    public final void setUrl(String str) {
        this.mUrl = str;
        this.mType = 0;
        this.RWn = null;
    }

    /* access modifiers changed from: protected */
    public final void cn(Map<String, String> map) {
        AppMethodBeat.i(188723);
        this.RWo.clear();
        Map<String, String> map2 = this.RWo;
        if (map == null) {
            map = new HashMap<>(0);
        }
        map2.putAll(map);
        AppMethodBeat.o(188723);
    }
}
