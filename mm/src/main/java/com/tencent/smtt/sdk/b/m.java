package com.tencent.smtt.sdk.b;

import android.content.Context;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.interfaces.IX5CoreNetwork;
import com.tencent.smtt.export.external.interfaces.UrlRequest;
import com.tencent.smtt.sdk.TbsWizard;
import java.util.ArrayList;
import java.util.concurrent.Executor;

public class m implements IX5CoreNetwork {

    /* renamed from: a  reason: collision with root package name */
    private DexLoader f2003a;

    m(DexLoader dexLoader) {
        this.f2003a = dexLoader;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreNetwork
    public String getCoreExtraMessage() {
        return null;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreNetwork
    public void setPreConnect(String str, int i2) {
        AppMethodBeat.i(188528);
        this.f2003a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "preConnect", new Class[]{Context.class, String.class, Integer.TYPE}, null, str, Integer.valueOf(i2));
        AppMethodBeat.o(188528);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreNetwork
    public void resetSpdySession() {
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreNetwork
    public UrlRequest getX5UrlRequestProvider(String str, int i2, UrlRequest.Callback callback, Executor executor, boolean z, String str2, ArrayList<Pair<String, String>> arrayList, String str3, byte[] bArr, String str4, String str5) {
        return null;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreNetwork
    public String getCanonicalUrl(String str) {
        return null;
    }
}
