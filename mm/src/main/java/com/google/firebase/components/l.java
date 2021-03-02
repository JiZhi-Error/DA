package com.google.firebase.components;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* access modifiers changed from: package-private */
public final class l implements m {
    private l() {
    }

    /* synthetic */ l(byte b2) {
        this();
    }

    private static Bundle aq(Context context) {
        AppMethodBeat.i(4085);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                AppMethodBeat.o(4085);
                return null;
            }
            ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, ComponentDiscoveryService.class), 128);
            if (serviceInfo == null) {
                AppMethodBeat.o(4085);
                return null;
            }
            Bundle bundle = serviceInfo.metaData;
            AppMethodBeat.o(4085);
            return bundle;
        } catch (PackageManager.NameNotFoundException e2) {
            AppMethodBeat.o(4085);
            return null;
        }
    }

    @Override // com.google.firebase.components.m
    public final List<String> ap(Context context) {
        AppMethodBeat.i(4084);
        Bundle aq = aq(context);
        if (aq == null) {
            List<String> emptyList = Collections.emptyList();
            AppMethodBeat.o(4084);
            return emptyList;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : aq.keySet()) {
            if ("com.google.firebase.components.ComponentRegistrar".equals(aq.get(str)) && str.startsWith("com.google.firebase.components:")) {
                arrayList.add(str.substring(31));
            }
        }
        AppMethodBeat.o(4084);
        return arrayList;
    }
}
