package com.tencent.mm.plugin.scanner.box;

import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.scanner.box.k;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.protocal.protobuf.qt;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.HashMap;
import java.util.UUID;
import kotlin.g.b.p;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001+B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J \u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 H\u0002J&\u0010!\u001a\u0004\u0018\u00010\u00042\u0014\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040#2\u0006\u0010\u001b\u001a\u00020\u001cJ\b\u0010$\u001a\u00020%H\u0002J&\u0010&\u001a\u00020'2\u0014\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040#2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\"\u0010(\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010)\u001a\u0004\u0018\u00010*H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006,"}, hxF = {"Lcom/tencent/mm/plugin/scanner/box/ScanBoxManager;", "", "()V", "KEY_ENABLE_CANCEL_OUTSIDE", "", "KEY_ENABLE_DIALOG_SCROLL", "KEY_ENABLE_FULL_SCREEN", "KEY_ENABLE_SCROLL_RIGHT_CLOSE", "KEY_ENTER_SESSION", "KEY_FIXED_DIALOG_HEIGHT", "KEY_FIXED_DIALOG_HEIGHT_RATE", "KEY_REQ_KEY", "KEY_SCAN_SESSION", "KEY_SCAN_SOURCE", "KEY_SESSION_ID", "KEY_SHOW_AFTER_WEBVIEW_READY", "KEY_TAB_SESSION", "KEY_TEMPLATE_TYPE", "TAG", "createContext", "Lcom/tencent/mm/protocal/protobuf/BoxHomeContext;", "data", "Landroid/os/Bundle;", "createDialogView", "Lcom/tencent/mm/plugin/scanner/box/BaseBoxDialogView;", "context", "Landroid/content/Context;", "templateType", "", "doShowBoxDialog", "Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialog;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialogViewListener;", "genBoxUrl", NativeProtocol.WEB_DIALOG_PARAMS, "Ljava/util/HashMap;", "getTextScaleSize", "", "putCommonUrlParams", "", "showBoxDialog", "boxDialogOnShowListener", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogOnShowListener;", "TemplateType", "plugin-scan_release"})
public final class l {
    public static final l CDd = new l();

    static {
        AppMethodBeat.i(52133);
        AppMethodBeat.o(52133);
    }

    private l() {
    }

