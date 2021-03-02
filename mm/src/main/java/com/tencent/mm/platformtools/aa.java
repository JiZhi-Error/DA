package com.tencent.mm.platformtools;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.c;
import com.tencent.mm.b.g;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.vfs.s;
import com.tencent.tav.decoder.EncoderWriter;
import java.io.InputStream;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public final class aa {
    public static boolean a(final String str, final String str2, final boolean z, boolean z2, int i2, final int i3) {
        AppMethodBeat.i(224148);
        if (z2) {
            ThreadPool.post(new Runnable() {
                /* class com.tencent.mm.platformtools.aa.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(143769);
                    aa.a(str, str2, z, i3);
                    AppMethodBeat.o(143769);
                }
            }, "StackReportUploader_uploadFileDirect", i2);
            AppMethodBeat.o(224148);
            return true;
        }
        boolean a2 = a(str, str2, z, i3);
        AppMethodBeat.o(224148);
        return a2;
    }

    public static boolean a(String str, String str2, boolean z, boolean z2) {
        AppMethodBeat.i(143771);
        boolean a2 = a(str, str2, z, z2, 1, 20003);
        AppMethodBeat.o(143771);
        return a2;
    }

    static boolean a(String str, String str2, boolean z, int i2) {
        boolean a2;
        AppMethodBeat.i(143772);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
            Log.e("MicroMsg.StackReportUploader", "uploadFile param err file:%s  user:%s", str, str2);
            AppMethodBeat.o(143772);
            return false;
        }
        int boW = (int) s.boW(str);
        if (boW <= 0) {
            Log.e("MicroMsg.StackReportUploader", "uploadFile err len file:%s len:%d", str, Integer.valueOf(boW));
            AppMethodBeat.o(143772);
            return false;
        } else if (boW <= 128000) {
            byte[] aW = s.aW(str, 0, -1);
            boolean a3 = a(aW, str, str2, i2);
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(a3);
            objArr[1] = Integer.valueOf(aW != null ? aW.length : -1);
            objArr[2] = str;
            Log.d("MicroMsg.StackReportUploader", "uploadFile ret:%b size:%d file:%s", objArr);
            if (a3 && z) {
                s.dy(str, true);
            }
            AppMethodBeat.o(143772);
            return a3;
        } else {
            int i3 = (boW / 127988) + 1;
            byte[] bArr = new byte[EncoderWriter.OUTPUT_AUDIO_BIT_RATE];
            int nowMilliSecond = (int) Util.nowMilliSecond();
            InputStream inputStream = null;
            try {
                InputStream openRead = s.openRead(str);
                for (int i4 = 0; i4 < i3; i4++) {
                    int read = openRead.read(bArr, 12, 127988);
                    if (read < 0) {
                        Log.e("MicroMsg.StackReportUploader", "uploadFile read failed file:%s", str);
                        if (openRead != null) {
                            try {
                                openRead.close();
                            } catch (Exception e2) {
                            }
                        }
                        AppMethodBeat.o(143772);
                        return false;
                    }
                    d(nowMilliSecond, bArr, 0);
                    d(i4, bArr, 4);
                    d(read, bArr, 8);
                    if (read < 127988) {
                        byte[] bArr2 = new byte[(read + 12)];
                        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
                        a2 = a(bArr2, str, str2, i2);
                    } else {
                        a2 = a(bArr, str, str2, i2);
                    }
                    Log.d("MicroMsg.StackReportUploader", "uploadFile idx:%d(%d) read:%d ret:%b size:%d file:%s", Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(read), Boolean.valueOf(a2), Integer.valueOf(boW), str);
                }
                if (z) {
                    s.dy(str, true);
                }
                if (openRead != null) {
                    try {
                        openRead.close();
                    } catch (Exception e3) {
                    }
                }
                AppMethodBeat.o(143772);
                return true;
            } catch (Exception e4) {
                Log.e("MicroMsg.StackReportUploader", "exception:%s", Util.stackTraceToString(e4));
                Log.e("MicroMsg.StackReportUploader", "uploadFile read except file:%s", str);
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (Exception e5) {
                    }
                }
                AppMethodBeat.o(143772);
                return false;
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (Exception e6) {
                    }
                }
                AppMethodBeat.o(143772);
                throw th;
            }
        }
    }

    private static boolean d(int i2, byte[] bArr, int i3) {
        if (128000 < i3 + 4) {
            return false;
        }
        bArr[i3] = (byte) ((i2 >> 24) & 255);
        bArr[i3 + 1] = (byte) ((i2 >> 16) & 255);
        bArr[i3 + 2] = (byte) ((i2 >> 8) & 255);
        bArr[i3 + 3] = (byte) (i2 & 255);
        return true;
    }

    private static boolean a(byte[] bArr, String str, String str2, int i2) {
        AppMethodBeat.i(143773);
        if (Util.isNullOrNil(bArr)) {
            Log.e("MicroMsg.StackReportUploader", "read file failed:%s", str);
            AppMethodBeat.o(143773);
            return false;
        } else if (bArr.length > 128000) {
            Log.e("MicroMsg.StackReportUploader", "file :%s data len error:%d", str, Integer.valueOf(bArr.length));
            AppMethodBeat.o(143773);
            return false;
        } else {
            int length = bArr.length;
            String lowerCase = g.getMessageDigest(String.format("weixin#$()%d%d", Integer.valueOf(d.KyO), Integer.valueOf(length)).getBytes()).toLowerCase();
            byte[] compress = com.tencent.mm.b.s.compress(bArr);
            if (Util.isNullOrNil(compress)) {
                Log.e("MicroMsg.StackReportUploader", "zip data failed file:%s", str);
                AppMethodBeat.o(143773);
                return false;
            }
            PByteArray pByteArray = new PByteArray();
            c.a(pByteArray, compress, lowerCase.getBytes());
            byte[] bArr2 = pByteArray.value;
            if (Util.isNullOrNil(bArr2)) {
                Log.e("MicroMsg.StackReportUploader", "encrypt data failed file:%s", str);
            }
            SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", 0);
            StringBuilder sb = new StringBuilder(HttpWrapperBase.PROTOCAL_HTTPS);
            String str3 = com.tencent.mm.network.c.icB;
            String sb2 = sb.append(sharedPreferences.getString(str3, str3)).toString();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(sb2 + "/cgi-bin/mmsupport-bin/stackreport?version=");
            stringBuffer.append(Integer.toHexString(d.KyO));
            stringBuffer.append("&devicetype=");
            stringBuffer.append(d.ics);
            stringBuffer.append("&filelength=");
            stringBuffer.append(length);
            stringBuffer.append("&sum=");
            stringBuffer.append(lowerCase);
            stringBuffer.append("&reporttype=");
            stringBuffer.append(i2);
            stringBuffer.append("&reportvalue=");
            stringBuffer.append(Util.nowMilliSecond() + ".0.1");
            if (str2 != null && !str2.equals("")) {
                stringBuffer.append("&username=");
                stringBuffer.append(str2);
            }
            DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(stringBuffer.toString());
            try {
                ByteArrayEntity byteArrayEntity = new ByteArrayEntity(bArr2);
                byteArrayEntity.setContentType("binary/octet-stream");
                httpPost.setEntity(byteArrayEntity);
                HttpResponse execute = defaultHttpClient.execute(httpPost);
                if (execute == null || execute.getStatusLine() == null) {
                    Log.e("MicroMsg.StackReportUploader", "execute http failed resp null");
                    AppMethodBeat.o(143773);
                    return false;
                } else if (execute.getStatusLine().getStatusCode() != 200) {
                    Log.e("MicroMsg.StackReportUploader", "error response code:%d ", Integer.valueOf(execute.getStatusLine().getStatusCode()));
                    AppMethodBeat.o(143773);
                    return false;
                } else {
                    AppMethodBeat.o(143773);
                    return true;
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.StackReportUploader", "exception:%s", Util.stackTraceToString(e2));
                Log.d("MicroMsg.StackReportUploader", "execute post failed msg:%s", e2.getMessage());
                AppMethodBeat.o(143773);
                return false;
            }
        }
    }
}
