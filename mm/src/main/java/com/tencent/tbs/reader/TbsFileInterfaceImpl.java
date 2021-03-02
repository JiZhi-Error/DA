package com.tencent.tbs.reader;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.reader.external.ITbsReaderAtom;
import java.util.LinkedHashMap;

public class TbsFileInterfaceImpl {
    public static int FILE_READER_WINDOW_TYPE_DEFAULT = 0;
    public static int FILE_READER_WINDOW_TYPE_VIEW = 2;

    /* renamed from: c  reason: collision with root package name */
    static TbsFileInterfaceImpl f2800c = null;

    /* renamed from: a  reason: collision with root package name */
    TbsReaderManager f2801a;

    /* renamed from: b  reason: collision with root package name */
    ReaderMixerMode f2802b;

    public static TbsFileInterfaceImpl getInstance() {
        AppMethodBeat.i(187973);
        if (f2800c == null) {
            f2800c = new TbsFileInterfaceImpl();
        }
        TbsFileInterfaceImpl tbsFileInterfaceImpl = f2800c;
        AppMethodBeat.o(187973);
        return tbsFileInterfaceImpl;
    }

    public TbsFileInterfaceImpl() {
        AppMethodBeat.i(187974);
        this.f2801a = null;
        this.f2802b = null;
        this.f2801a = new TbsReaderManager();
        AppMethodBeat.o(187974);
    }

    public static boolean initEngine(Context context) {
        AppMethodBeat.i(187975);
        ReaderEngine.getInstance().initReaderEntry(context);
        boolean isSupportCurrentPlatform = ReaderEngine.getInstance().isSupportCurrentPlatform();
        AppMethodBeat.o(187975);
        return isSupportCurrentPlatform;
    }

    public static void setProviderSetting(String str) {
        AppMethodBeat.i(187976);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("provider_classname", str);
        ReaderEngine.getInstance().setConfigSetting(linkedHashMap);
        AppMethodBeat.o(187976);
    }

    public static boolean canOpenFile(String str) {
        AppMethodBeat.i(187977);
        boolean z = false;
        if (ReaderEngine.getInstance().isSupportCurrentPlatform()) {
            z = ReaderEngine.getInstance().isSupportExt(3, str);
        }
        AppMethodBeat.o(187977);
        return z;
    }

    public void closeFileReader() {
        AppMethodBeat.i(187978);
        if (this.f2802b != null) {
            this.f2802b.closeFile();
        }
        this.f2802b = null;
        if (this.f2801a != null) {
            this.f2801a.destroy();
        }
        AppMethodBeat.o(187978);
    }

    public ReaderMixerMode createReader(Context context, ITbsReaderCallback iTbsReaderCallback) {
        AppMethodBeat.i(187979);
        ReaderMixerMode createReaderMode = this.f2801a.createReaderMode(context, iTbsReaderCallback);
        AppMethodBeat.o(187979);
        return createReaderMode;
    }

    public ITbsReaderAtom createAtom(int i2) {
        AppMethodBeat.i(187980);
        if (this.f2801a.getTbsReader() != null) {
            ITbsReaderAtom iTbsReaderAtom = (ITbsReaderAtom) this.f2801a.getTbsReader().createAtom(i2);
            AppMethodBeat.o(187980);
            return iTbsReaderAtom;
        }
        AppMethodBeat.o(187980);
        return null;
    }

    public boolean initReader(Context context, ITbsReaderCallback iTbsReaderCallback) {
        AppMethodBeat.i(187981);
        this.f2802b = createReader(context, iTbsReaderCallback);
        if (this.f2802b != null) {
            AppMethodBeat.o(187981);
            return true;
        }
        AppMethodBeat.o(187981);
        return false;
    }

    public int openFileReader(Bundle bundle, FrameLayout frameLayout) {
        AppMethodBeat.i(187982);
        int openFile = this.f2802b.openFile(bundle, frameLayout);
        AppMethodBeat.o(187982);
        return openFile;
    }

    public int openFileReader(Context context, Bundle bundle, ITbsReaderCallback iTbsReaderCallback, FrameLayout frameLayout) {
        AppMethodBeat.i(187983);
        closeFileReader();
        this.f2802b = createReader(context, iTbsReaderCallback);
        int openFile = this.f2802b.openFile(bundle, frameLayout);
        AppMethodBeat.o(187983);
        return openFile;
    }

    public void onSizeChanged(int i2, int i3) {
        AppMethodBeat.i(187984);
        if (this.f2802b != null) {
            this.f2802b.onSizeChanged(i2, i3);
        }
        AppMethodBeat.o(187984);
    }

    public void pluginPreLoad(Context context, String str) {
        AppMethodBeat.i(187985);
        this.f2801a.getPluginPre(context).downloadPlugin(context, str);
        AppMethodBeat.o(187985);
    }
}
