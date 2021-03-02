package org.xwalk.core.extension;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xwalk.core.Log;

public class MessageInfo {
    private String TAG = "MessageInfo";
    private JSONArray mArgs;
    private ByteBuffer mBinaryArgs;
    private String mCallbackId;
    private String mCmd;
    private XWalkExternalExtension mExtension;
    private int mInstanceId;
    private String mJsName;
    private String mObjectId;

    private int AlignedWith4Bytes(int i2) {
        return (4 - (i2 % 4)) + i2;
    }

    public MessageInfo(MessageInfo messageInfo) {
        this.mExtension = messageInfo.mExtension;
        this.mInstanceId = messageInfo.mInstanceId;
        this.mJsName = messageInfo.mJsName;
        this.mCallbackId = messageInfo.mCallbackId;
        this.mObjectId = messageInfo.mObjectId;
        this.mArgs = messageInfo.mArgs;
        this.mCmd = messageInfo.mCmd;
    }

    public MessageInfo(XWalkExternalExtension xWalkExternalExtension, int i2, String str) {
        AppMethodBeat.i(155246);
        this.mExtension = xWalkExternalExtension;
        this.mInstanceId = i2;
        if (str.trim().charAt(0) == '[') {
            try {
                this.mArgs = new JSONArray(str);
                this.mCmd = "invokeNative";
                this.mJsName = this.mArgs.getString(0);
                this.mCallbackId = this.mArgs.getString(1);
                this.mObjectId = this.mArgs.getString(2);
                if (Build.VERSION.SDK_INT >= 19) {
                    this.mArgs.remove(0);
                    this.mArgs.remove(0);
                    this.mArgs.remove(0);
                }
                AppMethodBeat.o(155246);
            } catch (JSONException e2) {
                Log.e(this.TAG, e2.toString());
                AppMethodBeat.o(155246);
            }
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("cmd");
                int i3 = jSONObject.getInt("objectId");
                this.mCmd = string;
                this.mObjectId = Integer.toString(i3);
                this.mCallbackId = Integer.toString(0);
                String string2 = jSONObject.getString("type");
                this.mArgs = new JSONArray();
                if (string2.equals(JsStubGenerator.MSG_TO_EXTENSION)) {
                    this.mArgs = jSONObject.getJSONArray("args");
                    this.mJsName = jSONObject.getString("name");
                    if (this.mCmd.equals("newInstance")) {
                        this.mObjectId = this.mArgs.getString(0);
                        this.mArgs = this.mArgs.getJSONArray(1);
                        AppMethodBeat.o(155246);
                        return;
                    }
                } else {
                    this.mJsName = string2;
                    this.mArgs.put(0, jSONObject.getString("name"));
                    this.mArgs.put(1, jSONObject.getJSONArray("args"));
                }
                AppMethodBeat.o(155246);
            } catch (JSONException e3) {
                Log.e(this.TAG, e3.toString());
                AppMethodBeat.o(155246);
            }
        }
    }

    public MessageInfo(XWalkExternalExtension xWalkExternalExtension, int i2, byte[] bArr) {
        AppMethodBeat.i(155247);
        this.mExtension = xWalkExternalExtension;
        this.mInstanceId = i2;
        this.mCmd = "invokeNative";
        try {
            this.mArgs = null;
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            if (wrap.order() != ByteOrder.LITTLE_ENDIAN) {
                wrap.order(ByteOrder.LITTLE_ENDIAN);
            }
            int position = wrap.position();
            int i3 = wrap.getInt(position);
            int AlignedWith4Bytes = AlignedWith4Bytes(i3);
            int i4 = position + 4;
            this.mJsName = new String(bArr, i4, i3);
            int i5 = i4 + AlignedWith4Bytes;
            this.mCallbackId = Integer.toString(wrap.getInt(i5));
            int i6 = i5 + 4;
            int i7 = wrap.getInt(i6);
            int AlignedWith4Bytes2 = AlignedWith4Bytes(i7);
            int i8 = i6 + 4;
            this.mObjectId = new String(bArr, i8, i7);
            int i9 = i8 + AlignedWith4Bytes2;
            this.mBinaryArgs = ByteBuffer.wrap(bArr, i9, bArr.length - i9);
            AppMethodBeat.o(155247);
        } catch (IndexOutOfBoundsException e2) {
            Log.e(this.TAG, e2.toString());
            AppMethodBeat.o(155247);
        } catch (NullPointerException e3) {
            Log.e(this.TAG, e3.toString());
            AppMethodBeat.o(155247);
        }
    }

    public String getJsName() {
        return this.mJsName;
    }

    public void setJsName(String str) {
        this.mJsName = str;
    }

    public JSONArray getArgs() {
        return this.mArgs;
    }

    public void setArgs(JSONArray jSONArray) {
        this.mArgs = jSONArray;
    }

    public ByteBuffer getBinaryArgs() {
        return this.mBinaryArgs;
    }

    public void setBinaryArgs(ByteBuffer byteBuffer) {
        this.mBinaryArgs = byteBuffer;
    }

    public String getObjectId() {
        return this.mObjectId;
    }

    public void setObjectId(String str) {
        this.mObjectId = str;
    }

    public String getCallbackId() {
        return this.mCallbackId;
    }

    public void setCallbackId(String str) {
        this.mCallbackId = str;
    }

    public String getCmd() {
        return this.mCmd;
    }

    public void postResult(JSONArray jSONArray) {
        AppMethodBeat.i(155248);
        try {
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(0, this.mCallbackId);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                jSONArray2.put(i2 + 1, jSONArray.get(i2));
            }
            Log.w(this.TAG, "postResult: " + jSONArray2.toString());
            this.mExtension.postMessage(this.mInstanceId, jSONArray2.toString());
            AppMethodBeat.o(155248);
        } catch (JSONException e2) {
            Log.e(this.TAG, e2.toString());
            AppMethodBeat.o(155248);
        }
    }

    public XWalkExternalExtension getExtension() {
        return this.mExtension;
    }

    public int getInstanceId() {
        return this.mInstanceId;
    }

    public ExtensionInstanceHelper getInstanceHelper() {
        AppMethodBeat.i(155249);
        ExtensionInstanceHelper instanceHelper = this.mExtension.getInstanceHelper(this.mInstanceId);
        AppMethodBeat.o(155249);
        return instanceHelper;
    }

    public void postResult(byte[] bArr) {
        AppMethodBeat.i(155250);
        this.mExtension.postBinaryMessage(this.mInstanceId, bArr);
        AppMethodBeat.o(155250);
    }
}
