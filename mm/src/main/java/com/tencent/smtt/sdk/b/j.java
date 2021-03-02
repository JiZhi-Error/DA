package com.tencent.smtt.sdk.b;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.interfaces.IX5CoreCookieManager;
import com.tencent.smtt.sdk.TbsWizard;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class j implements IX5CoreCookieManager {

    /* renamed from: a  reason: collision with root package name */
    private DexLoader f2000a;

    j(DexLoader dexLoader) {
        this.f2000a = dexLoader;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreCookieManager
    public boolean acceptCookie() {
        AppMethodBeat.i(188420);
        Object invokeStaticMethod = this.f2000a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "cookieManager_acceptCookie", new Class[0], new Object[0]);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(188420);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
        AppMethodBeat.o(188420);
        return booleanValue;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreCookieManager
    public boolean setCookies(Map<String, String[]> map) {
        AppMethodBeat.i(188421);
        Object invokeStaticMethod = this.f2000a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "cookieManager_setCookies", new Class[]{Map.class}, map);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(188421);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
        AppMethodBeat.o(188421);
        return booleanValue;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreCookieManager
    public void setCookie(String str, String str2) {
        AppMethodBeat.i(188422);
        this.f2000a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "cookieManager_setCookie", new Class[]{String.class, String.class}, str, str2);
        AppMethodBeat.o(188422);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreCookieManager
    public void setCookie(String str, String str2, ValueCallback<Boolean> valueCallback) {
        AppMethodBeat.i(188423);
        this.f2000a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "cookieManager_setCookie", new Class[]{String.class, String.class, ValueCallback.class}, str, str2, valueCallback);
        AppMethodBeat.o(188423);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreCookieManager
    public void setAcceptCookie(boolean z) {
        AppMethodBeat.i(188424);
        this.f2000a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "cookieManager_setAcceptCookie", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        AppMethodBeat.o(188424);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreCookieManager
    public void setAcceptThirdPartyCookies(Object obj, boolean z) {
        AppMethodBeat.i(188425);
        this.f2000a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "cookieManager_setAcceptThirdPartyCookies", new Class[]{Object.class, Boolean.TYPE}, obj, Boolean.valueOf(z));
        AppMethodBeat.o(188425);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreCookieManager
    public boolean acceptThirdPartyCookies(Object obj) {
        AppMethodBeat.i(188426);
        Object invokeStaticMethod = this.f2000a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "cookieManager_acceptThirdPartyCookies", new Class[]{Object.class}, obj);
        if (invokeStaticMethod != null) {
            boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
            AppMethodBeat.o(188426);
            return booleanValue;
        }
        AppMethodBeat.o(188426);
        return true;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreCookieManager
    public void removeSessionCookie() {
        AppMethodBeat.i(188427);
        this.f2000a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "cookieManager_removeSessionCookie", new Class[0], new Object[0]);
        AppMethodBeat.o(188427);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreCookieManager
    public void removeSessionCookies(ValueCallback<Boolean> valueCallback) {
        AppMethodBeat.i(188428);
        this.f2000a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "cookieManager_removeSessionCookies", new Class[]{ValueCallback.class}, valueCallback);
        AppMethodBeat.o(188428);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreCookieManager
    public void removeAllCookie() {
        AppMethodBeat.i(188429);
        this.f2000a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "cookieManager_removeAllCookie", new Class[0], new Object[0]);
        AppMethodBeat.o(188429);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreCookieManager
    public void removeAllCookies(ValueCallback<Boolean> valueCallback) {
        AppMethodBeat.i(188430);
        this.f2000a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "cookieManager_removeAllCookies", new Class[]{ValueCallback.class}, valueCallback);
        AppMethodBeat.o(188430);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreCookieManager
    public void flush() {
        AppMethodBeat.i(188431);
        this.f2000a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "cookieManager_flush", new Class[0], new Object[0]);
        AppMethodBeat.o(188431);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreCookieManager
    public void removeExpiredCookie() {
        AppMethodBeat.i(188432);
        this.f2000a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "cookieManager_removeExpiredCookie", new Class[0], new Object[0]);
        AppMethodBeat.o(188432);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreCookieManager
    public boolean hasCookies() {
        AppMethodBeat.i(188433);
        Object invokeStaticMethod = this.f2000a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "cookieManager_hasCookies", new Class[0], new Object[0]);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(188433);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
        AppMethodBeat.o(188433);
        return booleanValue;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreCookieManager
    public void syncManagerCreateInstance(Context context) {
        AppMethodBeat.i(188434);
        this.f2000a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "cookieSyncManager_createInstance", new Class[]{Context.class}, context);
        AppMethodBeat.o(188434);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreCookieManager
    public void syncManagerSync() {
        AppMethodBeat.i(188435);
        this.f2000a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "cookieSyncManager_Sync", new Class[0], new Object[0]);
        AppMethodBeat.o(188435);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreCookieManager
    public void syncManagerStopSync() {
        AppMethodBeat.i(188436);
        this.f2000a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "cookieSyncManager_stopSync", new Class[0], new Object[0]);
        AppMethodBeat.o(188436);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreCookieManager
    public void syncManagerStartSync() {
        AppMethodBeat.i(188437);
        this.f2000a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "cookieSyncManager_startSync", new Class[0], new Object[0]);
        AppMethodBeat.o(188437);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreCookieManager
    public void syncImmediately() {
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreCookieManager
    public void appendDomain(URL url) {
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreCookieManager
    public void setCookie(URL url, Map<String, List<String>> map) {
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreCookieManager
    public void setQCookie(String str, String str2) {
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreCookieManager
    public String getCookie(String str) {
        AppMethodBeat.i(188438);
        Object invokeStaticMethod = this.f2000a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "getCookie", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(188438);
            return null;
        }
        String str2 = (String) invokeStaticMethod;
        AppMethodBeat.o(188438);
        return str2;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreCookieManager
    public String getCookie(String str, boolean z) {
        return null;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreCookieManager
    public String getQCookie(String str) {
        return null;
    }
}
