package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;

public class TbsMediaFactory {

    /* renamed from: a  reason: collision with root package name */
    private Context f1833a = null;

    /* renamed from: b  reason: collision with root package name */
    private TbsWizard f1834b = null;

    /* renamed from: c  reason: collision with root package name */
    private DexLoader f1835c = null;

    public TbsMediaFactory(Context context) {
        AppMethodBeat.i(54529);
        this.f1833a = context.getApplicationContext();
        a();
        AppMethodBeat.o(54529);
    }

    private void a() {
        AppMethodBeat.i(54530);
        if (this.f1833a == null) {
            AppMethodBeat.o(54530);
            return;
        }
        if (this.f1834b == null) {
            g.a(true).a(this.f1833a, false, false, null);
            this.f1834b = g.a(true).a();
            if (this.f1834b != null) {
                this.f1835c = this.f1834b.dexLoader();
            }
        }
        if (this.f1834b == null || this.f1835c == null) {
            RuntimeException runtimeException = new RuntimeException("tbs core dex(s) load failure !!!");
            AppMethodBeat.o(54530);
            throw runtimeException;
        }
        AppMethodBeat.o(54530);
    }

    public TbsMediaPlayer createPlayer() {
        AppMethodBeat.i(54531);
        if (this.f1834b == null || this.f1835c == null) {
            RuntimeException runtimeException = new RuntimeException("tbs core dex(s) did not loaded !!!");
            AppMethodBeat.o(54531);
            throw runtimeException;
        }
        TbsMediaPlayer tbsMediaPlayer = new TbsMediaPlayer(new r(this.f1835c, this.f1833a));
        AppMethodBeat.o(54531);
        return tbsMediaPlayer;
    }
}
