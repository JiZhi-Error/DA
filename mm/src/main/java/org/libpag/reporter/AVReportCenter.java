package org.libpag.reporter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class AVReportCenter {
    private static final String TAG = ("AVReportCenter-" + Integer.toHexString(AVReportCenter.class.hashCode()));
    private static final AVReportCenter ourInstance = new AVReportCenter();
    private String app;
    private Boolean auto = Boolean.TRUE;
    private String dir;
    private boolean enable = true;
    private String imei;
    private volatile Handler ioHandler;
    private volatile HandlerThread ioThread;
    private String os;
    private Reporter reporter;
    private boolean shareLooper = true;
    private String tmpDir;

    static /* synthetic */ void access$600(AVReportCenter aVReportCenter, Map map) {
        AppMethodBeat.i(237027);
        aVReportCenter.putCommonData(map);
        AppMethodBeat.o(237027);
    }

    static /* synthetic */ void access$700(AVReportCenter aVReportCenter, Map map) {
        AppMethodBeat.i(237028);
        aVReportCenter.hibernateMap(map);
        AppMethodBeat.o(237028);
    }

    static {
        AppMethodBeat.i(237029);
        AppMethodBeat.o(237029);
    }

    public static AVReportCenter getInstance() {
        return ourInstance;
    }

    @SuppressLint({"MissingPermission"})
    public void init(Context context) {
        AppMethodBeat.i(237018);
        if (this.ioHandler == null) {
            synchronized (AVReportCenter.class) {
                try {
                    if (this.ioHandler == null) {
                        try {
                            this.os = DeviceInfo.getRomFingerprint(context) + DeviceInfo.getApiLevelInt();
                            this.app = "fail";
                            try {
                                this.app = context.getPackageName();
                            } catch (Exception e2) {
                            }
                            File externalCacheDir = context.getExternalCacheDir();
                            if (externalCacheDir == null) {
                                AppMethodBeat.o(237018);
                                return;
                            }
                            String str = externalCacheDir.getAbsolutePath() + File.separator + md5(getClass().getName());
                            this.dir = str + "/Report";
                            File file = new File(this.dir);
                            if (!file.exists()) {
                                file.mkdirs();
                            }
                            this.tmpDir = str + "/Report_tmp";
                            File file2 = new File(this.tmpDir);
                            if (!file2.exists()) {
                                file2.mkdirs();
                            }
                            try {
                                if (Build.VERSION.SDK_INT >= 26) {
                                    this.imei = Settings.Secure.getString(context.getContentResolver(), "android_id");
                                } else {
                                    this.imei = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                                }
                            } catch (Exception e3) {
                                this.imei = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                            }
                            this.ioThread = new HandlerThread(TAG);
                            this.ioThread.setDaemon(true);
                            this.ioThread.start();
                            do {
                            } while (!this.ioThread.isAlive());
                            this.ioHandler = new Handler(this.ioThread.getLooper());
                            this.ioHandler.post(new Runnable() {
                                /* class org.libpag.reporter.AVReportCenter.AnonymousClass1 */

                                public void run() {
                                    AppMethodBeat.i(237015);
                                    File[] listFiles = new File(AVReportCenter.this.dir).listFiles();
                                    if (listFiles != null) {
                                        for (File file : listFiles) {
                                            file.delete();
                                        }
                                    }
                                    File[] listFiles2 = new File(AVReportCenter.this.tmpDir).listFiles();
                                    if (listFiles2 != null) {
                                        for (File file2 : listFiles2) {
                                            file2.delete();
                                        }
                                    }
                                    AppMethodBeat.o(237015);
                                }
                            });
                            AppMethodBeat.o(237018);
                        } catch (Exception e4) {
                            AppMethodBeat.o(237018);
                        }
                    }
                } finally {
                    AppMethodBeat.o(237018);
                }
            }
        } else {
            AppMethodBeat.o(237018);
        }
    }

    private AVReportCenter() {
    }

    private void putCommonData(Map<String, Object> map) {
        AppMethodBeat.i(237019);
        map.put("device", DeviceInfo.getBrand() + DeviceInfo.getDeviceName());
        map.put(TPDownloadProxyEnum.USER_DEVICE_ID, this.imei);
        map.put(TPDownloadProxyEnum.USER_PLATFORM, "and");
        map.put("os", this.os);
        map.put("appid", this.app);
        map.put("_dc", Integer.valueOf(Math.abs(new Random().nextInt())));
        AppMethodBeat.o(237019);
    }

    private void hibernateMap(Map<String, Object> map) {
        AppMethodBeat.i(237020);
        hibernate(toUrlParams(map));
        AppMethodBeat.o(237020);
    }

    public void commit(final Map<String, String> map) {
        AppMethodBeat.i(237021);
        if (!this.enable || map == null || this.ioHandler == null) {
            AppMethodBeat.o(237021);
            return;
        }
        this.ioHandler.post(new Runnable() {
            /* class org.libpag.reporter.AVReportCenter.AnonymousClass2 */

            public void run() {
                AppMethodBeat.i(237016);
                if (AVReportCenter.this.reporter == null) {
                    AVReportCenter.this.reporter = new Reporter(new File(AVReportCenter.this.dir), AVReportCenter.this.auto, AVReportCenter.this.shareLooper ? AVReportCenter.this.ioHandler.getLooper() : null);
                }
                HashMap hashMap = new HashMap();
                AVReportCenter.access$600(AVReportCenter.this, hashMap);
                hashMap.putAll(map);
                AVReportCenter.access$700(AVReportCenter.this, hashMap);
                AppMethodBeat.o(237016);
            }
        });
        AppMethodBeat.o(237021);
    }

    public void flush() {
        AppMethodBeat.i(237022);
        if (this.ioHandler == null) {
            AppMethodBeat.o(237022);
            return;
        }
        this.ioHandler.post(new Runnable() {
            /* class org.libpag.reporter.AVReportCenter.AnonymousClass3 */

            public void run() {
                AppMethodBeat.i(237017);
                if (AVReportCenter.this.reporter != null) {
                    AVReportCenter.this.reporter.flush();
                }
                AppMethodBeat.o(237017);
            }
        });
        AppMethodBeat.o(237022);
    }

    private void hibernate(String str) {
        AppMethodBeat.i(237023);
        hibernate(str, "bean");
        AppMethodBeat.o(237023);
    }

    private void hibernate(String str, String str2) {
        AppMethodBeat.i(237024);
        if (this.dir == null || this.dir.length() == 0) {
            AppMethodBeat.o(237024);
            return;
        }
        try {
            File file = new File(this.tmpDir + File.separator + str2 + "." + System.nanoTime());
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bytes = str.getBytes();
            for (int i2 = 0; i2 < bytes.length; i2++) {
                bytes[i2] = (byte) (bytes[i2] ^ -23);
            }
            fileOutputStream.write(bytes);
            fileOutputStream.close();
            file.renameTo(new File(this.dir + File.separator + str2 + "." + System.nanoTime()));
            AppMethodBeat.o(237024);
        } catch (Exception e2) {
            AppMethodBeat.o(237024);
        }
    }

    private static String toUrlParams(Map<String, Object> map) {
        AppMethodBeat.i(237025);
        String str = "attaid=06400000136&token=3598698434";
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Object value = entry.getValue();
            String key = entry.getKey();
            if (value instanceof Number) {
                str = str + "&" + key + "=" + value.toString();
            } else if (value instanceof String) {
                try {
                    str = str + "&" + key + "=" + URLEncoder.encode(value.toString(), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                } catch (UnsupportedEncodingException e2) {
                }
            }
        }
        AppMethodBeat.o(237025);
        return str;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public void setEnable(boolean z) {
        this.enable = z;
    }

    private String md5(String str) {
        AppMethodBeat.i(237026);
        try {
            String bigInteger = new BigInteger(1, MessageDigest.getInstance("MD5").digest(str.getBytes(Charset.forName(MimeTypeUtil.ContentType.DEFAULT_CHARSET)))).toString(16);
            while (bigInteger.length() < 32) {
                bigInteger = AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(bigInteger));
            }
            AppMethodBeat.o(237026);
            return bigInteger;
        } catch (Exception e2) {
            AppMethodBeat.o(237026);
            return str;
        }
    }
}
