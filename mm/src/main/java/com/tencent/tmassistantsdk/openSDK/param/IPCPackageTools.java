package com.tencent.tmassistantsdk.openSDK.param;

import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.openSDK.param.jce.IPCCmd;
import com.tencent.tmassistantsdk.openSDK.param.jce.IPCHead;
import com.tencent.tmassistantsdk.openSDK.param.jce.IPCRequest;
import com.tencent.tmassistantsdk.openSDK.param.jce.IPCResponse;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.tmassistantsdk.util.GlobalUtil;

public class IPCPackageTools {
    protected static final String CHILD_NAME = ".jce.";
    static final String CRYPT_KEY = "ji*9^&43U0X-~./(";
    private static final String TAG = "IPCPackageTools";
    protected static int mReqId = 0;

    public static int getCmdId(JceStruct jceStruct) {
        AppMethodBeat.i(102217);
        if (jceStruct == null) {
            AppMethodBeat.o(102217);
            return -1;
        }
        String simpleName = jceStruct.getClass().getSimpleName();
        int value = IPCCmd.convert(simpleName.substring(0, simpleName.length() - 7)).value();
        AppMethodBeat.o(102217);
        return value;
    }

    public static IPCRequest buildIpcRequest(JceStruct jceStruct) {
        AppMethodBeat.i(102218);
        if (jceStruct == null) {
            AppMethodBeat.o(102218);
            return null;
        }
        IPCRequest iPCRequest = new IPCRequest();
        IPCHead iPCHead = new IPCHead();
        int i2 = mReqId;
        mReqId = i2 + 1;
        iPCHead.requestId = i2;
        iPCHead.cmdId = getCmdId(jceStruct);
        iPCHead.hostPackageName = GlobalUtil.getAppPackageName(GlobalUtil.getInstance().getContext());
        iPCHead.hostVersionCode = String.valueOf(GlobalUtil.getAppVersionCode(GlobalUtil.getInstance().getContext()));
        iPCRequest.head = iPCHead;
        iPCRequest.body = jceStruct2ByteArray(jceStruct);
        AppMethodBeat.o(102218);
        return iPCRequest;
    }

    public static byte[] buildPostData(IPCRequest iPCRequest) {
        AppMethodBeat.i(102219);
        if (iPCRequest == null) {
            AppMethodBeat.o(102219);
            return null;
        }
        iPCRequest.body = ProtocolPackage.encrypt(iPCRequest.body, CRYPT_KEY.getBytes());
        byte[] jceStruct2ByteArray = jceStruct2ByteArray(iPCRequest);
        AppMethodBeat.o(102219);
        return jceStruct2ByteArray;
    }

    public static IPCResponse unpackPackage(byte[] bArr) {
        AppMethodBeat.i(102220);
        if (bArr == null || bArr.length < 4) {
            AppMethodBeat.o(102220);
            return null;
        }
        IPCResponse iPCResponse = new IPCResponse();
        try {
            JceInputStream jceInputStream = new JceInputStream(bArr);
            jceInputStream.setServerEncoding(ProtocolPackage.ServerEncoding);
            iPCResponse.readFrom(jceInputStream);
            if (!TextUtils.isEmpty(iPCResponse.head.hostPackageName)) {
                iPCResponse.body = ProtocolPackage.decrypt(iPCResponse.body, CRYPT_KEY.getBytes());
            }
            AppMethodBeat.o(102220);
            return iPCResponse;
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(102220);
            return null;
        }
    }

    public static JceStruct unpackBodyStruct(IPCResponse iPCResponse) {
        AppMethodBeat.i(102221);
        JceStruct createFromRequest = createFromRequest(IPCCmd.convert(iPCResponse.head.cmdId).toString());
        if (createFromRequest == null || iPCResponse.body.length <= 0) {
            AppMethodBeat.o(102221);
            return null;
        }
        try {
            JceInputStream jceInputStream = new JceInputStream(iPCResponse.body);
            jceInputStream.setServerEncoding(ProtocolPackage.ServerEncoding);
            createFromRequest.readFrom(jceInputStream);
            AppMethodBeat.o(102221);
            return createFromRequest;
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(102221);
            return null;
        }
    }

    private static JceStruct createFromRequest(String str) {
        JceStruct jceStruct;
        AppMethodBeat.i(102222);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(102222);
            return null;
        }
        try {
            jceStruct = (JceStruct) Class.forName((IPCPackageTools.class.getPackage().getName() + CHILD_NAME + str) + "Response").newInstance();
        } catch (ClassNotFoundException e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            jceStruct = null;
        } catch (IllegalAccessException e3) {
            Log.printErrStackTrace(TAG, e3, "", new Object[0]);
            jceStruct = null;
        } catch (InstantiationException e4) {
            Log.printErrStackTrace(TAG, e4, "", new Object[0]);
            jceStruct = null;
        }
        AppMethodBeat.o(102222);
        return jceStruct;
    }

    public static byte[] jceStruct2ByteArray(JceStruct jceStruct) {
        AppMethodBeat.i(102223);
        byte[] jceStructToUTF8Byte = ProtocolPackage.jceStructToUTF8Byte(jceStruct);
        AppMethodBeat.o(102223);
        return jceStructToUTF8Byte;
    }
}
