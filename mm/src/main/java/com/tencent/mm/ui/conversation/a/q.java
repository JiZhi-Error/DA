package com.tencent.mm.ui.conversation.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.h;

public final class q extends b implements View.OnClickListener {
    private View jxm = getView().findViewById(R.id.a25);

    public q(Context context) {
        super(context);
        AppMethodBeat.i(163383);
        View findViewById = getView().findViewById(R.id.b4d);
        ((ImageView) getView().findViewById(R.id.g30)).setImageDrawable(ar.m((Context) this.Kgr.get(), R.raw.icons_filled_error, ((Context) this.Kgr.get()).getResources().getColor(R.color.Red)));
        ((TextView) getView().findViewById(R.id.g2y)).setText(R.string.acr);
        this.view.setOnClickListener(this);
        findViewById.setOnClickListener(this);
        AppMethodBeat.o(163383);
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final int getLayoutId() {
        return R.layout.byw;
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final void destroy() {
    }

    public final void onClick(View view) {
        AppMethodBeat.i(163384);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        a.b("com/tencent/mm/ui/conversation/banner/StoragePermissionBanner", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        Log.i("MicroMsg.StoragePermissionBanner", "onClick, %d", Integer.valueOf(view.getId()));
        Activity activity = (Activity) this.Kgr.get();
        if (view.getId() == R.id.b4d) {
            h.a(activity, activity.getString(R.string.acs), activity.getString(R.string.zb), activity.getString(R.string.fl9), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.ui.conversation.a.q.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(163382);
                    g.aAh().azQ().set(ar.a.USERINFO_STORAGE_PERMISSION_BANNER_CLOSED_FLAG_BOOLEAN_SYNC, Boolean.TRUE);
                    q.this.bYa();
                    AppMethodBeat.o(163382);
                }
            });
            e.INSTANCE.idkeyStat(462, 25, 1, true);
        } else {
            com.tencent.mm.pluginsdk.permission.b.a((Activity) this.Kgr.get(), "android.permission.WRITE_EXTERNAL_STORAGE", 33, "", "");
            e.INSTANCE.idkeyStat(462, 24, 1, true);
        }
        a.a(this, "com/tencent/mm/ui/conversation/banner/StoragePermissionBanner", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(163384);
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final boolean bYa() {
        AppMethodBeat.i(163385);
        boolean z = g.aAh().azQ().getBoolean(ar.a.USERINFO_STORAGE_PERMISSION_BANNER_CLOSED_FLAG_BOOLEAN_SYNC, false);
        boolean z2 = android.support.v4.content.b.checkSelfPermission((Activity) this.Kgr.get(), "android.permission.WRITE_EXTERNAL_STORAGE") != 0 && android.support.v4.app.a.a((Activity) this.Kgr.get(), "android.permission.WRITE_EXTERNAL_STORAGE") && !com.tencent.mm.sdcard_migrate.b.bhQ(com.tencent.mm.loader.j.b.aKI());
        if (z || !z2) {
            this.jxm.setVisibility(8);
            getView().setVisibility(8);
        } else {
            this.jxm.setVisibility(0);
            getView().setVisibility(0);
        }
        boolean bYa = super.bYa();
        AppMethodBeat.o(163385);
        return bYa;
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final int getOrder() {
        return 4;
    }
}
