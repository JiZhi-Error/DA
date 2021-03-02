package com.tencent.tmassistantsdk.protocol;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.protocol.jce.ReportLogRequest;
import com.tencent.tmassistantsdk.protocol.jce.ReqHead;
import com.tencent.tmassistantsdk.protocol.jce.Request;
import com.tencent.tmassistantsdk.protocol.jce.Response;
import com.tencent.tmassistantsdk.protocol.jce.Terminal;
import com.tencent.tmassistantsdk.util.Cryptor;
import com.tencent.tmassistantsdk.util.GlobalUtil;
import java.util.List;

public class ProtocolPackage {
    static final String CRYPT_KEY = "ji*9^&43U0X-~./(";
    static final byte FLAG_CRYPT = 2;
    static final byte FLAG_ZIP = 1;
    public static final String ServerEncoding = "utf-8";
    private static final String TAG = "ProtocolPackage";
    static final int ZIP_TRIGGER = 256;

    public static JceStruct buildReportRequest(byte b2, List<byte[]> list, String str, int i2, String str2) {
        AppMethodBeat.i(102260);
        ReportLogRequest reportLogRequest = new ReportLogRequest();
        reportLogRequest.logType = b2;
        reportLogRequest.logData = formatLogData(list);
        reportLogRequest.hostAppPackageName = str;
        reportLogRequest.hostAppVersion = i2;
        reportLogRequest.hostUserId = str2;
        AppMethodBeat.o(102260);
        return reportLogRequest;
    }

    public static ReqHead getReqHead(JceStruct jceStruct) {
        AppMethodBeat.i(102261);
        if (jceStruct == null) {
            AppMethodBeat.o(102261);
            return null;
        }
        ReqHead reqHead = new ReqHead();
        reqHead.requestId = GlobalUtil.getMemUUID();
        String simpleName = jceStruct.getClass().getSimpleName();
        reqHead.cmdId = GlobalUtil.getInstance().getJceCmdIdByClassName(simpleName.substring(0, simpleName.length() - 7));
        reqHead.qua = GlobalUtil.getInstance().mQUA;
        reqHead.phoneGuid = GlobalUtil.getInstance().getPhoneGuid();
        reqHead.terminal = new Terminal();
        reqHead.assistantAPILevel = GlobalUtil.getInstance().getQQDownloaderAPILevel();
        reqHead.assistantVersionCode = GlobalUtil.getInstance().getQQDownloaderVersionCode();
        AppMethodBeat.o(102261);
        return reqHead;
    }

    public static Request buildRequest(JceStruct jceStruct) {
        AppMethodBeat.i(102262);
        if (jceStruct == null) {
            AppMethodBeat.o(102262);
            return null;
        }
        Request request = new Request();
        request.head = getReqHead(jceStruct);
        request.body = jceStructToUTF8Byte(jceStruct);
        AppMethodBeat.o(102262);
        return request;
    }

    public static byte[] buildPostData(Request request) {
        AppMethodBeat.i(102263);
        if (request == null) {
            AppMethodBeat.o(102263);
            return null;
        }
        request.head.encryptWithPack = 0;
        if (request.body.length > 256) {
            request.body = ZipUtils.zip(request.body);
            request.head.encryptWithPack = (byte) (request.head.encryptWithPack | 1);
        }
        request.body = encrypt(request.body, CRYPT_KEY.getBytes());
        request.head.encryptWithPack = (byte) (request.head.encryptWithPack | 2);
        byte[] jceStructToUTF8Byte = jceStructToUTF8Byte(request);
        AppMethodBeat.o(102263);
        return jceStructToUTF8Byte;
    }

