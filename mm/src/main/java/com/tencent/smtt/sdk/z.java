package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.IX5CoreCacheManager;
import com.tencent.smtt.export.external.interfaces.IX5CoreCookieManager;
import com.tencent.smtt.export.external.interfaces.IX5CoreGeolocationPermissions;
import com.tencent.smtt.export.external.interfaces.IX5CoreJsCore;
import com.tencent.smtt.export.external.interfaces.IX5CoreMessy;
import com.tencent.smtt.export.external.interfaces.IX5CoreNetwork;
import com.tencent.smtt.export.external.interfaces.IX5CoreUrlUtil;
import com.tencent.smtt.export.external.interfaces.IX5CoreWebIconDB;
import com.tencent.smtt.export.external.interfaces.IX5CoreWebStorage;
import com.tencent.smtt.export.external.interfaces.IX5CoreWebViewDB;

public class z {
    public static boolean isX5Core() {
        AppMethodBeat.i(188307);
        x a2 = x.a();
        if (a2 == null || !a2.b()) {
            AppMethodBeat.o(188307);
            return false;
        }
        AppMethodBeat.o(188307);
        return true;
    }

    public static IX5CoreCookieManager getCookieManagerImpl() {
        AppMethodBeat.i(188308);
        IX5CoreCookieManager x5CoreCookieManager = TbsOneGreyInfoHelper.getCoreEntry().getX5CoreCookieManager();
        AppMethodBeat.o(188308);
        return x5CoreCookieManager;
    }

    public static IX5CoreCacheManager getCacheManagerImpl() {
        AppMethodBeat.i(188309);
        IX5CoreCacheManager x5CoreCacheManager = TbsOneGreyInfoHelper.getCoreEntry().getX5CoreCacheManager();
        AppMethodBeat.o(188309);
        return x5CoreCacheManager;
    }

    public static IX5CoreUrlUtil getX5CoreUrlUtilImpl() {
        AppMethodBeat.i(188310);
        IX5CoreUrlUtil x5CoreUrlUtil = TbsOneGreyInfoHelper.getCoreEntry().getX5CoreUrlUtil();
        AppMethodBeat.o(188310);
        return x5CoreUrlUtil;
    }

    public static IX5CoreWebIconDB getWebIconDBImpl() {
        AppMethodBeat.i(188311);
        IX5CoreWebIconDB x5CoreWebIconDB = TbsOneGreyInfoHelper.getCoreEntry().getX5CoreWebIconDB();
        AppMethodBeat.o(188311);
        return x5CoreWebIconDB;
    }

    public static IX5CoreWebStorage getWebStorageImpl() {
        AppMethodBeat.i(188312);
        IX5CoreWebStorage x5CoreWebStorage = TbsOneGreyInfoHelper.getCoreEntry().getX5CoreWebStorage();
        AppMethodBeat.o(188312);
        return x5CoreWebStorage;
    }

    public static IX5CoreGeolocationPermissions getGeolocationPermissionsImpl() {
        AppMethodBeat.i(188313);
        IX5CoreGeolocationPermissions x5CoreGeolocationPermissions = TbsOneGreyInfoHelper.getCoreEntry().getX5CoreGeolocationPermissions();
        AppMethodBeat.o(188313);
        return x5CoreGeolocationPermissions;
    }

    public static IX5CoreJsCore getJSCoreImpl() {
        AppMethodBeat.i(188314);
        IX5CoreJsCore x5CoreJsCore = TbsOneGreyInfoHelper.getCoreEntry().getX5CoreJsCore();
        AppMethodBeat.o(188314);
        return x5CoreJsCore;
    }

    public static IX5CoreWebViewDB getWebViewDBImpl() {
        AppMethodBeat.i(188315);
        IX5CoreWebViewDB x5CoreWebViewDB = TbsOneGreyInfoHelper.getCoreEntry().getX5CoreWebViewDB();
        AppMethodBeat.o(188315);
        return x5CoreWebViewDB;
    }

    public static IX5CoreMessy getCoreMessy() {
        AppMethodBeat.i(188316);
        IX5CoreMessy x5CoreMessy = TbsOneGreyInfoHelper.getCoreEntry().getX5CoreMessy();
        AppMethodBeat.o(188316);
        return x5CoreMessy;
    }

    public static IX5CoreNetwork getX5CoreNetwork() {
        AppMethodBeat.i(188317);
        IX5CoreNetwork x5CoreNetwork = TbsOneGreyInfoHelper.getCoreEntry().getX5CoreNetwork();
        AppMethodBeat.o(188317);
        return x5CoreNetwork;
    }
}
