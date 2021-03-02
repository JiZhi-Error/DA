package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ag.m;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.base.model.c;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.x.a;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashSet;
import java.util.Set;

public abstract class bi extends a {
    /* access modifiers changed from: protected */
    public abstract int z(Intent intent);

    @Override // com.tencent.mm.plugin.x.b
    public void k(Context context, Intent intent) {
        boolean z = Build.VERSION.SDK_INT >= 26;
        if (!b(intent, z)) {
            a(context, intent, false);
            return;
        }
        a(context, intent, true);
        b(context, intent, z);
    }

    /* access modifiers changed from: protected */
    public void a(Context context, Intent intent, boolean z) {
    }

    /* access modifiers changed from: protected */
    public void b(Context context, Intent intent, boolean z) {
        String ahb;
        String ahb2;
        if (z) {
            ahb = c.eX(IntentUtil.getStringExtra(intent, "id"), q.getAndroidId());
            ahb2 = c.eX(IntentUtil.getStringExtra(intent, "ext_info"), q.getAndroidId());
        } else {
            ahb = c.ahb(IntentUtil.getStringExtra(intent, "id"));
            ahb2 = c.ahb(IntentUtil.getStringExtra(intent, "ext_info"));
        }
        int intExtra = IntentUtil.getIntExtra(intent, "ext_info_1", 0);
        wq wqVar = new wq();
        wqVar.ecI.appId = ahb2;
        wqVar.ecI.userName = ahb;
        wqVar.ecI.ecL = intExtra;
        wqVar.ecI.scene = z(intent);
        wqVar.ecI.ecP = true;
        wqVar.ecI.context = context;
        wqVar.ecI.ecQ = false;
        EventCenter.instance.publish(wqVar);
        if (wqVar.ecJ.edc) {
            Log.i("MiroMsg.WxaShortcutEntry", "open wxa with id : %s", ahb);
        } else if (intExtra == 1) {
            Toast.makeText(context, (int) R.string.ju, 0).show();
        } else if (intExtra == 2) {
            Toast.makeText(context, (int) R.string.nz, 0).show();
        }
    }

    /* access modifiers changed from: protected */
    public boolean b(Intent intent, boolean z) {
        String ahb;
        String ahb2;
        if (z) {
            ahb = c.eX(IntentUtil.getStringExtra(intent, "id"), q.getAndroidId());
            ahb2 = c.eX(IntentUtil.getStringExtra(intent, "ext_info"), q.getAndroidId());
        } else {
            ahb = c.ahb(IntentUtil.getStringExtra(intent, "id"));
            ahb2 = c.ahb(IntentUtil.getStringExtra(intent, "ext_info"));
        }
        String stringExtra = IntentUtil.getStringExtra(intent, "token");
        int intExtra = IntentUtil.getIntExtra(intent, "ext_info_1", 0);
        if (TextUtils.isEmpty(ahb) || TextUtils.isEmpty(ahb2) || TextUtils.isEmpty(stringExtra)) {
            Log.e("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, username or appId or token is null or nil.");
            return false;
        } else if (!m.HF(ahb)) {
            Log.e("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, username %s invalid ", ahb);
            e.INSTANCE.idkeyStat(647, 1, 1, false);
            return false;
        } else {
            StringBuilder sb = new StringBuilder();
            g.aAf();
            if (!stringExtra.equals(c.eY(ahb2, sb.append(com.tencent.mm.kernel.a.getUin()).toString()))) {
                SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("app_brand_global_sp", 0);
                if (sharedPreferences == null) {
                    Log.w("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, sp is null.");
                    return false;
                }
                Set<String> stringSet = sharedPreferences.getStringSet("uin_set", new HashSet());
                if (stringSet == null || stringSet.isEmpty()) {
                    Log.w("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, uin set is null or nil.");
                    return false;
                }
                HashSet hashSet = new HashSet();
                for (String str : stringSet) {
                    hashSet.add(c.eY(ahb2, str));
                }
                if (!hashSet.contains(stringExtra)) {
                    Log.e("MiroMsg.WxaShortcutEntry", "jump to Wxa failed, illegal token(%s).", stringExtra);
                    return false;
                }
            }
            if (CrashReportFactory.hasDebuger() || intExtra != 1) {
                return true;
            }
            Log.i("MiroMsg.WxaShortcutEntry", "can not open testing WeApp in released WeChat.");
            return false;
        }
    }
}
