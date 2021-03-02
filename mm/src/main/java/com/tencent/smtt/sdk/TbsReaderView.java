package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.c.c;
import com.tencent.smtt.utils.Apn;

public class TbsReaderView extends FrameLayout {
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

    /* renamed from: f  reason: collision with root package name */
    static boolean f1867f = false;
    public static String gReaderPackName = "";
    public static String gReaderPackVersion = "";

    /* renamed from: a  reason: collision with root package name */
    Context f1868a = null;

    /* renamed from: b  reason: collision with root package name */
    ReaderWizard f1869b = null;

    /* renamed from: c  reason: collision with root package name */
    Object f1870c = null;

    /* renamed from: d  reason: collision with root package name */
    ReaderCallback f1871d = null;

    /* renamed from: e  reason: collision with root package name */
    ReaderCallback f1872e = null;

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
        AppMethodBeat.i(55481);
        if (!(context instanceof Activity)) {
            RuntimeException runtimeException = new RuntimeException("error: unexpect context(none Activity)");
            AppMethodBeat.o(55481);
            throw runtimeException;
        }
        this.f1871d = readerCallback;
        this.f1868a = context;
        this.f1872e = new ReaderCallback() {
            /* class com.tencent.smtt.sdk.TbsReaderView.AnonymousClass1 */

            @Override // com.tencent.smtt.sdk.TbsReaderView.ReaderCallback
            public void onCallBackAction(Integer num, Object obj, Object obj2) {
                Bundle bundle = null;
                boolean z = false;
                AppMethodBeat.i(55089);
                new StringBuilder("onCallBackAction, actionType:").append(num);
                Bundle bundle2 = obj;
                switch (num.intValue()) {
                    case 5008:
                        if (c.c(TbsReaderView.this.f1868a)) {
                            String str = "";
                            if (obj != null) {
                                Bundle bundle3 = (Bundle) obj;
                                str = bundle3.getString("docpath");
                                bundle = bundle3;
                            }
                            QbSdk.startQBForDoc(TbsReaderView.this.f1868a, str, 4, 0, "pdf", bundle);
                            TbsReaderView.this.userStatistics("AHNG813");
                            z = true;
                            bundle2 = obj;
                            break;
                        } else {
                            num = 5011;
                            String resString = TbsReaderView.getResString(TbsReaderView.this.f1868a, 5023);
                            Bundle bundle4 = new Bundle();
                            bundle4.putString("tip", resString);
                            bundle4.putString("statistics", "AHNG812");
                            bundle4.putInt("channel_id", 10834);
                            TbsReaderView.this.userStatistics("AHNG811");
                            bundle2 = bundle4;
                            break;
                        }
                    case 5009:
                        if (c.c(TbsReaderView.this.f1868a)) {
                            String str2 = "";
                            if (obj != null) {
                                Bundle bundle5 = (Bundle) obj;
                                str2 = bundle5.getString("docpath");
                                bundle = bundle5;
                            }
                            QbSdk.startQBForDoc(TbsReaderView.this.f1868a, str2, 4, 0, "", bundle);
                            TbsReaderView.this.userStatistics("AHNG809");
                            z = true;
                            bundle2 = obj;
                            break;
                        } else {
                            num = 5011;
                            String resString2 = TbsReaderView.getResString(TbsReaderView.this.f1868a, 5021);
                            Bundle bundle6 = new Bundle();
                            bundle6.putString("tip", resString2);
                            bundle6.putString("statistics", "AHNG808");
                            bundle6.putInt("channel_id", 10833);
                            TbsReaderView.this.userStatistics("AHNG807");
                            bundle2 = bundle6;
                            break;
                        }
                    case 5010:
                        if (c.c(TbsReaderView.this.f1868a)) {
                            String str3 = "";
                            if (obj != null) {
                                Bundle bundle7 = (Bundle) obj;
                                str3 = bundle7.getString("docpath");
                                bundle = bundle7;
                            }
                            QbSdk.startQBForDoc(TbsReaderView.this.f1868a, str3, 4, 0, "txt", bundle);
                            z = true;
                            bundle2 = obj;
                            break;
                        } else {
                            num = 5011;
                            String resString3 = TbsReaderView.getResString(TbsReaderView.this.f1868a, 5022);
                            Bundle bundle8 = new Bundle();
                            bundle8.putString("tip", resString3);
                            bundle8.putString("statistics", "AHNG816");
                            bundle8.putInt("channel_id", 10835);
                            TbsReaderView.this.userStatistics("AHNG815");
                            bundle2 = bundle8;
                            break;
                        }
                    case 5026:
                        if (c.c(TbsReaderView.this.f1868a)) {
                            String str4 = "";
                            if (obj != null) {
                                Bundle bundle9 = (Bundle) obj;
                                str4 = bundle9.getString("docpath");
                                bundle = bundle9;
                            }
                            QbSdk.startQBForDoc(TbsReaderView.this.f1868a, str4, 4, 0, "doc", bundle);
                            TbsReaderView.this.userStatistics("AHNG829");
                            z = true;
                            bundle2 = obj;
                            break;
                        } else {
                            num = 5011;
                            String resString4 = TbsReaderView.getResString(TbsReaderView.this.f1868a, 5029);
                            Bundle bundle10 = new Bundle();
                            bundle10.putString("tip", resString4);
                            bundle10.putString("statistics", "AHNG828");
                            bundle10.putInt("channel_id", 10965);
                            TbsReaderView.this.userStatistics("AHNG827");
                            bundle2 = bundle10;
                            break;
                        }
                    case 5030:
                        if (obj != null) {
                            Bundle bundle11 = (Bundle) obj;
                            TbsReaderView.gReaderPackName = bundle11.getString("name");
                            TbsReaderView.gReaderPackVersion = bundle11.getString("version");
                        }
                        z = true;
                        bundle2 = obj;
                        break;
                }
                if (TbsReaderView.this.f1871d != null && !z) {
                    TbsReaderView.this.f1871d.onCallBackAction(num, bundle2, obj2);
                }
                AppMethodBeat.o(55089);
            }
        };
        AppMethodBeat.o(55481);
    }

    static boolean a(Context context) {
        AppMethodBeat.i(55482);
        if (!f1867f) {
            g.a(true).a(context.getApplicationContext(), true, false, null);
            f1867f = g.a(false).b();
        }
        new StringBuilder("gInitSdk:").append(f1867f);
        boolean z = f1867f;
        AppMethodBeat.o(55482);
        return z;
    }

    public static boolean isSupportExt(Context context, String str) {
        boolean z = false;
        AppMethodBeat.i(55483);
        if (a(context) && ReaderWizard.isSupportCurrentPlatform(context) && ReaderWizard.isSupportExt(str)) {
            z = true;
        }
        AppMethodBeat.o(55483);
        return z;
    }

    public boolean preOpen(String str, boolean z) {
        boolean z2 = false;
        AppMethodBeat.i(55484);
        if (!isSupportExt(this.f1868a, str)) {
            AppMethodBeat.o(55484);
        } else {
            boolean a2 = a(this.f1868a);
            if (a2) {
                a2 = a();
                if (z && a2) {
                    if (Apn.getApnType(this.f1868a) == 3) {
                        z2 = true;
                    }
                    z2 = this.f1869b.checkPlugin(this.f1870c, this.f1868a, str, z2);
                    AppMethodBeat.o(55484);
                }
            }
            z2 = a2;
            AppMethodBeat.o(55484);
        }
        return z2;
    }

    public boolean downloadPlugin(String str) {
        AppMethodBeat.i(55485);
        if (this.f1870c == null) {
            AppMethodBeat.o(55485);
            return false;
        }
        boolean checkPlugin = this.f1869b.checkPlugin(this.f1870c, this.f1868a, str, true);
        AppMethodBeat.o(55485);
        return checkPlugin;
    }

    public static Drawable getResDrawable(Context context, int i2) {
        AppMethodBeat.i(55486);
        Drawable drawable = null;
        if (a(context)) {
            drawable = ReaderWizard.getResDrawable(i2);
        }
        AppMethodBeat.o(55486);
        return drawable;
    }

    public static String getResString(Context context, int i2) {
        AppMethodBeat.i(55487);
        String str = "";
        if (a(context)) {
            str = ReaderWizard.getResString(i2);
        }
        AppMethodBeat.o(55487);
        return str;
    }

    public void openFile(Bundle bundle) {
        boolean z = true;
        AppMethodBeat.i(55488);
        if (this.f1870c == null || bundle == null) {
            AppMethodBeat.o(55488);
            return;
        }
        bundle.putBoolean("browser6.0", (!c.b(this.f1868a)) | c.c(this.f1868a));
        boolean a2 = c.a(this.f1868a, 6101625, 610000);
        if (c.b(this.f1868a)) {
            z = false;
        }
        bundle.putBoolean("browser6.1", a2 | z);
        this.f1869b.openFile(this.f1870c, this.f1868a, bundle, this);
        AppMethodBeat.o(55488);
    }

    public void doCommand(Integer num, Object obj, Object obj2) {
        AppMethodBeat.i(55489);
        if (!(this.f1869b == null || this.f1870c == null)) {
            this.f1869b.doCommand(this.f1870c, num, obj, obj2);
        }
        AppMethodBeat.o(55489);
    }

    public void onSizeChanged(int i2, int i3) {
        AppMethodBeat.i(55490);
        if (!(this.f1869b == null || this.f1870c == null)) {
            this.f1869b.onSizeChanged(this.f1870c, i2, i3);
        }
        AppMethodBeat.o(55490);
    }

    public void onStop() {
        AppMethodBeat.i(55491);
        if (this.f1869b != null) {
            this.f1869b.destroy(this.f1870c);
            this.f1870c = null;
        }
        this.f1868a = null;
        f1867f = false;
        AppMethodBeat.o(55491);
    }

    public void userStatistics(String str) {
        AppMethodBeat.i(55492);
        if (this.f1869b != null) {
            this.f1869b.userStatistics(this.f1870c, str);
        }
        AppMethodBeat.o(55492);
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        boolean z = false;
        AppMethodBeat.i(55493);
        try {
            if (this.f1869b == null) {
                this.f1869b = new ReaderWizard(this.f1872e);
            }
            if (this.f1870c == null) {
                this.f1870c = this.f1869b.getTbsReader();
            }
            if (this.f1870c != null) {
                z = this.f1869b.initTbsReader(this.f1870c, this.f1868a);
            }
        } catch (NullPointerException e2) {
        }
        AppMethodBeat.o(55493);
        return z;
    }
}
