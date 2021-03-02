package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.m;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.plugin.base.model.b;
import com.tencent.mm.plugin.base.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class bf extends bi {
    @Override // com.tencent.mm.plugin.x.a, com.tencent.mm.plugin.x.b
    public final int getType() {
        return 1;
    }

    @Override // com.tencent.mm.plugin.appbrand.bi, com.tencent.mm.plugin.x.b
    public final void k(Context context, Intent intent) {
        AppMethodBeat.i(43998);
        h.INSTANCE.idkeyStat(443, 2, 1, false);
        super.k(context, intent);
        AppMethodBeat.o(43998);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.bi
    public final void a(Context context, Intent intent, boolean z) {
        AppMethodBeat.i(43999);
        if (!z) {
            h.INSTANCE.idkeyStat(443, 3, 1, false);
            if (Build.VERSION.SDK_INT >= 26) {
                String eX = c.eX(IntentUtil.getStringExtra(intent, "id"), q.getAndroidId());
                if (!m.HF(eX)) {
                    Log.e("MiroMsg.WxaLauncherShortcutEntry", "jump to Wxa with androidId decode failed, username %s invalid , try to decode with imei", eX);
                    if (m.HF(c.ahb(IntentUtil.getStringExtra(intent, "id")))) {
                        b(context, intent, false);
                        AppMethodBeat.o(43999);
                        return;
                    }
                    Toast.makeText(context, context.getString(R.string.j5h), 1).show();
                }
            }
        }
        AppMethodBeat.o(43999);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.bi
    public final int z(Intent intent) {
        return TXLiteAVCode.EVT_CAMERA_REMOVED;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.bi
    public final void b(final Context context, Intent intent, final boolean z) {
        String ahb;
        AppMethodBeat.i(44000);
        super.b(context, intent, z);
        if (z) {
            ahb = c.eX(IntentUtil.getStringExtra(intent, "id"), q.getAndroidId());
        } else {
            ahb = c.ahb(IntentUtil.getStringExtra(intent, "id"));
        }
        final int intExtra = IntentUtil.getIntExtra(intent, "ext_info_1", 0);
        String stringExtra = IntentUtil.getStringExtra(intent, "digest");
        if (!TextUtils.isEmpty(stringExtra)) {
            try {
                final WxaAttributes Xk = ((com.tencent.mm.plugin.appbrand.service.q) g.af(com.tencent.mm.plugin.appbrand.service.q.class)).Xk(ahb);
                if (Xk == null) {
                    Log.e("MiroMsg.WxaLauncherShortcutEntry", "no such WeApp(%s)", ahb);
                    AppMethodBeat.o(44000);
                    return;
                }
                if (!stringExtra.equals(com.tencent.mm.b.g.getMessageDigest((Xk.field_nickname + Xk.field_roundedSquareIconURL + Xk.field_brandIconURL + Xk.field_bigHeadURL).getBytes()))) {
                    Log.i("MiroMsg.WxaLauncherShortcutEntry", "update shortcut for wxa(%s)", ahb);
                    if (context == null) {
                        Log.e("MicroMsg.AppBrandShortcutManager", "remove fail, context or username is null.");
                    } else if (intent == null) {
                        Log.e("MicroMsg.AppBrandShortcutManager", "remove fail, intent is null");
                    } else {
                        ch chVar = new ch();
                        chVar.dFr.username = ahb;
                        EventCenter.instance.publish(chVar);
                        if (chVar.dFs.cze == null) {
                            Log.e("MicroMsg.AppBrandShortcutManager", "no such WeApp(%s)", ahb);
                        } else {
                            String str = TextUtils.isEmpty(chVar.dFs.nickname) ? ahb : chVar.dFs.nickname;
                            Intent intent2 = new Intent("com.android.launcher.action.UNINSTALL_SHORTCUT");
                            intent2.putExtra("android.intent.extra.shortcut.NAME", str);
                            intent2.putExtra("duplicate", false);
                            intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
                            b.q(context, intent2);
                            Log.i("MicroMsg.AppBrandShortcutManager", "remove shortcut %s", ahb);
                        }
                    }
                    MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.bf.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(43997);
                            g.aAf();
                            v.a(context, new v.a(a.getUin(), new String[]{Xk.field_roundedSquareIconURL, Xk.field_brandIconURL, Xk.field_bigHeadURL}, Xk.field_nickname, Xk.field_appId, Xk.field_username), intExtra, z);
                            AppMethodBeat.o(43997);
                        }
                    }, 1000);
                }
            } catch (NullPointerException e2) {
                Log.e("MiroMsg.WxaLauncherShortcutEntry", "query attrs with username[%s], e=%s", ahb, e2);
                AppMethodBeat.o(44000);
                return;
            }
        }
        intent.putExtra("type", 0);
        intent.putExtra("id", "");
        AppMethodBeat.o(44000);
    }
}
