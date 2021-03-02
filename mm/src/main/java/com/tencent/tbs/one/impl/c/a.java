package com.tencent.tbs.one.impl.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.one.TBSOneComponent;
import java.io.File;

public final class a implements TBSOneComponent {

    /* renamed from: a  reason: collision with root package name */
    Context f2415a;

    /* renamed from: b  reason: collision with root package name */
    ClassLoader f2416b;

    /* renamed from: c  reason: collision with root package name */
    Object f2417c;

    /* renamed from: d  reason: collision with root package name */
    private String f2418d;

    /* renamed from: e  reason: collision with root package name */
    private String f2419e;

    /* renamed from: f  reason: collision with root package name */
    private int f2420f;

    /* renamed from: g  reason: collision with root package name */
    private File f2421g;

    public a(String str, String str2, int i2, File file) {
        this.f2418d = str;
        this.f2419e = str2;
        this.f2420f = i2;
        this.f2421g = file;
    }

    @Override // com.tencent.tbs.one.TBSOneComponent
    public final ClassLoader getEntryClassLoader() {
        return this.f2416b;
    }

    @Override // com.tencent.tbs.one.TBSOneComponent
    public final Object getEntryObject() {
        return this.f2417c;
    }

    @Override // com.tencent.tbs.one.TBSOneComponent
    public final File getInstallationDirectory() {
        return this.f2421g;
    }

    @Override // com.tencent.tbs.one.TBSOneComponent
    public final String getName() {
        return this.f2418d;
    }

    @Override // com.tencent.tbs.one.TBSOneComponent
    public final Context getResourcesContext() {
        return this.f2415a;
    }

    @Override // com.tencent.tbs.one.TBSOneComponent
    public final int getVersionCode() {
        return this.f2420f;
    }

    @Override // com.tencent.tbs.one.TBSOneComponent
    public final String getVersionName() {
        return this.f2419e;
    }

    public final String toString() {
        AppMethodBeat.i(173883);
        String format = String.format("{name: '%s', versionName: '%s', versionCode: %d, installationDirectory: '%s', apkContext: '%s', entryClassLoader: '%s', entryObject: '%s'}", this.f2418d, this.f2419e, Integer.valueOf(this.f2420f), this.f2421g, this.f2415a, this.f2416b, this.f2417c);
        AppMethodBeat.o(173883);
        return format;
    }
}
