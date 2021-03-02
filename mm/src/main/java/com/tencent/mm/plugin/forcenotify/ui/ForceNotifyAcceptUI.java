package com.tencent.mm.plugin.forcenotify.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.widget.a.g;
import kotlin.g.b.p;
import kotlin.t;

public final class ForceNotifyAcceptUI extends MMBaseActivity {
    private static b UWc;
    public static final a UWd = new a((byte) 0);
    private static g uyo;
    private final int JXZ = 1234;

    public interface b {
        void b(ForceNotifyAcceptUI forceNotifyAcceptUI);

        void c(ForceNotifyAcceptUI forceNotifyAcceptUI);

        void d(ForceNotifyAcceptUI forceNotifyAcceptUI);
    }

    static {
        AppMethodBeat.i(261771);
        AppMethodBeat.o(261771);
    }

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ForceNotifyAcceptUI() {
        AppMethodBeat.i(149206);
        AppMethodBeat.o(149206);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(149203);
        super.onCreate(bundle);
        requestWindowFeature(1);
        setTheme(R.style.q6);
        cjQ();
        AppMethodBeat.o(149203);
    }

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public final void onResume() {
        AppMethodBeat.i(261766);
        super.onResume();
        aa.activateBroadcast(true);
        AppMethodBeat.o(261766);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public final void onNewIntent(Intent intent) {
        AppMethodBeat.i(261767);
        super.onNewIntent(intent);
        setIntent(intent);
        if (uyo != null) {
            g gVar = uyo;
            if (gVar != null) {
                gVar.bMo();
            }
            uyo = null;
        }
        cjQ();
        AppMethodBeat.o(261767);
    }

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public final void onPause() {
        AppMethodBeat.i(261768);
        super.onPause();
        aa.activateBroadcast(false);
        AppMethodBeat.o(261768);
    }

    private final void cjQ() {
        AppMethodBeat.i(261769);
        if (getIntent() == null) {
            AppMethodBeat.o(261769);
            return;
        }
        Intent intent = getIntent();
        p.g(intent, "intent");
        Bundle extras = intent.getExtras();
        if (extras == null) {
            AppMethodBeat.o(261769);
            return;
        }
        p.g(extras, "intent.extras ?: return");
        g gVar = new g(this, 1, 2, false);
        gVar.aE(extras.getString("title", getString(R.string.jd8)));
        View inflate = com.tencent.mm.ui.aa.jQ(this).inflate(R.layout.cfp, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.jzp);
        if (textView != null) {
            textView.setText(extras.getString("warning_content"));
        }
        gVar.setCustomView(inflate);
        String string = getString(com.tencent.mm.compatible.util.d.oD(23) ? R.string.jd2 : R.string.jd5);
        p.g(string, "getString(if (CApiLevel.…_notify_view_open_method)");
        gVar.b(getString(R.string.dh3), string);
        gVar.axv(0);
        gVar.a(new c(this, extras), new d(this, extras));
        uyo = gVar;
        gVar.dGm();
        AppMethodBeat.o(261769);
    }

    public static final class c implements g.a {
        final /* synthetic */ ForceNotifyAcceptUI UWe;
        final /* synthetic */ Bundle UWf;

        c(ForceNotifyAcceptUI forceNotifyAcceptUI, Bundle bundle) {
            this.UWe = forceNotifyAcceptUI;
            this.UWf = bundle;
        }

        @Override // com.tencent.mm.ui.widget.a.g.a
        public final void onClick() {
            AppMethodBeat.i(261764);
            b bVar = ForceNotifyAcceptUI.UWc;
            if (bVar != null) {
                bVar.d(this.UWe);
            }
            ForceNotifyAcceptUI.UWc = null;
            this.UWe.finish();
            AppMethodBeat.o(261764);
        }
    }

    public static final class d implements g.a {
        final /* synthetic */ ForceNotifyAcceptUI UWe;
        final /* synthetic */ Bundle UWf;

        d(ForceNotifyAcceptUI forceNotifyAcceptUI, Bundle bundle) {
            this.UWe = forceNotifyAcceptUI;
            this.UWf = bundle;
        }

        @Override // com.tencent.mm.ui.widget.a.g.a
        public final void onClick() {
            AppMethodBeat.i(261765);
            if (com.tencent.mm.compatible.util.d.oD(23)) {
                try {
                    Object obj = Settings.class.getField("ACTION_MANAGE_OVERLAY_PERMISSION").get(Settings.class);
                    if (obj == null) {
                        t tVar = new t("null cannot be cast to non-null type kotlin.String");
                        AppMethodBeat.o(261765);
                        throw tVar;
                    } else if (!Util.isNullOrNil((String) obj)) {
                        this.UWe.startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + MMApplicationContext.getPackageName())), this.UWe.JXZ);
                        AppMethodBeat.o(261765);
                        return;
                    }
                } catch (Exception e2) {
                }
            }
            String string = this.UWe.getString(R.string.ddf);
            p.g(string, "getString(R.string.floating_window_permission_url)");
            Intent intent = new Intent();
            intent.putExtra("rawUrl", string);
            intent.putExtra("useJs", true);
            intent.putExtra("vertical_scroll", true);
            com.tencent.mm.br.c.b(this.UWe, "webview", ".ui.tools.WebViewUI", intent);
            this.UWe.finish();
            AppMethodBeat.o(261765);
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(261770);
        if (UWc == null) {
            finish();
            AppMethodBeat.o(261770);
            return;
        }
        if (i2 != this.JXZ) {
            b bVar = UWc;
            if (bVar != null) {
                bVar.c(this);
            }
        } else if (com.tencent.mm.compatible.e.b.cx(MMApplicationContext.getContext())) {
            b bVar2 = UWc;
            if (bVar2 != null) {
                bVar2.b(this);
            }
        } else {
            b bVar3 = UWc;
            if (bVar3 != null) {
                bVar3.c(this);
            }
        }
        UWc = null;
        finish();
        AppMethodBeat.o(261770);
    }
}
