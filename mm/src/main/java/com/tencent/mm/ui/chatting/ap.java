package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.protocal.protobuf.ehv;
import com.tencent.mm.sdk.platformtools.Log;

public final class ap implements com.tencent.mm.plugin.newtips.a.a {
    private String PkH;
    private LinearLayout PkI = new LinearLayout(this.mContext);
    private a PkJ;
    private Context mContext;

    public interface a {
        void O(boolean z, String str);
    }

    public ap(Context context, String str, a aVar) {
        AppMethodBeat.i(232923);
        this.PkH = str;
        this.mContext = context;
        this.PkJ = aVar;
        AppMethodBeat.o(232923);
    }

    @Override // com.tencent.mm.plugin.newtips.a.a
    public final String getPath() {
        return this.PkH;
    }

    @Override // com.tencent.mm.plugin.newtips.a.a
    public final boolean qW(boolean z) {
        AppMethodBeat.i(232924);
        Log.i("MicroMsg.ShowRedDotCompoent", "menuKey:%s，show：%s", this.PkH, Boolean.valueOf(z));
        this.PkJ.O(z, this.PkH);
        AppMethodBeat.o(232924);
        return true;
    }

    @Override // com.tencent.mm.plugin.newtips.a.a
    public final boolean ehp() {
        return true;
    }

    @Override // com.tencent.mm.plugin.newtips.a.a
    public final View getRoot() {
        return this.PkI;
    }

    @Override // com.tencent.mm.plugin.newtips.a.a
    public final void a(k kVar, boolean z) {
    }

    @Override // com.tencent.mm.plugin.newtips.a.a
    public final boolean qV(boolean z) {
        return false;
    }

    @Override // com.tencent.mm.plugin.newtips.a.a
    public final boolean qX(boolean z) {
        return false;
    }

    @Override // com.tencent.mm.plugin.newtips.a.a
    public final boolean a(boolean z, ehv ehv) {
        return false;
    }

    @Override // com.tencent.mm.plugin.newtips.a.a
    public final boolean b(boolean z, ehv ehv) {
        return false;
    }

    @Override // com.tencent.mm.plugin.newtips.a.a
    public final boolean c(boolean z, ehv ehv) {
        return false;
    }

    @Override // com.tencent.mm.plugin.newtips.a.a
    public final boolean d(boolean z, ehv ehv) {
        return false;
    }
}
