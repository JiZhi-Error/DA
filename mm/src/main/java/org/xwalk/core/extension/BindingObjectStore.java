package org.xwalk.core.extension;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.xwalk.core.Log;

public class BindingObjectStore {
    private String TAG = "BindingObjectStore";
    private Map<String, BindingObject> mBindingObjects = new HashMap();
    private ExtensionInstanceHelper mInstance;

    public BindingObjectStore(MessageHandler messageHandler, ExtensionInstanceHelper extensionInstanceHelper) {
        AppMethodBeat.i(155197);
        this.mInstance = extensionInstanceHelper;
        messageHandler.register("JSObjectCollected", "onJSObjectCollected", this);
        messageHandler.register(JsStubGenerator.MSG_TO_OBJECT, "onPostMessageToObject", this);
        messageHandler.register(JsStubGenerator.MSG_TO_CLASS, "onPostMessageToClass", this);
        AppMethodBeat.o(155197);
    }

    public boolean addBindingObject(String str, BindingObject bindingObject) {
        AppMethodBeat.i(155198);
        if (this.mBindingObjects.containsKey(str)) {
            Log.w(this.TAG, "Existing binding object:\n".concat(String.valueOf(str)));
            AppMethodBeat.o(155198);
            return false;
        }
        bindingObject.initBindingInfo(str, this.mInstance);
        this.mBindingObjects.put(str, bindingObject);
        bindingObject.onJsBound();
        AppMethodBeat.o(155198);
        return true;
    }

    public BindingObject getBindingObject(String str) {
        AppMethodBeat.i(155199);
        BindingObject bindingObject = this.mBindingObjects.get(str);
        AppMethodBeat.o(155199);
        return bindingObject;
    }

    public BindingObject removeBindingObject(String str) {
        AppMethodBeat.i(155200);
        BindingObject remove = this.mBindingObjects.remove(str);
        if (remove != null) {
            remove.onJsDestroyed();
        }
        AppMethodBeat.o(155200);
        return remove;
    }

    public void onJSObjectCollected(MessageInfo messageInfo) {
        AppMethodBeat.i(155201);
        removeBindingObject(messageInfo.getObjectId());
        AppMethodBeat.o(155201);
    }

    public Object onPostMessageToClass(MessageInfo messageInfo) {
        Object obj = null;
        AppMethodBeat.i(155202);
        JSONArray args = messageInfo.getArgs();
        try {
            MessageInfo messageInfo2 = new MessageInfo(messageInfo);
            String string = args.getString(0);
            JSONArray jSONArray = args.getJSONArray(1);
            String string2 = jSONArray.getString(0);
            JSONArray jSONArray2 = jSONArray.getJSONArray(1);
            messageInfo2.setJsName(string);
            messageInfo2.setArgs(jSONArray2);
            obj = messageInfo.getExtension().getTargetReflect(string2).handleMessage(messageInfo2, null);
        } catch (JSONException e2) {
            Log.e(this.TAG, e2.toString());
        } catch (Exception e3) {
            Log.e(this.TAG, e3.toString());
        }
        AppMethodBeat.o(155202);
        return obj;
    }

    public Object onPostMessageToObject(MessageInfo messageInfo) {
        AppMethodBeat.i(155203);
        Object obj = null;
        try {
            BindingObject bindingObject = getBindingObject(messageInfo.getObjectId());
            MessageInfo messageInfo2 = new MessageInfo(messageInfo);
            if (messageInfo.getArgs() != null) {
                JSONArray args = messageInfo.getArgs();
                String string = args.getString(0);
                JSONArray jSONArray = args.getJSONArray(1);
                messageInfo2.setJsName(string);
                messageInfo2.setArgs(jSONArray);
            } else {
                ByteBuffer binaryArgs = messageInfo.getBinaryArgs();
                binaryArgs.order(ByteOrder.LITTLE_ENDIAN);
                int position = binaryArgs.position();
                int i2 = binaryArgs.getInt(position);
                int i3 = position + 4;
                String str = new String(binaryArgs.array(), i3, i2);
                int i4 = i3 + (4 - (i2 % 4)) + i2;
                ByteBuffer wrap = ByteBuffer.wrap(binaryArgs.array(), i4, binaryArgs.array().length - i4);
                messageInfo2.setJsName(str);
                messageInfo2.setBinaryArgs(wrap);
            }
            if (bindingObject != null) {
                obj = bindingObject.handleMessage(messageInfo2);
            }
        } catch (IndexOutOfBoundsException | NullPointerException | JSONException e2) {
            Log.e(this.TAG, e2.toString());
        }
        AppMethodBeat.o(155203);
        return obj;
    }

    public void onStart() {
        AppMethodBeat.i(155204);
        for (Map.Entry<String, BindingObject> entry : this.mBindingObjects.entrySet()) {
            entry.getValue().onStart();
        }
        AppMethodBeat.o(155204);
    }

    public void onResume() {
        AppMethodBeat.i(155205);
        for (Map.Entry<String, BindingObject> entry : this.mBindingObjects.entrySet()) {
            entry.getValue().onResume();
        }
        AppMethodBeat.o(155205);
    }

    public void onPause() {
        AppMethodBeat.i(155206);
        for (Map.Entry<String, BindingObject> entry : this.mBindingObjects.entrySet()) {
            entry.getValue().onPause();
        }
        AppMethodBeat.o(155206);
    }

    public void onStop() {
        AppMethodBeat.i(155207);
        for (Map.Entry<String, BindingObject> entry : this.mBindingObjects.entrySet()) {
            entry.getValue().onStop();
        }
        AppMethodBeat.o(155207);
    }

    public void onDestroy() {
        AppMethodBeat.i(155208);
        for (Map.Entry<String, BindingObject> entry : this.mBindingObjects.entrySet()) {
            entry.getValue().onDestroy();
        }
        AppMethodBeat.o(155208);
    }
}
