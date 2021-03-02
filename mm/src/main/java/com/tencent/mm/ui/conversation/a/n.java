package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ap.a;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.OutputStream;
import java.util.List;

public final class n extends b implements View.OnClickListener {
    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final int getLayoutId() {
        return R.layout.b55;
    }

    public final void onClick(View view) {
        AppMethodBeat.i(38827);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        a.b("com/tencent/mm/ui/conversation/banner/MsgDelayTipsBanner", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        kv((Context) this.Kgr.get());
        g.aAi();
        g.aAh().azQ().set(ar.a.USERINFO_SHOW_MSG_DELAY_BOOLEAN_SYNC, Boolean.FALSE);
        if (this.view != null) {
            this.view.setVisibility(8);
        }
        a.a(this, "com/tencent/mm/ui/conversation/banner/MsgDelayTipsBanner", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(38827);
    }

    private static int gWk() {
        int i2;
        AppMethodBeat.i(38828);
        if (Build.VERSION.SDK_INT < 23) {
            AppMethodBeat.o(38828);
            return 1;
        }
        PowerManager powerManager = (PowerManager) MMApplicationContext.getContext().getSystemService("power");
        try {
            boolean isIgnoringBatteryOptimizations = powerManager.isIgnoringBatteryOptimizations(MMApplicationContext.getContext().getPackageName());
            Log.i("MicroMsg.MsgDelayTipsBanner", "[oneliang]app is ignore:".concat(String.valueOf(isIgnoringBatteryOptimizations)));
            Log.i("MicroMsg.MsgDelayTipsBanner", "[oneliang]is device idle mode:" + powerManager.isDeviceIdleMode());
            if (!isIgnoringBatteryOptimizations) {
                i2 = 2;
            } else {
                i2 = 3;
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.MsgDelayTipsBanner", "[oneliang]ignoring battery optimizations check failure.use another way.");
            i2 = 3;
        }
        AppMethodBeat.o(38828);
        return i2;
    }

    private static int gWl() {
        AppMethodBeat.i(38829);
        String str = Build.BRAND;
        if (str == null) {
            AppMethodBeat.o(38829);
            return R.string.f44;
        } else if (str.toLowerCase().startsWith("samsung")) {
            AppMethodBeat.o(38829);
            return R.string.f45;
        } else if (!str.toLowerCase().equalsIgnoreCase("huawei")) {
            AppMethodBeat.o(38829);
            return R.string.f44;
        } else if (Build.VERSION.SDK_INT == 21 || Build.VERSION.SDK_INT == 22 || Build.VERSION.SDK_INT == 23) {
            AppMethodBeat.o(38829);
            return R.string.f42;
        } else if (Build.VERSION.SDK_INT == 24) {
            AppMethodBeat.o(38829);
            return R.string.f43;
        } else {
            AppMethodBeat.o(38829);
            return R.string.f44;
        }
    }

    public static void kv(Context context) {
        AppMethodBeat.i(38830);
        if (context == null) {
            AppMethodBeat.o(38830);
            return;
        }
        switch (gWk()) {
            case 1:
            case 3:
                int gWl = gWl();
                if (gWl > 0) {
                    h.d(context, context.getString(gWl), "", new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.ui.conversation.a.n.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(38825);
                            Log.i("MicroMsg.MsgDelayTipsBanner", "[oneliang]yes");
                            if (dialogInterface != null) {
                                dialogInterface.dismiss();
                            }
                            AppMethodBeat.o(38825);
                        }
                    });
                    AppMethodBeat.o(38830);
                    return;
                }
                Log.e("MicroMsg.MsgDelayTipsBanner", "[oneliang]impossible......");
                AppMethodBeat.o(38830);
                return;
            case 2:
                Log.i("MicroMsg.MsgDelayTipsBanner", "[oneliang]need to add ignore");
                Intent data = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS").setData(Uri.parse("package:" + MMApplicationContext.getContext().getPackageName()));
                data.setFlags(268435456);
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(data);
                a.a(context, bl.axQ(), "com/tencent/mm/ui/conversation/banner/MsgDelayTipsBanner", "showTips", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                a.a(context, "com/tencent/mm/ui/conversation/banner/MsgDelayTipsBanner", "showTips", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                break;
        }
        AppMethodBeat.o(38830);
    }

    public static void kw(Context context) {
        AppMethodBeat.i(38831);
        context.getString(R.string.zb);
        q a2 = h.a(context, context.getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.ui.conversation.a.n.AnonymousClass2 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(38826);
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
                AppMethodBeat.o(38826);
            }
        });
        List<a.C0258a> bbr = com.tencent.mm.ap.a.bbr();
        StringBuilder sb = new StringBuilder();
        if (bbr != null) {
            for (a.C0258a aVar : bbr) {
                sb.append(aVar.toString());
                Log.i("MicroMsg.MsgDelayTipsBanner", aVar.toString());
            }
        }
        if (a2 != null) {
            a2.dismiss();
        }
        StringBuilder sb2 = new StringBuilder();
        bg.aVF();
        String sb3 = sb2.append(c.aSJ()).append("/delayedMsg").toString();
        s.boN(sb3);
        o oVar = new o(sb3, "data.txt");
        String sb4 = sb.toString();
        if (!oVar.exists()) {
            try {
                oVar.createNewFile();
            } catch (Exception e2) {
                Log.i("MicroMsg.MsgDelayTipsBanner", "create new file exception:" + e2.getMessage());
            }
        }
        OutputStream outputStream = null;
        try {
            outputStream = s.d(oVar, false);
            outputStream.write((sb4 + "\n").getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET));
            outputStream.flush();
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e3) {
                    Log.i("MicroMsg.MsgDelayTipsBanner", "close exception:" + e3.getMessage());
                }
            }
        } catch (Exception e4) {
            Log.i("MicroMsg.MsgDelayTipsBanner", "exception:" + e4.getMessage());
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e5) {
                    Log.i("MicroMsg.MsgDelayTipsBanner", "close exception:" + e5.getMessage());
                }
            }
        } catch (Throwable th) {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e6) {
                    Log.i("MicroMsg.MsgDelayTipsBanner", "close exception:" + e6.getMessage());
                }
            }
            AppMethodBeat.o(38831);
            throw th;
        }
        Toast.makeText(context, aa.z(oVar.her()), 1).show();
        String z = aa.z(oVar.her());
        ca caVar = new ca();
        caVar.Cy("weixin");
        caVar.setContent(z);
        caVar.setType(1);
        caVar.nv(0);
        if (caVar.field_isSend == 1) {
            caVar.setStatus(4);
        } else {
            caVar.setStatus(3);
        }
        long currentTimeMillis = System.currentTimeMillis();
        caVar.yF(currentTimeMillis);
        caVar.setCreateTime(currentTimeMillis);
        ((l) g.af(l.class)).eiy().aC(caVar);
        AppMethodBeat.o(38831);
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final boolean bYa() {
        AppMethodBeat.i(38832);
        Log.i("MicroMsg.MsgDelayTipsBanner", "refresh banner.");
        g.aAi();
        boolean z = g.aAh().azQ().getBoolean(ar.a.USERINFO_SHOW_MSG_DELAY_BOOLEAN_SYNC, false);
        Log.i("MicroMsg.MsgDelayTipsBanner", "[oneliang]need to show banner:%s", Boolean.valueOf(z));
        if (z) {
            if (this.view != null) {
                this.view.setVisibility(0);
            }
        } else if (this.view != null) {
            this.view.setVisibility(8);
        }
        boolean bYa = super.bYa();
        AppMethodBeat.o(38832);
        return bYa;
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final void destroy() {
    }
}
