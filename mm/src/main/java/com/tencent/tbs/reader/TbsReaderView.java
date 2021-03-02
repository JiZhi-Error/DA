package com.tencent.tbs.reader;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TbsReaderView extends FrameLayout implements ITbsReaderCallback {
    public static final String IS_BAR_ANIMATING = "is_bar_animating";
    public static final String IS_BAR_SHOWING = "is_bar_show";
    public static final String IS_INTO_DOWNLOADING = "into_downloading";
    public static final String KEY_FILE_PATH = "filePath";
    public static final String KEY_TEMP_PATH = "tempPath";
    public static final int READER_CHANNEL_DOC_ID = 10965;
    public static final int READER_CHANNEL_PDF_ID = 10834;
    public static final int READER_CHANNEL_PPT_ID = 10833;
    public static final int READER_CHANNEL_TXT_ID = 10835;
    public static final String READER_STATISTICS_COUNT_CANCEL_LOADED_BTN = "AHNG802";
    public static final String READER_STATISTICS_COUNT_CLICK_LOADED_BTN = "AHNG801";
    public static final String READER_STATISTICS_COUNT_DOC_INTO_BROWSER = "AHNG829";
    public static final String READER_STATISTICS_COUNT_DOC_INTO_DIALOG = "AHNG827";
    public static final String READER_STATISTICS_COUNT_DOC_INTO_DOWNLOAD = "AHNG828";
    public static final String READER_STATISTICS_COUNT_DOC_SEARCH_BTN = "AHNG826";
    public static final String READER_STATISTICS_COUNT_PDF_FOLDER_BTN = "AHNG810";
    public static final String READER_STATISTICS_COUNT_PDF_INTO_BROWSER = "AHNG813";
    public static final String READER_STATISTICS_COUNT_PDF_INTO_DIALOG = "AHNG811";
    public static final String READER_STATISTICS_COUNT_PDF_INTO_DOWNLOAD = "AHNG812";
    public static final String READER_STATISTICS_COUNT_PPT_INTO_BROWSER = "AHNG809";
    public static final String READER_STATISTICS_COUNT_PPT_INTO_DIALOG = "AHNG807";
    public static final String READER_STATISTICS_COUNT_PPT_INTO_DOWNLOAD = "AHNG808";
    public static final String READER_STATISTICS_COUNT_PPT_PLAY_BTN = "AHNG806";
    public static final String READER_STATISTICS_COUNT_RETRY_BTN = "AHNG803";
    public static final String READER_STATISTICS_COUNT_TXT_INTO_BROWSER = "AHNG817";
    public static final String READER_STATISTICS_COUNT_TXT_INTO_DIALOG = "AHNG815";
    public static final String READER_STATISTICS_COUNT_TXT_INTO_DOWNLOAD = "AHNG816";
    public static final String READER_STATISTICS_COUNT_TXT_NOVEL_BTN = "AHNG814";
    public static final String TAG = "TbsReaderView";

    /* renamed from: g  reason: collision with root package name */
    static boolean f2804g = false;
    public static String gReaderPackName = "";
    public static String gReaderPackVersion = "";

    /* renamed from: a  reason: collision with root package name */
    Context f2805a = null;

    /* renamed from: b  reason: collision with root package name */
    ITbsReader f2806b = null;

    /* renamed from: c  reason: collision with root package name */
    ReaderCallback f2807c = null;

    /* renamed from: d  reason: collision with root package name */
    ReaderCallback f2808d = null;

    /* renamed from: e  reason: collision with root package name */
    ReaderMixerMode f2809e = null;

    /* renamed from: f  reason: collision with root package name */
    ReaderPluginPreLoad f2810f = null;

    public interface ReaderCallback {
        public static final int COPY_SELECT_TEXT = 5003;
        public static final int GET_BAR_ANIMATING = 5000;
        public static final int GET_BAR_ISSHOWING = 5024;
        public static final int HIDDEN_BAR = 5001;
        public static final int INSTALL_QB = 5011;
        public static final int NOTIFY_CANDISPLAY = 12;
        public static final int NOTIFY_ERRORCODE = 19;
        public static final int READER_OPEN_QQ_FILE_LIST = 5031;
        public static final int READER_PDF_LIST = 5008;
        public static final int READER_PLUGIN_ACTIVITY_PAUSE = 5032;
        public static final int READER_PLUGIN_CANLOAD = 5013;
        public static final int READER_PLUGIN_COMMAND_FIXSCREEN = 5015;
        public static final int READER_PLUGIN_COMMAND_PDF_LIST = 5036;
        public static final int READER_PLUGIN_COMMAND_PPT_PLAYER = 5035;
        public static final int READER_PLUGIN_COMMAND_ROTATESCREEN = 5018;
        public static final int READER_PLUGIN_COMMAND_TEXT_FIND = 5038;
        public static final int READER_PLUGIN_COMMAND_TEXT_FIND_CLEAR = 5041;
        public static final int READER_PLUGIN_COMMAND_TEXT_FIND_NEXT = 5039;
        public static final int READER_PLUGIN_COMMAND_TEXT_FIND_PREV = 5040;
        public static final int READER_PLUGIN_DOWNLOADING = 5014;
        public static final int READER_PLUGIN_RES_DOC_GUIDE = 5029;
        public static final int READER_PLUGIN_RES_FIXSCREEN_NORMAL = 5016;
        public static final int READER_PLUGIN_RES_FIXSCREEN_PRESS = 5017;
        public static final int READER_PLUGIN_RES_PDF_GUIDE = 5023;
        public static final int READER_PLUGIN_RES_PPT_GUIDE = 5021;
        public static final int READER_PLUGIN_RES_ROTATESCREEN_NORMAL = 5019;
        public static final int READER_PLUGIN_RES_ROTATESCREEN_PRESS = 5020;
        public static final int READER_PLUGIN_RES_TXT_GUIDE = 5022;
        public static final int READER_PLUGIN_SO_ERR = 5025;
        public static final int READER_PLUGIN_SO_INTO_START = 5027;
        public static final int READER_PLUGIN_SO_PROGRESS = 5028;
        public static final int READER_PLUGIN_SO_VERSION = 5030;
        public static final int READER_PLUGIN_STATUS = 5012;
        public static final int READER_PLUGIN_TEXT_FIND_RESULT = 5042;
        public static final int READER_PPT_PLAY_MODEL = 5009;
        public static final int READER_SEARCH_IN_DOCUMENT = 5026;
        public static final int READER_TOAST = 5005;
        public static final int READER_TXT_READING_MODEL = 5010;
        public static final int SEARCH_SELECT_TEXT = 5004;
        public static final int SHOW_BAR = 5002;
        public static final int SHOW_DIALOG = 5006;

        void onCallBackAction(Integer num, Object obj, Object obj2);
    }

    public TbsReaderView(Context context, ReaderCallback readerCallback) {
        super(context.getApplicationContext());
        AppMethodBeat.i(187987);
        if (!(context instanceof Activity)) {
            RuntimeException runtimeException = new RuntimeException("error: unexpect context(none Activity)");
            AppMethodBeat.o(187987);
            throw runtimeException;
        }
        this.f2807c = readerCallback;
        this.f2805a = context;
        AppMethodBeat.o(187987);
    }

    @Override // com.tencent.tbs.reader.ITbsReaderCallback
    public void onCallBackAction(Integer num, Object obj, Object obj2) {
        AppMethodBeat.i(187988);
        new StringBuilder("onCallBackAction:").append(num);
        if (this.f2807c != null) {
            this.f2807c.onCallBackAction(num, obj, obj2);
        }
        AppMethodBeat.o(187988);
    }

    public static boolean initSDK(Context context) {
        AppMethodBeat.i(187989);
        if (!f2804g) {
            f2804g = TbsFileInterfaceImpl.initEngine(context.getApplicationContext());
        }
        new StringBuilder("gInitSdk:").append(f2804g);
        boolean z = f2804g;
        AppMethodBeat.o(187989);
        return z;
    }

    public static boolean isSupportExt(Context context, String str) {
        AppMethodBeat.i(187990);
        boolean z = false;
        if (initSDK(context)) {
            z = TbsFileInterfaceImpl.canOpenFile(str);
        }
        AppMethodBeat.o(187990);
        return z;
    }

    public boolean preOpen(String str, boolean z) {
        AppMethodBeat.i(187991);
        if (!isSupportExt(this.f2805a, str)) {
            AppMethodBeat.o(187991);
            return false;
        }
        boolean initSDK = initSDK(this.f2805a);
        if (initSDK) {
            initSDK = a();
            if (z && initSDK) {
                downloadPlugin(str);
            }
        }
        AppMethodBeat.o(187991);
        return initSDK;
    }

    public boolean downloadPlugin(String str) {
        boolean z = false;
        AppMethodBeat.i(187992);
        if (this.f2806b == null) {
            AppMethodBeat.o(187992);
        } else {
            if (this.f2810f == null) {
                this.f2810f = new ReaderPluginPreLoad(this.f2805a, this.f2806b);
            }
            if (this.f2810f != null && this.f2810f.downloadPlugin(this.f2805a, str) == 0) {
                z = true;
            }
            AppMethodBeat.o(187992);
        }
        return z;
    }

    public static Drawable getResDrawable(Context context, int i2) {
        return null;
    }

    public static String getResString(Context context, int i2) {
        return "";
    }

    public int openFile(Bundle bundle) {
        AppMethodBeat.i(187993);
        if (this.f2806b == null || bundle == null || this.f2809e == null) {
            AppMethodBeat.o(187993);
            return -1;
        }
        if (!bundle.containsKey("file_reader_top_bar_hide")) {
            bundle.putBoolean("file_reader_top_bar_hide", true);
        }
        bundle.putInt("windowType", TbsFileInterfaceImpl.FILE_READER_WINDOW_TYPE_VIEW);
        int openFile = this.f2809e.openFile(bundle, this);
        AppMethodBeat.o(187993);
        return openFile;
    }

    public void doCommand(Integer num, Object obj, Object obj2) {
        AppMethodBeat.i(187994);
        if (!(this.f2809e == null || this.f2806b == null)) {
            this.f2806b.doCommand(num, obj, obj2);
        }
        AppMethodBeat.o(187994);
    }

    public void onSizeChanged(int i2, int i3) {
        AppMethodBeat.i(187995);
        if (this.f2809e != null) {
            this.f2809e.onSizeChanged(i2, i3);
        }
        AppMethodBeat.o(187995);
    }

    public void onStop() {
        AppMethodBeat.i(187996);
        if (this.f2809e != null) {
            this.f2809e.destroy();
            this.f2809e = null;
        }
        if (this.f2810f != null) {
            this.f2810f.destroy();
        }
        this.f2810f = null;
        if (this.f2806b != null) {
            this.f2806b.destroy();
        }
        this.f2806b = null;
        this.f2805a = null;
        f2804g = false;
        AppMethodBeat.o(187996);
    }

    public void userStatistics(String str) {
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        boolean z = false;
        AppMethodBeat.i(187997);
        try {
            this.f2806b = ReaderEngine.getInstance().createTbsReader(this.f2805a.getApplicationContext(), 3, this);
            if (this.f2806b != null) {
                this.f2809e = new ReaderMixerMode(this.f2805a, this.f2806b);
                z = true;
            }
        } catch (NullPointerException e2) {
        }
        AppMethodBeat.o(187997);
        return z;
    }
}
