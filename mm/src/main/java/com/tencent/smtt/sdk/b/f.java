package com.tencent.smtt.sdk.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.interfaces.IX5CoreUrlUtil;
import com.tencent.smtt.sdk.TbsWizard;

public class f implements IX5CoreUrlUtil {

    /* renamed from: a  reason: collision with root package name */
    private DexLoader f1996a;

    f(DexLoader dexLoader) {
        this.f1996a = dexLoader;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreUrlUtil
    public String guessUrl(String str) {
        AppMethodBeat.i(188439);
        Object invokeStaticMethod = this.f1996a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "urlUtilGuessUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(188439);
            return null;
        }
        String str2 = (String) invokeStaticMethod;
        AppMethodBeat.o(188439);
        return str2;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreUrlUtil
    public String composeSearchUrl(String str, String str2, String str3) {
        AppMethodBeat.i(188440);
        Object invokeStaticMethod = this.f1996a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "urlUtilComposeSearchUrl", new Class[]{String.class, String.class, String.class}, str, str2, str3);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(188440);
            return null;
        }
        String str4 = (String) invokeStaticMethod;
        AppMethodBeat.o(188440);
        return str4;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreUrlUtil
    public byte[] decode(byte[] bArr) {
        AppMethodBeat.i(188441);
        Object invokeStaticMethod = this.f1996a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "urlUtilDecode", new Class[]{String.class}, bArr);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(188441);
            return null;
        }
        byte[] bArr2 = (byte[]) invokeStaticMethod;
        AppMethodBeat.o(188441);
        return bArr2;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreUrlUtil
    public boolean isAssetUrl(String str) {
        AppMethodBeat.i(188442);
        Object invokeStaticMethod = this.f1996a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "urlUtilIsAssetUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(188442);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
        AppMethodBeat.o(188442);
        return booleanValue;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreUrlUtil
    public boolean isCookielessProxyUrl(String str) {
        AppMethodBeat.i(188443);
        Object invokeStaticMethod = this.f1996a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "urlUtilIsCookielessProxyUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(188443);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
        AppMethodBeat.o(188443);
        return booleanValue;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreUrlUtil
    public boolean isFileUrl(String str) {
        AppMethodBeat.i(188444);
        Object invokeStaticMethod = this.f1996a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "urlUtilIsFileUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(188444);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
        AppMethodBeat.o(188444);
        return booleanValue;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreUrlUtil
    public boolean isAboutUrl(String str) {
        AppMethodBeat.i(188445);
        Object invokeStaticMethod = this.f1996a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "urlUtilIsAboutUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(188445);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
        AppMethodBeat.o(188445);
        return booleanValue;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreUrlUtil
    public boolean isDataUrl(String str) {
        AppMethodBeat.i(188446);
        Object invokeStaticMethod = this.f1996a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "urlUtilIsDataUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(188446);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
        AppMethodBeat.o(188446);
        return booleanValue;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreUrlUtil
    public boolean isJavaScriptUrl(String str) {
        AppMethodBeat.i(188447);
        Object invokeStaticMethod = this.f1996a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "urlUtilIsJavaScriptUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(188447);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
        AppMethodBeat.o(188447);
        return booleanValue;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreUrlUtil
    public boolean isHttpUrl(String str) {
        AppMethodBeat.i(188448);
        Object invokeStaticMethod = this.f1996a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "urlUtilIsHttpUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(188448);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
        AppMethodBeat.o(188448);
        return booleanValue;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreUrlUtil
    public boolean isHttpsUrl(String str) {
        AppMethodBeat.i(188449);
        Object invokeStaticMethod = this.f1996a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "urlUtilIsHttpsUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(188449);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
        AppMethodBeat.o(188449);
        return booleanValue;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreUrlUtil
    public boolean isNetworkUrl(String str) {
        AppMethodBeat.i(188450);
        Object invokeStaticMethod = this.f1996a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "urlUtilIsNetworkUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(188450);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
        AppMethodBeat.o(188450);
        return booleanValue;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreUrlUtil
    public boolean isContentUrl(String str) {
        AppMethodBeat.i(188451);
        Object invokeStaticMethod = this.f1996a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "urlUtilIsContentUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(188451);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
        AppMethodBeat.o(188451);
        return booleanValue;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreUrlUtil
    public boolean isValidUrl(String str) {
        AppMethodBeat.i(188452);
        Object invokeStaticMethod = this.f1996a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "urlUtilIsValidUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(188452);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
        AppMethodBeat.o(188452);
        return booleanValue;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreUrlUtil
    public String stripAnchor(String str) {
        AppMethodBeat.i(188453);
        Object invokeStaticMethod = this.f1996a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "urlUtilStripAnchor", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(188453);
            return null;
        }
        String str2 = (String) invokeStaticMethod;
        AppMethodBeat.o(188453);
        return str2;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreUrlUtil
    public String guessFileName(String str, String str2, String str3) {
        AppMethodBeat.i(188454);
        Object invokeStaticMethod = this.f1996a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "urlUtilGuessFileName", new Class[]{String.class, String.class, String.class}, str, str2, str3);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(188454);
            return null;
        }
        String str4 = (String) invokeStaticMethod;
        AppMethodBeat.o(188454);
        return str4;
    }
}
