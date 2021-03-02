package com.tencent.qqmusic.mediaplayer.perf;

import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Xml;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.qqmusic.mediaplayer.AudioInformation;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlSerializer;

public class PrefInfoCollector implements PlayerInfoCollector {
    private static final String ENCODING_UTF_8 = "utf-8";
    private static final String FILE_NAME = "pref_infos.xml";
    private static final String NAMESPACE = null;
    private static final String ROOT = "root";
    private static final String TAG = PrefInfoCollector.class.getSimpleName();
    private static PrefInfoCollector instance;
    private HandlerThread mHandlerThread;
    private Handler mReportHandler;
    private FileOutputStream outputStream;
    private HashMap<String, Long> prefInfos;
    private String reportFilePath;
    private XmlSerializer xmlSerializer;

    static /* synthetic */ void access$000(PrefInfoCollector prefInfoCollector) {
        AppMethodBeat.i(114210);
        prefInfoCollector.createOutputs();
        AppMethodBeat.o(114210);
    }

    static /* synthetic */ void access$100(PrefInfoCollector prefInfoCollector, AudioInformation audioInformation) {
        AppMethodBeat.i(114211);
        prefInfoCollector.printPrefInfos(audioInformation);
        AppMethodBeat.o(114211);
    }

    static /* synthetic */ void access$200(PrefInfoCollector prefInfoCollector) {
        AppMethodBeat.i(114212);
        prefInfoCollector.upLoadByCommonPost();
        AppMethodBeat.o(114212);
    }

    static {
        AppMethodBeat.i(114213);
        AppMethodBeat.o(114213);
    }

    private PrefInfoCollector() {
        AppMethodBeat.i(114201);
        this.prefInfos = null;
        this.xmlSerializer = null;
        this.prefInfos = new HashMap<>();
        this.xmlSerializer = Xml.newSerializer();
        AppMethodBeat.o(114201);
    }

    public static synchronized PrefInfoCollector getInstance() {
        PrefInfoCollector prefInfoCollector;
        synchronized (PrefInfoCollector.class) {
            AppMethodBeat.i(114202);
            if (instance == null) {
                instance = new PrefInfoCollector();
            }
            prefInfoCollector = instance;
            AppMethodBeat.o(114202);
        }
        return prefInfoCollector;
    }

    @Override // com.tencent.qqmusic.mediaplayer.perf.PlayerInfoCollector
    public void putInt(String str, int i2) {
    }

    @Override // com.tencent.qqmusic.mediaplayer.perf.PlayerInfoCollector
    public void putLong(String str, long j2) {
        AppMethodBeat.i(114203);
        this.prefInfos.put(str, Long.valueOf(j2));
        AppMethodBeat.o(114203);
    }

    @Override // com.tencent.qqmusic.mediaplayer.perf.PlayerInfoCollector
    public void putBoolean(String str, boolean z) {
    }

    @Override // com.tencent.qqmusic.mediaplayer.perf.PlayerInfoCollector
    public void putString(String str, String str2) {
    }

    @Override // com.tencent.qqmusic.mediaplayer.perf.PlayerInfoCollector
    public void putUri(String str, Uri uri) {
    }