    public static Response unpackPackage(byte[] bArr) {
        AppMethodBeat.i(102264);
        if (bArr == null || bArr.length < 4) {
            AppMethodBeat.o(102264);
            return null;
        }
        Response response = new Response();
        try {
            JceInputStream jceInputStream = new JceInputStream(bArr);
            jceInputStream.setServerEncoding(ServerEncoding);
            response.readFrom(jceInputStream);
            if (response.head.ret == 0) {
                if ((response.head.encryptWithPack & 2) == 2) {
                    response.body = decrypt(response.body, CRYPT_KEY.getBytes());
                }
                if ((response.head.encryptWithPack & 1) == 1) {
                    response.body = ZipUtils.unzip(response.body);
                }
                GlobalUtil.getInstance().setPhoneGuid(response.head.phoneGuid);
            }
            AppMethodBeat.o(102264);
            return response;
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(102264);
            return null;
        }
    }

    public static JceStruct unpageageJceResponse(JceStruct jceStruct, byte[] bArr) {
        JceStruct createFromRequest;
        AppMethodBeat.i(102265);
        if (jceStruct == null || bArr == null || (createFromRequest = createFromRequest(jceStruct)) == null) {
            AppMethodBeat.o(102265);
            return null;
        }
        try {
            JceInputStream jceInputStream = new JceInputStream(bArr);
            jceInputStream.setServerEncoding(ServerEncoding);
            createFromRequest.readFrom(jceInputStream);
            AppMethodBeat.o(102265);
            return createFromRequest;
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(102265);
            return null;
        }
    }

    private static JceStruct createFromRequest(JceStruct jceStruct) {
        JceStruct jceStruct2;
        AppMethodBeat.i(102266);
        if (jceStruct == null) {
            AppMethodBeat.o(102266);
            return null;
        }
        String name = jceStruct.getClass().getName();
        try {
            jceStruct2 = (JceStruct) Class.forName(name.substring(0, name.length() - 7) + "Response").newInstance();
        } catch (ClassNotFoundException e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            jceStruct2 = null;
        } catch (IllegalAccessException e3) {
            Log.printErrStackTrace(TAG, e3, "", new Object[0]);
            jceStruct2 = null;
        } catch (InstantiationException e4) {
            Log.printErrStackTrace(TAG, e4, "", new Object[0]);
            jceStruct2 = null;
        }
        AppMethodBeat.o(102266);
        return jceStruct2;
    }

    public static byte[] jceStructToUTF8Byte(JceStruct jceStruct) {
        AppMethodBeat.i(102267);
        if (jceStruct == null) {
            AppMethodBeat.o(102267);
            return null;
        }
        JceOutputStream jceOutputStream = new JceOutputStream();
        jceOutputStream.setServerEncoding(ServerEncoding);
        jceStruct.writeTo(jceOutputStream);
        byte[] byteArray = jceOutputStream.toByteArray();
        AppMethodBeat.o(102267);
        return byteArray;
    }

    public static JceStruct bytes2JceObj(byte[] bArr, Class<? extends JceStruct> cls) {
        AppMethodBeat.i(102268);
        if (bArr == null) {
            AppMethodBeat.o(102268);
            return null;
        }
        try {
            JceInputStream jceInputStream = new JceInputStream(bArr);
            jceInputStream.setServerEncoding(ServerEncoding);
            JceStruct jceStruct = (JceStruct) cls.newInstance();
            jceStruct.readFrom(jceInputStream);
            AppMethodBeat.o(102268);
            return jceStruct;
        } catch (Exception e2) {
            AppMethodBeat.o(102268);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0039 A[SYNTHETIC, Splitter:B:15:0x0039] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003e A[SYNTHETIC, Splitter:B:18:0x003e] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x008d A[SYNTHETIC, Splitter:B:38:0x008d] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0092 A[SYNTHETIC, Splitter:B:41:0x0092] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] formatLogData(java.util.List<byte[]> r9) {
        /*
        // Method dump skipped, instructions count: 193
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tmassistantsdk.protocol.ProtocolPackage.formatLogData(java.util.List):byte[]");
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2) {
        AppMethodBeat.i(102270);
        byte[] encrypt = new Cryptor().encrypt(bArr, bArr2);
        AppMethodBeat.o(102270);
        return encrypt;
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2) {
        AppMethodBeat.i(102271);
        byte[] decrypt = new Cryptor().decrypt(bArr, bArr2);
        AppMethodBeat.o(102271);
        return decrypt;
    }
}
