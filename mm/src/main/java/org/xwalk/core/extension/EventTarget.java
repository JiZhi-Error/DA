package org.xwalk.core.extension;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xwalk.core.Log;

public class EventTarget extends BindingObject {
    private String TAG = "EventTarget";
    private Map<String, MessageInfo> mEvents = new HashMap();

    public EventTarget() {
        AppMethodBeat.i(155209);
        this.mHandler.register("addEventListener", this);
        this.mHandler.register("removeEventListener", this);
        AppMethodBeat.o(155209);
    }

    public void startEvent(String str) {
    }

    public void stopEvent(String str) {
    }

    public boolean isEventActive(String str) {
        AppMethodBeat.i(155210);
        boolean containsKey = this.mEvents.containsKey(str);
        AppMethodBeat.o(155210);
        return containsKey;
    }

    public void dispatchEvent(String str) {
        AppMethodBeat.i(155211);
        dispatchEvent(str, null);
        AppMethodBeat.o(155211);
    }

    public void dispatchEvent(String str, JSONObject jSONObject) {
        AppMethodBeat.i(155212);
        try {
            if (!this.mEvents.containsKey(str)) {
                Log.w(this.TAG, "Attempt to dispatch to non-existing event :".concat(String.valueOf(str)));
                AppMethodBeat.o(155212);
                return;
            }
            MessageInfo messageInfo = this.mEvents.get(str);
            JSONArray jSONArray = new JSONArray();
            if (jSONObject != null) {
                jSONArray.put(0, jSONObject);
            }
            messageInfo.postResult(jSONArray);
            AppMethodBeat.o(155212);
        } catch (JSONException e2) {
            Log.e(this.TAG, e2.toString());
            AppMethodBeat.o(155212);
        }
    }

    public void onAddEventListener(MessageInfo messageInfo) {
        AppMethodBeat.i(155213);
        try {
            String string = messageInfo.getArgs().getString(0);
            if (this.mEvents.containsKey(string)) {
                Log.w(this.TAG, "Trying to re-add the event :".concat(String.valueOf(string)));
                AppMethodBeat.o(155213);
                return;
            }
            this.mEvents.put(string, messageInfo);
            startEvent(string);
            AppMethodBeat.o(155213);
        } catch (JSONException e2) {
            Log.e(this.TAG, e2.toString());
            AppMethodBeat.o(155213);
        }
    }

    public void onRemoveEventListener(MessageInfo messageInfo) {
        AppMethodBeat.i(155214);
        try {
            String string = messageInfo.getArgs().getString(0);
            if (!this.mEvents.containsKey(string)) {
                Log.w(this.TAG, "Attempt to remove non-existing event :".concat(String.valueOf(string)));
                AppMethodBeat.o(155214);
                return;
            }
            stopEvent(string);
            this.mEvents.remove(string);
            AppMethodBeat.o(155214);
        } catch (JSONException e2) {
            Log.e(this.TAG, e2.toString());
            AppMethodBeat.o(155214);
        }
    }
}