    public static final i a(Context context, Bundle bundle, g gVar) {
        String str;
        ScanImageOCRDialogView scanImageOCRDialogView;
        AppMethodBeat.i(240285);
        p.h(context, "context");
        p.h(bundle, "data");
        String string = bundle.getString("scan_session");
        if (string == null) {
            str = String.valueOf(System.currentTimeMillis());
        } else {
            str = string;
        }
        p.g(str, "data.getString(KEY_SCAN_…ntTimeMillis().toString()");
        k kVar = new k(str, gVar);
        Log.v("MicroMsg.ScanBoxDialogViewListenerImpl", "alvinluo onShowStart %s", kVar.dRM);
        kVar.CCP = System.currentTimeMillis();
        kVar.CCV = new k.a();
        k kVar2 = kVar;
        int i2 = bundle.getInt(MessengerShareContentUtility.TEMPLATE_TYPE, 0);
        int i3 = bundle.getInt(MessengerShareContentUtility.TEMPLATE_TYPE, 0);
        qt qtVar = new qt();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = hashMap;
        String string2 = bundle.getString("req_key");
        if (string2 == null) {
            string2 = "";
        }
        hashMap2.put("req_key", string2);
        if (i3 == 1) {
            HashMap hashMap3 = hashMap;
            String string3 = bundle.getString("enter_session");
            if (string3 == null) {
                string3 = "";
            }
            hashMap3.put("enter_session", string3);
            HashMap hashMap4 = hashMap;
            String string4 = bundle.getString("tab_session");
            if (string4 == null) {
                string4 = "";
            }
            hashMap4.put("tab_session", string4);
            HashMap hashMap5 = hashMap;
            String string5 = bundle.getString("scan_session");
            if (string5 == null) {
                string5 = "";
            }
            hashMap5.put("scan_session", string5);
            Log.d("MicroMsg.ScanBoxManager", "alvinluo showBoxDialog from scan goods, enterSession: %s, tabSession: %s, scanSession: %s", hashMap.get("enter_session"), hashMap.get("tab_session"), hashMap.get("scan_session"));
        } else if (i3 == 2) {
            hashMap.put("session_id", String.valueOf(bundle.getLong("session_id", 0)));
            hashMap.put("scene", String.valueOf(bundle.getInt("scene", 0)));
        }
        Log.i("MicroMsg.ScanBoxManager", "alvinluo showBoxDialog templateType: %s, reqKey: %s, session_id: %s", Integer.valueOf(i3), hashMap.get("req_key"), hashMap.get("session_id"));
        qtVar.KXB = UUID.randomUUID().toString();
        p.h(hashMap, NativeProtocol.WEB_DIALOG_PARAMS);
        String str2 = "";
        switch (i3) {
            case 1:
                o oVar = o.CDl;
                str2 = o.ePx();
                b(hashMap, 4);
                break;
            case 2:
                o oVar2 = o.CDl;
                str2 = o.ePy();
                b(hashMap, 8);
                break;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("file://");
        stringBuffer.append(str2);
        stringBuffer.append("?");
        stringBuffer.append(ai.toUrlParams(hashMap));
        qtVar.Url = stringBuffer.toString();
        int i4 = bundle.getInt("fixed_dialog_height", 0);
        float f2 = bundle.getFloat("fixed_dialog_height_rate", -1.0f);
        boolean z = bundle.getBoolean("enable_dialog_scroll", true);
        boolean z2 = bundle.getBoolean("enable_cancel_outside", true);
        boolean z3 = bundle.getBoolean("show_after_webview_ready", false);
        boolean z4 = bundle.getBoolean("enable_full_screen", true);
        boolean z5 = bundle.getBoolean("enable_scroll_right_close", false);
        Log.i("MicroMsg.ScanBoxManager", "alvinluo showBoxDialog fixedDialogHeight: %d, fixedDialogHeightRate: %s, enableDialogScroll: %b", Integer.valueOf(i4), Float.valueOf(f2), Boolean.valueOf(z));
        if (i2 == 1) {
            scanImageOCRDialogView = new ScanGoodsDialogView(context);
        } else if (i2 == 2) {
            scanImageOCRDialogView = new ScanImageOCRDialogView(context);
        } else {
            Log.e("MicroMsg.ScanBoxManager", "alvinluo createDialogView templateType : %s not support", Integer.valueOf(i2));
            scanImageOCRDialogView = null;
        }
        i iVar = new i(context, qtVar, scanImageOCRDialogView, kVar2);
        if (i4 > 0) {
            iVar.ePo();
            iVar.CBH = i4;
            BaseBoxDialogView baseBoxDialogView = iVar.CCE;
            if (baseBoxDialogView != null) {
                baseBoxDialogView.setFixDialogHeight(i4);
            }
        } else if (f2 > 0.0f) {
            iVar.ePo();
            iVar.CBJ = f2;
            BaseBoxDialogView baseBoxDialogView2 = iVar.CCE;
            if (baseBoxDialogView2 != null) {
                baseBoxDialogView2.setFixDialogHeightRate(f2);
            }
        }
        iVar.CCH = z;
        BaseBoxDialogView baseBoxDialogView3 = iVar.CCE;
        if (baseBoxDialogView3 != null) {
            baseBoxDialogView3.setEnableDialogScroll(z);
        }
        iVar.CCI = z2;
        BaseBoxDialogView baseBoxDialogView4 = iVar.CCE;
        if (baseBoxDialogView4 != null) {
            baseBoxDialogView4.setCanceledOnTouchOutside(z2);
        }
        iVar.CCJ = z3;
        iVar.CAK = z4;
        iVar.CAL = z5;
        BaseBoxDialogView baseBoxDialogView5 = iVar.CCE;
        if (baseBoxDialogView5 != null) {
            baseBoxDialogView5.setEnableScrollRightClose(z5);
        }
        iVar.show();
        p.h(bundle, "data");
        if (iVar.CCC != null) {
            q.av(bundle);
        }
        Window window = iVar.getWindow();
        if (window != null) {
            window.setLayout(-1, -1);
        }
        AppMethodBeat.o(240285);
        return iVar;
    }

    private static void b(HashMap<String, String> hashMap, int i2) {
        AppMethodBeat.i(240286);
        hashMap.put("lang", LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()));
        hashMap.put(TPDownloadProxyEnum.USER_PLATFORM, "android");
        hashMap.put("version", String.valueOf(ai.aft(i2)));
        hashMap.put(DownloadInfo.NETTYPE, ai.ait());
        hashMap.put("isClientLoading", "1");
        hashMap.put("wechatVersion", BuildInfo.CLIENT_VERSION);
        hashMap.put("fontRatio", String.valueOf(ePv()));
        AppMethodBeat.o(240286);
    }

    private static float ePv() {
        float f2 = 1.0f;
        AppMethodBeat.i(240287);
        float ez = a.ez(MMApplicationContext.getContext());
        if (ez == 1.0f || ez == 0.8f || ez == 1.1f || ez == 1.12f || ez == 1.125f || ez == 1.4f || ez == 1.55f || ez == 1.65f) {
            f2 = ez;
        }
        AppMethodBeat.o(240287);
        return f2;
    }
}