    private void createOutputs() {
        AppMethodBeat.i(114204);
        try {
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), FILE_NAME);
            if (file.exists()) {
                file.delete();
                file.createNewFile();
            }
            Logger.d(TAG, "setInstrumentation: outputFile: ".concat(String.valueOf(file)));
            this.reportFilePath = file.getAbsolutePath();
            this.outputStream = new FileOutputStream(file);
            Logger.d(TAG, "setInstrumentation: outputFilepath: " + this.reportFilePath);
            try {
                this.xmlSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
                this.xmlSerializer.setOutput(this.outputStream, "utf-8");
                this.xmlSerializer.startDocument("utf-8", Boolean.TRUE);
                AppMethodBeat.o(114204);
            } catch (IOException e2) {
                Logger.e(TAG, "Unable to open serializer", e2);
                RuntimeException runtimeException = new RuntimeException("Unable to open serializer: " + e2.getMessage(), e2);
                AppMethodBeat.o(114204);
                throw runtimeException;
            }
        } catch (FileNotFoundException e3) {
            Logger.e(TAG, "Unable to open report file: pref_infos.xml", e3);
            RuntimeException runtimeException2 = new RuntimeException("Unable to open report file: " + e3.getMessage(), e3);
            AppMethodBeat.o(114204);
            throw runtimeException2;
        } catch (IOException e4) {
            Logger.e(TAG, "Unable to create report file: pref_infos.xml", e4);
            RuntimeException runtimeException3 = new RuntimeException("Unable to create report file: " + e4.getMessage(), e4);
            AppMethodBeat.o(114204);
            throw runtimeException3;
        }
    }

    public void printAudioInfomation(AudioInformation audioInformation) {
        AppMethodBeat.i(114205);
        printProperty("audio.format", new StringBuilder().append(audioInformation.getAudioType()).toString());
        printProperty("audio.sampleRate", new StringBuilder().append(audioInformation.getSampleRate()).toString());
        printProperty("audio.PlaySample", new StringBuilder().append(audioInformation.getPlaySample()).toString());
        printProperty("audio.bitDepth", new StringBuilder().append(audioInformation.getBitDepth()).toString());
        printProperty("audio.channels", new StringBuilder().append(audioInformation.getChannels()).toString());
        printProperty("audio.duration", new StringBuilder().append(audioInformation.getDuration()).toString());
        printProperty("audio.bitRate", new StringBuilder().append(audioInformation.getBitrate()).toString());
        AppMethodBeat.o(114205);
    }

    private void printProperty(String str, String str2) {
        AppMethodBeat.i(114206);
        this.xmlSerializer.startTag(NAMESPACE, str);
        this.xmlSerializer.text(str2);
        this.xmlSerializer.endTag(NAMESPACE, str);
        AppMethodBeat.o(114206);
    }

    private void printPrefInfos(AudioInformation audioInformation) {
        AppMethodBeat.i(114207);
        ArrayList<Map.Entry> arrayList = new ArrayList(this.prefInfos.entrySet());
        Collections.sort(arrayList, new Comparator<Map.Entry<String, Long>>() {
            /* class com.tencent.qqmusic.mediaplayer.perf.PrefInfoCollector.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public /* bridge */ /* synthetic */ int compare(Map.Entry<String, Long> entry, Map.Entry<String, Long> entry2) {
                AppMethodBeat.i(114196);
                int compare = compare(entry, entry2);
                AppMethodBeat.o(114196);
                return compare;
            }

            public int compare(Map.Entry<String, Long> entry, Map.Entry<String, Long> entry2) {
                AppMethodBeat.i(114195);
                if (entry.getKey().charAt(0) > entry2.getKey().charAt(0)) {
                    AppMethodBeat.o(114195);
                    return 1;
                } else if (entry.getKey().charAt(0) == entry2.getKey().charAt(0)) {
                    AppMethodBeat.o(114195);
                    return 0;
                } else {
                    AppMethodBeat.o(114195);
                    return -1;
                }
            }
        });
        if (!arrayList.isEmpty()) {
            this.xmlSerializer.startTag(NAMESPACE, ROOT);
            printProperty("device.manufacturer", Build.MANUFACTURER);
            printProperty("device.model", Build.MODEL);
            printProperty("device.apiLevel", String.valueOf(Build.VERSION.SDK_INT));
            printAudioInfomation(audioInformation);
            for (Map.Entry entry : arrayList) {
                printProperty((String) entry.getKey(), String.valueOf(((Long) entry.getValue()).longValue()));
            }
            this.xmlSerializer.endTag(NAMESPACE, ROOT);
            this.xmlSerializer.endDocument();
            this.xmlSerializer.flush();
        }
        AppMethodBeat.o(114207);
    }

    private void upLoadByCommonPost() {
        AppMethodBeat.i(114208);
        Logger.i(TAG, "upLoadByCommonPost");
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(" http://musict.proxy.music.qq.com/qmtm2/PlayPerformanceReport.fcg").openConnection();
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
        httpURLConnection.setRequestProperty("Charset", MimeTypeUtil.ContentType.DEFAULT_CHARSET);
        httpURLConnection.setRequestProperty("Content-Type", "text/xml");
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        FileInputStream fileInputStream = new FileInputStream(this.reportFilePath);
        byte[] bArr = new byte[8192];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read != -1) {
                dataOutputStream.write(bArr, 0, read);
            } else {
                fileInputStream.close();
                dataOutputStream.writeBytes(APLogFileUtil.SEPARATOR_LINE);
                dataOutputStream.flush();
                InputStream inputStream = httpURLConnection.getInputStream();
                Logger.i(TAG, "upload result:".concat(String.valueOf(new BufferedReader(new InputStreamReader(inputStream, MimeTypeUtil.ContentType.DEFAULT_CHARSET)).readLine())));
                dataOutputStream.close();
                inputStream.close();
                AppMethodBeat.o(114208);
                return;
            }
        }
    }

    public void upLoadPrefInfos(final AudioInformation audioInformation) {
        AppMethodBeat.i(114209);
        if (this.prefInfos == null || this.prefInfos.isEmpty()) {
            AppMethodBeat.o(114209);
            return;
        }
        if (this.mHandlerThread == null || this.mReportHandler == null) {
            this.mHandlerThread = new HandlerThread("PrefInfoCollector");
            this.mHandlerThread.start();
            this.mReportHandler = new Handler(this.mHandlerThread.getLooper());
        }
        this.mReportHandler.post(new Runnable() {
            /* class com.tencent.qqmusic.mediaplayer.perf.PrefInfoCollector.AnonymousClass2 */

            public void run() {
                AppMethodBeat.i(114185);
                try {
                    PrefInfoCollector.access$000(PrefInfoCollector.this);
                    PrefInfoCollector.access$100(PrefInfoCollector.this, audioInformation);
                    PrefInfoCollector.access$200(PrefInfoCollector.this);
                    AppMethodBeat.o(114185);
                } catch (Exception e2) {
                    Logger.e(PrefInfoCollector.TAG, e2);
                    AppMethodBeat.o(114185);
                }
            }
        });
        AppMethodBeat.o(114209);
    }
}
