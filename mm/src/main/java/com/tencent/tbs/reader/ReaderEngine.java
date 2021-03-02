package com.tencent.tbs.reader;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneManager;
import com.tencent.tbs.one.impl.common.statistic.StatisticReport;
import java.util.Map;

public class ReaderEngine {

    /* renamed from: b  reason: collision with root package name */
    private static volatile ReaderEngine f2792b = null;

    /* renamed from: a  reason: collision with root package name */
    protected ITbsReaderEntry f2793a;

    /* renamed from: c  reason: collision with root package name */
    private String f2794c;

    /* renamed from: d  reason: collision with root package name */
    private int f2795d;

    public static ReaderEngine getInstance() {
        AppMethodBeat.i(53083);
        if (f2792b == null) {
            synchronized (ReaderEngine.class) {
                try {
                    if (f2792b == null) {
                        f2792b = new ReaderEngine();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(53083);
                    throw th;
                }
            }
        }
        ReaderEngine readerEngine = f2792b;
        AppMethodBeat.o(53083);
        return readerEngine;
    }

    public String getVersionName() {
        return this.f2794c;
    }

    public int getVersionCode() {
        return this.f2795d;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0054  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean initReaderEntry(android.content.Context r8) {
        /*
        // Method dump skipped, instructions count: 103
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tbs.reader.ReaderEngine.initReaderEntry(android.content.Context):boolean");
    }

    public void report(int i2, String str, Throwable th) {
        AppMethodBeat.i(187964);
        try {
            StatisticReport create = StatisticReport.create("tbs_sdk_file_stat", i2);
            create.setDescription(str, th);
            create.report();
            AppMethodBeat.o(187964);
        } catch (Throwable th2) {
            AppMethodBeat.o(187964);
        }
    }

    public boolean fileEnginePreLoad(Context context, TBSOneCallback tBSOneCallback) {
        AppMethodBeat.i(187965);
        TBSOneManager defaultInstance = TBSOneManager.getDefaultInstance(context);
        defaultInstance.setPolicy(TBSOneManager.Policy.BUILTIN_FIRST);
        boolean z = false;
        try {
            z = defaultInstance.isComponentInstalled("file");
            if (!z) {
                defaultInstance.installComponent("file", tBSOneCallback);
            }
        } catch (Throwable th) {
        }
        AppMethodBeat.o(187965);
        return z;
    }

    public void setConfigSetting(Map map) {
        AppMethodBeat.i(187966);
        if (this.f2793a != null) {
            this.f2793a.initSettings(map);
        }
        AppMethodBeat.o(187966);
    }

    public static String getComponentName() {
        return "file";
    }

    public boolean isSupportCurrentPlatform() {
        AppMethodBeat.i(53085);
        boolean z = false;
        if (this.f2793a != null) {
            z = this.f2793a.isSupportCurrentPlatform();
        }
        AppMethodBeat.o(53085);
        return z;
    }

    public boolean isSupportExt(int i2, String str) {
        AppMethodBeat.i(53086);
        boolean z = false;
        if (this.f2793a != null) {
            z = this.f2793a.isSupportExt(i2, str);
        }
        if (!z) {
            report(1002, str, null);
        }
        AppMethodBeat.o(53086);
        return z;
    }

    public ITbsReader createTbsReader(Context context, Integer num, ITbsReaderCallback iTbsReaderCallback) {
        ITbsReader iTbsReader;
        AppMethodBeat.i(53087);
        if (this.f2793a != null) {
            iTbsReader = (ITbsReader) this.f2793a.createTbsReader(context, num, iTbsReaderCallback);
        } else {
            iTbsReader = null;
        }
        if (iTbsReader == null) {
            report(1001, "createTbsReader:".concat(String.valueOf(num)), null);
        }
        AppMethodBeat.o(53087);
        return iTbsReader;
    }
}
