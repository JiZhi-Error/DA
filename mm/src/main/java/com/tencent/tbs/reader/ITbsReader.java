package com.tencent.tbs.reader;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

public interface ITbsReader {
    public static final int OPEN_FILEREADER_CORE_CALLBACK = 14;
    public static final int OPEN_FILEREADER_ERRORCODE_CAN_NOT_OPEN = 10000;
    public static final int OPEN_FILEREADER_ERRORCODE_CAN_NOT_SUPPORTED = 10001;
    public static final int OPEN_FILEREADER_ERRORCODE_PERMISSION_DENIED = 20001;
    public static final int OPEN_FILEREADER_MINIQB_CALLBACK = 13;
    public static final int OPEN_FILEREADER_OPEN_SUCCESS = 0;
    public static final int OPEN_FILEREADER_PLUGIN_FAILED = 11;
    public static final int OPEN_FILEREADER_PLUGIN_PROGRESS = 12;
    public static final int OPEN_FILEREADER_PLUGIN_SUCCESS = 10;
    public static final int OPEN_FILEREADER_STATUS_UI_CALLBACK = 15;
    public static final int TBS_READER_TYPE_MIXER = 3;
    public static final int TBS_READER_TYPE_ONLY_VIEW = 1;

    public interface IReaderCore {
        void closeFile();

        void destroy();

        boolean init(Context context);

        void onSizeChanged(Integer num, Integer num2);

        int openFile(Context context, Bundle bundle, FrameLayout frameLayout, View view);
    }

    public interface IReaderPlugin {
        void destroy();

        int downloadPlugin(Context context, String str);

        int initPlugin(Context context);
    }

    Object createAtom(int i2);

    void destroy();

    void doCommand(Integer num, Object obj, Object obj2);

    IReaderCore getReaderCore();

    IReaderPlugin getReaderPlugin();

    void registerAtom(Object obj);
}
